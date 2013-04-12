package com.example.soundz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Environment;


public class Playback{

	MediaPlayer mp = new MediaPlayer();
	String currentTrackPath;
	int currentTrackPosition;
	
	/* This code makes it possible for the MediaPlayer to 
	 * perform the next() method when the track is complete.
	 */ 
	OnCompletionListener comp = new OnCompletionListener(){
		public void onCompletion(MediaPlayer mPlayer){
			next();
			play();
		}
	};
	
	
	// REMOVE LATER ON
	int track = 0;
	String [] tracks = new String [] {"/storage/extSdCard/Music/Agent Orange/Living In Darkness/04 - miserlou.mp3",
		"/storage/extSdCard/Music/Bone Awl/Not For Our Feet/02 Land Of Tar.mp3", 
		"/storage/extSdCard/Music/Agent Orange/Living In Darkness/02 - too young to die.mp3",
		"/storage/extSdCard/Music/Agent Orange/Living In Darkness/10 - pipeline.mp3"};
	
	
	
	public Playback(){
		
			/* This part should later on be implemented. It's perpose is to load
			 * the position of the last track played.*//*
			if (loadable()){  //Om det finns en fil och om det är relevant info
				loadPosition();  //Ladda pos, path
			}*/
		
		mountNextTrack();											// Load next path and should be considered to be removed later on											// Should NOT be here when integrated with GUI		
				
	}

	
	
	 /* 
	  * Play track if no song is playing. If no track is mounted, get path and mount
	 */
	public void play() {
		if (!mp.isPlaying()){			// If no track is currently playing
			try {
				mp.start();				// Try start track
			
			}
			catch (Exception e){	
				mountNextTrack();			// Else catch E and try to mount new song and play.
				play();					// Could cause fatal recursion!!!
			}	
		}
		
	}
	
	
	/*
	 * Pause current track
	 */
	public void pause() {
		if (mp.isPlaying()){									// It should only pause if track is playing
			currentTrackPosition = mp.getCurrentPosition(); 	// Save current position
			mp.pause();		
		}
	}


	/*
	 * Change to next track.
	 */
	public void next() {

		/* If song is playing, change to the next song and play
		 */
		if (mp.isPlaying()){
			mountNextTrack(); 
			play();
		}
		
		/* If song is NOT playing, change to the next song but do NOT play
		 */
		else
			mountNextTrack();
	}


	/*
	 * Change to prev. if current position is grater than 5 seq. else replay track. 
	 */
	public void prev() {
		
		/* If song is playing, change to the next song and play
		 */
		if(mp.isPlaying()){
			if (mp.getCurrentPosition() > 5000)		// And within first 5 sec
				mp.seekTo(0);
			else
				mountPreviousTrack();						// Replay track
		
			play();
		}
		
		/* If song is NOT playing, change to the next song but do NOT play
		 */
		else {
			if (mp.getCurrentPosition() < 5000)		// And within first 5 sec
				mountPreviousTrack();
			else
				mp.seekTo(0);						// Replay track	
		}
	}


	
	/*
	 * Version 1 (no queue interaction)
	 * This version will only load an pre-defined track from raw folder
	 * 
	 * Version 2 (with queue interaction)
	 * This version should get its next song from Qeueu and mount this path on mp
	 */
	public void mountNextTrack() {
		
		/*	GET PATH FROM QUEUE HERE!!
		 * 	
		 * 
		 * 
		 */
		
		
		/*
		 *		PREPERATION AREA 
		 */
		// Reset mp, to be able to mount new track
		mp.reset();
		currentTrackPosition = 0;
		// SHOULD BE REPLACED with more generic code
		//currentTrackPath = "/storage/extSdCard/Music/Agent Orange/Living In Darkness/04 - miserlou.mp3"; 	// Should be removed when above code is implemented
		
		// REMOVE LATER ON
		track = (track +1) % 4;
		currentTrackPath = tracks[track];
		
		
		
		/* 		MOUNT AREA
		 * 
		 * Mounts and prepare track for play back
		 */
		try {
			mp.setOnCompletionListener(comp);					// See comment at top of page at declaration
			mp.setDataSource(currentTrackPath);				
			mp.prepare();
		} catch (IllegalArgumentException e) {
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


	/*
	 * Version 1 (no queue interaction)
	 * This version will only load an pre-defined track from raw folder
	 * 
	 * Version 2 (with queue interaction)
	 * This version should get its prev. song from Qeueu and mount this path on mp
	 */
	public void mountPreviousTrack() {
		
		/*	GET PATH FROM QUEUE CODE HERE!!
		 * 	
		 * 
		 * 
		 */
		
		
		/*
		 *		PREPERATION AREA 
		 */
		// Reset mp, to be able to mount new track
		mp.reset();
		currentTrackPosition = 0;
		// SHOULD BE REPLACED with more generic code
		//currentTrackPath = "/storage/extSdCard/Music/Bone Awl/Not For Our Feet/02 Land Of Tar.mp3"; // Should be removed when above code is implemented
		
		// REMOVE LATER ON
		track = (track -1) % 4;
				currentTrackPath = tracks[track];		
		
		/* 		MOUNT AREA
		 * 
		 * Mounts and prepare track for play back
		 */
		try {
			mp.setOnCompletionListener(comp);					// See comment at top of page at declaration
			mp.setDataSource(currentTrackPath);
			mp.prepare();
		} catch (IllegalArgumentException e) {
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



	/*
	 * Load last played currentTrackPath and it's currentTrackPosition from file
	 * at activity startup.
	 */
	public void loadPosition() {
		// TODO Auto-generated method stub
	}

	/*
	 * Save currently played currentTrackPath and it's currentTrackPosition to file
	 * at activity shut down
	 */
	public void savePosition() {
		// TODO Auto-generated method stub
	}

	/*
	 * Check if it is posible to download the loadPosition file
	 * and if the content is of any use
	 */
	private boolean loadable() {
		return false;
	}

}
