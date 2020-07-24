import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Download extends JFrame implements ActionListener {
	
	JButton b1;
	JButton b2;
	JLabel l1;
	JLabel l2;
	File[] listfile;
	File[] listfolder;
	
	public Download()
	{
		super("Download Page..");
		super.setBounds(100, 100, 450, 200);
		
		b1 = new JButton("Local Disk (D:)");
		b1.setBounds(50, 50, 150, 50);
		b1.addActionListener(this);
		super.add(b1);
		
		b2 = new JButton("Local Disk (E:)");
		b2.setBounds(250, 50, 150, 50);
		b2.addActionListener(this);
		super.add(b2);
		
		super.setLayout(null);
		super.setResizable(false);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		
		try
		{
		if(e.getSource() == b1)
		{
			String url="rmi://192.168.43.202:34567//Java";
			Jr ref=(Jr)Naming.lookup(url);
			listfile = ref.callFiles("D:/");
			listfolder = ref.callFolders("D:/");
			System.out.println("Called D");
			System.out.println();
			
			super.dispose();
			
			new BasicNew(listfile,listfolder,"D:/");
			
		}
		
		else if(e.getSource() == b2)
		{
			
			String url="rmi://192.168.43.202:34567//Java";
			Jr ref=(Jr)Naming.lookup(url);
			listfile = ref.callFiles("E:/");
			listfolder = ref.callFolders("E:/");
			System.out.println("Called E");
			System.out.println();
			
			super.dispose();
			
			BasicNew b = new BasicNew(listfile,listfolder,"E:/");
		}
		}
		
		catch(Exception ex)
			{
				System.out.println("Error in client..");
				ex.printStackTrace();
			}
		// TODO Auto-generated method stub
		
	}
	
	

}
