package ru.mrlargha.feature.battlepassWinter2025;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BattlePassUi.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/BattlePassNavigationItemViews;", "", TtmlNode.RUBY_CONTAINER, "Landroid/view/View;", "text", "Landroid/widget/TextView;", "icon", "Landroid/widget/ImageView;", "<init>", "(Landroid/view/View;Landroid/widget/TextView;Landroid/widget/ImageView;)V", "getContainer", "()Landroid/view/View;", "getText", "()Landroid/widget/TextView;", "getIcon", "()Landroid/widget/ImageView;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BattlePassNavigationItemViews {
    private final View container;
    private final ImageView icon;
    private final TextView text;

    public static /* synthetic */ BattlePassNavigationItemViews copy$default(BattlePassNavigationItemViews battlePassNavigationItemViews, View view, TextView textView, ImageView imageView, int i, Object obj) {
        if ((i & 1) != 0) {
            view = battlePassNavigationItemViews.container;
        }
        if ((i & 2) != 0) {
            textView = battlePassNavigationItemViews.text;
        }
        if ((i & 4) != 0) {
            imageView = battlePassNavigationItemViews.icon;
        }
        return battlePassNavigationItemViews.copy(view, textView, imageView);
    }

    public final View component1() {
        return this.container;
    }

    public final TextView component2() {
        return this.text;
    }

    public final ImageView component3() {
        return this.icon;
    }

    public final BattlePassNavigationItemViews copy(View container, TextView text, ImageView icon) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new BattlePassNavigationItemViews(container, text, icon);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BattlePassNavigationItemViews) {
            BattlePassNavigationItemViews battlePassNavigationItemViews = (BattlePassNavigationItemViews) obj;
            return Intrinsics.areEqual(this.container, battlePassNavigationItemViews.container) && Intrinsics.areEqual(this.text, battlePassNavigationItemViews.text) && Intrinsics.areEqual(this.icon, battlePassNavigationItemViews.icon);
        }
        return false;
    }

    public int hashCode() {
        return (((this.container.hashCode() * 31) + this.text.hashCode()) * 31) + this.icon.hashCode();
    }

    public String toString() {
        View view = this.container;
        TextView textView = this.text;
        return "BattlePassNavigationItemViews(container=" + view + ", text=" + textView + ", icon=" + this.icon + ")";
    }

    public BattlePassNavigationItemViews(View container, TextView text, ImageView icon) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.container = container;
        this.text = text;
        this.icon = icon;
    }

    public final View getContainer() {
        return this.container;
    }

    public final TextView getText() {
        return this.text;
    }

    public final ImageView getIcon() {
        return this.icon;
    }
}
