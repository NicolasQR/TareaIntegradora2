package model;

public class PublicPlaylist extends Playlist{
	private int grade;
	private int quantityOfGrades;
	private int generalGrades;
	
	/*
	 * Description This is the constructor method of the PlayList class
	 * @param name, the name of the public playList
	 * @param mins, the minutes of the public playList
	 * @param secs, the seconds of the public playList
	 */
	public PublicPlaylist(String name, int mins, int secs) {
		super(name, mins, secs);
		publicPlaylist = true;
	}
	/*
	 * Description This method gets the grade of the PublicPlayList
	 * @return The name of the PublicPlayList
	 */
	public int getGrade() {
		return grade;
	}
	/*
	 * Description This method sets the grade of the PublicPlayList
	 * @param grade, the grade of the PublicPlayList
	 */
	public void setGrade(int grade) {
		quantityOfGrades += 1;
		generalGrades += grade;
		this.grade = generalGrades/quantityOfGrades;
	}
}