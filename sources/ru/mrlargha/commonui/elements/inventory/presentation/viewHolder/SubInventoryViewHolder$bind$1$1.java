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
import ru.mrlargha.commonui.databinding.ItemSubInventoryBinding;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.utils.UtilsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubInventoryViewHolder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.inventory.presentation.viewHolder.SubInventoryViewHolder$bind$1$1", f = "SubInventoryViewHolder.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class SubInventoryViewHolder$bind$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ InventoryItem $itemVal;
    final /* synthetic */ ItemSubInventoryBinding $this_with;
    int label;
    final /* synthetic */ SubInventoryViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubInventoryViewHolder$bind$1$1(ItemSubInventoryBinding itemSubInventoryBinding, SubInventoryViewHolder subInventoryViewHolder, InventoryItem inventoryItem, Continuation<? super SubInventoryViewHolder$bind$1$1> continuation) {
        super(2, continuation);
        this.$this_with = itemSubInventoryBinding;
        this.this$0 = subInventoryViewHolder;
        this.$itemVal = inventoryItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubInventoryViewHolder$bind$1$1(this.$this_with, this.this$0, this.$itemVal, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SubInventoryViewHolder$bind$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ItemSubInventoryBinding itemSubInventoryBinding;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new SubInventoryViewHolder$bind$1$1$bitmap$1(this.$itemVal, null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap != null) {
            ImageView ivItemImage = this.$this_with.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
            UtilsKt.setImage(ivItemImage, bitmap);
        } else {
            ImageView ivItemImage2 = this.$this_with.ivItemImage;
            Intrinsics.checkNotNullExpressionValue(ivItemImage2, "ivItemImage");
            itemSubInventoryBinding = this.this$0.binding;
            Context context = itemSubInventoryBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            UtilsKt.setNotLoadedImage(ivItemImage2, context);
        }
        return Unit.INSTANCE;
    }
}
