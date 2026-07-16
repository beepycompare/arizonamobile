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
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.DialogBankTaxPaymentBinding;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: DialogBankTaxPayment.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 A2\u00020\u0001:\u0001AB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u001eH\u0002J\b\u0010$\u001a\u00020\u001eH\u0002J\b\u0010%\u001a\u00020\u001eH\u0002J\b\u0010&\u001a\u00020\u001eH\u0002J \u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u0005H\u0002J\u0010\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u0005H\u0002J\b\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020\u0007H\u0002J\u0010\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u00020\u0005H\u0002J \u00107\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u00108\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u0007H\u0002J\u000e\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016H\u0002J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0005H\u0002J\u0018\u0010>\u001a\u0002032\u0006\u0010?\u001a\u0002032\u0006\u0010@\u001a\u000203H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u001aj\b\u0012\u0004\u0012\u00020\u0005`\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogBankTaxPayment;", "Lru/mrlargha/commonui/elements/dialogs/AbstractDialog;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "caption", "", "infoData", "leftButtonText", "sampDialogId", "<init>", "(Landroid/app/Activity;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "dialogLayout", "Landroid/view/View;", "binding", "Lru/mrlargha/commonui/databinding/DialogBankTaxPaymentBinding;", "payload", "Lru/mrlargha/commonui/elements/dialogs/DialogBankTaxPaymentModel;", "parsedBody", "Lru/mrlargha/commonui/elements/dialogs/ParsedTaxPaymentBody;", "methodTabs", "", "adapter", "Lru/mrlargha/commonui/elements/dialogs/DialogBankTaxPaymentAdapter;", "selectedTaxIds", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "selectedMethodIndex", "setupUi", "", "setupPreview", "setupBalance", "setupList", "setupMethodTabs", "setupButtons", "setupAdditionalInfo", "render", "renderMethodTabs", "updateMethodTab", "card", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "text", "Landroid/widget/TextView;", "isSelected", "", "selectMethodTab", FirebaseAnalytics.Param.INDEX, "toggleTax", "id", "selectedTotal", "", "selectedIdsPayload", "dismiss", "responseButtonId", "buildPayload", "parseBody", TtmlNode.TAG_BODY, "defaultMethodTabs", "taxVisual", "Lru/mrlargha/commonui/elements/dialogs/TaxPaymentVisual;", "type", "safeSum", TtmlNode.LEFT, TtmlNode.RIGHT, "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogBankTaxPayment extends AbstractDialog {
    private static final int MAX_METHOD_TABS = 2;
    private static final String METHOD_TAB_SEPARATOR = ";";
    private static final int PREVIEW_GRADIENT_ANGLE = 345;
    private static final String SELECTED_TAB_BG = "#FFFFFF";
    private static final String SELECTED_TAB_TEXT = "#2E3646";
    private static final int TAX_BUSINESS = 9;
    private static final int TAX_COMMUNAL = 2;
    private static final int TAX_ELECTRICITY = 3;
    private static final int TAX_FAMILY_APARTMENT = 10;
    private static final int TAX_HOME = 8;
    private static final int TAX_HOTEL_ROOM_LEASE = 7;
    private static final int TAX_LEGAL_FINE = 1;
    private static final int TAX_PRIVATE_ORGANIZATION = 4;
    private static final int TAX_SOCIAL_HOUSING = 5;
    private static final int TAX_TRANSPORT = 0;
    private static final int TAX_VEHICLE_RESTORATION = 6;
    private static final String UNSELECTED_TAB_BG = "#00FFFFFF";
    private static final String UNSELECTED_TAB_TEXT = "#FFFFFF";
    private final DialogBankTaxPaymentAdapter adapter;
    private final DialogBankTaxPaymentBinding binding;
    private final View dialogLayout;
    private final List<String> methodTabs;
    private final ParsedTaxPaymentBody parsedBody;
    private final DialogBankTaxPaymentModel payload;
    private int selectedMethodIndex;
    private final LinkedHashSet<Integer> selectedTaxIds;
    private static final Companion Companion = new Companion(null);
    private static final Gson gson = new Gson();
    private static final Regex METHOD_TABS_REGEX = new Regex("\\[\\[listitemTabs:titles=([^\\]]*)\\]\\]", RegexOption.IGNORE_CASE);

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
    public DialogBankTaxPayment(Activity targetActivity, int i, String caption, String infoData, String leftButtonText, int i2) {
        super(targetActivity, i, i2);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(caption, "caption");
        Intrinsics.checkNotNullParameter(infoData, "infoData");
        Intrinsics.checkNotNullParameter(leftButtonText, "leftButtonText");
        View inflate = LayoutInflater.from(targetActivity).inflate(R.layout.dialog_bank_tax_payment, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.dialogLayout = inflate;
        DialogBankTaxPaymentBinding bind = DialogBankTaxPaymentBinding.bind(inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        DialogBankTaxPaymentModel buildPayload = buildPayload(caption, infoData, leftButtonText);
        this.payload = buildPayload;
        ParsedTaxPaymentBody parseBody = parseBody(buildPayload.getBody());
        this.parsedBody = parseBody;
        List<String> methodTabs = parseBody.getMethodTabs();
        this.methodTabs = CollectionsKt.take(methodTabs.isEmpty() ? defaultMethodTabs() : methodTabs, 2);
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
        setupBalance();
        setupList();
        setupMethodTabs();
        setupButtons();
        setupAdditionalInfo();
        render();
    }

    private final void setupPreview() {
        DialogBankTaxPaymentBinding dialogBankTaxPaymentBinding = this.binding;
        TaxPaymentVisual taxVisual = taxVisual(this.payload.getAddType());
        CustomCardView bankBusinessPaymentPreview = dialogBankTaxPaymentBinding.bankBusinessPaymentPreview;
        Intrinsics.checkNotNullExpressionValue(bankBusinessPaymentPreview, "bankBusinessPaymentPreview");
        CustomCardView.setBackground$default(bankBusinessPaymentPreview, Color.parseColor(taxVisual.getMainColor()), Color.parseColor(taxVisual.getSecondColor()), Integer.valueOf((int) PREVIEW_GRADIENT_ANGLE), null, 8, null);
        dialogBankTaxPaymentBinding.bankBusinessPaymentPreviewTitle.setText(getTargetActivity().getString(taxVisual.getTitleRes()));
        dialogBankTaxPaymentBinding.bankBusinessPaymentPreviewBadge.setText(taxVisual.getBadge());
    }

    private final void setupBalance() {
        DialogBankTaxPaymentBinding dialogBankTaxPaymentBinding = this.binding;
        TextView bankBusinessPaymentBalance = dialogBankTaxPaymentBinding.bankBusinessPaymentBalance;
        Intrinsics.checkNotNullExpressionValue(bankBusinessPaymentBalance, "bankBusinessPaymentBalance");
        bankBusinessPaymentBalance.setVisibility(!StringsKt.isBlank(this.parsedBody.getBalanceText()) ? 0 : 8);
        dialogBankTaxPaymentBinding.bankBusinessPaymentBalance.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, this.parsedBody.getBalanceText(), 0.0f, null, 3, null));
    }

    private final void setupList() {
        DialogBankTaxPaymentBinding dialogBankTaxPaymentBinding = this.binding;
        dialogBankTaxPaymentBinding.bankBusinessPaymentList.setLayoutManager(new LinearLayoutManager(getTargetActivity()));
        dialogBankTaxPaymentBinding.bankBusinessPaymentList.setAdapter(this.adapter);
        dialogBankTaxPaymentBinding.bankBusinessPaymentList.setItemAnimator(null);
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
        DialogBankTaxPaymentBinding dialogBankTaxPaymentBinding = this.binding;
        LinearLayout bankBusinessPaymentInfoContainer = dialogBankTaxPaymentBinding.bankBusinessPaymentInfoContainer;
        Intrinsics.checkNotNullExpressionValue(bankBusinessPaymentInfoContainer, "bankBusinessPaymentInfoContainer");
        bankBusinessPaymentInfoContainer.setVisibility(!StringsKt.isBlank(this.payload.getAdditionalInfo()) ? 0 : 8);
        dialogBankTaxPaymentBinding.bankBusinessPaymentInfo.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, this.payload.getAdditionalInfo(), 0.0f, null, 3, null));
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
        TextView textView = dialogBankTaxPaymentBinding.bankBusinessPaymentPreviewAmount;
        dialogBankTaxPaymentMoneyText = DialogBankTaxPaymentKt.toDialogBankTaxPaymentMoneyText(selectedTotal());
        textView.setText(dialogBankTaxPaymentMoneyText);
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
        ArrayList arrayList = new ArrayList();
        for (DialogBankTaxPaymentInfo dialogBankTaxPaymentInfo : this.payload.getTaxList()) {
            Integer valueOf = Integer.valueOf(dialogBankTaxPaymentInfo.getId());
            if (!this.selectedTaxIds.contains(Integer.valueOf(valueOf.intValue()))) {
                valueOf = null;
            }
            if (valueOf != null) {
                arrayList.add(valueOf);
            }
        }
        String json = gson.toJson(arrayList);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismiss(int i) {
        getNotifier().onDialogResponseWrapper(getSampDialogId(), i, i == 1 ? this.selectedMethodIndex : -1, i == 1 ? StringsKt.encodeToByteArray(selectedIdsPayload()) : new byte[0]);
        getNotifier().destroyDialog();
    }

    private final ParsedTaxPaymentBody parseBody(String str) {
        List<String> groupValues;
        String str2;
        List split$default;
        String str3 = str;
        ArrayList arrayList = null;
        MatchResult find$default = Regex.find$default(METHOD_TABS_REGEX, str3, 0, 2, null);
        if (find$default != null && (groupValues = find$default.getGroupValues()) != null && (str2 = (String) CollectionsKt.getOrNull(groupValues, 1)) != null && (split$default = StringsKt.split$default((CharSequence) str2, new String[]{METHOD_TAB_SEPARATOR}, false, 0, 6, (Object) null)) != null) {
            List<String> list = split$default;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (String str4 : list) {
                arrayList2.add(StringsKt.trim((CharSequence) str4).toString());
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : arrayList2) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList3.add(obj);
                }
            }
            arrayList = arrayList3;
        }
        if (arrayList == null) {
            arrayList = CollectionsKt.emptyList();
        }
        return new ParsedTaxPaymentBody(StringsKt.trim((CharSequence) METHOD_TABS_REGEX.replace(str3, "")).toString(), arrayList);
    }

    private final List<String> defaultMethodTabs() {
        return CollectionsKt.listOf((Object[]) new String[]{getTargetActivity().getString(R.string.dialog_bank_tax_payment_tab_cash), getTargetActivity().getString(R.string.dialog_bank_tax_payment_tab_bank_account)});
    }

    private final TaxPaymentVisual taxVisual(int i) {
        switch (i) {
            case 0:
                return new TaxPaymentVisual(R.string.dialog_bank_tax_payment_transport_title, "CAR", "#2669D4", "#7ED2F5");
            case 1:
                return new TaxPaymentVisual(R.string.dialog_bank_tax_payment_legal_fine_title, "FINE", "#DC5A5A", "#FFC06E");
            case 2:
                return new TaxPaymentVisual(R.string.dialog_bank_tax_payment_communal_title, "UTIL", "#5F7CFF", "#71D7B6");
            case 3:
                return new TaxPaymentVisual(R.string.dialog_bank_tax_payment_electricity_title, "ELC", "#6A5CFF", "#FFF06A");
            case 4:
                return new TaxPaymentVisual(R.string.dialog_bank_tax_payment_private_org_title, "ORG", "#25A7B8", "#8EF1D1");
            case 5:
                return new TaxPaymentVisual(R.string.dialog_bank_tax_payment_social_housing_title, "SOC", "#4F85D9", "#B2C8FF");
            case 6:
                return new TaxPaymentVisual(R.string.dialog_bank_tax_payment_vehicle_restoration_title, "REST", "#C94C67", "#FFA27A");
            case 7:
                return new TaxPaymentVisual(R.string.dialog_bank_tax_payment_hotel_lease_title, "HOTEL", "#6E70D8", "#DFA7FF");
            case 8:
                return new TaxPaymentVisual(R.string.dialog_bank_tax_payment_home_title, "HOME", "#5F2ABF", "#E980A9");
            case 9:
                return new TaxPaymentVisual(R.string.dialog_bank_tax_payment_business_title, "BIZ", "#26B2D4", "#7ED2F5");
            case 10:
                return new TaxPaymentVisual(R.string.dialog_bank_tax_payment_family_apartment_title, "FAM", "#845EC2", "#FF9F80");
            default:
                return new TaxPaymentVisual(R.string.dialog_bank_tax_payment_business_title, "TAX", "#26B2D4", "#7ED2F5");
        }
    }

    /* compiled from: DialogBankTaxPayment.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogBankTaxPayment$Companion;", "", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "METHOD_TABS_REGEX", "Lkotlin/text/Regex;", "METHOD_TAB_SEPARATOR", "", "MAX_METHOD_TABS", "", "PREVIEW_GRADIENT_ANGLE", "SELECTED_TAB_BG", "UNSELECTED_TAB_BG", "SELECTED_TAB_TEXT", "UNSELECTED_TAB_TEXT", "TAX_TRANSPORT", "TAX_LEGAL_FINE", "TAX_COMMUNAL", "TAX_ELECTRICITY", "TAX_PRIVATE_ORGANIZATION", "TAX_SOCIAL_HOUSING", "TAX_VEHICLE_RESTORATION", "TAX_HOTEL_ROOM_LEASE", "TAX_HOME", "TAX_BUSINESS", "TAX_FAMILY_APARTMENT", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final DialogBankTaxPaymentModel buildPayload(String str, String str2, String str3) {
        DialogBankTaxPaymentModel dialogBankTaxPaymentModel = (DialogBankTaxPaymentModel) ((!MapperKt.isJsonValid(str2) || Intrinsics.areEqual(str2, AbstractJsonLexerKt.NULL) || Intrinsics.areEqual(str2, "{}") || str2.length() == 0) ? null : MapperKt.getGson().fromJson(str2, (Class<Object>) DialogBankTaxPaymentModel.class));
        if (dialogBankTaxPaymentModel != null) {
            String header = dialogBankTaxPaymentModel.getHeader();
            if (StringsKt.isBlank(header)) {
                header = str;
            }
            String str4 = header;
            String primaryButton = dialogBankTaxPaymentModel.getPrimaryButton();
            if (StringsKt.isBlank(primaryButton)) {
                primaryButton = str3;
            }
            DialogBankTaxPaymentModel copy$default = DialogBankTaxPaymentModel.copy$default(dialogBankTaxPaymentModel, 0, str4, 0, null, null, primaryButton, null, 93, null);
            if (copy$default != null) {
                return copy$default;
            }
        }
        return new DialogBankTaxPaymentModel(0, str, 0, null, str2, str3, null, 77, null);
    }
}
