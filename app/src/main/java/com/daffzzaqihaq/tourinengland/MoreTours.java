package com.daffzzaqihaq.tourinengland;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoreTours extends AppCompatActivity {

    @BindView(R.id.btnWorld)
    Button btnWorld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_tours);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btnWorld)
    public void onViewClicked() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.idntimes.com/travel/destination/rosma-stifani/10-objek-wisata-unik-berbagai-negara-bikin-takjub-c1c2"));
        startActivity(intent);
    }
}
