package com.arizonagames.feature.arizona.bank.pages;

import com.arizonagames.feature.arizona.bank.BankDepositDisabledTime;
import com.arizonagames.feature.arizona.bank.BankDepositInfo;
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
/* compiled from: BankDepositPageController.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizonagames.feature.arizona.bank.pages.BankDepositPageController$restartDisabledTimeTicker$1", f = "BankDepositPageController.kt", i = {0}, l = {212}, m = "invokeSuspend", n = {"$this$launch"}, nl = {213}, s = {"L$0"}, v = 2)
/* loaded from: classes3.dex */
public final class BankDepositPageController$restartDisabledTimeTicker$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BankDepositPageController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankDepositPageController$restartDisabledTimeTicker$1(BankDepositPageController bankDepositPageController, Continuation<? super BankDepositPageController$restartDisabledTimeTicker$1> continuation) {
        super(2, continuation);
        this.this$0 = bankDepositPageController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BankDepositPageController$restartDisabledTimeTicker$1 bankDepositPageController$restartDisabledTimeTicker$1 = new BankDepositPageController$restartDisabledTimeTicker$1(this.this$0, continuation);
        bankDepositPageController$restartDisabledTimeTicker$1.L$0 = obj;
        return bankDepositPageController$restartDisabledTimeTicker$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BankDepositPageController$restartDisabledTimeTicker$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003d -> B:16:0x0040). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        BankDepositDisabledTime bankDepositDisabledTime;
        boolean hasAnyActiveTimer;
        BankDepositDisabledTime bankDepositDisabledTime2;
        BankDepositDisabledTime tick;
        BankDepositInfo bankDepositInfo;
        BankDepositDisabledTime bankDepositDisabledTime3;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (CoroutineScopeKt.isActive(coroutineScope)) {
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            BankDepositPageController bankDepositPageController = this.this$0;
            bankDepositDisabledTime2 = bankDepositPageController.displayedDisabledTime;
            tick = bankDepositPageController.tick(bankDepositDisabledTime2);
            bankDepositPageController.displayedDisabledTime = tick;
            bankDepositInfo = this.this$0.currentDeposit;
            if (bankDepositInfo != null) {
                BankDepositPageController bankDepositPageController2 = this.this$0;
                bankDepositDisabledTime3 = bankDepositPageController2.displayedDisabledTime;
                bankDepositPageController2.renderDepositSummary(bankDepositInfo, bankDepositDisabledTime3);
            }
            if (CoroutineScopeKt.isActive(coroutineScope)) {
                BankDepositPageController bankDepositPageController3 = this.this$0;
                bankDepositDisabledTime = bankDepositPageController3.displayedDisabledTime;
                hasAnyActiveTimer = bankDepositPageController3.hasAnyActiveTimer(bankDepositDisabledTime);
                if (hasAnyActiveTimer) {
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    BankDepositPageController bankDepositPageController4 = this.this$0;
                    bankDepositDisabledTime2 = bankDepositPageController4.displayedDisabledTime;
                    tick = bankDepositPageController4.tick(bankDepositDisabledTime2);
                    bankDepositPageController4.displayedDisabledTime = tick;
                    bankDepositInfo = this.this$0.currentDeposit;
                    if (bankDepositInfo != null) {
                    }
                    if (CoroutineScopeKt.isActive(coroutineScope)) {
                    }
                }
            }
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
