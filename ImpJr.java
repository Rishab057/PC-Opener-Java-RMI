import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ImpJr extends UnicastRemoteObject implements Jr
{

	private static final long serialVersionUID = 1L;

	protected ImpJr() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int login(String regid, String pass) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/accounts" , "root" , "12345");
		
		PreparedStatement ps = conn.prepareStatement("select * from user where regid = '" + regid + "' and pass = '" + pass + "'");
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
			return 0;
		}
		
		return -1;
	}

	@Override
	public int newAccount(String uname, String regid, String pass, String mob, String email, String gender) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/accounts" , "root" , "12345");
		
		PreparedStatement ps = conn.prepareStatement("select * from user where regid = '" + regid + "'");
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
			return -1;
		}
		
		PreparedStatement ps2 = conn.prepareStatement("insert into user values(?,?,?,?,?,?);");
		
		ps2.setString(1,regid);
		ps2.setString(2,uname);
		ps2.setString(3,pass);
		ps2.setString(4,mob);
		ps2.setString(5,email);
		ps2.setString(6,gender);

		ps2.executeUpdate();
		return 0;
	}
	
	
		@Override
	public byte[] down(String path) throws IOException {
		
		FileInputStream fis = new FileInputStream(path);
		ArrayList<Byte> data = new ArrayList<Byte>();
		int val;
		
		while(true)
		{
			val = fis.read();
			
			if(val==-1)
				break;
			
			data.add((byte)val);
		}
		
		byte[] result = new byte[data.size()];
		for(int i = 0; i < data.size(); i++) {
		    result[i] = data.get(i).byteValue();
		}
		
		fis.close();
		
		return result;
	}
	
	public File[] callFiles(String path) throws Exception
	{
		File f = new File(path);
		File[] list = f.listFiles();
		ArrayList<File> data = new ArrayList<File>();
		
		if(list!=null)
		{
			for(File fu:list)
			{
				if(fu.isFile())
				{
					data.add(fu);
				}
			}	
		}
		
		File[] ret = data.toArray(new File[data.size()]);
	
		System.out.println("Returning");
		return ret;
	}
	
	public File[] callFolders(String path) throws Exception
	{
		File f = new File(path);
		File[] list = f.listFiles();
		
		ArrayList<File> data = new ArrayList<File>();
		
		if(list!=null)
		{
			for(File fu:list)
			{
				if(fu.isDirectory())
				{
					data.add(fu);
				}
			}	
		}
		
		File[] ret = data.toArray(new File[data.size()]);
		
		System.out.println("Returning");
		return ret;
	}
	

}
