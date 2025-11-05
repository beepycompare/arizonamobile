package ru.mrlargha.employment.center;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Target;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.feature.employment.center.databinding.EmploymentCenterBonusItemBinding;
/* compiled from: BonusesAdapter.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lru/mrlargha/employment/center/EmploymentBonusViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "picassoTarget", "Lcom/squareup/picasso/Target;", "getPicassoTarget", "()Lcom/squareup/picasso/Target;", "setPicassoTarget", "(Lcom/squareup/picasso/Target;)V", "binding", "Lru/mrlargha/feature/employment/center/databinding/EmploymentCenterBonusItemBinding;", "getBinding", "()Lru/mrlargha/feature/employment/center/databinding/EmploymentCenterBonusItemBinding;", "employment-center_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class EmploymentBonusViewHolder extends RecyclerView.ViewHolder {
    private final EmploymentCenterBonusItemBinding binding;
    private Target picassoTarget;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmploymentBonusViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        EmploymentCenterBonusItemBinding bind = EmploymentCenterBonusItemBinding.bind(view);
        this.picassoTarget = new EmploymentBonusViewHolder$binding$1$1(bind);
        Intrinsics.checkNotNullExpressionValue(bind, "apply(...)");
        this.binding = bind;
    }

    public final Target getPicassoTarget() {
        return this.picassoTarget;
    }

    public final void setPicassoTarget(Target target) {
        this.picassoTarget = target;
    }

    public final EmploymentCenterBonusItemBinding getBinding() {
        return this.binding;
    }
}
