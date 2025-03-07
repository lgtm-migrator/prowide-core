/*
 * Copyright 2006-2021 Prowide
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
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;

import java.io.Serializable;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import java.math.BigDecimal;
import java.math.BigInteger;


import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 137.
 * <p>
 * Model and parser for field 137 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>Character</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>Long</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>1a3!x&lt;CC&gt;4!n</code></li>
 * 		<li>parser pattern: <code>c3!S&lt;CC&gt;N</code></li>
 * 		<li>components pattern: <code>cSKN</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2021</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field137 extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 137.
	 */
    public static final String NAME = "137";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_137 = "137";

    /**
     * @deprecated Use {@link #parserPattern()} method instead.
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
	public static final String PARSER_PATTERN = "c3!S<CC>N";

    /**
     * @deprecated Use {@link #typesPattern()} method instead.
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
	public static final String COMPONENTS_PATTERN = "cSKN";

    /**
     * @deprecated Use {@link #typesPattern()} method instead.
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
	public static final String TYPES_PATTERN = "cSKN";

	/**
	 * Component number for the Broadcast Indicator subfield.
	 */
	public static final Integer BROADCAST_INDICATOR = 1;

	/**
	 * Component number for the Unsequenced Broadcast subfield.
	 */
	public static final Integer UNSEQUENCED_BROADCAST = 2;

	/**
	 * Component number for the Broadcast Issuer subfield.
	 */
	public static final Integer BROADCAST_ISSUER = 3;

	/**
	 * Component number for the Broadcast Number subfield.
	 */
	public static final Integer BROADCAST_NUMBER = 4;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field137() {
        super(4);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field137(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field137(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "137")) {
            throw new IllegalArgumentException("cannot create field 137 from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field137 newInstance(Field137 source) {
        Field137 cp = new Field137();
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
     * Create a Tag with this field name and an empty string as value.
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
        init(4);
        if (value != null) {
            final String toparse = SwiftParseUtils.getAlphaPrefix(value);
            if (toparse != null && toparse.length() > 0) {
                if (toparse.length() > 0) {
                    setComponent1(StringUtils.substring(toparse, 0, 1));
                    if (toparse.length() >= 4) {
                        setComponent2(StringUtils.substring(toparse, 1, 4));
                        if (toparse.length() > 4) {
                            setComponent3(StringUtils.substring(toparse, 4));
                        }
                    } else {
                        setComponent2(StringUtils.substring(toparse, 1));
                    }
                }
            }
            setComponent4(SwiftParseUtils.getNumericSuffix(value));
        }
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        result.append(joinComponents());
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
        if (component < 1 || component > 4) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 137");
        }
        if (component == 1) {
            //default format (as is)
            return getComponent(1);
        }
        if (component == 2) {
            //default format (as is)
            return getComponent(2);
        }
        if (component == 3) {
            //default format (as is)
            return getComponent(3);
        }
        if (component == 4) {
            //default format (as is)
            return getComponent(4);
        }
        return null;
    }

    /**
     * @deprecated Use {@link #typesPattern()} instead.
     */
    @Override
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public String componentsPattern() {
        return "cSKN";
    }

    /**
     * Returns the field component types pattern.
     *
     * This method returns a letter representing the type for each component in the Field. It supersedes
     * the Components Pattern because it distinguishes between N (Number) and I (BigDecimal).
     * @since 9.2.7
     */
    @Override
    public String typesPattern() {
        return "cSKN";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "c3!S<CC>N";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "1a3!x<CC>4!n";
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
        return 4;
    }

    /**
     * Returns english label for components.
     * <br>
     * The index in the list is in sync with specific field component structure.
     * @see #getComponentLabel(int)
     * @since 7.8.4
     */
    @Override
    public List<String> getComponentLabels() {
        List<String> result = new ArrayList<>();
        result.add("Broadcast Indicator");
        result.add("Unsequenced Broadcast");
        result.add("Broadcast Issuer");
        result.add("Broadcast Number");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "broadcastIndicator");
        result.put(2, "unsequencedBroadcast");
        result.put(3, "broadcastIssuer");
        result.put(4, "broadcastNumber");
        return result;
    }


    /**
     * Gets the component 1 (Broadcast Indicator).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the Broadcast Indicator (component 1).
     * @return the Broadcast Indicator from component 1
     */
    public String getBroadcastIndicator() {
        return getComponent1();
    }

    /**
     * Gets the component 2 (Unsequenced Broadcast).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Unsequenced Broadcast (component 2).
     * @return the Unsequenced Broadcast from component 2
     */
    public String getUnsequencedBroadcast() {
        return getComponent2();
    }

    /**
     * Gets the component 3 (Broadcast Issuer).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Gets the Broadcast Issuer (component 3).
     * @return the Broadcast Issuer from component 3
     */
    public String getBroadcastIssuer() {
        return getComponent3();
    }

    /**
     * Gets the component 4 (Broadcast Number).
     * @return the component 4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Get the component 4 as Long
     *
     * @return the component 4 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent4AsLong() {
        return SwiftFormatUtils.getLong(getComponent(4));
    }

    /**
     * Get the component 4 as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent4AsLong()</code> to get the proper value.
     *
     * @return the component 4 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getComponent4AsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public java.lang.Number getComponent4AsNumber() {
        Long l = getComponent4AsLong();
        return l != null ? new BigDecimal(l) : null;
    }

    /**
     * Gets the Broadcast Number (component 4).
     * @return the Broadcast Number from component 4
     */
    public String getBroadcastNumber() {
        return getComponent4();
    }

    /**
     * Get the Broadcast Number (component 4) as Long
     * @return the Broadcast Number from component 4 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getBroadcastNumberAsLong() {
        return getComponent4AsLong();
    }

    /**
     * Get the Broadcast Number (component 4) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent4AsLong()</code> to get the proper value.
     *
     * @return the component 4 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getBroadcastNumberAsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public java.lang.Number getBroadcastNumberAsNumber() {
        return getComponent4AsNumber();
    }

    /**
     * Set the component 1 (Broadcast Indicator).
     *
     * @param component1 the Broadcast Indicator to set
     * @return the field object to enable build pattern
     */
    public Field137 setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Broadcast Indicator (component 1).
     *
     * @param component1 the Broadcast Indicator to set
     * @return the field object to enable build pattern
     */
    public Field137 setBroadcastIndicator(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Unsequenced Broadcast).
     *
     * @param component2 the Unsequenced Broadcast to set
     * @return the field object to enable build pattern
     */
    public Field137 setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the Unsequenced Broadcast (component 2).
     *
     * @param component2 the Unsequenced Broadcast to set
     * @return the field object to enable build pattern
     */
    public Field137 setUnsequencedBroadcast(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Broadcast Issuer).
     *
     * @param component3 the Broadcast Issuer to set
     * @return the field object to enable build pattern
     */
    public Field137 setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the Broadcast Issuer (component 3).
     *
     * @param component3 the Broadcast Issuer to set
     * @return the field object to enable build pattern
     */
    public Field137 setBroadcastIssuer(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Broadcast Number).
     *
     * @param component4 the Broadcast Number to set
     * @return the field object to enable build pattern
     */
    public Field137 setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the component4 from a Long object.
     * <br>
     * <em>If the component being set is a fixed length number, the argument will not be
     * padded.</em> It is recommended for these cases to use the setComponent4(String)
     * method.
     *
     * @see #setComponent4(String)
     * @since 9.2.7
     *
     * @param component4 the Long with the Broadcast Number content to set
     * @return the field object to enable build pattern
     */
    public Field137 setComponent4(java.lang.Long component4) {
        setComponent(4, SwiftFormatUtils.getLong(component4));
        return this;
    }

    /**
     * Alternative method setter for field's Broadcast Number (component 4) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the Broadcast Number content to set
     * @return the field object to enable build pattern
     * @see #setBroadcastNumber(java.lang.Long)
     */
    public Field137 setComponent4(java.lang.Number component4) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component4 instanceof Long) {
            setComponent(4, SwiftFormatUtils.getLong((Long) component4));
        } else if (component4 instanceof BigInteger || component4 instanceof Integer) {
            setComponent(4, SwiftFormatUtils.getLong(component4.longValue()));
        } else if (component4 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(4, SwiftFormatUtils.getLong(component4.longValue()));
        } else {
            // explicitly set component as null
            setComponent(4, null);
        }
        return this;
    }

    /**
     * Set the Broadcast Number (component 4).
     *
     * @param component4 the Broadcast Number to set
     * @return the field object to enable build pattern
     */
    public Field137 setBroadcastNumber(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the Broadcast Number (component 4) from a Long object.
     *
     * @see #setComponent4(java.lang.Long)
     *
     * @param component4 Long with the Broadcast Number content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field137 setBroadcastNumber(java.lang.Long component4) {
        return setComponent4(component4);
    }

    /**
     * Alternative method setter for field's Broadcast Number (component 4) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the Broadcast Number content to set
     * @return the field object to enable build pattern
     * @see #setBroadcastNumber(java.lang.Long)
     */
    public Field137 setBroadcastNumber(java.lang.Number component4) {
        return setComponent4(component4);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field137.NAME
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
    public static Field137 get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field137(t);
    }

    /**
     * Gets the first instance of Field137 in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field137 get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field137 in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field137> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field137 from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field137> getAll(final SwiftTagListBlock block) {
        final List<Field137> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null && arr.length > 0) {
            for (final Tag f : arr) {
                result.add(new Field137(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field137 object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field137 fromJson(final String json) {

        final Field137 field = new Field137();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Broadcast Indicator

        if (jsonObject.get("broadcastIndicator") != null) {
            field.setComponent1(jsonObject.get("broadcastIndicator").getAsString());
        }

        // **** COMPONENT 2 - Unsequenced Broadcast

        if (jsonObject.get("unsequencedBroadcast") != null) {
            field.setComponent2(jsonObject.get("unsequencedBroadcast").getAsString());
        }

        // **** COMPONENT 3 - Broadcast Issuer

        if (jsonObject.get("broadcastIssuer") != null) {
            field.setComponent3(jsonObject.get("broadcastIssuer").getAsString());
        }

        // **** COMPONENT 4 - Broadcast Number

        if (jsonObject.get("broadcastNumber") != null) {
            field.setComponent4(jsonObject.get("broadcastNumber").getAsString());
        }

        return field;
    }


}
