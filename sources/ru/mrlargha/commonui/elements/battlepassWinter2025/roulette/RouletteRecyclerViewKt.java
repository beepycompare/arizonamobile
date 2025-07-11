package ru.mrlargha.commonui.elements.battlepassWinter2025.roulette;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RouletteRecyclerView.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"scrollToPositionCentered", "", "Landroidx/recyclerview/widget/RecyclerView;", "targetPosition", "", "CommonUI_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RouletteRecyclerViewKt {
    public static final void scrollToPositionCentered(RecyclerView recyclerView, int i) {
        int height;
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return;
        }
        if (linearLayoutManager.getOrientation() == 0) {
            height = recyclerView.getWidth();
        } else {
            height = recyclerView.getHeight();
        }
        linearLayoutManager.scrollToPositionWithOffset(i, (height / 2) - (recyclerView.getChildAt(0).getHeight() / 2));
    }
}
