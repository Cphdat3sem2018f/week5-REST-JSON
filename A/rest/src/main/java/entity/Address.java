package entity;

import java.util.ArrayList;

public class Address
{
    private String street;
    private String city;
    private ArrayList<Person> persons = new ArrayList();

    public Address()
    {
    }

    public Address(String street, String city)
    {
        this.street = street;
        this.city = city;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public ArrayList<Person> getPersons()
    {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons)
    {
        this.persons = persons;
    }
    
    public void addPerson(Person person)
    {
        this.persons.add(person);
    }

    @Override
    public String toString()
    {
        return "Address{" + "street=" + street + ", city=" + city + '}';
    }
    
    
}
