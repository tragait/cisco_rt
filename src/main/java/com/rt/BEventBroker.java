package com.rt;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BEventBroker {

    Map<BObservable, Set<BObserver>> bObservableMap = new HashMap<>();

    public void register(BObservable bObservable, Set<BObserver> bObserverSet){
        if(bObservableMap.containsKey(bObservable)){
            bObserverSet.addAll(bObservableMap.get(bObservable));
        }
        bObservableMap.put(bObservable, bObserverSet);
    }

    public void update(BEvent event){
        for(Map.Entry<BObservable, Set<BObserver>> entry: bObservableMap.entrySet()){
            if(event.getButtonId().equals(entry.getKey().getId())){
                entry.getValue().stream().forEach(x -> x.onEvent(event));
            }
        }
    }
}
