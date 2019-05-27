package paradise;

import java.awt.*;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Members8 extends JFrame implements ActionListener,Runnable{
	
	int mx,my;
	int mi=0,mj=0;
	JButton btnstart;
	int count=1;
	int [][] datas={
			{1, 1, 1 ,1 ,1 ,1, 1, 1, 1 ,1 ,1, 1},
			{0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0, 0, 1},
			{1 ,0 ,1 ,1, 0, 1, 1, 1 ,1, 1, 0, 1},
			{1 ,0 ,0 ,1, 0, 1, 0, 0, 0, 0, 0 ,1},
			{1, 1, 1 ,1 ,0 ,1 ,0, 1 ,1 ,1 ,1 ,1},
			{1 ,0, 0, 0, 0, 1, 0 ,0, 0, 0 ,0, 1},
			{1 ,0, 1 ,1 ,1 ,1, 0, 1, 1, 1, 0, 1},
			{1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1 ,0, 1 ,0 ,1 ,1, 1 ,1, 1, 1, 0, 1},
			{1 ,0 ,1, 0, 0 ,1 ,0 ,1, 0, 1 ,0, 1},
			{1, 0, 1 ,0, 1, 1, 0 ,0 ,0 ,0, 1, 1},
			{1 ,0 ,0 ,0, 0 ,0, 0, 1 ,1, 0, 0, 0},
			{1 ,1, 1, 1 ,1, 1, 1, 1, 1 ,1 ,1 ,1},
	};
	
	int [][] route = new int [2][100];
/*
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
*/
	public Members8(){
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
		
		route[0][0] = 0;
		route[1][0] = 1;
		dfsMaze(1, 0, datas);
		/*
			try{
				Thread.sleep(300);
				// byleftmove();
				dfsMaze(1, 0, datas);
			}catch (InterruptedException e) {
			    e.printStackTrace();
			   }
		*/
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
/*
	private void remember(){
		mi=mx;
		mj=my;
		remembers[mj][mi]=1;
	}//remember的作用就是记住上一步。
*/
	
	private void victory(){
		for(int k = 0; k+1 < count; k++) {
			// System.out.println("(" + route[0][k+1] + "," + route[1][k+1] + ")" + "-");
			try{
				Thread.sleep(300);
				int locate_x =(int)lab_m.getLocation().getX();
			    int locate_y =(int)lab_m.getLocation().getY();
			    if(route[0][k]==route[0][k+1]) {
			    	if(route[1][k]==route[1][k+1]+1) {
			    		lab_m.setLocation(locate_x-50,locate_y);
			    		Icon i=new ImageIcon("pic/wolf-left.png");
			    		lab_m.setIcon(i);
			    	}
			    	else if(route[1][k]==route[1][k+1]-1) {
			    		lab_m.setLocation(locate_x+50,locate_y);
			    		Icon i=new ImageIcon("pic/wolf-right.png");
			    		lab_m.setIcon(i);
			    	}
			    }
			    if(route[1][k]==route[1][k+1]) {
			    	if(route[0][k]==route[0][k+1]+1) {
			    		lab_m.setLocation(locate_x,locate_y-50);
			    		Icon i=new ImageIcon("pic/wolf-back.png");
			    		lab_m.setIcon(i);
			    	}
			    	else if(route[0][k]==route[0][k+1]-1) {
			    		lab_m.setLocation(locate_x,locate_y+50);
			    		Icon i=new ImageIcon("pic/wolf-front.png");
			    		lab_m.setIcon(i);
			    	}
			    }
		
			}catch (InterruptedException e) {
			    e.printStackTrace();
			   }
		}
		
		Icon i=new ImageIcon("pic/wolf.png");
		JOptionPane.showMessageDialog(null,"游戏结束","走出迷宫",2,i);
	}
	
	private void dfsMaze(int x, int y, int[][] maze) {
        /*
         * 获得矩阵的大小
         * */
        int m=maze.length;
        int n=maze[0].length;
        //设置结束条件
        if (x < 0 || y < 0)
            return;
        // 如果坐标越界，或者 maze[x][y]==1 表示遇到障碍
        if (x > m - 1 || y > n - 1 || maze[x][y] ==1)
            return;
        //表示遇到障碍
        if (maze[x][y] == 1)
            return; // 判断是否通路和越界
        
        maze[x][y] = 1; // 将走过的路标记
        route[0][count] = x;
        route[1][count] = y;
        count++;
        
        if (x == 11 && y == 11) { // 判断是否抵达出口
            victory();
            return;
        }
        //System.out.println("(" + x + "," + y + ")" + "-");
/*
        try{
			Thread.sleep(300);
			int locate_x =(int)lab_m.getLocation().getX();
		    int locate_y =(int)lab_m.getLocation().getY();
		    lab_m.setLocation(locate_x,locate_y);
		    Icon i=new ImageIcon("pic/wolf-back.png");
		    lab_m.setIcon(i);
		}catch (InterruptedException e) {
		    e.printStackTrace();
		   }
*/
        // 向四个方向搜索
        	dfsMaze(x + 1, y, maze);  //向右搜索
        
			dfsMaze(x, y + 1, maze);  //向下搜索
		
			dfsMaze(x, y - 1, maze);  //向上搜索
        
			dfsMaze(x - 1, y, maze);  //向左搜索
        // 将路线和标记恢复成上一次的状态
        maze[x][y] = 0;
        //清除
        count--;
    }

	
	public void actionPerformed(ActionEvent e){
		
		
		new Thread(this).start();
    }	
	
	
	public static void main(String[] args){
		new Members8();
	}
}

