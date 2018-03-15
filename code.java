package paradise;

import java.awt.*;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Members7 extends JFrame implements ActionListener,Runnable{
	
	int mx,my;
	int mi=0,mj=0;
	JButton btnstart;
	int [][] datas={
			{1, 1, 1 ,1 ,1 ,1, 1, 1, 1 ,1 ,1, 1},
			{0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0, 0, 1},
			{1 ,0 ,1 ,1, 0, 1, 1, 1 ,1, 1, 0, 1},
			{1 ,0 ,0 ,1, 0, 1, 0, 0, 0, 0, 0 ,1},
			{1, 1, 1 ,1 ,0 ,1 ,0, 1 ,1 ,1 ,1 ,1},
			{1 ,0, 0, 0, 0, 1, 0 ,0, 0, 0 ,0, 1},
			{1 ,0, 1 ,1 ,1 ,1, 1, 1, 1, 1, 0, 1},
			{1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1 ,0, 1 ,0 ,1 ,1, 1 ,1, 1, 1, 0, 1},
			{1 ,0 ,1, 0, 0 ,1 ,0 ,1, 0, 1 ,0, 1},
			{1, 0, 1 ,1, 1, 1, 0 ,0 ,0 ,1, 1, 1},
			{1 ,0 ,0 ,0, 0 ,0, 0, 1 ,0, 0, 0, 0},
			{1 ,1, 1, 1 ,1, 1, 1, 1, 1 ,1 ,1 ,1},
	};
	int [][] remembers={
			{0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
			{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0, 0 ,0 ,0 ,0},
			{0 ,0, 0, 0 ,0 ,0 ,0 ,0, 0 ,0 ,0 ,0},
			{0, 0, 0 ,0, 0, 0, 0, 0 ,0 ,0 ,0 ,0},
			{0 ,0 ,0, 0 ,0 ,0 ,0 ,0 ,0 ,0, 0, 0},
		    {0, 0, 0, 0 ,0, 0, 0 ,0 ,0 ,0, 0 ,0},
			{0, 0 ,0, 0, 0, 0 ,0 ,0, 0 ,0, 0 ,0},
			{0, 0, 0, 0 ,0, 0 ,0, 0 ,0 ,0 ,0 ,0},
			{0 ,0 ,0, 0, 0, 0 ,0 ,0 ,0, 0, 0, 0},
			{0, 0, 0 ,0 ,0, 0 ,0 ,0 ,0 ,0, 0 ,0},
			{0, 0 ,0 ,0, 0 ,0 ,0, 0 ,0 ,0 ,0 ,0},
			{0, 0 ,0 ,0 ,0, 0, 0 ,0 ,0 ,0 ,0 ,0},
			{0, 0 ,0 ,0 ,0, 0, 0, 0 ,0 ,0 ,0, 0},
	};
	public Members7(){
		Thread t=new Thread();
		t.start();
		treeInit();
		mushroomInit();
		backGroundInit();
		mybutton();
		framemain();
		btnstart.addActionListener(this);
	}
	public void run(){
		right();
		while (true){
			try{
				Thread.sleep(300);
				byleftmove();
			}catch (InterruptedException e) {
			    e.printStackTrace();
			   }
			
			
		}
	}
	private void framemain(){
		 this.setTitle("走出迷宫V1.01"); 
		 this.setSize(700,700);
		 this.setResizable(false);//不可改变窗体大小
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		 this.setLocationRelativeTo(null);
		 this.setVisible(true);
	}
	private void mybutton(){
		btnstart=new JButton("开始");
		btnstart.setBounds(600, 250, 100,200);
		this.add(btnstart);
		setLayout(null);
	}//按钮不显示（太小了，没看见）
	private void backGroundInit(){
		Icon i =new ImageIcon("pic/floor.png");
		JLabel lab_bg=new JLabel(i);	
		lab_bg.setBounds(0,0,600,650);
		this.add(lab_bg);
		setLayout(null);
	}//默认居中了，什么鬼？加上setLayout(null)即可
	
	private void mushroomInit(){
		mx=0;
		my=1;
		Icon i=new ImageIcon("pic/wolf-front.png");
		lab_m=new JLabel(i);
		lab_m.setBounds(mx*50, my*50, 50, 50);
		this.add(lab_m);
	}
	JLabel lab_m;
	private void treeInit(){
		Icon k=new ImageIcon("pic/tree.png");
		JLabel t =null;
		for (int i=0;i<datas.length;i++){
			for (int j=0;j<datas[i].length;j++){
				if (datas[i][j]==1){
					t=new JLabel(k);
					t.setBounds(j*50,i*50,50,50);
					this.add(t);
				}
			}
		}
	}
	private void remember(){
		mi=mx;
		mj=my;
		remembers[mj][mi]=1;
	}//remember的作用就是记住上一步。
	private void up(){
		
			remember();
		    my-=1;
		    int x =(int)lab_m.getLocation().getX();
		    int y =(int)lab_m.getLocation().getY();
		    lab_m.setLocation(x,y-50);
		    Icon i=new ImageIcon("pic/wolf-back.png");
		    lab_m.setIcon(i);	
		    victory();
	}
	private void down(){
		
			remember();
		    my+=1;
		    int x =(int)lab_m.getLocation().getX();
		    int y =(int)lab_m.getLocation().getY();
		    lab_m.setLocation(x,y+50);
		    Icon i=new ImageIcon("pic/wolf-front.png");
		    lab_m.setIcon(i);
		    victory();
		    
	}
	private void left(){
		
			remember();
		    mx-=1;
		    int x =(int)lab_m.getLocation().getX();
		    int y =(int)lab_m.getLocation().getY();
		    lab_m.setLocation(x-50,y);
		    Icon i=new ImageIcon("pic/wolf-left.png");
		    lab_m.setIcon(i);
		    victory();
		    
	}
	private void right(){
		
			remember();
		    mx+=1;
		    int x =(int)lab_m.getLocation().getX();
		    int y =(int)lab_m.getLocation().getY();
		    lab_m.setLocation(x+50,y);
		    Icon i=new ImageIcon("pic/wolf-right.png");
		    lab_m.setIcon(i);
		    victory();
	}
	private void victory(){
		if(mx==11&&my==11){
			Icon i=new ImageIcon("pic/wolf.png");
		JOptionPane.showMessageDialog(null,"游戏结束","走出迷宫",2,i);
		}
	}
	private void byleftmove(){
		
		//4种三路均堵塞的
		if(datas[my][mx+1]==1&&datas[my][mx-1]==1
				&&datas[my+1][mx]==1&&datas[my-1][mx]==0){
			up();
			return;
		}
		if(datas[my][mx+1]==1&&datas[my][mx-1]==1
				&&datas[my-1][mx]==1&&datas[my+1][mx]==0){
			down();
			return;
		}
		if(datas[my+1][mx]==1&&datas[my-1][mx]==1
				&&datas[my][mx+1]==1&&datas[my][mx-1]==0){
			left();
			return;
		}
		if(datas[my+1][mx]==1&&datas[my-1][mx]==1
				&&datas[my][mx-1]==1&&datas[my][mx+1]==0){
			right();
			return;
		}
		
		//12种一路堵塞的。
		//这里写了以up为障碍的3种情况，注意要把代码再写清楚点。
		if(mi==mx-1&&mj==my&&datas[my][mx+1]==0&&
				datas[my-1][mx]==1&&datas[my+1][mx]==0){
			right();
			return;
		}//从左往右
		if(mi==mx+1&&mj==my&&datas[my][mx-1]==0&&
				datas[my-1][mx]==1&&datas[my+1][mx]==0){
			down();
			return;
		}//从右往左
		if(mi==mx&&mj==my+1&&datas[my][mx+1]==0&&
				datas[my-1][mx]==1&&datas[my][mx-1]==0){
			left();
			return;
		}//从下往上
		
		//这里写以down为障碍的3种情况。
		if(datas[my+1][mx]==1&&datas[my-1][mx]==0&&
				datas[my][mx+1]==0&&mi==mx-1&&mj==my){
			up();
			return;
		}//从左往右
		if(datas[my+1][mx]==1&&datas[my-1][mx]==0&&
				datas[my][mx-1]==0&&mi==mx+1&&mj==my){
			left();
			return;
		}//从右往左
		if(datas[my+1][mx]==1&&datas[my][mx+1]==0&&
				datas[my][mx-1]==0&&mi==mx&&mj==my-1){
			right();
			return;
		}//从上往下
		
		//这里写了以left为障碍的3种情况
		if(datas[my][mx-1]==1&&datas[my][mx+1]==0&&
				datas[my+1][mx]==0&&mi==mx&&mj==my-1){
			right();
			return;
		}//从上往下
		if(datas[my][mx-1]==1&&datas[my][mx+1]==0&&
				datas[my-1][mx]==0&&mi==mx&&mj==my+1){
			up();
			return;
		}//从下往上
		if(datas[my][mx-1]==1&&datas[my-1][mx]==0&&
				datas[my+1][mx]==0&&mi==mx+1&&mj==my){
			down();
			return;
		}//从右往左
		
		//这里写以right为障碍的3种情况。
		if(datas[my][mx+1]==1&&datas[my][mx-1]==0&&
				datas[my+1][mx]==0&&mi==mx&&mj==my-1){
			down();
			return;
		}//从上往下
		if(datas[my][mx+1]==1&&datas[my][mx-1]==0&&
				datas[my-1][mx]==0&&mi==mx&&mj==my+1){
			left();
			return;
		}//从下往上
		if(datas[my][mx+1]==1&&datas[my-1][mx]==0&&
				datas[my+1][mx]==0&&mi==mx-1&&mj==my){
			up();
			return;
		}//从左往右
		
		//12种两路堵塞的
		//先设置1，2位置为障碍，共两种情况
		if(datas[my][mx-1]==1&&datas[my-1][mx]==1&&
				datas[my+1][mx]==0&&mi==mx+1&&mj==my){
			down();
			return;
		}//从右往左
		if(datas[my][mx-1]==1&&datas[my-1][mx]==1&&
				datas[my][mx+1]==0&&mi==mx&&mj==my+1){
			right();
			return;
		}//从下往上
		
		//再设置1，3位置为障碍的，两种情况
		if(datas[my][mx-1]==1&&datas[my][mx+1]==1&&
				datas[my+1][mx]==0&&mi==mx&&mj==my-1){
			down();
			return;
		}//从上往下
		if(datas[my][mx-1]==1&&datas[my][mx+1]==1&&
				datas[my-1][mx]==0&&mi==mx&&mj==my+1){
			up();
			return;
		}//从下往上
		
		//再设置1，4位置的，两种情况
		if(datas[my][mx-1]==1&&datas[my+1][mx]==1&&
				datas[my][mx+1]==0&&mi==mx&&mj==my-1){
			right();
			return;
		}//从上往下
		if(datas[my][mx-1]==1&&datas[my+1][mx]==1&&
				datas[my-1][mx]==0&&mi==mx+1&&mj==my){
			up();
			return;
		}//从右往左
		
		//设置2，3位置为障碍，共两种情况
		if(datas[my-1][mx]==1&&datas[my][mx+1]==1&&
				datas[my+1][mx]==0&&mi==mx-1&&mj==my){
			down();
			return;
		}//从左往右
		if(datas[my-1][mx]==1&&datas[my][mx+1]==1&&
				datas[my][mx-1]==0&&mi==mx&&mj==my+1){
			left();
			return;
		}//从下往上
		
		//设置2，4位置为障碍，共两种情况
		if(datas[my+1][mx]==1&&datas[my-1][mx]==1&&
				datas[my][mx+1]==0&&mi==mx-1&&mj==my){
			right();
			return;
		}//从左往右
		if(datas[my+1][mx]==1&&datas[my-1][mx]==1&&
				datas[my][mx-1]==0&&mi==mx+1&&mj==my){
			left();
			return;
		}//从右往左
		
		//最后设置3，4的位置为障碍，共两种情况
		if(datas[my][mx+1]==1&&datas[my+1][mx]==1&&
				datas[my-1][mx]==0&&mi==mx-1&&mj==my){
			up();
			return;
		}//从左往右
		if(datas[my][mx+1]==1&&datas[my+1][mx]==1&&
				datas[my][mx-1]==0&&mi==mx&&mj==my-1){
			left();
			return;
		}//从上往下
	}
	
	
	public void actionPerformed(ActionEvent e){
		
		
		new Thread(this).start();
    }	
	
	
	public static void main(String[] args){
		new Members7();
	}
}
