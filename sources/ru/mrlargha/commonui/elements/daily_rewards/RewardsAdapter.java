package ru.mrlargha.commonui.elements.daily_rewards;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.DailyRewardsRewardItemBinding;
import ru.mrlargha.commonui.elements.daily_rewards.DailyRewardsScreen;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
/* compiled from: RewardsAdapter.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002%&B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000eJ\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J \u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u0017H\u0002J\u0014\u0010 \u001a\u00020\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\"J\u000e\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lru/mrlargha/commonui/elements/daily_rewards/RewardsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/daily_rewards/RewardsAdapter$ViewHolder;", "isArizona", "", "<init>", "(Z)V", "rewardsList", "", "Lru/mrlargha/commonui/elements/daily_rewards/DailyRewardsScreen$RewardInfo;", "updateInfo", "Lru/mrlargha/commonui/elements/daily_rewards/DailyRewardsScreen$UpdatePlayerInfo;", "isMayReward", "rewardItemClickListener", "Lru/mrlargha/commonui/elements/daily_rewards/RewardsAdapter$OnRewardItemClickListener;", "setMayReward", "", "setOnRewardItemClickListener", "onRewardItemClickListener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "checkIsMayDay", CommonUrlParts.MODEL, "binding", "Lru/mrlargha/commonui/databinding/DailyRewardsRewardItemBinding;", "addRewards", "routes", "", "updateRewards", "updInfo", "OnRewardItemClickListener", "ViewHolder", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RewardsAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final boolean isArizona;
    private boolean isMayReward;
    private OnRewardItemClickListener rewardItemClickListener;
    private final List<DailyRewardsScreen.RewardInfo> rewardsList = new ArrayList();
    private DailyRewardsScreen.UpdatePlayerInfo updateInfo;

    /* compiled from: RewardsAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/elements/daily_rewards/RewardsAdapter$OnRewardItemClickListener;", "", "onRewardItemClickListener", "", "hasReward", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0119, code lost:
        if (r12.isArizona == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01c0, code lost:
        if (r1.getReceived() != 0) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01c2, code lost:
        if (r6 != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01c4, code lost:
        android.util.Log.e("rewards", "third argument  " + r5);
        r1 = r12.updateInfo;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r1 = r1.getPlayed();
        r2 = r12.updateInfo;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01ea, code lost:
        if (r1 >= r2.getNeedToPlay()) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01ec, code lost:
        r1 = r12.updateInfo;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r1 = r1.getNeedToPlay();
        r2 = r12.updateInfo;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
        r1 = ((r1 - r2.getPlayed()) % 86400) / kotlinx.datetime.internal.DateCalculationsKt.SECONDS_PER_HOUR;
        r2 = r12.updateInfo;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
        r2 = r2.getNeedToPlay();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r12.updateInfo);
        r0.mainContainer.setBackgroundResource(ru.mrlargha.commonui.R.drawable.daily_rewards_common_item_bg);
        r0.dayContainer.setBackgroundResource(ru.mrlargha.commonui.R.drawable.daily_rewards_current_day_container_bg);
        r0.dayTitle.setTextColor(android.graphics.Color.parseColor("#000000"));
        r9 = r0.timePgb;
        r10 = r12.updateInfo;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r10);
        r9.setMax(r10.getNeedToPlay());
        r9 = r0.timePgb;
        r10 = r12.updateInfo;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r10);
        r9.setProgress(r10.getPlayed());
        r0.timePgb.setVisibility(0);
        r0.doneContainer.setVisibility(8);
        r0.rewardDescription.setVisibility(0);
        r0.rewardDescription.setText("Осталось отыграть " + r1 + " ч. " + (((r2 - r9.getPlayed()) % kotlinx.datetime.internal.DateCalculationsKt.SECONDS_PER_HOUR) / 60) + " м.");
        r0.getButton.setVisibility(8);
        r0.getButton.setBackgroundResource(ru.mrlargha.commonui.R.drawable.daily_reward_get_button_unavailable_bg);
        r0.getButtonText.setTextColor(android.graphics.Color.parseColor("#10FFFFFF"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x029c, code lost:
        r1 = r12.updateInfo;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r1 = r1.getPlayed();
        r2 = r12.updateInfo;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x02ae, code lost:
        if (r1 < r2.getNeedToPlay()) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x02b0, code lost:
        android.util.Log.e("rewards", "forth argument  " + r5);
        r0.mainContainer.setBackgroundResource(ru.mrlargha.commonui.R.drawable.daily_rewards_award_item_bg);
        r0.dayContainer.setBackgroundResource(ru.mrlargha.commonui.R.drawable.daily_rewards_award_day_container_bg);
        r0.dayTitle.setTextColor(android.graphics.Color.parseColor("#000000"));
        r0.timePgb.setVisibility(8);
        r0.doneContainer.setVisibility(8);
        r0.rewardDescription.setVisibility(0);
        r0.rewardDescription.setText("Можете забрать награду");
        r0.getButton.setVisibility(0);
        r0.getButton.setBackgroundResource(ru.mrlargha.commonui.R.drawable.daily_reward_get_button_available_bg);
        r0.getButtonText.setTextColor(android.graphics.Color.parseColor("#FFFFFF"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0307, code lost:
        r3 = com.arizona.common.utils.EasyAnimation.INSTANCE;
        r0 = r0.getButton;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "getButton");
        com.arizona.common.utils.EasyAnimation.animateClick$default(r3, r0, 0, null, new ru.mrlargha.commonui.elements.daily_rewards.RewardsAdapter$$ExternalSyntheticLambda0(r12), 3, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0320, code lost:
        r0 = r12.updateInfo;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0322, code lost:
        if (r0 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0324, code lost:
        checkIsMayDay(r0, r13.getBinding(), r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x032b, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01b7  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(ViewHolder holder, int i) {
        String str;
        boolean z;
        DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo;
        boolean z2;
        DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo2;
        DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo3;
        DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo4;
        DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo5;
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
        DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo6 = this.updateInfo;
        Intrinsics.checkNotNull(updatePlayerInfo6);
        int needToPlay = updatePlayerInfo6.getNeedToPlay();
        DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo7 = this.updateInfo;
        Intrinsics.checkNotNull(updatePlayerInfo7);
        boolean z3 = true;
        if (needToPlay > updatePlayerInfo7.getPlayed()) {
            DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo8 = this.updateInfo;
            Intrinsics.checkNotNull(updatePlayerInfo8);
            if (updatePlayerInfo8.getPlayed() > 0) {
                z = false;
                updatePlayerInfo = this.updateInfo;
                Intrinsics.checkNotNull(updatePlayerInfo);
                if (updatePlayerInfo.getReceived() == 1) {
                    DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo9 = this.updateInfo;
                    Intrinsics.checkNotNull(updatePlayerInfo9);
                    if (i2 == updatePlayerInfo9.getCurrentDay() && z && !this.isArizona) {
                        z2 = true;
                        updatePlayerInfo2 = this.updateInfo;
                        Intrinsics.checkNotNull(updatePlayerInfo2);
                        if (updatePlayerInfo2.getReceived() == 1) {
                            DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo10 = this.updateInfo;
                            Intrinsics.checkNotNull(updatePlayerInfo10);
                            if (i2 == updatePlayerInfo10.getCurrentDay()) {
                                if (!z) {
                                }
                            }
                        }
                        z3 = false;
                        updatePlayerInfo3 = this.updateInfo;
                        Intrinsics.checkNotNull(updatePlayerInfo3);
                        if (i2 > updatePlayerInfo3.getCurrentDay()) {
                            Log.e("rewards", "first argument  " + i2);
                            binding.getButton.setVisibility(8);
                            binding.timePgb.setVisibility(8);
                            binding.rewardDescription.setVisibility(8);
                            binding.doneContainer.setVisibility(8);
                            binding.dayTitle.setTextColor(Color.parseColor("#FFFFFF"));
                            binding.dayContainer.setBackgroundResource(R.drawable.daily_rewards_day_container_bg);
                        }
                        updatePlayerInfo4 = this.updateInfo;
                        Intrinsics.checkNotNull(updatePlayerInfo4);
                        if (i2 >= updatePlayerInfo4.getCurrentDay() || z2) {
                            Log.e("rewards", "second argument  " + i2);
                            binding.mainContainer.setBackgroundResource(R.drawable.daily_rewards_common_item_bg);
                            binding.getButton.setVisibility(8);
                            binding.timePgb.setVisibility(8);
                            binding.rewardDescription.setVisibility(8);
                            binding.doneContainer.setVisibility(0);
                            binding.dayTitle.setTextColor(Color.parseColor("#FFFFFF"));
                            binding.dayContainer.setBackgroundResource(R.drawable.daily_rewards_day_container_bg);
                        }
                        updatePlayerInfo5 = this.updateInfo;
                        Intrinsics.checkNotNull(updatePlayerInfo5);
                        if (i2 == updatePlayerInfo5.getCurrentDay()) {
                            DailyRewardsScreen.UpdatePlayerInfo updatePlayerInfo11 = this.updateInfo;
                            Intrinsics.checkNotNull(updatePlayerInfo11);
                        }
                    }
                }
                z2 = false;
                updatePlayerInfo2 = this.updateInfo;
                Intrinsics.checkNotNull(updatePlayerInfo2);
                if (updatePlayerInfo2.getReceived() == 1) {
                }
                z3 = false;
                updatePlayerInfo3 = this.updateInfo;
                Intrinsics.checkNotNull(updatePlayerInfo3);
                if (i2 > updatePlayerInfo3.getCurrentDay()) {
                }
                updatePlayerInfo4 = this.updateInfo;
                Intrinsics.checkNotNull(updatePlayerInfo4);
                if (i2 >= updatePlayerInfo4.getCurrentDay()) {
                }
                Log.e("rewards", "second argument  " + i2);
                binding.mainContainer.setBackgroundResource(R.drawable.daily_rewards_common_item_bg);
                binding.getButton.setVisibility(8);
                binding.timePgb.setVisibility(8);
                binding.rewardDescription.setVisibility(8);
                binding.doneContainer.setVisibility(0);
                binding.dayTitle.setTextColor(Color.parseColor("#FFFFFF"));
                binding.dayContainer.setBackgroundResource(R.drawable.daily_rewards_day_container_bg);
                updatePlayerInfo5 = this.updateInfo;
                Intrinsics.checkNotNull(updatePlayerInfo5);
                if (i2 == updatePlayerInfo5.getCurrentDay()) {
                }
            }
        }
        z = true;
        updatePlayerInfo = this.updateInfo;
        Intrinsics.checkNotNull(updatePlayerInfo);
        if (updatePlayerInfo.getReceived() == 1) {
        }
        z2 = false;
        updatePlayerInfo2 = this.updateInfo;
        Intrinsics.checkNotNull(updatePlayerInfo2);
        if (updatePlayerInfo2.getReceived() == 1) {
        }
        z3 = false;
        updatePlayerInfo3 = this.updateInfo;
        Intrinsics.checkNotNull(updatePlayerInfo3);
        if (i2 > updatePlayerInfo3.getCurrentDay()) {
        }
        updatePlayerInfo4 = this.updateInfo;
        Intrinsics.checkNotNull(updatePlayerInfo4);
        if (i2 >= updatePlayerInfo4.getCurrentDay()) {
        }
        Log.e("rewards", "second argument  " + i2);
        binding.mainContainer.setBackgroundResource(R.drawable.daily_rewards_common_item_bg);
        binding.getButton.setVisibility(8);
        binding.timePgb.setVisibility(8);
        binding.rewardDescription.setVisibility(8);
        binding.doneContainer.setVisibility(0);
        binding.dayTitle.setTextColor(Color.parseColor("#FFFFFF"));
        binding.dayContainer.setBackgroundResource(R.drawable.daily_rewards_day_container_bg);
        updatePlayerInfo5 = this.updateInfo;
        Intrinsics.checkNotNull(updatePlayerInfo5);
        if (i2 == updatePlayerInfo5.getCurrentDay()) {
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
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/daily_rewards/RewardsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/commonui/databinding/DailyRewardsRewardItemBinding;", "getBinding", "()Lru/mrlargha/commonui/databinding/DailyRewardsRewardItemBinding;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
