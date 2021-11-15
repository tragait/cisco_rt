package com.rt;

public class BEvent {
    private String buttonId;
    private String buttonAction;

    public BEvent(final String buttonId){
        this.buttonId = buttonId;
    }

    public String getButtonId(){
        return buttonId;
    }

    public String getButtonAction() {
        return buttonAction;
    }

    public void setButtonAction(final String buttonAction) {
        this.buttonAction = buttonAction;
    }
}
