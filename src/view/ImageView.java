package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import controller.ImageListener;
import model.ImageModel;

public class ImageView extends JFrame
{
	private JLabel jLabel;

	private ImageModel imageModel ;

	public ImageView() 
	{
		this.setLayout( new BorderLayout());
		imageModel = new ImageModel();
			
			ImageIcon JFrameImageIcon= new ImageIcon("E:\\java_swing\\_15_Image\\bin\\view\\shrimp_icon.png");
			
			Image JFrameImage = JFrameImageIcon.getImage();
			this.setIconImage(JFrameImage);
		ImageListener listener = new ImageListener(this);
		
		// tạo menu Bar
		JMenuBar jMenuBar = new JMenuBar();
		this.setJMenuBar(jMenuBar);
		
		JMenu jMenuFile = new JMenu("File");
		jMenuFile.setMnemonic('F');
		
		JMenuItem jMenuItemNew= new JMenuItem("New",  KeyEvent.VK_N);
		jMenuItemNew.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
			ImageIcon NewIcon = new ImageIcon("E:\\java_swing\\_15_Image\\bin\\view\\new_icon.png");
			jMenuItemNew.setIcon(NewIcon);
		
		JMenuItem jMenuItemSave= new JMenuItem("Save", KeyEvent.VK_S);
		jMenuItemSave.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK));
			ImageIcon SaveIcon = new ImageIcon("E:\\java_swing\\_15_Image\\bin\\view\\save_icon.png");
			jMenuItemSave.setIcon(SaveIcon);
			
		JMenuItem jMenuItemSaveAs= new JMenuItem("Save as");
			ImageIcon saveAsIcon = new ImageIcon("E:\\java_swing\\_15_Image\\bin\\view\\save_as_icon.png");
			jMenuItemSaveAs.setIcon(saveAsIcon);
			
		JMenuItem jMenuItemOpen = new JMenuItem("Open", KeyEvent.VK_O);
		jMenuItemOpen.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK));
			ImageIcon openIcon = new ImageIcon("E:\\java_swing\\_15_Image\\bin\\view\\open_icon.png");
			jMenuItemOpen.setIcon(openIcon);
			
		
		JMenuItem jMenuItemClose = new JMenuItem("Close", KeyEvent.VK_X);
		jMenuItemClose.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_DOWN_MASK));
			ImageIcon closeIcon = new ImageIcon("E:\\java_swing\\_15_Image\\bin\\view\\close_icon.png");
			jMenuItemClose.setIcon(closeIcon);
			
		JMenu subMenu= new JMenu("Sub menu");
			
		JMenuItem jMenuItemPrint= new JMenuItem("Print");
			ImageIcon printIcon = new ImageIcon("E:\\java_swing\\_15_Image\\bin\\view\\print_icon.png");
			jMenuItemPrint.setIcon(printIcon);
			
		JMenuItem jMenuItemExit= new JMenuItem("Exit");
			ImageIcon exitIcon = new ImageIcon("E:\\java_swing\\_15_Image\\bin\\view\\exit_icon.png");
			jMenuItemExit.setIcon(exitIcon);
		
		subMenu.add(jMenuItemPrint);
		subMenu.add(jMenuItemExit);
		
		jMenuFile.add(jMenuItemNew);
		jMenuFile.add(jMenuItemOpen);
		jMenuFile.add(jMenuItemSave);
		jMenuFile.add(jMenuItemSaveAs);
		jMenuFile.add(jMenuItemClose);
		jMenuFile.add(subMenu);
		
		jMenuBar.add(jMenuFile);
		
		jLabel = new JLabel ();
		jLabel.setHorizontalAlignment( SwingConstants.CENTER);
		
		
		JPanel jPanel = new JPanel();
		
		jPanel.setLayout( new GridLayout(1,2));
		
		JButton jButtonRight = new JButton("");
		jButtonRight.setActionCommand("ButtonRight");
			ImageIcon rightIcon = new  ImageIcon("E:\\java_swing\\_15_Image\\bin\\view\\next_right_icon.png");
			jButtonRight.setIcon(rightIcon);
		jButtonRight.addActionListener(listener);
		
		JButton jButtonLeft = new JButton("");
		jButtonLeft.setActionCommand("ButtonLeft");
			ImageIcon leftIcon = new  ImageIcon("E:\\java_swing\\_15_Image\\bin\\view\\next_left_icon.png");
			jButtonLeft.setIcon(leftIcon);
		jButtonLeft.addActionListener(listener);
		
		jPanel.add(jButtonLeft);
		jPanel.add(jButtonRight);
		
		
		this.add(jLabel, BorderLayout.CENTER);
		this.add(jPanel, BorderLayout.SOUTH);
		
		this.setImage();
		
		init();
	}
	
	public void init()
	{
		this.setTitle(" See my Handsome Image :3");
		this.setSize(600,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
	
	public void setImage()
	{
		String s="image" + this.imageModel.getNum()+ ".png";
		
		ImageIcon imageIcon= new ImageIcon("E:\\java_swing\\_15_Image\\bin\\view\\"+s);
		jLabel.setIcon(imageIcon);
	}
	
	public void increase()
	{
		this.imageModel.increase();
		this.setImage();
	}

	public void decrease()
	{
		this.imageModel.decrease();
		this.setImage();
	}
}
