package ru.mrlargha.feature.battlepassWinter2025;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.arizona.game.BuildConfig;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.gson.JsonParseException;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.utils.CustomTextView;
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
import ru.mrlargha.feature.battlepassWinter2025.data.BattlePassOpenPage;
import ru.mrlargha.feature.battlepassWinter2025.data.BattlePassPremiumData;
import ru.mrlargha.feature.battlepassWinter2025.data.BattlePassUpdateCoinsData;
import ru.mrlargha.feature.battlepassWinter2025.data.BpModalWindowModel;
import ru.mrlargha.feature.battlepassWinter2025.data.CategoryType;
import ru.mrlargha.feature.battlepassWinter2025.data.CommonTaskInfo;
import ru.mrlargha.feature.battlepassWinter2025.data.EventPreviewData;
import ru.mrlargha.feature.battlepassWinter2025.data.EventPreviewRewardData;
import ru.mrlargha.feature.battlepassWinter2025.data.MainBattlePassInfo;
import ru.mrlargha.feature.battlepassWinter2025.data.RewardGetRequest;
import ru.mrlargha.feature.battlepassWinter2025.data.RouletteData;
import ru.mrlargha.feature.battlepassWinter2025.databinding.BpSeasonEndedBinding;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassConvertBattlecoinsLayoutBinding;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassLayoutBinding;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassLevelSetsLayoutBinding;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassRewardDescriptionPopupBinding;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassRouletteLayoutBinding;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassRouletteOldPriseItemWelcomeBinding;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassWelcomeLayoutBinding;
import ru.mrlargha.feature.battlepassWinter2025.roulette.data.OldPrise;
import ru.mrlargha.feature.battlepassWinter2025.roulette.data.PossiblePrise;
import ru.mrlargha.feature.battlepassWinter2025.utils.ArizonaMissionEpochTracker;
import ru.mrlargha.feature.battlepassWinter2025.utils.ArizonaMissionTableKeys;
import ru.mrlargha.feature.battlepassWinter2025.utils.ArizonaMissionsState;
import ru.mrlargha.feature.battlepassWinter2025.utils.ArizonaTaskResetTime;
import ru.mrlargha.feature.battlepassWinter2025.utils.ArizonaTaskResetTimer;
import ru.mrlargha.ui.kit.ParseColoredTextKt;
/* compiled from: Winter2025BattlePass.kt */
@Metadata(d1 = {"\u0000\u008a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 º\u00012\u00020\u0001:\u0006º\u0001»\u0001¼\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u0005H\u0002J\u0010\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u000bH\u0016J\u0018\u0010W\u001a\u00020U2\u0006\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\u0005H\u0016J\u001c\u0010Z\u001a\u00020U2\u0012\u0010[\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050909H\u0002J\b\u0010\\\u001a\u00020UH\u0002J\b\u0010]\u001a\u00020\u0005H\u0002J\b\u0010^\u001a\u00020UH\u0002J\b\u0010_\u001a\u00020UH\u0002J\b\u0010`\u001a\u00020UH\u0002J\b\u0010a\u001a\u00020UH\u0002J\u0010\u0010b\u001a\u00020U2\u0006\u0010c\u001a\u00020GH\u0002J\u0010\u0010d\u001a\u00020U2\u0006\u0010c\u001a\u00020GH\u0002J\b\u0010e\u001a\u00020UH\u0002J\b\u0010f\u001a\u00020UH\u0002J\u0018\u0010g\u001a\u00020U2\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020\u000bH\u0002J\b\u0010k\u001a\u00020UH\u0002J\b\u0010l\u001a\u00020UH\u0002J\b\u0010m\u001a\u00020UH\u0002J\b\u0010n\u001a\u00020UH\u0002J\b\u0010o\u001a\u00020UH\u0002J\b\u0010p\u001a\u00020UH\u0002J\b\u0010q\u001a\u00020UH\u0002J\b\u0010r\u001a\u00020UH\u0002J!\u0010s\u001a\u00020U2\u0006\u0010t\u001a\u00020u2\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010wJ\u0010\u0010x\u001a\u00020U2\u0006\u0010y\u001a\u00020\tH\u0002J!\u0010z\u001a\u00020U2\u0006\u0010{\u001a\u00020u2\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010wJ\u001a\u0010|\u001a\u00020U2\u0006\u0010}\u001a\u00020\u000b2\b\b\u0002\u0010~\u001a\u00020\u000bH\u0002J\b\u0010\u007f\u001a\u00020UH\u0002J\t\u0010\u0080\u0001\u001a\u00020UH\u0002J\u0011\u0010\u0081\u0001\u001a\u00020U2\u0006\u0010{\u001a\u00020uH\u0002J\u0017\u0010\u0082\u0001\u001a\u00020U2\u0007\u0010\u0083\u0001\u001a\u000200H\u0003b\u0003\b\u0084\u0001J\t\u0010\u0085\u0001\u001a\u00020UH\u0002J\u0012\u0010\u0086\u0001\u001a\u00020U2\u0007\u0010\u0087\u0001\u001a\u00020\u000bH\u0002J\t\u0010\u0088\u0001\u001a\u00020UH\u0002J\u0011\u0010\u0089\u0001\u001a\u00020\u000b2\u0006\u0010t\u001a\u00020uH\u0002J\u0019\u0010\u008a\u0001\u001a\u00020U2\u0006\u0010{\u001a\u00020=2\u0006\u0010t\u001a\u00020uH\u0002J\u001a\u0010\u008b\u0001\u001a\u00020U2\u0006\u0010{\u001a\u00020=2\u0007\u0010\u008c\u0001\u001a\u00020\u0005H\u0002J\u0018\u0010\u008d\u0001\u001a\u00020U2\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0003b\u0003\b\u0084\u0001J\u0018\u0010\u0090\u0001\u001a\u00020U2\r\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020=09H\u0002J\u0017\u0010\u0092\u0001\u001a\u00020U2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020M09H\u0002J\u0017\u0010\u0093\u0001\u001a\u00020U2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020M09H\u0002J\u0017\u0010\u0094\u0001\u001a\u00020U2\u0007\u0010\u0095\u0001\u001a\u00020\u0005H\u0003b\u0003\b\u0084\u0001J\u0012\u0010\u0096\u0001\u001a\u00020U2\u0007\u0010\u0097\u0001\u001a\u00020\u0005H\u0002J\u0019\u0010\u0098\u0001\u001a\u00020U2\t\b\u0002\u0010\u0099\u0001\u001a\u00020\u000bH\u0003b\u0003\b\u0084\u0001J$\u0010\u009a\u0001\u001a\u00020U2\u0019\u0010\u009b\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020:0209H\u0002J\t\u0010\u009c\u0001\u001a\u00020UH\u0002J\u001b\u0010\u009d\u0001\u001a\u00020U2\u0007\u0010\u009e\u0001\u001a\u00020\u000b2\u0007\u0010\u008c\u0001\u001a\u00020\u0005H\u0002J$\u0010\u009f\u0001\u001a\u00020U2\u0007\u0010 \u0001\u001a\u00020\u00132\u0007\u0010\u008c\u0001\u001a\u00020\u00052\u0007\u0010\u009e\u0001\u001a\u00020\u000bH\u0002J\u0012\u0010¡\u0001\u001a\u00020U2\u0007\u0010¢\u0001\u001a\u00020\tH\u0002J\t\u0010£\u0001\u001a\u00020UH\u0002J\t\u0010¤\u0001\u001a\u00020UH\u0002J\t\u0010¥\u0001\u001a\u00020UH\u0002J\u0013\u0010¦\u0001\u001a\u00020U2\b\u0010§\u0001\u001a\u00030¨\u0001H\u0002J\u001f\u0010©\u0001\u001a\u00020U2\b\u0010ª\u0001\u001a\u00030«\u00012\n\u0010¬\u0001\u001a\u0005\u0018\u00010\u00ad\u0001H\u0002J;\u0010®\u0001\u001a\u00020U2\b\u0010¯\u0001\u001a\u00030°\u00012\u0007\u0010±\u0001\u001a\u00020\t2\t\u0010²\u0001\u001a\u0004\u0018\u00010\t2\u0007\u0010³\u0001\u001a\u00020\u00052\t\b\u0002\u0010´\u0001\u001a\u00020\u000bH\u0002J\u0017\u0010µ\u0001\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\tH\u0002¢\u0006\u0003\u0010¶\u0001J\u0013\u0010·\u0001\u001a\u00020U2\b\u0010§\u0001\u001a\u00030¸\u0001H\u0002J\t\u0010¹\u0001\u001a\u00020UH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0005\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020:09X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020:09X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020=09X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020=09X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010?\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u000e\u0010C\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020M09X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010N\u001a\b\u0012\u0004\u0012\u00020M09X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020RX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006½\u0001"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/Winter2025BattlePassScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "azCoinsLink", "", "supportsBattlePassCurrency", "", "visualSkin", "Lru/mrlargha/feature/battlepassWinter2025/BattlePassVisualSkin;", "visualContext", "Landroid/view/ContextThemeWrapper;", "battlePassUi", "Lru/mrlargha/feature/battlepassWinter2025/BattlePassUi;", "layout", "Landroid/view/View;", "battlePassBinding", "Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassLayoutBinding;", "colorMaxProgress", "colorText", "whiteColor", "taskProgressColor", "taskProgressTextColor", "getTaskProgressTextColor", "()I", "taskProgressTextColor$delegate", "Lkotlin/Lazy;", "navigationActiveTextColor", "navigationInactiveTextColor", "navigationSelectedBackgroundColor", "premiumTaskLockBgStartColor", "premiumTaskLockBgEndColor", "premiumTaskLockGradientAngle", "levelSetBuyText", "levelSetUnavailableText", "colorHex", "colorRes", "commonTasksAdapter", "Lru/mrlargha/feature/battlepassWinter2025/CommonTasksAdapter;", "rewardsTasksAdapter", "Lru/mrlargha/feature/battlepassWinter2025/RewardsTasksAdapter;", "levelItemsAdapter", "Lru/mrlargha/feature/battlepassWinter2025/LevelItemsAdapter;", "battlePassInfo", "Lru/mrlargha/feature/battlepassWinter2025/data/MainBattlePassInfo;", "pendingPremiumRewardDescription", "Lkotlin/Pair;", "premiumRewardDescriptionPopup", "Landroid/widget/PopupWindow;", "startBattleCoinNumbCurse", "selectedBattleCoinMultiplier", "Lru/mrlargha/feature/battlepassWinter2025/data/BattleCoinsMultiplier;", "_bpUsualData", "", "Lru/mrlargha/feature/battlepassWinter2025/data/AwardItemData;", "_bpPremData", "_taskUsualData", "Lru/mrlargha/feature/battlepassWinter2025/data/CommonTaskInfo;", "_taskPremData", "client", "Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "getClient", "()Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "api", "Lru/mrlargha/feature/battlepassWinter2025/WinterBattlePassApi;", "isRouletteOpen", "currentNavItem", "Lru/mrlargha/feature/battlepassWinter2025/Winter2025BattlePassScreen$NavItems;", "rouletteController", "Lru/mrlargha/feature/battlepassWinter2025/BattlePassRouletteController;", "purchaseController", "Lru/mrlargha/feature/battlepassWinter2025/BattlePassPurchaseController;", "_usualTasks", "Lru/mrlargha/feature/battlepassWinter2025/data/ActualTask;", "_premTasks", "arizonaMissionsState", "Lru/mrlargha/feature/battlepassWinter2025/utils/ArizonaMissionsState;", "arizonaMissionEpochTracker", "Lru/mrlargha/feature/battlepassWinter2025/utils/ArizonaMissionEpochTracker;", "project", "setVisibility", "", "visible", "onBackendMessageHandled", "data", "subId", "updateBpAwards", "awardsStatusList", "setupConvertBattleCoinsPage", "getChosenMultiplier", "updateUiBySelectedMultiplier", "setupMainPageInfo", "setupNavigation", "openAzCoinsPurchase", "openPageFromUser", "navItem", "clickButtonMenuNavigation", "hideAllPages", "resetNavigationAlpha", "applyNavigationState", "item", "Lru/mrlargha/feature/battlepassWinter2025/BattlePassNavigationItemViews;", "selected", "refreshChromeVisibility", "showMainPage", "showTasksPage", "showRoulettePage", "showLevelSetsPage", "showBuyPremiumPage", "showConvertBattleCoinsPage", "setupCommonTasksInfo", "selectTaskCategory", "categoryType", "Lru/mrlargha/feature/battlepassWinter2025/data/CategoryType;", "preferredTaskId", "(Lru/mrlargha/feature/battlepassWinter2025/data/CategoryType;Ljava/lang/Integer;)V", "openBackendRequestedPage", "payload", "filterListForSelectedTask", "task", "applyTasksListVisibility", "isEmpty", "isLoading", "showTasksEmptySafeState", "showTasksLoadingState", "updateTaskCategoryTheme", "updateMainPageInfo", "info", "Landroidx/annotation/MainThread;", "updateLevelInfoOnPages", "setPremiumTaskLockVisible", "isVisible", "showPremiumTaskLockFallback", "updatePremiumTaskLock", "showSelectedTask", "showTaskInfo", "position", "updateCoins", "coinsData", "Lru/mrlargha/feature/battlepassWinter2025/data/BattlePassUpdateCoinsData;", "updateCommonTaskItems", "commonTasks", "updateTasks", "updateArizonaTasksProgress", "ensureArizonaMissionsForPremium", "premium", "loadArizonaMissionTable", "tier", "publishArizonaMissionsToUi", "preserveSelection", "updateLevelItems", "pairList", "updateLogo", "onClaimItem", "isPremium", "requestRewardDescription", "anchor", "showPremiumRewardDescription", "description", "dismissPremiumRewardDescription", "onQuality", "setWelcomeScreen", "showEventPreview", CommonUrlParts.MODEL, "Lru/mrlargha/feature/battlepassWinter2025/data/EventPreviewData;", "bindEventPreviewReward", "binding", "Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassRouletteOldPriseItemWelcomeBinding;", "reward", "Lru/mrlargha/feature/battlepassWinter2025/data/EventPreviewRewardData;", "loadEventPreviewImage", "view", "Landroid/widget/ImageView;", "folder", "resource", "fallback", "centerCrop", "toColorOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "openModalWindow", "Lru/mrlargha/feature/battlepassWinter2025/data/BpModalWindowModel;", "setupListeners", "Companion", "Spawner", "NavItems", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Winter2025BattlePassScreen extends SAMPUIElement {
    @Deprecated
    public static final int ARIZONA_MISSION_LOAD_ATTEMPTS = 3;
    @Deprecated
    public static final long ARIZONA_MISSION_RETRY_DELAY_MS = 1000;
    @Deprecated
    public static final int ARIZONA_REFRESH_TASKS_SUB_ID = 25;
    @Deprecated
    public static final int ARIZONA_WELCOME_CTA_SUB_ID = 24;
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final String EVENT_PREVIEW_BACKGROUND_PATH = "systems/event_preview/background";
    @Deprecated
    public static final String EVENT_PREVIEW_LOGO_PATH = "systems/event_preview/logo";
    @Deprecated
    public static final String EVENT_PREVIEW_PRIZE_PATH = "systems/event_preview/prize";
    @Deprecated
    public static final int EVENT_PREVIEW_RARITY_ALPHA = 128;
    private List<AwardItemData> _bpPremData;
    private List<AwardItemData> _bpUsualData;
    private List<ActualTask> _premTasks;
    private List<CommonTaskInfo> _taskPremData;
    private List<CommonTaskInfo> _taskUsualData;
    private List<ActualTask> _usualTasks;
    private final WinterBattlePassApi api;
    private final ArizonaMissionEpochTracker arizonaMissionEpochTracker;
    private final ArizonaMissionsState arizonaMissionsState;
    private final String azCoinsLink;
    private final WinterBattlepassLayoutBinding battlePassBinding;
    private MainBattlePassInfo battlePassInfo;
    private final BattlePassUi battlePassUi;
    private final ArizonaRetrofit client;
    private final int colorMaxProgress;
    private final int colorText;
    private final CommonTasksAdapter commonTasksAdapter;
    private NavItems currentNavItem;
    private boolean isRouletteOpen;
    private final View layout;
    private final LevelItemsAdapter levelItemsAdapter;
    private final String levelSetBuyText;
    private final String levelSetUnavailableText;
    private final int navigationActiveTextColor;
    private final int navigationInactiveTextColor;
    private final int navigationSelectedBackgroundColor;
    private Pair<? extends View, Integer> pendingPremiumRewardDescription;
    private PopupWindow premiumRewardDescriptionPopup;
    private final int premiumTaskLockBgEndColor;
    private final int premiumTaskLockBgStartColor;
    private final int premiumTaskLockGradientAngle;
    private final String project;
    private final BattlePassPurchaseController purchaseController;
    private final RewardsTasksAdapter rewardsTasksAdapter;
    private final BattlePassRouletteController rouletteController;
    private BattleCoinsMultiplier selectedBattleCoinMultiplier;
    private final int startBattleCoinNumbCurse;
    private final boolean supportsBattlePassCurrency;
    private final int taskProgressColor;
    private final Lazy taskProgressTextColor$delegate;
    private final ContextThemeWrapper visualContext;
    private final BattlePassVisualSkin visualSkin;
    private final int whiteColor;

    /* compiled from: Winter2025BattlePass.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
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
                iArr[BattlePassModelType.ArizonaWelcome.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[BattlePassModelType.PremiumRewardDescription.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[BattlePassModelType.EventPreview.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[BattlePassModelType.OpenPage.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[BattlePassModelType.ModalWindow.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[BattlePassModelType.BlockTimer.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BattleCoinsMultiplier.values().length];
            try {
                iArr2[BattleCoinsMultiplier.X10.ordinal()] = 1;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr2[BattleCoinsMultiplier.X100.ordinal()] = 2;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr2[BattleCoinsMultiplier.X1000.ordinal()] = 3;
            } catch (NoSuchFieldError unused20) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[NavItems.values().length];
            try {
                iArr3[NavItems.TASKS_PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr3[NavItems.LEVEL_SETS.ordinal()] = 2;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr3[NavItems.MAIN_PAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr3[NavItems.ROULETTE_PAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr3[NavItems.DONATE_PAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr3[NavItems.BUY_PREMIUM.ordinal()] = 6;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr3[NavItems.CONVERT_BATTLE_COINS.ordinal()] = 7;
            } catch (NoSuchFieldError unused27) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[BattlePassOpenPage.values().length];
            try {
                iArr4[BattlePassOpenPage.Levels.ordinal()] = 1;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr4[BattlePassOpenPage.Tasks.ordinal()] = 2;
            } catch (NoSuchFieldError unused29) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setWelcomeScreen$lambda$0$0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$2(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showEventPreview$lambda$0$0(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Winter2025BattlePassScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        String str;
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        if (UtilsKt.isArizonaType()) {
            str = "https://arizona-rp.com/shop";
        } else {
            str = "https://rodina-rp.com/shop";
        }
        this.azCoinsLink = str;
        BattlePassVisualSkin resolve = BattlePassVisualSkinResolver.INSTANCE.resolve(UtilsKt.isArizonaType(), UtilsKt.isBrazilType());
        this.visualSkin = resolve;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(targetActivity, resolve.getThemeOverlay());
        this.visualContext = contextThemeWrapper;
        BattlePassUiFactory battlePassUiFactory = BattlePassUiFactory.INSTANCE;
        LayoutInflater cloneInContext = targetActivity.getLayoutInflater().cloneInContext(contextThemeWrapper);
        Intrinsics.checkNotNullExpressionValue(cloneInContext, "cloneInContext(...)");
        BattlePassUi create = battlePassUiFactory.create(cloneInContext, contextThemeWrapper, resolve);
        this.battlePassUi = create;
        View host = create.getHost();
        this.layout = host;
        WinterBattlepassLayoutBinding binding = create.getBinding();
        this.battlePassBinding = binding;
        int resolveBattlePassColor = BattlePassVisualSkinKt.resolveBattlePassColor(contextThemeWrapper, R.attr.winterBpTaskProgressDone, R.color.winter_bp_task_progress_done);
        this.colorMaxProgress = resolveBattlePassColor;
        int resolveBattlePassColor2 = BattlePassVisualSkinKt.resolveBattlePassColor(contextThemeWrapper, R.attr.winterBpSelectedText, R.color.winter_bp_selected_text);
        this.colorText = resolveBattlePassColor2;
        int color = ContextCompat.getColor(contextThemeWrapper, R.color.winter_bp_white);
        this.whiteColor = color;
        this.taskProgressColor = BattlePassVisualSkinKt.resolveBattlePassColor(contextThemeWrapper, R.attr.winterBpTaskSurfaceTrack, R.color.winter_bp_white);
        this.taskProgressTextColor$delegate = LazyKt.lazy(new Function0() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda49
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int currentTextColor;
                currentTextColor = Winter2025BattlePassScreen.this.battlePassUi.getTasksPage().getProgressCountText().getCurrentTextColor();
                return Integer.valueOf(currentTextColor);
            }
        });
        this.navigationActiveTextColor = BattlePassVisualSkinKt.resolveBattlePassColor(contextThemeWrapper, R.attr.winterBpNavActiveText, R.color.winter_bp_white);
        this.navigationInactiveTextColor = BattlePassVisualSkinKt.resolveBattlePassColor(contextThemeWrapper, R.attr.winterBpNavInactiveText, R.color.winter_bp_white);
        this.navigationSelectedBackgroundColor = BattlePassVisualSkinKt.resolveBattlePassColor(contextThemeWrapper, R.attr.winterBpNavSelectedBg, 17170445);
        this.premiumTaskLockBgStartColor = BattlePassVisualSkinKt.resolveBattlePassColor(contextThemeWrapper, R.attr.winterBpTaskLockStart, R.color.winter_bp_task_lock_gradient_start);
        this.premiumTaskLockBgEndColor = BattlePassVisualSkinKt.resolveBattlePassColor(contextThemeWrapper, R.attr.winterBpTaskLockEnd, R.color.winter_bp_task_lock_gradient_end);
        this.premiumTaskLockGradientAngle = 90;
        String string = targetActivity.getString(R.string.battlepass_buy);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.levelSetBuyText = string;
        String string2 = targetActivity.getString(R.string.battlepass_unavailable);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.levelSetUnavailableText = string2;
        this.commonTasksAdapter = new CommonTasksAdapter(UtilsKt.isArizonaType(), resolveBattlePassColor, create.getItemLayouts().getCommonTaskItem(), new Function2() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Winter2025BattlePassScreen.commonTasksAdapter$lambda$0(Winter2025BattlePassScreen.this, (CommonTaskInfo) obj, ((Integer) obj2).intValue());
            }
        });
        this.rewardsTasksAdapter = new RewardsTasksAdapter(create.getItemLayouts().getTaskRewardItem(), UtilsKt.isArizonaType(), new Function0() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String trimEnd;
                trimEnd = StringsKt.trimEnd(FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null), '/');
                return trimEnd;
            }
        });
        this.levelItemsAdapter = new LevelItemsAdapter(create.getItemLayouts().getLevelItem(), new Function0() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Winter2025BattlePassScreen.levelItemsAdapter$lambda$0(Winter2025BattlePassScreen.this);
            }
        }, new Function0() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Winter2025BattlePassScreen.levelItemsAdapter$lambda$1(Winter2025BattlePassScreen.this);
            }
        }, new Function2() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Winter2025BattlePassScreen.levelItemsAdapter$lambda$2(Winter2025BattlePassScreen.this, ((Boolean) obj).booleanValue(), ((Integer) obj2).intValue());
            }
        }, new Winter2025BattlePassScreen$levelItemsAdapter$4(this), new Function0() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Winter2025BattlePassScreen.levelItemsAdapter$lambda$3(Winter2025BattlePassScreen.this);
            }
        });
        this.startBattleCoinNumbCurse = 250;
        this.selectedBattleCoinMultiplier = BattleCoinsMultiplier.X1000;
        this._bpUsualData = CollectionsKt.emptyList();
        this._bpPremData = CollectionsKt.emptyList();
        this._taskUsualData = CollectionsKt.emptyList();
        this._taskPremData = CollectionsKt.emptyList();
        ArizonaRetrofit arizonaRetrofit = new ArizonaRetrofit(targetActivity, i);
        this.client = arizonaRetrofit;
        this.api = (WinterBattlePassApi) ArizonaRetrofit.create$default(arizonaRetrofit, WinterBattlePassApi.class, false, null, null, 14, null);
        this.currentNavItem = NavItems.MAIN_PAGE;
        this.rouletteController = new BattlePassRouletteController(binding, UtilsKt.isArizonaType(), resolveBattlePassColor2, color, new Function2() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Winter2025BattlePassScreen.rouletteController$lambda$0(Winter2025BattlePassScreen.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
            }
        }, new Function1() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Winter2025BattlePassScreen.rouletteController$lambda$1(Winter2025BattlePassScreen.this, ((Boolean) obj).booleanValue());
            }
        });
        BattlePassPurchaseController battlePassPurchaseController = new BattlePassPurchaseController(targetActivity, binding, create.getMainPage().getPremiumAction(), arizonaRetrofit.getScope(), UtilsKt.isArizonaType(), string, string2, new Function2() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Winter2025BattlePassScreen.purchaseController$lambda$0(Winter2025BattlePassScreen.this, (ImageView) obj, (String) obj2);
            }
        }, new Function2() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Winter2025BattlePassScreen.purchaseController$lambda$1(Winter2025BattlePassScreen.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
            }
        });
        this.purchaseController = battlePassPurchaseController;
        this._usualTasks = CollectionsKt.emptyList();
        this._premTasks = CollectionsKt.emptyList();
        this.arizonaMissionsState = new ArizonaMissionsState();
        this.arizonaMissionEpochTracker = new ArizonaMissionEpochTracker();
        this.project = UtilsKt.isArizonaType() ? BuildConfig.FLAVOR : "rodina";
        addViewToConstraintLayout(host, -1, -1);
        create.prepare();
        binding.battlepass2023Container.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen._init_$lambda$0(view);
            }
        });
        LinearLayout buttonBuyBattlePoints = binding.buttonBuyBattlePoints;
        Intrinsics.checkNotNullExpressionValue(buttonBuyBattlePoints, "buttonBuyBattlePoints");
        buttonBuyBattlePoints.setVisibility(this.supportsBattlePassCurrency ? 0 : 8);
        if (UtilsKt.isArizonaType()) {
            ConstraintLayout root = binding.winterBattlepassWelcome.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            root.setVisibility(8);
        } else {
            setWelcomeScreen();
        }
        setupNavigation();
        setupMainPageInfo();
        setupCommonTasksInfo();
        battlePassPurchaseController.setupLevelBuyPage();
        if (this.supportsBattlePassCurrency) {
            setupConvertBattleCoinsPage();
        }
        clickButtonMenuNavigation(NavItems.MAIN_PAGE);
        setupListeners();
    }

    /* compiled from: Winter2025BattlePass.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/Winter2025BattlePassScreen$Companion;", "", "<init>", "()V", "ARIZONA_WELCOME_CTA_SUB_ID", "", "ARIZONA_REFRESH_TASKS_SUB_ID", "EVENT_PREVIEW_BACKGROUND_PATH", "", "EVENT_PREVIEW_LOGO_PATH", "EVENT_PREVIEW_PRIZE_PATH", "EVENT_PREVIEW_RARITY_ALPHA", "ARIZONA_MISSION_LOAD_ATTEMPTS", "ARIZONA_MISSION_RETRY_DELAY_MS", "", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final int getTaskProgressTextColor() {
        return ((Number) this.taskProgressTextColor$delegate.getValue()).intValue();
    }

    private final String colorHex(int i) {
        String num = Integer.toString(ContextCompat.getColor(getTargetActivity(), i) & 16777215, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        String upperCase = num.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return "#" + StringsKt.padStart(upperCase, 6, '0');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit commonTasksAdapter$lambda$0(Winter2025BattlePassScreen winter2025BattlePassScreen, CommonTaskInfo task, int i) {
        Intrinsics.checkNotNullParameter(task, "task");
        winter2025BattlePassScreen.showTaskInfo(task, i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit levelItemsAdapter$lambda$0(Winter2025BattlePassScreen winter2025BattlePassScreen) {
        winter2025BattlePassScreen.openPageFromUser(NavItems.LEVEL_SETS);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit levelItemsAdapter$lambda$1(Winter2025BattlePassScreen winter2025BattlePassScreen) {
        winter2025BattlePassScreen.onQuality();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit levelItemsAdapter$lambda$2(Winter2025BattlePassScreen winter2025BattlePassScreen, boolean z, int i) {
        winter2025BattlePassScreen.onClaimItem(z, i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit levelItemsAdapter$lambda$3(Winter2025BattlePassScreen winter2025BattlePassScreen) {
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, 0, 21, null, 4, null);
        return Unit.INSTANCE;
    }

    public final ArizonaRetrofit getClient() {
        return this.client;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit rouletteController$lambda$0(Winter2025BattlePassScreen winter2025BattlePassScreen, int i, int i2) {
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, i, i2, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit rouletteController$lambda$1(Winter2025BattlePassScreen winter2025BattlePassScreen, boolean z) {
        winter2025BattlePassScreen.isRouletteOpen = z;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit purchaseController$lambda$0(Winter2025BattlePassScreen winter2025BattlePassScreen, ImageView image, String id) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(id, "id");
        loadEventPreviewImage$default(winter2025BattlePassScreen, image, EVENT_PREVIEW_PRIZE_PATH, id, ru.mrlargha.commonui.R.drawable.image_placeholder, false, 16, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit purchaseController$lambda$1(Winter2025BattlePassScreen winter2025BattlePassScreen, int i, int i2) {
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, i, i2, null, 4, null);
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        if (!z) {
            dismissPremiumRewardDescription();
            this.commonTasksAdapter.clearAllTasksList();
            this.levelItemsAdapter.clearItems();
            this.rouletteController.clear();
            if (UtilsKt.isArizonaType()) {
                this.arizonaMissionsState.beginProgressSnapshot();
                this.arizonaMissionEpochTracker.prepareForNextMain();
                this._usualTasks = CollectionsKt.emptyList();
                this._premTasks = CollectionsKt.emptyList();
            }
        }
        super.setVisibility(z);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        BattlePassModelType fromType = BattlePassModelType.Companion.fromType(i);
        if (fromType == null) {
            return;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[fromType.ordinal()]) {
            case 1:
                updateMainPageInfo((MainBattlePassInfo) MapperKt.toModel(data, MainBattlePassInfo.class));
                return;
            case 2:
                return;
            case 3:
                updateTasks(MapperKt.toListModel(data, ActualTask.class));
                return;
            case 4:
                this.purchaseController.updateLevelSetsInfo(MapperKt.toListModel(data, BattlePassLevelSetData.class));
                return;
            case 5:
                this.purchaseController.updateBattlePassPremium(MapperKt.toListModel(data, BattlePassPremiumData.class));
                return;
            case 6:
                updateCoins((BattlePassUpdateCoinsData) MapperKt.toModel(data, BattlePassUpdateCoinsData.class));
                return;
            case 7:
                this.rouletteController.setup(MapperKt.toListModel(data, RouletteData.class));
                return;
            case 8:
                this.rouletteController.addPossiblePrise((PossiblePrise) CollectionsKt.first((List<? extends Object>) MapperKt.toListModel(data, PossiblePrise.class)));
                return;
            case 9:
                this.rouletteController.spinPrises(MapperKt.toListModel(data, Integer.TYPE));
                return;
            case 10:
                this.rouletteController.updateOldPrises(MapperKt.toListModel(data, OldPrise.class));
                return;
            case 11:
                if (UtilsKt.isArizonaType()) {
                    return;
                }
                setWelcomeScreen();
                return;
            case 12:
                if (UtilsKt.isArizonaType()) {
                    setWelcomeScreen();
                    return;
                }
                return;
            case 13:
                showPremiumRewardDescription(data);
                return;
            case 14:
                if (UtilsKt.isArizonaType()) {
                    showEventPreview((EventPreviewData) MapperKt.toModel(data, EventPreviewData.class));
                    return;
                }
                return;
            case 15:
                openBackendRequestedPage(data);
                return;
            case 16:
                if (data.length() == 0) {
                    FrameLayout root = this.battlePassBinding.seasonEnded.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                    root.setVisibility(8);
                    refreshChromeVisibility();
                    return;
                } else if (MapperKt.isJsonValid(data)) {
                    openModalWindow((BpModalWindowModel) MapperKt.getGson().fromJson(data, (Class<Object>) BpModalWindowModel.class));
                    return;
                } else {
                    throw new JsonParseException("Json is not valid");
                }
            case 17:
                this.purchaseController.checkAvailableBp(Long.parseLong(data));
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void updateBpAwards(List<? extends List<Integer>> list) {
        BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), Dispatchers.getIO(), null, new Winter2025BattlePassScreen$updateBpAwards$1(this, list, null), 2, null);
    }

    private final void setupConvertBattleCoinsPage() {
        final WinterBattlepassConvertBattlecoinsLayoutBinding winterBattlepassConvertBattlecoinsLayoutBinding = this.battlePassBinding.battlepassConvertBattlecoinsPage;
        winterBattlepassConvertBattlecoinsLayoutBinding.buttonBattleCoinsConvert.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupConvertBattleCoinsPage$lambda$0$0(Winter2025BattlePassScreen.this, winterBattlepassConvertBattlecoinsLayoutBinding, view);
            }
        });
        winterBattlepassConvertBattlecoinsLayoutBinding.plusBattlepointsButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda44
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupConvertBattleCoinsPage$lambda$0$1(WinterBattlepassConvertBattlecoinsLayoutBinding.this, this, view);
            }
        });
        winterBattlepassConvertBattlecoinsLayoutBinding.minusBattlepointsButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda45
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupConvertBattleCoinsPage$lambda$0$2(WinterBattlepassConvertBattlecoinsLayoutBinding.this, this, view);
            }
        });
        winterBattlepassConvertBattlecoinsLayoutBinding.multiplierBattlepoints10Text.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda46
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupConvertBattleCoinsPage$lambda$0$3(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassConvertBattlecoinsLayoutBinding.multiplierBattlepoints100Text.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda47
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupConvertBattleCoinsPage$lambda$0$4(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassConvertBattlecoinsLayoutBinding.multiplierBattlepoints1000Text.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda48
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

    private final void setupMainPageInfo() {
        this.battlePassBinding.levelItemsRc.setAdapter(this.levelItemsAdapter);
        this.battlePassUi.getTasksPage().getRewardsList().setAdapter(this.rewardsTasksAdapter);
    }

    private final void setupNavigation() {
        BattlePassNavigationViews navigation = this.battlePassUi.getNavigation();
        navigation.getBackButton().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupNavigation$lambda$0$0(Winter2025BattlePassScreen.this, view);
            }
        });
        navigation.getMain().getContainer().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupNavigation$lambda$0$1(Winter2025BattlePassScreen.this, view);
            }
        });
        navigation.getTasks().getContainer().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupNavigation$lambda$0$2(Winter2025BattlePassScreen.this, view);
            }
        });
        navigation.getCases().getContainer().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupNavigation$lambda$0$3(Winter2025BattlePassScreen.this, view);
            }
        });
        navigation.getCurrencyContainer().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.this.openAzCoinsPurchase();
            }
        });
        View currencyAddButton = navigation.getCurrencyAddButton();
        if (currencyAddButton != null) {
            currencyAddButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda20
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Winter2025BattlePassScreen.this.openAzCoinsPurchase();
                }
            });
        }
        BattlePassMainPageViews mainPage = this.battlePassUi.getMainPage();
        mainPage.getBuyLevelsButton().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupNavigation$lambda$1$0(Winter2025BattlePassScreen.this, view);
            }
        });
        mainPage.getPremiumAction().getContainer().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupNavigation$lambda$1$1(Winter2025BattlePassScreen.this, view);
            }
        });
        WinterBattlepassLayoutBinding winterBattlepassLayoutBinding = this.battlePassBinding;
        winterBattlepassLayoutBinding.rouletteNavMenuButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupNavigation$lambda$2$0(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassLayoutBinding.donateNavMenuButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupNavigation$lambda$2$1(Winter2025BattlePassScreen.this, view);
            }
        });
        if (this.supportsBattlePassCurrency) {
            winterBattlepassLayoutBinding.buttonBuyBattlePoints.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Winter2025BattlePassScreen.setupNavigation$lambda$2$2(Winter2025BattlePassScreen.this, view);
                }
            });
        } else {
            winterBattlepassLayoutBinding.buttonBuyBattlePoints.setOnClickListener(null);
        }
        WinterBattlepassRouletteLayoutBinding winterBattlepassRouletteLayoutBinding = this.battlePassBinding.battlepassRoulettePage;
        winterBattlepassRouletteLayoutBinding.premText.setColorList(CollectionsKt.listOf((Object[]) new String[]{colorHex(R.color.winter_bp_roulette_premium_text_start), colorHex(R.color.winter_bp_roulette_premium_text_end)}));
        if (UtilsKt.isArizonaType()) {
            winterBattlepassRouletteLayoutBinding.usualTitle1.setVisibility(0);
            winterBattlepassRouletteLayoutBinding.usualTitle.setText("Гетто");
            winterBattlepassRouletteLayoutBinding.usualTitle2.setVisibility(8);
        } else {
            winterBattlepassRouletteLayoutBinding.usualTitle1.setVisibility(8);
            winterBattlepassRouletteLayoutBinding.usualTitle.setText("Уличная");
            winterBattlepassRouletteLayoutBinding.usualTitle2.setVisibility(0);
        }
        this.battlePassBinding.overlay.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupNavigation$lambda$4(Winter2025BattlePassScreen.this, view);
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
        winter2025BattlePassScreen.openPageFromUser(NavItems.TASKS_PAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$3(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, 2, 11, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$1$0(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.openPageFromUser(NavItems.LEVEL_SETS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$1$1(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.clickButtonMenuNavigation(NavItems.BUY_PREMIUM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$2$0(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.clickButtonMenuNavigation(NavItems.ROULETTE_PAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$2$1(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.clickButtonMenuNavigation(NavItems.DONATE_PAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$2$2(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.clickButtonMenuNavigation(NavItems.CONVERT_BATTLE_COINS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void setupNavigation$lambda$4(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.battlePassBinding.overlay.setVisibility(8);
        winter2025BattlePassScreen.battlePassBinding.cardInfo.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openAzCoinsPurchase() {
        if (UtilsKt.isArizonaType()) {
            SAMPUIElement.notifyClick$default(this, 0, 30, null, 4, null);
        } else {
            StringKt.openLink(this.azCoinsLink, getTargetActivity());
        }
    }

    private final void openPageFromUser(NavItems navItems) {
        BattlePassOpenPage battlePassOpenPage;
        clickButtonMenuNavigation(navItems);
        if (UtilsKt.isArizonaType()) {
            int i = WhenMappings.$EnumSwitchMapping$2[navItems.ordinal()];
            if (i == 1) {
                battlePassOpenPage = BattlePassOpenPage.Tasks;
            } else if (i != 2) {
                return;
            } else {
                battlePassOpenPage = BattlePassOpenPage.Levels;
            }
            notifyClick(0, 33, battlePassOpenPage.getPayload());
        }
    }

    private final void clickButtonMenuNavigation(NavItems navItems) {
        if (navItems != NavItems.CONVERT_BATTLE_COINS || this.supportsBattlePassCurrency) {
            this.currentNavItem = navItems;
            hideAllPages();
            resetNavigationAlpha();
            switch (WhenMappings.$EnumSwitchMapping$2[navItems.ordinal()]) {
                case 1:
                    showTasksPage();
                    break;
                case 2:
                    showLevelSetsPage();
                    break;
                case 3:
                    showMainPage();
                    break;
                case 4:
                    SAMPUIElement.notifyClick$default(this, 2, 11, null, 4, null);
                    showRoulettePage();
                    break;
                case 5:
                    SAMPUIElement.notifyClick$default(this, 0, 9, null, 4, null);
                    break;
                case 6:
                    showBuyPremiumPage();
                    break;
                case 7:
                    showConvertBattleCoinsPage();
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (this.battlePassUi.getKeepMainNavigationSelectedOnSecondaryPages() && CollectionsKt.listOf((Object[]) new NavItems[]{NavItems.LEVEL_SETS, NavItems.BUY_PREMIUM, NavItems.CONVERT_BATTLE_COINS}).contains(navItems)) {
                applyNavigationState(this.battlePassUi.getNavigation().getMain(), true);
            }
            refreshChromeVisibility();
        }
    }

    private final void hideAllPages() {
        this.battlePassUi.setMainPageControlsVisible(false);
        this.battlePassUi.setTasksPageVisible(false);
        WinterBattlepassLayoutBinding winterBattlepassLayoutBinding = this.battlePassBinding;
        this.isRouletteOpen = false;
        winterBattlepassLayoutBinding.battlePassMainPageContainer.setVisibility(8);
        winterBattlepassLayoutBinding.battlepassRoulettePage.getRoot().setVisibility(8);
        winterBattlepassLayoutBinding.battlepassConvertBattlecoinsPage.getRoot().setVisibility(8);
        winterBattlepassLayoutBinding.battlepassLevelSetsPage.getRoot().setVisibility(8);
        winterBattlepassLayoutBinding.battlepassLevelSetsPageMaximum.getRoot().setVisibility(8);
        winterBattlepassLayoutBinding.battlepassLevelPremiumPage.getRoot().setVisibility(8);
        winterBattlepassLayoutBinding.battlepassRouletteView.getRoot().setVisibility(8);
        winterBattlepassLayoutBinding.logo.setVisibility(8);
    }

    private final void resetNavigationAlpha() {
        BattlePassNavigationViews navigation = this.battlePassUi.getNavigation();
        applyNavigationState(navigation.getMain(), false);
        applyNavigationState(navigation.getTasks(), false);
        applyNavigationState(navigation.getCases(), false);
        WinterBattlepassLayoutBinding winterBattlepassLayoutBinding = this.battlePassBinding;
        winterBattlepassLayoutBinding.rouletteNavMenuButton.setAlpha(0.5f);
        winterBattlepassLayoutBinding.shopNavMenuButton.setAlpha(0.5f);
        winterBattlepassLayoutBinding.donateNavMenuButton.setAlpha(0.5f);
        winterBattlepassLayoutBinding.infoNavMenuButton.setAlpha(0.5f);
    }

    private final void applyNavigationState(BattlePassNavigationItemViews battlePassNavigationItemViews, boolean z) {
        this.battlePassUi.applyNavigationState(battlePassNavigationItemViews.getContainer(), battlePassNavigationItemViews.getText(), battlePassNavigationItemViews.getIcon(), z, this.navigationActiveTextColor, this.navigationInactiveTextColor, this.navigationSelectedBackgroundColor);
    }

    private final void refreshChromeVisibility() {
        boolean z;
        ConstraintLayout root = this.battlePassBinding.winterBattlepassWelcome.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        boolean z2 = false;
        if (root.getVisibility() != 0) {
            FrameLayout root2 = this.battlePassBinding.seasonEnded.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
            if (root2.getVisibility() != 0) {
                z = false;
                this.battlePassUi.setChromeVisible(!z);
                BattlePassUi battlePassUi = this.battlePassUi;
                if (!z && this.currentNavItem == NavItems.MAIN_PAGE) {
                    z2 = true;
                }
                battlePassUi.setMainPageControlsVisible(z2);
            }
        }
        z = true;
        this.battlePassUi.setChromeVisible(!z);
        BattlePassUi battlePassUi2 = this.battlePassUi;
        if (!z) {
            z2 = true;
        }
        battlePassUi2.setMainPageControlsVisible(z2);
    }

    private final void showMainPage() {
        applyNavigationState(this.battlePassUi.getNavigation().getMain(), true);
        WinterBattlepassLayoutBinding winterBattlepassLayoutBinding = this.battlePassBinding;
        winterBattlepassLayoutBinding.battlePassMainPageContainer.setVisibility(0);
        winterBattlepassLayoutBinding.battlepassContainerBg.setImageResource(this.visualSkin.getMainBackground());
        updateLogo();
        winterBattlepassLayoutBinding.logo.setVisibility(0);
    }

    private final void showTasksPage() {
        applyNavigationState(this.battlePassUi.getNavigation().getTasks(), true);
        this.battlePassUi.setTasksPageVisible(true);
        WinterBattlepassLayoutBinding winterBattlepassLayoutBinding = this.battlePassBinding;
        selectTaskCategory$default(this, CategoryType.DAILY, null, 2, null);
        winterBattlepassLayoutBinding.battlepassContainerBg.setImageResource(this.visualSkin.getTasksBackground());
        winterBattlepassLayoutBinding.logo.setVisibility(8);
        this.isRouletteOpen = true;
    }

    private final void showRoulettePage() {
        WinterBattlepassLayoutBinding winterBattlepassLayoutBinding = this.battlePassBinding;
        winterBattlepassLayoutBinding.rouletteNavMenuButton.setAlpha(1.0f);
        winterBattlepassLayoutBinding.battlepassRoulettePage.getRoot().setVisibility(0);
        winterBattlepassLayoutBinding.battlepassContainerBg.setImageResource(R.drawable.battlepass_2025_winter_bg_glass);
        this.isRouletteOpen = true;
    }

    private final void showLevelSetsPage() {
        WinterBattlepassLayoutBinding winterBattlepassLayoutBinding = this.battlePassBinding;
        MainBattlePassInfo mainBattlePassInfo = this.battlePassInfo;
        if ((mainBattlePassInfo != null ? mainBattlePassInfo.getLevel() : 0) >= 100) {
            winterBattlepassLayoutBinding.battlepassLevelSetsPageMaximum.getRoot().setVisibility(0);
            winterBattlepassLayoutBinding.battlepassLevelSetsPageMaximum.buttonReturn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda37
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Winter2025BattlePassScreen.showLevelSetsPage$lambda$0$0(Winter2025BattlePassScreen.this, view);
                }
            });
            winterBattlepassLayoutBinding.battlepassContainerBg.setImageResource(this.visualSkin.getTasksBackground());
            return;
        }
        if (!this.purchaseController.isLevelPageLocked()) {
            winterBattlepassLayoutBinding.battlepassLevelSetsPage.getRoot().setVisibility(0);
        }
        winterBattlepassLayoutBinding.battlepassContainerBg.setImageResource(this.visualSkin.getMainBackground());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLevelSetsPage$lambda$0$0(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.clickButtonMenuNavigation(NavItems.MAIN_PAGE);
    }

    private final void showBuyPremiumPage() {
        WinterBattlepassLayoutBinding winterBattlepassLayoutBinding = this.battlePassBinding;
        if (!this.purchaseController.isPremiumPageLocked()) {
            winterBattlepassLayoutBinding.battlepassLevelPremiumPage.getRoot().setVisibility(0);
        }
        winterBattlepassLayoutBinding.battlepassContainerBg.setImageResource(this.visualSkin.getMainBackground());
    }

    private final void showConvertBattleCoinsPage() {
        if (this.supportsBattlePassCurrency) {
            WinterBattlepassLayoutBinding winterBattlepassLayoutBinding = this.battlePassBinding;
            winterBattlepassLayoutBinding.battlepassConvertBattlecoinsPage.getRoot().setVisibility(0);
            winterBattlepassLayoutBinding.battlepassContainerBg.setImageResource(this.visualSkin.getMainBackground());
        }
    }

    private final void setupCommonTasksInfo() {
        View container;
        View container2;
        View container3;
        BattlePassTasksPageViews tasksPage = this.battlePassUi.getTasksPage();
        tasksPage.getCommonTaskList().setAdapter(this.commonTasksAdapter);
        BattlePassTaskCategoryViews battlePassTaskCategoryViews = tasksPage.getCategories().get(CategoryType.DAILY);
        if (battlePassTaskCategoryViews != null && (container3 = battlePassTaskCategoryViews.getContainer()) != null) {
            container3.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda28
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Winter2025BattlePassScreen.setupCommonTasksInfo$lambda$0$0(Winter2025BattlePassScreen.this, view);
                }
            });
        }
        if (!UtilsKt.isArizonaType()) {
            BattlePassTaskCategoryViews battlePassTaskCategoryViews2 = tasksPage.getCategories().get(CategoryType.PREMIUM);
            if (battlePassTaskCategoryViews2 != null && (container2 = battlePassTaskCategoryViews2.getContainer()) != null) {
                container2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda29
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Winter2025BattlePassScreen.setupCommonTasksInfo$lambda$0$1(Winter2025BattlePassScreen.this, view);
                    }
                });
            }
        } else {
            BattlePassTaskCategoryViews battlePassTaskCategoryViews3 = tasksPage.getCategories().get(CategoryType.PREMIUM);
            if (battlePassTaskCategoryViews3 != null && (container = battlePassTaskCategoryViews3.getContainer()) != null) {
                container.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda30
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Winter2025BattlePassScreen.setupCommonTasksInfo$lambda$0$2(Winter2025BattlePassScreen.this, view);
                    }
                });
            }
        }
        tasksPage.getBuyLevelsButton().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda31
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupCommonTasksInfo$lambda$0$3(Winter2025BattlePassScreen.this, view);
            }
        });
        tasksPage.getBuyPremiumButton().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda32
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupCommonTasksInfo$lambda$0$4(Winter2025BattlePassScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCommonTasksInfo$lambda$0$0(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        selectTaskCategory$default(winter2025BattlePassScreen, CategoryType.DAILY, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCommonTasksInfo$lambda$0$1(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        selectTaskCategory$default(winter2025BattlePassScreen, CategoryType.PREMIUM, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCommonTasksInfo$lambda$0$2(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, 0, 25, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCommonTasksInfo$lambda$0$3(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.openPageFromUser(NavItems.LEVEL_SETS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCommonTasksInfo$lambda$0$4(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winter2025BattlePassScreen.clickButtonMenuNavigation(NavItems.BUY_PREMIUM);
    }

    static /* synthetic */ void selectTaskCategory$default(Winter2025BattlePassScreen winter2025BattlePassScreen, CategoryType categoryType, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        winter2025BattlePassScreen.selectTaskCategory(categoryType, num);
    }

    private final void selectTaskCategory(CategoryType categoryType, Integer num) {
        if (UtilsKt.isArizonaType()) {
            categoryType = CategoryType.DAILY;
        }
        updateTaskCategoryTheme(categoryType);
        filterListForSelectedTask(categoryType, num);
        CommonTaskInfo selectedTask = this.commonTasksAdapter.selectedTask();
        if (selectedTask == null) {
            selectedTask = (CommonTaskInfo) CollectionsKt.firstOrNull((List<? extends Object>) this.commonTasksAdapter.getCurrentTasksList());
        }
        if (selectedTask != null) {
            showSelectedTask(selectedTask, categoryType);
            return;
        }
        this.battlePassUi.getTasksPage().getCurrentTaskContainer().setVisibility(8);
        this.rewardsTasksAdapter.setRewards(CollectionsKt.emptyList());
    }

    private final void openBackendRequestedPage(String str) {
        NavItems navItems;
        BattlePassOpenPage fromPayload = BattlePassOpenPage.Companion.fromPayload(str);
        int i = fromPayload == null ? -1 : WhenMappings.$EnumSwitchMapping$3[fromPayload.ordinal()];
        if (i != -1) {
            if (i == 1) {
                navItems = NavItems.LEVEL_SETS;
            } else if (i != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                navItems = NavItems.TASKS_PAGE;
            }
            if (!isOnScreen()) {
                setVisibility(true);
                bringToFront();
            }
            clickButtonMenuNavigation(navItems);
        }
    }

    static /* synthetic */ void filterListForSelectedTask$default(Winter2025BattlePassScreen winter2025BattlePassScreen, CategoryType categoryType, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        winter2025BattlePassScreen.filterListForSelectedTask(categoryType, num);
    }

    private final void filterListForSelectedTask(CategoryType categoryType, Integer num) {
        Object obj;
        if (UtilsKt.isArizonaType()) {
            if (this.arizonaMissionsState.isLoading() || this.arizonaMissionsState.isAwaitingProgressSnapshot()) {
                applyTasksListVisibility(false, true);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : this.commonTasksAdapter.getAllTasksList()) {
                if (((CommonTaskInfo) obj2).isVisible()) {
                    arrayList.add(obj2);
                }
            }
            applyTasksListVisibility$default(this, arrayList.isEmpty(), false, 2, null);
            this.commonTasksAdapter.filterList(CategoryType.DAILY, true, num);
            return;
        }
        for (CommonTaskInfo commonTaskInfo : this.commonTasksAdapter.getAllTasksList()) {
            Iterator<T> it = (categoryType == CategoryType.DAILY ? this._usualTasks : this._premTasks).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
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
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : this.commonTasksAdapter.getAllTasksList()) {
            CommonTaskInfo commonTaskInfo2 = (CommonTaskInfo) obj3;
            if (commonTaskInfo2.getCategoryType() == categoryType.getValue() && commonTaskInfo2.isVisible()) {
                arrayList2.add(obj3);
            }
        }
        applyTasksListVisibility$default(this, arrayList2.isEmpty(), false, 2, null);
        CommonTasksAdapter.filterList$default(this.commonTasksAdapter, categoryType, false, null, 6, null);
    }

    static /* synthetic */ void applyTasksListVisibility$default(Winter2025BattlePassScreen winter2025BattlePassScreen, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        winter2025BattlePassScreen.applyTasksListVisibility(z, z2);
    }

    private final void applyTasksListVisibility(boolean z, boolean z2) {
        BattlePassTasksPageViews tasksPage = this.battlePassUi.getTasksPage();
        tasksPage.getLoadingState().setVisibility(z2 ? 0 : 8);
        if (z2) {
            tasksPage.getEmptyState().setVisibility(8);
            tasksPage.getCurrentTaskContainer().setVisibility(8);
            tasksPage.getCommonTaskList().setVisibility(8);
        } else if (z) {
            tasksPage.getEmptyState().setVisibility(0);
            tasksPage.getCurrentTaskContainer().setVisibility(8);
            tasksPage.getCommonTaskList().setVisibility(8);
        } else {
            tasksPage.getEmptyState().setVisibility(8);
            tasksPage.getCommonTaskList().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showTasksEmptySafeState() {
        this.commonTasksAdapter.clearAllTasksList();
        this.rewardsTasksAdapter.setRewards(CollectionsKt.emptyList());
        applyTasksListVisibility$default(this, true, false, 2, null);
    }

    private final void showTasksLoadingState() {
        this.commonTasksAdapter.clearAllTasksList();
        this.rewardsTasksAdapter.setRewards(CollectionsKt.emptyList());
        applyTasksListVisibility(false, true);
    }

    private final void updateTaskCategoryTheme(CategoryType categoryType) {
        this.battlePassUi.applyTaskCategoryState(categoryType, this.colorText, this.navigationInactiveTextColor);
    }

    private final void updateMainPageInfo(MainBattlePassInfo mainBattlePassInfo) {
        String taskPageTimeConvert;
        this.battlePassInfo = mainBattlePassInfo;
        this.battlePassUi.bindCompletedLevel(mainBattlePassInfo.getCompleted());
        this.battlePassUi.getNavigation().getCurrencyText().setText(this.battlePassUi.formatAzCoins(mainBattlePassInfo.getAzCoins()));
        this.battlePassUi.getMainPage().getRemainingTimeText().setText(TimeConverterKt.mainPageTimeConvert(mainBattlePassInfo.getTimestampTaskTime()));
        BattlePassTasksPageViews tasksPage = this.battlePassUi.getTasksPage();
        TextView resetTimeText = tasksPage.getResetTimeText();
        if (UtilsKt.isArizonaType()) {
            ArizonaTaskResetTime remaining$default = ArizonaTaskResetTimer.remaining$default(ArizonaTaskResetTimer.INSTANCE, mainBattlePassInfo.getTimestampMissionTime(), 0L, 2, null);
            taskPageTimeConvert = tasksPage.getResetTimeText().getContext().getString(R.string.battlepass_tasks_reset_time, Long.valueOf(remaining$default.getHours()), Long.valueOf(remaining$default.getMinutes()));
        } else {
            taskPageTimeConvert = TimeConverterKt.taskPageTimeConvert(mainBattlePassInfo.getTimestampMissionTime());
        }
        resetTimeText.setText(taskPageTimeConvert);
        tasksPage.getRemainingTimeText().setText(TimeConverterKt.mainPageTimeConvert(mainBattlePassInfo.getTimestampTaskTime()));
        this.battlePassBinding.textBuyBattlePoints.setText(String.valueOf(mainBattlePassInfo.getPassCoins()));
        if (this.supportsBattlePassCurrency && mainBattlePassInfo.getPassCoinCurseAzCoins() > 0) {
            WinterBattlepassConvertBattlecoinsLayoutBinding winterBattlepassConvertBattlecoinsLayoutBinding = this.battlePassBinding.battlepassConvertBattlecoinsPage;
            winterBattlepassConvertBattlecoinsLayoutBinding.battlepointsCurseInfoText.setText(mainBattlePassInfo.getPassCoinCurseAzCoins() + " AZ = 1 ");
            winterBattlepassConvertBattlecoinsLayoutBinding.battlepointsAmountText.setText(String.valueOf(this.startBattleCoinNumbCurse / mainBattlePassInfo.getPassCoinCurseAzCoins()));
            winterBattlepassConvertBattlecoinsLayoutBinding.coinsConvertNumbText.setText(String.valueOf(this.startBattleCoinNumbCurse));
        }
        updateLogo();
        updateLevelInfoOnPages();
        this.purchaseController.updatePremiumButtonsVisibility(mainBattlePassInfo.getPremium());
        this.purchaseController.setupBuyPremiumPage(mainBattlePassInfo);
        updateBpAwards(mainBattlePassInfo.getAvailableToReceive());
        if (UtilsKt.isArizonaType()) {
            if (this.arizonaMissionEpochTracker.shouldBeginProgressSnapshot(mainBattlePassInfo.getTimestampMissionTime(), ArizonaMissionTableKeys.INSTANCE.clampPremiumTier(mainBattlePassInfo.getPremium()))) {
                this.arizonaMissionsState.beginProgressSnapshot();
                this._usualTasks = CollectionsKt.emptyList();
                this._premTasks = CollectionsKt.emptyList();
                showTasksLoadingState();
            }
            ensureArizonaMissionsForPremium(mainBattlePassInfo.getPremium());
        }
        if (!this.isRouletteOpen) {
            clickButtonMenuNavigation(NavItems.MAIN_PAGE);
        }
        this.purchaseController.updateLevelSetButtonsAvailability(mainBattlePassInfo.getLevel());
    }

    private final void updateLevelInfoOnPages() {
        MainBattlePassInfo mainBattlePassInfo = this.battlePassInfo;
        if (mainBattlePassInfo == null) {
            return;
        }
        BattlePassMainPageViews mainPage = this.battlePassUi.getMainPage();
        mainPage.getLevelText().setText(String.valueOf(mainBattlePassInfo.getLevel()));
        mainPage.getExperienceText().setText(this.battlePassUi.formatExperience(mainBattlePassInfo.getExp(), mainBattlePassInfo.getMaxExp()));
        mainPage.getExperienceProgress().setMax(20);
        mainPage.getExperienceProgress().setProgress((mainBattlePassInfo.getExp() - mainBattlePassInfo.getMaxExp()) + 20);
        BattlePassTasksPageViews tasksPage = this.battlePassUi.getTasksPage();
        tasksPage.getLevelText().setText(String.valueOf(mainBattlePassInfo.getLevel()));
        tasksPage.getExperienceText().setText(this.battlePassUi.formatExperience(mainBattlePassInfo.getExp(), mainBattlePassInfo.getMaxExp()));
        tasksPage.getExperienceProgress().setMax(mainBattlePassInfo.getMaxExp());
        tasksPage.getExperienceProgress().setProgress(mainBattlePassInfo.getExp());
        WinterBattlepassLevelSetsLayoutBinding winterBattlepassLevelSetsLayoutBinding = this.battlePassBinding.battlepassLevelSetsPage;
    }

    private final void setPremiumTaskLockVisible(boolean z) {
        this.battlePassUi.getTasksPage().getPremiumLockContainer().setVisibility(z ? 0 : 8);
        if (z) {
            showPremiumTaskLockFallback();
        }
    }

    private final void showPremiumTaskLockFallback() {
        BattlePassTasksPageViews tasksPage = this.battlePassUi.getTasksPage();
        CustomCardView.setBackground$default(tasksPage.getPremiumLockContainer(), this.premiumTaskLockBgStartColor, this.premiumTaskLockBgEndColor, Integer.valueOf(this.premiumTaskLockGradientAngle), null, 8, null);
        tasksPage.getPremiumLockContainer().setBackgroundAlpha(100);
    }

    private final boolean updatePremiumTaskLock(CategoryType categoryType) {
        MainBattlePassInfo mainBattlePassInfo;
        boolean z = (categoryType != CategoryType.PREMIUM || (mainBattlePassInfo = this.battlePassInfo) == null || mainBattlePassInfo.isPremium()) ? false : true;
        setPremiumTaskLockVisible(z);
        return z;
    }

    private final void showSelectedTask(final CommonTaskInfo commonTaskInfo, final CategoryType categoryType) {
        BattlePassTasksPageViews tasksPage = this.battlePassUi.getTasksPage();
        tasksPage.getTitleText().setText(commonTaskInfo.getTitle());
        tasksPage.getDescriptionText().setText(commonTaskInfo.getHint());
        tasksPage.getProgressCountText().setText(commonTaskInfo.validCurrentProgress() + "/" + commonTaskInfo.getTotalProgress());
        tasksPage.getProgressPercentText().setText((commonTaskInfo.getTotalProgress() > 0 ? (int) ((commonTaskInfo.validCurrentProgress() / commonTaskInfo.getTotalProgress()) * 100.0f) : 0) + "%");
        if (commonTaskInfo.validCurrentProgress() == commonTaskInfo.getTotalProgress()) {
            tasksPage.getProgressDoneContainer().setVisibility(0);
            tasksPage.getProgressPercentText().setVisibility(8);
        } else {
            tasksPage.getProgressDoneContainer().setVisibility(8);
            tasksPage.getProgressPercentText().setVisibility(0);
        }
        tasksPage.getProgressBar().setMax(commonTaskInfo.getTotalProgress());
        tasksPage.getProgressBar().setProgress(commonTaskInfo.getCurrentProgress());
        this.rewardsTasksAdapter.setRewards(commonTaskInfo.getRewards());
        if (commonTaskInfo.getCurrentProgress() == commonTaskInfo.getTotalProgress()) {
            tasksPage.getProgressBar().setProgressTintList(ColorStateList.valueOf(this.colorMaxProgress));
            tasksPage.getProgressCountText().setTextColor(this.colorMaxProgress);
        } else {
            tasksPage.getProgressBar().setProgressTintList(ColorStateList.valueOf(this.taskProgressColor));
            tasksPage.getProgressCountText().setTextColor(getTaskProgressTextColor());
        }
        if (UtilsKt.isArizonaType()) {
            String buttonNameInfo = commonTaskInfo.getButtonNameInfo();
            String obj = buttonNameInfo != null ? StringsKt.trim((CharSequence) buttonNameInfo).toString() : null;
            if (obj == null) {
                obj = "";
            }
            String str = obj;
            tasksPage.getClaimButton().setVisibility(str.length() > 0 ? 0 : 8);
            tasksPage.getClaimButtonText().setText(str);
            tasksPage.getClaimButton().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda26
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Winter2025BattlePassScreen.showSelectedTask$lambda$0$0(Winter2025BattlePassScreen.this, commonTaskInfo, view);
                }
            });
        } else {
            tasksPage.getClaimButton().setVisibility(0);
            tasksPage.getClaimButton().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda27
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Winter2025BattlePassScreen.showSelectedTask$lambda$0$1(Winter2025BattlePassScreen.this, categoryType, commonTaskInfo, view);
                }
            });
        }
        if (updatePremiumTaskLock(categoryType)) {
            tasksPage.getClaimButton().setOnClickListener(null);
        }
        tasksPage.getCurrentTaskContainer().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSelectedTask$lambda$0$0(Winter2025BattlePassScreen winter2025BattlePassScreen, CommonTaskInfo commonTaskInfo, View view) {
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, commonTaskInfo.getId(), 31, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSelectedTask$lambda$0$1(Winter2025BattlePassScreen winter2025BattlePassScreen, CategoryType categoryType, CommonTaskInfo commonTaskInfo, View view) {
        winter2025BattlePassScreen.notifyClick(1, -1, StringKt.toStringJson(new RewardGetRequest(categoryType.getValue(), commonTaskInfo.getId())));
    }

    private final void showTaskInfo(CommonTaskInfo commonTaskInfo, int i) {
        CategoryType fromCategoryId;
        if (UtilsKt.isArizonaType()) {
            fromCategoryId = CategoryType.DAILY;
        } else {
            fromCategoryId = CategoryType.Companion.fromCategoryId(commonTaskInfo.getCategoryType());
        }
        this.commonTasksAdapter.selectTask(i);
        showSelectedTask(commonTaskInfo, fromCategoryId);
    }

    private final void updateCoins(BattlePassUpdateCoinsData battlePassUpdateCoinsData) {
        if (this.supportsBattlePassCurrency) {
            this.battlePassBinding.textBuyBattlePoints.setText(String.valueOf(battlePassUpdateCoinsData.getPassCoins()));
            MainBattlePassInfo mainBattlePassInfo = this.battlePassInfo;
            if (mainBattlePassInfo != null) {
                mainBattlePassInfo.setPassCoins(battlePassUpdateCoinsData.getPassCoins());
            }
        }
        this.battlePassUi.getNavigation().getCurrencyText().setText(this.battlePassUi.formatAzCoins(battlePassUpdateCoinsData.getAzCoins()));
        MainBattlePassInfo mainBattlePassInfo2 = this.battlePassInfo;
        if (mainBattlePassInfo2 != null) {
            mainBattlePassInfo2.setAzCoins(battlePassUpdateCoinsData.getAzCoins());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCommonTaskItems(List<CommonTaskInfo> list) {
        this.commonTasksAdapter.addAllTasks(list);
    }

    private final void updateTasks(List<ActualTask> list) {
        if (UtilsKt.isArizonaType()) {
            updateArizonaTasksProgress(list);
            return;
        }
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

    private final void updateArizonaTasksProgress(List<ActualTask> list) {
        this.arizonaMissionsState.replaceProgress(list);
        this._usualTasks = this.arizonaMissionsState.getProgress();
        this._premTasks = CollectionsKt.emptyList();
        MainBattlePassInfo mainBattlePassInfo = this.battlePassInfo;
        Integer valueOf = mainBattlePassInfo != null ? Integer.valueOf(mainBattlePassInfo.getPremium()) : null;
        if (valueOf != null) {
            ensureArizonaMissionsForPremium(valueOf.intValue());
        }
        if (this.arizonaMissionsState.getHasTable()) {
            publishArizonaMissionsToUi(true);
        }
    }

    private final void ensureArizonaMissionsForPremium(int i) {
        int clampPremiumTier = ArizonaMissionTableKeys.INSTANCE.clampPremiumTier(i);
        boolean needsLoad = this.arizonaMissionsState.needsLoad(clampPremiumTier);
        ArizonaMissionsState arizonaMissionsState = this.arizonaMissionsState;
        if (!needsLoad) {
            if (arizonaMissionsState.getHasTable() && this.commonTasksAdapter.getAllTasksList().isEmpty()) {
                publishArizonaMissionsToUi$default(this, false, 1, null);
                return;
            }
            return;
        }
        if (arizonaMissionsState.shouldClearVisibleForTier(clampPremiumTier)) {
            this._taskUsualData = CollectionsKt.emptyList();
            this._taskPremData = CollectionsKt.emptyList();
        }
        showTasksLoadingState();
        loadArizonaMissionTable(clampPremiumTier);
    }

    private final void loadArizonaMissionTable(int i) {
        BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), Dispatchers.getIO(), null, new Winter2025BattlePassScreen$loadArizonaMissionTable$1(this, this.arizonaMissionsState.beginTierLoad(i), ArizonaMissionTableKeys.INSTANCE.tableKeyForPremium(i), null), 2, null);
    }

    static /* synthetic */ void publishArizonaMissionsToUi$default(Winter2025BattlePassScreen winter2025BattlePassScreen, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        winter2025BattlePassScreen.publishArizonaMissionsToUi(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void publishArizonaMissionsToUi(boolean z) {
        if (this.arizonaMissionsState.isAwaitingProgressSnapshot()) {
            showTasksLoadingState();
            return;
        }
        Integer selectedTaskId = this.commonTasksAdapter.selectedTaskId();
        if (!z) {
            selectedTaskId = null;
        }
        List<CommonTaskInfo> applyProgressToMissions = this.arizonaMissionsState.applyProgressToMissions();
        if (applyProgressToMissions.isEmpty()) {
            showTasksEmptySafeState();
            return;
        }
        updateCommonTaskItems(applyProgressToMissions);
        if (this.currentNavItem == NavItems.TASKS_PAGE) {
            selectTaskCategory(CategoryType.DAILY, selectedTaskId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLevelItems(List<Pair<AwardItemData, AwardItemData>> list) {
        List<Pair<AwardItemData, AwardItemData>> list2;
        boolean z;
        MainBattlePassInfo mainBattlePassInfo = this.battlePassInfo;
        int exp = mainBattlePassInfo != null ? (mainBattlePassInfo.getExp() - mainBattlePassInfo.getMaxExp()) + 20 : 0;
        LevelItemsAdapter levelItemsAdapter = this.levelItemsAdapter;
        int level = mainBattlePassInfo != null ? mainBattlePassInfo.getLevel() : 0;
        boolean isArizonaType = UtilsKt.isArizonaType();
        if (mainBattlePassInfo == null || !mainBattlePassInfo.isPremium()) {
            list2 = list;
            z = false;
        } else {
            list2 = list;
            z = true;
        }
        levelItemsAdapter.setData(list2, level, exp, isArizonaType, z);
    }

    private final void updateLogo() {
        int logo;
        MainBattlePassInfo mainBattlePassInfo = this.battlePassInfo;
        int premium = mainBattlePassInfo != null ? mainBattlePassInfo.getPremium() : -1;
        if (premium == 0) {
            logo = this.visualSkin.getLogo();
        } else if (premium == 1) {
            logo = this.visualSkin.getPremiumLogo();
        } else {
            BattlePassVisualSkin battlePassVisualSkin = this.visualSkin;
            if (premium == 2) {
                logo = battlePassVisualSkin.getPremiumPlusLogo();
            } else {
                logo = battlePassVisualSkin.getLogo();
            }
        }
        this.battlePassBinding.logo.setImageResource(logo);
        this.battlePassBinding.battlepassLevelSetsPageMaximum.logo.setImageResource(logo);
    }

    private final void onClaimItem(boolean z, int i) {
        notifyClick(0, 3, i + ", " + (z ? 1 : 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestRewardDescription(View view, int i, boolean z) {
        PopupWindow popupWindow = this.premiumRewardDescriptionPopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.premiumRewardDescriptionPopup = null;
        this.pendingPremiumRewardDescription = TuplesKt.to(view, Integer.valueOf(i));
        notifyClick((UtilsKt.isArizonaType() && z) ? 1 : 0, 26, String.valueOf(i));
    }

    private final void showPremiumRewardDescription(String str) {
        Pair<? extends View, Integer> pair = this.pendingPremiumRewardDescription;
        if (pair == null) {
            return;
        }
        View component1 = pair.component1();
        int intValue = pair.component2().intValue();
        this.pendingPremiumRewardDescription = null;
        String str2 = str;
        if (!StringsKt.isBlank(str2) && component1.isAttachedToWindow() && Intrinsics.areEqual(component1.getTag(), Integer.valueOf(intValue))) {
            WinterBattlepassRewardDescriptionPopupBinding inflate = WinterBattlepassRewardDescriptionPopupBinding.inflate(LayoutInflater.from(this.visualContext));
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            CustomCardView root = inflate.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            inflate.rewardDescriptionText.setText(str2);
            root.measure(View.MeasureSpec.makeMeasureSpec(this.visualContext.getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
            final PopupWindow popupWindow = new PopupWindow((View) root, -2, -2, true);
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            popupWindow.setOutsideTouchable(true);
            popupWindow.setElevation(this.visualContext.getResources().getDimension(ru.mrlargha.commonui.R.dimen._2sdp));
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda41
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    Winter2025BattlePassScreen.showPremiumRewardDescription$lambda$1(Winter2025BattlePassScreen.this, popupWindow);
                }
            });
            root.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda42
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    popupWindow.dismiss();
                }
            });
            this.premiumRewardDescriptionPopup = popupWindow;
            popupWindow.showAsDropDown(component1, (component1.getWidth() - root.getMeasuredWidth()) / 2, -(component1.getHeight() + root.getMeasuredHeight() + this.visualContext.getResources().getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._2sdp)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showPremiumRewardDescription$lambda$1(Winter2025BattlePassScreen winter2025BattlePassScreen, PopupWindow popupWindow) {
        if (winter2025BattlePassScreen.premiumRewardDescriptionPopup == popupWindow) {
            winter2025BattlePassScreen.premiumRewardDescriptionPopup = null;
        }
    }

    private final void dismissPremiumRewardDescription() {
        this.pendingPremiumRewardDescription = null;
        PopupWindow popupWindow = this.premiumRewardDescriptionPopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.premiumRewardDescriptionPopup = null;
    }

    private final void onQuality() {
        this.battlePassBinding.textBonus.setText("Качество будет определено при открытии сертификата.\nВы можете получить:\n- Хлам\n- Обычное\n- Идеальное");
        this.battlePassBinding.overlay.setVisibility(0);
        this.battlePassBinding.cardInfo.setVisibility(0);
    }

    private final void setWelcomeScreen() {
        final WinterBattlepassWelcomeLayoutBinding winterBattlepassWelcomeLayoutBinding = this.battlePassBinding.winterBattlepassWelcome;
        winterBattlepassWelcomeLayoutBinding.battlepassWelcomeContainerBg.setImageResource(this.visualSkin.getWelcomeBackground());
        winterBattlepassWelcomeLayoutBinding.logoWelcome.setImageResource(this.visualSkin.getWelcomeLogo());
        winterBattlepassWelcomeLayoutBinding.getRoot().setVisibility(0);
        refreshChromeVisibility();
        winterBattlepassWelcomeLayoutBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setWelcomeScreen$lambda$0$0(view);
            }
        });
        winterBattlepassWelcomeLayoutBinding.backWelcomeButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setWelcomeScreen$lambda$0$1(WinterBattlepassWelcomeLayoutBinding.this, this, view);
            }
        });
        winterBattlepassWelcomeLayoutBinding.btnGetInfoWinterWelcome.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setWelcomeScreen$lambda$0$2(Winter2025BattlePassScreen.this, winterBattlepassWelcomeLayoutBinding, view);
            }
        });
        winterBattlepassWelcomeLayoutBinding.welcomePrice1.timerContainer.setVisibility(8);
        winterBattlepassWelcomeLayoutBinding.welcomePrice2.timerContainer.setVisibility(8);
        winterBattlepassWelcomeLayoutBinding.welcomePrice3.timerContainer.setVisibility(8);
        if (this.visualSkin == BattlePassVisualSkin.PINK_CODEX) {
            winterBattlepassWelcomeLayoutBinding.welcomePrice1.oldPriseTitle.setText(R.string.battlepass_welcome_reward_rodina_1);
            winterBattlepassWelcomeLayoutBinding.welcomePrice2.oldPriseTitle.setText(R.string.battlepass_welcome_reward_rodina_2);
            winterBattlepassWelcomeLayoutBinding.welcomePrice3.oldPriseTitle.setText(R.string.battlepass_welcome_reward_rodina_3);
        } else {
            winterBattlepassWelcomeLayoutBinding.welcomePrice1.oldPriseTitle.setText(R.string.battlepass_welcome_reward_arizona_1);
            winterBattlepassWelcomeLayoutBinding.welcomePrice2.oldPriseTitle.setText(R.string.battlepass_welcome_reward_arizona_2);
            winterBattlepassWelcomeLayoutBinding.welcomePrice3.oldPriseTitle.setText(R.string.battlepass_welcome_reward_arizona_3);
        }
        winterBattlepassWelcomeLayoutBinding.welcomePrice1.rarity.setBackgroundColor(ContextCompat.getColor(getTargetActivity(), R.color.winter_bp_rarity_pink));
        winterBattlepassWelcomeLayoutBinding.welcomePrice3.rarity.setBackgroundColor(ContextCompat.getColor(getTargetActivity(), R.color.winter_bp_rarity_gold));
        winterBattlepassWelcomeLayoutBinding.welcomePrice2.rarity.setBackgroundColor(ContextCompat.getColor(getTargetActivity(), R.color.winter_bp_rarity_red));
        winterBattlepassWelcomeLayoutBinding.welcomePrice1.bg.setBackgroundResource(ru.mrlargha.commonui.R.drawable.rarity_red);
        winterBattlepassWelcomeLayoutBinding.welcomePrice2.bg.setBackgroundResource(ru.mrlargha.commonui.R.drawable.rarity_gold);
        winterBattlepassWelcomeLayoutBinding.welcomePrice3.bg.setBackgroundResource(ru.mrlargha.commonui.R.drawable.rarity_pink);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new Winter2025BattlePassScreen$setWelcomeScreen$1$4(winterBattlepassWelcomeLayoutBinding, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setWelcomeScreen$lambda$0$1(WinterBattlepassWelcomeLayoutBinding winterBattlepassWelcomeLayoutBinding, Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winterBattlepassWelcomeLayoutBinding.getRoot().setVisibility(8);
        winter2025BattlePassScreen.setVisibility(false);
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, 0, 10, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setWelcomeScreen$lambda$0$2(Winter2025BattlePassScreen winter2025BattlePassScreen, WinterBattlepassWelcomeLayoutBinding winterBattlepassWelcomeLayoutBinding, View view) {
        if (UtilsKt.isArizonaType()) {
            SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, 0, 24, null, 4, null);
            return;
        }
        winterBattlepassWelcomeLayoutBinding.getRoot().setVisibility(8);
        winter2025BattlePassScreen.refreshChromeVisibility();
    }

    private final void showEventPreview(EventPreviewData eventPreviewData) {
        String obj;
        final WinterBattlepassWelcomeLayoutBinding winterBattlepassWelcomeLayoutBinding = this.battlePassBinding.winterBattlepassWelcome;
        winterBattlepassWelcomeLayoutBinding.getRoot().setVisibility(0);
        refreshChromeVisibility();
        winterBattlepassWelcomeLayoutBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.showEventPreview$lambda$0$0(view);
            }
        });
        winterBattlepassWelcomeLayoutBinding.backWelcomeButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda35
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.showEventPreview$lambda$0$1(WinterBattlepassWelcomeLayoutBinding.this, this, view);
            }
        });
        winterBattlepassWelcomeLayoutBinding.btnGetInfoWinterWelcome.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda36
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.showEventPreview$lambda$0$2(Winter2025BattlePassScreen.this, view);
            }
        });
        Integer colorOrNull = toColorOrNull(eventPreviewData.getMainColor());
        int intValue = colorOrNull != null ? colorOrNull.intValue() : ContextCompat.getColor(getTargetActivity(), R.color.winter_bp_action_yellow);
        winterBattlepassWelcomeLayoutBinding.welcomeTitle.setTextColorList(this.whiteColor, intValue);
        CustomTextView customTextView = winterBattlepassWelcomeLayoutBinding.welcomeTitle;
        String string = getTargetActivity().getString(R.string.battlepass_event_preview_description_arizona);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        customTextView.setFormattedText(string);
        winterBattlepassWelcomeLayoutBinding.welcomePremiumDescription.setTextColorList(this.whiteColor, intValue);
        CustomTextView customTextView2 = winterBattlepassWelcomeLayoutBinding.welcomePremiumDescription;
        String string2 = getTargetActivity().getString(R.string.battlepass_event_preview_rewards_caption_arizona);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        customTextView2.setFormattedText(string2);
        String buttonText = eventPreviewData.getButtonText();
        if (buttonText != null && (obj = StringsKt.trim((CharSequence) buttonText).toString()) != null) {
            if (obj.length() <= 0) {
                obj = null;
            }
            if (obj != null) {
                winterBattlepassWelcomeLayoutBinding.btnGetInfoWinterWelcome.setText(obj);
            }
        }
        Integer colorOrNull2 = toColorOrNull(eventPreviewData.getButtonColor());
        if (colorOrNull2 != null) {
            winterBattlepassWelcomeLayoutBinding.btnGetInfoWinterWelcome.setBackgroundTintList(ColorStateList.valueOf(colorOrNull2.intValue()));
        }
        ImageView battlepassWelcomeContainerBg = winterBattlepassWelcomeLayoutBinding.battlepassWelcomeContainerBg;
        Intrinsics.checkNotNullExpressionValue(battlepassWelcomeContainerBg, "battlepassWelcomeContainerBg");
        loadEventPreviewImage(battlepassWelcomeContainerBg, EVENT_PREVIEW_BACKGROUND_PATH, eventPreviewData.getBgImg(), this.visualSkin.getWelcomeBackground(), true);
        ImageView logoWelcome = winterBattlepassWelcomeLayoutBinding.logoWelcome;
        Intrinsics.checkNotNullExpressionValue(logoWelcome, "logoWelcome");
        loadEventPreviewImage$default(this, logoWelcome, EVENT_PREVIEW_LOGO_PATH, eventPreviewData.getLogo(), this.visualSkin.getWelcomeLogo(), false, 16, null);
        List<EventPreviewRewardData> rewards = eventPreviewData.getRewards();
        if (rewards == null) {
            rewards = CollectionsKt.emptyList();
        }
        WinterBattlepassRouletteOldPriseItemWelcomeBinding welcomePrice1 = winterBattlepassWelcomeLayoutBinding.welcomePrice1;
        Intrinsics.checkNotNullExpressionValue(welcomePrice1, "welcomePrice1");
        bindEventPreviewReward(welcomePrice1, (EventPreviewRewardData) CollectionsKt.getOrNull(rewards, 0));
        WinterBattlepassRouletteOldPriseItemWelcomeBinding welcomePrice2 = winterBattlepassWelcomeLayoutBinding.welcomePrice2;
        Intrinsics.checkNotNullExpressionValue(welcomePrice2, "welcomePrice2");
        bindEventPreviewReward(welcomePrice2, (EventPreviewRewardData) CollectionsKt.getOrNull(rewards, 1));
        WinterBattlepassRouletteOldPriseItemWelcomeBinding welcomePrice3 = winterBattlepassWelcomeLayoutBinding.welcomePrice3;
        Intrinsics.checkNotNullExpressionValue(welcomePrice3, "welcomePrice3");
        bindEventPreviewReward(welcomePrice3, (EventPreviewRewardData) CollectionsKt.getOrNull(rewards, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showEventPreview$lambda$0$1(WinterBattlepassWelcomeLayoutBinding winterBattlepassWelcomeLayoutBinding, Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        winterBattlepassWelcomeLayoutBinding.getRoot().setVisibility(8);
        winter2025BattlePassScreen.setVisibility(false);
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, 0, 10, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showEventPreview$lambda$0$2(Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, 0, 24, null, 4, null);
    }

    private final void bindEventPreviewReward(WinterBattlepassRouletteOldPriseItemWelcomeBinding winterBattlepassRouletteOldPriseItemWelcomeBinding, final EventPreviewRewardData eventPreviewRewardData) {
        LinearLayout root = winterBattlepassRouletteOldPriseItemWelcomeBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(eventPreviewRewardData != null ? 0 : 8);
        if (eventPreviewRewardData != null) {
            FrameLayout timerContainer = winterBattlepassRouletteOldPriseItemWelcomeBinding.timerContainer;
            Intrinsics.checkNotNullExpressionValue(timerContainer, "timerContainer");
            timerContainer.setVisibility(8);
            TextView textView = winterBattlepassRouletteOldPriseItemWelcomeBinding.oldPriseTitle;
            String title = eventPreviewRewardData.getTitle();
            if (title == null) {
                title = "";
            }
            textView.setText(title);
            Integer colorOrNull = toColorOrNull(eventPreviewRewardData.getRarity());
            if (colorOrNull != null) {
                int intValue = colorOrNull.intValue();
                winterBattlepassRouletteOldPriseItemWelcomeBinding.rarity.setBackgroundColor(intValue);
                FrameLayout frameLayout = winterBattlepassRouletteOldPriseItemWelcomeBinding.bg;
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, Color.argb(128, Color.red(intValue), Color.green(intValue), Color.blue(intValue))});
                gradientDrawable.setCornerRadius(getTargetActivity().getResources().getDimension(ru.mrlargha.commonui.R.dimen._8sdp));
                frameLayout.setBackground(gradientDrawable);
            } else {
                winterBattlepassRouletteOldPriseItemWelcomeBinding.bg.setBackgroundResource(R.drawable.winter_battlepass_roulette_bg_transparent_white);
            }
            winterBattlepassRouletteOldPriseItemWelcomeBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda43
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Winter2025BattlePassScreen.bindEventPreviewReward$lambda$0$1(EventPreviewRewardData.this, this, view);
                }
            });
            winterBattlepassRouletteOldPriseItemWelcomeBinding.getRoot().setClickable(eventPreviewRewardData.getId() != null);
            ImageView imagePrise = winterBattlepassRouletteOldPriseItemWelcomeBinding.imagePrise;
            Intrinsics.checkNotNullExpressionValue(imagePrise, "imagePrise");
            loadEventPreviewImage$default(this, imagePrise, EVENT_PREVIEW_PRIZE_PATH, eventPreviewRewardData.getImg(), ru.mrlargha.commonui.R.drawable.image_placeholder, false, 16, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindEventPreviewReward$lambda$0$1(EventPreviewRewardData eventPreviewRewardData, Winter2025BattlePassScreen winter2025BattlePassScreen, View view) {
        Integer id = eventPreviewRewardData.getId();
        if (id != null) {
            SAMPUIElement.notifyClick$default(winter2025BattlePassScreen, id.intValue(), 29, null, 4, null);
        }
    }

    static /* synthetic */ void loadEventPreviewImage$default(Winter2025BattlePassScreen winter2025BattlePassScreen, ImageView imageView, String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            z = false;
        }
        winter2025BattlePassScreen.loadEventPreviewImage(imageView, str, str2, i, z);
    }

    private final void loadEventPreviewImage(ImageView imageView, String str, String str2, int i, boolean z) {
        String str3;
        if (str2 == null || (str3 = StringsKt.trim((CharSequence) str2).toString()) == null || str3.length() <= 0) {
            str3 = null;
        }
        if (str3 == null) {
            imageView.setImageResource(i);
            return;
        }
        if (!StringsKt.contains$default((CharSequence) StringsKt.substringAfterLast$default(str3, '/', (String) null, 2, (Object) null), '.', false, 2, (Object) null)) {
            str3 = str3 + ".webp";
        }
        RequestBuilder error = Glide.with(imageView).load(StringsKt.trimEnd(UtilsKt.isArizonaType() ? FirebaseConfigHelper.INSTANCE.getProjectResourceUrl(false) : FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null), '/') + "/" + str + "/" + str3).placeholder(i).error(i);
        Intrinsics.checkNotNullExpressionValue(error, "error(...)");
        RequestBuilder requestBuilder = error;
        RequestBuilder centerCrop = z ? requestBuilder.centerCrop() : requestBuilder.fitCenter();
        requestBuilder.into(imageView);
    }

    private final Integer toColorOrNull(String str) {
        Object m9919constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            m9919constructorimpl = Result.m9919constructorimpl(Integer.valueOf(Color.parseColor(str != null ? StringsKt.trim((CharSequence) str).toString() : null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9919constructorimpl = Result.m9919constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m9925isFailureimpl(m9919constructorimpl) ? null : m9919constructorimpl;
    }

    private final void openModalWindow(BpModalWindowModel bpModalWindowModel) {
        BpSeasonEndedBinding bpSeasonEndedBinding = this.battlePassBinding.seasonEnded;
        FrameLayout root = bpSeasonEndedBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        refreshChromeVisibility();
        bpSeasonEndedBinding.ivPoster.setImageResource(this.visualSkin.getSeasonEndedPoster());
        bpSeasonEndedBinding.tvTitle.setText(bpModalWindowModel.getTitle());
        bpSeasonEndedBinding.tvDesc.setText(ParseColoredTextKt.toStyledColoredText(bpModalWindowModel.getInfo(), this.whiteColor));
        bpSeasonEndedBinding.tvAccept.setText(bpModalWindowModel.getButtonAcceptText());
        bpSeasonEndedBinding.tvClose.setText(bpModalWindowModel.getButtonCloseText());
        CustomCardView btnAccept = bpSeasonEndedBinding.btnAccept;
        Intrinsics.checkNotNullExpressionValue(btnAccept, "btnAccept");
        btnAccept.setVisibility(bpModalWindowModel.getButtonAcceptText().length() > 0 ? 0 : 8);
        CustomCardView btnClose = bpSeasonEndedBinding.btnClose;
        Intrinsics.checkNotNullExpressionValue(btnClose, "btnClose");
        btnClose.setVisibility(bpModalWindowModel.getButtonCloseText().length() > 0 ? 0 : 8);
        if (StringsKt.isBlank(bpModalWindowModel.getImage())) {
            return;
        }
        Picasso.get().load(FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "systems/battlepass/image_modal/" + bpModalWindowModel.getImage() + ".webp").placeholder(this.visualSkin.getSeasonEndedPoster()).error(this.visualSkin.getSeasonEndedPoster()).into(bpSeasonEndedBinding.ivPoster);
    }

    private final void setupListeners() {
        WinterBattlepassLayoutBinding winterBattlepassLayoutBinding = this.battlePassBinding;
        winterBattlepassLayoutBinding.seasonEnded.btnAccept.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupListeners$lambda$0$0(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassLayoutBinding.seasonEnded.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda39
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Winter2025BattlePassScreen.setupListeners$lambda$0$1(Winter2025BattlePassScreen.this, view);
            }
        });
        winterBattlepassLayoutBinding.seasonEnded.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.battlepassWinter2025.Winter2025BattlePassScreen$$ExternalSyntheticLambda40
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

    /* compiled from: Winter2025BattlePass.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/Winter2025BattlePassScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/Winter2025BattlePassScreen$NavItems;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN_PAGE", "TASKS_PAGE", "ROULETTE_PAGE", "DONATE_PAGE", "LEVEL_SETS", "BUY_PREMIUM", "CONVERT_BATTLE_COINS", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
