package com.arizonagames.feature.arizona.bank.pages;

import com.arizonagames.feature.arizona.bank.BankLotteryInfo;
import com.arizonagames.feature.arizona.bank.BankLotteryResultStateKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BankLotteryPageController.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizonagames.feature.arizona.bank.pages.BankLotteryPageController$restartTimer$1", f = "BankLotteryPageController.kt", i = {0}, l = {448}, m = "invokeSuspend", n = {"$this$launch"}, nl = {449}, s = {"L$0"}, v = 2)
/* loaded from: classes3.dex */
public final class BankLotteryPageController$restartTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BankLotteryPageController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankLotteryPageController$restartTimer$1(BankLotteryPageController bankLotteryPageController, Continuation<? super BankLotteryPageController$restartTimer$1> continuation) {
        super(2, continuation);
        this.this$0 = bankLotteryPageController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BankLotteryPageController$restartTimer$1 bankLotteryPageController$restartTimer$1 = new BankLotteryPageController$restartTimer$1(this.this$0, continuation);
        bankLotteryPageController$restartTimer$1.L$0 = obj;
        return bankLotteryPageController$restartTimer$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BankLotteryPageController$restartTimer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0031 -> B:14:0x0034). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        BankLotteryInfo bankLotteryInfo;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!CoroutineScopeKt.isActive(coroutineScope)) {
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            bankLotteryInfo = this.this$0.currentLottery;
            if (bankLotteryInfo != null) {
                return Unit.INSTANCE;
            }
            this.this$0.renderDynamic(bankLotteryInfo);
            if (BankLotteryResultStateKt.hasBankLotteryEnded$default(bankLotteryInfo, 0L, 2, null)) {
                return Unit.INSTANCE;
            }
            if (!CoroutineScopeKt.isActive(coroutineScope)) {
                this.L$0 = coroutineScope;
                this.label = 1;
                if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                bankLotteryInfo = this.this$0.currentLottery;
                if (bankLotteryInfo != null) {
                }
            } else {
                return Unit.INSTANCE;
            }
        }
    }
}
