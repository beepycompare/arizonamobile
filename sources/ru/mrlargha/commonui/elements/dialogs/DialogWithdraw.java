package ru.mrlargha.commonui.elements.dialogs;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.autofill.HintConstants;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.DialogWithdrawBinding;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.money.MoneyElementKt;
/* compiled from: DialogWithdraw.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0010\u0018\u0000 ?2\u00020\u0001:\u0001?BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u001f\u001a\u00020\u000fJ\b\u0010 \u001a\u00020!H\u0002J$\u0010\"\u001a\u00020!*\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\fJ\u001e\u0010(\u001a\u00020!*\u00020#2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\fH\u0002J \u0010)\u001a\u00020!*\u00020&2\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\fH\u0002J \u0010+\u001a\u00020!*\u00020&2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\fH\u0002J\f\u0010-\u001a\u00020\f*\u00020&H\u0002J\u0016\u0010.\u001a\u00020!*\u00020&2\b\b\u0002\u0010'\u001a\u00020\fH\u0002J\f\u0010/\u001a\u000200*\u00020&H\u0002J\b\u00101\u001a\u000200H\u0002J\u0014\u00102\u001a\u00020!*\u00020&2\u0006\u00103\u001a\u000200H\u0002J\f\u00104\u001a\u00020!*\u00020&H\u0002J\u0014\u00105\u001a\u00020!*\u00020&2\u0006\u00106\u001a\u00020#H\u0002J\f\u00107\u001a\u00020!*\u00020&H\u0002J\u001c\u00108\u001a\u00020\f*\u00020&2\u0006\u0010$\u001a\u00020#2\u0006\u00109\u001a\u00020#H\u0002J\u0010\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020\u000fH\u0002J\u000e\u0010<\u001a\u00020!2\u0006\u0010=\u001a\u00020\fJ\b\u0010>\u001a\u00020!H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogWithdraw;", "Lru/mrlargha/commonui/elements/dialogs/AbstractDialog;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "caption", "Landroid/text/SpannableString;", "info", "leftButtonText", "rightButtonText", "passwordMode", "", "sampDialogId", "hintInput", "", "<init>", "(Landroid/app/Activity;ILandroid/text/SpannableString;Landroid/text/SpannableString;Landroid/text/SpannableString;Landroid/text/SpannableString;ZILjava/lang/String;)V", "dialogLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/commonui/databinding/DialogWithdrawBinding;", "isKeyboardShowing", "scope", "Lkotlinx/coroutines/CoroutineScope;", "plusJob", "Lkotlinx/coroutines/Job;", "minusJob", "limits", "Lru/mrlargha/commonui/elements/dialogs/DialogWithdrawLimit;", "getInputCost", "setupListeners", "", "onClickPlus", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "btnMinus", "et", "Landroid/widget/EditText;", "isDouble", "onClickMinus", "minusOne", "minusCount", "plusOne", "plusCount", "checkIsZero", "setFilter", "getMoneyValue", "", "getMaxMoney", "setMoneyValue", "value", "setMoneyIconSize", "setFocus", "cardView", "setLimit", "checkValidate", "customFieldLayout", "savePassword", HintConstants.AUTOFILL_HINT_NEW_PASSWORD, "checkActiveButton", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "checkEtValidates", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogWithdraw extends AbstractDialog {
    private static final long DEFAULT_MAX_MONEY = 999999999999L;
    public static final String PASSWORD_SP_NAME = "PASSWORD_SP_FIELD";
    private static final String TAG = "UserInputDialog";
    private final DialogWithdrawBinding binding;
    private final View dialogLayout;
    private boolean isKeyboardShowing;
    private DialogWithdrawLimit limits;
    private Job minusJob;
    private final boolean passwordMode;
    private Job plusJob;
    private final CoroutineScope scope;
    public static final Companion Companion = new Companion(null);
    private static final Map<Integer, String> inputHistory = new LinkedHashMap();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogWithdraw(final Activity targetActivity, int i, SpannableString caption, SpannableString info, SpannableString leftButtonText, SpannableString rightButtonText, boolean z, final int i2, String hintInput) {
        super(targetActivity, i, i2);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(caption, "caption");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(leftButtonText, "leftButtonText");
        Intrinsics.checkNotNullParameter(rightButtonText, "rightButtonText");
        Intrinsics.checkNotNullParameter(hintInput, "hintInput");
        this.passwordMode = z;
        Object obj = null;
        View dialogLayout = LayoutInflater.from(targetActivity).inflate(R.layout.dialog_withdraw, (ViewGroup) null, false);
        this.dialogLayout = dialogLayout;
        DialogWithdrawBinding bind = DialogWithdrawBinding.bind(dialogLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        Log.d(TAG, "info: " + ((Object) info) + ", caption: " + ((Object) caption) + ", leftButtonText: " + ((Object) leftButtonText) + ", rightButtonText: " + ((Object) rightButtonText) + ", hintInput: " + hintInput);
        bind.buttons.button1.setAlpha(0.5f);
        bind.buttons.button1.setEnabled(false);
        if (MapperKt.isJsonValid(hintInput) && !Intrinsics.areEqual(hintInput, AbstractJsonLexerKt.NULL) && !Intrinsics.areEqual(hintInput, "{}") && hintInput.length() != 0) {
            obj = MapperKt.getGson().fromJson(hintInput, (Class<Object>) DialogWithdrawLimit.class);
        }
        this.limits = (DialogWithdrawLimit) obj;
        Intrinsics.checkNotNullExpressionValue(dialogLayout, "dialogLayout");
        addViewToConstraintLayout(dialogLayout, -2, -2);
        setPosition(SAMPUIElement.PositionType.CENTER, 0, 0);
        dialogLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogWithdraw$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                DialogWithdraw.lambda$0$0(DialogWithdraw.this);
            }
        });
        bind.infoText.setText(info);
        bind.infoText.setMovementMethod(new ScrollingMovementMethod());
        bind.caption.setText(caption);
        setVisibility(true);
        SpannableString spannableString = leftButtonText;
        if (spannableString.length() == 0) {
            bind.buttons.button1.setVisibility(8);
        } else {
            bind.buttons.tvAccept.setText(spannableString);
            bind.buttons.button1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogWithdraw$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogWithdraw.lambda$0$1(targetActivity, this, i2, view);
                }
            });
        }
        SpannableString spannableString2 = rightButtonText;
        if (spannableString2.length() == 0) {
            bind.buttons.button2.setVisibility(8);
        } else {
            bind.buttons.tvCancel.setText(spannableString2);
            bind.buttons.button2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogWithdraw$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogWithdraw.lambda$0$2(targetActivity, this, i2, view);
                }
            });
        }
        bind.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogWithdraw$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogWithdraw.lambda$0$3(targetActivity, this, i2, view);
            }
        });
        setupListeners();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$0(DialogWithdraw dialogWithdraw) {
        Rect rect = new Rect();
        dialogWithdraw.dialogLayout.getWindowVisibleDisplayFrame(rect);
        int height = dialogWithdraw.dialogLayout.getRootView().getRootView().getHeight();
        int i = height - rect.bottom;
        if (i > height * 0.15d) {
            if (dialogWithdraw.isKeyboardShowing) {
                return;
            }
            Log.d(TAG, "Keyboard was shown");
            dialogWithdraw.isKeyboardShowing = true;
            dialogWithdraw.setPosition(SAMPUIElement.PositionType.CENTER_TOP, 0, (height - i) - dialogWithdraw.dialogLayout.getHeight());
        } else if (dialogWithdraw.isKeyboardShowing) {
            Log.d(TAG, "Keyboard was closed");
            dialogWithdraw.isKeyboardShowing = false;
            dialogWithdraw.setPosition(SAMPUIElement.PositionType.CENTER, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$1(Activity activity, DialogWithdraw dialogWithdraw, int i, View view) {
        SAMPUIElement.Companion.hideKeyboard(activity);
        if (!dialogWithdraw.passwordMode) {
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.dialogs.IAutocompleteStateProvider");
            if (((IAutocompleteStateProvider) activity).getAutocompleteState()) {
                inputHistory.put(Integer.valueOf(i), dialogWithdraw.getInputCost());
            }
        }
        dialogWithdraw.getNotifier().onDialogResponseWrapper(i, 1, -1, StringsKt.encodeToByteArray(dialogWithdraw.getInputCost()));
        dialogWithdraw.getNotifier().destroyDialog();
        if (dialogWithdraw.passwordMode) {
            dialogWithdraw.savePassword(dialogWithdraw.getInputCost());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$2(Activity activity, DialogWithdraw dialogWithdraw, int i, View view) {
        SAMPUIElement.Companion.hideKeyboard(activity);
        dialogWithdraw.getNotifier().onDialogResponseWrapper(i, 0, -1, StringsKt.encodeToByteArray(dialogWithdraw.getInputCost()));
        dialogWithdraw.getNotifier().destroyDialog();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$3(Activity activity, DialogWithdraw dialogWithdraw, int i, View view) {
        SAMPUIElement.Companion.hideKeyboard(activity);
        dialogWithdraw.getNotifier().onDialogResponseWrapper(i, 0, -1, StringsKt.encodeToByteArray(dialogWithdraw.getInputCost()));
        dialogWithdraw.getNotifier().destroyDialog();
    }

    public final String getInputCost() {
        EditText etMoney = this.binding.etMoney;
        Intrinsics.checkNotNullExpressionValue(etMoney, "etMoney");
        return String.valueOf(getMoneyValue(etMoney));
    }

    private final void setupListeners() {
        DialogWithdrawBinding dialogWithdrawBinding = this.binding;
        CustomCardView btnMinus = dialogWithdrawBinding.btnMinus;
        Intrinsics.checkNotNullExpressionValue(btnMinus, "btnMinus");
        EditText etMoney = dialogWithdrawBinding.etMoney;
        Intrinsics.checkNotNullExpressionValue(etMoney, "etMoney");
        onClickMinus$default(this, btnMinus, etMoney, false, 2, null);
        CustomCardView btnPlus = dialogWithdrawBinding.btnPlus;
        Intrinsics.checkNotNullExpressionValue(btnPlus, "btnPlus");
        CustomCardView btnMinus2 = dialogWithdrawBinding.btnMinus;
        Intrinsics.checkNotNullExpressionValue(btnMinus2, "btnMinus");
        EditText etMoney2 = dialogWithdrawBinding.etMoney;
        Intrinsics.checkNotNullExpressionValue(etMoney2, "etMoney");
        onClickPlus$default(this, btnPlus, btnMinus2, etMoney2, false, 4, null);
        EditText etMoney3 = dialogWithdrawBinding.etMoney;
        Intrinsics.checkNotNullExpressionValue(etMoney3, "etMoney");
        setFilter$default(this, etMoney3, false, 1, null);
        EditText etMoney4 = dialogWithdrawBinding.etMoney;
        Intrinsics.checkNotNullExpressionValue(etMoney4, "etMoney");
        CustomCardView cardViewMoney = dialogWithdrawBinding.cardViewMoney;
        Intrinsics.checkNotNullExpressionValue(cardViewMoney, "cardViewMoney");
        setFocus(etMoney4, cardViewMoney);
        EditText etMoney5 = dialogWithdrawBinding.etMoney;
        Intrinsics.checkNotNullExpressionValue(etMoney5, "etMoney");
        setLimit(etMoney5);
        EditText etMoney6 = dialogWithdrawBinding.etMoney;
        Intrinsics.checkNotNullExpressionValue(etMoney6, "etMoney");
        setMoneyIconSize(etMoney6);
        EditText etMoney7 = dialogWithdrawBinding.etMoney;
        Intrinsics.checkNotNullExpressionValue(etMoney7, "etMoney");
        etMoney7.addTextChangedListener(new TextWatcher() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogWithdraw$setupListeners$lambda$0$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                DialogWithdraw.this.checkEtValidates();
            }
        });
        checkEtValidates();
    }

    public static /* synthetic */ void onClickPlus$default(DialogWithdraw dialogWithdraw, CustomCardView customCardView, CustomCardView customCardView2, EditText editText, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        dialogWithdraw.onClickPlus(customCardView, customCardView2, editText, z);
    }

    public final void onClickPlus(CustomCardView customCardView, final CustomCardView btnMinus, final EditText et, final boolean z) {
        Intrinsics.checkNotNullParameter(customCardView, "<this>");
        Intrinsics.checkNotNullParameter(btnMinus, "btnMinus");
        Intrinsics.checkNotNullParameter(et, "et");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        customCardView.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogWithdraw$$ExternalSyntheticLambda8
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return DialogWithdraw.onClickPlus$lambda$0(Ref.BooleanRef.this, this, et, z, btnMinus, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean onClickPlus$lambda$0(Ref.BooleanRef booleanRef, DialogWithdraw dialogWithdraw, EditText editText, boolean z, CustomCardView customCardView, View view, MotionEvent motionEvent) {
        Job launch$default;
        int action = motionEvent.getAction();
        if (action == 0) {
            booleanRef.element = false;
            Job job = dialogWithdraw.plusJob;
            if (job != null) {
                Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            launch$default = BuildersKt__Builders_commonKt.launch$default(dialogWithdraw.scope, null, null, new DialogWithdraw$onClickPlus$1$1(booleanRef, dialogWithdraw, editText, z, customCardView, null), 3, null);
            dialogWithdraw.plusJob = launch$default;
            return true;
        } else if (action != 1) {
            if (action != 3) {
                return false;
            }
            Job job2 = dialogWithdraw.plusJob;
            if (job2 != null) {
                Job.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            return true;
        } else {
            Job job3 = dialogWithdraw.plusJob;
            if (job3 != null) {
                Job.cancel$default(job3, (CancellationException) null, 1, (Object) null);
            }
            if (!booleanRef.element) {
                dialogWithdraw.plusOne(editText, 1, z);
                dialogWithdraw.checkEtValidates();
                CustomCardView.changeValidate$default(customCardView, dialogWithdraw.checkIsZero(editText), 0.0f, 2, null);
            }
            view.performClick();
            return true;
        }
    }

    static /* synthetic */ void onClickMinus$default(DialogWithdraw dialogWithdraw, CustomCardView customCardView, EditText editText, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        dialogWithdraw.onClickMinus(customCardView, editText, z);
    }

    private final void onClickMinus(final CustomCardView customCardView, final EditText editText, final boolean z) {
        CustomCardView.changeValidate$default(customCardView, checkIsZero(editText), 0.0f, 2, null);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        customCardView.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogWithdraw$$ExternalSyntheticLambda7
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return DialogWithdraw.onClickMinus$lambda$0(Ref.BooleanRef.this, this, editText, z, customCardView, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean onClickMinus$lambda$0(Ref.BooleanRef booleanRef, DialogWithdraw dialogWithdraw, EditText editText, boolean z, CustomCardView customCardView, View view, MotionEvent motionEvent) {
        Job launch$default;
        int action = motionEvent.getAction();
        if (action == 0) {
            booleanRef.element = false;
            Job job = dialogWithdraw.minusJob;
            if (job != null) {
                Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            launch$default = BuildersKt__Builders_commonKt.launch$default(dialogWithdraw.scope, null, null, new DialogWithdraw$onClickMinus$1$1(booleanRef, dialogWithdraw, editText, z, customCardView, null), 3, null);
            dialogWithdraw.minusJob = launch$default;
            return true;
        } else if (action != 1) {
            if (action != 3) {
                return false;
            }
            Job job2 = dialogWithdraw.minusJob;
            if (job2 != null) {
                Job.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            return true;
        } else {
            Job job3 = dialogWithdraw.minusJob;
            if (job3 != null) {
                Job.cancel$default(job3, (CancellationException) null, 1, (Object) null);
            }
            if (!booleanRef.element) {
                dialogWithdraw.minusOne(editText, 1, z);
                dialogWithdraw.checkEtValidates();
                CustomCardView.changeValidate$default(customCardView, dialogWithdraw.checkIsZero(editText), 0.0f, 2, null);
            }
            view.performClick();
            return true;
        }
    }

    static /* synthetic */ void minusOne$default(DialogWithdraw dialogWithdraw, EditText editText, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        dialogWithdraw.minusOne(editText, i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void minusOne(EditText editText, int i, boolean z) {
        if (z) {
            Float floatOrNull = StringsKt.toFloatOrNull(editText.getText().toString());
            if (floatOrNull != null) {
                floatOrNull.floatValue();
                if (floatOrNull.floatValue() > 0.0f) {
                    float f = i;
                    if (floatOrNull.floatValue() < f) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format(Locale.US, "%.3f", Arrays.copyOf(new Object[]{Float.valueOf(0.0f)}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                        editText.setText(format);
                        Job job = this.plusJob;
                        if (job != null) {
                            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
                        }
                        Job job2 = this.minusJob;
                        if (job2 != null) {
                            Job.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                            return;
                        }
                        return;
                    }
                    float floatValue = floatOrNull.floatValue() >= 1.0f ? floatOrNull.floatValue() - f : 0.0f;
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String format2 = String.format(Locale.US, "%.3f", Arrays.copyOf(new Object[]{Float.valueOf(floatValue)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                    editText.setText(format2);
                    return;
                }
                return;
            }
            setMoneyValue(editText, 0L);
            return;
        }
        long coerceAtLeast = RangesKt.coerceAtLeast(getMoneyValue(editText) - i, 0L);
        setMoneyValue(editText, coerceAtLeast);
        if (coerceAtLeast == 0) {
            Job job3 = this.plusJob;
            if (job3 != null) {
                Job.cancel$default(job3, (CancellationException) null, 1, (Object) null);
            }
            Job job4 = this.minusJob;
            if (job4 != null) {
                Job.cancel$default(job4, (CancellationException) null, 1, (Object) null);
            }
        }
    }

    static /* synthetic */ void plusOne$default(DialogWithdraw dialogWithdraw, EditText editText, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        dialogWithdraw.plusOne(editText, i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void plusOne(EditText editText, int i, boolean z) {
        if (z) {
            Float floatOrNull = StringsKt.toFloatOrNull(editText.getText().toString());
            float floatValue = floatOrNull != null ? floatOrNull.floatValue() : 0.0f;
            float f = i + floatValue;
            if (f <= 999.999d) {
                if (floatValue < 999.0f) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format(Locale.US, "%.3f", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    editText.setText(format);
                    return;
                }
                return;
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format(Locale.US, "%.3f", Arrays.copyOf(new Object[]{Float.valueOf(999.999f)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            editText.setText(format2);
            Job job = this.plusJob;
            if (job != null) {
                Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            Job job2 = this.minusJob;
            if (job2 != null) {
                Job.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                return;
            }
            return;
        }
        long moneyValue = getMoneyValue(editText);
        long maxMoney = getMaxMoney();
        long coerceAtMost = RangesKt.coerceAtMost(moneyValue + i, maxMoney);
        setMoneyValue(editText, coerceAtMost);
        if (coerceAtMost == maxMoney) {
            Job job3 = this.plusJob;
            if (job3 != null) {
                Job.cancel$default(job3, (CancellationException) null, 1, (Object) null);
            }
            Job job4 = this.minusJob;
            if (job4 != null) {
                Job.cancel$default(job4, (CancellationException) null, 1, (Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkIsZero(EditText editText) {
        return getMoneyValue(editText) != 0;
    }

    static /* synthetic */ void setFilter$default(DialogWithdraw dialogWithdraw, EditText editText, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        dialogWithdraw.setFilter(editText, z);
    }

    private final void setFilter(EditText editText, final boolean z) {
        InputFilter inputFilter = new InputFilter() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogWithdraw$$ExternalSyntheticLambda4
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return DialogWithdraw.setFilter$lambda$0(z, this, charSequence, i, i2, spanned, i3, i4);
            }
        };
        InputFilter[] filters = editText.getFilters();
        Intrinsics.checkNotNullExpressionValue(filters, "getFilters(...)");
        editText.setFilters((InputFilter[]) ArraysKt.plus(filters, inputFilter));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence setFilter$lambda$0(boolean z, DialogWithdraw dialogWithdraw, CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        String sb = new StringBuilder(spanned).replace(i3, i4, charSequence.subSequence(i, i2).toString()).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        String str = null;
        if (sb.length() == 0) {
            return null;
        }
        if (z) {
            Float floatOrNull = StringsKt.toFloatOrNull(sb);
            if ((floatOrNull == null || floatOrNull.floatValue() > 1000.0f) && (floatOrNull == null || !Intrinsics.areEqual(floatOrNull, 0.0f))) {
                str = "";
            }
            return str;
        }
        Long longOrNull = StringsKt.toLongOrNull(sb);
        return (longOrNull == null || longOrNull.longValue() > dialogWithdraw.getMaxMoney()) ? "" : "";
    }

    private final long getMoneyValue(EditText editText) {
        Long longOrNull = StringsKt.toLongOrNull(editText.getText().toString());
        if (longOrNull != null) {
            return longOrNull.longValue();
        }
        return 0L;
    }

    private final long getMaxMoney() {
        DialogWithdrawLimitModel limits;
        DialogWithdrawLimit dialogWithdrawLimit = this.limits;
        return (dialogWithdrawLimit == null || (limits = dialogWithdrawLimit.getLimits()) == null) ? DEFAULT_MAX_MONEY : limits.getMaxMoney();
    }

    private final void setMoneyValue(EditText editText, long j) {
        editText.setText(String.valueOf(j));
        editText.setSelection(editText.getText().length());
    }

    private final void setMoneyIconSize(EditText editText) {
        Drawable drawable = ContextCompat.getDrawable(editText.getContext(), R.drawable.ic_dollar);
        if (drawable == null) {
            return;
        }
        int dimensionPixelSize = editText.getResources().getDimensionPixelSize(R.dimen._14sdp);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        editText.setCompoundDrawablePadding(editText.getResources().getDimensionPixelSize(R.dimen._4sdp));
        editText.setCompoundDrawablesRelative(null, null, drawable, null);
    }

    private final void setFocus(EditText editText, final CustomCardView customCardView) {
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogWithdraw$$ExternalSyntheticLambda5
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                DialogWithdraw.setFocus$lambda$0(CustomCardView.this, this, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void setFocus$lambda$0(CustomCardView customCardView, DialogWithdraw dialogWithdraw, View view, boolean z) {
        Log.d(TAG, "setFocus: " + z);
        if (z) {
            customCardView.setBorder(Color.parseColor("#FFF600"));
            Job job = dialogWithdraw.plusJob;
            if (job != null) {
                Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            Job job2 = dialogWithdraw.minusJob;
            if (job2 != null) {
                Job.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
        } else if (customCardView.getBorderMainColor() != -65536) {
            customCardView.setBorder(Color.parseColor("#33FFFFFF"));
        }
    }

    private final void setLimit(EditText editText) {
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogWithdraw$$ExternalSyntheticLambda6
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return DialogWithdraw.setLimit$lambda$0(DialogWithdraw.this, textView, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean setLimit$lambda$0(DialogWithdraw dialogWithdraw, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            dialogWithdraw.checkEtValidates();
            Job job = dialogWithdraw.plusJob;
            if (job != null) {
                Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            Job job2 = dialogWithdraw.minusJob;
            if (job2 != null) {
                Job.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            Object systemService = textView.getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(textView.getWindowToken(), 0);
            return true;
        }
        return false;
    }

    private final boolean checkValidate(EditText editText, CustomCardView customCardView, CustomCardView customCardView2) {
        int parseColor;
        long moneyValue = getMoneyValue(editText);
        CustomCardView.changeValidate$default(customCardView, checkIsZero(editText), 0.0f, 2, null);
        DialogWithdrawLimit dialogWithdrawLimit = this.limits;
        if (dialogWithdrawLimit != null) {
            try {
                long minMoney = dialogWithdrawLimit.getLimits().getMinMoney();
                long maxMoney = dialogWithdrawLimit.getLimits().getMaxMoney();
                if (moneyValue > maxMoney) {
                    TextView tvError = this.binding.tvError;
                    Intrinsics.checkNotNullExpressionValue(tvError, "tvError");
                    tvError.setVisibility(0);
                    customCardView2.setBorder(SupportMenu.CATEGORY_MASK);
                    this.binding.tvError.setText(MoneyElementKt.toMoneyFormattedSpannable$default(maxMoney, false, "Максимум ", null, null, 13, null));
                    checkActiveButton(false);
                    return false;
                } else if (1 <= moneyValue && moneyValue < minMoney) {
                    TextView tvError2 = this.binding.tvError;
                    Intrinsics.checkNotNullExpressionValue(tvError2, "tvError");
                    tvError2.setVisibility(0);
                    customCardView2.setBorder(SupportMenu.CATEGORY_MASK);
                    TextView textView = this.binding.tvError;
                    String string = getTargetActivity().getString(R.string.dialog_withdraw_minimum_prefix);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    textView.setText(MoneyElementKt.toMoneyFormattedSpannable$default(minMoney, false, string, null, null, 13, null));
                    checkActiveButton(false);
                    return false;
                } else {
                    TextView tvError3 = this.binding.tvError;
                    Intrinsics.checkNotNullExpressionValue(tvError3, "tvError");
                    tvError3.setVisibility(8);
                    if (editText.hasFocus()) {
                        parseColor = Color.parseColor("#FFF600");
                    } else {
                        parseColor = Color.parseColor("#33FFFFFF");
                    }
                    customCardView2.setBorder(parseColor);
                    boolean z = moneyValue >= minMoney;
                    checkActiveButton(z);
                    return z;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        checkActiveButton(true);
        return true;
    }

    private final void savePassword(String str) {
        int length = str.length();
        if (6 > length || length >= 33) {
            return;
        }
        getSharedPreferences().edit().putString("PASSWORD_SP_FIELD", str).apply();
    }

    public final void checkActiveButton(boolean z) {
        DialogWithdrawBinding dialogWithdrawBinding = this.binding;
        if (z) {
            dialogWithdrawBinding.buttons.button1.setAlpha(1.0f);
            this.binding.buttons.button1.setEnabled(true);
            return;
        }
        dialogWithdrawBinding.buttons.button1.setAlpha(0.5f);
        this.binding.buttons.button1.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkEtValidates() {
        EditText etMoney = this.binding.etMoney;
        Intrinsics.checkNotNullExpressionValue(etMoney, "etMoney");
        CustomCardView btnMinus = this.binding.btnMinus;
        Intrinsics.checkNotNullExpressionValue(btnMinus, "btnMinus");
        CustomCardView cardViewMoney = this.binding.cardViewMoney;
        Intrinsics.checkNotNullExpressionValue(cardViewMoney, "cardViewMoney");
        checkValidate(etMoney, btnMinus, cardViewMoney);
    }

    /* compiled from: DialogWithdraw.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogWithdraw$Companion;", "", "<init>", "()V", "TAG", "", "DEFAULT_MAX_MONEY", "", "PASSWORD_SP_NAME", "inputHistory", "", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
