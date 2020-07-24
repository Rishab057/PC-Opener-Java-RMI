import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Client extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	JButton b1;
	JButton b2;
	
	public Client()
	{
		super("User");
		super.setBounds(400,400,400,400);
		
		b1 = new JButton("Login");
		b1.setBounds(150, 100, 100, 50);
		super.add(b1);
		b1.addActionListener(this);
		
		b2 = new JButton("SignUp");
		b2.setBounds(150, 200, 100, 50);
		super.add(b2);
		b2.addActionListener(this);
		
		super.setLayout(null);
		super.setResizable(false);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setVisible(true);
	}
	
	public static void main(String[] args) {
	
		new Client();
	 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == b1)
		{
			super.dispose();
			
			ClientLogin cl = new ClientLogin();
			
		}
		
		else if(e.getSource() == b2)
		{
			super.dispose();
			
			ClientSignup cs = new ClientSignup();
		}
		
	}

}
