package ru.mrlargha.feature.battlepassWinter2025;

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
/* compiled from: BattlePassPurchaseController.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.battlepassWinter2025.BattlePassPurchaseController$startLeftTimer$1", f = "BattlePassPurchaseController.kt", i = {0, 0}, l = {337}, m = "invokeSuspend", n = {"$this$launch", "timeLeft"}, nl = {338}, s = {"L$0", "J$0"}, v = 2)
/* loaded from: classes6.dex */
public final class BattlePassPurchaseController$startLeftTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $remainingMillis;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BattlePassPurchaseController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BattlePassPurchaseController$startLeftTimer$1(long j, BattlePassPurchaseController battlePassPurchaseController, Continuation<? super BattlePassPurchaseController$startLeftTimer$1> continuation) {
        super(2, continuation);
        this.$remainingMillis = j;
        this.this$0 = battlePassPurchaseController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BattlePassPurchaseController$startLeftTimer$1 battlePassPurchaseController$startLeftTimer$1 = new BattlePassPurchaseController$startLeftTimer$1(this.$remainingMillis, this.this$0, continuation);
        battlePassPurchaseController$startLeftTimer$1.L$0 = obj;
        return battlePassPurchaseController$startLeftTimer$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BattlePassPurchaseController$startLeftTimer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003d -> B:16:0x0040). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        long j;
        int i;
        String leftTime;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            j = this.$remainingMillis;
            if (CoroutineScopeKt.isActive(coroutineScope)) {
                this.L$0 = coroutineScope;
                this.J$0 = j;
                this.label = 1;
                if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                }
                j -= 1000;
                i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                BattlePassPurchaseController battlePassPurchaseController = this.this$0;
                if (i <= 0) {
                }
            }
            return Unit.INSTANCE;
        } else if (i2 == 1) {
            j = this.J$0;
            ResultKt.throwOnFailure(obj);
            j -= 1000;
            i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            BattlePassPurchaseController battlePassPurchaseController2 = this.this$0;
            if (i <= 0) {
                battlePassPurchaseController2.updateBlockTime(null);
                return Unit.INSTANCE;
            }
            leftTime = battlePassPurchaseController2.setLeftTime(j);
            battlePassPurchaseController2.updateBlockTime(leftTime);
            if (CoroutineScopeKt.isActive(coroutineScope) && j > 0) {
                this.L$0 = coroutineScope;
                this.J$0 = j;
                this.label = 1;
                if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j -= 1000;
                i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                BattlePassPurchaseController battlePassPurchaseController22 = this.this$0;
                if (i <= 0) {
                }
            }
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
