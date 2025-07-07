package ru.mrlargha.commonui.elements.authorization.presentation.screen;

import android.app.Activity;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.Toast;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.Character;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.databinding.BackgroundVideoBinding;
import ru.mrlargha.commonui.databinding.RegistrationAccountBinding;
import ru.mrlargha.commonui.elements.authorization.domain.RequestState;
import ru.mrlargha.commonui.elements.authorization.domain.controller.RegistrationInterfaceType;
import ru.mrlargha.commonui.elements.authorization.domain.controller.RegistrationVideoModeType;
import ru.mrlargha.commonui.elements.authorization.domain.registration.RegistrationAccountData;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceManager;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: RegistrationAccount.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u0000 52\u00020\u0001:\u000245B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\u0019\u001a\u00020\u001a*\u00020\u001bH\u0002J \u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0002J\u000e\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0015J\u000e\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u0015J\b\u0010%\u001a\u00020\u001aH\u0002J\b\u0010&\u001a\u00020\u001aH\u0002J\b\u0010'\u001a\u00020\u001aH\u0002J\b\u0010(\u001a\u00020\u001aH\u0002J\b\u0010)\u001a\u00020\u001aH\u0002J\b\u0010*\u001a\u00020\u001aH\u0002J\b\u0010+\u001a\u00020\u001aH\u0002J\b\u0010,\u001a\u00020\u001aH\u0002J\b\u0010-\u001a\u00020\u001aH\u0002J\b\u0010.\u001a\u00020\u001aH\u0002J\u0018\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0015H\u0002J\n\u0010/\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020 H\u0002J\u0010\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020 H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/screen/RegistrationAccount;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "registrationAccount", "Landroidx/constraintlayout/widget/ConstraintLayout;", "videoBinding", "Lru/mrlargha/commonui/databinding/BackgroundVideoBinding;", "notifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "registrationAccountBinding", "Lru/mrlargha/commonui/databinding/RegistrationAccountBinding;", "requestState", "Lru/mrlargha/commonui/elements/authorization/domain/RequestState;", "sharedPreferences", "Landroid/content/SharedPreferences;", "localUsername", "", "localSurname", "localPassword", "localInvite", "checkRaisingContent", "", "Landroid/widget/EditText;", "addRegData", HintConstants.AUTOFILL_HINT_USERNAME, HintConstants.AUTOFILL_HINT_PASSWORD, "rememberMe", "", "isCyrillic", CmcdData.STREAMING_FORMAT_SS, "onServerAccountResponse", "data", "enableUsernameError", "disableUsernameError", "enableSurnameError", "disableSurnameError", "enablePasswordError", "disablePasswordError", "enableInviteError", "disableInviteError", "enableRegistrationButton", "disableRegistrationButton", "getServerId", "setRegisteredState", RemoteConfigConstants.ResponseFieldKey.STATE, "setVisible", "visible", "ContainerData", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RegistrationAccount implements InterfaceController {
    public static final Companion Companion = new Companion(null);
    private static final String REGDATA = "REGDATA";
    private static final String SERVER_ID = "SERVER_ID";
    private static final String SP_NAME = "UI_ELEMENTS_SP";
    private final int backendID;
    private String localInvite;
    private String localPassword;
    private String localSurname;
    private String localUsername;
    private final IBackendNotifier notifier;
    private final ConstraintLayout registrationAccount;
    private final RegistrationAccountBinding registrationAccountBinding;
    private RequestState requestState;
    private final SharedPreferences sharedPreferences;
    private final Activity targetActivity;
    private final BackgroundVideoBinding videoBinding;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$7(View view) {
    }

    public RegistrationAccount(Activity targetActivity, int i) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.targetActivity = targetActivity;
        this.backendID = i;
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.registration_account, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.registrationAccount = constraintLayout;
        InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.VIDEO_BACKGROUND.getId(), targetActivity, i);
        Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationVideoBackground");
        BackgroundVideoBinding mainBinding = ((RegistrationVideoBackground) orCreateInterface).getMainBinding();
        this.videoBinding = mainBinding;
        Intrinsics.checkNotNull(targetActivity, "null cannot be cast to non-null type ru.mrlargha.commonui.core.IBackendNotifier");
        this.notifier = (IBackendNotifier) targetActivity;
        RegistrationAccountBinding bind = RegistrationAccountBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.registrationAccountBinding = bind;
        this.requestState = RequestState.INIT;
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences(SP_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sharedPreferences = sharedPreferences;
        this.localUsername = "";
        this.localSurname = "";
        this.localPassword = "";
        this.localInvite = "";
        mainBinding.video.addView(bind.registrationAccount, -1, -1);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(mainBinding.video);
        constraintSet.connect(bind.registrationAccount.getId(), 1, mainBinding.video.getId(), 1);
        constraintSet.connect(bind.registrationAccount.getId(), 3, mainBinding.video.getId(), 3);
        constraintSet.connect(bind.registrationAccount.getId(), 4, mainBinding.video.getId(), 4);
        constraintSet.applyTo(mainBinding.video);
        bind.registrationAccountNextButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationAccount$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegistrationAccount._init_$lambda$0(RegistrationAccount.this, view);
            }
        });
        EditText registrationAccountPasswordPlaceholder = bind.registrationAccountPasswordPlaceholder;
        Intrinsics.checkNotNullExpressionValue(registrationAccountPasswordPlaceholder, "registrationAccountPasswordPlaceholder");
        checkRaisingContent(registrationAccountPasswordPlaceholder);
        EditText registrationAccountSurnamePlaceholder = bind.registrationAccountSurnamePlaceholder;
        Intrinsics.checkNotNullExpressionValue(registrationAccountSurnamePlaceholder, "registrationAccountSurnamePlaceholder");
        checkRaisingContent(registrationAccountSurnamePlaceholder);
        EditText registrationAccountUsernamePlaceholder = bind.registrationAccountUsernamePlaceholder;
        Intrinsics.checkNotNullExpressionValue(registrationAccountUsernamePlaceholder, "registrationAccountUsernamePlaceholder");
        checkRaisingContent(registrationAccountUsernamePlaceholder);
        EditText registrationAccountUsernamePlaceholder2 = bind.registrationAccountUsernamePlaceholder;
        Intrinsics.checkNotNullExpressionValue(registrationAccountUsernamePlaceholder2, "registrationAccountUsernamePlaceholder");
        registrationAccountUsernamePlaceholder2.addTextChangedListener(new TextWatcher() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationAccount$special$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                RegistrationAccountBinding registrationAccountBinding;
                RegistrationAccountBinding registrationAccountBinding2;
                String str;
                registrationAccountBinding = RegistrationAccount.this.registrationAccountBinding;
                String obj = registrationAccountBinding.registrationAccountUsernamePlaceholder.getText().toString();
                registrationAccountBinding2 = RegistrationAccount.this.registrationAccountBinding;
                registrationAccountBinding2.registrationAccountUsernamePlaceholder.requestFocus();
                String str2 = obj;
                if (StringsKt.isBlank(str2) || str2.length() <= 0) {
                    return;
                }
                str = RegistrationAccount.this.localUsername;
                if (Intrinsics.areEqual(str, obj)) {
                    return;
                }
                RegistrationAccount.this.disableUsernameError();
                RegistrationAccount.this.enableRegistrationButton();
            }
        });
        EditText registrationAccountSurnamePlaceholder2 = bind.registrationAccountSurnamePlaceholder;
        Intrinsics.checkNotNullExpressionValue(registrationAccountSurnamePlaceholder2, "registrationAccountSurnamePlaceholder");
        registrationAccountSurnamePlaceholder2.addTextChangedListener(new TextWatcher() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationAccount$special$$inlined$addTextChangedListener$default$2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                RegistrationAccountBinding registrationAccountBinding;
                RegistrationAccountBinding registrationAccountBinding2;
                String str;
                registrationAccountBinding = RegistrationAccount.this.registrationAccountBinding;
                String obj = registrationAccountBinding.registrationAccountSurnamePlaceholder.getText().toString();
                registrationAccountBinding2 = RegistrationAccount.this.registrationAccountBinding;
                registrationAccountBinding2.registrationAccountSurnamePlaceholder.requestFocus();
                String str2 = obj;
                if (StringsKt.isBlank(str2) || str2.length() <= 0) {
                    return;
                }
                str = RegistrationAccount.this.localSurname;
                if (Intrinsics.areEqual(str, obj)) {
                    return;
                }
                RegistrationAccount.this.disableSurnameError();
                RegistrationAccount.this.enableRegistrationButton();
            }
        });
        EditText registrationAccountPasswordPlaceholder2 = bind.registrationAccountPasswordPlaceholder;
        Intrinsics.checkNotNullExpressionValue(registrationAccountPasswordPlaceholder2, "registrationAccountPasswordPlaceholder");
        registrationAccountPasswordPlaceholder2.addTextChangedListener(new TextWatcher() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationAccount$special$$inlined$addTextChangedListener$default$3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                RegistrationAccountBinding registrationAccountBinding;
                RegistrationAccountBinding registrationAccountBinding2;
                String str;
                registrationAccountBinding = RegistrationAccount.this.registrationAccountBinding;
                registrationAccountBinding.registrationAccountPasswordPlaceholder.requestFocus();
                registrationAccountBinding2 = RegistrationAccount.this.registrationAccountBinding;
                String obj = registrationAccountBinding2.registrationAccountPasswordPlaceholder.getText().toString();
                String str2 = obj;
                if (StringsKt.isBlank(str2) || str2.length() <= 0) {
                    return;
                }
                str = RegistrationAccount.this.localPassword;
                if (Intrinsics.areEqual(str, obj)) {
                    return;
                }
                RegistrationAccount.this.disablePasswordError();
                RegistrationAccount.this.enableRegistrationButton();
            }
        });
        EditText registrationAccountInvitePlaceholder = bind.registrationAccountInvitePlaceholder;
        Intrinsics.checkNotNullExpressionValue(registrationAccountInvitePlaceholder, "registrationAccountInvitePlaceholder");
        registrationAccountInvitePlaceholder.addTextChangedListener(new TextWatcher() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationAccount$special$$inlined$addTextChangedListener$default$4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                RegistrationAccountBinding registrationAccountBinding;
                RegistrationAccountBinding registrationAccountBinding2;
                String str;
                registrationAccountBinding = RegistrationAccount.this.registrationAccountBinding;
                registrationAccountBinding.registrationAccountInvitePlaceholder.requestFocus();
                registrationAccountBinding2 = RegistrationAccount.this.registrationAccountBinding;
                String obj = registrationAccountBinding2.registrationAccountInvitePlaceholder.getText().toString();
                str = RegistrationAccount.this.localInvite;
                if (Intrinsics.areEqual(str, obj)) {
                    return;
                }
                RegistrationAccount.this.disableInviteError();
                RegistrationAccount.this.enableRegistrationButton();
            }
        });
        bind.registrationAccountIsExistButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationAccount$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegistrationAccount._init_$lambda$6(RegistrationAccount.this, view);
            }
        });
        bind.registrationAccount.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationAccount$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegistrationAccount._init_$lambda$7(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(RegistrationAccount registrationAccount, View view) {
        if (registrationAccount.requestState == RequestState.SEND_TO_SERVER) {
            Toast.makeText(registrationAccount.targetActivity, "Подождите...", 0).show();
        } else if (registrationAccount.requestState == RequestState.DISABLE) {
            Toast.makeText(registrationAccount.targetActivity, "Исправьте отмеченные поля!", 1).show();
        } else if (registrationAccount.requestState == RequestState.RECEIVED_BAD_ANSWER_FROM_SERVER) {
            Toast.makeText(registrationAccount.targetActivity, "Исправьте отмеченные поля!", 0).show();
        } else {
            String obj = StringsKt.trim((CharSequence) registrationAccount.registrationAccountBinding.registrationAccountUsernamePlaceholder.getText().toString()).toString();
            String obj2 = StringsKt.trim((CharSequence) registrationAccount.registrationAccountBinding.registrationAccountSurnamePlaceholder.getText().toString()).toString();
            String obj3 = registrationAccount.registrationAccountBinding.registrationAccountPasswordPlaceholder.getText().toString();
            String obj4 = registrationAccount.registrationAccountBinding.registrationAccountInvitePlaceholder.getText().toString();
            registrationAccount.localUsername = obj;
            registrationAccount.localSurname = obj2;
            registrationAccount.localPassword = obj3;
            registrationAccount.localInvite = obj4;
            Regex regex = new Regex("^[A-Za-z0-9]{2,17}");
            Regex regex2 = new Regex("^[A-Za-z0-9]{2,17}");
            Regex regex3 = new Regex("^[A-Za-z0-9_]{4,20}");
            String str = obj + "_" + obj2;
            int length = obj3.length();
            boolean z = 6 <= length && length < 33;
            if (registrationAccount.isCyrillic(obj)) {
                Toast.makeText(registrationAccount.targetActivity, "Имя игрока должно использовать только буквы английского алфавита.", 1).show();
                registrationAccount.enableUsernameError();
                registrationAccount.disableRegistrationButton();
            } else if (registrationAccount.isCyrillic(obj2)) {
                Toast.makeText(registrationAccount.targetActivity, "Фамилия игрока должна использовать только буквы английского алфавита.", 1).show();
                registrationAccount.enableSurnameError();
                registrationAccount.disableRegistrationButton();
            } else if (!regex.matches(obj)) {
                Toast.makeText(registrationAccount.targetActivity, "Имя игрока должно содержать от 2 до 17 символов.", 1).show();
                registrationAccount.enableUsernameError();
                registrationAccount.disableRegistrationButton();
            } else if (!regex2.matches(obj2)) {
                Toast.makeText(registrationAccount.targetActivity, "Фамилия игрока должно содержать от 2 до 17 символов.", 1).show();
                registrationAccount.enableSurnameError();
                registrationAccount.disableRegistrationButton();
            } else if (!regex3.matches(str)) {
                Toast.makeText(registrationAccount.targetActivity, "Фамилия и имя игрока должны содержать в сумме от 4 до 20 символов.", 1).show();
                registrationAccount.enableSurnameError();
                registrationAccount.enableUsernameError();
                registrationAccount.disableRegistrationButton();
            } else if (!z) {
                Toast.makeText(registrationAccount.targetActivity, "Пароль не может быть короче 6 и длинее 32 символов!", 1).show();
                registrationAccount.enablePasswordError();
                registrationAccount.disableRegistrationButton();
            } else {
                IBackendNotifier iBackendNotifier = registrationAccount.notifier;
                int i = registrationAccount.backendID;
                byte[] bytes = StringKt.toStringJson(new RegistrationAccountData(str, obj3, obj4)).getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                iBackendNotifier.clickedWrapper(i, 1, 0, bytes);
                registrationAccount.disableRegistrationButton();
                registrationAccount.requestState = RequestState.SEND_TO_SERVER;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$6(RegistrationAccount registrationAccount, View view) {
        InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.VIDEO_BACKGROUND.getId(), registrationAccount.targetActivity, registrationAccount.backendID);
        Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationVideoBackground");
        InterfaceController orCreateInterface2 = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.AUTH_INIT.getId(), registrationAccount.targetActivity, registrationAccount.backendID);
        Intrinsics.checkNotNull(orCreateInterface2, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization");
        InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.AUTHORIZATION_NEWS.getId(), registrationAccount.targetActivity, registrationAccount.backendID).setVisible(true);
        ((RegistrationVideoBackground) orCreateInterface).selectVideoMode(RegistrationVideoModeType.VIDEO_AUTHORIZATION);
        registrationAccount.setVisible(false);
        ((Authorization) orCreateInterface2).setVisible(true);
    }

    private final void checkRaisingContent(final EditText editText) {
        final Ref.IntRef intRef = new Ref.IntRef();
        final RegistrationAccountBinding registrationAccountBinding = this.registrationAccountBinding;
        editText.post(new Runnable() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationAccount$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                RegistrationAccount.checkRaisingContent$lambda$9$lambda$8(RegistrationAccountBinding.this, editText, this, intRef);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkRaisingContent$lambda$9$lambda$8(final RegistrationAccountBinding registrationAccountBinding, EditText editText, final RegistrationAccount registrationAccount, final Ref.IntRef intRef) {
        int[] iArr = new int[2];
        registrationAccountBinding.registrationAccountPasswordPlaceholder.getLocationOnScreen(iArr);
        final int height = iArr[1] + registrationAccountBinding.registrationAccountPasswordPlaceholder.getHeight();
        final int height2 = registrationAccountBinding.registrationAccountBackground.getRootView().getHeight();
        editText.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationAccount$checkRaisingContent$1$1$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Activity activity;
                activity = RegistrationAccount.this.targetActivity;
                int keyboardHeightOrNull = UtilsKt.getKeyboardHeightOrNull(activity);
                if (keyboardHeightOrNull != intRef.element) {
                    intRef.element = keyboardHeightOrNull;
                    if (intRef.element == 0) {
                        registrationAccountBinding.registrationAccountBackground.setTranslationY(0.0f);
                        return;
                    }
                    int i = height2 - intRef.element;
                    int i2 = height;
                    if (i2 > i) {
                        registrationAccountBinding.registrationAccountBackground.setTranslationY(-(i2 - i));
                        return;
                    }
                    registrationAccountBinding.registrationAccountBackground.setTranslationY(0.0f);
                }
            }
        });
    }

    private final void addRegData(String str, String str2, boolean z) {
        String string = this.sharedPreferences.getString("REGDATA", new JSONObject().toString());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str3 = string;
        if (str3 != null && str3.length() != 0) {
            Map map = (Map) new Gson().fromJson(string, new TypeToken<Map<String, ? extends ContainerData>>() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationAccount$addRegData$type$1
            }.getType());
            Intrinsics.checkNotNull(map);
            linkedHashMap.putAll(map);
            linkedHashMap.put(String.valueOf(getServerId()), new ContainerData(str, str2, z));
        } else {
            linkedHashMap.put(String.valueOf(getServerId()), new ContainerData(str, str2, z));
        }
        this.sharedPreferences.edit().putString("REGDATA", new Gson().toJson(linkedHashMap)).apply();
    }

    public final boolean isCyrillic(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        char[] charArray = s.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        for (char c : charArray) {
            if (Intrinsics.areEqual(Character.UnicodeBlock.of(c), Character.UnicodeBlock.CYRILLIC)) {
                return true;
            }
        }
        return false;
    }

    public final void onServerAccountResponse(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        switch (data.hashCode()) {
            case -1867169789:
                if (data.equals(FirebaseAnalytics.Param.SUCCESS)) {
                    enableRegistrationButton();
                    String str = this.localUsername;
                    addRegData(str + "_" + this.localSurname, this.localPassword);
                    RegistrationAccountBinding registrationAccountBinding = this.registrationAccountBinding;
                    registrationAccountBinding.registrationAccountUsernamePlaceholder.setText("");
                    registrationAccountBinding.registrationAccountPasswordPlaceholder.setText("");
                    registrationAccountBinding.registrationAccountInvitePlaceholder.setText("");
                    InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.REGISTRATION_PED_SETTINGS.getId(), this.targetActivity, this.backendID);
                    Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationPedSettings");
                    setRegisteredState(true);
                    setVisible(false);
                    ((RegistrationPedSettings) orCreateInterface).setVisible(true);
                    return;
                }
                return;
            case -677697707:
                if (data.equals("referral_invalid")) {
                    Toast.makeText(this.targetActivity, "Рефералл с данным никнеймом не найден!", 0).show();
                    enableInviteError();
                    return;
                }
                return;
            case 561732553:
                if (data.equals("pass_invalid")) {
                    Toast.makeText(this.targetActivity, "Пароль не соотвествует требованиям!", 0).show();
                    enablePasswordError();
                    return;
                }
                return;
            case 1922004355:
                if (data.equals("user_exist")) {
                    Toast.makeText(this.targetActivity, "Такой никнейм уже существует!", 0).show();
                    enableUsernameError();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void enableUsernameError() {
        this.registrationAccountBinding.registrationAccountUsernameCheck.setVisibility(0);
        this.registrationAccountBinding.registrationAccountUsernameCheck.setImageResource(R.drawable.auth_error_ic);
        this.registrationAccountBinding.registrationAccountUsernameCheck.setRotation(0.0f);
        this.requestState = RequestState.DISABLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disableUsernameError() {
        this.registrationAccountBinding.registrationAccountUsernameCheck.setVisibility(8);
        this.requestState = RequestState.INIT;
    }

    private final void enableSurnameError() {
        this.registrationAccountBinding.registrationAccountSurnameCheck.setVisibility(0);
        this.registrationAccountBinding.registrationAccountSurnameCheck.setImageResource(R.drawable.auth_error_ic);
        this.registrationAccountBinding.registrationAccountSurnameCheck.setRotation(0.0f);
        this.requestState = RequestState.DISABLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disableSurnameError() {
        this.registrationAccountBinding.registrationAccountSurnameCheck.setVisibility(8);
        this.requestState = RequestState.INIT;
    }

    private final void enablePasswordError() {
        this.registrationAccountBinding.registrationAccountPasswordCheck.setVisibility(0);
        this.registrationAccountBinding.registrationAccountPasswordCheck.setImageResource(R.drawable.auth_error_ic);
        this.registrationAccountBinding.registrationAccountPasswordCheck.setRotation(0.0f);
        this.requestState = RequestState.DISABLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disablePasswordError() {
        this.registrationAccountBinding.registrationAccountPasswordCheck.setVisibility(8);
        this.requestState = RequestState.INIT;
    }

    private final void enableInviteError() {
        this.registrationAccountBinding.registrationAccountInviteCheck.setVisibility(0);
        this.registrationAccountBinding.registrationAccountInviteCheck.setImageResource(R.drawable.auth_error_ic);
        this.registrationAccountBinding.registrationAccountInviteCheck.setRotation(0.0f);
        this.requestState = RequestState.DISABLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disableInviteError() {
        this.registrationAccountBinding.registrationAccountInviteCheck.setVisibility(8);
        this.requestState = RequestState.INIT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enableRegistrationButton() {
        this.registrationAccountBinding.registrationAccountNextButton.setBackgroundResource(R.drawable.authorization_border_red);
    }

    private final void disableRegistrationButton() {
        this.registrationAccountBinding.registrationAccountNextButton.setBackgroundResource(R.drawable.authorization_border);
    }

    private final void addRegData(String str, String str2) {
        String string = this.sharedPreferences.getString("REGDATA", new JSONObject().toString());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str3 = string;
        if (str3 != null && str3.length() != 0) {
            Map map = (Map) new Gson().fromJson(string, new TypeToken<Map<String, ? extends ContainerData>>() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationAccount$addRegData$type$2
            }.getType());
            Intrinsics.checkNotNull(map);
            linkedHashMap.putAll(map);
            linkedHashMap.put(String.valueOf(getServerId()), new ContainerData(str, str2, true));
        } else {
            linkedHashMap.put(String.valueOf(getServerId()), new ContainerData(str, str2, true));
        }
        this.sharedPreferences.edit().putString("REGDATA", new Gson().toJson(linkedHashMap)).apply();
    }

    private final String getServerId() {
        return this.sharedPreferences.getString(SERVER_ID, "");
    }

    private final void setRegisteredState(boolean z) {
        this.sharedPreferences.edit().putBoolean(Authorization.NEW_ACCOUNT, z).apply();
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        this.registrationAccountBinding.registrationAccount.setVisibility(z ? 0 : 8);
    }

    /* compiled from: RegistrationAccount.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/screen/RegistrationAccount$ContainerData;", "", HintConstants.AUTOFILL_HINT_USERNAME, "", HintConstants.AUTOFILL_HINT_PASSWORD, "rememberMe", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "getPassword", "setPassword", "getRememberMe", "()Z", "setRememberMe", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ContainerData {
        private String password;
        private boolean rememberMe;
        private String username;

        public static /* synthetic */ ContainerData copy$default(ContainerData containerData, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = containerData.username;
            }
            if ((i & 2) != 0) {
                str2 = containerData.password;
            }
            if ((i & 4) != 0) {
                z = containerData.rememberMe;
            }
            return containerData.copy(str, str2, z);
        }

        public final String component1() {
            return this.username;
        }

        public final String component2() {
            return this.password;
        }

        public final boolean component3() {
            return this.rememberMe;
        }

        public final ContainerData copy(String username, String password, boolean z) {
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(password, "password");
            return new ContainerData(username, password, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ContainerData) {
                ContainerData containerData = (ContainerData) obj;
                return Intrinsics.areEqual(this.username, containerData.username) && Intrinsics.areEqual(this.password, containerData.password) && this.rememberMe == containerData.rememberMe;
            }
            return false;
        }

        public int hashCode() {
            return (((this.username.hashCode() * 31) + this.password.hashCode()) * 31) + Boolean.hashCode(this.rememberMe);
        }

        public String toString() {
            String str = this.username;
            String str2 = this.password;
            return "ContainerData(username=" + str + ", password=" + str2 + ", rememberMe=" + this.rememberMe + ")";
        }

        public ContainerData(String username, String password, boolean z) {
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(password, "password");
            this.username = username;
            this.password = password;
            this.rememberMe = z;
        }

        public final String getUsername() {
            return this.username;
        }

        public final void setUsername(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.username = str;
        }

        public final String getPassword() {
            return this.password;
        }

        public final void setPassword(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.password = str;
        }

        public final boolean getRememberMe() {
            return this.rememberMe;
        }

        public final void setRememberMe(boolean z) {
            this.rememberMe = z;
        }
    }

    /* compiled from: RegistrationAccount.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/screen/RegistrationAccount$Companion;", "", "<init>", "()V", "SP_NAME", "", "REGDATA", RegistrationAccount.SERVER_ID, "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
