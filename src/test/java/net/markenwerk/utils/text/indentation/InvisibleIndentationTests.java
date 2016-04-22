package net.markenwerk.utils.text.indentation;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class InvisibleIndentationTests {

	@Test(expected = IllegalArgumentException.class)
	public void create_nullLineBreak() {

		new InvisibleIndentation(null);

	}

	@Test
	public void isVisible_invisible() {

		Indentation indentation = new InvisibleIndentation();

		Assert.assertFalse(indentation.isVisible());

	}

	@Test
	public void get_notNull() {

		Indentation indentation = new InvisibleIndentation();

		String indentationString = indentation.get(0);

		Assert.assertNotNull(indentationString);

	}

	@Test
	public void get_invisibleAtLevelZero() {

		Indentation indentation = new InvisibleIndentation();

		String indentationString = indentation.get(0);

		Assert.assertEquals("", indentationString);

	}

	@Test
	public void get_invisibleAtLevelNotZero() {

		Indentation indentation = new InvisibleIndentation();

		String indentationString = indentation.get(1);

		Assert.assertEquals("", indentationString);

	}

	@Test
	public void get_invisibleLineBreakAtLevelZero() {

		Indentation indentation = new InvisibleIndentation();

		String indentationString = indentation.get(0, true);

		Assert.assertEquals("", indentationString);

	}

	@Test
	public void get_invisibleLineBreakAtLevelNotZero() {

		Indentation indentation = new InvisibleIndentation();

		String indentationString = indentation.get(1, true);

		Assert.assertEquals("", indentationString);

	}

	@Test
	public void appendTo_invisibleAtLevelZero() throws IllegalArgumentException, IOException {

		Indentation indentation = new InvisibleIndentation();

		StringBuilder stringBuilder = new StringBuilder();
		indentation.appendTo(stringBuilder, 0);
		String indentationString = stringBuilder.toString();

		Assert.assertEquals("", indentationString);

	}

	@Test
	public void appendTo_invisibleAtLevelNotZero() throws IllegalArgumentException, IOException {

		Indentation indentation = new InvisibleIndentation();

		StringBuilder stringBuilder = new StringBuilder();
		indentation.appendTo(stringBuilder, 1);
		String indentationString = stringBuilder.toString();

		Assert.assertEquals("", indentationString);

	}

	@Test
	public void appendTo_invisibleLineBreakAtLevelZero() throws IllegalArgumentException, IOException {

		Indentation indentation = new InvisibleIndentation();

		StringBuilder stringBuilder = new StringBuilder();
		indentation.appendTo(stringBuilder, 0, true);
		String indentationString = stringBuilder.toString();

		Assert.assertEquals("", indentationString);

	}

	@Test
	public void appendTo_invisibleLineBreakAtLevelNotZero() throws IllegalArgumentException, IOException {

		Indentation indentation = new InvisibleIndentation();

		StringBuilder stringBuilder = new StringBuilder();
		indentation.appendTo(stringBuilder, 1, true);
		String indentationString = stringBuilder.toString();

		Assert.assertEquals("", indentationString);

	}

}
