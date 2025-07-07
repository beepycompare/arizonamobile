package androidx.constraintlayout.compose;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.constraintlayout.compose.Dimension;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: ConstraintLayout.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001af\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0010\b\n\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00182\u001e\b\u0004\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000f0\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001dH\u0087\b¢\u0006\u0002\u0010\u001e\u001an\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u001f\u001a\u00020\u00012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0010\b\n\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00182\u001e\b\u0004\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000f0\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001dH\u0087\b¢\u0006\u0002\u0010!\u001ac\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0010\b\n\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00182\u0013\b\u0004\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000f0\u0018¢\u0006\u0002\b\u001cH\u0087\b¢\u0006\u0002\u0010$\u001ak\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u001f\u001a\u00020\u00012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0010\b\n\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00182\u0013\b\u0004\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000f0\u0018¢\u0006\u0002\b\u001cH\u0087\b¢\u0006\u0002\u0010%\u001a'\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020#2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u000f0\u001a¢\u0006\u0002\b\u001d\u001a\u0018\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020#2\b\b\u0001\u0010*\u001a\u00020+\u001a\u001f\u0010&\u001a\u00020#2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u000f0\u001a¢\u0006\u0002\b\u001d\u001a\u0010\u0010&\u001a\u00020#2\b\b\u0001\u0010*\u001a\u00020+\u001a#\u0010&\u001a\u00020#2\b\b\u0001\u0010\u0019\u001a\u00020+2\n\b\u0003\u0010,\u001a\u0004\u0018\u00010+H\u0007¢\u0006\u0002\u0010-\u001a\u001e\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u0002002\f\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0000\u001a\b\u00104\u001a\u000205H\u0000\u001a\u001c\u00106\u001a\u00020\u0003*\u00020\u00042\u0006\u00107\u001a\u000208ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a\u001c\u00106\u001a\u00020\u0007*\u00020\b2\u0006\u00107\u001a\u000208ø\u0001\u0000¢\u0006\u0004\b9\u0010;\u001a\u001e\u0010\u0002\u001a\u00020\u0007*\u00020\b2\u0006\u00107\u001a\u000208H\u0007ø\u0001\u0000¢\u0006\u0004\b<\u0010;\u001a\u001c\u0010=\u001a\u00020\b*\u00020\u00042\u0006\u00107\u001a\u000208ø\u0001\u0000¢\u0006\u0004\b>\u0010?\u001a\u001c\u0010=\u001a\u00020\u0007*\u00020\u00032\u0006\u00107\u001a\u000208ø\u0001\u0000¢\u0006\u0004\b>\u0010@\u001a0\u0010A\u001a\u00020\u000f*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\b\b\u0002\u0010G\u001a\u00020HH\u0000ø\u0001\u0000¢\u0006\u0004\bI\u0010J\u001a\f\u0010K\u001a\u00020+*\u00020LH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0015\u0010\u0002\u001a\u00020\u0007*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\t\"\u0015\u0010\n\u001a\u00020\b*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0015\u0010\n\u001a\u00020\u0007*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\r*\f\b\u0000\u0010M\"\u00020N2\u00020N*\f\b\u0000\u0010O\"\u00020P2\u00020P\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Q²\u0006\n\u0010R\u001a\u00020#X\u008a\u008e\u0002²\u0006\n\u0010S\u001a\u00020#X\u008a\u008e\u0002"}, d2 = {"DEBUG", "", "atLeastWrapContent", "Landroidx/constraintlayout/compose/Dimension$MaxCoercible;", "Landroidx/constraintlayout/compose/Dimension$Coercible;", "getAtLeastWrapContent", "(Landroidx/constraintlayout/compose/Dimension$Coercible;)Landroidx/constraintlayout/compose/Dimension$MaxCoercible;", "Landroidx/constraintlayout/compose/Dimension;", "Landroidx/constraintlayout/compose/Dimension$MinCoercible;", "(Landroidx/constraintlayout/compose/Dimension$MinCoercible;)Landroidx/constraintlayout/compose/Dimension;", "atMostWrapContent", "getAtMostWrapContent", "(Landroidx/constraintlayout/compose/Dimension$Coercible;)Landroidx/constraintlayout/compose/Dimension$MinCoercible;", "(Landroidx/constraintlayout/compose/Dimension$MaxCoercible;)Landroidx/constraintlayout/compose/Dimension;", "ConstraintLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "optimizationLevel", "", "animateChangesSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "finishedAnimationListener", "Lkotlin/Function0;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/ConstraintLayoutScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;ILandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animateChanges", "animationSpec", "(Landroidx/compose/ui/Modifier;IZLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "constraintSet", "Landroidx/constraintlayout/compose/ConstraintSet;", "(Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/compose/ui/Modifier;ILandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/compose/ui/Modifier;IZLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ConstraintSet", "extendConstraintSet", "description", "Landroidx/constraintlayout/compose/ConstraintSetScope;", "jsonContent", "", "overrideVariables", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/constraintlayout/compose/ConstraintSet;", "buildMapping", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/constraintlayout/compose/State;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "createId", "", "atLeast", "dp", "Landroidx/compose/ui/unit/Dp;", "atLeast-3ABfNKs", "(Landroidx/constraintlayout/compose/Dimension$Coercible;F)Landroidx/constraintlayout/compose/Dimension$MaxCoercible;", "(Landroidx/constraintlayout/compose/Dimension$MinCoercible;F)Landroidx/constraintlayout/compose/Dimension;", "atLeastWrapContent-3ABfNKs", "atMost", "atMost-3ABfNKs", "(Landroidx/constraintlayout/compose/Dimension$Coercible;F)Landroidx/constraintlayout/compose/Dimension$MinCoercible;", "(Landroidx/constraintlayout/compose/Dimension$MaxCoercible;F)Landroidx/constraintlayout/compose/Dimension;", "placeWithFrameTransform", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placeable", "Landroidx/compose/ui/layout/Placeable;", TypedValues.AttributesType.S_FRAME, "Landroidx/constraintlayout/core/state/WidgetFrame;", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/unit/IntOffset;", "placeWithFrameTransform-Ktjjmr4", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;Landroidx/compose/ui/layout/Placeable;Landroidx/constraintlayout/core/state/WidgetFrame;J)V", "toDebugString", "Landroidx/constraintlayout/core/widgets/ConstraintWidget;", "SolverDimension", "Landroidx/constraintlayout/core/state/Dimension;", "SolverState", "Landroidx/constraintlayout/core/state/State;", "constraintlayout-compose_release", "startConstraint", "endConstraint"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConstraintLayoutKt {
    private static final boolean DEBUG = false;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r26v0, types: [androidx.compose.runtime.Composer] */
    public static final void ConstraintLayout(Modifier modifier, int i, AnimationSpec<Float> animationSpec, Function0<Unit> function0, Function3<? super ConstraintLayoutScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i2, int i3) {
        composer.startReplaceGroup(-1003410150);
        ComposerKt.sourceInformation(composer, "CC(ConstraintLayout)P(3,4!1,2)414@18758L7,415@18785L31,416@18833L36,417@18904L34,418@18963L45,419@19034L53,421@19113L1030,445@20172L288,454@20553L33,456@20645L729,453@20495L885:ConstraintLayout.kt#fysre8");
        Modifier.Companion companion = (i3 & 1) != 0 ? Modifier.Companion : modifier;
        int i4 = (i3 & 2) != 0 ? 257 : i;
        AnimationSpec<Float> animationSpec2 = (i3 & 4) != 0 ? null : animationSpec;
        Function0<Unit> function02 = (i3 & 8) != 0 ? null : function0;
        composer.startReplaceGroup(212064437);
        ComposerKt.sourceInformation(composer, "359@16265L33,360@16347L33,361@16401L70,362@16501L53,363@16587L101,366@16711L54,368@16821L1432,399@18263L441");
        if (animationSpec2 != null) {
            ComposerKt.sourceInformationMarkerStart(composer, 212064614, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composer.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212067238, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composer.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState2 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212069003, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            ConstraintLayoutScope constraintLayoutScope = rememberedValue3;
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                ConstraintLayoutScope constraintLayoutScope2 = new ConstraintLayoutScope();
                constraintLayoutScope2.setAnimateChanges(true);
                composer.updateRememberedValue(constraintLayoutScope2);
                constraintLayoutScope = constraintLayoutScope2;
            }
            ConstraintLayoutScope constraintLayoutScope3 = (ConstraintLayoutScope) constraintLayoutScope;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212072186, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue4 = composer.rememberedValue();
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                composer.updateRememberedValue(rememberedValue4);
            }
            MutableState mutableState3 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212074986, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue5 = composer.rememberedValue();
            Ref ref = rememberedValue5;
            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                Ref ref2 = new Ref();
                ref2.setValue(CompositionSource.Unknown);
                composer.updateRememberedValue(ref2);
                ref = ref2;
            }
            Ref ref3 = (Ref) ref;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212078907, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue6 = composer.rememberedValue();
            if (rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = ChannelKt.Channel$default(-1, null, null, 6, null);
                composer.updateRememberedValue(rememberedValue6);
            }
            Channel channel = (Channel) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composer);
            LateMotionLayoutKt.LateMotionLayout(mutableState, mutableState2, animationSpec2, channel, mutableState3, ref3, i4, function02, companion, ComposableLambdaKt.rememberComposableLambda(-74958949, true, new ConstraintLayoutKt$ConstraintLayout$contentDelegate$1(mutableState3, ref3, constraintLayoutScope3, function3, channel, mutableState, mutableState2), composer, 54), composer, (i2 & 896) | 805330998 | (Ref.$stable << 15) | ((i2 << 15) & 3670016) | ((i2 << 12) & 29360128) | ((i2 << 24) & 234881024));
            composer.endReplaceGroup();
            composer.endReplaceGroup();
            return;
        }
        composer.endReplaceGroup();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume;
        ComposerKt.sourceInformationMarkerStart(composer, 212145252, "CC(remember):ConstraintLayout.kt#9igjgp");
        Object rememberedValue7 = composer.rememberedValue();
        if (rememberedValue7 == Composer.Companion.getEmpty()) {
            rememberedValue7 = new Measurer2(density);
            composer.updateRememberedValue(rememberedValue7);
        }
        Measurer2 measurer2 = (Measurer2) rememberedValue7;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 212146793, "CC(remember):ConstraintLayout.kt#9igjgp");
        Object rememberedValue8 = composer.rememberedValue();
        if (rememberedValue8 == Composer.Companion.getEmpty()) {
            rememberedValue8 = new ConstraintLayoutScope();
            composer.updateRememberedValue(rememberedValue8);
        }
        ConstraintLayoutScope constraintLayoutScope4 = (ConstraintLayoutScope) rememberedValue8;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 212149063, "CC(remember):ConstraintLayout.kt#9igjgp");
        Object rememberedValue9 = composer.rememberedValue();
        if (rememberedValue9 == Composer.Companion.getEmpty()) {
            rememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            composer.updateRememberedValue(rememberedValue9);
        }
        MutableState mutableState4 = (MutableState) rememberedValue9;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 212150962, "CC(remember):ConstraintLayout.kt#9igjgp");
        Object rememberedValue10 = composer.rememberedValue();
        if (rememberedValue10 == Composer.Companion.getEmpty()) {
            rememberedValue10 = new ConstraintSetForInlineDsl(constraintLayoutScope4);
            composer.updateRememberedValue(rememberedValue10);
        }
        ConstraintSetForInlineDsl constraintSetForInlineDsl = (ConstraintSetForInlineDsl) rememberedValue10;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 212153242, "CC(remember):ConstraintLayout.kt#9igjgp");
        Object rememberedValue11 = composer.rememberedValue();
        if (rememberedValue11 == Composer.Companion.getEmpty()) {
            rememberedValue11 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
            composer.updateRememberedValue(rememberedValue11);
        }
        MutableState mutableState5 = (MutableState) rememberedValue11;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 212156747, "CC(remember):ConstraintLayout.kt#9igjgp");
        boolean changedInstance = ((((i2 & 112) ^ 48) > 32 && composer.changed(i4)) || (i2 & 48) == 32) | composer.changedInstance(measurer2);
        ConstraintLayoutKt$ConstraintLayout$measurePolicy$1$1 rememberedValue12 = composer.rememberedValue();
        if (changedInstance || rememberedValue12 == Composer.Companion.getEmpty()) {
            rememberedValue12 = new ConstraintLayoutKt$ConstraintLayout$measurePolicy$1$1(mutableState5, measurer2, constraintSetForInlineDsl, i4, mutableState4);
            composer.updateRememberedValue(rememberedValue12);
        }
        MeasurePolicy measurePolicy = rememberedValue12;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 212189893, "CC(remember):ConstraintLayout.kt#9igjgp");
        ConstraintLayoutKt$ConstraintLayout$onHelpersChanged$1$1 rememberedValue13 = composer.rememberedValue();
        if (rememberedValue13 == Composer.Companion.getEmpty()) {
            rememberedValue13 = new ConstraintLayoutKt$ConstraintLayout$onHelpersChanged$1$1(mutableState4, constraintSetForInlineDsl);
            composer.updateRememberedValue(rememberedValue13);
        }
        Function0 function03 = (Function0) rememberedValue13;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 212201830, "CC(remember):ConstraintLayout.kt#9igjgp");
        boolean changedInstance2 = composer.changedInstance(measurer2);
        ConstraintLayoutKt$ConstraintLayout$1$1 rememberedValue14 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue14 == Composer.Companion.getEmpty()) {
            rememberedValue14 = new ConstraintLayoutKt$ConstraintLayout$1$1(measurer2);
            composer.updateRememberedValue(rememberedValue14);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue14, 1, null), ComposableLambdaKt.rememberComposableLambda(1200550679, true, new ConstraintLayoutKt$ConstraintLayout$2(mutableState5, constraintLayoutScope4, function3, function03), composer, 54), measurePolicy, composer, 48, 0);
        composer.endReplaceGroup();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Prefer version that takes a nullable AnimationSpec to animate changes.", replaceWith = @ReplaceWith(expression = "ConstraintLayout(modifier = modifier, optimizationLevel = optimizationLevel, animateChangesSpec = animationSpec, finishedAnimationListener = finishedAnimationListener) { content() }", imports = {}))
    public static final void ConstraintLayout(Modifier modifier, int i, boolean z, AnimationSpec<Float> animationSpec, Function0<Unit> function0, Function3<? super ConstraintLayoutScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i2, int i3) {
        Measurer2 measurer2;
        MutableState mutableState;
        Object obj;
        ComposerKt.sourceInformationMarkerStart(composer, -2033384074, "CC(ConstraintLayout)P(4,5!2,3)495@22248L262:ConstraintLayout.kt#fysre8");
        Modifier.Companion companion = (i3 & 1) != 0 ? Modifier.Companion : modifier;
        int i4 = (i3 & 2) != 0 ? 257 : i;
        boolean z2 = (i3 & 4) != 0 ? false : z;
        TweenSpec tween$default = (i3 & 8) != 0 ? AnimationSpecKt.tween$default(0, 0, null, 7, null) : animationSpec;
        Function0<Unit> function02 = (i3 & 16) != 0 ? null : function0;
        if (!z2) {
            tween$default = null;
        }
        int i5 = i2 >> 3;
        int i6 = (i2 & WebSocketProtocol.PAYLOAD_SHORT) | (i5 & 7168) | (i5 & 57344);
        composer.startReplaceGroup(-1003410150);
        ComposerKt.sourceInformation(composer, "CC(ConstraintLayout)P(3,4!1,2)414@18758L7,415@18785L31,416@18833L36,417@18904L34,418@18963L45,419@19034L53,421@19113L1030,445@20172L288,454@20553L33,456@20645L729,453@20495L885:ConstraintLayout.kt#fysre8");
        composer.startReplaceGroup(212064437);
        ComposerKt.sourceInformation(composer, "359@16265L33,360@16347L33,361@16401L70,362@16501L53,363@16587L101,366@16711L54,368@16821L1432,399@18263L441");
        if (tween$default != null) {
            ComposerKt.sourceInformationMarkerStart(composer, 212064614, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composer.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState2 = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212067238, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composer.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState3 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212069003, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            Object obj2 = rememberedValue3;
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                ConstraintLayoutScope constraintLayoutScope = new ConstraintLayoutScope();
                constraintLayoutScope.setAnimateChanges(true);
                composer.updateRememberedValue(constraintLayoutScope);
                obj2 = constraintLayoutScope;
            }
            ConstraintLayoutScope constraintLayoutScope2 = (ConstraintLayoutScope) obj2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212072186, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue4 = composer.rememberedValue();
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                composer.updateRememberedValue(rememberedValue4);
            }
            MutableState mutableState4 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212074986, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue5 = composer.rememberedValue();
            Object obj3 = rememberedValue5;
            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                Ref ref = new Ref();
                ref.setValue(CompositionSource.Unknown);
                composer.updateRememberedValue(ref);
                obj3 = ref;
            }
            Ref ref2 = (Ref) obj3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212078907, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue6 = composer.rememberedValue();
            if (rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = ChannelKt.Channel$default(-1, null, null, 6, null);
                composer.updateRememberedValue(rememberedValue6);
            }
            Channel channel = (Channel) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composer);
            LateMotionLayoutKt.LateMotionLayout(mutableState2, mutableState3, tween$default, channel, mutableState4, ref2, i4, function02, companion, ComposableLambdaKt.rememberComposableLambda(-74958949, true, new ConstraintLayoutKt$ConstraintLayout$contentDelegate$1(mutableState4, ref2, constraintLayoutScope2, function3, channel, mutableState2, mutableState3), composer, 54), composer, (Ref.$stable << 15) | 805330998 | ((i6 << 15) & 3670016) | ((i6 << 12) & 29360128) | ((i6 << 24) & 234881024));
            composer.endReplaceGroup();
            composer.endReplaceGroup();
        } else {
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(composer, 212145252, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue7 = composer.rememberedValue();
            if (rememberedValue7 == Composer.Companion.getEmpty()) {
                rememberedValue7 = new Measurer2(density);
                composer.updateRememberedValue(rememberedValue7);
            }
            Object obj4 = (Measurer2) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212146793, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue8 = composer.rememberedValue();
            if (rememberedValue8 == Composer.Companion.getEmpty()) {
                rememberedValue8 = new ConstraintLayoutScope();
                composer.updateRememberedValue(rememberedValue8);
            }
            ConstraintLayoutScope constraintLayoutScope3 = (ConstraintLayoutScope) rememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212149063, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue9 = composer.rememberedValue();
            if (rememberedValue9 == Composer.Companion.getEmpty()) {
                rememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composer.updateRememberedValue(rememberedValue9);
            }
            MutableState mutableState5 = (MutableState) rememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212150962, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue10 = composer.rememberedValue();
            if (rememberedValue10 == Composer.Companion.getEmpty()) {
                rememberedValue10 = new ConstraintSetForInlineDsl(constraintLayoutScope3);
                composer.updateRememberedValue(rememberedValue10);
            }
            ConstraintSetForInlineDsl constraintSetForInlineDsl = (ConstraintSetForInlineDsl) rememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212153242, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue11 = composer.rememberedValue();
            if (rememberedValue11 == Composer.Companion.getEmpty()) {
                rememberedValue11 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                composer.updateRememberedValue(rememberedValue11);
            }
            MutableState mutableState6 = (MutableState) rememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212156747, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean changedInstance = ((((i6 & 112) ^ 48) > 32 && composer.changed(i4)) || (i6 & 48) == 32) | composer.changedInstance(obj4);
            Object rememberedValue12 = composer.rememberedValue();
            if (changedInstance || rememberedValue12 == Composer.Companion.getEmpty()) {
                measurer2 = obj4;
                mutableState = mutableState6;
                Object obj5 = (MeasurePolicy) new ConstraintLayoutKt$ConstraintLayout$measurePolicy$1$1(mutableState, measurer2, constraintSetForInlineDsl, i4, mutableState5);
                composer.updateRememberedValue(obj5);
                obj = obj5;
            } else {
                obj = rememberedValue12;
                measurer2 = obj4;
                mutableState = mutableState6;
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) obj;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212189893, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue13 = composer.rememberedValue();
            if (rememberedValue13 == Composer.Companion.getEmpty()) {
                rememberedValue13 = (Function0) new ConstraintLayoutKt$ConstraintLayout$onHelpersChanged$1$1(mutableState5, constraintSetForInlineDsl);
                composer.updateRememberedValue(rememberedValue13);
            }
            Function0 function03 = (Function0) rememberedValue13;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212201830, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean changedInstance2 = composer.changedInstance(measurer2);
            Object rememberedValue14 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue14 == Composer.Companion.getEmpty()) {
                rememberedValue14 = (Function1) new ConstraintLayoutKt$ConstraintLayout$1$1(measurer2);
                composer.updateRememberedValue(rememberedValue14);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue14, 1, null), ComposableLambdaKt.rememberComposableLambda(1200550679, true, new ConstraintLayoutKt$ConstraintLayout$2(mutableState, constraintLayoutScope3, function3, function03), composer, 54), measurePolicy, composer, 48, 0);
            composer.endReplaceGroup();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public static final void ConstraintLayout(ConstraintSet constraintSet, Modifier modifier, int i, AnimationSpec<Float> animationSpec, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i2, int i3) {
        Animatable animatable;
        ComposerKt.sourceInformationMarkerStart(composer, 2055379008, "CC(ConstraintLayout)P(1,4,5!1,3):ConstraintLayout.kt#fysre8");
        Modifier.Companion companion = (i3 & 2) != 0 ? Modifier.Companion : modifier;
        int i4 = (i3 & 4) != 0 ? 257 : i;
        Object obj = (i3 & 8) != 0 ? null : animationSpec;
        Object obj2 = (i3 & 16) != 0 ? null : function0;
        if (obj != null) {
            composer.startReplaceGroup(-2000135165);
            ComposerKt.sourceInformation(composer, "769@32178L42,770@32250L42,771@32316L29,772@32368L54,773@32447L33,775@32501L34,775@32490L45,777@32569L794,777@32545L818,794@33372L201");
            ComposerKt.sourceInformationMarkerStart(composer, 212573839, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(constraintSet, null, 2, null);
                composer.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212576143, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(constraintSet, null, 2, null);
                composer.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState2 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212578242, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                composer.updateRememberedValue(rememberedValue3);
            }
            Object obj3 = (Animatable) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212579931, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue4 = composer.rememberedValue();
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = ChannelKt.Channel$default(-1, null, null, 6, null);
                composer.updateRememberedValue(rememberedValue4);
            }
            Channel channel = (Channel) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212582438, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue5 = composer.rememberedValue();
            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = SnapshotIntStateKt.mutableIntStateOf(1);
                composer.updateRememberedValue(rememberedValue5);
            }
            MutableIntState mutableIntState = (MutableIntState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212584167, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(channel) | (((6 ^ (i2 & 14)) > 4 && composer.changed(constraintSet)) || (i2 & 6) == 4);
            Object rememberedValue6 = composer.rememberedValue();
            if (changedInstance || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = (Function0) new ConstraintLayoutKt$ConstraintLayout$3$1(channel, constraintSet);
                composer.updateRememberedValue(rememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.SideEffect((Function0) rememberedValue6, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 212587103, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean changedInstance2 = composer.changedInstance(channel) | composer.changedInstance(obj3) | composer.changedInstance(obj) | ((((57344 & i2) ^ 24576) > 16384 && composer.changed(obj2)) || (i2 & 24576) == 16384);
            Object rememberedValue7 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue7 == Composer.Companion.getEmpty()) {
                animatable = obj3;
                rememberedValue7 = (Function2) new ConstraintLayoutKt$ConstraintLayout$4$1(channel, mutableIntState, animatable, obj, obj2, mutableState, mutableState2, null);
                composer.updateRememberedValue(rememberedValue7);
            } else {
                animatable = obj3;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.LaunchedEffect(channel, (Function2) rememberedValue7, composer, 0);
            ConstraintSet m7012ConstraintLayout$lambda17 = m7012ConstraintLayout$lambda17(mutableState);
            ConstraintSet m7014ConstraintLayout$lambda20 = m7014ConstraintLayout$lambda20(mutableState2);
            float floatValue = ((Number) animatable.getValue()).floatValue();
            int i5 = (i2 << 6) & 7168;
            ComposerKt.sourceInformationMarkerStart(composer, -531105279, "CC(MotionLayout)P(7,2,6,4,8,1:androidx.constraintlayout.compose.DebugFlags,5,3)145@6151L53,146@6233L93,151@6488L627,166@7120L556:MotionLayout.kt#fysre8");
            int m7040getNonebfy_xzQ = DebugFlags.Companion.m7040getNonebfy_xzQ();
            InvalidationStrategy defaultInvalidationStrategy = InvalidationStrategy.Companion.getDefaultInvalidationStrategy();
            ComposerKt.sourceInformationMarkerStart(composer, 1692702995, "CC(remember):MotionLayout.kt#9igjgp");
            Object rememberedValue8 = composer.rememberedValue();
            if (rememberedValue8 == Composer.Companion.getEmpty()) {
                rememberedValue8 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                composer.updateRememberedValue(rememberedValue8);
            }
            MutableState mutableState3 = (MutableState) rememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1692705659, "CC(remember):MotionLayout.kt#9igjgp");
            Object rememberedValue9 = composer.rememberedValue();
            Object obj4 = rememberedValue9;
            if (rememberedValue9 == Composer.Companion.getEmpty()) {
                Ref ref = new Ref();
                ref.setValue(CompositionSource.Unknown);
                composer.updateRememberedValue(ref);
                obj4 = ref;
            }
            Ref ref2 = (Ref) obj4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            MotionLayoutKt.MotionLayoutCore(m7012ConstraintLayout$lambda17, m7014ConstraintLayout$lambda20, null, floatValue, null, 257, DebugFlags.m7033getShowBoundsimpl(m7040getNonebfy_xzQ), DebugFlags.m7035getShowPathsimpl(m7040getNonebfy_xzQ), DebugFlags.m7034getShowKeyPositionsimpl(m7040getNonebfy_xzQ), companion, mutableState3, ref2, defaultInvalidationStrategy, ComposableLambdaKt.rememberComposableLambda(284503157, true, new ConstraintLayoutKt$ConstraintLayout$$inlined$MotionLayoutT3LJ6Qw$1(mutableState3, defaultInvalidationStrategy, ref2, function2, i2), composer, 54), composer, 24576 | ((i5 << 18) & 1879048192), (Ref.$stable << 3) | 3078);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1998673515);
            ComposerKt.sourceInformation(composer, "802@33613L35,804@33679L53,805@33768L7,806@33799L31,807@33859L914");
            ComposerKt.sourceInformationMarkerStart(composer, 212619752, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue10 = composer.rememberedValue();
            if (rememberedValue10 == Composer.Companion.getEmpty()) {
                rememberedValue10 = SnapshotLongStateKt.mutableLongStateOf(0L);
                composer.updateRememberedValue(rememberedValue10);
            }
            MutableLongState mutableLongState = (MutableLongState) rememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212621882, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue11 = composer.rememberedValue();
            if (rememberedValue11 == Composer.Companion.getEmpty()) {
                rememberedValue11 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                composer.updateRememberedValue(rememberedValue11);
            }
            MutableState mutableState4 = (MutableState) rememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(composer, 212625700, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue12 = composer.rememberedValue();
            if (rememberedValue12 == Composer.Companion.getEmpty()) {
                rememberedValue12 = new Measurer2(density);
                composer.updateRememberedValue(rememberedValue12);
            }
            Measurer2 measurer2 = (Measurer2) rememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212628503, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean changedInstance3 = ((((i2 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(i4)) || (i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | composer.changedInstance(measurer2) | ((((i2 & 14) ^ 6) > 4 && composer.changed(constraintSet)) || (i2 & 6) == 4);
            Object rememberedValue13 = composer.rememberedValue();
            if (changedInstance3 || rememberedValue13 == Composer.Companion.getEmpty()) {
                rememberedValue13 = (MeasurePolicy) new ConstraintLayoutKt$ConstraintLayout$measurePolicy$2$1(mutableState4, measurer2, constraintSet, i4);
                composer.updateRememberedValue(rememberedValue13);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue13;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (constraintSet instanceof EditableJSONLayout) {
                ((EditableJSONLayout) constraintSet).setUpdateFlag(mutableLongState);
            }
            measurer2.addLayoutInformationReceiver(constraintSet instanceof LayoutInformationReceiver ? (LayoutInformationReceiver) constraintSet : null);
            if (!Float.isNaN(measurer2.getForcedScaleFactor())) {
                composer.startReplaceGroup(-1997256040);
                ComposerKt.sourceInformation(composer, "836@35158L332");
                Modifier scale = ScaleKt.scale(companion, measurer2.getForcedScaleFactor());
                ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, Modifier.Companion);
                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer m3520constructorimpl = Updater.m3520constructorimpl(composer);
                Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -2074157001, "C839@35286L33,841@35445L13,838@35221L255:ConstraintLayout.kt#fysre8");
                ComposerKt.sourceInformationMarkerStart(composer, -1729473147, "CC(remember):ConstraintLayout.kt#9igjgp");
                boolean changedInstance4 = composer.changedInstance(measurer2);
                Object rememberedValue14 = composer.rememberedValue();
                if (changedInstance4 || rememberedValue14 == Composer.Companion.getEmpty()) {
                    rememberedValue14 = (Function1) new ConstraintLayoutKt$ConstraintLayout$6$1$1(measurer2);
                    composer.updateRememberedValue(rememberedValue14);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(scale, false, (Function1) rememberedValue14, 1, null), ComposableLambdaKt.rememberComposableLambda(1131308473, true, new ConstraintLayoutKt$ConstraintLayout$6$2(function2), composer, 54), measurePolicy, composer, 48, 0);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1996827620);
                ComposerKt.sourceInformation(composer, "847@35623L33,849@35731L328,846@35557L516");
                ComposerKt.sourceInformationMarkerStart(composer, 212684070, "CC(remember):ConstraintLayout.kt#9igjgp");
                boolean changedInstance5 = composer.changedInstance(measurer2);
                Object rememberedValue15 = composer.rememberedValue();
                if (changedInstance5 || rememberedValue15 == Composer.Companion.getEmpty()) {
                    rememberedValue15 = (Function1) new ConstraintLayoutKt$ConstraintLayout$7$1(measurer2);
                    composer.updateRememberedValue(rememberedValue15);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue15, 1, null), ComposableLambdaKt.rememberComposableLambda(-207512644, true, new ConstraintLayoutKt$ConstraintLayout$8(mutableState4, function2), composer, 54), measurePolicy, composer, 48, 0);
                composer.endReplaceGroup();
            }
            composer.endReplaceGroup();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* renamed from: ConstraintLayout$lambda-17 */
    public static final ConstraintSet m7012ConstraintLayout$lambda17(MutableState<ConstraintSet> mutableState) {
        return mutableState.getValue();
    }

    /* renamed from: ConstraintLayout$lambda-20 */
    public static final ConstraintSet m7014ConstraintLayout$lambda20(MutableState<ConstraintSet> mutableState) {
        return mutableState.getValue();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Prefer version that takes a nullable AnimationSpec to animate changes.", replaceWith = @ReplaceWith(expression = "ConstraintLayout(constraintSet = constraintSet, modifier = modifier, optimizationLevel = optimizationLevel, animateChangesSpec = animationSpec, finishedAnimationListener = finishedAnimationListener) { content() }", imports = {}))
    public static final void ConstraintLayout(ConstraintSet constraintSet, Modifier modifier, int i, boolean z, AnimationSpec<Float> animationSpec, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i2, int i3) {
        Animatable animatable;
        ComposerKt.sourceInformationMarkerStart(composer, 136894876, "CC(ConstraintLayout)P(2,5,6!2,4)885@37021L301:ConstraintLayout.kt#fysre8");
        Modifier.Companion companion = (i3 & 2) != 0 ? Modifier.Companion : modifier;
        int i4 = (i3 & 4) != 0 ? 257 : i;
        boolean z2 = (i3 & 8) != 0 ? false : z;
        TweenSpec tween$default = (i3 & 16) != 0 ? AnimationSpecKt.tween$default(0, 0, null, 7, null) : animationSpec;
        Object obj = (i3 & 32) != 0 ? null : function0;
        if (!z2) {
            tween$default = null;
        }
        int i5 = i2 >> 3;
        int i6 = (i5 & 458752) | (i2 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | (i5 & 57344);
        ComposerKt.sourceInformationMarkerStart(composer, 2055379008, "CC(ConstraintLayout)P(1,4,5!1,3):ConstraintLayout.kt#fysre8");
        if (tween$default != null) {
            composer.startReplaceGroup(-2000135165);
            ComposerKt.sourceInformation(composer, "769@32178L42,770@32250L42,771@32316L29,772@32368L54,773@32447L33,775@32501L34,775@32490L45,777@32569L794,777@32545L818,794@33372L201");
            ComposerKt.sourceInformationMarkerStart(composer, 212573839, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(constraintSet, null, 2, null);
                composer.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212576143, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(constraintSet, null, 2, null);
                composer.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState2 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212578242, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                composer.updateRememberedValue(rememberedValue3);
            }
            Object obj2 = (Animatable) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212579931, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue4 = composer.rememberedValue();
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = ChannelKt.Channel$default(-1, null, null, 6, null);
                composer.updateRememberedValue(rememberedValue4);
            }
            Channel channel = (Channel) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212582438, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue5 = composer.rememberedValue();
            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = SnapshotIntStateKt.mutableIntStateOf(1);
                composer.updateRememberedValue(rememberedValue5);
            }
            MutableIntState mutableIntState = (MutableIntState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212584167, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(channel) | (((6 ^ (i6 & 14)) > 4 && composer.changed(constraintSet)) || (i6 & 6) == 4);
            Object rememberedValue6 = composer.rememberedValue();
            if (changedInstance || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = (Function0) new ConstraintLayoutKt$ConstraintLayout$3$1(channel, constraintSet);
                composer.updateRememberedValue(rememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.SideEffect((Function0) rememberedValue6, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 212587103, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean changedInstance2 = composer.changedInstance(channel) | composer.changedInstance(obj2) | composer.changedInstance(tween$default) | ((((i6 & 57344) ^ 24576) > 16384 && composer.changed(obj)) || (i6 & 24576) == 16384);
            Object rememberedValue7 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue7 == Composer.Companion.getEmpty()) {
                animatable = obj2;
                rememberedValue7 = (Function2) new ConstraintLayoutKt$ConstraintLayout$4$1(channel, mutableIntState, animatable, tween$default, obj, mutableState, mutableState2, null);
                composer.updateRememberedValue(rememberedValue7);
            } else {
                animatable = obj2;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.LaunchedEffect(channel, (Function2) rememberedValue7, composer, 0);
            ConstraintSet m7012ConstraintLayout$lambda17 = m7012ConstraintLayout$lambda17(mutableState);
            ConstraintSet m7014ConstraintLayout$lambda20 = m7014ConstraintLayout$lambda20(mutableState2);
            float floatValue = ((Number) animatable.getValue()).floatValue();
            int i7 = (i6 << 6) & 7168;
            ComposerKt.sourceInformationMarkerStart(composer, -531105279, "CC(MotionLayout)P(7,2,6,4,8,1:androidx.constraintlayout.compose.DebugFlags,5,3)145@6151L53,146@6233L93,151@6488L627,166@7120L556:MotionLayout.kt#fysre8");
            int m7040getNonebfy_xzQ = DebugFlags.Companion.m7040getNonebfy_xzQ();
            InvalidationStrategy defaultInvalidationStrategy = InvalidationStrategy.Companion.getDefaultInvalidationStrategy();
            ComposerKt.sourceInformationMarkerStart(composer, 1692702995, "CC(remember):MotionLayout.kt#9igjgp");
            Object rememberedValue8 = composer.rememberedValue();
            if (rememberedValue8 == Composer.Companion.getEmpty()) {
                rememberedValue8 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                composer.updateRememberedValue(rememberedValue8);
            }
            MutableState mutableState3 = (MutableState) rememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1692705659, "CC(remember):MotionLayout.kt#9igjgp");
            Object rememberedValue9 = composer.rememberedValue();
            Object obj3 = rememberedValue9;
            if (rememberedValue9 == Composer.Companion.getEmpty()) {
                Ref ref = new Ref();
                ref.setValue(CompositionSource.Unknown);
                composer.updateRememberedValue(ref);
                obj3 = ref;
            }
            Ref ref2 = (Ref) obj3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            MotionLayoutKt.MotionLayoutCore(m7012ConstraintLayout$lambda17, m7014ConstraintLayout$lambda20, null, floatValue, null, 257, DebugFlags.m7033getShowBoundsimpl(m7040getNonebfy_xzQ), DebugFlags.m7035getShowPathsimpl(m7040getNonebfy_xzQ), DebugFlags.m7034getShowKeyPositionsimpl(m7040getNonebfy_xzQ), companion, mutableState3, ref2, defaultInvalidationStrategy, ComposableLambdaKt.rememberComposableLambda(284503157, true, new ConstraintLayoutKt$ConstraintLayout$$inlined$MotionLayoutT3LJ6Qw$1(mutableState3, defaultInvalidationStrategy, ref2, function2, i6), composer, 54), composer, 24576 | ((i7 << 18) & 1879048192), (Ref.$stable << 3) | 3078);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1998673515);
            ComposerKt.sourceInformation(composer, "802@33613L35,804@33679L53,805@33768L7,806@33799L31,807@33859L914");
            ComposerKt.sourceInformationMarkerStart(composer, 212619752, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue10 = composer.rememberedValue();
            if (rememberedValue10 == Composer.Companion.getEmpty()) {
                rememberedValue10 = SnapshotLongStateKt.mutableLongStateOf(0L);
                composer.updateRememberedValue(rememberedValue10);
            }
            MutableLongState mutableLongState = (MutableLongState) rememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212621882, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue11 = composer.rememberedValue();
            if (rememberedValue11 == Composer.Companion.getEmpty()) {
                rememberedValue11 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                composer.updateRememberedValue(rememberedValue11);
            }
            MutableState mutableState4 = (MutableState) rememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(composer, 212625700, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object rememberedValue12 = composer.rememberedValue();
            if (rememberedValue12 == Composer.Companion.getEmpty()) {
                rememberedValue12 = new Measurer2(density);
                composer.updateRememberedValue(rememberedValue12);
            }
            Measurer2 measurer2 = (Measurer2) rememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212628503, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean changedInstance3 = composer.changedInstance(measurer2) | ((((i6 & 14) ^ 6) > 4 && composer.changed(constraintSet)) || (i6 & 6) == 4) | ((((i6 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(i4)) || (i6 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
            Object rememberedValue13 = composer.rememberedValue();
            if (changedInstance3 || rememberedValue13 == Composer.Companion.getEmpty()) {
                rememberedValue13 = (MeasurePolicy) new ConstraintLayoutKt$ConstraintLayout$measurePolicy$2$1(mutableState4, measurer2, constraintSet, i4);
                composer.updateRememberedValue(rememberedValue13);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue13;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (constraintSet instanceof EditableJSONLayout) {
                ((EditableJSONLayout) constraintSet).setUpdateFlag(mutableLongState);
            }
            measurer2.addLayoutInformationReceiver(constraintSet instanceof LayoutInformationReceiver ? (LayoutInformationReceiver) constraintSet : null);
            if (Float.isNaN(measurer2.getForcedScaleFactor())) {
                composer.startReplaceGroup(-1996827620);
                ComposerKt.sourceInformation(composer, "847@35623L33,849@35731L328,846@35557L516");
                ComposerKt.sourceInformationMarkerStart(composer, 212684070, "CC(remember):ConstraintLayout.kt#9igjgp");
                boolean changedInstance4 = composer.changedInstance(measurer2);
                Object rememberedValue14 = composer.rememberedValue();
                if (changedInstance4 || rememberedValue14 == Composer.Companion.getEmpty()) {
                    rememberedValue14 = (Function1) new ConstraintLayoutKt$ConstraintLayout$7$1(measurer2);
                    composer.updateRememberedValue(rememberedValue14);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue14, 1, null), ComposableLambdaKt.rememberComposableLambda(-207512644, true, new ConstraintLayoutKt$ConstraintLayout$8(mutableState4, function2), composer, 54), measurePolicy, composer, 48, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1997256040);
                ComposerKt.sourceInformation(composer, "836@35158L332");
                Modifier scale = ScaleKt.scale(companion, measurer2.getForcedScaleFactor());
                ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, Modifier.Companion);
                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer m3520constructorimpl = Updater.m3520constructorimpl(composer);
                Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -2074157001, "C839@35286L33,841@35445L13,838@35221L255:ConstraintLayout.kt#fysre8");
                ComposerKt.sourceInformationMarkerStart(composer, -1729473147, "CC(remember):ConstraintLayout.kt#9igjgp");
                boolean changedInstance5 = composer.changedInstance(measurer2);
                Object rememberedValue15 = composer.rememberedValue();
                if (changedInstance5 || rememberedValue15 == Composer.Companion.getEmpty()) {
                    rememberedValue15 = (Function1) new ConstraintLayoutKt$ConstraintLayout$6$1$1(measurer2);
                    composer.updateRememberedValue(rememberedValue15);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(scale, false, (Function1) rememberedValue15, 1, null), ComposableLambdaKt.rememberComposableLambda(1131308473, true, new ConstraintLayoutKt$ConstraintLayout$6$2(function2), composer, 54), measurePolicy, composer, 48, 0);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
            }
            composer.endReplaceGroup();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public static final Object createId() {
        return new Object() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$createId$1
        };
    }

    public static final Dimension.MaxCoercible getAtLeastWrapContent(Dimension.Coercible coercible) {
        Intrinsics.checkNotNull(coercible, "null cannot be cast to non-null type androidx.constraintlayout.compose.DimensionDescription");
        DimensionDescription dimensionDescription = (DimensionDescription) coercible;
        dimensionDescription.getMin$constraintlayout_compose_release().update("wrap");
        return dimensionDescription;
    }

    /* renamed from: atLeast-3ABfNKs */
    public static final Dimension.MaxCoercible m7020atLeast3ABfNKs(Dimension.Coercible coercible, float f) {
        Intrinsics.checkNotNull(coercible, "null cannot be cast to non-null type androidx.constraintlayout.compose.DimensionDescription");
        DimensionDescription dimensionDescription = (DimensionDescription) coercible;
        dimensionDescription.getMin$constraintlayout_compose_release().m7043update0680j_4(f);
        return dimensionDescription;
    }

    /* renamed from: atMost-3ABfNKs */
    public static final Dimension.MinCoercible m7023atMost3ABfNKs(Dimension.Coercible coercible, float f) {
        Intrinsics.checkNotNull(coercible, "null cannot be cast to non-null type androidx.constraintlayout.compose.DimensionDescription");
        DimensionDescription dimensionDescription = (DimensionDescription) coercible;
        dimensionDescription.getMax$constraintlayout_compose_release().m7043update0680j_4(f);
        return dimensionDescription;
    }

    public static final Dimension.MinCoercible getAtMostWrapContent(Dimension.Coercible coercible) {
        Intrinsics.checkNotNull(coercible, "null cannot be cast to non-null type androidx.constraintlayout.compose.DimensionDescription");
        DimensionDescription dimensionDescription = (DimensionDescription) coercible;
        dimensionDescription.getMax$constraintlayout_compose_release().update("wrap");
        return dimensionDescription;
    }

    @Deprecated(message = "Unintended method name, use atLeast(dp) instead", replaceWith = @ReplaceWith(expression = "this.atLeast(dp)", imports = {"androidx.constraintlayout.compose.atLeast"}))
    /* renamed from: atLeastWrapContent-3ABfNKs */
    public static final Dimension m7022atLeastWrapContent3ABfNKs(Dimension.MinCoercible minCoercible, float f) {
        Intrinsics.checkNotNull(minCoercible, "null cannot be cast to non-null type androidx.constraintlayout.compose.DimensionDescription");
        DimensionDescription dimensionDescription = (DimensionDescription) minCoercible;
        dimensionDescription.getMin$constraintlayout_compose_release().m7043update0680j_4(f);
        return dimensionDescription;
    }

    /* renamed from: atLeast-3ABfNKs */
    public static final Dimension m7021atLeast3ABfNKs(Dimension.MinCoercible minCoercible, float f) {
        Intrinsics.checkNotNull(minCoercible, "null cannot be cast to non-null type androidx.constraintlayout.compose.DimensionDescription");
        DimensionDescription dimensionDescription = (DimensionDescription) minCoercible;
        dimensionDescription.getMin$constraintlayout_compose_release().m7043update0680j_4(f);
        return dimensionDescription;
    }

    public static final Dimension getAtLeastWrapContent(Dimension.MinCoercible minCoercible) {
        Intrinsics.checkNotNull(minCoercible, "null cannot be cast to non-null type androidx.constraintlayout.compose.DimensionDescription");
        DimensionDescription dimensionDescription = (DimensionDescription) minCoercible;
        dimensionDescription.getMin$constraintlayout_compose_release().update("wrap");
        return dimensionDescription;
    }

    /* renamed from: atMost-3ABfNKs */
    public static final Dimension m7024atMost3ABfNKs(Dimension.MaxCoercible maxCoercible, float f) {
        Intrinsics.checkNotNull(maxCoercible, "null cannot be cast to non-null type androidx.constraintlayout.compose.DimensionDescription");
        DimensionDescription dimensionDescription = (DimensionDescription) maxCoercible;
        dimensionDescription.getMax$constraintlayout_compose_release().m7043update0680j_4(f);
        return dimensionDescription;
    }

    public static final Dimension getAtMostWrapContent(Dimension.MaxCoercible maxCoercible) {
        Intrinsics.checkNotNull(maxCoercible, "null cannot be cast to non-null type androidx.constraintlayout.compose.DimensionDescription");
        DimensionDescription dimensionDescription = (DimensionDescription) maxCoercible;
        dimensionDescription.getMax$constraintlayout_compose_release().update("wrap");
        return dimensionDescription;
    }

    public static final ConstraintSet ConstraintSet(String str, String str2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1420317079, "C(ConstraintSet)1349@55301L86:ConstraintLayout.kt#fysre8");
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        String str3 = str2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1420317079, i, -1, "androidx.constraintlayout.compose.ConstraintSet (ConstraintLayout.kt:1347)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1304151869, "CC(remember):ConstraintLayout.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(str)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(str3)) || (i & 48) == 32);
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            JSONConstraintSet jSONConstraintSet = new JSONConstraintSet(str, str3, null, 4, null);
            composer.updateRememberedValue(jSONConstraintSet);
            rememberedValue = jSONConstraintSet;
        }
        JSONConstraintSet jSONConstraintSet2 = (JSONConstraintSet) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jSONConstraintSet2;
    }

    public static final ConstraintSet ConstraintSet(String str) {
        return new JSONConstraintSet(str, null, null, 6, null);
    }

    public static final ConstraintSet ConstraintSet(ConstraintSet constraintSet, String str) {
        return new JSONConstraintSet(str, null, constraintSet, 2, null);
    }

    public static final ConstraintSet ConstraintSet(Function1<? super ConstraintSetScope, Unit> function1) {
        return new DslConstraintSet(function1, null, 2, null);
    }

    public static final ConstraintSet ConstraintSet(ConstraintSet constraintSet, Function1<? super ConstraintSetScope, Unit> function1) {
        return new DslConstraintSet(function1, constraintSet);
    }

    /* renamed from: placeWithFrameTransform-Ktjjmr4$default */
    public static /* synthetic */ void m7026placeWithFrameTransformKtjjmr4$default(Placeable.PlacementScope placementScope, Placeable placeable, WidgetFrame widgetFrame, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = IntOffset.Companion.m6823getZeronOccac();
        }
        m7025placeWithFrameTransformKtjjmr4(placementScope, placeable, widgetFrame, j);
    }

    /* renamed from: placeWithFrameTransform-Ktjjmr4 */
    public static final void m7025placeWithFrameTransformKtjjmr4(Placeable.PlacementScope placementScope, Placeable placeable, final WidgetFrame widgetFrame, long j) {
        if (widgetFrame.visibility == 8) {
            return;
        }
        if (widgetFrame.isDefaultTransform()) {
            Placeable.PlacementScope.m5502place70tqf50$default(placementScope, placeable, IntOffsetKt.IntOffset(widgetFrame.left - IntOffset.m6812getXimpl(j), widgetFrame.top - IntOffset.m6813getYimpl(j)), 0.0f, 2, null);
            return;
        }
        placementScope.placeWithLayer(placeable, widgetFrame.left - IntOffset.m6812getXimpl(j), widgetFrame.top - IntOffset.m6813getYimpl(j), Float.isNaN(widgetFrame.translationZ) ? 0.0f : widgetFrame.translationZ, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$placeWithFrameTransform$layerBlock$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                invoke2(graphicsLayerScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                if (!Float.isNaN(WidgetFrame.this.pivotX) || !Float.isNaN(WidgetFrame.this.pivotY)) {
                    graphicsLayerScope.mo4271setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(Float.isNaN(WidgetFrame.this.pivotX) ? 0.5f : WidgetFrame.this.pivotX, Float.isNaN(WidgetFrame.this.pivotY) ? 0.5f : WidgetFrame.this.pivotY));
                }
                if (!Float.isNaN(WidgetFrame.this.rotationX)) {
                    graphicsLayerScope.setRotationX(WidgetFrame.this.rotationX);
                }
                if (!Float.isNaN(WidgetFrame.this.rotationY)) {
                    graphicsLayerScope.setRotationY(WidgetFrame.this.rotationY);
                }
                if (!Float.isNaN(WidgetFrame.this.rotationZ)) {
                    graphicsLayerScope.setRotationZ(WidgetFrame.this.rotationZ);
                }
                if (!Float.isNaN(WidgetFrame.this.translationX)) {
                    graphicsLayerScope.setTranslationX(WidgetFrame.this.translationX);
                }
                if (!Float.isNaN(WidgetFrame.this.translationY)) {
                    graphicsLayerScope.setTranslationY(WidgetFrame.this.translationY);
                }
                if (!Float.isNaN(WidgetFrame.this.translationZ)) {
                    graphicsLayerScope.setShadowElevation(WidgetFrame.this.translationZ);
                }
                if (!Float.isNaN(WidgetFrame.this.scaleX) || !Float.isNaN(WidgetFrame.this.scaleY)) {
                    graphicsLayerScope.setScaleX(Float.isNaN(WidgetFrame.this.scaleX) ? 1.0f : WidgetFrame.this.scaleX);
                    graphicsLayerScope.setScaleY(Float.isNaN(WidgetFrame.this.scaleY) ? 1.0f : WidgetFrame.this.scaleY);
                }
                if (Float.isNaN(WidgetFrame.this.alpha)) {
                    return;
                }
                graphicsLayerScope.setAlpha(WidgetFrame.this.alpha);
            }
        });
    }

    public static final String toDebugString(ConstraintWidget constraintWidget) {
        StringBuilder sb = new StringBuilder();
        sb.append(constraintWidget.getDebugName()).append(" width ").append(constraintWidget.getWidth()).append(" minWidth ").append(constraintWidget.getMinWidth()).append(" maxWidth ").append(constraintWidget.getMaxWidth()).append(" height ").append(constraintWidget.getHeight()).append(" minHeight ").append(constraintWidget.getMinHeight()).append(" maxHeight ").append(constraintWidget.getMaxHeight()).append(" HDB ").append(constraintWidget.getHorizontalDimensionBehaviour()).append(" VDB ").append(constraintWidget.getVerticalDimensionBehaviour()).append(" MCW ").append(constraintWidget.mMatchConstraintDefaultWidth).append(" MCH ").append(constraintWidget.mMatchConstraintDefaultHeight).append(" percentW ").append(constraintWidget.mMatchConstraintPercentWidth);
        sb.append(" percentH ").append(constraintWidget.mMatchConstraintPercentHeight);
        return sb.toString();
    }

    public static final void buildMapping(State state, List<? extends Measurable> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Measurable measurable = list.get(i);
            Object layoutId = LayoutIdKt.getLayoutId(measurable);
            if (layoutId == null && (layoutId = ConstraintLayoutTagKt.getConstraintLayoutId(measurable)) == null) {
                layoutId = createId();
            }
            state.map(layoutId.toString(), measurable);
            Object constraintLayoutTag = ConstraintLayoutTagKt.getConstraintLayoutTag(measurable);
            if (constraintLayoutTag != null && (constraintLayoutTag instanceof String) && (layoutId instanceof String)) {
                state.setTag((String) layoutId, (String) constraintLayoutTag);
            }
        }
    }
}
