import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Success extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JLabel l;
	JButton b;
	
	public Success()
	{
		super("Success");
		super.setBounds(400, 400, 300, 300);
		
		l = new JLabel("File Downloaded Successfully!!");
		l.setBounds(70, 30, 150, 70);
		super.add(l);
		
		b = new JButton("OK");
		b.setBounds(115,110,70,50);
		super.add(b);
		b.addActionListener(this);
		
		super.setLayout(null);
		super.setResizable(false);
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		super.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b)
		{
			super.dispose();
		}
		
	}

}
