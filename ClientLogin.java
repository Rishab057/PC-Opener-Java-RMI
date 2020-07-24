import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class ClientLogin extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	JLabel regidl;
	JTextField regid;
	JLabel passl;
	JPasswordField pass;
	JButton b1;
	JLabel n;
	
	public ClientLogin()
	{
		super("Login Page");
		super.setBounds(400,400,400,400);
		
		regidl = new JLabel("Reg. ID ");
		regidl.setBounds(50, 50, 100, 50);
		super.add(regidl);
		regid = new JTextField();
		regid.setBounds(170, 60, 150, 30);
		super.add(regid);
		
		passl = new JLabel("Password ");
		passl.setBounds(50, 120, 100, 50);
		super.add(passl);
		pass = new JPasswordField();
		pass.setBounds(170, 130, 150, 30);
		super.add(pass);
		
		
		b1 = new JButton("Login");
		b1.setBounds(150,200, 100, 50);
		super.add(b1);
		b1.addActionListener(this);
		
		super.setLayout(null);
		super.setResizable(false);
		super.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == b1)
		{
			try
			{
			String url="rmi://192.168.43.202:34567//Java";
			Jr ref=(Jr)Naming.lookup(url);
			String R = regid.getText();
			String P = new String(pass.getPassword());
			int x = ref.login(R, P);
			
			if(x==0)
			{
			super.dispose();
			Download d = new Download();
			}
			
			else
			{
				super.dispose();
				Error re = new Error();
			}
			}
			
			catch(Exception ex)
			{
				System.out.println("Error in client..");
				ex.printStackTrace();
			}
		}
		
	}

}
