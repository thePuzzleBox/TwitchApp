package com.example.per2.twitchapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TopGamesAdapter extends RecyclerView.Adapter<TopGamesAdapter.ViewHolder> {

    private List<GameItem> mGameItemList;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.img_box)
        ImageView imgBox;
        @Bind(R.id.txt_game_title)
        TextView txtGameTitle;
        @Bind(R.id.rel_item)
        RelativeLayout relItem;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public TopGamesAdapter(List<GameItem> mGameItemList) {
        this.mGameItemList = mGameItemList;
    }

    @Override
    public TopGamesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_game_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TopGamesAdapter.ViewHolder holder, int position) {
        final GameItem gameItem = mGameItemList.get(position);
        loadImage(gameItem.getGame().getBox().getTemplate(), holder.imgBox);
        loadText(gameItem.getGame().getName(), holder.txtGameTitle);
        loadDetails(gameItem, holder.relItem);
    }

    @Override
    public int getItemCount() {
        return mGameItemList.size();
    }

    private void loadImage(String url, ImageView img) {
        Picasso.with(img.getContext())
                .load(Utils.getBoxUrl(url, Utils.getDensity(img.getContext())))
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(img);
    }

    private void loadText(String text, TextView txt) {
        txt.setText(text);
    }

    private void loadDetails(final GameItem gameItem, final View v) {
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v.getContext().startActivity(getDetailIntent(gameItem, v.getContext()));
            }
        });
    }

    private Intent getDetailIntent(GameItem gameItem, Context ctx) {
        Intent i = new Intent(ctx, Streams.class);
        i.putExtra(Utils.Keys.TITLE.name(), gameItem.getGame().getName());
        i.putExtra(Utils.Keys.URL_LOGO.name(), gameItem.getGame().getLogo().getTemplate());
        i.putExtra(Utils.Keys.URL_BOX.name(), gameItem.getGame().getBox().getTemplate());
        i.putExtra(Utils.Keys.CHANNEL.name(), String.valueOf(gameItem.getChannels()));
        i.putExtra(Utils.Keys.VIEWER.name(), String.valueOf(gameItem.getViewers()));
        return i;
    }
}
