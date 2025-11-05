package com.arkivanov.decompose.router.items;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Add missing generic type declarations: [C] */
/* compiled from: ItemsNavigatorExt.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: classes3.dex */
public final class ItemsNavigatorExtKt$setActiveItems$$inlined$setActiveItems$1<C> implements Function2<Items<C>, Items<C>, Unit> {
    public final void invoke(Items<C> newItems, Items<C> oldItems) {
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        Intrinsics.checkNotNullParameter(oldItems, "oldItems");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
        invoke((Items) ((Items) obj), (Items) ((Items) obj2));
        return Unit.INSTANCE;
    }
}
