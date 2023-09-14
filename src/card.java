import java.util.ArrayList;



public class card {

	enum Symbol{
		//생성자 부분
		Spade("♠"),
		Diamond("♦"),
		Heart("♥"),
		Clover("♣"),
		Joker("Joker");
		
		private final String str;		
		Symbol(String str){			this.str=str;		}
		String str() {			return str;		}		
	};
	
	@Override
	public String toString() {
//		if(!show) return "[]";
		return cardName;
	}
	
	enum Color{Black, Colored};
	final int JOKER=0;
	
	int number;
	Symbol symbol;
	Color color;
	String cardName;
	boolean show;
	
	String[] num2string= {"JOKER",
			"A","2","3","4","5","6","7","8","9","10",
			"J","Q","K"};
		
	public card(int number, Symbol symbol) {
		this.number=number;
		this.symbol=symbol;
		color= (symbol==Symbol.Spade||symbol==Symbol.Clover)
				?Color.Black:Color.Colored;
		int index=0;
		cardName=symbol.str()+num2string[number];
		show=false;
	}
	
	//joker 용
	public card(Color color) {
		this.number=JOKER;
		this.symbol=Symbol.Joker;
		this.color=color;
		cardName=symbol.str();		
	}
	
	public static ArrayList<card> makeDeck() {
		ArrayList<card> deck=new ArrayList<card>();
		Symbol[] symbols= 
			{Symbol.Spade,Symbol.Diamond,Symbol.Heart,Symbol.Clover};
		for(int n=1; n<=13;n++) {
			for(int s=0; s<4; s++) {
				card c=new card(n,symbols[s]);
//				System.out.print(c.cardName+" ");
				deck.add(c);
			}
		}
		deck.add(new card(Color.Black));
		deck.add(new card(Color.Colored));
		
		return deck;
	}
	
	public void show() {show=true;}
	public void hide() {show=false;}

}
