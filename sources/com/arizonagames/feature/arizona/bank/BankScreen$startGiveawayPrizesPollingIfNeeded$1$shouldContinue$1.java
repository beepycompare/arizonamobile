package com.arizonagames.feature.arizona.bank;

import com.arizonagames.feature.arizona.bank.navigation.BankNavigator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: BankScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizonagames.feature.arizona.bank.BankScreen$startGiveawayPrizesPollingIfNeeded$1$shouldContinue$1", f = "BankScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes3.dex */
final class BankScreen$startGiveawayPrizesPollingIfNeeded$1$shouldContinue$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ List<BankLotteryRewardInfo> $prizes;
    final /* synthetic */ int $requestGeneration;
    int label;
    final /* synthetic */ BankScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankScreen$startGiveawayPrizesPollingIfNeeded$1$shouldContinue$1(int i, BankScreen bankScreen, List<BankLotteryRewardInfo> list, Continuation<? super BankScreen$startGiveawayPrizesPollingIfNeeded$1$shouldContinue$1> continuation) {
        super(2, continuation);
        this.$requestGeneration = i;
        this.this$0 = bankScreen;
        this.$prizes = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BankScreen$startGiveawayPrizesPollingIfNeeded$1$shouldContinue$1(this.$requestGeneration, this.this$0, this.$prizes, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((BankScreen$startGiveawayPrizesPollingIfNeeded$1$shouldContinue$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i;
        BankNavigator bankNavigator;
        BankScreenPayload bankScreenPayload;
        List list;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        int i2 = this.$requestGeneration;
        i = this.this$0.openingStateGeneration;
        if (i2 == i) {
            bankNavigator = this.this$0.navigator;
            if (bankNavigator.getCurrentPage() == BankPage.LOTTERY) {
                bankScreenPayload = this.this$0.currentPayload;
                if (BankContractKt.hasLotteryPage(bankScreenPayload)) {
                    List<BankLotteryRewardInfo> list2 = this.$prizes;
                    if (list2 != null) {
                        this.this$0.bindGiveawayPrizes(list2);
                    }
                    list = this.this$0.currentGiveawayPrizes;
                    return Boxing.boxBoolean(!BankLotteryResultStateKt.hasAllBankLotteryWinners(list));
                }
            }
        }
        return Boxing.boxBoolean(false);
    }
}
