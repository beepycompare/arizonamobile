package androidx.compose.foundation.lazy.grid;

import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: LazyGridIntervalContent.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 22\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00012B\u001e\u0012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\bJZ\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0019\u0010 \u001a\u0015\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0018\u00010\u0005¢\u0006\u0002\b\u00072\b\u0010#\u001a\u0004\u0018\u00010\u001f2\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b%¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u0010&J³\u0001\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)2#\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110)¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00052\u001f\u0010 \u001a\u001b\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"\u0018\u00010-¢\u0006\u0002\b\u00072#\u0010#\u001a\u001f\u0012\u0013\u0012\u00110)¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u000521\u0010.\u001a-\u0012\u0004\u0012\u00020$\u0012\u0013\u0012\u00110)¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00060-¢\u0006\u0002\b%¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u0010/JE\u00100\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010#\u001a\u0004\u0018\u00010\u001f2\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00060-¢\u0006\u0002\b%¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u00101R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u00063"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Landroidx/compose/foundation/lazy/grid/LazyGridInterval;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "_headerIndexes", "Landroidx/collection/MutableIntList;", "hasCustomSpans", "", "getHasCustomSpans$foundation_release", "()Z", "setHasCustomSpans$foundation_release", "(Z)V", "headerIndexes", "Landroidx/collection/IntList;", "getHeaderIndexes", "()Landroidx/collection/IntList;", "intervals", "Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "getSpanLayoutProvider$foundation_release", "()Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "item", "key", "", TtmlNode.TAG_SPAN, "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "contentType", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", FirebaseAnalytics.Param.ITEMS, "count", "", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "Lkotlin/Function2;", "itemContent", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "stickyHeader", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)V", "Companion", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridIntervalContent extends LazyLayoutIntervalContent<LazyGridInterval> implements LazyGridScope {
    private MutableIntList _headerIndexes;
    private boolean hasCustomSpans;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Function2<LazyGridItemSpanScope, Integer, GridItemSpan> DefaultSpan = new Function2<LazyGridItemSpanScope, Integer, GridItemSpan>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridIntervalContent$Companion$DefaultSpan$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope, Integer num) {
            return GridItemSpan.m859boximpl(m874invoke_orMbw(lazyGridItemSpanScope, num.intValue()));
        }

        /* renamed from: invoke-_-orMbw  reason: not valid java name */
        public final long m874invoke_orMbw(LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
            return LazyGridSpanKt.GridItemSpan(1);
        }
    };
    private final LazyGridSpanLayoutProvider spanLayoutProvider = new LazyGridSpanLayoutProvider(this);
    private final MutableIntervalList<LazyGridInterval> intervals = new MutableIntervalList<>();

    public LazyGridIntervalContent(Function1<? super LazyGridScope, Unit> function1) {
        function1.invoke(this);
    }

    public final LazyGridSpanLayoutProvider getSpanLayoutProvider$foundation_release() {
        return this.spanLayoutProvider;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent
    public IntervalList<LazyGridInterval> getIntervals() {
        return this.intervals;
    }

    public final boolean getHasCustomSpans$foundation_release() {
        return this.hasCustomSpans;
    }

    public final void setHasCustomSpans$foundation_release(boolean z) {
        this.hasCustomSpans = z;
    }

    public final IntList getHeaderIndexes() {
        MutableIntList mutableIntList = this._headerIndexes;
        return mutableIntList != null ? mutableIntList : IntListKt.emptyIntList();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.foundation.lazy.layout.MutableIntervalList] */
    @Override // androidx.compose.foundation.lazy.grid.LazyGridScope
    public void item(final Object obj, final Function1<? super LazyGridItemSpanScope, GridItemSpan> function1, final Object obj2, final Function3<? super LazyGridItemScope, ? super Composer, ? super Integer, Unit> function3) {
        getIntervals().addInterval(1, new LazyGridInterval(obj != null ? new Function1<Integer, Object>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridIntervalContent$item$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Object invoke(int i) {
                return obj;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }
        } : null, function1 != null ? new Function2<LazyGridItemSpanScope, Integer, GridItemSpan>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridIntervalContent$item$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope, Integer num) {
                return GridItemSpan.m859boximpl(m875invoke_orMbw(lazyGridItemSpanScope, num.intValue()));
            }

            /* renamed from: invoke-_-orMbw  reason: not valid java name */
            public final long m875invoke_orMbw(LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
                return function1.invoke(lazyGridItemSpanScope).m866unboximpl();
            }
        } : DefaultSpan, new Function1<Integer, Object>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridIntervalContent$item$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return obj2;
            }
        }, ComposableLambdaKt.composableLambdaInstance(-34608120, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridIntervalContent$item$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyGridItemScope lazyGridItemScope, int i, Composer composer, int i2) {
                ComposerKt.sourceInformation(composer, "C55@1984L9:LazyGridIntervalContent.kt#7791vq");
                if ((i2 & 6) == 0) {
                    i2 |= composer.changed(lazyGridItemScope) ? 4 : 2;
                }
                if (!composer.shouldExecute((i2 & 131) != 130, i2 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-34608120, i2, -1, "androidx.compose.foundation.lazy.grid.LazyGridIntervalContent.item.<anonymous> (LazyGridIntervalContent.kt:55)");
                }
                function3.invoke(lazyGridItemScope, composer, Integer.valueOf(i2 & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        })));
        if (function1 != null) {
            this.hasCustomSpans = true;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.foundation.lazy.layout.MutableIntervalList] */
    @Override // androidx.compose.foundation.lazy.grid.LazyGridScope
    public void items(int i, Function1<? super Integer, ? extends Object> function1, Function2<? super LazyGridItemSpanScope, ? super Integer, GridItemSpan> function2, Function1<? super Integer, ? extends Object> function12, Function4<? super LazyGridItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4) {
        getIntervals().addInterval(i, new LazyGridInterval(function1, function2 == null ? DefaultSpan : function2, function12, function4));
        if (function2 != null) {
            this.hasCustomSpans = true;
        }
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridScope
    public void stickyHeader(Object obj, Object obj2, final Function4<? super LazyGridItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4) {
        MutableIntList mutableIntList = this._headerIndexes;
        if (mutableIntList == null) {
            mutableIntList = new MutableIntList(0, 1, null);
            this._headerIndexes = mutableIntList;
        }
        final int size = getIntervals().getSize();
        mutableIntList.add(size);
        item(obj, new Function1<LazyGridItemSpanScope, GridItemSpan>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridIntervalContent$stickyHeader$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope) {
                return GridItemSpan.m859boximpl(m876invokeBHJflc(lazyGridItemSpanScope));
            }

            /* renamed from: invoke-BHJ-flc  reason: not valid java name */
            public final long m876invokeBHJflc(LazyGridItemSpanScope lazyGridItemSpanScope) {
                return LazyGridSpanKt.GridItemSpan(lazyGridItemSpanScope.getMaxLineSpan());
            }
        }, obj2, ComposableLambdaKt.composableLambdaInstance(2045010142, true, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridIntervalContent$stickyHeader$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
                invoke(lazyGridItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyGridItemScope lazyGridItemScope, Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C88@3036L25:LazyGridIntervalContent.kt#7791vq");
                if ((i & 6) == 0) {
                    i |= composer.changed(lazyGridItemScope) ? 4 : 2;
                }
                if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2045010142, i, -1, "androidx.compose.foundation.lazy.grid.LazyGridIntervalContent.stickyHeader.<anonymous> (LazyGridIntervalContent.kt:88)");
                }
                function4.invoke(lazyGridItemScope, Integer.valueOf(size), composer, Integer.valueOf(i & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    /* compiled from: LazyGridIntervalContent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R(\u0010\u0003\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\b\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent$Companion;", "", "()V", "DefaultSpan", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "Lkotlin/ExtensionFunctionType;", "getDefaultSpan", "()Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function2<LazyGridItemSpanScope, Integer, GridItemSpan> getDefaultSpan() {
            return LazyGridIntervalContent.DefaultSpan;
        }
    }
}
