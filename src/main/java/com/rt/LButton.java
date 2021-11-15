package com.rt;


public class LButton implements BObservable {

    private String id;
    private BEventBroker broker;

    public LButton(final String id, final BEventBroker broker){
        this.id=id;
        this.broker=broker;
    }

    public void buttonPressed(){
        System.out.println("button " + id + " pressed.");
        final BEvent event = new BEvent(id);
        notifyBroker(event);
    }

    @Override
    public void notifyBroker(BEvent event) {
//        System.out.println("Notifying broker for button " + id);
        broker.update(event);
    }

    @Override
    public String getId() {
        return id;
    }
}
