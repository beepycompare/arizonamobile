package kotlinx.coroutines;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
/* compiled from: JobSupport.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lkotlinx/coroutines/Job;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {1003, 1005}, m = "invokeSuspend", n = {"$this$sequence", RemoteConfigConstants.ResponseFieldKey.STATE, "$this$sequence", RemoteConfigConstants.ResponseFieldKey.STATE, "list", "this_$iv", "cur$iv", "it", "$i$a$-let-JobSupport$children$1$1", "$i$f$forEach", "$i$a$-forEach-JobSupport$children$1$1$1"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2"}, v = 1)
/* loaded from: classes5.dex */
final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Job>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
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

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0062, code lost:
        if (r0.yield(((kotlinx.coroutines.ChildHandleNode) r12).childJob, r11) == r1) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b8, code lost:
        if (r0.yield(r12, r11) == r1) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ba, code lost:
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x008d -> B:27:0x00bb). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00b8 -> B:27:0x00bb). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        NodeList list;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Object obj2;
        NodeList nodeList;
        Object obj3;
        int i;
        int i2;
        SequenceScope sequenceScope = (SequenceScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Object state$kotlinx_coroutines_core = this.this$0.getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof ChildHandleNode) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(state$kotlinx_coroutines_core);
                this.label = 1;
            } else if ((state$kotlinx_coroutines_core instanceof Incomplete) && (list = ((Incomplete) state$kotlinx_coroutines_core).getList()) != null) {
                NodeList nodeList2 = list;
                Object next = nodeList2.getNext();
                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
                obj2 = state$kotlinx_coroutines_core;
                nodeList = list;
                obj3 = nodeList2;
                i = 0;
                i2 = 0;
                if (!Intrinsics.areEqual(lockFreeLinkedListNode, obj3)) {
                }
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i3 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            i = this.I$1;
            i2 = this.I$0;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) this.L$5;
            lockFreeLinkedListNode = (LockFreeLinkedListNode) this.L$4;
            obj3 = (LockFreeLinkedListHead) this.L$3;
            nodeList = (NodeList) this.L$2;
            obj2 = this.L$1;
            ResultKt.throwOnFailure(obj);
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!Intrinsics.areEqual(lockFreeLinkedListNode, obj3)) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    ChildJob childJob = ((ChildHandleNode) lockFreeLinkedListNode).childJob;
                    this.L$0 = sequenceScope;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(nodeList);
                    this.L$3 = obj3;
                    this.L$4 = lockFreeLinkedListNode;
                    this.L$5 = SpillingKt.nullOutSpilledVariable(lockFreeLinkedListNode);
                    this.I$0 = i2;
                    this.I$1 = i;
                    this.I$2 = 0;
                    this.label = 2;
                }
                lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
                if (!Intrinsics.areEqual(lockFreeLinkedListNode, obj3)) {
                }
            }
        }
        return Unit.INSTANCE;
    }
}
