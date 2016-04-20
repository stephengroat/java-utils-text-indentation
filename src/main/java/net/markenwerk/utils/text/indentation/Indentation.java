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
	 * Returns a string that needs to be appended at the beginning of a line for
	 * a given depth.
	 * 
	 * <p>
	 * This method must not return {@literal null}.
	 * 
	 * @param depth
	 *            The indentation depth.
	 * @return The indentation string.
	 * @throws IllegalArgumentException
	 *             if the given depth is negative.
	 */
	public String getIndentationString(int depth) throws IllegalArgumentException;

	/**
	 * Returns whether this {@link Indentation} has any visible effect or if
	 * every {@link Indentation#getIndentationString(int) indentation string} is
	 * the empty string.
	 * 
	 * @return Whether this {@link Indentation} has any visible effect.
	 */
	public boolean isVisible();

}
