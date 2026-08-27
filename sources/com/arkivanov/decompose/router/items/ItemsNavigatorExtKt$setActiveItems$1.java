package com.arkivanov.decompose.router.items;

import com.arkivanov.decompose.router.items.Items;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Add missing generic type declarations: [C] */
/* compiled from: ItemsNavigatorExt.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: classes4.dex */
public final class ItemsNavigatorExtKt$setActiveItems$1<C> implements Function1<Items<C>, Items<C>> {
    final /* synthetic */ Function1<Map<C, ? extends Items.ActiveLifecycleState>, Map<C, Items.ActiveLifecycleState>> $activeItems;

    /* JADX WARN: Multi-variable type inference failed */
    public ItemsNavigatorExtKt$setActiveItems$1(Function1<? super Map<C, ? extends Items.ActiveLifecycleState>, ? extends Map<C, ? extends Items.ActiveLifecycleState>> function1) {
        this.$activeItems = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((Items) ((Items) obj));
    }

    public final Items<C> invoke(Items<C> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Items.copy$default(it, null, this.$activeItems.invoke(it.getActiveItems()), 1, null);
    }
}
