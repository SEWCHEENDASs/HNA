package com.johnnysayshiandroid.historynotesapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    ImageButton Btnchapter1;
    private Realm realm;
    private AddCsvToRealm csvToRealm = new AddCsvToRealm();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Realm init
        Realm.init(this);
        // Get a Realm instance for this thread
        realm = Realm.getDefaultInstance();

        //Get all chap inside this database
        RealmResults<Chap> chaps = realm.where(Chap.class).findAll();
        //Check the database is empty
        if(chaps.size() == 0){
            // isEmpty
            // Add all data to RealmDatabase
            csvToRealm.addToRealm(this);
        }

        Btnchapter1=findViewById(R.id.btnWW1);

        Btnchapter1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(MainActivity.this, chapter_detailsActivity.class);
                activityChangeIntent.putExtra("chap", "1");
                activityChangeIntent.putExtra("test", 0);
                startActivity(activityChangeIntent);

            }
        });
    }
}
