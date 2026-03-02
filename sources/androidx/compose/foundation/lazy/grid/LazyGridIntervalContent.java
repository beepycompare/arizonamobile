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
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 32\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00013B \u0012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¢\u0006\u0004\b\b\u0010\tJZ\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0019\u0010!\u001a\u0015\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0018\u00010\u0005¢\u0006\u0002\b\u00072\b\u0010$\u001a\u0004\u0018\u00010 2\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b&¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u0010'J³\u0001\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*2#\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020 \u0018\u00010\u00052\u001f\u0010!\u001a\u001b\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020#\u0018\u00010.¢\u0006\u0002\b\u00072#\u0010$\u001a\u001f\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0006\u0012\u0004\u0018\u00010 0\u000521\u0010/\u001a-\u0012\u0004\u0012\u00020%\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00060.¢\u0006\u0002\b&¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u00100JE\u00101\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010$\u001a\u0004\u0018\u00010 2\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00060.¢\u0006\u0002\b&¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0002\u00102R\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u00064"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Landroidx/compose/foundation/lazy/grid/LazyGridInterval;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "getSpanLayoutProvider$foundation", "()Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "intervals", "Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "hasCustomSpans", "", "getHasCustomSpans$foundation", "()Z", "setHasCustomSpans$foundation", "(Z)V", "_headerIndexes", "Landroidx/collection/MutableIntList;", "headerIndexes", "Landroidx/collection/IntList;", "getHeaderIndexes", "()Landroidx/collection/IntList;", "item", "key", "", TtmlNode.TAG_SPAN, "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "contentType", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "items", "count", "", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "Lkotlin/Function2;", "itemContent", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "stickyHeader", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)V", "Companion", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridIntervalContent extends LazyLayoutIntervalContent<LazyGridInterval> implements LazyGridScope {
    private MutableIntList _headerIndexes;
    private boolean hasCustomSpans;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Function2<LazyGridItemSpanScope, Integer, GridItemSpan> DefaultSpan = new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridIntervalContent$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            GridItemSpan m938boximpl;
            LazyGridItemSpanScope lazyGridItemSpanScope = (LazyGridItemSpanScope) obj;
            ((Integer) obj2).intValue();
            m938boximpl = GridItemSpan.m938boximpl(LazyGridSpanKt.GridItemSpan(1));
            return m938boximpl;
        }
    };
    private final LazyGridSpanLayoutProvider spanLayoutProvider = new LazyGridSpanLayoutProvider(this);
    private final MutableIntervalList<LazyGridInterval> intervals = new MutableIntervalList<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object item$lambda$0$0(Object obj, int i) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object item$lambda$2(Object obj, int i) {
        return obj;
    }

    public LazyGridIntervalContent(Function1<? super LazyGridScope, Unit> function1) {
        function1.invoke(this);
    }

    public final LazyGridSpanLayoutProvider getSpanLayoutProvider$foundation() {
        return this.spanLayoutProvider;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent
    public IntervalList<LazyGridInterval> getIntervals() {
        return this.intervals;
    }

    public final boolean getHasCustomSpans$foundation() {
        return this.hasCustomSpans;
    }

    public final void setHasCustomSpans$foundation(boolean z) {
        this.hasCustomSpans = z;
    }

    public final IntList getHeaderIndexes() {
        MutableIntList mutableIntList = this._headerIndexes;
        return mutableIntList != null ? mutableIntList : IntListKt.emptyIntList();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.foundation.lazy.layout.MutableIntervalList] */
    @Override // androidx.compose.foundation.lazy.grid.LazyGridScope
    public void item(final Object obj, final Function1<? super LazyGridItemSpanScope, GridItemSpan> function1, final Object obj2, final Function3<? super LazyGridItemScope, ? super Composer, ? super Integer, Unit> function3) {
        getIntervals().addInterval(1, new LazyGridInterval(obj != null ? new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridIntervalContent$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                Object item$lambda$0$0;
                item$lambda$0$0 = LazyGridIntervalContent.item$lambda$0$0(obj, ((Integer) obj3).intValue());
                return item$lambda$0$0;
            }
        } : null, function1 != null ? new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridIntervalContent$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj3, Object obj4) {
                GridItemSpan item$lambda$1$0;
                item$lambda$1$0 = LazyGridIntervalContent.item$lambda$1$0(Function1.this, (LazyGridItemSpanScope) obj3, ((Integer) obj4).intValue());
                return item$lambda$1$0;
            }
        } : DefaultSpan, new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridIntervalContent$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                return LazyGridIntervalContent.item$lambda$2(obj2, ((Integer) obj3).intValue());
            }
        }, ComposableLambdaKt.composableLambdaInstance(-291643851, true, new Function4() { // from class: androidx.compose.foundation.lazy.grid.LazyGridIntervalContent$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj3, Object obj4, Object obj5, Object obj6) {
                return LazyGridIntervalContent.item$lambda$3(Function3.this, (LazyGridItemScope) obj3, ((Integer) obj4).intValue(), (Composer) obj5, ((Integer) obj6).intValue());
            }
        })));
        if (function1 != null) {
            this.hasCustomSpans = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GridItemSpan item$lambda$1$0(Function1 function1, LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
        return (GridItemSpan) function1.invoke(lazyGridItemSpanScope);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit item$lambda$3(Function3 function3, LazyGridItemScope lazyGridItemScope, int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "CN(it)55@1985L9:LazyGridIntervalContent.kt#7791vq");
        if ((i2 & 6) == 0) {
            i2 |= composer.changed(lazyGridItemScope) ? 4 : 2;
        }
        if (composer.shouldExecute((i2 & 131) != 130, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-291643851, i2, -1, "androidx.compose.foundation.lazy.grid.LazyGridIntervalContent.item.<anonymous> (LazyGridIntervalContent.kt:55)");
            }
            function3.invoke(lazyGridItemScope, composer, Integer.valueOf(i2 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
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
        item(obj, new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridIntervalContent$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                GridItemSpan m938boximpl;
                m938boximpl = GridItemSpan.m938boximpl(LazyGridSpanKt.GridItemSpan(((LazyGridItemSpanScope) obj3).getMaxLineSpan()));
                return m938boximpl;
            }
        }, obj2, ComposableLambdaKt.composableLambdaInstance(46791243, true, new Function3() { // from class: androidx.compose.foundation.lazy.grid.LazyGridIntervalContent$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                return LazyGridIntervalContent.stickyHeader$lambda$2(Function4.this, size, (LazyGridItemScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit stickyHeader$lambda$2(Function4 function4, int i, LazyGridItemScope lazyGridItemScope, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C88@3043L25:LazyGridIntervalContent.kt#7791vq");
        if ((i2 & 6) == 0) {
            i2 |= composer.changed(lazyGridItemScope) ? 4 : 2;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(46791243, i2, -1, "androidx.compose.foundation.lazy.grid.LazyGridIntervalContent.stickyHeader.<anonymous> (LazyGridIntervalContent.kt:88)");
            }
            function4.invoke(lazyGridItemScope, Integer.valueOf(i), composer, Integer.valueOf(i2 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* compiled from: LazyGridIntervalContent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0004\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent$Companion;", "", "<init>", "()V", "DefaultSpan", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "Lkotlin/ExtensionFunctionType;", "getDefaultSpan", "()Lkotlin/jvm/functions/Function2;", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
