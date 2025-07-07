package com.arkivanov.decompose.backhandler;

import com.arkivanov.essenty.backhandler.BackDispatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* compiled from: DefaultChildBackHandler.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class DefaultChildBackHandler$parentCallback$3 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultChildBackHandler$parentCallback$3(Object obj) {
        super(0, obj, BackDispatcher.class, "cancelPredictiveBack", "cancelPredictiveBack()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((BackDispatcher) this.receiver).cancelPredictiveBack();
    }
}
