package zuzz.projects.medical_appointment_booking_system.domain.valueobject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PhoneNumberTest {

    @Test
    void shouldReturnFullNumber() {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setCountryCode("+51");
        phoneNumber.setNumber("123456789");

        String expected = "+51 123456789";
        String actual = phoneNumber.getFullNumber();

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnTrueifCountryCodeAndNumberAreValid() {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setCountryCode("+51");
        phoneNumber.setNumber("123456789");

        assertEquals(true, phoneNumber.isValid());
    }

    @Test
    void shouldReturnFalseIfCountryCodeIsNotValid() {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setCountryCode("-5123");
        phoneNumber.setNumber("123456789");

        assertEquals(false, phoneNumber.isValid());
    }

    @Test
    void shouldReturnFalseIfNumberIsNotValid() {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setCountryCode("+51");
        phoneNumber.setNumber("1234567891011");

        assertEquals(false, phoneNumber.isValid());
    }
}
