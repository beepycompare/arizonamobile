package androidx.compose.animation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSizeKt;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SharedElement.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\"\u001a\u0004\u0018\u00010#J\b\u0010:\u001a\u00020\u000eH\u0002J\n\u0010;\u001a\u0004\u0018\u00010#H\u0002J\u0016\u0010=\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AJ\b\u0010F\u001a\u00020\fH\u0002J\u0006\u0010G\u001a\u00020\u000eJ\u0006\u0010H\u001a\u00020\u000eJ\u000e\u0010L\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020AJ\u000e\u0010N\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020AR\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR+\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u00188@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR/\u0010\u001e\u001a\u0004\u0018\u00010\u00182\b\u0010\u000f\u001a\u0004\u0018\u00010\u00188B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u0016\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR/\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u000f\u001a\u0004\u0018\u00010#8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010\u0016\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010+\u001a\u0004\u0018\u00010*2\b\u0010\u0017\u001a\u0004\u0018\u00010*@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R(\u0010.\u001a\u0004\u0018\u00010*2\b\u0010\u0017\u001a\u0004\u0018\u00010*@BX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010-\"\u0004\b0\u00101R+\u00103\u001a\u0002022\u0006\u0010\u000f\u001a\u0002028B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b8\u0010\u0016\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u000e\u00109\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020A0C¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000e0IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000e0KX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Landroidx/compose/animation/SharedElement;", "", "key", "scope", "Landroidx/compose/animation/SharedTransitionScopeImpl;", "<init>", "(Ljava/lang/Object;Landroidx/compose/animation/SharedTransitionScopeImpl;)V", "getKey", "()Ljava/lang/Object;", "getScope", "()Landroidx/compose/animation/SharedTransitionScopeImpl;", "isAnimating", "", "updateMatch", "", "<set-?>", "foundMatch", "getFoundMatch", "()Z", "setFoundMatch", "(Z)V", "foundMatch$delegate", "Landroidx/compose/runtime/MutableState;", "value", "Landroidx/compose/animation/TargetData;", "targetData", "getTargetData$animation", "()Landroidx/compose/animation/TargetData;", "setTargetData$animation", "(Landroidx/compose/animation/TargetData;)V", "_targetData", "get_targetData", "set_targetData", "_targetData$delegate", "tryInitializingCurrentBounds", "Landroidx/compose/ui/geometry/Rect;", "currentBoundsWhenMatched", "getCurrentBoundsWhenMatched", "()Landroidx/compose/ui/geometry/Rect;", "setCurrentBoundsWhenMatched", "(Landroidx/compose/ui/geometry/Rect;)V", "currentBoundsWhenMatched$delegate", "Landroidx/compose/animation/BoundsProvider;", "lastTargetBoundsProvider", "getLastTargetBoundsProvider$animation", "()Landroidx/compose/animation/BoundsProvider;", "targetBoundsProvider", "getTargetBoundsProvider$animation", "setTargetBoundsProvider", "(Landroidx/compose/animation/BoundsProvider;)V", "", "targetBoundsProviderUpdateRequestId", "getTargetBoundsProviderUpdateRequestId", "()I", "setTargetBoundsProviderUpdateRequestId", "(I)V", "targetBoundsProviderUpdateRequestId$delegate", "lastHandledTargetProviderUpdateRequestId", "updateTargetBoundsProvider", "obtainBoundsFromLastTarget", "targetBoundsProviderChanged", "onLookaheadPlaced", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/animation/SharedElementInternalState;", "states", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "getStates", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "hasVisibleContent", "invalidateTargetBoundsProvider", "onSharedTransitionFinished", "Lkotlin/Function1;", "observingVisibilityChange", "Lkotlin/Function0;", "addState", "sharedElementState", "removeState", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SharedElement {
    public static final int $stable = 8;
    private final MutableState _targetData$delegate;
    private final MutableState currentBoundsWhenMatched$delegate;
    private final MutableState foundMatch$delegate;
    private final Object key;
    private int lastHandledTargetProviderUpdateRequestId;
    private BoundsProvider lastTargetBoundsProvider;
    private final Function0<Unit> observingVisibilityChange;
    private final SharedTransitionScopeImpl scope;
    private final SnapshotStateList<SharedElementInternalState> states;
    private BoundsProvider targetBoundsProvider;
    private boolean targetBoundsProviderChanged;
    private final MutableState targetBoundsProviderUpdateRequestId$delegate;
    private final Function1<SharedElement, Unit> updateMatch;

    public SharedElement(Object obj, SharedTransitionScopeImpl sharedTransitionScopeImpl) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        this.key = obj;
        this.scope = sharedTransitionScopeImpl;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.foundMatch$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this._targetData$delegate = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentBoundsWhenMatched$delegate = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.targetBoundsProviderUpdateRequestId$delegate = mutableStateOf$default4;
        this.states = SnapshotStateKt.mutableStateListOf();
        this.updateMatch = new Function1<SharedElement, Unit>() { // from class: androidx.compose.animation.SharedElement$updateMatch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SharedElement sharedElement) {
                invoke2(sharedElement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SharedElement sharedElement) {
                SharedElement.this.updateMatch();
            }
        };
        this.observingVisibilityChange = new Function0<Unit>() { // from class: androidx.compose.animation.SharedElement$observingVisibilityChange$1
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
                SharedElement.this.hasVisibleContent();
            }
        };
    }

    public final Object getKey() {
        return this.key;
    }

    public final SharedTransitionScopeImpl getScope() {
        return this.scope;
    }

    public final boolean isAnimating() {
        SnapshotStateList<SharedElementInternalState> snapshotStateList = this.states;
        int size = snapshotStateList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            } else if (!snapshotStateList.get(i).getBoundsAnimation().isRunning()) {
                i++;
            } else if (getFoundMatch()) {
                return true;
            }
        }
        return false;
    }

    public final void updateMatch() {
        boolean hasVisibleContent = hasVisibleContent();
        if (this.states.size() > 1 && hasVisibleContent) {
            setFoundMatch(true);
        } else if (!this.scope.isTransitionActive()) {
            setFoundMatch(false);
        } else if (!hasVisibleContent) {
            setFoundMatch(false);
        }
        if (!this.states.isEmpty()) {
            this.scope.observeReads$animation(this, this.updateMatch, this.observingVisibilityChange);
        }
        invalidateTargetBoundsProvider();
    }

    private final void setFoundMatch(boolean z) {
        this.foundMatch$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean getFoundMatch() {
        return ((Boolean) this.foundMatch$delegate.getValue()).booleanValue();
    }

    public final TargetData getTargetData$animation() {
        if (getFoundMatch()) {
            return get_targetData();
        }
        return null;
    }

    public final void setTargetData$animation(TargetData targetData) {
        if (getFoundMatch()) {
            set_targetData(targetData);
        }
    }

    private final TargetData get_targetData() {
        return (TargetData) this._targetData$delegate.getValue();
    }

    private final void set_targetData(TargetData targetData) {
        this._targetData$delegate.setValue(targetData);
    }

    public final Rect tryInitializingCurrentBounds() {
        if (getFoundMatch()) {
            updateTargetBoundsProvider();
            if (getCurrentBoundsWhenMatched() == null) {
                setCurrentBoundsWhenMatched(obtainBoundsFromLastTarget());
            }
            return getCurrentBoundsWhenMatched();
        }
        return null;
    }

    public final Rect getCurrentBoundsWhenMatched() {
        return (Rect) this.currentBoundsWhenMatched$delegate.getValue();
    }

    public final void setCurrentBoundsWhenMatched(Rect rect) {
        this.currentBoundsWhenMatched$delegate.setValue(rect);
    }

    public final BoundsProvider getLastTargetBoundsProvider$animation() {
        return this.lastTargetBoundsProvider;
    }

    public final BoundsProvider getTargetBoundsProvider$animation() {
        return this.targetBoundsProvider;
    }

    private final void setTargetBoundsProvider(BoundsProvider boundsProvider) {
        if (!Intrinsics.areEqual(this.targetBoundsProvider, boundsProvider)) {
            this.lastTargetBoundsProvider = this.targetBoundsProvider;
        }
        this.targetBoundsProvider = boundsProvider;
    }

    private final int getTargetBoundsProviderUpdateRequestId() {
        return ((Number) this.targetBoundsProviderUpdateRequestId$delegate.getValue()).intValue();
    }

    private final void setTargetBoundsProviderUpdateRequestId(int i) {
        this.targetBoundsProviderUpdateRequestId$delegate.setValue(Integer.valueOf(i));
    }

    private final void updateTargetBoundsProvider() {
        SharedElementInternalState sharedElementInternalState;
        if (getTargetBoundsProviderUpdateRequestId() != this.lastHandledTargetProviderUpdateRequestId) {
            SnapshotStateList<SharedElementInternalState> snapshotStateList = this.states;
            int size = snapshotStateList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    sharedElementInternalState = null;
                    break;
                }
                sharedElementInternalState = snapshotStateList.get(i);
                if (sharedElementInternalState.getTarget()) {
                    break;
                }
                i++;
            }
            SharedElementInternalState sharedElementInternalState2 = sharedElementInternalState;
            if (sharedElementInternalState2 == null) {
                sharedElementInternalState2 = (SharedElementInternalState) CollectionsKt.firstOrNull((List<? extends Object>) this.states);
            }
            BoundsProvider boundsProvider = sharedElementInternalState2 != null ? sharedElementInternalState2.getBoundsProvider() : null;
            if (!Intrinsics.areEqual(boundsProvider, this.targetBoundsProvider)) {
                this.lastTargetBoundsProvider = this.targetBoundsProvider;
                setTargetBoundsProvider(boundsProvider);
                this.targetBoundsProviderChanged = true;
            }
            if (boundsProvider == null) {
                setTargetBoundsProvider(null);
            }
            this.lastHandledTargetProviderUpdateRequestId = getTargetBoundsProviderUpdateRequestId();
        }
    }

    private final Rect obtainBoundsFromLastTarget() {
        if (this.lastTargetBoundsProvider != null) {
            SnapshotStateList<SharedElementInternalState> snapshotStateList = this.states;
            int size = snapshotStateList.size();
            for (int i = 0; i < size; i++) {
                if (Intrinsics.areEqual(snapshotStateList.get(i).getBoundsProvider(), this.lastTargetBoundsProvider)) {
                    BoundsProvider boundsProvider = this.lastTargetBoundsProvider;
                    if (boundsProvider != null) {
                        return boundsProvider.getLastBoundsInSharedTransitionScope();
                    }
                    return null;
                }
            }
        }
        return null;
    }

    public final void onLookaheadPlaced(Placeable.PlacementScope placementScope, SharedElementInternalState sharedElementInternalState) {
        LayoutCoordinates coordinates;
        long j;
        long j2;
        updateTargetBoundsProvider();
        if (getFoundMatch() && sharedElementInternalState.getBoundsAnimation().getTarget() && (coordinates = placementScope.getCoordinates()) != null) {
            long m8179toSizeozmzZPI = IntSizeKt.m8179toSizeozmzZPI(coordinates.mo6706getSizeYbymL2g());
            long m6727localLookaheadPositionOfauaQtc$default = LookaheadScope.m6727localLookaheadPositionOfauaQtc$default(sharedElementInternalState.getSharedElement().scope, sharedElementInternalState.getSharedElement().scope.getLookaheadRoot$animation(), coordinates, 0L, false, 6, null);
            SharedTransitionScopeImpl sharedTransitionScopeImpl = sharedElementInternalState.getSharedElement().scope;
            long m6705localPositionOfS_NoaFU$default = LayoutCoordinates.m6705localPositionOfS_NoaFU$default(sharedElementInternalState.getSharedElement().scope.getLookaheadRoot$animation(), coordinates, 0L, false, 2, null);
            TargetData targetData$animation = getTargetData$animation();
            if (targetData$animation == null) {
                j = m8179toSizeozmzZPI;
                j2 = m6705localPositionOfS_NoaFU$default;
                targetData$animation = new TargetData(j, Offset.m5040minusMKHz9U(m6727localLookaheadPositionOfauaQtc$default, m6705localPositionOfS_NoaFU$default), j2, null);
            } else {
                j = m8179toSizeozmzZPI;
                j2 = m6705localPositionOfS_NoaFU$default;
            }
            if (!Offset.m5033equalsimpl0(targetData$animation.m144getTargetStructuralOffsetF1C5BW0(), j2) || !Size.m5101equalsimpl0(targetData$animation.m143getSizeNHjbRc(), j) || this.targetBoundsProviderChanged) {
                targetData$animation.m147setSizeuvyYCjk(j);
                targetData$animation.m148setTargetStructuralOffsetk4lQ0M(j2);
                if (this.targetBoundsProviderChanged) {
                    targetData$animation.m146setInitialMfrOffsetk4lQ0M(Offset.m5040minusMKHz9U(Offset.m5040minusMKHz9U(m6727localLookaheadPositionOfauaQtc$default, j2), Offset.m5040minusMKHz9U(targetData$animation.m141getCurrentMfrOffsetF1C5BW0(), targetData$animation.m142getInitialMfrOffsetF1C5BW0())));
                }
                if (getCurrentBoundsWhenMatched() == null) {
                    Rect obtainBoundsFromLastTarget = obtainBoundsFromLastTarget();
                    if (obtainBoundsFromLastTarget == null) {
                        obtainBoundsFromLastTarget = RectKt.m5076Recttz77jQw(m6727localLookaheadPositionOfauaQtc$default, j);
                    }
                    setCurrentBoundsWhenMatched(obtainBoundsFromLastTarget);
                }
            }
            targetData$animation.m145setCurrentMfrOffsetk4lQ0M(Offset.m5040minusMKHz9U(m6727localLookaheadPositionOfauaQtc$default, j2));
            setTargetData$animation(targetData$animation);
            this.targetBoundsProviderChanged = false;
        }
    }

    public final SnapshotStateList<SharedElementInternalState> getStates() {
        return this.states;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasVisibleContent() {
        SnapshotStateList<SharedElementInternalState> snapshotStateList = this.states;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            if (snapshotStateList.get(i).getBoundsAnimation().getTarget()) {
                return true;
            }
        }
        return false;
    }

    public final void invalidateTargetBoundsProvider() {
        SharedElementInternalState sharedElementInternalState;
        Iterator<SharedElementInternalState> it = this.states.iterator();
        while (true) {
            if (!it.hasNext()) {
                sharedElementInternalState = null;
                break;
            }
            sharedElementInternalState = it.next();
            if (sharedElementInternalState.getTarget()) {
                break;
            }
        }
        SharedElementInternalState sharedElementInternalState2 = sharedElementInternalState;
        if (sharedElementInternalState2 == null && this.targetBoundsProvider == null) {
            return;
        }
        if (Intrinsics.areEqual(sharedElementInternalState2 != null ? sharedElementInternalState2.getBoundsProvider() : null, this.targetBoundsProvider)) {
            return;
        }
        setTargetBoundsProviderUpdateRequestId(this.lastHandledTargetProviderUpdateRequestId + 1);
    }

    public final void onSharedTransitionFinished() {
        boolean z = true;
        setFoundMatch((this.states.size() <= 1 || !hasVisibleContent()) ? false : false);
        this.lastTargetBoundsProvider = null;
        set_targetData(null);
    }

    public final void addState(SharedElementInternalState sharedElementInternalState) {
        this.states.add(sharedElementInternalState);
        this.scope.observeReads$animation(this, this.updateMatch, this.observingVisibilityChange);
    }

    public final void removeState(SharedElementInternalState sharedElementInternalState) {
        this.states.remove(sharedElementInternalState);
        if (this.states.isEmpty()) {
            updateMatch();
            this.scope.clearObservation$animation(this);
            return;
        }
        this.scope.observeReads$animation(this, this.updateMatch, this.observingVisibilityChange);
    }
}
