package com.example.todoapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class EditItemActivity extends Activity {

	private int pos;
	private String text;
	private EditText mtlListItem;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_item);
		text = getIntent().getStringExtra("text");
		pos = getIntent().getIntExtra("position", 0);
		mtlListItem = (EditText) findViewById(R.id.mtlListItem);
		mtlListItem.setText(text);
		mtlListItem.setSelection(mtlListItem.getText().length());
		mtlListItem.requestFocus();
		
		mtlListItem.postDelayed( new Runnable() {
			@Override
			public void run() {
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.showSoftInput(mtlListItem, InputMethodManager.SHOW_IMPLICIT);
			}
			
		}, 50);
	}

	public void onSaveItem(View v) {
		Intent data = new Intent();
		
		data.putExtra("newListItem", mtlListItem.getText().toString());
		data.putExtra("position", pos);
		
		setResult(RESULT_OK, data);
		finish();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_item, menu);
		return true;
	}

}
