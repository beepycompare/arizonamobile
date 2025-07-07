package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class PairedStatsAccumulator {
    private final StatsAccumulator xStats = new StatsAccumulator();
    private final StatsAccumulator yStats = new StatsAccumulator();
    private double sumOfProductsOfDeltas = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;

    private double ensurePositive(double value) {
        if (value > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return value;
        }
        return Double.MIN_VALUE;
    }

    public void add(double x, double y) {
        this.xStats.add(x);
        if (Doubles.isFinite(x) && Doubles.isFinite(y)) {
            if (this.xStats.count() > 1) {
                this.sumOfProductsOfDeltas += (x - this.xStats.mean()) * (y - this.yStats.mean());
            }
        } else {
            this.sumOfProductsOfDeltas = Double.NaN;
        }
        this.yStats.add(y);
    }

    public void addAll(PairedStats values) {
        if (values.count() == 0) {
            return;
        }
        this.xStats.addAll(values.xStats());
        if (this.yStats.count() == 0) {
            this.sumOfProductsOfDeltas = values.sumOfProductsOfDeltas();
        } else {
            this.sumOfProductsOfDeltas += values.sumOfProductsOfDeltas() + ((values.xStats().mean() - this.xStats.mean()) * (values.yStats().mean() - this.yStats.mean()) * values.count());
        }
        this.yStats.addAll(values.yStats());
    }

    public PairedStats snapshot() {
        return new PairedStats(this.xStats.snapshot(), this.yStats.snapshot(), this.sumOfProductsOfDeltas);
    }

    public long count() {
        return this.xStats.count();
    }

    public Stats xStats() {
        return this.xStats.snapshot();
    }

    public Stats yStats() {
        return this.yStats.snapshot();
    }

    public double populationCovariance() {
        Preconditions.checkState(count() != 0);
        return this.sumOfProductsOfDeltas / count();
    }

    public final double sampleCovariance() {
        Preconditions.checkState(count() > 1);
        return this.sumOfProductsOfDeltas / (count() - 1);
    }

    public final double pearsonsCorrelationCoefficient() {
        Preconditions.checkState(count() > 1);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return Double.NaN;
        }
        double sumOfSquaresOfDeltas = this.xStats.sumOfSquaresOfDeltas();
        double sumOfSquaresOfDeltas2 = this.yStats.sumOfSquaresOfDeltas();
        Preconditions.checkState(sumOfSquaresOfDeltas > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        Preconditions.checkState(sumOfSquaresOfDeltas2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        return ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(ensurePositive(sumOfSquaresOfDeltas * sumOfSquaresOfDeltas2)));
    }

    public final LinearTransformation leastSquaresFit() {
        Preconditions.checkState(count() > 1);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return LinearTransformation.forNaN();
        }
        double sumOfSquaresOfDeltas = this.xStats.sumOfSquaresOfDeltas();
        if (sumOfSquaresOfDeltas > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            if (this.yStats.sumOfSquaresOfDeltas() > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return LinearTransformation.mapping(this.xStats.mean(), this.yStats.mean()).withSlope(this.sumOfProductsOfDeltas / sumOfSquaresOfDeltas);
            }
            return LinearTransformation.horizontal(this.yStats.mean());
        }
        Preconditions.checkState(this.yStats.sumOfSquaresOfDeltas() > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        return LinearTransformation.vertical(this.xStats.mean());
    }

    private static double ensureInUnitRange(double value) {
        return Doubles.constrainToRange(value, -1.0d, 1.0d);
    }
}
