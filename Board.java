import java.util.*;

class Board{
    Card board[];
    ArrayList<Integer>yoozd;
    int a, num, one, two;
    Board(){
        String words[]={"BIG", "DOCUMENT", "LEATHER", "GLACIER", "CELL", "AXIS", "DAYLIGHT", "FALLS", "JUNIOR", "CORPORATION", "DRIVE", "CHILLY", "GUZZLING", "DUMP", "AMBIDEXTROUS", "COMFORTABLE", "CANDY", "DISTANT", "CONTENT", "NUMERIC", "GRADE", "DESCRIBES", "CHANNEL", "ESSENCE", "GEOMETRICAL", "LEGION", "CRASHER", "ENEMIES", "HUMANLY", "HOOLIGAN", "FREAK", "FIGHTING", "EVEN", "EXCLUSIVE", "DATA", "GANGLAND"};
        board=new Card[36];
        int a=0;
		while(a<36){
			Card temp=new Card(words[a]);
			board[a]=temp;
			a++;
		}
    }
    void assignRandom(int x, char y){
        a=0;
        while(a<x){
            num=(int)(Math.random()*36);
            if(!yoozd.contains(num)){
                yoozd.add(num);
                board[num].setCamp(y);
                a++;
            }
        }
    }
    void moreRed(){
        yoozd=new ArrayList<>();
        assignRandom(13, 'r');
        assignRandom(12, 'b');
        assignRandom(8, 'y');
        assignRandom(2, 'g');
        assignRandom(1, 'a');
    }
    void moreBlue(){
        yoozd=new ArrayList<>();
        assignRandom(13, 'b');
        assignRandom(12, 'r');
        assignRandom(9, 'y');
        assignRandom(2, 'a');
    }
    int checWichCard(String chec){
		a=0;
		while(a<36){
			if(board[a]!=null)
				if(board[a].getWord().equals(chec))
					return a;
			a++;
		}
		return -1;
	}
}
