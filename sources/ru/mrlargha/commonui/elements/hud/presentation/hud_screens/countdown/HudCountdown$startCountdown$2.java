package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.countdown;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
/* compiled from: HudCountdown.kt */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"ru/mrlargha/commonui/elements/hud/presentation/hud_screens/countdown/HudCountdown$startCountdown$2", "Ljava/lang/Runnable;", "run", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudCountdown$startCountdown$2 implements Runnable {
    final /* synthetic */ Ref.IntRef $seconds;
    final /* synthetic */ HudCountdown this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HudCountdown$startCountdown$2(Ref.IntRef intRef, HudCountdown hudCountdown) {
        this.$seconds = intRef;
        this.this$0 = hudCountdown;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        this.$seconds.element--;
        int i = this.$seconds.element;
        HudCountdown hudCountdown = this.this$0;
        if (i >= 1) {
            hudCountdown.showCountdownNumber(this.$seconds.element);
            handler2 = this.this$0.handler;
            handler2.postDelayed(this, 1000L);
            return;
        }
        hudCountdown.showStartLabel();
        final HudCountdown hudCountdown2 = this.this$0;
        Runnable runnable = new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.countdown.HudCountdown$startCountdown$2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                HudCountdown.this.hideAfterStart();
            }
        };
        handler = this.this$0.handler;
        handler.postDelayed(runnable, 900L);
        hudCountdown2.startRunnable = runnable;
        this.this$0.countdownRunnable = null;
    }
}
