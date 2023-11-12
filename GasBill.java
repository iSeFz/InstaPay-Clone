public class GasBill extends Bill{
    public GasBill(float amount, String date, Boolean status) {
        super(amount, date, status);
    }

    @Override
    public void printBill() {
        // method to print gas bill
        System.out.println("Gas bill: " + this.getAmount());
    }

    @Override
    public void createBill() {
        // method to generate random gas bill  between 50 and 100
        float amount = (float) (Math.random() * (100 - 50 + 1) + 50);
        this.setAmount(amount);
    }

    @Override
    public void deducateBill() {
        // method to deduct gas bill from bank account
    }
}
