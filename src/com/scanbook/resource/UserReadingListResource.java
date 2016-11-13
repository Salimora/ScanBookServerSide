/**
 * 
 */
package com.scanbook.resource;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scanbook.orm.ReadingListBook;
import com.scanbook.orm.UserReadingList;
import com.scanbook.service.BookService;
import com.scanbook.service.UserReadingListService;

/**
 * @author Zhe
 *
 */
@Component
@Path("/user")
public class UserReadingListResource {
	@Autowired
	UserReadingListService userReadingListService;
	
	//get current user book list from UserReadingList
	@POST
	@Path("{user}/readinglist")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReadingListBook> getListBooks(@PathParam("user") String user){
		int userId = Integer.parseInt(user);
		return userReadingListService.getListBooks(userId);
	}
	
	//current user add a book to UserReadingList
	@POST
	@Path("{user}/readinglist/addbook/{id}")
	@Produces(MediaType.TEXT_HTML)
	public Response addBooktoReadingList(@PathParam("user") String user,@PathParam("id") String id){
		int barCode = Integer.parseInt(id);
		int userId = Integer.parseInt(user);
		int serverResponse = userReadingListService.addBooktoReadingList(userId, barCode);
		int result = 500;
		if(serverResponse == 1){
			result = 200;
		}
		return Response.status(result).build();
	}
	
	//current user delete a book from UserReadingList
	@DELETE
	@Path("{user}/readinglist/deletebook/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteBookFromReadingList(@PathParam("user") String user, @PathParam("id") String id){
		int barCode = Integer.parseInt(id);
		int userId = Integer.parseInt(user);
		int serverResponse = userReadingListService.deleteBookFromReadingList(userId, barCode);
		int result = 500;
		if(serverResponse == 1){
			result = 200;
		}
		return Response.status(result).build();
	}
	
	//current user update a book to UserReadingList
	@POST
	@Path("{user}/readinglist/updatebook/{id}/{reading}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBookinReadingList(@PathParam("user") String user, @PathParam("id") String id, @PathParam("reading") String reading){
		int barCode = Integer.parseInt(id);
		int userId = Integer.parseInt(user);
		int readOrNot = Integer.parseInt(reading);
		int serverResponse = userReadingListService.updateBookinReadingList(userId, barCode, readOrNot);
		int result = 500;
		if(serverResponse == 1){
			result = 200;
		}
		return Response.status(result).build();
	}
	
}
