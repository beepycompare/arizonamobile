package androidx.compose.animation;

import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: SharedTransitionScope.kt */
@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002:\u0001~B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u001e\u001a\u00020\u001f*\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120\u000bH\u0016J\"\u0010!\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bH\u0016JD\u0010%\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#2\u0006\u0010/\u001a\u000200H\u0016J\\\u00101\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u0010*\u001a\u00020+2\u0006\u00106\u001a\u0002072\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#2\u0006\u0010/\u001a\u000200H\u0016JD\u00108\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010&\u001a\u00020'2\u0006\u00109\u001a\u00020\u00122\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#2\u0006\u0010/\u001a\u000200H\u0016JS\u0010:\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010&\u001a\u00020'2\u0006\u00109\u001a\u00020\u00122\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010/\u001a\u000200H\u0000¢\u0006\u0002\b;J\u0010\u0010<\u001a\u0002002\u0006\u0010=\u001a\u00020>H\u0016J\r\u0010A\u001a\u00020\fH\u0000¢\u0006\u0002\bBJp\u0010C\u001a\u00020\u001f\"\u0004\b\u0000\u0010D*\u00020\u001f2\u0006\u0010&\u001a\u00020'2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u0002HD\u0018\u00010F2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u00020\u00120G2\u0006\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-2\u0006\u0010H\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#2\u0006\u0010/\u001a\u000200H\u0002JM\u0010I\u001a\u00020J2\u0006\u0010%\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\u0006\u0010,\u001a\u00020-2\u0006\u0010H\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'2\u0006\u0010/\u001a\u0002002\u0006\u0010\"\u001a\u00020#2\u0006\u0010.\u001a\u00020\u0012H\u0003¢\u0006\u0002\u0010NJ\u0010\u0010b\u001a\u00020K2\u0006\u0010c\u001a\u00020aH\u0002J\u0015\u0010d\u001a\u00020\f2\u0006\u0010e\u001a\u00020fH\u0000¢\u0006\u0002\bgJ\u0015\u0010h\u001a\u00020\f2\u0006\u0010i\u001a\u00020JH\u0000¢\u0006\u0002\bjJ\u0015\u0010k\u001a\u00020\f2\u0006\u0010i\u001a\u00020JH\u0000¢\u0006\u0002\blJ\u0015\u0010m\u001a\u00020\f2\u0006\u0010n\u001a\u00020^H\u0000¢\u0006\u0002\boJ\u0015\u0010p\u001a\u00020\f2\u0006\u0010n\u001a\u00020^H\u0000¢\u0006\u0002\bqJ,\u0010r\u001a\u00020s*\u00020P2\u0006\u0010t\u001a\u00020P2\u0006\u0010u\u001a\u00020s2\u0006\u0010v\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\bw\u0010xJ\r\u0010y\u001a\u00020P*\u00020PH\u0096\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R,\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u000eR$\u0010Q\u001a\u00020P2\u0006\u0010O\u001a\u00020P8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010V\u001a\u0004\u0018\u00010P2\b\u0010O\u001a\u0004\u0018\u00010P@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bW\u0010SR$\u0010X\u001a\u00020P2\u0006\u0010O\u001a\u00020P8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\bY\u0010S\"\u0004\bZ\u0010UR\u0010\u0010[\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\\\u001a\b\u0012\u0004\u0012\u00020^0]X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010_\u001a\u000e\u0012\u0004\u0012\u00020a\u0012\u0004\u0012\u00020K0`X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010z\u001a\u00020P*\u00020{X\u0096\u0005¢\u0006\u0006\u001a\u0004\b|\u0010}¨\u0006\u007f"}, d2 = {"Landroidx/compose/animation/SharedTransitionScopeImpl;", "Landroidx/compose/animation/SharedTransitionScope;", "Landroidx/compose/ui/layout/LookaheadScope;", "lookaheadScope", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroidx/compose/ui/layout/LookaheadScope;Lkotlinx/coroutines/CoroutineScope;)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "invalidateOverlay", "Lkotlin/Function0;", "", "getInvalidateOverlay", "()Lkotlin/jvm/functions/Function0;", "setInvalidateOverlay", "(Lkotlin/jvm/functions/Function0;)V", "<set-?>", "", "isTransitionActive", "()Z", "setTransitionActive", "(Z)V", "isTransitionActive$delegate", "Landroidx/compose/runtime/MutableState;", "testBlockToRun", "getTestBlockToRun$annotations", "()V", "getTestBlockToRun", "setTestBlockToRun", "skipToLookaheadSize", "Landroidx/compose/ui/Modifier;", "enabled", "renderInSharedTransitionScopeOverlay", "zIndexInOverlay", "", "renderInOverlay", "sharedElement", "sharedContentState", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "animatedVisibilityScope", "Landroidx/compose/animation/AnimatedVisibilityScope;", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "placeholderSize", "Landroidx/compose/animation/SharedTransitionScope$PlaceholderSize;", "renderInOverlayDuringTransition", "clipInOverlayDuringTransition", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "sharedBounds", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "resizeMode", "Landroidx/compose/animation/SharedTransitionScope$ResizeMode;", "sharedElementWithCallerManagedVisibility", "visible", "sharedBoundsWithCallerManagedVisibility", "sharedBoundsWithCallerManagedVisibility$animation", "OverlayClip", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "observeAnimatingBlock", "getObserveAnimatingBlock$animation", "updateTransitionActiveness", "updateTransitionActiveness$animation", "sharedBoundsImpl", ExifInterface.GPS_DIRECTION_TRUE, "parentTransition", "Landroidx/compose/animation/core/Transition;", "Lkotlin/Function1;", "renderOnlyWhenVisible", "rememberSharedElementState", "Landroidx/compose/animation/SharedElementEntry;", "Landroidx/compose/animation/SharedElement;", "boundsAnimation", "Landroidx/compose/animation/BoundsAnimation;", "(Landroidx/compose/animation/SharedElement;Landroidx/compose/animation/BoundsAnimation;Landroidx/compose/animation/SharedTransitionScope$PlaceholderSize;ZLandroidx/compose/animation/SharedTransitionScope$SharedContentState;Landroidx/compose/animation/SharedTransitionScope$OverlayClip;FZLandroidx/compose/runtime/Composer;I)Landroidx/compose/animation/SharedElementEntry;", "value", "Landroidx/compose/ui/layout/LayoutCoordinates;", "root", "getRoot$animation", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setRoot$animation", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "nullableRoot", "getNullableRoot$animation", "lookaheadRoot", "getLookaheadRoot$animation", "setLookaheadRoot$animation", "_nullableLookaheadRoot", "renderers", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/animation/LayerRenderer;", "sharedElements", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "", "sharedElementsFor", "key", "drawInOverlay", "scope", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawInOverlay$animation", "onEntryRemoved", "sharedElementState", "onEntryRemoved$animation", "onEntryAdded", "onEntryAdded$animation", "onLayerRendererCreated", "renderer", "onLayerRendererCreated$animation", "onLayerRendererRemoved", "onLayerRendererRemoved$animation", "localLookaheadPositionOf", "Landroidx/compose/ui/geometry/Offset;", "sourceCoordinates", "relativeToSource", "includeMotionFrameOfReference", "localLookaheadPositionOf-au-aQtc", "(Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "toLookaheadCoordinates", "lookaheadScopeCoordinates", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getLookaheadScopeCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Landroidx/compose/ui/layout/LayoutCoordinates;", "ShapeBasedClip", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SharedTransitionScopeImpl implements SharedTransitionScope, LookaheadScope {
    public static final int $stable = 0;
    private final /* synthetic */ LookaheadScope $$delegate_0;
    private LayoutCoordinates _nullableLookaheadRoot;
    private final CoroutineScope coroutineScope;
    private Function0<Unit> invalidateOverlay;
    private final MutableState isTransitionActive$delegate;
    private LayoutCoordinates nullableRoot;
    private final Function0<Unit> observeAnimatingBlock;
    private final SnapshotStateList<LayerRenderer> renderers;
    private final SnapshotStateMap<Object, SharedElement> sharedElements;
    private Function0<Unit> testBlockToRun;

    public static /* synthetic */ void getTestBlockToRun$annotations() {
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    public LayoutCoordinates getLookaheadScopeCoordinates(Placeable.PlacementScope placementScope) {
        return this.$$delegate_0.getLookaheadScopeCoordinates(placementScope);
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    /* renamed from: localLookaheadPositionOf-au-aQtc  reason: not valid java name */
    public long mo128localLookaheadPositionOfauaQtc(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, long j, boolean z) {
        return this.$$delegate_0.mo128localLookaheadPositionOfauaQtc(layoutCoordinates, layoutCoordinates2, j, z);
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    public LayoutCoordinates toLookaheadCoordinates(LayoutCoordinates layoutCoordinates) {
        return this.$$delegate_0.toLookaheadCoordinates(layoutCoordinates);
    }

    public SharedTransitionScopeImpl(LookaheadScope lookaheadScope, CoroutineScope coroutineScope) {
        MutableState mutableStateOf$default;
        this.$$delegate_0 = lookaheadScope;
        this.coroutineScope = coroutineScope;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.isTransitionActive$delegate = mutableStateOf$default;
        this.observeAnimatingBlock = new Function0<Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$observeAnimatingBlock$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SnapshotStateMap snapshotStateMap;
                snapshotStateMap = SharedTransitionScopeImpl.this.sharedElements;
                SnapshotStateMap snapshotStateMap2 = snapshotStateMap;
                if (snapshotStateMap2.isEmpty()) {
                    return;
                }
                Iterator it = snapshotStateMap2.entrySet().iterator();
                while (it.hasNext() && !((SharedElement) ((Map.Entry) it.next()).getValue()).isAnimating()) {
                }
            }
        };
        this.renderers = SnapshotStateKt.mutableStateListOf();
        this.sharedElements = SnapshotStateKt.mutableStateMapOf();
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final Function0<Unit> getInvalidateOverlay() {
        return this.invalidateOverlay;
    }

    public final void setInvalidateOverlay(Function0<Unit> function0) {
        this.invalidateOverlay = function0;
    }

    private void setTransitionActive(boolean z) {
        this.isTransitionActive$delegate.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public boolean isTransitionActive() {
        return ((Boolean) this.isTransitionActive$delegate.getValue()).booleanValue();
    }

    public final Function0<Unit> getTestBlockToRun() {
        return this.testBlockToRun;
    }

    public final void setTestBlockToRun(Function0<Unit> function0) {
        this.testBlockToRun = function0;
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier skipToLookaheadSize(Modifier modifier, Function0<Boolean> function0) {
        return modifier.then(new SkipToLookaheadSizeElement(null, function0, 1, null));
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier renderInSharedTransitionScopeOverlay(Modifier modifier, float f, Function0<Boolean> function0) {
        return modifier.then(new RenderInTransitionOverlayNodeElement(this, function0, f));
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier sharedElement(Modifier modifier, SharedTransitionScope.SharedContentState sharedContentState, AnimatedVisibilityScope animatedVisibilityScope, BoundsTransform boundsTransform, SharedTransitionScope.PlaceholderSize placeholderSize, boolean z, float f, SharedTransitionScope.OverlayClip overlayClip) {
        return sharedBoundsImpl(modifier, sharedContentState, animatedVisibilityScope.getTransition(), new Function1<EnterExitState, Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedElement$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(EnterExitState enterExitState) {
                return Boolean.valueOf(enterExitState == EnterExitState.Visible);
            }
        }, boundsTransform, placeholderSize, true, z, f, overlayClip);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier sharedBounds(Modifier modifier, final SharedTransitionScope.SharedContentState sharedContentState, final AnimatedVisibilityScope animatedVisibilityScope, final EnterTransition enterTransition, final ExitTransition exitTransition, BoundsTransform boundsTransform, final SharedTransitionScope.ResizeMode resizeMode, SharedTransitionScope.PlaceholderSize placeholderSize, boolean z, float f, SharedTransitionScope.OverlayClip overlayClip) {
        return ComposedModifierKt.composed$default(sharedBoundsImpl(modifier, sharedContentState, animatedVisibilityScope.getTransition(), new Function1<EnterExitState, Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedBounds$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(EnterExitState enterExitState) {
                return Boolean.valueOf(enterExitState == EnterExitState.Visible);
            }
        }, boundsTransform, placeholderSize, false, z, f, overlayClip), null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedBounds$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                Modifier.Companion companion;
                composer.startReplaceGroup(-233734437);
                ComposerKt.sourceInformation(composer, "C1062@58781L35,1054@58258L657:SharedTransitionScope.kt#xbi5r1");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-233734437, i, -1, "androidx.compose.animation.SharedTransitionScopeImpl.sharedBounds.<anonymous> (SharedTransitionScope.kt:1053)");
                }
                Transition<EnterExitState> transition = AnimatedVisibilityScope.this.getTransition();
                EnterTransition enterTransition2 = enterTransition;
                ExitTransition exitTransition2 = exitTransition;
                ComposerKt.sourceInformationMarkerStart(composer, -1280475426, "CC(remember):SharedTransitionScope.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(sharedContentState);
                final SharedTransitionScope.SharedContentState sharedContentState2 = sharedContentState;
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = (Function0) new Function0<Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedBounds$2$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return Boolean.valueOf(SharedTransitionScope.SharedContentState.this.isMatchFound());
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier createModifier = EnterExitTransitionKt.createModifier(transition, enterTransition2, exitTransition2, (Function0) rememberedValue, "enter/exit for " + sharedContentState.getKey(), composer, 0, 0);
                if (resizeMode instanceof ScaleToBoundsImpl) {
                    composer.startReplaceGroup(-1039792755);
                    ComposerKt.sourceInformation(composer, "1067@59082L530");
                    Modifier.Companion companion2 = Modifier.Companion;
                    ScaleToBoundsImpl scaleToBoundsImpl = (ScaleToBoundsImpl) resizeMode;
                    ComposerKt.sourceInformationMarkerStart(composer, -1280465299, "CC(remember):SharedTransitionScope.kt#9igjgp");
                    boolean changedInstance2 = composer.changedInstance(sharedContentState);
                    final SharedTransitionScope.SharedContentState sharedContentState3 = sharedContentState;
                    Object rememberedValue2 = composer.rememberedValue();
                    if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = (Function0) new Function0<Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedBounds$2$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                return Boolean.valueOf(SharedTransitionScope.SharedContentState.this.isMatchFound());
                            }
                        };
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    companion = SkipToLookaheadSizeNodeKt.createContentScaleModifier(companion2, scaleToBoundsImpl, (Function0) rememberedValue2);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-1039175545);
                    composer.endReplaceGroup();
                    companion = Modifier.Companion;
                }
                Modifier then = createModifier.then(companion);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return then;
            }
        }, 1, null);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier sharedElementWithCallerManagedVisibility(Modifier modifier, SharedTransitionScope.SharedContentState sharedContentState, final boolean z, BoundsTransform boundsTransform, SharedTransitionScope.PlaceholderSize placeholderSize, boolean z2, float f, SharedTransitionScope.OverlayClip overlayClip) {
        return sharedBoundsImpl(modifier, sharedContentState, null, new Function1<Unit, Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedElementWithCallerManagedVisibility$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Unit unit) {
                return Boolean.valueOf(z);
            }
        }, boundsTransform, placeholderSize, true, z2, f, overlayClip);
    }

    public static /* synthetic */ Modifier sharedBoundsWithCallerManagedVisibility$animation$default(SharedTransitionScopeImpl sharedTransitionScopeImpl, Modifier modifier, SharedTransitionScope.SharedContentState sharedContentState, boolean z, BoundsTransform boundsTransform, SharedTransitionScope.PlaceholderSize placeholderSize, boolean z2, float f, SharedTransitionScope.OverlayClip overlayClip, int i, Object obj) {
        if ((i & 4) != 0) {
            boundsTransform = SharedTransitionDefaults.INSTANCE.getBoundsTransform();
        }
        BoundsTransform boundsTransform2 = boundsTransform;
        if ((i & 8) != 0) {
            placeholderSize = SharedTransitionScope.PlaceholderSize.Companion.getContentSize();
        }
        return sharedTransitionScopeImpl.sharedBoundsWithCallerManagedVisibility$animation(modifier, sharedContentState, z, boundsTransform2, placeholderSize, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? 0.0f : f, (i & 64) != 0 ? SharedTransitionScopeKt.access$getParentClip$p() : overlayClip);
    }

    public final Modifier sharedBoundsWithCallerManagedVisibility$animation(Modifier modifier, SharedTransitionScope.SharedContentState sharedContentState, final boolean z, BoundsTransform boundsTransform, SharedTransitionScope.PlaceholderSize placeholderSize, boolean z2, float f, SharedTransitionScope.OverlayClip overlayClip) {
        return sharedBoundsImpl(modifier, sharedContentState, null, new Function1<Unit, Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedBoundsWithCallerManagedVisibility$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Unit unit) {
                return Boolean.valueOf(z);
            }
        }, boundsTransform, placeholderSize, false, z2, f, overlayClip);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public SharedTransitionScope.OverlayClip OverlayClip(Shape shape) {
        return new ShapeBasedClip(shape);
    }

    public final Function0<Unit> getObserveAnimatingBlock$animation() {
        return this.observeAnimatingBlock;
    }

    public final void updateTransitionActiveness$animation() {
        SnapshotStateMap<Object, SharedElement> snapshotStateMap = this.sharedElements;
        boolean z = false;
        if (!snapshotStateMap.isEmpty()) {
            Iterator<Map.Entry<Object, SharedElement>> it = snapshotStateMap.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getValue().isAnimating()) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z != isTransitionActive()) {
            setTransitionActive(z);
            if (!z) {
                for (Map.Entry<Object, SharedElement> entry : this.sharedElements.entrySet()) {
                    entry.getValue().onSharedTransitionFinished();
                }
            }
        }
        for (Map.Entry<Object, SharedElement> entry2 : this.sharedElements.entrySet()) {
            entry2.getValue().updateMatch$animation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Modifier sharedBoundsImpl(Modifier modifier, final SharedTransitionScope.SharedContentState sharedContentState, final Transition<T> transition, final Function1<? super T, Boolean> function1, final BoundsTransform boundsTransform, final SharedTransitionScope.PlaceholderSize placeholderSize, final boolean z, final boolean z2, final float f, final SharedTransitionScope.OverlayClip overlayClip) {
        return ComposedModifierKt.composed$default(modifier, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedBoundsImpl$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                Transition rememberTransition;
                SharedElementEntry rememberSharedElementState;
                Composer composer2 = composer;
                composer2.startReplaceGroup(-1539505585);
                ComposerKt.sourceInformation(composer2, "C:SharedTransitionScope.kt#xbi5r1");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1539505585, i, -1, "androidx.compose.animation.SharedTransitionScopeImpl.sharedBoundsImpl.<anonymous> (SharedTransitionScope.kt:1225)");
                }
                Object key = SharedTransitionScope.SharedContentState.this.getKey();
                composer2.startMovableGroup(-1996110529, key);
                ComposerKt.sourceInformation(composer2, "1228@68034L35,1285@71430L559");
                ComposerKt.sourceInformationMarkerStart(composer2, -1996113006, "CC(remember):SharedTransitionScope.kt#9igjgp");
                SharedTransitionScopeImpl sharedTransitionScopeImpl = this;
                Object rememberedValue = composer2.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = sharedTransitionScopeImpl.sharedElementsFor(key);
                    composer2.updateRememberedValue(rememberedValue);
                }
                SharedElement sharedElement = (SharedElement) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.startMovableGroup(-1996106748, transition);
                ComposerKt.sourceInformation(composer2, "1265@70383L438");
                boolean z3 = false;
                if (transition != null) {
                    composer2.startReplaceGroup(-1749734647);
                    ComposerKt.sourceInformation(composer2, "1233@68308L121");
                    Transition<T> transition2 = transition;
                    String obj = key.toString();
                    Function1<T, Boolean> function12 = function1;
                    ComposerKt.sourceInformationMarkerStart(composer2, -539313577, "CC(createChildTransition)N(label,transformToChildState)1768@75281L36,1769@75341L74,1770@75438L39,1771@75489L63:Transition.kt#pdpnli");
                    ComposerKt.sourceInformationMarkerStart(composer2, 1410701659, "CC(remember):Transition.kt#9igjgp");
                    boolean changed = composer2.changed(transition2);
                    Object rememberedValue2 = composer2.rememberedValue();
                    if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = transition2.getCurrentState();
                        composer2.updateRememberedValue(rememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (transition2.isSeeking()) {
                        rememberedValue2 = transition2.getCurrentState();
                    }
                    composer2.startReplaceGroup(1498260051);
                    ComposerKt.sourceInformation(composer2, "C:SharedTransitionScope.kt#xbi5r1");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1498260051, 0, -1, "androidx.compose.animation.SharedTransitionScopeImpl.sharedBoundsImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SharedTransitionScope.kt:1234)");
                    }
                    boolean booleanValue = function12.invoke(rememberedValue2).booleanValue();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    Boolean valueOf = Boolean.valueOf(booleanValue);
                    Object targetState = transition2.getTargetState();
                    composer2.startReplaceGroup(1498260051);
                    ComposerKt.sourceInformation(composer2, "C:SharedTransitionScope.kt#xbi5r1");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1498260051, 0, -1, "androidx.compose.animation.SharedTransitionScopeImpl.sharedBoundsImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SharedTransitionScope.kt:1234)");
                    }
                    boolean booleanValue2 = function12.invoke(targetState).booleanValue();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    rememberTransition = androidx.compose.animation.core.TransitionKt.createChildTransitionInternal(transition2, valueOf, Boolean.valueOf(booleanValue2), obj, composer2, 0);
                    composer2 = composer2;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-1749482679);
                    ComposerKt.sourceInformation(composer2, "1240@68711L1251,1259@70074L35");
                    Function function = function1;
                    Intrinsics.checkNotNull(function, "null cannot be cast to non-null type kotlin.Function1<kotlin.Unit, kotlin.Boolean>");
                    boolean booleanValue3 = ((Boolean) ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function, 1)).invoke(Unit.INSTANCE)).booleanValue();
                    ComposerKt.sourceInformationMarkerStart(composer2, -1996090126, "CC(remember):SharedTransitionScope.kt#9igjgp");
                    Object rememberedValue3 = composer2.rememberedValue();
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        if (sharedElement.getEnabledEntries().isEmpty()) {
                            z3 = booleanValue3;
                        } else if (!booleanValue3) {
                            z3 = true;
                        }
                        rememberedValue3 = new MutableTransitionState(Boolean.valueOf(z3));
                        composer2.updateRememberedValue(rememberedValue3);
                    }
                    MutableTransitionState mutableTransitionState = (MutableTransitionState) rememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(booleanValue3));
                    rememberTransition = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, null, composer2, MutableTransitionState.$stable, 2);
                    composer2.endReplaceGroup();
                }
                composer2.startMovableGroup(-1996043323, Boolean.valueOf(this.isTransitionActive()));
                ComposerKt.sourceInformation(composer2, "1263@70283L45");
                Transition<Boolean>.DeferredAnimation<Rect, AnimationVector4D> createDeferredAnimation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(rememberTransition, VectorConvertersKt.getVectorConverter(Rect.Companion), null, composer2, 0, 2);
                composer2.endMovableGroup();
                ComposerKt.sourceInformationMarkerStart(composer2, -1996037435, "CC(remember):SharedTransitionScope.kt#9igjgp");
                boolean changed2 = composer2.changed(rememberTransition);
                SharedTransitionScopeImpl sharedTransitionScopeImpl2 = this;
                BoundsTransform boundsTransform2 = boundsTransform;
                Object rememberedValue4 = composer2.rememberedValue();
                if (changed2 || rememberedValue4 == Composer.Companion.getEmpty()) {
                    BoundsAnimation boundsAnimation = new BoundsAnimation(sharedTransitionScopeImpl2, rememberTransition, createDeferredAnimation, boundsTransform2, sharedElement.getMomentumAnimationOffset());
                    composer2.updateRememberedValue(boundsAnimation);
                    rememberedValue4 = boundsAnimation;
                }
                BoundsAnimation boundsAnimation2 = (BoundsAnimation) rememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                boundsAnimation2.updateAnimation(createDeferredAnimation, boundsTransform);
                composer2.endMovableGroup();
                rememberSharedElementState = this.rememberSharedElementState(sharedElement, boundsAnimation2, placeholderSize, z, SharedTransitionScope.SharedContentState.this, overlayClip, f, z2, composer, 0);
                composer.endMovableGroup();
                Modifier then = modifier2.then(new SharedBoundsNodeElement(rememberSharedElementState));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return then;
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedElementEntry rememberSharedElementState(SharedElement sharedElement, BoundsAnimation boundsAnimation, SharedTransitionScope.PlaceholderSize placeholderSize, boolean z, SharedTransitionScope.SharedContentState sharedContentState, SharedTransitionScope.OverlayClip overlayClip, float f, boolean z2, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 864401334, "C(rememberSharedElementState)P(6!1,2,4,5!1,7)1311@72514L504:SharedTransitionScope.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(864401334, i, -1, "androidx.compose.animation.SharedTransitionScopeImpl.rememberSharedElementState (SharedTransitionScope.kt:1311)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1761007534, "CC(remember):SharedTransitionScope.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new SharedElementEntry(sharedElement, boundsAnimation, placeholderSize, z, overlayClip, z2, sharedContentState, f);
            composer.updateRememberedValue(rememberedValue);
        }
        SharedElementEntry sharedElementEntry = (SharedElementEntry) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        sharedContentState.setInternalState$animation(sharedElementEntry);
        sharedElementEntry.setSharedElement(sharedElement);
        sharedElementEntry.setRenderOnlyWhenVisible(z);
        sharedElementEntry.setBoundsAnimation(boundsAnimation);
        sharedElementEntry.setPlaceholderSize(placeholderSize);
        sharedElementEntry.setOverlayClip(overlayClip);
        sharedElementEntry.setZIndex(f);
        sharedElementEntry.setRenderInOverlayDuringTransition(z2);
        sharedElementEntry.setUserState(sharedContentState);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return sharedElementEntry;
    }

    public final LayoutCoordinates getRoot$animation() {
        LayoutCoordinates layoutCoordinates = this.nullableRoot;
        if (layoutCoordinates != null) {
            return layoutCoordinates;
        }
        throw new IllegalArgumentException("Error: Uninitialized LayoutCoordinates. Please make sure when using the SharedTransitionScope composable function, the modifier passed to the child content is being used, or use SharedTransitionLayout instead.".toString());
    }

    public final void setRoot$animation(LayoutCoordinates layoutCoordinates) {
        this.nullableRoot = layoutCoordinates;
    }

    public final LayoutCoordinates getNullableRoot$animation() {
        return this.nullableRoot;
    }

    public final LayoutCoordinates getLookaheadRoot$animation() {
        LayoutCoordinates layoutCoordinates = this._nullableLookaheadRoot;
        if (layoutCoordinates != null) {
            return layoutCoordinates;
        }
        throw new IllegalArgumentException("Error: Uninitialized LayoutCoordinates. Please make sure when using the SharedTransitionScope composable function, the modifier passed to the child content is being used, or use SharedTransitionLayout instead.".toString());
    }

    public final void setLookaheadRoot$animation(LayoutCoordinates layoutCoordinates) {
        this._nullableLookaheadRoot = layoutCoordinates;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedElement sharedElementsFor(Object obj) {
        SharedElement sharedElement = this.sharedElements.get(obj);
        if (sharedElement == null) {
            SharedElement sharedElement2 = new SharedElement(obj, this);
            this.sharedElements.put(obj, sharedElement2);
            return sharedElement2;
        }
        return sharedElement;
    }

    public final void drawInOverlay$animation(ContentDrawScope contentDrawScope) {
        SnapshotStateList<LayerRenderer> snapshotStateList = this.renderers;
        if (snapshotStateList.size() > 1) {
            CollectionsKt.sortWith(snapshotStateList, new Comparator() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$drawInOverlay$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    LayerRenderer layerRenderer = (LayerRenderer) t;
                    float f = -1.0f;
                    Float valueOf = Float.valueOf((layerRenderer.getZIndex() == 0.0f && (layerRenderer instanceof SharedElementEntry) && ((SharedElementEntry) layerRenderer).getParentState() == null) ? -1.0f : layerRenderer.getZIndex());
                    LayerRenderer layerRenderer2 = (LayerRenderer) t2;
                    if (layerRenderer2.getZIndex() != 0.0f || !(layerRenderer2 instanceof SharedElementEntry) || ((SharedElementEntry) layerRenderer2).getParentState() != null) {
                        f = layerRenderer2.getZIndex();
                    }
                    return ComparisonsKt.compareValues(valueOf, Float.valueOf(f));
                }
            });
        }
        SnapshotStateList<LayerRenderer> snapshotStateList2 = this.renderers;
        int size = snapshotStateList2.size();
        for (int i = 0; i < size; i++) {
            snapshotStateList2.get(i).drawInOverlay(contentDrawScope);
        }
    }

    public final void onEntryRemoved$animation(SharedElementEntry sharedElementEntry) {
        SharedElement sharedElement = sharedElementEntry.getSharedElement();
        sharedElement.removeEntry(sharedElementEntry);
        updateTransitionActiveness$animation();
        this.renderers.remove(sharedElementEntry);
        if (sharedElement.getAllEntries().isEmpty()) {
            BuildersKt__Builders_commonKt.launch$default(sharedElement.getScope().coroutineScope, null, null, new SharedTransitionScopeImpl$onEntryRemoved$1$1(sharedElement, sharedElementEntry, null), 3, null);
        }
    }

    public final void onEntryAdded$animation(SharedElementEntry sharedElementEntry) {
        sharedElementEntry.getSharedElement().addEntry(sharedElementEntry);
        updateTransitionActiveness$animation();
        Iterator<LayerRenderer> it = this.renderers.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            LayerRenderer next = it.next();
            SharedElementEntry sharedElementEntry2 = next instanceof SharedElementEntry ? (SharedElementEntry) next : null;
            if (Intrinsics.areEqual(sharedElementEntry2 != null ? sharedElementEntry2.getSharedElement() : null, sharedElementEntry.getSharedElement())) {
                break;
            }
            i++;
        }
        if (i == this.renderers.size() - 1 || i == -1) {
            this.renderers.add(sharedElementEntry);
        } else {
            this.renderers.add(i + 1, sharedElementEntry);
        }
    }

    public final void onLayerRendererCreated$animation(LayerRenderer layerRenderer) {
        this.renderers.add(layerRenderer);
    }

    public final void onLayerRendererRemoved$animation(LayerRenderer layerRenderer) {
        this.renderers.remove(layerRenderer);
    }

    /* compiled from: SharedTransitionScope.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/animation/SharedTransitionScopeImpl$ShapeBasedClip;", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "<init>", "(Landroidx/compose/ui/graphics/Shape;)V", "getClipShape", "()Landroidx/compose/ui/graphics/Shape;", "path", "Landroidx/compose/ui/graphics/Path;", "getClipPath", "sharedContentState", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    private static final class ShapeBasedClip implements SharedTransitionScope.OverlayClip {
        private final Shape clipShape;
        private final Path path = AndroidPath_androidKt.Path();

        public ShapeBasedClip(Shape shape) {
            this.clipShape = shape;
        }

        public final Shape getClipShape() {
            return this.clipShape;
        }

        @Override // androidx.compose.animation.SharedTransitionScope.OverlayClip
        public Path getClipPath(SharedTransitionScope.SharedContentState sharedContentState, Rect rect, LayoutDirection layoutDirection, Density density) {
            this.path.reset();
            OutlineKt.addOutline(this.path, this.clipShape.mo320createOutlinePq9zytI(rect.m4560getSizeNHjbRc(), layoutDirection, density));
            this.path.mo4664translatek4lQ0M(rect.m4562getTopLeftF1C5BW0());
            return this.path;
        }
    }
}
