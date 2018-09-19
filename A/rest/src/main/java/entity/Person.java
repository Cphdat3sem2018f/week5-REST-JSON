package entity;

import java.util.ArrayList;

public class Person
{
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private ArrayList<Address> addresses = new ArrayList();

    public Person()
    {
    }

    public Person(String firstName, String lastName, int phoneNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Address> getAddresses()
    {
        return addresses;
    }

    public void setAddresses(ArrayList<Address> addresses)
    {
        this.addresses = addresses;
    }
    
    public void addAddress(Address address)
    {
        this.addresses.add(address);
    }

    @Override
    public String toString()
    {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + '}';
    }
}
