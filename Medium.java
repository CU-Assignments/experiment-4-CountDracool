import java.util.*;

class CardCollection {
    Map<String, List<String>> cards = new HashMap<>();

    void addCard(String symbol, String card) {
        cards.computeIfAbsent(symbol, k -> new ArrayList<>()).add(card);
    }

    List<String> getCardsBySymbol(String symbol) {
        return cards.getOrDefault(symbol, Collections.emptyList());
    }

    public static void main(String[] args) {
        CardCollection collection = new CardCollection();
        collection.addCard("Hearts", "Ace");
        collection.addCard("Hearts", "King");
        collection.addCard("Spades", "Queen");
        System.out.println(collection.getCardsBySymbol("Hearts"));
    }
}
