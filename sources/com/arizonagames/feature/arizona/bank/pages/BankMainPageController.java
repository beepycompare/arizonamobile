package com.arizonagames.feature.arizona.bank.pages;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.arizonagames.feature.arizona.bank.BankAccountInfo;
import com.arizonagames.feature.arizona.bank.BankMainSection;
import com.arizonagames.feature.arizona.bank.BankOrganizationInfo;
import com.arizonagames.feature.arizona.bank.BankPage;
import com.arizonagames.feature.arizona.bank.BankRetirementInfo;
import com.arizonagames.feature.arizona.bank.BankScreenPayload;
import com.arizonagames.feature.arizona.bank.BankSendSubId;
import com.arizonagames.feature.arizona.bank.BankTaxInfo;
import com.arizonagames.feature.arizona.bank.BankTaxesInfo;
import com.arizonagames.feature.arizona.bank.adapters.BankAccountTabsAdapter;
import com.arizonagames.feature.arizona.bank.adapters.BankTaxesAdapter;
import com.arizonagames.feature.arizona.bank.databinding.BankMainPageBinding;
import com.arizonagames.feature.arizona.bank.navigation.BankMainSectionNavigator;
import com.arizonagames.feature.arizona.bank.ui.BankClickAnimationKt;
import com.arizonagames.feature.arizona.bank.ui.BankOrganizationLogoMapper;
import com.arizonagames.feature.arizona.bank.ui.BankRecyclerTabIndicator;
import com.arizonagames.feature.arizona.bank.ui.BankUiFormatterKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: BankMainPageController.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 ?2\u00020\u0001:\u0001?B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u001eH\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\u000e\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020\nH\u0002J\b\u0010'\u001a\u00020\nH\u0002J\u0010\u0010(\u001a\u00020\n2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\bH\u0002J\u0010\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\bH\u0002J\b\u0010-\u001a\u00020\nH\u0002J\u0010\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\bH\u0002J\b\u00100\u001a\u00020\nH\u0002J\u0012\u00101\u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\n\u00104\u001a\u0004\u0018\u000103H\u0002J\u0016\u00105\u001a\u00020\b2\f\u00106\u001a\b\u0012\u0004\u0012\u00020307H\u0002J\u001a\u00108\u001a\u00020\n*\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020;07H\u0002J\u0017\u0010<\u001a\u0004\u0018\u00010\b2\u0006\u0010=\u001a\u00020;H\u0002¢\u0006\u0002\u0010>R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankMainPageController;", "Lcom/arizonagames/feature/arizona/bank/pages/BankPageController;", "targetActivity", "Landroid/app/Activity;", "binding", "Lcom/arizonagames/feature/arizona/bank/databinding/BankMainPageBinding;", "onAction", "Lkotlin/Function2;", "", "Lcom/arizonagames/feature/arizona/bank/BankSendSubId;", "", "<init>", "(Landroid/app/Activity;Lcom/arizonagames/feature/arizona/bank/databinding/BankMainPageBinding;Lkotlin/jvm/functions/Function2;)V", "page", "Lcom/arizonagames/feature/arizona/bank/BankPage;", "getPage", "()Lcom/arizonagames/feature/arizona/bank/BankPage;", "root", "Landroid/widget/FrameLayout;", "getRoot", "()Landroid/widget/FrameLayout;", "accountTabsIndicator", "Lcom/arizonagames/feature/arizona/bank/ui/BankRecyclerTabIndicator;", "accountTabsAdapter", "Lcom/arizonagames/feature/arizona/bank/adapters/BankAccountTabsAdapter;", "taxesAdapter", "Lcom/arizonagames/feature/arizona/bank/adapters/BankTaxesAdapter;", "sectionNavigator", "Lcom/arizonagames/feature/arizona/bank/navigation/BankMainSectionNavigator;", "currentPayload", "Lcom/arizonagames/feature/arizona/bank/BankScreenPayload;", "selectedAccountId", "bind", "payload", "resetState", "setMainSection", "section", "Lcom/arizonagames/feature/arizona/bank/BankMainSection;", "setupLists", "bindClicks", "onMainSectionClicked", "onAccountSelected", "accountId", "scrollAccountTabs", "direction", "updateAccountTabsScrollArrows", "onTaxSelected", "taxId", "onPayAllTaxesSelected", "updateSelectedAccountState", "account", "Lcom/arizonagames/feature/arizona/bank/BankAccountInfo;", "getSelectedAccount", "resolveSelectedAccountId", "accounts", "", "bindOrganizationBackground", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "rawColors", "", "parseOrganizationColor", "rawColor", "(Ljava/lang/String;)Ljava/lang/Integer;", "Companion", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankMainPageController implements BankPageController {
    @Deprecated
    public static final int ORGANIZATION_GRADIENT_ANGLE = 0;
    private final BankAccountTabsAdapter accountTabsAdapter;
    private final BankRecyclerTabIndicator accountTabsIndicator;
    private final BankMainPageBinding binding;
    private BankScreenPayload currentPayload;
    private final Function2<Integer, BankSendSubId, Unit> onAction;
    private final BankPage page;
    private final FrameLayout root;
    private final BankMainSectionNavigator sectionNavigator;
    private int selectedAccountId;
    private final Activity targetActivity;
    private final BankTaxesAdapter taxesAdapter;
    private static final Companion Companion = new Companion(null);
    private static final Regex HEX_COLOR_REGEX = new Regex("[0-9A-Fa-f]{6}([0-9A-Fa-f]{2})?");
    private static final int DEFAULT_ORGANIZATION_BACKGROUND = Color.parseColor("#26FFFFFF");

    /* JADX WARN: Multi-variable type inference failed */
    public BankMainPageController(Activity targetActivity, BankMainPageBinding binding, Function2<? super Integer, ? super BankSendSubId, Unit> onAction) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        this.targetActivity = targetActivity;
        this.binding = binding;
        this.onAction = onAction;
        this.page = BankPage.MAIN;
        FrameLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.root = root;
        RecyclerView bankMainAccountsTabsContainer = binding.bankMainAccountsTabsContainer;
        Intrinsics.checkNotNullExpressionValue(bankMainAccountsTabsContainer, "bankMainAccountsTabsContainer");
        CustomCardView bankMainAccountsTabIndicator = binding.bankMainAccountsTabIndicator;
        Intrinsics.checkNotNullExpressionValue(bankMainAccountsTabIndicator, "bankMainAccountsTabIndicator");
        BankRecyclerTabIndicator bankRecyclerTabIndicator = new BankRecyclerTabIndicator(bankMainAccountsTabsContainer, bankMainAccountsTabIndicator);
        this.accountTabsIndicator = bankRecyclerTabIndicator;
        this.accountTabsAdapter = new BankAccountTabsAdapter(new BankMainPageController$accountTabsAdapter$1(this), new BankMainPageController$accountTabsAdapter$2(bankRecyclerTabIndicator));
        this.taxesAdapter = new BankTaxesAdapter(new BankMainPageController$taxesAdapter$1(this), new BankMainPageController$taxesAdapter$2(this));
        BankMainSectionNavigator bankMainSectionNavigator = new BankMainSectionNavigator(binding);
        this.sectionNavigator = bankMainSectionNavigator;
        this.currentPayload = new BankScreenPayload(null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
        setupLists();
        bindClicks();
        bankMainSectionNavigator.select(BankMainSection.ACCOUNTS);
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
    public FrameLayout getRoot() {
        return this.root;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01f4  */
    @Override // com.arizonagames.feature.arizona.bank.pages.BankPageController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bind(BankScreenPayload payload) {
        List<BankTaxInfo> list;
        Integer id;
        Intrinsics.checkNotNullParameter(payload, "payload");
        BankMainPageBinding bankMainPageBinding = this.binding;
        this.currentPayload = payload;
        this.selectedAccountId = resolveSelectedAccountId(payload.getBankAccounts());
        this.accountTabsAdapter.submitList(CollectionsKt.sortedWith(payload.getBankAccounts(), new Comparator() { // from class: com.arizonagames.feature.arizona.bank.pages.BankMainPageController$bind$lambda$0$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((BankAccountInfo) t).getId()), Integer.valueOf(((BankAccountInfo) t2).getId()));
            }
        }), this.selectedAccountId);
        bankMainPageBinding.bankMainAccountsTabsContainer.post(new Runnable() { // from class: com.arizonagames.feature.arizona.bank.pages.BankMainPageController$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                BankMainPageController.bind$lambda$0$updateAccountTabsScrollArrows(BankMainPageController.this);
            }
        });
        updateSelectedAccountState(getSelectedAccount());
        BankOrganizationInfo organization = payload.getOrganization();
        if (organization == null || !organization.getEnable() || ((id = organization.getId()) != null ? id.intValue() == 0 || id.intValue() == 21 : StringsKt.isBlank(organization.getName()))) {
            organization = null;
        }
        bankMainPageBinding.bankMainOrganizationCard.setVisibility(organization == null ? 8 : 0);
        if (organization != null) {
            Integer resolve = BankOrganizationLogoMapper.INSTANCE.resolve(organization.getId());
            bankMainPageBinding.bankMainOrganizationLogo.setVisibility(resolve == null ? 8 : 0);
            bankMainPageBinding.bankMainOrganizationName.setVisibility(resolve == null ? 0 : 8);
            if (resolve != null) {
                ImageView bankMainOrganizationLogo = bankMainPageBinding.bankMainOrganizationLogo;
                Intrinsics.checkNotNullExpressionValue(bankMainOrganizationLogo, "bankMainOrganizationLogo");
                bankMainOrganizationLogo.setImageResource(resolve.intValue());
            }
            bankMainPageBinding.bankMainOrganizationName.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, organization.getName(), 0.0f, null, 3, null));
            CustomCardView bankMainOrganizationCard = bankMainPageBinding.bankMainOrganizationCard;
            Intrinsics.checkNotNullExpressionValue(bankMainOrganizationCard, "bankMainOrganizationCard");
            bindOrganizationBackground(bankMainOrganizationCard, organization.getColors());
            bankMainPageBinding.tvCost.setText(BankUiFormatterKt.toBankMoneyText(organization.getMoney(), this.targetActivity));
            bankMainPageBinding.bankMainOrganizationWithdrawCommission.setText(organization.getPercents().getWithdraw() + "%");
            CustomCardView bankMainOrganizationWithdrawButton = bankMainPageBinding.bankMainOrganizationWithdrawButton;
            Intrinsics.checkNotNullExpressionValue(bankMainOrganizationWithdrawButton, "bankMainOrganizationWithdrawButton");
            CustomCardView.changeValidate$default(bankMainOrganizationWithdrawButton, StringsKt.isBlank(organization.getWithdrawError()), 0.0f, 2, null);
            CustomCardView bankMainOrganizationTopUpButton = bankMainPageBinding.bankMainOrganizationTopUpButton;
            Intrinsics.checkNotNullExpressionValue(bankMainOrganizationTopUpButton, "bankMainOrganizationTopUpButton");
            CustomCardView.changeValidate$default(bankMainOrganizationTopUpButton, StringsKt.isBlank(organization.getDepositError()), 0.0f, 2, null);
        }
        BankRetirementInfo retirement = payload.getRetirement();
        bankMainPageBinding.bankMainPensionCard.setVisibility(retirement == null ? 8 : 0);
        boolean z = true;
        if (retirement != null) {
            bankMainPageBinding.bankMainPensionLockedState.setVisibility(retirement.getStatus() ? 8 : 0);
            bankMainPageBinding.bankMainPensionOpenState.setVisibility(retirement.getStatus() ? 0 : 8);
            bankMainPageBinding.bankMainPensionBalance.setText(BankUiFormatterKt.toBankMoneyText(retirement.getMoney(), this.targetActivity));
            bankMainPageBinding.bankMainPensionBuyButtonText.setText(BankUiFormatterKt.buildOpenRetirementText(this.targetActivity, retirement.getBuyCost()));
            CustomCardView bankMainPensionWithdrawButton = bankMainPageBinding.bankMainPensionWithdrawButton;
            Intrinsics.checkNotNullExpressionValue(bankMainPensionWithdrawButton, "bankMainPensionWithdrawButton");
            CustomCardView.changeValidate$default(bankMainPensionWithdrawButton, retirement.getStatus(), 0.0f, 2, null);
            CustomCardView bankMainPensionBuyButton = bankMainPageBinding.bankMainPensionBuyButton;
            Intrinsics.checkNotNullExpressionValue(bankMainPensionBuyButton, "bankMainPensionBuyButton");
            CustomCardView.changeValidate$default(bankMainPensionBuyButton, !retirement.getStatus(), 0.0f, 2, null);
        }
        BankTaxesInfo taxes = payload.getTaxes();
        if (taxes != null) {
            if (taxes.getTotalCost() <= 0) {
                List<BankTaxInfo> list2 = taxes.getList();
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    for (BankTaxInfo bankTaxInfo : list2) {
                        if (bankTaxInfo.getWarning()) {
                            break;
                        }
                    }
                }
            }
            bankMainPageBinding.bankMainPageTaxesTabWarning.setVisibility(z ? 0 : 8);
            BankTaxesAdapter bankTaxesAdapter = this.taxesAdapter;
            BankTaxesInfo taxes2 = payload.getTaxes();
            list = taxes2 != null ? taxes2.getList() : null;
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            BankTaxesInfo taxes3 = payload.getTaxes();
            bankTaxesAdapter.submitList(list, taxes3 != null ? taxes3.getTotalCost() : 0L);
        }
        z = false;
        bankMainPageBinding.bankMainPageTaxesTabWarning.setVisibility(z ? 0 : 8);
        BankTaxesAdapter bankTaxesAdapter2 = this.taxesAdapter;
        BankTaxesInfo taxes22 = payload.getTaxes();
        if (taxes22 != null) {
        }
        if (list == null) {
        }
        BankTaxesInfo taxes32 = payload.getTaxes();
        bankTaxesAdapter2.submitList(list, taxes32 != null ? taxes32.getTotalCost() : 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$updateAccountTabsScrollArrows(BankMainPageController bankMainPageController) {
        Intrinsics.checkNotNullParameter(bankMainPageController, "<this>");
        bankMainPageController.updateAccountTabsScrollArrows();
    }

    @Override // com.arizonagames.feature.arizona.bank.pages.BankPageController
    public void resetState() {
        this.currentPayload = new BankScreenPayload(null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
        this.selectedAccountId = 0;
        this.sectionNavigator.select(BankMainSection.ACCOUNTS);
        this.accountTabsAdapter.submitList(CollectionsKt.emptyList(), this.selectedAccountId);
        this.binding.bankMainAccountsTabsContainer.post(new Runnable() { // from class: com.arizonagames.feature.arizona.bank.pages.BankMainPageController$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                BankMainPageController.resetState$updateAccountTabsScrollArrows(BankMainPageController.this);
            }
        });
        this.taxesAdapter.submitList(CollectionsKt.emptyList(), 0L);
        updateSelectedAccountState(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetState$updateAccountTabsScrollArrows(BankMainPageController bankMainPageController) {
        Intrinsics.checkNotNullParameter(bankMainPageController, "<this>");
        bankMainPageController.updateAccountTabsScrollArrows();
    }

    public final void setMainSection(BankMainSection section) {
        Intrinsics.checkNotNullParameter(section, "section");
        this.sectionNavigator.select(section);
    }

    private final void setupLists() {
        BankMainPageBinding bankMainPageBinding = this.binding;
        RecyclerView recyclerView = bankMainPageBinding.bankMainAccountsTabsContainer;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.targetActivity, 0, false));
        recyclerView.setAdapter(this.accountTabsAdapter);
        recyclerView.setItemAnimator(null);
        recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.arizonagames.feature.arizona.bank.pages.BankMainPageController$$ExternalSyntheticLambda7
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                BankMainPageController.this.updateAccountTabsScrollArrows();
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.arizonagames.feature.arizona.bank.pages.BankMainPageController$setupLists$1$1$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i, int i2) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                BankMainPageController.this.updateAccountTabsScrollArrows();
            }
        });
        bankMainPageBinding.bankMainPageTaxesContent.setAdapter(this.taxesAdapter);
        bankMainPageBinding.bankMainPageTaxesContent.setItemAnimator(null);
        RecyclerView.LayoutManager layoutManager = bankMainPageBinding.bankMainPageTaxesContent.getLayoutManager();
        GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
        if (gridLayoutManager != null) {
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.arizonagames.feature.arizona.bank.pages.BankMainPageController$setupLists$1$2
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i) {
                    BankTaxesAdapter bankTaxesAdapter;
                    bankTaxesAdapter = BankMainPageController.this.taxesAdapter;
                    return bankTaxesAdapter.getSpanSize(i);
                }
            });
        }
    }

    private final void bindClicks() {
        BankMainPageBinding bankMainPageBinding = this.binding;
        bankMainPageBinding.bankMainPageAccountTab.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.bank.pages.BankMainPageController$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankMainPageController.bindClicks$lambda$0$0(BankMainPageController.this, view);
            }
        });
        bankMainPageBinding.bankMainPageTaxesTab.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.bank.pages.BankMainPageController$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankMainPageController.bindClicks$lambda$0$1(BankMainPageController.this, view);
            }
        });
        ImageView bankMainAccountsScrollLeft = bankMainPageBinding.bankMainAccountsScrollLeft;
        Intrinsics.checkNotNullExpressionValue(bankMainAccountsScrollLeft, "bankMainAccountsScrollLeft");
        BankClickAnimationKt.setAnimatedClickListener(bankMainAccountsScrollLeft, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankMainPageController$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$2;
                bindClicks$lambda$0$2 = BankMainPageController.bindClicks$lambda$0$2(BankMainPageController.this);
                return bindClicks$lambda$0$2;
            }
        });
        ImageView bankMainAccountsScrollRight = bankMainPageBinding.bankMainAccountsScrollRight;
        Intrinsics.checkNotNullExpressionValue(bankMainAccountsScrollRight, "bankMainAccountsScrollRight");
        BankClickAnimationKt.setAnimatedClickListener(bankMainAccountsScrollRight, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankMainPageController$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$3;
                bindClicks$lambda$0$3 = BankMainPageController.bindClicks$lambda$0$3(BankMainPageController.this);
                return bindClicks$lambda$0$3;
            }
        });
        CustomCardView bankMainAccountsWithdrawButton = bankMainPageBinding.bankMainAccountsWithdrawButton;
        Intrinsics.checkNotNullExpressionValue(bankMainAccountsWithdrawButton, "bankMainAccountsWithdrawButton");
        BankClickAnimationKt.setAnimatedClickListener(bankMainAccountsWithdrawButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankMainPageController$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$4;
                bindClicks$lambda$0$4 = BankMainPageController.bindClicks$lambda$0$4(BankMainPageController.this);
                return bindClicks$lambda$0$4;
            }
        });
        CustomCardView bankMainAccountsTopUpButton = bankMainPageBinding.bankMainAccountsTopUpButton;
        Intrinsics.checkNotNullExpressionValue(bankMainAccountsTopUpButton, "bankMainAccountsTopUpButton");
        BankClickAnimationKt.setAnimatedClickListener(bankMainAccountsTopUpButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankMainPageController$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$5;
                bindClicks$lambda$0$5 = BankMainPageController.bindClicks$lambda$0$5(BankMainPageController.this);
                return bindClicks$lambda$0$5;
            }
        });
        CustomCardView bankMainAccountsTransferButton = bankMainPageBinding.bankMainAccountsTransferButton;
        Intrinsics.checkNotNullExpressionValue(bankMainAccountsTransferButton, "bankMainAccountsTransferButton");
        BankClickAnimationKt.setAnimatedClickListener(bankMainAccountsTransferButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankMainPageController$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$6;
                bindClicks$lambda$0$6 = BankMainPageController.bindClicks$lambda$0$6(BankMainPageController.this);
                return bindClicks$lambda$0$6;
            }
        });
        CustomCardView bankMainAccountsHistoryButton = bankMainPageBinding.bankMainAccountsHistoryButton;
        Intrinsics.checkNotNullExpressionValue(bankMainAccountsHistoryButton, "bankMainAccountsHistoryButton");
        BankClickAnimationKt.setAnimatedClickListener(bankMainAccountsHistoryButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankMainPageController$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$7;
                bindClicks$lambda$0$7 = BankMainPageController.bindClicks$lambda$0$7(BankMainPageController.this);
                return bindClicks$lambda$0$7;
            }
        });
        CustomCardView bankMainOrganizationWithdrawButton = bankMainPageBinding.bankMainOrganizationWithdrawButton;
        Intrinsics.checkNotNullExpressionValue(bankMainOrganizationWithdrawButton, "bankMainOrganizationWithdrawButton");
        BankClickAnimationKt.setAnimatedClickListener(bankMainOrganizationWithdrawButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankMainPageController$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$8;
                bindClicks$lambda$0$8 = BankMainPageController.bindClicks$lambda$0$8(BankMainPageController.this);
                return bindClicks$lambda$0$8;
            }
        });
        CustomCardView bankMainOrganizationTopUpButton = bankMainPageBinding.bankMainOrganizationTopUpButton;
        Intrinsics.checkNotNullExpressionValue(bankMainOrganizationTopUpButton, "bankMainOrganizationTopUpButton");
        BankClickAnimationKt.setAnimatedClickListener(bankMainOrganizationTopUpButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankMainPageController$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$9;
                bindClicks$lambda$0$9 = BankMainPageController.bindClicks$lambda$0$9(BankMainPageController.this);
                return bindClicks$lambda$0$9;
            }
        });
        CustomCardView bankMainOrganizationHistoryButton = bankMainPageBinding.bankMainOrganizationHistoryButton;
        Intrinsics.checkNotNullExpressionValue(bankMainOrganizationHistoryButton, "bankMainOrganizationHistoryButton");
        BankClickAnimationKt.setAnimatedClickListener(bankMainOrganizationHistoryButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankMainPageController$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$10;
                bindClicks$lambda$0$10 = BankMainPageController.bindClicks$lambda$0$10(BankMainPageController.this);
                return bindClicks$lambda$0$10;
            }
        });
        CustomCardView bankMainPensionBuyButton = bankMainPageBinding.bankMainPensionBuyButton;
        Intrinsics.checkNotNullExpressionValue(bankMainPensionBuyButton, "bankMainPensionBuyButton");
        BankClickAnimationKt.setAnimatedClickListener(bankMainPensionBuyButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankMainPageController$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$11;
                bindClicks$lambda$0$11 = BankMainPageController.bindClicks$lambda$0$11(BankMainPageController.this);
                return bindClicks$lambda$0$11;
            }
        });
        CustomCardView bankMainPensionWithdrawButton = bankMainPageBinding.bankMainPensionWithdrawButton;
        Intrinsics.checkNotNullExpressionValue(bankMainPensionWithdrawButton, "bankMainPensionWithdrawButton");
        BankClickAnimationKt.setAnimatedClickListener(bankMainPensionWithdrawButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankMainPageController$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$12;
                bindClicks$lambda$0$12 = BankMainPageController.bindClicks$lambda$0$12(BankMainPageController.this);
                return bindClicks$lambda$0$12;
            }
        });
        TextView bankMainPensionInfoButton = bankMainPageBinding.bankMainPensionInfoButton;
        Intrinsics.checkNotNullExpressionValue(bankMainPensionInfoButton, "bankMainPensionInfoButton");
        BankClickAnimationKt.setAnimatedClickListener(bankMainPensionInfoButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankMainPageController$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$13;
                bindClicks$lambda$0$13 = BankMainPageController.bindClicks$lambda$0$13(BankMainPageController.this);
                return bindClicks$lambda$0$13;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindClicks$lambda$0$0(BankMainPageController bankMainPageController, View view) {
        bankMainPageController.onMainSectionClicked(BankMainSection.ACCOUNTS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindClicks$lambda$0$1(BankMainPageController bankMainPageController, View view) {
        bankMainPageController.onMainSectionClicked(BankMainSection.TAXES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$2(BankMainPageController bankMainPageController) {
        bankMainPageController.scrollAccountTabs(-1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$3(BankMainPageController bankMainPageController) {
        bankMainPageController.scrollAccountTabs(1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$4(BankMainPageController bankMainPageController) {
        BankAccountInfo selectedAccount = bankMainPageController.getSelectedAccount();
        if (selectedAccount != null) {
            bankMainPageController.onAction.invoke(Integer.valueOf(selectedAccount.getId()), BankSendSubId.ACCOUNT_WITHDRAW);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$5(BankMainPageController bankMainPageController) {
        BankAccountInfo selectedAccount = bankMainPageController.getSelectedAccount();
        if (selectedAccount != null) {
            bankMainPageController.onAction.invoke(Integer.valueOf(selectedAccount.getId()), BankSendSubId.ACCOUNT_DEPOSIT);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$6(BankMainPageController bankMainPageController) {
        BankAccountInfo selectedAccount = bankMainPageController.getSelectedAccount();
        if (selectedAccount != null) {
            bankMainPageController.onAction.invoke(Integer.valueOf(selectedAccount.getId()), BankSendSubId.ACCOUNT_TRANSFER);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$7(BankMainPageController bankMainPageController) {
        BankAccountInfo selectedAccount = bankMainPageController.getSelectedAccount();
        if (selectedAccount != null) {
            bankMainPageController.onAction.invoke(Integer.valueOf(selectedAccount.getId()), BankSendSubId.ACCOUNT_HISTORY);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$8(BankMainPageController bankMainPageController) {
        bankMainPageController.onAction.invoke(0, BankSendSubId.ORGANIZATION_WITHDRAW);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$9(BankMainPageController bankMainPageController) {
        bankMainPageController.onAction.invoke(0, BankSendSubId.ORGANIZATION_DEPOSIT);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$10(BankMainPageController bankMainPageController) {
        bankMainPageController.onAction.invoke(0, BankSendSubId.ORGANIZATION_HISTORY);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$11(BankMainPageController bankMainPageController) {
        bankMainPageController.onAction.invoke(0, BankSendSubId.RETIREMENT_BUY);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$12(BankMainPageController bankMainPageController) {
        bankMainPageController.onAction.invoke(0, BankSendSubId.RETIREMENT_WITHDRAW);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$13(BankMainPageController bankMainPageController) {
        bankMainPageController.onAction.invoke(0, BankSendSubId.RETIREMENT_INFO);
        return Unit.INSTANCE;
    }

    private final void onMainSectionClicked(BankMainSection bankMainSection) {
        this.sectionNavigator.select(bankMainSection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAccountSelected(int i) {
        this.selectedAccountId = i;
        this.accountTabsAdapter.setSelectedAccountId(i);
        updateSelectedAccountState(getSelectedAccount());
    }

    private final void scrollAccountTabs(int i) {
        Integer num;
        int findFirstVisibleItemPosition;
        if (i == 0 || this.accountTabsAdapter.getItemCount() == 0) {
            return;
        }
        RecyclerView bankMainAccountsTabsContainer = this.binding.bankMainAccountsTabsContainer;
        Intrinsics.checkNotNullExpressionValue(bankMainAccountsTabsContainer, "bankMainAccountsTabsContainer");
        RecyclerView.LayoutManager layoutManager = bankMainAccountsTabsContainer.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return;
        }
        if (i > 0) {
            Integer valueOf = Integer.valueOf(linearLayoutManager.findLastCompletelyVisibleItemPosition());
            num = valueOf.intValue() != -1 ? valueOf : null;
            if (num != null) {
                findFirstVisibleItemPosition = num.intValue();
            } else {
                findFirstVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            }
        } else {
            Integer valueOf2 = Integer.valueOf(linearLayoutManager.findFirstCompletelyVisibleItemPosition());
            num = valueOf2.intValue() != -1 ? valueOf2 : null;
            if (num != null) {
                findFirstVisibleItemPosition = num.intValue();
            } else {
                findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            }
        }
        if (findFirstVisibleItemPosition == -1) {
            return;
        }
        bankMainAccountsTabsContainer.smoothScrollToPosition(RangesKt.coerceIn(findFirstVisibleItemPosition + i, 0, this.accountTabsAdapter.getItemCount() - 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAccountTabsScrollArrows() {
        BankMainPageBinding bankMainPageBinding = this.binding;
        bankMainPageBinding.bankMainAccountsScrollLeft.setVisibility(bankMainPageBinding.bankMainAccountsTabsContainer.canScrollHorizontally(-1) ? 0 : 8);
        bankMainPageBinding.bankMainAccountsScrollRight.setVisibility(bankMainPageBinding.bankMainAccountsTabsContainer.canScrollHorizontally(1) ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTaxSelected(int i) {
        this.onAction.invoke(Integer.valueOf(i), BankSendSubId.TAX_PAY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPayAllTaxesSelected() {
        this.onAction.invoke(0, BankSendSubId.TAX_PAY_ALL);
    }

    private final void updateSelectedAccountState(BankAccountInfo bankAccountInfo) {
        String str;
        BankMainPageBinding bankMainPageBinding = this.binding;
        bankMainPageBinding.bankMainAccountsCard.setVisibility(bankAccountInfo == null ? 8 : 0);
        if (bankAccountInfo == null) {
            return;
        }
        boolean isOpened = bankAccountInfo.isOpened();
        TextView textView = bankMainPageBinding.bankMainAccountsBalanceBillions;
        if (isOpened) {
            str = BankUiFormatterKt.toBankMoneyText(bankAccountInfo.getMoney(), this.targetActivity);
        }
        textView.setText(str);
        bankMainPageBinding.bankMainAccountsWithdrawCommission.setText(bankAccountInfo.getPercents().getWithdraw() + "%");
        bankMainPageBinding.bankMainAccountsTransferCommission.setText(bankAccountInfo.getPercents().getTransfer() + "%");
        CustomCardView bankMainAccountsWithdrawButton = bankMainPageBinding.bankMainAccountsWithdrawButton;
        Intrinsics.checkNotNullExpressionValue(bankMainAccountsWithdrawButton, "bankMainAccountsWithdrawButton");
        CustomCardView.changeValidate$default(bankMainAccountsWithdrawButton, isOpened, 0.0f, 2, null);
        CustomCardView bankMainAccountsTopUpButton = bankMainPageBinding.bankMainAccountsTopUpButton;
        Intrinsics.checkNotNullExpressionValue(bankMainAccountsTopUpButton, "bankMainAccountsTopUpButton");
        CustomCardView.changeValidate$default(bankMainAccountsTopUpButton, isOpened, 0.0f, 2, null);
        CustomCardView bankMainAccountsTransferButton = bankMainPageBinding.bankMainAccountsTransferButton;
        Intrinsics.checkNotNullExpressionValue(bankMainAccountsTransferButton, "bankMainAccountsTransferButton");
        CustomCardView.changeValidate$default(bankMainAccountsTransferButton, isOpened, 0.0f, 2, null);
        CustomCardView bankMainAccountsHistoryButton = bankMainPageBinding.bankMainAccountsHistoryButton;
        Intrinsics.checkNotNullExpressionValue(bankMainAccountsHistoryButton, "bankMainAccountsHistoryButton");
        CustomCardView.changeValidate$default(bankMainAccountsHistoryButton, isOpened, 0.0f, 2, null);
    }

    private final BankAccountInfo getSelectedAccount() {
        Object obj;
        Iterator<T> it = this.currentPayload.getBankAccounts().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((BankAccountInfo) obj).getId() == this.selectedAccountId) {
                break;
            }
        }
        return (BankAccountInfo) obj;
    }

    private final int resolveSelectedAccountId(List<BankAccountInfo> list) {
        Object obj;
        if (list.isEmpty()) {
            return 0;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((BankAccountInfo) obj).getId() == this.selectedAccountId) {
                break;
            }
        }
        BankAccountInfo bankAccountInfo = (BankAccountInfo) obj;
        return bankAccountInfo != null ? bankAccountInfo.getId() : ((BankAccountInfo) CollectionsKt.first((List<? extends Object>) list)).getId();
    }

    private final void bindOrganizationBackground(CustomCardView customCardView, List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            Integer parseOrganizationColor = parseOrganizationColor(str);
            if (parseOrganizationColor != null) {
                arrayList.add(parseOrganizationColor);
            }
        }
        int[] intArray = CollectionsKt.toIntArray(arrayList);
        int length = intArray.length;
        if (length == 0) {
            customCardView.setBackground(DEFAULT_ORGANIZATION_BACKGROUND);
        } else if (length == 1) {
            customCardView.setBackground(ArraysKt.first(intArray));
        } else {
            CustomCardView.setBackground$default(customCardView, intArray, 0, null, 4, null);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(8:3|(1:5)(2:25|(1:27))|6|7|8|(3:10|(3:12|(1:16)|17)|18)|19|20)|28|6|7|8|(0)|19|20) */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x006e, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006f, code lost:
        r0 = kotlin.Result.Companion;
        r5 = kotlin.Result.m9920constructorimpl(kotlin.ResultKt.createFailure(r5));
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Integer parseOrganizationColor(String str) {
        String str2;
        Throwable m9923exceptionOrNullimpl;
        String removeSuffix = StringsKt.removeSuffix(StringsKt.removePrefix(StringsKt.trim((CharSequence) str).toString(), (CharSequence) "{"), (CharSequence) "}");
        Object obj = null;
        if (!StringsKt.startsWith$default(removeSuffix, "#", false, 2, (Object) null)) {
            if (StringsKt.startsWith(removeSuffix, "0x", true)) {
                str2 = "#" + StringsKt.drop(removeSuffix, 2);
            } else {
                if (HEX_COLOR_REGEX.matches(removeSuffix)) {
                    str2 = "#" + removeSuffix;
                }
            }
            Result.Companion companion = Result.Companion;
            BankMainPageController bankMainPageController = this;
            Object obj2 = Result.m9920constructorimpl(Integer.valueOf(Color.parseColor(str2)));
            m9923exceptionOrNullimpl = Result.m9923exceptionOrNullimpl(obj2);
            Object obj3 = obj2;
            if (m9923exceptionOrNullimpl != null) {
                Long longOrNull = StringsKt.toLongOrNull(removeSuffix);
                if (longOrNull != null) {
                    long longValue = longOrNull.longValue();
                    int i = (int) longValue;
                    if (0 <= longValue && longValue < 16777216) {
                        i |= -16777216;
                    }
                    obj = Integer.valueOf(i);
                }
                obj3 = obj;
            }
            return (Integer) obj3;
        }
        str2 = removeSuffix;
        Result.Companion companion2 = Result.Companion;
        BankMainPageController bankMainPageController2 = this;
        Object obj22 = Result.m9920constructorimpl(Integer.valueOf(Color.parseColor(str2)));
        m9923exceptionOrNullimpl = Result.m9923exceptionOrNullimpl(obj22);
        Object obj32 = obj22;
        if (m9923exceptionOrNullimpl != null) {
        }
        return (Integer) obj32;
    }

    /* compiled from: BankMainPageController.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankMainPageController$Companion;", "", "<init>", "()V", "HEX_COLOR_REGEX", "Lkotlin/text/Regex;", "getHEX_COLOR_REGEX", "()Lkotlin/text/Regex;", "DEFAULT_ORGANIZATION_BACKGROUND", "", "getDEFAULT_ORGANIZATION_BACKGROUND", "()I", "ORGANIZATION_GRADIENT_ANGLE", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Regex getHEX_COLOR_REGEX() {
            return BankMainPageController.HEX_COLOR_REGEX;
        }

        public final int getDEFAULT_ORGANIZATION_BACKGROUND() {
            return BankMainPageController.DEFAULT_ORGANIZATION_BACKGROUND;
        }
    }
}
