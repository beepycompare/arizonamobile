package ru.mrlargha.feature.mobile.presentation.page.rent_accessory.adapters;

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
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.feature.mobile.databinding.MobileRentAccessoryElementItemBinding;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryModelItem;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MobileRentAccessoryMainAdapter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent_accessory.adapters.MobileRentAccessoryMainAdapter$MainViewHolder$initItems$1$1$1$1", f = "MobileRentAccessoryMainAdapter.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, nl = {151}, s = {}, v = 2)
/* loaded from: classes6.dex */
public final class MobileRentAccessoryMainAdapter$MainViewHolder$initItems$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MobileRentAccessoryElementItemBinding $itemBinding;
    final /* synthetic */ MobileRentAccessoryModelItem $model;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileRentAccessoryMainAdapter$MainViewHolder$initItems$1$1$1$1(MobileRentAccessoryElementItemBinding mobileRentAccessoryElementItemBinding, MobileRentAccessoryModelItem mobileRentAccessoryModelItem, Continuation<? super MobileRentAccessoryMainAdapter$MainViewHolder$initItems$1$1$1$1> continuation) {
        super(2, continuation);
        this.$itemBinding = mobileRentAccessoryElementItemBinding;
        this.$model = mobileRentAccessoryModelItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MobileRentAccessoryMainAdapter$MainViewHolder$initItems$1$1$1$1(this.$itemBinding, this.$model, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MobileRentAccessoryMainAdapter$MainViewHolder$initItems$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ImageView ivItem = this.$itemBinding.ivItem;
            Intrinsics.checkNotNullExpressionValue(ivItem, "ivItem");
            this.label = 1;
            if (UtilsKt.setImageFromArchive(ivItem, "items", this.$model.getItemID(), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
