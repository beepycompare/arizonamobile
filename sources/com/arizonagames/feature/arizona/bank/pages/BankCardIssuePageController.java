package com.arizonagames.feature.arizona.bank.pages;

import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizonagames.feature.arizona.bank.BankContractKt;
import com.arizonagames.feature.arizona.bank.BankPage;
import com.arizonagames.feature.arizona.bank.BankScreenPayload;
import com.arizonagames.feature.arizona.bank.BankSubtitleField;
import com.arizonagames.feature.arizona.bank.databinding.BankCardIssuePageBinding;
import com.arizonagames.feature.arizona.bank.databinding.BankScreenBinding;
import com.arizonagames.feature.arizona.bank.ui.BankClickAnimationKt;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: BankCardIssuePageController.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0016H\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\u000e\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0018J\u000e\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0018J\b\u0010#\u001a\u00020\bH\u0002J\b\u0010$\u001a\u00020\bH\u0002J\b\u0010%\u001a\u00020\bH\u0002J\b\u0010&\u001a\u00020\u0018H\u0002J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0016H\u0002J \u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankCardIssuePageController;", "Lcom/arizonagames/feature/arizona/bank/pages/BankPageController;", "binding", "Lcom/arizonagames/feature/arizona/bank/databinding/BankCardIssuePageBinding;", "bindingRoot", "Lcom/arizonagames/feature/arizona/bank/databinding/BankScreenBinding;", "onOpenIntroForm", "Lkotlin/Function0;", "", "onOpenSignature", "onSubmit", "<init>", "(Lcom/arizonagames/feature/arizona/bank/databinding/BankCardIssuePageBinding;Lcom/arizonagames/feature/arizona/bank/databinding/BankScreenBinding;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "page", "Lcom/arizonagames/feature/arizona/bank/BankPage;", "getPage", "()Lcom/arizonagames/feature/arizona/bank/BankPage;", "root", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "currentPayload", "Lcom/arizonagames/feature/arizona/bank/BankScreenPayload;", "isOpenAccountStateVisible", "", "identityAccepted", "policyAccepted", "signatureCompleted", "bind", "payload", "resetState", "setOpenAccountStateVisible", "visible", "setSignatureCompleted", "value", "bindClicks", "renderState", "openSignatureIfAllowed", "isSubmitEnabled", "hasOpenedAccount", "applyCheckState", TtmlNode.RUBY_CONTAINER, "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "checkmark", "isChecked", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankCardIssuePageController implements BankPageController {
    private final BankCardIssuePageBinding binding;
    private final BankScreenBinding bindingRoot;
    private BankScreenPayload currentPayload;
    private boolean identityAccepted;
    private boolean isOpenAccountStateVisible;
    private final Function0<Unit> onOpenIntroForm;
    private final Function0<Unit> onOpenSignature;
    private final Function0<Unit> onSubmit;
    private final BankPage page;
    private boolean policyAccepted;
    private final View root;
    private boolean signatureCompleted;

    public BankCardIssuePageController(BankCardIssuePageBinding binding, BankScreenBinding bindingRoot, Function0<Unit> onOpenIntroForm, Function0<Unit> onOpenSignature, Function0<Unit> onSubmit) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(bindingRoot, "bindingRoot");
        Intrinsics.checkNotNullParameter(onOpenIntroForm, "onOpenIntroForm");
        Intrinsics.checkNotNullParameter(onOpenSignature, "onOpenSignature");
        Intrinsics.checkNotNullParameter(onSubmit, "onSubmit");
        this.binding = binding;
        this.bindingRoot = bindingRoot;
        this.onOpenIntroForm = onOpenIntroForm;
        this.onOpenSignature = onOpenSignature;
        this.onSubmit = onSubmit;
        this.page = BankPage.CARD_ISSUE;
        FrameLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.root = root;
        this.currentPayload = new BankScreenPayload(null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
        bindClicks();
        renderState();
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
        BankCardIssuePageBinding bankCardIssuePageBinding = this.binding;
        this.currentPayload = payload;
        if (hasOpenedAccount(payload)) {
            this.isOpenAccountStateVisible = false;
            this.identityAccepted = false;
            this.policyAccepted = false;
            this.signatureCompleted = false;
        }
        BankSubtitleField name = payload.getName();
        String subtitle = name != null ? name.getSubtitle() : null;
        if (subtitle == null) {
            subtitle = "";
        }
        String str = subtitle;
        if (StringsKt.isBlank(str)) {
            str = "Не указано";
        }
        String str2 = str;
        String[] strArr = new String[2];
        BankSubtitleField years = payload.getYears();
        String subtitle2 = years != null ? years.getSubtitle() : null;
        if (subtitle2 == null) {
            subtitle2 = "";
        }
        strArr[0] = subtitle2;
        BankSubtitleField birth = payload.getBirth();
        String subtitle3 = birth != null ? birth.getSubtitle() : null;
        strArr[1] = subtitle3 != null ? subtitle3 : "";
        ArrayList arrayList = new ArrayList();
        for (Object obj : CollectionsKt.listOf((Object[]) strArr)) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        CollectionsKt.joinToString$default(arrayList, " • ", null, null, 0, null, null, 62, null);
        TextView textView = bankCardIssuePageBinding.bankCardIssueIdentityValue;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase = str2.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        textView.setText(upperCase);
        renderState();
    }

    @Override // com.arizonagames.feature.arizona.bank.pages.BankPageController
    public void resetState() {
        this.currentPayload = new BankScreenPayload(null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
        this.isOpenAccountStateVisible = false;
        this.identityAccepted = false;
        this.policyAccepted = false;
        this.signatureCompleted = false;
        renderState();
    }

    public final void setOpenAccountStateVisible(boolean z) {
        this.isOpenAccountStateVisible = z;
        renderState();
    }

    public final void setSignatureCompleted(boolean z) {
        this.signatureCompleted = z;
        renderState();
    }

    private final void bindClicks() {
        BankCardIssuePageBinding bankCardIssuePageBinding = this.binding;
        CustomCardView bankCardIssueIntroButton = bankCardIssuePageBinding.bankCardIssueIntroButton;
        Intrinsics.checkNotNullExpressionValue(bankCardIssueIntroButton, "bankCardIssueIntroButton");
        BankClickAnimationKt.setAnimatedClickListener(bankCardIssueIntroButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankCardIssuePageController$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$0;
                bindClicks$lambda$0$0 = BankCardIssuePageController.bindClicks$lambda$0$0(BankCardIssuePageController.this);
                return bindClicks$lambda$0$0;
            }
        });
        CustomCardView bankCardIssueIdentityCard = bankCardIssuePageBinding.bankCardIssueIdentityCard;
        Intrinsics.checkNotNullExpressionValue(bankCardIssueIdentityCard, "bankCardIssueIdentityCard");
        BankClickAnimationKt.setAnimatedClickListener(bankCardIssueIdentityCard, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankCardIssuePageController$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$1;
                bindClicks$lambda$0$1 = BankCardIssuePageController.bindClicks$lambda$0$1(BankCardIssuePageController.this);
                return bindClicks$lambda$0$1;
            }
        });
        CustomCardView bankCardIssueIdentityCheck = bankCardIssuePageBinding.bankCardIssueIdentityCheck;
        Intrinsics.checkNotNullExpressionValue(bankCardIssueIdentityCheck, "bankCardIssueIdentityCheck");
        BankClickAnimationKt.setAnimatedClickListener(bankCardIssueIdentityCheck, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankCardIssuePageController$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$2;
                bindClicks$lambda$0$2 = BankCardIssuePageController.bindClicks$lambda$0$2(BankCardIssuePageController.this);
                return bindClicks$lambda$0$2;
            }
        });
        CustomCardView bankCardIssuePolicyCard = bankCardIssuePageBinding.bankCardIssuePolicyCard;
        Intrinsics.checkNotNullExpressionValue(bankCardIssuePolicyCard, "bankCardIssuePolicyCard");
        BankClickAnimationKt.setAnimatedClickListener(bankCardIssuePolicyCard, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankCardIssuePageController$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$3;
                bindClicks$lambda$0$3 = BankCardIssuePageController.bindClicks$lambda$0$3(BankCardIssuePageController.this);
                return bindClicks$lambda$0$3;
            }
        });
        CustomCardView bankCardIssuePolicyCheck = bankCardIssuePageBinding.bankCardIssuePolicyCheck;
        Intrinsics.checkNotNullExpressionValue(bankCardIssuePolicyCheck, "bankCardIssuePolicyCheck");
        BankClickAnimationKt.setAnimatedClickListener(bankCardIssuePolicyCheck, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankCardIssuePageController$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$4;
                bindClicks$lambda$0$4 = BankCardIssuePageController.bindClicks$lambda$0$4(BankCardIssuePageController.this);
                return bindClicks$lambda$0$4;
            }
        });
        CustomCardView bankCardIssueSignatureCard = bankCardIssuePageBinding.bankCardIssueSignatureCard;
        Intrinsics.checkNotNullExpressionValue(bankCardIssueSignatureCard, "bankCardIssueSignatureCard");
        BankClickAnimationKt.setAnimatedClickListener(bankCardIssueSignatureCard, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankCardIssuePageController$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$5;
                bindClicks$lambda$0$5 = BankCardIssuePageController.bindClicks$lambda$0$5(BankCardIssuePageController.this);
                return bindClicks$lambda$0$5;
            }
        });
        CustomCardView bankCardIssueSignature = bankCardIssuePageBinding.bankCardIssueSignature;
        Intrinsics.checkNotNullExpressionValue(bankCardIssueSignature, "bankCardIssueSignature");
        BankClickAnimationKt.setAnimatedClickListener(bankCardIssueSignature, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankCardIssuePageController$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$6;
                bindClicks$lambda$0$6 = BankCardIssuePageController.bindClicks$lambda$0$6(BankCardIssuePageController.this);
                return bindClicks$lambda$0$6;
            }
        });
        CustomCardView bankCardIssueSubmitButton = bankCardIssuePageBinding.bankCardIssueSubmitButton;
        Intrinsics.checkNotNullExpressionValue(bankCardIssueSubmitButton, "bankCardIssueSubmitButton");
        BankClickAnimationKt.setAnimatedClickListener(bankCardIssueSubmitButton, new Function0() { // from class: com.arizonagames.feature.arizona.bank.pages.BankCardIssuePageController$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit bindClicks$lambda$0$7;
                bindClicks$lambda$0$7 = BankCardIssuePageController.bindClicks$lambda$0$7(BankCardIssuePageController.this);
                return bindClicks$lambda$0$7;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$0(BankCardIssuePageController bankCardIssuePageController) {
        bankCardIssuePageController.onOpenIntroForm.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$1(BankCardIssuePageController bankCardIssuePageController) {
        bankCardIssuePageController.identityAccepted = !bankCardIssuePageController.identityAccepted;
        bankCardIssuePageController.renderState();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$2(BankCardIssuePageController bankCardIssuePageController) {
        bankCardIssuePageController.identityAccepted = !bankCardIssuePageController.identityAccepted;
        bankCardIssuePageController.renderState();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$3(BankCardIssuePageController bankCardIssuePageController) {
        bankCardIssuePageController.policyAccepted = !bankCardIssuePageController.policyAccepted;
        bankCardIssuePageController.renderState();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$4(BankCardIssuePageController bankCardIssuePageController) {
        bankCardIssuePageController.policyAccepted = !bankCardIssuePageController.policyAccepted;
        bankCardIssuePageController.renderState();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$5(BankCardIssuePageController bankCardIssuePageController) {
        bankCardIssuePageController.openSignatureIfAllowed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$6(BankCardIssuePageController bankCardIssuePageController) {
        bankCardIssuePageController.openSignatureIfAllowed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindClicks$lambda$0$7(BankCardIssuePageController bankCardIssuePageController) {
        if (bankCardIssuePageController.isSubmitEnabled()) {
            bankCardIssuePageController.onSubmit.invoke();
        }
        return Unit.INSTANCE;
    }

    private final void renderState() {
        BankCardIssuePageBinding bankCardIssuePageBinding = this.binding;
        bankCardIssuePageBinding.bankCardIssueIntroState.setVisibility(this.isOpenAccountStateVisible ? 0 : 8);
        this.bindingRoot.bankCardIssuePreviewBg.setVisibility(this.isOpenAccountStateVisible ? 0 : 8);
        bankCardIssuePageBinding.bankCardIssueFormContent.setVisibility(this.isOpenAccountStateVisible ? 8 : 0);
        CustomCardView bankCardIssueIdentityCheck = bankCardIssuePageBinding.bankCardIssueIdentityCheck;
        Intrinsics.checkNotNullExpressionValue(bankCardIssueIdentityCheck, "bankCardIssueIdentityCheck");
        ImageView bankCardIssueIdentityCheckmark = bankCardIssuePageBinding.bankCardIssueIdentityCheckmark;
        Intrinsics.checkNotNullExpressionValue(bankCardIssueIdentityCheckmark, "bankCardIssueIdentityCheckmark");
        applyCheckState(bankCardIssueIdentityCheck, bankCardIssueIdentityCheckmark, this.identityAccepted);
        CustomCardView bankCardIssuePolicyCheck = bankCardIssuePageBinding.bankCardIssuePolicyCheck;
        Intrinsics.checkNotNullExpressionValue(bankCardIssuePolicyCheck, "bankCardIssuePolicyCheck");
        ImageView bankCardIssuePolicyCheckmark = bankCardIssuePageBinding.bankCardIssuePolicyCheckmark;
        Intrinsics.checkNotNullExpressionValue(bankCardIssuePolicyCheckmark, "bankCardIssuePolicyCheckmark");
        applyCheckState(bankCardIssuePolicyCheck, bankCardIssuePolicyCheckmark, this.policyAccepted);
        bankCardIssuePageBinding.bankCardIssueSignature.setVisibility(this.signatureCompleted ? 8 : 0);
        bankCardIssuePageBinding.bankCardIssueSignatureCheck.setVisibility(this.signatureCompleted ? 0 : 8);
        bankCardIssuePageBinding.bankCardIssueSignatureCard.setClickable(!this.signatureCompleted);
        bankCardIssuePageBinding.bankCardIssueSignature.setClickable(!this.signatureCompleted);
        bankCardIssuePageBinding.bankCardIssueSignatureCheck.setClickable(false);
        CustomCardView bankCardIssueSubmitButton = bankCardIssuePageBinding.bankCardIssueSubmitButton;
        Intrinsics.checkNotNullExpressionValue(bankCardIssueSubmitButton, "bankCardIssueSubmitButton");
        CustomCardView.changeValidate$default(bankCardIssueSubmitButton, isSubmitEnabled(), 0.0f, 2, null);
    }

    private final void openSignatureIfAllowed() {
        if (this.signatureCompleted) {
            return;
        }
        this.onOpenSignature.invoke();
    }

    private final boolean isSubmitEnabled() {
        return !hasOpenedAccount(this.currentPayload) && this.identityAccepted && this.policyAccepted && this.signatureCompleted;
    }

    private final boolean hasOpenedAccount(BankScreenPayload bankScreenPayload) {
        return BankContractKt.hasOpenedBankAccount(bankScreenPayload);
    }

    private final void applyCheckState(CustomCardView customCardView, View view, boolean z) {
        if (z) {
            customCardView.setBackground(Color.parseColor("#FFF000"));
            customCardView.setBackgroundAlpha(100);
            view.setVisibility(0);
            return;
        }
        customCardView.setBackground(-1);
        customCardView.setBackgroundAlpha(25);
        view.setVisibility(8);
    }
}
