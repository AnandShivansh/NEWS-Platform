package com.example.prans.news.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class News {

    @SerializedName("title")
    @Expose
    private String mTitle;
    @SerializedName("url")
    @Expose
    private String mUrl;
    @SerializedName("urlToImage")
    @Expose
    private String mUrlToImage;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;
    public static final int NEWS_IMAGE_TYPE = 0;
    public static final int NEWS_WITHOUT_IMAGE_TYPE = 1;
    private int type;

    public News(String mTitle, String mUrl, String mUrlToImage,String description,String publishedAt, int type) {
        this.mTitle = mTitle;
        this.mUrl = mUrl;
        this.mUrlToImage = mUrlToImage;
        this.description = description;
        this.publishedAt = publishedAt;
        this.type = type;
    }

    public int getType() {
        if (mUrlToImage == null) {
            return NEWS_WITHOUT_IMAGE_TYPE;
        } else {
            return NEWS_IMAGE_TYPE;
        }
    }

    public String getTitle() {
        return mTitle.replace("/<(.*?)\\>", "");
    }

    public String getUrl() {
        return mUrl;
    }

    public String getUrlToImage() {
        if (mUrlToImage != null){
            return mUrlToImage;
        }
        return null;
    }
    public String getPublishedAt() {
        return publishedAt;
    }
    public String getDescription() {
        return description;
    }
}
