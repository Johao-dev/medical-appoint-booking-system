package zuzz.projects.medical_appointment_booking_system.domain.valueobject;

public class PhoneNumber {

    private String number;
    private String countryCode;

    public PhoneNumber() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isValid() {
        return isValidCountryCode(countryCode) && isValidNumber(number);
    }
    
    public String getFullNumber() {
        StringBuilder numberBuilder = new StringBuilder();
        numberBuilder.append(countryCode);
        numberBuilder.append(" ");
        numberBuilder.append(number);

        return numberBuilder.toString();
    }

    private boolean isValidCountryCode(String countryCode) {
        return countryCode.matches("\\+[0-9]{1,3}");
    }

    private boolean isValidNumber(String number) {
        return number.matches("[0-9]{9}");
    }
}
