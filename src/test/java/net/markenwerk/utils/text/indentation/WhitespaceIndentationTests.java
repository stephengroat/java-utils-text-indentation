package net.markenwerk.utils.text.indentation;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class WhitespaceIndentationTests {

	@Test(expected = IllegalArgumentException.class)
	public void create_nullWhitespace() {

		new WhitespaceIndentation(null, 0);

	}

	@Test(expected = IllegalArgumentException.class)
	public void create_negativeLength() {

		new WhitespaceIndentation(Whitespace.SPACE, -1);

	}

	@Test(expected = IllegalArgumentException.class)
	public void create_nullLineBreak() {

		new WhitespaceIndentation(Whitespace.SPACE, 0, null);

	}

	@Test
	public void get_lengthZero_invisibleAtLevelZero() {

		Indentation indentation = new WhitespaceIndentation(Whitespace.TAB, 0);

		String indentationString = indentation.get(0);

		Assert.assertEquals("", indentationString);

	}

	@Test
	public void get_lengthZero_invisibleAtLevelNotZero() {

		Indentation indentation = new WhitespaceIndentation(Whitespace.TAB, 0);

		String indentationString = indentation.get(1);

		Assert.assertEquals("", indentationString);

	}

	@Test
	public void get_lengthZero_invisibleLineBreakAtLevelZero() {

		Indentation indentation = new WhitespaceIndentation(Whitespace.TAB, 0);

		String indentationString = indentation.get(0, true);

		Assert.assertEquals("", indentationString);

	}

	@Test
	public void get_lengthZero_invisibleLineBreakAtLevelNotZero() {

		Indentation indentation = new WhitespaceIndentation(Whitespace.TAB, 0);

		String indentationString = indentation.get(1, true);

		Assert.assertEquals("", indentationString);

	}

	@Test
	public void appendTo_lengthZero_invisibleAtLevelZero() throws IllegalArgumentException, IOException {

		Indentation indentation = new WhitespaceIndentation(Whitespace.TAB, 0);

		StringBuilder stringBuilder = new StringBuilder();
		indentation.appendTo(stringBuilder, 0);
		String indentationString = stringBuilder.toString();

		Assert.assertEquals("", indentationString);

	}

	@Test
	public void appendTo_lengthZero_invisibleAtLevelNotZero() throws IllegalArgumentException, IOException {

		Indentation indentation = new WhitespaceIndentation(Whitespace.TAB, 0);

		StringBuilder stringBuilder = new StringBuilder();
		indentation.appendTo(stringBuilder, 1);
		String indentationString = stringBuilder.toString();

		Assert.assertEquals("", indentationString);

	}

	@Test
	public void appendTo_lengthZero_invisibleLineBreakAtLevelZero() throws IllegalArgumentException, IOException {

		Indentation indentation = new WhitespaceIndentation(Whitespace.TAB, 0);

		StringBuilder stringBuilder = new StringBuilder();
		indentation.appendTo(stringBuilder, 0, true);
		String indentationString = stringBuilder.toString();

		Assert.assertEquals("", indentationString);

	}

	@Test
	public void appendTo_lengthZero_invisibleLineBreakAtLevelNotZero() throws IllegalArgumentException, IOException {

		Indentation indentation = new WhitespaceIndentation(Whitespace.TAB, 0);

		StringBuilder stringBuilder = new StringBuilder();
		indentation.appendTo(stringBuilder, 1, true);
		String indentationString = stringBuilder.toString();

		Assert.assertEquals("", indentationString);

	}

	@Test
	public void get_lengthOne_notNull() {

		Indentation indentation = new WhitespaceIndentation(Whitespace.SPACE, 1);

		String indentationString = indentation.get(0);

		Assert.assertNotNull(indentationString);

	}

	@Test
	public void get_lengthOne_levelZero() {

		Indentation indentation = new WhitespaceIndentation(Whitespace.SPACE, 1);

		String indentationString = indentation.get(0);

		Assert.assertEquals("", indentationString);

	}

	@Test
	public void get_lengthOne_levelOne() {

		Indentation indentation = new WhitespaceIndentation(Whitespace.SPACE, 1);

		String indentationString = indentation.get(1);

		Assert.assertEquals(" ", indentationString);

	}

	@Test
	public void get_lengthOne_levelTwo() {

		Indentation indentation = new WhitespaceIndentation(Whitespace.SPACE, 1);

		String indentationString = indentation.get(2);

		Assert.assertEquals("  ", indentationString);

	}

	@Test
	public void get_lengthOne_lineBreakAtLevelZero() {

		Indentation indentation = new WhitespaceIndentation(Whitespace.TAB, 1, LineBreak.UNIX);

		String indentationString = indentation.get(0, true);

		Assert.assertEquals("\n", indentationString);

	}

	@Test
	public void get_lengthOne_lineBreakAtLevelOne() {

		Indentation indentation = new WhitespaceIndentation(Whitespace.TAB, 1, LineBreak.UNIX);

		String indentationString = indentation.get(1, true);

		Assert.assertEquals("\n\t", indentationString);

	}

	@Test
	public void get_lengthOne_lineBreakAtLevelTwo() {

		Indentation indentation = new WhitespaceIndentation(Whitespace.TAB, 1, LineBreak.UNIX);

		String indentationString = indentation.get(2, true);

		Assert.assertEquals("\n\t\t", indentationString);

	}

	@Test
	public void appendTo_lengthOne_levelZero() throws IllegalArgumentException, IOException {

		Indentation indentation = new WhitespaceIndentation(Whitespace.SPACE, 1);

		StringBuilder stringBuilder = new StringBuilder();
		indentation.appendTo(stringBuilder, 0);
		String indentationString = stringBuilder.toString();

		Assert.assertEquals("", indentationString);

	}

	@Test
	public void appendTo_lengthOne_levelOne() throws IllegalArgumentException, IOException {

		Indentation indentation = new WhitespaceIndentation(Whitespace.SPACE, 1);

		StringBuilder stringBuilder = new StringBuilder();
		indentation.appendTo(stringBuilder, 1);
		String indentationString = stringBuilder.toString();

		Assert.assertEquals(" ", indentationString);

	}

	@Test
	public void appendTo_lengthOne_levelTwo() throws IllegalArgumentException, IOException {

		Indentation indentation = new WhitespaceIndentation(Whitespace.SPACE, 1);

		StringBuilder stringBuilder = new StringBuilder();
		indentation.appendTo(stringBuilder, 2);
		String indentationString = stringBuilder.toString();

		Assert.assertEquals("  ", indentationString);

	}

	@Test
	public void appendTo_lengthOne_lineBreakAtLevelZero() throws IllegalArgumentException, IOException {

		Indentation indentation = new WhitespaceIndentation(Whitespace.TAB, 1, LineBreak.WINDOWS);

		StringBuilder stringBuilder = new StringBuilder();
		indentation.appendTo(stringBuilder, 0, true);
		String indentationString = stringBuilder.toString();

		Assert.assertEquals("\r\n", indentationString);

	}

	@Test
	public void appendTo_lengthOne_lineBreakAtLevelOne() throws IllegalArgumentException, IOException {

		Indentation indentation = new WhitespaceIndentation(Whitespace.TAB, 1, LineBreak.WINDOWS);

		StringBuilder stringBuilder = new StringBuilder();
		indentation.appendTo(stringBuilder, 1, true);
		String indentationString = stringBuilder.toString();

		Assert.assertEquals("\r\n\t", indentationString);

	}

	@Test
	public void appendTo_lengthOne_lineBreakAtLevelTwo() throws IllegalArgumentException, IOException {

		Indentation indentation = new WhitespaceIndentation(Whitespace.TAB, 1, LineBreak.WINDOWS);

		StringBuilder stringBuilder = new StringBuilder();
		indentation.appendTo(stringBuilder, 2, true);
		String indentationString = stringBuilder.toString();

		Assert.assertEquals("\r\n\t\t", indentationString);

	}

	@Test
	public void get_lengthTwo_notNull() {

		Indentation indentation = new WhitespaceIndentation(Whitespace.SPACE, 2);

		String indentationString = indentation.get(0);

		Assert.assertNotNull(indentationString);

	}

	@Test
	public void get_lengthTwo_levelZero() {

		Indentation indentation = new WhitespaceIndentation(Whitespace.SPACE, 2);

		String indentationString = indentation.get(0);

		Assert.assertEquals("", indentationString);

	}

	@Test
	public void get_lengthTwo_levelOne() {

		Indentation indentation = new WhitespaceIndentation(Whitespace.SPACE, 2);

		String indentationString = indentation.get(1);

		Assert.assertEquals("  ", indentationString);

	}

	@Test
	public void get_lengthTwo_levelTwo() {

		Indentation indentation = new WhitespaceIndentation(Whitespace.SPACE, 2);

		String indentationString = indentation.get(2);

		Assert.assertEquals("    ", indentationString);

	}

	@Test
	public void get_lengthTwo_lineBreakAtLevelZero() {

		Indentation indentation = new WhitespaceIndentation(Whitespace.TAB, 2, LineBreak.UNIX);

		String indentationString = indentation.get(0, true);

		Assert.assertEquals("\n", indentationString);

	}

	@Test
	public void get_lengthTwo_lineBreakAtLevelOne() {

		Indentation indentation = new WhitespaceIndentation(Whitespace.TAB, 2, LineBreak.UNIX);

		String indentationString = indentation.get(1, true);

		Assert.assertEquals("\n\t\t", indentationString);

	}

	@Test
	public void get_lengthTwo_lineBreakAtLevelTwo() {

		Indentation indentation = new WhitespaceIndentation(Whitespace.TAB, 2, LineBreak.UNIX);

		String indentationString = indentation.get(2, true);

		Assert.assertEquals("\n\t\t\t\t", indentationString);

	}

	@Test
	public void appendTo_lengthTwo_levelZero() throws IllegalArgumentException, IOException {

		Indentation indentation = new WhitespaceIndentation(Whitespace.SPACE, 2);

		StringBuilder stringBuilder = new StringBuilder();
		indentation.appendTo(stringBuilder, 0);
		String indentationString = stringBuilder.toString();

		Assert.assertEquals("", indentationString);

	}

	@Test
	public void appendTo_lengthTwo_levelOne() throws IllegalArgumentException, IOException {

		Indentation indentation = new WhitespaceIndentation(Whitespace.SPACE, 2);

		StringBuilder stringBuilder = new StringBuilder();
		indentation.appendTo(stringBuilder, 1);
		String indentationString = stringBuilder.toString();

		Assert.assertEquals("  ", indentationString);

	}

	@Test
	public void appendTo_lengthTwo_levelTwo() throws IllegalArgumentException, IOException {

		Indentation indentation = new WhitespaceIndentation(Whitespace.SPACE, 2);

		StringBuilder stringBuilder = new StringBuilder();
		indentation.appendTo(stringBuilder, 2);
		String indentationString = stringBuilder.toString();

		Assert.assertEquals("    ", indentationString);

	}

	@Test
	public void appendTo_lengthTwo_lineBreakAtLevelZero() throws IllegalArgumentException, IOException {

		Indentation indentation = new WhitespaceIndentation(Whitespace.TAB, 2, LineBreak.WINDOWS);

		StringBuilder stringBuilder = new StringBuilder();
		indentation.appendTo(stringBuilder, 0, true);
		String indentationString = stringBuilder.toString();

		Assert.assertEquals("\r\n", indentationString);

	}

	@Test
	public void appendTo_lengthTwo_lineBreakAtLevelOne() throws IllegalArgumentException, IOException {

		Indentation indentation = new WhitespaceIndentation(Whitespace.TAB, 2, LineBreak.WINDOWS);

		StringBuilder stringBuilder = new StringBuilder();
		indentation.appendTo(stringBuilder, 1, true);
		String indentationString = stringBuilder.toString();

		Assert.assertEquals("\r\n\t\t", indentationString);

	}

	@Test
	public void appendTo_lengthTwo_lineBreakAtLevelTwo() throws IllegalArgumentException, IOException {

		Indentation indentation = new WhitespaceIndentation(Whitespace.TAB, 2, LineBreak.WINDOWS);

		StringBuilder stringBuilder = new StringBuilder();
		indentation.appendTo(stringBuilder, 2, true);
		String indentationString = stringBuilder.toString();

		Assert.assertEquals("\r\n\t\t\t\t", indentationString);

	}

}
