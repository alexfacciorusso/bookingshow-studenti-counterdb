package com.pascal.counterdb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getInstance(new RealmConfiguration.Builder(this).build());
        final GlobalData globalData;
        if (realm.where(GlobalData.class).count() == 0) {
            realm.beginTransaction();
            globalData = realm.createObject(GlobalData.class);
            realm.commitTransaction();
        } else {
            globalData = realm.where(GlobalData.class).findFirst();
        }

        final TextView textView = (TextView) findViewById(R.id.counter);
        textView.setText(String.valueOf(globalData.getCounter()));

        Button button = (Button) findViewById(R.id.incrementa_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.beginTransaction();
                globalData.incrementa();
                realm.commitTransaction();
                int actualCounter = globalData.getCounter();
                textView.setText(String.valueOf(actualCounter));
            }
        });
    }
}
