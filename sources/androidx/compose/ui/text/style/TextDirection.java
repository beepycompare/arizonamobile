package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: TextDirection.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/TextDirection;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class TextDirection {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Ltr = m6576constructorimpl(1);
    private static final int Rtl = m6576constructorimpl(2);
    private static final int Content = m6576constructorimpl(3);
    private static final int ContentOrLtr = m6576constructorimpl(4);
    private static final int ContentOrRtl = m6576constructorimpl(5);
    private static final int Unspecified = m6576constructorimpl(Integer.MIN_VALUE);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ TextDirection m6575boximpl(int i) {
        return new TextDirection(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m6576constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6577equalsimpl(int i, Object obj) {
        return (obj instanceof TextDirection) && i == ((TextDirection) obj).m6581unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6578equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6579hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m6577equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m6579hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m6581unboximpl() {
        return this.value;
    }

    private /* synthetic */ TextDirection(int i) {
        this.value = i;
    }

    public String toString() {
        return m6580toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6580toStringimpl(int i) {
        return m6578equalsimpl0(i, Ltr) ? "Ltr" : m6578equalsimpl0(i, Rtl) ? "Rtl" : m6578equalsimpl0(i, Content) ? "Content" : m6578equalsimpl0(i, ContentOrLtr) ? "ContentOrLtr" : m6578equalsimpl0(i, ContentOrRtl) ? "ContentOrRtl" : m6578equalsimpl0(i, Unspecified) ? "Unspecified" : "Invalid";
    }

    /* compiled from: TextDirection.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/TextDirection$Companion;", "", "()V", "Content", "Landroidx/compose/ui/text/style/TextDirection;", "getContent-s_7X-co", "()I", "I", "ContentOrLtr", "getContentOrLtr-s_7X-co", "ContentOrRtl", "getContentOrRtl-s_7X-co", "Ltr", "getLtr-s_7X-co", "Rtl", "getRtl-s_7X-co", "Unspecified", "getUnspecified-s_7X-co", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getLtr-s_7X-co  reason: not valid java name */
        public final int m6585getLtrs_7Xco() {
            return TextDirection.Ltr;
        }

        /* renamed from: getRtl-s_7X-co  reason: not valid java name */
        public final int m6586getRtls_7Xco() {
            return TextDirection.Rtl;
        }

        /* renamed from: getContent-s_7X-co  reason: not valid java name */
        public final int m6582getContents_7Xco() {
            return TextDirection.Content;
        }

        /* renamed from: getContentOrLtr-s_7X-co  reason: not valid java name */
        public final int m6583getContentOrLtrs_7Xco() {
            return TextDirection.ContentOrLtr;
        }

        /* renamed from: getContentOrRtl-s_7X-co  reason: not valid java name */
        public final int m6584getContentOrRtls_7Xco() {
            return TextDirection.ContentOrRtl;
        }

        /* renamed from: getUnspecified-s_7X-co  reason: not valid java name */
        public final int m6587getUnspecifieds_7Xco() {
            return TextDirection.Unspecified;
        }
    }
}
