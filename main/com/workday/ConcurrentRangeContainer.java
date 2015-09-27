package com.workday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentRangeContainer implements RangeContainer {

	/*
	 * ConcurrentSkipListMap is used for storing key and value based data. The
	 * concurrentskiplistmap has methods to retrieve the keyset which is
	 * navigable and provides methods for headmap, tailmap and submap.
	 * 
	 * ConcurrentSkipListMap can be used for scalable concurrent navigable maps.
	 * 

	 * O(log(n))
	 */
	 private ConcurrentSkipListMap<Long, Short> indexIds = new ConcurrentSkipListMap<Long, Short>();

	public ConcurrentRangeContainer(long[] data) {
		for (short i = 0; i < data.length; i++) {
			indexIds.put(data[i], i);

		}
	}

	@Override
	public Ids findIdsInRange(long fromValue, long toValue,	boolean fromInclusive, boolean toInclusive) {

		ConcurrentNavigableMap<Long, Short>idsRange = indexIds.subMap(fromValue, fromInclusive, toValue, toInclusive);
		List<Short> idsList = new ArrayList<>(idsRange.values());
		Collections.sort(idsList);
		Ids ids = new EnumIds(Collections.enumeration(idsList));
		return ids;

	}

}
