package graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class FirstLogin {
	public static void main(String []args) {
		new LoginFrame().setVisible(true);
	}
}

class LoginFrame extends JFrame {
	public LoginFrame() {
		setBounds(30, 30, 400, 120);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		super.add(new LoginPannel());
	}
}

class LoginPannel extends JPanel {
	private JPanel mainPannel;
	private JLabel userLabel;
	private JTextField userField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private Document doc;
	private JButton btn;
	
	public LoginPannel() {
		super.setLayout(new BorderLayout(3, 3));
		this.mainPannel = new JPanel();
		this.mainPannel.setLayout(new GridLayout(2, 2, 3, 3));
		
		this.mainPannel.add(this.userLabel = new JLabel("User: "));
		this.mainPannel.add(this.userField = new JTextField(20));
		this.mainPannel.add(this.passwordLabel = new JLabel("Password: "));
		this.mainPannel.add(this.passwordField = new JPasswordField(20));
		this.doc = this.passwordField.getDocument();
		this.doc.addDocumentListener(new CheckPassword());
		
		super.add(this.mainPannel, BorderLayout.NORTH);
		
		this.btn = new JButton("Send");
		super.add(this.btn, BorderLayout.SOUTH);
	}
	
	private class CheckPassword implements DocumentListener {

		@Override
		public void insertUpdate(DocumentEvent e) {updateFieldState();}

		@Override
		public void removeUpdate(DocumentEvent e) {updateFieldState();}

		@Override
		public void changedUpdate(DocumentEvent e) {}
		
		private void updateFieldState() {
			if(!passwordField.getText().matches("^.{8,12}$"))
				passwordField.setBackground(Color.RED);
			else passwordField.setBackground(Color.WHITE);
		}
	}
}