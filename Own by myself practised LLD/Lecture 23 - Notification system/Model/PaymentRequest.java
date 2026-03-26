package Model;

public class PaymentRequest {
    String sender;
    String reciever;
    int amount;
    String currency;

    
    public PaymentRequest(String sender, String reciever, int amount, String currency) {
        this.sender = sender;
        this.reciever = reciever;
        this.amount = amount;
        this.currency = currency;
    }
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getReciever() {
        return reciever;
    }
    public void setReciever(String reciever) {
        this.reciever = reciever;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    


}
