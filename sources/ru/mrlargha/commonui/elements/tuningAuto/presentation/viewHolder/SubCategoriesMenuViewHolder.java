package ru.mrlargha.commonui.elements.tuningAuto.presentation.viewHolder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.ItemTuningSubmenuBinding;
import ru.mrlargha.commonui.elements.tuningAuto.domain.CategoryInfo;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: SubCategoriesMenuViewHolder.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lru/mrlargha/commonui/elements/tuningAuto/presentation/viewHolder/SubCategoriesMenuViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemTuningSubmenuBinding;", "onItemClicked", "Lkotlin/Function2;", "Lru/mrlargha/commonui/elements/tuningAuto/domain/CategoryInfo;", "", "", "context", "Landroid/content/Context;", "<init>", "(Lru/mrlargha/commonui/databinding/ItemTuningSubmenuBinding;Lkotlin/jvm/functions/Function2;Landroid/content/Context;)V", "bind", "item", "position", "selectedItemPosition", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubCategoriesMenuViewHolder extends RecyclerView.ViewHolder {
    private final ItemTuningSubmenuBinding binding;
    private final Context context;
    private final Function2<CategoryInfo, Integer, Unit> onItemClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SubCategoriesMenuViewHolder(ItemTuningSubmenuBinding binding, Function2<? super CategoryInfo, ? super Integer, Unit> onItemClicked, Context context) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        Intrinsics.checkNotNullParameter(context, "context");
        this.binding = binding;
        this.onItemClicked = onItemClicked;
        this.context = context;
    }

    public final void bind(final CategoryInfo item, int i, int i2) {
        Intrinsics.checkNotNullParameter(item, "item");
        ItemTuningSubmenuBinding itemTuningSubmenuBinding = this.binding;
        itemTuningSubmenuBinding.tvMenuName.setText(item.getName());
        Drawable drawable = this.context.getResources().getDrawable(this.context.getResources().getIdentifier(UtilsKt.deleteSvgWord(item.getIcon()), "drawable", this.context.getPackageName()));
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(...)");
        itemTuningSubmenuBinding.ivSubMenuIcon.setImageDrawable(drawable);
        View backView = itemTuningSubmenuBinding.backView;
        Intrinsics.checkNotNullExpressionValue(backView, "backView");
        backView.setVisibility(i == i2 ? 0 : 8);
        itemTuningSubmenuBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.viewHolder.SubCategoriesMenuViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubCategoriesMenuViewHolder.bind$lambda$1$lambda$0(SubCategoriesMenuViewHolder.this, item, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1$lambda$0(SubCategoriesMenuViewHolder subCategoriesMenuViewHolder, CategoryInfo categoryInfo, View view) {
        subCategoriesMenuViewHolder.onItemClicked.invoke(categoryInfo, Integer.valueOf(subCategoriesMenuViewHolder.getAdapterPosition()));
    }
}
