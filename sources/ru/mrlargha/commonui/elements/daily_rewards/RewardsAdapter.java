package ru.mrlargha.commonui.elements.daily_rewards;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.arizona.common.utils.EasyAnimation;
import com.squareup.picasso.Picasso;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.DateCalculationsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.DailyRewardsRewardItemBinding;
import ru.mrlargha.commonui.elements.daily_rewards.DailyRewardsScreen;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
/* compiled from: RewardsAdapter.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002%&B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000eJ\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J \u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u0017H\u0002J\u0014\u0010 \u001a\u00020\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\"J\u000e\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lru/mrlargha/commonui/elements/daily_rewards/RewardsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/daily_rewards/RewardsAdapter$ViewHolder;", "isArizona", "", "<init>", "(Z)V", "rewardsList", "", "Lru/mrlargha/commonui/elements/daily_rewards/DailyRewardsScreen$RewardInfo;", "updateInfo", "Lru/mrlargha/commonui/elements/daily_rewards/DailyRewardsScreen$UpdatePlayerInfo;", "isMayReward", "rewardItemClickListener", "Lru/mrlargha/commonui/elements/daily_rewards/RewardsAdapter$OnRewardItemClickListener;", "setMayReward", "", "setOnRewardItemClickListener", "onRewardItemClickListener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "checkIsMayDay", CommonUrlParts.MODEL, "binding", "Lru/mrlargha/commonui/databinding/DailyRewardsRewardItemBinding;", "addRewards", "routes", "", "updateRewards", "updInfo", "OnRewardItemClickListener", "ViewHolder", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RewardsAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final boolean isArizona;
    private boolean isMayReward;
    private OnRewardItemClickListener rewardItemClickListener;
    private final List<DailyRewardsScreen.RewardInfo> rewardsList = new ArrayList();
    private DailyRewardsScreen.UpdatePlayerInfo updateInfo;

    /* compiled from: RewardsAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/elements/daily_rewards/RewardsAdapter$OnRewardItemClickListener;", "", "onRewardItemClickListener", "", "hasReward", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnRewardItemClickListener {
        void onRewardItemClickListener(int i);
    }

    public RewardsAdapter(boolean z) {
        this.isArizona = z;
    }

    public final void setMayReward(boolean z) {
        this.isMayReward = z;
    }

    public final void setOnRewardItemClickListener(OnRewardItemClickListener onRewardItemClickListener) {
        Intrinsics.checkNotNullParameter(onRewardItemClickListener, "onRewardItemClickListener");
        this.rewardItemClickListener = onRewardItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_rewards_reward_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.rewardsList.size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0120, code lost:
        if (r5 == r1.getCurrentDay()) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0173, code lost:
        if (r1.getReceived() != 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x01a0, code lost:
        if (r1.getReceived() != 1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(ViewHolder holder, int i) {
        String str;
        DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo;
        DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo2;
        DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (this.updateInfo == null) {
            return;
        }
        DailyRewardsRewardItemBinding binding = holder.getBinding();
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
        if (this.isArizona) {
            str = FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/arizona-rp/systems/december_calendar/" + rewardInfo.getImage() + ".webp";
        } else {
            str = FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/rodina-rp/systems/battlepass/items/" + rewardInfo.getImage() + ".webp";
        }
        Picasso.get().load(str).into(binding.rewardIc);
        DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo4 = this.updateInfo;
        Intrinsics.checkNotNull(updatePlayerInfo4);
        if (i2 > updatePlayerInfo4.getCurrentDay()) {
            Log.e("rewards", "first argument  " + i2);
            binding.getButton.setVisibility(8);
            binding.timePgb.setVisibility(8);
            binding.rewardDescription.setVisibility(8);
            binding.doneContainer.setVisibility(8);
            binding.dayTitle.setTextColor(Color.parseColor("#FFFFFF"));
            binding.dayContainer.setBackgroundResource(R.drawable.daily_rewards_day_container_bg);
        }
        DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo5 = this.updateInfo;
        Intrinsics.checkNotNull(updatePlayerInfo5);
        if (i2 >= updatePlayerInfo5.getCurrentDay()) {
            DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo6 = this.updateInfo;
            Intrinsics.checkNotNull(updatePlayerInfo6);
            if (updatePlayerInfo6.getReceived() == 1) {
                DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo7 = this.updateInfo;
                Intrinsics.checkNotNull(updatePlayerInfo7);
            }
            updatePlayerInfo = this.updateInfo;
            Intrinsics.checkNotNull(updatePlayerInfo);
            if (i2 == updatePlayerInfo.getCurrentDay()) {
                DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo8 = this.updateInfo;
                Intrinsics.checkNotNull(updatePlayerInfo8);
            }
            if (!this.isArizona) {
                DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo9 = this.updateInfo;
                Intrinsics.checkNotNull(updatePlayerInfo9);
                int needToPlay = updatePlayerInfo9.getNeedToPlay();
                DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo10 = this.updateInfo;
                Intrinsics.checkNotNull(updatePlayerInfo10);
                if (needToPlay > updatePlayerInfo10.getPlayed()) {
                    DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo11 = this.updateInfo;
                    Intrinsics.checkNotNull(updatePlayerInfo11);
                    if (i2 == updatePlayerInfo11.getCurrentDay()) {
                        DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo12 = this.updateInfo;
                        if (updatePlayerInfo12 != null) {
                        }
                        Log.e("rewards", "third argument  " + i2);
                        DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo13 = this.updateInfo;
                        Intrinsics.checkNotNull(updatePlayerInfo13);
                        int played = updatePlayerInfo13.getPlayed();
                        DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo14 = this.updateInfo;
                        Intrinsics.checkNotNull(updatePlayerInfo14);
                        if (played < updatePlayerInfo14.getNeedToPlay()) {
                            DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo15 = this.updateInfo;
                            Intrinsics.checkNotNull(updatePlayerInfo15);
                            int needToPlay2 = updatePlayerInfo15.getNeedToPlay();
                            DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo16 = this.updateInfo;
                            Intrinsics.checkNotNull(updatePlayerInfo16);
                            int played2 = ((needToPlay2 - updatePlayerInfo16.getPlayed()) % 86400) / DateCalculationsKt.SECONDS_PER_HOUR;
                            DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo17 = this.updateInfo;
                            Intrinsics.checkNotNull(updatePlayerInfo17);
                            int needToPlay3 = updatePlayerInfo17.getNeedToPlay();
                            Intrinsics.checkNotNull(this.updateInfo);
                            binding.mainContainer.setBackgroundResource(R.drawable.daily_rewards_common_item_bg);
                            binding.dayContainer.setBackgroundResource(R.drawable.daily_rewards_current_day_container_bg);
                            binding.dayTitle.setTextColor(Color.parseColor("#000000"));
                            ProgressBar progressBar = binding.timePgb;
                            DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo18 = this.updateInfo;
                            Intrinsics.checkNotNull(updatePlayerInfo18);
                            progressBar.setMax(updatePlayerInfo18.getNeedToPlay());
                            ProgressBar progressBar2 = binding.timePgb;
                            DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo19 = this.updateInfo;
                            Intrinsics.checkNotNull(updatePlayerInfo19);
                            progressBar2.setProgress(updatePlayerInfo19.getPlayed());
                            binding.timePgb.setVisibility(0);
                            binding.doneContainer.setVisibility(8);
                            binding.rewardDescription.setVisibility(0);
                            binding.rewardDescription.setText("Осталось отыграть " + played2 + " ч. " + (((needToPlay3 - updatePlayerInfo3.getPlayed()) % DateCalculationsKt.SECONDS_PER_HOUR) / 60) + " м.");
                            binding.getButton.setVisibility(0);
                            binding.getButton.setBackgroundResource(R.drawable.daily_reward_get_button_unavailable_bg);
                            binding.getButtonText.setTextColor(Color.parseColor("#10FFFFFF"));
                        }
                        DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo20 = this.updateInfo;
                        Intrinsics.checkNotNull(updatePlayerInfo20);
                        int played3 = updatePlayerInfo20.getPlayed();
                        DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo21 = this.updateInfo;
                        Intrinsics.checkNotNull(updatePlayerInfo21);
                        if (played3 >= updatePlayerInfo21.getNeedToPlay()) {
                            Log.e("rewards", "forth argument  " + i2);
                            binding.mainContainer.setBackgroundResource(R.drawable.daily_rewards_award_item_bg);
                            binding.dayContainer.setBackgroundResource(R.drawable.daily_rewards_award_day_container_bg);
                            binding.dayTitle.setTextColor(Color.parseColor("#000000"));
                            binding.timePgb.setVisibility(8);
                            binding.doneContainer.setVisibility(8);
                            binding.rewardDescription.setVisibility(0);
                            binding.rewardDescription.setText("Можете забрать награду");
                            binding.getButton.setVisibility(0);
                            binding.getButton.setBackgroundResource(R.drawable.daily_reward_get_button_available_bg);
                            binding.getButtonText.setTextColor(Color.parseColor("#FFFFFF"));
                        }
                        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
                        ConstraintLayout getButton = binding.getButton;
                        Intrinsics.checkNotNullExpressionValue(getButton, "getButton");
                        EasyAnimation.animateClick$default(easyAnimation, getButton, 0L, null, new Function0() { // from class: ru.mrlargha.commonui.elements.daily_rewards.RewardsAdapter$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit onBindViewHolder$lambda$1$lambda$0;
                                onBindViewHolder$lambda$1$lambda$0 = RewardsAdapter.onBindViewHolder$lambda$1$lambda$0(RewardsAdapter.this);
                                return onBindViewHolder$lambda$1$lambda$0;
                            }
                        }, 3, null);
                    }
                }
            }
            updatePlayerInfo2 = this.updateInfo;
            if (updatePlayerInfo2 == null) {
                checkIsMayDay(updatePlayerInfo2, holder.getBinding(), i);
                return;
            }
            return;
        }
        Log.e("rewards", "second argument  " + i2);
        binding.mainContainer.setBackgroundResource(R.drawable.daily_rewards_common_item_bg);
        binding.getButton.setVisibility(8);
        binding.timePgb.setVisibility(8);
        binding.rewardDescription.setVisibility(8);
        binding.doneContainer.setVisibility(0);
        binding.dayTitle.setTextColor(Color.parseColor("#FFFFFF"));
        binding.dayContainer.setBackgroundResource(R.drawable.daily_rewards_day_container_bg);
        updatePlayerInfo = this.updateInfo;
        Intrinsics.checkNotNull(updatePlayerInfo);
        if (i2 == updatePlayerInfo.getCurrentDay()) {
        }
        if (!this.isArizona) {
        }
        updatePlayerInfo2 = this.updateInfo;
        if (updatePlayerInfo2 == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$1$lambda$0(RewardsAdapter rewardsAdapter) {
        OnRewardItemClickListener onRewardItemClickListener = rewardsAdapter.rewardItemClickListener;
        if (onRewardItemClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rewardItemClickListener");
            onRewardItemClickListener = null;
        }
        DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo = rewardsAdapter.updateInfo;
        Intrinsics.checkNotNull(updatePlayerInfo);
        onRewardItemClickListener.onRewardItemClickListener(updatePlayerInfo.getReceived());
        return Unit.INSTANCE;
    }

    private final void checkIsMayDay(DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo, DailyRewardsRewardItemBinding dailyRewardsRewardItemBinding, int i) {
        if (this.isMayReward) {
            int i2 = i + 1;
            Log.e("rewards", "may argument " + i2 + " ");
            if (updatePlayerInfo.getCurrentDay() == i2) {
                dailyRewardsRewardItemBinding.getButtonText.setTextColor(Color.parseColor("#FFFFFF"));
                dailyRewardsRewardItemBinding.dayTitle.setTextColor(Color.parseColor("#FFFFFF"));
                dailyRewardsRewardItemBinding.mainContainer.setBackgroundResource(R.drawable.daily_reward_item_current_day_bg);
                dailyRewardsRewardItemBinding.dayContainer.setBackgroundColor(Color.parseColor("#CE8235"));
                dailyRewardsRewardItemBinding.getButton.setBackgroundColor(Color.parseColor("#CE8235"));
            } else if (updatePlayerInfo.getCurrentDay() <= i) {
                dailyRewardsRewardItemBinding.getButtonText.setTextColor(Color.parseColor("#FFFFFF"));
                dailyRewardsRewardItemBinding.dayTitle.setTextColor(Color.parseColor("#FFFFFF"));
                dailyRewardsRewardItemBinding.mainContainer.setBackgroundResource(R.drawable.daily_reward_may_item_bg);
                dailyRewardsRewardItemBinding.dayContainer.setBackgroundColor(Color.parseColor("#3D4623"));
            }
        }
    }

    public final void addRewards(List<DailyRewardsScreen.RewardInfo> routes) {
        Intrinsics.checkNotNullParameter(routes, "routes");
        this.rewardsList.clear();
        this.rewardsList.addAll(routes);
    }

    public final void updateRewards(DailyRewardsScreen.UpdatePlayerInfo updInfo) {
        Intrinsics.checkNotNullParameter(updInfo, "updInfo");
        this.updateInfo = updInfo;
    }

    /* compiled from: RewardsAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/daily_rewards/RewardsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/commonui/databinding/DailyRewardsRewardItemBinding;", "getBinding", "()Lru/mrlargha/commonui/databinding/DailyRewardsRewardItemBinding;", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final DailyRewardsRewardItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            DailyRewardsRewardItemBinding bind = DailyRewardsRewardItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final DailyRewardsRewardItemBinding getBinding() {
            return this.binding;
        }
    }
}
