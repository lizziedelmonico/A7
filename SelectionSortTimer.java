import java.util.*;

/* Initializes the timer for the SelectionSort method */
public class SelectionSortTimer {
    /** Starts the program running */
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
   * Sorts the given cards using the previously written selection sort method (without the record)
   * @param unsorted  The unsorted card pile
   * @return  The sorted card pile
   */
  public static CardPile sort(CardPile unsorted){

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();


    while(unsorted.size() > 0){
      ListIterator<Card> position = unsorted.listIterator();
      Card min = unsorted.getFirst();
      Card c = min;
      int index = 0;
      while(position.hasNext()){
        c = position.next();
        if(c.compareTo(min) < 0){
          min = c;
          index = position.previousIndex();
        }
      }
        sorted.add(min);
        unsorted.remove(index);
    }
    return sorted;
  }
}
