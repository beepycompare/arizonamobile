package ru.mrlargha.commonui.elements.tuningAuto.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ResponseData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003JF\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001f"}, d2 = {"Lru/mrlargha/commonui/elements/tuningAuto/domain/CategoryInfo;", "", "id", "", "name", "", "icon", "parentId", "type", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getIcon", "getParentId", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lru/mrlargha/commonui/elements/tuningAuto/domain/CategoryInfo;", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CategoryInfo {
    private final String icon;
    private final Integer id;
    private final String name;
    private final Integer parentId;
    private final String type;

    public static /* synthetic */ CategoryInfo copy$default(CategoryInfo categoryInfo, Integer num, String str, String str2, Integer num2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = categoryInfo.id;
        }
        if ((i & 2) != 0) {
            str = categoryInfo.name;
        }
        if ((i & 4) != 0) {
            str2 = categoryInfo.icon;
        }
        if ((i & 8) != 0) {
            num2 = categoryInfo.parentId;
        }
        if ((i & 16) != 0) {
            str3 = categoryInfo.type;
        }
        String str4 = str3;
        String str5 = str2;
        return categoryInfo.copy(num, str, str5, num2, str4);
    }

    public final Integer component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.icon;
    }

    public final Integer component4() {
        return this.parentId;
    }

    public final String component5() {
        return this.type;
    }

    public final CategoryInfo copy(Integer num, String name, String icon, Integer num2, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new CategoryInfo(num, name, icon, num2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CategoryInfo) {
            CategoryInfo categoryInfo = (CategoryInfo) obj;
            return Intrinsics.areEqual(this.id, categoryInfo.id) && Intrinsics.areEqual(this.name, categoryInfo.name) && Intrinsics.areEqual(this.icon, categoryInfo.icon) && Intrinsics.areEqual(this.parentId, categoryInfo.parentId) && Intrinsics.areEqual(this.type, categoryInfo.type);
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (((((num == null ? 0 : num.hashCode()) * 31) + this.name.hashCode()) * 31) + this.icon.hashCode()) * 31;
        Integer num2 = this.parentId;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.type;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        Integer num = this.id;
        String str = this.name;
        String str2 = this.icon;
        Integer num2 = this.parentId;
        return "CategoryInfo(id=" + num + ", name=" + str + ", icon=" + str2 + ", parentId=" + num2 + ", type=" + this.type + ")";
    }

    public CategoryInfo(Integer num, String name, String icon, Integer num2, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.id = num;
        this.name = name;
        this.icon = icon;
        this.parentId = num2;
        this.type = str;
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final Integer getParentId() {
        return this.parentId;
    }

    public final String getType() {
        return this.type;
    }
}
