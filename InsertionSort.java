import java.util.Collections;
import java.util.ListIterator;

public class InsertionSort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();
    
    
    
    while(!unsorted.isEmpty()){
      Card current = unsorted.getFirst();
      ListIterator<Card> sort_pos = sorted.listIterator(sorted.size());
      Card sort_first = sorted.getFirst();

      unsorted.remove(current);

      if(current.compareTo(sort_first) <= 0){
        sorted.add(current);
      } else{
        Card prev = sort_pos.previous();
        while(sort_pos.hasPrevious() && current.compareTo(prev) > 0){
          prev = sort_pos.previous();
        }
        sorted.add(current);
      }

    }
    
    
    // return the sorted result here
    return sorted;
  }

    public static void main(String args[]){

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

    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort: Insertion Sort");
  }
}
