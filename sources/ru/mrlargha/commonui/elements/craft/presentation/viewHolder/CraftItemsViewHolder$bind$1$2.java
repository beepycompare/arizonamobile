package ru.mrlargha.commonui.elements.craft.presentation.viewHolder;

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
import ru.mrlargha.commonui.databinding.ItemBulletBinding;
import ru.mrlargha.commonui.elements.craft.domain.CraftItem;
import ru.mrlargha.commonui.utils.UtilsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CraftItemsViewHolder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.craft.presentation.viewHolder.CraftItemsViewHolder$bind$1$2", f = "CraftItemsViewHolder.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class CraftItemsViewHolder$bind$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CraftItem $item;
    final /* synthetic */ ItemBulletBinding $this_with;
    int label;
    final /* synthetic */ CraftItemsViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CraftItemsViewHolder$bind$1$2(ItemBulletBinding itemBulletBinding, CraftItemsViewHolder craftItemsViewHolder, CraftItem craftItem, Continuation<? super CraftItemsViewHolder$bind$1$2> continuation) {
        super(2, continuation);
        this.$this_with = itemBulletBinding;
        this.this$0 = craftItemsViewHolder;
        this.$item = craftItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CraftItemsViewHolder$bind$1$2(this.$this_with, this.this$0, this.$item, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CraftItemsViewHolder$bind$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ItemBulletBinding itemBulletBinding;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new CraftItemsViewHolder$bind$1$2$bitmap$1(this.$item, null), this);
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
            ImageView ivItemIcon = this.$this_with.ivItemIcon;
            Intrinsics.checkNotNullExpressionValue(ivItemIcon, "ivItemIcon");
            UtilsKt.setImage(ivItemIcon, bitmap);
        } else {
            ImageView ivItemIcon2 = this.$this_with.ivItemIcon;
            Intrinsics.checkNotNullExpressionValue(ivItemIcon2, "ivItemIcon");
            itemBulletBinding = this.this$0.binding;
            Context context = itemBulletBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            UtilsKt.setNotLoadedImage(ivItemIcon2, context);
        }
        return Unit.INSTANCE;
    }
}
