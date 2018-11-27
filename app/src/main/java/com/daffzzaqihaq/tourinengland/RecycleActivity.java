package com.daffzzaqihaq.tourinengland;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleActivity extends AppCompatActivity {

    @BindView(R.id.my_recycler_view)
    RecyclerView myRecyclerView;

    String[] namaTour,detailTour;
    int[] gambarTour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        ButterKnife.bind(this);


        namaTour = getResources().getStringArray(R.array.tourname);
        detailTour = getResources().getStringArray(R.array.tourdetail);
        gambarTour = new int[]{R.drawable.windsorcastle, R.drawable.bigben, R.drawable.lakedistric, R.drawable.toweroflondon, R.drawable.stonehege, R.drawable.thecots, R.drawable.warwickcastle, R.drawable.durhamcat, R.drawable.edenproject, R.drawable.yorkminster,R.drawable.piramidagiza, R.drawable.starbuck, R.drawable.arizona, R.drawable.apucalo, R.drawable.bali, R.drawable.tutan};

        SplashScreen.Adapter adapter = new SplashScreen.Adapter(RecycleActivity.this, gambarTour,namaTour,detailTour);

        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(RecycleActivity.this));
        myRecyclerView.setAdapter(adapter);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.action_myprofile:
                intent = new Intent(this, MyProfile.class);
                startActivity(intent);
                break;

            case R.id.action_airpaz:
                Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.traveloka.com/id/"));
                startActivity(implicit);
                break;

            case R.id.myweb:
                intent = new Intent(this,MoreTours.class);
                startActivity(intent);
                break;

            case R.id.call:
                String noTelp = "082246472002";
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+noTelp));
                startActivity(intent);


        }
        return super.onOptionsItemSelected(item);
    }
}



