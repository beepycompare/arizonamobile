package androidx.compose.ui.graphics.colorspace;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: RenderIntent.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-graphics"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class RenderIntent {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Perceptual = m5799constructorimpl(0);
    private static final int Relative = m5799constructorimpl(1);
    private static final int Saturation = m5799constructorimpl(2);
    private static final int Absolute = m5799constructorimpl(3);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ RenderIntent m5798boximpl(int i) {
        return new RenderIntent(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m5799constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5800equalsimpl(int i, Object obj) {
        return (obj instanceof RenderIntent) && i == ((RenderIntent) obj).m5804unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5801equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5802hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m5800equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5802hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m5804unboximpl() {
        return this.value;
    }

    /* compiled from: RenderIntent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/RenderIntent$Companion;", "", "<init>", "()V", "Perceptual", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "getPerceptual-uksYyKA", "()I", "I", "Relative", "getRelative-uksYyKA", ExifInterface.TAG_SATURATION, "getSaturation-uksYyKA", "Absolute", "getAbsolute-uksYyKA", "ui-graphics"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getPerceptual-uksYyKA  reason: not valid java name */
        public final int m5806getPerceptualuksYyKA() {
            return RenderIntent.Perceptual;
        }

        /* renamed from: getRelative-uksYyKA  reason: not valid java name */
        public final int m5807getRelativeuksYyKA() {
            return RenderIntent.Relative;
        }

        /* renamed from: getSaturation-uksYyKA  reason: not valid java name */
        public final int m5808getSaturationuksYyKA() {
            return RenderIntent.Saturation;
        }

        /* renamed from: getAbsolute-uksYyKA  reason: not valid java name */
        public final int m5805getAbsoluteuksYyKA() {
            return RenderIntent.Absolute;
        }
    }

    private /* synthetic */ RenderIntent(int i) {
        this.value = i;
    }

    public String toString() {
        return m5803toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5803toStringimpl(int i) {
        return m5801equalsimpl0(i, Perceptual) ? "Perceptual" : m5801equalsimpl0(i, Relative) ? "Relative" : m5801equalsimpl0(i, Saturation) ? ExifInterface.TAG_SATURATION : m5801equalsimpl0(i, Absolute) ? "Absolute" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }
}
