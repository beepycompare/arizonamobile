package com.miami.game.core.news.data.api;

import com.miami.game.core.api.model.response.news.NewsApiModelItem;
import com.miami.game.core.api.network.NetworkDataSource;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
/* compiled from: NewsApiRepository.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0086@¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/miami/game/core/news/data/api/NewsApiRepository;", "", "networkDataSource", "Lcom/miami/game/core/api/network/NetworkDataSource;", "<init>", "(Lcom/miami/game/core/api/network/NetworkDataSource;)V", "getNews", "", "Lcom/miami/game/core/api/model/response/news/NewsApiModelItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "news_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NewsApiRepository {
    private final NetworkDataSource networkDataSource;

    @Inject
    public NewsApiRepository(NetworkDataSource networkDataSource) {
        Intrinsics.checkNotNullParameter(networkDataSource, "networkDataSource");
        this.networkDataSource = networkDataSource;
    }

    public final Object getNews(Continuation<? super List<NewsApiModelItem>> continuation) throws Exception {
        return BuildersKt.withContext(Dispatchers.getIO(), new NewsApiRepository$getNews$2(this, null), continuation);
    }
}
