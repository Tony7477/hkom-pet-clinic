package hkom.springframework.hkompetclinic.services.map;



import hkom.springframework.hkompetclinic.model.BaseEnitity;
import net.bytebuddy.dynamic.scaffold.TypeInitializer;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEnitity,ID extends Long> {
    protected Map<Long,T>map=new HashMap<>();
    Set<T> findAll(){
        return new HashSet<>(map.values());
    }
    T findById(ID id){
        return map.get(id);
    }
    T save(ID id,T object){
        if (object!=null){
            if(object.getId()==null){
                object.setId(getNextID());
            }
            map.put(id,object);
        }else{
            throw new RuntimeException("object is null man please look into it inialize with somwhing ");
        }

        return object;
    }
    void deleteById(ID id){
map.remove(id);
    }
    void delete(T object){
        map.entrySet().removeIf(entry->entry.getValue().equals(object));
    }
     Long getNextID(){
        Long next= null;
        try {
            next=Collections.max(map.keySet()) + 1;

        }catch(NoSuchElementException e){
            next=1L;



        }
        return next;
    }
}

