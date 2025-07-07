package androidx.paging;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.paging.SingleRunner;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SingleRunner.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.SingleRunner$runInIsolation$2", f = "SingleRunner.kt", i = {0, 1}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF, 59, LockFreeTaskQueueCore.CLOSED_SHIFT, LockFreeTaskQueueCore.CLOSED_SHIFT}, m = "invokeSuspend", n = {"myJob", "myJob"}, s = {"L$0", "L$0"})
/* loaded from: classes3.dex */
public final class SingleRunner$runInIsolation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    final /* synthetic */ int $priority;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SingleRunner this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SingleRunner$runInIsolation$2(SingleRunner singleRunner, int i, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super SingleRunner$runInIsolation$2> continuation) {
        super(2, continuation);
        this.this$0 = singleRunner;
        this.$priority = i;
        this.$block = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SingleRunner$runInIsolation$2 singleRunner$runInIsolation$2 = new SingleRunner$runInIsolation$2(this.this$0, this.$priority, this.$block, continuation);
        singleRunner$runInIsolation$2.L$0 = obj;
        return singleRunner$runInIsolation$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SingleRunner$runInIsolation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x007e, code lost:
        if (r10.invoke(r9) == r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0093, code lost:
        if (r10.onFinish(r1, r2) == r0) goto L20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v15, types: [androidx.paging.SingleRunner$Holder] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.Job] */
    /* JADX WARN: Type inference failed for: r1v10, types: [kotlinx.coroutines.Job] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.paging.SingleRunner$Holder] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ?? r3;
        SingleRunner.Holder holder;
        Job job;
        ?? r10;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        SingleRunner$runInIsolation$2 singleRunner$runInIsolation$2 = 4;
        try {
        } catch (Throwable th) {
            r3 = this.this$0.holder;
            this.L$0 = th;
            this.label = singleRunner$runInIsolation$2;
            if (r3.onFinish(r1, this) != coroutine_suspended) {
                throw th;
            }
        }
        if (r1 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineContext.Element element = ((CoroutineScope) this.L$0).getCoroutineContext().get(Job.Key);
            if (element != null) {
                Job job2 = (Job) element;
                holder = this.this$0.holder;
                this.L$0 = job2;
                this.label = 1;
                Object tryEnqueue = holder.tryEnqueue(this.$priority, job2, this);
                if (tryEnqueue != coroutine_suspended) {
                    job = job2;
                    obj = tryEnqueue;
                }
                return coroutine_suspended;
            }
            throw new IllegalStateException("Internal error. coroutineScope should've created a job.".toString());
        } else if (r1 == 1) {
            job = (Job) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (r1 != 2) {
            if (r1 == 3) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else if (r1 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                Throwable th2 = (Throwable) this.L$0;
                ResultKt.throwOnFailure(obj);
                throw th2;
            }
        } else {
            Job job3 = (Job) this.L$0;
            ResultKt.throwOnFailure(obj);
            r1 = job3;
            r10 = this.this$0.holder;
            singleRunner$runInIsolation$2 = this;
            this.L$0 = null;
            this.label = 3;
        }
        if (((Boolean) obj).booleanValue()) {
            Function1<Continuation<? super Unit>, Object> function1 = this.$block;
            this.L$0 = job;
            this.label = 2;
            r1 = job;
        }
        return Unit.INSTANCE;
    }
}
