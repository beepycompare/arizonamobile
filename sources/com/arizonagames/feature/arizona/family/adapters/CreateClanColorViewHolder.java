package com.arizonagames.feature.arizona.family.adapters;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.arizonagames.feature.arizona.family.databinding.FamilyCreateColorItemBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CreateClanColorAdapter.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/arizonagames/feature/arizona/family/adapters/CreateClanColorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "cntx", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getCntx", "()Landroid/content/Context;", "binding", "Lcom/arizonagames/feature/arizona/family/databinding/FamilyCreateColorItemBinding;", "getBinding", "()Lcom/arizonagames/feature/arizona/family/databinding/FamilyCreateColorItemBinding;", "family"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CreateClanColorViewHolder extends RecyclerView.ViewHolder {
    private final FamilyCreateColorItemBinding binding;
    private final Context cntx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateClanColorViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.cntx = view.getContext();
        FamilyCreateColorItemBinding bind = FamilyCreateColorItemBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
    }

    public final Context getCntx() {
        return this.cntx;
    }

    public final FamilyCreateColorItemBinding getBinding() {
        return this.binding;
    }
}
