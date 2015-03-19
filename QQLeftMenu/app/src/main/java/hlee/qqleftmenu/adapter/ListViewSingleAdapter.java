package hlee.qqleftmenu.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import hlee.qqleftmenu.R;
import hlee.qqleftmenu.TestInfos;


/**
 * Created by Administrator on 2015/3/5 0005.
 */
public class ListViewSingleAdapter extends BaseAdapter {

    private Context context = null;

    private List<TestInfos> list = null;

    private ViewHolder holder = null;

    private LayoutInflater mInflater;

    private boolean isLoading = true;

    private boolean change = true;


    LinearLayout linearLayout;
    ImageView img;
    LinearLayout linearLayoutIn;
    TextView tv;
    TextView info;

    public ListViewSingleAdapter(Context context, List<TestInfos> list){
            this.context = context;
            this.list = list;
            this.mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        int count =0;
        count = list.size();
        return count;
    }

    @Override
    public TestInfos getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (convertView == null) {

            holder = new ViewHolder();

            view = mInflater.inflate(R.layout.item_listview_single, null);

            holder.imageView = (ImageView)view.findViewById(R.id.img_single);
            holder.title = (TextView)view.findViewById(R.id.title_single);
            holder.info = (TextView)view.findViewById(R.id.info_single);

            view.setTag(holder);
            Log.e("1","1");
            isLoading = true;
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
           // holder.outLy.removeAllViews();
            Log.e("2","2");
            isLoading = false;
        }
        Log.i("position",position+"");
        // set data


        TestInfos t = list.get(position);
        updateData(t);



        return view;
    }





    private void updateData(TestInfos t){
        holder.imageView.setImageResource(R.drawable.ic_launcher);
        holder.title.setText(t.getTitle());
        holder.info.setText(t.getInfo());

    }

    static class ViewHolder {
        ImageView imageView;
        TextView title;
        TextView info;

        //ImageView pic;

    }
}
