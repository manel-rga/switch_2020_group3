package switchtwentytwenty.project.ONEdomain.aggregates.person;

import switchtwentytwenty.project.ONEdomain.aggregates.AggregateRoot;
import switchtwentytwenty.project.ONEdomain.valueobject.*;
import switchtwentytwenty.project.exceptions.EmailAlreadyRegisteredException;

import java.util.ArrayList;
import java.util.List;

public class Person implements AggregateRoot<PersonID> {

    private final PersonID id;
    private Name name;
    private BirthDate birthdate;
    private List<EmailAddress> emails = new ArrayList<>();
    private VATNumber vat;
    private List<PhoneNumber> phone = new ArrayList<>();
    private Address address;
    private FamilyID familyID;
    private List<AccountID> accounts = new ArrayList<>();
    private LedgerID ledger;
    private List<FutureTransactionID> futureTransactions = new ArrayList<>();

    public Person(Name name, BirthDate birthDate, PersonID personID, VATNumber vat, PhoneNumber phone, Address address, FamilyID familyID) {
        this.name = name;
        this.birthdate = birthDate;
        this.id = personID;
        this.vat = vat;
        addPhone(phone);
        this.address = address;
        this.familyID = familyID;
    }

    private void addPhone(PhoneNumber phone) {
        if (!phone.isNull()) {
            this.phone.add(phone);
        }
    }

    /**
     * This method is used to tell the Person to verify if they have that email associated. This way, when the Person
     * Repository iterates through all the Person in the entire system, doesn't use Getters and tells the Information Expert
     * to do it (Tell don't ask)
     *
     * @param personIDToCheck
     * @return
     */
    @Override
    public boolean hasID(ID personIDToCheck) {
        return this.id.equals(personIDToCheck);
    }

    public FamilyID getFamilyID() {
        return this.familyID.clone();
    }

    @Override
    public PersonID id() {
        return this.id;
    }

    public void addEmail(EmailAddress email) {
        if (!isEmailAlreadyRegistered(email)) {
            this.emails.add(email);
        } else {
            throw new EmailAlreadyRegisteredException();
        }
    }

    private boolean isEmailAlreadyRegistered(EmailAddress email) {
        boolean emailPresent = false;
        for (EmailAddress registeredEmail : emails) {
            if (registeredEmail.equals(email)) {
                emailPresent = true;
            }
        }
        if (this.id.isThisEmail(email)) {
            emailPresent = true;
        }
        return emailPresent;
    }
}