package switchtwentytwenty.project.dto.person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputProfileDTOTest {
    OutputProfileDTO profileOutputDTO = new OutputProfileDTO();
    String ID = "tony@gmail.com";
    String NAME = "Tony";
    String BIRTHDATE = "12/12/1222";
    String EMAIL = "email@gmail.com";
    Integer PHONE = 919999999;
    Integer VAT = 123456789;
    String CITY = "City";
    String STREET = "Street";
    String HOUSENUMBER = "123A";
    String ZIPCODE = "1234-123";

    @Test
    @DisplayName("Test to determine the correct function of the getEmail method")
    void getEmail() {
        profileOutputDTO.setEmail(EMAIL);
        String expected = "email@gmail.com";
        String result = profileOutputDTO.getEmail();

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test to determine the correct function of the getName method")
    void getName() {
        profileOutputDTO.setName(NAME);
        String expected = "Tony";
        String result = profileOutputDTO.getName();

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test to determine the correct function of the geBirthDate method")
    void getBirthDate() {
        profileOutputDTO.setBirthDate(BIRTHDATE);
        String expected = "12/12/1222";
        String result = profileOutputDTO.getBirthDate();

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test to determine the correct function of the getVatNumber method")
    void getVatNumber() {
        profileOutputDTO.setVatNumber(VAT);
        Integer expected = 123456789;
        Integer result = profileOutputDTO.getVatNumber();

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test to determine the correct function of the getPhoneNumber method")
    void getPhoneNumber() {
        profileOutputDTO.setPhoneNumber(PHONE);
        Integer expected = 919999999;
        Integer result = profileOutputDTO.getPhoneNumber();

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should return true if two identical ProfileOutputDTO objects are compared with the equals method")
    void testEquals() {
        OutputProfileDTO profileOutputDTOOne = new OutputProfileDTO(EMAIL, NAME, BIRTHDATE, VAT, PHONE, STREET, CITY, HOUSENUMBER, ZIPCODE);
        OutputProfileDTO profileOutputDTOTwo = new OutputProfileDTO(EMAIL, NAME, BIRTHDATE, VAT, PHONE, STREET, CITY, HOUSENUMBER, ZIPCODE);

        Assertions.assertEquals(profileOutputDTOOne, profileOutputDTOTwo);
        Assertions.assertNotSame(profileOutputDTOOne, profileOutputDTOTwo);
    }

    @Test
    @DisplayName("Should return false if two ProfileOutputDTO objects with different emails are compared with the equals method")
    void testEqualsFalseDifferentEmail() {
        OutputProfileDTO profileOutputDTOOne = new OutputProfileDTO("diffemail@gmail.com", NAME, BIRTHDATE, VAT, PHONE, STREET, CITY, HOUSENUMBER, ZIPCODE);
        OutputProfileDTO profileOutputDTOTwo = new OutputProfileDTO(EMAIL, NAME, BIRTHDATE, VAT, PHONE, STREET, CITY, HOUSENUMBER, ZIPCODE);

        Assertions.assertNotEquals(profileOutputDTOOne, profileOutputDTOTwo);
    }

    @Test
    @DisplayName("Should return false if two ProfileOutputDTO objects with different names are compared with the equals method")
    void testEqualsFalseDifferentName() {
        OutputProfileDTO profileOutputDTOOne = new OutputProfileDTO(EMAIL, "otherName", BIRTHDATE, VAT, PHONE, STREET, CITY, HOUSENUMBER, ZIPCODE);
        OutputProfileDTO profileOutputDTOTwo = new OutputProfileDTO(EMAIL, NAME, BIRTHDATE, VAT, PHONE, STREET, CITY, HOUSENUMBER, ZIPCODE);

        Assertions.assertNotEquals(profileOutputDTOOne, profileOutputDTOTwo);
    }

    @Test
    @DisplayName("Should return false if two ProfileOutputDTO objects with different birthDates are compared with the equals method")
    void testEqualsFalseDifferentBirthDates() {
        OutputProfileDTO profileOutputDTOOne = new OutputProfileDTO(EMAIL, NAME, "01/01/1970", VAT, PHONE, STREET, CITY, HOUSENUMBER, ZIPCODE);
        OutputProfileDTO profileOutputDTOTwo = new OutputProfileDTO(EMAIL, NAME, BIRTHDATE, VAT, PHONE, STREET, CITY, HOUSENUMBER, ZIPCODE);

        Assertions.assertNotEquals(profileOutputDTOOne, profileOutputDTOTwo);
    }

    @Test
    @DisplayName("Should return false if two ProfileOutputDTO objects with different VATNumbers are compared with the equals method")
    void testEqualsFalseDifferentVATNumbers() {
        OutputProfileDTO profileOutputDTOOne = new OutputProfileDTO(EMAIL, NAME, BIRTHDATE, 111111111, PHONE, STREET, CITY, HOUSENUMBER, ZIPCODE);
        OutputProfileDTO profileOutputDTOTwo = new OutputProfileDTO(EMAIL, NAME, BIRTHDATE, VAT, PHONE, STREET, CITY, HOUSENUMBER, ZIPCODE);

        Assertions.assertNotEquals(profileOutputDTOOne, profileOutputDTOTwo);
    }

    @Test
    @DisplayName("Should return false if two ProfileOutputDTO objects with different PhoneNumbers are compared with the equals method")
    void testEqualsFalseDifferentPhoneNumbers() {
        OutputProfileDTO profileOutputDTOOne = new OutputProfileDTO(EMAIL, NAME, BIRTHDATE, VAT, 111111111, STREET, CITY, HOUSENUMBER, ZIPCODE);
        OutputProfileDTO profileOutputDTOTwo = new OutputProfileDTO(EMAIL, NAME, BIRTHDATE, VAT, PHONE, STREET, CITY, HOUSENUMBER, ZIPCODE);

        Assertions.assertNotEquals(profileOutputDTOOne, profileOutputDTOTwo);
    }

    @Test
    @DisplayName("Should return false if two ProfileOutputDTO objects with different streets are compared with the equals method")
    void testEqualsFalseDifferentStreets() {
        OutputProfileDTO profileOutputDTOOne = new OutputProfileDTO(EMAIL, NAME, BIRTHDATE, VAT, PHONE, "other street", CITY, HOUSENUMBER, ZIPCODE);
        OutputProfileDTO profileOutputDTOTwo = new OutputProfileDTO(EMAIL, NAME, BIRTHDATE, VAT, PHONE, STREET, CITY, HOUSENUMBER, ZIPCODE);

        Assertions.assertNotEquals(profileOutputDTOOne, profileOutputDTOTwo);
    }

    @Test
    @DisplayName("Should return false if two ProfileOutputDTO objects with different cities are compared with the equals method")
    void testEqualsFalseDifferentCity() {
        OutputProfileDTO profileOutputDTOOne = new OutputProfileDTO(EMAIL, NAME, BIRTHDATE, VAT, PHONE, STREET, "other City", HOUSENUMBER, ZIPCODE);
        OutputProfileDTO profileOutputDTOTwo = new OutputProfileDTO(EMAIL, NAME, BIRTHDATE, VAT, PHONE, STREET, CITY, HOUSENUMBER, ZIPCODE);

        Assertions.assertNotEquals(profileOutputDTOOne, profileOutputDTOTwo);
    }

    @Test
    @DisplayName("Should return false if two ProfileOutputDTO objects with different houseNumbers are compared with the equals method")
    void testEqualsFalseDifferentHouseNumber() {
        OutputProfileDTO profileOutputDTOOne = new OutputProfileDTO(EMAIL, NAME, BIRTHDATE, VAT, PHONE, STREET, CITY, "111C", ZIPCODE);
        OutputProfileDTO profileOutputDTOTwo = new OutputProfileDTO(EMAIL, NAME, BIRTHDATE, VAT, PHONE, STREET, CITY, HOUSENUMBER, ZIPCODE);

        Assertions.assertNotEquals(profileOutputDTOOne, profileOutputDTOTwo);
    }

    @Test
    @DisplayName("Should return false if two ProfileOutputDTO objects with different zipCodes are compared with the equals method")
    void testEqualsFalseDifferentZipCodes() {
        OutputProfileDTO profileOutputDTOOne = new OutputProfileDTO(EMAIL, NAME, BIRTHDATE, VAT, PHONE, STREET, CITY, HOUSENUMBER, "4000-001");
        OutputProfileDTO profileOutputDTOTwo = new OutputProfileDTO(EMAIL, NAME, BIRTHDATE, VAT, PHONE, STREET, CITY, HOUSENUMBER, ZIPCODE);

        Assertions.assertNotEquals(profileOutputDTOOne, profileOutputDTOTwo);
    }

    @Test
    void testEqualsSameProfileOutputDTO() {
        OutputProfileDTO profileOutputDTOOne = new OutputProfileDTO(EMAIL, NAME, BIRTHDATE, VAT, PHONE, STREET, CITY, HOUSENUMBER, ZIPCODE);
        OutputProfileDTO profileOutputDTOTwo = profileOutputDTOOne;

        Assertions.assertEquals(profileOutputDTOOne, profileOutputDTOTwo);
    }

    @Test
    void testEqualsDifferentObjects() {
        OutputProfileDTO profileOutputDTO = new OutputProfileDTO(EMAIL, NAME, BIRTHDATE, VAT, PHONE, STREET, CITY, HOUSENUMBER, ZIPCODE);
        String notProfileOutputDTO = "test String";

        Assertions.assertNotEquals(profileOutputDTO, notProfileOutputDTO);
    }

    @Test
    void testEqualsDifferentFromNull() {
        OutputProfileDTO profileOutputDTO = new OutputProfileDTO(EMAIL, NAME, BIRTHDATE, VAT, PHONE, STREET, CITY, HOUSENUMBER, ZIPCODE);

        Assertions.assertNotEquals(null,profileOutputDTO);
    }

    @Test
    @DisplayName("Should return true if two identical ProfileOutputDTO objects have their hashcodes compared")
    void testHashCode() {
        OutputProfileDTO profileOutputDTOOne = new OutputProfileDTO(EMAIL, NAME, BIRTHDATE, VAT, PHONE, STREET, CITY, HOUSENUMBER, ZIPCODE);
        OutputProfileDTO profileOutputDTOTwo = new OutputProfileDTO(EMAIL, NAME, BIRTHDATE, VAT, PHONE, STREET, CITY, HOUSENUMBER, ZIPCODE);

        Assertions.assertEquals(profileOutputDTOOne.hashCode(), profileOutputDTOTwo.hashCode());
        Assertions.assertNotSame(profileOutputDTOOne, profileOutputDTOTwo);
    }

    @Test
    @DisplayName("Should return false if two different ProfileOutputDTO objects have their hashcodes compared")
    void testHashCodeFalse() {
        OutputProfileDTO profileOutputDTOOne = new OutputProfileDTO("diffemail@gmail.com", NAME, BIRTHDATE, VAT, PHONE, STREET, CITY, HOUSENUMBER, ZIPCODE);
        OutputProfileDTO profileOutputDTOTwo = new OutputProfileDTO(EMAIL, NAME, BIRTHDATE, VAT, PHONE, STREET, CITY, HOUSENUMBER, ZIPCODE);

        Assertions.assertNotEquals(profileOutputDTOOne.hashCode(), profileOutputDTOTwo.hashCode());
    }

    @Test
    @DisplayName("Test to determine the correct function of the getCity method")
    void getCity() {
        profileOutputDTO.setCity(CITY);
        String expected = "City";
        String result = profileOutputDTO.getCity();

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test to determine the correct function of the getAddressNumber method")
    void getAddressNumber() {
        profileOutputDTO.setAddressNumber(HOUSENUMBER);
        String expected = "123A";
        String result = profileOutputDTO.getAddressNumber();

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test to determine the correct function of the getZipCode method")
    void getZipCode() {
        profileOutputDTO.setZipCode(ZIPCODE);
        String expected = "1234-123";
        String result = profileOutputDTO.getZipCode();

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test to determine the correct function of the getStreet method")
    void getStreet() {
        profileOutputDTO.setStreet(STREET);
        String expected = "Street";
        String result = profileOutputDTO.getStreet();

        Assertions.assertEquals(expected, result);
    }
}