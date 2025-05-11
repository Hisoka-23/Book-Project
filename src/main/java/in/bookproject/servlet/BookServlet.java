package in.bookproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import in.bookproject.dao.BookDAO;
import in.bookproject.dto.BookDTO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)throws IOException {
		
		try {
			
			//capture form data
			int bookId = Integer.parseInt(req.getParameter("bookId"));
			String name = req.getParameter("bookName");
			double bookPrice = Double.parseDouble(req.getParameter("bookPrice"));
			
			BookDTO dto = new BookDTO();
			dto.setBookId(bookId);
			dto.setBookName(name);
			dto.setBookPrice(bookPrice);
			
			//call dao method by giving form data
			BookDAO dao = new BookDAO();
			boolean status = dao.saveBook(dto);
			
			// send response to client
			String respone = null;
			if(status) {
				respone = "Record Inserted";
			}else {
				respone = "Record not Inserted";
			}
			
			PrintWriter pw = resp.getWriter();
			pw.append(respone);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
