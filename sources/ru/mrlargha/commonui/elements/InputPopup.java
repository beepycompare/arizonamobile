package ru.mrlargha.commonui.elements;

import android.app.Activity;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
/* compiled from: InputPopup.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lru/mrlargha/commonui/elements/InputPopup;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", TtmlNode.TAG_LAYOUT, "Landroid/view/View;", "kotlin.jvm.PlatformType", "textInput", "Landroid/widget/EditText;", "button", "Lcom/google/android/material/button/MaterialButton;", "passwordToggle", "Landroid/widget/ImageButton;", "targetID", "bindID", "", "id", "isPassword", "", "bindText", "", "setPasswordMode", "commitResult", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InputPopup extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private static int passwordDialogsCount;
    private final MaterialButton button;
    private final View layout;
    private final ImageButton passwordToggle;
    private int targetID;
    private final EditText textInput;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputPopup(final Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View layout = LayoutInflater.from(targetActivity).inflate(R.layout.input_popup, (ViewGroup) null, false);
        this.layout = layout;
        View findViewById = layout.findViewById(R.id.text_input);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        EditText editText = (EditText) findViewById;
        this.textInput = editText;
        View findViewById2 = layout.findViewById(R.id.ok_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        MaterialButton materialButton = (MaterialButton) findViewById2;
        this.button = materialButton;
        View findViewById3 = layout.findViewById(R.id.password_toggle);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        ImageButton imageButton = (ImageButton) findViewById3;
        this.passwordToggle = imageButton;
        this.targetID = -1;
        Intrinsics.checkNotNullExpressionValue(layout, "layout");
        addViewToConstraintLayout(layout, -1, -1);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.commonui.elements.InputPopup$$ExternalSyntheticLambda0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                boolean _init_$lambda$0;
                _init_$lambda$0 = InputPopup._init_$lambda$0(targetActivity, this, textView, i2, keyEvent);
                return _init_$lambda$0;
            }
        });
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.InputPopup$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputPopup._init_$lambda$1(targetActivity, this, view);
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.InputPopup$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputPopup._init_$lambda$2(InputPopup.this, view);
            }
        });
        editText.setOnKeyListener(new View.OnKeyListener() { // from class: ru.mrlargha.commonui.elements.InputPopup$$ExternalSyntheticLambda3
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                boolean _init_$lambda$3;
                _init_$lambda$3 = InputPopup._init_$lambda$3(InputPopup.this, view, i2, keyEvent);
                return _init_$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(Activity activity, InputPopup inputPopup, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 5 || i == 6) {
            SAMPUIElement.Companion.hideKeyboard(activity);
            inputPopup.button.requestFocus();
            inputPopup.button.performClick();
            inputPopup.commitResult();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(Activity activity, InputPopup inputPopup, View view) {
        SAMPUIElement.Companion.hideKeyboard(activity);
        inputPopup.commitResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(InputPopup inputPopup, View view) {
        inputPopup.setPasswordMode(inputPopup.textInput.getTransformationMethod() == null);
        inputPopup.passwordToggle.setImageResource(inputPopup.textInput.getTransformationMethod() == null ? R.drawable.eye : R.drawable.eye_off);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$3(InputPopup inputPopup, View view, int i, KeyEvent keyEvent) {
        if (i == 66 && keyEvent.isCtrlPressed()) {
            inputPopup.commitResult();
            return true;
        }
        return false;
    }

    public final void bindID(int i, boolean z, String bindText) {
        Intrinsics.checkNotNullParameter(bindText, "bindText");
        this.targetID = i;
        setVisibility(true);
        setPasswordMode(z);
        if (!z) {
            this.passwordToggle.setVisibility(8);
        }
        this.textInput.setText(bindText);
        this.textInput.requestFocus();
        Object systemService = getTargetActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(this.textInput, 1);
    }

    private final void setPasswordMode(boolean z) {
        if (z) {
            this.textInput.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            this.textInput.setTransformationMethod(null);
        }
    }

    private final void commitResult() {
        getNotifier().inputFinished(this.textInput.getText().toString(), this.targetID);
        setVisibility(false);
    }

    /* compiled from: InputPopup.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/elements/InputPopup$Companion;", "", "<init>", "()V", "passwordDialogsCount", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
