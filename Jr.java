import java.rmi.Remote;
import java.sql.SQLException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public interface Jr extends Remote
{
	public int login(String regid, String pass)throws Exception;
	public int newAccount(String uname, String regid, String pass , String mob , String email , String gender)throws Exception;
	public byte[] down(String path) throws FileNotFoundException, IOException;
	public File[] callFiles(String path) throws Exception;
	public File[] callFolders(String path) throws Exception;
}