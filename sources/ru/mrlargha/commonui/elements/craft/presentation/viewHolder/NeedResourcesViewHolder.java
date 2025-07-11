package ru.mrlargha.commonui.elements.craft.presentation.viewHolder;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.ItemInventoryBinding;
import ru.mrlargha.commonui.elements.craft.domain.NeedItemsUi;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: NeedResourcesViewHolder.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/mrlargha/commonui/elements/craft/presentation/viewHolder/NeedResourcesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemInventoryBinding;", "onItemClicked", "Lkotlin/Function1;", "", "", "<init>", "(Lru/mrlargha/commonui/databinding/ItemInventoryBinding;Lkotlin/jvm/functions/Function1;)V", "bind", "itemVal", "Lru/mrlargha/commonui/elements/craft/domain/NeedItemsUi;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NeedResourcesViewHolder extends RecyclerView.ViewHolder {
    private final ItemInventoryBinding binding;
    private final Function1<Integer, Unit> onItemClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NeedResourcesViewHolder(ItemInventoryBinding binding, Function1<? super Integer, Unit> onItemClicked) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.binding = binding;
        this.onItemClicked = onItemClicked;
    }

    public final void bind(final NeedItemsUi itemVal) {
        Intrinsics.checkNotNullParameter(itemVal, "itemVal");
        ItemInventoryBinding itemInventoryBinding = this.binding;
        View viewCenter = itemInventoryBinding.viewCenter;
        Intrinsics.checkNotNullExpressionValue(viewCenter, "viewCenter");
        viewCenter.setVisibility(itemVal.getAmountHave() >= itemVal.getAmountNeed() ? 8 : 0);
        itemInventoryBinding.tvTitleText.setText(itemVal.getAmountHave() + RemoteSettings.FORWARD_SLASH_STRING + itemVal.getAmountNeed());
        Bitmap iconFromArchive$default = UtilsKt.getIconFromArchive$default(FirebaseAnalytics.Param.ITEMS, itemVal.getItem(), null, 4, null);
        if (iconFromArchive$default != null) {
            ImageView ivItemImage = itemInventoryBinding.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
            UtilsKt.setImage(ivItemImage, iconFromArchive$default);
        }
        itemInventoryBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.craft.presentation.viewHolder.NeedResourcesViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NeedResourcesViewHolder.bind$lambda$2$lambda$1(NeedResourcesViewHolder.this, itemVal, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$2$lambda$1(NeedResourcesViewHolder needResourcesViewHolder, NeedItemsUi needItemsUi, View view) {
        needResourcesViewHolder.onItemClicked.invoke(Integer.valueOf(needItemsUi.getItem()));
    }
}
