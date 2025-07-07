package ru.mrlargha.commonui.elements.hud;

import android.app.Activity;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AnimatedMoneyText.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tJ\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\tH\u0002J\u0006\u0010\u0016\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/hud/AnimatedMoneyText;", "", "textView", "Landroid/widget/TextView;", "targetActivity", "Landroid/app/Activity;", "<init>", "(Landroid/widget/TextView;Landroid/app/Activity;)V", "currentRealValue", "", "currentVisualValue", "thread", "Ljava/lang/Thread;", "formatter", "Ljava/text/DecimalFormat;", "updateMoney", "", "money", "runnable", "Ljava/lang/Runnable;", "updateText", "toValue", "getCurrentVisualValue", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AnimatedMoneyText {
    private int currentRealValue;
    private int currentVisualValue;
    private final DecimalFormat formatter;
    private Runnable runnable;
    private final Activity targetActivity;
    private final TextView textView;
    private Thread thread;

    public AnimatedMoneyText(TextView textView, Activity targetActivity) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.textView = textView;
        this.targetActivity = targetActivity;
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.getDefault());
        decimalFormatSymbols.setGroupingSeparator('.');
        this.formatter = new DecimalFormat("###,###.###", decimalFormatSymbols);
        this.runnable = new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.AnimatedMoneyText$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AnimatedMoneyText.runnable$lambda$1(AnimatedMoneyText.this);
            }
        };
    }

    public final void updateMoney(int i) {
        Thread thread;
        this.currentRealValue = i;
        Thread thread2 = this.thread;
        if (thread2 != null && thread2.isAlive() && (thread = this.thread) != null) {
            thread.interrupt();
        }
        try {
            Thread thread3 = new Thread(this.runnable);
            this.thread = thread3;
            thread3.start();
        } catch (Exception unused) {
            updateText(this.currentRealValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runnable$lambda$1(AnimatedMoneyText animatedMoneyText) {
        while (animatedMoneyText.currentVisualValue < animatedMoneyText.currentRealValue && !Thread.currentThread().isInterrupted()) {
            int i = animatedMoneyText.currentVisualValue;
            int ceil = i + ((int) Math.ceil(Math.abs(animatedMoneyText.currentRealValue - i) * 0.005d));
            animatedMoneyText.currentVisualValue = ceil;
            int i2 = animatedMoneyText.currentRealValue;
            if (ceil > i2) {
                animatedMoneyText.currentVisualValue = i2;
            }
            animatedMoneyText.updateText(animatedMoneyText.currentVisualValue);
            try {
                Thread.sleep(10L);
            } catch (InterruptedException unused) {
                animatedMoneyText.updateText(animatedMoneyText.currentRealValue);
            }
        }
        while (animatedMoneyText.currentVisualValue > animatedMoneyText.currentRealValue && !Thread.currentThread().isInterrupted()) {
            int i3 = animatedMoneyText.currentVisualValue;
            int ceil2 = i3 - ((int) Math.ceil(Math.abs(animatedMoneyText.currentRealValue - i3) * 0.005d));
            animatedMoneyText.currentVisualValue = ceil2;
            int i4 = animatedMoneyText.currentRealValue;
            if (ceil2 < i4) {
                animatedMoneyText.currentVisualValue = i4;
            }
            animatedMoneyText.updateText(animatedMoneyText.currentVisualValue);
            try {
                Thread.sleep(10L);
            } catch (InterruptedException unused2) {
                animatedMoneyText.updateText(animatedMoneyText.currentRealValue);
                return;
            }
        }
    }

    private final void updateText(final int i) {
        this.targetActivity.runOnUiThread(new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.AnimatedMoneyText$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AnimatedMoneyText.updateText$lambda$2(AnimatedMoneyText.this, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateText$lambda$2(AnimatedMoneyText animatedMoneyText, int i) {
        animatedMoneyText.textView.setText(animatedMoneyText.formatter.format(Integer.valueOf(i)));
    }

    public final int getCurrentVisualValue() {
        return this.currentVisualValue;
    }
}
