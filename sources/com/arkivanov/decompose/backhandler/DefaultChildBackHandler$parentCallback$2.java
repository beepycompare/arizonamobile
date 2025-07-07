package com.arkivanov.decompose.backhandler;

import com.arkivanov.essenty.backhandler.BackDispatcher;
import com.arkivanov.essenty.backhandler.BackEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DefaultChildBackHandler.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class DefaultChildBackHandler$parentCallback$2 extends FunctionReferenceImpl implements Function1<BackEvent, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultChildBackHandler$parentCallback$2(Object obj) {
        super(1, obj, BackDispatcher.class, "progressPredictiveBack", "progressPredictiveBack(Lcom/arkivanov/essenty/backhandler/BackEvent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BackEvent backEvent) {
        invoke2(backEvent);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(BackEvent p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((BackDispatcher) this.receiver).progressPredictiveBack(p0);
    }
}
