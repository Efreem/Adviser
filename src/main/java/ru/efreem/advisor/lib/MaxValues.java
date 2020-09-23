package ru.efreem.advisor.lib;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class MaxValues {

    public static <T,V> boolean isIn(T object, Collection<T> collectionOfObjects) {

        for (T elem : collectionOfObjects) {
            if (elem.equals(object)) {
                return true;
            }
        }

        return false;
    }

    public static <T> T getMaxValueFromMap(Map<T,Long> map, List<T> ignoreList) {
        List<T> keys = new ArrayList<>();
        keys.addAll(map.keySet());

        T temp = keys.get(0);

        for (T elem : keys) {

            if (isIn(elem, ignoreList)) {
                continue;
            }
            if (map.get(elem) > map.get(temp)) {
                temp = elem;
            }
        }

        return temp;
    }

    public static <T> List<T> getSortedListByMax(Map<T,Long> map) {
        List<T> result = new ArrayList<>();
        List<T> ignoreList = new ArrayList();
        Set<T> keySet = map.keySet();

        for (T elem : keySet) {
            result.add(getMaxValueFromMap(map, ignoreList));
            ignoreList.add(getMaxValueFromMap(map, ignoreList));
        }

        return result;
    }
}
