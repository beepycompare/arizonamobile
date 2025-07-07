package com.arkivanov.decompose.router.slot;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Add missing generic type declarations: [C] */
/* compiled from: SlotNavigatorExt.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: classes3.dex */
public final class SlotNavigatorExtKt$activate$3<C> implements Function2<C, C, Unit> {
    final /* synthetic */ Function0<Unit> $onComplete;

    public SlotNavigatorExtKt$activate$3(Function0<Unit> function0) {
        this.$onComplete = function0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
        invoke2(obj, obj2);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(C c, C c2) {
        this.$onComplete.invoke();
    }
}
