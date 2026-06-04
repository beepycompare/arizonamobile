package com.miami.game.core.api.model.response.news;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NewsApiModelItem.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR'\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR'\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR'\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/miami/game/core/api/model/response/news/NewsApiModelItem;", "", "title", "", "imageUrl", "url", "date", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "Lcom/google/gson/annotations/SerializedName;", "value", "getImageUrl", "getUrl", "getDate", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "api-model"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewsApiModelItem {
    @SerializedName("date")
    private final String date;
    @SerializedName("imageUrl")
    private final String imageUrl;
    @SerializedName("title")
    private final String title;
    @SerializedName("url")
    private final String url;

    public static /* synthetic */ NewsApiModelItem copy$default(NewsApiModelItem newsApiModelItem, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = newsApiModelItem.title;
        }
        if ((i & 2) != 0) {
            str2 = newsApiModelItem.imageUrl;
        }
        if ((i & 4) != 0) {
            str3 = newsApiModelItem.url;
        }
        if ((i & 8) != 0) {
            str4 = newsApiModelItem.date;
        }
        return newsApiModelItem.copy(str, str2, str3, str4);
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

    public final NewsApiModelItem copy(String str, String str2, String str3, String str4) {
        return new NewsApiModelItem(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NewsApiModelItem) {
            NewsApiModelItem newsApiModelItem = (NewsApiModelItem) obj;
            return Intrinsics.areEqual(this.title, newsApiModelItem.title) && Intrinsics.areEqual(this.imageUrl, newsApiModelItem.imageUrl) && Intrinsics.areEqual(this.url, newsApiModelItem.url) && Intrinsics.areEqual(this.date, newsApiModelItem.date);
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
        return "NewsApiModelItem(title=" + str + ", imageUrl=" + str2 + ", url=" + str3 + ", date=" + this.date + ")";
    }

    public NewsApiModelItem(String str, String str2, String str3, String str4) {
        this.title = str;
        this.imageUrl = str2;
        this.url = str3;
        this.date = str4;
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
