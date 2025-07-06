package zuzz.projects.medical_appointment_booking_system.domain.valueobject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AddressTest {

    @Test
    void shouldReturnFullAddress() {
        Address address = new Address.Builder()
            .street("Av. Arquitectos km 39")
            .district("Ventanilla")
            .province("Callao")
            .department("Lima")
            .postalCode("07076")
            .reference("Dos cuadras abajo del colegio Francisco Bolognesi")
            .build();

        String expected = """
            Av. Arquitectos km 39
            Ventanilla, Callao, Lima
            07076
            Referencia: Dos cuadras abajo del colegio Francisco Bolognesi""";
        String actual = address.getFullAddress();

        assertEquals(expected, actual);
        assertEquals("Lima", address.getDepartment());
        assertEquals("Callao", address.getProvince());
        assertEquals("Ventanilla", address.getDistrict());
        assertEquals("Av. Arquitectos km 39", address.getStreet());
        assertEquals("07076", address.getPostalCode());
        assertEquals("Dos cuadras abajo del colegio Francisco Bolognesi", address.getReference());
    }
}
