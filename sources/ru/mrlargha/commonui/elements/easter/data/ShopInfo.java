package ru.mrlargha.commonui.elements.easter.data;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ShopData.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/easter/data/ShopInfo;", "", "top", "", "Lru/mrlargha/commonui/elements/easter/data/ShopTopItem;", FirebaseAnalytics.Param.ITEMS, "Lru/mrlargha/commonui/elements/easter/data/ShopItem;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getTop", "()Ljava/util/List;", "getItems", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShopInfo {
    private final List<ShopItem> items;
    private final List<ShopTopItem> top;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShopInfo copy$default(ShopInfo shopInfo, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = shopInfo.top;
        }
        if ((i & 2) != 0) {
            list2 = shopInfo.items;
        }
        return shopInfo.copy(list, list2);
    }

    public final List<ShopTopItem> component1() {
        return this.top;
    }

    public final List<ShopItem> component2() {
        return this.items;
    }

    public final ShopInfo copy(List<ShopTopItem> top, List<ShopItem> items) {
        Intrinsics.checkNotNullParameter(top, "top");
        Intrinsics.checkNotNullParameter(items, "items");
        return new ShopInfo(top, items);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShopInfo) {
            ShopInfo shopInfo = (ShopInfo) obj;
            return Intrinsics.areEqual(this.top, shopInfo.top) && Intrinsics.areEqual(this.items, shopInfo.items);
        }
        return false;
    }

    public int hashCode() {
        return (this.top.hashCode() * 31) + this.items.hashCode();
    }

    public String toString() {
        List<ShopTopItem> list = this.top;
        return "ShopInfo(top=" + list + ", items=" + this.items + ")";
    }

    public ShopInfo(List<ShopTopItem> top, List<ShopItem> items) {
        Intrinsics.checkNotNullParameter(top, "top");
        Intrinsics.checkNotNullParameter(items, "items");
        this.top = top;
        this.items = items;
    }

    public final List<ShopTopItem> getTop() {
        return this.top;
    }

    public final List<ShopItem> getItems() {
        return this.items;
    }
}
