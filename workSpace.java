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
import java.io.File;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

public class workSpace extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					workSpace frame = new workSpace();
					frame.setExtendedState(MAXIMIZED_BOTH);
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
	public workSpace() {
		setTitle("JIBBERISH");
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
		
		JTree draftTree = new JTree();
		draftTree.setFont(new Font("Tahoma", Font.BOLD, 16));
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.addTab("Draft", null, draftTree, null);
		
		JTree peopleTree = new JTree();
		peopleTree.setFont(new Font("Tahoma", Font.BOLD, 16));
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.addTab("People", null, peopleTree, null);
		
		JTree placesTree = new JTree();
		placesTree.setFont(new Font("Tahoma", Font.BOLD, 16));
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.addTab("Places", null, placesTree, null);
		
		JTree thingsTree = new JTree();
		thingsTree.setFont(new Font("Tahoma", Font.BOLD, 16));
		JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.addTab("Things", null, thingsTree, null);
		NewProject newProject = new NewProject();
		
		
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
