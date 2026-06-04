package ru.mrlargha.commonui.elements.craft.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CraftResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/craft/domain/CategoryItem;", "", "category", "", "name", "", "items", "", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "getCategory", "()I", "getName", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CategoryItem {
    private final int category;
    private final List<Integer> items;
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CategoryItem copy$default(CategoryItem categoryItem, int i, String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = categoryItem.category;
        }
        if ((i2 & 2) != 0) {
            str = categoryItem.name;
        }
        if ((i2 & 4) != 0) {
            list = categoryItem.items;
        }
        return categoryItem.copy(i, str, list);
    }

    public final int component1() {
        return this.category;
    }

    public final String component2() {
        return this.name;
    }

    public final List<Integer> component3() {
        return this.items;
    }

    public final CategoryItem copy(int i, String str, List<Integer> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        return new CategoryItem(i, str, items);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CategoryItem) {
            CategoryItem categoryItem = (CategoryItem) obj;
            return this.category == categoryItem.category && Intrinsics.areEqual(this.name, categoryItem.name) && Intrinsics.areEqual(this.items, categoryItem.items);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.category) * 31;
        String str = this.name;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.items.hashCode();
    }

    public String toString() {
        int i = this.category;
        String str = this.name;
        return "CategoryItem(category=" + i + ", name=" + str + ", items=" + this.items + ")";
    }

    public CategoryItem(int i, String str, List<Integer> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.category = i;
        this.name = str;
        this.items = items;
    }

    public /* synthetic */ CategoryItem(int i, String str, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str, list);
    }

    public final int getCategory() {
        return this.category;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Integer> getItems() {
        return this.items;
    }
}
