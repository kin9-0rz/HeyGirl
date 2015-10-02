package com.android.reverse.client;

import java.lang.reflect.InvocationTargetException;

import com.android.reverse.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
		try {
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			((InvocationTargetException)e).getTargetException().printStackTrace();
		}
	}


}
