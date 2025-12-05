package androidx.compose.ui.unit;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Dp.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u000f\u0010\u0005J\u0018\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0003H\u0087\n¢\u0006\u0004\b\u0011\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b\u0011\u0010\u0013J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0014\u0010\u000bJ\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0003H\u0087\n¢\u0006\u0004\b\u0016\u0010\u000bJ\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b\u0016\u0010\u0013J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0000H\u0097\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u001bH\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010\t\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006#"}, d2 = {"Landroidx/compose/ui/unit/Dp;", "", "value", "", "constructor-impl", "(F)F", "getValue", "()F", "plus", "other", "plus-5rwHm24", "(FF)F", "minus", "minus-5rwHm24", "unaryMinus", "unaryMinus-D9Ej5fM", TtmlNode.TAG_DIV, "div-u2uoSUM", "", "(FI)F", "div-0680j_4", "times", "times-u2uoSUM", "compareTo", "compareTo-0680j_4", "(FF)I", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class Dp implements Comparable<Dp> {
    public static final Companion Companion = new Companion(null);
    private static final float Hairline = m8258constructorimpl(0.0f);
    private static final float Infinity = m8258constructorimpl(Float.POSITIVE_INFINITY);
    private static final float Unspecified = m8258constructorimpl(Float.NaN);
    private final float value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Dp m8256boximpl(float f) {
        return new Dp(f);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static float m8258constructorimpl(float f) {
        return f;
    }

    /* renamed from: div-0680j_4  reason: not valid java name */
    public static final float m8259div0680j_4(float f, float f2) {
        return f / f2;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m8262equalsimpl(float f, Object obj) {
        return (obj instanceof Dp) && Float.compare(f, ((Dp) obj).m8272unboximpl()) == 0;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m8263equalsimpl0(float f, float f2) {
        return Float.compare(f, f2) == 0;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m8264hashCodeimpl(float f) {
        return Float.hashCode(f);
    }

    public boolean equals(Object obj) {
        return m8262equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m8264hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ float m8272unboximpl() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Dp dp) {
        return m8271compareTo0680j_4(dp.m8272unboximpl());
    }

    private /* synthetic */ Dp(float f) {
        this.value = f;
    }

    public final float getValue() {
        return this.value;
    }

    /* renamed from: plus-5rwHm24  reason: not valid java name */
    public static final float m8266plus5rwHm24(float f, float f2) {
        return m8258constructorimpl(f + f2);
    }

    /* renamed from: minus-5rwHm24  reason: not valid java name */
    public static final float m8265minus5rwHm24(float f, float f2) {
        return m8258constructorimpl(f - f2);
    }

    /* renamed from: unaryMinus-D9Ej5fM  reason: not valid java name */
    public static final float m8270unaryMinusD9Ej5fM(float f) {
        return m8258constructorimpl(-f);
    }

    /* renamed from: div-u2uoSUM  reason: not valid java name */
    public static final float m8260divu2uoSUM(float f, float f2) {
        return m8258constructorimpl(f / f2);
    }

    /* renamed from: div-u2uoSUM  reason: not valid java name */
    public static final float m8261divu2uoSUM(float f, int i) {
        return m8258constructorimpl(f / i);
    }

    /* renamed from: times-u2uoSUM  reason: not valid java name */
    public static final float m8267timesu2uoSUM(float f, float f2) {
        return m8258constructorimpl(f * f2);
    }

    /* renamed from: times-u2uoSUM  reason: not valid java name */
    public static final float m8268timesu2uoSUM(float f, int i) {
        return m8258constructorimpl(f * i);
    }

    /* renamed from: compareTo-0680j_4  reason: not valid java name */
    public int m8271compareTo0680j_4(float f) {
        return m8257compareTo0680j_4(this.value, f);
    }

    /* renamed from: compareTo-0680j_4  reason: not valid java name */
    public static int m8257compareTo0680j_4(float f, float f2) {
        if (ComposeUiUnitFlags.isDpCompareToChanged) {
            if (Float.isNaN(f) || Float.isNaN(f2)) {
                return 0;
            }
            return Float.compare(f, f2);
        }
        return Float.compare(f, f2);
    }

    public String toString() {
        return m8269toStringimpl(this.value);
    }

    /* compiled from: Dp.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\b¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/unit/Dp$Companion;", "", "<init>", "()V", "Hairline", "Landroidx/compose/ui/unit/Dp;", "getHairline-D9Ej5fM$annotations", "getHairline-D9Ej5fM", "()F", "F", "Infinity", "getInfinity-D9Ej5fM$annotations", "getInfinity-D9Ej5fM", "Unspecified", "getUnspecified-D9Ej5fM$annotations", "getUnspecified-D9Ej5fM", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getHairline-D9Ej5fM$annotations  reason: not valid java name */
        public static /* synthetic */ void m8273getHairlineD9Ej5fM$annotations() {
        }

        /* renamed from: getInfinity-D9Ej5fM$annotations  reason: not valid java name */
        public static /* synthetic */ void m8274getInfinityD9Ej5fM$annotations() {
        }

        /* renamed from: getUnspecified-D9Ej5fM$annotations  reason: not valid java name */
        public static /* synthetic */ void m8275getUnspecifiedD9Ej5fM$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getHairline-D9Ej5fM  reason: not valid java name */
        public final float m8276getHairlineD9Ej5fM() {
            return Dp.Hairline;
        }

        /* renamed from: getInfinity-D9Ej5fM  reason: not valid java name */
        public final float m8277getInfinityD9Ej5fM() {
            return Dp.Infinity;
        }

        /* renamed from: getUnspecified-D9Ej5fM  reason: not valid java name */
        public final float m8278getUnspecifiedD9Ej5fM() {
            return Dp.Unspecified;
        }
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m8269toStringimpl(float f) {
        return Float.isNaN(f) ? "Dp.Unspecified" : f + ".dp";
    }
}
