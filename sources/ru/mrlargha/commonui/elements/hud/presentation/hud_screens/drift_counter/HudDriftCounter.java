package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.HudDriftCounterBinding;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter.HudDriftCounter;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: HudDriftCounter.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b&\u0018\u0000 j2\u00020\u0001:\u0001jB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001fJ\u000e\u0010'\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001fJ\u000e\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u0018J\u0006\u0010*\u001a\u00020%J\"\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020\u000e2\b\u0010-\u001a\u0004\u0018\u00010\u000e2\u0006\u0010.\u001a\u00020\u0018H\u0002J\"\u0010/\u001a\u00020%2\u0006\u0010,\u001a\u00020\u00102\b\u0010-\u001a\u0004\u0018\u00010\u00102\u0006\u00100\u001a\u00020\u0018H\u0002J&\u00101\u001a\u00020%2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u000b2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b06H\u0002J\u0010\u00107\u001a\u00020%2\u0006\u00108\u001a\u00020\u0018H\u0002J\u0010\u00109\u001a\u00020%2\u0006\u00108\u001a\u00020\u0018H\u0002J.\u0010:\u001a\u00020%2\u0006\u00102\u001a\u0002032\u0006\u00108\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u000b2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b06H\u0002J\b\u0010;\u001a\u00020%H\u0002J\u0018\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u0018H\u0002J\u0010\u0010?\u001a\u00020%2\u0006\u0010>\u001a\u00020\u0018H\u0002J\u0018\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020\u00122\u0006\u0010>\u001a\u00020\u0018H\u0002J\b\u0010B\u001a\u00020%H\u0002J*\u0010C\u001a\u00020%2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020\u00182\b\b\u0002\u0010H\u001a\u00020\tH\u0002J \u0010I\u001a\u00020%2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u001f2\u0006\u0010>\u001a\u00020\u0018H\u0002J\u0018\u0010J\u001a\u00020%2\u0006\u0010K\u001a\u00020\u00122\u0006\u0010L\u001a\u00020\u0012H\u0002J\u0018\u0010M\u001a\u00020%2\u0006\u0010N\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020\u0012H\u0002J\u0010\u0010O\u001a\u00020%2\u0006\u0010N\u001a\u00020\u000bH\u0002J\u0018\u0010P\u001a\u00020%2\u0006\u0010Q\u001a\u00020\u00122\u0006\u0010G\u001a\u00020\u0018H\u0002J\u0010\u0010R\u001a\u00020%2\u0006\u0010Q\u001a\u00020\u0012H\u0002J\u0010\u0010S\u001a\u00020%2\u0006\u0010,\u001a\u00020\u000eH\u0002J\b\u0010T\u001a\u00020\tH\u0002J\u0018\u0010U\u001a\u00020\t2\u0006\u0010D\u001a\u0002032\u0006\u0010V\u001a\u000203H\u0002J\b\u0010W\u001a\u00020%H\u0002J\b\u0010X\u001a\u00020%H\u0002J\b\u0010Y\u001a\u00020%H\u0002J\b\u0010Z\u001a\u00020%H\u0002J\b\u0010[\u001a\u00020%H\u0002J\u0010\u0010\\\u001a\u00020%2\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010]\u001a\u00020%2\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010^\u001a\u00020%2\u0006\u00102\u001a\u000203H\u0002J\u0016\u0010_\u001a\u00020%2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020%06H\u0002J\b\u0010a\u001a\u00020%H\u0002J\u0010\u0010b\u001a\u00020%2\u0006\u0010D\u001a\u000203H\u0002J\u0018\u0010c\u001a\u00020\u00182\u0006\u00102\u001a\u0002032\u0006\u0010d\u001a\u00020\u0018H\u0002J\b\u0010e\u001a\u00020\u0018H\u0002J\b\u0010f\u001a\u00020%H\u0002J\b\u0010g\u001a\u00020%H\u0002J\b\u0010h\u001a\u00020\u0018H\u0002J\b\u0010i\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/drift_counter/HudDriftCounter;", "", "binding", "Lru/mrlargha/commonui/databinding/HudDriftCounterBinding;", "<init>", "(Lru/mrlargha/commonui/databinding/HudDriftCounterBinding;)V", "handler", "Landroid/os/Handler;", "slideOffsetPx", "", "gapPx", "", "multiplierOffsetPx", "pointsState", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/drift_counter/HudDriftPointsData;", "moneyState", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/drift_counter/HudDriftMoneyData;", "lastCommittedPoints", "", "Ljava/lang/Long;", "pointsGeneration", "pointsFlightSeq", "moneyGeneration", "hidingPoints", "", "hidingMoney", "pointsFlightActive", "moneyDeadlineElapsedMs", "moneyTimerRunnable", "Ljava/lang/Runnable;", "lastTimerTargetText", "", "pointsDeltaRunnable", "pointsFlightAnim", "Landroid/animation/Animator;", "temporarilyHidden", "eventPoints", "", "payload", "eventMoney", "setTemporarilyHidden", "hidden", "clear", "applyPointsUpdate", "data", "previous", "appearing", "renderMoney", "animateValues", "showContainer", TtmlNode.RUBY_CONTAINER, "Landroid/view/View;", "generation", "currentGeneration", "Lkotlin/Function0;", "hidePoints", "animated", "hideMoney", "hideContainer", "updateRootVisibility", "syncMoneyTimer", "seconds", "animate", "restartMoneyTimerTicker", "renderTimerText", "remainingMs", "cancelMoneyTimer", "updateNumber", "view", "Landroid/widget/TextView;", "text", "pulse", "pulseScale", "updateMultiplier", "startPointsRise", "from", TypedValues.TransitionType.S_TO, "finishPointsRise", "seq", "continuePointsFlight", "commitPoints", "value", "setPointsText", "settlePointsTo", "deltaRiseY", "centerYIn", "ancestor", "resetDeltaVisuals", "stopPointsFlightVisuals", "cancelPointsFlight", "cancelPointsChildren", "cancelMoneyChildren", "resetNumber", "resetMultiplier", "snapHide", "reposition", "change", "applyGap", "cancelViewAnimation", "isShown", "hiding", "canShowVisuals", "suppressVisuals", "restoreVisuals", "hudAnimationsEnabled", "animationScale", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudDriftCounter {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final long DELTA_FADE_IN_MS = 150;
    @Deprecated
    public static final long DELTA_FADE_OUT_MS = 150;
    @Deprecated
    public static final long DELTA_RISE_MS = 400;
    @Deprecated
    public static final long FLIGHT_SAFETY_SLACK_MS = 200;
    @Deprecated
    public static final long MILLIS_PER_SECOND = 1000;
    @Deprecated
    public static final long MULTIPLIER_HALF_MS = 110;
    @Deprecated
    public static final long NUMBER_PULSE_HALF_MS = 110;
    @Deprecated
    public static final float NUMBER_PULSE_SCALE = 1.3f;
    @Deprecated
    public static final float POINTS_PULSE_SCALE = 1.3f;
    @Deprecated
    public static final long SHOW_HIDE_MS = 220;
    @Deprecated
    public static final int SPEED_LIMIT_KMH = 200;
    private final HudDriftCounterBinding binding;
    private final int gapPx;
    private final Handler handler;
    private boolean hidingMoney;
    private boolean hidingPoints;
    private Long lastCommittedPoints;
    private String lastTimerTargetText;
    private long moneyDeadlineElapsedMs;
    private int moneyGeneration;
    private HudDriftMoneyData moneyState;
    private Runnable moneyTimerRunnable;
    private final float multiplierOffsetPx;
    private Runnable pointsDeltaRunnable;
    private boolean pointsFlightActive;
    private Animator pointsFlightAnim;
    private int pointsFlightSeq;
    private int pointsGeneration;
    private HudDriftPointsData pointsState;
    private final float slideOffsetPx;
    private boolean temporarilyHidden;

    public HudDriftCounter(HudDriftCounterBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        this.handler = new Handler(Looper.getMainLooper());
        this.slideOffsetPx = binding.getRoot().getResources().getDimension(R.dimen._2sdp);
        this.gapPx = binding.getRoot().getResources().getDimensionPixelSize(R.dimen._10sdp);
        this.multiplierOffsetPx = binding.getRoot().getResources().getDimension(R.dimen._6sdp);
        float dimension = binding.getRoot().getResources().getDimension(R.dimen._1sdp);
        int argb = Color.argb(128, 0, 0, 0);
        binding.points.setShadowLayer(dimension, 0.0f, dimension, argb);
        binding.money.setShadowLayer(dimension, 0.0f, dimension, argb);
        binding.getRoot().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter.HudDriftCounter.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                HudDriftCounter.this.restoreVisuals();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                HudDriftCounter.this.suppressVisuals();
            }
        });
    }

    public final void eventPoints(String payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        HudDriftPointsData parseHudDriftPointsPayload = HudDriftCounterDataKt.parseHudDriftPointsPayload(payload, this.pointsState);
        if (parseHudDriftPointsPayload == null) {
            hidePoints(canShowVisuals());
            return;
        }
        HudDriftPointsData hudDriftPointsData = this.pointsState;
        boolean z = (hudDriftPointsData == null || this.hidingPoints) ? false : true;
        if (Intrinsics.areEqual(parseHudDriftPointsPayload, hudDriftPointsData) && z) {
            return;
        }
        this.pointsState = parseHudDriftPointsPayload;
        boolean z2 = !z;
        if (!z) {
            this.pointsGeneration++;
        }
        this.hidingPoints = false;
        if (!canShowVisuals()) {
            settlePointsTo(parseHudDriftPointsPayload);
            return;
        }
        applyPointsUpdate(parseHudDriftPointsPayload, hudDriftPointsData, z2);
        LinearLayout speedContainer = this.binding.speedContainer;
        Intrinsics.checkNotNullExpressionValue(speedContainer, "speedContainer");
        showContainer(speedContainer, this.pointsGeneration, new Function0() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter.HudDriftCounter$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i;
                i = HudDriftCounter.this.pointsGeneration;
                return Integer.valueOf(i);
            }
        });
    }

    public final void eventMoney(String payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        ParsedHudDriftMoney parseHudDriftMoneyPayload = HudDriftCounterDataKt.parseHudDriftMoneyPayload(payload, this.moneyState);
        if (parseHudDriftMoneyPayload == null) {
            hideMoney(canShowVisuals());
            return;
        }
        HudDriftMoneyData data = parseHudDriftMoneyPayload.getData();
        HudDriftMoneyData hudDriftMoneyData = this.moneyState;
        boolean z = (hudDriftMoneyData == null || this.hidingMoney) ? false : true;
        this.moneyState = data;
        if (parseHudDriftMoneyPayload.getTimerProvided() || !z) {
            syncMoneyTimer(data.getTimer(), z && canShowVisuals());
        }
        if (Intrinsics.areEqual(data, hudDriftMoneyData) && z) {
            return;
        }
        this.hidingMoney = false;
        if (!canShowVisuals()) {
            renderMoney(data, null, false);
            return;
        }
        int i = this.moneyGeneration + 1;
        this.moneyGeneration = i;
        renderMoney(data, hudDriftMoneyData, z);
        LinearLayout scoreContainer = this.binding.scoreContainer;
        Intrinsics.checkNotNullExpressionValue(scoreContainer, "scoreContainer");
        showContainer(scoreContainer, i, new Function0() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter.HudDriftCounter$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i2;
                i2 = HudDriftCounter.this.moneyGeneration;
                return Integer.valueOf(i2);
            }
        });
    }

    public final void setTemporarilyHidden(boolean z) {
        if (this.temporarilyHidden == z) {
            return;
        }
        this.temporarilyHidden = z;
        if (z) {
            suppressVisuals();
        } else {
            restoreVisuals();
        }
    }

    public final void clear() {
        this.pointsGeneration++;
        this.moneyGeneration++;
        this.pointsState = null;
        this.lastCommittedPoints = null;
        this.moneyState = null;
        this.hidingPoints = false;
        this.hidingMoney = false;
        this.moneyDeadlineElapsedMs = 0L;
        cancelMoneyTimer();
        cancelPointsChildren();
        cancelMoneyChildren();
        TransitionManager.endTransitions(this.binding.getRoot());
        LinearLayout speedContainer = this.binding.speedContainer;
        Intrinsics.checkNotNullExpressionValue(speedContainer, "speedContainer");
        snapHide(speedContainer);
        LinearLayout scoreContainer = this.binding.scoreContainer;
        Intrinsics.checkNotNullExpressionValue(scoreContainer, "scoreContainer");
        snapHide(scoreContainer);
        applyGap();
        LinearLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        cancelViewAnimation(root);
        LinearLayout root2 = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        root2.setVisibility(8);
        this.binding.getRoot().setAlpha(1.0f);
    }

    private final void applyPointsUpdate(HudDriftPointsData hudDriftPointsData, HudDriftPointsData hudDriftPointsData2, boolean z) {
        long displayedTotal = hudDriftPointsData.getDisplayedTotal();
        String string = this.binding.getRoot().getContext().getString(R.string.hud_drift_counter_multiplier, Integer.valueOf(hudDriftPointsData.getPointMultiplier()));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        boolean z2 = (hudDriftPointsData2 == null || hudDriftPointsData2.getPointMultiplier() == hudDriftPointsData.getPointMultiplier()) ? false : true;
        if (z || hudDriftPointsData2 == null) {
            settlePointsTo(hudDriftPointsData);
            return;
        }
        TextView pointMultiplier = this.binding.pointMultiplier;
        Intrinsics.checkNotNullExpressionValue(pointMultiplier, "pointMultiplier");
        updateMultiplier(pointMultiplier, string, z2);
        Long l = this.lastCommittedPoints;
        long longValue = l != null ? l.longValue() : hudDriftPointsData2.getDisplayedTotal();
        if (displayedTotal < hudDriftPointsData2.getDisplayedTotal()) {
            cancelPointsFlight();
            this.lastCommittedPoints = Long.valueOf(displayedTotal);
            setPointsText(displayedTotal);
        } else if (displayedTotal == longValue) {
        } else {
            if (!hudAnimationsEnabled()) {
                cancelPointsFlight();
                this.lastCommittedPoints = Long.valueOf(displayedTotal);
                setPointsText(displayedTotal);
            } else if (this.pointsFlightActive) {
            } else {
                startPointsRise(longValue, displayedTotal);
            }
        }
    }

    private final void renderMoney(HudDriftMoneyData hudDriftMoneyData, HudDriftMoneyData hudDriftMoneyData2, boolean z) {
        HudDriftCounterBinding hudDriftCounterBinding = this.binding;
        String formatHudDriftPoints = HudDriftCounterDataKt.formatHudDriftPoints(hudDriftMoneyData.getMoney());
        String string = hudDriftCounterBinding.getRoot().getContext().getString(R.string.hud_drift_counter_multiplier, Integer.valueOf(hudDriftMoneyData.getMoneyMultiplier()));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        boolean z2 = true;
        if (hudDriftMoneyData2 == null || hudDriftMoneyData2.getMoney() != hudDriftMoneyData.getMoney()) {
            TextView money = hudDriftCounterBinding.money;
            Intrinsics.checkNotNullExpressionValue(money, "money");
            updateNumber(money, formatHudDriftPoints, z && hudDriftMoneyData2 != null, 1.3f);
        }
        TextView moneyMultiplier = hudDriftCounterBinding.moneyMultiplier;
        Intrinsics.checkNotNullExpressionValue(moneyMultiplier, "moneyMultiplier");
        if (!z || hudDriftMoneyData2 == null || hudDriftMoneyData2.getMoneyMultiplier() == hudDriftMoneyData.getMoneyMultiplier()) {
            z2 = false;
        }
        updateMultiplier(moneyMultiplier, string, z2);
        TextView speedStatus = hudDriftCounterBinding.speedStatus;
        Intrinsics.checkNotNullExpressionValue(speedStatus, "speedStatus");
        speedStatus.setVisibility(hudDriftMoneyData.getSpeedLimit() ? 0 : 8);
        if (hudDriftMoneyData.getSpeedLimit()) {
            hudDriftCounterBinding.speedStatus.setText(hudDriftCounterBinding.getRoot().getContext().getString(R.string.hud_drift_counter_speed_above, 200));
        }
    }

    private final void showContainer(final View view, int i, Function0<Integer> function0) {
        if (i == function0.invoke().intValue() && canShowVisuals()) {
            LinearLayout root = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            root.setVisibility(0);
            boolean z = view.getVisibility() != 0;
            cancelViewAnimation(view);
            if (z) {
                reposition(new Function0() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter.HudDriftCounter$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HudDriftCounter.showContainer$lambda$0(view, this);
                    }
                });
                if (hudAnimationsEnabled()) {
                    view.animate().alpha(1.0f).translationY(0.0f).setDuration(220L).start();
                    return;
                }
                return;
            }
            applyGap();
            if (!hudAnimationsEnabled()) {
                view.setAlpha(1.0f);
                view.setTranslationY(0.0f);
                return;
            }
            view.animate().alpha(1.0f).translationY(0.0f).setDuration(220L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showContainer$lambda$0(View view, HudDriftCounter hudDriftCounter) {
        view.setAlpha(hudDriftCounter.hudAnimationsEnabled() ? 0.0f : 1.0f);
        view.setTranslationY(hudDriftCounter.hudAnimationsEnabled() ? hudDriftCounter.slideOffsetPx : 0.0f);
        view.setVisibility(0);
        return Unit.INSTANCE;
    }

    private final void hidePoints(boolean z) {
        this.pointsState = null;
        this.lastCommittedPoints = null;
        int i = this.pointsGeneration + 1;
        this.pointsGeneration = i;
        this.hidingPoints = true;
        cancelPointsChildren();
        LinearLayout speedContainer = this.binding.speedContainer;
        Intrinsics.checkNotNullExpressionValue(speedContainer, "speedContainer");
        hideContainer(speedContainer, z, i, new Function0() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter.HudDriftCounter$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i2;
                i2 = HudDriftCounter.this.pointsGeneration;
                return Integer.valueOf(i2);
            }
        });
    }

    private final void hideMoney(boolean z) {
        this.moneyState = null;
        this.moneyDeadlineElapsedMs = 0L;
        int i = this.moneyGeneration + 1;
        this.moneyGeneration = i;
        this.hidingMoney = true;
        cancelMoneyChildren();
        cancelMoneyTimer();
        TextView speedStatus = this.binding.speedStatus;
        Intrinsics.checkNotNullExpressionValue(speedStatus, "speedStatus");
        speedStatus.setVisibility(8);
        LinearLayout scoreContainer = this.binding.scoreContainer;
        Intrinsics.checkNotNullExpressionValue(scoreContainer, "scoreContainer");
        hideContainer(scoreContainer, z, i, new Function0() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter.HudDriftCounter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i2;
                i2 = HudDriftCounter.this.moneyGeneration;
                return Integer.valueOf(i2);
            }
        });
    }

    private final void hideContainer(final View view, boolean z, final int i, final Function0<Integer> function0) {
        final Function0 function02 = new Function0() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter.HudDriftCounter$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HudDriftCounter.hideContainer$lambda$0(i, function0, view, this);
            }
        };
        cancelViewAnimation(view);
        if (!z || !hudAnimationsEnabled() || view.getVisibility() != 0) {
            function02.invoke();
        } else {
            view.animate().alpha(0.0f).translationY(this.slideOffsetPx).setDuration(220L).setListener(new AnimatorListenerAdapter() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter.HudDriftCounter$hideContainer$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    view.animate().setListener(null);
                    function02.invoke();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit hideContainer$lambda$0(int i, Function0 function0, final View view, final HudDriftCounter hudDriftCounter) {
        if (i == ((Number) function0.invoke()).intValue()) {
            if (view == hudDriftCounter.binding.speedContainer) {
                hudDriftCounter.hidingPoints = false;
            } else {
                hudDriftCounter.hidingMoney = false;
            }
            hudDriftCounter.reposition(new Function0() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter.HudDriftCounter$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit hideContainer$lambda$0$0;
                    hideContainer$lambda$0$0 = HudDriftCounter.hideContainer$lambda$0$0(HudDriftCounter.this, view);
                    return hideContainer$lambda$0$0;
                }
            });
            hudDriftCounter.updateRootVisibility();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit hideContainer$lambda$0$0(HudDriftCounter hudDriftCounter, View view) {
        hudDriftCounter.snapHide(view);
        return Unit.INSTANCE;
    }

    private final void updateRootVisibility() {
        if (this.binding.speedContainer.getVisibility() != 8 || this.binding.scoreContainer.getVisibility() != 8) {
            if (canShowVisuals()) {
                LinearLayout root = this.binding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                root.setVisibility(0);
                return;
            }
            return;
        }
        LinearLayout root2 = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        cancelViewAnimation(root2);
        LinearLayout root3 = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "getRoot(...)");
        root3.setVisibility(8);
        this.binding.getRoot().setAlpha(1.0f);
    }

    private final void syncMoneyTimer(int i, boolean z) {
        this.moneyDeadlineElapsedMs = SystemClock.elapsedRealtime() + (RangesKt.coerceAtLeast(i, 0) * 1000);
        restartMoneyTimerTicker(z);
    }

    private final void restartMoneyTimerTicker(boolean z) {
        cancelMoneyTimer();
        if (canShowVisuals()) {
            long elapsedRealtime = this.moneyDeadlineElapsedMs - SystemClock.elapsedRealtime();
            renderTimerText(elapsedRealtime, z);
            if (elapsedRealtime <= 0) {
                return;
            }
            Runnable runnable = new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter.HudDriftCounter$restartMoneyTimerTicker$runnable$1
                @Override // java.lang.Runnable
                public void run() {
                    boolean canShowVisuals;
                    long j;
                    Handler handler;
                    HudDriftCounter.Companion companion;
                    canShowVisuals = HudDriftCounter.this.canShowVisuals();
                    HudDriftCounter hudDriftCounter = HudDriftCounter.this;
                    if (!canShowVisuals) {
                        hudDriftCounter.moneyTimerRunnable = null;
                        return;
                    }
                    j = hudDriftCounter.moneyDeadlineElapsedMs;
                    long elapsedRealtime2 = j - SystemClock.elapsedRealtime();
                    HudDriftCounter.this.renderTimerText(elapsedRealtime2, true);
                    int i = (elapsedRealtime2 > 0L ? 1 : (elapsedRealtime2 == 0L ? 0 : -1));
                    HudDriftCounter hudDriftCounter2 = HudDriftCounter.this;
                    if (i > 0) {
                        handler = hudDriftCounter2.handler;
                        companion = HudDriftCounter.Companion;
                        handler.postDelayed(this, companion.delayToNextSecond(elapsedRealtime2));
                        return;
                    }
                    hudDriftCounter2.moneyTimerRunnable = null;
                }
            };
            this.moneyTimerRunnable = runnable;
            this.handler.postDelayed(runnable, Companion.delayToNextSecond(elapsedRealtime));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderTimerText(long j, boolean z) {
        String formatHudDriftElapsedTime = HudDriftCounterDataKt.formatHudDriftElapsedTime(j <= 0 ? 0 : (int) ((j + 999) / 1000));
        if (z && Intrinsics.areEqual(this.lastTimerTargetText, formatHudDriftElapsedTime)) {
            return;
        }
        this.lastTimerTargetText = formatHudDriftElapsedTime;
        TextView driftMoneyTimer = this.binding.driftMoneyTimer;
        Intrinsics.checkNotNullExpressionValue(driftMoneyTimer, "driftMoneyTimer");
        updateMultiplier(driftMoneyTimer, formatHudDriftElapsedTime, z);
    }

    private final void cancelMoneyTimer() {
        Runnable runnable = this.moneyTimerRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        this.moneyTimerRunnable = null;
    }

    static /* synthetic */ void updateNumber$default(HudDriftCounter hudDriftCounter, TextView textView, String str, boolean z, float f, int i, Object obj) {
        if ((i & 8) != 0) {
            f = 1.3f;
        }
        hudDriftCounter.updateNumber(textView, str, z, f);
    }

    private final void updateNumber(final TextView textView, String str, boolean z, float f) {
        textView.setText(str);
        cancelViewAnimation(textView);
        textView.setScaleX(1.0f);
        textView.setScaleY(1.0f);
        if (z && hudAnimationsEnabled()) {
            if (textView.getWidth() > 0) {
                textView.setPivotX(textView.getWidth() / 2.0f);
                textView.setPivotY(textView.getHeight() / 2.0f);
            }
            textView.animate().scaleX(f).scaleY(f).setDuration(110L).withEndAction(new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter.HudDriftCounter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    textView.animate().scaleX(1.0f).scaleY(1.0f).setDuration(110L).start();
                }
            }).start();
        }
    }

    private final void updateMultiplier(final TextView textView, final String str, boolean z) {
        cancelViewAnimation(textView);
        if (Intrinsics.areEqual(textView.getText().toString(), str) && textView.getAlpha() == 1.0f && textView.getTranslationY() == 0.0f) {
            textView.setText(str);
            textView.setAlpha(1.0f);
            textView.setTranslationY(0.0f);
        } else if (!z || !hudAnimationsEnabled()) {
            textView.setText(str);
            textView.setAlpha(1.0f);
            textView.setTranslationY(0.0f);
        } else {
            textView.animate().alpha(0.0f).translationY(-this.multiplierOffsetPx).setDuration(110L).withEndAction(new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter.HudDriftCounter$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    HudDriftCounter.updateMultiplier$lambda$0(textView, str, this);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void updateMultiplier$lambda$0(TextView textView, String str, HudDriftCounter hudDriftCounter) {
        textView.setText(str);
        textView.setTranslationY(hudDriftCounter.multiplierOffsetPx);
        textView.animate().alpha(1.0f).translationY(0.0f).setDuration(110L).start();
    }

    private final void startPointsRise(long j, final long j2) {
        final int i = this.pointsFlightSeq;
        if (j2 <= j) {
            commitPoints(j2, false);
            continuePointsFlight(i);
        } else if (!hudAnimationsEnabled()) {
            commitPoints(j2, false);
        } else {
            stopPointsFlightVisuals();
            this.pointsFlightActive = true;
            setPointsText(j);
            final TextView speedSpeedStatus = this.binding.speedSpeedStatus;
            Intrinsics.checkNotNullExpressionValue(speedSpeedStatus, "speedSpeedStatus");
            speedSpeedStatus.setText(speedSpeedStatus.getContext().getString(R.string.hud_drift_counter_points_delta, HudDriftCounterDataKt.formatHudDriftPoints(j2 - j)));
            speedSpeedStatus.setAlpha(0.0f);
            speedSpeedStatus.setTranslationY(0.0f);
            speedSpeedStatus.setVisibility(0);
            Runnable runnable = new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter.HudDriftCounter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    HudDriftCounter.startPointsRise$lambda$0(i, this, j2);
                }
            };
            this.pointsDeltaRunnable = runnable;
            this.handler.postDelayed(runnable, 750L);
            speedSpeedStatus.post(new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter.HudDriftCounter$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    HudDriftCounter.startPointsRise$lambda$1(i, this, j2, speedSpeedStatus);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void startPointsRise$lambda$0(int i, HudDriftCounter hudDriftCounter, long j) {
        if (i != hudDriftCounter.pointsFlightSeq) {
            return;
        }
        HudDriftPointsData hudDriftPointsData = hudDriftCounter.pointsState;
        if (hudDriftPointsData != null) {
            j = hudDriftPointsData.getDisplayedTotal();
        }
        hudDriftCounter.cancelPointsFlight();
        hudDriftCounter.lastCommittedPoints = Long.valueOf(j);
        hudDriftCounter.setPointsText(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void startPointsRise$lambda$1(final int i, final HudDriftCounter hudDriftCounter, final long j, final TextView textView) {
        if (i != hudDriftCounter.pointsFlightSeq) {
            return;
        }
        if (!hudDriftCounter.hudAnimationsEnabled()) {
            hudDriftCounter.cancelPointsFlight();
            HudDriftPointsData hudDriftPointsData = hudDriftCounter.pointsState;
            Long valueOf = hudDriftPointsData != null ? Long.valueOf(hudDriftPointsData.getDisplayedTotal()) : Long.valueOf(j);
            hudDriftCounter.lastCommittedPoints = valueOf;
            if (valueOf != null) {
                j = valueOf.longValue();
            }
            hudDriftCounter.setPointsText(j);
            return;
        }
        final float deltaRiseY = hudDriftCounter.deltaRiseY();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(550L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter.HudDriftCounter$$ExternalSyntheticLambda10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                HudDriftCounter.startPointsRise$lambda$1$0$0(i, hudDriftCounter, r3, textView, deltaRiseY, r6, valueAnimator);
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter.HudDriftCounter$startPointsRise$1$animator$1$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                int i2;
                Intrinsics.checkNotNullParameter(animation, "animation");
                int i3 = i;
                i2 = hudDriftCounter.pointsFlightSeq;
                if (i3 != i2) {
                    return;
                }
                hudDriftCounter.finishPointsRise(i, j);
            }
        });
        hudDriftCounter.pointsFlightAnim = ofFloat;
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startPointsRise$lambda$1$0$0(int i, HudDriftCounter hudDriftCounter, float f, TextView textView, float f2, float f3, ValueAnimator anim) {
        Intrinsics.checkNotNullParameter(anim, "anim");
        if (i != hudDriftCounter.pointsFlightSeq) {
            return;
        }
        float animatedFraction = anim.getAnimatedFraction();
        if (animatedFraction <= f) {
            textView.setAlpha(f != 0.0f ? animatedFraction / f : 1.0f);
            textView.setTranslationY(0.0f);
            return;
        }
        textView.setTranslationY(f2 * RangesKt.coerceIn((animatedFraction - f) / (1.0f - f), 0.0f, 1.0f));
        if (animatedFraction > f3 && f3 < 1.0f) {
            r0 = RangesKt.coerceIn(1.0f - ((animatedFraction - f3) / (1.0f - f3)), 0.0f, 1.0f);
        }
        textView.setAlpha(r0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishPointsRise(int i, long j) {
        if (i != this.pointsFlightSeq) {
            return;
        }
        Runnable runnable = this.pointsDeltaRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        this.pointsDeltaRunnable = null;
        this.pointsFlightAnim = null;
        this.pointsFlightActive = false;
        resetDeltaVisuals();
        commitPoints(j, hudAnimationsEnabled());
        continuePointsFlight(i);
    }

    private final void continuePointsFlight(int i) {
        HudDriftPointsData hudDriftPointsData;
        Long l;
        if (i != this.pointsFlightSeq || (hudDriftPointsData = this.pointsState) == null || (l = this.lastCommittedPoints) == null) {
            return;
        }
        long longValue = l.longValue();
        if (canShowVisuals()) {
            LinearLayout speedContainer = this.binding.speedContainer;
            Intrinsics.checkNotNullExpressionValue(speedContainer, "speedContainer");
            if (isShown(speedContainer, this.hidingPoints) && hudDriftPointsData.getDisplayedTotal() > longValue) {
                startPointsRise(longValue, hudDriftPointsData.getDisplayedTotal());
            }
        }
    }

    private final void commitPoints(long j, boolean z) {
        this.lastCommittedPoints = Long.valueOf(j);
        TextView points = this.binding.points;
        Intrinsics.checkNotNullExpressionValue(points, "points");
        updateNumber(points, HudDriftCounterDataKt.formatHudDriftPoints(j), z, 1.3f);
    }

    private final void setPointsText(long j) {
        TextView points = this.binding.points;
        Intrinsics.checkNotNullExpressionValue(points, "points");
        resetNumber(points);
        this.binding.points.setText(HudDriftCounterDataKt.formatHudDriftPoints(j));
    }

    private final void settlePointsTo(HudDriftPointsData hudDriftPointsData) {
        cancelPointsChildren();
        long displayedTotal = hudDriftPointsData.getDisplayedTotal();
        this.lastCommittedPoints = Long.valueOf(displayedTotal);
        this.binding.points.setText(HudDriftCounterDataKt.formatHudDriftPoints(displayedTotal));
        this.binding.pointMultiplier.setText(this.binding.getRoot().getContext().getString(R.string.hud_drift_counter_multiplier, Integer.valueOf(hudDriftPointsData.getPointMultiplier())));
        TextView pointMultiplier = this.binding.pointMultiplier;
        Intrinsics.checkNotNullExpressionValue(pointMultiplier, "pointMultiplier");
        resetMultiplier(pointMultiplier);
    }

    private final float deltaRiseY() {
        LinearLayout speedContainer = this.binding.speedContainer;
        Intrinsics.checkNotNullExpressionValue(speedContainer, "speedContainer");
        TextView points = this.binding.points;
        Intrinsics.checkNotNullExpressionValue(points, "points");
        LinearLayout linearLayout = speedContainer;
        float centerYIn = centerYIn(points, linearLayout);
        TextView speedSpeedStatus = this.binding.speedSpeedStatus;
        Intrinsics.checkNotNullExpressionValue(speedSpeedStatus, "speedSpeedStatus");
        return centerYIn - centerYIn(speedSpeedStatus, linearLayout);
    }

    private final float centerYIn(View view, View view2) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationInWindow(iArr);
        view2.getLocationInWindow(iArr2);
        return (iArr[1] - iArr2[1]) + (view.getHeight() / 2.0f);
    }

    private final void resetDeltaVisuals() {
        TextView speedSpeedStatus = this.binding.speedSpeedStatus;
        Intrinsics.checkNotNullExpressionValue(speedSpeedStatus, "speedSpeedStatus");
        TextView textView = speedSpeedStatus;
        cancelViewAnimation(textView);
        textView.setVisibility(8);
        speedSpeedStatus.setAlpha(1.0f);
        speedSpeedStatus.setTranslationY(0.0f);
    }

    private final void stopPointsFlightVisuals() {
        Runnable runnable = this.pointsDeltaRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
            this.binding.speedSpeedStatus.removeCallbacks(runnable);
        }
        this.pointsDeltaRunnable = null;
        Animator animator = this.pointsFlightAnim;
        if (animator != null) {
            animator.removeAllListeners();
        }
        Animator animator2 = this.pointsFlightAnim;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.pointsFlightAnim = null;
        resetDeltaVisuals();
    }

    private final void cancelPointsFlight() {
        this.pointsFlightSeq++;
        this.pointsFlightActive = false;
        stopPointsFlightVisuals();
    }

    private final void cancelPointsChildren() {
        TextView points = this.binding.points;
        Intrinsics.checkNotNullExpressionValue(points, "points");
        resetNumber(points);
        TextView pointMultiplier = this.binding.pointMultiplier;
        Intrinsics.checkNotNullExpressionValue(pointMultiplier, "pointMultiplier");
        resetMultiplier(pointMultiplier);
        cancelPointsFlight();
    }

    private final void cancelMoneyChildren() {
        TextView money = this.binding.money;
        Intrinsics.checkNotNullExpressionValue(money, "money");
        resetNumber(money);
        TextView moneyMultiplier = this.binding.moneyMultiplier;
        Intrinsics.checkNotNullExpressionValue(moneyMultiplier, "moneyMultiplier");
        resetMultiplier(moneyMultiplier);
        TextView driftMoneyTimer = this.binding.driftMoneyTimer;
        Intrinsics.checkNotNullExpressionValue(driftMoneyTimer, "driftMoneyTimer");
        resetMultiplier(driftMoneyTimer);
        this.binding.driftMoneyTimer.setScaleX(1.0f);
        this.binding.driftMoneyTimer.setScaleY(1.0f);
        this.lastTimerTargetText = null;
    }

    private final void resetNumber(TextView textView) {
        cancelViewAnimation(textView);
        textView.setScaleX(1.0f);
        textView.setScaleY(1.0f);
    }

    private final void resetMultiplier(TextView textView) {
        cancelViewAnimation(textView);
        textView.setAlpha(1.0f);
        textView.setTranslationY(0.0f);
    }

    private final void snapHide(View view) {
        cancelViewAnimation(view);
        view.setVisibility(8);
        view.setAlpha(1.0f);
        view.setTranslationY(0.0f);
    }

    private final void reposition(Function0<Unit> function0) {
        if (hudAnimationsEnabled()) {
            ChangeBounds changeBounds = new ChangeBounds();
            changeBounds.setDuration(220L);
            TransitionManager.beginDelayedTransition(this.binding.getRoot(), changeBounds);
        }
        function0.invoke();
        applyGap();
    }

    private final void applyGap() {
        int i = (this.binding.speedContainer.getVisibility() == 8 || this.binding.scoreContainer.getVisibility() == 8) ? 0 : this.gapPx;
        ViewGroup.LayoutParams layoutParams = this.binding.speedContainer.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams.getMarginEnd() == i) {
            return;
        }
        marginLayoutParams.setMarginEnd(i);
        this.binding.speedContainer.setLayoutParams(marginLayoutParams);
    }

    private final void cancelViewAnimation(View view) {
        view.animate().setListener(null);
        view.animate().cancel();
    }

    private final boolean isShown(View view, boolean z) {
        return view.getVisibility() == 0 && !z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean canShowVisuals() {
        return !this.temporarilyHidden && this.binding.getRoot().isAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void suppressVisuals() {
        this.pointsGeneration++;
        this.moneyGeneration++;
        this.hidingPoints = false;
        this.hidingMoney = false;
        HudDriftPointsData hudDriftPointsData = this.pointsState;
        if (hudDriftPointsData != null) {
            settlePointsTo(hudDriftPointsData);
        } else {
            cancelPointsChildren();
            this.lastCommittedPoints = null;
        }
        HudDriftMoneyData hudDriftMoneyData = this.moneyState;
        if (hudDriftMoneyData != null) {
            cancelMoneyChildren();
            renderMoney(hudDriftMoneyData, null, false);
        } else {
            cancelMoneyChildren();
        }
        cancelMoneyTimer();
        TransitionManager.endTransitions(this.binding.getRoot());
        LinearLayout speedContainer = this.binding.speedContainer;
        Intrinsics.checkNotNullExpressionValue(speedContainer, "speedContainer");
        snapHide(speedContainer);
        LinearLayout scoreContainer = this.binding.scoreContainer;
        Intrinsics.checkNotNullExpressionValue(scoreContainer, "scoreContainer");
        snapHide(scoreContainer);
        applyGap();
        LinearLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        cancelViewAnimation(root);
        LinearLayout root2 = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        root2.setVisibility(8);
        this.binding.getRoot().setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void restoreVisuals() {
        if (canShowVisuals()) {
            HudDriftPointsData hudDriftPointsData = this.pointsState;
            HudDriftMoneyData hudDriftMoneyData = this.moneyState;
            if (hudDriftPointsData == null && hudDriftMoneyData == null) {
                updateRootVisibility();
                return;
            }
            if (hudDriftPointsData != null) {
                int i = this.pointsGeneration + 1;
                this.pointsGeneration = i;
                this.hidingPoints = false;
                settlePointsTo(hudDriftPointsData);
                LinearLayout speedContainer = this.binding.speedContainer;
                Intrinsics.checkNotNullExpressionValue(speedContainer, "speedContainer");
                showContainer(speedContainer, i, new Function0() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter.HudDriftCounter$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        int i2;
                        i2 = HudDriftCounter.this.pointsGeneration;
                        return Integer.valueOf(i2);
                    }
                });
            }
            if (hudDriftMoneyData != null) {
                int i2 = this.moneyGeneration + 1;
                this.moneyGeneration = i2;
                this.hidingMoney = false;
                renderMoney(hudDriftMoneyData, null, false);
                restartMoneyTimerTicker(false);
                LinearLayout scoreContainer = this.binding.scoreContainer;
                Intrinsics.checkNotNullExpressionValue(scoreContainer, "scoreContainer");
                showContainer(scoreContainer, i2, new Function0() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.drift_counter.HudDriftCounter$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        int i3;
                        i3 = HudDriftCounter.this.moneyGeneration;
                        return Integer.valueOf(i3);
                    }
                });
            }
        }
    }

    private final boolean hudAnimationsEnabled() {
        if (animationScale() == 0.0f) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return ValueAnimator.areAnimatorsEnabled();
        }
        return true;
    }

    private final float animationScale() {
        for (Context context = this.binding.getRoot().getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return UtilsKt.getAnimationScale((Activity) context);
            }
        }
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HudDriftCounter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/drift_counter/HudDriftCounter$Companion;", "", "<init>", "()V", "SHOW_HIDE_MS", "", "NUMBER_PULSE_HALF_MS", "NUMBER_PULSE_SCALE", "", "POINTS_PULSE_SCALE", "MULTIPLIER_HALF_MS", "DELTA_FADE_IN_MS", "DELTA_RISE_MS", "DELTA_FADE_OUT_MS", "FLIGHT_SAFETY_SLACK_MS", "MILLIS_PER_SECOND", "SPEED_LIMIT_KMH", "", "delayToNextSecond", "remainingMs", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long delayToNextSecond(long j) {
            long j2 = j % 1000;
            if (j2 == 0) {
                return 1000L;
            }
            return j2;
        }
    }
}
