package net.kampungweb.batikmoo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvBatik;
    private ArrayList<Batik> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvBatik = findViewById(R.id.rv_batik);
        rvBatik.setHasFixedSize(true);

        list.addAll(BatikData.getListData());
        showRecycleList();

    }

    private void showRecycleList() {
        rvBatik.setLayoutManager(new LinearLayoutManager(this));
        ListBatikAdapter listBatikAdapter = new ListBatikAdapter(list);
        rvBatik.setAdapter(listBatikAdapter);

        // onClickListener to detail batik items
        listBatikAdapter.setOnItemClickCallBack(new ListBatikAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(Batik data) {
                showSelectedBatik(data);
            }
        });
    }

    // Show Detail Click list items
    private void showSelectedBatik(Batik batik){
        Toast.makeText(this, "detail to : " + batik.getName(), Toast.LENGTH_SHORT).show();

        // Cara 1
        Batik mBatik = new Batik();
        mBatik.setName(batik.getName());
        mBatik.setFrom(batik.getFrom());
        mBatik.setContent(batik.getContent());
        mBatik.setPhoto(batik.getPhoto());

        // Cara 2 dengan parcelable
        Intent intentDetailBatik = new Intent(MainActivity.this, DetailBatikActivity.class);
        intentDetailBatik.putExtra(DetailBatikActivity.EXTRA_DETAIL, mBatik);
        startActivity(intentDetailBatik);

    }

    //Menu main
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode){
        switch (selectedMode){
            case R.id.about:
                Toast.makeText(this,"to about activity", Toast.LENGTH_SHORT).show();
                Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(aboutIntent);
                break;
            case R.id.profile:
                Toast.makeText(this,"to profile activity", Toast.LENGTH_SHORT).show();
                Intent profileIntent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(profileIntent);
                break;
        }
    }
}
