package com.example.soundz;



import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity /*implements PlaybarListener*/
{
	
	private Playback playback;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		
		// Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container1) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create an instance of ExampleFragment
            Queue startFragment = new Queue();
            
            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            startFragment.setArguments(getIntent().getExtras());
            
            // Add the fragment to the 'fragment_container1' FrameLayout
            getFragmentManager().beginTransaction()
                    .add(R.id.fragment_container1, startFragment).commit();
            
            Info infoFragment = new Info();
            
            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            infoFragment.setArguments(getIntent().getExtras());
            
            // Add the fragment to the 'fragment_container2' FrameLayout
            getFragmentManager().beginTransaction()
                    .add(R.id.fragment_container2, infoFragment).commit();
            
            playback = new Playback();
        }
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
	    /*switch(item.getItemId())
	    {
	    	case R.id.settings:
		    	Fragment fragment = new Fragment();
		    	setContentView(R.layout.settings);
		    	if(findViewById(R.id.fragment_container1) != null) {
		            fragment.setArguments(getIntent().getExtras());
		            FragmentTransaction transaction = getFragmentManager().beginTransaction();
		            transaction.replace(R.id., fragment);
		            transaction.addToBackStack(null);
		            transaction.commit();
		        }
	    }*/

	    return true;
	}
	
	@Override
	public void onBackPressed(){
	    
	}

	
	
	/*
	 * Below methods are called when the buttons on the Playbar are pressed
	 */
	
	public void onHomeButtonPressed(View view) {
				
	}

	
	public void onQueueButtonPressed(View view) {
				
	}

	
	public void onPreviousButtonPressed(View view) {
			playback.prev();
	}

	
	public void onNextButtonPressed(View view) {
			playback.next();
	}

	
	public void onPlayButtonPressed(View view) {
		boolean state = ((ToggleButton) view).isChecked();
		if(state){
			playback.play();
		}
		else{
			playback.pause();
		}
	}
	
	
	
	/*
	private void doTest(String s){
		
		Test t = new Test();
		Bundle args = new Bundle();
		args.putString("key", s);
		t.setArguments(args);

		FragmentTransaction transaction = getFragmentManager().beginTransaction();

		// Replace whatever is in the fragment_container view with this fragment,
		// and add the transaction to the back stack so the user can navigate back
		transaction.replace(R.id.fragment_container1, t);
		transaction.addToBackStack(null);

		// Commit the transaction
		transaction.commit();
		
	}*/
}
