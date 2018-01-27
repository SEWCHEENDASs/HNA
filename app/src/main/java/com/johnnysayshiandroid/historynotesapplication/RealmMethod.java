package com.johnnysayshiandroid.historynotesapplication;

import android.content.Context;

import io.realm.Realm;

/**
 * Created by USER on 28/1/2018.
 */

public class RealmMethod {
    private Realm realm;

    public void addChapData(Context context, String id, String title){
        Realm.init(context);
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Chap chap = realm.createObject(Chap.class);
        chap.setId(id);
        chap.setTitle(title);
        realm.commitTransaction();
    }

    public void addInfoData(Context context, String id, String subTopic, String information, String chapID, String img){
        Realm.init(context);
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        InformationData informationData = realm.createObject(InformationData.class);
        informationData.setId(id);
        informationData.setSubTopic(subTopic);
        informationData.setInformation(information);
        informationData.setChapID(chapID);
        informationData.setImg(img);
        realm.commitTransaction();
    }
}

