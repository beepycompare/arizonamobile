package ru.mrlargha.commonui.utils;

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
import kotlinx.coroutines.sync.Semaphore;
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.utils.UtilsKt$preloadInventoryIcons$2$1$1", f = "Utils.kt", i = {0, 1}, l = {936, 240}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv"}, nl = {937, 938}, s = {"L$0", "L$0"}, v = 2)
/* loaded from: classes6.dex */
final class UtilsKt$preloadInventoryIcons$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ InventoryIconRequest $request;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UtilsKt$preloadInventoryIcons$2$1$1(InventoryIconRequest inventoryIconRequest, Continuation<? super UtilsKt$preloadInventoryIcons$2$1$1> continuation) {
        super(2, continuation);
        this.$request = inventoryIconRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UtilsKt$preloadInventoryIcons$2$1$1(this.$request, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return ((UtilsKt$preloadInventoryIcons$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
        if (r7.acquire(r6) == r0) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Semaphore semaphore;
        InventoryIconRequest inventoryIconRequest;
        Throwable th;
        Semaphore semaphore2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                semaphore = UtilsKt.inventoryIconPreloadSemaphore;
                inventoryIconRequest = this.$request;
                this.L$0 = semaphore;
                this.L$1 = inventoryIconRequest;
                this.label = 1;
            } else if (i != 1) {
                if (i == 2) {
                    semaphore2 = (Semaphore) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Bitmap bitmap = (Bitmap) obj;
                        semaphore2.release();
                        return bitmap;
                    } catch (Throwable th2) {
                        th = th2;
                        semaphore2.release();
                        throw th;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                inventoryIconRequest = (InventoryIconRequest) this.L$1;
                ResultKt.throwOnFailure(obj);
                semaphore = (Semaphore) this.L$0;
            }
            this.L$0 = semaphore;
            this.L$1 = null;
            this.label = 2;
            Object loadInventoryIcon = UtilsKt.loadInventoryIcon(inventoryIconRequest, this);
            if (loadInventoryIcon != coroutine_suspended) {
                Semaphore semaphore3 = semaphore;
                obj = loadInventoryIcon;
                semaphore2 = semaphore3;
                Bitmap bitmap2 = (Bitmap) obj;
                semaphore2.release();
                return bitmap2;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Semaphore semaphore4 = semaphore;
            th = th3;
            semaphore2 = semaphore4;
            semaphore2.release();
            throw th;
        }
    }
}
