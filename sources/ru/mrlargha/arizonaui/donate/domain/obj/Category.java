package ru.mrlargha.arizonaui.donate.domain.obj;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Category.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u001b\u001a\u00020\tHÆ\u0003JD\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lru/mrlargha/arizonaui/donate/domain/obj/Category;", "", "id", "", "title", "url", "img", "", "onClicked", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Z)V", "getId", "()Ljava/lang/String;", "getTitle", "getUrl", "getImg", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOnClicked", "()Z", "setOnClicked", "(Z)V", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Z)Lru/mrlargha/arizonaui/donate/domain/obj/Category;", "equals", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Category {
    private final String id;
    private final Integer img;
    private boolean onClicked;
    private final String title;
    private final String url;

    public static /* synthetic */ Category copy$default(Category category, String str, String str2, String str3, Integer num, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = category.id;
        }
        if ((i & 2) != 0) {
            str2 = category.title;
        }
        if ((i & 4) != 0) {
            str3 = category.url;
        }
        if ((i & 8) != 0) {
            num = category.img;
        }
        if ((i & 16) != 0) {
            z = category.onClicked;
        }
        boolean z2 = z;
        String str4 = str3;
        return category.copy(str, str2, str4, num, z2);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.url;
    }

    public final Integer component4() {
        return this.img;
    }

    public final boolean component5() {
        return this.onClicked;
    }

    public final Category copy(String id, String title, String str, Integer num, boolean z) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        return new Category(id, title, str, num, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Category) {
            Category category = (Category) obj;
            return Intrinsics.areEqual(this.id, category.id) && Intrinsics.areEqual(this.title, category.title) && Intrinsics.areEqual(this.url, category.url) && Intrinsics.areEqual(this.img, category.img) && this.onClicked == category.onClicked;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.id.hashCode() * 31) + this.title.hashCode()) * 31;
        String str = this.url;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.img;
        return ((hashCode2 + (num != null ? num.hashCode() : 0)) * 31) + Boolean.hashCode(this.onClicked);
    }

    public String toString() {
        String str = this.id;
        String str2 = this.title;
        String str3 = this.url;
        Integer num = this.img;
        return "Category(id=" + str + ", title=" + str2 + ", url=" + str3 + ", img=" + num + ", onClicked=" + this.onClicked + ")";
    }

    public Category(String id, String title, String str, Integer num, boolean z) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        this.id = id;
        this.title = title;
        this.url = str;
        this.img = num;
        this.onClicked = z;
    }

    public /* synthetic */ Category(String str, String str2, String str3, Integer num, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, num, (i & 16) != 0 ? false : z);
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Integer getImg() {
        return this.img;
    }

    public final boolean getOnClicked() {
        return this.onClicked;
    }

    public final void setOnClicked(boolean z) {
        this.onClicked = z;
    }
}
