package jpacontrol;

import java.util.HashMap;
import javax.persistence.Persistence;

public class Structure
{
    public static void main(String[] args)
    {
        Persistence.generateSchema("jpapu", new HashMap<String, Object>());
    }
}
