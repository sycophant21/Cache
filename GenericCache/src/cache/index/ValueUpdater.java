package cache.index;

import domain.Employee;
import domain.Value;
import helper.ReflectionHelper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ValueUpdater {
    private final ReflectionHelper reflectionHelper;

    public ValueUpdater(ReflectionHelper reflectionHelper) {
        this.reflectionHelper = reflectionHelper;
    }

    public void add(Value value, Map<String, Map<Object, List<Value>>> outerMap) {
        try {
            for (String key : outerMap.keySet()) {
                String getter = reflectionHelper.getGetter(key,value.getClass());
                Object object = Employee.class.getDeclaredMethod(getter).invoke(value);
                if (outerMap.get(key).containsKey(object)) {
                    outerMap.get(key).get(object).add(value);
                } else {
                    List<Value> valueList = new ArrayList<>();
                    valueList.add(value);
                    outerMap.get(key).put(object, valueList);
                }
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public void deleteByValue(Value value, Map<String, Map<Object, List<Value>>> outerMap) {
        try {
            for (String key : outerMap.keySet()) {
                String getter = reflectionHelper.getGetter(key,value.getClass());
                Object object = Employee.class.getDeclaredMethod(getter).invoke(value);
                if (outerMap.get(key).containsKey(object)) {
                    outerMap.get(key).get(object).remove(value);
                }
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void deleteByField(String basisOfDeletion, Object valueToBeDeleted , Map<String, Map<Object, List<Value>>> outerMap) {
        try {
            String getter = reflectionHelper.getGetter(basisOfDeletion, outerMap.get(basisOfDeletion.toUpperCase()).get(valueToBeDeleted).get(0).getClass());

            for (String key : outerMap.keySet()) {

                if (!key.equalsIgnoreCase(basisOfDeletion)) {

                    for (Object object : outerMap.get(key).keySet()) {

                        for (Value value : outerMap.get(key).get(object)) {

                            if (value.getClass().getDeclaredMethod(getter).invoke(value).equals(valueToBeDeleted)) {

                                outerMap.get(key).get(object).remove(value);
                            }
                        }
                    }
                }
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
