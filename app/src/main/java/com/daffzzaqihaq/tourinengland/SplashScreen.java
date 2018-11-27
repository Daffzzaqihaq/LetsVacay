package com.daffzzaqihaq.tourinengland;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SplashScreen extends AppCompatActivity {

    private long ms = 0;
    private long SplashTime = 3000;
    private boolean SplashActive = true;
    private boolean Paused = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        findViewById(R.id.progresbar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final ProgressBar progressBar = findViewById(R.id.progresbar);

        Thread mythread = new Thread() {
            public void run() {
                try {
                    while (SplashActive && ms <SplashTime) {
                        if(!Paused) {
                            ms = ms + 50;
                            sleep(50);
                            progressBar.setProgress((int)ms);
                        }
                    }

                }catch (Exception e) {
                }finally {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        mythread.start();
    }

    public static class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
        Context context;
        int[] gambarTour;
        String[] namaTour,detailTour;

        public Adapter(Context context,int[] gambarTour, String[] namaTour, String[] detailTour){
            this.context = context;
            this.gambarTour = gambarTour;
            this.namaTour = namaTour;
            this.detailTour = detailTour;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listtour, viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
            viewHolder.txtNama.setText(namaTour[i]);
            Glide.with(context).load(gambarTour[i]).into(viewHolder.imgLogo);

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent pindah = new Intent(context,DetailActivity.class);
                    pindah.putExtra("np",namaTour[i]);
                    pindah.putExtra("dp",detailTour[i]);
                    pindah.putExtra("gp",gambarTour[i]);
                    context.startActivity(pindah);

                }
            });
        }



        @Override
        public int getItemCount() {
            return gambarTour.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imgLogo;
            TextView txtNama;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                imgLogo = itemView.findViewById(R.id.imgList);
                txtNama = itemView.findViewById(R.id.txtListTitle);

            }
        }
    }
}

