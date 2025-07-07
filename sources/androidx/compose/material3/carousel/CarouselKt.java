package androidx.compose.material3.carousel;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
/* compiled from: Carousel.kt */
@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a»\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000526\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\f\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u001621\u0010\u0017\u001a-\u0012\u0004\u0012\u00020\u0018\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0091\u0001\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\f\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\u00142\b\b\u0002\u0010\u000e\u001a\u00020\u000f21\u0010\u0017\u001a-\u0012\u0004\u0012\u00020\u0018\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a}\u0010$\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00142\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\f\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000e\u001a\u00020\u000f21\u0010\u0017\u001a-\u0012\u0004\u0012\u00020\u0018\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a\u0018\u0010(\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*H\u0000\u001a\u0018\u0010+\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*H\u0001\u001a \u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\bH\u0002\u001a\u0019\u00101\u001a\u00020\b*\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u00102\u001a\u0019\u00103\u001a\u00020\b*\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u00102\u001a:\u00104\u001a\u00020\u0013*\u00020\u00132\u0006\u00105\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006;"}, d2 = {"Carousel", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/material3/carousel/CarouselState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "keylineList", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "availableSpace", "itemSpacing", "Landroidx/compose/material3/carousel/KeylineList;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "maxNonFocalVisibleItemCount", "", "modifier", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/Dp;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/material3/carousel/CarouselItemScope;", "itemIndex", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Carousel-V-95POc", "(Landroidx/compose/material3/carousel/CarouselState;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;ILandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "HorizontalMultiBrowseCarousel", "preferredItemWidth", "minSmallItemWidth", "maxSmallItemWidth", "HorizontalMultiBrowseCarousel-zCIJ0Nk", "(Landroidx/compose/material3/carousel/CarouselState;FLandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;FFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "HorizontalUncontainedCarousel", "itemWidth", "HorizontalUncontainedCarousel-9QcgTRs", "(Landroidx/compose/material3/carousel/CarouselState;FLandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "calculateCurrentScrollOffset", "strategy", "Landroidx/compose/material3/carousel/Strategy;", "calculateMaxScrollOffset", "getProgress", TtmlNode.ANNOTATION_POSITION_BEFORE, "Landroidx/compose/material3/carousel/Keyline;", TtmlNode.ANNOTATION_POSITION_AFTER, "unadjustedOffset", "calculateAfterContentPadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/runtime/Composer;I)F", "calculateBeforeContentPadding", "carouselItem", FirebaseAnalytics.Param.INDEX, "Lkotlin/Function0;", "carouselItemInfo", "Landroidx/compose/material3/carousel/CarouselItemInfoImpl;", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CarouselKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:160:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ff  */
    /* renamed from: HorizontalMultiBrowseCarousel-zCIJ0Nk  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2688HorizontalMultiBrowseCarouselzCIJ0Nk(final CarouselState carouselState, final float f, Modifier modifier, float f2, TargetedFlingBehavior targetedFlingBehavior, float f3, float f4, PaddingValues paddingValues, final Function4<? super CarouselItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        int i3;
        float f5;
        Object obj;
        int i4;
        float f6;
        Object obj2;
        int i5;
        float f7;
        int i6;
        float f8;
        int i7;
        Object obj3;
        int i8;
        Composer composer2;
        int i9;
        CarouselState carouselState2;
        PaddingValues m731PaddingValues0680j_4;
        TargetedFlingBehavior targetedFlingBehavior2;
        int i10;
        Modifier modifier2;
        float f9;
        boolean changed;
        Object rememberedValue;
        Composer composer3;
        final float f10;
        final PaddingValues paddingValues2;
        ScopeUpdateScope endRestartGroup;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(-1825706865);
        ComposerKt.sourceInformation(startRestartGroup, "C(HorizontalMultiBrowseCarousel)P(8,7:c#ui.unit.Dp,6,3:c#ui.unit.Dp,2,5:c#ui.unit.Dp,4:c#ui.unit.Dp,1)106@5374L41,112@5703L7,116@5816L554,113@5715L1048:Carousel.kt#dcf9yb");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(carouselState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            f5 = f;
        } else {
            f5 = f;
            if ((i & 48) == 0) {
                i3 |= startRestartGroup.changed(f5) ? 32 : 16;
            }
        }
        int i12 = i2 & 4;
        if (i12 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                f6 = f2;
                i3 |= startRestartGroup.changed(f6) ? 2048 : 1024;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        obj2 = targetedFlingBehavior;
                        if (startRestartGroup.changed(obj2)) {
                            i11 = 16384;
                            i3 |= i11;
                        }
                    } else {
                        obj2 = targetedFlingBehavior;
                    }
                    i11 = 8192;
                    i3 |= i11;
                } else {
                    obj2 = targetedFlingBehavior;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    f7 = f3;
                    i3 |= startRestartGroup.changed(f7) ? 131072 : 65536;
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                        f8 = f4;
                    } else {
                        f8 = f4;
                        if ((i & 1572864) == 0) {
                            i3 |= startRestartGroup.changed(f8) ? 1048576 : 524288;
                        }
                    }
                    i7 = i2 & 128;
                    if (i7 == 0) {
                        i3 |= 12582912;
                        obj3 = paddingValues;
                    } else {
                        obj3 = paddingValues;
                        if ((i & 12582912) == 0) {
                            i3 |= startRestartGroup.changed(obj3) ? 8388608 : 4194304;
                        }
                    }
                    i8 = i3;
                    if ((i2 & 256) == 0) {
                        i8 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i8 |= startRestartGroup.changedInstance(function4) ? 67108864 : 33554432;
                        if ((i8 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i12 != 0 ? Modifier.Companion : obj;
                                float m6684constructorimpl = i4 != 0 ? Dp.m6684constructorimpl(0) : f6;
                                if ((i2 & 16) != 0) {
                                    composer2 = startRestartGroup;
                                    i9 = 0;
                                    carouselState2 = carouselState;
                                    i8 &= -57345;
                                    obj2 = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composer2, (i8 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 2);
                                } else {
                                    composer2 = startRestartGroup;
                                    i9 = 0;
                                    carouselState2 = carouselState;
                                }
                                if (i5 != 0) {
                                    f7 = CarouselDefaults.INSTANCE.m2685getMinSmallItemSizeD9Ej5fM$material3_release();
                                }
                                if (i6 != 0) {
                                    f8 = CarouselDefaults.INSTANCE.m2684getMaxSmallItemSizeD9Ej5fM$material3_release();
                                }
                                m731PaddingValues0680j_4 = i7 != 0 ? PaddingKt.m731PaddingValues0680j_4(Dp.m6684constructorimpl(i9)) : obj3;
                                targetedFlingBehavior2 = obj2;
                                i10 = i8;
                                modifier2 = companion;
                                f9 = m6684constructorimpl;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i8 &= -57345;
                                }
                                m731PaddingValues0680j_4 = obj3;
                                targetedFlingBehavior2 = obj2;
                                i10 = i8;
                                f9 = f6;
                                modifier2 = obj;
                                composer2 = startRestartGroup;
                                carouselState2 = carouselState;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1825706865, i10, -1, "androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel (Carousel.kt:111)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume = composer2.consume(CompositionLocalsKt.getLocalDensity());
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            final Density density = (Density) consume;
                            Orientation orientation = Orientation.Horizontal;
                            ComposerKt.sourceInformationMarkerStart(composer2, 1995157598, "CC(remember):Carousel.kt#9igjgp");
                            PaddingValues paddingValues3 = m731PaddingValues0680j_4;
                            changed = ((i10 & 112) == 32) | composer2.changed(density) | composer2.changedInstance(carouselState2) | ((i10 & 458752) == 131072) | ((3670016 & i10) == 1048576);
                            rememberedValue = composer2.rememberedValue();
                            if (!changed || rememberedValue == Composer.Companion.getEmpty()) {
                                final CarouselState carouselState3 = carouselState2;
                                final float f11 = f5;
                                final float f12 = f8;
                                final float f13 = f7;
                                rememberedValue = (Function2) new Function2<Float, Float, KeylineList>() { // from class: androidx.compose.material3.carousel.CarouselKt$HorizontalMultiBrowseCarousel$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ KeylineList invoke(Float f14, Float f15) {
                                        return invoke(f14.floatValue(), f15.floatValue());
                                    }

                                    public final KeylineList invoke(float f14, float f15) {
                                        Density density2 = Density.this;
                                        return KeylinesKt.multiBrowseKeylineList(density2, f14, density2.mo389toPx0680j_4(f11), f15, carouselState3.getItemCountState().getValue().invoke().intValue(), density2.mo389toPx0680j_4(f13), density2.mo389toPx0680j_4(f12));
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            int i13 = i10 << 9;
                            Composer composer4 = composer2;
                            m2687CarouselV95POc(carouselState, orientation, (Function2) rememberedValue, paddingValues3, 2, modifier2, f9, targetedFlingBehavior2, function4, composer4, (i10 & 14) | 24624 | ((i10 >> 12) & 7168) | (i13 & 458752) | (3670016 & i13) | (i13 & 29360128) | (234881024 & i10), 0);
                            composer3 = composer4;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            f10 = f9;
                            paddingValues2 = paddingValues3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            f10 = f6;
                            paddingValues2 = obj3;
                            targetedFlingBehavior2 = obj2;
                            modifier2 = obj;
                            composer3 = startRestartGroup;
                        }
                        final float f14 = f7;
                        endRestartGroup = composer3.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            final TargetedFlingBehavior targetedFlingBehavior3 = targetedFlingBehavior2;
                            final float f15 = f8;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.carousel.CarouselKt$HorizontalMultiBrowseCarousel$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                    invoke(composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer5, int i14) {
                                    CarouselKt.m2688HorizontalMultiBrowseCarouselzCIJ0Nk(CarouselState.this, f, modifier3, f10, targetedFlingBehavior3, f14, f15, paddingValues2, function4, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i8 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    targetedFlingBehavior2 = obj2;
                    i10 = i8;
                    modifier2 = companion;
                    f9 = m6684constructorimpl;
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume2 = composer2.consume(CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    final Density density2 = (Density) consume2;
                    Orientation orientation2 = Orientation.Horizontal;
                    ComposerKt.sourceInformationMarkerStart(composer2, 1995157598, "CC(remember):Carousel.kt#9igjgp");
                    PaddingValues paddingValues32 = m731PaddingValues0680j_4;
                    changed = ((i10 & 112) == 32) | composer2.changed(density2) | composer2.changedInstance(carouselState2) | ((i10 & 458752) == 131072) | ((3670016 & i10) == 1048576);
                    rememberedValue = composer2.rememberedValue();
                    if (!changed) {
                    }
                    final CarouselState carouselState32 = carouselState2;
                    final float f112 = f5;
                    final float f122 = f8;
                    final float f132 = f7;
                    rememberedValue = (Function2) new Function2<Float, Float, KeylineList>() { // from class: androidx.compose.material3.carousel.CarouselKt$HorizontalMultiBrowseCarousel$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ KeylineList invoke(Float f142, Float f152) {
                            return invoke(f142.floatValue(), f152.floatValue());
                        }

                        public final KeylineList invoke(float f142, float f152) {
                            Density density22 = Density.this;
                            return KeylinesKt.multiBrowseKeylineList(density22, f142, density22.mo389toPx0680j_4(f112), f152, carouselState32.getItemCountState().getValue().invoke().intValue(), density22.mo389toPx0680j_4(f132), density22.mo389toPx0680j_4(f122));
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    int i132 = i10 << 9;
                    Composer composer42 = composer2;
                    m2687CarouselV95POc(carouselState, orientation2, (Function2) rememberedValue, paddingValues32, 2, modifier2, f9, targetedFlingBehavior2, function4, composer42, (i10 & 14) | 24624 | ((i10 >> 12) & 7168) | (i132 & 458752) | (3670016 & i132) | (i132 & 29360128) | (234881024 & i10), 0);
                    composer3 = composer42;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f10 = f9;
                    paddingValues2 = paddingValues32;
                    final float f142 = f7;
                    endRestartGroup = composer3.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                f7 = f3;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                i7 = i2 & 128;
                if (i7 == 0) {
                }
                i8 = i3;
                if ((i2 & 256) == 0) {
                }
                if ((i8 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i12 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                targetedFlingBehavior2 = obj2;
                i10 = i8;
                modifier2 = companion;
                f9 = m6684constructorimpl;
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume22 = composer2.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(composer2);
                final Density density22 = (Density) consume22;
                Orientation orientation22 = Orientation.Horizontal;
                ComposerKt.sourceInformationMarkerStart(composer2, 1995157598, "CC(remember):Carousel.kt#9igjgp");
                PaddingValues paddingValues322 = m731PaddingValues0680j_4;
                changed = ((i10 & 112) == 32) | composer2.changed(density22) | composer2.changedInstance(carouselState2) | ((i10 & 458752) == 131072) | ((3670016 & i10) == 1048576);
                rememberedValue = composer2.rememberedValue();
                if (!changed) {
                }
                final CarouselState carouselState322 = carouselState2;
                final float f1122 = f5;
                final float f1222 = f8;
                final float f1322 = f7;
                rememberedValue = (Function2) new Function2<Float, Float, KeylineList>() { // from class: androidx.compose.material3.carousel.CarouselKt$HorizontalMultiBrowseCarousel$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ KeylineList invoke(Float f1422, Float f152) {
                        return invoke(f1422.floatValue(), f152.floatValue());
                    }

                    public final KeylineList invoke(float f1422, float f152) {
                        Density density222 = Density.this;
                        return KeylinesKt.multiBrowseKeylineList(density222, f1422, density222.mo389toPx0680j_4(f1122), f152, carouselState322.getItemCountState().getValue().invoke().intValue(), density222.mo389toPx0680j_4(f1322), density222.mo389toPx0680j_4(f1222));
                    }
                };
                composer2.updateRememberedValue(rememberedValue);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                int i1322 = i10 << 9;
                Composer composer422 = composer2;
                m2687CarouselV95POc(carouselState, orientation22, (Function2) rememberedValue, paddingValues322, 2, modifier2, f9, targetedFlingBehavior2, function4, composer422, (i10 & 14) | 24624 | ((i10 >> 12) & 7168) | (i1322 & 458752) | (3670016 & i1322) | (i1322 & 29360128) | (234881024 & i10), 0);
                composer3 = composer422;
                if (ComposerKt.isTraceInProgress()) {
                }
                f10 = f9;
                paddingValues2 = paddingValues322;
                final float f1422 = f7;
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            f6 = f2;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            f7 = f3;
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            i7 = i2 & 128;
            if (i7 == 0) {
            }
            i8 = i3;
            if ((i2 & 256) == 0) {
            }
            if ((i8 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i12 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            targetedFlingBehavior2 = obj2;
            i10 = i8;
            modifier2 = companion;
            f9 = m6684constructorimpl;
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume222 = composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer2);
            final Density density222 = (Density) consume222;
            Orientation orientation222 = Orientation.Horizontal;
            ComposerKt.sourceInformationMarkerStart(composer2, 1995157598, "CC(remember):Carousel.kt#9igjgp");
            PaddingValues paddingValues3222 = m731PaddingValues0680j_4;
            changed = ((i10 & 112) == 32) | composer2.changed(density222) | composer2.changedInstance(carouselState2) | ((i10 & 458752) == 131072) | ((3670016 & i10) == 1048576);
            rememberedValue = composer2.rememberedValue();
            if (!changed) {
            }
            final CarouselState carouselState3222 = carouselState2;
            final float f11222 = f5;
            final float f12222 = f8;
            final float f13222 = f7;
            rememberedValue = (Function2) new Function2<Float, Float, KeylineList>() { // from class: androidx.compose.material3.carousel.CarouselKt$HorizontalMultiBrowseCarousel$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ KeylineList invoke(Float f14222, Float f152) {
                    return invoke(f14222.floatValue(), f152.floatValue());
                }

                public final KeylineList invoke(float f14222, float f152) {
                    Density density2222 = Density.this;
                    return KeylinesKt.multiBrowseKeylineList(density2222, f14222, density2222.mo389toPx0680j_4(f11222), f152, carouselState3222.getItemCountState().getValue().invoke().intValue(), density2222.mo389toPx0680j_4(f13222), density2222.mo389toPx0680j_4(f12222));
                }
            };
            composer2.updateRememberedValue(rememberedValue);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            int i13222 = i10 << 9;
            Composer composer4222 = composer2;
            m2687CarouselV95POc(carouselState, orientation222, (Function2) rememberedValue, paddingValues3222, 2, modifier2, f9, targetedFlingBehavior2, function4, composer4222, (i10 & 14) | 24624 | ((i10 >> 12) & 7168) | (i13222 & 458752) | (3670016 & i13222) | (i13222 & 29360128) | (234881024 & i10), 0);
            composer3 = composer4222;
            if (ComposerKt.isTraceInProgress()) {
            }
            f10 = f9;
            paddingValues2 = paddingValues3222;
            final float f14222 = f7;
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        f6 = f2;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        f7 = f3;
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        i7 = i2 & 128;
        if (i7 == 0) {
        }
        i8 = i3;
        if ((i2 & 256) == 0) {
        }
        if ((i8 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i12 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        targetedFlingBehavior2 = obj2;
        i10 = i8;
        modifier2 = companion;
        f9 = m6684constructorimpl;
        composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2222 = composer2.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer2);
        final Density density2222 = (Density) consume2222;
        Orientation orientation2222 = Orientation.Horizontal;
        ComposerKt.sourceInformationMarkerStart(composer2, 1995157598, "CC(remember):Carousel.kt#9igjgp");
        PaddingValues paddingValues32222 = m731PaddingValues0680j_4;
        changed = ((i10 & 112) == 32) | composer2.changed(density2222) | composer2.changedInstance(carouselState2) | ((i10 & 458752) == 131072) | ((3670016 & i10) == 1048576);
        rememberedValue = composer2.rememberedValue();
        if (!changed) {
        }
        final CarouselState carouselState32222 = carouselState2;
        final float f112222 = f5;
        final float f122222 = f8;
        final float f132222 = f7;
        rememberedValue = (Function2) new Function2<Float, Float, KeylineList>() { // from class: androidx.compose.material3.carousel.CarouselKt$HorizontalMultiBrowseCarousel$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ KeylineList invoke(Float f142222, Float f152) {
                return invoke(f142222.floatValue(), f152.floatValue());
            }

            public final KeylineList invoke(float f142222, float f152) {
                Density density22222 = Density.this;
                return KeylinesKt.multiBrowseKeylineList(density22222, f142222, density22222.mo389toPx0680j_4(f112222), f152, carouselState32222.getItemCountState().getValue().invoke().intValue(), density22222.mo389toPx0680j_4(f132222), density22222.mo389toPx0680j_4(f122222));
            }
        };
        composer2.updateRememberedValue(rememberedValue);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        int i132222 = i10 << 9;
        Composer composer42222 = composer2;
        m2687CarouselV95POc(carouselState, orientation2222, (Function2) rememberedValue, paddingValues32222, 2, modifier2, f9, targetedFlingBehavior2, function4, composer42222, (i10 & 14) | 24624 | ((i10 >> 12) & 7168) | (i132222 & 458752) | (3670016 & i132222) | (i132222 & 29360128) | (234881024 & i10), 0);
        composer3 = composer42222;
        if (ComposerKt.isTraceInProgress()) {
        }
        f10 = f9;
        paddingValues2 = paddingValues32222;
        final float f142222 = f7;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0116  */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* renamed from: HorizontalUncontainedCarousel-9QcgTRs  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2689HorizontalUncontainedCarousel9QcgTRs(final CarouselState carouselState, final float f, Modifier modifier, float f2, TargetedFlingBehavior targetedFlingBehavior, PaddingValues paddingValues, final Function4<? super CarouselItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        CarouselState carouselState2;
        int i3;
        Modifier.Companion companion;
        int i4;
        float f3;
        TargetedFlingBehavior targetedFlingBehavior2;
        int i5;
        Object obj;
        Object obj2;
        PaddingValues m731PaddingValues0680j_4;
        TargetedFlingBehavior targetedFlingBehavior3;
        boolean z;
        Object rememberedValue;
        Composer composer2;
        final PaddingValues paddingValues2;
        final Modifier modifier2;
        final float f4;
        final TargetedFlingBehavior targetedFlingBehavior4;
        ScopeUpdateScope endRestartGroup;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(529322840);
        ComposerKt.sourceInformation(startRestartGroup, "C(HorizontalUncontainedCarousel)P(6,4:c#ui.unit.Dp,5,3:c#ui.unit.Dp,2,1)175@8483L21,179@8666L7,183@8779L337,180@8678L818:Carousel.kt#dcf9yb");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            carouselState2 = carouselState;
        } else {
            carouselState2 = carouselState;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(carouselState2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(f) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                f3 = f2;
                i3 |= startRestartGroup.changed(f3) ? 2048 : 1024;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        targetedFlingBehavior2 = targetedFlingBehavior;
                        if (startRestartGroup.changed(targetedFlingBehavior2)) {
                            i6 = 16384;
                            i3 |= i6;
                        }
                    } else {
                        targetedFlingBehavior2 = targetedFlingBehavior;
                    }
                    i6 = 8192;
                    i3 |= i6;
                } else {
                    targetedFlingBehavior2 = targetedFlingBehavior;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    obj = paddingValues;
                    i3 |= startRestartGroup.changed(obj) ? 131072 : 65536;
                    if ((i2 & 64) == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        obj2 = function4;
                        i3 |= startRestartGroup.changedInstance(obj2) ? 1048576 : 524288;
                        if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i7 != 0) {
                                    companion = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    f3 = Dp.m6684constructorimpl(0);
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    targetedFlingBehavior2 = CarouselDefaults.INSTANCE.noSnapFlingBehavior(startRestartGroup, 6);
                                }
                                if (i5 != 0) {
                                    m731PaddingValues0680j_4 = PaddingKt.m731PaddingValues0680j_4(Dp.m6684constructorimpl(0));
                                    targetedFlingBehavior3 = targetedFlingBehavior2;
                                    boolean z2 = false;
                                    float f5 = f3;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(529322840, i3, -1, "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:178)");
                                    }
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    final Density density = (Density) consume;
                                    Orientation orientation = Orientation.Horizontal;
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1883505148, "CC(remember):Carousel.kt#9igjgp");
                                    boolean changed = startRestartGroup.changed(density);
                                    if ((i3 & 112) == 32) {
                                        z2 = true;
                                    }
                                    z = z2 | changed;
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    if (!z || rememberedValue == Composer.Companion.getEmpty()) {
                                        rememberedValue = (Function2) new Function2<Float, Float, KeylineList>() { // from class: androidx.compose.material3.carousel.CarouselKt$HorizontalUncontainedCarousel$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ KeylineList invoke(Float f6, Float f7) {
                                                return invoke(f6.floatValue(), f7.floatValue());
                                            }

                                            public final KeylineList invoke(float f6, float f7) {
                                                Density density2 = Density.this;
                                                return KeylinesKt.uncontainedKeylineList(density2, f6, density2.mo389toPx0680j_4(f), f7);
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    int i8 = i3 << 9;
                                    composer2 = startRestartGroup;
                                    Function4<? super CarouselItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function42 = obj2;
                                    Modifier modifier3 = companion;
                                    m2687CarouselV95POc(carouselState2, orientation, rememberedValue, m731PaddingValues0680j_4, 0, modifier3, f5, targetedFlingBehavior3, function42, composer2, (i3 & 14) | 24624 | ((i3 >> 6) & 7168) | (458752 & i8) | (3670016 & i8) | (i8 & 29360128) | ((i3 << 6) & 234881024), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    paddingValues2 = m731PaddingValues0680j_4;
                                    modifier2 = modifier3;
                                    f4 = f5;
                                    targetedFlingBehavior4 = targetedFlingBehavior3;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                            }
                            targetedFlingBehavior3 = targetedFlingBehavior2;
                            m731PaddingValues0680j_4 = obj;
                            boolean z22 = false;
                            float f52 = f3;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            final Density density2 = (Density) consume2;
                            Orientation orientation2 = Orientation.Horizontal;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1883505148, "CC(remember):Carousel.kt#9igjgp");
                            boolean changed2 = startRestartGroup.changed(density2);
                            if ((i3 & 112) == 32) {
                            }
                            z = z22 | changed2;
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!z) {
                            }
                            rememberedValue = (Function2) new Function2<Float, Float, KeylineList>() { // from class: androidx.compose.material3.carousel.CarouselKt$HorizontalUncontainedCarousel$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ KeylineList invoke(Float f6, Float f7) {
                                    return invoke(f6.floatValue(), f7.floatValue());
                                }

                                public final KeylineList invoke(float f6, float f7) {
                                    Density density22 = Density.this;
                                    return KeylinesKt.uncontainedKeylineList(density22, f6, density22.mo389toPx0680j_4(f), f7);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i82 = i3 << 9;
                            composer2 = startRestartGroup;
                            Function4<? super CarouselItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function422 = obj2;
                            Modifier modifier32 = companion;
                            m2687CarouselV95POc(carouselState2, orientation2, rememberedValue, m731PaddingValues0680j_4, 0, modifier32, f52, targetedFlingBehavior3, function422, composer2, (i3 & 14) | 24624 | ((i3 >> 6) & 7168) | (458752 & i82) | (3670016 & i82) | (i82 & 29360128) | ((i3 << 6) & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            paddingValues2 = m731PaddingValues0680j_4;
                            modifier2 = modifier32;
                            f4 = f52;
                            targetedFlingBehavior4 = targetedFlingBehavior3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier2 = companion;
                            f4 = f3;
                            targetedFlingBehavior4 = targetedFlingBehavior2;
                            paddingValues2 = obj;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.carousel.CarouselKt$HorizontalUncontainedCarousel$2
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
                                    CarouselKt.m2689HorizontalUncontainedCarousel9QcgTRs(CarouselState.this, f, modifier2, f4, targetedFlingBehavior4, paddingValues2, function4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    obj2 = function4;
                    if ((599187 & i3) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    targetedFlingBehavior3 = targetedFlingBehavior2;
                    m731PaddingValues0680j_4 = obj;
                    boolean z222 = false;
                    float f522 = f3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume22 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final Density density22 = (Density) consume22;
                    Orientation orientation22 = Orientation.Horizontal;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1883505148, "CC(remember):Carousel.kt#9igjgp");
                    boolean changed22 = startRestartGroup.changed(density22);
                    if ((i3 & 112) == 32) {
                    }
                    z = z222 | changed22;
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z) {
                    }
                    rememberedValue = (Function2) new Function2<Float, Float, KeylineList>() { // from class: androidx.compose.material3.carousel.CarouselKt$HorizontalUncontainedCarousel$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ KeylineList invoke(Float f6, Float f7) {
                            return invoke(f6.floatValue(), f7.floatValue());
                        }

                        public final KeylineList invoke(float f6, float f7) {
                            Density density222 = Density.this;
                            return KeylinesKt.uncontainedKeylineList(density222, f6, density222.mo389toPx0680j_4(f), f7);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    int i822 = i3 << 9;
                    composer2 = startRestartGroup;
                    Function4<? super CarouselItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4222 = obj2;
                    Modifier modifier322 = companion;
                    m2687CarouselV95POc(carouselState2, orientation22, rememberedValue, m731PaddingValues0680j_4, 0, modifier322, f522, targetedFlingBehavior3, function4222, composer2, (i3 & 14) | 24624 | ((i3 >> 6) & 7168) | (458752 & i822) | (3670016 & i822) | (i822 & 29360128) | ((i3 << 6) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    paddingValues2 = m731PaddingValues0680j_4;
                    modifier2 = modifier322;
                    f4 = f522;
                    targetedFlingBehavior4 = targetedFlingBehavior3;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj = paddingValues;
                if ((i2 & 64) == 0) {
                }
                obj2 = function4;
                if ((599187 & i3) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i7 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if (i5 != 0) {
                }
                targetedFlingBehavior3 = targetedFlingBehavior2;
                m731PaddingValues0680j_4 = obj;
                boolean z2222 = false;
                float f5222 = f3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume222 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final Density density222 = (Density) consume222;
                Orientation orientation222 = Orientation.Horizontal;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1883505148, "CC(remember):Carousel.kt#9igjgp");
                boolean changed222 = startRestartGroup.changed(density222);
                if ((i3 & 112) == 32) {
                }
                z = z2222 | changed222;
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z) {
                }
                rememberedValue = (Function2) new Function2<Float, Float, KeylineList>() { // from class: androidx.compose.material3.carousel.CarouselKt$HorizontalUncontainedCarousel$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ KeylineList invoke(Float f6, Float f7) {
                        return invoke(f6.floatValue(), f7.floatValue());
                    }

                    public final KeylineList invoke(float f6, float f7) {
                        Density density2222 = Density.this;
                        return KeylinesKt.uncontainedKeylineList(density2222, f6, density2222.mo389toPx0680j_4(f), f7);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                int i8222 = i3 << 9;
                composer2 = startRestartGroup;
                Function4<? super CarouselItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function42222 = obj2;
                Modifier modifier3222 = companion;
                m2687CarouselV95POc(carouselState2, orientation222, rememberedValue, m731PaddingValues0680j_4, 0, modifier3222, f5222, targetedFlingBehavior3, function42222, composer2, (i3 & 14) | 24624 | ((i3 >> 6) & 7168) | (458752 & i8222) | (3670016 & i8222) | (i8222 & 29360128) | ((i3 << 6) & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                paddingValues2 = m731PaddingValues0680j_4;
                modifier2 = modifier3222;
                f4 = f5222;
                targetedFlingBehavior4 = targetedFlingBehavior3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            f3 = f2;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            obj = paddingValues;
            if ((i2 & 64) == 0) {
            }
            obj2 = function4;
            if ((599187 & i3) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i7 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i5 != 0) {
            }
            targetedFlingBehavior3 = targetedFlingBehavior2;
            m731PaddingValues0680j_4 = obj;
            boolean z22222 = false;
            float f52222 = f3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2222 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Density density2222 = (Density) consume2222;
            Orientation orientation2222 = Orientation.Horizontal;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1883505148, "CC(remember):Carousel.kt#9igjgp");
            boolean changed2222 = startRestartGroup.changed(density2222);
            if ((i3 & 112) == 32) {
            }
            z = z22222 | changed2222;
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z) {
            }
            rememberedValue = (Function2) new Function2<Float, Float, KeylineList>() { // from class: androidx.compose.material3.carousel.CarouselKt$HorizontalUncontainedCarousel$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ KeylineList invoke(Float f6, Float f7) {
                    return invoke(f6.floatValue(), f7.floatValue());
                }

                public final KeylineList invoke(float f6, float f7) {
                    Density density22222 = Density.this;
                    return KeylinesKt.uncontainedKeylineList(density22222, f6, density22222.mo389toPx0680j_4(f), f7);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int i82222 = i3 << 9;
            composer2 = startRestartGroup;
            Function4<? super CarouselItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function422222 = obj2;
            Modifier modifier32222 = companion;
            m2687CarouselV95POc(carouselState2, orientation2222, rememberedValue, m731PaddingValues0680j_4, 0, modifier32222, f52222, targetedFlingBehavior3, function422222, composer2, (i3 & 14) | 24624 | ((i3 >> 6) & 7168) | (458752 & i82222) | (3670016 & i82222) | (i82222 & 29360128) | ((i3 << 6) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            paddingValues2 = m731PaddingValues0680j_4;
            modifier2 = modifier32222;
            f4 = f52222;
            targetedFlingBehavior4 = targetedFlingBehavior3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        f3 = f2;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        obj = paddingValues;
        if ((i2 & 64) == 0) {
        }
        obj2 = function4;
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i7 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i5 != 0) {
        }
        targetedFlingBehavior3 = targetedFlingBehavior2;
        m731PaddingValues0680j_4 = obj;
        boolean z222222 = false;
        float f522222 = f3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume22222 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final Density density22222 = (Density) consume22222;
        Orientation orientation22222 = Orientation.Horizontal;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1883505148, "CC(remember):Carousel.kt#9igjgp");
        boolean changed22222 = startRestartGroup.changed(density22222);
        if ((i3 & 112) == 32) {
        }
        z = z222222 | changed22222;
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z) {
        }
        rememberedValue = (Function2) new Function2<Float, Float, KeylineList>() { // from class: androidx.compose.material3.carousel.CarouselKt$HorizontalUncontainedCarousel$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ KeylineList invoke(Float f6, Float f7) {
                return invoke(f6.floatValue(), f7.floatValue());
            }

            public final KeylineList invoke(float f6, float f7) {
                Density density222222 = Density.this;
                return KeylinesKt.uncontainedKeylineList(density222222, f6, density222222.mo389toPx0680j_4(f), f7);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        int i822222 = i3 << 9;
        composer2 = startRestartGroup;
        Function4<? super CarouselItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4222222 = obj2;
        Modifier modifier322222 = companion;
        m2687CarouselV95POc(carouselState2, orientation22222, rememberedValue, m731PaddingValues0680j_4, 0, modifier322222, f522222, targetedFlingBehavior3, function4222222, composer2, (i3 & 14) | 24624 | ((i3 >> 6) & 7168) | (458752 & i822222) | (3670016 & i822222) | (i822222 & 29360128) | ((i3 << 6) & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        paddingValues2 = m731PaddingValues0680j_4;
        modifier2 = modifier322222;
        f4 = f522222;
        targetedFlingBehavior4 = targetedFlingBehavior3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x010d  */
    /* renamed from: Carousel-V-95POc  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2687CarouselV95POc(CarouselState carouselState, final Orientation orientation, final Function2<? super Float, ? super Float, KeylineList> function2, final PaddingValues paddingValues, final int i, Modifier modifier, float f, TargetedFlingBehavior targetedFlingBehavior, final Function4<? super CarouselItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        Object obj;
        int i6;
        float f2;
        Object obj2;
        int i7;
        boolean z;
        final CarouselState carouselState2;
        Object obj3;
        float f3;
        Object rememberedValue;
        Modifier modifier2;
        final float f4;
        final TargetedFlingBehavior targetedFlingBehavior2;
        ScopeUpdateScope endRestartGroup;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-2035733443);
        ComposerKt.sourceInformation(startRestartGroup, "C(Carousel)P(8,7,4,1,5,6,3:c#ui.unit.Dp,2)239@11411L41,242@11572L42,243@11660L41,245@11729L118:Carousel.kt#dcf9yb");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(carouselState) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changed(orientation) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i2 & 3072) == 0) {
            i4 |= startRestartGroup.changed(paddingValues) ? 2048 : 1024;
        }
        if ((i3 & 16) != 0) {
            i4 |= 24576;
            i5 = i;
        } else {
            i5 = i;
            if ((i2 & 24576) == 0) {
                i4 |= startRestartGroup.changed(i5) ? 16384 : 8192;
            }
        }
        int i9 = i3 & 32;
        if (i9 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((196608 & i2) == 0) {
            obj = modifier;
            i4 |= startRestartGroup.changed(obj) ? 131072 : 65536;
            i6 = i3 & 64;
            if (i6 == 0) {
                i4 |= 1572864;
            } else if ((1572864 & i2) == 0) {
                f2 = f;
                i4 |= startRestartGroup.changed(f2) ? 1048576 : 524288;
                if ((i2 & 12582912) == 0) {
                    if ((i3 & 128) == 0) {
                        obj2 = targetedFlingBehavior;
                        if (startRestartGroup.changed(obj2)) {
                            i8 = 8388608;
                            i4 |= i8;
                        }
                    } else {
                        obj2 = targetedFlingBehavior;
                    }
                    i8 = 4194304;
                    i4 |= i8;
                } else {
                    obj2 = targetedFlingBehavior;
                }
                if ((i3 & 256) != 0) {
                    i4 |= 100663296;
                } else if ((i2 & 100663296) == 0) {
                    i4 |= startRestartGroup.changedInstance(function4) ? 67108864 : 33554432;
                }
                i7 = i4;
                if ((38347923 & i7) == 38347922 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i9 != 0 ? Modifier.Companion : obj;
                        if (i6 != 0) {
                            f2 = Dp.m6684constructorimpl(0);
                        }
                        if ((i3 & 128) != 0) {
                            z = false;
                            carouselState2 = carouselState;
                            i7 &= -29360129;
                            obj3 = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, startRestartGroup, (i7 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 2);
                        } else {
                            z = false;
                            carouselState2 = carouselState;
                            obj3 = obj2;
                        }
                        obj = companion;
                        f3 = f2;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i3 & 128) != 0) {
                            i7 &= -29360129;
                        }
                        z = false;
                        obj3 = obj2;
                        f3 = f2;
                        carouselState2 = carouselState;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2035733443, i7, -1, "androidx.compose.material3.carousel.Carousel (Carousel.kt:241)");
                    }
                    int i10 = ((i7 >> 9) & 14) | (i7 & 112);
                    float calculateBeforeContentPadding = calculateBeforeContentPadding(paddingValues, orientation, startRestartGroup, i10);
                    float calculateAfterContentPadding = calculateAfterContentPadding(paddingValues, orientation, startRestartGroup, i10);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2025986753, "CC(remember):Carousel.kt#9igjgp");
                    if ((i7 & 896) == 256) {
                        z = true;
                    }
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new CarouselPageSize(function2, calculateBeforeContentPadding, calculateAfterContentPadding);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    final CarouselPageSize carouselPageSize = (CarouselPageSize) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    SnapPosition KeylineSnapPosition = KeylineSnapPositionKt.KeylineSnapPosition(carouselPageSize);
                    if (orientation == Orientation.Horizontal) {
                        startRestartGroup.startReplaceGroup(-1618653092);
                        ComposerKt.sourceInformation(startRestartGroup, "266@12589L1014,252@11960L1643");
                        int i11 = i5;
                        modifier2 = obj;
                        PagerKt.m984HorizontalPageroI3XNZo(carouselState2.getPagerState$material3_release(), modifier2, PaddingKt.m735PaddingValuesa9UjIt4$default(0.0f, paddingValues.mo690calculateTopPaddingD9Ej5fM(), 0.0f, paddingValues.mo687calculateBottomPaddingD9Ej5fM(), 5, null), carouselPageSize, i11, f3, null, obj3, false, false, null, null, KeylineSnapPosition, ComposableLambdaKt.rememberComposableLambda(687111200, true, new Function4<PagerScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.carousel.CarouselKt$Carousel$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Composer composer2, Integer num2) {
                                invoke(pagerScope, num.intValue(), composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(PagerScope pagerScope, int i12, Composer composer2, int i13) {
                                ComposerKt.sourceInformation(composer2, "C267@12634L35,268@12694L63,269@12786L389,286@13376L21,281@13189L404:Carousel.kt#dcf9yb");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(687111200, i13, -1, "androidx.compose.material3.carousel.Carousel.<anonymous> (Carousel.kt:267)");
                                }
                                ComposerKt.sourceInformationMarkerStart(composer2, -685906675, "CC(remember):Carousel.kt#9igjgp");
                                Object rememberedValue2 = composer2.rememberedValue();
                                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                    rememberedValue2 = new CarouselItemInfoImpl();
                                    composer2.updateRememberedValue(rememberedValue2);
                                }
                                final CarouselItemInfoImpl carouselItemInfoImpl = (CarouselItemInfoImpl) rememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerStart(composer2, -685904727, "CC(remember):Carousel.kt#9igjgp");
                                Object rememberedValue3 = composer2.rememberedValue();
                                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                    rememberedValue3 = new CarouselItemScopeImpl(carouselItemInfoImpl);
                                    composer2.updateRememberedValue(rememberedValue3);
                                }
                                CarouselItemScopeImpl carouselItemScopeImpl = (CarouselItemScopeImpl) rememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerStart(composer2, -685901457, "CC(remember):Carousel.kt#9igjgp");
                                Object rememberedValue4 = composer2.rememberedValue();
                                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                    rememberedValue4 = new Shape() { // from class: androidx.compose.material3.carousel.CarouselKt$Carousel$1$clipShape$1$1
                                        @Override // androidx.compose.ui.graphics.Shape
                                        /* renamed from: createOutline-Pq9zytI */
                                        public Outline mo303createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
                                            return new Outline.Rectangle(CarouselItemInfoImpl.this.getMaskRect());
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue4);
                                }
                                CarouselKt$Carousel$1$clipShape$1$1 carouselKt$Carousel$1$clipShape$1$1 = (CarouselKt$Carousel$1$clipShape$1$1) rememberedValue4;
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                Modifier.Companion companion2 = Modifier.Companion;
                                CarouselState carouselState3 = CarouselState.this;
                                ComposerKt.sourceInformationMarkerStart(composer2, -685882945, "CC(remember):Carousel.kt#9igjgp");
                                boolean changed = composer2.changed(carouselPageSize);
                                final CarouselPageSize carouselPageSize2 = carouselPageSize;
                                Object rememberedValue5 = composer2.rememberedValue();
                                if (changed || rememberedValue5 == Composer.Companion.getEmpty()) {
                                    rememberedValue5 = (Function0) new Function0<Strategy>() { // from class: androidx.compose.material3.carousel.CarouselKt$Carousel$1$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Strategy invoke() {
                                            return CarouselPageSize.this.getStrategy();
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue5);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                Modifier carouselItem = CarouselKt.carouselItem(companion2, i12, carouselState3, (Function0) rememberedValue5, carouselItemInfoImpl, carouselKt$Carousel$1$clipShape$1$1);
                                Function4<CarouselItemScope, Integer, Composer, Integer, Unit> function42 = function4;
                                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, carouselItem);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor);
                                } else {
                                    composer2.useNode();
                                }
                                Composer m3520constructorimpl = Updater.m3520constructorimpl(composer2);
                                Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer2, 1112607687, "C291@13566L13:Carousel.kt#dcf9yb");
                                function42.invoke(carouselItemScopeImpl, Integer.valueOf(i12), composer2, Integer.valueOf(i13 & 112));
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54), startRestartGroup, ((i7 >> 12) & 112) | (57344 & i7) | ((i7 >> 3) & 458752) | (29360128 & i7), 3072, 3904);
                        startRestartGroup.endReplaceGroup();
                    } else {
                        modifier2 = obj;
                        if (orientation == Orientation.Vertical) {
                            startRestartGroup.startReplaceGroup(-1616959128);
                            ComposerKt.sourceInformation(startRestartGroup, "300@13962L7,301@14054L7,309@14347L1014,295@13666L1695");
                            PagerState pagerState$material3_release = carouselState2.getPagerState$material3_release();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            float calculateStartPadding = PaddingKt.calculateStartPadding(paddingValues, (LayoutDirection) consume);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            PagerKt.m986VerticalPageroI3XNZo(pagerState$material3_release, modifier2, PaddingKt.m735PaddingValuesa9UjIt4$default(calculateStartPadding, 0.0f, PaddingKt.calculateEndPadding(paddingValues, (LayoutDirection) consume2), 0.0f, 10, null), carouselPageSize, i, f3, null, obj3, false, false, null, null, KeylineSnapPosition, ComposableLambdaKt.rememberComposableLambda(-817308503, true, new Function4<PagerScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.carousel.CarouselKt$Carousel$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Composer composer2, Integer num2) {
                                    invoke(pagerScope, num.intValue(), composer2, num2.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(PagerScope pagerScope, int i12, Composer composer2, int i13) {
                                    ComposerKt.sourceInformation(composer2, "C310@14392L35,311@14452L63,312@14544L389,329@15134L21,324@14947L404:Carousel.kt#dcf9yb");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-817308503, i13, -1, "androidx.compose.material3.carousel.Carousel.<anonymous> (Carousel.kt:310)");
                                    }
                                    ComposerKt.sourceInformationMarkerStart(composer2, -685850419, "CC(remember):Carousel.kt#9igjgp");
                                    Object rememberedValue2 = composer2.rememberedValue();
                                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                        rememberedValue2 = new CarouselItemInfoImpl();
                                        composer2.updateRememberedValue(rememberedValue2);
                                    }
                                    final CarouselItemInfoImpl carouselItemInfoImpl = (CarouselItemInfoImpl) rememberedValue2;
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerStart(composer2, -685848471, "CC(remember):Carousel.kt#9igjgp");
                                    Object rememberedValue3 = composer2.rememberedValue();
                                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                        rememberedValue3 = new CarouselItemScopeImpl(carouselItemInfoImpl);
                                        composer2.updateRememberedValue(rememberedValue3);
                                    }
                                    CarouselItemScopeImpl carouselItemScopeImpl = (CarouselItemScopeImpl) rememberedValue3;
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerStart(composer2, -685845201, "CC(remember):Carousel.kt#9igjgp");
                                    Object rememberedValue4 = composer2.rememberedValue();
                                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                        rememberedValue4 = new Shape() { // from class: androidx.compose.material3.carousel.CarouselKt$Carousel$2$clipShape$1$1
                                            @Override // androidx.compose.ui.graphics.Shape
                                            /* renamed from: createOutline-Pq9zytI */
                                            public Outline mo303createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
                                                return new Outline.Rectangle(CarouselItemInfoImpl.this.getMaskRect());
                                            }
                                        };
                                        composer2.updateRememberedValue(rememberedValue4);
                                    }
                                    CarouselKt$Carousel$2$clipShape$1$1 carouselKt$Carousel$2$clipShape$1$1 = (CarouselKt$Carousel$2$clipShape$1$1) rememberedValue4;
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    Modifier.Companion companion2 = Modifier.Companion;
                                    CarouselState carouselState3 = CarouselState.this;
                                    ComposerKt.sourceInformationMarkerStart(composer2, -685826689, "CC(remember):Carousel.kt#9igjgp");
                                    boolean changed = composer2.changed(carouselPageSize);
                                    final CarouselPageSize carouselPageSize2 = carouselPageSize;
                                    Object rememberedValue5 = composer2.rememberedValue();
                                    if (changed || rememberedValue5 == Composer.Companion.getEmpty()) {
                                        rememberedValue5 = (Function0) new Function0<Strategy>() { // from class: androidx.compose.material3.carousel.CarouselKt$Carousel$2$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Strategy invoke() {
                                                return CarouselPageSize.this.getStrategy();
                                            }
                                        };
                                        composer2.updateRememberedValue(rememberedValue5);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    Modifier carouselItem = CarouselKt.carouselItem(companion2, i12, carouselState3, (Function0) rememberedValue5, carouselItemInfoImpl, carouselKt$Carousel$2$clipShape$1$1);
                                    Function4<CarouselItemScope, Integer, Composer, Integer, Unit> function42 = function4;
                                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, carouselItem);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                    if (!(composer2.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer2.startReusableNode();
                                    if (composer2.getInserting()) {
                                        composer2.createNode(constructor);
                                    } else {
                                        composer2.useNode();
                                    }
                                    Composer m3520constructorimpl = Updater.m3520constructorimpl(composer2);
                                    Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer2, 1114351623, "C334@15324L13:Carousel.kt#dcf9yb");
                                    function42.invoke(carouselItemScopeImpl, Integer.valueOf(i12), composer2, Integer.valueOf(i13 & 112));
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    composer2.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), startRestartGroup, ((i7 >> 12) & 112) | (57344 & i7) | ((i7 >> 3) & 458752) | (29360128 & i7), 3072, 3904);
                            startRestartGroup.endReplaceGroup();
                        } else {
                            startRestartGroup.startReplaceGroup(-1615314857);
                            startRestartGroup.endReplaceGroup();
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj = modifier2;
                    f4 = f3;
                    targetedFlingBehavior2 = obj3;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    carouselState2 = carouselState;
                    targetedFlingBehavior2 = obj2;
                    f4 = f2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier3 = obj;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.carousel.CarouselKt$Carousel$3
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

                        public final void invoke(Composer composer2, int i12) {
                            CarouselKt.m2687CarouselV95POc(CarouselState.this, orientation, function2, paddingValues, i, modifier3, f4, targetedFlingBehavior2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                    return;
                }
                return;
            }
            f2 = f;
            if ((i2 & 12582912) == 0) {
            }
            if ((i3 & 256) != 0) {
            }
            i7 = i4;
            if ((38347923 & i7) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i9 != 0) {
            }
            if (i6 != 0) {
            }
            if ((i3 & 128) != 0) {
            }
            obj = companion;
            f3 = f2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i102 = ((i7 >> 9) & 14) | (i7 & 112);
            float calculateBeforeContentPadding2 = calculateBeforeContentPadding(paddingValues, orientation, startRestartGroup, i102);
            float calculateAfterContentPadding2 = calculateAfterContentPadding(paddingValues, orientation, startRestartGroup, i102);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2025986753, "CC(remember):Carousel.kt#9igjgp");
            if ((i7 & 896) == 256) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z) {
            }
            rememberedValue = new CarouselPageSize(function2, calculateBeforeContentPadding2, calculateAfterContentPadding2);
            startRestartGroup.updateRememberedValue(rememberedValue);
            final CarouselPageSize carouselPageSize2 = (CarouselPageSize) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SnapPosition KeylineSnapPosition2 = KeylineSnapPositionKt.KeylineSnapPosition(carouselPageSize2);
            if (orientation == Orientation.Horizontal) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            obj = modifier2;
            f4 = f3;
            targetedFlingBehavior2 = obj3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i6 = i3 & 64;
        if (i6 == 0) {
        }
        f2 = f;
        if ((i2 & 12582912) == 0) {
        }
        if ((i3 & 256) != 0) {
        }
        i7 = i4;
        if ((38347923 & i7) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i9 != 0) {
        }
        if (i6 != 0) {
        }
        if ((i3 & 128) != 0) {
        }
        obj = companion;
        f3 = f2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i1022 = ((i7 >> 9) & 14) | (i7 & 112);
        float calculateBeforeContentPadding22 = calculateBeforeContentPadding(paddingValues, orientation, startRestartGroup, i1022);
        float calculateAfterContentPadding22 = calculateAfterContentPadding(paddingValues, orientation, startRestartGroup, i1022);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2025986753, "CC(remember):Carousel.kt#9igjgp");
        if ((i7 & 896) == 256) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z) {
        }
        rememberedValue = new CarouselPageSize(function2, calculateBeforeContentPadding22, calculateAfterContentPadding22);
        startRestartGroup.updateRememberedValue(rememberedValue);
        final CarouselPageSize carouselPageSize22 = (CarouselPageSize) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        SnapPosition KeylineSnapPosition22 = KeylineSnapPositionKt.KeylineSnapPosition(carouselPageSize22);
        if (orientation == Orientation.Horizontal) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        obj = modifier2;
        f4 = f3;
        targetedFlingBehavior2 = obj3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final float calculateBeforeContentPadding(PaddingValues paddingValues, Orientation orientation, Composer composer, int i) {
        float calculateStartPadding;
        ComposerKt.sourceInformationMarkerStart(composer, 1896839347, "C(calculateBeforeContentPadding)*349@15698L7:Carousel.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1896839347, i, -1, "androidx.compose.material3.carousel.calculateBeforeContentPadding (Carousel.kt:341)");
        }
        composer.startReplaceGroup(295830617);
        ComposerKt.sourceInformation(composer, "346@15649L7");
        if (orientation == Orientation.Vertical) {
            calculateStartPadding = paddingValues.mo690calculateTopPaddingD9Ej5fM();
        } else {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer);
            calculateStartPadding = PaddingKt.calculateStartPadding(paddingValues, (LayoutDirection) consume);
        }
        composer.endReplaceGroup();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        float mo389toPx0680j_4 = ((Density) consume2).mo389toPx0680j_4(calculateStartPadding);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mo389toPx0680j_4;
    }

    private static final float calculateAfterContentPadding(PaddingValues paddingValues, Orientation orientation, Composer composer, int i) {
        float calculateEndPadding;
        ComposerKt.sourceInformationMarkerStart(composer, 1018496720, "C(calculateAfterContentPadding)*361@16056L7:Carousel.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1018496720, i, -1, "androidx.compose.material3.carousel.calculateAfterContentPadding (Carousel.kt:353)");
        }
        composer.startReplaceGroup(-587616383);
        ComposerKt.sourceInformation(composer, "358@16007L7");
        if (orientation == Orientation.Vertical) {
            calculateEndPadding = paddingValues.mo687calculateBottomPaddingD9Ej5fM();
        } else {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer);
            calculateEndPadding = PaddingKt.calculateEndPadding(paddingValues, (LayoutDirection) consume);
        }
        composer.endReplaceGroup();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        float mo389toPx0680j_4 = ((Density) consume2).mo389toPx0680j_4(calculateEndPadding);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mo389toPx0680j_4;
    }

    public static final Modifier carouselItem(Modifier modifier, final int i, final CarouselState carouselState, final Function0<Strategy> function0, final CarouselItemInfoImpl carouselItemInfoImpl, final Shape shape) {
        return LayoutModifierKt.layout(modifier, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.carousel.CarouselKt$carouselItem$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m2690invoke3p2s80s(measureScope, measurable, constraints.m6643unboximpl());
            }

            /* renamed from: invoke-3p2s80s  reason: not valid java name */
            public final MeasureResult m2690invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                long m6626copyZbe2FdA;
                final Strategy invoke = function0.invoke();
                if (!invoke.isValid()) {
                    return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.carousel.CarouselKt$carouselItem$1.1
                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(Placeable.PlacementScope placementScope) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }
                    }, 4, null);
                }
                final boolean z = carouselState.getPagerState$material3_release().getLayoutInfo().getOrientation() == Orientation.Vertical;
                final boolean z2 = measureScope.getLayoutDirection() == LayoutDirection.Rtl;
                float itemMainAxisSize = invoke.getItemMainAxisSize();
                if (z) {
                    m6626copyZbe2FdA = Constraints.m6626copyZbe2FdA(j, Constraints.m6639getMinWidthimpl(j), Constraints.m6637getMaxWidthimpl(j), MathKt.roundToInt(itemMainAxisSize), MathKt.roundToInt(itemMainAxisSize));
                } else {
                    m6626copyZbe2FdA = Constraints.m6626copyZbe2FdA(j, MathKt.roundToInt(itemMainAxisSize), MathKt.roundToInt(itemMainAxisSize), Constraints.m6638getMinHeightimpl(j), Constraints.m6636getMaxHeightimpl(j));
                }
                final Placeable mo5438measureBRTryo0 = measurable.mo5438measureBRTryo0(m6626copyZbe2FdA);
                int width = mo5438measureBRTryo0.getWidth();
                int height = mo5438measureBRTryo0.getHeight();
                final CarouselState carouselState2 = carouselState;
                final int i2 = i;
                final CarouselItemInfoImpl carouselItemInfoImpl2 = carouselItemInfoImpl;
                final Shape shape2 = shape;
                return MeasureScope.layout$default(measureScope, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.carousel.CarouselKt$carouselItem$1.2
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
                        Placeable placeable = Placeable.this;
                        final CarouselState carouselState3 = carouselState2;
                        final Strategy strategy = invoke;
                        final int i3 = i2;
                        final boolean z3 = z;
                        final CarouselItemInfoImpl carouselItemInfoImpl3 = carouselItemInfoImpl2;
                        final Shape shape3 = shape2;
                        final boolean z4 = z2;
                        Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, 0, 0, 0.0f, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.carousel.CarouselKt.carouselItem.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                                invoke2(graphicsLayerScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:31:0x012f  */
                            /* JADX WARN: Removed duplicated region for block: B:34:0x013e  */
                            /* JADX WARN: Removed duplicated region for block: B:36:0x0142  */
                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                                float progress;
                                float calculateCurrentScrollOffset = CarouselKt.calculateCurrentScrollOffset(CarouselState.this, strategy);
                                float calculateMaxScrollOffset = CarouselKt.calculateMaxScrollOffset(CarouselState.this, strategy);
                                KeylineList keylineListForScrollOffset$material3_release$default = Strategy.getKeylineListForScrollOffset$material3_release$default(strategy, calculateCurrentScrollOffset, calculateMaxScrollOffset, false, 4, null);
                                KeylineList keylineListForScrollOffset$material3_release = strategy.getKeylineListForScrollOffset$material3_release(calculateCurrentScrollOffset, calculateMaxScrollOffset, true);
                                float itemMainAxisSize2 = ((i3 * (strategy.getItemMainAxisSize() + strategy.getItemSpacing())) + (strategy.getItemMainAxisSize() / 2.0f)) - calculateCurrentScrollOffset;
                                Keyline keylineBefore = keylineListForScrollOffset$material3_release$default.getKeylineBefore(itemMainAxisSize2);
                                Keyline keylineAfter = keylineListForScrollOffset$material3_release$default.getKeylineAfter(itemMainAxisSize2);
                                progress = CarouselKt.getProgress(keylineBefore, keylineAfter, itemMainAxisSize2);
                                Keyline lerp = KeylineListKt.lerp(keylineBefore, keylineAfter, progress);
                                boolean areEqual = Intrinsics.areEqual(keylineBefore, keylineAfter);
                                float m3903getHeightimpl = (z3 ? Size.m3903getHeightimpl(graphicsLayerScope.mo4265getSizeNHjbRc()) : strategy.getItemMainAxisSize()) / 2.0f;
                                float itemMainAxisSize3 = (z3 ? strategy.getItemMainAxisSize() : Size.m3903getHeightimpl(graphicsLayerScope.mo4265getSizeNHjbRc())) / 2.0f;
                                float m3906getWidthimpl = (z3 ? Size.m3906getWidthimpl(graphicsLayerScope.mo4265getSizeNHjbRc()) : lerp.getSize()) / 2.0f;
                                float size = (z3 ? lerp.getSize() : Size.m3903getHeightimpl(graphicsLayerScope.mo4265getSizeNHjbRc())) / 2.0f;
                                Rect rect = new Rect(m3903getHeightimpl - m3906getWidthimpl, itemMainAxisSize3 - size, m3903getHeightimpl + m3906getWidthimpl, itemMainAxisSize3 + size);
                                carouselItemInfoImpl3.setSizeState(lerp.getSize());
                                CarouselItemInfoImpl carouselItemInfoImpl4 = carouselItemInfoImpl3;
                                Iterator<Keyline> it = keylineListForScrollOffset$material3_release.iterator();
                                if (!it.hasNext()) {
                                    throw new NoSuchElementException();
                                }
                                Keyline next = it.next();
                                if (!it.hasNext()) {
                                    carouselItemInfoImpl4.setMinSizeState(next.getSize());
                                    carouselItemInfoImpl3.setMaxSizeState(keylineListForScrollOffset$material3_release.getFirstFocal().getSize());
                                    carouselItemInfoImpl3.setMaskRectState(rect);
                                    graphicsLayerScope.setClip(!Intrinsics.areEqual(rect, new Rect(0.0f, 0.0f, Size.m3906getWidthimpl(graphicsLayerScope.mo4265getSizeNHjbRc()), Size.m3903getHeightimpl(graphicsLayerScope.mo4265getSizeNHjbRc()))));
                                    graphicsLayerScope.setShape(shape3);
                                    float offset = lerp.getOffset() - itemMainAxisSize2;
                                    if (areEqual) {
                                        offset += (itemMainAxisSize2 - lerp.getUnadjustedOffset()) / lerp.getSize();
                                    }
                                    if (!z3) {
                                        graphicsLayerScope.setTranslationY(offset);
                                        return;
                                    }
                                    if (z4) {
                                        offset = -offset;
                                    }
                                    graphicsLayerScope.setTranslationX(offset);
                                    return;
                                }
                                float size2 = next.getSize();
                                do {
                                    Keyline next2 = it.next();
                                    float size3 = next2.getSize();
                                    if (Float.compare(size2, size3) > 0) {
                                        next = next2;
                                        size2 = size3;
                                    }
                                } while (it.hasNext());
                                carouselItemInfoImpl4.setMinSizeState(next.getSize());
                                carouselItemInfoImpl3.setMaxSizeState(keylineListForScrollOffset$material3_release.getFirstFocal().getSize());
                                carouselItemInfoImpl3.setMaskRectState(rect);
                                graphicsLayerScope.setClip(!Intrinsics.areEqual(rect, new Rect(0.0f, 0.0f, Size.m3906getWidthimpl(graphicsLayerScope.mo4265getSizeNHjbRc()), Size.m3903getHeightimpl(graphicsLayerScope.mo4265getSizeNHjbRc()))));
                                graphicsLayerScope.setShape(shape3);
                                float offset2 = lerp.getOffset() - itemMainAxisSize2;
                                if (areEqual) {
                                }
                                if (!z3) {
                                }
                            }
                        }, 4, (Object) null);
                    }
                }, 4, null);
            }
        });
    }

    public static final float calculateCurrentScrollOffset(CarouselState carouselState, Strategy strategy) {
        float itemMainAxisSize = strategy.getItemMainAxisSize() + strategy.getItemSpacing();
        return ((carouselState.getPagerState$material3_release().getCurrentPage() * itemMainAxisSize) + (carouselState.getPagerState$material3_release().getCurrentPageOffsetFraction() * itemMainAxisSize)) - KeylineSnapPositionKt.getSnapPositionOffset(strategy, carouselState.getPagerState$material3_release().getCurrentPage(), carouselState.getPagerState$material3_release().getPageCount());
    }

    public static final float calculateMaxScrollOffset(CarouselState carouselState, Strategy strategy) {
        float pageCount = carouselState.getPagerState$material3_release().getPageCount();
        return RangesKt.coerceAtLeast(((strategy.getItemMainAxisSize() * pageCount) + (strategy.getItemSpacing() * (pageCount - 1))) - strategy.getAvailableSpace(), 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float getProgress(Keyline keyline, Keyline keyline2, float f) {
        if (Intrinsics.areEqual(keyline, keyline2)) {
            return 1.0f;
        }
        return (f - keyline.getUnadjustedOffset()) / (keyline2.getUnadjustedOffset() - keyline.getUnadjustedOffset());
    }
}
