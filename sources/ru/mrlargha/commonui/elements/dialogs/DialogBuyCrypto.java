package ru.mrlargha.commonui.elements.dialogs;

import android.app.Activity;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.DialogBuyCryptoBinding;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.money.MoneyFormatter;
/* compiled from: DialogBuyCrypto.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Z2\u00020\u0001:\u0001ZBG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0019H\u0016J\b\u0010#\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020!H\u0002J\b\u0010%\u001a\u00020!H\u0002J\b\u0010&\u001a\u00020!H\u0002J\b\u0010'\u001a\u00020!H\u0002J\u0010\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u0005H\u0002J\u0017\u0010*\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010,J\u0019\u0010-\u001a\u0004\u0018\u00010\u00072\b\u0010+\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010.J\u0017\u0010/\u001a\u00020!2\b\u00100\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u00101J\u001d\u00102\u001a\b\u0012\u0004\u0012\u000204032\b\u00105\u001a\u0004\u0018\u000106H\u0002¢\u0006\u0002\u00107J\u000f\u00108\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u00109J\b\u0010:\u001a\u00020\u0007H\u0002J\u0010\u0010;\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010<\u001a\u00020!2\u0006\u0010=\u001a\u00020\u0007H\u0016J(\u0010>\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002J$\u0010?\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002J$\u0010@\u001a\u00020\u0014*\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002J\f\u0010A\u001a\u00020B*\u00020\u0007H\u0002J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0007H\u0002J\u0010\u0010F\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0007H\u0002J\f\u0010G\u001a\u00020\u0007*\u00020\u0007H\u0002J\u0010\u0010H\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u0007H\u0002J\u0010\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0007H\u0002J\u0010\u0010K\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0007H\u0002J\u0010\u0010L\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0007H\u0002J\u0017\u0010M\u001a\u0004\u0018\u00010\u00052\u0006\u0010J\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010NJ\u0010\u0010O\u001a\u00020\u00172\u0006\u0010P\u001a\u00020\u0014H\u0002J!\u0010Q\u001a\u0004\u0018\u00010\u0017*\b\u0012\u0004\u0012\u00020S0R2\u0006\u0010=\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010TJ\u0013\u0010U\u001a\u0004\u0018\u00010\u0017*\u00020\u0007H\u0002¢\u0006\u0002\u0010VJ\u0018\u0010W\u001a\u00020\u00172\u0006\u0010X\u001a\u00020\u00172\u0006\u0010Y\u001a\u00020\u0017H\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogBuyCrypto;", "Lru/mrlargha/commonui/elements/dialogs/AbstractDialog;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "caption", "", "infoData", "leftButtonText", "rightButtonText", "sampDialogId", "hintInput", "<init>", "(Landroid/app/Activity;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "dialogLayout", "Landroid/view/View;", "binding", "Lru/mrlargha/commonui/databinding/DialogBuyCryptoBinding;", "dialogInfo", "Lru/mrlargha/commonui/elements/dialogs/DialogBuyCryptoModel;", "placeholder", "resolvedCurrencyRate", "", "keyboardLayoutListenerAttached", "", "keyboardAwareTop", "Ljava/lang/Integer;", "dialogRect", "Landroid/graphics/Rect;", "keyboardLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "setVisibility", "", "visible", "addKeyboardLayoutListener", "removeKeyboardLayoutListener", "updateKeyboardAwarePosition", "setupUi", "updateSummaryFromInput", "dismiss", "responseButtonId", "updateValidationState", "currentValue", "(Ljava/lang/Long;)Z", "buildValidationError", "(Ljava/lang/Long;)Ljava/lang/String;", "updateSummaryCards", "amount", "(Ljava/lang/Long;)V", "buildInputFilters", "", "Landroid/text/InputFilter;", "limits", "Lru/mrlargha/commonui/elements/dialogs/DialogWithdrawLimitModel;", "(Lru/mrlargha/commonui/elements/dialogs/DialogWithdrawLimitModel;)[Landroid/text/InputFilter;", "parseInputAmount", "()Ljava/lang/Long;", "getAmountInput", "resolvePlaceholder", "consumeUserInput", "text", "buildDialogInfo", "withDefaults", "toLegacyDialogInfo", "extractLegacyBody", "Lru/mrlargha/commonui/elements/dialogs/LegacyCryptoBody;", "parseBody", "Lru/mrlargha/commonui/elements/dialogs/ParsedCryptoBody;", TtmlNode.TAG_BODY, "normalizeRichText", "stripColorTags", "containsMoneyToken", "buildDefaultPlaceholder", FirebaseAnalytics.Param.CURRENCY, "resolveCurrencyCodeLabel", "resolveCurrencySuffix", "resolveCurrencyIconRes", "(Ljava/lang/String;)Ljava/lang/Integer;", "resolveCurrencyRate", "info", "firstMoneyValue", "", "Lkotlin/text/Regex;", "(Ljava/util/List;Ljava/lang/String;)Ljava/lang/Long;", "toMoneyLongOrNull", "(Ljava/lang/String;)Ljava/lang/Long;", "safeMultiply", "value", "rate", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogBuyCrypto extends AbstractDialog {
    private static final String BTC_SYMBOL = "₿";
    private static final String DEFAULT_CURRENCY_CODE = "btc";
    private static final long DEFAULT_MAX_INPUT = 999999;
    private static final long DEFAULT_MIN_INPUT = 1;
    private static final String EURO_SYMBOL = "€";
    private static final double KEYBOARD_MIN_HEIGHT_RATIO = 0.15d;
    private static final String TOTAL_COST_PREFIX = "Итого";
    private static final String VC_SYMBOL = "VC";
    private final DialogBuyCryptoBinding binding;
    private final DialogBuyCryptoModel dialogInfo;
    private final View dialogLayout;
    private final Rect dialogRect;
    private Integer keyboardAwareTop;
    private final ViewTreeObserver.OnGlobalLayoutListener keyboardLayoutListener;
    private boolean keyboardLayoutListenerAttached;
    private final String placeholder;
    private final long resolvedCurrencyRate;
    public static final Companion Companion = new Companion(null);
    private static final Regex FRAMED_TEXT_REGEX = new Regex("\\[\\[framed:text=(.*?)\\]\\]", RegexOption.DOT_MATCHES_ALL);
    private static final Regex COLOR_TAG_REGEX = new Regex("\\{[0-9A-Fa-f]{6,8}\\}");
    private static final Regex LEGACY_BALANCE_REGEX = new Regex("(?:\\{[0-9A-Fa-f]{6,8}\\}\\s*)?(.*?(?:\\u0431\\u0430\\u043B\\u0430\\u043D\\u0441|balance).*?)(?:\\{[0-9A-Fa-f]{6,8}\\}\\s*)?(:[A-Za-z]+:\\s*[0-9][0-9\\s.,]*)\\s*", RegexOption.IGNORE_CASE);
    private static final List<Regex> RATE_TEXT_REGEXES = CollectionsKt.listOf((Object[]) new Regex[]{new Regex("1\\s*[^=\\n]*=\\s*(?::[A-Za-z]+:)?\\s*([0-9][0-9\\s.,]*)", RegexOption.IGNORE_CASE), new Regex("1\\s*[^\\n]*(?:\\u0437\\u0430|\\u0441\\u0442\\u043E\\u0438\\u0442|\\u0441\\u043E\\u0441\\u0442\\u0430\\u0432\\u043B\\u044F\\u0435\\u0442|:|-|\\u2013|\\u2014)\\s*(?::[A-Za-z]+:)?\\s*([0-9][0-9\\s.,]*)", RegexOption.IGNORE_CASE), new Regex("(?:\\u043A\\u0443\\u0440\\u0441|\\u0441\\u0442\\u043E\\u0438\\u043C\\u043E\\u0441\\u0442[\\u044C\\u0438]|\\u0446\\u0435\\u043D\\u0430)[^\\n]*?(?::[A-Za-z]+:)?\\s*([0-9][0-9\\s.,]*)", RegexOption.IGNORE_CASE)});

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$0(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogBuyCrypto(Activity targetActivity, int i, String caption, String infoData, String leftButtonText, String rightButtonText, int i2, String hintInput) {
        super(targetActivity, i, i2);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(caption, "caption");
        Intrinsics.checkNotNullParameter(infoData, "infoData");
        Intrinsics.checkNotNullParameter(leftButtonText, "leftButtonText");
        Intrinsics.checkNotNullParameter(rightButtonText, "rightButtonText");
        Intrinsics.checkNotNullParameter(hintInput, "hintInput");
        View inflate = LayoutInflater.from(targetActivity).inflate(R.layout.dialog_buy_crypto, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.dialogLayout = inflate;
        DialogBuyCryptoBinding bind = DialogBuyCryptoBinding.bind(inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        DialogBuyCryptoModel buildDialogInfo = buildDialogInfo(caption, infoData, leftButtonText, rightButtonText);
        this.dialogInfo = buildDialogInfo;
        this.placeholder = resolvePlaceholder(hintInput);
        this.resolvedCurrencyRate = resolveCurrencyRate(buildDialogInfo);
        this.dialogRect = new Rect();
        this.keyboardLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBuyCrypto$$ExternalSyntheticLambda6
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                DialogBuyCrypto.this.updateKeyboardAwarePosition();
            }
        };
        addViewToConstraintLayout(inflate, -2, -2);
        setPosition(SAMPUIElement.PositionType.CENTER, 0, 0);
        setupUi();
        setVisibility(true);
        bind.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBuyCrypto$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogBuyCrypto._init_$lambda$0(view);
            }
        });
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        if (z) {
            addKeyboardLayoutListener();
        } else {
            removeKeyboardLayoutListener();
        }
        super.setVisibility(z);
    }

    private final void addKeyboardLayoutListener() {
        if (this.keyboardLayoutListenerAttached) {
            return;
        }
        ViewTreeObserver viewTreeObserver = this.dialogLayout.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(this.keyboardLayoutListener);
            this.keyboardLayoutListenerAttached = true;
        }
    }

    private final void removeKeyboardLayoutListener() {
        if (this.keyboardLayoutListenerAttached) {
            ViewTreeObserver viewTreeObserver = this.dialogLayout.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnGlobalLayoutListener(this.keyboardLayoutListener);
            }
            this.keyboardLayoutListenerAttached = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateKeyboardAwarePosition() {
        int intValue;
        this.dialogLayout.getWindowVisibleDisplayFrame(this.dialogRect);
        int height = this.dialogLayout.getRootView().getRootView().getHeight();
        if (height <= 0) {
            return;
        }
        if (height - this.dialogRect.bottom <= height * KEYBOARD_MIN_HEIGHT_RATIO) {
            if (this.keyboardAwareTop != null) {
                this.keyboardAwareTop = null;
                setPosition(SAMPUIElement.PositionType.CENTER, 0, 0);
                return;
            }
            return;
        }
        Integer valueOf = Integer.valueOf(this.dialogLayout.getHeight());
        if (valueOf.intValue() <= 0) {
            valueOf = null;
        }
        if (valueOf != null) {
            intValue = valueOf.intValue();
        } else {
            Integer valueOf2 = Integer.valueOf(this.dialogLayout.getMeasuredHeight());
            Integer num = valueOf2.intValue() > 0 ? valueOf2 : null;
            if (num != null) {
                intValue = num.intValue();
            } else {
                this.dialogLayout.post(new Runnable() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBuyCrypto$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        DialogBuyCrypto.updateKeyboardAwarePosition$lambda$2$updateKeyboardAwarePosition(DialogBuyCrypto.this);
                    }
                });
                return;
            }
        }
        int dimensionPixelSize = getTargetActivity().getResources().getDimensionPixelSize(R.dimen._8sdp);
        int coerceAtLeast = RangesKt.coerceAtLeast(Math.min((height - intValue) / 2, (this.dialogRect.bottom - dimensionPixelSize) - intValue), dimensionPixelSize);
        Integer num2 = this.keyboardAwareTop;
        if (num2 != null && num2.intValue() == coerceAtLeast) {
            return;
        }
        this.keyboardAwareTop = Integer.valueOf(coerceAtLeast);
        setPosition(SAMPUIElement.PositionType.CENTER_TOP, 0, coerceAtLeast);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateKeyboardAwarePosition$lambda$2$updateKeyboardAwarePosition(DialogBuyCrypto dialogBuyCrypto) {
        Intrinsics.checkNotNullParameter(dialogBuyCrypto, "<this>");
        dialogBuyCrypto.updateKeyboardAwarePosition();
    }

    private final void setupUi() {
        final DialogBuyCryptoBinding dialogBuyCryptoBinding = this.binding;
        ParsedCryptoBody parseBody = parseBody(this.dialogInfo.getBody());
        DialogBuyCryptoHeaderInfo headerInfo = this.dialogInfo.getHeaderInfo();
        String value = headerInfo != null ? headerInfo.getValue() : null;
        if (value == null) {
            value = "";
        }
        String normalizeRichText = normalizeRichText(value);
        Integer resolveCurrencyIconRes = resolveCurrencyIconRes(this.dialogInfo.getCurrency());
        boolean containsMoneyToken = containsMoneyToken(normalizeRichText);
        dialogBuyCryptoBinding.caption.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, normalizeRichText(this.dialogInfo.getHeader()), 0.0f, null, 3, null));
        dialogBuyCryptoBinding.bodyText.setMovementMethod(new ScrollingMovementMethod());
        dialogBuyCryptoBinding.bodyText.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, normalizeRichText(parseBody.getBodyText()), 0.8f, null, 2, null));
        TextView bodyText = dialogBuyCryptoBinding.bodyText;
        Intrinsics.checkNotNullExpressionValue(bodyText, "bodyText");
        bodyText.setVisibility(!StringsKt.isBlank(parseBody.getBodyText()) ? 0 : 8);
        CustomCardView availabilityCard = dialogBuyCryptoBinding.availabilityCard;
        Intrinsics.checkNotNullExpressionValue(availabilityCard, "availabilityCard");
        availabilityCard.setVisibility(!StringsKt.isBlank(parseBody.getFramedText()) ? 0 : 8);
        dialogBuyCryptoBinding.availabilityText.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, normalizeRichText(parseBody.getFramedText()), 0.8f, null, 2, null));
        boolean z = true;
        boolean z2 = (headerInfo == null || (StringsKt.isBlank(headerInfo.getText()) && StringsKt.isBlank(headerInfo.getValue()))) ? false : true;
        LinearLayout headerInfoContainer = dialogBuyCryptoBinding.headerInfoContainer;
        Intrinsics.checkNotNullExpressionValue(headerInfoContainer, "headerInfoContainer");
        headerInfoContainer.setVisibility(z2 ? 0 : 8);
        TextView textView = dialogBuyCryptoBinding.headerInfoLabel;
        ChatEmoji chatEmoji = ChatEmoji.INSTANCE;
        String text = headerInfo != null ? headerInfo.getText() : null;
        textView.setText(ChatEmoji.toSpannable$default(chatEmoji, normalizeRichText(text != null ? text : ""), 0.0f, null, 3, null));
        dialogBuyCryptoBinding.headerInfoValue.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, normalizeRichText, 0.8f, null, 2, null));
        ImageView ivCurrency = dialogBuyCryptoBinding.ivCurrency;
        Intrinsics.checkNotNullExpressionValue(ivCurrency, "ivCurrency");
        ImageView imageView = ivCurrency;
        if (!z2 || containsMoneyToken || resolveCurrencyIconRes == null) {
            z = false;
        }
        imageView.setVisibility(z ? 0 : 8);
        if (resolveCurrencyIconRes != null) {
            ImageView ivCurrency2 = dialogBuyCryptoBinding.ivCurrency;
            Intrinsics.checkNotNullExpressionValue(ivCurrency2, "ivCurrency");
            ivCurrency2.setImageResource(resolveCurrencyIconRes.intValue());
        }
        dialogBuyCryptoBinding.amountSuffix.setText(resolveCurrencySuffix(this.dialogInfo.getCurrency()));
        EditText editText = dialogBuyCryptoBinding.amountInput;
        String str = this.placeholder;
        if (StringsKt.isBlank(str)) {
            str = buildDefaultPlaceholder(this.dialogInfo.getCurrency());
        }
        editText.setHint(str);
        dialogBuyCryptoBinding.amountInput.setFilters(buildInputFilters(this.dialogInfo.getLimits()));
        CustomCardView primaryButton = dialogBuyCryptoBinding.primaryButton;
        Intrinsics.checkNotNullExpressionValue(primaryButton, "primaryButton");
        primaryButton.setVisibility(!StringsKt.isBlank(this.dialogInfo.getPrimaryButton()) ? 0 : 8);
        dialogBuyCryptoBinding.primaryButtonText.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, normalizeRichText(this.dialogInfo.getPrimaryButton()), 0.0f, null, 3, null));
        CustomCardView secondaryButton = dialogBuyCryptoBinding.secondaryButton;
        Intrinsics.checkNotNullExpressionValue(secondaryButton, "secondaryButton");
        secondaryButton.setVisibility(!StringsKt.isBlank(this.dialogInfo.getSecondaryButton()) ? 0 : 8);
        dialogBuyCryptoBinding.secondaryButtonText.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, normalizeRichText(this.dialogInfo.getSecondaryButton()), 0.0f, null, 3, null));
        CustomCardView primaryButton2 = dialogBuyCryptoBinding.primaryButton;
        Intrinsics.checkNotNullExpressionValue(primaryButton2, "primaryButton");
        CustomCardView.changeValidate$default(primaryButton2, false, 0.0f, 2, null);
        TextView validationText = dialogBuyCryptoBinding.validationText;
        Intrinsics.checkNotNullExpressionValue(validationText, "validationText");
        validationText.setVisibility(8);
        updateSummaryFromInput();
        EditText amountInput = dialogBuyCryptoBinding.amountInput;
        Intrinsics.checkNotNullExpressionValue(amountInput, "amountInput");
        amountInput.addTextChangedListener(new TextWatcher() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBuyCrypto$setupUi$lambda$0$$inlined$doAfterTextChanged$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Long parseInputAmount;
                parseInputAmount = DialogBuyCrypto.this.parseInputAmount();
                DialogBuyCrypto.this.updateSummaryCards(parseInputAmount);
                DialogBuyCrypto.this.updateValidationState(parseInputAmount);
            }
        });
        dialogBuyCryptoBinding.amountInput.post(new Runnable() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBuyCrypto$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                DialogBuyCrypto.this.updateSummaryFromInput();
            }
        });
        dialogBuyCryptoBinding.amountInput.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBuyCrypto$$ExternalSyntheticLambda10
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                boolean z3;
                z3 = DialogBuyCrypto.setupUi$lambda$0$3(DialogBuyCrypto.this, dialogBuyCryptoBinding, textView2, i, keyEvent);
                return z3;
            }
        });
        dialogBuyCryptoBinding.primaryButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBuyCrypto$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogBuyCrypto.setupUi$lambda$0$4(DialogBuyCrypto.this, view);
            }
        });
        dialogBuyCryptoBinding.secondaryButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBuyCrypto$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogBuyCrypto.this.dismiss(0);
            }
        });
        dialogBuyCryptoBinding.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBuyCrypto$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogBuyCrypto.this.dismiss(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupUi$lambda$0$3(DialogBuyCrypto dialogBuyCrypto, DialogBuyCryptoBinding dialogBuyCryptoBinding, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 5 || i == 6) {
            SAMPUIElement.Companion.hideKeyboard(dialogBuyCrypto.getTargetActivity());
            dialogBuyCryptoBinding.primaryButton.performClick();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUi$lambda$0$4(DialogBuyCrypto dialogBuyCrypto, View view) {
        SAMPUIElement.Companion.hideKeyboard(dialogBuyCrypto.getTargetActivity());
        Long parseInputAmount = dialogBuyCrypto.parseInputAmount();
        dialogBuyCrypto.updateSummaryCards(parseInputAmount);
        if (dialogBuyCrypto.updateValidationState(parseInputAmount)) {
            dialogBuyCrypto.dismiss(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSummaryFromInput() {
        updateSummaryCards(parseInputAmount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismiss(int i) {
        SAMPUIElement.Companion.hideKeyboard(getTargetActivity());
        getNotifier().onDialogResponseWrapper(getSampDialogId(), i, -1, StringsKt.encodeToByteArray(getAmountInput()));
        getNotifier().destroyDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean updateValidationState(Long l) {
        String buildValidationError = buildValidationError(l);
        TextView validationText = this.binding.validationText;
        Intrinsics.checkNotNullExpressionValue(validationText, "validationText");
        String str = buildValidationError;
        boolean z = true;
        validationText.setVisibility(!(str == null || str.length() == 0) ? 0 : 8);
        this.binding.validationText.setText(str);
        if (l == null || buildValidationError != null) {
            z = false;
        }
        CustomCardView primaryButton = this.binding.primaryButton;
        Intrinsics.checkNotNullExpressionValue(primaryButton, "primaryButton");
        CustomCardView.changeValidate$default(primaryButton, z, 0.0f, 2, null);
        return z;
    }

    private final String buildValidationError(Long l) {
        if (l == null) {
            return null;
        }
        String resolveCurrencyCodeLabel = resolveCurrencyCodeLabel(this.dialogInfo.getCurrency());
        DialogWithdrawLimitModel limits = this.dialogInfo.getLimits();
        long max = Math.max(1L, limits != null ? limits.getMinMoney() : 1L);
        DialogWithdrawLimitModel limits2 = this.dialogInfo.getLimits();
        long max2 = Math.max(max, limits2 != null ? limits2.getMaxMoney() : DEFAULT_MAX_INPUT);
        if (l.longValue() < max) {
            return getTargetActivity().getString(R.string.dialog_buy_crypto_minimum, new Object[]{String.valueOf(max), resolveCurrencyCodeLabel});
        }
        if (l.longValue() > max2) {
            return getTargetActivity().getString(R.string.dialog_buy_crypto_maximum, new Object[]{String.valueOf(max2), resolveCurrencyCodeLabel});
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSummaryCards(Long l) {
        DialogBuyCryptoBinding dialogBuyCryptoBinding = this.binding;
        dialogBuyCryptoBinding.summaryDollars.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, "Итого: :cash:" + MoneyFormatter.INSTANCE.formatPlain(safeMultiply(l != null ? l.longValue() : 0L, this.resolvedCurrencyRate)), 0.8f, null, 2, null));
    }

    private final InputFilter[] buildInputFilters(DialogWithdrawLimitModel dialogWithdrawLimitModel) {
        final long max = Math.max(Math.max(1L, dialogWithdrawLimitModel != null ? dialogWithdrawLimitModel.getMinMoney() : 1L), dialogWithdrawLimitModel != null ? dialogWithdrawLimitModel.getMaxMoney() : DEFAULT_MAX_INPUT);
        return new InputFilter[]{new InputFilter.LengthFilter(RangesKt.coerceAtLeast(String.valueOf(max).length(), 1)), new InputFilter() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBuyCrypto$$ExternalSyntheticLambda5
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return DialogBuyCrypto.buildInputFilters$lambda$0(max, charSequence, i, i2, spanned, i3, i4);
            }
        }};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence buildInputFilters$lambda$0(long j, CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        String sb = new StringBuilder(spanned).replace(i3, i4, charSequence.subSequence(i, i2).toString()).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        if (sb.length() == 0) {
            return null;
        }
        Long longOrNull = StringsKt.toLongOrNull(sb);
        if (longOrNull == null || longOrNull.longValue() > j) {
            return "";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Long parseInputAmount() {
        String amountInput = getAmountInput();
        if (amountInput.length() <= 0) {
            amountInput = null;
        }
        if (amountInput != null) {
            return StringsKt.toLongOrNull(amountInput);
        }
        return null;
    }

    private final String getAmountInput() {
        String str;
        String obj;
        Editable text = this.binding.amountInput.getText();
        if (text == null || (obj = text.toString()) == null) {
            str = null;
        } else {
            String str2 = obj;
            StringBuilder sb = new StringBuilder();
            int length = str2.length();
            for (int i = 0; i < length; i++) {
                char charAt = str2.charAt(i);
                if (Character.isDigit(charAt)) {
                    sb.append(charAt);
                }
            }
            str = sb.toString();
        }
        return str == null ? "" : str;
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void consumeUserInput(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        setVisibility(true);
        EditText editText = this.binding.amountInput;
        String str = text;
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        editText.setText(sb.toString());
        this.binding.primaryButton.performClick();
    }

    private final DialogBuyCryptoModel withDefaults(DialogBuyCryptoModel dialogBuyCryptoModel, String str, String str2, String str3) {
        LegacyCryptoBody extractLegacyBody = extractLegacyBody(dialogBuyCryptoModel.getBody());
        String header = dialogBuyCryptoModel.getHeader();
        if (StringsKt.isBlank(header)) {
            header = str;
        }
        String str4 = header;
        DialogBuyCryptoHeaderInfo headerInfo = dialogBuyCryptoModel.getHeaderInfo();
        if (headerInfo == null) {
            headerInfo = extractLegacyBody.getHeaderInfo();
        }
        DialogBuyCryptoHeaderInfo dialogBuyCryptoHeaderInfo = headerInfo;
        String body = extractLegacyBody.getBody();
        String primaryButton = dialogBuyCryptoModel.getPrimaryButton();
        if (StringsKt.isBlank(primaryButton)) {
            primaryButton = str2;
        }
        String str5 = primaryButton;
        String secondaryButton = dialogBuyCryptoModel.getSecondaryButton();
        if (StringsKt.isBlank(secondaryButton)) {
            secondaryButton = str3;
        }
        return DialogBuyCryptoModel.copy$default(dialogBuyCryptoModel, 0, str4, dialogBuyCryptoHeaderInfo, body, 0L, null, str5, secondaryButton, null, 305, null);
    }

    private final DialogBuyCryptoModel toLegacyDialogInfo(String str, String str2, String str3, String str4) {
        LegacyCryptoBody extractLegacyBody = extractLegacyBody(str);
        return new DialogBuyCryptoModel(0, str2, extractLegacyBody.getHeaderInfo(), extractLegacyBody.getBody(), 0L, null, str3, str4, null, 305, null);
    }

    private final LegacyCryptoBody extractLegacyBody(String str) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        return new LegacyCryptoBody((DialogBuyCryptoHeaderInfo) objectRef.element, StringsKt.trim((CharSequence) SequencesKt.joinToString$default(SequencesKt.mapNotNull(StringsKt.lineSequence(str), new Function1() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBuyCrypto$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DialogBuyCrypto.extractLegacyBody$lambda$0(Ref.ObjectRef.this, this, (String) obj);
            }
        }), "\n", null, null, 0, null, null, 62, null)).toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, ru.mrlargha.commonui.elements.dialogs.DialogBuyCryptoHeaderInfo] */
    public static final String extractLegacyBody$lambda$0(Ref.ObjectRef objectRef, DialogBuyCrypto dialogBuyCrypto, String line) {
        Intrinsics.checkNotNullParameter(line, "line");
        MatchResult matchEntire = LEGACY_BALANCE_REGEX.matchEntire(StringsKt.trim((CharSequence) line).toString());
        if (matchEntire == null || objectRef.element != 0) {
            return line;
        }
        objectRef.element = new DialogBuyCryptoHeaderInfo(StringsKt.trim((CharSequence) dialogBuyCrypto.stripColorTags(matchEntire.getGroupValues().get(1))).toString(), StringsKt.trim((CharSequence) matchEntire.getGroupValues().get(2)).toString());
        return null;
    }

    private final ParsedCryptoBody parseBody(String str) {
        Regex regex = FRAMED_TEXT_REGEX;
        String str2 = str;
        return new ParsedCryptoBody(SequencesKt.joinToString$default(SequencesKt.filter(SequencesKt.mapNotNull(Regex.findAll$default(regex, str2, 0, 2, null), new Function1() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBuyCrypto$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DialogBuyCrypto.parseBody$lambda$0((MatchResult) obj);
            }
        }), new Function1() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogBuyCrypto$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(DialogBuyCrypto.parseBody$lambda$1((String) obj));
            }
        }), "\n", null, null, 0, null, null, 62, null), StringsKt.trim((CharSequence) regex.replace(str2, "")).toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String parseBody$lambda$0(MatchResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String str = (String) CollectionsKt.getOrNull(it.getGroupValues(), 1);
        if (str != null) {
            return StringsKt.trim((CharSequence) str).toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean parseBody$lambda$1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !StringsKt.isBlank(it);
    }

    private final String normalizeRichText(String str) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str, "&nbsp;", " ", false, 4, (Object) null), "&nbsp", " ", false, 4, (Object) null), ":M:", ":kkk:", false, 4, (Object) null), ":KK:", ":kk:", false, 4, (Object) null), ":K:", ":k:", false, 4, (Object) null);
    }

    private final String stripColorTags(String str) {
        return COLOR_TAG_REGEX.replace(str, "");
    }

    private final boolean containsMoneyToken(String str) {
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = str.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str2 = lowerCase;
        return StringsKt.contains$default((CharSequence) str2, (CharSequence) ":kkk:", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) ":kk:", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) ":k:", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) ":cash:", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) ":cashv:", false, 2, (Object) null);
    }

    private final String buildDefaultPlaceholder(String str) {
        String string = getTargetActivity().getString(R.string.dialog_buy_crypto_placeholder_default, new Object[]{resolveCurrencyCodeLabel(str)});
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    private final String resolveCurrencyCodeLabel(String str) {
        String str2 = str;
        if (StringsKt.isBlank(str2)) {
            str2 = DEFAULT_CURRENCY_CODE;
        }
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String upperCase = str2.toUpperCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    private final String resolveCurrencySuffix(String str) {
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = str.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int hashCode = lowerCase.hashCode();
        if (hashCode != 3757) {
            if (hashCode != 97873) {
                if (hashCode != 100802) {
                    if (hashCode == 3124973 && lowerCase.equals("euro")) {
                        return EURO_SYMBOL;
                    }
                } else if (lowerCase.equals("eur")) {
                    return EURO_SYMBOL;
                }
            } else if (lowerCase.equals(DEFAULT_CURRENCY_CODE)) {
                return BTC_SYMBOL;
            }
        } else if (lowerCase.equals("vc")) {
            return VC_SYMBOL;
        }
        return resolveCurrencyCodeLabel(str);
    }

    private final Integer resolveCurrencyIconRes(String str) {
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = str.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int hashCode = lowerCase.hashCode();
        if (hashCode == 3757) {
            if (lowerCase.equals("vc")) {
                return Integer.valueOf(R.drawable.currency_ic_vc);
            }
            return null;
        } else if (hashCode == 97873) {
            if (lowerCase.equals(DEFAULT_CURRENCY_CODE)) {
                return Integer.valueOf(R.drawable.currency_ic_btc);
            }
            return null;
        } else {
            if (hashCode != 100802) {
                if (hashCode != 3124973 || !lowerCase.equals("euro")) {
                    return null;
                }
            } else if (!lowerCase.equals("eur")) {
                return null;
            }
            return Integer.valueOf(R.drawable.currency_ic_euro);
        }
    }

    private final long resolveCurrencyRate(DialogBuyCryptoModel dialogBuyCryptoModel) {
        Long valueOf = Long.valueOf(dialogBuyCryptoModel.getCurrencyRate());
        if (valueOf.longValue() <= 0) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.longValue();
        }
        List<Regex> list = RATE_TEXT_REGEXES;
        Long firstMoneyValue = firstMoneyValue(list, dialogBuyCryptoModel.getBody());
        if (firstMoneyValue != null) {
            return firstMoneyValue.longValue();
        }
        String header = dialogBuyCryptoModel.getHeader();
        DialogBuyCryptoHeaderInfo headerInfo = dialogBuyCryptoModel.getHeaderInfo();
        String value = headerInfo != null ? headerInfo.getValue() : null;
        if (value == null) {
            value = "";
        }
        Long firstMoneyValue2 = firstMoneyValue(list, header + " " + value);
        if (firstMoneyValue2 != null) {
            return firstMoneyValue2.longValue();
        }
        return 0L;
    }

    private final Long firstMoneyValue(List<Regex> list, String str) {
        Long l;
        List<String> groupValues;
        String str2;
        Iterator<T> it = list.iterator();
        do {
            l = null;
            if (!it.hasNext()) {
                break;
            }
            MatchResult find$default = Regex.find$default((Regex) it.next(), str, 0, 2, null);
            if (find$default != null && (groupValues = find$default.getGroupValues()) != null && (str2 = (String) CollectionsKt.getOrNull(groupValues, 1)) != null) {
                l = toMoneyLongOrNull(str2);
                continue;
            }
        } while (l == null);
        return l;
    }

    private final long safeMultiply(long j, long j2) {
        if (j <= 0 || j2 <= 0) {
            return 0L;
        }
        if (Long.MAX_VALUE / j < j2) {
            return Long.MAX_VALUE;
        }
        return j * j2;
    }

    /* compiled from: DialogBuyCrypto.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogBuyCrypto$Companion;", "", "<init>", "()V", "FRAMED_TEXT_REGEX", "Lkotlin/text/Regex;", "COLOR_TAG_REGEX", "LEGACY_BALANCE_REGEX", "RATE_TEXT_REGEXES", "", "KEYBOARD_MIN_HEIGHT_RATIO", "", "TOTAL_COST_PREFIX", "", "DEFAULT_MIN_INPUT", "", "DEFAULT_MAX_INPUT", "DEFAULT_CURRENCY_CODE", "BTC_SYMBOL", "EURO_SYMBOL", "VC_SYMBOL", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final String resolvePlaceholder(String str) {
        DialogPlaceholderModel dialogPlaceholderModel = (DialogPlaceholderModel) ((!MapperKt.isJsonValid(str) || Intrinsics.areEqual(str, AbstractJsonLexerKt.NULL) || Intrinsics.areEqual(str, "{}") || str.length() == 0) ? null : MapperKt.getGson().fromJson(str, (Class<Object>) DialogPlaceholderModel.class));
        String placeholder = dialogPlaceholderModel != null ? dialogPlaceholderModel.getPlaceholder() : null;
        if (placeholder == null) {
            placeholder = "";
        }
        if (StringsKt.isBlank(placeholder)) {
            String str2 = str;
            return (StringsKt.isBlank(str2) || StringsKt.startsWith$default(StringsKt.trim((CharSequence) str2).toString(), "{", false, 2, (Object) null) || StringsKt.startsWith$default(StringsKt.trim((CharSequence) str2).toString(), "[", false, 2, (Object) null)) ? "" : str;
        }
        return placeholder;
    }

    private final DialogBuyCryptoModel buildDialogInfo(String str, String str2, String str3, String str4) {
        DialogBuyCryptoModel withDefaults;
        DialogBuyCryptoModel dialogBuyCryptoModel = (DialogBuyCryptoModel) ((!MapperKt.isJsonValid(str2) || Intrinsics.areEqual(str2, AbstractJsonLexerKt.NULL) || Intrinsics.areEqual(str2, "{}") || str2.length() == 0) ? null : MapperKt.getGson().fromJson(str2, (Class<Object>) DialogBuyCryptoModel.class));
        return (dialogBuyCryptoModel == null || (withDefaults = withDefaults(dialogBuyCryptoModel, str, str3, str4)) == null) ? toLegacyDialogInfo(str2, str, str3, str4) : withDefaults;
    }

    private final Long toMoneyLongOrNull(String str) {
        String str2 = str;
        StringBuilder sb = new StringBuilder();
        int length = str2.length();
        for (int i = 0; i < length; i++) {
            char charAt = str2.charAt(i);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        if (sb2.length() <= 0) {
            sb2 = null;
        }
        if (sb2 != null) {
            return StringsKt.toLongOrNull(sb2);
        }
        return null;
    }
}
