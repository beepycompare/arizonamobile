package ru.mrlargha.commonui.elements.trade.presentation;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.ViewMoneyPartInputBinding;
import ru.mrlargha.commonui.databinding.ViewUniversalMoneyInputBinding;
import ru.mrlargha.commonui.utils.ui.money.MoneyElementKt;
import ru.mrlargha.commonui.utils.ui.money.MoneyFormatter;
import ru.mrlargha.commonui.utils.ui.money.MoneyParts;
import ru.mrlargha.commonui.utils.ui.textWithIcons.IconAndSize;
import ru.mrlargha.commonui.utils.ui.textWithIcons.TextWithIconsKt;
/* compiled from: TradeEditText.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\b\u0010 \u001a\u00020\u0017H\u0002J\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\rJ \u0010#\u001a\u00020\u00172\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u001e0\u001cJ\u000e\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u000bJ\u000e\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0016J\r\u0010(\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010)J\u000e\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u000bJ\u001e\u0010,\u001a\u00020\u00172\u0016\u0010-\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015J\u0006\u0010.\u001a\u00020\u0017J\b\u0010/\u001a\u00020\u0017H\u0002J\b\u00100\u001a\u00020\u0017H\u0002J\u000e\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u001e0\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lru/mrlargha/commonui/elements/trade/presentation/TradeEditText;", "", "binding", "Lru/mrlargha/commonui/databinding/ViewUniversalMoneyInputBinding;", "<init>", "(Lru/mrlargha/commonui/databinding/ViewUniversalMoneyInputBinding;)V", "blockM", "Lru/mrlargha/commonui/elements/trade/presentation/MoneyPartFieldController;", "blockKK", "blockK", "isNewMoney", "", "editTextType", "", "getEditTextType", "()I", "setEditTextType", "(I)V", "singleWatcher", "Landroid/text/TextWatcher;", "onValueChanged", "Lkotlin/Function1;", "", "", "ignoreChanges", "kFormattingWatcher", "isFormattingK", "limits", "", "", "", "setupBlocks", "setupSingleField", "setType", "type", "setLimits", "setValidation", "validation", "setValue", "value", "getValue", "()Ljava/lang/Long;", "setEnabled", "enabled", "setOnValueChanged", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "requestFocus", "notifyValueChanged", "setupKFormatting", "setIcon", "icon", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TradeEditText {
    private final ViewUniversalMoneyInputBinding binding;
    private final MoneyPartFieldController blockK;
    private final MoneyPartFieldController blockKK;
    private final MoneyPartFieldController blockM;
    private int editTextType;
    private boolean ignoreChanges;
    private boolean isFormattingK;
    private boolean isNewMoney;
    private TextWatcher kFormattingWatcher;
    private Map<String, ? extends List<Long>> limits;
    private Function1<? super Long, Unit> onValueChanged;
    private TextWatcher singleWatcher;

    public TradeEditText(ViewUniversalMoneyInputBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        ViewMoneyPartInputBinding bind = ViewMoneyPartInputBinding.bind(binding.blockM.getRoot());
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.blockM = new MoneyPartFieldController(bind);
        ViewMoneyPartInputBinding bind2 = ViewMoneyPartInputBinding.bind(binding.blockKK.getRoot());
        Intrinsics.checkNotNullExpressionValue(bind2, "bind(...)");
        this.blockKK = new MoneyPartFieldController(bind2);
        ViewMoneyPartInputBinding bind3 = ViewMoneyPartInputBinding.bind(binding.blockK.getRoot());
        Intrinsics.checkNotNullExpressionValue(bind3, "bind(...)");
        this.blockK = new MoneyPartFieldController(bind3);
        this.limits = MapsKt.emptyMap();
        setupBlocks();
        setupSingleField();
    }

    public final int getEditTextType() {
        return this.editTextType;
    }

    public final void setEditTextType(int i) {
        this.editTextType = i;
    }

    private final void setupBlocks() {
        this.blockM.setup(":m:", 4);
        this.blockKK.setup(":kk:", 3);
        this.blockK.setup(":k:", 6);
        this.blockM.setHint("0");
        this.blockKK.setHint("0");
        this.blockK.setHint("0.000");
        this.blockM.setOnTextChanged(new Function0() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeEditText$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TradeEditText.setupBlocks$lambda$0(TradeEditText.this);
            }
        });
        this.blockKK.setOnTextChanged(new Function0() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeEditText$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TradeEditText.setupBlocks$lambda$1(TradeEditText.this);
            }
        });
        setupKFormatting();
        this.blockM.getEditText().setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeEditText$$ExternalSyntheticLambda2
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return TradeEditText.setupBlocks$lambda$2(TradeEditText.this, textView, i, keyEvent);
            }
        });
        this.blockKK.getEditText().setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeEditText$$ExternalSyntheticLambda3
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return TradeEditText.setupBlocks$lambda$3(TradeEditText.this, textView, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit setupBlocks$lambda$0(TradeEditText tradeEditText) {
        tradeEditText.notifyValueChanged();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit setupBlocks$lambda$1(TradeEditText tradeEditText) {
        tradeEditText.notifyValueChanged();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean setupBlocks$lambda$2(TradeEditText tradeEditText, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 5) {
            tradeEditText.blockKK.requestFocus();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean setupBlocks$lambda$3(TradeEditText tradeEditText, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 5) {
            tradeEditText.blockK.requestFocus();
            return true;
        }
        return false;
    }

    private final void setupSingleField() {
        this.binding.etSingle.etValue.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(13)});
        this.singleWatcher = new TextWatcher() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeEditText$setupSingleField$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                TradeEditText.this.notifyValueChanged();
            }
        };
        this.binding.etSingle.etValue.addTextChangedListener(this.singleWatcher);
    }

    public final void setType(int i) {
        this.isNewMoney = false;
        this.editTextType = i;
        if (i == 0) {
            this.isNewMoney = true;
        } else if (i == 1) {
            setIcon(R.drawable.trade_euro_ic);
        } else if (i == 2) {
            setIcon(R.drawable.trade_bitcoin_ic);
        } else if (i == 3) {
            setIcon(R.drawable.trade_asc_ic);
        } else if (i == 10) {
            setIcon(R.drawable.ic_rubble);
        }
        this.binding.layoutMoney.setVisibility(this.isNewMoney ? 0 : 8);
        this.binding.etSingle.getRoot().setVisibility(this.isNewMoney ? 8 : 0);
    }

    public final void setLimits(Map<String, ? extends List<Long>> limits) {
        Intrinsics.checkNotNullParameter(limits, "limits");
        this.limits = limits;
    }

    public final void setValidation(boolean z) {
        int parseColor = Color.parseColor(z ? "#1AFFFFFF" : "#E2254E");
        this.blockM.setColor(parseColor);
        this.blockK.setColor(parseColor);
        this.blockKK.setColor(parseColor);
        this.binding.etSingle.getRoot().setBorder(parseColor);
    }

    public final void setValue(long j) {
        this.ignoreChanges = true;
        if (this.isNewMoney) {
            MoneyParts splitValue = MoneyFormatter.INSTANCE.splitValue(j);
            this.blockM.setValue(String.valueOf(splitValue.getM()));
            this.blockKK.setValue(String.valueOf(splitValue.getKk()));
            this.blockK.setValue(MoneyFormatter.INSTANCE.formatK(splitValue.getK()));
        } else {
            this.binding.etSingle.etValue.setText(String.valueOf(j));
            EditText editText = this.binding.etSingle.etValue;
            Editable text = this.binding.etSingle.etValue.getText();
            editText.setSelection(text != null ? text.length() : 0);
        }
        this.ignoreChanges = false;
    }

    public final Long getValue() {
        long longValue;
        String obj;
        Long longOrNull;
        List<Long> orDefault = this.limits.getOrDefault(String.valueOf(this.editTextType), null);
        if (this.isNewMoney) {
            Integer intOrNull = StringsKt.toIntOrNull(this.blockM.getValue());
            int intValue = intOrNull != null ? intOrNull.intValue() : 0;
            Integer intOrNull2 = StringsKt.toIntOrNull(this.blockKK.getValue());
            int intValue2 = intOrNull2 != null ? intOrNull2.intValue() : 0;
            Integer intOrNull3 = StringsKt.toIntOrNull(this.blockK.getValue());
            longValue = MoneyElementKt.toLong(new MoneyParts(intValue, intValue2, intOrNull3 != null ? intOrNull3.intValue() : 0));
        } else {
            Editable text = this.binding.etSingle.etValue.getText();
            longValue = (text == null || (obj = text.toString()) == null || (longOrNull = StringsKt.toLongOrNull(obj)) == null) ? 0L : longOrNull.longValue();
        }
        if (orDefault == null || (longValue >= orDefault.get(0).longValue() && longValue <= orDefault.get(1).longValue())) {
            return Long.valueOf(longValue);
        }
        return null;
    }

    public final void setEnabled(boolean z) {
        this.binding.etSingle.etValue.setEnabled(z);
        this.blockM.setEnabled(z);
        this.blockKK.setEnabled(z);
        this.blockK.setEnabled(z);
    }

    public final void setOnValueChanged(Function1<? super Long, Unit> function1) {
        this.onValueChanged = function1;
    }

    public final void requestFocus() {
        if (this.isNewMoney) {
            this.blockM.requestFocus();
            return;
        }
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

    private final void setupKFormatting() {
        final EditText editText = this.blockK.getEditText();
        TextWatcher textWatcher = this.kFormattingWatcher;
        if (textWatcher != null) {
            editText.removeTextChangedListener(textWatcher);
        }
        TextWatcher textWatcher2 = new TextWatcher() { // from class: ru.mrlargha.commonui.elements.trade.presentation.TradeEditText$setupKFormatting$2
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
                z = TradeEditText.this.ignoreChanges;
                if (!z) {
                    z3 = TradeEditText.this.isFormattingK;
                    if (!z3) {
                        String obj = editable != null ? editable.toString() : null;
                        String str = "";
                        if (obj == null) {
                            obj = "";
                        }
                        String str2 = obj;
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i = 0; i < length; i++) {
                            char charAt = str2.charAt(i);
                            if (Character.isDigit(charAt)) {
                                sb.append(charAt);
                            }
                        }
                        String takeLast = StringsKt.takeLast(sb.toString(), 6);
                        if (takeLast.length() != 0) {
                            MoneyFormatter moneyFormatter = MoneyFormatter.INSTANCE;
                            Integer intOrNull = StringsKt.toIntOrNull(takeLast);
                            str = moneyFormatter.formatK(intOrNull != null ? intOrNull.intValue() : 0);
                        }
                        if (!Intrinsics.areEqual(obj, str)) {
                            TradeEditText.this.isFormattingK = true;
                            editText.setText(str);
                            EditText editText2 = editText;
                            Editable text = editText2.getText();
                            editText2.setSelection(text != null ? text.length() : 0);
                            TradeEditText.this.isFormattingK = false;
                        }
                        TradeEditText.this.notifyValueChanged();
                        return;
                    }
                }
                z2 = TradeEditText.this.ignoreChanges;
                if (z2) {
                    return;
                }
                TradeEditText.this.notifyValueChanged();
            }
        };
        this.kFormattingWatcher = textWatcher2;
        editText.addTextChangedListener(textWatcher2);
    }

    public final void setIcon(int i) {
        TextView textView = this.binding.etSingle.tvSuffix;
        Context context = this.binding.root.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.setText(TextWithIconsKt.toTextWithIcons("<ic>1<ic>", context, new IconAndSize(i, R.dimen._12sdp, R.dimen._12sdp)));
    }
}
