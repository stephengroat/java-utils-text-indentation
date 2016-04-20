package net.markenwerk.utils.text.indentation;

/**
 * An {@link Whitespace} is one of the typically used whitespace characters.
 * 
 * @author Torsten Krause (tk at markenwerk dot net)
 * @since 1.0.0
 */
public enum Whitespace {

	/**
	 * The space character.
	 */
	SPACE(' '),

	/**
	 * The tab character.
	 */
	TAB('\t');

	private final char whitespaceCharacter;

	private Whitespace(char whitespaceCharacter) {
		this.whitespaceCharacter = whitespaceCharacter;
	}

	/**
	 * Retuern the actual whitespace character described by this
	 * {@link Whitespace}.
	 * 
	 * @return The actual whitespace character.
	 */
	public char getWhitespaceCharacter() {
		return whitespaceCharacter;
	}

}
