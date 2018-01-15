package com.sheygam.masa_g2_15_01_18_part2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gregorysheygam on 15/01/2018.
 */

public class MyAdapter extends BaseAdapter {
    private ArrayList<User> users;
    public MyAdapter(){
        users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            users.add(new User("User " + i,"email" + i + "@mail.com"));
        }
    }

    public void addUser(User user){
        users.add(0,user);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.my_row, parent, false);
        }
        User user = users.get(position);
        TextView nameTxt = convertView.findViewById(R.id.name_txt);
        TextView emailTxt = convertView.findViewById(R.id.email_txt);
        nameTxt.setText(user.getName());
        emailTxt.setText(user.getEmail());

        return convertView;
    }
}
