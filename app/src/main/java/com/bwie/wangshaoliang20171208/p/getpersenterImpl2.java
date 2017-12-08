package com.bwie.wangshaoliang20171208.p;

import com.bwie.wangshaoliang20171208.LeftBean;
import com.bwie.wangshaoliang20171208.m.getModel2;
import com.bwie.wangshaoliang20171208.m.getModelImpl2;
import com.bwie.wangshaoliang20171208.utils.LeftFinish;
import com.bwie.wangshaoliang20171208.v.getView;

/**
 * Created by lenovo on 2017/12/8.
 */

public class getpersenterImpl2 implements getpersenter2,LeftFinish{
    private final getModel2 model2;
    getView view;

    public getpersenterImpl2(getView view) {
        this.view = view;
         model2=new getModelImpl2();
    }

    @Override
    public void guanlian2(String cid) {
         model2.getData2(this,view.cid());
    }

    @Override
    public void finish2(LeftBean bean) {
     view.ShowData2(bean);
    }
}
