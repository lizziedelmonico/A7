import java.util.Collections;
/* Sorts the given card pile by using quick sort methods */
public class Quicksort {
  
  /**
   * Sorts a card pile using quick sort techniques
   * @param unsorted  The unsorted card pile
   * @param record  Keeps track of the changes being made to the card pile
   * @return  The sorted card pile
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    record.add(unsorted);
    record.next();

    CardPile result = quickSortCards(unsorted, record);


    record.add(result);
    return result;
  }
  public static CardPile quickSortCards(CardPile unsorted, SortRecorder record){
    if(unsorted.size() < 2){
      return unsorted; 
    }
    Card pivot = unsorted.removeFirst(); 
    CardPile small = new CardPile();
    CardPile big = new CardPile();
    while(!unsorted.isEmpty()){
      Card unsortCard = unsorted.removeFirst(); 
      if(unsortCard.compareTo(pivot) < 0){
        small.add(unsortCard);
      }else{
        big.add(unsortCard);
      }
    record.add(small);
    record.add(pivot);
    record.add(big);
    record.next();
    }
    CardPile results = new CardPile();
    results.append(quickSortCards(small, record));
    results.add(pivot);
    results.append(quickSortCards(big, record));
    return results;
  }
  
  
  public static void main(String[] args) {
    SortRecorder recorder = new SortRecorder();


    Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);



    Collections.shuffle(cards);


    Card[] card_arr = cards.toArray(new Card[0]);

    cards = Quicksort.sort(cards, recorder);


    recorder.display("Card Sort Demo: QuickSort");
  }
}