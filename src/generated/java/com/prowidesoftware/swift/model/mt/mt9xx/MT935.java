/*
 * Copyright 2006-2022 Prowide
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
package com.prowidesoftware.swift.model.mt.mt9xx;



import com.prowidesoftware.Generated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.model.field.*;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import com.prowidesoftware.swift.utils.Lib;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;

/**
 * MT 935 - Rate Change Advice.
 *
 * <p>
 * SWIFT MT935 (ISO 15022) message structure:
 *
 <div class="scheme"><ul>
<li class="field">Field 20  (M)</li>
<li class="sequence">
Sequence _A (M) (repetitive)<ul><li class="field">Field 23  (O)</li>
<li class="field">Field 25  (O)</li>
<li class="field">Field 30  (M)</li>
<li class="field">Field 37 H (M) (repetitive)</li>
</ul></li>
<li class="field">Field 72  (O)</li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2022</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT935 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2022;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT935.class.getName());
	
	/**
	 * Constant for MT name, this is part of the classname, after MT.
	 */
	public static final String NAME = "935";

	/**
	 * Creates an MT935 initialized with the parameter SwiftMessage.
	 * @param m swift message with the MT935 content
	 */
	public MT935(final SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT935 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT935 content, the parameter can not be null
	 * @see #MT935(String)
	 */
	public MT935(final MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT935 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT935 content
	 * @return the created object or null if the parameter is null
	 * @see #MT935(String)
	 * @since 7.7
	 */
	public static MT935 parse(final MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT935(m);
	}
	
	/**
	 * Creates and initializes a new MT935 input message setting TEST BICS as sender and receiver.
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT935() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT935 input message from sender to receiver.
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT935(final String sender, final String receiver) {
		super(935, sender, receiver);
	}
	
	/**
	 * Creates a new MT935 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT935(final String fin) {
		super();
		if (fin != null) {
			final SwiftMessage parsed = read(fin);
			if (parsed != null) {
				super.m = parsed;
				sanityCheck(parsed);
			}
		}
    }
    
    private void sanityCheck(final SwiftMessage param) {
    	if (param.isServiceMessage()) {
			log.warning("Creating an MT935 object from FIN content with a Service Message. Check if the MT935 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), "935")) {
			log.warning("Creating an MT935 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT935 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter cannot be parsed, the returned MT935 will have its internal message object
	 * initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT935 or null if fin is null 
	 * @since 7.7
	 */
	public static MT935 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT935(fin);
    }
    
    /**
	 * Creates a new MT935 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT935(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT935 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT935 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT935 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT935(stream);
    }
    
    /**
	 * Creates a new MT935 by parsing a file with the message content in its swift FIN format.
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT935(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT935 by parsing a file with the message content in its swift FIN format.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT935 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT935 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT935(file);
    }
    
	/**
	 * Returns this MT number.
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "935";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT935 append(final SwiftTagListBlock block) {
		super.append(block);
		return this;
	}
	
	/**
	 * Add all tags to the end of the block4.
	 *
	 * @param tags to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT935 append(final Tag... tags) {
		super.append(tags);
		return this;
	}
	
	/**
	 * Add all the fields to the end of the block4.
	 *
	 * @param fields to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT935 append(final Field... fields) {
		super.append(fields);
		return this;
	}

   /**
	* Creates an MT935 messages from its JSON representation.
	* <p>
	* For generic conversion of JSON into the corresponding MT instance
	* see {@link AbstractMT#fromJson(String)}
	*
	* @param json a JSON representation of an MT935 message
	* @return a new instance of MT935
	* @since 7.10.3
	*/
	public static MT935 fromJson(final String json) {
		return (MT935) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or null if none is found.
	 * The first occurrence of field 20 at MT935 is expected to be the only one.
	 * 
	 * @return a Field20 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field20 getField20() {
		final Tag t = tag("20");
		if (t != null) {
			return new Field20(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 72, 
	 * or null if none is found.
	 * The first occurrence of field 72 at MT935 is expected to be the only one.
	 * 
	 * @return a Field72 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field72 getField72() {
		final Tag t = tag("72");
		if (t != null) {
			return new Field72(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 23, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 23 at MT935 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field23 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field23> getField23() {
		final List<Field23> result = new ArrayList<>();
		final Tag[] tags = tags("23");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field23(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 25, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 25 at MT935 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field25 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field25> getField25() {
		final List<Field25> result = new ArrayList<>();
		final Tag[] tags = tags("25");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field25(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 30, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 30 at MT935 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field30 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field30> getField30() {
		final List<Field30> result = new ArrayList<>();
		final Tag[] tags = tags("30");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field30(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 37H, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 37H at MT935 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field37H objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field37H> getField37H() {
		final List<Field37H> result = new ArrayList<>();
		final Tag[] tags = tags("37H");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field37H(tag.getValue()));
            }
		}
		return result;
	}
	



}
