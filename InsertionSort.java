import java.util.*;

public class InsertionSort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

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

    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort: Insertion Sort");
  }
}
