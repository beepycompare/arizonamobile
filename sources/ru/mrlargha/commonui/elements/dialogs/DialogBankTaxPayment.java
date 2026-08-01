package ru.mrlargha.commonui.elements.dialogs;

import android.app.Activity;
import android.graphics.Color;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.DialogBankTaxPaymentBinding;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: DialogBankTaxPayment.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 92\u00020\u0001:\u00019B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\b\u0010$\u001a\u00020\u001dH\u0002J \u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u0005H\u0002J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\u0005H\u0002J\b\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020\u0007H\u0002J\u0010\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u00020\u0005H\u0002J\u000e\u00105\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015H\u0002J\u0018\u00106\u001a\u0002012\u0006\u00107\u001a\u0002012\u0006\u00108\u001a\u000201H\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0019j\b\u0012\u0004\u0012\u00020\u0005`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogBankTaxPayment;", "Lru/mrlargha/commonui/elements/dialogs/AbstractDialog;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "caption", "", "infoData", "leftButtonText", "hintInput", "sampDialogId", "<init>", "(Landroid/app/Activity;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "dialogLayout", "Landroid/view/View;", "binding", "Lru/mrlargha/commonui/databinding/DialogBankTaxPaymentBinding;", "payload", "Lru/mrlargha/commonui/elements/dialogs/DialogBankTaxPaymentModel;", "methodTabs", "", "adapter", "Lru/mrlargha/commonui/elements/dialogs/DialogBankTaxPaymentAdapter;", "selectedTaxIds", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "selectedMethodIndex", "setupUi", "", "setupPreview", "setupList", "setupMethodTabs", "setupButtons", "setupAdditionalInfo", "render", "renderMethodTabs", "updateMethodTab", "card", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "text", "Landroid/widget/TextView;", "isSelected", "", "selectMethodTab", FirebaseAnalytics.Param.INDEX, "toggleTax", "id", "selectedTotal", "", "selectedIdsPayload", "dismiss", "responseButtonId", "defaultMethodTabs", "safeSum", TtmlNode.LEFT, TtmlNode.RIGHT, "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogBankTaxPayment extends AbstractDialog {
    private static final Companion Companion = new Companion(null);
    private static final int MAX_METHOD_TABS = 2;
    private static final String SELECTED_TAB_BG = "#FFFFFF";
    private static final String SELECTED_TAB_TEXT = "#2E3646";
    private static final String UNSELECTED_TAB_BG = "#00FFFFFF";
    private static final String UNSELECTED_TAB_TEXT = "#FFFFFF";
    private final DialogBankTaxPaymentAdapter adapter;
    private final DialogBankTaxPaymentBinding binding;
    private final View dialogLayout;
    private final List<String> methodTabs;
    private final DialogBankTaxPaymentModel payload;
    private int selectedMethodIndex;
    private final LinkedHashSet<Integer> selectedTaxIds;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$0(View view) {
    }

    private final long safeSum(long j, long j2) {
        if (Long.MAX_VALUE - j < j2) {
            return Long.MAX_VALUE;
        }
        return j + j2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogBankTaxPayment(Activity targetActivity, int i, String caption, String infoData, String leftButtonText, String hintInput, int i2) {
        super(targetActivity, i, i2);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(caption, "caption");
        Intrinsics.checkNotNullParameter(infoData, "infoData");
        Intrinsics.checkNotNullParameter(leftButtonText, "leftButtonText");
        Intrinsics.checkNotNullParameter(hintInput, "hintInput");
        View inflate = LayoutInflater.from(targetActivity).inflate(R.layout.dialog_bank_tax_payment, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.dialogLayout = inflate;
        DialogBankTaxPaymentBinding bind = DialogBankTaxPaymentBinding.bind(inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        DialogBankTaxPaymentModel parseDialogBankTaxPaymentModel = DialogBankTaxPaymentKt.parseDialogBankTaxPaymentModel(caption, infoData, leftButtonText, hintInput);
        this.payload = parseDialogBankTaxPaymentModel;
        List<String> titles = DialogListItemTabsKt.parseDialogListItemTabs(parseDialogBankTaxPaymentModel.getBody(), 2).getTitles();
        this.methodTabs = CollectionsKt.take(titles.isEmpty() ? defaultMethodTabs() : titles, 2);
        this.adapter = new DialogBankTaxPaymentAdapter(new DialogBankTaxPayment$adapter$1(this));
        this.selectedTaxIds = new LinkedHashSet<>();
        addViewToConstraintLayout(inflate, -1, -1);
        setPosition(SAMPUIElement.PositionType.CENTER, 0, 0);
        setupUi();
        setVisibility(true);
        bind.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBankTaxPayment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogBankTaxPayment._init_$lambda$0(view);
            }
        });
    }

    private final void setupUi() {
        DialogBankTaxPaymentBinding dialogBankTaxPaymentBinding = this.binding;
        TextView textView = dialogBankTaxPaymentBinding.bankBusinessPaymentModalTitle;
        ChatEmoji chatEmoji = ChatEmoji.INSTANCE;
        String header = this.payload.getHeader();
        if (StringsKt.isBlank(header)) {
            header = getTargetActivity().getString(R.string.dialog_bank_tax_payment_title);
            Intrinsics.checkNotNullExpressionValue(header, "getString(...)");
        }
        textView.setText(ChatEmoji.toSpannable$default(chatEmoji, header, 0.0f, null, 3, null));
        dialogBankTaxPaymentBinding.bankBusinessPaymentClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBankTaxPayment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogBankTaxPayment.this.dismiss(0);
            }
        });
        setupPreview();
        setupList();
        setupMethodTabs();
        setupButtons();
        setupAdditionalInfo();
        render();
    }

    private final void setupPreview() {
        DialogBankTaxPaymentBinding dialogBankTaxPaymentBinding = this.binding;
        dialogBankTaxPaymentBinding.bankBusinessPaymentPreviewTitle.setText(getTargetActivity().getString(DialogBankTaxPaymentKt.resolveDialogBankTaxPaymentTitleRes(this.payload.getAddType())));
        Picasso.get().load(DialogBankTaxPaymentKt.resolveTaxPaymentImageUrl(this.payload.getAddType())).into(dialogBankTaxPaymentBinding.bankBusinessPaymentPreviewImage);
    }

    private final void setupList() {
        DialogBankTaxPaymentBinding dialogBankTaxPaymentBinding = this.binding;
        dialogBankTaxPaymentBinding.bankBusinessPaymentList.setLayoutManager(new LinearLayoutManager(getTargetActivity()));
        dialogBankTaxPaymentBinding.bankBusinessPaymentList.setAdapter(this.adapter);
        dialogBankTaxPaymentBinding.bankBusinessPaymentList.setItemAnimator(null);
        dialogBankTaxPaymentBinding.bankBusinessPaymentList.setNestedScrollingEnabled(true);
        dialogBankTaxPaymentBinding.bankBusinessPaymentList.setScrollbarFadingEnabled(false);
    }

    private final void setupMethodTabs() {
        DialogBankTaxPaymentBinding dialogBankTaxPaymentBinding = this.binding;
        dialogBankTaxPaymentBinding.bankBusinessPaymentCash.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBankTaxPayment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogBankTaxPayment.this.selectMethodTab(0);
            }
        });
        dialogBankTaxPaymentBinding.bankBusinessPaymentBankAccount.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBankTaxPayment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogBankTaxPayment.this.selectMethodTab(1);
            }
        });
    }

    private final void setupButtons() {
        DialogBankTaxPaymentBinding dialogBankTaxPaymentBinding = this.binding;
        TextView textView = dialogBankTaxPaymentBinding.bankBusinessPaymentPayText;
        ChatEmoji chatEmoji = ChatEmoji.INSTANCE;
        String primaryButton = this.payload.getPrimaryButton();
        if (StringsKt.isBlank(primaryButton)) {
            primaryButton = getTargetActivity().getString(R.string.dialog_bank_tax_payment_pay);
            Intrinsics.checkNotNullExpressionValue(primaryButton, "getString(...)");
        }
        textView.setText(ChatEmoji.toSpannable$default(chatEmoji, primaryButton, 0.0f, null, 3, null));
        dialogBankTaxPaymentBinding.bankBusinessPaymentPay.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBankTaxPayment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogBankTaxPayment.setupButtons$lambda$0$1(DialogBankTaxPayment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupButtons$lambda$0$1(DialogBankTaxPayment dialogBankTaxPayment, View view) {
        if (dialogBankTaxPayment.selectedTaxIds.isEmpty()) {
            return;
        }
        dialogBankTaxPayment.dismiss(1);
    }

    private final void setupAdditionalInfo() {
        String normalizeTaxPaymentMoneyTokens;
        DialogBankTaxPaymentBinding dialogBankTaxPaymentBinding = this.binding;
        LinearLayout bankBusinessPaymentInfoContainer = dialogBankTaxPaymentBinding.bankBusinessPaymentInfoContainer;
        Intrinsics.checkNotNullExpressionValue(bankBusinessPaymentInfoContainer, "bankBusinessPaymentInfoContainer");
        bankBusinessPaymentInfoContainer.setVisibility(!StringsKt.isBlank(this.payload.getAdditionalInfo()) ? 0 : 8);
        TextView textView = dialogBankTaxPaymentBinding.bankBusinessPaymentInfo;
        ChatEmoji chatEmoji = ChatEmoji.INSTANCE;
        normalizeTaxPaymentMoneyTokens = DialogBankTaxPaymentKt.normalizeTaxPaymentMoneyTokens(this.payload.getAdditionalInfo());
        textView.setText(ChatEmoji.toSpannable$default(chatEmoji, normalizeTaxPaymentMoneyTokens, 0.8f, null, 2, null));
    }

    private final void render() {
        CharSequence dialogBankTaxPaymentMoneyText;
        DialogBankTaxPaymentBinding dialogBankTaxPaymentBinding = this.binding;
        this.adapter.submitList(this.payload.getTaxList(), this.selectedTaxIds);
        TextView bankBusinessPaymentEmpty = dialogBankTaxPaymentBinding.bankBusinessPaymentEmpty;
        Intrinsics.checkNotNullExpressionValue(bankBusinessPaymentEmpty, "bankBusinessPaymentEmpty");
        bankBusinessPaymentEmpty.setVisibility(this.payload.getTaxList().isEmpty() ? 0 : 8);
        RecyclerView bankBusinessPaymentList = dialogBankTaxPaymentBinding.bankBusinessPaymentList;
        Intrinsics.checkNotNullExpressionValue(bankBusinessPaymentList, "bankBusinessPaymentList");
        bankBusinessPaymentList.setVisibility(this.payload.getTaxList().isEmpty() ? 8 : 0);
        CustomCardView bankBusinessPaymentPay = dialogBankTaxPaymentBinding.bankBusinessPaymentPay;
        Intrinsics.checkNotNullExpressionValue(bankBusinessPaymentPay, "bankBusinessPaymentPay");
        CustomCardView.changeValidate$default(bankBusinessPaymentPay, !this.selectedTaxIds.isEmpty(), 0.0f, 2, null);
        dialogBankTaxPaymentMoneyText = DialogBankTaxPaymentKt.toDialogBankTaxPaymentMoneyText(selectedTotal());
        dialogBankTaxPaymentBinding.bankBusinessPaymentPreviewAmount.setText(dialogBankTaxPaymentMoneyText);
        dialogBankTaxPaymentBinding.bankBusinessPaymentTotalAmount.setText(dialogBankTaxPaymentMoneyText);
        renderMethodTabs();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void renderMethodTabs() {
        SpannableString spannableString;
        String str;
        DialogBankTaxPaymentBinding dialogBankTaxPaymentBinding = this.binding;
        TextView textView = dialogBankTaxPaymentBinding.bankBusinessPaymentCashText;
        String str2 = (String) CollectionsKt.getOrNull(this.methodTabs, 0);
        SpannableString spannableString2 = null;
        if (str2 != null) {
            String str3 = str2;
            if (StringsKt.isBlank(str3)) {
                str3 = getTargetActivity().getString(R.string.dialog_bank_tax_payment_tab_cash);
                Intrinsics.checkNotNullExpressionValue(str3, "getString(...)");
            }
            String str4 = str3;
            if (str4 != null) {
                spannableString = ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, str4, 0.0f, null, 3, null);
                textView.setText(spannableString);
                CustomCardView bankBusinessPaymentBankAccount = dialogBankTaxPaymentBinding.bankBusinessPaymentBankAccount;
                Intrinsics.checkNotNullExpressionValue(bankBusinessPaymentBankAccount, "bankBusinessPaymentBankAccount");
                bankBusinessPaymentBankAccount.setVisibility(!(this.methodTabs.size() <= 1) ? 0 : 8);
                TextView textView2 = dialogBankTaxPaymentBinding.bankBusinessPaymentBankAccountText;
                str = (String) CollectionsKt.getOrNull(this.methodTabs, 1);
                if (str != null) {
                    String str5 = str;
                    if (StringsKt.isBlank(str5)) {
                        str5 = getTargetActivity().getString(R.string.dialog_bank_tax_payment_tab_bank_account);
                        Intrinsics.checkNotNullExpressionValue(str5, "getString(...)");
                    }
                    String str6 = str5;
                    if (str6 != null) {
                        spannableString2 = ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, str6, 0.0f, null, 3, null);
                    }
                }
                textView2.setText(spannableString2);
                CustomCardView bankBusinessPaymentCash = dialogBankTaxPaymentBinding.bankBusinessPaymentCash;
                Intrinsics.checkNotNullExpressionValue(bankBusinessPaymentCash, "bankBusinessPaymentCash");
                TextView bankBusinessPaymentCashText = dialogBankTaxPaymentBinding.bankBusinessPaymentCashText;
                Intrinsics.checkNotNullExpressionValue(bankBusinessPaymentCashText, "bankBusinessPaymentCashText");
                updateMethodTab(bankBusinessPaymentCash, bankBusinessPaymentCashText, this.selectedMethodIndex != 0);
                CustomCardView bankBusinessPaymentBankAccount2 = dialogBankTaxPaymentBinding.bankBusinessPaymentBankAccount;
                Intrinsics.checkNotNullExpressionValue(bankBusinessPaymentBankAccount2, "bankBusinessPaymentBankAccount");
                TextView bankBusinessPaymentBankAccountText = dialogBankTaxPaymentBinding.bankBusinessPaymentBankAccountText;
                Intrinsics.checkNotNullExpressionValue(bankBusinessPaymentBankAccountText, "bankBusinessPaymentBankAccountText");
                updateMethodTab(bankBusinessPaymentBankAccount2, bankBusinessPaymentBankAccountText, this.selectedMethodIndex == 1);
            }
        }
        spannableString = null;
        textView.setText(spannableString);
        CustomCardView bankBusinessPaymentBankAccount3 = dialogBankTaxPaymentBinding.bankBusinessPaymentBankAccount;
        Intrinsics.checkNotNullExpressionValue(bankBusinessPaymentBankAccount3, "bankBusinessPaymentBankAccount");
        bankBusinessPaymentBankAccount3.setVisibility(!(this.methodTabs.size() <= 1) ? 0 : 8);
        TextView textView22 = dialogBankTaxPaymentBinding.bankBusinessPaymentBankAccountText;
        str = (String) CollectionsKt.getOrNull(this.methodTabs, 1);
        if (str != null) {
        }
        textView22.setText(spannableString2);
        CustomCardView bankBusinessPaymentCash2 = dialogBankTaxPaymentBinding.bankBusinessPaymentCash;
        Intrinsics.checkNotNullExpressionValue(bankBusinessPaymentCash2, "bankBusinessPaymentCash");
        TextView bankBusinessPaymentCashText2 = dialogBankTaxPaymentBinding.bankBusinessPaymentCashText;
        Intrinsics.checkNotNullExpressionValue(bankBusinessPaymentCashText2, "bankBusinessPaymentCashText");
        updateMethodTab(bankBusinessPaymentCash2, bankBusinessPaymentCashText2, this.selectedMethodIndex != 0);
        CustomCardView bankBusinessPaymentBankAccount22 = dialogBankTaxPaymentBinding.bankBusinessPaymentBankAccount;
        Intrinsics.checkNotNullExpressionValue(bankBusinessPaymentBankAccount22, "bankBusinessPaymentBankAccount");
        TextView bankBusinessPaymentBankAccountText2 = dialogBankTaxPaymentBinding.bankBusinessPaymentBankAccountText;
        Intrinsics.checkNotNullExpressionValue(bankBusinessPaymentBankAccountText2, "bankBusinessPaymentBankAccountText");
        updateMethodTab(bankBusinessPaymentBankAccount22, bankBusinessPaymentBankAccountText2, this.selectedMethodIndex == 1);
    }

    private final void updateMethodTab(CustomCardView customCardView, TextView textView, boolean z) {
        String str = "#FFFFFF";
        customCardView.setBackground(Color.parseColor(z ? "#FFFFFF" : UNSELECTED_TAB_BG));
        if (z) {
            str = SELECTED_TAB_TEXT;
        }
        textView.setTextColor(Color.parseColor(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectMethodTab(int i) {
        if (i < 0 || i >= this.methodTabs.size()) {
            return;
        }
        this.selectedMethodIndex = i;
        renderMethodTabs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleTax(int i) {
        if (!this.selectedTaxIds.add(Integer.valueOf(i))) {
            this.selectedTaxIds.remove(Integer.valueOf(i));
        }
        render();
    }

    private final long selectedTotal() {
        ArrayList<DialogBankTaxPaymentInfo> arrayList = new ArrayList();
        for (Object obj : this.payload.getTaxList()) {
            if (this.selectedTaxIds.contains(Integer.valueOf(((DialogBankTaxPaymentInfo) obj).getId()))) {
                arrayList.add(obj);
            }
        }
        long j = 0;
        for (DialogBankTaxPaymentInfo dialogBankTaxPaymentInfo : arrayList) {
            j = safeSum(j, RangesKt.coerceAtLeast(dialogBankTaxPaymentInfo.getTax(), 0L));
        }
        return j;
    }

    private final String selectedIdsPayload() {
        return DialogBankTaxPaymentKt.buildDialogBankTaxPaymentSelectedIdsPayload(this.payload.getTaxList(), this.selectedTaxIds);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismiss(int i) {
        getNotifier().onDialogResponseWrapper(getSampDialogId(), i, i == 1 ? this.selectedMethodIndex : -1, i == 1 ? StringsKt.encodeToByteArray(selectedIdsPayload()) : new byte[0]);
        getNotifier().destroyDialog();
    }

    private final List<String> defaultMethodTabs() {
        return CollectionsKt.listOf((Object[]) new String[]{getTargetActivity().getString(R.string.dialog_bank_tax_payment_tab_cash), getTargetActivity().getString(R.string.dialog_bank_tax_payment_tab_bank_account)});
    }

    /* compiled from: DialogBankTaxPayment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogBankTaxPayment$Companion;", "", "<init>", "()V", "MAX_METHOD_TABS", "", "SELECTED_TAB_BG", "", "UNSELECTED_TAB_BG", "SELECTED_TAB_TEXT", "UNSELECTED_TAB_TEXT", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
