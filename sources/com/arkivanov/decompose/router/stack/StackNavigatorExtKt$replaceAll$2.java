package com.arkivanov.decompose.router.stack;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Add missing generic type declarations: [C] */
/* compiled from: StackNavigatorExt.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: classes3.dex */
public final class StackNavigatorExtKt$replaceAll$2<C> implements Function1<List<? extends C>, List<? extends C>> {
    final /* synthetic */ C[] $configurations;

    public StackNavigatorExtKt$replaceAll$2(C[] cArr) {
        this.$configurations = cArr;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((List) ((List) obj));
    }

    public final List<C> invoke(List<? extends C> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ArraysKt.toList(this.$configurations);
    }
}
