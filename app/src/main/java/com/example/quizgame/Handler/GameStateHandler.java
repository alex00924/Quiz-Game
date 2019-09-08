package com.example.quizgame.Handler;
import android.content.Context;
import android.content.SharedPreferences;
import com.example.quizgame.Application;

public class GameStateHandler {
    private static final GameStateHandler Instance = new GameStateHandler();
    public static GameStateHandler getInstance() {
        return Instance;
    }
    private SharedPreferences sharedpreferences;
    private GameStateHandler() {
        sharedpreferences = Application.getContext().getSharedPreferences("GameState", Context.MODE_PRIVATE);
    }
    public String getGameStete(String Key){
        return sharedpreferences.getString(Key, "");
    }
    public void setGameStete(String Key,String value){
        SharedPreferences.Editor mEditor = sharedpreferences.edit();
        if(sharedpreferences.contains(Key)){
            mEditor.remove(Key);
        }
        mEditor.putString(Key, value);
        mEditor.apply();
    }
    public boolean isKeyExist(String Key){
        return sharedpreferences.contains(Key);
    }
}
