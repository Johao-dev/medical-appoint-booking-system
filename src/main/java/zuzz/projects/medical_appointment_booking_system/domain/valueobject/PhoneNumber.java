package zuzz.projects.medical_appointment_booking_system.domain.valueobject;

public class PhoneNumber {

    private String number;
    private String countryCode;

    public PhoneNumber(String countryCode, String number) {
        this.countryCode = countryCode;
        this.number = number;
    }

    public PhoneNumber() {

    }

    public String getFullNumber() {
        StringBuilder numberBuilder = new StringBuilder();
        numberBuilder.append(countryCode);
        numberBuilder.append(" ");
        numberBuilder.append(number);

        return numberBuilder.toString();
    }

    public boolean isValid() {
        return isValidCountryCode(countryCode) && isValidNumber(number);
    }

    private boolean isValidCountryCode(String countryCode) {
        return countryCode.matches("\\+[0-9]{1,3}");
    }

    private boolean isValidNumber(String number) {
        return number.matches("[0-9]{9}");
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((number == null) ? 0 : number.hashCode());
        result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PhoneNumber other = (PhoneNumber) obj;
        if (number == null) {
            if (other.number != null)
                return false;
        } else if (!number.equals(other.number))
            return false;
        if (countryCode == null) {
            if (other.countryCode != null)
                return false;
        } else if (!countryCode.equals(other.countryCode))
            return false;
        return true;
    }
}
