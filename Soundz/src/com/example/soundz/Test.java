package com.example.soundz;



import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Test extends Fragment
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.test, container, false);
		String s = getArguments().getString("key");
		TextView text = (TextView) view.findViewById(R.id.text_test);
		text.setText(s);
		
        return view;
	}
	
	
	@Override
	public void onAttach(Activity activity) {
        super.onAttach(activity);
        
        
    }
}