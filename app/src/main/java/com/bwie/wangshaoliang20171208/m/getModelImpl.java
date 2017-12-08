package com.bwie.wangshaoliang20171208.m;

import com.bwie.wangshaoliang20171208.Bean;
import com.bwie.wangshaoliang20171208.utils.Finish;
import com.bwie.wangshaoliang20171208.utils.ServiceAPI;
import com.bwie.wangshaoliang20171208.utils.UtilsURL;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2017/12/8.
 */

public class getModelImpl implements getModel{
    @Override
    public void getData(final Finish finish) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(UtilsURL.HOST_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServiceAPI serviceAPI = retrofit.create(ServiceAPI.class);
        Flowable<Bean> bean = serviceAPI.bean();
        bean.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Bean>() {
                    @Override
                    public void accept(Bean bean) throws Exception {
                        finish.onfinish(bean);
                    }
                });
    }
}
