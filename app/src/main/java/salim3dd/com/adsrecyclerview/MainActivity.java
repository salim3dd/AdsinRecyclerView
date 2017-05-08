package salim3dd.com.adsrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public List<List_Item> mList;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private Recycler_ViewAdapter Recycler_view_Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.m_RecyclerView);
        recyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        mList = new ArrayList<>();

        Recycler_view_Adapter = new Recycler_ViewAdapter(mList, this);
        recyclerView.setAdapter(Recycler_view_Adapter);

        LoadData();
    }

    public void LoadData() {

        for (int i = 1; i < 31; i++) {
            List_Item list_item = new List_Item();
            list_item.setTitle("العنوان رقم : " + i);
            list_item.setViewType(1);
            mList.add(list_item);
        }

        ////
        List_Item list_item2 = new List_Item();
        list_item2.setViewType(2);
        mList.add(0, list_item2);
        mList.add(10, list_item2);
        mList.add(20, list_item2);
        mList.add(29, list_item2);



        Recycler_view_Adapter.notifyDataSetChanged();
    }

}
