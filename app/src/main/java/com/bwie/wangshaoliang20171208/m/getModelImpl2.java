package com.bwie.wangshaoliang20171208.m;

import com.bwie.wangshaoliang20171208.Bean;
import com.bwie.wangshaoliang20171208.LeftBean;
import com.bwie.wangshaoliang20171208.utils.LeftFinish;
import com.bwie.wangshaoliang20171208.utils.ServiceAPI;
import com.bwie.wangshaoliang20171208.utils.UtilsURL;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2017/12/8.
 */

public class getModelImpl2 implements getModel2{
    @Override
    public void getData2(final LeftFinish leftfinish, String cid) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(UtilsURL.HOST_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServiceAPI serviceAPI = retrofit.create(ServiceAPI.class);
        Flowable<LeftBean> leftbean = serviceAPI.leftbean(cid);
        leftbean.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LeftBean>() {
                    @Override
                    public void accept(LeftBean bean) throws Exception {
                        leftfinish.finish2(bean);
                    }
                });
    }
}
