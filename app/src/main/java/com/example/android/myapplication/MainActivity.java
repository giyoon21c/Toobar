package com.example.android.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.layout.simple_list_item_1;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    ListView l;
    String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // toobar setup
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        // listadapter setup
        l = (ListView) findViewById(R.id.listView);
        // 2nd param in constructor is how the view should appear...
        // Android's simple_list_item_1
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, days);
        // set the adapter for this listView
        l.setAdapter(adapter);
        // define OnItemClickListener
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id){
                TextView temp = (TextView) view;
                Toast.makeText(getApplicationContext(), temp.getText() + "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(this, "Hey you just hit " + item.getTitle(),
                    Toast.LENGTH_SHORT).show();
            return true;
        }

        // Intent is defined as calling SubActivity here when
        // navigate submenu is chosen
        if (id == R.id.navigate) {
            startActivity(new Intent(this, SubActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

}
