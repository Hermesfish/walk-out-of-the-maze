package paradise;

import java.awt.BorderLayout;



import java.awt.GridLayout;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FrameMain extends JFrame{
	JButton btnstart;
	JPanel eastPanel;
  public FrameMain(){
	  eastPanel=new JPanel( new GridLayout(1,1));
		 btnstart=new JButton("开始");
		 eastPanel.add(btnstart);
		 add(eastPanel,BorderLayout.EAST);
	 this.setTitle("走出迷宫V1.01"); 
	 this.setSize(825,645);
	 this.setResizable(false);
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	 this.setLocationRelativeTo(null);
	 this.setVisible(true);
  }
  public static void main(String[] args){
	  new FrameMain();
  }
}
 