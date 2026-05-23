package ru.mrlargha.commonui.elements.dialogs;

import android.app.Activity;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.method.PasswordTransformationMethod;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.autofill.HintConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.InputDialogBinding;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.ui.CustomEditText;
/* compiled from: UserInputDialog.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u0001:\u0001'BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u001e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000fH\u0002J\u0010\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\fH\u0016J\b\u0010$\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020 H\u0002J\u0010\u0010&\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/UserInputDialog;", "Lru/mrlargha/commonui/elements/dialogs/AbstractDialog;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "caption", "Landroid/text/SpannableString;", "info", "leftButtonText", "rightButtonText", "passwordMode", "", "sampDialogId", "hintInput", "", "<init>", "(Landroid/app/Activity;ILandroid/text/SpannableString;Landroid/text/SpannableString;Landroid/text/SpannableString;Landroid/text/SpannableString;ZILjava/lang/String;)V", "dialogLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/commonui/databinding/InputDialogBinding;", "text", "isKeyboardShowing", "keyboardLayoutListenerAttached", "dialogRect", "Landroid/graphics/Rect;", "keyboardLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "getPassword", "savePassword", "", HintConstants.AUTOFILL_HINT_NEW_PASSWORD, "setVisibility", "visible", "addKeyboardLayoutListener", "removeKeyboardLayoutListener", "consumeUserInput", "Companion", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
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
    private String text;
    public static final Companion Companion = new Companion(null);
    private static final Map<Integer, String> inputHistory = new LinkedHashMap();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserInputDialog(final Activity targetActivity, int i, SpannableString caption, SpannableString info, SpannableString leftButtonText, SpannableString rightButtonText, boolean z, final int i2, String hintInput) {
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
        String str = "";
        this.text = "";
        this.dialogRect = new Rect();
        this.keyboardLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ru.mrlargha.commonui.elements.dialogs.UserInputDialog$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                UserInputDialog.keyboardLayoutListener$lambda$0(UserInputDialog.this);
            }
        };
        Intrinsics.checkNotNullExpressionValue(dialogLayout, "dialogLayout");
        addViewToConstraintLayout(dialogLayout, -2, -2);
        setPosition(SAMPUIElement.PositionType.CENTER, 0, 0);
        bind.infoText.setText(info);
        bind.infoText.setMovementMethod(new ScrollingMovementMethod());
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
        } else if (((IAutocompleteStateProvider) targetActivity).getAutocompleteState()) {
            CustomEditText customEditText = bind.userInput;
            String str2 = inputHistory.get(Integer.valueOf(i2));
            customEditText.setText(str2 == null ? "" : str2);
        }
        SpannableString spannableString = leftButtonText;
        if (spannableString.length() == 0) {
            bind.buttons.button1.setVisibility(8);
        } else {
            bind.buttons.tvAccept.setText(spannableString);
            bind.buttons.button1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.UserInputDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserInputDialog.lambda$0$1(targetActivity, this, i2, bind, view);
                }
            });
        }
        SpannableString spannableString2 = rightButtonText;
        if (spannableString2.length() == 0) {
            bind.buttons.button2.setVisibility(8);
        } else {
            bind.buttons.tvCancel.setText(spannableString2);
            bind.buttons.button2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.UserInputDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserInputDialog.lambda$0$2(targetActivity, this, i2, bind, view);
                }
            });
        }
        bind.userInput.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.commonui.elements.dialogs.UserInputDialog$$ExternalSyntheticLambda3
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                return UserInputDialog.lambda$0$3(targetActivity, bind, textView, i3, keyEvent);
            }
        });
        try {
            str = ((DialogPlaceholderModel) MapperKt.toModel(hintInput, DialogPlaceholderModel.class)).getPlaceholder();
        } catch (Exception unused) {
        }
        bind.userInput.setAlwaysHint(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void keyboardLayoutListener$lambda$0(UserInputDialog userInputDialog) {
        try {
            userInputDialog.dialogLayout.getWindowVisibleDisplayFrame(userInputDialog.dialogRect);
            int height = userInputDialog.dialogLayout.getRootView().getRootView().getHeight();
            if (height <= 0) {
                return;
            }
            int i = height - userInputDialog.dialogRect.bottom;
            if (i > height * 0.15d) {
                if (userInputDialog.isKeyboardShowing) {
                    return;
                }
                Log.d(TAG, "Keyboard was shown");
                userInputDialog.isKeyboardShowing = true;
                userInputDialog.setPosition(SAMPUIElement.PositionType.CENTER_TOP, 0, (height - i) - userInputDialog.dialogLayout.getHeight());
            } else if (userInputDialog.isKeyboardShowing) {
                Log.d(TAG, "Keyboard was closed");
                userInputDialog.isKeyboardShowing = false;
                userInputDialog.setPosition(SAMPUIElement.PositionType.CENTER, 0, 0);
            }
        } catch (OutOfMemoryError e) {
            Log.e(TAG, "Unable to update dialog keyboard layout due to low memory", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$1(Activity activity, UserInputDialog userInputDialog, int i, InputDialogBinding inputDialogBinding, View view) {
        SAMPUIElement.Companion.hideKeyboard(activity);
        if (!userInputDialog.passwordMode) {
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.dialogs.IAutocompleteStateProvider");
            if (((IAutocompleteStateProvider) activity).getAutocompleteState()) {
                inputHistory.put(Integer.valueOf(i), String.valueOf(inputDialogBinding.userInput.getText()));
            }
        }
        userInputDialog.getNotifier().onDialogResponseWrapper(i, 1, -1, StringsKt.encodeToByteArray(String.valueOf(inputDialogBinding.userInput.getText())));
        userInputDialog.getNotifier().destroyDialog();
        if (userInputDialog.passwordMode) {
            userInputDialog.savePassword(String.valueOf(inputDialogBinding.userInput.getText()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$2(Activity activity, UserInputDialog userInputDialog, int i, InputDialogBinding inputDialogBinding, View view) {
        SAMPUIElement.Companion.hideKeyboard(activity);
        userInputDialog.getNotifier().onDialogResponseWrapper(i, 0, -1, StringsKt.encodeToByteArray(String.valueOf(inputDialogBinding.userInput.getText())));
        userInputDialog.getNotifier().destroyDialog();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$3(Activity activity, InputDialogBinding inputDialogBinding, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 5 || i == 6) {
            SAMPUIElement.Companion.hideKeyboard(activity);
            inputDialogBinding.buttons.button1.requestFocus();
            inputDialogBinding.buttons.button1.performClick();
            return true;
        }
        return true;
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
        this.binding.userInput.setText(text);
        this.text = text;
        this.binding.buttons.button1.callOnClick();
    }

    /* compiled from: UserInputDialog.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/UserInputDialog$Companion;", "", "<init>", "()V", "PASSWORD_SEND_RETRY_COUNT", "", "TAG", "", "PASSWORD_SP_NAME", "passwordDialogShowTimes", "inputHistory", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
