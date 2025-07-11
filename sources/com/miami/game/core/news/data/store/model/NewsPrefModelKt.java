package com.miami.game.core.news.data.store.model;

import com.miami.game.core.api.model.response.news.NewsApiModelItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NewsPrefModel.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0004"}, d2 = {"toDomain", "Lcom/miami/game/core/api/model/response/news/NewsApiModelItem;", "Lcom/miami/game/core/news/data/store/model/NewsPrefModelItem;", "toPrefsModel", "news_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NewsPrefModelKt {
    public static final NewsApiModelItem toDomain(NewsPrefModelItem newsPrefModelItem) {
        Intrinsics.checkNotNullParameter(newsPrefModelItem, "<this>");
        return new NewsApiModelItem(newsPrefModelItem.getTitle(), newsPrefModelItem.getImageUrl(), newsPrefModelItem.getUrl(), newsPrefModelItem.getDate());
    }

    public static final NewsPrefModelItem toPrefsModel(NewsApiModelItem newsApiModelItem) {
        Intrinsics.checkNotNullParameter(newsApiModelItem, "<this>");
        return new NewsPrefModelItem(newsApiModelItem.getTitle(), newsApiModelItem.getImageUrl(), newsApiModelItem.getUrl(), newsApiModelItem.getDate());
    }
}
