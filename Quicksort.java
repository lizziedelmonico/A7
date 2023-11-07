import java.util.Collections;
public class Quicksort {
  
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
    CardPile smaller = new CardPile();
    CardPile bigger = new CardPile();
    while(!unsorted.isEmpty()){
      Card unSCard = unsorted.removeFirst(); 
      if(unSCard.compareTo(pivot) < 0){
        smaller.add(unSCard);
      }else{
        bigger.add(unSCard);
      }
    record.add(smaller);
    record.add(pivot);
    record.add(bigger);
    record.next();
    }
    CardPile results = new CardPile();
    results.append(quickSortCards(smaller, record));
    results.add(pivot);
    results.append(quickSortCards(bigger, record));
    return results;
  }
  
  
  public static void main(String[] args) {
    SortRecorder recorder = new SortRecorder();


    Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);



    Collections.shuffle(cards);


    Card[] card_arr = cards.toArray(new Card[0]);

    cards = Quicksort.sort(cards, recorder);


    System.out.println(cards);


    recorder.display("Card Sort Demo: QuickSort");
  }
}