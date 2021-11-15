package com.rt;

public interface BObservable {
    void notifyBroker(BEvent event);
    String getId();
}
