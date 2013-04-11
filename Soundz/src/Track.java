import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import android.os.Build;


// Writen my Theo and also siversgay some. plz dounut steal.
public class Track {
	
	// metadata key constants:
	private static final int METADATA_KEY_ALBUM=1;
	private static final int METADATA_KEY_ARTIST=2;
	private static final int METADATA_KEY_BITRATE=20;
	private static final int METADATA_KEY_CD_TRACK_NUMBER=0;
	private static final int METADATA_KEY_DURATION=9;
	private static final int METADATA_KEY_DISC_NUMBER=14;
	private static final int METADATA_KEY_GENRE=6;
	private static final int METADATA_KEY_TITLE=7;
	private static final int METADATA_KEY_YEAR=8;
			
	// varibles for variabling:
	private String path;
	private String artist;
	private String genre;
	private String album;
	private String duration;
	private int year;
	private int tracknumber;
	private int cdnumber;
	private String title;
	
	// Extracting metadata from mp3 at path.
	public Track (String path){
		MediaMetadataRetriever reader=new MediaMetadataRetriever();
		reader.setDataSource(path);
		this.path=path;
		this.artist=reader.extractMetadata(METADATA_KEY_ARTIST);
		this.genre=reader.extractMetadata(METADATA_KEY_GENRE);
		this.album=reader.extractMetadata(METADATA_KEY_ALBUM);
		this.duration=reader.extractMetadata(METADATA_KEY_DURATION);
		this.year=Integer.parseInt(reader.extractMetadata(METADATA_KEY_YEAR));
		this.tracknumber=Integer.parseInt(reader.extractMetadata(METADATA_KEY_CD_TRACK_NUMBER));
		this.cdnumber=Integer.parseInt(reader.extractMetadata(METADATA_KEY_DISC_NUMBER));
		this.title=reader.extractMetadata(METADATA_KEY_TITLE);
		
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
}
