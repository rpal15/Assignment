package com.workday;

public class RangeContainerFactoryImpl implements RangeContainerFactory  {
	
	
	    @Override
	    public RangeContainer createContainer(long[] data) {
	        return new ConcurrentRangeContainer(data);
	    }

}
