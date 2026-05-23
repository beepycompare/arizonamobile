package androidx.compose.ui.platform;

import android.content.Context;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.ui.MotionDurationScale;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlow;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WindowRecomposer.android.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001d\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR+\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/platform/MotionDurationScaleImpl;", "Landroidx/compose/ui/MotionDurationScale;", "applicationContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "<set-?>", "", "_scaleFactor", "get_scaleFactor", "()F", "set_scaleFactor", "(F)V", "_scaleFactor$delegate", "Landroidx/compose/runtime/MutableFloatState;", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "setJob", "(Lkotlinx/coroutines/Job;)V", "scaleFactor", "getScaleFactor", "startObservingSystemScaleFactor", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MotionDurationScaleImpl implements MotionDurationScale {
    private final MutableFloatState _scaleFactor$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
    private final Context applicationContext;
    private CoroutineScope coroutineScope;
    private Job job;

    public MotionDurationScaleImpl(Context context) {
        this.applicationContext = context;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public /* bridge */ <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) MotionDurationScale.DefaultImpls.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public /* bridge */ <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) MotionDurationScale.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public /* bridge */ CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return MotionDurationScale.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public /* bridge */ CoroutineContext plus(CoroutineContext coroutineContext) {
        return MotionDurationScale.DefaultImpls.plus(this, coroutineContext);
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final void setCoroutineScope(CoroutineScope coroutineScope) {
        this.coroutineScope = coroutineScope;
    }

    private final float get_scaleFactor() {
        return this._scaleFactor$delegate.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void set_scaleFactor(float f) {
        this._scaleFactor$delegate.setFloatValue(f);
    }

    public final Job getJob() {
        return this.job;
    }

    public final void setJob(Job job) {
        this.job = job;
    }

    @Override // androidx.compose.ui.MotionDurationScale
    public float getScaleFactor() {
        if (this.job == null) {
            this.job = startObservingSystemScaleFactor();
        }
        return get_scaleFactor();
    }

    private final Job startObservingSystemScaleFactor() {
        StateFlow animationScaleFlowFor;
        Job launch$default;
        animationScaleFlowFor = WindowRecomposer_androidKt.getAnimationScaleFlowFor(this.applicationContext);
        set_scaleFactor(((Number) animationScaleFlowFor.getValue()).floatValue());
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MotionDurationScaleImpl$startObservingSystemScaleFactor$1(animationScaleFlowFor, this, null), 3, null);
            return launch$default;
        }
        throw new IllegalStateException("MotionDurationScale scale factor requested before recomposer loop start".toString());
    }
}
