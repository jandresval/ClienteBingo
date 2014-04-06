package com.bingosoft.bingo.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bingosoft.bingo.R;
import com.bingosoft.bingo.adapter.items.ImageItem;

import java.util.List;

/**
 * Created by Jaime on 2014-04-04.
 */
public class ImageAdapter extends ArrayAdapter<ImageItem> {

    private Context context;
    private int ResourceId;


    public ImageAdapter(Context context, int resource, List<ImageItem> items) {
        super(context, resource, items);
        this.context = context;
        this.ResourceId = resource;
    }

    private class ViewHolder {
        ImageView photoImageView;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ImageItem photoItem = getItem(position);
        View viewToUse = null;
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            holder = new ViewHolder();
            viewToUse = mInflater.inflate(ResourceId, null);
            holder.photoImageView = (ImageView) viewToUse.findViewById(R.id.imageView);
            viewToUse.setTag(holder);
        } else {
            viewToUse = convertView;
            holder = (ViewHolder) viewToUse.getTag();
        }

        holder.photoImageView.setImageResource(photoItem.getResourceID());
        holder.photoImageView.setAdjustViewBounds(true);
        holder.photoImageView.setMaxHeight(100);
        holder.photoImageView.setMaxWidth(100);

        return viewToUse;
    }

}
