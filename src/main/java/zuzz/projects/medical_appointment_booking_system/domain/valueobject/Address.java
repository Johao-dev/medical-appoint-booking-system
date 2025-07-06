package zuzz.projects.medical_appointment_booking_system.domain.valueobject;

public class Address {

    private String street;
    private String district;
    private String province;
    private String reference;
    private String department;
    private String postalCode;

    private Address(Builder builder) {
        this.street = builder.street;
        this.district = builder.district;
        this.province = builder.province;
        this.department = builder.department;
        this.reference = builder.reference;
        this.postalCode = builder.postalCode;
    }

    public static class Builder {
        private String street;
        private String district;
        private String province;
        private String reference;
        private String department;
        private String postalCode;

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Builder district(String district) {
            this.district = district;
            return this;
        }

        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Builder reference(String reference) {
            this.reference = reference;
            return this;
        }

        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder province(String province) {
            this.province = province;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getFullAddress() {
        StringBuilder address = new StringBuilder();
        address.append(street);
        address.append("\n");
        address.append(district);
        address.append(", ");
        address.append(province);
        address.append(", ");
        address.append(department);
        address.append("\n");
        address.append(postalCode);
        address.append("\n");
        address.append("Referencia: ");
        address.append(reference);

        return address.toString();
    }
}
