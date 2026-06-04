package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.gathers_count;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import ru.mrlargha.commonui.databinding.HudGathersCountBinding;
/* compiled from: HudGathersCount.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.hud.presentation.hud_screens.gathers_count.HudGathersCount$startTimer$1$1", f = "HudGathersCount.kt", i = {0, 0}, l = {81}, m = "invokeSuspend", n = {"$this$launch", "seconds"}, nl = {82}, s = {"L$0", "I$0"}, v = 2)
/* loaded from: classes6.dex */
final class HudGathersCount$startTimer$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HudGathersCountBinding $this_with;
    final /* synthetic */ int $time;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HudGathersCount this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HudGathersCount$startTimer$1$1(int i, HudGathersCount hudGathersCount, HudGathersCountBinding hudGathersCountBinding, Continuation<? super HudGathersCount$startTimer$1$1> continuation) {
        super(2, continuation);
        this.$time = i;
        this.this$0 = hudGathersCount;
        this.$this_with = hudGathersCountBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HudGathersCount$startTimer$1$1 hudGathersCount$startTimer$1$1 = new HudGathersCount$startTimer$1$1(this.$time, this.this$0, this.$this_with, continuation);
        hudGathersCount$startTimer$1$1.L$0 = obj;
        return hudGathersCount$startTimer$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HudGathersCount$startTimer$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:15:0x003d). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int i;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            i = this.$time;
            if (!CoroutineScopeKt.isActive(coroutineScope)) {
            }
            return Unit.INSTANCE;
        } else if (i2 == 1) {
            i = this.I$0;
            ResultKt.throwOnFailure(obj);
            HudGathersCount hudGathersCount = this.this$0;
            TextView tvTimer = this.$this_with.tvTimer;
            Intrinsics.checkNotNullExpressionValue(tvTimer, "tvTimer");
            hudGathersCount.timeConvertor(tvTimer, i);
            i--;
            if (!CoroutineScopeKt.isActive(coroutineScope) && i >= 0) {
                this.L$0 = coroutineScope;
                this.I$0 = i;
                this.label = 1;
                if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                HudGathersCount hudGathersCount2 = this.this$0;
                TextView tvTimer2 = this.$this_with.tvTimer;
                Intrinsics.checkNotNullExpressionValue(tvTimer2, "tvTimer");
                hudGathersCount2.timeConvertor(tvTimer2, i);
                i--;
                if (!CoroutineScopeKt.isActive(coroutineScope)) {
                }
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
