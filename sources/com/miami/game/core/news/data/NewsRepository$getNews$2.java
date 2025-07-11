package com.miami.game.core.news.data;

import com.miami.game.core.api.model.response.news.NewsApiModelItem;
import com.miami.game.core.news.data.api.NewsApiRepository;
import com.miami.game.core.news.data.store.NewsPrefRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewsRepository.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/miami/game/core/api/model/response/news/NewsApiModelItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.news.data.NewsRepository$getNews$2", f = "NewsRepository.kt", i = {1}, l = {22, 24}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
/* loaded from: classes4.dex */
public final class NewsRepository$getNews$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends NewsApiModelItem>>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ NewsRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewsRepository$getNews$2(NewsRepository newsRepository, Continuation<? super NewsRepository$getNews$2> continuation) {
        super(2, continuation);
        this.this$0 = newsRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NewsRepository$getNews$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends NewsApiModelItem>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<NewsApiModelItem>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<NewsApiModelItem>> continuation) {
        return ((NewsRepository$getNews$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (r5 == r0) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0055 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        NewsApiRepository newsApiRepository;
        NewsPrefRepository newsPrefRepository;
        List<NewsApiModelItem> list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            newsApiRepository = this.this$0.apiRepository;
            this.label = 1;
            obj = newsApiRepository.getNews(this);
        } else if (i != 1) {
            if (i == 2) {
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                return list != null ? CollectionsKt.emptyList() : list;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        List<NewsApiModelItem> list2 = (List) obj;
        newsPrefRepository = this.this$0.prefRepository;
        this.L$0 = list2;
        this.label = 2;
        if (newsPrefRepository.saveCache(list2, this) != coroutine_suspended) {
            list = list2;
            if (list != null) {
            }
        }
        return coroutine_suspended;
    }
}
