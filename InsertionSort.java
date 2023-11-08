import java.util.*;

/* Sorts a deck of cards using the insertion method */
public class InsertionSort {
  
  /**
   * Sorts the given card pile using insertion techniques
   * @param unsorted  The unsorted card pile that will be sorted
   * @param record    Keeps track of the changes being made to the card pile
   * @return   The sorted card pile
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();
    Card c = unsorted.removeFirst();
    sorted.add(c);

    
    while(unsorted.size() > 0){
      c = unsorted.removeFirst();
      ListIterator<Card> position = sorted.listIterator();
      Card current = position.next();
      while (position.hasNext() && (c.compareTo(current) > 0)){
        current= position.next();
      }
      if(c.compareTo(current) < 0){
        position.previous();
  
      position.add(c);
      record.next();
      record.add(sorted);
      record.add(unsorted);
    }
    
  
    }
    return sorted;
  }

    public static void main(String args[]) throws NoSuchElementException{

    // set up a class to record and display the sorting results
    SortRecorder recorder = new SortRecorder();

    // set up the deck of cards
    Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

    // for debugging purposes, uncomment this to
    // work with a smaller number of cards:
    // cards = cards.split(cards.get(39));

    // mix up the cards
    Collections.shuffle(cards);

    // if you want to sort in array form, use:
    Card[] card_arr = cards.toArray(new Card[0]);

    // in your program, this would be a call to a real sorting algorithm
    cards = InsertionSort.sort(cards, recorder);

    // make window appear showing the record
    recorder.display("Card Sort: Insertion Sort");
  }
}
