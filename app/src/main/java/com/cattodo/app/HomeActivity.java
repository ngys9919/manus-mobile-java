package com.cattodo.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView;

import java.util.ArrayList;

public class HomeActivity extends Activity {

    private ArrayList<String> todoList;
    private ArrayAdapter<String> adapter;
    private EditText todoInput;
    private ListView todoListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        todoInput = (EditText) findViewById(R.id.todo_input);
        todoListView = (ListView) findViewById(R.id.todo_list_view);

        // Initialize the list and adapter
        todoList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, // Simple built-in layout for list items
                todoList);

        // Set the adapter to the ListView
        todoListView.setAdapter(adapter);

        // Optional: Set up item click listener to remove items
        todoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String item = todoList.get(position);
            Toast.makeText(HomeActivity.this, "Completed: " + item, Toast.LENGTH_SHORT).show();
            todoList.remove(position);
            adapter.notifyDataSetChanged();
            }
        });
    }

    /**
     * Called when the user clicks the Add button.
     * This method is linked via android:onClick="addTodoItem" in activity_home.xml.
     */
    public void addTodoItem(View view) {
        String itemText = todoInput.getText().toString().trim();

        if (!itemText.isEmpty()) {
            todoList.add(itemText);
            adapter.notifyDataSetChanged(); // Refresh the list view
            todoInput.setText(""); // Clear the input field
        } else {
            Toast.makeText(this, "Please enter a task!", Toast.LENGTH_SHORT).show();
        }
    }
}
