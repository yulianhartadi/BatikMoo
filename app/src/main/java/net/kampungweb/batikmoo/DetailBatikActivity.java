package net.kampungweb.batikmoo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


public class DetailBatikActivity extends AppCompatActivity {

    public static final String EXTRA_DETAIL = "extra_detail";

    ImageView imgDetailBatik;
    TextView tvNameBatik, tvFromBatik, tvContentBatik;
    ImageButton imgFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_batik);

        tvNameBatik = findViewById(R.id.batik_name);
        tvFromBatik = findViewById(R.id.batik_from);
        tvContentBatik = findViewById(R.id.batik_content);
        imgDetailBatik = findViewById(R.id.img_batik_photo);
        imgFavorite = findViewById(R.id.btn_favorite);

        final Batik mBatik = getIntent().getParcelableExtra(EXTRA_DETAIL);

        // load item detail
        String name = null;
        if (mBatik != null) {
            name = mBatik.getName();
        }
        tvNameBatik.setText(name);

        String from = null;
        if (mBatik != null) {
            from = mBatik.getFrom();
        }
        tvFromBatik.setText(from);

        String content = null;
        if (mBatik != null) {
            content = mBatik.getContent();
        }
        tvContentBatik.setText(content);

        // photo load with Glide
        if (mBatik != null) {
            Glide.with(getApplicationContext())
                    .load(mBatik.getPhoto())
                    .apply(new RequestOptions().override(525, 350))
                    .into(imgDetailBatik);
        }

        imgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBatik != null) {
                    Toast.makeText(getApplicationContext(), mBatik.getName() + " adalah favorit Anda", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
