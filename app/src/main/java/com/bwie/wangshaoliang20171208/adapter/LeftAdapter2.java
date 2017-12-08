package com.bwie.wangshaoliang20171208.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.wangshaoliang20171208.LeftBean;
import com.bwie.wangshaoliang20171208.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/12/8.
 */

public class LeftAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<LeftBean.DataBean.ListBean> bean;

    public LeftAdapter2(Context context, List<LeftBean.DataBean.ListBean> bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.leftitem2, null);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder=(ViewHolder)holder;
        viewHolder.simpl.setImageURI(bean.get(position).getIcon());
        viewHolder.tv3.setText(bean.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return bean.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.simpl)
        SimpleDraweeView simpl;
        @BindView(R.id.tv3)
        TextView tv3;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
