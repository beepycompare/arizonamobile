package com.arizonagames.feature.arizona.bank;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.arizona.launcher.UpdateActivity;
import com.arizonagames.feature.arizona.bank.BankMainSection;
import com.arizonagames.feature.arizona.bank.BankPage;
import com.arizonagames.feature.arizona.bank.adapters.BankTabsAdapter;
import com.arizonagames.feature.arizona.bank.data.BankApiRepository;
import com.arizonagames.feature.arizona.bank.data.BankDepositRepository;
import com.arizonagames.feature.arizona.bank.data.remote.BankRetrofitClient;
import com.arizonagames.feature.arizona.bank.databinding.BankCardIssuePageBinding;
import com.arizonagames.feature.arizona.bank.databinding.BankCurrencyPageBinding;
import com.arizonagames.feature.arizona.bank.databinding.BankDepositPageBinding;
import com.arizonagames.feature.arizona.bank.databinding.BankLotteryPageBinding;
import com.arizonagames.feature.arizona.bank.databinding.BankMainPageBinding;
import com.arizonagames.feature.arizona.bank.databinding.BankOtherPageBinding;
import com.arizonagames.feature.arizona.bank.databinding.BankScreenBinding;
import com.arizonagames.feature.arizona.bank.navigation.BankNavigator;
import com.arizonagames.feature.arizona.bank.pages.BankCardIssuePageController;
import com.arizonagames.feature.arizona.bank.pages.BankCurrencyPageController;
import com.arizonagames.feature.arizona.bank.pages.BankDepositPageController;
import com.arizonagames.feature.arizona.bank.pages.BankLotteryPageController;
import com.arizonagames.feature.arizona.bank.pages.BankMainPageController;
import com.arizonagames.feature.arizona.bank.pages.BankOtherPageController;
import com.arizonagames.feature.arizona.bank.pages.BankPageController;
import com.arizonagames.feature.arizona.bank.ui.BankClickAnimationKt;
import com.arizonagames.feature.arizona.bank.ui.BankUiFormatterKt;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.elements.dialogs.DialogBankHistory;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: BankScreen.kt */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u0087\u00012\u00020\u0001:\u0004\u0087\u0001\u0088\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020*H\u0016J\u0018\u0010C\u001a\u00020A2\u0006\u0010D\u001a\u00020*2\u0006\u0010E\u001a\u00020*H\u0002J\u0018\u0010F\u001a\u00020A2\u0006\u0010D\u001a\u00020*2\u0006\u0010G\u001a\u00020*H\u0002J\u0018\u0010H\u001a\u00020A2\u0006\u0010I\u001a\u00020\u00052\u0006\u0010G\u001a\u00020*H\u0002J\u0010\u0010J\u001a\u00020A2\u0006\u0010G\u001a\u00020*H\u0002J\b\u0010K\u001a\u00020AH\u0002J\b\u0010L\u001a\u00020AH\u0002J\u0018\u0010M\u001a\u00020A2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u0005H\u0016J\u0010\u0010Q\u001a\u00020A2\u0006\u0010R\u001a\u00020OH\u0002J\b\u0010S\u001a\u00020AH\u0002J\b\u0010T\u001a\u00020AH\u0002J\u0010\u0010U\u001a\u00020A2\u0006\u0010V\u001a\u00020(H\u0002J\u0010\u0010W\u001a\u00020A2\u0006\u0010X\u001a\u00020YH\u0002J\u001a\u0010Z\u001a\u00020A2\u0006\u0010X\u001a\u00020Y2\b\b\u0002\u0010[\u001a\u00020*H\u0002J\u0018\u0010\\\u001a\u00020A2\u0006\u0010]\u001a\u00020\u00052\u0006\u0010P\u001a\u00020^H\u0002J\b\u0010_\u001a\u00020AH\u0002J\b\u0010`\u001a\u00020AH\u0002J\b\u0010a\u001a\u00020AH\u0002J\u0018\u0010b\u001a\u00020A2\u0006\u0010]\u001a\u00020\u00052\u0006\u0010P\u001a\u00020^H\u0002J\u0010\u0010c\u001a\u00020*2\u0006\u0010V\u001a\u00020(H\u0002J\u0010\u0010d\u001a\u00020*2\u0006\u0010V\u001a\u00020(H\u0002J\u0010\u0010e\u001a\u00020A2\u0006\u0010V\u001a\u00020(H\u0002J\u0018\u0010f\u001a\u00020*2\u0006\u0010X\u001a\u00020Y2\u0006\u0010V\u001a\u00020(H\u0002J\u0010\u0010g\u001a\u00020*2\u0006\u0010V\u001a\u00020(H\u0002J\u0010\u0010h\u001a\u00020*2\u0006\u0010V\u001a\u00020(H\u0002J\u0016\u0010i\u001a\b\u0012\u0004\u0012\u00020Y0j2\u0006\u0010V\u001a\u00020(H\u0002J\u0010\u0010k\u001a\u00020*2\u0006\u0010N\u001a\u00020OH\u0002J\u0010\u0010l\u001a\u00020*2\u0006\u0010N\u001a\u00020OH\u0002J\u0018\u0010m\u001a\u00020*2\u0006\u0010n\u001a\u00020O2\u0006\u0010N\u001a\u00020OH\u0002J\u0010\u0010o\u001a\u00020A2\u0006\u0010X\u001a\u00020YH\u0002J\u0010\u0010p\u001a\u00020A2\u0006\u0010X\u001a\u00020YH\u0002J\u0010\u0010q\u001a\u00020A2\u0006\u0010X\u001a\u00020YH\u0002J\u0016\u0010r\u001a\u00020A2\f\u0010s\u001a\b\u0012\u0004\u0012\u0002060\u0014H\u0002J\b\u0010t\u001a\u00020AH\u0002J\u0016\u0010u\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u0014H\u0082@¢\u0006\u0002\u0010vJ\b\u0010w\u001a\u00020AH\u0002J\u0010\u0010x\u001a\u00020A2\u0006\u0010y\u001a\u00020\u0005H\u0002J\b\u0010z\u001a\u00020AH\u0002J\b\u0010{\u001a\u00020AH\u0002J?\u0010|\u001a\u00020A2\u0006\u0010}\u001a\u00020O2\u0006\u0010~\u001a\u00020\u00052\u001f\u0010\u007f\u001a\u001b\b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020O0\u0081\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0082\u00010\u0080\u0001H\u0002¢\u0006\u0003\u0010\u0083\u0001J\u0011\u0010\u0084\u0001\u001a\u00020*2\u0006\u0010V\u001a\u00020(H\u0002J\u0010\u0010\u0085\u0001\u001a\u00020**\u0005\u0018\u00010\u0086\u0001H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u0002060\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0089\u0001"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "bankRetrofitClient", "Lcom/arizonagames/feature/arizona/bank/data/remote/BankRetrofitClient;", "bankDepositRepository", "Lcom/arizonagames/feature/arizona/bank/data/BankDepositRepository;", "bankApiRepository", "Lcom/arizonagames/feature/arizona/bank/data/BankApiRepository;", "screen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lcom/arizonagames/feature/arizona/bank/databinding/BankScreenBinding;", "pageRoots", "", "tabsAdapter", "Lcom/arizonagames/feature/arizona/bank/adapters/BankTabsAdapter;", "mainPageController", "Lcom/arizonagames/feature/arizona/bank/pages/BankMainPageController;", "depositPageController", "Lcom/arizonagames/feature/arizona/bank/pages/BankDepositPageController;", "currencyPageController", "Lcom/arizonagames/feature/arizona/bank/pages/BankCurrencyPageController;", "otherPageController", "Lcom/arizonagames/feature/arizona/bank/pages/BankOtherPageController;", "lotteryPageController", "Lcom/arizonagames/feature/arizona/bank/pages/BankLotteryPageController;", "cardIssuePageController", "Lcom/arizonagames/feature/arizona/bank/pages/BankCardIssuePageController;", "pageControllers", "Lcom/arizonagames/feature/arizona/bank/pages/BankPageController;", "navigator", "Lcom/arizonagames/feature/arizona/bank/navigation/BankNavigator;", "currentPayload", "Lcom/arizonagames/feature/arizona/bank/BankScreenPayload;", "isOpenAccountState", "", "hasDismissedOpenAccountState", "hasRequestedDepositIncome", "isDepositIncomeRequestInFlight", "hasReceivedDepositIncomeUpdate", "hasRequestedCurrencyHistory", "isCurrencyHistoryRequestInFlight", "hasRequestedGiveawayPrizes", "isGiveawayPrizesRequestInFlight", "giveawayPrizesPollingJob", "Lkotlinx/coroutines/Job;", "currentGiveawayPrizes", "Lcom/arizonagames/feature/arizona/bank/BankLotteryRewardInfo;", "isAtmMode", "historyDialog", "Lru/mrlargha/commonui/elements/dialogs/DialogBankHistory;", "shouldResetStateOnNextRootState", "openingStateGeneration", "visibilityAnimationGeneration", "hasPlayedOpeningAnimation", "isClosingAnimationRunning", "hasHandledVisibilityChange", "setVisibility", "", "visible", "showWithAnimation", "wasVisible", "wasClosing", "hideWithAnimation", "shouldResetAfterHide", "completeHideAnimation", "animationGeneration", "resetAfterHideIfNeeded", "restoreAnimationState", "prepareOpeningAnimationState", "onBackendMessageHandled", "data", "", "subId", "applyContentFrameMode", UpdateActivity.UPDATE_MODE, "resetOpeningState", "setupTabs", "applyPayload", "payload", "onPageTabClick", "page", "Lcom/arizonagames/feature/arizona/bank/BankPage;", "showPage", "requestBackendRefresh", "dispatchAction", "targetId", "Lcom/arizonagames/feature/arizona/bank/BankSendSubId;", "openSignatureModal", "openCardIssueForm", "submitCardIssue", "sendBackendAction", "requiresAccountSetup", "shouldLockTopTabs", "updateTopTabAccess", "isPageAccessible", "canShowCardIssue", "hasLoadedRootState", "visibleTopTabs", "", "isEmptyRootStatePayload", "applyPartialPayload", "applyWrappedPartialPayload", "key", "requestDepositIncomeIfNeeded", "requestCurrencyHistoryIfNeeded", "requestGiveawayPrizesIfNeeded", "bindGiveawayPrizes", "prizes", "startGiveawayPrizesPollingIfNeeded", "loadGiveawayPrizesOrNull", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopGiveawayPrizesPolling", "requestAccountHistory", "accountNumber", "requestDepositHistory", "requestOrganizationHistory", "requestHistory", "title", "addType", "loadBody", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "needsDepositIncome", "hasDepositIncomeHistory", "Lcom/arizonagames/feature/arizona/bank/BankIncomeInfo;", "Companion", "Spawner", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankScreen extends SAMPUIElement {
    @Deprecated
    public static final String BANK_BACKEND_CLICK_LOG_TAG = "BankBackendClick";
    @Deprecated
    public static final float CLOSE_ACCELERATION_FACTOR = 1.2f;
    @Deprecated
    public static final long CLOSE_ANIMATION_DURATION_MS = 180;
    @Deprecated
    public static final float CLOSE_END_ALPHA = 0.0f;
    @Deprecated
    public static final float CLOSE_END_SCALE = 0.975f;
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final String FULLSCREEN_LAYOUT_MODE = "0";
    @Deprecated
    public static final long GIVEAWAY_PRIZES_POLL_INTERVAL_MS = 60000;
    @Deprecated
    public static final int HISTORY_TYPE_ACCOUNT = 0;
    @Deprecated
    public static final int HISTORY_TYPE_DEPOSIT = 1;
    @Deprecated
    public static final int HISTORY_TYPE_ORGANIZATION = 2;
    @Deprecated
    public static final long MILLIS_PER_SECOND = 1000;
    @Deprecated
    public static final long OPEN_ANIMATION_DURATION_MS = 260;
    @Deprecated
    public static final float OPEN_DECELERATION_FACTOR = 1.45f;
    @Deprecated
    public static final float OPEN_START_ALPHA = 0.0f;
    @Deprecated
    public static final float OPEN_START_SCALE = 0.96f;
    private final BankApiRepository bankApiRepository;
    private final BankDepositRepository bankDepositRepository;
    private final BankRetrofitClient bankRetrofitClient;
    private final BankScreenBinding binding;
    private final BankCardIssuePageController cardIssuePageController;
    private final BankCurrencyPageController currencyPageController;
    private List<BankLotteryRewardInfo> currentGiveawayPrizes;
    private BankScreenPayload currentPayload;
    private final BankDepositPageController depositPageController;
    private Job giveawayPrizesPollingJob;
    private boolean hasDismissedOpenAccountState;
    private boolean hasHandledVisibilityChange;
    private boolean hasPlayedOpeningAnimation;
    private boolean hasReceivedDepositIncomeUpdate;
    private boolean hasRequestedCurrencyHistory;
    private boolean hasRequestedDepositIncome;
    private boolean hasRequestedGiveawayPrizes;
    private DialogBankHistory historyDialog;
    private boolean isAtmMode;
    private boolean isClosingAnimationRunning;
    private boolean isCurrencyHistoryRequestInFlight;
    private boolean isDepositIncomeRequestInFlight;
    private boolean isGiveawayPrizesRequestInFlight;
    private boolean isOpenAccountState;
    private final BankLotteryPageController lotteryPageController;
    private final BankMainPageController mainPageController;
    private final BankNavigator navigator;
    private int openingStateGeneration;
    private final BankOtherPageController otherPageController;
    private final List<BankPageController> pageControllers;
    private final List<View> pageRoots;
    private final View screen;
    private boolean shouldResetStateOnNextRootState;
    private final BankTabsAdapter tabsAdapter;
    private int visibilityAnimationGeneration;

    /* compiled from: BankScreen.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BankSendSubId.values().length];
            try {
                iArr[BankSendSubId.ACCOUNT_HISTORY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BankSendSubId.DEPOSIT_HISTORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BankSendSubId.ORGANIZATION_HISTORY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        BankRetrofitClient bankRetrofitClient = new BankRetrofitClient(targetActivity, i);
        this.bankRetrofitClient = bankRetrofitClient;
        this.bankDepositRepository = new BankDepositRepository(bankRetrofitClient.getApiService());
        this.bankApiRepository = new BankApiRepository(bankRetrofitClient.getApiService());
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.bank_screen, (ViewGroup) null);
        this.screen = inflate;
        BankScreenBinding bind = BankScreenBinding.bind(inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        int childCount = bind.bankPageContainer.getChildCount();
        ArrayList arrayList = new ArrayList(childCount);
        for (int i2 = 0; i2 < childCount; i2++) {
            arrayList.add(this.binding.bankPageContainer.getChildAt(i2));
        }
        this.pageRoots = arrayList;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : BankPage.getEntries()) {
            if (((BankPage) obj).getHasTopTab()) {
                arrayList2.add(obj);
            }
        }
        BankTabsAdapter bankTabsAdapter = new BankTabsAdapter(arrayList2, new BankScreen$tabsAdapter$2(this));
        this.tabsAdapter = bankTabsAdapter;
        BankMainPageBinding bind2 = BankMainPageBinding.bind(this.pageRoots.get(0));
        Intrinsics.checkNotNullExpressionValue(bind2, "bind(...)");
        BankMainPageController bankMainPageController = new BankMainPageController(targetActivity, bind2, new BankScreen$mainPageController$1(this));
        this.mainPageController = bankMainPageController;
        BankDepositPageBinding bind3 = BankDepositPageBinding.bind(this.pageRoots.get(1));
        Intrinsics.checkNotNullExpressionValue(bind3, "bind(...)");
        BankDepositPageController bankDepositPageController = new BankDepositPageController(targetActivity, bind3, new BankScreen$depositPageController$1(this));
        this.depositPageController = bankDepositPageController;
        BankCurrencyPageBinding bind4 = BankCurrencyPageBinding.bind(this.pageRoots.get(2));
        Intrinsics.checkNotNullExpressionValue(bind4, "bind(...)");
        BankCurrencyPageController bankCurrencyPageController = new BankCurrencyPageController(targetActivity, bind4, new BankScreen$currencyPageController$1(this));
        this.currencyPageController = bankCurrencyPageController;
        BankOtherPageBinding bind5 = BankOtherPageBinding.bind(this.pageRoots.get(3));
        Intrinsics.checkNotNullExpressionValue(bind5, "bind(...)");
        BankOtherPageController bankOtherPageController = new BankOtherPageController(bind5, new BankScreen$otherPageController$1(this));
        this.otherPageController = bankOtherPageController;
        BankLotteryPageBinding bind6 = BankLotteryPageBinding.bind(this.pageRoots.get(4));
        Intrinsics.checkNotNullExpressionValue(bind6, "bind(...)");
        BankLotteryPageController bankLotteryPageController = new BankLotteryPageController(targetActivity, bind6, new BankScreen$lotteryPageController$1(this));
        this.lotteryPageController = bankLotteryPageController;
        BankCardIssuePageBinding bind7 = BankCardIssuePageBinding.bind(this.pageRoots.get(5));
        Intrinsics.checkNotNullExpressionValue(bind7, "bind(...)");
        BankCardIssuePageController bankCardIssuePageController = new BankCardIssuePageController(bind7, this.binding, new BankScreen$cardIssuePageController$1(this), new BankScreen$cardIssuePageController$2(this), new BankScreen$cardIssuePageController$3(this));
        this.cardIssuePageController = bankCardIssuePageController;
        List<BankPageController> listOf = CollectionsKt.listOf((Object[]) new BankPageController[]{bankMainPageController, bankDepositPageController, bankCurrencyPageController, bankOtherPageController, bankLotteryPageController, bankCardIssuePageController});
        this.pageControllers = listOf;
        BankNavigator bankNavigator = new BankNavigator(bankTabsAdapter, listOf);
        this.navigator = bankNavigator;
        this.currentPayload = new BankScreenPayload(null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
        this.currentGiveawayPrizes = CollectionsKt.emptyList();
        this.shouldResetStateOnNextRootState = true;
        ChatEmoji.INSTANCE.init(targetActivity);
        prepareOpeningAnimationState();
        View screen = this.screen;
        Intrinsics.checkNotNullExpressionValue(screen, "screen");
        addViewToConstraintLayout(screen, -1, -1);
        setupTabs();
        bankNavigator.setVisibleTopTabs(visibleTopTabs(new BankScreenPayload(null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null)));
        CustomCardView buttonClose = this.binding.buttonClose;
        Intrinsics.checkNotNullExpressionValue(buttonClose, "buttonClose");
        BankClickAnimationKt.setAnimatedClickListener(buttonClose, new Function0() { // from class: com.arizonagames.feature.arizona.bank.BankScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BankScreen._init_$lambda$0(BankScreen.this);
            }
        });
        applyContentFrameMode("0");
        View screen2 = this.screen;
        Intrinsics.checkNotNullExpressionValue(screen2, "screen");
        BankUiFormatterKt.applyTaggedPlaceholderText(screen2);
        bankNavigator.showPage(BankPage.MAIN, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$0(BankScreen bankScreen) {
        bankScreen.dispatchAction(0, BankSendSubId.CLOSE);
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        boolean z2 = this.hasHandledVisibilityChange && isOnScreen();
        boolean z3 = this.isClosingAnimationRunning;
        this.hasHandledVisibilityChange = true;
        if (!z) {
            stopGiveawayPrizesPolling();
        }
        if (z || !this.isClosingAnimationRunning) {
            boolean shouldResetBankOpeningState = BankScreenKt.shouldResetBankOpeningState(z2, z);
            if (z) {
                showWithAnimation(z2, z3);
            } else {
                hideWithAnimation(z2, shouldResetBankOpeningState);
            }
        }
    }

    private final void showWithAnimation(boolean z, boolean z2) {
        final int i = this.visibilityAnimationGeneration + 1;
        this.visibilityAnimationGeneration = i;
        this.isClosingAnimationRunning = false;
        this.screen.animate().cancel();
        if (!BankScreenKt.shouldPlayBankOpeningAnimation(this.hasPlayedOpeningAnimation, z, z2, true)) {
            super.setVisibility(true);
            restoreAnimationState();
            return;
        }
        this.hasPlayedOpeningAnimation = true;
        prepareOpeningAnimationState();
        super.setVisibility(true);
        this.screen.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(260L).setInterpolator(new DecelerateInterpolator(1.45f)).withEndAction(new Runnable() { // from class: com.arizonagames.feature.arizona.bank.BankScreen$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BankScreen.showWithAnimation$lambda$0(i, this);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showWithAnimation$lambda$0(int i, BankScreen bankScreen) {
        if (i == bankScreen.visibilityAnimationGeneration) {
            bankScreen.restoreAnimationState();
        }
    }

    private final void hideWithAnimation(boolean z, final boolean z2) {
        boolean shouldPlayBankClosingAnimation = BankScreenKt.shouldPlayBankClosingAnimation(z, this.isClosingAnimationRunning, false);
        int i = this.visibilityAnimationGeneration;
        if (!shouldPlayBankClosingAnimation) {
            this.visibilityAnimationGeneration = i + 1;
            this.screen.animate().cancel();
            super.setVisibility(false);
            restoreAnimationState();
            resetAfterHideIfNeeded(z2);
            return;
        }
        final int i2 = i + 1;
        this.visibilityAnimationGeneration = i2;
        this.isClosingAnimationRunning = true;
        this.screen.animate().cancel();
        this.screen.animate().alpha(0.0f).scaleX(0.975f).scaleY(0.975f).setDuration(180L).setInterpolator(new AccelerateInterpolator(1.2f)).withEndAction(new Runnable() { // from class: com.arizonagames.feature.arizona.bank.BankScreen$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                BankScreen.this.completeHideAnimation(i2, z2);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void completeHideAnimation(int i, boolean z) {
        if (i != this.visibilityAnimationGeneration) {
            return;
        }
        this.isClosingAnimationRunning = false;
        super.setVisibility(false);
        restoreAnimationState();
        resetAfterHideIfNeeded(z);
    }

    private final void resetAfterHideIfNeeded(boolean z) {
        if (z) {
            resetOpeningState();
            this.shouldResetStateOnNextRootState = true;
        }
    }

    private final void restoreAnimationState() {
        this.screen.setAlpha(1.0f);
        this.screen.setScaleX(1.0f);
        this.screen.setScaleY(1.0f);
    }

    private final void prepareOpeningAnimationState() {
        this.screen.setAlpha(0.0f);
        this.screen.setScaleX(0.96f);
        this.screen.setScaleY(0.96f);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.onBackendMessageHandled(data, i);
        if (i == BankReceiveSubId.ROOT_STATE.getSubId()) {
            if (isEmptyRootStatePayload(data)) {
                resetOpeningState();
                this.shouldResetStateOnNextRootState = false;
                applyPayload(new BankScreenPayload(null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null));
                return;
            }
            boolean isLikelyPartialRootState = BankPayloadMerger.INSTANCE.isLikelyPartialRootState(data);
            if (hasLoadedRootState(this.currentPayload) || !isLikelyPartialRootState) {
                if (!isLikelyPartialRootState && this.shouldResetStateOnNextRootState) {
                    resetOpeningState();
                    this.shouldResetStateOnNextRootState = false;
                }
                BankScreenPayload mergeRootState = BankPayloadMerger.INSTANCE.mergeRootState(this.currentPayload, data);
                if (mergeRootState != null) {
                    applyPayload(mergeRootState);
                }
            }
        } else if (i == BankReceiveSubId.DEPOSIT_STATE.getSubId()) {
            boolean containsDepositSnapshotUpdate = BankPayloadMerger.INSTANCE.containsDepositSnapshotUpdate(data);
            if (applyPartialPayload(data)) {
                if (!containsDepositSnapshotUpdate || needsDepositIncome(this.currentPayload)) {
                    return;
                }
                this.hasReceivedDepositIncomeUpdate = true;
            } else if (shouldLockTopTabs(this.currentPayload)) {
            } else {
                BankPage.Companion companion = BankPage.Companion;
                Integer intOrNull = StringsKt.toIntOrNull(data);
                showPage(companion.fromServerOpenId(intOrNull != null ? intOrNull.intValue() : 1), true);
            }
        } else if (i == BankReceiveSubId.OTHER_STATE.getSubId()) {
            if (applyPartialPayload(data)) {
                return;
            }
            BankMainPageController bankMainPageController = this.mainPageController;
            BankMainSection.Companion companion2 = BankMainSection.Companion;
            Integer intOrNull2 = StringsKt.toIntOrNull(data);
            bankMainPageController.setMainSection(companion2.fromBackend(intOrNull2 != null ? intOrNull2.intValue() : BankMainSection.ACCOUNTS.getBackendValue()));
        } else if (i == BankReceiveSubId.SELECTED_BUSINESS_STATE.getSubId()) {
            applyWrappedPartialPayload("selectedBusiness", data);
        } else if (i == BankReceiveSubId.SELECTED_ELECTRIC_STATE.getSubId()) {
            applyWrappedPartialPayload("selectedElectric", data);
        } else if (i == BankReceiveSubId.CURRENCY_STATE.getSubId()) {
            applyPartialPayload(data);
        } else if (i == BankReceiveSubId.SIGNATURE_STATE.getSubId()) {
            this.cardIssuePageController.setSignatureCompleted(true);
        } else if (i == BankReceiveSubId.LAYOUT_MODE.getSubId()) {
            applyContentFrameMode(StringsKt.trim((CharSequence) data).toString());
        } else if (i == BankReceiveSubId.SELECTED_TAB.getSubId()) {
            BankPage.Companion companion3 = BankPage.Companion;
            Integer intOrNull3 = StringsKt.toIntOrNull(StringsKt.trim((CharSequence) data).toString());
            showPage(companion3.fromServerOpenId(intOrNull3 != null ? intOrNull3.intValue() : 1), true);
        } else if (i == BankReceiveSubId.GIVEAWAY_STATE.getSubId()) {
            applyPartialPayload(data);
        }
    }

    private final void applyContentFrameMode(String str) {
        boolean areEqual = Intrinsics.areEqual(str, "0");
        boolean z = this.isAtmMode;
        this.isAtmMode = !areEqual;
        this.binding.bankContent.setCorners(0.0f);
        this.binding.bankContentFrame.setCorners(0.0f);
        this.binding.bankScreen.setBackgroundResource(R.drawable.bank_screen_bg);
        this.binding.bankLogo.setImageResource(BankScreenKt.resolveBankLogoResource(this.isAtmMode));
        if (z != this.isAtmMode) {
            updateTopTabAccess(this.currentPayload);
            if (isPageAccessible(this.navigator.getCurrentPage(), this.currentPayload)) {
                return;
            }
            showPage$default(this, BankPage.MAIN, false, 2, null);
        }
    }

    private final void resetOpeningState() {
        this.openingStateGeneration++;
        this.currentPayload = new BankScreenPayload(null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
        this.isOpenAccountState = false;
        this.hasDismissedOpenAccountState = false;
        this.hasRequestedDepositIncome = false;
        this.isDepositIncomeRequestInFlight = false;
        this.hasReceivedDepositIncomeUpdate = false;
        this.hasRequestedCurrencyHistory = false;
        this.isCurrencyHistoryRequestInFlight = false;
        this.hasRequestedGiveawayPrizes = false;
        this.isGiveawayPrizesRequestInFlight = false;
        this.currentGiveawayPrizes = CollectionsKt.emptyList();
        stopGiveawayPrizesPolling();
        DialogBankHistory dialogBankHistory = this.historyDialog;
        if (dialogBankHistory != null) {
            dialogBankHistory.closeSilently();
        }
        this.historyDialog = null;
        for (BankPageController bankPageController : this.pageControllers) {
            bankPageController.resetState();
        }
        this.navigator.setVisibleTopTabs(visibleTopTabs(new BankScreenPayload(null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null)));
        this.navigator.setEnabledTopTabs(SetsKt.emptySet());
        this.navigator.showPage(BankPage.MAIN, false);
    }

    private final void setupTabs() {
        RecyclerView recyclerView = this.binding.bankTabsRecycler;
        recyclerView.setLayoutManager(new LinearLayoutManager(getTargetActivity(), 0, false));
        recyclerView.setAdapter(this.tabsAdapter);
        recyclerView.setItemAnimator(null);
    }

    private final void applyPayload(BankScreenPayload bankScreenPayload) {
        BankPage currentPage;
        boolean requiresAccountSetup = requiresAccountSetup(this.currentPayload);
        boolean requiresAccountSetup2 = requiresAccountSetup(bankScreenPayload);
        if (!requiresAccountSetup2 || !requiresAccountSetup) {
            this.hasDismissedOpenAccountState = false;
        }
        this.isOpenAccountState = requiresAccountSetup2 && !this.hasDismissedOpenAccountState;
        this.currentPayload = bankScreenPayload;
        for (BankPageController bankPageController : this.pageControllers) {
            bankPageController.bind(bankScreenPayload);
        }
        this.cardIssuePageController.setOpenAccountStateVisible(this.isOpenAccountState);
        if (!hasLoadedRootState(bankScreenPayload) || requiresAccountSetup(bankScreenPayload)) {
            this.hasRequestedDepositIncome = false;
            this.isDepositIncomeRequestInFlight = false;
            this.hasReceivedDepositIncomeUpdate = false;
            this.hasRequestedCurrencyHistory = false;
            this.isCurrencyHistoryRequestInFlight = false;
        }
        updateTopTabAccess(bankScreenPayload);
        if (requiresAccountSetup2) {
            currentPage = BankPage.CARD_ISSUE;
        } else if (this.navigator.getCurrentPage() == BankPage.LOTTERY && !BankContractKt.hasLotteryPage(bankScreenPayload)) {
            currentPage = BankPage.MAIN;
        } else if (this.navigator.getCurrentPage() == BankPage.CARD_ISSUE) {
            currentPage = BankPage.MAIN;
        } else {
            currentPage = !isPageAccessible(this.navigator.getCurrentPage(), bankScreenPayload) ? BankPage.MAIN : this.navigator.getCurrentPage();
        }
        this.navigator.showPage(currentPage, canShowCardIssue(bankScreenPayload));
        requestDepositIncomeIfNeeded(currentPage);
        requestCurrencyHistoryIfNeeded(currentPage);
        requestGiveawayPrizesIfNeeded(currentPage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPageTabClick(BankPage bankPage) {
        if (isPageAccessible(bankPage, this.currentPayload)) {
            showPage(bankPage, true);
        }
    }

    static /* synthetic */ void showPage$default(BankScreen bankScreen, BankPage bankPage, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        bankScreen.showPage(bankPage, z);
    }

    private final void showPage(BankPage bankPage, boolean z) {
        Integer topTabClickId;
        if (isPageAccessible(bankPage, this.currentPayload)) {
            BankPage showPage = this.navigator.showPage(bankPage, canShowCardIssue(this.currentPayload));
            if (z && (topTabClickId = showPage.getTopTabClickId()) != null) {
                dispatchAction(topTabClickId.intValue(), BankSendSubId.TOP_TAB_SELECT);
            }
            requestDepositIncomeIfNeeded(showPage);
            requestCurrencyHistoryIfNeeded(showPage);
            requestGiveawayPrizesIfNeeded(showPage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchAction(int i, BankSendSubId bankSendSubId) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[bankSendSubId.ordinal()];
        if (i2 == 1) {
            sendBackendAction(i, bankSendSubId);
            requestAccountHistory(i);
        } else if (i2 == 2) {
            sendBackendAction(i, bankSendSubId);
            requestDepositHistory();
        } else if (i2 == 3) {
            sendBackendAction(i, bankSendSubId);
            requestOrganizationHistory();
        } else {
            sendBackendAction(i, bankSendSubId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openSignatureModal() {
        dispatchAction(0, BankSendSubId.SIGNATURE_OPEN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openCardIssueForm() {
        this.hasDismissedOpenAccountState = true;
        this.isOpenAccountState = false;
        this.cardIssuePageController.setOpenAccountStateVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void submitCardIssue() {
        dispatchAction(0, BankSendSubId.BANK_ACCOUNT_OPEN);
    }

    private final void sendBackendAction(int i, BankSendSubId bankSendSubId) {
        BankClick resolveBankClick = BankScreenKt.resolveBankClick(i, bankSendSubId);
        notifyClick(resolveBankClick.getId(), resolveBankClick.getSubId(), resolveBankClick.getMessage());
    }

    private final boolean requiresAccountSetup(BankScreenPayload bankScreenPayload) {
        return BankContractKt.requiresBankAccountSetup(bankScreenPayload);
    }

    private final boolean shouldLockTopTabs(BankScreenPayload bankScreenPayload) {
        return requiresAccountSetup(bankScreenPayload);
    }

    private final void updateTopTabAccess(BankScreenPayload bankScreenPayload) {
        Set<BankPage> visibleTopTabs = visibleTopTabs(bankScreenPayload);
        this.navigator.setVisibleTopTabs(visibleTopTabs);
        this.navigator.setEnabledTopTabs(BankScreenKt.resolveEnabledBankTopTabs(visibleTopTabs, shouldLockTopTabs(bankScreenPayload), this.isAtmMode));
    }

    private final boolean isPageAccessible(BankPage bankPage, BankScreenPayload bankScreenPayload) {
        if (bankPage.getHasTopTab()) {
            return BankScreenKt.resolveEnabledBankTopTabs(visibleTopTabs(bankScreenPayload), shouldLockTopTabs(bankScreenPayload), this.isAtmMode).contains(bankPage);
        }
        return true;
    }

    private final boolean canShowCardIssue(BankScreenPayload bankScreenPayload) {
        return requiresAccountSetup(bankScreenPayload);
    }

    private final boolean hasLoadedRootState(BankScreenPayload bankScreenPayload) {
        return (bankScreenPayload.getName() == null && bankScreenPayload.getYears() == null && bankScreenPayload.getBirth() == null && bankScreenPayload.getBankAccounts().isEmpty() && bankScreenPayload.getOrganization() == null && bankScreenPayload.getRetirement() == null && bankScreenPayload.getTaxes() == null) ? false : true;
    }

    private final Set<BankPage> visibleTopTabs(BankScreenPayload bankScreenPayload) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : BankPage.getEntries()) {
            if (((BankPage) obj).getHasTopTab()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((BankPage) obj2) != BankPage.LOTTERY || BankContractKt.hasLotteryPage(bankScreenPayload)) {
                arrayList2.add(obj2);
            }
        }
        return CollectionsKt.toSet(arrayList2);
    }

    private final boolean isEmptyRootStatePayload(String str) {
        String obj = StringsKt.trim((CharSequence) str).toString();
        int hashCode = obj.hashCode();
        return hashCode != 0 ? hashCode != 3938 ? hashCode == 3392903 && obj.equals(AbstractJsonLexerKt.NULL) : obj.equals("{}") : obj.equals("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean applyPartialPayload(String str) {
        BankScreenPayload merge = BankPayloadMerger.INSTANCE.merge(this.currentPayload, str);
        if (merge == null) {
            return false;
        }
        applyPayload(merge);
        return true;
    }

    private final boolean applyWrappedPartialPayload(String str, String str2) {
        Object m9920constructorimpl;
        String json;
        String obj = StringsKt.trim((CharSequence) str2).toString();
        int hashCode = obj.hashCode();
        if (hashCode == 0 ? obj.equals("") : hashCode == 3938 ? obj.equals("{}") : hashCode == 3392903 && obj.equals(AbstractJsonLexerKt.NULL)) {
            json = "{\"" + str + "\":null}";
        } else {
            try {
                Result.Companion companion = Result.Companion;
                BankScreen bankScreen = this;
                m9920constructorimpl = Result.m9920constructorimpl((JsonObject) MapperKt.getGson().fromJson(str2, (Class<Object>) JsonObject.class));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m9920constructorimpl = Result.m9920constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m9926isFailureimpl(m9920constructorimpl)) {
                m9920constructorimpl = null;
            }
            JsonObject jsonObject = (JsonObject) m9920constructorimpl;
            if (jsonObject == null) {
                return false;
            }
            Gson gson = MapperKt.getGson();
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.add(str, jsonObject);
            json = gson.toJson((JsonElement) jsonObject2);
        }
        Intrinsics.checkNotNull(json);
        return applyPartialPayload(json);
    }

    private final void requestDepositIncomeIfNeeded(BankPage bankPage) {
        if (bankPage != BankPage.DEPOSIT || shouldLockTopTabs(this.currentPayload) || !needsDepositIncome(this.currentPayload) || this.hasRequestedDepositIncome || this.isDepositIncomeRequestInFlight || this.hasReceivedDepositIncomeUpdate) {
            return;
        }
        this.isDepositIncomeRequestInFlight = true;
        BuildersKt__Builders_commonKt.launch$default(this.bankRetrofitClient.getRetrofit().getScope(), null, null, new BankScreen$requestDepositIncomeIfNeeded$1(this, this.openingStateGeneration, null), 3, null);
    }

    private final void requestCurrencyHistoryIfNeeded(BankPage bankPage) {
        if (bankPage == BankPage.CURRENCY && isPageAccessible(BankPage.CURRENCY, this.currentPayload) && this.currentPayload.getCurrencyHistory().isEmpty() && !this.hasRequestedCurrencyHistory && !this.isCurrencyHistoryRequestInFlight) {
            this.isCurrencyHistoryRequestInFlight = true;
            BuildersKt__Builders_commonKt.launch$default(this.bankRetrofitClient.getRetrofit().getScope(), null, null, new BankScreen$requestCurrencyHistoryIfNeeded$1(this, this.openingStateGeneration, null), 3, null);
        }
    }

    private final void requestGiveawayPrizesIfNeeded(BankPage bankPage) {
        if (bankPage != BankPage.LOTTERY || !BankContractKt.hasLotteryPage(this.currentPayload)) {
            stopGiveawayPrizesPolling();
        } else if (this.hasRequestedGiveawayPrizes || this.isGiveawayPrizesRequestInFlight) {
            startGiveawayPrizesPollingIfNeeded();
        } else {
            this.hasRequestedGiveawayPrizes = true;
            this.isGiveawayPrizesRequestInFlight = true;
            BuildersKt__Builders_commonKt.launch$default(this.bankRetrofitClient.getRetrofit().getScope(), null, null, new BankScreen$requestGiveawayPrizesIfNeeded$1(this, this.openingStateGeneration, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bindGiveawayPrizes(List<BankLotteryRewardInfo> list) {
        this.currentGiveawayPrizes = list;
        this.lotteryPageController.bindPrizes(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startGiveawayPrizesPollingIfNeeded() {
        Job job;
        Job launch$default;
        BankLotteryInfo lottery = this.currentPayload.getLottery();
        if (this.navigator.getCurrentPage() != BankPage.LOTTERY || lottery == null || !BankContractKt.isAvailable(lottery) || BankLotteryResultStateKt.hasAllBankLotteryWinners(this.currentGiveawayPrizes) || ((job = this.giveawayPrizesPollingJob) != null && job.isActive())) {
            if (BankLotteryResultStateKt.hasAllBankLotteryWinners(this.currentGiveawayPrizes)) {
                stopGiveawayPrizesPolling();
                return;
            }
            return;
        }
        if (!lottery.getActiveState() || lottery.getEndTime() > 0) {
            int i = this.openingStateGeneration;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.bankRetrofitClient.getRetrofit().getScope(), null, null, new BankScreen$startGiveawayPrizesPollingIfNeeded$1(BankLotteryResultStateKt.hasBankLotteryEnded(lottery, currentTimeMillis) ? 0L : RangesKt.coerceAtLeast(lottery.getEndTime() - currentTimeMillis, 0L) * 1000, this, i, null), 3, null);
            this.giveawayPrizesPollingJob = launch$default;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadGiveawayPrizesOrNull(Continuation<? super List<BankLotteryRewardInfo>> continuation) {
        BankScreen$loadGiveawayPrizesOrNull$1 bankScreen$loadGiveawayPrizesOrNull$1;
        int i;
        try {
            if (continuation instanceof BankScreen$loadGiveawayPrizesOrNull$1) {
                bankScreen$loadGiveawayPrizesOrNull$1 = (BankScreen$loadGiveawayPrizesOrNull$1) continuation;
                if ((bankScreen$loadGiveawayPrizesOrNull$1.label & Integer.MIN_VALUE) != 0) {
                    bankScreen$loadGiveawayPrizesOrNull$1.label -= Integer.MIN_VALUE;
                    Object obj = bankScreen$loadGiveawayPrizesOrNull$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = bankScreen$loadGiveawayPrizesOrNull$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        BankApiRepository bankApiRepository = this.bankApiRepository;
                        bankScreen$loadGiveawayPrizesOrNull$1.label = 1;
                        obj = bankApiRepository.getGiveawayPrizes(bankScreen$loadGiveawayPrizesOrNull$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return (List) obj;
                }
            }
            if (i != 0) {
            }
            return (List) obj;
        } catch (CancellationException e) {
            throw e;
        } catch (Exception unused) {
            return null;
        }
        bankScreen$loadGiveawayPrizesOrNull$1 = new BankScreen$loadGiveawayPrizesOrNull$1(this, continuation);
        Object obj2 = bankScreen$loadGiveawayPrizesOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bankScreen$loadGiveawayPrizesOrNull$1.label;
    }

    private final void stopGiveawayPrizesPolling() {
        Job job = this.giveawayPrizesPollingJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.giveawayPrizesPollingJob = null;
    }

    private final void requestAccountHistory(int i) {
        String string = getTargetActivity().getString(R.string.bank_history_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        requestHistory(string, 0, new BankScreen$requestAccountHistory$1(this, i, null));
    }

    private final void requestDepositHistory() {
        String string = getTargetActivity().getString(R.string.bank_history_title_deposit);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        requestHistory(string, 1, new BankScreen$requestDepositHistory$1(this, null));
    }

    private final void requestOrganizationHistory() {
        String string = getTargetActivity().getString(R.string.bank_history_title_organization);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        requestHistory(string, 2, new BankScreen$requestOrganizationHistory$1(this, null));
    }

    private final void requestHistory(String str, int i, Function1<? super Continuation<? super String>, ? extends Object> function1) {
        BuildersKt__Builders_commonKt.launch$default(this.bankRetrofitClient.getRetrofit().getScope(), null, null, new BankScreen$requestHistory$1(function1, this, str, i, null), 3, null);
    }

    private final boolean needsDepositIncome(BankScreenPayload bankScreenPayload) {
        return !hasDepositIncomeHistory(bankScreenPayload.getIncome());
    }

    private final boolean hasDepositIncomeHistory(BankIncomeInfo bankIncomeInfo) {
        if (bankIncomeInfo == null) {
            return false;
        }
        return (bankIncomeInfo.getDay().getHistory().isEmpty() && bankIncomeInfo.getWeek().getHistory().isEmpty() && bankIncomeInfo.getMonth().getHistory().isEmpty()) ? false : true;
    }

    /* compiled from: BankScreen.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankScreen$Companion;", "", "<init>", "()V", "BANK_BACKEND_CLICK_LOG_TAG", "", "FULLSCREEN_LAYOUT_MODE", "HISTORY_TYPE_ACCOUNT", "", "HISTORY_TYPE_DEPOSIT", "HISTORY_TYPE_ORGANIZATION", "OPEN_START_ALPHA", "", "OPEN_START_SCALE", "CLOSE_END_ALPHA", "CLOSE_END_SCALE", "OPEN_ANIMATION_DURATION_MS", "", "CLOSE_ANIMATION_DURATION_MS", "OPEN_DECELERATION_FACTOR", "CLOSE_ACCELERATION_FACTOR", "GIVEAWAY_PRIZES_POLL_INTERVAL_MS", "MILLIS_PER_SECOND", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: BankScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.ARIZONA_BANK);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new BankScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}
