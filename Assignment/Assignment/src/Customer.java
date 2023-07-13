public class Customer extends Person{
    
    private String contactNum, artistPreference;
    private String[] artworkPurchases;

    public String getContactNum()
    {
        return contactNum;
    }

    public void setContactNum(String contactNum)
    {
        this.contactNum = contactNum;
    }

    public String getArtistPreference()
    {
        return artistPreference;
    }

    public void setArtistPreference(String artistPreference)
    {
        this.artistPreference = artistPreference;
    }

    public String[] getArtworkPurchase()
    {
        return artworkPurchases;
    }

    public void setArtworkPurchase(String[] artworkPurchases)
    {
        this.artworkPurchases = artworkPurchases;
    }

    public Customer(String name, int age, String contactNum, String artistPreference, String[] artworkPurchases)
    {
        super(name, age);
        this.contactNum = contactNum;
        this.artistPreference = artistPreference;
        this.artworkPurchases = artworkPurchases;
    }

}