public abstract class Bill {
    private float amount;
    private String date;
    private Boolean status;

    public Bill(float amount, String date, Boolean status) {
        this.amount = amount;
        this.date = date;
        this.status = status;
    }

    public float getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public Boolean getStatus() {
        return status;
    }

    protected void setAmount(float amount) {
        this.amount = amount;
    }

    protected void setDate(String date) {
        this.date = date;
    }

    protected void setStatus(Boolean status) {
        this.status = status;
    }
    public abstract void printBill();

    public abstract void createBill();

    public abstract Boolean deducateBill();
}