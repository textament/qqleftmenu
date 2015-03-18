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
public class ListViewAdapter extends BaseAdapter {

    private Context context = null;

    private List<TestInfos> list = null;

    private ViewHolder holder = null;

    private LayoutInflater mInflater;

    private boolean isLoading = true;


    LinearLayout linearLayout;
    ImageView img;
    LinearLayout linearLayoutIn;
    TextView tv;
    TextView info;

    public ListViewAdapter(Context context,List<TestInfos> list){
            this.context = context;
            this.list = list;
            this.mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        int count =0;
        if(list.size()%2==0){
            count = list.size()/2;
        }else{
            count = list.size()/2+1;
        }

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

            view = mInflater.inflate(R.layout.item_listview, null);
            holder.outLy = (LinearLayout)view.findViewById(R.id.lin1);
            holder.imageView = (ImageView)view.findViewById(R.id.img);
            holder.title = (TextView)view.findViewById(R.id.title);
            holder.info = (TextView)view.findViewById(R.id.info);
            holder.linearLayoutRight  =(LinearLayout)view.findViewById(R.id.id_lyRight);
            holder.imageViewRight = (ImageView)view.findViewById(R.id.imgRight);
            holder.titleRight = (TextView)view.findViewById(R.id.titleRight);
            holder.infoRight = (TextView)view.findViewById(R.id.infoRight);
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

        int leftP = 0;
        int rightP = 0;

        if(position==0){
            leftP =0;

        }else {
            leftP = position*2;
        }

        rightP = leftP + 1;
        Log.i("rightP",rightP+"");
        TestInfos t = list.get(leftP);
        updateData(t);
        if(rightP<list.size()){
            TestInfos tNext = list.get(rightP);
            updateDataRight(tNext);
            holder.linearLayoutRight.setVisibility(View.VISIBLE);
        }else{
            holder.linearLayoutRight.setVisibility(View.GONE);
        }





//                if(isLoading){
//                    linearLayout  = new LinearLayout(context);
//                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,1);
//                    linearLayout.setLayoutParams(layoutParams);
//                    linearLayout.setOrientation(LinearLayout.HORIZONTAL);
//
//                    img  = new ImageView(context);
//                    LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT ,LinearLayout.LayoutParams.WRAP_CONTENT);
//                    img.setBackgroundResource(R.drawable.ic_launcher);
//                    img.setLayoutParams(lp2);
//
//                    linearLayoutIn = new LinearLayout(context);
//                    LinearLayout.LayoutParams layoutParamsIn = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                    linearLayoutIn.setLayoutParams(layoutParamsIn);
//                    linearLayoutIn.setOrientation(LinearLayout.VERTICAL);
//
//                    tv = new TextView(context);
//                    LinearLayout.LayoutParams layoutParamsTv = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                    tv.setLayoutParams(layoutParamsTv);
//                    tv.setTextSize(16);
//                    tv.setText(tNext.getTitle());
//
//                    info = new TextView(context);
//                    LinearLayout.LayoutParams layoutParamsInfo = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                    info.setLayoutParams(layoutParamsInfo);
//                    info.setTextSize(16);
//                    info.setText(tNext.getInfo());
//
//                    linearLayoutIn.addView(tv);
//                    linearLayoutIn.addView(info);
//
//                    linearLayout.addView(img);
//                    linearLayout.addView(linearLayoutIn);
//                    holder.outLy.addView(linearLayout);
//                }else{
//
//                    tv.setText(tNext.getTitle());
//                    info.setText(tNext.getInfo());
//                }

        return view;
    }

    private void updateDataRight(TestInfos t){

        holder.imageViewRight.setImageResource(R.drawable.ic_launcher);
        holder.titleRight.setText(t.getTitle());
        holder.infoRight.setText(t.getInfo());
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
        LinearLayout outLy;
        LinearLayout linearLayoutRight;
        ImageView imageViewRight;
        TextView titleRight;
        TextView infoRight;
        //ImageView pic;

    }
}
