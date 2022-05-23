package aud02.cards;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

    private PlayingCard[] cards;
    private boolean[] isDealt;
    private int dealtTotal;

    public Deck() {
        cards = new PlayingCard[52];
        isDealt = new boolean[52];
        dealtTotal = 0;

        for (int i = 0; i < PlayingCardType.values().length; i++) {
            for (int j = 0; j < 13; j++) {
                cards[13 * i + j] = new PlayingCard(j + 2, PlayingCardType.values()[i]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (PlayingCard card : cards) {
            stringBuilder.append(card);
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public PlayingCard[] getCards() {
        return cards;
    }

    private void shuffle() {
        List<PlayingCard> playingCardList = Arrays.asList(cards);
        Collections.shuffle(playingCardList);
    }

    public boolean hasCardsLeft() {
        return (cards.length - dealtTotal) > 0;
    }

    public PlayingCard dealCard() {
        if (!hasCardsLeft()) return null;

        int card = (int) (Math.random() * 52);

        if (!isDealt[card]) {
            isDealt[card] = true;
            dealtTotal++;
            return cards[card];
        }
        return dealCard();
    }

    public void dealCardsSecondWay() {
        shuffle();

        for (PlayingCard card : cards)
            System.out.println(card);
    }

    public static void main(String[] args) {
        Deck deck1 = new Deck();
        System.out.println(deck1);

        deck1.shuffle();
        System.out.println(deck1);

        PlayingCard card;
        while ((card = deck1.dealCard()) != null) {
            System.out.println(card);
        }

        System.out.println();
        Deck deck2 = new Deck();
        System.out.println(deck2);

        deck2.dealCardsSecondWay();
    }

}
