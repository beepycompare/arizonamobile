package ru.mrlargha.feature.battlepassWinter2025;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.adjust.sdk.Constants;
import com.arizona.game.BuildConfig;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.TimeConverterKt;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.ui.ArizonaRetrofit;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.battlepassWinter2025.data.ActualTask;
import ru.mrlargha.feature.battlepassWinter2025.data.AwardItemData;
import ru.mrlargha.feature.battlepassWinter2025.data.BattleCoinsMultiplier;
import ru.mrlargha.feature.battlepassWinter2025.data.BattlePassLevelSetData;
import ru.mrlargha.feature.battlepassWinter2025.data.BattlePassModelType;
import ru.mrlargha.feature.battlepassWinter2025.data.BattlePassPremiumData;
import ru.mrlargha.feature.battlepassWinter2025.data.BattlePassUpdateCoinsData;
import ru.mrlargha.feature.battlepassWinter2025.data.BpModalWindowModel;
import ru.mrlargha.feature.battlepassWinter2025.data.CategoryType;
import ru.mrlargha.feature.battlepassWinter2025.data.CommonTaskInfo;
import ru.mrlargha.feature.battlepassWinter2025.data.MainBattlePassInfo;
import ru.mrlargha.feature.battlepassWinter2025.data.RewardGetRequest;
import ru.mrlargha.feature.battlepassWinter2025.data.RouletteData;
import ru.mrlargha.feature.battlepassWinter2025.databinding.BpSeasonEndedBinding;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassBuyPremiumLayoutBinding;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassConvertBattlecoinsLayoutBinding;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassLayoutBinding;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassLevelSetsLayoutBinding;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassRouletteLayoutBinding;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassRouletteMainScreenBinding;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassTasksLayoutBinding;
import ru.mrlargha.feature.battlepassWinter2025.roulette.OldPriseAdapter;
import ru.mrlargha.feature.battlepassWinter2025.roulette.PriseAdapter;
import ru.mrlargha.feature.battlepassWinter2025.roulette.PriseModel;
import ru.mrlargha.feature.battlepassWinter2025.roulette.RoulettePrisesPicasso;
import ru.mrlargha.feature.battlepassWinter2025.roulette.data.OldPrise;
import ru.mrlargha.feature.battlepassWinter2025.roulette.data.PossiblePrise;
import ru.mrlargha.ui.kit.ParseColoredTextKt;
/* compiled from: Winter2025BattlePass.kt */
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0004\u0097\u0001\u0098\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u001cH\u0016J\u0018\u0010B\u001a\u00020@2\u0006\u0010C\u001a\u00020\t2\u0006\u0010D\u001a\u00020\u0005H\u0016J\u001c\u0010E\u001a\u00020@2\u0012\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\"0\"H\u0002J\b\u0010G\u001a\u00020@H\u0002J\b\u0010H\u001a\u00020\u0005H\u0002J\b\u0010I\u001a\u00020@H\u0002J\b\u0010J\u001a\u00020@H\u0002J\b\u0010K\u001a\u00020@H\u0002J\b\u0010L\u001a\u00020@H\u0002J\u0010\u0010M\u001a\u00020@2\u0006\u0010N\u001a\u00020OH\u0002J\b\u0010P\u001a\u00020@H\u0002J\u0010\u0010Q\u001a\u00020@2\u0006\u0010R\u001a\u00020SH\u0002J\u0010\u0010T\u001a\u00020@2\u0006\u0010R\u001a\u00020SH\u0002J\u0010\u0010U\u001a\u00020@2\u0006\u0010V\u001a\u00020\u0018H\u0003J\b\u0010W\u001a\u00020@H\u0002J\u0010\u0010X\u001a\u00020@2\u0006\u0010Y\u001a\u00020\u0005H\u0002J\u0018\u0010Z\u001a\u00020@2\u0006\u0010R\u001a\u00020&2\u0006\u0010[\u001a\u00020SH\u0002J\u0018\u0010\\\u001a\u00020@2\u0006\u0010R\u001a\u00020&2\u0006\u0010]\u001a\u00020\u0005H\u0002J\u0010\u0010^\u001a\u00020@2\u0006\u0010_\u001a\u00020`H\u0003J\u0016\u0010a\u001a\u00020@2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020c0\"H\u0002J*\u0010d\u001a\u00020@2\b\u0010e\u001a\u0004\u0018\u00010f2\u0006\u0010g\u001a\u00020f2\u0006\u0010h\u001a\u00020f2\u0006\u0010i\u001a\u00020jH\u0003J\u0016\u0010k\u001a\u00020@2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020j0\"H\u0003J\b\u0010m\u001a\u00020@H\u0002J\u0016\u0010n\u001a\u00020@2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020&0\"H\u0002J\u0016\u0010p\u001a\u00020@2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002060\"H\u0002J\"\u0010q\u001a\u00020@2\u0018\u0010r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0s0\"H\u0002J\b\u0010t\u001a\u00020@H\u0002J\u0018\u0010u\u001a\u00020@2\u0006\u0010v\u001a\u00020\u001c2\u0006\u0010]\u001a\u00020\u0005H\u0002J\u0016\u0010w\u001a\u00020@2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020x0\"H\u0002J\u0018\u0010y\u001a\u00020@2\u0006\u0010v\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020xH\u0002J\b\u0010z\u001a\u00020@H\u0002J\u0016\u0010{\u001a\u00020@2\f\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00050\"H\u0002J\u0010\u0010}\u001a\u00020@2\u0006\u0010~\u001a\u000200H\u0002J#\u0010\u007f\u001a\u00020\t2\u0007\u0010\u0080\u0001\u001a\u00020\u00052\u0007\u0010\u0081\u0001\u001a\u00020\u00052\u0007\u0010\u0082\u0001\u001a\u00020\tH\u0002J\u001b\u0010\u0083\u0001\u001a\u00020@2\u0007\u0010\u0080\u0001\u001a\u00020\u00052\u0007\u0010\u0082\u0001\u001a\u00020\tH\u0002J\u001b\u0010\u0084\u0001\u001a\u00020@2\u0007\u0010\u0080\u0001\u001a\u00020\u00052\u0007\u0010\u0082\u0001\u001a\u00020\tH\u0002J\u0018\u0010\u0085\u0001\u001a\u00020@2\r\u0010C\u001a\t\u0012\u0005\u0012\u00030\u0086\u00010\"H\u0002J\t\u0010\u0087\u0001\u001a\u00020@H\u0002J\t\u0010\u0088\u0001\u001a\u00020@H\u0002J\u0013\u0010\u0089\u0001\u001a\u00020@2\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0002J\t\u0010\u008c\u0001\u001a\u00020@H\u0002J\u0013\u0010\u008d\u0001\u001a\u00020@2\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0002J\u0013\u0010\u0090\u0001\u001a\u00020@2\b\u0010\u0091\u0001\u001a\u00030\u008f\u0001H\u0002J\u0013\u0010\u0092\u0001\u001a\u00020\t2\b\u0010\u0093\u0001\u001a\u00030\u008f\u0001H\u0002J\u0015\u0010\u0094\u0001\u001a\u00030\u0095\u00012\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u0002060\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\b\u0012\u0004\u0012\u0002060\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00109\u001a\u00020:¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0099\u0001"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/Winter2025BattlePassScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "tag", "", "azCoinsLink", "layout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "battlePassBinding", "Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassLayoutBinding;", "colorMaxProgress", "colorText", "commonTasksAdapter", "Lru/mrlargha/feature/battlepassWinter2025/CommonTasksAdapter;", "rewardsTasksAdapter", "Lru/mrlargha/feature/battlepassWinter2025/RewardsTasksAdapter;", "levelItemsAdapter", "Lru/mrlargha/feature/battlepassWinter2025/LevelItemsAdapter;", "battlePassInfo", "Lru/mrlargha/feature/battlepassWinter2025/data/MainBattlePassInfo;", "frontendLevelSetsMinimumSize", "frontendPremiumMinimumSize", "isLockLevelPage", "", "isLockPremiumPage", "startBattleCoinNumbCurse", "selectedBattleCoinMultiplier", "Lru/mrlargha/feature/battlepassWinter2025/data/BattleCoinsMultiplier;", "_bpUsualData", "", "Lru/mrlargha/feature/battlepassWinter2025/data/AwardItemData;", "_bpPremData", "_taskUsualData", "Lru/mrlargha/feature/battlepassWinter2025/data/CommonTaskInfo;", "_taskPremData", "blockTimerJob", "Lkotlinx/coroutines/Job;", "priseAdapter", "Lru/mrlargha/feature/battlepassWinter2025/roulette/PriseAdapter;", "oldPriseAdapter", "Lru/mrlargha/feature/battlepassWinter2025/roulette/OldPriseAdapter;", "possiblePrisesList", "", "Lru/mrlargha/feature/battlepassWinter2025/roulette/data/PossiblePrise;", "multiplierBuyRoulette", "isPremRoulette", "rouletteCount", "isRouletteOpen", "_usualTasks", "Lru/mrlargha/feature/battlepassWinter2025/data/ActualTask;", "_premTasks", "project", "client", "Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "getClient", "()Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "api", "Lru/mrlargha/feature/battlepassWinter2025/WinterBattlePassApi;", "setVisibility", "", "visible", "onBackendMessage", "data", "subId", "updateBpAwards", "awardsStatusList", "setupConvertBattleCoinsPage", "getChosenMultiplier", "updateUiBySelectedMultiplier", "setupBuyPremiumPage", "setupMainPageInfo", "setupNavigation", "clickButtonMenuNavigation", "navItem", "Lru/mrlargha/feature/battlepassWinter2025/Winter2025BattlePassScreen$NavItems;", "setupCommonTasksInfo", "filterListForSelectedTask", "task", "Lru/mrlargha/feature/battlepassWinter2025/data/CategoryType;", "setupThemeForSelectedTask", "updateMainPageInfo", "info", "updateLevelInfoOnPages", "updatePremiumButtonsVisibility", "premium", "setupTaskDataIntoUi", "categoryType", "showTaskInfo", "position", "updateCoins", "coinsData", "Lru/mrlargha/feature/battlepassWinter2025/data/BattlePassUpdateCoinsData;", "updateBattlePassPremium", "premiumList", "Lru/mrlargha/feature/battlepassWinter2025/data/BattlePassPremiumData;", "setupLevelSetText", "lvlText", "Landroid/widget/TextView;", "priceText", "discountText", "levelData", "Lru/mrlargha/feature/battlepassWinter2025/data/BattlePassLevelSetData;", "updateLevelSetsInfo", "levelSets", "setupLevelBuyPage", "updateCommonTaskItems", "commonTasks", "updateTasks", "updateLevelItems", "pairList", "Lkotlin/Pair;", "updateLogo", "onClaimItem", "isPremium", "setupRoulette", "Lru/mrlargha/feature/battlepassWinter2025/data/RouletteData;", "initRouletteView", "startRoulette", "rouletteSpinPrises", "list", "rouletteAddPossiblePrise", "prise", "calcRoulettePrice", FirebaseAnalytics.Param.PRICE, "multiplier", FirebaseAnalytics.Param.CURRENCY, "rouletteBuySelectSetup", "rouletteBuyButtonSetup", "updateOldPrises", "Lru/mrlargha/feature/battlepassWinter2025/roulette/data/OldPrise;", "onQuality", "setWelcomeScreen", "openModalWindow", CommonUrlParts.MODEL, "Lru/mrlargha/feature/battlepassWinter2025/data/BpModalWindowModel;", "setupListeners", "checkAvailableBp", "targetUnixTime", "", "startLeftTimer", "remainingMillis", "setLeftTime", "leftTime", "updateBlockTime", "", "time", "Spawner", "NavItems", "battle-pass_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Winter2025BattlePassScreen extends SAMPUIElement {
    private List<AwardItemData> _bpPremData;
    private List<AwardItemData> _bpUsualData;
    private List<ActualTask> _premTasks;
    private List<CommonTaskInfo> _taskPremData;
    private List<CommonTaskInfo> _taskUsualData;
    private List<ActualTask> _usualTasks;
    private final WinterBattlePassApi api;
    private final String azCoinsLink;
    private final WinterBattlepassLayoutBinding battlePassBinding;
    private MainBattlePassInfo battlePassInfo;
    private Job blockTimerJob;
    private final ArizonaRetrofit client;
    private final int colorMaxProgress;
    private final int colorText;
    private final CommonTasksAdapter commonTasksAdapter;
    private final int frontendLevelSetsMinimumSize;
    private final int frontendPremiumMinimumSize;
    private boolean isLockLevelPage;
    private boolean isLockPremiumPage;
    private boolean isPremRoulette;
    private boolean isRouletteOpen;
    private final ConstraintLayout layout;
    private final LevelItemsAdapter levelItemsAdapter;
    private int multiplierBuyRoulette;
    private final OldPriseAdapter oldPriseAdapter;
    private List<PossiblePrise> possiblePrisesList;
    private final PriseAdapter priseAdapter;
    private final String project;
    private final RewardsTasksAdapter rewardsTasksAdapter;
    private int rouletteCount;
    private BattleCoinsMultiplier selectedBattleCoinMultiplier;
    private final int startBattleCoinNumbCurse;
    private final String tag;

    /* compiled from: Winter2025BattlePass.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[BattlePassModelType.values().length];
            try {
                iArr[BattlePassModelType.MainBattlePass.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BattlePassModelType.LevelItems.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BattlePassModelType.CommonTasks.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BattlePassModelType.BattlePassLevelSets.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BattlePassModelType.BuyPremiumTypes.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[BattlePassModelType.UpdateCoins.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[BattlePassModelType.InitRoulette.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[BattlePassModelType.RoulettePossiblePrises.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[BattlePassModelType.RoulettePrises.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[BattlePassModelType.OldPrises.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[BattlePassModelType.Welcome.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[BattlePassModelType.ModalWindow.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[BattlePassModelType.BlockTimer.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BattleCoinsMultiplier.values().length];
            try {
                iArr2[BattleCoinsMultiplier.X10.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[BattleCoinsMultiplier.X100.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[BattleCoinsMultiplier.X1000.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[NavItems.values().length];
            try {
                iArr3[NavItems.MAIN_PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr3[NavItems.TASKS_PAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr3[NavItems.ROULETTE_PAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr3[NavItems.DONATE_PAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr3[NavItems.LEVEL_SETS.ordinal()] = 5;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr3[NavItems.BUY_PREMIUM.ordinal()] = 6;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr3[NavItems.CONVERT_BATTLE_COINS.ordinal()] = 7;
            } catch (NoSuchFieldError unused23) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[CategoryType.values().length];
            try {
                iArr4[CategoryType.DAILY.ordinal()] = 1;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr4[CategoryType.SHOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr4[CategoryType.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr4[CategoryType.PREMIUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused27) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rouletteSpinPrises$lambda$1(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setWelcomeScreen$lambda$0$0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$2(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Winter2025BattlePassScreen(final Activity targetActivity, int i) {
        super(targetActivity, i);
        String str;
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.tag = "Winter2025BattlePassScreen";
        if (UtilsKt.isArizonaType()) {
            str = "https://arizona-rp.com/shop";
        } else {
            str = "https://rodina-rp.com/shop";
        }
        this.azCoinsLink = str;
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.winter_battlepass_layout, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.layout = constraintLayout;
        WinterBattlepassLayoutBinding bind = WinterBattlepassLayoutBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.battlePassBinding = bind;
        Activity activity = targetActivity;
        int color = ContextCompat.getColor(activity, R.color.battlepass1);
        this.colorMaxProgress = color;
        int color2 = ContextCompat.getColor(activity, R.color.battlepass_stick_color);
        this.colorText = color2;
        this.commonTasksAdapter = new CommonTasksAdapter(UtilsKt.isArizonaType(), color, new Function2() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit commonTasksAdapter$lambda$0;
                commonTasksAdapter$lambda$0 = Winter2025BattlePassScreen.commonTasksAdapter$lambda$0(Winter2025BattlePassScreen.this, (CommonTaskInfo) obj, ((Integer) obj2).intValue());
                return commonTasksAdapter$lambda$0;
            }
        });
        this.rewardsTasksAdapter = new RewardsTasksAdapter(UtilsKt.isArizonaType());
        this.levelItemsAdapter = new LevelItemsAdapter(color, color2, new Function0() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit levelItemsAdapter$lambda$0;
                levelItemsAdapter$lambda$0 = Winter2025BattlePassScreen.levelItemsAdapter$lambda$0(Winter2025BattlePassScreen.this);
                return levelItemsAdapter$lambda$0;
            }
        }, new Function0() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit levelItemsAdapter$lambda$1;
                levelItemsAdapter$lambda$1 = Winter2025BattlePassScreen.levelItemsAdapter$lambda$1(Winter2025BattlePassScreen.this);
                return levelItemsAdapter$lambda$1;
            }
        }, new Function2() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit levelItemsAdapter$lambda$2;
                levelItemsAdapter$lambda$2 = Winter2025BattlePassScreen.levelItemsAdapter$lambda$2(Winter2025BattlePassScreen.this, ((Boolean) obj).booleanValue(), ((Integer) obj2).intValue());
                return levelItemsAdapter$lambda$2;
            }
        }, new Function0() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit levelItemsAdapter$lambda$3;
                levelItemsAdapter$lambda$3 = Winter2025BattlePassScreen.levelItemsAdapter$lambda$3(Winter2025BattlePassScreen.this);
                return levelItemsAdapter$lambda$3;
            }
        });
        this.frontendLevelSetsMinimumSize = 4;
        this.frontendPremiumMinimumSize = 2;
        this.startBattleCoinNumbCurse = 250;
        this.selectedBattleCoinMultiplier = BattleCoinsMultiplier.X1000;
        this._bpUsualData = CollectionsKt.emptyList();
        this._bpPremData = CollectionsKt.emptyList();
        this._taskUsualData = CollectionsKt.emptyList();
        this._taskPremData = CollectionsKt.emptyList();
        this.priseAdapter = new PriseAdapter(new Function4() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit priseAdapter$lambda$0;
                priseAdapter$lambda$0 = Winter2025BattlePassScreen.priseAdapter$lambda$0(Winter2025BattlePassScreen.this, targetActivity, ((Float) obj).floatValue(), ((Float) obj2).floatValue(), (String) obj3, ((Integer) obj4).intValue());
                return priseAdapter$lambda$0;
            }
        });
        this.oldPriseAdapter = new OldPriseAdapter();
        this.possiblePrisesList = new ArrayList();
        this.multiplierBuyRoulette = 1;
        this._usualTasks = CollectionsKt.emptyList();
        this._premTasks = CollectionsKt.emptyList();
        this.project = UtilsKt.isArizonaType() ? BuildConfig.FLAVOR : "rodina";
        ArizonaRetrofit arizonaRetrofit = new ArizonaRetrofit(targetActivity, i);
        this.client = arizonaRetrofit;
        this.api = (WinterBattlePassApi) ArizonaRetrofit.create$default(arizonaRetrofit, WinterBattlePassApi.class, false, null, 6, null);
        RoulettePrisesPicasso.INSTANCE.isArizona(UtilsKt.isArizonaType());
        addViewToConstraintLayout(constraintLayout, -1, -1);
        bind.battlepass2023Container.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen._init_$lambda$0(view);
            }
        });
        LinearLayout buttonBuyBattlePoints = bind.buttonBuyBattlePoints;
        Intrinsics.checkNotNullExpressionValue(buttonBuyBattlePoints, "buttonBuyBattlePoints");
        buttonBuyBattlePoints.setVisibility(8);
        setWelcomeScreen();
        setupNavigation();
        setupMainPageInfo();
        setupCommonTasksInfo();
        setupLevelBuyPage();
        setupConvertBattleCoinsPage();
        clickButtonMenuNavigation(NavItems.MAIN_PAGE);
        setupListeners();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit commonTasksAdapter$lambda$0(Winter2025BattlePassScreen winter2025BattlePassScreen, CommonTaskInfo task, int i) {
        Intrinsics.checkNotNullParameter(task, "task");
        winter2025BattlePassScreen.showTaskInfo(task, i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit levelItemsAdapter$lambda$0(Winter2025BattlePassScreen winter2025BattlePassScreen) {
        winter2025BattlePassScreen.clickButtonMenuNavigation(NavItems.LEVEL_SETS);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit levelItemsAdapter$lambda$1(Winter2025BattlePassScreen winter2025BattlePassScreen) {
        winter2025BattlePassScreen.onQuality();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit levelItemsAdapter$lambda$2(Winter2025BattlePassScreen winter2025BattlePassScreen, boolean z, int i) {
        winter2025BattlePassScreen.onClaimItem(z, i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit levelItemsAdapter$lambda$3(Winter2025BattlePassScreen winter2025BattlePassScreen) {
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, 0, 21, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit priseAdapter$lambda$0(final Winter2025BattlePassScreen winter2025BattlePassScreen, Activity activity, float f, float f2, String name, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        Log.d("name", TypedValues.CycleType.S_WAVE_OFFSET + f + " " + f2);
        WinterBattlepassLayoutBinding winterBattlepassLayoutBinding = winter2025BattlePassScreen.battlePassBinding;
        View findViewWithTag = winterBattlepassLayoutBinding.getRoot().findViewWithTag("winterbp_prise_name");
        if (findViewWithTag == null) {
            Log.d("name", AbstractJsonLexerKt.NULL);
            View inflate = activity.getLayoutInflater().inflate(R.layout.winter_battlepass_roulette_prise_name_item, (ViewGroup) winter2025BattlePassScreen.battlePassBinding.getRoot(), false);
            inflate.setTag("winterbp_prise_name");
            inflate.setX(f - winter2025BattlePassScreen.battlePassBinding.getRoot().getPaddingLeft());
            inflate.setY(f2 - winter2025BattlePassScreen.battlePassBinding.getRoot().getPaddingTop());
            inflate.setLayoutParams(new ViewGroup.LayoutParams(i, -2));
            ((TextView) inflate.findViewById(R.id.tv_prise_name)).setText(name);
            winter2025BattlePassScreen.battlePassBinding.getRoot().addView(inflate);
        } else {
            Log.d("name", "not null");
            findViewWithTag.setVisibility(0);
            findViewWithTag.setX(f - 50);
            findViewWithTag.setY(f2);
            ((TextView) findViewWithTag.findViewById(R.id.tv_prise_name)).setText(name);
        }
        winter2025BattlePassScreen.battlePassBinding.clickBlocker.setVisibility(0);
        winter2025BattlePassScreen.battlePassBinding.clickBlocker.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda49
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.priseAdapter$lambda$0$0$0(Winter2025BattlePassScreen.this, r2, view);
            }
        });
        winterBattlepassLayoutBinding.battlepassRouletteView.priseListRv.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$priseAdapter$1$1$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                WinterBattlepassLayoutBinding winterBattlepassLayoutBinding2;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, i2, i3);
                winterBattlepassLayoutBinding2 = Winter2025BattlePassScreen.this.battlePassBinding;
                View findViewWithTag2 = winterBattlepassLayoutBinding2.getRoot().findViewWithTag(r2);
                if (findViewWithTag2 != null) {
                    findViewWithTag2.setVisibility(8);
                }
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void priseAdapter$lambda$0$0$0(Winter2025BattlePassScreen winter2025BattlePassScreen, String str, View view) {
        View findViewWithTag = winter2025BattlePassScreen.battlePassBinding.getRoot().findViewWithTag(str);
        if (findViewWithTag != null) {
            findViewWithTag.setVisibility(8);
        }
        winter2025BattlePassScreen.battlePassBinding.clickBlocker.setVisibility(8);
    }

    public final ArizonaRetrofit getClient() {
        return this.client;
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        if (!z) {
            this.commonTasksAdapter.clearAllTasksList();
            this.levelItemsAdapter.clearItems();
            RoulettePrisesPicasso.INSTANCE.clear();
        }
        super.setVisibility(z);
        Log.d(this.tag, "setVisibility: " + z);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Log.d(this.tag, "onBackendMessage: subId= " + i + " data = " + data);
        try {
            switch (WhenMappings.$EnumSwitchMapping$0[BattlePassModelType.Companion.fromType(i).ordinal()]) {
                case 1:
                    updateMainPageInfo((MainBattlePassInfo) MapperKt.toModel(data, MainBattlePassInfo.class));
                    return;
                case 2:
                    return;
                case 3:
                    updateTasks(MapperKt.toListModel(data, ActualTask.class));
                    return;
                case 4:
                    updateLevelSetsInfo(MapperKt.toListModel(data, BattlePassLevelSetData.class));
                    return;
                case 5:
                    updateBattlePassPremium(MapperKt.toListModel(data, BattlePassPremiumData.class));
                    return;
                case 6:
                    updateCoins((BattlePassUpdateCoinsData) MapperKt.toModel(data, BattlePassUpdateCoinsData.class));
                    return;
                case 7:
                    setupRoulette(MapperKt.toListModel(data, RouletteData.class));
                    return;
                case 8:
                    rouletteAddPossiblePrise((PossiblePrise) CollectionsKt.first((List<? extends Object>) MapperKt.toListModel(data, PossiblePrise.class)));
                    return;
                case 9:
                    rouletteSpinPrises(MapperKt.toListModel(data, Integer.TYPE));
                    return;
                case 10:
                    updateOldPrises(MapperKt.toListModel(data, OldPrise.class));
                    return;
                case 11:
                    setWelcomeScreen();
                    return;
                case 12:
                    if (data.length() == 0) {
                        FrameLayout root = this.battlePassBinding.seasonEnded.getRoot();
                        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                        root.setVisibility(8);
                        return;
                    } else if (MapperKt.isJsonValid(data)) {
                        openModalWindow((BpModalWindowModel) new GsonBuilder().setLenient().create().fromJson(data, (Class<Object>) BpModalWindowModel.class));
                        return;
                    } else {
                        throw new JsonParseException("Json is not valid");
                    }
                case 13:
                    checkAvailableBp(Long.parseLong(data));
                    return;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } catch (Exception e) {
            Log.d(this.tag, "onBackendMessage: subId = " + i + ", ex = " + e);
        }
    }

    private final void updateBpAwards(List<? extends List<Integer>> list) {
        BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), Dispatchers.getIO(), null, new Winter2025BattlePassScreen$updateBpAwards$1(this, list, null), 2, null);
    }

    private final void setupConvertBattleCoinsPage() {
        final WinterBattlepassConvertBattlecoinsLayoutBinding winterBattlepassConvertBattlecoinsLayoutBinding = this.battlePassBinding.battlepassConvertBattlecoinsPage;
        winterBattlepassConvertBattlecoinsLayoutBinding.buttonBattleCoinsConvert.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupConvertBattleCoinsPage$lambda$0$0(Winter2025BattlePassScreen.this, winterBattlepassConvertBattlecoinsLayoutBinding, view);
            }
        });
        winterBattlepassConvertBattlecoinsLayoutBinding.plusBattlepointsButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda51
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupConvertBattleCoinsPage$lambda$0$1(WinterBattlepassConvertBattlecoinsLayoutBinding.this, this, view);
            }
        });
        winterBattlepassConvertBattlecoinsLayoutBinding.minusBattlepointsButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupConvertBattleCoinsPage$lambda$0$2(WinterBattlepassConvertBattlecoinsLayoutBinding.this, this, view);
            }
        });
        winterBattlepassConvertBattlecoinsLayoutBinding.multiplierBattlepoints10Text.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda53
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupConvertBattleCoinsPage$lambda$0$3(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassConvertBattlecoinsLayoutBinding.multiplierBattlepoints100Text.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda54
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupConvertBattleCoinsPage$lambda$0$4(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassConvertBattlecoinsLayoutBinding.multiplierBattlepoints1000Text.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupConvertBattleCoinsPage$lambda$0$5(Winter2025BattlePassScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupConvertBattleCoinsPage$lambda$0$0(Winter2025BattlePassScreen winter2025BattlePassScreen, WinterBattlepassConvertBattlecoinsLayoutBinding winterBattlepassConvertBattlecoinsLayoutBinding, View view) {
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, Integer.parseInt(winterBattlepassConvertBattlecoinsLayoutBinding.coinsConvertNumbText.getText().toString()), 8, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupConvertBattleCoinsPage$lambda$0$1(WinterBattlepassConvertBattlecoinsLayoutBinding winterBattlepassConvertBattlecoinsLayoutBinding, Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        int parseInt = Integer.parseInt(winterBattlepassConvertBattlecoinsLayoutBinding.coinsConvertNumbText.getText().toString()) + winter2025BattlePassScreen.getChosenMultiplier();
        winterBattlepassConvertBattlecoinsLayoutBinding.coinsConvertNumbText.setText(String.valueOf(parseInt));
        MainBattlePassInfo mainBattlePassInfo = winter2025BattlePassScreen.battlePassInfo;
        if (mainBattlePassInfo != null) {
            winterBattlepassConvertBattlecoinsLayoutBinding.battlepointsAmountText.setText(String.valueOf(parseInt / mainBattlePassInfo.getPassCoinCurseAzCoins()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupConvertBattleCoinsPage$lambda$0$2(WinterBattlepassConvertBattlecoinsLayoutBinding winterBattlepassConvertBattlecoinsLayoutBinding, Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        int parseInt = Integer.parseInt(winterBattlepassConvertBattlecoinsLayoutBinding.coinsConvertNumbText.getText().toString()) - winter2025BattlePassScreen.getChosenMultiplier();
        if (parseInt <= 0) {
            parseInt = 0;
        }
        winterBattlepassConvertBattlecoinsLayoutBinding.coinsConvertNumbText.setText(String.valueOf(parseInt));
        MainBattlePassInfo mainBattlePassInfo = winter2025BattlePassScreen.battlePassInfo;
        if (mainBattlePassInfo != null) {
            winterBattlepassConvertBattlecoinsLayoutBinding.battlepointsAmountText.setText(String.valueOf(parseInt / mainBattlePassInfo.getPassCoinCurseAzCoins()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupConvertBattleCoinsPage$lambda$0$3(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.selectedBattleCoinMultiplier = BattleCoinsMultiplier.X10;
        winter2025BattlePassScreen.updateUiBySelectedMultiplier();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupConvertBattleCoinsPage$lambda$0$4(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.selectedBattleCoinMultiplier = BattleCoinsMultiplier.X100;
        winter2025BattlePassScreen.updateUiBySelectedMultiplier();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupConvertBattleCoinsPage$lambda$0$5(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.selectedBattleCoinMultiplier = BattleCoinsMultiplier.X1000;
        winter2025BattlePassScreen.updateUiBySelectedMultiplier();
    }

    private final int getChosenMultiplier() {
        int i = WhenMappings.$EnumSwitchMapping$1[this.selectedBattleCoinMultiplier.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return 1000;
                }
                throw new NoWhenBranchMatchedException();
            }
            return 100;
        }
        return 10;
    }

    private final void updateUiBySelectedMultiplier() {
        WinterBattlepassConvertBattlecoinsLayoutBinding winterBattlepassConvertBattlecoinsLayoutBinding = this.battlePassBinding.battlepassConvertBattlecoinsPage;
        winterBattlepassConvertBattlecoinsLayoutBinding.multiplierBattlepoints10Text.setBackgroundResource(R.drawable.border_rodina_battlepass_battlepoints);
        winterBattlepassConvertBattlecoinsLayoutBinding.multiplierBattlepoints100Text.setBackgroundResource(R.drawable.border_rodina_battlepass_battlepoints);
        winterBattlepassConvertBattlecoinsLayoutBinding.multiplierBattlepoints1000Text.setBackgroundResource(R.drawable.border_rodina_battlepass_battlepoints);
        int i = WhenMappings.$EnumSwitchMapping$1[this.selectedBattleCoinMultiplier.ordinal()];
        if (i == 1) {
            winterBattlepassConvertBattlecoinsLayoutBinding.multiplierBattlepoints10Text.setBackgroundResource(R.drawable.border_rodina_battlepass_battlepoints_gold);
        } else if (i == 2) {
            winterBattlepassConvertBattlecoinsLayoutBinding.multiplierBattlepoints100Text.setBackgroundResource(R.drawable.border_rodina_battlepass_battlepoints_gold);
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            winterBattlepassConvertBattlecoinsLayoutBinding.multiplierBattlepoints1000Text.setBackgroundResource(R.drawable.border_rodina_battlepass_battlepoints_gold);
        }
    }

    private final void setupBuyPremiumPage() {
        WinterBattlepassBuyPremiumLayoutBinding winterBattlepassBuyPremiumLayoutBinding = this.battlePassBinding.battlepassLevelPremiumPage;
        winterBattlepassBuyPremiumLayoutBinding.premiumDiscountText.setPaintFlags(16);
        winterBattlepassBuyPremiumLayoutBinding.premiumPlusDiscountText.setPaintFlags(16);
        MainBattlePassInfo mainBattlePassInfo = this.battlePassInfo;
        if (mainBattlePassInfo != null) {
            int premium = mainBattlePassInfo.getPremium();
            if (premium == 0) {
                winterBattlepassBuyPremiumLayoutBinding.premiumPriceButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda37
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Winter2025BattlePassScreen.setupBuyPremiumPage$lambda$0$0$0(Winter2025BattlePassScreen.this, view);
                    }
                });
                winterBattlepassBuyPremiumLayoutBinding.premiumPriceButtonText.setText("КУПИТЬ");
                winterBattlepassBuyPremiumLayoutBinding.premiumPriceButton.setAlpha(1.0f);
            } else if (premium == 1) {
                RelativeLayout relativeLayout = winterBattlepassBuyPremiumLayoutBinding.premiumPriceButton;
                winterBattlepassBuyPremiumLayoutBinding.premiumPriceButtonText.setText("КУПЛЕНО");
                winterBattlepassBuyPremiumLayoutBinding.premiumPriceButton.setAlpha(0.5f);
            }
        }
        winterBattlepassBuyPremiumLayoutBinding.premiumPlusPriceButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupBuyPremiumPage$lambda$0$1(Winter2025BattlePassScreen.this, view);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new Winter2025BattlePassScreen$setupBuyPremiumPage$1$3(winterBattlepassBuyPremiumLayoutBinding, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupBuyPremiumPage$lambda$0$0$0(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, 0, 6, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupBuyPremiumPage$lambda$0$1(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, 1, 6, null, 4, null);
    }

    private final void setupMainPageInfo() {
        WinterBattlepassLayoutBinding winterBattlepassLayoutBinding = this.battlePassBinding;
        winterBattlepassLayoutBinding.levelItemsRc.setAdapter(this.levelItemsAdapter);
        winterBattlepassLayoutBinding.battlepassTasksPage.taskItemsRewardsList.setAdapter(this.rewardsTasksAdapter);
    }

    private final void setupNavigation() {
        WinterBattlepassLayoutBinding winterBattlepassLayoutBinding = this.battlePassBinding;
        winterBattlepassLayoutBinding.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupNavigation$lambda$0$0(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassLayoutBinding.mainNavMenuButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupNavigation$lambda$0$1(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassLayoutBinding.tasksNavMenuButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupNavigation$lambda$0$2(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassLayoutBinding.rouletteNavMenuButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupNavigation$lambda$0$3(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassLayoutBinding.casesNavMenuButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupNavigation$lambda$0$4(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassLayoutBinding.donateNavMenuButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupNavigation$lambda$0$5(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassLayoutBinding.buyLevelsBtn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupNavigation$lambda$0$6(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassLayoutBinding.buyPremiumBtn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupNavigation$lambda$0$7(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassLayoutBinding.buttonBuyBattlePoints.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupNavigation$lambda$0$8(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassLayoutBinding.buttonBuyAzCoins.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupNavigation$lambda$0$9(Winter2025BattlePassScreen.this, view);
            }
        });
        WinterBattlepassRouletteLayoutBinding winterBattlepassRouletteLayoutBinding = this.battlePassBinding.battlepassRoulettePage;
        winterBattlepassRouletteLayoutBinding.premText.setColorList(CollectionsKt.listOf((Object[]) new String[]{"#EBFFD7", "#C6EB8B"}));
        if (UtilsKt.isArizonaType()) {
            winterBattlepassRouletteLayoutBinding.usualTitle1.setVisibility(0);
            winterBattlepassRouletteLayoutBinding.usualTitle.setText("Гетто");
            winterBattlepassRouletteLayoutBinding.usualTitle2.setVisibility(8);
        } else {
            winterBattlepassRouletteLayoutBinding.usualTitle1.setVisibility(8);
            winterBattlepassRouletteLayoutBinding.usualTitle.setText("Уличная");
            winterBattlepassRouletteLayoutBinding.usualTitle2.setVisibility(0);
        }
        this.battlePassBinding.overlay.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupNavigation$lambda$2(Winter2025BattlePassScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$0(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.isRouletteOpen = false;
        winter2025BattlePassScreen.setVisibility(false);
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, 0, 10, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$1(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.clickButtonMenuNavigation(NavItems.MAIN_PAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$2(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.clickButtonMenuNavigation(NavItems.TASKS_PAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$3(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.clickButtonMenuNavigation(NavItems.ROULETTE_PAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$4(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, 2, 11, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$5(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.clickButtonMenuNavigation(NavItems.DONATE_PAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$6(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.clickButtonMenuNavigation(NavItems.LEVEL_SETS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$7(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.clickButtonMenuNavigation(NavItems.BUY_PREMIUM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$8(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.clickButtonMenuNavigation(NavItems.CONVERT_BATTLE_COINS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$9(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        StringKt.openLink(winter2025BattlePassScreen.azCoinsLink, winter2025BattlePassScreen.getTargetActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$2(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.battlePassBinding.overlay.setVisibility(8);
        winter2025BattlePassScreen.battlePassBinding.cardInfo.setVisibility(8);
    }

    private final void clickButtonMenuNavigation(NavItems navItems) {
        WinterBattlepassLayoutBinding winterBattlepassLayoutBinding = this.battlePassBinding;
        this.isRouletteOpen = false;
        winterBattlepassLayoutBinding.battlePassMainPageContainer.setVisibility(8);
        winterBattlepassLayoutBinding.battlepassTasksPage.getRoot().setVisibility(8);
        winterBattlepassLayoutBinding.battlepassRoulettePage.getRoot().setVisibility(8);
        winterBattlepassLayoutBinding.battlepassConvertBattlecoinsPage.getRoot().setVisibility(8);
        winterBattlepassLayoutBinding.battlepassLevelSetsPage.getRoot().setVisibility(8);
        winterBattlepassLayoutBinding.battlepassLevelSetsPageMaximum.getRoot().setVisibility(8);
        winterBattlepassLayoutBinding.battlepassLevelPremiumPage.getRoot().setVisibility(8);
        winterBattlepassLayoutBinding.battlepassRouletteView.getRoot().setVisibility(8);
        winterBattlepassLayoutBinding.logo.setVisibility(8);
        winterBattlepassLayoutBinding.tasksNavMenuButton.setAlpha(0.5f);
        winterBattlepassLayoutBinding.rouletteNavMenuButton.setAlpha(0.5f);
        winterBattlepassLayoutBinding.mainNavMenuButton.setAlpha(0.5f);
        winterBattlepassLayoutBinding.shopNavMenuButton.setAlpha(0.5f);
        winterBattlepassLayoutBinding.donateNavMenuButton.setAlpha(0.5f);
        winterBattlepassLayoutBinding.infoNavMenuButton.setAlpha(0.5f);
        switch (WhenMappings.$EnumSwitchMapping$2[navItems.ordinal()]) {
            case 1:
                winterBattlepassLayoutBinding.mainNavMenuButton.setAlpha(1.0f);
                winterBattlepassLayoutBinding.battlePassMainPageContainer.setVisibility(0);
                winterBattlepassLayoutBinding.battlepassContainerBg.setImageResource(R.drawable.battlepass_2025_winter_bg1);
                updateLogo();
                winterBattlepassLayoutBinding.logo.setVisibility(0);
                return;
            case 2:
                winterBattlepassLayoutBinding.tasksNavMenuButton.setAlpha(1.0f);
                winterBattlepassLayoutBinding.battlepassTasksPage.getRoot().setVisibility(0);
                setupThemeForSelectedTask(CategoryType.DAILY);
                filterListForSelectedTask(CategoryType.DAILY);
                CommonTaskInfo commonTaskInfo = !this.commonTasksAdapter.getCurrentTasksList().isEmpty() ? this.commonTasksAdapter.getCurrentTasksList().get(0) : null;
                if (commonTaskInfo != null) {
                    setupTaskDataIntoUi(commonTaskInfo, CategoryType.DAILY);
                }
                winterBattlepassLayoutBinding.battlepassContainerBg.setImageResource(R.drawable.battlepass_2025_winter_bg2);
                winterBattlepassLayoutBinding.logo.setVisibility(8);
                this.isRouletteOpen = true;
                return;
            case 3:
                SAMPUIElement.notifyClick$default(this, 2, 11, null, 4, null);
                winterBattlepassLayoutBinding.rouletteNavMenuButton.setAlpha(1.0f);
                winterBattlepassLayoutBinding.battlepassRoulettePage.getRoot().setVisibility(0);
                winterBattlepassLayoutBinding.battlepassContainerBg.setImageResource(R.drawable.battlepass_2025_winter_bg_glass);
                this.isRouletteOpen = true;
                return;
            case 4:
                SAMPUIElement.notifyClick$default(this, 0, 9, null, 4, null);
                return;
            case 5:
                MainBattlePassInfo mainBattlePassInfo = this.battlePassInfo;
                if ((mainBattlePassInfo != null ? mainBattlePassInfo.getLevel() : 0) >= 100) {
                    winterBattlepassLayoutBinding.battlepassLevelSetsPageMaximum.getRoot().setVisibility(0);
                    winterBattlepassLayoutBinding.battlepassLevelSetsPageMaximum.buttonReturn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda31
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            Winter2025BattlePassScreen.clickButtonMenuNavigation$lambda$0$0(Winter2025BattlePassScreen.this, view);
                        }
                    });
                    winterBattlepassLayoutBinding.battlepassContainerBg.setImageResource(R.drawable.battlepass_2025_winter_bg2);
                    return;
                }
                if (!this.isLockLevelPage) {
                    winterBattlepassLayoutBinding.battlepassLevelSetsPage.getRoot().setVisibility(0);
                }
                winterBattlepassLayoutBinding.battlepassContainerBg.setImageResource(R.drawable.battlepass_2025_winter_bg1);
                return;
            case 6:
                if (!this.isLockPremiumPage) {
                    winterBattlepassLayoutBinding.battlepassLevelPremiumPage.getRoot().setVisibility(0);
                }
                winterBattlepassLayoutBinding.battlepassContainerBg.setImageResource(R.drawable.battlepass_2025_winter_bg1);
                return;
            case 7:
                winterBattlepassLayoutBinding.battlepassConvertBattlecoinsPage.getRoot().setVisibility(0);
                winterBattlepassLayoutBinding.battlepassContainerBg.setImageResource(R.drawable.battlepass_2025_winter_bg1);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clickButtonMenuNavigation$lambda$0$0(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.clickButtonMenuNavigation(NavItems.MAIN_PAGE);
    }

    private final void setupCommonTasksInfo() {
        WinterBattlepassTasksLayoutBinding winterBattlepassTasksLayoutBinding = this.battlePassBinding.battlepassTasksPage;
        winterBattlepassTasksLayoutBinding.commonTaskRecycleView.setAdapter(this.commonTasksAdapter);
        winterBattlepassTasksLayoutBinding.buttonDailyTasks.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda32
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupCommonTasksInfo$lambda$0$0(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassTasksLayoutBinding.buttonPremiumTasks.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupCommonTasksInfo$lambda$0$1(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassTasksLayoutBinding.buyLevelsBtnSd.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda35
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupCommonTasksInfo$lambda$0$2(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassTasksLayoutBinding.btnBuyPremiumLock.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda36
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupCommonTasksInfo$lambda$0$3(Winter2025BattlePassScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCommonTasksInfo$lambda$0$0(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.setupThemeForSelectedTask(CategoryType.DAILY);
        winter2025BattlePassScreen.filterListForSelectedTask(CategoryType.DAILY);
        CommonTaskInfo commonTaskInfo = !winter2025BattlePassScreen.commonTasksAdapter.getCurrentTasksList().isEmpty() ? winter2025BattlePassScreen.commonTasksAdapter.getCurrentTasksList().get(0) : null;
        if (commonTaskInfo != null) {
            winter2025BattlePassScreen.setupTaskDataIntoUi(commonTaskInfo, CategoryType.DAILY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCommonTasksInfo$lambda$0$1(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.setupThemeForSelectedTask(CategoryType.PREMIUM);
        winter2025BattlePassScreen.filterListForSelectedTask(CategoryType.PREMIUM);
        CommonTaskInfo commonTaskInfo = !winter2025BattlePassScreen.commonTasksAdapter.getCurrentTasksList().isEmpty() ? winter2025BattlePassScreen.commonTasksAdapter.getCurrentTasksList().get(0) : null;
        if (commonTaskInfo != null) {
            winter2025BattlePassScreen.setupTaskDataIntoUi(commonTaskInfo, CategoryType.PREMIUM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCommonTasksInfo$lambda$0$2(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.clickButtonMenuNavigation(NavItems.LEVEL_SETS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCommonTasksInfo$lambda$0$3(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.clickButtonMenuNavigation(NavItems.BUY_PREMIUM);
    }

    private final void filterListForSelectedTask(CategoryType categoryType) {
        Object obj;
        Iterator<T> it = this.commonTasksAdapter.getAllTasksList().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            CommonTaskInfo commonTaskInfo = (CommonTaskInfo) it.next();
            Iterator<T> it2 = (categoryType == CategoryType.DAILY ? this._usualTasks : this._premTasks).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                ActualTask actualTask = (ActualTask) obj;
                if (actualTask.getId() == commonTaskInfo.getId() && Intrinsics.areEqual(actualTask.getCategoryId(), commonTaskInfo.getCategoryId())) {
                    break;
                }
            }
            ActualTask actualTask2 = (ActualTask) obj;
            if (actualTask2 != null) {
                commonTaskInfo.setVisible(actualTask2.getVisible() == 1);
                commonTaskInfo.setCurrentProgress(actualTask2.getProgress());
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : this.commonTasksAdapter.getAllTasksList()) {
            if (((CommonTaskInfo) obj2).getCategoryType() == categoryType.getValue()) {
                arrayList.add(obj2);
            }
        }
        WinterBattlepassTasksLayoutBinding winterBattlepassTasksLayoutBinding = this.battlePassBinding.battlepassTasksPage;
        if (arrayList.isEmpty()) {
            LinearLayout taskContainerListIsEmpty = winterBattlepassTasksLayoutBinding.taskContainerListIsEmpty;
            Intrinsics.checkNotNullExpressionValue(taskContainerListIsEmpty, "taskContainerListIsEmpty");
            taskContainerListIsEmpty.setVisibility(0);
            RelativeLayout currTaskInfoContainer = winterBattlepassTasksLayoutBinding.currTaskInfoContainer;
            Intrinsics.checkNotNullExpressionValue(currTaskInfoContainer, "currTaskInfoContainer");
            currTaskInfoContainer.setVisibility(8);
            RecyclerView commonTaskRecycleView = winterBattlepassTasksLayoutBinding.commonTaskRecycleView;
            Intrinsics.checkNotNullExpressionValue(commonTaskRecycleView, "commonTaskRecycleView");
            commonTaskRecycleView.setVisibility(8);
        } else {
            LinearLayout taskContainerListIsEmpty2 = winterBattlepassTasksLayoutBinding.taskContainerListIsEmpty;
            Intrinsics.checkNotNullExpressionValue(taskContainerListIsEmpty2, "taskContainerListIsEmpty");
            taskContainerListIsEmpty2.setVisibility(8);
            RecyclerView commonTaskRecycleView2 = winterBattlepassTasksLayoutBinding.commonTaskRecycleView;
            Intrinsics.checkNotNullExpressionValue(commonTaskRecycleView2, "commonTaskRecycleView");
            commonTaskRecycleView2.setVisibility(0);
        }
        this.commonTasksAdapter.filterList(categoryType);
    }

    private final void setupThemeForSelectedTask(CategoryType categoryType) {
        WinterBattlepassTasksLayoutBinding winterBattlepassTasksLayoutBinding = this.battlePassBinding.battlepassTasksPage;
        winterBattlepassTasksLayoutBinding.buttonLongTasks.setBackgroundResource(R.drawable.background_az_battlepass_type_task_disabled);
        winterBattlepassTasksLayoutBinding.buttonShopTasks.setBackgroundResource(R.drawable.background_az_battlepass_type_task_disabled);
        winterBattlepassTasksLayoutBinding.buttonDailyTasks.setBackgroundResource(R.drawable.background_az_battlepass_type_task_disabled);
        winterBattlepassTasksLayoutBinding.buttonPremiumTasks.setBackgroundResource(R.drawable.background_az_battlepass_type_task_premium);
        winterBattlepassTasksLayoutBinding.buttonDailyTasksText.setTextColor(-1);
        winterBattlepassTasksLayoutBinding.buttonShopTasksText.setTextColor(-1);
        winterBattlepassTasksLayoutBinding.buttonLongTasksText.setTextColor(-1);
        int i = WhenMappings.$EnumSwitchMapping$3[categoryType.ordinal()];
        if (i == 1) {
            winterBattlepassTasksLayoutBinding.buttonDailyTasks.setBackgroundResource(R.drawable.background_az_battlepass_type_task_enabled);
            winterBattlepassTasksLayoutBinding.buttonDailyTasksText.setTextColor(this.colorText);
        } else if (i == 2) {
            winterBattlepassTasksLayoutBinding.buttonShopTasks.setBackgroundResource(R.drawable.background_az_battlepass_type_task_enabled);
            winterBattlepassTasksLayoutBinding.buttonShopTasksText.setTextColor(this.colorText);
        } else if (i == 3) {
            winterBattlepassTasksLayoutBinding.buttonLongTasks.setBackgroundResource(R.drawable.background_az_battlepass_type_task_enabled);
            winterBattlepassTasksLayoutBinding.buttonLongTasksText.setTextColor(this.colorText);
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            winterBattlepassTasksLayoutBinding.buttonPremiumTasks.setBackgroundResource(R.drawable.background_az_battlepass_type_task_enabled);
            winterBattlepassTasksLayoutBinding.buttonPremiumTasksText.setTextColor(this.colorText);
        }
    }

    private final void updateMainPageInfo(MainBattlePassInfo mainBattlePassInfo) {
        Log.d(this.tag, "updateMainPageInfo ");
        this.battlePassInfo = mainBattlePassInfo;
        WinterBattlepassLayoutBinding winterBattlepassLayoutBinding = this.battlePassBinding;
        LinearLayout bpLevel = winterBattlepassLayoutBinding.bpLevel;
        Intrinsics.checkNotNullExpressionValue(bpLevel, "bpLevel");
        bpLevel.setVisibility(mainBattlePassInfo.getCompleted() <= 100 ? 4 : 0);
        winterBattlepassLayoutBinding.tvBpLevel.setText(String.valueOf(mainBattlePassInfo.getCompleted()));
        winterBattlepassLayoutBinding.textBuyBattlePoints.setText(String.valueOf(mainBattlePassInfo.getPassCoins()));
        winterBattlepassLayoutBinding.textBuyAzCoins.setText(String.valueOf(mainBattlePassInfo.getAzCoins()));
        winterBattlepassLayoutBinding.battlepassTasksPage.tasksTimeText.setText(TimeConverterKt.taskPageTimeConvert(mainBattlePassInfo.getTimestampMissionTime()));
        winterBattlepassLayoutBinding.remainingTimeTextMain.setText(TimeConverterKt.mainPageTimeConvert(mainBattlePassInfo.getTimestampTaskTime()));
        winterBattlepassLayoutBinding.battlepassTasksPage.remainingTimeText.setText(TimeConverterKt.mainPageTimeConvert(mainBattlePassInfo.getTimestampTaskTime()));
        WinterBattlepassConvertBattlecoinsLayoutBinding winterBattlepassConvertBattlecoinsLayoutBinding = this.battlePassBinding.battlepassConvertBattlecoinsPage;
        winterBattlepassConvertBattlecoinsLayoutBinding.battlepointsCurseInfoText.setText(mainBattlePassInfo.getPassCoinCurseAzCoins() + " AZ = 1 ");
        winterBattlepassConvertBattlecoinsLayoutBinding.battlepointsAmountText.setText(String.valueOf(this.startBattleCoinNumbCurse / mainBattlePassInfo.getPassCoinCurseAzCoins()));
        winterBattlepassConvertBattlecoinsLayoutBinding.coinsConvertNumbText.setText(String.valueOf(this.startBattleCoinNumbCurse));
        updateLogo();
        updateLevelInfoOnPages();
        updatePremiumButtonsVisibility(mainBattlePassInfo.getPremium());
        setupBuyPremiumPage();
        updateBpAwards(mainBattlePassInfo.getAvailableToReceive());
        if (!this.isRouletteOpen) {
            clickButtonMenuNavigation(NavItems.MAIN_PAGE);
        }
        WinterBattlepassLevelSetsLayoutBinding winterBattlepassLevelSetsLayoutBinding = this.battlePassBinding.battlepassLevelSetsPage;
        if (mainBattlePassInfo.getLevel() + 10 > 100) {
            TextView textView = winterBattlepassLevelSetsLayoutBinding.silverPriceButton;
            textView.setText("Недоступно");
            textView.setAlpha(0.6f);
            textView.setEnabled(false);
        } else {
            TextView textView2 = winterBattlepassLevelSetsLayoutBinding.silverPriceButton;
            textView2.setText("Купить");
            textView2.setAlpha(1.0f);
            textView2.setEnabled(true);
        }
        if (mainBattlePassInfo.getLevel() + 10 > 100) {
            TextView textView3 = winterBattlepassLevelSetsLayoutBinding.goldPriceButton;
            textView3.setText("Недоступно");
            textView3.setAlpha(0.6f);
            textView3.setEnabled(false);
        } else {
            TextView textView4 = winterBattlepassLevelSetsLayoutBinding.goldPriceButton;
            textView4.setText("Купить");
            textView4.setAlpha(1.0f);
            textView4.setEnabled(true);
        }
        if (mainBattlePassInfo.getLevel() + 20 > 100) {
            TextView textView5 = winterBattlepassLevelSetsLayoutBinding.epicPriceButton;
            textView5.setText("Недоступно");
            textView5.setAlpha(0.6f);
            textView5.setEnabled(false);
        } else {
            TextView textView6 = winterBattlepassLevelSetsLayoutBinding.epicPriceButton;
            textView6.setText("Купить");
            textView6.setAlpha(1.0f);
            textView6.setEnabled(true);
        }
        if (mainBattlePassInfo.getLevel() > 100) {
            TextView textView7 = winterBattlepassLevelSetsLayoutBinding.legendaryPriceButton;
            textView7.setText("Недоступно");
            textView7.setAlpha(0.6f);
            textView7.setEnabled(false);
            return;
        }
        TextView textView8 = winterBattlepassLevelSetsLayoutBinding.legendaryPriceButton;
        textView8.setText("Купить");
        textView8.setAlpha(1.0f);
        textView8.setEnabled(true);
    }

    private final void updateLevelInfoOnPages() {
        if (this.battlePassInfo == null) {
            return;
        }
        WinterBattlepassLayoutBinding winterBattlepassLayoutBinding = this.battlePassBinding;
        TextView textView = winterBattlepassLayoutBinding.levelPassText;
        MainBattlePassInfo mainBattlePassInfo = this.battlePassInfo;
        Intrinsics.checkNotNull(mainBattlePassInfo);
        textView.setText(String.valueOf(mainBattlePassInfo.getLevel()));
        TextView textView2 = winterBattlepassLayoutBinding.mainExperienceText;
        MainBattlePassInfo mainBattlePassInfo2 = this.battlePassInfo;
        Intrinsics.checkNotNull(mainBattlePassInfo2);
        int exp = mainBattlePassInfo2.getExp();
        MainBattlePassInfo mainBattlePassInfo3 = this.battlePassInfo;
        Intrinsics.checkNotNull(mainBattlePassInfo3);
        textView2.setText(exp + "/" + mainBattlePassInfo3.getMaxExp());
        winterBattlepassLayoutBinding.progressExperience.setMax(20);
        LinearProgressIndicator linearProgressIndicator = winterBattlepassLayoutBinding.progressExperience;
        MainBattlePassInfo mainBattlePassInfo4 = this.battlePassInfo;
        Intrinsics.checkNotNull(mainBattlePassInfo4);
        int exp2 = mainBattlePassInfo4.getExp();
        MainBattlePassInfo mainBattlePassInfo5 = this.battlePassInfo;
        Intrinsics.checkNotNull(mainBattlePassInfo5);
        linearProgressIndicator.setProgress((exp2 - mainBattlePassInfo5.getMaxExp()) + 20);
        WinterBattlepassTasksLayoutBinding winterBattlepassTasksLayoutBinding = this.battlePassBinding.battlepassTasksPage;
        TextView textView3 = winterBattlepassTasksLayoutBinding.levelPassText;
        MainBattlePassInfo mainBattlePassInfo6 = this.battlePassInfo;
        Intrinsics.checkNotNull(mainBattlePassInfo6);
        textView3.setText(String.valueOf(mainBattlePassInfo6.getLevel()));
        TextView textView4 = winterBattlepassTasksLayoutBinding.mainExperienceText;
        MainBattlePassInfo mainBattlePassInfo7 = this.battlePassInfo;
        Intrinsics.checkNotNull(mainBattlePassInfo7);
        int exp3 = mainBattlePassInfo7.getExp();
        MainBattlePassInfo mainBattlePassInfo8 = this.battlePassInfo;
        Intrinsics.checkNotNull(mainBattlePassInfo8);
        textView4.setText(exp3 + "/" + mainBattlePassInfo8.getMaxExp());
        LinearProgressIndicator linearProgressIndicator2 = winterBattlepassTasksLayoutBinding.progressExperience;
        MainBattlePassInfo mainBattlePassInfo9 = this.battlePassInfo;
        Intrinsics.checkNotNull(mainBattlePassInfo9);
        linearProgressIndicator2.setMax(mainBattlePassInfo9.getMaxExp());
        LinearProgressIndicator linearProgressIndicator3 = winterBattlepassTasksLayoutBinding.progressExperience;
        MainBattlePassInfo mainBattlePassInfo10 = this.battlePassInfo;
        Intrinsics.checkNotNull(mainBattlePassInfo10);
        linearProgressIndicator3.setProgress(mainBattlePassInfo10.getExp());
        WinterBattlepassLevelSetsLayoutBinding winterBattlepassLevelSetsLayoutBinding = this.battlePassBinding.battlepassLevelSetsPage;
    }

    private final void updatePremiumButtonsVisibility(int i) {
        WinterBattlepassTasksLayoutBinding winterBattlepassTasksLayoutBinding = this.battlePassBinding.battlepassTasksPage;
        WinterBattlepassLayoutBinding winterBattlepassLayoutBinding = this.battlePassBinding;
        if (i == 0) {
            winterBattlepassLayoutBinding.buyPremiumBtn.setVisibility(0);
            winterBattlepassLayoutBinding.buyPremiumText.setText("КУПИТЬ PREMIUM");
        } else if (i == 1) {
            winterBattlepassLayoutBinding.buyPremiumBtn.setVisibility(0);
            winterBattlepassLayoutBinding.buyPremiumText.setText("КУПИТЬ PREMIUM PLUS");
        } else {
            winterBattlepassLayoutBinding.buyPremiumBtn.setVisibility(8);
        }
        WinterBattlepassConvertBattlecoinsLayoutBinding winterBattlepassConvertBattlecoinsLayoutBinding = this.battlePassBinding.battlepassConvertBattlecoinsPage;
    }

    private final void setupTaskDataIntoUi(final CommonTaskInfo commonTaskInfo, final CategoryType categoryType) {
        WinterBattlepassTasksLayoutBinding winterBattlepassTasksLayoutBinding = this.battlePassBinding.battlepassTasksPage;
        winterBattlepassTasksLayoutBinding.taskInfoTitle.setText(commonTaskInfo.getTitle());
        winterBattlepassTasksLayoutBinding.taskInfoDesc.setText(commonTaskInfo.getHint());
        TextView textView = winterBattlepassTasksLayoutBinding.itemCount;
        int validCurrentProgress = commonTaskInfo.validCurrentProgress();
        textView.setText(validCurrentProgress + "/" + commonTaskInfo.getTotalProgress());
        winterBattlepassTasksLayoutBinding.progressInPercentText.setText(((commonTaskInfo.validCurrentProgress() / commonTaskInfo.getTotalProgress()) * 100) + "%");
        if (commonTaskInfo.validCurrentProgress() == commonTaskInfo.getTotalProgress()) {
            LinearLayout progressDoneContainer = winterBattlepassTasksLayoutBinding.progressDoneContainer;
            Intrinsics.checkNotNullExpressionValue(progressDoneContainer, "progressDoneContainer");
            progressDoneContainer.setVisibility(0);
            TextView progressInPercentText = winterBattlepassTasksLayoutBinding.progressInPercentText;
            Intrinsics.checkNotNullExpressionValue(progressInPercentText, "progressInPercentText");
            progressInPercentText.setVisibility(8);
        } else {
            LinearLayout progressDoneContainer2 = winterBattlepassTasksLayoutBinding.progressDoneContainer;
            Intrinsics.checkNotNullExpressionValue(progressDoneContainer2, "progressDoneContainer");
            progressDoneContainer2.setVisibility(8);
            TextView progressInPercentText2 = winterBattlepassTasksLayoutBinding.progressInPercentText;
            Intrinsics.checkNotNullExpressionValue(progressInPercentText2, "progressInPercentText");
            progressInPercentText2.setVisibility(0);
        }
        winterBattlepassTasksLayoutBinding.taskInfoProgressBar.setMax(commonTaskInfo.getTotalProgress());
        winterBattlepassTasksLayoutBinding.taskInfoProgressBar.setProgress(commonTaskInfo.getCurrentProgress());
        this.rewardsTasksAdapter.setRewards(commonTaskInfo.getRewards());
        if (commonTaskInfo.getCurrentProgress() == commonTaskInfo.getTotalProgress()) {
            winterBattlepassTasksLayoutBinding.taskInfoProgressBar.setProgressTintList(ColorStateList.valueOf(this.colorMaxProgress));
        } else {
            winterBattlepassTasksLayoutBinding.taskInfoProgressBar.setProgressTintList(ColorStateList.valueOf(-1));
        }
        winterBattlepassTasksLayoutBinding.buttonTaskInfoGetReward.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupTaskDataIntoUi$lambda$0$0(Winter2025BattlePassScreen.this, categoryType, commonTaskInfo, view);
            }
        });
        if (categoryType == CategoryType.PREMIUM) {
            MainBattlePassInfo mainBattlePassInfo = this.battlePassInfo;
            if (mainBattlePassInfo != null && !mainBattlePassInfo.isPremium()) {
                LinearLayout taskInfoPremiumLockContainer = winterBattlepassTasksLayoutBinding.taskInfoPremiumLockContainer;
                Intrinsics.checkNotNullExpressionValue(taskInfoPremiumLockContainer, "taskInfoPremiumLockContainer");
                taskInfoPremiumLockContainer.setVisibility(0);
                winterBattlepassTasksLayoutBinding.buttonTaskInfoGetReward.setOnClickListener(null);
            } else {
                LinearLayout taskInfoPremiumLockContainer2 = winterBattlepassTasksLayoutBinding.taskInfoPremiumLockContainer;
                Intrinsics.checkNotNullExpressionValue(taskInfoPremiumLockContainer2, "taskInfoPremiumLockContainer");
                taskInfoPremiumLockContainer2.setVisibility(8);
            }
        } else {
            LinearLayout taskInfoPremiumLockContainer3 = winterBattlepassTasksLayoutBinding.taskInfoPremiumLockContainer;
            Intrinsics.checkNotNullExpressionValue(taskInfoPremiumLockContainer3, "taskInfoPremiumLockContainer");
            taskInfoPremiumLockContainer3.setVisibility(8);
        }
        RelativeLayout currTaskInfoContainer = winterBattlepassTasksLayoutBinding.currTaskInfoContainer;
        Intrinsics.checkNotNullExpressionValue(currTaskInfoContainer, "currTaskInfoContainer");
        currTaskInfoContainer.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupTaskDataIntoUi$lambda$0$0(Winter2025BattlePassScreen winter2025BattlePassScreen, CategoryType categoryType, CommonTaskInfo commonTaskInfo, View view) {
        winter2025BattlePassScreen.notifyClick(1, -1, StringKt.toStringJson(new RewardGetRequest(categoryType.getValue(), commonTaskInfo.getId())));
    }

    private final void showTaskInfo(CommonTaskInfo commonTaskInfo, int i) {
        CategoryType fromCategoryId = CategoryType.Companion.fromCategoryId(commonTaskInfo.getCategoryType());
        this.commonTasksAdapter.selectTask(i);
        setupTaskDataIntoUi(commonTaskInfo, fromCategoryId);
    }

    private final void updateCoins(BattlePassUpdateCoinsData battlePassUpdateCoinsData) {
        WinterBattlepassLayoutBinding winterBattlepassLayoutBinding = this.battlePassBinding;
        winterBattlepassLayoutBinding.textBuyBattlePoints.setText(String.valueOf(battlePassUpdateCoinsData.getPassCoins()));
        winterBattlepassLayoutBinding.textBuyAzCoins.setText(String.valueOf(battlePassUpdateCoinsData.getAzCoins()));
        MainBattlePassInfo mainBattlePassInfo = this.battlePassInfo;
        if (mainBattlePassInfo != null) {
            mainBattlePassInfo.setPassCoins(battlePassUpdateCoinsData.getPassCoins());
        }
        MainBattlePassInfo mainBattlePassInfo2 = this.battlePassInfo;
        if (mainBattlePassInfo2 != null) {
            mainBattlePassInfo2.setAzCoins(battlePassUpdateCoinsData.getAzCoins());
        }
    }

    private final void updateBattlePassPremium(List<BattlePassPremiumData> list) {
        if (list.size() != this.frontendPremiumMinimumSize) {
            this.isLockPremiumPage = true;
            Toast.makeText(getTargetActivity().getApplicationContext(), "Количество премиумов не соотвествует серверу, обратитесь в поддержку!", 1).show();
            return;
        }
        WinterBattlepassBuyPremiumLayoutBinding winterBattlepassBuyPremiumLayoutBinding = this.battlePassBinding.battlepassLevelPremiumPage;
        BattlePassPremiumData battlePassPremiumData = list.get(0);
        BattlePassPremiumData battlePassPremiumData2 = list.get(1);
        if (battlePassPremiumData.getDiscount() > 0) {
            winterBattlepassBuyPremiumLayoutBinding.premiumDiscountText.setVisibility(0);
            winterBattlepassBuyPremiumLayoutBinding.premiumDiscountPercentBox.setVisibility(0);
            winterBattlepassBuyPremiumLayoutBinding.premiumDiscountPercentText.setText(battlePassPremiumData.getDiscount() + " %");
            winterBattlepassBuyPremiumLayoutBinding.premiumDiscountText.setText(battlePassPremiumData.getPrice() + " RUB");
            winterBattlepassBuyPremiumLayoutBinding.premiumPriceText.setText(battlePassPremiumData.getPriceWithDiscount() + " RUB");
        } else {
            winterBattlepassBuyPremiumLayoutBinding.premiumDiscountPercentBox.setVisibility(4);
            winterBattlepassBuyPremiumLayoutBinding.premiumDiscountText.setVisibility(8);
            winterBattlepassBuyPremiumLayoutBinding.premiumPriceText.setText(battlePassPremiumData.getPrice() + " RUB");
        }
        if (battlePassPremiumData2.getDiscount() > 0) {
            winterBattlepassBuyPremiumLayoutBinding.premiumPlusDiscountText.setVisibility(0);
            winterBattlepassBuyPremiumLayoutBinding.premiumPlusDiscountPercentBox.setVisibility(0);
            winterBattlepassBuyPremiumLayoutBinding.premiumPlusDiscountPercentText.setText(battlePassPremiumData2.getDiscount() + " %");
            winterBattlepassBuyPremiumLayoutBinding.premiumPlusDiscountText.setText(battlePassPremiumData2.getPrice() + " RUB");
            winterBattlepassBuyPremiumLayoutBinding.premiumPlusPriceText.setText(battlePassPremiumData2.getPriceWithDiscount() + " RUB");
        } else {
            winterBattlepassBuyPremiumLayoutBinding.premiumPlusDiscountText.setVisibility(4);
            winterBattlepassBuyPremiumLayoutBinding.premiumPlusDiscountPercentBox.setVisibility(4);
            winterBattlepassBuyPremiumLayoutBinding.premiumPlusPriceText.setText(battlePassPremiumData2.getPrice() + " RUB");
        }
        if (battlePassPremiumData.getStatus() == 1) {
            winterBattlepassBuyPremiumLayoutBinding.premiumPriceButton.setForeground(ContextCompat.getDrawable(getTargetActivity(), R.drawable.bp_unselect_btn));
            winterBattlepassBuyPremiumLayoutBinding.premiumPriceButtonText.setText("Недоступно");
        } else {
            winterBattlepassBuyPremiumLayoutBinding.premiumPriceButton.setForeground(null);
            winterBattlepassBuyPremiumLayoutBinding.premiumPriceButtonText.setText("Купить");
        }
        if (battlePassPremiumData2.getStatus() == 1) {
            winterBattlepassBuyPremiumLayoutBinding.premiumPlusPriceButton.setForeground(ContextCompat.getDrawable(getTargetActivity(), R.drawable.bp_unselect_btn));
            winterBattlepassBuyPremiumLayoutBinding.premiumPlusPriceButtonText.setText("Недоступно");
            return;
        }
        winterBattlepassBuyPremiumLayoutBinding.premiumPlusPriceButton.setForeground(null);
        winterBattlepassBuyPremiumLayoutBinding.premiumPlusPriceButtonText.setText("Купить");
    }

    private final void setupLevelSetText(TextView textView, TextView textView2, TextView textView3, BattlePassLevelSetData battlePassLevelSetData) {
        if (textView != null) {
            textView.setText(battlePassLevelSetData.getCount() + " lvl");
        }
        textView3.setPaintFlags(16);
        if (battlePassLevelSetData.getDiscount() > 0) {
            textView3.setVisibility(0);
            textView3.setText(battlePassLevelSetData.getPrice() + " RUB");
            textView2.setText(battlePassLevelSetData.getPriceWithDiscount() + " RUB");
            return;
        }
        textView3.setVisibility(4);
        textView2.setText(battlePassLevelSetData.getPrice() + " RUB");
    }

    private final void updateLevelSetsInfo(List<BattlePassLevelSetData> list) {
        if (list.size() != this.frontendLevelSetsMinimumSize) {
            this.isLockLevelPage = true;
            Toast.makeText(getTargetActivity().getApplicationContext(), "Количество уровней не соотвествует серверу, обратитесь в поддержку!", 1).show();
            return;
        }
        WinterBattlepassLevelSetsLayoutBinding winterBattlepassLevelSetsLayoutBinding = this.battlePassBinding.battlepassLevelSetsPage;
        TextView textView = winterBattlepassLevelSetsLayoutBinding.silverLvlText;
        TextView silverPriceText = winterBattlepassLevelSetsLayoutBinding.silverPriceText;
        Intrinsics.checkNotNullExpressionValue(silverPriceText, "silverPriceText");
        TextView silverDiscountText = winterBattlepassLevelSetsLayoutBinding.silverDiscountText;
        Intrinsics.checkNotNullExpressionValue(silverDiscountText, "silverDiscountText");
        setupLevelSetText(textView, silverPriceText, silverDiscountText, list.get(0));
        TextView textView2 = winterBattlepassLevelSetsLayoutBinding.goldLvlText;
        TextView goldPriceText = winterBattlepassLevelSetsLayoutBinding.goldPriceText;
        Intrinsics.checkNotNullExpressionValue(goldPriceText, "goldPriceText");
        TextView goldDiscountText = winterBattlepassLevelSetsLayoutBinding.goldDiscountText;
        Intrinsics.checkNotNullExpressionValue(goldDiscountText, "goldDiscountText");
        setupLevelSetText(textView2, goldPriceText, goldDiscountText, list.get(1));
        TextView textView3 = winterBattlepassLevelSetsLayoutBinding.epicLvlText;
        TextView epicPriceText = winterBattlepassLevelSetsLayoutBinding.epicPriceText;
        Intrinsics.checkNotNullExpressionValue(epicPriceText, "epicPriceText");
        TextView epicDiscountText = winterBattlepassLevelSetsLayoutBinding.epicDiscountText;
        Intrinsics.checkNotNullExpressionValue(epicDiscountText, "epicDiscountText");
        setupLevelSetText(textView3, epicPriceText, epicDiscountText, list.get(2));
        TextView legendaryPriceText = winterBattlepassLevelSetsLayoutBinding.legendaryPriceText;
        Intrinsics.checkNotNullExpressionValue(legendaryPriceText, "legendaryPriceText");
        TextView legendaryDiscountText = winterBattlepassLevelSetsLayoutBinding.legendaryDiscountText;
        Intrinsics.checkNotNullExpressionValue(legendaryDiscountText, "legendaryDiscountText");
        setupLevelSetText(null, legendaryPriceText, legendaryDiscountText, list.get(3));
    }

    private final void setupLevelBuyPage() {
        WinterBattlepassLevelSetsLayoutBinding winterBattlepassLevelSetsLayoutBinding = this.battlePassBinding.battlepassLevelSetsPage;
        winterBattlepassLevelSetsLayoutBinding.silverPriceButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupLevelBuyPage$lambda$0$0(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassLevelSetsLayoutBinding.goldPriceButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupLevelBuyPage$lambda$0$1(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassLevelSetsLayoutBinding.epicPriceButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupLevelBuyPage$lambda$0$2(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassLevelSetsLayoutBinding.legendaryPriceButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupLevelBuyPage$lambda$0$3(Winter2025BattlePassScreen.this, view);
            }
        });
        if (UtilsKt.isArizonaType()) {
            return;
        }
        winterBattlepassLevelSetsLayoutBinding.passName1.setText("Rodina Pass");
        winterBattlepassLevelSetsLayoutBinding.passName2.setText("Rodina Pass");
        winterBattlepassLevelSetsLayoutBinding.passName3.setText("Rodina Pass");
        winterBattlepassLevelSetsLayoutBinding.passName4.setText("Rodina Pass");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupLevelBuyPage$lambda$0$0(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, 0, 7, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupLevelBuyPage$lambda$0$1(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, 1, 7, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupLevelBuyPage$lambda$0$2(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, 2, 7, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupLevelBuyPage$lambda$0$3(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, 3, 7, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCommonTaskItems(List<CommonTaskInfo> list) {
        this.commonTasksAdapter.addAllTasks(list);
    }

    private final void updateTasks(List<ActualTask> list) {
        ActualTask actualTask = (ActualTask) CollectionsKt.firstOrNull((List<? extends Object>) list);
        if (Intrinsics.areEqual(actualTask != null ? actualTask.getCategoryId() : null, "daily")) {
            this._usualTasks = list;
        }
        ActualTask actualTask2 = (ActualTask) CollectionsKt.firstOrNull((List<? extends Object>) list);
        if (Intrinsics.areEqual(actualTask2 != null ? actualTask2.getCategoryId() : null, "premium")) {
            this._premTasks = list;
        }
        BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), Dispatchers.getIO(), null, new Winter2025BattlePassScreen$updateTasks$1(this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLevelItems(List<Pair<AwardItemData, AwardItemData>> list) {
        int i;
        List<Pair<AwardItemData, AwardItemData>> list2;
        boolean z;
        MainBattlePassInfo mainBattlePassInfo = this.battlePassInfo;
        if (mainBattlePassInfo != null) {
            Intrinsics.checkNotNull(mainBattlePassInfo);
            int exp = mainBattlePassInfo.getExp();
            MainBattlePassInfo mainBattlePassInfo2 = this.battlePassInfo;
            Intrinsics.checkNotNull(mainBattlePassInfo2);
            i = (exp - mainBattlePassInfo2.getMaxExp()) + 20;
        } else {
            i = 0;
        }
        LevelItemsAdapter levelItemsAdapter = this.levelItemsAdapter;
        MainBattlePassInfo mainBattlePassInfo3 = this.battlePassInfo;
        int level = mainBattlePassInfo3 != null ? mainBattlePassInfo3.getLevel() : 0;
        boolean isArizonaType = UtilsKt.isArizonaType();
        MainBattlePassInfo mainBattlePassInfo4 = this.battlePassInfo;
        if (mainBattlePassInfo4 == null || !mainBattlePassInfo4.isPremium()) {
            list2 = list;
            z = false;
        } else {
            z = true;
            list2 = list;
        }
        levelItemsAdapter.setData(list2, level, i, isArizonaType, z);
    }

    private final void updateLogo() {
        int premium;
        int i;
        if (UtilsKt.isArizonaType()) {
            MainBattlePassInfo mainBattlePassInfo = this.battlePassInfo;
            premium = mainBattlePassInfo != null ? mainBattlePassInfo.getPremium() : -1;
            if (premium == 0) {
                i = R.drawable.battlepass_logo;
            } else if (premium == 1) {
                i = R.drawable.battlepass_logo_prem;
            } else if (premium == 2) {
                i = R.drawable.battlepass_logo_prem_plus;
            } else {
                i = R.drawable.battlepass_logo;
            }
        } else {
            MainBattlePassInfo mainBattlePassInfo2 = this.battlePassInfo;
            premium = mainBattlePassInfo2 != null ? mainBattlePassInfo2.getPremium() : -1;
            if (premium == 0) {
                i = R.drawable.battlepass_logo;
            } else if (premium == 1) {
                i = R.drawable.battlepass_logo_prem;
            } else if (premium == 2) {
                i = R.drawable.battlepass_logo_prem_plus;
            } else {
                i = R.drawable.battlepass_logo;
            }
        }
        this.battlePassBinding.logo.setImageResource(i);
        this.battlePassBinding.battlepassLevelSetsPageMaximum.logo.setImageResource(i);
    }

    private final void onClaimItem(boolean z, int i) {
        notifyClick(0, 3, i + ", " + (z ? 1 : 0));
    }

    private final void setupRoulette(List<RouletteData> list) {
        try {
            final RouletteData rouletteData = list.get(0);
            final RouletteData rouletteData2 = list.get(1);
            final WinterBattlepassLayoutBinding winterBattlepassLayoutBinding = this.battlePassBinding;
            winterBattlepassLayoutBinding.battlepassRoulettePage.roulettePageSaleText.setText(rouletteData2.getDescription());
            winterBattlepassLayoutBinding.battlepassRoulettePage.battlepass2025WinterRouletteUsualCount.setText(String.valueOf(rouletteData.getTotal()));
            winterBattlepassLayoutBinding.battlepassRoulettePage.battlepass2025WinterRoulettePremCount.setText(String.valueOf(rouletteData2.getTotal()));
            winterBattlepassLayoutBinding.battlepassRoulettePage.battlepass2025WinterRouletteUsualButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda33
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Winter2025BattlePassScreen.setupRoulette$lambda$0$0(Winter2025BattlePassScreen.this, winterBattlepassLayoutBinding, rouletteData, view);
                }
            });
            winterBattlepassLayoutBinding.battlepassRoulettePage.battlepass2025WinterRoulettePremButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda44
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Winter2025BattlePassScreen.setupRoulette$lambda$0$1(Winter2025BattlePassScreen.this, winterBattlepassLayoutBinding, rouletteData2, view);
                }
            });
            if (this.isPremRoulette) {
                winterBattlepassLayoutBinding.battlepassRouletteView.attempsCount.setText(String.valueOf(rouletteData2.getTotal()));
                this.rouletteCount = rouletteData2.getTotal();
                return;
            }
            winterBattlepassLayoutBinding.battlepassRouletteView.attempsCount.setText(String.valueOf(rouletteData.getTotal()));
            this.rouletteCount = rouletteData.getTotal();
        } catch (Exception e) {
            Log.d(this.tag, e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupRoulette$lambda$0$0(Winter2025BattlePassScreen winter2025BattlePassScreen, WinterBattlepassLayoutBinding winterBattlepassLayoutBinding, RouletteData rouletteData, View view) {
        winter2025BattlePassScreen.possiblePrisesList.clear();
        RoulettePrisesPicasso.INSTANCE.clear();
        winter2025BattlePassScreen.priseAdapter.clearPriseList();
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, 0, 12, null, 4, null);
        winterBattlepassLayoutBinding.battlepassRoulettePage.getRoot().setVisibility(8);
        winterBattlepassLayoutBinding.battlepassRouletteView.getRoot().setVisibility(0);
        winter2025BattlePassScreen.initRouletteView(false, rouletteData);
        winter2025BattlePassScreen.isPremRoulette = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupRoulette$lambda$0$1(Winter2025BattlePassScreen winter2025BattlePassScreen, WinterBattlepassLayoutBinding winterBattlepassLayoutBinding, RouletteData rouletteData, View view) {
        winter2025BattlePassScreen.possiblePrisesList.clear();
        RoulettePrisesPicasso.INSTANCE.clear();
        winter2025BattlePassScreen.priseAdapter.clearPriseList();
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, 1, 12, null, 4, null);
        winterBattlepassLayoutBinding.battlepassRoulettePage.getRoot().setVisibility(8);
        winterBattlepassLayoutBinding.battlepassRouletteView.getRoot().setVisibility(0);
        winter2025BattlePassScreen.initRouletteView(true, rouletteData);
        winter2025BattlePassScreen.isPremRoulette = true;
    }

    private final void initRouletteView(boolean z, RouletteData rouletteData) {
        this.isRouletteOpen = true;
        WinterBattlepassRouletteMainScreenBinding winterBattlepassRouletteMainScreenBinding = this.battlePassBinding.battlepassRouletteView;
        if (z) {
            String name = rouletteData.getName();
            if (name != null && name.length() != 0) {
                winterBattlepassRouletteMainScreenBinding.buttonPriceRub.setText(rouletteData.getName());
                winterBattlepassRouletteMainScreenBinding.buttonPriceRubTop.setText(rouletteData.getName());
            }
            winterBattlepassRouletteMainScreenBinding.btnBuy.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_premium_blue);
            winterBattlepassRouletteMainScreenBinding.tvBuy.setTextColor(this.colorText);
            winterBattlepassRouletteMainScreenBinding.buttonPrice.setTextColor(Color.parseColor("#FFFFFF"));
            winterBattlepassRouletteMainScreenBinding.buttonPriceIcon.setVisibility(8);
            winterBattlepassRouletteMainScreenBinding.buttonPriceRub.setVisibility(0);
            winterBattlepassRouletteMainScreenBinding.buttonPriceIconTop.setVisibility(8);
            winterBattlepassRouletteMainScreenBinding.buttonPriceRubTop.setVisibility(0);
            winterBattlepassRouletteMainScreenBinding.btn1.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_premium_transparent_blue);
            winterBattlepassRouletteMainScreenBinding.btn2.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_premium_transparent_blue);
            winterBattlepassRouletteMainScreenBinding.btn3.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_premium_transparent_blue);
        } else {
            winterBattlepassRouletteMainScreenBinding.btnBuy.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_white);
            winterBattlepassRouletteMainScreenBinding.tvBuy.setTextColor(this.colorText);
            winterBattlepassRouletteMainScreenBinding.buttonPrice.setTextColor(this.colorText);
            winterBattlepassRouletteMainScreenBinding.buttonPriceIcon.setVisibility(0);
            winterBattlepassRouletteMainScreenBinding.buttonPriceRub.setVisibility(8);
            winterBattlepassRouletteMainScreenBinding.buttonPriceIconTop.setVisibility(0);
            winterBattlepassRouletteMainScreenBinding.buttonPriceRubTop.setVisibility(8);
            winterBattlepassRouletteMainScreenBinding.btn1.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white);
            winterBattlepassRouletteMainScreenBinding.btn2.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white);
            winterBattlepassRouletteMainScreenBinding.btn3.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white);
        }
        winterBattlepassRouletteMainScreenBinding.btnBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.initRouletteView$lambda$0$0(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassRouletteMainScreenBinding.btnSprint.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda29
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.this.startRoulette();
            }
        });
        if (z) {
            TextView textView = winterBattlepassRouletteMainScreenBinding.buttonPrice;
            int price = rouletteData.getPrice();
            int i = this.multiplierBuyRoulette;
            String name2 = rouletteData.getName();
            if (name2 == null) {
                name2 = "";
            }
            textView.setText(calcRoulettePrice(price, i, name2));
            TextView textView2 = winterBattlepassRouletteMainScreenBinding.textPrice;
            int price2 = rouletteData.getPrice();
            String name3 = rouletteData.getName();
            if (name3 == null) {
                name3 = "";
            }
            textView2.setText(calcRoulettePrice(price2, 1, name3));
        } else {
            winterBattlepassRouletteMainScreenBinding.buttonPrice.setText(String.valueOf(rouletteData.getPrice()));
            winterBattlepassRouletteMainScreenBinding.textPrice.setText(String.valueOf(rouletteData.getPrice()));
        }
        winterBattlepassRouletteMainScreenBinding.attempsCount.setText(String.valueOf(rouletteData.getTotal()));
        this.rouletteCount = rouletteData.getTotal();
        winterBattlepassRouletteMainScreenBinding.rouletteView.isPremium(z, new Function1() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initRouletteView$lambda$0$2;
                initRouletteView$lambda$0$2 = Winter2025BattlePassScreen.initRouletteView$lambda$0$2(Winter2025BattlePassScreen.this, ((Integer) obj).intValue());
                return initRouletteView$lambda$0$2;
            }
        });
        winterBattlepassRouletteMainScreenBinding.priseListRv.setAdapter(this.priseAdapter);
        int price3 = rouletteData.getPrice();
        String name4 = rouletteData.getName();
        if (name4 == null) {
            name4 = "";
        }
        rouletteBuySelectSetup(price3, name4);
        int price4 = rouletteData.getPrice();
        String name5 = rouletteData.getName();
        rouletteBuyButtonSetup(price4, name5 != null ? name5 : "");
        winterBattlepassRouletteMainScreenBinding.oldPriseRv.setAdapter(this.oldPriseAdapter);
        this.oldPriseAdapter.setPriseList(CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRouletteView$lambda$0$0(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.battlePassBinding.battlepassRoulettePage.getRoot().setVisibility(0);
        winter2025BattlePassScreen.battlePassBinding.battlepassRouletteView.getRoot().setVisibility(8);
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, 2, 11, null, 4, null);
        winter2025BattlePassScreen.isRouletteOpen = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initRouletteView$lambda$0$2(Winter2025BattlePassScreen winter2025BattlePassScreen, int i) {
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, i, 14, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startRoulette() {
        int i = this.rouletteCount;
        if (i > 0) {
            this.rouletteCount = i - 1;
            this.battlePassBinding.battlepassRouletteView.attempsCount.setText(String.valueOf(this.rouletteCount));
            SAMPUIElement.notifyClick$default(this, 0, 13, null, 4, null);
        }
    }

    private final void rouletteSpinPrises(List<Integer> list) {
        List<Integer> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Number number : list2) {
            arrayList.add(new PriseModel(number.intValue()));
        }
        this.battlePassBinding.clickBlocker.setVisibility(0);
        this.battlePassBinding.clickBlocker.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.rouletteSpinPrises$lambda$1(view);
            }
        });
        this.battlePassBinding.battlepassRouletteView.rouletteView.start(arrayList, new Function0() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda41
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit rouletteSpinPrises$lambda$2;
                rouletteSpinPrises$lambda$2 = Winter2025BattlePassScreen.rouletteSpinPrises$lambda$2(Winter2025BattlePassScreen.this);
                return rouletteSpinPrises$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rouletteSpinPrises$lambda$2(Winter2025BattlePassScreen winter2025BattlePassScreen) {
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, 0, 18, null, 4, null);
        winter2025BattlePassScreen.battlePassBinding.clickBlocker.setVisibility(8);
        return Unit.INSTANCE;
    }

    private final void rouletteAddPossiblePrise(PossiblePrise possiblePrise) {
        PossiblePrise copy$default = PossiblePrise.copy$default(possiblePrise, 0, null, null, 0, StringsKt.replace$default(possiblePrise.getImage(), ".webp", "", false, 4, (Object) null), 15, null);
        RoulettePrisesPicasso.INSTANCE.addPrise(copy$default);
        this.possiblePrisesList.add(copy$default);
        this.priseAdapter.addPrise(copy$default);
        this.battlePassBinding.battlepassRouletteView.rouletteView.notifyAdapter();
    }

    private final String calcRoulettePrice(int i, int i2, String str) {
        int i3 = i * i2;
        String str2 = str;
        if ((str2.length() == 0) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "RUB", false, 2, (Object) null)) {
            return String.valueOf(i3);
        }
        if (i3 >= 1000000) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.1fкк", Arrays.copyOf(new Object[]{Double.valueOf(i3 / 1000000.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return StringsKt.replace$default(format, StringUtils.COMMA, ".", false, 4, (Object) null);
        } else if (i3 >= 1000) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%.1fк", Arrays.copyOf(new Object[]{Double.valueOf(i3 / 1000.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            return StringsKt.replace$default(format2, StringUtils.COMMA, ".", false, 4, (Object) null);
        } else {
            return String.valueOf(i3);
        }
    }

    private final void rouletteBuySelectSetup(final int i, final String str) {
        final int i2 = this.colorText;
        final int parseColor = Color.parseColor("#FFFFFF");
        final WinterBattlepassRouletteMainScreenBinding winterBattlepassRouletteMainScreenBinding = this.battlePassBinding.battlepassRouletteView;
        winterBattlepassRouletteMainScreenBinding.btn1.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white_selected);
        winterBattlepassRouletteMainScreenBinding.btn2.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white);
        winterBattlepassRouletteMainScreenBinding.btn3.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white);
        winterBattlepassRouletteMainScreenBinding.btn1Text.setTextColor(i2);
        winterBattlepassRouletteMainScreenBinding.btn2Text.setTextColor(parseColor);
        winterBattlepassRouletteMainScreenBinding.btn3Text.setTextColor(parseColor);
        this.multiplierBuyRoulette = 1;
        winterBattlepassRouletteMainScreenBinding.btn1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda42
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.rouletteBuySelectSetup$lambda$0$0(Winter2025BattlePassScreen.this, winterBattlepassRouletteMainScreenBinding, i2, parseColor, i, str, view);
            }
        });
        winterBattlepassRouletteMainScreenBinding.btn2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda43
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.rouletteBuySelectSetup$lambda$0$1(Winter2025BattlePassScreen.this, winterBattlepassRouletteMainScreenBinding, parseColor, i2, i, str, view);
            }
        });
        winterBattlepassRouletteMainScreenBinding.btn3.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda45
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.rouletteBuySelectSetup$lambda$0$2(Winter2025BattlePassScreen.this, winterBattlepassRouletteMainScreenBinding, parseColor, i2, i, str, view);
            }
        });
        winterBattlepassRouletteMainScreenBinding.buttonPrice.setText(calcRoulettePrice(i, this.multiplierBuyRoulette, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rouletteBuySelectSetup$lambda$0$0(Winter2025BattlePassScreen winter2025BattlePassScreen, WinterBattlepassRouletteMainScreenBinding winterBattlepassRouletteMainScreenBinding, int i, int i2, int i3, String str, View view) {
        winter2025BattlePassScreen.multiplierBuyRoulette = 1;
        winterBattlepassRouletteMainScreenBinding.btn1.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white_selected);
        winterBattlepassRouletteMainScreenBinding.btn2.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white);
        winterBattlepassRouletteMainScreenBinding.btn3.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white);
        winterBattlepassRouletteMainScreenBinding.btn1Text.setTextColor(i);
        winterBattlepassRouletteMainScreenBinding.btn2Text.setTextColor(i2);
        winterBattlepassRouletteMainScreenBinding.btn3Text.setTextColor(i2);
        winterBattlepassRouletteMainScreenBinding.buttonPrice.setText(winter2025BattlePassScreen.calcRoulettePrice(i3, winter2025BattlePassScreen.multiplierBuyRoulette, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rouletteBuySelectSetup$lambda$0$1(Winter2025BattlePassScreen winter2025BattlePassScreen, WinterBattlepassRouletteMainScreenBinding winterBattlepassRouletteMainScreenBinding, int i, int i2, int i3, String str, View view) {
        winter2025BattlePassScreen.multiplierBuyRoulette = 5;
        winterBattlepassRouletteMainScreenBinding.btn1.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white);
        winterBattlepassRouletteMainScreenBinding.btn2.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white_selected);
        winterBattlepassRouletteMainScreenBinding.btn3.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white);
        winterBattlepassRouletteMainScreenBinding.btn1Text.setTextColor(i);
        winterBattlepassRouletteMainScreenBinding.btn2Text.setTextColor(i2);
        winterBattlepassRouletteMainScreenBinding.btn3Text.setTextColor(i);
        winterBattlepassRouletteMainScreenBinding.buttonPrice.setText(winter2025BattlePassScreen.calcRoulettePrice(i3, winter2025BattlePassScreen.multiplierBuyRoulette, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rouletteBuySelectSetup$lambda$0$2(Winter2025BattlePassScreen winter2025BattlePassScreen, WinterBattlepassRouletteMainScreenBinding winterBattlepassRouletteMainScreenBinding, int i, int i2, int i3, String str, View view) {
        winter2025BattlePassScreen.multiplierBuyRoulette = 10;
        winterBattlepassRouletteMainScreenBinding.btn1.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white);
        winterBattlepassRouletteMainScreenBinding.btn2.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white);
        winterBattlepassRouletteMainScreenBinding.btn3.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white_selected);
        winterBattlepassRouletteMainScreenBinding.btn1Text.setTextColor(i);
        winterBattlepassRouletteMainScreenBinding.btn2Text.setTextColor(i);
        winterBattlepassRouletteMainScreenBinding.btn3Text.setTextColor(i2);
        winterBattlepassRouletteMainScreenBinding.buttonPrice.setText(winter2025BattlePassScreen.calcRoulettePrice(i3, winter2025BattlePassScreen.multiplierBuyRoulette, str));
    }

    private final void rouletteBuyButtonSetup(final int i, final String str) {
        this.battlePassBinding.battlepassRouletteView.btnBuy.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.rouletteBuyButtonSetup$lambda$0$0(Winter2025BattlePassScreen.this, i, str, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rouletteBuyButtonSetup$lambda$0$0(Winter2025BattlePassScreen winter2025BattlePassScreen, int i, String str, View view) {
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, winter2025BattlePassScreen.multiplierBuyRoulette, 16, null, 4, null);
        winter2025BattlePassScreen.rouletteBuySelectSetup(i, str);
    }

    private final void updateOldPrises(List<OldPrise> list) {
        this.battlePassBinding.battlepassRouletteView.oldPriseEmpty.setVisibility(8);
        this.battlePassBinding.battlepassRouletteView.oldPriseRv.setVisibility(0);
        OldPriseAdapter oldPriseAdapter = this.oldPriseAdapter;
        List<OldPrise> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (OldPrise oldPrise : list2) {
            arrayList.add(OldPrise.copy$default(oldPrise, 0, null, null, 0, StringsKt.replace$default(oldPrise.getImage(), ".webp", "", false, 4, (Object) null), 0L, 47, null));
        }
        oldPriseAdapter.setPriseList(CollectionsKt.reversed(arrayList));
    }

    private final void onQuality() {
        this.battlePassBinding.textBonus.setText("Качество будет определено при открытии сертификата.\nВы можете получить:\n- Хлам\n- Обычное\n- Идеальное");
        this.battlePassBinding.overlay.setVisibility(0);
        this.battlePassBinding.cardInfo.setVisibility(0);
    }

    private final void setWelcomeScreen() {
        int i;
        final WinterBattlepassLayoutBinding winterBattlepassLayoutBinding = this.battlePassBinding;
        if (UtilsKt.isArizonaType()) {
            i = R.drawable.battlepass_logo;
        } else {
            i = R.drawable.battlepass_logo;
        }
        winterBattlepassLayoutBinding.logoWelcome.setImageResource(i);
        winterBattlepassLayoutBinding.winterBattlepassWelcome.setVisibility(0);
        winterBattlepassLayoutBinding.winterBattlepassWelcome.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setWelcomeScreen$lambda$0$0(view);
            }
        });
        winterBattlepassLayoutBinding.backWelcomeButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setWelcomeScreen$lambda$0$1(WinterBattlepassLayoutBinding.this, this, view);
            }
        });
        winterBattlepassLayoutBinding.btnGetInfoWinterWelcome.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setWelcomeScreen$lambda$0$2(WinterBattlepassLayoutBinding.this, view);
            }
        });
        winterBattlepassLayoutBinding.welcomePrice1.timerContainer.setVisibility(8);
        winterBattlepassLayoutBinding.welcomePrice2.timerContainer.setVisibility(8);
        winterBattlepassLayoutBinding.welcomePrice3.timerContainer.setVisibility(8);
        winterBattlepassLayoutBinding.welcomePrice1.oldPriseTitle.setText("Автомобиль: Advan Lambo");
        winterBattlepassLayoutBinding.welcomePrice2.oldPriseTitle.setText("Скин: Оборотень");
        winterBattlepassLayoutBinding.welcomePrice3.oldPriseTitle.setText("Автомобиль: Halloween Truck");
        winterBattlepassLayoutBinding.welcomePrice1.rarity.setBackgroundColor(Color.parseColor("#E500FF"));
        winterBattlepassLayoutBinding.welcomePrice3.rarity.setBackgroundColor(Color.parseColor("#FFBA00"));
        winterBattlepassLayoutBinding.welcomePrice2.rarity.setBackgroundColor(Color.parseColor("#FF3600"));
        winterBattlepassLayoutBinding.welcomePrice1.bg.setBackgroundResource(ru.mrlargha.commonui.R.drawable.rarity_red);
        winterBattlepassLayoutBinding.welcomePrice2.bg.setBackgroundResource(ru.mrlargha.commonui.R.drawable.rarity_gold);
        winterBattlepassLayoutBinding.welcomePrice3.bg.setBackgroundResource(ru.mrlargha.commonui.R.drawable.rarity_pink);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new Winter2025BattlePassScreen$setWelcomeScreen$1$4(winterBattlepassLayoutBinding, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setWelcomeScreen$lambda$0$1(WinterBattlepassLayoutBinding winterBattlepassLayoutBinding, Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winterBattlepassLayoutBinding.winterBattlepassWelcome.setVisibility(8);
        winter2025BattlePassScreen.setVisibility(false);
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, 0, 10, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setWelcomeScreen$lambda$0$2(WinterBattlepassLayoutBinding winterBattlepassLayoutBinding, View view) {
        winterBattlepassLayoutBinding.winterBattlepassWelcome.setVisibility(8);
    }

    private final void openModalWindow(BpModalWindowModel bpModalWindowModel) {
        BpSeasonEndedBinding bpSeasonEndedBinding = this.battlePassBinding.seasonEnded;
        FrameLayout root = bpSeasonEndedBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        bpSeasonEndedBinding.tvTitle.setText(bpModalWindowModel.getTitle());
        bpSeasonEndedBinding.tvDesc.setText(ParseColoredTextKt.toStyledColoredText(bpModalWindowModel.getInfo(), -1));
        bpSeasonEndedBinding.tvAccept.setText(bpModalWindowModel.getButtonAcceptText());
        bpSeasonEndedBinding.tvClose.setText(bpModalWindowModel.getButtonCloseText());
        CustomCardView btnAccept = bpSeasonEndedBinding.btnAccept;
        Intrinsics.checkNotNullExpressionValue(btnAccept, "btnAccept");
        btnAccept.setVisibility(bpModalWindowModel.getButtonAcceptText().length() > 0 ? 0 : 8);
        CustomCardView btnClose = bpSeasonEndedBinding.btnClose;
        Intrinsics.checkNotNullExpressionValue(btnClose, "btnClose");
        btnClose.setVisibility(bpModalWindowModel.getButtonCloseText().length() > 0 ? 0 : 8);
        Picasso.get().load(FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "projects/arizona-rp/systems/battlepass/image_modal/" + bpModalWindowModel.getImage() + ".webp").into(bpSeasonEndedBinding.ivPoster);
    }

    private final void setupListeners() {
        WinterBattlepassLayoutBinding winterBattlepassLayoutBinding = this.battlePassBinding;
        winterBattlepassLayoutBinding.seasonEnded.btnAccept.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda46
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupListeners$lambda$0$0(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassLayoutBinding.seasonEnded.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda47
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupListeners$lambda$0$1(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassLayoutBinding.seasonEnded.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda48
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupListeners$lambda$0$2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$0(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, -1, 19, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$1(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, -1, 20, null, 4, null);
    }

    private final void checkAvailableBp(long j) {
        long currentTimeMillis = (j * 1000) - System.currentTimeMillis();
        if (currentTimeMillis <= 0) {
            updateBlockTime(null);
        } else {
            startLeftTimer(currentTimeMillis);
        }
    }

    private final void startLeftTimer(long j) {
        Job launch$default;
        Log.d("TAG", "bockTimer: startLeftTimer " + j);
        updateBlockTime(setLeftTime(j));
        Job job = this.blockTimerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), null, null, new Winter2025BattlePassScreen$startLeftTimer$1(j, this, null), 3, null);
        this.blockTimerJob = launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String setLeftTime(long j) {
        long j2 = 60;
        return ((j / ((long) Constants.ONE_HOUR)) % 24) + StringUtils.PROCESS_POSTFIX_DELIMITER + ((j / 60000) % j2) + StringUtils.PROCESS_POSTFIX_DELIMITER + ((j / 1000) % j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateBlockTime(String str) {
        WinterBattlepassLevelSetsLayoutBinding winterBattlepassLevelSetsLayoutBinding = this.battlePassBinding.battlepassLevelSetsPage;
        Log.d("TAG", "bockTimer: updateBlockTime " + str);
        final List<TextView> listOf = CollectionsKt.listOf((Object[]) new TextView[]{winterBattlepassLevelSetsLayoutBinding.silverPriceButton, winterBattlepassLevelSetsLayoutBinding.goldPriceButton, winterBattlepassLevelSetsLayoutBinding.epicPriceButton, winterBattlepassLevelSetsLayoutBinding.legendaryPriceButton});
        if (str == null) {
            return new Function0() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda39
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit updateBlockTime$lambda$0$1;
                    updateBlockTime$lambda$0$1 = Winter2025BattlePassScreen.updateBlockTime$lambda$0$1(listOf);
                    return updateBlockTime$lambda$0$1;
                }
            };
        }
        for (TextView textView : listOf) {
            textView.setText(str);
            textView.setAlpha(0.6f);
            textView.setEnabled(false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateBlockTime$lambda$0$1(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            TextView textView = (TextView) it.next();
            textView.setText("Купить");
            textView.setAlpha(1.0f);
            textView.setEnabled(true);
        }
        return Unit.INSTANCE;
    }

    /* compiled from: Winter2025BattlePass.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/Winter2025BattlePassScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "battle-pass_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf((Object[]) new UIElementID[]{UIElementID.MAIN_BATTLE_PASS, UIElementID.BATTLE_PASS});

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new Winter2025BattlePassScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Winter2025BattlePass.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/Winter2025BattlePassScreen$NavItems;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN_PAGE", "TASKS_PAGE", "ROULETTE_PAGE", "DONATE_PAGE", "LEVEL_SETS", "BUY_PREMIUM", "CONVERT_BATTLE_COINS", "battle-pass_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class NavItems {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ NavItems[] $VALUES;
        public static final NavItems MAIN_PAGE = new NavItems("MAIN_PAGE", 0);
        public static final NavItems TASKS_PAGE = new NavItems("TASKS_PAGE", 1);
        public static final NavItems ROULETTE_PAGE = new NavItems("ROULETTE_PAGE", 2);
        public static final NavItems DONATE_PAGE = new NavItems("DONATE_PAGE", 3);
        public static final NavItems LEVEL_SETS = new NavItems("LEVEL_SETS", 4);
        public static final NavItems BUY_PREMIUM = new NavItems("BUY_PREMIUM", 5);
        public static final NavItems CONVERT_BATTLE_COINS = new NavItems("CONVERT_BATTLE_COINS", 6);

        private static final /* synthetic */ NavItems[] $values() {
            return new NavItems[]{MAIN_PAGE, TASKS_PAGE, ROULETTE_PAGE, DONATE_PAGE, LEVEL_SETS, BUY_PREMIUM, CONVERT_BATTLE_COINS};
        }

        public static EnumEntries<NavItems> getEntries() {
            return $ENTRIES;
        }

        public static NavItems valueOf(String str) {
            return (NavItems) Enum.valueOf(NavItems.class, str);
        }

        public static NavItems[] values() {
            return (NavItems[]) $VALUES.clone();
        }

        private NavItems(String str, int i) {
        }

        static {
            NavItems[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }
}
