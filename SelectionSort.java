import java.util.*;

public class SelectionSort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
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
}
