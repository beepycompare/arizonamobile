package com.arkivanov.decompose.router.slot;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* compiled from: SlotNavigatorExt.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: classes3.dex */
public final class SlotNavigatorExtKt$dismiss$3 implements Function2 {
    final /* synthetic */ Function1<Boolean, Unit> $onComplete;

    /* JADX WARN: Multi-variable type inference failed */
    public SlotNavigatorExtKt$dismiss$3(Function1<? super Boolean, Unit> function1) {
        this.$onComplete = function1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        m8037invoke(obj, obj2);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: collision with other method in class */
    public final void m8037invoke(Object obj, Object obj2) {
        this.$onComplete.invoke(Boolean.valueOf(obj2 != null));
    }
}
