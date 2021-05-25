
import java.awt.BorderLayout;

import javax.swing.tree.TreePath;

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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
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
    
    public String rootPath;
    
    boolean nightMode;
    File[] dirs;
    
    //Sourced from https://coderanch.com/t/641799/java/Custom-Jtree-renderer
    //Fix the appearance of trees and prevents the full path from being shown
    private static class JibTreeRenderer extends DefaultTreeCellRenderer {  
    	 
        @Override 
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {  
     
            if(value instanceof DefaultMutableTreeNode){  
     
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;  
                Object userValue = node.getUserObject();  
     
                if(userValue instanceof File){  
                     // overwrite value with the new value to renderer; this is a local parameter/variable, you're not changing the actual content in the tree
                     value = ((File) userValue).getName();
                }  
               
            }  
            return super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);  
        }  
    }
    
    private void createChildren(File fileRoot, 
            DefaultMutableTreeNode node) {
        File[] files = fileRoot.listFiles();
        if(files == null){return;}

        for (File file : files) {
        		TreePath temp = new TreePath(file);
        		
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(temp.getLastPathComponent());
            //childNode.
          //  
           
           //childNode.setUserObject(file.getName());
            
            node.add(childNode);
        
           
            
           if (file.isDirectory()) {
        	   		//node.setUserObject(file.getName());
                createChildren(file, childNode);
            }
        }
       
    }
    
    
    
	public Jibberish(String projectName, boolean newProject){
		nightMode=false;
		
		File pName = new File(projectName);
		
		setTitle(pName.getName() + " - Jibberish");
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
		
		JMenuItem nightModeSwitch = new JMenuItem("Dark Mode");
		mnNewMenu.add(nightModeSwitch);
		
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		Label label = new Label("PROJECT");
		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		label.setBounds(10, 39, 116, 22);
		contentPane.add(label);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 67, 300, 400);
		contentPane.add(tabbedPane_1);
		
		File fileroot;
		
		if(newProject) {
			 fileroot = new File("Jibberish"+File.separator+projectName);
		}else {
			 fileroot=new File(projectName);
		}
		root = new DefaultMutableTreeNode(fileroot);
		
		
        treeModel = new DefaultTreeModel(root);
        
        createChildren(fileroot, root);

      
		JTree draftTree = new JTree(treeModel);
		draftTree.setShowsRootHandles(true);
		
		//CALLS THE INSTANCE OF THE CELL RENDER TO PREVENT SHOWING THE FULL PATH
		draftTree.setCellRenderer(new JibTreeRenderer());
		
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
	
		draftTree.addTreeSelectionListener(new TreeSelectionListener() {

            public void valueChanged(TreeSelectionEvent e) {
               
                rootPath=draftTree.getLastSelectedPathComponent().toString();
               // rootPath=rootPath.substring(1, rootPath.length()-1);
               // if (selection != null) {
                  // String key = (String)selection.getUserObject();
                   // System.out.println("Key: "+key);*/
                    System.out.println(rootPath);
                    if(draftTree.getSelectionPath()!=null) {
                		File file = new File(rootPath);
                		if(file.isFile()) {
                			try (BufferedReader reader = new BufferedReader(new FileReader(new File(rootPath)))) {
                	            editorPane_1.read(reader, "File");
                	        } catch (IOException exp) {
                	            exp.printStackTrace();
                	        }
                		}else {
                			DefaultTreeModel model = (DefaultTreeModel) draftTree.getModel();
                			//model.reload(root);
                			//createChildren(fileroot, root);
                			
                			
                		}
                	
                }
               // } else {
                    //descriptionLabel.setText(NOTHING_SELECTED);
              //  }
            }
        });
			
			
		
		
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
			File file = new File(rootPath);
			try {
					FileWriter output = new FileWriter(file);
					output.write(editorPane_1.getText());
					output.close();
				}catch (IOException e1){
					e1.printStackTrace();
				}		
				
			}
			private Object File(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		
		newSnippet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//fix this, man
				
				//TreePath tp = draftTree.getLastSelectedPathComponent();
				
				//if(tp==null) {return;}
		
		
				File temp  = new File(draftTree.getSelectionPath().toString());
				
				String snipPath = temp.getPath();
				snipPath = snipPath.substring(1, snipPath.length() - 1);
				
				File snipRoot= new File(snipPath);
				
				/*while(snipRoot.isDirectory()) {
					snipRoot = snipRoot.getParentFile();
				}*/
				
				System.out.println("SNIP ROOT:"+ snipRoot);
				draftTree.setName("Draft Tree Name here");
				newSnippet snip = new newSnippet(snipRoot, draftTree);	
				
				snip.frmSnippet.setVisible(true);
				
				//createChildren(fileroot, root);
				draftTree.setCellRenderer(new JibTreeRenderer());
				draftTree.updateUI();
				
			
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
