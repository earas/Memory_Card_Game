
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GridPanel extends JFrame{

	private ImageIcon gamelogo = new ImageIcon("img/gamelogo.png");
	
	public GridPanel() {
		
		String[] gridsize = { "2", "4", "6"};
		setTitle("New");
		setSize(200, 150);
		setIconImage(gamelogo.getImage());
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setSize(200, 150);
		panel.setLocation(0, 0);
		panel.setVisible(true);
		panel.setLayout(null);

		JLabel title = new JLabel("Select grid size: ");
		title.setLocation(20,20);
		title.setVisible(true);
		title.setSize(100, 30);
		
		JComboBox gridList = new JComboBox(gridsize);
		gridList.setSelectedIndex(1);
		gridList.setLocation(117,27);
		gridList.setSize(50,20);
		gridList.setVisible(true);
		
		JButton button = new JButton("Play");
		button.setSize(60, 30);
		button.setLocation(70, 60);
		button.setVisible(true);
			
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent act) {
				int grid = Integer.parseInt((String)gridList.getSelectedItem());
				dispose();
				new Game(grid);
				
			}});
		
		
		panel.add(title);
		panel.add(gridList);
		panel.add(button);
		add(panel);
		setVisible(true);
		
		
	}

}
