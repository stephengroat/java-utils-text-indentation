package net.markenwerk.utils.text.indentation;

/**
 * An {@link Whitespace} is a whitespace character string.
 * 
 * @author Torsten Krause (tk at markenwerk dot net)
 * @since 1.0.0
 */
public enum Whitespace {

	/**
	 * A single space character.
	 */
	SPACE(" "),

	/**
	 * A single tab character.
	 */
	TAB("\t");

	private final String whitespaceString;

	private Whitespace(String whitespaceString) {
		this.whitespaceString = whitespaceString;
	}

	/**
	 * Returns the whitespace string of this {@link Whitespace}.
	 * 
	 * @return The whitespace string of this {@link Whitespace}.
	 */
	public String getWhitespaceString() {
		return whitespaceString;
	}

}
