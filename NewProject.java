import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.awt.Color;
import java.awt.Component;

public class NewProject extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Something");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					NewProject frame = new NewProject();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewProject() {
		setResizable(false);
		setTitle("Create a New Project");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 137);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(131, 28, 187, 20);
		contentPane.add(textPane);
		
		JLabel lblProjectName = new JLabel("Project Name:");
		lblProjectName.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		
		lblProjectName.setBounds(10, 28, 124, 20);
		contentPane.add(lblProjectName);
		
		JLabel lblProjectAlreadyExists = new JLabel("PROJECT ALREADY EXISTS");
		lblProjectAlreadyExists.setFont(new Font("Segoe UI", Font.BOLD, 11));
		
		lblProjectAlreadyExists.setForeground(Color.RED);
		lblProjectAlreadyExists.setBounds(131, 85, 187, 23);
		
		lblProjectAlreadyExists.setVisible(false);
		contentPane.add(lblProjectAlreadyExists);

		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String projectName = textPane.getText();
				File projectFolder = new File("Jibberish" + File.separator + projectName);
			
				File projectBody = new File("Jibberish" + File.separator + projectName + File.separator + "Snippet 1.txt");
				
				try {
					if(projectFolder.exists()) {
						System.err.println("Project already exists.");
						lblProjectAlreadyExists.setVisible(true);
					}else{
						projectFolder.mkdirs();
						projectBody.getParentFile().mkdirs();
						
						projectBody.createNewFile();
					
						System.out.println("Project created.");	
						File currentProject = projectBody;
						
						Jibberish jibberish = new Jibberish(projectName, true);
						jibberish.setVisible(true);
						
						jibberish.setExtendedState(JFrame.MAXIMIZED_BOTH);
						jibberish.setTitle(projectName + " - Jibberish");
						
						
						dispose();			
						
					}
				} catch (Exception w) {
					w.printStackTrace();
				}
				
						
			}											
					
						
		
		}
				
			
		);
		btnNewButton.setFont(new Font("Kristen ITC", Font.BOLD, 11));
		btnNewButton.setBounds(229, 59, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
		} }
			);
		btnNewButton_1.setFont(new Font("Kristen ITC", Font.BOLD, 11));
		btnNewButton_1.setBounds(130, 59, 89, 23);
		contentPane.add(btnNewButton_1);
		

	
	}}	
 

