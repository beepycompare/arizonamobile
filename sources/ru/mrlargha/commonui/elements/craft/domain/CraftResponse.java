package ru.mrlargha.commonui.elements.craft.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CraftResponse.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/craft/domain/CraftResponse;", "", "categories", "", "Lru/mrlargha/commonui/elements/craft/domain/CategoryItem;", "colors", "Lru/mrlargha/commonui/elements/craft/domain/ItemColor;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getCategories", "()Ljava/util/List;", "getColors", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CraftResponse {
    private final List<CategoryItem> categories;
    private final List<ItemColor> colors;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CraftResponse copy$default(CraftResponse craftResponse, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = craftResponse.categories;
        }
        if ((i & 2) != 0) {
            list2 = craftResponse.colors;
        }
        return craftResponse.copy(list, list2);
    }

    public final List<CategoryItem> component1() {
        return this.categories;
    }

    public final List<ItemColor> component2() {
        return this.colors;
    }

    public final CraftResponse copy(List<CategoryItem> categories, List<ItemColor> colors) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(colors, "colors");
        return new CraftResponse(categories, colors);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CraftResponse) {
            CraftResponse craftResponse = (CraftResponse) obj;
            return Intrinsics.areEqual(this.categories, craftResponse.categories) && Intrinsics.areEqual(this.colors, craftResponse.colors);
        }
        return false;
    }

    public int hashCode() {
        return (this.categories.hashCode() * 31) + this.colors.hashCode();
    }

    public String toString() {
        List<CategoryItem> list = this.categories;
        return "CraftResponse(categories=" + list + ", colors=" + this.colors + ")";
    }

    public CraftResponse(List<CategoryItem> categories, List<ItemColor> colors) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.categories = categories;
        this.colors = colors;
    }

    public final List<CategoryItem> getCategories() {
        return this.categories;
    }

    public final List<ItemColor> getColors() {
        return this.colors;
    }
}
