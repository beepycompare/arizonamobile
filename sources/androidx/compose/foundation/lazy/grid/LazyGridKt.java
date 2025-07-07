package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: LazyGrid.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0088\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0002\u0010\u001a\u001a\u0088\u0001\u0010\u001b\u001a\u0019\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001c¢\u0006\u0002\b\u00192\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0003¢\u0006\u0002\u0010)¨\u0006*"}, d2 = {"LazyGrid", "", "modifier", "Landroidx/compose/ui/Modifier;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "slots", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyGridMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "stickyItemsScrollBehavior", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:188:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyGrid(Modifier modifier, final LazyGridState lazyGridState, final LazyGridSlotsProvider lazyGridSlotsProvider, PaddingValues paddingValues, boolean z, final boolean z2, FlingBehavior flingBehavior, final boolean z3, final OverscrollEffect overscrollEffect, final Arrangement.Vertical vertical, final Arrangement.Horizontal horizontal, final Function1<? super LazyGridScope, Unit> function1, Composer composer, final int i, final int i2, final int i3) {
        Object obj;
        int i4;
        Object obj2;
        int i5;
        boolean z4;
        Object obj3;
        int i6;
        int i7;
        final PaddingValues paddingValues2;
        final boolean z5;
        final Modifier modifier2;
        final FlingBehavior flingBehavior2;
        ScopeUpdateScope endRestartGroup;
        Modifier.Companion companion;
        PaddingValues m731PaddingValues0680j_4;
        boolean z6;
        FlingBehavior flingBehavior3;
        int i8;
        Object rememberedValue;
        Modifier.Companion companion2;
        Modifier scrollingContainer;
        Composer startRestartGroup = composer.startRestartGroup(708740370);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyGrid)P(5,9,8,1,7,4,2,10,6,11,3)83@3963L50,85@4039L51,87@4117L24,88@4189L7,89@4258L7,92@4299L403,125@5367L302,120@5198L1174:LazyGrid.kt#7791vq");
        int i9 = i3 & 1;
        if (i9 != 0) {
            i4 = i | 6;
            obj = modifier;
        } else if ((i & 6) == 0) {
            obj = modifier;
            i4 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            obj = modifier;
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changed(lazyGridState) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= (i & 512) == 0 ? startRestartGroup.changed(lazyGridSlotsProvider) : startRestartGroup.changedInstance(lazyGridSlotsProvider) ? 256 : 128;
        }
        int i10 = i3 & 8;
        if (i10 != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            obj2 = paddingValues;
            i4 |= startRestartGroup.changed(obj2) ? 2048 : 1024;
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                z4 = z;
                i4 |= startRestartGroup.changed(z4) ? 16384 : 8192;
                if ((i3 & 32) != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i4 |= startRestartGroup.changed(z2) ? 131072 : 65536;
                }
                if ((i & 1572864) == 0) {
                    obj3 = flingBehavior;
                    i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(obj3)) ? 1048576 : 524288;
                } else {
                    obj3 = flingBehavior;
                }
                if ((i3 & 128) != 0) {
                    i4 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i4 |= startRestartGroup.changed(z3) ? 8388608 : 4194304;
                }
                if ((i3 & 256) != 0) {
                    i4 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i4 |= startRestartGroup.changed(overscrollEffect) ? 67108864 : 33554432;
                    if ((i3 & 512) == 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i4 |= startRestartGroup.changed(vertical) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        if ((i3 & 1024) != 0) {
                            i6 = i2 | 6;
                        } else if ((i2 & 6) == 0) {
                            i6 = i2 | (startRestartGroup.changed(horizontal) ? 4 : 2);
                        } else {
                            i6 = i2;
                        }
                        if ((i3 & 2048) != 0) {
                            i6 |= 48;
                        } else if ((i2 & 48) == 0) {
                            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
                        }
                        i7 = i6;
                        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i7 & 19) != 18, i4 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "71@3432L15");
                            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i9 != 0 ? Modifier.Companion : obj;
                                m731PaddingValues0680j_4 = i10 != 0 ? PaddingKt.m731PaddingValues0680j_4(Dp.m6684constructorimpl(0)) : obj2;
                                z6 = i5 == 0 ? z4 : false;
                                if ((i3 & 64) != 0) {
                                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                    i8 = i4 & (-3670017);
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(708740370, i8, i7, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:82)");
                                    }
                                    int i11 = (i8 >> 3) & 14;
                                    Function0<LazyGridItemProvider> rememberLazyGridItemProviderLambda = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, function1, startRestartGroup, (i7 & 112) | i11);
                                    int i12 = i8 >> 9;
                                    LazyLayoutSemanticState rememberLazyGridSemanticState = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z6, startRestartGroup, (i12 & 112) | i11);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)558@25470L68:Effects.kt#9igjgp");
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -954203484, "CC(remember):Effects.kt#9igjgp");
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.Companion.getEmpty()) {
                                        rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalGraphicsContext());
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    GraphicsContext graphicsContext = (GraphicsContext) consume;
                                    CompositionLocal<Boolean> localScrollCaptureInProgress = CompositionLocalsKt.getLocalScrollCaptureInProgress();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object consume2 = startRestartGroup.consume(localScrollCaptureInProgress);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    Modifier modifier3 = companion;
                                    int i13 = i8;
                                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy = rememberLazyGridMeasurePolicy(rememberLazyGridItemProviderLambda, lazyGridState, lazyGridSlotsProvider, m731PaddingValues0680j_4, z6, z2, horizontal, vertical, coroutineScope, graphicsContext, ((Boolean) consume2).booleanValue() ? StickyItemsPlacement.Companion.getStickToTopPlacement() : null, startRestartGroup, (524272 & i8) | ((i7 << 18) & 3670016) | ((i8 >> 6) & 29360128), 0);
                                    PaddingValues paddingValues3 = m731PaddingValues0680j_4;
                                    Orientation orientation = !z2 ? Orientation.Vertical : Orientation.Horizontal;
                                    if (!z3) {
                                        startRestartGroup.startReplaceGroup(-1614890700);
                                        ComposerKt.sourceInformation(startRestartGroup, "111@4933L48");
                                        companion2 = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.Companion, LazyGridBeyondBoundsModifierKt.rememberLazyGridBeyondBoundsState(lazyGridState, startRestartGroup, i11), lazyGridState.getBeyondBoundsInfo$foundation_release(), z6, orientation);
                                        startRestartGroup.endReplaceGroup();
                                    } else {
                                        startRestartGroup.startReplaceGroup(-1614595456);
                                        startRestartGroup.endReplaceGroup();
                                        companion2 = Modifier.Companion;
                                    }
                                    boolean z7 = z6;
                                    FlingBehavior flingBehavior4 = flingBehavior3;
                                    scrollingContainer = ScrollingContainerKt.scrollingContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier3.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), rememberLazyGridItemProviderLambda, rememberLazyGridSemanticState, orientation, z3, z7, startRestartGroup, (i12 & 57344) | ((i13 << 3) & 458752)).then(companion2).then(lazyGridState.getItemAnimator$foundation_release().getModifier()), lazyGridState, orientation, z3, z7, flingBehavior4, lazyGridState.getInternalInteractionSource$foundation_release(), false, overscrollEffect, (i & 256) != 0 ? null : null);
                                    LazyLayoutKt.LazyLayout(rememberLazyGridItemProviderLambda, scrollingContainer, lazyGridState.getPrefetchState$foundation_release(), rememberLazyGridMeasurePolicy, startRestartGroup, 0, 0);
                                    startRestartGroup = startRestartGroup;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    flingBehavior2 = flingBehavior4;
                                    z5 = z7;
                                    modifier2 = modifier3;
                                    paddingValues2 = paddingValues3;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                m731PaddingValues0680j_4 = obj2;
                                z6 = z4;
                                companion = obj;
                            }
                            i8 = i4;
                            flingBehavior3 = obj3;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i112 = (i8 >> 3) & 14;
                            Function0<LazyGridItemProvider> rememberLazyGridItemProviderLambda2 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, function1, startRestartGroup, (i7 & 112) | i112);
                            int i122 = i8 >> 9;
                            LazyLayoutSemanticState rememberLazyGridSemanticState2 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z6, startRestartGroup, (i122 & 112) | i112);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)558@25470L68:Effects.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -954203484, "CC(remember):Effects.kt#9igjgp");
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                            }
                            CoroutineScope coroutineScope2 = (CoroutineScope) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalGraphicsContext());
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            GraphicsContext graphicsContext2 = (GraphicsContext) consume3;
                            CompositionLocal<Boolean> localScrollCaptureInProgress2 = CompositionLocalsKt.getLocalScrollCaptureInProgress();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume22 = startRestartGroup.consume(localScrollCaptureInProgress2);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Modifier modifier32 = companion;
                            int i132 = i8;
                            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy2 = rememberLazyGridMeasurePolicy(rememberLazyGridItemProviderLambda2, lazyGridState, lazyGridSlotsProvider, m731PaddingValues0680j_4, z6, z2, horizontal, vertical, coroutineScope2, graphicsContext2, ((Boolean) consume22).booleanValue() ? StickyItemsPlacement.Companion.getStickToTopPlacement() : null, startRestartGroup, (524272 & i8) | ((i7 << 18) & 3670016) | ((i8 >> 6) & 29360128), 0);
                            PaddingValues paddingValues32 = m731PaddingValues0680j_4;
                            Orientation orientation2 = !z2 ? Orientation.Vertical : Orientation.Horizontal;
                            if (!z3) {
                            }
                            boolean z72 = z6;
                            FlingBehavior flingBehavior42 = flingBehavior3;
                            scrollingContainer = ScrollingContainerKt.scrollingContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier32.then(lazyGridState.getRemeasurementModifier$foundation_release()).then(lazyGridState.getAwaitLayoutModifier$foundation_release()), rememberLazyGridItemProviderLambda2, rememberLazyGridSemanticState2, orientation2, z3, z72, startRestartGroup, (i122 & 57344) | ((i132 << 3) & 458752)).then(companion2).then(lazyGridState.getItemAnimator$foundation_release().getModifier()), lazyGridState, orientation2, z3, z72, flingBehavior42, lazyGridState.getInternalInteractionSource$foundation_release(), false, overscrollEffect, (i & 256) != 0 ? null : null);
                            LazyLayoutKt.LazyLayout(rememberLazyGridItemProviderLambda2, scrollingContainer, lazyGridState.getPrefetchState$foundation_release(), rememberLazyGridMeasurePolicy2, startRestartGroup, 0, 0);
                            startRestartGroup = startRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            flingBehavior2 = flingBehavior42;
                            z5 = z72;
                            modifier2 = modifier32;
                            paddingValues2 = paddingValues32;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            paddingValues2 = obj2;
                            z5 = z4;
                            modifier2 = obj;
                            flingBehavior2 = obj3;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$LazyGrid$1
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
                                    LazyGridKt.LazyGrid(Modifier.this, lazyGridState, lazyGridSlotsProvider, paddingValues2, z5, z2, flingBehavior2, z3, overscrollEffect, vertical, horizontal, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i3 & 1024) != 0) {
                    }
                    if ((i3 & 2048) != 0) {
                    }
                    i7 = i6;
                    if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i7 & 19) != 18, i4 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                if ((i3 & 512) == 0) {
                }
                if ((i3 & 1024) != 0) {
                }
                if ((i3 & 2048) != 0) {
                }
                i7 = i6;
                if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i7 & 19) != 18, i4 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z4 = z;
            if ((i3 & 32) != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i3 & 128) != 0) {
            }
            if ((i3 & 256) != 0) {
            }
            if ((i3 & 512) == 0) {
            }
            if ((i3 & 1024) != 0) {
            }
            if ((i3 & 2048) != 0) {
            }
            i7 = i6;
            if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i7 & 19) != 18, i4 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj2 = paddingValues;
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        z4 = z;
        if ((i3 & 32) != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i3 & 128) != 0) {
        }
        if ((i3 & 256) != 0) {
        }
        if ((i3 & 512) == 0) {
        }
        if ((i3 & 1024) != 0) {
        }
        if ((i3 & 2048) != 0) {
        }
        i7 = i6;
        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i7 & 19) != 18, i4 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0094, code lost:
        if (r29.changed(r3) == false) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy(final Function0<? extends LazyGridItemProvider> function0, final LazyGridState lazyGridState, final LazyGridSlotsProvider lazyGridSlotsProvider, final PaddingValues paddingValues, final boolean z, boolean z2, final Arrangement.Horizontal horizontal, final Arrangement.Vertical vertical, final CoroutineScope coroutineScope, final GraphicsContext graphicsContext, final StickyItemsPlacement stickyItemsPlacement, Composer composer, int i, int i2) {
        boolean z3;
        boolean z4;
        boolean changed;
        Object rememberedValue;
        ComposerKt.sourceInformationMarkerStart(composer, -2025385037, "C(rememberLazyGridMeasurePolicy)P(5,8,7!1,6,4,3,10)179@7592L11578:LazyGrid.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2025385037, i, i2, "androidx.compose.foundation.lazy.grid.rememberLazyGridMeasurePolicy (LazyGrid.kt:179)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1026611131, "CC(remember):LazyGrid.kt#9igjgp");
        boolean z5 = ((((i & 112) ^ 48) > 32 && composer.changed(lazyGridState)) || (i & 48) == 32) | ((((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(lazyGridSlotsProvider)) || (i & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(paddingValues)) || (i & 3072) == 2048) | ((((57344 & i) ^ 24576) > 16384 && composer.changed(z)) || (i & 24576) == 16384);
        if (((458752 & i) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072) {
            z3 = z2;
        } else {
            z3 = z2;
        }
        if ((196608 & i) != 131072) {
            z4 = false;
            changed = z5 | z4 | ((((3670016 & i) ^ 1572864) <= 1048576 && composer.changed(horizontal)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) > 8388608 && composer.changed(vertical)) || (i & 12582912) == 8388608) | composer.changed(graphicsContext);
            rememberedValue = composer.rememberedValue();
            if (!changed || rememberedValue == Composer.Companion.getEmpty()) {
                final boolean z6 = z3;
                rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ LazyGridMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                        return m879invoke0kLqBqw(lazyLayoutMeasureScope, constraints.m6643unboximpl());
                    }

                    /* JADX WARN: Type inference failed for: r22v1, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1] */
                    /* JADX WARN: Type inference failed for: r27v0, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1] */
                    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                    public final LazyGridMeasureResult m879invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                        int i3;
                        int i4;
                        int i5;
                        float mo625getSpacingD9Ej5fM;
                        int m6637getMaxWidthimpl;
                        LazyGridItemProvider lazyGridItemProvider;
                        long m6806constructorimpl;
                        int lineIndexOfItem;
                        int firstVisibleItemScrollOffset;
                        float scrollToBeConsumed$foundation_release;
                        ObservableScopeInvalidator.m918attachToScopeimpl(LazyGridState.this.m887getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                        boolean z7 = LazyGridState.this.getHasLookaheadOccurred$foundation_release() || lazyLayoutMeasureScope.isLookingAhead();
                        CheckScrollableContainerConstraintsKt.m275checkScrollableContainerConstraintsK40F9xA(j, z6 ? Orientation.Vertical : Orientation.Horizontal);
                        if (z6) {
                            i3 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo688calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                        } else {
                            i3 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                        }
                        if (z6) {
                            i4 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo689calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                        } else {
                            i4 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                        }
                        int i6 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo690calculateTopPaddingD9Ej5fM());
                        int i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo687calculateBottomPaddingD9Ej5fM());
                        final int i8 = i6 + i7;
                        final int i9 = i3 + i4;
                        boolean z8 = z6;
                        int i10 = z8 ? i8 : i9;
                        if (z8 && !z) {
                            i5 = i6;
                        } else if (z8 && z) {
                            i5 = i7;
                        } else {
                            i5 = (z8 || z) ? i4 : i3;
                        }
                        final int i11 = i10 - i5;
                        long m6656offsetNN6EwU = ConstraintsKt.m6656offsetNN6EwU(j, -i9, -i8);
                        LazyGridItemProvider invoke = function0.invoke();
                        final LazyGridSpanLayoutProvider spanLayoutProvider = invoke.getSpanLayoutProvider();
                        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                        final LazyGridSlots mo867invoke0kLqBqw = lazyGridSlotsProvider.mo867invoke0kLqBqw(lazyLayoutMeasureScope2, m6656offsetNN6EwU);
                        int length = mo867invoke0kLqBqw.getSizes().length;
                        spanLayoutProvider.setSlotsPerLine(length);
                        if (z6) {
                            Arrangement.Vertical vertical2 = vertical;
                            if (vertical2 != null) {
                                mo625getSpacingD9Ej5fM = vertical2.mo625getSpacingD9Ej5fM();
                            } else {
                                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                                throw new KotlinNothingValueException();
                            }
                        } else {
                            Arrangement.Horizontal horizontal2 = horizontal;
                            if (horizontal2 != null) {
                                mo625getSpacingD9Ej5fM = horizontal2.mo625getSpacingD9Ej5fM();
                            } else {
                                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalArrangement when isVertical == false");
                                throw new KotlinNothingValueException();
                            }
                        }
                        final int i12 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(mo625getSpacingD9Ej5fM);
                        final int itemCount = invoke.getItemCount();
                        if (z6) {
                            m6637getMaxWidthimpl = Constraints.m6636getMaxHeightimpl(j) - i8;
                        } else {
                            m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j) - i9;
                        }
                        int i13 = m6637getMaxWidthimpl;
                        if (z && i13 <= 0) {
                            boolean z9 = z6;
                            if (!z9) {
                                i3 += i13;
                            }
                            if (z9) {
                                i6 += i13;
                            }
                            lazyGridItemProvider = invoke;
                            m6806constructorimpl = IntOffset.m6806constructorimpl((i3 << 32) | (i6 & 4294967295L));
                        } else {
                            lazyGridItemProvider = invoke;
                            m6806constructorimpl = IntOffset.m6806constructorimpl((i3 << 32) | (i6 & 4294967295L));
                        }
                        final LazyGridState lazyGridState2 = LazyGridState.this;
                        final boolean z10 = z6;
                        final boolean z11 = z;
                        final int i14 = i5;
                        final long j2 = m6806constructorimpl;
                        final LazyGridItemProvider lazyGridItemProvider2 = lazyGridItemProvider;
                        final ?? r27 = new LazyGridMeasuredItemProvider(lazyGridItemProvider2, lazyLayoutMeasureScope, i12, lazyGridState2, z10, z11, i14, i11, j2) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1
                            final /* synthetic */ int $afterContentPadding;
                            final /* synthetic */ int $beforeContentPadding;
                            final /* synthetic */ boolean $isVertical;
                            final /* synthetic */ boolean $reverseLayout;
                            final /* synthetic */ LazyGridState $state;
                            final /* synthetic */ LazyLayoutMeasureScope $this_null;
                            final /* synthetic */ long $visualItemOffset;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.$this_null = lazyLayoutMeasureScope;
                                this.$state = lazyGridState2;
                                this.$isVertical = z10;
                                this.$reverseLayout = z11;
                                this.$beforeContentPadding = i14;
                                this.$afterContentPadding = i11;
                                this.$visualItemOffset = j2;
                            }

                            @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider
                            /* renamed from: createItem-O3s9Psw  reason: not valid java name */
                            public LazyGridMeasuredItem mo880createItemO3s9Psw(int i15, Object obj, Object obj2, int i16, int i17, List<? extends Placeable> list, long j3, int i18, int i19) {
                                return new LazyGridMeasuredItem(i15, obj, this.$isVertical, i16, i17, this.$reverseLayout, this.$this_null.getLayoutDirection(), this.$beforeContentPadding, this.$afterContentPadding, list, this.$visualItemOffset, obj2, this.$state.getItemAnimator$foundation_release(), j3, i18, i19, null);
                            }
                        };
                        final boolean z12 = z6;
                        final ?? r22 = new LazyGridMeasuredLineProvider(z12, mo867invoke0kLqBqw, itemCount, i12, r27, spanLayoutProvider) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1
                            final /* synthetic */ boolean $isVertical;
                            final /* synthetic */ LazyGridSlots $resolvedSlots;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(z12, mo867invoke0kLqBqw, itemCount, i12, r27, spanLayoutProvider);
                                this.$isVertical = z12;
                                this.$resolvedSlots = mo867invoke0kLqBqw;
                            }

                            @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider
                            public LazyGridMeasuredLine createLine(int i15, LazyGridMeasuredItem[] lazyGridMeasuredItemArr, List<GridItemSpan> list, int i16) {
                                return new LazyGridMeasuredLine(i15, lazyGridMeasuredItemArr, this.$resolvedSlots, list, this.$isVertical, i16);
                            }
                        };
                        Function1<Integer, ArrayList<Pair<? extends Integer, ? extends Constraints>>> function1 = new Function1<Integer, ArrayList<Pair<? extends Integer, ? extends Constraints>>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$prefetchInfoRetriever$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ ArrayList<Pair<? extends Integer, ? extends Constraints>> invoke(Integer num) {
                                return invoke(num.intValue());
                            }

                            public final ArrayList<Pair<Integer, Constraints>> invoke(int i15) {
                                LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = LazyGridSpanLayoutProvider.this.getLineConfiguration(i15);
                                int firstItemIndex = lineConfiguration.getFirstItemIndex();
                                ArrayList<Pair<Integer, Constraints>> arrayList = new ArrayList<>(lineConfiguration.getSpans().size());
                                List<GridItemSpan> spans = lineConfiguration.getSpans();
                                LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 = r22;
                                int size = spans.size();
                                int i16 = 0;
                                for (int i17 = 0; i17 < size; i17++) {
                                    int m863getCurrentLineSpanimpl = GridItemSpan.m863getCurrentLineSpanimpl(spans.get(i17).m866unboximpl());
                                    arrayList.add(TuplesKt.to(Integer.valueOf(firstItemIndex), Constraints.m6624boximpl(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1.m886childConstraintsJhjzzOo$foundation_release(i16, m863getCurrentLineSpanimpl))));
                                    firstItemIndex++;
                                    i16 += m863getCurrentLineSpanimpl;
                                }
                                return arrayList;
                            }
                        };
                        Snapshot.Companion companion = Snapshot.Companion;
                        LazyGridState lazyGridState3 = LazyGridState.this;
                        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                        try {
                            int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyGridState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyGridItemProvider2, lazyGridState3.getFirstVisibleItemIndex());
                            if (updateScrollPositionIfTheFirstItemWasMoved$foundation_release >= itemCount && itemCount > 0) {
                                lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(itemCount - 1);
                                firstVisibleItemScrollOffset = 0;
                                int i15 = lineIndexOfItem;
                                Unit unit = Unit.INSTANCE;
                                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                List<Integer> calculateLazyLayoutPinnedIndices = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyGridItemProvider2, LazyGridState.this.getPinnedItems$foundation_release(), LazyGridState.this.getBeyondBoundsInfo$foundation_release());
                                if (!lazyLayoutMeasureScope.isLookingAhead() || !z7) {
                                    scrollToBeConsumed$foundation_release = LazyGridState.this.getScrollToBeConsumed$foundation_release();
                                } else {
                                    scrollToBeConsumed$foundation_release = LazyGridState.this.getScrollDeltaBetweenPasses$foundation_release();
                                }
                                LazyGridMeasureResult m882measureLazyGridGyuLg2I = LazyGridMeasureKt.m882measureLazyGridGyuLg2I(itemCount, (LazyGridMeasuredLineProvider) r22, (LazyGridMeasuredItemProvider) r27, i13, i14, i11, i12, i15, firstVisibleItemScrollOffset, scrollToBeConsumed$foundation_release, m6656offsetNN6EwU, z6, vertical, horizontal, z, lazyLayoutMeasureScope2, LazyGridState.this.getItemAnimator$foundation_release(), length, calculateLazyLayoutPinnedIndices, z7, lazyLayoutMeasureScope.isLookingAhead(), LazyGridState.this.getApproachLayoutInfo$foundation_release(), coroutineScope, LazyGridState.this.m888getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, function1, stickyItemsPlacement, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measureResult$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function12) {
                                        return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function12);
                                    }

                                    public final MeasureResult invoke(int i16, int i17, Function1<? super Placeable.PlacementScope, Unit> function12) {
                                        return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6654constrainWidthK40F9xA(j, i16 + i9), ConstraintsKt.m6653constrainHeightK40F9xA(j, i17 + i8), MapsKt.emptyMap(), function12);
                                    }
                                });
                                LazyGridState.applyMeasureResult$foundation_release$default(LazyGridState.this, m882measureLazyGridGyuLg2I, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                                return m882measureLazyGridGyuLg2I;
                            }
                            lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(updateScrollPositionIfTheFirstItemWasMoved$foundation_release);
                            firstVisibleItemScrollOffset = lazyGridState3.getFirstVisibleItemScrollOffset();
                            int i152 = lineIndexOfItem;
                            Unit unit2 = Unit.INSTANCE;
                            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                            List<Integer> calculateLazyLayoutPinnedIndices2 = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyGridItemProvider2, LazyGridState.this.getPinnedItems$foundation_release(), LazyGridState.this.getBeyondBoundsInfo$foundation_release());
                            if (!lazyLayoutMeasureScope.isLookingAhead()) {
                            }
                            scrollToBeConsumed$foundation_release = LazyGridState.this.getScrollToBeConsumed$foundation_release();
                            LazyGridMeasureResult m882measureLazyGridGyuLg2I2 = LazyGridMeasureKt.m882measureLazyGridGyuLg2I(itemCount, (LazyGridMeasuredLineProvider) r22, (LazyGridMeasuredItemProvider) r27, i13, i14, i11, i12, i152, firstVisibleItemScrollOffset, scrollToBeConsumed$foundation_release, m6656offsetNN6EwU, z6, vertical, horizontal, z, lazyLayoutMeasureScope2, LazyGridState.this.getItemAnimator$foundation_release(), length, calculateLazyLayoutPinnedIndices2, z7, lazyLayoutMeasureScope.isLookingAhead(), LazyGridState.this.getApproachLayoutInfo$foundation_release(), coroutineScope, LazyGridState.this.m888getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, function1, stickyItemsPlacement, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measureResult$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function12) {
                                    return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function12);
                                }

                                public final MeasureResult invoke(int i16, int i17, Function1<? super Placeable.PlacementScope, Unit> function12) {
                                    return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6654constrainWidthK40F9xA(j, i16 + i9), ConstraintsKt.m6653constrainHeightK40F9xA(j, i17 + i8), MapsKt.emptyMap(), function12);
                                }
                            });
                            LazyGridState.applyMeasureResult$foundation_release$default(LazyGridState.this, m882measureLazyGridGyuLg2I2, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                            return m882measureLazyGridGyuLg2I2;
                        } catch (Throwable th) {
                            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                            throw th;
                        }
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2 = (Function2) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return function2;
        }
        z4 = true;
        if (((29360128 & i) ^ 12582912) > 8388608) {
            changed = z5 | z4 | ((((3670016 & i) ^ 1572864) <= 1048576 && composer.changed(horizontal)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) > 8388608 && composer.changed(vertical)) || (i & 12582912) == 8388608) | composer.changed(graphicsContext);
            rememberedValue = composer.rememberedValue();
            if (!changed) {
            }
            final boolean z62 = z3;
            rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyGridMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m879invoke0kLqBqw(lazyLayoutMeasureScope, constraints.m6643unboximpl());
                }

                /* JADX WARN: Type inference failed for: r22v1, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1] */
                /* JADX WARN: Type inference failed for: r27v0, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1] */
                /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                public final LazyGridMeasureResult m879invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                    int i3;
                    int i4;
                    int i5;
                    float mo625getSpacingD9Ej5fM;
                    int m6637getMaxWidthimpl;
                    LazyGridItemProvider lazyGridItemProvider;
                    long m6806constructorimpl;
                    int lineIndexOfItem;
                    int firstVisibleItemScrollOffset;
                    float scrollToBeConsumed$foundation_release;
                    ObservableScopeInvalidator.m918attachToScopeimpl(LazyGridState.this.m887getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                    boolean z7 = LazyGridState.this.getHasLookaheadOccurred$foundation_release() || lazyLayoutMeasureScope.isLookingAhead();
                    CheckScrollableContainerConstraintsKt.m275checkScrollableContainerConstraintsK40F9xA(j, z62 ? Orientation.Vertical : Orientation.Horizontal);
                    if (z62) {
                        i3 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo688calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i3 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    if (z62) {
                        i4 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo689calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i4 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    int i6 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo690calculateTopPaddingD9Ej5fM());
                    int i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo687calculateBottomPaddingD9Ej5fM());
                    final int i8 = i6 + i7;
                    final int i9 = i3 + i4;
                    boolean z8 = z62;
                    int i10 = z8 ? i8 : i9;
                    if (z8 && !z) {
                        i5 = i6;
                    } else if (z8 && z) {
                        i5 = i7;
                    } else {
                        i5 = (z8 || z) ? i4 : i3;
                    }
                    final int i11 = i10 - i5;
                    long m6656offsetNN6EwU = ConstraintsKt.m6656offsetNN6EwU(j, -i9, -i8);
                    LazyGridItemProvider invoke = function0.invoke();
                    final LazyGridSpanLayoutProvider spanLayoutProvider = invoke.getSpanLayoutProvider();
                    LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                    final LazyGridSlots mo867invoke0kLqBqw = lazyGridSlotsProvider.mo867invoke0kLqBqw(lazyLayoutMeasureScope2, m6656offsetNN6EwU);
                    int length = mo867invoke0kLqBqw.getSizes().length;
                    spanLayoutProvider.setSlotsPerLine(length);
                    if (z62) {
                        Arrangement.Vertical vertical2 = vertical;
                        if (vertical2 != null) {
                            mo625getSpacingD9Ej5fM = vertical2.mo625getSpacingD9Ej5fM();
                        } else {
                            InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                            throw new KotlinNothingValueException();
                        }
                    } else {
                        Arrangement.Horizontal horizontal2 = horizontal;
                        if (horizontal2 != null) {
                            mo625getSpacingD9Ej5fM = horizontal2.mo625getSpacingD9Ej5fM();
                        } else {
                            InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalArrangement when isVertical == false");
                            throw new KotlinNothingValueException();
                        }
                    }
                    final int i12 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(mo625getSpacingD9Ej5fM);
                    final int itemCount = invoke.getItemCount();
                    if (z62) {
                        m6637getMaxWidthimpl = Constraints.m6636getMaxHeightimpl(j) - i8;
                    } else {
                        m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j) - i9;
                    }
                    int i13 = m6637getMaxWidthimpl;
                    if (z && i13 <= 0) {
                        boolean z9 = z62;
                        if (!z9) {
                            i3 += i13;
                        }
                        if (z9) {
                            i6 += i13;
                        }
                        lazyGridItemProvider = invoke;
                        m6806constructorimpl = IntOffset.m6806constructorimpl((i3 << 32) | (i6 & 4294967295L));
                    } else {
                        lazyGridItemProvider = invoke;
                        m6806constructorimpl = IntOffset.m6806constructorimpl((i3 << 32) | (i6 & 4294967295L));
                    }
                    final LazyGridState lazyGridState2 = LazyGridState.this;
                    final boolean z10 = z62;
                    final boolean z11 = z;
                    final int i14 = i5;
                    final long j2 = m6806constructorimpl;
                    final LazyGridItemProvider lazyGridItemProvider2 = lazyGridItemProvider;
                    final LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 r27 = new LazyGridMeasuredItemProvider(lazyGridItemProvider2, lazyLayoutMeasureScope, i12, lazyGridState2, z10, z11, i14, i11, j2) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1
                        final /* synthetic */ int $afterContentPadding;
                        final /* synthetic */ int $beforeContentPadding;
                        final /* synthetic */ boolean $isVertical;
                        final /* synthetic */ boolean $reverseLayout;
                        final /* synthetic */ LazyGridState $state;
                        final /* synthetic */ LazyLayoutMeasureScope $this_null;
                        final /* synthetic */ long $visualItemOffset;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.$this_null = lazyLayoutMeasureScope;
                            this.$state = lazyGridState2;
                            this.$isVertical = z10;
                            this.$reverseLayout = z11;
                            this.$beforeContentPadding = i14;
                            this.$afterContentPadding = i11;
                            this.$visualItemOffset = j2;
                        }

                        @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider
                        /* renamed from: createItem-O3s9Psw  reason: not valid java name */
                        public LazyGridMeasuredItem mo880createItemO3s9Psw(int i15, Object obj, Object obj2, int i16, int i17, List<? extends Placeable> list, long j3, int i18, int i19) {
                            return new LazyGridMeasuredItem(i15, obj, this.$isVertical, i16, i17, this.$reverseLayout, this.$this_null.getLayoutDirection(), this.$beforeContentPadding, this.$afterContentPadding, list, this.$visualItemOffset, obj2, this.$state.getItemAnimator$foundation_release(), j3, i18, i19, null);
                        }
                    };
                    final boolean z12 = z62;
                    final LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 r22 = new LazyGridMeasuredLineProvider(z12, mo867invoke0kLqBqw, itemCount, i12, r27, spanLayoutProvider) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1
                        final /* synthetic */ boolean $isVertical;
                        final /* synthetic */ LazyGridSlots $resolvedSlots;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(z12, mo867invoke0kLqBqw, itemCount, i12, r27, spanLayoutProvider);
                            this.$isVertical = z12;
                            this.$resolvedSlots = mo867invoke0kLqBqw;
                        }

                        @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider
                        public LazyGridMeasuredLine createLine(int i15, LazyGridMeasuredItem[] lazyGridMeasuredItemArr, List<GridItemSpan> list, int i16) {
                            return new LazyGridMeasuredLine(i15, lazyGridMeasuredItemArr, this.$resolvedSlots, list, this.$isVertical, i16);
                        }
                    };
                    Function1<Integer, ArrayList<Pair<? extends Integer, ? extends Constraints>>> function1 = new Function1<Integer, ArrayList<Pair<? extends Integer, ? extends Constraints>>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$prefetchInfoRetriever$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ ArrayList<Pair<? extends Integer, ? extends Constraints>> invoke(Integer num) {
                            return invoke(num.intValue());
                        }

                        public final ArrayList<Pair<Integer, Constraints>> invoke(int i15) {
                            LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = LazyGridSpanLayoutProvider.this.getLineConfiguration(i15);
                            int firstItemIndex = lineConfiguration.getFirstItemIndex();
                            ArrayList<Pair<Integer, Constraints>> arrayList = new ArrayList<>(lineConfiguration.getSpans().size());
                            List<GridItemSpan> spans = lineConfiguration.getSpans();
                            LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 = r22;
                            int size = spans.size();
                            int i16 = 0;
                            for (int i17 = 0; i17 < size; i17++) {
                                int m863getCurrentLineSpanimpl = GridItemSpan.m863getCurrentLineSpanimpl(spans.get(i17).m866unboximpl());
                                arrayList.add(TuplesKt.to(Integer.valueOf(firstItemIndex), Constraints.m6624boximpl(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1.m886childConstraintsJhjzzOo$foundation_release(i16, m863getCurrentLineSpanimpl))));
                                firstItemIndex++;
                                i16 += m863getCurrentLineSpanimpl;
                            }
                            return arrayList;
                        }
                    };
                    Snapshot.Companion companion = Snapshot.Companion;
                    LazyGridState lazyGridState3 = LazyGridState.this;
                    Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                    Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                    Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                    try {
                        int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyGridState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyGridItemProvider2, lazyGridState3.getFirstVisibleItemIndex());
                        if (updateScrollPositionIfTheFirstItemWasMoved$foundation_release >= itemCount && itemCount > 0) {
                            lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(itemCount - 1);
                            firstVisibleItemScrollOffset = 0;
                            int i152 = lineIndexOfItem;
                            Unit unit2 = Unit.INSTANCE;
                            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                            List<Integer> calculateLazyLayoutPinnedIndices2 = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyGridItemProvider2, LazyGridState.this.getPinnedItems$foundation_release(), LazyGridState.this.getBeyondBoundsInfo$foundation_release());
                            if (!lazyLayoutMeasureScope.isLookingAhead() || !z7) {
                                scrollToBeConsumed$foundation_release = LazyGridState.this.getScrollToBeConsumed$foundation_release();
                            } else {
                                scrollToBeConsumed$foundation_release = LazyGridState.this.getScrollDeltaBetweenPasses$foundation_release();
                            }
                            LazyGridMeasureResult m882measureLazyGridGyuLg2I2 = LazyGridMeasureKt.m882measureLazyGridGyuLg2I(itemCount, (LazyGridMeasuredLineProvider) r22, (LazyGridMeasuredItemProvider) r27, i13, i14, i11, i12, i152, firstVisibleItemScrollOffset, scrollToBeConsumed$foundation_release, m6656offsetNN6EwU, z62, vertical, horizontal, z, lazyLayoutMeasureScope2, LazyGridState.this.getItemAnimator$foundation_release(), length, calculateLazyLayoutPinnedIndices2, z7, lazyLayoutMeasureScope.isLookingAhead(), LazyGridState.this.getApproachLayoutInfo$foundation_release(), coroutineScope, LazyGridState.this.m888getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, function1, stickyItemsPlacement, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measureResult$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function12) {
                                    return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function12);
                                }

                                public final MeasureResult invoke(int i16, int i17, Function1<? super Placeable.PlacementScope, Unit> function12) {
                                    return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6654constrainWidthK40F9xA(j, i16 + i9), ConstraintsKt.m6653constrainHeightK40F9xA(j, i17 + i8), MapsKt.emptyMap(), function12);
                                }
                            });
                            LazyGridState.applyMeasureResult$foundation_release$default(LazyGridState.this, m882measureLazyGridGyuLg2I2, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                            return m882measureLazyGridGyuLg2I2;
                        }
                        lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(updateScrollPositionIfTheFirstItemWasMoved$foundation_release);
                        firstVisibleItemScrollOffset = lazyGridState3.getFirstVisibleItemScrollOffset();
                        int i1522 = lineIndexOfItem;
                        Unit unit22 = Unit.INSTANCE;
                        companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                        List<Integer> calculateLazyLayoutPinnedIndices22 = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyGridItemProvider2, LazyGridState.this.getPinnedItems$foundation_release(), LazyGridState.this.getBeyondBoundsInfo$foundation_release());
                        if (!lazyLayoutMeasureScope.isLookingAhead()) {
                        }
                        scrollToBeConsumed$foundation_release = LazyGridState.this.getScrollToBeConsumed$foundation_release();
                        LazyGridMeasureResult m882measureLazyGridGyuLg2I22 = LazyGridMeasureKt.m882measureLazyGridGyuLg2I(itemCount, (LazyGridMeasuredLineProvider) r22, (LazyGridMeasuredItemProvider) r27, i13, i14, i11, i12, i1522, firstVisibleItemScrollOffset, scrollToBeConsumed$foundation_release, m6656offsetNN6EwU, z62, vertical, horizontal, z, lazyLayoutMeasureScope2, LazyGridState.this.getItemAnimator$foundation_release(), length, calculateLazyLayoutPinnedIndices22, z7, lazyLayoutMeasureScope.isLookingAhead(), LazyGridState.this.getApproachLayoutInfo$foundation_release(), coroutineScope, LazyGridState.this.m888getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, function1, stickyItemsPlacement, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measureResult$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function12) {
                                return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function12);
                            }

                            public final MeasureResult invoke(int i16, int i17, Function1<? super Placeable.PlacementScope, Unit> function12) {
                                return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6654constrainWidthK40F9xA(j, i16 + i9), ConstraintsKt.m6653constrainHeightK40F9xA(j, i17 + i8), MapsKt.emptyMap(), function12);
                            }
                        });
                        LazyGridState.applyMeasureResult$foundation_release$default(LazyGridState.this, m882measureLazyGridGyuLg2I22, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                        return m882measureLazyGridGyuLg2I22;
                    } catch (Throwable th) {
                        companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                        throw th;
                    }
                }
            };
            composer.updateRememberedValue(rememberedValue);
            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function22 = (Function2) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return function22;
        }
        changed = z5 | z4 | ((((3670016 & i) ^ 1572864) <= 1048576 && composer.changed(horizontal)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) > 8388608 && composer.changed(vertical)) || (i & 12582912) == 8388608) | composer.changed(graphicsContext);
        rememberedValue = composer.rememberedValue();
        if (!changed) {
        }
        final boolean z622 = z3;
        rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ LazyGridMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                return m879invoke0kLqBqw(lazyLayoutMeasureScope, constraints.m6643unboximpl());
            }

            /* JADX WARN: Type inference failed for: r22v1, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1] */
            /* JADX WARN: Type inference failed for: r27v0, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1] */
            /* renamed from: invoke-0kLqBqw  reason: not valid java name */
            public final LazyGridMeasureResult m879invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                int i3;
                int i4;
                int i5;
                float mo625getSpacingD9Ej5fM;
                int m6637getMaxWidthimpl;
                LazyGridItemProvider lazyGridItemProvider;
                long m6806constructorimpl;
                int lineIndexOfItem;
                int firstVisibleItemScrollOffset;
                float scrollToBeConsumed$foundation_release;
                ObservableScopeInvalidator.m918attachToScopeimpl(LazyGridState.this.m887getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                boolean z7 = LazyGridState.this.getHasLookaheadOccurred$foundation_release() || lazyLayoutMeasureScope.isLookingAhead();
                CheckScrollableContainerConstraintsKt.m275checkScrollableContainerConstraintsK40F9xA(j, z622 ? Orientation.Vertical : Orientation.Horizontal);
                if (z622) {
                    i3 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo688calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                } else {
                    i3 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                }
                if (z622) {
                    i4 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo689calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                } else {
                    i4 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                }
                int i6 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo690calculateTopPaddingD9Ej5fM());
                int i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo687calculateBottomPaddingD9Ej5fM());
                final int i8 = i6 + i7;
                final int i9 = i3 + i4;
                boolean z8 = z622;
                int i10 = z8 ? i8 : i9;
                if (z8 && !z) {
                    i5 = i6;
                } else if (z8 && z) {
                    i5 = i7;
                } else {
                    i5 = (z8 || z) ? i4 : i3;
                }
                final int i11 = i10 - i5;
                long m6656offsetNN6EwU = ConstraintsKt.m6656offsetNN6EwU(j, -i9, -i8);
                LazyGridItemProvider invoke = function0.invoke();
                final LazyGridSpanLayoutProvider spanLayoutProvider = invoke.getSpanLayoutProvider();
                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                final LazyGridSlots mo867invoke0kLqBqw = lazyGridSlotsProvider.mo867invoke0kLqBqw(lazyLayoutMeasureScope2, m6656offsetNN6EwU);
                int length = mo867invoke0kLqBqw.getSizes().length;
                spanLayoutProvider.setSlotsPerLine(length);
                if (z622) {
                    Arrangement.Vertical vertical2 = vertical;
                    if (vertical2 != null) {
                        mo625getSpacingD9Ej5fM = vertical2.mo625getSpacingD9Ej5fM();
                    } else {
                        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                        throw new KotlinNothingValueException();
                    }
                } else {
                    Arrangement.Horizontal horizontal2 = horizontal;
                    if (horizontal2 != null) {
                        mo625getSpacingD9Ej5fM = horizontal2.mo625getSpacingD9Ej5fM();
                    } else {
                        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalArrangement when isVertical == false");
                        throw new KotlinNothingValueException();
                    }
                }
                final int i12 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(mo625getSpacingD9Ej5fM);
                final int itemCount = invoke.getItemCount();
                if (z622) {
                    m6637getMaxWidthimpl = Constraints.m6636getMaxHeightimpl(j) - i8;
                } else {
                    m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j) - i9;
                }
                int i13 = m6637getMaxWidthimpl;
                if (z && i13 <= 0) {
                    boolean z9 = z622;
                    if (!z9) {
                        i3 += i13;
                    }
                    if (z9) {
                        i6 += i13;
                    }
                    lazyGridItemProvider = invoke;
                    m6806constructorimpl = IntOffset.m6806constructorimpl((i3 << 32) | (i6 & 4294967295L));
                } else {
                    lazyGridItemProvider = invoke;
                    m6806constructorimpl = IntOffset.m6806constructorimpl((i3 << 32) | (i6 & 4294967295L));
                }
                final LazyGridState lazyGridState2 = LazyGridState.this;
                final boolean z10 = z622;
                final boolean z11 = z;
                final int i14 = i5;
                final long j2 = m6806constructorimpl;
                final LazyGridItemProvider lazyGridItemProvider2 = lazyGridItemProvider;
                final LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 r27 = new LazyGridMeasuredItemProvider(lazyGridItemProvider2, lazyLayoutMeasureScope, i12, lazyGridState2, z10, z11, i14, i11, j2) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1
                    final /* synthetic */ int $afterContentPadding;
                    final /* synthetic */ int $beforeContentPadding;
                    final /* synthetic */ boolean $isVertical;
                    final /* synthetic */ boolean $reverseLayout;
                    final /* synthetic */ LazyGridState $state;
                    final /* synthetic */ LazyLayoutMeasureScope $this_null;
                    final /* synthetic */ long $visualItemOffset;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.$this_null = lazyLayoutMeasureScope;
                        this.$state = lazyGridState2;
                        this.$isVertical = z10;
                        this.$reverseLayout = z11;
                        this.$beforeContentPadding = i14;
                        this.$afterContentPadding = i11;
                        this.$visualItemOffset = j2;
                    }

                    @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider
                    /* renamed from: createItem-O3s9Psw  reason: not valid java name */
                    public LazyGridMeasuredItem mo880createItemO3s9Psw(int i15, Object obj, Object obj2, int i16, int i17, List<? extends Placeable> list, long j3, int i18, int i19) {
                        return new LazyGridMeasuredItem(i15, obj, this.$isVertical, i16, i17, this.$reverseLayout, this.$this_null.getLayoutDirection(), this.$beforeContentPadding, this.$afterContentPadding, list, this.$visualItemOffset, obj2, this.$state.getItemAnimator$foundation_release(), j3, i18, i19, null);
                    }
                };
                final boolean z12 = z622;
                final LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 r22 = new LazyGridMeasuredLineProvider(z12, mo867invoke0kLqBqw, itemCount, i12, r27, spanLayoutProvider) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1
                    final /* synthetic */ boolean $isVertical;
                    final /* synthetic */ LazyGridSlots $resolvedSlots;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(z12, mo867invoke0kLqBqw, itemCount, i12, r27, spanLayoutProvider);
                        this.$isVertical = z12;
                        this.$resolvedSlots = mo867invoke0kLqBqw;
                    }

                    @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider
                    public LazyGridMeasuredLine createLine(int i15, LazyGridMeasuredItem[] lazyGridMeasuredItemArr, List<GridItemSpan> list, int i16) {
                        return new LazyGridMeasuredLine(i15, lazyGridMeasuredItemArr, this.$resolvedSlots, list, this.$isVertical, i16);
                    }
                };
                Function1<Integer, ArrayList<Pair<? extends Integer, ? extends Constraints>>> function1 = new Function1<Integer, ArrayList<Pair<? extends Integer, ? extends Constraints>>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$prefetchInfoRetriever$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ ArrayList<Pair<? extends Integer, ? extends Constraints>> invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final ArrayList<Pair<Integer, Constraints>> invoke(int i15) {
                        LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = LazyGridSpanLayoutProvider.this.getLineConfiguration(i15);
                        int firstItemIndex = lineConfiguration.getFirstItemIndex();
                        ArrayList<Pair<Integer, Constraints>> arrayList = new ArrayList<>(lineConfiguration.getSpans().size());
                        List<GridItemSpan> spans = lineConfiguration.getSpans();
                        LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 = r22;
                        int size = spans.size();
                        int i16 = 0;
                        for (int i17 = 0; i17 < size; i17++) {
                            int m863getCurrentLineSpanimpl = GridItemSpan.m863getCurrentLineSpanimpl(spans.get(i17).m866unboximpl());
                            arrayList.add(TuplesKt.to(Integer.valueOf(firstItemIndex), Constraints.m6624boximpl(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1.m886childConstraintsJhjzzOo$foundation_release(i16, m863getCurrentLineSpanimpl))));
                            firstItemIndex++;
                            i16 += m863getCurrentLineSpanimpl;
                        }
                        return arrayList;
                    }
                };
                Snapshot.Companion companion = Snapshot.Companion;
                LazyGridState lazyGridState3 = LazyGridState.this;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyGridState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyGridItemProvider2, lazyGridState3.getFirstVisibleItemIndex());
                    if (updateScrollPositionIfTheFirstItemWasMoved$foundation_release >= itemCount && itemCount > 0) {
                        lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(itemCount - 1);
                        firstVisibleItemScrollOffset = 0;
                        int i1522 = lineIndexOfItem;
                        Unit unit22 = Unit.INSTANCE;
                        companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                        List<Integer> calculateLazyLayoutPinnedIndices22 = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyGridItemProvider2, LazyGridState.this.getPinnedItems$foundation_release(), LazyGridState.this.getBeyondBoundsInfo$foundation_release());
                        if (!lazyLayoutMeasureScope.isLookingAhead() || !z7) {
                            scrollToBeConsumed$foundation_release = LazyGridState.this.getScrollToBeConsumed$foundation_release();
                        } else {
                            scrollToBeConsumed$foundation_release = LazyGridState.this.getScrollDeltaBetweenPasses$foundation_release();
                        }
                        LazyGridMeasureResult m882measureLazyGridGyuLg2I22 = LazyGridMeasureKt.m882measureLazyGridGyuLg2I(itemCount, (LazyGridMeasuredLineProvider) r22, (LazyGridMeasuredItemProvider) r27, i13, i14, i11, i12, i1522, firstVisibleItemScrollOffset, scrollToBeConsumed$foundation_release, m6656offsetNN6EwU, z622, vertical, horizontal, z, lazyLayoutMeasureScope2, LazyGridState.this.getItemAnimator$foundation_release(), length, calculateLazyLayoutPinnedIndices22, z7, lazyLayoutMeasureScope.isLookingAhead(), LazyGridState.this.getApproachLayoutInfo$foundation_release(), coroutineScope, LazyGridState.this.m888getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, function1, stickyItemsPlacement, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measureResult$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function12) {
                                return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function12);
                            }

                            public final MeasureResult invoke(int i16, int i17, Function1<? super Placeable.PlacementScope, Unit> function12) {
                                return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6654constrainWidthK40F9xA(j, i16 + i9), ConstraintsKt.m6653constrainHeightK40F9xA(j, i17 + i8), MapsKt.emptyMap(), function12);
                            }
                        });
                        LazyGridState.applyMeasureResult$foundation_release$default(LazyGridState.this, m882measureLazyGridGyuLg2I22, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                        return m882measureLazyGridGyuLg2I22;
                    }
                    lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(updateScrollPositionIfTheFirstItemWasMoved$foundation_release);
                    firstVisibleItemScrollOffset = lazyGridState3.getFirstVisibleItemScrollOffset();
                    int i15222 = lineIndexOfItem;
                    Unit unit222 = Unit.INSTANCE;
                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                    List<Integer> calculateLazyLayoutPinnedIndices222 = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyGridItemProvider2, LazyGridState.this.getPinnedItems$foundation_release(), LazyGridState.this.getBeyondBoundsInfo$foundation_release());
                    if (!lazyLayoutMeasureScope.isLookingAhead()) {
                    }
                    scrollToBeConsumed$foundation_release = LazyGridState.this.getScrollToBeConsumed$foundation_release();
                    LazyGridMeasureResult m882measureLazyGridGyuLg2I222 = LazyGridMeasureKt.m882measureLazyGridGyuLg2I(itemCount, (LazyGridMeasuredLineProvider) r22, (LazyGridMeasuredItemProvider) r27, i13, i14, i11, i12, i15222, firstVisibleItemScrollOffset, scrollToBeConsumed$foundation_release, m6656offsetNN6EwU, z622, vertical, horizontal, z, lazyLayoutMeasureScope2, LazyGridState.this.getItemAnimator$foundation_release(), length, calculateLazyLayoutPinnedIndices222, z7, lazyLayoutMeasureScope.isLookingAhead(), LazyGridState.this.getApproachLayoutInfo$foundation_release(), coroutineScope, LazyGridState.this.m888getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, function1, stickyItemsPlacement, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measureResult$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function12) {
                            return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function12);
                        }

                        public final MeasureResult invoke(int i16, int i17, Function1<? super Placeable.PlacementScope, Unit> function12) {
                            return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6654constrainWidthK40F9xA(j, i16 + i9), ConstraintsKt.m6653constrainHeightK40F9xA(j, i17 + i8), MapsKt.emptyMap(), function12);
                        }
                    });
                    LazyGridState.applyMeasureResult$foundation_release$default(LazyGridState.this, m882measureLazyGridGyuLg2I222, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                    return m882measureLazyGridGyuLg2I222;
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
        };
        composer.updateRememberedValue(rememberedValue);
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function222 = (Function2) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return function222;
    }
}
