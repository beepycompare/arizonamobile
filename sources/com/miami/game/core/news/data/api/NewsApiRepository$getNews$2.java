package com.miami.game.core.news.data.api;

import com.miami.game.core.api.model.response.news.NewsApiModelItem;
import com.miami.game.core.api.network.NetworkDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewsApiRepository.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/miami/game/core/api/model/response/news/NewsApiModelItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.news.data.api.NewsApiRepository$getNews$2", f = "NewsApiRepository.kt", i = {}, l = {14}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class NewsApiRepository$getNews$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends NewsApiModelItem>>, Object> {
    int label;
    final /* synthetic */ NewsApiRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewsApiRepository$getNews$2(NewsApiRepository newsApiRepository, Continuation<? super NewsApiRepository$getNews$2> continuation) {
        super(2, continuation);
        this.this$0 = newsApiRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NewsApiRepository$getNews$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends NewsApiModelItem>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<NewsApiModelItem>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<NewsApiModelItem>> continuation) {
        return ((NewsApiRepository$getNews$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        NetworkDataSource networkDataSource;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        networkDataSource = this.this$0.networkDataSource;
        this.label = 1;
        Object news = networkDataSource.getNews(this);
        return news == coroutine_suspended ? coroutine_suspended : news;
    }
}
