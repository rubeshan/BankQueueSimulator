import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Question extends JFrame {
	private static final long serialVersionUID = 1L;

	public Question() {
		setResizable(false);
		JButton close = new JButton("Close");
		CloseButtonHandler closeHandler = new CloseButtonHandler();
		close.addActionListener(closeHandler);
		Container pane = getContentPane();
		pane.setLayout(null);

		JLabel title = new JLabel("A Bank Simulator");
		Font currentFont = title.getFont();

		title.setFont(new Font(currentFont.getFontName(), currentFont
				.getStyle(), 30));

		JLabel text1 = new JLabel(
				"Simulate the operation of a bank. Customers enter the bank, and there");
		JLabel text2 = new JLabel(
				"are one or more tellers. If a teller is free, that teller serves");
		JLabel text3 = new JLabel(
				"the customer. Otherwise the customer enters the queue and waits until");
		JLabel text4 = new JLabel(
				"a teller is free. Your program should accept the following inputs:");
		JLabel text5 = new JLabel("· The arrival rate for the customers");
		JLabel text6 = new JLabel("· The average processing time");
		JLabel text7 = new JLabel(". The number of tellers");
		JLabel text8 = new JLabel(
				"Use your program to determine how many tellers are required for a given");
		JLabel text9 = new JLabel(
				"arrival rate and average processing time. Implement a graphical simulation.");

		pane.add(title);
		pane.add(text1);
		pane.add(text2);
		pane.add(text3);
		pane.add(text4);
		pane.add(text5);
		pane.add(text6);
		pane.add(text7);
		pane.add(text8);
		pane.add(text9);
		pane.add(close);
		Insets position = pane.getInsets();
		Dimension size = close.getPreferredSize();
		close.setBounds(380 + position.left, 340 + position.top, 70, 20);

		size = title.getPreferredSize();
		title.setBounds(35 + position.left, 40 + position.top, size.width,
				size.height);

		size = text1.getPreferredSize();
		text1.setBounds(35 + position.left, 90 + position.top, size.width,
				size.height);

		size = text2.getPreferredSize();
		text2.setBounds(35 + position.left, 110 + position.top, size.width,
				size.height);
		size = text3.getPreferredSize();
		text3.setBounds(35 + position.left, 130 + position.top, size.width,
				size.height);
		size = text4.getPreferredSize();
		text4.setBounds(35 + position.left, 150 + position.top, size.width,
				size.height);
		size = text5.getPreferredSize();
		text5.setBounds(35 + position.left, 190 + position.top, size.width,
				size.height);
		size = text6.getPreferredSize();
		text6.setBounds(35 + position.left, 210 + position.top, size.width,
				size.height);
		size = text7.getPreferredSize();
		text7.setBounds(35 + position.left, 230 + position.top, size.width,
				size.height);
		size = text8.getPreferredSize();
		text8.setBounds(35 + position.left, 275 + position.top, size.width,
				size.height);
		size = text9.getPreferredSize();
		text9.setBounds(35 + position.left, 295 + position.top, size.width,
				size.height);
	}

	private class CloseButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	}
}
