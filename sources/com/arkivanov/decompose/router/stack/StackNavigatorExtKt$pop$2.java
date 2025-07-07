package com.arkivanov.decompose.router.stack;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Add missing generic type declarations: [C] */
/* compiled from: StackNavigatorExt.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: classes3.dex */
public final class StackNavigatorExtKt$pop$2<C> implements Function1<List<? extends C>, List<? extends C>> {
    public static final StackNavigatorExtKt$pop$2 INSTANCE = new StackNavigatorExtKt$pop$2();

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((List) ((List) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<C> invoke(List<? extends C> stack) {
        List<C> dropLast;
        Intrinsics.checkNotNullParameter(stack, "stack");
        List list = stack.size() > 1 ? stack : null;
        return (list == null || (dropLast = CollectionsKt.dropLast(list, 1)) == null) ? stack : dropLast;
    }
}
