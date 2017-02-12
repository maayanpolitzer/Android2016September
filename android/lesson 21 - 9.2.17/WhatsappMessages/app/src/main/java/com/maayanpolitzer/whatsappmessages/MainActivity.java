package com.maayanpolitzer.whatsappmessages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.maayanpolitzer.whatsappmessages.listeners.OnUsersArrivedListener;
import com.maayanpolitzer.whatsappmessages.threads.GetUsersThread;


public class MainActivity extends AppCompatActivity implements OnUsersArrivedListener, AdapterView.OnItemClickListener {

    private ListView listView;
    private User[] users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new GetUsersThread(this).start();

        listView = (ListView) findViewById(R.id.list_view);

        listView.setOnItemClickListener(this);

    }


    @Override
    public void updateList(User[] users) {
        this.users = users;
        ArrayAdapter<User> adapter = new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, users);
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, ChatActivity.class);
        intent.putExtra("ID", users[position].getId());
        startActivity(intent);
    }
}
