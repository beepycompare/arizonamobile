package ru.mrlargha.commonui.elements.hud.presentation;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.media3.common.C;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.common.utils.EasyAnimation;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.BannerElementBinding;
import ru.mrlargha.commonui.databinding.HudCaptBinding;
import ru.mrlargha.commonui.databinding.HudImprovingSkillsBinding;
import ru.mrlargha.commonui.databinding.HudPageBinding;
import ru.mrlargha.commonui.databinding.HudProgressBarContainerBinding;
import ru.mrlargha.commonui.databinding.HudProposalScreenBinding;
import ru.mrlargha.commonui.databinding.HudTaximeterContainerBinding;
import ru.mrlargha.commonui.databinding.HudTaximeterStopwatchBinding;
import ru.mrlargha.commonui.databinding.HudTimerBinding;
import ru.mrlargha.commonui.databinding.RodinaKaptScreenBinding;
import ru.mrlargha.commonui.elements.hud.interaction_button.InteractionData;
import ru.mrlargha.commonui.elements.hud.mission_progress.MissionData;
import ru.mrlargha.commonui.elements.hud.mission_progress.MissionGroupData;
import ru.mrlargha.commonui.elements.hud.mission_progress.MissionProgressAdapter;
import ru.mrlargha.commonui.elements.hud.presentation.api.HudApi;
import ru.mrlargha.commonui.elements.hud.presentation.api.obj.HudApiRequest;
import ru.mrlargha.commonui.elements.hud.presentation.api.obj.Query;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.HudImprovingSkills;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.HudProposalScreen;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.HudTimer;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.UnreadMessageModel;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.capt.HudCapt;
import ru.mrlargha.commonui.elements.hud.presentation.inner_classes.BannerElement;
import ru.mrlargha.commonui.elements.hud.presentation.models.GroupItem;
import ru.mrlargha.commonui.elements.hud.presentation.models.ProgressBarModel;
import ru.mrlargha.commonui.elements.hud.presentation.models.ServerInfoItem;
import ru.mrlargha.commonui.elements.hud.presentation.models.TaximeterModel;
import ru.mrlargha.commonui.utils.ConverterKt;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
import ru.mrlargha.commonui.utils.GsonStore;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.StringKt;
/* compiled from: Hud.kt */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u0096\u00012\u00020\u0001:\n\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001\u0096\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\u000e\u00101\u001a\u00020.2\u0006\u00102\u001a\u000200J\u001e\u00103\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000100\u0012\u0004\u0012\u000200042\u0006\u00105\u001a\u000200H\u0002J\u0010\u00106\u001a\u00020.2\u0006\u00107\u001a\u00020\u0019H\u0016J&\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005J\u000e\u0010=\u001a\u00020.2\u0006\u0010>\u001a\u00020\u0005J\u000e\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020\u0015J\u000e\u0010A\u001a\u00020.2\u0006\u0010B\u001a\u00020\u0005J\u000e\u0010C\u001a\u00020.2\u0006\u0010D\u001a\u000200J\u000e\u0010E\u001a\u00020.2\u0006\u0010D\u001a\u000200J\u0010\u0010F\u001a\u00020.2\u0006\u0010G\u001a\u000200H\u0002J\u0010\u0010H\u001a\u00020.2\u0006\u0010D\u001a\u000200H\u0002J\u0010\u0010I\u001a\u00020.2\u0006\u0010J\u001a\u00020\u0005H\u0002J\u0010\u0010K\u001a\u00020.2\u0006\u0010L\u001a\u00020\u0005H\u0002J\u0010\u0010M\u001a\u00020.2\u0006\u0010L\u001a\u00020\u0005H\u0002J\u0010\u0010N\u001a\u0002002\u0006\u0010O\u001a\u00020\u0015H\u0002J\u0010\u0010P\u001a\u00020.2\u0006\u0010Q\u001a\u00020\u0005H\u0002JR\u0010R\u001a\u00020.2\u0006\u0010S\u001a\u00020\u00052\u0006\u0010T\u001a\u00020\u00052\b\b\u0002\u0010U\u001a\u00020\u00052\u0006\u0010V\u001a\u0002002\b\b\u0002\u0010W\u001a\u0002002\b\b\u0002\u0010X\u001a\u0002002\b\b\u0002\u0010Y\u001a\u00020\u00192\b\b\u0002\u0010Z\u001a\u00020\u0005H\u0002J<\u0010[\u001a\u00020.2\u0006\u0010\\\u001a\u00020\u00052\u0006\u0010]\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\u00052\u0006\u0010_\u001a\u0002002\b\b\u0002\u0010Z\u001a\u00020\u00052\b\b\u0002\u0010`\u001a\u00020\u0019H\u0002J\u0010\u0010a\u001a\u00020.2\u0006\u00107\u001a\u00020\u0005H\u0002J\u0010\u0010b\u001a\u00020.2\u0006\u0010L\u001a\u00020\u0005H\u0002J\u0010\u0010c\u001a\u00020.2\u0006\u0010d\u001a\u00020eH\u0002J\u0010\u0010f\u001a\u00020.2\u0006\u0010G\u001a\u000200H\u0002J\b\u0010g\u001a\u00020.H\u0002J\u001e\u0010h\u001a\u00020.2\u0006\u0010i\u001a\u0002002\f\u0010j\u001a\b\u0012\u0004\u0012\u00020l0kH\u0002J\b\u0010m\u001a\u00020.H\u0002J\u0010\u0010n\u001a\u00020.2\u0006\u0010o\u001a\u00020\u0005H\u0002J\u0010\u0010p\u001a\u00020.2\u0006\u0010q\u001a\u00020rH\u0002J\u0018\u0010s\u001a\u00020.2\u0006\u0010D\u001a\u0002002\u0006\u0010t\u001a\u00020\u0005H\u0016J\u0010\u0010u\u001a\u00020.2\u0006\u0010D\u001a\u000200H\u0002J\u0010\u0010v\u001a\u00020.2\u0006\u0010d\u001a\u00020wH\u0002J\u0010\u0010x\u001a\u00020.2\u0006\u00107\u001a\u00020\u0005H\u0002J\b\u0010y\u001a\u00020.H\u0002J\u0016\u0010z\u001a\u00020.2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020{0kH\u0002J\u0016\u0010|\u001a\u00020.2\f\u0010}\u001a\b\u0012\u0004\u0012\u00020{0kH\u0002J\u0010\u0010~\u001a\u00020.2\u0006\u0010B\u001a\u00020\u0005H\u0002J\u0010\u0010\u007f\u001a\u00020.2\u0006\u0010}\u001a\u00020{H\u0002J\u001a\u0010\u0080\u0001\u001a\u00020.2\u0006\u0010D\u001a\u0002002\u0007\u0010\u0081\u0001\u001a\u00020\u0019H\u0002J\t\u0010\u0082\u0001\u001a\u00020.H\u0002J\t\u0010\u0083\u0001\u001a\u00020.H\u0002J\t\u0010\u0084\u0001\u001a\u00020.H\u0002J\u0012\u0010\u0085\u0001\u001a\u00020.2\u0007\u0010\u0086\u0001\u001a\u000200H\u0002J\t\u0010\u0087\u0001\u001a\u00020.H\u0002J\u0012\u0010\u0088\u0001\u001a\u00020.2\u0007\u0010D\u001a\u00030\u0089\u0001H\u0002J\u0012\u0010\u008a\u0001\u001a\u00020.2\u0007\u0010\u008b\u0001\u001a\u00020\u0005H\u0002J\u0012\u0010\u008c\u0001\u001a\u00020.2\u0007\u0010\u008b\u0001\u001a\u00020\u0005H\u0002J\t\u0010\u008d\u0001\u001a\u00020.H\u0002J\t\u0010\u008e\u0001\u001a\u00020.H\u0002J\u0012\u0010\u008f\u0001\u001a\u00020.2\u0007\u0010\u0090\u0001\u001a\u00020\u0005H\u0002J\t\u0010\u0091\u0001\u001a\u00020.H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u0012*\u0004\u0018\u00010\u00170\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0097\u0001"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/Hud;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "hud", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/HudPageBinding;", "backendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "retrofit", "Lretrofit2/Retrofit;", "api", "Lru/mrlargha/commonui/elements/hud/presentation/api/HudApi;", "kotlin.jvm.PlatformType", "xPayDay", "previousMoneyValue", "", "sharedPref", "Landroid/content/SharedPreferences;", "isArizonaType", "", "taximeterTimer", "Landroid/os/CountDownTimer;", "trainTimer", "moneyTimer", "missionsProgressAdapter", "Lru/mrlargha/commonui/elements/hud/mission_progress/MissionProgressAdapter;", "interactionButtonId", "streamerState", "isRunningTaxiTimer", "handler", "Landroid/os/Handler;", "remainedTime", "typeTaximeterValue", "Lru/mrlargha/commonui/elements/hud/presentation/TypeTaximeterValue;", "isGroupButtonPressed", "groupAdapter", "Lru/mrlargha/commonui/elements/hud/presentation/GroupAdapter;", "bannerElement", "Lru/mrlargha/commonui/elements/hud/presentation/inner_classes/BannerElement;", "installServerLogotype", "", "uri", "", "setPlayerLocation", FirebaseAnalytics.Param.LOCATION, "parseString", "Lkotlin/Pair;", "input", "setVisibility", "visible", "installHud", "playerId", "serverId", "serverType", "isStreamerMode", "updateOnline", "currentOnline", "updateMoney", "money", "updateRouletteInfo", "id", "updateRouletteInfoText", "data", "updateMainRouletteText", "setTaxiPrice", "text", "setTaximeterVisibility", "startTaxiTimerCountUp", "initialElapsedSeconds", "startTaxiTimerCountdown", "seconds", "stopTaxiTimer", "formatTime", "millisUntilFinished", "setTaximeterType", "type", "setTaximeterLayoutType", "sumBg", "timerBg", "bg", "timeTextColor", "sumTitleText", "sumTextColor", "isBigTextSize", TtmlNode.ATTR_TTS_FONT_FAMILY, "setDemorganType", "titleImage", "containerImage", "containerBg", "textColor", "isScaleBg", "setTrainsVisibility", "startTrainTimer", "setTrainInfo", "info", "Lru/mrlargha/commonui/elements/hud/presentation/Hud$Companion$TrainInfo;", "showInteractionButton", "hideInteractionButton", "showMissionsProgress", "title", "missions", "", "Lru/mrlargha/commonui/elements/hud/mission_progress/MissionData;", "hideMissionsProgress", "setVip", "days", "setNoticeState", "noticeInfo", "Lru/mrlargha/commonui/elements/hud/presentation/Hud$Companion$NoticeInfo;", "onBackendMessage", "subId", "setLocationVisibility", "setServerID", "Lru/mrlargha/commonui/elements/hud/presentation/models/ServerInfoItem;", "setGroupButtonVisibility", "changeGroupTableVisibility", "setGroupData", "Lru/mrlargha/commonui/elements/hud/presentation/models/GroupItem;", "updateGroupData", "item", "deleteGroupMember", "addGroupMember", "setTaximeterCounterType", "isCountDown", "showTimer", "updateTimer", "scheduleUpdateTimer", "showProgressBar", "next", "hideProgressBar", "setDataProgressBar", "Lru/mrlargha/commonui/elements/hud/presentation/models/ProgressBarModel;", "showOverlay", TypedValues.TransitionType.S_DURATION, "hideOverlay", "hideRouletteUi", "showRouletteUi", "setXPayDay", "value", "updatePayDay", "HudListener", "Spawner", "KaptGang", "KaptData", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Hud extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private final HudApi api;
    private final IBackendNotifier backendNotifier;
    private final BannerElement bannerElement;
    private final HudPageBinding binding;
    private final GroupAdapter groupAdapter;
    private final Handler handler;
    private final ConstraintLayout hud;
    private int interactionButtonId;
    private final boolean isArizonaType;
    private boolean isGroupButtonPressed;
    private boolean isRunningTaxiTimer;
    private final MissionProgressAdapter missionsProgressAdapter;
    private CountDownTimer moneyTimer;
    private long previousMoneyValue;
    private int remainedTime;
    private Retrofit retrofit;
    private final SharedPreferences sharedPref;
    private boolean streamerState;
    private CountDownTimer taximeterTimer;
    private CountDownTimer trainTimer;
    private TypeTaximeterValue typeTaximeterValue;
    private int xPayDay;

    /* compiled from: Hud.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/Hud$HudListener;", "", "hudUpdateMoney", "", "money", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface HudListener {
        void hudUpdateMoney(long j);
    }

    /* compiled from: Hud.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TypeTaximeterValue.values().length];
            try {
                iArr[TypeTaximeterValue.PRISE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TypeTaximeterValue.PERCENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TypeTaximeterValue.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TypeTaximeter.values().length];
            try {
                iArr2[TypeTaximeter.TAXI.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[TypeTaximeter.BUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[TypeTaximeter.TRUCK.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[TypeTaximeter.DELIVERY.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[TypeTaximeter.DRIFT_POINT.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[TypeTaximeter.HALLOWEEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[TypeTaximeter.DEMORGAN.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[TypeTaximeter.ARMY_SECOND.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[TypeTaximeter.EASTER_RELAY.ordinal()] = 9;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[TypeTaximeter.FARMER_HEALTH.ordinal()] = 10;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[TypeTaximeter.SOCCER_GOALS.ordinal()] = 11;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[TypeTaximeter.EASTER_CHICKEN.ordinal()] = 12;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[TypeTaximeter.AIRPLANE.ordinal()] = 13;
            } catch (NoSuchFieldError unused16) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$18$lambda$15(View view) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$18$lambda$17(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Hud(final Activity targetActivity, final int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.hud_page, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.hud = constraintLayout;
        final HudPageBinding bind = HudPageBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.backendNotifier = (IBackendNotifier) targetActivity;
        Retrofit build = new Retrofit.Builder().baseUrl(FirebaseConfigHelper.INSTANCE.getHudPingUrl()).addConverterFactory(GsonConverterFactory.create()).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        this.retrofit = build;
        this.api = (HudApi) build.create(HudApi.class);
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("isArizonaType", false);
        this.isArizonaType = z;
        MissionProgressAdapter missionProgressAdapter = new MissionProgressAdapter();
        this.missionsProgressAdapter = missionProgressAdapter;
        this.interactionButtonId = -1;
        this.handler = new Handler(Looper.getMainLooper());
        this.typeTaximeterValue = TypeTaximeterValue.PRISE;
        GroupAdapter groupAdapter = new GroupAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit groupAdapter$lambda$0;
                groupAdapter$lambda$0 = Hud.groupAdapter$lambda$0(Hud.this, (GroupItem) obj);
                return groupAdapter$lambda$0;
            }
        });
        this.groupAdapter = groupAdapter;
        BannerElementBinding banner = bind.banner;
        Intrinsics.checkNotNullExpressionValue(banner, "banner");
        this.bannerElement = new BannerElement(banner, z, this);
        if (z) {
            bind.hudMoneyIcon.setImageResource(R.drawable.hud_dollar_icon);
        }
        addViewToConstraintLayout(constraintLayout, -1, -1);
        LinearLayout root = bind.leftMenu.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        bind.hudStreamerButton.setVisibility(8);
        bind.rouletteContainer.setVisibility(8);
        bind.rouletteTimeContainer.setVisibility(8);
        bind.missionProgressList.setAdapter(missionProgressAdapter);
        bind.rouletteContainer.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.this.backendNotifier.clickedWrapper(i, 6, -1);
            }
        });
        bind.rouletteContainer.setVisibility(8);
        bind.rouletteTimeContainer.setVisibility(8);
        bind.rouletteContainer.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.this.backendNotifier.clickedWrapper(i, 6, -1);
            }
        });
        bind.leftMenu.btnOpenRadialMenu.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.lambda$18$lambda$3(targetActivity, this, i, view);
            }
        });
        bind.leftMenu.btnOpenQuest.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.lambda$18$lambda$4(targetActivity, this, i, view);
            }
        });
        bind.leftMenu.btnOpenBattlePass.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.lambda$18$lambda$5(targetActivity, this, i, view);
            }
        });
        bind.hudStreamerButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.lambda$18$lambda$6(targetActivity, this, i, view);
            }
        });
        bind.hudMenuButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.lambda$18$lambda$7(targetActivity, this, i, view);
            }
        });
        bind.hudPhoneButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.lambda$18$lambda$8(targetActivity, this, i, view);
            }
        });
        bind.hudInventoryButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.lambda$18$lambda$9(targetActivity, this, view);
            }
        });
        bind.hudDonateButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.lambda$18$lambda$10(targetActivity, this, i, view);
            }
        });
        bind.hudServerInfoContainer.setVisibility(8);
        bind.ivDoors.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.this.backendNotifier.clickedWrapper(i, -1, 1);
            }
        });
        bind.ivHorn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.lambda$18$lambda$13(Hud.this, i, bind, view);
            }
        });
        bind.imageButtonInteraction.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r0.backendNotifier.clickedWrapper(i, 7, Hud.this.interactionButtonId);
            }
        });
        bind.newMessageContainer.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.lambda$18$lambda$15(view);
            }
        });
        bind.groupButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.this.changeGroupTableVisibility();
            }
        });
        bind.groupRv.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda21
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return Hud.lambda$18$lambda$17(view, motionEvent);
            }
        });
        bind.groupRv.setAdapter(groupAdapter);
        setVisibility(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit groupAdapter$lambda$0(Hud hud, GroupItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        SAMPUIElement.notifyClick$default(hud, it.getId() + 60, 60, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$18$lambda$3(Activity activity, Hud hud, int i, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.bounce));
        hud.backendNotifier.clickedWrapper(i, 9, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$18$lambda$4(Activity activity, Hud hud, int i, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.bounce));
        hud.backendNotifier.clickedWrapper(i, 4, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$18$lambda$5(Activity activity, Hud hud, int i, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.bounce));
        hud.backendNotifier.clickedWrapper(i, 5, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$18$lambda$6(Activity activity, Hud hud, int i, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.bounce));
        hud.backendNotifier.clickedWrapper(i, 8, -1);
        hud.streamerState = !hud.streamerState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$18$lambda$7(Activity activity, Hud hud, int i, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.bounce));
        hud.backendNotifier.clickedWrapper(i, 0, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$18$lambda$8(Activity activity, Hud hud, int i, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.bounce));
        hud.backendNotifier.clickedWrapper(i, 1, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$18$lambda$9(Activity activity, Hud hud, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.bounce));
        IBackendNotifier iBackendNotifier = hud.backendNotifier;
        int id = UIElementID.INVENTORY.getId();
        byte[] bytes = StringKt.toStringJson("").getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, -1, 0, bytes);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$18$lambda$10(Activity activity, Hud hud, int i, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.bounce));
        hud.backendNotifier.clickedWrapper(i, 3, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$18$lambda$13(Hud hud, int i, final HudPageBinding hudPageBinding, View view) {
        hud.backendNotifier.clickedWrapper(i, -1, 2);
        hudPageBinding.ivHornState.setImageResource(R.drawable.ic_switch_off);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                HudPageBinding.this.ivHornState.setImageResource(R.drawable.ic_switch_none);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void installServerLogotype(String str) {
        Picasso.get().load(str).placeholder(R.drawable.logo_phoenix).into(this.binding.hudServerShieldLogo);
    }

    /* compiled from: Hud.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/Hud$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new Hud(targetActivity, i);
        }
    }

    public final void setPlayerLocation(String location) {
        String str;
        Intrinsics.checkNotNullParameter(location, "location");
        Pair<String, String> parseString = parseString(location);
        Log.d(HttpHeaders.LOCATION, "setPlayerLocation: " + parseString);
        HudPageBinding hudPageBinding = this.binding;
        String first = parseString.getFirst();
        String str2 = "";
        if (first == null) {
            first = "";
        }
        if (Intrinsics.areEqual(first, "LS")) {
            str = "Los Santos";
        } else {
            String first2 = parseString.getFirst();
            if (first2 == null) {
                first2 = "";
            }
            if (Intrinsics.areEqual(first2, "SF")) {
                str = "San Fierro";
            } else {
                String first3 = parseString.getFirst();
                if (first3 == null) {
                    first3 = "";
                }
                if (Intrinsics.areEqual(first3, "LV")) {
                    str = "Las Venturas";
                } else {
                    String first4 = parseString.getFirst();
                    if (first4 == null) {
                        first4 = "";
                    }
                    if (Intrinsics.areEqual(first4, "RC")) {
                        str = "Red Country";
                    } else {
                        String first5 = parseString.getFirst();
                        if (first5 == null) {
                            first5 = "";
                        }
                        str = (!Intrinsics.areEqual(first5, "VC") && (Intrinsics.areEqual(parseString.getSecond(), "San Andreas") || !Intrinsics.areEqual(parseString.getSecond(), "Miami"))) ? "San Andreas" : "Vice City";
                    }
                }
            }
        }
        String second = parseString.getSecond();
        if (!Intrinsics.areEqual(second, "San Andreas") && !Intrinsics.areEqual(second, "Miami")) {
            str2 = parseString.getSecond();
        }
        Log.d(HttpHeaders.LOCATION, "setPlayerLocation: " + str + " " + str2);
        hudPageBinding.locationCity.setText(str);
        hudPageBinding.locationText.setText(str2);
    }

    private final Pair<String, String> parseString(String str) {
        MatchResult matchEntire = new Regex("^\\[([^]]+)]\\s*(.*)$").matchEntire(str);
        if (matchEntire != null) {
            MatchResult.Destructured destructured = matchEntire.getDestructured();
            return TuplesKt.to(destructured.getMatch().getGroupValues().get(1), destructured.getMatch().getGroupValues().get(2));
        }
        return TuplesKt.to(null, str);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        super.setVisibility(z);
        updatePayDay();
    }

    public final void installHud(int i, final int i2, int i3, int i4) {
        Call<HudApiRequest> arizonaMobileServerInfo;
        String str;
        if (i4 != 0) {
            this.binding.hudStreamerButton.setVisibility(0);
        }
        if (i3 == 0) {
            arizonaMobileServerInfo = this.api.getArizonaMobileServerInfo();
        } else if (i3 == 1) {
            arizonaMobileServerInfo = this.api.getArizonaPcServerInfo();
        } else if (i3 == 2) {
            arizonaMobileServerInfo = this.api.getRodinaServerInfo();
        } else if (i3 != 3) {
            return;
        } else {
            arizonaMobileServerInfo = this.api.getRodinaMobileServerInfo();
        }
        arizonaMobileServerInfo.enqueue(new Callback<HudApiRequest>() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$installHud$1
            @Override // retrofit2.Callback
            public void onResponse(Call<HudApiRequest> call, Response<HudApiRequest> response) {
                boolean z;
                HudPageBinding hudPageBinding;
                HudPageBinding hudPageBinding2;
                HudPageBinding hudPageBinding3;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                HudApiRequest body = response.body();
                if (body != null) {
                    int i5 = i2;
                    Hud hud = this;
                    for (Query query : body.getQuery()) {
                        Integer number = query.getNumber();
                        if (number != null && number.intValue() == i5) {
                            String icon = query.getIcon();
                            if (icon != null) {
                                hud.installServerLogotype(icon);
                            }
                            z = hud.isArizonaType;
                            String str2 = null;
                            if (z) {
                                hudPageBinding3 = hud.binding;
                                TextView textView = hudPageBinding3.hudServerShieldName;
                                String name = query.getName();
                                if (name != null) {
                                    str2 = name.toUpperCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(str2, "toUpperCase(...)");
                                }
                                textView.setText(str2);
                            } else {
                                String name2 = query.getName();
                                if (name2 != null) {
                                    String substringBefore$default = StringsKt.substringBefore$default(name2, " ", (String) null, 2, (Object) null);
                                    hudPageBinding = hud.binding;
                                    hudPageBinding.hudServerShieldName.setText(substringBefore$default);
                                }
                            }
                            hudPageBinding2 = hud.binding;
                            hudPageBinding2.hudServerInfoContainer.setVisibility(0);
                        }
                    }
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<HudApiRequest> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                Log.w("HUD", "error get server info");
            }
        });
        TextView textView = this.binding.hudServerShieldSite;
        if (i3 == 0 || i3 == 1) {
            str = "arizona-rp.com";
        } else if (i3 == 2 || i3 == 3) {
            str = "rodina-rp.com";
        } else {
            str = "test-server.com";
        }
        textView.setText(str);
        this.binding.hudInfoIdValue.setText(String.valueOf(i));
    }

    public final void updateOnline(int i) {
        this.binding.hudInfoPersonValue.setText(String.valueOf(i));
    }

    public final void updateMoney(long j) {
        CountDownTimer countDownTimer = this.moneyTimer;
        if (countDownTimer != null) {
            if (countDownTimer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("moneyTimer");
                countDownTimer = null;
            }
            countDownTimer.cancel();
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###,###,###", new DecimalFormatSymbols(Locale.ENGLISH));
        String format = decimalFormat.format(j);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        final String replace$default = StringsKt.replace$default(format, StringUtils.COMMA, " ", false, 4, (Object) null);
        long j2 = j - this.previousMoneyValue;
        String format2 = decimalFormat.format(j2);
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        String replace$default2 = StringsKt.replace$default(format2, StringUtils.COMMA, " ", false, 4, (Object) null);
        this.previousMoneyValue = j;
        final HudPageBinding hudPageBinding = this.binding;
        if (j2 >= 0) {
            hudPageBinding.hudInfoMoneyValue.setText("+ " + ((Object) replace$default2));
            hudPageBinding.hudInfoMoneyValue.setTextColor(Color.parseColor("#60CA5D"));
        } else {
            hudPageBinding.hudInfoMoneyValue.setText("- " + ((Object) StringsKt.replace$default(replace$default2, Constants.FILENAME_SEQUENCE_SEPARATOR, "", false, 4, (Object) null)));
            hudPageBinding.hudInfoMoneyValue.setTextColor(Color.parseColor("#FF1D38"));
        }
        CountDownTimer countDownTimer2 = new CountDownTimer() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$updateMoney$1$1
            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                HudPageBinding.this.hudInfoMoneyValue.setText(replace$default);
                HudPageBinding.this.hudInfoMoneyValue.setTextColor(Color.parseColor("#FFFFFF"));
            }
        };
        this.moneyTimer = countDownTimer2;
        countDownTimer2.start();
    }

    public final void updateRouletteInfo(int i) {
        HudPageBinding hudPageBinding = this.binding;
        if (i == 0) {
            hudPageBinding.rouletteContainer.setVisibility(8);
            hudPageBinding.rouletteTimeContainer.setVisibility(8);
        } else if (i == 1) {
            hudPageBinding.rouletteContainer.setVisibility(0);
            hudPageBinding.rouletteTimeContainer.setVisibility(0);
            hudPageBinding.rouletteIc.setImageResource(R.drawable.hud_roulette_info_ic);
            hudPageBinding.rouletteTimeContainer.setBackgroundResource(R.drawable.hud_roulette_temer_info_container);
        } else if (i != 2) {
        } else {
            hudPageBinding.rouletteContainer.setVisibility(0);
            hudPageBinding.rouletteTimeContainer.setVisibility(0);
            hudPageBinding.rouletteIc.setImageResource(R.drawable.hud_roulette_ic);
            hudPageBinding.rouletteTimeContainer.setBackgroundResource(R.drawable.hud_roulette_time_container_bg);
        }
    }

    public final void updateRouletteInfoText(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.binding.rouletteTime.setText(data);
    }

    public final void updateMainRouletteText(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.binding.rouletteText.setText(data);
    }

    private final void setTaxiPrice(String str) {
        HudTaximeterContainerBinding hudTaximeterContainerBinding = this.binding.hudTaximeterLayout.hudTaximeterLayoutContainer;
        int i = WhenMappings.$EnumSwitchMapping$0[this.typeTaximeterValue.ordinal()];
        if (i == 1) {
            hudTaximeterContainerBinding.tvTaximeterSum.setText(str);
        } else if (i == 2) {
            hudTaximeterContainerBinding.tvTaximeterSum.setText(str + "%");
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            hudTaximeterContainerBinding.tvTaximeterSum.setText(str);
        }
    }

    private final void setTaximeterVisibility(String str) {
        int i;
        LinearLayout btnNext = this.binding.hudTaximeterLayout.hudTaximeterLayoutContainer.btnNext;
        Intrinsics.checkNotNullExpressionValue(btnNext, "btnNext");
        btnNext.setVisibility(8);
        if (this.isArizonaType) {
            i = Integer.parseInt(str);
        } else {
            TaximeterModel taximeterModel = (TaximeterModel) MapperKt.toModel(str, TaximeterModel.class);
            int show = taximeterModel.getShow();
            if (taximeterModel.getButtonText().length() > 0) {
                LinearLayout btnNext2 = this.binding.hudTaximeterLayout.hudTaximeterLayoutContainer.btnNext;
                Intrinsics.checkNotNullExpressionValue(btnNext2, "btnNext");
                btnNext2.setVisibility(0);
                this.binding.hudTaximeterLayout.hudTaximeterLayoutContainer.tvType.setText(taximeterModel.getButtonText());
            }
            i = show;
        }
        if (i == 0) {
            this.binding.hudTaximeterLayout.getRoot().setVisibility(8);
            CountDownTimer countDownTimer = this.taximeterTimer;
            if (countDownTimer != null) {
                if (countDownTimer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("taximeterTimer");
                    countDownTimer = null;
                }
                countDownTimer.cancel();
                return;
            }
            return;
        }
        this.binding.hudTaximeterLayout.getRoot().setVisibility(0);
    }

    private final void startTaxiTimerCountUp(int i) {
        CountDownTimer countDownTimer = null;
        if (this.isRunningTaxiTimer) {
            this.isRunningTaxiTimer = false;
            CountDownTimer countDownTimer2 = this.taximeterTimer;
            if (countDownTimer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("taximeterTimer");
                countDownTimer2 = null;
            }
            countDownTimer2.cancel();
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = RangesKt.coerceAtMost(i, 3599);
        final long j = (3600 - intRef.element) * 1000;
        this.taximeterTimer = new CountDownTimer(j) { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$startTaxiTimerCountUp$1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                String formatTime;
                HudPageBinding hudPageBinding;
                HudPageBinding hudPageBinding2;
                if (Ref.IntRef.this.element < r2) {
                    formatTime = this.formatTime(Ref.IntRef.this.element * 1000);
                    Log.d("taximeter", "onTickUp: " + formatTime);
                    hudPageBinding = this.binding;
                    String str = formatTime;
                    hudPageBinding.hudTaximeterLayout.hudTaximeterLayoutContainer.tvTaximeterTime.setText(str);
                    hudPageBinding2 = this.binding;
                    hudPageBinding2.hudTaximeterLayout.hudTaximeterArmySecond.tvArmySecondTimer.setText(str);
                    Ref.IntRef.this.element++;
                    return;
                }
                onFinish();
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                String formatTime;
                HudPageBinding hudPageBinding;
                HudPageBinding hudPageBinding2;
                this.isRunningTaxiTimer = false;
                formatTime = this.formatTime(Ref.IntRef.this.element * 1000);
                hudPageBinding = this.binding;
                String str = formatTime;
                hudPageBinding.hudTaximeterLayout.hudTaximeterLayoutContainer.tvTaximeterTime.setText(str);
                hudPageBinding2 = this.binding;
                hudPageBinding2.hudTaximeterLayout.hudTaximeterArmySecond.tvArmySecondTimer.setText(str);
            }
        };
        String formatTime = formatTime(intRef.element * 1000);
        this.binding.hudTaximeterLayout.hudTaximeterLayoutContainer.tvTaximeterTime.setText(formatTime);
        this.binding.hudTaximeterLayout.hudTaximeterArmySecond.tvArmySecondTimer.setText(formatTime);
        this.isRunningTaxiTimer = true;
        CountDownTimer countDownTimer3 = this.taximeterTimer;
        if (countDownTimer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taximeterTimer");
        } else {
            countDownTimer = countDownTimer3;
        }
        countDownTimer.start();
    }

    private final void startTaxiTimerCountdown(int i) {
        CountDownTimer countDownTimer = null;
        if (this.isRunningTaxiTimer) {
            this.isRunningTaxiTimer = false;
            CountDownTimer countDownTimer2 = this.taximeterTimer;
            if (countDownTimer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("taximeterTimer");
                countDownTimer2 = null;
            }
            countDownTimer2.cancel();
        }
        final long j = i * 1000;
        this.taximeterTimer = new CountDownTimer(j) { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$startTaxiTimerCountdown$1
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                String formatTime;
                HudPageBinding hudPageBinding;
                String formatTime2;
                HudPageBinding hudPageBinding2;
                String formatTime3;
                formatTime = Hud.this.formatTime(j2);
                Log.d("taximeter", "onTickDownTick: " + formatTime);
                hudPageBinding = Hud.this.binding;
                TextView textView = hudPageBinding.hudTaximeterLayout.hudTaximeterLayoutContainer.tvTaximeterTime;
                formatTime2 = Hud.this.formatTime(j2);
                textView.setText(formatTime2);
                hudPageBinding2 = Hud.this.binding;
                TextView textView2 = hudPageBinding2.hudTaximeterLayout.hudTaximeterArmySecond.tvArmySecondTimer;
                formatTime3 = Hud.this.formatTime(j2);
                textView2.setText(formatTime3);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                Hud.this.isRunningTaxiTimer = false;
            }
        };
        this.binding.hudTaximeterLayout.hudTaximeterLayoutContainer.tvTaximeterTime.setText(formatTime(j));
        this.binding.hudTaximeterLayout.hudTaximeterArmySecond.tvArmySecondTimer.setText(formatTime(j));
        this.isRunningTaxiTimer = true;
        CountDownTimer countDownTimer3 = this.taximeterTimer;
        if (countDownTimer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taximeterTimer");
        } else {
            countDownTimer = countDownTimer3;
        }
        countDownTimer.start();
    }

    private final void stopTaxiTimer(int i) {
        this.isRunningTaxiTimer = false;
        CountDownTimer countDownTimer = this.taximeterTimer;
        if (countDownTimer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taximeterTimer");
            countDownTimer = null;
        }
        countDownTimer.cancel();
        long j = i * 1000;
        this.binding.hudTaximeterLayout.hudTaximeterLayoutContainer.tvTaximeterTime.setText(formatTime(j));
        this.binding.hudTaximeterLayout.hudTaximeterArmySecond.tvArmySecondTimer.setText(formatTime(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatTime(long j) {
        long j2 = j / 1000;
        long j3 = 60;
        long j4 = j2 / j3;
        long j5 = j2 % j3;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j4), Long.valueOf(j5)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    private final void setTaximeterType(int i) {
        ImageView ivGoalsIcon = this.binding.hudTaximeterLayout.hudTaximeterArmySecond.ivGoalsIcon;
        Intrinsics.checkNotNullExpressionValue(ivGoalsIcon, "ivGoalsIcon");
        ivGoalsIcon.setVisibility(8);
        this.typeTaximeterValue = TypeTaximeterValue.PRISE;
        HudTaximeterContainerBinding hudTaximeterContainerBinding = this.binding.hudTaximeterLayout.hudTaximeterLayoutContainer;
        ImageView ivDopIcon = hudTaximeterContainerBinding.ivDopIcon;
        Intrinsics.checkNotNullExpressionValue(ivDopIcon, "ivDopIcon");
        ivDopIcon.setVisibility(8);
        TypeTaximeter valueOf = TypeTaximeter.Companion.valueOf(i);
        hudTaximeterContainerBinding.btnNext.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.setTaximeterType$lambda$28$lambda$25(Hud.this, view);
            }
        });
        LinearLayout root = hudTaximeterContainerBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        FrameLayout root2 = this.binding.hudTaximeterLayout.hudTaximeterArmySecond.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        root2.setVisibility(8);
        switch (WhenMappings.$EnumSwitchMapping$1[valueOf.ordinal()]) {
            case 1:
                setTaximeterLayoutType$default(this, R.drawable.bg_taximeter_sum, R.drawable.bg_taximeter_time, R.drawable.bg_taximeter_sum, "#FFDD28", null, "#000000", false, R.font.ds_digital, 80, null);
                return;
            case 2:
                setTaximeterLayoutType$default(this, R.drawable.bg_taximeter_bus_sum, R.drawable.bg_taximeter_bus_time, R.drawable.bg_taximeter_bus_sum, "#28D8FF", null, "#000000", false, R.font.ds_digital, 80, null);
                return;
            case 3:
                setTaximeterLayoutType$default(this, R.drawable.bg_taximeter_truck_sum, R.drawable.bg_taximeter_truck_time, R.drawable.bg_taximeter_truck_sum, "#ADFF2F", null, "#000000", false, R.font.ds_digital, 80, null);
                return;
            case 4:
                setTaximeterLayoutType$default(this, R.drawable.bg_taximeter_delivery_summ, R.drawable.bg_taximeter_delivery_time, R.drawable.bg_taximeter_delivery_summ, "#FF2372", null, "#000000", false, R.font.ds_digital, 80, null);
                return;
            case 5:
                setTaximeterLayoutType$default(this, R.drawable.bg_taximeter_drift_summ, R.drawable.bg_taximeter_drift_time, R.drawable.bg_taximeter_drift_summ, "#FF5900", null, "#000000", false, R.font.ds_digital, 80, null);
                return;
            case 6:
                setTaximeterLayoutType$default(this, R.drawable.bg_taximeter_halloween_summ, R.drawable.bg_taximeter_halloween_time, R.drawable.bg_taximeter_halloween_summ, "#FF0000", null, "#000000", false, R.font.ds_digital, 80, null);
                return;
            case 7:
                LinearLayout root3 = hudTaximeterContainerBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root3, "getRoot(...)");
                root3.setVisibility(8);
                setDemorganType$default(this, R.drawable.hud_taximeter_stopwatch_demorgan_logo, R.drawable.hud_taximeter_stopwatch_demorgan_second_bg, R.drawable.hud_taximeter_stopwatch_demorgan_bg, "#FF4343", 0, false, 48, null);
                return;
            case 8:
                LinearLayout root4 = hudTaximeterContainerBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root4, "getRoot(...)");
                root4.setVisibility(8);
                setDemorganType$default(this, R.drawable.hud_taximeter_stopwatch_army_logo, R.drawable.hud_taximeter_stopwatch_army_second_bg, R.drawable.hud_taximeter_stopwatch_army_bg, "#75D100", 0, false, 48, null);
                return;
            case 9:
                LinearLayout root5 = hudTaximeterContainerBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root5, "getRoot(...)");
                root5.setVisibility(8);
                setDemorganType(R.drawable.hud_taximeter_stopwatch_easter_relay_logo, R.drawable.hud_taximeter_stopwatch_easter_relay_second_bg, R.drawable.hud_taximeter_stopwatch_easter_relay_bg, "#FFFFFF", R.font.harreegh_popped_cyrillic, true);
                return;
            case 10:
                this.typeTaximeterValue = TypeTaximeterValue.PERCENT;
                ImageView imageView = hudTaximeterContainerBinding.ivDopIcon;
                imageView.setImageResource(R.drawable.hud_taximeter_farmer_health_heart_icon);
                Intrinsics.checkNotNull(imageView);
                imageView.setVisibility(0);
                setTaximeterLayoutType$default(this, R.drawable.hud_taximeter_farmer_health_sum, R.drawable.hud_taximeter_farmer_health_time, R.drawable.hud_taximeter_farmer_health_bg, "#FFFFFF", "Здоровье", null, false, 0, 160, null);
                return;
            case 11:
                this.typeTaximeterValue = TypeTaximeterValue.TEXT;
                ImageView imageView2 = hudTaximeterContainerBinding.ivDopIcon;
                imageView2.setImageResource(R.drawable.hud_taximeter_stopwatch_soccer_goals_icon);
                Intrinsics.checkNotNull(imageView2);
                imageView2.setVisibility(0);
                setTaximeterLayoutType$default(this, R.drawable.hud_taximeter_soccer_goals_sum, R.drawable.hud_taximeter_soccer_goals_time, R.drawable.hud_taximeter_soccer_goals_bg, "#FFFFFF", "Голов", null, false, 0, 160, null);
                return;
            case 12:
                this.typeTaximeterValue = TypeTaximeterValue.PERCENT;
                setTaximeterLayoutType$default(this, R.drawable.hud_taximeter_easter_chicken_summ, R.drawable.hud_taximeter_easter_chicken_time, R.drawable.hud_taximeter_easter_chicken_bg, "#D0FFFA", "Состояние прицепа", null, false, 0, 160, null);
                return;
            case 13:
                this.typeTaximeterValue = TypeTaximeterValue.TEXT;
                setTaximeterLayoutType$default(this, R.drawable.bg_taximeter_bus_sum, R.drawable.bg_taximeter_bus_time, R.drawable.bg_taximeter_bus_sum, "#28D8FF", null, "#000000", false, R.font.ds_digital, 80, null);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTaximeterType$lambda$28$lambda$25(Hud hud, View view) {
        hud.backendNotifier.clickedWrapper(hud.getBackendID(), 10, 8);
    }

    static /* synthetic */ void setTaximeterLayoutType$default(Hud hud, int i, int i2, int i3, String str, String str2, String str3, boolean z, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i3 = R.drawable.bg_taximeter;
        }
        hud.setTaximeterLayoutType(i, i2, i3, str, (i5 & 16) != 0 ? "Сумма" : str2, (i5 & 32) != 0 ? "#FFFFFF" : str3, (i5 & 64) != 0 ? true : z, (i5 & 128) != 0 ? R.font.harreegh_popped_cyrillic : i4);
    }

    private final void setTaximeterLayoutType(int i, int i2, int i3, String str, String str2, String str3, boolean z, int i4) {
        HudTaximeterContainerBinding hudTaximeterContainerBinding = this.binding.hudTaximeterLayout.hudTaximeterLayoutContainer;
        hudTaximeterContainerBinding.priseTimeContainer.setImageResource(i3);
        if (z) {
            hudTaximeterContainerBinding.tvTaximeterSumTitle.setTextSize(ConverterKt.pxToDp(20.0f, getTargetActivity()));
        } else {
            hudTaximeterContainerBinding.tvTaximeterSumTitle.setTextSize(ConverterKt.pxToDp(15.0f, getTargetActivity()));
        }
        Typeface font = ResourcesCompat.getFont(getTargetActivity(), i4);
        hudTaximeterContainerBinding.tvTaximeterTime.setTypeface(font);
        hudTaximeterContainerBinding.tvTaximeterSum.setTypeface(font);
        hudTaximeterContainerBinding.tvTaximeterSumTitle.setTypeface(font);
        hudTaximeterContainerBinding.linearSum.setBackgroundResource(i);
        hudTaximeterContainerBinding.linearTime.setBackgroundResource(i2);
        hudTaximeterContainerBinding.btnNext.setBackgroundResource(i3);
        hudTaximeterContainerBinding.tvTaximeterTime.setTextColor(Color.parseColor(str));
        hudTaximeterContainerBinding.tvTaximeterSum.setTextColor(Color.parseColor(str3));
        hudTaximeterContainerBinding.tvTaximeterSumTitle.setTextColor(Color.parseColor(str3));
        hudTaximeterContainerBinding.tvTaximeterSumTitle.setText(str2);
    }

    static /* synthetic */ void setDemorganType$default(Hud hud, int i, int i2, int i3, String str, int i4, boolean z, int i5, Object obj) {
        if ((i5 & 16) != 0) {
            i4 = R.font.ds_digital;
        }
        int i6 = i4;
        if ((i5 & 32) != 0) {
            z = false;
        }
        hud.setDemorganType(i, i2, i3, str, i6, z);
    }

    private final void setDemorganType(int i, int i2, int i3, String str, int i4, boolean z) {
        HudTaximeterStopwatchBinding hudTaximeterStopwatchBinding = this.binding.hudTaximeterLayout.hudTaximeterArmySecond;
        if (z) {
            ImageView ivBgSmaller = hudTaximeterStopwatchBinding.ivBgSmaller;
            Intrinsics.checkNotNullExpressionValue(ivBgSmaller, "ivBgSmaller");
            ivBgSmaller.setVisibility(8);
            ImageView ivBgBigger = hudTaximeterStopwatchBinding.ivBgBigger;
            Intrinsics.checkNotNullExpressionValue(ivBgBigger, "ivBgBigger");
            ivBgBigger.setVisibility(0);
            hudTaximeterStopwatchBinding.ivBgBigger.setImageResource(i3);
        } else {
            ImageView ivBgBigger2 = hudTaximeterStopwatchBinding.ivBgBigger;
            Intrinsics.checkNotNullExpressionValue(ivBgBigger2, "ivBgBigger");
            ivBgBigger2.setVisibility(8);
            ImageView ivBgSmaller2 = hudTaximeterStopwatchBinding.ivBgSmaller;
            Intrinsics.checkNotNullExpressionValue(ivBgSmaller2, "ivBgSmaller");
            ivBgSmaller2.setVisibility(0);
            hudTaximeterStopwatchBinding.ivBgSmaller.setImageResource(i3);
        }
        Typeface font = ResourcesCompat.getFont(getTargetActivity(), i4);
        this.binding.hudTaximeterLayout.hudTaximeterArmySecond.armySecondTitle.setImageResource(i);
        this.binding.hudTaximeterLayout.hudTaximeterArmySecond.secondContainer.setBackgroundResource(i2);
        this.binding.hudTaximeterLayout.hudTaximeterArmySecond.tvArmySecondTimer.setTextColor(Color.parseColor(str));
        this.binding.hudTaximeterLayout.hudTaximeterArmySecond.tvArmySecondTimer.setTypeface(font);
        FrameLayout root = this.binding.hudTaximeterLayout.hudTaximeterArmySecond.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
    }

    private final void setTrainsVisibility(int i) {
        if (i == 0) {
            this.binding.trainDriverContainer.setVisibility(8);
            CountDownTimer countDownTimer = this.trainTimer;
            if (countDownTimer != null) {
                if (countDownTimer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("trainTimer");
                    countDownTimer = null;
                }
                countDownTimer.cancel();
                return;
            }
            return;
        }
        this.binding.trainDriverContainer.setVisibility(0);
        startTrainTimer(0);
    }

    private final void startTrainTimer(int i) {
        CountDownTimer countDownTimer = this.trainTimer;
        if (countDownTimer != null) {
            if (countDownTimer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("trainTimer");
                countDownTimer = null;
            }
            countDownTimer.cancel();
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = i;
        CountDownTimer countDownTimer2 = new CountDownTimer() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$startTrainTimer$1
            @Override // android.os.CountDownTimer
            public void onFinish() {
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                HudPageBinding hudPageBinding;
                String formatTime;
                hudPageBinding = Hud.this.binding;
                TextView textView = hudPageBinding.trainCurrentTime;
                formatTime = Hud.this.formatTime(intRef.element * 1000);
                textView.setText(formatTime + " ");
                intRef.element++;
            }
        };
        this.trainTimer = countDownTimer2;
        countDownTimer2.start();
    }

    private final void setTrainInfo(Companion.TrainInfo trainInfo) {
        HudPageBinding hudPageBinding = this.binding;
        hudPageBinding.income.setText(trainInfo.getSalary() + "$");
        TextView textView = hudPageBinding.warningsCount;
        int warnings = trainInfo.getWarnings();
        textView.setText(warnings + " / " + trainInfo.getWarningsMax());
        if (trainInfo.getMaxTime() == 0) {
            hudPageBinding.trainMaxTime.setVisibility(8);
        } else {
            hudPageBinding.trainMaxTime.setText("/ " + formatTime(trainInfo.getMaxTime() * 1000));
        }
        String speedLimitType = trainInfo.getSpeedLimitType();
        int hashCode = speedLimitType.hashCode();
        if (hashCode != -1039745817) {
            if (hashCode != 1124446108) {
                if (hashCode == 1952151455 && speedLimitType.equals("critical")) {
                    hudPageBinding.speedLimit.setTextColor(Color.parseColor("#FFFFFF"));
                    hudPageBinding.warningIc.setImageResource(R.drawable.hud_train_critical_speed_limit);
                    hudPageBinding.speedLimit.setText(String.valueOf(trainInfo.getSpeedLimit()));
                }
            } else if (speedLimitType.equals("warning")) {
                hudPageBinding.speedLimit.setTextColor(Color.parseColor("#000000"));
                hudPageBinding.warningIc.setImageResource(R.drawable.hud_train_warning_speed_limit);
                hudPageBinding.speedLimit.setText(String.valueOf(trainInfo.getSpeedLimit()));
            }
        } else if (speedLimitType.equals(com.adjust.sdk.Constants.NORMAL)) {
            hudPageBinding.speedLimit.setTextColor(Color.parseColor("#FFFFFF"));
            hudPageBinding.warningIc.setImageResource(R.drawable.hud_train_normal_speed_limit);
            hudPageBinding.speedLimit.setText(String.valueOf(trainInfo.getSpeedLimit()));
        }
        hudPageBinding.routeProgress.setProgress(trainInfo.getDistance() / trainInfo.getTotalDistance());
        hudPageBinding.maxKm.setText(((int) trainInfo.getTotalDistance()) + "km");
    }

    private final void showInteractionButton(String str) {
        this.binding.interactionButtonContainer.setVisibility(0);
        this.binding.textInteraction.setText(str);
    }

    private final void hideInteractionButton() {
        this.binding.interactionButtonContainer.setVisibility(8);
    }

    private final void showMissionsProgress(String str, List<MissionData> list) {
        this.binding.missionProgressContainer.setVisibility(0);
        this.binding.missionTitle.setText(str);
        this.missionsProgressAdapter.setItems(list);
    }

    private final void hideMissionsProgress() {
        this.missionsProgressAdapter.clear();
        this.binding.missionProgressContainer.setVisibility(8);
    }

    private final void setVip(int i) {
        HudPageBinding hudPageBinding = this.binding;
        if (i == -1) {
            hudPageBinding.vipContainer.setVisibility(0);
            hudPageBinding.vipDays.setText("Навсегда");
        } else if (i == 0) {
            hudPageBinding.vipContainer.setVisibility(8);
        } else {
            hudPageBinding.vipContainer.setVisibility(0);
            hudPageBinding.vipDays.setText(i + " д.");
        }
    }

    private final void setNoticeState(Companion.NoticeInfo noticeInfo) {
        HudPageBinding hudPageBinding = this.binding;
        int type = noticeInfo.getType();
        if (type == Companion.NoticeType.NONE.getId()) {
            hudPageBinding.actionButton.setVisibility(8);
            hudPageBinding.noticeWithoutDescriptionButton.setVisibility(8);
            hudPageBinding.actionNoticeWithoutDescriptionButton.setVisibility(8);
            hudPageBinding.actionNoticeWithDescriptionButton.setVisibility(8);
            hudPageBinding.noticeWithDescriptionButton.setVisibility(8);
        } else if (type == Companion.NoticeType.ACTION_BUTTON.getId()) {
            hudPageBinding.noticeWithoutDescriptionButton.setVisibility(8);
            hudPageBinding.actionNoticeWithoutDescriptionButton.setVisibility(8);
            hudPageBinding.actionNoticeWithDescriptionButton.setVisibility(8);
            hudPageBinding.noticeWithDescriptionButton.setVisibility(8);
            hudPageBinding.actionButton.setVisibility(0);
            hudPageBinding.actionButtonTxt.setText(noticeInfo.getKeyText());
            EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
            ConstraintLayout actionButton = hudPageBinding.actionButton;
            Intrinsics.checkNotNullExpressionValue(actionButton, "actionButton");
            EasyAnimation.animateClick$default(easyAnimation, actionButton, 0L, null, new Function0() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit noticeState$lambda$36$lambda$33;
                    noticeState$lambda$36$lambda$33 = Hud.setNoticeState$lambda$36$lambda$33(Hud.this);
                    return noticeState$lambda$36$lambda$33;
                }
            }, 3, null);
        } else if (type == Companion.NoticeType.NOTICE_WITHOUT_DESCRIPTION.getId()) {
            hudPageBinding.actionButton.setVisibility(8);
            hudPageBinding.actionNoticeWithoutDescriptionButton.setVisibility(8);
            hudPageBinding.actionNoticeWithDescriptionButton.setVisibility(8);
            hudPageBinding.noticeWithDescriptionButton.setVisibility(8);
            hudPageBinding.noticeWithoutDescriptionButton.setVisibility(0);
            hudPageBinding.noticeWithoutDescriptionButtonTitle.setText(noticeInfo.getKeyText());
        } else if (type == Companion.NoticeType.ACTION_NOTICE_WITHOUT_DESCRIPTION.getId()) {
            hudPageBinding.actionButton.setVisibility(8);
            hudPageBinding.noticeWithoutDescriptionButton.setVisibility(8);
            hudPageBinding.actionNoticeWithDescriptionButton.setVisibility(8);
            hudPageBinding.noticeWithDescriptionButton.setVisibility(8);
            hudPageBinding.actionNoticeWithoutDescriptionButton.setVisibility(0);
            hudPageBinding.actionNoticeWithoutDescriptionButtonTitle.setText(noticeInfo.getTitle());
            hudPageBinding.actionNoticeWithoutDescriptionButtonText.setText(noticeInfo.getKeyText());
            EasyAnimation easyAnimation2 = EasyAnimation.INSTANCE;
            ConstraintLayout actionNoticeWithoutDescriptionButtonClick = hudPageBinding.actionNoticeWithoutDescriptionButtonClick;
            Intrinsics.checkNotNullExpressionValue(actionNoticeWithoutDescriptionButtonClick, "actionNoticeWithoutDescriptionButtonClick");
            EasyAnimation.animateClick$default(easyAnimation2, actionNoticeWithoutDescriptionButtonClick, 0L, null, new Function0() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit noticeState$lambda$36$lambda$34;
                    noticeState$lambda$36$lambda$34 = Hud.setNoticeState$lambda$36$lambda$34(Hud.this);
                    return noticeState$lambda$36$lambda$34;
                }
            }, 3, null);
        } else if (type == Companion.NoticeType.ACTION_NOTICE_WITH_DESCRIPTION.getId()) {
            hudPageBinding.actionButton.setVisibility(8);
            hudPageBinding.noticeWithoutDescriptionButton.setVisibility(8);
            hudPageBinding.actionNoticeWithoutDescriptionButton.setVisibility(8);
            hudPageBinding.noticeWithDescriptionButton.setVisibility(8);
            hudPageBinding.actionNoticeWithDescriptionButton.setVisibility(0);
            hudPageBinding.actionNoticeWithDescriptionTitle.setText(noticeInfo.getTitle());
            hudPageBinding.actionNoticeWithDescriptionDescription.setText(noticeInfo.getText());
            hudPageBinding.actionNoticeWithDescriptionButtonText.setText(noticeInfo.getKeyText());
            EasyAnimation easyAnimation3 = EasyAnimation.INSTANCE;
            ConstraintLayout actionNoticeWithDescriptionButtonClick = hudPageBinding.actionNoticeWithDescriptionButtonClick;
            Intrinsics.checkNotNullExpressionValue(actionNoticeWithDescriptionButtonClick, "actionNoticeWithDescriptionButtonClick");
            EasyAnimation.animateClick$default(easyAnimation3, actionNoticeWithDescriptionButtonClick, 0L, null, new Function0() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit noticeState$lambda$36$lambda$35;
                    noticeState$lambda$36$lambda$35 = Hud.setNoticeState$lambda$36$lambda$35(Hud.this);
                    return noticeState$lambda$36$lambda$35;
                }
            }, 3, null);
        } else if (type == Companion.NoticeType.NOTICE_WITH_DESCRIPTION.getId()) {
            hudPageBinding.actionButton.setVisibility(8);
            hudPageBinding.noticeWithoutDescriptionButton.setVisibility(8);
            hudPageBinding.actionNoticeWithoutDescriptionButton.setVisibility(8);
            hudPageBinding.actionNoticeWithDescriptionButton.setVisibility(8);
            hudPageBinding.noticeWithDescriptionButton.setVisibility(0);
            hudPageBinding.noticeWithDescriptionTitle.setText(noticeInfo.getTitle());
            hudPageBinding.noticeWithDescriptionDescription.setText(noticeInfo.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setNoticeState$lambda$36$lambda$33(Hud hud) {
        hud.backendNotifier.clickedWrapper(hud.getBackendID(), 7, -1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setNoticeState$lambda$36$lambda$34(Hud hud) {
        hud.backendNotifier.clickedWrapper(hud.getBackendID(), 7, -1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setNoticeState$lambda$36$lambda$35(Hud hud) {
        hud.backendNotifier.clickedWrapper(hud.getBackendID(), 7, -1);
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Log.d("HUD", "onBackendMessage: " + data + ", subId: " + i);
        if (i == 0) {
            setXPayDay(Integer.parseInt(data));
            return;
        }
        if (i == 1) {
            updateRouletteInfo(Integer.parseInt(data));
        } else if (i == 2) {
            updateRouletteInfoText(data);
        } else if (i == 3) {
            updateMainRouletteText(data);
        } else if (i == 4) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(data));
                if (getTargetActivity().getPackageManager().resolveActivity(intent, 65536) != null) {
                    getTargetActivity().startActivity(intent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (i == 5) {
                ConstraintLayout trainSettings = this.binding.trainSettings;
                Intrinsics.checkNotNullExpressionValue(trainSettings, "trainSettings");
                trainSettings.setVisibility(Integer.parseInt(data) == 1 ? 0 : 8);
            } else if (i == 6) {
                if (Integer.parseInt(data) == 1) {
                    this.binding.ivDoorsState.setImageResource(R.drawable.ic_switch_on);
                } else {
                    this.binding.ivDoorsState.setImageResource(R.drawable.ic_switch_none);
                }
            } else if (i == 7) {
                setTaximeterVisibility(data);
            } else if (i == 8) {
                setTaxiPrice(data);
            } else if (i == 9) {
                setTaximeterCounterType(data, false);
            } else if (i == 10) {
                setTaximeterType(Integer.parseInt(data));
            } else if (i == 11) {
                setTrainsVisibility(Integer.parseInt(data));
            } else if (i == 12) {
                setTrainInfo((Companion.TrainInfo) MapperKt.toModel(data, Companion.TrainInfo.class));
            } else if (i == 13) {
                startTrainTimer(Integer.parseInt(data));
            } else if (i == 14) {
                setVip(Integer.parseInt(data));
            } else if (i == 15) {
                setNoticeState((Companion.NoticeInfo) MapperKt.toModel(data, Companion.NoticeInfo.class));
            } else if (i == BackendHudIds.SHOW_MISSIONS_PROGRESS.getSubId()) {
                List listModel = MapperKt.toListModel(data, MissionGroupData.class);
                if (listModel.isEmpty()) {
                    return;
                }
                MissionGroupData missionGroupData = (MissionGroupData) listModel.get(0);
                showMissionsProgress(missionGroupData.getTitle(), missionGroupData.getQuests());
            } else if (i == BackendHudIds.HIDE_MISSIONS_PROGRESS.getSubId()) {
                hideMissionsProgress();
            } else if (i == BackendHudIds.SHOW_INTERACTION_BUTTON.getSubId()) {
                InteractionData interactionData = (InteractionData) MapperKt.toModel(data, InteractionData.class);
                this.interactionButtonId = interactionData.getId();
                showInteractionButton(interactionData.getText());
            } else if (i == BackendHudIds.HIDE_INTERACTION_BUTTON.getSubId()) {
                hideInteractionButton();
            } else if (i == BackendHudIds.SHOW_ROULETTE.getSubId()) {
                showRouletteUi();
            } else if (i == BackendHudIds.HIDE_ROULETTE.getSubId()) {
                hideRouletteUi();
            } else if (i == BackendHudIds.OVERLAY_SHOW.getSubId()) {
                showOverlay(Integer.parseInt(data));
            } else if (i == BackendHudIds.OVERLAY_HIDE.getSubId()) {
                hideOverlay(Integer.parseInt(data));
            } else if (i == BackendHudIds.TAXITIMER_COUNTDOUWN.getSubId()) {
                setTaximeterCounterType(data, true);
            } else if (i == BackendHudIds.TAXITIMER_STOP.getSubId()) {
                stopTaxiTimer(Integer.parseInt(data));
            } else if (i == BackendHudIds.PROGRESS_BAR_SHOW.getSubId()) {
                showProgressBar(data);
            } else if (i == BackendHudIds.PROGRESS_BAR_HIDE.getSubId()) {
                hideProgressBar();
            } else if (i == BackendHudIds.PROGRESS_BAR_SET_DATA.getSubId()) {
                setDataProgressBar((ProgressBarModel) MapperKt.toModel(data, ProgressBarModel.class));
            } else if (i != BackendHudIds.KAPT_ZERO.getSubId()) {
                if (i == BackendHudIds.KAPT_ONE.getSubId()) {
                    ConstraintLayout root = this.binding.hudKaptScreen.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                    root.setVisibility(0);
                    if (Integer.parseInt(data) == 0) {
                        RodinaKaptScreenBinding rodinaKaptScreenBinding = this.binding.hudKaptScreen;
                        rodinaKaptScreenBinding.textView42Top.setVisibility(8);
                        rodinaKaptScreenBinding.rodinaKaptTimeRemainingTop.setVisibility(8);
                        rodinaKaptScreenBinding.textView42.setVisibility(0);
                        rodinaKaptScreenBinding.rodinaKaptTimeRemaining.setVisibility(0);
                        Intrinsics.checkNotNull(rodinaKaptScreenBinding);
                    } else if (Integer.parseInt(data) == 2) {
                        ConstraintLayout root2 = this.binding.hudKaptScreen.getRoot();
                        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
                        root2.setVisibility(8);
                    } else {
                        RodinaKaptScreenBinding rodinaKaptScreenBinding2 = this.binding.hudKaptScreen;
                        rodinaKaptScreenBinding2.textView42.setVisibility(8);
                        rodinaKaptScreenBinding2.rodinaKaptTimeRemaining.setVisibility(8);
                        rodinaKaptScreenBinding2.textView42Top.setVisibility(0);
                        rodinaKaptScreenBinding2.rodinaKaptTimeRemainingTop.setVisibility(0);
                        Intrinsics.checkNotNull(rodinaKaptScreenBinding2);
                    }
                } else if (i == BackendHudIds.PROPOSAL_SCREEN.getSubId()) {
                    HudProposalScreen.ProposalResponse proposalResponse = (HudProposalScreen.ProposalResponse) MapperKt.toModel(data, HudProposalScreen.ProposalResponse.class);
                    HudProposalScreen hudProposalScreen = HudProposalScreen.INSTANCE;
                    if (proposalResponse.getId() >= 0) {
                        ConstraintLayout root3 = this.binding.hudProposalScreen.getRoot();
                        Intrinsics.checkNotNullExpressionValue(root3, "getRoot(...)");
                        root3.setVisibility(0);
                        HudProposalScreenBinding hudProposalScreen2 = this.binding.hudProposalScreen;
                        Intrinsics.checkNotNullExpressionValue(hudProposalScreen2, "hudProposalScreen");
                        hudProposalScreen.showProposalScreen(hudProposalScreen2, proposalResponse, new Function1() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit onBackendMessage$lambda$40;
                                onBackendMessage$lambda$40 = Hud.onBackendMessage$lambda$40(Hud.this, ((Integer) obj).intValue());
                                return onBackendMessage$lambda$40;
                            }
                        });
                        return;
                    }
                    ConstraintLayout root4 = this.binding.hudProposalScreen.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root4, "getRoot(...)");
                    root4.setVisibility(8);
                    hudProposalScreen.stopTimer();
                } else if (i == BackendHudIds.UNREAD_MESSAGE_COUNT.getSubId()) {
                    UnreadMessageModel unreadMessageModel = (UnreadMessageModel) MapperKt.toModel(data, UnreadMessageModel.class);
                    if (unreadMessageModel.getUnreadMessengerMessages() > 0) {
                        FrameLayout unreadMeassageContainer = this.binding.unreadMeassageContainer;
                        Intrinsics.checkNotNullExpressionValue(unreadMeassageContainer, "unreadMeassageContainer");
                        unreadMeassageContainer.setVisibility(0);
                        this.binding.tvMessageCount.setText(String.valueOf(unreadMessageModel.getUnreadMessengerMessages()));
                        return;
                    }
                    FrameLayout unreadMeassageContainer2 = this.binding.unreadMeassageContainer;
                    Intrinsics.checkNotNullExpressionValue(unreadMeassageContainer2, "unreadMeassageContainer");
                    unreadMeassageContainer2.setVisibility(8);
                } else if (i == BackendHudIds.UNREAD_MESSAGE_COUNT.getSubId()) {
                    UnreadMessageModel unreadMessageModel2 = (UnreadMessageModel) MapperKt.toModel(data, UnreadMessageModel.class);
                    if (unreadMessageModel2.getUnreadMessengerMessages() > 0) {
                        FrameLayout unreadMeassageContainer3 = this.binding.unreadMeassageContainer;
                        Intrinsics.checkNotNullExpressionValue(unreadMeassageContainer3, "unreadMeassageContainer");
                        unreadMeassageContainer3.setVisibility(0);
                        this.binding.tvMessageCount.setText(String.valueOf(unreadMessageModel2.getUnreadMessengerMessages()));
                        return;
                    }
                    FrameLayout unreadMeassageContainer4 = this.binding.unreadMeassageContainer;
                    Intrinsics.checkNotNullExpressionValue(unreadMeassageContainer4, "unreadMeassageContainer");
                    unreadMeassageContainer4.setVisibility(8);
                } else if (i == BackendHudIds.UPDATE_MONEY.getSubId()) {
                    updateMoney(Long.parseLong(data));
                    Activity targetActivity = getTargetActivity();
                    Intrinsics.checkNotNull(targetActivity, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.hud.presentation.Hud.HudListener");
                    ((HudListener) targetActivity).hudUpdateMoney(Long.parseLong(data));
                } else if (i == BackendHudIds.SHOW_IMPROVING_SKILLS.getSubId()) {
                    HudImprovingSkills hudImprovingSkills = HudImprovingSkills.INSTANCE;
                    HudImprovingSkillsBinding improvingSkills = this.binding.improvingSkills;
                    Intrinsics.checkNotNullExpressionValue(improvingSkills, "improvingSkills");
                    LinearLayout root5 = this.binding.improvingSkills.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root5, "getRoot(...)");
                    root5.setVisibility(0);
                    hudImprovingSkills.showImprovingSkills(improvingSkills, data);
                } else if (i == BackendHudIds.HIDE_IMPROVING_SKILLS.getSubId()) {
                    LinearLayout root6 = this.binding.improvingSkills.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root6, "getRoot(...)");
                    root6.setVisibility(8);
                } else if (i == BackendHudIds.SHOW_TIMER.getSubId()) {
                    HudTimer hudTimer = HudTimer.INSTANCE;
                    HudTimerBinding timer = this.binding.timer;
                    Intrinsics.checkNotNullExpressionValue(timer, "timer");
                    LinearLayout root7 = this.binding.timer.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root7, "getRoot(...)");
                    root7.setVisibility(0);
                    hudTimer.showTimer(timer, data);
                } else if (i == BackendHudIds.HIDE_TIMER.getSubId()) {
                    LinearLayout root8 = this.binding.timer.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root8, "getRoot(...)");
                    root8.setVisibility(8);
                } else if (i == BackendHudIds.SHOW_WALKIE_TALKIE.getSubId()) {
                    ImageView root9 = this.binding.walkieTalkie.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root9, "getRoot(...)");
                    root9.setVisibility(0);
                } else if (i == BackendHudIds.HIDE_WALKIE_TALKIE.getSubId()) {
                    ImageView root10 = this.binding.walkieTalkie.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root10, "getRoot(...)");
                    root10.setVisibility(8);
                } else if (i == BackendHudIds.GROUP_BUTTON_VISIBILITY.getSubId()) {
                    Integer intOrNull = StringsKt.toIntOrNull(data);
                    setGroupButtonVisibility(intOrNull != null ? intOrNull.intValue() : 0);
                } else if (i == BackendHudIds.GROUP_INIT_DATA.getSubId()) {
                    setGroupData(MapperKt.toListModel(data, GroupItem.class));
                } else if (i == BackendHudIds.GROUP_UPDATE_DATA.getSubId()) {
                    updateGroupData(MapperKt.toListModel(data, GroupItem.class));
                } else if (i == BackendHudIds.GROUP_DELETE_ITEM.getSubId()) {
                    Integer intOrNull2 = StringsKt.toIntOrNull(data);
                    deleteGroupMember(intOrNull2 != null ? intOrNull2.intValue() : -1);
                } else if (i == BackendHudIds.GROUP_ADD_ITEM.getSubId()) {
                    addGroupMember((GroupItem) MapperKt.toModel(data, GroupItem.class));
                } else if (i == BackendHudIds.SET_SERVER_ID.getSubId()) {
                    setServerID((ServerInfoItem) MapperKt.toModel(data, ServerInfoItem.class));
                } else if (i == BackendHudIds.BANNER_INIT.getSubId()) {
                    this.bannerElement.initializeBanner(data);
                } else if (i == BackendHudIds.BANNER_SET_TYPE.getSubId()) {
                    this.bannerElement.setTypeBanner(data);
                } else if (i == BackendHudIds.BANNER_VISIBILITY.getSubId()) {
                    this.bannerElement.setVisible(data);
                    hideRouletteUi();
                } else if (i == BackendHudIds.LOCATION_VISIBILITY.getSubId()) {
                    setLocationVisibility(data);
                } else if (i == BackendHudIds.CAPT.getSubId()) {
                    HudCapt hudCapt = HudCapt.INSTANCE;
                    HudCaptBinding capt = this.binding.capt;
                    Intrinsics.checkNotNullExpressionValue(capt, "capt");
                    hudCapt.showCapt(capt, data);
                }
            } else {
                Object fromJson = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) KaptData.class);
                Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
                KaptData kaptData = (KaptData) fromJson;
                ConstraintLayout root11 = this.binding.hudKaptScreen.getRoot();
                Intrinsics.checkNotNullExpressionValue(root11, "getRoot(...)");
                root11.setVisibility(0);
                RodinaKaptScreenBinding rodinaKaptScreenBinding3 = this.binding.hudKaptScreen;
                rodinaKaptScreenBinding3.rodinaKaptLeftGangName.setText(kaptData.getLeftGang().getName());
                rodinaKaptScreenBinding3.rodinaKaptRightGangName.setText(kaptData.getRightGang().getName());
                rodinaKaptScreenBinding3.rodinaKaptLeftGangFragCountValue.setText(String.valueOf(kaptData.getLeftGang().getKills()));
                rodinaKaptScreenBinding3.rodinaKaptRightGangFragCountValue.setText(String.valueOf(kaptData.getRightGang().getKills()));
                rodinaKaptScreenBinding3.rodinaKaptLeftGangFragCountBg.setColorFilter(kaptData.getLeftGang().getColorInt(), PorterDuff.Mode.SRC_OVER);
                rodinaKaptScreenBinding3.rodinaKaptLeftGangFlag.setColorFilter(kaptData.getLeftGang().getColorInt(), PorterDuff.Mode.SRC_OVER);
                rodinaKaptScreenBinding3.rodinaKaptRightGangFragCountBg.setColorFilter(kaptData.getRightGang().getColorInt(), PorterDuff.Mode.SRC_OVER);
                rodinaKaptScreenBinding3.rodinaKaptRightGangFlag.setColorFilter(kaptData.getRightGang().getColorInt(), PorterDuff.Mode.SRC_OVER);
                this.handler.removeCallbacksAndMessages(null);
                this.remainedTime = kaptData.getTime();
                showTimer();
                scheduleUpdateTimer();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBackendMessage$lambda$40(Hud hud, int i) {
        hud.backendNotifier.clickedWrapper(hud.getBackendID(), i, BackendHudIds.PROPOSAL_SCREEN_SEND_STATUS.getSubId());
        return Unit.INSTANCE;
    }

    private final void setLocationVisibility(String str) {
        Integer intOrNull = StringsKt.toIntOrNull(str);
        if ((intOrNull != null ? intOrNull.intValue() : 0) == 0) {
            HudPageBinding hudPageBinding = this.binding;
            hudPageBinding.locationContainer.setVisibility(4);
            hudPageBinding.bgForLocation.setVisibility(4);
            return;
        }
        HudPageBinding hudPageBinding2 = this.binding;
        hudPageBinding2.locationContainer.setVisibility(0);
        hudPageBinding2.bgForLocation.setVisibility(0);
    }

    private final void setServerID(ServerInfoItem serverInfoItem) {
        this.sharedPref.edit().putInt("server_id", serverInfoItem.getServer()).putString("api_token", serverInfoItem.getToken()).apply();
    }

    private final void setGroupButtonVisibility(int i) {
        this.binding.groupButton.setVisibility(i == 1 ? 0 : 8);
        this.groupAdapter.clearList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeGroupTableVisibility() {
        boolean z = this.isGroupButtonPressed;
        this.isGroupButtonPressed = !z;
        SAMPUIElement.notifyClick$default(this, !z ? 51 : 50, 56, null, 4, null);
        this.binding.groupRv.setVisibility(this.isGroupButtonPressed ? 0 : 8);
    }

    private final void setGroupData(List<GroupItem> list) {
        this.groupAdapter.addAllItems(list);
    }

    private final void updateGroupData(List<GroupItem> list) {
        this.groupAdapter.updateList(list);
    }

    private final void deleteGroupMember(int i) {
        this.groupAdapter.deleteItem(i);
    }

    private final void addGroupMember(GroupItem groupItem) {
        this.groupAdapter.addItem(groupItem);
    }

    private final void setTaximeterCounterType(String str, boolean z) {
        if (!this.isArizonaType) {
            this.binding.hudTaximeterLayout.hudTaximeterLayoutContainer.tvTaximeterTime.setText(formatTime(Long.parseLong(str) * 1000));
            this.binding.hudTaximeterLayout.hudTaximeterArmySecond.tvArmySecondTimer.setText(formatTime(Long.parseLong(str) * 1000));
        } else if (z) {
            startTaxiTimerCountdown(Integer.parseInt(str));
        } else {
            startTaxiTimerCountUp(Integer.parseInt(str));
        }
    }

    private final void showTimer() {
        TextView textView = this.binding.hudKaptScreen.rodinaKaptTimeRemaining;
        int i = this.remainedTime;
        textView.setText((i / 60) + StringUtils.PROCESS_POSTFIX_DELIMITER + (i % 60));
        TextView textView2 = this.binding.hudKaptScreen.rodinaKaptTimeRemainingTop;
        int i2 = this.remainedTime;
        textView2.setText((i2 / 60) + StringUtils.PROCESS_POSTFIX_DELIMITER + (i2 % 60));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTimer() {
        showTimer();
        int i = this.remainedTime - 1;
        this.remainedTime = i;
        if (i > 0) {
            scheduleUpdateTimer();
        }
    }

    private final void scheduleUpdateTimer() {
        this.handler.postDelayed(new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$scheduleUpdateTimer$$inlined$postDelayed$default$1
            @Override // java.lang.Runnable
            public final void run() {
                Hud.this.updateTimer();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Hud.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\f¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/Hud$KaptGang;", "", "name", "", "kills", "", "color", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getName", "()Ljava/lang/String;", "getKills", "()I", "getColor", "colorInt", "getColorInt", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class KaptGang {
        private final String color;
        private final int kills;
        private final String name;

        public static /* synthetic */ KaptGang copy$default(KaptGang kaptGang, String str, int i, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = kaptGang.name;
            }
            if ((i2 & 2) != 0) {
                i = kaptGang.kills;
            }
            if ((i2 & 4) != 0) {
                str2 = kaptGang.color;
            }
            return kaptGang.copy(str, i, str2);
        }

        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.kills;
        }

        public final String component3() {
            return this.color;
        }

        public final KaptGang copy(String name, int i, String color) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(color, "color");
            return new KaptGang(name, i, color);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof KaptGang) {
                KaptGang kaptGang = (KaptGang) obj;
                return Intrinsics.areEqual(this.name, kaptGang.name) && this.kills == kaptGang.kills && Intrinsics.areEqual(this.color, kaptGang.color);
            }
            return false;
        }

        public int hashCode() {
            return (((this.name.hashCode() * 31) + Integer.hashCode(this.kills)) * 31) + this.color.hashCode();
        }

        public String toString() {
            String str = this.name;
            int i = this.kills;
            return "KaptGang(name=" + str + ", kills=" + i + ", color=" + this.color + ")";
        }

        public KaptGang(String name, int i, String color) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(color, "color");
            this.name = name;
            this.kills = i;
            this.color = color;
        }

        public final String getColor() {
            return this.color;
        }

        public final int getKills() {
            return this.kills;
        }

        public final String getName() {
            return this.name;
        }

        public final int getColorInt() {
            return Color.parseColor(this.color);
        }
    }

    /* compiled from: Hud.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/Hud$KaptData;", "", "time", "", "leftGang", "Lru/mrlargha/commonui/elements/hud/presentation/Hud$KaptGang;", "rightGang", "<init>", "(ILru/mrlargha/commonui/elements/hud/presentation/Hud$KaptGang;Lru/mrlargha/commonui/elements/hud/presentation/Hud$KaptGang;)V", "getTime", "()I", "getLeftGang", "()Lru/mrlargha/commonui/elements/hud/presentation/Hud$KaptGang;", "getRightGang", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class KaptData {
        @SerializedName("left_gang")
        private final KaptGang leftGang;
        @SerializedName("right_gang")
        private final KaptGang rightGang;
        private final int time;

        public static /* synthetic */ KaptData copy$default(KaptData kaptData, int i, KaptGang kaptGang, KaptGang kaptGang2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = kaptData.time;
            }
            if ((i2 & 2) != 0) {
                kaptGang = kaptData.leftGang;
            }
            if ((i2 & 4) != 0) {
                kaptGang2 = kaptData.rightGang;
            }
            return kaptData.copy(i, kaptGang, kaptGang2);
        }

        public final int component1() {
            return this.time;
        }

        public final KaptGang component2() {
            return this.leftGang;
        }

        public final KaptGang component3() {
            return this.rightGang;
        }

        public final KaptData copy(int i, KaptGang leftGang, KaptGang rightGang) {
            Intrinsics.checkNotNullParameter(leftGang, "leftGang");
            Intrinsics.checkNotNullParameter(rightGang, "rightGang");
            return new KaptData(i, leftGang, rightGang);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof KaptData) {
                KaptData kaptData = (KaptData) obj;
                return this.time == kaptData.time && Intrinsics.areEqual(this.leftGang, kaptData.leftGang) && Intrinsics.areEqual(this.rightGang, kaptData.rightGang);
            }
            return false;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.time) * 31) + this.leftGang.hashCode()) * 31) + this.rightGang.hashCode();
        }

        public String toString() {
            int i = this.time;
            KaptGang kaptGang = this.leftGang;
            return "KaptData(time=" + i + ", leftGang=" + kaptGang + ", rightGang=" + this.rightGang + ")";
        }

        public KaptData(int i, KaptGang leftGang, KaptGang rightGang) {
            Intrinsics.checkNotNullParameter(leftGang, "leftGang");
            Intrinsics.checkNotNullParameter(rightGang, "rightGang");
            this.time = i;
            this.leftGang = leftGang;
            this.rightGang = rightGang;
        }

        public final int getTime() {
            return this.time;
        }

        public final KaptGang getLeftGang() {
            return this.leftGang;
        }

        public final KaptGang getRightGang() {
            return this.rightGang;
        }
    }

    private final void showProgressBar(String str) {
        HudProgressBarContainerBinding hudProgressBarContainerBinding = this.binding.hudProgressBarLayout;
        hudProgressBarContainerBinding.tvNext.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.showProgressBar$lambda$45$lambda$44(Hud.this, view);
            }
        });
        hudProgressBarContainerBinding.getRoot().setVisibility(0);
        if (this.isArizonaType) {
            TextView tvNext = hudProgressBarContainerBinding.tvNext;
            Intrinsics.checkNotNullExpressionValue(tvNext, "tvNext");
            tvNext.setVisibility(8);
            return;
        }
        TextView tvNext2 = hudProgressBarContainerBinding.tvNext;
        Intrinsics.checkNotNullExpressionValue(tvNext2, "tvNext");
        tvNext2.setVisibility(0);
        hudProgressBarContainerBinding.tvNext.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showProgressBar$lambda$45$lambda$44(Hud hud, View view) {
        hud.backendNotifier.clickedWrapper(hud.getBackendID(), 10, 9);
    }

    private final void hideProgressBar() {
        this.binding.hudProgressBarLayout.getRoot().setVisibility(8);
    }

    private final void setDataProgressBar(ProgressBarModel progressBarModel) {
        FrameLayout barProgress = this.binding.hudProgressBarLayout.barProgress;
        Intrinsics.checkNotNullExpressionValue(barProgress, "barProgress");
        ViewGroup.LayoutParams layoutParams = barProgress.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.matchConstraintPercentWidth = progressBarModel.getProgress() / 100.0f;
        barProgress.setLayoutParams(layoutParams2);
        FrameLayout barTotal = this.binding.hudProgressBarLayout.barTotal;
        Intrinsics.checkNotNullExpressionValue(barTotal, "barTotal");
        ViewGroup.LayoutParams layoutParams3 = barTotal.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        layoutParams4.matchConstraintPercentWidth = progressBarModel.getTotalProgress() / 100.0f;
        barTotal.setLayoutParams(layoutParams4);
    }

    private final void showOverlay(int i) {
        this.binding.overlay.animate().setDuration(i).alpha(0.5f).start();
    }

    private final void hideOverlay(int i) {
        this.binding.overlay.animate().setDuration(i).alpha(0.0f).start();
    }

    private final void hideRouletteUi() {
        HudPageBinding hudPageBinding = this.binding;
        hudPageBinding.rouletteContainer.setVisibility(8);
        hudPageBinding.rouletteTimeContainer.setVisibility(8);
    }

    private final void showRouletteUi() {
        HudPageBinding hudPageBinding = this.binding;
        hudPageBinding.rouletteContainer.setVisibility(0);
        hudPageBinding.rouletteTimeContainer.setVisibility(0);
    }

    /* compiled from: Hud.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/Hud$Companion;", "", "<init>", "()V", "TrainInfo", "NoticeInfo", "NoticeType", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: Hud.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u0006("}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/Hud$Companion$TrainInfo;", "", "salary", "", "maxTime", "speedLimit", "speedLimitType", "", "warningsMax", "warnings", "distance", "", "totalDistance", "<init>", "(IIILjava/lang/String;IIFF)V", "getSalary", "()I", "getMaxTime", "getSpeedLimit", "getSpeedLimitType", "()Ljava/lang/String;", "getWarningsMax", "getWarnings", "getDistance", "()F", "getTotalDistance", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class TrainInfo {
            private final float distance;
            private final int maxTime;
            private final int salary;
            private final int speedLimit;
            private final String speedLimitType;
            private final float totalDistance;
            private final int warnings;
            private final int warningsMax;

            public static /* synthetic */ TrainInfo copy$default(TrainInfo trainInfo, int i, int i2, int i3, String str, int i4, int i5, float f, float f2, int i6, Object obj) {
                if ((i6 & 1) != 0) {
                    i = trainInfo.salary;
                }
                if ((i6 & 2) != 0) {
                    i2 = trainInfo.maxTime;
                }
                if ((i6 & 4) != 0) {
                    i3 = trainInfo.speedLimit;
                }
                if ((i6 & 8) != 0) {
                    str = trainInfo.speedLimitType;
                }
                if ((i6 & 16) != 0) {
                    i4 = trainInfo.warningsMax;
                }
                if ((i6 & 32) != 0) {
                    i5 = trainInfo.warnings;
                }
                if ((i6 & 64) != 0) {
                    f = trainInfo.distance;
                }
                if ((i6 & 128) != 0) {
                    f2 = trainInfo.totalDistance;
                }
                float f3 = f;
                float f4 = f2;
                int i7 = i4;
                int i8 = i5;
                return trainInfo.copy(i, i2, i3, str, i7, i8, f3, f4);
            }

            public final int component1() {
                return this.salary;
            }

            public final int component2() {
                return this.maxTime;
            }

            public final int component3() {
                return this.speedLimit;
            }

            public final String component4() {
                return this.speedLimitType;
            }

            public final int component5() {
                return this.warningsMax;
            }

            public final int component6() {
                return this.warnings;
            }

            public final float component7() {
                return this.distance;
            }

            public final float component8() {
                return this.totalDistance;
            }

            public final TrainInfo copy(int i, int i2, int i3, String speedLimitType, int i4, int i5, float f, float f2) {
                Intrinsics.checkNotNullParameter(speedLimitType, "speedLimitType");
                return new TrainInfo(i, i2, i3, speedLimitType, i4, i5, f, f2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof TrainInfo) {
                    TrainInfo trainInfo = (TrainInfo) obj;
                    return this.salary == trainInfo.salary && this.maxTime == trainInfo.maxTime && this.speedLimit == trainInfo.speedLimit && Intrinsics.areEqual(this.speedLimitType, trainInfo.speedLimitType) && this.warningsMax == trainInfo.warningsMax && this.warnings == trainInfo.warnings && Float.compare(this.distance, trainInfo.distance) == 0 && Float.compare(this.totalDistance, trainInfo.totalDistance) == 0;
                }
                return false;
            }

            public int hashCode() {
                return (((((((((((((Integer.hashCode(this.salary) * 31) + Integer.hashCode(this.maxTime)) * 31) + Integer.hashCode(this.speedLimit)) * 31) + this.speedLimitType.hashCode()) * 31) + Integer.hashCode(this.warningsMax)) * 31) + Integer.hashCode(this.warnings)) * 31) + Float.hashCode(this.distance)) * 31) + Float.hashCode(this.totalDistance);
            }

            public String toString() {
                int i = this.salary;
                int i2 = this.maxTime;
                int i3 = this.speedLimit;
                String str = this.speedLimitType;
                int i4 = this.warningsMax;
                int i5 = this.warnings;
                float f = this.distance;
                return "TrainInfo(salary=" + i + ", maxTime=" + i2 + ", speedLimit=" + i3 + ", speedLimitType=" + str + ", warningsMax=" + i4 + ", warnings=" + i5 + ", distance=" + f + ", totalDistance=" + this.totalDistance + ")";
            }

            public TrainInfo(int i, int i2, int i3, String speedLimitType, int i4, int i5, float f, float f2) {
                Intrinsics.checkNotNullParameter(speedLimitType, "speedLimitType");
                this.salary = i;
                this.maxTime = i2;
                this.speedLimit = i3;
                this.speedLimitType = speedLimitType;
                this.warningsMax = i4;
                this.warnings = i5;
                this.distance = f;
                this.totalDistance = f2;
            }

            public final int getSalary() {
                return this.salary;
            }

            public final int getMaxTime() {
                return this.maxTime;
            }

            public final int getSpeedLimit() {
                return this.speedLimit;
            }

            public final String getSpeedLimitType() {
                return this.speedLimitType;
            }

            public final int getWarningsMax() {
                return this.warningsMax;
            }

            public final int getWarnings() {
                return this.warnings;
            }

            public final float getDistance() {
                return this.distance;
            }

            public final float getTotalDistance() {
                return this.totalDistance;
            }
        }

        private Companion() {
        }

        /* compiled from: Hud.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/Hud$Companion$NoticeInfo;", "", "type", "", "title", "", "text", "keyText", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()I", "getTitle", "()Ljava/lang/String;", "getText", "getKeyText", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class NoticeInfo {
            private final String keyText;
            private final String text;
            private final String title;
            private final int type;

            public static /* synthetic */ NoticeInfo copy$default(NoticeInfo noticeInfo, int i, String str, String str2, String str3, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = noticeInfo.type;
                }
                if ((i2 & 2) != 0) {
                    str = noticeInfo.title;
                }
                if ((i2 & 4) != 0) {
                    str2 = noticeInfo.text;
                }
                if ((i2 & 8) != 0) {
                    str3 = noticeInfo.keyText;
                }
                return noticeInfo.copy(i, str, str2, str3);
            }

            public final int component1() {
                return this.type;
            }

            public final String component2() {
                return this.title;
            }

            public final String component3() {
                return this.text;
            }

            public final String component4() {
                return this.keyText;
            }

            public final NoticeInfo copy(int i, String title, String text, String keyText) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(keyText, "keyText");
                return new NoticeInfo(i, title, text, keyText);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof NoticeInfo) {
                    NoticeInfo noticeInfo = (NoticeInfo) obj;
                    return this.type == noticeInfo.type && Intrinsics.areEqual(this.title, noticeInfo.title) && Intrinsics.areEqual(this.text, noticeInfo.text) && Intrinsics.areEqual(this.keyText, noticeInfo.keyText);
                }
                return false;
            }

            public int hashCode() {
                return (((((Integer.hashCode(this.type) * 31) + this.title.hashCode()) * 31) + this.text.hashCode()) * 31) + this.keyText.hashCode();
            }

            public String toString() {
                int i = this.type;
                String str = this.title;
                String str2 = this.text;
                return "NoticeInfo(type=" + i + ", title=" + str + ", text=" + str2 + ", keyText=" + this.keyText + ")";
            }

            public NoticeInfo(int i, String title, String text, String keyText) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(keyText, "keyText");
                this.type = i;
                this.title = title;
                this.text = text;
                this.keyText = keyText;
            }

            public final int getType() {
                return this.type;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getText() {
                return this.text;
            }

            public final String getKeyText() {
                return this.keyText;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: Hud.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/Hud$Companion$NoticeType;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "NONE", "ACTION_BUTTON", "NOTICE_WITHOUT_DESCRIPTION", "ACTION_NOTICE_WITHOUT_DESCRIPTION", "ACTION_NOTICE_WITH_DESCRIPTION", "NOTICE_WITH_DESCRIPTION", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class NoticeType {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ NoticeType[] $VALUES;
            private final int id;
            public static final NoticeType NONE = new NoticeType("NONE", 0, 0);
            public static final NoticeType ACTION_BUTTON = new NoticeType("ACTION_BUTTON", 1, 1);
            public static final NoticeType NOTICE_WITHOUT_DESCRIPTION = new NoticeType("NOTICE_WITHOUT_DESCRIPTION", 2, 2);
            public static final NoticeType ACTION_NOTICE_WITHOUT_DESCRIPTION = new NoticeType("ACTION_NOTICE_WITHOUT_DESCRIPTION", 3, 3);
            public static final NoticeType ACTION_NOTICE_WITH_DESCRIPTION = new NoticeType("ACTION_NOTICE_WITH_DESCRIPTION", 4, 4);
            public static final NoticeType NOTICE_WITH_DESCRIPTION = new NoticeType("NOTICE_WITH_DESCRIPTION", 5, 5);

            private static final /* synthetic */ NoticeType[] $values() {
                return new NoticeType[]{NONE, ACTION_BUTTON, NOTICE_WITHOUT_DESCRIPTION, ACTION_NOTICE_WITHOUT_DESCRIPTION, ACTION_NOTICE_WITH_DESCRIPTION, NOTICE_WITH_DESCRIPTION};
            }

            public static EnumEntries<NoticeType> getEntries() {
                return $ENTRIES;
            }

            public static NoticeType valueOf(String str) {
                return (NoticeType) Enum.valueOf(NoticeType.class, str);
            }

            public static NoticeType[] values() {
                return (NoticeType[]) $VALUES.clone();
            }

            private NoticeType(String str, int i, int i2) {
                this.id = i2;
            }

            public final int getId() {
                return this.id;
            }

            static {
                NoticeType[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
            }
        }
    }

    private final void setXPayDay(int i) {
        this.xPayDay = i;
        updatePayDay();
    }

    private final void updatePayDay() {
        if (this.xPayDay > 1) {
            HudPageBinding hudPageBinding = this.binding;
            hudPageBinding.hudServerInfoMultiplyValue.setText("X" + this.xPayDay);
            if (this.hud.getVisibility() == 0) {
                hudPageBinding.hudServerInfoMultiply.setVisibility(0);
                return;
            } else {
                hudPageBinding.hudServerInfoMultiply.setVisibility(8);
                return;
            }
        }
        this.binding.hudServerInfoMultiply.setVisibility(8);
    }
}
