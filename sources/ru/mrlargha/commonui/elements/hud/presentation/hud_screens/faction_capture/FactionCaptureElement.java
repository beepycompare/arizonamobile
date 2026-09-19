package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.faction_capture;

import android.content.res.Resources;
import android.os.CountDownTimer;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.HudFactionCaptureBinding;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: FactionCaptureElement.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\rH\u0002J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/faction_capture/FactionCaptureElement;", "", "binding", "Lru/mrlargha/commonui/databinding/HudFactionCaptureBinding;", "<init>", "(Lru/mrlargha/commonui/databinding/HudFactionCaptureBinding;)V", "showRequested", "", "countDownTimer", "Landroid/os/CountDownTimer;", "currentState", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/faction_capture/FactionCaptureState;", "event", "", "payload", "", "show", RemoteConfigConstants.ResponseFieldKey.STATE, "restartTimer", "applyCaptureAppearance", "isBattle", "hide", "startTimer", "remainingSeconds", "", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FactionCaptureElement {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final long HIDE_ANIMATION_DURATION_MS = 160;
    @Deprecated
    public static final long MILLIS_PER_SECOND = 1000;
    @Deprecated
    public static final String PREPARATION_STATUS = "ПОДГОТОВКА К СРАЖЕНИЮ";
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
        applyCaptureAppearance(!Companion.isPreparationStatus(factionCaptureState.getStatus()));
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

    private final void applyCaptureAppearance(boolean z) {
        HudFactionCaptureBinding hudFactionCaptureBinding = this.binding;
        Resources resources = hudFactionCaptureBinding.getRoot().getResources();
        int dimensionPixelSize = z ? -2 : resources.getDimensionPixelSize(R.dimen._90sdp);
        int dimensionPixelSize2 = z ? -2 : resources.getDimensionPixelSize(R.dimen._25sdp);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen._6sdp);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen._8sdp);
        int dimensionPixelSize5 = resources.getDimensionPixelSize(R.dimen._4sdp);
        int color = ContextCompat.getColor(hudFactionCaptureBinding.getRoot().getContext(), R.color.hud_faction_capture_waiting_label_bg);
        int color2 = ContextCompat.getColor(hudFactionCaptureBinding.getRoot().getContext(), R.color.hud_faction_capture_waiting_fill);
        CustomCardView leftScoreContainer = hudFactionCaptureBinding.leftScoreContainer;
        Intrinsics.checkNotNullExpressionValue(leftScoreContainer, "leftScoreContainer");
        leftScoreContainer.setVisibility(z ? 0 : 8);
        CustomCardView rightScoreContainer = hudFactionCaptureBinding.rightScoreContainer;
        Intrinsics.checkNotNullExpressionValue(rightScoreContainer, "rightScoreContainer");
        rightScoreContainer.setVisibility(z ? 0 : 8);
        LinearLayout leftFactionColumn = hudFactionCaptureBinding.leftFactionColumn;
        Intrinsics.checkNotNullExpressionValue(leftFactionColumn, "leftFactionColumn");
        LinearLayout linearLayout = leftFactionColumn;
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        FrameLayout.LayoutParams layoutParams3 = layoutParams2;
        layoutParams3.width = dimensionPixelSize;
        int i = GravityCompat.END;
        layoutParams3.gravity = GravityCompat.END;
        linearLayout.setLayoutParams(layoutParams2);
        LinearLayout rightFactionColumn = hudFactionCaptureBinding.rightFactionColumn;
        Intrinsics.checkNotNullExpressionValue(rightFactionColumn, "rightFactionColumn");
        LinearLayout linearLayout2 = rightFactionColumn;
        ViewGroup.LayoutParams layoutParams4 = linearLayout2.getLayoutParams();
        if (layoutParams4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) layoutParams4;
        FrameLayout.LayoutParams layoutParams6 = layoutParams5;
        layoutParams6.width = dimensionPixelSize;
        int i2 = GravityCompat.START;
        layoutParams6.gravity = GravityCompat.START;
        linearLayout2.setLayoutParams(layoutParams5);
        TextView leftFaction = hudFactionCaptureBinding.leftFaction;
        Intrinsics.checkNotNullExpressionValue(leftFaction, "leftFaction");
        TextView textView = leftFaction;
        ViewGroup.LayoutParams layoutParams7 = textView.getLayoutParams();
        if (layoutParams7 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) layoutParams7;
        LinearLayout.LayoutParams layoutParams9 = layoutParams8;
        layoutParams9.width = z ? -2 : -1;
        layoutParams9.height = dimensionPixelSize2;
        layoutParams9.bottomMargin = z ? dimensionPixelSize3 : 0;
        if (z) {
            i = 1;
        }
        layoutParams9.gravity = i;
        textView.setLayoutParams(layoutParams8);
        TextView rightFaction = hudFactionCaptureBinding.rightFaction;
        Intrinsics.checkNotNullExpressionValue(rightFaction, "rightFaction");
        TextView textView2 = rightFaction;
        ViewGroup.LayoutParams layoutParams10 = textView2.getLayoutParams();
        if (layoutParams10 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        LinearLayout.LayoutParams layoutParams11 = (LinearLayout.LayoutParams) layoutParams10;
        LinearLayout.LayoutParams layoutParams12 = layoutParams11;
        layoutParams12.width = z ? -2 : -1;
        layoutParams12.height = dimensionPixelSize2;
        if (!z) {
            dimensionPixelSize3 = 0;
        }
        layoutParams12.bottomMargin = dimensionPixelSize3;
        if (z) {
            i2 = 1;
        }
        layoutParams12.gravity = i2;
        textView2.setLayoutParams(layoutParams11);
        if (z) {
            dimensionPixelSize4 = 0;
        }
        if (z) {
            dimensionPixelSize5 = 0;
        }
        TextView leftFaction2 = hudFactionCaptureBinding.leftFaction;
        Intrinsics.checkNotNullExpressionValue(leftFaction2, "leftFaction");
        leftFaction2.setPadding(dimensionPixelSize4, dimensionPixelSize5, dimensionPixelSize4, dimensionPixelSize5);
        TextView rightFaction2 = hudFactionCaptureBinding.rightFaction;
        Intrinsics.checkNotNullExpressionValue(rightFaction2, "rightFaction");
        rightFaction2.setPadding(dimensionPixelSize4, dimensionPixelSize5, dimensionPixelSize4, dimensionPixelSize5);
        if (z) {
            hudFactionCaptureBinding.leftFaction.setBackgroundColor(0);
            hudFactionCaptureBinding.rightFaction.setBackgroundColor(0);
            hudFactionCaptureBinding.counterContainer.setBackground(ContextCompat.getColor(hudFactionCaptureBinding.getRoot().getContext(), R.color.hud_faction_capture_center));
            CustomCardView counterContainer = hudFactionCaptureBinding.counterContainer;
            Intrinsics.checkNotNullExpressionValue(counterContainer, "counterContainer");
            CustomCardView customCardView = counterContainer;
            ViewGroup.LayoutParams layoutParams13 = customCardView.getLayoutParams();
            if (layoutParams13 != null) {
                LinearLayout.LayoutParams layoutParams14 = (LinearLayout.LayoutParams) layoutParams13;
                layoutParams14.gravity = 80;
                customCardView.setLayoutParams(layoutParams14);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        hudFactionCaptureBinding.leftFaction.setBackgroundColor(color);
        hudFactionCaptureBinding.rightFaction.setBackgroundColor(color);
        hudFactionCaptureBinding.counterContainer.setBackground(color2);
        CustomCardView counterContainer2 = hudFactionCaptureBinding.counterContainer;
        Intrinsics.checkNotNullExpressionValue(counterContainer2, "counterContainer");
        CustomCardView customCardView2 = counterContainer2;
        ViewGroup.LayoutParams layoutParams15 = customCardView2.getLayoutParams();
        if (layoutParams15 != null) {
            LinearLayout.LayoutParams layoutParams16 = (LinearLayout.LayoutParams) layoutParams15;
            layoutParams16.gravity = 16;
            customCardView2.setLayoutParams(layoutParams16);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FactionCaptureElement.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/faction_capture/FactionCaptureElement$Companion;", "", "<init>", "()V", "SHOW_ANIMATION_DURATION_MS", "", "HIDE_ANIMATION_DURATION_MS", "MILLIS_PER_SECOND", "PREPARATION_STATUS", "", "isPreparationStatus", "", "status", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isPreparationStatus(String status) {
            Intrinsics.checkNotNullParameter(status, "status");
            return StringsKt.equals(StringsKt.trim((CharSequence) status).toString(), FactionCaptureElement.PREPARATION_STATUS, true);
        }
    }
}
