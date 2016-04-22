package net.markenwerk.utils.text.indentation;

/**
 * A {@link InvisibleIndentation} is an {@link Indentation} that has no visible
 * effect.
 * 
 * @author Torsten Krause (tk at markenwerk dot net)
 * @since 1.0.0
 */
public class InvisibleIndentation extends AbstractIndentation {

	/**
	 * Creates a new {@link InvisibleIndentation} using the
	 * {@link LineBreak#SYSTEM} {@link LineBreak}.
	 */
	public InvisibleIndentation() {
		super("", LineBreak.SYSTEM);
	}

	/**
	 * Creates a new {@link InvisibleIndentation}.
	 * 
	 * @param lineBreak
	 *            The {@link LineBreak} to be used.
	 * 
	 * @throws IllegalArgumentException
	 *             If the given {@link LineBreak} is {@literal null}.
	 */
	public InvisibleIndentation(LineBreak lineBreak) throws IllegalArgumentException {
		super("", lineBreak);
	}

}
