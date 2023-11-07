import java.util.Collections;
import java.util.ArrayDeque;

public class MergeSort {

  CardPile l1;
  CardPile l2;

  public static CardPile sort(CardPile unsorted, SortRecorder record) {

    ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();


    while (unsorted.size() > 0) {
      CardPile miniPile = new CardPile();
      miniPile.addFirst(unsorted.removeFirst());
      queue.add(miniPile);

    }

    record.add(unsorted);

    while (queue.size() > 1) {
      CardPile l1 = queue.removeFirst();
      CardPile l2 = queue.removeFirst();


      CardPile mergedList = merge(l1, l2);
      queue.push(mergedList);
      record.add(mergedList);

      record.next(); 
      for (CardPile pile: queue) { 
        record.add(pile);
      }

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


  /** Starts the program running */
  public static void main(String args[]) {

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
    cards = MergeSort.sort(cards, recorder);

    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("MergeSort");

  }
}