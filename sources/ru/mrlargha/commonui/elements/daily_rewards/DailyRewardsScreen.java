package ru.mrlargha.commonui.elements.daily_rewards;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.arizona.common.utils.EasyAnimation;
import io.appmetrica.analytics.impl.L2;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.DailyRewardsLayoutBinding;
import ru.mrlargha.commonui.elements.daily_rewards.RewardsAdapter;
import ru.mrlargha.commonui.utils.ConverterKt;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: DailyRewardsScreen.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0005\"#$%&B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\u0017\u0010\u001e\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001f\u001a\u00020 H\u0002¢\u0006\u0002\u0010!R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lru/mrlargha/commonui/elements/daily_rewards/DailyRewardsScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screenLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/DailyRewardsLayoutBinding;", "getBinding", "()Lru/mrlargha/commonui/databinding/DailyRewardsLayoutBinding;", "rewardsAdapter", "Lru/mrlargha/commonui/elements/daily_rewards/RewardsAdapter;", "setRewardsInfo", "", "rewards", "", "Lru/mrlargha/commonui/elements/daily_rewards/DailyRewardsScreen$RewardInfo;", "updateInfo", "info", "Lru/mrlargha/commonui/elements/daily_rewards/DailyRewardsScreen$UpdatePlayerInfo;", "updateMainInfo", "data", "Lru/mrlargha/commonui/elements/daily_rewards/DailyRewardsScreen$ScreenDataInfo;", "onBackendMessage", "", "subId", "setVisibleDetail", "isVisible", "", "(Z)Lkotlin/Unit;", "RewardInfo", "UpdatePlayerInfo", "ScreenDataInfo", "BackgroundType", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DailyRewardsScreen extends SAMPUIElement {
    private final DailyRewardsLayoutBinding binding;
    private final RewardsAdapter rewardsAdapter;
    private final ConstraintLayout screenLayout;

    /* compiled from: DailyRewardsScreen.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
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
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyRewardsScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        DailyRewardsLayoutBinding dailyRewardsLayoutBinding = null;
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.daily_rewards_layout, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.screenLayout = constraintLayout;
        try {
            dailyRewardsLayoutBinding = DailyRewardsLayoutBinding.bind(constraintLayout);
        } catch (NullPointerException e) {
            Log.e("Binding", "tip_container not found in layout", e);
        }
        this.binding = dailyRewardsLayoutBinding;
        RewardsAdapter rewardsAdapter = new RewardsAdapter(targetActivity.getSharedPreferences("flavorType", 0).getBoolean("isArizonaType", false));
        this.rewardsAdapter = rewardsAdapter;
        addViewToConstraintLayout(this.screenLayout, -1, -1);
        if (dailyRewardsLayoutBinding != null) {
            dailyRewardsLayoutBinding.rewardsRc.setAdapter(rewardsAdapter);
            rewardsAdapter.setOnRewardItemClickListener(new RewardsAdapter.OnRewardItemClickListener() { // from class: ru.mrlargha.commonui.elements.daily_rewards.DailyRewardsScreen$1$1$1
                @Override // ru.mrlargha.commonui.elements.daily_rewards.RewardsAdapter.OnRewardItemClickListener
                public void onRewardItemClickListener(int i2) {
                    if (i2 == 0) {
                        SAMPUIElement.notifyClick$default(DailyRewardsScreen.this, 0, 1, null, 4, null);
                    }
                }
            });
            EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
            ImageView exitButton = dailyRewardsLayoutBinding.exitButton;
            Intrinsics.checkNotNullExpressionValue(exitButton, "exitButton");
            EasyAnimation.animateClick$default(easyAnimation, exitButton, 0L, new Function0() { // from class: ru.mrlargha.commonui.elements.daily_rewards.DailyRewardsScreen$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DailyRewardsScreen.lambda$2$lambda$1$lambda$0(DailyRewardsScreen.this);
                }
            }, null, 5, null);
        }
    }

    public final DailyRewardsLayoutBinding getBinding() {
        return this.binding;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$2$lambda$1$lambda$0(DailyRewardsScreen dailyRewardsScreen) {
        SAMPUIElement.notifyClick$default(dailyRewardsScreen, 0, 0, null, 4, null);
        return Unit.INSTANCE;
    }

    private final void setRewardsInfo(List<RewardInfo> list) {
        this.rewardsAdapter.addRewards(list);
    }

    private final void updateInfo(UpdatePlayerInfo updatePlayerInfo) {
        this.rewardsAdapter.updateRewards(updatePlayerInfo);
    }

    private final void updateMainInfo(ScreenDataInfo screenDataInfo) {
        DailyRewardsLayoutBinding dailyRewardsLayoutBinding = this.binding;
        if (dailyRewardsLayoutBinding != null) {
            dailyRewardsLayoutBinding.title.setText(screenDataInfo.getHeader());
            setVisibleDetail(true);
            int i = WhenMappings.$EnumSwitchMapping$0[BackgroundType.Companion.fromType(screenDataInfo.getBackground()).ordinal()];
            if (i == 1) {
                dailyRewardsLayoutBinding.getRoot().setBackgroundResource(R.drawable.daily_reward_bg);
            } else if (i == 2) {
                dailyRewardsLayoutBinding.getRoot().setBackgroundResource(R.drawable.new_year_reward_bg);
            } else if (i != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                dailyRewardsLayoutBinding.getRoot().setBackgroundResource(R.drawable.daily_rewards_may_bg);
                setVisibleDetail(false);
            }
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        RecyclerView recyclerView;
        RecyclerView.RecycledViewPool recycledViewPool;
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            DailyRewardsLayoutBinding dailyRewardsLayoutBinding = this.binding;
            if (dailyRewardsLayoutBinding != null && (recyclerView = dailyRewardsLayoutBinding.rewardsRc) != null && (recycledViewPool = recyclerView.getRecycledViewPool()) != null) {
                recycledViewPool.clear();
            }
            setRewardsInfo(MapperKt.toListModel(data, RewardInfo.class));
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
            this.rewardsAdapter.setMayReward(!z);
            if (!z) {
                Log.e("daily", "setVisibleDetail: ");
                int dpToPx = ConverterKt.dpToPx(150.0f, getTargetActivity());
                dailyRewardsLayoutBinding.rewardsRc.setPadding(dpToPx, 0, 0, 0);
                dailyRewardsLayoutBinding.title.setPadding(dpToPx, 0, 0, 0);
                dailyRewardsLayoutBinding.rewardsRc.setVisibility(0);
            }
            return Unit.INSTANCE;
        }
        return null;
    }

    /* compiled from: DailyRewardsScreen.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/daily_rewards/DailyRewardsScreen$RewardInfo;", "", "title", "", "image", "amount", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getTitle", "()Ljava/lang/String;", "getImage", "getAmount", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class RewardInfo {
        private final int amount;
        private final String image;
        private final String title;

        public static /* synthetic */ RewardInfo copy$default(RewardInfo rewardInfo, String str, String str2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = rewardInfo.title;
            }
            if ((i2 & 2) != 0) {
                str2 = rewardInfo.image;
            }
            if ((i2 & 4) != 0) {
                i = rewardInfo.amount;
            }
            return rewardInfo.copy(str, str2, i);
        }

        public final String component1() {
            return this.title;
        }

        public final String component2() {
            return this.image;
        }

        public final int component3() {
            return this.amount;
        }

        public final RewardInfo copy(String title, String image, int i) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(image, "image");
            return new RewardInfo(title, image, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RewardInfo) {
                RewardInfo rewardInfo = (RewardInfo) obj;
                return Intrinsics.areEqual(this.title, rewardInfo.title) && Intrinsics.areEqual(this.image, rewardInfo.image) && this.amount == rewardInfo.amount;
            }
            return false;
        }

        public int hashCode() {
            return (((this.title.hashCode() * 31) + this.image.hashCode()) * 31) + Integer.hashCode(this.amount);
        }

        public String toString() {
            String str = this.title;
            String str2 = this.image;
            return "RewardInfo(title=" + str + ", image=" + str2 + ", amount=" + this.amount + ")";
        }

        public RewardInfo(String title, String image, int i) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(image, "image");
            this.title = title;
            this.image = image;
            this.amount = i;
        }

        public final int getAmount() {
            return this.amount;
        }

        public final String getImage() {
            return this.image;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    /* compiled from: DailyRewardsScreen.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/daily_rewards/DailyRewardsScreen$UpdatePlayerInfo;", "", "currentDay", "", "needToPlay", "played", "received", "<init>", "(IIII)V", "getCurrentDay", "()I", "getNeedToPlay", "getPlayed", "getReceived", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
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
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/daily_rewards/DailyRewardsScreen$ScreenDataInfo;", "", "header", "", L2.g, "", "<init>", "(Ljava/lang/String;I)V", "getHeader", "()Ljava/lang/String;", "getBackground", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
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
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lru/mrlargha/commonui/elements/daily_rewards/DailyRewardsScreen$BackgroundType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "DAILY_REWARD", "NEW_YEAR", "MAY_REWARD", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class BackgroundType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ BackgroundType[] $VALUES;
        public static final Companion Companion;
        private final int type;
        public static final BackgroundType DAILY_REWARD = new BackgroundType("DAILY_REWARD", 0, 0);
        public static final BackgroundType NEW_YEAR = new BackgroundType("NEW_YEAR", 1, 1);
        public static final BackgroundType MAY_REWARD = new BackgroundType("MAY_REWARD", 2, 2);

        private static final /* synthetic */ BackgroundType[] $values() {
            return new BackgroundType[]{DAILY_REWARD, NEW_YEAR, MAY_REWARD};
        }

        public static EnumEntries<BackgroundType> getEntries() {
            return $ENTRIES;
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
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/daily_rewards/DailyRewardsScreen$BackgroundType$Companion;", "", "<init>", "()V", "fromType", "Lru/mrlargha/commonui/elements/daily_rewards/DailyRewardsScreen$BackgroundType;", "type", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
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

        public static BackgroundType valueOf(String str) {
            return (BackgroundType) Enum.valueOf(BackgroundType.class, str);
        }

        public static BackgroundType[] values() {
            return (BackgroundType[]) $VALUES.clone();
        }
    }

    /* compiled from: DailyRewardsScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/daily_rewards/DailyRewardsScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new DailyRewardsScreen(targetActivity, i);
        }
    }
}
