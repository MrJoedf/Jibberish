
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTree;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import java.util.Scanner;
public class Jibberish extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Jibberish frame = new Jibberish();
					frame.setExtendedState(MAXIMIZED_BOTH);
					frame.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	private DefaultMutableTreeNode root;

    private DefaultTreeModel treeModel;
    
    private void createChildren(File fileRoot, 
            DefaultMutableTreeNode node) {
        File[] files = fileRoot.listFiles();
        if(files == null){return;}

        for (File file : files) {
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(file);
            node.add(childNode);
            if (file.isDirectory()) {
                createChildren(file, childNode);
            }
        }
    }


    
	public Jibberish(String projectName){
		
		setTitle(projectName + " - Jibberish");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1368, 765);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnNewMenu.add(mntmSave);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnNewMenu.add(mntmOpen);
		
		JMenuItem mntmExport = new JMenuItem("Export");
		mnNewMenu.add(mntmExport);
		
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		Label label = new Label("PROJECT");
		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		label.setBounds(10, 39, 116, 22);
		contentPane.add(label);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 67, 250, 400);
		contentPane.add(tabbedPane_1);
		
		
		File fileroot = new File("Jibberish"+File.separator+projectName);
		root = new DefaultMutableTreeNode(fileroot);
		
		
        treeModel = new DefaultTreeModel(root);
        
        createChildren(fileroot, root);

      
		JTree draftTree = new JTree(treeModel);
		draftTree.setShowsRootHandles(true);
		
		
		JScrollPane treeScroll = new JScrollPane(draftTree);
		treeScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		treeScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		draftTree.scrollPathToVisible(null);
		draftTree.setFont(new Font("Tahoma", Font.BOLD, 16));
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.addTab("Draft", null, draftTree, null);
		
		
		
		JEditorPane editorPane_1 = new JEditorPane();
		JScrollPane sp = new JScrollPane(editorPane_1);
		
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		sp.getVerticalScrollBar();
		sp.setBounds(350,39,720,600);
		contentPane.add(sp);
		editorPane_1.setBounds(450, 39, 640, 860);
		editorPane_1.setFont(new Font("Arial", Font.PLAIN, 20));
		/*
		draftTree.addTreeSelectionListener(new TreeSelectionListener(){
			public void valueChanged(TreeSelectionEvent e) {
		        TreePath tp = draftTree.getSelectionPath();
		        
		        String rootString = tp.getPath().toString();
		        String outString;
		        
				rootString = rootString.substring(1, rootString.length()-1);
				
				
				File tp1 = new File(rootString);
				Scanner in;
				try {
					in = new Scanner(new FileReader(rootString)); 
					if (tp != null) {
		        	StringBuilder sb = new StringBuilder();
		        	
					while(in.hasNext()) {
					    sb.append(in.next());
					}
					in.close();
					outString = sb.toString();
					
					editorPane_1.setText(outString);
					}
			
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
		       
		});*/
			
			
		
		
		JButton newSnippet = new JButton("New Snippet");
		
		newSnippet.setLocation(40, 460);
		newSnippet.setSize(85,20);
		newSnippet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton newFolder = new JButton("New Folder");
		
		newFolder.setLocation(155, 460);
		newFolder.setSize(85,20);
		newFolder.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		
		contentPane.add(newSnippet);
		contentPane.add(newFolder);
		
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			for(File file : fileroot.listFiles()) {
				try{
					
					FileWriter output = new FileWriter(file);
					output.write(editorPane_1.getText());
					output.close();
				}catch (IOException e1){
					e1.printStackTrace();
				}	
				
				
			}
			}
			private Object File(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		
		newSnippet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				TreePath tp = draftTree.getSelectionPath();
				
				if(tp==null) {return;}
				
				String snipPath = tp.toString();
				
				File snipRoot= new File(snipPath);
				
				while(snipRoot.isDirectory()) {
					snipRoot = snipRoot.getParentFile();
				}
				
				System.out.println(snipRoot);
				newSnippet snip = new newSnippet(snipRoot, draftTree);	
				
				snip.frmSnippet.setVisible(true);
				
				createChildren(fileroot, root);
				
								
			
			}
			
			private Object File(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		
			
		
	}
public Jibberish(){
		//default constructor for the first calling
		//use for testing and making sure things don't get wonky
		setTitle(" - Jibberish");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1368, 765);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnNewMenu.add(mntmSave);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnNewMenu.add(mntmOpen);
		
		JMenuItem mntmExport = new JMenuItem("Export");
		mnNewMenu.add(mntmExport);
		
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		Label label = new Label("PROJECT");
		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		label.setBounds(10, 39, 116, 22);
		contentPane.add(label);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 67, 250, 400);
		contentPane.add(tabbedPane_1);
		
		JButton newSnippet = new JButton("New Snippet");
		
		newSnippet.setLocation(40, 460);
		newSnippet.setSize(85,20);
		newSnippet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton newFolder = new JButton("New Folder");
		
		newFolder.setLocation(155, 460);
		newFolder.setSize(85,20);
		newFolder.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		
		contentPane.add(newSnippet);
		contentPane.add(newFolder);
		
		
		
		JTree draftTree = new JTree();
		draftTree.setFont(new Font("Tahoma", Font.BOLD, 16));
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.addTab("Draft", null, draftTree, null);
		
		
		
		
		
		JEditorPane editorPane_1 = new JEditorPane();
		JScrollPane sp = new JScrollPane(editorPane_1);
		
		
		
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		sp.getVerticalScrollBar();
		sp.setBounds(350,39,720,600);
		contentPane.add(sp);
		editorPane_1.setBounds(350, 39, 720, 600);
		
		
		
		
		
	}
}
