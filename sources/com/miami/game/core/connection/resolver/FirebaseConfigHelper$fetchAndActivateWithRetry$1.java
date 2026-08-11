package com.miami.game.core.connection.resolver;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FirebaseServerHandler.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.connection.resolver.FirebaseConfigHelper", f = "FirebaseServerHandler.kt", i = {0, 0}, l = {288}, m = "fetchAndActivateWithRetry", n = {"attempt", "fetched"}, nl = {290}, s = {"I$2", "I$3"}, v = 2)
/* loaded from: classes5.dex */
public final class FirebaseConfigHelper$fetchAndActivateWithRetry$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FirebaseConfigHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirebaseConfigHelper$fetchAndActivateWithRetry$1(FirebaseConfigHelper firebaseConfigHelper, Continuation<? super FirebaseConfigHelper$fetchAndActivateWithRetry$1> continuation) {
        super(continuation);
        this.this$0 = firebaseConfigHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object fetchAndActivateWithRetry;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchAndActivateWithRetry = this.this$0.fetchAndActivateWithRetry(this);
        return fetchAndActivateWithRetry;
    }
}
