package ru.mrlargha.commonui.elements.shop.viewholder;

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
import ru.mrlargha.commonui.databinding.ItemLavkaTypeBinding;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.utils.UtilsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LavkaTypeViewHolder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.shop.viewholder.LavkaTypeViewHolder$bind$1$2", f = "LavkaTypeViewHolder.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class LavkaTypeViewHolder$bind$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ InventoryItem $itemVal;
    final /* synthetic */ ItemLavkaTypeBinding $this_with;
    int label;
    final /* synthetic */ LavkaTypeViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LavkaTypeViewHolder$bind$1$2(ItemLavkaTypeBinding itemLavkaTypeBinding, LavkaTypeViewHolder lavkaTypeViewHolder, InventoryItem inventoryItem, Continuation<? super LavkaTypeViewHolder$bind$1$2> continuation) {
        super(2, continuation);
        this.$this_with = itemLavkaTypeBinding;
        this.this$0 = lavkaTypeViewHolder;
        this.$itemVal = inventoryItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LavkaTypeViewHolder$bind$1$2(this.$this_with, this.this$0, this.$itemVal, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LavkaTypeViewHolder$bind$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ItemLavkaTypeBinding itemLavkaTypeBinding;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new LavkaTypeViewHolder$bind$1$2$bitmap$1(this.$itemVal, null), this);
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
            itemLavkaTypeBinding = this.this$0.binding;
            Context context = itemLavkaTypeBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            UtilsKt.setNotLoadedImage(ivItemImage2, context);
        }
        return Unit.INSTANCE;
    }
}
