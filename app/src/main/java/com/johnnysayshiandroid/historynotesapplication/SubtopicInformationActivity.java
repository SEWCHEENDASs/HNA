package com.johnnysayshiandroid.historynotesapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;

public class SubtopicInformationActivity extends AppCompatActivity {

    ImageView ivImg;
    TextView tvTitle;
    TextView tvInformation;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtopic_information);

        // Realm init
        Realm.init(this);
        // Get a Realm instance for this thread
        realm = Realm.getDefaultInstance();

        ivImg = (ImageView) findViewById(R.id.ivImg);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvInformation = (TextView) findViewById(R.id.tvInformation);

        Intent i = getIntent();
        String id = i.getStringExtra("id");
        RealmResults<Chap> chaps = realm.where(Chap.class).equalTo("id", id).findAll();
        setTitle(chaps.get(0).getTitle());
        RealmResults<InformationData> chaps1 = realm.where(InformationData.class).equalTo("id", id).findAll();

        Resources res = getResources();
        String imgName = chaps1.get(0).getImg();
        int resID = res.getIdentifier(imgName , "drawable", getPackageName());

        System.out.println("Checking: " + imgName);

        ivImg.setImageResource(resID);
        tvTitle.setText(chaps1.get(0).getSubTopic());
        tvInformation.setText(chaps1.get(0).getInformation());


    }
}
