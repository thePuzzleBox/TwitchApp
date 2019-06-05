package com.example.per2.twitchapp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TwitchActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.swiperefresh)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.recycler_view_top_games)
    RecyclerView recyclerView;
    @Bind(R.id.progress)
    ProgressBar progressBar;
    private List<GameItem> gameItemList;
    private TopGamesAdapter adapter;
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitch);
        ButterKnife.bind(this);
        initRecyclerView();
        initSwipeRefreshLayout();
        loadGames(50, null);
    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        gameItemList = new ArrayList<>();
        adapter = new TopGamesAdapter(gameItemList);
        recyclerView.setAdapter(adapter);
    }

    private void initSwipeRefreshLayout() {
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    private void loadGames(Integer limit, Integer offset) {
        if (Utils.isInternetAvailable(this)) {
            if (snackbar != null) snackbar.dismiss();
            RetrofitClientInstance.createTwitchService().getTopGames(limit, offset).enqueue(new Callback<TopGames>() {
                @Override
                public void onResponse(Call<TopGames> call, Response<TopGames> response) {
                    if (response.isSuccessful())
                        updateList(response.body().getGameItemList());
                }

                @Override
                public void onFailure(Call<TopGames> call, Throwable t) {
                    stopLoadings();
                    initSnackbar(R.string.error);
                    snackbar.show();
                }
            });
        } else {
            initSnackbar(R.string.error_no_internet);
            snackbar.show();
            stopLoadings();
        }
    }

    private void updateList(List<GameItem> list) {
        gameItemList.clear();
        gameItemList.addAll(list);
        adapter.notifyDataSetChanged();
        stopLoadings();
    }

    @Override
    public void onRefresh() {
        loadGames(50, null);
    }

    private void stopLoadings() {
        progressBar.setVisibility(View.GONE);
        swipeRefreshLayout.setRefreshing(false);
    }

    private void initSnackbar(int messageId) {
        snackbar = Snackbar.make(recyclerView, messageId, Snackbar.LENGTH_INDEFINITE);
    }
}
