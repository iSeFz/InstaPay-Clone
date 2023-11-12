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

    public Boolean getType() {
        return status;
    }

    public abstract void printBill();

    public abstract void createBill();

    public abstract void deducateBill();

    protected void setAmount(float amount) {
        this.amount = amount;
    }
}
