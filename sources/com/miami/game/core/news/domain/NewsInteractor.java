package com.miami.game.core.news.domain;

import com.miami.game.core.api.model.response.news.NewsApiModelItem;
import com.miami.game.core.news.data.NewsRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
/* compiled from: NewsInteractor.kt */
@Singleton
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0082@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/miami/game/core/news/domain/NewsInteractor;", "", "repository", "Lcom/miami/game/core/news/data/NewsRepository;", "<init>", "(Lcom/miami/game/core/news/data/NewsRepository;)V", "stateStore", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/core/news/domain/NewsState;", "interactorStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getInteractorStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "initial", "", "retry", "getNews", "", "Lcom/miami/game/core/news/domain/NewsModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "news_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NewsInteractor {
    private final StateFlow<NewsState> interactorStateFlow;
    private final NewsRepository repository;
    private final CoroutineScope scope;
    private final MutableStateFlow<NewsState> stateStore;

    @Inject
    public NewsInteractor(NewsRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
        MutableStateFlow<NewsState> MutableStateFlow = StateFlowKt.MutableStateFlow(new NewsState(null, 1, null));
        this.stateStore = MutableStateFlow;
        this.interactorStateFlow = FlowKt.asStateFlow(MutableStateFlow);
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        initial();
    }

    public final StateFlow<NewsState> getInteractorStateFlow() {
        return this.interactorStateFlow;
    }

    public final void initial() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getIO(), null, new NewsInteractor$initial$1(this, null), 2, null);
    }

    public final void retry() {
        initial();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0059 A[LOOP:0: B:18:0x0053->B:20:0x0059, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getNews(Continuation<? super List<NewsModel>> continuation) {
        NewsInteractor$getNews$1 newsInteractor$getNews$1;
        int i;
        if (continuation instanceof NewsInteractor$getNews$1) {
            newsInteractor$getNews$1 = (NewsInteractor$getNews$1) continuation;
            if ((newsInteractor$getNews$1.label & Integer.MIN_VALUE) != 0) {
                newsInteractor$getNews$1.label -= Integer.MIN_VALUE;
                Object obj = newsInteractor$getNews$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = newsInteractor$getNews$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    NewsRepository newsRepository = this.repository;
                    newsInteractor$getNews$1.label = 1;
                    obj = newsRepository.getNews(newsInteractor$getNews$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                Iterable<NewsApiModelItem> iterable = (Iterable) obj;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (NewsApiModelItem newsApiModelItem : iterable) {
                    arrayList.add(NewsModelKt.toDomain(newsApiModelItem));
                }
                return arrayList;
            }
        }
        newsInteractor$getNews$1 = new NewsInteractor$getNews$1(this, continuation);
        Object obj2 = newsInteractor$getNews$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = newsInteractor$getNews$1.label;
        if (i != 0) {
        }
        Iterable<NewsApiModelItem> iterable2 = (Iterable) obj2;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        while (r5.hasNext()) {
        }
        return arrayList2;
    }
}
