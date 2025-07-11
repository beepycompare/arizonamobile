package com.miami.game.core.news.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NewsModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/miami/game/core/news/domain/NewsModel;", "", "title", "", "imageUrl", "url", "date", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getImageUrl", "getUrl", "getDate", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "news_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NewsModel {
    private final String date;
    private final String imageUrl;
    private final String title;
    private final String url;

    public NewsModel() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ NewsModel copy$default(NewsModel newsModel, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = newsModel.title;
        }
        if ((i & 2) != 0) {
            str2 = newsModel.imageUrl;
        }
        if ((i & 4) != 0) {
            str3 = newsModel.url;
        }
        if ((i & 8) != 0) {
            str4 = newsModel.date;
        }
        return newsModel.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.imageUrl;
    }

    public final String component3() {
        return this.url;
    }

    public final String component4() {
        return this.date;
    }

    public final NewsModel copy(String str, String str2, String str3, String str4) {
        return new NewsModel(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NewsModel) {
            NewsModel newsModel = (NewsModel) obj;
            return Intrinsics.areEqual(this.title, newsModel.title) && Intrinsics.areEqual(this.imageUrl, newsModel.imageUrl) && Intrinsics.areEqual(this.url, newsModel.url) && Intrinsics.areEqual(this.date, newsModel.date);
        }
        return false;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.imageUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.url;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.date;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        String str = this.title;
        String str2 = this.imageUrl;
        String str3 = this.url;
        return "NewsModel(title=" + str + ", imageUrl=" + str2 + ", url=" + str3 + ", date=" + this.date + ")";
    }

    public NewsModel(String str, String str2, String str3, String str4) {
        this.title = str;
        this.imageUrl = str2;
        this.url = str3;
        this.date = str4;
    }

    public /* synthetic */ NewsModel(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "Загрузка.." : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getDate() {
        return this.date;
    }
}
