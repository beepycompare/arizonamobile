package com.arizonagames.feature.arizona.certificate;

import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
/* compiled from: CertificateScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.arizonagames.feature.arizona.certificate.CertificateScreen$startAnimatedScreen$2$1", f = "CertificateScreen.kt", i = {0, 0}, l = {TsExtractor.TS_STREAM_TYPE_DTS}, m = "invokeSuspend", n = {"$this$launch", "currentZoom"}, nl = {TsExtractor.TS_STREAM_TYPE_DTS_UHD}, s = {"L$0", "F$0"}, v = 2)
/* loaded from: classes3.dex */
final class CertificateScreen$startAnimatedScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MainInfo $it;
    final /* synthetic */ float $zoomBase;
    final /* synthetic */ float $zoomMax;
    final /* synthetic */ float $zoomTick;
    float F$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CertificateScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CertificateScreen$startAnimatedScreen$2$1(float f, float f2, float f3, CertificateScreen certificateScreen, MainInfo mainInfo, Continuation<? super CertificateScreen$startAnimatedScreen$2$1> continuation) {
        super(2, continuation);
        this.$zoomMax = f;
        this.$zoomBase = f2;
        this.$zoomTick = f3;
        this.this$0 = certificateScreen;
        this.$it = mainInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CertificateScreen$startAnimatedScreen$2$1 certificateScreen$startAnimatedScreen$2$1 = new CertificateScreen$startAnimatedScreen$2$1(this.$zoomMax, this.$zoomBase, this.$zoomTick, this.this$0, this.$it, continuation);
        certificateScreen$startAnimatedScreen$2$1.L$0 = obj;
        return certificateScreen$startAnimatedScreen$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CertificateScreen$startAnimatedScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
        if (r2 > r6.$zoomBase) goto L7;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003e -> B:16:0x0041). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        float f;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            f = this.$zoomMax;
            if (CoroutineScopeKt.isActive(coroutineScope) && f > this.$zoomBase) {
                this.L$0 = coroutineScope;
                this.F$0 = f;
                this.label = 1;
                if (DelayKt.delay(5L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                f -= this.$zoomTick;
                this.this$0.getScene().scaleModel(this.$it.getObjectViewer().getObjectModel().getId(), f);
            }
            return Unit.INSTANCE;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            f = this.F$0;
            ResultKt.throwOnFailure(obj);
            f -= this.$zoomTick;
            this.this$0.getScene().scaleModel(this.$it.getObjectViewer().getObjectModel().getId(), f);
        }
    }
}
