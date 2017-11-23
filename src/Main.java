import javax.swing.JFrame;
 
public class Main {
	public static void main(String args[]){
		JFrame frame = new Editor();
		frame.setTitle("NSEditor");
		frame.setVisible(true);
		frame.setSize(1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
	}
}