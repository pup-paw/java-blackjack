package blackjack.domain.participant;

import java.util.List;
import java.util.stream.Collectors;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;

public abstract class Participant {
	private static final int MAX_SCORE = 21;

	private final Name name;
	private final Cards cards;

	public Participant(Name name) {
		this.name = name;
		this.cards = new Cards();
	}

	public void receiveCard(Card card) {
		cards.addCard(card);
	}

	public Boolean bust() {
		return getScore() > MAX_SCORE;
	}

	abstract public boolean shouldHit();

	public int getScore() {
		return cards.sum();
	}

	public List<String> getCardNames() {
		return cards.getCards().stream()
			.map(Card::getName)
			.collect(Collectors.toList());
	}

	public String getName() {
		return name.getName();
	}

	public Cards getCards() {
		return this.cards;
	}
}
