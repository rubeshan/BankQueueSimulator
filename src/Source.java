import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileInputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Source extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final String[] names = { "Index", "Help", "About",
			"Graph_maker", "GUI_frame", "Source", "Question" };
	private JTextArea SourceViewer;

	public Source() {
		setResizable(false);
		Container pane = getContentPane();
		pane.setLayout(null);
		pane.setBackground(Color.orange);

		JButton close = new JButton("Close");
		CloseButtonHandler closeHandler = new CloseButtonHandler();
		close.addActionListener(closeHandler);
		close.setBackground(Color.red);

		JButton viewSource = new JButton("Choose File");
		ViewSource sourceHandler = new ViewSource();
		viewSource.addActionListener(sourceHandler);
		viewSource.setBackground(Color.green);

		SourceViewer = new JTextArea(30, 73);
		JScrollPane scrollPane = new JScrollPane(SourceViewer);

		JLabel title = new JLabel("SOURCE CODE VIEWER");
		Font currentFont = title.getFont();
		title.setFont(new Font(currentFont.getFontName(), currentFont
				.getStyle(), 20));

		pane.add(scrollPane);
		pane.add(title);
		pane.add(viewSource);
		pane.add(close);

		Insets position = pane.getInsets();
		Dimension size = close.getPreferredSize();
		close.setBounds(550 + position.left, 640 + position.top, 70, 20);

		size = title.getPreferredSize();
		title.setBounds(25 + position.left, 20 + position.top, size.width,
				size.height);

		size = scrollPane.getPreferredSize();
		scrollPane.setBounds(25 + position.left, 60 + position.top, size.width,
				size.height);

		size = viewSource.getPreferredSize();
		viewSource.setBounds(440 + position.left, 640 + position.top, 100, 20);
	}

	private class CloseButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	}

	private class ViewSource implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String inside;
			SourceViewer.setText(null);
			JFrame frame = new JFrame("Choose a File name.");
			frame.setBackground(Color.green);
			String FileName = (String) JOptionPane.showInputDialog(frame,
					"What source code do you want to see?", "Choose File name",
					JOptionPane.QUESTION_MESSAGE, null, names, names[0]);
			try {
				DataInput f = new DataInputStream(new FileInputStream("src/"
						+ FileName + ".java"));
				String txt = f.readLine();
				while (txt != null) {
					inside = txt;
					txt = f.readLine();
					String s = SourceViewer.getText();
					SourceViewer.setText(s + "\n" + inside);
				}
			} catch (Exception e1) {
				SourceViewer
						.setText("Your File with the Source Code is not Found");
			}
		}
	}
}