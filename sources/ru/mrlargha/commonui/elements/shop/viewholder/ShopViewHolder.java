package ru.mrlargha.commonui.elements.shop.viewholder;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.ItemShopBinding;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: ShopViewHolder.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lru/mrlargha/commonui/elements/shop/viewholder/ShopViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemShopBinding;", "onItemClicked", "Lkotlin/Function1;", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "", "context", "Landroid/content/Context;", "<init>", "(Lru/mrlargha/commonui/databinding/ItemShopBinding;Lkotlin/jvm/functions/Function1;Landroid/content/Context;)V", "loadImageJob", "Lkotlinx/coroutines/Job;", "bind", "itemVal", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShopViewHolder extends RecyclerView.ViewHolder {
    private final ItemShopBinding binding;
    private final Context context;
    private Job loadImageJob;
    private final Function1<InventoryItem, Unit> onItemClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ShopViewHolder(ItemShopBinding binding, Function1<? super InventoryItem, Unit> onItemClicked, Context context) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        Intrinsics.checkNotNullParameter(context, "context");
        this.binding = binding;
        this.onItemClicked = onItemClicked;
        this.context = context;
    }

    public final void bind(final InventoryItem itemVal) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(itemVal, "itemVal");
        ItemShopBinding itemShopBinding = this.binding;
        itemShopBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.shop.viewholder.ShopViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShopViewHolder.bind$lambda$2$lambda$0(InventoryItem.this, this, view);
            }
        });
        Job job = this.loadImageJob;
        Object obj = null;
        boolean z = true;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (itemVal.getItem() != null) {
            itemShopBinding.tvTitleText.setText(itemVal.getText());
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new ShopViewHolder$bind$1$2(itemShopBinding, this, itemVal, null), 3, null);
            this.loadImageJob = launch$default;
        } else {
            itemShopBinding.tvTitleText.setText("");
            itemShopBinding.ivItemImage.setImageResource(R.drawable.ic_empty_item);
        }
        AppCompatImageView ivActiveItem = itemShopBinding.ivActiveItem;
        Intrinsics.checkNotNullExpressionValue(ivActiveItem, "ivActiveItem");
        AppCompatImageView appCompatImageView = ivActiveItem;
        Iterator<T> it = UtilsKt.getItemsName().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int id = ((ItemsInfo) next).getId();
            Integer item = itemVal.getItem();
            if (item != null && id == item.intValue()) {
                obj = next;
                break;
            }
        }
        ItemsInfo itemsInfo = (ItemsInfo) obj;
        appCompatImageView.setVisibility(itemsInfo != null && itemsInfo.getActive() == 1 ? 0 : 8);
        View viewCenter = itemShopBinding.viewCenter;
        Intrinsics.checkNotNullExpressionValue(viewCenter, "viewCenter");
        Integer blackout = itemVal.getBlackout();
        if (blackout == null || blackout.intValue() != 1) {
            z = false;
        }
        viewCenter.setVisibility(z ? 0 : 8);
        Integer available = itemVal.getAvailable();
        if (available != null && available.intValue() == 0) {
            itemShopBinding.getRoot().setClickable(false);
            View viewCenter2 = itemShopBinding.viewCenter;
            Intrinsics.checkNotNullExpressionValue(viewCenter2, "viewCenter");
            viewCenter2.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$2$lambda$0(InventoryItem inventoryItem, ShopViewHolder shopViewHolder, View view) {
        Integer available = inventoryItem.getAvailable();
        if ((available != null && available.intValue() == 0) || inventoryItem.getItem() == null) {
            return;
        }
        shopViewHolder.onItemClicked.invoke(inventoryItem);
    }
}
