package hlee.qqleftmenu;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import java.util.List;

import hlee.qqleftmenu.adapter.ListViewAdapter;
import hlee.qqleftmenu.adapter.ListViewSingleAdapter;

public class WeixinFragment extends Fragment
{
    private Context self = null;


    private ListView listView;
    private ListView listViewSingle;

    private ListViewAdapter adapter;
    private ListViewSingleAdapter listViewSingleAdapter;
    private List<TestInfos> mlist;

    private Button button;
    //切换 true 单行 false 双行
    private Boolean isChange = true;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
        self = getActivity();
        View view = inflater.inflate(R.layout.tab01, container,
                false);
        getData();
        button = (Button)view.findViewById(R.id.change_btn);
        listView = (ListView) view.findViewById(R.id.listview);
    //    listViewSingle = (ListView)view.findViewById(R.id.listview2);
        adapter = new ListViewAdapter(self,mlist);
        adapter.setIsChanage(isChange);
        listView.setAdapter(adapter);

//        listViewSingleAdapter = new ListViewSingleAdapter(self,mlist);
//        listViewSingle.setAdapter(listViewSingleAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isChange){
//                    listViewSingle.setVisibility(View.GONE);
//                    listView.setVisibility(View.VISIBLE);
                    adapter = new ListViewAdapter(self,mlist);
                    adapter.setIsChanage(isChange);
                    isChange = false;

                }else{
//                    listViewSingle.setVisibility(View.VISIBLE);
//                    listView.setVisibility(View.GONE);
                    adapter = new ListViewAdapter(self,mlist);
                    adapter.setIsChanage(isChange);
                    isChange = true;
                }

            }
        });



		return view;
	}


    private List<TestInfos> getData() {
        mlist = new ArrayList<TestInfos>();
        for(int i =0;i<30;i++){
            TestInfos t = new TestInfos();
            t.setTitle("标题"+i);
            t.setInfo("内容"+i);
            mlist.add(t);
        }

        return mlist;
    }


}
