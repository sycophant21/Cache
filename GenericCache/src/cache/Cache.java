package cache;

import domain.ID;
import domain.Value;

import java.util.List;

public interface Cache {
    public void createIndex(String newBasisOfSegregation);
    public Value get(ID id);
    public List<Value> search(String basisOfSegregation, Object valueOfSegregation);
    public void addToCache(Value value);
    public void deleteFromCache(ID id);
    public void deleteFromCache(String basisOfDeletion, Object valueToBeDeleted);
}

