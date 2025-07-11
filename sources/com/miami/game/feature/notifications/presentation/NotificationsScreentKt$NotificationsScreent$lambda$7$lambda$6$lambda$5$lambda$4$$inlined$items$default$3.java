package com.miami.game.feature.notifications.presentation;

import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
/* compiled from: LazyGridDsl.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "it", "", "invoke-_-orMbw", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;I)J", "androidx/compose/foundation/lazy/grid/LazyGridDslKt$items$3"}, k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NotificationsScreentKt$NotificationsScreent$lambda$7$lambda$6$lambda$5$lambda$4$$inlined$items$default$3 extends Lambda implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
    final /* synthetic */ List $items;
    final /* synthetic */ Function2 $span;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationsScreentKt$NotificationsScreent$lambda$7$lambda$6$lambda$5$lambda$4$$inlined$items$default$3(Function2 function2, List list) {
        super(2);
        this.$span = function2;
        this.$items = list;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope, Integer num) {
        return GridItemSpan.m859boximpl(m8400invoke_orMbw(lazyGridItemSpanScope, num.intValue()));
    }

    /* renamed from: invoke-_-orMbw  reason: not valid java name */
    public final long m8400invoke_orMbw(LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
        return ((GridItemSpan) this.$span.invoke(lazyGridItemSpanScope, this.$items.get(i))).m866unboximpl();
    }
}
