package kotlinx.coroutines.rx2;

import androidx.compose.runtime.GapComposerKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RxScheduler.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxSchedulerKt", f = "RxScheduler.kt", i = {0, 0, 0}, l = {GapComposerKt.nodeKey}, m = "scheduleTask$task", n = {"disposableRef", "ctx", "decoratedBlock"}, s = {"L$0", "L$1", "L$2"}, v = 1)
/* loaded from: classes5.dex */
public final class RxSchedulerKt$scheduleTask$task$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RxSchedulerKt$scheduleTask$task$1(Continuation<? super RxSchedulerKt$scheduleTask$task$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object scheduleTask$task;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        scheduleTask$task = RxSchedulerKt.scheduleTask$task(null, null, null, this);
        return scheduleTask$task;
    }
}
