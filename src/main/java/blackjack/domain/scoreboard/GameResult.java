package blackjack.domain.scoreboard;

import blackjack.domain.card.Card;

import java.util.List;

public class GameResult {
    private final List<Card> resultCards;
    private final WinOrLose winOrLose;

    public GameResult(List<Card> resultCards, WinOrLose winOrLose) {
        this.resultCards = resultCards;
        this.winOrLose = winOrLose;
    }

    public int calculateScore() {
        return resultCards.stream()
                .mapToInt(Card::getScore)
                .sum();
    }

    public WinOrLose getWinOrLose(){
        return winOrLose;
    }
}