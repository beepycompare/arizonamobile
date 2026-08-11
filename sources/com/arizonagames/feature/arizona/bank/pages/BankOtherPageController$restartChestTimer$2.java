package com.arizonagames.feature.arizona.bank.pages;

import com.arizonagames.feature.arizona.bank.BankChestInfo;
import java.util.Collection;
import java.util.List;
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
/* compiled from: BankOtherPageController.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizonagames.feature.arizona.bank.pages.BankOtherPageController$restartChestTimer$2", f = "BankOtherPageController.kt", i = {0, 0}, l = {248}, m = "invokeSuspend", n = {"$this$launch", "nowEpochSeconds"}, nl = {250}, s = {"L$0", "J$0"}, v = 2)
/* loaded from: classes3.dex */
public final class BankOtherPageController$restartChestTimer$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BankOtherPageController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankOtherPageController$restartChestTimer$2(BankOtherPageController bankOtherPageController, Continuation<? super BankOtherPageController$restartChestTimer$2> continuation) {
        super(2, continuation);
        this.this$0 = bankOtherPageController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BankOtherPageController$restartChestTimer$2 bankOtherPageController$restartChestTimer$2 = new BankOtherPageController$restartChestTimer$2(this.this$0, continuation);
        bankOtherPageController$restartChestTimer$2.L$0 = obj;
        return bankOtherPageController$restartChestTimer$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BankOtherPageController$restartChestTimer$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long currentEpochSeconds;
        List list;
        boolean hasActiveTimer;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0 || i == 1) {
            ResultKt.throwOnFailure(obj);
            loop0: while (CoroutineScopeKt.isActive(coroutineScope)) {
                currentEpochSeconds = this.this$0.currentEpochSeconds();
                this.this$0.renderChestSection(currentEpochSeconds);
                list = this.this$0.currentChests;
                List<BankChestInfo> list2 = list;
                BankOtherPageController bankOtherPageController = this.this$0;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    for (BankChestInfo bankChestInfo : list2) {
                        hasActiveTimer = bankOtherPageController.hasActiveTimer(bankChestInfo, currentEpochSeconds);
                        if (hasActiveTimer) {
                            this.L$0 = coroutineScope;
                            this.J$0 = currentEpochSeconds;
                            this.label = 1;
                            if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                    break loop0;
                }
                break;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
