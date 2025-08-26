package com.lin.booking.util.common;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapperUtil {
	
	 public static <T, R> List<R> mapList(List<T> sourceList, Function<T, R> mapper) {
	        return (sourceList == null || sourceList.isEmpty())
	                ? Collections.emptyList()
	                : sourceList.stream().map(mapper).collect(Collectors.toList());
	    }

}
