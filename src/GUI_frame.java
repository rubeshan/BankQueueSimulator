import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

public class GUI_frame extends JFrame {
	private static final long serialVersionUID = 1L;

	private JMenu menu;
	private JMenuItem menuItem;
	private JMenuBar menubar;
	private JTextField ArrivalRate, ProcessTime, Tellers;

	static TextArea je;

	public GUI_frame() {
		setResizable(false);

		je = new TextArea();
		je.setEditable(true);

		JScrollPane js = new JScrollPane(je);

		ArrivalRate = new JTextField("8");
		ProcessTime = new JTextField("1000");
		Tellers = new JTextField("2");

		ImageIcon pic = new ImageIcon("images/cover.jpg");
		JLabel image = new JLabel(pic);

		JButton Run = new JButton("RUN");
		Run.setBackground(Color.MAGENTA);
		RunButtonHandler closeHandler = new RunButtonHandler();
		Run.addActionListener(closeHandler);

		JLabel title = new JLabel("Bank QUEUE Tester");
		Font currentFont = title.getFont();
		title.setFont(new Font(currentFont.getFontName(), currentFont
				.getStyle(), 30));

		JLabel arrivalRate = new JLabel("Arrival rate");
		JLabel processTime = new JLabel("Process Time");
		JLabel tellers = new JLabel("Tellers");

		menubar = new JMenuBar();
		menubar.setBackground(Color.white);

		/**
		 * The File Menu contains New Exit Save
		 */
		// Add the File menu option
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		menu.getAccessibleContext().setAccessibleDescription(
				"This is the file menu");
		menubar.add(menu);

		// Add the reset option
		menuItem = new JMenuItem("New");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				ActionEvent.CTRL_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"Create New File");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrivalRate.setText(" ");
				ProcessTime.setText(" ");
				Tellers.setText("  ");
			}
		});
		menu.add(menuItem);

		// Add the open option
		menuItem = new JMenuItem("Open");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				ActionEvent.CTRL_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"exit the program");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadContent();
			}
		});
		menu.add(menuItem);

		// Add the save Option
		menuItem = new JMenuItem("Save");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"exit the program");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveContent();
			}
		});
		menu.add(menuItem);

		// Add the exit option
		menuItem = new JMenuItem("Exit");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"exit the program");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(menuItem);

		// ------------------------------------------------------------/

		/**
		 * Edit Menu contains Undo Redo Copy Cut Preferences
		 */
		// Add the Edit menu option
		menu = new JMenu("Edit");
		menu.setMnemonic(KeyEvent.VK_E);
		menu.getAccessibleContext().setAccessibleDescription(
				"This is the Edit menu");
		menubar.add(menu);
		// Add the Undo option for the Edit menu

		menuItem = new JMenuItem("Copy");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				ActionEvent.CTRL_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"One action forward");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrivalRate.selectAll();
			}
		});
		menu.add(menuItem);

		menuItem = new JMenuItem("Cut");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.CTRL_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"One action forward");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrivalRate.cut();
			}
		});
		menu.add(menuItem);
		// -------------------------------------------------------//

		/**
		 * View Menu contains source Question Graph
		 */

		menu = new JMenu("View");
		menu.setMnemonic(KeyEvent.VK_V);
		menu.getAccessibleContext().setAccessibleDescription(
				"This is the View Menu");
		menubar.add(menu);

		menuItem = new JMenuItem("Question");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"View Question");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Question question = new Question();
				Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
				question.setLocation(screen.width / 3, screen.height / 4);

				question.setVisible(true);
				question.setTitle("The Question");
				question.setSize(470, 400);
			}
		});
		menu.add(menuItem);

		// Add the ViewSource Option
		menuItem = new JMenuItem("Source");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"View Question");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Source source = new Source();
				Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
				source.setLocation(screen.width / 3, screen.height / 4);
				source.setVisible(true);
				source.setTitle("The Question");
				source.setSize(650, 700);
			}
		});
		menu.add(menuItem);

		/**
		 * Help Menu contains Help Topics About
		 */
		// Add the Help menu Option
		menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_H);
		menu.getAccessibleContext().setAccessibleDescription(
				"This is the Help Menu");

		menubar.add(menu);

		// Add the Help Topics Option
		menuItem = new JMenuItem("Help topics");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"Help about the Program");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Help help = new Help();
				help.setVisible(true);
				Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
				help.setLocation(screen.width / 3, screen.height / 8);
				help.setResizable(false);

				help.setSize(500, 800);
				help.setTitle("Help Contents");
			}
		});
		menu.add(menuItem);

		menuItem = new JMenuItem("About");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"About this software");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About about = new About();
				about.setVisible(true);
				Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
				about.setLocation(screen.width / 3, screen.height / 4);
				about.setTitle("About Bank Simulation");
				about.setSize(470, 400);
			}
		});
		menu.add(menuItem);

		Container pane = getContentPane();
		;
		pane.setLayout(null);
		pane.add(title);
		pane.add(ArrivalRate);
		pane.add(ProcessTime);
		pane.add(Tellers);
		pane.add(arrivalRate);
		pane.add(processTime);
		pane.add(tellers);
		pane.add(Run);
		pane.add(js);
		pane.add(image);

		Insets position = pane.getInsets();
		Dimension size = title.getPreferredSize();
		title.setBounds(10 + position.left, 10 + position.top, size.width,
				size.height);

		size = ArrivalRate.getPreferredSize();
		ArrivalRate.setBounds(550 + position.left, 5 + position.top, 50,
				size.height);

		size = ProcessTime.getPreferredSize();
		ProcessTime.setBounds(550 + position.left, 25 + position.top, 50,
				size.height);

		size = Tellers.getPreferredSize();
		Tellers.setBounds(550 + position.left, 45 + position.top, 50,
				size.height);

		size = arrivalRate.getPreferredSize();
		arrivalRate.setBounds(465 + position.left, 5 + position.top,
				size.width + 20, size.height);

		size = processTime.getPreferredSize();
		processTime.setBounds(465 + position.left, 25 + position.top,
				size.width + 20, size.height);

		size = tellers.getPreferredSize();
		tellers.setBounds(465 + position.left, 45 + position.top,
				size.width + 20, size.height);

		size = Run.getPreferredSize();
		Run.setBounds(350 + position.left, 10 + position.top, 60, 60);

		size = js.getPreferredSize();
		js.setBounds(0 + position.left, 80 + position.top, 694, 469);

		setContentPane(pane);
		setJMenuBar(menubar);
		pack();

		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();

		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (Exception e) {
			System.err.println("Couldn't get specified look and feel ("
					+ lookAndFeel + "), for some reason.");
			System.err.println("Using the default look and feel.");
			e.printStackTrace();
		}

	}

	public void loadContent() {
		String OpenName = JOptionPane
				.showInputDialog("Enter the file Name to Open..");
		try {
			DataInput f = new DataInputStream(new FileInputStream(
					"Saved files/" + OpenName + ".txt"));
			String txt = f.readLine();
			while (txt != null) {

				ArrivalRate.setText(null);
				String A = ArrivalRate.getText();
				ArrivalRate.setText(txt + A);
				txt = f.readLine();
				ProcessTime.setText(null);
				String P = ProcessTime.getText();
				ProcessTime.setText(txt + P);
				txt = f.readLine();
				Tellers.setText(null);
				String T = Tellers.getText();
				Tellers.setText(txt + T);
				txt = f.readLine();
			}
		} catch (Exception e1) {
			System.err.println("Could not load file: " + OpenName);
		}

	}

	public void saveContent() {
		String SaveName = JOptionPane
				.showInputDialog("Enter the file Name to Save..");
		try {
			FileWriter fw = new FileWriter("Saved files/" + SaveName + ".txt");
			fw.write(ArrivalRate.getText() + "\n");
			fw.write(ProcessTime.getText() + "\n");
			fw.write(Tellers.getText() + "\n");
			fw.close();
		} catch (Exception e) {
			System.err.println("Could not save file: " + SaveName);
		}
	}

	private class RunButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int ReadTellers;
			int ReadArrivalRate;
			long ReadProcessTime;
			ReadTellers = Integer.parseInt(Tellers.getText());
			ReadArrivalRate = Integer.parseInt(ArrivalRate.getText());
			ReadProcessTime = (long) Integer.parseInt(ProcessTime.getText());

			je.append("\n. The arrival rate for the customers\t"
					+ ReadArrivalRate + "\n");
			je.append("\n. The average processing time\t\t" + ReadProcessTime
					+ "\n");
			je.append("\n. The number of tellers\t\t" + ReadTellers + "\n");

			double value = (double) ReadProcessTime / 60000;
			int tells = (int) ((int) ReadArrivalRate * value) + 1;

			if (tells > ReadArrivalRate) {
				tells -= ReadArrivalRate;
			}

			je.append("\nNumber of tellers needed :-  " + Math.ceil(tells)
					+ "\n\n");

			Bank mybank = new Bank(ReadTellers, ReadProcessTime,
					ReadArrivalRate);
			mybank.simulation();

		}
	}
}
