import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Spam {
	JLabel l1, l2;
	JTextArea area;
	JButton b;
	JTextField score, percent;

	// Given Final String Array of spam words
	private static final String[] spamWords = { "LV", "disclaimer", "urgent", "necessary", "free", "4u", "Guarantee",
			"profits", "congratulations", "opportunity", "unlimited", "scam", "casino", "profits", "amazing", "mailto",
			"Credit", "unsecured", "winner", "winning", "hormone", "insurance", "spam", "ringtones", "account",
			"blackjack", "luck", "chatroom", "Duty-free", "HD" };

	// GUI Code
	Spam() {
		JFrame f = new JFrame("Spam Scanner");
		l1 = new JLabel("Score:");
		l1.setBounds(210, 180, 100, 30);
		l2 = new JLabel("Spam likelihood:");
		l2.setBounds(330, 180, 100, 30);
		score = new JTextField();
		score.setEditable(false);
		score.setBounds(250, 180, 70, 30);
		percent = new JTextField();
		percent.setEditable(false);
		percent.setBounds(430, 180, 70, 30);
		area = new JTextArea();
		area.setLineWrap(true);
		area.setBounds(20, 05, 490, 150);
		b = new JButton("Scan Message");
		b.setBounds(80, 180, 120, 30);

		f.add(l1);
		f.add(l2);
		f.add(area);
		f.add(b);
		f.add(score);
		f.add(percent);
		f.setSize(550, 350);
		f.setLayout(null);
		f.setVisible(true);

		// Lambda Expression to trigger the event
		b.addActionListener(e -> {
			String text = area.getText();
			String words[] = text.split("\\s");

			// Array list to store the values that are present in text area as well as
			// spamWords array.
			ArrayList<String> ar = new ArrayList<String>();

			for (int i = 0; i < words.length; i++) {
				if (Arrays.asList(spamWords).contains(words[i]))
					ar.add(words[i]);
			}

			// Setting the score by counting the elements in the arraylist above
			score.setText("" + ar.size());

			// Calculating the likelihood by taking out the percentage.
			int total = ar.size();
			int areatotal = words.length;
			double likelihood = (total * 100 / areatotal);

			// Setting the likelihood text field
			percent.setText(likelihood + "%");

			String output = "";

			// Using hashset to get distinct values of arraylist above
			HashSet<String> hSetNumbers = new HashSet<String>(ar);

			// Adding final distinct values from hashset to arraylist to display in required
			// format
			ArrayList<String> arfinal = new ArrayList<String>();

			for (String strNumber : hSetNumbers) {
				strNumber = hSetNumbers.toString();
				arfinal.add(strNumber);
			}

			// Loop to make a string object and store the values of arraylist in required
			// format
			for (int i = 0; i < arfinal.size(); i++) {
				String everything = ar.get(i).toString();

				output += everything.toUpperCase() + " " + "\n";
			}

			// Display another pane, i.e dialog box as required.
			JOptionPane.showMessageDialog(null, "The spam words in text area: \n" + output, "Spam words in text",
					JOptionPane.WARNING_MESSAGE);

		});

	}

	public static void main(String[] args) {
		new Spam();
	}
}