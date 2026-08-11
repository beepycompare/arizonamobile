package ru.mrlargha.commonui.elements.shop.viewholder;

import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
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
import ru.mrlargha.commonui.databinding.ItemInventoryBinding;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.elements.inventory.presentation.UtilKt;
import ru.mrlargha.commonui.elements.shop.ShopMoneyFormatterKt;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.ui.money.MoneyElementKt;
/* compiled from: LavkaTypeViewHolder.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lru/mrlargha/commonui/elements/shop/viewholder/LavkaTypeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemInventoryBinding;", "onItemClicked", "Lkotlin/Function1;", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "", "<init>", "(Lru/mrlargha/commonui/databinding/ItemInventoryBinding;Lkotlin/jvm/functions/Function1;)V", "loadImageJob", "Lkotlinx/coroutines/Job;", "effectLoadJob", "bind", "itemVal", "recycle", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class LavkaTypeViewHolder extends RecyclerView.ViewHolder {
    private final ItemInventoryBinding binding;
    private Job effectLoadJob;
    private Job loadImageJob;
    private final Function1<InventoryItem, Unit> onItemClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LavkaTypeViewHolder(ItemInventoryBinding binding, Function1<? super InventoryItem, Unit> onItemClicked) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.binding = binding;
        this.onItemClicked = onItemClicked;
    }

    public final void bind(final InventoryItem itemVal) {
        Job launch$default;
        Long amount;
        Intrinsics.checkNotNullParameter(itemVal, "itemVal");
        ItemInventoryBinding itemInventoryBinding = this.binding;
        Job job = this.effectLoadJob;
        Object obj = null;
        boolean z = true;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        itemInventoryBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.shop.viewholder.LavkaTypeViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LavkaTypeViewHolder.bind$lambda$0$0(InventoryItem.this, this, view);
            }
        });
        Job job2 = this.loadImageJob;
        if (job2 != null) {
            Job.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        if (itemVal.getItem() != null) {
            itemInventoryBinding.tvTitleText.setIncludeFontPadding(true);
            itemInventoryBinding.tvTitleText.setPadding(0, 0, 0, 0);
            itemInventoryBinding.tvTitleText.setText(itemVal.getText());
            if (Intrinsics.areEqual(itemVal.getText(), "$") && (amount = itemVal.getAmount()) != null) {
                SpannableString shopMoneyFormattedSpannable = ShopMoneyFormatterKt.toShopMoneyFormattedSpannable(amount.longValue());
                itemInventoryBinding.tvTitleText.setIncludeFontPadding(false);
                itemInventoryBinding.tvTitleText.setPadding(0, 0, itemInventoryBinding.getRoot().getResources().getDimensionPixelSize(R.dimen._1sdp), 0);
                TextView textView = itemInventoryBinding.tvTitleText;
                int length = shopMoneyFormattedSpannable.length();
                SpannableString spannableString = shopMoneyFormattedSpannable;
                if (length > 8) {
                    spannableString = MoneyElementKt.resize(spannableString, 0.9f);
                }
                textView.setText(spannableString);
            }
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new LavkaTypeViewHolder$bind$1$3(itemInventoryBinding, this, itemVal, null), 3, null);
            this.loadImageJob = launch$default;
        } else {
            itemInventoryBinding.ivItemImage.setImageResource(R.drawable.ic_empty_item);
            itemInventoryBinding.tvTitleText.setText("");
        }
        if (itemVal.getBackground() == null) {
            ImageView ivDefaultItem = itemInventoryBinding.ivDefaultItem;
            Intrinsics.checkNotNullExpressionValue(ivDefaultItem, "ivDefaultItem");
            ivDefaultItem.setVisibility(0);
            itemInventoryBinding.ivItemImage.setBackgroundResource(0);
        } else {
            ImageView ivDefaultItem2 = itemInventoryBinding.ivDefaultItem;
            Intrinsics.checkNotNullExpressionValue(ivDefaultItem2, "ivDefaultItem");
            ivDefaultItem2.setVisibility(8);
            itemInventoryBinding.item.setCardBackgroundColor(UtilsKt.getColorTint(itemVal.getBackground().intValue()));
            itemInventoryBinding.ivItemImage.setBackgroundResource(R.drawable.shining_workshop_color);
        }
        AppCompatImageView ivActiveItem = itemInventoryBinding.ivActiveItem;
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
        View viewCenter = itemInventoryBinding.viewCenter;
        Intrinsics.checkNotNullExpressionValue(viewCenter, "viewCenter");
        Integer blackout = itemVal.getBlackout();
        if (blackout == null || blackout.intValue() != 1) {
            z = false;
        }
        viewCenter.setVisibility(z ? 0 : 8);
        Integer available = itemVal.getAvailable();
        if (available != null && available.intValue() == 0) {
            itemInventoryBinding.getRoot().setClickable(false);
            View viewCenter2 = itemInventoryBinding.viewCenter;
            Intrinsics.checkNotNullExpressionValue(viewCenter2, "viewCenter");
            viewCenter2.setVisibility(0);
        }
        this.effectLoadJob = UtilKt.setInventoryItemEffect(itemInventoryBinding, itemVal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$0(InventoryItem inventoryItem, LavkaTypeViewHolder lavkaTypeViewHolder, View view) {
        Integer available = inventoryItem.getAvailable();
        if ((available != null && available.intValue() == 0) || inventoryItem.getItem() == null) {
            return;
        }
        lavkaTypeViewHolder.onItemClicked.invoke(inventoryItem);
    }

    public final void recycle() {
        ItemInventoryBinding itemInventoryBinding = this.binding;
        Job job = this.loadImageJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.loadImageJob = null;
        Job job2 = this.effectLoadJob;
        if (job2 != null) {
            Job.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.effectLoadJob = null;
        UtilKt.clearInventoryItemEffect(itemInventoryBinding);
    }
}
