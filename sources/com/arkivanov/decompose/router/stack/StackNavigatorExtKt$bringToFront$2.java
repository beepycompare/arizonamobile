package com.arkivanov.decompose.router.stack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Add missing generic type declarations: [C] */
/* compiled from: StackNavigatorExt.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: classes3.dex */
public final class StackNavigatorExtKt$bringToFront$2<C> implements Function1<List<? extends C>, List<? extends C>> {
    final /* synthetic */ C $configuration;

    public StackNavigatorExtKt$bringToFront$2(C c) {
        this.$configuration = c;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((List) ((List) obj));
    }

    public final List<C> invoke(List<? extends C> stack) {
        Intrinsics.checkNotNullParameter(stack, "stack");
        C c = this.$configuration;
        ArrayList arrayList = new ArrayList();
        for (Object obj : stack) {
            if (obj.getClass() != c.getClass()) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.plus((Collection<? extends C>) arrayList, this.$configuration);
    }
}
