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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BankScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizonagames.feature.arizona.bank.BankScreen$startGiveawayPrizesPollingIfNeeded$1", f = "BankScreen.kt", i = {0, 1, 2, 3, 3}, l = {720, 723, 724, 726}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch", "$this$launch", "prizes"}, nl = {722, 724, 726, 736}, s = {"L$0", "L$0", "L$0", "L$0", "L$1"}, v = 2)
/* loaded from: classes3.dex */
public final class BankScreen$startGiveawayPrizesPollingIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayUntilResultsMs;
    final /* synthetic */ int $requestGeneration;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ BankScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankScreen$startGiveawayPrizesPollingIfNeeded$1(long j, BankScreen bankScreen, int i, Continuation<? super BankScreen$startGiveawayPrizesPollingIfNeeded$1> continuation) {
        super(2, continuation);
        this.$delayUntilResultsMs = j;
        this.this$0 = bankScreen;
        this.$requestGeneration = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BankScreen$startGiveawayPrizesPollingIfNeeded$1 bankScreen$startGiveawayPrizesPollingIfNeeded$1 = new BankScreen$startGiveawayPrizesPollingIfNeeded$1(this.$delayUntilResultsMs, this.this$0, this.$requestGeneration, continuation);
        bankScreen$startGiveawayPrizesPollingIfNeeded$1.L$0 = obj;
        return bankScreen$startGiveawayPrizesPollingIfNeeded$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BankScreen$startGiveawayPrizesPollingIfNeeded$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
        if (kotlinx.coroutines.DelayKt.delay(r8, r12) == r1) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0065, code lost:
        if (kotlinx.coroutines.DelayKt.delay(60000, r12) == r1) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0075, code lost:
        if (r13 == r1) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009c, code lost:
        if (r13 == r1) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009e, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a5, code lost:
        if (((java.lang.Boolean) r13).booleanValue() == false) goto L20;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x009c -> B:30:0x009f). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long j = this.$delayUntilResultsMs;
            if (j > 0) {
                this.L$0 = coroutineScope;
                this.label = 1;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = coroutineScope;
            this.label = 3;
            obj = this.this$0.loadGiveawayPrizesOrNull(this);
        } else if (i == 3) {
            ResultKt.throwOnFailure(obj);
            List list = (List) obj;
            this.L$0 = coroutineScope;
            this.L$1 = SpillingKt.nullOutSpilledVariable(list);
            this.label = 4;
            obj = BuildersKt.withContext(Dispatchers.getMain(), new BankScreen$startGiveawayPrizesPollingIfNeeded$1$shouldContinue$1(this.$requestGeneration, this.this$0, list, null), this);
        } else if (i != 4) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            List list2 = (List) this.L$1;
            ResultKt.throwOnFailure(obj);
        }
        if (CoroutineScopeKt.isActive(coroutineScope)) {
            this.L$0 = coroutineScope;
            this.L$1 = null;
            this.label = 2;
        }
        return Unit.INSTANCE;
    }
}
