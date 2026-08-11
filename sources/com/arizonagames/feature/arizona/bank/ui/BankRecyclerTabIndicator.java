package com.arizonagames.feature.arizona.bank.ui;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankSlidingTabIndicator.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bJ\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/ui/BankRecyclerTabIndicator;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "indicator", "Landroid/view/View;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;)V", "slidingIndicator", "Lcom/arizonagames/feature/arizona/bank/ui/BankSlidingTabIndicator;", "selectedPosition", "", "selectedTarget", "selectedTargetLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "select", "", "position", "update", "animate", "", "clearSelectedTarget", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankRecyclerTabIndicator {
    private final RecyclerView recyclerView;
    private int selectedPosition;
    private View selectedTarget;
    private final View.OnLayoutChangeListener selectedTargetLayoutListener;
    private final BankSlidingTabIndicator slidingIndicator;

    public BankRecyclerTabIndicator(RecyclerView recyclerView, View indicator) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(indicator, "indicator");
        this.recyclerView = recyclerView;
        this.slidingIndicator = new BankSlidingTabIndicator(indicator);
        this.selectedPosition = -1;
        this.selectedTargetLayoutListener = new View.OnLayoutChangeListener() { // from class: com.arizonagames.feature.arizona.bank.ui.BankRecyclerTabIndicator$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                BankRecyclerTabIndicator.selectedTargetLayoutListener$lambda$0(BankRecyclerTabIndicator.this, view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        };
        recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.arizonagames.feature.arizona.bank.ui.BankRecyclerTabIndicator$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                BankRecyclerTabIndicator.this.update(false);
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.arizonagames.feature.arizona.bank.ui.BankRecyclerTabIndicator.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i, int i2) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                BankRecyclerTabIndicator.this.update(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void selectedTargetLayoutListener$lambda$0(BankRecyclerTabIndicator bankRecyclerTabIndicator, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (view == bankRecyclerTabIndicator.selectedTarget) {
            if (i == i5 && i2 == i6 && i3 == i7 && i4 == i8) {
                return;
            }
            BankSlidingTabIndicator bankSlidingTabIndicator = bankRecyclerTabIndicator.slidingIndicator;
            Intrinsics.checkNotNull(view);
            bankSlidingTabIndicator.moveTo(view, false);
        }
    }

    public final void select(final int i) {
        if (i == -1) {
            this.selectedPosition = -1;
            clearSelectedTarget();
            this.slidingIndicator.hide();
            return;
        }
        final boolean z = this.selectedPosition != -1;
        this.selectedPosition = i;
        this.recyclerView.post(new Runnable() { // from class: com.arizonagames.feature.arizona.bank.ui.BankRecyclerTabIndicator$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                BankRecyclerTabIndicator.select$lambda$0(BankRecyclerTabIndicator.this, i, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void select$lambda$0(BankRecyclerTabIndicator bankRecyclerTabIndicator, int i, boolean z) {
        bankRecyclerTabIndicator.recyclerView.smoothScrollToPosition(i);
        bankRecyclerTabIndicator.update(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void update(boolean z) {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition;
        View view;
        int i = this.selectedPosition;
        if (i == -1 || (findViewHolderForAdapterPosition = this.recyclerView.findViewHolderForAdapterPosition(i)) == null || (view = findViewHolderForAdapterPosition.itemView) == null) {
            return;
        }
        if (this.selectedTarget != view) {
            clearSelectedTarget();
            this.selectedTarget = view;
            view.addOnLayoutChangeListener(this.selectedTargetLayoutListener);
        }
        this.slidingIndicator.moveTo(view, z);
    }

    private final void clearSelectedTarget() {
        View view = this.selectedTarget;
        if (view != null) {
            view.removeOnLayoutChangeListener(this.selectedTargetLayoutListener);
        }
        this.selectedTarget = null;
    }
}
