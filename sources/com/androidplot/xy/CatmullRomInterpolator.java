package com.androidplot.xy;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class CatmullRomInterpolator implements Interpolator<Params> {

    /* loaded from: classes3.dex */
    public enum Type {
        Uniform,
        Centripetal
    }

    /* loaded from: classes3.dex */
    public static class Params implements InterpolationParams {
        private int pointPerSegment;
        private Type type;

        public Params(int i, Type type) {
            this.pointPerSegment = i;
            this.type = type;
        }

        @Override // com.androidplot.xy.InterpolationParams
        public Class<CatmullRomInterpolator> getInterpolatorClass() {
            return CatmullRomInterpolator.class;
        }

        public int getPointPerSegment() {
            return this.pointPerSegment;
        }

        public void setPointPerSegment(int i) {
            this.pointPerSegment = i;
        }

        public Type getType() {
            return this.type;
        }

        public void setType(Type type) {
            this.type = type;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ExtrapolatedXYSeries implements XYSeries {
        private final XYCoords first;
        private final XYCoords last;
        private final XYSeries series;

        public ExtrapolatedXYSeries(XYSeries xYSeries, XYCoords xYCoords, XYCoords xYCoords2) {
            this.series = xYSeries;
            this.first = xYCoords;
            this.last = xYCoords2;
        }

        @Override // com.androidplot.xy.XYSeries
        public Number getX(int i) {
            if (i == 0) {
                return this.first.x;
            }
            if (i == this.series.size() + 1) {
                return this.last.x;
            }
            return this.series.getX(i - 1);
        }

        @Override // com.androidplot.xy.XYSeries
        public Number getY(int i) {
            if (i == 0) {
                return this.first.y;
            }
            if (i == this.series.size() + 1) {
                return this.last.y;
            }
            return this.series.getY(i - 1);
        }

        @Override // com.androidplot.xy.XYSeries
        public int size() {
            return this.series.size() + 2;
        }

        @Override // com.androidplot.Series
        public String getTitle() {
            return this.series.getTitle();
        }
    }

    @Override // com.androidplot.xy.Interpolator
    public List<XYCoords> interpolate(XYSeries xYSeries, Params params) {
        if (params.getPointPerSegment() < 2) {
            throw new IllegalArgumentException("pointsPerSegment must be greater than 2, since 2 points is just the linear segment.");
        }
        if (xYSeries.size() < 3) {
            throw new IllegalArgumentException("Cannot interpolate a series with fewer than 3 vertices.");
        }
        XYCoords xYCoords = new XYCoords(Double.valueOf(xYSeries.getX(0).doubleValue() - (xYSeries.getX(1).doubleValue() - xYSeries.getX(0).doubleValue())), Double.valueOf(xYSeries.getY(0).doubleValue() - (xYSeries.getY(1).doubleValue() - xYSeries.getY(0).doubleValue())));
        int size = xYSeries.size();
        int i = size - 1;
        int i2 = size - 2;
        ExtrapolatedXYSeries extrapolatedXYSeries = new ExtrapolatedXYSeries(xYSeries, xYCoords, new XYCoords(Double.valueOf(xYSeries.getX(i).doubleValue() + (xYSeries.getX(i).doubleValue() - xYSeries.getX(i2).doubleValue())), Double.valueOf(xYSeries.getY(i).doubleValue() + (xYSeries.getY(i).doubleValue() - xYSeries.getY(i2).doubleValue()))));
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < extrapolatedXYSeries.size() - 3; i3++) {
            List<XYCoords> interpolate = interpolate(extrapolatedXYSeries, i3, params);
            if (arrayList.size() > 0) {
                interpolate.remove(0);
            }
            arrayList.addAll(interpolate);
        }
        return arrayList;
    }

    protected List<XYCoords> interpolate(XYSeries xYSeries, int i, Params params) {
        double d;
        double d2;
        double pow;
        ArrayList arrayList = new ArrayList();
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        double[] dArr3 = new double[4];
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i + i2;
            dArr[i2] = xYSeries.getX(i3).doubleValue();
            dArr2[i2] = xYSeries.getY(i3).doubleValue();
            dArr3[i2] = i2;
        }
        char c = 2;
        int i4 = 1;
        if (params.getType() != Type.Uniform) {
            double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            int i5 = 1;
            for (int i6 = 4; i5 < i6; i6 = 4) {
                int i7 = i5 - 1;
                double d4 = dArr[i5] - dArr[i7];
                double d5 = dArr2[i5] - dArr2[i7];
                if (params.getType() == Type.Centripetal) {
                    pow = Math.pow((d4 * d4) + (d5 * d5), 0.25d);
                } else {
                    pow = Math.pow((d4 * d4) + (d5 * d5), 0.5d);
                }
                d3 += pow;
                dArr3[i5] = d3;
                i5++;
            }
            d = dArr3[1];
            d2 = dArr3[2];
        } else {
            d = 1.0d;
            d2 = 2.0d;
        }
        int pointPerSegment = params.getPointPerSegment() - 1;
        int i8 = i + 1;
        arrayList.add(new XYCoords(xYSeries.getX(i8), xYSeries.getY(i8)));
        while (i4 < pointPerSegment) {
            double d6 = ((i4 * (d2 - d)) / pointPerSegment) + d;
            arrayList.add(new XYCoords(Double.valueOf(interpolate(dArr, dArr3, d6)), Double.valueOf(interpolate(dArr2, dArr3, d6))));
            i4++;
            c = c;
        }
        int i9 = i + 2;
        arrayList.add(new XYCoords(xYSeries.getX(i9), xYSeries.getY(i9)));
        return arrayList;
    }

    protected static double interpolate(double[] dArr, double[] dArr2, double d) {
        double d2 = dArr[0];
        double d3 = dArr2[1];
        double d4 = dArr2[0];
        double d5 = dArr[1];
        double d6 = ((d2 * (d3 - d)) / (d3 - d4)) + (((d - d4) * d5) / (d3 - d4));
        double d7 = dArr2[2];
        double d8 = dArr[2];
        double d9 = ((d5 * (d7 - d)) / (d7 - d3)) + (((d - d3) * d8) / (d7 - d3));
        double d10 = dArr2[3];
        return (((((d6 * (d7 - d)) / (d7 - d4)) + (((d - d4) * d9) / (d7 - d4))) * (d7 - d)) / (d7 - d3)) + (((((d9 * (d10 - d)) / (d10 - d3)) + (((((d8 * (d10 - d)) / (d10 - d7)) + ((dArr[3] * (d - d7)) / (d10 - d7))) * (d - d3)) / (d10 - d3))) * (d - d3)) / (d7 - d3));
    }
}
