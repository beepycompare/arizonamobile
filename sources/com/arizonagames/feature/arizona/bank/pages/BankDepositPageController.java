package com.arizonagames.feature.arizona.bank.pages;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.arizonagames.feature.arizona.bank.BankDepositDisabledTime;
import com.arizonagames.feature.arizona.bank.BankDepositInfo;
import com.arizonagames.feature.arizona.bank.BankIncomeInfo;
import com.arizonagames.feature.arizona.bank.BankIncomeRangeInfo;
import com.arizonagames.feature.arizona.bank.BankPage;
import com.arizonagames.feature.arizona.bank.BankScreenPayload;
import com.arizonagames.feature.arizona.bank.BankSendSubId;
import com.arizonagames.feature.arizona.bank.databinding.BankDepositPageBinding;
import com.arizonagames.feature.arizona.bank.ui.BankClickAnimationKt;
import com.arizonagames.feature.arizona.bank.ui.BankUiFormatterKt;
import com.arizonagames.feature.arizona.bank.views.BankIncomeChartView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: BankDepositPageController.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001FB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\nH\u0016J\u0018\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020 H\u0002J\u0012\u0010)\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010+\u001a\u00020\nH\u0002J\u0010\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u001aH\u0002J\b\u0010.\u001a\u00020\nH\u0002J\b\u0010/\u001a\u00020\nH\u0002J \u00100\u001a\u00020\n2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002J\u0010\u00107\u001a\u00020\n2\u0006\u0010(\u001a\u00020 H\u0002J\b\u00108\u001a\u00020\nH\u0002J\u0012\u00109\u001a\u00020:2\b\u0010*\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010;\u001a\u00020\nH\u0002J\u0018\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\bH\u0002J\b\u0010@\u001a\u00020\nH\u0002J \u0010A\u001a\u00020B2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\b2\u0006\u0010C\u001a\u00020\bH\u0002J\f\u0010D\u001a\u000206*\u00020 H\u0002J\f\u0010E\u001a\u00020 *\u00020 H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankDepositPageController;", "Lcom/arizonagames/feature/arizona/bank/pages/BankPageController;", "targetActivity", "Landroid/app/Activity;", "binding", "Lcom/arizonagames/feature/arizona/bank/databinding/BankDepositPageBinding;", "onAction", "Lkotlin/Function2;", "", "Lcom/arizonagames/feature/arizona/bank/BankSendSubId;", "", "<init>", "(Landroid/app/Activity;Lcom/arizonagames/feature/arizona/bank/databinding/BankDepositPageBinding;Lkotlin/jvm/functions/Function2;)V", "page", "Lcom/arizonagames/feature/arizona/bank/BankPage;", "getPage", "()Lcom/arizonagames/feature/arizona/bank/BankPage;", "root", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "disabledTimeJob", "Lkotlinx/coroutines/Job;", "selectedRange", "Lcom/arizonagames/feature/arizona/bank/pages/BankDepositPageController$DepositIncomeRange;", "currentDeposit", "Lcom/arizonagames/feature/arizona/bank/BankDepositInfo;", "currentIncome", "Lcom/arizonagames/feature/arizona/bank/BankIncomeInfo;", "serverDisabledTime", "Lcom/arizonagames/feature/arizona/bank/BankDepositDisabledTime;", "displayedDisabledTime", "bind", "payload", "Lcom/arizonagames/feature/arizona/bank/BankScreenPayload;", "resetState", "renderDepositSummary", "deposit", "disabledTime", "renderIncome", "income", "setupRangeTabs", "selectRange", "range", "setupActionClicks", "updateRangeTabs", "updateRangeTab", "card", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "textView", "Landroid/widget/TextView;", "isSelected", "", "syncDisabledTime", "restartDisabledTimeTicker", "currentRangeIncome", "Lcom/arizonagames/feature/arizona/bank/BankIncomeRangeInfo;", "setupChartTooltip", "showChartTooltip", "selection", "Lcom/arizonagames/feature/arizona/bank/views/BankIncomeChartView$PointSelection;", "historySize", "hideChartTooltip", "buildChartPointDate", "", "pointIndex", "hasAnyActiveTimer", "tick", "DepositIncomeRange", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankDepositPageController implements BankPageController {
    private final BankDepositPageBinding binding;
    private BankDepositInfo currentDeposit;
    private BankIncomeInfo currentIncome;
    private Job disabledTimeJob;
    private BankDepositDisabledTime displayedDisabledTime;
    private final Function2<Integer, BankSendSubId, Unit> onAction;
    private final BankPage page;
    private final View root;
    private final CoroutineScope scope;
    private DepositIncomeRange selectedRange;
    private BankDepositDisabledTime serverDisabledTime;
    private final Activity targetActivity;

    /* compiled from: BankDepositPageController.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DepositIncomeRange.values().length];
            try {
                iArr[DepositIncomeRange.DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DepositIncomeRange.WEEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DepositIncomeRange.MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BankDepositPageController(Activity targetActivity, BankDepositPageBinding binding, Function2<? super Integer, ? super BankSendSubId, Unit> onAction) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        this.targetActivity = targetActivity;
        this.binding = binding;
        this.onAction = onAction;
        this.page = BankPage.DEPOSIT;
        NestedScrollView root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.root = root;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        this.selectedRange = DepositIncomeRange.DAY;
        this.serverDisabledTime = new BankDepositDisabledTime(0, 0, 0, 7, null);
        this.displayedDisabledTime = new BankDepositDisabledTime(0, 0, 0, 7, null);
        setupRangeTabs();
        setupActionClicks();
        setupChartTooltip();
        binding.getRoot().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.arizonagames.feature.arizona.bank.pages.BankDepositPageController.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                Job job = BankDepositPageController.this.disabledTimeJob;
                if (job != null) {
                    Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                CoroutineScopeKt.cancel$default(BankDepositPageController.this.scope, null, 1, null);
            }
        });
    }

    @Override // com.arizonagames.feature.arizona.bank.pages.BankPageController
    public /* bridge */ IBackendNotifier getNotifier() {
        return super.getNotifier();
    }

    @Override // com.arizonagames.feature.arizona.bank.pages.BankPageController
    public /* bridge */ void setVisible(boolean z, boolean z2, int i) {
        super.setVisible(z, z2, i);
    }

    @Override // com.arizonagames.feature.arizona.bank.pages.BankPageController
    public BankPage getPage() {
        return this.page;
    }

    @Override // com.arizonagames.feature.arizona.bank.pages.BankPageController
    public View getRoot() {
        return this.root;
    }

    @Override // com.arizonagames.feature.arizona.bank.pages.BankPageController
    public void bind(BankScreenPayload payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        BankDepositPageBinding bankDepositPageBinding = this.binding;
        BankDepositInfo bankDeposit = payload.getBankDeposit();
        this.currentDeposit = bankDeposit;
        this.currentIncome = payload.getIncome();
        boolean z = bankDeposit != null;
        bankDepositPageBinding.bankDepositSummaryCard.setVisibility(z ? 0 : 8);
        bankDepositPageBinding.bankDepositProfitabilityCard.setVisibility(z ? 0 : 8);
        bankDepositPageBinding.bankDepositLevelButton.setVisibility(z ? 0 : 8);
        if (bankDeposit != null) {
            syncDisabledTime(bankDeposit.getDisabledTime());
            renderDepositSummary(bankDeposit, this.displayedDisabledTime);
        } else {
            this.serverDisabledTime = new BankDepositDisabledTime(0, 0, 0, 7, null);
            this.displayedDisabledTime = new BankDepositDisabledTime(0, 0, 0, 7, null);
            Job job = this.disabledTimeJob;
            if (job != null) {
                Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
        }
        renderIncome(payload.getIncome());
    }

    @Override // com.arizonagames.feature.arizona.bank.pages.BankPageController
    public void resetState() {
        this.selectedRange = DepositIncomeRange.DAY;
        this.currentDeposit = null;
        this.currentIncome = null;
        this.serverDisabledTime = new BankDepositDisabledTime(0, 0, 0, 7, null);
        this.displayedDisabledTime = new BankDepositDisabledTime(0, 0, 0, 7, null);
        Job job = this.disabledTimeJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        hideChartTooltip();
        bind(new BankScreenPayload(null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderDepositSummary(BankDepositInfo bankDepositInfo, BankDepositDisabledTime bankDepositDisabledTime) {
        BankDepositPageBinding bankDepositPageBinding = this.binding;
        bankDepositPageBinding.bankDepositBalance.setText(BankUiFormatterKt.toBankMoneyText(bankDepositInfo.getMoney(), this.targetActivity));
        bankDepositPageBinding.bankDepositDescription.setText(bankDepositInfo.getDescription());
        bankDepositPageBinding.bankDepositLevelValue.setText(String.valueOf(bankDepositInfo.getLevel()));
        bankDepositPageBinding.bankDepositWithdrawBadge.setText(bankDepositInfo.getPercents().getWithdraw() + "%");
        bankDepositPageBinding.bankDepositConditionsText.setText(BankUiFormatterKt.buildDepositStatusText(bankDepositInfo, bankDepositDisabledTime));
        CustomCardView bankDepositWithdrawButton = bankDepositPageBinding.bankDepositWithdrawButton;
        Intrinsics.checkNotNullExpressionValue(bankDepositWithdrawButton, "bankDepositWithdrawButton");
        boolean z = false;
        CustomCardView.changeValidate$default(bankDepositWithdrawButton, bankDepositDisabledTime.getWithdraw() <= 0, 0.0f, 2, null);
        CustomCardView bankDepositTopUpButton = bankDepositPageBinding.bankDepositTopUpButton;
        Intrinsics.checkNotNullExpressionValue(bankDepositTopUpButton, "bankDepositTopUpButton");
        CustomCardView.changeValidate$default(bankDepositTopUpButton, bankDepositDisabledTime.getDeposit() <= 0, 0.0f, 2, null);
        CustomCardView bankDepositHistoryButton = bankDepositPageBinding.bankDepositHistoryButton;
        Intrinsics.checkNotNullExpressionValue(bankDepositHistoryButton, "bankDepositHistoryButton");
        CustomCardView.changeValidate$default(bankDepositHistoryButton, true, 0.0f, 2, null);
        CustomCardView bankDepositUpgradeButton = bankDepositPageBinding.bankDepositUpgradeButton;
        Intrinsics.checkNotNullExpressionValue(bankDepositUpgradeButton, "bankDepositUpgradeButton");
        CustomCardView.changeValidate$default(bankDepositUpgradeButton, bankDepositDisabledTime.getUpgrade() <= 0 && bankDepositInfo.getLevel() < bankDepositInfo.getMaxLevel(), 0.0f, 2, null);
        CustomCardView bankDepositLevelButton = bankDepositPageBinding.bankDepositLevelButton;
        Intrinsics.checkNotNullExpressionValue(bankDepositLevelButton, "bankDepositLevelButton");
        if (bankDepositDisabledTime.getUpgrade() <= 0 && bankDepositInfo.getLevel() < bankDepositInfo.getMaxLevel()) {
            z = true;
        }
        CustomCardView.changeValidate$default(bankDepositLevelButton, z, 0.0f, 2, null);
        bankDepositPageBinding.bankDepositWithdrawText.setText("СНЯТЬ");
        bankDepositPageBinding.bankDepositTopUpText.setText("ПОПОЛНИТЬ");
        bankDepositPageBinding.bankDepositUpgradeText.setText(bankDepositInfo.getLevel() >= bankDepositInfo.getMaxLevel() ? "МАКС." : "УЛУЧШИТЬ");
    }

    private final void renderIncome(BankIncomeInfo bankIncomeInfo) {
        BankDepositPageBinding bankDepositPageBinding = this.binding;
        updateRangeTabs();
        BankIncomeRangeInfo currentRangeIncome = currentRangeIncome(bankIncomeInfo);
        bankDepositPageBinding.bankDepositIncomeValue.setText(BankUiFormatterKt.toBankMoneyText(currentRangeIncome.getMoney(), this.targetActivity));
        bankDepositPageBinding.bankDepositPaydayIncome.setText(BankUiFormatterKt.buildPaydayIncomeText(this.targetActivity, bankIncomeInfo != null ? bankIncomeInfo.getPayDayIncome() : 0L));
        bankDepositPageBinding.bankDepositProfitChart.setHistory(currentRangeIncome.getHistory());
        hideChartTooltip();
    }

    private final void setupRangeTabs() {
        BankDepositPageBinding bankDepositPageBinding = this.binding;
        bankDepositPageBinding.bankDepositRangeDayTab.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.bank.pages.BankDepositPageController$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankDepositPageController.setupRangeTabs$lambda$0$0(BankDepositPageController.this, view);
            }
        });
        bankDepositPageBinding.bankDepositRangeWeekTab.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.bank.pages.BankDepositPageController$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankDepositPageController.setupRangeTabs$lambda$0$1(BankDepositPageController.this, view);
            }
        });
        bankDepositPageBinding.bankDepositRangeMonthTab.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.bank.pages.BankDepositPageController$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankDepositPageController.setupRangeTabs$lambda$0$2(BankDepositPageController.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupRangeTabs$lambda$0$0(BankDepositPageController bankDepositPageController, View view) {
        bankDepositPageController.selectRange(DepositIncomeRange.DAY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupRangeTabs$lambda$0$1(BankDepositPageController bankDepositPageController, View view) {
        bankDepositPageController.selectRange(DepositIncomeRange.WEEK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupRangeTabs$lambda$0$2(BankDepositPageController bankDepositPageController, View view) {
        bankDepositPageController.selectRange(DepositIncomeRange.MONTH);
    }

    private final void selectRange(DepositIncomeRange depositIncomeRange) {
        if (this.selectedRange == depositIncomeRange) {
            return;
        }
        this.selectedRange = depositIncomeRange;
        renderIncome(this.currentIncome);
    }

    private final void setupActionClicks() {
        BankDepositPageBinding bankDepositPageBinding = this.binding;
        CustomCardView bankDepositWithdrawButton = bankDepositPageBinding.bankDepositWithdrawButton;
        Intrinsics.checkNotNullExpressionValue(bankDepositWithdrawButton, "bankDepositWithdrawButton");
        BankClickAnimationKt.setAnimatedClickListener(bankDepositWithdrawButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankDepositPageController$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = BankDepositPageController.setupActionClicks$lambda$0$0(BankDepositPageController.this);
                return unit;
            }
        });
        CustomCardView bankDepositTopUpButton = bankDepositPageBinding.bankDepositTopUpButton;
        Intrinsics.checkNotNullExpressionValue(bankDepositTopUpButton, "bankDepositTopUpButton");
        BankClickAnimationKt.setAnimatedClickListener(bankDepositTopUpButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankDepositPageController$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = BankDepositPageController.setupActionClicks$lambda$0$1(BankDepositPageController.this);
                return unit;
            }
        });
        CustomCardView bankDepositHistoryButton = bankDepositPageBinding.bankDepositHistoryButton;
        Intrinsics.checkNotNullExpressionValue(bankDepositHistoryButton, "bankDepositHistoryButton");
        BankClickAnimationKt.setAnimatedClickListener(bankDepositHistoryButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankDepositPageController$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = BankDepositPageController.setupActionClicks$lambda$0$2(BankDepositPageController.this);
                return unit;
            }
        });
        CustomCardView bankDepositUpgradeButton = bankDepositPageBinding.bankDepositUpgradeButton;
        Intrinsics.checkNotNullExpressionValue(bankDepositUpgradeButton, "bankDepositUpgradeButton");
        BankClickAnimationKt.setAnimatedClickListener(bankDepositUpgradeButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankDepositPageController$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = BankDepositPageController.setupActionClicks$lambda$0$3(BankDepositPageController.this);
                return unit;
            }
        });
        CustomCardView bankDepositLevelButton = bankDepositPageBinding.bankDepositLevelButton;
        Intrinsics.checkNotNullExpressionValue(bankDepositLevelButton, "bankDepositLevelButton");
        BankClickAnimationKt.setAnimatedClickListener(bankDepositLevelButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankDepositPageController$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = BankDepositPageController.setupActionClicks$lambda$0$4(BankDepositPageController.this);
                return unit;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupActionClicks$lambda$0$0(BankDepositPageController bankDepositPageController) {
        bankDepositPageController.onAction.invoke(0, BankSendSubId.DEPOSIT_WITHDRAW);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupActionClicks$lambda$0$1(BankDepositPageController bankDepositPageController) {
        bankDepositPageController.onAction.invoke(0, BankSendSubId.DEPOSIT_DEPOSIT);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupActionClicks$lambda$0$2(BankDepositPageController bankDepositPageController) {
        bankDepositPageController.onAction.invoke(0, BankSendSubId.DEPOSIT_HISTORY);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupActionClicks$lambda$0$3(BankDepositPageController bankDepositPageController) {
        bankDepositPageController.onAction.invoke(0, BankSendSubId.DEPOSIT_UPGRADE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupActionClicks$lambda$0$4(BankDepositPageController bankDepositPageController) {
        bankDepositPageController.onAction.invoke(0, BankSendSubId.DEPOSIT_UPGRADE);
        return Unit.INSTANCE;
    }

    private final void updateRangeTabs() {
        BankDepositPageBinding bankDepositPageBinding = this.binding;
        CustomCardView bankDepositRangeDayTab = bankDepositPageBinding.bankDepositRangeDayTab;
        Intrinsics.checkNotNullExpressionValue(bankDepositRangeDayTab, "bankDepositRangeDayTab");
        TextView bankDepositRangeDayText = bankDepositPageBinding.bankDepositRangeDayText;
        Intrinsics.checkNotNullExpressionValue(bankDepositRangeDayText, "bankDepositRangeDayText");
        updateRangeTab(bankDepositRangeDayTab, bankDepositRangeDayText, this.selectedRange == DepositIncomeRange.DAY);
        CustomCardView bankDepositRangeWeekTab = bankDepositPageBinding.bankDepositRangeWeekTab;
        Intrinsics.checkNotNullExpressionValue(bankDepositRangeWeekTab, "bankDepositRangeWeekTab");
        TextView bankDepositRangeWeekText = bankDepositPageBinding.bankDepositRangeWeekText;
        Intrinsics.checkNotNullExpressionValue(bankDepositRangeWeekText, "bankDepositRangeWeekText");
        updateRangeTab(bankDepositRangeWeekTab, bankDepositRangeWeekText, this.selectedRange == DepositIncomeRange.WEEK);
        CustomCardView bankDepositRangeMonthTab = bankDepositPageBinding.bankDepositRangeMonthTab;
        Intrinsics.checkNotNullExpressionValue(bankDepositRangeMonthTab, "bankDepositRangeMonthTab");
        TextView bankDepositRangeMonthText = bankDepositPageBinding.bankDepositRangeMonthText;
        Intrinsics.checkNotNullExpressionValue(bankDepositRangeMonthText, "bankDepositRangeMonthText");
        updateRangeTab(bankDepositRangeMonthTab, bankDepositRangeMonthText, this.selectedRange == DepositIncomeRange.MONTH);
    }

    private final void updateRangeTab(CustomCardView customCardView, TextView textView, boolean z) {
        customCardView.setBackground(z ? -1 : Color.parseColor("#33000000"));
        customCardView.setBackgroundAlpha(100);
        textView.setTextColor(Color.parseColor(z ? "#161A2A" : "#A9B3D4"));
    }

    private final void syncDisabledTime(BankDepositDisabledTime bankDepositDisabledTime) {
        if (Intrinsics.areEqual(bankDepositDisabledTime, this.serverDisabledTime)) {
            return;
        }
        this.serverDisabledTime = bankDepositDisabledTime;
        this.displayedDisabledTime = bankDepositDisabledTime;
        restartDisabledTimeTicker();
    }

    private final void restartDisabledTimeTicker() {
        Job launch$default;
        Job job = this.disabledTimeJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (hasAnyActiveTimer(this.displayedDisabledTime)) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new BankDepositPageController$restartDisabledTimeTicker$1(this, null), 3, null);
            this.disabledTimeJob = launch$default;
        }
    }

    private final BankIncomeRangeInfo currentRangeIncome(BankIncomeInfo bankIncomeInfo) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.selectedRange.ordinal()];
        BankIncomeRangeInfo bankIncomeRangeInfo = null;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (bankIncomeInfo != null) {
                    bankIncomeRangeInfo = bankIncomeInfo.getMonth();
                }
            } else if (bankIncomeInfo != null) {
                bankIncomeRangeInfo = bankIncomeInfo.getWeek();
            }
        } else if (bankIncomeInfo != null) {
            bankIncomeRangeInfo = bankIncomeInfo.getDay();
        }
        return bankIncomeRangeInfo == null ? new BankIncomeRangeInfo(0L, null, 3, null) : bankIncomeRangeInfo;
    }

    private final void setupChartTooltip() {
        hideChartTooltip();
        this.binding.bankDepositProfitChart.setOnPointSelected(new Function1() { // from class: com.arizonagames.feature.arizona.bank.pages.BankDepositPageController$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BankDepositPageController.setupChartTooltip$lambda$0(BankDepositPageController.this, (BankIncomeChartView.PointSelection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit setupChartTooltip$lambda$0(BankDepositPageController bankDepositPageController, BankIncomeChartView.PointSelection pointSelection) {
        if (pointSelection == null) {
            bankDepositPageController.hideChartTooltip();
            return Unit.INSTANCE;
        }
        BankIncomeRangeInfo currentRangeIncome = bankDepositPageController.currentRangeIncome(bankDepositPageController.currentIncome);
        if (currentRangeIncome.getHistory().isEmpty()) {
            bankDepositPageController.hideChartTooltip();
            return Unit.INSTANCE;
        }
        bankDepositPageController.showChartTooltip(pointSelection, currentRangeIncome.getHistory().size());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showChartTooltip(final BankIncomeChartView.PointSelection pointSelection, final int i) {
        float anchorX;
        BankDepositPageBinding bankDepositPageBinding = this.binding;
        bankDepositPageBinding.bankDepositChartPointValue.setText(BankUiFormatterKt.toBankMoneyText(pointSelection.getValue(), this.targetActivity));
        bankDepositPageBinding.bankDepositChartPointDate.setText(buildChartPointDate(this.selectedRange, i, pointSelection.getIndex()));
        int width = bankDepositPageBinding.bankDepositChartContainer.getWidth();
        int height = bankDepositPageBinding.bankDepositChartContainer.getHeight();
        if (width <= 0 || height <= 0) {
            bankDepositPageBinding.bankDepositChartContainer.post(new Runnable() { // from class: com.arizonagames.feature.arizona.bank.pages.BankDepositPageController$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    BankDepositPageController.this.showChartTooltip(pointSelection, i);
                }
            });
            return;
        }
        bankDepositPageBinding.bankDepositChartPointCard.measure(View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE));
        float measuredWidth = bankDepositPageBinding.bankDepositChartPointCard.getMeasuredWidth();
        float measuredHeight = bankDepositPageBinding.bankDepositChartPointCard.getMeasuredHeight();
        float f = width;
        float coerceAtLeast = RangesKt.coerceAtLeast(f - measuredWidth, 0.0f);
        float coerceAtLeast2 = RangesKt.coerceAtLeast(height - measuredHeight, 0.0f);
        float dimension = this.targetActivity.getResources().getDimension(R.dimen._4sdp);
        if (pointSelection.getAnchorX() + dimension + measuredWidth <= f) {
            anchorX = pointSelection.getAnchorX() + dimension;
        } else {
            anchorX = (pointSelection.getAnchorX() - measuredWidth) - dimension;
        }
        bankDepositPageBinding.bankDepositChartPointCard.setTranslationX(RangesKt.coerceIn(anchorX, 0.0f, coerceAtLeast));
        bankDepositPageBinding.bankDepositChartPointCard.setTranslationY(RangesKt.coerceIn(pointSelection.getAnchorY() - (measuredHeight / 2.0f), 0.0f, coerceAtLeast2));
        bankDepositPageBinding.bankDepositChartPointCard.setVisibility(0);
    }

    private final void hideChartTooltip() {
        BankDepositPageBinding bankDepositPageBinding = this.binding;
        bankDepositPageBinding.bankDepositProfitChart.clearSelection();
        bankDepositPageBinding.bankDepositChartPointCard.setVisibility(4);
    }

    private final String buildChartPointDate(DepositIncomeRange depositIncomeRange, int i, int i2) {
        String str;
        if (i <= 0 || i2 < 0 || i2 >= i) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        int i3 = WhenMappings.$EnumSwitchMapping$0[depositIncomeRange.ordinal()];
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
        int i5 = WhenMappings.$EnumSwitchMapping$0[depositIncomeRange.ordinal()];
        if (i5 == 1) {
            calendar.add(11, -i4);
        } else if (i5 != 2 && i5 != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            calendar.add(5, -i4);
        }
        if (depositIncomeRange == DepositIncomeRange.DAY) {
            str = "dd.MM.yyyy HH:00";
        } else {
            str = "dd.MM.yyyy";
        }
        String format = new SimpleDateFormat(str, Locale.getDefault()).format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasAnyActiveTimer(BankDepositDisabledTime bankDepositDisabledTime) {
        return bankDepositDisabledTime.getWithdraw() > 0 || bankDepositDisabledTime.getDeposit() > 0 || bankDepositDisabledTime.getUpgrade() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BankDepositDisabledTime tick(BankDepositDisabledTime bankDepositDisabledTime) {
        return bankDepositDisabledTime.copy(RangesKt.coerceAtLeast(bankDepositDisabledTime.getWithdraw() - 1, 0), RangesKt.coerceAtLeast(bankDepositDisabledTime.getDeposit() - 1, 0), RangesKt.coerceAtLeast(bankDepositDisabledTime.getUpgrade() - 1, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: BankDepositPageController.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankDepositPageController$DepositIncomeRange;", "", "<init>", "(Ljava/lang/String;I)V", "DAY", "WEEK", "MONTH", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DepositIncomeRange {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DepositIncomeRange[] $VALUES;
        public static final DepositIncomeRange DAY = new DepositIncomeRange("DAY", 0);
        public static final DepositIncomeRange WEEK = new DepositIncomeRange("WEEK", 1);
        public static final DepositIncomeRange MONTH = new DepositIncomeRange("MONTH", 2);

        private static final /* synthetic */ DepositIncomeRange[] $values() {
            return new DepositIncomeRange[]{DAY, WEEK, MONTH};
        }

        public static EnumEntries<DepositIncomeRange> getEntries() {
            return $ENTRIES;
        }

        public static DepositIncomeRange valueOf(String str) {
            return (DepositIncomeRange) Enum.valueOf(DepositIncomeRange.class, str);
        }

        public static DepositIncomeRange[] values() {
            return (DepositIncomeRange[]) $VALUES.clone();
        }

        private DepositIncomeRange(String str, int i) {
        }

        static {
            DepositIncomeRange[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }
}
