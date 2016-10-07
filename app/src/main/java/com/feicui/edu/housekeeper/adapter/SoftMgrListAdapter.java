package com.feicui.edu.housekeeper.adapter;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.feicui.edu.housekeeper.R;
import com.feicui.edu.housekeeper.entity.AppInfo;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/30 0030.
 */
public class SoftMgrListAdapter extends BaseAdapter {

    private ArrayList<AppInfo> appInfos;
    private Context context;
    private LayoutInflater inflater;


    public SoftMgrListAdapter(Context context, ArrayList<AppInfo> appInfos){
        this.appInfos = appInfos;
        this.context = context;
        //创建布局加载器
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return appInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return appInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //加载布局文件
        View view = inflater.inflate(R.layout.view_soft_mgr_list_item, null);
        //找到要使用的控件
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.soft_mgr_list_item_cb);
        ImageView imageView = (ImageView) view.findViewById(R.id.soft_mgr_list_item_iv);
        TextView textView1 = (TextView) view.findViewById(R.id.soft_mgr_list_item_tv1);
        TextView textView2 = (TextView) view.findViewById(R.id.soft_mgr_list_item_tv2);
        TextView textView3 = (TextView) view.findViewById(R.id.soft_mgr_list_item_tv3);

        //添加数据
        AppInfo appInfo = appInfos.get(position);
        PackageInfo packageInfo = appInfo.getInfo();
        checkBox.setChecked(false);
        //获取图标
        Drawable drawable = packageInfo.applicationInfo.loadIcon(context.getPackageManager());
        String label = packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
        imageView.setImageDrawable(drawable);
        textView1.setText(label);
        textView2.setText(packageInfo.packageName);
        textView3.setText(packageInfo.versionName);

        return view;
    }
}
