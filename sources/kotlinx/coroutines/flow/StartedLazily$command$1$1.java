package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SharingStarted.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StartedLazily$command$1$1<T> implements FlowCollector {
    final /* synthetic */ Ref.BooleanRef $started;
    final /* synthetic */ FlowCollector<SharingCommand> $this_unsafeFlow;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public StartedLazily$command$1$1(Ref.BooleanRef booleanRef, FlowCollector<? super SharingCommand> flowCollector) {
        this.$started = booleanRef;
        this.$this_unsafeFlow = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(int i, Continuation<? super Unit> continuation) {
        StartedLazily$command$1$1$emit$1 startedLazily$command$1$1$emit$1;
        int i2;
        if (continuation instanceof StartedLazily$command$1$1$emit$1) {
            startedLazily$command$1$1$emit$1 = (StartedLazily$command$1$1$emit$1) continuation;
            if ((startedLazily$command$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                startedLazily$command$1$1$emit$1.label -= Integer.MIN_VALUE;
                Object obj = startedLazily$command$1$1$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = startedLazily$command$1$1$emit$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (i <= 0 || this.$started.element) {
                        return Unit.INSTANCE;
                    }
                    this.$started.element = true;
                    FlowCollector<SharingCommand> flowCollector = this.$this_unsafeFlow;
                    SharingCommand sharingCommand = SharingCommand.START;
                    startedLazily$command$1$1$emit$1.I$0 = i;
                    startedLazily$command$1$1$emit$1.label = 1;
                    if (flowCollector.emit(sharingCommand, startedLazily$command$1$1$emit$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i3 = startedLazily$command$1$1$emit$1.I$0;
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
        startedLazily$command$1$1$emit$1 = new StartedLazily$command$1$1$emit$1(this, continuation);
        Object obj2 = startedLazily$command$1$1$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = startedLazily$command$1$1$emit$1.label;
        if (i2 != 0) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit(((Number) obj).intValue(), continuation);
    }
}
