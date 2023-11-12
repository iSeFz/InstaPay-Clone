public class WaterBill extends Bill {
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
        String date = "2020-10-10";
        Boolean status = false;
        setAmount(amount);
        setDate(date);
        setStatus(status);
        System.out.println("Water bill created");
    }

    @Override
    public void deducateBill() {
        // deducate water bill
        if (getStatus()) {
            System.out.println("Water bill has been deducated");
        } else {
            System.out.println("Water bill has not been deducated");
    }
}
}
