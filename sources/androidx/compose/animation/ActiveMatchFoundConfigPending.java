package androidx.compose.animation;

import androidx.compose.animation.SharedTransitionStateMachine;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: SharedTransitionStateMachine.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J7\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u0012\u0010'\u001a\u00020\u00012\b\u0010(\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0007H\u0016J\b\u0010,\u001a\u00020\u0001H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R/\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00078V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006-"}, d2 = {"Landroidx/compose/animation/ActiveMatchFoundConfigPending;", "Landroidx/compose/animation/SharedTransitionStateMachine$State;", "targetBoundsProviderBeforeConfig", "Landroidx/compose/animation/BoundsProvider;", "targetData", "Landroidx/compose/animation/TargetData;", "currentBounds", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Landroidx/compose/animation/BoundsProvider;Landroidx/compose/animation/TargetData;Landroidx/compose/ui/geometry/Rect;)V", "getTargetBoundsProviderBeforeConfig", "()Landroidx/compose/animation/BoundsProvider;", "setTargetBoundsProviderBeforeConfig", "(Landroidx/compose/animation/BoundsProvider;)V", "getTargetData", "()Landroidx/compose/animation/TargetData;", "activeMatchFound", "", "getActiveMatchFound", "()Z", "<set-?>", "getCurrentBounds", "()Landroidx/compose/ui/geometry/Rect;", "setCurrentBounds", "(Landroidx/compose/ui/geometry/Rect;)V", "currentBounds$delegate", "Landroidx/compose/runtime/MutableState;", "initializeCurrentBounds", "sharedElement", "Landroidx/compose/animation/SharedElement;", "configureActiveMatch", "targetBoundsProvider", "lookaheadSize", "Landroidx/compose/ui/geometry/Size;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "structuralOffset", "configureActiveMatch-38uP1EE", "(Landroidx/compose/animation/SharedElement;Landroidx/compose/animation/BoundsProvider;JJJ)Landroidx/compose/animation/SharedTransitionStateMachine$State;", "onMatchFound", "previousTargetBoundsProvider", "updateBounds", "", "bounds", "onVisibleContentRemovedDuringTransition", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ActiveMatchFoundConfigPending extends SharedTransitionStateMachine.State {
    public static final int $stable = 8;
    private final MutableState currentBounds$delegate;
    private BoundsProvider targetBoundsProviderBeforeConfig;
    private final TargetData targetData;

    @Override // androidx.compose.animation.SharedTransitionStateMachine.State
    public boolean getActiveMatchFound() {
        return true;
    }

    public ActiveMatchFoundConfigPending(BoundsProvider boundsProvider, TargetData targetData, Rect rect) {
        super(null);
        MutableState mutableStateOf$default;
        this.targetBoundsProviderBeforeConfig = boundsProvider;
        this.targetData = targetData;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(rect, null, 2, null);
        this.currentBounds$delegate = mutableStateOf$default;
    }

    public /* synthetic */ ActiveMatchFoundConfigPending(BoundsProvider boundsProvider, TargetData targetData, Rect rect, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(boundsProvider, (i & 2) != 0 ? null : targetData, (i & 4) != 0 ? null : rect);
    }

    public final BoundsProvider getTargetBoundsProviderBeforeConfig() {
        return this.targetBoundsProviderBeforeConfig;
    }

    public final void setTargetBoundsProviderBeforeConfig(BoundsProvider boundsProvider) {
        this.targetBoundsProviderBeforeConfig = boundsProvider;
    }

    @Override // androidx.compose.animation.SharedTransitionStateMachine.State
    public TargetData getTargetData() {
        return this.targetData;
    }

    private void setCurrentBounds(Rect rect) {
        this.currentBounds$delegate.setValue(rect);
    }

    @Override // androidx.compose.animation.SharedTransitionStateMachine.State
    public Rect getCurrentBounds() {
        return (Rect) this.currentBounds$delegate.getValue();
    }

    @Override // androidx.compose.animation.SharedTransitionStateMachine.State
    public Rect initializeCurrentBounds(SharedElement sharedElement) {
        Rect obtainBoundsFromLastTarget;
        SharedElementEntry sharedElementEntry;
        Rect currentBounds = getCurrentBounds();
        if (currentBounds != null) {
            return currentBounds;
        }
        if (getCurrentBounds() == null) {
            BoundsProvider boundsProvider = this.targetBoundsProviderBeforeConfig;
            if (boundsProvider == null) {
                List<SharedElementEntry> allEntries = sharedElement.getAllEntries();
                int size = allEntries.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        sharedElementEntry = null;
                        break;
                    }
                    sharedElementEntry = allEntries.get(i);
                    if (sharedElement.getEnabledEntries().contains(sharedElementEntry)) {
                        break;
                    }
                    i++;
                }
                SharedElementEntry sharedElementEntry2 = sharedElementEntry;
                boundsProvider = sharedElementEntry2 != null ? sharedElementEntry2.getBoundsProvider() : null;
            }
            obtainBoundsFromLastTarget = SharedTransitionStateMachineKt.obtainBoundsFromLastTarget(sharedElement, boundsProvider);
            if (obtainBoundsFromLastTarget != null) {
                setCurrentBounds(obtainBoundsFromLastTarget);
            }
        }
        return getCurrentBounds();
    }

    @Override // androidx.compose.animation.SharedTransitionStateMachine.State
    /* renamed from: configureActiveMatch-38uP1EE */
    public SharedTransitionStateMachine.State mo36configureActiveMatch38uP1EE(SharedElement sharedElement, BoundsProvider boundsProvider, long j, long j2, long j3) {
        long j4;
        SharedElementEntry sharedElementEntry;
        TargetData targetData = getTargetData();
        if (targetData == null) {
            targetData = new TargetData(j, Offset.m4531minusMKHz9U(j2, j3), j3, null);
        }
        Rect currentBounds = getCurrentBounds();
        if (currentBounds == null) {
            BoundsProvider boundsProvider2 = this.targetBoundsProviderBeforeConfig;
            if (boundsProvider2 == null) {
                List<SharedElementEntry> allEntries = sharedElement.getAllEntries();
                int size = allEntries.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        sharedElementEntry = null;
                        break;
                    }
                    sharedElementEntry = allEntries.get(i);
                    if (sharedElement.getEnabledEntries().contains(sharedElementEntry)) {
                        break;
                    }
                    i++;
                }
                SharedElementEntry sharedElementEntry2 = sharedElementEntry;
                boundsProvider2 = sharedElementEntry2 != null ? sharedElementEntry2.getBoundsProvider() : null;
            }
            currentBounds = SharedTransitionStateMachineKt.obtainBoundsFromLastTarget(sharedElement, boundsProvider2);
            if (currentBounds == null) {
                j4 = j2;
                currentBounds = RectKt.m4567Recttz77jQw(j4, j);
                TargetData targetData2 = targetData;
                SharedTransitionStateMachineKt.m131updateTargetDataBGTQxF0(targetData2, j, j4, j3, true);
                return new ActiveMatchConfigured(targetData2, boundsProvider, currentBounds);
            }
        }
        j4 = j2;
        TargetData targetData22 = targetData;
        SharedTransitionStateMachineKt.m131updateTargetDataBGTQxF0(targetData22, j, j4, j3, true);
        return new ActiveMatchConfigured(targetData22, boundsProvider, currentBounds);
    }

    @Override // androidx.compose.animation.SharedTransitionStateMachine.State
    public SharedTransitionStateMachine.State onMatchFound(BoundsProvider boundsProvider) {
        if (this.targetBoundsProviderBeforeConfig == null) {
            this.targetBoundsProviderBeforeConfig = boundsProvider;
        }
        return this;
    }

    @Override // androidx.compose.animation.SharedTransitionStateMachine.State
    public void updateBounds(Rect rect) {
        setCurrentBounds(rect);
    }

    @Override // androidx.compose.animation.SharedTransitionStateMachine.State
    public SharedTransitionStateMachine.State onVisibleContentRemovedDuringTransition() {
        return NoMatchFound.INSTANCE;
    }
}
