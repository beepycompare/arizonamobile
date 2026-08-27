package com.arkivanov.decompose.router.slot;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* compiled from: SlotNavigatorExt.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: classes4.dex */
public final class SlotNavigatorExtKt$dismiss$3 implements Function2<Object, Object, Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $onComplete;

    /* JADX WARN: Multi-variable type inference failed */
    public SlotNavigatorExtKt$dismiss$3(Function1<? super Boolean, Unit> function1) {
        this.$onComplete = function1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
        invoke2(obj, obj2);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Object obj, Object obj2) {
        this.$onComplete.invoke(Boolean.valueOf(obj2 != null));
    }
}
