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

import java.util.HashMap;
import java.util.Map;

/**
 * An {@link AbstractIndentation} is an {@link Indentation} that repeats a given
 * indentation string.
 * 
 * <p>
 * The strings containing the repetitions of the indentation string will be
 * reused.
 * 
 * @author Torsten Krause (tk at markenwerk dot net)
 * @since 1.0.0
 */
public abstract class AbstractIndentation implements Indentation {

	private final Map<Integer, String> indentations = new HashMap<Integer, String>();

	private final String indentationString;

	/**
	 * Creates a new {@link AbstractIndentation} for the given indentation
	 * string.
	 * 
	 * @param indentationString
	 *            the indentation string to be used.
	 * @throws IllegalArgumentException
	 *             If the given indentation string is {@literal null}.
	 * 
	 */
	public AbstractIndentation(String indentationString) throws IllegalArgumentException {
		if (null == indentationString) {
			throw new IllegalArgumentException("indentationString is null");
		}
		this.indentationString = indentationString;
	}

	@Override
	public final String getIndentationString(int amount) throws IllegalArgumentException {
		if (amount < 0) {
			throw new IllegalArgumentException("depth is negative");
		}
		if (0 == amount) {
			return "";
		} else {
			String indentation = indentations.get(amount);
			if (null == indentation) {
				synchronized (indentations) {
					StringBuilder builder = new StringBuilder();
					for (int i = 0; i < amount; i++) {
						builder.append(indentationString);
					}
					indentation = builder.toString();
					indentations.put(amount, indentation);
				}
			}
			return indentation;
		}
	}

	@Override
	public final boolean isVisible() {
		return 0 != indentationString.length();
	}

}
