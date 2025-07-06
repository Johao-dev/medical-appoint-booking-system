package zuzz.projects.medical_appointment_booking_system.domain.valueobject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AddressTest {

    @Test
    void shouldReturnFullAddress() {
        Address address = new Address.Builder()
            .street("Av. 123 km 12")
            .district("Distrito 1")
            .province("Provincia 1")
            .department("Departamento 1")
            .postalCode("01234")
            .reference("Referencia 1")
            .build();

        String expected = """
            Av. 123 km 12
            Distrito 1, Provincia 1, Departamento 1
            01234
            Referencia: Referencia 1""";

        String actual = address.getFullAddress();

        assertEquals(expected, actual);
        assertEquals("Departamento 1", address.getDepartment());
        assertEquals("Provincia 1", address.getProvince());
        assertEquals("Distrito 1", address.getDistrict());
        assertEquals("Av. 123 km 12", address.getStreet());
        assertEquals("01234", address.getPostalCode());
        assertEquals("Referencia 1", address.getReference());
    }
}
