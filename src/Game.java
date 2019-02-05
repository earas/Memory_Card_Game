import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JFrame{	
	private ImageIcon gamelogo = new ImageIcon("img/gamelogo.png");
	private ImageIcon back = new ImageIcon("img/back.png");
	private ImageIcon front1 = new ImageIcon("img/front1.png");
	private ImageIcon front2 = new ImageIcon("img/front2.png");
	private ImageIcon front3 = new ImageIcon("img/front3.png");
	private ImageIcon front4 = new ImageIcon("img/front4.png");
	private ImageIcon front5 = new ImageIcon("img/front5.png");
	private ImageIcon front6 = new ImageIcon("img/front6.png");
	private ImageIcon front7 = new ImageIcon("img/front7.png");
	private ImageIcon front8 = new ImageIcon("img/front8.png");
	private ImageIcon front9 = new ImageIcon("img/front9.png");
	private JPanel playpanel;
	private JLabel timepiece, successcounter, statement;
	private int min = 0, sec = 0, counterr = 0, countsuccess = 0;;
	private List<JButton> drawlist = new ArrayList<JButton>();
	private List<JButton> freezecards = new ArrayList<JButton>();
	private List<Cards> cardlist = new ArrayList<Cards>();
	private Map<Integer, ImageIcon> cardmap = new HashMap<>();
	private List<Integer> uniqcards = new ArrayList<Integer>();
	private List<Integer> randomlist = new ArrayList<Integer>();
	private final int grid;
	private Boolean time = true;
	
	public Game(int grid){	
	
	this.grid = grid;	
	
	setTitle("Memory The Game");
	setSize(800, 800);
	setLocationRelativeTo(null);
	setIconImage(gamelogo.getImage());
	setResizable(false);
	
	
	JPanel GUI = new JPanel();
	GUI.setSize(800,800);
	GUI.setLocation(0, 0);
	GUI.setLayout(null);
	GUI.setVisible(true);
	GUI.setBackground(Color.getHSBColor(287, 95, 82));
	
	
	JPanel showpanel = new JPanel();
	showpanel.setSize(200, 800);
	showpanel.setLocation(600, 0);
	showpanel.setLayout(null);
	showpanel.setVisible(true);
	showpanel.setBackground(Color.lightGray);
	showpanel.setLayout(null);
	
	
	JButton back = new JButton("Back");
	back.setSize(80,50);
	back.setLocation(60,670);
	back.setFont(new Font("arial", Font.BOLD, 25));
	back.setHorizontalAlignment(0);
	back.setVisible(true);
	back.setBorder(null);
	back.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent act) {
			dispose();
		
		}});

	playpanel = new JPanel();
	playpanel.setSize(600, 800);
	playpanel.setLocation(0, 80);
	playpanel.setLayout(null);
	playpanel.setBackground(Color.getHSBColor(287, 95, 82));
	playpanel.setLayout(new FlowLayout());
	playpanel.setVisible(true);
	if (grid == 2) {
		setSize(600, 800);
		GUI.setSize(600,800);
		GUI.setLocation(0, 0);
		showpanel.setSize(200, 800);
		showpanel.setLocation(400, 0);
		playpanel.setSize(350, 800);
		playpanel.setLocation(0, 80);
		}
	if (grid == 6) {
		setSize(1000, 800);
		GUI.setSize(1000,800);
		GUI.setLocation(0, 0);
		showpanel.setSize(200, 800);
		showpanel.setLocation(800, 0);
		playpanel.setSize(800, 800);
		playpanel.setLocation(0, 80);
		}

	Cards c1 = new Cards(1, front1);
	Cards c2 = new Cards(2, front2);
	Cards c3 = new Cards(3, front3);
	Cards c4 = new Cards(4, front4);
	Cards c5 = new Cards(5, front5);
	Cards c6 = new Cards(6, front6);
	Cards c7 = new Cards(7, front7);
	Cards c8 = new Cards(8, front8);
	Cards c9 = new Cards(9, front9);
	
	cardmap.put(c1.getNumber(), front1);
	cardmap.put(c2.getNumber(), front2);
	cardmap.put(c3.getNumber(), front3);
	cardmap.put(c4.getNumber(), front4);
	cardmap.put(c5.getNumber(), front5);
	cardmap.put(c6.getNumber(), front6);
	cardmap.put(c7.getNumber(), front7);
	cardmap.put(c8.getNumber(), front8);
	cardmap.put(c9.getNumber(), front9);
	
	cardlist.add(c1);
	cardlist.add(c2);
	cardlist.add(c3);
	cardlist.add(c4);
	cardlist.add(c5);
	cardlist.add(c6);	
	cardlist.add(c7);
	cardlist.add(c8);
	cardlist.add(c9);
	

	timepiece = new JLabel("0:00");
	timepiece.setFont(new Font("arial", Font.BOLD, 20));
	timepiece.setSize(70, 40);
	timepiece.setLocation(60, 10);
	timepiece.setHorizontalAlignment(0);
	timepiece.setVisible(true);
	
	statement = new JLabel("Draw a card");
	statement.setSize(150, 30);
	statement.setFont(new Font("arial", Font.BOLD, 15));
	statement.setHorizontalAlignment(0);
	statement.setLocation(20, 60);
	statement.setVisible(true);
	
	JLabel titlesuccess = new JLabel("Score:");
	titlesuccess.setSize(80, 30);
	titlesuccess.setFont(new Font("arial", Font.BOLD, 20));
	titlesuccess.setHorizontalAlignment(0);
	titlesuccess.setLocation(50, 110);
	titlesuccess.setVisible(true);
	
	successcounter = new JLabel("0");
	successcounter.setSize(50, 30);
	successcounter.setFont(new Font("arial", Font.BOLD, 20));
	successcounter.setHorizontalAlignment(0);
	successcounter.setLocation(60, 130);
	successcounter.setVisible(true);
	
	treads();
	
	showpanel.add(titlesuccess);
	showpanel.add(statement);
	showpanel.add(successcounter);
	showpanel.add(timepiece);
	showpanel.add(back);
	GUI.add(showpanel);
	GUI.add(playpanel);
	add(GUI);
	
	setVisible(true);
	
				
}

	public void createbutton(JButton bt1, int id) {	
		bt1.setIcon(back);
		bt1.setVisible(true);
		bt1.setBorder(null);
		freezecards.add(bt1);
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent act) {
				if (bt1.getIcon() != back) {
				bt1.setBackground(Color.blue);}
				if(bt1.getBackground() != Color.red && bt1.getBackground() != Color.blue) {
				bt1.setIcon(cardmap.get(id));		
				counterr++;
				drawlist.add(bt1);
				if(counterr == 2) {
					drawlist.get(0).setBackground(Color.black);
					drawlist.get(0).setDisabledIcon(drawlist.get(0).getIcon());
					drawlist.get(1).setDisabledIcon(drawlist.get(1).getIcon());
					for(JButton a : freezecards) {
						a.setEnabled(false);
					}
					bt1.setIcon(cardlist.get(id-1).getIcon());
					draw();				
					}			
				}				
			}	
			
		});
		playpanel.add(bt1);		
	}

	public void draw() {
	
	Thread drawing = new Thread(new Runnable() {
		 @Override
         public void run() {	
			 
	counterr = 0;
	
	if(drawlist.get(0).getIcon() == drawlist.get(1).getIcon())
	{
		statement.setText("Checking...");
	
		try {	
			Thread.sleep(500);
				
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		drawlist.get(0).setEnabled(false);
		drawlist.get(1).setEnabled(false);
		drawlist.get(0).setBackground(Color.red);
		drawlist.get(1).setBackground(Color.red);
		drawlist.get(0).setDisabledIcon(null);
		drawlist.get(1).setDisabledIcon(null);
		drawlist.clear();
		statement.setText("Same card!");
		countsuccess++;
		String ssuccess = " "+countsuccess;
		successcounter.setText(ssuccess);
		
		int maxscore = (grid*3)/2;
		if(countsuccess == maxscore) {
			stoptimer();
			String username = JOptionPane.showInputDialog("Username: ");
			if(username != null) {
			System.out.println(username);
			System.out.println("wtf");
			HighScore h = new HighScore();
			h.putscore(username, min, sec, grid);
			h.readfile();
			h.writefile();	
			}
		}
				
	}
	else {
		statement.setText("Checking...");
		try {	
			Thread.sleep(500);
			drawlist.get(0).setIcon(back);
			drawlist.get(1).setIcon(back);
			drawlist.get(0).setDisabledIcon(null);
			drawlist.get(1).setDisabledIcon(null);
			drawlist.clear();		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		statement.setText("wrong! Try again!");
			
	}	
	for(JButton a : freezecards) {
		a.setEnabled(true);
	}
	
		 }}); 
	
	drawing.start();	
}

	
	
	public void treads(){
		
    Thread timerthread = new Thread(new Runnable() {
    	 @Override
         public void run() {
    		 
    		 try {
					Thread.sleep(1000);
    		 while(time == true) {
    				if(sec >= 59) {
    					min++;
    					sec=0;
    				}
    				else {
    					sec++;
    				}
    				 String stime= min+":"+sec;
    				 timepiece.setText(stime);
    				try {
    					Thread.sleep(1000);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}}
    		 }catch (InterruptedException e) {
					e.printStackTrace();
				}
    		 
    		 }
    	});  
    
    Thread shuffle = new Thread(new Runnable() {
   	 @Override
        public void run() {
   		 
   		 int uniqcardnumber = (grid*3)/2;
   			
   			for(int i=1; i <=2; i++) {
   			for(int j = 0; j <= uniqcardnumber-1; j++) {
   				uniqcards.add(cardlist.get(j).getNumber());
   			}}
   		
   			for(int j = 1; j <= uniqcardnumber*2; j++) {
   				randomlist.add(0);
   			}
   			

   			Random rant = new Random();
   			boolean search = true;
   			for (int num : uniqcards) {
   				
   				while(search) {
   				int a = rant.nextInt(uniqcardnumber*2);
   				
   				if(randomlist.get(a) == 0) {
   					//System.out.println("random number: " +a);
   					randomlist.set(a, num);
   					break;
   				}
   				}
   								
   			}
   		
   			for (int i : randomlist) {
   				System.out.print(i+" ");
   			}
   			
   			for(int i = 0; i <= (grid*3)-1; i++) {		
   				createbutton(new JButton(), randomlist.get(i));	
   			}
   			
   		 
   	 }
	 });
    
    timerthread.start();
    shuffle.start();
   
   
    
    }	

	public void stoptimer() {
		time = false;
		}
	
	
	}
	
	
