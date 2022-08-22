package com.appectools.cuttingcalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class AdapterBetweenMainAndList_view extends BaseAdapter {
    ArrayList<VariablesForObjectForListView> data_list = new ArrayList<>();
    Context context;

    //Constructor
    public AdapterBetweenMainAndList_view(ArrayList<VariablesForObjectForListView> list, Context context_c) {
        this.data_list = list;
        this.context = context_c;
    }

    @Override
    //Size of data_list Array
    public int getCount() {
        return data_list.size();
    }

    @Override
    //position of Image
    public Object getItem(int position) {
        return data_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    //Layout in Flat +View
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflaterInObject = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewObject = layoutInflaterInObject.inflate(R.layout.list_view_layout, parent, false);
        // The Image from List_view_layout Declaration and Assigning
        ImageView imageView = viewObject.findViewById(R.id.imageView_list_view);
        imageView.setImageResource(data_list.get(position).getShapeImage());
        return viewObject;
    }
}
