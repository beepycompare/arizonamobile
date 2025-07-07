package androidx.compose.runtime;

import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.internal.RememberEventDispatcher;
import com.facebook.widget.FacebookDialog;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PausableComposition.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B^\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\b\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012\u0012\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015¢\u0006\u0002\u0010\u0016J\b\u00104\u001a\u00020\rH\u0016J\b\u00105\u001a\u00020\rH\u0002J\b\u00106\u001a\u00020\rH\u0016J\b\u00107\u001a\u00020\rH\u0002J\u0010\u00108\u001a\u00020\u00102\u0006\u00109\u001a\u00020:H\u0016R\u0015\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\b\u000e¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0015\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001c\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140*X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020.X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b1\u0010&R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Landroidx/compose/runtime/PausedCompositionImpl;", "Landroidx/compose/runtime/PausedComposition;", "composition", "Landroidx/compose/runtime/CompositionImpl;", "context", "Landroidx/compose/runtime/CompositionContext;", "composer", "Landroidx/compose/runtime/ComposerImpl;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "reusable", "", "applier", "Landroidx/compose/runtime/Applier;", "lock", "", "Landroidx/compose/runtime/platform/SynchronizedObject;", "(Landroidx/compose/runtime/CompositionImpl;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/ComposerImpl;Ljava/util/Set;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/runtime/Applier;Ljava/lang/Object;)V", "getApplier", "()Landroidx/compose/runtime/Applier;", "getComposer", "()Landroidx/compose/runtime/ComposerImpl;", "getComposition", "()Landroidx/compose/runtime/CompositionImpl;", "getContent", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getContext", "()Landroidx/compose/runtime/CompositionContext;", "invalidScopes", "Landroidx/collection/ScatterSet;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "isComplete", "()Z", "getLock", "()Ljava/lang/Object;", "pausableApplier", "Landroidx/compose/runtime/RecordingApplier;", "getPausableApplier$runtime_release", "()Landroidx/compose/runtime/RecordingApplier;", "rememberManager", "Landroidx/compose/runtime/internal/RememberEventDispatcher;", "getRememberManager$runtime_release", "()Landroidx/compose/runtime/internal/RememberEventDispatcher;", "getReusable", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/runtime/PausedCompositionState;", "apply", "applyChanges", FacebookDialog.COMPLETION_GESTURE_CANCEL, "markComplete", "resume", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PausedCompositionImpl implements PausedComposition {
    public static final int $stable = 8;
    private final Applier<?> applier;
    private final ComposerImpl composer;
    private final CompositionImpl composition;
    private final Function2<Composer, Integer, Unit> content;
    private final CompositionContext context;
    private final Object lock;
    private final RecordingApplier<Object> pausableApplier;
    private final RememberEventDispatcher rememberManager;
    private final boolean reusable;
    private PausedCompositionState state = PausedCompositionState.InitialPending;
    private ScatterSet<RecomposeScopeImpl> invalidScopes = ScatterSetKt.emptyScatterSet();

    /* compiled from: PausableComposition.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PausedCompositionState.values().length];
            try {
                iArr[PausedCompositionState.InitialPending.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PausedCompositionState.RecomposePending.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PausedCompositionState.ApplyPending.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PausedCompositionState.Applied.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PausedCompositionState.Cancelled.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PausedCompositionState.Invalid.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PausedCompositionImpl(CompositionImpl compositionImpl, CompositionContext compositionContext, ComposerImpl composerImpl, Set<RememberObserver> set, Function2<? super Composer, ? super Integer, Unit> function2, boolean z, Applier<?> applier, Object obj) {
        this.composition = compositionImpl;
        this.context = compositionContext;
        this.composer = composerImpl;
        this.content = function2;
        this.reusable = z;
        this.applier = applier;
        this.lock = obj;
        this.rememberManager = new RememberEventDispatcher(set);
        this.pausableApplier = new RecordingApplier<>(applier.getCurrent());
    }

    public final CompositionImpl getComposition() {
        return this.composition;
    }

    public final CompositionContext getContext() {
        return this.context;
    }

    public final ComposerImpl getComposer() {
        return this.composer;
    }

    public final Function2<Composer, Integer, Unit> getContent() {
        return this.content;
    }

    public final boolean getReusable() {
        return this.reusable;
    }

    public final Applier<?> getApplier() {
        return this.applier;
    }

    public final Object getLock() {
        return this.lock;
    }

    public final RememberEventDispatcher getRememberManager$runtime_release() {
        return this.rememberManager;
    }

    public final RecordingApplier<Object> getPausableApplier$runtime_release() {
        return this.pausableApplier;
    }

    @Override // androidx.compose.runtime.PausedComposition
    public boolean isComplete() {
        return this.state.compareTo(PausedCompositionState.ApplyPending) >= 0;
    }

    @Override // androidx.compose.runtime.PausedComposition
    public boolean resume(ShouldPauseCallback shouldPauseCallback) {
        try {
            switch (WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()]) {
                case 1:
                    if (this.reusable) {
                        this.composer.startReuseFromRoot();
                    }
                    this.invalidScopes = this.context.composeInitialPaused$runtime_release(this.composition, shouldPauseCallback, this.content);
                    if (this.reusable) {
                        this.composer.endReuseFromRoot();
                    }
                    this.state = PausedCompositionState.RecomposePending;
                    if (this.invalidScopes.isEmpty()) {
                        markComplete();
                        break;
                    }
                    break;
                case 2:
                    ScatterSet<RecomposeScopeImpl> recomposePaused$runtime_release = this.context.recomposePaused$runtime_release(this.composition, shouldPauseCallback, this.invalidScopes);
                    this.invalidScopes = recomposePaused$runtime_release;
                    if (recomposePaused$runtime_release.isEmpty()) {
                        markComplete();
                        break;
                    }
                    break;
                case 3:
                    throw new IllegalStateException("Pausable composition is complete and apply() should be applied".toString());
                case 4:
                    throw new IllegalStateException("The paused composition has been applied".toString());
                case 5:
                    throw new IllegalStateException("The paused composition has been cancelled".toString());
                case 6:
                    throw new IllegalStateException("The paused composition is invalid because of a previous exception".toString());
            }
            return isComplete();
        } catch (Exception e) {
            this.state = PausedCompositionState.Invalid;
            throw e;
        }
    }

    @Override // androidx.compose.runtime.PausedComposition
    public void apply() {
        try {
            switch (WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()]) {
                case 1:
                case 2:
                    throw new IllegalStateException("The paused composition has not completed yet".toString());
                case 3:
                    applyChanges();
                    this.state = PausedCompositionState.Applied;
                    return;
                case 4:
                    throw new IllegalStateException("The paused composition has already been applied".toString());
                case 5:
                    throw new IllegalStateException("The paused composition has been cancelled".toString());
                case 6:
                    throw new IllegalStateException("The paused composition is invalid because of a previous exception".toString());
                default:
                    return;
            }
        } catch (Exception e) {
            this.state = PausedCompositionState.Invalid;
            throw e;
        }
    }

    @Override // androidx.compose.runtime.PausedComposition
    public void cancel() {
        this.state = PausedCompositionState.Cancelled;
        this.rememberManager.dispatchAbandons();
        this.composition.pausedCompositionFinished$runtime_release();
    }

    private final void markComplete() {
        this.state = PausedCompositionState.ApplyPending;
    }

    private final void applyChanges() {
        synchronized (this.lock) {
            RecordingApplier<Object> recordingApplier = this.pausableApplier;
            Applier<?> applier = this.applier;
            Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            recordingApplier.playTo(applier);
            this.rememberManager.dispatchRememberObservers();
            this.rememberManager.dispatchSideEffects();
            this.rememberManager.dispatchAbandons();
            this.composition.pausedCompositionFinished$runtime_release();
            Unit unit = Unit.INSTANCE;
        }
    }
}
