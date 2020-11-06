package model;

import java.util.Date;

public class App {
	private User[] users;
	private Song[] poolOfSongs;
	private Playlist[] playlists;
	
	public static final int SIZE_OF_USERS = 10;
	public static final int AMOUNT_OF_SONGS = 30;
	public static final int AMOUNT_OF_PLAYLISTS = 20;
	
	/*
	*Description This is the constructor method of the App class
	**/
	
	public App() {
		users = new User[SIZE_OF_USERS];
		poolOfSongs = new Song[AMOUNT_OF_SONGS];
		playlists = new Playlist[AMOUNT_OF_PLAYLISTS];
	}
	
}