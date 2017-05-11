package com.example.ajayp.gridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by ajayp on 5/9/2017.
 */


public class ImageAdapter extends BaseAdapter {
        private Context mContext;
        public ImageAdapter(Context c) {
            mContext=c;
        }


        @Override
        public int getCount() {
            return Ids.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView= new ImageView(mContext);;
            imageView.setLayoutParams(new GridView.LayoutParams(200,200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
            imageView.setImageResource(Ids[position]);
            return imageView;
        }
        // references to our images
        private Integer[] Ids = {
                R.color.colorAccent, R.color.colorPrimary,
                R.color.colorAccent, R.color.colorPrimary,
                R.color.colorAccent, R.color.colorPrimary,
                R.color.colorAccent, R.color.colorPrimary,
                R.color.colorAccent, R.color.colorPrimary,
                R.color.colorAccent, R.color.colorPrimary,
                R.color.colorAccent, R.color.colorPrimary,
                R.color.colorAccent, R.color.colorPrimary,
        };
}
