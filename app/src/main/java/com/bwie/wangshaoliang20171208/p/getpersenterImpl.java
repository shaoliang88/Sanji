package com.bwie.wangshaoliang20171208.p;

import com.bwie.wangshaoliang20171208.Bean;
import com.bwie.wangshaoliang20171208.m.getModel;
import com.bwie.wangshaoliang20171208.m.getModelImpl;
import com.bwie.wangshaoliang20171208.utils.Finish;
import com.bwie.wangshaoliang20171208.v.getView;

/**
 * Created by lenovo on 2017/12/8.
 */

public class getpersenterImpl implements getpersenter,Finish{
    private final getModel m;
    getView view;

    public getpersenterImpl(getView view) {
        this.view = view;
        m=new getModelImpl();
    }

    @Override
    public void guanlian() {
        m.getData(this);
    }

    @Override
    public void onfinish(Bean bean) {
        view.ShowData(bean);
    }
}
