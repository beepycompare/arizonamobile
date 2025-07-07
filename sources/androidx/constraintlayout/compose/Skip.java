package androidx.constraintlayout.compose;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: ConstraintLayoutBaseScope.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087@\u0018\u00002\u00020\u0001B'\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B\u001d\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\tB\u0011\b\u0002\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0088\u0001\n¨\u0006\u0019"}, d2 = {"Landroidx/constraintlayout/compose/Skip;", "", "position", "", "rows", "columns", "constructor-impl", "(III)Ljava/lang/String;", "size", "(II)Ljava/lang/String;", "description", "", "(Ljava/lang/String;)Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "equals", "", "other", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class Skip {
    private final String description;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Skip m7134boximpl(String str) {
        return new Skip(str);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static String m7137constructorimpl(String str) {
        return str;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7138equalsimpl(String str, Object obj) {
        return (obj instanceof Skip) && Intrinsics.areEqual(str, ((Skip) obj).m7142unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7139equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7140hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7141toStringimpl(String str) {
        return "Skip(description=" + str + ')';
    }

    public boolean equals(Object obj) {
        return m7138equalsimpl(this.description, obj);
    }

    public int hashCode() {
        return m7140hashCodeimpl(this.description);
    }

    public String toString() {
        return m7141toStringimpl(this.description);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ String m7142unboximpl() {
        return this.description;
    }

    private /* synthetic */ Skip(String str) {
        this.description = str;
    }

    public final String getDescription() {
        return this.description;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static String m7136constructorimpl(int i, int i2, int i3) {
        return m7137constructorimpl(new StringBuilder().append(i).append(AbstractJsonLexerKt.COLON).append(i2).append('x').append(i3).toString());
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static String m7135constructorimpl(int i, int i2) {
        return m7137constructorimpl(new StringBuilder().append(i).append(AbstractJsonLexerKt.COLON).append(i2).toString());
    }
}
