package switch2020.project.model;

public class CashAccount {

    // Attributes
    private int cashAccountID;
    private double balance;

    // Constructors
    public CashAccount() {
        this.cashAccountID = 0;
        this.balance = 0;
    }

    // Business Methods
    /**
     * A method that validates if the given cash account ID is valid
     *
     * @param cashAccountID given cash account ID to validate
     * @return a boolean validID, true if valid, false if invalid
     */
    private boolean validateID(int cashAccountID) {
        boolean validID = false;
        if (cashAccountID >= 0) {
            validID = true;
        }
        return validID;
    }
}