package jdbc_Krushimart_sevlets;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class CRUD {
	
	public Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/krushimart","root","root");
		return connection;
	}
	
	public int setUser(Registration registration) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement ps=connection.prepareStatement("INSERT INTO USER VALUES (?,?,?,?,?,?,?)");
		
		ps.setInt(1, registration.getUserid());
		ps.setString(2, registration.getFname());
		ps.setString(3, registration.getLname());
		ps.setString(4, registration.getEmailid());
		ps.setString(5, registration.getPassword());
		ps.setLong(6, registration.getPhone());
		ps.setString(7, registration.getRole());
		
		int count=ps.executeUpdate();
		
		connection.close();
		return count;
	}
	
	public int getCount() throws Exception
	{
		Connection connection=getConnection();
		int count=0;
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT COUNT(*) FROM USER");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
		 		count=rs.getInt(1);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public int getPostCount() throws Exception
	{
		Connection connection=getConnection();
		int count=0;
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT COUNT(*) FROM PRODUCT");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
		 		count=rs.getInt(1);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
	public String login(String email) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement ps=connection.prepareStatement("SELECT PASSWORD FROM USER WHERE EMAIL_ID=?");
		ps.setString(1, email);
		
		ResultSet rs=ps.executeQuery();
		String password=null;
		while(rs.next())
		{
			password=rs.getString("password");
		}
		connection.close();
		return password;
	}
	
	public int setPost(Post post) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement ps=connection.prepareStatement("INSERT INTO PRODUCT VALUES(?,?,?,?,?)");
		ps.setInt(1,post.getId());
		ps.setString(2, post.getProduct());
		ps.setDouble(3,post.getPrice());
		ps.setInt(4, post.getQuatity());
		ps.setString(5, post.getEmail_Id());
		int count=ps.executeUpdate();
		connection.close();
		return count;
	}
	
	public List<Post> getProduct(String email) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement ps=connection.prepareStatement("SELECT * FROM PRODUCT WHERE EMAIL_ID=?");
		ps.setString(1, email);
		ResultSet resultset=ps.executeQuery();
		List<Post> list=new ArrayList<>();
		while(resultset.next())
		{
			Post post=new Post();
			post.setId(resultset.getInt("ID"));
			post.setProduct(resultset.getString("product_name"));
			post.setPrice(resultset.getDouble("price"));
			post.setQuatity(resultset.getInt("Qty"));			
			list.add(post);
		}
		connection.close();
		return list;
	}
	
	public int getId(String email) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement ps=connection.prepareStatement("SELECT USERID FROM USER WHERE EMAIL_ID=?");
		ps.setString(1, email);
		ResultSet rs=ps.executeQuery();
		int id=0;
		while(rs.next())
		{
			id=rs.getInt("userID");
		}
		connection.close();
		return id;
	}
	
	public List<Post> getPost() throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement ps=connection.prepareStatement("SELECT * FROM PRODUCT");
		ResultSet resultset=ps.executeQuery();
		List<Post> list=new ArrayList<>();
		while(resultset.next())
		{
			Post post=new Post();
			post.setId(resultset.getInt("ID"));
			post.setProduct(resultset.getString("product_name"));
			post.setPrice(resultset.getDouble("price"));
			post.setQuatity(resultset.getInt("Qty"));			
			list.add(post);
		}
		connection.close();
		return list;
	}

	public String getRole(String email) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement ps=connection.prepareStatement("SELECT USER_ROLE FROM USER WHERE EMAIL_ID=?");
		ps.setString(1, email);
		ResultSet rs=ps.executeQuery();
		String role=null;
		while(rs.next())
		{
			role=rs.getString("user_role");
		}
		connection.close();
		return role;
	}
	
	public Registration getProfile(String email) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement ps=connection.prepareStatement("SELECT * FROM USER WHERE EMAIL_ID=?");
		ps.setString(1,email);
		ResultSet rs=ps.executeQuery();
		Registration register=new Registration();
		while(rs.next())
		{
			register.setUserid(rs.getInt("userID"));
			register.setFname(rs.getString("first_name"));
			register.setLname(rs.getString("last_name"));
			register.setEmailid(rs.getString("email_id"));
			register.setPhone(rs.getLong("phone_no"));
			register.setRole(rs.getString("user_role"));
		}
		connection.close();
		return register;
		
	}
	public int updateUser(Registration register) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement ps=connection.prepareStatement("UPDATE USER SET FIRST_NAME=?,LAST_NAME=?,EMAIL_ID=?,PASSWORD=?,PHONE_NO=?,USER_ROLE=? WHERE userID=?");
	    ps.setString(1, register.getFname());
	    ps.setString(2, register.getLname());
	    ps.setString(3, register.getEmailid());
	    ps.setString(4, register.getPassword());
	    ps.setLong(5, register.getPhone());
	    ps.setString(6, register.getRole());
	    ps.setInt(7,register.getUserid());
	    
	    int count=ps.executeUpdate();
	    connection.close();
	    return count;
	}
	
	public int updatePassword(String email,String password) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement ps=connection.prepareStatement("UPDATE USER SET PASSWORD=? WHERE EMAIL_ID=?");
		ps.setString(2, email);
		ps.setString(1, password);
		
		int count=ps.executeUpdate();
		connection.close();
		return count;
	}
	
	public int updatePost(Post post) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement ps=connection.prepareStatement("UPDATE USER SET PRODUCT_NAME=?,PRICE=?,QTY=? WHERE EMAIL_ID=?");
		ps.setString(1, post.getProduct());
		ps.setDouble(2, post.getPrice());
		ps.setInt(3, post.getQuatity());
		ps.setString(4,post.getEmail_Id());
		
		int count=ps.executeUpdate();
		connection.close();
		return count;
	}
	public List<Post> getPost(String email) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement ps=connection.prepareStatement("SELECT * FROM PRODUCT WHERE email_id=?");
		ps.setString(1, email);
		ResultSet resultset=ps.executeQuery();
		List<Post> list=new ArrayList<>();
		while(resultset.next())
		{
			Post post=new Post();
			post.setId(resultset.getInt("ID"));
			post.setProduct(resultset.getString("product_name"));
			post.setPrice(resultset.getDouble("price"));
			post.setQuatity(resultset.getInt("Qty"));			
			list.add(post);
		}
		connection.close();
		return list;
	}
	public int deletePost(String email) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement ps=connection.prepareStatement("DELETE FROM PRODUCT WHERE EMAIL_ID=?");
		ps.setString(1, email);
		int count=ps.executeUpdate();
		connection.close();
		return count;
	}
	public int deletepost(String name) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement ps=connection.prepareStatement("DELETE FROM PRODUCT WHERE PRODUCT_NAME=?");
		ps.setString(1, name);
		int count=ps.executeUpdate();
		connection.close();
		return count;
	}
	
}
