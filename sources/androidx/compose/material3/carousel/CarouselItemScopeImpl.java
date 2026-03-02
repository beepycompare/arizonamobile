package androidx.compose.material3.carousel;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.shape.GenericShape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: CarouselItemScope.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\n*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017¢\u0006\u0002\u0010\rJ!\u0010\u000e\u001a\u00020\n*\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0017¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0017¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/carousel/CarouselItemScopeImpl;", "Landroidx/compose/material3/carousel/CarouselItemScope;", "itemInfo", "Landroidx/compose/material3/carousel/CarouselItemDrawInfo;", "<init>", "(Landroidx/compose/material3/carousel/CarouselItemDrawInfo;)V", "carouselItemDrawInfo", "getCarouselItemDrawInfo", "()Landroidx/compose/material3/carousel/CarouselItemDrawInfo;", "maskClip", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "maskBorder", "border", "Landroidx/compose/foundation/BorderStroke;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "rememberMaskShape", "Landroidx/compose/foundation/shape/GenericShape;", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/shape/GenericShape;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CarouselItemScopeImpl implements CarouselItemScope {
    public static final int $stable = 8;
    private final CarouselItemDrawInfo itemInfo;

    public CarouselItemScopeImpl(CarouselItemDrawInfo carouselItemDrawInfo) {
        this.itemInfo = carouselItemDrawInfo;
    }

    @Override // androidx.compose.material3.carousel.CarouselItemScope
    public CarouselItemDrawInfo getCarouselItemDrawInfo() {
        return this.itemInfo;
    }

    @Override // androidx.compose.material3.carousel.CarouselItemScope
    public Modifier maskClip(Modifier modifier, Shape shape, Composer composer, int i) {
        composer.startReplaceGroup(440683050);
        ComposerKt.sourceInformation(composer, "C(maskClip)N(shape)81@3262L32:CarouselItemScope.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(440683050, i, -1, "androidx.compose.material3.carousel.CarouselItemScopeImpl.maskClip (CarouselItemScope.kt:81)");
        }
        Modifier clip = ClipKt.clip(modifier, rememberMaskShape(shape, composer, (i >> 3) & WebSocketProtocol.PAYLOAD_SHORT));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return clip;
    }

    @Override // androidx.compose.material3.carousel.CarouselItemScope
    public Modifier maskBorder(Modifier modifier, BorderStroke borderStroke, Shape shape, Composer composer, int i) {
        composer.startReplaceGroup(610897768);
        ComposerKt.sourceInformation(composer, "C(maskBorder)N(border,shape)85@3421L32:CarouselItemScope.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(610897768, i, -1, "androidx.compose.material3.carousel.CarouselItemScopeImpl.maskBorder (CarouselItemScope.kt:85)");
        }
        Modifier border = BorderKt.border(modifier, borderStroke, rememberMaskShape(shape, composer, (i >> 6) & WebSocketProtocol.PAYLOAD_SHORT));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return border;
    }

    @Override // androidx.compose.material3.carousel.CarouselItemScope
    public GenericShape rememberMaskShape(final Shape shape, Composer composer, int i) {
        composer.startReplaceGroup(152582312);
        ComposerKt.sourceInformation(composer, "C(rememberMaskShape)N(shape)89@3572L7,90@3595L327:CarouselItemScope.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(152582312, i, -1, "androidx.compose.material3.carousel.CarouselItemScopeImpl.rememberMaskShape (CarouselItemScope.kt:88)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) consume;
        Object carouselItemDrawInfo = getCarouselItemDrawInfo();
        ComposerKt.sourceInformationMarkerStart(composer, 602718415, "CC(remember):CarouselItemScope.kt#9igjgp");
        boolean changed = composer.changed(carouselItemDrawInfo) | composer.changed(density);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new GenericShape(new Function3() { // from class: androidx.compose.material3.carousel.CarouselItemScopeImpl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CarouselItemScopeImpl.rememberMaskShape$lambda$1$lambda$0(CarouselItemScopeImpl.this, shape, density, (Path) obj, (Size) obj2, (LayoutDirection) obj3);
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        GenericShape genericShape = (GenericShape) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return genericShape;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit rememberMaskShape$lambda$1$lambda$0(CarouselItemScopeImpl carouselItemScopeImpl, Shape shape, Density density, Path path, Size size, LayoutDirection layoutDirection) {
        Rect intersect = carouselItemScopeImpl.getCarouselItemDrawInfo().getMaskRect().intersect(SizeKt.m4617toRectuvyYCjk(size.m4601unboximpl()));
        OutlineKt.addOutline(path, shape.mo320createOutlinePq9zytI(intersect.m4560getSizeNHjbRc(), layoutDirection, density));
        path.mo4664translatek4lQ0M(Offset.m4519constructorimpl((Float.floatToRawIntBits(intersect.getLeft()) << 32) | (Float.floatToRawIntBits(intersect.getTop()) & 4294967295L)));
        return Unit.INSTANCE;
    }
}
