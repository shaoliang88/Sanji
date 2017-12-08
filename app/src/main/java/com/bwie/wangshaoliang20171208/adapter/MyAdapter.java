package com.bwie.wangshaoliang20171208.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.wangshaoliang20171208.Bean;
import com.bwie.wangshaoliang20171208.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/12/8.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private Bean bean;
    public MyAdapter(Context context, Bean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
          ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        final ViewHolder viewHolder=(ViewHolder)holder;
        if(onItemClickLinster!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    onItemClickLinster.OnItemClickLinser(view,pos);
                    onItemClickLinster.OnItemLongClickLinser(view,pos);
                }
            });
        }
        viewHolder.tv.setText(this.bean.getData().get(position).getName());
    }

    @Override
    public int getItemCount() {
        return bean.getData().size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv)
        TextView tv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
    public interface OnItemClickLinster{
        void OnItemClickLinser(View v, int pos);
        void OnItemLongClickLinser(View v, int pos);
    }

    private OnItemClickLinster onItemClickLinster;

    public void setOnItemClickLinster(OnItemClickLinster onItemClickLinster) {
        this.onItemClickLinster = onItemClickLinster;
    }

}
