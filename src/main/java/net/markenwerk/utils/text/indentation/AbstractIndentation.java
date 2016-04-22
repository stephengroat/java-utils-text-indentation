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
 * An {@link AbstractIndentation} is an {@link Indentation} that repeats a given
 * indentation string.
 * 
 * @author Torsten Krause (tk at markenwerk dot net)
 * @since 1.0.0
 */
public abstract class AbstractIndentation implements Indentation {

	private final String indentationString;

	private final String lineBreakString;

	/**
	 * Creates a new {@link AbstractIndentation}.
	 * 
	 * <p>
	 * An {@link AbstractIndentation} with level {@code 0} has no visible
	 * effect.
	 * 
	 * @param indentationString
	 *            The indentation string to be used.
	 * @param lineBreak
	 *            The line break string to be used.
	 * @throws IllegalArgumentException
	 *             If the given indentation string is {@literal null} or if the
	 *             given {@link LineBreak} is {@literal null}.
	 * 
	 */
	public AbstractIndentation(String indentationString, LineBreak lineBreak) {
		this(indentationString, fromLineBreak(lineBreak));
	}

	private static String fromLineBreak(LineBreak lineBreak) {
		if (null == lineBreak) {
			throw new IllegalArgumentException("lineBreak is null");
		}
		return lineBreak.getLineBreakString();
	}

	/**
	 * Creates a new {@link AbstractIndentation}.
	 * 
	 * <p>
	 * An {@link AbstractIndentation} with level {@code 0} has no visible
	 * effect.
	 * 
	 * @param indentationString
	 *            The indentation string to be used.
	 * @param lineBreakString
	 *            The line break string to be used.
	 * @throws IllegalArgumentException
	 *             If the given indentation string is {@literal null} or if the
	 *             given line break string is {@literal null}.
	 * 
	 */
	public AbstractIndentation(String indentationString, String lineBreakString) throws IllegalArgumentException {
		if (null == indentationString) {
			throw new IllegalArgumentException("indentationString is null");
		}
		if (null == lineBreakString) {
			throw new IllegalArgumentException("lineBreakString is null");
		}
		this.indentationString = indentationString;
		this.lineBreakString = lineBreakString;
		lineBreakString = System.getProperty("line.separator");
	}

	@Override
	public String getLineBreak() {
		return lineBreakString;
	}

	@Override
	public final boolean isVisible() {
		return 0 != indentationString.length();
	}

	@Override
	public String get(int level) throws IllegalArgumentException {
		return get(level, false);
	}

	@Override
	public String get(int level, boolean includeLineBreak) throws IllegalArgumentException {
		StringBuilder builder = new StringBuilder();
		if (isVisible()) {
			if (includeLineBreak) {
				builder.append(lineBreakString);
			}
			for (int i = 0; i < level; i++) {
				builder.append(indentationString);
			}
		}
		return builder.toString();
	}

	@Override
	public void appendTo(Appendable appendable, int level) throws IllegalArgumentException, IOException {
		appendTo(appendable, level, false);
	}

	@Override
	public void appendTo(Appendable appendable, int level, boolean includeLineBreak) throws IllegalArgumentException,
			IOException {
		if (null == appendable) {
			throw new IllegalArgumentException("appendable is null");
		}
		if (isVisible()) {
			if (includeLineBreak) {
				appendable.append(lineBreakString);
			}
			for (int i = 0; i < level; i++) {
				appendable.append(indentationString);
			}
		}
	}

}
