package com.bawei.test.app;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

/**
 * Created by asus on 2017/8/29.
 */

public class TotalAPp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initUtils();
initImgLoader();
    }

    private void initImgLoader() {
        DisplayImageOptions option=new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .build();
        ImageLoaderConfiguration con=new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(option)
                .build();
        ImageLoader.getInstance().init(con);
    }

    private void initUtils() {
        x.Ext.init(this);
        x.Ext.setDebug(false);
    }
}
