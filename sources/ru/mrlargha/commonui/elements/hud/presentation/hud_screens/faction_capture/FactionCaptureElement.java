package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.faction_capture;

import android.os.CountDownTimer;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.HudFactionCaptureBinding;
/* compiled from: FactionCaptureElement.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/faction_capture/FactionCaptureElement;", "", "binding", "Lru/mrlargha/commonui/databinding/HudFactionCaptureBinding;", "<init>", "(Lru/mrlargha/commonui/databinding/HudFactionCaptureBinding;)V", "showRequested", "", "countDownTimer", "Landroid/os/CountDownTimer;", "currentState", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/faction_capture/FactionCaptureState;", "event", "", "payload", "", "show", RemoteConfigConstants.ResponseFieldKey.STATE, "restartTimer", "hide", "startTimer", "remainingSeconds", "", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FactionCaptureElement {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final long HIDE_ANIMATION_DURATION_MS = 160;
    @Deprecated
    public static final long MILLIS_PER_SECOND = 1000;
    @Deprecated
    public static final long SHOW_ANIMATION_DURATION_MS = 240;
    private final HudFactionCaptureBinding binding;
    private CountDownTimer countDownTimer;
    private FactionCaptureState currentState;
    private boolean showRequested;

    public FactionCaptureElement(HudFactionCaptureBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public final void event(String payload) {
        FactionCaptureState initialStateOrNull;
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (StringsKt.isBlank(payload)) {
            hide();
            return;
        }
        FactionCaptureData parseFactionCapturePayload = FactionCaptureDataKt.parseFactionCapturePayload(payload);
        if (parseFactionCapturePayload == null) {
            return;
        }
        FactionCaptureState factionCaptureState = this.currentState;
        if ((factionCaptureState == null || (initialStateOrNull = FactionCaptureDataKt.merge(factionCaptureState, parseFactionCapturePayload)) == null) && (initialStateOrNull = FactionCaptureDataKt.toInitialStateOrNull(parseFactionCapturePayload)) == null) {
            return;
        }
        this.currentState = initialStateOrNull;
        show(initialStateOrNull, factionCaptureState == null || parseFactionCapturePayload.getRemainingSeconds() != null);
    }

    private final void show(FactionCaptureState factionCaptureState, boolean z) {
        HudFactionCaptureBinding hudFactionCaptureBinding = this.binding;
        hudFactionCaptureBinding.leftFaction.setText(factionCaptureState.getLeftFaction());
        hudFactionCaptureBinding.rightFaction.setText(factionCaptureState.getRightFaction());
        hudFactionCaptureBinding.leftScore.setText(String.valueOf(factionCaptureState.getLeftScore()));
        hudFactionCaptureBinding.rightScore.setText(String.valueOf(factionCaptureState.getRightScore()));
        hudFactionCaptureBinding.status.setText(factionCaptureState.getStatus());
        if (z) {
            startTimer(factionCaptureState.getRemainingSeconds());
        }
        hudFactionCaptureBinding.getRoot().animate().cancel();
        if (this.showRequested) {
            LinearLayout root = hudFactionCaptureBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            if (root.getVisibility() == 0) {
                hudFactionCaptureBinding.getRoot().setAlpha(1.0f);
                hudFactionCaptureBinding.getRoot().setTranslationY(0.0f);
                return;
            }
        }
        this.showRequested = true;
        hudFactionCaptureBinding.getRoot().setAlpha(0.0f);
        hudFactionCaptureBinding.getRoot().setTranslationY(hudFactionCaptureBinding.getRoot().getResources().getDimension(R.dimen._6sdp));
        LinearLayout root2 = hudFactionCaptureBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        root2.setVisibility(0);
        hudFactionCaptureBinding.getRoot().animate().alpha(1.0f).translationY(0.0f).setDuration(240L).setInterpolator(new DecelerateInterpolator()).start();
    }

    private final void hide() {
        this.currentState = null;
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.countDownTimer = null;
        final LinearLayout root = this.binding.getRoot();
        if (!this.showRequested) {
            Intrinsics.checkNotNull(root);
            if (root.getVisibility() != 0) {
                return;
            }
        }
        this.showRequested = false;
        root.animate().cancel();
        root.animate().alpha(0.0f).translationY(root.getResources().getDimension(R.dimen._4sdp)).setDuration(160L).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.faction_capture.FactionCaptureElement$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FactionCaptureElement.hide$lambda$0$0(FactionCaptureElement.this, root);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hide$lambda$0$0(FactionCaptureElement factionCaptureElement, LinearLayout linearLayout) {
        if (factionCaptureElement.showRequested) {
            return;
        }
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setVisibility(8);
        linearLayout.setAlpha(1.0f);
        linearLayout.setTranslationY(0.0f);
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [ru.mrlargha.commonui.elements.hud.presentation.hud_screens.faction_capture.FactionCaptureElement$startTimer$1] */
    private final void startTimer(int i) {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.countDownTimer = null;
        int coerceAtLeast = RangesKt.coerceAtLeast(i, 0);
        this.binding.timer.setText(FactionCaptureDataKt.formatFactionCaptureTime(coerceAtLeast));
        if (coerceAtLeast == 0) {
            return;
        }
        final long j = coerceAtLeast * 1000;
        this.countDownTimer = new CountDownTimer(j) { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.faction_capture.FactionCaptureElement$startTimer$1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                HudFactionCaptureBinding hudFactionCaptureBinding;
                hudFactionCaptureBinding = FactionCaptureElement.this.binding;
                hudFactionCaptureBinding.timer.setText(FactionCaptureDataKt.formatFactionCaptureTime((int) ((j2 + 999) / 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                HudFactionCaptureBinding hudFactionCaptureBinding;
                hudFactionCaptureBinding = FactionCaptureElement.this.binding;
                hudFactionCaptureBinding.timer.setText(FactionCaptureDataKt.formatFactionCaptureTime(0));
                FactionCaptureElement.this.countDownTimer = null;
            }
        }.start();
    }

    /* compiled from: FactionCaptureElement.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/faction_capture/FactionCaptureElement$Companion;", "", "<init>", "()V", "SHOW_ANIMATION_DURATION_MS", "", "HIDE_ANIMATION_DURATION_MS", "MILLIS_PER_SECOND", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
