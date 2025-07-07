package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.KeyCommand;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TextFieldKeyEventHandler.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081@\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0088\u0001\u0002¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/text/input/internal/ClipboardKeyCommandsHandler;", "", "handler", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/KeyCommand;", "", "constructor-impl", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "getHandler", "()Lkotlin/jvm/functions/Function1;", "equals", "", "other", "equals-impl", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Lkotlin/jvm/functions/Function1;)I", "toString", "", "toString-impl", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class ClipboardKeyCommandsHandler {
    private final Function1<KeyCommand, Unit> handler;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ClipboardKeyCommandsHandler m1238boximpl(Function1 function1) {
        return new ClipboardKeyCommandsHandler(function1);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static Function1<? super KeyCommand, ? extends Unit> m1239constructorimpl(Function1<? super KeyCommand, Unit> function1) {
        return function1;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1240equalsimpl(Function1<? super KeyCommand, ? extends Unit> function1, Object obj) {
        return (obj instanceof ClipboardKeyCommandsHandler) && Intrinsics.areEqual(function1, ((ClipboardKeyCommandsHandler) obj).m1244unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1241equalsimpl0(Function1<? super KeyCommand, ? extends Unit> function1, Function1<? super KeyCommand, ? extends Unit> function12) {
        return Intrinsics.areEqual(function1, function12);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1242hashCodeimpl(Function1<? super KeyCommand, ? extends Unit> function1) {
        return function1.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1243toStringimpl(Function1<? super KeyCommand, ? extends Unit> function1) {
        return "ClipboardKeyCommandsHandler(handler=" + function1 + ')';
    }

    public boolean equals(Object obj) {
        return m1240equalsimpl(this.handler, obj);
    }

    public int hashCode() {
        return m1242hashCodeimpl(this.handler);
    }

    public String toString() {
        return m1243toStringimpl(this.handler);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Function1 m1244unboximpl() {
        return this.handler;
    }

    private /* synthetic */ ClipboardKeyCommandsHandler(Function1 function1) {
        this.handler = function1;
    }

    public final Function1<KeyCommand, Unit> getHandler() {
        return this.handler;
    }
}
