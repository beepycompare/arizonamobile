package com.arkivanov.decompose.router.items;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.router.items.Items;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ChildItems.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\n\b\u0001\u0010\u0003 \u0001*\u00020\u00022\u00020\u0002B9\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005HÆ\u0003J!\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\t0\b0\u0007HÆ\u0003JG\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\t0\b0\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR)\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/arkivanov/decompose/router/items/ChildItems;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "items", "", "activeItems", "", "Lkotlin/Pair;", "Lcom/arkivanov/decompose/router/items/Items$ActiveLifecycleState;", "<init>", "(Ljava/util/List;Ljava/util/Map;)V", "getItems", "()Ljava/util/List;", "getActiveItems", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ChildItems<C, T> {
    private final Map<C, Pair<T, Items.ActiveLifecycleState>> activeItems;
    private final List<C> items;

    public ChildItems() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChildItems copy$default(ChildItems childItems, List list, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            list = childItems.items;
        }
        if ((i & 2) != 0) {
            map = childItems.activeItems;
        }
        return childItems.copy(list, map);
    }

    public final List<C> component1() {
        return this.items;
    }

    public final Map<C, Pair<T, Items.ActiveLifecycleState>> component2() {
        return this.activeItems;
    }

    public final ChildItems<C, T> copy(List<? extends C> items, Map<C, ? extends Pair<? extends T, ? extends Items.ActiveLifecycleState>> activeItems) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(activeItems, "activeItems");
        return new ChildItems<>(items, activeItems);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChildItems) {
            ChildItems childItems = (ChildItems) obj;
            return Intrinsics.areEqual(this.items, childItems.items) && Intrinsics.areEqual(this.activeItems, childItems.activeItems);
        }
        return false;
    }

    public int hashCode() {
        return (this.items.hashCode() * 31) + this.activeItems.hashCode();
    }

    public String toString() {
        return "ChildItems(items=" + this.items + ", activeItems=" + this.activeItems + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChildItems(List<? extends C> items, Map<C, ? extends Pair<? extends T, ? extends Items.ActiveLifecycleState>> activeItems) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(activeItems, "activeItems");
        this.items = items;
        this.activeItems = activeItems;
    }

    public /* synthetic */ ChildItems(List list, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? MapsKt.emptyMap() : map);
    }

    public final List<C> getItems() {
        return this.items;
    }

    public final Map<C, Pair<T, Items.ActiveLifecycleState>> getActiveItems() {
        return this.activeItems;
    }
}
