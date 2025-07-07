package androidx.compose.material3.carousel;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Carousel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0081@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/carousel/CarouselAlignment;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class CarouselAlignment {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Start = m2674constructorimpl(-1);
    private static final int Center = m2674constructorimpl(0);
    private static final int End = m2674constructorimpl(1);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ CarouselAlignment m2673boximpl(int i) {
        return new CarouselAlignment(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m2674constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2675equalsimpl(int i, Object obj) {
        return (obj instanceof CarouselAlignment) && i == ((CarouselAlignment) obj).m2679unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2676equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2677hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2678toStringimpl(int i) {
        return "CarouselAlignment(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m2675equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2677hashCodeimpl(this.value);
    }

    public String toString() {
        return m2678toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m2679unboximpl() {
        return this.value;
    }

    /* compiled from: Carousel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/material3/carousel/CarouselAlignment$Companion;", "", "()V", "Center", "Landroidx/compose/material3/carousel/CarouselAlignment;", "getCenter-NUL3oTo", "()I", "I", "End", "getEnd-NUL3oTo", "Start", "getStart-NUL3oTo", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getStart-NUL3oTo  reason: not valid java name */
        public final int m2682getStartNUL3oTo() {
            return CarouselAlignment.Start;
        }

        /* renamed from: getCenter-NUL3oTo  reason: not valid java name */
        public final int m2680getCenterNUL3oTo() {
            return CarouselAlignment.Center;
        }

        /* renamed from: getEnd-NUL3oTo  reason: not valid java name */
        public final int m2681getEndNUL3oTo() {
            return CarouselAlignment.End;
        }
    }

    private /* synthetic */ CarouselAlignment(int i) {
        this.value = i;
    }
}
