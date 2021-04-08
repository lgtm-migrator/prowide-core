/*
 * Copyright 2006-2020 Prowide
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.prowidesoftware.swift.model.field;

import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.Generated;

import java.io.Serializable;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.prowidesoftware.swift.model.BIC;
import com.prowidesoftware.swift.model.field.BICContainer;
import com.prowidesoftware.swift.model.field.MultiLineField;


import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <strong>SWIFT MT Field 59A</strong>
 * <p>
 * Model and parser for field 59A of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * 		<li><code>BIC</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>[/34x$]&lt;BIC&gt;</code></li>
 * 		<li>parser pattern: <code>[/S$]S</code></li>
 * 		<li>components pattern: <code>SB</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2020</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field59A extends Field implements Serializable, BICContainer, MultiLineField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2020;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 59A
	 */
    public static final String NAME = "59A";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_59A = "59A";
	public static final String PARSER_PATTERN ="[/S$]S";
	public static final String COMPONENTS_PATTERN = "SB";

	/**
	 * Component number for the Account subfield
	 */
	public static final Integer ACCOUNT = 1;

	/**
	 * Component number for the BIC subfield
	 */
	public static final Integer BIC = 2;

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field59A() {
		super(2);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field59A(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field59A(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "59A")) {
			throw new IllegalArgumentException("cannot create field 59A from tag "+tag.getName()+", tagname must match the name of the field.");
		}
		parse(tag.getValue());
	}

	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field59A newInstance(Field59A source) {
		Field59A cp = new Field59A();
		cp.setComponents(new ArrayList<>(source.getComponents()));
		return cp;
	}

	/**
	 * Create a Tag with this field name and the given value.
	 * Shorthand for <code>new Tag(NAME, value)</code>
	 * @see #NAME
	 * @since 7.5
	 */
	public static Tag tag(final String value) {
		return new Tag(NAME, value);
	}

	/**
	 * Create a Tag with this field name and an empty string as value
	 * Shorthand for <code>new Tag(NAME, "")</code>
	 * @see #NAME
	 * @since 7.5
	 */
	public static Tag emptyTag() {
		return new Tag(NAME, "");
	}


	/**
	 * Parses the parameter value into the internal components structure.
	 *
	 * <p>Used to update all components from a full new value, as an alternative
	 * to setting individual components. Previous component values are overwritten.
	 *
	 * @param value complete field value including separators and CRLF
	 * @since 7.8
	 */
	@Override
	public void parse(final String value) {
		init(2);
		List<String> lines = SwiftParseUtils.getLines(value);
		if (!lines.isEmpty()) {
			if (lines.get(0).startsWith("/")) {
		  		setComponent1(StringUtils.substring(lines.get(0), 1));
		  		SwiftParseUtils.setComponentsFromLines(this, 2, null, 1, lines);
		 	} else {
		  		SwiftParseUtils.setComponentsFromLines(this, 2, null, 0, lines);
		 	}
		}
	}
	/**
	 * Serializes the fields' components into the single string value (SWIFT format)
	 */
	@Override
	public String getValue() {
		final StringBuilder result = new StringBuilder();
		if (getComponent1() != null) {
			result.append("/").append(getComponent1());
		}
		appendInLines(result, getComponent2());
		return result.toString();
	}
	/**
	 * Returns a localized suitable for showing to humans string of a field component.<br>
	 *
	 * @param component number of the component to display
	 * @param locale optional locale to format date and amounts, if null, the default locale is used
	 * @return formatted component value or null if component number is invalid or not present
	 * @throws IllegalArgumentException if component number is invalid for the field
	 * @since 7.8
	 */
	@Override
	public String getValueDisplay(int component, Locale locale) {
		if (component < 1 || component > 2) {
			throw new IllegalArgumentException("invalid component number "+component+" for field 59A");
		}
		if (component == 1) {
			//default format (as is)
			return getComponent(1);
		}
		if (component == 2) {
			//default format (as is)
			return getComponent(2);
		}
		return null;
	}
	/**
	 * Returns the field components pattern
	 * @return the static value of Field59A.COMPONENTS_PATTERN
	 */
	@Override
	public final String componentsPattern() {
		return COMPONENTS_PATTERN;
	}

	/**
     * Returns the field parser pattern
     * @return the static value of Field59A.PARSER_PATTERN
     */
	@Override
	public final String parserPattern() {
        return PARSER_PATTERN;
    }

	/**
	 * Returns the field validator pattern
	 */
	@Override
	public final String validatorPattern() {
		return "[/34x$]<BIC>";
	}

    /**
     * Given a component number it returns true if the component is optional,
     * regardless of the field being mandatory in a particular message.<br>
     * Being the field's value conformed by a composition of one or several
     * internal component values, the field may be present in a message with
     * a proper value but with some of its internal components not set.
     *
     * @param component component number, first component of a field is referenced as 1
     * @return true if the component is optional for this field, false otherwise
     */
    @Override
    public boolean isOptional(int component) {
        if (component == 1) {
            return true;
        }
        return false;
    }

    /**
     * Returns true if the field is a GENERIC FIELD as specified by the standard.
     * @return true if the field is generic, false otherwise
     */
    @Override
    public boolean isGeneric() {
        return false;
    }

	/**
	 * Returns the defined amount of components.<br>
	 * This is not the amount of components present in the field instance, but the total amount of components
	 * that this field accepts as defined.
	 * @since 7.7
	 */
	@Override
	public int componentsSize() {
		return 2;
	}

	/**
	 * Returns english label for components.
	 * <br>
	 * The index in the list is in sync with specific field component structure.
	 * @see #getComponentLabel(int)
	 * @since 7.8.4
	 */
	@Override
	protected List<String> getComponentLabels() {
		List<String> result = new ArrayList<>();
		result.add("Account");
		result.add("BIC");
		return result;
	}

	/**
	 * Returns a mapping between component numbers and their label in camel case format.
	 * @since 7.10.3
	 */
	@Override
	protected Map<Integer, String> getComponentMap() {
		Map<Integer, String> result = new HashMap<>();
		result.put(1, "account");
		result.put(2, "bIC");
		return result;
	}
	/**
	 * Gets the component 1 (Account).
	 * @return the component 1
	 */
	public String getComponent1() {
		return getComponent(1);
	}

	/**
	 * Gets the Account (component 1) removing its starting slashes if any.
	 * @return the Account from component 1
	 */
	public String getAccount() {
		String c = getComponent(1);
		if (c != null) {
			for (int i=0; i<c.length(); i++) {
				if (c.charAt(i) != '/') {
					return c.substring(i);
				}
			}
			return "";
		}
		return null;
	}
	/**
	 * Gets the component 2 (BIC).
	 * @return the component 2
	 */
	public String getComponent2() {
		return getComponent(2);
	}

	/**
	 * Get the component 2 as BIC
	 * @return the component 2 converted to BIC or null if cannot be converted
	 */
	public com.prowidesoftware.swift.model.BIC getComponent2AsBIC() {
		return SwiftFormatUtils.getBIC(getComponent(2));
	}

	/**
	 * Gets the BIC (component 2).
	 * @return the BIC from component 2
	 */
	public String getBIC() {
		return getComponent(2);
	}
	
	/**
	 * Get the BIC (component 2) as BIC
	 * @return the BIC from component 2 converted to BIC or null if cannot be converted
	 */
	public com.prowidesoftware.swift.model.BIC getBICAsBIC() {
		return SwiftFormatUtils.getBIC(getComponent(2));
	}

	public List<BIC> bics () {
		final List<BIC> result = new ArrayList<>();
		result.add(SwiftFormatUtils.getBIC(getComponent(2)));
		return result;
	}

	public List<String> bicStrings () {
		final List<String> result = new ArrayList<>();
		result.add(getComponent(2));
		return result;
	}


	/**
	 * Set the component1 (Account).
	 * @param component1 the component1 to set
	 */
	public Field59A setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the Account (component1).
	 * @param component1 the Account to set
	 */
	public Field59A setAccount(String component1) {
		setComponent(1, component1);
		return this;
	}

	/**
	 * Set the component2 (BIC).
	 * @param component2 the component2 to set
	 */
	public Field59A setComponent2(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the component2 from a BIC object.
	 * @param component2 the BIC with the component2 content to set
	 */
	public Field59A setComponent2(com.prowidesoftware.swift.model.BIC component2) {
		setComponent(2, SwiftFormatUtils.getBIC(component2));
		return this;
	}
	
	/**
	 * Set the BIC (component2).
	 * @param component2 the BIC to set
	 */
	public Field59A setBIC(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the BIC (component2) from a BIC object.
	 * @see #setComponent2(com.prowidesoftware.swift.model.BIC)
	 * @param component2 BIC with the BIC content to set
	 */
	public Field59A setBIC(com.prowidesoftware.swift.model.BIC component2) {
		setComponent2(component2);
		return this;
	}

   
	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field59A.NAME
	 */
	@Override
	public String getName() {
		return NAME;
	}

	/**
	 * Gets the first occurrence form the tag list or null if not found.
	 * @return null if not found o block is null or empty
	 * @param block may be null or empty 
	 */
	public static Field59A get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field59A(t) ;
	}
	
	/**
	 * Gets the first instance of Field59A in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field59A get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field59A in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static List<Field59A> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field59A from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static List<Field59A> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length > 0) {
			final List<Field59A> result = new ArrayList<>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field59A(f));
			}
			return result;
		}
		return java.util.Collections.emptyList();
	}
	
	/**
	 * Returns a specific line from the field's value.<br>
	 *
	 * @see MultiLineField#getLine(int)
	 * @param line a reference to a specific line in the field, first line being 1
	 * @return line content or null if not present or if line number is above the expected
	 * @since 7.7
	 */
	public String getLine(int line) {
		return getLine(line, 0);
	}
	
	/**
	 * Returns a specific line from the field's value.<br>
	 * 
	 * @see MultiLineField#getLine(int, int)
	 * @param line a reference to a specific line in the field, first line being 1
	 * @param offset an optional component number used as offset when counting lines
	 * @return line content or null if not present or if line number is above the expected
	 * @since 7.7
	 */
	public String getLine(int line, int offset) {
		Field59A cp = newInstance(this);
		return getLine(cp, line, null, offset);
	}
	
	/**
	 * Returns the field value split into lines.<br>
	 *
	 * @see MultiLineField#getLines()
	 * @return lines content or empty list if field's value is empty
	 * @since 7.7
	 */
	public List<String> getLines() {
		return SwiftParseUtils.getLines(getValue());
	}

	/**
	 * Returns the field value starting at the offset component, split into lines.<br>
	 *
	 * @see MultiLineField#getLines(int)
	 * @param offset an optional component number used as offset when counting lines
	 * @return found lines or empty list if lines are not present or the offset is invalid
	 * @since 7.7
	 */
	public List<String> getLines(int offset) {
		Field59A cp = newInstance(this);
		return SwiftParseUtils.getLines(getLine(cp, null, null, offset));
	}
	
	/**
	 * Returns a specific subset of lines from the field's value, given a range.<br>
	 *
	 * @see MultiLineField#getLinesBetween(int, int )
	 * @param start a reference to a specific line in the field, first line being 1
	 * @param end a reference to a specific line in the field, must be greater than start
	 * @return found lines or empty list if value is empty
	 * @since 7.7
	 */
	public List<String> getLinesBetween(int start, int end) {
		return getLinesBetween(start, end, 0);
	}

	/**
	 * Returns a specific subset of lines from the field's value, starting at the offset component.<br>
	 *
	 * @see MultiLineField#getLinesBetween(int start, int end, int offset)
	 * @param start a reference to a specific line in the field, first line being 1
	 * @param end a reference to a specific line in the field, must be greater than start
	 * @param offset an optional component number used as offset when counting lines
	 * @return found lines or empty list if lines are not present or the offset is invalid
	 * @since 7.7
	 */
	public List<String> getLinesBetween(int start, int end, int offset) {
		Field59A cp = newInstance(this);
		return SwiftParseUtils.getLines(getLine(cp, start, end, offset));
	}

	/**
	 * This method deserializes the JSON data into a Field59A object.
	 * @param json JSON structure including tuples with label and value for all field components
	 * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
	 * @since 7.10.3
	 * @see Field#fromJson(String)
	 */
	public static Field59A fromJson(final String json) {
		Field59A field = new Field59A();
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(json);
		if (jsonObject.get("account") != null) {
			field.setComponent1(jsonObject.get("account").getAsString());
		}
		if (jsonObject.get("bIC") != null) {
			field.setComponent2(jsonObject.get("bIC").getAsString());
		}
		return field;
	}
	

}
