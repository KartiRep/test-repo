package com.osama.demorest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello_word")
public class HelloWord {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage(){
        return "hi word";
    }

}
