package isel.sisinf.model.interfaces;

import isel.sisinf.model.Employee;
import isel.sisinf.model.ReplacementOrder;
import isel.sisinf.model.Station;

import java.time.LocalDateTime;

public interface IReplacement {
    public int getNumber();
    public void setNumber(int number);

    public LocalDateTime getDreplacement();
    public void setDreplacement(LocalDateTime dreplacement);

    public String getAction();
    public void setAction(String action);

    public ReplacementOrder getReporder();
    public void setReporder(ReplacementOrder reporder);

    public Station getRepstation();
    public void setRepstation(Station repstation);

    public Employee getEmployee();
    public void setEmployee(Employee employee);
}
