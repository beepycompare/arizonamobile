package com.skydoves.cloudy;

import android.graphics.Bitmap;
import com.skydoves.cloudy.internals.render.RenderScriptToolkitKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: CloudyLegacyBlurStrategy.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.skydoves.cloudy.CloudyModifierNode$draw$2$blurResult$1", f = "CloudyLegacyBlurStrategy.kt", i = {0, 0}, l = {229}, m = "invokeSuspend", n = {"$this$withContext", "outputBitmap"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes5.dex */
final class CloudyModifierNode$draw$2$blurResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ int $currentRadius;
    final /* synthetic */ Bitmap $softwareBitmap;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloudyModifierNode$draw$2$blurResult$1(Bitmap bitmap, int i, Continuation<? super CloudyModifierNode$draw$2$blurResult$1> continuation) {
        super(2, continuation);
        this.$softwareBitmap = bitmap;
        this.$currentRadius = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CloudyModifierNode$draw$2$blurResult$1 cloudyModifierNode$draw$2$blurResult$1 = new CloudyModifierNode$draw$2$blurResult$1(this.$softwareBitmap, this.$currentRadius, continuation);
        cloudyModifierNode$draw$2$blurResult$1.L$0 = obj;
        return cloudyModifierNode$draw$2$blurResult$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return ((CloudyModifierNode$draw$2$blurResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                Bitmap bitmap = (Bitmap) this.L$1;
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Bitmap androidBitmap = PlatformBitmap_androidKt.toAndroidBitmap(PlatformBitmap_androidKt.createCompatible(PlatformBitmap_androidKt.toPlatformBitmap(this.$softwareBitmap)));
        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
        this.L$1 = SpillingKt.nullOutSpilledVariable(androidBitmap);
        this.label = 1;
        Object await = RenderScriptToolkitKt.iterativeBlur(coroutineScope, this.$softwareBitmap, androidBitmap, this.$currentRadius).await(this);
        return await == coroutine_suspended ? coroutine_suspended : await;
    }
}
