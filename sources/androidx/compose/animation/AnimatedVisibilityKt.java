package androidx.compose.animation;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: AnimatedVisibility.kt */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a[\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a_\u0010\u0000\u001a\u00020\u0001*\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0013\u001a_\u0010\u0000\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0015\u001aa\u0010\u0000\u001a\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0018\u001ae\u0010\u0000\u001a\u00020\u0001*\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0019\u001ae\u0010\u0000\u001a\u00020\u0001*\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001a\u001am\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u001c2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00030\r2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001d\u001ak\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001c2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010 \u001a\u0091\u0001\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001c2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00030#2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010'\u001a9\u0010+\u001a\u00020$\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u001c2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010,\u001a\u0002H\u001bH\u0003¢\u0006\u0002\u0010-\"\u001e\u0010(\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020$0\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006.²\u0006\u001c\u0010/\u001a\u0014\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00030#X\u008a\u0084\u0002²\u0006\n\u00100\u001a\u00020\u0003X\u008a\u0084\u0002"}, d2 = {"AnimatedVisibility", "", "visible", "", "modifier", "Landroidx/compose/ui/Modifier;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", Constants.ScionAnalytics.PARAM_LABEL, "", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedVisibilityScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/RowScope;", "(Landroidx/compose/foundation/layout/RowScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "visibleState", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/ColumnScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/animation/core/Transition;", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "AnimatedVisibilityImpl", "transition", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "AnimatedEnterExitImpl", "shouldDisposeBlock", "Lkotlin/Function2;", "Landroidx/compose/animation/EnterExitState;", "onLookaheadMeasured", "Landroidx/compose/animation/OnLookaheadMeasured;", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function2;Landroidx/compose/animation/OnLookaheadMeasured;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "exitFinished", "getExitFinished", "(Landroidx/compose/animation/core/Transition;)Z", "targetEnterExit", "targetState", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterExitState;", "animation", "shouldDisposeBlockUpdated", "shouldDisposeAfterExit"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnimatedVisibilityKt {
    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0192  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedVisibility(boolean z, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        final boolean z2;
        int i3;
        Object obj;
        int i4;
        Object obj2;
        int i5;
        Object obj3;
        int i6;
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32;
        final String str2;
        final Modifier modifier2;
        final EnterTransition enterTransition2;
        final ExitTransition exitTransition2;
        ScopeUpdateScope endRestartGroup;
        int i7;
        Modifier.Companion companion;
        Composer startRestartGroup = composer.startRestartGroup(-1448730565);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)131@7032L32,132@7104L6,132@7069L84:AnimatedVisibility.kt#xbi5r1");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z2 = z;
        } else if ((i & 6) == 0) {
            z2 = z;
            i3 = (startRestartGroup.changed(z2) ? 4 : 2) | i;
        } else {
            z2 = z;
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj2 = enterTransition;
                i3 |= startRestartGroup.changed(obj2) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    obj3 = exitTransition;
                    i3 |= startRestartGroup.changed(obj3) ? 2048 : 1024;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        i3 |= startRestartGroup.changed(str) ? 16384 : 8192;
                        if ((i2 & 32) != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            function32 = function3;
                        } else {
                            function32 = function3;
                            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i3 |= startRestartGroup.changedInstance(function32) ? 131072 : 65536;
                            }
                        }
                        if (!startRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
                            startRestartGroup.skipToGroupEnd();
                            str2 = str;
                            modifier2 = obj;
                            enterTransition2 = obj2;
                            exitTransition2 = obj3;
                        } else {
                            if (i8 != 0) {
                                companion = Modifier.Companion;
                                i7 = i6;
                            } else {
                                i7 = i6;
                                companion = obj;
                            }
                            EnterTransition plus = i4 != 0 ? EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null)) : obj2;
                            ExitTransition plus2 = i5 != 0 ? EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)) : obj3;
                            String str3 = i7 != 0 ? "AnimatedVisibility" : str;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1448730565, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:130)");
                            }
                            Transition updateTransition = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str3, startRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -660656063, "CC(remember):AnimatedVisibility.kt#9igjgp");
                            AnimatedVisibilityKt$AnimatedVisibility$1$1 rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1$1
                                    public final Boolean invoke(boolean z3) {
                                        return Boolean.valueOf(z3);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                        return invoke(bool.booleanValue());
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i9 = i3 << 3;
                            AnimatedVisibilityImpl(updateTransition, (Function1) rememberedValue, companion, plus, plus2, function32, startRestartGroup, (i9 & 57344) | (i9 & 896) | 48 | (i9 & 7168) | (i3 & 458752));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str2 = str3;
                            modifier2 = companion;
                            enterTransition2 = plus;
                            exitTransition2 = plus2;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i10) {
                                    AnimatedVisibilityKt.AnimatedVisibility(z2, modifier2, enterTransition2, exitTransition2, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj3 = exitTransition;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (!startRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj2 = enterTransition;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            obj3 = exitTransition;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (!startRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        obj2 = enterTransition;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        obj3 = exitTransition;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (!startRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x018b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedVisibility(final RowScope rowScope, boolean z, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        final boolean z2;
        int i3;
        Object obj;
        int i4;
        Object obj2;
        int i5;
        Object obj3;
        int i6;
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32;
        final Modifier modifier2;
        final EnterTransition enterTransition2;
        final ExitTransition exitTransition2;
        final String str2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(234057107);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)205@11418L32,206@11490L6,206@11455L84:AnimatedVisibility.kt#xbi5r1");
        if ((i2 & 1) != 0) {
            i3 = i | 48;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 48) == 0) {
                i3 = (startRestartGroup.changed(z2) ? 32 : 16) | i;
            } else {
                i3 = i;
            }
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 256 : 128;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                obj2 = enterTransition;
                i3 |= startRestartGroup.changed(obj2) ? 2048 : 1024;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    obj3 = exitTransition;
                    i3 |= startRestartGroup.changed(obj3) ? 16384 : 8192;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((196608 & i) == 0) {
                        i3 |= startRestartGroup.changed(str) ? 131072 : 65536;
                        if ((i2 & 32) != 0) {
                            i3 |= 1572864;
                            function32 = function3;
                        } else {
                            function32 = function3;
                            if ((i & 1572864) == 0) {
                                i3 |= startRestartGroup.changedInstance(function32) ? 1048576 : 524288;
                            }
                        }
                        if (!startRestartGroup.shouldExecute((599185 & i3) != 599184, i3 & 1)) {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = obj;
                            enterTransition2 = obj2;
                            exitTransition2 = obj3;
                            str2 = str;
                        } else {
                            Modifier.Companion companion = i7 != 0 ? Modifier.Companion : obj;
                            if (i4 != 0) {
                                obj2 = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null));
                            }
                            ExitTransition plus = i5 != 0 ? EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null)) : obj3;
                            String str3 = i6 != 0 ? "AnimatedVisibility" : str;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(234057107, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:204)");
                            }
                            int i8 = i3 >> 3;
                            Transition updateTransition = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str3, startRestartGroup, (i8 & 14) | ((i3 >> 12) & 112), 0);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1590594329, "CC(remember):AnimatedVisibility.kt#9igjgp");
                            AnimatedVisibilityKt$AnimatedVisibility$3$1 rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3$1
                                    public final Boolean invoke(boolean z3) {
                                        return Boolean.valueOf(z3);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                        return invoke(bool.booleanValue());
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            EnterTransition enterTransition3 = obj2;
                            AnimatedVisibilityImpl(updateTransition, (Function1) rememberedValue, companion, enterTransition3, plus, function32, startRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i8));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str2 = str3;
                            modifier2 = companion;
                            enterTransition2 = enterTransition3;
                            exitTransition2 = plus;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$4
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i9) {
                                    AnimatedVisibilityKt.AnimatedVisibility(RowScope.this, z2, modifier2, enterTransition2, exitTransition2, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((599185 & i3) != 599184, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj3 = exitTransition;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (!startRestartGroup.shouldExecute((599185 & i3) != 599184, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj2 = enterTransition;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            obj3 = exitTransition;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (!startRestartGroup.shouldExecute((599185 & i3) != 599184, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        obj2 = enterTransition;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        obj3 = exitTransition;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (!startRestartGroup.shouldExecute((599185 & i3) != 599184, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x018b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedVisibility(final ColumnScope columnScope, boolean z, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        final boolean z2;
        int i3;
        Object obj;
        int i4;
        Object obj2;
        int i5;
        Object obj3;
        int i6;
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32;
        final Modifier modifier2;
        final EnterTransition enterTransition2;
        final ExitTransition exitTransition2;
        final String str2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1799879339);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)278@15785L32,279@15857L6,279@15822L84:AnimatedVisibility.kt#xbi5r1");
        if ((i2 & 1) != 0) {
            i3 = i | 48;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 48) == 0) {
                i3 = (startRestartGroup.changed(z2) ? 32 : 16) | i;
            } else {
                i3 = i;
            }
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 256 : 128;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                obj2 = enterTransition;
                i3 |= startRestartGroup.changed(obj2) ? 2048 : 1024;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    obj3 = exitTransition;
                    i3 |= startRestartGroup.changed(obj3) ? 16384 : 8192;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((196608 & i) == 0) {
                        i3 |= startRestartGroup.changed(str) ? 131072 : 65536;
                        if ((i2 & 32) != 0) {
                            i3 |= 1572864;
                            function32 = function3;
                        } else {
                            function32 = function3;
                            if ((i & 1572864) == 0) {
                                i3 |= startRestartGroup.changedInstance(function32) ? 1048576 : 524288;
                            }
                        }
                        if (!startRestartGroup.shouldExecute((599185 & i3) != 599184, i3 & 1)) {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = obj;
                            enterTransition2 = obj2;
                            exitTransition2 = obj3;
                            str2 = str;
                        } else {
                            Modifier.Companion companion = i7 != 0 ? Modifier.Companion : obj;
                            if (i4 != 0) {
                                obj2 = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                            }
                            ExitTransition plus = i5 != 0 ? EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null)) : obj3;
                            String str3 = i6 != 0 ? "AnimatedVisibility" : str;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1799879339, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:277)");
                            }
                            int i8 = i3 >> 3;
                            Transition updateTransition = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str3, startRestartGroup, (i8 & 14) | ((i3 >> 12) & 112), 0);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1187761711, "CC(remember):AnimatedVisibility.kt#9igjgp");
                            AnimatedVisibilityKt$AnimatedVisibility$5$1 rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5$1
                                    public final Boolean invoke(boolean z3) {
                                        return Boolean.valueOf(z3);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                        return invoke(bool.booleanValue());
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            EnterTransition enterTransition3 = obj2;
                            AnimatedVisibilityImpl(updateTransition, (Function1) rememberedValue, companion, enterTransition3, plus, function32, startRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i8));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str2 = str3;
                            modifier2 = companion;
                            enterTransition2 = enterTransition3;
                            exitTransition2 = plus;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$6
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i9) {
                                    AnimatedVisibilityKt.AnimatedVisibility(ColumnScope.this, z2, modifier2, enterTransition2, exitTransition2, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((599185 & i3) != 599184, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj3 = exitTransition;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (!startRestartGroup.shouldExecute((599185 & i3) != 599184, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj2 = enterTransition;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            obj3 = exitTransition;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (!startRestartGroup.shouldExecute((599185 & i3) != 599184, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        obj2 = enterTransition;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        obj3 = exitTransition;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (!startRestartGroup.shouldExecute((599185 & i3) != 599184, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x018a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedVisibility(final MutableTransitionState<Boolean> mutableTransitionState, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        int i4;
        Object obj2;
        int i5;
        Object obj3;
        int i6;
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32;
        final String str2;
        final Modifier modifier2;
        final EnterTransition enterTransition2;
        final ExitTransition exitTransition2;
        ScopeUpdateScope endRestartGroup;
        int i7;
        Modifier.Companion companion;
        Composer startRestartGroup = composer.startRestartGroup(657024243);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)377@21247L39,378@21326L6,378@21291L84:AnimatedVisibility.kt#xbi5r1");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? startRestartGroup.changed(mutableTransitionState) : startRestartGroup.changedInstance(mutableTransitionState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj2 = enterTransition;
                i3 |= startRestartGroup.changed(obj2) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    obj3 = exitTransition;
                    i3 |= startRestartGroup.changed(obj3) ? 2048 : 1024;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        i3 |= startRestartGroup.changed(str) ? 16384 : 8192;
                        if ((i2 & 32) != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            function32 = function3;
                        } else {
                            function32 = function3;
                            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i3 |= startRestartGroup.changedInstance(function32) ? 131072 : 65536;
                            }
                        }
                        if (!startRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
                            startRestartGroup.skipToGroupEnd();
                            str2 = str;
                            modifier2 = obj;
                            enterTransition2 = obj2;
                            exitTransition2 = obj3;
                        } else {
                            if (i8 != 0) {
                                companion = Modifier.Companion;
                                i7 = i6;
                            } else {
                                i7 = i6;
                                companion = obj;
                            }
                            EnterTransition plus = i4 != 0 ? EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null)) : obj2;
                            ExitTransition plus2 = i5 != 0 ? EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null)) : obj3;
                            String str3 = i7 != 0 ? "AnimatedVisibility" : str;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(657024243, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:376)");
                            }
                            Transition rememberTransition = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, startRestartGroup, MutableTransitionState.$stable | (i3 & 14) | ((i3 >> 9) & 112), 0);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 40119161, "CC(remember):AnimatedVisibility.kt#9igjgp");
                            AnimatedVisibilityKt$AnimatedVisibility$7$1 rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7$1
                                    public final Boolean invoke(boolean z) {
                                        return Boolean.valueOf(z);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                        return invoke(bool.booleanValue());
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i9 = i3 << 3;
                            AnimatedVisibilityImpl(rememberTransition, (Function1) rememberedValue, companion, plus, plus2, function32, startRestartGroup, (i9 & 57344) | (i9 & 896) | 48 | (i9 & 7168) | (i3 & 458752));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str2 = str3;
                            modifier2 = companion;
                            enterTransition2 = plus;
                            exitTransition2 = plus2;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$8
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i10) {
                                    AnimatedVisibilityKt.AnimatedVisibility(mutableTransitionState, modifier2, enterTransition2, exitTransition2, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj3 = exitTransition;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (!startRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj2 = enterTransition;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            obj3 = exitTransition;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (!startRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        obj2 = enterTransition;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        obj3 = exitTransition;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (!startRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0186  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedVisibility(final RowScope rowScope, final MutableTransitionState<Boolean> mutableTransitionState, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        int i4;
        Object obj2;
        int i5;
        Object obj3;
        int i6;
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32;
        final Modifier modifier2;
        final EnterTransition enterTransition2;
        final ExitTransition exitTransition2;
        final String str2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1763490971);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)449@25685L39,450@25764L6,450@25729L84:AnimatedVisibility.kt#xbi5r1");
        if ((i2 & 1) != 0) {
            i3 = i | 48;
        } else if ((i & 48) == 0) {
            i3 = ((i & 64) == 0 ? startRestartGroup.changed(mutableTransitionState) : startRestartGroup.changedInstance(mutableTransitionState) ? 32 : 16) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 256 : 128;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                obj2 = enterTransition;
                i3 |= startRestartGroup.changed(obj2) ? 2048 : 1024;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    obj3 = exitTransition;
                    i3 |= startRestartGroup.changed(obj3) ? 16384 : 8192;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((196608 & i) == 0) {
                        i3 |= startRestartGroup.changed(str) ? 131072 : 65536;
                        if ((i2 & 32) != 0) {
                            i3 |= 1572864;
                            function32 = function3;
                        } else {
                            function32 = function3;
                            if ((i & 1572864) == 0) {
                                i3 |= startRestartGroup.changedInstance(function32) ? 1048576 : 524288;
                            }
                        }
                        if (!startRestartGroup.shouldExecute((599185 & i3) != 599184, i3 & 1)) {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = obj;
                            enterTransition2 = obj2;
                            exitTransition2 = obj3;
                            str2 = str;
                        } else {
                            Modifier.Companion companion = i7 != 0 ? Modifier.Companion : obj;
                            if (i4 != 0) {
                                obj2 = EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                            }
                            ExitTransition plus = i5 != 0 ? EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)) : obj3;
                            String str3 = i6 != 0 ? "AnimatedVisibility" : str;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1763490971, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:448)");
                            }
                            int i8 = i3 >> 3;
                            Transition rememberTransition = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, startRestartGroup, MutableTransitionState.$stable | (i8 & 14) | ((i3 >> 12) & 112), 0);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1797243743, "CC(remember):AnimatedVisibility.kt#9igjgp");
                            AnimatedVisibilityKt$AnimatedVisibility$9$1 rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9$1
                                    public final Boolean invoke(boolean z) {
                                        return Boolean.valueOf(z);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                        return invoke(bool.booleanValue());
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            EnterTransition enterTransition3 = obj2;
                            AnimatedVisibilityImpl(rememberTransition, (Function1) rememberedValue, companion, enterTransition3, plus, function32, startRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i8));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str2 = str3;
                            modifier2 = companion;
                            enterTransition2 = enterTransition3;
                            exitTransition2 = plus;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$10
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i9) {
                                    AnimatedVisibilityKt.AnimatedVisibility(RowScope.this, mutableTransitionState, modifier2, enterTransition2, exitTransition2, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((599185 & i3) != 599184, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj3 = exitTransition;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (!startRestartGroup.shouldExecute((599185 & i3) != 599184, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj2 = enterTransition;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            obj3 = exitTransition;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (!startRestartGroup.shouldExecute((599185 & i3) != 599184, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        obj2 = enterTransition;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        obj3 = exitTransition;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (!startRestartGroup.shouldExecute((599185 & i3) != 599184, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0186  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedVisibility(final ColumnScope columnScope, final MutableTransitionState<Boolean> mutableTransitionState, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        int i4;
        Object obj2;
        int i5;
        Object obj3;
        int i6;
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32;
        final Modifier modifier2;
        final EnterTransition enterTransition2;
        final ExitTransition exitTransition2;
        final String str2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1238803325);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)523@30218L39,524@30297L6,524@30262L84:AnimatedVisibility.kt#xbi5r1");
        if ((i2 & 1) != 0) {
            i3 = i | 48;
        } else if ((i & 48) == 0) {
            i3 = ((i & 64) == 0 ? startRestartGroup.changed(mutableTransitionState) : startRestartGroup.changedInstance(mutableTransitionState) ? 32 : 16) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 256 : 128;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                obj2 = enterTransition;
                i3 |= startRestartGroup.changed(obj2) ? 2048 : 1024;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    obj3 = exitTransition;
                    i3 |= startRestartGroup.changed(obj3) ? 16384 : 8192;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((196608 & i) == 0) {
                        i3 |= startRestartGroup.changed(str) ? 131072 : 65536;
                        if ((i2 & 32) != 0) {
                            i3 |= 1572864;
                            function32 = function3;
                        } else {
                            function32 = function3;
                            if ((i & 1572864) == 0) {
                                i3 |= startRestartGroup.changedInstance(function32) ? 1048576 : 524288;
                            }
                        }
                        if (!startRestartGroup.shouldExecute((599185 & i3) != 599184, i3 & 1)) {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = obj;
                            enterTransition2 = obj2;
                            exitTransition2 = obj3;
                            str2 = str;
                        } else {
                            Modifier.Companion companion = i7 != 0 ? Modifier.Companion : obj;
                            if (i4 != 0) {
                                obj2 = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                            }
                            ExitTransition plus = i5 != 0 ? EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)) : obj3;
                            String str3 = i6 != 0 ? "AnimatedVisibility" : str;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1238803325, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:522)");
                            }
                            int i8 = i3 >> 3;
                            Transition rememberTransition = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, startRestartGroup, MutableTransitionState.$stable | (i8 & 14) | ((i3 >> 12) & 112), 0);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -784039319, "CC(remember):AnimatedVisibility.kt#9igjgp");
                            AnimatedVisibilityKt$AnimatedVisibility$11$1 rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11$1
                                    public final Boolean invoke(boolean z) {
                                        return Boolean.valueOf(z);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                        return invoke(bool.booleanValue());
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            EnterTransition enterTransition3 = obj2;
                            AnimatedVisibilityImpl(rememberTransition, (Function1) rememberedValue, companion, enterTransition3, plus, function32, startRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i8));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str2 = str3;
                            modifier2 = companion;
                            enterTransition2 = enterTransition3;
                            exitTransition2 = plus;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$12
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i9) {
                                    AnimatedVisibilityKt.AnimatedVisibility(ColumnScope.this, mutableTransitionState, modifier2, enterTransition2, exitTransition2, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((599185 & i3) != 599184, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj3 = exitTransition;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (!startRestartGroup.shouldExecute((599185 & i3) != 599184, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj2 = enterTransition;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            obj3 = exitTransition;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (!startRestartGroup.shouldExecute((599185 & i3) != 599184, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        obj2 = enterTransition;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        obj3 = exitTransition;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (!startRestartGroup.shouldExecute((599185 & i3) != 599184, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> void AnimatedVisibility(final Transition<T> transition, final Function1<? super T, Boolean> function1, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Transition<T> transition2;
        int i3;
        Function1<? super T, Boolean> function12;
        final Object obj;
        int i4;
        Object obj2;
        int i5;
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32;
        final EnterTransition enterTransition2;
        final ExitTransition exitTransition2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1699747442);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedVisibility)P(4,3,1,2)593@34536L79:AnimatedVisibility.kt#xbi5r1");
        if ((i2 & Integer.MIN_VALUE) != 0) {
            i3 = i | 6;
            transition2 = transition;
        } else {
            transition2 = transition;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changed(transition2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 1) != 0) {
            i3 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i & 48) == 0) {
                i3 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
            }
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 256 : 128;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                obj2 = enterTransition;
                i3 |= startRestartGroup.changed(obj2) ? 2048 : 1024;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    i3 |= startRestartGroup.changed(exitTransition) ? 16384 : 8192;
                    if ((i2 & 16) == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        function32 = function3;
                    } else {
                        function32 = function3;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i3 |= startRestartGroup.changedInstance(function32) ? 131072 : 65536;
                        }
                    }
                    if (startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                        startRestartGroup.skipToGroupEnd();
                        enterTransition2 = obj2;
                        exitTransition2 = exitTransition;
                    } else {
                        Modifier.Companion companion = i6 != 0 ? Modifier.Companion : obj;
                        EnterTransition plus = i4 != 0 ? EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null)) : obj2;
                        ExitTransition plus2 = i5 != 0 ? EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)) : exitTransition;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1699747442, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:593)");
                        }
                        EnterTransition enterTransition3 = plus;
                        AnimatedVisibilityImpl(transition2, function12, companion, enterTransition3, plus2, function32, startRestartGroup, i3 & 524286);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        obj = companion;
                        enterTransition2 = enterTransition3;
                        exitTransition2 = plus2;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$13
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i7) {
                                AnimatedVisibilityKt.AnimatedVisibility(transition, function1, obj, enterTransition2, exitTransition2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i2 & 16) == 0) {
                }
                if (startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            obj2 = enterTransition;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            if ((i2 & 16) == 0) {
            }
            if (startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        obj2 = enterTransition;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if (startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final <T> void AnimatedVisibilityImpl(final Transition<T> transition, final Function1<? super T, Boolean> function1, final Modifier modifier, final EnterTransition enterTransition, final ExitTransition exitTransition, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Object obj;
        Composer startRestartGroup = composer.startRestartGroup(1706321816);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedVisibilityImpl)P(4,5,3,1,2)682@38821L423,694@39319L62,678@38691L724:AnimatedVisibility.kt#xbi5r1");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(transition) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(enterTransition) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            obj = exitTransition;
            i2 |= startRestartGroup.changed(obj) ? 16384 : 8192;
        } else {
            obj = exitTransition;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
        }
        if (!startRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1706321816, i2, -1, "androidx.compose.animation.AnimatedVisibilityImpl (AnimatedVisibility.kt:677)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -902228929, "CC(remember):AnimatedVisibility.kt#9igjgp");
            int i3 = i2 & 112;
            int i4 = i2 & 14;
            boolean z = (i3 == 32) | (i4 == 4);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                        return m84invoke3p2s80s(measureScope, measurable, constraints.m7955unboximpl());
                    }

                    /* renamed from: invoke-3p2s80s  reason: not valid java name */
                    public final MeasureResult m84invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                        long m8162constructorimpl;
                        final Placeable mo6698measureBRTryo0 = measurable.mo6698measureBRTryo0(j);
                        if (measureScope.isLookingAhead() && !function1.invoke(transition.getTargetState()).booleanValue()) {
                            m8162constructorimpl = IntSize.Companion.m8172getZeroYbymL2g();
                        } else {
                            m8162constructorimpl = IntSize.m8162constructorimpl((mo6698measureBRTryo0.getWidth() << 32) | (mo6698measureBRTryo0.getHeight() & 4294967295L));
                        }
                        return MeasureScope.layout$default(measureScope, (int) (m8162constructorimpl >> 32), (int) (m8162constructorimpl & 4294967295L), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1.1
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
                                Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier layout = LayoutModifierKt.layout(modifier, (Function3) rememberedValue);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -902213354, "CC(remember):AnimatedVisibility.kt#9igjgp");
            AnimatedVisibilityKt$AnimatedVisibilityImpl$2$1 rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function2<EnterExitState, EnterExitState, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public final Boolean invoke(EnterExitState enterExitState, EnterExitState enterExitState2) {
                        return Boolean.valueOf(enterExitState == enterExitState2 && enterExitState2 == EnterExitState.PostExit);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            AnimatedEnterExitImpl(transition, function1, layout, enterTransition, obj, (Function2) rememberedValue2, null, function3, startRestartGroup, i3 | 196608 | i4 | (i2 & 7168) | (57344 & i2) | ((i2 << 6) & 29360128), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    AnimatedVisibilityKt.AnimatedVisibilityImpl(transition, function1, modifier, enterTransition, exitTransition, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:193:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:198:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> void AnimatedEnterExitImpl(final Transition<T> transition, final Function1<? super T, Boolean> function1, final Modifier modifier, final EnterTransition enterTransition, final ExitTransition exitTransition, final Function2<? super EnterExitState, ? super EnterExitState, Boolean> function2, OnLookaheadMeasured onLookaheadMeasured, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        EnterTransition enterTransition2;
        ExitTransition exitTransition2;
        int i4;
        Composer composer2;
        Object obj;
        ScopeUpdateScope endRestartGroup;
        EnterExitState enterExitState;
        Object obj2;
        int i5;
        final OnLookaheadMeasured onLookaheadMeasured2;
        Modifier.Companion companion;
        Object obj3;
        Object obj4 = onLookaheadMeasured;
        Composer startRestartGroup = composer.startRestartGroup(1912839215);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedEnterExitImpl)P(6,7,3,1,2,5,4):AnimatedVisibility.kt#xbi5r1");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(transition) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
            enterTransition2 = enterTransition;
        } else {
            enterTransition2 = enterTransition;
            if ((i & 3072) == 0) {
                i3 |= startRestartGroup.changed(enterTransition2) ? 2048 : 1024;
            }
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
            exitTransition2 = exitTransition;
        } else {
            exitTransition2 = exitTransition;
            if ((i & 24576) == 0) {
                i3 |= startRestartGroup.changed(exitTransition2) ? 16384 : 8192;
            }
        }
        if ((i2 & 32) != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        int i6 = i2 & 64;
        int i7 = 1572864;
        if (i6 == 0) {
            if ((i & 1572864) == 0) {
                i7 = (i & 2097152) == 0 ? startRestartGroup.changed(obj4) : startRestartGroup.changedInstance(obj4) ? 1048576 : 524288;
            }
            if ((i2 & 128) == 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                i3 |= startRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
            }
            i4 = i3;
            int i8 = 1;
            Object obj5 = obj4;
            if (startRestartGroup.shouldExecute((4793491 & i4) == 4793490, i4 & 1)) {
                composer2 = startRestartGroup;
                composer2.skipToGroupEnd();
                obj = obj4;
            } else {
                if (i6 != 0) {
                    obj5 = null;
                }
                Object obj6 = obj5;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1912839215, i4, -1, "androidx.compose.animation.AnimatedEnterExitImpl (AnimatedVisibility.kt:715)");
                }
                if (function1.invoke(transition.getTargetState()).booleanValue() || function1.invoke(transition.getCurrentState()).booleanValue() || transition.isSeeking() || transition.getHasInitialValueAnimations()) {
                    startRestartGroup.startReplaceGroup(-232323267);
                    ComposerKt.sourceInformation(startRestartGroup, "723@40225L124,727@40392L40,733@40641L529,730@40484L686");
                    int i9 = i4 & 14;
                    int i10 = i9 | 48;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -539313577, "CC(createChildTransition)N(label,transformToChildState)1768@75281L36,1769@75341L74,1770@75438L39,1771@75489L63:Transition.kt#pdpnli");
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1410703355, "CC(remember):Transition.kt#9igjgp");
                    int i11 = i10 & 14;
                    boolean z = ((i11 ^ 6) > 4 && startRestartGroup.changed(transition)) || (i10 & 6) == 4;
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (z || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = transition.getCurrentState();
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    if (transition.isSeeking()) {
                        rememberedValue = transition.getCurrentState();
                    }
                    startRestartGroup.startReplaceGroup(1844425648);
                    ComposerKt.sourceInformation(startRestartGroup, "C724@40307L28:AnimatedVisibility.kt#xbi5r1");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1844425648, 0, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:724)");
                    }
                    int i12 = i4 & WebSocketProtocol.PAYLOAD_SHORT;
                    EnterExitState targetEnterExit = targetEnterExit(transition, function1, rememberedValue, startRestartGroup, i12);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    startRestartGroup.endReplaceGroup();
                    T targetState = transition.getTargetState();
                    startRestartGroup.startReplaceGroup(1844425648);
                    ComposerKt.sourceInformation(startRestartGroup, "C724@40307L28:AnimatedVisibility.kt#xbi5r1");
                    if (ComposerKt.isTraceInProgress()) {
                        enterExitState = targetEnterExit;
                        obj2 = obj6;
                        i5 = 0;
                        ComposerKt.traceEventStart(1844425648, 0, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:724)");
                    } else {
                        enterExitState = targetEnterExit;
                        obj2 = obj6;
                        i5 = 0;
                    }
                    EnterExitState targetEnterExit2 = targetEnterExit(transition, function1, targetState, startRestartGroup, i12);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    startRestartGroup.endReplaceGroup();
                    int i13 = i5;
                    Transition createChildTransitionInternal = androidx.compose.animation.core.TransitionKt.createChildTransitionInternal(transition, enterExitState, targetEnterExit2, "EnterExitTransition", startRestartGroup, i11 | 3072);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, startRestartGroup, (i4 >> 15) & 14);
                    Boolean invoke = function2.invoke(createChildTransitionInternal.getCurrentState(), createChildTransitionInternal.getTargetState());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -7480960, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    boolean changed = startRestartGroup.changed(createChildTransitionInternal) | startRestartGroup.changed(rememberUpdatedState);
                    AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1 rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1(createChildTransitionInternal, rememberUpdatedState, null);
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    State produceState = SnapshotStateKt.produceState(invoke, (Function2) rememberedValue2, startRestartGroup, i13);
                    if (!getExitFinished(createChildTransitionInternal) || !AnimatedEnterExitImpl$lambda$11(produceState)) {
                        startRestartGroup.startReplaceGroup(-231293261);
                        ComposerKt.sourceInformation(startRestartGroup, "749@41268L69,755@41536L47,769@42351L50,750@41350L1066");
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -7461356, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        int i14 = i9 == 4 ? 1 : i13;
                        Object rememberedValue3 = startRestartGroup.rememberedValue();
                        if (i14 != 0 || rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = new AnimatedVisibilityScopeImpl(createChildTransitionInternal);
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        AnimatedVisibilityScopeImpl animatedVisibilityScopeImpl = (AnimatedVisibilityScopeImpl) rememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        int i15 = i4 >> 6;
                        onLookaheadMeasured2 = obj2;
                        Modifier createModifier = EnterExitTransitionKt.createModifier(createChildTransitionInternal, enterTransition2, exitTransition2, null, "Built-in", startRestartGroup, (i15 & 112) | 24576 | (i15 & 896), 4);
                        composer2 = startRestartGroup;
                        if (onLookaheadMeasured2 != null) {
                            composer2.startReplaceGroup(-230873924);
                            ComposerKt.sourceInformation(composer2, "758@41738L479");
                            Modifier.Companion companion2 = Modifier.Companion;
                            ComposerKt.sourceInformationMarkerStart(composer2, -7445906, "CC(remember):AnimatedVisibility.kt#9igjgp");
                            if ((3670016 & i4) != 1048576 && ((i4 & 2097152) == 0 || !composer2.changedInstance(onLookaheadMeasured2))) {
                                i8 = i13;
                            }
                            Object rememberedValue4 = composer2.rememberedValue();
                            if (i8 != 0 || rememberedValue4 == Composer.Companion.getEmpty()) {
                                rememberedValue4 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                        return m83invoke3p2s80s(measureScope, measurable, constraints.m7955unboximpl());
                                    }

                                    /* renamed from: invoke-3p2s80s  reason: not valid java name */
                                    public final MeasureResult m83invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                                        final Placeable mo6698measureBRTryo0 = measurable.mo6698measureBRTryo0(j);
                                        OnLookaheadMeasured onLookaheadMeasured3 = OnLookaheadMeasured.this;
                                        if (measureScope.isLookingAhead()) {
                                            onLookaheadMeasured3.m120invokeozmzZPI(IntSize.m8162constructorimpl((mo6698measureBRTryo0.getWidth() << 32) | (mo6698measureBRTryo0.getHeight() & 4294967295L)));
                                        }
                                        return MeasureScope.layout$default(measureScope, mo6698measureBRTryo0.getWidth(), mo6698measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
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
                                                Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                                            }
                                        }, 4, null);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            companion = LayoutModifierKt.layout(companion2, (Function3) rememberedValue4);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(-7429769);
                            composer2.endReplaceGroup();
                            companion = Modifier.Companion;
                        }
                        Modifier then = modifier.then(createModifier.then(companion));
                        ComposerKt.sourceInformationMarkerStart(composer2, -7426719, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        Object rememberedValue5 = composer2.rememberedValue();
                        if (rememberedValue5 == Composer.Companion.getEmpty()) {
                            rememberedValue5 = new AnimatedEnterExitMeasurePolicy(animatedVisibilityScopeImpl);
                            composer2.updateRememberedValue(rememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        AnimatedEnterExitMeasurePolicy animatedEnterExitMeasurePolicy = (AnimatedEnterExitMeasurePolicy) rememberedValue5;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, i13));
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, then);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer m4598constructorimpl = Updater.m4598constructorimpl(composer2);
                        Updater.m4605setimpl(m4598constructorimpl, animatedEnterExitMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4605setimpl(m4598constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m4598constructorimpl.getInserting() || !Intrinsics.areEqual(m4598constructorimpl.rememberedValue(), Integer.valueOf(hashCode))) {
                            m4598constructorimpl.updateRememberedValue(Integer.valueOf(hashCode));
                            m4598constructorimpl.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                        }
                        Updater.m4605setimpl(m4598constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -1766274760, "C751@41392L9:AnimatedVisibility.kt#xbi5r1");
                        function3.invoke(animatedVisibilityScopeImpl, composer2, Integer.valueOf((i4 >> 18) & 112));
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceGroup();
                    } else {
                        startRestartGroup.startReplaceGroup(-230155437);
                        startRestartGroup.endReplaceGroup();
                        onLookaheadMeasured2 = obj2;
                        composer2 = startRestartGroup;
                    }
                    composer2.endReplaceGroup();
                    obj3 = onLookaheadMeasured2;
                } else {
                    startRestartGroup.startReplaceGroup(-230149485);
                    startRestartGroup.endReplaceGroup();
                    composer2 = startRestartGroup;
                    obj3 = obj6;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj3;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                final OnLookaheadMeasured onLookaheadMeasured3 = obj;
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$4
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

                    public final void invoke(Composer composer3, int i16) {
                        AnimatedVisibilityKt.AnimatedEnterExitImpl(transition, function1, modifier, enterTransition, exitTransition, function2, onLookaheadMeasured3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= i7;
        if ((i2 & 128) == 0) {
        }
        i4 = i3;
        int i82 = 1;
        Object obj52 = obj4;
        if (startRestartGroup.shouldExecute((4793491 & i4) == 4793490, i4 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getExitFinished(Transition<EnterExitState> transition) {
        return transition.getCurrentState() == EnterExitState.PostExit && transition.getTargetState() == EnterExitState.PostExit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> EnterExitState targetEnterExit(Transition<T> transition, Function1<? super T, Boolean> function1, T t, Composer composer, int i) {
        EnterExitState enterExitState;
        ComposerKt.sourceInformationMarkerStart(composer, 361571134, "C(targetEnterExit)P(1):AnimatedVisibility.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(361571134, i, -1, "androidx.compose.animation.targetEnterExit (AnimatedVisibility.kt:833)");
        }
        composer.startMovableGroup(-422486105, transition);
        ComposerKt.sourceInformation(composer, "");
        if (transition.isSeeking()) {
            composer.startReplaceGroup(-212146657);
            composer.endReplaceGroup();
            if (function1.invoke(t).booleanValue()) {
                enterExitState = EnterExitState.Visible;
            } else if (function1.invoke(transition.getCurrentState()).booleanValue()) {
                enterExitState = EnterExitState.PostExit;
            } else {
                enterExitState = EnterExitState.PreEnter;
            }
        } else {
            composer.startReplaceGroup(-211872524);
            ComposerKt.sourceInformation(composer, "845@44894L34");
            ComposerKt.sourceInformationMarkerStart(composer, -422476000, "CC(remember):AnimatedVisibility.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composer.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (function1.invoke(transition.getCurrentState()).booleanValue()) {
                mutableState.setValue(true);
            }
            if (function1.invoke(t).booleanValue()) {
                enterExitState = EnterExitState.Visible;
            } else if (((Boolean) mutableState.getValue()).booleanValue()) {
                enterExitState = EnterExitState.PostExit;
            } else {
                enterExitState = EnterExitState.PreEnter;
            }
            composer.endReplaceGroup();
        }
        composer.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return enterExitState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<EnterExitState, EnterExitState, Boolean> AnimatedEnterExitImpl$lambda$9(State<? extends Function2<? super EnterExitState, ? super EnterExitState, Boolean>> state) {
        return (Function2) state.getValue();
    }

    private static final boolean AnimatedEnterExitImpl$lambda$11(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
