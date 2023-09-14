import java.util.Arrays;

public class game {
	static final int N_PLAYERS=4;
	cards cs=new cards(true);
	player[] players=new player[N_PLAYERS];
	
	public game() {
		
		for(int i=0;i<players.length;i++) {
			players[i]=new player("player"+(i+1));
		}
		
	}

	public void startGame() {
		for(int i=0;i<players.length;i++) {
			players[i].NewGame();
		}
		cs=new cards(true);
		cs.shuffle();
		
		for(int j=0;j<5;j++) {
			for(int i=0;i<players.length;i++) {
				card c=cs.give(0);
				players[i].take(c);
				
				System.out.println(players[i]);
			}
		}		
		
		cards p1_hand=players[0].getHandCards();
		int[] nums=p1_hand.getNumbers();
		//Arrays.sort(nums);
		
		int[] count=new int[14];
		
		for(int num:nums) {
			System.out.print(num+" ");
			count[num]++;
		}
		
		for(int i=1;i<=13;i++) {
			if(count[i]==2)
				System.out.println("1 pair:"+i);
			else if(count[i]==3)
				System.out.println("triple"+i);
			else if(count[i]==4)
				System.out.println("four card"+i);
		}
		
	}
	
}
