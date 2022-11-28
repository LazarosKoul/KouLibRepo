package com.koulaz.KouLib.entities;
/**
 * This is a Author's entity representation, for application usage,
 * as well as saving.
 */
public class Author {

    private String firstName;
    private String lastName;

    /*
     * This constructor is used for de-serialization.
     */
    public Author() {
        this.firstName = "NoFirstName";
        this.lastName = "NoLastName";
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * This function is used from JFrame to show author's properties.
     * @return author's representation.
     */
    @Override
    public String toString() {
        return  firstName + " "+ lastName ;
    }

}
