package com.skydoves.cloudy;

import android.graphics.Bitmap;
import com.skydoves.cloudy.internals.SkySnapshot;
import com.skydoves.cloudy.internals.render.RenderScriptToolkit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: CloudyBackground.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.skydoves.cloudy.CloudyBackgroundModifierNode$drawWithBitmap$3$success$1", f = "CloudyBackground.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes5.dex */
final class CloudyBackgroundModifierNode$drawWithBitmap$3$success$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ SkySnapshot $capturedSnapshot;
    final /* synthetic */ Bitmap $outputBitmap;
    final /* synthetic */ RenderScriptToolkit.ProgressiveDirection $progressiveDir;
    final /* synthetic */ Bitmap $softwareBitmap;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloudyBackgroundModifierNode$drawWithBitmap$3$success$1(Bitmap bitmap, Bitmap bitmap2, SkySnapshot skySnapshot, RenderScriptToolkit.ProgressiveDirection progressiveDirection, Continuation<? super CloudyBackgroundModifierNode$drawWithBitmap$3$success$1> continuation) {
        super(2, continuation);
        this.$softwareBitmap = bitmap;
        this.$outputBitmap = bitmap2;
        this.$capturedSnapshot = skySnapshot;
        this.$progressiveDir = progressiveDirection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CloudyBackgroundModifierNode$drawWithBitmap$3$success$1(this.$softwareBitmap, this.$outputBitmap, this.$capturedSnapshot, this.$progressiveDir, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((CloudyBackgroundModifierNode$drawWithBitmap$3$success$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return Boxing.boxBoolean(RenderScriptToolkit.INSTANCE.backgroundBlur$cloudy_release(this.$softwareBitmap, this.$outputBitmap, RangesKt.coerceAtLeast((int) this.$capturedSnapshot.getOffsetX(), 0), RangesKt.coerceAtLeast((int) this.$capturedSnapshot.getOffsetY(), 0), RangesKt.coerceIn(this.$capturedSnapshot.getRadius(), 1, 25), 0.25f, this.$progressiveDir, this.$capturedSnapshot.getFadeStart(), this.$capturedSnapshot.getFadeEnd()));
    }
}
