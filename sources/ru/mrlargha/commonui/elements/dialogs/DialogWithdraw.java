package ru.mrlargha.commonui.elements.dialogs;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.autofill.HintConstants;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.JsonParseException;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.DialogWithdrawBinding;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.money.MoneyElementKt;
import ru.mrlargha.commonui.utils.ui.money.MoneyParts;
/* compiled from: DialogWithdraw.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 A2\u00020\u0001:\u0001ABO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010 \u001a\u00020!H\u0002J$\u0010\"\u001a\u00020!*\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\fJ\u001e\u0010(\u001a\u00020!*\u00020#2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\fH\u0002J \u0010)\u001a\u00020!*\u00020&2\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\fH\u0002J \u0010+\u001a\u00020!*\u00020&2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\fH\u0002J\f\u0010-\u001a\u00020\f*\u00020&H\u0002J\u0016\u0010.\u001a\u00020!*\u00020&2\b\b\u0002\u0010'\u001a\u00020\fH\u0002J\b\u0010/\u001a\u00020\u000fH\u0002J$\u00100\u001a\u00020!*\u00020&2\u0006\u00101\u001a\u00020#2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H\u0002J\f\u00105\u001a\u00020!*\u00020&H\u0002J,\u00106\u001a\u00020\f*\u00020&2\u0006\u0010$\u001a\u00020#2\u0006\u00107\u001a\u00020#2\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0002J\u0010\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020\u000fH\u0002J\u0006\u0010<\u001a\u00020=J\u000e\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020\fJ\b\u0010@\u001a\u00020!H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogWithdraw;", "Lru/mrlargha/commonui/elements/dialogs/AbstractDialog;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "caption", "Landroid/text/SpannableString;", "info", "leftButtonText", "rightButtonText", "passwordMode", "", "sampDialogId", "hintInput", "", "<init>", "(Landroid/app/Activity;ILandroid/text/SpannableString;Landroid/text/SpannableString;Landroid/text/SpannableString;Landroid/text/SpannableString;ZILjava/lang/String;)V", "dialogLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/commonui/databinding/DialogWithdrawBinding;", "text", "isKeyboardShowing", "scope", "Lkotlinx/coroutines/CoroutineScope;", "plusJob", "Lkotlinx/coroutines/Job;", "minusJob", "limits", "Lru/mrlargha/commonui/elements/dialogs/DialogWithdrawLimit;", "setupListeners", "", "onClickPlus", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "btnMinus", "et", "Landroid/widget/EditText;", "isDouble", "onClickMinus", "minusOne", "minusCount", "plusOne", "plusCount", "checkIsZero", "setFilter", "getInputCost", "setFocus", "cardView", "llOne", "Landroid/widget/LinearLayout;", "llTwo", "setLimit", "checkValidate", "customFieldLayout", "costType", "icCost", "savePassword", HintConstants.AUTOFILL_HINT_NEW_PASSWORD, "getEtSum", "", "checkActiveButton", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "checkEtValidates", "Companion", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogWithdraw extends AbstractDialog {
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
    private String text;
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
        View dialogLayout = LayoutInflater.from(targetActivity).inflate(R.layout.dialog_withdraw, (ViewGroup) null, false);
        this.dialogLayout = dialogLayout;
        DialogWithdrawBinding bind = DialogWithdrawBinding.bind(dialogLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.text = "";
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        bind.buttons.button1.setAlpha(0.5f);
        bind.buttons.button1.setEnabled(false);
        if (MapperKt.isJsonValid(hintInput)) {
            this.limits = (DialogWithdrawLimit) MapperKt.getGson().fromJson(hintInput, (Class<Object>) DialogWithdrawLimit.class);
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
            bind.etK.setFilters(new InputFilter[]{new DecimalMaxValueFilter(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 0, 0, 7, null), new InputFilter.LengthFilter(7)});
            setupListeners();
            ViewCompat.setOnApplyWindowInsetsListener(bind.getRoot(), new OnApplyWindowInsetsListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogWithdraw$$ExternalSyntheticLambda4
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    return DialogWithdraw._init_$lambda$1(DialogWithdraw.this, view, windowInsetsCompat);
                }
            });
            return;
        }
        throw new JsonParseException("Json is not valid");
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final WindowInsetsCompat _init_$lambda$1(DialogWithdraw dialogWithdraw, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        if (!insets.isVisible(WindowInsetsCompat.Type.ime())) {
            Double doubleOrNull = StringsKt.toDoubleOrNull(dialogWithdraw.binding.etK.getText().toString());
            double doubleValue = doubleOrNull != null ? doubleOrNull.doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            EditText editText = dialogWithdraw.binding.etK;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.US, "%.3f", Arrays.copyOf(new Object[]{Double.valueOf(doubleValue)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            editText.setText(format);
            LinearLayout mContainer = dialogWithdraw.binding.mContainer;
            Intrinsics.checkNotNullExpressionValue(mContainer, "mContainer");
            mContainer.setVisibility(0);
            LinearLayout kkContainer = dialogWithdraw.binding.kkContainer;
            Intrinsics.checkNotNullExpressionValue(kkContainer, "kkContainer");
            kkContainer.setVisibility(0);
            LinearLayout kContainer = dialogWithdraw.binding.kContainer;
            Intrinsics.checkNotNullExpressionValue(kContainer, "kContainer");
            kContainer.setVisibility(0);
            dialogWithdraw.binding.mContainer.clearFocus();
            dialogWithdraw.binding.kkContainer.clearFocus();
            dialogWithdraw.binding.kContainer.clearFocus();
        }
        return insets;
    }

    private final void setupListeners() {
        DialogWithdrawBinding dialogWithdrawBinding = this.binding;
        CustomCardView btnMinusM = dialogWithdrawBinding.btnMinusM;
        Intrinsics.checkNotNullExpressionValue(btnMinusM, "btnMinusM");
        EditText etM = dialogWithdrawBinding.etM;
        Intrinsics.checkNotNullExpressionValue(etM, "etM");
        onClickMinus$default(this, btnMinusM, etM, false, 2, null);
        CustomCardView btnMinusKk = dialogWithdrawBinding.btnMinusKk;
        Intrinsics.checkNotNullExpressionValue(btnMinusKk, "btnMinusKk");
        EditText etKk = dialogWithdrawBinding.etKk;
        Intrinsics.checkNotNullExpressionValue(etKk, "etKk");
        onClickMinus$default(this, btnMinusKk, etKk, false, 2, null);
        CustomCardView btnMinusK = dialogWithdrawBinding.btnMinusK;
        Intrinsics.checkNotNullExpressionValue(btnMinusK, "btnMinusK");
        EditText etK = dialogWithdrawBinding.etK;
        Intrinsics.checkNotNullExpressionValue(etK, "etK");
        onClickMinus(btnMinusK, etK, true);
        CustomCardView btnPlusM = dialogWithdrawBinding.btnPlusM;
        Intrinsics.checkNotNullExpressionValue(btnPlusM, "btnPlusM");
        CustomCardView btnMinusM2 = dialogWithdrawBinding.btnMinusM;
        Intrinsics.checkNotNullExpressionValue(btnMinusM2, "btnMinusM");
        EditText etM2 = dialogWithdrawBinding.etM;
        Intrinsics.checkNotNullExpressionValue(etM2, "etM");
        onClickPlus$default(this, btnPlusM, btnMinusM2, etM2, false, 4, null);
        CustomCardView btnPlusKk = dialogWithdrawBinding.btnPlusKk;
        Intrinsics.checkNotNullExpressionValue(btnPlusKk, "btnPlusKk");
        CustomCardView btnMinusKk2 = dialogWithdrawBinding.btnMinusKk;
        Intrinsics.checkNotNullExpressionValue(btnMinusKk2, "btnMinusKk");
        EditText etKk2 = dialogWithdrawBinding.etKk;
        Intrinsics.checkNotNullExpressionValue(etKk2, "etKk");
        onClickPlus$default(this, btnPlusKk, btnMinusKk2, etKk2, false, 4, null);
        CustomCardView btnPlusK = dialogWithdrawBinding.btnPlusK;
        Intrinsics.checkNotNullExpressionValue(btnPlusK, "btnPlusK");
        CustomCardView btnMinusK2 = dialogWithdrawBinding.btnMinusK;
        Intrinsics.checkNotNullExpressionValue(btnMinusK2, "btnMinusK");
        EditText etK2 = dialogWithdrawBinding.etK;
        Intrinsics.checkNotNullExpressionValue(etK2, "etK");
        onClickPlus(btnPlusK, btnMinusK2, etK2, true);
        EditText etM3 = dialogWithdrawBinding.etM;
        Intrinsics.checkNotNullExpressionValue(etM3, "etM");
        setFilter$default(this, etM3, false, 1, null);
        EditText etKk3 = dialogWithdrawBinding.etKk;
        Intrinsics.checkNotNullExpressionValue(etKk3, "etKk");
        setFilter$default(this, etKk3, false, 1, null);
        EditText etK3 = dialogWithdrawBinding.etK;
        Intrinsics.checkNotNullExpressionValue(etK3, "etK");
        setFilter(etK3, true);
        EditText etM4 = dialogWithdrawBinding.etM;
        Intrinsics.checkNotNullExpressionValue(etM4, "etM");
        CustomCardView cardViewM = dialogWithdrawBinding.cardViewM;
        Intrinsics.checkNotNullExpressionValue(cardViewM, "cardViewM");
        LinearLayout kkContainer = dialogWithdrawBinding.kkContainer;
        Intrinsics.checkNotNullExpressionValue(kkContainer, "kkContainer");
        LinearLayout kContainer = dialogWithdrawBinding.kContainer;
        Intrinsics.checkNotNullExpressionValue(kContainer, "kContainer");
        setFocus(etM4, cardViewM, kkContainer, kContainer);
        EditText etKk4 = dialogWithdrawBinding.etKk;
        Intrinsics.checkNotNullExpressionValue(etKk4, "etKk");
        CustomCardView cardViewKk = dialogWithdrawBinding.cardViewKk;
        Intrinsics.checkNotNullExpressionValue(cardViewKk, "cardViewKk");
        LinearLayout mContainer = dialogWithdrawBinding.mContainer;
        Intrinsics.checkNotNullExpressionValue(mContainer, "mContainer");
        LinearLayout kContainer2 = dialogWithdrawBinding.kContainer;
        Intrinsics.checkNotNullExpressionValue(kContainer2, "kContainer");
        setFocus(etKk4, cardViewKk, mContainer, kContainer2);
        EditText etK4 = dialogWithdrawBinding.etK;
        Intrinsics.checkNotNullExpressionValue(etK4, "etK");
        CustomCardView cardViewK = dialogWithdrawBinding.cardViewK;
        Intrinsics.checkNotNullExpressionValue(cardViewK, "cardViewK");
        LinearLayout mContainer2 = dialogWithdrawBinding.mContainer;
        Intrinsics.checkNotNullExpressionValue(mContainer2, "mContainer");
        LinearLayout kkContainer2 = dialogWithdrawBinding.kkContainer;
        Intrinsics.checkNotNullExpressionValue(kkContainer2, "kkContainer");
        setFocus(etK4, cardViewK, mContainer2, kkContainer2);
        EditText etM5 = dialogWithdrawBinding.etM;
        Intrinsics.checkNotNullExpressionValue(etM5, "etM");
        setLimit(etM5);
        EditText etKk5 = dialogWithdrawBinding.etKk;
        Intrinsics.checkNotNullExpressionValue(etKk5, "etKk");
        setLimit(etKk5);
        EditText etK5 = dialogWithdrawBinding.etK;
        Intrinsics.checkNotNullExpressionValue(etK5, "etK");
        setLimit(etK5);
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
        customCardView.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogWithdraw$$ExternalSyntheticLambda9
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
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
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
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            return true;
        } else {
            Job job3 = dialogWithdraw.plusJob;
            if (job3 != null) {
                Job.DefaultImpls.cancel$default(job3, (CancellationException) null, 1, (Object) null);
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
        customCardView.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogWithdraw$$ExternalSyntheticLambda8
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
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
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
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            return true;
        } else {
            Job job3 = dialogWithdraw.minusJob;
            if (job3 != null) {
                Job.DefaultImpls.cancel$default(job3, (CancellationException) null, 1, (Object) null);
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
                            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                        }
                        Job job2 = this.minusJob;
                        if (job2 != null) {
                            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
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
            return;
        }
        Integer intOrNull = StringsKt.toIntOrNull(editText.getText().toString());
        if (intOrNull != null) {
            intOrNull.intValue();
            if (intOrNull.intValue() < i) {
                editText.setText("0");
                Job job3 = this.plusJob;
                if (job3 != null) {
                    Job.DefaultImpls.cancel$default(job3, (CancellationException) null, 1, (Object) null);
                }
                Job job4 = this.minusJob;
                if (job4 != null) {
                    Job.DefaultImpls.cancel$default(job4, (CancellationException) null, 1, (Object) null);
                }
            } else if (intOrNull.intValue() > 0) {
                editText.setText(String.valueOf(intOrNull.intValue() - i));
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
            if (floatOrNull != null) {
                floatOrNull.floatValue();
                float f = i;
                if (floatOrNull.floatValue() + f > 999.999d) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format(Locale.US, "%.3f", Arrays.copyOf(new Object[]{Float.valueOf(999.999f)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    editText.setText(format);
                    Job job = this.plusJob;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    Job job2 = this.minusJob;
                    if (job2 != null) {
                        Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                        return;
                    }
                    return;
                } else if (floatOrNull.floatValue() < 999.0f) {
                    float floatValue = floatOrNull.floatValue() + f;
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String format2 = String.format(Locale.US, "%.3f", Arrays.copyOf(new Object[]{Float.valueOf(floatValue)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                    editText.setText(format2);
                    return;
                } else {
                    return;
                }
            }
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format3 = String.format(Locale.US, "%.3f", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
            editText.setText(format3);
            return;
        }
        Integer intOrNull = StringsKt.toIntOrNull(editText.getText().toString());
        if (intOrNull != null) {
            intOrNull.intValue();
            if (intOrNull.intValue() + i > 999) {
                editText.setText("999");
                Job job3 = this.plusJob;
                if (job3 != null) {
                    Job.DefaultImpls.cancel$default(job3, (CancellationException) null, 1, (Object) null);
                }
                Job job4 = this.minusJob;
                if (job4 != null) {
                    Job.DefaultImpls.cancel$default(job4, (CancellationException) null, 1, (Object) null);
                    return;
                }
                return;
            } else if (intOrNull.intValue() < 999) {
                editText.setText(String.valueOf(intOrNull.intValue() + i));
                return;
            } else {
                return;
            }
        }
        editText.setText(String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkIsZero(EditText editText) {
        Long longOrNull = StringsKt.toLongOrNull(editText.getText().toString());
        if (longOrNull != null) {
            return longOrNull.longValue() != 0;
        }
        Float floatOrNull = StringsKt.toFloatOrNull(editText.getText().toString());
        if (floatOrNull != null) {
            return !(floatOrNull.floatValue() == 0.0f);
        }
        return false;
    }

    static /* synthetic */ void setFilter$default(DialogWithdraw dialogWithdraw, EditText editText, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        dialogWithdraw.setFilter(editText, z);
    }

    private final void setFilter(EditText editText, final boolean z) {
        InputFilter inputFilter = new InputFilter() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogWithdraw$$ExternalSyntheticLambda5
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return DialogWithdraw.setFilter$lambda$0(z, charSequence, i, i2, spanned, i3, i4);
            }
        };
        InputFilter[] filters = editText.getFilters();
        Intrinsics.checkNotNullExpressionValue(filters, "getFilters(...)");
        editText.setFilters((InputFilter[]) ArraysKt.plus(filters, inputFilter));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence setFilter$lambda$0(boolean z, CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        String sb = new StringBuilder(spanned).replace(i3, i4, charSequence.subSequence(i, i2).toString()).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        CharSequence charSequence2 = null;
        if (sb.length() == 0) {
            return null;
        }
        if (z) {
            Float floatOrNull = StringsKt.toFloatOrNull(sb);
            if ((floatOrNull == null || floatOrNull.floatValue() > 1000.0f) && (floatOrNull == null || !Intrinsics.areEqual(floatOrNull, 0.0f))) {
                charSequence2 = "";
            }
            return charSequence2;
        }
        Integer intOrNull = StringsKt.toIntOrNull(sb);
        if ((intOrNull == null || intOrNull.intValue() > 999) && (intOrNull == null || intOrNull.intValue() != 0)) {
            charSequence2 = "";
        }
        return charSequence2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c9, code lost:
        if (r5 != null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getInputCost() {
        String str;
        String padEnd;
        String take;
        String replace$default = StringsKt.replace$default(this.binding.etM.getText().toString(), " ", "", false, 4, (Object) null);
        if (replace$default.length() == 0) {
            replace$default = "0";
        }
        String str2 = replace$default;
        String replace$default2 = StringsKt.replace$default(this.binding.etKk.getText().toString(), " ", "", false, 4, (Object) null);
        if (replace$default2.length() == 0) {
            replace$default2 = "0";
        }
        String str3 = replace$default2;
        String replace$default3 = StringsKt.replace$default(StringsKt.replace$default(this.binding.etK.getText().toString(), " ", "", false, 4, (Object) null), StringUtils.COMMA, ".", false, 4, (Object) null);
        List split$default = StringsKt.split$default((CharSequence) (replace$default3.length() != 0 ? replace$default3 : "0"), new String[]{"."}, false, 0, 6, (Object) null);
        String str4 = (String) CollectionsKt.getOrNull(split$default, 0);
        String str5 = "000";
        if (str4 != null) {
            String str6 = str4;
            StringBuilder sb = new StringBuilder();
            int length = str6.length();
            for (int i = 0; i < length; i++) {
                char charAt = str6.charAt(i);
                if (Character.isDigit(charAt)) {
                    sb.append(charAt);
                }
            }
            String sb2 = sb.toString();
            if (sb2 != null) {
                String padStart = StringsKt.padStart(sb2, 3, '0');
                if (padStart != null) {
                    str = StringsKt.takeLast(padStart, 3);
                }
            }
        }
        str = "000";
        String str7 = (String) CollectionsKt.getOrNull(split$default, 1);
        if (str7 != null) {
            String str8 = str7;
            StringBuilder sb3 = new StringBuilder();
            int length2 = str8.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char charAt2 = str8.charAt(i2);
                if (Character.isDigit(charAt2)) {
                    sb3.append(charAt2);
                }
            }
            String sb4 = sb3.toString();
            if (sb4 != null && (padEnd = StringsKt.padEnd(sb4, 3, '0')) != null && (take = StringsKt.take(padEnd, 3)) != null) {
                str5 = take;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        Long longOrNull = StringsKt.toLongOrNull(str2);
        sb5.append(longOrNull != null ? longOrNull.longValue() : 0L);
        String str9 = str3;
        StringBuilder sb6 = new StringBuilder();
        int length3 = str9.length();
        for (int i3 = 0; i3 < length3; i3++) {
            char charAt3 = str9.charAt(i3);
            if (Character.isDigit(charAt3)) {
                sb6.append(charAt3);
            }
        }
        sb5.append(StringsKt.takeLast(StringsKt.padStart(sb6.toString(), 3, '0'), 3));
        sb5.append(str);
        sb5.append(str5);
        return sb5.toString();
    }

    private final void setFocus(EditText editText, final CustomCardView customCardView, final LinearLayout linearLayout, final LinearLayout linearLayout2) {
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogWithdraw$$ExternalSyntheticLambda6
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                DialogWithdraw.setFocus$lambda$0(CustomCardView.this, linearLayout, linearLayout2, this, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void setFocus$lambda$0(CustomCardView customCardView, LinearLayout linearLayout, LinearLayout linearLayout2, DialogWithdraw dialogWithdraw, View view, boolean z) {
        Log.d(TAG, "setFocus: " + z);
        if (z) {
            customCardView.setBorder(Color.parseColor("#FFF600"));
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(8);
            Job job = dialogWithdraw.plusJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            Job job2 = dialogWithdraw.minusJob;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                return;
            }
            return;
        }
        if (customCardView.getBorderMainColor() != -65536) {
            customCardView.setBorder(Color.parseColor("#33FFFFFF"));
        }
        linearLayout.setVisibility(0);
        linearLayout2.setVisibility(0);
    }

    private final void setLimit(EditText editText) {
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogWithdraw$$ExternalSyntheticLambda7
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
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            Job job2 = dialogWithdraw.minusJob;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            Object systemService = textView.getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(textView.getWindowToken(), 0);
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003e, code lost:
        if (r3 < r8) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
        r3 = r17.binding.tvError;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "tvError");
        r3.setVisibility(0);
        r6 = r19;
        android.util.Log.d(r6, "checkValidate: " + r5.getLimits().getMinForM());
        r17.binding.tvError.setText(ru.mrlargha.commonui.utils.ui.money.MoneyElementKt.toMoneyFormattedSpannable$default(r8, false, "Минимум ", null, 5, null));
        checkActiveButton(false);
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0080, code lost:
        r6 = r19;
        r3 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1));
        r4 = r17.binding;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0086, code lost:
        if (r3 <= 0) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0088, code lost:
        r3 = r4.tvError;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "tvError");
        r3.setVisibility(0);
        r7 = 0;
        r17.binding.tvError.setText(ru.mrlargha.commonui.utils.ui.money.MoneyElementKt.toMoneyFormattedSpannable$default(r10, false, "Максимум ", null, 5, null));
        checkActiveButton(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00ac, code lost:
        r7 = 0;
        r3 = r4.tvError;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "tvError");
        r3.setVisibility(8);
        checkActiveButton(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0037, code lost:
        if (r3 < r8) goto L90;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean checkValidate(EditText editText, CustomCardView customCardView, CustomCardView customCardView2, int i, int i2) {
        String str;
        String str2;
        ?? r7;
        Number valueOf;
        Number valueOf2;
        DialogWithdrawLimitModel limits;
        DialogWithdrawLimitModel limits2;
        DialogWithdrawLimitModel limits3;
        DialogWithdrawLimitModel limits4;
        DialogWithdrawLimitModel limits5;
        DialogWithdrawLimitModel limits6;
        DialogWithdrawLimitModel limits7;
        DialogWithdrawLimitModel limits8;
        long etSum = getEtSum();
        DialogWithdrawLimit dialogWithdrawLimit = this.limits;
        if (dialogWithdrawLimit != null) {
            CustomCardView.changeValidate$default(customCardView, checkIsZero(editText), 0.0f, 2, null);
            long minMoney = dialogWithdrawLimit.getLimits().getMinMoney();
            long maxMoney = dialogWithdrawLimit.getLimits().getMaxMoney();
            if (i == 0) {
                str = "TAG";
            } else {
                str = "TAG";
            }
            if (getEtSum() < dialogWithdrawLimit.getLimits().getMinMoney()) {
                checkActiveButton(r7);
            }
            long j = 0;
            if (i == 0) {
                Double doubleOrNull = StringsKt.toDoubleOrNull(editText.getText().toString());
                valueOf = Double.valueOf(doubleOrNull != null ? doubleOrNull.doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            } else {
                Long longOrNull = StringsKt.toLongOrNull(editText.getText().toString());
                valueOf = Long.valueOf(longOrNull != null ? longOrNull.longValue() : 0L);
            }
            if (i == 0) {
                DialogWithdrawLimit dialogWithdrawLimit2 = this.limits;
                valueOf2 = (dialogWithdrawLimit2 == null || (limits = dialogWithdrawLimit2.getLimits()) == null) ? Integer.valueOf((int) r7) : Double.valueOf(limits.getMinForK());
            } else {
                DialogWithdrawLimit dialogWithdrawLimit3 = this.limits;
                if (i == 1) {
                    if (dialogWithdrawLimit3 != null && (limits6 = dialogWithdrawLimit3.getLimits()) != null) {
                        limits6.setCurrentKK(valueOf.longValue());
                    }
                    DialogWithdrawLimit dialogWithdrawLimit4 = this.limits;
                    valueOf2 = Long.valueOf((dialogWithdrawLimit4 == null || (limits5 = dialogWithdrawLimit4.getLimits()) == null) ? 0L : limits5.getMinForKK());
                } else {
                    if (dialogWithdrawLimit3 != null && (limits8 = dialogWithdrawLimit3.getLimits()) != null) {
                        limits8.setCurrentM(valueOf.longValue());
                    }
                    DialogWithdrawLimit dialogWithdrawLimit5 = this.limits;
                    valueOf2 = Long.valueOf((dialogWithdrawLimit5 == null || (limits7 = dialogWithdrawLimit5.getLimits()) == null) ? 0L : limits7.getMinForM());
                }
            }
            if (i == 0) {
                DialogWithdrawLimit dialogWithdrawLimit6 = this.limits;
                if (dialogWithdrawLimit6 != null && (limits2 = dialogWithdrawLimit6.getLimits()) != null) {
                    j = limits2.getMaxForK();
                }
            } else {
                DialogWithdrawLimit dialogWithdrawLimit7 = this.limits;
                if (i != 1) {
                    if (dialogWithdrawLimit7 != null && (limits4 = dialogWithdrawLimit7.getLimits()) != null) {
                        j = limits4.getMaxForM();
                    }
                } else if (dialogWithdrawLimit7 != null && (limits3 = dialogWithdrawLimit7.getLimits()) != null) {
                    j = limits3.getMaxForKK();
                }
            }
            if (i == 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.US, "%.3f", Arrays.copyOf(new Object[]{valueOf}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                editText.setText(format);
            }
            if (i != 0 ? valueOf.intValue() < valueOf2.intValue() : valueOf.doubleValue() < valueOf2.doubleValue()) {
                Log.d(str2, "getMinForK: " + valueOf2.doubleValue() + " " + valueOf + " ");
                customCardView2.setBorder(SupportMenu.CATEGORY_MASK);
                return r7;
            } else if (valueOf.longValue() > j) {
                customCardView2.setBorder(SupportMenu.CATEGORY_MASK);
                return r7;
            } else {
                customCardView2.setBorder(Color.parseColor("#33FFFFFF"));
                return true;
            }
        }
        return true;
    }

    private final void savePassword(String str) {
        int length = str.length();
        if (6 > length || length >= 33) {
            return;
        }
        getSharedPreferences().edit().putString("PASSWORD_SP_FIELD", str).apply();
    }

    public final long getEtSum() {
        DialogWithdrawBinding dialogWithdrawBinding = this.binding;
        Integer intOrNull = StringsKt.toIntOrNull(dialogWithdrawBinding.etM.getText().toString());
        int intValue = intOrNull != null ? intOrNull.intValue() : 0;
        Integer intOrNull2 = StringsKt.toIntOrNull(dialogWithdrawBinding.etKk.getText().toString());
        int intValue2 = intOrNull2 != null ? intOrNull2.intValue() : 0;
        Double doubleOrNull = StringsKt.toDoubleOrNull(dialogWithdrawBinding.etK.getText().toString());
        return MoneyElementKt.toLong(new MoneyParts(intValue, intValue2, (int) ((doubleOrNull != null ? doubleOrNull.doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) * 1000)));
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
        EditText etM = this.binding.etM;
        Intrinsics.checkNotNullExpressionValue(etM, "etM");
        CustomCardView btnMinusM = this.binding.btnMinusM;
        Intrinsics.checkNotNullExpressionValue(btnMinusM, "btnMinusM");
        CustomCardView cardViewM = this.binding.cardViewM;
        Intrinsics.checkNotNullExpressionValue(cardViewM, "cardViewM");
        if (checkValidate(etM, btnMinusM, cardViewM, 2, R.drawable.ic_m_cost)) {
            EditText etKk = this.binding.etKk;
            Intrinsics.checkNotNullExpressionValue(etKk, "etKk");
            CustomCardView btnMinusKk = this.binding.btnMinusKk;
            Intrinsics.checkNotNullExpressionValue(btnMinusKk, "btnMinusKk");
            CustomCardView cardViewKk = this.binding.cardViewKk;
            Intrinsics.checkNotNullExpressionValue(cardViewKk, "cardViewKk");
            if (checkValidate(etKk, btnMinusKk, cardViewKk, 1, R.drawable.ic_kk_cost)) {
                EditText etK = this.binding.etK;
                Intrinsics.checkNotNullExpressionValue(etK, "etK");
                CustomCardView btnMinusK = this.binding.btnMinusK;
                Intrinsics.checkNotNullExpressionValue(btnMinusK, "btnMinusK");
                CustomCardView cardViewK = this.binding.cardViewK;
                Intrinsics.checkNotNullExpressionValue(cardViewK, "cardViewK");
                checkValidate(etK, btnMinusK, cardViewK, 0, R.drawable.ic_k_cost);
            }
        }
    }

    /* compiled from: DialogWithdraw.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogWithdraw$Companion;", "", "<init>", "()V", "TAG", "", "PASSWORD_SP_NAME", "inputHistory", "", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
