import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.awt.Image;
import java.awt.FlowLayout;*/
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainMenu extends JFrame {
	
	private static JButton button1, button2, button3;
	private ImageIcon gamelogo = new ImageIcon("img/gamelogo.png");
	
	
	MainMenu(){
		super();
		
		setTitle("Memory The Game");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(gamelogo.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel toppanel = new JPanel();
		toppanel.setSize(600, 150);
		toppanel.setLocation(0, 0);
		toppanel.setLayout(null);
		toppanel.setVisible(true);
		
		
		JPanel centerpanel = new JPanel();
		centerpanel.setSize(600, 450);
		centerpanel.setLocation(600, 160);
		centerpanel.setLayout(null);
		centerpanel.setVisible(true);
		centerpanel.setBackground(Color.getHSBColor(287, 95, 82));
		
		
		JLabel namelabel = new JLabel("Memory The Game");
		namelabel.setSize(400, 40);
		namelabel.setFont(new Font("arial", Font.BOLD, 35));
		namelabel.setLocation(100, 40);
		namelabel.setHorizontalAlignment(0);
		namelabel.setVisible(true);
		
		JLabel numberlabel = new JLabel("s16650");
		numberlabel.setSize(250, 40);
		numberlabel.setFont(new Font("arial", Font.BOLD, 30));
		numberlabel.setLocation(170, 90);
		numberlabel.setHorizontalAlignment(0);
		numberlabel.setVisible(true);
		
		button1 = new JButton("New Game");
		button1.setSize(150, 60);
		button1.setLocation(220, 250);
		button1.setFont(new Font("arial", Font.BOLD, 20));
		button1.setHorizontalAlignment(0);
		button1.setVisible(true);
		button1.addActionListener(new Action());
		
		
		button2 = new JButton("High Score");
		button2.setSize(150,60);
		button2.setLocation(220, 320);
		button2.setFont(new Font("arial", Font.BOLD, 20));
		button2.setHorizontalAlignment(0);
		button2.setVisible(true);
		button2.addActionListener(new Action());
		
		button3 = new JButton("Exit");
		button3.setSize(150,60);
		button3.setLocation(220, 390);
		button3.setFont(new Font("arial", Font.BOLD, 20));
		button3.setHorizontalAlignment(0);
		button3.setVisible(true);
		button3.addActionListener(new Action());
		
		centerpanel.add(button3);
		centerpanel.add(button1);
		centerpanel.add(button2);
		toppanel.add(namelabel);
		toppanel.add(numberlabel);
		
		add(toppanel);
		add(centerpanel);
		setVisible(true);
		
		
		
	}
	
	static class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent act) {
				if(act.getSource() == button1) {	
					new GridPanel();
				}
		
				if(act.getSource() == button2) {
					new ScoreGUI();
					
				}				
				if(act.getSource() == button3) {
					System.exit(0);
					
				}}};
				
	
	
		
}
