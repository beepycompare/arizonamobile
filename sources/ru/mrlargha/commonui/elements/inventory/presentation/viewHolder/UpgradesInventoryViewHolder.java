package ru.mrlargha.commonui.elements.inventory.presentation.viewHolder;

import android.os.CountDownTimer;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.adjust.sdk.Constants;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.ItemSubInventoryBinding;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.DraggedItem;
import ru.mrlargha.commonui.utils.ArizonaBlockType;
import ru.mrlargha.commonui.utils.GsonStore;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.RodinaBlockType;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: UpgradesInventoryViewHolder.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/viewHolder/UpgradesInventoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemSubInventoryBinding;", "onItemDropped", "Lkotlin/Function1;", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/DraggedItem;", "", "onLongClicked", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "onItemClicked", "<init>", "(Lru/mrlargha/commonui/databinding/ItemSubInventoryBinding;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "countDownTimer", "Landroid/os/CountDownTimer;", "loadImageJob", "Lkotlinx/coroutines/Job;", "bind", "itemVal", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UpgradesInventoryViewHolder extends RecyclerView.ViewHolder {
    private final ItemSubInventoryBinding binding;
    private CountDownTimer countDownTimer;
    private Job loadImageJob;
    private final Function1<InventoryItem, Unit> onItemClicked;
    private final Function1<DraggedItem, Unit> onItemDropped;
    private final Function1<InventoryItem, Unit> onLongClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UpgradesInventoryViewHolder(ItemSubInventoryBinding binding, Function1<? super DraggedItem, Unit> onItemDropped, Function1<? super InventoryItem, Unit> onLongClicked, Function1<? super InventoryItem, Unit> onItemClicked) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onItemDropped, "onItemDropped");
        Intrinsics.checkNotNullParameter(onLongClicked, "onLongClicked");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.binding = binding;
        this.onItemDropped = onItemDropped;
        this.onLongClicked = onLongClicked;
        this.onItemClicked = onItemClicked;
    }

    /* JADX WARN: Type inference failed for: r3v44, types: [ru.mrlargha.commonui.elements.inventory.presentation.viewHolder.UpgradesInventoryViewHolder$bind$1$6] */
    public final void bind(final InventoryItem itemVal) {
        Object obj;
        Job launch$default;
        Intrinsics.checkNotNullParameter(itemVal, "itemVal");
        final ItemSubInventoryBinding itemSubInventoryBinding = this.binding;
        Job job = this.loadImageJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (itemVal.getItem() != null) {
            TextView tvItemNum = itemSubInventoryBinding.tvItemNum;
            Intrinsics.checkNotNullExpressionValue(tvItemNum, "tvItemNum");
            tvItemNum.setVisibility(8);
            TextView tvDescriptionText = itemSubInventoryBinding.tvDescriptionText;
            Intrinsics.checkNotNullExpressionValue(tvDescriptionText, "tvDescriptionText");
            tvDescriptionText.setVisibility(0);
            itemSubInventoryBinding.tvDescriptionText.setText(itemVal.getText());
            ImageView ivItemImage = itemSubInventoryBinding.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
            ivItemImage.setVisibility(0);
            if (itemVal.getInventoryType() != RodinaBlockType.BLOCK_TYPE_WALLET.getId() || itemVal.getInventoryType() != RodinaBlockType.BLOCK_TYPE_ACTOR_WEAPON.getId() || itemVal.getInventoryType() != ArizonaBlockType.BLOCK_TYPE_WALLET.getId() || itemVal.getInventoryType() != ArizonaBlockType.BLOCK_TYPE_ACTOR_WEAPON.getId() || itemVal.getInventoryType() != ArizonaBlockType.BLOCK_TYPE_FISHBAG.getId()) {
                itemSubInventoryBinding.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.viewHolder.UpgradesInventoryViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        boolean bind$lambda$4$lambda$0;
                        bind$lambda$4$lambda$0 = UpgradesInventoryViewHolder.bind$lambda$4$lambda$0(UpgradesInventoryViewHolder.this, itemVal, view);
                        return bind$lambda$4$lambda$0;
                    }
                });
            }
        } else {
            TextView tvDescriptionText2 = itemSubInventoryBinding.tvDescriptionText;
            Intrinsics.checkNotNullExpressionValue(tvDescriptionText2, "tvDescriptionText");
            tvDescriptionText2.setVisibility(8);
            TextView tvItemNum2 = itemSubInventoryBinding.tvItemNum;
            Intrinsics.checkNotNullExpressionValue(tvItemNum2, "tvItemNum");
            tvItemNum2.setVisibility(0);
            itemSubInventoryBinding.tvItemNum.setText(String.valueOf(getAdapterPosition() + 1));
        }
        if (itemVal.getItem() != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new UpgradesInventoryViewHolder$bind$1$2(itemSubInventoryBinding, this, itemVal, null), 3, null);
            this.loadImageJob = launch$default;
            TextView tvTitleText = itemSubInventoryBinding.tvTitleText;
            Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
            tvTitleText.setVisibility(8);
            ImageView ivItemDefaultImage = itemSubInventoryBinding.ivItemDefaultImage;
            Intrinsics.checkNotNullExpressionValue(ivItemDefaultImage, "ivItemDefaultImage");
            ivItemDefaultImage.setVisibility(8);
        } else {
            itemSubInventoryBinding.ivItemImage.setImageResource(R.drawable.ic_empty_item);
            ImageView ivItemDefaultImage2 = itemSubInventoryBinding.ivItemDefaultImage;
            Intrinsics.checkNotNullExpressionValue(ivItemDefaultImage2, "ivItemDefaultImage");
            ivItemDefaultImage2.setVisibility(8);
        }
        if (itemVal.getItem() == null && (itemVal.getInventoryType() == RodinaBlockType.BLOCK_TYPE_ACTOR_WEAPON.getId() || itemVal.getInventoryType() == ArizonaBlockType.BLOCK_TYPE_ACTOR_WEAPON.getId())) {
            ImageView ivItemDefaultImage3 = itemSubInventoryBinding.ivItemDefaultImage;
            Intrinsics.checkNotNullExpressionValue(ivItemDefaultImage3, "ivItemDefaultImage");
            ivItemDefaultImage3.setVisibility(0);
            itemSubInventoryBinding.ivItemDefaultImage.setImageResource(R.drawable.ic_guard_weapon);
            TextView tvDescriptionText3 = itemSubInventoryBinding.tvDescriptionText;
            Intrinsics.checkNotNullExpressionValue(tvDescriptionText3, "tvDescriptionText");
            tvDescriptionText3.setVisibility(8);
            TextView tvTitleText2 = itemSubInventoryBinding.tvTitleText;
            Intrinsics.checkNotNullExpressionValue(tvTitleText2, "tvTitleText");
            tvTitleText2.setVisibility(0);
            itemSubInventoryBinding.tvTitleText.setText(this.binding.getRoot().getContext().getString(R.string.weapon));
            TextView tvItemNum3 = itemSubInventoryBinding.tvItemNum;
            Intrinsics.checkNotNullExpressionValue(tvItemNum3, "tvItemNum");
            tvItemNum3.setVisibility(8);
        }
        if (itemVal.getBackground() == null) {
            ImageView ivDefaultItem = itemSubInventoryBinding.ivDefaultItem;
            Intrinsics.checkNotNullExpressionValue(ivDefaultItem, "ivDefaultItem");
            ivDefaultItem.setVisibility(0);
            itemSubInventoryBinding.ivItemImage.setBackgroundResource(0);
        } else {
            ImageView ivDefaultItem2 = itemSubInventoryBinding.ivDefaultItem;
            Intrinsics.checkNotNullExpressionValue(ivDefaultItem2, "ivDefaultItem");
            ivDefaultItem2.setVisibility(8);
            itemSubInventoryBinding.parentItem.setCardBackgroundColor(UtilsKt.getColorTint(itemVal.getBackground().intValue()));
            itemSubInventoryBinding.ivItemImage.setBackgroundResource(R.drawable.shining_workshop_color);
        }
        View viewColored = itemSubInventoryBinding.viewColored;
        Intrinsics.checkNotNullExpressionValue(viewColored, "viewColored");
        viewColored.setVisibility(itemVal.isColored() ? 0 : 8);
        View viewCenter = itemSubInventoryBinding.viewCenter;
        Intrinsics.checkNotNullExpressionValue(viewCenter, "viewCenter");
        Integer blackout = itemVal.getBlackout();
        viewCenter.setVisibility(blackout != null && blackout.intValue() == 1 ? 0 : 8);
        Integer available = itemVal.getAvailable();
        if (available != null && available.intValue() == 0) {
            itemSubInventoryBinding.getRoot().setClickable(false);
            View viewCenter2 = itemSubInventoryBinding.viewCenter;
            Intrinsics.checkNotNullExpressionValue(viewCenter2, "viewCenter");
            viewCenter2.setVisibility(0);
        }
        itemSubInventoryBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.viewHolder.UpgradesInventoryViewHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UpgradesInventoryViewHolder.bind$lambda$4$lambda$1(UpgradesInventoryViewHolder.this, itemVal, view);
            }
        });
        itemSubInventoryBinding.getRoot().setOnDragListener(new View.OnDragListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.viewHolder.UpgradesInventoryViewHolder$$ExternalSyntheticLambda2
            @Override // android.view.View.OnDragListener
            public final boolean onDrag(View view, DragEvent dragEvent) {
                boolean bind$lambda$4$lambda$2;
                bind$lambda$4$lambda$2 = UpgradesInventoryViewHolder.bind$lambda$4$lambda$2(UpgradesInventoryViewHolder.this, view, dragEvent);
                return bind$lambda$4$lambda$2;
            }
        });
        AppCompatImageView ivActiveItem = itemSubInventoryBinding.ivActiveItem;
        Intrinsics.checkNotNullExpressionValue(ivActiveItem, "ivActiveItem");
        AppCompatImageView appCompatImageView = ivActiveItem;
        Iterator<T> it = UtilsKt.getItemsName().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            int id = ((ItemsInfo) obj).getId();
            Integer item = itemVal.getItem();
            if (item != null && id == item.intValue()) {
                break;
            }
        }
        ItemsInfo itemsInfo = (ItemsInfo) obj;
        appCompatImageView.setVisibility(itemsInfo != null && itemsInfo.getActive() == 1 ? 0 : 8);
        if (itemVal.getTime() != null && itemVal.getTime().longValue() > 0) {
            final long longValue = (itemVal.getTime().longValue() * 1000) - System.currentTimeMillis();
            CountDownTimer countDownTimer = this.countDownTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.countDownTimer = new CountDownTimer(longValue) { // from class: ru.mrlargha.commonui.elements.inventory.presentation.viewHolder.UpgradesInventoryViewHolder$bind$1$6
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    long j2 = (long) Constants.ONE_HOUR;
                    long j3 = 60000;
                    TextView textView = itemSubInventoryBinding.tvTitleText;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf((int) (j / j2)), Integer.valueOf((int) ((j % j2) / j3)), Integer.valueOf((int) ((j % j3) / 1000))}, 3));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    textView.setText(format);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    TextView tvTitleText3 = itemSubInventoryBinding.tvTitleText;
                    Intrinsics.checkNotNullExpressionValue(tvTitleText3, "tvTitleText");
                    tvTitleText3.setVisibility(8);
                    this.countDownTimer = null;
                }
            }.start();
        } else {
            CountDownTimer countDownTimer2 = this.countDownTimer;
            if (countDownTimer2 != null) {
                countDownTimer2.cancel();
            }
        }
        String text = itemVal.getText();
        if (text != null && StringsKt.contains$default((CharSequence) text, (CharSequence) "day", false, 2, (Object) null)) {
            itemSubInventoryBinding.tvTitleText.setText(itemVal.getText());
            CountDownTimer countDownTimer3 = this.countDownTimer;
            if (countDownTimer3 != null) {
                countDownTimer3.cancel();
            }
        }
        if (itemVal.isLocked()) {
            itemSubInventoryBinding.ivItemImage.setImageResource(R.drawable.ic_locked_item);
            itemSubInventoryBinding.tvTitleText.setText("");
            TextView tvItemNum4 = itemSubInventoryBinding.tvItemNum;
            Intrinsics.checkNotNullExpressionValue(tvItemNum4, "tvItemNum");
            tvItemNum4.setVisibility(8);
        }
        if (itemVal.getColor() != null) {
            CardView cvColoredItem = itemSubInventoryBinding.cvColoredItem;
            Intrinsics.checkNotNullExpressionValue(cvColoredItem, "cvColoredItem");
            cvColoredItem.setVisibility(0);
            itemSubInventoryBinding.cvColoredItem.setCardBackgroundColor(UtilsKt.getColorTint(itemVal.getColor().intValue()));
            return;
        }
        CardView cvColoredItem2 = itemSubInventoryBinding.cvColoredItem;
        Intrinsics.checkNotNullExpressionValue(cvColoredItem2, "cvColoredItem");
        cvColoredItem2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$4$lambda$0(UpgradesInventoryViewHolder upgradesInventoryViewHolder, InventoryItem inventoryItem, View view) {
        upgradesInventoryViewHolder.onLongClicked.invoke(inventoryItem);
        Intrinsics.checkNotNull(view);
        return UtilsKt.setDragClick(inventoryItem, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$4$lambda$1(UpgradesInventoryViewHolder upgradesInventoryViewHolder, InventoryItem inventoryItem, View view) {
        upgradesInventoryViewHolder.onItemClicked.invoke(inventoryItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$4$lambda$2(UpgradesInventoryViewHolder upgradesInventoryViewHolder, View view, DragEvent dragEvent) {
        switch (dragEvent.getAction()) {
            case 1:
                return dragEvent.getClipDescription().hasMimeType("text/plain");
            case 2:
                view.invalidate();
                return true;
            case 3:
                if (dragEvent.getClipData() != null) {
                    Object fromJson = GsonStore.INSTANCE.getGson().fromJson(UtilsKt.updateJsonString(dragEvent.getClipData().getItemAt(0).getText().toString()), (Class<Object>) InventoryItem.class);
                    Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
                    upgradesInventoryViewHolder.onItemDropped.invoke(new DraggedItem((InventoryItem) fromJson, upgradesInventoryViewHolder.getAdapterPosition()));
                }
                view.invalidate();
                Object localState = dragEvent.getLocalState();
                CardView cardView = localState instanceof CardView ? (CardView) localState : null;
                if (cardView != null) {
                    ViewParent parent = cardView.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (cardView.isAttachedToWindow() && viewGroup != null) {
                        viewGroup.removeView(cardView);
                    }
                }
                return true;
            case 4:
            case 6:
                view.invalidate();
                return true;
            case 5:
                view.invalidate();
                return true;
            default:
                return false;
        }
    }
}
