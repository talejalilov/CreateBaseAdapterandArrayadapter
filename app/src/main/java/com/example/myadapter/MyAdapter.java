package com.example.myadapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;

class ListClass {
    String name;
    String capture;
    int imageID;
    ListClass(String n,String c, int i){

        name = n;
        capture = c;
        imageID = i;
    }

}

class ViewPlaceHolder {

    ImageView i;
    TextView CoT;
    TextView CaT;
    ViewPlaceHolder(View view){

        i = view.findViewById(R.id.imageView);
        CoT = view.findViewById(R.id.countryName);
        CaT = view.findViewById(R.id.captureCountry);

    }

}

public class MyAdapter extends BaseAdapter {
    ArrayList<ListClass> list  ;
    Context context;

    MyAdapter(Context c){
        context = c;

        list = new ArrayList<>();
        Resources resources = c.getResources();
        String[] countryName = resources.getStringArray(R.array.CountryName);
        String[] captureName = resources.getStringArray(R.array.CaptureName);
        int[] imageId ={R.drawable.country1,R.drawable.country2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
                R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,R.drawable.c11,R.drawable.c12,R.drawable.c13,R.drawable.c14};

        for(int i=0; i<imageId.length;i++) {
            list.add(new ListClass(countryName[i],captureName[i],imageId[i]));
        }

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewPlaceHolder viewPlaceHolder =null;

        View view = convertView;
        if(view==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view= layoutInflater.inflate(R.layout.layout_list,parent,false);
            viewPlaceHolder = new ViewPlaceHolder(view);
            view.setTag(viewPlaceHolder);

        }else {

            viewPlaceHolder = (ViewPlaceHolder) view.getTag();

        }

        ListClass listClass = list.get(position);

        viewPlaceHolder.i.setImageResource(listClass.imageID);
        viewPlaceHolder.CoT.setText(listClass.name);
        viewPlaceHolder.CaT.setText(listClass.capture);


        return view;
    }
}
