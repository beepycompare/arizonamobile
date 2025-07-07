package com.arkivanov.decompose.router.slot;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
/* JADX INFO: Add missing generic type declarations: [C] */
/* compiled from: SlotNavigatorExt.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: classes3.dex */
public final class SlotNavigatorExtKt$activate$2<C> implements Function1<C, C> {
    final /* synthetic */ C $configuration;

    public SlotNavigatorExtKt$activate$2(C c) {
        this.$configuration = c;
    }

    @Override // kotlin.jvm.functions.Function1
    public final C invoke(C c) {
        return this.$configuration;
    }
}
