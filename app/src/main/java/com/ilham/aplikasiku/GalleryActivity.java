package com.ilham.aplikasiku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.ilham.aplikasiku.Adapter.GalleryAdapter;
import com.ilham.aplikasiku.Item.GalleryItem;
import com.ilham.aplikasiku.utils.Tools;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryActivity extends AppCompatActivity {

    private List<GalleryItem> galleryitems = null;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    private ActionBar actionBar;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        ButterKnife.bind(this);

        initToolbar();
        loadDataGallery();

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        GalleryAdapter GalleryDataAdapter = new GalleryAdapter(getApplicationContext(), galleryitems);
        recyclerView.setAdapter(GalleryDataAdapter);
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.blue_700));
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("Gallery");
        Tools.setSystemBarColor(this, R.color.colorPrimary);
    }

    public void loadDataGallery() {
        galleryitems = new ArrayList<GalleryItem>();
        galleryitems.add(new GalleryItem("Ryan Yusup", "Lembang People", R.drawable.ryan));
        galleryitems.add(new GalleryItem("Aa Suhendar", "Lembang People", R.drawable.aa));
        galleryitems.add(new GalleryItem("Gilang Maulana", "Cimahi People", R.drawable.lang));
        galleryitems.add(new GalleryItem("Yusup Maulanadireja", "Sahabat seperjuangan", R.drawable.ucup));
        galleryitems.add(new GalleryItem("Erry Nurhadiansyah", "Subang People", R.drawable.eri));
        galleryitems.add(new GalleryItem("Adi", "Lembang People", R.drawable.adi));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
