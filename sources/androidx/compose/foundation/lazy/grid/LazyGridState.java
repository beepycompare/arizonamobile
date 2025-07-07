package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollDeltaBetweenPasses;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
/* compiled from: LazyGridState.kt */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u0099\u00012\u00020\u0001:\u0002\u0099\u0001B\u001b\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B%\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\"\u0010u\u001a\u00020v2\b\b\u0001\u0010w\u001a\u00020\u00032\b\b\u0002\u0010x\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010yJ'\u0010z\u001a\u00020v2\u0006\u0010{\u001a\u00020\f2\u0006\u0010|\u001a\u00020\u00182\b\b\u0002\u0010}\u001a\u00020\u0018H\u0000¢\u0006\u0002\b~J\u0011\u0010\u007f\u001a\u00020k2\u0007\u0010\u0080\u0001\u001a\u00020kH\u0016J\u001a\u0010\u0081\u0001\u001a\u00020v2\u0007\u0010\u0080\u0001\u001a\u00020k2\u0006\u0010?\u001a\u00020@H\u0002J\u0018\u0010\u0082\u0001\u001a\u00020k2\u0007\u0010\u0083\u0001\u001a\u00020kH\u0000¢\u0006\u0003\b\u0084\u0001J\u001b\u0010\u0085\u0001\u001a\u00020v2\b\b\u0001\u0010w\u001a\u00020\u00032\b\b\u0002\u0010x\u001a\u00020\u0003JI\u0010\u0086\u0001\u001a\u00020v2\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012-\u0010\u0089\u0001\u001a(\b\u0001\u0012\u0005\u0012\u00030\u008b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020v0\u008c\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u008d\u00010\u008a\u0001¢\u0006\u0003\b\u008e\u0001H\u0096@¢\u0006\u0003\u0010\u008f\u0001J#\u0010\u0090\u0001\u001a\u00020v2\b\b\u0001\u0010w\u001a\u00020\u00032\b\b\u0002\u0010x\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010yJ(\u0010\u0091\u0001\u001a\u00020v2\u0006\u0010w\u001a\u00020\u00032\u0006\u0010x\u001a\u00020\u00032\u0007\u0010\u0092\u0001\u001a\u00020\u0018H\u0000¢\u0006\u0003\b\u0093\u0001J\"\u0010\u0094\u0001\u001a\u00020\u00032\b\u0010\u0095\u0001\u001a\u00030\u0096\u00012\u0007\u0010\u0097\u0001\u001a\u00020\u0003H\u0000¢\u0006\u0003\b\u0098\u0001R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R+\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\u00188V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR+\u0010 \u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\u00188V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u001f\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001dR\u0014\u0010$\u001a\u00020%8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0011\u0010\u0004\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b*\u0010)R\u001e\u0010+\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\u0018@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001bR\u0011\u0010-\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u000202X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u001bR\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020807X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u001bR\u0014\u0010=\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u001bR\u0011\u0010?\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020\f0DX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010E\u001a\u00020FX\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\bG\u0010HR\u001b\u0010I\u001a\u00020J8@X\u0080\u0084\u0002¢\u0006\f\u001a\u0004\bM\u0010N*\u0004\bK\u0010LR\u001e\u0010O\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bP\u0010)R\u0014\u0010Q\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bR\u0010)R\u0014\u0010S\u001a\u00020TX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u001c\u0010W\u001a\u00020FX\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\bX\u0010HR\u000e\u0010Y\u001a\u00020ZX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010[\u001a\u00020\\X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010_\u001a\u00020\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u001b\"\u0004\ba\u0010\u001dR\"\u0010c\u001a\u0004\u0018\u00010b2\b\u0010\u000b\u001a\u0004\u0018\u00010b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\u0014\u0010f\u001a\u00020gX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u0014\u0010j\u001a\u00020k8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR\u000e\u0010n\u001a\u00020oX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010p\u001a\u00020k2\u0006\u0010\u000b\u001a\u00020k@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bq\u0010mR\u000e\u0010r\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010s\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bt\u0010)\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u009a\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "firstVisibleItemIndex", "", "firstVisibleItemScrollOffset", "(II)V", "prefetchStrategy", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "(IILandroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;)V", "_lazyLayoutScrollDeltaBetweenPasses", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollDeltaBetweenPasses;", "<set-?>", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "approachLayoutInfo", "getApproachLayoutInfo$foundation_release", "()Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "", "canScrollBackward", "getCanScrollBackward", "()Z", "setCanScrollBackward", "(Z)V", "canScrollBackward$delegate", "Landroidx/compose/runtime/MutableState;", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "canScrollForward$delegate", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "getFirstVisibleItemIndex", "()I", "getFirstVisibleItemScrollOffset", "hasLookaheadOccurred", "getHasLookaheadOccurred$foundation_release", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isScrollInProgress", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "getItemAnimator$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "lastScrolledBackward", "getLastScrolledBackward", "lastScrolledForward", "getLastScrolledForward", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "measurementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "getMeasurementScopeInvalidator-zYiylxw$foundation_release", "()Landroidx/compose/runtime/MutableState;", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation_release$delegate", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;)Ljava/lang/Object;", "getNearestRange$foundation_release", "()Lkotlin/ranges/IntRange;", "numMeasurePasses", "getNumMeasurePasses$foundation_release", "numOfItemsToTeleport", "getNumOfItemsToTeleport", "pinnedItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedItems$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "placementScopeInvalidator", "getPlacementScopeInvalidator-zYiylxw$foundation_release", "prefetchScope", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation_release", "()Landroidx/compose/ui/layout/Remeasurement;", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "scrollDeltaBetweenPasses", "", "getScrollDeltaBetweenPasses$foundation_release", "()F", "scrollPosition", "Landroidx/compose/foundation/lazy/grid/LazyGridScrollPosition;", "scrollToBeConsumed", "getScrollToBeConsumed$foundation_release", "scrollableState", "slotsPerLine", "getSlotsPerLine$foundation_release", "animateScrollToItem", "", FirebaseAnalytics.Param.INDEX, "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyMeasureResult", "result", "isLookingAhead", "visibleItemsStayedTheSame", "applyMeasureResult$foundation_release", "dispatchRawDelta", "delta", "notifyPrefetchOnScroll", "onScroll", "distance", "onScroll$foundation_release", "requestScrollToItem", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToItem", "snapToItemIndexInternal", "forceRemeasure", "snapToItemIndexInternal$foundation_release", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "firstItemIndex", "updateScrollPositionIfTheFirstItemWasMoved$foundation_release", "Companion", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridState implements ScrollableState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final Saver<LazyGridState, ?> Saver = ListSaverKt.listSaver(new Function2<SaverScope, LazyGridState, List<? extends Integer>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final List<Integer> invoke(SaverScope saverScope, LazyGridState lazyGridState) {
            return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(lazyGridState.getFirstVisibleItemIndex()), Integer.valueOf(lazyGridState.getFirstVisibleItemScrollOffset())});
        }
    }, new Function1<List<? extends Integer>, LazyGridState>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ LazyGridState invoke(List<? extends Integer> list) {
            return invoke2((List<Integer>) list);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final LazyGridState invoke2(List<Integer> list) {
            return new LazyGridState(list.get(0).intValue(), list.get(1).intValue());
        }
    });
    private final LazyLayoutScrollDeltaBetweenPasses _lazyLayoutScrollDeltaBetweenPasses;
    private LazyGridMeasureResult approachLayoutInfo;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final MutableState canScrollBackward$delegate;
    private final MutableState canScrollForward$delegate;
    private boolean hasLookaheadOccurred;
    private final MutableInteractionSource internalInteractionSource;
    private final LazyLayoutItemAnimator<LazyGridMeasuredItem> itemAnimator;
    private final MutableState<LazyGridMeasureResult> layoutInfoState;
    private final MutableState<Unit> measurementScopeInvalidator;
    private int numMeasurePasses;
    private final LazyLayoutPinnedItemList pinnedItems;
    private final MutableState<Unit> placementScopeInvalidator;
    private final LazyGridPrefetchScope prefetchScope;
    private final LazyLayoutPrefetchState prefetchState;
    private final LazyGridPrefetchStrategy prefetchStrategy;
    private boolean prefetchingEnabled;
    private Remeasurement remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final LazyGridScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;

    public LazyGridState() {
        this(0, 0, null, 7, null);
    }

    public LazyGridState(final int i, int i2, LazyGridPrefetchStrategy lazyGridPrefetchStrategy) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        this.prefetchStrategy = lazyGridPrefetchStrategy;
        LazyGridScrollPosition lazyGridScrollPosition = new LazyGridScrollPosition(i, i2);
        this.scrollPosition = lazyGridScrollPosition;
        this.layoutInfoState = SnapshotStateKt.mutableStateOf(LazyGridStateKt.access$getEmptyLazyGridLayoutInfo$p(), SnapshotStateKt.neverEqualPolicy());
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.scrollableState = ScrollableStateKt.ScrollableState(new Function1<Float, Float>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$scrollableState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final Float invoke(float f) {
                return Float.valueOf(-LazyGridState.this.onScroll$foundation_release(-f));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Float invoke(Float f) {
                return invoke(f.floatValue());
            }
        });
        this.prefetchingEnabled = true;
        this.remeasurementModifier = new RemeasurementModifier() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$remeasurementModifier$1
            @Override // androidx.compose.ui.layout.RemeasurementModifier
            public void onRemeasurementAvailable(Remeasurement remeasurement) {
                LazyGridState.this.remeasurement = remeasurement;
            }
        };
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.itemAnimator = new LazyLayoutItemAnimator<>();
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.prefetchState = new LazyLayoutPrefetchState(lazyGridPrefetchStrategy.getPrefetchScheduler(), new Function1<NestedPrefetchScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$prefetchState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NestedPrefetchScope nestedPrefetchScope) {
                invoke2(nestedPrefetchScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(NestedPrefetchScope nestedPrefetchScope) {
                LazyGridPrefetchStrategy lazyGridPrefetchStrategy2;
                lazyGridPrefetchStrategy2 = LazyGridState.this.prefetchStrategy;
                int i3 = i;
                Snapshot.Companion companion = Snapshot.Companion;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                companion.restoreNonObservable(currentThreadSnapshot, companion.makeCurrentNonObservable(currentThreadSnapshot), currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null);
                lazyGridPrefetchStrategy2.onNestedPrefetch(nestedPrefetchScope, i3);
            }
        });
        this.prefetchScope = new LazyGridPrefetchScope() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$prefetchScope$1
            @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchScope
            public List<LazyLayoutPrefetchState.PrefetchHandle> scheduleLinePrefetch(int i3) {
                MutableState mutableState;
                LazyGridMeasureResult lazyGridMeasureResult;
                ArrayList arrayList = new ArrayList();
                Snapshot.Companion companion = Snapshot.Companion;
                LazyGridState lazyGridState = LazyGridState.this;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    if (!lazyGridState.getHasLookaheadOccurred$foundation_release()) {
                        mutableState = lazyGridState.layoutInfoState;
                        lazyGridMeasureResult = (LazyGridMeasureResult) mutableState.getValue();
                    } else {
                        lazyGridMeasureResult = lazyGridState.getApproachLayoutInfo$foundation_release();
                    }
                    if (lazyGridMeasureResult != null) {
                        List<Pair<Integer, Constraints>> invoke = lazyGridMeasureResult.getPrefetchInfoRetriever().invoke(Integer.valueOf(i3));
                        int size = invoke.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            Pair<Integer, Constraints> pair = invoke.get(i4);
                            arrayList.add(lazyGridState.getPrefetchState$foundation_release().m916schedulePrefetch0kLqBqw(pair.getFirst().intValue(), pair.getSecond().m6643unboximpl()));
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    return arrayList;
                } finally {
                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                }
            }
        };
        this.pinnedItems = new LazyLayoutPinnedItemList();
        lazyGridScrollPosition.getNearestRangeState();
        this.placementScopeInvalidator = ObservableScopeInvalidator.m921constructorimpl$default(null, 1, null);
        this.measurementScopeInvalidator = ObservableScopeInvalidator.m921constructorimpl$default(null, 1, null);
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.canScrollForward$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.canScrollBackward$delegate = mutableStateOf$default2;
        this._lazyLayoutScrollDeltaBetweenPasses = new LazyLayoutScrollDeltaBetweenPasses();
    }

    public /* synthetic */ LazyGridState(int i, int i2, LazyGridPrefetchStrategy lazyGridPrefetchStrategy, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? LazyGridPrefetchStrategyKt.LazyGridPrefetchStrategy$default(0, 1, null) : lazyGridPrefetchStrategy);
    }

    public /* synthetic */ LazyGridState(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public LazyGridState(int i, int i2) {
        this(i, i2, LazyGridPrefetchStrategyKt.LazyGridPrefetchStrategy$default(0, 1, null));
    }

    public final boolean getHasLookaheadOccurred$foundation_release() {
        return this.hasLookaheadOccurred;
    }

    public final LazyGridMeasureResult getApproachLayoutInfo$foundation_release() {
        return this.approachLayoutInfo;
    }

    public final int getFirstVisibleItemIndex() {
        return this.scrollPosition.getIndex();
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.scrollPosition.getScrollOffset();
    }

    public final LazyGridLayoutInfo getLayoutInfo() {
        return this.layoutInfoState.getValue();
    }

    public final InteractionSource getInteractionSource() {
        return this.internalInteractionSource;
    }

    public final MutableInteractionSource getInternalInteractionSource$foundation_release() {
        return this.internalInteractionSource;
    }

    public final float getScrollToBeConsumed$foundation_release() {
        return this.scrollToBeConsumed;
    }

    public final int getSlotsPerLine$foundation_release() {
        return this.layoutInfoState.getValue().getSlotsPerLine();
    }

    public final Density getDensity$foundation_release() {
        return this.layoutInfoState.getValue().getDensity();
    }

    public final int getNumMeasurePasses$foundation_release() {
        return this.numMeasurePasses;
    }

    public final boolean getPrefetchingEnabled$foundation_release() {
        return this.prefetchingEnabled;
    }

    public final void setPrefetchingEnabled$foundation_release(boolean z) {
        this.prefetchingEnabled = z;
    }

    public final Remeasurement getRemeasurement$foundation_release() {
        return this.remeasurement;
    }

    public final RemeasurementModifier getRemeasurementModifier$foundation_release() {
        return this.remeasurementModifier;
    }

    public final AwaitFirstLayoutModifier getAwaitLayoutModifier$foundation_release() {
        return this.awaitLayoutModifier;
    }

    public final LazyLayoutItemAnimator<LazyGridMeasuredItem> getItemAnimator$foundation_release() {
        return this.itemAnimator;
    }

    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo$foundation_release() {
        return this.beyondBoundsInfo;
    }

    public final LazyLayoutPrefetchState getPrefetchState$foundation_release() {
        return this.prefetchState;
    }

    public final LazyLayoutPinnedItemList getPinnedItems$foundation_release() {
        return this.pinnedItems;
    }

    public final IntRange getNearestRange$foundation_release() {
        return this.scrollPosition.getNearestRangeState().getValue();
    }

    /* renamed from: getPlacementScopeInvalidator-zYiylxw$foundation_release  reason: not valid java name */
    public final MutableState<Unit> m888getPlacementScopeInvalidatorzYiylxw$foundation_release() {
        return this.placementScopeInvalidator;
    }

    public static /* synthetic */ Object scrollToItem$default(LazyGridState lazyGridState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyGridState.scrollToItem(i, i2, continuation);
    }

    public final Object scrollToItem(int i, int i2, Continuation<? super Unit> continuation) {
        Object scroll$default = ScrollableState.scroll$default(this, null, new LazyGridState$scrollToItem$2(this, i, i2, null), continuation, 1, null);
        return scroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll$default : Unit.INSTANCE;
    }

    /* renamed from: getMeasurementScopeInvalidator-zYiylxw$foundation_release  reason: not valid java name */
    public final MutableState<Unit> m887getMeasurementScopeInvalidatorzYiylxw$foundation_release() {
        return this.measurementScopeInvalidator;
    }

    public static /* synthetic */ void requestScrollToItem$default(LazyGridState lazyGridState, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        lazyGridState.requestScrollToItem(i, i2);
    }

    public final void requestScrollToItem(int i, int i2) {
        if (isScrollInProgress()) {
            BuildersKt__Builders_commonKt.launch$default(this.layoutInfoState.getValue().getCoroutineScope(), null, null, new LazyGridState$requestScrollToItem$1(this, null), 3, null);
        }
        snapToItemIndexInternal$foundation_release(i, i2, false);
    }

    public final void snapToItemIndexInternal$foundation_release(int i, int i2, boolean z) {
        if (this.scrollPosition.getIndex() != i || this.scrollPosition.getScrollOffset() != i2) {
            this.itemAnimator.reset();
        }
        this.scrollPosition.requestPositionAndForgetLastKnownKey(i, i2);
        if (z) {
            Remeasurement remeasurement = this.remeasurement;
            if (remeasurement != null) {
                remeasurement.forceRemeasure();
                return;
            }
            return;
        }
        ObservableScopeInvalidator.m925invalidateScopeimpl(this.measurementScopeInvalidator);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006a, code lost:
        if (r8.scroll(r6, r7, r0) != r1) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        LazyGridState$scroll$1 lazyGridState$scroll$1;
        int i;
        LazyGridState lazyGridState;
        if (continuation instanceof LazyGridState$scroll$1) {
            lazyGridState$scroll$1 = (LazyGridState$scroll$1) continuation;
            if ((lazyGridState$scroll$1.label & Integer.MIN_VALUE) != 0) {
                lazyGridState$scroll$1.label -= Integer.MIN_VALUE;
                Object obj = lazyGridState$scroll$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = lazyGridState$scroll$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    AwaitFirstLayoutModifier awaitFirstLayoutModifier = this.awaitLayoutModifier;
                    lazyGridState$scroll$1.L$0 = this;
                    lazyGridState$scroll$1.L$1 = mutatePriority;
                    lazyGridState$scroll$1.L$2 = function2;
                    lazyGridState$scroll$1.label = 1;
                    if (awaitFirstLayoutModifier.waitForFirstLayout(lazyGridState$scroll$1) != coroutine_suspended) {
                        lazyGridState = this;
                    }
                    return coroutine_suspended;
                } else if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    function2 = (Function2) lazyGridState$scroll$1.L$2;
                    mutatePriority = (MutatePriority) lazyGridState$scroll$1.L$1;
                    lazyGridState = (LazyGridState) lazyGridState$scroll$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                ScrollableState scrollableState = lazyGridState.scrollableState;
                lazyGridState$scroll$1.L$0 = null;
                lazyGridState$scroll$1.L$1 = null;
                lazyGridState$scroll$1.L$2 = null;
                lazyGridState$scroll$1.label = 2;
            }
        }
        lazyGridState$scroll$1 = new LazyGridState$scroll$1(this, continuation);
        Object obj2 = lazyGridState$scroll$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = lazyGridState$scroll$1.label;
        if (i != 0) {
        }
        ScrollableState scrollableState2 = lazyGridState.scrollableState;
        lazyGridState$scroll$1.L$0 = null;
        lazyGridState$scroll$1.L$1 = null;
        lazyGridState$scroll$1.L$2 = null;
        lazyGridState$scroll$1.label = 2;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float f) {
        return this.scrollableState.dispatchRawDelta(f);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    private void setCanScrollForward(boolean z) {
        this.canScrollForward$delegate.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
    }

    private void setCanScrollBackward(boolean z) {
        this.canScrollBackward$delegate.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledForward() {
        return this.scrollableState.getLastScrolledForward();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledBackward() {
        return this.scrollableState.getLastScrolledBackward();
    }

    public final float onScroll$foundation_release(float f) {
        LazyGridMeasureResult lazyGridMeasureResult;
        if ((f >= 0.0f || getCanScrollForward()) && (f <= 0.0f || getCanScrollBackward())) {
            if (!(Math.abs(this.scrollToBeConsumed) <= 0.5f)) {
                InlineClassHelperKt.throwIllegalStateException("entered drag with non-zero pending scroll");
            }
            float f2 = this.scrollToBeConsumed + f;
            this.scrollToBeConsumed = f2;
            if (Math.abs(f2) > 0.5f) {
                float f3 = this.scrollToBeConsumed;
                int roundToInt = MathKt.roundToInt(f3);
                LazyGridMeasureResult copyWithScrollDeltaWithoutRemeasure = this.layoutInfoState.getValue().copyWithScrollDeltaWithoutRemeasure(roundToInt, !this.hasLookaheadOccurred);
                if (copyWithScrollDeltaWithoutRemeasure != null && (lazyGridMeasureResult = this.approachLayoutInfo) != null) {
                    LazyGridMeasureResult copyWithScrollDeltaWithoutRemeasure2 = lazyGridMeasureResult != null ? lazyGridMeasureResult.copyWithScrollDeltaWithoutRemeasure(roundToInt, true) : null;
                    if (copyWithScrollDeltaWithoutRemeasure2 != null) {
                        this.approachLayoutInfo = copyWithScrollDeltaWithoutRemeasure2;
                    } else {
                        copyWithScrollDeltaWithoutRemeasure = null;
                    }
                }
                if (copyWithScrollDeltaWithoutRemeasure != null) {
                    applyMeasureResult$foundation_release(copyWithScrollDeltaWithoutRemeasure, this.hasLookaheadOccurred, true);
                    ObservableScopeInvalidator.m925invalidateScopeimpl(this.placementScopeInvalidator);
                    notifyPrefetchOnScroll(f3 - this.scrollToBeConsumed, copyWithScrollDeltaWithoutRemeasure);
                } else {
                    Remeasurement remeasurement = this.remeasurement;
                    if (remeasurement != null) {
                        remeasurement.forceRemeasure();
                    }
                    notifyPrefetchOnScroll(f3 - this.scrollToBeConsumed, getLayoutInfo());
                }
            }
            if (Math.abs(this.scrollToBeConsumed) <= 0.5f) {
                return f;
            }
            float f4 = f - this.scrollToBeConsumed;
            this.scrollToBeConsumed = 0.0f;
            return f4;
        }
        return 0.0f;
    }

    private final void notifyPrefetchOnScroll(float f, LazyGridLayoutInfo lazyGridLayoutInfo) {
        if (this.prefetchingEnabled) {
            this.prefetchStrategy.onScroll(this.prefetchScope, f, lazyGridLayoutInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getNumOfItemsToTeleport() {
        return getSlotsPerLine$foundation_release() * 100;
    }

    public static /* synthetic */ Object animateScrollToItem$default(LazyGridState lazyGridState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyGridState.animateScrollToItem(i, i2, continuation);
    }

    public final Object animateScrollToItem(int i, int i2, Continuation<? super Unit> continuation) {
        Object scroll$default = ScrollableState.scroll$default(this, null, new LazyGridState$animateScrollToItem$2(this, i, i2, null), continuation, 1, null);
        return scroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll$default : Unit.INSTANCE;
    }

    public static /* synthetic */ void applyMeasureResult$foundation_release$default(LazyGridState lazyGridState, LazyGridMeasureResult lazyGridMeasureResult, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        lazyGridState.applyMeasureResult$foundation_release(lazyGridMeasureResult, z, z2);
    }

    public final void applyMeasureResult$foundation_release(LazyGridMeasureResult lazyGridMeasureResult, boolean z, boolean z2) {
        if (!z && this.hasLookaheadOccurred) {
            this.approachLayoutInfo = lazyGridMeasureResult;
            return;
        }
        if (z) {
            this.hasLookaheadOccurred = true;
        }
        this.scrollToBeConsumed -= lazyGridMeasureResult.getConsumedScroll();
        this.layoutInfoState.setValue(lazyGridMeasureResult);
        setCanScrollBackward(lazyGridMeasureResult.getCanScrollBackward());
        setCanScrollForward(lazyGridMeasureResult.getCanScrollForward());
        if (z2) {
            this.scrollPosition.updateScrollOffset(lazyGridMeasureResult.getFirstVisibleLineScrollOffset());
        } else {
            this.scrollPosition.updateFromMeasureResult(lazyGridMeasureResult);
            if (this.prefetchingEnabled) {
                this.prefetchStrategy.onVisibleItemsUpdated(this.prefetchScope, lazyGridMeasureResult);
            }
        }
        if (z) {
            this._lazyLayoutScrollDeltaBetweenPasses.updateScrollDeltaForApproach$foundation_release(lazyGridMeasureResult.getScrollBackAmount(), lazyGridMeasureResult.getDensity(), lazyGridMeasureResult.getCoroutineScope());
        }
        this.numMeasurePasses++;
    }

    public final float getScrollDeltaBetweenPasses$foundation_release() {
        return this._lazyLayoutScrollDeltaBetweenPasses.getScrollDeltaBetweenPasses$foundation_release();
    }

    public final int updateScrollPositionIfTheFirstItemWasMoved$foundation_release(LazyGridItemProvider lazyGridItemProvider, int i) {
        return this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(lazyGridItemProvider, i);
    }

    /* compiled from: LazyGridState.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\b\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u00042\u0006\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\b\u000bR\u001b\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "saver", "prefetchStrategy", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "saver$foundation_release", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<LazyGridState, ?> getSaver() {
            return LazyGridState.Saver;
        }

        public final Saver<LazyGridState, ?> saver$foundation_release(final LazyGridPrefetchStrategy lazyGridPrefetchStrategy) {
            return ListSaverKt.listSaver(new Function2<SaverScope, LazyGridState, List<? extends Integer>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$Companion$saver$3
                @Override // kotlin.jvm.functions.Function2
                public final List<Integer> invoke(SaverScope saverScope, LazyGridState lazyGridState) {
                    return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(lazyGridState.getFirstVisibleItemIndex()), Integer.valueOf(lazyGridState.getFirstVisibleItemScrollOffset())});
                }
            }, new Function1<List<? extends Integer>, LazyGridState>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$Companion$saver$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ LazyGridState invoke(List<? extends Integer> list) {
                    return invoke2((List<Integer>) list);
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final LazyGridState invoke2(List<Integer> list) {
                    return new LazyGridState(list.get(0).intValue(), list.get(1).intValue(), LazyGridPrefetchStrategy.this);
                }
            });
        }
    }
}
