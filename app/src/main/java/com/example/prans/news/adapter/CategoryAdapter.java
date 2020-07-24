package com.example.prans.news.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.prans.news.R;
import com.example.prans.news.fragment.BBCFragment;
import com.example.prans.news.fragment.MtvFragment;
import com.example.prans.news.fragment.CNNFragment;
import com.example.prans.news.fragment.FortuneFragment;
import com.example.prans.news.fragment.FoxNewsFragment;
import com.example.prans.news.fragment.GoogleNewsFragment;
import com.example.prans.news.fragment.TheHinduFragment;
import com.example.prans.news.fragment.ESPNFragment;
import com.example.prans.news.fragment.BuzzfeedFragment;
import com.example.prans.news.fragment.AljazeeraFragment;

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new BuzzfeedFragment();
                break;
            case 1:
                fragment = new AljazeeraFragment();
                break;
            case 2:
                fragment = new ESPNFragment();
                break;
            case 3:
                fragment = new BBCFragment();
                break;
            case 4:
                fragment = new GoogleNewsFragment();
                break;
            case 5:
                fragment = new TheHinduFragment();
                break;
            case 6:
                fragment = new CNNFragment();
                break;
            case 7:
                fragment = new MtvFragment();
                break;
            case 8:
                fragment = new FoxNewsFragment();
                break;
            case 9:
                fragment = new FortuneFragment();
                break;
            default:
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String pageTitle = null;
        switch (position) {
            case 0:
                pageTitle = mContext.getString(R.string.source_buzzfeed);
                break;

            case 1:
                pageTitle = mContext.getString(R.string.source_aljazeera);
                break;
            case 2:
                pageTitle = mContext.getString(R.string.source_espn);
                break;
            case 3:
                pageTitle = mContext.getString(R.string.source_bbc);
                break;
            case 4:
                pageTitle = mContext.getString(R.string.source_google);
                break;
            case 5:
                pageTitle = mContext.getString(R.string.source_thehindu);
                break;
            case 6:
                pageTitle = mContext.getString(R.string.source_cnn);
                break;
            case 7:
                pageTitle = mContext.getString(R.string.source_mtvnews);
                break;
            case 8:
                pageTitle = mContext.getString(R.string.source_foxnews);
                break;
            case 9:
                pageTitle = mContext.getString(R.string.source_fortune);
                break;
            default:
                break;
        }

        return pageTitle;
    }

}
