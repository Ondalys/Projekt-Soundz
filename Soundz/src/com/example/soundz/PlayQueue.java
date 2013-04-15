package com.example.soundz;

//En kö av låtar. Håller koll på var i kön uppspelningen är just nu och kan ge vilken som är nästa låt. Implementerad med LinkedList.
class PlayQueue extends TrackList{
	
	private int currentTrack = 0;
	
	public Track getCurrentTrack(){
		//Ger den låt som spelas nu.
		
	}
	
	public String getCurrentPath(){
		//Ger sökvägen till den låt som spelas nu.
		trackList.get(currentTrack);
	}
	
	public void nextTrack(){
		//Byter till nästa låt.
		currentTrack ++;
	}
	
	public void previousTrack(){
		//Går till föregående låt.
		if(currentTrack > 0){
			currentTrack = currentTrack - 1;
		}
	}
	
	public void loopOn(){
		//Slå på loop.
		
	}
	
	public void loopOff(){
		//Slå av loop.
		
	}
	
	public void shuffle(){
		//Blandar om kön.
		
	}
	
	public void jumpTo(int index){
		//Hopper till låt nummer index.
		
	}
	
	public void clear(){
		//Tömmer kön.
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}