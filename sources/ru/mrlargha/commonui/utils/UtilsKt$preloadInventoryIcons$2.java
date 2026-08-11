package ru.mrlargha.commonui.utils;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.utils.UtilsKt$preloadInventoryIcons$2", f = "Utils.kt", i = {0}, l = {243}, m = "invokeSuspend", n = {"$this$coroutineScope"}, nl = {-1}, s = {"L$0"}, v = 2)
/* loaded from: classes6.dex */
public final class UtilsKt$preloadInventoryIcons$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Bitmap>>, Object> {
    final /* synthetic */ List<InventoryIconRequest> $missingRequests;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UtilsKt$preloadInventoryIcons$2(List<InventoryIconRequest> list, Continuation<? super UtilsKt$preloadInventoryIcons$2> continuation) {
        super(2, continuation);
        this.$missingRequests = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UtilsKt$preloadInventoryIcons$2 utilsKt$preloadInventoryIcons$2 = new UtilsKt$preloadInventoryIcons$2(this.$missingRequests, continuation);
        utilsKt$preloadInventoryIcons$2.L$0 = obj;
        return utilsKt$preloadInventoryIcons$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Bitmap>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<Bitmap>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<Bitmap>> continuation) {
        return ((UtilsKt$preloadInventoryIcons$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Deferred async$default;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
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
        List<InventoryIconRequest> list = this.$missingRequests;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (InventoryIconRequest inventoryIconRequest : list) {
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new UtilsKt$preloadInventoryIcons$2$1$1(inventoryIconRequest, null), 3, null);
            arrayList.add(async$default);
        }
        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
        this.label = 1;
        Object awaitAll = AwaitKt.awaitAll(arrayList, this);
        return awaitAll == coroutine_suspended ? coroutine_suspended : awaitAll;
    }
}
