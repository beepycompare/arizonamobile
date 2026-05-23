package com.skydoves.cloudy;

import android.graphics.Bitmap;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import com.skydoves.cloudy.CloudyState;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
/* compiled from: CloudyLegacyBlurStrategy.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\bJ\f\u0010\u001a\u001a\u00020\b*\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u0004H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/skydoves/cloudy/CloudyModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "radius", "", "onStateChanged", "Lkotlin/Function1;", "Lcom/skydoves/cloudy/CloudyState;", "", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "value", "getRadius", "()I", "blurredBitmap", "Lcom/skydoves/cloudy/PlatformBitmap;", "cachedBlurRadius", "isProcessing", "", "pendingInvalidateRequest", "blurJob", "Lkotlinx/coroutines/Job;", "contentMayHaveChanged", "updateRadius", "newRadius", "onUpdate", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "isTransparentBitmap", "bitmap", "Landroid/graphics/Bitmap;", "grid", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
final class CloudyModifierNode extends Modifier.Node implements DrawModifierNode {
    private Job blurJob;
    private PlatformBitmap blurredBitmap;
    private int cachedBlurRadius;
    private boolean contentMayHaveChanged;
    private boolean isProcessing;
    private final Function1<CloudyState, Unit> onStateChanged;
    private boolean pendingInvalidateRequest;
    private int radius;

    public CloudyModifierNode() {
        this(0, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CloudyModifierNode(int i, Function1<? super CloudyState, Unit> onStateChanged) {
        Intrinsics.checkNotNullParameter(onStateChanged, "onStateChanged");
        this.onStateChanged = onStateChanged;
        this.radius = i;
        this.cachedBlurRadius = -1;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public /* bridge */ void onMeasureResultChanged() {
        super.onMeasureResultChanged();
    }

    public /* synthetic */ CloudyModifierNode(int i, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 10 : i, (i2 & 2) != 0 ? new Function1() { // from class: com.skydoves.cloudy.CloudyModifierNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CloudyModifierNode._init_$lambda$0((CloudyState) obj);
            }
        } : function1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$0(CloudyState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final int getRadius() {
        return this.radius;
    }

    public final void updateRadius(int i) {
        if (this.radius == i) {
            return;
        }
        this.radius = i;
        Job job = this.blurJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.blurJob = null;
        this.isProcessing = false;
        this.pendingInvalidateRequest = false;
        if (this.cachedBlurRadius != this.radius) {
            this.contentMayHaveChanged = true;
        }
        if (isAttached()) {
            DrawModifierNodeKt.invalidateDraw(this);
        }
    }

    public final void onUpdate() {
        this.contentMayHaveChanged = true;
        if (this.isProcessing) {
            this.pendingInvalidateRequest = true;
        } else if (isAttached()) {
            DrawModifierNodeKt.invalidateDraw(this);
        }
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(final ContentDrawScope contentDrawScope) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        GraphicsContext requireGraphicsContext = DelegatableNodeKt.requireGraphicsContext(this);
        GraphicsLayer createGraphicsLayer = requireGraphicsContext.createGraphicsLayer();
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        DrawScope.m5920recordJVtK1S4$default(contentDrawScope2, createGraphicsLayer, 0L, new Function1() { // from class: com.skydoves.cloudy.CloudyModifierNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CloudyModifierNode.draw$lambda$0(ContentDrawScope.this, (DrawScope) obj);
            }
        }, 1, null);
        if (this.radius <= 0) {
            GraphicsLayerKt.drawLayer(contentDrawScope2, createGraphicsLayer);
            requireGraphicsContext.releaseGraphicsLayer(createGraphicsLayer);
            return;
        }
        PlatformBitmap platformBitmap = this.blurredBitmap;
        if (platformBitmap != null && !platformBitmap.getBitmap().isRecycled()) {
            DrawScope.m5906drawImagegbVJVH8$default(contentDrawScope2, AndroidImageBitmap_androidKt.asImageBitmap(platformBitmap.getBitmap()), 0L, 0.0f, null, null, 0, 62, null);
        } else {
            GraphicsLayerKt.drawLayer(contentDrawScope2, createGraphicsLayer);
        }
        if (platformBitmap != null && !platformBitmap.getBitmap().isRecycled() && this.cachedBlurRadius == this.radius && !this.contentMayHaveChanged) {
            requireGraphicsContext.releaseGraphicsLayer(createGraphicsLayer);
            this.onStateChanged.invoke(new CloudyState.Success.Captured(platformBitmap));
        } else if (!this.isProcessing) {
            this.isProcessing = true;
            this.pendingInvalidateRequest = false;
            this.onStateChanged.invoke(CloudyState.Loading.INSTANCE);
            launch$default = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), Dispatchers.getMain(), null, new CloudyModifierNode$draw$2(createGraphicsLayer, this, this, this.radius, requireGraphicsContext, null), 2, null);
            this.blurJob = launch$default;
        } else {
            this.pendingInvalidateRequest = true;
            requireGraphicsContext.releaseGraphicsLayer(createGraphicsLayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit draw$lambda$0(ContentDrawScope contentDrawScope, DrawScope record) {
        Intrinsics.checkNotNullParameter(record, "$this$record");
        contentDrawScope.drawContent();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean isTransparentBitmap$default(CloudyModifierNode cloudyModifierNode, Bitmap bitmap, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 4;
        }
        return cloudyModifierNode.isTransparentBitmap(bitmap, i);
    }

    private final boolean isTransparentBitmap(Bitmap bitmap, int i) {
        if (bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {
            return true;
        }
        if (i <= 1) {
            return false;
        }
        int width = bitmap.getWidth() - 1;
        int height = bitmap.getHeight() - 1;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f = i - 1;
            int coerceIn = RangesKt.coerceIn((int) ((i3 / f) * height), 0, height);
            for (int i4 = 0; i4 < i; i4++) {
                if (((bitmap.getPixel(RangesKt.coerceIn((int) ((i4 / f) * width), 0, width), coerceIn) >> 24) & 255) > 0) {
                    i2++;
                }
            }
        }
        return i2 == 0;
    }
}
