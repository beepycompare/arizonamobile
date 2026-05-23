package androidx.compose.ui.graphics;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: ImageBitmap.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/graphics/ImageBitmapConfig;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-graphics"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class ImageBitmapConfig {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Argb8888 = m5572constructorimpl(0);
    private static final int Alpha8 = m5572constructorimpl(1);
    private static final int Rgb565 = m5572constructorimpl(2);
    private static final int F16 = m5572constructorimpl(3);
    private static final int Gpu = m5572constructorimpl(4);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ImageBitmapConfig m5571boximpl(int i) {
        return new ImageBitmapConfig(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m5572constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5573equalsimpl(int i, Object obj) {
        return (obj instanceof ImageBitmapConfig) && i == ((ImageBitmapConfig) obj).m5577unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5574equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5575hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m5573equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5575hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m5577unboximpl() {
        return this.value;
    }

    /* compiled from: ImageBitmap.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/graphics/ImageBitmapConfig$Companion;", "", "<init>", "()V", "Argb8888", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getArgb8888-_sVssgQ", "()I", "I", "Alpha8", "getAlpha8-_sVssgQ", "Rgb565", "getRgb565-_sVssgQ", "F16", "getF16-_sVssgQ", "Gpu", "getGpu-_sVssgQ", "ui-graphics"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getArgb8888-_sVssgQ  reason: not valid java name */
        public final int m5579getArgb8888_sVssgQ() {
            return ImageBitmapConfig.Argb8888;
        }

        /* renamed from: getAlpha8-_sVssgQ  reason: not valid java name */
        public final int m5578getAlpha8_sVssgQ() {
            return ImageBitmapConfig.Alpha8;
        }

        /* renamed from: getRgb565-_sVssgQ  reason: not valid java name */
        public final int m5582getRgb565_sVssgQ() {
            return ImageBitmapConfig.Rgb565;
        }

        /* renamed from: getF16-_sVssgQ  reason: not valid java name */
        public final int m5580getF16_sVssgQ() {
            return ImageBitmapConfig.F16;
        }

        /* renamed from: getGpu-_sVssgQ  reason: not valid java name */
        public final int m5581getGpu_sVssgQ() {
            return ImageBitmapConfig.Gpu;
        }
    }

    private /* synthetic */ ImageBitmapConfig(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    public String toString() {
        return m5576toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5576toStringimpl(int i) {
        return m5574equalsimpl0(i, Argb8888) ? "Argb8888" : m5574equalsimpl0(i, Alpha8) ? "Alpha8" : m5574equalsimpl0(i, Rgb565) ? "Rgb565" : m5574equalsimpl0(i, F16) ? "F16" : m5574equalsimpl0(i, Gpu) ? "Gpu" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }
}
