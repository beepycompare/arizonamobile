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
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
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
import androidx.compose.ui.unit.Constraints;
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
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0093\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"LazyStaggeredGrid", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyStaggeredGrid-w41Enmo", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;FFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:191:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0102  */
    /* renamed from: LazyStaggeredGrid-w41Enmo  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m947LazyStaggeredGridw41Enmo(final LazyStaggeredGridState lazyStaggeredGridState, final Orientation orientation, final LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider, Modifier modifier, PaddingValues paddingValues, boolean z, FlingBehavior flingBehavior, boolean z2, final OverscrollEffect overscrollEffect, float f, float f2, final Function1<? super LazyStaggeredGridScope, Unit> function1, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Object obj;
        int i5;
        final Object obj2;
        int i6;
        boolean z3;
        Object obj3;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        final boolean z4;
        final float f3;
        Composer composer2;
        final boolean z5;
        final Modifier modifier2;
        final float f4;
        ScopeUpdateScope endRestartGroup;
        FlingBehavior flingBehavior2;
        boolean z6;
        float m6684constructorimpl;
        Modifier modifier3;
        PaddingValues paddingValues2;
        Object obj4;
        boolean z7;
        float f5;
        Modifier.Companion companion;
        Modifier scrollingContainer;
        Composer startRestartGroup = composer.startRestartGroup(-1904835166);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyStaggeredGrid)P(10,6,9,5,1,8,3,11,7,4:c#ui.unit.Dp,2:c#ui.unit.Dp)63@2871L55,64@2952L24,65@3024L7,67@3064L310,79@3399L60,98@4046L302,93@3877L1173:LazyStaggeredGrid.kt#fzvcnm");
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
            i4 |= startRestartGroup.changed(orientation) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= (i & 512) == 0 ? startRestartGroup.changed(lazyGridStaggeredGridSlotsProvider) : startRestartGroup.changedInstance(lazyGridStaggeredGridSlotsProvider) ? 256 : 128;
        }
        int i14 = i3 & 8;
        if (i14 != 0) {
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
                    obj3 = flingBehavior;
                    i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(obj3)) ? 1048576 : 524288;
                } else {
                    obj3 = flingBehavior;
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i4 |= startRestartGroup.changed(z2) ? 8388608 : 4194304;
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
                        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i13 & 19) != 18, i4 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "51@2365L15");
                            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion2 = i14 != 0 ? Modifier.Companion : obj;
                                PaddingValues m731PaddingValues0680j_4 = i5 != 0 ? PaddingKt.m731PaddingValues0680j_4(Dp.m6684constructorimpl(0)) : obj2;
                                if (i6 != 0) {
                                    z3 = false;
                                }
                                if ((i3 & 64) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                    i4 &= -3670017;
                                } else {
                                    flingBehavior2 = obj3;
                                }
                                z6 = i7 == 0 ? z2 : true;
                                float m6684constructorimpl2 = i9 != 0 ? Dp.m6684constructorimpl(0) : f;
                                m6684constructorimpl = i11 != 0 ? Dp.m6684constructorimpl(0) : f2;
                                modifier3 = companion2;
                                paddingValues2 = m731PaddingValues0680j_4;
                                obj4 = flingBehavior2;
                                z7 = z3;
                                f5 = m6684constructorimpl2;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                z6 = z2;
                                m6684constructorimpl = f2;
                                paddingValues2 = obj2;
                                z7 = z3;
                                obj4 = obj3;
                                modifier3 = obj;
                                f5 = f;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1904835166, i4, i13, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:62)");
                            }
                            int i15 = i4 & 14;
                            Function0<LazyStaggeredGridItemProvider> rememberStaggeredGridItemProviderLambda = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda(lazyStaggeredGridState, function1, startRestartGroup, (i13 & 112) | i15);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)558@25470L68:Effects.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -954203484, "CC(remember):Effects.kt#9igjgp");
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
                            int i16 = i4 >> 6;
                            int i17 = i4 >> 12;
                            int i18 = i4;
                            float f6 = m6684constructorimpl;
                            Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> m958rememberStaggeredGridMeasurePolicyqKj4JfE = LazyStaggeredGridMeasurePolicyKt.m958rememberStaggeredGridMeasurePolicyqKj4JfE(lazyStaggeredGridState, rememberStaggeredGridItemProviderLambda, paddingValues2, z7, orientation, f5, f6, (CoroutineScope) rememberedValue, lazyGridStaggeredGridSlotsProvider, (GraphicsContext) consume, startRestartGroup, ((i4 << 18) & 234881024) | (i16 & 7168) | (i16 & 896) | i15 | ((i4 << 9) & 57344) | (i17 & 458752) | ((i13 << 18) & 3670016));
                            PaddingValues paddingValues3 = paddingValues2;
                            float f7 = f5;
                            LazyLayoutSemanticState rememberLazyStaggeredGridSemanticState = LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(lazyStaggeredGridState, z7, startRestartGroup, (i17 & 112) | i15);
                            if (z6) {
                                startRestartGroup.startReplaceGroup(1913386186);
                                ComposerKt.sourceInformation(startRestartGroup, "84@3602L57");
                                companion = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.Companion, LazyStaggeredGridBeyondBoundsModifierKt.rememberLazyStaggeredGridBeyondBoundsState(lazyStaggeredGridState, startRestartGroup, i15), lazyStaggeredGridState.getBeyondBoundsInfo$foundation_release(), z7, orientation);
                                startRestartGroup.endReplaceGroup();
                            } else {
                                startRestartGroup.startReplaceGroup(1913691040);
                                startRestartGroup.endReplaceGroup();
                                companion = Modifier.Companion;
                            }
                            boolean z8 = z7;
                            boolean z9 = z6;
                            FlingBehavior flingBehavior3 = obj4;
                            scrollingContainer = ScrollingContainerKt.scrollingContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier3.then(lazyStaggeredGridState.getRemeasurementModifier$foundation_release()).then(lazyStaggeredGridState.getAwaitLayoutModifier$foundation_release()), rememberStaggeredGridItemProviderLambda, rememberLazyStaggeredGridSemanticState, orientation, z9, z8, startRestartGroup, (i18 & 458752) | ((i18 << 6) & 7168) | ((i18 >> 9) & 57344)).then(companion).then(lazyStaggeredGridState.getItemAnimator$foundation_release().getModifier()), lazyStaggeredGridState, orientation, z9, z8, flingBehavior3, lazyStaggeredGridState.getMutableInteractionSource$foundation_release(), false, overscrollEffect, (i & 256) != 0 ? null : null);
                            obj3 = flingBehavior3;
                            LazyLayoutKt.LazyLayout(rememberStaggeredGridItemProviderLambda, scrollingContainer, lazyStaggeredGridState.getPrefetchState$foundation_release(), m958rememberStaggeredGridMeasurePolicyqKj4JfE, startRestartGroup, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2 = startRestartGroup;
                            modifier2 = modifier3;
                            z4 = z9;
                            obj2 = paddingValues3;
                            f3 = f7;
                            f4 = f6;
                            z5 = z8;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            z4 = z2;
                            f3 = f;
                            composer2 = startRestartGroup;
                            z5 = z3;
                            modifier2 = obj;
                            f4 = f2;
                        }
                        final FlingBehavior flingBehavior4 = obj3;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$LazyStaggeredGrid$1
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

                                public final void invoke(Composer composer3, int i19) {
                                    LazyStaggeredGridKt.m947LazyStaggeredGridw41Enmo(LazyStaggeredGridState.this, orientation, lazyGridStaggeredGridSlotsProvider, modifier2, obj2, z5, flingBehavior4, z4, overscrollEffect, f3, f4, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
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
                    if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i13 & 19) != 18, i4 & 1)) {
                    }
                    final FlingBehavior flingBehavior42 = obj3;
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
                if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i13 & 19) != 18, i4 & 1)) {
                }
                final FlingBehavior flingBehavior422 = obj3;
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
            if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i13 & 19) != 18, i4 & 1)) {
            }
            final FlingBehavior flingBehavior4222 = obj3;
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
        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i13 & 19) != 18, i4 & 1)) {
        }
        final FlingBehavior flingBehavior42222 = obj3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
