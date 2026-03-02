package androidx.compose.foundation.lazy;

import android.os.Trace;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollableAreaKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: LazyList.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a¢\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00010\u001b¢\u0006\u0002\b\u001dH\u0001¢\u0006\u0002\u0010\u001e\u001a\u0085\u0001\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0003¢\u0006\u0002\u0010*\u001a\"\u0010+\u001a\u00020\u0001*\u00020,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u00100\u001a\u000201H\u0002¨\u00062"}, d2 = {"LazyList", "", "modifier", "Landroidx/compose/ui/Modifier;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "beyondBoundsItemCount", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;ILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyListMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "stickyItemsPlacement", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "keepAroundItems", "Landroidx/compose/foundation/lazy/layout/CacheWindowLogic;", "visibleItemsList", "", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyListKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LazyList$lambda$0(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, boolean z2, FlingBehavior flingBehavior, boolean z3, OverscrollEffect overscrollEffect, int i, Alignment.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, Arrangement.Horizontal horizontal2, Function1 function1, int i2, int i3, int i4, Composer composer, int i5) {
        LazyList(modifier, lazyListState, paddingValues, z, z2, flingBehavior, z3, overscrollEffect, i, horizontal, vertical, vertical2, horizontal2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:181:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyList(final Modifier modifier, LazyListState lazyListState, final PaddingValues paddingValues, final boolean z, final boolean z2, final FlingBehavior flingBehavior, final boolean z3, final OverscrollEffect overscrollEffect, int i, Alignment.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, Arrangement.Horizontal horizontal2, final Function1<? super LazyListScope, Unit> function1, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Object obj;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        LazyListState lazyListState2;
        final Alignment.Horizontal horizontal3;
        final Arrangement.Vertical vertical3;
        final Arrangement.Horizontal horizontal4;
        final int i12;
        final Alignment.Vertical vertical4;
        ScopeUpdateScope endRestartGroup;
        int i13;
        Alignment.Horizontal horizontal5;
        Arrangement.Vertical vertical5;
        Alignment.Vertical vertical6;
        int i14;
        int i15;
        Arrangement.Horizontal horizontal6;
        Object rememberedValue;
        Modifier.Companion companion;
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(924924659);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyList)N(modifier,state,contentPadding,reverseLayout,isVertical,flingBehavior,userScrollEnabled,overscrollEffect,beyondBoundsItemCount,horizontalAlignment,verticalArrangement,verticalAlignment,horizontalArrangement,content)86@4189L50,88@4265L48,89@4339L24,90@4411L7,91@4480L7,94@4521L484,133@5809L302,128@5640L1117:LazyList.kt#428nma");
        if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= startRestartGroup.changed(lazyListState) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = paddingValues;
            i5 |= startRestartGroup.changed(obj) ? 256 : 128;
        } else {
            obj = paddingValues;
        }
        if ((i2 & 3072) == 0) {
            i5 |= startRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i5 |= startRestartGroup.changed(z2) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i5 |= startRestartGroup.changed(flingBehavior) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i5 |= startRestartGroup.changed(z3) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i5 |= startRestartGroup.changed(overscrollEffect) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            if ((i4 & 256) == 0) {
                i6 = i;
                if (startRestartGroup.changed(i6)) {
                    i16 = 67108864;
                    i5 |= i16;
                }
            } else {
                i6 = i;
            }
            i16 = 33554432;
            i5 |= i16;
        } else {
            i6 = i;
        }
        int i17 = i4 & 512;
        if (i17 != 0) {
            i5 |= 805306368;
        } else if ((i2 & 805306368) == 0) {
            i5 |= startRestartGroup.changed(horizontal) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        int i18 = i4 & 1024;
        if (i18 != 0) {
            i8 = i3 | 6;
            i7 = i18;
        } else if ((i3 & 6) == 0) {
            i7 = i18;
            i8 = i3 | (startRestartGroup.changed(vertical) ? 4 : 2);
        } else {
            i7 = i18;
            i8 = i3;
        }
        int i19 = i4 & 2048;
        if (i19 != 0) {
            i8 |= 48;
            i9 = i19;
        } else if ((i3 & 48) == 0) {
            i9 = i19;
            i8 |= startRestartGroup.changed(vertical2) ? 32 : 16;
        } else {
            i9 = i19;
        }
        int i20 = i8;
        int i21 = i4 & 4096;
        if (i21 != 0) {
            i10 = i20 | RendererCapabilities.DECODER_SUPPORT_MASK;
        } else {
            i10 = i20;
            if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i10 |= startRestartGroup.changed(horizontal2) ? 256 : 128;
                if ((i3 & 3072) == 0) {
                    i10 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
                }
                i11 = i10;
                if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i11 & 1171) != 1170, i5 & 1)) {
                    startRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(startRestartGroup, "74@3486L38");
                    if ((i2 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                        if ((i4 & 256) != 0) {
                            i13 = LazyList_androidKt.defaultLazyListBeyondBoundsItemCount(startRestartGroup, 0);
                            i5 &= -234881025;
                        } else {
                            i13 = i6;
                        }
                        horizontal5 = i17 != 0 ? null : horizontal;
                        vertical5 = i7 != 0 ? null : vertical;
                        vertical6 = i9 != 0 ? null : vertical2;
                        i14 = i13;
                        i15 = i5;
                        if (i21 != 0) {
                            horizontal6 = null;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(924924659, i15, i11, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:85)");
                            }
                            int i22 = (i15 >> 3) & 14;
                            Function0<LazyListItemProvider> rememberLazyListItemProviderLambda = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, function1, startRestartGroup, i22 | ((i11 >> 6) & 112));
                            int i23 = i15 >> 9;
                            LazyLayoutSemanticState rememberLazyListSemanticState = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, z2, startRestartGroup, i22 | (i23 & 112));
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
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
                            StickyItemsPlacement stickToTopPlacement = ((Boolean) consume2).booleanValue() ? null : StickyItemsPlacement.Companion.getStickToTopPlacement();
                            int i24 = i11 << 18;
                            int i25 = (65520 & i15) | (i23 & 458752) | (3670016 & i23) | (29360128 & i24) | (i24 & 234881024) | ((i11 << 27) & 1879048192);
                            int i26 = i15;
                            LazyLayoutMeasurePolicy rememberLazyListMeasurePolicy = rememberLazyListMeasurePolicy(rememberLazyListItemProviderLambda, lazyListState, obj, z, z2, i14, horizontal5, vertical6, horizontal6, vertical5, coroutineScope, graphicsContext, stickToTopPlacement, startRestartGroup, i25, 0);
                            lazyListState2 = lazyListState;
                            Alignment.Horizontal horizontal7 = horizontal5;
                            Alignment.Vertical vertical7 = vertical6;
                            Arrangement.Horizontal horizontal8 = horizontal6;
                            Arrangement.Vertical vertical8 = vertical5;
                            int i27 = i14;
                            Orientation orientation = !z2 ? Orientation.Vertical : Orientation.Horizontal;
                            if (!z3) {
                                startRestartGroup.startReplaceGroup(-2077147368);
                                ComposerKt.sourceInformation(startRestartGroup, "116@5256L166");
                                companion = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.Companion, LazyListBeyondBoundsModifierKt.rememberLazyListBeyondBoundsState(lazyListState2, i27, startRestartGroup, i22 | ((i26 >> 21) & 112)), lazyListState2.getBeyondBoundsInfo$foundation(), z, orientation);
                                startRestartGroup.endReplaceGroup();
                            } else {
                                startRestartGroup.startReplaceGroup(-2076718545);
                                startRestartGroup.endReplaceGroup();
                                companion = Modifier.Companion;
                            }
                            LazyLayoutKt.LazyLayout(rememberLazyListItemProviderLambda, ScrollableAreaKt.scrollableArea$default(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState2.getRemeasurementModifier$foundation()).then(lazyListState2.getAwaitLayoutModifier$foundation()), rememberLazyListItemProviderLambda, rememberLazyListSemanticState, orientation, z3, z, startRestartGroup, ((i26 >> 6) & 57344) | ((i26 << 6) & 458752)).then(companion).then(lazyListState2.getItemAnimator$foundation().getModifier()), lazyListState2, orientation, overscrollEffect, z3, z, flingBehavior, lazyListState2.getInternalInteractionSource$foundation(), null, 128, null), lazyListState2.getPrefetchState$foundation(), rememberLazyListMeasurePolicy, startRestartGroup, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i12 = i27;
                            horizontal3 = horizontal7;
                            vertical4 = vertical7;
                            horizontal4 = horizontal8;
                            vertical3 = vertical8;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i4 & 256) != 0) {
                            i5 &= -234881025;
                        }
                        horizontal5 = horizontal;
                        vertical5 = vertical;
                        vertical6 = vertical2;
                        i15 = i5;
                        i14 = i6;
                    }
                    horizontal6 = horizontal2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i222 = (i15 >> 3) & 14;
                    Function0<LazyListItemProvider> rememberLazyListItemProviderLambda2 = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, function1, startRestartGroup, i222 | ((i11 >> 6) & 112));
                    int i232 = i15 >> 9;
                    LazyLayoutSemanticState rememberLazyListSemanticState2 = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, z2, startRestartGroup, i222 | (i232 & 112));
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
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
                    if (((Boolean) consume22).booleanValue()) {
                    }
                    int i242 = i11 << 18;
                    int i252 = (65520 & i15) | (i232 & 458752) | (3670016 & i232) | (29360128 & i242) | (i242 & 234881024) | ((i11 << 27) & 1879048192);
                    int i262 = i15;
                    LazyLayoutMeasurePolicy rememberLazyListMeasurePolicy2 = rememberLazyListMeasurePolicy(rememberLazyListItemProviderLambda2, lazyListState, obj, z, z2, i14, horizontal5, vertical6, horizontal6, vertical5, coroutineScope2, graphicsContext2, stickToTopPlacement, startRestartGroup, i252, 0);
                    lazyListState2 = lazyListState;
                    Alignment.Horizontal horizontal72 = horizontal5;
                    Alignment.Vertical vertical72 = vertical6;
                    Arrangement.Horizontal horizontal82 = horizontal6;
                    Arrangement.Vertical vertical82 = vertical5;
                    int i272 = i14;
                    Orientation orientation2 = !z2 ? Orientation.Vertical : Orientation.Horizontal;
                    if (!z3) {
                    }
                    LazyLayoutKt.LazyLayout(rememberLazyListItemProviderLambda2, ScrollableAreaKt.scrollableArea$default(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState2.getRemeasurementModifier$foundation()).then(lazyListState2.getAwaitLayoutModifier$foundation()), rememberLazyListItemProviderLambda2, rememberLazyListSemanticState2, orientation2, z3, z, startRestartGroup, ((i262 >> 6) & 57344) | ((i262 << 6) & 458752)).then(companion).then(lazyListState2.getItemAnimator$foundation().getModifier()), lazyListState2, orientation2, overscrollEffect, z3, z, flingBehavior, lazyListState2.getInternalInteractionSource$foundation(), null, 128, null), lazyListState2.getPrefetchState$foundation(), rememberLazyListMeasurePolicy2, startRestartGroup, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i12 = i272;
                    horizontal3 = horizontal72;
                    vertical4 = vertical72;
                    horizontal4 = horizontal82;
                    vertical3 = vertical82;
                } else {
                    lazyListState2 = lazyListState;
                    startRestartGroup.skipToGroupEnd();
                    horizontal3 = horizontal;
                    vertical3 = vertical;
                    horizontal4 = horizontal2;
                    i12 = i6;
                    vertical4 = vertical2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                    final LazyListState lazyListState3 = lazyListState2;
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.LazyListKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return LazyListKt.LazyList$lambda$0(Modifier.this, lazyListState3, paddingValues, z, z2, flingBehavior, z3, overscrollEffect, i12, horizontal3, vertical3, vertical4, horizontal4, function1, i2, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                    return;
                }
                return;
            }
        }
        if ((i3 & 3072) == 0) {
        }
        i11 = i10;
        if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i11 & 1171) != 1170, i5 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
        if (r34.changed(r4) == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00af, code lost:
        if (r34.changed(r9) == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00cb, code lost:
        if (r34.changed(r12) == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00e7, code lost:
        if (r34.changed(r13) == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0103, code lost:
        if (r34.changed(r5) == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0122, code lost:
        if (r34.changed(r6) == false) goto L65;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final LazyLayoutMeasurePolicy rememberLazyListMeasurePolicy(Function0<? extends LazyListItemProvider> function0, LazyListState lazyListState, PaddingValues paddingValues, boolean z, boolean z2, int i, Alignment.Horizontal horizontal, Alignment.Vertical vertical, Arrangement.Horizontal horizontal2, Arrangement.Vertical vertical2, CoroutineScope coroutineScope, GraphicsContext graphicsContext, StickyItemsPlacement stickyItemsPlacement, Composer composer, int i2, int i3) {
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
        LazyListKt$rememberLazyListMeasurePolicy$1$1 rememberedValue;
        ComposerKt.sourceInformationMarkerStart(composer, 406165748, "C(rememberLazyListMeasurePolicy)N(itemProviderLambda,state,contentPadding,reverseLayout,isVertical,beyondBoundsItemCount,horizontalAlignment,verticalAlignment,horizontalArrangement,verticalArrangement,coroutineScope,graphicsContext,stickyItemsPlacement)187@8024L9764:LazyList.kt#428nma");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(406165748, i2, i3, "androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:187)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -516691432, "CC(remember):LazyList.kt#9igjgp");
        boolean z11 = ((((i2 & 112) ^ 48) > 32 && composer.changed(lazyListState)) || (i2 & 48) == 32) | ((((i2 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(paddingValues)) || (i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | ((((i2 & 7168) ^ 3072) > 2048 && composer.changed(z)) || (i2 & 3072) == 2048);
        if (((57344 & i2) ^ 24576) > 16384) {
            z3 = z2;
        } else {
            z3 = z2;
        }
        if ((i2 & 24576) != 16384) {
            z4 = false;
            boolean z12 = z11 | z4 | ((((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) <= 131072 && composer.changed(i)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072);
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
                                    rememberedValue = new LazyListKt$rememberLazyListMeasurePolicy$1$1(lazyListState, z3, paddingValues, z, function0, obj4, obj3, i, coroutineScope, graphicsContext, obj5, obj, obj2);
                                    composer.updateRememberedValue(rememberedValue);
                                }
                                LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy = (LazyLayoutMeasurePolicy) rememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composer);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer);
                                return lazyLayoutMeasurePolicy;
                            }
                            z9 = true;
                            z10 = changed | z9;
                            rememberedValue = composer.rememberedValue();
                            if (!z10) {
                            }
                            rememberedValue = new LazyListKt$rememberLazyListMeasurePolicy$1$1(lazyListState, z3, paddingValues, z, function0, obj4, obj3, i, coroutineScope, graphicsContext, obj5, obj, obj2);
                            composer.updateRememberedValue(rememberedValue);
                            LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy2 = (LazyLayoutMeasurePolicy) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            return lazyLayoutMeasurePolicy2;
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
                        rememberedValue = new LazyListKt$rememberLazyListMeasurePolicy$1$1(lazyListState, z3, paddingValues, z, function0, obj4, obj3, i, coroutineScope, graphicsContext, obj5, obj, obj2);
                        composer.updateRememberedValue(rememberedValue);
                        LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy22 = (LazyLayoutMeasurePolicy) rememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        return lazyLayoutMeasurePolicy22;
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
                    rememberedValue = new LazyListKt$rememberLazyListMeasurePolicy$1$1(lazyListState, z3, paddingValues, z, function0, obj4, obj3, i, coroutineScope, graphicsContext, obj5, obj, obj2);
                    composer.updateRememberedValue(rememberedValue);
                    LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy222 = (LazyLayoutMeasurePolicy) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    return lazyLayoutMeasurePolicy222;
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
                rememberedValue = new LazyListKt$rememberLazyListMeasurePolicy$1$1(lazyListState, z3, paddingValues, z, function0, obj4, obj3, i, coroutineScope, graphicsContext, obj5, obj, obj2);
                composer.updateRememberedValue(rememberedValue);
                LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy2222 = (LazyLayoutMeasurePolicy) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (ComposerKt.isTraceInProgress()) {
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                return lazyLayoutMeasurePolicy2222;
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
            rememberedValue = new LazyListKt$rememberLazyListMeasurePolicy$1$1(lazyListState, z3, paddingValues, z, function0, obj4, obj3, i, coroutineScope, graphicsContext, obj5, obj, obj2);
            composer.updateRememberedValue(rememberedValue);
            LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy22222 = (LazyLayoutMeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return lazyLayoutMeasurePolicy22222;
        }
        z4 = true;
        boolean z122 = z11 | z4 | ((((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) <= 131072 && composer.changed(i)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072);
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
        rememberedValue = new LazyListKt$rememberLazyListMeasurePolicy$1$1(lazyListState, z3, paddingValues, z, function0, obj4, obj3, i, coroutineScope, graphicsContext, obj5, obj, obj2);
        composer.updateRememberedValue(rememberedValue);
        LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy222222 = (LazyLayoutMeasurePolicy) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyLayoutMeasurePolicy222222;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void keepAroundItems(CacheWindowLogic cacheWindowLogic, List<LazyListMeasuredItem> list, LazyListMeasuredItemProvider lazyListMeasuredItemProvider) {
        Trace.beginSection("compose:lazy:cache_window:keepAroundItems");
        try {
            if (cacheWindowLogic.hasValidBounds() && !list.isEmpty()) {
                int index = ((LazyListMeasuredItem) CollectionsKt.first((List<? extends Object>) list)).getIndex();
                int index2 = ((LazyListMeasuredItem) CollectionsKt.last((List<? extends Object>) list)).getIndex();
                for (int prefetchWindowStartLine$foundation = cacheWindowLogic.getPrefetchWindowStartLine$foundation(); prefetchWindowStartLine$foundation < index; prefetchWindowStartLine$foundation++) {
                    lazyListMeasuredItemProvider.keepAround(prefetchWindowStartLine$foundation);
                }
                int i = index2 + 1;
                int prefetchWindowEndLine$foundation = cacheWindowLogic.getPrefetchWindowEndLine$foundation();
                if (i <= prefetchWindowEndLine$foundation) {
                    while (true) {
                        lazyListMeasuredItemProvider.keepAround(i);
                        if (i == prefetchWindowEndLine$foundation) {
                            break;
                        }
                        i++;
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }
}
