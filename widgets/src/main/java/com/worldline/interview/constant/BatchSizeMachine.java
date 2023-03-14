package com.worldline.interview.constant;

public enum BatchSizeMachine {
    WIDGET(8),
    STEAM(2);

    public int batchSize;

    BatchSizeMachine(int batchSize) {
        this.batchSize = batchSize;
    }

    public int getBatchSize(){
        return batchSize;
    }
}
