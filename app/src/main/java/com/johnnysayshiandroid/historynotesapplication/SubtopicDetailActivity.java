package com.johnnysayshiandroid.historynotesapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class SubtopicDetailActivity extends AppCompatActivity {

    ListView lvListDetail;
    ArrayAdapter aa;
    ArrayList<String> alSubtopic = new ArrayList<String>();
    ArrayList<String> alIDInformation = new ArrayList<String>();
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtopic_detail);

        lvListDetail = (ListView) findViewById(R.id.lvListDetail);

        // Realm init
        Realm.init(this);
        // Get a Realm instance for this thread
        realm = Realm.getDefaultInstance();

        Intent i = getIntent();
        String chap = i.getStringExtra("chap");
        RealmResults<Chap> chaps = realm.where(Chap.class).equalTo("id", chap).findAll();
        setTitle(chaps.get(0).getTitle());

        RealmResults<InformationData> chaps1 = realm.where(InformationData.class).equalTo("chapID", chap).findAll();
        for(InformationData id : chaps1){
            alSubtopic.add(id.getSubTopic());
            alIDInformation.add(id.getId());
        }

        aa = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, alSubtopic){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                // Initialize a TextView for ListView each Item
                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                // Set the text color of TextView (ListView Item)
                tv.setTextColor(Color.WHITE);

                // Generate ListView Item using TextView
                return view;
            }
        };

        lvListDetail.setAdapter(aa);

        lvListDetail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(SubtopicDetailActivity.this, SubtopicInformationActivity.class);
                intent.putExtra("id", alIDInformation.get(i));
                startActivity(intent);
            }
        });
    }
}
