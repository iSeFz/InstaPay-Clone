public class ElectricityBill extends Bill {
    public ElectricityBill() {
    }

    public ElectricityBill(float amount, String date, Boolean status) {
        super(amount, date, status);
    }

    @Override
    public void printBill() {
        System.out.println("Electricity bill");
        System.out.println("Amount: " + getAmount());
        System.out.println("Date: " + getDate());
        System.out.println("Status: " + getStatus());
    }

    @Override
    public void createBill() {
        // generate electricity bill between 50 and 500
        float amount = (float) (Math.random() * 450 + 50);
        String date = "2023-12-01";
        Boolean status = false;
        setAmount(amount);
        setDate(date);
        setStatus(status);
    }
}
