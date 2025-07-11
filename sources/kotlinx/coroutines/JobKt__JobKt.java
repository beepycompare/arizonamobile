package kotlinx.coroutines;

import com.facebook.widget.FacebookDialog;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.Job;
/* compiled from: Job.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0012\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u001a\u0019\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0002\b\u0007\u001a\u0014\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0001H\u0000\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\u000f\u001a!\u0010\u0010\u001a\u00020\u000e*\u00020\u00022\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013¢\u0006\u0002\u0010\u0014\u001a\f\u0010\u0010\u001a\u00020\u000e*\u00020\u0002H\u0007\u001a\u0018\u0010\u0010\u001a\u00020\u000e*\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0015H\u0007\u001a!\u0010\u0019\u001a\u00020\u000e*\u00020\u00172\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013¢\u0006\u0002\u0010\u001a\u001a\f\u0010\u0019\u001a\u00020\u000e*\u00020\u0017H\u0007\u001a\n\u0010\u001b\u001a\u00020\u000e*\u00020\u0002\u001a\n\u0010\u001b\u001a\u00020\u000e*\u00020\u0017\u001a\u001e\u0010\u0019\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0015\u001a\u0018\u0010\u0019\u001a\u00020\u0004*\u00020\u00172\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0015H\u0007\u001a!\u0010\u0010\u001a\u00020\u000e*\u00020\u00172\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013¢\u0006\u0002\u0010\u001a\u001a\f\u0010\u0010\u001a\u00020\u000e*\u00020\u0017H\u0007\u001a\u0018\u0010\u0010\u001a\u00020\u000e*\u00020\u00172\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0015H\u0007\u001a\u001b\u0010!\u001a\u00020\u0015*\u0004\u0018\u00010\u00152\u0006\u0010\u001e\u001a\u00020\u0002H\u0002¢\u0006\u0002\b\"\"\u0015\u0010\u0016\u001a\u00020\u0004*\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018\"\u0015\u0010\u001e\u001a\u00020\u0002*\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Job;", "invokeImmediately", "", "handler", "Lkotlinx/coroutines/JobNode;", "Job", "Lkotlinx/coroutines/CompletableJob;", "parent", "Job0", "disposeOnCompletion", "handle", "cancelAndJoin", "", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelChildren", "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Lkotlinx/coroutines/Job;Ljava/util/concurrent/CancellationException;)V", "", "isActive", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)Z", FacebookDialog.COMPLETION_GESTURE_CANCEL, "(Lkotlin/coroutines/CoroutineContext;Ljava/util/concurrent/CancellationException;)V", "ensureActive", "message", "", "job", "getJob", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Job;", "orCancellation", "orCancellation$JobKt__JobKt", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "kotlinx/coroutines/JobKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class JobKt__JobKt {
    public static /* synthetic */ DisposableHandle invokeOnCompletion$default(Job job, boolean z, JobNode jobNode, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return JobKt.invokeOnCompletion(job, z, jobNode);
    }

    public static final DisposableHandle invokeOnCompletion(Job job, boolean z, JobNode jobNode) {
        return job instanceof JobSupport ? ((JobSupport) job).invokeOnCompletionInternal$kotlinx_coroutines_core(z, jobNode) : job.invokeOnCompletion(jobNode.getOnCancelling(), z, new JobKt__JobKt$invokeOnCompletion$1(jobNode));
    }

    public static /* synthetic */ CompletableJob Job$default(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return JobKt.Job(job);
    }

    public static final CompletableJob Job(Job job) {
        return new JobImpl(job);
    }

    /* renamed from: Job$default */
    public static /* synthetic */ Job m9976Job$default(Job job, int i, Object obj) {
        Job m9975Job;
        if ((i & 1) != 0) {
            job = null;
        }
        m9975Job = m9975Job(job);
        return m9975Job;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* renamed from: Job */
    public static final /* synthetic */ Job m9975Job(Job job) {
        return JobKt.Job(job);
    }

    public static final DisposableHandle disposeOnCompletion(Job job, DisposableHandle disposableHandle) {
        DisposableHandle invokeOnCompletion$default;
        invokeOnCompletion$default = invokeOnCompletion$default(job, false, new DisposeOnCompletion(disposableHandle), 1, null);
        return invokeOnCompletion$default;
    }

    public static final Object cancelAndJoin(Job job, Continuation<? super Unit> continuation) {
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        Object join = job.join(continuation);
        return join == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? join : Unit.INSTANCE;
    }

    public static /* synthetic */ void cancelChildren$default(Job job, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancelChildren(job, cancellationException);
    }

    public static final void cancelChildren(Job job, CancellationException cancellationException) {
        for (Job job2 : job.getChildren()) {
            job2.cancel(cancellationException);
        }
    }

    public static /* synthetic */ void cancelChildren$default(Job job, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        cancelChildren(job, th);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(Job job, Throwable th) {
        for (Job job2 : job.getChildren()) {
            JobSupport jobSupport = job2 instanceof JobSupport ? (JobSupport) job2 : null;
            if (jobSupport != null) {
                jobSupport.cancelInternal(orCancellation$JobKt__JobKt(th, job));
            }
        }
    }

    public static final boolean isActive(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            return job.isActive();
        }
        return true;
    }

    public static /* synthetic */ void cancel$default(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancel(coroutineContext, cancellationException);
    }

    public static final void cancel(CoroutineContext coroutineContext, CancellationException cancellationException) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            job.cancel(cancellationException);
        }
    }

    public static final void ensureActive(Job job) {
        if (!job.isActive()) {
            throw job.getCancellationException();
        }
    }

    public static final void ensureActive(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            JobKt.ensureActive(job);
        }
    }

    public static final void cancel(Job job, String str, Throwable th) {
        job.cancel(ExceptionsKt.CancellationException(str, th));
    }

    public static /* synthetic */ void cancel$default(Job job, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        JobKt.cancel(job, str, th);
    }

    public static /* synthetic */ boolean cancel$default(CoroutineContext coroutineContext, Throwable th, int i, Object obj) {
        boolean cancel;
        if ((i & 1) != 0) {
            th = null;
        }
        cancel = cancel(coroutineContext, th);
        return cancel;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ boolean cancel(CoroutineContext coroutineContext, Throwable th) {
        CoroutineContext.Element element = coroutineContext.get(Job.Key);
        JobSupport jobSupport = element instanceof JobSupport ? (JobSupport) element : null;
        if (jobSupport == null) {
            return false;
        }
        jobSupport.cancelInternal(orCancellation$JobKt__JobKt(th, jobSupport));
        return true;
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancelChildren(coroutineContext, cancellationException);
    }

    public static final void cancelChildren(CoroutineContext coroutineContext, CancellationException cancellationException) {
        Sequence<Job> children;
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job == null || (children = job.getChildren()) == null) {
            return;
        }
        for (Job job2 : children) {
            job2.cancel(cancellationException);
        }
    }

    public static final Job getJob(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            return job;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        cancelChildren(coroutineContext, th);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(CoroutineContext coroutineContext, Throwable th) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job == null) {
            return;
        }
        for (Job job2 : job.getChildren()) {
            JobSupport jobSupport = job2 instanceof JobSupport ? (JobSupport) job2 : null;
            if (jobSupport != null) {
                jobSupport.cancelInternal(orCancellation$JobKt__JobKt(th, job));
            }
        }
    }

    private static final Throwable orCancellation$JobKt__JobKt(Throwable th, Job job) {
        return th == null ? new JobCancellationException("Job was cancelled", null, job) : th;
    }
}
