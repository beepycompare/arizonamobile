package androidx.compose.ui.unit;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: IntOffset.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u0000 42\u00020\u0001:\u00014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0014\u0010\rJ'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aH\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b#\u0010\rJ\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b%\u0010&J\u001b\u0010'\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b(\u0010&J\u001e\u0010)\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\tH\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+J\u001e\u0010,\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aH\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010\u001cJ\u000f\u0010.\u001a\u00020/H\u0017¢\u0006\u0004\b0\u00101J\u0016\u00102\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u0088\u0001\u0002\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"Landroidx/compose/ui/unit/IntOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "x", "", "getX$annotations", "()V", "getX-impl", "(J)I", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-iSbpLlY", "(JII)J", TtmlNode.TAG_DIV, "operand", "", "div-Bjo55l4", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "minus", "minus-qkQi6aY", "(JJ)J", "plus", "plus-qkQi6aY", "rem", "rem-Bjo55l4", "(JI)J", "times", "times-Bjo55l4", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-nOcc-ac", "Companion", "ui-unit_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class IntOffset {
    private final long packedValue;
    public static final Companion Companion = new Companion(null);
    private static final long Zero = m6806constructorimpl(0);
    private static final long Max = m6806constructorimpl(9223372034707292159L);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ IntOffset m6803boximpl(long j) {
        return new IntOffset(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m6806constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6810equalsimpl(long j, Object obj) {
        return (obj instanceof IntOffset) && j == ((IntOffset) obj).m6821unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6811equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getX$annotations() {
    }

    /* renamed from: getX-impl  reason: not valid java name */
    public static final int m6812getXimpl(long j) {
        return (int) (j >> 32);
    }

    public static /* synthetic */ void getY$annotations() {
    }

    /* renamed from: getY-impl  reason: not valid java name */
    public static final int m6813getYimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6814hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m6810equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m6814hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m6821unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ IntOffset(long j) {
        this.packedValue = j;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    /* renamed from: component1-impl  reason: not valid java name */
    public static final int m6804component1impl(long j) {
        return m6812getXimpl(j);
    }

    /* renamed from: component2-impl  reason: not valid java name */
    public static final int m6805component2impl(long j) {
        return m6813getYimpl(j);
    }

    /* renamed from: copy-iSbpLlY$default  reason: not valid java name */
    public static /* synthetic */ long m6808copyiSbpLlY$default(long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = (int) (j >> 32);
        }
        if ((i3 & 2) != 0) {
            i2 = (int) (4294967295L & j);
        }
        return m6807copyiSbpLlY(j, i, i2);
    }

    /* renamed from: copy-iSbpLlY  reason: not valid java name */
    public static final long m6807copyiSbpLlY(long j, int i, int i2) {
        return m6806constructorimpl((i << 32) | (i2 & 4294967295L));
    }

    /* renamed from: minus-qkQi6aY  reason: not valid java name */
    public static final long m6815minusqkQi6aY(long j, long j2) {
        return m6806constructorimpl(((((int) (j >> 32)) - ((int) (j2 >> 32))) << 32) | ((((int) (j & 4294967295L)) - ((int) (j2 & 4294967295L))) & 4294967295L));
    }

    /* renamed from: plus-qkQi6aY  reason: not valid java name */
    public static final long m6816plusqkQi6aY(long j, long j2) {
        return m6806constructorimpl(((((int) (j >> 32)) + ((int) (j2 >> 32))) << 32) | ((((int) (j & 4294967295L)) + ((int) (j2 & 4294967295L))) & 4294967295L));
    }

    /* renamed from: unaryMinus-nOcc-ac  reason: not valid java name */
    public static final long m6820unaryMinusnOccac(long j) {
        return m6806constructorimpl(((-((int) (j & 4294967295L))) & 4294967295L) | ((-((int) (j >> 32))) << 32));
    }

    /* renamed from: rem-Bjo55l4  reason: not valid java name */
    public static final long m6817remBjo55l4(long j, int i) {
        return m6806constructorimpl(((((int) (j >> 32)) % i) << 32) | ((((int) (j & 4294967295L)) % i) & 4294967295L));
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6819toStringimpl(long j) {
        return "(" + m6812getXimpl(j) + ", " + m6813getYimpl(j) + ')';
    }

    public String toString() {
        return m6819toStringimpl(this.packedValue);
    }

    /* compiled from: IntOffset.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/ui/unit/IntOffset$Companion;", "", "()V", "Max", "Landroidx/compose/ui/unit/IntOffset;", "getMax-nOcc-ac", "()J", "J", "Zero", "getZero-nOcc-ac", "ui-unit_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getZero-nOcc-ac  reason: not valid java name */
        public final long m6823getZeronOccac() {
            return IntOffset.Zero;
        }

        /* renamed from: getMax-nOcc-ac  reason: not valid java name */
        public final long m6822getMaxnOccac() {
            return IntOffset.Max;
        }
    }

    /* renamed from: times-Bjo55l4  reason: not valid java name */
    public static final long m6818timesBjo55l4(long j, float f) {
        return m6806constructorimpl((Math.round(((int) (j >> 32)) * f) << 32) | (Math.round(((int) (j & 4294967295L)) * f) & 4294967295L));
    }

    /* renamed from: div-Bjo55l4  reason: not valid java name */
    public static final long m6809divBjo55l4(long j, float f) {
        return m6806constructorimpl((Math.round(((int) (j >> 32)) / f) << 32) | (Math.round(((int) (j & 4294967295L)) / f) & 4294967295L));
    }
}
