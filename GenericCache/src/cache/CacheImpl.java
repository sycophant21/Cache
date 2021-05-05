package cache;

import cache.index.IndexAdder;
import cache.index.ValueUpdater;
import domain.ID;
import domain.Value;
import helper.ReflectionHelper;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheImpl implements Cache {
    private final Map<String, Map<Object, List<Value>>> outerMap;
    private final Map<ID, Value> idValueMap;
    private final IndexAdder indexAdder;
    private final ValueUpdater valueUpdater;
    private final ReflectionHelper reflectionHelper = new ReflectionHelper();
    public CacheImpl() {
        this.outerMap = new HashMap<>();
        idValueMap = new HashMap<>();
        this.indexAdder = new IndexAdder(reflectionHelper);
        this.valueUpdater = new ValueUpdater(reflectionHelper);
    }

    public void createIndex(String newBasisOfSegregation) {

        outerMap.put(newBasisOfSegregation.toUpperCase(),indexAdder.addIndex(newBasisOfSegregation, idValueMap.values()));

    }
    public Value get(ID id) {
            return idValueMap.get(id);
    }

    public List<Value> search(String basisOfSegregation, Object valueOfSegregation) {
        return outerMap.get(basisOfSegregation.toUpperCase()).get(valueOfSegregation);
    }

    public void addToCache(Value value) {
        idValueMap.put(value.getID(),value);
        if (!outerMap.isEmpty()) {
            valueUpdater.add(value, outerMap);
        }
    }

    public void deleteFromCache(ID id) {
        if (!outerMap.isEmpty()) {
            valueUpdater.deleteByValue(idValueMap.get(id), outerMap);
        }
        idValueMap.remove(id);
    }

    public void deleteFromCache(String basisOfDeletion, Object valueToBeDeleted) {
        try {
            if (outerMap.containsKey(basisOfDeletion.toUpperCase())) {
                valueUpdater.deleteByField(basisOfDeletion,valueToBeDeleted,outerMap);
                outerMap.get(basisOfDeletion.toUpperCase()).remove(valueToBeDeleted);
            }
            for (ID id : idValueMap.keySet() ) {
                Value value = idValueMap.get(id);
                String getter = reflectionHelper.getGetter(basisOfDeletion,value.getClass());
                if (value.getClass().getDeclaredMethod(getter).invoke(value).equals(valueToBeDeleted)) {
                    idValueMap.remove(id);
                }
            }
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
