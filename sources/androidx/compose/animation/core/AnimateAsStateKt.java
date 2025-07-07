package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
/* compiled from: AnimateAsState.kt */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aH\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aR\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001aM\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\b\b\u0002\u0010 \u001a\u00020\u00022\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010!\u001aW\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010\"\u001aC\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010$\u001aM\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010%\u001aH\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u0013\u001a\u00020\b2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001aR\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u0013\u001a\u00020\b2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001aH\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u0013\u001a\u00020\n2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010(\u001aR\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u0013\u001a\u00020\n2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010*\u001aH\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\u0006\u0010\u0013\u001a\u00020\f2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010(\u001aR\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\u0006\u0010\u0013\u001a\u00020\f2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u0010*\u001aC\u00101\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u00102\u001aM\u00101\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u00103\u001aH\u00104\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b5\u0010(\u001aR\u00104\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b6\u0010*\u001as\u00107\u001a\b\u0012\u0004\u0012\u0002H80\u0012\"\u0004\b\u0000\u00108\"\b\b\u0001\u00109*\u00020:2\u0006\u0010\u0013\u001a\u0002H82\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H90<2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H80\u00152\n\b\u0002\u0010 \u001a\u0004\u0018\u0001H82\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010=\u001a}\u00107\u001a\b\u0012\u0004\u0012\u0002H80\u0012\"\u0004\b\u0000\u00108\"\b\b\u0001\u00109*\u00020:2\u0006\u0010\u0013\u001a\u0002H82\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H90<2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H80\u00152\n\b\u0002\u0010 \u001a\u0004\u0018\u0001H82\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010>\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006?²\u0006(\u0010@\u001a\u0010\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\"\u0004\b\u0000\u00108\"\b\b\u0001\u00109*\u00020:X\u008a\u0084\u0002²\u0006 \u0010A\u001a\b\u0012\u0004\u0012\u0002H80\u0015\"\u0004\b\u0000\u00108\"\b\b\u0001\u00109*\u00020:X\u008a\u0084\u0002"}, d2 = {"defaultAnimation", "Landroidx/compose/animation/core/SpringSpec;", "", "dpDefaultSpring", "Landroidx/compose/ui/unit/Dp;", "intDefaultSpring", "", "intOffsetDefaultSpring", "Landroidx/compose/ui/unit/IntOffset;", "intSizeDefaultSpring", "Landroidx/compose/ui/unit/IntSize;", "offsetDefaultSpring", "Landroidx/compose/ui/geometry/Offset;", "rectDefaultSpring", "Landroidx/compose/ui/geometry/Rect;", "sizeDefaultSpring", "Landroidx/compose/ui/geometry/Size;", "animateDpAsState", "Landroidx/compose/runtime/State;", "targetValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "finishedListener", "Lkotlin/Function1;", "", "animateDpAsState-Kz89ssw", "(FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", Constants.ScionAnalytics.PARAM_LABEL, "", "animateDpAsState-AjpBEmI", "(FLandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateFloatAsState", "visibilityThreshold", "(FLandroidx/compose/animation/core/AnimationSpec;FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(FLandroidx/compose/animation/core/AnimationSpec;FLjava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntAsState", "(ILandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(ILandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntOffsetAsState", "animateIntOffsetAsState-8f6pmRE", "(JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntOffsetAsState-HyPO7BM", "(JLandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntSizeAsState", "animateIntSizeAsState-zTRF_AQ", "animateIntSizeAsState-4goxYXU", "animateOffsetAsState", "animateOffsetAsState-N6fFfp4", "animateOffsetAsState-7362WCg", "animateRectAsState", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateSizeAsState", "animateSizeAsState-LjSzlW0", "animateSizeAsState-YLp_XPw", "animateValueAsState", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animation-core_release", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "animSpec"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnimateAsStateKt {
    private static final SpringSpec<Float> defaultAnimation = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
    private static final SpringSpec<Dp> dpDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Dp.m6682boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Dp.Companion)), 3, null);
    private static final SpringSpec<Size> sizeDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Size.m3894boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Size.Companion)), 3, null);
    private static final SpringSpec<Offset> offsetDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Offset.m3826boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Offset.Companion)), 3, null);
    private static final SpringSpec<Rect> rectDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.Companion), 3, null);
    private static final SpringSpec<Integer> intDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Integer.valueOf(VisibilityThresholdsKt.getVisibilityThreshold(IntCompanionObject.INSTANCE)), 3, null);
    private static final SpringSpec<IntOffset> intOffsetDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m6803boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, null);
    private static final SpringSpec<IntSize> intSizeDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, IntSize.m6847boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 3, null);

    public static final State<Float> animateFloatAsState(float f, AnimationSpec<Float> animationSpec, float f2, String str, Function1<? super Float, Unit> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 668842840, "C(animateFloatAsState)P(3!1,4,2)74@3328L173:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = defaultAnimation;
        }
        if ((i2 & 4) != 0) {
            f2 = 0.01f;
        }
        if ((i2 & 8) != 0) {
            str = "FloatAnimation";
        }
        String str2 = str;
        Function1<? super Float, Unit> function12 = (i2 & 16) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(668842840, i, -1, "androidx.compose.animation.core.animateFloatAsState (AnimateAsState.kt:67)");
        }
        if (animationSpec == defaultAnimation) {
            composer.startReplaceGroup(1125558999);
            ComposerKt.sourceInformation(composer, "70@3180L83");
            ComposerKt.sourceInformationMarkerStart(composer, 313403443, "CC(remember):AnimateAsState.kt#9igjgp");
            boolean z = (((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(f2)) || (i & RendererCapabilities.DECODER_SUPPORT_MASK) == 256;
            Object rememberedValue = composer.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = AnimationSpecKt.spring$default(0.0f, 0.0f, Float.valueOf(f2), 3, null);
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
            animationSpec = (SpringSpec) rememberedValue;
        } else {
            composer.startReplaceGroup(1125668925);
            composer.endReplaceGroup();
        }
        Float valueOf = Float.valueOf(f);
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        Float valueOf2 = Float.valueOf(f2);
        int i3 = i << 3;
        State<Float> animateValueAsState = animateValueAsState(valueOf, vectorConverter, animationSpec, valueOf2, str2, function12, composer, (i & 14) | (i3 & 7168) | (57344 & i3) | (i3 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return animateValueAsState;
    }

    /* renamed from: animateDpAsState-AjpBEmI  reason: not valid java name */
    public static final State<Dp> m136animateDpAsStateAjpBEmI(float f, AnimationSpec<Dp> animationSpec, String str, Function1<? super Dp, Unit> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1407150062, "C(animateDpAsState)P(3:c#ui.unit.Dp!1,2)112@5028L165:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = dpDefaultSpring;
        }
        AnimationSpec<Dp> animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            str = "DpAnimation";
        }
        String str2 = str;
        if ((i2 & 8) != 0) {
            function1 = null;
        }
        Function1<? super Dp, Unit> function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1407150062, i, -1, "androidx.compose.animation.core.animateDpAsState (AnimateAsState.kt:111)");
        }
        int i3 = i << 6;
        State<Dp> animateValueAsState = animateValueAsState(Dp.m6682boximpl(f), VectorConvertersKt.getVectorConverter(Dp.Companion), animationSpec2, null, str2, function12, composer, (i & 14) | ((i << 3) & 896) | (57344 & i3) | (i3 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return animateValueAsState;
    }

    /* renamed from: animateSizeAsState-YLp_XPw  reason: not valid java name */
    public static final State<Size> m145animateSizeAsStateYLp_XPw(long j, AnimationSpec<Size> animationSpec, String str, Function1<? super Size, Unit> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1374633148, "C(animateSizeAsState)P(3:c#ui.geometry.Size!1,2)153@6865L167:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = sizeDefaultSpring;
        }
        AnimationSpec<Size> animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            str = "SizeAnimation";
        }
        String str2 = str;
        Function1<? super Size, Unit> function12 = (i2 & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1374633148, i, -1, "androidx.compose.animation.core.animateSizeAsState (AnimateAsState.kt:152)");
        }
        int i3 = i << 6;
        State<Size> animateValueAsState = animateValueAsState(Size.m3894boximpl(j), VectorConvertersKt.getVectorConverter(Size.Companion), animationSpec2, null, str2, function12, composer, (i & 14) | ((i << 3) & 896) | (57344 & i3) | (i3 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return animateValueAsState;
    }

    /* renamed from: animateOffsetAsState-7362WCg  reason: not valid java name */
    public static final State<Offset> m142animateOffsetAsState7362WCg(long j, AnimationSpec<Offset> animationSpec, String str, Function1<? super Offset, Unit> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 357896800, "C(animateOffsetAsState)P(3:c#ui.geometry.Offset!1,2)192@8685L169:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = offsetDefaultSpring;
        }
        AnimationSpec<Offset> animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            str = "OffsetAnimation";
        }
        String str2 = str;
        Function1<? super Offset, Unit> function12 = (i2 & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(357896800, i, -1, "androidx.compose.animation.core.animateOffsetAsState (AnimateAsState.kt:191)");
        }
        int i3 = i << 6;
        State<Offset> animateValueAsState = animateValueAsState(Offset.m3826boximpl(j), VectorConvertersKt.getVectorConverter(Offset.Companion), animationSpec2, null, str2, function12, composer, (i & 14) | ((i << 3) & 896) | (57344 & i3) | (i3 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return animateValueAsState;
    }

    public static final State<Rect> animateRectAsState(Rect rect, AnimationSpec<Rect> animationSpec, String str, Function1<? super Rect, Unit> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 536062978, "C(animateRectAsState)P(3!1,2)233@10537L167:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = rectDefaultSpring;
        }
        AnimationSpec<Rect> animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            str = "RectAnimation";
        }
        String str2 = str;
        if ((i2 & 8) != 0) {
            function1 = null;
        }
        Function1<? super Rect, Unit> function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(536062978, i, -1, "androidx.compose.animation.core.animateRectAsState (AnimateAsState.kt:232)");
        }
        int i3 = i << 6;
        State<Rect> animateValueAsState = animateValueAsState(rect, VectorConvertersKt.getVectorConverter(Rect.Companion), animationSpec2, null, str2, function12, composer, (i & 14) | ((i << 3) & 896) | (57344 & i3) | (i3 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return animateValueAsState;
    }

    public static final State<Integer> animateIntAsState(int i, AnimationSpec<Integer> animationSpec, String str, Function1<? super Integer, Unit> function1, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 428074472, "C(animateIntAsState)P(3!1,2)271@12257L166:AnimateAsState.kt#pdpnli");
        if ((i3 & 2) != 0) {
            animationSpec = intDefaultSpring;
        }
        AnimationSpec<Integer> animationSpec2 = animationSpec;
        if ((i3 & 4) != 0) {
            str = "IntAnimation";
        }
        String str2 = str;
        if ((i3 & 8) != 0) {
            function1 = null;
        }
        Function1<? super Integer, Unit> function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(428074472, i2, -1, "androidx.compose.animation.core.animateIntAsState (AnimateAsState.kt:270)");
        }
        int i4 = i2 << 6;
        State<Integer> animateValueAsState = animateValueAsState(Integer.valueOf(i), VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), animationSpec2, null, str2, function12, composer, (i2 & 14) | ((i2 << 3) & 896) | (57344 & i4) | (i4 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return animateValueAsState;
    }

    /* renamed from: animateIntOffsetAsState-HyPO7BM  reason: not valid java name */
    public static final State<IntOffset> m139animateIntOffsetAsStateHyPO7BM(long j, AnimationSpec<IntOffset> animationSpec, String str, Function1<? super IntOffset, Unit> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -696782904, "C(animateIntOffsetAsState)P(3:c#ui.unit.IntOffset!1,2)310@14105L172:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = intOffsetDefaultSpring;
        }
        AnimationSpec<IntOffset> animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            str = "IntOffsetAnimation";
        }
        String str2 = str;
        Function1<? super IntOffset, Unit> function12 = (i2 & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-696782904, i, -1, "androidx.compose.animation.core.animateIntOffsetAsState (AnimateAsState.kt:309)");
        }
        int i3 = i << 6;
        State<IntOffset> animateValueAsState = animateValueAsState(IntOffset.m6803boximpl(j), VectorConvertersKt.getVectorConverter(IntOffset.Companion), animationSpec2, null, str2, function12, composer, (i & 14) | ((i << 3) & 896) | (57344 & i3) | (i3 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return animateValueAsState;
    }

    /* renamed from: animateIntSizeAsState-4goxYXU  reason: not valid java name */
    public static final State<IntSize> m140animateIntSizeAsState4goxYXU(long j, AnimationSpec<IntSize> animationSpec, String str, Function1<? super IntSize, Unit> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 582576328, "C(animateIntSizeAsState)P(3:c#ui.unit.IntSize!1,2)348@15880L170:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = intSizeDefaultSpring;
        }
        AnimationSpec<IntSize> animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            str = "IntSizeAnimation";
        }
        String str2 = str;
        Function1<? super IntSize, Unit> function12 = (i2 & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(582576328, i, -1, "androidx.compose.animation.core.animateIntSizeAsState (AnimateAsState.kt:347)");
        }
        int i3 = i << 6;
        State<IntSize> animateValueAsState = animateValueAsState(IntSize.m6847boximpl(j), VectorConvertersKt.getVectorConverter(IntSize.Companion), animationSpec2, null, str2, function12, composer, (i & 14) | ((i << 3) & 896) | (57344 & i3) | (i3 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return animateValueAsState;
    }

    public static final <T, V extends AnimationVector> State<T> animateValueAsState(final T t, TwoWayConverter<T, V> twoWayConverter, AnimationSpec<T> animationSpec, T t2, String str, Function1<? super T, Unit> function1, Composer composer, int i, int i2) {
        SpringSpec springSpec;
        Channel channel;
        ComposerKt.sourceInformationMarkerStart(composer, -1994373980, "C(animateValueAsState)P(3,4!1,5,2)391@17983L21,397@18165L44,398@18231L79,399@18331L38,401@18416L428,414@18863L42,415@18921L32,415@18910L43,416@18982L697,416@18958L721:AnimateAsState.kt#pdpnli");
        if ((i2 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 728505056, "CC(remember):AnimateAsState.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            springSpec = (SpringSpec) rememberedValue;
        } else {
            springSpec = animationSpec;
        }
        T t3 = (i2 & 8) != 0 ? null : t2;
        String str2 = (i2 & 16) != 0 ? "ValueAnimation" : str;
        Function1<? super T, Unit> function12 = (i2 & 32) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1994373980, i, -1, "androidx.compose.animation.core.animateValueAsState (AnimateAsState.kt:395)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 728510903, "CC(remember):AnimateAsState.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        MutableState mutableState = (MutableState) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 728513050, "CC(remember):AnimateAsState.kt#9igjgp");
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new Animatable(t, twoWayConverter, t3, str2);
            composer.updateRememberedValue(rememberedValue3);
        }
        Animatable animatable = (Animatable) rememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function12, composer, (i >> 15) & 14);
        if (t3 != null && (springSpec instanceof SpringSpec)) {
            SpringSpec springSpec2 = (SpringSpec) springSpec;
            if (!Intrinsics.areEqual(springSpec2.getVisibilityThreshold(), t3)) {
                springSpec = AnimationSpecKt.spring(springSpec2.getDampingRatio(), springSpec2.getStiffness(), t3);
            }
        }
        State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(springSpec, composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, 728533237, "CC(remember):AnimateAsState.kt#9igjgp");
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == Composer.Companion.getEmpty()) {
            rememberedValue4 = ChannelKt.Channel$default(-1, null, null, 6, null);
            composer.updateRememberedValue(rememberedValue4);
        }
        final Channel channel2 = (Channel) rememberedValue4;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 728535083, "CC(remember):AnimateAsState.kt#9igjgp");
        boolean changedInstance = ((((i & 14) ^ 6) > 4 && composer.changedInstance(t)) || (i & 6) == 4) | composer.changedInstance(channel2);
        Object rememberedValue5 = composer.rememberedValue();
        if (changedInstance || rememberedValue5 == Composer.Companion.getEmpty()) {
            rememberedValue5 = (Function0) new Function0<Unit>() { // from class: androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    channel2.mo7544trySendJP2dKIU(t);
                }
            };
            composer.updateRememberedValue(rememberedValue5);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.SideEffect((Function0) rememberedValue5, composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, 728537700, "CC(remember):AnimateAsState.kt#9igjgp");
        boolean changedInstance2 = composer.changedInstance(channel2) | composer.changedInstance(animatable) | composer.changed(rememberUpdatedState2) | composer.changed(rememberUpdatedState);
        Object rememberedValue6 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue6 == Composer.Companion.getEmpty()) {
            channel = channel2;
            rememberedValue6 = (Function2) new AnimateAsStateKt$animateValueAsState$3$1(channel, animatable, rememberUpdatedState2, rememberUpdatedState, null);
            composer.updateRememberedValue(rememberedValue6);
        } else {
            channel = channel2;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(channel, (Function2) rememberedValue6, composer, 0);
        State<T> state = (State) mutableState.getValue();
        if (state == null) {
            state = animatable.asState();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return state;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateFloatAsState(float f, AnimationSpec animationSpec, float f2, Function1 function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1091643291, "C(animateFloatAsState)P(2!1,3)446@20095L143:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = defaultAnimation;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            f2 = 0.01f;
        }
        float f3 = f2;
        if ((i2 & 8) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1091643291, i, -1, "androidx.compose.animation.core.animateFloatAsState (AnimateAsState.kt:446)");
        }
        State<Float> animateFloatAsState = animateFloatAsState(f, animationSpec2, f3, null, function12, composer, (i & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i << 3) & 57344), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return animateFloatAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* renamed from: animateDpAsState-Kz89ssw  reason: not valid java name */
    public static final /* synthetic */ State m137animateDpAsStateKz89ssw(float f, AnimationSpec animationSpec, Function1 function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 704104481, "C(animateDpAsState)P(2:c#ui.unit.Dp)463@20546L142:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = dpDefaultSpring;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(704104481, i, -1, "androidx.compose.animation.core.animateDpAsState (AnimateAsState.kt:462)");
        }
        State animateValueAsState = animateValueAsState(Dp.m6682boximpl(f), VectorConvertersKt.getVectorConverter(Dp.Companion), animationSpec2, null, null, function12, composer, (i & 14) | ((i << 3) & 896) | ((i << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return animateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* renamed from: animateSizeAsState-LjSzlW0  reason: not valid java name */
    public static final /* synthetic */ State m144animateSizeAsStateLjSzlW0(long j, AnimationSpec animationSpec, Function1 function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 875212471, "C(animateSizeAsState)P(2:c#ui.geometry.Size)481@21010L144:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = sizeDefaultSpring;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(875212471, i, -1, "androidx.compose.animation.core.animateSizeAsState (AnimateAsState.kt:480)");
        }
        State animateValueAsState = animateValueAsState(Size.m3894boximpl(j), VectorConvertersKt.getVectorConverter(Size.Companion), animationSpec2, null, null, function12, composer, (i & 14) | ((i << 3) & 896) | ((i << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return animateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* renamed from: animateOffsetAsState-N6fFfp4  reason: not valid java name */
    public static final /* synthetic */ State m143animateOffsetAsStateN6fFfp4(long j, AnimationSpec animationSpec, Function1 function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -456513133, "C(animateOffsetAsState)P(2:c#ui.geometry.Offset)499@21488L146:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = offsetDefaultSpring;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-456513133, i, -1, "androidx.compose.animation.core.animateOffsetAsState (AnimateAsState.kt:498)");
        }
        State animateValueAsState = animateValueAsState(Offset.m3826boximpl(j), VectorConvertersKt.getVectorConverter(Offset.Companion), animationSpec2, null, null, function12, composer, (i & 14) | ((i << 3) & 896) | ((i << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return animateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateRectAsState(Rect rect, AnimationSpec animationSpec, Function1 function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -782613967, "C(animateRectAsState)P(2)517@21956L144:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = rectDefaultSpring;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-782613967, i, -1, "androidx.compose.animation.core.animateRectAsState (AnimateAsState.kt:516)");
        }
        State animateValueAsState = animateValueAsState(rect, VectorConvertersKt.getVectorConverter(Rect.Companion), animationSpec2, null, null, function12, composer, (i & 14) | ((i << 3) & 896) | ((i << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return animateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateIntAsState(int i, AnimationSpec animationSpec, Function1 function1, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -842612981, "C(animateIntAsState)P(2)535@22416L143:AnimateAsState.kt#pdpnli");
        if ((i3 & 2) != 0) {
            animationSpec = intDefaultSpring;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-842612981, i2, -1, "androidx.compose.animation.core.animateIntAsState (AnimateAsState.kt:534)");
        }
        State animateValueAsState = animateValueAsState(Integer.valueOf(i), VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), animationSpec2, null, null, function12, composer, (i2 & 14) | ((i2 << 3) & 896) | ((i2 << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return animateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* renamed from: animateIntOffsetAsState-8f6pmRE  reason: not valid java name */
    public static final /* synthetic */ State m138animateIntOffsetAsState8f6pmRE(long j, AnimationSpec animationSpec, Function1 function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1010307371, "C(animateIntOffsetAsState)P(2:c#ui.unit.IntOffset)553@22911L149:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = intOffsetDefaultSpring;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1010307371, i, -1, "androidx.compose.animation.core.animateIntOffsetAsState (AnimateAsState.kt:552)");
        }
        State animateValueAsState = animateValueAsState(IntOffset.m6803boximpl(j), VectorConvertersKt.getVectorConverter(IntOffset.Companion), animationSpec2, null, null, function12, composer, (i & 14) | ((i << 3) & 896) | ((i << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return animateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* renamed from: animateIntSizeAsState-zTRF_AQ  reason: not valid java name */
    public static final /* synthetic */ State m141animateIntSizeAsStatezTRF_AQ(long j, AnimationSpec animationSpec, Function1 function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1749239765, "C(animateIntSizeAsState)P(2:c#ui.unit.IntSize)571@23400L147:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = intSizeDefaultSpring;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1749239765, i, -1, "androidx.compose.animation.core.animateIntSizeAsState (AnimateAsState.kt:570)");
        }
        State animateValueAsState = animateValueAsState(IntSize.m6847boximpl(j), VectorConvertersKt.getVectorConverter(IntSize.Companion), animationSpec2, null, null, function12, composer, (i & 14) | ((i << 3) & 896) | ((i << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return animateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateValueAsState(Object obj, TwoWayConverter twoWayConverter, AnimationSpec animationSpec, Object obj2, Function1 function1, Composer composer, int i, int i2) {
        SpringSpec springSpec;
        ComposerKt.sourceInformationMarkerStart(composer, -846382129, "C(animateValueAsState)P(2,3!1,4)587@23837L21,591@23958L268:AnimateAsState.kt#pdpnli");
        if ((i2 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 728692384, "CC(remember):AnimateAsState.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            springSpec = (SpringSpec) rememberedValue;
        } else {
            springSpec = animationSpec;
        }
        Object obj3 = (i2 & 8) != 0 ? null : obj2;
        Function1 function12 = (i2 & 16) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-846382129, i, -1, "androidx.compose.animation.core.animateValueAsState (AnimateAsState.kt:591)");
        }
        int i3 = i & 8;
        State animateValueAsState = animateValueAsState(obj, twoWayConverter, springSpec, obj3, "ValueAnimation", function12, composer, (i3 << 9) | i3 | 24576 | (i & 14) | (i & 112) | (i & 896) | (i & 7168) | ((i << 3) & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return animateValueAsState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Function1<T, Unit> animateValueAsState$lambda$4(State<? extends Function1<? super T, Unit>> state) {
        return (Function1) ((Function1<? super T, Unit>) state.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> AnimationSpec<T> animateValueAsState$lambda$6(State<? extends AnimationSpec<T>> state) {
        return state.getValue();
    }
}
