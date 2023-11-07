import java.util.ArrayDeque;
import java.util.*;

public class MergeSort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();
    CardPile sorted = new CardPile();
  
    // ***********************************************************
    // Here is where you'll do the "work" of MergeSort:
    //   - Use queue to store the intermediate piles
    //   - Don't forget to register the new state with the
    //     recorder after each merge step:
    //        record.next();        // tell it this is a new step
    //        for (CardPile pile: queue) { // add all piles
    //           record.add(pile);
    //        }
    // ***********************************************************

    for(ListIterator<Card> iterator = unsorted.listIterator(); iterator.hasNext();){
      CardPile a = new CardPile();
      queue.add(a);
    } while(queue.size() > 1){
      CardPile one = queue.remove();
      CardPile two = queue.remove();
      if(one.getFirst().compareTo(two.getFirst()) > 0){
        sorted.add(one.getFirst());
      }

    }





    // return the sorted result here
    return queue.remove();
  }
}
