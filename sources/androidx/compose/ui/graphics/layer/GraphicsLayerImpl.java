package androidx.compose.ui.graphics.layer;

import android.graphics.Matrix;
import android.graphics.Outline;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: AndroidGraphicsLayer.android.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b`\u0018\u0000 w2\u00020\u0001:\u0001wJ\b\u0010W\u001a\u00020XH&J\b\u0010Y\u001a\u00020ZH&J\u0010\u0010[\u001a\u00020Z2\u0006\u0010\\\u001a\u00020]H&J9\u0010^\u001a\u00020Z2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020d2\u0017\u0010e\u001a\u0013\u0012\u0004\u0012\u00020g\u0012\u0004\u0012\u00020Z0f¢\u0006\u0002\bhH&J$\u0010i\u001a\u00020Z2\b\u0010j\u001a\u0004\u0018\u00010k2\u0006\u0010l\u001a\u00020mH&ø\u0001\u0000¢\u0006\u0004\bn\u0010oJ*\u0010p\u001a\u00020Z2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020r2\u0006\u0010t\u001a\u00020mH&ø\u0001\u0000¢\u0006\u0004\bu\u0010vR\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\tX¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000fX¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007R\u0018\u0010\u0017\u001a\u00020\u0018X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001eX¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$X¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010\u0013R\u0014\u0010'\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u001aR\u0018\u0010)\u001a\u00020\u0018X¦\u000e¢\u0006\f\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010\u001cR\u0012\u0010+\u001a\u00020,X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u000bR\u0012\u0010.\u001a\u00020,X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u000bR\u001e\u00100\u001a\u000201X¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b2\u0010\u000b\"\u0004\b3\u0010\rR\u001a\u00104\u001a\u0004\u0018\u000105X¦\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0018\u0010:\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b;\u0010\u0005\"\u0004\b<\u0010\u0007R\u0018\u0010=\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b>\u0010\u0005\"\u0004\b?\u0010\u0007R\u0018\u0010@\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bA\u0010\u0005\"\u0004\bB\u0010\u0007R\u0018\u0010C\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bD\u0010\u0005\"\u0004\bE\u0010\u0007R\u0018\u0010F\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bG\u0010\u0005\"\u0004\bH\u0010\u0007R\u0018\u0010I\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bJ\u0010\u0005\"\u0004\bK\u0010\u0007R\u001e\u0010L\u001a\u00020\tX¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\bM\u0010\u000b\"\u0004\bN\u0010\rR\u0014\u0010O\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bP\u0010\u001aR\u0018\u0010Q\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bR\u0010\u0005\"\u0004\bS\u0010\u0007R\u0018\u0010T\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bU\u0010\u0005\"\u0004\bV\u0010\u0007ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006xÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "cameraDistance", "getCameraDistance", "setCameraDistance", "clip", "", "getClip", "()Z", "setClip", "(Z)V", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "compositingStrategy", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "getCompositingStrategy-ke2Ky5w", "setCompositingStrategy-Wpw9cng", "hasDisplayList", "getHasDisplayList", "isInvalidated", "setInvalidated", "layerId", "", "getLayerId", "ownerId", "getOwnerId", "pivotOffset", "Landroidx/compose/ui/geometry/Offset;", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "supportsSoftwareRendering", "getSupportsSoftwareRendering", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "calculateMatrix", "Landroid/graphics/Matrix;", "discardDisplayList", "", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "record", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", AdRevenueConstants.LAYER_KEY, "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "setOutline", "outline", "Landroid/graphics/Outline;", "outlineSize", "Landroidx/compose/ui/unit/IntSize;", "setOutline-O0kMr_c", "(Landroid/graphics/Outline;J)V", "setPosition", "x", "", "y", "size", "setPosition-H0pRuoY", "(IIJ)V", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface GraphicsLayerImpl {
    public static final Companion Companion = Companion.$$INSTANCE;

    Matrix calculateMatrix();

    void discardDisplayList();

    void draw(Canvas canvas);

    float getAlpha();

    /* renamed from: getAmbientShadowColor-0d7_KjU  reason: not valid java name */
    long mo4743getAmbientShadowColor0d7_KjU();

    /* renamed from: getBlendMode-0nO6VwU  reason: not valid java name */
    int mo4744getBlendMode0nO6VwU();

    float getCameraDistance();

    boolean getClip();

    ColorFilter getColorFilter();

    /* renamed from: getCompositingStrategy-ke2Ky5w  reason: not valid java name */
    int mo4745getCompositingStrategyke2Ky5w();

    default boolean getHasDisplayList() {
        return true;
    }

    long getLayerId();

    long getOwnerId();

    /* renamed from: getPivotOffset-F1C5BW0  reason: not valid java name */
    long mo4746getPivotOffsetF1C5BW0();

    RenderEffect getRenderEffect();

    float getRotationX();

    float getRotationY();

    float getRotationZ();

    float getScaleX();

    float getScaleY();

    float getShadowElevation();

    /* renamed from: getSpotShadowColor-0d7_KjU  reason: not valid java name */
    long mo4747getSpotShadowColor0d7_KjU();

    default boolean getSupportsSoftwareRendering() {
        return false;
    }

    float getTranslationX();

    float getTranslationY();

    boolean isInvalidated();

    void record(Density density, LayoutDirection layoutDirection, GraphicsLayer graphicsLayer, Function1<? super DrawScope, Unit> function1);

    void setAlpha(float f);

    /* renamed from: setAmbientShadowColor-8_81llA  reason: not valid java name */
    void mo4748setAmbientShadowColor8_81llA(long j);

    /* renamed from: setBlendMode-s9anfk8  reason: not valid java name */
    void mo4749setBlendModes9anfk8(int i);

    void setCameraDistance(float f);

    void setClip(boolean z);

    void setColorFilter(ColorFilter colorFilter);

    /* renamed from: setCompositingStrategy-Wpw9cng  reason: not valid java name */
    void mo4750setCompositingStrategyWpw9cng(int i);

    void setInvalidated(boolean z);

    /* renamed from: setOutline-O0kMr_c  reason: not valid java name */
    void mo4751setOutlineO0kMr_c(Outline outline, long j);

    /* renamed from: setPivotOffset-k-4lQ0M  reason: not valid java name */
    void mo4752setPivotOffsetk4lQ0M(long j);

    /* renamed from: setPosition-H0pRuoY  reason: not valid java name */
    void mo4753setPositionH0pRuoY(int i, int i2, long j);

    void setRenderEffect(RenderEffect renderEffect);

    void setRotationX(float f);

    void setRotationY(float f);

    void setRotationZ(float f);

    void setScaleX(float f);

    void setScaleY(float f);

    void setShadowElevation(float f);

    /* renamed from: setSpotShadowColor-8_81llA  reason: not valid java name */
    void mo4754setSpotShadowColor8_81llA(long j);

    void setTranslationX(float f);

    void setTranslationY(float f);

    /* compiled from: AndroidGraphicsLayer.android.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl$Companion;", "", "()V", "DefaultDrawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "getDefaultDrawBlock", "()Lkotlin/jvm/functions/Function1;", "ui-graphics_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Function1<DrawScope, Unit> DefaultDrawBlock = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.layer.GraphicsLayerImpl$Companion$DefaultDrawBlock$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawScope) {
                DrawScope.m4634drawRectnJ9OG0$default(drawScope, Color.Companion.m4113getTransparent0d7_KjU(), 0L, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
            }
        };

        private Companion() {
        }

        public final Function1<DrawScope, Unit> getDefaultDrawBlock() {
            return DefaultDrawBlock;
        }
    }
}
