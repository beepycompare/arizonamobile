package com.miami.game.core.local.repository.common;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalRepository.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.local.repository.common.LocalRepository", f = "LocalRepository.kt", i = {0, 0}, l = {56}, m = "remove$suspendImpl", n = {"$this", "key"}, nl = {61}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes5.dex */
public final class LocalRepository$remove$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalRepository$remove$1(LocalRepository localRepository, Continuation<? super LocalRepository$remove$1> continuation) {
        super(continuation);
        this.this$0 = localRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return LocalRepository.remove$suspendImpl(this.this$0, null, this);
    }
}
