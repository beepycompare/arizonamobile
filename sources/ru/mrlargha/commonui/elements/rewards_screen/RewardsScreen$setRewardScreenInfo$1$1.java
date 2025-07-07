package ru.mrlargha.commonui.elements.rewards_screen;

import android.os.CountDownTimer;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.arizona.common.utils.EasyAnimation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.databinding.RewardsLayoutBinding;
import ru.mrlargha.commonui.elements.rewards_screen.RewardsScreen;
/* compiled from: RewardsScreen.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"ru/mrlargha/commonui/elements/rewards_screen/RewardsScreen$setRewardScreenInfo$1$1", "Landroid/os/CountDownTimer;", "onTick", "", "millisUntilFinished", "", "onFinish", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RewardsScreen$setRewardScreenInfo$1$1 extends CountDownTimer {
    final /* synthetic */ RewardsScreen.Companion.RewardScreenInfo $info;
    final /* synthetic */ RewardsLayoutBinding $this_with;
    final /* synthetic */ RewardsScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RewardsScreen$setRewardScreenInfo$1$1(RewardsLayoutBinding rewardsLayoutBinding, RewardsScreen rewardsScreen, RewardsScreen.Companion.RewardScreenInfo rewardScreenInfo, long j) {
        super(j, 1000L);
        this.$this_with = rewardsLayoutBinding;
        this.this$0 = rewardsScreen;
        this.$info = rewardScreenInfo;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        String formatTime;
        TextView textView = this.$this_with.actionButtonTxt;
        formatTime = this.this$0.formatTime(j);
        textView.setText("Доступно через " + formatTime);
        this.$this_with.actionButton.setOnClickListener(null);
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.$this_with.actionButtonTxt.setText(this.$info.getButtonName());
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        LinearLayout actionButton = this.$this_with.actionButton;
        Intrinsics.checkNotNullExpressionValue(actionButton, "actionButton");
        LinearLayout linearLayout = actionButton;
        final RewardsScreen rewardsScreen = this.this$0;
        EasyAnimation.animateClick$default(easyAnimation, linearLayout, 0L, null, new Function0() { // from class: ru.mrlargha.commonui.elements.rewards_screen.RewardsScreen$setRewardScreenInfo$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onFinish$lambda$0;
                onFinish$lambda$0 = RewardsScreen$setRewardScreenInfo$1$1.onFinish$lambda$0(RewardsScreen.this);
                return onFinish$lambda$0;
            }
        }, 3, null);
        cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onFinish$lambda$0(RewardsScreen rewardsScreen) {
        IBackendNotifier notifier;
        notifier = rewardsScreen.getNotifier();
        notifier.clickedWrapper(rewardsScreen.getBackendID(), 0, 1);
        return Unit.INSTANCE;
    }
}
