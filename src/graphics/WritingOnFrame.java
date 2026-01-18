package graphics;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WritingOnFrame {
	
	public static void main(String []args) {
		Frame frame = new Frame();
	}
}

class Frame extends JFrame {
	
	private Pannel pannel;
	
	public Frame() {
		setVisible(true);
		setBounds(400, 200, 600, 450);
		setTitle("My first frame with pannels");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pannel = new Pannel();
		add(pannel);
	}
}

class Pannel extends JPanel {
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("We're learning swing", 100, 100);
	}
}