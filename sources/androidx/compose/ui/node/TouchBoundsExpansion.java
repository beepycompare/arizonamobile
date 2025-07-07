package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: TouchBoundsExpansion.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 %2\u00020\u0001:\u0001%B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u001a\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b \u0010\tJ\u0010\u0010!\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006&"}, d2 = {"Landroidx/compose/ui/node/TouchBoundsExpansion;", "", "packedValue", "", "constructor-impl", "(J)J", "bottom", "", "getBottom-impl", "(J)I", TtmlNode.END, "getEnd-impl", "isLayoutDirectionAware", "", "isLayoutDirectionAware-impl", "(J)Z", TtmlNode.START, "getStart-impl", "top", "getTop-impl", "computeLeft", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "computeLeft-impl$ui_release", "(JLandroidx/compose/ui/unit/LayoutDirection;)I", "computeRight", "computeRight-impl$ui_release", "equals", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class TouchBoundsExpansion {
    private static final long IS_LAYOUT_DIRECTION_AWARE = Long.MIN_VALUE;
    private static final int MASK = 32767;
    public static final int MAX_VALUE = 32767;
    private static final int SHIFT = 15;
    private final long packedValue;
    public static final Companion Companion = new Companion(null);
    private static final long None = TouchBoundsExpansionKt.TouchBoundsExpansion$default(0, 0, 0, 0, 14, null);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ TouchBoundsExpansion m5779boximpl(long j) {
        return new TouchBoundsExpansion(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m5782constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5783equalsimpl(long j, Object obj) {
        return (obj instanceof TouchBoundsExpansion) && j == ((TouchBoundsExpansion) obj).m5792unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5784equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5789hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* renamed from: isLayoutDirectionAware-impl  reason: not valid java name */
    public static final boolean m5790isLayoutDirectionAwareimpl(long j) {
        return (j & Long.MIN_VALUE) != 0;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5791toStringimpl(long j) {
        return "TouchBoundsExpansion(packedValue=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m5783equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m5789hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m5791toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m5792unboximpl() {
        return this.packedValue;
    }

    /* compiled from: TouchBoundsExpansion.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J;\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J5\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001aJ\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/ui/node/TouchBoundsExpansion$Companion;", "", "()V", "IS_LAYOUT_DIRECTION_AWARE", "", "MASK", "", "MAX_VALUE", "None", "Landroidx/compose/ui/node/TouchBoundsExpansion;", "getNone-RZrCHBk", "()J", "J", "SHIFT", "Absolute", TtmlNode.LEFT, "top", TtmlNode.RIGHT, "bottom", "Absolute-vsh68fg", "(IIII)J", "pack", TtmlNode.START, TtmlNode.END, "isLayoutDirectionAware", "", "pack$ui_release", "trimAndShift", "int", "position", "unpack", "packedValue", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final long trimAndShift(int i, int i2) {
            return (i & 32767) << (i2 * 15);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int unpack(long j, int i) {
            return ((int) (j >> (i * 15))) & 32767;
        }

        private Companion() {
        }

        /* renamed from: Absolute-vsh68fg$default  reason: not valid java name */
        public static /* synthetic */ long m5793Absolutevsh68fg$default(Companion companion, int i, int i2, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = 0;
            }
            if ((i5 & 2) != 0) {
                i2 = 0;
            }
            if ((i5 & 4) != 0) {
                i3 = 0;
            }
            if ((i5 & 8) != 0) {
                i4 = 0;
            }
            return companion.m5794Absolutevsh68fg(i, i2, i3, i4);
        }

        /* renamed from: Absolute-vsh68fg  reason: not valid java name */
        public final long m5794Absolutevsh68fg(int i, int i2, int i3, int i4) {
            boolean z = true;
            if (!(i >= 0 && i < 32768)) {
                InlineClassHelperKt.throwIllegalArgumentException("Start must be in the range of 0 .. 32767");
            }
            if (!(i2 >= 0 && i2 < 32768)) {
                InlineClassHelperKt.throwIllegalArgumentException("Top must be in the range of 0 .. 32767");
            }
            if (!(i3 >= 0 && i3 < 32768)) {
                InlineClassHelperKt.throwIllegalArgumentException("End must be in the range of 0 .. 32767");
            }
            if (i4 < 0 || i4 >= 32768) {
                z = false;
            }
            if (!z) {
                InlineClassHelperKt.throwIllegalArgumentException("Bottom must be in the range of 0 .. 32767");
            }
            return TouchBoundsExpansion.m5782constructorimpl(pack$ui_release(i, i2, i3, i4, false));
        }

        /* renamed from: getNone-RZrCHBk  reason: not valid java name */
        public final long m5795getNoneRZrCHBk() {
            return TouchBoundsExpansion.None;
        }

        public final long pack$ui_release(int i, int i2, int i3, int i4, boolean z) {
            return trimAndShift(i2, 1) | trimAndShift(i, 0) | trimAndShift(i3, 2) | trimAndShift(i4, 3) | (z ? Long.MIN_VALUE : 0L);
        }
    }

    private /* synthetic */ TouchBoundsExpansion(long j) {
        this.packedValue = j;
    }

    /* renamed from: getStart-impl  reason: not valid java name */
    public static final int m5787getStartimpl(long j) {
        return Companion.unpack(j, 0);
    }

    /* renamed from: getTop-impl  reason: not valid java name */
    public static final int m5788getTopimpl(long j) {
        return Companion.unpack(j, 1);
    }

    /* renamed from: getEnd-impl  reason: not valid java name */
    public static final int m5786getEndimpl(long j) {
        return Companion.unpack(j, 2);
    }

    /* renamed from: getBottom-impl  reason: not valid java name */
    public static final int m5785getBottomimpl(long j) {
        return Companion.unpack(j, 3);
    }

    /* renamed from: computeLeft-impl$ui_release  reason: not valid java name */
    public static final int m5780computeLeftimpl$ui_release(long j, LayoutDirection layoutDirection) {
        if (!m5790isLayoutDirectionAwareimpl(j) || layoutDirection == LayoutDirection.Ltr) {
            return m5787getStartimpl(j);
        }
        return m5786getEndimpl(j);
    }

    /* renamed from: computeRight-impl$ui_release  reason: not valid java name */
    public static final int m5781computeRightimpl$ui_release(long j, LayoutDirection layoutDirection) {
        if (!m5790isLayoutDirectionAwareimpl(j) || layoutDirection == LayoutDirection.Ltr) {
            return m5786getEndimpl(j);
        }
        return m5787getStartimpl(j);
    }
}
