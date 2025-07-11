package ru.mrlargha.commonui.elements.craft.presentation.viewHolder;

import android.content.SharedPreferences;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.ItemMenuBtnBinding;
import ru.mrlargha.commonui.elements.craft.domain.CraftResponseKt;
/* compiled from: CraftMenuViewHolder.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/craft/presentation/viewHolder/CraftMenuViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemMenuBtnBinding;", "onItemClicked", "Lkotlin/Function2;", "", "", "<init>", "(Lru/mrlargha/commonui/databinding/ItemMenuBtnBinding;Lkotlin/jvm/functions/Function2;)V", "sharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "isArizonaType", "", "bind", "item", "position", "selectedItemPosition", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CraftMenuViewHolder extends RecyclerView.ViewHolder {
    private final ItemMenuBtnBinding binding;
    private final boolean isArizonaType;
    private final Function2<Integer, Integer, Unit> onItemClicked;
    private final SharedPreferences sharedPref;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CraftMenuViewHolder(ItemMenuBtnBinding binding, Function2<? super Integer, ? super Integer, Unit> onItemClicked) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.binding = binding;
        this.onItemClicked = onItemClicked;
        SharedPreferences sharedPreferences = binding.getRoot().getContext().getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        this.isArizonaType = sharedPreferences.getBoolean("isArizonaType", false);
    }

    public final void bind(final int i, int i2, int i3) {
        ItemMenuBtnBinding itemMenuBtnBinding = this.binding;
        if (this.isArizonaType) {
            itemMenuBtnBinding.tvCraftMenu.setText(CraftResponseKt.getArizonaCraftCategories().get(i));
        } else {
            itemMenuBtnBinding.tvCraftMenu.setText(CraftResponseKt.getRodinaCraftCategories().get(i));
        }
        if (i2 == i3) {
            itemMenuBtnBinding.parentLayout.setBackgroundResource(R.drawable.paralel_white);
            itemMenuBtnBinding.tvCraftMenu.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        } else {
            itemMenuBtnBinding.parentLayout.setBackgroundResource(R.drawable.paralel_grey);
            itemMenuBtnBinding.tvCraftMenu.setTextColor(-1);
        }
        itemMenuBtnBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.craft.presentation.viewHolder.CraftMenuViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CraftMenuViewHolder.bind$lambda$1$lambda$0(CraftMenuViewHolder.this, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1$lambda$0(CraftMenuViewHolder craftMenuViewHolder, int i, View view) {
        craftMenuViewHolder.onItemClicked.invoke(Integer.valueOf(i), Integer.valueOf(craftMenuViewHolder.getAdapterPosition()));
    }
}
