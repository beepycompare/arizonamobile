package ru.mrlargha.arizonaui.mobile.presentation;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import androidx.compose.material3.internal.CalendarModelKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.adjust.sdk.Constants;
import com.google.firebase.messaging.Constants;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MobilePhoneBinding;
import ru.mrlargha.arizonaui.mobile.domain.enums.MobilePhonePage;
import ru.mrlargha.arizonaui.mobile.domain.enums.MobilePhoneScreenIds;
import ru.mrlargha.arizonaui.mobile.domain.enums.UberPriority;
import ru.mrlargha.arizonaui.mobile.domain.obj.CallStatus;
import ru.mrlargha.arizonaui.mobile.domain.obj.CatchAppInfo;
import ru.mrlargha.arizonaui.mobile.domain.obj.ChangeArtistNameRadioRequest;
import ru.mrlargha.arizonaui.mobile.domain.obj.DriverInfo;
import ru.mrlargha.arizonaui.mobile.domain.obj.MobilePhoneAvailableCar;
import ru.mrlargha.arizonaui.mobile.domain.obj.MobilePhoneDriverOrder;
import ru.mrlargha.arizonaui.mobile.domain.obj.MobilePhoneDriverWorkInfo;
import ru.mrlargha.arizonaui.mobile.domain.obj.MobilePhoneRentInfo;
import ru.mrlargha.arizonaui.mobile.domain.obj.UserNumber;
import ru.mrlargha.arizonaui.mobile.presentation.page.call.CallReceive;
import ru.mrlargha.arizonaui.mobile.presentation.page.call.CallTalk;
import ru.mrlargha.arizonaui.mobile.presentation.page.carsharing.CarSharingCars;
import ru.mrlargha.arizonaui.mobile.presentation.page.carsharing.CarSharingMain;
import ru.mrlargha.arizonaui.mobile.presentation.page.carsharing.CarSharingRented;
import ru.mrlargha.arizonaui.mobile.presentation.page.catch_app.CatchApp;
import ru.mrlargha.arizonaui.mobile.presentation.page.driver.DriverOrder;
import ru.mrlargha.arizonaui.mobile.presentation.page.driver.DriverOrders;
import ru.mrlargha.arizonaui.mobile.presentation.page.messenger.Messenger;
import ru.mrlargha.arizonaui.mobile.presentation.page.messenger.MessengerChat;
import ru.mrlargha.arizonaui.mobile.presentation.page.messenger.api.MessengerRetrofitClient;
import ru.mrlargha.arizonaui.mobile.presentation.page.messenger.api.obj.ContactApiResponse;
import ru.mrlargha.arizonaui.mobile.presentation.page.messenger.api.obj.ContactModel;
import ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage;
import ru.mrlargha.arizonaui.mobile.presentation.page.uber.UberOrder;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.utils.ConverterKt;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: MobilePhone.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b/\u0018\u00002\u00020\u00012\u00020\u0002:\u0001{B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010!\u001a\u00020\nH\u0002J\b\u0010\"\u001a\u00020\nH\u0002J\b\u0010#\u001a\u00020\nH\u0002J\u0010\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u0013H\u0002J\u0010\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0013H\u0002J\u0010\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u0013H\u0002J\u0006\u0010*\u001a\u00020\u0013J\u0006\u0010+\u001a\u00020\u0013J\u0010\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u0013H\u0002J\u0010\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u0013H\u0002J\u0010\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u0013H\u0002J\u0010\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\u0013H\u0002J\u0010\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\u0013H\u0002J\b\u00106\u001a\u00020\nH\u0002J\u0010\u00107\u001a\u00020\n2\u0006\u00103\u001a\u00020\u0013H\u0002J\u0010\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\u0013H\u0002J\b\u0010:\u001a\u00020\nH\u0002J\b\u0010;\u001a\u00020\nH\u0002J\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020\u0004J\u0006\u0010@\u001a\u00020\u0017J\u000e\u0010G\u001a\u00020\n2\u0006\u0010H\u001a\u00020DJ\u0016\u0010I\u001a\u0012\u0012\u0004\u0012\u00020D0Cj\b\u0012\u0004\u0012\u00020D`EJ\u000e\u0010N\u001a\u00020\n2\u0006\u0010O\u001a\u00020\u0013J\u000e\u0010P\u001a\u00020\n2\u0006\u0010<\u001a\u00020\u0006J\u000e\u0010Q\u001a\u00020\n2\u0006\u0010R\u001a\u00020\u0006J\u000e\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020\u0006J\u0006\u0010U\u001a\u00020\u0006J\u000e\u0010V\u001a\u00020\n2\u0006\u0010W\u001a\u00020\u0013J\u0010\u0010X\u001a\u00020\n2\u0006\u0010Y\u001a\u00020\u0013H\u0002J\u0010\u0010Z\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0013H\u0002J\u0010\u0010[\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u0013H\u0002J\u0010\u0010]\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u0013H\u0002J\u0010\u0010^\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u0013H\u0002J\u0010\u0010_\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u0013H\u0002J\b\u0010`\u001a\u00020\nH\u0002J\u0010\u0010a\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u0013H\u0002J\u0010\u0010b\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u0013H\u0002J\u0010\u0010c\u001a\u00020\u00132\u0006\u0010R\u001a\u00020\u0006H\u0002J\u0006\u0010d\u001a\u00020\nJ\u0018\u0010e\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u00132\u0006\u0010f\u001a\u00020\u0006H\u0016J\u0010\u0010g\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u0013H\u0002J\u0010\u0010h\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u0013H\u0002J\u0010\u0010i\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u0013H\u0002J\u0010\u0010j\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u0013H\u0002J\u0010\u0010k\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u0013H\u0002J\u0010\u0010l\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u0013H\u0002J\u0010\u0010m\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u0013H\u0002J\u0010\u0010n\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u0013H\u0002J\u0010\u0010o\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u0013H\u0002J\u0010\u0010p\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u0013H\u0002J\u0010\u0010q\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u0013H\u0002J\u0010\u0010r\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u0013H\u0002J\u0010\u0010s\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u0013H\u0002J\u0010\u0010t\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\u0013H\u0002J\u0010\u0010u\u001a\u00020\n2\u0006\u0010v\u001a\u00020\u0006H\u0002J\u0010\u0010w\u001a\u00020\n2\u0006\u0010x\u001a\u00020\u0006H\u0002J\b\u0010y\u001a\u00020\nH\u0016J\b\u0010z\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010<\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010A\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010B\u001a\u0012\u0012\u0004\u0012\u00020D0Cj\b\u0012\u0004\u0012\u00020D`EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00060\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010K\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060M0LX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006|"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/MobilePhone;", "Lru/mrlargha/arizonaui/mobile/presentation/MobileController;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "activity", "Landroid/app/Activity;", "backendId", "", "<init>", "(Landroid/app/Activity;I)V", "setVisibility", "", "visible", "", "phoneIsOpen", "sendFrontedMessage", "Lru/mrlargha/commonui/core/IBackendNotifier;", "timer", "Landroid/os/CountDownTimer;", "phoneModel", "", "mobilePhone", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mobilePhoneBinding", "Lru/mrlargha/arizonaui/databinding/MobilePhoneBinding;", "sharedPreferencesMessengerToken", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "pageBg", "", "callStatus", "Ljava/lang/Integer;", "callCompanionName", "callCompanionNumber", "renderTaxiSearch", "closeOrder", "sendOrderStatus", "sendPriority", "priority", "sendDriverInfo", "driverInfo", "sendTaxiStatus", NotificationCompat.CATEGORY_STATUS, "getCompanionName", "getCompanionNumber", "setCompanionName", "name", "setCompanionNumber", "number", "setWorkingButton", "workingButton", "setWorkingInfo", "workInfo", "addWorkingList", "workList", "clearTaxiOrders", "renderDriverOrder", "setGreenButtonText", "text", "clearDriverOrders", "closeDriverMenu", "backgroundId", "getBackground", "Landroid/graphics/drawable/Drawable;", "getContext", "getBinding", "arizonaMobilBalance", "availableCars", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/mobile/domain/obj/MobilePhoneAvailableCar;", "Lkotlin/collections/ArrayList;", "currentCar", "setAvailableCar", "car", "getAvailableCars", "cases", "phoneCaseSize", "", "Lkotlin/Pair;", "setServerName", "serverName", "setScreenBackgroundId", "setCaseId", "caseId", "setArizonaMobilBalance", "balance", "getArizonaMobilBalance", "setRentedInfo", "rentInfo", "addAvailableCars", "cars", "setCallStatus", "playTrackFromServer", "data", "initFavourite", "addToFavourite", "removeFromFavourite", "openSpotify", "changeArtistNameRadio", "setCatchAppInfo", "phoneCaseIdentifier", "closePhone", "onBackendMessage", "subId", "openMessengerChat", "updateDialog", "newMessage", "callContactStatus", "removeMessageStatus", "notifyContactStatus", "clearMessagesStatus", "pinContactStatus", "blockContactStatus", "addContactStatus", "removeContactStatus", "sendMessageSuccess", "setMessengerToken", "contactSettingsUpdate", "showScreenByID", "id", "sendRequest", "position", "renderPage", "removePage", "Spawner", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobilePhone extends SAMPUIElement implements MobileController {
    private final Activity activity;
    private int arizonaMobilBalance;
    private final ArrayList<MobilePhoneAvailableCar> availableCars;
    private Integer backgroundId;
    private String callCompanionName;
    private String callCompanionNumber;
    private Integer callStatus;
    private final List<Integer> cases;
    private MobilePhoneAvailableCar currentCar;
    private final ConstraintLayout mobilePhone;
    private final MobilePhoneBinding mobilePhoneBinding;
    private final List<Integer> pageBg;
    private final Map<String, Pair<Integer, Integer>> phoneCaseSize;
    private boolean phoneIsOpen;
    private String phoneModel;
    private final IBackendNotifier sendFrontedMessage;
    private final SharedPreferences sharedPreferencesMessengerToken;
    private CountDownTimer timer;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$7(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$8(View view) {
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void renderPage() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v6, types: [ru.mrlargha.arizonaui.mobile.presentation.MobilePhone$1] */
    public MobilePhone(Activity activity, int i) {
        super(activity, i);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type ru.mrlargha.commonui.core.IBackendNotifier");
        this.sendFrontedMessage = (IBackendNotifier) activity;
        this.phoneModel = "";
        View inflate = activity.getLayoutInflater().inflate(R.layout.mobile_phone, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.mobilePhone = constraintLayout;
        MobilePhoneBinding bind = MobilePhoneBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.mobilePhoneBinding = bind;
        this.sharedPreferencesMessengerToken = activity.getSharedPreferences(Messenger.MESSENGER_PREFS, 0);
        this.pageBg = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.phone_bg_1), Integer.valueOf(R.drawable.phone_bg_2), Integer.valueOf(R.drawable.phone_bg_3), Integer.valueOf(R.drawable.phone_bg_4), Integer.valueOf(R.drawable.phone_bg_5), Integer.valueOf(R.drawable.phone_bg_6), Integer.valueOf(R.drawable.phone_bg_7), Integer.valueOf(R.drawable.phone_bg_8), Integer.valueOf(R.drawable.phone_bg_9), Integer.valueOf(R.drawable.phone_bg_11), Integer.valueOf(R.drawable.phone_bg_11), Integer.valueOf(R.drawable.phone_bg_12), Integer.valueOf(R.drawable.phone_bg_13), Integer.valueOf(R.drawable.phone_bg_14), Integer.valueOf(R.drawable.phone_bg_15), Integer.valueOf(R.drawable.phone_bg_16), Integer.valueOf(R.drawable.phone_bg_17), Integer.valueOf(R.drawable.phone_bg_18), Integer.valueOf(R.drawable.phone_bg_19), Integer.valueOf(R.drawable.phone_bg_20), Integer.valueOf(R.drawable.phone_bg_21), Integer.valueOf(R.drawable.phone_bg_22), Integer.valueOf(R.drawable.phone_bg_23), Integer.valueOf(R.drawable.phone_bg_24), Integer.valueOf(R.drawable.phone_bg_25), Integer.valueOf(R.drawable.phone_bg_26), Integer.valueOf(R.drawable.phone_bg_27), Integer.valueOf(R.drawable.phone_bg_28), Integer.valueOf(R.drawable.phone_bg_29), Integer.valueOf(R.drawable.phone_bg_30), Integer.valueOf(R.drawable.phone_bg_31), Integer.valueOf(R.drawable.phone_bg_32), Integer.valueOf(R.drawable.phone_bg_33), Integer.valueOf(R.drawable.phone_bg_34), Integer.valueOf(R.drawable.phone_bg_35), Integer.valueOf(R.drawable.phone_bg_36), Integer.valueOf(R.drawable.phone_bg_37), Integer.valueOf(R.drawable.phone_bg_38), Integer.valueOf(R.drawable.phone_bg_39), Integer.valueOf(R.drawable.phone_bg_40)});
        this.callCompanionName = "";
        this.callCompanionNumber = "";
        this.availableCars = new ArrayList<>();
        this.cases = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.border_a_2), Integer.valueOf(R.drawable.border_a_1), Integer.valueOf(R.drawable.border_a_7), Integer.valueOf(R.drawable.border_a_3), Integer.valueOf(R.drawable.border_a_9), Integer.valueOf(R.drawable.border_a_4), Integer.valueOf(R.drawable.border_a_5), Integer.valueOf(R.drawable.border_a_6), Integer.valueOf(R.drawable.border_a_7), Integer.valueOf(R.drawable.border_a_8), Integer.valueOf(R.drawable.border_a_9), Integer.valueOf(R.drawable.border_b_1), Integer.valueOf(R.drawable.border_b_2), Integer.valueOf(R.drawable.border_b_3), Integer.valueOf(R.drawable.border_b_4), Integer.valueOf(R.drawable.border_b_5), Integer.valueOf(R.drawable.border_b_6), Integer.valueOf(R.drawable.border_b_7), Integer.valueOf(R.drawable.border_b_8), Integer.valueOf(R.drawable.border_b_9), Integer.valueOf(R.drawable.border_b_10), Integer.valueOf(R.drawable.border_b_5), Integer.valueOf(R.drawable.border_c_1), Integer.valueOf(R.drawable.border_c_2), Integer.valueOf(R.drawable.border_c_3), Integer.valueOf(R.drawable.border_c_4), Integer.valueOf(R.drawable.border_c_5), Integer.valueOf(R.drawable.border_c_6), Integer.valueOf(R.drawable.border_c_7), Integer.valueOf(R.drawable.border_c_8), Integer.valueOf(R.drawable.border_c_9), Integer.valueOf(R.drawable.border_c_9), Integer.valueOf(R.drawable.border_c_5), Integer.valueOf(R.drawable.border_d_1), Integer.valueOf(R.drawable.border_d_2), Integer.valueOf(R.drawable.border_d_3), Integer.valueOf(R.drawable.border_d_4), Integer.valueOf(R.drawable.border_d_5), Integer.valueOf(R.drawable.border_d_6), Integer.valueOf(R.drawable.border_d_7), Integer.valueOf(R.drawable.border_d_8), Integer.valueOf(R.drawable.border_d_9), Integer.valueOf(R.drawable.border_d_9), Integer.valueOf(R.drawable.border_d_5), Integer.valueOf(R.drawable.border_e_1), Integer.valueOf(R.drawable.border_e_2), Integer.valueOf(R.drawable.border_e_3), Integer.valueOf(R.drawable.border_e_4), Integer.valueOf(R.drawable.border_e_5), Integer.valueOf(R.drawable.border_e_6), Integer.valueOf(R.drawable.border_e_7), Integer.valueOf(R.drawable.border_e_8), Integer.valueOf(R.drawable.border_e_9), Integer.valueOf(R.drawable.border_e_9), Integer.valueOf(R.drawable.border_e_5)});
        this.phoneCaseSize = MapsKt.mapOf(TuplesKt.to(Constants.REFERRER_API_XIAOMI, new Pair(174, 300)), TuplesKt.to("huawei", new Pair(174, 300)), TuplesKt.to(Constants.REFERRER_API_GOOGLE, new Pair(174, 300)), TuplesKt.to(Constants.REFERRER_API_SAMSUNG, new Pair(174, 300)), TuplesKt.to("iphone", new Pair(174, 300)));
        addViewToConstraintLayout(constraintLayout, -1, -1);
        setVisibility(false);
        Animation loadAnimation = AnimationUtils.loadAnimation(activity, R.anim.slide);
        constraintLayout.startAnimation(loadAnimation);
        constraintLayout.startAnimation(loadAnimation);
        HistoryManager.Companion.putPage(MobilePhonePage.MOBILE_PHONE_PAGE.getId(), this);
        HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MAIN_PAGE.getId());
        bind.phoneTopBarTime.setText(new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date()));
        CountDownTimer start = new CountDownTimer(CalendarModelKt.MillisecondsIn24Hours, 60000L) { // from class: ru.mrlargha.arizonaui.mobile.presentation.MobilePhone.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                this.mobilePhoneBinding.phoneTopBarTime.setText(new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date()));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                cancel();
            }
        }.start();
        Intrinsics.checkNotNullExpressionValue(start, "start(...)");
        this.timer = start;
        bind.mpActionBackButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.MobilePhone$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobilePhone._init_$lambda$5(view);
            }
        });
        bind.mpActionCloseButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.MobilePhone$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobilePhone._init_$lambda$6(MobilePhone.this, view);
            }
        });
        bind.phoneCaseContainer.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.MobilePhone$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobilePhone._init_$lambda$7(view);
            }
        });
        bind.phoneBackground.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.MobilePhone$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobilePhone._init_$lambda$8(view);
            }
        });
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public synchronized void setVisibility(boolean z) {
        this.phoneIsOpen = z;
        if (!z && !HistoryManager.Companion.getHistoryManager().isEmpty()) {
            MobileController pageIfExist = HistoryManager.Companion.getPageIfExist(MobilePhonePage.MESSENGER_CHAT.getId());
            if (pageIfExist != null) {
                pageIfExist.removePage();
            }
            Integer history = HistoryManager.Companion.getHistory();
            if (history != null) {
                MobileController pageIfExist2 = HistoryManager.Companion.getPageIfExist(history.intValue());
                if (pageIfExist2 != null) {
                    pageIfExist2.removePage();
                }
            }
            Integer history2 = HistoryManager.Companion.getHistory();
            if (history2 != null) {
                HistoryManager.Companion.clearHistoryByKey(history2.intValue());
            }
            HistoryManager.Companion.getOrCreatePage(0);
        }
        super.setVisibility(z);
    }

    private final void renderTaxiSearch() {
        MobileController pageIfExist = HistoryManager.Companion.getPageIfExist(MobilePhonePage.UBER_CHOSE_TAXI.getId());
        if (pageIfExist != null) {
            pageIfExist.removePage();
        }
        HistoryManager.Companion.getOrCreatePage(MobilePhonePage.UBER_ORDER.getId());
    }

    private final void closeOrder() {
        if (this.phoneIsOpen) {
            MobileController pageIfExist = HistoryManager.Companion.getPageIfExist(MobilePhonePage.UBER_ORDER.getId());
            if (pageIfExist != null) {
                pageIfExist.removePage();
            }
            MobileController pageIfExist2 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.UBER_CHOSE_TAXI.getId());
            if (pageIfExist2 != null) {
                pageIfExist2.removePage();
            }
            HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MAIN_PAGE.getId());
        }
    }

    private final void sendOrderStatus() {
        if (this.phoneIsOpen) {
            Integer history = HistoryManager.Companion.getHistory();
            if (history != null) {
                MobileController pageIfExist = HistoryManager.Companion.getPageIfExist(history.intValue());
                if (pageIfExist != null) {
                    pageIfExist.removePage();
                }
            }
            Integer history2 = HistoryManager.Companion.getHistory();
            if (history2 != null) {
                HistoryManager.Companion.clearHistoryByKey(history2.intValue());
            }
            MobileController pageIfExist2 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.UBER_PREVIEW.getId());
            if (pageIfExist2 != null) {
                pageIfExist2.removePage();
            }
            MobileController pageIfExist3 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.UBER_CHOSE_TAXI.getId());
            if (pageIfExist3 != null) {
                pageIfExist3.removePage();
            }
            MobileController pageIfExist4 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.UBER_ORDER.getId());
            if (pageIfExist4 != null) {
                pageIfExist4.removePage();
            }
            HistoryManager.Companion.getOrCreatePage(MobilePhonePage.UBER_ORDER.getId());
        }
    }

    private final void sendPriority(String str) {
        if (this.phoneIsOpen) {
            MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.UBER_ORDER.getId());
            Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.uber.UberOrder");
            ((UberOrder) orCreatePage).sendPriority(UberPriority.Companion.fromInt(Integer.parseInt(str)));
        }
    }

    private final void sendDriverInfo(String str) {
        if (this.phoneIsOpen) {
            try {
                MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.UBER_ORDER.getId());
                Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.uber.UberOrder");
                ((UberOrder) orCreatePage).sendDriverInfo((DriverInfo) MapperKt.toModel(str, DriverInfo.class));
            } catch (Exception unused) {
                System.out.println((Object) "Не удалось распарсить информацию о водителе");
            }
        }
    }

    private final void sendTaxiStatus(String str) {
        if (this.phoneIsOpen) {
            Log.d("uber", "openUberOrder");
            MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.UBER_ORDER.getId());
            Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.uber.UberOrder");
            ((UberOrder) orCreatePage).updateStatus(str);
        }
    }

    public final String getCompanionName() {
        return this.callCompanionName;
    }

    public final String getCompanionNumber() {
        return this.callCompanionNumber;
    }

    private final void setCompanionName(String str) {
        this.callCompanionName = str;
        Integer num = this.callStatus;
        if (num != null && num.intValue() == 0) {
            MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.CALL_TALK_PAGE.getId());
            Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.call.CallTalk");
            ((CallTalk) orCreatePage).setCompanionName(str);
        } else if (num != null && num.intValue() == 1) {
            MobileController orCreatePage2 = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.CALL_RECEIVE_PAGE.getId());
            Intrinsics.checkNotNull(orCreatePage2, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.call.CallReceive");
            ((CallReceive) orCreatePage2).setCompanionName(str);
        }
    }

    private final void setCompanionNumber(String str) {
        this.callCompanionNumber = str;
        Integer num = this.callStatus;
        if (num != null && num.intValue() == 0) {
            MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.CALL_TALK_PAGE.getId());
            Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.call.CallTalk");
            ((CallTalk) orCreatePage).setCompanionNumber(str);
        } else if (num != null && num.intValue() == 1) {
            MobileController orCreatePage2 = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.CALL_RECEIVE_PAGE.getId());
            Intrinsics.checkNotNull(orCreatePage2, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.call.CallReceive");
            ((CallReceive) orCreatePage2).setCompanionNumber(str);
        }
    }

    private final void setWorkingButton(String str) {
        MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.DRIVER_ORDERS.getId());
        Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.driver.DriverOrders");
        ((DriverOrders) orCreatePage).setWorkingButton(str);
    }

    private final void setWorkingInfo(String str) {
        try {
            MobilePhoneDriverWorkInfo mobilePhoneDriverWorkInfo = (MobilePhoneDriverWorkInfo) MapperKt.toModel(str, MobilePhoneDriverWorkInfo.class);
            MobileController pageIfExist = HistoryManager.Companion.getPageIfExist(MobilePhonePage.MAIN_PAGE.getId());
            if (pageIfExist != null) {
                pageIfExist.removePage();
            }
            MobileController pageIfExist2 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.DRIVER_ORDERS.getId());
            if (pageIfExist2 != null) {
                pageIfExist2.removePage();
            }
            MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.DRIVER_ORDERS.getId());
            Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.driver.DriverOrders");
            ((DriverOrders) orCreatePage).setWorkingInfo(mobilePhoneDriverWorkInfo);
        } catch (Exception unused) {
            System.out.println((Object) "Ошибка при парсинге информации о заказе");
        }
    }

    private final void addWorkingList(String str) {
        try {
            List<MobilePhoneDriverOrder> listModel = MapperKt.toListModel(str, MobilePhoneDriverOrder.class);
            MobileController pageIfExist = HistoryManager.Companion.getPageIfExist(MobilePhonePage.MAIN_PAGE.getId());
            if (pageIfExist != null) {
                pageIfExist.removePage();
            }
            MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.DRIVER_ORDERS.getId());
            Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.driver.DriverOrders");
            ((DriverOrders) orCreatePage).addOrders(listModel);
        } catch (Exception unused) {
            System.out.println((Object) "Ошибка при парсинге информации о заказе");
        }
    }

    private final void clearTaxiOrders() {
        try {
            MobileController pageIfExist = HistoryManager.Companion.getPageIfExist(MobilePhonePage.MAIN_PAGE.getId());
            if (pageIfExist != null) {
                pageIfExist.removePage();
            }
            MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.DRIVER_ORDERS.getId());
            Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.driver.DriverOrders");
            ((DriverOrders) orCreatePage).clearOrders();
        } catch (Exception unused) {
            System.out.println((Object) "Ошибка при удалении заказов");
        }
    }

    private final void renderDriverOrder(String str) {
        try {
            MobilePhoneDriverOrder mobilePhoneDriverOrder = (MobilePhoneDriverOrder) MapperKt.toModel(str, MobilePhoneDriverOrder.class);
            MobileController pageIfExist = HistoryManager.Companion.getPageIfExist(MobilePhonePage.MAIN_PAGE.getId());
            if (pageIfExist != null) {
                pageIfExist.removePage();
            }
            MobileController pageIfExist2 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.DRIVER_ORDERS.getId());
            if (pageIfExist2 != null) {
                pageIfExist2.removePage();
            }
            MobileController pageIfExist3 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.DRIVER_ORDER.getId());
            if (pageIfExist3 != null) {
                pageIfExist3.removePage();
            }
            MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.DRIVER_ORDER.getId());
            Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.driver.DriverOrder");
            ((DriverOrder) orCreatePage).updateOrderInfo(mobilePhoneDriverOrder);
        } catch (Exception unused) {
            System.out.println((Object) "Ошибка при парсинге информации о заказе");
        }
    }

    private final void setGreenButtonText(String str) {
        MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.DRIVER_ORDER.getId());
        Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.driver.DriverOrder");
        ((DriverOrder) orCreatePage).setGreenButtonText(str);
    }

    private final void clearDriverOrders() {
        MobileController pageIfExist = HistoryManager.Companion.getPageIfExist(MobilePhonePage.DRIVER_ORDER.getId());
        if (pageIfExist != null) {
            pageIfExist.removePage();
        }
        MobileController pageIfExist2 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.DRIVER_ORDERS.getId());
        if (pageIfExist2 != null) {
            pageIfExist2.removePage();
        }
        MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.DRIVER_ORDERS.getId());
        Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.driver.DriverOrders");
        DriverOrders driverOrders = (DriverOrders) orCreatePage;
    }

    private final void closeDriverMenu() {
        HistoryManager.Companion.clearAllHistory();
        MobileController pageIfExist = HistoryManager.Companion.getPageIfExist(MobilePhonePage.UBER_PREVIEW.getId());
        if (pageIfExist != null) {
            pageIfExist.removePage();
        }
        MobileController pageIfExist2 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.UBER_COMPLETE.getId());
        if (pageIfExist2 != null) {
            pageIfExist2.removePage();
        }
        MobileController pageIfExist3 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.UBER_ORDER.getId());
        if (pageIfExist3 != null) {
            pageIfExist3.removePage();
        }
        MobileController pageIfExist4 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.UBER_CHOSE_TAXI.getId());
        if (pageIfExist4 != null) {
            pageIfExist4.removePage();
        }
        MobileController pageIfExist5 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.DRIVER_ORDER.getId());
        if (pageIfExist5 != null) {
            pageIfExist5.removePage();
        }
        MobileController pageIfExist6 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.MAIN_PAGE.getId());
        if (pageIfExist6 != null) {
            pageIfExist6.removePage();
        }
        MobileController pageIfExist7 = HistoryManager.Companion.getPageIfExist(HistoryManager.Companion.getThisPageId());
        if (pageIfExist7 != null) {
            pageIfExist7.removePage();
        }
        HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MAIN_PAGE.getId());
    }

    public final Drawable getBackground() {
        Integer num = this.backgroundId;
        if (num != null) {
            Drawable drawable = ContextCompat.getDrawable(this.activity, this.pageBg.get(num.intValue()).intValue());
            if (drawable != null) {
                return drawable;
            }
        }
        Drawable drawable2 = ContextCompat.getDrawable(this.activity, R.drawable.phone_bg_1);
        Intrinsics.checkNotNull(drawable2);
        return drawable2;
    }

    public final Activity getContext() {
        return this.activity;
    }

    public final MobilePhoneBinding getBinding() {
        return this.mobilePhoneBinding;
    }

    public final void setAvailableCar(MobilePhoneAvailableCar car) {
        Intrinsics.checkNotNullParameter(car, "car");
        this.currentCar = car;
    }

    public final ArrayList<MobilePhoneAvailableCar> getAvailableCars() {
        return this.availableCars;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006f, code lost:
        if (r3.intValue() == ru.mrlargha.arizonaui.mobile.domain.enums.MobilePhonePage.MESSENGER_CHAT.getId()) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void _init_$lambda$5(View view) {
        Integer history = HistoryManager.Companion.getHistory();
        Log.e("phone", String.valueOf(history));
        if (history != null) {
            if (history.intValue() != MobilePhonePage.CALL_TALK_PAGE.getId()) {
                if (history.intValue() != MobilePhonePage.CALL_RECEIVE_PAGE.getId()) {
                    if (history.intValue() == MobilePhonePage.MAIN_PAGE.getId()) {
                        return;
                    }
                    if (history.intValue() == MobilePhonePage.CALL_TYPE_PAGE.getId()) {
                        HistoryManager.Companion.clearAllHistory();
                        HistoryManager.Companion.removeViewsPage(MobilePhonePage.CALL_TYPE_PAGE.getId());
                        HistoryManager.Companion.getOrCreatePage(0);
                    }
                    if (history.intValue() != MobilePhonePage.MESSENGER_APP.getId()) {
                    }
                    HistoryManager.Companion.clearAllHistory();
                    HistoryManager.Companion.removeViewsPage(MobilePhonePage.MESSENGER_APP.getId());
                    HistoryManager.Companion.removeViewsPage(MobilePhonePage.MESSENGER_CHAT.getId());
                    HistoryManager.Companion.getOrCreatePage(0);
                    if (history.intValue() != MobilePhonePage.DRIVER_ORDER.getId()) {
                        if (history.intValue() != MobilePhonePage.DRIVER_ORDERS.getId()) {
                            HistoryManager.Companion.previousPage();
                            return;
                        }
                    }
                    HistoryManager.Companion.clearAllHistory();
                    HistoryManager.Companion.removeViewsPage(MobilePhonePage.DRIVER_ORDER.getId());
                    HistoryManager.Companion.removeViewsPage(MobilePhonePage.DRIVER_ORDERS.getId());
                    HistoryManager.Companion.getOrCreatePage(0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$6(MobilePhone mobilePhone, View view) {
        HistoryManager.Companion.clearAllHistory();
        HistoryManager.Companion.removeViewsPage(MobilePhonePage.MESSENGER_APP.getId());
        HistoryManager.Companion.removeViewsPage(MobilePhonePage.MESSENGER_CHAT.getId());
        mobilePhone.closePhone();
    }

    public final void setServerName(String serverName) {
        Intrinsics.checkNotNullParameter(serverName, "serverName");
        this.mobilePhoneBinding.phoneNetworkName.setText(serverName);
    }

    public final void setScreenBackgroundId(int i) {
        this.backgroundId = Integer.valueOf(i);
        this.mobilePhoneBinding.phoneBackground.setBackground(ContextCompat.getDrawable(this.activity, this.pageBg.get(i).intValue()));
    }

    public final void setCaseId(int i) {
        String phoneCaseIdentifier = phoneCaseIdentifier(i);
        this.phoneModel = phoneCaseIdentifier;
        Pair<Integer, Integer> pair = this.phoneCaseSize.get(phoneCaseIdentifier);
        Intrinsics.checkNotNull(pair);
        Pair<Integer, Integer> pair2 = pair;
        int intValue = pair2.component1().intValue();
        int intValue2 = pair2.component2().intValue();
        if (Intrinsics.areEqual(this.phoneModel, Constants.REFERRER_API_XIAOMI)) {
            this.mobilePhoneBinding.phoneBackground.setLayoutParams(new ConstraintLayout.LayoutParams(ConverterKt.dpToPx(intValue, getTargetActivity()), ConverterKt.dpToPx(intValue2, getTargetActivity())));
            this.mobilePhoneBinding.phoneCaseContainer.setLayoutParams(new ConstraintLayout.LayoutParams(ConverterKt.dpToPx(intValue, getTargetActivity()), ConverterKt.dpToPx(intValue2 - 5, getTargetActivity())));
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this.mobilePhoneBinding.phoneContainer);
            constraintSet.connect(this.mobilePhoneBinding.phoneBackground.getId(), 1, this.mobilePhoneBinding.phoneContainer.getId(), 1);
            constraintSet.setMargin(this.mobilePhoneBinding.phoneBackground.getId(), 1, ConverterKt.dpToPx(13, this.activity));
            constraintSet.connect(this.mobilePhoneBinding.phoneBackground.getId(), 3, this.mobilePhoneBinding.phoneContainer.getId(), 3);
            constraintSet.connect(this.mobilePhoneBinding.phoneBackground.getId(), 4, this.mobilePhoneBinding.phoneContainer.getId(), 4);
            this.mobilePhoneBinding.phoneContainer.setConstraintSet(constraintSet);
            ConstraintSet constraintSet2 = new ConstraintSet();
            constraintSet2.clone(this.mobilePhoneBinding.phoneCase);
            constraintSet2.connect(this.mobilePhoneBinding.phoneCaseContainer.getId(), 1, this.mobilePhoneBinding.phoneCase.getId(), 1);
            constraintSet2.connect(this.mobilePhoneBinding.phoneCaseContainer.getId(), 3, this.mobilePhoneBinding.phoneCase.getId(), 3);
            constraintSet2.setMargin(this.mobilePhoneBinding.phoneCaseContainer.getId(), 1, ConverterKt.dpToPx(13, this.activity));
            constraintSet2.setMargin(this.mobilePhoneBinding.phoneCaseContainer.getId(), 3, ConverterKt.dpToPx(12, this.activity));
            this.mobilePhoneBinding.phoneCase.setConstraintSet(constraintSet2);
        } else {
            this.mobilePhoneBinding.phoneBackground.setLayoutParams(new ConstraintLayout.LayoutParams(ConverterKt.dpToPx(intValue, getTargetActivity()), ConverterKt.dpToPx(intValue2, getTargetActivity())));
            this.mobilePhoneBinding.phoneCaseContainer.setLayoutParams(new ConstraintLayout.LayoutParams(ConverterKt.dpToPx(intValue, getTargetActivity()), ConverterKt.dpToPx(intValue2 - 5, getTargetActivity())));
            ConstraintSet constraintSet3 = new ConstraintSet();
            constraintSet3.clone(this.mobilePhoneBinding.phoneContainer);
            constraintSet3.connect(this.mobilePhoneBinding.phoneBackground.getId(), 1, this.mobilePhoneBinding.phoneContainer.getId(), 1);
            constraintSet3.setMargin(this.mobilePhoneBinding.phoneBackground.getId(), 1, ConverterKt.dpToPx(9, this.activity));
            constraintSet3.connect(this.mobilePhoneBinding.phoneBackground.getId(), 3, this.mobilePhoneBinding.phoneContainer.getId(), 3);
            constraintSet3.connect(this.mobilePhoneBinding.phoneBackground.getId(), 4, this.mobilePhoneBinding.phoneContainer.getId(), 4);
            this.mobilePhoneBinding.phoneContainer.setConstraintSet(constraintSet3);
            ConstraintSet constraintSet4 = new ConstraintSet();
            constraintSet4.clone(this.mobilePhoneBinding.phoneCase);
            constraintSet4.connect(this.mobilePhoneBinding.phoneCaseContainer.getId(), 1, this.mobilePhoneBinding.phoneCase.getId(), 1);
            constraintSet4.connect(this.mobilePhoneBinding.phoneCaseContainer.getId(), 3, this.mobilePhoneBinding.phoneCase.getId(), 3);
            constraintSet4.setMargin(this.mobilePhoneBinding.phoneCaseContainer.getId(), 1, ConverterKt.dpToPx(9, this.activity));
            constraintSet4.setMargin(this.mobilePhoneBinding.phoneCaseContainer.getId(), 3, ConverterKt.dpToPx(14, this.activity));
            this.mobilePhoneBinding.phoneCase.setConstraintSet(constraintSet4);
        }
        ConstraintLayout constraintLayout = this.mobilePhoneBinding.phoneCase;
        Activity activity = this.activity;
        List<Integer> list = this.cases;
        constraintLayout.setBackground(ContextCompat.getDrawable(activity, ((i < 0 || i >= list.size()) ? Integer.valueOf(this.cases.get(0).intValue()) : list.get(i)).intValue()));
    }

    public final void setArizonaMobilBalance(int i) {
        this.arizonaMobilBalance = i;
        MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.ARIZONAMOBIL_MAIN.getId());
        Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.carsharing.CarSharingMain");
        ((CarSharingMain) orCreatePage).addBalance(i);
    }

    public final int getArizonaMobilBalance() {
        return this.arizonaMobilBalance;
    }

    public final void setRentedInfo(String rentInfo) {
        Intrinsics.checkNotNullParameter(rentInfo, "rentInfo");
        try {
            MobilePhoneRentInfo mobilePhoneRentInfo = (MobilePhoneRentInfo) MapperKt.toModel(rentInfo, MobilePhoneRentInfo.class);
            if (mobilePhoneRentInfo.getUnix() != -1) {
                MobileController pageIfExist = HistoryManager.Companion.getPageIfExist(MobilePhonePage.ARIZONAMOBIL_CAR_INFO.getId());
                if (pageIfExist != null) {
                    pageIfExist.removePage();
                }
                HistoryManager.Companion.clearHistoryByKey(MobilePhonePage.ARIZONAMOBIL_CAR_INFO.getId());
                MobileController pageIfExist2 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.ARIZONAMOBIL_CARS.getId());
                if (pageIfExist2 != null) {
                    pageIfExist2.removePage();
                }
                HistoryManager.Companion.clearHistoryByKey(MobilePhonePage.ARIZONAMOBIL_CARS.getId());
                MobileController pageIfExist3 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.ARIZONAMOBIL_MAIN.getId());
                if (pageIfExist3 != null) {
                    pageIfExist3.removePage();
                }
                HistoryManager.Companion.clearHistoryByKey(MobilePhonePage.ARIZONAMOBIL_MAIN.getId());
                MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.ARIZONAMOBIL_RENTED.getId());
                Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.carsharing.CarSharingRented");
                ((CarSharingRented) orCreatePage).setRentInfo(mobilePhoneRentInfo);
            }
        } catch (Exception unused) {
            System.out.println((Object) "Ошибка при парсинге информации об аренде");
        }
    }

    private final void addAvailableCars(String str) {
        try {
            List listModel = MapperKt.toListModel(str, MobilePhoneAvailableCar.class);
            MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.ARIZONAMOBIL_CARS.getId());
            Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.carsharing.CarSharingCars");
            this.availableCars.addAll(listModel);
            ((CarSharingCars) orCreatePage).addCars(this.availableCars);
        } catch (Exception unused) {
            System.out.println((Object) "Ошибка при парсинге доступных машин");
        }
    }

    private final void setCallStatus(String str) {
        try {
            CallStatus callStatus = (CallStatus) MapperKt.toModel(str, CallStatus.class);
            HistoryManager.Companion.clearAllHistory();
            HistoryManager.Companion.removeViewsPage(MobilePhonePage.MESSENGER_APP.getId());
            HistoryManager.Companion.removeViewsPage(MobilePhonePage.MESSENGER_CHAT.getId());
            int type = callStatus.getType();
            if (type != 0) {
                if (type != 1) {
                    return;
                }
                if (callStatus.getStatus() == 1) {
                    this.callStatus = Integer.valueOf(callStatus.getType());
                    MobileController pageIfExist = HistoryManager.Companion.getPageIfExist(MobilePhonePage.MAIN_PAGE.getId());
                    if (pageIfExist != null) {
                        pageIfExist.removePage();
                    }
                    MobileController pageIfExist2 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.CALL_RECEIVE_PAGE.getId());
                    if (pageIfExist2 != null) {
                        pageIfExist2.removePage();
                    }
                    HistoryManager.Companion.getOrCreatePage(MobilePhonePage.CALL_RECEIVE_PAGE.getId());
                } else if (callStatus.getStatus() == 0) {
                    this.callStatus = null;
                    MobileController pageIfExist3 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.CALL_TALK_PAGE.getId());
                    if (pageIfExist3 != null) {
                        pageIfExist3.removePage();
                    }
                    MobileController pageIfExist4 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.CALL_RECEIVE_PAGE.getId());
                    if (pageIfExist4 != null) {
                        pageIfExist4.removePage();
                    }
                    HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MAIN_PAGE.getId());
                }
            } else if (callStatus.getStatus() == 1) {
                this.callStatus = 0;
                MobileController pageIfExist5 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.MAIN_PAGE.getId());
                if (pageIfExist5 != null) {
                    pageIfExist5.removePage();
                }
                MobileController pageIfExist6 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.CALL_TYPE_PAGE.getId());
                if (pageIfExist6 != null) {
                    pageIfExist6.removePage();
                }
                MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.CALL_TALK_PAGE.getId());
                Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.call.CallTalk");
                CallTalk callTalk = (CallTalk) orCreatePage;
            } else if (callStatus.getStatus() == 0) {
                this.callStatus = null;
                MobileController pageIfExist7 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.CALL_TYPE_PAGE.getId());
                if (pageIfExist7 != null) {
                    pageIfExist7.removePage();
                }
                MobileController pageIfExist8 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.CALL_TALK_PAGE.getId());
                if (pageIfExist8 != null) {
                    pageIfExist8.removePage();
                }
                MobileController pageIfExist9 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.CALL_RECEIVE_PAGE.getId());
                if (pageIfExist9 != null) {
                    pageIfExist9.removePage();
                }
                MobileController pageIfExist10 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.CALL_TYPE_PAGE.getId());
                if (pageIfExist10 != null) {
                    pageIfExist10.removePage();
                }
                HistoryManager.Companion.getOrCreatePage(0);
            }
        } catch (Exception unused) {
            System.out.println((Object) "Ошибка при парсинге статуса вызова");
        }
    }

    private final void playTrackFromServer(String str) {
        List split$default = StringsKt.split$default((CharSequence) str, new String[]{StringUtils.COMMA}, false, 0, 6, (Object) null);
        MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.SPOTIFY_PAGE.getId());
        Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage");
        SpotifyPage spotifyPage = (SpotifyPage) orCreatePage;
        if (split$default.size() == 2) {
            spotifyPage.addPlayedTrack(Integer.parseInt((String) split$default.get(0)), Integer.parseInt((String) split$default.get(1)));
        } else {
            Log.d("MobilePhone", "error from server, id, trackStart(second) is absent");
        }
    }

    private final void initFavourite(String str) {
        ArrayList emptyList;
        List split$default;
        try {
            MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.SPOTIFY_PAGE.getId());
            Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage");
            SpotifyPage spotifyPage = (SpotifyPage) orCreatePage;
            String removeSurrounding = StringsKt.removeSurrounding(str, (CharSequence) "[", (CharSequence) "]");
            if (removeSurrounding.length() <= 0) {
                removeSurrounding = null;
            }
            if (removeSurrounding != null && (split$default = StringsKt.split$default((CharSequence) removeSurrounding, new String[]{StringUtils.COMMA}, false, 0, 6, (Object) null)) != null) {
                List<String> list = split$default;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (String str2 : list) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
                }
                emptyList = arrayList;
            } else {
                emptyList = CollectionsKt.emptyList();
            }
            spotifyPage.initFavourite(emptyList);
        } catch (RuntimeException unused) {
            Log.d("MobilePhone", "error from server, init favourite (not int array)");
        }
    }

    private final void addToFavourite(String str) {
        try {
            MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.SPOTIFY_PAGE.getId());
            Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage");
            ((SpotifyPage) orCreatePage).addToFavourite(Integer.parseInt(str));
        } catch (RuntimeException unused) {
            Log.d("MobilePhone", "error from server, favourite (not int)");
        }
    }

    private final void removeFromFavourite(String str) {
        try {
            MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.SPOTIFY_PAGE.getId());
            Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage");
            ((SpotifyPage) orCreatePage).removeFromFavourite(Integer.parseInt(str));
        } catch (RuntimeException unused) {
            Log.d("MobilePhone", "error from server, favourite (not int)");
        }
    }

    private final void openSpotify() {
        MobileController pageIfExist = HistoryManager.Companion.getPageIfExist(MobilePhonePage.MAIN_PAGE.getId());
        if (pageIfExist != null) {
            pageIfExist.removePage();
        }
        HistoryManager.Companion.getOrCreatePage(MobilePhonePage.SPOTIFY_PAGE.getId()).renderPage();
    }

    private final void changeArtistNameRadio(String str) {
        try {
            List<ChangeArtistNameRadioRequest> listModel = MapperKt.toListModel(str, ChangeArtistNameRadioRequest.class);
            MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.SPOTIFY_PAGE.getId());
            Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyPage");
            ((SpotifyPage) orCreatePage).changeArtistNameRadio(listModel);
        } catch (Exception unused) {
            System.out.println((Object) "Не удалось распарсить информацию о ChangeArtistNameRadioRequest");
        }
    }

    private final void setCatchAppInfo(String str) {
        try {
            CatchAppInfo catchAppInfo = (CatchAppInfo) MapperKt.toModel(str, CatchAppInfo.class);
            MobileController pageIfExist = HistoryManager.Companion.getPageIfExist(MobilePhonePage.MAIN_PAGE.getId());
            if (pageIfExist != null) {
                pageIfExist.removePage();
            }
            HistoryManager.Companion.getOrCreatePage(MobilePhonePage.CATCH_APP.getId()).renderPage();
            MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.CATCH_APP.getId());
            Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.catch_app.CatchApp");
            ((CatchApp) orCreatePage).setCatchAppInfo(catchAppInfo);
        } catch (Exception unused) {
            System.out.println((Object) "Не удалось распарсить информацию о CatchAppInfo");
        }
    }

    private final String phoneCaseIdentifier(int i) {
        if (i < 0 || i >= 11) {
            if (11 > i || i >= 22) {
                if (22 > i || i >= 32) {
                    if (32 > i || i >= 42) {
                        if (42 > i || i >= 52) {
                            return Constants.REFERRER_API_XIAOMI;
                        }
                        return "iphone";
                    }
                    return Constants.REFERRER_API_SAMSUNG;
                }
                return Constants.REFERRER_API_GOOGLE;
            }
            return "huawei";
        }
        return Constants.REFERRER_API_XIAOMI;
    }

    public final synchronized void closePhone() {
        this.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), -1, 12);
        this.timer.cancel();
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        switch (i) {
            case 0:
                setServerName(data);
                return;
            case 1:
                setScreenBackgroundId(Integer.parseInt(data));
                return;
            case 2:
                setCaseId(Integer.parseInt(data) - 1);
                return;
            case 3:
                addAvailableCars(data);
                return;
            case 4:
                setRentedInfo(data);
                return;
            case 5:
            case 6:
            case 7:
            case 29:
            default:
                return;
            case 8:
                setArizonaMobilBalance(Integer.parseInt(data));
                return;
            case 9:
                setCallStatus(data);
                return;
            case 10:
                setCompanionName(data);
                return;
            case 11:
                setCompanionNumber(data);
                return;
            case 12:
                renderTaxiSearch();
                return;
            case 13:
                sendTaxiStatus(data);
                return;
            case 14:
                sendDriverInfo(data);
                return;
            case 15:
                closeOrder();
                return;
            case 16:
                sendOrderStatus();
                return;
            case 17:
                sendPriority(data);
                return;
            case 18:
                setWorkingButton(data);
                return;
            case 19:
                setWorkingInfo(data);
                return;
            case 20:
                addWorkingList(data);
                return;
            case 21:
                renderDriverOrder(data);
                return;
            case 22:
                setGreenButtonText(data);
                return;
            case 23:
                clearDriverOrders();
                return;
            case 24:
                closeDriverMenu();
                return;
            case 25:
                initFavourite(data);
                return;
            case 26:
                addToFavourite(data);
                return;
            case 27:
                removeFromFavourite(data);
                return;
            case 28:
                playTrackFromServer(data);
                return;
            case 30:
                openSpotify();
                return;
            case 31:
                changeArtistNameRadio(data);
                return;
            case 32:
                setCatchAppInfo(data);
                return;
            case 33:
                showScreenByID(Integer.parseInt(data));
                return;
            case 34:
                clearTaxiOrders();
                return;
            case 35:
                setMessengerToken(data);
                return;
            case 36:
                sendMessageSuccess(data);
                return;
            case 37:
                removeContactStatus(data);
                return;
            case 38:
                addContactStatus(data);
                return;
            case 39:
                blockContactStatus(data);
                return;
            case 40:
                pinContactStatus(data);
                return;
            case 41:
                clearMessagesStatus(data);
                return;
            case 42:
                notifyContactStatus(data);
                return;
            case 43:
                removeMessageStatus(data);
                return;
            case 44:
                contactSettingsUpdate(data);
                return;
            case 45:
                callContactStatus(data);
                return;
            case 46:
                newMessage(data);
                return;
            case 47:
                updateDialog(data);
                return;
            case 48:
                openMessengerChat(data);
                return;
        }
    }

    private final void openMessengerChat(String str) {
        if (!this.phoneIsOpen) {
            setVisibility(true);
        }
        UserNumber userNumber = (UserNumber) MapperKt.toModel(str, UserNumber.class);
        String string = this.sharedPreferencesMessengerToken.getString("token", "");
        MessengerRetrofitClient.INSTANCE.getApi().getContactInfo(string != null ? string : "", userNumber.getId(), userNumber.getTel()).enqueue(new Callback<ContactApiResponse>() { // from class: ru.mrlargha.arizonaui.mobile.presentation.MobilePhone$openMessengerChat$1
            @Override // retrofit2.Callback
            public void onResponse(Call<ContactApiResponse> call, Response<ContactApiResponse> response) {
                ContactApiResponse body;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (!response.isSuccessful() || (body = response.body()) == null) {
                    return;
                }
                HistoryManager.Companion.putParams(body.toModel());
                if (HistoryManager.Companion.getThisPageId() != MobilePhonePage.MESSENGER_CHAT.getId()) {
                    MobileController pageIfExist = HistoryManager.Companion.getPageIfExist(HistoryManager.Companion.getThisPageId());
                    if (pageIfExist != null) {
                        pageIfExist.removePage();
                    }
                    HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MESSENGER_CHAT.getId());
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<ContactApiResponse> p0, Throwable p1) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                Intrinsics.checkNotNullParameter(p1, "p1");
                Log.e(Messenger.MESSENGER_PREFS, "onFailure: " + p1);
            }
        });
    }

    private final void updateDialog(String str) {
        MobileController pageIfExist = HistoryManager.Companion.getPageIfExist(MobilePhonePage.MESSENGER_CHAT.getId());
        MessengerChat messengerChat = pageIfExist instanceof MessengerChat ? (MessengerChat) pageIfExist : null;
        MobileController pageIfExist2 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.MESSENGER_APP.getId());
        Messenger messenger = pageIfExist2 instanceof Messenger ? (Messenger) pageIfExist2 : null;
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("id")) {
            int i = jSONObject.getInt("id");
            if (messenger != null) {
                messenger.updateDialog(i);
            }
            if (messengerChat != null) {
                messengerChat.updateDialog(i);
            }
        }
    }

    private final void newMessage(String str) {
        MobileController pageIfExist = HistoryManager.Companion.getPageIfExist(MobilePhonePage.MESSENGER_CHAT.getId());
        MessengerChat messengerChat = pageIfExist instanceof MessengerChat ? (MessengerChat) pageIfExist : null;
        MobileController pageIfExist2 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.MESSENGER_APP.getId());
        Messenger messenger = pageIfExist2 instanceof Messenger ? (Messenger) pageIfExist2 : null;
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("title")) {
            String string = jSONObject.getString("title");
            int i = jSONObject.getInt(Constants.MessagePayloadKeys.MSGID_SERVER);
            int i2 = jSONObject.getInt("user_id");
            Intrinsics.checkNotNull(string);
            if (string.length() > 0) {
                if (messenger != null) {
                    messenger.onNewMessage(i2, string);
                }
                if (messengerChat != null) {
                    messengerChat.onNewMessage(i2, i, string);
                }
            }
        }
    }

    private final void callContactStatus(String str) {
        MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MESSENGER_CHAT.getId());
        Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.messenger.MessengerChat");
        MessengerChat messengerChat = (MessengerChat) orCreatePage;
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
            if (jSONObject.getBoolean(NotificationCompat.CATEGORY_STATUS)) {
                messengerChat.callContactStatus();
            } else {
                Toast.makeText(this.activity, "Произошла ошибка", 0).show();
            }
        }
    }

    private final void removeMessageStatus(String str) {
        MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MESSENGER_CHAT.getId());
        Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.messenger.MessengerChat");
        MessengerChat messengerChat = (MessengerChat) orCreatePage;
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
            if (jSONObject.getBoolean(NotificationCompat.CATEGORY_STATUS)) {
                messengerChat.removeMessageStatus();
            } else {
                Toast.makeText(this.activity, "Произошла ошибка", 0).show();
            }
        }
    }

    private final void notifyContactStatus(String str) {
        MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MESSENGER_CHAT.getId());
        Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.messenger.MessengerChat");
        MessengerChat messengerChat = (MessengerChat) orCreatePage;
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
            if (jSONObject.getBoolean(NotificationCompat.CATEGORY_STATUS)) {
                messengerChat.notifyContactStatus();
            } else {
                Toast.makeText(this.activity, "Произошла ошибка", 0).show();
            }
        }
    }

    private final void clearMessagesStatus(String str) {
        MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MESSENGER_CHAT.getId());
        Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.messenger.MessengerChat");
        MessengerChat messengerChat = (MessengerChat) orCreatePage;
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
            if (jSONObject.getBoolean(NotificationCompat.CATEGORY_STATUS)) {
                messengerChat.clearMessagesStatus();
            } else {
                Toast.makeText(this.activity, "Произошла ошибка", 0).show();
            }
        }
    }

    private final void pinContactStatus(String str) {
        MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MESSENGER_CHAT.getId());
        Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.messenger.MessengerChat");
        MessengerChat messengerChat = (MessengerChat) orCreatePage;
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
            if (jSONObject.getBoolean(NotificationCompat.CATEGORY_STATUS)) {
                messengerChat.pinContactStatus();
            } else {
                Toast.makeText(this.activity, "Произошла ошибка", 0).show();
            }
        }
    }

    private final void blockContactStatus(String str) {
        MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MESSENGER_CHAT.getId());
        Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.messenger.MessengerChat");
        MessengerChat messengerChat = (MessengerChat) orCreatePage;
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has(NotificationCompat.CATEGORY_STATUS) && jSONObject.getBoolean(NotificationCompat.CATEGORY_STATUS)) {
            messengerChat.blockContact();
        }
    }

    private final void addContactStatus(String str) {
        MobileController pageIfExist = HistoryManager.Companion.getPageIfExist(MobilePhonePage.MESSENGER_APP.getId());
        MessengerChat messengerChat = null;
        Messenger messenger = pageIfExist instanceof Messenger ? (Messenger) pageIfExist : null;
        if (messenger == null) {
            MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MESSENGER_CHAT.getId());
            Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.messenger.MessengerChat");
            messengerChat = (MessengerChat) orCreatePage;
        }
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has(NotificationCompat.CATEGORY_STATUS) && jSONObject.getBoolean(NotificationCompat.CATEGORY_STATUS)) {
            if (messenger != null) {
                messenger.addContactAction();
            }
            if (messengerChat != null) {
                messengerChat.addContactAction();
            }
        }
    }

    private final void removeContactStatus(String str) {
        MobileController pageIfExist = HistoryManager.Companion.getPageIfExist(MobilePhonePage.MESSENGER_APP.getId());
        MessengerChat messengerChat = null;
        Messenger messenger = pageIfExist instanceof Messenger ? (Messenger) pageIfExist : null;
        if (messenger == null) {
            MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MESSENGER_CHAT.getId());
            Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.messenger.MessengerChat");
            messengerChat = (MessengerChat) orCreatePage;
        }
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
            if (!jSONObject.getBoolean(NotificationCompat.CATEGORY_STATUS)) {
                Toast.makeText(this.activity, "Произошла ошибка", 0).show();
                return;
            }
            if (messenger != null) {
                messenger.removeContactAction();
            }
            if (messengerChat != null) {
                messengerChat.removeContactAction();
            }
        }
    }

    private final void sendMessageSuccess(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
            if (jSONObject.getBoolean(NotificationCompat.CATEGORY_STATUS)) {
                MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MESSENGER_CHAT.getId());
                MessengerChat messengerChat = orCreatePage instanceof MessengerChat ? (MessengerChat) orCreatePage : null;
                if (messengerChat != null) {
                    messengerChat.sendMessageSuccess();
                    return;
                }
                return;
            }
            Toast.makeText(this.activity, "Произошла ошибка", 0).show();
        }
    }

    private final void setMessengerToken(String str) {
        Integer history = HistoryManager.Companion.getHistory();
        int id = MobilePhonePage.MESSENGER_APP.getId();
        if (history == null || history.intValue() != id) {
            Integer history2 = HistoryManager.Companion.getHistory();
            int id2 = MobilePhonePage.MESSENGER_CHAT.getId();
            if (history2 == null || history2.intValue() != id2) {
                return;
            }
        }
        MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MESSENGER_APP.getId());
        Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.messenger.Messenger");
        Messenger messenger = (Messenger) orCreatePage;
        MobileController pageIfExist = HistoryManager.Companion.getPageIfExist(MobilePhonePage.MESSENGER_CHAT.getId());
        MessengerChat messengerChat = pageIfExist instanceof MessengerChat ? (MessengerChat) pageIfExist : null;
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("token")) {
            String string = jSONObject.getString("token");
            Intrinsics.checkNotNull(string);
            messenger.addToken(string);
            if (messengerChat != null) {
                messengerChat.updateToken(string);
                return;
            }
            return;
        }
        Toast.makeText(this.activity, "Ошибка авторизации, попробуйте позже", 0).show();
        HistoryManager.Companion.previousPage();
    }

    private final void contactSettingsUpdate(String str) {
        MapperKt.toModel(str, ContactModel.class);
        MobileController orCreatePage = HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MESSENGER_APP.getId());
        Intrinsics.checkNotNull(orCreatePage, "null cannot be cast to non-null type ru.mrlargha.arizonaui.mobile.presentation.page.messenger.Messenger");
        ((Messenger) orCreatePage).contactSettingsUpdate();
    }

    private final void showScreenByID(int i) {
        if (!this.phoneIsOpen) {
            this.sendFrontedMessage.clickedWrapper(8, 1, -1);
        } else if (i == MobilePhoneScreenIds.MENU_ID_MENU.getId()) {
            HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MAIN_PAGE.getId());
        } else if (i == MobilePhoneScreenIds.MENU_ID_HELP.getId()) {
            sendRequest(1);
        } else if (i == MobilePhoneScreenIds.MENU_ID_QUEST.getId()) {
            sendRequest(2);
        } else if (i == MobilePhoneScreenIds.MENU_ID_REPORT.getId()) {
            sendRequest(3);
        } else if (i == MobilePhoneScreenIds.MENU_ID_AZPOTIFY.getId()) {
            sendRequest(4);
            MobileController pageIfExist = HistoryManager.Companion.getPageIfExist(MobilePhonePage.MAIN_PAGE.getId());
            if (pageIfExist != null) {
                pageIfExist.removePage();
            }
            HistoryManager.Companion.getOrCreatePage(MobilePhonePage.SPOTIFY_PAGE.getId()).renderPage();
        } else if (i == MobilePhoneScreenIds.MENU_ID_DRIVER.getId()) {
            sendRequest(5);
            MobileController pageIfExist2 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.MAIN_PAGE.getId());
            if (pageIfExist2 != null) {
                pageIfExist2.removePage();
            }
        } else if (i == MobilePhoneScreenIds.MENU_ID_UBER.getId()) {
            sendRequest(6);
        } else if (i == MobilePhoneScreenIds.MENU_ID_GPS.getId()) {
            sendRequest(7);
        } else if (i == MobilePhoneScreenIds.MENU_ID_SETTING.getId()) {
            sendRequest(8);
        } else if (i == MobilePhoneScreenIds.MENU_ID_CALL.getId()) {
            sendRequest(9);
            MobileController pageIfExist3 = HistoryManager.Companion.getPageIfExist(MobilePhonePage.MAIN_PAGE.getId());
            if (pageIfExist3 != null) {
                pageIfExist3.removePage();
            }
            HistoryManager.Companion.getOrCreatePage(MobilePhonePage.CALL_TYPE_PAGE.getId());
        } else if (i == MobilePhoneScreenIds.MENU_ID_SMS.getId()) {
            sendRequest(10);
            if (HistoryManager.Companion.getThisPageId() != MobilePhonePage.MESSENGER_APP.getId()) {
                MobileController pageIfExist4 = HistoryManager.Companion.getPageIfExist(HistoryManager.Companion.getThisPageId());
                if (pageIfExist4 != null) {
                    pageIfExist4.removePage();
                }
                HistoryManager.Companion.getOrCreatePage(MobilePhonePage.MESSENGER_APP.getId());
            }
        } else if (i == MobilePhoneScreenIds.MENU_ID_CONTACT.getId()) {
            sendRequest(11);
        } else if (i == MobilePhoneScreenIds.MENU_ID_REWARD.getId()) {
            sendRequest(12);
        } else if (i == MobilePhoneScreenIds.MENU_ID_SHOP.getId()) {
            sendRequest(13);
        } else if (i == MobilePhoneScreenIds.MENU_ID_BLOCKCHAIN.getId()) {
            sendRequest(14);
        } else if (i == MobilePhoneScreenIds.MENU_ID_MED.getId()) {
            sendRequest(15);
        } else if (i == MobilePhoneScreenIds.MENU_ID_PASS.getId()) {
            sendRequest(16);
        } else if (i == MobilePhoneScreenIds.MENU_ID_ANIM.getId()) {
            sendRequest(17);
        } else if (i == MobilePhoneScreenIds.MENU_ID_MYFAMILY.getId()) {
            sendRequest(18);
        } else if (i == MobilePhoneScreenIds.MENU_ID_YOUTUBE.getId()) {
            sendRequest(19);
        } else if (i == MobilePhoneScreenIds.MENU_ID_BIZ.getId()) {
            sendRequest(20);
        } else if (i == MobilePhoneScreenIds.MENU_ID_CARS.getId()) {
            sendRequest(21);
        } else if (i == MobilePhoneScreenIds.MENU_ID_HOUSE.getId()) {
            sendRequest(22);
        } else if (i == MobilePhoneScreenIds.MENU_ID_BANKING.getId()) {
            sendRequest(23);
        } else if (i == MobilePhoneScreenIds.MENU_ID_BILBOARD.getId()) {
            sendRequest(24);
        } else if (i == MobilePhoneScreenIds.MENU_ID_GALERY.getId()) {
            sendRequest(25);
        } else if (i == MobilePhoneScreenIds.MENU_ID_MUSIC.getId()) {
            sendRequest(26);
        } else if (i == MobilePhoneScreenIds.MENU_ID_COP_CHASE.getId()) {
            sendRequest(27);
        } else if (i == MobilePhoneScreenIds.MENU_ID_SOBES_DRIVER.getId()) {
            sendRequest(28);
        } else if (i == MobilePhoneScreenIds.MENU_ID_PROPERTY_WAR.getId()) {
            sendRequest(29);
        } else if (i == MobilePhoneScreenIds.MENU_ID_SELFIE_CAMERA.getId()) {
            sendRequest(30);
        } else if (i == MobilePhoneScreenIds.MENU_ID_PHONE_NUMBER_LIST.getId()) {
            sendRequest(31);
        } else if (i == MobilePhoneScreenIds.MENU_ID_PHONE_NICKNAME.getId()) {
            sendRequest(32);
        } else if (i == MobilePhoneScreenIds.MENU_ID_PHONE_CALENDAR.getId()) {
            sendRequest(33);
        } else if (i == MobilePhoneScreenIds.MENU_ID_PHONE_MARKETPLACE.getId()) {
            sendRequest(34);
        } else if (i == MobilePhoneScreenIds.MENU_ID_PHONE_STORAGE.getId()) {
            sendRequest(35);
        }
    }

    private final void sendRequest(int i) {
        this.sendFrontedMessage.clickedWrapper(UIElementID.ARIZONA_MOBILE_PHONE.getId(), i, 0);
    }

    /* compiled from: MobilePhone.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/MobilePhone$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new MobilePhone(targetActivity, i);
        }
    }

    @Override // ru.mrlargha.arizonaui.mobile.presentation.MobileController
    public void removePage() {
        this.mobilePhone.removeAllViews();
    }
}
