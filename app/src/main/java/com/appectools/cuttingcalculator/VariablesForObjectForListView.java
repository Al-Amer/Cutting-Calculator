package com.appectools.cuttingcalculator;

import java.io.Serializable;

public class VariablesForObjectForListView implements Serializable {
    private int shapeImage;

    public VariablesForObjectForListView(int shapeImage){
        this.shapeImage=shapeImage;

    }

    public int getShapeImage() {
        return shapeImage;
    }

    public void setShapeImage(int shapeImage) {
        this.shapeImage = shapeImage;
    }
}
