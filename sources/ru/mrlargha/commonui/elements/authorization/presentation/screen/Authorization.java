package ru.mrlargha.commonui.elements.authorization.presentation.screen;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.Toast;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.databinding.AuthorizationBinding;
import ru.mrlargha.commonui.databinding.BackgroundVideoBinding;
import ru.mrlargha.commonui.elements.authorization.domain.AuthorizationData;
import ru.mrlargha.commonui.elements.authorization.domain.controller.RegistrationInterfaceType;
import ru.mrlargha.commonui.elements.authorization.domain.controller.RegistrationVideoModeType;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceManager;
import ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationAccount;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: Authorization.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 J2\u00020\u0001:\u0001JB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002J\b\u0010'\u001a\u00020%H\u0002J\f\u0010(\u001a\u00020%*\u00020)H\u0002J\u0016\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0019J\n\u0010-\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010.\u001a\u00020%H\u0002J\b\u0010/\u001a\u00020%H\u0002J\b\u00100\u001a\u00020%H\u0002J\b\u00101\u001a\u00020%H\u0002J\b\u00102\u001a\u00020%H\u0002J\b\u00103\u001a\u00020%H\u0002J\b\u00104\u001a\u00020%H\u0002J\b\u00105\u001a\u00020%H\u0002J\u0018\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0019H\u0002J\u0010\u00109\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\u0019H\u0002J\n\u0010:\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010;\u001a\u00020%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019H\u0002J\n\u0010<\u001a\u0004\u0018\u00010\u0019H\u0002J\n\u0010=\u001a\u0004\u0018\u00010\u0019H\u0002J\n\u0010>\u001a\u0004\u0018\u00010\u0019H\u0002J\u0006\u0010?\u001a\u00020%J\u0010\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020\u001cH\u0016J\b\u0010B\u001a\u00020%H\u0002J\b\u0010C\u001a\u00020\u001cH\u0002J\b\u0010D\u001a\u00020%H\u0002J \u0010E\u001a\u00020%2\u0006\u0010F\u001a\u00020\u00192\u0006\u0010G\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001cH\u0002J\n\u0010H\u001a\u0004\u0018\u00010IH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/screen/Authorization;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "getTargetActivity", "()Landroid/app/Activity;", "getBackendID", "()I", "authorization", "Landroidx/constraintlayout/widget/ConstraintLayout;", "authorizationBinding", "Lru/mrlargha/commonui/databinding/AuthorizationBinding;", "videoBinding", "Lru/mrlargha/commonui/databinding/BackgroundVideoBinding;", "notifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "timer", "Landroid/os/CountDownTimer;", "sharedPreferences", "Landroid/content/SharedPreferences;", "arizonaLogotypeUri", "", "rodinaLogotypeUri", "isLoginError", "", "localPassword", "localUsername", "rememberMe", "arizonaServers", "", "rodinaServers", "recoveryHandlerId", "setFilter", "", "restoreSavedCreds", "loginAction", "checkRaisingContent", "Landroid/widget/EditText;", "onServerMessage", "actionType", "data", "getPassword", "checkBoxEnabled", "resetLoginText", "checkboxDisable", "enableError", "disableError", "disableLoading", "enableLoginButton", "disableLoginButton", "installServerLogotype", "serverId", "logotypeUri", "setLocalPassword", "getLocalPassword", "setLocalUsername", "getLocalUsername", "getUsername", "getServerId", "hideLoader", "setVisible", "visible", "setRegisteredState", "getRegisteredState", "setRegistrationWindow", "addRegData", HintConstants.AUTOFILL_HINT_USERNAME, HintConstants.AUTOFILL_HINT_PASSWORD, "getUserAuthData", "Lru/mrlargha/commonui/elements/authorization/presentation/screen/RegistrationAccount$ContainerData;", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Authorization implements InterfaceController {
    public static final Companion Companion = new Companion(null);
    public static final String NEW_ACCOUNT = "NEW_ACCOUNT";
    public static final String REGDATA = "REGDATA";
    private static final String SERVER_ID = "SERVER_ID";
    private static final String SP_NAME = "UI_ELEMENTS_SP";
    private static final String TAG = "ArizonaAuthorization";
    private final String arizonaLogotypeUri;
    private final Map<Integer, String> arizonaServers;
    private final ConstraintLayout authorization;
    private final AuthorizationBinding authorizationBinding;
    private final int backendID;
    private boolean isLoginError;
    private String localPassword;
    private String localUsername;
    private final IBackendNotifier notifier;
    private final int recoveryHandlerId;
    private boolean rememberMe;
    private final String rodinaLogotypeUri;
    private final Map<Integer, String> rodinaServers;
    private final SharedPreferences sharedPreferences;
    private final Activity targetActivity;
    private CountDownTimer timer;
    private BackgroundVideoBinding videoBinding;

    public Authorization(Activity targetActivity, int i) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.targetActivity = targetActivity;
        this.backendID = i;
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.authorization, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.authorization = constraintLayout;
        AuthorizationBinding bind = AuthorizationBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.authorizationBinding = bind;
        InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.VIDEO_BACKGROUND.getId(), targetActivity, i);
        Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationVideoBackground");
        this.videoBinding = ((RegistrationVideoBackground) orCreateInterface).getMainBinding();
        Intrinsics.checkNotNull(targetActivity, "null cannot be cast to non-null type ru.mrlargha.commonui.core.IBackendNotifier");
        this.notifier = (IBackendNotifier) targetActivity;
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("UI_ELEMENTS_SP", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sharedPreferences = sharedPreferences;
        this.arizonaLogotypeUri = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "assets/images/project_icons/";
        this.rodinaLogotypeUri = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "assets/images/project_icons/";
        this.localPassword = getPassword();
        this.localUsername = getUsername();
        RegistrationAccount.ContainerData userAuthData = getUserAuthData();
        this.rememberMe = userAuthData != null && userAuthData.getRememberMe();
        this.arizonaServers = MapsKt.mapOf(TuplesKt.to(1, "Phoenix"), TuplesKt.to(2, "Tucson"), TuplesKt.to(3, "Scottdale"), TuplesKt.to(4, "Chandler"), TuplesKt.to(5, "Brainburg"), TuplesKt.to(6, "Saint-Rose"), TuplesKt.to(7, "Mesa"), TuplesKt.to(8, "Red-Rock"), TuplesKt.to(9, "Yuma"), TuplesKt.to(10, "Surprise"), TuplesKt.to(11, "Prescott"), TuplesKt.to(12, "Glendale"), TuplesKt.to(13, "Kingman"), TuplesKt.to(14, "Winslow"), TuplesKt.to(15, "Payson"), TuplesKt.to(16, "Gilbert"), TuplesKt.to(17, "Show-Low"), TuplesKt.to(18, "Casa-Grande"), TuplesKt.to(19, "Page"), TuplesKt.to(20, "Sun-City"), TuplesKt.to(21, "Queen-Creek"), TuplesKt.to(22, "Sedona"), TuplesKt.to(23, "Holiday"), TuplesKt.to(24, "Wednesday"), TuplesKt.to(25, "Yava"), TuplesKt.to(26, "Faraway"), TuplesKt.to(27, "Bumble Bee"), TuplesKt.to(28, "Christmas"), TuplesKt.to(29, "Mirage"), TuplesKt.to(30, "Love"), TuplesKt.to(31, "Drake"), TuplesKt.to(32, "Space"), TuplesKt.to(101, "Mobile 1"), TuplesKt.to(102, "Mobile 2"), TuplesKt.to(103, "Mobile 3"));
        this.rodinaServers = MapsKt.mapOf(TuplesKt.to(0, "Тестовы"), TuplesKt.to(1, "Центральный"), TuplesKt.to(2, "Южный"), TuplesKt.to(3, "Северный"), TuplesKt.to(4, "Восточный"), TuplesKt.to(5, "Западный"), TuplesKt.to(6, "Приморский"), TuplesKt.to(7, "Федеральный"), TuplesKt.to(101, "Москва"), TuplesKt.to(102, "Санкт-Петербург"), TuplesKt.to(103, "Екатеринбург"));
        this.recoveryHandlerId = RegistrationInterfaceType.RECOVERY_HANDLER.getId();
        this.videoBinding.video.addView(bind.auth, -1, -1);
        bind.authForgotPassword.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Authorization._init_$lambda$0(Authorization.this, view);
            }
        });
        if (getUserAuthData() == null) {
            setRegistrationWindow();
        }
        bind.authRememberCheckbox.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Authorization._init_$lambda$1(Authorization.this, view);
            }
        });
        bind.authLoginButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Authorization.this.loginAction();
            }
        });
        EditText authSurnameEdit = bind.authSurnameEdit;
        Intrinsics.checkNotNullExpressionValue(authSurnameEdit, "authSurnameEdit");
        checkRaisingContent(authSurnameEdit);
        EditText authUsernameEdit = bind.authUsernameEdit;
        Intrinsics.checkNotNullExpressionValue(authUsernameEdit, "authUsernameEdit");
        checkRaisingContent(authUsernameEdit);
        EditText authPasswordEdit = bind.authPasswordEdit;
        Intrinsics.checkNotNullExpressionValue(authPasswordEdit, "authPasswordEdit");
        checkRaisingContent(authPasswordEdit);
        bind.authUsernameEdit.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization$$ExternalSyntheticLambda7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                Authorization._init_$lambda$4(Authorization.this);
            }
        });
        EditText authPasswordEdit2 = bind.authPasswordEdit;
        Intrinsics.checkNotNullExpressionValue(authPasswordEdit2, "authPasswordEdit");
        authPasswordEdit2.addTextChangedListener(new TextWatcher() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization$special$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                AuthorizationBinding authorizationBinding;
                authorizationBinding = Authorization.this.authorizationBinding;
                Editable text = authorizationBinding.authPasswordEdit.getText();
                Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                if (StringsKt.isBlank(text)) {
                    return;
                }
                Authorization.this.disableError();
                Authorization.this.enableLoginButton();
            }
        });
        bind.authAccountRegistrationButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Authorization._init_$lambda$6(Authorization.this, view);
            }
        });
        setFilter();
    }

    public final int getBackendID() {
        return this.backendID;
    }

    public final Activity getTargetActivity() {
        return this.targetActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$0(Authorization authorization, View view) {
        if (authorization.timer != null) {
            authorization.resetLoginText();
            CountDownTimer countDownTimer = authorization.timer;
            if (countDownTimer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timer");
                countDownTimer = null;
            }
            countDownTimer.cancel();
        }
        String str = authorization.localUsername;
        if (str != null) {
            InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(authorization.recoveryHandlerId, authorization.targetActivity, authorization.backendID);
            Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.RecoveryHandler");
            RecoveryHandler recoveryHandler = (RecoveryHandler) orCreateInterface;
            recoveryHandler.setUsername(str);
            recoveryHandler.setVisible(true);
            return;
        }
        Activity activity = authorization.targetActivity;
        Toast.makeText(activity, activity.getString(R.string.auth_required_nickname_for_password_reset), 1).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$1(Authorization authorization, View view) {
        if (authorization.rememberMe) {
            authorization.checkboxDisable();
            authorization.rememberMe = false;
            return;
        }
        authorization.checkBoxEnabled();
        authorization.rememberMe = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$4(Authorization authorization) {
        String obj;
        EditText authUsernameEdit = authorization.authorizationBinding.authUsernameEdit;
        Intrinsics.checkNotNullExpressionValue(authUsernameEdit, "authUsernameEdit");
        if (authorization.authorizationBinding.authSurnameEdit.getText().toString().length() > 0) {
            Editable text = authorization.authorizationBinding.authUsernameEdit.getText();
            obj = ((Object) text) + "_" + ((Object) authorization.authorizationBinding.authSurnameEdit.getText());
        } else {
            obj = StringsKt.trim((CharSequence) authorization.authorizationBinding.authUsernameEdit.getText().toString()).toString();
        }
        Editable text2 = authUsernameEdit.getText();
        Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
        if (StringsKt.isBlank(text2)) {
            return;
        }
        Editable text3 = authUsernameEdit.getText();
        Intrinsics.checkNotNullExpressionValue(text3, "getText(...)");
        if (StringsKt.isBlank(text3) || Intrinsics.areEqual(authorization.getLocalUsername(), obj)) {
            return;
        }
        if (authorization.timer != null) {
            authorization.resetLoginText();
            CountDownTimer countDownTimer = authorization.timer;
            if (countDownTimer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timer");
                countDownTimer = null;
            }
            countDownTimer.cancel();
        }
        authorization.setLocalUsername(obj);
        authorization.disableError();
        authorization.enableLoginButton();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$6(Authorization authorization, View view) {
        if (authorization.timer != null) {
            authorization.resetLoginText();
            CountDownTimer countDownTimer = authorization.timer;
            if (countDownTimer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timer");
                countDownTimer = null;
            }
            countDownTimer.cancel();
        }
        authorization.setRegistrationWindow();
    }

    private final void setFilter() {
        AuthorizationBinding authorizationBinding = this.authorizationBinding;
        EditText editText = authorizationBinding.authUsernameEdit;
        InputFilter[] filters = editText.getFilters();
        Intrinsics.checkNotNullExpressionValue(filters, "getFilters(...)");
        editText.setFilters((InputFilter[]) ArraysKt.plus(filters, AuthorizationUtilsKt.getRuLettersFilter(new Function0() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit filter$lambda$0$0;
                filter$lambda$0$0 = Authorization.setFilter$lambda$0$0(Authorization.this);
                return filter$lambda$0$0;
            }
        })));
        EditText editText2 = authorizationBinding.authSurnameEdit;
        InputFilter[] filters2 = editText2.getFilters();
        Intrinsics.checkNotNullExpressionValue(filters2, "getFilters(...)");
        editText2.setFilters((InputFilter[]) ArraysKt.plus(filters2, AuthorizationUtilsKt.getRuLettersFilter(new Function0() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit filter$lambda$0$1;
                filter$lambda$0$1 = Authorization.setFilter$lambda$0$1(Authorization.this);
                return filter$lambda$0$1;
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setFilter$lambda$0$0(Authorization authorization) {
        Activity activity = authorization.targetActivity;
        Activity activity2 = activity;
        String string = activity.getString(R.string.auth_username_latin_only);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        AuthorizationUtilsKt.showErrorToast(activity2, string);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setFilter$lambda$0$1(Authorization authorization) {
        Activity activity = authorization.targetActivity;
        Activity activity2 = activity;
        String string = activity.getString(R.string.auth_surname_latin_only);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        AuthorizationUtilsKt.showErrorToast(activity2, string);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization$restoreSavedCreds$1$1] */
    private final void restoreSavedCreds() {
        RegistrationAccount.ContainerData userAuthData = getUserAuthData();
        if (userAuthData != null) {
            this.rememberMe = userAuthData.getRememberMe();
            CountDownTimer countDownTimer = null;
            if (StringsKt.contains$default((CharSequence) userAuthData.getUsername(), (CharSequence) "_", false, 2, (Object) null)) {
                List split$default = StringsKt.split$default((CharSequence) userAuthData.getUsername(), new String[]{"_"}, false, 0, 6, (Object) null);
                this.authorizationBinding.authUsernameEdit.setText((String) split$default.get(0));
                this.authorizationBinding.authSurnameEdit.setText((String) split$default.get(1));
                CountDownTimer countDownTimer2 = this.timer;
                if (countDownTimer2 != null) {
                    if (countDownTimer2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("timer");
                    } else {
                        countDownTimer = countDownTimer2;
                    }
                    countDownTimer.cancel();
                }
                CountDownTimer start = new CountDownTimer() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization$restoreSavedCreds$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(10000L, 1000L);
                    }

                    @Override // android.os.CountDownTimer
                    public void onTick(long j) {
                        AuthorizationBinding authorizationBinding;
                        authorizationBinding = Authorization.this.authorizationBinding;
                        authorizationBinding.authLoginText.setText(Authorization.this.getTargetActivity().getString(R.string.auth_connecting_in_seconds, new Object[]{Long.valueOf(j / 1000)}));
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        Authorization.this.resetLoginText();
                        Authorization.this.loginAction();
                        cancel();
                    }
                }.start();
                Intrinsics.checkNotNullExpressionValue(start, "start(...)");
                this.timer = start;
            } else {
                this.authorizationBinding.authUsernameEdit.setText(userAuthData.getUsername());
            }
        }
        if (this.rememberMe) {
            checkBoxEnabled();
            RegistrationAccount.ContainerData userAuthData2 = getUserAuthData();
            if (userAuthData2 != null) {
                this.authorizationBinding.authPasswordEdit.setText(userAuthData2.getPassword());
                return;
            }
            return;
        }
        checkboxDisable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loginAction() {
        if (this.timer != null) {
            resetLoginText();
            CountDownTimer countDownTimer = this.timer;
            if (countDownTimer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timer");
                countDownTimer = null;
            }
            countDownTimer.cancel();
        }
        AuthorizationBinding authorizationBinding = this.authorizationBinding;
        if (this.isLoginError) {
            return;
        }
        int length = authorizationBinding.authSurnameEdit.getText().toString().length();
        AuthorizationBinding authorizationBinding2 = this.authorizationBinding;
        if (length > 0) {
            Editable text = authorizationBinding2.authUsernameEdit.getText();
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            setLocalUsername(StringsKt.trim((CharSequence) (((Object) StringsKt.trim(text)) + "_" + ((Object) this.authorizationBinding.authSurnameEdit.getText()))).toString());
        } else {
            setLocalUsername(StringsKt.trim((CharSequence) authorizationBinding2.authUsernameEdit.getText().toString()).toString());
        }
        String localUsername = getLocalUsername();
        setLocalPassword(this.authorizationBinding.authPasswordEdit.getText().toString());
        String localPassword = getLocalPassword();
        if (localUsername == null) {
            disableLoginButton();
        } else if (localPassword == null) {
            disableLoginButton();
            enableError();
        } else {
            Regex regex = new Regex("^[A-Za-z0-9]{2,17}");
            int length2 = localPassword.length();
            boolean z = 6 <= length2 && length2 < 33;
            if (!regex.matches(StringsKt.trim((CharSequence) this.authorizationBinding.authUsernameEdit.getText().toString()).toString())) {
                Activity activity = this.targetActivity;
                Toast.makeText(activity, activity.getString(R.string.auth_username_length_error), 1).show();
                disableLoginButton();
            } else if (!z) {
                Activity activity2 = this.targetActivity;
                Toast.makeText(activity2, activity2.getString(R.string.auth_password_length_error), 1).show();
                disableLoginButton();
                enableError();
            } else {
                IBackendNotifier iBackendNotifier = this.notifier;
                int i = this.backendID;
                byte[] bytes = StringKt.toStringJson(new AuthorizationData(localUsername, localPassword)).getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                iBackendNotifier.clickedWrapper(i, 0, 0, bytes);
            }
        }
    }

    private final void checkRaisingContent(final EditText editText) {
        final Ref.IntRef intRef = new Ref.IntRef();
        final AuthorizationBinding authorizationBinding = this.authorizationBinding;
        editText.post(new Runnable() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Authorization.checkRaisingContent$lambda$0$0(AuthorizationBinding.this, editText, this, intRef);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkRaisingContent$lambda$0$0(final AuthorizationBinding authorizationBinding, EditText editText, final Authorization authorization, final Ref.IntRef intRef) {
        int[] iArr = new int[2];
        authorizationBinding.authPasswordEdit.getLocationOnScreen(iArr);
        final int height = iArr[1] + authorizationBinding.authPasswordEdit.getHeight();
        final int height2 = authorizationBinding.authBackground.getRootView().getHeight();
        editText.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization$checkRaisingContent$1$1$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int keyboardHeightOrNull = UtilsKt.getKeyboardHeightOrNull(Authorization.this.getTargetActivity());
                if (keyboardHeightOrNull != intRef.element) {
                    intRef.element = keyboardHeightOrNull;
                    Log.e("auth", String.valueOf(intRef.element));
                    if (intRef.element == 0) {
                        authorizationBinding.authBackground.setTranslationY(0.0f);
                        return;
                    }
                    int i = height2 - intRef.element;
                    int i2 = height;
                    AuthorizationBinding authorizationBinding2 = authorizationBinding;
                    if (i2 > i) {
                        authorizationBinding2.authBackground.setTranslationY(-(i2 - i));
                    } else {
                        authorizationBinding2.authBackground.setTranslationY(0.0f);
                    }
                }
            }
        });
    }

    /* JADX WARN: Type inference failed for: r9v108, types: [ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization$onServerMessage$1] */
    /* JADX WARN: Type inference failed for: r9v20, types: [ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization$onServerMessage$3] */
    public final void onServerMessage(int i, String data) {
        String obj;
        String obj2;
        Intrinsics.checkNotNullParameter(data, "data");
        if (i != RegistrationInterfaceType.AUTH_INIT.getId()) {
            if (i == RegistrationInterfaceType.AUTH_SERVER_ID_INFO.getId()) {
                boolean isArizonaType = UtilsKt.isArizonaType();
                if (isArizonaType) {
                    installServerLogotype(Integer.parseInt(data), this.arizonaLogotypeUri);
                    this.authorizationBinding.authServerName.setText(this.arizonaServers.get(Integer.valueOf(Integer.parseInt(data))));
                } else if (isArizonaType) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    installServerLogotype(Integer.parseInt(data), this.rodinaLogotypeUri);
                    this.authorizationBinding.authServerName.setText(this.rodinaServers.get(Integer.valueOf(Integer.parseInt(data))));
                }
            } else if (i == RegistrationInterfaceType.AUTH_SERVER_ONLINE_INFO.getId()) {
                this.authorizationBinding.authOnlineCount.setText(data);
            } else if (i == RegistrationInterfaceType.AUTH_SERVER_SUCCESS.getId()) {
                CountDownTimer countDownTimer = null;
                if (this.timer != null) {
                    resetLoginText();
                    CountDownTimer countDownTimer2 = this.timer;
                    if (countDownTimer2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("timer");
                        countDownTimer2 = null;
                    }
                    countDownTimer2.cancel();
                }
                if (Intrinsics.areEqual(data, "error")) {
                    disableLoginButton();
                    disableLoading();
                    enableError();
                    Activity activity = this.targetActivity;
                    Toast.makeText(activity, activity.getString(R.string.auth_invalid_credentials), 0).show();
                    new CountDownTimer() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization$onServerMessage$1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(5000L, 1000L);
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            Authorization.this.isLoginError = false;
                            Authorization.this.enableLoginButton();
                            Authorization.this.disableError();
                            cancel();
                        }
                    }.start();
                }
                if (Intrinsics.areEqual(data, "user_not_found")) {
                    if (this.timer != null) {
                        resetLoginText();
                        CountDownTimer countDownTimer3 = this.timer;
                        if (countDownTimer3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("timer");
                            countDownTimer3 = null;
                        }
                        countDownTimer3.cancel();
                    }
                    disableLoading();
                    enableError();
                    Activity activity2 = this.targetActivity;
                    Toast.makeText(activity2, activity2.getString(R.string.auth_account_not_registered), 0).show();
                }
                if (Intrinsics.areEqual(data, "loading")) {
                    if (this.timer != null) {
                        resetLoginText();
                        CountDownTimer countDownTimer4 = this.timer;
                        if (countDownTimer4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("timer");
                            countDownTimer4 = null;
                        }
                        countDownTimer4.cancel();
                    }
                    this.authorizationBinding.loaderContainer.setVisibility(0);
                    this.authorizationBinding.loaderContainer.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization$$ExternalSyntheticLambda3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            Authorization.onServerMessage$lambda$0(Authorization.this, view);
                        }
                    });
                    int length = this.authorizationBinding.authSurnameEdit.getText().toString().length();
                    AuthorizationBinding authorizationBinding = this.authorizationBinding;
                    if (length > 0) {
                        obj2 = StringsKt.trim((CharSequence) (((Object) authorizationBinding.authUsernameEdit.getText()) + "_" + ((Object) this.authorizationBinding.authSurnameEdit.getText()))).toString();
                    } else {
                        obj2 = StringsKt.trim((CharSequence) authorizationBinding.authUsernameEdit.getText().toString()).toString();
                    }
                    addRegData(obj2, this.authorizationBinding.authPasswordEdit.getText().toString(), this.rememberMe);
                }
                if (Intrinsics.areEqual(data, "spawn")) {
                    if (this.timer != null) {
                        resetLoginText();
                        CountDownTimer countDownTimer5 = this.timer;
                        if (countDownTimer5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("timer");
                            countDownTimer5 = null;
                        }
                        countDownTimer5.cancel();
                    }
                    disableLoading();
                    disableError();
                    InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.SPAWN_SELECTOR.getId(), this.targetActivity, this.backendID);
                    Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.SpawnMenu");
                    setVisible(false);
                    ((SpawnMenu) orCreateInterface).setVisible(true);
                }
                if (Intrinsics.areEqual(data, FirebaseAnalytics.Param.SUCCESS)) {
                    if (this.timer != null) {
                        resetLoginText();
                        CountDownTimer countDownTimer6 = this.timer;
                        if (countDownTimer6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("timer");
                            countDownTimer6 = null;
                        }
                        countDownTimer6.cancel();
                    }
                    disableLoading();
                    disableError();
                    int length2 = this.authorizationBinding.authSurnameEdit.getText().toString().length();
                    AuthorizationBinding authorizationBinding2 = this.authorizationBinding;
                    if (length2 > 0) {
                        obj = StringsKt.trim((CharSequence) (((Object) authorizationBinding2.authUsernameEdit.getText()) + "_" + ((Object) this.authorizationBinding.authSurnameEdit.getText()))).toString();
                    } else {
                        obj = StringsKt.trim((CharSequence) authorizationBinding2.authUsernameEdit.getText().toString()).toString();
                    }
                    String obj3 = this.authorizationBinding.authPasswordEdit.getText().toString();
                    if (obj.length() == 0 || obj3.length() == 0) {
                        RegistrationAccount.ContainerData userAuthData = getUserAuthData();
                        obj = String.valueOf(userAuthData != null ? userAuthData.getUsername() : null);
                        RegistrationAccount.ContainerData userAuthData2 = getUserAuthData();
                        obj3 = String.valueOf(userAuthData2 != null ? userAuthData2.getPassword() : null);
                    }
                    RegistrationAccount.ContainerData userAuthData3 = getUserAuthData();
                    if (!Intrinsics.areEqual(obj, String.valueOf(userAuthData3 != null ? userAuthData3.getUsername() : null)) && !getRegisteredState()) {
                        addRegData(obj, obj3, this.rememberMe);
                    }
                    InterfaceController orCreateInterface2 = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.VIDEO_BACKGROUND.getId(), this.targetActivity, this.backendID);
                    Intrinsics.checkNotNull(orCreateInterface2, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationVideoBackground");
                    RegistrationVideoBackground registrationVideoBackground = (RegistrationVideoBackground) orCreateInterface2;
                    registrationVideoBackground.selectVideoMode(RegistrationVideoModeType.VIDEO_HIDE);
                    registrationVideoBackground.setVisibility(false);
                    setRegisteredState();
                    setVisible(false);
                }
                if (Intrinsics.areEqual(data, "user_already_game")) {
                    if (this.timer != null) {
                        resetLoginText();
                        CountDownTimer countDownTimer7 = this.timer;
                        if (countDownTimer7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("timer");
                        } else {
                            countDownTimer = countDownTimer7;
                        }
                        countDownTimer.cancel();
                    }
                    disableLoading();
                    enableError();
                    this.authorizationBinding.authUsernameError.setVisibility(0);
                    this.authorizationBinding.authSurnameError.setVisibility(0);
                    this.isLoginError = true;
                    disableLoginButton();
                    new CountDownTimer() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization$onServerMessage$3
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(2000L, 1000L);
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            Authorization.this.isLoginError = false;
                            Authorization.this.enableLoginButton();
                            cancel();
                        }
                    }.start();
                    Toast.makeText(this.targetActivity.getApplicationContext(), this.targetActivity.getString(R.string.auth_player_already_in_game), 0).show();
                }
            } else {
                Log.w(TAG, "Действие неопределено. Неопознаный ID.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onServerMessage$lambda$0(Authorization authorization, View view) {
        Activity activity = authorization.targetActivity;
        Toast.makeText(activity, activity.getString(R.string.loading), 0).show();
    }

    private final String getPassword() {
        RegistrationAccount.ContainerData userAuthData = getUserAuthData();
        if (userAuthData != null) {
            return userAuthData.getPassword();
        }
        return null;
    }

    private final void checkBoxEnabled() {
        this.authorizationBinding.authRememberCheckbox.setBackgroundResource(R.drawable.authorization_border_red);
        this.authorizationBinding.authRememberCheckboxMark.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetLoginText() {
        this.authorizationBinding.authLoginText.setText(this.targetActivity.getString(R.string.sign_in));
    }

    private final void checkboxDisable() {
        this.authorizationBinding.authRememberCheckbox.setBackgroundResource(R.drawable.authorization_border);
        this.authorizationBinding.authRememberCheckboxMark.setVisibility(4);
    }

    private final void enableError() {
        this.authorizationBinding.authPasswordError.setVisibility(0);
        this.authorizationBinding.authUsernameError.setVisibility(0);
        this.authorizationBinding.authSurnameError.setVisibility(0);
        this.isLoginError = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disableError() {
        this.authorizationBinding.authPasswordError.setVisibility(4);
        this.authorizationBinding.authUsernameError.setVisibility(4);
        this.authorizationBinding.authSurnameError.setVisibility(4);
        this.isLoginError = false;
    }

    private final void disableLoading() {
        this.authorizationBinding.loaderContainer.setVisibility(8);
        this.authorizationBinding.loaderContainer.setOnClickListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enableLoginButton() {
        this.authorizationBinding.authLoginButton.setBackgroundResource(R.drawable.authorization_border_red);
    }

    private final void disableLoginButton() {
        this.authorizationBinding.authLoginButton.setBackgroundResource(R.drawable.authorization_border);
    }

    private final void installServerLogotype(int i, String str) {
        Picasso.get().load(str + i + ".webp").placeholder(R.drawable.logo_phoenix).into(this.authorizationBinding.authServerLogotype);
    }

    private final void setLocalPassword(String str) {
        this.localPassword = str;
    }

    private final String getLocalPassword() {
        return this.localPassword;
    }

    private final void setLocalUsername(String str) {
        this.localUsername = str;
    }

    private final String getLocalUsername() {
        return this.localUsername;
    }

    private final String getUsername() {
        RegistrationAccount.ContainerData userAuthData = getUserAuthData();
        if (userAuthData != null) {
            return userAuthData.getUsername();
        }
        return null;
    }

    private final String getServerId() {
        return this.sharedPreferences.getString(SERVER_ID, "");
    }

    public final void hideLoader() {
        this.authorizationBinding.loaderContainer.setVisibility(8);
    }

    /* compiled from: Authorization.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/screen/Authorization$Companion;", "", "<init>", "()V", Authorization.REGDATA, "", "SP_NAME", Authorization.SERVER_ID, Authorization.NEW_ACCOUNT, "TAG", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        int i;
        ConstraintLayout constraintLayout = this.authorizationBinding.auth;
        if (z) {
            restoreSavedCreds();
            i = 0;
        } else {
            i = 8;
        }
        constraintLayout.setVisibility(i);
    }

    private final void setRegisteredState() {
        this.sharedPreferences.edit().putBoolean(NEW_ACCOUNT, false).apply();
    }

    private final boolean getRegisteredState() {
        return this.sharedPreferences.getBoolean(NEW_ACCOUNT, false);
    }

    private final void setRegistrationWindow() {
        InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.VIDEO_BACKGROUND.getId(), this.targetActivity, this.backendID);
        Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationVideoBackground");
        InterfaceController orCreateInterface2 = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.REGISTRATION_INIT.getId(), this.targetActivity, this.backendID);
        Intrinsics.checkNotNull(orCreateInterface2, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationAccount");
        InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.AUTHORIZATION_NEWS.getId(), this.targetActivity, this.backendID).setVisible(false);
        ((RegistrationVideoBackground) orCreateInterface).selectVideoMode(RegistrationVideoModeType.VIDEO_REGISTRATION);
        ((RegistrationAccount) orCreateInterface2).setVisible(true);
    }

    private final void addRegData(String str, String str2, boolean z) {
        String string = this.sharedPreferences.getString(REGDATA, new JSONObject().toString());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str3 = string;
        if (str3 != null && str3.length() != 0) {
            Map map = (Map) new Gson().fromJson(string, new TypeToken<Map<String, ? extends RegistrationAccount.ContainerData>>() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization$addRegData$type$1
            }.getType());
            Intrinsics.checkNotNull(map);
            linkedHashMap.putAll(map);
            linkedHashMap.put(String.valueOf(getServerId()), new RegistrationAccount.ContainerData(str, str2, z));
        } else {
            linkedHashMap.put(String.valueOf(getServerId()), new RegistrationAccount.ContainerData(str, str2, z));
        }
        this.sharedPreferences.edit().putString(REGDATA, new Gson().toJson(linkedHashMap)).apply();
    }

    private final RegistrationAccount.ContainerData getUserAuthData() {
        Map map = (Map) new Gson().fromJson(this.sharedPreferences.getString(REGDATA, new JSONObject().toString()), new TypeToken<Map<String, ? extends RegistrationAccount.ContainerData>>() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.Authorization$getUserAuthData$type$1
        }.getType());
        Intrinsics.checkNotNull(map);
        return (RegistrationAccount.ContainerData) map.get(getServerId());
    }
}
