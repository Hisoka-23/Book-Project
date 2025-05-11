package in.bookproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.bookproject.util.ConnectionFactory;

public class BookDAO {

	private static final String INSERT_SQL = "insert into books values(?, ?, ?)";
	
	public boolean saveBook(int bookId, String bookName, double price)throws Exception {
		
		Connection con = ConnectionFactory.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(INSERT_SQL);
		pstmt.setInt(1, bookId);
		pstmt.setString(2, bookName);
		pstmt.setDouble(3, price);
		
		int count = pstmt.executeUpdate();
		
		con.close();
		
		return count > 0;
		
	}
	
}
