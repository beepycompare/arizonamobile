package com.miami.game.core.news.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NewsInteractor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0004"}, d2 = {"Lcom/miami/game/core/news/domain/newsHolder;", "", "<init>", "()V", "news", "", "Lcom/miami/game/core/news/domain/NewsModel;", "getNews", "()Ljava/util/List;", "setNews", "(Ljava/util/List;)V"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class newsHolder {
    public static final newsHolder INSTANCE = new newsHolder();
    private static List<NewsModel> news = CollectionsKt.emptyList();

    private newsHolder() {
    }

    public final List<NewsModel> getNews() {
        return news;
    }

    public final void setNews(List<NewsModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        news = list;
    }
}
