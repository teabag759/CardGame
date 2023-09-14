import java.util.ArrayList;
import java.util.Collections;

public class cards {
	
	@Override
	public String toString() {
		
		String s="";
		for(card c:cards) {
			s+=c+" ";
			// s+=c.toString()+" "; 와 같음
		}
		return "["+s+"]";
	}
	
	
	public ArrayList<card> cards;

	public cards(boolean generate_card) {
		if(generate_card)
			cards=card.makeDeck(); //1덱의 카드
		else
			cards=new ArrayList<card>(); //손에 카드 없음
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public void print() {
		for(card c:cards) {
			System.out.print(c.toString()+" ");
		}
	}
	
	public void take(card c) {
		cards.add(c);		
	}
	
	public card give(int index) {
		card c=cards.get(index);
		cards.remove(index);
		return c;
	}
	
	public void giveTo(cards target,int index) {
		
		target.take(this.give(index));
		//this 가 준 카드를 target이 받은 것
//		card c=cards.get(index);
//		cards.remove(index);
//		target.take(c);
	}
	
	public void giveTo(cards target) {
		giveTo(target,0);
	}
	
	public void giveToN(cards target, int n_cards) {
		for(int i=0;i<n_cards;i++) {
			giveTo(target);
		}
	}
	
	public int getCardNumbers() {
		return cards.size();
	}
	public void showAll() {
		for(card c:cards) {
			c.show();
		}
	}
	
	public void removeAll() {
		cards.clear();
	}
	
	//카드를 줌(주는 것은 아님)
	public card get(int index) {
		return cards.get(index);
	}
	
	public int[] getNumbers() {
		int sz=cards.size();
		int[] arr= new int[sz];
		
		for(int i=0;i<sz;i++) {
			arr[i]=cards.get(i).number;
		}
		
		return arr;
	}
}
