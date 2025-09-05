package coil3.compose;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
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
import androidx.profileinstaller.ProfileVerifier;
import coil3.ImageLoader;
import coil3.compose.AsyncImagePainter;
import coil3.compose.internal.AsyncImageState;
import coil3.compose.internal.SubcomposeContentPainterElement;
import coil3.compose.internal.UtilsKt;
import coil3.request.ImageRequest;
import coil3.size.SizeResolver;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: SubcomposeAsyncImage.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aÉ\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2&\b\u0002\u0010\r\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122&\b\u0002\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122&\b\u0002\u0010\u0015\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%H\u0007¢\u0006\u0004\b&\u0010'\u001a¿\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0004\b*\u0010+\u001a¥\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0003¢\u0006\u0004\b.\u0010/\u001ae\u00100\u001a\u00020\u0001*\u00020\u000f2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u00101\u001a\u0002022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010$\u001a\u00020%H\u0007¢\u0006\u0002\u00103\u001a\u0095\u0001\u00104\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122$\u0010\r\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122$\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122$\u0010\u0015\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0003¢\u0006\u0002\u00105¨\u00066"}, d2 = {"SubcomposeAsyncImage", "", CommonUrlParts.MODEL, "", "contentDescription", "", "imageLoader", "Lcoil3/ImageLoader;", "modifier", "Landroidx/compose/ui/Modifier;", "transform", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State;", "loading", "Lkotlin/Function2;", "Lcoil3/compose/SubcomposeAsyncImageScope;", "Lcoil3/compose/AsyncImagePainter$State$Loading;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", FirebaseAnalytics.Param.SUCCESS, "Lcoil3/compose/AsyncImagePainter$State$Success;", "error", "Lcoil3/compose/AsyncImagePainter$State$Error;", "onLoading", "onSuccess", "onError", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "clipToBounds", "", "SubcomposeAsyncImage-MokUVwQ", "(Ljava/lang/Object;Ljava/lang/String;Lcoil3/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLandroidx/compose/runtime/Composer;III)V", "onState", FirebaseAnalytics.Param.CONTENT, "SubcomposeAsyncImage-QgsmV_s", "(Ljava/lang/Object;Ljava/lang/String;Lcoil3/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcoil3/compose/internal/AsyncImageState;", "SubcomposeAsyncImage-gl8XCv8", "(Lcoil3/compose/internal/AsyncImageState;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SubcomposeAsyncImageContent", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Lcoil3/compose/SubcomposeAsyncImageScope;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ZLandroidx/compose/runtime/Composer;II)V", "contentOf", "(Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;)Lkotlin/jvm/functions/Function3;", "coil-compose-core_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SubcomposeAsyncImageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SubcomposeAsyncImageContent$lambda$3(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Modifier modifier, Painter painter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, int i, int i2, Composer composer, int i3) {
        SubcomposeAsyncImageContent(subcomposeAsyncImageScope, modifier, painter, str, alignment, contentScale, f, colorFilter, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SubcomposeAsyncImage_gl8XCv8$lambda$2(AsyncImageState asyncImageState, String str, Modifier modifier, Function1 function1, Function1 function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, Function3 function3, int i2, int i3, int i4, Composer composer, int i5) {
        m8344SubcomposeAsyncImagegl8XCv8(asyncImageState, str, modifier, function1, function12, alignment, contentScale, f, colorFilter, i, z, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* renamed from: SubcomposeAsyncImage-MokUVwQ  reason: not valid java name */
    public static final void m8342SubcomposeAsyncImageMokUVwQ(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function42, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function43, Function1<? super AsyncImagePainter.State.Loading, Unit> function12, Function1<? super AsyncImagePainter.State.Success, Unit> function13, Function1<? super AsyncImagePainter.State.Error, Unit> function14, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, Composer composer, int i2, int i3, int i4) {
        Modifier modifier2;
        ComposerKt.sourceInformationMarkerStart(composer, 831032125, "C(SubcomposeAsyncImage)P(10,4,8,11,16,9,15,6,13,14,12!1,5!1,3,7:c#ui.graphics.FilterQuality)83@4395L35,82@4361L453:SubcomposeAsyncImage.kt#8xxpns");
        Modifier.Companion companion = (i4 & 8) != 0 ? Modifier.Companion : modifier;
        Function1<AsyncImagePainter.State, AsyncImagePainter.State> defaultTransform = (i4 & 16) != 0 ? AsyncImagePainter.Companion.getDefaultTransform() : function1;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function44 = (i4 & 32) != 0 ? null : function4;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function45 = (i4 & 64) != 0 ? null : function42;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function46 = (i4 & 128) != 0 ? null : function43;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function15 = (i4 & 256) != 0 ? null : function12;
        Function1<? super AsyncImagePainter.State.Success, Unit> function16 = (i4 & 512) != 0 ? null : function13;
        Function1<? super AsyncImagePainter.State.Error, Unit> function17 = (i4 & 1024) != 0 ? null : function14;
        Alignment center = (i4 & 2048) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i4 & 4096) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i4 & 8192) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i4 & 16384) != 0 ? null : colorFilter;
        int m5119getDefaultFilterQualityfv9h1I = (i4 & 32768) != 0 ? DrawScope.Companion.m5119getDefaultFilterQualityfv9h1I() : i;
        boolean z2 = (i4 & 65536) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            modifier2 = companion;
            ComposerKt.traceEventStart(831032125, i2, i3, "coil3.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:82)");
        } else {
            modifier2 = companion;
        }
        int i5 = i2 >> 3;
        ComposerKt.sourceInformationMarkerStart(composer, -1014878424, "CC(AsyncImageState)P(1)148@4782L7:utils.kt#7tflp");
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(LocalAsyncImageModelEqualityDelegateKt.getLocalAsyncImageModelEqualityDelegate());
        ComposerKt.sourceInformationMarkerEnd(composer);
        AsyncImageState asyncImageState = new AsyncImageState(obj, (AsyncImageModelEqualityDelegate) consume, imageLoader);
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i6 = (i2 & 112) | (i5 & 896) | (i5 & 7168);
        int i7 = i3 << 12;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function18 = defaultTransform;
        Alignment alignment2 = center;
        Modifier modifier3 = modifier2;
        m8344SubcomposeAsyncImagegl8XCv8(asyncImageState, str, modifier3, function18, UtilsKt.onStateOf(function15, function16, function17), alignment2, fit, f2, colorFilter2, m5119getDefaultFilterQualityfv9h1I, z2, contentOf(function44, function45, function46), composer, i6 | (458752 & i7) | (3670016 & i7) | (29360128 & i7) | (234881024 & i7) | (i7 & 1879048192), (i3 >> 18) & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* renamed from: SubcomposeAsyncImage-QgsmV_s  reason: not valid java name */
    public static final void m8343SubcomposeAsyncImageQgsmV_s(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, Function3<? super SubcomposeAsyncImageScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i2, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, -734720902, "C(SubcomposeAsyncImage)P(9,5,8,10,12,11!1,6!1,3,7:c#ui.graphics.FilterQuality)142@7300L35,141@7266L393:SubcomposeAsyncImage.kt#8xxpns");
        Modifier.Companion companion = (i4 & 8) != 0 ? Modifier.Companion : modifier;
        Function1<AsyncImagePainter.State, AsyncImagePainter.State> defaultTransform = (i4 & 16) != 0 ? AsyncImagePainter.Companion.getDefaultTransform() : function1;
        Function1<? super AsyncImagePainter.State, Unit> function13 = (i4 & 32) != 0 ? null : function12;
        Alignment center = (i4 & 64) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i4 & 128) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i4 & 256) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i4 & 512) == 0 ? colorFilter : null;
        int m5119getDefaultFilterQualityfv9h1I = (i4 & 1024) != 0 ? DrawScope.Companion.m5119getDefaultFilterQualityfv9h1I() : i;
        boolean z2 = (i4 & 2048) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-734720902, i2, i3, "coil3.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:141)");
        }
        int i5 = i2 >> 3;
        ComposerKt.sourceInformationMarkerStart(composer, -1014878424, "CC(AsyncImageState)P(1)148@4782L7:utils.kt#7tflp");
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(LocalAsyncImageModelEqualityDelegateKt.getLocalAsyncImageModelEqualityDelegate());
        ComposerKt.sourceInformationMarkerEnd(composer);
        AsyncImageState asyncImageState = new AsyncImageState(obj, (AsyncImageModelEqualityDelegate) consume, imageLoader);
        ComposerKt.sourceInformationMarkerEnd(composer);
        m8344SubcomposeAsyncImagegl8XCv8(asyncImageState, str, companion, defaultTransform, function13, center, fit, f2, colorFilter2, m5119getDefaultFilterQualityfv9h1I, z2, function3, composer, ((i3 << 27) & 1879048192) | (i5 & 234881024) | (i2 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (29360128 & i5), (i3 >> 3) & WebSocketProtocol.PAYLOAD_SHORT, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0103  */
    /* renamed from: SubcomposeAsyncImage-gl8XCv8  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m8344SubcomposeAsyncImagegl8XCv8(final AsyncImageState asyncImageState, final String str, Modifier modifier, final Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, final Function1<? super AsyncImagePainter.State, Unit> function12, final Alignment alignment, final ContentScale contentScale, final float f, final ColorFilter colorFilter, final int i, final boolean z, final Function3<? super SubcomposeAsyncImageScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Object obj;
        int i6;
        int i7;
        final Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        Modifier modifier3;
        Composer startRestartGroup = composer.startRestartGroup(-205779950);
        ComposerKt.sourceInformation(startRestartGroup, "C(SubcomposeAsyncImage)P(10,5,8,11,9!1,6!1,3,7:c#ui.graphics.FilterQuality)171@8122L98,175@8239L232:SubcomposeAsyncImage.kt#8xxpns");
        if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(asyncImageState) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        int i8 = i4 & 4;
        if (i8 != 0) {
            i5 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i5 |= startRestartGroup.changed(modifier) ? 256 : 128;
            if ((i2 & 3072) != 0) {
                obj = function1;
                i5 |= startRestartGroup.changedInstance(obj) ? 2048 : 1024;
            } else {
                obj = function1;
            }
            if ((i2 & 24576) == 0) {
                i5 |= startRestartGroup.changedInstance(function12) ? 16384 : 8192;
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i5 |= startRestartGroup.changed(alignment) ? 131072 : 65536;
            }
            if ((i2 & 1572864) == 0) {
                i5 |= startRestartGroup.changed(contentScale) ? 1048576 : 524288;
            }
            if ((i2 & 12582912) == 0) {
                i5 |= startRestartGroup.changed(f) ? 8388608 : 4194304;
            }
            if ((i2 & 100663296) == 0) {
                i5 |= startRestartGroup.changed(colorFilter) ? 67108864 : 33554432;
            }
            if ((i2 & 805306368) == 0) {
                i5 |= startRestartGroup.changed(i) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
            }
            if ((i3 & 6) != 0) {
                i6 = i3 | (startRestartGroup.changed(z) ? 4 : 2);
            } else {
                i6 = i3;
            }
            if ((i3 & 48) == 0) {
                i6 |= startRestartGroup.changedInstance(function3) ? 32 : 16;
            }
            i7 = i6;
            if (startRestartGroup.shouldExecute((306783379 & i5) == 306783378 || (i7 & 19) != 18, i5 & 1)) {
                startRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
            } else {
                Modifier.Companion companion = i8 != 0 ? Modifier.Companion : modifier;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-205779950, i5, i7, "coil3.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:170)");
                }
                ImageRequest requestOfWithSizeResolver = UtilsKt.requestOfWithSizeResolver(asyncImageState.getModel(), contentScale, startRestartGroup, (i5 >> 15) & 112);
                int i9 = i5 >> 6;
                int i10 = i5 >> 12;
                final AsyncImagePainter m8322rememberAsyncImagePainter5jETZwI = AsyncImagePainterKt.m8322rememberAsyncImagePainter5jETZwI(requestOfWithSizeResolver, asyncImageState.getImageLoader(), obj, function12, contentScale, i, startRestartGroup, ((i5 >> 3) & 8064) | (i9 & 57344) | (i10 & 458752), 0);
                final SizeResolver sizeResolver = requestOfWithSizeResolver.getSizeResolver();
                if (sizeResolver instanceof ConstraintsSizeResolver) {
                    startRestartGroup.startReplaceGroup(-1470550590);
                    ComposerKt.sourceInformation(startRestartGroup, "211@9543L739,207@9394L888");
                    startRestartGroup = startRestartGroup;
                    modifier3 = companion;
                    BoxWithConstraintsKt.BoxWithConstraints(modifier3, alignment, true, ComposableLambdaKt.rememberComposableLambda(-374957172, true, new Function3() { // from class: coil3.compose.SubcomposeAsyncImageKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                            Unit SubcomposeAsyncImage_gl8XCv8$lambda$1;
                            SubcomposeAsyncImage_gl8XCv8$lambda$1 = SubcomposeAsyncImageKt.SubcomposeAsyncImage_gl8XCv8$lambda$1(SizeResolver.this, function3, m8322rememberAsyncImagePainter5jETZwI, str, alignment, contentScale, f, colorFilter, z, (BoxWithConstraintsScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                            return SubcomposeAsyncImage_gl8XCv8$lambda$1;
                        }
                    }, startRestartGroup, 54), startRestartGroup, (i9 & 14) | 3456 | (i10 & 112), 0);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(-1471239317);
                    ComposerKt.sourceInformation(startRestartGroup, "188@8695L543");
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(alignment, true);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Composer m3855constructorimpl = Updater.m3855constructorimpl(startRestartGroup);
                    Updater.m3862setimpl(m3855constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m3862setimpl(m3855constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m3855constructorimpl.getInserting() || !Intrinsics.areEqual(m3855constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3855constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3855constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m3862setimpl(m3855constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -293812529, "C202@9219L9:SubcomposeAsyncImage.kt#8xxpns");
                    function3.invoke(new RealSubcomposeAsyncImageScope(BoxScopeInstance.INSTANCE, m8322rememberAsyncImagePainter5jETZwI, str, alignment, contentScale, f, colorFilter, z), startRestartGroup, Integer.valueOf(i7 & 112));
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup = startRestartGroup;
                    modifier3 = companion;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: coil3.compose.SubcomposeAsyncImageKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit SubcomposeAsyncImage_gl8XCv8$lambda$2;
                        SubcomposeAsyncImage_gl8XCv8$lambda$2 = SubcomposeAsyncImageKt.SubcomposeAsyncImage_gl8XCv8$lambda$2(AsyncImageState.this, str, modifier2, function1, function12, alignment, contentScale, f, colorFilter, i, z, function3, i2, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                        return SubcomposeAsyncImage_gl8XCv8$lambda$2;
                    }
                });
                return;
            }
            return;
        }
        if ((i2 & 3072) != 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        if ((i2 & 1572864) == 0) {
        }
        if ((i2 & 12582912) == 0) {
        }
        if ((i2 & 100663296) == 0) {
        }
        if ((i2 & 805306368) == 0) {
        }
        if ((i3 & 6) != 0) {
        }
        if ((i3 & 48) == 0) {
        }
        i7 = i6;
        if (startRestartGroup.shouldExecute((306783379 & i5) == 306783378 || (i7 & 19) != 18, i5 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SubcomposeAsyncImage_gl8XCv8$lambda$1(SizeResolver sizeResolver, Function3 function3, AsyncImagePainter asyncImagePainter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "C226@10263L9:SubcomposeAsyncImage.kt#8xxpns");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(boxWithConstraintsScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-374957172, i2, -1, "coil3.compose.SubcomposeAsyncImage.<anonymous> (SubcomposeAsyncImage.kt:215)");
            }
            ((ConstraintsSizeResolver) sizeResolver).m8326setConstraintsBRTryo0(boxWithConstraintsScope.mo718getConstraintsmsEJaDk());
            function3.invoke(new RealSubcomposeAsyncImageScope(boxWithConstraintsScope, asyncImagePainter, str, alignment, contentScale, f, colorFilter, z), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SubcomposeAsyncImageContent(final SubcomposeAsyncImageScope subcomposeAsyncImageScope, Modifier modifier, Painter painter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        AsyncImagePainter asyncImagePainter;
        Object obj;
        Object obj2;
        Object obj3;
        float f2;
        Object obj4;
        boolean z2;
        final Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(-1375825518);
        ComposerKt.sourceInformation(startRestartGroup, "C(SubcomposeAsyncImageContent)P(6,7,4!1,5!1,3)276@11723L417:SubcomposeAsyncImage.kt#8xxpns");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(subcomposeAsyncImageScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 1;
        if (i11 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i2 & 2) == 0) {
                    asyncImagePainter = painter;
                    if (startRestartGroup.changedInstance(asyncImagePainter)) {
                        i10 = 256;
                        i3 |= i10;
                    }
                } else {
                    asyncImagePainter = painter;
                }
                i10 = 128;
                i3 |= i10;
            } else {
                asyncImagePainter = painter;
            }
            if ((i & 3072) != 0) {
                if ((i2 & 4) == 0) {
                    obj = str;
                    if (startRestartGroup.changed(obj)) {
                        i9 = 2048;
                        i3 |= i9;
                    }
                } else {
                    obj = str;
                }
                i9 = 1024;
                i3 |= i9;
            } else {
                obj = str;
            }
            if ((i & 24576) != 0) {
                if ((i2 & 8) == 0) {
                    obj2 = alignment;
                    if (startRestartGroup.changed(obj2)) {
                        i8 = 16384;
                        i3 |= i8;
                    }
                } else {
                    obj2 = alignment;
                }
                i8 = 8192;
                i3 |= i8;
            } else {
                obj2 = alignment;
            }
            if ((196608 & i) != 0) {
                if ((i2 & 16) == 0) {
                    obj3 = contentScale;
                    if (startRestartGroup.changed(obj3)) {
                        i7 = 131072;
                        i3 |= i7;
                    }
                } else {
                    obj3 = contentScale;
                }
                i7 = 65536;
                i3 |= i7;
            } else {
                obj3 = contentScale;
            }
            if ((1572864 & i) != 0) {
                if ((i2 & 32) == 0) {
                    f2 = f;
                    if (startRestartGroup.changed(f2)) {
                        i6 = 1048576;
                        i3 |= i6;
                    }
                } else {
                    f2 = f;
                }
                i6 = 524288;
                i3 |= i6;
            } else {
                f2 = f;
            }
            if ((12582912 & i) != 0) {
                if ((i2 & 64) == 0) {
                    obj4 = colorFilter;
                    if (startRestartGroup.changed(obj4)) {
                        i5 = 8388608;
                        i3 |= i5;
                    }
                } else {
                    obj4 = colorFilter;
                }
                i5 = 4194304;
                i3 |= i5;
            } else {
                obj4 = colorFilter;
            }
            if ((100663296 & i) != 0) {
                if ((i2 & 128) == 0) {
                    z2 = z;
                    if (startRestartGroup.changed(z2)) {
                        i4 = 67108864;
                        i3 |= i4;
                    }
                } else {
                    z2 = z;
                }
                i4 = 33554432;
                i3 |= i4;
            } else {
                z2 = z;
            }
            if (!startRestartGroup.shouldExecute((38347923 & i3) == 38347922, i3 & 1)) {
                startRestartGroup.startDefaults();
                if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                    if (i11 != 0) {
                        companion = Modifier.Companion;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -897;
                        asyncImagePainter = subcomposeAsyncImageScope.getPainter();
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -7169;
                        obj = subcomposeAsyncImageScope.getContentDescription();
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -57345;
                        obj2 = subcomposeAsyncImageScope.getAlignment();
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -458753;
                        obj3 = subcomposeAsyncImageScope.getContentScale();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -3670017;
                        f2 = subcomposeAsyncImageScope.getAlpha();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -29360129;
                        obj4 = subcomposeAsyncImageScope.getColorFilter();
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -234881025;
                        z2 = subcomposeAsyncImageScope.getClipToBounds();
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -458753;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -3670017;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -29360129;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -234881025;
                    }
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1375825518, i3, -1, "coil3.compose.SubcomposeAsyncImageContent (SubcomposeAsyncImage.kt:276)");
                }
                Modifier then = companion.then(new SubcomposeContentPainterElement(asyncImagePainter, obj2, obj3, f2, obj4, z2, obj));
                MeasurePolicy useMinConstraintsMeasurePolicy = UtilsKt.getUseMinConstraintsMeasurePolicy();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 544976794, "CC(Layout)P(1)121@4798L23,124@4949L333:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, then);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                Modifier modifier3 = companion;
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
                Composer m3855constructorimpl = Updater.m3855constructorimpl(startRestartGroup);
                Updater.m3862setimpl(m3855constructorimpl, useMinConstraintsMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3862setimpl(m3855constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.m3862setimpl(m3855constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3855constructorimpl.getInserting() || !Intrinsics.areEqual(m3855constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m3855constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m3855constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier2 = companion;
            }
            final Painter painter2 = asyncImagePainter;
            final String str2 = obj;
            final Alignment alignment2 = obj2;
            final ContentScale contentScale2 = obj3;
            final float f3 = f2;
            final ColorFilter colorFilter2 = obj4;
            final boolean z3 = z2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: coil3.compose.SubcomposeAsyncImageKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj5, Object obj6) {
                        Unit SubcomposeAsyncImageContent$lambda$3;
                        SubcomposeAsyncImageContent$lambda$3 = SubcomposeAsyncImageKt.SubcomposeAsyncImageContent$lambda$3(SubcomposeAsyncImageScope.this, modifier2, painter2, str2, alignment2, contentScale2, f3, colorFilter2, z3, i, i2, (Composer) obj5, ((Integer) obj6).intValue());
                        return SubcomposeAsyncImageContent$lambda$3;
                    }
                });
                return;
            }
            return;
        }
        companion = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        if ((12582912 & i) != 0) {
        }
        if ((100663296 & i) != 0) {
        }
        if (!startRestartGroup.shouldExecute((38347923 & i3) == 38347922, i3 & 1)) {
        }
        final Painter painter22 = asyncImagePainter;
        final String str22 = obj;
        final Alignment alignment22 = obj2;
        final ContentScale contentScale22 = obj3;
        final float f32 = f2;
        final ColorFilter colorFilter22 = obj4;
        final boolean z32 = z2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> contentOf(final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function42, final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function43) {
        return (function4 == null && function42 == null && function43 == null) ? ComposableSingletons$SubcomposeAsyncImageKt.INSTANCE.getLambda$1938077476$coil_compose_core_release() : ComposableLambdaKt.composableLambdaInstance(-1106738291, true, new Function3() { // from class: coil3.compose.SubcomposeAsyncImageKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit contentOf$lambda$7;
                contentOf$lambda$7 = SubcomposeAsyncImageKt.contentOf$lambda$7(Function4.this, function42, function43, (SubcomposeAsyncImageScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return contentOf$lambda$7;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit contentOf$lambda$7(Function4 function4, Function4 function42, Function4 function43, SubcomposeAsyncImageScope subcomposeAsyncImageScope, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "C300@12612L16:SubcomposeAsyncImage.kt#8xxpns");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(subcomposeAsyncImageScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1106738291, i2, -1, "coil3.compose.contentOf.<anonymous> (SubcomposeAsyncImage.kt:299)");
            }
            AsyncImagePainter.State state = (AsyncImagePainter.State) SnapshotStateKt.collectAsState(subcomposeAsyncImageScope.getPainter().getState(), null, composer, 0, 1).getValue();
            if (state instanceof AsyncImagePainter.State.Loading) {
                if (function4 != null) {
                    composer.startReplaceGroup(1576397282);
                    ComposerKt.sourceInformation(composer, "301@12695L14");
                    function4.invoke(subcomposeAsyncImageScope, state, composer, Integer.valueOf(i2 & 14));
                    Unit unit = Unit.INSTANCE;
                    composer.endReplaceGroup();
                    composer.startReplaceGroup(1611065525);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(1611065525);
                    composer.endReplaceGroup();
                    composer.startReplaceGroup(1576407562);
                    ComposerKt.sourceInformation(composer, "306@13031L29");
                    SubcomposeAsyncImageContent(subcomposeAsyncImageScope, null, null, null, null, null, 0.0f, null, false, composer, i2 & 14, 255);
                    composer.endReplaceGroup();
                }
            } else if (!(state instanceof AsyncImagePainter.State.Success)) {
                if (state instanceof AsyncImagePainter.State.Error) {
                    if (function43 == null) {
                        composer.startReplaceGroup(1611065525);
                        composer.endReplaceGroup();
                    } else {
                        composer.startReplaceGroup(1576403106);
                        ComposerKt.sourceInformation(composer, "303@12879L12");
                        function43.invoke(subcomposeAsyncImageScope, state, composer, Integer.valueOf(i2 & 14));
                        Unit unit2 = Unit.INSTANCE;
                        composer.endReplaceGroup();
                        composer.startReplaceGroup(1611065525);
                        composer.endReplaceGroup();
                    }
                } else if (!(state instanceof AsyncImagePainter.State.Empty)) {
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceGroup(1576407562);
                ComposerKt.sourceInformation(composer, "306@13031L29");
                SubcomposeAsyncImageContent(subcomposeAsyncImageScope, null, null, null, null, null, 0.0f, null, false, composer, i2 & 14, 255);
                composer.endReplaceGroup();
            } else if (function42 != null) {
                composer.startReplaceGroup(1576400290);
                ComposerKt.sourceInformation(composer, "302@12789L14");
                function42.invoke(subcomposeAsyncImageScope, state, composer, Integer.valueOf(i2 & 14));
                Unit unit3 = Unit.INSTANCE;
                composer.endReplaceGroup();
                composer.startReplaceGroup(1611065525);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1611065525);
                composer.endReplaceGroup();
                composer.startReplaceGroup(1576407562);
                ComposerKt.sourceInformation(composer, "306@13031L29");
                SubcomposeAsyncImageContent(subcomposeAsyncImageScope, null, null, null, null, null, 0.0f, null, false, composer, i2 & 14, 255);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
