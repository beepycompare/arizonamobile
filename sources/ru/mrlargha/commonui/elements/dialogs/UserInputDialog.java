package ru.mrlargha.commonui.elements.dialogs;

import android.app.Activity;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.autofill.HintConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.InputDialogBinding;
import ru.mrlargha.commonui.elements.dialogs.UserInputDialogResponseCodec;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.ui.money.MoneyElementKt;
/* compiled from: UserInputDialog.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 =2\u00020\u0001:\u0001=BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\"\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000fH\u0002J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002J\u0010\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020\u0005H\u0002J\b\u0010)\u001a\u00020\u000fH\u0002J\u0012\u0010*\u001a\u00020%2\b\u0010+\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.H\u0002J\u001d\u0010/\u001a\b\u0012\u0004\u0012\u000201002\b\u00102\u001a\u0004\u0018\u000103H\u0002¢\u0006\u0002\u00104J\n\u00105\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020\u000fH\u0002J\u0010\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020\fH\u0016J\b\u0010:\u001a\u00020%H\u0002J\b\u0010;\u001a\u00020%H\u0002J\u0010\u0010<\u001a\u00020%2\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/UserInputDialog;", "Lru/mrlargha/commonui/elements/dialogs/AbstractDialog;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "caption", "Landroid/text/SpannableString;", "info", "leftButtonText", "rightButtonText", "passwordMode", "", "sampDialogId", "hintInput", "", "<init>", "(Landroid/app/Activity;ILandroid/text/SpannableString;Landroid/text/SpannableString;Landroid/text/SpannableString;Landroid/text/SpannableString;ZILjava/lang/String;)V", "dialogLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/commonui/databinding/InputDialogBinding;", "text", "isKeyboardShowing", "keyboardLayoutListenerAttached", "placeholderModel", "Lru/mrlargha/commonui/elements/dialogs/DialogPlaceholderModel;", "dialogRect", "Landroid/graphics/Rect;", "keyboardLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "setupHintInput", "Landroid/text/TextWatcher;", "resolveMainInputHint", "moneyTitle", "bindHeaderInfo", "", "updateTransferCommission", "updateKeyboardOffset", "keyboardTop", "getResponseInput", "restoreInputHistory", "input", "applyDecodedInput", "decodedInput", "Lru/mrlargha/commonui/elements/dialogs/UserInputDialogResponseCodec$DecodedInput;", "buildMoneyInputFilters", "", "Landroid/text/InputFilter;", "limits", "Lru/mrlargha/commonui/elements/dialogs/DialogWithdrawLimitModel;", "(Lru/mrlargha/commonui/elements/dialogs/DialogWithdrawLimitModel;)[Landroid/text/InputFilter;", "getPassword", "savePassword", HintConstants.AUTOFILL_HINT_NEW_PASSWORD, "setVisibility", "visible", "addKeyboardLayoutListener", "removeKeyboardLayoutListener", "consumeUserInput", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UserInputDialog extends AbstractDialog {
    private static final int PASSWORD_SEND_RETRY_COUNT = 2;
    public static final String PASSWORD_SP_NAME = "PASSWORD_SP_FIELD";
    private static final String TAG = "UserInputDialog";
    private static int passwordDialogShowTimes;
    private final InputDialogBinding binding;
    private final View dialogLayout;
    private final Rect dialogRect;
    private boolean isKeyboardShowing;
    private final ViewTreeObserver.OnGlobalLayoutListener keyboardLayoutListener;
    private boolean keyboardLayoutListenerAttached;
    private final boolean passwordMode;
    private final DialogPlaceholderModel placeholderModel;
    private String text;
    public static final Companion Companion = new Companion(null);
    private static final Map<Integer, String> inputHistory = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$0(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserInputDialog(final Activity targetActivity, int i, SpannableString caption, SpannableString info, SpannableString leftButtonText, SpannableString rightButtonText, boolean z, final int i2, final String hintInput) {
        super(targetActivity, i, i2);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(caption, "caption");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(leftButtonText, "leftButtonText");
        Intrinsics.checkNotNullParameter(rightButtonText, "rightButtonText");
        Intrinsics.checkNotNullParameter(hintInput, "hintInput");
        this.passwordMode = z;
        View dialogLayout = LayoutInflater.from(targetActivity).inflate(R.layout.input_dialog, (ViewGroup) null, false);
        this.dialogLayout = dialogLayout;
        final InputDialogBinding bind = InputDialogBinding.bind(dialogLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.text = "";
        this.placeholderModel = Companion.toModelOrNull(hintInput);
        this.dialogRect = new Rect();
        this.keyboardLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ru.mrlargha.commonui.elements.dialogs.UserInputDialog$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                UserInputDialog.keyboardLayoutListener$lambda$0(hintInput, this);
            }
        };
        Intrinsics.checkNotNullExpressionValue(dialogLayout, "dialogLayout");
        addViewToConstraintLayout(dialogLayout, -2, -2);
        setPosition(SAMPUIElement.PositionType.CENTER, 0, 0);
        bind.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.UserInputDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInputDialog.lambda$0$0(view);
            }
        });
        SpannableString spannableString = info;
        bind.infoText.setText(spannableString);
        bind.infoText.setMovementMethod(new ScrollingMovementMethod());
        TextView infoText = bind.infoText;
        Intrinsics.checkNotNullExpressionValue(infoText, "infoText");
        infoText.setVisibility(!StringsKt.isBlank(spannableString) ? 0 : 8);
        bind.caption.setText(caption);
        setVisibility(true);
        if (z) {
            bind.textInputLayout.setEndIconMode(1);
            bind.textInputLayout.setEndIconVisible(true);
            bind.textInputLayout.setEndIconMinSize(1);
            bind.userInput.setTransformationMethod(PasswordTransformationMethod.getInstance());
            passwordDialogShowTimes++;
            String password = getPassword();
            if (password != null && passwordDialogShowTimes < 2 && i2 == 2) {
                getNotifier().onDialogResponseWrapper(i2, 1, -1, StringsKt.encodeToByteArray(password));
                setVisibility(false);
                getNotifier().destroyDialog();
            }
        }
        SpannableString spannableString2 = leftButtonText;
        if (spannableString2.length() == 0) {
            bind.buttons.button1.setVisibility(8);
        } else {
            bind.buttons.tvAccept.setText(spannableString2);
            bind.buttons.button1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.UserInputDialog$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserInputDialog.lambda$0$2(targetActivity, this, i2, bind, view);
                }
            });
        }
        SpannableString spannableString3 = rightButtonText;
        if (spannableString3.length() == 0) {
            bind.buttons.button2.setVisibility(8);
        } else {
            bind.buttons.tvCancel.setText(spannableString3);
            bind.buttons.button2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.UserInputDialog$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserInputDialog.lambda$0$3(targetActivity, this, i2, view);
                }
            });
        }
        bind.findPlayerInput.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.commonui.elements.dialogs.UserInputDialog$$ExternalSyntheticLambda5
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                return UserInputDialog.lambda$0$4(InputDialogBinding.this, textView, i3, keyEvent);
            }
        });
        bind.userInput.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.commonui.elements.dialogs.UserInputDialog$$ExternalSyntheticLambda6
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                return UserInputDialog.lambda$0$5(targetActivity, bind, textView, i3, keyEvent);
            }
        });
        setupHintInput(hintInput);
        if (z || !((IAutocompleteStateProvider) targetActivity).getAutocompleteState()) {
            return;
        }
        restoreInputHistory(inputHistory.get(Integer.valueOf(i2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void keyboardLayoutListener$lambda$0(String str, UserInputDialog userInputDialog) {
        try {
            Log.d(TAG, "hintInput: " + str);
            userInputDialog.dialogLayout.getWindowVisibleDisplayFrame(userInputDialog.dialogRect);
            int height = userInputDialog.dialogLayout.getRootView().getRootView().getHeight();
            if (height <= 0) {
                return;
            }
            if (height - userInputDialog.dialogRect.bottom > height * 0.15d) {
                if (!userInputDialog.isKeyboardShowing) {
                    Log.d(TAG, "Keyboard was shown");
                    userInputDialog.isKeyboardShowing = true;
                }
                userInputDialog.updateKeyboardOffset(userInputDialog.dialogRect.bottom);
            } else if (userInputDialog.isKeyboardShowing) {
                Log.d(TAG, "Keyboard was closed");
                userInputDialog.isKeyboardShowing = false;
                userInputDialog.setPosition(SAMPUIElement.PositionType.CENTER, 0, 0);
                userInputDialog.dialogLayout.setTranslationY(0.0f);
            }
        } catch (OutOfMemoryError e) {
            Log.e(TAG, "Unable to update dialog keyboard layout due to low memory", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$2(Activity activity, UserInputDialog userInputDialog, int i, InputDialogBinding inputDialogBinding, View view) {
        SAMPUIElement.Companion.hideKeyboard(activity);
        if (!userInputDialog.passwordMode) {
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.dialogs.IAutocompleteStateProvider");
            if (((IAutocompleteStateProvider) activity).getAutocompleteState()) {
                inputHistory.put(Integer.valueOf(i), userInputDialog.getResponseInput());
            }
        }
        userInputDialog.getNotifier().onDialogResponseWrapper(i, 1, -1, StringsKt.encodeToByteArray(userInputDialog.getResponseInput()));
        userInputDialog.getNotifier().destroyDialog();
        if (userInputDialog.passwordMode) {
            userInputDialog.savePassword(inputDialogBinding.userInput.getText().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$3(Activity activity, UserInputDialog userInputDialog, int i, View view) {
        SAMPUIElement.Companion.hideKeyboard(activity);
        userInputDialog.getNotifier().onDialogResponseWrapper(i, 0, -1, StringsKt.encodeToByteArray(userInputDialog.getResponseInput()));
        userInputDialog.getNotifier().destroyDialog();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$4(InputDialogBinding inputDialogBinding, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 5 || i == 6) {
            inputDialogBinding.userInput.requestFocus();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$5(Activity activity, InputDialogBinding inputDialogBinding, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 5 || i == 6) {
            SAMPUIElement.Companion.hideKeyboard(activity);
            inputDialogBinding.buttons.button1.requestFocus();
            inputDialogBinding.buttons.button1.performClick();
            return true;
        }
        return true;
    }

    private final TextWatcher setupHintInput(String str) {
        InputDialogBinding inputDialogBinding = this.binding;
        DialogPlaceholderModel dialogPlaceholderModel = this.placeholderModel;
        String moneyTitle = dialogPlaceholderModel != null ? dialogPlaceholderModel.getMoneyTitle() : null;
        if (moneyTitle == null) {
            moneyTitle = "";
        }
        DialogPlaceholderModel dialogPlaceholderModel2 = this.placeholderModel;
        String findPlayerTitle = dialogPlaceholderModel2 != null ? dialogPlaceholderModel2.getFindPlayerTitle() : null;
        String str2 = findPlayerTitle != null ? findPlayerTitle : "";
        boolean isBlank = StringsKt.isBlank(str2);
        TextView findPlayerTitle2 = inputDialogBinding.findPlayerTitle;
        Intrinsics.checkNotNullExpressionValue(findPlayerTitle2, "findPlayerTitle");
        findPlayerTitle2.setVisibility(!isBlank ? 0 : 8);
        LinearLayout findPlayerInputRow = inputDialogBinding.findPlayerInputRow;
        Intrinsics.checkNotNullExpressionValue(findPlayerInputRow, "findPlayerInputRow");
        findPlayerInputRow.setVisibility(!isBlank ? 0 : 8);
        inputDialogBinding.findPlayerTitle.setText(str2);
        inputDialogBinding.findPlayerInput.setHint(str2);
        LinearLayout moneyTitleContainer = inputDialogBinding.moneyTitleContainer;
        Intrinsics.checkNotNullExpressionValue(moneyTitleContainer, "moneyTitleContainer");
        String str3 = moneyTitle;
        moneyTitleContainer.setVisibility(StringsKt.isBlank(str3) ? 8 : 0);
        inputDialogBinding.moneyTitle.setText(str3);
        inputDialogBinding.userInput.setHint(resolveMainInputHint(str, moneyTitle));
        if (!this.passwordMode) {
            DialogPlaceholderModel dialogPlaceholderModel3 = this.placeholderModel;
            if ((dialogPlaceholderModel3 != null ? dialogPlaceholderModel3.getLimits() : null) != null || !StringsKt.isBlank(str3)) {
                inputDialogBinding.userInput.setInputType(2);
                EditText editText = inputDialogBinding.userInput;
                InputFilter[] filters = inputDialogBinding.userInput.getFilters();
                Intrinsics.checkNotNullExpressionValue(filters, "getFilters(...)");
                InputFilter[] inputFilterArr = filters;
                DialogPlaceholderModel dialogPlaceholderModel4 = this.placeholderModel;
                editText.setFilters((InputFilter[]) ArraysKt.plus((Object[]) inputFilterArr, (Object[]) buildMoneyInputFilters(dialogPlaceholderModel4 != null ? dialogPlaceholderModel4.getLimits() : null)));
            }
        }
        bindHeaderInfo();
        updateTransferCommission();
        EditText userInput = inputDialogBinding.userInput;
        Intrinsics.checkNotNullExpressionValue(userInput, "userInput");
        TextWatcher textWatcher = new TextWatcher() { // from class: ru.mrlargha.commonui.elements.dialogs.UserInputDialog$setupHintInput$lambda$0$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                UserInputDialog.this.updateTransferCommission();
            }
        };
        userInput.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    private final String resolveMainInputHint(String str, String str2) {
        DialogPlaceholderModel dialogPlaceholderModel = this.placeholderModel;
        String placeholder = dialogPlaceholderModel != null ? dialogPlaceholderModel.getPlaceholder() : null;
        if (placeholder == null) {
            placeholder = "";
        }
        if (StringsKt.isBlank(str2)) {
            if (StringsKt.isBlank(placeholder)) {
                String str3 = str;
                return (StringsKt.isBlank(str3) || StringsKt.startsWith$default(StringsKt.trim((CharSequence) str3).toString(), "{", false, 2, (Object) null) || StringsKt.startsWith$default(StringsKt.trim((CharSequence) str3).toString(), "[", false, 2, (Object) null)) ? "" : str;
            }
            return placeholder;
        }
        return str2;
    }

    private final void bindHeaderInfo() {
        InputDialogBinding inputDialogBinding = this.binding;
        DialogPlaceholderModel dialogPlaceholderModel = this.placeholderModel;
        DialogInputHeaderInfo headerInfo = dialogPlaceholderModel != null ? dialogPlaceholderModel.getHeaderInfo() : null;
        LinearLayout headerInfoContainer = inputDialogBinding.headerInfoContainer;
        Intrinsics.checkNotNullExpressionValue(headerInfoContainer, "headerInfoContainer");
        headerInfoContainer.setVisibility(8);
        TextView textView = inputDialogBinding.headerInfoText;
        String text = headerInfo != null ? headerInfo.getText() : null;
        if (text == null) {
            text = "";
        }
        textView.setText(text);
        inputDialogBinding.headerInfoBadge.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTransferCommission() {
        String str;
        String text;
        String substringBefore$default;
        String text2;
        String obj;
        InputDialogBinding inputDialogBinding = this.binding;
        DialogPlaceholderModel dialogPlaceholderModel = this.placeholderModel;
        String str2 = null;
        DialogInputHeaderInfo headerInfo = dialogPlaceholderModel != null ? dialogPlaceholderModel.getHeaderInfo() : null;
        Editable text3 = inputDialogBinding.userInput.getText();
        if (text3 == null || (obj = text3.toString()) == null) {
            str = null;
        } else {
            String str3 = obj;
            StringBuilder sb = new StringBuilder();
            int length = str3.length();
            for (int i = 0; i < length; i++) {
                char charAt = str3.charAt(i);
                if (Character.isDigit(charAt)) {
                    sb.append(charAt);
                }
            }
            str = sb.toString();
        }
        if (str == null) {
            str = "";
        }
        Long longOrNull = StringsKt.toLongOrNull(str);
        long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
        int commissionPercentFor = headerInfo != null ? Companion.commissionPercentFor(headerInfo, longValue) : 0;
        Companion companion = Companion;
        long calculateCommission = companion.calculateCommission(longValue, commissionPercentFor);
        boolean z = true;
        String activeBadgeText = headerInfo != null ? companion.activeBadgeText(headerInfo, commissionPercentFor, !StringsKt.isBlank(str)) : null;
        if (activeBadgeText == null) {
            activeBadgeText = "";
        }
        LinearLayout headerInfoContainer = inputDialogBinding.headerInfoContainer;
        Intrinsics.checkNotNullExpressionValue(headerInfoContainer, "headerInfoContainer");
        headerInfoContainer.setVisibility(headerInfo != null && (text2 = headerInfo.getText()) != null && (StringsKt.isBlank(text2) ^ true) && !StringsKt.isBlank(activeBadgeText) ? 0 : 8);
        TextView textView = inputDialogBinding.headerInfoText;
        String text4 = headerInfo != null ? headerInfo.getText() : null;
        if (text4 == null) {
            text4 = "";
        }
        textView.setText(text4);
        inputDialogBinding.headerInfoBadge.setText(activeBadgeText + "%");
        LinearLayout transferCommissionContainer = inputDialogBinding.transferCommissionContainer;
        Intrinsics.checkNotNullExpressionValue(transferCommissionContainer, "transferCommissionContainer");
        transferCommissionContainer.setVisibility((StringsKt.isBlank(str) || calculateCommission <= 0) ? false : false ? 0 : 8);
        TextView textView2 = inputDialogBinding.transferCommissionText;
        if (headerInfo != null && (text = headerInfo.getText()) != null && (substringBefore$default = StringsKt.substringBefore$default(text, " ", (String) null, 2, (Object) null)) != null) {
            String str4 = substringBefore$default;
            if (StringsKt.isBlank(str4)) {
                str4 = headerInfo.getText();
            }
            str2 = str4;
        }
        textView2.setText(str2 != null ? str2 : "");
        inputDialogBinding.transferCommissionValue.setText(MoneyElementKt.toMoneyFormattedSpannable$default(calculateCommission, false, null, null, null, 15, null));
    }

    private final void updateKeyboardOffset(int i) {
        EditText editText;
        boolean hasFocus = this.binding.findPlayerInput.hasFocus();
        InputDialogBinding inputDialogBinding = this.binding;
        if (hasFocus) {
            editText = inputDialogBinding.findPlayerInput;
        } else {
            boolean hasFocus2 = inputDialogBinding.userInput.hasFocus();
            InputDialogBinding inputDialogBinding2 = this.binding;
            if (hasFocus2) {
                editText = inputDialogBinding2.userInput;
            } else {
                editText = inputDialogBinding2.userInput;
            }
        }
        Intrinsics.checkNotNull(editText);
        int[] iArr = new int[2];
        editText.getLocationOnScreen(iArr);
        float translationY = ((iArr[1] - this.dialogLayout.getTranslationY()) + editText.getHeight()) - i;
        this.dialogLayout.setTranslationY(translationY > 0.0f ? -translationY : 0.0f);
    }

    private final String getResponseInput() {
        String obj;
        Editable text = this.binding.userInput.getText();
        String str = null;
        String obj2 = text != null ? text.toString() : null;
        if (obj2 == null) {
            obj2 = "";
        }
        Editable text2 = this.binding.findPlayerInput.getText();
        if (text2 != null && (obj = text2.toString()) != null) {
            LinearLayout findPlayerInputRow = this.binding.findPlayerInputRow;
            Intrinsics.checkNotNullExpressionValue(findPlayerInputRow, "findPlayerInputRow");
            if (findPlayerInputRow.getVisibility() == 0) {
                str = obj;
            }
        }
        return UserInputDialogResponseCodec.INSTANCE.encode(obj2, str);
    }

    private final void restoreInputHistory(String str) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        UserInputDialogResponseCodec userInputDialogResponseCodec = UserInputDialogResponseCodec.INSTANCE;
        LinearLayout findPlayerInputRow = this.binding.findPlayerInputRow;
        Intrinsics.checkNotNullExpressionValue(findPlayerInputRow, "findPlayerInputRow");
        applyDecodedInput(userInputDialogResponseCodec.decode(str, findPlayerInputRow.getVisibility() == 0));
    }

    private final void applyDecodedInput(UserInputDialogResponseCodec.DecodedInput decodedInput) {
        String findPlayerInput = decodedInput.getFindPlayerInput();
        if (findPlayerInput != null) {
            EditText findPlayerInput2 = this.binding.findPlayerInput;
            Intrinsics.checkNotNullExpressionValue(findPlayerInput2, "findPlayerInput");
            findPlayerInput2.setText(findPlayerInput);
        }
        this.binding.userInput.setText(decodedInput.getMainInput());
    }

    private final InputFilter[] buildMoneyInputFilters(DialogWithdrawLimitModel dialogWithdrawLimitModel) {
        if (dialogWithdrawLimitModel != null) {
            final long maxMoney = dialogWithdrawLimitModel.getMaxMoney();
            return new InputFilter[]{new InputFilter.LengthFilter(RangesKt.coerceAtLeast(String.valueOf(maxMoney).length(), 1)), new InputFilter() { // from class: ru.mrlargha.commonui.elements.dialogs.UserInputDialog$$ExternalSyntheticLambda0
                @Override // android.text.InputFilter
                public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                    return UserInputDialog.buildMoneyInputFilters$lambda$0(maxMoney, charSequence, i, i2, spanned, i3, i4);
                }
            }};
        }
        return new InputFilter[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence buildMoneyInputFilters$lambda$0(long j, CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
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

    private final String getPassword() {
        return getSharedPreferences().getString("PASSWORD_SP_FIELD", null);
    }

    private final void savePassword(String str) {
        int length = str.length();
        if (6 > length || length >= 33) {
            return;
        }
        getSharedPreferences().edit().putString("PASSWORD_SP_FIELD", str).apply();
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

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void consumeUserInput(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        setVisibility(true);
        UserInputDialogResponseCodec userInputDialogResponseCodec = UserInputDialogResponseCodec.INSTANCE;
        LinearLayout findPlayerInputRow = this.binding.findPlayerInputRow;
        Intrinsics.checkNotNullExpressionValue(findPlayerInputRow, "findPlayerInputRow");
        applyDecodedInput(userInputDialogResponseCodec.decode(text, findPlayerInputRow.getVisibility() == 0));
        this.text = text;
        this.binding.buttons.button1.callOnClick();
    }

    /* compiled from: UserInputDialog.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u0007H\u0002J\u001c\u0010\u000e\u001a\u00020\u0007*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0014\u0010\u0013\u001a\u00020\u0005*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/UserInputDialog$Companion;", "", "<init>", "()V", "PASSWORD_SEND_RETRY_COUNT", "", "TAG", "", "PASSWORD_SP_NAME", "passwordDialogShowTimes", "inputHistory", "", "toModelOrNull", "Lru/mrlargha/commonui/elements/dialogs/DialogPlaceholderModel;", "activeBadgeText", "Lru/mrlargha/commonui/elements/dialogs/DialogInputHeaderInfo;", "commissionPercent", "hasAmountInput", "", "commissionPercentFor", "amount", "", "calculateCommission", "percent", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final DialogPlaceholderModel toModelOrNull(String str) {
            Object m9916constructorimpl;
            Object obj;
            try {
                Result.Companion companion = Result.Companion;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m9916constructorimpl = Result.m9916constructorimpl(ResultKt.createFailure(th));
            }
            if (MapperKt.isJsonValid(str) && !Intrinsics.areEqual(str, AbstractJsonLexerKt.NULL) && !Intrinsics.areEqual(str, "{}") && str.length() != 0) {
                obj = MapperKt.getGson().fromJson(str, (Class<Object>) DialogPlaceholderModel.class);
                m9916constructorimpl = Result.m9916constructorimpl((DialogPlaceholderModel) obj);
                return Result.m9922isFailureimpl(m9916constructorimpl) ? null : m9916constructorimpl;
            }
            obj = null;
            m9916constructorimpl = Result.m9916constructorimpl((DialogPlaceholderModel) obj);
            return Result.m9922isFailureimpl(m9916constructorimpl) ? null : m9916constructorimpl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String activeBadgeText(DialogInputHeaderInfo dialogInputHeaderInfo, int i, boolean z) {
            if (z) {
                if (i > 0) {
                    return i + "%";
                }
                return (dialogInputHeaderInfo.getTiers().isEmpty() && dialogInputHeaderInfo.getPercent() == null && !StringsKt.isBlank(dialogInputHeaderInfo.getValue())) ? dialogInputHeaderInfo.getValue() : "";
            }
            return "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int commissionPercentFor(DialogInputHeaderInfo dialogInputHeaderInfo, long j) {
            Object next;
            ArrayList arrayList = new ArrayList();
            for (Object obj : dialogInputHeaderInfo.getTiers()) {
                DialogInputCommissionTier dialogInputCommissionTier = (DialogInputCommissionTier) obj;
                if (dialogInputCommissionTier.getPercent() > 0 && j >= dialogInputCommissionTier.getFrom()) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            Integer num = null;
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    long from = ((DialogInputCommissionTier) next).getFrom();
                    do {
                        Object next2 = it.next();
                        long from2 = ((DialogInputCommissionTier) next2).getFrom();
                        if (from < from2) {
                            next = next2;
                            from = from2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            DialogInputCommissionTier dialogInputCommissionTier2 = (DialogInputCommissionTier) next;
            if (dialogInputCommissionTier2 != null) {
                return dialogInputCommissionTier2.getPercent();
            }
            Integer percent = dialogInputHeaderInfo.getPercent();
            if (percent != null && percent.intValue() > 0) {
                num = percent;
            }
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long calculateCommission(long j, int i) {
            Long m9916constructorimpl;
            if (j <= 0 || i <= 0) {
                return 0L;
            }
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                m9916constructorimpl = Result.m9916constructorimpl(Long.valueOf(Math.multiplyExact(j, i) / 100));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.Companion;
                m9916constructorimpl = Result.m9916constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m9922isFailureimpl(m9916constructorimpl)) {
                m9916constructorimpl = Long.MAX_VALUE;
            }
            return ((Number) m9916constructorimpl).longValue();
        }
    }
}
