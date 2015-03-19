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
    private ViewHolderSingle holdersingle = null;

    private LayoutInflater mInflater;

    private boolean isLoading = true;

    private boolean change = true;


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

        if(change){
            count = list.size();
        }else {
            if(list.size()%2==0){
                count = list.size()/2;
            }else{
                count = list.size()/2+1;
            }
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



            if(change){
                holdersingle = new ViewHolderSingle();


                view = mInflater.inflate(R.layout.item_listview_single, null);

                holdersingle.imageViewSingle = (ImageView)view.findViewById(R.id.img_single);
                holdersingle.titleSingle = (TextView)view.findViewById(R.id.title_single);
                holdersingle.infoSingle = (TextView)view.findViewById(R.id.info_single);

                view.setTag(holdersingle);


            }else{
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
            }


            isLoading = true;
        } else {
            view = convertView;
            if(change){
                holdersingle = (ViewHolderSingle)view.getTag();
            }else{

                holder = (ViewHolder) view.getTag();
            }

           // holder.outLy.removeAllViews();
            isLoading = false;
        }
        // set data

        if(change){
            TestInfos t = list.get(position);
            updateDataSingle(t);
        }else{
            int leftP = 0;
            int rightP = 0;

            if(position==0){
                leftP =0;

            }else {
                leftP = position*2;
            }

            rightP = leftP + 1;
            TestInfos t = list.get(leftP);
            updateData(t);
            if(rightP<list.size()){
                TestInfos tNext = list.get(rightP);
                updateDataRight(tNext);
                holder.linearLayoutRight.setVisibility(View.VISIBLE);
            }else{
                holder.linearLayoutRight.setVisibility(View.GONE);
            }
        }


        return view;
    }

    public void updateData(){
        notifyDataSetChanged();;
    }

    public void setIsChanage (boolean isChanage){
        this.change = isChanage;
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

    private void updateDataSingle(TestInfos t){
        holdersingle.imageViewSingle.setImageResource(R.drawable.ic_launcher);
        holdersingle.titleSingle.setText(t.getTitle());
        holdersingle.infoSingle.setText(t.getInfo());

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


    static class ViewHolderSingle {
        ImageView imageViewSingle;
        TextView titleSingle;
        TextView infoSingle;

        //ImageView pic;

    }
}
