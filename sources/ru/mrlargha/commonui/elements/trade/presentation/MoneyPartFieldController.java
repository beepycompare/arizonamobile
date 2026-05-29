package ru.mrlargha.commonui.elements.trade.presentation;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.EditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.ViewMoneyPartInputBinding;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
/* compiled from: TradeEditText.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\tJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\t2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001aJ\u000e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/trade/presentation/MoneyPartFieldController;", "", "binding", "Lru/mrlargha/commonui/databinding/ViewMoneyPartInputBinding;", "<init>", "(Lru/mrlargha/commonui/databinding/ViewMoneyPartInputBinding;)V", "watcher", "Landroid/text/TextWatcher;", "setup", "", "suffix", "", "maxLength", "", "setValue", "value", "getValue", "setHint", "setEnabled", "enabled", "", "requestFocus", "getEditText", "Landroid/widget/EditText;", "setOnTextChanged", "onChanged", "Lkotlin/Function0;", "setColor", "color", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MoneyPartFieldController {
    private final ViewMoneyPartInputBinding binding;
    private TextWatcher watcher;

    public MoneyPartFieldController(ViewMoneyPartInputBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public final void setup(String suffix, int i) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        this.binding.tvSuffix.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, suffix, 0.0f, null, 3, null));
        this.binding.etValue.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(i)});
    }

    public final void setValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Editable text = this.binding.etValue.getText();
        if (Intrinsics.areEqual(text != null ? text.toString() : null, value)) {
            return;
        }
        this.binding.etValue.setText(value);
        EditText editText = this.binding.etValue;
        Editable text2 = this.binding.etValue.getText();
        editText.setSelection(text2 != null ? text2.length() : 0);
    }

    public final String getValue() {
        Editable text = this.binding.etValue.getText();
        String obj = text != null ? text.toString() : null;
        return obj == null ? "" : obj;
    }

    public final void setHint(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.binding.etValue.setHint(value);
    }

    public final void setEnabled(boolean z) {
        this.binding.etValue.setEnabled(z);
    }

    public final void requestFocus() {
        this.binding.etValue.requestFocus();
        EditText editText = this.binding.etValue;
        Editable text = this.binding.etValue.getText();
        editText.setSelection(text != null ? text.length() : 0);
    }

    public final EditText getEditText() {
        EditText etValue = this.binding.etValue;
        Intrinsics.checkNotNullExpressionValue(etValue, "etValue");
        return etValue;
    }

    public final void setOnTextChanged(final Function0<Unit> function0) {
        TextWatcher textWatcher = this.watcher;
        if (textWatcher != null) {
            this.binding.etValue.removeTextChangedListener(textWatcher);
        }
        if (function0 == null) {
            this.watcher = null;
            return;
        }
        this.watcher = new TextWatcher() { // from class: ru.mrlargha.commonui.elements.trade.presentation.MoneyPartFieldController$setOnTextChanged$2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                function0.invoke();
            }
        };
        this.binding.etValue.addTextChangedListener(this.watcher);
    }

    public final void setColor(int i) {
        this.binding.getRoot().setBorder(i);
    }
}
