package com.skydoves.cloudy;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.DrawModifierNodeKt;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import com.skydoves.cloudy.CloudyState;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
/* compiled from: CloudyLegacyBlurStrategy.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.skydoves.cloudy.CloudyModifierNode$draw$2", f = "CloudyLegacyBlurStrategy.kt", i = {1, 1}, l = {DownloaderService.STATUS_WAITING_FOR_NETWORK, 222}, m = "invokeSuspend", n = {"capturedBitmap", "softwareBitmap"}, nl = {DownloaderService.STATUS_QUEUED_FOR_WIFI_OR_CELLULAR_PERMISSION, 232}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes4.dex */
final class CloudyModifierNode$draw$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $currentRadius;
    final /* synthetic */ GraphicsContext $graphicsContext;
    final /* synthetic */ GraphicsLayer $graphicsLayer;
    final /* synthetic */ CloudyModifierNode $node;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CloudyModifierNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloudyModifierNode$draw$2(GraphicsLayer graphicsLayer, CloudyModifierNode cloudyModifierNode, CloudyModifierNode cloudyModifierNode2, int i, GraphicsContext graphicsContext, Continuation<? super CloudyModifierNode$draw$2> continuation) {
        super(2, continuation);
        this.$graphicsLayer = graphicsLayer;
        this.this$0 = cloudyModifierNode;
        this.$node = cloudyModifierNode2;
        this.$currentRadius = i;
        this.$graphicsContext = graphicsContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CloudyModifierNode$draw$2(this.$graphicsLayer, this.this$0, this.$node, this.$currentRadius, this.$graphicsContext, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CloudyModifierNode$draw$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x010e, code lost:
        if (r10 == r0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0184, code lost:
        if (r9.$node.isAttached() != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0186, code lost:
        androidx.compose.ui.node.DrawModifierNodeKt.invalidateDraw(r9.$node);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0214, code lost:
        if (r9.$node.isAttached() != false) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        boolean z;
        Function1 function1;
        boolean z2;
        Function1 function12;
        boolean z3;
        Bitmap bitmap;
        Function1 function13;
        boolean z4;
        Function1 function14;
        PlatformBitmap platformBitmap;
        boolean z5;
        Function1 function15;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                try {
                } catch (Exception e) {
                    if (e instanceof CancellationException) {
                        throw e;
                    }
                    function12 = this.this$0.onStateChanged;
                    function12.invoke(new CloudyState.Error(e));
                    Unit unit = Unit.INSTANCE;
                    this.$graphicsContext.releaseGraphicsLayer(this.$graphicsLayer);
                    this.this$0.isProcessing = false;
                    this.this$0.blurJob = null;
                    z3 = this.this$0.pendingInvalidateRequest;
                    if (z3) {
                        this.this$0.pendingInvalidateRequest = false;
                        if (this.$node.isAttached()) {
                            DrawModifierNodeKt.invalidateDraw(this.$node);
                        }
                    }
                    return unit;
                }
            } catch (Exception e2) {
                if (e2 instanceof CancellationException) {
                    throw e2;
                }
                function1 = this.this$0.onStateChanged;
                function1.invoke(new CloudyState.Error(e2));
                this.$graphicsContext.releaseGraphicsLayer(this.$graphicsLayer);
                this.this$0.isProcessing = false;
                this.this$0.blurJob = null;
                z2 = this.this$0.pendingInvalidateRequest;
                if (z2) {
                    this.this$0.pendingInvalidateRequest = false;
                }
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = this.$graphicsLayer.toImageBitmap(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                if (i == 2) {
                    Bitmap bitmap2 = (Bitmap) this.L$1;
                    Bitmap bitmap3 = (Bitmap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    Bitmap bitmap4 = (Bitmap) obj;
                    if (bitmap4 == null || (platformBitmap = PlatformBitmap_androidKt.toPlatformBitmap(bitmap4)) == null) {
                        throw new RuntimeException("Blur processing returned null");
                    }
                    if (this.$node.isAttached()) {
                        if (CloudyModifierNode.isTransparentBitmap$default(this.this$0, platformBitmap.getBitmap(), 0, 2, null)) {
                            this.this$0.isProcessing = false;
                            this.this$0.contentMayHaveChanged = true;
                        } else {
                            this.this$0.cachedBlurRadius = this.$currentRadius;
                            this.this$0.blurredBitmap = platformBitmap;
                            this.this$0.contentMayHaveChanged = false;
                            DrawModifierNodeKt.invalidateDraw(this.$node);
                            function15 = this.this$0.onStateChanged;
                            function15.invoke(new CloudyState.Success.Captured(platformBitmap));
                        }
                    }
                    this.$graphicsContext.releaseGraphicsLayer(this.$graphicsLayer);
                    this.this$0.isProcessing = false;
                    this.this$0.blurJob = null;
                    z5 = this.this$0.pendingInvalidateRequest;
                    if (z5) {
                        this.this$0.pendingInvalidateRequest = false;
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            Bitmap asAndroidBitmap = AndroidImageBitmap_androidKt.asAndroidBitmap((ImageBitmap) obj);
            if (Build.VERSION.SDK_INT < 26 || asAndroidBitmap.getConfig() != Bitmap.Config.HARDWARE) {
                bitmap = asAndroidBitmap;
            } else {
                try {
                    bitmap = asAndroidBitmap.copy(Bitmap.Config.ARGB_8888, true);
                } catch (Exception e3) {
                    function14 = this.this$0.onStateChanged;
                    function14.invoke(new CloudyState.Error(e3));
                    return Unit.INSTANCE;
                }
            }
            if (bitmap == null) {
                function13 = this.this$0.onStateChanged;
                function13.invoke(new CloudyState.Error(new RuntimeException("Failed to create software bitmap")));
                Unit unit2 = Unit.INSTANCE;
                this.$graphicsContext.releaseGraphicsLayer(this.$graphicsLayer);
                this.this$0.isProcessing = false;
                this.this$0.blurJob = null;
                z4 = this.this$0.pendingInvalidateRequest;
                if (z4) {
                    this.this$0.pendingInvalidateRequest = false;
                    if (this.$node.isAttached()) {
                        DrawModifierNodeKt.invalidateDraw(this.$node);
                    }
                }
                return unit2;
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(asAndroidBitmap);
            this.L$1 = SpillingKt.nullOutSpilledVariable(bitmap);
            this.label = 2;
            obj = BuildersKt.withContext(Dispatchers.getDefault(), new CloudyModifierNode$draw$2$blurResult$1(bitmap, this.$currentRadius, null), this);
        } finally {
            this.$graphicsContext.releaseGraphicsLayer(this.$graphicsLayer);
            this.this$0.isProcessing = false;
            this.this$0.blurJob = null;
            z = this.this$0.pendingInvalidateRequest;
            if (z) {
                this.this$0.pendingInvalidateRequest = false;
                if (this.$node.isAttached()) {
                    DrawModifierNodeKt.invalidateDraw(this.$node);
                }
            }
        }
    }
}
