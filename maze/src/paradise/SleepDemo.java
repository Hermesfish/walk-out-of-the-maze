package paradise;
//трг╫ к╞╬У трг╫ к╞╬У трг╫ трг╫ к╞╬У трг╫ тр╢╘ак ╦ибОдьё║ффоЮак
//р╩╠ътрг╫ё╛р╩╠ък╞╬У
public class SleepDemo {
	 public static void main(String[] args) {
	  Thread t = new Thread() {
	   public void run() {
	    for (int i = 0; i < 5; i++) {
	     System.out.println("к╞╬У");
	     try {
	      Thread.sleep(10000);
	     } catch (InterruptedException e) {
	      // e.printStackTrace();
	      System.out.println("╦ибОдьё║ффоЮак");
	      break;
	     }
	    }
	   }
	  };
	  t.start();
	  for (int i = 0; i < 5; i++) {
	   System.out.println("трг╫");
	   try {
	    Thread.sleep(5000);
	   } catch (InterruptedException e) {
	    e.printStackTrace();
	   }
	  }
	  System.out.println("тр╢╘ак");
	  t.interrupt();// ╢Р╤ооъЁлt╣дsleep
	 }
	}
