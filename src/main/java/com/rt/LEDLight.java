package com.rt;

public class LEDLight implements LEDDriver, BObserver{

    private String id;

    public void setCurrentState(LEDState currentState) {
        this.currentState = currentState;
    }

    public void setCurrentColor(LEDColor currentColor) {
        this.currentColor = currentColor;
    }

    private LEDState currentState;
    private LEDColor currentColor;
    public LEDLight(final String id){
        this.id = id;
        currentState = LEDState.OFF;
        currentColor = LEDColor.RED;
    }

    @Override
    public void redOn() {
        currentState = LEDState.ON;
        currentColor = LEDColor.RED;
        System.out.println(this.id + " LED is RED_ON");
    }

    @Override
    public void redFlash() {
        currentState = LEDState.FLASH;
        currentColor = LEDColor.RED;
        System.out.println(this.id + " LED is RED_FLASH");
    }

    @Override
    public void ledOff() {
        currentState = LEDState.OFF;
        currentColor = LEDColor.RED;
        System.out.println(this.id + " LED is OFF");
    }

    @Override
    public void whiteOn() {
        currentState = LEDState.ON;
        currentColor = LEDColor.WHITE;
        System.out.println(this.id + " LED is WHITE_ON");
    }

    @Override
    public void whiteFlash() {
        currentState = LEDState.FLASH;
        currentColor = LEDColor.WHITE;
        System.out.println(this.id + " LED is WHITE_FLASH");
    }

    public LEDState getCurrentState(){
        return currentState;
    }

    public LEDColor getCurrentColor(){
        return currentColor ;
    }

    public void ledCurrentStateColor(){
        if(currentState == LEDState.OFF)
            System.out.println("LED " + currentState);
        else
            System.out.println("LED " + currentColor + "_" + currentState);
    }
    @Override
    public void onEvent(final BEvent event) {
        final String bId = event.getButtonId();

        final LEDState state = this.getCurrentState();
        final LEDColor color = this.getCurrentColor();
        switch (bId){
            case "1":
                // we are assuming that button only have one event "pressed" so not checking button action
                if(state == LEDState.OFF)
                    this.setCurrentColor(LEDColor.RED);
                this.setCurrentState(state.nextState());
                break;
            case "2":
                if(state != LEDState.OFF)  // if state is OFF then do nothing else toggle
                    this.setCurrentColor(color.nextColor());
                break;
            default:
                System.out.println(bId+" does not have any handling.");
        }
        ledCurrentStateColor();
    }
}
