package com.miami.game.core.news.data.store;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewsPrefRepository.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.news.data.store.NewsPrefRepository", f = "NewsPrefRepository.kt", i = {}, l = {43}, m = "getCache", n = {}, s = {})
/* loaded from: classes4.dex */
public final class NewsPrefRepository$getCache$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NewsPrefRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewsPrefRepository$getCache$1(NewsPrefRepository newsPrefRepository, Continuation<? super NewsPrefRepository$getCache$1> continuation) {
        super(continuation);
        this.this$0 = newsPrefRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getCache(this);
    }
}
