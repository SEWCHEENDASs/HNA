package com.johnnysayshiandroid.historynotesapplication;

import io.realm.RealmObject;

/**
 * Created by USER on 28/1/2018.
 */

public class InformationData extends RealmObject {
    private String id;
    private String subTopic;
    private String information;
    private String chapID;
    private String img;

    public InformationData(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubTopic() {
        return subTopic;
    }

    public void setSubTopic(String subTopic) {
        this.subTopic = subTopic;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getChapID() {
        return chapID;
    }

    public void setChapID(String chapID) {
        this.chapID = chapID;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
