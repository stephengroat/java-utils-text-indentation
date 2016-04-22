# A Common indentation for pretty printing libraries

[![Build Status](https://travis-ci.org/markenwerk/java-utils-text-indentation.svg?branch=master)](https://travis-ci.org/markenwerk/java-utils-text-indentation)
[![Coverage Status](https://coveralls.io/repos/github/markenwerk/java-utils-text-indentation/badge.svg?branch=master)](https://coveralls.io/github/markenwerk/java-utils-text-indentation?branch=master)
[![Dependency Status](https://www.versioneye.com/user/projects/571906ddfcd19a0039f17ad9/badge.svg)](https://www.versioneye.com/user/projects/571906ddfcd19a0039f17ad9)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/net.markenwerk/utils-text-indentation/badge.svg)](https://maven-badges.herokuapp.com/maven-central/net.markenwerk/utils-text-indentation)
[![Issues](https://img.shields.io/github/issues/markenwerk/java-utils-text-indentation.svg)](https://github.com/markenwerk/java-utils-text-indentation/issues)
[![MIT License](https://img.shields.io/badge/license-MIT-brightgreen.svg)](https://github.com/markenwerk/java-utils-text-indentation/blob/master/LICENSE)

## Overview

This library provides a Common indentation for other libraries that include a pretty printing functionality.

Consult the [documentation](http://markenwerk.github.io/java-utils-text-indentation/javadoc/index.html) and [usage description](#usage) for further information:

- [Using an `Indentation`](#using-an-indentation)
- [Whitespace `Indentation`](#whitespace-indentation)
- [Invisible `Indentation`](#invisible-indentation)

## Maven

This library is hosted in the [Maven Central Repository](https://maven-badges.herokuapp.com/maven-central/net.markenwerk/utils-text-indentation). You can use it with the following coordinates:

```xml
<dependency>
	<groupId>net.markenwerk</groupId>
	<artifactId>utils-text-indentation</artifactId>
	<version>1.0.0</version>
</dependency>
```

## Motivation

The goal of this library is to avoid unnecessary and probably inconsistent repetition of a configurable indentation for formatted text output (e.g. pretty printing).
 
## Usage

This library provides the [`Indentation`][Indentation] interface.

### Using an `Indentation`

An [`Indentation`][Indentation] provides the following two methods to create a character sequence that needs to be appended at the beginning of a line, with the result that the the line is indented by the given level.

```java
Indentation indentation = ...;

// get an indentation prefix for the given level
indentation.get(level);

// append an indentation prefix for the given level
indentation.append(appendable, level);
```

An [`Indentation`][Indentation] provides the following two methods that optionally append a line break to create the character sequence that needs to be appended at the end of a line, with the result that the next line is indented by the given level. This includes the necessary line break characters.

```java
Indentation indentation = ...;

// get an indentation prefix for the given level
indentation.get(level, true);

// append an indentation prefix for the given level
indentation.append(appendable, level, true);
```

It is also possible to check, if an [`Indentation`][Indentation] will have any visible effect.

```java
Indentation indentation = ...;

// check if the indentation will return non-empty strings 
boolean prettyPrinting = indentation.isVisible();
```

The result of `isVisible()` is useful, if a pretty printer needs to behave differently (e.g. add whitespace between separators). Even if `isVisible()` returns `false`, `getPrefix(int)` and `getLineBreak(int)` will always return a [`String`] that is not `null`. This means that it is safe to use these methods without any checks. An [`Indentation`][Indentation] that has no visible effect won't include the line break characters.

### Whitespace `Indentation`

This library provides the [`WhitespaceIndentation`][WhitespaceIndentation] that can be safely configured to create indentation strings with the most common whitespace characters (tab and space).

```java
// indentation with four spaces
Indentation spaceIndentation = new WhitespaceIndentation(Whitespace.SPACE, 4);

// indentation with one tab and windows style line break
Indentation tabIndentation = new WhitespaceIndentation(Whitespace.TAB, 1, LineBreak.WINDOWS);
```

### Invisible `Indentation`

This library provides the [`InvisibleIndentation`][InvisibleIndentation] that has no visible effect.

```java
// indentation without visible effects
Indentation spaceIndentation = new InvisibleIndentation();
```

[Indentation]:  http://markenwerk.github.io/java-utils-text-indentation/index.html?net/markenwerk/utils/text/indentation/Indentation.html
[InvisibleIndentation]:  http://markenwerk.github.io/java-utils-text-indentation/index.html?net/markenwerk/utils/text/indentation/InvisibleIndentation.html
[WhitespaceIndentation]:  http://markenwerk.github.io/java-utils-text-indentation/index.html?net/markenwerk/utils/text/indentation/WhitespaceIndentation.html


[String]: http://docs.oracle.com/javase/8/docs/api/index.html?java/lang/String.html

