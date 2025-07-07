package ru.mrlargha.commonui.elements.catalog.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CatalogInfoModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/catalog/models/CatalogInfoModel;", "", "title", "", "desc", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getDesc", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CatalogInfoModel {
    private final String desc;
    private final String title;

    public CatalogInfoModel() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ CatalogInfoModel copy$default(CatalogInfoModel catalogInfoModel, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = catalogInfoModel.title;
        }
        if ((i & 2) != 0) {
            str2 = catalogInfoModel.desc;
        }
        return catalogInfoModel.copy(str, str2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.desc;
    }

    public final CatalogInfoModel copy(String title, String desc) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        return new CatalogInfoModel(title, desc);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CatalogInfoModel) {
            CatalogInfoModel catalogInfoModel = (CatalogInfoModel) obj;
            return Intrinsics.areEqual(this.title, catalogInfoModel.title) && Intrinsics.areEqual(this.desc, catalogInfoModel.desc);
        }
        return false;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.desc.hashCode();
    }

    public String toString() {
        String str = this.title;
        return "CatalogInfoModel(title=" + str + ", desc=" + this.desc + ")";
    }

    public CatalogInfoModel(String title, String desc) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.title = title;
        this.desc = desc;
    }

    public /* synthetic */ CatalogInfoModel(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "unknown" : str, (i & 2) != 0 ? "unknown" : str2);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDesc() {
        return this.desc;
    }
}
