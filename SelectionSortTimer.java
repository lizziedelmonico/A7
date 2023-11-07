public class SelectionSortTimer {
      /** Starts the program running */
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

  /** This method actually doesn't sort at all */
  public static CardPile sort(CardPile unsorted) {
    
    // Now move cards from one list to another, 
    // and use the recorder to record the steps along the way.
    // In a real implementation, you would actually sort the list.
    // Here, we just move them in the same order they came in
    CardPile sorted = new CardPile();
      
    while (unsorted.size() > 0) {
      // move one card between piles
      sorted.add(unsorted.removeFirst());

    }

    // return the (un)sorted result here
    return sorted;
  }
}
