package com.example.quizgame.model;

public class KeyGesture {
    public int keyCode;
    public long tp;
    public long ts;
    public String toString() {
        return "key:" + keyCode + " tp:" + tp + " ts:" + ts;
    }
}
