package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.money;

import android.graphics.Color;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import com.google.android.vending.expansion.downloader.Constants;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.HudElementMoneyBinding;
import ru.mrlargha.commonui.databinding.HudElementMoneyItemBinding;
import ru.mrlargha.commonui.utils.ui.money.MoneyFormatter;
/* compiled from: MoneyElement.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 '2\u00020\u0001:\u0001'B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0018H\u0002J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0013H\u0002J\f\u0010%\u001a\u00020\u0018*\u00020\u0018H\u0002J\b\u0010&\u001a\u00020\u0011H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/money/MoneyElement;", "", "binding", "Lru/mrlargha/commonui/databinding/HudElementMoneyBinding;", "notifier", "Lru/mrlargha/commonui/core/SAMPUIElement;", "<init>", "(Lru/mrlargha/commonui/databinding/HudElementMoneyBinding;Lru/mrlargha/commonui/core/SAMPUIElement;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/HudElementMoneyBinding;", "getNotifier", "()Lru/mrlargha/commonui/core/SAMPUIElement;", "uiScope", "Lkotlinx/coroutines/CoroutineScope;", "hideDeltaJob", "Lkotlinx/coroutines/Job;", "setValue", "", "data", "", "setDelta", "setupStaticUi", "showDelta", "delta", "", "bindDelta", "item", "Lru/mrlargha/commonui/databinding/HudElementMoneyItemBinding;", "animateDelta", "view", "Landroid/view/View;", "hideDeltaAnimated", "clearDelta", "formatValue", "value", "formatDeltaAmount", "parseMoney", "absSafe", "ensureScope", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MoneyElement {
    private static final long ANIM_DURATION = 220;
    private static final long DELTA_VISIBLE_MS = 3000;
    private final HudElementMoneyBinding binding;
    private Job hideDeltaJob;
    private final SAMPUIElement notifier;
    private CoroutineScope uiScope;
    public static final Companion Companion = new Companion(null);
    private static final int COLOR_DELTA_PLUS = Color.parseColor("#88FF48");
    private static final int COLOR_DELTA_MINUS = Color.parseColor("#FF4848");

    public MoneyElement(HudElementMoneyBinding binding, SAMPUIElement notifier) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(notifier, "notifier");
        this.binding = binding;
        this.notifier = notifier;
        this.uiScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob((Job) null).plus(Dispatchers.getMain().getImmediate()));
        binding.root.setVisibility(8);
        setupStaticUi();
    }

    public final HudElementMoneyBinding getBinding() {
        return this.binding;
    }

    public final SAMPUIElement getNotifier() {
        return this.notifier;
    }

    /* compiled from: MoneyElement.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/money/MoneyElement$Companion;", "", "<init>", "()V", "DELTA_VISIBLE_MS", "", "ANIM_DURATION", "COLOR_DELTA_PLUS", "", "COLOR_DELTA_MINUS", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void setValue(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ensureScope();
        this.binding.root.setVisibility(0);
        this.binding.blockMoney.tvValue.setText(formatValue(parseMoney(data)));
        this.binding.root.requestLayout();
    }

    public final void setDelta(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ensureScope();
        this.binding.root.setVisibility(0);
        showDelta(parseMoney(data));
    }

    private final void setupStaticUi() {
        HudElementMoneyItemBinding hudElementMoneyItemBinding = this.binding.blockMoney;
        hudElementMoneyItemBinding.tvPrefix.setImageResource(R.drawable.arizona_dollar);
        hudElementMoneyItemBinding.tvPrefixDelta.setImageResource(R.drawable.arizona_dollar);
        hudElementMoneyItemBinding.deltaRow.setVisibility(4);
    }

    private final void showDelta(long j) {
        Job launch$default;
        Job job = this.hideDeltaJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        HudElementMoneyItemBinding blockMoney = this.binding.blockMoney;
        Intrinsics.checkNotNullExpressionValue(blockMoney, "blockMoney");
        bindDelta(blockMoney, j);
        LinearLayout deltaRow = this.binding.blockMoney.deltaRow;
        Intrinsics.checkNotNullExpressionValue(deltaRow, "deltaRow");
        animateDelta(deltaRow);
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.uiScope, null, null, new MoneyElement$showDelta$1(this, null), 3, null);
        this.hideDeltaJob = launch$default;
    }

    private final void bindDelta(HudElementMoneyItemBinding hudElementMoneyItemBinding, long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i == 0) {
            clearDelta(hudElementMoneyItemBinding);
            return;
        }
        int i2 = i > 0 ? COLOR_DELTA_PLUS : COLOR_DELTA_MINUS;
        hudElementMoneyItemBinding.deltaRow.setVisibility(0);
        hudElementMoneyItemBinding.tvDeltaSign.setText(i > 0 ? "+" : Constants.FILENAME_SEQUENCE_SEPARATOR);
        hudElementMoneyItemBinding.tvDelta.setText(formatDeltaAmount(j));
        hudElementMoneyItemBinding.tvDeltaSign.setTextColor(i2);
        hudElementMoneyItemBinding.tvDelta.setTextColor(i2);
        if (i < 0) {
            hudElementMoneyItemBinding.tvPrefixDelta.setColorFilter(COLOR_DELTA_MINUS);
        } else {
            hudElementMoneyItemBinding.tvPrefixDelta.clearColorFilter();
        }
    }

    private final void animateDelta(View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        view.clearAnimation();
        view.setAlpha(0.0f);
        view.setTranslationY(-10.0f);
        view.animate().alpha(1.0f).translationY(0.0f).setDuration(ANIM_DURATION).setInterpolator(new DecelerateInterpolator()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideDeltaAnimated(View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        view.clearAnimation();
        view.animate().alpha(0.0f).translationY(-8.0f).setDuration(180L).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.money.MoneyElement$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MoneyElement.hideDeltaAnimated$lambda$0(MoneyElement.this);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void hideDeltaAnimated$lambda$0(MoneyElement moneyElement) {
        HudElementMoneyItemBinding blockMoney = moneyElement.binding.blockMoney;
        Intrinsics.checkNotNullExpressionValue(blockMoney, "blockMoney");
        moneyElement.clearDelta(blockMoney);
    }

    private final void clearDelta(HudElementMoneyItemBinding hudElementMoneyItemBinding) {
        hudElementMoneyItemBinding.deltaRow.setVisibility(4);
        hudElementMoneyItemBinding.tvDeltaSign.setText("");
        hudElementMoneyItemBinding.tvDelta.setText("");
        hudElementMoneyItemBinding.tvPrefixDelta.clearColorFilter();
        hudElementMoneyItemBinding.deltaRow.setAlpha(1.0f);
        hudElementMoneyItemBinding.deltaRow.setTranslationY(0.0f);
        this.binding.root.requestLayout();
    }

    private final String formatValue(long j) {
        String formatPlain = MoneyFormatter.INSTANCE.formatPlain(absSafe(j));
        return j < 0 ? "- " + formatPlain : formatPlain;
    }

    private final String formatDeltaAmount(long j) {
        return MoneyFormatter.INSTANCE.formatPlain(absSafe(j));
    }

    private final long parseMoney(String str) {
        String replace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.trim((CharSequence) str).toString(), " ", "", false, 4, (Object) null), StringUtils.COMMA, "", false, 4, (Object) null);
        if (replace$default.length() == 0) {
            replace$default = "0";
        }
        Long longOrNull = StringsKt.toLongOrNull(replace$default);
        if (longOrNull != null) {
            return longOrNull.longValue();
        }
        return 0L;
    }

    private final long absSafe(long j) {
        if (j == Long.MIN_VALUE) {
            return Long.MAX_VALUE;
        }
        return Math.abs(j);
    }

    private final void ensureScope() {
        Job job = (Job) this.uiScope.getCoroutineContext().get(Job.Key);
        if (job == null || !job.isActive()) {
            this.uiScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        }
    }
}
