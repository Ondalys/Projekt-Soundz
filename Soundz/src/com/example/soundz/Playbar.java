package com.example.soundz;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

public class Playbar extends Fragment
{
	//PlaybarListener mCallback;
	
	
	//This interface must be implement by any class that is supposed to communicate with this fragment
	/*public interface PlaybarListener{
		
		public void onHomeButtonPressed();
		
		public void onQueueButtonPressed();
		
		public void onPreviousButtonPressed();
		
		public void onNextButtonPressed();
		
		public void onPlayButtonPressed(boolean state);
	}*/
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.playbar, container, false);
        return view;
	}
	
	
	//When the fragment is attached to activity
	public void onAttach(Activity activity) {
        super.onAttach(activity);
        
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        /*try {
            mCallback = (PlaybarListener) activity;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement PlaybarListener");
        }*/
    }
	
}
