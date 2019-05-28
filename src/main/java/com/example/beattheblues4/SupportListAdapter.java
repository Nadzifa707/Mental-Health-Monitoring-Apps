package com.example.beattheblues4;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SupportListAdapter extends ArrayAdapter<Support> {

    Context context;
    int layoutResourceId;
    List<Support> data = null;

    public SupportListAdapter(Context context, int resource, List<Support> objects) {
        super(context, resource, objects);
        this.layoutResourceId = resource;
        this.context = context;
        this.data = (List) objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        SupportHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new SupportHolder();
            holder.name = (TextView) row.findViewById(R.id.name_text);
            holder.email = (TextView)row.findViewById(R.id.email_text);

            row.setTag(holder);
        }
        else
        {
            holder = (SupportHolder) row.getTag();
        }

        Support item = data.get(position);
        holder.name.setText(item.getName());
        holder.email.setText(item.getEmail());

        return row;
    }

    private class SupportHolder {
        public TextView name;
        public TextView email;

    }
}