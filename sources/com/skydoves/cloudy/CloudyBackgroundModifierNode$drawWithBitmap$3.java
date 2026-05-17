package com.skydoves.cloudy;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.DrawModifierNodeKt;
import com.skydoves.cloudy.CloudyState;
import com.skydoves.cloudy.internals.SkySnapshot;
import com.skydoves.cloudy.internals.render.RenderScriptToolkit;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CloudyBackground.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.skydoves.cloudy.CloudyBackgroundModifierNode$drawWithBitmap$3", f = "CloudyBackground.android.kt", i = {1, 1, 1, 1}, l = {524, 579}, m = "invokeSuspend", n = {"capturedBitmap", "softwareBitmap", "outputBitmap", "progressiveDir"}, nl = {525, 593}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
/* loaded from: classes3.dex */
public final class CloudyBackgroundModifierNode$drawWithBitmap$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SkySnapshot $capturedSnapshot;
    final /* synthetic */ GraphicsLayer $layer;
    final /* synthetic */ CloudyBackgroundModifierNode $node;
    final /* synthetic */ int $outputHeight;
    final /* synthetic */ int $outputWidth;
    final /* synthetic */ long $processingVersion;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ CloudyBackgroundModifierNode this$0;

    /* compiled from: CloudyBackground.android.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SkySnapshot.ProgressiveDirection.values().length];
            try {
                iArr[SkySnapshot.ProgressiveDirection.TOP_TO_BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SkySnapshot.ProgressiveDirection.BOTTOM_TO_TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SkySnapshot.ProgressiveDirection.EDGES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SkySnapshot.ProgressiveDirection.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloudyBackgroundModifierNode$drawWithBitmap$3(GraphicsLayer graphicsLayer, CloudyBackgroundModifierNode cloudyBackgroundModifierNode, int i, int i2, SkySnapshot skySnapshot, CloudyBackgroundModifierNode cloudyBackgroundModifierNode2, long j, Continuation<? super CloudyBackgroundModifierNode$drawWithBitmap$3> continuation) {
        super(2, continuation);
        this.$layer = graphicsLayer;
        this.this$0 = cloudyBackgroundModifierNode;
        this.$outputWidth = i;
        this.$outputHeight = i2;
        this.$capturedSnapshot = skySnapshot;
        this.$node = cloudyBackgroundModifierNode2;
        this.$processingVersion = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CloudyBackgroundModifierNode$drawWithBitmap$3(this.$layer, this.this$0, this.$outputWidth, this.$outputHeight, this.$capturedSnapshot, this.$node, this.$processingVersion, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CloudyBackgroundModifierNode$drawWithBitmap$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x014c, code lost:
        if (r2 == r4) goto L49;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Function1 function1;
        Function1 function12;
        Unit unit;
        Object imageBitmap;
        Bitmap bitmap;
        Bitmap createBitmap;
        RenderScriptToolkit.ProgressiveDirection progressiveDirection;
        Object withContext;
        Function1 function13;
        Function1 function14;
        Function1 function15;
        PlatformBitmap platformBitmap;
        long j;
        long j2;
        long j3;
        Function1 function16;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                try {
                } finally {
                    this.this$0.isProcessing = false;
                    this.this$0.blurJob = null;
                }
            } catch (Exception e) {
                if (e instanceof CancellationException) {
                    throw e;
                }
                Log.e("CloudyBackground", "Failed to capture layer as bitmap", e);
                function12 = this.this$0.onStateChanged;
                function12.invoke(new CloudyState.Error(e));
                unit = Unit.INSTANCE;
            }
        } catch (Exception e2) {
            if (e2 instanceof CancellationException) {
                throw e2;
            }
            Log.e("CloudyBackground", "Background blur failed", e2);
            function1 = this.this$0.onStateChanged;
            function1.invoke(new CloudyState.Error(e2));
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            imageBitmap = this.$layer.toImageBitmap(this);
            if (imageBitmap == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            if (i == 2) {
                RenderScriptToolkit.ProgressiveDirection progressiveDirection2 = (RenderScriptToolkit.ProgressiveDirection) this.L$3;
                Bitmap bitmap2 = (Bitmap) this.L$2;
                Bitmap bitmap3 = (Bitmap) this.L$1;
                Bitmap bitmap4 = (Bitmap) this.L$0;
                ResultKt.throwOnFailure(obj);
                createBitmap = bitmap2;
                withContext = obj;
                if (!((Boolean) withContext).booleanValue()) {
                    Log.e("CloudyBackground", "Native background blur failed");
                    function16 = this.this$0.onStateChanged;
                    function16.invoke(new CloudyState.Error(new RuntimeException("Native blur processing failed")));
                    unit = Unit.INSTANCE;
                    return unit;
                }
                Log.d("CloudyBackground", "Blur complete: " + createBitmap.getWidth() + 'x' + createBitmap.getHeight());
                if (this.$node.isAttached()) {
                    this.this$0.blurredBitmap = new PlatformBitmap(createBitmap);
                    this.this$0.cachedContentVersion = this.$processingVersion;
                    function15 = this.this$0.onStateChanged;
                    platformBitmap = this.this$0.blurredBitmap;
                    Intrinsics.checkNotNull(platformBitmap);
                    function15.invoke(new CloudyState.Success.Captured(platformBitmap));
                    j = this.this$0.queuedVersion;
                    this.this$0.queuedVersion = -1L;
                    if (j != -1) {
                        j2 = this.this$0.cachedContentVersion;
                        if (j != j2) {
                            StringBuilder append = new StringBuilder("Processing queued version: ").append(j).append(" (cached: ");
                            j3 = this.this$0.cachedContentVersion;
                            Log.d("CloudyBackground", append.append(j3).append(')').toString());
                        }
                    }
                    DrawModifierNodeKt.invalidateDraw(this.$node);
                }
                this.this$0.isProcessing = false;
                this.this$0.blurJob = null;
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            imageBitmap = obj;
        }
        Bitmap asAndroidBitmap = AndroidImageBitmap_androidKt.asAndroidBitmap((ImageBitmap) imageBitmap);
        if (Build.VERSION.SDK_INT < 26 || asAndroidBitmap.getConfig() != Bitmap.Config.HARDWARE) {
            bitmap = asAndroidBitmap;
        } else {
            try {
                bitmap = asAndroidBitmap.copy(Bitmap.Config.ARGB_8888, true);
            } catch (Exception e3) {
                if (e3 instanceof CancellationException) {
                    throw e3;
                }
                Log.e("CloudyBackground", "Failed to convert HARDWARE bitmap", e3);
                function14 = this.this$0.onStateChanged;
                function14.invoke(new CloudyState.Error(e3));
                unit = Unit.INSTANCE;
            }
        }
        if (bitmap == null) {
            function13 = this.this$0.onStateChanged;
            function13.invoke(new CloudyState.Error(new RuntimeException("Failed to create software bitmap")));
            unit = Unit.INSTANCE;
            return unit;
        }
        Log.d("CloudyBackground", "Captured bitmap: " + bitmap.getWidth() + 'x' + bitmap.getHeight());
        createBitmap = Bitmap.createBitmap(this.$outputWidth, this.$outputHeight, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        createBitmap.setPremultiplied(true);
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.$capturedSnapshot.getDirection().ordinal()];
        if (i2 == 1) {
            progressiveDirection = RenderScriptToolkit.ProgressiveDirection.TOP_TO_BOTTOM;
        } else if (i2 == 2) {
            progressiveDirection = RenderScriptToolkit.ProgressiveDirection.BOTTOM_TO_TOP;
        } else if (i2 == 3) {
            progressiveDirection = RenderScriptToolkit.ProgressiveDirection.EDGES;
        } else if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            progressiveDirection = RenderScriptToolkit.ProgressiveDirection.NONE;
        }
        RenderScriptToolkit.ProgressiveDirection progressiveDirection3 = progressiveDirection;
        this.L$0 = SpillingKt.nullOutSpilledVariable(asAndroidBitmap);
        this.L$1 = SpillingKt.nullOutSpilledVariable(bitmap);
        this.L$2 = createBitmap;
        this.L$3 = SpillingKt.nullOutSpilledVariable(progressiveDirection3);
        this.label = 2;
        withContext = BuildersKt.withContext(Dispatchers.getDefault(), new CloudyBackgroundModifierNode$drawWithBitmap$3$success$1(bitmap, createBitmap, this.$capturedSnapshot, progressiveDirection3, null), this);
    }
}
