package model;

import java.util.Date;

public class Song {
	private String title;
	private String artist;
	private Date date;
	private String duration;
	private int mins;
	private int secs;
	private Genre genre;
	
	public Song(String title, String artist, Date date, int mins, int secs, Genre genre) {
		this.title = title;
		this.artist = artist;
		this.date = date;
		this.mins = mins;
		this.secs = secs;
		setDuration(mins, secs);;
		this.genre = genre;
	}
	
	/*
	 * Description This method gets song title
	 * @return Title of the song
	 */
	public String getTitle() {
		return title;
	}
	
	/*
	 * Description This method sets song title
	 * @param title, song title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/*
	 * Description This method gets song artist
	 * @return artist of the song
	 */
	public String getArtist() {
		return artist;
	}
	
	/*
	 * Description This method sets song artist
	 * @param artist, song artist 
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	/*
	 * Description This method gets song date
	 * @return date of the song
	 */
	public Date getDate() {
		return date;
	}
	
	/*
	 * Description This method sets song date
	 * @param date, song date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/*
	 * Description This method gets song duration
	 * @return duration of the song
	 */
	public String getDuration() {
		return duration;
	}
}