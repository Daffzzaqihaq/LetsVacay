package com.daffzzaqihaq.tourinengland;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyProfile extends AppCompatActivity {

    @BindView(R.id.feedback)
    Button feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.feedback,})
    public void onViewClicked(View view) {

        Intent intent;

        // TODO Membuat Intent untuk memanggil Email
        intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("MailTo", "daffaazzaqihaq000@gmail.com", null));

        // TODO Memasukan subject dan isi pesan ke dalam Intent
        intent.putExtra(Intent.EXTRA_SUBJECT, "(Silahkan diisi)");
        intent.putExtra(Intent.EXTRA_TEXT, "(Silahkan diisi)");


        // TODO Mencek apakah user memiliki aplikasi Email
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Pilih Email"));
        } else {
            Toast.makeText(this, "Maaf anda tidak memiliki aplikasi Email", Toast.LENGTH_SHORT).show();

        }

    }
}





