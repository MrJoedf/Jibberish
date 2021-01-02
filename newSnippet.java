import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JTree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class newSnippet {
    
	public JFrame frmSnippet;
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
					newSnippet window = new newSnippet();
					window.frmSnippet.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public newSnippet() {
		initialize();
	}
	
	public newSnippet(File root, JTree tree) {
		System.out.println(root);
		
		initialize(root, tree);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize(){};
	
	private void initialize(File root, JTree tree) {
		frmSnippet = new JFrame();
	
		frmSnippet.setTitle("New Snippet");
		frmSnippet.setResizable(false);
		frmSnippet.getContentPane().setFont(new Font("Kristen ITC", Font.BOLD, 28));
		frmSnippet.getContentPane().setLayout(null);
		
		
		JLabel lblSnippet = new JLabel("Enter the name of the new snippet:");
		lblSnippet.setBounds(50, 30, 476, 14);
		frmSnippet.getContentPane().add(lblSnippet);
		
		JTextPane snipName = new JTextPane();
		
		snipName.setBounds(50, 50, 365, 20);
		frmSnippet.getContentPane().add(snipName);
		
		JButton btnNewSnippet = new JButton("CREATE");
		btnNewSnippet.setLocation(45, 68);
		btnNewSnippet.setFont(new Font("Kristen ITC", Font.BOLD, 14));
		btnNewSnippet.setSize(128, 30);
		
		btnNewSnippet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String snippetName = snipName.getText();
				String rootString = root.getPath().toString();
				rootString = rootString.substring(1, rootString.length()-1);
				File newSnippet = new File(rootString+File.separator+snippetName+".txt");
				System.out.println(rootString);
				
				DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
				
				newSnippet.getParentFile().mkdirs();
			
				try {
					newSnippet.createNewFile();
					System.out.println(tree.getSelectionPath().toString());
					System.out.println(newSnippet);
			
					model.reload();
					
					frmSnippet.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
							
			private String to_string(java.io.File root) {
				// TODO Auto-generated method stub
				return null;
			}

			private Object File(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		frmSnippet.getContentPane().add(btnNewSnippet);
		
		
		frmSnippet.setTitle("New snippet");
		frmSnippet.setBounds(100, 100, 450, 150);
		frmSnippet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
