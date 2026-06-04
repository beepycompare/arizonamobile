package ru.mrlargha.commonui.elements.trade.presentation;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.ViewUniversalMoneyInputBinding;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.ui.money.MoneyFormatter;
import ru.mrlargha.commonui.utils.ui.textWithIcons.IconAndSize;
import ru.mrlargha.commonui.utils.ui.textWithIcons.TextWithIconsKt;
/* compiled from: TradeEditText.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\tJ \u0010\u001d\u001a\u00020\u00132\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00190\u0017J\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0012J\r\u0010\"\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010#J\u000e\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0007J\u0006\u0010&\u001a\u00020\u0007J\u001e\u0010'\u001a\u00020\u00132\u0016\u0010(\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011J\u0006\u0010)\u001a\u00020\u0013J\b\u0010*\u001a\u00020\u0013H\u0002J\u0012\u0010+\u001a\u00020\u00132\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u000e\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00190\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lru/mrlargha/commonui/elements/trade/presentation/TradeEditText;", "", "binding", "Lru/mrlargha/commonui/databinding/ViewUniversalMoneyInputBinding;", "<init>", "(Lru/mrlargha/commonui/databinding/ViewUniversalMoneyInputBinding;)V", "isNewMoney", "", "editTextType", "", "getEditTextType", "()I", "setEditTextType", "(I)V", "singleWatcher", "Landroid/text/TextWatcher;", "onValueChanged", "Lkotlin/Function1;", "", "", "ignoreChanges", "isFormattingMoney", "limits", "", "", "", "setupSingleField", "setType", "type", "setLimits", "setValidation", "validation", "setValue", "value", "getValue", "()Ljava/lang/Long;", "setEnabled", "enabled", "hasFocus", "setOnValueChanged", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "requestFocus", "notifyValueChanged", "formatMoneyInput", CmcdData.STREAMING_FORMAT_SS, "Landroid/text/Editable;", "setIcon", "icon", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TradeEditText {
    private final ViewUniversalMoneyInputBinding binding;
    private int editTextType;
    private boolean ignoreChanges;
    private boolean isFormattingMoney;
    private boolean isNewMoney;
    private Map<String, ? extends List<Long>> limits;
    private Function1<? super Long, Unit> onValueChanged;
    private TextWatcher singleWatcher;

    public TradeEditText(ViewUniversalMoneyInputBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        this.limits = MapsKt.emptyMap();
        setupSingleField();
    }

    public final int getEditTextType() {
        return this.editTextType;
    }

    public final void setEditTextType(int i) {
        this.editTextType = i;
    }

    private final void setupSingleField() {
        EditText editText = this.binding.etSingle.etValue;
        editText.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(17)});
        editText.setSingleLine(true);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeEditText$$ExternalSyntheticLambda0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean z;
                z = TradeEditText.setupSingleField$lambda$0$0(textView, i, keyEvent);
                return z;
            }
        });
        this.singleWatcher = new TextWatcher() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeEditText$setupSingleField$2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z;
                boolean z2;
                boolean z3;
                z = TradeEditText.this.isFormattingMoney;
                if (z) {
                    return;
                }
                z2 = TradeEditText.this.ignoreChanges;
                if (!z2) {
                    z3 = TradeEditText.this.isNewMoney;
                    if (z3) {
                        TradeEditText.this.formatMoneyInput(editable);
                    }
                }
                TradeEditText.this.notifyValueChanged();
            }
        };
        this.binding.etSingle.etValue.addTextChangedListener(this.singleWatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupSingleField$lambda$0$0(TextView textView, int i, KeyEvent keyEvent) {
        boolean z = i == 6;
        boolean z2 = keyEvent != null && keyEvent.getKeyCode() == 66 && keyEvent.getAction() == 1;
        if (z || z2) {
            textView.clearFocus();
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(context, InputMethodManager.class);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(textView.getWindowToken(), 0);
            }
            return true;
        }
        return false;
    }

    public final void setType(int i) {
        this.isNewMoney = false;
        this.editTextType = i;
        if (i == 0) {
            if (UtilsKt.isArizonaType()) {
                this.isNewMoney = true;
                setIcon(R.drawable.arizona_dollar);
                return;
            }
            setIcon(R.drawable.ic_rubble);
        } else if (i == 1) {
            setIcon(R.drawable.trade_euro_ic);
        } else if (i == 2) {
            setIcon(R.drawable.trade_bitcoin_ic);
        } else if (i == 3) {
            setIcon(R.drawable.trade_asc_ic);
        } else if (i != 10) {
        } else {
            setIcon(R.drawable.ic_rubble);
        }
    }

    public final void setLimits(Map<String, ? extends List<Long>> limits) {
        Intrinsics.checkNotNullParameter(limits, "limits");
        this.limits = limits;
    }

    public final void setValidation(boolean z) {
        this.binding.etSingle.getRoot().setBorder(Color.parseColor(z ? "#1AFFFFFF" : "#E2254E"));
    }

    public final void setValue(long j) {
        String valueOf;
        this.ignoreChanges = true;
        if (this.isNewMoney) {
            valueOf = MoneyFormatter.INSTANCE.formatPlain(RangesKt.coerceAtLeast(j, 0L));
        } else {
            valueOf = String.valueOf(j);
        }
        Editable text = this.binding.etSingle.etValue.getText();
        if (!Intrinsics.areEqual(text != null ? text.toString() : null, valueOf)) {
            this.binding.etSingle.etValue.setText(valueOf);
        }
        if (this.binding.etSingle.etValue.hasFocus()) {
            EditText editText = this.binding.etSingle.etValue;
            Editable text2 = this.binding.etSingle.etValue.getText();
            editText.setSelection(text2 != null ? text2.length() : 0);
        }
        this.ignoreChanges = false;
    }

    public final Long getValue() {
        long j;
        String obj;
        Long longOrNull;
        List<Long> orDefault = this.limits.getOrDefault(String.valueOf(this.editTextType), null);
        Editable text = this.binding.etSingle.etValue.getText();
        if (text != null && (obj = text.toString()) != null) {
            String str = obj;
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (Character.isDigit(charAt)) {
                    sb.append(charAt);
                }
            }
            String sb2 = sb.toString();
            if (sb2 != null && (longOrNull = StringsKt.toLongOrNull(sb2)) != null) {
                j = longOrNull.longValue();
                if (orDefault != null || (j >= orDefault.get(0).longValue() && j <= orDefault.get(1).longValue())) {
                    return Long.valueOf(j);
                }
                return null;
            }
        }
        j = 0;
        if (orDefault != null) {
        }
        return Long.valueOf(j);
    }

    public final void setEnabled(boolean z) {
        EditText editText = this.binding.etSingle.etValue;
        editText.setEnabled(true);
        editText.setFocusable(z);
        editText.setFocusableInTouchMode(z);
        editText.setCursorVisible(z);
        editText.setLongClickable(z);
        if (z) {
            return;
        }
        editText.clearFocus();
    }

    public final boolean hasFocus() {
        return this.binding.etSingle.etValue.hasFocus();
    }

    public final void setOnValueChanged(Function1<? super Long, Unit> function1) {
        this.onValueChanged = function1;
    }

    public final void requestFocus() {
        this.binding.etSingle.etValue.requestFocus();
        EditText editText = this.binding.etSingle.etValue;
        Editable text = this.binding.etSingle.etValue.getText();
        editText.setSelection(text != null ? text.length() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyValueChanged() {
        Function1<? super Long, Unit> function1;
        if (this.ignoreChanges || (function1 = this.onValueChanged) == null) {
            return;
        }
        function1.invoke(getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void formatMoneyInput(Editable editable) {
        if (this.isFormattingMoney) {
            return;
        }
        String obj = editable != null ? editable.toString() : null;
        if (obj == null) {
            obj = "";
        }
        String str = obj;
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        Long longOrNull = StringsKt.toLongOrNull(StringsKt.take(sb.toString(), 13));
        String formatPlain = longOrNull != null ? MoneyFormatter.INSTANCE.formatPlain(longOrNull.longValue()) : null;
        String str2 = formatPlain != null ? formatPlain : "";
        if (Intrinsics.areEqual(obj, str2)) {
            return;
        }
        this.isFormattingMoney = true;
        this.binding.etSingle.etValue.setText(str2);
        EditText editText = this.binding.etSingle.etValue;
        Editable text = this.binding.etSingle.etValue.getText();
        editText.setSelection(text != null ? text.length() : 0);
        this.isFormattingMoney = false;
    }

    public final void setIcon(int i) {
        TextView textView = this.binding.etSingle.tvSuffix;
        Context context = this.binding.root.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.setText(TextWithIconsKt.toTextWithIcons("<ic>1<ic>", context, new IconAndSize(i, R.dimen._12sdp, R.dimen._12sdp)));
    }
}
