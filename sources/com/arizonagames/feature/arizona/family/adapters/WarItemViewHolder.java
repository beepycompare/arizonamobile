package com.arizonagames.feature.arizona.family.adapters;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.arizonagames.feature.arizona.family.databinding.FamilyWarItemBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WarsAdapter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/arizonagames/feature/arizona/family/adapters/WarItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lcom/arizonagames/feature/arizona/family/databinding/FamilyWarItemBinding;", "getBinding", "()Lcom/arizonagames/feature/arizona/family/databinding/FamilyWarItemBinding;", "family_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WarItemViewHolder extends RecyclerView.ViewHolder {
    private final FamilyWarItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WarItemViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        FamilyWarItemBinding bind = FamilyWarItemBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
    }

    public final FamilyWarItemBinding getBinding() {
        return this.binding;
    }
}
