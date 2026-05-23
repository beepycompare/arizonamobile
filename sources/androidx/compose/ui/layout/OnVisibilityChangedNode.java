package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.UnplacedAwareModifierNode;
import androidx.compose.ui.spatial.RelativeLayoutBounds;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
/* compiled from: OnVisibilityChangedModifier.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010@\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010A\u001a\u0002062\b\u0010B\u001a\u0004\u0018\u000106J\u0006\u0010C\u001a\u00020\rJ\u0006\u0010D\u001a\u00020\rJ\u0006\u0010E\u001a\u00020\rJ\b\u0010F\u001a\u00020\rH\u0016J\u0006\u0010G\u001a\u00020\rJ\b\u0010H\u001a\u00020\rH\u0016J\b\u0010I\u001a\u00020\rH\u0016J\b\u0010J\u001a\u00020\rH\u0016J\b\u0010K\u001a\u00020\rH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00108\"\u0004\b=\u0010:R\u001d\u0010>\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0019¨\u0006L"}, d2 = {"Landroidx/compose/ui/layout/OnVisibilityChangedNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/UnplacedAwareModifierNode;", "minDurationMs", "", "minFractionVisible", "", "viewportBounds", "Landroidx/compose/ui/layout/LayoutBoundsHolder;", "callback", "Lkotlin/Function1;", "", "", "<init>", "(JFLandroidx/compose/ui/layout/LayoutBoundsHolder;Lkotlin/jvm/functions/Function1;)V", "getMinDurationMs", "()J", "setMinDurationMs", "(J)V", "getMinFractionVisible", "()F", "setMinFractionVisible", "(F)V", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "value", "getViewportBounds", "()Landroidx/compose/ui/layout/LayoutBoundsHolder;", "setViewportBounds", "(Landroidx/compose/ui/layout/LayoutBoundsHolder;)V", "handle", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "getHandle", "()Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "setHandle", "(Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;)V", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "setJob", "(Lkotlinx/coroutines/Job;)V", "lastResult", "getLastResult", "()Z", "setLastResult", "(Z)V", "lastReportedResult", "getLastReportedResult", "setLastReportedResult", "lastBounds", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "getLastBounds", "()Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "setLastBounds", "(Landroidx/compose/ui/spatial/RelativeLayoutBounds;)V", "lastViewport", "getLastViewport", "setLastViewport", "rectChanged", "getRectChanged", "checkVisibility", "bounds", "viewport", "triggerCallback", "forceUpdate", "fireExitIfNeeded", "onReset", "updateViewport", "onAttach", "onDetach", "onObservedReadsChanged", "onUnplaced", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OnVisibilityChangedNode extends Modifier.Node implements ObserverModifierNode, UnplacedAwareModifierNode {
    public static final int $stable = 8;
    private Function1<? super Boolean, Unit> callback;
    private DelegatableNode.RegistrationHandle handle;
    private Job job;
    private RelativeLayoutBounds lastBounds;
    private boolean lastReportedResult;
    private boolean lastResult;
    private RelativeLayoutBounds lastViewport;
    private long minDurationMs;
    private float minFractionVisible;
    private final Function1<RelativeLayoutBounds, Unit> rectChanged = new Function1<RelativeLayoutBounds, Unit>() { // from class: androidx.compose.ui.layout.OnVisibilityChangedNode$rectChanged$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RelativeLayoutBounds relativeLayoutBounds) {
            invoke2(relativeLayoutBounds);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(RelativeLayoutBounds relativeLayoutBounds) {
            OnVisibilityChangedNode onVisibilityChangedNode = OnVisibilityChangedNode.this;
            LayoutBoundsHolder viewportBounds = onVisibilityChangedNode.getViewportBounds();
            onVisibilityChangedNode.setLastViewport(viewportBounds != null ? viewportBounds.getBounds() : null);
            OnVisibilityChangedNode onVisibilityChangedNode2 = OnVisibilityChangedNode.this;
            onVisibilityChangedNode2.checkVisibility(onVisibilityChangedNode2.getMinFractionVisible(), relativeLayoutBounds, OnVisibilityChangedNode.this.getLastViewport());
        }
    };
    private LayoutBoundsHolder viewportBounds;

    public OnVisibilityChangedNode(long j, float f, LayoutBoundsHolder layoutBoundsHolder, Function1<? super Boolean, Unit> function1) {
        this.minDurationMs = j;
        this.minFractionVisible = f;
        this.callback = function1;
        this.viewportBounds = layoutBoundsHolder;
    }

    public final long getMinDurationMs() {
        return this.minDurationMs;
    }

    public final void setMinDurationMs(long j) {
        this.minDurationMs = j;
    }

    public final float getMinFractionVisible() {
        return this.minFractionVisible;
    }

    public final void setMinFractionVisible(float f) {
        this.minFractionVisible = f;
    }

    public final Function1<Boolean, Unit> getCallback() {
        return this.callback;
    }

    public final void setCallback(Function1<? super Boolean, Unit> function1) {
        this.callback = function1;
    }

    public final LayoutBoundsHolder getViewportBounds() {
        return this.viewportBounds;
    }

    public final void setViewportBounds(LayoutBoundsHolder layoutBoundsHolder) {
        this.viewportBounds = layoutBoundsHolder;
        updateViewport();
    }

    public final DelegatableNode.RegistrationHandle getHandle() {
        return this.handle;
    }

    public final void setHandle(DelegatableNode.RegistrationHandle registrationHandle) {
        this.handle = registrationHandle;
    }

    public final Job getJob() {
        return this.job;
    }

    public final void setJob(Job job) {
        this.job = job;
    }

    public final boolean getLastResult() {
        return this.lastResult;
    }

    public final void setLastResult(boolean z) {
        this.lastResult = z;
    }

    public final boolean getLastReportedResult() {
        return this.lastReportedResult;
    }

    public final void setLastReportedResult(boolean z) {
        this.lastReportedResult = z;
    }

    public final RelativeLayoutBounds getLastBounds() {
        return this.lastBounds;
    }

    public final void setLastBounds(RelativeLayoutBounds relativeLayoutBounds) {
        this.lastBounds = relativeLayoutBounds;
    }

    public final RelativeLayoutBounds getLastViewport() {
        return this.lastViewport;
    }

    public final void setLastViewport(RelativeLayoutBounds relativeLayoutBounds) {
        this.lastViewport = relativeLayoutBounds;
    }

    public final Function1<RelativeLayoutBounds, Unit> getRectChanged() {
        return this.rectChanged;
    }

    public final void checkVisibility(float f, RelativeLayoutBounds relativeLayoutBounds, RelativeLayoutBounds relativeLayoutBounds2) {
        float fractionVisibleInWindow;
        Job launch$default;
        this.lastBounds = relativeLayoutBounds;
        if (relativeLayoutBounds2 != null || this.viewportBounds == null) {
            if (relativeLayoutBounds2 != null) {
                fractionVisibleInWindow = relativeLayoutBounds.fractionVisibleIn(relativeLayoutBounds2);
            } else {
                fractionVisibleInWindow = relativeLayoutBounds.fractionVisibleInWindow();
            }
            boolean z = fractionVisibleInWindow > f || fractionVisibleInWindow == 1.0f;
            if (z != this.lastResult) {
                this.lastResult = z;
                Job job = this.job;
                if (job != null) {
                    Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.job = null;
                if (z != this.lastReportedResult) {
                    if (z && this.minDurationMs > 0) {
                        launch$default = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new OnVisibilityChangedNode$checkVisibility$1(this, null), 3, null);
                        this.job = launch$default;
                        return;
                    }
                    triggerCallback();
                }
            }
        }
    }

    public final void triggerCallback() {
        Job job = this.job;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.job = null;
        this.callback.invoke(Boolean.valueOf(this.lastResult));
        this.lastReportedResult = this.lastResult;
    }

    public final void forceUpdate() {
        RelativeLayoutBounds relativeLayoutBounds = this.lastBounds;
        if (relativeLayoutBounds != null) {
            checkVisibility(this.minFractionVisible, relativeLayoutBounds, this.lastViewport);
        }
    }

    public final void fireExitIfNeeded() {
        Job job = this.job;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.job = null;
        this.lastResult = false;
        if (this.lastReportedResult) {
            triggerCallback();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onReset() {
        fireExitIfNeeded();
        Job job = this.job;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.job = null;
        this.lastResult = false;
        this.lastBounds = null;
        this.lastViewport = null;
    }

    public final void updateViewport() {
        if (this.viewportBounds == null) {
            if (this.lastViewport != null) {
                this.lastViewport = null;
                forceUpdate();
                return;
            }
            return;
        }
        ObserverModifierNodeKt.observeReads(this, new Function0<Unit>() { // from class: androidx.compose.ui.layout.OnVisibilityChangedNode$updateViewport$1
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
                LayoutBoundsHolder viewportBounds = OnVisibilityChangedNode.this.getViewportBounds();
                RelativeLayoutBounds bounds = viewportBounds != null ? viewportBounds.getBounds() : null;
                if (Intrinsics.areEqual(OnVisibilityChangedNode.this.getLastViewport(), bounds)) {
                    return;
                }
                OnVisibilityChangedNode.this.setLastViewport(bounds);
                OnVisibilityChangedNode.this.forceUpdate();
            }
        });
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        DelegatableNode.RegistrationHandle registrationHandle = this.handle;
        if (registrationHandle != null) {
            registrationHandle.unregister();
        }
        this.handle = OnLayoutRectChangedModifierKt.registerOnLayoutRectChanged(this, 0L, 0L, this.rectChanged);
        updateViewport();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        DelegatableNode.RegistrationHandle registrationHandle = this.handle;
        if (registrationHandle != null) {
            registrationHandle.unregister();
        }
        fireExitIfNeeded();
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        updateViewport();
    }

    @Override // androidx.compose.ui.node.UnplacedAwareModifierNode
    public void onUnplaced() {
        fireExitIfNeeded();
    }
}
