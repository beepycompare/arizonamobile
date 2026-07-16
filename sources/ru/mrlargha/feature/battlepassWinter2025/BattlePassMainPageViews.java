package ru.mrlargha.feature.battlepassWinter2025;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BattlePassUi.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0014\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020%HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/BattlePassMainPageViews;", "", "premiumAction", "Lru/mrlargha/feature/battlepassWinter2025/BattlePassPremiumActionViews;", "remainingTimeText", "Landroid/widget/TextView;", "levelText", "experienceText", "experienceProgress", "Landroid/widget/ProgressBar;", "buyLevelsButton", "Landroid/view/View;", "<init>", "(Lru/mrlargha/feature/battlepassWinter2025/BattlePassPremiumActionViews;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/ProgressBar;Landroid/view/View;)V", "getPremiumAction", "()Lru/mrlargha/feature/battlepassWinter2025/BattlePassPremiumActionViews;", "getRemainingTimeText", "()Landroid/widget/TextView;", "getLevelText", "getExperienceText", "getExperienceProgress", "()Landroid/widget/ProgressBar;", "getBuyLevelsButton", "()Landroid/view/View;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BattlePassMainPageViews {
    private final View buyLevelsButton;
    private final ProgressBar experienceProgress;
    private final TextView experienceText;
    private final TextView levelText;
    private final BattlePassPremiumActionViews premiumAction;
    private final TextView remainingTimeText;

    public static /* synthetic */ BattlePassMainPageViews copy$default(BattlePassMainPageViews battlePassMainPageViews, BattlePassPremiumActionViews battlePassPremiumActionViews, TextView textView, TextView textView2, TextView textView3, ProgressBar progressBar, View view, int i, Object obj) {
        if ((i & 1) != 0) {
            battlePassPremiumActionViews = battlePassMainPageViews.premiumAction;
        }
        if ((i & 2) != 0) {
            textView = battlePassMainPageViews.remainingTimeText;
        }
        if ((i & 4) != 0) {
            textView2 = battlePassMainPageViews.levelText;
        }
        if ((i & 8) != 0) {
            textView3 = battlePassMainPageViews.experienceText;
        }
        if ((i & 16) != 0) {
            progressBar = battlePassMainPageViews.experienceProgress;
        }
        if ((i & 32) != 0) {
            view = battlePassMainPageViews.buyLevelsButton;
        }
        ProgressBar progressBar2 = progressBar;
        View view2 = view;
        return battlePassMainPageViews.copy(battlePassPremiumActionViews, textView, textView2, textView3, progressBar2, view2);
    }

    public final BattlePassPremiumActionViews component1() {
        return this.premiumAction;
    }

    public final TextView component2() {
        return this.remainingTimeText;
    }

    public final TextView component3() {
        return this.levelText;
    }

    public final TextView component4() {
        return this.experienceText;
    }

    public final ProgressBar component5() {
        return this.experienceProgress;
    }

    public final View component6() {
        return this.buyLevelsButton;
    }

    public final BattlePassMainPageViews copy(BattlePassPremiumActionViews premiumAction, TextView remainingTimeText, TextView levelText, TextView experienceText, ProgressBar experienceProgress, View buyLevelsButton) {
        Intrinsics.checkNotNullParameter(premiumAction, "premiumAction");
        Intrinsics.checkNotNullParameter(remainingTimeText, "remainingTimeText");
        Intrinsics.checkNotNullParameter(levelText, "levelText");
        Intrinsics.checkNotNullParameter(experienceText, "experienceText");
        Intrinsics.checkNotNullParameter(experienceProgress, "experienceProgress");
        Intrinsics.checkNotNullParameter(buyLevelsButton, "buyLevelsButton");
        return new BattlePassMainPageViews(premiumAction, remainingTimeText, levelText, experienceText, experienceProgress, buyLevelsButton);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BattlePassMainPageViews) {
            BattlePassMainPageViews battlePassMainPageViews = (BattlePassMainPageViews) obj;
            return Intrinsics.areEqual(this.premiumAction, battlePassMainPageViews.premiumAction) && Intrinsics.areEqual(this.remainingTimeText, battlePassMainPageViews.remainingTimeText) && Intrinsics.areEqual(this.levelText, battlePassMainPageViews.levelText) && Intrinsics.areEqual(this.experienceText, battlePassMainPageViews.experienceText) && Intrinsics.areEqual(this.experienceProgress, battlePassMainPageViews.experienceProgress) && Intrinsics.areEqual(this.buyLevelsButton, battlePassMainPageViews.buyLevelsButton);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.premiumAction.hashCode() * 31) + this.remainingTimeText.hashCode()) * 31) + this.levelText.hashCode()) * 31) + this.experienceText.hashCode()) * 31) + this.experienceProgress.hashCode()) * 31) + this.buyLevelsButton.hashCode();
    }

    public String toString() {
        BattlePassPremiumActionViews battlePassPremiumActionViews = this.premiumAction;
        TextView textView = this.remainingTimeText;
        TextView textView2 = this.levelText;
        TextView textView3 = this.experienceText;
        ProgressBar progressBar = this.experienceProgress;
        return "BattlePassMainPageViews(premiumAction=" + battlePassPremiumActionViews + ", remainingTimeText=" + textView + ", levelText=" + textView2 + ", experienceText=" + textView3 + ", experienceProgress=" + progressBar + ", buyLevelsButton=" + this.buyLevelsButton + ")";
    }

    public BattlePassMainPageViews(BattlePassPremiumActionViews premiumAction, TextView remainingTimeText, TextView levelText, TextView experienceText, ProgressBar experienceProgress, View buyLevelsButton) {
        Intrinsics.checkNotNullParameter(premiumAction, "premiumAction");
        Intrinsics.checkNotNullParameter(remainingTimeText, "remainingTimeText");
        Intrinsics.checkNotNullParameter(levelText, "levelText");
        Intrinsics.checkNotNullParameter(experienceText, "experienceText");
        Intrinsics.checkNotNullParameter(experienceProgress, "experienceProgress");
        Intrinsics.checkNotNullParameter(buyLevelsButton, "buyLevelsButton");
        this.premiumAction = premiumAction;
        this.remainingTimeText = remainingTimeText;
        this.levelText = levelText;
        this.experienceText = experienceText;
        this.experienceProgress = experienceProgress;
        this.buyLevelsButton = buyLevelsButton;
    }

    public final BattlePassPremiumActionViews getPremiumAction() {
        return this.premiumAction;
    }

    public final TextView getRemainingTimeText() {
        return this.remainingTimeText;
    }

    public final TextView getLevelText() {
        return this.levelText;
    }

    public final TextView getExperienceText() {
        return this.experienceText;
    }

    public final ProgressBar getExperienceProgress() {
        return this.experienceProgress;
    }

    public final View getBuyLevelsButton() {
        return this.buyLevelsButton;
    }
}
