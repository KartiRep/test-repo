package com.osama.demorest;

import com.osama.repositoryController.RepositoryController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@Path("/students")
public class StudentController {

    private RepositoryController repositoryController = new RepositoryController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAll(){
        System.out.println("hiii");
        return repositoryController.getAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("student/{id}")
    public Student getStudent(@PathParam("id") int id){
        return repositoryController.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/student")
    public Student creatStudent(Student s){
        System.out.println(s);
        repositoryController.CreateStudent(s);
        return s;
    }

    @PUT
    @Path("/student")
    @Consumes(MediaType.APPLICATION_JSON)
    public Student updateStudent(Student s){
        repositoryController.updateStudent(s);
        return s;
    }

    @DELETE
    @Path("/student/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteStudent(@PathParam("id") int id){
        repositoryController.delete(id);
    }
}
