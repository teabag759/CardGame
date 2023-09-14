
public class player {
	cards hand=new cards(false);
	cards board=new cards(false);
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public player(String name) {
		this.name=name;
	}
	
	public void take(card c) {
		hand.take(c);
	}
	public void show() {
		hand.giveToN(board, hand.getCardNumbers());
		hand.showAll();
	}
	
	@Override
	public String toString(){
		return name+"(hand="+hand+",board="+board+")";
	}
	
	public void NewGame() {
		hand.removeAll();
		board.removeAll();
	}
	
	public cards getHandCards() {
		return hand;
	}
	
}
