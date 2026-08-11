package com.arizonagames.feature.arizona.bank.pages;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.arizonagames.feature.arizona.bank.BankCurrencyHistoryInfo;
import com.arizonagames.feature.arizona.bank.BankCurrencyInfo;
import com.arizonagames.feature.arizona.bank.R;
import com.arizonagames.feature.arizona.bank.ui.BankClickAnimationKt;
import com.arizonagames.feature.arizona.bank.ui.BankUiFormatterKt;
import com.arizonagames.feature.arizona.bank.views.BankCurrencyChartView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BankCurrencyPageController.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u0000 I2\u00020\u0001:\u0001IB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0082\u0001\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020&022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020&022\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020&022\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020&02J \u00107\u001a\u00020&2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002002\u0006\u0010;\u001a\u000204H\u0002J\b\u0010<\u001a\u00020&H\u0002J \u0010=\u001a\u00020>2\u0006\u0010:\u001a\u0002002\u0006\u0010;\u001a\u0002042\u0006\u0010?\u001a\u000204H\u0002J\u0010\u0010@\u001a\u00020&2\u0006\u0010A\u001a\u000204H\u0002J\u001b\u0010B\u001a\u00020&*\u00020\t2\b\u0010A\u001a\u0004\u0018\u000104H\u0002¢\u0006\u0002\u0010CJ\u0018\u0010D\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010/\u001a\u000200H\u0002J(\u0010E\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020HH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankCurrencyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "card", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "title", "Landroid/widget/TextView;", "icon", "Landroid/widget/ImageView;", "priceBadge", FirebaseAnalytics.Param.PRICE, "availableCard", "available", "ownBalanceCard", "ownBalanceText", "buyButton", "buyPercent", "sellButton", "sellPercent", "info", "trendArrow", "percent", "chartContainer", "chart", "Lcom/arizonagames/feature/arizona/bank/views/BankCurrencyChartView;", "chartPointCard", "chartPointValue", "chartPointDate", "dayTab", "weekTab", "monthTab", "dayText", "weekText", "monthText", "bind", "", "spec", "Lcom/arizonagames/feature/arizona/bank/pages/BankCurrencySpec;", FirebaseAnalytics.Param.CURRENCY, "Lcom/arizonagames/feature/arizona/bank/BankCurrencyInfo;", "history", "Lcom/arizonagames/feature/arizona/bank/BankCurrencyHistoryInfo;", "ownBalance", "", "selectedRange", "Lcom/arizonagames/feature/arizona/bank/pages/CurrencyHistoryRange;", "onRangeSelected", "Lkotlin/Function1;", "onBuy", "", "onSell", "onInfo", "showChartTooltip", "selection", "Lcom/arizonagames/feature/arizona/bank/views/BankCurrencyChartView$PointSelection;", "range", "historySize", "hideChartTooltip", "buildChartPointDate", "", "pointIndex", "bindPercent", "value", "bindActionPercent", "(Landroid/widget/TextView;Ljava/lang/Integer;)V", "bindRangeTabs", "bindRangeTab", "text", "isSelected", "", "Companion", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankCurrencyViewHolder extends RecyclerView.ViewHolder {
    @Deprecated
    public static final float BLOCKED_ALPHA = 0.62f;
    private static final Companion Companion = new Companion(null);
    private final TextView available;
    private final CustomCardView availableCard;
    private final CustomCardView buyButton;
    private final TextView buyPercent;
    private final CustomCardView card;
    private final BankCurrencyChartView chart;
    private final View chartContainer;
    private final CustomCardView chartPointCard;
    private final TextView chartPointDate;
    private final TextView chartPointValue;
    private final CustomCardView dayTab;
    private final TextView dayText;
    private final ImageView icon;
    private final ImageView info;
    private final CustomCardView monthTab;
    private final TextView monthText;
    private final CustomCardView ownBalanceCard;
    private final TextView ownBalanceText;
    private final TextView percent;
    private final TextView price;
    private final CustomCardView priceBadge;
    private final CustomCardView sellButton;
    private final TextView sellPercent;
    private final TextView title;
    private final View trendArrow;
    private final CustomCardView weekTab;
    private final TextView weekText;

    /* compiled from: BankCurrencyPageController.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CurrencyHistoryRange.values().length];
            try {
                iArr[CurrencyHistoryRange.DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CurrencyHistoryRange.WEEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CurrencyHistoryRange.MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankCurrencyViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.bank_currency_card);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.card = (CustomCardView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.bank_currency_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.title = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.bank_currency_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.icon = (ImageView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.bank_currency_price_badge);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.priceBadge = (CustomCardView) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.bank_currency_price);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.price = (TextView) findViewById5;
        View findViewById6 = itemView.findViewById(R.id.bank_currency_available_card);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.availableCard = (CustomCardView) findViewById6;
        View findViewById7 = itemView.findViewById(R.id.bank_currency_available);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.available = (TextView) findViewById7;
        View findViewById8 = itemView.findViewById(R.id.bank_currency_own_balance_card);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        this.ownBalanceCard = (CustomCardView) findViewById8;
        View findViewById9 = itemView.findViewById(R.id.bank_currency_own_balance);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
        this.ownBalanceText = (TextView) findViewById9;
        View findViewById10 = itemView.findViewById(R.id.bank_currency_buy_button);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(...)");
        this.buyButton = (CustomCardView) findViewById10;
        View findViewById11 = itemView.findViewById(R.id.bank_currency_buy_percent);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(...)");
        this.buyPercent = (TextView) findViewById11;
        View findViewById12 = itemView.findViewById(R.id.bank_currency_sell_button);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(...)");
        this.sellButton = (CustomCardView) findViewById12;
        View findViewById13 = itemView.findViewById(R.id.bank_currency_sell_percent);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(...)");
        this.sellPercent = (TextView) findViewById13;
        View findViewById14 = itemView.findViewById(R.id.info);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(...)");
        this.info = (ImageView) findViewById14;
        View findViewById15 = itemView.findViewById(R.id.bank_currency_trend_arrow);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(...)");
        this.trendArrow = findViewById15;
        View findViewById16 = itemView.findViewById(R.id.bank_currency_percent);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "findViewById(...)");
        this.percent = (TextView) findViewById16;
        View findViewById17 = itemView.findViewById(R.id.bank_currency_chart_container);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "findViewById(...)");
        this.chartContainer = findViewById17;
        View findViewById18 = itemView.findViewById(R.id.bank_currency_chart);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "findViewById(...)");
        this.chart = (BankCurrencyChartView) findViewById18;
        View findViewById19 = itemView.findViewById(R.id.bank_currency_chart_point_card);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "findViewById(...)");
        this.chartPointCard = (CustomCardView) findViewById19;
        View findViewById20 = itemView.findViewById(R.id.bank_currency_chart_point_value);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "findViewById(...)");
        this.chartPointValue = (TextView) findViewById20;
        View findViewById21 = itemView.findViewById(R.id.bank_currency_chart_point_date);
        Intrinsics.checkNotNullExpressionValue(findViewById21, "findViewById(...)");
        this.chartPointDate = (TextView) findViewById21;
        View findViewById22 = itemView.findViewById(R.id.bank_currency_day_tab);
        Intrinsics.checkNotNullExpressionValue(findViewById22, "findViewById(...)");
        this.dayTab = (CustomCardView) findViewById22;
        View findViewById23 = itemView.findViewById(R.id.bank_currency_week_tab);
        Intrinsics.checkNotNullExpressionValue(findViewById23, "findViewById(...)");
        this.weekTab = (CustomCardView) findViewById23;
        View findViewById24 = itemView.findViewById(R.id.bank_currency_month_tab);
        Intrinsics.checkNotNullExpressionValue(findViewById24, "findViewById(...)");
        this.monthTab = (CustomCardView) findViewById24;
        View findViewById25 = itemView.findViewById(R.id.bank_currency_day_text);
        Intrinsics.checkNotNullExpressionValue(findViewById25, "findViewById(...)");
        this.dayText = (TextView) findViewById25;
        View findViewById26 = itemView.findViewById(R.id.bank_currency_week_text);
        Intrinsics.checkNotNullExpressionValue(findViewById26, "findViewById(...)");
        this.weekText = (TextView) findViewById26;
        View findViewById27 = itemView.findViewById(R.id.bank_currency_month_text);
        Intrinsics.checkNotNullExpressionValue(findViewById27, "findViewById(...)");
        this.monthText = (TextView) findViewById27;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006a, code lost:
        if (r25.getBlocked() == true) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bind(final BankCurrencySpec spec, BankCurrencyInfo bankCurrencyInfo, BankCurrencyHistoryInfo bankCurrencyHistoryInfo, long j, final CurrencyHistoryRange selectedRange, final Function1<? super CurrencyHistoryRange, Unit> onRangeSelected, final Function1<? super Integer, Unit> onBuy, final Function1<? super Integer, Unit> onSell, final Function1<? super Integer, Unit> onInfo) {
        List valuesFor;
        long longValue;
        List<Long> valuesFor2;
        String string;
        Intrinsics.checkNotNullParameter(spec, "spec");
        Intrinsics.checkNotNullParameter(selectedRange, "selectedRange");
        Intrinsics.checkNotNullParameter(onRangeSelected, "onRangeSelected");
        Intrinsics.checkNotNullParameter(onBuy, "onBuy");
        Intrinsics.checkNotNullParameter(onSell, "onSell");
        Intrinsics.checkNotNullParameter(onInfo, "onInfo");
        if (bankCurrencyInfo == null) {
            valuesFor = BankCurrencyPageControllerKt.valuesFor(bankCurrencyHistoryInfo, CurrencyHistoryRange.DAY);
            Long l = (Long) CollectionsKt.lastOrNull((List<? extends Object>) valuesFor);
            longValue = l != null ? l.longValue() : spec.getFallbackPrice();
        } else {
            longValue = bankCurrencyInfo.getCurrent();
        }
        long availableMoney = bankCurrencyInfo != null ? bankCurrencyInfo.getAvailableMoney() : spec.getFallbackAvailableMoney();
        int resolveCurrencyPercent = BankCurrencyPageControllerKt.resolveCurrencyPercent(bankCurrencyInfo, bankCurrencyHistoryInfo, spec.getFallbackPercent());
        final boolean z = bankCurrencyInfo != null;
        this.itemView.setAlpha(z ? 0.62f : 1.0f);
        this.title.setText(spec.getTitleResId());
        this.icon.setImageResource(spec.getIconResId());
        Integer iconTintColor = spec.getIconTintColor();
        ImageView imageView = this.icon;
        if (iconTintColor != null) {
            imageView.setColorFilter(iconTintColor.intValue());
        } else {
            imageView.clearColorFilter();
        }
        CustomCardView.setBackground$default(this.card, spec.getMainColor(), spec.getSecondColor(), Integer.valueOf(spec.getGradientAngle()), null, 8, null);
        this.card.setBackgroundAlpha(100);
        this.priceBadge.setBackground(spec.getPriceBadgeColor());
        this.priceBadge.setBackgroundAlpha(100);
        this.availableCard.setBackground(spec.getSoftPanelColor());
        this.availableCard.setBackgroundAlpha(spec.getSoftPanelAlpha());
        this.ownBalanceCard.setBackground(spec.getSoftPanelColor());
        this.ownBalanceCard.setBackgroundAlpha(spec.getSoftPanelAlpha());
        this.sellButton.setBackground(spec.getSoftPanelColor());
        this.sellButton.setBackgroundAlpha(34);
        long j2 = longValue;
        long j3 = availableMoney;
        CustomCardView.changeValidate$default(this.buyButton, !z, 0.0f, 2, null);
        CustomCardView.changeValidate$default(this.sellButton, !z, 0.0f, 2, null);
        this.available.setTextColor(spec.getAvailableTextColor());
        this.ownBalanceText.setTextColor(spec.getAvailableTextColor());
        valuesFor2 = BankCurrencyPageControllerKt.valuesFor(bankCurrencyHistoryInfo, selectedRange);
        List<Long> list = valuesFor2;
        if (list.isEmpty()) {
            list = spec.getFallbackHistory();
        }
        final List<Long> list2 = list;
        this.price.setText(BankUiFormatterKt.toBankDollarAmountText(j2));
        bindPercent(resolveCurrencyPercent);
        bindRangeTabs(spec, selectedRange);
        this.chart.setHistory(list2);
        hideChartTooltip();
        this.chart.setOnPointSelected(new Function1() { // from class: com.arizonagames.feature.arizona.bank.pages.BankCurrencyViewHolder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BankCurrencyViewHolder.bind$lambda$1(list2, this, selectedRange, (BankCurrencyChartView.PointSelection) obj);
            }
        });
        String bankCurrencyAvailabilityAmountText = BankUiFormatterKt.toBankCurrencyAvailabilityAmountText(j3);
        if (bankCurrencyAvailabilityAmountText == null) {
            string = this.itemView.getContext().getString(R.string.bank_currency_available_unlimited);
        } else {
            string = this.itemView.getContext().getString(R.string.bank_currency_available_format, bankCurrencyAvailabilityAmountText);
        }
        Intrinsics.checkNotNull(string);
        TextView textView = this.available;
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.setText(BankUiFormatterKt.buildCurrencyAvailabilityText(context, string, spec.getIconResId()));
        String string2 = this.itemView.getContext().getString(R.string.bank_currency_balance_format, BankUiFormatterKt.toBankPlainAmountText(j));
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        TextView textView2 = this.ownBalanceText;
        Context context2 = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        textView2.setText(BankUiFormatterKt.buildCurrencyAvailabilityText(context2, string2, spec.getIconResId()));
        bindActionPercent(this.buyPercent, bankCurrencyInfo != null ? bankCurrencyInfo.getPercent() : null);
        bindActionPercent(this.sellPercent, bankCurrencyInfo != null ? bankCurrencyInfo.getSellPercent() : null);
        this.dayTab.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.bank.pages.BankCurrencyViewHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function1.this.invoke(CurrencyHistoryRange.DAY);
            }
        });
        this.weekTab.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.bank.pages.BankCurrencyViewHolder$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function1.this.invoke(CurrencyHistoryRange.WEEK);
            }
        });
        this.monthTab.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.bank.pages.BankCurrencyViewHolder$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function1.this.invoke(CurrencyHistoryRange.MONTH);
            }
        });
        BankClickAnimationKt.setAnimatedClickListener(this.buyButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankCurrencyViewHolder$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BankCurrencyViewHolder.bind$lambda$5(z, onBuy, spec);
            }
        });
        BankClickAnimationKt.setAnimatedClickListener(this.sellButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankCurrencyViewHolder$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BankCurrencyViewHolder.bind$lambda$6(z, onSell, spec);
            }
        });
        BankClickAnimationKt.setAnimatedClickListener(this.info, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankCurrencyViewHolder$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BankCurrencyViewHolder.bind$lambda$7(Function1.this, spec);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit bind$lambda$1(List list, BankCurrencyViewHolder bankCurrencyViewHolder, CurrencyHistoryRange currencyHistoryRange, BankCurrencyChartView.PointSelection pointSelection) {
        if (pointSelection == null || list.isEmpty()) {
            bankCurrencyViewHolder.hideChartTooltip();
            return Unit.INSTANCE;
        }
        bankCurrencyViewHolder.showChartTooltip(pointSelection, currencyHistoryRange, list.size());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit bind$lambda$5(boolean z, Function1 function1, BankCurrencySpec bankCurrencySpec) {
        if (!z) {
            function1.invoke(Integer.valueOf(bankCurrencySpec.getId()));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit bind$lambda$6(boolean z, Function1 function1, BankCurrencySpec bankCurrencySpec) {
        if (!z) {
            function1.invoke(Integer.valueOf(bankCurrencySpec.getId()));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit bind$lambda$7(Function1 function1, BankCurrencySpec bankCurrencySpec) {
        function1.invoke(Integer.valueOf(bankCurrencySpec.getId()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showChartTooltip(final BankCurrencyChartView.PointSelection pointSelection, final CurrencyHistoryRange currencyHistoryRange, final int i) {
        float anchorX;
        this.chartPointValue.setText(BankUiFormatterKt.toBankDollarAmountText(pointSelection.getValue()));
        this.chartPointDate.setText(buildChartPointDate(currencyHistoryRange, i, pointSelection.getIndex()));
        int width = this.chartContainer.getWidth();
        int height = this.chartContainer.getHeight();
        if (width <= 0 || height <= 0) {
            this.chartContainer.post(new Runnable() { // from class: com.arizonagames.feature.arizona.bank.pages.BankCurrencyViewHolder$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    BankCurrencyViewHolder.this.showChartTooltip(pointSelection, currencyHistoryRange, i);
                }
            });
            return;
        }
        this.chartPointCard.measure(View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE));
        float measuredWidth = this.chartPointCard.getMeasuredWidth();
        float measuredHeight = this.chartPointCard.getMeasuredHeight();
        float f = width;
        float coerceAtLeast = RangesKt.coerceAtLeast(f - measuredWidth, 0.0f);
        float coerceAtLeast2 = RangesKt.coerceAtLeast(height - measuredHeight, 0.0f);
        float dimension = this.itemView.getResources().getDimension(ru.mrlargha.commonui.R.dimen._4sdp);
        if (pointSelection.getAnchorX() + dimension + measuredWidth <= f) {
            anchorX = pointSelection.getAnchorX() + dimension;
        } else {
            anchorX = (pointSelection.getAnchorX() - measuredWidth) - dimension;
        }
        this.chartPointCard.setTranslationX(RangesKt.coerceIn(anchorX, 0.0f, coerceAtLeast));
        this.chartPointCard.setTranslationY(RangesKt.coerceIn(pointSelection.getAnchorY() - (measuredHeight / 2.0f), 0.0f, coerceAtLeast2));
        this.chartPointCard.setVisibility(0);
    }

    private final void hideChartTooltip() {
        this.chart.clearSelection();
        this.chartPointCard.setVisibility(4);
    }

    private final String buildChartPointDate(CurrencyHistoryRange currencyHistoryRange, int i, int i2) {
        String str;
        if (i <= 0 || i2 < 0 || i2 >= i) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        int i3 = WhenMappings.$EnumSwitchMapping$0[currencyHistoryRange.ordinal()];
        if (i3 == 1) {
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            calendar.add(11, -1);
        } else if (i3 != 2 && i3 != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            calendar.set(11, 12);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            calendar.add(5, -1);
        }
        int i4 = (i - i2) - 1;
        int i5 = WhenMappings.$EnumSwitchMapping$0[currencyHistoryRange.ordinal()];
        if (i5 == 1) {
            calendar.add(11, -i4);
        } else if (i5 != 2 && i5 != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            calendar.add(5, -i4);
        }
        if (currencyHistoryRange == CurrencyHistoryRange.DAY) {
            str = "dd.MM.yyyy HH:00";
        } else {
            str = "dd.MM.yyyy";
        }
        String format = new SimpleDateFormat(str, Locale.getDefault()).format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    private final void bindPercent(int i) {
        int parseColor;
        boolean z = i != 0;
        this.trendArrow.setVisibility(z ? 0 : 8);
        this.percent.setVisibility(z ? 0 : 8);
        if (z) {
            this.trendArrow.setRotation(i < 0 ? 180.0f : 0.0f);
            TextView textView = this.percent;
            if (i < 0) {
                parseColor = Color.parseColor("#FFB3A6");
            } else {
                parseColor = Color.parseColor("#B7FF00");
            }
            textView.setTextColor(parseColor);
            this.percent.setText(this.itemView.getContext().getString(R.string.bank_currency_percent_value, Integer.valueOf(i)));
        }
    }

    private final void bindActionPercent(TextView textView, Integer num) {
        boolean z = (num == null || num.intValue() == 0) ? false : true;
        textView.setVisibility(z ? 0 : 8);
        String str = null;
        if (num != null) {
            num.intValue();
            if (!z) {
                num = null;
            }
            if (num != null) {
                str = textView.getContext().getString(R.string.bank_currency_percent_value, Integer.valueOf(num.intValue()));
            }
        }
        if (str == null) {
            str = "";
        }
        textView.setText(str);
    }

    private final void bindRangeTabs(BankCurrencySpec bankCurrencySpec, CurrencyHistoryRange currencyHistoryRange) {
        bindRangeTab(bankCurrencySpec, this.dayTab, this.dayText, currencyHistoryRange == CurrencyHistoryRange.DAY);
        bindRangeTab(bankCurrencySpec, this.weekTab, this.weekText, currencyHistoryRange == CurrencyHistoryRange.WEEK);
        bindRangeTab(bankCurrencySpec, this.monthTab, this.monthText, currencyHistoryRange == CurrencyHistoryRange.MONTH);
    }

    private final void bindRangeTab(BankCurrencySpec bankCurrencySpec, CustomCardView customCardView, TextView textView, boolean z) {
        if (z) {
            customCardView.setBackground(-1);
            customCardView.setBackgroundAlpha(100);
            textView.setTextColor(Color.parseColor("#15182A"));
            return;
        }
        customCardView.setBackground(bankCurrencySpec.getSoftPanelColor());
        customCardView.setBackgroundAlpha(RangesKt.coerceAtMost(bankCurrencySpec.getSoftPanelAlpha() + 8, 100));
        textView.setTextColor(bankCurrencySpec.getUnselectedTabTextColor());
    }

    /* compiled from: BankCurrencyPageController.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankCurrencyViewHolder$Companion;", "", "<init>", "()V", "BLOCKED_ALPHA", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
