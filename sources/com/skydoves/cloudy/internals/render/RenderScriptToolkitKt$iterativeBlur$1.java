package com.skydoves.cloudy.internals.render;

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
/* compiled from: RenderScriptToolkit.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.skydoves.cloudy.internals.render.RenderScriptToolkitKt$iterativeBlur$1", f = "RenderScriptToolkit.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class RenderScriptToolkitKt$iterativeBlur$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Bitmap $androidBitmap;
    final /* synthetic */ Bitmap $outputBitmap;
    final /* synthetic */ int $radius;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RenderScriptToolkitKt$iterativeBlur$1(int i, Bitmap bitmap, Bitmap bitmap2, Continuation<? super RenderScriptToolkitKt$iterativeBlur$1> continuation) {
        super(2, continuation);
        this.$radius = i;
        this.$androidBitmap = bitmap;
        this.$outputBitmap = bitmap2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RenderScriptToolkitKt$iterativeBlur$1(this.$radius, this.$androidBitmap, this.$outputBitmap, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return ((RenderScriptToolkitKt$iterativeBlur$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        int i = (this.$radius + 1) / 25;
        Bitmap blur$default = RenderScriptToolkit.blur$default(RenderScriptToolkit.INSTANCE, this.$androidBitmap, this.$outputBitmap, (this.$radius + 1) % 25, null, 8, null);
        for (int i2 = 0; i2 < i; i2++) {
            blur$default = RenderScriptToolkit.blur$default(RenderScriptToolkit.INSTANCE, blur$default, this.$outputBitmap, 25, null, 8, null);
        }
        return blur$default;
    }
}
