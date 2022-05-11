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
package com.prowidesoftware.swift.model.mt.mt2xx;



import com.prowidesoftware.Generated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.internal.*;
import com.prowidesoftware.swift.internal.SequenceStyle.Type;
import com.prowidesoftware.swift.model.field.*;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import com.prowidesoftware.swift.utils.Lib;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;

/**
 * MT 204 - Financial Markets Direct Debit Message.
 *
 * <p>
 * SWIFT MT204 (ISO 15022) message structure:
 *
 <div class="scheme"><ul>
<li class="sequence">
Sequence A (M)<ul><li class="field">Field 20  (M)</li>
<li class="field">Field 19  (M)</li>
<li class="field">Field 30  (M)</li>
<li class="field">Field 57 A,B,D (O)</li>
<li class="field">Field 58 A,D (O)</li>
<li class="field">Field 72  (O)</li>
</ul></li>
<li class="sequence">
Sequence B (M) (repetitive)<ul><li class="field">Field 20  (M)</li>
<li class="field">Field 21  (O)</li>
<li class="field">Field 32 B (M)</li>
<li class="field">Field 53 A,B,D (M)</li>
<li class="field">Field 72  (O)</li>
</ul></li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2022</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT204 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2022;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT204.class.getName());
	
	/**
	 * Constant for MT name, this is part of the classname, after MT.
	 */
	public static final String NAME = "204";

	/**
	 * Creates an MT204 initialized with the parameter SwiftMessage.
	 * @param m swift message with the MT204 content
	 */
	public MT204(final SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT204 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT204 content, the parameter can not be null
	 * @see #MT204(String)
	 */
	public MT204(final MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT204 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT204 content
	 * @return the created object or null if the parameter is null
	 * @see #MT204(String)
	 * @since 7.7
	 */
	public static MT204 parse(final MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT204(m);
	}
	
	/**
	 * Creates and initializes a new MT204 input message setting TEST BICS as sender and receiver.
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT204() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT204 input message from sender to receiver.
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT204(final String sender, final String receiver) {
		super(204, sender, receiver);
	}
	
	/**
	 * Creates a new MT204 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT204(final String fin) {
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
			log.warning("Creating an MT204 object from FIN content with a Service Message. Check if the MT204 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), "204")) {
			log.warning("Creating an MT204 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT204 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter cannot be parsed, the returned MT204 will have its internal message object
	 * initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT204 or null if fin is null 
	 * @since 7.7
	 */
	public static MT204 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT204(fin);
    }
    
    /**
	 * Creates a new MT204 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT204(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT204 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT204 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT204 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT204(stream);
    }
    
    /**
	 * Creates a new MT204 by parsing a file with the message content in its swift FIN format.
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT204(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT204 by parsing a file with the message content in its swift FIN format.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT204 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT204 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT204(file);
    }
    
	/**
	 * Returns this MT number.
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "204";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT204 append(final SwiftTagListBlock block) {
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
	public MT204 append(final Tag... tags) {
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
	public MT204 append(final Field... fields) {
		super.append(fields);
		return this;
	}

   /**
	* Creates an MT204 messages from its JSON representation.
	* <p>
	* For generic conversion of JSON into the corresponding MT instance
	* see {@link AbstractMT#fromJson(String)}
	*
	* @param json a JSON representation of an MT204 message
	* @return a new instance of MT204
	* @since 7.10.3
	*/
	public static MT204 fromJson(final String json) {
		return (MT204) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 19, 
	 * or null if none is found.
	 * The first occurrence of field 19 at MT204 is expected to be the only one.
	 * 
	 * @return a Field19 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field19 getField19() {
		final Tag t = tag("19");
		if (t != null) {
			return new Field19(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30, 
	 * or null if none is found.
	 * The first occurrence of field 30 at MT204 is expected to be the only one.
	 * 
	 * @return a Field30 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30 getField30() {
		final Tag t = tag("30");
		if (t != null) {
			return new Field30(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 57A, 
	 * or null if none is found.
	 * The first occurrence of field 57A at MT204 is expected to be the only one.
	 * 
	 * @return a Field57A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field57A getField57A() {
		final Tag t = tag("57A");
		if (t != null) {
			return new Field57A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 57B, 
	 * or null if none is found.
	 * The first occurrence of field 57B at MT204 is expected to be the only one.
	 * 
	 * @return a Field57B object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field57B getField57B() {
		final Tag t = tag("57B");
		if (t != null) {
			return new Field57B(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 57D, 
	 * or null if none is found.
	 * The first occurrence of field 57D at MT204 is expected to be the only one.
	 * 
	 * @return a Field57D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field57D getField57D() {
		final Tag t = tag("57D");
		if (t != null) {
			return new Field57D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 58A, 
	 * or null if none is found.
	 * The first occurrence of field 58A at MT204 is expected to be the only one.
	 * 
	 * @return a Field58A object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field58A getField58A() {
		final Tag t = tag("58A");
		if (t != null) {
			return new Field58A(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 58D, 
	 * or null if none is found.
	 * The first occurrence of field 58D at MT204 is expected to be the only one.
	 * 
	 * @return a Field58D object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field58D getField58D() {
		final Tag t = tag("58D");
		if (t != null) {
			return new Field58D(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 20, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 20 at MT204 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field20 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field20> getField20() {
		final List<Field20> result = new ArrayList<>();
		final Tag[] tags = tags("20");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field20(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 21, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 21 at MT204 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field21 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field21> getField21() {
		final List<Field21> result = new ArrayList<>();
		final Tag[] tags = tags("21");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field21(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32B, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 32B at MT204 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field32B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field32B> getField32B() {
		final List<Field32B> result = new ArrayList<>();
		final Tag[] tags = tags("32B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field32B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 53A, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 53A at MT204 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field53A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field53A> getField53A() {
		final List<Field53A> result = new ArrayList<>();
		final Tag[] tags = tags("53A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field53A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 53B, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 53B at MT204 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field53B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field53B> getField53B() {
		final List<Field53B> result = new ArrayList<>();
		final Tag[] tags = tags("53B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field53B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 53D, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 53D at MT204 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field53D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field53D> getField53D() {
		final List<Field53D> result = new ArrayList<>();
		final Tag[] tags = tags("53D");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field53D(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 72, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 72 at MT204 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field72 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field72> getField72() {
		final List<Field72> result = new ArrayList<>();
		final Tag[] tags = tags("72");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field72(tag.getValue()));
            }
		}
		return result;
	}
	

	/**
	 * Class to model Sequence "A" in MT 204.
	 */
	public static class SequenceA extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
		 */
	    private SequenceA() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceA(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * First mandatory tag name of the sequence: <em>"20"  </em>.
		 * Array format is for cases when more than one letter options is allowed
		 */
		public static final String[] START = { "20"   } ;

		/**
		 * Last mandatory tag name of the sequence: <em>"30"  </em>
		 * Array format is for cases when more than one letter options is allowed
		 */
		protected static final String[] END = { "30"   };

		/**
		 * List of optional tags after the last mandatory tag.
		 */
		protected static final String[] TAIL = new String[]{ "57A", "57B", "57D", "58A", "58D", "72"   };

		/**
		 * Same as {@link #newInstance(int, int, Tag...)} using zero for the indexes.
		 * @param tags the list of tags to set as sequence content
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceA newInstance(final Tag... tags) {
			return newInstance(0, 0, tags);
		}

		/**
		 * Creates a sequence with starting and ending tags set to the indicated tags in from the
		 * {@link #START} and {@link #END} lists of mandatory fields, and with the content between
		 * the starting and ending tag initialized with the given optional tags.
		 *
		 * @param start a zero-based index within the list of mandatory starting tags in the sequence
		 * @param end a zero-based index within the list of mandatory ending tags in the sequence
		 * @param tags the list of tags to set as sequence content
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceA newInstance(final int start, final int end, final Tag... tags) {
			final SequenceA result = new SequenceA();
			result.append(new Tag(START[start], ""));
			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}
			result.append(new Tag(END[end], ""));
			return result;
		}
	}
	/**
	 * Get the single occurrence of SequenceA delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * If block 4 is empty this method returns null.
	 *
	 * @return the found sequence or an empty sequence if none is found
	 * @see SwiftTagListBlock#getSubBlockDelimitedWithOptionalTail(String[], String[], String[])
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public SequenceA getSequenceA() {
		return getSequenceA(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the single occurrence of SequenceA delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur only once according to the Standard.
	 * If block 4 is empty this method returns null.
	 *
	 * @see SwiftTagListBlock#getSubBlockDelimitedWithOptionalTail(String[], String[], String[])
	 * @param parentSequence a not null parent sequence to find SequenceA within it
	 * @return the found sequence or an empty sequence if none is found, or null if the parent sequence is null or empty
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public SequenceA getSequenceA(SwiftTagListBlock parentSequence) {
		if (parentSequence != null && !parentSequence.isEmpty()) {
			final SwiftTagListBlock content = parentSequence.getSubBlockDelimitedWithOptionalTail(SequenceA.START, SequenceA.END, SequenceA.TAIL);
			if (log.isLoggable(java.util.logging.Level.FINE)) {
				if (content == null) {
					log.fine("content for sequence SequenceA: is null");
				} else {
					log.fine("content for sequence SequenceA: "+content.tagNamesList());
				}
			}
			if (content == null) {
				return new SequenceA();
			} else {
				return new SequenceA(content);
			}
		}
		return null;
	}
 

	/**
	 * Class to model Sequence "B" in MT 204.
	 */
	public static class SequenceB extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
		 */
	    private SequenceB() {
			super(new ArrayList<Tag>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private SequenceB(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * First mandatory tag name of the sequence: <em>"20"  </em>.
		 * Array format is for cases when more than one letter options is allowed
		 */
		public static final String[] START = { "20"   } ;

		/**
		 * Last mandatory tag name of the sequence: <em>"53A", "53B", "53D"  </em>
		 * Array format is for cases when more than one letter options is allowed
		 */
		protected static final String[] END = { "53A", "53B", "53D"   };

		/**
		 * List of optional tags after the last mandatory tag.
		 */
		protected static final String[] TAIL = new String[]{ "72"   };

		/**
		 * Same as {@link #newInstance(int, int, Tag...)} using zero for the indexes.
		 * @param tags the list of tags to set as sequence content
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceB newInstance(final Tag... tags) {
			return newInstance(0, 0, tags);
		}

		/**
		 * Creates a sequence with starting and ending tags set to the indicated tags in from the
		 * {@link #START} and {@link #END} lists of mandatory fields, and with the content between
		 * the starting and ending tag initialized with the given optional tags.
		 *
		 * @param start a zero-based index within the list of mandatory starting tags in the sequence
		 * @param end a zero-based index within the list of mandatory ending tags in the sequence
		 * @param tags the list of tags to set as sequence content
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static SequenceB newInstance(final int start, final int end, final Tag... tags) {
			final SequenceB result = new SequenceB();
			result.append(new Tag(START[start], ""));
			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}
			result.append(new Tag(END[end], ""));
			return result;
		}
	}
	/**
	 * Get the list of SequenceB delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @return the found sequences or an empty list if none is found
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<SequenceB> getSequenceBList() {
		return getSequenceBList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the list of SequenceB delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 * @param parentSequence a not null parent sequence to find SequenceB within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<SequenceB> getSequenceBList(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocksDelimitedWithOptionalTail(SequenceB.START, SequenceB.END, SequenceB.TAIL);
            if (blocks != null && !blocks.isEmpty()) {
                final List<SequenceB> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    result.add(new SequenceB(b));
                }
                return result;
            }
        }
        return Collections.emptyList();
	}
 



}
