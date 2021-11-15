package com.rt;

public enum LEDColor {
    RED{
        @Override
        public LEDColor nextColor() {
            return WHITE;
        }
    }, WHITE{
        @Override
        public LEDColor nextColor() {
            return RED;
        }
    };

    public abstract LEDColor nextColor();
}
