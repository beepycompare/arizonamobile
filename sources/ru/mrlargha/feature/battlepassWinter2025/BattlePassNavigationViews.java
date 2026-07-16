package ru.mrlargha.feature.battlepassWinter2025;

import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
/* compiled from: BattlePassUi.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020$HÖ\u0081\u0004J\n\u0010%\u001a\u00020&HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006'"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/BattlePassNavigationViews;", "", "backButton", "Landroid/view/View;", JvmProtoBufUtil.DEFAULT_MODULE_NAME, "Lru/mrlargha/feature/battlepassWinter2025/BattlePassNavigationItemViews;", "tasks", "cases", "currencyContainer", "currencyText", "Landroid/widget/TextView;", "currencyAddButton", "<init>", "(Landroid/view/View;Lru/mrlargha/feature/battlepassWinter2025/BattlePassNavigationItemViews;Lru/mrlargha/feature/battlepassWinter2025/BattlePassNavigationItemViews;Lru/mrlargha/feature/battlepassWinter2025/BattlePassNavigationItemViews;Landroid/view/View;Landroid/widget/TextView;Landroid/view/View;)V", "getBackButton", "()Landroid/view/View;", "getMain", "()Lru/mrlargha/feature/battlepassWinter2025/BattlePassNavigationItemViews;", "getTasks", "getCases", "getCurrencyContainer", "getCurrencyText", "()Landroid/widget/TextView;", "getCurrencyAddButton", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BattlePassNavigationViews {
    private final View backButton;
    private final BattlePassNavigationItemViews cases;
    private final View currencyAddButton;
    private final View currencyContainer;
    private final TextView currencyText;
    private final BattlePassNavigationItemViews main;
    private final BattlePassNavigationItemViews tasks;

    public static /* synthetic */ BattlePassNavigationViews copy$default(BattlePassNavigationViews battlePassNavigationViews, View view, BattlePassNavigationItemViews battlePassNavigationItemViews, BattlePassNavigationItemViews battlePassNavigationItemViews2, BattlePassNavigationItemViews battlePassNavigationItemViews3, View view2, TextView textView, View view3, int i, Object obj) {
        if ((i & 1) != 0) {
            view = battlePassNavigationViews.backButton;
        }
        if ((i & 2) != 0) {
            battlePassNavigationItemViews = battlePassNavigationViews.main;
        }
        if ((i & 4) != 0) {
            battlePassNavigationItemViews2 = battlePassNavigationViews.tasks;
        }
        if ((i & 8) != 0) {
            battlePassNavigationItemViews3 = battlePassNavigationViews.cases;
        }
        if ((i & 16) != 0) {
            view2 = battlePassNavigationViews.currencyContainer;
        }
        if ((i & 32) != 0) {
            textView = battlePassNavigationViews.currencyText;
        }
        if ((i & 64) != 0) {
            view3 = battlePassNavigationViews.currencyAddButton;
        }
        TextView textView2 = textView;
        View view4 = view3;
        View view5 = view2;
        BattlePassNavigationItemViews battlePassNavigationItemViews4 = battlePassNavigationItemViews2;
        return battlePassNavigationViews.copy(view, battlePassNavigationItemViews, battlePassNavigationItemViews4, battlePassNavigationItemViews3, view5, textView2, view4);
    }

    public final View component1() {
        return this.backButton;
    }

    public final BattlePassNavigationItemViews component2() {
        return this.main;
    }

    public final BattlePassNavigationItemViews component3() {
        return this.tasks;
    }

    public final BattlePassNavigationItemViews component4() {
        return this.cases;
    }

    public final View component5() {
        return this.currencyContainer;
    }

    public final TextView component6() {
        return this.currencyText;
    }

    public final View component7() {
        return this.currencyAddButton;
    }

    public final BattlePassNavigationViews copy(View backButton, BattlePassNavigationItemViews main, BattlePassNavigationItemViews tasks, BattlePassNavigationItemViews cases, View currencyContainer, TextView currencyText, View view) {
        Intrinsics.checkNotNullParameter(backButton, "backButton");
        Intrinsics.checkNotNullParameter(main, "main");
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        Intrinsics.checkNotNullParameter(cases, "cases");
        Intrinsics.checkNotNullParameter(currencyContainer, "currencyContainer");
        Intrinsics.checkNotNullParameter(currencyText, "currencyText");
        return new BattlePassNavigationViews(backButton, main, tasks, cases, currencyContainer, currencyText, view);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BattlePassNavigationViews) {
            BattlePassNavigationViews battlePassNavigationViews = (BattlePassNavigationViews) obj;
            return Intrinsics.areEqual(this.backButton, battlePassNavigationViews.backButton) && Intrinsics.areEqual(this.main, battlePassNavigationViews.main) && Intrinsics.areEqual(this.tasks, battlePassNavigationViews.tasks) && Intrinsics.areEqual(this.cases, battlePassNavigationViews.cases) && Intrinsics.areEqual(this.currencyContainer, battlePassNavigationViews.currencyContainer) && Intrinsics.areEqual(this.currencyText, battlePassNavigationViews.currencyText) && Intrinsics.areEqual(this.currencyAddButton, battlePassNavigationViews.currencyAddButton);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.backButton.hashCode() * 31) + this.main.hashCode()) * 31) + this.tasks.hashCode()) * 31) + this.cases.hashCode()) * 31) + this.currencyContainer.hashCode()) * 31) + this.currencyText.hashCode()) * 31;
        View view = this.currencyAddButton;
        return hashCode + (view == null ? 0 : view.hashCode());
    }

    public String toString() {
        View view = this.backButton;
        BattlePassNavigationItemViews battlePassNavigationItemViews = this.main;
        BattlePassNavigationItemViews battlePassNavigationItemViews2 = this.tasks;
        BattlePassNavigationItemViews battlePassNavigationItemViews3 = this.cases;
        View view2 = this.currencyContainer;
        TextView textView = this.currencyText;
        return "BattlePassNavigationViews(backButton=" + view + ", main=" + battlePassNavigationItemViews + ", tasks=" + battlePassNavigationItemViews2 + ", cases=" + battlePassNavigationItemViews3 + ", currencyContainer=" + view2 + ", currencyText=" + textView + ", currencyAddButton=" + this.currencyAddButton + ")";
    }

    public BattlePassNavigationViews(View backButton, BattlePassNavigationItemViews main, BattlePassNavigationItemViews tasks, BattlePassNavigationItemViews cases, View currencyContainer, TextView currencyText, View view) {
        Intrinsics.checkNotNullParameter(backButton, "backButton");
        Intrinsics.checkNotNullParameter(main, "main");
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        Intrinsics.checkNotNullParameter(cases, "cases");
        Intrinsics.checkNotNullParameter(currencyContainer, "currencyContainer");
        Intrinsics.checkNotNullParameter(currencyText, "currencyText");
        this.backButton = backButton;
        this.main = main;
        this.tasks = tasks;
        this.cases = cases;
        this.currencyContainer = currencyContainer;
        this.currencyText = currencyText;
        this.currencyAddButton = view;
    }

    public /* synthetic */ BattlePassNavigationViews(View view, BattlePassNavigationItemViews battlePassNavigationItemViews, BattlePassNavigationItemViews battlePassNavigationItemViews2, BattlePassNavigationItemViews battlePassNavigationItemViews3, View view2, TextView textView, View view3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, battlePassNavigationItemViews, battlePassNavigationItemViews2, battlePassNavigationItemViews3, view2, textView, (i & 64) != 0 ? null : view3);
    }

    public final View getBackButton() {
        return this.backButton;
    }

    public final BattlePassNavigationItemViews getMain() {
        return this.main;
    }

    public final BattlePassNavigationItemViews getTasks() {
        return this.tasks;
    }

    public final BattlePassNavigationItemViews getCases() {
        return this.cases;
    }

    public final View getCurrencyContainer() {
        return this.currencyContainer;
    }

    public final TextView getCurrencyText() {
        return this.currencyText;
    }

    public final View getCurrencyAddButton() {
        return this.currencyAddButton;
    }
}
