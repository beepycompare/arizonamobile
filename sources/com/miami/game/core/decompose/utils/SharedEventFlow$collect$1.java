package com.miami.game.core.decompose.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SharedEventFlow.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.decompose.utils.SharedEventFlow", f = "SharedEventFlow.kt", i = {0}, l = {22}, m = "collect", n = {"collector"}, s = {"L$0"})
/* loaded from: classes4.dex */
public final class SharedEventFlow$collect$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SharedEventFlow<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedEventFlow$collect$1(SharedEventFlow<T> sharedEventFlow, Continuation<? super SharedEventFlow$collect$1> continuation) {
        super(continuation);
        this.this$0 = sharedEventFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collect(null, this);
    }
}
