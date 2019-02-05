
import java.util.Collections;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ScoreGUI extends JFrame{
	
	private ImageIcon gamelogo = new ImageIcon("img/gamelogo.png");
	private DefaultListModel<String> listModel = new DefaultListModel<>();
	public ScoreGUI() {
		
		
	setTitle("High Scores");
	setSize(300, 200);
	setIconImage(gamelogo.getImage());
	setResizable(false);
	setLocationRelativeTo(null);
	
	HighScore h = new HighScore();
	h.readfile();
	
	Collections.sort(h.scores);
	
	
	for(Players p : h.scores) {
		listModel.addElement(p.getName() + "   (Time  " + p.getMin() + ":" + p.getSec() + ", grid " + p.getGrid() + "x3)");
	}
	

	Players[] myplayers = new Players[h.scores.size()];
	h.scores.toArray(myplayers);
	
	
	JList<Players> scorelist = new JList<>(myplayers);
	
	
	
	scorelist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	scorelist.addListSelectionListener(new ListSelectionListener() {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
			Players p = scorelist.getSelectedValue();
			System.out.println(p);
			h.scores.remove(p);
			h.writefile();
			 }
		}
		});
	
	
	add(new JScrollPane(scorelist));
	setVisible(true);
	
	}
}
