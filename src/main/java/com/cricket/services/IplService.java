package com.cricket.services;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/ipl")
public class IplService {

	@Path("/testCon")
	@GET
	public Response TestConnection() {

		String output = "connection Succesfull!!";
		System.out.println("connection triggered!!!!");
		return Response.status(200).entity(output).build();
	}

	@Path("/wishUser")
	@GET
	public Response sayHello(@QueryParam("name") String userName) {

		System.out.println("User is: " + userName);
		String output = "Hello :" + userName;
		
		Date dt = new Date();
        int hours = dt.getHours();
        int min = dt.getMinutes();

        if(hours>=1 && hours<=12){
            output = output + " Good Morning!!";
        }else if(hours>=12 && hours<=16){
        	output = output + " Good Afternoon!!";
        }else if(hours>=16 && hours<=21){
        	output = output + " Good Evening!!";
        }else if(hours>=21 && hours<=24){
        	output = output + " Good Night!!";
        }
		
		return Response.status(200).entity(output).build();
	}
	
	@Path("/greetUser/{userName}/{age}/{industry}")
	@GET
	public Response sayHelloPath(@PathParam("userName") String name,@PathParam("age") String age,@PathParam("industry")String indus) {

		System.out.println("User is: " + name+"--"+age+"--"+indus);
		String output = "Hello :" + name+"--"+age+"--"+indus;
		return Response.status(200).entity(output).build();
	}
	
	

}
