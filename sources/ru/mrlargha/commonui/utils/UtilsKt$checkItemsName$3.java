package ru.mrlargha.commonui.utils;

import android.util.Log;
import com.google.android.vending.licensing.Policy;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.commonui.elements.inventory.domain.InventoryApi;
import ru.mrlargha.commonui.elements.inventory.domain.InventoryCatalogKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.utils.UtilsKt$checkItemsName$3", f = "Utils.kt", i = {1, 2, 2}, l = {560, 562, 569}, m = "invokeSuspend", n = {"exception", "result", "loadedCatalog"}, nl = {Policy.NOT_LICENSED, 563, 574}, s = {"L$0", "L$0", "L$1"}, v = 2)
/* loaded from: classes6.dex */
public final class UtilsKt$checkItemsName$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ InventoryApi $api;
    final /* synthetic */ String $key;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UtilsKt$checkItemsName$3(InventoryApi inventoryApi, String str, Continuation<? super UtilsKt$checkItemsName$3> continuation) {
        super(2, continuation);
        this.$api = inventoryApi;
        this.$key = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UtilsKt$checkItemsName$3(this.$api, this.$key, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UtilsKt$checkItemsName$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x008d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object m9915constructorimpl;
        Object completeInventoryCatalogLoad;
        Object completeInventoryCatalogLoad2;
        Object obj2;
        Throwable m9918exceptionOrNullimpl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (CancellationException e) {
            this.L$0 = e;
            this.label = 2;
            completeInventoryCatalogLoad = UtilsKt.completeInventoryCatalogLoad(this.$key, null, false, this);
            if (completeInventoryCatalogLoad != coroutine_suspended) {
                throw e;
            }
        } catch (Throwable th) {
            Result.Companion companion = Result.Companion;
            m9915constructorimpl = Result.m9915constructorimpl(ResultKt.createFailure(th));
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Result.Companion companion2 = Result.Companion;
            this.label = 1;
            obj = this.$api.get(this.$key, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            if (i == 2) {
                CancellationException cancellationException = (CancellationException) this.L$0;
                ResultKt.throwOnFailure(obj);
                throw cancellationException;
            } else if (i == 3) {
                List list = (List) this.L$1;
                obj2 = this.L$0;
                ResultKt.throwOnFailure(obj);
                m9918exceptionOrNullimpl = Result.m9918exceptionOrNullimpl(obj2);
                if (m9918exceptionOrNullimpl != null) {
                    Log.e("InventoryCatalog", "Unable to load catalog '" + this.$key + "'", m9918exceptionOrNullimpl);
                }
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
        }
        m9915constructorimpl = Result.m9915constructorimpl(InventoryCatalogKt.normalizeInventoryCatalog((List) obj));
        List list2 = Result.m9921isFailureimpl(m9915constructorimpl) ? null : m9915constructorimpl;
        String str = this.$key;
        boolean z = list2 != null;
        this.L$0 = m9915constructorimpl;
        this.L$1 = SpillingKt.nullOutSpilledVariable(list2);
        this.label = 3;
        completeInventoryCatalogLoad2 = UtilsKt.completeInventoryCatalogLoad(str, list2, z, this);
        if (completeInventoryCatalogLoad2 != coroutine_suspended) {
            obj2 = m9915constructorimpl;
            m9918exceptionOrNullimpl = Result.m9918exceptionOrNullimpl(obj2);
            if (m9918exceptionOrNullimpl != null) {
            }
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }
}
