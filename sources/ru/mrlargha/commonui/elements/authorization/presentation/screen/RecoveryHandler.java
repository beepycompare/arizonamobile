package ru.mrlargha.commonui.elements.authorization.presentation.screen;

import android.app.Activity;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.Toast;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.AccountRecoveryHandlerBinding;
import ru.mrlargha.commonui.databinding.BackgroundVideoBinding;
import ru.mrlargha.commonui.elements.authorization.domain.RequestState;
import ru.mrlargha.commonui.elements.authorization.domain.controller.RegistrationInterfaceType;
import ru.mrlargha.commonui.elements.authorization.domain.recovery.RecoveryMethodType;
import ru.mrlargha.commonui.elements.authorization.domain.recovery.SetRecoveryCode;
import ru.mrlargha.commonui.elements.authorization.domain.recovery.SetRecoveryInfo;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceManager;
import ru.mrlargha.commonui.utils.ConverterKt;
import ru.mrlargha.commonui.utils.StringKt;
/* compiled from: RecoveryHandler.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0018J\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0018J\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020\u001cH\u0002J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u001cH\u0002J\b\u0010'\u001a\u00020\u001cH\u0002J\b\u0010(\u001a\u00020\u001cH\u0002J\b\u0010)\u001a\u00020\u001cH\u0002J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/screen/RecoveryHandler;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "getTargetActivity", "()Landroid/app/Activity;", "getBackendID", "()I", "recoveryHandler", "Landroidx/constraintlayout/widget/ConstraintLayout;", "recoveryHandlerBinding", "Lru/mrlargha/commonui/databinding/AccountRecoveryHandlerBinding;", "videoBinding", "Lru/mrlargha/commonui/databinding/BackgroundVideoBinding;", "notifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "requestState", "Lru/mrlargha/commonui/elements/authorization/domain/RequestState;", "recoveryMethod", HintConstants.AUTOFILL_HINT_USERNAME, "", "inputText", "inputCode", "onServerRecoveryResponse", "", "data", "selectRecoveryMethod", "setUsername", "enableError", "disableError", "disableUpdateButton", "enableUpdateButton", "getRecoveryMethodType", "Lru/mrlargha/commonui/elements/authorization/domain/recovery/RecoveryMethodType;", "getInputText", "sendRecoveryCode", "resetRecoveryHandler", "sendRecoveryInfo", "setVisible", "visible", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecoveryHandler implements InterfaceController {
    private final int backendID;
    private String inputCode;
    private String inputText;
    private final IBackendNotifier notifier;
    private final ConstraintLayout recoveryHandler;
    private final AccountRecoveryHandlerBinding recoveryHandlerBinding;
    private int recoveryMethod;
    private RequestState requestState;
    private final Activity targetActivity;
    private String username;
    private final BackgroundVideoBinding videoBinding;

    /* compiled from: RecoveryHandler.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[RequestState.values().length];
            try {
                iArr[RequestState.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RequestState.SEND_TO_SERVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RequestState.RECEIVED_BAD_ANSWER_FROM_SERVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RequestState.DISABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[RecoveryMethodType.values().length];
            try {
                iArr2[RecoveryMethodType.MAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[RecoveryMethodType.TELEGRAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[RecoveryMethodType.VK.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$7(View view) {
    }

    public RecoveryHandler(Activity targetActivity, int i) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.targetActivity = targetActivity;
        this.backendID = i;
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.account_recovery_handler, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.recoveryHandler = constraintLayout;
        AccountRecoveryHandlerBinding bind = AccountRecoveryHandlerBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.recoveryHandlerBinding = bind;
        InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.VIDEO_BACKGROUND.getId(), targetActivity, i);
        Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationVideoBackground");
        BackgroundVideoBinding mainBinding = ((RegistrationVideoBackground) orCreateInterface).getMainBinding();
        this.videoBinding = mainBinding;
        Intrinsics.checkNotNull(targetActivity, "null cannot be cast to non-null type ru.mrlargha.commonui.core.IBackendNotifier");
        this.notifier = (IBackendNotifier) targetActivity;
        this.requestState = RequestState.DISABLE;
        this.recoveryMethod = -1;
        this.inputText = "";
        this.inputCode = "";
        mainBinding.video.addView(bind.accountRecoveryHandler, -1, -1);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(mainBinding.video);
        constraintSet.connect(bind.accountRecoveryHandler.getId(), 1, mainBinding.video.getId(), 1);
        constraintSet.connect(bind.accountRecoveryHandler.getId(), 3, mainBinding.video.getId(), 3);
        constraintSet.connect(bind.accountRecoveryHandler.getId(), 4, mainBinding.video.getId(), 4);
        constraintSet.applyTo(mainBinding.video);
        bind.accountRecoveryHandlerUpdateButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryHandler$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveryHandler._init_$lambda$0(RecoveryHandler.this, view);
            }
        });
        final EditText editText = bind.accountRecoveryTypePlaceholder;
        editText.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryHandler$$ExternalSyntheticLambda2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                RecoveryHandler.lambda$3$lambda$2(RecoveryHandler.this, editText);
            }
        });
        EditText accountRecoveryTypePlaceholder = bind.accountRecoveryTypePlaceholder;
        Intrinsics.checkNotNullExpressionValue(accountRecoveryTypePlaceholder, "accountRecoveryTypePlaceholder");
        accountRecoveryTypePlaceholder.addTextChangedListener(new TextWatcher() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryHandler$special$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                AccountRecoveryHandlerBinding accountRecoveryHandlerBinding;
                AccountRecoveryHandlerBinding accountRecoveryHandlerBinding2;
                int i2;
                RequestState requestState;
                accountRecoveryHandlerBinding = RecoveryHandler.this.recoveryHandlerBinding;
                String obj = accountRecoveryHandlerBinding.accountRecoveryTypePlaceholder.getText().toString();
                if (Intrinsics.areEqual(obj, "")) {
                    return;
                }
                String str = obj;
                if (str.length() <= 0 || StringsKt.isBlank(str)) {
                    RecoveryHandler.this.disableUpdateButton();
                    RecoveryHandler.this.enableError();
                    return;
                }
                accountRecoveryHandlerBinding2 = RecoveryHandler.this.recoveryHandlerBinding;
                accountRecoveryHandlerBinding2.accountRecoveryHandlerErrorContainer.setVisibility(8);
                i2 = RecoveryHandler.this.recoveryMethod;
                if (i2 == RecoveryMethodType.TELEGRAM.getId() || i2 == RecoveryMethodType.VK.getId()) {
                    RecoveryHandler.this.enableUpdateButton();
                    RecoveryHandler.this.disableError();
                } else if (i2 == RecoveryMethodType.MAIL.getId()) {
                    if (Patterns.EMAIL_ADDRESS.matcher(str).matches()) {
                        requestState = RecoveryHandler.this.requestState;
                        if (requestState != RequestState.SEND_TO_SERVER) {
                            RecoveryHandler.this.enableUpdateButton();
                            RecoveryHandler.this.disableError();
                            return;
                        }
                        RecoveryHandler.this.enableError();
                        return;
                    }
                    RecoveryHandler.this.disableUpdateButton();
                    RecoveryHandler.this.enableError();
                }
            }
        });
        bind.accountRecoveryHandlerMethod.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryHandler$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveryHandler._init_$lambda$5(RecoveryHandler.this, view);
            }
        });
        bind.accountRecoveryHandlerExistButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryHandler$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveryHandler._init_$lambda$6(RecoveryHandler.this, view);
            }
        });
        bind.accountRecoveryHandler.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryHandler$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveryHandler._init_$lambda$7(view);
            }
        });
    }

    public final int getBackendID() {
        return this.backendID;
    }

    public final Activity getTargetActivity() {
        return this.targetActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(RecoveryHandler recoveryHandler, View view) {
        int i = WhenMappings.$EnumSwitchMapping$0[recoveryHandler.requestState.ordinal()];
        if (i == 1) {
            recoveryHandler.sendRecoveryInfo();
        } else if (i == 2) {
            Toast.makeText(recoveryHandler.targetActivity, "Пожалуйста, подождите...", 0).show();
        } else if (i == 3) {
            Toast.makeText(recoveryHandler.targetActivity, "Для того что бы отправить запрос повторно, необходимо ввести корректную информацию", 0).show();
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            Toast.makeText(recoveryHandler.targetActivity, "Заполните все обязательные поля!", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$3$lambda$2(RecoveryHandler recoveryHandler, EditText editText) {
        Insets insets;
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(recoveryHandler.targetActivity.getWindow().getDecorView());
        Integer valueOf = (rootWindowInsets == null || (insets = rootWindowInsets.getInsets(WindowInsetsCompat.Type.ime())) == null) ? null : Integer.valueOf(insets.bottom);
        int[] iArr = new int[2];
        ConstraintLayout accountRecoveryHandler = recoveryHandler.recoveryHandlerBinding.accountRecoveryHandler;
        Intrinsics.checkNotNullExpressionValue(accountRecoveryHandler, "accountRecoveryHandler");
        editText.getLocationOnScreen(iArr);
        if (valueOf != null) {
            int height = accountRecoveryHandler.getHeight() - valueOf.intValue();
            if (valueOf.intValue() == 0) {
                accountRecoveryHandler.setTranslationY(ConverterKt.pxToDp(0.0f, recoveryHandler.targetActivity));
            } else if ((iArr[1] + editText.getHeight()) - height > 0) {
                accountRecoveryHandler.setTranslationY(ConverterKt.pxToDp(-((iArr[1] + editText.getHeight()) - height), recoveryHandler.targetActivity));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$5(RecoveryHandler recoveryHandler, View view) {
        recoveryHandler.resetRecoveryHandler();
        InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.RECOVERY_METHOD.getId(), recoveryHandler.targetActivity, recoveryHandler.backendID);
        Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryMethod");
        recoveryHandler.setVisible(false);
        ((RecoveryMethod) orCreateInterface).setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$6(RecoveryHandler recoveryHandler, View view) {
        recoveryHandler.resetRecoveryHandler();
        recoveryHandler.setVisible(false);
        InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.AUTH_INIT.getId(), recoveryHandler.targetActivity, recoveryHandler.backendID).setVisible(true);
        InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.AUTHORIZATION_NEWS.getId(), recoveryHandler.targetActivity, recoveryHandler.backendID).setVisible(true);
    }

    public final void onServerRecoveryResponse(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        switch (data.hashCode()) {
            case -1848551503:
                if (data.equals("code_success")) {
                    InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.RECOVERY_FINAL.getId(), this.targetActivity, this.backendID);
                    Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryFinal");
                    RecoveryFinal recoveryFinal = (RecoveryFinal) orCreateInterface;
                    recoveryFinal.setRecoveryValue(this.recoveryMethod, this.inputText);
                    setVisible(false);
                    recoveryFinal.setVisible(true);
                    resetRecoveryHandler();
                    return;
                }
                return;
            case -1736417282:
                if (data.equals("service_error")) {
                    RecoveryMethodType recoveryMethodType = getRecoveryMethodType();
                    this.recoveryHandlerBinding.accountRecoveryHandlerErrorContainer.setVisibility(0);
                    int i = WhenMappings.$EnumSwitchMapping$1[recoveryMethodType.ordinal()];
                    if (i == 1) {
                        this.recoveryHandlerBinding.accountRecoveryHandlerErrorDescription.setText("Сервис временно недоступен. Попробуйте повторить попытку позже.");
                    } else if (i != 2 && i != 3) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        this.recoveryHandlerBinding.accountRecoveryHandlerErrorDescription.setText("Сервис временно недоступен. Попробуйте повторить попытку позже.");
                        disableUpdateButton();
                        this.requestState = RequestState.RECEIVED_BAD_ANSWER_FROM_SERVER;
                    }
                    enableError();
                    disableUpdateButton();
                    return;
                }
                return;
            case -591463114:
                if (data.equals("code_error")) {
                    this.recoveryHandlerBinding.accountRecoveryHandlerErrorContainer.setVisibility(0);
                    this.recoveryHandlerBinding.accountRecoveryHandlerErrorDescription.setText("Указан неверный проверочный код. Проверьте правильность написания и повторите попытку.");
                    enableError();
                    disableUpdateButton();
                    return;
                }
                return;
            case -539121290:
                if (data.equals("account_error")) {
                    RecoveryMethodType recoveryMethodType2 = getRecoveryMethodType();
                    this.recoveryHandlerBinding.accountRecoveryHandlerErrorContainer.setVisibility(0);
                    int i2 = WhenMappings.$EnumSwitchMapping$1[recoveryMethodType2.ordinal()];
                    if (i2 == 1) {
                        this.recoveryHandlerBinding.accountRecoveryHandlerErrorDescription.setText("Аккаунт не найден. Никнейм или почта указаны некорректно. Проверьте правильность написания.");
                    } else if (i2 == 2) {
                        this.recoveryHandlerBinding.accountRecoveryHandlerErrorDescription.setText("Аккаунт не найден. telegram id указан некорректно. Проверьте правильность написания.");
                        disableUpdateButton();
                        this.requestState = RequestState.RECEIVED_BAD_ANSWER_FROM_SERVER;
                    } else if (i2 != 3) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        this.recoveryHandlerBinding.accountRecoveryHandlerErrorDescription.setText("Аккаунт не найден. vk id указан некорректно. Проверьте правильность написания.");
                        disableUpdateButton();
                        this.requestState = RequestState.RECEIVED_BAD_ANSWER_FROM_SERVER;
                    }
                    enableError();
                    disableUpdateButton();
                    return;
                }
                return;
            case 1207301105:
                if (data.equals("account_success")) {
                    AccountRecoveryHandlerBinding accountRecoveryHandlerBinding = this.recoveryHandlerBinding;
                    accountRecoveryHandlerBinding.accountRecoveryHandlerMethodIcon.setImageResource(R.drawable.auth2_icon);
                    accountRecoveryHandlerBinding.accountRecoveryTypePlaceholder.setText("");
                    accountRecoveryHandlerBinding.accountRecoveryTypePlaceholder.setHint("Введите проверочный код");
                    ConstraintLayout constraintLayout = accountRecoveryHandlerBinding.accountRecoveryHandlerInfoContainer;
                    this.requestState = RequestState.INIT;
                    constraintLayout.setVisibility(8);
                    accountRecoveryHandlerBinding.accountRecoveryDescription.setText("Проверочный код уже выслан " + (this.recoveryMethod == RecoveryMethodType.MAIL.getId() ? "на вашу почту" : "в Вконтакте") + ". Проверьте спам, если не можете найти его");
                    accountRecoveryHandlerBinding.accountRecoveryHandlerUpdateButtonTxt.setText("Сбросить пароль");
                    accountRecoveryHandlerBinding.accountRecoveryHandlerUpdateButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryHandler$$ExternalSyntheticLambda6
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            RecoveryHandler.onServerRecoveryResponse$lambda$11$lambda$9(RecoveryHandler.this, view);
                        }
                    });
                    EditText accountRecoveryTypePlaceholder = accountRecoveryHandlerBinding.accountRecoveryTypePlaceholder;
                    Intrinsics.checkNotNullExpressionValue(accountRecoveryTypePlaceholder, "accountRecoveryTypePlaceholder");
                    accountRecoveryTypePlaceholder.addTextChangedListener(new TextWatcher() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryHandler$onServerRecoveryResponse$lambda$11$$inlined$addTextChangedListener$default$1
                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable editable) {
                            AccountRecoveryHandlerBinding accountRecoveryHandlerBinding2;
                            accountRecoveryHandlerBinding2 = RecoveryHandler.this.recoveryHandlerBinding;
                            String obj = accountRecoveryHandlerBinding2.accountRecoveryTypePlaceholder.getText().toString();
                            RecoveryHandler.this.inputCode = obj;
                            String str = obj;
                            if (str.length() <= 0 || StringsKt.isBlank(str)) {
                                RecoveryHandler.this.enableError();
                                RecoveryHandler.this.disableUpdateButton();
                                return;
                            }
                            RecoveryHandler.this.disableError();
                            RecoveryHandler.this.enableUpdateButton();
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onServerRecoveryResponse$lambda$11$lambda$9(RecoveryHandler recoveryHandler, View view) {
        int i = WhenMappings.$EnumSwitchMapping$0[recoveryHandler.requestState.ordinal()];
        if (i == 1) {
            recoveryHandler.sendRecoveryCode();
        } else if (i == 2) {
            Toast.makeText(recoveryHandler.targetActivity, "Пожалуйста, подождите...", 0).show();
        } else if (i == 3) {
            Toast.makeText(recoveryHandler.targetActivity, "Для того что бы отправить запрос повторно, необходимо ввести корректную информацию", 0).show();
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            Toast.makeText(recoveryHandler.targetActivity, "Заполните все обязательные поля!", 0).show();
        }
    }

    public final void selectRecoveryMethod(String recoveryMethod) {
        Intrinsics.checkNotNullParameter(recoveryMethod, "recoveryMethod");
        this.requestState = RequestState.DISABLE;
        this.recoveryHandlerBinding.accountRecoveryHandlerPlaceholder.setText(recoveryMethod);
        this.recoveryHandlerBinding.accountRecoveryHandlerInfoContainer.setVisibility(8);
        this.recoveryHandlerBinding.accountRecoveryHandlerInput.setVisibility(0);
        CharSequence text = this.recoveryHandlerBinding.accountRecoveryHandlerPlaceholder.getText();
        if (Intrinsics.areEqual(text, "Почта")) {
            this.recoveryHandlerBinding.accountRecoveryTypePlaceholder.setHint("Адрес электронной почты");
            this.recoveryHandlerBinding.accountRecoveryTypePlaceholder.setText("");
            this.recoveryHandlerBinding.accountRecoveryHandlerMethodIcon.setImageResource(R.drawable.mail_ic);
            this.recoveryMethod = RecoveryMethodType.MAIL.getId();
        } else if (Intrinsics.areEqual(text, "Вконтакте")) {
            this.recoveryHandlerBinding.accountRecoveryTypePlaceholder.setHint("ID профиля VK");
            this.recoveryHandlerBinding.accountRecoveryTypePlaceholder.setText("");
            this.recoveryHandlerBinding.accountRecoveryHandlerMethodIcon.setImageResource(R.drawable.vk_ic);
            this.recoveryMethod = RecoveryMethodType.VK.getId();
        } else if (Intrinsics.areEqual(text, "Телеграм")) {
            this.recoveryHandlerBinding.accountRecoveryTypePlaceholder.setHint("ID профиля Telegram");
            this.recoveryHandlerBinding.accountRecoveryTypePlaceholder.setText("");
            this.recoveryHandlerBinding.accountRecoveryHandlerMethodIcon.setImageResource(R.drawable.ic_telegram);
            this.recoveryMethod = RecoveryMethodType.TELEGRAM.getId();
        }
        EditText accountRecoveryTypePlaceholder = this.recoveryHandlerBinding.accountRecoveryTypePlaceholder;
        Intrinsics.checkNotNullExpressionValue(accountRecoveryTypePlaceholder, "accountRecoveryTypePlaceholder");
        accountRecoveryTypePlaceholder.addTextChangedListener(new TextWatcher() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryHandler$selectRecoveryMethod$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                AccountRecoveryHandlerBinding accountRecoveryHandlerBinding;
                String str;
                AccountRecoveryHandlerBinding accountRecoveryHandlerBinding2;
                int i;
                RequestState requestState;
                accountRecoveryHandlerBinding = RecoveryHandler.this.recoveryHandlerBinding;
                String obj = accountRecoveryHandlerBinding.accountRecoveryTypePlaceholder.getText().toString();
                str = RecoveryHandler.this.inputText;
                if (!Intrinsics.areEqual(str, obj)) {
                    String str2 = obj;
                    if (str2.length() > 0 && !StringsKt.isBlank(str2)) {
                        accountRecoveryHandlerBinding2 = RecoveryHandler.this.recoveryHandlerBinding;
                        accountRecoveryHandlerBinding2.accountRecoveryHandlerErrorContainer.setVisibility(8);
                        i = RecoveryHandler.this.recoveryMethod;
                        if (i == RecoveryMethodType.TELEGRAM.getId() || i == RecoveryMethodType.VK.getId()) {
                            RecoveryHandler.this.enableUpdateButton();
                            RecoveryHandler.this.disableError();
                            return;
                        } else if (i == RecoveryMethodType.MAIL.getId()) {
                            if (Patterns.EMAIL_ADDRESS.matcher(str2).matches()) {
                                requestState = RecoveryHandler.this.requestState;
                                if (requestState != RequestState.SEND_TO_SERVER) {
                                    RecoveryHandler.this.enableUpdateButton();
                                    RecoveryHandler.this.disableError();
                                    return;
                                }
                                RecoveryHandler.this.enableError();
                                return;
                            }
                            RecoveryHandler.this.disableUpdateButton();
                            RecoveryHandler.this.enableError();
                            return;
                        } else {
                            return;
                        }
                    }
                }
                RecoveryHandler.this.disableUpdateButton();
                RecoveryHandler.this.enableError();
            }
        });
    }

    public final void setUsername(String username) {
        Intrinsics.checkNotNullParameter(username, "username");
        this.username = username;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enableError() {
        this.recoveryHandlerBinding.accountRecoveryHandlerIsExistIcon.setImageResource(R.drawable.auth_error_ic);
        this.requestState = RequestState.DISABLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disableError() {
        this.recoveryHandlerBinding.accountRecoveryHandlerIsExistIcon.setImageResource(R.drawable.arrow_right_ic);
        this.requestState = RequestState.INIT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disableUpdateButton() {
        this.recoveryHandlerBinding.accountRecoveryHandlerUpdateButton.setBackgroundResource(R.drawable.authorization_border);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enableUpdateButton() {
        this.recoveryHandlerBinding.accountRecoveryHandlerUpdateButton.setBackgroundResource(R.drawable.authorization_border_red);
    }

    private final RecoveryMethodType getRecoveryMethodType() {
        CharSequence text = this.recoveryHandlerBinding.accountRecoveryHandlerPlaceholder.getText();
        return Intrinsics.areEqual(text, "Почта") ? RecoveryMethodType.MAIL : Intrinsics.areEqual(text, "Вконтакте") ? RecoveryMethodType.VK : RecoveryMethodType.TELEGRAM;
    }

    private final void getInputText() {
        this.inputText = this.recoveryHandlerBinding.accountRecoveryTypePlaceholder.getText().toString();
    }

    private final void sendRecoveryCode() {
        if (this.inputCode.length() > 0 && !StringsKt.isBlank(this.inputCode)) {
            IBackendNotifier iBackendNotifier = this.notifier;
            int i = this.backendID;
            byte[] bytes = StringKt.toStringJson(new SetRecoveryCode(this.recoveryMethod, this.inputCode)).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            iBackendNotifier.clickedWrapper(i, 4, 1, bytes);
            return;
        }
        Toast.makeText(this.targetActivity, "Проверьте правильность введенных полей!", 0).show();
    }

    private final void resetRecoveryHandler() {
        disableError();
        this.recoveryMethod = -1;
        this.requestState = RequestState.DISABLE;
        this.inputCode = "";
        this.inputText = "Почта";
        this.recoveryHandlerBinding.accountRecoveryHandlerPlaceholder.setText("Способ восстановления");
        this.recoveryHandlerBinding.accountRecoveryHandlerPlaceholder.setTextColor(Color.parseColor("#979797"));
        this.recoveryHandlerBinding.accountRecoveryHandlerInfoContainer.setVisibility(0);
        this.recoveryHandlerBinding.accountRecoveryDescription.setText("Выберите способ получения нового пароля для вашего аккаунта");
        this.recoveryHandlerBinding.accountRecoveryHandlerErrorContainer.setVisibility(8);
        this.recoveryHandlerBinding.accountRecoveryHandlerInput.setVisibility(8);
        this.recoveryHandlerBinding.accountRecoveryHandlerUpdateButtonTxt.setText("Отправить код");
        this.recoveryHandlerBinding.accountRecoveryHandlerUpdateButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryHandler$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveryHandler.resetRecoveryHandler$lambda$13(RecoveryHandler.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetRecoveryHandler$lambda$13(RecoveryHandler recoveryHandler, View view) {
        int i = WhenMappings.$EnumSwitchMapping$0[recoveryHandler.requestState.ordinal()];
        if (i == 1) {
            recoveryHandler.sendRecoveryInfo();
        } else if (i == 2) {
            Toast.makeText(recoveryHandler.targetActivity, "Пожалуйста, подождите...", 0).show();
        } else if (i == 3) {
            Toast.makeText(recoveryHandler.targetActivity, "Для того что бы отправить запрос повторно, необходимо ввести корректную информацию", 0).show();
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            Toast.makeText(recoveryHandler.targetActivity, "Заполните все обязательные поля!", 0).show();
        }
    }

    private final void sendRecoveryInfo() {
        getInputText();
        String str = this.username;
        if (str != null) {
            IBackendNotifier iBackendNotifier = this.notifier;
            int id = UIElementID.AUTHORIZATION.getId();
            byte[] bytes = StringKt.toStringJson(new SetRecoveryInfo(StringsKt.trim((CharSequence) str).toString(), this.recoveryMethod, this.inputText)).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            iBackendNotifier.clickedWrapper(id, 4, 0, bytes);
            this.requestState = RequestState.SEND_TO_SERVER;
            disableUpdateButton();
            return;
        }
        Toast.makeText(this.targetActivity, "Вернитесь на окно авторизации и введите никнейм что бы продолжить процедуру восстонавления!", 1).show();
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        this.recoveryHandlerBinding.accountRecoveryHandler.setVisibility(z ? 0 : 8);
    }
}
