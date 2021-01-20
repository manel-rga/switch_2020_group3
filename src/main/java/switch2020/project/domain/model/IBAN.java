package switch2020.project.domain.model;

import java.util.Objects;
import java.util.regex.Pattern;

public class IBAN {

    private String ibanNumber;


    public IBAN(String iban) {
        if (validate(iban)) {
            this.ibanNumber = iban;
        } else {
            throw new IllegalArgumentException("Invalid IBAN number");
        }
    }

    private boolean validate(String iban) {
        if (iban == null)
            return false;
        if (iban.isEmpty() || iban.isBlank())
            return false;
        return checkFormat(iban);
    }

    private boolean checkFormat(String iban) {
        String ibanRegex = "/^(?:(?:IT|SM)\\d{2}[A-Z]\\d{22}|CY\\d{2}[A-Z]\\d{23}|NL\\d{2}[A-Z]{4}\\d{10}|LV\\d{2}[A-Z]{4}\\d{13}|(?:BG|BH|GB|IE)\\d{2}[A-Z]{4}\\d{14}|GI\\d{2}[A-Z]{4}\\d{15}|RO\\d{2}[A-Z]{4}\\d{16}|KW\\d{2}[A-Z]{4}\\d{22}|MT\\d{2}[A-Z]{4}\\d{23}|NO\\d{13}|(?:DK|FI|GL|FO)\\d{16}|MK\\d{17}|(?:AT|EE|KZ|LU|XK)\\d{18}|(?:BA|HR|LI|CH|CR)\\d{19}|(?:GE|DE|LT|ME|RS)\\d{20}|IL\\d{21}|(?:AD|CZ|ES|MD|SA)\\d{22}|PT\\d{23}|(?:BE|IS)\\d{24}|(?:FR|MR|MC)\\d{25}|(?:AL|DO|LB|PL)\\d{26}|(?:AZ|HU)\\d{27}|(?:GR|MU)\\d{28})$/i";
        Pattern pat = Pattern.compile(ibanRegex);
        return pat.matcher(iban).matches();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IBAN)) return false;
        IBAN that = (IBAN) o;
        return Objects.equals(ibanNumber, that.ibanNumber);
    }
}
