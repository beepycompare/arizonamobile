package com.arkivanov.decompose.backhandler;

import com.arkivanov.decompose.UtilsKt;
import com.arkivanov.essenty.backhandler.BackHandler;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import com.arkivanov.essenty.lifecycle.LifecycleExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ChildBackHandler.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0000\u001a \u0010\u0006\u001a\u00020\u0007*\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\n"}, d2 = {"child", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "lifecycle", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "priority", "", "childBackHandler", "Lcom/arkivanov/decompose/backhandler/ChildBackHandler;", "isEnabled", "", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChildBackHandlerKt {
    public static /* synthetic */ BackHandler child$default(BackHandler backHandler, Lifecycle lifecycle, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            lifecycle = null;
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return child(backHandler, lifecycle, i);
    }

    public static final BackHandler child(BackHandler backHandler, Lifecycle lifecycle, int i) {
        Intrinsics.checkNotNullParameter(backHandler, "<this>");
        final ChildBackHandler childBackHandler = childBackHandler(backHandler, false, i);
        if (lifecycle == null) {
            childBackHandler.setEnabled(true);
            childBackHandler.start();
        } else if (!UtilsKt.isDestroyed(lifecycle)) {
            childBackHandler.setEnabled(lifecycle.getState().compareTo(Lifecycle.State.STARTED) >= 0);
            childBackHandler.start();
            LifecycleExtKt.subscribe$default(lifecycle, null, new Function0() { // from class: com.arkivanov.decompose.backhandler.ChildBackHandlerKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit child$lambda$0;
                    child$lambda$0 = ChildBackHandlerKt.child$lambda$0(ChildBackHandler.this);
                    return child$lambda$0;
                }
            }, null, null, new Function0() { // from class: com.arkivanov.decompose.backhandler.ChildBackHandlerKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit child$lambda$1;
                    child$lambda$1 = ChildBackHandlerKt.child$lambda$1(ChildBackHandler.this);
                    return child$lambda$1;
                }
            }, new ChildBackHandlerKt$child$3(childBackHandler), 13, null);
        }
        return childBackHandler;
    }

    public static final Unit child$lambda$0(ChildBackHandler childBackHandler) {
        childBackHandler.setEnabled(true);
        return Unit.INSTANCE;
    }

    public static final Unit child$lambda$1(ChildBackHandler childBackHandler) {
        childBackHandler.setEnabled(false);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ ChildBackHandler childBackHandler$default(BackHandler backHandler, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return childBackHandler(backHandler, z, i);
    }

    public static final ChildBackHandler childBackHandler(BackHandler backHandler, boolean z, int i) {
        Intrinsics.checkNotNullParameter(backHandler, "<this>");
        return new DefaultChildBackHandler(backHandler, z, i, null, 8, null);
    }
}
