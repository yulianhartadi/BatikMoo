package net.kampungweb.batikmoo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageButton btnEmail = findViewById(R.id.ib_email);
        btnEmail.setOnClickListener(this);

        ImageButton btnCall = findViewById(R.id.ib_call);
        btnCall.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_email:
                String email = "rawzadigital@gmail.com";
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:" + email));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Hi.. Salam Kenal");
                emailIntent.putExtra(Intent.EXTRA_TEXT,"Tulis disini emailnya");
                startActivity(emailIntent);
                break;
            case R.id.ib_call:
                String phoneNumber = "089501613982";
                Intent intentDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(intentDial);
                break;
        }
    }
}
