package com.example.diplom;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by kamal_bunkar on 20-01-2018.
 */

public class OnSwipeTouchListner implements View.OnTouchListener {

    private GestureDetector gestureDetector;

    public OnSwipeTouchListner(Context context){

        gestureDetector = new GestureDetector(context, new GestureListner());
    }                                                                    //   0, 0                 10 ,0     10 - 0 = 10   0-10 =-10

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }


    private class GestureListner extends GestureDetector.SimpleOnGestureListener{

        private static final int SWIPE_THRESHHOLD = 70;
        private static final int SWIPE_VELOCITY_THRESH = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            Boolean result = false;

            float diffx =  e2.getX()- e1.getX();
            float diffy = e2.getY() - e1.getY();

            if (Math.abs(diffx) > Math.abs(diffy)){

                if ( Math.abs(diffx) >SWIPE_THRESHHOLD  && Math.abs(velocityX  ) >SWIPE_VELOCITY_THRESH ){

                    if (diffx>0){
                        onSwapeRight();
                    }else {
                        onSwipeLeft();
                    }
                    result =true;

                }


            }else if (Math.abs(diffy)> SWIPE_THRESHHOLD && Math.abs(velocityY)>SWIPE_VELOCITY_THRESH){

                if (diffy>0){
                    onSwipeBottom();
                }else {
                    onSwipeTop();
                }
                result = true;

            }

            return result;
        }



    }

    public void onSwapeRight(){
        Log.e("swipe ", " swipte to right");
    }
    public void onSwipeLeft(){}

    public void onSwipeBottom(){}

    public void onSwipeTop(){}

}
