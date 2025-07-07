package com.arkivanov.decompose.router.stack;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Add missing generic type declarations: [C] */
/* compiled from: StackNavigatorExt.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: classes3.dex */
public final class StackNavigatorExtKt$pushToFront$3<C> implements Function2<List<? extends C>, List<? extends C>, Unit> {
    final /* synthetic */ Function0<Unit> $onComplete;

    public StackNavigatorExtKt$pushToFront$3(Function0<Unit> function0) {
        this.$onComplete = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
        invoke((List) ((List) obj), (List) ((List) obj2));
        return Unit.INSTANCE;
    }

    public final void invoke(List<? extends C> list, List<? extends C> list2) {
        Intrinsics.checkNotNullParameter(list, "<unused var>");
        Intrinsics.checkNotNullParameter(list2, "<unused var>");
        this.$onComplete.invoke();
    }
}
