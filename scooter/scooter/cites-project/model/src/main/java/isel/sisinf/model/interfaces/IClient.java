package isel.sisinf.model.interfaces;

import isel.sisinf.model.Person;

import java.time.LocalDateTime;

public interface IClient {
    // Getters and Setters
    public Person getPerson();
    public void setPerson(Person person);

    public LocalDateTime getDtRegister();
    public void setDtRegister(LocalDateTime dtRegister);
}
