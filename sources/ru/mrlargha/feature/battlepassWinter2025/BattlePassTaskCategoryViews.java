package ru.mrlargha.feature.battlepassWinter2025;

import android.view.View;
import android.widget.TextView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BattlePassUi.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/BattlePassTaskCategoryViews;", "", TtmlNode.RUBY_CONTAINER, "Landroid/view/View;", "text", "Landroid/widget/TextView;", "<init>", "(Landroid/view/View;Landroid/widget/TextView;)V", "getContainer", "()Landroid/view/View;", "getText", "()Landroid/widget/TextView;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BattlePassTaskCategoryViews {
    private final View container;
    private final TextView text;

    public static /* synthetic */ BattlePassTaskCategoryViews copy$default(BattlePassTaskCategoryViews battlePassTaskCategoryViews, View view, TextView textView, int i, Object obj) {
        if ((i & 1) != 0) {
            view = battlePassTaskCategoryViews.container;
        }
        if ((i & 2) != 0) {
            textView = battlePassTaskCategoryViews.text;
        }
        return battlePassTaskCategoryViews.copy(view, textView);
    }

    public final View component1() {
        return this.container;
    }

    public final TextView component2() {
        return this.text;
    }

    public final BattlePassTaskCategoryViews copy(View container, TextView text) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(text, "text");
        return new BattlePassTaskCategoryViews(container, text);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BattlePassTaskCategoryViews) {
            BattlePassTaskCategoryViews battlePassTaskCategoryViews = (BattlePassTaskCategoryViews) obj;
            return Intrinsics.areEqual(this.container, battlePassTaskCategoryViews.container) && Intrinsics.areEqual(this.text, battlePassTaskCategoryViews.text);
        }
        return false;
    }

    public int hashCode() {
        return (this.container.hashCode() * 31) + this.text.hashCode();
    }

    public String toString() {
        View view = this.container;
        return "BattlePassTaskCategoryViews(container=" + view + ", text=" + this.text + ")";
    }

    public BattlePassTaskCategoryViews(View container, TextView text) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(text, "text");
        this.container = container;
        this.text = text;
    }

    public final View getContainer() {
        return this.container;
    }

    public final TextView getText() {
        return this.text;
    }
}
