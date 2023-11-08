import java.util.ArrayDeque;

/* Initializes the timer for the Merge Sort method */
public class MergeSortTimer {
    
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
   * Sorts the given cards using the previously written merge sort method (without the record)
   * @param unsorted  The unsorted card pile
   * @return  The sorted card pile
   */
      public static CardPile sort(CardPile unsorted) {

        ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();
    
    
        while (unsorted.size() > 0) {
          CardPile miniPile = new CardPile();
          miniPile.addFirst(unsorted.removeFirst());
          queue.add(miniPile);
    
        }
    
        while (queue.size() > 1) {
          CardPile l1 = queue.removeFirst();
          CardPile l2 = queue.removeFirst();
    
    
          CardPile mergedList = merge(l1, l2);
          queue.push(mergedList);
    
        }
    
        return queue.remove();
      }
    
      public static CardPile merge(CardPile l1, CardPile l2) {
        CardPile mergedList = new CardPile();
    
        while (l1.size() > 0 && l2.size() > 0) {
    
    
          if (l1.getFirst().compareTo(l2.getFirst()) == 0) {
            mergedList.add(l1.removeFirst());
            mergedList.add(l2.removeFirst());
          }
    
          else if (l1.getFirst().compareTo(l2.getFirst()) < 0) {
    
            mergedList.add(l1.removeFirst());
    
          }
    
          else if (l1.getFirst().compareTo(l2.getFirst()) > 0) {
            mergedList.add(l2.removeFirst());
    
          }
        }
    
    
        mergedList.append(l1);
        mergedList.append(l2);
    
        return mergedList;
      }


}
