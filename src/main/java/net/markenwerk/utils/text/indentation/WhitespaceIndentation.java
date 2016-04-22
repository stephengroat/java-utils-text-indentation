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

import java.io.Writer;

/**
 * An {@link WhitespaceIndentation} is an {@link Indentation} that repeats a
 * given repetition of a {@link Whitespace} character.
 * 
 * <p>
 * The strings containing the repetitions of the indentation string will be
 * reused.
 * 
 * @author Torsten Krause (tk at markenwerk dot net)
 * @since 1.0.0
 */
public final class WhitespaceIndentation extends AbstractIndentation {

	/**
	 * Creates a new {@link WhitespaceIndentation} using the
	 * {@link LineBreak#SYSTEM} {@link LineBreak}.
	 * 
	 * @param whitespace
	 *            The {@link Whitespace} character to be used.
	 * @param length
	 *            The indentation length to be used.
	 * 
	 * @throws IllegalArgumentException
	 *             If the given {@link Writer} is {@literal null} or if the
	 *             given {@link Whitespace} character is {@literal null} or if
	 *             the given indentation length is negative.
	 */
	public WhitespaceIndentation(Whitespace whitespace, int length) throws IllegalArgumentException {
		this(whitespace, length, LineBreak.SYSTEM);
	}

	/**
	 * Creates a new {@link WhitespaceIndentation}.
	 * 
	 * @param whitespace
	 *            The {@link Whitespace} character to be used.
	 * @param length
	 *            The indentation length to be used.
	 * @param lineBreak
	 *            the {@link LineBreak} to be used.
	 * 
	 * @throws IllegalArgumentException
	 *             If the given {@link Writer} is {@literal null} or if the
	 *             given {@link Whitespace} character is {@literal null} or if
	 *             the given indentation length is negative or if the given
	 *             {@link LineBreak} is {@literal null}.
	 */
	public WhitespaceIndentation(Whitespace whitespace, int length, LineBreak lineBreak)
			throws IllegalArgumentException {
		super(fromWhitespaceAndLength(whitespace, length), lineBreak);
	}

	private static String fromWhitespaceAndLength(Whitespace whitespace, int length) {
		if (null == whitespace) {
			throw new IllegalArgumentException("whitespace is null");
		}
		if (length < 0) {
			throw new IllegalArgumentException("length is negative");
		}
		String indentation = "";
		for (int i = 0; i < length; i++) {
			indentation += whitespace.getWhitespaceString();
		}
		return indentation;
	}

}
