package com.example.diplom;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public abstract class MySwipeHelper extends ItemTouchHelper.SimpleCallback {
    int buttonWidth;
    private RecyclerView recyclerView;
    private List<MyButton> buttonList;
    private GestureDetector gestureDetector;
    private int swipePosition = -1;
    private float swipeThreashold = 0.5f;
    private Map<Integer, List<MyButton>> buttonBuffer;
    private Queue<Integer> removerQueue;
    private GestureDetector.SimpleOnGestureListener gestureListener = new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            for (MyButton button : buttonList) {
                if (button.onClick(e.getX(), e.getY()))
                    break;
            }
            return true;
        }
    };
    private View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (swipePosition < 0) return false;
            Point point = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            RecyclerView.ViewHolder swipeViewHolder = recyclerView.findViewHolderForAdapterPosition(swipePosition);
            View swipedItem = null;
            if(swipeViewHolder !=null) {
                swipedItem = swipeViewHolder.itemView;
                Rect rect = new Rect();
                swipedItem.getGlobalVisibleRect(rect);
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN ||
                        motionEvent.getAction() == MotionEvent.ACTION_UP ||
                        motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                    if (rect.top < point.y && rect.bottom > point.y)
                        gestureDetector.onTouchEvent(motionEvent);
                    else {
                        removerQueue.add(swipePosition);
                        swipePosition = -1;
                        recoverSwipedItem();
                    }
                }
            }
            return false;
        }
    };

    public MySwipeHelper(final Context context, RecyclerView recyclerView, int buttonWidth) {
        super(0, ItemTouchHelper.LEFT);
        this.recyclerView = recyclerView;
        this.buttonList = new ArrayList<>();
        this.gestureDetector = new GestureDetector(context, gestureListener);
        this.recyclerView.setOnTouchListener(onTouchListener);
        this.buttonBuffer = new HashMap<>();
        this.buttonWidth = buttonWidth;

        removerQueue = new LinkedList<Integer>() {
            @Override
            public boolean add(Integer integer) {
                if (contains(integer))
                    return false;
                else
                    return super.add(integer);
            }
        };
        attachSwipe();

    }

    private void attachSwipe() {
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(this);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    protected synchronized void recoverSwipedItem() {
        while (!removerQueue.isEmpty()) {
            int pos = removerQueue.poll();
            if (pos > -1)
                recyclerView.getAdapter().notifyItemChanged(pos);
        }
    }

    public class MyButton {
        private String text;
        private int imageResId, textsize, color, pos;
        private RectF clickRegion;
        private MyButtonClickListener listener;
        private Context context;
        private Resources resources;

        public MyButton(Context context, String text, int textsize, int imageResId, int color, MyButtonClickListener listener) {
            this.text = text;
            this.imageResId = imageResId;
            this.textsize = textsize;
            this.color = color;
            this.listener = listener;
            this.context = context;
            this.resources = context.getResources();
        }


        public boolean onClick(float x, float y) {
            if (clickRegion != null && clickRegion.contains(x, y)) {
                listener.onClick(pos);
                return true;
            }
            return false;
        }


        public void onDraw(Canvas c, RectF rectF, int pos) {
            Paint p = new Paint();
            p.setColor(color);
            c.drawRect(rectF, p);

            p.setColor(Color.WHITE);
            p.setTextSize(textsize);

            Rect r = new Rect();
            float cHeight = rectF.height();
            float cWidth = rectF.width();
            p.setTextAlign(Paint.Align.LEFT);

            p.getTextBounds(text, 0, text.length(), r);
            float x = 0, y = 0;
            if (imageResId == 0) {

                x = cWidth / 2f - r.width() / 2f - r.left;
                y = cHeight / 2f + r.height() / 2f - r.bottom;
                c.drawText(text, rectF.left + x, rectF.top + y, p);

            } else {
                Drawable d = ContextCompat.getDrawable(context, imageResId);
                Bitmap bitmap = drawableToBitmap(d);
                x = cWidth / 2f - r.width() / 2f - r.top * 4;
                y = cHeight / 2f + r.height() / 2f - r.bottom;
                c.drawBitmap(bitmap, rectF.left + x / 3, rectF.top + y / 3, p);
            }
            clickRegion = rectF;
            this.pos = pos;
        }
    }

    private Bitmap drawableToBitmap(Drawable d) {
        if (d instanceof BitmapDrawable)
            return ((BitmapDrawable) d).getBitmap();
        Bitmap bitmap = Bitmap.createBitmap(d.getIntrinsicWidth(),
                d.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        d.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());

        d.draw(canvas);
        return bitmap;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        int pos = viewHolder.getAdapterPosition();
        if (swipePosition != pos)
            removerQueue.add(swipePosition);
        swipePosition = pos;
        if (buttonBuffer.containsKey(swipePosition))
            buttonList = buttonBuffer.get(swipePosition);
        else
            buttonList.clear();
        buttonBuffer.clear();
        swipeThreashold = 0.5f * buttonList.size() * buttonWidth;
        recoverSwipedItem();
    }

    public float getSwipeThreashold(RecyclerView.ViewHolder viewHolder) {
        return swipeThreashold;
    }

    @Override
    public float getSwipeEscapeVelocity(float defaultValue) {
        return 0.1f * defaultValue;
    }

    @Override
    public float getSwipeVelocityThreshold(float defaultValue) {
        return 5.0f * defaultValue;
    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        int pos = viewHolder.getAdapterPosition();
        float traslationX = dX;
        View itemView = viewHolder.itemView;
        if (pos < 0) {
            swipePosition = pos;
            return;
        }
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            if (dX < 0) {
                List<MyButton> buffer = new ArrayList<>();
                if (!buttonBuffer.containsKey(pos)) {
                    instantiateMyButton(viewHolder, buffer);
                    buttonBuffer.put(pos, buffer);
                } else {
                    buffer = buttonBuffer.get(pos);

                }
                traslationX = dX * buffer.size() * buttonWidth / itemView.getWidth();
                drawButton(c, itemView, buffer, pos, traslationX);
            }
        }
        super.onChildDraw(c, recyclerView, viewHolder, traslationX, dY, actionState, isCurrentlyActive);
    }

    private void drawButton(Canvas c, View itemView, List<MyButton> buffer, int pos, float traslationX) {
        float right = itemView.getRight();
        float dButtonWidth = -1 * traslationX / buffer.size();
        for (MyButton button : buffer) {
            float left = right - dButtonWidth;
            button.onDraw(c, new RectF(left, itemView.getTop(), right, itemView.getBottom()), pos);
            right = left;
        }
    }

    public abstract void instantiateMyButton(RecyclerView.ViewHolder viewHolder, List<MyButton> buffer);
}

