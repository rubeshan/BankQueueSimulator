import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Help extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField input;

	public Help() {
		JButton Search = new JButton("Search");
		SearchButtonHandler searchHandler = new SearchButtonHandler();
		Search.addActionListener(searchHandler);
		JLabel title = new JLabel("Help Contents");
		input = new JTextField("         ");

		JEditorPane je = new JEditorPane();

		JScrollPane js = new JScrollPane();
		js.getViewport().add(je);

		try {
			URL url = new URL(
					"file:///D:/workspace/Final_project/src/helpcontents.html");

			je.setPage(url);
			je.setEditable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Container pane = getContentPane();
		pane.setLayout(null);

		pane.add(Search);
		pane.add(title);
		pane.add(input);
		pane.add(js);

		Insets position = pane.getInsets();
		Dimension size = title.getPreferredSize();
		title.setBounds(12 + position.left, 10 + position.top, size.width,
				size.height);

		size = Search.getPreferredSize();
		Search.setBounds(320 + position.left, 10 + position.top, size.width,
				size.height);

		size = input.getPreferredSize();
		input.setBounds(120 + position.left, 8 + position.top,
				size.width + 150, size.height + 10);

		size = js.getPreferredSize();
		js.setBounds(1 + position.left, 40 + position.top, 482,
				size.height + 700);

		for (int i = 0; i < 10; i++) {
			a[i] = i;
		}
	}

	private int[] a = new int[10];

	public int search(int v) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == v) {
				return i;
			} else {
			}

		}
		return -1;
	}

	private class SearchButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			@SuppressWarnings("unused")
			String search = input.getText();

			int pos = search(3);
			System.out.println("Found in position " + pos);

		}
	}

}
