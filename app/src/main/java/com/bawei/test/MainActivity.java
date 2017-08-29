package com.bawei.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.bawei.test.adapter.MyAdapter;
import com.bawei.test.api.HttpApi;
import com.bawei.test.bean.News;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

//@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
//    @ViewInject(R.id.lv_news)
    ListView lv_news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_news= (ListView) findViewById(R.id.lv_news);
loadNews();
    }

    private void loadNews() {
        RequestParams params=new RequestParams(HttpApi.POST_URL);
        params.addBodyParameter("key",HttpApi.KEY);
        //请求
        x.http().post(params, new Callback.CommonCallback<String>() {
            String result=null;
            @Override
            public void onSuccess(String result) {
if(result!=null)
{
    this.result=result;
    System.out.println(result);
    parseData(result);
}
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                System.out.println("错误");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void parseData(String data) {

        Gson gson=new Gson();
        News news = gson.fromJson(data, News.class);
        List<News.ResultBean.DataBean> list = news.getResult().getData();
        MyAdapter adapter=new MyAdapter(this,list);

        lv_news.setAdapter(adapter);
    }
}
