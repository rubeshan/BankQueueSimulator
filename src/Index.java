import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Index {
	public static void main(String args[]) {

		GUI_frame window = new GUI_frame();
		GUI_frame.je.setText(null);
		window.setTitle("Bank Assignment");
		window.setVisible(true);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation(screen.width / 3, screen.height / 4);
		window.setSize(700, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		About about = new About();
		about.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Help help = new Help();
		help.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
