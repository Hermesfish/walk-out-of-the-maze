package paradise;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class DD extends JFrame{
 My_Panel jp=new My_Panel();
 DD(){
  Thread t=new Thread(jp);
  t.start();
  add(jp);
  setSize(500,500);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setVisible(true);
 }
 public static void main(String[] args) {
  new DD();
 }
}
class My_Panel extends JPanel implements Runnable{
 int x,y,r=100,theta=0;
 public void paint(Graphics g){
  x=(int)(200+r*Math.sin(theta));
  y=(int)(200+r*Math.cos(theta));
  g.drawOval(x, y, 100, 100);
 }
 public void run() {
  while(true){
   try {
    Thread.sleep(200);
    theta++;
    if(theta==360) theta=0;
    repaint();
   } catch (InterruptedException e) {
    e.printStackTrace();
   }
  }
 }
}
