package com.example.soundz;

//En k� av l�tar. H�ller koll p� var i k�n uppspelningen �r just nu och kan ge vilken som �r n�sta l�t. Implementerad med LinkedList.
class PlayQueue extends TrackList{
	
	private int currentTrack = 0;
	
	public Track getCurrentTrack(){
		//Ger den l�t som spelas nu.
		
	}
	
	public String getCurrentPath(){
		//Ger s�kv�gen till den l�t som spelas nu.
		trackList.get(currentTrack);
	}
	
	public void nextTrack(){
		//Byter till n�sta l�t.
		currentTrack ++;
	}
	
	public void previousTrack(){
		//G�r till f�reg�ende l�t.
		if(currentTrack > 0){
			currentTrack = currentTrack - 1;
		}
	}
	
	public void loopOn(){
		//Sl� p� loop.
		
	}
	
	public void loopOff(){
		//Sl� av loop.
		
	}
	
	public void shuffle(){
		//Blandar om k�n.
		
	}
	
	public void jumpTo(int index){
		//Hopper till l�t nummer index.
		
	}
	
	public void clear(){
		//T�mmer k�n.
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}