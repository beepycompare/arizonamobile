package com.arkivanov.decompose.router.pages;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
/* JADX INFO: Add missing generic type declarations: [C] */
/* compiled from: PagesNavigatorExt.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: classes3.dex */
public final class PagesNavigatorExtKt$setItems$1<C> implements Function1<Pages<? extends C>, Pages<? extends C>> {
    final /* synthetic */ Function1<List<? extends C>, List<C>> $items;

    /* JADX WARN: Multi-variable type inference failed */
    public PagesNavigatorExtKt$setItems$1(Function1<? super List<? extends C>, ? extends List<? extends C>> function1) {
        this.$items = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((Pages) ((Pages) obj));
    }

    public final Pages<C> invoke(Pages<? extends C> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        List<C> invoke = this.$items.invoke(it.getItems());
        List<C> list = invoke;
        return (Pages<? extends C>) it.copy(invoke, !list.isEmpty() ? RangesKt.coerceIn(it.getSelectedIndex(), (ClosedRange<Integer>) CollectionsKt.getIndices(list)) : -1);
    }
}
