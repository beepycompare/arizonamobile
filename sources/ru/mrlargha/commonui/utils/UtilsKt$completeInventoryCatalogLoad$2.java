package ru.mrlargha.commonui.utils;

import android.util.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.utils.UtilsKt$completeInventoryCatalogLoad$2", f = "Utils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes6.dex */
public final class UtilsKt$completeInventoryCatalogLoad$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Function1<Boolean, Unit>> $callbacks;
    final /* synthetic */ boolean $success;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UtilsKt$completeInventoryCatalogLoad$2(List<? extends Function1<? super Boolean, Unit>> list, boolean z, Continuation<? super UtilsKt$completeInventoryCatalogLoad$2> continuation) {
        super(2, continuation);
        this.$callbacks = list;
        this.$success = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UtilsKt$completeInventoryCatalogLoad$2 utilsKt$completeInventoryCatalogLoad$2 = new UtilsKt$completeInventoryCatalogLoad$2(this.$callbacks, this.$success, continuation);
        utilsKt$completeInventoryCatalogLoad$2.L$0 = obj;
        return utilsKt$completeInventoryCatalogLoad$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UtilsKt$completeInventoryCatalogLoad$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m9920constructorimpl;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        boolean z = this.$success;
        Iterator<T> it = this.$callbacks.iterator();
        while (it.hasNext()) {
            Function1 function1 = (Function1) it.next();
            try {
                Result.Companion companion = Result.Companion;
                function1.invoke(Boxing.boxBoolean(z));
                m9920constructorimpl = Result.m9920constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m9920constructorimpl = Result.m9920constructorimpl(ResultKt.createFailure(th));
            }
            Throwable m9923exceptionOrNullimpl = Result.m9923exceptionOrNullimpl(m9920constructorimpl);
            if (m9923exceptionOrNullimpl != null) {
                Log.e("InventoryCatalog", "Inventory catalog callback failed", m9923exceptionOrNullimpl);
            }
        }
        return Unit.INSTANCE;
    }
}
