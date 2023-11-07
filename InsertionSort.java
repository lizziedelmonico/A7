import java.util.*;

public class InsertionSort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();

    
    
    while(unsorted.size() > 0){
      Card c = unsorted.getFirst();
      unsorted.remove(c);
      if(sorted.size() == 0){
        sorted.add(c);
      }
      for(int index = 0; index < sorted.size();){
        if(sorted.size() == 0){
          sorted.add(c);
        }
        Card d = sorted.get(index);
        if(c.compareTo(d) < 0){
          sorted.add(index, c);
          index = index-1;
        } 
      }
  
      record.next();
      record.add(sorted);
      record.add(unsorted);
    }
    
    
    // return the sorted result here
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

    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort: Insertion Sort");
  }
}
