package com.miami.game.core.news.domain;

import com.miami.game.core.api.model.response.news.NewsApiModelItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NewsModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toDomain", "Lcom/miami/game/core/news/domain/NewsModel;", "Lcom/miami/game/core/api/model/response/news/NewsApiModelItem;", "news_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NewsModelKt {
    public static final NewsModel toDomain(NewsApiModelItem newsApiModelItem) {
        Intrinsics.checkNotNullParameter(newsApiModelItem, "<this>");
        return new NewsModel(newsApiModelItem.getTitle(), newsApiModelItem.getImageUrl(), newsApiModelItem.getUrl(), newsApiModelItem.getDate());
    }
}
