package com.osama.demorest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/employees")
public class EmployeeController {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Employee> getEmployee() {
        Employee employee1 = new Employee();

        employee1.setAge("18");
        employee1.setFirstName("osama");
        employee1.setLastName("ahmad");

        Employee employee2 = new Employee();

        employee2.setAge("18");
        employee2.setFirstName("osama");
        employee2.setLastName("ahmad");

        List<Employee> employees = Arrays.asList(employee1,employee2);
        return employees;
    }
}
