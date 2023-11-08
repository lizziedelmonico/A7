import java.util.Collections;
import java.util.ArrayDeque;

/* Sorts the given card pile using merge sort methods */
public class MergeSort {

  /* The first individual card pile */
  CardPile l1;
  /* The second individual card pile */
  CardPile l2;

  /**
   * Sorts a card pile using merge sort techniques
   * @param unsorted   The unsorted card pile
   * @param record    Keeps track of the changes being made to the card pile
   * @return    The sorted card pile
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {

    ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();


    while (unsorted.size() > 0) {
      CardPile miniPile = new CardPile();
      miniPile.addFirst(unsorted.removeFirst());
      queue.add(miniPile);

    }

    record.add(unsorted);

    while (queue.size() > 1) {
      CardPile one = queue.removeFirst();
      CardPile two = queue.removeFirst();


      CardPile mergedList = merge(one, two);
      queue.push(mergedList);
      record.add(mergedList);

      record.next(); 
      for (CardPile pile: queue) { 
        record.add(pile);
      }

    }

    return queue.remove();
  }

  public static CardPile merge(CardPile one, CardPile two) {
    CardPile mergedList = new CardPile();

    while (one.size() > 0 && two.size() > 0) {


      if (one.getFirst().compareTo(two.getFirst()) == 0) {
        mergedList.add(one.removeFirst());
        mergedList.add(two.removeFirst());
      }

      else if (one.getFirst().compareTo(two.getFirst()) < 0) {

        mergedList.add(one.removeFirst());

      }

      else if (one.getFirst().compareTo(two.getFirst()) > 0) {
        mergedList.add(two.removeFirst());

      }
    }


    mergedList.append(one);
    mergedList.append(two);

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

    // make window appear showing the record
    recorder.display("MergeSort");

  }
}