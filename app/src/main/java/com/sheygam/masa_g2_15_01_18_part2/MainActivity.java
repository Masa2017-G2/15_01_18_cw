package com.sheygam.masa_g2_15_01_18_part2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView myList;
    private MyAdapter adapter;
    private Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new MyAdapter();
        myList = findViewById(R.id.my_list);
        addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(this);
        myList.setAdapter(adapter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = (User) adapter.getItem(position);
                Toast.makeText(MainActivity.this, "Was clicked " + user.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        myList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                User user = (User) adapter.getItem(position);
                Toast.makeText(MainActivity.this, "Long click on " + user.getName(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.add_btn){
            User user = new User("Name " + System.currentTimeMillis() , "vasya@mail.com");
            adapter.addUser(user);
        }
    }
}
