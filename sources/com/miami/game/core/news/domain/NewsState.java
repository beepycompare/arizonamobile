package com.miami.game.core.news.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NewsState.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/miami/game/core/news/domain/NewsState;", "", "newsList", "", "Lcom/miami/game/core/news/domain/NewsModel;", "<init>", "(Ljava/util/List;)V", "getNewsList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "news_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NewsState {
    private final List<NewsModel> newsList;

    public NewsState() {
        this(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NewsState copy$default(NewsState newsState, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = newsState.newsList;
        }
        return newsState.copy(list);
    }

    public final List<NewsModel> component1() {
        return this.newsList;
    }

    public final NewsState copy(List<NewsModel> newsList) {
        Intrinsics.checkNotNullParameter(newsList, "newsList");
        return new NewsState(newsList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NewsState) && Intrinsics.areEqual(this.newsList, ((NewsState) obj).newsList);
    }

    public int hashCode() {
        return this.newsList.hashCode();
    }

    public String toString() {
        return "NewsState(newsList=" + this.newsList + ")";
    }

    public NewsState(List<NewsModel> newsList) {
        Intrinsics.checkNotNullParameter(newsList, "newsList");
        this.newsList = newsList;
    }

    public /* synthetic */ NewsState(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<NewsModel> getNewsList() {
        return this.newsList;
    }
}
