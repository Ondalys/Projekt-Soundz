package com.example.soundz;


import java.io.IOException;

import android.media.MediaPlayer;
import android.os.Environment;

public class playback {
	private MediaPlayer mp;	
	
	public playback(){
		this.mp=new MediaPlayer();		
		try {
			mp.setDataSource(Environment.getExternalStorageDirectory().getPath()+"01 - introduction & main titles.mp3");// /sdcard/CampainMusic09.mp3
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void play(){
		this.mp.start();
	}

}
