package isel.sisinf.model.interfaces;

import isel.sisinf.model.Person;

public interface IEmployee {
    public int getNumber();
    public void setNumber(int number);

    public Person getPerson();
    public void setPerson(Person person);
}
