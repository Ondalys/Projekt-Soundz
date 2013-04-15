package com.example.soundz;

import android.content.Context;

public class TrackArrayAdapter extends TwoLineArrayAdapter<Track>{
	
    public TrackArrayAdapter(Context context, Track[] tracks) {
        super(context, tracks);
    }

    @Override
    public String lineOneText(Track t) {
        return t.getTitle();
    }

    @Override
    public String lineTwoText(Track t) {
        return t.getArtist();
    }
    
}