package com.miami.game.core.news.data;

import com.miami.game.core.api.model.response.news.NewsApiModelItem;
import com.miami.game.core.news.data.api.NewsApiRepository;
import com.miami.game.core.news.data.store.NewsPrefRepository;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
/* compiled from: NewsRepository.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0002\b\b¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0086@¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/miami/game/core/news/data/NewsRepository;", "", "apiRepository", "Lcom/miami/game/core/news/data/api/NewsApiRepository;", "prefRepository", "Lcom/miami/game/core/news/data/store/NewsPrefRepository;", "<init>", "(Lcom/miami/game/core/news/data/api/NewsApiRepository;Lcom/miami/game/core/news/data/store/NewsPrefRepository;)V", "Ljavax/inject/Inject;", "getNews", "", "Lcom/miami/game/core/api/model/response/news/NewsApiModelItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "news"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewsRepository {
    private final NewsApiRepository apiRepository;
    private final NewsPrefRepository prefRepository;

    @Inject
    public NewsRepository(NewsApiRepository apiRepository, NewsPrefRepository prefRepository) {
        Intrinsics.checkNotNullParameter(apiRepository, "apiRepository");
        Intrinsics.checkNotNullParameter(prefRepository, "prefRepository");
        this.apiRepository = apiRepository;
        this.prefRepository = prefRepository;
    }

    public final Object getNews(Continuation<? super List<NewsApiModelItem>> continuation) throws Exception {
        return BuildersKt.withContext(Dispatchers.getIO(), new NewsRepository$getNews$2(this, null), continuation);
    }
}
