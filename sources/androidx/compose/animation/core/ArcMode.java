package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: VectorizedAnimationSpec.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\t\u001a\u00020\u0003HÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\r"}, d2 = {"Landroidx/compose/animation/core/ArcMode;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "hashCode", "toString", "", "Companion", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class ArcMode {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int ArcAbove = m190constructorimpl(5);
    private static final int ArcBelow = m190constructorimpl(4);
    private static final int ArcLinear = m190constructorimpl(0);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ArcMode m189boximpl(int i) {
        return new ArcMode(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m190constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m191equalsimpl(int i, Object obj) {
        return (obj instanceof ArcMode) && i == ((ArcMode) obj).m195unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m192equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m193hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m194toStringimpl(int i) {
        return "ArcMode(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m191equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m193hashCodeimpl(this.value);
    }

    public String toString() {
        return m194toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m195unboximpl() {
        return this.value;
    }

    private /* synthetic */ ArcMode(int i) {
        this.value = i;
    }

    /* compiled from: VectorizedAnimationSpec.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/animation/core/ArcMode$Companion;", "", "<init>", "()V", "ArcAbove", "Landroidx/compose/animation/core/ArcMode;", "getArcAbove--9T-Mq4", "()I", "I", "ArcBelow", "getArcBelow--9T-Mq4", "ArcLinear", "getArcLinear--9T-Mq4", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getArcAbove--9T-Mq4  reason: not valid java name */
        public final int m196getArcAbove9TMq4() {
            return ArcMode.ArcAbove;
        }

        /* renamed from: getArcBelow--9T-Mq4  reason: not valid java name */
        public final int m197getArcBelow9TMq4() {
            return ArcMode.ArcBelow;
        }

        /* renamed from: getArcLinear--9T-Mq4  reason: not valid java name */
        public final int m198getArcLinear9TMq4() {
            return ArcMode.ArcLinear;
        }
    }
}
