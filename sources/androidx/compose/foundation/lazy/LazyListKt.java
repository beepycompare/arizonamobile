package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: LazyList.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a¢\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00010\u001b¢\u0006\u0002\b\u001dH\u0001¢\u0006\u0002\u0010\u001e\u001a\u009c\u0001\u0010\u001f\u001a\u0019\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0 ¢\u0006\u0002\b\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0003¢\u0006\u0002\u0010-¨\u0006."}, d2 = {"LazyList", "", "modifier", "Landroidx/compose/ui/Modifier;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "beyondBoundsItemCount", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;ILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyListMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "stickyItemsPlacement", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyListKt {
    /* JADX WARN: Removed duplicated region for block: B:109:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:201:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyList(final Modifier modifier, LazyListState lazyListState, final PaddingValues paddingValues, final boolean z, final boolean z2, final FlingBehavior flingBehavior, final boolean z3, final OverscrollEffect overscrollEffect, int i, Alignment.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, Arrangement.Horizontal horizontal2, final Function1<? super LazyListScope, Unit> function1, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Object obj;
        int i6;
        final int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Composer composer2;
        LazyListState lazyListState2;
        final Alignment.Horizontal horizontal3;
        final Arrangement.Vertical vertical3;
        final Alignment.Vertical vertical4;
        final Arrangement.Horizontal horizontal4;
        ScopeUpdateScope endRestartGroup;
        Modifier.Companion companion;
        Modifier scrollingContainer;
        Composer startRestartGroup = composer.startRestartGroup(924924659);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyList)P(7,10,2,9,6,3,11,8!1,4,13,12,5)85@4100L50,87@4176L48,88@4250L24,89@4322L7,90@4391L7,93@4432L483,132@5717L302,127@5548L1174:LazyList.kt#428nma");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            i5 |= startRestartGroup.changed(lazyListState) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = paddingValues;
            i5 |= startRestartGroup.changed(obj) ? 256 : 128;
            if ((i4 & 8) == 0) {
                i5 |= 3072;
            } else if ((i2 & 3072) == 0) {
                i5 |= startRestartGroup.changed(z) ? 2048 : 1024;
            }
            if ((i4 & 16) == 0) {
                i5 |= 24576;
            } else if ((i2 & 24576) == 0) {
                i5 |= startRestartGroup.changed(z2) ? 16384 : 8192;
            }
            if ((i4 & 32) == 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i5 |= startRestartGroup.changed(flingBehavior) ? 131072 : 65536;
                if ((i4 & 64) != 0) {
                    i5 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    i5 |= startRestartGroup.changed(z3) ? 1048576 : 524288;
                }
                if ((i4 & 128) != 0) {
                    i5 |= 12582912;
                } else if ((i2 & 12582912) == 0) {
                    i5 |= startRestartGroup.changed(overscrollEffect) ? 8388608 : 4194304;
                    i6 = i4 & 256;
                    if (i6 == 0) {
                        i5 |= 100663296;
                        i7 = i;
                    } else {
                        i7 = i;
                        if ((i2 & 100663296) == 0) {
                            i5 |= startRestartGroup.changed(i7) ? 67108864 : 33554432;
                        }
                    }
                    i8 = i4 & 512;
                    if (i8 == 0) {
                        i5 |= 805306368;
                    } else if ((i2 & 805306368) == 0) {
                        i9 = i8;
                        i5 |= startRestartGroup.changed(horizontal) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        i10 = i4 & 1024;
                        if (i10 != 0) {
                            i12 = i3 | 6;
                            i11 = i10;
                        } else if ((i3 & 6) == 0) {
                            i11 = i10;
                            i12 = i3 | (startRestartGroup.changed(vertical) ? 4 : 2);
                        } else {
                            i11 = i10;
                            i12 = i3;
                        }
                        i13 = i4 & 2048;
                        if (i13 != 0) {
                            i12 |= 48;
                            i14 = i13;
                        } else if ((i3 & 48) == 0) {
                            i14 = i13;
                            i12 |= startRestartGroup.changed(vertical2) ? 32 : 16;
                        } else {
                            i14 = i13;
                        }
                        int i17 = i12;
                        i15 = i4 & 4096;
                        if (i15 != 0) {
                            i16 = i17 | RendererCapabilities.DECODER_SUPPORT_MASK;
                        } else {
                            int i18 = i17;
                            if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                i18 |= startRestartGroup.changed(horizontal2) ? 256 : 128;
                            }
                            i16 = i18;
                        }
                        if ((i4 & 8192) != 0) {
                            i16 |= 3072;
                        } else if ((i3 & 3072) == 0) {
                            i16 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
                        }
                        if (startRestartGroup.shouldExecute((306783379 & i5) == 306783378 || (i16 & 1171) != 1170, i5 & 1)) {
                            int i19 = i6 != 0 ? 0 : i7;
                            Alignment.Horizontal horizontal5 = i9 != 0 ? null : horizontal;
                            Arrangement.Vertical vertical5 = i11 != 0 ? null : vertical;
                            Alignment.Vertical vertical6 = i14 != 0 ? null : vertical2;
                            Arrangement.Horizontal horizontal6 = i15 != 0 ? null : horizontal2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(924924659, i5, i16, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:84)");
                            }
                            int i20 = (i5 >> 3) & 14;
                            Function0<LazyListItemProvider> rememberLazyListItemProviderLambda = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, function1, startRestartGroup, i20 | ((i16 >> 6) & 112));
                            int i21 = i5 >> 9;
                            int i22 = i16;
                            LazyLayoutSemanticState rememberLazyListSemanticState = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, z2, startRestartGroup, i20 | (i21 & 112));
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)558@25470L68:Effects.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -954203484, "CC(remember):Effects.kt#9igjgp");
                            Object rememberedValue = startRestartGroup.rememberedValue();
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
                            int i23 = (65520 & i5) | (458752 & i21) | (3670016 & i21);
                            int i24 = i22 << 18;
                            StickyItemsPlacement stickToTopPlacement = !((Boolean) consume2).booleanValue() ? StickyItemsPlacement.Companion.getStickToTopPlacement() : null;
                            int i25 = i5;
                            Arrangement.Horizontal horizontal7 = horizontal6;
                            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy = rememberLazyListMeasurePolicy(rememberLazyListItemProviderLambda, lazyListState, obj, z, z2, i19, horizontal5, vertical6, horizontal7, vertical5, coroutineScope, graphicsContext, stickToTopPlacement, startRestartGroup, i23 | (29360128 & i24) | (i24 & 234881024) | ((i22 << 27) & 1879048192), 0);
                            Alignment.Horizontal horizontal8 = horizontal5;
                            Alignment.Vertical vertical7 = vertical6;
                            Arrangement.Vertical vertical8 = vertical5;
                            lazyListState2 = lazyListState;
                            int i26 = i19;
                            Orientation orientation = z2 ? Orientation.Vertical : Orientation.Horizontal;
                            if (z3) {
                                startRestartGroup.startReplaceGroup(-1513147781);
                                ComposerKt.sourceInformation(startRestartGroup, "115@5166L165");
                                companion = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.Companion, LazyListBeyondBoundsModifierKt.rememberLazyListBeyondBoundsState(lazyListState2, i26, startRestartGroup, i20 | ((i25 >> 21) & 112)), lazyListState2.getBeyondBoundsInfo$foundation_release(), z, orientation);
                                startRestartGroup.endReplaceGroup();
                            } else {
                                startRestartGroup.startReplaceGroup(-1512720880);
                                startRestartGroup.endReplaceGroup();
                                companion = Modifier.Companion;
                            }
                            scrollingContainer = ScrollingContainerKt.scrollingContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState2.getRemeasurementModifier$foundation_release()).then(lazyListState2.getAwaitLayoutModifier$foundation_release()), rememberLazyListItemProviderLambda, rememberLazyListSemanticState, orientation, z3, z, startRestartGroup, ((i25 >> 6) & 57344) | ((i25 << 6) & 458752)).then(companion).then(lazyListState2.getItemAnimator$foundation_release().getModifier()), lazyListState2, orientation, z3, z, flingBehavior, lazyListState2.getInternalInteractionSource$foundation_release(), false, overscrollEffect, (i & 256) != 0 ? null : null);
                            composer2 = startRestartGroup;
                            LazyLayoutKt.LazyLayout(rememberLazyListItemProviderLambda, scrollingContainer, lazyListState2.getPrefetchState$foundation_release(), rememberLazyListMeasurePolicy, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i7 = i26;
                            horizontal3 = horizontal8;
                            vertical4 = vertical7;
                            horizontal4 = horizontal7;
                            vertical3 = vertical8;
                        } else {
                            composer2 = startRestartGroup;
                            lazyListState2 = lazyListState;
                            composer2.skipToGroupEnd();
                            horizontal3 = horizontal;
                            vertical3 = vertical;
                            vertical4 = vertical2;
                            horizontal4 = horizontal2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            final LazyListState lazyListState3 = lazyListState2;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt$LazyList$1
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

                                public final void invoke(Composer composer3, int i27) {
                                    LazyListKt.LazyList(Modifier.this, lazyListState3, paddingValues, z, z2, flingBehavior, z3, overscrollEffect, i7, horizontal3, vertical3, vertical4, horizontal4, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i9 = i8;
                    i10 = i4 & 1024;
                    if (i10 != 0) {
                    }
                    i13 = i4 & 2048;
                    if (i13 != 0) {
                    }
                    int i172 = i12;
                    i15 = i4 & 4096;
                    if (i15 != 0) {
                    }
                    if ((i4 & 8192) != 0) {
                    }
                    if (startRestartGroup.shouldExecute((306783379 & i5) == 306783378 || (i16 & 1171) != 1170, i5 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i6 = i4 & 256;
                if (i6 == 0) {
                }
                i8 = i4 & 512;
                if (i8 == 0) {
                }
                i9 = i8;
                i10 = i4 & 1024;
                if (i10 != 0) {
                }
                i13 = i4 & 2048;
                if (i13 != 0) {
                }
                int i1722 = i12;
                i15 = i4 & 4096;
                if (i15 != 0) {
                }
                if ((i4 & 8192) != 0) {
                }
                if (startRestartGroup.shouldExecute((306783379 & i5) == 306783378 || (i16 & 1171) != 1170, i5 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            if ((i4 & 64) != 0) {
            }
            if ((i4 & 128) != 0) {
            }
            i6 = i4 & 256;
            if (i6 == 0) {
            }
            i8 = i4 & 512;
            if (i8 == 0) {
            }
            i9 = i8;
            i10 = i4 & 1024;
            if (i10 != 0) {
            }
            i13 = i4 & 2048;
            if (i13 != 0) {
            }
            int i17222 = i12;
            i15 = i4 & 4096;
            if (i15 != 0) {
            }
            if ((i4 & 8192) != 0) {
            }
            if (startRestartGroup.shouldExecute((306783379 & i5) == 306783378 || (i16 & 1171) != 1170, i5 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = paddingValues;
        if ((i4 & 8) == 0) {
        }
        if ((i4 & 16) == 0) {
        }
        if ((i4 & 32) == 0) {
        }
        if ((i4 & 64) != 0) {
        }
        if ((i4 & 128) != 0) {
        }
        i6 = i4 & 256;
        if (i6 == 0) {
        }
        i8 = i4 & 512;
        if (i8 == 0) {
        }
        i9 = i8;
        i10 = i4 & 1024;
        if (i10 != 0) {
        }
        i13 = i4 & 2048;
        if (i13 != 0) {
        }
        int i172222 = i12;
        i15 = i4 & 4096;
        if (i15 != 0) {
        }
        if ((i4 & 8192) != 0) {
        }
        if (startRestartGroup.shouldExecute((306783379 & i5) == 306783378 || (i16 & 1171) != 1170, i5 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0079, code lost:
        if (r34.changed(r4) == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0096, code lost:
        if (r34.changed(r9) == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b2, code lost:
        if (r34.changed(r12) == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ce, code lost:
        if (r34.changed(r13) == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ea, code lost:
        if (r34.changed(r14) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0109, code lost:
        if (r34.changed(r5) == false) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy(final Function0<? extends LazyListItemProvider> function0, final LazyListState lazyListState, final PaddingValues paddingValues, final boolean z, boolean z2, final int i, Alignment.Horizontal horizontal, Alignment.Vertical vertical, Arrangement.Horizontal horizontal2, Arrangement.Vertical vertical2, final CoroutineScope coroutineScope, final GraphicsContext graphicsContext, StickyItemsPlacement stickyItemsPlacement, Composer composer, int i2, int i3) {
        boolean z3;
        boolean z4;
        Object obj;
        boolean z5;
        Object obj2;
        boolean z6;
        Object obj3;
        boolean z7;
        Object obj4;
        boolean z8;
        Object obj5;
        boolean z9;
        boolean z10;
        Object rememberedValue;
        ComposerKt.sourceInformationMarkerStart(composer, -739270660, "C(rememberLazyListMeasurePolicy)P(7,9,1,8,6!1,4,11,5,12)187@7988L9562:LazyList.kt#428nma");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-739270660, i2, i3, "androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:187)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 581144747, "CC(remember):LazyList.kt#9igjgp");
        boolean z11 = ((((i2 & 112) ^ 48) > 32 && composer.changed(lazyListState)) || (i2 & 48) == 32) | ((((i2 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(paddingValues)) || (i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | ((((i2 & 7168) ^ 3072) > 2048 && composer.changed(z)) || (i2 & 3072) == 2048);
        if (((57344 & i2) ^ 24576) > 16384) {
            z3 = z2;
        } else {
            z3 = z2;
        }
        if ((i2 & 24576) != 16384) {
            z4 = false;
            boolean z12 = z11 | z4;
            if (((3670016 & i2) ^ 1572864) <= 1048576) {
                obj = horizontal;
            } else {
                obj = horizontal;
            }
            if ((1572864 & i2) != 1048576) {
                z5 = false;
                boolean z13 = z12 | z5;
                if (((29360128 & i2) ^ 12582912) > 8388608) {
                    obj2 = vertical;
                } else {
                    obj2 = vertical;
                }
                if ((12582912 & i2) != 8388608) {
                    z6 = false;
                    boolean z14 = z13 | z6;
                    if (((234881024 & i2) ^ 100663296) <= 67108864) {
                        obj3 = horizontal2;
                    } else {
                        obj3 = horizontal2;
                    }
                    if ((100663296 & i2) != 67108864) {
                        z7 = false;
                        boolean z15 = z14 | z7;
                        if (((1879048192 & i2) ^ 805306368) > 536870912) {
                            obj4 = vertical2;
                        } else {
                            obj4 = vertical2;
                        }
                        if ((i2 & 805306368) != 536870912) {
                            z8 = false;
                            boolean changed = z8 | z15 | composer.changed(graphicsContext);
                            if (((i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256) {
                                obj5 = stickyItemsPlacement;
                            } else {
                                obj5 = stickyItemsPlacement;
                            }
                            if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
                                z9 = false;
                                z10 = changed | z9;
                                rememberedValue = composer.rememberedValue();
                                if (!z10 || rememberedValue == Composer.Companion.getEmpty()) {
                                    final Arrangement.Vertical vertical3 = obj4;
                                    final Arrangement.Horizontal horizontal3 = obj3;
                                    final StickyItemsPlacement stickyItemsPlacement2 = obj5;
                                    final Alignment.Horizontal horizontal4 = obj;
                                    final Alignment.Vertical vertical4 = obj2;
                                    final boolean z16 = z3;
                                    rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ LazyListMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                                            return m842invoke0kLqBqw(lazyLayoutMeasureScope, constraints.m6643unboximpl());
                                        }

                                        /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                                        public final LazyListMeasureResult m842invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                                            int i4;
                                            int i5;
                                            final int i6;
                                            float mo625getSpacingD9Ej5fM;
                                            int m6637getMaxWidthimpl;
                                            LazyListItemProvider lazyListItemProvider;
                                            long m6806constructorimpl;
                                            float scrollToBeConsumed$foundation_release;
                                            ObservableScopeInvalidator.m918attachToScopeimpl(LazyListState.this.m857getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                                            boolean z17 = LazyListState.this.getHasLookaheadOccurred$foundation_release() || lazyLayoutMeasureScope.isLookingAhead();
                                            CheckScrollableContainerConstraintsKt.m275checkScrollableContainerConstraintsK40F9xA(j, z16 ? Orientation.Vertical : Orientation.Horizontal);
                                            if (z16) {
                                                i4 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo688calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                                            } else {
                                                i4 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                            }
                                            if (z16) {
                                                i5 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo689calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                                            } else {
                                                i5 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                            }
                                            int i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo690calculateTopPaddingD9Ej5fM());
                                            int i8 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo687calculateBottomPaddingD9Ej5fM());
                                            final int i9 = i7 + i8;
                                            final int i10 = i4 + i5;
                                            boolean z18 = z16;
                                            int i11 = z18 ? i9 : i10;
                                            if (z18 && !z) {
                                                i6 = i7;
                                            } else if (z18 && z) {
                                                i6 = i8;
                                            } else {
                                                i6 = (z18 || z) ? i5 : i4;
                                            }
                                            final int i12 = i11 - i6;
                                            final long m6656offsetNN6EwU = ConstraintsKt.m6656offsetNN6EwU(j, -i10, -i9);
                                            LazyListItemProvider invoke = function0.invoke();
                                            invoke.getItemScope().setMaxSize(Constraints.m6637getMaxWidthimpl(m6656offsetNN6EwU), Constraints.m6636getMaxHeightimpl(m6656offsetNN6EwU));
                                            if (z16) {
                                                Arrangement.Vertical vertical5 = vertical3;
                                                if (vertical5 != null) {
                                                    mo625getSpacingD9Ej5fM = vertical5.mo625getSpacingD9Ej5fM();
                                                } else {
                                                    InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                                                    throw new KotlinNothingValueException();
                                                }
                                            } else {
                                                Arrangement.Horizontal horizontal5 = horizontal3;
                                                if (horizontal5 != null) {
                                                    mo625getSpacingD9Ej5fM = horizontal5.mo625getSpacingD9Ej5fM();
                                                } else {
                                                    InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalAlignment when isVertical == false");
                                                    throw new KotlinNothingValueException();
                                                }
                                            }
                                            final int i13 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(mo625getSpacingD9Ej5fM);
                                            final int itemCount = invoke.getItemCount();
                                            if (z16) {
                                                m6637getMaxWidthimpl = Constraints.m6636getMaxHeightimpl(j) - i9;
                                            } else {
                                                m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j) - i10;
                                            }
                                            int i14 = m6637getMaxWidthimpl;
                                            if (z && i14 <= 0) {
                                                boolean z19 = z16;
                                                if (!z19) {
                                                    i4 += i14;
                                                }
                                                if (z19) {
                                                    i7 += i14;
                                                }
                                                lazyListItemProvider = invoke;
                                                m6806constructorimpl = IntOffset.m6806constructorimpl((i4 << 32) | (i7 & 4294967295L));
                                            } else {
                                                lazyListItemProvider = invoke;
                                                m6806constructorimpl = IntOffset.m6806constructorimpl((i4 << 32) | (i7 & 4294967295L));
                                            }
                                            final boolean z20 = z16;
                                            final Alignment.Horizontal horizontal6 = horizontal4;
                                            final long j2 = m6806constructorimpl;
                                            final LazyListItemProvider lazyListItemProvider2 = lazyListItemProvider;
                                            final Alignment.Vertical vertical6 = vertical4;
                                            final boolean z21 = z;
                                            final LazyListState lazyListState2 = LazyListState.this;
                                            LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(m6656offsetNN6EwU, z20, lazyListItemProvider2, lazyLayoutMeasureScope, itemCount, i13, horizontal6, vertical6, z21, i6, i12, j2, lazyListState2) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
                                                final /* synthetic */ int $afterContentPadding;
                                                final /* synthetic */ int $beforeContentPadding;
                                                final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
                                                final /* synthetic */ boolean $isVertical;
                                                final /* synthetic */ int $itemsCount;
                                                final /* synthetic */ boolean $reverseLayout;
                                                final /* synthetic */ int $spaceBetweenItems;
                                                final /* synthetic */ LazyListState $state;
                                                final /* synthetic */ LazyLayoutMeasureScope $this_null;
                                                final /* synthetic */ Alignment.Vertical $verticalAlignment;
                                                final /* synthetic */ long $visualItemOffset;

                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    this.$isVertical = z20;
                                                    this.$this_null = lazyLayoutMeasureScope;
                                                    this.$itemsCount = itemCount;
                                                    this.$spaceBetweenItems = i13;
                                                    this.$horizontalAlignment = horizontal6;
                                                    this.$verticalAlignment = vertical6;
                                                    this.$reverseLayout = z21;
                                                    this.$beforeContentPadding = i6;
                                                    this.$afterContentPadding = i12;
                                                    this.$visualItemOffset = j2;
                                                    this.$state = lazyListState2;
                                                }

                                                @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
                                                /* renamed from: createItem-X9ElhV4  reason: not valid java name */
                                                public LazyListMeasuredItem mo843createItemX9ElhV4(int i15, Object obj6, Object obj7, List<? extends Placeable> list, long j3) {
                                                    return new LazyListMeasuredItem(i15, list, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_null.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, i15 == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, obj6, obj7, this.$state.getItemAnimator$foundation_release(), j3, null);
                                                }
                                            };
                                            Snapshot.Companion companion = Snapshot.Companion;
                                            LazyListState lazyListState3 = LazyListState.this;
                                            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                                            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                            Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                                            try {
                                                int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyListState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyListItemProvider2, lazyListState3.getFirstVisibleItemIndex());
                                                int firstVisibleItemScrollOffset = lazyListState3.getFirstVisibleItemScrollOffset();
                                                Unit unit = Unit.INSTANCE;
                                                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                                List<Integer> calculateLazyLayoutPinnedIndices = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyListItemProvider2, LazyListState.this.getPinnedItems$foundation_release(), LazyListState.this.getBeyondBoundsInfo$foundation_release());
                                                if (lazyLayoutMeasureScope.isLookingAhead() || !z17) {
                                                    scrollToBeConsumed$foundation_release = LazyListState.this.getScrollToBeConsumed$foundation_release();
                                                } else {
                                                    scrollToBeConsumed$foundation_release = LazyListState.this.getScrollDeltaBetweenPasses$foundation_release();
                                                }
                                                LazyListMeasureResult m847measureLazyListLCrQqZ4 = LazyListMeasureKt.m847measureLazyListLCrQqZ4(itemCount, lazyListMeasuredItemProvider, i14, i6, i12, i13, updateScrollPositionIfTheFirstItemWasMoved$foundation_release, firstVisibleItemScrollOffset, scrollToBeConsumed$foundation_release, m6656offsetNN6EwU, z16, vertical3, horizontal3, z, lazyLayoutMeasureScope, LazyListState.this.getItemAnimator$foundation_release(), i, calculateLazyLayoutPinnedIndices, z17, lazyLayoutMeasureScope.isLookingAhead(), LazyListState.this.getApproachLayoutInfo$foundation_release(), coroutineScope, LazyListState.this.m858getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, stickyItemsPlacement2, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measureResult$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                                        return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                                    }

                                                    public final MeasureResult invoke(int i15, int i16, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                                        return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6654constrainWidthK40F9xA(j, i15 + i10), ConstraintsKt.m6653constrainHeightK40F9xA(j, i16 + i9), MapsKt.emptyMap(), function1);
                                                    }
                                                });
                                                LazyListState.applyMeasureResult$foundation_release$default(LazyListState.this, m847measureLazyListLCrQqZ4, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                                                return m847measureLazyListLCrQqZ4;
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
                            z9 = true;
                            z10 = changed | z9;
                            rememberedValue = composer.rememberedValue();
                            if (!z10) {
                            }
                            final Arrangement.Vertical vertical32 = obj4;
                            final Arrangement.Horizontal horizontal32 = obj3;
                            final StickyItemsPlacement stickyItemsPlacement22 = obj5;
                            final Alignment.Horizontal horizontal42 = obj;
                            final Alignment.Vertical vertical42 = obj2;
                            final boolean z162 = z3;
                            rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ LazyListMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                                    return m842invoke0kLqBqw(lazyLayoutMeasureScope, constraints.m6643unboximpl());
                                }

                                /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                                public final LazyListMeasureResult m842invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                                    int i4;
                                    int i5;
                                    final int i6;
                                    float mo625getSpacingD9Ej5fM;
                                    int m6637getMaxWidthimpl;
                                    LazyListItemProvider lazyListItemProvider;
                                    long m6806constructorimpl;
                                    float scrollToBeConsumed$foundation_release;
                                    ObservableScopeInvalidator.m918attachToScopeimpl(LazyListState.this.m857getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                                    boolean z17 = LazyListState.this.getHasLookaheadOccurred$foundation_release() || lazyLayoutMeasureScope.isLookingAhead();
                                    CheckScrollableContainerConstraintsKt.m275checkScrollableContainerConstraintsK40F9xA(j, z162 ? Orientation.Vertical : Orientation.Horizontal);
                                    if (z162) {
                                        i4 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo688calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                                    } else {
                                        i4 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                    }
                                    if (z162) {
                                        i5 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo689calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                                    } else {
                                        i5 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                    }
                                    int i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo690calculateTopPaddingD9Ej5fM());
                                    int i8 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo687calculateBottomPaddingD9Ej5fM());
                                    final int i9 = i7 + i8;
                                    final int i10 = i4 + i5;
                                    boolean z18 = z162;
                                    int i11 = z18 ? i9 : i10;
                                    if (z18 && !z) {
                                        i6 = i7;
                                    } else if (z18 && z) {
                                        i6 = i8;
                                    } else {
                                        i6 = (z18 || z) ? i5 : i4;
                                    }
                                    final int i12 = i11 - i6;
                                    final long m6656offsetNN6EwU = ConstraintsKt.m6656offsetNN6EwU(j, -i10, -i9);
                                    LazyListItemProvider invoke = function0.invoke();
                                    invoke.getItemScope().setMaxSize(Constraints.m6637getMaxWidthimpl(m6656offsetNN6EwU), Constraints.m6636getMaxHeightimpl(m6656offsetNN6EwU));
                                    if (z162) {
                                        Arrangement.Vertical vertical5 = vertical32;
                                        if (vertical5 != null) {
                                            mo625getSpacingD9Ej5fM = vertical5.mo625getSpacingD9Ej5fM();
                                        } else {
                                            InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                                            throw new KotlinNothingValueException();
                                        }
                                    } else {
                                        Arrangement.Horizontal horizontal5 = horizontal32;
                                        if (horizontal5 != null) {
                                            mo625getSpacingD9Ej5fM = horizontal5.mo625getSpacingD9Ej5fM();
                                        } else {
                                            InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalAlignment when isVertical == false");
                                            throw new KotlinNothingValueException();
                                        }
                                    }
                                    final int i13 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(mo625getSpacingD9Ej5fM);
                                    final int itemCount = invoke.getItemCount();
                                    if (z162) {
                                        m6637getMaxWidthimpl = Constraints.m6636getMaxHeightimpl(j) - i9;
                                    } else {
                                        m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j) - i10;
                                    }
                                    int i14 = m6637getMaxWidthimpl;
                                    if (z && i14 <= 0) {
                                        boolean z19 = z162;
                                        if (!z19) {
                                            i4 += i14;
                                        }
                                        if (z19) {
                                            i7 += i14;
                                        }
                                        lazyListItemProvider = invoke;
                                        m6806constructorimpl = IntOffset.m6806constructorimpl((i4 << 32) | (i7 & 4294967295L));
                                    } else {
                                        lazyListItemProvider = invoke;
                                        m6806constructorimpl = IntOffset.m6806constructorimpl((i4 << 32) | (i7 & 4294967295L));
                                    }
                                    final boolean z20 = z162;
                                    final Alignment.Horizontal horizontal6 = horizontal42;
                                    final long j2 = m6806constructorimpl;
                                    final LazyListItemProvider lazyListItemProvider2 = lazyListItemProvider;
                                    final Alignment.Vertical vertical6 = vertical42;
                                    final boolean z21 = z;
                                    final LazyListState lazyListState2 = LazyListState.this;
                                    LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(m6656offsetNN6EwU, z20, lazyListItemProvider2, lazyLayoutMeasureScope, itemCount, i13, horizontal6, vertical6, z21, i6, i12, j2, lazyListState2) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
                                        final /* synthetic */ int $afterContentPadding;
                                        final /* synthetic */ int $beforeContentPadding;
                                        final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
                                        final /* synthetic */ boolean $isVertical;
                                        final /* synthetic */ int $itemsCount;
                                        final /* synthetic */ boolean $reverseLayout;
                                        final /* synthetic */ int $spaceBetweenItems;
                                        final /* synthetic */ LazyListState $state;
                                        final /* synthetic */ LazyLayoutMeasureScope $this_null;
                                        final /* synthetic */ Alignment.Vertical $verticalAlignment;
                                        final /* synthetic */ long $visualItemOffset;

                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            this.$isVertical = z20;
                                            this.$this_null = lazyLayoutMeasureScope;
                                            this.$itemsCount = itemCount;
                                            this.$spaceBetweenItems = i13;
                                            this.$horizontalAlignment = horizontal6;
                                            this.$verticalAlignment = vertical6;
                                            this.$reverseLayout = z21;
                                            this.$beforeContentPadding = i6;
                                            this.$afterContentPadding = i12;
                                            this.$visualItemOffset = j2;
                                            this.$state = lazyListState2;
                                        }

                                        @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
                                        /* renamed from: createItem-X9ElhV4  reason: not valid java name */
                                        public LazyListMeasuredItem mo843createItemX9ElhV4(int i15, Object obj6, Object obj7, List<? extends Placeable> list, long j3) {
                                            return new LazyListMeasuredItem(i15, list, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_null.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, i15 == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, obj6, obj7, this.$state.getItemAnimator$foundation_release(), j3, null);
                                        }
                                    };
                                    Snapshot.Companion companion = Snapshot.Companion;
                                    LazyListState lazyListState3 = LazyListState.this;
                                    Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                                    Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                    Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                                    try {
                                        int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyListState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyListItemProvider2, lazyListState3.getFirstVisibleItemIndex());
                                        int firstVisibleItemScrollOffset = lazyListState3.getFirstVisibleItemScrollOffset();
                                        Unit unit = Unit.INSTANCE;
                                        companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                        List<Integer> calculateLazyLayoutPinnedIndices = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyListItemProvider2, LazyListState.this.getPinnedItems$foundation_release(), LazyListState.this.getBeyondBoundsInfo$foundation_release());
                                        if (lazyLayoutMeasureScope.isLookingAhead() || !z17) {
                                            scrollToBeConsumed$foundation_release = LazyListState.this.getScrollToBeConsumed$foundation_release();
                                        } else {
                                            scrollToBeConsumed$foundation_release = LazyListState.this.getScrollDeltaBetweenPasses$foundation_release();
                                        }
                                        LazyListMeasureResult m847measureLazyListLCrQqZ4 = LazyListMeasureKt.m847measureLazyListLCrQqZ4(itemCount, lazyListMeasuredItemProvider, i14, i6, i12, i13, updateScrollPositionIfTheFirstItemWasMoved$foundation_release, firstVisibleItemScrollOffset, scrollToBeConsumed$foundation_release, m6656offsetNN6EwU, z162, vertical32, horizontal32, z, lazyLayoutMeasureScope, LazyListState.this.getItemAnimator$foundation_release(), i, calculateLazyLayoutPinnedIndices, z17, lazyLayoutMeasureScope.isLookingAhead(), LazyListState.this.getApproachLayoutInfo$foundation_release(), coroutineScope, LazyListState.this.m858getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, stickyItemsPlacement22, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measureResult$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                                return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                            }

                                            public final MeasureResult invoke(int i15, int i16, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                                return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6654constrainWidthK40F9xA(j, i15 + i10), ConstraintsKt.m6653constrainHeightK40F9xA(j, i16 + i9), MapsKt.emptyMap(), function1);
                                            }
                                        });
                                        LazyListState.applyMeasureResult$foundation_release$default(LazyListState.this, m847measureLazyListLCrQqZ4, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                                        return m847measureLazyListLCrQqZ4;
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
                        z8 = true;
                        boolean changed2 = z8 | z15 | composer.changed(graphicsContext);
                        if (((i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256) {
                        }
                        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
                        }
                        z9 = true;
                        z10 = changed2 | z9;
                        rememberedValue = composer.rememberedValue();
                        if (!z10) {
                        }
                        final Arrangement.Vertical vertical322 = obj4;
                        final Arrangement.Horizontal horizontal322 = obj3;
                        final StickyItemsPlacement stickyItemsPlacement222 = obj5;
                        final Alignment.Horizontal horizontal422 = obj;
                        final Alignment.Vertical vertical422 = obj2;
                        final boolean z1622 = z3;
                        rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ LazyListMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                                return m842invoke0kLqBqw(lazyLayoutMeasureScope, constraints.m6643unboximpl());
                            }

                            /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                            public final LazyListMeasureResult m842invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                                int i4;
                                int i5;
                                final int i6;
                                float mo625getSpacingD9Ej5fM;
                                int m6637getMaxWidthimpl;
                                LazyListItemProvider lazyListItemProvider;
                                long m6806constructorimpl;
                                float scrollToBeConsumed$foundation_release;
                                ObservableScopeInvalidator.m918attachToScopeimpl(LazyListState.this.m857getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                                boolean z17 = LazyListState.this.getHasLookaheadOccurred$foundation_release() || lazyLayoutMeasureScope.isLookingAhead();
                                CheckScrollableContainerConstraintsKt.m275checkScrollableContainerConstraintsK40F9xA(j, z1622 ? Orientation.Vertical : Orientation.Horizontal);
                                if (z1622) {
                                    i4 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo688calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                                } else {
                                    i4 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                }
                                if (z1622) {
                                    i5 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo689calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                                } else {
                                    i5 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                }
                                int i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo690calculateTopPaddingD9Ej5fM());
                                int i8 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo687calculateBottomPaddingD9Ej5fM());
                                final int i9 = i7 + i8;
                                final int i10 = i4 + i5;
                                boolean z18 = z1622;
                                int i11 = z18 ? i9 : i10;
                                if (z18 && !z) {
                                    i6 = i7;
                                } else if (z18 && z) {
                                    i6 = i8;
                                } else {
                                    i6 = (z18 || z) ? i5 : i4;
                                }
                                final int i12 = i11 - i6;
                                final long m6656offsetNN6EwU = ConstraintsKt.m6656offsetNN6EwU(j, -i10, -i9);
                                LazyListItemProvider invoke = function0.invoke();
                                invoke.getItemScope().setMaxSize(Constraints.m6637getMaxWidthimpl(m6656offsetNN6EwU), Constraints.m6636getMaxHeightimpl(m6656offsetNN6EwU));
                                if (z1622) {
                                    Arrangement.Vertical vertical5 = vertical322;
                                    if (vertical5 != null) {
                                        mo625getSpacingD9Ej5fM = vertical5.mo625getSpacingD9Ej5fM();
                                    } else {
                                        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                                        throw new KotlinNothingValueException();
                                    }
                                } else {
                                    Arrangement.Horizontal horizontal5 = horizontal322;
                                    if (horizontal5 != null) {
                                        mo625getSpacingD9Ej5fM = horizontal5.mo625getSpacingD9Ej5fM();
                                    } else {
                                        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalAlignment when isVertical == false");
                                        throw new KotlinNothingValueException();
                                    }
                                }
                                final int i13 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(mo625getSpacingD9Ej5fM);
                                final int itemCount = invoke.getItemCount();
                                if (z1622) {
                                    m6637getMaxWidthimpl = Constraints.m6636getMaxHeightimpl(j) - i9;
                                } else {
                                    m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j) - i10;
                                }
                                int i14 = m6637getMaxWidthimpl;
                                if (z && i14 <= 0) {
                                    boolean z19 = z1622;
                                    if (!z19) {
                                        i4 += i14;
                                    }
                                    if (z19) {
                                        i7 += i14;
                                    }
                                    lazyListItemProvider = invoke;
                                    m6806constructorimpl = IntOffset.m6806constructorimpl((i4 << 32) | (i7 & 4294967295L));
                                } else {
                                    lazyListItemProvider = invoke;
                                    m6806constructorimpl = IntOffset.m6806constructorimpl((i4 << 32) | (i7 & 4294967295L));
                                }
                                final boolean z20 = z1622;
                                final Alignment.Horizontal horizontal6 = horizontal422;
                                final long j2 = m6806constructorimpl;
                                final LazyListItemProvider lazyListItemProvider2 = lazyListItemProvider;
                                final Alignment.Vertical vertical6 = vertical422;
                                final boolean z21 = z;
                                final LazyListState lazyListState2 = LazyListState.this;
                                LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(m6656offsetNN6EwU, z20, lazyListItemProvider2, lazyLayoutMeasureScope, itemCount, i13, horizontal6, vertical6, z21, i6, i12, j2, lazyListState2) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
                                    final /* synthetic */ int $afterContentPadding;
                                    final /* synthetic */ int $beforeContentPadding;
                                    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
                                    final /* synthetic */ boolean $isVertical;
                                    final /* synthetic */ int $itemsCount;
                                    final /* synthetic */ boolean $reverseLayout;
                                    final /* synthetic */ int $spaceBetweenItems;
                                    final /* synthetic */ LazyListState $state;
                                    final /* synthetic */ LazyLayoutMeasureScope $this_null;
                                    final /* synthetic */ Alignment.Vertical $verticalAlignment;
                                    final /* synthetic */ long $visualItemOffset;

                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        this.$isVertical = z20;
                                        this.$this_null = lazyLayoutMeasureScope;
                                        this.$itemsCount = itemCount;
                                        this.$spaceBetweenItems = i13;
                                        this.$horizontalAlignment = horizontal6;
                                        this.$verticalAlignment = vertical6;
                                        this.$reverseLayout = z21;
                                        this.$beforeContentPadding = i6;
                                        this.$afterContentPadding = i12;
                                        this.$visualItemOffset = j2;
                                        this.$state = lazyListState2;
                                    }

                                    @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
                                    /* renamed from: createItem-X9ElhV4  reason: not valid java name */
                                    public LazyListMeasuredItem mo843createItemX9ElhV4(int i15, Object obj6, Object obj7, List<? extends Placeable> list, long j3) {
                                        return new LazyListMeasuredItem(i15, list, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_null.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, i15 == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, obj6, obj7, this.$state.getItemAnimator$foundation_release(), j3, null);
                                    }
                                };
                                Snapshot.Companion companion = Snapshot.Companion;
                                LazyListState lazyListState3 = LazyListState.this;
                                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                                try {
                                    int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyListState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyListItemProvider2, lazyListState3.getFirstVisibleItemIndex());
                                    int firstVisibleItemScrollOffset = lazyListState3.getFirstVisibleItemScrollOffset();
                                    Unit unit = Unit.INSTANCE;
                                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                    List<Integer> calculateLazyLayoutPinnedIndices = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyListItemProvider2, LazyListState.this.getPinnedItems$foundation_release(), LazyListState.this.getBeyondBoundsInfo$foundation_release());
                                    if (lazyLayoutMeasureScope.isLookingAhead() || !z17) {
                                        scrollToBeConsumed$foundation_release = LazyListState.this.getScrollToBeConsumed$foundation_release();
                                    } else {
                                        scrollToBeConsumed$foundation_release = LazyListState.this.getScrollDeltaBetweenPasses$foundation_release();
                                    }
                                    LazyListMeasureResult m847measureLazyListLCrQqZ4 = LazyListMeasureKt.m847measureLazyListLCrQqZ4(itemCount, lazyListMeasuredItemProvider, i14, i6, i12, i13, updateScrollPositionIfTheFirstItemWasMoved$foundation_release, firstVisibleItemScrollOffset, scrollToBeConsumed$foundation_release, m6656offsetNN6EwU, z1622, vertical322, horizontal322, z, lazyLayoutMeasureScope, LazyListState.this.getItemAnimator$foundation_release(), i, calculateLazyLayoutPinnedIndices, z17, lazyLayoutMeasureScope.isLookingAhead(), LazyListState.this.getApproachLayoutInfo$foundation_release(), coroutineScope, LazyListState.this.m858getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, stickyItemsPlacement222, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measureResult$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                            return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                        }

                                        public final MeasureResult invoke(int i15, int i16, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                            return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6654constrainWidthK40F9xA(j, i15 + i10), ConstraintsKt.m6653constrainHeightK40F9xA(j, i16 + i9), MapsKt.emptyMap(), function1);
                                        }
                                    });
                                    LazyListState.applyMeasureResult$foundation_release$default(LazyListState.this, m847measureLazyListLCrQqZ4, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                                    return m847measureLazyListLCrQqZ4;
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
                    z7 = true;
                    boolean z152 = z14 | z7;
                    if (((1879048192 & i2) ^ 805306368) > 536870912) {
                    }
                    if ((i2 & 805306368) != 536870912) {
                    }
                    z8 = true;
                    boolean changed22 = z8 | z152 | composer.changed(graphicsContext);
                    if (((i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256) {
                    }
                    if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
                    }
                    z9 = true;
                    z10 = changed22 | z9;
                    rememberedValue = composer.rememberedValue();
                    if (!z10) {
                    }
                    final Arrangement.Vertical vertical3222 = obj4;
                    final Arrangement.Horizontal horizontal3222 = obj3;
                    final StickyItemsPlacement stickyItemsPlacement2222 = obj5;
                    final Alignment.Horizontal horizontal4222 = obj;
                    final Alignment.Vertical vertical4222 = obj2;
                    final boolean z16222 = z3;
                    rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ LazyListMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                            return m842invoke0kLqBqw(lazyLayoutMeasureScope, constraints.m6643unboximpl());
                        }

                        /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                        public final LazyListMeasureResult m842invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                            int i4;
                            int i5;
                            final int i6;
                            float mo625getSpacingD9Ej5fM;
                            int m6637getMaxWidthimpl;
                            LazyListItemProvider lazyListItemProvider;
                            long m6806constructorimpl;
                            float scrollToBeConsumed$foundation_release;
                            ObservableScopeInvalidator.m918attachToScopeimpl(LazyListState.this.m857getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                            boolean z17 = LazyListState.this.getHasLookaheadOccurred$foundation_release() || lazyLayoutMeasureScope.isLookingAhead();
                            CheckScrollableContainerConstraintsKt.m275checkScrollableContainerConstraintsK40F9xA(j, z16222 ? Orientation.Vertical : Orientation.Horizontal);
                            if (z16222) {
                                i4 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo688calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                            } else {
                                i4 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                            }
                            if (z16222) {
                                i5 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo689calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                            } else {
                                i5 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                            }
                            int i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo690calculateTopPaddingD9Ej5fM());
                            int i8 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo687calculateBottomPaddingD9Ej5fM());
                            final int i9 = i7 + i8;
                            final int i10 = i4 + i5;
                            boolean z18 = z16222;
                            int i11 = z18 ? i9 : i10;
                            if (z18 && !z) {
                                i6 = i7;
                            } else if (z18 && z) {
                                i6 = i8;
                            } else {
                                i6 = (z18 || z) ? i5 : i4;
                            }
                            final int i12 = i11 - i6;
                            final long m6656offsetNN6EwU = ConstraintsKt.m6656offsetNN6EwU(j, -i10, -i9);
                            LazyListItemProvider invoke = function0.invoke();
                            invoke.getItemScope().setMaxSize(Constraints.m6637getMaxWidthimpl(m6656offsetNN6EwU), Constraints.m6636getMaxHeightimpl(m6656offsetNN6EwU));
                            if (z16222) {
                                Arrangement.Vertical vertical5 = vertical3222;
                                if (vertical5 != null) {
                                    mo625getSpacingD9Ej5fM = vertical5.mo625getSpacingD9Ej5fM();
                                } else {
                                    InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                                    throw new KotlinNothingValueException();
                                }
                            } else {
                                Arrangement.Horizontal horizontal5 = horizontal3222;
                                if (horizontal5 != null) {
                                    mo625getSpacingD9Ej5fM = horizontal5.mo625getSpacingD9Ej5fM();
                                } else {
                                    InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalAlignment when isVertical == false");
                                    throw new KotlinNothingValueException();
                                }
                            }
                            final int i13 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(mo625getSpacingD9Ej5fM);
                            final int itemCount = invoke.getItemCount();
                            if (z16222) {
                                m6637getMaxWidthimpl = Constraints.m6636getMaxHeightimpl(j) - i9;
                            } else {
                                m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j) - i10;
                            }
                            int i14 = m6637getMaxWidthimpl;
                            if (z && i14 <= 0) {
                                boolean z19 = z16222;
                                if (!z19) {
                                    i4 += i14;
                                }
                                if (z19) {
                                    i7 += i14;
                                }
                                lazyListItemProvider = invoke;
                                m6806constructorimpl = IntOffset.m6806constructorimpl((i4 << 32) | (i7 & 4294967295L));
                            } else {
                                lazyListItemProvider = invoke;
                                m6806constructorimpl = IntOffset.m6806constructorimpl((i4 << 32) | (i7 & 4294967295L));
                            }
                            final boolean z20 = z16222;
                            final Alignment.Horizontal horizontal6 = horizontal4222;
                            final long j2 = m6806constructorimpl;
                            final LazyListItemProvider lazyListItemProvider2 = lazyListItemProvider;
                            final Alignment.Vertical vertical6 = vertical4222;
                            final boolean z21 = z;
                            final LazyListState lazyListState2 = LazyListState.this;
                            LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(m6656offsetNN6EwU, z20, lazyListItemProvider2, lazyLayoutMeasureScope, itemCount, i13, horizontal6, vertical6, z21, i6, i12, j2, lazyListState2) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
                                final /* synthetic */ int $afterContentPadding;
                                final /* synthetic */ int $beforeContentPadding;
                                final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
                                final /* synthetic */ boolean $isVertical;
                                final /* synthetic */ int $itemsCount;
                                final /* synthetic */ boolean $reverseLayout;
                                final /* synthetic */ int $spaceBetweenItems;
                                final /* synthetic */ LazyListState $state;
                                final /* synthetic */ LazyLayoutMeasureScope $this_null;
                                final /* synthetic */ Alignment.Vertical $verticalAlignment;
                                final /* synthetic */ long $visualItemOffset;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    this.$isVertical = z20;
                                    this.$this_null = lazyLayoutMeasureScope;
                                    this.$itemsCount = itemCount;
                                    this.$spaceBetweenItems = i13;
                                    this.$horizontalAlignment = horizontal6;
                                    this.$verticalAlignment = vertical6;
                                    this.$reverseLayout = z21;
                                    this.$beforeContentPadding = i6;
                                    this.$afterContentPadding = i12;
                                    this.$visualItemOffset = j2;
                                    this.$state = lazyListState2;
                                }

                                @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
                                /* renamed from: createItem-X9ElhV4  reason: not valid java name */
                                public LazyListMeasuredItem mo843createItemX9ElhV4(int i15, Object obj6, Object obj7, List<? extends Placeable> list, long j3) {
                                    return new LazyListMeasuredItem(i15, list, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_null.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, i15 == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, obj6, obj7, this.$state.getItemAnimator$foundation_release(), j3, null);
                                }
                            };
                            Snapshot.Companion companion = Snapshot.Companion;
                            LazyListState lazyListState3 = LazyListState.this;
                            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                            Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                            try {
                                int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyListState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyListItemProvider2, lazyListState3.getFirstVisibleItemIndex());
                                int firstVisibleItemScrollOffset = lazyListState3.getFirstVisibleItemScrollOffset();
                                Unit unit = Unit.INSTANCE;
                                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                List<Integer> calculateLazyLayoutPinnedIndices = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyListItemProvider2, LazyListState.this.getPinnedItems$foundation_release(), LazyListState.this.getBeyondBoundsInfo$foundation_release());
                                if (lazyLayoutMeasureScope.isLookingAhead() || !z17) {
                                    scrollToBeConsumed$foundation_release = LazyListState.this.getScrollToBeConsumed$foundation_release();
                                } else {
                                    scrollToBeConsumed$foundation_release = LazyListState.this.getScrollDeltaBetweenPasses$foundation_release();
                                }
                                LazyListMeasureResult m847measureLazyListLCrQqZ4 = LazyListMeasureKt.m847measureLazyListLCrQqZ4(itemCount, lazyListMeasuredItemProvider, i14, i6, i12, i13, updateScrollPositionIfTheFirstItemWasMoved$foundation_release, firstVisibleItemScrollOffset, scrollToBeConsumed$foundation_release, m6656offsetNN6EwU, z16222, vertical3222, horizontal3222, z, lazyLayoutMeasureScope, LazyListState.this.getItemAnimator$foundation_release(), i, calculateLazyLayoutPinnedIndices, z17, lazyLayoutMeasureScope.isLookingAhead(), LazyListState.this.getApproachLayoutInfo$foundation_release(), coroutineScope, LazyListState.this.m858getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, stickyItemsPlacement2222, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measureResult$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                        return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                    }

                                    public final MeasureResult invoke(int i15, int i16, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                        return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6654constrainWidthK40F9xA(j, i15 + i10), ConstraintsKt.m6653constrainHeightK40F9xA(j, i16 + i9), MapsKt.emptyMap(), function1);
                                    }
                                });
                                LazyListState.applyMeasureResult$foundation_release$default(LazyListState.this, m847measureLazyListLCrQqZ4, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                                return m847measureLazyListLCrQqZ4;
                            } catch (Throwable th) {
                                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                throw th;
                            }
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2222 = (Function2) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    return function2222;
                }
                z6 = true;
                boolean z142 = z13 | z6;
                if (((234881024 & i2) ^ 100663296) <= 67108864) {
                }
                if ((100663296 & i2) != 67108864) {
                }
                z7 = true;
                boolean z1522 = z142 | z7;
                if (((1879048192 & i2) ^ 805306368) > 536870912) {
                }
                if ((i2 & 805306368) != 536870912) {
                }
                z8 = true;
                boolean changed222 = z8 | z1522 | composer.changed(graphicsContext);
                if (((i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256) {
                }
                if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
                }
                z9 = true;
                z10 = changed222 | z9;
                rememberedValue = composer.rememberedValue();
                if (!z10) {
                }
                final Arrangement.Vertical vertical32222 = obj4;
                final Arrangement.Horizontal horizontal32222 = obj3;
                final StickyItemsPlacement stickyItemsPlacement22222 = obj5;
                final Alignment.Horizontal horizontal42222 = obj;
                final Alignment.Vertical vertical42222 = obj2;
                final boolean z162222 = z3;
                rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ LazyListMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                        return m842invoke0kLqBqw(lazyLayoutMeasureScope, constraints.m6643unboximpl());
                    }

                    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                    public final LazyListMeasureResult m842invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                        int i4;
                        int i5;
                        final int i6;
                        float mo625getSpacingD9Ej5fM;
                        int m6637getMaxWidthimpl;
                        LazyListItemProvider lazyListItemProvider;
                        long m6806constructorimpl;
                        float scrollToBeConsumed$foundation_release;
                        ObservableScopeInvalidator.m918attachToScopeimpl(LazyListState.this.m857getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                        boolean z17 = LazyListState.this.getHasLookaheadOccurred$foundation_release() || lazyLayoutMeasureScope.isLookingAhead();
                        CheckScrollableContainerConstraintsKt.m275checkScrollableContainerConstraintsK40F9xA(j, z162222 ? Orientation.Vertical : Orientation.Horizontal);
                        if (z162222) {
                            i4 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo688calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                        } else {
                            i4 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                        }
                        if (z162222) {
                            i5 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo689calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                        } else {
                            i5 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                        }
                        int i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo690calculateTopPaddingD9Ej5fM());
                        int i8 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo687calculateBottomPaddingD9Ej5fM());
                        final int i9 = i7 + i8;
                        final int i10 = i4 + i5;
                        boolean z18 = z162222;
                        int i11 = z18 ? i9 : i10;
                        if (z18 && !z) {
                            i6 = i7;
                        } else if (z18 && z) {
                            i6 = i8;
                        } else {
                            i6 = (z18 || z) ? i5 : i4;
                        }
                        final int i12 = i11 - i6;
                        final long m6656offsetNN6EwU = ConstraintsKt.m6656offsetNN6EwU(j, -i10, -i9);
                        LazyListItemProvider invoke = function0.invoke();
                        invoke.getItemScope().setMaxSize(Constraints.m6637getMaxWidthimpl(m6656offsetNN6EwU), Constraints.m6636getMaxHeightimpl(m6656offsetNN6EwU));
                        if (z162222) {
                            Arrangement.Vertical vertical5 = vertical32222;
                            if (vertical5 != null) {
                                mo625getSpacingD9Ej5fM = vertical5.mo625getSpacingD9Ej5fM();
                            } else {
                                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                                throw new KotlinNothingValueException();
                            }
                        } else {
                            Arrangement.Horizontal horizontal5 = horizontal32222;
                            if (horizontal5 != null) {
                                mo625getSpacingD9Ej5fM = horizontal5.mo625getSpacingD9Ej5fM();
                            } else {
                                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalAlignment when isVertical == false");
                                throw new KotlinNothingValueException();
                            }
                        }
                        final int i13 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(mo625getSpacingD9Ej5fM);
                        final int itemCount = invoke.getItemCount();
                        if (z162222) {
                            m6637getMaxWidthimpl = Constraints.m6636getMaxHeightimpl(j) - i9;
                        } else {
                            m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j) - i10;
                        }
                        int i14 = m6637getMaxWidthimpl;
                        if (z && i14 <= 0) {
                            boolean z19 = z162222;
                            if (!z19) {
                                i4 += i14;
                            }
                            if (z19) {
                                i7 += i14;
                            }
                            lazyListItemProvider = invoke;
                            m6806constructorimpl = IntOffset.m6806constructorimpl((i4 << 32) | (i7 & 4294967295L));
                        } else {
                            lazyListItemProvider = invoke;
                            m6806constructorimpl = IntOffset.m6806constructorimpl((i4 << 32) | (i7 & 4294967295L));
                        }
                        final boolean z20 = z162222;
                        final Alignment.Horizontal horizontal6 = horizontal42222;
                        final long j2 = m6806constructorimpl;
                        final LazyListItemProvider lazyListItemProvider2 = lazyListItemProvider;
                        final Alignment.Vertical vertical6 = vertical42222;
                        final boolean z21 = z;
                        final LazyListState lazyListState2 = LazyListState.this;
                        LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(m6656offsetNN6EwU, z20, lazyListItemProvider2, lazyLayoutMeasureScope, itemCount, i13, horizontal6, vertical6, z21, i6, i12, j2, lazyListState2) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
                            final /* synthetic */ int $afterContentPadding;
                            final /* synthetic */ int $beforeContentPadding;
                            final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
                            final /* synthetic */ boolean $isVertical;
                            final /* synthetic */ int $itemsCount;
                            final /* synthetic */ boolean $reverseLayout;
                            final /* synthetic */ int $spaceBetweenItems;
                            final /* synthetic */ LazyListState $state;
                            final /* synthetic */ LazyLayoutMeasureScope $this_null;
                            final /* synthetic */ Alignment.Vertical $verticalAlignment;
                            final /* synthetic */ long $visualItemOffset;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.$isVertical = z20;
                                this.$this_null = lazyLayoutMeasureScope;
                                this.$itemsCount = itemCount;
                                this.$spaceBetweenItems = i13;
                                this.$horizontalAlignment = horizontal6;
                                this.$verticalAlignment = vertical6;
                                this.$reverseLayout = z21;
                                this.$beforeContentPadding = i6;
                                this.$afterContentPadding = i12;
                                this.$visualItemOffset = j2;
                                this.$state = lazyListState2;
                            }

                            @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
                            /* renamed from: createItem-X9ElhV4  reason: not valid java name */
                            public LazyListMeasuredItem mo843createItemX9ElhV4(int i15, Object obj6, Object obj7, List<? extends Placeable> list, long j3) {
                                return new LazyListMeasuredItem(i15, list, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_null.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, i15 == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, obj6, obj7, this.$state.getItemAnimator$foundation_release(), j3, null);
                            }
                        };
                        Snapshot.Companion companion = Snapshot.Companion;
                        LazyListState lazyListState3 = LazyListState.this;
                        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                        try {
                            int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyListState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyListItemProvider2, lazyListState3.getFirstVisibleItemIndex());
                            int firstVisibleItemScrollOffset = lazyListState3.getFirstVisibleItemScrollOffset();
                            Unit unit = Unit.INSTANCE;
                            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                            List<Integer> calculateLazyLayoutPinnedIndices = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyListItemProvider2, LazyListState.this.getPinnedItems$foundation_release(), LazyListState.this.getBeyondBoundsInfo$foundation_release());
                            if (lazyLayoutMeasureScope.isLookingAhead() || !z17) {
                                scrollToBeConsumed$foundation_release = LazyListState.this.getScrollToBeConsumed$foundation_release();
                            } else {
                                scrollToBeConsumed$foundation_release = LazyListState.this.getScrollDeltaBetweenPasses$foundation_release();
                            }
                            LazyListMeasureResult m847measureLazyListLCrQqZ4 = LazyListMeasureKt.m847measureLazyListLCrQqZ4(itemCount, lazyListMeasuredItemProvider, i14, i6, i12, i13, updateScrollPositionIfTheFirstItemWasMoved$foundation_release, firstVisibleItemScrollOffset, scrollToBeConsumed$foundation_release, m6656offsetNN6EwU, z162222, vertical32222, horizontal32222, z, lazyLayoutMeasureScope, LazyListState.this.getItemAnimator$foundation_release(), i, calculateLazyLayoutPinnedIndices, z17, lazyLayoutMeasureScope.isLookingAhead(), LazyListState.this.getApproachLayoutInfo$foundation_release(), coroutineScope, LazyListState.this.m858getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, stickyItemsPlacement22222, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measureResult$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                    return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                }

                                public final MeasureResult invoke(int i15, int i16, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                    return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6654constrainWidthK40F9xA(j, i15 + i10), ConstraintsKt.m6653constrainHeightK40F9xA(j, i16 + i9), MapsKt.emptyMap(), function1);
                                }
                            });
                            LazyListState.applyMeasureResult$foundation_release$default(LazyListState.this, m847measureLazyListLCrQqZ4, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                            return m847measureLazyListLCrQqZ4;
                        } catch (Throwable th) {
                            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                            throw th;
                        }
                    }
                };
                composer.updateRememberedValue(rememberedValue);
                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function22222 = (Function2) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (ComposerKt.isTraceInProgress()) {
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                return function22222;
            }
            z5 = true;
            boolean z132 = z12 | z5;
            if (((29360128 & i2) ^ 12582912) > 8388608) {
            }
            if ((12582912 & i2) != 8388608) {
            }
            z6 = true;
            boolean z1422 = z132 | z6;
            if (((234881024 & i2) ^ 100663296) <= 67108864) {
            }
            if ((100663296 & i2) != 67108864) {
            }
            z7 = true;
            boolean z15222 = z1422 | z7;
            if (((1879048192 & i2) ^ 805306368) > 536870912) {
            }
            if ((i2 & 805306368) != 536870912) {
            }
            z8 = true;
            boolean changed2222 = z8 | z15222 | composer.changed(graphicsContext);
            if (((i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256) {
            }
            if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
            }
            z9 = true;
            z10 = changed2222 | z9;
            rememberedValue = composer.rememberedValue();
            if (!z10) {
            }
            final Arrangement.Vertical vertical322222 = obj4;
            final Arrangement.Horizontal horizontal322222 = obj3;
            final StickyItemsPlacement stickyItemsPlacement222222 = obj5;
            final Alignment.Horizontal horizontal422222 = obj;
            final Alignment.Vertical vertical422222 = obj2;
            final boolean z1622222 = z3;
            rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyListMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m842invoke0kLqBqw(lazyLayoutMeasureScope, constraints.m6643unboximpl());
                }

                /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                public final LazyListMeasureResult m842invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                    int i4;
                    int i5;
                    final int i6;
                    float mo625getSpacingD9Ej5fM;
                    int m6637getMaxWidthimpl;
                    LazyListItemProvider lazyListItemProvider;
                    long m6806constructorimpl;
                    float scrollToBeConsumed$foundation_release;
                    ObservableScopeInvalidator.m918attachToScopeimpl(LazyListState.this.m857getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                    boolean z17 = LazyListState.this.getHasLookaheadOccurred$foundation_release() || lazyLayoutMeasureScope.isLookingAhead();
                    CheckScrollableContainerConstraintsKt.m275checkScrollableContainerConstraintsK40F9xA(j, z1622222 ? Orientation.Vertical : Orientation.Horizontal);
                    if (z1622222) {
                        i4 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo688calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i4 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    if (z1622222) {
                        i5 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo689calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i5 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    int i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo690calculateTopPaddingD9Ej5fM());
                    int i8 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo687calculateBottomPaddingD9Ej5fM());
                    final int i9 = i7 + i8;
                    final int i10 = i4 + i5;
                    boolean z18 = z1622222;
                    int i11 = z18 ? i9 : i10;
                    if (z18 && !z) {
                        i6 = i7;
                    } else if (z18 && z) {
                        i6 = i8;
                    } else {
                        i6 = (z18 || z) ? i5 : i4;
                    }
                    final int i12 = i11 - i6;
                    final long m6656offsetNN6EwU = ConstraintsKt.m6656offsetNN6EwU(j, -i10, -i9);
                    LazyListItemProvider invoke = function0.invoke();
                    invoke.getItemScope().setMaxSize(Constraints.m6637getMaxWidthimpl(m6656offsetNN6EwU), Constraints.m6636getMaxHeightimpl(m6656offsetNN6EwU));
                    if (z1622222) {
                        Arrangement.Vertical vertical5 = vertical322222;
                        if (vertical5 != null) {
                            mo625getSpacingD9Ej5fM = vertical5.mo625getSpacingD9Ej5fM();
                        } else {
                            InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                            throw new KotlinNothingValueException();
                        }
                    } else {
                        Arrangement.Horizontal horizontal5 = horizontal322222;
                        if (horizontal5 != null) {
                            mo625getSpacingD9Ej5fM = horizontal5.mo625getSpacingD9Ej5fM();
                        } else {
                            InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalAlignment when isVertical == false");
                            throw new KotlinNothingValueException();
                        }
                    }
                    final int i13 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(mo625getSpacingD9Ej5fM);
                    final int itemCount = invoke.getItemCount();
                    if (z1622222) {
                        m6637getMaxWidthimpl = Constraints.m6636getMaxHeightimpl(j) - i9;
                    } else {
                        m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j) - i10;
                    }
                    int i14 = m6637getMaxWidthimpl;
                    if (z && i14 <= 0) {
                        boolean z19 = z1622222;
                        if (!z19) {
                            i4 += i14;
                        }
                        if (z19) {
                            i7 += i14;
                        }
                        lazyListItemProvider = invoke;
                        m6806constructorimpl = IntOffset.m6806constructorimpl((i4 << 32) | (i7 & 4294967295L));
                    } else {
                        lazyListItemProvider = invoke;
                        m6806constructorimpl = IntOffset.m6806constructorimpl((i4 << 32) | (i7 & 4294967295L));
                    }
                    final boolean z20 = z1622222;
                    final Alignment.Horizontal horizontal6 = horizontal422222;
                    final long j2 = m6806constructorimpl;
                    final LazyListItemProvider lazyListItemProvider2 = lazyListItemProvider;
                    final Alignment.Vertical vertical6 = vertical422222;
                    final boolean z21 = z;
                    final LazyListState lazyListState2 = LazyListState.this;
                    LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(m6656offsetNN6EwU, z20, lazyListItemProvider2, lazyLayoutMeasureScope, itemCount, i13, horizontal6, vertical6, z21, i6, i12, j2, lazyListState2) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
                        final /* synthetic */ int $afterContentPadding;
                        final /* synthetic */ int $beforeContentPadding;
                        final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
                        final /* synthetic */ boolean $isVertical;
                        final /* synthetic */ int $itemsCount;
                        final /* synthetic */ boolean $reverseLayout;
                        final /* synthetic */ int $spaceBetweenItems;
                        final /* synthetic */ LazyListState $state;
                        final /* synthetic */ LazyLayoutMeasureScope $this_null;
                        final /* synthetic */ Alignment.Vertical $verticalAlignment;
                        final /* synthetic */ long $visualItemOffset;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.$isVertical = z20;
                            this.$this_null = lazyLayoutMeasureScope;
                            this.$itemsCount = itemCount;
                            this.$spaceBetweenItems = i13;
                            this.$horizontalAlignment = horizontal6;
                            this.$verticalAlignment = vertical6;
                            this.$reverseLayout = z21;
                            this.$beforeContentPadding = i6;
                            this.$afterContentPadding = i12;
                            this.$visualItemOffset = j2;
                            this.$state = lazyListState2;
                        }

                        @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
                        /* renamed from: createItem-X9ElhV4  reason: not valid java name */
                        public LazyListMeasuredItem mo843createItemX9ElhV4(int i15, Object obj6, Object obj7, List<? extends Placeable> list, long j3) {
                            return new LazyListMeasuredItem(i15, list, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_null.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, i15 == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, obj6, obj7, this.$state.getItemAnimator$foundation_release(), j3, null);
                        }
                    };
                    Snapshot.Companion companion = Snapshot.Companion;
                    LazyListState lazyListState3 = LazyListState.this;
                    Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                    Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                    Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                    try {
                        int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyListState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyListItemProvider2, lazyListState3.getFirstVisibleItemIndex());
                        int firstVisibleItemScrollOffset = lazyListState3.getFirstVisibleItemScrollOffset();
                        Unit unit = Unit.INSTANCE;
                        companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                        List<Integer> calculateLazyLayoutPinnedIndices = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyListItemProvider2, LazyListState.this.getPinnedItems$foundation_release(), LazyListState.this.getBeyondBoundsInfo$foundation_release());
                        if (lazyLayoutMeasureScope.isLookingAhead() || !z17) {
                            scrollToBeConsumed$foundation_release = LazyListState.this.getScrollToBeConsumed$foundation_release();
                        } else {
                            scrollToBeConsumed$foundation_release = LazyListState.this.getScrollDeltaBetweenPasses$foundation_release();
                        }
                        LazyListMeasureResult m847measureLazyListLCrQqZ4 = LazyListMeasureKt.m847measureLazyListLCrQqZ4(itemCount, lazyListMeasuredItemProvider, i14, i6, i12, i13, updateScrollPositionIfTheFirstItemWasMoved$foundation_release, firstVisibleItemScrollOffset, scrollToBeConsumed$foundation_release, m6656offsetNN6EwU, z1622222, vertical322222, horizontal322222, z, lazyLayoutMeasureScope, LazyListState.this.getItemAnimator$foundation_release(), i, calculateLazyLayoutPinnedIndices, z17, lazyLayoutMeasureScope.isLookingAhead(), LazyListState.this.getApproachLayoutInfo$foundation_release(), coroutineScope, LazyListState.this.m858getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, stickyItemsPlacement222222, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measureResult$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                            }

                            public final MeasureResult invoke(int i15, int i16, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6654constrainWidthK40F9xA(j, i15 + i10), ConstraintsKt.m6653constrainHeightK40F9xA(j, i16 + i9), MapsKt.emptyMap(), function1);
                            }
                        });
                        LazyListState.applyMeasureResult$foundation_release$default(LazyListState.this, m847measureLazyListLCrQqZ4, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                        return m847measureLazyListLCrQqZ4;
                    } catch (Throwable th) {
                        companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                        throw th;
                    }
                }
            };
            composer.updateRememberedValue(rememberedValue);
            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function222222 = (Function2) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return function222222;
        }
        z4 = true;
        boolean z122 = z11 | z4;
        if (((3670016 & i2) ^ 1572864) <= 1048576) {
        }
        if ((1572864 & i2) != 1048576) {
        }
        z5 = true;
        boolean z1322 = z122 | z5;
        if (((29360128 & i2) ^ 12582912) > 8388608) {
        }
        if ((12582912 & i2) != 8388608) {
        }
        z6 = true;
        boolean z14222 = z1322 | z6;
        if (((234881024 & i2) ^ 100663296) <= 67108864) {
        }
        if ((100663296 & i2) != 67108864) {
        }
        z7 = true;
        boolean z152222 = z14222 | z7;
        if (((1879048192 & i2) ^ 805306368) > 536870912) {
        }
        if ((i2 & 805306368) != 536870912) {
        }
        z8 = true;
        boolean changed22222 = z8 | z152222 | composer.changed(graphicsContext);
        if (((i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256) {
        }
        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
        }
        z9 = true;
        z10 = changed22222 | z9;
        rememberedValue = composer.rememberedValue();
        if (!z10) {
        }
        final Arrangement.Vertical vertical3222222 = obj4;
        final Arrangement.Horizontal horizontal3222222 = obj3;
        final StickyItemsPlacement stickyItemsPlacement2222222 = obj5;
        final Alignment.Horizontal horizontal4222222 = obj;
        final Alignment.Vertical vertical4222222 = obj2;
        final boolean z16222222 = z3;
        rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ LazyListMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                return m842invoke0kLqBqw(lazyLayoutMeasureScope, constraints.m6643unboximpl());
            }

            /* renamed from: invoke-0kLqBqw  reason: not valid java name */
            public final LazyListMeasureResult m842invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                int i4;
                int i5;
                final int i6;
                float mo625getSpacingD9Ej5fM;
                int m6637getMaxWidthimpl;
                LazyListItemProvider lazyListItemProvider;
                long m6806constructorimpl;
                float scrollToBeConsumed$foundation_release;
                ObservableScopeInvalidator.m918attachToScopeimpl(LazyListState.this.m857getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                boolean z17 = LazyListState.this.getHasLookaheadOccurred$foundation_release() || lazyLayoutMeasureScope.isLookingAhead();
                CheckScrollableContainerConstraintsKt.m275checkScrollableContainerConstraintsK40F9xA(j, z16222222 ? Orientation.Vertical : Orientation.Horizontal);
                if (z16222222) {
                    i4 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo688calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                } else {
                    i4 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                }
                if (z16222222) {
                    i5 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo689calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                } else {
                    i5 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                }
                int i7 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo690calculateTopPaddingD9Ej5fM());
                int i8 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(paddingValues.mo687calculateBottomPaddingD9Ej5fM());
                final int i9 = i7 + i8;
                final int i10 = i4 + i5;
                boolean z18 = z16222222;
                int i11 = z18 ? i9 : i10;
                if (z18 && !z) {
                    i6 = i7;
                } else if (z18 && z) {
                    i6 = i8;
                } else {
                    i6 = (z18 || z) ? i5 : i4;
                }
                final int i12 = i11 - i6;
                final long m6656offsetNN6EwU = ConstraintsKt.m6656offsetNN6EwU(j, -i10, -i9);
                LazyListItemProvider invoke = function0.invoke();
                invoke.getItemScope().setMaxSize(Constraints.m6637getMaxWidthimpl(m6656offsetNN6EwU), Constraints.m6636getMaxHeightimpl(m6656offsetNN6EwU));
                if (z16222222) {
                    Arrangement.Vertical vertical5 = vertical3222222;
                    if (vertical5 != null) {
                        mo625getSpacingD9Ej5fM = vertical5.mo625getSpacingD9Ej5fM();
                    } else {
                        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                        throw new KotlinNothingValueException();
                    }
                } else {
                    Arrangement.Horizontal horizontal5 = horizontal3222222;
                    if (horizontal5 != null) {
                        mo625getSpacingD9Ej5fM = horizontal5.mo625getSpacingD9Ej5fM();
                    } else {
                        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalAlignment when isVertical == false");
                        throw new KotlinNothingValueException();
                    }
                }
                final int i13 = lazyLayoutMeasureScope.mo383roundToPx0680j_4(mo625getSpacingD9Ej5fM);
                final int itemCount = invoke.getItemCount();
                if (z16222222) {
                    m6637getMaxWidthimpl = Constraints.m6636getMaxHeightimpl(j) - i9;
                } else {
                    m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j) - i10;
                }
                int i14 = m6637getMaxWidthimpl;
                if (z && i14 <= 0) {
                    boolean z19 = z16222222;
                    if (!z19) {
                        i4 += i14;
                    }
                    if (z19) {
                        i7 += i14;
                    }
                    lazyListItemProvider = invoke;
                    m6806constructorimpl = IntOffset.m6806constructorimpl((i4 << 32) | (i7 & 4294967295L));
                } else {
                    lazyListItemProvider = invoke;
                    m6806constructorimpl = IntOffset.m6806constructorimpl((i4 << 32) | (i7 & 4294967295L));
                }
                final boolean z20 = z16222222;
                final Alignment.Horizontal horizontal6 = horizontal4222222;
                final long j2 = m6806constructorimpl;
                final LazyListItemProvider lazyListItemProvider2 = lazyListItemProvider;
                final Alignment.Vertical vertical6 = vertical4222222;
                final boolean z21 = z;
                final LazyListState lazyListState2 = LazyListState.this;
                LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(m6656offsetNN6EwU, z20, lazyListItemProvider2, lazyLayoutMeasureScope, itemCount, i13, horizontal6, vertical6, z21, i6, i12, j2, lazyListState2) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
                    final /* synthetic */ int $afterContentPadding;
                    final /* synthetic */ int $beforeContentPadding;
                    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
                    final /* synthetic */ boolean $isVertical;
                    final /* synthetic */ int $itemsCount;
                    final /* synthetic */ boolean $reverseLayout;
                    final /* synthetic */ int $spaceBetweenItems;
                    final /* synthetic */ LazyListState $state;
                    final /* synthetic */ LazyLayoutMeasureScope $this_null;
                    final /* synthetic */ Alignment.Vertical $verticalAlignment;
                    final /* synthetic */ long $visualItemOffset;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.$isVertical = z20;
                        this.$this_null = lazyLayoutMeasureScope;
                        this.$itemsCount = itemCount;
                        this.$spaceBetweenItems = i13;
                        this.$horizontalAlignment = horizontal6;
                        this.$verticalAlignment = vertical6;
                        this.$reverseLayout = z21;
                        this.$beforeContentPadding = i6;
                        this.$afterContentPadding = i12;
                        this.$visualItemOffset = j2;
                        this.$state = lazyListState2;
                    }

                    @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
                    /* renamed from: createItem-X9ElhV4  reason: not valid java name */
                    public LazyListMeasuredItem mo843createItemX9ElhV4(int i15, Object obj6, Object obj7, List<? extends Placeable> list, long j3) {
                        return new LazyListMeasuredItem(i15, list, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_null.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, i15 == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, obj6, obj7, this.$state.getItemAnimator$foundation_release(), j3, null);
                    }
                };
                Snapshot.Companion companion = Snapshot.Companion;
                LazyListState lazyListState3 = LazyListState.this;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyListState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyListItemProvider2, lazyListState3.getFirstVisibleItemIndex());
                    int firstVisibleItemScrollOffset = lazyListState3.getFirstVisibleItemScrollOffset();
                    Unit unit = Unit.INSTANCE;
                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                    List<Integer> calculateLazyLayoutPinnedIndices = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyListItemProvider2, LazyListState.this.getPinnedItems$foundation_release(), LazyListState.this.getBeyondBoundsInfo$foundation_release());
                    if (lazyLayoutMeasureScope.isLookingAhead() || !z17) {
                        scrollToBeConsumed$foundation_release = LazyListState.this.getScrollToBeConsumed$foundation_release();
                    } else {
                        scrollToBeConsumed$foundation_release = LazyListState.this.getScrollDeltaBetweenPasses$foundation_release();
                    }
                    LazyListMeasureResult m847measureLazyListLCrQqZ4 = LazyListMeasureKt.m847measureLazyListLCrQqZ4(itemCount, lazyListMeasuredItemProvider, i14, i6, i12, i13, updateScrollPositionIfTheFirstItemWasMoved$foundation_release, firstVisibleItemScrollOffset, scrollToBeConsumed$foundation_release, m6656offsetNN6EwU, z16222222, vertical3222222, horizontal3222222, z, lazyLayoutMeasureScope, LazyListState.this.getItemAnimator$foundation_release(), i, calculateLazyLayoutPinnedIndices, z17, lazyLayoutMeasureScope.isLookingAhead(), LazyListState.this.getApproachLayoutInfo$foundation_release(), coroutineScope, LazyListState.this.m858getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, stickyItemsPlacement2222222, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measureResult$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                            return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                        }

                        public final MeasureResult invoke(int i15, int i16, Function1<? super Placeable.PlacementScope, Unit> function1) {
                            return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6654constrainWidthK40F9xA(j, i15 + i10), ConstraintsKt.m6653constrainHeightK40F9xA(j, i16 + i9), MapsKt.emptyMap(), function1);
                        }
                    });
                    LazyListState.applyMeasureResult$foundation_release$default(LazyListState.this, m847measureLazyListLCrQqZ4, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                    return m847measureLazyListLCrQqZ4;
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
        };
        composer.updateRememberedValue(rememberedValue);
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2222222 = (Function2) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return function2222222;
    }
}
