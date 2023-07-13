package Eivonne;

import java.util.ArrayList;

public class Artist {

	private String specialty;
	private String status;
	private String priceRange;
	private ArrayList <Artist> artist;
	
	public Artist()
	{
		
	}
	public Artist(String specialty, String priceRange)
	{
		this.specialty =specialty;
		this.status ="alive";
		this.priceRange =priceRange;
		artist = new ArrayList<Artist>();
	}
	
	public String getSpecialty()
	{
		return specialty;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public String getPriceRange()
	{
		return priceRange;
	}
	
	public ArrayList <Artist> getArtist()
	{
		return artist;
	}
	
	public void setSpecialty(String specialty)
	{
		this.specialty =specialty;
	}
	
	public void setStatus(String status)
	{
		this.status =status;
	}
	
	public void setPriceRange(String priceRange)
	{
		this.priceRange =priceRange;
	}
	
	public void setArtist(ArrayList<Artist> artist)
	{
		this.artist = artist;
	}
	
	
}
