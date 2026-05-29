package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.payday;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PaydayElement.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.hud.presentation.hud_screens.payday.PaydayElement$startClock$1", f = "PaydayElement.kt", i = {0, 1, 1}, l = {100, 103}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "e"}, nl = {101, 106}, s = {"L$0", "L$0", "L$1"}, v = 2)
/* loaded from: classes6.dex */
public final class PaydayElement$startClock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ PaydayElement this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaydayElement$startClock$1(PaydayElement paydayElement, Continuation<? super PaydayElement$startClock$1> continuation) {
        super(2, continuation);
        this.this$0 = paydayElement;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PaydayElement$startClock$1 paydayElement$startClock$1 = new PaydayElement$startClock$1(this.this$0, continuation);
        paydayElement$startClock$1.L$0 = obj;
        return paydayElement$startClock$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PaydayElement$startClock$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0030 A[Catch: Exception -> 0x0025, TRY_ENTER, TryCatch #0 {Exception -> 0x0025, blocks: (B:9:0x0021, B:16:0x0030, B:18:0x0038, B:19:0x003d), top: B:27:0x0021 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0070 -> B:14:0x002a). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        PaydayData paydayData;
        long j;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    this.L$0 = coroutineScope;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(e);
                    this.label = 2;
                    if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                    }
                }
                while (CoroutineScopeKt.isActive(coroutineScope)) {
                    paydayData = this.this$0.currentData;
                    if (paydayData != null) {
                        this.this$0.render(paydayData);
                    }
                    j = this.this$0.secondsPassed;
                    this.this$0.secondsPassed = j + 1;
                    this.L$0 = coroutineScope;
                    this.L$1 = null;
                    this.label = 1;
                    if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            } else if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                Exception exc = (Exception) this.L$1;
            }
        }
        ResultKt.throwOnFailure(obj);
        while (CoroutineScopeKt.isActive(coroutineScope)) {
        }
        return Unit.INSTANCE;
    }
}
