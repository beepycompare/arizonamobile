package coil3.decode;

import coil3.size.Dimension;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeKt;
import coil3.util.IntPair;
import coil3.util.UtilsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.ranges.RangesKt;
/* compiled from: DecodeUtils.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0007J0\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0007J0\u0010\f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0007J0\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0007J7\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u0005*\u00020\u00172\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u0018"}, d2 = {"Lcoil3/decode/DecodeUtils;", "", "<init>", "()V", "calculateInSampleSize", "", "srcWidth", "srcHeight", "dstWidth", "dstHeight", "scale", "Lcoil3/size/Scale;", "computeSizeMultiplier", "", "", "computeDstSize", "Lcoil3/util/IntPair;", "targetSize", "Lcoil3/size/Size;", "maxSize", "computeDstSize-sEdh43o", "(IILcoil3/size/Size;Lcoil3/size/Scale;Lcoil3/size/Size;)J", "toPx", "Lcoil3/size/Dimension;", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DecodeUtils {
    public static final DecodeUtils INSTANCE = new DecodeUtils();

    /* compiled from: DecodeUtils.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Scale.values().length];
            try {
                iArr[Scale.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Scale.FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private DecodeUtils() {
    }

    @JvmStatic
    public static final int calculateInSampleSize(int i, int i2, int i3, int i4, Scale scale) {
        int min;
        int highestOneBit = Integer.highestOneBit(i / i3);
        int highestOneBit2 = Integer.highestOneBit(i2 / i4);
        int i5 = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i5 == 1) {
            min = Math.min(highestOneBit, highestOneBit2);
        } else if (i5 != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            min = Math.max(highestOneBit, highestOneBit2);
        }
        return RangesKt.coerceAtLeast(min, 1);
    }

    @JvmStatic
    public static final double computeSizeMultiplier(int i, int i2, int i3, int i4, Scale scale) {
        double d = i3 / i;
        double d2 = i4 / i2;
        int i5 = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            return Math.min(d, d2);
        }
        return Math.max(d, d2);
    }

    @JvmStatic
    public static final float computeSizeMultiplier(float f, float f2, float f3, float f4, Scale scale) {
        float f5 = f3 / f;
        float f6 = f4 / f2;
        int i = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            return Math.min(f5, f6);
        }
        return Math.max(f5, f6);
    }

    @JvmStatic
    public static final double computeSizeMultiplier(double d, double d2, double d3, double d4, Scale scale) {
        double d5 = d3 / d;
        double d6 = d4 / d2;
        int i = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            return Math.min(d5, d6);
        }
        return Math.max(d5, d6);
    }

    @JvmStatic
    /* renamed from: computeDstSize-sEdh43o  reason: not valid java name */
    public static final long m7771computeDstSizesEdh43o(int i, int i2, Size size, Scale scale, Size size2) {
        if (!SizeKt.isOriginal(size)) {
            DecodeUtils decodeUtils = INSTANCE;
            int px = decodeUtils.toPx(size.getWidth(), scale);
            i2 = decodeUtils.toPx(size.getHeight(), scale);
            i = px;
        }
        if ((size2.getWidth() instanceof Dimension.Pixels) && !UtilsKt.isMinOrMax(i)) {
            i = RangesKt.coerceAtMost(i, ((Dimension.Pixels) size2.getWidth()).m7820unboximpl());
        }
        if ((size2.getHeight() instanceof Dimension.Pixels) && !UtilsKt.isMinOrMax(i2)) {
            i2 = RangesKt.coerceAtMost(i2, ((Dimension.Pixels) size2.getHeight()).m7820unboximpl());
        }
        return IntPair.m7825constructorimpl(i, i2);
    }

    private final int toPx(Dimension dimension, Scale scale) {
        if (dimension instanceof Dimension.Pixels) {
            return ((Dimension.Pixels) dimension).m7820unboximpl();
        }
        int i = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return Integer.MAX_VALUE;
            }
            throw new NoWhenBranchMatchedException();
        }
        return Integer.MIN_VALUE;
    }
}
