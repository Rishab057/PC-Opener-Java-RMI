import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class ClientSignup extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JTextField name;
	JLabel namel;
	JTextField regid;
	JLabel regidl;
	JTextField pass;
	JLabel passl;
	JTextField mob;
	JLabel mobl;
	JTextField email;
	JLabel emaill;
	JComboBox<String> gender;
	JLabel genderl;
	JButton b1;
	
	public ClientSignup() {
		// TODO Auto-generated constructor stub
		
		super("Signup Page");
		super.setBounds(400,400,600,600);
		
		namel = new JLabel("Name");
		namel.setBounds(50, 50, 100, 50);
		super.add(namel);
		name = new JTextField();
		name.setBounds(120, 60, 200, 30);
		super.add(name);
		
		regidl = new JLabel("Reg. ID");
		regidl.setBounds(50, 120, 50+50, 50);
		super.add(regidl);
		regid = new JTextField();
		regid.setBounds(120, 130, 200, 30);
		super.add(regid);
		
		passl = new JLabel("Password");
		passl.setBounds(50,190, 50+50, 50);
		super.add(passl);
		pass = new JTextField();
		pass.setBounds(120, 200, 200, 30);
		super.add(pass);
		
		mobl = new JLabel("Mobile");
		mobl.setBounds(50, 260, 50+50, 50);
		super.add(mobl);
		mob = new JTextField();
		mob.setBounds(120, 270, 200, 30);
		super.add(mob);
		
		emaill = new JLabel("EMail");
		emaill.setBounds(50, 330, 50+50, 50);
		super.add(emaill);
		email = new JTextField();
		email.setBounds(120, 340, 200, 30);
		super.add(email);
		
		genderl = new JLabel("Gender");
		genderl.setBounds(50, 400, 50+50, 50);
		super.add(genderl);
		String g[] = {"Select","M","F","S"};
		gender = new JComboBox<String>(g);
		gender.setBounds(120, 400, 100, 50);
		super.add(gender);
		
		b1 = new JButton("Submit");
		b1.setBounds(250, 500, 100, 50);
		b1.addActionListener(this);
		super.add(b1);
		
		super.setLayout(null);
		super.setResizable(false);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setVisible(true);
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b1)
		{
			try
			{
			String url="rmi://192.168.43.202:34567//Java";
			Jr ref=(Jr)Naming.lookup(url);
			String N = name.getText();
			String P = pass.getText();
			String R = regid.getText();
			String M = mob.getText();
			String E = email.getText();
			String G = gender.getItemAt(gender.getSelectedIndex());
			
			if(N!=null && P!=null && R!=null && M!=null &&E!=null && !G.equalsIgnoreCase("select") && M.length() == 10)
			{
				int x = ref.newAccount(N,R,P,M,E,G);
				
				if(x==-1)
				{
					super.dispose();
					Error err = new Error();
				}
				
				else
				{
				super.dispose();
				Successful s = new Successful();
				}
			}
			
			else
			{
			super.dispose();
			Error err = new Error();
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
