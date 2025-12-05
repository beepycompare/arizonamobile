package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: GraphicsLayerModifier.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\t\u001a\u00020\u0003HÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\r"}, d2 = {"Landroidx/compose/ui/graphics/CompositingStrategy;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "hashCode", "toString", "", "Companion", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class CompositingStrategy {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Auto = m5509constructorimpl(0);
    private static final int Offscreen = m5509constructorimpl(1);
    private static final int ModulateAlpha = m5509constructorimpl(2);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ CompositingStrategy m5508boximpl(int i) {
        return new CompositingStrategy(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m5509constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5510equalsimpl(int i, Object obj) {
        return (obj instanceof CompositingStrategy) && i == ((CompositingStrategy) obj).m5514unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5511equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5512hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5513toStringimpl(int i) {
        return "CompositingStrategy(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m5510equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5512hashCodeimpl(this.value);
    }

    public String toString() {
        return m5513toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m5514unboximpl() {
        return this.value;
    }

    private /* synthetic */ CompositingStrategy(int i) {
        this.value = i;
    }

    /* compiled from: GraphicsLayerModifier.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/graphics/CompositingStrategy$Companion;", "", "<init>", "()V", "Auto", "Landroidx/compose/ui/graphics/CompositingStrategy;", "getAuto--NrFUSI", "()I", "I", "Offscreen", "getOffscreen--NrFUSI", "ModulateAlpha", "getModulateAlpha--NrFUSI", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getAuto--NrFUSI  reason: not valid java name */
        public final int m5515getAutoNrFUSI() {
            return CompositingStrategy.Auto;
        }

        /* renamed from: getOffscreen--NrFUSI  reason: not valid java name */
        public final int m5517getOffscreenNrFUSI() {
            return CompositingStrategy.Offscreen;
        }

        /* renamed from: getModulateAlpha--NrFUSI  reason: not valid java name */
        public final int m5516getModulateAlphaNrFUSI() {
            return CompositingStrategy.ModulateAlpha;
        }
    }
}
