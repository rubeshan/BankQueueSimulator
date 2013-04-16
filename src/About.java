import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame {
	private static final long serialVersionUID = 1L;

	public About() {
		setResizable(false);
		JButton close = new JButton("OK");
		CloseButtonHandler closeHandler = new CloseButtonHandler();
		close.addActionListener(closeHandler);
		Container pane = getContentPane();
		pane.setLayout(null);

		ImageIcon pic = new ImageIcon("images/uoit.jpg");
		JLabel image = new JLabel(pic);
		ImageIcon Logo = new ImageIcon("images/logo.jpg");
		JLabel logo = new JLabel(Logo);
		ImageIcon divider = new ImageIcon("images/HR.jpg");
		JLabel HR = new JLabel(divider);

		JLabel text1 = new JLabel("Data Structures");
		JLabel text2 = new JLabel("Version 1.1 (Build 1201)");
		JLabel text3 = new JLabel(
				"Copyright c 2011 University of Ontario. All rights reserved.");
		JLabel text4 = new JLabel(
				"The Bank Simulation and its  Graphical user Interface are ");
		JLabel text5 = new JLabel(
				"protected by trademark and other pending or existing intellectual");
		JLabel text6 = new JLabel(
				"property rights in Canada and other countries");
		JLabel text7 = new JLabel(
				"This product is licensed under the UOIT license terms to:");
		JLabel text8 = new JLabel("UOSL 10-X");
		JLabel text9 = new JLabel("UOSL 10-X");

		pane.add(image);
		pane.add(HR);
		pane.add(logo);
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

		size = image.getPreferredSize();
		image.setBounds(60 + position.left, 20 + position.top, size.width,
				size.height);

		size = HR.getPreferredSize();
		HR.setBounds(20 + position.left, 140 + position.top, size.width - 320,
				size.height);
		size = logo.getPreferredSize();
		logo.setBounds(15 + position.left, 154 + position.top, size.width,
				size.height);

		size = text1.getPreferredSize();
		text1.setBounds(50 + position.left, 150 + position.top, size.width,
				size.height);
		size = text2.getPreferredSize();
		text2.setBounds(50 + position.left, 165 + position.top, size.width,
				size.height);
		size = text3.getPreferredSize();
		text3.setBounds(50 + position.left, 180 + position.top, size.width,
				size.height);
		size = text4.getPreferredSize();
		text4.setBounds(50 + position.left, 195 + position.top, size.width,
				size.height);
		size = text5.getPreferredSize();
		text5.setBounds(50 + position.left, 210 + position.top, size.width,
				size.height);
		size = text6.getPreferredSize();
		text6.setBounds(50 + position.left, 225 + position.top, size.width,
				size.height);
		size = text7.getPreferredSize();
		text7.setBounds(50 + position.left, 280 + position.top, size.width,
				size.height);
		size = text8.getPreferredSize();
		text8.setBounds(50 + position.left, 295 + position.top, size.width,
				size.height);
		size = text9.getPreferredSize();
		text9.setBounds(50 + position.left, 310 + position.top, size.width,
				size.height);
	}

	private class CloseButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	}
}
