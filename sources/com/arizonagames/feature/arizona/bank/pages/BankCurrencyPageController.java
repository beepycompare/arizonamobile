package com.arizonagames.feature.arizona.bank.pages;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.arizonagames.feature.arizona.bank.BankPage;
import com.arizonagames.feature.arizona.bank.BankScreenPayload;
import com.arizonagames.feature.arizona.bank.BankSendSubId;
import com.arizonagames.feature.arizona.bank.R;
import com.arizonagames.feature.arizona.bank.databinding.BankCurrencyPageBinding;
import com.arizonagames.feature.arizona.bank.ui.BankUiFormatterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.core.IBackendNotifier;
/* compiled from: BankCurrencyPageController.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankCurrencyPageController;", "Lcom/arizonagames/feature/arizona/bank/pages/BankPageController;", "targetActivity", "Landroid/app/Activity;", "binding", "Lcom/arizonagames/feature/arizona/bank/databinding/BankCurrencyPageBinding;", "onAction", "Lkotlin/Function2;", "", "Lcom/arizonagames/feature/arizona/bank/BankSendSubId;", "", "<init>", "(Landroid/app/Activity;Lcom/arizonagames/feature/arizona/bank/databinding/BankCurrencyPageBinding;Lkotlin/jvm/functions/Function2;)V", "page", "Lcom/arizonagames/feature/arizona/bank/BankPage;", "getPage", "()Lcom/arizonagames/feature/arizona/bank/BankPage;", "root", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "currencyBalanceDollars", "Landroid/widget/TextView;", "currencyAdapter", "Lcom/arizonagames/feature/arizona/bank/pages/BankCurrencyAdapter;", "bind", "payload", "Lcom/arizonagames/feature/arizona/bank/BankScreenPayload;", "resetState", "bindDollarBalance", "money", "", "Companion", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankCurrencyPageController implements BankPageController {
    @Deprecated
    public static final int CURRENCY_COLUMNS = 2;
    private static final Companion Companion = new Companion(null);
    private final BankCurrencyPageBinding binding;
    private final BankCurrencyAdapter currencyAdapter;
    private final TextView currencyBalanceDollars;
    private final Function2<Integer, BankSendSubId, Unit> onAction;
    private final BankPage page;
    private final View root;
    private final Activity targetActivity;

    /* JADX WARN: Multi-variable type inference failed */
    public BankCurrencyPageController(Activity targetActivity, BankCurrencyPageBinding binding, Function2<? super Integer, ? super BankSendSubId, Unit> onAction) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        this.targetActivity = targetActivity;
        this.binding = binding;
        this.onAction = onAction;
        this.page = BankPage.CURRENCY;
        FrameLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.root = root;
        View findViewById = binding.getRoot().findViewById(R.id.bank_currency_balance_dollars);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.currencyBalanceDollars = (TextView) findViewById;
        BankCurrencyAdapter bankCurrencyAdapter = new BankCurrencyAdapter(onAction);
        this.currencyAdapter = bankCurrencyAdapter;
        RecyclerView recyclerView = binding.bankCurrencyList;
        recyclerView.setLayoutManager(new GridLayoutManager((Context) targetActivity, 2, 1, false));
        recyclerView.setAdapter(bankCurrencyAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new BankCurrencyGridSpacingDecoration(2, recyclerView.getResources().getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._10sdp)));
        bindDollarBalance(0L);
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
        BankCurrencyPageBinding bankCurrencyPageBinding = this.binding;
        boolean z = (payload.getOwn().isEmpty() && payload.getCurrencies().isEmpty() && payload.getCurrencyHistory().isEmpty()) ? false : true;
        bankCurrencyPageBinding.bankCurrencyList.setVisibility(z ? 0 : 8);
        bankCurrencyPageBinding.bankCurrencyBalanceBar.setVisibility(z ? 0 : 8);
        bindDollarBalance(payload.getMoney());
        this.currencyAdapter.submitList(payload.getCurrencies(), payload.getCurrencyHistory(), payload.getOwn());
    }

    @Override // com.arizonagames.feature.arizona.bank.pages.BankPageController
    public void resetState() {
        this.currencyAdapter.resetState();
        this.binding.bankCurrencyList.scrollToPosition(0);
        bind(new BankScreenPayload(null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null));
    }

    private final void bindDollarBalance(long j) {
        TextView textView = this.currencyBalanceDollars;
        Context context = getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.setText(BankUiFormatterKt.toBankMoneyText(j, context));
    }

    /* compiled from: BankCurrencyPageController.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankCurrencyPageController$Companion;", "", "<init>", "()V", "CURRENCY_COLUMNS", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
