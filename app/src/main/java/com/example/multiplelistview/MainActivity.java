package com.example.multiplelistview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    final String LOG_TAG = "myLogs";
    ListView lvMain;
    String[] names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMain = findViewById(R.id.lvMain);
        // stalling the choice mod
        lvMain.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE); //you can only choose one item from the list

        // creating adapter, using an array from resources file
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.names,
                android.R.layout.simple_list_item_multiple_choice); //choosing the pre-made list with single choice mode on
        lvMain.setAdapter(adapter);

        Button btnChecked = findViewById(R.id.btnChecked);
        btnChecked.setOnClickListener(this);

        // getting array from resources file
        names = getResources().getStringArray(R.array.names);
    }

    @Override
    public void onClick(View arg0) {
        Log.d(LOG_TAG, "checked: ");
        SparseBooleanArray sbArray = lvMain.getCheckedItemPositions();
        for (int i = 0; i < sbArray.size(); i++){
            int key = sbArray.keyAt(i);
            if (sbArray.get(key)){
                Log.d(LOG_TAG, names[key]);
            }
        }
    }
}
