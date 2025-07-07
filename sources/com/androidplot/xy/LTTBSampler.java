package com.androidplot.xy;

import android.util.Log;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* loaded from: classes3.dex */
public class LTTBSampler implements Sampler {
    @Override // com.androidplot.xy.Sampler
    public RectRegion run(XYSeries xYSeries, EditableXYSeries editableXYSeries) {
        RectRegion rectRegion = new RectRegion();
        int size = editableXYSeries.size();
        int size2 = xYSeries.size();
        if (size >= size2 || size == 0) {
            throw new RuntimeException("Shouldnt be here!");
        }
        int i = size - 2;
        double d = (size2 - 2) / i;
        setSample(xYSeries, editableXYSeries, 0, 0, rectRegion);
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (true) {
            int i5 = i3;
            if (i2 < i) {
                int i6 = i2 + 1;
                double d2 = i6 * d;
                int floor = ((int) Math.floor(d2)) + 1;
                int floor2 = ((int) Math.floor((i2 + 2) * d)) + 1;
                if (floor2 >= size2) {
                    floor2 = size2;
                }
                int i7 = floor2 - floor;
                double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                double d4 = 0.0d;
                while (floor < floor2) {
                    if (xYSeries.getX(floor) != null) {
                        d3 += xYSeries.getX(floor).doubleValue();
                    }
                    if (xYSeries.getY(floor) != null) {
                        d4 += xYSeries.getY(floor).doubleValue();
                    }
                    floor++;
                }
                double d5 = i7;
                double d6 = d3 / d5;
                double d7 = d4 / d5;
                double doubleValue = xYSeries.getX(i3).doubleValue();
                double doubleValue2 = xYSeries.getY(i3).doubleValue();
                int floor3 = ((int) Math.floor(d2)) + 1;
                XYCoords xYCoords = null;
                double d8 = -1.0d;
                int i8 = i5;
                for (int floor4 = ((int) Math.floor(i2 * d)) + 1; floor4 < floor3; floor4++) {
                    double abs = Math.abs(((doubleValue - d6) * (xYSeries.getY(floor4).doubleValue() - doubleValue2)) - ((doubleValue - xYSeries.getX(floor4).doubleValue()) * (d7 - doubleValue2))) * 0.5d;
                    if (abs > d8) {
                        if (xYSeries.getY(floor4) == null) {
                            Log.i("LTTB", "Null value encountered in raw data at index: " + floor4);
                        }
                        i8 = floor4;
                        xYCoords = new XYCoords(xYSeries.getX(floor4), xYSeries.getY(floor4));
                        d8 = abs;
                    }
                }
                setSample(editableXYSeries, xYCoords.x, xYCoords.y, i4, rectRegion);
                i4++;
                i3 = i8;
                i2 = i6;
            } else {
                setSample(xYSeries, editableXYSeries, size2 - 1, i4, rectRegion);
                return rectRegion;
            }
        }
    }

    protected void setSample(XYSeries xYSeries, EditableXYSeries editableXYSeries, int i, int i2, RectRegion rectRegion) {
        setSample(editableXYSeries, xYSeries.getX(i), xYSeries.getY(i), i2, rectRegion);
    }

    protected void setSample(EditableXYSeries editableXYSeries, Number number, Number number2, int i, RectRegion rectRegion) {
        rectRegion.union(number, number2);
        editableXYSeries.setX(number, i);
        editableXYSeries.setY(number2, i);
    }
}
