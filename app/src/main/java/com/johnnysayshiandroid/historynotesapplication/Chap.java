package com.johnnysayshiandroid.historynotesapplication;

import io.realm.RealmObject;

/**
 * Created by USER on 28/1/2018.
 */

public class Chap extends RealmObject {
    private String id;
    private String title;

    public Chap(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String chap) {
        this.title = chap;
    }
}
