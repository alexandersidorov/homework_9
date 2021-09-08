package two;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee
{
    private long id;
    private String name;
    private double salary;
}