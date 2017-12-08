package com.bwie.wangshaoliang20171208;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwie.wangshaoliang20171208.adapter.LeftAdpter;
import com.bwie.wangshaoliang20171208.adapter.MyAdapter;
import com.bwie.wangshaoliang20171208.p.getpersenter;
import com.bwie.wangshaoliang20171208.p.getpersenter2;
import com.bwie.wangshaoliang20171208.p.getpersenterImpl;
import com.bwie.wangshaoliang20171208.p.getpersenterImpl2;
import com.bwie.wangshaoliang20171208.v.getView;
import butterknife.BindView;
import butterknife.ButterKnife;
public class MainActivity extends AppCompatActivity implements getView {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.recycler2)
    RecyclerView recycler2;
    private getpersenter p;

    private getpersenter2 p2;
    private getpersenter2 p21;
    private String cid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        p=new getpersenterImpl(this);
        p.guanlian();
        p21 = new getpersenterImpl2(this);

recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler2.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void ShowData(final Bean bean) {
        MyAdapter adapter=new MyAdapter(MainActivity.this,bean);
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
          adapter.setOnItemClickLinster(new MyAdapter.OnItemClickLinster() {
              @Override
              public void OnItemClickLinser(View v, int pos) {
                   cid = bean.getData().get(pos).getCid()+"";
                   p21.guanlian2(cid);
              }

              @Override
              public void OnItemLongClickLinser(View v, int pos) {

              }
          });
    }

    @Override
    public void ShowData2(LeftBean leftBean) {
        LeftAdpter adpter=new LeftAdpter(MainActivity.this,leftBean);
        recycler2.setAdapter(adpter);


    }

    @Override
    public String cid() {
        return cid;
    }

}
