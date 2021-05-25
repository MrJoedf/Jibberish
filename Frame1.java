import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.io.File;
import javax.swing.JFileChooser;

public class Frame1 {
    
	JFrame frmJibberish;
	/**
	 * Launch the application.
	 */		
		public static void main(String[] args) {
			System.setProperty("apple.laf.useScreenMenuBar", "true");
			System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Name");
			EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Frame1 window = new Frame1();
					window.frmJibberish.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmJibberish = new JFrame();
		frmJibberish.setTitle("Jibberish");
		frmJibberish.setResizable(false);
		
		frmJibberish.getContentPane().setFont(new Font("Kristen ITC", Font.BOLD, 28));
		frmJibberish.getContentPane().setLayout(null);
		
	
		
		JLabel lblJibberish = new JLabel("JIBBERISH v.02");
		lblJibberish.setBounds(0, 0, 476, 51);
		
		lblJibberish.setHorizontalAlignment(SwingConstants.CENTER);
		lblJibberish.setForeground(new Color(50, 205, 50));
		
		lblJibberish.setFont(new Font("Kristen ITC", Font.BOLD, 28));
		frmJibberish.getContentPane().add(lblJibberish);
		
		JLabel lblPropertyOfJemsoft = new JLabel("Property of JEMSOFT and Joe Foster (2017-2021)");
		lblPropertyOfJemsoft.setBounds(10, 151, 476, 14);
		frmJibberish.getContentPane().add(lblPropertyOfJemsoft);
		
		JButton btnNewProject = new JButton("NEW PROJECT");
		btnNewProject.setLocation(10, 68);
		
		btnNewProject.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		btnNewProject.setSize(228, 61);
		
		btnNewProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewProject newProject = new NewProject();
				newProject.setVisible(true);
				
				JibberishFolder jibberishFolder = new JibberishFolder();
				jibberishFolder.createFolder();
				
			}
							
			private Object File(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
	
		
		frmJibberish.getContentPane().add(btnNewProject);
		
		JButton btnExistingProject = new JButton("EXISTING PROJECT");
		btnExistingProject.setBounds(263, 68, 213, 61);
		
		btnExistingProject.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		
		btnExistingProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser chooser = new JFileChooser();
				    chooser.setCurrentDirectory(new java.io.File("Jibberish"));
				    chooser.setDialogTitle("Choose a project folder: ");
				    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				    chooser.setAcceptAllFileFilterUsed(false);

				    //	System.out.println(chooser.getSelectedFile());
				    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				      System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
				      System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
				    } else {
				      System.out.println("No Selection ");
				    }
				    	
				    String pDirectory = chooser.getSelectedFile().toString();
				    File temp = new File(pDirectory);
				    pDirectory = temp.getAbsolutePath().toString();
				    Jibberish jibberish = new Jibberish(pDirectory, false);
				    
				    jibberish.setVisible(true);
				    jibberish.setExtendedState(JFrame.MAXIMIZED_BOTH);
				    jibberish.setTitle(chooser.getSelectedFile().getName() + " - Jibberish");
			}
		});
		frmJibberish.getContentPane().add(btnExistingProject);
		frmJibberish.setTitle("Jibberish");
		
		frmJibberish.setBounds(100, 100, 504, 212);
		frmJibberish.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
