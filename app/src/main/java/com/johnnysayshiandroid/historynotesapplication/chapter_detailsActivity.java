package com.johnnysayshiandroid.historynotesapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;

public class chapter_detailsActivity extends AppCompatActivity {

    TextView tvTitle;
    private Realm realm;
    Button btnTheory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_details);
        //String text = Intent.getIntentOld("test");

        Intent i = getIntent();
        final String chap = i.getStringExtra("chap");

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        btnTheory = (Button) findViewById(R.id.btnTheory);

        btnTheory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(chapter_detailsActivity.this, SubtopicDetailActivity.class);
                i.putExtra("chap", chap);
                startActivity(i);
            }
        });

        // Realm init
        Realm.init(this);
        // Get a Realm instance for this thread
        realm = Realm.getDefaultInstance();

        RealmResults<Chap> chaps1 = realm.where(Chap.class).equalTo("id", chap).findAll();
//        System.out.println("Test Display: " + chaps1.get(0).getTitle());
        tvTitle.setText(chaps1.get(0).getTitle());


    }
}
