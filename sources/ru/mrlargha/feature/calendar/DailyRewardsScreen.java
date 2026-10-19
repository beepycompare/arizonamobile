package ru.mrlargha.feature.calendar;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.arizona.common.utils.EasyAnimation;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.miami.game.core.firebase.notification.NotificationStatsPayloadFactory;
import io.appmetrica.analytics.impl.M2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.utils.ConverterKt;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.feature.calendar.RewardsAdapter;
import ru.mrlargha.feature.calendar.databinding.DailyRewardsLayoutBinding;
import ru.mrlargha.feature.calendar.databinding.OctoberStreetLayoutBinding;
/* compiled from: DailyRewardsScreen.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0005,-./0B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0016H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0010H\u0002J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u0010H\u0002J\b\u0010$\u001a\u00020\u0016H\u0002J\u0018\u0010%\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0005H\u0016J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001e\u001a\u00020&H\u0002J\u0017\u0010)\u001a\u0004\u0018\u00010\u00162\u0006\u0010*\u001a\u00020\u0014H\u0002¢\u0006\u0002\u0010+R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lru/mrlargha/feature/calendar/DailyRewardsScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "legacyScreenLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "screenLayout", "Landroid/widget/FrameLayout;", "binding", "Lru/mrlargha/feature/calendar/databinding/DailyRewardsLayoutBinding;", "octoberBinding", "Lru/mrlargha/feature/calendar/databinding/OctoberStreetLayoutBinding;", "rewardsAdapter", "Lru/mrlargha/feature/calendar/RewardsAdapter;", "isOctoberStreet", "", "setRewardsInfo", "", "rewards", "", "Lru/mrlargha/feature/calendar/DailyRewardsScreen$RewardInfo;", "updateInfo", "info", "Lru/mrlargha/feature/calendar/DailyRewardsScreen$UpdatePlayerInfo;", "updateMainInfo", "data", "Lru/mrlargha/feature/calendar/DailyRewardsScreen$ScreenDataInfo;", "showOctoberStreet", "showLegacy", "obtainOctoberBinding", "configureOctoberInsets", "updateOctoberScrollbar", "onBackendMessageHandled", "", "subId", "parseArizonaRewards", "setVisibleDetail", "isVisible", "(Z)Lkotlin/Unit;", "RewardInfo", "UpdatePlayerInfo", "ScreenDataInfo", "BackgroundType", "Spawner", "calendar"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DailyRewardsScreen extends SAMPUIElement {
    private final DailyRewardsLayoutBinding binding;
    private boolean isOctoberStreet;
    private final View legacyScreenLayout;
    private OctoberStreetLayoutBinding octoberBinding;
    private final RewardsAdapter rewardsAdapter;
    private final FrameLayout screenLayout;

    /* compiled from: DailyRewardsScreen.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BackgroundType.values().length];
            try {
                iArr[BackgroundType.DAILY_REWARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BackgroundType.NEW_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BackgroundType.MAY_REWARD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BackgroundType.AUTUMN_REWARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BackgroundType.WELCOME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[BackgroundType.RODINA_CAR_1.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[BackgroundType.RODINA_CAR_2.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[BackgroundType.OCTOBER_STREET.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyRewardsScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        DailyRewardsLayoutBinding dailyRewardsLayoutBinding = null;
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.daily_rewards_layout, (ViewGroup) null);
        this.legacyScreenLayout = inflate;
        FrameLayout frameLayout = new FrameLayout(targetActivity);
        frameLayout.setId(View.generateViewId());
        frameLayout.addView(inflate, new FrameLayout.LayoutParams(-1, -1));
        this.screenLayout = frameLayout;
        try {
            dailyRewardsLayoutBinding = DailyRewardsLayoutBinding.bind(inflate);
        } catch (NullPointerException e) {
            Log.e("Binding", "daily rewards layout is incomplete", e);
        }
        this.binding = dailyRewardsLayoutBinding;
        RewardsAdapter rewardsAdapter = new RewardsAdapter(UtilsKt.isArizonaType());
        this.rewardsAdapter = rewardsAdapter;
        SAMPUIElement.addViewToConstraintLayout$default(this, this.screenLayout, -1, -1, false, 8, null);
        if (dailyRewardsLayoutBinding != null) {
            dailyRewardsLayoutBinding.rewardsRc.setAdapter(rewardsAdapter);
            EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
            ImageView exitButton = dailyRewardsLayoutBinding.exitButton;
            Intrinsics.checkNotNullExpressionValue(exitButton, "exitButton");
            EasyAnimation.animateClick$default(easyAnimation, exitButton, 0L, new Function0() { // from class: ru.mrlargha.feature.calendar.DailyRewardsScreen$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DailyRewardsScreen.lambda$0$0(DailyRewardsScreen.this);
                }
            }, null, 5, null);
        }
        rewardsAdapter.setOnRewardItemClickListener(new RewardsAdapter.OnRewardItemClickListener() { // from class: ru.mrlargha.feature.calendar.DailyRewardsScreen.2
            @Override // ru.mrlargha.feature.calendar.RewardsAdapter.OnRewardItemClickListener
            public void onRewardItemClickListener(int i2) {
                if (i2 == 0) {
                    SAMPUIElement.notifyClick$default(DailyRewardsScreen.this, 0, 1, null, 4, null);
                }
            }

            @Override // ru.mrlargha.feature.calendar.RewardsAdapter.OnRewardItemClickListener
            public void onClaimRewardClick(int i2) {
                DailyRewardsScreen.this.notifyClick(0, 1, "{\"day\":" + i2 + "}");
            }

            @Override // ru.mrlargha.feature.calendar.RewardsAdapter.OnRewardItemClickListener
            public void onRestoreRewardClick(int i2) {
                DailyRewardsScreen.this.notifyClick(0, 2, "{\"day\":" + i2 + "}");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(DailyRewardsScreen dailyRewardsScreen) {
        SAMPUIElement.notifyClick$default(dailyRewardsScreen, 0, 0, null, 4, null);
        return Unit.INSTANCE;
    }

    private final void setRewardsInfo(List<RewardInfo> list) {
        LeftFadingEdgeRecyclerView leftFadingEdgeRecyclerView;
        LeftFadingEdgeRecyclerView leftFadingEdgeRecyclerView2;
        RecyclerView.RecycledViewPool recycledViewPool;
        RecyclerView recyclerView;
        RecyclerView.RecycledViewPool recycledViewPool2;
        DailyRewardsLayoutBinding dailyRewardsLayoutBinding = this.binding;
        if (dailyRewardsLayoutBinding != null && (recyclerView = dailyRewardsLayoutBinding.rewardsRc) != null && (recycledViewPool2 = recyclerView.getRecycledViewPool()) != null) {
            recycledViewPool2.clear();
        }
        OctoberStreetLayoutBinding octoberStreetLayoutBinding = this.octoberBinding;
        if (octoberStreetLayoutBinding != null && (leftFadingEdgeRecyclerView2 = octoberStreetLayoutBinding.rewardsRc) != null && (recycledViewPool = leftFadingEdgeRecyclerView2.getRecycledViewPool()) != null) {
            recycledViewPool.clear();
        }
        this.rewardsAdapter.addRewards(list);
        this.rewardsAdapter.notifyDataSetChanged();
        OctoberStreetLayoutBinding octoberStreetLayoutBinding2 = this.octoberBinding;
        if (octoberStreetLayoutBinding2 == null || (leftFadingEdgeRecyclerView = octoberStreetLayoutBinding2.rewardsRc) == null) {
            return;
        }
        leftFadingEdgeRecyclerView.post(new Runnable() { // from class: ru.mrlargha.feature.calendar.DailyRewardsScreen$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DailyRewardsScreen.this.updateOctoberScrollbar();
            }
        });
    }

    private final void updateInfo(UpdatePlayerInfo updatePlayerInfo) {
        this.rewardsAdapter.updateRewards(updatePlayerInfo);
    }

    private final void updateMainInfo(ScreenDataInfo screenDataInfo) {
        BackgroundType fromType = BackgroundType.Companion.fromType(screenDataInfo.getBackground());
        if (UtilsKt.isArizonaType() && fromType == BackgroundType.OCTOBER_STREET) {
            showOctoberStreet();
            return;
        }
        showLegacy();
        DailyRewardsLayoutBinding dailyRewardsLayoutBinding = this.binding;
        if (dailyRewardsLayoutBinding != null) {
            dailyRewardsLayoutBinding.title.setText(screenDataInfo.getHeader());
            switch (WhenMappings.$EnumSwitchMapping$0[fromType.ordinal()]) {
                case 1:
                    dailyRewardsLayoutBinding.getRoot().setBackgroundResource(R.drawable.daily_reward_bg);
                    setVisibleDetail(true);
                    this.rewardsAdapter.setLegacyRewardType(BackgroundType.DAILY_REWARD);
                    return;
                case 2:
                    dailyRewardsLayoutBinding.getRoot().setBackgroundResource(R.drawable.new_year_reward_bg);
                    setVisibleDetail(true);
                    this.rewardsAdapter.setLegacyRewardType(BackgroundType.DAILY_REWARD);
                    return;
                case 3:
                    dailyRewardsLayoutBinding.getRoot().setBackgroundResource(R.drawable.daily_rewards_may_bg);
                    setVisibleDetail(false);
                    this.rewardsAdapter.setLegacyRewardType(BackgroundType.MAY_REWARD);
                    return;
                case 4:
                    dailyRewardsLayoutBinding.getRoot().setBackgroundResource(R.drawable.autumn_reward_bg);
                    setVisibleDetail(false);
                    this.rewardsAdapter.setLegacyRewardType(BackgroundType.AUTUMN_REWARD);
                    return;
                case 5:
                    dailyRewardsLayoutBinding.getRoot().setBackgroundResource(R.drawable.daily_reward_welcom_bg);
                    setVisibleDetail(false);
                    this.rewardsAdapter.setLegacyRewardType(BackgroundType.WELCOME);
                    return;
                case 6:
                    dailyRewardsLayoutBinding.getRoot().setBackgroundResource(R.drawable.calendar_rodina_car_1);
                    setVisibleDetail(false);
                    this.rewardsAdapter.setLegacyRewardType(BackgroundType.RODINA_CAR_1);
                    return;
                case 7:
                    dailyRewardsLayoutBinding.getRoot().setBackgroundResource(R.drawable.calendar_rodina_car_2);
                    setVisibleDetail(false);
                    this.rewardsAdapter.setLegacyRewardType(BackgroundType.RODINA_CAR_2);
                    return;
                case 8:
                    dailyRewardsLayoutBinding.getRoot().setBackgroundResource(R.drawable.daily_reward_bg);
                    setVisibleDetail(true);
                    this.rewardsAdapter.setLegacyRewardType(BackgroundType.DAILY_REWARD);
                    return;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    private final void showOctoberStreet() {
        ConstraintLayout root;
        RecyclerView recyclerView;
        OctoberStreetLayoutBinding obtainOctoberBinding = obtainOctoberBinding();
        if (!this.isOctoberStreet) {
            DailyRewardsLayoutBinding dailyRewardsLayoutBinding = this.binding;
            if (dailyRewardsLayoutBinding != null && (recyclerView = dailyRewardsLayoutBinding.rewardsRc) != null) {
                if (recyclerView.getAdapter() != this.rewardsAdapter) {
                    recyclerView = null;
                }
                if (recyclerView != null) {
                    recyclerView.setAdapter(null);
                }
            }
            this.rewardsAdapter.setPresentation(RewardsAdapter.Presentation.OCTOBER_STREET);
            obtainOctoberBinding.rewardsRc.setAdapter(this.rewardsAdapter);
            this.isOctoberStreet = true;
        }
        DailyRewardsLayoutBinding dailyRewardsLayoutBinding2 = this.binding;
        if (dailyRewardsLayoutBinding2 != null && (root = dailyRewardsLayoutBinding2.getRoot()) != null) {
            root.setVisibility(8);
        }
        FrameLayout root2 = obtainOctoberBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        root2.setVisibility(0);
        obtainOctoberBinding.rewardsRc.post(new Runnable() { // from class: ru.mrlargha.feature.calendar.DailyRewardsScreen$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                DailyRewardsScreen.this.updateOctoberScrollbar();
            }
        });
    }

    private final void showLegacy() {
        ConstraintLayout root;
        FrameLayout root2;
        RecyclerView recyclerView;
        LeftFadingEdgeRecyclerView leftFadingEdgeRecyclerView;
        if (this.isOctoberStreet) {
            OctoberStreetLayoutBinding octoberStreetLayoutBinding = this.octoberBinding;
            if (octoberStreetLayoutBinding != null && (leftFadingEdgeRecyclerView = octoberStreetLayoutBinding.rewardsRc) != null) {
                if (leftFadingEdgeRecyclerView.getAdapter() != this.rewardsAdapter) {
                    leftFadingEdgeRecyclerView = null;
                }
                if (leftFadingEdgeRecyclerView != null) {
                    leftFadingEdgeRecyclerView.setAdapter(null);
                }
            }
            this.rewardsAdapter.setPresentation(RewardsAdapter.Presentation.LEGACY);
            DailyRewardsLayoutBinding dailyRewardsLayoutBinding = this.binding;
            if (dailyRewardsLayoutBinding != null && (recyclerView = dailyRewardsLayoutBinding.rewardsRc) != null) {
                recyclerView.setAdapter(this.rewardsAdapter);
            }
            this.isOctoberStreet = false;
        }
        OctoberStreetLayoutBinding octoberStreetLayoutBinding2 = this.octoberBinding;
        if (octoberStreetLayoutBinding2 != null && (root2 = octoberStreetLayoutBinding2.getRoot()) != null) {
            root2.setVisibility(8);
        }
        DailyRewardsLayoutBinding dailyRewardsLayoutBinding2 = this.binding;
        if (dailyRewardsLayoutBinding2 == null || (root = dailyRewardsLayoutBinding2.getRoot()) == null) {
            return;
        }
        root.setVisibility(0);
    }

    private final OctoberStreetLayoutBinding obtainOctoberBinding() {
        OctoberStreetLayoutBinding octoberStreetLayoutBinding = this.octoberBinding;
        if (octoberStreetLayoutBinding != null) {
            return octoberStreetLayoutBinding;
        }
        OctoberStreetLayoutBinding inflate = OctoberStreetLayoutBinding.inflate(getTargetActivity().getLayoutInflater(), this.screenLayout, false);
        inflate.rewardsRc.setLayoutManager(new LinearLayoutManager(getTargetActivity(), 0, false));
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ImageView exitButton = inflate.exitButton;
        Intrinsics.checkNotNullExpressionValue(exitButton, "exitButton");
        EasyAnimation.animateClick$default(easyAnimation, exitButton, 0L, new Function0() { // from class: ru.mrlargha.feature.calendar.DailyRewardsScreen$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit obtainOctoberBinding$lambda$1$0;
                obtainOctoberBinding$lambda$1$0 = DailyRewardsScreen.obtainOctoberBinding$lambda$1$0(DailyRewardsScreen.this);
                return obtainOctoberBinding$lambda$1$0;
            }
        }, null, 5, null);
        inflate.rewardsRc.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ru.mrlargha.feature.calendar.DailyRewardsScreen$obtainOctoberBinding$2$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                DailyRewardsScreen.this.updateOctoberScrollbar();
            }
        });
        inflate.rewardsRc.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: ru.mrlargha.feature.calendar.DailyRewardsScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                DailyRewardsScreen.this.updateOctoberScrollbar();
            }
        });
        Intrinsics.checkNotNull(inflate);
        configureOctoberInsets(inflate);
        this.screenLayout.addView(inflate.getRoot(), new FrameLayout.LayoutParams(-1, -1));
        this.octoberBinding = inflate;
        ViewCompat.requestApplyInsets(inflate.getRoot());
        Intrinsics.checkNotNullExpressionValue(inflate, "also(...)");
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit obtainOctoberBinding$lambda$1$0(DailyRewardsScreen dailyRewardsScreen) {
        SAMPUIElement.notifyClick$default(dailyRewardsScreen, 0, 0, null, 4, null);
        return Unit.INSTANCE;
    }

    private final void configureOctoberInsets(final OctoberStreetLayoutBinding octoberStreetLayoutBinding) {
        ViewGroup.LayoutParams layoutParams = octoberStreetLayoutBinding.headerContainer.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        final int i = layoutParams2.topMargin;
        final int marginEnd = layoutParams2.getMarginEnd();
        final int paddingStart = octoberStreetLayoutBinding.contentContainer.getPaddingStart();
        final int paddingTop = octoberStreetLayoutBinding.contentContainer.getPaddingTop();
        final int paddingEnd = octoberStreetLayoutBinding.contentContainer.getPaddingEnd();
        final int paddingBottom = octoberStreetLayoutBinding.contentContainer.getPaddingBottom();
        ViewCompat.setOnApplyWindowInsetsListener(octoberStreetLayoutBinding.getRoot(), new OnApplyWindowInsetsListener() { // from class: ru.mrlargha.feature.calendar.DailyRewardsScreen$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return DailyRewardsScreen.configureOctoberInsets$lambda$0(OctoberStreetLayoutBinding.this, paddingStart, paddingTop, paddingEnd, paddingBottom, i, marginEnd, view, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final WindowInsetsCompat configureOctoberInsets$lambda$0(OctoberStreetLayoutBinding octoberStreetLayoutBinding, int i, int i2, int i3, int i4, int i5, int i6, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        ViewGroup.LayoutParams layoutParams = octoberStreetLayoutBinding.headerContainer.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.topMargin = i5 + insets2.top;
            layoutParams2.setMarginEnd(i6);
            octoberStreetLayoutBinding.headerContainer.setLayoutParams(layoutParams2);
        }
        octoberStreetLayoutBinding.contentContainer.setPaddingRelative(i + insets2.left, i2, i3 + insets2.right, i4);
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateOctoberScrollbar() {
        OctoberStreetLayoutBinding octoberStreetLayoutBinding = this.octoberBinding;
        if (octoberStreetLayoutBinding == null) {
            return;
        }
        LeftFadingEdgeRecyclerView rewardsRc = octoberStreetLayoutBinding.rewardsRc;
        Intrinsics.checkNotNullExpressionValue(rewardsRc, "rewardsRc");
        int width = octoberStreetLayoutBinding.scrollbarTrack.getWidth();
        int computeHorizontalScrollRange = rewardsRc.computeHorizontalScrollRange();
        int computeHorizontalScrollExtent = rewardsRc.computeHorizontalScrollExtent();
        if (width <= 0 || computeHorizontalScrollRange <= 0 || computeHorizontalScrollExtent <= 0) {
            return;
        }
        int coerceIn = RangesKt.coerceIn((int) ((width * computeHorizontalScrollExtent) / computeHorizontalScrollRange), 1, width);
        int coerceAtLeast = RangesKt.coerceAtLeast(computeHorizontalScrollRange - computeHorizontalScrollExtent, 0);
        int i = width - coerceIn;
        int coerceIn2 = coerceAtLeast != 0 ? RangesKt.coerceIn((int) ((i * rewardsRc.computeHorizontalScrollOffset()) / coerceAtLeast), 0, i) : 0;
        ViewGroup.LayoutParams layoutParams = octoberStreetLayoutBinding.scrollbarThumb.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            if (layoutParams2.width == coerceIn && layoutParams2.leftMargin == coerceIn2) {
                return;
            }
            layoutParams2.width = coerceIn;
            layoutParams2.leftMargin = coerceIn2;
            octoberStreetLayoutBinding.scrollbarThumb.setLayoutParams(layoutParams2);
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        List<RewardInfo> listModel;
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            if (UtilsKt.isArizonaType()) {
                listModel = parseArizonaRewards(data);
            } else {
                listModel = MapperKt.toListModel(data, RewardInfo.class);
            }
            setRewardsInfo(listModel);
        } else if (i == 1) {
            updateInfo((UpdatePlayerInfo) MapperKt.toModel(data, UpdatePlayerInfo.class));
            this.rewardsAdapter.notifyDataSetChanged();
        } else if (i == 2) {
            this.rewardsAdapter.notifyDataSetChanged();
        } else if (i != 3) {
        } else {
            updateMainInfo((ScreenDataInfo) MapperKt.toModel(data, ScreenDataInfo.class));
        }
    }

    private final List<RewardInfo> parseArizonaRewards(String str) {
        List<JsonObject> listModel = MapperKt.toListModel(str, JsonObject.class);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listModel, 10));
        for (JsonObject jsonObject : listModel) {
            JsonElement jsonElement = jsonObject.get(NotificationStatsPayloadFactory.API_EVENT_RECEIVED);
            if (jsonElement != null) {
                jsonElement = (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber()) ? null : null;
                if (jsonElement != null) {
                    jsonObject.addProperty(NotificationStatsPayloadFactory.API_EVENT_RECEIVED, Boolean.valueOf(jsonElement.getAsInt() == 1));
                }
            }
            arrayList.add((RewardInfo) MapperKt.getGson().fromJson((JsonElement) jsonObject, (Class<Object>) RewardInfo.class));
        }
        return arrayList;
    }

    private final Unit setVisibleDetail(boolean z) {
        DailyRewardsLayoutBinding dailyRewardsLayoutBinding = this.binding;
        if (dailyRewardsLayoutBinding != null) {
            TextView description = dailyRewardsLayoutBinding.description;
            Intrinsics.checkNotNullExpressionValue(description, "description");
            description.setVisibility(z ? 0 : 8);
            TextView tvTips = dailyRewardsLayoutBinding.tvTips;
            Intrinsics.checkNotNullExpressionValue(tvTips, "tvTips");
            tvTips.setVisibility(z ? 0 : 8);
            ImageView prizeIc = dailyRewardsLayoutBinding.prizeIc;
            Intrinsics.checkNotNullExpressionValue(prizeIc, "prizeIc");
            prizeIc.setVisibility(z ? 0 : 8);
            ImageView infoIc = dailyRewardsLayoutBinding.infoIc;
            Intrinsics.checkNotNullExpressionValue(infoIc, "infoIc");
            infoIc.setVisibility(z ? 0 : 8);
            LinearLayout tipContainer = dailyRewardsLayoutBinding.tipContainer;
            Intrinsics.checkNotNullExpressionValue(tipContainer, "tipContainer");
            tipContainer.setVisibility(z ? 4 : 0);
            int dpToPx = z ? 0 : ConverterKt.dpToPx(150.0f, getTargetActivity());
            dailyRewardsLayoutBinding.rewardsRc.setPadding(dpToPx, 0, 0, 0);
            dailyRewardsLayoutBinding.title.setPadding(dpToPx, 0, 0, 0);
            dailyRewardsLayoutBinding.rewardsRc.setVisibility(0);
            return Unit.INSTANCE;
        }
        return null;
    }

    /* compiled from: DailyRewardsScreen.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b.\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0092\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u00101J\u0014\u00102\u001a\u00020\b2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00104\u001a\u00020\u0006HÖ\u0081\u0004J\n\u00105\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001eR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b!\u0010\u001eR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\"\u0010\u001eR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b#\u0010\u001e¨\u00066"}, d2 = {"Lru/mrlargha/feature/calendar/DailyRewardsScreen$RewardInfo;", "", "title", "", "image", "amount", "", "missed", "", "restorePrice", NotificationStatsPayloadFactory.API_EVENT_RECEIVED, "restoreCurrency", TtmlNode.ATTR_ID, "day", RemoteConfigConstants.ResponseFieldKey.STATE, FirebaseAnalytics.Param.PRICE, FirebaseAnalytics.Param.CURRENCY, "<init>", "(Ljava/lang/String;Ljava/lang/String;IZIZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getTitle", "()Ljava/lang/String;", "getImage", "getAmount", "()I", "getMissed", "()Z", "getRestorePrice", "getReceived", "getRestoreCurrency", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDay", "getState", "getPrice", "getCurrency", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;IZIZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lru/mrlargha/feature/calendar/DailyRewardsScreen$RewardInfo;", "equals", "other", "hashCode", "toString", "calendar"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class RewardInfo {
        private final int amount;
        private final Integer currency;
        private final Integer day;
        private final Integer id;
        private final String image;
        private final boolean missed;
        private final Integer price;
        private final boolean received;
        private final String restoreCurrency;
        private final int restorePrice;
        private final Integer state;
        private final String title;

        public static /* synthetic */ RewardInfo copy$default(RewardInfo rewardInfo, String str, String str2, int i, boolean z, int i2, boolean z2, String str3, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = rewardInfo.title;
            }
            if ((i3 & 2) != 0) {
                str2 = rewardInfo.image;
            }
            if ((i3 & 4) != 0) {
                i = rewardInfo.amount;
            }
            if ((i3 & 8) != 0) {
                z = rewardInfo.missed;
            }
            if ((i3 & 16) != 0) {
                i2 = rewardInfo.restorePrice;
            }
            if ((i3 & 32) != 0) {
                z2 = rewardInfo.received;
            }
            if ((i3 & 64) != 0) {
                str3 = rewardInfo.restoreCurrency;
            }
            if ((i3 & 128) != 0) {
                num = rewardInfo.id;
            }
            if ((i3 & 256) != 0) {
                num2 = rewardInfo.day;
            }
            if ((i3 & 512) != 0) {
                num3 = rewardInfo.state;
            }
            if ((i3 & 1024) != 0) {
                num4 = rewardInfo.price;
            }
            if ((i3 & 2048) != 0) {
                num5 = rewardInfo.currency;
            }
            Integer num6 = num4;
            Integer num7 = num5;
            Integer num8 = num2;
            Integer num9 = num3;
            String str4 = str3;
            Integer num10 = num;
            int i4 = i2;
            boolean z3 = z2;
            return rewardInfo.copy(str, str2, i, z, i4, z3, str4, num10, num8, num9, num6, num7);
        }

        public final String component1() {
            return this.title;
        }

        public final Integer component10() {
            return this.state;
        }

        public final Integer component11() {
            return this.price;
        }

        public final Integer component12() {
            return this.currency;
        }

        public final String component2() {
            return this.image;
        }

        public final int component3() {
            return this.amount;
        }

        public final boolean component4() {
            return this.missed;
        }

        public final int component5() {
            return this.restorePrice;
        }

        public final boolean component6() {
            return this.received;
        }

        public final String component7() {
            return this.restoreCurrency;
        }

        public final Integer component8() {
            return this.id;
        }

        public final Integer component9() {
            return this.day;
        }

        public final RewardInfo copy(String title, String image, int i, boolean z, int i2, boolean z2, String str, Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(image, "image");
            return new RewardInfo(title, image, i, z, i2, z2, str, num, num2, num3, num4, num5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RewardInfo) {
                RewardInfo rewardInfo = (RewardInfo) obj;
                return Intrinsics.areEqual(this.title, rewardInfo.title) && Intrinsics.areEqual(this.image, rewardInfo.image) && this.amount == rewardInfo.amount && this.missed == rewardInfo.missed && this.restorePrice == rewardInfo.restorePrice && this.received == rewardInfo.received && Intrinsics.areEqual(this.restoreCurrency, rewardInfo.restoreCurrency) && Intrinsics.areEqual(this.id, rewardInfo.id) && Intrinsics.areEqual(this.day, rewardInfo.day) && Intrinsics.areEqual(this.state, rewardInfo.state) && Intrinsics.areEqual(this.price, rewardInfo.price) && Intrinsics.areEqual(this.currency, rewardInfo.currency);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((((((((this.title.hashCode() * 31) + this.image.hashCode()) * 31) + Integer.hashCode(this.amount)) * 31) + Boolean.hashCode(this.missed)) * 31) + Integer.hashCode(this.restorePrice)) * 31) + Boolean.hashCode(this.received)) * 31;
            String str = this.restoreCurrency;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.id;
            int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.day;
            int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.state;
            int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.price;
            int hashCode6 = (hashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.currency;
            return hashCode6 + (num5 != null ? num5.hashCode() : 0);
        }

        public String toString() {
            String str = this.title;
            String str2 = this.image;
            int i = this.amount;
            boolean z = this.missed;
            int i2 = this.restorePrice;
            boolean z2 = this.received;
            String str3 = this.restoreCurrency;
            Integer num = this.id;
            Integer num2 = this.day;
            Integer num3 = this.state;
            Integer num4 = this.price;
            return "RewardInfo(title=" + str + ", image=" + str2 + ", amount=" + i + ", missed=" + z + ", restorePrice=" + i2 + ", received=" + z2 + ", restoreCurrency=" + str3 + ", id=" + num + ", day=" + num2 + ", state=" + num3 + ", price=" + num4 + ", currency=" + this.currency + ")";
        }

        public RewardInfo(String title, String image, int i, boolean z, int i2, boolean z2, String str, Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(image, "image");
            this.title = title;
            this.image = image;
            this.amount = i;
            this.missed = z;
            this.restorePrice = i2;
            this.received = z2;
            this.restoreCurrency = str;
            this.id = num;
            this.day = num2;
            this.state = num3;
            this.price = num4;
            this.currency = num5;
        }

        public /* synthetic */ RewardInfo(String str, String str2, int i, boolean z, int i2, boolean z2, String str3, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, i, (i3 & 8) != 0 ? false : z, (i3 & 16) != 0 ? 0 : i2, (i3 & 32) != 0 ? false : z2, (i3 & 64) != 0 ? null : str3, (i3 & 128) != 0 ? null : num, (i3 & 256) != 0 ? null : num2, (i3 & 512) != 0 ? null : num3, (i3 & 1024) != 0 ? null : num4, (i3 & 2048) != 0 ? null : num5);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getImage() {
            return this.image;
        }

        public final int getAmount() {
            return this.amount;
        }

        public final boolean getMissed() {
            return this.missed;
        }

        public final int getRestorePrice() {
            return this.restorePrice;
        }

        public final boolean getReceived() {
            return this.received;
        }

        public final String getRestoreCurrency() {
            return this.restoreCurrency;
        }

        public final Integer getId() {
            return this.id;
        }

        public final Integer getDay() {
            return this.day;
        }

        public final Integer getState() {
            return this.state;
        }

        public final Integer getPrice() {
            return this.price;
        }

        public final Integer getCurrency() {
            return this.currency;
        }
    }

    /* compiled from: DailyRewardsScreen.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lru/mrlargha/feature/calendar/DailyRewardsScreen$UpdatePlayerInfo;", "", "currentDay", "", "needToPlay", "played", NotificationStatsPayloadFactory.API_EVENT_RECEIVED, "<init>", "(IIII)V", "getCurrentDay", "()I", "getNeedToPlay", "getPlayed", "getReceived", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "calendar"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class UpdatePlayerInfo {
        private final int currentDay;
        private final int needToPlay;
        private final int played;
        private final int received;

        public static /* synthetic */ UpdatePlayerInfo copy$default(UpdatePlayerInfo updatePlayerInfo, int i, int i2, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = updatePlayerInfo.currentDay;
            }
            if ((i5 & 2) != 0) {
                i2 = updatePlayerInfo.needToPlay;
            }
            if ((i5 & 4) != 0) {
                i3 = updatePlayerInfo.played;
            }
            if ((i5 & 8) != 0) {
                i4 = updatePlayerInfo.received;
            }
            return updatePlayerInfo.copy(i, i2, i3, i4);
        }

        public final int component1() {
            return this.currentDay;
        }

        public final int component2() {
            return this.needToPlay;
        }

        public final int component3() {
            return this.played;
        }

        public final int component4() {
            return this.received;
        }

        public final UpdatePlayerInfo copy(int i, int i2, int i3, int i4) {
            return new UpdatePlayerInfo(i, i2, i3, i4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UpdatePlayerInfo) {
                UpdatePlayerInfo updatePlayerInfo = (UpdatePlayerInfo) obj;
                return this.currentDay == updatePlayerInfo.currentDay && this.needToPlay == updatePlayerInfo.needToPlay && this.played == updatePlayerInfo.played && this.received == updatePlayerInfo.received;
            }
            return false;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.currentDay) * 31) + Integer.hashCode(this.needToPlay)) * 31) + Integer.hashCode(this.played)) * 31) + Integer.hashCode(this.received);
        }

        public String toString() {
            int i = this.currentDay;
            int i2 = this.needToPlay;
            int i3 = this.played;
            return "UpdatePlayerInfo(currentDay=" + i + ", needToPlay=" + i2 + ", played=" + i3 + ", received=" + this.received + ")";
        }

        public UpdatePlayerInfo(int i, int i2, int i3, int i4) {
            this.currentDay = i;
            this.needToPlay = i2;
            this.played = i3;
            this.received = i4;
        }

        public final int getCurrentDay() {
            return this.currentDay;
        }

        public final int getNeedToPlay() {
            return this.needToPlay;
        }

        public final int getPlayed() {
            return this.played;
        }

        public final int getReceived() {
            return this.received;
        }
    }

    /* compiled from: DailyRewardsScreen.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lru/mrlargha/feature/calendar/DailyRewardsScreen$ScreenDataInfo;", "", "header", "", M2.g, "", "<init>", "(Ljava/lang/String;I)V", "getHeader", "()Ljava/lang/String;", "getBackground", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "calendar"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class ScreenDataInfo {
        private final int background;
        private final String header;

        public static /* synthetic */ ScreenDataInfo copy$default(ScreenDataInfo screenDataInfo, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = screenDataInfo.header;
            }
            if ((i2 & 2) != 0) {
                i = screenDataInfo.background;
            }
            return screenDataInfo.copy(str, i);
        }

        public final String component1() {
            return this.header;
        }

        public final int component2() {
            return this.background;
        }

        public final ScreenDataInfo copy(String header, int i) {
            Intrinsics.checkNotNullParameter(header, "header");
            return new ScreenDataInfo(header, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ScreenDataInfo) {
                ScreenDataInfo screenDataInfo = (ScreenDataInfo) obj;
                return Intrinsics.areEqual(this.header, screenDataInfo.header) && this.background == screenDataInfo.background;
            }
            return false;
        }

        public int hashCode() {
            return (this.header.hashCode() * 31) + Integer.hashCode(this.background);
        }

        public String toString() {
            String str = this.header;
            return "ScreenDataInfo(header=" + str + ", background=" + this.background + ")";
        }

        public ScreenDataInfo(String header, int i) {
            Intrinsics.checkNotNullParameter(header, "header");
            this.header = header;
            this.background = i;
        }

        public final int getBackground() {
            return this.background;
        }

        public final String getHeader() {
            return this.header;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DailyRewardsScreen.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lru/mrlargha/feature/calendar/DailyRewardsScreen$BackgroundType;", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "DAILY_REWARD", "NEW_YEAR", "MAY_REWARD", "AUTUMN_REWARD", "WELCOME", "RODINA_CAR_1", "RODINA_CAR_2", "OCTOBER_STREET", "Companion", "calendar"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class BackgroundType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ BackgroundType[] $VALUES;
        public static final Companion Companion;
        private final int type;
        public static final BackgroundType DAILY_REWARD = new BackgroundType("DAILY_REWARD", 0, 0);
        public static final BackgroundType NEW_YEAR = new BackgroundType("NEW_YEAR", 1, 1);
        public static final BackgroundType MAY_REWARD = new BackgroundType("MAY_REWARD", 2, 2);
        public static final BackgroundType AUTUMN_REWARD = new BackgroundType("AUTUMN_REWARD", 3, 3);
        public static final BackgroundType WELCOME = new BackgroundType("WELCOME", 4, 4);
        public static final BackgroundType RODINA_CAR_1 = new BackgroundType("RODINA_CAR_1", 5, 5);
        public static final BackgroundType RODINA_CAR_2 = new BackgroundType("RODINA_CAR_2", 6, 6);
        public static final BackgroundType OCTOBER_STREET = new BackgroundType("OCTOBER_STREET", 7, 7);

        private static final /* synthetic */ BackgroundType[] $values() {
            return new BackgroundType[]{DAILY_REWARD, NEW_YEAR, MAY_REWARD, AUTUMN_REWARD, WELCOME, RODINA_CAR_1, RODINA_CAR_2, OCTOBER_STREET};
        }

        public static EnumEntries<BackgroundType> getEntries() {
            return $ENTRIES;
        }

        public static BackgroundType valueOf(String str) {
            return (BackgroundType) Enum.valueOf(BackgroundType.class, str);
        }

        public static BackgroundType[] values() {
            return (BackgroundType[]) $VALUES.clone();
        }

        private BackgroundType(String str, int i, int i2) {
            this.type = i2;
        }

        public final int getType() {
            return this.type;
        }

        static {
            BackgroundType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            Companion = new Companion(null);
        }

        /* compiled from: DailyRewardsScreen.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/feature/calendar/DailyRewardsScreen$BackgroundType$Companion;", "", "<init>", "()V", "fromType", "Lru/mrlargha/feature/calendar/DailyRewardsScreen$BackgroundType;", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "", "calendar"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final BackgroundType fromType(int i) {
                Object obj;
                Iterator<E> it = BackgroundType.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((BackgroundType) obj).getType() == i) {
                        break;
                    }
                }
                BackgroundType backgroundType = (BackgroundType) obj;
                return backgroundType == null ? BackgroundType.DAILY_REWARD : backgroundType;
            }
        }
    }

    /* compiled from: DailyRewardsScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/feature/calendar/DailyRewardsScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "calendar"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.DAILY_REWARD);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new DailyRewardsScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}
