package com.miami.game.feature.select.server.ui.compose;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
/* compiled from: LazyGridDsl.kt */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectServerScreenKt$SelectServerScreen$lambda$1$0$2$0$0$$inlined$items$default$2 implements Function1<Integer, Object> {
    final /* synthetic */ List $items;
    final /* synthetic */ Function1 $key;

    public SelectServerScreenKt$SelectServerScreen$lambda$1$0$2$0$0$$inlined$items$default$2(Function1 function1, List list) {
        this.$key = function1;
        this.$items = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final Object invoke(int i) {
        return this.$key.invoke(this.$items.get(i));
    }
}
