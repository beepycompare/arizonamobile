package ru.mrlargha.arizona.promo;

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
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.feature.arizona.promo.databinding.ProgressItemBinding;
/* compiled from: ProgressItemsAdapter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.arizona.promo.ProgressItemsAdapter$onBindViewHolder$1$2", f = "ProgressItemsAdapter.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, nl = {80}, s = {}, v = 2)
/* loaded from: classes6.dex */
final class ProgressItemsAdapter$onBindViewHolder$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PromoReward $item;
    final /* synthetic */ ProgressItemBinding $this_apply;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressItemsAdapter$onBindViewHolder$1$2(PromoReward promoReward, ProgressItemBinding progressItemBinding, Continuation<? super ProgressItemsAdapter$onBindViewHolder$1$2> continuation) {
        super(2, continuation);
        this.$item = promoReward;
        this.$this_apply = progressItemBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProgressItemsAdapter$onBindViewHolder$1$2(this.$item, this.$this_apply, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProgressItemsAdapter$onBindViewHolder$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new ProgressItemsAdapter$onBindViewHolder$1$2$bitmap$1(this.$item, null), this);
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
            ImageView image = this.$this_apply.image;
            Intrinsics.checkNotNullExpressionValue(image, "image");
            UtilsKt.setImage(image, bitmap);
        }
        return Unit.INSTANCE;
    }
}
