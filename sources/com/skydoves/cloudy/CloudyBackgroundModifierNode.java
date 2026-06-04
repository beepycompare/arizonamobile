package com.skydoves.cloudy;

import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.AndroidRenderEffect_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.unit.IntSize;
import com.skydoves.cloudy.CloudyState;
import com.skydoves.cloudy.internals.SkySnapshot;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
/* compiled from: CloudyBackground.android.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 ;2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001;BC\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0004\b\u0014\u0010\u0015JI\u0010%\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*H\u0016J\u0017\u0010+\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¢\u0006\u0004\b,\u0010-J\f\u0010.\u001a\u00020\u0013*\u00020/H\u0016J\u0014\u00100\u001a\u00020\u0013*\u00020/2\u0006\u00101\u001a\u000202H\u0002J\u001c\u00103\u001a\u00020\u0013*\u00020/2\u0006\u00101\u001a\u0002022\u0006\u00104\u001a\u000205H\u0002J\u001c\u00106\u001a\u00020\u0013*\u00020/2\u0006\u00101\u001a\u0002022\u0006\u00104\u001a\u000205H\u0003J\b\u00108\u001a\u00020\u0013H\u0002J\u001c\u00109\u001a\u00020\u0013*\u00020/2\u0006\u00101\u001a\u0002022\u0006\u00104\u001a\u000205H\u0002J\b\u0010:\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/skydoves/cloudy/CloudyBackgroundModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "sky", "Lcom/skydoves/cloudy/Sky;", "radius", "", "progressive", "Lcom/skydoves/cloudy/CloudyProgressive;", "tint", "Landroidx/compose/ui/graphics/Color;", "cpuBlurEnabled", "", "onStateChanged", "Lkotlin/Function1;", "Lcom/skydoves/cloudy/CloudyState;", "", "<init>", "(Lcom/skydoves/cloudy/Sky;ILcom/skydoves/cloudy/CloudyProgressive;JZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "positionInRoot", "Landroidx/compose/ui/geometry/Offset;", "size", "Landroidx/compose/ui/unit/IntSize;", "blurredBitmap", "Lcom/skydoves/cloudy/PlatformBitmap;", "cachedContentVersion", "", "isProcessing", "blurJob", "Lkotlinx/coroutines/Job;", "pendingContentVersion", "lastBlurStartTime", "queuedVersion", "update", "update-Bx497Mc", "(Lcom/skydoves/cloudy/Sky;ILcom/skydoves/cloudy/CloudyProgressive;JZLkotlin/jvm/functions/Function1;)V", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "onRemeasured", "onRemeasured-ozmzZPI", "(J)V", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawBackgroundRegion", AdRevenueConstants.LAYER_KEY, "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "drawScrimFallback", "snapshot", "Lcom/skydoves/cloudy/internals/SkySnapshot;", "drawWithRenderEffect", "hasLoggedProgressiveWarning", "logProgressiveBlurWarningOnce", "drawWithBitmap", "onDetach", "Companion", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
final class CloudyBackgroundModifierNode extends Modifier.Node implements DrawModifierNode, GlobalPositionAwareModifierNode, LayoutAwareModifierNode, CompositionLocalConsumerModifierNode {
    public static final Companion Companion = new Companion(null);
    private static final long MIN_BLUR_INTERVAL_MS = 50;
    private Job blurJob;
    private PlatformBitmap blurredBitmap;
    private long cachedContentVersion;
    private boolean cpuBlurEnabled;
    private boolean hasLoggedProgressiveWarning;
    private boolean isProcessing;
    private long lastBlurStartTime;
    private Function1<? super CloudyState, Unit> onStateChanged;
    private long pendingContentVersion;
    private long positionInRoot;
    private CloudyProgressive progressive;
    private long queuedVersion;
    private int radius;
    private long size;
    private Sky sky;
    private long tint;

    public /* synthetic */ CloudyBackgroundModifierNode(Sky sky, int i, CloudyProgressive cloudyProgressive, long j, boolean z, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(sky, i, cloudyProgressive, j, z, function1);
    }

    private CloudyBackgroundModifierNode(Sky sky, int i, CloudyProgressive progressive, long j, boolean z, Function1<? super CloudyState, Unit> onStateChanged) {
        Intrinsics.checkNotNullParameter(sky, "sky");
        Intrinsics.checkNotNullParameter(progressive, "progressive");
        Intrinsics.checkNotNullParameter(onStateChanged, "onStateChanged");
        this.sky = sky;
        this.radius = i;
        this.progressive = progressive;
        this.tint = j;
        this.cpuBlurEnabled = z;
        this.onStateChanged = onStateChanged;
        this.positionInRoot = Offset.Companion.m5119getZeroF1C5BW0();
        this.size = IntSize.Companion.m8336getZeroYbymL2g();
        this.cachedContentVersion = -1L;
        this.pendingContentVersion = -1L;
        this.queuedVersion = -1L;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public /* bridge */ void onMeasureResultChanged() {
        super.onMeasureResultChanged();
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public /* bridge */ void onPlaced(LayoutCoordinates layoutCoordinates) {
        super.onPlaced(layoutCoordinates);
    }

    /* compiled from: CloudyBackground.android.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/skydoves/cloudy/CloudyBackgroundModifierNode$Companion;", "", "<init>", "()V", "MIN_BLUR_INTERVAL_MS", "", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: update-Bx497Mc  reason: not valid java name */
    public final void m9850updateBx497Mc(Sky sky, int i, CloudyProgressive progressive, long j, boolean z, Function1<? super CloudyState, Unit> onStateChanged) {
        Intrinsics.checkNotNullParameter(sky, "sky");
        Intrinsics.checkNotNullParameter(progressive, "progressive");
        Intrinsics.checkNotNullParameter(onStateChanged, "onStateChanged");
        boolean z2 = (Intrinsics.areEqual(this.sky, sky) && this.radius == i && Intrinsics.areEqual(this.progressive, progressive) && Color.m5349equalsimpl0(this.tint, j) && this.cpuBlurEnabled == z) ? false : true;
        this.sky = sky;
        this.radius = i;
        this.progressive = progressive;
        this.tint = j;
        this.cpuBlurEnabled = z;
        this.onStateChanged = onStateChanged;
        if (z2) {
            this.queuedVersion = -1L;
            this.lastBlurStartTime = 0L;
            this.cachedContentVersion = -1L;
            this.pendingContentVersion = -1L;
            if (isAttached()) {
                DrawModifierNodeKt.invalidateDraw(this);
            }
        }
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        this.positionInRoot = LayoutCoordinatesKt.positionInRoot(coordinates);
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode, androidx.compose.ui.node.MeasuredSizeAwareModifierNode
    /* renamed from: onRemeasured-ozmzZPI */
    public void mo423onRemeasuredozmzZPI(long j) {
        this.size = j;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        GraphicsLayer backgroundLayer$cloudy_release = this.sky.getBackgroundLayer$cloudy_release();
        if (backgroundLayer$cloudy_release == null) {
            this.onStateChanged.invoke(new CloudyState.Error(new RuntimeException("Background layer not available")));
            contentDrawScope.drawContent();
        } else if (this.radius <= 0) {
            drawBackgroundRegion(contentDrawScope, backgroundLayer$cloudy_release);
            contentDrawScope.drawContent();
        } else {
            Rect sourceBounds$cloudy_release = this.sky.getSourceBounds$cloudy_release();
            SkySnapshot m9858fromProgressivePE3pjmc = SkySnapshot.Companion.m9858fromProgressivePE3pjmc(this.radius, Float.intBitsToFloat((int) (this.positionInRoot >> 32)) - sourceBounds$cloudy_release.getLeft(), Float.intBitsToFloat((int) (this.positionInRoot & 4294967295L)) - sourceBounds$cloudy_release.getTop(), Float.intBitsToFloat((int) (contentDrawScope.mo5922getSizeNHjbRc() >> 32)), Float.intBitsToFloat((int) (4294967295L & contentDrawScope.mo5922getSizeNHjbRc())), this.progressive, this.tint);
            if (Build.VERSION.SDK_INT >= 31) {
                drawWithRenderEffect(contentDrawScope, backgroundLayer$cloudy_release, m9858fromProgressivePE3pjmc);
            } else if (this.cpuBlurEnabled) {
                drawWithBitmap(contentDrawScope, backgroundLayer$cloudy_release, m9858fromProgressivePE3pjmc);
            } else {
                drawScrimFallback(contentDrawScope, backgroundLayer$cloudy_release, m9858fromProgressivePE3pjmc);
            }
            contentDrawScope.drawContent();
        }
    }

    private final void drawBackgroundRegion(ContentDrawScope contentDrawScope, GraphicsLayer graphicsLayer) {
        Rect sourceBounds$cloudy_release = this.sky.getSourceBounds$cloudy_release();
        float intBitsToFloat = Float.intBitsToFloat((int) (this.positionInRoot >> 32)) - sourceBounds$cloudy_release.getLeft();
        float intBitsToFloat2 = Float.intBitsToFloat((int) (this.positionInRoot & 4294967295L)) - sourceBounds$cloudy_release.getTop();
        contentDrawScope.getDrawContext().getCanvas().save();
        contentDrawScope.getDrawContext().getCanvas().translate(-intBitsToFloat, -intBitsToFloat2);
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        GraphicsLayerKt.drawLayer(contentDrawScope2, graphicsLayer);
        contentDrawScope.getDrawContext().getCanvas().restore();
        if (!Color.m5349equalsimpl0(this.tint, Color.Companion.m5383getTransparent0d7_KjU())) {
            DrawScope.m5916drawRectnJ9OG0$default(contentDrawScope2, this.tint, 0L, 0L, 0.0f, null, null, BlendMode.Companion.m5288getSrcOver0nO6VwU(), 62, null);
        }
        this.onStateChanged.invoke(CloudyState.Success.Applied.INSTANCE);
    }

    private final void drawScrimFallback(ContentDrawScope contentDrawScope, GraphicsLayer graphicsLayer, SkySnapshot skySnapshot) {
        long m9857getTintColor0d7_KjU;
        long j;
        contentDrawScope.getDrawContext().getCanvas().save();
        contentDrawScope.getDrawContext().getCanvas().translate(-skySnapshot.getOffsetX(), -skySnapshot.getOffsetY());
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        GraphicsLayerKt.drawLayer(contentDrawScope2, graphicsLayer);
        contentDrawScope.getDrawContext().getCanvas().restore();
        if (Color.m5349equalsimpl0(skySnapshot.m9857getTintColor0d7_KjU(), Color.Companion.m5383getTransparent0d7_KjU())) {
            m9857getTintColor0d7_KjU = CloudyDefaults.INSTANCE.m9853getDefaultScrimColor0d7_KjU();
        } else {
            m9857getTintColor0d7_KjU = skySnapshot.m9857getTintColor0d7_KjU();
        }
        long j2 = m9857getTintColor0d7_KjU;
        float intBitsToFloat = Float.intBitsToFloat((int) (contentDrawScope2.mo5922getSizeNHjbRc() >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (contentDrawScope2.mo5922getSizeNHjbRc() & 4294967295L));
        int m5337getIntersectrtfAjoo = ClipOp.Companion.m5337getIntersectrtfAjoo();
        DrawContext drawContext = contentDrawScope2.getDrawContext();
        long mo5843getSizeNHjbRc = drawContext.mo5843getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo5846clipRectN_I0leg(0.0f, 0.0f, intBitsToFloat, intBitsToFloat2, m5337getIntersectrtfAjoo);
            try {
                DrawScope.m5916drawRectnJ9OG0$default(contentDrawScope2, j2, 0L, 0L, 0.0f, null, null, BlendMode.Companion.m5288getSrcOver0nO6VwU(), 62, null);
                drawContext.getCanvas().restore();
                drawContext.mo5844setSizeuvyYCjk(mo5843getSizeNHjbRc);
                this.onStateChanged.invoke(CloudyState.Success.Scrim.INSTANCE);
            } catch (Throwable th) {
                th = th;
                j = mo5843getSizeNHjbRc;
                drawContext.getCanvas().restore();
                drawContext.mo5844setSizeuvyYCjk(j);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            j = mo5843getSizeNHjbRc;
        }
    }

    private final void drawWithRenderEffect(ContentDrawScope contentDrawScope, final GraphicsLayer graphicsLayer, final SkySnapshot skySnapshot) {
        GraphicsContext graphicsContext;
        long j;
        GraphicsContext graphicsContext2;
        if (skySnapshot.getDirection() != SkySnapshot.ProgressiveDirection.NONE && Build.VERSION.SDK_INT < 33) {
            logProgressiveBlurWarningOnce();
        }
        float radius = skySnapshot.getRadius() / 2.0f;
        RenderEffect createBlurEffect = RenderEffect.createBlurEffect(radius, radius, Shader.TileMode.CLAMP);
        Intrinsics.checkNotNullExpressionValue(createBlurEffect, "createBlurEffect(...)");
        androidx.compose.ui.graphics.RenderEffect asComposeRenderEffect = AndroidRenderEffect_androidKt.asComposeRenderEffect(createBlurEffect);
        GraphicsContext requireGraphicsContext = DelegatableNodeKt.requireGraphicsContext(this);
        GraphicsLayer createGraphicsLayer = requireGraphicsContext.createGraphicsLayer();
        try {
            DrawScope.m5920recordJVtK1S4$default(contentDrawScope, createGraphicsLayer, 0L, new Function1() { // from class: com.skydoves.cloudy.CloudyBackgroundModifierNode$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CloudyBackgroundModifierNode.drawWithRenderEffect$lambda$0(SkySnapshot.this, graphicsLayer, (DrawScope) obj);
                }
            }, 1, null);
            createGraphicsLayer.setRenderEffect(asComposeRenderEffect);
            ContentDrawScope contentDrawScope2 = contentDrawScope;
            float intBitsToFloat = Float.intBitsToFloat((int) (contentDrawScope2.mo5922getSizeNHjbRc() >> 32));
            float intBitsToFloat2 = Float.intBitsToFloat((int) (contentDrawScope2.mo5922getSizeNHjbRc() & 4294967295L));
            int m5337getIntersectrtfAjoo = ClipOp.Companion.m5337getIntersectrtfAjoo();
            DrawContext drawContext = contentDrawScope2.getDrawContext();
            long mo5843getSizeNHjbRc = drawContext.mo5843getSizeNHjbRc();
            drawContext.getCanvas().save();
            try {
                drawContext.getTransform().mo5846clipRectN_I0leg(0.0f, 0.0f, intBitsToFloat, intBitsToFloat2, m5337getIntersectrtfAjoo);
                GraphicsLayerKt.drawLayer(contentDrawScope2, createGraphicsLayer);
                if (Color.m5349equalsimpl0(skySnapshot.m9857getTintColor0d7_KjU(), Color.Companion.m5383getTransparent0d7_KjU())) {
                    graphicsContext2 = requireGraphicsContext;
                    j = mo5843getSizeNHjbRc;
                } else {
                    try {
                        graphicsContext2 = requireGraphicsContext;
                        j = mo5843getSizeNHjbRc;
                    } catch (Throwable th) {
                        th = th;
                        graphicsContext2 = requireGraphicsContext;
                        j = mo5843getSizeNHjbRc;
                    }
                    try {
                        DrawScope.m5916drawRectnJ9OG0$default(contentDrawScope2, skySnapshot.m9857getTintColor0d7_KjU(), 0L, 0L, 0.0f, null, null, BlendMode.Companion.m5288getSrcOver0nO6VwU(), 62, null);
                    } catch (Throwable th2) {
                        th = th2;
                        graphicsContext = graphicsContext2;
                        try {
                            drawContext.getCanvas().restore();
                            drawContext.mo5844setSizeuvyYCjk(j);
                            throw th;
                        } catch (Throwable th3) {
                            th = th3;
                            graphicsContext.releaseGraphicsLayer(createGraphicsLayer);
                            throw th;
                        }
                    }
                }
                try {
                    drawContext.getCanvas().restore();
                    drawContext.mo5844setSizeuvyYCjk(j);
                    this.onStateChanged.invoke(CloudyState.Success.Applied.INSTANCE);
                    graphicsContext2.releaseGraphicsLayer(createGraphicsLayer);
                } catch (Throwable th4) {
                    th = th4;
                    graphicsContext = graphicsContext2;
                    graphicsContext.releaseGraphicsLayer(createGraphicsLayer);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                graphicsContext = requireGraphicsContext;
                j = mo5843getSizeNHjbRc;
            }
        } catch (Throwable th6) {
            th = th6;
            graphicsContext = requireGraphicsContext;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit drawWithRenderEffect$lambda$0(SkySnapshot skySnapshot, GraphicsLayer graphicsLayer, DrawScope record) {
        Intrinsics.checkNotNullParameter(record, "$this$record");
        record.getDrawContext().getCanvas().save();
        record.getDrawContext().getCanvas().translate(-skySnapshot.getOffsetX(), -skySnapshot.getOffsetY());
        GraphicsLayerKt.drawLayer(record, graphicsLayer);
        record.getDrawContext().getCanvas().restore();
        return Unit.INSTANCE;
    }

    private final void logProgressiveBlurWarningOnce() {
        if (this.hasLoggedProgressiveWarning) {
            return;
        }
        this.hasLoggedProgressiveWarning = true;
        Log.w("CloudyBackground", "Progressive blur requires API 33+ for background blur. Falling back to uniform blur on API " + Build.VERSION.SDK_INT + '.');
    }

    private final void drawWithBitmap(ContentDrawScope contentDrawScope, GraphicsLayer graphicsLayer, SkySnapshot skySnapshot) {
        Job launch$default;
        long j;
        long contentVersion$cloudy_release = this.sky.getContentVersion$cloudy_release();
        PlatformBitmap platformBitmap = this.blurredBitmap;
        if (platformBitmap != null && !platformBitmap.getBitmap().isRecycled() && this.cachedContentVersion == contentVersion$cloudy_release) {
            ContentDrawScope contentDrawScope2 = contentDrawScope;
            float intBitsToFloat = Float.intBitsToFloat((int) (contentDrawScope2.mo5922getSizeNHjbRc() >> 32));
            float intBitsToFloat2 = Float.intBitsToFloat((int) (contentDrawScope2.mo5922getSizeNHjbRc() & 4294967295L));
            int m5337getIntersectrtfAjoo = ClipOp.Companion.m5337getIntersectrtfAjoo();
            DrawContext drawContext = contentDrawScope2.getDrawContext();
            long mo5843getSizeNHjbRc = drawContext.mo5843getSizeNHjbRc();
            drawContext.getCanvas().save();
            try {
                drawContext.getTransform().mo5846clipRectN_I0leg(0.0f, 0.0f, intBitsToFloat, intBitsToFloat2, m5337getIntersectrtfAjoo);
                DrawScope.m5905drawImageAZ2fEMs$default(contentDrawScope2, AndroidImageBitmap_androidKt.asImageBitmap(platformBitmap.getBitmap()), 0L, 0L, 0L, IntSize.m8326constructorimpl((4294967295L & ((int) Float.intBitsToFloat((int) (contentDrawScope2.mo5922getSizeNHjbRc() & 4294967295L)))) | (((int) Float.intBitsToFloat((int) (contentDrawScope2.mo5922getSizeNHjbRc() >> 32))) << 32)), 0.0f, null, null, 0, 0, 1006, null);
                if (!Color.m5349equalsimpl0(skySnapshot.m9857getTintColor0d7_KjU(), Color.Companion.m5383getTransparent0d7_KjU())) {
                    DrawScope.m5916drawRectnJ9OG0$default(contentDrawScope2, skySnapshot.m9857getTintColor0d7_KjU(), 0L, 0L, 0.0f, null, null, BlendMode.Companion.m5288getSrcOver0nO6VwU(), 62, null);
                }
                drawContext.getCanvas().restore();
                drawContext.mo5844setSizeuvyYCjk(mo5843getSizeNHjbRc);
                this.onStateChanged.invoke(new CloudyState.Success.Captured(platformBitmap));
                return;
            } catch (Throwable th) {
                drawContext.getCanvas().restore();
                drawContext.mo5844setSizeuvyYCjk(mo5843getSizeNHjbRc);
                throw th;
            }
        }
        if (platformBitmap != null && !platformBitmap.getBitmap().isRecycled()) {
            ContentDrawScope contentDrawScope3 = contentDrawScope;
            float intBitsToFloat3 = Float.intBitsToFloat((int) (contentDrawScope3.mo5922getSizeNHjbRc() >> 32));
            float intBitsToFloat4 = Float.intBitsToFloat((int) (contentDrawScope3.mo5922getSizeNHjbRc() & 4294967295L));
            int m5337getIntersectrtfAjoo2 = ClipOp.Companion.m5337getIntersectrtfAjoo();
            DrawContext drawContext2 = contentDrawScope3.getDrawContext();
            long mo5843getSizeNHjbRc2 = drawContext2.mo5843getSizeNHjbRc();
            drawContext2.getCanvas().save();
            try {
                j = mo5843getSizeNHjbRc2;
                try {
                    drawContext2.getTransform().mo5846clipRectN_I0leg(0.0f, 0.0f, intBitsToFloat3, intBitsToFloat4, m5337getIntersectrtfAjoo2);
                    DrawScope.m5905drawImageAZ2fEMs$default(contentDrawScope3, AndroidImageBitmap_androidKt.asImageBitmap(platformBitmap.getBitmap()), 0L, 0L, 0L, IntSize.m8326constructorimpl((((int) Float.intBitsToFloat((int) (contentDrawScope3.mo5922getSizeNHjbRc() >> 32))) << 32) | (((int) Float.intBitsToFloat((int) (contentDrawScope3.mo5922getSizeNHjbRc() & 4294967295L))) & 4294967295L)), 0.0f, null, null, 0, 0, 1006, null);
                    if (!Color.m5349equalsimpl0(skySnapshot.m9857getTintColor0d7_KjU(), Color.Companion.m5383getTransparent0d7_KjU())) {
                        DrawScope.m5916drawRectnJ9OG0$default(contentDrawScope3, skySnapshot.m9857getTintColor0d7_KjU(), 0L, 0L, 0.0f, null, null, BlendMode.Companion.m5288getSrcOver0nO6VwU(), 62, null);
                    }
                    drawContext2.getCanvas().restore();
                    drawContext2.mo5844setSizeuvyYCjk(j);
                } catch (Throwable th2) {
                    th = th2;
                    drawContext2.getCanvas().restore();
                    drawContext2.mo5844setSizeuvyYCjk(j);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                j = mo5843getSizeNHjbRc2;
            }
        }
        if (this.isProcessing) {
            this.queuedVersion = contentVersion$cloudy_release;
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastBlurStartTime < 50) {
            this.queuedVersion = contentVersion$cloudy_release;
        } else if (contentVersion$cloudy_release == this.cachedContentVersion) {
        } else {
            this.lastBlurStartTime = currentTimeMillis;
            this.isProcessing = true;
            this.pendingContentVersion = contentVersion$cloudy_release;
            this.onStateChanged.invoke(CloudyState.Loading.INSTANCE);
            SkySnapshot m9854copyfnh65Uc$default = SkySnapshot.m9854copyfnh65Uc$default(skySnapshot, 0, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, null, 0L, 1023, null);
            launch$default = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), Dispatchers.getMain(), null, new CloudyBackgroundModifierNode$drawWithBitmap$3(graphicsLayer, this, (int) m9854copyfnh65Uc$default.getChildWidth(), (int) m9854copyfnh65Uc$default.getChildHeight(), m9854copyfnh65Uc$default, this, contentVersion$cloudy_release, null), 2, null);
            this.blurJob = launch$default;
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        Job job = this.blurJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.blurJob = null;
        this.blurredBitmap = null;
        this.isProcessing = false;
        this.cachedContentVersion = -1L;
        this.pendingContentVersion = -1L;
        this.queuedVersion = -1L;
        this.lastBlurStartTime = 0L;
    }
}
