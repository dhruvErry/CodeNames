import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CodeNames implements ActionListener {
    JFrame frame;
    JButton button1, button2, u;
    JPanel panel, p2;
    JButton butinz[];
    JDialog dialog, spyz, last;
    JLabel l1, l2, l3;
    int clic=-1;
    int bRem, rRem, a;
    Board b;
    String turn; 
    boolean redTurn, spyMaster;
    public CodeNames() {
        JLabel spy=new JLabel("Are you the SpyMaster?");
        JButton yes=new JButton("Yes");
        JButton no=new JButton("No");
		spy.setFont(new Font("Courier New", Font.BOLD, 22));
		spy.setBounds(65, 20, 300, 64);
		JDialog.setDefaultLookAndFeelDecorated(true);
		spyz=new JDialog(frame, "TROOTH PLEEZ", true);
		Container pane2=spyz.getContentPane();
		spyz.setLayout(null);
		pane2.setLayout(null);
		spyz.setSize(399, 199);
		spyz.getLayeredPane().getComponent(1).setFont(new Font("Courier New",Font.BOLD,16)); 
		spyz.add(spy);
		spyz.setSize(399,199);
		spyz.setLocation(486,279);
		pane2.add(yes);
		pane2.add(no);
        yes.setBounds(99,92,79,31);
        no.setBounds(209, 92, 79, 31);
        yes.setBackground(Color.WHITE);
		yes.setFont(new Font("Courier New", Font.BOLD, 21));
		no.setFont(new Font("Courier New", Font.BOLD, 21));
        yes.setFocusPainted(false);
        yes.addActionListener(this);
        no.setBackground(Color.WHITE);
        no.setFocusPainted(false);
        no.addActionListener(this);
		spyz.setVisible(true);
 
        frame = new JFrame();
      //  frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setTitle("Erry's codeNames Board");
        frame.setSize(1369, 739);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        b=new Board();
        b.moreRed();
        panel = new JPanel(new GridLayout(7, 6));
        panel.setSize(1299, 699);
        butinz=new JButton[36];
        printScores();
        a=0;
        while(a<36){
			butinz[a] = new JButton(b.board[a].getWord());
			butinz[a].setFont(new Font("Courier New", Font.BOLD, 23));
			butinz[a].setBackground(new Color(251, 254, 211));
			if(spyMaster){
				if(b.board[a].getCamp()=='r')
					butinz[a].setForeground(Color.RED);
				else if(b.board[a].getCamp()=='b')
					butinz[a].setForeground(Color.BLUE);
				else if(b.board[a].getCamp()=='y')
					butinz[a].setForeground(Color.ORANGE);
				else if(b.board[a].getCamp()=='a')
					butinz[a].setForeground(Color.BLACK);
				else 
					butinz[a].setForeground(Color.GRAY);					
			}
            butinz[a].setFocusPainted(false);
			butinz[a].addActionListener(this);
			panel.add(butinz[a]);
			a++;
		}
	//	butinz[12].setBackground(Color.BLUE);
	//	butinz[12].setText("");
  //      button1.addActionListener(this);
        frame.add(panel);
        frame.setVisible(true);
    }
     
    public void actionPerformed(ActionEvent e) {
        String clict=e.getActionCommand();
        if(l1!=null)
			newScawz();
		if(clict.startsWith("End")){
			chanjeTurn();
			turnChaynjd();
		}
		else if(clict.equals("Fine, man"))
			last.setVisible(false);
		else if(clict.equals("Yes")){
			spyMaster=true;
			spyz.setVisible(false);
		}
		else if(clict.equals("No"))
			spyz.setVisible(false);
		else if(clict.equals("Got it"))
			dialog.setVisible(false);
		else{
			clic=b.checWichCard(clict); 
			JButton temp=butinz[clic];
			if(b.board[clic].getCamp()=='r'){
				temp.setBackground(Color.RED);
				temp.setForeground(Color.RED);
				rRem--;
				newScawz();
				if(rRem==0)
					loseGame(false);
				if(!redTurn)
					chanjeTurn();
			}
			else if(b.board[clic].getCamp()=='b'){
				temp.setBackground(Color.BLUE);
				temp.setForeground(Color.BLUE);
				bRem--;
				newScawz();
				if(bRem==0)
					loseGame(true);
				if(redTurn)
					chanjeTurn();
			}
			else if(b.board[clic].getCamp()=='y'){
				temp.setBackground(Color.YELLOW);
				temp.setForeground(Color.YELLOW);
				chanjeTurn();
			}
			else if(b.board[clic].getCamp()=='g'){
				temp.setBackground(Color.GRAY);
				temp.setForeground(Color.GRAY);
				chanjeCard();
				chanjeTurn();
			}
			else{
				temp.setBackground(Color.BLACK);
				temp.setForeground(Color.BLACK);
				loseGame(redTurn);
			}
		}
	}
     		 
    void printScores(){ 
		bRem=0;
		rRem=0;
		a=0;
		while(a<36){
			if(b.board[a]!=null){
				if(b.board[a].getCamp()=='b')
					bRem++;
				else if(b.board[a].getCamp()=='r')
					rRem++;
			}
			a++;
		}
		p2=new JPanel(); 
		p2.setLayout(null);
		l1=new JLabel(Integer.toString(bRem));
		l1.setFont(new Font("Courier New", Font.BOLD, 25));
		l1.setForeground(Color.BLUE);
		l2=new JLabel(" - ");
		l2.setFont(new Font("Courier New", Font.BOLD, 25));
		l2.setForeground(Color.BLACK);
		l3=new JLabel(Integer.toString(rRem));
		l3.setFont(new Font("Courier New", Font.BOLD, 25));
		l3.setForeground(Color.RED);
		p2.add(l1);
		p2.add(l2);
		p2.add(l3);
		l1.setBounds(61, 43, 39, 29);
		l2.setBounds(90, 43, 69, 29);
		l3.setBounds(130, 43, 39, 29);
		JLabel fill=new JLabel("");
	//	fill.setBounds(170, 46, 2999, 199);
		JLabel r=new JLabel("");
		//fill.setBounds(299, 46, 2999, 199);
		JLabel f=new JLabel("");
		JLabel p=new JLabel("");
		//r.setBounds(499, 46, 2999, 199);
		u=new JButton("End "+turn+" turn");
		u.setBorderPainted(false);
		u.setFocusPainted(false);
		u.setFont(new Font("Courier New", Font.BOLD, 21));
		u.setBackground(new Color(238, 238, 238));
		redTurn=!redTurn;
		turnChaynjd();
		panel.add(p2);
		panel.add(fill);
		panel.add(r);
		panel.add(f);
		panel.add(p);
		panel.add(u);
		u.addActionListener(this);
	}
	
	void newScawz(){
		l1.setText(Integer.toString(bRem));
		l3.setText(Integer.toString(rRem));
		turnChaynjd();
	}
	
	void chanjeCard(){
		JButton fine=new JButton("Fine, man");
		fine.setFont(new Font("Courier New", Font.BOLD , 19));
		turn=(redTurn)?"Red":"Blue";
		JLabel lab=new JLabel("A neutral card has been converted into a "+turn+" coloured card!!");
		lab.setFont(new Font("Courier New", Font.BOLD, 21));
		lab.setBounds(41, 20, 799, 64); 
		JDialog.setDefaultLookAndFeelDecorated(true);
		last=new JDialog(frame, "BAD NYOOZ", true);
		Container pane3=last.getContentPane();
		last.setLayout(null);
		pane3.setLayout(null);
		last.getLayeredPane().getComponent(1).setFont(new Font("Courier New",Font.BOLD,17)); 
		last.add(lab);
		last.setSize(881,179);
		last.setLocation(241,339);
		pane3.add(fine);
        fine.setBounds(349,92,159,31);
        fine.setBackground(Color.WHITE);
        fine.setFocusPainted(false);
        fine.addActionListener(this);
        a=0;
        while(a<36){
			if(b.board[a].getCamp()=='y'){
				if(redTurn){
					b.board[a].setCamp('r');
					if(spyMaster)
						butinz[a].setForeground(Color.RED);
					rRem++;
				}
				else{
					b.board[a].setCamp('b');
					if(spyMaster)
						butinz[a].setForeground(Color.BLUE);
					bRem++;
				}
				break;
			}			
			a++;
		}	
		newScawz();	
		last.setVisible(true); 
	}
    void chanjeTurn(){
		JButton ok=new JButton("Got it");
		ok.setFont(new Font("Courier New", Font.BOLD , 19));
		redTurn=!redTurn;
		turn=(redTurn)?"Red":"Blue";
		JLabel label=new JLabel("It is now "+turn+"'s turn");
		label.setFont(new Font("Courier New", Font.BOLD, 22));
		label.setBounds(65, 20, 300, 64);
	//	label.setHorizontalAlignment(SwingConstants.CENTER);
		JDialog.setDefaultLookAndFeelDecorated(true);
		dialog=new JDialog(frame, "TURN CHAYNJ", true);
		Container pane=dialog.getContentPane();
		dialog.setLayout(null);
		pane.setLayout(null);
		dialog.setSize(399, 199);
		dialog.getLayeredPane().getComponent(1).setFont(new Font("Courier New",Font.BOLD,17)); 
		dialog.add(label);
		dialog.setSize(399,199);
		dialog.setLocation(486,279);
		pane.add(ok);
        ok.setBounds(131,92,129,31);
        ok.setBackground(Color.WHITE);
        ok.setFocusPainted(false);
        ok.addActionListener(this);
		dialog.setVisible(true);
	    //UIManager.put("OptionPane.minimumSize",new Dimension(399, 199));
		//JOptionPane.showMessageDialog(null, label,"TURN CHAYNJ", JOptionPane.PLAIN_MESSAGE);
	}
	
	void turnChaynjd(){
		turn=(redTurn)?"Red":"Blue";
		u.setText("End "+turn+" turn");
		if(redTurn)
			u.setForeground(Color.RED);
		else
			u.setForeground(Color.BLUE);
	}
	
	void loseGame(boolean b){
		JDialog lose=new JDialog(frame, "GAME OVER", true);
		if(b)
			turn="Red";
		else
			turn="Blue";
		JLabel l=new JLabel("       "+turn+" Loses!!!");
		l.setFont(new Font("Courier New", Font.BOLD, 25));
		lose.add(l);
		l.setBounds(65, 20, 300, 64);
		lose.setSize(399,199);
		lose.setLocation(486,279);
		lose.getLayeredPane().getComponent(1).setFont(new Font("Courier New",Font.BOLD,16)); 
		lose.setLayout(new GridLayout());
		lose.setVisible(true);
	}
	
    public static void main(String args[]){
        CodeNames test = new CodeNames();
    }
}
