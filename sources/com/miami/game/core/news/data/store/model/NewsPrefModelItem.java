package com.miami.game.core.news.data.store.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NewsPrefModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/miami/game/core/news/data/store/model/NewsPrefModelItem;", "", "title", "", "imageUrl", "url", "date", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getImageUrl", "getUrl", "getDate", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "news_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NewsPrefModelItem {
    @SerializedName("date")
    private final String date;
    @SerializedName("imageUrl")
    private final String imageUrl;
    @SerializedName("title")
    private final String title;
    @SerializedName("url")
    private final String url;

    public static /* synthetic */ NewsPrefModelItem copy$default(NewsPrefModelItem newsPrefModelItem, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = newsPrefModelItem.title;
        }
        if ((i & 2) != 0) {
            str2 = newsPrefModelItem.imageUrl;
        }
        if ((i & 4) != 0) {
            str3 = newsPrefModelItem.url;
        }
        if ((i & 8) != 0) {
            str4 = newsPrefModelItem.date;
        }
        return newsPrefModelItem.copy(str, str2, str3, str4);
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

    public final NewsPrefModelItem copy(String str, String str2, String str3, String str4) {
        return new NewsPrefModelItem(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NewsPrefModelItem) {
            NewsPrefModelItem newsPrefModelItem = (NewsPrefModelItem) obj;
            return Intrinsics.areEqual(this.title, newsPrefModelItem.title) && Intrinsics.areEqual(this.imageUrl, newsPrefModelItem.imageUrl) && Intrinsics.areEqual(this.url, newsPrefModelItem.url) && Intrinsics.areEqual(this.date, newsPrefModelItem.date);
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
        return "NewsPrefModelItem(title=" + str + ", imageUrl=" + str2 + ", url=" + str3 + ", date=" + this.date + ")";
    }

    public NewsPrefModelItem(String str, String str2, String str3, String str4) {
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
