package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.payday;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.HudElementPaydayBinding;
import ru.mrlargha.commonui.databinding.HudElementPaydayItemBinding;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.money.MoneyElementKt;
import ru.mrlargha.commonui.utils.ui.money.MoneyFormatter;
import ru.mrlargha.commonui.utils.ui.textWithIcons.IconAndSize;
import ru.mrlargha.commonui.utils.ui.textWithIcons.TextWithIconsKt;
/* compiled from: PaydayElement.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001d\u001a\u00020\u0019H\u0002J\u0006\u0010\u001e\u001a\u00020\u0019J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00152\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J\u0018\u0010%\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010&\u001a\u00020$H\u0002J\u001a\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001bH\u0002J\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u000fH\u0002J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u000fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0014\u001a\r\u0012\t\u0012\u00070\u0016¢\u0006\u0002\b\u00170\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayElement;", "", "binding", "Lru/mrlargha/commonui/databinding/HudElementPaydayBinding;", "notifier", "Lru/mrlargha/commonui/core/SAMPUIElement;", "<init>", "(Lru/mrlargha/commonui/databinding/HudElementPaydayBinding;Lru/mrlargha/commonui/core/SAMPUIElement;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/HudElementPaydayBinding;", "getNotifier", "()Lru/mrlargha/commonui/core/SAMPUIElement;", "clockJob", "Lkotlinx/coroutines/Job;", "secondsPassed", "", "currentData", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayData;", "isVisible", "", "cards", "", "Lru/mrlargha/commonui/databinding/HudElementPaydayItemBinding;", "Lkotlin/jvm/internal/EnhancedNullability;", "setVisibility", "", "data", "", "setInfo", "startClock", "stopClock", "render", "renderHeader", "renderOnline", "renderCards", "buildCards", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/PaydayCardUi;", "bindCard", "item", "formExtraCard", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/payday/ExtraData;", "int", "", "postfix", "formatTime", "actualTime", "formatTimer", "seconds", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PaydayElement {
    private final HudElementPaydayBinding binding;
    private final List<HudElementPaydayItemBinding> cards;
    private Job clockJob;
    private PaydayData currentData;
    private boolean isVisible;
    private final SAMPUIElement notifier;
    private long secondsPassed;

    public PaydayElement(HudElementPaydayBinding binding, SAMPUIElement notifier) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(notifier, "notifier");
        this.binding = binding;
        this.notifier = notifier;
        this.cards = CollectionsKt.listOf((Object[]) new HudElementPaydayItemBinding[]{binding.cardLevel, binding.cardDeposit, binding.cardFraction, binding.cardAz, binding.cardLaws, binding.cardAdditional});
        binding.close.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.payday.PaydayElement$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SAMPUIElement.notifyClick$default(PaydayElement.this.notifier, 108, 108, null, 4, null);
            }
        });
    }

    public final HudElementPaydayBinding getBinding() {
        return this.binding;
    }

    public final SAMPUIElement getNotifier() {
        return this.notifier;
    }

    public final void setVisibility(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (Intrinsics.areEqual(data, "1")) {
            this.isVisible = true;
            this.binding.main.setTranslationX(800.0f);
            this.binding.getRoot().setVisibility(0);
            this.binding.main.animate().translationX(0.0f).setDuration(800L).setInterpolator(new DecelerateInterpolator()).start();
            return;
        }
        this.isVisible = false;
        this.binding.main.animate().translationX(800.0f).setDuration(800L).setInterpolator(new DecelerateInterpolator()).start();
        this.binding.getRoot().postDelayed(new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.payday.PaydayElement$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PaydayElement.setVisibility$lambda$0(PaydayElement.this);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void setVisibility$lambda$0(PaydayElement paydayElement) {
        if (paydayElement.isVisible) {
            return;
        }
        paydayElement.binding.getRoot().setVisibility(8);
    }

    private final void startClock() {
        Job launch$default;
        stopClock();
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new PaydayElement$startClock$1(this, null), 3, null);
        this.clockJob = launch$default;
    }

    public final void stopClock() {
        Job job = this.clockJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.clockJob = null;
        this.secondsPassed = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void render(PaydayData paydayData) {
        renderHeader(paydayData);
        renderOnline(paydayData);
        renderCards(paydayData);
    }

    private final void renderHeader(PaydayData paydayData) {
        TextView textView = this.binding.tvMainIncome;
        Context context = this.binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.setText(TextWithIconsKt.toTextWithIcons(StringsKt.replace$default(StringsKt.replace$default(MoneyFormatter.format$default(MoneyFormatter.INSTANCE, paydayData.getIncomeMoney(), true, "+ ", null, 8, null), ":kk:", "<ic>1<ic>", false, 4, (Object) null), ":k:", "<ic>2<ic>", false, 4, (Object) null), context, new IconAndSize(R.drawable.hud_element_payday_kk, R.dimen._12sdp, R.dimen._7sdp), new IconAndSize(R.drawable.hud_element_payday_k, R.dimen._8sdp, R.dimen._7sdp)));
        boolean z = paydayData.getPaydayMultiplier().getValue() >= 3;
        FrameLayout root = this.binding.badgePaydayMultiplier.root;
        Intrinsics.checkNotNullExpressionValue(root, "root");
        root.setVisibility(z ? 0 : 8);
        if (z) {
            this.binding.badgePaydayMultiplier.text.setText("X" + paydayData.getPaydayMultiplier().getValue() + (paydayData.getPaydayMultiplier().getTimer() > 0 ? " " + formatTimer(paydayData.getPaydayMultiplier().getTimer() - this.secondsPassed) : ""));
        }
        boolean z2 = paydayData.getHouseMultiplier() > 1;
        FrameLayout root2 = this.binding.badgeHouseMultiplier.root;
        Intrinsics.checkNotNullExpressionValue(root2, "root");
        root2.setVisibility(z2 ? 0 : 8);
        if (z2) {
            this.binding.badgeHouseMultiplier.text.setText("X" + paydayData.getHouseMultiplier() + " ДОМ");
        }
        int i = (paydayData.getPlayedHour() > 900L ? 1 : (paydayData.getPlayedHour() == 900L ? 0 : -1));
        HudElementPaydayBinding hudElementPaydayBinding = this.binding;
        if (i < 0) {
            hudElementPaydayBinding.warningCard.root.setVisibility(0);
        } else {
            hudElementPaydayBinding.warningCard.root.setVisibility(8);
        }
    }

    private final void renderOnline(PaydayData paydayData) {
        this.binding.tvTodayTime.setText(formatTime(paydayData.getPlayedToday()));
        this.binding.tvHourTime.setText(formatTime(paydayData.getPlayedHour() + this.secondsPassed));
    }

    private final void renderCards(PaydayData paydayData) {
        List<PaydayCardUi> buildCards = buildCards(paydayData);
        int i = 0;
        for (Object obj : this.cards) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            HudElementPaydayItemBinding hudElementPaydayItemBinding = (HudElementPaydayItemBinding) obj;
            PaydayCardUi paydayCardUi = (PaydayCardUi) CollectionsKt.getOrNull(buildCards, i);
            if (paydayCardUi == null) {
                hudElementPaydayItemBinding.getRoot().setVisibility(8);
            } else {
                Intrinsics.checkNotNull(hudElementPaydayItemBinding);
                bindCard(hudElementPaydayItemBinding, paydayCardUi);
            }
            i = i2;
        }
    }

    private final List<PaydayCardUi> buildCards(PaydayData paydayData) {
        PaydayCardUi paydayCardUi;
        char c;
        Object obj;
        PaydayCardUi paydayCardUi2;
        String str;
        PaydayCardUi paydayCardUi3;
        String str2;
        String str3;
        String name;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = arrayList;
        if (paydayData.getLevel().getLostProperty().length() > 0) {
            paydayCardUi = new PaydayCardUi("Ваш " + paydayData.getLevel().getLostProperty(), "Слетел", null, null, R.drawable.hud_element_payday_ic_lost, "#EA1E1E", "#FFC5C5", false, null, 396, null);
        } else {
            paydayCardUi = new PaydayCardUi(paydayData.getLevel().getLevel() + " уровень", paydayData.getLevel().getCurrentExp() + " / " + paydayData.getLevel().getMaxExp(), null, null, R.drawable.hud_element_payday_ic_level, "#1558A0", "#5DDCFF", false, null, 396, null);
        }
        arrayList2.add(paydayCardUi);
        ExtraData formExtraCard = formExtraCard(paydayData.getDeposit().getPercent(), "%");
        if (paydayData.getDeposit().getTaxWarningProperty().length() > 0) {
            paydayCardUi2 = new PaydayCardUi("Скоро слетит", paydayData.getDeposit().getTaxWarningProperty(), null, null, R.drawable.hud_element_payday_ic_deposit_warn, "#FFA600", "#FFF2BD", false, null, 396, null);
            c = 0;
            obj = AppMeasurementSdk.ConditionalUserProperty.ACTIVE;
        } else if (Intrinsics.areEqual(paydayData.getDeposit().getState(), AppMeasurementSdk.ConditionalUserProperty.ACTIVE)) {
            SpannableString moneyFormattedSpannable$default = MoneyElementKt.toMoneyFormattedSpannable$default(paydayData.getDeposit().getIncome(), true, "+", null, 4, null);
            int i = paydayData.getDeposit().getHasAgenda() ? R.drawable.hud_element_payday_ic_deposit_agenda : R.drawable.hud_element_payday_ic_deposit;
            SpannableString spannableString = moneyFormattedSpannable$default;
            obj = AppMeasurementSdk.ConditionalUserProperty.ACTIVE;
            c = 0;
            paydayCardUi2 = new PaydayCardUi("Депозит", spannableString, null, formExtraCard, i, "#46A015", "#CCF053", false, null, 388, null);
        } else {
            c = 0;
            obj = AppMeasurementSdk.ConditionalUserProperty.ACTIVE;
            SpannableString spannableString2 = new SpannableString("Временно заблокирован");
            spannableString2.setSpan(new RelativeSizeSpan(0.66f), 0, spannableString2.length(), 33);
            paydayCardUi2 = new PaydayCardUi("Депозит", spannableString2, null, null, R.drawable.hud_element_payday_ic_deposit, "#46A015", "#CCF053", true, null, 268, null);
        }
        arrayList2.add(paydayCardUi2);
        ExtraData formExtraCard2 = formExtraCard(paydayData.getFraction().getPercent(), "%");
        ExtraData extraData = paydayData.getFraction().getMultiplier() > 1 ? new ExtraData("X" + paydayData.getFraction().getMultiplier(), -1, Color.parseColor("#FF4400")) : null;
        if (paydayData.getFraction().getDebuffType().length() > 0) {
            if (Intrinsics.areEqual(paydayData.getFraction().getDebuffType(), "medCard")) {
                Context context = this.binding.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                IconAndSize[] iconAndSizeArr = new IconAndSize[1];
                iconAndSizeArr[c] = new IconAndSize(R.drawable.hud_element_payday_warning_ic, R.dimen._5sdp, R.dimen._5sdp);
                name = TextWithIconsKt.toTextWithIcons("<ic>1<ic> Мед.карта", context, iconAndSizeArr);
            } else {
                name = paydayData.getFraction().getName();
            }
            CharSequence charSequence = name;
            str = "";
            paydayCardUi3 = new PaydayCardUi(charSequence, MoneyElementKt.toMoneyFormattedSpannable$default(paydayData.getFraction().getIncome(), true, "+", null, 4, null), formExtraCard2, null, R.drawable.hud_element_payday_ic_fraction, "#80719E", "#B9AED0", false, null, 392, null);
        } else {
            str = "";
            if (Intrinsics.areEqual(paydayData.getFraction().getState(), "noUniform")) {
                paydayCardUi3 = new PaydayCardUi(paydayData.getFraction().getName(), "Вы не в форме", null, null, R.drawable.hud_element_payday_ic_fraction, "#80719E", "#B9AED0", true, null, 268, null);
            } else if (Intrinsics.areEqual(paydayData.getFraction().getState(), obj)) {
                paydayCardUi3 = new PaydayCardUi(paydayData.getFraction().getName(), MoneyElementKt.toMoneyFormattedSpannable$default(paydayData.getFraction().getIncome(), true, "+", null, 4, null), formExtraCard2, extraData, R.drawable.hud_element_payday_ic_fraction, "#80719E", "#B9AED0", false, null, RendererCapabilities.DECODER_SUPPORT_MASK, null);
            } else if (Intrinsics.areEqual(paydayData.getFraction().getState(), "noFraction")) {
                paydayCardUi3 = new PaydayCardUi(str, str, null, null, R.drawable.hud_element_payday_ic_fraction, "#80719E", "#B9AED0", false, "вступи во фракцию и зарабатывай каждый payday", 140, null);
            } else {
                paydayCardUi3 = new PaydayCardUi("Фракция", "НЕ СОСТОИТ", null, null, R.drawable.hud_element_payday_ic_fraction, "#80719E", "#B9AED0", false, null, 396, null);
            }
        }
        arrayList2.add(paydayCardUi3);
        arrayList2.add(new PaydayCardUi("AZ COINS", paydayData.getAz().getCurrent() + " AZ", null, paydayData.getAz().getIncome() > 0 ? new ExtraData("+" + paydayData.getAz().getIncome(), Color.parseColor("#FFDB79"), Color.parseColor("#80582200")) : null, R.drawable.hud_element_payday_az_coins, "#A97700", "#FFDB79", false, null, 388, null));
        if (paydayData.getLaw().getCurrentValue() < paydayData.getLaw().getMaxValue() && paydayData.getLaw().getIncome() != 0) {
            String str4 = paydayData.getLaw().getCurrentValue() + "/" + paydayData.getLaw().getMaxValue();
            int i2 = R.drawable.hud_element_payday_laws;
            int currentValue = paydayData.getLaw().getCurrentValue();
            if (currentValue >= 0 && currentValue < 30) {
                str2 = "#980000";
            } else if (30 <= currentValue && currentValue < 60) {
                str2 = "#FF6200";
            } else {
                str2 = "#448D04";
            }
            String str5 = str2;
            int currentValue2 = paydayData.getLaw().getCurrentValue();
            if (currentValue2 >= 0 && currentValue2 < 30) {
                str3 = "#FF7676";
            } else if (30 <= currentValue2 && currentValue2 < 60) {
                str3 = "#FFCC00";
            } else {
                str3 = "#BCFF50";
            }
            arrayList2.add(new PaydayCardUi("Законопослушность", str4, formExtraCard(paydayData.getLaw().getIncome(), str), null, i2, str5, str3, false, null, 392, null));
        }
        if (paydayData.getOtherIncome().getIncome() > 0) {
            arrayList2.add(new PaydayCardUi("Другой доход", MoneyElementKt.toMoneyFormattedSpannable$default(paydayData.getOtherIncome().getIncome(), true, "+", null, 4, null), null, null, R.drawable.hud_element_payday_ic_other_income, "#8E7CFF", "#6A5BEA", false, null, 396, null));
        }
        return arrayList;
    }

    private final void bindCard(HudElementPaydayItemBinding hudElementPaydayItemBinding, PaydayCardUi paydayCardUi) {
        hudElementPaydayItemBinding.getRoot().setVisibility(0);
        TextView title = hudElementPaydayItemBinding.title;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        title.setVisibility(StringsKt.isBlank(paydayCardUi.getTitle()) ? 8 : 0);
        hudElementPaydayItemBinding.title.setText(paydayCardUi.getTitle());
        hudElementPaydayItemBinding.value.setText(paydayCardUi.getValue());
        TextView bigText = hudElementPaydayItemBinding.bigText;
        Intrinsics.checkNotNullExpressionValue(bigText, "bigText");
        bigText.setVisibility(paydayCardUi.getBigText().length() > 0 ? 0 : 8);
        LinearLayout main = hudElementPaydayItemBinding.main;
        Intrinsics.checkNotNullExpressionValue(main, "main");
        main.setVisibility(paydayCardUi.getBigText().length() == 0 ? 0 : 8);
        hudElementPaydayItemBinding.bigText.setText(paydayCardUi.getBigText());
        hudElementPaydayItemBinding.extraTitleCard.setVisibility(8);
        ExtraData extraTitle = paydayCardUi.getExtraTitle();
        if (extraTitle != null) {
            hudElementPaydayItemBinding.extraTitleCard.setVisibility(0);
            hudElementPaydayItemBinding.extraTitle.setText(extraTitle.getValue());
            hudElementPaydayItemBinding.extraTitleCard.setBackground(extraTitle.getCardColor());
            hudElementPaydayItemBinding.extraTitle.setTextColor(extraTitle.getTextColor());
        }
        hudElementPaydayItemBinding.extraValueCard.setVisibility(8);
        ExtraData extraValue = paydayCardUi.getExtraValue();
        if (extraValue != null) {
            hudElementPaydayItemBinding.extraValueCard.setVisibility(0);
            hudElementPaydayItemBinding.extraValue.setText(extraValue.getValue());
            hudElementPaydayItemBinding.extraValueCard.setBackground(extraValue.getCardColor());
            hudElementPaydayItemBinding.extraValue.setTextColor(extraValue.getTextColor());
        }
        hudElementPaydayItemBinding.image.setImageResource(paydayCardUi.getIconRes());
        CustomCardView redCard = hudElementPaydayItemBinding.redCard;
        Intrinsics.checkNotNullExpressionValue(redCard, "redCard");
        redCard.setVisibility(paydayCardUi.isRed() ? 0 : 8);
        int parseColor = Color.parseColor(paydayCardUi.getGradientStart());
        int parseColor2 = Color.parseColor(paydayCardUi.getGradientEnd());
        CustomCardView mainCard = hudElementPaydayItemBinding.mainCard;
        Intrinsics.checkNotNullExpressionValue(mainCard, "mainCard");
        CustomCardView.setBackground$default(mainCard, parseColor, parseColor2, null, null, 12, null);
        CustomCardView innerCard = hudElementPaydayItemBinding.innerCard;
        Intrinsics.checkNotNullExpressionValue(innerCard, "innerCard");
        CustomCardView.setBackground$default(innerCard, 0, parseColor2, null, null, 12, null);
        hudElementPaydayItemBinding.innerCard.setBackgroundAlpha(50);
    }

    private final ExtraData formExtraCard(int i, String str) {
        if (i == 0) {
            return null;
        }
        if (i > 0) {
            return new ExtraData("+" + i + str, Color.parseColor("#CCF053"), Color.parseColor("#1C5800"));
        }
        return new ExtraData(i + " " + str, Color.parseColor("#FFC3C3"), Color.parseColor("#AA0000"));
    }

    private final String formatTime(long j) {
        if (j > 3600) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j / 3600), Long.valueOf((j % 3600) / 60), Long.valueOf(j % 60)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        } else if (j <= 0) {
            return "00:00";
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            return format2;
        }
    }

    private final String formatTimer(long j) {
        long coerceAtLeast = RangesKt.coerceAtLeast(j, 0L);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(coerceAtLeast / 3600), Long.valueOf((coerceAtLeast % 3600) / 60), Long.valueOf(coerceAtLeast % 60)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public final void setInfo(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        PaydayData paydayData = (PaydayData) ((!MapperKt.isJsonValid(data) || Intrinsics.areEqual(data, AbstractJsonLexerKt.NULL) || Intrinsics.areEqual(data, "{}") || data.length() == 0) ? null : MapperKt.getGson().fromJson(data, (Class<Object>) PaydayData.class));
        if (paydayData == null) {
            stopClock();
            setVisibility("0");
            return;
        }
        this.currentData = paydayData;
        this.secondsPassed = 0L;
        setVisibility("1");
        startClock();
    }
}
