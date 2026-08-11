package ru.mrlargha.commonui.elements.catalog.models;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CatalogInfoModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/catalog/models/CatalogInfoModel;", "", "title", "", "desc", FirebaseAnalytics.Event.SEARCH, "", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getDesc", "getSearch", "()Z", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CatalogInfoModel {
    private final String desc;
    private final boolean search;
    private final String title;
    private final String url;

    public CatalogInfoModel() {
        this(null, null, false, null, 15, null);
    }

    public static /* synthetic */ CatalogInfoModel copy$default(CatalogInfoModel catalogInfoModel, String str, String str2, boolean z, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = catalogInfoModel.title;
        }
        if ((i & 2) != 0) {
            str2 = catalogInfoModel.desc;
        }
        if ((i & 4) != 0) {
            z = catalogInfoModel.search;
        }
        if ((i & 8) != 0) {
            str3 = catalogInfoModel.url;
        }
        return catalogInfoModel.copy(str, str2, z, str3);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.desc;
    }

    public final boolean component3() {
        return this.search;
    }

    public final String component4() {
        return this.url;
    }

    public final CatalogInfoModel copy(String title, String desc, boolean z, String str) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        return new CatalogInfoModel(title, desc, z, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CatalogInfoModel) {
            CatalogInfoModel catalogInfoModel = (CatalogInfoModel) obj;
            return Intrinsics.areEqual(this.title, catalogInfoModel.title) && Intrinsics.areEqual(this.desc, catalogInfoModel.desc) && this.search == catalogInfoModel.search && Intrinsics.areEqual(this.url, catalogInfoModel.url);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.title.hashCode() * 31) + this.desc.hashCode()) * 31) + Boolean.hashCode(this.search)) * 31;
        String str = this.url;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.title;
        String str2 = this.desc;
        boolean z = this.search;
        return "CatalogInfoModel(title=" + str + ", desc=" + str2 + ", search=" + z + ", url=" + this.url + ")";
    }

    public CatalogInfoModel(String title, String desc, boolean z, String str) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.title = title;
        this.desc = desc;
        this.search = z;
        this.url = str;
    }

    public /* synthetic */ CatalogInfoModel(String str, String str2, boolean z, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "unknown" : str, (i & 2) != 0 ? "unknown" : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : str3);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final boolean getSearch() {
        return this.search;
    }

    public final String getUrl() {
        return this.url;
    }
}
