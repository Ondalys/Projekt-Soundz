package com.example.soundz;

import java.util.*;

public class TrackList
{
	protected LinkedList<Track> trackList = new LinkedList<Track>();
	
	public void addTrack(Track track)					//lägger till en track längst bak
	{
		trackList.add(track);
	}
	public void removeTrack(int index,Track track)    //tar bort track med valt index
	{
		trackList.remove(index);
	}
	public String[] getArtists()						//hämtar artister från tracksen
	{
		String[] ret = new String[this.getLength()];
		for(int i = 0; i < this.getLength(); i++)
		{
			ret[i] = trackList.get(i).getArtist();
		}
		return ret;
	}
	public String[] getTrackNames(LinkedList<Track> tracks)			//hämtar titlarna
	{
		String[] ret = new String[this.getLength()];
		for(int i = 0; i < this.getLength(); i++)
		{
			ret[i] = trackList.get(i).getTitle();
		}
		return ret;
	}
	public String[] getAlbums(LinkedList<Track> tracks)				//hämtar album
	{
		String[] ret = new String[this.getLength()];
		for(int i = 0; i < this.getLength(); i++)
		{
			ret[i] = trackList.get(i).getAlbum();
		}
		return ret;
	}
	public Object[] getTracks()
	{
		return trackList.toArray();
	}
	public int getLength()										//hämtar längden på tracklistan
	{
		return trackList.size();
	}
}