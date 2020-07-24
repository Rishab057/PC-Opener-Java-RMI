//import java.util.Scanner;
import java.rmi.*;


public class Server {
	
//	private static Scanner scan;

	public static void main(String[] args) {
	
		//scan = new Scanner(System.in);
		
		
			try {
			//System.setProperty("java.rmi.server.hostname","192.168.43.202:34567");	
			String url="rmi://192.168.43.202:34567//Java";	
			System.out.println("Safe here 1 ..\n\n");
			ImpJr obj=new ImpJr();
			System.out.println("Safe here 2 ..\n\n");
			Naming.bind(url,obj);
			System.out.println("Safe here 3 ..\n\n");
			
			System.out.println("Server started.....");
			
			}
			catch(Throwable  t) {
			System.out.println("Error in Server\n\n "+t);
			}

		}
}
