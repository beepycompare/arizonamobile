package ru.mrlargha.commonui.elements.tuningAuto.presentation.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.ItemUserCartBinding;
import ru.mrlargha.commonui.elements.tuningAuto.domain.CategoryComponents;
/* compiled from: UserCartAdapter.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lru/mrlargha/commonui/elements/tuningAuto/presentation/adapter/UserCartViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemUserCartBinding;", "onItemClicked", "Lkotlin/Function1;", "Lru/mrlargha/commonui/elements/tuningAuto/domain/CategoryComponents;", "", "<init>", "(Lru/mrlargha/commonui/databinding/ItemUserCartBinding;Lkotlin/jvm/functions/Function1;)V", "bind", "item", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserCartViewHolder extends RecyclerView.ViewHolder {
    private final ItemUserCartBinding binding;
    private final Function1<CategoryComponents, Unit> onItemClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UserCartViewHolder(ItemUserCartBinding binding, Function1<? super CategoryComponents, Unit> onItemClicked) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.binding = binding;
        this.onItemClicked = onItemClicked;
    }

    public final void bind(final CategoryComponents item) {
        Intrinsics.checkNotNullParameter(item, "item");
        ItemUserCartBinding itemUserCartBinding = this.binding;
        itemUserCartBinding.tvItemName.setText(item.getName());
        itemUserCartBinding.tvItemPrice.setText(String.valueOf(item.getPrice()));
        itemUserCartBinding.ivRemoveCart.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.adapter.UserCartViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCartViewHolder.bind$lambda$1$lambda$0(UserCartViewHolder.this, item, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1$lambda$0(UserCartViewHolder userCartViewHolder, CategoryComponents categoryComponents, View view) {
        userCartViewHolder.onItemClicked.invoke(categoryComponents);
    }
}
