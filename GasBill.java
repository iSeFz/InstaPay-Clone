public class GasBill extends Bill {
    public GasBill(float amount, String date, Boolean status) {
        super(amount, date, status);
    }

    @Override
    public void printBill() {
        System.out.println("Gas bill");
        System.out.println("Amount: " + this.getAmount());
        System.out.println("Date: " + this.getDate());
        System.out.println("Status: " + this.getStatus());
    }

    @Override
    public void createBill() {
        // generate bill for gas between 50 and 100
        float amount = (float) (Math.random() * (100 - 50 + 1) + 50);
        String date = "2023-12-01";
        Boolean status = false;
        setAmount(amount);
        setDate(date);
        setStatus(status);
        System.out.println("Gas bill created");
    }

    @Override
    public void deducateBill() {
        // deduct bill for gas
    }
}
