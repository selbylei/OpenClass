package com.selbylei.openclass.mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.selbylei.openclass.R;
import com.selbylei.openclass.mvp.bean.Girl;



import java.util.List;

/**
 * Created by selbylei on 17/2/17.
 */
public class GirlAdapter extends BaseAdapter {

    private Context mContext;
    private List<Girl> mGirls;

    public GirlAdapter(Context context, List<Girl> girls) {
        this.mContext = context;
        this.mGirls = girls;
    }

    @Override
    public int getCount() {
        return mGirls.size();
    }

    @Override
    public Object getItem(int position) {
        return mGirls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.adpter_girl, null);
            holder.iv_tips = (ImageView) convertView.findViewById(R.id.iv_tips);
            holder.tv_description = (TextView) convertView.findViewById(R.id.tv_description);
            holder.tv_start = (TextView) convertView.findViewById(R.id.tv_start);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.iv_tips.setImageResource(mGirls.get(position).getResId());
        holder.tv_start.setText(mGirls.get(position).getStart());
        holder.tv_description.setText(mGirls.get(position).getDescription());
        return convertView;
    }


    private static class ViewHolder {
        private ImageView iv_tips;
        private TextView tv_start;
        private TextView tv_description;
    }
}
