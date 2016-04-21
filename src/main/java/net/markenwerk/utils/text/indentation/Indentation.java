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
 * @author Torsten Krause (tk at markenwerk dot net)
 * @since 1.0.0
 */
public interface Indentation {

	/**
	 * A {@link WhitespaceIndentation}, using single {@link Whitespace#TAB tab}
	 * character, to default to, if no specific {@link Indentation} is given.
	 */
	public static final Indentation DEFAULT = new WhitespaceIndentation(Whitespace.TAB, 1);

	/**
	 * Returns whether this {@link Indentation} has any visible effect or if
	 * every {@link Indentation#getPrefix(int) indentation string} is the empty
	 * string.
	 * 
	 * @return Whether this {@link Indentation} has any visible effect.
	 */
	public boolean isVisible();

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
	public String getPrefix(int level) throws IllegalArgumentException;

	/**
	 * Appends the string that needs to be appended at the beginning of a line,
	 * with the result that the the line is indented by the given level, to the
	 * given {@link Appendable}
	 * 
	 * @param appendable
	 *            The {@link Appendable} to be used.
	 * 
	 * @param level
	 *            The indentation level.
	 * @throws IllegalArgumentException
	 *             If the given {@link Appendable} is {@literal null} or if the
	 *             given level is negative.
	 * @throws IOException
	 *             If appending to the given {@link Appendable} failed.
	 */
	public void appendPrefix(Appendable appendable, int level) throws IllegalArgumentException, IOException;

	/**
	 * Returns the string that needs to be appended at the end of a line, with
	 * the result that the next line is indented by the given level. This
	 * includes the necessary line break characters.
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
	 * @return The indentation string.
	 * 
	 * @throws IllegalArgumentException
	 *             If the given level is negative.
	 */
	public String getLineBreak(int level) throws IllegalArgumentException;

	/**
	 * Appends the string that needs to be appended at the end of a line, with
	 * the result that the next line is indented by the given level, to the
	 * given {@link Appendable}. This includes the necessary line break
	 * characters.
	 * 
	 * <p>
	 * The line break characters are omitted, if this {@link Indentation} is not
	 * {@link Indentation#isVisible() visible}.
	 * 
	 * @param appendable
	 *            The {@link Appendable} to be used.
	 * 
	 * @param level
	 *            The indentation level.
	 * @throws IllegalArgumentException
	 *             If the given {@link Appendable} is {@literal null} or if the
	 *             given level is negative.
	 * @throws IOException
	 *             If appending to the given {@link Appendable} failed.
	 */
	public void appendLineBreak(Appendable appendable, int level) throws IllegalArgumentException, IOException;

}
