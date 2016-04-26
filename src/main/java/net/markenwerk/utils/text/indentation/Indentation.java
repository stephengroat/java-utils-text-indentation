/*
 * Copyright (c) 2016 Torsten Krause, Markenwerk GmbH
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.markenwerk.utils.text.indentation;

import java.io.IOException;

/**
 * An {@link Indentation} represents all strings necessary to perform consistent
 * indentation of structured strings.
 * 
 * <p>
 * An {@link Indentation} may choose to have no {@link Indentation#isVisible()
 * visible} effect, in which case calling any other method of the
 * {@link Indentation} has no effect.
 * 
 * @author Torsten Krause (tk at markenwerk dot net)
 * @since 1.0.0
 */
public interface Indentation {

	/**
	 * A {@link WhitespaceIndentation}, using single {@link Whitespace#TAB tab}
	 * character and the system line break, to default to, if no specific
	 * {@link Indentation} is given.
	 */
	public static final Indentation DEFAULT = new WhitespaceIndentation(Whitespace.TAB, 1);

	/**
	 * A {@link InvisibleIndentation}, to default to, if no specific
	 * {@link Indentation} is given.
	 */
	public static final Indentation INVISIBLE = new InvisibleIndentation();

	/**
	 * Returns whether this {@link Indentation} has any visible effect or if
	 * every {@link Indentation#get(int) indentation string} is the empty
	 * string.
	 * 
	 * @return Whether this {@link Indentation} has any visible effect.
	 */
	public boolean isVisible();

	/**
	 * returns the line break string used by this {@link Indentation}.
	 * 
	 * @return The line break string used by this {@link Indentation}.
	 * 
	 */
	public String getLineBreak();

	/**
	 * Returns the string that needs to be appended at the beginning of a line,
	 * with the result that the the line is indented by the given level.
	 * 
	 * <p>
	 * The result is never {@literal null}, even if this {@link Indentation} is
	 * not {@link Indentation#isVisible() visible}.
	 * 
	 * 
	 * @param level
	 *            The indentation level.
	 * @return The indentation string.
	 * @throws IllegalArgumentException
	 *             If the given level is negative.
	 */
	public String get(int level) throws IllegalArgumentException;

	/**
	 * Returns the string that needs to be appended at the beginning of a line,
	 * with the result that the the line is indented by the given level or the
	 * string that needs to be appended at the end of a line, with the result
	 * that the next line is indented by the given level, including the
	 * necessary line break characters.
	 * 
	 * <p>
	 * The line break characters are omitted, if this {@link Indentation} is not
	 * {@link Indentation#isVisible() visible}.
	 * 
	 * <p>
	 * The result is never {@literal null}, even if this {@link Indentation} is
	 * not {@link Indentation#isVisible() visible}.
	 * 
	 * @param level
	 *            The indentation level.
	 * @param includeLineBreak
	 *            Whether to include the line break characters.
	 * @return The indentation string.
	 * 
	 * @throws IllegalArgumentException
	 *             If the given level is negative.
	 */
	public String get(int level, boolean includeLineBreak) throws IllegalArgumentException;

	/**
	 * Appends the string that needs to be appended at the beginning of a line,
	 * with the result that the the line is indented by the given level, to the
	 * given {@link Appendable}
	 * 
	 * @param appendable
	 *            The {@link Appendable} to be used.
	 * @param level
	 *            The indentation level.
	 * 
	 * @throws IllegalArgumentException
	 *             If the given {@link Appendable} is {@literal null} or if the
	 *             given level is negative.
	 * @throws IOException
	 *             If appending to the given {@link Appendable} failed.
	 */
	public void appendTo(Appendable appendable, int level) throws IllegalArgumentException, IOException;

	/**
	 * Appends the string that needs to be appended at the beginning of a line,
	 * with the result that the the line is indented by the given level or the
	 * string that needs to be appended at the end of a line, with the result
	 * that the next line is indented by the given level, including the
	 * necessary line break characters, to the given {@link Appendable}.
	 * 
	 * <p>
	 * The line break characters are omitted, if this {@link Indentation} is not
	 * {@link Indentation#isVisible() visible}.
	 * 
	 * @param appendable
	 *            The {@link Appendable} to be used.
	 * @param level
	 *            The indentation level.
	 * @param includeLineBreak
	 *            Whether to include the line break characters.
	 * 
	 * @throws IllegalArgumentException
	 *             If the given {@link Appendable} is {@literal null} or if the
	 *             given level is negative.
	 * @throws IOException
	 *             If appending to the given {@link Appendable} failed.
	 */
	public void appendTo(Appendable appendable, int level, boolean includeLineBreak) throws IllegalArgumentException,
			IOException;

}
