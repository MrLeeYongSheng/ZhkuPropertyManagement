package com.lys.zhku.utils;

import java.util.Collection;

public class CollectionUtils {

	public static boolean isEmpty(Object[] array) {
		return (array==null || array.length==0);
	}

	public static boolean isEmpty(Collection collection) {
		return (collection==null || collection.size()==0);
	}
}
