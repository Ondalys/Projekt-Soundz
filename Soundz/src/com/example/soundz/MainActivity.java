package com.example.soundz;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item)
	{
	    switch(item.getItemId())
	    {
	    	case R.id.action_settings:
		    	Fragment fragment = new Fragment();
		    	setContentView(R.layout.activity_settings);
		    	if(findViewById(R.id.linearLayout2) != null) {
		            fragment.setArguments(getIntent().getExtras());
		            FragmentTransaction transaction = getFragmentManager().beginTransaction();
		            transaction.replace(R.id.linearLayout2, fragment);
		            transaction.addToBackStack(null);
		            transaction.commit();
		        }
	    }

	    	return true;
	}
	
	@Override
	public void onBackPressed(){
	    
	}
}
