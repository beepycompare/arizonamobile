package com.arizonagames.feature.arizona.bank.navigation;

import android.graphics.Color;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.arizonagames.feature.arizona.bank.BankMainSection;
import com.arizonagames.feature.arizona.bank.databinding.BankMainPageBinding;
import com.arizonagames.feature.arizona.bank.ui.BankContentTransitionKt;
import com.arizonagames.feature.arizona.bank.ui.BankSlidingTabIndicator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: BankMainSectionNavigator.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007J \u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/navigation/BankMainSectionNavigator;", "", "binding", "Lcom/arizonagames/feature/arizona/bank/databinding/BankMainPageBinding;", "<init>", "(Lcom/arizonagames/feature/arizona/bank/databinding/BankMainPageBinding;)V", "value", "Lcom/arizonagames/feature/arizona/bank/BankMainSection;", "currentSection", "getCurrentSection", "()Lcom/arizonagames/feature/arizona/bank/BankMainSection;", "sectionIndicator", "Lcom/arizonagames/feature/arizona/bank/ui/BankSlidingTabIndicator;", "hasSelectedSection", "", "select", "", "section", "updateTab", "card", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "textView", "Landroid/widget/TextView;", "isSelected", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankMainSectionNavigator {
    private final BankMainPageBinding binding;
    private BankMainSection currentSection;
    private boolean hasSelectedSection;
    private final BankSlidingTabIndicator sectionIndicator;

    public BankMainSectionNavigator(BankMainPageBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        this.currentSection = BankMainSection.ACCOUNTS;
        CustomCardView bankMainPageSectionIndicator = binding.bankMainPageSectionIndicator;
        Intrinsics.checkNotNullExpressionValue(bankMainPageSectionIndicator, "bankMainPageSectionIndicator");
        this.sectionIndicator = new BankSlidingTabIndicator(bankMainPageSectionIndicator);
    }

    public final BankMainSection getCurrentSection() {
        return this.currentSection;
    }

    public final void select(BankMainSection section) {
        Intrinsics.checkNotNullParameter(section, "section");
        BankMainSection bankMainSection = this.currentSection;
        boolean z = this.hasSelectedSection && bankMainSection != section;
        int i = section.getBackendValue() >= bankMainSection.getBackendValue() ? 1 : -1;
        this.currentSection = section;
        boolean z2 = section == BankMainSection.ACCOUNTS;
        CustomCardView bankMainPageAccountTab = this.binding.bankMainPageAccountTab;
        Intrinsics.checkNotNullExpressionValue(bankMainPageAccountTab, "bankMainPageAccountTab");
        TextView bankMainPageAccountTabText = this.binding.bankMainPageAccountTabText;
        Intrinsics.checkNotNullExpressionValue(bankMainPageAccountTabText, "bankMainPageAccountTabText");
        updateTab(bankMainPageAccountTab, bankMainPageAccountTabText, z2);
        CustomCardView bankMainPageTaxesTab = this.binding.bankMainPageTaxesTab;
        Intrinsics.checkNotNullExpressionValue(bankMainPageTaxesTab, "bankMainPageTaxesTab");
        TextView bankMainPageTaxesTabText = this.binding.bankMainPageTaxesTabText;
        Intrinsics.checkNotNullExpressionValue(bankMainPageTaxesTabText, "bankMainPageTaxesTabText");
        updateTab(bankMainPageTaxesTab, bankMainPageTaxesTabText, !z2);
        BankSlidingTabIndicator bankSlidingTabIndicator = this.sectionIndicator;
        BankMainPageBinding bankMainPageBinding = this.binding;
        CustomCardView customCardView = z2 ? bankMainPageBinding.bankMainPageAccountTab : bankMainPageBinding.bankMainPageTaxesTab;
        Intrinsics.checkNotNull(customCardView);
        BankSlidingTabIndicator.moveTo$default(bankSlidingTabIndicator, customCardView, false, 2, null);
        BankMainPageBinding bankMainPageBinding2 = this.binding;
        if (z2) {
            NestedScrollView bankMainPageAccountContent = bankMainPageBinding2.bankMainPageAccountContent;
            Intrinsics.checkNotNullExpressionValue(bankMainPageAccountContent, "bankMainPageAccountContent");
            BankContentTransitionKt.showBankContentTransition(bankMainPageAccountContent, i, z);
            RecyclerView bankMainPageTaxesContent = this.binding.bankMainPageTaxesContent;
            Intrinsics.checkNotNullExpressionValue(bankMainPageTaxesContent, "bankMainPageTaxesContent");
            BankContentTransitionKt.hideBankContentTransition(bankMainPageTaxesContent, -i, z);
        } else {
            RecyclerView bankMainPageTaxesContent2 = bankMainPageBinding2.bankMainPageTaxesContent;
            Intrinsics.checkNotNullExpressionValue(bankMainPageTaxesContent2, "bankMainPageTaxesContent");
            BankContentTransitionKt.showBankContentTransition(bankMainPageTaxesContent2, i, z);
            NestedScrollView bankMainPageAccountContent2 = this.binding.bankMainPageAccountContent;
            Intrinsics.checkNotNullExpressionValue(bankMainPageAccountContent2, "bankMainPageAccountContent");
            BankContentTransitionKt.hideBankContentTransition(bankMainPageAccountContent2, -i, z);
        }
        this.hasSelectedSection = true;
    }

    private final void updateTab(CustomCardView customCardView, TextView textView, boolean z) {
        customCardView.setBackground(-1);
        customCardView.setBackgroundAlpha(0);
        textView.setTextColor(z ? Color.parseColor("#15182A") : -1);
    }
}
