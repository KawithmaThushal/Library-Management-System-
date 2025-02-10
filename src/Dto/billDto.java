package Dto;

public class billDto {
    private String BID;
    private String MID;
    private int ExpireDates;
    private double Amount;
    public String getBID() {
        return BID;
    }
    public void setBID(String bID) {
        BID = bID;
    }
    public String getMID() {
        return MID;
    }
    public void setMID(String mID) {
        MID = mID;
    }
    public int getExpireDates() {
        return ExpireDates;
    }
    public void setExpireDates(int expireDates) {
        ExpireDates = expireDates;
    }
    public double getAmount() {
        return Amount;
    }
    public void setAmount(float amount) {
        Amount = amount;
    }
    public billDto() {
    }
    public billDto(String bID, String mID, int expireDates, double amount) {
        BID = bID;
        MID = mID;
        ExpireDates = expireDates;
        Amount = amount;
    }
    @Override
    public String toString() {
        return "bill [BID=" + BID + ", MID=" + MID + ", ExpireDates=" + ExpireDates + ", Amount=" + Amount + "]";
    }

    
}
