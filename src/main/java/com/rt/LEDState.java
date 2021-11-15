package com.rt;

public enum LEDState {
    OFF{
        @Override
        public LEDState nextState() {
            return ON;
        }
    }, ON{
        @Override
        public LEDState nextState() {
            return FLASH;
        }
    }, FLASH{
        @Override
        public LEDState nextState() {
            return OFF;
        }
    };

    public abstract LEDState nextState();
}
