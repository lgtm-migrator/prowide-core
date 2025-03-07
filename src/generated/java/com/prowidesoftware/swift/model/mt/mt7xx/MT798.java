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
package com.prowidesoftware.swift.model.mt.mt7xx;



import com.prowidesoftware.Generated;
import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.model.field.*;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import com.prowidesoftware.swift.utils.Lib;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;

/**
 * MT 798 - Proprietary Message.
 *
 * <p>
 * SWIFT MT798 (ISO 15022) message structure:
 *
 <div class="scheme"><ul>
<li class="field">Field 20  (M)</li>
<li class="field">Field 12  (M)</li>
<li class="field">Field 77 E (M)</li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2021</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT798 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;
	private static final long serialVersionUID = 1L;
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT798.class.getName());
	
	/**
	 * Constant for MT name, this is part of the classname, after MT.
	 */
	public static final String NAME = "798";

	/**
	 * Creates an MT798 initialized with the parameter SwiftMessage.
	 * @param m swift message with the MT798 content
	 */
	public MT798(final SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT798 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT798 content, the parameter can not be null
	 * @see #MT798(String)
	 */
	public MT798(final MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT798 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT798 content
	 * @return the created object or null if the parameter is null
	 * @see #MT798(String)
	 * @since 7.7
	 */
	public static MT798 parse(final MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT798(m);
	}
	
	/**
	 * Creates and initializes a new MT798 input message setting TEST BICS as sender and receiver.
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT798() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT798 input message from sender to receiver.
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT798(final String sender, final String receiver) {
		super(798, sender, receiver);
	}
	
	/**
	 * Creates a new MT798 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT798(final String fin) {
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
			log.warning("Creating an MT798 object from FIN content with a Service Message. Check if the MT798 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), "798")) {
			log.warning("Creating an MT798 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT798 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter cannot be parsed, the returned MT798 will have its internal message object
	 * initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT798 or null if fin is null 
	 * @since 7.7
	 */
	public static MT798 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT798(fin);
    }
    
    /**
	 * Creates a new MT798 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT798(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT798 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT798 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT798 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT798(stream);
    }
    
    /**
	 * Creates a new MT798 by parsing a file with the message content in its swift FIN format.
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT798(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT798 by parsing a file with the message content in its swift FIN format.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT798 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT798 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT798(file);
    }
    
	/**
	 * Returns this MT number.
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "798";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT798 append(final SwiftTagListBlock block) {
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
	public MT798 append(final Tag... tags) {
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
	public MT798 append(final Field... fields) {
		super.append(fields);
		return this;
	}

   /**
	* Creates an MT798 messages from its JSON representation.
	* <p>
	* For generic conversion of JSON into the corresponding MT instance
	* see {@link AbstractMT#fromJson(String)}
	*
	* @param json a JSON representation of an MT798 message
	* @return a new instance of MT798
	* @since 7.10.3
	*/
	public static MT798 fromJson(final String json) {
		return (MT798) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or null if none is found.
	 * The first occurrence of field 20 at MT798 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 12, 
	 * or null if none is found.
	 * The first occurrence of field 12 at MT798 is expected to be the only one.
	 * 
	 * @return a Field12 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field12 getField12() {
		final Tag t = tag("12");
		if (t != null) {
			return new Field12(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 77E, 
	 * or null if none is found.
	 * The first occurrence of field 77E at MT798 is expected to be the only one.
	 * 
	 * @return a Field77E object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field77E getField77E() {
		final Tag t = tag("77E");
		if (t != null) {
			return new Field77E(t.getValue());
		} else {
			return null;
		}
	}
	


	/**
	 * Creates a new messages with the content of the enclosed sub-message type.
	 *
	 * The headers are a clone to the actual envelop MT798 headers, changing the message type in block 2 with the
	 * value of field 12 in the envelop. The block4 will contain all fields following 77E in the envelop (including
	 * for example the message index in 27A and customer reference in 21P when present).
	 *
	 * Notice the return type is a {@link SwiftMessage} since this model has a very lenient structure. If the sub-message
	 * type is a well-formed and known MT you can further transform it into a specific MT object with the
	 * {@link SwiftMessage#toMT()} method.
	 *
 	 * @return a model containing the fields from the enclosed sub message
	 * @since 9.2.11
	 */
	public SwiftMessage getSubMessage() {
		Field12 field12 = getField12();
		if (field12 == null) {
			return null;
		}
		SwiftMessage result = new SwiftMessage(true);

		if (this.m.getBlock1() != null) {
			result.getBlock1().setValue(this.m.getBlock1().getValue());
		}

		if (this.m.getBlock2() != null) {
			if (this.m.isInput()) {
				SwiftBlock2Input currentBlock2 = (SwiftBlock2Input) this.m.getBlock2();
				SwiftBlock2Input newBlock2 = new SwiftBlock2Input(currentBlock2.getValue());
				newBlock2.setMessageType(field12.getValue());
				result.setBlock2(newBlock2);
			} else {
				SwiftBlock2Output currentBlock2 = (SwiftBlock2Output) this.m.getBlock2();
				SwiftBlock2Output newBlock2 = new SwiftBlock2Output(currentBlock2.getValue());
				newBlock2.setMessageType(field12.getValue());
				result.setBlock2(newBlock2);
			}
		}

		if (this.m.getBlock3() != null) {
			for (Tag tag : this.m.getBlock3().getTags()) {
				result.getBlock3().append(new Tag(tag));
			}
		}

		if (this.m.getBlock4() != null) {
			boolean found77E = false;
			for (Tag tag : this.m.getBlock4().getTags()) {
				if (found77E) {
					result.getBlock4().append(new Tag(tag));
				}
				if (Field77E.NAME.equals(tag.getName())) {
					found77E = true;
				}
			}
		}

		return result;
	}
}
