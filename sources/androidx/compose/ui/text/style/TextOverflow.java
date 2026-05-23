package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: TextOverflow.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/style/TextOverflow;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class TextOverflow {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Clip = m8084constructorimpl(1);
    private static final int Ellipsis = m8084constructorimpl(2);
    private static final int Visible = m8084constructorimpl(3);
    private static final int StartEllipsis = m8084constructorimpl(4);
    private static final int MiddleEllipsis = m8084constructorimpl(5);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ TextOverflow m8083boximpl(int i) {
        return new TextOverflow(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m8084constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m8085equalsimpl(int i, Object obj) {
        return (obj instanceof TextOverflow) && i == ((TextOverflow) obj).m8089unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m8086equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m8087hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m8085equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m8087hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m8089unboximpl() {
        return this.value;
    }

    private /* synthetic */ TextOverflow(int i) {
        this.value = i;
    }

    public String toString() {
        return m8088toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m8088toStringimpl(int i) {
        return m8086equalsimpl0(i, Clip) ? "Clip" : m8086equalsimpl0(i, Ellipsis) ? "Ellipsis" : m8086equalsimpl0(i, MiddleEllipsis) ? "MiddleEllipsis" : m8086equalsimpl0(i, Visible) ? "Visible" : m8086equalsimpl0(i, StartEllipsis) ? "StartEllipsis" : "Invalid";
    }

    /* compiled from: TextOverflow.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\bR\u001e\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\bR\u001e\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\b¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/text/style/TextOverflow$Companion;", "", "<init>", "()V", "Clip", "Landroidx/compose/ui/text/style/TextOverflow;", "getClip-gIe3tQ8$annotations", "getClip-gIe3tQ8", "()I", "I", "Ellipsis", "getEllipsis-gIe3tQ8$annotations", "getEllipsis-gIe3tQ8", "Visible", "getVisible-gIe3tQ8$annotations", "getVisible-gIe3tQ8", "StartEllipsis", "getStartEllipsis-gIe3tQ8$annotations", "getStartEllipsis-gIe3tQ8", "MiddleEllipsis", "getMiddleEllipsis-gIe3tQ8$annotations", "getMiddleEllipsis-gIe3tQ8", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getClip-gIe3tQ8$annotations  reason: not valid java name */
        public static /* synthetic */ void m8090getClipgIe3tQ8$annotations() {
        }

        /* renamed from: getEllipsis-gIe3tQ8$annotations  reason: not valid java name */
        public static /* synthetic */ void m8091getEllipsisgIe3tQ8$annotations() {
        }

        /* renamed from: getMiddleEllipsis-gIe3tQ8$annotations  reason: not valid java name */
        public static /* synthetic */ void m8092getMiddleEllipsisgIe3tQ8$annotations() {
        }

        /* renamed from: getStartEllipsis-gIe3tQ8$annotations  reason: not valid java name */
        public static /* synthetic */ void m8093getStartEllipsisgIe3tQ8$annotations() {
        }

        /* renamed from: getVisible-gIe3tQ8$annotations  reason: not valid java name */
        public static /* synthetic */ void m8094getVisiblegIe3tQ8$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getClip-gIe3tQ8  reason: not valid java name */
        public final int m8095getClipgIe3tQ8() {
            return TextOverflow.Clip;
        }

        /* renamed from: getEllipsis-gIe3tQ8  reason: not valid java name */
        public final int m8096getEllipsisgIe3tQ8() {
            return TextOverflow.Ellipsis;
        }

        /* renamed from: getVisible-gIe3tQ8  reason: not valid java name */
        public final int m8099getVisiblegIe3tQ8() {
            return TextOverflow.Visible;
        }

        /* renamed from: getStartEllipsis-gIe3tQ8  reason: not valid java name */
        public final int m8098getStartEllipsisgIe3tQ8() {
            return TextOverflow.StartEllipsis;
        }

        /* renamed from: getMiddleEllipsis-gIe3tQ8  reason: not valid java name */
        public final int m8097getMiddleEllipsisgIe3tQ8() {
            return TextOverflow.MiddleEllipsis;
        }
    }
}
