package ru.mrlargha.commonui.elements.inventory.presentation.viewHolder;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.ItemSubInventoryBinding;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.utils.InventoryIconRequest;
import ru.mrlargha.commonui.utils.ItemTypes;
import ru.mrlargha.commonui.utils.UtilsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpgradesInventoryViewHolder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.inventory.presentation.viewHolder.UpgradesInventoryViewHolder$bind$1$2", f = "UpgradesInventoryViewHolder.kt", i = {0}, l = {101}, m = "invokeSuspend", n = {"$this$launch"}, nl = {104}, s = {"L$0"}, v = 2)
/* loaded from: classes6.dex */
public final class UpgradesInventoryViewHolder$bind$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ InventoryIconRequest $iconRequest;
    final /* synthetic */ InventoryItem $itemVal;
    final /* synthetic */ long $requestGeneration;
    final /* synthetic */ ItemSubInventoryBinding $this_with;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UpgradesInventoryViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpgradesInventoryViewHolder$bind$1$2(long j, UpgradesInventoryViewHolder upgradesInventoryViewHolder, InventoryIconRequest inventoryIconRequest, ItemSubInventoryBinding itemSubInventoryBinding, InventoryItem inventoryItem, Continuation<? super UpgradesInventoryViewHolder$bind$1$2> continuation) {
        super(2, continuation);
        this.$requestGeneration = j;
        this.this$0 = upgradesInventoryViewHolder;
        this.$iconRequest = inventoryIconRequest;
        this.$this_with = itemSubInventoryBinding;
        this.$itemVal = inventoryItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UpgradesInventoryViewHolder$bind$1$2 upgradesInventoryViewHolder$bind$1$2 = new UpgradesInventoryViewHolder$bind$1$2(this.$requestGeneration, this.this$0, this.$iconRequest, this.$this_with, this.$itemVal, continuation);
        upgradesInventoryViewHolder$bind$1$2.L$0 = obj;
        return upgradesInventoryViewHolder$bind$1$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UpgradesInventoryViewHolder$bind$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long j;
        ItemSubInventoryBinding itemSubInventoryBinding;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new UpgradesInventoryViewHolder$bind$1$2$bitmap$1(this.$iconRequest, null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        Bitmap bitmap = (Bitmap) obj;
        long j2 = this.$requestGeneration;
        j = this.this$0.imageRequestGeneration;
        if (j2 != j) {
            return Unit.INSTANCE;
        }
        if (bitmap != null) {
            ImageView ivItemImage = this.$this_with.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
            UtilsKt.setImage(ivItemImage, bitmap);
        } else {
            InventoryItem inventoryItem = this.$itemVal;
            ItemSubInventoryBinding itemSubInventoryBinding2 = this.$this_with;
            UpgradesInventoryViewHolder upgradesInventoryViewHolder = this.this$0;
            Integer item_type = inventoryItem.getItem_type();
            int id = ItemTypes.ITEM_TYPE_GUN_SKIN.getId();
            if (item_type != null && item_type.intValue() == id) {
                itemSubInventoryBinding2.ivItemImage.setImageResource(R.drawable.inventory_item_type_gun_skin_ic);
            } else {
                ImageView ivItemImage2 = itemSubInventoryBinding2.ivItemImage;
                Intrinsics.checkNotNullExpressionValue(ivItemImage2, "ivItemImage");
                itemSubInventoryBinding = upgradesInventoryViewHolder.binding;
                Context context = itemSubInventoryBinding.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                UtilsKt.setNotLoadedImage(ivItemImage2, context);
            }
        }
        return Unit.INSTANCE;
    }
}
