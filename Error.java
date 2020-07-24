import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Error extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JLabel l1;
	JLabel l2;
	JLabel l3;
	JButton b;
	JButton b2;
	
	public Error()
	{
		super("Error");
		super.setBounds(400, 400, 300, 300);
		
		l1 = new JLabel("Either the user with same REGID exists");
		l1.setBounds(25, 10, 250, 50);
		super.add(l1);
		
		l2 = new JLabel("or you did not fill all the details...");
		l2.setBounds(25, 30, 250, 50);
		super.add(l2);
		
		l3 = new JLabel("Try again by going to the login page.");
		l3.setBounds(25, 50, 250, 50);
		super.add(l3);
		
		b = new JButton("OK");
		b.setBounds(115,100,70,50);
		super.add(b);
		b.addActionListener(this);
		
		b2 = new JButton("Login Page");
		b2.setBounds(100,160,100,50);
		super.add(b2);
		b2.addActionListener(this);
		
		super.setLayout(null);
		super.setResizable(false);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b)
		{
			super.dispose();
		}
		
		else if(e.getSource() == b2)
		{
			super.dispose();
			Client ob = new Client();
		}
		
	}

}
