package com.arkivanov.decompose.router.items;

import com.arkivanov.decompose.router.items.ItemsController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [C] */
/* compiled from: ItemsController.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public /* synthetic */ class ItemsController$init$2<C> extends FunctionReferenceImpl implements Function1<ItemsController.NavEvent<C>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ItemsController$init$2(Object obj) {
        super(1, obj, ItemsController.class, "onEvent", "onEvent(Lcom/arkivanov/decompose/router/items/ItemsController$NavEvent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke((ItemsController.NavEvent) ((ItemsController.NavEvent) obj));
        return Unit.INSTANCE;
    }

    public final void invoke(ItemsController.NavEvent<C> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((ItemsController) this.receiver).onEvent(p0);
    }
}
