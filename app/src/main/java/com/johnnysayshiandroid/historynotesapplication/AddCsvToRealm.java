package com.johnnysayshiandroid.historynotesapplication;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by USER on 28/1/2018.
 */

public class AddCsvToRealm {
    private Context context;
    private RealmMethod ro = new RealmMethod();

    private void addChap(){
        try {
            InputStream inputStream = context.getAssets().open("chap.csv");
            CSVReader csv = new CSVReader(inputStream);
            List<String[]> list = csv.read();

            for(int i=0; i<list.size(); i++){
                ro.addChapData(context, list.get(i)[0], list.get(i)[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addSubtopic(){
        try {
            InputStream inputStream = context.getAssets().open("subtopic.csv");
            CSVReader csv = new CSVReader(inputStream);
            List<String[]> list = csv.read();

            for(int i=0; i<list.size(); i++){
                ro.addInfoData(context,list.get(i)[0],list.get(i)[1],list.get(i)[2],list.get(i)[3],list.get(i)[4]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addToRealm(Context c){
        this.context = c;
        addChap();
        addSubtopic();
    }
}
