package com.arizonagames.feature.arizona.bank;

import java.util.List;
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
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BankScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizonagames.feature.arizona.bank.BankScreen$requestGiveawayPrizesIfNeeded$1", f = "BankScreen.kt", i = {1}, l = {673, 675}, m = "invokeSuspend", n = {"prizes"}, nl = {675, 683}, s = {"L$0"}, v = 2)
/* loaded from: classes3.dex */
public final class BankScreen$requestGiveawayPrizesIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $requestGeneration;
    Object L$0;
    int label;
    final /* synthetic */ BankScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankScreen$requestGiveawayPrizesIfNeeded$1(BankScreen bankScreen, int i, Continuation<? super BankScreen$requestGiveawayPrizesIfNeeded$1> continuation) {
        super(2, continuation);
        this.this$0 = bankScreen;
        this.$requestGeneration = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BankScreen$requestGiveawayPrizesIfNeeded$1(this.this$0, this.$requestGeneration, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BankScreen$requestGiveawayPrizesIfNeeded$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (r8 == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0056, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.arizonagames.feature.arizona.bank.BankScreen$requestGiveawayPrizesIfNeeded$1.AnonymousClass1(r7.$requestGeneration, r7.this$0, r8, null), r7) == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.loadGiveawayPrizesOrNull(this);
        } else if (i != 1) {
            if (i == 2) {
                List list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        List list2 = (List) obj;
        this.L$0 = SpillingKt.nullOutSpilledVariable(list2);
        this.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BankScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.arizonagames.feature.arizona.bank.BankScreen$requestGiveawayPrizesIfNeeded$1$1", f = "BankScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    /* renamed from: com.arizonagames.feature.arizona.bank.BankScreen$requestGiveawayPrizesIfNeeded$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<BankLotteryRewardInfo> $prizes;
        final /* synthetic */ int $requestGeneration;
        int label;
        final /* synthetic */ BankScreen this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, BankScreen bankScreen, List<BankLotteryRewardInfo> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$requestGeneration = i;
            this.this$0 = bankScreen;
            this.$prizes = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$requestGeneration, this.this$0, this.$prizes, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            int i2 = this.$requestGeneration;
            i = this.this$0.openingStateGeneration;
            if (i2 == i) {
                this.this$0.isGiveawayPrizesRequestInFlight = false;
                List<BankLotteryRewardInfo> list = this.$prizes;
                if (list != null) {
                    this.this$0.bindGiveawayPrizes(list);
                }
                this.this$0.startGiveawayPrizesPollingIfNeeded();
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }
}
