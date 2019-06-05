package com.example.per2.twitchapp;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;



public class Streams extends AppCompatActivity {

    @Bind(R.id.txt_game_title)
    TextView txtGameTitle;
    @Bind(R.id.txt_details)
    TextView txtGameDetails;
    @Bind(R.id.img_box)
    ImageView imgBox;
    @Bind(R.id.img_logo)
    ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streams);
        ButterKnife.bind(this);
        initActionBar();
        loadBox();
        loadLogo();
        loadTitle();
        loadDetails();
    }

    private void loadBox() {
        String url = getIntent().getStringExtra(Utils.Keys.URL_BOX.name());
        Picasso.with(imgBox.getContext())
                .load(Utils.getBoxUrl(url, Utils.getDensity(this)))
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(imgBox);
    }

    private void loadLogo() {
        String url = getIntent().getStringExtra(Utils.Keys.URL_LOGO.name());
        Picasso.with(imgLogo.getContext())
                .load(Utils.getLogoUrl(url, Utils.getDensity(this)))
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(imgLogo);
    }


    private void loadTitle() {
        txtGameTitle.setText(getExtra(Utils.Keys.TITLE));
    }

    private void loadDetails() {
        String details = buildDetails(getExtra(Utils.Keys.CHANNEL), getExtra(Utils.Keys.VIEWER));
        txtGameDetails.setText(details);
    }

    private String getExtra(Utils.Keys key) {
        return getIntent().getStringExtra(key.name()) == null ? getString(R.string.error) : getIntent().getStringExtra(key.name());
    }

    private String buildDetails(String channels, String views) {
        return String.format("%s %s\n%s %s", getString(R.string.channel), channels, getString(R.string.viewers), views);
    }

    private void initActionBar() {
        ActionBar act = getSupportActionBar();
        if (act == null) return;
        act.setDisplayHomeAsUpEnabled(true);
        act.setTitle(getExtra(Utils.Keys.TITLE));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                this.finish();
                return true;
        }
    }
}
