package com.example.diplom;

public class Model {

    private String title;
    private  String  deck;

    public Model(String title, String deck) {
        this.title = title;
        this.deck = deck;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }
}
