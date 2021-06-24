package com.example.myadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CountryAdapter extends ArrayAdapter<String> {

    String[] countryNamee;
    String[] captureNamee;
    int[] imageId;
    Context context;

    public CountryAdapter(Context contexts, String[] country_name, String[] capture_name, int[] image_id) {
        super(contexts, R.layout.layout_list, R.id.countryName, country_name);
        this.context = contexts;
        this.countryNamee = country_name;
        this.captureNamee = capture_name;
        this.imageId = image_id;

    }

    class PlaceHolder {

        ImageView image;
        TextView textCountry, textCapture;

        PlaceHolder(View view) {
            image = view.findViewById(R.id.imageView);
            textCountry = view.findViewById(R.id.countryName);
            textCapture = view.findViewById(R.id.captureCountry);

        }

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        PlaceHolder placeHolder = null;
        View view = convertView;

        if (view == null) {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.layout_list, parent, false);
            placeHolder = new PlaceHolder(view);
            view.setTag(placeHolder);
        } else {
            placeHolder = (PlaceHolder) view.getTag();

        }


        placeHolder.image.setImageResource(imageId[position]);
        placeHolder.textCountry.setText(countryNamee[position]);
        placeHolder.textCapture.setText(captureNamee[position]);


        return view;
    }
}
