package com.adjust.sdk;

import androidx.compose.material3.internal.CalendarModelKt;
/* loaded from: classes3.dex */
public enum BackoffStrategy {
    LONG_WAIT(1, 120000, CalendarModelKt.MillisecondsIn24Hours, 0.5d, 1.0d),
    SHORT_WAIT(1, 200, 3600000, 0.5d, 1.0d),
    TEST_WAIT(1, 200, 1000, 0.5d, 1.0d),
    NO_WAIT(100, 1, 1000, 1.0d, 1.0d);
    
    double maxRange;
    long maxWait;
    long milliSecondMultiplier;
    double minRange;
    int minRetries;

    BackoffStrategy(int i, long j, long j2, double d, double d2) {
        this.minRetries = i;
        this.milliSecondMultiplier = j;
        this.maxWait = j2;
        this.minRange = d;
        this.maxRange = d2;
    }
}
