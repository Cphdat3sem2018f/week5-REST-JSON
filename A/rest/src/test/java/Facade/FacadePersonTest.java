package Facade;

import entity.Person;
import entity.PersonDTO;
import facade.FacadePerson;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class FacadePersonTest
{
    FacadePerson fp = new FacadePerson(Persistence.createEntityManagerFactory("jpapuTEST"));
    
    public FacadePersonTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    @Test
    public void testAddPersonGetPersons()
    {
        System.out.println("AddPersonGetPersons");
        fp.addPerson(new Person("John", "Winter", 34567));
        
        List<PersonDTO> persons = fp.getPersons();
        System.out.println(persons);
        
        assertTrue(persons.contains(new PersonDTO("John", "Winter", 34567)));
    }
}
