package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.HudDriftCounterBinding;
/* compiled from: HudDriftCounter.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u0000 &2\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0013J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u000fH\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0011H\u0002J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\b\u0010\"\u001a\u00020\u0013H\u0002J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u000fH\u0002J\b\u0010%\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/drift_counter/HudDriftCounter;", "", "binding", "Lru/mrlargha/commonui/databinding/HudDriftCounterBinding;", "<init>", "(Lru/mrlargha/commonui/databinding/HudDriftCounterBinding;)V", "handler", "Landroid/os/Handler;", "currentState", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/drift_counter/HudDriftCounterState;", "countdownRunnable", "Ljava/lang/Runnable;", "startRunnable", "elapsedRunnable", "displayedElapsedSeconds", "", "introIsRunning", "", "event", "", "payload", "", "clear", "startCountdown", "initialSeconds", "showCountdownNumber", "value", "showStartLabel", "finishIntro", "showCounter", RemoteConfigConstants.ResponseFieldKey.STATE, "restartElapsedTimer", "renderCounter", "startElapsedTimer", "animateCountdownLabel", "applyCountdownAccent", "color", "cancelScheduledWork", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudDriftCounter {
    @Deprecated
    public static final long COUNTDOWN_ANIMATION_MS = 180;
    @Deprecated
    public static final float COUNTDOWN_INITIAL_ALPHA = 0.35f;
    @Deprecated
    public static final float COUNTDOWN_INITIAL_SCALE = 0.72f;
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final int MAX_COUNTDOWN_SECONDS = 10;
    @Deprecated
    public static final long MILLIS_PER_SECOND = 1000;
    @Deprecated
    public static final int MIN_COUNTDOWN_SECONDS = 1;
    @Deprecated
    public static final long SCORE_SHOW_ANIMATION_MS = 220;
    @Deprecated
    public static final long START_LABEL_DURATION_MS = 900;
    private final HudDriftCounterBinding binding;
    private Runnable countdownRunnable;
    private HudDriftCounterState currentState;
    private int displayedElapsedSeconds;
    private Runnable elapsedRunnable;
    private final Handler handler;
    private boolean introIsRunning;
    private Runnable startRunnable;

    public HudDriftCounter(HudDriftCounterBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        this.handler = new Handler(Looper.getMainLooper());
        float dimension = binding.getRoot().getResources().getDimension(R.dimen._1sdp);
        int argb = Color.argb(128, 0, 0, 0);
        binding.countdownLabel.setShadowLayer(dimension, 0.0f, dimension, argb);
        binding.scoreValue.setShadowLayer(dimension, 0.0f, dimension, argb);
    }

    public final void event(String payload) {
        HudDriftCounterState initialStateOrNull;
        int intValue;
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (StringsKt.isBlank(payload)) {
            clear();
            return;
        }
        HudDriftCounterData parseHudDriftCounterPayload = HudDriftCounterDataKt.parseHudDriftCounterPayload(payload);
        if (parseHudDriftCounterPayload == null) {
            return;
        }
        if (parseHudDriftCounterPayload.getCountdownSeconds() == null || (1 <= (intValue = parseHudDriftCounterPayload.getCountdownSeconds().intValue()) && intValue < 11)) {
            HudDriftCounterState hudDriftCounterState = this.currentState;
            if ((hudDriftCounterState == null || (initialStateOrNull = HudDriftCounterDataKt.merge(hudDriftCounterState, parseHudDriftCounterPayload)) == null) && (initialStateOrNull = HudDriftCounterDataKt.toInitialStateOrNull(parseHudDriftCounterPayload)) == null) {
                return;
            }
            this.currentState = initialStateOrNull;
            boolean z = parseHudDriftCounterPayload.getCountdownSeconds() != null;
            if (hudDriftCounterState == null && z) {
                startCountdown(initialStateOrNull.getCountdownSeconds());
            } else if (hudDriftCounterState == null) {
                showCounter(initialStateOrNull, true);
            } else if (z) {
                startCountdown(initialStateOrNull.getCountdownSeconds());
            } else if (this.introIsRunning) {
            } else {
                showCounter(initialStateOrNull, parseHudDriftCounterPayload.getElapsedSeconds() != null);
            }
        }
    }

    public final void clear() {
        cancelScheduledWork();
        this.currentState = null;
        this.introIsRunning = false;
        this.displayedElapsedSeconds = 0;
        HudDriftCounterBinding hudDriftCounterBinding = this.binding;
        hudDriftCounterBinding.getRoot().animate().cancel();
        hudDriftCounterBinding.countdownLabel.animate().cancel();
        hudDriftCounterBinding.scoreContainer.animate().cancel();
        FrameLayout root = hudDriftCounterBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(8);
        hudDriftCounterBinding.getRoot().setAlpha(1.0f);
        LinearLayout countdownContainer = hudDriftCounterBinding.countdownContainer;
        Intrinsics.checkNotNullExpressionValue(countdownContainer, "countdownContainer");
        countdownContainer.setVisibility(0);
        LinearLayout scoreContainer = hudDriftCounterBinding.scoreContainer;
        Intrinsics.checkNotNullExpressionValue(scoreContainer, "scoreContainer");
        scoreContainer.setVisibility(8);
    }

    private final void startCountdown(int i) {
        cancelScheduledWork();
        this.introIsRunning = true;
        HudDriftCounterBinding hudDriftCounterBinding = this.binding;
        hudDriftCounterBinding.getRoot().animate().cancel();
        FrameLayout root = hudDriftCounterBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        hudDriftCounterBinding.getRoot().setAlpha(1.0f);
        LinearLayout scoreContainer = hudDriftCounterBinding.scoreContainer;
        Intrinsics.checkNotNullExpressionValue(scoreContainer, "scoreContainer");
        scoreContainer.setVisibility(8);
        LinearLayout countdownContainer = hudDriftCounterBinding.countdownContainer;
        Intrinsics.checkNotNullExpressionValue(countdownContainer, "countdownContainer");
        countdownContainer.setVisibility(0);
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = RangesKt.coerceIn(i, 1, 10);
        showCountdownNumber(intRef.element);
        HudDriftCounter$startCountdown$2 hudDriftCounter$startCountdown$2 = new HudDriftCounter$startCountdown$2(intRef, this);
        this.handler.postDelayed(hudDriftCounter$startCountdown$2, 1000L);
        this.countdownRunnable = hudDriftCounter$startCountdown$2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCountdownNumber(int i) {
        this.binding.countdownLabel.setText(String.valueOf(i));
        applyCountdownAccent(-1);
        animateCountdownLabel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showStartLabel() {
        HudDriftCounterBinding hudDriftCounterBinding = this.binding;
        hudDriftCounterBinding.countdownLabel.setText(R.string.hud_drift_counter_start);
        applyCountdownAccent(ContextCompat.getColor(hudDriftCounterBinding.getRoot().getContext(), R.color.hud_drift_counter_accent));
        animateCountdownLabel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishIntro() {
        this.startRunnable = null;
        this.introIsRunning = false;
        HudDriftCounterState hudDriftCounterState = this.currentState;
        if (hudDriftCounterState == null) {
            return;
        }
        showCounter(hudDriftCounterState, true);
    }

    private final void showCounter(HudDriftCounterState hudDriftCounterState, boolean z) {
        HudDriftCounterBinding hudDriftCounterBinding = this.binding;
        renderCounter(hudDriftCounterState);
        FrameLayout root = hudDriftCounterBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        LinearLayout countdownContainer = hudDriftCounterBinding.countdownContainer;
        Intrinsics.checkNotNullExpressionValue(countdownContainer, "countdownContainer");
        countdownContainer.setVisibility(8);
        LinearLayout scoreContainer = hudDriftCounterBinding.scoreContainer;
        Intrinsics.checkNotNullExpressionValue(scoreContainer, "scoreContainer");
        if (scoreContainer.getVisibility() != 0) {
            hudDriftCounterBinding.scoreContainer.animate().cancel();
            hudDriftCounterBinding.scoreContainer.setAlpha(0.0f);
            hudDriftCounterBinding.scoreContainer.setTranslationY(hudDriftCounterBinding.getRoot().getResources().getDimension(R.dimen._2sdp));
            LinearLayout scoreContainer2 = hudDriftCounterBinding.scoreContainer;
            Intrinsics.checkNotNullExpressionValue(scoreContainer2, "scoreContainer");
            scoreContainer2.setVisibility(0);
            hudDriftCounterBinding.scoreContainer.animate().alpha(1.0f).translationY(0.0f).setDuration(220L).start();
        }
        if (z) {
            startElapsedTimer(hudDriftCounterState.getElapsedSeconds());
        }
    }

    private final void renderCounter(HudDriftCounterState hudDriftCounterState) {
        HudDriftCounterBinding hudDriftCounterBinding = this.binding;
        hudDriftCounterBinding.scoreValue.setText(HudDriftCounterDataKt.formatHudDriftPoints(hudDriftCounterState.getPoints()));
        hudDriftCounterBinding.elapsedTime.setText(HudDriftCounterDataKt.formatHudDriftElapsedTime(hudDriftCounterState.getElapsedSeconds()));
        hudDriftCounterBinding.multiplier.setText(hudDriftCounterBinding.getRoot().getContext().getString(R.string.hud_drift_counter_multiplier, Integer.valueOf(hudDriftCounterState.getMultiplier())));
        boolean z = hudDriftCounterState.getCurrentSpeedKmh() >= hudDriftCounterState.getMinimumSpeedKmh();
        TextView speedStatus = hudDriftCounterBinding.speedStatus;
        Intrinsics.checkNotNullExpressionValue(speedStatus, "speedStatus");
        speedStatus.setVisibility(z ? 0 : 8);
        if (z) {
            hudDriftCounterBinding.speedStatus.setText(hudDriftCounterBinding.getRoot().getContext().getString(R.string.hud_drift_counter_speed_above, Integer.valueOf(hudDriftCounterState.getMinimumSpeedKmh())));
        }
    }

    private final void startElapsedTimer(int i) {
        Runnable runnable = this.elapsedRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        this.elapsedRunnable = null;
        int coerceAtLeast = RangesKt.coerceAtLeast(i, 0);
        this.displayedElapsedSeconds = coerceAtLeast;
        HudDriftCounterState hudDriftCounterState = this.currentState;
        this.currentState = hudDriftCounterState != null ? HudDriftCounterState.copy$default(hudDriftCounterState, 0, 0L, coerceAtLeast, 0, 0, 0, 59, null) : null;
        this.binding.elapsedTime.setText(HudDriftCounterDataKt.formatHudDriftElapsedTime(this.displayedElapsedSeconds));
        Runnable runnable2 = new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter.HudDriftCounter$startElapsedTimer$2
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                HudDriftCounterState hudDriftCounterState2;
                HudDriftCounterState hudDriftCounterState3;
                HudDriftCounterBinding hudDriftCounterBinding;
                int i3;
                Handler handler;
                int i4;
                HudDriftCounter hudDriftCounter = HudDriftCounter.this;
                i2 = hudDriftCounter.displayedElapsedSeconds;
                hudDriftCounter.displayedElapsedSeconds = i2 + 1;
                HudDriftCounter hudDriftCounter2 = HudDriftCounter.this;
                hudDriftCounterState2 = hudDriftCounter2.currentState;
                if (hudDriftCounterState2 != null) {
                    i4 = HudDriftCounter.this.displayedElapsedSeconds;
                    hudDriftCounterState3 = HudDriftCounterState.copy$default(hudDriftCounterState2, 0, 0L, i4, 0, 0, 0, 59, null);
                } else {
                    hudDriftCounterState3 = null;
                }
                hudDriftCounter2.currentState = hudDriftCounterState3;
                hudDriftCounterBinding = HudDriftCounter.this.binding;
                TextView textView = hudDriftCounterBinding.elapsedTime;
                i3 = HudDriftCounter.this.displayedElapsedSeconds;
                textView.setText(HudDriftCounterDataKt.formatHudDriftElapsedTime(i3));
                handler = HudDriftCounter.this.handler;
                handler.postDelayed(this, 1000L);
            }
        };
        this.handler.postDelayed(runnable2, 1000L);
        this.elapsedRunnable = runnable2;
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
        Runnable runnable3 = this.elapsedRunnable;
        if (runnable3 != null) {
            this.handler.removeCallbacks(runnable3);
        }
        this.countdownRunnable = null;
        this.startRunnable = null;
        this.elapsedRunnable = null;
    }

    /* compiled from: HudDriftCounter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/drift_counter/HudDriftCounter$Companion;", "", "<init>", "()V", "MIN_COUNTDOWN_SECONDS", "", "MAX_COUNTDOWN_SECONDS", "MILLIS_PER_SECOND", "", "START_LABEL_DURATION_MS", "COUNTDOWN_ANIMATION_MS", "SCORE_SHOW_ANIMATION_MS", "COUNTDOWN_INITIAL_ALPHA", "", "COUNTDOWN_INITIAL_SCALE", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
