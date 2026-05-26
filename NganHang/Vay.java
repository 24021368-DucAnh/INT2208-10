package NganHang;

public class Vay{
    public String processLoan(int age, double income, int creditScore, String employment) {
        if (age < 18 || age > 65) return "Invalid Input";
        if (income < 5.0 || income > 500.0) return "Invalid Input";
        if (creditScore < 300 || creditScore > 850) return "Invalid Input";
        if (!employment.equals("C") && !employment.equals("F")) return "Invalid Input";

        String risk;
        if (creditScore <= 500) {
            risk = "High";
        } else if (creditScore <= 700) {
            risk = "Medium";
        } else {
            risk = "Low";
        }

        if (risk.equals("High")) {
            return "REJECT";
        }

        if (income < 15.0) {
            if (employment.equals("F") || risk.equals("Medium")) {
                return "REJECT";
            }
            return "MANUAL REVIEW";
        } else {
            if (employment.equals("C")) {
                return "APPROVE";
            } else {
                return "MANUAL REVIEW";
            }
        }
    }
}