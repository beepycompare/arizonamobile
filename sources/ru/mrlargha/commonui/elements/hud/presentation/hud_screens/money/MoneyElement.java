package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.money;

import android.graphics.Color;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.media3.exoplayer.upstream.CmcdData;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
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
/* compiled from: MoneyElement.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 32\u00020\u0001:\u000234B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fJ\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u001dH\u0002J \u0010%\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\"H\u0002J\u0018\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020(H\u0002J\u0010\u0010.\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010/\u001a\u00020\u0013H\u0002J\u0010\u00100\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u000fH\u0002J\u0010\u00101\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u00102\u001a\u00020\u0013H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/money/MoneyElement;", "", "binding", "Lru/mrlargha/commonui/databinding/HudElementMoneyBinding;", "notifier", "Lru/mrlargha/commonui/core/SAMPUIElement;", "<init>", "(Lru/mrlargha/commonui/databinding/HudElementMoneyBinding;Lru/mrlargha/commonui/core/SAMPUIElement;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/HudElementMoneyBinding;", "getNotifier", "()Lru/mrlargha/commonui/core/SAMPUIElement;", "uiScope", "Lkotlinx/coroutines/CoroutineScope;", "lastValue", "", "hideDeltaJob", "Lkotlinx/coroutines/Job;", "setValue", "", "data", "setDelta", "setupStaticUi", "setupBlock", "item", "Lru/mrlargha/commonui/databinding/HudElementMoneyItemBinding;", "prefix", "applyValues", "parts", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/money/MoneyElement$NumberParts;", "setMainValue", "textView", "Landroid/widget/TextView;", "value", "", "showDelta", "newParts", "bindDelta", "delta", "isKBlock", "", "formatDeltaK", "animateDelta", "view", "Landroid/view/View;", "fromUp", "hideDeltaAnimated", "hideDeltaImmediate", "splitValue", "formatK", "ensureScope", "Companion", "NumberParts", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MoneyElement {
    private static final long ANIM_DURATION = 220;
    private static final long DELTA_VISIBLE_MS = 3000;
    private final HudElementMoneyBinding binding;
    private Job hideDeltaJob;
    private String lastValue;
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
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/money/MoneyElement$Companion;", "", "<init>", "()V", "DELTA_VISIBLE_MS", "", "ANIM_DURATION", "COLOR_DELTA_PLUS", "", "COLOR_DELTA_MINUS", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MoneyElement.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/money/MoneyElement$NumberParts;", "", CmcdData.OBJECT_TYPE_MANIFEST, "", "kk", "k", "<init>", "(III)V", "getM", "()I", "getKk", "getK", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class NumberParts {
        private final int k;
        private final int kk;
        private final int m;

        public static /* synthetic */ NumberParts copy$default(NumberParts numberParts, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = numberParts.m;
            }
            if ((i4 & 2) != 0) {
                i2 = numberParts.kk;
            }
            if ((i4 & 4) != 0) {
                i3 = numberParts.k;
            }
            return numberParts.copy(i, i2, i3);
        }

        public final int component1() {
            return this.m;
        }

        public final int component2() {
            return this.kk;
        }

        public final int component3() {
            return this.k;
        }

        public final NumberParts copy(int i, int i2, int i3) {
            return new NumberParts(i, i2, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NumberParts) {
                NumberParts numberParts = (NumberParts) obj;
                return this.m == numberParts.m && this.kk == numberParts.kk && this.k == numberParts.k;
            }
            return false;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.m) * 31) + Integer.hashCode(this.kk)) * 31) + Integer.hashCode(this.k);
        }

        public String toString() {
            int i = this.m;
            int i2 = this.kk;
            return "NumberParts(m=" + i + ", kk=" + i2 + ", k=" + this.k + ")";
        }

        public NumberParts(int i, int i2, int i3) {
            this.m = i;
            this.kk = i2;
            this.k = i3;
        }

        public final int getM() {
            return this.m;
        }

        public final int getKk() {
            return this.kk;
        }

        public final int getK() {
            return this.k;
        }
    }

    public final void setValue(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ensureScope();
        NumberParts splitValue = splitValue(data);
        String str = this.lastValue;
        if (str != null) {
            splitValue(str);
        }
        applyValues(splitValue);
        this.lastValue = data;
    }

    public final void setDelta(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ensureScope();
        showDelta(splitValue(data));
    }

    private final void setupStaticUi() {
        HudElementMoneyItemBinding blockM = this.binding.blockM;
        Intrinsics.checkNotNullExpressionValue(blockM, "blockM");
        setupBlock(blockM, "M");
        HudElementMoneyItemBinding blockKK = this.binding.blockKK;
        Intrinsics.checkNotNullExpressionValue(blockKK, "blockKK");
        setupBlock(blockKK, "KK");
        HudElementMoneyItemBinding blockK = this.binding.blockK;
        Intrinsics.checkNotNullExpressionValue(blockK, "blockK");
        setupBlock(blockK, "K");
    }

    private final void setupBlock(HudElementMoneyItemBinding hudElementMoneyItemBinding, String str) {
        int hashCode = str.hashCode();
        if (hashCode != 75) {
            if (hashCode != 77) {
                if (hashCode == 2400 && str.equals("KK")) {
                    hudElementMoneyItemBinding.tvPrefix.setImageResource(R.drawable.new_money_kk);
                    hudElementMoneyItemBinding.tvPrefixDelta.setImageResource(R.drawable.new_money_kk);
                }
            } else if (str.equals("M")) {
                hudElementMoneyItemBinding.tvPrefix.setImageResource(R.drawable.new_money_m);
                hudElementMoneyItemBinding.tvPrefixDelta.setImageResource(R.drawable.new_money_m);
            }
        } else if (str.equals("K")) {
            hudElementMoneyItemBinding.tvPrefix.setImageResource(R.drawable.new_money_k);
            hudElementMoneyItemBinding.tvPrefixDelta.setImageResource(R.drawable.new_money_k);
        }
        hudElementMoneyItemBinding.deltaRow.setVisibility(4);
    }

    private final void applyValues(NumberParts numberParts) {
        int m = numberParts.getM();
        HudElementMoneyBinding hudElementMoneyBinding = this.binding;
        if (m == 0) {
            LinearLayout root = hudElementMoneyBinding.blockM.root;
            Intrinsics.checkNotNullExpressionValue(root, "root");
            root.postDelayed(new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.money.MoneyElement$applyValues$$inlined$postDelayed$1
                @Override // java.lang.Runnable
                public final void run() {
                    MoneyElement.this.getBinding().blockM.root.setVisibility(8);
                }
            }, 3000L);
        } else {
            hudElementMoneyBinding.blockM.root.setVisibility(0);
        }
        if (numberParts.getKk() == 0 && numberParts.getM() == 0) {
            LinearLayout root2 = this.binding.blockKK.root;
            Intrinsics.checkNotNullExpressionValue(root2, "root");
            root2.postDelayed(new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.money.MoneyElement$applyValues$$inlined$postDelayed$2
                @Override // java.lang.Runnable
                public final void run() {
                    MoneyElement.this.getBinding().blockKK.root.setVisibility(8);
                }
            }, 3000L);
        } else {
            this.binding.blockKK.root.setVisibility(0);
        }
        this.binding.blockM.tvValue.setText(String.valueOf(numberParts.getM()));
        this.binding.blockKK.tvValue.setText(String.valueOf(numberParts.getKk()));
        this.binding.blockK.tvValue.setText(formatK(numberParts.getK()));
    }

    private final void setMainValue(TextView textView, int i) {
        textView.setText(String.valueOf(i));
    }

    private final void showDelta(NumberParts numberParts) {
        Job launch$default;
        Job job = this.hideDeltaJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        HudElementMoneyItemBinding blockM = this.binding.blockM;
        Intrinsics.checkNotNullExpressionValue(blockM, "blockM");
        bindDelta(blockM, numberParts.getM(), false);
        HudElementMoneyItemBinding blockKK = this.binding.blockKK;
        Intrinsics.checkNotNullExpressionValue(blockKK, "blockKK");
        bindDelta(blockKK, numberParts.getKk(), false);
        HudElementMoneyItemBinding blockK = this.binding.blockK;
        Intrinsics.checkNotNullExpressionValue(blockK, "blockK");
        bindDelta(blockK, numberParts.getK(), true);
        LinearLayout deltaRow = this.binding.blockM.deltaRow;
        Intrinsics.checkNotNullExpressionValue(deltaRow, "deltaRow");
        animateDelta(deltaRow, true);
        LinearLayout deltaRow2 = this.binding.blockKK.deltaRow;
        Intrinsics.checkNotNullExpressionValue(deltaRow2, "deltaRow");
        animateDelta(deltaRow2, true);
        LinearLayout deltaRow3 = this.binding.blockK.deltaRow;
        Intrinsics.checkNotNullExpressionValue(deltaRow3, "deltaRow");
        animateDelta(deltaRow3, true);
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.uiScope, null, null, new MoneyElement$showDelta$1(this, null), 3, null);
        this.hideDeltaJob = launch$default;
    }

    private final void bindDelta(HudElementMoneyItemBinding hudElementMoneyItemBinding, int i, boolean z) {
        String valueOf;
        if (i == 0) {
            hudElementMoneyItemBinding.deltaRow.setVisibility(4);
            hudElementMoneyItemBinding.tvDelta.setText("");
            return;
        }
        hudElementMoneyItemBinding.deltaRow.setVisibility(0);
        TextView textView = hudElementMoneyItemBinding.tvDelta;
        if (z) {
            valueOf = formatDeltaK(i);
        } else {
            valueOf = String.valueOf(Math.abs(i));
        }
        textView.setText(valueOf);
        hudElementMoneyItemBinding.tvDelta.setTextColor(i > 0 ? COLOR_DELTA_PLUS : COLOR_DELTA_MINUS);
    }

    private final String formatDeltaK(int i) {
        int coerceAtMost = RangesKt.coerceAtMost(Math.abs(i), 999999);
        int i2 = coerceAtMost / 1000;
        return i2 + "." + StringsKt.padStart(String.valueOf(coerceAtMost % 1000), 3, '0');
    }

    private final void animateDelta(View view, boolean z) {
        if (view.getVisibility() != 0) {
            return;
        }
        view.clearAnimation();
        view.setAlpha(0.0f);
        view.setTranslationY(z ? -10.0f : 10.0f);
        view.animate().alpha(1.0f).translationY(0.0f).setDuration(ANIM_DURATION).setInterpolator(new DecelerateInterpolator()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideDeltaAnimated(final View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        view.clearAnimation();
        view.animate().alpha(0.0f).translationY(-8.0f).setDuration(180L).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.money.MoneyElement$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MoneyElement.hideDeltaAnimated$lambda$0(view);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void hideDeltaAnimated$lambda$0(View view) {
        view.setVisibility(4);
        view.setAlpha(1.0f);
        view.setTranslationY(0.0f);
    }

    private final void hideDeltaImmediate() {
        Job job = this.hideDeltaJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        for (LinearLayout linearLayout : CollectionsKt.listOf((Object[]) new LinearLayout[]{this.binding.blockM.deltaRow, this.binding.blockKK.deltaRow, this.binding.blockK.deltaRow})) {
            linearLayout.clearAnimation();
            linearLayout.setVisibility(4);
            linearLayout.setAlpha(1.0f);
            linearLayout.setTranslationY(0.0f);
        }
    }

    private final NumberParts splitValue(String str) {
        String str2 = str;
        boolean z = StringsKt.first(str2) == '-';
        String replace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.trim((CharSequence) str2).toString(), " ", "", false, 4, (Object) null), StringUtils.COMMA, "", false, 4, (Object) null);
        if (replace$default.length() == 0) {
            replace$default = "0";
        }
        String padStart = StringsKt.padStart(replace$default, 13, '0');
        String dropLast = StringsKt.dropLast(padStart, 9);
        String dropLast2 = StringsKt.dropLast(StringsKt.takeLast(padStart, 9), 6);
        String takeLast = StringsKt.takeLast(padStart, 6);
        String trimStart = StringsKt.trimStart(dropLast, '0');
        if (trimStart.length() == 0) {
            trimStart = "0";
        }
        String str3 = trimStart;
        String trimStart2 = StringsKt.trimStart(dropLast2, '0');
        if (trimStart2.length() == 0) {
            trimStart2 = "0";
        }
        String str4 = trimStart2;
        String trimStart3 = StringsKt.trimStart(takeLast, '0');
        String str5 = trimStart3.length() != 0 ? trimStart3 : "0";
        int i = z ? -1 : 1;
        Integer intOrNull = StringsKt.toIntOrNull(str3);
        int abs = Math.abs(intOrNull != null ? intOrNull.intValue() : 0) * i;
        Integer intOrNull2 = StringsKt.toIntOrNull(str4);
        int abs2 = Math.abs(intOrNull2 != null ? intOrNull2.intValue() : 0) * i;
        Integer intOrNull3 = StringsKt.toIntOrNull(str5);
        return new NumberParts(abs, abs2, i * Math.abs(intOrNull3 != null ? intOrNull3.intValue() : 0));
    }

    private final String formatK(int i) {
        int coerceIn = RangesKt.coerceIn(i, 0, 999999);
        int i2 = coerceIn / 1000;
        return i2 + "." + StringsKt.padStart(String.valueOf(coerceIn % 1000), 3, '0');
    }

    private final void ensureScope() {
        Job job = (Job) this.uiScope.getCoroutineContext().get(Job.Key);
        if (job == null || !job.isActive()) {
            this.uiScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        }
    }
}
