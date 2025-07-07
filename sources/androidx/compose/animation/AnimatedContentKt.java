package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AnimatedContent.kt */
@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a´\u0001\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u001f\b\u0002\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112%\b\u0002\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00150\n21\u0010\u0016\u001a-\u0012\u0004\u0012\u00020\u0018\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00040\u0017¢\u0006\u0002\b\u0019¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u001a\u001aP\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2>\b\u0002\u0010\u001f\u001a8\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\"0\u0017\u001a¬\u0001\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050#2\b\b\u0002\u0010\u0007\u001a\u00020\b2\u001f\b\u0002\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2%\b\u0002\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00150\n21\u0010\u0016\u001a-\u0012\u0004\u0012\u00020\u0018\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00040\u0017¢\u0006\u0002\b\u0019¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010$\u001a\u0015\u0010%\u001a\u00020\f*\u00020&2\u0006\u0010'\u001a\u00020(H\u0086\u0004\u001a\u0015\u0010)\u001a\u00020\f*\u00020&2\u0006\u0010'\u001a\u00020(H\u0087\u0004\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006*"}, d2 = {"UnspecifiedSize", "Landroidx/compose/ui/unit/IntSize;", "J", "AnimatedContent", "", ExifInterface.LATITUDE_SOUTH, "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/compose/animation/ContentTransform;", "Lkotlin/ExtensionFunctionType;", "contentAlignment", "Landroidx/compose/ui/Alignment;", Constants.ScionAnalytics.PARAM_LABEL, "", "contentKey", "Lkotlin/ParameterName;", "name", "", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "SizeTransform", "Landroidx/compose/animation/SizeTransform;", "clip", "", "sizeAnimationSpec", "initialSize", "targetSize", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/animation/core/Transition;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "togetherWith", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "with", "animation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnimatedContentKt {
    private static final long UnspecifiedSize;

    /* JADX WARN: Removed duplicated region for block: B:144:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:229:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <S> void AnimatedContent(final S s, Modifier modifier, Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function1, Alignment alignment, String str, Function1<? super S, ? extends Object> function12, final Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Object obj;
        int i5;
        Object obj2;
        int i6;
        int i7;
        AnimatedContentKt$AnimatedContent$2 animatedContentKt$AnimatedContent$2;
        Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function42;
        final Modifier modifier2;
        final String str2;
        final Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function13;
        final Alignment alignment2;
        ScopeUpdateScope endRestartGroup;
        int i8;
        Modifier.Companion companion;
        int i9;
        Alignment alignment3;
        Composer startRestartGroup = composer.startRestartGroup(2132720749);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedContent)P(5,4,6,1,3,2)141@7609L58,142@7683L136:AnimatedContent.kt#xbi5r1");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? startRestartGroup.changed(s) : startRestartGroup.changedInstance(s) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj = function1;
                i3 |= startRestartGroup.changedInstance(obj) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    obj2 = alignment;
                    i3 |= startRestartGroup.changed(obj2) ? 2048 : 1024;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        i3 |= startRestartGroup.changed(str) ? 16384 : 8192;
                        i7 = i2 & 32;
                        if (i7 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((196608 & i) == 0) {
                            animatedContentKt$AnimatedContent$2 = function12;
                            i3 |= startRestartGroup.changedInstance(animatedContentKt$AnimatedContent$2) ? 131072 : 65536;
                            if ((i2 & 64) == 0) {
                                i3 |= 1572864;
                            } else if ((i & 1572864) == 0) {
                                function42 = function4;
                                i3 |= startRestartGroup.changedInstance(function42) ? 1048576 : 524288;
                                if (startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                                    if (i10 != 0) {
                                        companion = Modifier.Companion;
                                        i8 = i6;
                                    } else {
                                        i8 = i6;
                                        companion = modifier;
                                    }
                                    AnimatedContentKt$AnimatedContent$1 animatedContentKt$AnimatedContent$1 = i4 != 0 ? new Function1<AnimatedContentTransitionScope<S>, ContentTransform>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$1
                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ ContentTransform invoke(Object obj3) {
                                            return invoke((AnimatedContentTransitionScope) ((AnimatedContentTransitionScope) obj3));
                                        }

                                        public final ContentTransform invoke(AnimatedContentTransitionScope<S> animatedContentTransitionScope) {
                                            return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m87scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.92f, 0L, 4, null)), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, null, 6, null), 0.0f, 2, null));
                                        }
                                    } : obj;
                                    if (i5 != 0) {
                                        alignment3 = Alignment.Companion.getTopStart();
                                        i9 = i7;
                                    } else {
                                        i9 = i7;
                                        alignment3 = obj2;
                                    }
                                    String str3 = i8 != 0 ? "AnimatedContent" : str;
                                    if (i9 != 0) {
                                        animatedContentKt$AnimatedContent$2 = new Function1<S, S>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final S invoke(S s2) {
                                                return s2;
                                            }
                                        };
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:140)");
                                    }
                                    Transition updateTransition = androidx.compose.animation.core.TransitionKt.updateTransition(s, str3, startRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                                    int i11 = i3 & 8176;
                                    int i12 = i3 >> 3;
                                    AnimatedContent(updateTransition, companion, animatedContentKt$AnimatedContent$1, alignment3, animatedContentKt$AnimatedContent$2, function42, startRestartGroup, i11 | (57344 & i12) | (i12 & 458752), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    str2 = str3;
                                    modifier2 = companion;
                                    function13 = animatedContentKt$AnimatedContent$1;
                                    alignment2 = alignment3;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    modifier2 = modifier;
                                    str2 = str;
                                    function13 = obj;
                                    alignment2 = obj2;
                                }
                                final Function1<? super S, ? extends Object> function14 = animatedContentKt$AnimatedContent$2;
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$3
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

                                        public final void invoke(Composer composer2, int i13) {
                                            AnimatedContentKt.AnimatedContent(s, modifier2, function13, alignment2, str2, function14, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            function42 = function4;
                            if (startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                            }
                            final Function1<? super S, ? extends Object> function142 = animatedContentKt$AnimatedContent$2;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        animatedContentKt$AnimatedContent$2 = function12;
                        if ((i2 & 64) == 0) {
                        }
                        function42 = function4;
                        if (startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                        }
                        final Function1<? super S, ? extends Object> function1422 = animatedContentKt$AnimatedContent$2;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i7 = i2 & 32;
                    if (i7 != 0) {
                    }
                    animatedContentKt$AnimatedContent$2 = function12;
                    if ((i2 & 64) == 0) {
                    }
                    function42 = function4;
                    if (startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                    }
                    final Function1<? super S, ? extends Object> function14222 = animatedContentKt$AnimatedContent$2;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj2 = alignment;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                i7 = i2 & 32;
                if (i7 != 0) {
                }
                animatedContentKt$AnimatedContent$2 = function12;
                if ((i2 & 64) == 0) {
                }
                function42 = function4;
                if (startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                }
                final Function1<? super S, ? extends Object> function142222 = animatedContentKt$AnimatedContent$2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj = function1;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            obj2 = alignment;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            i7 = i2 & 32;
            if (i7 != 0) {
            }
            animatedContentKt$AnimatedContent$2 = function12;
            if ((i2 & 64) == 0) {
            }
            function42 = function4;
            if (startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
            }
            final Function1<? super S, ? extends Object> function1422222 = animatedContentKt$AnimatedContent$2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        obj = function1;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        obj2 = alignment;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        i7 = i2 & 32;
        if (i7 != 0) {
        }
        animatedContentKt$AnimatedContent$2 = function12;
        if ((i2 & 64) == 0) {
        }
        function42 = function4;
        if (startRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
        }
        final Function1<? super S, ? extends Object> function14222222 = animatedContentKt$AnimatedContent$2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static /* synthetic */ SizeTransform SizeTransform$default(boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            function2 = new Function2<IntSize, IntSize, SpringSpec<IntSize>>() { // from class: androidx.compose.animation.AnimatedContentKt$SizeTransform$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ SpringSpec<IntSize> invoke(IntSize intSize, IntSize intSize2) {
                    return m41invokeTemP2vQ(intSize.m6859unboximpl(), intSize2.m6859unboximpl());
                }

                /* renamed from: invoke-TemP2vQ  reason: not valid java name */
                public final SpringSpec<IntSize> m41invokeTemP2vQ(long j, long j2) {
                    return AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6847boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
                }
            };
        }
        return SizeTransform(z, function2);
    }

    public static final SizeTransform SizeTransform(boolean z, Function2<? super IntSize, ? super IntSize, ? extends FiniteAnimationSpec<IntSize>> function2) {
        return new SizeTransformImpl(z, function2);
    }

    public static final ContentTransform togetherWith(EnterTransition enterTransition, ExitTransition exitTransition) {
        return new ContentTransform(enterTransition, exitTransition, 0.0f, null, 12, null);
    }

    @Deprecated(message = "Infix fun EnterTransition.with(ExitTransition) has been renamed to togetherWith", replaceWith = @ReplaceWith(expression = "togetherWith(exit)", imports = {}))
    public static final ContentTransform with(EnterTransition enterTransition, ExitTransition exitTransition) {
        return new ContentTransform(enterTransition, exitTransition, 0.0f, null, 12, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:225:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:397:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <S> void AnimatedContent(final Transition<S> transition, Modifier modifier, Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function1, Alignment alignment, Function1<? super S, ? extends Object> function12, final Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        int i4;
        Object obj2;
        int i5;
        Alignment alignment2;
        int i6;
        AnimatedContentKt$AnimatedContent$5 animatedContentKt$AnimatedContent$5;
        Object obj3;
        final Modifier modifier2;
        final AnimatedContentKt$AnimatedContent$4 animatedContentKt$AnimatedContent$4;
        ScopeUpdateScope endRestartGroup;
        AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl;
        SnapshotStateList snapshotStateList;
        MutableScatterMap mutableScatterMap;
        final Transition<S> transition2 = transition;
        Composer startRestartGroup = composer.startRestartGroup(-114689412);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedContent)P(3,4,1,2)773@38528L7,775@38564L114,779@38766L51,780@38839L69,866@43373L58,867@43465L45,873@43720L52,868@43515L263:AnimatedContent.kt#xbi5r1");
        if ((i2 & Integer.MIN_VALUE) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(transition2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            i4 = i2 & 2;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj2 = function1;
                i3 |= startRestartGroup.changedInstance(obj2) ? 256 : 128;
                i5 = i2 & 4;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    Object obj4 = alignment;
                    i3 |= startRestartGroup.changed(obj4) ? 2048 : 1024;
                    alignment2 = obj4;
                    i6 = i2 & 8;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        Object obj5 = function12;
                        i3 |= startRestartGroup.changedInstance(obj5) ? 16384 : 8192;
                        animatedContentKt$AnimatedContent$5 = obj5;
                        if ((i2 & 16) != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            obj3 = function4;
                            i3 |= startRestartGroup.changedInstance(obj3) ? 131072 : 65536;
                            if (!startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                                Modifier.Companion companion = i7 != 0 ? Modifier.Companion : obj;
                                animatedContentKt$AnimatedContent$4 = i4 != 0 ? new Function1<AnimatedContentTransitionScope<S>, ContentTransform>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$4
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ ContentTransform invoke(Object obj6) {
                                        return invoke((AnimatedContentTransitionScope) ((AnimatedContentTransitionScope) obj6));
                                    }

                                    public final ContentTransform invoke(AnimatedContentTransitionScope<S> animatedContentTransitionScope) {
                                        return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m87scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.92f, 0L, 4, null)), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, null, 6, null), 0.0f, 2, null));
                                    }
                                } : obj2;
                                if (i5 != 0) {
                                    alignment2 = Alignment.Companion.getTopStart();
                                }
                                if (i6 != 0) {
                                    animatedContentKt$AnimatedContent$5 = new Function1<S, S>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$5
                                        @Override // kotlin.jvm.functions.Function1
                                        public final S invoke(S s) {
                                            return s;
                                        }
                                    };
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:772)");
                                }
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                LayoutDirection layoutDirection = (LayoutDirection) consume;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -801775907, "CC(remember):AnimatedContent.kt#9igjgp");
                                int i8 = i3 & 14;
                                boolean z = i8 == 4;
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (z || rememberedValue == Composer.Companion.getEmpty()) {
                                    rememberedValue = new AnimatedContentTransitionScopeImpl(transition2, alignment2, layoutDirection);
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl2 = (AnimatedContentTransitionScopeImpl) rememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -801769506, "CC(remember):AnimatedContent.kt#9igjgp");
                                boolean z2 = i8 == 4;
                                Object rememberedValue2 = startRestartGroup.rememberedValue();
                                if (z2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                                    rememberedValue2 = SnapshotStateKt.mutableStateListOf(transition2.getCurrentState());
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                SnapshotStateList snapshotStateList2 = (SnapshotStateList) rememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -801767152, "CC(remember):AnimatedContent.kt#9igjgp");
                                boolean z3 = i8 == 4;
                                Object rememberedValue3 = startRestartGroup.rememberedValue();
                                if (z3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                    rememberedValue3 = ScatterMapKt.mutableScatterMapOf();
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                MutableScatterMap mutableScatterMap2 = (MutableScatterMap) rememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                if (!snapshotStateList2.contains(transition2.getCurrentState())) {
                                    snapshotStateList2.clear();
                                    snapshotStateList2.add(transition2.getCurrentState());
                                }
                                if (Intrinsics.areEqual(transition2.getCurrentState(), transition2.getTargetState())) {
                                    if (snapshotStateList2.size() != 1 || !Intrinsics.areEqual(snapshotStateList2.get(0), transition2.getCurrentState())) {
                                        snapshotStateList2.clear();
                                        snapshotStateList2.add(transition2.getCurrentState());
                                    }
                                    if (mutableScatterMap2.getSize() != 1 || mutableScatterMap2.containsKey(transition2.getCurrentState())) {
                                        mutableScatterMap2.clear();
                                    }
                                    animatedContentTransitionScopeImpl2.setContentAlignment(alignment2);
                                    animatedContentTransitionScopeImpl2.setLayoutDirection$animation_release(layoutDirection);
                                }
                                if (!Intrinsics.areEqual(transition2.getCurrentState(), transition2.getTargetState()) && !snapshotStateList2.contains(transition2.getTargetState())) {
                                    Iterator<T> it = snapshotStateList2.iterator();
                                    int i9 = 0;
                                    while (true) {
                                        if (!it.hasNext()) {
                                            i9 = -1;
                                            break;
                                        } else if (Intrinsics.areEqual(animatedContentKt$AnimatedContent$5.invoke((Object) it.next()), animatedContentKt$AnimatedContent$5.invoke(transition2.getTargetState()))) {
                                            break;
                                        } else {
                                            i9++;
                                        }
                                    }
                                    if (i9 == -1) {
                                        snapshotStateList2.add(transition2.getTargetState());
                                    } else {
                                        snapshotStateList2.set(i9, transition2.getTargetState());
                                    }
                                }
                                if (!mutableScatterMap2.containsKey(transition2.getTargetState()) || !mutableScatterMap2.containsKey(transition2.getCurrentState())) {
                                    startRestartGroup.startReplaceGroup(916905750);
                                    ComposerKt.sourceInformation(startRestartGroup, "*816@40785L2544");
                                    mutableScatterMap2.clear();
                                    SnapshotStateList snapshotStateList3 = snapshotStateList2;
                                    int size = snapshotStateList3.size();
                                    int i10 = 0;
                                    Object obj6 = obj3;
                                    while (i10 < size) {
                                        MutableScatterMap mutableScatterMap3 = mutableScatterMap2;
                                        final T t = snapshotStateList3.get(i10);
                                        int i11 = i10;
                                        final SnapshotStateList snapshotStateList4 = snapshotStateList2;
                                        final Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function42 = obj6;
                                        int i12 = size;
                                        final AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl3 = animatedContentTransitionScopeImpl2;
                                        mutableScatterMap3.set(t, ComposableLambdaKt.rememberComposableLambda(885640742, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1
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

                                            /* JADX WARN: Multi-variable type inference failed */
                                            public final void invoke(Composer composer2, int i13) {
                                                Object initialContentExit;
                                                ComposerKt.sourceInformation(composer2, "C817@40821L38,821@41035L323,828@41391L125,839@41959L348,835@41768L25,846@42447L233,851@42699L616,833@41699L1616:AnimatedContent.kt#xbi5r1");
                                                if (!composer2.shouldExecute((i13 & 3) != 2, i13 & 1)) {
                                                    composer2.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(885640742, i13, -1, "androidx.compose.animation.AnimatedContent.<anonymous>.<anonymous> (AnimatedContent.kt:817)");
                                                }
                                                ComposerKt.sourceInformationMarkerStart(composer2, 1908352303, "CC(remember):AnimatedContent.kt#9igjgp");
                                                Function1<AnimatedContentTransitionScope<S>, ContentTransform> function13 = animatedContentKt$AnimatedContent$4;
                                                Object obj7 = animatedContentTransitionScopeImpl3;
                                                ContentTransform rememberedValue4 = composer2.rememberedValue();
                                                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                                    rememberedValue4 = function13.invoke(obj7);
                                                    composer2.updateRememberedValue(rememberedValue4);
                                                }
                                                final ContentTransform contentTransform = (ContentTransform) rememberedValue4;
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                boolean areEqual = Intrinsics.areEqual(transition2.getSegment().getTargetState(), t);
                                                ComposerKt.sourceInformationMarkerStart(composer2, 1908359436, "CC(remember):AnimatedContent.kt#9igjgp");
                                                boolean changed = composer2.changed(areEqual);
                                                Transition<S> transition3 = transition2;
                                                S s = t;
                                                Function1<AnimatedContentTransitionScope<S>, ContentTransform> function14 = animatedContentKt$AnimatedContent$4;
                                                Object obj8 = animatedContentTransitionScopeImpl3;
                                                Object rememberedValue5 = composer2.rememberedValue();
                                                if (changed || rememberedValue5 == Composer.Companion.getEmpty()) {
                                                    if (Intrinsics.areEqual(transition3.getSegment().getTargetState(), s)) {
                                                        initialContentExit = ExitTransition.Companion.getNone();
                                                    } else {
                                                        initialContentExit = function14.invoke(obj8).getInitialContentExit();
                                                    }
                                                    rememberedValue5 = initialContentExit;
                                                    composer2.updateRememberedValue(rememberedValue5);
                                                }
                                                final ExitTransition exitTransition = (ExitTransition) rememberedValue5;
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                ComposerKt.sourceInformationMarkerStart(composer2, 1908370630, "CC(remember):AnimatedContent.kt#9igjgp");
                                                S s2 = t;
                                                Transition<S> transition4 = transition2;
                                                Object rememberedValue6 = composer2.rememberedValue();
                                                if (rememberedValue6 == Composer.Companion.getEmpty()) {
                                                    rememberedValue6 = new AnimatedContentTransitionScopeImpl.ChildData(Intrinsics.areEqual(s2, transition4.getTargetState()));
                                                    composer2.updateRememberedValue(rememberedValue6);
                                                }
                                                AnimatedContentTransitionScopeImpl.ChildData childData = (AnimatedContentTransitionScopeImpl.ChildData) rememberedValue6;
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                EnterTransition targetContentEnter = contentTransform.getTargetContentEnter();
                                                Modifier.Companion companion2 = Modifier.Companion;
                                                ComposerKt.sourceInformationMarkerStart(composer2, 1908389029, "CC(remember):AnimatedContent.kt#9igjgp");
                                                boolean changedInstance = composer2.changedInstance(contentTransform);
                                                Object rememberedValue7 = composer2.rememberedValue();
                                                if (changedInstance || rememberedValue7 == Composer.Companion.getEmpty()) {
                                                    rememberedValue7 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$1$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                                            return m40invoke3p2s80s(measureScope, measurable, constraints.m6643unboximpl());
                                                        }

                                                        /* renamed from: invoke-3p2s80s  reason: not valid java name */
                                                        public final MeasureResult m40invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                                                            final Placeable mo5438measureBRTryo0 = measurable.mo5438measureBRTryo0(j);
                                                            int width = mo5438measureBRTryo0.getWidth();
                                                            int height = mo5438measureBRTryo0.getHeight();
                                                            final ContentTransform contentTransform2 = ContentTransform.this;
                                                            return MeasureScope.layout$default(measureScope, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$1$1.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                                                    placementScope.place(Placeable.this, 0, 0, contentTransform2.getTargetContentZIndex());
                                                                }
                                                            }, 4, null);
                                                        }
                                                    };
                                                    composer2.updateRememberedValue(rememberedValue7);
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                Modifier layout = LayoutModifierKt.layout(companion2, (Function3) rememberedValue7);
                                                childData.setTarget(Intrinsics.areEqual(t, transition2.getTargetState()));
                                                Modifier then = layout.then(childData);
                                                Transition<S> transition5 = transition2;
                                                ComposerKt.sourceInformationMarkerStart(composer2, 1908382594, "CC(remember):AnimatedContent.kt#9igjgp");
                                                boolean changedInstance2 = composer2.changedInstance(t);
                                                final S s3 = t;
                                                Object rememberedValue8 = composer2.rememberedValue();
                                                if (changedInstance2 || rememberedValue8 == Composer.Companion.getEmpty()) {
                                                    rememberedValue8 = (Function1) new Function1<S, Boolean>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$3$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Boolean invoke(S s4) {
                                                            return Boolean.valueOf(Intrinsics.areEqual(s4, s3));
                                                        }

                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Boolean invoke(Object obj9) {
                                                            return invoke((AnimatedContentKt$AnimatedContent$6$1$3$1<S>) obj9);
                                                        }
                                                    };
                                                    composer2.updateRememberedValue(rememberedValue8);
                                                }
                                                Function1 function15 = (Function1) rememberedValue8;
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                ComposerKt.sourceInformationMarkerStart(composer2, 1908404530, "CC(remember):AnimatedContent.kt#9igjgp");
                                                boolean changed2 = composer2.changed(exitTransition);
                                                Object rememberedValue9 = composer2.rememberedValue();
                                                if (changed2 || rememberedValue9 == Composer.Companion.getEmpty()) {
                                                    rememberedValue9 = (Function2) new Function2<EnterExitState, EnterExitState, Boolean>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$4$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Boolean invoke(EnterExitState enterExitState, EnterExitState enterExitState2) {
                                                            return Boolean.valueOf(enterExitState == EnterExitState.PostExit && enterExitState2 == EnterExitState.PostExit && !ExitTransition.this.getData$animation_release().getHold());
                                                        }
                                                    };
                                                    composer2.updateRememberedValue(rememberedValue9);
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                final SnapshotStateList<S> snapshotStateList5 = snapshotStateList4;
                                                final S s4 = t;
                                                final AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl4 = animatedContentTransitionScopeImpl3;
                                                final Function4<AnimatedContentScope, S, Composer, Integer, Unit> function43 = function42;
                                                AnimatedVisibilityKt.AnimatedEnterExitImpl(transition5, function15, then, targetContentEnter, exitTransition, (Function2) rememberedValue9, null, ComposableLambdaKt.rememberComposableLambda(-616195562, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1.5
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                                                        invoke(animatedVisibilityScope, composer3, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, int i14) {
                                                        ComposerKt.sourceInformation(composer3, "C853@42832L230,853@42809L253,*861@43224L43,861@43271L24:AnimatedContent.kt#xbi5r1");
                                                        if ((i14 & 6) == 0) {
                                                            i14 |= (i14 & 8) == 0 ? composer3.changed(animatedVisibilityScope) : composer3.changedInstance(animatedVisibilityScope) ? 4 : 2;
                                                        }
                                                        if (!composer3.shouldExecute((i14 & 19) != 18, i14 & 1)) {
                                                            composer3.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-616195562, i14, -1, "androidx.compose.animation.AnimatedContent.<anonymous>.<anonymous>.<anonymous> (AnimatedContent.kt:853)");
                                                        }
                                                        ComposerKt.sourceInformationMarkerStart(composer3, 642125262, "CC(remember):AnimatedContent.kt#9igjgp");
                                                        boolean changed3 = composer3.changed(snapshotStateList5) | composer3.changedInstance(s4) | composer3.changedInstance(animatedContentTransitionScopeImpl4);
                                                        final SnapshotStateList<S> snapshotStateList6 = snapshotStateList5;
                                                        final S s5 = s4;
                                                        final AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl5 = animatedContentTransitionScopeImpl4;
                                                        Object rememberedValue10 = composer3.rememberedValue();
                                                        if (changed3 || rememberedValue10 == Composer.Companion.getEmpty()) {
                                                            rememberedValue10 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$5$1$1
                                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public /* bridge */ /* synthetic */ DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                                                    return invoke2(disposableEffectScope);
                                                                }

                                                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                                public final DisposableEffectResult invoke2(DisposableEffectScope disposableEffectScope) {
                                                                    final SnapshotStateList<S> snapshotStateList7 = snapshotStateList6;
                                                                    final S s6 = s5;
                                                                    final AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl6 = animatedContentTransitionScopeImpl5;
                                                                    return new DisposableEffectResult() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$5$1$1$invoke$$inlined$onDispose$1
                                                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                                                        public void dispose() {
                                                                            SnapshotStateList.this.remove(s6);
                                                                            animatedContentTransitionScopeImpl6.getTargetSizeMap$animation_release().remove(s6);
                                                                        }
                                                                    };
                                                                }
                                                            };
                                                            composer3.updateRememberedValue(rememberedValue10);
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        EffectsKt.DisposableEffect(animatedVisibilityScope, (Function1) rememberedValue10, composer3, i14 & 14);
                                                        MutableScatterMap targetSizeMap$animation_release = animatedContentTransitionScopeImpl4.getTargetSizeMap$animation_release();
                                                        S s6 = s4;
                                                        Intrinsics.checkNotNull(animatedVisibilityScope, "null cannot be cast to non-null type androidx.compose.animation.AnimatedVisibilityScopeImpl");
                                                        targetSizeMap$animation_release.set(s6, ((AnimatedVisibilityScopeImpl) animatedVisibilityScope).getTargetSize$animation_release());
                                                        ComposerKt.sourceInformationMarkerStart(composer3, 642137619, "CC(remember):AnimatedContent.kt#9igjgp");
                                                        Object rememberedValue11 = composer3.rememberedValue();
                                                        if (rememberedValue11 == Composer.Companion.getEmpty()) {
                                                            rememberedValue11 = new AnimatedContentScopeImpl(animatedVisibilityScope);
                                                            composer3.updateRememberedValue(rememberedValue11);
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        function43.invoke((AnimatedContentScopeImpl) rememberedValue11, s4, composer3, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, composer2, 54), composer2, 12582912, 64);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, startRestartGroup, 54));
                                        transition2 = transition;
                                        animatedContentTransitionScopeImpl2 = animatedContentTransitionScopeImpl3;
                                        mutableScatterMap2 = mutableScatterMap3;
                                        size = i12;
                                        obj6 = function4;
                                        snapshotStateList2 = snapshotStateList4;
                                        i10 = i11 + 1;
                                        snapshotStateList3 = snapshotStateList3;
                                    }
                                    animatedContentTransitionScopeImpl = animatedContentTransitionScopeImpl2;
                                    snapshotStateList = snapshotStateList2;
                                    mutableScatterMap = mutableScatterMap2;
                                    startRestartGroup.endReplaceGroup();
                                } else {
                                    startRestartGroup.startReplaceGroup(919489879);
                                    startRestartGroup.endReplaceGroup();
                                    animatedContentTransitionScopeImpl = animatedContentTransitionScopeImpl2;
                                    snapshotStateList = snapshotStateList2;
                                    mutableScatterMap = mutableScatterMap2;
                                }
                                Transition.Segment<S> segment = transition.getSegment();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -801622075, "CC(remember):AnimatedContent.kt#9igjgp");
                                boolean changed = startRestartGroup.changed(segment) | startRestartGroup.changed(animatedContentTransitionScopeImpl);
                                ContentTransform rememberedValue4 = startRestartGroup.rememberedValue();
                                if (changed || rememberedValue4 == Composer.Companion.getEmpty()) {
                                    rememberedValue4 = animatedContentKt$AnimatedContent$4.invoke(animatedContentTransitionScopeImpl);
                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                Modifier then = companion.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) rememberedValue4, startRestartGroup, 0));
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -801610977, "CC(remember):AnimatedContent.kt#9igjgp");
                                Object rememberedValue5 = startRestartGroup.rememberedValue();
                                if (rememberedValue5 == Composer.Companion.getEmpty()) {
                                    rememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                                    startRestartGroup.updateRememberedValue(rememberedValue5);
                                }
                                AnimatedContentMeasurePolicy animatedContentMeasurePolicy = (AnimatedContentMeasurePolicy) rememberedValue5;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, then);
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
                                Composer m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
                                Updater.m3527setimpl(m3520constructorimpl, animatedContentMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1027519816, "C:AnimatedContent.kt#xbi5r1");
                                startRestartGroup.startReplaceGroup(-1490874326);
                                ComposerKt.sourceInformation(startRestartGroup, "");
                                SnapshotStateList snapshotStateList5 = snapshotStateList;
                                int size2 = snapshotStateList5.size();
                                for (int i13 = 0; i13 < size2; i13++) {
                                    Object obj7 = (Object) snapshotStateList5.get(i13);
                                    startRestartGroup.startMovableGroup(1908442329, animatedContentKt$AnimatedContent$5.invoke(obj7));
                                    ComposerKt.sourceInformation(startRestartGroup, "");
                                    Function2 function2 = (Function2) mutableScatterMap.get(obj7);
                                    if (function2 == null) {
                                        startRestartGroup.startReplaceGroup(-967793488);
                                        startRestartGroup.endReplaceGroup();
                                    } else {
                                        startRestartGroup.startReplaceGroup(1908443505);
                                        ComposerKt.sourceInformation(startRestartGroup, "871@43672L8");
                                        function2.invoke(startRestartGroup, 0);
                                        startRestartGroup.endReplaceGroup();
                                    }
                                    startRestartGroup.endMovableGroup();
                                }
                                startRestartGroup.endReplaceGroup();
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                startRestartGroup.endNode();
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = companion;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier2 = obj;
                                animatedContentKt$AnimatedContent$4 = obj2;
                            }
                            final Alignment alignment3 = alignment2;
                            final Function1<? super S, ? extends Object> function13 = animatedContentKt$AnimatedContent$5;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$9
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

                                    public final void invoke(Composer composer2, int i14) {
                                        AnimatedContentKt.AnimatedContent(transition, modifier2, animatedContentKt$AnimatedContent$4, alignment3, function13, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        obj3 = function4;
                        if (!startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                        }
                        final Alignment alignment32 = alignment2;
                        final Function1<? super S, ? extends Object> function132 = animatedContentKt$AnimatedContent$5;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    animatedContentKt$AnimatedContent$5 = function12;
                    if ((i2 & 16) != 0) {
                    }
                    obj3 = function4;
                    if (!startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                    }
                    final Alignment alignment322 = alignment2;
                    final Function1<? super S, ? extends Object> function1322 = animatedContentKt$AnimatedContent$5;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                alignment2 = alignment;
                i6 = i2 & 8;
                if (i6 == 0) {
                }
                animatedContentKt$AnimatedContent$5 = function12;
                if ((i2 & 16) != 0) {
                }
                obj3 = function4;
                if (!startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                }
                final Alignment alignment3222 = alignment2;
                final Function1<? super S, ? extends Object> function13222 = animatedContentKt$AnimatedContent$5;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            obj2 = function1;
            i5 = i2 & 4;
            if (i5 != 0) {
            }
            alignment2 = alignment;
            i6 = i2 & 8;
            if (i6 == 0) {
            }
            animatedContentKt$AnimatedContent$5 = function12;
            if ((i2 & 16) != 0) {
            }
            obj3 = function4;
            if (!startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
            }
            final Alignment alignment32222 = alignment2;
            final Function1<? super S, ? extends Object> function132222 = animatedContentKt$AnimatedContent$5;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = modifier;
        i4 = i2 & 2;
        if (i4 == 0) {
        }
        obj2 = function1;
        i5 = i2 & 4;
        if (i5 != 0) {
        }
        alignment2 = alignment;
        i6 = i2 & 8;
        if (i6 == 0) {
        }
        animatedContentKt$AnimatedContent$5 = function12;
        if ((i2 & 16) != 0) {
        }
        obj3 = function4;
        if (!startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
        }
        final Alignment alignment322222 = alignment2;
        final Function1<? super S, ? extends Object> function1322222 = animatedContentKt$AnimatedContent$5;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    static {
        long j = Integer.MIN_VALUE;
        UnspecifiedSize = IntSize.m6850constructorimpl((j & 4294967295L) | (j << 32));
    }
}
