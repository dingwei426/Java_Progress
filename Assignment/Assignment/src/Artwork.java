public class Artwork {
    
    private String title, datePurchased, dateSold;
    private Artist artist;
    private boolean isSold;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDatePurchased()
    {
        return datePurchased;
    }

    public void setDatePurchased(String datePurchased)
    {
        this.datePurchased = datePurchased;
    }

    public String getDateSold()
    {
        return dateSold;
    }

    public void setDateSold(String dateSold)
    {
        this.dateSold = dateSold;
    }

    public Artist getArtist()
    {
        return artist;
    }

    public void setArtist(Artist artist)
    {
        this.artist = artist;
    }

    public boolean getIsSold()
    {
        return isSold;
    }

    public void setIsSold(boolean isSold)
    {
        this.isSold = isSold;
    }

    public Artwork(String title, String datePurchased, String dateSold, Artist artist, boolean isSold)
    {
        this.title = title;
        this.datePurchased = datePurchased;
        this.dateSold = dateSold;
        this.artist = artist;
        this.isSold = isSold;
    }

}
