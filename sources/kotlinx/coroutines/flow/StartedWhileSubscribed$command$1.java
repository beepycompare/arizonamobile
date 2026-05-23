package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
/* compiled from: SharingStarted.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;", "count", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4}, l = {175, 177, 179, 180, 182}, m = "invokeSuspend", n = {"$this$transformLatest", "count", "$this$transformLatest", "count", "$this$transformLatest", "count", "$this$transformLatest", "count", "$this$transformLatest", "count"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0", "I$0"}, v = 1)
/* loaded from: classes5.dex */
final class StartedWhileSubscribed$command$1 extends SuspendLambda implements Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StartedWhileSubscribed this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartedWhileSubscribed$command$1(StartedWhileSubscribed startedWhileSubscribed, Continuation<? super StartedWhileSubscribed$command$1> continuation) {
        super(3, continuation);
        this.this$0 = startedWhileSubscribed;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super SharingCommand> flowCollector, Integer num, Continuation<? super Unit> continuation) {
        return invoke(flowCollector, num.intValue(), continuation);
    }

    public final Object invoke(FlowCollector<? super SharingCommand> flowCollector, int i, Continuation<? super Unit> continuation) {
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1(this.this$0, continuation);
        startedWhileSubscribed$command$1.L$0 = flowCollector;
        startedWhileSubscribed$command$1.I$0 = i;
        return startedWhileSubscribed$command$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0050, code lost:
        if (r0.emit(kotlinx.coroutines.flow.SharingCommand.START, r11) == r2) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
        if (kotlinx.coroutines.DelayKt.delay(r8, r11) == r2) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0084, code lost:
        if (r0.emit(kotlinx.coroutines.flow.SharingCommand.STOP, r11) == r2) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009a, code lost:
        if (kotlinx.coroutines.DelayKt.delay(r6, r11) == r2) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b0, code lost:
        if (r0.emit(kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE, r11) != r2) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        long j;
        long j2;
        long j3;
        FlowCollector flowCollector = (FlowCollector) this.L$0;
        int i = this.I$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (i > 0) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.I$0 = i;
                this.label = 1;
            } else {
                j = this.this$0.stopTimeout;
                this.L$0 = flowCollector;
                this.I$0 = i;
                this.label = 2;
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(obj);
                j2 = this.this$0.replayExpiration;
                if (j2 > 0) {
                    this.L$0 = flowCollector;
                    this.I$0 = i;
                    this.label = 3;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.I$0 = i;
                this.label = 5;
            } else if (i2 == 3) {
                ResultKt.throwOnFailure(obj);
                j3 = this.this$0.replayExpiration;
                this.L$0 = flowCollector;
                this.I$0 = i;
                this.label = 4;
            } else if (i2 == 4) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.I$0 = i;
                this.label = 5;
            } else if (i2 != 5) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
        ResultKt.throwOnFailure(obj);
        return Unit.INSTANCE;
    }
}
