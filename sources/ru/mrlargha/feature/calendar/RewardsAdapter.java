package ru.mrlargha.feature.calendar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Matrix;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.arizona.common.utils.EasyAnimation;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.utils.PicassoLoadSafeKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.money.MoneyFormatter;
import ru.mrlargha.feature.calendar.DailyRewardsScreen;
import ru.mrlargha.feature.calendar.RewardsAdapter;
import ru.mrlargha.feature.calendar.databinding.DailyRewardsRewardItemBinding;
import ru.mrlargha.feature.calendar.databinding.OctoberStreetRewardItemBinding;
/* compiled from: RewardsAdapter.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\u0018\u0000 W2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0007STUVWXYB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0011J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J\b\u0010 \u001a\u00020\u001aH\u0016J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0018\u0010#\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0018\u0010%\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J(\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)2\u0006\u0010\"\u001a\u00020&2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u0010-\u001a\u00020.2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\tH\u0002J(\u0010/\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)2\u0006\u0010\"\u001a\u00020&2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u00100\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\tH\u0002J\u0017\u00101\u001a\u0004\u0018\u00010\u001a2\u0006\u0010*\u001a\u00020\tH\u0002¢\u0006\u0002\u00102J\u0010\u00103\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u00104\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)H\u0002J \u00105\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020&2\u0006\u0010*\u001a\u00020\t2\u0006\u00106\u001a\u00020\u0004H\u0002J\u0018\u00107\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)2\u0006\u00108\u001a\u00020\u001aH\u0002J\u0018\u00109\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)2\u0006\u0010:\u001a\u00020;H\u0002J\u0012\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010*\u001a\u00020\tH\u0002J\u0012\u0010>\u001a\u0004\u0018\u00010=2\u0006\u0010*\u001a\u00020\tH\u0002J\u0018\u0010?\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)2\u0006\u0010@\u001a\u00020=H\u0002J\u0018\u0010A\u001a\u00020;2\u0006\u0010+\u001a\u00020,2\u0006\u0010B\u001a\u00020\u001aH\u0002J0\u0010C\u001a\u00020\u00132\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020;2\u0006\u0010H\u001a\u00020;2\u0006\u0010I\u001a\u00020;H\u0002J \u0010J\u001a\u00020\u00132\u0006\u0010K\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020L2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0014\u0010M\u001a\u00020\u00132\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\t0OJ\u000e\u0010P\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020\u000bJ\u0010\u0010R\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lru/mrlargha/feature/calendar/RewardsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "isArizona", "", "<init>", "(Z)V", "rewardsList", "", "Lru/mrlargha/feature/calendar/DailyRewardsScreen$RewardInfo;", "updateInfo", "Lru/mrlargha/feature/calendar/DailyRewardsScreen$UpdatePlayerInfo;", "rewardType", "Lru/mrlargha/feature/calendar/DailyRewardsScreen$BackgroundType;", "presentation", "Lru/mrlargha/feature/calendar/RewardsAdapter$Presentation;", "rewardItemClickListener", "Lru/mrlargha/feature/calendar/RewardsAdapter$OnRewardItemClickListener;", "setPresentation", "", "value", "setLegacyRewardType", "type", "setOnRewardItemClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "bindLegacy", "Lru/mrlargha/feature/calendar/RewardsAdapter$LegacyViewHolder;", "bindOctober", "Lru/mrlargha/feature/calendar/RewardsAdapter$OctoberViewHolder;", "bindOctoberCurrent", "binding", "Lru/mrlargha/feature/calendar/databinding/OctoberStreetRewardItemBinding;", "reward", "context", "Landroid/content/Context;", "octoberState", "Lru/mrlargha/feature/calendar/RewardsAdapter$OctoberState;", "bindOctoberClaim", "rewardDayForDisplay", "explicitRewardDay", "(Lru/mrlargha/feature/calendar/DailyRewardsScreen$RewardInfo;)Ljava/lang/Integer;", "resetOctoberRewardLayout", "setOctoberReadyLayout", "showOctoberReward", "showDetails", "showOctoberChest", "topMarginRes", "showOctoberNotice", "title", "", "restoreCurrencyFor", "Lru/mrlargha/feature/calendar/RewardsAdapter$RestoreCurrency;", "explicitRestoreCurrencyFor", "bindRestoreCurrency", FirebaseAnalytics.Param.CURRENCY, "formatRemainingTime", "totalSeconds", "setOctoberCardColors", "dayContainer", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "mainContainer", "dayColor", "mainColor", "darkMainColor", "checkLegacyRewardType", CommonUrlParts.MODEL, "Lru/mrlargha/feature/calendar/databinding/DailyRewardsRewardItemBinding;", "addRewards", "rewards", "", "updateRewards", "info", "onViewRecycled", "Presentation", "OctoberState", "RestoreCurrency", "OnRewardItemClickListener", "Companion", "LegacyViewHolder", "OctoberViewHolder", "calendar"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RewardsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final Companion Companion = new Companion(null);
    private static final Matrix OCTOBER_STREET_RADIAL_GRADIENT_TRANSFORM;
    private final boolean isArizona;
    private OnRewardItemClickListener rewardItemClickListener;
    private DailyRewardsScreen.UpdatePlayerInfo updateInfo;
    private final List<DailyRewardsScreen.RewardInfo> rewardsList = new ArrayList();
    private DailyRewardsScreen.BackgroundType rewardType = DailyRewardsScreen.BackgroundType.DAILY_REWARD;
    private Presentation presentation = Presentation.LEGACY;

    /* compiled from: RewardsAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lru/mrlargha/feature/calendar/RewardsAdapter$OnRewardItemClickListener;", "", "onRewardItemClickListener", "", "hasReward", "", "onClaimRewardClick", "day", "onRestoreRewardClick", "calendar"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public interface OnRewardItemClickListener {
        void onClaimRewardClick(int i);

        void onRestoreRewardClick(int i);

        void onRewardItemClickListener(int i);
    }

    /* compiled from: RewardsAdapter.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[Presentation.values().length];
            try {
                iArr[Presentation.LEGACY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Presentation.OCTOBER_STREET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[RestoreCurrency.values().length];
            try {
                iArr2[RestoreCurrency.AZ.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[RestoreCurrency.RUB.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[OctoberState.values().length];
            try {
                iArr3[OctoberState.READY_TO_CLAIM.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[OctoberState.CLAIMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[OctoberState.CURRENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[OctoberState.MISSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[OctoberState.FUTURE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[OctoberState.NOTICE.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[DailyRewardsScreen.BackgroundType.values().length];
            try {
                iArr4[DailyRewardsScreen.BackgroundType.MAY_REWARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr4[DailyRewardsScreen.BackgroundType.AUTUMN_REWARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr4[DailyRewardsScreen.BackgroundType.WELCOME.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr4[DailyRewardsScreen.BackgroundType.RODINA_CAR_1.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr4[DailyRewardsScreen.BackgroundType.RODINA_CAR_2.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    public RewardsAdapter(boolean z) {
        this.isArizona = z;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: RewardsAdapter.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/mrlargha/feature/calendar/RewardsAdapter$Presentation;", "", "<init>", "(Ljava/lang/String;I)V", "LEGACY", "OCTOBER_STREET", "calendar"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Presentation {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Presentation[] $VALUES;
        public static final Presentation LEGACY = new Presentation("LEGACY", 0);
        public static final Presentation OCTOBER_STREET = new Presentation("OCTOBER_STREET", 1);

        private static final /* synthetic */ Presentation[] $values() {
            return new Presentation[]{LEGACY, OCTOBER_STREET};
        }

        public static EnumEntries<Presentation> getEntries() {
            return $ENTRIES;
        }

        public static Presentation valueOf(String str) {
            return (Presentation) Enum.valueOf(Presentation.class, str);
        }

        public static Presentation[] values() {
            return (Presentation[]) $VALUES.clone();
        }

        private Presentation(String str, int i) {
        }

        static {
            Presentation[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: RewardsAdapter.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lru/mrlargha/feature/calendar/RewardsAdapter$OctoberState;", "", "<init>", "(Ljava/lang/String;I)V", "FUTURE", "CURRENT", "READY_TO_CLAIM", "CLAIMED", "MISSED", "NOTICE", "calendar"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class OctoberState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ OctoberState[] $VALUES;
        public static final OctoberState FUTURE = new OctoberState("FUTURE", 0);
        public static final OctoberState CURRENT = new OctoberState("CURRENT", 1);
        public static final OctoberState READY_TO_CLAIM = new OctoberState("READY_TO_CLAIM", 2);
        public static final OctoberState CLAIMED = new OctoberState("CLAIMED", 3);
        public static final OctoberState MISSED = new OctoberState("MISSED", 4);
        public static final OctoberState NOTICE = new OctoberState("NOTICE", 5);

        private static final /* synthetic */ OctoberState[] $values() {
            return new OctoberState[]{FUTURE, CURRENT, READY_TO_CLAIM, CLAIMED, MISSED, NOTICE};
        }

        public static EnumEntries<OctoberState> getEntries() {
            return $ENTRIES;
        }

        public static OctoberState valueOf(String str) {
            return (OctoberState) Enum.valueOf(OctoberState.class, str);
        }

        public static OctoberState[] values() {
            return (OctoberState[]) $VALUES.clone();
        }

        private OctoberState(String str, int i) {
        }

        static {
            OctoberState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: RewardsAdapter.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/mrlargha/feature/calendar/RewardsAdapter$RestoreCurrency;", "", "<init>", "(Ljava/lang/String;I)V", "AZ", "RUB", "calendar"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class RestoreCurrency {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ RestoreCurrency[] $VALUES;
        public static final RestoreCurrency AZ = new RestoreCurrency("AZ", 0);
        public static final RestoreCurrency RUB = new RestoreCurrency("RUB", 1);

        private static final /* synthetic */ RestoreCurrency[] $values() {
            return new RestoreCurrency[]{AZ, RUB};
        }

        public static EnumEntries<RestoreCurrency> getEntries() {
            return $ENTRIES;
        }

        public static RestoreCurrency valueOf(String str) {
            return (RestoreCurrency) Enum.valueOf(RestoreCurrency.class, str);
        }

        public static RestoreCurrency[] values() {
            return (RestoreCurrency[]) $VALUES.clone();
        }

        private RestoreCurrency(String str, int i) {
        }

        static {
            RestoreCurrency[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    public final void setPresentation(Presentation value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.presentation == value) {
            return;
        }
        this.presentation = value;
        notifyDataSetChanged();
    }

    public final void setLegacyRewardType(DailyRewardsScreen.BackgroundType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (this.rewardType == type) {
            return;
        }
        this.rewardType = type;
        if (this.presentation == Presentation.LEGACY) {
            notifyDataSetChanged();
        }
    }

    public final void setOnRewardItemClickListener(OnRewardItemClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.rewardItemClickListener = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.presentation.ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        int i2 = WhenMappings.$EnumSwitchMapping$0[((Presentation) Presentation.getEntries().get(i)).ordinal()];
        if (i2 == 1) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_rewards_reward_item, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new LegacyViewHolder(inflate);
        } else if (i2 != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.october_street_reward_item, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
            return new OctoberViewHolder(inflate2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.rewardsList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof LegacyViewHolder) {
            bindLegacy((LegacyViewHolder) holder, i);
        } else if (holder instanceof OctoberViewHolder) {
            bindOctober((OctoberViewHolder) holder, i);
        }
    }

    private final void bindLegacy(LegacyViewHolder legacyViewHolder, int i) {
        LegacyViewHolder legacyViewHolder2;
        Job launch$default;
        DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo = this.updateInfo;
        if (updatePlayerInfo == null) {
            return;
        }
        DailyRewardsRewardItemBinding binding = legacyViewHolder.getBinding();
        legacyViewHolder.cancelImageLoad();
        DailyRewardsScreen.RewardInfo rewardInfo = this.rewardsList.get(i);
        binding.rewardName.setText(rewardInfo.getTitle());
        if (rewardInfo.getAmount() > 0) {
            binding.rewardCountContainer.setVisibility(0);
            binding.rewardCount.setText(String.valueOf(rewardInfo.getAmount()));
        } else {
            binding.rewardCountContainer.setVisibility(8);
        }
        int i2 = i + 1;
        binding.dayTitle.setText("ДЕНЬ " + i2);
        boolean z = true;
        if (this.isArizona) {
            binding.rewardIc.setImageDrawable(null);
            String image = rewardInfo.getImage();
            String str = image;
            if (str == null || StringsKt.isBlank(str)) {
                legacyViewHolder2 = legacyViewHolder;
            } else {
                launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new RewardsAdapter$bindLegacy$1$1(binding, image, null), 3, null);
                legacyViewHolder2 = legacyViewHolder;
                legacyViewHolder2.setLoadImageJob(launch$default);
            }
        } else {
            legacyViewHolder2 = legacyViewHolder;
            Picasso picasso = Picasso.get();
            Intrinsics.checkNotNullExpressionValue(picasso, "get(...)");
            PicassoLoadSafeKt.loadSafe(picasso, FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "systems/battlepass/items/" + rewardInfo.getImage() + ".webp").networkPolicy(NetworkPolicy.NO_CACHE, new NetworkPolicy[0]).memoryPolicy(MemoryPolicy.NO_CACHE, new MemoryPolicy[0]).into(binding.rewardIc);
        }
        boolean z2 = updatePlayerInfo.getNeedToPlay() <= updatePlayerInfo.getPlayed() || updatePlayerInfo.getPlayed() <= 0;
        boolean z3 = updatePlayerInfo.getReceived() == 1 && i2 == updatePlayerInfo.getCurrentDay() && z2 && !this.isArizona;
        if (updatePlayerInfo.getReceived() != 1 || i2 != updatePlayerInfo.getCurrentDay() || z2 || this.isArizona) {
            z = false;
        }
        if (i2 > updatePlayerInfo.getCurrentDay()) {
            binding.getButton.setVisibility(8);
            binding.timePgb.setVisibility(8);
            binding.rewardDescription.setVisibility(8);
            binding.doneContainer.setVisibility(8);
            binding.dayTitle.setTextColor(-1);
            binding.dayContainer.setBackgroundResource(R.drawable.daily_rewards_day_container_bg);
        }
        if (i2 < updatePlayerInfo.getCurrentDay() || z3) {
            binding.mainContainer.setBackgroundResource(R.drawable.daily_rewards_common_item_bg);
            binding.getButton.setVisibility(8);
            binding.timePgb.setVisibility(8);
            binding.rewardDescription.setVisibility(8);
            binding.doneContainer.setVisibility(0);
            binding.dayTitle.setTextColor(-1);
            binding.dayContainer.setBackgroundResource(R.drawable.daily_rewards_day_container_bg);
        }
        if ((i2 == updatePlayerInfo.getCurrentDay() && updatePlayerInfo.getReceived() == 0) || z) {
            if (updatePlayerInfo.getPlayed() < updatePlayerInfo.getNeedToPlay()) {
                binding.mainContainer.setBackgroundResource(R.drawable.daily_rewards_common_item_bg);
                binding.dayContainer.setBackgroundResource(R.drawable.daily_rewards_current_day_container_bg);
                binding.dayTitle.setTextColor(-16777216);
                binding.timePgb.setMax(updatePlayerInfo.getNeedToPlay());
                binding.timePgb.setProgress(updatePlayerInfo.getPlayed());
                binding.timePgb.setVisibility(0);
                binding.doneContainer.setVisibility(8);
                binding.rewardDescription.setVisibility(0);
                binding.rewardDescription.setText("Осталось отыграть " + (((updatePlayerInfo.getNeedToPlay() - updatePlayerInfo.getPlayed()) % 86400) / 3600) + " ч. " + (((updatePlayerInfo.getNeedToPlay() - updatePlayerInfo.getPlayed()) % 3600) / 60) + " м.");
                binding.getButton.setVisibility(8);
                binding.getButton.setBackgroundResource(R.drawable.daily_reward_get_button_unavailable_bg);
                binding.getButtonText.setTextColor(Color.parseColor("#10FFFFFF"));
            }
            if (updatePlayerInfo.getPlayed() >= updatePlayerInfo.getNeedToPlay()) {
                binding.mainContainer.setBackgroundResource(R.drawable.daily_rewards_award_item_bg);
                binding.dayContainer.setBackgroundResource(R.drawable.daily_rewards_award_day_container_bg);
                binding.dayTitle.setTextColor(-16777216);
                binding.timePgb.setVisibility(8);
                binding.doneContainer.setVisibility(8);
                binding.rewardDescription.setVisibility(0);
                binding.rewardDescription.setText("Можете забрать награду");
                binding.getButton.setVisibility(0);
                binding.getButton.setBackgroundResource(R.drawable.daily_reward_get_button_available_bg);
                binding.getButtonText.setTextColor(-1);
            }
            EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
            ConstraintLayout getButton = binding.getButton;
            Intrinsics.checkNotNullExpressionValue(getButton, "getButton");
            EasyAnimation.animateClick$default(easyAnimation, getButton, 0L, null, new Function0() { // from class: ru.mrlargha.feature.calendar.RewardsAdapter$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit bindLegacy$lambda$0$0;
                    bindLegacy$lambda$0$0 = RewardsAdapter.bindLegacy$lambda$0$0(RewardsAdapter.this);
                    return bindLegacy$lambda$0$0;
                }
            }, 3, null);
        }
        checkLegacyRewardType(updatePlayerInfo, legacyViewHolder2.getBinding(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindLegacy$lambda$0$0(RewardsAdapter rewardsAdapter) {
        OnRewardItemClickListener onRewardItemClickListener;
        DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo = rewardsAdapter.updateInfo;
        if (updatePlayerInfo != null && (onRewardItemClickListener = rewardsAdapter.rewardItemClickListener) != null) {
            onRewardItemClickListener.onRewardItemClickListener(updatePlayerInfo.getReceived());
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0188  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void bindOctober(final OctoberViewHolder octoberViewHolder, int i) {
        RestoreCurrency explicitRestoreCurrencyFor;
        final int i2;
        int intValue;
        Integer explicitRewardDay;
        int i3;
        DailyRewardsScreen.RewardInfo rewardInfo = this.rewardsList.get(i);
        OctoberState octoberState = octoberState(i, rewardInfo);
        OctoberStreetRewardItemBinding binding = octoberViewHolder.getBinding();
        Context context = binding.getRoot().getContext();
        octoberViewHolder.cancelImageLoad();
        resetOctoberRewardLayout(binding);
        binding.dayTitle.setText(context.getString(R.string.october_street_day, Integer.valueOf(rewardDayForDisplay(i, rewardInfo))));
        binding.completedIcon.setVisibility(octoberState == OctoberState.CLAIMED ? 0 : 8);
        binding.clockIcon.setVisibility(octoberState == OctoberState.CURRENT ? 0 : 8);
        binding.missedLabel.setVisibility(octoberState == OctoberState.MISSED ? 0 : 8);
        binding.rewardIcon.setVisibility(8);
        binding.rewardIcon.setAlpha(1.0f);
        binding.genericChest.setVisibility(8);
        binding.genericChest.setAlpha(1.0f);
        binding.rewardName.setVisibility(8);
        binding.rewardName.setText((CharSequence) null);
        binding.rewardCountContainer.setVisibility(8);
        binding.rewardCount.setText((CharSequence) null);
        binding.progressContainer.setVisibility(8);
        binding.restoreButton.setVisibility(8);
        binding.restoreCoin.setVisibility(8);
        binding.restoreCoin.setImageResource(R.drawable.october_street_az_coin);
        binding.restoreCoin.clearColorFilter();
        binding.restorePrice.setText((CharSequence) null);
        binding.restoreButton.setContentDescription(null);
        CustomCardView restoreButton = binding.restoreButton;
        Intrinsics.checkNotNullExpressionValue(restoreButton, "restoreButton");
        CustomCardView.changeValidate$default(restoreButton, true, 0.0f, 2, null);
        binding.restoreButton.setOnClickListener(null);
        Picasso.get().cancelRequest(binding.rewardIcon);
        binding.rewardIcon.setImageDrawable(null);
        switch (WhenMappings.$EnumSwitchMapping$2[octoberState.ordinal()]) {
            case 1:
            case 2:
                CustomCardView dayContainer = binding.dayContainer;
                Intrinsics.checkNotNullExpressionValue(dayContainer, "dayContainer");
                CustomCardView mainContainer = binding.mainContainer;
                Intrinsics.checkNotNullExpressionValue(mainContainer, "mainContainer");
                setOctoberCardColors(dayContainer, mainContainer, "#559647", "#204018", "#081006");
                if (octoberState == OctoberState.READY_TO_CLAIM && explicitRewardDay(rewardInfo) != null) {
                    setOctoberReadyLayout(binding);
                }
                showOctoberReward(octoberViewHolder, rewardInfo, true);
                if (octoberState == OctoberState.READY_TO_CLAIM) {
                    Intrinsics.checkNotNull(context);
                    bindOctoberClaim(binding, octoberViewHolder, rewardInfo, context);
                    return;
                }
                return;
            case 3:
                Intrinsics.checkNotNull(context);
                bindOctoberCurrent(binding, octoberViewHolder, rewardInfo, context);
                return;
            case 4:
                CustomCardView dayContainer2 = binding.dayContainer;
                Intrinsics.checkNotNullExpressionValue(dayContainer2, "dayContainer");
                CustomCardView mainContainer2 = binding.mainContainer;
                Intrinsics.checkNotNullExpressionValue(mainContainer2, "mainContainer");
                setOctoberCardColors(dayContainer2, mainContainer2, "#564943", "#564943", "#161211");
                showOctoberReward(octoberViewHolder, rewardInfo, false);
                binding.rewardIcon.setAlpha(0.25f);
                if (rewardInfo.getState() == null) {
                    explicitRestoreCurrencyFor = restoreCurrencyFor(rewardInfo);
                } else {
                    explicitRestoreCurrencyFor = explicitRestoreCurrencyFor(rewardInfo);
                }
                final RestoreCurrency restoreCurrency = explicitRestoreCurrencyFor;
                if (rewardInfo.getState() == null) {
                    intValue = rewardInfo.getRestorePrice();
                } else {
                    Integer price = rewardInfo.getPrice();
                    if (price == null) {
                        i2 = 0;
                        if (rewardInfo.getState() != null) {
                            explicitRewardDay = Integer.valueOf(i + 1);
                        } else {
                            explicitRewardDay = explicitRewardDay(rewardInfo);
                        }
                        final Integer num = explicitRewardDay;
                        if (i2 > 0 || restoreCurrency == null || num == null) {
                            return;
                        }
                        binding.restoreButton.setVisibility(0);
                        binding.restoreButton.setBackground(-1);
                        CustomCardView restoreButton2 = binding.restoreButton;
                        Intrinsics.checkNotNullExpressionValue(restoreButton2, "restoreButton");
                        CustomCardView.changeValidate$default(restoreButton2, true, 0.0f, 2, null);
                        binding.restoreCoin.setVisibility(0);
                        binding.restorePrice.setTextColor(Color.parseColor("#21170E"));
                        bindRestoreCurrency(binding, restoreCurrency);
                        binding.restorePrice.setText(context.getString(R.string.october_street_restore_price, MoneyFormatter.INSTANCE.formatPlain(i2)));
                        CustomCardView customCardView = binding.restoreButton;
                        Resources resources = context.getResources();
                        int i4 = WhenMappings.$EnumSwitchMapping$1[restoreCurrency.ordinal()];
                        if (i4 == 1) {
                            i3 = R.plurals.october_street_restore_az_description;
                        } else if (i4 != 2) {
                            throw new NoWhenBranchMatchedException();
                        } else {
                            i3 = R.plurals.october_street_restore_rub_description;
                        }
                        customCardView.setContentDescription(resources.getQuantityString(i3, i2, Integer.valueOf(i2)));
                        binding.restoreButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.calendar.RewardsAdapter$$ExternalSyntheticLambda1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                RewardsAdapter.bindOctober$lambda$0(RewardsAdapter.OctoberViewHolder.this, this, num, i2, restoreCurrency, view);
                            }
                        });
                        return;
                    }
                    intValue = price.intValue();
                }
                i2 = intValue;
                if (rewardInfo.getState() != null) {
                }
                final Integer num2 = explicitRewardDay;
                if (i2 > 0) {
                    return;
                }
                return;
            case 5:
                CustomCardView dayContainer3 = binding.dayContainer;
                Intrinsics.checkNotNullExpressionValue(dayContainer3, "dayContainer");
                CustomCardView mainContainer3 = binding.mainContainer;
                Intrinsics.checkNotNullExpressionValue(mainContainer3, "mainContainer");
                setOctoberCardColors(dayContainer3, mainContainer3, "#973B09", "#973B09", "#260F02");
                showOctoberChest(binding, ru.mrlargha.commonui.R.dimen._17sdp);
                return;
            case 6:
                CustomCardView dayContainer4 = binding.dayContainer;
                Intrinsics.checkNotNullExpressionValue(dayContainer4, "dayContainer");
                CustomCardView mainContainer4 = binding.mainContainer;
                Intrinsics.checkNotNullExpressionValue(mainContainer4, "mainContainer");
                setOctoberCardColors(dayContainer4, mainContainer4, "#973B09", "#973B09", "#260F02");
                String title = rewardInfo.getTitle();
                String str = title;
                if (str == null || StringsKt.isBlank(str)) {
                    showOctoberChest(binding, ru.mrlargha.commonui.R.dimen._17sdp);
                    return;
                } else {
                    showOctoberNotice(binding, title);
                    return;
                }
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void bindOctober$lambda$0(OctoberViewHolder octoberViewHolder, RewardsAdapter rewardsAdapter, Integer num, int i, RestoreCurrency restoreCurrency, View view) {
        Integer num2;
        Integer num3;
        OnRewardItemClickListener onRewardItemClickListener;
        int intValue;
        int bindingAdapterPosition = octoberViewHolder.getBindingAdapterPosition();
        DailyRewardsScreen.RewardInfo rewardInfo = (DailyRewardsScreen.RewardInfo) CollectionsKt.getOrNull(rewardsAdapter.rewardsList, bindingAdapterPosition);
        RestoreCurrency restoreCurrency2 = null;
        if (rewardInfo != null) {
            num2 = rewardInfo.getState() == null ? Integer.valueOf(bindingAdapterPosition + 1) : rewardsAdapter.explicitRewardDay(rewardInfo);
        } else {
            num2 = null;
        }
        if (rewardInfo != null) {
            if (rewardInfo.getState() == null) {
                intValue = rewardInfo.getRestorePrice();
            } else {
                Integer price = rewardInfo.getPrice();
                intValue = price != null ? price.intValue() : 0;
            }
            num3 = Integer.valueOf(intValue);
        } else {
            num3 = null;
        }
        if (rewardInfo != null) {
            restoreCurrency2 = rewardInfo.getState() == null ? rewardsAdapter.restoreCurrencyFor(rewardInfo) : rewardsAdapter.explicitRestoreCurrencyFor(rewardInfo);
        }
        if (rewardsAdapter.presentation == Presentation.OCTOBER_STREET && rewardsAdapter.isArizona && bindingAdapterPosition != -1 && rewardInfo != null && rewardsAdapter.octoberState(bindingAdapterPosition, rewardInfo) == OctoberState.MISSED) {
            int intValue2 = num.intValue();
            if (num2 != null && num2.intValue() == intValue2 && num3 != null && num3.intValue() == i && restoreCurrency2 == restoreCurrency && (onRewardItemClickListener = rewardsAdapter.rewardItemClickListener) != null) {
                onRewardItemClickListener.onRestoreRewardClick(num.intValue());
            }
        }
    }

    private final void bindOctoberCurrent(OctoberStreetRewardItemBinding octoberStreetRewardItemBinding, final OctoberViewHolder octoberViewHolder, DailyRewardsScreen.RewardInfo rewardInfo, Context context) {
        CustomCardView dayContainer = octoberStreetRewardItemBinding.dayContainer;
        Intrinsics.checkNotNullExpressionValue(dayContainer, "dayContainer");
        CustomCardView mainContainer = octoberStreetRewardItemBinding.mainContainer;
        Intrinsics.checkNotNullExpressionValue(mainContainer, "mainContainer");
        setOctoberCardColors(dayContainer, mainContainer, "#CE8235", "#603C18", "#180F06");
        octoberStreetRewardItemBinding.rewardIcon.setVisibility(0);
        octoberStreetRewardItemBinding.rewardIcon.setImageResource(R.drawable.october_street_chest);
        DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo = this.updateInfo;
        if (updatePlayerInfo == null) {
            return;
        }
        if (rewardInfo.getState() != null) {
            if (explicitRewardDay(rewardInfo) == null) {
                return;
            }
            Integer explicitRewardDay = explicitRewardDay(rewardInfo);
            int currentDay = updatePlayerInfo.getCurrentDay();
            if (explicitRewardDay == null || explicitRewardDay.intValue() != currentDay) {
                return;
            }
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(updatePlayerInfo.getNeedToPlay(), 0);
        int coerceAtMost = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(updatePlayerInfo.getPlayed(), 0), coerceAtLeast);
        if (rewardInfo.getState() == null && updatePlayerInfo.getNeedToPlay() >= 0 && coerceAtMost >= coerceAtLeast) {
            octoberStreetRewardItemBinding.restoreButton.setVisibility(0);
            octoberStreetRewardItemBinding.restoreButton.setBackground(Color.parseColor("#CE8235"));
            CustomCardView restoreButton = octoberStreetRewardItemBinding.restoreButton;
            Intrinsics.checkNotNullExpressionValue(restoreButton, "restoreButton");
            CustomCardView.changeValidate$default(restoreButton, true, 0.0f, 2, null);
            octoberStreetRewardItemBinding.restorePrice.setTextColor(-1);
            octoberStreetRewardItemBinding.restorePrice.setText(context.getString(R.string.october_street_claim));
            octoberStreetRewardItemBinding.restoreButton.setContentDescription(context.getString(R.string.october_street_claim));
            octoberStreetRewardItemBinding.restoreButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.calendar.RewardsAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RewardsAdapter.bindOctoberCurrent$lambda$0(RewardsAdapter.OctoberViewHolder.this, this, view);
                }
            });
            return;
        }
        octoberStreetRewardItemBinding.progressContainer.setVisibility(0);
        octoberStreetRewardItemBinding.remainingTime.setText(formatRemainingTime(context, RangesKt.coerceAtLeast(coerceAtLeast - coerceAtMost, 0)));
        octoberStreetRewardItemBinding.progressFill.setPercentWidth(coerceAtLeast != 0 ? coerceAtMost / coerceAtLeast : 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void bindOctoberCurrent$lambda$0(OctoberViewHolder octoberViewHolder, RewardsAdapter rewardsAdapter, View view) {
        OnRewardItemClickListener onRewardItemClickListener;
        int bindingAdapterPosition = octoberViewHolder.getBindingAdapterPosition();
        DailyRewardsScreen.RewardInfo rewardInfo = (DailyRewardsScreen.RewardInfo) CollectionsKt.getOrNull(rewardsAdapter.rewardsList, bindingAdapterPosition);
        DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo = rewardsAdapter.updateInfo;
        if (rewardsAdapter.presentation != Presentation.OCTOBER_STREET || !rewardsAdapter.isArizona || bindingAdapterPosition == -1 || rewardInfo == null || updatePlayerInfo == null || rewardInfo.getState() != null || bindingAdapterPosition + 1 != updatePlayerInfo.getCurrentDay() || updatePlayerInfo.getReceived() != 0 || rewardInfo.getReceived() || rewardInfo.getMissed() || rewardsAdapter.octoberState(bindingAdapterPosition, rewardInfo) != OctoberState.CURRENT || updatePlayerInfo.getNeedToPlay() < 0 || updatePlayerInfo.getPlayed() < updatePlayerInfo.getNeedToPlay() || (onRewardItemClickListener = rewardsAdapter.rewardItemClickListener) == null) {
            return;
        }
        onRewardItemClickListener.onRewardItemClickListener(0);
    }

    private final OctoberState octoberState(int i, DailyRewardsScreen.RewardInfo rewardInfo) {
        DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo;
        Integer state = rewardInfo.getState();
        if (state != null) {
            int intValue = state.intValue();
            if (intValue != 0) {
                if (intValue != 1) {
                    if (intValue != 2) {
                        if (intValue != 3) {
                            if (intValue != 4) {
                                if (intValue == 5) {
                                    return OctoberState.NOTICE;
                                }
                                return OctoberState.FUTURE;
                            }
                            return OctoberState.MISSED;
                        }
                        return OctoberState.CLAIMED;
                    }
                    return OctoberState.READY_TO_CLAIM;
                }
                return OctoberState.CURRENT;
            }
            return OctoberState.FUTURE;
        } else if (rewardInfo.getReceived()) {
            return OctoberState.CLAIMED;
        } else {
            if (rewardInfo.getMissed()) {
                return OctoberState.MISSED;
            }
            DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo2 = this.updateInfo;
            if (updatePlayerInfo2 != null) {
                int currentDay = updatePlayerInfo2.getCurrentDay();
                int i2 = i + 1;
                if (i2 < currentDay) {
                    return OctoberState.CLAIMED;
                }
                if (i2 == currentDay && (updatePlayerInfo = this.updateInfo) != null && updatePlayerInfo.getReceived() == 1) {
                    return OctoberState.CLAIMED;
                }
                if (i2 == currentDay) {
                    return OctoberState.CURRENT;
                }
                return OctoberState.FUTURE;
            }
            return OctoberState.FUTURE;
        }
    }

    private final void bindOctoberClaim(OctoberStreetRewardItemBinding octoberStreetRewardItemBinding, final OctoberViewHolder octoberViewHolder, DailyRewardsScreen.RewardInfo rewardInfo, Context context) {
        Integer explicitRewardDay = explicitRewardDay(rewardInfo);
        if (explicitRewardDay != null) {
            final int intValue = explicitRewardDay.intValue();
            octoberStreetRewardItemBinding.restoreButton.setVisibility(0);
            octoberStreetRewardItemBinding.restoreButton.setBackground(-1);
            CustomCardView restoreButton = octoberStreetRewardItemBinding.restoreButton;
            Intrinsics.checkNotNullExpressionValue(restoreButton, "restoreButton");
            CustomCardView.changeValidate$default(restoreButton, true, 0.0f, 2, null);
            octoberStreetRewardItemBinding.restoreCoin.setVisibility(8);
            octoberStreetRewardItemBinding.restorePrice.setTextColor(Color.parseColor("#21170E"));
            octoberStreetRewardItemBinding.restorePrice.setText(context.getString(R.string.october_street_claim));
            octoberStreetRewardItemBinding.restoreButton.setContentDescription(context.getString(R.string.october_street_claim));
            octoberStreetRewardItemBinding.restoreButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.calendar.RewardsAdapter$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RewardsAdapter.bindOctoberClaim$lambda$0(RewardsAdapter.OctoberViewHolder.this, this, intValue, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void bindOctoberClaim$lambda$0(OctoberViewHolder octoberViewHolder, RewardsAdapter rewardsAdapter, int i, View view) {
        Integer state;
        OnRewardItemClickListener onRewardItemClickListener;
        int bindingAdapterPosition = octoberViewHolder.getBindingAdapterPosition();
        DailyRewardsScreen.RewardInfo rewardInfo = (DailyRewardsScreen.RewardInfo) CollectionsKt.getOrNull(rewardsAdapter.rewardsList, bindingAdapterPosition);
        Integer explicitRewardDay = rewardInfo != null ? rewardsAdapter.explicitRewardDay(rewardInfo) : null;
        if (rewardsAdapter.presentation != Presentation.OCTOBER_STREET || !rewardsAdapter.isArizona || bindingAdapterPosition == -1 || rewardInfo == null || (state = rewardInfo.getState()) == null || state.intValue() != 2 || explicitRewardDay == null || explicitRewardDay.intValue() != i || (onRewardItemClickListener = rewardsAdapter.rewardItemClickListener) == null) {
            return;
        }
        onRewardItemClickListener.onClaimRewardClick(i);
    }

    private final int rewardDayForDisplay(int i, DailyRewardsScreen.RewardInfo rewardInfo) {
        Integer explicitRewardDay;
        if (rewardInfo.getState() != null && (explicitRewardDay = explicitRewardDay(rewardInfo)) != null) {
            return explicitRewardDay.intValue();
        }
        return i + 1;
    }

    private final Integer explicitRewardDay(DailyRewardsScreen.RewardInfo rewardInfo) {
        Integer day = rewardInfo.getDay();
        if (day == null || day.intValue() <= 0) {
            day = null;
        }
        Integer id = rewardInfo.getId();
        if (id == null || id.intValue() <= 0) {
            id = null;
        }
        if (day == null || id == null || Intrinsics.areEqual(day, id)) {
            return day == null ? id : day;
        }
        return null;
    }

    private final void resetOctoberRewardLayout(OctoberStreetRewardItemBinding octoberStreetRewardItemBinding) {
        Resources resources = octoberStreetRewardItemBinding.getRoot().getResources();
        ViewGroup.LayoutParams layoutParams = octoberStreetRewardItemBinding.rewardIcon.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.width = resources.getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._71sdp);
            layoutParams2.height = resources.getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._71sdp);
            layoutParams2.topMargin = resources.getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._9sdp);
            octoberStreetRewardItemBinding.rewardIcon.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = octoberStreetRewardItemBinding.rewardName.getLayoutParams();
        FrameLayout.LayoutParams layoutParams4 = layoutParams3 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams3 : null;
        if (layoutParams4 != null) {
            layoutParams4.height = resources.getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._22sdp);
            layoutParams4.topMargin = resources.getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._80sdp);
            octoberStreetRewardItemBinding.rewardName.setLayoutParams(layoutParams4);
        }
        ViewGroup.LayoutParams layoutParams5 = octoberStreetRewardItemBinding.genericChest.getLayoutParams();
        FrameLayout.LayoutParams layoutParams6 = layoutParams5 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams5 : null;
        if (layoutParams6 != null) {
            layoutParams6.height = resources.getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._83sdp);
            layoutParams6.topMargin = resources.getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._17sdp);
            octoberStreetRewardItemBinding.genericChest.setLayoutParams(layoutParams6);
        }
        ViewGroup.LayoutParams layoutParams7 = octoberStreetRewardItemBinding.restoreButton.getLayoutParams();
        FrameLayout.LayoutParams layoutParams8 = layoutParams7 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams7 : null;
        if (layoutParams8 != null) {
            layoutParams8.bottomMargin = resources.getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._11sdp);
            octoberStreetRewardItemBinding.restoreButton.setLayoutParams(layoutParams8);
        }
    }

    private final void setOctoberReadyLayout(OctoberStreetRewardItemBinding octoberStreetRewardItemBinding) {
        Resources resources = octoberStreetRewardItemBinding.getRoot().getResources();
        ViewGroup.LayoutParams layoutParams = octoberStreetRewardItemBinding.rewardIcon.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.width = resources.getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._60sdp);
            layoutParams2.height = resources.getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._60sdp);
            layoutParams2.topMargin = resources.getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._4sdp);
            octoberStreetRewardItemBinding.rewardIcon.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = octoberStreetRewardItemBinding.rewardName.getLayoutParams();
        FrameLayout.LayoutParams layoutParams4 = layoutParams3 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams3 : null;
        if (layoutParams4 != null) {
            layoutParams4.height = resources.getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._20sdp);
            layoutParams4.topMargin = resources.getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._66sdp);
            octoberStreetRewardItemBinding.rewardName.setLayoutParams(layoutParams4);
        }
        ViewGroup.LayoutParams layoutParams5 = octoberStreetRewardItemBinding.restoreButton.getLayoutParams();
        FrameLayout.LayoutParams layoutParams6 = layoutParams5 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams5 : null;
        if (layoutParams6 != null) {
            layoutParams6.bottomMargin = resources.getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._5sdp);
            octoberStreetRewardItemBinding.restoreButton.setLayoutParams(layoutParams6);
        }
    }

    private final void showOctoberReward(OctoberViewHolder octoberViewHolder, DailyRewardsScreen.RewardInfo rewardInfo, boolean z) {
        Job launch$default;
        OctoberStreetRewardItemBinding binding = octoberViewHolder.getBinding();
        String image = rewardInfo.getImage();
        binding.rewardIcon.setVisibility(0);
        String str = image;
        if (str != null && !StringsKt.isBlank(str)) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new RewardsAdapter$showOctoberReward$1(binding, image, null), 3, null);
            octoberViewHolder.setLoadImageJob(launch$default);
        } else {
            binding.rewardIcon.setImageResource(R.drawable.october_street_chest);
        }
        if (z) {
            String title = rewardInfo.getTitle();
            if (title != null && !StringsKt.isBlank(title)) {
                binding.rewardName.setVisibility(0);
                binding.rewardName.setText(title);
            }
            if (rewardInfo.getAmount() > 0) {
                binding.rewardCountContainer.setVisibility(0);
                binding.rewardCount.setText(binding.getRoot().getContext().getString(R.string.october_street_amount, Integer.valueOf(rewardInfo.getAmount())));
            }
        }
    }

    private final void showOctoberChest(OctoberStreetRewardItemBinding octoberStreetRewardItemBinding, int i) {
        octoberStreetRewardItemBinding.genericChest.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = octoberStreetRewardItemBinding.genericChest.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.topMargin = octoberStreetRewardItemBinding.getRoot().getResources().getDimensionPixelSize(i);
            octoberStreetRewardItemBinding.genericChest.setLayoutParams(layoutParams2);
        }
    }

    private final void showOctoberNotice(OctoberStreetRewardItemBinding octoberStreetRewardItemBinding, String str) {
        Resources resources = octoberStreetRewardItemBinding.getRoot().getResources();
        octoberStreetRewardItemBinding.rewardName.setVisibility(0);
        octoberStreetRewardItemBinding.rewardName.setText(str);
        ViewGroup.LayoutParams layoutParams = octoberStreetRewardItemBinding.rewardName.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.height = resources.getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._22sdp);
            layoutParams2.topMargin = resources.getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._4sdp);
            octoberStreetRewardItemBinding.rewardName.setLayoutParams(layoutParams2);
        }
        octoberStreetRewardItemBinding.genericChest.setVisibility(0);
        ViewGroup.LayoutParams layoutParams3 = octoberStreetRewardItemBinding.genericChest.getLayoutParams();
        FrameLayout.LayoutParams layoutParams4 = layoutParams3 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams3 : null;
        if (layoutParams4 != null) {
            layoutParams4.height = resources.getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._83sdp);
            layoutParams4.topMargin = resources.getDimensionPixelSize(ru.mrlargha.commonui.R.dimen._17sdp);
            octoberStreetRewardItemBinding.genericChest.setLayoutParams(layoutParams4);
        }
    }

    private final RestoreCurrency restoreCurrencyFor(DailyRewardsScreen.RewardInfo rewardInfo) {
        String restoreCurrency = rewardInfo.getRestoreCurrency();
        if (restoreCurrency == null || Intrinsics.areEqual(restoreCurrency, "az")) {
            return RestoreCurrency.AZ;
        }
        if (Intrinsics.areEqual(restoreCurrency, "rub")) {
            return RestoreCurrency.RUB;
        }
        return null;
    }

    private final RestoreCurrency explicitRestoreCurrencyFor(DailyRewardsScreen.RewardInfo rewardInfo) {
        Integer currency = rewardInfo.getCurrency();
        if (currency != null && currency.intValue() == 1) {
            return RestoreCurrency.AZ;
        }
        if (currency != null && currency.intValue() == 2) {
            return RestoreCurrency.RUB;
        }
        return null;
    }

    private final void bindRestoreCurrency(OctoberStreetRewardItemBinding octoberStreetRewardItemBinding, RestoreCurrency restoreCurrency) {
        int i = WhenMappings.$EnumSwitchMapping$1[restoreCurrency.ordinal()];
        if (i == 1) {
            octoberStreetRewardItemBinding.restoreCoin.setImageResource(R.drawable.october_street_az_coin);
            octoberStreetRewardItemBinding.restoreCoin.clearColorFilter();
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            octoberStreetRewardItemBinding.restoreCoin.setImageResource(ru.mrlargha.commonui.R.drawable.donate_paypass_ic_ruble);
            octoberStreetRewardItemBinding.restoreCoin.setColorFilter(Color.parseColor("#21170E"));
        }
    }

    private final String formatRemainingTime(Context context, int i) {
        int coerceAtLeast = RangesKt.coerceAtLeast(i, 0);
        int i2 = coerceAtLeast / 86400;
        int i3 = (coerceAtLeast % 86400) / 3600;
        int i4 = (coerceAtLeast % 3600) / 60;
        ArrayList arrayList = new ArrayList();
        if (i2 > 0) {
            arrayList.add(context.getResources().getQuantityString(R.plurals.october_street_days, i2, Integer.valueOf(i2)));
        }
        if (i3 > 0) {
            arrayList.add(context.getResources().getQuantityString(R.plurals.october_street_hours, i3, Integer.valueOf(i3)));
        }
        if (i4 > 0 || arrayList.isEmpty()) {
            arrayList.add(context.getResources().getQuantityString(R.plurals.october_street_minutes, i4, Integer.valueOf(i4)));
        }
        return CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, null, 62, null);
    }

    private final void setOctoberCardColors(CustomCardView customCardView, CustomCardView customCardView2, String str, String str2, String str3) {
        customCardView.setBackground(Color.parseColor(str));
        customCardView.setBorder(Color.parseColor("#FF9F32"));
        customCardView2.setRadialGradientTransform(OCTOBER_STREET_RADIAL_GRADIENT_TRANSFORM);
        CustomCardView.setBackground$default(customCardView2, Color.parseColor(str2), Color.parseColor(str3), null, CustomCardView.GradientType.RADIAL, 4, null);
        customCardView2.setBorder(Color.parseColor("#FF9F32"));
    }

    /* compiled from: RewardsAdapter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/feature/calendar/RewardsAdapter$Companion;", "", "<init>", "()V", "OCTOBER_STREET_RADIAL_GRADIENT_TRANSFORM", "Landroid/graphics/Matrix;", "getOCTOBER_STREET_RADIAL_GRADIENT_TRANSFORM", "()Landroid/graphics/Matrix;", "calendar"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Matrix getOCTOBER_STREET_RADIAL_GRADIENT_TRANSFORM() {
            return RewardsAdapter.OCTOBER_STREET_RADIAL_GRADIENT_TRANSFORM;
        }
    }

    static {
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{-0.03249917f, 0.61748457f, 0.2075073f, -0.61748457f, -0.03249917f, 0.8249919f, 0.0f, 0.0f, 1.0f});
        OCTOBER_STREET_RADIAL_GRADIENT_TRANSFORM = matrix;
    }

    private final void checkLegacyRewardType(DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo, DailyRewardsRewardItemBinding dailyRewardsRewardItemBinding, int i) {
        int i2 = WhenMappings.$EnumSwitchMapping$3[this.rewardType.ordinal()];
        if (i2 == 1) {
            if (updatePlayerInfo.getCurrentDay() == i + 1) {
                dailyRewardsRewardItemBinding.getButtonText.setTextColor(-1);
                dailyRewardsRewardItemBinding.dayTitle.setTextColor(-1);
                dailyRewardsRewardItemBinding.mainContainer.setBackgroundResource(R.drawable.daily_reward_item_current_day_bg);
                dailyRewardsRewardItemBinding.dayContainer.setBackgroundColor(Color.parseColor("#CE8235"));
                dailyRewardsRewardItemBinding.getButton.setBackgroundColor(Color.parseColor("#CE8235"));
            } else if (updatePlayerInfo.getCurrentDay() <= i) {
                dailyRewardsRewardItemBinding.getButtonText.setTextColor(-1);
                dailyRewardsRewardItemBinding.dayTitle.setTextColor(-1);
                dailyRewardsRewardItemBinding.mainContainer.setBackgroundResource(R.drawable.daily_reward_may_item_bg);
                dailyRewardsRewardItemBinding.dayContainer.setBackgroundColor(Color.parseColor("#3D4623"));
            }
        } else if (i2 == 2) {
            if (updatePlayerInfo.getCurrentDay() == i + 1) {
                dailyRewardsRewardItemBinding.getButtonText.setTextColor(-1);
                dailyRewardsRewardItemBinding.dayTitle.setTextColor(-1);
                dailyRewardsRewardItemBinding.mainContainer.setBackgroundResource(R.drawable.daily_reward_item_current_day_bg);
                dailyRewardsRewardItemBinding.dayContainer.setBackgroundColor(Color.parseColor("#CE8235"));
                dailyRewardsRewardItemBinding.getButton.setBackgroundColor(Color.parseColor("#CE8235"));
            } else if (updatePlayerInfo.getCurrentDay() <= i) {
                dailyRewardsRewardItemBinding.getButtonText.setTextColor(-1);
                dailyRewardsRewardItemBinding.dayTitle.setTextColor(-1);
                dailyRewardsRewardItemBinding.mainContainer.setBackgroundResource(R.drawable.daily_reward_autumn_item_bg);
                dailyRewardsRewardItemBinding.dayContainer.setBackgroundColor(Color.parseColor("#876836"));
            }
        } else if (i2 == 3) {
            if (updatePlayerInfo.getCurrentDay() == i + 1) {
                dailyRewardsRewardItemBinding.getButtonText.setTextColor(-1);
                dailyRewardsRewardItemBinding.dayTitle.setTextColor(-1);
                dailyRewardsRewardItemBinding.mainContainer.setBackgroundResource(R.drawable.daily_reward_item_current_day_bg);
                dailyRewardsRewardItemBinding.dayContainer.setBackgroundColor(Color.parseColor("#CE8235"));
                dailyRewardsRewardItemBinding.getButton.setBackgroundColor(Color.parseColor("#CE8235"));
            } else if (updatePlayerInfo.getCurrentDay() <= i) {
                dailyRewardsRewardItemBinding.getButtonText.setTextColor(-1);
                dailyRewardsRewardItemBinding.dayTitle.setTextColor(-1);
                dailyRewardsRewardItemBinding.mainContainer.setBackgroundResource(R.drawable.daily_reward_welcom_item_bg);
                dailyRewardsRewardItemBinding.dayContainer.setBackgroundColor(Color.parseColor("#201E3D"));
            } else {
                dailyRewardsRewardItemBinding.getButtonText.setTextColor(-1);
                dailyRewardsRewardItemBinding.dayTitle.setTextColor(-1);
                dailyRewardsRewardItemBinding.mainContainer.setBackgroundResource(R.drawable.daily_rewerd_item_get_bg);
                dailyRewardsRewardItemBinding.dayContainer.setBackgroundColor(Color.parseColor("#569647"));
            }
        } else if (i2 == 4) {
            if (updatePlayerInfo.getCurrentDay() == i + 1) {
                dailyRewardsRewardItemBinding.getButtonText.setTextColor(-1);
                dailyRewardsRewardItemBinding.dayTitle.setTextColor(-1);
                dailyRewardsRewardItemBinding.mainContainer.setBackgroundResource(R.drawable.daily_reward_item_current_day_bg);
                dailyRewardsRewardItemBinding.dayContainer.setBackgroundColor(Color.parseColor("#CE8235"));
                dailyRewardsRewardItemBinding.getButton.setBackgroundColor(Color.parseColor("#CE8235"));
            } else if (updatePlayerInfo.getCurrentDay() <= i) {
                dailyRewardsRewardItemBinding.getButtonText.setTextColor(-1);
                dailyRewardsRewardItemBinding.dayTitle.setTextColor(-1);
                dailyRewardsRewardItemBinding.mainContainer.setBackgroundResource(R.drawable.daily_reward_rodina_car_1_item_bg);
                dailyRewardsRewardItemBinding.dayContainer.setBackgroundColor(Color.parseColor("#281410"));
            }
        } else if (i2 != 5) {
        } else {
            if (updatePlayerInfo.getCurrentDay() == i + 1) {
                dailyRewardsRewardItemBinding.getButtonText.setTextColor(-1);
                dailyRewardsRewardItemBinding.dayTitle.setTextColor(-1);
                dailyRewardsRewardItemBinding.mainContainer.setBackgroundResource(R.drawable.daily_reward_item_current_day_bg);
                dailyRewardsRewardItemBinding.dayContainer.setBackgroundColor(Color.parseColor("#CE8235"));
                dailyRewardsRewardItemBinding.getButton.setBackgroundColor(Color.parseColor("#CE8235"));
            } else if (updatePlayerInfo.getCurrentDay() <= i) {
                dailyRewardsRewardItemBinding.getButtonText.setTextColor(-1);
                dailyRewardsRewardItemBinding.dayTitle.setTextColor(-1);
                dailyRewardsRewardItemBinding.mainContainer.setBackgroundResource(R.drawable.daily_reward_rodina_car_2_item_bg);
                dailyRewardsRewardItemBinding.dayContainer.setBackgroundColor(Color.parseColor("#0C2840"));
            }
        }
    }

    public final void addRewards(List<DailyRewardsScreen.RewardInfo> rewards) {
        Intrinsics.checkNotNullParameter(rewards, "rewards");
        this.rewardsList.clear();
        this.rewardsList.addAll(rewards);
    }

    public final void updateRewards(DailyRewardsScreen.UpdatePlayerInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.updateInfo = info;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof LegacyViewHolder) {
            ((LegacyViewHolder) holder).cancelImageLoad();
        } else if (holder instanceof OctoberViewHolder) {
            ((OctoberViewHolder) holder).cancelImageLoad();
        }
        super.onViewRecycled(holder);
    }

    /* compiled from: RewardsAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lru/mrlargha/feature/calendar/RewardsAdapter$LegacyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/feature/calendar/databinding/DailyRewardsRewardItemBinding;", "getBinding", "()Lru/mrlargha/feature/calendar/databinding/DailyRewardsRewardItemBinding;", "loadImageJob", "Lkotlinx/coroutines/Job;", "getLoadImageJob", "()Lkotlinx/coroutines/Job;", "setLoadImageJob", "(Lkotlinx/coroutines/Job;)V", "cancelImageLoad", "", "calendar"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class LegacyViewHolder extends RecyclerView.ViewHolder {
        private final DailyRewardsRewardItemBinding binding;
        private Job loadImageJob;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LegacyViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            DailyRewardsRewardItemBinding bind = DailyRewardsRewardItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final DailyRewardsRewardItemBinding getBinding() {
            return this.binding;
        }

        public final Job getLoadImageJob() {
            return this.loadImageJob;
        }

        public final void setLoadImageJob(Job job) {
            this.loadImageJob = job;
        }

        public final void cancelImageLoad() {
            Job job = this.loadImageJob;
            if (job != null) {
                Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.loadImageJob = null;
        }
    }

    /* compiled from: RewardsAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lru/mrlargha/feature/calendar/RewardsAdapter$OctoberViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/feature/calendar/databinding/OctoberStreetRewardItemBinding;", "getBinding", "()Lru/mrlargha/feature/calendar/databinding/OctoberStreetRewardItemBinding;", "loadImageJob", "Lkotlinx/coroutines/Job;", "getLoadImageJob", "()Lkotlinx/coroutines/Job;", "setLoadImageJob", "(Lkotlinx/coroutines/Job;)V", "cancelImageLoad", "", "calendar"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class OctoberViewHolder extends RecyclerView.ViewHolder {
        private final OctoberStreetRewardItemBinding binding;
        private Job loadImageJob;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OctoberViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            OctoberStreetRewardItemBinding bind = OctoberStreetRewardItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final OctoberStreetRewardItemBinding getBinding() {
            return this.binding;
        }

        public final Job getLoadImageJob() {
            return this.loadImageJob;
        }

        public final void setLoadImageJob(Job job) {
            this.loadImageJob = job;
        }

        public final void cancelImageLoad() {
            Job job = this.loadImageJob;
            if (job != null) {
                Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.loadImageJob = null;
        }
    }
}
