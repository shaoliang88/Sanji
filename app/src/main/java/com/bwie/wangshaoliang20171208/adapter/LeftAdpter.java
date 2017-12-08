package com.bwie.wangshaoliang20171208.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.wangshaoliang20171208.LeftBean;
import com.bwie.wangshaoliang20171208.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/12/8.
 */

public class LeftAdpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LeftBean bean;

    public LeftAdpter(Context context, LeftBean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.leftitem, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
       viewHolder.tv2.setText(bean.getData().get(position).getName());
        viewHolder.recycler3.setLayoutManager(new GridLayoutManager(context,4));
         LeftAdapter2 adapter2=new LeftAdapter2(context,bean.getData().get(position).getList());
        viewHolder.recycler3.setAdapter(adapter2);
    }

    @Override
    public int getItemCount() {
        return bean.getData().size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv2)
        TextView tv2;
        @BindView(R.id.recycler3)
        RecyclerView recycler3;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
