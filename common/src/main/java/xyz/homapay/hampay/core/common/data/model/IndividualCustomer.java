package xyz.homapay.hampay.core.common.data.model;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Siavash Mahmoudpour
 */
@Entity(value = "individual_customers", noClassnameStored = true)
public class IndividualCustomer extends Customer {

    private String firstName;
    private String lastName;
    private String fullEnglishName;
    private String fatherName;
    private Date birthDate;
    private String birthPlace;

    @Embedded
    private Map<String, Contact> contacts;

    @Reference
    private List<User> users;

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

    public String getFullEnglishName() {
        return fullEnglishName;
    }

    public void setFullEnglishName(String fullEnglishName) {
        this.fullEnglishName = fullEnglishName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Map<String, Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Map<String, Contact> contacts) {
        this.contacts = contacts;
    }

    public List<User> getUsers() {
        if (users == null)
            users = new ArrayList<User>();
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getDisplayName() {
        return getName();
    }
}
