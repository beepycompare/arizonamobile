package com.skydoves.cloudy;

import android.graphics.Bitmap;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.media3.extractor.ts.TsExtractor;
import com.skydoves.cloudy.CloudyState;
import com.skydoves.cloudy.internals.render.RenderScriptToolkitKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: CloudyModifierNode.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.skydoves.cloudy.CloudyModifierNode$draw$2", f = "CloudyModifierNode.kt", i = {0}, l = {AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID, TsExtractor.TS_STREAM_TYPE_HDMV_DTS}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes4.dex */
final class CloudyModifierNode$draw$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GraphicsLayer $graphicsLayer;
    final /* synthetic */ ContentDrawScope $this_draw;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CloudyModifierNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloudyModifierNode$draw$2(GraphicsLayer graphicsLayer, CloudyModifierNode cloudyModifierNode, ContentDrawScope contentDrawScope, Continuation<? super CloudyModifierNode$draw$2> continuation) {
        super(2, continuation);
        this.$graphicsLayer = graphicsLayer;
        this.this$0 = cloudyModifierNode;
        this.$this_draw = contentDrawScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CloudyModifierNode$draw$2 cloudyModifierNode$draw$2 = new CloudyModifierNode$draw$2(this.$graphicsLayer, this.this$0, this.$this_draw, continuation);
        cloudyModifierNode$draw$2.L$0 = obj;
        return cloudyModifierNode$draw$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CloudyModifierNode$draw$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005c, code lost:
        r3 = r11.this$0.getCachedOutput();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006e, code lost:
        r3 = r11.this$0.getCachedOutput();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a9, code lost:
        if (r12 == r0) goto L32;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Function1 function1;
        CoroutineScope coroutineScope;
        Bitmap cachedOutput;
        Bitmap createCompatibleBitmap;
        Bitmap cachedOutput2;
        Bitmap cachedOutput3;
        Function1 function12;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
            } catch (Exception e) {
                function1 = this.this$0.onStateChanged;
                function1.invoke(new CloudyState.Error(e));
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                this.L$0 = coroutineScope;
                this.label = 1;
                obj = this.$graphicsLayer.toImageBitmap(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    Bitmap bitmap = (Bitmap) obj;
                    if (bitmap != null) {
                        DrawScope.m4624drawImagegbVJVH8$default(this.$this_draw, AndroidImageBitmap_androidKt.asImageBitmap(bitmap), 0L, 0.0f, null, null, 0, 62, null);
                        function12 = this.this$0.onStateChanged;
                        function12.invoke(new CloudyState.Success(bitmap));
                        DelegatableNodeKt.requireGraphicsContext(this.this$0).releaseGraphicsLayer(this.$graphicsLayer);
                        return Unit.INSTANCE;
                    }
                    throw new RuntimeException("Couldn't capture a bitmap from the composable tree");
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            Bitmap copy = AndroidImageBitmap_androidKt.asAndroidBitmap((ImageBitmap) obj).copy(Bitmap.Config.ARGB_8888, true);
            Intrinsics.checkNotNullExpressionValue(copy, "copy(...)");
            cachedOutput = this.this$0.getCachedOutput();
            if (cachedOutput == null || cachedOutput2 == null || cachedOutput2.getWidth() != copy.getWidth() || cachedOutput3 == null || cachedOutput3.getHeight() != copy.getHeight()) {
                createCompatibleBitmap = CloudyModifierNodeKt.createCompatibleBitmap(copy);
                this.this$0.setCachedOutput(createCompatibleBitmap);
            } else {
                createCompatibleBitmap = this.this$0.getCachedOutput();
                Intrinsics.checkNotNull(createCompatibleBitmap);
            }
            this.L$0 = null;
            this.label = 2;
            obj = RenderScriptToolkitKt.iterativeBlur(coroutineScope, copy, createCompatibleBitmap, this.this$0.getRadius()).await(this);
        } catch (Throwable th) {
            DelegatableNodeKt.requireGraphicsContext(this.this$0).releaseGraphicsLayer(this.$graphicsLayer);
            throw th;
        }
    }
}
