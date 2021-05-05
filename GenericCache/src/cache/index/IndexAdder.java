package cache.index;

import domain.Value;
import helper.ReflectionHelper;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class IndexAdder {
    private final ReflectionHelper reflectionHelper;
    public IndexAdder(ReflectionHelper reflectionHelper) {
        this.reflectionHelper = reflectionHelper;
    }

    public Map<Object, List<Value>> addIndex(String mapType, Collection<Value> valueCollection) {
        try {
            String getter = reflectionHelper.getGetter(mapType,valueCollection.iterator().next().getClass());
            Map<Object, List<Value>> mapToBeStored = new HashMap<>();
            for (Value value : valueCollection) {

                Object object = value.getClass().getDeclaredMethod(getter).invoke(value);
                if (mapToBeStored.containsKey(object)) {
                    mapToBeStored.get(object).add(value);
                } else {
                    List<Value> values = new ArrayList<>();
                    values.add(value);
                    mapToBeStored.put(object, values);
                }
            }
            return mapToBeStored;
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }




}
