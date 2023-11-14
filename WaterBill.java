public class WaterBill extends Bill {
    public WaterBill() { }
    public WaterBill(float amount, String date, Boolean status) {
        super(amount, date, status);
    }

    @Override
    public void printBill() {
        System.out.println("Water bill");
        System.out.println("Amount: " + getAmount());
        System.out.println("Date: " + getDate());
        System.out.println("Status: " + getStatus());
    }

    @Override
    public void createBill() {
        // generate water bill between 100 and 500
        float amount = (float) (Math.random() * 400 + 100);
        String date = "2023-12-1";
        Boolean status = false;
        setAmount(amount);
        setDate(date);
        setStatus(status);
        System.out.println("Water bill created");
    }

    @Override
    public Boolean deducateBill() {
        if (!getStatus()) {
            System.out.println("Water bill has been deducated");
            return true;
        } else {
            System.out.println("Water bill has not been deducated");
            return false;
        }
    }
}
