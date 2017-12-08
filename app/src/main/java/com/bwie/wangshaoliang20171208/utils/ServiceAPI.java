package com.bwie.wangshaoliang20171208.utils;

import com.bwie.wangshaoliang20171208.Bean;
import com.bwie.wangshaoliang20171208.LeftBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lenovo on 2017/12/8.
 */

public interface ServiceAPI {
@GET(UtilsURL.TAGS_URL)
    Flowable<Bean> bean();
    @GET("product/getProductCatagory")
    Flowable<LeftBean> leftbean(@Query("cid")String cid);
}
