package ru.mrlargha.commonui.elements.hud.presentation;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
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
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.common.C;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import com.arizona.common.utils.EasyAnimation;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.BannerElementBinding;
import ru.mrlargha.commonui.databinding.HudCaptBinding;
import ru.mrlargha.commonui.databinding.HudElementCasesTimerBinding;
import ru.mrlargha.commonui.databinding.HudElementChickenChargeBinding;
import ru.mrlargha.commonui.databinding.HudElementImposterGameBinding;
import ru.mrlargha.commonui.databinding.HudElementPiratesBinding;
import ru.mrlargha.commonui.databinding.HudElementPromoBinding;
import ru.mrlargha.commonui.databinding.HudImprovingSkillsBinding;
import ru.mrlargha.commonui.databinding.HudPageBinding;
import ru.mrlargha.commonui.databinding.HudProgressBarContainerBinding;
import ru.mrlargha.commonui.databinding.HudProposalScreenBinding;
import ru.mrlargha.commonui.databinding.HudRadarScreenBinding;
import ru.mrlargha.commonui.databinding.HudTaximeterBinding;
import ru.mrlargha.commonui.databinding.HudTimerBinding;
import ru.mrlargha.commonui.databinding.RodinaKaptScreenBinding;
import ru.mrlargha.commonui.elements.hud.interaction_button.InteractionData;
import ru.mrlargha.commonui.elements.hud.mission_progress.MissionData;
import ru.mrlargha.commonui.elements.hud.mission_progress.MissionGroupData;
import ru.mrlargha.commonui.elements.hud.mission_progress.MissionProgressAdapter;
import ru.mrlargha.commonui.elements.hud.presentation.api.HudApi;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.HudImprovingSkills;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.HudProposalScreen;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.HudTimer;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.UnreadMessageModel;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.banner.BannerElement;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.capt.HudCapt;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.case_timer.CaseTimerElement;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_charge.ChickenChargeElement;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_charge.HudChickenChargeResult;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_game.HudChickenGame;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_game.models.HudChickenGameModel;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_game.models.HudChickenGameRatingModel;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.counter.HudCounter;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.imposter_game.ImposterGameElement;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.pirates.PiratesElement;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.pirates.SquidHpModel;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.promo.PromoElement;
import ru.mrlargha.commonui.elements.hud.presentation.hud_screens.radar.RadarScreen;
import ru.mrlargha.commonui.elements.hud.presentation.models.GroupItem;
import ru.mrlargha.commonui.elements.hud.presentation.models.ProgressBarModel;
import ru.mrlargha.commonui.elements.hud.presentation.models.ServerInfoItem;
import ru.mrlargha.commonui.elements.hud.presentation.models.SharedPreferenceKeys;
import ru.mrlargha.commonui.utils.GsonStore;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.TokenManagerKt;
import ru.mrlargha.commonui.utils.ui.ArizonaRetrofit;
import ru.mrlargha.commonui.utils.ui.LockerKt;
/* compiled from: Hud.kt */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u0084\u00012\u00020\u0001:\n\u0080\u0001\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002J\u000e\u0010<\u001a\u0002092\u0006\u0010=\u001a\u00020;J\u0010\u0010>\u001a\u0002092\u0006\u0010?\u001a\u00020!H\u0016J&\u0010@\u001a\u0002092\u0006\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u0005J\u000e\u0010E\u001a\u0002092\u0006\u0010F\u001a\u00020\u0005J\u000e\u0010G\u001a\u0002092\u0006\u0010H\u001a\u00020\u0016J\u000e\u0010I\u001a\u0002092\u0006\u0010J\u001a\u00020\u0005J\u000e\u0010K\u001a\u0002092\u0006\u0010L\u001a\u00020;J\u000e\u0010M\u001a\u0002092\u0006\u0010L\u001a\u00020;J\u0010\u0010N\u001a\u0002092\u0006\u0010?\u001a\u00020\u0005H\u0002J\u0010\u0010O\u001a\u0002092\u0006\u0010P\u001a\u00020\u0005H\u0002J\u0010\u0010Q\u001a\u0002092\u0006\u0010R\u001a\u00020SH\u0002J\u0010\u0010T\u001a\u0002092\u0006\u0010U\u001a\u00020;H\u0002J\b\u0010V\u001a\u000209H\u0002J\u001e\u0010W\u001a\u0002092\u0006\u0010X\u001a\u00020;2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020[0ZH\u0002J\b\u0010\\\u001a\u000209H\u0002J\u0010\u0010]\u001a\u0002092\u0006\u0010^\u001a\u00020\u0005H\u0002J\u0010\u0010_\u001a\u0002092\u0006\u0010`\u001a\u00020aH\u0002J\u0018\u0010b\u001a\u0002092\u0006\u0010L\u001a\u00020;2\u0006\u0010c\u001a\u00020\u0005H\u0016J\u0010\u0010d\u001a\u0002092\u0006\u0010L\u001a\u00020;H\u0002J\u0010\u0010e\u001a\u0002092\u0006\u0010R\u001a\u00020fH\u0002J\u0010\u0010g\u001a\u0002092\u0006\u0010?\u001a\u00020\u0005H\u0002J\b\u0010h\u001a\u000209H\u0002J\u0016\u0010i\u001a\u0002092\f\u0010L\u001a\b\u0012\u0004\u0012\u00020j0ZH\u0002J\u0016\u0010k\u001a\u0002092\f\u0010l\u001a\b\u0012\u0004\u0012\u00020j0ZH\u0002J\u0010\u0010m\u001a\u0002092\u0006\u0010J\u001a\u00020\u0005H\u0002J\u0010\u0010n\u001a\u0002092\u0006\u0010l\u001a\u00020jH\u0002J\b\u0010o\u001a\u000209H\u0002J\b\u0010p\u001a\u000209H\u0002J\b\u0010q\u001a\u000209H\u0002J\u0010\u0010r\u001a\u0002092\u0006\u0010s\u001a\u00020;H\u0002J\b\u0010t\u001a\u000209H\u0002J\u0010\u0010u\u001a\u0002092\u0006\u0010L\u001a\u00020vH\u0002J\u0010\u0010w\u001a\u0002092\u0006\u0010x\u001a\u00020\u0005H\u0002J\u0010\u0010y\u001a\u0002092\u0006\u0010x\u001a\u00020\u0005H\u0002J\b\u0010z\u001a\u000209H\u0002J\b\u0010{\u001a\u000209H\u0002J\u0010\u0010|\u001a\u0002092\u0006\u0010}\u001a\u00020\u0005H\u0002J\b\u0010~\u001a\u000209H\u0002J\b\u0010\u007f\u001a\u000209H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0085\u0001"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/Hud;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "hud", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/HudPageBinding;", "backendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "client", "Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "getClient", "()Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "api", "Lru/mrlargha/commonui/elements/hud/presentation/api/HudApi;", "xPayDay", "previousMoneyValue", "", "sharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "trainTimer", "Landroid/os/CountDownTimer;", "moneyTimer", "missionsProgressAdapter", "Lru/mrlargha/commonui/elements/hud/mission_progress/MissionProgressAdapter;", "interactionButtonId", "streamerState", "", "handler", "Landroid/os/Handler;", "remainedTime", "isGroupButtonPressed", "groupAdapter", "Lru/mrlargha/commonui/elements/hud/presentation/GroupAdapter;", "bannerElement", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/banner/BannerElement;", "promoElement", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/promo/PromoElement;", "counter", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/counter/HudCounter;", "radar", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/radar/RadarScreen;", "caseTimer", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/case_timer/CaseTimerElement;", "imposterGameElement", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/imposter_game/ImposterGameElement;", "chargeElement", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_charge/ChickenChargeElement;", "chickenGame", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_game/HudChickenGame;", "installServerLogotype", "", "uri", "", "setPlayerLocation", FirebaseAnalytics.Param.LOCATION, "setVisibility", "visible", "installHud", "playerId", "serverId", "serverType", "isStreamerMode", "updateOnline", "currentOnline", "updateMoney", "money", "updateRouletteInfo", "id", "updateRouletteInfoText", "data", "updateMainRouletteText", "setTrainsVisibility", "startTrainTimer", "seconds", "setTrainInfo", "info", "Lru/mrlargha/commonui/elements/hud/presentation/Hud$Companion$TrainInfo;", "showInteractionButton", "text", "hideInteractionButton", "showMissionsProgress", "title", "missions", "", "Lru/mrlargha/commonui/elements/hud/mission_progress/MissionData;", "hideMissionsProgress", "setVip", "days", "setNoticeState", "noticeInfo", "Lru/mrlargha/commonui/elements/hud/presentation/Hud$Companion$NoticeInfo;", "onBackendMessage", "subId", "setLocationVisibility", "setServerID", "Lru/mrlargha/commonui/elements/hud/presentation/models/ServerInfoItem;", "setGroupButtonVisibility", "changeGroupTableVisibility", "setGroupData", "Lru/mrlargha/commonui/elements/hud/presentation/models/GroupItem;", "updateGroupData", "item", "deleteGroupMember", "addGroupMember", "showTimer", "updateTimer", "scheduleUpdateTimer", "showProgressBar", "next", "hideProgressBar", "setDataProgressBar", "Lru/mrlargha/commonui/elements/hud/presentation/models/ProgressBarModel;", "showOverlay", TypedValues.TransitionType.S_DURATION, "hideOverlay", "hideRouletteUi", "showRouletteUi", "setXPayDay", "value", "updatePayDay", "resetHud", "HudListener", "Spawner", "KaptGang", "KaptData", "Companion", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Hud extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private final HudApi api;
    private final IBackendNotifier backendNotifier;
    private final BannerElement bannerElement;
    private final HudPageBinding binding;
    private final CaseTimerElement caseTimer;
    private final ChickenChargeElement chargeElement;
    private final HudChickenGame chickenGame;
    private final ArizonaRetrofit client;
    private final HudCounter counter;
    private final GroupAdapter groupAdapter;
    private final Handler handler;
    private final ConstraintLayout hud;
    private final ImposterGameElement imposterGameElement;
    private int interactionButtonId;
    private boolean isGroupButtonPressed;
    private final MissionProgressAdapter missionsProgressAdapter;
    private CountDownTimer moneyTimer;
    private long previousMoneyValue;
    private final PromoElement promoElement;
    private final RadarScreen radar;
    private int remainedTime;
    private final SharedPreferences sharedPref;
    private boolean streamerState;
    private CountDownTimer trainTimer;
    private int xPayDay;

    /* compiled from: Hud.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/Hud$HudListener;", "", "hudUpdateMoney", "", "money", "", "hudSetTimer", "seconds", "", "hudScale", "scale", "", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public interface HudListener {
        void hudScale(float f);

        void hudSetTimer(int i);

        void hudUpdateMoney(long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$13(View view) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$15(View view, MotionEvent motionEvent) {
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
        IBackendNotifier iBackendNotifier = (IBackendNotifier) targetActivity;
        this.backendNotifier = iBackendNotifier;
        ArizonaRetrofit arizonaRetrofit = new ArizonaRetrofit(targetActivity, i);
        this.client = arizonaRetrofit;
        this.api = (HudApi) ArizonaRetrofit.create$default(arizonaRetrofit, HudApi.class, false, FirebaseConfigHelper.INSTANCE.getHudPingUrl(), null, 10, null);
        this.sharedPref = targetActivity.getSharedPreferences("flavorType", 0);
        MissionProgressAdapter missionProgressAdapter = new MissionProgressAdapter();
        this.missionsProgressAdapter = missionProgressAdapter;
        this.interactionButtonId = -1;
        this.handler = new Handler(Looper.getMainLooper());
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
        Hud hud = this;
        this.bannerElement = new BannerElement(banner, ru.mrlargha.commonui.utils.UtilsKt.isArizonaType(), hud);
        HudElementPromoBinding promo = bind.promo;
        Intrinsics.checkNotNullExpressionValue(promo, "promo");
        this.promoElement = new PromoElement(promo, hud);
        HudTaximeterBinding hudTaximeterLayout = bind.hudTaximeterLayout;
        Intrinsics.checkNotNullExpressionValue(hudTaximeterLayout, "hudTaximeterLayout");
        this.counter = new HudCounter(i, hudTaximeterLayout, iBackendNotifier);
        HudRadarScreenBinding radar = bind.radar;
        Intrinsics.checkNotNullExpressionValue(radar, "radar");
        this.radar = new RadarScreen(radar, i, getNotifier());
        HudElementCasesTimerBinding casesTimer = bind.casesTimer;
        Intrinsics.checkNotNullExpressionValue(casesTimer, "casesTimer");
        this.caseTimer = new CaseTimerElement(casesTimer, hud);
        HudElementImposterGameBinding imposterGame = bind.imposterGame;
        Intrinsics.checkNotNullExpressionValue(imposterGame, "imposterGame");
        HudListener hudListener = (HudListener) targetActivity;
        this.imposterGameElement = new ImposterGameElement(imposterGame, hud, hudListener);
        HudElementChickenChargeBinding chargeChiken = bind.chargeChiken;
        Intrinsics.checkNotNullExpressionValue(chargeChiken, "chargeChiken");
        this.chargeElement = new ChickenChargeElement(chargeChiken, hud);
        this.chickenGame = new HudChickenGame(bind, hud, hudListener);
        if ((targetActivity.getResources().getConfiguration().screenLayout & 15) >= 3) {
            hudListener.hudScale(0.7f);
            bind.topQuestButtonLine.setGuidelinePercent(0.23f);
        }
        if (ru.mrlargha.commonui.utils.UtilsKt.isArizonaType()) {
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
        bind.rouletteContainer.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.this.backendNotifier.clickedWrapper(i, 6, -1);
            }
        });
        bind.rouletteContainer.setVisibility(8);
        bind.rouletteTimeContainer.setVisibility(8);
        bind.rouletteContainer.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.this.backendNotifier.clickedWrapper(i, 6, -1);
            }
        });
        bind.leftMenu.btnOpenRadialMenu.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.lambda$0$2(targetActivity, this, i, view);
            }
        });
        bind.leftMenu.btnOpenQuest.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.lambda$0$3(targetActivity, this, i, view);
            }
        });
        bind.leftMenu.btnOpenBattlePass.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.lambda$0$4(targetActivity, this, i, view);
            }
        });
        bind.hudStreamerButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.lambda$0$5(targetActivity, this, i, view);
            }
        });
        bind.hudMenuButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.lambda$0$6(targetActivity, this, i, view);
            }
        });
        ConstraintLayout hudPhoneButton = bind.hudPhoneButton;
        Intrinsics.checkNotNullExpressionValue(hudPhoneButton, "hudPhoneButton");
        LockerKt.setLockingClickListener(hudPhoneButton, 600L, new Function1() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Hud.lambda$0$7(targetActivity, this, i, (View) obj);
            }
        });
        bind.hudInventoryButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.lambda$0$8(targetActivity, this, view);
            }
        });
        bind.hudDonateButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.lambda$0$9(targetActivity, this, i, view);
            }
        });
        bind.hudServerInfoContainer.setVisibility(8);
        bind.ivDoors.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.this.backendNotifier.clickedWrapper(i, -1, 1);
            }
        });
        bind.ivHorn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.lambda$0$11(Hud.this, i, bind, view);
            }
        });
        bind.imageButtonInteraction.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r0.backendNotifier.clickedWrapper(i, 7, Hud.this.interactionButtonId);
            }
        });
        bind.newMessageContainer.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.lambda$0$13(view);
            }
        });
        bind.groupButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.this.changeGroupTableVisibility();
            }
        });
        bind.groupRv.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda20
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return Hud.lambda$0$15(view, motionEvent);
            }
        });
        bind.groupRv.setAdapter(groupAdapter);
        setVisibility(false);
    }

    public final ArizonaRetrofit getClient() {
        return this.client;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit groupAdapter$lambda$0(Hud hud, GroupItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        SAMPUIElement.notifyClick$default(hud, it.getId() + 60, 60, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$2(Activity activity, Hud hud, int i, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.bounce));
        hud.backendNotifier.clickedWrapper(i, 9, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$3(Activity activity, Hud hud, int i, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.bounce));
        hud.backendNotifier.clickedWrapper(i, 4, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$4(Activity activity, Hud hud, int i, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.bounce));
        hud.backendNotifier.clickedWrapper(i, 5, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$5(Activity activity, Hud hud, int i, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.bounce));
        hud.backendNotifier.clickedWrapper(i, 8, -1);
        hud.streamerState = !hud.streamerState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$6(Activity activity, Hud hud, int i, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.bounce));
        hud.backendNotifier.clickedWrapper(i, 0, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$7(Activity activity, Hud hud, int i, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.bounce));
        hud.backendNotifier.clickedWrapper(i, 1, -1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$8(Activity activity, Hud hud, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.bounce));
        IBackendNotifier iBackendNotifier = hud.backendNotifier;
        int id = UIElementID.INVENTORY.getId();
        byte[] bytes = StringKt.toStringJson("").getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, -1, 0, bytes);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$9(Activity activity, Hud hud, int i, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.bounce));
        hud.backendNotifier.clickedWrapper(i, 3, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$11(Hud hud, int i, final HudPageBinding hudPageBinding, View view) {
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
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/Hud$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.HUD);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new Hud(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }

    public final void setPlayerLocation(String location) {
        String str;
        Intrinsics.checkNotNullParameter(location, "location");
        Pair<String, String> parseString = UtilsKt.parseString(location);
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

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        super.setVisibility(z);
        updatePayDay();
    }

    public final void installHud(int i, int i2, int i3, int i4) {
        String str;
        if (i4 != 0) {
            this.binding.hudStreamerButton.setVisibility(0);
        }
        BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), null, null, new Hud$installHud$1(i3, this, i2, null), 3, null);
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
                hudPageBinding = Hud.this.binding;
                hudPageBinding.trainCurrentTime.setText(ru.mrlargha.commonui.utils.UtilsKt.formatTime(intRef.element * 1000) + " ");
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
            hudPageBinding.trainMaxTime.setText("/ " + ru.mrlargha.commonui.utils.UtilsKt.formatTime(trainInfo.getMaxTime() * 1000));
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
        hudPageBinding.maxKm.setText(((int) trainInfo.getTotalDistance()) + " m");
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
                    Unit noticeState$lambda$0$0;
                    noticeState$lambda$0$0 = Hud.setNoticeState$lambda$0$0(Hud.this);
                    return noticeState$lambda$0$0;
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
                    Unit noticeState$lambda$0$1;
                    noticeState$lambda$0$1 = Hud.setNoticeState$lambda$0$1(Hud.this);
                    return noticeState$lambda$0$1;
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
                    Unit noticeState$lambda$0$2;
                    noticeState$lambda$0$2 = Hud.setNoticeState$lambda$0$2(Hud.this);
                    return noticeState$lambda$0$2;
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
    public static final Unit setNoticeState$lambda$0$0(Hud hud) {
        hud.backendNotifier.clickedWrapper(hud.getBackendID(), 7, -1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setNoticeState$lambda$0$1(Hud hud) {
        hud.backendNotifier.clickedWrapper(hud.getBackendID(), 7, -1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setNoticeState$lambda$0$2(Hud hud) {
        hud.backendNotifier.clickedWrapper(hud.getBackendID(), 7, -1);
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            if (i == 0) {
                setXPayDay(Integer.parseInt(data));
                return;
            }
            if (i == 1) {
                CardView root = this.binding.banner.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                if (root.getVisibility() != 0) {
                    FrameLayout root2 = this.binding.casesTimer.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
                    if (root2.getVisibility() != 0) {
                        updateRouletteInfo(Integer.parseInt(data));
                        return;
                    }
                }
                updateRouletteInfo(0);
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
            } else if (i == 5) {
                ConstraintLayout trainSettings = this.binding.trainSettings;
                Intrinsics.checkNotNullExpressionValue(trainSettings, "trainSettings");
                ConstraintLayout constraintLayout = trainSettings;
                if (!(Integer.parseInt(data) == 1)) {
                    r4 = 8;
                }
                constraintLayout.setVisibility(r4);
            } else if (i == 6) {
                if (Integer.parseInt(data) == 1) {
                    this.binding.ivDoorsState.setImageResource(R.drawable.ic_switch_on);
                } else {
                    this.binding.ivDoorsState.setImageResource(R.drawable.ic_switch_none);
                }
            } else if (i == 7) {
                this.counter.setTaximeterVisibility(data);
            } else if (i == 8) {
                this.counter.setTaxiPrice(data);
            } else if (i == 9) {
                this.counter.setTaximeterCounterType(data, false);
            } else if (i == 10) {
                this.counter.setTaximeterType(Integer.parseInt(data));
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
                this.counter.setTaximeterCounterType(data, true);
            } else if (i == BackendHudIds.TAXITIMER_STOP.getSubId()) {
                this.counter.stopTaxiTimer(Integer.parseInt(data));
            } else if (i == BackendHudIds.PROGRESS_BAR_SHOW.getSubId()) {
                showProgressBar(data);
            } else if (i == BackendHudIds.PROGRESS_BAR_HIDE.getSubId()) {
                hideProgressBar();
            } else if (i == BackendHudIds.PROGRESS_BAR_SET_DATA.getSubId()) {
                setDataProgressBar((ProgressBarModel) MapperKt.toModel(data, ProgressBarModel.class));
            } else if (i != BackendHudIds.KAPT_ZERO.getSubId()) {
                if (i == BackendHudIds.KAPT_ONE.getSubId()) {
                    ConstraintLayout root3 = this.binding.hudKaptScreen.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root3, "getRoot(...)");
                    root3.setVisibility(0);
                    if (Integer.parseInt(data) == 0) {
                        RodinaKaptScreenBinding rodinaKaptScreenBinding = this.binding.hudKaptScreen;
                        rodinaKaptScreenBinding.textView42Top.setVisibility(8);
                        rodinaKaptScreenBinding.rodinaKaptTimeRemainingTop.setVisibility(8);
                        rodinaKaptScreenBinding.textView42.setVisibility(0);
                        rodinaKaptScreenBinding.rodinaKaptTimeRemaining.setVisibility(0);
                        Intrinsics.checkNotNull(rodinaKaptScreenBinding);
                    } else if (Integer.parseInt(data) == 2) {
                        ConstraintLayout root4 = this.binding.hudKaptScreen.getRoot();
                        Intrinsics.checkNotNullExpressionValue(root4, "getRoot(...)");
                        root4.setVisibility(8);
                        Unit unit = Unit.INSTANCE;
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
                        ConstraintLayout root5 = this.binding.hudProposalScreen.getRoot();
                        Intrinsics.checkNotNullExpressionValue(root5, "getRoot(...)");
                        root5.setVisibility(0);
                        HudProposalScreenBinding hudProposalScreen2 = this.binding.hudProposalScreen;
                        Intrinsics.checkNotNullExpressionValue(hudProposalScreen2, "hudProposalScreen");
                        hudProposalScreen.showProposalScreen(hudProposalScreen2, proposalResponse, new Function1() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit onBackendMessage$lambda$3;
                                onBackendMessage$lambda$3 = Hud.onBackendMessage$lambda$3(Hud.this, ((Integer) obj).intValue());
                                return onBackendMessage$lambda$3;
                            }
                        });
                        return;
                    }
                    ConstraintLayout root6 = this.binding.hudProposalScreen.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root6, "getRoot(...)");
                    root6.setVisibility(8);
                    hudProposalScreen.stopTimer();
                } else if (i == BackendHudIds.UNREAD_MESSAGE_COUNT.getSubId()) {
                    UnreadMessageModel unreadMessageModel = (UnreadMessageModel) MapperKt.toModel(data, UnreadMessageModel.class);
                    if (unreadMessageModel.getUnreadMessengerMessages() > 0) {
                        FrameLayout unreadMeassageContainer = this.binding.unreadMeassageContainer;
                        Intrinsics.checkNotNullExpressionValue(unreadMeassageContainer, "unreadMeassageContainer");
                        unreadMeassageContainer.setVisibility(0);
                        this.binding.tvMessageCount.setText(String.valueOf(unreadMessageModel.getUnreadMessengerMessages()));
                    } else {
                        FrameLayout unreadMeassageContainer2 = this.binding.unreadMeassageContainer;
                        Intrinsics.checkNotNullExpressionValue(unreadMeassageContainer2, "unreadMeassageContainer");
                        unreadMeassageContainer2.setVisibility(8);
                    }
                    getSharedPreferences().edit().putInt("UNREAD_MESSAGE", unreadMessageModel.getUnreadMessengerMessages()).apply();
                    Log.d(getCLASS_TAG(), "onBackendMessage: unreade message in shared pref: " + getSharedPreferences().getInt("UNREAD_MESSAGE", 0));
                } else if (i == BackendHudIds.UPDATE_MONEY.getSubId()) {
                    updateMoney(Long.parseLong(data));
                    Activity targetActivity = getTargetActivity();
                    Intrinsics.checkNotNull(targetActivity, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.hud.presentation.Hud.HudListener");
                    ((HudListener) targetActivity).hudUpdateMoney(Long.parseLong(data));
                } else if (i == BackendHudIds.SHOW_IMPROVING_SKILLS.getSubId()) {
                    HudImprovingSkills hudImprovingSkills = HudImprovingSkills.INSTANCE;
                    HudImprovingSkillsBinding improvingSkills = this.binding.improvingSkills;
                    Intrinsics.checkNotNullExpressionValue(improvingSkills, "improvingSkills");
                    LinearLayout root7 = this.binding.improvingSkills.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root7, "getRoot(...)");
                    root7.setVisibility(0);
                    hudImprovingSkills.showImprovingSkills(improvingSkills, data);
                } else if (i == BackendHudIds.HIDE_IMPROVING_SKILLS.getSubId()) {
                    LinearLayout root8 = this.binding.improvingSkills.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root8, "getRoot(...)");
                    root8.setVisibility(8);
                } else if (i == BackendHudIds.SHOW_TIMER.getSubId()) {
                    HudTimer hudTimer = HudTimer.INSTANCE;
                    HudTimerBinding timer = this.binding.timer;
                    Intrinsics.checkNotNullExpressionValue(timer, "timer");
                    LinearLayout root9 = this.binding.timer.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root9, "getRoot(...)");
                    root9.setVisibility(0);
                    hudTimer.showTimer(timer, data);
                } else if (i == BackendHudIds.HIDE_TIMER.getSubId()) {
                    LinearLayout root10 = this.binding.timer.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root10, "getRoot(...)");
                    root10.setVisibility(8);
                } else if (i == BackendHudIds.SHOW_WALKIE_TALKIE.getSubId()) {
                    ImageView root11 = this.binding.walkieTalkie.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root11, "getRoot(...)");
                    root11.setVisibility(0);
                } else if (i == BackendHudIds.HIDE_WALKIE_TALKIE.getSubId()) {
                    ImageView root12 = this.binding.walkieTalkie.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root12, "getRoot(...)");
                    root12.setVisibility(8);
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
                    resetHud();
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
                } else if (i == BackendHudIds.PromoSetInfo.getSubId()) {
                    this.promoElement.setInfo(data);
                } else if (i == BackendHudIds.PromoInvisible.getSubId()) {
                    this.promoElement.close();
                } else if (i == BackendHudIds.RODINA_SQUID_HEALTH_SHOW.getSubId()) {
                    PiratesElement piratesElement = PiratesElement.INSTANCE;
                    HudElementPiratesBinding pirates = this.binding.pirates;
                    Intrinsics.checkNotNullExpressionValue(pirates, "pirates");
                    piratesElement.showInfo(pirates, (SquidHpModel) MapperKt.toModel(data, SquidHpModel.class));
                } else if (i == BackendHudIds.RODINA_SQUID_HEALTH_HIDE.getSubId()) {
                    PiratesElement piratesElement2 = PiratesElement.INSTANCE;
                    HudElementPiratesBinding pirates2 = this.binding.pirates;
                    Intrinsics.checkNotNullExpressionValue(pirates2, "pirates");
                    piratesElement2.hide(pirates2);
                } else if (i == BackendHudIds.RADAR.getSubId()) {
                    this.radar.getEvent(data);
                } else if (i == BackendHudIds.CASE_TIMER_INIT.getSubId()) {
                    this.caseTimer.setInfo(data);
                    hideRouletteUi();
                } else if (i == BackendHudIds.CASE_TIMER_HIDE.getSubId()) {
                    this.caseTimer.close();
                } else if (i == BackendHudIds.IMPOSTER_GAME_VISIBILITY.getSubId()) {
                    if (Intrinsics.areEqual(data, "0")) {
                        this.binding.hideAll.setVisibility(0);
                    } else {
                        this.binding.hideAll.setVisibility(8);
                    }
                    this.imposterGameElement.setVisible(data);
                } else if (i == BackendHudIds.IMPOSTER_GAME_ITEMS_LIST.getSubId()) {
                    this.binding.hideAll.setVisibility(8);
                    this.imposterGameElement.setItemsList(data);
                } else if (i == BackendHudIds.IMPOSTER_GAME_INFO.getSubId()) {
                    this.binding.hideAll.setVisibility(8);
                    this.imposterGameElement.setPlayerInfo(data);
                } else if (i == BackendHudIds.CHICKEN_GAME_SHOW.getSubId()) {
                    this.chickenGame.isVisible(true);
                } else if (i == BackendHudIds.CHICKEN_GAME_HIDE.getSubId()) {
                    this.chickenGame.isVisible(false);
                } else if (i != BackendHudIds.CHICKEN_GAME_RATING.getSubId()) {
                    if (i != BackendHudIds.CHICKEN_GAME_TOOLS_INFO.getSubId()) {
                        if (i == BackendHudIds.CHICKEN_GAME_CHICKENS_KILLED.getSubId()) {
                            HudChickenGame hudChickenGame = this.chickenGame;
                            Integer intOrNull3 = StringsKt.toIntOrNull(data);
                            hudChickenGame.setKilledChicken(intOrNull3 != null ? intOrNull3.intValue() : 0);
                            return;
                        } else if (i == BackendHudIds.CHICKEN_GAME_EVENT_ONLINE.getSubId()) {
                            HudChickenGame hudChickenGame2 = this.chickenGame;
                            Integer intOrNull4 = StringsKt.toIntOrNull(data);
                            hudChickenGame2.setOnline(intOrNull4 != null ? intOrNull4.intValue() : 0);
                            return;
                        } else if (i != BackendHudIds.CHICKEN_GAME_PLAYER_RATING.getSubId()) {
                            if (i == BackendHudIds.CHICKEN_GAME_COINS.getSubId()) {
                                this.chickenGame.setMoney(data);
                                return;
                            } else if (i == BackendHudIds.CHICKEN_GAME_TIME_LEFT.getSubId()) {
                                this.chickenGame.startTimer(data);
                                return;
                            } else if (i == BackendHudIds.CHICKEN_GAME_CHICKEN_SIZE.getSubId()) {
                                this.chickenGame.setSize(data);
                                return;
                            } else if (i == BackendHudIds.CHICKEN_GAME_SAFE_ZONE.getSubId()) {
                                this.chickenGame.setZone(data);
                                return;
                            } else if (i == BackendHudIds.CHICKEN_CHARGE_VISIBILITY.getSubId()) {
                                this.chargeElement.setVisibility(data);
                                return;
                            } else if (i == BackendHudIds.CHICKEN_CHARGE_INFO.getSubId()) {
                                this.chargeElement.setInfo(data);
                                return;
                            } else if (i == BackendHudIds.CHICKEN_CHARGE_RESULT.getSubId()) {
                                ChickenChargeElement chickenChargeElement = this.chargeElement;
                                if (MapperKt.isJsonValid(data)) {
                                    Gson create = new GsonBuilder().setLenient().create();
                                    JsonArray asJsonArray = ((JsonElement) create.fromJson(data, (Class<Object>) JsonElement.class)).getAsJsonArray();
                                    Intrinsics.checkNotNull(asJsonArray);
                                    JsonArray<JsonElement> jsonArray = asJsonArray;
                                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray, 10));
                                    for (JsonElement jsonElement : jsonArray) {
                                        arrayList3.add(create.fromJson(jsonElement, (Class<Object>) HudChickenChargeResult.class));
                                    }
                                    arrayList = arrayList3;
                                } else {
                                    arrayList = CollectionsKt.emptyList();
                                }
                                chickenChargeElement.setResult(arrayList);
                                return;
                            } else {
                                return;
                            }
                        } else {
                            HudChickenGame hudChickenGame3 = this.chickenGame;
                            if (MapperKt.isJsonValid(data)) {
                                hudChickenGame3.setPlayerRating((HudChickenGameRatingModel) new GsonBuilder().setLenient().create().fromJson(data, (Class<Object>) HudChickenGameRatingModel.class));
                                return;
                            }
                            throw new JsonParseException("Json is not valid");
                        }
                    }
                    HudChickenGame hudChickenGame4 = this.chickenGame;
                    if (MapperKt.isJsonValid(data)) {
                        hudChickenGame4.setToolsInfo((HudChickenGameModel) new GsonBuilder().setLenient().create().fromJson(data, (Class<Object>) HudChickenGameModel.class));
                        return;
                    }
                    throw new JsonParseException("Json is not valid");
                } else {
                    HudChickenGame hudChickenGame5 = this.chickenGame;
                    if (MapperKt.isJsonValid(data)) {
                        Gson create2 = new GsonBuilder().setLenient().create();
                        JsonArray asJsonArray2 = ((JsonElement) create2.fromJson(data, (Class<Object>) JsonElement.class)).getAsJsonArray();
                        Intrinsics.checkNotNull(asJsonArray2);
                        JsonArray<JsonElement> jsonArray2 = asJsonArray2;
                        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray2, 10));
                        for (JsonElement jsonElement2 : jsonArray2) {
                            arrayList4.add(create2.fromJson(jsonElement2, (Class<Object>) HudChickenGameRatingModel.class));
                        }
                        arrayList2 = arrayList4;
                    } else {
                        arrayList2 = CollectionsKt.emptyList();
                    }
                    hudChickenGame5.setRatingList(arrayList2);
                }
            } else {
                Object fromJson = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) KaptData.class);
                Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
                KaptData kaptData = (KaptData) fromJson;
                ConstraintLayout root13 = this.binding.hudKaptScreen.getRoot();
                Intrinsics.checkNotNullExpressionValue(root13, "getRoot(...)");
                root13.setVisibility(0);
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
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.d("Exception", "onBackendMessage: " + e2.getMessage());
            Toast.makeText(getTargetActivity().getApplicationContext(), "Iid: " + getBackendID() + "; subId: " + i, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBackendMessage$lambda$3(Hud hud, int i) {
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
        TokenManagerKt.setServerId(serverInfoItem.getServer());
        TokenManagerKt.set_token(serverInfoItem.getToken());
        this.sharedPref.edit().putInt(SharedPreferenceKeys.SERVER_ID.getKeyName(), serverInfoItem.getServer()).putString(SharedPreferenceKeys.API_TOKEN.getKeyName(), serverInfoItem.getToken()).putInt(SharedPreferenceKeys.ACCOUNT_ID.getKeyName(), serverInfoItem.getAccountId()).apply();
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Hud.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\f¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/Hud$KaptGang;", "", "name", "", "kills", "", "color", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getName", "()Ljava/lang/String;", "getKills", "()I", "getColor", "colorInt", "getColorInt", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
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
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/Hud$KaptData;", "", "time", "", "leftGang", "Lru/mrlargha/commonui/elements/hud/presentation/Hud$KaptGang;", "rightGang", "<init>", "(ILru/mrlargha/commonui/elements/hud/presentation/Hud$KaptGang;Lru/mrlargha/commonui/elements/hud/presentation/Hud$KaptGang;)V", "getTime", "()I", "getLeftGang", "()Lru/mrlargha/commonui/elements/hud/presentation/Hud$KaptGang;", "getRightGang", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
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
        hudProgressBarContainerBinding.tvNext.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Hud.showProgressBar$lambda$0$0(Hud.this, view);
            }
        });
        hudProgressBarContainerBinding.getRoot().setVisibility(0);
        if (ru.mrlargha.commonui.utils.UtilsKt.isArizonaType()) {
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
    public static final void showProgressBar$lambda$0$0(Hud hud, View view) {
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
        this.binding.overlay.animate().setDuration(i).alpha(1.0f).start();
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
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/Hud$Companion;", "", "<init>", "()V", "TrainInfo", "NoticeInfo", "NoticeType", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: Hud.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u0006("}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/Hud$Companion$TrainInfo;", "", "salary", "", "maxTime", "speedLimit", "speedLimitType", "", "warningsMax", "warnings", "distance", "", "totalDistance", "<init>", "(IIILjava/lang/String;IIFF)V", "getSalary", "()I", "getMaxTime", "getSpeedLimit", "getSpeedLimitType", "()Ljava/lang/String;", "getWarningsMax", "getWarnings", "getDistance", "()F", "getTotalDistance", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes6.dex */
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
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/Hud$Companion$NoticeInfo;", "", "type", "", "title", "", "text", "keyText", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()I", "getTitle", "()Ljava/lang/String;", "getText", "getKeyText", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes6.dex */
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
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/Hud$Companion$NoticeType;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "NONE", "ACTION_BUTTON", "NOTICE_WITHOUT_DESCRIPTION", "ACTION_NOTICE_WITHOUT_DESCRIPTION", "ACTION_NOTICE_WITH_DESCRIPTION", "NOTICE_WITH_DESCRIPTION", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes6.dex */
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

    private final void resetHud() {
        this.binding.hideAll.setVisibility(0);
        this.imposterGameElement.close();
        this.chickenGame.isVisible(false);
        this.chargeElement.setVisibility("0");
    }

    private final void scheduleUpdateTimer() {
        this.handler.postDelayed(new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.presentation.Hud$scheduleUpdateTimer$$inlined$postDelayed$default$1
            @Override // java.lang.Runnable
            public final void run() {
                Hud.this.updateTimer();
            }
        }, 1000L);
    }
}
