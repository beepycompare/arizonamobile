package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: LazyStaggeredGrid.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"LazyStaggeredGrid", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyStaggeredGrid-w41Enmo", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;FFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyStaggeredGrid_w41Enmo$lambda$0(LazyStaggeredGridState lazyStaggeredGridState, Orientation orientation, LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider, Modifier modifier, PaddingValues paddingValues, boolean z, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, float f, float f2, Function1 function1, int i, int i2, int i3, Composer composer, int i4) {
        m1102LazyStaggeredGridw41Enmo(lazyStaggeredGridState, orientation, lazyGridStaggeredGridSlotsProvider, modifier, paddingValues, z, flingBehavior, z2, overscrollEffect, f, f2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0108  */
    /* renamed from: LazyStaggeredGrid-w41Enmo  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1102LazyStaggeredGridw41Enmo(final LazyStaggeredGridState lazyStaggeredGridState, final Orientation orientation, final LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider, Modifier modifier, PaddingValues paddingValues, boolean z, FlingBehavior flingBehavior, boolean z2, final OverscrollEffect overscrollEffect, float f, float f2, final Function1<? super LazyStaggeredGridScope, Unit> function1, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Object obj;
        int i5;
        Object obj2;
        int i6;
        boolean z3;
        FlingBehavior flingBehavior2;
        int i7;
        boolean z4;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        final float f3;
        final FlingBehavior flingBehavior3;
        Composer composer2;
        final boolean z5;
        final PaddingValues paddingValues2;
        final boolean z6;
        final Modifier modifier2;
        final float f4;
        ScopeUpdateScope endRestartGroup;
        int i15;
        boolean z7;
        float m7996constructorimpl;
        Modifier modifier3;
        PaddingValues paddingValues3;
        boolean z8;
        FlingBehavior flingBehavior4;
        int i16;
        float f5;
        Modifier.Companion companion;
        Modifier scrollingContainer;
        Composer startRestartGroup = composer.startRestartGroup(-1904835166);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyStaggeredGrid)N(state,orientation,slots,modifier,contentPadding,reverseLayout,flingBehavior,userScrollEnabled,overscrollEffect,mainAxisSpacing:c#ui.unit.Dp,crossAxisSpacing:c#ui.unit.Dp,content)63@2872L55,64@2953L24,65@3025L7,67@3065L311,79@3401L60,98@4048L302,93@3879L1175:LazyStaggeredGrid.kt#fzvcnm");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(lazyStaggeredGridState) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changed(orientation.ordinal()) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= (i & 512) == 0 ? startRestartGroup.changed(lazyGridStaggeredGridSlotsProvider) : startRestartGroup.changedInstance(lazyGridStaggeredGridSlotsProvider) ? 256 : 128;
        }
        int i17 = i3 & 8;
        if (i17 != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            obj = modifier;
            i4 |= startRestartGroup.changed(obj) ? 2048 : 1024;
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                obj2 = paddingValues;
                i4 |= startRestartGroup.changed(obj2) ? 16384 : 8192;
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    z3 = z;
                } else {
                    z3 = z;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= startRestartGroup.changed(z3) ? 131072 : 65536;
                    }
                }
                if ((i & 1572864) == 0) {
                    flingBehavior2 = flingBehavior;
                    i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(flingBehavior2)) ? 1048576 : 524288;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 12582912;
                    z4 = z2;
                } else {
                    z4 = z2;
                    if ((i & 12582912) == 0) {
                        i4 |= startRestartGroup.changed(z4) ? 8388608 : 4194304;
                    }
                }
                if ((i3 & 256) != 0) {
                    i4 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i4 |= startRestartGroup.changed(overscrollEffect) ? 67108864 : 33554432;
                    i8 = i3 & 512;
                    if (i8 == 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i9 = i8;
                        i4 |= startRestartGroup.changed(f) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        i10 = i3 & 1024;
                        if (i10 != 0) {
                            i12 = i2 | 6;
                            i11 = i10;
                        } else if ((i2 & 6) == 0) {
                            i11 = i10;
                            i12 = i2 | (startRestartGroup.changed(f2) ? 4 : 2);
                        } else {
                            i11 = i10;
                            i12 = i2;
                        }
                        if ((i3 & 2048) != 0) {
                            i12 |= 48;
                        } else if ((i2 & 48) == 0) {
                            i12 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
                        }
                        i13 = i12;
                        i14 = i4;
                        if (startRestartGroup.shouldExecute((i14 & 306783379) == 306783378 || (i13 & 19) != 18, i14 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "51@2365L15");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 64) != 0) {
                                    m7996constructorimpl = f2;
                                    z8 = z3;
                                    flingBehavior4 = flingBehavior2;
                                    z7 = z4;
                                    f5 = f;
                                    i16 = i14 & (-3670017);
                                    paddingValues3 = obj2;
                                } else {
                                    m7996constructorimpl = f2;
                                    z8 = z3;
                                    flingBehavior4 = flingBehavior2;
                                    z7 = z4;
                                    paddingValues3 = obj2;
                                    f5 = f;
                                    i16 = i14;
                                }
                                modifier3 = obj;
                            } else {
                                Modifier.Companion companion2 = i17 != 0 ? Modifier.Companion : obj;
                                PaddingValues m836PaddingValues0680j_4 = i5 != 0 ? PaddingKt.m836PaddingValues0680j_4(Dp.m7996constructorimpl(0)) : obj2;
                                if (i6 != 0) {
                                    z3 = false;
                                }
                                if ((i3 & 64) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                    i15 = i14 & (-3670017);
                                } else {
                                    i15 = i14;
                                }
                                z7 = i7 == 0 ? z4 : true;
                                float m7996constructorimpl2 = i9 != 0 ? Dp.m7996constructorimpl(0) : f;
                                m7996constructorimpl = i11 != 0 ? Dp.m7996constructorimpl(0) : f2;
                                modifier3 = companion2;
                                paddingValues3 = m836PaddingValues0680j_4;
                                z8 = z3;
                                flingBehavior4 = flingBehavior2;
                                i16 = i15;
                                f5 = m7996constructorimpl2;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1904835166, i16, i13, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:62)");
                            }
                            int i18 = i16 & 14;
                            Function0<LazyStaggeredGridItemProvider> rememberStaggeredGridItemProviderLambda = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda(lazyStaggeredGridState, function1, startRestartGroup, (i13 & 112) | i18);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalGraphicsContext());
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i19 = i16 >> 6;
                            int i20 = i16 >> 12;
                            int i21 = i16;
                            float f6 = m7996constructorimpl;
                            LazyLayoutMeasurePolicy m1113rememberStaggeredGridMeasurePolicyqKj4JfE = LazyStaggeredGridMeasurePolicyKt.m1113rememberStaggeredGridMeasurePolicyqKj4JfE(lazyStaggeredGridState, rememberStaggeredGridItemProviderLambda, paddingValues3, z8, orientation, f5, f6, (CoroutineScope) rememberedValue, lazyGridStaggeredGridSlotsProvider, (GraphicsContext) consume, startRestartGroup, ((i16 << 18) & 234881024) | (i19 & 7168) | (i19 & 896) | i18 | ((i16 << 9) & 57344) | (i20 & 458752) | ((i13 << 18) & 3670016));
                            PaddingValues paddingValues4 = paddingValues3;
                            float f7 = f5;
                            LazyLayoutSemanticState rememberLazyStaggeredGridSemanticState = LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(lazyStaggeredGridState, z8, startRestartGroup, (i20 & 112) | i18);
                            if (z7) {
                                startRestartGroup.startReplaceGroup(-1834534838);
                                ComposerKt.sourceInformation(startRestartGroup, "84@3604L57");
                                companion = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.Companion, LazyStaggeredGridBeyondBoundsModifierKt.rememberLazyStaggeredGridBeyondBoundsState(lazyStaggeredGridState, startRestartGroup, i18), lazyStaggeredGridState.getBeyondBoundsInfo$foundation_release(), z8, orientation);
                                startRestartGroup.endReplaceGroup();
                            } else {
                                startRestartGroup.startReplaceGroup(-1834229984);
                                startRestartGroup.endReplaceGroup();
                                companion = Modifier.Companion;
                            }
                            boolean z9 = z8;
                            boolean z10 = z7;
                            FlingBehavior flingBehavior5 = flingBehavior4;
                            scrollingContainer = ScrollingContainerKt.scrollingContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier3.then(lazyStaggeredGridState.getRemeasurementModifier$foundation_release()).then(lazyStaggeredGridState.getAwaitLayoutModifier$foundation_release()), rememberStaggeredGridItemProviderLambda, rememberLazyStaggeredGridSemanticState, orientation, z10, z9, startRestartGroup, (i21 & 458752) | ((i21 << 6) & 7168) | ((i21 >> 9) & 57344)).then(companion).then(lazyStaggeredGridState.getItemAnimator$foundation_release().getModifier()), lazyStaggeredGridState, orientation, z10, z9, flingBehavior5, lazyStaggeredGridState.getMutableInteractionSource$foundation_release(), false, overscrollEffect, (i & 256) != 0 ? null : null);
                            LazyLayoutKt.LazyLayout(rememberStaggeredGridItemProviderLambda, scrollingContainer, lazyStaggeredGridState.getPrefetchState$foundation_release(), m1113rememberStaggeredGridMeasurePolicyqKj4JfE, startRestartGroup, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2 = startRestartGroup;
                            flingBehavior3 = flingBehavior5;
                            modifier2 = modifier3;
                            z5 = z10;
                            paddingValues2 = paddingValues4;
                            f4 = f7;
                            f3 = f6;
                            z6 = z9;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            f3 = f2;
                            flingBehavior3 = flingBehavior2;
                            composer2 = startRestartGroup;
                            z5 = z4;
                            paddingValues2 = obj2;
                            z6 = z3;
                            modifier2 = obj;
                            f4 = f;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj3, Object obj4) {
                                    Unit LazyStaggeredGrid_w41Enmo$lambda$0;
                                    LazyStaggeredGrid_w41Enmo$lambda$0 = LazyStaggeredGridKt.LazyStaggeredGrid_w41Enmo$lambda$0(LazyStaggeredGridState.this, orientation, lazyGridStaggeredGridSlotsProvider, modifier2, paddingValues2, z6, flingBehavior3, z5, overscrollEffect, f4, f3, function1, i, i2, i3, (Composer) obj3, ((Integer) obj4).intValue());
                                    return LazyStaggeredGrid_w41Enmo$lambda$0;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i9 = i8;
                    i10 = i3 & 1024;
                    if (i10 != 0) {
                    }
                    if ((i3 & 2048) != 0) {
                    }
                    i13 = i12;
                    i14 = i4;
                    if (startRestartGroup.shouldExecute((i14 & 306783379) == 306783378 || (i13 & 19) != 18, i14 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i8 = i3 & 512;
                if (i8 == 0) {
                }
                i9 = i8;
                i10 = i3 & 1024;
                if (i10 != 0) {
                }
                if ((i3 & 2048) != 0) {
                }
                i13 = i12;
                i14 = i4;
                if (startRestartGroup.shouldExecute((i14 & 306783379) == 306783378 || (i13 & 19) != 18, i14 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj2 = paddingValues;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            i7 = i3 & 128;
            if (i7 != 0) {
            }
            if ((i3 & 256) != 0) {
            }
            i8 = i3 & 512;
            if (i8 == 0) {
            }
            i9 = i8;
            i10 = i3 & 1024;
            if (i10 != 0) {
            }
            if ((i3 & 2048) != 0) {
            }
            i13 = i12;
            i14 = i4;
            if (startRestartGroup.shouldExecute((i14 & 306783379) == 306783378 || (i13 & 19) != 18, i14 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        obj2 = paddingValues;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        i7 = i3 & 128;
        if (i7 != 0) {
        }
        if ((i3 & 256) != 0) {
        }
        i8 = i3 & 512;
        if (i8 == 0) {
        }
        i9 = i8;
        i10 = i3 & 1024;
        if (i10 != 0) {
        }
        if ((i3 & 2048) != 0) {
        }
        i13 = i12;
        i14 = i4;
        if (startRestartGroup.shouldExecute((i14 & 306783379) == 306783378 || (i13 & 19) != 18, i14 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
