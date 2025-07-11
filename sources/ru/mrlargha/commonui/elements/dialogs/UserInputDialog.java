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
import android.widget.Button;
import android.widget.TextView;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
/* compiled from: UserInputDialog.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\n\u0010\u001f\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001dH\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/UserInputDialog;", "Lru/mrlargha/commonui/elements/dialogs/AbstractDialog;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "caption", "Landroid/text/SpannableString;", "info", "leftButtonText", "rightButtonText", "passwordMode", "", "sampDialogId", "<init>", "(Landroid/app/Activity;ILandroid/text/SpannableString;Landroid/text/SpannableString;Landroid/text/SpannableString;Landroid/text/SpannableString;ZI)V", "dialogLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "infoTextView", "Landroid/widget/TextView;", "captionTextView", "button1", "Landroid/widget/Button;", "button2", "textInput", "Lcom/google/android/material/textfield/TextInputEditText;", "inputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "text", "", "isKeyboardShowing", "getPassword", "savePassword", "", HintConstants.AUTOFILL_HINT_NEW_PASSWORD, "consumeUserInput", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserInputDialog extends AbstractDialog {
    private static final int PASSWORD_SEND_RETRY_COUNT = 2;
    public static final String PASSWORD_SP_NAME = "PASSWORD_SP_FIELD";
    private static final String TAG = "UserInputDialog";
    private static int passwordDialogShowTimes;
    private final Button button1;
    private final Button button2;
    private final TextView captionTextView;
    private final ConstraintLayout dialogLayout;
    private final TextView infoTextView;
    private final TextInputLayout inputLayout;
    private boolean isKeyboardShowing;
    private final boolean passwordMode;
    private String text;
    private final TextInputEditText textInput;
    public static final Companion Companion = new Companion(null);
    private static final Map<Integer, String> inputHistory = new LinkedHashMap();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserInputDialog(final Activity targetActivity, int i, SpannableString caption, SpannableString info, SpannableString leftButtonText, SpannableString rightButtonText, boolean z, final int i2) {
        super(targetActivity, i, i2);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(caption, "caption");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(leftButtonText, "leftButtonText");
        Intrinsics.checkNotNullParameter(rightButtonText, "rightButtonText");
        this.passwordMode = z;
        View inflate = LayoutInflater.from(targetActivity).inflate(R.layout.input_dialog, (ViewGroup) null, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.dialogLayout = constraintLayout;
        View findViewById = constraintLayout.findViewById(R.id.infoText);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        this.infoTextView = textView;
        View findViewById2 = constraintLayout.findViewById(R.id.caption);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        TextView textView2 = (TextView) findViewById2;
        this.captionTextView = textView2;
        View findViewById3 = constraintLayout.findViewById(R.id.button1);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        Button button = (Button) findViewById3;
        this.button1 = button;
        View findViewById4 = constraintLayout.findViewById(R.id.button2);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        Button button2 = (Button) findViewById4;
        this.button2 = button2;
        View findViewById5 = constraintLayout.findViewById(R.id.user_input);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        TextInputEditText textInputEditText = (TextInputEditText) findViewById5;
        this.textInput = textInputEditText;
        View findViewById6 = constraintLayout.findViewById(R.id.textInputLayout);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        TextInputLayout textInputLayout = (TextInputLayout) findViewById6;
        this.inputLayout = textInputLayout;
        this.text = "";
        addViewToConstraintLayout(constraintLayout, -2, -2);
        setPosition(SAMPUIElement.PositionType.CENTER, 0, 0);
        constraintLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ru.mrlargha.commonui.elements.dialogs.UserInputDialog$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                UserInputDialog._init_$lambda$0(UserInputDialog.this);
            }
        });
        textView.setText(info);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView2.setText(caption);
        setVisibility(true);
        if (z) {
            textInputLayout.setEndIconMode(1);
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconMinSize(1);
            textInputEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            passwordDialogShowTimes++;
            String password = getPassword();
            if (password != null && passwordDialogShowTimes < 2 && i2 == 2) {
                getNotifier().onDialogResponseWrapper(i2, 1, -1, StringsKt.encodeToByteArray(password));
                setVisibility(false);
                getNotifier().destroyDialog();
            }
        } else if (((IAutocompleteStateProvider) targetActivity).getAutocompleteState()) {
            String str = inputHistory.get(Integer.valueOf(i2));
            textInputEditText.setText(str != null ? str : "");
        }
        SpannableString spannableString = leftButtonText;
        if (spannableString.length() == 0) {
            button.setVisibility(8);
        } else {
            button.setText(spannableString);
            button.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.UserInputDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserInputDialog._init_$lambda$2(targetActivity, this, i2, view);
                }
            });
        }
        SpannableString spannableString2 = rightButtonText;
        if (spannableString2.length() == 0) {
            button2.setVisibility(8);
        } else {
            button2.setText(spannableString2);
            button2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.UserInputDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserInputDialog._init_$lambda$3(targetActivity, this, i2, view);
                }
            });
        }
        textInputEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.commonui.elements.dialogs.UserInputDialog$$ExternalSyntheticLambda3
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView3, int i3, KeyEvent keyEvent) {
                boolean _init_$lambda$4;
                _init_$lambda$4 = UserInputDialog._init_$lambda$4(targetActivity, this, textView3, i3, keyEvent);
                return _init_$lambda$4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(UserInputDialog userInputDialog) {
        Rect rect = new Rect();
        userInputDialog.dialogLayout.getWindowVisibleDisplayFrame(rect);
        int height = userInputDialog.dialogLayout.getRootView().getRootView().getHeight();
        int i = height - rect.bottom;
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(Activity activity, UserInputDialog userInputDialog, int i, View view) {
        SAMPUIElement.Companion.hideKeyboard(activity);
        if (!userInputDialog.passwordMode) {
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.dialogs.IAutocompleteStateProvider");
            if (((IAutocompleteStateProvider) activity).getAutocompleteState()) {
                inputHistory.put(Integer.valueOf(i), String.valueOf(userInputDialog.textInput.getText()));
            }
        }
        userInputDialog.getNotifier().onDialogResponseWrapper(i, 1, -1, StringsKt.encodeToByteArray(String.valueOf(userInputDialog.textInput.getText())));
        userInputDialog.getNotifier().destroyDialog();
        if (userInputDialog.passwordMode) {
            userInputDialog.savePassword(String.valueOf(userInputDialog.textInput.getText()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(Activity activity, UserInputDialog userInputDialog, int i, View view) {
        SAMPUIElement.Companion.hideKeyboard(activity);
        userInputDialog.getNotifier().onDialogResponseWrapper(i, 0, -1, StringsKt.encodeToByteArray(String.valueOf(userInputDialog.textInput.getText())));
        userInputDialog.getNotifier().destroyDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$4(Activity activity, UserInputDialog userInputDialog, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 5 || i == 6) {
            SAMPUIElement.Companion.hideKeyboard(activity);
            userInputDialog.button1.requestFocus();
            userInputDialog.button1.performClick();
            return true;
        }
        return true;
    }

    private final String getPassword() {
        return getSharedPreferences().getString(PASSWORD_SP_NAME, null);
    }

    private final void savePassword(String str) {
        int length = str.length();
        if (6 > length || length >= 33) {
            return;
        }
        getSharedPreferences().edit().putString(PASSWORD_SP_NAME, str).apply();
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void consumeUserInput(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        setVisibility(true);
        this.textInput.setText(text);
        this.text = text;
        this.button1.callOnClick();
    }

    /* compiled from: UserInputDialog.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/UserInputDialog$Companion;", "", "<init>", "()V", "PASSWORD_SEND_RETRY_COUNT", "", "TAG", "", "PASSWORD_SP_NAME", "passwordDialogShowTimes", "inputHistory", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
