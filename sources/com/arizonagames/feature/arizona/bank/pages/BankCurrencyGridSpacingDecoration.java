package com.arizonagames.feature.arizona.bank.pages;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankCurrencyPageController.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankCurrencyGridSpacingDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "columns", "", "spacing", "<init>", "(II)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/recyclerview/widget/RecyclerView$State;", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final class BankCurrencyGridSpacingDecoration extends RecyclerView.ItemDecoration {
    private final int columns;
    private final int spacing;

    public BankCurrencyGridSpacingDecoration(int i, int i2) {
        this.columns = i;
        this.spacing = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (childAdapterPosition == -1) {
            return;
        }
        if (childAdapterPosition >= this.columns) {
            outRect.top = this.spacing;
        }
        if (childAdapterPosition % this.columns != 0) {
            outRect.left = this.spacing;
        }
    }
}
