package net.kampungweb.batikmoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Button btnContact = findViewById(R.id.btn_contact);
        btnContact.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_contact:
                Toast.makeText(getApplicationContext(), "contact clicked", Toast.LENGTH_SHORT).show();
                String email = "rawzadigital@gmail.com";
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:" + email));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Hi.. Salam Kenal");
                emailIntent.putExtra(Intent.EXTRA_TEXT,"Tulis disini emailnya");
                startActivity(emailIntent);
                break;
        }
    }
}
