/*import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.rmi.*;
import java.rmi.server.*;

/*import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.FlowLayout;
import javax.swing.BorderLayout;
import javax.swing.ImageIcon;*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BasicNew extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JLabel lb;
	JScrollBar hor; 
	JScrollBar ver;
	JList<String> file;
	JList<String> folder;
	JLabel fi;
	JLabel fol;
	JScrollPane jscrlpfilv;
	JScrollPane jscrlpfilh;
	JScrollPane jscrlpfolv;
	JScrollPane jscrlpfolh;
	JLabel filelb;
	JLabel folderlb;
	JTextArea fileta;
	JTextArea folderta;
	JButton open;
	JButton download;
	JButton back;
	JLabel ll;
	File[] listfile;
	File[] listfolder;
	File[] listfilenew;
	File[] listfoldernew;
	String newpath;
	int i;
	
	public BasicNew()
	{
		
	}
	
	public BasicNew(File[] list1 , File[] list2 , String path)
	{
		super(path);
		path = path.replace('\\','/');
		newpath = path;
		i=0;
		super.setBounds(100, 100, 700, 700);
		//super.getContentPane().setBackground(Color.RED);			This is how we ad a color to JFrame
		//("C:\\Users\\Rishab\\Desktop\\javaapp.jpeg");
		
		//setContentPane(new JLabel(new ImageIcon("C:\\Users\\Rishab\\Desktop\\javaapp.jpeg")));		In this way we can add image in background
		
		showIt(list1 , list2);
		
		filelb = new JLabel("Enter the file number ");
		filelb.setBounds(50, 535, 150, 50);
		folderlb = new JLabel("Enter the folder number");
		folderlb.setBounds(50, 575, 150, 50);
		fileta = new JTextArea();
		fileta.setBounds(200, 550, 100, 20);
		fileta.setBackground(Color.GREEN);
		folderta = new JTextArea();
		folderta.setBounds(200, 590, 100, 20);
		folderta.setBackground(Color.YELLOW);
		open = new JButton("Open");
		open.setBounds(375, 585, 100, 30);
		download = new JButton("Download");
		download.setBounds(375, 545, 100, 30);
		download.addActionListener(this);
		open.addActionListener(this);
		
		ll = new JLabel(" ");
		ll.setBounds(75, 550, 150, 30);
		
		back = new JButton("BACK");
		back.setBounds(600,10,75,30);
		back.addActionListener(this);
		super.add(back);	
		super.add(filelb);
		super.add(folderlb);
		super.add(fileta);
		super.add(folderta);
		super.add(open);
		super.add(download);
		super.setLayout(null);
		super.setResizable(false);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setVisible(true);
	}
	
	public void showIt(File[] list1 , File[] list2)
	{	
		listfile = list1;
		listfolder = list2;
		
		if(listfile!=null || listfolder!=null)
		{	
			ArrayList<String> filname = new ArrayList<String>();
			ArrayList<String> folname = new ArrayList<String>();
			
			fi = new JLabel("Files");
			fol = new JLabel("Folders");
			fi.setBounds(375, 20, 30, 30);
			fol.setBounds(50,20,50,30);
			
			add(fi);
			add(fol);
			
			int i=1;
			int j=1;
			
			if(list1!=null)
			{
			for(File fil : list1)
			{
					filname.add(i+".  " + fil.getName());
					i++;
			}
			}
			
			if(list2!=null)
			{
			for(File fil : list2)
			{
					folname.add(j+".  " + fil.getName());
					j++;
			}
			}
			
			String[] files = filname.toArray(new String[filname.size()]);
			String[] folders = folname.toArray(new String[folname.size()]);
			
			file = new JList<String>(files);
			folder = new JList<String>(folders);
			
			file.setBackground(Color.BLUE);
			file.setForeground(Color.WHITE);
			folder.setBackground(Color.GRAY);
			folder.setForeground(Color.WHITE);
			//file.setBounds(400, 70, 250, 450);
			//folder.setBounds(50, 70, 250, 450);
			
			jscrlpfilv = new JScrollPane(file,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			jscrlpfilv.setBounds(375, 70, 275, 450);
			
			jscrlpfolv = new JScrollPane(folder,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			jscrlpfolv.setBounds(50, 70, 275, 450);
			
			//jscrlpfilv.setPreferredSize(new Dimension(200,200));
			//jscrlpfolv.setPreferredSize(new Dimension(200,200));check
			
			add(jscrlpfolv);
			add(jscrlpfilv);
			
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		try
		{
		if(e.getSource() == download)
		{
			int index = Integer.parseInt(fileta.getText());
			File d = listfile[index-1];
			String path = d.getAbsolutePath();
			System.out.println(path);
			String name = d.getName();
			System.out.println(name);
			try {
				File f = new File("C:\\yaya");
				f.mkdir();
				FileOutputStream fos = new FileOutputStream("C:\\yaya\\" + name , false);
				
				String url="rmi://192.168.43.202:34567//Java";
				Jr ref=(Jr)Naming.lookup(url);
				byte[] b = ref.down(path);
				
				int i=0;
				int len = b.length;
				
				while(i<len)
				{
					fos.write(b[i]);
					i++;
				}
				
				new Success();
				
				fos.close();
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
		else if(e.getSource() == open)
		{
			i++;
			ll.setText("Wait...");
			add(ll);
			int index = Integer.parseInt(folderta.getText());
			File d = listfolder[index-1];
			String path = d.getAbsolutePath();
			System.out.println(path);
			String name = d.getName();
			System.out.println(name);
			
			String url="rmi://192.168.43.202:34567//Java";
			Jr ref=(Jr)Naming.lookup(url);
			listfilenew = ref.callFiles(path);
			listfoldernew = ref.callFolders(path);
			System.out.println("Called" + name);
			System.out.println();
			
			super.dispose();
			
			new BasicNew(listfilenew,listfoldernew ,path);
			
		}
		
		else if(e.getSource() == back)
		{
			if((newpath.equals("E:/") || newpath.equals("D:/")))
			{
				super.dispose();
				new Download();
			}
			
			else
			{
			String prev_name = newpath;
			char[] pname = prev_name.toCharArray();
			int i=0;
			int len = prev_name.length();
			
			for(i=len-2 ; i>0;i--)
			{
				if(pname[i] == '/' || pname[i]=='\\')
					break;
			}
			
			char[] newname = new char[i+1];
			
			for(int j=0;j<=i;j++)
			{
				newname[j] = pname[j];
			}
			
			String new_path = new String(newname);
			
			String url="rmi://192.168.43.202:34567//Java";
			Jr ref=(Jr)Naming.lookup(url);
			listfilenew = ref.callFiles(new_path);
			listfoldernew = ref.callFolders(new_path);
			System.out.println("Called" + new_path);
			System.out.println();
			
			super.dispose();
			
			new BasicNew(listfilenew,listfoldernew ,new_path);
			}
			
		}
		
		}
		
		catch(Exception ex)
		{
			System.out.println("Error.... in basicNew");
			ex.printStackTrace();
		}
		
	}
	
}
