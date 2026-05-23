package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ShouldPauseCallback;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import com.facebook.widget.FacebookDialog;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* compiled from: SubcomposeLayout.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0002*+B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006B\u0011\b\u0017\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0004\u0010\tJ(\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00012\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00120\"¢\u0006\u0002\b#¢\u0006\u0002\u0010$J(\u0010%\u001a\u00020&2\b\u0010 \u001a\u0004\u0018\u00010\u00012\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00120\"¢\u0006\u0002\b#¢\u0006\u0002\u0010'J\r\u0010(\u001a\u00020\u0012H\u0000¢\u0006\u0002\b)R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR+\u0010\u000f\u001a\u0019\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0002\b\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R+\u0010\u0016\u001a\u0019\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0002\b\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015RB\u0010\u0019\u001a0\u0012\u0004\u0012\u00020\u0011\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u0010¢\u0006\u0002\b\u0013\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0002\b\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015¨\u0006,"}, d2 = {"Landroidx/compose/ui/layout/SubcomposeLayoutState;", "", "slotReusePolicy", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "<init>", "(Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "()V", "maxSlotsToRetainForReuse", "", "(I)V", "_state", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", RemoteConfigConstants.ResponseFieldKey.STATE, "getState", "()Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "setRoot", "Lkotlin/Function2;", "Landroidx/compose/ui/node/LayoutNode;", "", "Lkotlin/ExtensionFunctionType;", "getSetRoot$ui", "()Lkotlin/jvm/functions/Function2;", "setCompositionContext", "Landroidx/compose/runtime/CompositionContext;", "getSetCompositionContext$ui", "setMeasurePolicy", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "getSetMeasurePolicy$ui", "precompose", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "slotId", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "createPausedPrecomposition", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PausedPrecomposition;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PausedPrecomposition;", "forceRecomposeChildren", "forceRecomposeChildren$ui", "PausedPrecomposition", "PrecomposedSlotHandle", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SubcomposeLayoutState {
    public static final int $stable = 8;
    private LayoutNodeSubcompositionsState _state;
    private final Function2<LayoutNode, CompositionContext, Unit> setCompositionContext;
    private final Function2<LayoutNode, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult>, Unit> setMeasurePolicy;
    private final Function2<LayoutNode, SubcomposeLayoutState, Unit> setRoot;
    private final SubcomposeSlotReusePolicy slotReusePolicy;

    /* compiled from: SubcomposeLayout.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004\u0082\u0001\u0001\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/layout/SubcomposeLayoutState$PausedPrecomposition;", "", "isComplete", "", "()Z", "resume", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "apply", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", FacebookDialog.COMPLETION_GESTURE_CANCEL, "", "Landroidx/compose/ui/layout/PausedPrecompositionImpl;", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface PausedPrecomposition {
        PrecomposedSlotHandle apply();

        void cancel();

        boolean isComplete();

        boolean resume(ShouldPauseCallback shouldPauseCallback);
    }

    public SubcomposeLayoutState(SubcomposeSlotReusePolicy subcomposeSlotReusePolicy) {
        this.slotReusePolicy = subcomposeSlotReusePolicy;
        this.setRoot = new Function2<LayoutNode, SubcomposeLayoutState, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setRoot$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, SubcomposeLayoutState subcomposeLayoutState) {
                invoke2(layoutNode, subcomposeLayoutState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutNode layoutNode, SubcomposeLayoutState subcomposeLayoutState) {
                LayoutNodeSubcompositionsState state;
                LayoutNodeSubcompositionsState state2;
                SubcomposeSlotReusePolicy subcomposeSlotReusePolicy2;
                SubcomposeSlotReusePolicy subcomposeSlotReusePolicy3;
                SubcomposeLayoutState subcomposeLayoutState2 = SubcomposeLayoutState.this;
                LayoutNodeSubcompositionsState subcompositionsState$ui = layoutNode.getSubcompositionsState$ui();
                if (subcompositionsState$ui == null) {
                    subcomposeSlotReusePolicy3 = SubcomposeLayoutState.this.slotReusePolicy;
                    subcompositionsState$ui = new LayoutNodeSubcompositionsState(layoutNode, subcomposeSlotReusePolicy3);
                    layoutNode.setSubcompositionsState$ui(subcompositionsState$ui);
                }
                subcomposeLayoutState2._state = subcompositionsState$ui;
                state = SubcomposeLayoutState.this.getState();
                state.makeSureStateIsConsistent();
                state2 = SubcomposeLayoutState.this.getState();
                subcomposeSlotReusePolicy2 = SubcomposeLayoutState.this.slotReusePolicy;
                state2.setSlotReusePolicy(subcomposeSlotReusePolicy2);
            }
        };
        this.setCompositionContext = new Function2<LayoutNode, CompositionContext, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setCompositionContext$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, CompositionContext compositionContext) {
                invoke2(layoutNode, compositionContext);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutNode layoutNode, CompositionContext compositionContext) {
                LayoutNodeSubcompositionsState state;
                state = SubcomposeLayoutState.this.getState();
                state.setCompositionContext(compositionContext);
            }
        };
        this.setMeasurePolicy = new Function2<LayoutNode, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult>, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$setMeasurePolicy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> function2) {
                invoke2(layoutNode, function2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutNode layoutNode, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> function2) {
                LayoutNodeSubcompositionsState state;
                state = SubcomposeLayoutState.this.getState();
                layoutNode.setMeasurePolicy(state.createMeasurePolicy(function2));
            }
        };
    }

    public SubcomposeLayoutState() {
        this(NoOpSubcomposeSlotReusePolicy.INSTANCE);
    }

    @Deprecated(message = "This constructor is deprecated", replaceWith = @ReplaceWith(expression = "SubcomposeLayoutState(SubcomposeSlotReusePolicy(maxSlotsToRetainForReuse))", imports = {"androidx.compose.ui.layout.SubcomposeSlotReusePolicy"}))
    public SubcomposeLayoutState(int i) {
        this(SubcomposeLayoutKt.SubcomposeSlotReusePolicy(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutNodeSubcompositionsState getState() {
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this._state;
        if (layoutNodeSubcompositionsState != null) {
            return layoutNodeSubcompositionsState;
        }
        throw new IllegalArgumentException("SubcomposeLayoutState is not attached to SubcomposeLayout".toString());
    }

    public final Function2<LayoutNode, SubcomposeLayoutState, Unit> getSetRoot$ui() {
        return this.setRoot;
    }

    public final Function2<LayoutNode, CompositionContext, Unit> getSetCompositionContext$ui() {
        return this.setCompositionContext;
    }

    public final Function2<LayoutNode, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult>, Unit> getSetMeasurePolicy$ui() {
        return this.setMeasurePolicy;
    }

    public final PrecomposedSlotHandle precompose(Object obj, Function2<? super Composer, ? super Integer, Unit> function2) {
        return getState().precompose(obj, function2);
    }

    public final PausedPrecomposition createPausedPrecomposition(Object obj, Function2<? super Composer, ? super Integer, Unit> function2) {
        return getState().precomposePaused(obj, function2);
    }

    public final void forceRecomposeChildren$ui() {
        getState().forceRecomposeChildren();
    }

    /* compiled from: SubcomposeLayout.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ&\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011H\u0016J\u0017\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "", "dispose", "", "placeablesCount", "", "getPlaceablesCount", "()I", "premeasure", FirebaseAnalytics.Param.INDEX, "constraints", "Landroidx/compose/ui/unit/Constraints;", "premeasure-0kLqBqw", "(IJ)V", "traverseDescendants", "key", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "getSize", "Landroidx/compose/ui/unit/IntSize;", "getSize-YEO4UFw", "(I)J", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface PrecomposedSlotHandle {
        void dispose();

        default int getPlaceablesCount() {
            return 0;
        }

        /* renamed from: premeasure-0kLqBqw */
        default void mo6846premeasure0kLqBqw(int i, long j) {
        }

        default void traverseDescendants(Object obj, Function1<? super TraversableNode, ? extends TraversableNode.Companion.TraverseDescendantsAction> function1) {
        }

        /* renamed from: getSize-YEO4UFw */
        default long mo6845getSizeYEO4UFw(int i) {
            return IntSize.Companion.m8336getZeroYbymL2g();
        }
    }
}
