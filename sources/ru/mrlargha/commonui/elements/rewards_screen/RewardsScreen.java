package ru.mrlargha.commonui.elements.rewards_screen;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.common.utils.EasyAnimation;
import com.squareup.picasso.Picasso;
import io.appmetrica.analytics.impl.L2;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.RewardsLayoutBinding;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: RewardsScreen.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J(\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u0018\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lru/mrlargha/commonui/elements/rewards_screen/RewardsScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", TtmlNode.TAG_LAYOUT, "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/RewardsLayoutBinding;", "timer", "Landroid/os/CountDownTimer;", "setVisibility", "", "visible", "", "setRewardScreenInfo", "info", "Lru/mrlargha/commonui/elements/rewards_screen/RewardsScreen$Companion$RewardScreenInfo;", "formatTime", "", "millisUntilFinished", "", "colorizeTextView", "textView", "Landroid/widget/TextView;", "fullString", "subString", "color", "onBackendMessage", "data", "subId", "Companion", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RewardsScreen extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private final RewardsLayoutBinding binding;
    private final ConstraintLayout layout;
    private CountDownTimer timer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RewardsScreen(Activity targetActivity, final int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.rewards_layout, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.layout = constraintLayout;
        RewardsLayoutBinding bind = RewardsLayoutBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        constraintLayout.setClickable(true);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ImageView exitButton = bind.exitButton;
        Intrinsics.checkNotNullExpressionValue(exitButton, "exitButton");
        EasyAnimation.animateClick$default(easyAnimation, exitButton, 0L, null, new Function0() { // from class: ru.mrlargha.commonui.elements.rewards_screen.RewardsScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RewardsScreen.lambda$2$lambda$0(RewardsScreen.this, i);
            }
        }, 3, null);
        EasyAnimation easyAnimation2 = EasyAnimation.INSTANCE;
        LinearLayout actionButton = bind.actionButton;
        Intrinsics.checkNotNullExpressionValue(actionButton, "actionButton");
        EasyAnimation.animateClick$default(easyAnimation2, actionButton, 0L, null, new Function0() { // from class: ru.mrlargha.commonui.elements.rewards_screen.RewardsScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RewardsScreen.lambda$2$lambda$1(RewardsScreen.this, i);
            }
        }, 3, null);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        CountDownTimer countDownTimer;
        if (!z && (countDownTimer = this.timer) != null) {
            if (countDownTimer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timer");
                countDownTimer = null;
            }
            countDownTimer.cancel();
        }
        super.setVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$2$lambda$0(RewardsScreen rewardsScreen, int i) {
        rewardsScreen.getNotifier().clickedWrapper(i, 0, 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$2$lambda$1(RewardsScreen rewardsScreen, int i) {
        rewardsScreen.getNotifier().clickedWrapper(i, 0, 1);
        return Unit.INSTANCE;
    }

    private final void setRewardScreenInfo(Companion.RewardScreenInfo rewardScreenInfo) {
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            if (countDownTimer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timer");
                countDownTimer = null;
            }
            countDownTimer.cancel();
        }
        RewardsLayoutBinding rewardsLayoutBinding = this.binding;
        Picasso.get().load(FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/arizona-rp/systems/reward_banner/background/" + rewardScreenInfo.getBackground()).into(rewardsLayoutBinding.layoutBg);
        String str = rewardScreenInfo.getTitleHeaders() + "\n" + rewardScreenInfo.getTitle();
        if (rewardScreenInfo.getType() == 7) {
            rewardsLayoutBinding.title.setTypeface(ResourcesCompat.getFont(getTargetActivity(), R.font.hardpixel));
        }
        TextView title = rewardsLayoutBinding.title;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        colorizeTextView(title, str, rewardScreenInfo.getTitle(), Color.parseColor(rewardScreenInfo.getColor()));
        rewardsLayoutBinding.description.setText(rewardScreenInfo.getDescription());
        CountDownTimer start = new RewardsScreen$setRewardScreenInfo$1$1(rewardsLayoutBinding, this, rewardScreenInfo, rewardScreenInfo.getTime() * 1000).start();
        Intrinsics.checkNotNullExpressionValue(start, "start(...)");
        this.timer = start;
        int i = 0;
        for (Object obj : rewardScreenInfo.getRewards()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Companion.RewardItem rewardItem = (Companion.RewardItem) obj;
            if (i == 0) {
                Picasso.get().load(FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/arizona-rp/systems/reward_banner/items/" + rewardItem.getImage()).into(rewardsLayoutBinding.firstShortPrizeIc);
                rewardsLayoutBinding.firstShortPrizeTitle.setText(rewardItem.getTitle());
                rewardsLayoutBinding.firstShortPrizeDescription.setText(rewardItem.getValue());
                if (rewardItem.getBadge().length() > 0) {
                    rewardsLayoutBinding.firstShortPrizeTimeContainer.setVisibility(0);
                    rewardsLayoutBinding.firstShortPrizeTimeContainer.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(rewardScreenInfo.getColor())));
                    rewardsLayoutBinding.firstShortPrizeTimeDescription.setText(rewardItem.getBadge());
                } else {
                    rewardsLayoutBinding.firstShortPrizeTimeContainer.setVisibility(8);
                }
            } else if (i == 1) {
                Picasso.get().load(FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/arizona-rp/systems/reward_banner/items/" + rewardItem.getImage()).into(rewardsLayoutBinding.firstLongPrizeIc);
                rewardsLayoutBinding.firstLongPrizeTitle.setText(rewardItem.getTitle());
                rewardsLayoutBinding.firstLongPrizeDescription.setText(rewardItem.getValue());
                if (rewardItem.getBadge().length() > 0) {
                    rewardsLayoutBinding.firstLongPrizeTimeContainer.setVisibility(0);
                    rewardsLayoutBinding.firstLongPrizeTimeContainer.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(rewardScreenInfo.getColor())));
                    rewardsLayoutBinding.firstLongPrizeTimeDescription.setText(rewardItem.getBadge());
                } else {
                    rewardsLayoutBinding.firstLongPrizeTimeContainer.setVisibility(8);
                }
            } else if (i == 2) {
                Picasso.get().load(FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/arizona-rp/systems/reward_banner/items/" + rewardItem.getImage()).into(rewardsLayoutBinding.secondShortPrizeIc);
                rewardsLayoutBinding.secondShortPrizeTitle.setText(rewardItem.getTitle());
                rewardsLayoutBinding.secondShortPrizeDescription.setText(rewardItem.getValue());
                if (rewardItem.getBadge().length() > 0) {
                    rewardsLayoutBinding.secondShortPrizeTimeContainer.setVisibility(0);
                    rewardsLayoutBinding.secondShortPrizeTimeContainer.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(rewardScreenInfo.getColor())));
                    rewardsLayoutBinding.secondShortPrizeTimeDescription.setText(rewardItem.getBadge());
                } else {
                    rewardsLayoutBinding.secondShortPrizeTimeContainer.setVisibility(8);
                }
            } else if (i == 3) {
                Picasso.get().load(FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/arizona-rp/systems/reward_banner/items/" + rewardItem.getImage()).into(rewardsLayoutBinding.secondLongPrizeIc);
                rewardsLayoutBinding.secondLongPrizeTitle.setText(rewardItem.getTitle());
                rewardsLayoutBinding.secondLongPrizeDescription.setText(rewardItem.getValue());
                if (rewardItem.getBadge().length() > 0) {
                    rewardsLayoutBinding.secondLongPrizeTimeContainer.setVisibility(0);
                    rewardsLayoutBinding.secondLongPrizeTimeContainer.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(rewardScreenInfo.getColor())));
                    rewardsLayoutBinding.secondLongPrizeTimeDescription.setText(rewardItem.getBadge());
                } else {
                    rewardsLayoutBinding.secondLongPrizeTimeContainer.setVisibility(8);
                }
            }
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatTime(long j) {
        long j2 = j / 1000;
        long j3 = 60;
        long j4 = j2 / j3;
        long j5 = j2 % j3;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j4), Long.valueOf(j5)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    private final void colorizeTextView(TextView textView, String str, String str2, int i) {
        String str3 = str;
        SpannableString spannableString = new SpannableString(str3);
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str3, str2, 0, false, 6, (Object) null);
        spannableString.setSpan(new ForegroundColorSpan(i), indexOf$default, str2.length() + indexOf$default, 33);
        textView.setText(spannableString);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            setRewardScreenInfo((Companion.RewardScreenInfo) MapperKt.toModel(data, Companion.RewardScreenInfo.class));
        }
    }

    /* compiled from: RewardsScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/elements/rewards_screen/RewardsScreen$Companion;", "", "<init>", "()V", "RewardScreenInfo", "RewardItem", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: RewardsScreen.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003Ji\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lru/mrlargha/commonui/elements/rewards_screen/RewardsScreen$Companion$RewardScreenInfo;", "", "type", "", L2.g, "", "title", "titleHeaders", "buttonName", "description", "time", "color", "rewards", "", "Lru/mrlargha/commonui/elements/rewards_screen/RewardsScreen$Companion$RewardItem;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;)V", "getType", "()I", "getBackground", "()Ljava/lang/String;", "getTitle", "getTitleHeaders", "getButtonName", "getDescription", "getTime", "getColor", "getRewards", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class RewardScreenInfo {
            private final String background;
            private final String buttonName;
            private final String color;
            private final String description;
            private final List<RewardItem> rewards;
            private final int time;
            private final String title;
            private final String titleHeaders;
            private final int type;

            public static /* synthetic */ RewardScreenInfo copy$default(RewardScreenInfo rewardScreenInfo, int i, String str, String str2, String str3, String str4, String str5, int i2, String str6, List list, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = rewardScreenInfo.type;
                }
                if ((i3 & 2) != 0) {
                    str = rewardScreenInfo.background;
                }
                if ((i3 & 4) != 0) {
                    str2 = rewardScreenInfo.title;
                }
                if ((i3 & 8) != 0) {
                    str3 = rewardScreenInfo.titleHeaders;
                }
                if ((i3 & 16) != 0) {
                    str4 = rewardScreenInfo.buttonName;
                }
                if ((i3 & 32) != 0) {
                    str5 = rewardScreenInfo.description;
                }
                if ((i3 & 64) != 0) {
                    i2 = rewardScreenInfo.time;
                }
                if ((i3 & 128) != 0) {
                    str6 = rewardScreenInfo.color;
                }
                List<RewardItem> list2 = list;
                if ((i3 & 256) != 0) {
                    list2 = rewardScreenInfo.rewards;
                }
                String str7 = str6;
                List list3 = list2;
                String str8 = str5;
                int i4 = i2;
                String str9 = str4;
                String str10 = str2;
                return rewardScreenInfo.copy(i, str, str10, str3, str9, str8, i4, str7, list3);
            }

            public final int component1() {
                return this.type;
            }

            public final String component2() {
                return this.background;
            }

            public final String component3() {
                return this.title;
            }

            public final String component4() {
                return this.titleHeaders;
            }

            public final String component5() {
                return this.buttonName;
            }

            public final String component6() {
                return this.description;
            }

            public final int component7() {
                return this.time;
            }

            public final String component8() {
                return this.color;
            }

            public final List<RewardItem> component9() {
                return this.rewards;
            }

            public final RewardScreenInfo copy(int i, String background, String title, String titleHeaders, String buttonName, String description, int i2, String color, List<RewardItem> rewards) {
                Intrinsics.checkNotNullParameter(background, "background");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(titleHeaders, "titleHeaders");
                Intrinsics.checkNotNullParameter(buttonName, "buttonName");
                Intrinsics.checkNotNullParameter(description, "description");
                Intrinsics.checkNotNullParameter(color, "color");
                Intrinsics.checkNotNullParameter(rewards, "rewards");
                return new RewardScreenInfo(i, background, title, titleHeaders, buttonName, description, i2, color, rewards);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof RewardScreenInfo) {
                    RewardScreenInfo rewardScreenInfo = (RewardScreenInfo) obj;
                    return this.type == rewardScreenInfo.type && Intrinsics.areEqual(this.background, rewardScreenInfo.background) && Intrinsics.areEqual(this.title, rewardScreenInfo.title) && Intrinsics.areEqual(this.titleHeaders, rewardScreenInfo.titleHeaders) && Intrinsics.areEqual(this.buttonName, rewardScreenInfo.buttonName) && Intrinsics.areEqual(this.description, rewardScreenInfo.description) && this.time == rewardScreenInfo.time && Intrinsics.areEqual(this.color, rewardScreenInfo.color) && Intrinsics.areEqual(this.rewards, rewardScreenInfo.rewards);
                }
                return false;
            }

            public int hashCode() {
                return (((((((((((((((Integer.hashCode(this.type) * 31) + this.background.hashCode()) * 31) + this.title.hashCode()) * 31) + this.titleHeaders.hashCode()) * 31) + this.buttonName.hashCode()) * 31) + this.description.hashCode()) * 31) + Integer.hashCode(this.time)) * 31) + this.color.hashCode()) * 31) + this.rewards.hashCode();
            }

            public String toString() {
                int i = this.type;
                String str = this.background;
                String str2 = this.title;
                String str3 = this.titleHeaders;
                String str4 = this.buttonName;
                String str5 = this.description;
                int i2 = this.time;
                String str6 = this.color;
                return "RewardScreenInfo(type=" + i + ", background=" + str + ", title=" + str2 + ", titleHeaders=" + str3 + ", buttonName=" + str4 + ", description=" + str5 + ", time=" + i2 + ", color=" + str6 + ", rewards=" + this.rewards + ")";
            }

            public RewardScreenInfo(int i, String background, String title, String titleHeaders, String buttonName, String description, int i2, String color, List<RewardItem> rewards) {
                Intrinsics.checkNotNullParameter(background, "background");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(titleHeaders, "titleHeaders");
                Intrinsics.checkNotNullParameter(buttonName, "buttonName");
                Intrinsics.checkNotNullParameter(description, "description");
                Intrinsics.checkNotNullParameter(color, "color");
                Intrinsics.checkNotNullParameter(rewards, "rewards");
                this.type = i;
                this.background = background;
                this.title = title;
                this.titleHeaders = titleHeaders;
                this.buttonName = buttonName;
                this.description = description;
                this.time = i2;
                this.color = color;
                this.rewards = rewards;
            }

            public final int getType() {
                return this.type;
            }

            public final String getBackground() {
                return this.background;
            }

            public final String getButtonName() {
                return this.buttonName;
            }

            public final String getDescription() {
                return this.description;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getTitleHeaders() {
                return this.titleHeaders;
            }

            public final String getColor() {
                return this.color;
            }

            public final List<RewardItem> getRewards() {
                return this.rewards;
            }

            public final int getTime() {
                return this.time;
            }
        }

        private Companion() {
        }

        /* compiled from: RewardsScreen.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/rewards_screen/RewardsScreen$Companion$RewardItem;", "", "title", "", "value", "badge", "image", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getValue", "getBadge", "getImage", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class RewardItem {
            private final String badge;
            private final String image;
            private final String title;
            private final String value;

            public static /* synthetic */ RewardItem copy$default(RewardItem rewardItem, String str, String str2, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = rewardItem.title;
                }
                if ((i & 2) != 0) {
                    str2 = rewardItem.value;
                }
                if ((i & 4) != 0) {
                    str3 = rewardItem.badge;
                }
                if ((i & 8) != 0) {
                    str4 = rewardItem.image;
                }
                return rewardItem.copy(str, str2, str3, str4);
            }

            public final String component1() {
                return this.title;
            }

            public final String component2() {
                return this.value;
            }

            public final String component3() {
                return this.badge;
            }

            public final String component4() {
                return this.image;
            }

            public final RewardItem copy(String title, String value, String badge, String image) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(badge, "badge");
                Intrinsics.checkNotNullParameter(image, "image");
                return new RewardItem(title, value, badge, image);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof RewardItem) {
                    RewardItem rewardItem = (RewardItem) obj;
                    return Intrinsics.areEqual(this.title, rewardItem.title) && Intrinsics.areEqual(this.value, rewardItem.value) && Intrinsics.areEqual(this.badge, rewardItem.badge) && Intrinsics.areEqual(this.image, rewardItem.image);
                }
                return false;
            }

            public int hashCode() {
                return (((((this.title.hashCode() * 31) + this.value.hashCode()) * 31) + this.badge.hashCode()) * 31) + this.image.hashCode();
            }

            public String toString() {
                String str = this.title;
                String str2 = this.value;
                String str3 = this.badge;
                return "RewardItem(title=" + str + ", value=" + str2 + ", badge=" + str3 + ", image=" + this.image + ")";
            }

            public RewardItem(String title, String value, String badge, String image) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(badge, "badge");
                Intrinsics.checkNotNullParameter(image, "image");
                this.title = title;
                this.value = value;
                this.badge = badge;
                this.image = image;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getValue() {
                return this.value;
            }

            public final String getBadge() {
                return this.badge;
            }

            public final String getImage() {
                return this.image;
            }
        }
    }

    /* compiled from: RewardsScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/rewards_screen/RewardsScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new RewardsScreen(targetActivity, i);
        }
    }
}
