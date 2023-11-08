import java.util.*;

/* Initializes the timer for the Insertion Sort method */
public class InsertionSortTimer {
    
    /* Starts the program running */
    public static void main(String args[]) {
    
        if (args.length<1) {
          System.err.println("Please specify how many cards to sort!");
        } else {
          Card[] deck = Card.newDeck(true);
          CardPile cards = new CardPile();
          SortRecorder recorder = new SortRecorder();
          
          for (int i = 0; i<Integer.parseInt(args[0]); i++ ) {
            cards.add(deck[(int)(52*Math.random())]);
          }
    
          SelectionSort.sort(cards, recorder);
          
        }
      }

    /**
   * Sorts the given cards using the previously written insertion sort method (without the record)
   * @param unsorted  The unsorted card pile
   * @return  The sorted card pile
   */
      public static CardPile sort(CardPile unsorted) {
    
    
        // Here is the result list you will be creating
        CardPile sorted = new CardPile();
        Card c = unsorted.removeFirst();
        sorted.add(c);
    
        
        while(unsorted.size() > 0){
          c = unsorted.removeFirst();
          ListIterator<Card> cardIterator1 = sorted.listIterator();
          Card curCard = cardIterator1.next();
          while (cardIterator1.hasNext() && (c.compareTo(curCard) > 0)){
            curCard = cardIterator1.next();
          }
          if(c.compareTo(curCard) < 0){
            cardIterator1.previous();
      
          cardIterator1.add(c);
        }
        
      
        }
        return sorted;
      }


}
