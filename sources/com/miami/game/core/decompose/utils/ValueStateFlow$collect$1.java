package com.miami.game.core.decompose.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ValueStateFlow.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.decompose.utils.ValueStateFlow", f = "ValueStateFlow.kt", i = {0, 0, 0, 0}, l = {21}, m = "collect", n = {"collector", "flow", "observer", "cancellation"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes4.dex */
public final class ValueStateFlow$collect$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ValueStateFlow<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ValueStateFlow$collect$1(ValueStateFlow<T> valueStateFlow, Continuation<? super ValueStateFlow$collect$1> continuation) {
        super(continuation);
        this.this$0 = valueStateFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collect(null, this);
    }
}
