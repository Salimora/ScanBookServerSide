/**
 * 
 */
package com.scanbook.resource;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scanbook.orm.Book;
import com.scanbook.service.BookService;

/**
 * @author Zhe
 *
 */
@Component
@Path("/books")
public class BookResource {
	
	@Autowired
	BookService bookService;
	
	//get all Books List
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getBookList(){
		return bookService.getBookList();
		
	}
	
	//input barCode, search book from Book table
	@GET
	@Path("/search/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book searchBook(@PathParam("id") String id){
		int barCode = Integer.parseInt(id);
		return bookService.searchBook(barCode);
	}
	
	//update book Info based barCode 
	@PUT
	@Path("/update/{id}/{title}/{author}/{numOfPage}/{readOrNot}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateBook(@PathParam("id") String id, @PathParam("title") String title, 
			@PathParam("author") String author, @PathParam("numOfPage") String numOfPage, @PathParam("readOrNot") String readOrNot){
		int barCode = Integer.parseInt(id);
		int pages = Integer.parseInt(numOfPage);
		int reading = Integer.parseInt(readOrNot);
		Book book = new Book(barCode, title, author, pages, reading);
		int serverResponse = bookService.updateBook(book);
		int result = 500;
		if(serverResponse == 1){
			result = 200;
		}
		return Response.status(result).build();
	
	}
	
	//add a new book in Books table 
	@PUT
	@Path("/add/{id}/{title}/{author}/{numOfPage}/{readOrNot}")
//	@Path("/add/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBook(@PathParam("id") String id, @PathParam("title") String title, 
			@PathParam("author") String author, @PathParam("numOfPage") String numOfPage, @PathParam("readOrNot") String readOrNot){
		int barCode = Integer.parseInt(id);
		int pages = Integer.parseInt(numOfPage);
		int reading = Integer.parseInt(readOrNot);
		Book book = new Book(barCode, title, author, pages, reading);
		int result = 500;
		int serverResponse = bookService.addBook(book);
		if(serverResponse == 1){
			result = 200;
		}
		return Response.status(result).build();
	}
//	public String addBook(@PathParam("id") String id){
//		int barCode = Integer.parseInt(id);
//		bookService.addBook(barCode);
//		return "success";
//		
//	}
	
	//delete book from Books table based barCode
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON) 
	public Response delete(@PathParam("id") String id){
		int bookId = Integer.parseInt(id);
		int serverResponse = bookService.deleteBook(bookId);
		int result = 500;
		if(serverResponse == 1){
			result = 200;
		}
		return Response.status(result).build();
	}
}
