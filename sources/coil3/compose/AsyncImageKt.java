package coil3.compose;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import coil3.ImageLoader;
import coil3.compose.AsyncImagePainter;
import coil3.compose.internal.AsyncImageState;
import coil3.compose.internal.ContentPainterElement;
import coil3.compose.internal.UtilsKt;
import coil3.request.ImageRequest;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AsyncImage.kt */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aß\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007¢\u0006\u0004\b!\u0010\"\u001a¡\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0\u000f2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007¢\u0006\u0004\b&\u0010'\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010(\u001a\u00020)2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0\u000f2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0003¢\u0006\u0004\b*\u0010+¨\u0006,"}, d2 = {"AsyncImage", "", CommonUrlParts.MODEL, "", "contentDescription", "", "imageLoader", "Lcoil3/ImageLoader;", "modifier", "Landroidx/compose/ui/Modifier;", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onLoading", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State$Loading;", "onSuccess", "Lcoil3/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil3/compose/AsyncImagePainter$State$Error;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "clipToBounds", "", "AsyncImage-nc27qi8", "(Ljava/lang/Object;Ljava/lang/String;Lcoil3/ImageLoader;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLandroidx/compose/runtime/Composer;III)V", "transform", "Lcoil3/compose/AsyncImagePainter$State;", "onState", "AsyncImage-sKDTAoQ", "(Ljava/lang/Object;Ljava/lang/String;Lcoil3/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLandroidx/compose/runtime/Composer;III)V", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcoil3/compose/internal/AsyncImageState;", "AsyncImage-76YX9Dk", "(Lcoil3/compose/internal/AsyncImageState;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLandroidx/compose/runtime/Composer;II)V", "coil-compose-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AsyncImageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AsyncImage_76YX9Dk$lambda$0(AsyncImageState asyncImageState, String str, Modifier modifier, Function1 function1, Function1 function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, int i2, int i3, Composer composer, int i4) {
        m7733AsyncImage76YX9Dk(asyncImageState, str, modifier, function1, function12, alignment, contentScale, f, colorFilter, i, z, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
        return Unit.INSTANCE;
    }

    /* renamed from: AsyncImage-nc27qi8  reason: not valid java name */
    public static final void m7734AsyncImagenc27qi8(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Painter painter, Painter painter2, Painter painter3, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, Composer composer, int i2, int i3, int i4) {
        Modifier modifier2;
        ComposerKt.sourceInformationMarkerStart(composer, -1128374444, "C(AsyncImage)P(10,4,9,11,15,6,7,13,14,12!1,5!1,3,8:c#ui.graphics.FilterQuality)73@3681L35,72@3657L425:AsyncImage.kt#8xxpns");
        Modifier.Companion companion = (i4 & 8) != 0 ? Modifier.Companion : modifier;
        Painter painter4 = (i4 & 16) != 0 ? null : painter;
        Painter painter5 = (i4 & 32) != 0 ? null : painter2;
        Painter painter6 = (i4 & 64) != 0 ? painter5 : painter3;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function14 = (i4 & 128) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function15 = (i4 & 256) != 0 ? null : function12;
        Function1<? super AsyncImagePainter.State.Error, Unit> function16 = (i4 & 512) != 0 ? null : function13;
        Alignment center = (i4 & 1024) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i4 & 2048) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i4 & 4096) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i4 & 8192) != 0 ? null : colorFilter;
        int m4643getDefaultFilterQualityfv9h1I = (i4 & 16384) != 0 ? DrawScope.Companion.m4643getDefaultFilterQualityfv9h1I() : i;
        boolean z2 = (i4 & 32768) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            modifier2 = companion;
            ComposerKt.traceEventStart(-1128374444, i2, i3, "coil3.compose.AsyncImage (AsyncImage.kt:72)");
        } else {
            modifier2 = companion;
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1014878424, "CC(AsyncImageState)P(1)148@4782L7:utils.kt#7tflp");
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(LocalAsyncImageModelEqualityDelegateKt.getLocalAsyncImageModelEqualityDelegate());
        ComposerKt.sourceInformationMarkerEnd(composer);
        AsyncImageState asyncImageState = new AsyncImageState(obj, (AsyncImageModelEqualityDelegate) consume, imageLoader);
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i5 = i3 << 15;
        Alignment alignment2 = center;
        ContentScale contentScale2 = fit;
        float f3 = f2;
        m7733AsyncImage76YX9Dk(asyncImageState, str, modifier2, UtilsKt.transformOf(painter4, painter5, painter6), UtilsKt.onStateOf(function14, function15, function16), alignment2, contentScale2, f3, colorFilter2, m4643getDefaultFilterQualityfv9h1I, z2, composer, ((i2 >> 3) & 896) | (i2 & 112) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | (234881024 & i5) | (i5 & 1879048192), (i3 >> 15) & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* renamed from: AsyncImage-sKDTAoQ  reason: not valid java name */
    public static final void m7735AsyncImagesKDTAoQ(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, Composer composer, int i2, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, 40041566, "C(AsyncImage)P(8,4,7,9,11,10!1,5!1,3,6:c#ui.graphics.FilterQuality)126@6242L35,125@6218L360:AsyncImage.kt#8xxpns");
        Modifier.Companion companion = (i4 & 8) != 0 ? Modifier.Companion : modifier;
        Function1<AsyncImagePainter.State, AsyncImagePainter.State> defaultTransform = (i4 & 16) != 0 ? AsyncImagePainter.Companion.getDefaultTransform() : function1;
        Function1<? super AsyncImagePainter.State, Unit> function13 = (i4 & 32) != 0 ? null : function12;
        Alignment center = (i4 & 64) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i4 & 128) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i4 & 256) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i4 & 512) == 0 ? colorFilter : null;
        int m4643getDefaultFilterQualityfv9h1I = (i4 & 1024) != 0 ? DrawScope.Companion.m4643getDefaultFilterQualityfv9h1I() : i;
        boolean z2 = (i4 & 2048) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(40041566, i2, i3, "coil3.compose.AsyncImage (AsyncImage.kt:125)");
        }
        int i5 = i2 >> 3;
        ComposerKt.sourceInformationMarkerStart(composer, -1014878424, "CC(AsyncImageState)P(1)148@4782L7:utils.kt#7tflp");
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(LocalAsyncImageModelEqualityDelegateKt.getLocalAsyncImageModelEqualityDelegate());
        ComposerKt.sourceInformationMarkerEnd(composer);
        AsyncImageState asyncImageState = new AsyncImageState(obj, (AsyncImageModelEqualityDelegate) consume, imageLoader);
        ComposerKt.sourceInformationMarkerEnd(composer);
        m7733AsyncImage76YX9Dk(asyncImageState, str, companion, defaultTransform, function13, center, fit, f2, colorFilter2, m4643getDefaultFilterQualityfv9h1I, z2, composer, (i5 & 234881024) | (i2 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | ((i3 << 27) & 1879048192), (i3 >> 3) & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* renamed from: AsyncImage-76YX9Dk  reason: not valid java name */
    private static final void m7733AsyncImage76YX9Dk(final AsyncImageState asyncImageState, final String str, final Modifier modifier, final Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, final Function1<? super AsyncImagePainter.State, Unit> function12, final Alignment alignment, final ContentScale contentScale, final float f, final ColorFilter colorFilter, final int i, final boolean z, Composer composer, final int i2, final int i3) {
        AsyncImageState asyncImageState2;
        int i4;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        float f2;
        ColorFilter colorFilter2;
        int i5;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(1236588022);
        ComposerKt.sourceInformation(startRestartGroup, "C(AsyncImage)P(9,4,7,10,8!1,5!1,3,6:c#ui.graphics.FilterQuality)153@6957L98,173@7677L16,159@7090L749:AsyncImage.kt#8xxpns");
        if ((i2 & 6) == 0) {
            asyncImageState2 = asyncImageState;
            i4 = (startRestartGroup.changed(asyncImageState2) ? 4 : 2) | i2;
        } else {
            asyncImageState2 = asyncImageState;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            obj = str;
            i4 |= startRestartGroup.changed(obj) ? 32 : 16;
        } else {
            obj = str;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            obj2 = function1;
            i4 |= startRestartGroup.changedInstance(obj2) ? 2048 : 1024;
        } else {
            obj2 = function1;
        }
        if ((i2 & 24576) == 0) {
            obj3 = function12;
            i4 |= startRestartGroup.changedInstance(obj3) ? 16384 : 8192;
        } else {
            obj3 = function12;
        }
        if ((196608 & i2) == 0) {
            obj4 = alignment;
            i4 |= startRestartGroup.changed(obj4) ? 131072 : 65536;
        } else {
            obj4 = alignment;
        }
        if ((1572864 & i2) == 0) {
            i4 |= startRestartGroup.changed(contentScale) ? 1048576 : 524288;
        }
        if ((12582912 & i2) == 0) {
            f2 = f;
            i4 |= startRestartGroup.changed(f2) ? 8388608 : 4194304;
        } else {
            f2 = f;
        }
        if ((100663296 & i2) == 0) {
            colorFilter2 = colorFilter;
            i4 |= startRestartGroup.changed(colorFilter2) ? 67108864 : 33554432;
        } else {
            colorFilter2 = colorFilter;
        }
        if ((805306368 & i2) == 0) {
            i5 = i;
            i4 |= startRestartGroup.changed(i5) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        } else {
            i5 = i;
        }
        if ((i3 & 6) == 0) {
            i6 = i3 | (startRestartGroup.changed(z) ? 4 : 2);
        } else {
            i6 = i3;
        }
        if ((i4 & 306783379) != 306783378 || (i6 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1236588022, i4, i6, "coil3.compose.AsyncImage (AsyncImage.kt:152)");
            }
            ImageRequest requestOfWithSizeResolver = UtilsKt.requestOfWithSizeResolver(asyncImageState2.getModel(), contentScale, startRestartGroup, (i4 >> 15) & 112);
            UtilsKt.validateRequest(requestOfWithSizeResolver);
            int i7 = i5;
            Modifier then = modifier.then(new ContentPainterElement(requestOfWithSizeResolver, asyncImageState2.getImageLoader(), asyncImageState2.getModelEqualityDelegate(), obj2, obj3, i7, obj4, contentScale, f2, colorFilter2, z, UtilsKt.previewHandler(startRestartGroup, 0), obj, null));
            MeasurePolicy useMinConstraintsMeasurePolicy = UtilsKt.getUseMinConstraintsMeasurePolicy();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 544976794, "CC(Layout)P(1)121@4798L23,124@4949L333:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, then);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl, useMinConstraintsMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: coil3.compose.AsyncImageKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj5, Object obj6) {
                    Unit AsyncImage_76YX9Dk$lambda$0;
                    AsyncImage_76YX9Dk$lambda$0 = AsyncImageKt.AsyncImage_76YX9Dk$lambda$0(AsyncImageState.this, str, modifier, function1, function12, alignment, contentScale, f, colorFilter, i, z, i2, i3, (Composer) obj5, ((Integer) obj6).intValue());
                    return AsyncImage_76YX9Dk$lambda$0;
                }
            });
        }
    }
}
