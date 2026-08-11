package ru.mrlargha.commonui.elements.inventory.presentation.viewHolder;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.commonui.utils.InventoryIconRequest;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: SubInventoryViewHolder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.inventory.presentation.viewHolder.SubInventoryViewHolder$bind$1$1$bitmap$1", f = "SubInventoryViewHolder.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
/* loaded from: classes6.dex */
final class SubInventoryViewHolder$bind$1$1$bitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ InventoryIconRequest $iconRequest;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubInventoryViewHolder$bind$1$1$bitmap$1(InventoryIconRequest inventoryIconRequest, Continuation<? super SubInventoryViewHolder$bind$1$1$bitmap$1> continuation) {
        super(2, continuation);
        this.$iconRequest = inventoryIconRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubInventoryViewHolder$bind$1$1$bitmap$1(this.$iconRequest, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return ((SubInventoryViewHolder$bind$1$1$bitmap$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        Object loadInventoryIcon = UtilsKt.loadInventoryIcon(this.$iconRequest, this);
        return loadInventoryIcon == coroutine_suspended ? coroutine_suspended : loadInventoryIcon;
    }
}
