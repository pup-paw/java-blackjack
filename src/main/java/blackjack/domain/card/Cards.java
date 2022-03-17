package blackjack.domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cards {
	private static final int CRITERIA_SELECT_ACE_VALUE = 11;
	private static final int ADDITIONAL_ACE_VALUE = 10;

	private final List<Card> cards;

	public Cards() {
		this.cards = new ArrayList<>();
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public int sum() {
		int sum = cards.stream()
			.mapToInt(Card::getValue)
			.sum();
		if (hasAce()) {
			return selectAceValue(sum);
		}
		return sum;
	}

	private boolean hasAce() {
		return cards.stream()
			.map(Card::isAce)
			.anyMatch(x -> x.equals(true));
	}

	private int selectAceValue(int sum) {
		if (sum <= CRITERIA_SELECT_ACE_VALUE) {
			sum += ADDITIONAL_ACE_VALUE;
		}
		return sum;
	}

	public Card pickRandomCard() {
		shuffle();
		return pickFirstCard();
	}

	private void shuffle() {
		Collections.shuffle(this.cards);
	}

	public Card pickFirstCard() {
		return this.cards.get(0);
	}

	public void remove(Card card) {
		this.cards.remove(card);
	}

	public List<String> getCardNames() {
		return this.cards.stream()
			.map(Card::getName)
			.collect(Collectors.toList());
	}

	public List<Card> getCards() {
		return List.copyOf(this.cards);
	}
}
