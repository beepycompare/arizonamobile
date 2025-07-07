package ru.mrlargha.commonui.elements.hud.presentation.hud_screens;

import android.os.CountDownTimer;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
import ru.mrlargha.commonui.databinding.HudProposalScreenBinding;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.HudProposalScreen;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HudProposalScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.hud.presentation.hud_screens.HudProposalScreen$showProposalScreen$2", f = "HudProposalScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class HudProposalScreen$showProposalScreen$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HudProposalScreenBinding $proposalBinding;
    final /* synthetic */ HudProposalScreen.ProposalResponse $proposalResponse;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HudProposalScreen$showProposalScreen$2(HudProposalScreen.ProposalResponse proposalResponse, HudProposalScreenBinding hudProposalScreenBinding, Continuation<? super HudProposalScreen$showProposalScreen$2> continuation) {
        super(2, continuation);
        this.$proposalResponse = proposalResponse;
        this.$proposalBinding = hudProposalScreenBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HudProposalScreen$showProposalScreen$2(this.$proposalResponse, this.$proposalBinding, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HudProposalScreen$showProposalScreen$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CountDownTimer countDownTimer;
        CountDownTimer countDownTimer2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            countDownTimer = HudProposalScreen.timer;
            countDownTimer.cancel();
            HudProposalScreen hudProposalScreen = HudProposalScreen.INSTANCE;
            final HudProposalScreen.ProposalResponse proposalResponse = this.$proposalResponse;
            final HudProposalScreenBinding hudProposalScreenBinding = this.$proposalBinding;
            HudProposalScreen.timer = new CountDownTimer(this.$proposalResponse.getTime() * 1000) { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.HudProposalScreen$showProposalScreen$2.1
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    BigDecimal valueOf = BigDecimal.valueOf((((HudProposalScreen.ProposalResponse.this.getTime() * 1000) - j) * 100) / (HudProposalScreen.ProposalResponse.this.getTime() * 1000));
                    Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
                    hudProposalScreenBinding.proposalProgress.setProgress(100 - valueOf.setScale(1, RoundingMode.HALF_UP).intValue());
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    hudProposalScreenBinding.proposalProgress.setProgress(0);
                }
            };
            countDownTimer2 = HudProposalScreen.timer;
            countDownTimer2.start();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
