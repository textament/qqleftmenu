package hlee.qqleftmenu;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import java.util.List;

import hlee.qqleftmenu.adapter.ListViewAdapter;

public class WeixinFragment extends Fragment
{
    private Context self = null;


    private ListView listView;

    private ListViewAdapter adapter;
    private List<TestInfos> mlist;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
        self = getActivity();
        View view = inflater.inflate(R.layout.tab01, container,
                false);
        getData();
        listView = (ListView) view.findViewById(R.id.listview);
        adapter = new ListViewAdapter(self,mlist);
        listView.setAdapter(adapter);
		return view;
	}


    private List<TestInfos> getData() {
        mlist = new ArrayList<TestInfos>();
        for(int i =0;i<10;i++){
            TestInfos t = new TestInfos();
            t.setTitle("标题"+i);
            t.setInfo("内容"+i);
            mlist.add(t);
        }

        return mlist;
    }


}
