package com.arkivanov.decompose.router.items;

import com.arkivanov.decompose.router.items.Items;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Add missing generic type declarations: [C] */
/* compiled from: ItemsNavigatorExt.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: classes3.dex */
public final class ItemsNavigatorExtKt$setItems$1<C> implements Function1<Items<C>, Items<C>> {
    final /* synthetic */ Function1<List<? extends C>, List<C>> $items;

    /* JADX WARN: Multi-variable type inference failed */
    public ItemsNavigatorExtKt$setItems$1(Function1<? super List<? extends C>, ? extends List<? extends C>> function1) {
        this.$items = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((Items) ((Items) obj));
    }

    public final Items<C> invoke(Items<C> oldItems) {
        Intrinsics.checkNotNullParameter(oldItems, "oldItems");
        List<C> invoke = this.$items.invoke(oldItems.getItems());
        Map<C, ? extends Items.ActiveLifecycleState> mutableMap = MapsKt.toMutableMap(oldItems.getActiveItems());
        mutableMap.keySet().retainAll(CollectionsKt.toSet(invoke));
        Unit unit = Unit.INSTANCE;
        return oldItems.copy(invoke, mutableMap);
    }
}
