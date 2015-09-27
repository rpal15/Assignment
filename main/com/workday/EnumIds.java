package com.workday;

import java.util.Enumeration;

/**
 *enum used for the sorted ids from RangeContainer
 *
 */
public class EnumIds implements Ids {

	private Enumeration<Short> idIndexes;

	// enumof Ids

	public EnumIds(Enumeration<Short> idIndexes) {
		this.idIndexes = idIndexes;
	}

	// Provides the list of Ids

	@Override
	public short nextId() {
		if (idIndexes.hasMoreElements())
			return idIndexes.nextElement();
		else
			return END_OF_IDS;
	}
}
