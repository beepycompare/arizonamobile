package ru.mrlargha.commonui.elements.hud.presentation.hud_screens;

import android.app.Activity;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import com.adjust.sdk.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.databinding.HudArizonaTrainJobBinding;
import ru.mrlargha.commonui.databinding.HudArizonaTrainSettingsBinding;
import ru.mrlargha.commonui.elements.hud.presentation.Hud;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.ui.money.MoneyElementKt;
/* compiled from: ArizonaTrainHud.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\u00020\u0001:\u0001%B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007J\u000e\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0007J\u0006\u0010#\u001a\u00020\u0019J\b\u0010$\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/ArizonaTrainHud;", "", "targetActivity", "Landroid/app/Activity;", "backendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "backendId", "", "slot", "Landroid/view/ViewGroup;", "hideAll", "Landroidx/constraintlayout/widget/ConstraintLayout;", "<init>", "(Landroid/app/Activity;Lru/mrlargha/commonui/core/IBackendNotifier;ILandroid/view/ViewGroup;Landroidx/constraintlayout/widget/ConstraintLayout;)V", "driverBinding", "Lru/mrlargha/commonui/databinding/HudArizonaTrainJobBinding;", "settingsBinding", "Lru/mrlargha/commonui/databinding/HudArizonaTrainSettingsBinding;", "handler", "Landroid/os/Handler;", "trainTimer", "Landroid/os/CountDownTimer;", "resetHornState", "Ljava/lang/Runnable;", "setVisibility", "", "visible", "setInfo", "info", "Lru/mrlargha/commonui/elements/hud/presentation/Hud$Companion$TrainInfo;", "startTimer", "seconds", "setSettingsVisibility", "setDoorState", RemoteConfigConstants.ResponseFieldKey.STATE, "clear", "cancelTimer", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaTrainHud {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final long HORN_STATE_RESET_MS = 1000;
    private final HudArizonaTrainJobBinding driverBinding;
    private final Handler handler;
    private final Runnable resetHornState;
    private final HudArizonaTrainSettingsBinding settingsBinding;
    private final Activity targetActivity;
    private CountDownTimer trainTimer;

    public ArizonaTrainHud(Activity targetActivity, final IBackendNotifier backendNotifier, final int i, ViewGroup slot, ConstraintLayout hideAll) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(backendNotifier, "backendNotifier");
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(hideAll, "hideAll");
        this.targetActivity = targetActivity;
        this.handler = new Handler(Looper.getMainLooper());
        this.resetHornState = new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.ArizonaTrainHud$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ArizonaTrainHud.this.settingsBinding.ivHornState.setImageResource(R.drawable.ic_switch_none);
            }
        };
        LayoutInflater layoutInflater = targetActivity.getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "getLayoutInflater(...)");
        layoutInflater.inflate(R.layout.hud_arizona_train_job, slot, true);
        HudArizonaTrainJobBinding bind = HudArizonaTrainJobBinding.bind(slot.findViewById(R.id.train_driver_container));
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.driverBinding = bind;
        View inflate = layoutInflater.inflate(R.layout.hud_arizona_train_settings, (ViewGroup) hideAll, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        hideAll.addView(inflate, hideAll.indexOfChild(hideAll.findViewById(R.id.left_menu)) + 1, (ConstraintLayout.LayoutParams) layoutParams);
        HudArizonaTrainSettingsBinding bind2 = HudArizonaTrainSettingsBinding.bind(inflate);
        Intrinsics.checkNotNullExpressionValue(bind2, "bind(...)");
        this.settingsBinding = bind2;
        bind2.ivDoors.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.ArizonaTrainHud$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IBackendNotifier.this.clickedWrapper(i, -1, 1);
            }
        });
        bind2.ivHorn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.ArizonaTrainHud$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArizonaTrainHud._init_$lambda$1(IBackendNotifier.this, i, this, view);
            }
        });
        bind.getRoot().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.ArizonaTrainHud.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                ArizonaTrainHud.this.clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$1(IBackendNotifier iBackendNotifier, int i, ArizonaTrainHud arizonaTrainHud, View view) {
        iBackendNotifier.clickedWrapper(i, -1, 2);
        arizonaTrainHud.settingsBinding.ivHornState.setImageResource(R.drawable.ic_switch_off);
        arizonaTrainHud.handler.removeCallbacks(arizonaTrainHud.resetHornState);
        arizonaTrainHud.handler.postDelayed(arizonaTrainHud.resetHornState, 1000L);
    }

    public final void setVisibility(int i) {
        HudArizonaTrainJobBinding hudArizonaTrainJobBinding = this.driverBinding;
        if (i == 0) {
            hudArizonaTrainJobBinding.getRoot().setVisibility(8);
            cancelTimer();
            return;
        }
        hudArizonaTrainJobBinding.getRoot().setVisibility(0);
        startTimer(0);
    }

    public final void setInfo(Hud.Companion.TrainInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        HudArizonaTrainJobBinding hudArizonaTrainJobBinding = this.driverBinding;
        hudArizonaTrainJobBinding.income.setText(MoneyElementKt.toMoneyFormattedSpannable$default(info.getSalary(), false, null, null, null, 15, null));
        TextView textView = hudArizonaTrainJobBinding.warningsCount;
        int warnings = info.getWarnings();
        textView.setText(warnings + " / " + info.getWarningsMax());
        if (info.getMaxTime() == 0) {
            hudArizonaTrainJobBinding.trainMaxTime.setVisibility(8);
        } else {
            hudArizonaTrainJobBinding.trainMaxTime.setVisibility(0);
            hudArizonaTrainJobBinding.trainMaxTime.setText("/ " + UtilsKt.formatTime(info.getMaxTime() * 1000));
        }
        String speedLimitType = info.getSpeedLimitType();
        int hashCode = speedLimitType.hashCode();
        if (hashCode != -1039745817) {
            if (hashCode != 1124446108) {
                if (hashCode == 1952151455 && speedLimitType.equals("critical")) {
                    hudArizonaTrainJobBinding.speedLimit.setTextColor(Color.parseColor("#FFFFFF"));
                    hudArizonaTrainJobBinding.warningIc.setImageResource(R.drawable.hud_train_critical_speed_limit);
                    hudArizonaTrainJobBinding.speedLimit.setText(String.valueOf(info.getSpeedLimit()));
                }
            } else if (speedLimitType.equals("warning")) {
                hudArizonaTrainJobBinding.speedLimit.setTextColor(Color.parseColor("#000000"));
                hudArizonaTrainJobBinding.warningIc.setImageResource(R.drawable.hud_train_warning_speed_limit);
                hudArizonaTrainJobBinding.speedLimit.setText(String.valueOf(info.getSpeedLimit()));
            }
        } else if (speedLimitType.equals(Constants.NORMAL)) {
            hudArizonaTrainJobBinding.speedLimit.setTextColor(Color.parseColor("#FFFFFF"));
            hudArizonaTrainJobBinding.warningIc.setImageResource(R.drawable.hud_train_normal_speed_limit);
            hudArizonaTrainJobBinding.speedLimit.setText(String.valueOf(info.getSpeedLimit()));
        }
        hudArizonaTrainJobBinding.routeProgress.setProgress(info.getDistance() / info.getTotalDistance());
        hudArizonaTrainJobBinding.maxKm.setText(this.targetActivity.getString(R.string.train_hud_arizona_meters_format, new Object[]{Integer.valueOf((int) info.getTotalDistance())}));
    }

    public final void startTimer(int i) {
        cancelTimer();
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = i;
        CountDownTimer countDownTimer = new CountDownTimer() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.ArizonaTrainHud$startTimer$1
            @Override // android.os.CountDownTimer
            public void onFinish() {
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                HudArizonaTrainJobBinding hudArizonaTrainJobBinding;
                hudArizonaTrainJobBinding = ArizonaTrainHud.this.driverBinding;
                hudArizonaTrainJobBinding.trainCurrentTime.setText(UtilsKt.formatTime(intRef.element * 1000) + " ");
                intRef.element++;
            }
        };
        this.trainTimer = countDownTimer;
        countDownTimer.start();
    }

    public final void setSettingsVisibility(int i) {
        ConstraintLayout root = this.settingsBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(i == 1 ? 0 : 8);
    }

    public final void setDoorState(int i) {
        this.settingsBinding.ivDoorsState.setImageResource(i == 1 ? R.drawable.ic_switch_on : R.drawable.ic_switch_none);
    }

    public final void clear() {
        cancelTimer();
        this.handler.removeCallbacks(this.resetHornState);
    }

    private final void cancelTimer() {
        CountDownTimer countDownTimer = this.trainTimer;
        if (countDownTimer != null) {
            if (countDownTimer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("trainTimer");
                countDownTimer = null;
            }
            countDownTimer.cancel();
        }
    }

    /* compiled from: ArizonaTrainHud.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/ArizonaTrainHud$Companion;", "", "<init>", "()V", "HORN_STATE_RESET_MS", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
