public class Artist extends Person{
    
    private String specialty, status, priceRange;

    public String getSpecialty()
    {
        return specialty;
    }

    public void setSpecialty(String specialty)
    {
        this.specialty = specialty;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getPriceRange()
    {
        return priceRange;
    }

    public void setPriceRange(String priceRange)
    {
        this.priceRange = priceRange;
    }

    public Artist(String name, int age, String specialty, String status, String priceRange)
    {
        super(name, age);
        this.specialty = specialty;
        this.status = status;
        this.priceRange = priceRange;
    }
}
