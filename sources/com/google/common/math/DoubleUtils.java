package com.google.common.math;

import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.google.common.base.Preconditions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.math.BigInteger;
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class DoubleUtils {
    static final int EXPONENT_BIAS = 1023;
    static final long EXPONENT_MASK = 9218868437227405312L;
    static final long IMPLICIT_BIT = 4503599627370496L;
    static final long ONE_BITS = 4607182418800017408L;
    static final int SIGNIFICAND_BITS = 52;
    static final long SIGNIFICAND_MASK = 4503599627370495L;
    static final long SIGN_MASK = Long.MIN_VALUE;

    private DoubleUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double nextDown(double d) {
        return -Math.nextUp(-d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getSignificand(double d) {
        Preconditions.checkArgument(isFinite(d), "not a normal value");
        int exponent = Math.getExponent(d);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d) & SIGNIFICAND_MASK;
        return exponent == -1023 ? doubleToRawLongBits << 1 : doubleToRawLongBits | IMPLICIT_BIT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isFinite(double d) {
        return Math.getExponent(d) <= 1023;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isNormal(double d) {
        return Math.getExponent(d) >= -1022;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double scaleNormalize(double x) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(x) & SIGNIFICAND_MASK) | ONE_BITS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double bigToDouble(BigInteger x) {
        BigInteger abs = x.abs();
        int bitLength = abs.bitLength();
        int i = bitLength - 1;
        if (i < 63) {
            return x.longValue();
        }
        if (i > 1023) {
            return x.signum() * Double.POSITIVE_INFINITY;
        }
        int i2 = bitLength - 54;
        long longValue = abs.shiftRight(i2).longValue();
        long j = longValue >> 1;
        long j2 = SIGNIFICAND_MASK & j;
        if ((longValue & 1) != 0 && ((j & 1) != 0 || abs.getLowestSetBit() < i2)) {
            j2++;
        }
        return Double.longBitsToDouble((((bitLength + AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) << 52) + j2) | (x.signum() & Long.MIN_VALUE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double ensureNonNegative(double value) {
        Preconditions.checkArgument(!Double.isNaN(value));
        return Math.max(value, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }
}
