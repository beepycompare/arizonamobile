package com.arkivanov.decompose.router.stack;

import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Add missing generic type declarations: [C] */
/* compiled from: StackNavigatorExt.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: classes3.dex */
public final class StackNavigatorExtKt$popWhile$2<C> implements Function1<List<? extends C>, List<? extends C>> {
    final /* synthetic */ Function1<C, Boolean> $predicate;

    /* JADX WARN: Multi-variable type inference failed */
    public StackNavigatorExtKt$popWhile$2(Function1<? super C, Boolean> function1) {
        this.$predicate = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((List) ((List) obj));
    }

    public final List<C> invoke(List<? extends C> stack) {
        List<C> emptyList;
        Intrinsics.checkNotNullParameter(stack, "stack");
        Function1<C, Boolean> function1 = this.$predicate;
        if (!stack.isEmpty()) {
            ListIterator<? extends C> listIterator = stack.listIterator(stack.size());
            while (listIterator.hasPrevious()) {
                if (!function1.invoke(listIterator.previous()).booleanValue()) {
                    emptyList = CollectionsKt.take(stack, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt.emptyList();
        if (emptyList.isEmpty()) {
            emptyList = null;
        }
        return emptyList == null ? CollectionsKt.take(stack, 1) : emptyList;
    }
}
