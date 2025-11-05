package ru.mrlargha.feature.mobile.presentation.page.rent;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.internal.view.SupportMenu;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.CustomEditText;
import ru.mrlargha.commonui.utils.ui.EditeTextValidationErrorType;
import ru.mrlargha.feature.mobile.R;
/* compiled from: ArizonaRentResponse.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aT\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\u0010\u000e\u001a]\u0010\u000f\u001a\u00020\u0001*\u00020\u00102\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162#\u0010\u0017\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\t\u001a0\u0010\u001a\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u00010\t\u001a\u0018\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0014H\u0002¨\u0006\u001e"}, d2 = {"checkAvailableData", "", "Landroid/widget/EditText;", "maxInputInt", "", "minInputInt", "checkEmptyValue", "", "result", "Lkotlin/Function1;", "Lru/mrlargha/feature/mobile/presentation/page/rent/EditTextCheckResult;", "Lkotlin/ParameterName;", "name", "checkResult", "(Landroid/widget/EditText;Ljava/lang/Integer;Ljava/lang/Integer;ZLkotlin/jvm/functions/Function1;)V", "onChangeListeners", "Lru/mrlargha/commonui/utils/ui/CustomEditText;", "minValue", "maxValue", "etContainer", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "tvError", "Landroid/widget/TextView;", "afterTextChanged", "Landroid/text/Editable;", CmcdData.STREAMING_FORMAT_SS, "checkValidate", "isError", "showError", "customCardView", "mobile_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaRentResponseKt {

    /* compiled from: ArizonaRentResponse.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EditeTextValidationErrorType.values().length];
            try {
                iArr[EditeTextValidationErrorType.SUCCESSFUL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EditeTextValidationErrorType.EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EditeTextValidationErrorType.MIN_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EditeTextValidationErrorType.MAX_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void checkAvailableData$default(EditText editText, Integer num, Integer num2, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        checkAvailableData(editText, num, num2, z, function1);
    }

    public static final void checkAvailableData(EditText editText, Integer num, Integer num2, boolean z, Function1<? super EditTextCheckResult, Unit> result) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Intrinsics.checkNotNullParameter(result, "result");
        String obj = StringsKt.trim((CharSequence) editText.getText().toString()).toString();
        if (z && obj.length() == 0) {
            result.invoke(EditTextCheckResult.EMPTY_VALUE);
            return;
        }
        Integer intOrNull = StringsKt.toIntOrNull(obj);
        if ((num != null || num2 != null) && intOrNull == null) {
            result.invoke(EditTextCheckResult.EMPTY_VALUE);
            return;
        }
        if (intOrNull != null) {
            int intValue = intOrNull.intValue();
            if (num2 != null && intValue < num2.intValue()) {
                result.invoke(EditTextCheckResult.TOO_SMALL_VALUE);
                return;
            } else if (num != null && intValue > num.intValue()) {
                result.invoke(EditTextCheckResult.TOO_BIG_VALUE);
                return;
            }
        }
        result.invoke(EditTextCheckResult.SUCCESSFUL);
    }

    public static /* synthetic */ void onChangeListeners$default(CustomEditText customEditText, boolean z, int i, int i2, CustomCardView customCardView, TextView textView, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = true;
        }
        if ((i3 & 2) != 0) {
            i = 1;
        }
        if ((i3 & 4) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        onChangeListeners(customEditText, z, i, i2, customCardView, textView, function1);
    }

    public static final void onChangeListeners(final CustomEditText customEditText, boolean z, int i, int i2, final CustomCardView etContainer, final TextView tvError, final Function1<? super Editable, Unit> afterTextChanged) {
        Intrinsics.checkNotNullParameter(customEditText, "<this>");
        Intrinsics.checkNotNullParameter(etContainer, "etContainer");
        Intrinsics.checkNotNullParameter(tvError, "tvError");
        Intrinsics.checkNotNullParameter(afterTextChanged, "afterTextChanged");
        Object tag = customEditText.getTag(R.id.text_watcher_tag);
        TextWatcher textWatcher = tag instanceof TextWatcher ? (TextWatcher) tag : null;
        if (textWatcher != null) {
            customEditText.removeTextChangedListener(textWatcher);
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        TextWatcher textWatcher2 = new TextWatcher() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentResponseKt$onChangeListeners$textWatcher$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Ref.BooleanRef.this.element = false;
            }
        };
        customEditText.addTextChangedListener(textWatcher2);
        customEditText.setTag(R.id.text_watcher_tag, textWatcher2);
        customEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentResponseKt$$ExternalSyntheticLambda0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                boolean onChangeListeners$lambda$0;
                onChangeListeners$lambda$0 = ArizonaRentResponseKt.onChangeListeners$lambda$0(CustomEditText.this, etContainer, tvError, booleanRef, afterTextChanged, textView, i3, keyEvent);
                return onChangeListeners$lambda$0;
            }
        });
        customEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentResponseKt$$ExternalSyntheticLambda1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z2) {
                ArizonaRentResponseKt.onChangeListeners$lambda$1(Ref.BooleanRef.this, customEditText, view, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onChangeListeners$lambda$0(CustomEditText customEditText, CustomCardView customCardView, TextView textView, Ref.BooleanRef booleanRef, final Function1 function1, TextView textView2, int i, KeyEvent keyEvent) {
        if (i == 6) {
            checkValidate(customEditText, customCardView, textView, new Function1() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentResponseKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit onChangeListeners$lambda$0$0;
                    onChangeListeners$lambda$0$0 = ArizonaRentResponseKt.onChangeListeners$lambda$0$0(Function1.this, (Editable) obj);
                    return onChangeListeners$lambda$0$0;
                }
            });
            booleanRef.element = true;
            customEditText.clearFocus();
            Object systemService = customEditText.getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(customEditText.getWindowToken(), 0);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onChangeListeners$lambda$0$0(Function1 function1, Editable editable) {
        function1.invoke(editable);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onChangeListeners$lambda$1(Ref.BooleanRef booleanRef, CustomEditText customEditText, View view, boolean z) {
        if (z || booleanRef.element) {
            return;
        }
        customEditText.setText("");
    }

    public static final void checkValidate(CustomEditText customEditText, CustomCardView etContainer, TextView tvError, Function1<? super Editable, Unit> afterTextChanged) {
        Intrinsics.checkNotNullParameter(customEditText, "<this>");
        Intrinsics.checkNotNullParameter(etContainer, "etContainer");
        Intrinsics.checkNotNullParameter(tvError, "tvError");
        Intrinsics.checkNotNullParameter(afterTextChanged, "afterTextChanged");
        int i = WhenMappings.$EnumSwitchMapping$0[customEditText.getEditTextValidationBuilder().checkValidationField().ordinal()];
        if (i == 1) {
            isError(false, etContainer);
            tvError.setVisibility(8);
            afterTextChanged.invoke(customEditText.getEditableText());
        } else if (i == 2) {
            isError(true, etContainer);
            tvError.setVisibility(0);
            tvError.setText(etContainer.getContext().getString(R.string.error_input_form));
            afterTextChanged.invoke(null);
        } else if (i == 3) {
            customEditText.setText(String.valueOf(customEditText.getEditTextValidationBuilder().getMinInputCount()));
            Editable text = customEditText.getText();
            customEditText.setSelection(text != null ? text.length() : 0);
            isError(false, etContainer);
            Toast.makeText(customEditText.getContext(), "Значение должно быть не менее " + customEditText.getEditTextValidationBuilder().getMinInputCount(), 0).show();
            tvError.setVisibility(8);
            afterTextChanged.invoke(customEditText.getEditableText());
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            customEditText.setText(String.valueOf(customEditText.getEditTextValidationBuilder().getMaxInputCount()));
            Editable text2 = customEditText.getText();
            customEditText.setSelection(text2 != null ? text2.length() : 0);
            Toast.makeText(customEditText.getContext(), "Значение должно быть не более " + customEditText.getEditTextValidationBuilder().getMaxInputCount(), 0).show();
            isError(false, etContainer);
            tvError.setVisibility(8);
            afterTextChanged.invoke(customEditText.getEditableText());
        }
    }

    private static final void isError(boolean z, CustomCardView customCardView) {
        if (z) {
            customCardView.setBorder(SupportMenu.CATEGORY_MASK);
        } else {
            customCardView.setBorder(Color.parseColor("#1AFFFFFF"));
        }
    }
}
