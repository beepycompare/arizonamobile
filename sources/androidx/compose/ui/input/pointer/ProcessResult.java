package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
/* compiled from: PointerInputEventProcessor.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b\u0088\u0001\u0002¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/input/pointer/ProcessResult;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "dispatchedToAPointerInputModifier", "", "getDispatchedToAPointerInputModifier-impl", "(I)Z", "anyMovementConsumed", "getAnyMovementConsumed-impl", "anyChangeConsumed", "getAnyChangeConsumed-impl", "equals", "other", "hashCode", "toString", "", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class ProcessResult {
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ProcessResult m6769boximpl(int i) {
        return new ProcessResult(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m6770constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6771equalsimpl(int i, Object obj) {
        return (obj instanceof ProcessResult) && i == ((ProcessResult) obj).m6778unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6772equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: getAnyChangeConsumed-impl  reason: not valid java name */
    public static final boolean m6773getAnyChangeConsumedimpl(int i) {
        return (i & 4) != 0;
    }

    /* renamed from: getAnyMovementConsumed-impl  reason: not valid java name */
    public static final boolean m6774getAnyMovementConsumedimpl(int i) {
        return (i & 2) != 0;
    }

    /* renamed from: getDispatchedToAPointerInputModifier-impl  reason: not valid java name */
    public static final boolean m6775getDispatchedToAPointerInputModifierimpl(int i) {
        return (i & 1) != 0;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6776hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6777toStringimpl(int i) {
        return "ProcessResult(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m6771equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m6776hashCodeimpl(this.value);
    }

    public String toString() {
        return m6777toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m6778unboximpl() {
        return this.value;
    }

    private /* synthetic */ ProcessResult(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
