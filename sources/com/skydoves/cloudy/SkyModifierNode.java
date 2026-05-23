package com.skydoves.cloudy;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CloudyBackground.android.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00192\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0019B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\f\u0010\u0016\u001a\u00020\u0013*\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/skydoves/cloudy/SkyModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "sky", "Lcom/skydoves/cloudy/Sky;", "<init>", "(Lcom/skydoves/cloudy/Sky;)V", "getSky", "()Lcom/skydoves/cloudy/Sky;", "setSky", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "positionInRoot", "Landroidx/compose/ui/geometry/Offset;", "J", "lastVersionIncrementTime", "", "onGloballyPositioned", "", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "onDetach", "Companion", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
final class SkyModifierNode extends Modifier.Node implements DrawModifierNode, GlobalPositionAwareModifierNode {
    public static final Companion Companion = new Companion(null);
    private static final long VERSION_INCREMENT_INTERVAL_MS = 100;
    private GraphicsLayer graphicsLayer;
    private long lastVersionIncrementTime;
    private long positionInRoot;
    private Sky sky;

    public SkyModifierNode(Sky sky) {
        Intrinsics.checkNotNullParameter(sky, "sky");
        this.sky = sky;
        this.positionInRoot = Offset.Companion.m5119getZeroF1C5BW0();
    }

    public final Sky getSky() {
        return this.sky;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public /* bridge */ void onMeasureResultChanged() {
        super.onMeasureResultChanged();
    }

    public final void setSky(Sky sky) {
        Intrinsics.checkNotNullParameter(sky, "<set-?>");
        this.sky = sky;
    }

    /* compiled from: CloudyBackground.android.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/skydoves/cloudy/SkyModifierNode$Companion;", "", "<init>", "()V", "VERSION_INCREMENT_INTERVAL_MS", "", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        long positionInRoot = LayoutCoordinatesKt.positionInRoot(coordinates);
        this.positionInRoot = positionInRoot;
        this.sky.setSourceBounds$cloudy_release(RectKt.m5143Recttz77jQw(positionInRoot, IntSizeKt.m8343toSizeozmzZPI(coordinates.mo6826getSizeYbymL2g())));
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(final ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        GraphicsContext requireGraphicsContext = DelegatableNodeKt.requireGraphicsContext(this);
        GraphicsLayer graphicsLayer = this.graphicsLayer;
        if (graphicsLayer == null) {
            graphicsLayer = requireGraphicsContext.createGraphicsLayer();
            this.graphicsLayer = graphicsLayer;
        }
        GraphicsLayer graphicsLayer2 = graphicsLayer;
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        DrawScope.m5920recordJVtK1S4$default(contentDrawScope2, graphicsLayer2, 0L, new Function1() { // from class: com.skydoves.cloudy.SkyModifierNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SkyModifierNode.draw$lambda$1(ContentDrawScope.this, (DrawScope) obj);
            }
        }, 1, null);
        this.sky.setBackgroundLayer$cloudy_release(graphicsLayer2);
        this.sky.incrementContentVersion$cloudy_release();
        GraphicsLayerKt.drawLayer(contentDrawScope2, graphicsLayer2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit draw$lambda$1(ContentDrawScope contentDrawScope, DrawScope record) {
        Intrinsics.checkNotNullParameter(record, "$this$record");
        contentDrawScope.drawContent();
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        GraphicsLayer graphicsLayer = this.graphicsLayer;
        if (graphicsLayer != null) {
            DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(graphicsLayer);
        }
        this.graphicsLayer = null;
        this.sky.setBackgroundLayer$cloudy_release(null);
    }
}
