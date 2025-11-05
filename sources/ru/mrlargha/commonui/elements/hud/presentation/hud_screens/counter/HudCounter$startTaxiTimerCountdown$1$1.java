package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.counter;

import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import ru.mrlargha.commonui.databinding.HudTaximeterBinding;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: HudCounter.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"ru/mrlargha/commonui/elements/hud/presentation/hud_screens/counter/HudCounter$startTaxiTimerCountdown$1$1", "Landroid/os/CountDownTimer;", "onTick", "", "millisUntilFinished", "", "onFinish", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudCounter$startTaxiTimerCountdown$1$1 extends CountDownTimer {
    final /* synthetic */ HudTaximeterBinding $this_with;
    final /* synthetic */ HudCounter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HudCounter$startTaxiTimerCountdown$1$1(HudCounter hudCounter, HudTaximeterBinding hudTaximeterBinding, long j) {
        super(j, 1000L);
        this.this$0 = hudCounter;
        this.$this_with = hudTaximeterBinding;
    }

    @Override // android.os.CountDownTimer
    public void onTick(final long j) {
        TextView textView;
        Log.d("taximeter", "onTickDownTick: " + UtilsKt.formatTime(j));
        textView = this.this$0.firstTextView;
        if (textView == null) {
            final HudTaximeterBinding hudTaximeterBinding = this.$this_with;
            new Function0() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.counter.HudCounter$startTaxiTimerCountdown$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit onTick$lambda$1;
                    onTick$lambda$1 = HudCounter$startTaxiTimerCountdown$1$1.onTick$lambda$1(HudTaximeterBinding.this, j);
                    return onTick$lambda$1;
                }
            };
            return;
        }
        textView.setText(UtilsKt.formatTime(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onTick$lambda$1(HudTaximeterBinding hudTaximeterBinding, long j) {
        hudTaximeterBinding.hudTaximeterLayoutContainer.tvTaximeterTime.setText(UtilsKt.formatTime(j));
        hudTaximeterBinding.hudTaximeterArmySecond.tvArmySecondTimer.setText(UtilsKt.formatTime(j));
        hudTaximeterBinding.counter.firstItem.tvSimpleTime.setText(UtilsKt.formatTime(j));
        return Unit.INSTANCE;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.this$0.isRunningTaxiTimer = false;
    }
}
