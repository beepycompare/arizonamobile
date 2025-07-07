package ru.mrlargha.commonui.elements.craft.domain;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CraftResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/craft/domain/CategoryItem;", "", "category", "", FirebaseAnalytics.Param.ITEMS, "", "<init>", "(ILjava/util/List;)V", "getCategory", "()I", "getItems", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CategoryItem {
    private final int category;
    private final List<Integer> items;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CategoryItem copy$default(CategoryItem categoryItem, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = categoryItem.category;
        }
        if ((i2 & 2) != 0) {
            list = categoryItem.items;
        }
        return categoryItem.copy(i, list);
    }

    public final int component1() {
        return this.category;
    }

    public final List<Integer> component2() {
        return this.items;
    }

    public final CategoryItem copy(int i, List<Integer> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        return new CategoryItem(i, items);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CategoryItem) {
            CategoryItem categoryItem = (CategoryItem) obj;
            return this.category == categoryItem.category && Intrinsics.areEqual(this.items, categoryItem.items);
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.category) * 31) + this.items.hashCode();
    }

    public String toString() {
        int i = this.category;
        return "CategoryItem(category=" + i + ", items=" + this.items + ")";
    }

    public CategoryItem(int i, List<Integer> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.category = i;
        this.items = items;
    }

    public final int getCategory() {
        return this.category;
    }

    public final List<Integer> getItems() {
        return this.items;
    }
}
