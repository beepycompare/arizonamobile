package androidx.compose.animation;

import androidx.compose.animation.SharedTransitionStateMachine;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSizeKt;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
/* compiled from: SharedElement.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010#\u001a\u00020$J\r\u0010)\u001a\u00020*H\u0000¢\u0006\u0002\b+J\u0017\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020/H\u0000¢\u0006\u0004\b0\u00101J\u0006\u00106\u001a\u00020*J\b\u00107\u001a\u0004\u0018\u000108J\u0006\u00109\u001a\u00020*J\u0016\u0010?\u001a\u00020*2\u0006\u0010@\u001a\u00020A2\u0006\u0010\r\u001a\u00020\u0013J\u000e\u0010D\u001a\u00020*2\u0006\u0010E\u001a\u00020\u0013J\u000e\u0010F\u001a\u00020*2\u0006\u0010E\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R7\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R7\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128F¢\u0006\u0006\u001a\u0004\b \u0010\u0016R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0016R\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020'03¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010:\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0011\u0010=\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b>\u0010<R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020*03X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u00105¨\u0006G"}, d2 = {"Landroidx/compose/animation/SharedElement;", "", "key", "scope", "Landroidx/compose/animation/SharedTransitionScopeImpl;", "<init>", "(Ljava/lang/Object;Landroidx/compose/animation/SharedTransitionScopeImpl;)V", "getKey", "()Ljava/lang/Object;", "getScope", "()Landroidx/compose/animation/SharedTransitionScopeImpl;", "stateMachine", "Landroidx/compose/animation/SharedTransitionStateMachine;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/animation/SharedTransitionStateMachine$State;", "getState$animation", "()Landroidx/compose/animation/SharedTransitionStateMachine$State;", "<set-?>", "", "Landroidx/compose/animation/SharedElementEntry;", "_allEntries", "get_allEntries", "()Ljava/util/List;", "set_allEntries", "(Ljava/util/List;)V", "_allEntries$delegate", "Landroidx/compose/runtime/MutableState;", "_enabledEntries", "get_enabledEntries", "set_enabledEntries", "_enabledEntries$delegate", "enabledEntries", "getEnabledEntries", "allEntries", "getAllEntries", "isAnimating", "", "momentumAnimation", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/animation/core/AnimationVector2D;", "updateMatch", "", "updateMatch$animation", "animationSpecFinalized", "updateExitVelocity", "velocity", "Landroidx/compose/ui/unit/Velocity;", "updateExitVelocity-TH1AsA0$animation", "(J)V", "momentumAnimationOffset", "Lkotlin/Function0;", "getMomentumAnimationOffset", "()Lkotlin/jvm/functions/Function0;", "invalidateTargetBoundsProvider", "tryInitializingCurrentBounds", "Landroidx/compose/ui/geometry/Rect;", "onSharedTransitionFinished", "foundMatch", "getFoundMatch", "()Z", "boundsTransformIsActive", "getBoundsTransformIsActive", "onLookaheadPlaced", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "observingVisibilityChange", "getObservingVisibilityChange$animation", "addEntry", "sharedElementState", "removeEntry", "animation"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SharedElement {
    public static final int $stable = 8;
    private final MutableState _allEntries$delegate;
    private final MutableState _enabledEntries$delegate;
    private boolean animationSpecFinalized;
    private final Object key;
    private final Animatable<Offset, AnimationVector2D> momentumAnimation;
    private final Function0<Offset> momentumAnimationOffset;
    private final Function0<Unit> observingVisibilityChange;
    private final SharedTransitionScopeImpl scope;
    private final SharedTransitionStateMachine stateMachine = new SharedTransitionStateMachine(this);

    public SharedElement(Object obj, SharedTransitionScopeImpl sharedTransitionScopeImpl) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        this.key = obj;
        this.scope = sharedTransitionScopeImpl;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
        this._allEntries$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
        this._enabledEntries$delegate = mutableStateOf$default2;
        this.momentumAnimation = new Animatable<>(Offset.m5092boximpl(Offset.Companion.m5119getZeroF1C5BW0()), VectorConvertersKt.getVectorConverter(Offset.Companion), null, null, 12, null);
        this.momentumAnimationOffset = new Function0<Offset>() { // from class: androidx.compose.animation.SharedElement$momentumAnimationOffset$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Offset invoke() {
                return Offset.m5092boximpl(m145invokeF1C5BW0());
            }

            /* renamed from: invoke-F1C5BW0  reason: not valid java name */
            public final long m145invokeF1C5BW0() {
                boolean z;
                Animatable animatable;
                Animatable animatable2;
                SharedElementEntry sharedElementEntry;
                z = SharedElement.this.animationSpecFinalized;
                if (!z && SharedElement.this.getScope().isTransitionActive()) {
                    animatable2 = SharedElement.this.momentumAnimation;
                    if (animatable2.isRunning()) {
                        List<SharedElementEntry> enabledEntries = SharedElement.this.getEnabledEntries();
                        int size = enabledEntries.size();
                        int i = 0;
                        while (true) {
                            if (i >= size) {
                                sharedElementEntry = null;
                                break;
                            }
                            sharedElementEntry = enabledEntries.get(i);
                            if (sharedElementEntry.getTarget()) {
                                break;
                            }
                            i++;
                        }
                        SharedElementEntry sharedElementEntry2 = sharedElementEntry;
                        if (sharedElementEntry2 != null) {
                            SharedElement sharedElement = SharedElement.this;
                            FiniteAnimationSpec<Rect> animationSpec = sharedElementEntry2.getBoundsAnimation().getAnimationSpec();
                            if (animationSpec instanceof SpringSpec) {
                                SpringSpec springSpec = (SpringSpec) animationSpec;
                                BuildersKt__Builders_commonKt.launch$default(sharedElement.getScope().getCoroutineScope(), null, null, new SharedElement$momentumAnimationOffset$1$2$1(sharedElement, AnimationSpecKt.spring(springSpec.getDampingRatio(), springSpec.getStiffness(), Offset.m5092boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Offset.Companion))), null), 3, null);
                            }
                            sharedElement.animationSpecFinalized = true;
                        }
                    }
                }
                animatable = SharedElement.this.momentumAnimation;
                return ((Offset) animatable.getValue()).m5113unboximpl();
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
                List<SharedElementEntry> allEntries = SharedElement.this.getAllEntries();
                int size = allEntries.size();
                for (int i = 0; i < size; i++) {
                    SharedElementEntry sharedElementEntry = allEntries.get(i);
                    if (sharedElementEntry.getTarget() && sharedElementEntry.isEnabled()) {
                        return;
                    }
                }
            }
        };
    }

    public final Object getKey() {
        return this.key;
    }

    public final SharedTransitionScopeImpl getScope() {
        return this.scope;
    }

    public final SharedTransitionStateMachine.State getState$animation() {
        return this.stateMachine.getState();
    }

    private final List<SharedElementEntry> get_allEntries() {
        return (List) this._allEntries$delegate.getValue();
    }

    private final void set_allEntries(List<SharedElementEntry> list) {
        this._allEntries$delegate.setValue(list);
    }

    private final List<SharedElementEntry> get_enabledEntries() {
        return (List) this._enabledEntries$delegate.getValue();
    }

    private final void set_enabledEntries(List<SharedElementEntry> list) {
        this._enabledEntries$delegate.setValue(list);
    }

    public final List<SharedElementEntry> getEnabledEntries() {
        return get_enabledEntries();
    }

    public final List<SharedElementEntry> getAllEntries() {
        return get_allEntries();
    }

    public final boolean isAnimating() {
        List<SharedElementEntry> enabledEntries = getEnabledEntries();
        int size = enabledEntries.size();
        for (int i = 0; i < size; i++) {
            if (enabledEntries.get(i).getBoundsAnimation().isRunning()) {
                return true;
            }
        }
        return false;
    }

    public final void updateMatch$animation() {
        Function0<Unit> testBlockToRun = this.scope.getTestBlockToRun();
        if (testBlockToRun != null) {
            testBlockToRun.invoke();
        }
        List<SharedElementEntry> list = get_allEntries();
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            SharedElementEntry sharedElementEntry = list.get(i);
            if (sharedElementEntry.isEnabled()) {
                arrayList.add(sharedElementEntry);
                if (sharedElementEntry.getBoundsAnimation().getTarget()) {
                    z = true;
                }
            }
        }
        set_enabledEntries(arrayList);
        this.stateMachine.checkForAndDeferStateUpdates(z);
    }

    /* renamed from: updateExitVelocity-TH1AsA0$animation  reason: not valid java name */
    public final void m144updateExitVelocityTH1AsA0$animation(long j) {
        BuildersKt__Builders_commonKt.launch$default(this.scope.getCoroutineScope(), null, null, new SharedElement$updateExitVelocity$1(this, j, null), 3, null);
    }

    public final Function0<Offset> getMomentumAnimationOffset() {
        return this.momentumAnimationOffset;
    }

    public final void invalidateTargetBoundsProvider() {
        this.stateMachine.invalidateTargetBoundsProvider();
    }

    public final Rect tryInitializingCurrentBounds() {
        return this.stateMachine.tryInitializingCurrentBounds();
    }

    public final void onSharedTransitionFinished() {
        if (getEnabledEntries().size() <= 1 || !SharedElementKt.access$hasVisibleContent(getEnabledEntries())) {
            this.stateMachine.resetState();
        }
    }

    public final boolean getFoundMatch() {
        return getState$animation().getActiveMatchFound() || getState$animation().getMatchIsOrHasBeenConfigured() || this.stateMachine.getActiveMatchDeferred();
    }

    public final boolean getBoundsTransformIsActive() {
        return getState$animation().getMatchIsOrHasBeenConfigured();
    }

    public final void onLookaheadPlaced(Placeable.PlacementScope placementScope, SharedElementEntry sharedElementEntry) {
        LayoutCoordinates coordinates;
        this.stateMachine.processPendingRequest();
        if (Intrinsics.areEqual(getState$animation(), NoMatchFound.INSTANCE) || !sharedElementEntry.isEnabled()) {
            return;
        }
        SharedTransitionStateMachine.State state$animation = getState$animation();
        if (sharedElementEntry.getBoundsAnimation().getTarget() && state$animation.getActiveMatchFound() && (coordinates = placementScope.getCoordinates()) != null) {
            long m8343toSizeozmzZPI = IntSizeKt.m8343toSizeozmzZPI(coordinates.mo6826getSizeYbymL2g());
            long m6848localLookaheadPositionOfauaQtc$default = LookaheadScope.m6848localLookaheadPositionOfauaQtc$default(sharedElementEntry.getSharedElement().scope, sharedElementEntry.getSharedElement().scope.getLookaheadRoot$animation(), coordinates, 0L, false, 6, null);
            SharedTransitionScopeImpl sharedTransitionScopeImpl = sharedElementEntry.getSharedElement().scope;
            this.stateMachine.m153configureActiveMatchL7TYDSY(m8343toSizeozmzZPI, m6848localLookaheadPositionOfauaQtc$default, LayoutCoordinates.m6825localPositionOfS_NoaFU$default(sharedElementEntry.getSharedElement().scope.getLookaheadRoot$animation(), coordinates, 0L, false, 2, null));
        }
    }

    public final Function0<Unit> getObservingVisibilityChange$animation() {
        return this.observingVisibilityChange;
    }

    public final void addEntry(SharedElementEntry sharedElementEntry) {
        set_allEntries(CollectionsKt.plus((Collection<? extends SharedElementEntry>) get_allEntries(), sharedElementEntry));
        updateMatch$animation();
    }

    public final void removeEntry(SharedElementEntry sharedElementEntry) {
        set_allEntries(CollectionsKt.minus(get_allEntries(), sharedElementEntry));
        set_enabledEntries(CollectionsKt.minus(get_enabledEntries(), sharedElementEntry));
        updateMatch$animation();
    }
}
