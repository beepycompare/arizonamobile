package ru.mrlargha.feature.selector.presentation;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.core.SAMPUIElement;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SelectorScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.selector.presentation.SelectorScreen$startTimer$1", f = "SelectorScreen.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, nl = {121}, s = {}, v = 2)
/* loaded from: classes6.dex */
public final class SelectorScreen$startTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SelectorScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectorScreen$startTimer$1(SelectorScreen selectorScreen, Continuation<? super SelectorScreen$startTimer$1> continuation) {
        super(2, continuation);
        this.this$0 = selectorScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SelectorScreen$startTimer$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SelectorScreen$startTimer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i;
        int i2;
        Job job;
        int i3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            i = this.this$0.timerCount;
            if (i > 0) {
                SelectorScreen selectorScreen = this.this$0;
                i2 = selectorScreen.currentId;
                SAMPUIElement.notifyClick$default(selectorScreen, i2, 0, null, 4, null);
                this.this$0.timerCount = 0;
                job = this.this$0.timerJob;
                if (job != null) {
                    Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
            }
            this.label = 1;
            if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        i3 = this.this$0.timerCount;
        this.this$0.timerCount = i3 + 1;
        this.this$0.startTimer();
        return Unit.INSTANCE;
    }
}
