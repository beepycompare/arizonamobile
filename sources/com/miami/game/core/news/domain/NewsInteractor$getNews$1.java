package com.miami.game.core.news.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewsInteractor.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.news.domain.NewsInteractor", f = "NewsInteractor.kt", i = {}, l = {56}, m = "getNews", n = {}, s = {})
/* loaded from: classes4.dex */
public final class NewsInteractor$getNews$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NewsInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewsInteractor$getNews$1(NewsInteractor newsInteractor, Continuation<? super NewsInteractor$getNews$1> continuation) {
        super(continuation);
        this.this$0 = newsInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object news;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        news = this.this$0.getNews(this);
        return news;
    }
}
