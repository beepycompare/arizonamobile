package ru.mrlargha.commonui.elements.dialogs;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.DialogSignBinding;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: DialogSign.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 %2\u00020\u0001:\u0001%B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\u001c\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010!\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\tH\u0002J\u0017\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\tH\u0002¢\u0006\u0002\u0010$R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogSign;", "Lru/mrlargha/commonui/elements/dialogs/AbstractDialog;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "header", "", "infoData", "", "primaryButton", "sampDialogId", "<init>", "(Landroid/app/Activity;ILjava/lang/CharSequence;Ljava/lang/String;Ljava/lang/CharSequence;I)V", "dialogLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/commonui/databinding/DialogSignBinding;", "dialogInfo", "Lru/mrlargha/commonui/elements/dialogs/DialogSignModel;", "hasSignature", "", "currentProgress", "setupUi", "", "dismissWithResponse", "responseButtonId", "updateConfirmState", "canConfirm", "applyProgress", "progress", "colorOverride", "resolveProgressColor", "parseColorOrNull", "color", "(Ljava/lang/String;)Ljava/lang/Integer;", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogSign extends AbstractDialog {
    private static final int ACTIVE_BUTTON_BACKGROUND_ALPHA = 100;
    private static final String ACTIVE_BUTTON_BACKGROUND_COLOR = "#FFF600";
    private static final String ACTIVE_BUTTON_TEXT_COLOR = "#000000";
    public static final Companion Companion = new Companion(null);
    private static final String GREEN_PROGRESS_COLOR = "#43D51B";
    private static final int HIGH_PROGRESS_THRESHOLD = 80;
    private static final int INACTIVE_BUTTON_BACKGROUND_ALPHA = 28;
    private static final String INACTIVE_BUTTON_BACKGROUND_COLOR = "#33FFFFFF";
    private static final String INACTIVE_BUTTON_TEXT_COLOR = "#33FFFFFF";
    private static final int LOW_PROGRESS_MAX = 50;
    private static final int MAX_PROGRESS = 100;
    private static final String ORANGE_PROGRESS_COLOR = "#FF6600";
    private static final String RED_PROGRESS_COLOR = "#FF0000";
    private static final int REQUIRED_PROGRESS = 100;
    private final DialogSignBinding binding;
    private int currentProgress;
    private final DialogSignModel dialogInfo;
    private final View dialogLayout;
    private boolean hasSignature;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$1(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogSign(Activity targetActivity, int i, CharSequence header, String infoData, CharSequence primaryButton, int i2) {
        super(targetActivity, i, i2);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(infoData, "infoData");
        Intrinsics.checkNotNullParameter(primaryButton, "primaryButton");
        Object obj = null;
        View dialogLayout = LayoutInflater.from(targetActivity).inflate(R.layout.dialog_sign, (ViewGroup) null, false);
        this.dialogLayout = dialogLayout;
        DialogSignBinding bind = DialogSignBinding.bind(dialogLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        if (MapperKt.isJsonValid(infoData) && !Intrinsics.areEqual(infoData, AbstractJsonLexerKt.NULL) && !Intrinsics.areEqual(infoData, "{}") && infoData.length() != 0) {
            obj = MapperKt.getGson().fromJson(infoData, (Class<Object>) DialogSignModel.class);
        }
        DialogSignModel dialogSignModel = (DialogSignModel) obj;
        dialogSignModel = dialogSignModel == null ? new DialogSignModel(infoData, 0, null, 6, null) : dialogSignModel;
        this.dialogInfo = dialogSignModel;
        this.currentProgress = RangesKt.coerceIn(dialogSignModel.getValue(), 0, 100);
        bind.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogSign$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSign._init_$lambda$0(view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(dialogLayout, "dialogLayout");
        addViewToConstraintLayout(dialogLayout, -2, -2);
        setPosition(SAMPUIElement.PositionType.CENTER, 0, 0);
        setupUi(header, primaryButton);
        setVisibility(true);
        bind.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogSign$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSign._init_$lambda$1(view);
            }
        });
    }

    private final void setupUi(CharSequence charSequence, CharSequence charSequence2) {
        DialogSignBinding dialogSignBinding = this.binding;
        dialogSignBinding.bankCardSignatureModalTitle.setText(charSequence);
        TextView textView = dialogSignBinding.tvBackground;
        String text = this.dialogInfo.getText();
        if (StringsKt.isBlank(text)) {
            text = getTargetActivity().getString(R.string.dialog_sign_filled_prefix);
            Intrinsics.checkNotNullExpressionValue(text, "getString(...)");
        }
        textView.setText(text);
        dialogSignBinding.bankCardSignatureConfirmButtonText.setText(charSequence2);
        dialogSignBinding.bankCardSignatureModalRoot.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogSign$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSign.this.dismissWithResponse(0);
            }
        });
        dialogSignBinding.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogSign$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSign.this.dismissWithResponse(0);
            }
        });
        dialogSignBinding.bankCardSignatureConfirmButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogSign$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSign.setupUi$lambda$0$3(DialogSign.this, view);
            }
        });
        dialogSignBinding.bankCardSignaturePad.setOnClickListener(null);
        dialogSignBinding.bankCardSignaturePad.setOnSignatureChangedListener(new Function2() { // from class: ru.mrlargha.commonui.elements.dialogs.DialogSign$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit unit;
                unit = DialogSign.setupUi$lambda$0$4(DialogSign.this, ((Boolean) obj).booleanValue(), ((Integer) obj2).intValue());
                return unit;
            }
        });
        dialogSignBinding.bankCardSignaturePad.clear();
        int coerceIn = RangesKt.coerceIn(this.dialogInfo.getValue(), 0, 100);
        this.currentProgress = coerceIn;
        applyProgress(coerceIn, this.dialogInfo.getColor());
        updateConfirmState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUi$lambda$0$3(DialogSign dialogSign, View view) {
        if (dialogSign.canConfirm()) {
            dialogSign.dismissWithResponse(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupUi$lambda$0$4(DialogSign dialogSign, boolean z, int i) {
        dialogSign.hasSignature = z;
        int coerceIn = RangesKt.coerceIn(i, 0, 100);
        dialogSign.currentProgress = coerceIn;
        applyProgress$default(dialogSign, coerceIn, null, 2, null);
        dialogSign.updateConfirmState();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissWithResponse(int i) {
        getNotifier().onDialogResponseWrapper(getSampDialogId(), i, -1, new byte[0]);
        getNotifier().destroyDialog();
    }

    private final void updateConfirmState() {
        boolean canConfirm = canConfirm();
        this.binding.bankCardSignatureConfirmButton.changeValidate(canConfirm, 1.0f);
        this.binding.bankCardSignatureConfirmButton.setBackgroundAlpha(canConfirm ? 100 : 28);
        String str = "#33FFFFFF";
        this.binding.bankCardSignatureConfirmButton.setBackground(Color.parseColor(canConfirm ? ACTIVE_BUTTON_BACKGROUND_COLOR : "#33FFFFFF"));
        TextView textView = this.binding.bankCardSignatureConfirmButtonText;
        if (canConfirm) {
            str = ACTIVE_BUTTON_TEXT_COLOR;
        }
        textView.setTextColor(Color.parseColor(str));
    }

    private final boolean canConfirm() {
        return this.hasSignature && this.currentProgress >= 100;
    }

    private final void applyProgress(int i, String str) {
        String str2;
        DialogSignBinding dialogSignBinding = this.binding;
        boolean z = i >= 100;
        TextView tvBackground = dialogSignBinding.tvBackground;
        Intrinsics.checkNotNullExpressionValue(tvBackground, "tvBackground");
        tvBackground.setVisibility(z ? 8 : 0);
        TextView textView = dialogSignBinding.tvSignatureProgressValue;
        if (z) {
            str2 = getTargetActivity().getString(R.string.dialog_sign_filled_done);
        } else {
            str2 = i + "%";
        }
        textView.setText(str2);
        dialogSignBinding.tvSignatureProgressValue.setTextColor(-1);
        dialogSignBinding.background.setBackground(resolveProgressColor(i, str));
    }

    static /* synthetic */ void applyProgress$default(DialogSign dialogSign, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        dialogSign.applyProgress(i, str);
    }

    private final int resolveProgressColor(int i, String str) {
        Integer num = null;
        if (str != null) {
            if (StringsKt.isBlank(str)) {
                str = null;
            }
            if (str != null) {
                num = parseColorOrNull(str);
            }
        }
        if (this.hasSignature || num == null) {
            if (i <= 50) {
                return Color.parseColor(RED_PROGRESS_COLOR);
            }
            if (i < HIGH_PROGRESS_THRESHOLD) {
                return Color.parseColor(ORANGE_PROGRESS_COLOR);
            }
            return Color.parseColor(GREEN_PROGRESS_COLOR);
        }
        return num.intValue();
    }

    private final Integer parseColorOrNull(String str) {
        try {
            return Integer.valueOf(Color.parseColor(str));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* compiled from: DialogSign.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogSign$Companion;", "", "<init>", "()V", "MAX_PROGRESS", "", "REQUIRED_PROGRESS", "LOW_PROGRESS_MAX", "HIGH_PROGRESS_THRESHOLD", "RED_PROGRESS_COLOR", "", "ORANGE_PROGRESS_COLOR", "GREEN_PROGRESS_COLOR", "ACTIVE_BUTTON_BACKGROUND_COLOR", "INACTIVE_BUTTON_BACKGROUND_COLOR", "ACTIVE_BUTTON_BACKGROUND_ALPHA", "INACTIVE_BUTTON_BACKGROUND_ALPHA", "ACTIVE_BUTTON_TEXT_COLOR", "INACTIVE_BUTTON_TEXT_COLOR", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
