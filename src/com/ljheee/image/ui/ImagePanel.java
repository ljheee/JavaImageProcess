package com.ljheee.image.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * JPanel做背景图层
 */
public class ImagePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * JPanel背景要显示的图片
	 */
	private BufferedImage image = null;

	public ImagePanel(){
		super();
		java.net.URL imageURL = this.getClass().getResource("lena.jpg");//资源需在同一个package下
		try {
			image = ImageIO.read(imageURL);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("An error occured when loading the image icon...");
		}
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
	    Graphics2D g2 = (Graphics2D)g;  
	    // 反锯齿
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
	    		RenderingHints.VALUE_ANTIALIAS_ON);
	    
	    g2.fillRect(0, 0, getWidth(), getHeight());
	    
	    if(image != null){
	    	g2.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	    }
	}


	public static void main(String[] args){
		JFrame ui = new JFrame("Background Pic in JPanel");
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ui.setPreferredSize(new Dimension(380, 380));
		ui.setLocationRelativeTo(null);
		ui.getContentPane().setLayout(new BorderLayout());
		ui.getContentPane().add(new ImagePanel(), BorderLayout.CENTER);
		
		ui.pack();
		ui.setVisible(true);
	}
	

}
