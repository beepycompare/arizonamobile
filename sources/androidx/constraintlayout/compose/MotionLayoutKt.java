package androidx.constraintlayout.compose;

import android.os.Build;
import android.view.View;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.motion.widget.Key;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
/* compiled from: MotionLayout.kt */
@Metadata(d1 = {"\u0000¦\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u007f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001e\b\u0004\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001au\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001e\b\u0004\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u008d\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060 2\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\n\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001e\b\u0004\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010#\u001a£\u0001\u0010$\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0001¢\u0006\u0002\u00100\u001a\u0084\u0001\u0010$\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a¤\u0001\u0010$\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060 2\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a\u001f\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u0002072\b\u0010%\u001a\u0004\u0018\u00010&H\u0001¢\u0006\u0002\u00108\u001a\u0015\u00109\u001a\u0002072\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0010:\u001a\\\u0010;\u001a\u00020<2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010=2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020@2\u0006\u00106\u001a\u0002072\u0006\u0010A\u001a\u00020B2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0001\u001a4\u0010C\u001a\u00020\b*\u00020\b2\u0006\u0010A\u001a\u00020B2\u0006\u0010D\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(H\u0001\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006E²\u0006\n\u0010\u0002\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\u0004\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010F\u001a\u00020(X\u008a\u008e\u0002"}, d2 = {"MotionLayout", "", TtmlNode.START, "Landroidx/constraintlayout/compose/ConstraintSet;", TtmlNode.END, "progress", "", "modifier", "Landroidx/compose/ui/Modifier;", "transition", "Landroidx/constraintlayout/compose/Transition;", "debugFlags", "Landroidx/constraintlayout/compose/DebugFlags;", "optimizationLevel", "", "invalidationStrategy", "Landroidx/constraintlayout/compose/InvalidationStrategy;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/MotionLayoutScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "MotionLayout-T3LJ6Qw", "(Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/ConstraintSet;FLandroidx/compose/ui/Modifier;Landroidx/constraintlayout/compose/Transition;IILandroidx/constraintlayout/compose/InvalidationStrategy;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "motionScene", "Landroidx/constraintlayout/compose/MotionScene;", "transitionName", "", "MotionLayout-6oYECBM", "(Landroidx/constraintlayout/compose/MotionScene;FLandroidx/compose/ui/Modifier;Ljava/lang/String;IILandroidx/constraintlayout/compose/InvalidationStrategy;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "constraintSetName", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "finishedAnimationListener", "Lkotlin/Function0;", "(Landroidx/constraintlayout/compose/MotionScene;Ljava/lang/String;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;IILandroidx/constraintlayout/compose/InvalidationStrategy;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "MotionLayoutCore", "informationReceiver", "Landroidx/constraintlayout/compose/LayoutInformationReceiver;", "showBounds", "", "showPaths", "showKeyPositions", "contentTracker", "Landroidx/compose/runtime/MutableState;", "compositionSource", "Landroidx/compose/ui/node/Ref;", "Landroidx/constraintlayout/compose/CompositionSource;", "(Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/Transition;FLandroidx/constraintlayout/compose/LayoutInformationReceiver;IZZZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/node/Ref;Landroidx/constraintlayout/compose/InvalidationStrategy;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "MotionLayoutCore-SehEMGo", "(Landroidx/constraintlayout/compose/MotionScene;FLjava/lang/String;IILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/node/Ref;Landroidx/constraintlayout/compose/InvalidationStrategy;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "MotionLayoutCore-TEds9UA", "(Landroidx/constraintlayout/compose/MotionScene;Ljava/lang/String;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;IILandroidx/compose/runtime/MutableState;Landroidx/compose/ui/node/Ref;Landroidx/constraintlayout/compose/InvalidationStrategy;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "UpdateWithForcedIfNoUserChange", Key.MOTIONPROGRESS, "Landroidx/compose/runtime/MutableFloatState;", "(Landroidx/compose/runtime/MutableFloatState;Landroidx/constraintlayout/compose/LayoutInformationReceiver;Landroidx/compose/runtime/Composer;I)V", "createAndUpdateMotionProgress", "(FLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/MutableFloatState;", "motionLayoutMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "Landroidx/compose/runtime/State;", "constraintSetStart", "constraintSetEnd", "Landroidx/constraintlayout/compose/TransitionImpl;", "measurer", "Landroidx/constraintlayout/compose/MotionMeasurer;", "motionDebug", "scaleFactor", "constraintlayout-compose_release", "animateToEnd"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MotionLayoutKt {
    /* renamed from: MotionLayout-T3LJ6Qw  reason: not valid java name */
    public static final void m7100MotionLayoutT3LJ6Qw(ConstraintSet constraintSet, ConstraintSet constraintSet2, float f, Modifier modifier, Transition transition, int i, int i2, InvalidationStrategy invalidationStrategy, final Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, -531105279, "CC(MotionLayout)P(7,2,6,4,8,1:androidx.constraintlayout.compose.DebugFlags,5,3)145@6151L53,146@6233L93,151@6488L627,166@7120L556:MotionLayout.kt#fysre8");
        Modifier.Companion companion = (i4 & 8) != 0 ? Modifier.Companion : modifier;
        Transition transition2 = (i4 & 16) != 0 ? null : transition;
        int m7040getNonebfy_xzQ = (i4 & 32) != 0 ? DebugFlags.Companion.m7040getNonebfy_xzQ() : i;
        int i5 = (i4 & 64) != 0 ? 257 : i2;
        final InvalidationStrategy defaultInvalidationStrategy = (i4 & 128) != 0 ? InvalidationStrategy.Companion.getDefaultInvalidationStrategy() : invalidationStrategy;
        ComposerKt.sourceInformationMarkerStart(composer, 1692702995, "CC(remember):MotionLayout.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
            composer.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1692705659, "CC(remember):MotionLayout.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        Object obj = rememberedValue2;
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            Ref ref = new Ref();
            ref.setValue(CompositionSource.Unknown);
            composer.updateRememberedValue(ref);
            obj = ref;
        }
        final Ref ref2 = (Ref) obj;
        ComposerKt.sourceInformationMarkerEnd(composer);
        MotionLayoutCore(constraintSet, constraintSet2, transition2, f, null, i5, DebugFlags.m7033getShowBoundsimpl(m7040getNonebfy_xzQ), DebugFlags.m7035getShowPathsimpl(m7040getNonebfy_xzQ), DebugFlags.m7034getShowKeyPositionsimpl(m7040getNonebfy_xzQ), companion, mutableState, ref2, defaultInvalidationStrategy, ComposableLambdaKt.rememberComposableLambda(284503157, true, new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayout$contentDelegate$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                invoke(motionLayoutScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(MotionLayoutScope motionLayoutScope, Composer composer2, int i6) {
                ComposerKt.sourceInformation(composer2, "C164@7100L9:MotionLayout.kt#fysre8");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(284503157, i6, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:154)");
                }
                mutableState.setValue(Unit.INSTANCE);
                if (defaultInvalidationStrategy.getOnObservedStateChange() == null && ref2.getValue() == CompositionSource.Unknown) {
                    ref2.setValue(CompositionSource.Content);
                }
                function3.invoke(motionLayoutScope, composer2, Integer.valueOf(i6 & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, (i3 & 14) | 24576 | (i3 & 112) | ((i3 >> 6) & 896) | ((i3 << 3) & 7168) | ((i3 >> 3) & 458752) | ((i3 << 18) & 1879048192), (Ref.$stable << 3) | 3078 | ((i3 >> 15) & 896));
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* renamed from: MotionLayout-6oYECBM  reason: not valid java name */
    public static final void m7099MotionLayout6oYECBM(MotionScene motionScene, float f, Modifier modifier, String str, int i, int i2, InvalidationStrategy invalidationStrategy, final Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)255@11054L53,256@11136L93,261@11391L627,277@12024L412:MotionLayout.kt#fysre8");
        if ((i4 & 4) != 0) {
            modifier = Modifier.Companion;
        }
        Modifier modifier2 = modifier;
        if ((i4 & 8) != 0) {
            str = "default";
        }
        String str2 = str;
        int m7040getNonebfy_xzQ = (i4 & 16) != 0 ? DebugFlags.Companion.m7040getNonebfy_xzQ() : i;
        int i5 = (i4 & 32) != 0 ? 257 : i2;
        final InvalidationStrategy defaultInvalidationStrategy = (i4 & 64) != 0 ? InvalidationStrategy.Companion.getDefaultInvalidationStrategy() : invalidationStrategy;
        ComposerKt.sourceInformationMarkerStart(composer, 1692859891, "CC(remember):MotionLayout.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
            composer.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1692862555, "CC(remember):MotionLayout.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        Object obj = rememberedValue2;
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            Ref ref = new Ref();
            ref.setValue(CompositionSource.Unknown);
            composer.updateRememberedValue(ref);
            obj = ref;
        }
        final Ref ref2 = (Ref) obj;
        ComposerKt.sourceInformationMarkerEnd(composer);
        m7102MotionLayoutCoreSehEMGo(motionScene, f, str2, i5, m7040getNonebfy_xzQ, modifier2, mutableState, ref2, defaultInvalidationStrategy, ComposableLambdaKt.rememberComposableLambda(-23317463, true, new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayout$contentDelegate$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                invoke(motionLayoutScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(MotionLayoutScope motionLayoutScope, Composer composer2, int i6) {
                ComposerKt.sourceInformation(composer2, "C274@12003L9:MotionLayout.kt#fysre8");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-23317463, i6, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:264)");
                }
                mutableState.setValue(Unit.INSTANCE);
                if (defaultInvalidationStrategy.getOnObservedStateChange() == null && ref2.getValue() == CompositionSource.Unknown) {
                    ref2.setValue(CompositionSource.Content);
                }
                function3.invoke(motionLayoutScope, composer2, Integer.valueOf(i6 & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, (i3 & 14) | 806879232 | (i3 & 112) | ((i3 >> 3) & 896) | ((i3 >> 6) & 7168) | (i3 & 57344) | ((i3 << 9) & 458752) | (Ref.$stable << 21) | (234881024 & (i3 << 6)));
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* renamed from: MotionLayout-T3LJ6Qw  reason: not valid java name */
    public static final void m7101MotionLayoutT3LJ6Qw(MotionScene motionScene, String str, AnimationSpec<Float> animationSpec, Modifier modifier, Function0<Unit> function0, int i, int i2, InvalidationStrategy invalidationStrategy, final Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, -267984822, "CC(MotionLayout)P(7,1!1,6,4,3:androidx.constraintlayout.compose.DebugFlags,8,5)381@16753L53,382@16835L93,387@17090L627,403@17723L491:MotionLayout.kt#fysre8");
        Modifier.Companion companion = (i4 & 8) != 0 ? Modifier.Companion : modifier;
        Function0<Unit> function02 = (i4 & 16) != 0 ? null : function0;
        int m7040getNonebfy_xzQ = (i4 & 32) != 0 ? DebugFlags.Companion.m7040getNonebfy_xzQ() : i;
        int i5 = (i4 & 64) != 0 ? 257 : i2;
        final InvalidationStrategy defaultInvalidationStrategy = (i4 & 128) != 0 ? InvalidationStrategy.Companion.getDefaultInvalidationStrategy() : invalidationStrategy;
        ComposerKt.sourceInformationMarkerStart(composer, 1693042259, "CC(remember):MotionLayout.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
            composer.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1693044923, "CC(remember):MotionLayout.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        Object obj = rememberedValue2;
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            Ref ref = new Ref();
            ref.setValue(CompositionSource.Unknown);
            composer.updateRememberedValue(ref);
            obj = ref;
        }
        final Ref ref2 = (Ref) obj;
        ComposerKt.sourceInformationMarkerEnd(composer);
        m7103MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, companion, function02, m7040getNonebfy_xzQ, i5, mutableState, ref2, defaultInvalidationStrategy, ComposableLambdaKt.rememberComposableLambda(1064705982, true, new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayout$contentDelegate$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                invoke(motionLayoutScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(MotionLayoutScope motionLayoutScope, Composer composer2, int i6) {
                ComposerKt.sourceInformation(composer2, "C400@17702L9:MotionLayout.kt#fysre8");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1064705982, i6, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:390)");
                }
                mutableState.setValue(Unit.INSTANCE);
                if (defaultInvalidationStrategy.getOnObservedStateChange() == null && ref2.getValue() == CompositionSource.Unknown) {
                    ref2.setValue(CompositionSource.Content);
                }
                function3.invoke(motionLayoutScope, composer2, Integer.valueOf(i6 & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (Ref.$stable << 24) | ((i3 << 6) & 1879048192), 6, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0281 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:275:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fb  */
    /* renamed from: MotionLayoutCore-TEds9UA  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m7103MotionLayoutCoreTEds9UA(final MotionScene motionScene, final String str, final AnimationSpec<Float> animationSpec, Modifier modifier, Function0<Unit> function0, int i, int i2, final MutableState<Unit> mutableState, final Ref<CompositionSource> ref, final InvalidationStrategy invalidationStrategy, final Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        Object obj;
        int i7;
        Object obj2;
        int i8;
        int i9;
        int i10;
        final int i11;
        int i12;
        int i13;
        int i14;
        Object rememberedValue;
        boolean changed;
        Object rememberedValue2;
        Transition transition;
        boolean changed2;
        Object rememberedValue3;
        ConstraintSet constraintSet;
        boolean changed3;
        Object rememberedValue4;
        ScopeUpdateScope endRestartGroup;
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        int i15;
        int i16;
        LayoutInformationReceiver layoutInformationReceiver;
        int i17;
        Animatable animatable;
        Function0<Unit> function02;
        LayoutInformationReceiver layoutInformationReceiver2;
        Composer composer2;
        final Modifier modifier2;
        final Function0<Unit> function03;
        final int i18;
        Channel channel;
        Composer startRestartGroup = composer.startRestartGroup(1132252061);
        ComposerKt.sourceInformation(startRestartGroup, "C(MotionLayoutCore)P(9,2!1,8,6,5:androidx.constraintlayout.compose.DebugFlags,10,4!1,7)434@18847L35,437@18913L113,442@19059L189,447@19278L181,456@19569L54,457@19654L52,460@19746L147,464@19914L27,466@19967L46,468@20033L54,491@20968L591:MotionLayout.kt#fysre8");
        if ((i5 & 1) != 0) {
            i6 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i6 = (startRestartGroup.changed(motionScene) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else if ((i3 & 48) == 0) {
            i6 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i5 & 4) != 0) {
            i6 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i6 |= startRestartGroup.changedInstance(animationSpec) ? 256 : 128;
        }
        int i19 = i5 & 8;
        if (i19 != 0) {
            i6 |= 3072;
        } else if ((i3 & 3072) == 0) {
            obj = modifier;
            i6 |= startRestartGroup.changed(obj) ? 2048 : 1024;
            i7 = i5 & 16;
            if (i7 == 0) {
                i6 |= 24576;
            } else if ((i3 & 24576) == 0) {
                obj2 = function0;
                i6 |= startRestartGroup.changedInstance(obj2) ? 16384 : 8192;
                i8 = i5 & 32;
                if (i8 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i9 = i;
                } else {
                    i9 = i;
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i6 |= startRestartGroup.changed(i9) ? 131072 : 65536;
                    }
                }
                i10 = i5 & 64;
                if (i10 != 0) {
                    i6 |= 1572864;
                    i11 = i2;
                } else {
                    i11 = i2;
                    if ((i3 & 1572864) == 0) {
                        i6 |= startRestartGroup.changed(i11) ? 1048576 : 524288;
                    }
                }
                if ((i5 & 128) != 0) {
                    i6 |= 12582912;
                } else if ((i3 & 12582912) == 0) {
                    i6 |= startRestartGroup.changed(mutableState) ? 8388608 : 4194304;
                    if ((i5 & 256) == 0) {
                        i12 = 100663296;
                    } else {
                        if ((100663296 & i3) == 0) {
                            i12 = (134217728 & i3) == 0 ? startRestartGroup.changed(ref) : startRestartGroup.changedInstance(ref) ? 67108864 : 33554432;
                        }
                        if ((i5 & 512) != 0) {
                            i6 |= 805306368;
                        } else if ((805306368 & i3) == 0) {
                            i6 |= startRestartGroup.changedInstance(invalidationStrategy) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                            if ((i5 & 1024) == 0) {
                                i13 = i7;
                                i14 = i4 | 6;
                            } else if ((i4 & 6) == 0) {
                                i13 = i7;
                                i14 = i4 | (startRestartGroup.changedInstance(function3) ? 4 : 2);
                            } else {
                                i13 = i7;
                                i14 = i4;
                            }
                            if ((i6 & 306783379) == 306783378 || (i14 & 3) != 2 || !startRestartGroup.getSkipping()) {
                                Modifier.Companion companion = i19 == 0 ? Modifier.Companion : obj;
                                if (i13 != 0) {
                                    obj2 = null;
                                }
                                int m7040getNonebfy_xzQ = i8 == 0 ? DebugFlags.Companion.m7040getNonebfy_xzQ() : i9;
                                if (i10 != 0) {
                                    i11 = 257;
                                }
                                final int i20 = i11;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1132252061, i6, i14, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:433)");
                                }
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488059648, "CC(remember):MotionLayout.kt#9igjgp");
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    rememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                MutableLongState mutableLongState = (MutableLongState) rememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                long longValue = mutableLongState.getLongValue();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488057458, "CC(remember):MotionLayout.kt#9igjgp");
                                int i21 = i6 & 14;
                                final Modifier modifier3 = companion;
                                changed = (i21 != 4) | startRestartGroup.changed(longValue);
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (!changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                                    rememberedValue2 = motionScene.getTransitionInstance("default");
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                transition = (Transition) rememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                long longValue2 = mutableLongState.getLongValue();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488052710, "CC(remember):MotionLayout.kt#9igjgp");
                                changed2 = (i21 != 4) | startRestartGroup.changed(longValue2);
                                rememberedValue3 = startRestartGroup.rememberedValue();
                                if (!changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                    if (transition != null || (r0 = transition.getStartConstraintSetId()) == null) {
                                        String str2 = TtmlNode.START;
                                    }
                                    rememberedValue3 = motionScene.getConstraintSetInstance(str2);
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                constraintSet = (ConstraintSet) rememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                int i22 = i6;
                                long longValue3 = mutableLongState.getLongValue();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488045710, "CC(remember):MotionLayout.kt#9igjgp");
                                changed3 = startRestartGroup.changed(longValue3) | (i21 != 4);
                                rememberedValue4 = startRestartGroup.rememberedValue();
                                if (!changed3 || rememberedValue4 == Composer.Companion.getEmpty()) {
                                    if (transition != null || (r4 = transition.getEndConstraintSetId()) == null) {
                                        String str3 = TtmlNode.END;
                                    }
                                    rememberedValue4 = motionScene.getConstraintSetInstance(str3);
                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                }
                                ConstraintSet constraintSet2 = (ConstraintSet) rememberedValue4;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                if (constraintSet != null || constraintSet2 == null) {
                                    final Function0<Unit> function04 = obj2;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    endRestartGroup = startRestartGroup.endRestartGroup();
                                    if (endRestartGroup == null) {
                                        final int i23 = m7040getNonebfy_xzQ;
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i24) {
                                                MotionLayoutKt.m7103MotionLayoutCoreTEds9UA(MotionScene.this, str, animationSpec, modifier3, function04, i23, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488036525, "CC(remember):MotionLayout.kt#9igjgp");
                                boolean z = i21 == 4;
                                Object rememberedValue5 = startRestartGroup.rememberedValue();
                                if (z || rememberedValue5 == Composer.Companion.getEmpty()) {
                                    mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(constraintSet, null, 2, null);
                                    startRestartGroup.updateRememberedValue(mutableStateOf$default);
                                    rememberedValue5 = mutableStateOf$default;
                                }
                                MutableState mutableState2 = (MutableState) rememberedValue5;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488033807, "CC(remember):MotionLayout.kt#9igjgp");
                                boolean z2 = i21 == 4;
                                Object rememberedValue6 = startRestartGroup.rememberedValue();
                                if (z2 || rememberedValue6 == Composer.Companion.getEmpty()) {
                                    mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(constraintSet2, null, 2, null);
                                    startRestartGroup.updateRememberedValue(mutableStateOf$default2);
                                    rememberedValue6 = mutableStateOf$default2;
                                }
                                MutableState mutableState3 = (MutableState) rememberedValue6;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488030768, "CC(remember):MotionLayout.kt#9igjgp");
                                boolean z3 = (i21 == 4) | ((i22 & 112) == 32);
                                Object rememberedValue7 = startRestartGroup.rememberedValue();
                                if (z3 || rememberedValue7 == Composer.Companion.getEmpty()) {
                                    ConstraintSet constraintSetInstance = str != null ? motionScene.getConstraintSetInstance(str) : null;
                                    startRestartGroup.updateRememberedValue(constraintSetInstance);
                                    rememberedValue7 = constraintSetInstance;
                                }
                                final ConstraintSet constraintSet3 = (ConstraintSet) rememberedValue7;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488025512, "CC(remember):MotionLayout.kt#9igjgp");
                                Object rememberedValue8 = startRestartGroup.rememberedValue();
                                if (rememberedValue8 == Composer.Companion.getEmpty()) {
                                    i15 = i22;
                                    rememberedValue8 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue8);
                                } else {
                                    i15 = i22;
                                }
                                Animatable animatable2 = (Animatable) rememberedValue8;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488023797, "CC(remember):MotionLayout.kt#9igjgp");
                                boolean z4 = i21 == 4;
                                Object rememberedValue9 = startRestartGroup.rememberedValue();
                                if (z4 || rememberedValue9 == Composer.Companion.getEmpty()) {
                                    rememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue9);
                                }
                                MutableState mutableState4 = (MutableState) rememberedValue9;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488021677, "CC(remember):MotionLayout.kt#9igjgp");
                                Object rememberedValue10 = startRestartGroup.rememberedValue();
                                if (rememberedValue10 == Composer.Companion.getEmpty()) {
                                    i16 = i14;
                                    layoutInformationReceiver = null;
                                    rememberedValue10 = ChannelKt.Channel$default(-1, null, null, 6, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue10);
                                } else {
                                    i16 = i14;
                                    layoutInformationReceiver = null;
                                }
                                final Channel channel2 = (Channel) rememberedValue10;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                startRestartGroup.startReplaceGroup(-488018941);
                                ComposerKt.sourceInformation(startRestartGroup, "471@20147L40,471@20136L51,473@20234L723,473@20197L760");
                                if (constraintSet3 != null) {
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488018043, "CC(remember):MotionLayout.kt#9igjgp");
                                    boolean changedInstance = startRestartGroup.changedInstance(channel2) | startRestartGroup.changed(constraintSet3);
                                    Object rememberedValue11 = startRestartGroup.rememberedValue();
                                    if (changedInstance || rememberedValue11 == Composer.Companion.getEmpty()) {
                                        rememberedValue11 = (Function0) new Function0<Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$2$1
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
                                                channel2.mo7544trySendJP2dKIU(constraintSet3);
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue11);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    EffectsKt.SideEffect((Function0) rememberedValue11, startRestartGroup, 0);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488014576, "CC(remember):MotionLayout.kt#9igjgp");
                                    boolean changedInstance2 = startRestartGroup.changedInstance(channel2) | startRestartGroup.changed(mutableState4) | startRestartGroup.changed(mutableState2) | startRestartGroup.changed(mutableState3) | startRestartGroup.changedInstance(animatable2) | startRestartGroup.changedInstance(animationSpec) | ((i15 & 57344) == 16384);
                                    MotionLayoutKt$MotionLayoutCore$3$1 rememberedValue12 = startRestartGroup.rememberedValue();
                                    if (changedInstance2 || rememberedValue12 == Composer.Companion.getEmpty()) {
                                        animatable = animatable2;
                                        Function0<Unit> function05 = obj2;
                                        layoutInformationReceiver2 = null;
                                        channel = channel2;
                                        i17 = i15;
                                        function02 = function05;
                                        rememberedValue12 = new MotionLayoutKt$MotionLayoutCore$3$1(channel, animatable, animationSpec, function05, mutableState4, mutableState2, mutableState3, null);
                                        startRestartGroup.updateRememberedValue(rememberedValue12);
                                    } else {
                                        animatable = animatable2;
                                        function02 = obj2;
                                        layoutInformationReceiver2 = null;
                                        channel = channel2;
                                        i17 = i15;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    EffectsKt.LaunchedEffect(motionScene, channel, (Function2) rememberedValue12, startRestartGroup, i21);
                                } else {
                                    i17 = i15;
                                    animatable = animatable2;
                                    function02 = obj2;
                                    layoutInformationReceiver2 = layoutInformationReceiver;
                                }
                                startRestartGroup.endReplaceGroup();
                                int i24 = i17 >> 21;
                                composer2 = startRestartGroup;
                                MotionLayoutCore(MotionLayoutCore_TEds9UA$lambda$14(mutableState2), MotionLayoutCore_TEds9UA$lambda$17(mutableState3), transition, ((Number) animatable.getValue()).floatValue(), motionScene instanceof LayoutInformationReceiver ? (LayoutInformationReceiver) motionScene : layoutInformationReceiver2, i20, DebugFlags.m7033getShowBoundsimpl(m7040getNonebfy_xzQ), DebugFlags.m7035getShowPathsimpl(m7040getNonebfy_xzQ), DebugFlags.m7034getShowKeyPositionsimpl(m7040getNonebfy_xzQ), modifier3, mutableState, ref, invalidationStrategy, function3, composer2, ((i17 >> 3) & 458752) | ((i17 << 18) & 1879048192), (i24 & 896) | (i24 & 14) | (Ref.$stable << 3) | (i24 & 112) | ((i16 << 9) & 7168));
                                i11 = i20;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = modifier3;
                                function03 = function02;
                                i18 = m7040getNonebfy_xzQ;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                i18 = i9;
                                modifier2 = obj;
                                composer2 = startRestartGroup;
                                function03 = obj2;
                            }
                            ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
                            if (endRestartGroup2 != null) {
                                endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$4
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i25) {
                                        MotionLayoutKt.m7103MotionLayoutCoreTEds9UA(MotionScene.this, str, animationSpec, modifier2, function03, i18, i11, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i5 & 1024) == 0) {
                        }
                        if ((i6 & 306783379) == 306783378) {
                        }
                        if (i19 == 0) {
                        }
                        if (i13 != 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (i10 != 0) {
                        }
                        final int i202 = i11;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488059648, "CC(remember):MotionLayout.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                        }
                        MutableLongState mutableLongState2 = (MutableLongState) rememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        long longValue4 = mutableLongState2.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488057458, "CC(remember):MotionLayout.kt#9igjgp");
                        int i212 = i6 & 14;
                        final Modifier modifier32 = companion;
                        changed = (i212 != 4) | startRestartGroup.changed(longValue4);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue2 = motionScene.getTransitionInstance("default");
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                        transition = (Transition) rememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        long longValue22 = mutableLongState2.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488052710, "CC(remember):MotionLayout.kt#9igjgp");
                        changed2 = (i212 != 4) | startRestartGroup.changed(longValue22);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!changed2) {
                        }
                        if (transition != null) {
                        }
                        String str22 = TtmlNode.START;
                        rememberedValue3 = motionScene.getConstraintSetInstance(str22);
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                        constraintSet = (ConstraintSet) rememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        int i222 = i6;
                        long longValue32 = mutableLongState2.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488045710, "CC(remember):MotionLayout.kt#9igjgp");
                        changed3 = startRestartGroup.changed(longValue32) | (i212 != 4);
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (!changed3) {
                        }
                        if (transition != null) {
                        }
                        String str32 = TtmlNode.END;
                        rememberedValue4 = motionScene.getConstraintSetInstance(str32);
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                        ConstraintSet constraintSet22 = (ConstraintSet) rememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        if (constraintSet != null) {
                        }
                        final Function0<Unit> function042 = obj2;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i6 |= i12;
                    if ((i5 & 512) != 0) {
                    }
                    if ((i5 & 1024) == 0) {
                    }
                    if ((i6 & 306783379) == 306783378) {
                    }
                    if (i19 == 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i10 != 0) {
                    }
                    final int i2022 = i11;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488059648, "CC(remember):MotionLayout.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                    }
                    MutableLongState mutableLongState22 = (MutableLongState) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    long longValue42 = mutableLongState22.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488057458, "CC(remember):MotionLayout.kt#9igjgp");
                    int i2122 = i6 & 14;
                    final Modifier modifier322 = companion;
                    changed = (i2122 != 4) | startRestartGroup.changed(longValue42);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue2 = motionScene.getTransitionInstance("default");
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    transition = (Transition) rememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    long longValue222 = mutableLongState22.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488052710, "CC(remember):MotionLayout.kt#9igjgp");
                    changed2 = (i2122 != 4) | startRestartGroup.changed(longValue222);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!changed2) {
                    }
                    if (transition != null) {
                    }
                    String str222 = TtmlNode.START;
                    rememberedValue3 = motionScene.getConstraintSetInstance(str222);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                    constraintSet = (ConstraintSet) rememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    int i2222 = i6;
                    long longValue322 = mutableLongState22.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488045710, "CC(remember):MotionLayout.kt#9igjgp");
                    changed3 = startRestartGroup.changed(longValue322) | (i2122 != 4);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (!changed3) {
                    }
                    if (transition != null) {
                    }
                    String str322 = TtmlNode.END;
                    rememberedValue4 = motionScene.getConstraintSetInstance(str322);
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                    ConstraintSet constraintSet222 = (ConstraintSet) rememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    if (constraintSet != null) {
                    }
                    final Function0<Unit> function0422 = obj2;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                if ((i5 & 256) == 0) {
                }
                i6 |= i12;
                if ((i5 & 512) != 0) {
                }
                if ((i5 & 1024) == 0) {
                }
                if ((i6 & 306783379) == 306783378) {
                }
                if (i19 == 0) {
                }
                if (i13 != 0) {
                }
                if (i8 == 0) {
                }
                if (i10 != 0) {
                }
                final int i20222 = i11;
                if (ComposerKt.isTraceInProgress()) {
                }
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488059648, "CC(remember):MotionLayout.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                }
                MutableLongState mutableLongState222 = (MutableLongState) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                long longValue422 = mutableLongState222.getLongValue();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488057458, "CC(remember):MotionLayout.kt#9igjgp");
                int i21222 = i6 & 14;
                final Modifier modifier3222 = companion;
                changed = (i21222 != 4) | startRestartGroup.changed(longValue422);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue2 = motionScene.getTransitionInstance("default");
                startRestartGroup.updateRememberedValue(rememberedValue2);
                transition = (Transition) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                long longValue2222 = mutableLongState222.getLongValue();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488052710, "CC(remember):MotionLayout.kt#9igjgp");
                changed2 = (i21222 != 4) | startRestartGroup.changed(longValue2222);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed2) {
                }
                if (transition != null) {
                }
                String str2222 = TtmlNode.START;
                rememberedValue3 = motionScene.getConstraintSetInstance(str2222);
                startRestartGroup.updateRememberedValue(rememberedValue3);
                constraintSet = (ConstraintSet) rememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                int i22222 = i6;
                long longValue3222 = mutableLongState222.getLongValue();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488045710, "CC(remember):MotionLayout.kt#9igjgp");
                changed3 = startRestartGroup.changed(longValue3222) | (i21222 != 4);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!changed3) {
                }
                if (transition != null) {
                }
                String str3222 = TtmlNode.END;
                rememberedValue4 = motionScene.getConstraintSetInstance(str3222);
                startRestartGroup.updateRememberedValue(rememberedValue4);
                ConstraintSet constraintSet2222 = (ConstraintSet) rememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                if (constraintSet != null) {
                }
                final Function0<Unit> function04222 = obj2;
                if (ComposerKt.isTraceInProgress()) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            obj2 = function0;
            i8 = i5 & 32;
            if (i8 != 0) {
            }
            i10 = i5 & 64;
            if (i10 != 0) {
            }
            if ((i5 & 128) != 0) {
            }
            if ((i5 & 256) == 0) {
            }
            i6 |= i12;
            if ((i5 & 512) != 0) {
            }
            if ((i5 & 1024) == 0) {
            }
            if ((i6 & 306783379) == 306783378) {
            }
            if (i19 == 0) {
            }
            if (i13 != 0) {
            }
            if (i8 == 0) {
            }
            if (i10 != 0) {
            }
            final int i202222 = i11;
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488059648, "CC(remember):MotionLayout.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
            }
            MutableLongState mutableLongState2222 = (MutableLongState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            long longValue4222 = mutableLongState2222.getLongValue();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488057458, "CC(remember):MotionLayout.kt#9igjgp");
            int i212222 = i6 & 14;
            final Modifier modifier32222 = companion;
            changed = (i212222 != 4) | startRestartGroup.changed(longValue4222);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue2 = motionScene.getTransitionInstance("default");
            startRestartGroup.updateRememberedValue(rememberedValue2);
            transition = (Transition) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            long longValue22222 = mutableLongState2222.getLongValue();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488052710, "CC(remember):MotionLayout.kt#9igjgp");
            changed2 = (i212222 != 4) | startRestartGroup.changed(longValue22222);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            if (transition != null) {
            }
            String str22222 = TtmlNode.START;
            rememberedValue3 = motionScene.getConstraintSetInstance(str22222);
            startRestartGroup.updateRememberedValue(rememberedValue3);
            constraintSet = (ConstraintSet) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int i222222 = i6;
            long longValue32222 = mutableLongState2222.getLongValue();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488045710, "CC(remember):MotionLayout.kt#9igjgp");
            changed3 = startRestartGroup.changed(longValue32222) | (i212222 != 4);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (!changed3) {
            }
            if (transition != null) {
            }
            String str32222 = TtmlNode.END;
            rememberedValue4 = motionScene.getConstraintSetInstance(str32222);
            startRestartGroup.updateRememberedValue(rememberedValue4);
            ConstraintSet constraintSet22222 = (ConstraintSet) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (constraintSet != null) {
            }
            final Function0<Unit> function042222 = obj2;
            if (ComposerKt.isTraceInProgress()) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = modifier;
        i7 = i5 & 16;
        if (i7 == 0) {
        }
        obj2 = function0;
        i8 = i5 & 32;
        if (i8 != 0) {
        }
        i10 = i5 & 64;
        if (i10 != 0) {
        }
        if ((i5 & 128) != 0) {
        }
        if ((i5 & 256) == 0) {
        }
        i6 |= i12;
        if ((i5 & 512) != 0) {
        }
        if ((i5 & 1024) == 0) {
        }
        if ((i6 & 306783379) == 306783378) {
        }
        if (i19 == 0) {
        }
        if (i13 != 0) {
        }
        if (i8 == 0) {
        }
        if (i10 != 0) {
        }
        final int i2022222 = i11;
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488059648, "CC(remember):MotionLayout.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
        }
        MutableLongState mutableLongState22222 = (MutableLongState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        long longValue42222 = mutableLongState22222.getLongValue();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488057458, "CC(remember):MotionLayout.kt#9igjgp");
        int i2122222 = i6 & 14;
        final Modifier modifier322222 = companion;
        changed = (i2122222 != 4) | startRestartGroup.changed(longValue42222);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue2 = motionScene.getTransitionInstance("default");
        startRestartGroup.updateRememberedValue(rememberedValue2);
        transition = (Transition) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        long longValue222222 = mutableLongState22222.getLongValue();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488052710, "CC(remember):MotionLayout.kt#9igjgp");
        changed2 = (i2122222 != 4) | startRestartGroup.changed(longValue222222);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        if (transition != null) {
        }
        String str222222 = TtmlNode.START;
        rememberedValue3 = motionScene.getConstraintSetInstance(str222222);
        startRestartGroup.updateRememberedValue(rememberedValue3);
        constraintSet = (ConstraintSet) rememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        int i2222222 = i6;
        long longValue322222 = mutableLongState22222.getLongValue();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -488045710, "CC(remember):MotionLayout.kt#9igjgp");
        changed3 = startRestartGroup.changed(longValue322222) | (i2122222 != 4);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changed3) {
        }
        if (transition != null) {
        }
        String str322222 = TtmlNode.END;
        rememberedValue4 = motionScene.getConstraintSetInstance(str322222);
        startRestartGroup.updateRememberedValue(rememberedValue4);
        ConstraintSet constraintSet222222 = (ConstraintSet) rememberedValue4;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        if (constraintSet != null) {
        }
        final Function0<Unit> function0422222 = obj2;
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConstraintSet MotionLayoutCore_TEds9UA$lambda$14(MutableState<ConstraintSet> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConstraintSet MotionLayoutCore_TEds9UA$lambda$17(MutableState<ConstraintSet> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MotionLayoutCore_TEds9UA$lambda$23(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MotionLayoutCore_TEds9UA$lambda$24(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* renamed from: MotionLayoutCore-SehEMGo  reason: not valid java name */
    public static final void m7102MotionLayoutCoreSehEMGo(final MotionScene motionScene, final float f, final String str, final int i, final int i2, final Modifier modifier, final MutableState<Unit> mutableState, final Ref<CompositionSource> ref, final InvalidationStrategy invalidationStrategy, final Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3) {
        int i4;
        float f2;
        int i5;
        int i6;
        Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function32;
        String str2;
        String str3;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1160212844);
        ComposerKt.sourceInformation(startRestartGroup, "C(MotionLayoutCore)P(6,8,9,7,3:androidx.constraintlayout.compose.DebugFlags,5,2!1,4)525@22091L91,528@22208L178,533@22409L170,541@22646L585:MotionLayout.kt#fysre8");
        if ((i3 & 6) == 0) {
            i4 = (startRestartGroup.changed(motionScene) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            f2 = f;
            i4 |= startRestartGroup.changed(f2) ? 32 : 16;
        } else {
            f2 = f;
        }
        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i5 = i;
            i4 |= startRestartGroup.changed(i5) ? 2048 : 1024;
        } else {
            i5 = i;
        }
        if ((i3 & 24576) == 0) {
            i6 = i2;
            i4 |= startRestartGroup.changed(i6) ? 16384 : 8192;
        } else {
            i6 = i2;
        }
        if ((196608 & i3) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            i4 |= startRestartGroup.changed(mutableState) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i4 |= (16777216 & i3) == 0 ? startRestartGroup.changed(ref) : startRestartGroup.changedInstance(ref) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            i4 |= startRestartGroup.changedInstance(invalidationStrategy) ? 67108864 : 33554432;
        }
        if ((805306368 & i3) == 0) {
            function32 = function3;
            i4 |= startRestartGroup.changedInstance(function32) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        } else {
            function32 = function3;
        }
        if ((i4 & 306783379) != 306783378 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1160212844, i4, -1, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:523)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -487955784, "CC(remember):MotionLayout.kt#9igjgp");
            int i7 = i4 & 14;
            int i8 = i4;
            boolean z = ((i4 & 896) == 256) | (i7 == 4);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = motionScene.getTransitionInstance(str);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Transition transition = (Transition) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -487951953, "CC(remember):MotionLayout.kt#9igjgp");
            boolean changed = (i7 == 4) | startRestartGroup.changed(transition);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                if (transition == null || (str2 = transition.getStartConstraintSetId()) == null) {
                    str2 = TtmlNode.START;
                }
                rememberedValue2 = motionScene.getConstraintSetInstance(str2);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ConstraintSet constraintSet = (ConstraintSet) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -487945529, "CC(remember):MotionLayout.kt#9igjgp");
            boolean changed2 = (i7 == 4) | startRestartGroup.changed(transition);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                if (transition == null || (str3 = transition.getEndConstraintSetId()) == null) {
                    str3 = TtmlNode.END;
                }
                rememberedValue3 = motionScene.getConstraintSetInstance(str3);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ConstraintSet constraintSet2 = (ConstraintSet) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (constraintSet == null || constraintSet2 == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$5
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i9) {
                            MotionLayoutKt.m7102MotionLayoutCoreSehEMGo(MotionScene.this, f, str, i, i2, modifier, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
                        }
                    });
                    return;
                }
                return;
            }
            composer2 = startRestartGroup;
            int i9 = i8 >> 18;
            MotionLayoutCore(constraintSet, constraintSet2, transition, f2, motionScene instanceof LayoutInformationReceiver ? (LayoutInformationReceiver) motionScene : null, i5, DebugFlags.m7033getShowBoundsimpl(i6), DebugFlags.m7035getShowPathsimpl(i2), DebugFlags.m7034getShowKeyPositionsimpl(i2), modifier, mutableState, ref, invalidationStrategy, function32, composer2, ((i8 << 6) & 465920) | ((i8 << 12) & 1879048192), (i9 & 14) | (Ref.$stable << 3) | (i9 & 112) | (i9 & 896) | (i9 & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$6
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i10) {
                    MotionLayoutKt.m7102MotionLayoutCoreSehEMGo(MotionScene.this, f, str, i, i2, modifier, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x03d3  */
    /* JADX WARN: Type inference failed for: r8v41 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MotionLayoutCore(final ConstraintSet constraintSet, final ConstraintSet constraintSet2, final Transition transition, final float f, final LayoutInformationReceiver layoutInformationReceiver, final int i, final boolean z, final boolean z2, final boolean z3, final Modifier modifier, final MutableState<Unit> mutableState, final Ref<CompositionSource> ref, final InvalidationStrategy invalidationStrategy, final Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i2, final int i3) {
        int i4;
        ConstraintSet constraintSet3;
        int i5;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean changedInstance;
        Object rememberedValue;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-657259923);
        ComposerKt.sourceInformation(startRestartGroup, "C(MotionLayoutCore)P(12,3,13,8,4,7,9,11,10,6,2!1,5)578@23851L50,581@24073L35,585@24258L128,590@24419L7,591@24474L7,592@24501L36,593@24554L56,595@24616L328,675@27568L33,677@27660L19,660@26979L706:MotionLayout.kt#fysre8");
        if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(constraintSet) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            constraintSet3 = constraintSet2;
            i4 |= startRestartGroup.changed(constraintSet3) ? 32 : 16;
        } else {
            constraintSet3 = constraintSet2;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changed(transition) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= startRestartGroup.changed(f) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= (32768 & i2) == 0 ? startRestartGroup.changed(layoutInformationReceiver) : startRestartGroup.changedInstance(layoutInformationReceiver) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i4 |= startRestartGroup.changed(i) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= startRestartGroup.changed(z) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i4 |= startRestartGroup.changed(z2) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i4 |= startRestartGroup.changed(z3) ? 67108864 : 33554432;
        }
        if ((i2 & 805306368) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i3 & 6) == 0) {
            i5 = i3 | (startRestartGroup.changed(mutableState) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= (i3 & 64) == 0 ? startRestartGroup.changed(ref) : startRestartGroup.changedInstance(ref) ? 32 : 16;
        }
        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i5 |= startRestartGroup.changedInstance(invalidationStrategy) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i5 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        int i6 = i5;
        if ((i4 & 306783379) != 306783378 || (i6 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-657259923, i4, i6, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:577)");
            }
            int i7 = i4 >> 9;
            MutableFloatState createAndUpdateMotionProgress = createAndUpdateMotionProgress(f, startRestartGroup, i7 & 14);
            TransitionImpl transitionImpl = transition instanceof TransitionImpl ? (TransitionImpl) transition : null;
            if (transitionImpl == null) {
                transitionImpl = TransitionImpl.Companion.getEMPTY$constraintlayout_compose_release();
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -487892416, "CC(remember):MotionLayout.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotLongStateKt.mutableLongStateOf(0L);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableLongState mutableLongState = (MutableLongState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            mutableLongState.getLongValue();
            if (layoutInformationReceiver != null) {
                layoutInformationReceiver.setUpdateFlag(mutableLongState);
            }
            UpdateWithForcedIfNoUserChange(createAndUpdateMotionProgress, layoutInformationReceiver, startRestartGroup, i7 & 112);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -487878719, "CC(remember):MotionLayout.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new MotionMeasurer(density);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MotionMeasurer motionMeasurer = (MotionMeasurer) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -487877003, "CC(remember):MotionLayout.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new MotionLayoutScope(motionMeasurer, createAndUpdateMotionProgress);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MotionLayoutScope motionLayoutScope = (MotionLayoutScope) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -487874747, "CC(remember):MotionLayout.kt#9igjgp");
            boolean z8 = ((i4 & 14) == 4) | ((i4 & 112) == 32) | ((i4 & 896) == 256);
            boolean rememberedValue5 = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue5 == Composer.Companion.getEmpty()) {
                TransitionImpl transitionImpl2 = transitionImpl;
                motionMeasurer.initWith(constraintSet, constraintSet3, layoutDirection, transitionImpl2, createAndUpdateMotionProgress.getFloatValue());
                transitionImpl = transitionImpl2;
                rememberedValue5 = true;
                startRestartGroup.updateRememberedValue(true);
            }
            ((Boolean) rememberedValue5).booleanValue();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.startReplaceGroup(-487863565);
            ComposerKt.sourceInformation(startRestartGroup, "608@25061L631");
            if (invalidationStrategy.getOnObservedStateChange() != null) {
                Snapshot.Companion companion = Snapshot.Companion;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -487860204, "CC(remember):MotionLayout.kt#9igjgp");
                boolean z9 = ((i6 & 14) == 4) | ((i6 & 112) == 32 || ((i6 & 64) != 0 && startRestartGroup.changedInstance(ref)));
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (z9 || rememberedValue6 == Composer.Companion.getEmpty()) {
                    rememberedValue6 = (Function1) new Function1<Object, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$8$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                            invoke2(obj);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(Object obj) {
                            mutableState.setValue(Unit.INSTANCE);
                            if (ref.getValue() == CompositionSource.Unknown) {
                                ref.setValue(CompositionSource.Content);
                            }
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Snapshot.Companion.observe$default(companion, rememberedValue6, null, invalidationStrategy.getOnObservedStateChange(), 2, null);
            }
            startRestartGroup.endReplaceGroup();
            MeasurePolicy motionLayoutMeasurePolicy = motionLayoutMeasurePolicy(mutableState, ref, constraintSet, constraintSet2, transitionImpl, createAndUpdateMotionProgress, motionMeasurer, i, invalidationStrategy);
            motionMeasurer.addLayoutInformationReceiver(layoutInformationReceiver);
            MotionLayoutDebugFlags forcedDrawDebug = layoutInformationReceiver != null ? layoutInformationReceiver.getForcedDrawDebug() : null;
            float forcedScaleFactor = motionMeasurer.getForcedScaleFactor();
            if (forcedDrawDebug == null || forcedDrawDebug == MotionLayoutDebugFlags.UNKNOWN) {
                z4 = z;
                z5 = z3;
                z6 = z2;
            } else {
                z4 = forcedDrawDebug == MotionLayoutDebugFlags.SHOW_ALL;
                z6 = z4;
                z5 = z6;
            }
            startRestartGroup.startReplaceGroup(-487805395);
            ComposerKt.sourceInformation(startRestartGroup, "654@26894L7");
            if (Build.VERSION.SDK_INT >= 30) {
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume3 = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                if (Api30Impl.isShowingLayoutBounds((View) consume3)) {
                    z7 = true;
                    startRestartGroup.endReplaceGroup();
                    Modifier motionPointerInput = MotionDragHandlerKt.motionPointerInput(motionDebug(modifier, motionMeasurer, forcedScaleFactor, !z7 ? true : z4, z6, z5), transition != null ? TransitionImpl.Companion.getEMPTY$constraintlayout_compose_release() : transition, createAndUpdateMotionProgress, motionMeasurer);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -487780578, "CC(remember):MotionLayout.kt#9igjgp");
                    changedInstance = startRestartGroup.changedInstance(motionMeasurer);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$9$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, MotionMeasurer.this);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    composer2 = startRestartGroup;
                    LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(motionPointerInput, false, (Function1) rememberedValue, 1, null), ComposableLambdaKt.rememberComposableLambda(1008059664, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$10
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i8) {
                            ComposerKt.sourceInformation(composer3, "C677@27668L9:MotionLayout.kt#fysre8");
                            if ((i8 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1008059664, i8, -1, "androidx.constraintlayout.compose.MotionLayoutCore.<anonymous> (MotionLayout.kt:677)");
                            }
                            function3.invoke(motionLayoutScope, composer3, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), motionLayoutMeasurePolicy, composer2, 48, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }
            z7 = false;
            startRestartGroup.endReplaceGroup();
            Modifier motionPointerInput2 = MotionDragHandlerKt.motionPointerInput(motionDebug(modifier, motionMeasurer, forcedScaleFactor, !z7 ? true : z4, z6, z5), transition != null ? TransitionImpl.Companion.getEMPTY$constraintlayout_compose_release() : transition, createAndUpdateMotionProgress, motionMeasurer);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -487780578, "CC(remember):MotionLayout.kt#9igjgp");
            changedInstance = startRestartGroup.changedInstance(motionMeasurer);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changedInstance) {
            }
            rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$9$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, MotionMeasurer.this);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            composer2 = startRestartGroup;
            LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(motionPointerInput2, false, (Function1) rememberedValue, 1, null), ComposableLambdaKt.rememberComposableLambda(1008059664, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$10
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i8) {
                    ComposerKt.sourceInformation(composer3, "C677@27668L9:MotionLayout.kt#fysre8");
                    if ((i8 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1008059664, i8, -1, "androidx.constraintlayout.compose.MotionLayoutCore.<anonymous> (MotionLayout.kt:677)");
                    }
                    function3.invoke(motionLayoutScope, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), motionLayoutMeasurePolicy, composer2, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$11
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i8) {
                    MotionLayoutKt.MotionLayoutCore(ConstraintSet.this, constraintSet2, transition, f, layoutInformationReceiver, i, z, z2, z3, modifier, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
                }
            });
        }
    }

    public static final MeasurePolicy motionLayoutMeasurePolicy(final androidx.compose.runtime.State<Unit> state, final Ref<CompositionSource> ref, final ConstraintSet constraintSet, final ConstraintSet constraintSet2, final TransitionImpl transitionImpl, final MutableFloatState mutableFloatState, final MotionMeasurer motionMeasurer, final int i, final InvalidationStrategy invalidationStrategy) {
        return new MeasurePolicy() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$motionLayoutMeasurePolicy$1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo42measure3p2s80s(MeasureScope measureScope, final List<? extends Measurable> list, long j) {
                final LinkedHashMap linkedHashMap = new LinkedHashMap();
                state.getValue();
                MotionMeasurer motionMeasurer2 = motionMeasurer;
                LayoutDirection layoutDirection = measureScope.getLayoutDirection();
                ConstraintSet constraintSet3 = constraintSet;
                ConstraintSet constraintSet4 = constraintSet2;
                TransitionImpl transitionImpl2 = transitionImpl;
                int i2 = i;
                float floatValue = mutableFloatState.getFloatValue();
                CompositionSource value = ref.getValue();
                if (value == null) {
                    value = CompositionSource.Unknown;
                }
                long m7126performInterpolationMeasureLzAeyeM = motionMeasurer2.m7126performInterpolationMeasureLzAeyeM(j, layoutDirection, constraintSet3, constraintSet4, transitionImpl2, list, linkedHashMap, i2, floatValue, value, invalidationStrategy.getShouldInvalidate$constraintlayout_compose_release());
                ref.setValue(CompositionSource.Unknown);
                int m6855getWidthimpl = IntSize.m6855getWidthimpl(m7126performInterpolationMeasureLzAeyeM);
                int m6854getHeightimpl = IntSize.m6854getHeightimpl(m7126performInterpolationMeasureLzAeyeM);
                final MotionMeasurer motionMeasurer3 = motionMeasurer;
                return MeasureScope.layout$default(measureScope, m6855getWidthimpl, m6854getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$motionLayoutMeasurePolicy$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope placementScope) {
                        MotionMeasurer.this.performLayout(placementScope, list, linkedHashMap);
                    }
                }, 4, null);
            }
        };
    }

    public static final void UpdateWithForcedIfNoUserChange(final MutableFloatState mutableFloatState, final LayoutInformationReceiver layoutInformationReceiver, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1501096015);
        ComposerKt.sourceInformation(startRestartGroup, "C(UpdateWithForcedIfNoUserChange)P(1)1027@41345L63:MotionLayout.kt#fysre8");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(mutableFloatState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(layoutInformationReceiver) : startRestartGroup.changedInstance(layoutInformationReceiver) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1501096015, i2, -1, "androidx.constraintlayout.compose.UpdateWithForcedIfNoUserChange (MotionLayout.kt:1019)");
            }
            if (layoutInformationReceiver == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$UpdateWithForcedIfNoUserChange$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i3) {
                            MotionLayoutKt.UpdateWithForcedIfNoUserChange(MutableFloatState.this, layoutInformationReceiver, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                        }
                    });
                    return;
                }
                return;
            }
            float floatValue = mutableFloatState.getFloatValue();
            float forcedProgress = layoutInformationReceiver.getForcedProgress();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 744491742, "CC(remember):MotionLayout.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            Ref ref = rememberedValue;
            if (rememberedValue == Composer.Companion.getEmpty()) {
                Ref ref2 = new Ref();
                ref2.setValue(Float.valueOf(floatValue));
                startRestartGroup.updateRememberedValue(ref2);
                ref = ref2;
            }
            Ref ref3 = (Ref) ref;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (!Float.isNaN(forcedProgress) && Intrinsics.areEqual((Float) ref3.getValue(), floatValue)) {
                mutableFloatState.setFloatValue(forcedProgress);
            } else {
                layoutInformationReceiver.resetForcedProgress();
            }
            ref3.setValue(Float.valueOf(floatValue));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$UpdateWithForcedIfNoUserChange$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    MotionLayoutKt.UpdateWithForcedIfNoUserChange(MutableFloatState.this, layoutInformationReceiver, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final MutableFloatState createAndUpdateMotionProgress(float f, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1721363510, "C(createAndUpdateMotionProgress)1047@42189L42,1048@42247L52:MotionLayout.kt#fysre8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1721363510, i, -1, "androidx.constraintlayout.compose.createAndUpdateMotionProgress (MotionLayout.kt:1046)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 346861427, "CC(remember):MotionLayout.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableFloatState mutableFloatState = (MutableFloatState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 346863293, "CC(remember):MotionLayout.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        Object obj = rememberedValue2;
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            Ref.FloatRef floatRef = new Ref.FloatRef();
            floatRef.element = f;
            composer.updateRememberedValue(floatRef);
            obj = floatRef;
        }
        Ref.FloatRef floatRef2 = (Ref.FloatRef) obj;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (floatRef2.element != f) {
            floatRef2.element = f;
            mutableFloatState.setFloatValue(f);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mutableFloatState;
    }

    public static final Modifier motionDebug(Modifier modifier, final MotionMeasurer motionMeasurer, float f, final boolean z, final boolean z2, final boolean z3) {
        if (!Float.isNaN(f)) {
            modifier = ScaleKt.scale(modifier, f);
        }
        return (z || z3 || z2) ? DrawModifierKt.drawBehind(modifier, new Function1<DrawScope, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$motionDebug$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawScope) {
                MotionMeasurer.this.drawDebug(drawScope, z, z2, z3);
            }
        }) : modifier;
    }
}
