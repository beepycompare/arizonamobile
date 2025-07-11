package ru.mrlargha.commonui.elements;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.InputFilter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
/* compiled from: CustomKeyboard.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0002:;B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020*H\u0002J\u0006\u0010,\u001a\u00020\u001eJ\u000e\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020*2\u0006\u0010!\u001a\u00020\"J\u0006\u00101\u001a\u00020*J&\u00102\u001a\u00020*2\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u00020\u0005J\u0010\u00107\u001a\u00020*2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00108\u001a\u00020*H\u0002J\b\u00109\u001a\u00020*H\u0002R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lru/mrlargha/commonui/elements/CustomKeyboard;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "activity", "inputLayout", "Landroidx/appcompat/widget/AppCompatImageView;", "inputArea", "Landroid/widget/EditText;", "chatType", "Landroid/widget/TextView;", "currentHistory", "keySlash", "keyNext", "keyOld", "keyBinder", "rpButton", "Landroid/widget/Button;", "nonrpButton", "orgButton", "familyButton", "workButton", "vipButton", "selectButton", "sendButton", "isChat", "", "isBinderShowing", "lastHeightKeyboard", "inputListener", "Lru/mrlargha/commonui/elements/CustomKeyboard$InputListener;", "filters", "", "Landroid/text/InputFilter$LengthFilter;", "[Landroid/text/InputFilter$LengthFilter;", "mKeyboardView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "showKeyboard", "", "hideKeyboard", "getUniqueState", "setString", "str", "", "setInputLayoutForEditText", "removeListener", "setInputLayout", "thisChatType", "type", "thisIsChat", "height", "OnInputEnd", "updateTextByCurrentHistoryLevel", "updateHistoryNavigationButtonsEnabledState", "InputListener", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CustomKeyboard extends SAMPUIElement {
    private final Activity activity;
    private final TextView chatType;
    private int currentHistory;
    private final Button familyButton;
    private final InputFilter.LengthFilter[] filters;
    private final EditText inputArea;
    private final AppCompatImageView inputLayout;
    private InputListener inputListener;
    private boolean isBinderShowing;
    private boolean isChat;
    private final AppCompatImageView keyBinder;
    private final AppCompatImageView keyNext;
    private final AppCompatImageView keyOld;
    private final AppCompatImageView keySlash;
    private int lastHeightKeyboard;
    private final ConstraintLayout mKeyboardView;
    private final Button nonrpButton;
    private final Button orgButton;
    private final Button rpButton;
    private final AppCompatImageView selectButton;
    private final AppCompatImageView sendButton;
    private final Button vipButton;
    private final Button workButton;

    /* compiled from: CustomKeyboard.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\tH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\tH&J\b\u0010\u0011\u001a\u00020\u0003H&¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/elements/CustomKeyboard$InputListener;", "", "t_OnInputEnd", "", "str", "", "t_BinderIsEmpty", "", "t_GetKeyboardHistorySize", "", "t_GetKeyboardHistoryText", FirebaseAnalytics.Param.INDEX, "t_SetChatType", "t_SetLastString", "std", "t_SetChatHeight", "height", "closeKeyboard", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface InputListener {
        void closeKeyboard();

        boolean t_BinderIsEmpty();

        int t_GetKeyboardHistorySize();

        String t_GetKeyboardHistoryText(int i);

        void t_OnInputEnd(String str);

        void t_SetChatHeight(int i);

        void t_SetChatType(int i);

        void t_SetLastString(String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomKeyboard(final Activity targetActivity, int i) {
        super(targetActivity, i);
        ConstraintLayout constraintLayout;
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.currentHistory = -1;
        this.filters = new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(200)};
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.chat, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout2 = (ConstraintLayout) inflate;
        this.mKeyboardView = constraintLayout2;
        addViewToConstraintLayout(constraintLayout2, -1, -1);
        this.activity = targetActivity;
        constraintLayout2.setVisibility(8);
        View findViewById = constraintLayout2.findViewById(R.id.enter_message);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.inputLayout = (AppCompatImageView) findViewById;
        View findViewById2 = constraintLayout2.findViewById(R.id.input_zone);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        EditText editText = (EditText) findViewById2;
        this.inputArea = editText;
        View findViewById3 = constraintLayout2.findViewById(R.id.up_button);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        AppCompatImageView appCompatImageView = (AppCompatImageView) findViewById3;
        this.keyNext = appCompatImageView;
        View findViewById4 = constraintLayout2.findViewById(R.id.down_button);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) findViewById4;
        this.keyOld = appCompatImageView2;
        View findViewById5 = constraintLayout2.findViewById(R.id.slash);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) findViewById5;
        this.keySlash = appCompatImageView3;
        View findViewById6 = constraintLayout2.findViewById(R.id.binder_button);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        AppCompatImageView appCompatImageView4 = (AppCompatImageView) findViewById6;
        this.keyBinder = appCompatImageView4;
        View findViewById7 = constraintLayout2.findViewById(R.id.chat_type);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.chatType = (TextView) findViewById7;
        View findViewById8 = constraintLayout2.findViewById(R.id.rp_button);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        Button button = (Button) findViewById8;
        this.rpButton = button;
        View findViewById9 = constraintLayout2.findViewById(R.id.nonrp_button);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
        Button button2 = (Button) findViewById9;
        this.nonrpButton = button2;
        View findViewById10 = constraintLayout2.findViewById(R.id.org_button);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(...)");
        Button button3 = (Button) findViewById10;
        this.orgButton = button3;
        View findViewById11 = constraintLayout2.findViewById(R.id.fam_button);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(...)");
        Button button4 = (Button) findViewById11;
        this.familyButton = button4;
        View findViewById12 = constraintLayout2.findViewById(R.id.work_button);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(...)");
        Button button5 = (Button) findViewById12;
        this.workButton = button5;
        View findViewById13 = constraintLayout2.findViewById(R.id.vip_button);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(...)");
        Button button6 = (Button) findViewById13;
        this.vipButton = button6;
        View findViewById14 = constraintLayout2.findViewById(R.id.select_button);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(...)");
        AppCompatImageView appCompatImageView5 = (AppCompatImageView) findViewById14;
        this.selectButton = appCompatImageView5;
        View findViewById15 = constraintLayout2.findViewById(R.id.send_button);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(...)");
        AppCompatImageView appCompatImageView6 = (AppCompatImageView) findViewById15;
        this.sendButton = appCompatImageView6;
        appCompatImageView3.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.CustomKeyboard$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomKeyboard._init_$lambda$0(CustomKeyboard.this, view);
            }
        });
        appCompatImageView2.setEnabled(false);
        if (this.lastHeightKeyboard != 0) {
            constraintLayout = constraintLayout2;
            setPosition(SAMPUIElement.PositionType.CENTER_TOP, 0, this.lastHeightKeyboard);
        } else {
            constraintLayout = constraintLayout2;
        }
        constraintLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ru.mrlargha.commonui.elements.CustomKeyboard$$ExternalSyntheticLambda14
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                CustomKeyboard._init_$lambda$2(CustomKeyboard.this, targetActivity);
            }
        });
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.CustomKeyboard$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomKeyboard._init_$lambda$3(CustomKeyboard.this, view);
            }
        });
        appCompatImageView6.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.CustomKeyboard$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomKeyboard._init_$lambda$4(CustomKeyboard.this, view);
            }
        });
        editText.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.CustomKeyboard$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomKeyboard._init_$lambda$5(CustomKeyboard.this, view);
            }
        });
        appCompatImageView5.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.CustomKeyboard$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomKeyboard._init_$lambda$6(CustomKeyboard.this, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.CustomKeyboard$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomKeyboard._init_$lambda$7(CustomKeyboard.this, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.CustomKeyboard$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomKeyboard._init_$lambda$8(CustomKeyboard.this, view);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.CustomKeyboard$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomKeyboard._init_$lambda$9(CustomKeyboard.this, view);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.CustomKeyboard$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomKeyboard._init_$lambda$10(CustomKeyboard.this, view);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.CustomKeyboard$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomKeyboard._init_$lambda$11(CustomKeyboard.this, view);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.CustomKeyboard$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomKeyboard._init_$lambda$12(CustomKeyboard.this, view);
            }
        });
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.CustomKeyboard$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomKeyboard._init_$lambda$13(CustomKeyboard.this, view);
            }
        });
        appCompatImageView4.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.CustomKeyboard$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomKeyboard._init_$lambda$14(CustomKeyboard.this, view);
            }
        });
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.commonui.elements.CustomKeyboard$$ExternalSyntheticLambda12
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                boolean _init_$lambda$15;
                _init_$lambda$15 = CustomKeyboard._init_$lambda$15(CustomKeyboard.this, textView, i2, keyEvent);
                return _init_$lambda$15;
            }
        });
        editText.setOnKeyListener(new View.OnKeyListener() { // from class: ru.mrlargha.commonui.elements.CustomKeyboard$$ExternalSyntheticLambda13
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                boolean _init_$lambda$16;
                _init_$lambda$16 = CustomKeyboard._init_$lambda$16(CustomKeyboard.this, view, i2, keyEvent);
                return _init_$lambda$16;
            }
        });
    }

    public final void showKeyboard() {
        Object systemService = this.activity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(this.inputArea, 1);
        this.rpButton.setVisibility(8);
        this.nonrpButton.setVisibility(8);
        this.orgButton.setVisibility(8);
        this.familyButton.setVisibility(8);
        this.workButton.setVisibility(8);
        this.vipButton.setVisibility(8);
        this.isBinderShowing = false;
    }

    private final void hideKeyboard() {
        SAMPUIElement.Companion.hideKeyboard(this.activity);
    }

    public final boolean getUniqueState() {
        return (this.rpButton.getVisibility() == 8 && this.nonrpButton.getVisibility() == 8 && this.orgButton.getVisibility() == 8 && this.familyButton.getVisibility() == 8 && this.workButton.getVisibility() == 8 && this.vipButton.getVisibility() == 8 && !this.isBinderShowing) ? false : true;
    }

    public final void setString(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        this.inputArea.setText(str);
        EditText editText = this.inputArea;
        editText.setSelection(editText.getText().length());
    }

    public final void setInputLayoutForEditText(InputListener inputListener) {
        Intrinsics.checkNotNullParameter(inputListener, "inputListener");
        this.keyNext.setVisibility(8);
        this.keyOld.setVisibility(8);
        this.keyBinder.setVisibility(8);
        this.chatType.setVisibility(8);
        this.selectButton.setVisibility(8);
        this.inputListener = inputListener;
        this.inputArea.setFilters(this.filters);
        this.inputArea.requestFocus();
    }

    public final void removeListener() {
        this.keyNext.setVisibility(0);
        this.keyOld.setVisibility(0);
        this.keyBinder.setVisibility(0);
        this.chatType.setVisibility(0);
        this.selectButton.setVisibility(0);
        this.inputArea.setFilters(new InputFilter[0]);
        this.inputListener = null;
    }

    public final void setInputLayout(int i, boolean z, boolean z2, int i2) {
        this.isChat = z2;
        this.keyNext.setVisibility(0);
        this.keyOld.setVisibility(0);
        this.keyBinder.setVisibility(0);
        this.chatType.setVisibility(0);
        this.selectButton.setVisibility(0);
        updateHistoryNavigationButtonsEnabledState();
        if (z) {
            this.lastHeightKeyboard = i2;
            this.currentHistory = -1;
            this.inputArea.requestFocus();
            this.rpButton.setVisibility(8);
            this.nonrpButton.setVisibility(8);
            this.orgButton.setVisibility(8);
            this.familyButton.setVisibility(8);
            this.workButton.setVisibility(8);
            this.vipButton.setVisibility(8);
            if (i == 0) {
                this.chatType.setText("РП");
            } else if (i == 1) {
                this.chatType.setText("НРП");
            } else if (i == 2) {
                this.chatType.setText("ОРГ");
            } else if (i == 3) {
                this.chatType.setText("СЕМ");
            } else if (i == 4) {
                this.chatType.setText("РАБ");
            } else if (i == 5) {
                this.chatType.setText("VIP");
            }
            Object systemService = this.activity.getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).showSoftInput(this.inputArea, 1);
            return;
        }
        this.mKeyboardView.setVisibility(8);
        if (this.inputListener == null) {
            Activity activity = this.activity;
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.CustomKeyboard.InputListener");
            ((InputListener) activity).t_SetLastString(this.inputArea.getEditableText().toString());
            hideKeyboard();
        }
    }

    private final void OnInputEnd(String str) {
        this.currentHistory = -1;
        CharSequence text = this.chatType.getText();
        if (!Intrinsics.areEqual(text, "РП")) {
            if (Intrinsics.areEqual(text, "НРП")) {
                if (this.isChat && !StringsKt.startsWith$default(str, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null)) {
                    str = "/b " + str;
                }
            } else if (Intrinsics.areEqual(text, "ОРГ")) {
                if (this.isChat && !StringsKt.startsWith$default(str, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null)) {
                    str = "/fr " + str;
                }
            } else if (Intrinsics.areEqual(text, "СЕМ")) {
                if (this.isChat && !StringsKt.startsWith$default(str, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null)) {
                    str = "/fam " + str;
                }
            } else if (Intrinsics.areEqual(text, "РАБ")) {
                if (this.isChat && !StringsKt.startsWith$default(str, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null)) {
                    str = "/j " + str;
                }
            } else if (!Intrinsics.areEqual(text, "VIP")) {
                str = "";
            } else if (this.isChat && !StringsKt.startsWith$default(str, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null)) {
                str = "/vr " + str;
            }
        }
        InputListener inputListener = this.inputListener;
        if (inputListener == null) {
            Activity activity = this.activity;
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.CustomKeyboard.InputListener");
            ((InputListener) activity).t_OnInputEnd(str);
            return;
        }
        Intrinsics.checkNotNull(inputListener);
        inputListener.t_OnInputEnd(str);
        Activity activity2 = this.activity;
        Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.CustomKeyboard.InputListener");
        ((InputListener) activity2).closeKeyboard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(CustomKeyboard customKeyboard, View view) {
        customKeyboard.inputArea.getText().insert(customKeyboard.inputArea.getSelectionStart(), RemoteSettings.FORWARD_SLASH_STRING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(final CustomKeyboard customKeyboard, Activity activity) {
        int height;
        Rect rect = new Rect();
        customKeyboard.mKeyboardView.getWindowVisibleDisplayFrame(rect);
        int height2 = customKeyboard.mKeyboardView.getRootView().getRootView().getHeight();
        int i = height2 - rect.bottom;
        Object systemService = activity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        if (((InputMethodManager) systemService).isAcceptingText() && i > 300 && customKeyboard.lastHeightKeyboard != (height = (height2 - i) - customKeyboard.inputArea.getHeight())) {
            customKeyboard.setPosition(SAMPUIElement.PositionType.CENTER_TOP, 0, height);
            customKeyboard.lastHeightKeyboard = height;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: ru.mrlargha.commonui.elements.CustomKeyboard$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                CustomKeyboard.this.mKeyboardView.setVisibility(0);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(CustomKeyboard customKeyboard, View view) {
        customKeyboard.currentHistory--;
        customKeyboard.updateHistoryNavigationButtonsEnabledState();
        customKeyboard.updateTextByCurrentHistoryLevel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4(CustomKeyboard customKeyboard, View view) {
        Editable text = customKeyboard.inputArea.getText();
        if (text != null) {
            String obj = text.toString();
            customKeyboard.inputArea.setText("");
            customKeyboard.OnInputEnd(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$5(CustomKeyboard customKeyboard, View view) {
        customKeyboard.rpButton.setVisibility(8);
        customKeyboard.nonrpButton.setVisibility(8);
        customKeyboard.orgButton.setVisibility(8);
        customKeyboard.familyButton.setVisibility(8);
        customKeyboard.workButton.setVisibility(8);
        customKeyboard.vipButton.setVisibility(8);
        if (customKeyboard.isBinderShowing) {
            customKeyboard.getNotifier().setUIElementVisible(UIElementID.COMMAND_BINDER.getId(), false);
            customKeyboard.isBinderShowing = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$6(CustomKeyboard customKeyboard, View view) {
        if (customKeyboard.rpButton.getVisibility() == 8 && customKeyboard.nonrpButton.getVisibility() == 8 && customKeyboard.orgButton.getVisibility() == 8 && customKeyboard.familyButton.getVisibility() == 8 && customKeyboard.workButton.getVisibility() == 8 && customKeyboard.vipButton.getVisibility() == 8) {
            customKeyboard.rpButton.setVisibility(0);
            customKeyboard.nonrpButton.setVisibility(0);
            customKeyboard.orgButton.setVisibility(0);
            customKeyboard.familyButton.setVisibility(0);
            customKeyboard.workButton.setVisibility(0);
            customKeyboard.vipButton.setVisibility(0);
            customKeyboard.hideKeyboard();
            return;
        }
        customKeyboard.rpButton.setVisibility(8);
        customKeyboard.nonrpButton.setVisibility(8);
        customKeyboard.orgButton.setVisibility(8);
        customKeyboard.familyButton.setVisibility(8);
        customKeyboard.workButton.setVisibility(8);
        customKeyboard.vipButton.setVisibility(8);
        if (customKeyboard.isBinderShowing) {
            return;
        }
        Object systemService = customKeyboard.activity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(customKeyboard.inputArea, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$7(CustomKeyboard customKeyboard, View view) {
        customKeyboard.chatType.setText("РП");
        customKeyboard.rpButton.setVisibility(8);
        customKeyboard.nonrpButton.setVisibility(8);
        customKeyboard.orgButton.setVisibility(8);
        customKeyboard.familyButton.setVisibility(8);
        customKeyboard.workButton.setVisibility(8);
        customKeyboard.vipButton.setVisibility(8);
        Activity activity = customKeyboard.activity;
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.CustomKeyboard.InputListener");
        ((InputListener) activity).t_SetChatType(0);
        if (customKeyboard.isBinderShowing) {
            return;
        }
        Object systemService = customKeyboard.activity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(customKeyboard.inputArea, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$8(CustomKeyboard customKeyboard, View view) {
        customKeyboard.chatType.setText("НРП");
        customKeyboard.rpButton.setVisibility(8);
        customKeyboard.nonrpButton.setVisibility(8);
        customKeyboard.orgButton.setVisibility(8);
        customKeyboard.familyButton.setVisibility(8);
        customKeyboard.workButton.setVisibility(8);
        customKeyboard.vipButton.setVisibility(8);
        Activity activity = customKeyboard.activity;
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.CustomKeyboard.InputListener");
        ((InputListener) activity).t_SetChatType(1);
        if (customKeyboard.isBinderShowing) {
            return;
        }
        Object systemService = customKeyboard.activity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(customKeyboard.inputArea, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$9(CustomKeyboard customKeyboard, View view) {
        customKeyboard.chatType.setText("ОРГ");
        customKeyboard.rpButton.setVisibility(8);
        customKeyboard.nonrpButton.setVisibility(8);
        customKeyboard.orgButton.setVisibility(8);
        customKeyboard.familyButton.setVisibility(8);
        customKeyboard.workButton.setVisibility(8);
        customKeyboard.vipButton.setVisibility(8);
        Activity activity = customKeyboard.activity;
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.CustomKeyboard.InputListener");
        ((InputListener) activity).t_SetChatType(2);
        if (customKeyboard.isBinderShowing) {
            return;
        }
        Object systemService = customKeyboard.activity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(customKeyboard.inputArea, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$10(CustomKeyboard customKeyboard, View view) {
        customKeyboard.chatType.setText("СЕМ");
        customKeyboard.rpButton.setVisibility(8);
        customKeyboard.nonrpButton.setVisibility(8);
        customKeyboard.orgButton.setVisibility(8);
        customKeyboard.familyButton.setVisibility(8);
        customKeyboard.workButton.setVisibility(8);
        customKeyboard.vipButton.setVisibility(8);
        Activity activity = customKeyboard.activity;
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.CustomKeyboard.InputListener");
        ((InputListener) activity).t_SetChatType(3);
        if (customKeyboard.isBinderShowing) {
            return;
        }
        Object systemService = customKeyboard.activity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(customKeyboard.inputArea, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$11(CustomKeyboard customKeyboard, View view) {
        customKeyboard.chatType.setText("РАБ");
        customKeyboard.rpButton.setVisibility(8);
        customKeyboard.nonrpButton.setVisibility(8);
        customKeyboard.orgButton.setVisibility(8);
        customKeyboard.familyButton.setVisibility(8);
        customKeyboard.workButton.setVisibility(8);
        customKeyboard.vipButton.setVisibility(8);
        Activity activity = customKeyboard.activity;
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.CustomKeyboard.InputListener");
        ((InputListener) activity).t_SetChatType(4);
        if (customKeyboard.isBinderShowing) {
            return;
        }
        Object systemService = customKeyboard.activity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(customKeyboard.inputArea, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$12(CustomKeyboard customKeyboard, View view) {
        customKeyboard.chatType.setText("VIP");
        customKeyboard.rpButton.setVisibility(8);
        customKeyboard.nonrpButton.setVisibility(8);
        customKeyboard.orgButton.setVisibility(8);
        customKeyboard.familyButton.setVisibility(8);
        customKeyboard.workButton.setVisibility(8);
        customKeyboard.vipButton.setVisibility(8);
        Activity activity = customKeyboard.activity;
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.CustomKeyboard.InputListener");
        ((InputListener) activity).t_SetChatType(5);
        if (customKeyboard.isBinderShowing) {
            return;
        }
        Object systemService = customKeyboard.activity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(customKeyboard.inputArea, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$13(CustomKeyboard customKeyboard, View view) {
        customKeyboard.currentHistory++;
        customKeyboard.updateHistoryNavigationButtonsEnabledState();
        customKeyboard.updateTextByCurrentHistoryLevel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$14(CustomKeyboard customKeyboard, View view) {
        if (!customKeyboard.isBinderShowing) {
            customKeyboard.hideKeyboard();
            customKeyboard.getNotifier().setUIElementVisible(UIElementID.COMMAND_BINDER.getId(), true);
            customKeyboard.isBinderShowing = true;
            return;
        }
        customKeyboard.rpButton.setVisibility(8);
        customKeyboard.nonrpButton.setVisibility(8);
        customKeyboard.orgButton.setVisibility(8);
        customKeyboard.familyButton.setVisibility(8);
        customKeyboard.workButton.setVisibility(8);
        customKeyboard.vipButton.setVisibility(8);
        Object systemService = customKeyboard.activity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(customKeyboard.inputArea, 1);
        customKeyboard.getNotifier().setUIElementVisible(UIElementID.COMMAND_BINDER.getId(), false);
        customKeyboard.isBinderShowing = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$15(CustomKeyboard customKeyboard, TextView textView, int i, KeyEvent keyEvent) {
        Editable text;
        if ((i == 0 || i == 5 || i == 6) && (text = customKeyboard.inputArea.getText()) != null) {
            String obj = text.toString();
            customKeyboard.inputArea.setText("");
            customKeyboard.OnInputEnd(obj);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$16(CustomKeyboard customKeyboard, View view, int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 66 && keyEvent.isCtrlPressed() && (text = customKeyboard.inputArea.getText()) != null) {
            String obj = text.toString();
            customKeyboard.inputArea.setText("");
            customKeyboard.OnInputEnd(obj);
            return true;
        }
        return false;
    }

    private final void updateTextByCurrentHistoryLevel() {
        try {
            EditText editText = this.inputArea;
            Activity activity = this.activity;
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.CustomKeyboard.InputListener");
            editText.setText(((InputListener) activity).t_GetKeyboardHistoryText(this.currentHistory));
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("CustomKeyboard", "currentHistory == -1");
            this.inputArea.setText("");
        }
        EditText editText2 = this.inputArea;
        editText2.setSelection(editText2.getText().length());
    }

    private final void updateHistoryNavigationButtonsEnabledState() {
        Activity activity = this.activity;
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.CustomKeyboard.InputListener");
        int t_GetKeyboardHistorySize = ((InputListener) activity).t_GetKeyboardHistorySize();
        boolean z = false;
        this.keyOld.setEnabled(this.currentHistory > -1);
        AppCompatImageView appCompatImageView = this.keyNext;
        if (this.currentHistory != t_GetKeyboardHistorySize - 1 && t_GetKeyboardHistorySize > 0) {
            z = true;
        }
        appCompatImageView.setEnabled(z);
    }

    /* compiled from: CustomKeyboard.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/CustomKeyboard$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new CustomKeyboard(targetActivity, i);
        }
    }
}
