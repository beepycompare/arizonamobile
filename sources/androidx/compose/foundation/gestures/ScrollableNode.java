package androidx.compose.foundation.gestures;

import android.view.KeyEvent;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode;
import androidx.compose.ui.focus.FocusTargetModifierNode;
import androidx.compose.ui.focus.FocusTargetModifierNodeKt;
import androidx.compose.ui.focus.Focusability;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.core.app.NotificationCompat;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
/* compiled from: Scrollable.kt */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004BO\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u00107\u001a\u0002082\u0006\u00109\u001a\u00020-H\u0016¢\u0006\u0004\b:\u0010;JM\u0010<\u001a\u0002082=\u0010=\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110?¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(@\u0012\u0004\u0012\u0002080>\u0012\n\u0012\b\u0012\u0004\u0012\u0002080.\u0012\u0006\u0012\u0004\u0018\u00010/0&H\u0096@¢\u0006\u0002\u0010AJ\u0017\u0010B\u001a\u0002082\u0006\u0010C\u001a\u00020-H\u0016¢\u0006\u0004\bD\u0010;J\u0010\u0010E\u001a\u0002082\u0006\u0010F\u001a\u00020GH\u0016J\u0017\u0010H\u001a\u0002082\u0006\u0010I\u001a\u00020JH\u0002¢\u0006\u0004\bK\u0010;J\u0017\u0010L\u001a\u0002082\u0006\u0010I\u001a\u00020JH\u0002¢\u0006\u0004\bM\u0010;J\b\u0010N\u001a\u00020\u000eH\u0016J\b\u0010O\u001a\u000208H\u0002J\b\u0010P\u001a\u000208H\u0002JN\u0010Q\u001a\u0002082\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010R\u001a\u000208H\u0016J\b\u0010S\u001a\u000208H\u0002J\b\u0010T\u001a\u000208H\u0016J\u0017\u0010U\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020VH\u0016¢\u0006\u0004\bW\u0010XJ\u0017\u0010Y\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020VH\u0016¢\u0006\u0004\bZ\u0010XJ'\u0010[\u001a\u0002082\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aH\u0016¢\u0006\u0004\bb\u0010cJ\f\u0010d\u001a\u000208*\u00020eH\u0016J\b\u0010f\u001a\u000208H\u0002J\b\u0010g\u001a\u000208H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010%\u001a4\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u000e\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010,\u001a \b\u0001\u0012\u0004\u0012\u00020-\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0.\u0012\u0006\u0012\u0004\u0018\u00010/\u0018\u00010&X\u0082\u000e¢\u0006\u0004\n\u0002\u00100R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006h"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollableNode;", "Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/foundation/gestures/OnScrollChangedDispatcher;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/gestures/ScrollableState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "<init>", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/BringIntoViewSpec;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "defaultFlingBehavior", "Landroidx/compose/foundation/gestures/ScrollableDefaultFlingBehavior;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "nestedScrollConnection", "Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "focusTargetModifierNode", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "contentInViewNode", "Landroidx/compose/foundation/gestures/ContentInViewNode;", "scrollByAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "scrollByOffsetAction", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/jvm/functions/Function2;", "mouseWheelScrollingLogic", "Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic;", "trackpadScrollingLogic", "Landroidx/compose/foundation/gestures/TrackpadScrollingLogic;", "scrollableContainerNode", "Landroidx/compose/foundation/gestures/ScrollableContainerNode;", "dispatchScrollDeltaInfo", "", "delta", "dispatchScrollDeltaInfo-k-4lQ0M", "(J)V", "drag", "forEachDelta", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "dragDelta", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted", "startedPosition", "onDragStarted-k-4lQ0M", "onDragStopped", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "onWheelScrollStopped", "velocity", "Landroidx/compose/ui/unit/Velocity;", "onWheelScrollStopped-TH1AsA0", "onTrackpadScrollStopped", "onTrackpadScrollStopped-TH1AsA0", "startDragImmediately", "ensureMouseWheelScrollingLogicInitialized", "ensureTrackpadScrollingLogicInitialized", "update", "onAttach", "updateDefaultFlingBehavior", "onDensityChange", "onKeyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onPreKeyEvent", "onPreKeyEvent-ZmokQxo", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "setScrollSemanticsActions", "clearScrollSemanticsActions", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScrollableNode extends DragGestureNode implements KeyInputModifierNode, SemanticsModifierNode, OnScrollChangedDispatcher {
    public static final int $stable = 8;
    private final ContentInViewNode contentInViewNode;
    private final ScrollableDefaultFlingBehavior defaultFlingBehavior;
    private FlingBehavior flingBehavior;
    private final FocusTargetModifierNode focusTargetModifierNode;
    private MouseWheelScrollingLogic mouseWheelScrollingLogic;
    private final ScrollableNestedScrollConnection nestedScrollConnection;
    private final NestedScrollDispatcher nestedScrollDispatcher;
    private OverscrollEffect overscrollEffect;
    private Function2<? super Float, ? super Float, Boolean> scrollByAction;
    private Function2<? super Offset, ? super Continuation<? super Offset>, ? extends Object> scrollByOffsetAction;
    private ScrollableContainerNode scrollableContainerNode;
    private final ScrollingLogic scrollingLogic;
    private final boolean shouldAutoInvalidate;
    private TrackpadScrollingLogic trackpadScrollingLogic;

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* renamed from: onDragStarted-k-4lQ0M */
    public void mo452onDragStartedk4lQ0M(long j) {
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* renamed from: onPreKeyEvent-ZmokQxo */
    public boolean mo258onPreKeyEventZmokQxo(KeyEvent keyEvent) {
        return false;
    }

    public ScrollableNode(ScrollableState scrollableState, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec) {
        super(ScrollableKt.getCanDragCalculation(), z, mutableInteractionSource, orientation);
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        NestedScrollDispatcher nestedScrollDispatcher = new NestedScrollDispatcher();
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        ScrollableDefaultFlingBehavior platformScrollableDefaultFlingBehavior = Scrollable_androidKt.platformScrollableDefaultFlingBehavior();
        this.defaultFlingBehavior = platformScrollableDefaultFlingBehavior;
        OverscrollEffect overscrollEffect2 = this.overscrollEffect;
        ScrollableDefaultFlingBehavior scrollableDefaultFlingBehavior = this.flingBehavior;
        ScrollingLogic scrollingLogic = new ScrollingLogic(scrollableState, overscrollEffect2, scrollableDefaultFlingBehavior == null ? platformScrollableDefaultFlingBehavior : scrollableDefaultFlingBehavior, orientation, z2, nestedScrollDispatcher, this, new Function0() { // from class: androidx.compose.foundation.gestures.ScrollableNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isAttached;
                isAttached = ScrollableNode.this.isAttached();
                return Boolean.valueOf(isAttached);
            }
        });
        this.scrollingLogic = scrollingLogic;
        ScrollableNestedScrollConnection scrollableNestedScrollConnection = new ScrollableNestedScrollConnection(scrollingLogic, z);
        this.nestedScrollConnection = scrollableNestedScrollConnection;
        this.focusTargetModifierNode = (FocusTargetModifierNode) delegate(FocusTargetModifierNodeKt.m5015FocusTargetModifierNodePYyLHbc$default(Focusability.Companion.m5038getNeverLCbbffg(), null, 2, null));
        ContentInViewNode contentInViewNode = (ContentInViewNode) delegate(new ContentInViewNode(orientation, scrollingLogic, z2, bringIntoViewSpec, new Function0() { // from class: androidx.compose.foundation.gestures.ScrollableNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Rect focusedRect;
                focusedRect = FocusTargetModifierNodeKt.getFocusedRect(ScrollableNode.this.focusTargetModifierNode);
                return focusedRect;
            }
        }));
        this.contentInViewNode = contentInViewNode;
        delegate(NestedScrollNodeKt.nestedScrollModifierNode(scrollableNestedScrollConnection, nestedScrollDispatcher));
        delegate(new BringIntoViewResponderNode(contentInViewNode));
        if (ComposeFoundationFlags.isDelayPressesUsingGestureConsumptionEnabled) {
            return;
        }
        this.scrollableContainerNode = (ScrollableContainerNode) delegate(new ScrollableContainerNode(z));
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.foundation.gestures.OnScrollChangedDispatcher
    /* renamed from: dispatchScrollDeltaInfo-k-4lQ0M */
    public void mo563dispatchScrollDeltaInfok4lQ0M(long j) {
        if (isAttached()) {
            DelegatableNodeKt.m6987dispatchOnScrollChangedUv8p0NA(this, j);
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        ScrollingLogic scrollingLogic = this.scrollingLogic;
        Object scroll = scrollingLogic.scroll(MutatePriority.UserInput, new ScrollableNode$drag$2$1(function2, scrollingLogic, null), continuation);
        return scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void onDragStopped(DragEvent.DragStopped dragStopped) {
        BuildersKt__Builders_commonKt.launch$default(this.nestedScrollDispatcher.getCoroutineScope(), null, null, new ScrollableNode$onDragStopped$1(dragStopped, this, null), 3, null);
    }

    /* renamed from: onWheelScrollStopped-TH1AsA0  reason: not valid java name */
    private final void m605onWheelScrollStoppedTH1AsA0(long j) {
        BuildersKt__Builders_commonKt.launch$default(this.nestedScrollDispatcher.getCoroutineScope(), null, null, new ScrollableNode$onWheelScrollStopped$1(this, j, null), 3, null);
    }

    /* renamed from: onTrackpadScrollStopped-TH1AsA0  reason: not valid java name */
    private final void m604onTrackpadScrollStoppedTH1AsA0(long j) {
        BuildersKt__Builders_commonKt.launch$default(this.nestedScrollDispatcher.getCoroutineScope(), null, null, new ScrollableNode$onTrackpadScrollStopped$1(this, j, null), 3, null);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public boolean startDragImmediately() {
        return this.scrollingLogic.shouldScrollImmediately();
    }

    private final void ensureMouseWheelScrollingLogicInitialized() {
        if (this.mouseWheelScrollingLogic == null) {
            this.mouseWheelScrollingLogic = new MouseWheelScrollingLogic(this.scrollingLogic, AndroidScrollable_androidKt.platformScrollConfig(this), new ScrollableNode$ensureMouseWheelScrollingLogicInitialized$1(this), DelegatableNodeKt.requireDensity(this));
        }
        MouseWheelScrollingLogic mouseWheelScrollingLogic = this.mouseWheelScrollingLogic;
        if (mouseWheelScrollingLogic != null) {
            mouseWheelScrollingLogic.startReceivingEvents(getCoroutineScope());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object ensureMouseWheelScrollingLogicInitialized$onWheelScrollStopped(ScrollableNode scrollableNode, long j, Continuation continuation) {
        scrollableNode.m605onWheelScrollStoppedTH1AsA0(j);
        return Unit.INSTANCE;
    }

    private final void ensureTrackpadScrollingLogicInitialized() {
        if (this.trackpadScrollingLogic == null) {
            this.trackpadScrollingLogic = new TrackpadScrollingLogic(this.scrollingLogic, new ScrollableNode$ensureTrackpadScrollingLogicInitialized$1(this), DelegatableNodeKt.requireDensity(this));
        }
        TrackpadScrollingLogic trackpadScrollingLogic = this.trackpadScrollingLogic;
        if (trackpadScrollingLogic != null) {
            trackpadScrollingLogic.startReceivingEvents(getCoroutineScope());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object ensureTrackpadScrollingLogicInitialized$onTrackpadScrollStopped(ScrollableNode scrollableNode, long j, Continuation continuation) {
        scrollableNode.m604onTrackpadScrollStoppedTH1AsA0(j);
        return Unit.INSTANCE;
    }

    public final void update(ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z, boolean z2, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec) {
        boolean z3;
        if (getEnabled() != z) {
            this.nestedScrollConnection.setEnabled(z);
            ScrollableContainerNode scrollableContainerNode = this.scrollableContainerNode;
            if (scrollableContainerNode != null) {
                scrollableContainerNode.update(z);
            }
            z3 = true;
        } else {
            z3 = false;
        }
        boolean z4 = z3;
        boolean update = this.scrollingLogic.update(scrollableState, orientation, overscrollEffect, z2, flingBehavior == null ? this.defaultFlingBehavior : flingBehavior, this.nestedScrollDispatcher);
        this.contentInViewNode.update(orientation, z2, bringIntoViewSpec);
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        update(ScrollableKt.getCanDragCalculation(), z, mutableInteractionSource, this.scrollingLogic.isVertical() ? Orientation.Vertical : Orientation.Horizontal, update);
        if (z4) {
            clearScrollSemanticsActions();
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateDefaultFlingBehavior();
        MouseWheelScrollingLogic mouseWheelScrollingLogic = this.mouseWheelScrollingLogic;
        if (mouseWheelScrollingLogic != null) {
            mouseWheelScrollingLogic.updateDensity(DelegatableNodeKt.requireDensity(this));
        }
        TrackpadScrollingLogic trackpadScrollingLogic = this.trackpadScrollingLogic;
        if (trackpadScrollingLogic != null) {
            trackpadScrollingLogic.updateDensity(DelegatableNodeKt.requireDensity(this));
        }
    }

    private final void updateDefaultFlingBehavior() {
        if (isAttached()) {
            this.defaultFlingBehavior.updateDensity(DelegatableNodeKt.requireDensity(this));
        }
    }

    @Override // androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public void onDensityChange() {
        onCancelPointerInput();
        updateDefaultFlingBehavior();
        MouseWheelScrollingLogic mouseWheelScrollingLogic = this.mouseWheelScrollingLogic;
        if (mouseWheelScrollingLogic != null) {
            mouseWheelScrollingLogic.updateDensity(DelegatableNodeKt.requireDensity(this));
        }
        TrackpadScrollingLogic trackpadScrollingLogic = this.trackpadScrollingLogic;
        if (trackpadScrollingLogic != null) {
            trackpadScrollingLogic.updateDensity(DelegatableNodeKt.requireDensity(this));
        }
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* renamed from: onKeyEvent-ZmokQxo */
    public boolean mo256onKeyEventZmokQxo(KeyEvent keyEvent) {
        long m5095constructorimpl;
        if (getEnabled()) {
            if ((Key.m6197equalsimpl0(KeyEvent_androidKt.m6517getKeyZmokQxo(keyEvent), Key.Companion.m6396getPageDownEK5gGoQ()) || Key.m6197equalsimpl0(KeyEvent_androidKt.m6517getKeyZmokQxo(keyEvent), Key.Companion.m6397getPageUpEK5gGoQ())) && KeyEventType.m6510equalsimpl0(KeyEvent_androidKt.m6518getTypeZmokQxo(keyEvent), KeyEventType.Companion.m6514getKeyDownCS__XNY()) && !KeyEvent_androidKt.m6521isCtrlPressedZmokQxo(keyEvent)) {
                boolean isVertical = this.scrollingLogic.isVertical();
                ContentInViewNode contentInViewNode = this.contentInViewNode;
                if (isVertical) {
                    int m470getViewportSizeOrZeroYbymL2g$foundation = (int) (contentInViewNode.m470getViewportSizeOrZeroYbymL2g$foundation() & 4294967295L);
                    m5095constructorimpl = Offset.m5095constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(Key.m6197equalsimpl0(KeyEvent_androidKt.m6517getKeyZmokQxo(keyEvent), Key.Companion.m6397getPageUpEK5gGoQ()) ? m470getViewportSizeOrZeroYbymL2g$foundation : -m470getViewportSizeOrZeroYbymL2g$foundation) & 4294967295L));
                } else {
                    int m470getViewportSizeOrZeroYbymL2g$foundation2 = (int) (contentInViewNode.m470getViewportSizeOrZeroYbymL2g$foundation() >> 32);
                    m5095constructorimpl = Offset.m5095constructorimpl((Float.floatToRawIntBits(Key.m6197equalsimpl0(KeyEvent_androidKt.m6517getKeyZmokQxo(keyEvent), Key.Companion.m6397getPageUpEK5gGoQ()) ? m470getViewportSizeOrZeroYbymL2g$foundation2 : -m470getViewportSizeOrZeroYbymL2g$foundation2) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L));
                }
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new ScrollableNode$onKeyEvent$1(this, m5095constructorimpl, null), 3, null);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode, androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY */
    public void mo257onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            } else if (getCanDrag().invoke(PointerType.m6755boximpl(changes.get(i).m6688getTypeT8wyACA())).booleanValue()) {
                super.mo257onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
                break;
            } else {
                i++;
            }
        }
        initializeGestureCoordination();
        if (getEnabled()) {
            if (pointerEventPass == PointerEventPass.Initial && PointerEventType.m6625equalsimpl0(pointerEvent.m6618getType7fucELk(), PointerEventType.Companion.m6640getScroll7fucELk())) {
                ensureMouseWheelScrollingLogicInitialized();
            }
            MouseWheelScrollingLogic mouseWheelScrollingLogic = this.mouseWheelScrollingLogic;
            if (mouseWheelScrollingLogic != null) {
                mouseWheelScrollingLogic.mo555onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
            }
            if (pointerEventPass == PointerEventPass.Initial && (PointerEventType.m6625equalsimpl0(pointerEvent.m6618getType7fucELk(), PointerEventType.Companion.m6634getPanStart7fucELk()) || PointerEventType.m6625equalsimpl0(pointerEvent.m6618getType7fucELk(), PointerEventType.Companion.m6633getPanMove7fucELk()) || PointerEventType.m6625equalsimpl0(pointerEvent.m6618getType7fucELk(), PointerEventType.Companion.m6632getPanEnd7fucELk()))) {
                ensureTrackpadScrollingLogicInitialized();
            }
            TrackpadScrollingLogic trackpadScrollingLogic = this.trackpadScrollingLogic;
            if (trackpadScrollingLogic != null) {
                trackpadScrollingLogic.mo555onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
            }
        }
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (getEnabled() && (this.scrollByAction == null || this.scrollByOffsetAction == null)) {
            setScrollSemanticsActions();
        }
        Function2<? super Float, ? super Float, Boolean> function2 = this.scrollByAction;
        if (function2 != null) {
            SemanticsPropertiesKt.scrollBy$default(semanticsPropertyReceiver, null, function2, 1, null);
        }
        Function2<? super Offset, ? super Continuation<? super Offset>, ? extends Object> function22 = this.scrollByOffsetAction;
        if (function22 != null) {
            SemanticsPropertiesKt.scrollByOffset(semanticsPropertyReceiver, function22);
        }
    }

    private final void setScrollSemanticsActions() {
        this.scrollByAction = new Function2() { // from class: androidx.compose.foundation.gestures.ScrollableNode$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(ScrollableNode.setScrollSemanticsActions$lambda$0(ScrollableNode.this, ((Float) obj).floatValue(), ((Float) obj2).floatValue()));
            }
        };
        this.scrollByOffsetAction = new ScrollableNode$setScrollSemanticsActions$2(this, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean setScrollSemanticsActions$lambda$0(ScrollableNode scrollableNode, float f, float f2) {
        BuildersKt__Builders_commonKt.launch$default(scrollableNode.getCoroutineScope(), null, null, new ScrollableNode$setScrollSemanticsActions$1$1(scrollableNode, f, f2, null), 3, null);
        return true;
    }

    private final void clearScrollSemanticsActions() {
        this.scrollByAction = null;
        this.scrollByOffsetAction = null;
    }
}
