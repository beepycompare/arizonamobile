package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
/* compiled from: JobSupport.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lkotlinx/coroutines/Job;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {1, 1, 1}, l = {1003, 1005}, m = "invokeSuspend", n = {"$this$sequence", "this_$iv", "cur$iv"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes5.dex */
final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Job>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ JobSupport this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobSupport$children$1(JobSupport jobSupport, Continuation<? super JobSupport$children$1> continuation) {
        super(2, continuation);
        this.this$0 = jobSupport;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.this$0, continuation);
        jobSupport$children$1.L$0 = obj;
        return jobSupport$children$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Job> sequenceScope, Continuation<? super Unit> continuation) {
        return ((JobSupport$children$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0048, code lost:
        if (r6.yield(((kotlinx.coroutines.ChildHandleNode) r1).childJob, r5) == r0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0083, code lost:
        if (r4.yield(r6, r5) == r0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0085, code lost:
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0070 -> B:27:0x0086). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0083 -> B:27:0x0086). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        NodeList list;
        Object obj2;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        SequenceScope sequenceScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
            Object state$kotlinx_coroutines_core = this.this$0.getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof ChildHandleNode) {
                this.label = 1;
            } else if ((state$kotlinx_coroutines_core instanceof Incomplete) && (list = ((Incomplete) state$kotlinx_coroutines_core).getList()) != null) {
                NodeList nodeList = list;
                Object next = nodeList.getNext();
                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) next;
                obj2 = nodeList;
                lockFreeLinkedListNode = lockFreeLinkedListNode2;
                sequenceScope = sequenceScope2;
                if (!Intrinsics.areEqual(lockFreeLinkedListNode, obj2)) {
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) this.L$2;
            obj2 = (LockFreeLinkedListHead) this.L$1;
            sequenceScope = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!Intrinsics.areEqual(lockFreeLinkedListNode, obj2)) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    ChildJob childJob = ((ChildHandleNode) lockFreeLinkedListNode).childJob;
                    this.L$0 = sequenceScope;
                    this.L$1 = obj2;
                    this.L$2 = lockFreeLinkedListNode;
                    this.label = 2;
                }
                lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
                if (!Intrinsics.areEqual(lockFreeLinkedListNode, obj2)) {
                }
            }
        }
        return Unit.INSTANCE;
    }
}
