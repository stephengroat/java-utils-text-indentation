package net.markenwerk.utils.text.indentation;

/**
 * An {@link Whitespace} is a line break character string.
 * 
 * @author Torsten Krause (tk at markenwerk dot net)
 * @since 1.0.0
 */
public enum LineBreak {

	/**
	 * A single line feed character.
	 */
	UNIX("\n"),

	/**
	 * A carriage return character followed by an line feed character.
	 */
	WINDOWS("\r\n"),

	/**
	 * The content of the system {@link System#getProperty(String) property}
	 * {@code line.separator}.
	 */
	SYSTEM(System.getProperty("line.separator"));

	private final String lineBreakString;

	private LineBreak(String lineBreakString) {
		this.lineBreakString = lineBreakString;
	}

	/**
	 * Returns the line break string of this {@link LineBreak};
	 * 
	 * @return The line break string of this {@link LineBreak};
	 */
	public String getLineBreakString() {
		return lineBreakString;
	}

}
