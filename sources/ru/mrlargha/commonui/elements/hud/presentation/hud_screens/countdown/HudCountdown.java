package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.countdown;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.HudCountdownBinding;
/* compiled from: HudCountdown.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\fJ\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002J\b\u0010\u0017\u001a\u00020\fH\u0002J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/countdown/HudCountdown;", "", "binding", "Lru/mrlargha/commonui/databinding/HudCountdownBinding;", "<init>", "(Lru/mrlargha/commonui/databinding/HudCountdownBinding;)V", "handler", "Landroid/os/Handler;", "countdownRunnable", "Ljava/lang/Runnable;", "startRunnable", "event", "", "payload", "", "clear", "startCountdown", "initialSeconds", "", "hideAfterStart", "showCountdownNumber", "value", "showStartLabel", "animateCountdownLabel", "applyCountdownAccent", "color", "cancelScheduledWork", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudCountdown {
    @Deprecated
    public static final long COUNTDOWN_ANIMATION_MS = 180;
    @Deprecated
    public static final float COUNTDOWN_INITIAL_ALPHA = 0.35f;
    @Deprecated
    public static final float COUNTDOWN_INITIAL_SCALE = 0.72f;
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final long MILLIS_PER_SECOND = 1000;
    @Deprecated
    public static final int MIN_COUNTDOWN_SECONDS = 1;
    @Deprecated
    public static final long START_LABEL_DURATION_MS = 900;
    private final HudCountdownBinding binding;
    private Runnable countdownRunnable;
    private final Handler handler;
    private Runnable startRunnable;

    public HudCountdown(HudCountdownBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        this.handler = new Handler(Looper.getMainLooper());
        float dimension = binding.getRoot().getResources().getDimension(R.dimen._1sdp);
        binding.countdownLabel.setShadowLayer(dimension, 0.0f, dimension, Color.argb(128, 0, 0, 0));
        binding.getRoot().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.countdown.HudCountdown.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                HudCountdown.this.clear();
            }
        });
    }

    public final void event(String payload) {
        int intValue;
        Intrinsics.checkNotNullParameter(payload, "payload");
        String str = payload;
        if (StringsKt.isBlank(str)) {
            clear();
            return;
        }
        Integer intOrNull = StringsKt.toIntOrNull(StringsKt.trim((CharSequence) str).toString());
        if (intOrNull == null || (intValue = intOrNull.intValue()) < 1) {
            return;
        }
        startCountdown(intValue);
    }

    public final void clear() {
        cancelScheduledWork();
        HudCountdownBinding hudCountdownBinding = this.binding;
        hudCountdownBinding.getRoot().animate().cancel();
        hudCountdownBinding.countdownLabel.animate().cancel();
        FrameLayout root = hudCountdownBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(8);
        hudCountdownBinding.getRoot().setAlpha(1.0f);
        hudCountdownBinding.countdownLabel.setAlpha(1.0f);
        hudCountdownBinding.countdownLabel.setScaleX(1.0f);
        hudCountdownBinding.countdownLabel.setScaleY(1.0f);
        LinearLayout countdownContainer = hudCountdownBinding.countdownContainer;
        Intrinsics.checkNotNullExpressionValue(countdownContainer, "countdownContainer");
        countdownContainer.setVisibility(0);
    }

    private final void startCountdown(int i) {
        cancelScheduledWork();
        HudCountdownBinding hudCountdownBinding = this.binding;
        hudCountdownBinding.getRoot().animate().cancel();
        FrameLayout root = hudCountdownBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        hudCountdownBinding.getRoot().setAlpha(1.0f);
        LinearLayout countdownContainer = hudCountdownBinding.countdownContainer;
        Intrinsics.checkNotNullExpressionValue(countdownContainer, "countdownContainer");
        countdownContainer.setVisibility(0);
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = i;
        showCountdownNumber(intRef.element);
        HudCountdown$startCountdown$2 hudCountdown$startCountdown$2 = new HudCountdown$startCountdown$2(intRef, this);
        this.handler.postDelayed(hudCountdown$startCountdown$2, 1000L);
        this.countdownRunnable = hudCountdown$startCountdown$2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideAfterStart() {
        this.startRunnable = null;
        clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCountdownNumber(int i) {
        this.binding.countdownLabel.setText(String.valueOf(i));
        applyCountdownAccent(-1);
        animateCountdownLabel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showStartLabel() {
        HudCountdownBinding hudCountdownBinding = this.binding;
        hudCountdownBinding.countdownLabel.setText(R.string.hud_drift_counter_start);
        applyCountdownAccent(ContextCompat.getColor(hudCountdownBinding.getRoot().getContext(), R.color.hud_drift_counter_accent));
        animateCountdownLabel();
    }

    private final void animateCountdownLabel() {
        TextView textView = this.binding.countdownLabel;
        textView.animate().cancel();
        textView.setAlpha(0.35f);
        textView.setScaleX(0.72f);
        textView.setScaleY(0.72f);
        textView.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(180L).start();
    }

    private final void applyCountdownAccent(int i) {
        this.binding.countdownLabel.setTextColor(i);
    }

    private final void cancelScheduledWork() {
        Runnable runnable = this.countdownRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.startRunnable;
        if (runnable2 != null) {
            this.handler.removeCallbacks(runnable2);
        }
        this.countdownRunnable = null;
        this.startRunnable = null;
    }

    /* compiled from: HudCountdown.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/countdown/HudCountdown$Companion;", "", "<init>", "()V", "MIN_COUNTDOWN_SECONDS", "", "MILLIS_PER_SECOND", "", "START_LABEL_DURATION_MS", "COUNTDOWN_ANIMATION_MS", "COUNTDOWN_INITIAL_ALPHA", "", "COUNTDOWN_INITIAL_SCALE", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
