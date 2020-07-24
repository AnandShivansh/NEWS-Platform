package com.example.prans.news.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.prans.news.R;
import com.example.prans.news.model.News;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.prans.news.model.Utils;

import java.text.ParseException;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsWithImageViewHolder> {

    private List<News> newsList;
    private final RequestManager glide;
    private Context context;
    public NewsAdapter(List<News> newsList, RequestManager glide) {
        this.newsList = newsList;
        this.glide = glide;

    }

    @NonNull
    @Override
    public NewsWithImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_item, viewGroup, false);
        return new NewsWithImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsWithImageViewHolder viewHolder, int i) {
        News news = newsList.get(i);
        final NewsWithImageViewHolder holder = viewHolder;
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(Utils.getRandomDrawbleColor());
        requestOptions.error(Utils.getRandomDrawbleColor());
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        requestOptions.centerCrop();

        glide.load(news.getUrlToImage())
                .apply(requestOptions)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.imageView);

        holder.title.setText(news.getTitle());
        holder.desc.setText(news.getDescription());
        holder.time.setText(" \u2022 " + Utils.DateToTimeFormat(news.getPublishedAt()));
        holder.published_ad.setText(Utils.DateFormat(news.getPublishedAt()));
    }

    @Override
    public int getItemViewType(int position) {

        News news = newsList.get(position);

        if (news != null) {
            return news.getType();
        }

        return 0;
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsWithImageViewHolder extends RecyclerView.ViewHolder {

        TextView title, desc, author, published_ad, source, time;
        ImageView imageView;
        ProgressBar progressBar;

        public NewsWithImageViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);
            published_ad = itemView.findViewById(R.id.publishedAt);
            time = itemView.findViewById(R.id.time);
            imageView = itemView.findViewById(R.id.img);
            progressBar = itemView.findViewById(R.id.prograss_load_photo);

        }
    }
}
