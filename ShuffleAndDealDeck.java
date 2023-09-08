import java.util.Random;

class Card{
    String face;
    String suit;
    public Card(String face, String suit){
        this.face=face;
        this.suit=suit;
    }
}

class DeckOfCards{
    static final int DECK_SIZE=52;
    static final String[] faces={"Ace","Deuce","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","King","Queen"};
    static final String[] suits={"Hearts","Diamonds","Clubs","Spades"};
    Card[] deck;
    Random rand;

    public DeckOfCards(){
        deck = new Card[DECK_SIZE];
        rand =  new Random();
        fillDeck();
    }

    public void fillDeck(){
        for (int i=0; i<DECK_SIZE; i++){
            deck[i] = new Card(faces[i%13],suits[i%4]);
        }
    }

    public void shuffle(){
        for(int i=0; i<DECK_SIZE; i++){
            int j = rand.nextInt(DECK_SIZE);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    public void deal(){
        System.out.println("-------------------------------------------");
        for (int i = 0; i < deck.length; i++) {
            System.out.printf("| %-6s of %-8s |", deck[i].face, deck[i].suit);
            if ((i + 1) % 2 == 0) {
                System.out.println();
            }
        }
        System.out.println("-------------------------------------------");
    }
}


public class ShuffleAndDealDeck {
    public static void main(String[] args){

        DeckOfCards deste = new DeckOfCards();
        deste.shuffle();
        deste.deal();
    }
}