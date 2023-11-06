import java.util.*;

public class SelectionSort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) throws NoSuchElementException{
    
    // register the starting configuration with the recorder
    record.add(unsorted);

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();
  
    Card min = unsorted.getFirst();
    int index = 0;

    while(!unsorted.isEmpty()){
      for(ListIterator<Card> position = unsorted.listIterator(); position.hasNext();){
        Card c = position.next();
        if(c.compareTo(min) < 0){
          min = c;
          index = position.nextIndex();
        } 
        unsorted.remove(min);
        sorted.add(min);
      }

  

    }

    // return the sorted result here
    System.out.println(sorted);
    return sorted;
  
  }

  public static void main(String[] args){
    SortRecorder recorder = new SortRecorder();
    Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);
    Collections.shuffle(cards);
    Card[] card_arr = cards.toArray(new Card[0]);
    cards = sort(cards, recorder);
    System.out.println(cards);

  }
}
