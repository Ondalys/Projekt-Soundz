package com.example.soundz;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;


// Writen my Theo and also sieversgay some. plz dounut steal.
public class Track {
			
	// varibles for variabling:
	private String path;
	private String artist="Unknown";
	private String genre="Unknown";
	private String album="Unknown";
	private String duration="";
	private int durationValue=0;
	private int year=0;
	private int tracknumber=0;
	private int cdnumber=0;
	private String title="Unknown";
	private byte[] art;
	
	// Extracting metadata from mp3 at path.
	public Track (String path){
		MediaMetadataRetriever reader=new MediaMetadataRetriever();
		reader.setDataSource(path);
		try{
			this.path=path;}
			catch (Exception e){}
		try{
			this.artist=reader.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);}
			catch (Exception e){}
		try{
			this.genre=reader.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE);}
			catch (Exception e){}
		try{
			this.album=reader.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);}
			catch (Exception e){}
		try{
			this.durationValue=Integer.parseInt(reader.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));}
			catch (Exception e){}
		try{
			this.duration=(durationValue/60000) + ":"+(durationValue/1000)%60;}
			catch (Exception e){}
		try{
			this.year=Integer.parseInt(reader.extractMetadata(MediaMetadataRetriever.METADATA_KEY_YEAR));}
			catch (Exception e){}
		try{
			this.tracknumber=Integer.parseInt(reader.extractMetadata(MediaMetadataRetriever.METADATA_KEY_CD_TRACK_NUMBER));}
			catch (Exception e){}
		try{
			this.cdnumber=Integer.parseInt(reader.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DISC_NUMBER));}
			catch (Exception e){}
		try{
			this.title=reader.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);}
			catch (Exception e){}
		try{
			this.art=reader.getEmbeddedPicture();}
			catch (Exception e){
				// TODO: set art to standard picture
			}
		
	}
	
	//Get functions:
	String getPath(){
		return this.path;
	}
	String getArtist(){
		return this.artist;
	}
	String getGenre(){
		return this.genre;
	}
	String getAlbum(){
		return this.album;
	}
	String getTitle(){
		return this.title;
	}
	String getDuration(){
		return this.duration;
	}
	int getYear(){
		return this.year;
	}
	int getTracknumber(){
		return this.tracknumber;
	}
	int getCDNumber(){
		return this.cdnumber;
	}
	int getDurationValue(){
		return this.durationValue;
	}
	
	//converts byte array to bitmap. art is stored as byte array for memory reason
	Bitmap getArt(){
		try{
			return BitmapFactory.decodeByteArray(this.art, 0, this.art.length);}
		catch(Exception e){
			return null;}
	}
}
