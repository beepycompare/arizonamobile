package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.counter;

import android.os.CountDownTimer;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;
import ru.mrlargha.commonui.databinding.HudTaximeterBinding;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: HudCounter.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"ru/mrlargha/commonui/elements/hud/presentation/hud_screens/counter/HudCounter$startTaxiTimerCountUp$1$1", "Landroid/os/CountDownTimer;", "onTick", "", "millisUntilFinished", "", "onFinish", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudCounter$startTaxiTimerCountUp$1$1 extends CountDownTimer {
    final /* synthetic */ Ref.IntRef $currentSeconds;
    final /* synthetic */ int $maxSeconds;
    final /* synthetic */ HudTaximeterBinding $this_with;
    final /* synthetic */ HudCounter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HudCounter$startTaxiTimerCountUp$1$1(Ref.IntRef intRef, int i, HudCounter hudCounter, HudTaximeterBinding hudTaximeterBinding, long j) {
        super(j, 1000L);
        this.$currentSeconds = intRef;
        this.$maxSeconds = i;
        this.this$0 = hudCounter;
        this.$this_with = hudTaximeterBinding;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        TextView textView;
        if (this.$currentSeconds.element >= this.$maxSeconds) {
            onFinish();
            return;
        }
        final String formatTime = UtilsKt.formatTime(this.$currentSeconds.element * 1000);
        textView = this.this$0.firstTextView;
        if (textView == null) {
            final HudTaximeterBinding hudTaximeterBinding = this.$this_with;
            new Function0() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.counter.HudCounter$startTaxiTimerCountUp$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit onTick$lambda$1;
                    onTick$lambda$1 = HudCounter$startTaxiTimerCountUp$1$1.onTick$lambda$1(HudTaximeterBinding.this, formatTime);
                    return onTick$lambda$1;
                }
            };
        } else {
            textView.setText(formatTime);
        }
        this.$currentSeconds.element++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onTick$lambda$1(HudTaximeterBinding hudTaximeterBinding, String str) {
        String str2 = str;
        hudTaximeterBinding.hudTaximeterLayoutContainer.tvTaximeterTime.setText(str2);
        hudTaximeterBinding.hudTaximeterArmySecond.tvArmySecondTimer.setText(str2);
        hudTaximeterBinding.counter.firstItem.tvSimpleTime.setText(str2);
        return Unit.INSTANCE;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        TextView textView;
        this.this$0.isRunningTaxiTimer = false;
        final String formatTime = UtilsKt.formatTime(this.$currentSeconds.element * 1000);
        textView = this.this$0.firstTextView;
        if (textView == null) {
            final HudTaximeterBinding hudTaximeterBinding = this.$this_with;
            new Function0() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.counter.HudCounter$startTaxiTimerCountUp$1$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit onFinish$lambda$3;
                    onFinish$lambda$3 = HudCounter$startTaxiTimerCountUp$1$1.onFinish$lambda$3(HudTaximeterBinding.this, formatTime);
                    return onFinish$lambda$3;
                }
            };
            return;
        }
        textView.setText(formatTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onFinish$lambda$3(HudTaximeterBinding hudTaximeterBinding, String str) {
        String str2 = str;
        hudTaximeterBinding.hudTaximeterLayoutContainer.tvTaximeterTime.setText(str2);
        hudTaximeterBinding.hudTaximeterArmySecond.tvArmySecondTimer.setText(str2);
        hudTaximeterBinding.counter.firstItem.tvSimpleTime.setText(str2);
        return Unit.INSTANCE;
    }
}
