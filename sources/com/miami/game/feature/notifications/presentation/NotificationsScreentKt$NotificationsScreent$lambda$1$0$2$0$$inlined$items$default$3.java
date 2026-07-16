package com.miami.game.feature.notifications.presentation;

import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
/* compiled from: LazyGridDsl.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationsScreentKt$NotificationsScreent$lambda$1$0$2$0$$inlined$items$default$3 implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
    final /* synthetic */ List $items;
    final /* synthetic */ Function2 $span;

    public NotificationsScreentKt$NotificationsScreent$lambda$1$0$2$0$$inlined$items$default$3(Function2 function2, List list) {
        this.$span = function2;
        this.$items = list;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope, Integer num) {
        return GridItemSpan.m1191boximpl(m9815invoke_orMbw(lazyGridItemSpanScope, num.intValue()));
    }

    /* renamed from: invoke-_-orMbw  reason: not valid java name */
    public final long m9815invoke_orMbw(LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
        return ((GridItemSpan) this.$span.invoke(lazyGridItemSpanScope, this.$items.get(i))).m1198unboximpl();
    }
}
