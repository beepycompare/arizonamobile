package com.arkivanov.decompose.router.stack;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Add missing generic type declarations: [C] */
/* compiled from: StackNavigatorExt.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: classes3.dex */
public final class StackNavigatorExtKt$pushNew$3<C> implements Function2<List<? extends C>, List<? extends C>, Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $onComplete;

    /* JADX WARN: Multi-variable type inference failed */
    public StackNavigatorExtKt$pushNew$3(Function1<? super Boolean, Unit> function1) {
        this.$onComplete = function1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
        invoke((List) ((List) obj), (List) ((List) obj2));
        return Unit.INSTANCE;
    }

    public final void invoke(List<? extends C> newStack, List<? extends C> oldStack) {
        Intrinsics.checkNotNullParameter(newStack, "newStack");
        Intrinsics.checkNotNullParameter(oldStack, "oldStack");
        this.$onComplete.invoke(Boolean.valueOf(newStack.size() > oldStack.size()));
    }
}
