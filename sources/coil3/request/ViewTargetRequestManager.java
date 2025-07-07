package coil3.request;

import android.view.View;
import coil3.util.CoroutinesKt;
import coil3.util.Utils_androidKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
/* compiled from: ViewTargetRequestManager.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0007J\u0014\u0010\u0010\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013J\u0012\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0007J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0003H\u0017J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0003H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcoil3/request/ViewTargetRequestManager;", "Landroid/view/View$OnAttachStateChangeListener;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "currentDisposable", "Lcoil3/request/ViewTargetDisposable;", "pendingClear", "Lkotlinx/coroutines/Job;", "currentRequest", "Lcoil3/request/ViewTargetRequestDelegate;", "isRestart", "", "isDisposed", "disposable", "getDisposable", "job", "Lkotlinx/coroutines/Deferred;", "Lcoil3/request/ImageResult;", "dispose", "", "getResult", "setRequest", "request", "onViewAttachedToWindow", "v", "onViewDetachedFromWindow", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewTargetRequestManager implements View.OnAttachStateChangeListener {
    private ViewTargetDisposable currentDisposable;
    private ViewTargetRequestDelegate currentRequest;
    private boolean isRestart;
    private Job pendingClear;
    private final View view;

    public ViewTargetRequestManager(View view) {
        this.view = view;
    }

    public final synchronized boolean isDisposed(ViewTargetDisposable viewTargetDisposable) {
        return viewTargetDisposable != this.currentDisposable;
    }

    public final synchronized ViewTargetDisposable getDisposable(Deferred<? extends ImageResult> deferred) {
        ViewTargetDisposable viewTargetDisposable = this.currentDisposable;
        if (viewTargetDisposable != null && Utils_androidKt.isMainThread() && this.isRestart) {
            this.isRestart = false;
            viewTargetDisposable.setJob(deferred);
            return viewTargetDisposable;
        }
        Job job = this.pendingClear;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.pendingClear = null;
        ViewTargetDisposable viewTargetDisposable2 = new ViewTargetDisposable(this.view, deferred);
        this.currentDisposable = viewTargetDisposable2;
        return viewTargetDisposable2;
    }

    public final synchronized void dispose() {
        Job launch$default;
        Job job = this.pendingClear;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new ViewTargetRequestManager$dispose$1(this, null), 2, null);
        this.pendingClear = launch$default;
        this.currentDisposable = null;
    }

    public final synchronized ImageResult getResult() {
        ViewTargetDisposable viewTargetDisposable;
        Deferred<ImageResult> job;
        viewTargetDisposable = this.currentDisposable;
        return (viewTargetDisposable == null || (job = viewTargetDisposable.getJob()) == null) ? null : (ImageResult) CoroutinesKt.getCompletedOrNull(job);
    }

    public final void setRequest(ViewTargetRequestDelegate viewTargetRequestDelegate) {
        ViewTargetRequestDelegate viewTargetRequestDelegate2 = this.currentRequest;
        if (viewTargetRequestDelegate2 != null) {
            viewTargetRequestDelegate2.dispose();
        }
        this.currentRequest = viewTargetRequestDelegate;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        ViewTargetRequestDelegate viewTargetRequestDelegate = this.currentRequest;
        if (viewTargetRequestDelegate == null) {
            return;
        }
        this.isRestart = true;
        viewTargetRequestDelegate.restart();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        ViewTargetRequestDelegate viewTargetRequestDelegate = this.currentRequest;
        if (viewTargetRequestDelegate != null) {
            viewTargetRequestDelegate.dispose();
        }
    }
}
