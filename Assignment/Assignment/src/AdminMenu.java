public abstract class AdminMenu {
    
    protected String username, password;

    public abstract void viewInfo();
    public abstract void addInfo() throws Exception;
    public abstract void removeInfo();
    public abstract void modifyInfo();
}
