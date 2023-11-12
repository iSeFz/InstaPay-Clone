import java.util.Random;

public class OTP {
    private String otp;
    public String generateOTP() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 7; i++) {
            sb.append(random.nextInt(10));
        }

        this.otp = sb.toString();
        return otp;
    }

    public String getOTP() {
        return otp;
    }

    public void sendOTP() {
        System.out.println("OTP sent Is: " + otp);
    }

    public boolean verifyOTP(String otp) {
        return this.otp.equals(otp);
    }

}
