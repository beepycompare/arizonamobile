package ru.mrlargha.commonui.elements.keyboard.customKeyboard;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.elements.keyboard.customKeyboard.CustomKeyboard;
import ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard;
import ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.KeyboardKeeper;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
/* compiled from: KeyboardEditText.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001:\u0002./B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\u0002\b\n¢\u0006\u0004\b\b\u0010\tJ,\u0010\u0010\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0017b\u0018\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\n\b$\u0012\u0006\b\n0%8&J,\u0010\u0017\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010'H\u0017b\u0018\b!\u0012\b\b\"\u0012\u0004\b\b((\u0012\n\b$\u0012\u0006\b\n0%8&J\b\u0010)\u001a\u00020\rH\u0002J\b\u0010*\u001a\u00020\u0014H\u0002J\b\u0010+\u001a\u00020\rH\u0002J\u0010\u0010,\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0014H\u0002J\b\u0010-\u001a\u00020\rH\u0002R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\r0\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\u0010\b1\u0012\f\b2\u0012\b\b\fJ\u0004\b\b(3¨\u00060"}, d2 = {"Lru/mrlargha/commonui/elements/keyboard/customKeyboard/KeyboardEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lkotlin/jvm/JvmOverloads;", "onClickListener", "Lkotlin/Function0;", "", "getOnClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "onFocusChangeListener", "Lkotlin/Function1;", "", "getOnFocusChangeListener", "()Lkotlin/jvm/functions/Function1;", "setOnFocusChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "onDone", "getOnDone", "setOnDone", "typedArray", "Landroid/content/res/TypedArray;", "showInput", CmcdData.STREAM_TYPE_LIVE, "Landroid/view/View$OnClickListener;", "Lkotlin/Deprecated;", "message", "setOnClickListener запрещён. Используй onClickListener().", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "ERROR", "Landroid/view/View$OnFocusChangeListener;", "setOnFocusChangeListener запрещён. Используй onFocusChangeListener().", "setupKeyboardHandlers", "syncKeyboardMode", "hideSystemKeyboard", "showInGameKeyboard", "hideInGameKeyboard", "InGameInputListener", "InputCustomKeyboardListener", "CommonUI", "Landroid/annotation/SuppressLint;", "value", "AppCompatCustomView"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public class KeyboardEditText extends AppCompatEditText {
    private Function0<Unit> onClickListener;
    private Function0<Unit> onDone;
    private Function1<? super Boolean, Unit> onFocusChangeListener;
    private final boolean showInput;
    private final TypedArray typedArray;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KeyboardEditText(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KeyboardEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.onClickListener = new Function0() { // from class: ru.mrlargha.commonui.elements.keyboard.customKeyboard.KeyboardEditText$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        };
        this.onFocusChangeListener = new Function1() { // from class: ru.mrlargha.commonui.elements.keyboard.customKeyboard.KeyboardEditText$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                ((Boolean) obj).booleanValue();
                unit = Unit.INSTANCE;
                return unit;
            }
        };
        this.onDone = new Function0() { // from class: ru.mrlargha.commonui.elements.keyboard.customKeyboard.KeyboardEditText$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KeyboardEditText);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.typedArray = obtainStyledAttributes;
        this.showInput = obtainStyledAttributes.getInteger(R.styleable.KeyboardEditText_showInput, 1) == 1;
        setupKeyboardHandlers();
    }

    public /* synthetic */ KeyboardEditText(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? androidx.appcompat.R.attr.editTextStyle : i);
    }

    public final Function0<Unit> getOnClickListener() {
        return this.onClickListener;
    }

    public final void setOnClickListener(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onClickListener = function0;
    }

    @Override // android.view.View
    public final Function1<Boolean, Unit> getOnFocusChangeListener() {
        return this.onFocusChangeListener;
    }

    public final void setOnFocusChangeListener(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onFocusChangeListener = function1;
    }

    public final Function0<Unit> getOnDone() {
        return this.onDone;
    }

    public final void setOnDone(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onDone = function0;
    }

    @Override // android.view.View
    @Deprecated(level = DeprecationLevel.ERROR, message = "setOnClickListener запрещён. Используй onClickListener().")
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    @Deprecated(level = DeprecationLevel.ERROR, message = "setOnFocusChangeListener запрещён. Используй onFocusChangeListener().")
    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        super.setOnFocusChangeListener(onFocusChangeListener);
    }

    private final void setupKeyboardHandlers() {
        setFocusable(true);
        setFocusableInTouchMode(true);
        syncKeyboardMode();
        super.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ru.mrlargha.commonui.elements.keyboard.customKeyboard.KeyboardEditText$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                KeyboardEditText.setupKeyboardHandlers$lambda$0(KeyboardEditText.this, view, z);
            }
        });
        super.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.keyboard.customKeyboard.KeyboardEditText$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KeyboardEditText.setupKeyboardHandlers$lambda$1(KeyboardEditText.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void setupKeyboardHandlers$lambda$0(KeyboardEditText keyboardEditText, View view, boolean z) {
        IBackendNotifier iBackendNotifier;
        if (keyboardEditText.syncKeyboardMode()) {
            if (z) {
                keyboardEditText.hideSystemKeyboard();
                keyboardEditText.showInGameKeyboard(keyboardEditText.showInput);
            } else {
                keyboardEditText.hideInGameKeyboard();
            }
        } else if (keyboardEditText.showInput && z && (iBackendNotifier = KeyboardKeeper.INSTANCE.getNotifier().get()) != null) {
            iBackendNotifier.showCustomKeyboardForEditText(new InputCustomKeyboardListener(), String.valueOf(keyboardEditText.getText()));
        }
        keyboardEditText.onFocusChangeListener.invoke(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void setupKeyboardHandlers$lambda$1(KeyboardEditText keyboardEditText, View view) {
        IBackendNotifier iBackendNotifier;
        boolean syncKeyboardMode = keyboardEditText.syncKeyboardMode();
        if (keyboardEditText.hasFocus()) {
            if (syncKeyboardMode) {
                keyboardEditText.hideSystemKeyboard();
                keyboardEditText.showInGameKeyboard(keyboardEditText.showInput);
            } else if (keyboardEditText.showInput && (iBackendNotifier = KeyboardKeeper.INSTANCE.getNotifier().get()) != null) {
                iBackendNotifier.showCustomKeyboardForEditText(new InputCustomKeyboardListener(), String.valueOf(keyboardEditText.getText()));
            }
        }
        keyboardEditText.onClickListener.invoke();
    }

    private final boolean syncKeyboardMode() {
        KeyboardKeeper keyboardKeeper = KeyboardKeeper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        boolean syncFromSettings = keyboardKeeper.syncFromSettings(context);
        setShowSoftInputOnFocus(!syncFromSettings);
        if (syncFromSettings) {
            hideSystemKeyboard();
        }
        return syncFromSettings;
    }

    private final void hideSystemKeyboard() {
        Object systemService = getContext().getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    private final void showInGameKeyboard(boolean z) {
        IBackendNotifier iBackendNotifier = KeyboardKeeper.INSTANCE.getNotifier().get();
        if (iBackendNotifier != null) {
            iBackendNotifier.setKeyboardInputListener(new InGameInputListener());
            iBackendNotifier.disableTypeAndBindersInGameKeyboard(z, String.valueOf(getText()));
            iBackendNotifier.setUIElementVisible(UIElementID.IN_GAME_KEYBOARD.getId(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideInGameKeyboard() {
        IBackendNotifier iBackendNotifier = KeyboardKeeper.INSTANCE.getNotifier().get();
        if (iBackendNotifier != null) {
            iBackendNotifier.setUIElementVisible(UIElementID.IN_GAME_KEYBOARD.getId(), false);
        }
    }

    /* compiled from: KeyboardEditText.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/keyboard/customKeyboard/KeyboardEditText$InGameInputListener;", "Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/Keyboard$KeyboardInputListener;", "<init>", "(Lru/mrlargha/commonui/elements/keyboard/customKeyboard/KeyboardEditText;)V", "onSymbolInput", "", "symbol", "", "onTextInput", "text", "", "onTextRemove", "onTextRemoveAll", "onSend", "onSendText", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class InGameInputListener implements Keyboard.KeyboardInputListener {
        public InGameInputListener() {
        }

        @Override // ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard.KeyboardInputListener
        public void onSymbolInput(char c) {
            int selectionStart = KeyboardEditText.this.getSelectionStart();
            int selectionEnd = KeyboardEditText.this.getSelectionEnd();
            KeyboardEditText keyboardEditText = KeyboardEditText.this;
            if (selectionStart != selectionEnd) {
                Editable text = keyboardEditText.getText();
                if (text != null) {
                    text.replace(selectionStart, selectionEnd, String.valueOf(c));
                    return;
                }
                return;
            }
            Editable text2 = keyboardEditText.getText();
            if (text2 != null) {
                text2.insert(selectionStart, String.valueOf(c));
            }
        }

        @Override // ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard.KeyboardInputListener
        public void onTextInput(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            int selectionStart = KeyboardEditText.this.getSelectionStart();
            int selectionEnd = KeyboardEditText.this.getSelectionEnd();
            SpannableString spannable$default = ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, text, 1.1f, null, 2, null);
            KeyboardEditText keyboardEditText = KeyboardEditText.this;
            if (selectionStart != selectionEnd) {
                Editable text2 = keyboardEditText.getText();
                if (text2 != null) {
                    text2.replace(selectionStart, selectionEnd, spannable$default);
                    return;
                }
                return;
            }
            Editable text3 = keyboardEditText.getText();
            if (text3 != null) {
                text3.insert(selectionStart, spannable$default);
            }
        }

        @Override // ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard.KeyboardInputListener
        public void onTextRemove() {
            Editable text;
            int selectionStart = KeyboardEditText.this.getSelectionStart();
            int selectionEnd = KeyboardEditText.this.getSelectionEnd();
            if (selectionStart != selectionEnd) {
                Editable text2 = KeyboardEditText.this.getText();
                if (text2 != null) {
                    text2.delete(selectionStart, selectionEnd);
                }
            } else if (selectionStart <= 0 || (text = KeyboardEditText.this.getText()) == null) {
            } else {
                text.delete(selectionStart - 1, selectionStart);
            }
        }

        @Override // ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard.KeyboardInputListener
        public void onTextRemoveAll() {
            KeyboardEditText.this.setText("");
        }

        @Override // ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard.KeyboardInputListener
        public void onSend() {
            KeyboardEditText.this.clearFocus();
            KeyboardEditText.this.hideInGameKeyboard();
            KeyboardEditText.this.getOnDone().invoke();
        }

        @Override // ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard.KeyboardInputListener
        public void onSendText(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            KeyboardEditText.this.setText(text);
            KeyboardEditText.this.clearFocus();
            KeyboardEditText.this.hideInGameKeyboard();
            KeyboardEditText.this.getOnDone().invoke();
        }
    }

    /* compiled from: KeyboardEditText.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/keyboard/customKeyboard/KeyboardEditText$InputCustomKeyboardListener;", "Lru/mrlargha/commonui/elements/keyboard/customKeyboard/CustomKeyboard$InputListener;", "<init>", "(Lru/mrlargha/commonui/elements/keyboard/customKeyboard/KeyboardEditText;)V", "t_OnInputEnd", "", "str", "", "t_BinderIsEmpty", "", "t_GetKeyboardHistorySize", "", "t_GetKeyboardHistoryText", FirebaseAnalytics.Param.INDEX, "t_SetChatType", "t_SetLastString", "std", "t_SetChatHeight", "height", "closeKeyboard", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class InputCustomKeyboardListener implements CustomKeyboard.InputListener {
        @Override // ru.mrlargha.commonui.elements.keyboard.customKeyboard.CustomKeyboard.InputListener
        public void closeKeyboard() {
        }

        @Override // ru.mrlargha.commonui.elements.keyboard.customKeyboard.CustomKeyboard.InputListener
        public boolean t_BinderIsEmpty() {
            return false;
        }

        @Override // ru.mrlargha.commonui.elements.keyboard.customKeyboard.CustomKeyboard.InputListener
        public int t_GetKeyboardHistorySize() {
            return 0;
        }

        @Override // ru.mrlargha.commonui.elements.keyboard.customKeyboard.CustomKeyboard.InputListener
        public String t_GetKeyboardHistoryText(int i) {
            return null;
        }

        @Override // ru.mrlargha.commonui.elements.keyboard.customKeyboard.CustomKeyboard.InputListener
        public void t_SetChatHeight(int i) {
        }

        @Override // ru.mrlargha.commonui.elements.keyboard.customKeyboard.CustomKeyboard.InputListener
        public void t_SetChatType(int i) {
        }

        @Override // ru.mrlargha.commonui.elements.keyboard.customKeyboard.CustomKeyboard.InputListener
        public void t_SetLastString(String str) {
        }

        public InputCustomKeyboardListener() {
        }

        @Override // ru.mrlargha.commonui.elements.keyboard.customKeyboard.CustomKeyboard.InputListener
        public void t_OnInputEnd(String str) {
            KeyboardEditText.this.setText(str);
            KeyboardEditText.this.getOnDone().invoke();
        }
    }
}
