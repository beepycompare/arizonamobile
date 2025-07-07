package androidx.constraintlayout.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.compose.MotionLayoutScope;
import androidx.constraintlayout.compose.carousel.CarouselSwipeableKt;
import androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$carouselSwipeable$1;
import androidx.constraintlayout.compose.carousel.CarouselSwipeableState;
import androidx.constraintlayout.compose.carousel.FractionalThreshold;
import androidx.constraintlayout.compose.carousel.SwipeableDefaults;
import androidx.constraintlayout.compose.carousel.ThresholdConfig;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: MotionCarousel.kt */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001af\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00072\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a,\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u0010\u001c\u001aP\u0010\u001d\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001e*\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u001f2(\b\u0004\u0010 \u001a\"\u0012\u0013\u0012\u0011H\u001e¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\nH\u0086\b¢\u0006\u0002\u0010$\u001ao\u0010%\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001e*\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u001f2G\b\u0004\u0010 \u001aA\u0012\u0013\u0012\u0011H\u001e¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u001d\u0012\u001b\u0012\b\u0012\u00060'R\u00020(0\u001a¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00010&¢\u0006\u0002\b\nH\u0086\b¢\u0006\u0002\u0010*¨\u0006+²\u0006\n\u0010,\u001a\u00020-X\u008a\u008e\u0002²\u0006\n\u0010.\u001a\u00020/X\u008a\u008e\u0002²\u0006\n\u00100\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"ItemHolder", "", CmcdData.OBJECT_TYPE_INIT_SEGMENT, "", "slotPrefix", "", "showSlot", "", "function", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ILjava/lang/String;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "MotionCarousel", "motionScene", "Landroidx/constraintlayout/compose/MotionScene;", "initialSlotIndex", "numSlots", "backwardTransition", "forwardTransition", "showSlots", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/MotionCarouselScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/constraintlayout/compose/MotionScene;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberStateOfItemsProvider", "Landroidx/compose/runtime/State;", "Landroidx/constraintlayout/compose/MotionItemsProvider;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", FirebaseAnalytics.Param.ITEMS, ExifInterface.GPS_DIRECTION_TRUE, "", "itemContent", "Lkotlin/ParameterName;", "name", "item", "(Landroidx/constraintlayout/compose/MotionCarouselScope;Ljava/util/List;Lkotlin/jvm/functions/Function3;)V", "itemsWithProperties", "Lkotlin/Function2;", "Landroidx/constraintlayout/compose/MotionLayoutScope$MotionProperties;", "Landroidx/constraintlayout/compose/MotionLayoutScope;", "properties", "(Landroidx/constraintlayout/compose/MotionCarouselScope;Ljava/util/List;Lkotlin/jvm/functions/Function4;)V", "constraintlayout-compose_release", "componentWidth", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/constraintlayout/compose/CarouselState;", "currentIndex"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MotionCarouselKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x04e5  */
    /* JADX WARN: Removed duplicated region for block: B:176:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MotionCarousel(final MotionScene motionScene, final int i, final int i2, String str, String str2, String str3, boolean z, final Function1<? super MotionCarouselScope, Unit> function1, Composer composer, final int i3, final int i4) {
        MotionScene motionScene2;
        int i5;
        int i6;
        Object obj;
        int i7;
        Object obj2;
        int i8;
        Object obj3;
        int i9;
        final boolean z2;
        final int i10;
        Object rememberedValue;
        CarouselSwipeableState rememberCarouselSwipeableState;
        float floatValue;
        Object rememberedValue2;
        Object rememberedValue3;
        final MutableIntState mutableIntState;
        String str4;
        int i11;
        Map mapOf;
        Object rememberedValue4;
        MutableState mutableState;
        float f;
        Object obj4;
        float f2;
        CarouselSwipeableState carouselSwipeableState;
        androidx.compose.runtime.State<MotionItemsProvider> state;
        Modifier m7159carouselSwipeablepPrIpRY;
        Object rememberedValue5;
        Object rememberedValue6;
        Object rememberedValue7;
        final String str5;
        Object obj5;
        final String str6;
        MutableState mutableState2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1035994944);
        ComposerKt.sourceInformation(startRestartGroup, "C(MotionCarousel)P(4,3,5!1,2,7,6)153@6669L37,155@6734L39,156@6799L47,159@6937L107,162@7069L33,177@7610L46,230@9571L49,215@8950L1326:MotionCarousel.kt#fysre8");
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
            motionScene2 = motionScene;
        } else {
            motionScene2 = motionScene;
            if ((i3 & 6) == 0) {
                i5 = (startRestartGroup.changed(motionScene2) ? 4 : 2) | i3;
            } else {
                i5 = i3;
            }
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= startRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            i6 = i2;
        } else {
            i6 = i2;
            if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i5 |= startRestartGroup.changed(i6) ? 256 : 128;
            }
        }
        int i12 = i4 & 8;
        if (i12 != 0) {
            i5 |= 3072;
        } else if ((i3 & 3072) == 0) {
            obj = str;
            i5 |= startRestartGroup.changed(obj) ? 2048 : 1024;
            i7 = i4 & 16;
            if (i7 == 0) {
                i5 |= 24576;
            } else if ((i3 & 24576) == 0) {
                obj2 = str2;
                i5 |= startRestartGroup.changed(obj2) ? 16384 : 8192;
                i8 = i4 & 32;
                if (i8 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i3) == 0) {
                    obj3 = str3;
                    i5 |= startRestartGroup.changed(obj3) ? 131072 : 65536;
                    i9 = i4 & 64;
                    if (i9 == 0) {
                        i5 |= 1572864;
                        z2 = z;
                    } else {
                        z2 = z;
                        if ((i3 & 1572864) == 0) {
                            i5 |= startRestartGroup.changed(z2) ? 1048576 : 524288;
                        }
                    }
                    if ((i4 & 128) == 0) {
                        i5 |= 12582912;
                    } else if ((i3 & 12582912) == 0) {
                        i5 |= startRestartGroup.changedInstance(function1) ? 8388608 : 4194304;
                    }
                    i10 = i5;
                    if ((4793491 & i10) == 4793490 || !startRestartGroup.getSkipping()) {
                        String str7 = i12 == 0 ? "backward" : obj;
                        if (i7 != 0) {
                            obj2 = "forward";
                        }
                        final String str8 = i8 == 0 ? "slot" : obj3;
                        final boolean z3 = i9 == 0 ? false : z2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1035994944, i10, -1, "androidx.constraintlayout.compose.MotionCarousel (MotionCarousel.kt:147)");
                        }
                        androidx.compose.runtime.State<MotionItemsProvider> rememberStateOfItemsProvider = rememberStateOfItemsProvider(function1, startRestartGroup, (i10 >> 21) & 14);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162022299, "CC(remember):MotionCarousel.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(1000.0f);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        final MutableFloatState mutableFloatState = (MutableFloatState) rememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        String str9 = obj2;
                        String str10 = str7;
                        rememberCarouselSwipeableState = CarouselSwipeableKt.rememberCarouselSwipeableState(TtmlNode.START, null, null, startRestartGroup, 6, 6);
                        floatValue = rememberCarouselSwipeableState.getOffset().getFloatValue() / MotionCarousel$lambda$1(mutableFloatState);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162028863, "CC(remember):MotionCarousel.kt#9igjgp");
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new CarouselState(MotionCarouselDirection.FORWARD, 0, 0, false, false), null, 2, null);
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        MutableState mutableState3 = (MutableState) rememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162033013, "CC(remember):MotionCarousel.kt#9igjgp");
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        mutableIntState = (MutableIntState) rememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        if (MotionCarousel$lambda$7(mutableIntState) != 0) {
                            mapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), TtmlNode.START), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), "next"));
                        } else if (MotionCarousel$lambda$7(mutableIntState) == rememberStateOfItemsProvider.getValue().count() - 1) {
                            mapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), TtmlNode.START));
                        } else {
                            Pair pair = TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), "next");
                            str4 = TtmlNode.START;
                            i11 = 2;
                            mapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), TtmlNode.START), pair);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                            rememberedValue4 = startRestartGroup.rememberedValue();
                            Map map = mapOf;
                            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str9, null, i11, null);
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            mutableState = (MutableState) rememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            if (floatValue >= 0.0f && MotionCarousel$lambda$4(mutableState3).getIndex() > 0) {
                                MotionCarousel$lambda$4(mutableState3).setDirection(MotionCarouselDirection.BACKWARD);
                                mutableState.setValue(str10);
                                f = (-1) * floatValue;
                            } else {
                                MotionCarousel$lambda$4(mutableState3).setDirection(MotionCarouselDirection.FORWARD);
                                mutableState.setValue(str9);
                                f = floatValue;
                            }
                            startRestartGroup.startReplaceGroup(1162062662);
                            ComposerKt.sourceInformation(startRestartGroup, "");
                            if (rememberCarouselSwipeableState.isAnimationRunning()) {
                                obj4 = str10;
                                f2 = f;
                                carouselSwipeableState = rememberCarouselSwipeableState;
                                state = rememberStateOfItemsProvider;
                            } else {
                                obj4 = str10;
                                f2 = f;
                                if (MotionCarousel$lambda$4(mutableState3).getDirection() == MotionCarouselDirection.FORWARD && ((String) rememberCarouselSwipeableState.getCurrentValue()).equals("next")) {
                                    startRestartGroup.startReplaceGroup(1664382685);
                                    ComposerKt.sourceInformation(startRestartGroup, "193@8202L260,193@8181L281");
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162069496, "CC(remember):MotionCarousel.kt#9igjgp");
                                    boolean changed = startRestartGroup.changed(rememberStateOfItemsProvider) | startRestartGroup.changed(rememberCarouselSwipeableState);
                                    MotionCarouselKt$MotionCarousel$1$1 rememberedValue8 = startRestartGroup.rememberedValue();
                                    if (changed || rememberedValue8 == Composer.Companion.getEmpty()) {
                                        MotionCarouselKt$MotionCarousel$1$1 motionCarouselKt$MotionCarousel$1$1 = new MotionCarouselKt$MotionCarousel$1$1(rememberStateOfItemsProvider, rememberCarouselSwipeableState, str4, mutableState3, null);
                                        state = rememberStateOfItemsProvider;
                                        carouselSwipeableState = rememberCarouselSwipeableState;
                                        mutableState2 = mutableState3;
                                        rememberedValue8 = motionCarouselKt$MotionCarousel$1$1;
                                        startRestartGroup.updateRememberedValue(rememberedValue8);
                                    } else {
                                        carouselSwipeableState = rememberCarouselSwipeableState;
                                        state = rememberStateOfItemsProvider;
                                        mutableState2 = mutableState3;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    EffectsKt.LaunchedEffect((Object) true, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue8, startRestartGroup, 6);
                                    startRestartGroup.endReplaceGroup();
                                } else {
                                    carouselSwipeableState = rememberCarouselSwipeableState;
                                    state = rememberStateOfItemsProvider;
                                    String str11 = str4;
                                    mutableState2 = mutableState3;
                                    if (MotionCarousel$lambda$4(mutableState2).getDirection() == MotionCarouselDirection.BACKWARD && ((String) carouselSwipeableState.getCurrentValue()).equals("previous")) {
                                        startRestartGroup.startReplaceGroup(1664841950);
                                        ComposerKt.sourceInformation(startRestartGroup, "204@8666L227,204@8645L248");
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162084311, "CC(remember):MotionCarousel.kt#9igjgp");
                                        boolean changed2 = startRestartGroup.changed(carouselSwipeableState);
                                        MotionCarouselKt$MotionCarousel$2$1 rememberedValue9 = startRestartGroup.rememberedValue();
                                        if (changed2 || rememberedValue9 == Composer.Companion.getEmpty()) {
                                            rememberedValue9 = new MotionCarouselKt$MotionCarousel$2$1(carouselSwipeableState, str11, mutableState2, null);
                                            startRestartGroup.updateRememberedValue(rememberedValue9);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        EffectsKt.LaunchedEffect((Object) true, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue9, startRestartGroup, 6);
                                        startRestartGroup.endReplaceGroup();
                                    } else {
                                        startRestartGroup.startReplaceGroup(1665103342);
                                        startRestartGroup.endReplaceGroup();
                                    }
                                }
                                mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState2).getIndex());
                            }
                            startRestartGroup.endReplaceGroup();
                            String str12 = (String) mutableState.getValue();
                            m7159carouselSwipeablepPrIpRY = CarouselSwipeableKt.m7159carouselSwipeablepPrIpRY(BackgroundKt.m247backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), Color.Companion.m4115getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map, Orientation.Horizontal, (r26 & 8) != 0, (r26 & 16) != 0 ? false : true, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$3
                                @Override // kotlin.jvm.functions.Function2
                                public final ThresholdConfig invoke(String str13, String str14) {
                                    return new FractionalThreshold(0.3f);
                                }
                            }, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map.keySet(), 0.0f, 0.0f, 6, null) : null, (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m7164getVelocityThresholdD9Ej5fM() : 0.0f);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                            rememberedValue5 = startRestartGroup.rememberedValue();
                            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                                rememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                        m7086invokeozmzZPI(intSize.m6859unboximpl());
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke-ozmzZPI  reason: not valid java name */
                                    public final void m7086invokeozmzZPI(long j) {
                                        MutableFloatState.this.setFloatValue(IntSize.m6855getWidthimpl(j));
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Modifier onSizeChanged = OnRemeasuredModifierKt.onSizeChanged(m7159carouselSwipeablepPrIpRY, (Function1) rememberedValue5);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)255@11054L53,256@11136L93,261@11391L627,277@12024L412:MotionLayout.kt#fysre8");
                            int m7040getNonebfy_xzQ = DebugFlags.Companion.m7040getNonebfy_xzQ();
                            final InvalidationStrategy defaultInvalidationStrategy = InvalidationStrategy.Companion.getDefaultInvalidationStrategy();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1692859891, "CC(remember):MotionLayout.kt#9igjgp");
                            rememberedValue6 = startRestartGroup.rememberedValue();
                            if (rememberedValue6 == Composer.Companion.getEmpty()) {
                                rememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                                startRestartGroup.updateRememberedValue(rememberedValue6);
                            }
                            final MutableState mutableState4 = (MutableState) rememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1692862555, "CC(remember):MotionLayout.kt#9igjgp");
                            rememberedValue7 = startRestartGroup.rememberedValue();
                            Ref ref = rememberedValue7;
                            if (rememberedValue7 == Composer.Companion.getEmpty()) {
                                Ref ref2 = new Ref();
                                ref2.setValue(CompositionSource.Unknown);
                                startRestartGroup.updateRememberedValue(ref2);
                                ref = ref2;
                            }
                            final Ref ref3 = (Ref) ref;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            final androidx.compose.runtime.State<MotionItemsProvider> state2 = state;
                            final int i13 = i6;
                            Function3<MotionLayoutScope, Composer, Integer, Unit> function3 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                                    invoke(motionLayoutScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i14) {
                                    int MotionCarousel$lambda$7;
                                    ComposerKt.sourceInformation(composer2, "C274@12003L9:MotionLayout.kt#fysre8");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-23317463, i14, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:264)");
                                    }
                                    MutableState.this.setValue(Unit.INSTANCE);
                                    if (defaultInvalidationStrategy.getOnObservedStateChange() == null && ref3.getValue() == CompositionSource.Unknown) {
                                        ref3.setValue(CompositionSource.Content);
                                    }
                                    composer2.startReplaceGroup(-1854403913);
                                    ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                                    composer2.startReplaceGroup(1187106508);
                                    ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                                    int i15 = 0;
                                    while (i15 < i13) {
                                        MotionCarousel$lambda$7 = MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState);
                                        final int i16 = (MotionCarousel$lambda$7 + i15) - i;
                                        final boolean z4 = i16 >= 0 && i16 < ((MotionItemsProvider) state2.getValue()).count();
                                        String str13 = str8;
                                        boolean z5 = z3;
                                        final int i17 = i15;
                                        final androidx.compose.runtime.State state3 = state2;
                                        final String str14 = str8;
                                        ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
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

                                            public final void invoke(Composer composer3, int i18) {
                                                ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                                if ((i18 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-2020349941, i18, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                                    }
                                                    if (z4) {
                                                        if (state3.getValue().hasItemsWithProperties()) {
                                                            composer3.startReplaceGroup(-2023112919);
                                                            ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                            state3.getValue().getContent(i16, motionLayoutScope.motionProperties(str14 + i17, composer3, 0)).invoke(composer3, 0);
                                                            composer3.endReplaceGroup();
                                                        } else {
                                                            composer3.startReplaceGroup(-2022913031);
                                                            ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                            state3.getValue().getContent(i16).invoke(composer3, 0);
                                                            composer3.endReplaceGroup();
                                                        }
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }, composer2, 54);
                                        int i18 = i10;
                                        MotionCarouselKt.ItemHolder(i17, str13, z5, rememberComposableLambda, composer2, ((i18 >> 12) & 896) | ((i18 >> 12) & 112) | 3072);
                                        i15 = i17 + 1;
                                    }
                                    composer2.endReplaceGroup();
                                    composer2.endReplaceGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            };
                            String str13 = str8;
                            boolean z4 = z3;
                            MotionLayoutKt.m7102MotionLayoutCoreSehEMGo(motionScene2, f2, str12, 257, m7040getNonebfy_xzQ, onSizeChanged, mutableState4, ref3, defaultInvalidationStrategy, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function3, startRestartGroup, 54), startRestartGroup, 806879232 | (i10 & 14) | (Ref.$stable << 21));
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z2 = z4;
                            str5 = str9;
                            obj5 = obj4;
                            str6 = str13;
                        }
                        str4 = TtmlNode.START;
                        i11 = 2;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        Map map2 = mapOf;
                        if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        }
                        mutableState = (MutableState) rememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        if (floatValue >= 0.0f) {
                        }
                        MotionCarousel$lambda$4(mutableState3).setDirection(MotionCarouselDirection.FORWARD);
                        mutableState.setValue(str9);
                        f = floatValue;
                        startRestartGroup.startReplaceGroup(1162062662);
                        ComposerKt.sourceInformation(startRestartGroup, "");
                        if (rememberCarouselSwipeableState.isAnimationRunning()) {
                        }
                        startRestartGroup.endReplaceGroup();
                        String str122 = (String) mutableState.getValue();
                        m7159carouselSwipeablepPrIpRY = CarouselSwipeableKt.m7159carouselSwipeablepPrIpRY(BackgroundKt.m247backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), Color.Companion.m4115getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map2, Orientation.Horizontal, (r26 & 8) != 0, (r26 & 16) != 0 ? false : true, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$3
                            @Override // kotlin.jvm.functions.Function2
                            public final ThresholdConfig invoke(String str132, String str14) {
                                return new FractionalThreshold(0.3f);
                            }
                        }, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map2.keySet(), 0.0f, 0.0f, 6, null) : null, (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m7164getVelocityThresholdD9Ej5fM() : 0.0f);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                        rememberedValue5 = startRestartGroup.rememberedValue();
                        if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        }
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        Modifier onSizeChanged2 = OnRemeasuredModifierKt.onSizeChanged(m7159carouselSwipeablepPrIpRY, (Function1) rememberedValue5);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)255@11054L53,256@11136L93,261@11391L627,277@12024L412:MotionLayout.kt#fysre8");
                        int m7040getNonebfy_xzQ2 = DebugFlags.Companion.m7040getNonebfy_xzQ();
                        final InvalidationStrategy defaultInvalidationStrategy2 = InvalidationStrategy.Companion.getDefaultInvalidationStrategy();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1692859891, "CC(remember):MotionLayout.kt#9igjgp");
                        rememberedValue6 = startRestartGroup.rememberedValue();
                        if (rememberedValue6 == Composer.Companion.getEmpty()) {
                        }
                        final MutableState mutableState42 = (MutableState) rememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1692862555, "CC(remember):MotionLayout.kt#9igjgp");
                        rememberedValue7 = startRestartGroup.rememberedValue();
                        Ref ref4 = rememberedValue7;
                        if (rememberedValue7 == Composer.Companion.getEmpty()) {
                        }
                        final Ref ref32 = (Ref) ref4;
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        final androidx.compose.runtime.State state22 = state;
                        final int i132 = i6;
                        Function3<MotionLayoutScope, Composer, Integer, Unit> function32 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                                invoke(motionLayoutScope, composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i14) {
                                int MotionCarousel$lambda$7;
                                ComposerKt.sourceInformation(composer2, "C274@12003L9:MotionLayout.kt#fysre8");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-23317463, i14, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:264)");
                                }
                                MutableState.this.setValue(Unit.INSTANCE);
                                if (defaultInvalidationStrategy2.getOnObservedStateChange() == null && ref32.getValue() == CompositionSource.Unknown) {
                                    ref32.setValue(CompositionSource.Content);
                                }
                                composer2.startReplaceGroup(-1854403913);
                                ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                                composer2.startReplaceGroup(1187106508);
                                ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                                int i15 = 0;
                                while (i15 < i132) {
                                    MotionCarousel$lambda$7 = MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState);
                                    final int i16 = (MotionCarousel$lambda$7 + i15) - i;
                                    final boolean z42 = i16 >= 0 && i16 < ((MotionItemsProvider) state22.getValue()).count();
                                    String str132 = str8;
                                    boolean z5 = z3;
                                    final int i17 = i15;
                                    final androidx.compose.runtime.State<? extends MotionItemsProvider> state3 = state22;
                                    final String str14 = str8;
                                    ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
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

                                        public final void invoke(Composer composer3, int i18) {
                                            ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                            if ((i18 & 3) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2020349941, i18, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                                }
                                                if (z42) {
                                                    if (state3.getValue().hasItemsWithProperties()) {
                                                        composer3.startReplaceGroup(-2023112919);
                                                        ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                        state3.getValue().getContent(i16, motionLayoutScope.motionProperties(str14 + i17, composer3, 0)).invoke(composer3, 0);
                                                        composer3.endReplaceGroup();
                                                    } else {
                                                        composer3.startReplaceGroup(-2022913031);
                                                        ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                        state3.getValue().getContent(i16).invoke(composer3, 0);
                                                        composer3.endReplaceGroup();
                                                    }
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }, composer2, 54);
                                    int i18 = i10;
                                    MotionCarouselKt.ItemHolder(i17, str132, z5, rememberComposableLambda, composer2, ((i18 >> 12) & 896) | ((i18 >> 12) & 112) | 3072);
                                    i15 = i17 + 1;
                                }
                                composer2.endReplaceGroup();
                                composer2.endReplaceGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        };
                        String str132 = str8;
                        boolean z42 = z3;
                        MotionLayoutKt.m7102MotionLayoutCoreSehEMGo(motionScene2, f2, str122, 257, m7040getNonebfy_xzQ2, onSizeChanged2, mutableState42, ref32, defaultInvalidationStrategy2, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function32, startRestartGroup, 54), startRestartGroup, 806879232 | (i10 & 14) | (Ref.$stable << 21));
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        z2 = z42;
                        str5 = str9;
                        obj5 = obj4;
                        str6 = str132;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        str5 = obj2;
                        str6 = obj3;
                        obj5 = obj;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final String str14 = obj5;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$6
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
                                MotionCarouselKt.MotionCarousel(MotionScene.this, i, i2, str14, str5, str6, z2, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
                            }
                        });
                        return;
                    }
                    return;
                }
                obj3 = str3;
                i9 = i4 & 64;
                if (i9 == 0) {
                }
                if ((i4 & 128) == 0) {
                }
                i10 = i5;
                if ((4793491 & i10) == 4793490) {
                }
                if (i12 == 0) {
                }
                if (i7 != 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                androidx.compose.runtime.State<MotionItemsProvider> rememberStateOfItemsProvider2 = rememberStateOfItemsProvider(function1, startRestartGroup, (i10 >> 21) & 14);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162022299, "CC(remember):MotionCarousel.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                }
                final MutableFloatState mutableFloatState2 = (MutableFloatState) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                String str92 = obj2;
                String str102 = str7;
                rememberCarouselSwipeableState = CarouselSwipeableKt.rememberCarouselSwipeableState(TtmlNode.START, null, null, startRestartGroup, 6, 6);
                floatValue = rememberCarouselSwipeableState.getOffset().getFloatValue() / MotionCarousel$lambda$1(mutableFloatState2);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162028863, "CC(remember):MotionCarousel.kt#9igjgp");
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                }
                MutableState mutableState32 = (MutableState) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162033013, "CC(remember):MotionCarousel.kt#9igjgp");
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                }
                mutableIntState = (MutableIntState) rememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                if (MotionCarousel$lambda$7(mutableIntState) != 0) {
                }
                str4 = TtmlNode.START;
                i11 = 2;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                rememberedValue4 = startRestartGroup.rememberedValue();
                Map map22 = mapOf;
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                }
                mutableState = (MutableState) rememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                if (floatValue >= 0.0f) {
                }
                MotionCarousel$lambda$4(mutableState32).setDirection(MotionCarouselDirection.FORWARD);
                mutableState.setValue(str92);
                f = floatValue;
                startRestartGroup.startReplaceGroup(1162062662);
                ComposerKt.sourceInformation(startRestartGroup, "");
                if (rememberCarouselSwipeableState.isAnimationRunning()) {
                }
                startRestartGroup.endReplaceGroup();
                String str1222 = (String) mutableState.getValue();
                m7159carouselSwipeablepPrIpRY = CarouselSwipeableKt.m7159carouselSwipeablepPrIpRY(BackgroundKt.m247backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), Color.Companion.m4115getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map22, Orientation.Horizontal, (r26 & 8) != 0, (r26 & 16) != 0 ? false : true, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$3
                    @Override // kotlin.jvm.functions.Function2
                    public final ThresholdConfig invoke(String str1322, String str142) {
                        return new FractionalThreshold(0.3f);
                    }
                }, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map22.keySet(), 0.0f, 0.0f, 6, null) : null, (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m7164getVelocityThresholdD9Ej5fM() : 0.0f);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (rememberedValue5 == Composer.Companion.getEmpty()) {
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier onSizeChanged22 = OnRemeasuredModifierKt.onSizeChanged(m7159carouselSwipeablepPrIpRY, (Function1) rememberedValue5);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)255@11054L53,256@11136L93,261@11391L627,277@12024L412:MotionLayout.kt#fysre8");
                int m7040getNonebfy_xzQ22 = DebugFlags.Companion.m7040getNonebfy_xzQ();
                final InvalidationStrategy defaultInvalidationStrategy22 = InvalidationStrategy.Companion.getDefaultInvalidationStrategy();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1692859891, "CC(remember):MotionLayout.kt#9igjgp");
                rememberedValue6 = startRestartGroup.rememberedValue();
                if (rememberedValue6 == Composer.Companion.getEmpty()) {
                }
                final MutableState mutableState422 = (MutableState) rememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1692862555, "CC(remember):MotionLayout.kt#9igjgp");
                rememberedValue7 = startRestartGroup.rememberedValue();
                Ref ref42 = rememberedValue7;
                if (rememberedValue7 == Composer.Companion.getEmpty()) {
                }
                final Ref ref322 = (Ref) ref42;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final androidx.compose.runtime.State state222 = state;
                final int i1322 = i6;
                Function3<MotionLayoutScope, Composer, Integer, Unit> function322 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                        invoke(motionLayoutScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i14) {
                        int MotionCarousel$lambda$7;
                        ComposerKt.sourceInformation(composer2, "C274@12003L9:MotionLayout.kt#fysre8");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-23317463, i14, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:264)");
                        }
                        MutableState.this.setValue(Unit.INSTANCE);
                        if (defaultInvalidationStrategy22.getOnObservedStateChange() == null && ref322.getValue() == CompositionSource.Unknown) {
                            ref322.setValue(CompositionSource.Content);
                        }
                        composer2.startReplaceGroup(-1854403913);
                        ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                        composer2.startReplaceGroup(1187106508);
                        ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                        int i15 = 0;
                        while (i15 < i1322) {
                            MotionCarousel$lambda$7 = MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState);
                            final int i16 = (MotionCarousel$lambda$7 + i15) - i;
                            final boolean z422 = i16 >= 0 && i16 < ((MotionItemsProvider) state222.getValue()).count();
                            String str1322 = str8;
                            boolean z5 = z3;
                            final int i17 = i15;
                            final androidx.compose.runtime.State<? extends MotionItemsProvider> state3 = state222;
                            final String str142 = str8;
                            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
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

                                public final void invoke(Composer composer3, int i18) {
                                    ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                    if ((i18 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2020349941, i18, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                        }
                                        if (z422) {
                                            if (state3.getValue().hasItemsWithProperties()) {
                                                composer3.startReplaceGroup(-2023112919);
                                                ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                state3.getValue().getContent(i16, motionLayoutScope.motionProperties(str142 + i17, composer3, 0)).invoke(composer3, 0);
                                                composer3.endReplaceGroup();
                                            } else {
                                                composer3.startReplaceGroup(-2022913031);
                                                ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                state3.getValue().getContent(i16).invoke(composer3, 0);
                                                composer3.endReplaceGroup();
                                            }
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }, composer2, 54);
                            int i18 = i10;
                            MotionCarouselKt.ItemHolder(i17, str1322, z5, rememberComposableLambda, composer2, ((i18 >> 12) & 896) | ((i18 >> 12) & 112) | 3072);
                            i15 = i17 + 1;
                        }
                        composer2.endReplaceGroup();
                        composer2.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                };
                String str1322 = str8;
                boolean z422 = z3;
                MotionLayoutKt.m7102MotionLayoutCoreSehEMGo(motionScene2, f2, str1222, 257, m7040getNonebfy_xzQ22, onSizeChanged22, mutableState422, ref322, defaultInvalidationStrategy22, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function322, startRestartGroup, 54), startRestartGroup, 806879232 | (i10 & 14) | (Ref.$stable << 21));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                }
                z2 = z422;
                str5 = str92;
                obj5 = obj4;
                str6 = str1322;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            obj2 = str2;
            i8 = i4 & 32;
            if (i8 != 0) {
            }
            obj3 = str3;
            i9 = i4 & 64;
            if (i9 == 0) {
            }
            if ((i4 & 128) == 0) {
            }
            i10 = i5;
            if ((4793491 & i10) == 4793490) {
            }
            if (i12 == 0) {
            }
            if (i7 != 0) {
            }
            if (i8 == 0) {
            }
            if (i9 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            androidx.compose.runtime.State<MotionItemsProvider> rememberStateOfItemsProvider22 = rememberStateOfItemsProvider(function1, startRestartGroup, (i10 >> 21) & 14);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162022299, "CC(remember):MotionCarousel.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
            }
            final MutableFloatState mutableFloatState22 = (MutableFloatState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            String str922 = obj2;
            String str1022 = str7;
            rememberCarouselSwipeableState = CarouselSwipeableKt.rememberCarouselSwipeableState(TtmlNode.START, null, null, startRestartGroup, 6, 6);
            floatValue = rememberCarouselSwipeableState.getOffset().getFloatValue() / MotionCarousel$lambda$1(mutableFloatState22);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162028863, "CC(remember):MotionCarousel.kt#9igjgp");
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
            }
            MutableState mutableState322 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162033013, "CC(remember):MotionCarousel.kt#9igjgp");
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
            }
            mutableIntState = (MutableIntState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (MotionCarousel$lambda$7(mutableIntState) != 0) {
            }
            str4 = TtmlNode.START;
            i11 = 2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
            rememberedValue4 = startRestartGroup.rememberedValue();
            Map map222 = mapOf;
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
            }
            mutableState = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (floatValue >= 0.0f) {
            }
            MotionCarousel$lambda$4(mutableState322).setDirection(MotionCarouselDirection.FORWARD);
            mutableState.setValue(str922);
            f = floatValue;
            startRestartGroup.startReplaceGroup(1162062662);
            ComposerKt.sourceInformation(startRestartGroup, "");
            if (rememberCarouselSwipeableState.isAnimationRunning()) {
            }
            startRestartGroup.endReplaceGroup();
            String str12222 = (String) mutableState.getValue();
            m7159carouselSwipeablepPrIpRY = CarouselSwipeableKt.m7159carouselSwipeablepPrIpRY(BackgroundKt.m247backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), Color.Companion.m4115getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map222, Orientation.Horizontal, (r26 & 8) != 0, (r26 & 16) != 0 ? false : true, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$3
                @Override // kotlin.jvm.functions.Function2
                public final ThresholdConfig invoke(String str13222, String str142) {
                    return new FractionalThreshold(0.3f);
                }
            }, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map222.keySet(), 0.0f, 0.0f, 6, null) : null, (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m7164getVelocityThresholdD9Ej5fM() : 0.0f);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
            rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.Companion.getEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier onSizeChanged222 = OnRemeasuredModifierKt.onSizeChanged(m7159carouselSwipeablepPrIpRY, (Function1) rememberedValue5);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)255@11054L53,256@11136L93,261@11391L627,277@12024L412:MotionLayout.kt#fysre8");
            int m7040getNonebfy_xzQ222 = DebugFlags.Companion.m7040getNonebfy_xzQ();
            final InvalidationStrategy defaultInvalidationStrategy222 = InvalidationStrategy.Companion.getDefaultInvalidationStrategy();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1692859891, "CC(remember):MotionLayout.kt#9igjgp");
            rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.Companion.getEmpty()) {
            }
            final MutableState mutableState4222 = (MutableState) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1692862555, "CC(remember):MotionLayout.kt#9igjgp");
            rememberedValue7 = startRestartGroup.rememberedValue();
            Ref ref422 = rememberedValue7;
            if (rememberedValue7 == Composer.Companion.getEmpty()) {
            }
            final Ref ref3222 = (Ref) ref422;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final androidx.compose.runtime.State state2222 = state;
            final int i13222 = i6;
            Function3<MotionLayoutScope, Composer, Integer, Unit> function3222 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                    invoke(motionLayoutScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i14) {
                    int MotionCarousel$lambda$7;
                    ComposerKt.sourceInformation(composer2, "C274@12003L9:MotionLayout.kt#fysre8");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-23317463, i14, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:264)");
                    }
                    MutableState.this.setValue(Unit.INSTANCE);
                    if (defaultInvalidationStrategy222.getOnObservedStateChange() == null && ref3222.getValue() == CompositionSource.Unknown) {
                        ref3222.setValue(CompositionSource.Content);
                    }
                    composer2.startReplaceGroup(-1854403913);
                    ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                    composer2.startReplaceGroup(1187106508);
                    ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                    int i15 = 0;
                    while (i15 < i13222) {
                        MotionCarousel$lambda$7 = MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState);
                        final int i16 = (MotionCarousel$lambda$7 + i15) - i;
                        final boolean z4222 = i16 >= 0 && i16 < ((MotionItemsProvider) state2222.getValue()).count();
                        String str13222 = str8;
                        boolean z5 = z3;
                        final int i17 = i15;
                        final androidx.compose.runtime.State<? extends MotionItemsProvider> state3 = state2222;
                        final String str142 = str8;
                        ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
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

                            public final void invoke(Composer composer3, int i18) {
                                ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                if ((i18 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2020349941, i18, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                    }
                                    if (z4222) {
                                        if (state3.getValue().hasItemsWithProperties()) {
                                            composer3.startReplaceGroup(-2023112919);
                                            ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                            state3.getValue().getContent(i16, motionLayoutScope.motionProperties(str142 + i17, composer3, 0)).invoke(composer3, 0);
                                            composer3.endReplaceGroup();
                                        } else {
                                            composer3.startReplaceGroup(-2022913031);
                                            ComposerKt.sourceInformation(composer3, "241@10198L8");
                                            state3.getValue().getContent(i16).invoke(composer3, 0);
                                            composer3.endReplaceGroup();
                                        }
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }, composer2, 54);
                        int i18 = i10;
                        MotionCarouselKt.ItemHolder(i17, str13222, z5, rememberComposableLambda, composer2, ((i18 >> 12) & 896) | ((i18 >> 12) & 112) | 3072);
                        i15 = i17 + 1;
                    }
                    composer2.endReplaceGroup();
                    composer2.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            };
            String str13222 = str8;
            boolean z4222 = z3;
            MotionLayoutKt.m7102MotionLayoutCoreSehEMGo(motionScene2, f2, str12222, 257, m7040getNonebfy_xzQ222, onSizeChanged222, mutableState4222, ref3222, defaultInvalidationStrategy222, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function3222, startRestartGroup, 54), startRestartGroup, 806879232 | (i10 & 14) | (Ref.$stable << 21));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
            }
            z2 = z4222;
            str5 = str922;
            obj5 = obj4;
            str6 = str13222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = str;
        i7 = i4 & 16;
        if (i7 == 0) {
        }
        obj2 = str2;
        i8 = i4 & 32;
        if (i8 != 0) {
        }
        obj3 = str3;
        i9 = i4 & 64;
        if (i9 == 0) {
        }
        if ((i4 & 128) == 0) {
        }
        i10 = i5;
        if ((4793491 & i10) == 4793490) {
        }
        if (i12 == 0) {
        }
        if (i7 != 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        androidx.compose.runtime.State<MotionItemsProvider> rememberStateOfItemsProvider222 = rememberStateOfItemsProvider(function1, startRestartGroup, (i10 >> 21) & 14);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162022299, "CC(remember):MotionCarousel.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
        }
        final MutableFloatState mutableFloatState222 = (MutableFloatState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        String str9222 = obj2;
        String str10222 = str7;
        rememberCarouselSwipeableState = CarouselSwipeableKt.rememberCarouselSwipeableState(TtmlNode.START, null, null, startRestartGroup, 6, 6);
        floatValue = rememberCarouselSwipeableState.getOffset().getFloatValue() / MotionCarousel$lambda$1(mutableFloatState222);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162028863, "CC(remember):MotionCarousel.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
        }
        MutableState mutableState3222 = (MutableState) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162033013, "CC(remember):MotionCarousel.kt#9igjgp");
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
        }
        mutableIntState = (MutableIntState) rememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        if (MotionCarousel$lambda$7(mutableIntState) != 0) {
        }
        str4 = TtmlNode.START;
        i11 = 2;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
        rememberedValue4 = startRestartGroup.rememberedValue();
        Map map2222 = mapOf;
        if (rememberedValue4 == Composer.Companion.getEmpty()) {
        }
        mutableState = (MutableState) rememberedValue4;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        if (floatValue >= 0.0f) {
        }
        MotionCarousel$lambda$4(mutableState3222).setDirection(MotionCarouselDirection.FORWARD);
        mutableState.setValue(str9222);
        f = floatValue;
        startRestartGroup.startReplaceGroup(1162062662);
        ComposerKt.sourceInformation(startRestartGroup, "");
        if (rememberCarouselSwipeableState.isAnimationRunning()) {
        }
        startRestartGroup.endReplaceGroup();
        String str122222 = (String) mutableState.getValue();
        m7159carouselSwipeablepPrIpRY = CarouselSwipeableKt.m7159carouselSwipeablepPrIpRY(BackgroundKt.m247backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), Color.Companion.m4115getWhite0d7_KjU(), null, 2, null), carouselSwipeableState, map2222, Orientation.Horizontal, (r26 & 8) != 0, (r26 & 16) != 0 ? false : true, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$3
            @Override // kotlin.jvm.functions.Function2
            public final ThresholdConfig invoke(String str132222, String str142) {
                return new FractionalThreshold(0.3f);
            }
        }, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map2222.keySet(), 0.0f, 0.0f, 6, null) : null, (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m7164getVelocityThresholdD9Ej5fM() : 0.0f);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (rememberedValue5 == Composer.Companion.getEmpty()) {
        }
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Modifier onSizeChanged2222 = OnRemeasuredModifierKt.onSizeChanged(m7159carouselSwipeablepPrIpRY, (Function1) rememberedValue5);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)255@11054L53,256@11136L93,261@11391L627,277@12024L412:MotionLayout.kt#fysre8");
        int m7040getNonebfy_xzQ2222 = DebugFlags.Companion.m7040getNonebfy_xzQ();
        final InvalidationStrategy defaultInvalidationStrategy2222 = InvalidationStrategy.Companion.getDefaultInvalidationStrategy();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1692859891, "CC(remember):MotionLayout.kt#9igjgp");
        rememberedValue6 = startRestartGroup.rememberedValue();
        if (rememberedValue6 == Composer.Companion.getEmpty()) {
        }
        final MutableState mutableState42222 = (MutableState) rememberedValue6;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1692862555, "CC(remember):MotionLayout.kt#9igjgp");
        rememberedValue7 = startRestartGroup.rememberedValue();
        Ref ref4222 = rememberedValue7;
        if (rememberedValue7 == Composer.Companion.getEmpty()) {
        }
        final Ref ref32222 = (Ref) ref4222;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final androidx.compose.runtime.State state22222 = state;
        final int i132222 = i6;
        Function3<MotionLayoutScope, Composer, Integer, Unit> function32222 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                invoke(motionLayoutScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i14) {
                int MotionCarousel$lambda$7;
                ComposerKt.sourceInformation(composer2, "C274@12003L9:MotionLayout.kt#fysre8");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-23317463, i14, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:264)");
                }
                MutableState.this.setValue(Unit.INSTANCE);
                if (defaultInvalidationStrategy2222.getOnObservedStateChange() == null && ref32222.getValue() == CompositionSource.Unknown) {
                    ref32222.setValue(CompositionSource.Content);
                }
                composer2.startReplaceGroup(-1854403913);
                ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                composer2.startReplaceGroup(1187106508);
                ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                int i15 = 0;
                while (i15 < i132222) {
                    MotionCarousel$lambda$7 = MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState);
                    final int i16 = (MotionCarousel$lambda$7 + i15) - i;
                    final boolean z42222 = i16 >= 0 && i16 < ((MotionItemsProvider) state22222.getValue()).count();
                    String str132222 = str8;
                    boolean z5 = z3;
                    final int i17 = i15;
                    final androidx.compose.runtime.State<? extends MotionItemsProvider> state3 = state22222;
                    final String str142 = str8;
                    ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
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

                        public final void invoke(Composer composer3, int i18) {
                            ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                            if ((i18 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2020349941, i18, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                }
                                if (z42222) {
                                    if (state3.getValue().hasItemsWithProperties()) {
                                        composer3.startReplaceGroup(-2023112919);
                                        ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                        state3.getValue().getContent(i16, motionLayoutScope.motionProperties(str142 + i17, composer3, 0)).invoke(composer3, 0);
                                        composer3.endReplaceGroup();
                                    } else {
                                        composer3.startReplaceGroup(-2022913031);
                                        ComposerKt.sourceInformation(composer3, "241@10198L8");
                                        state3.getValue().getContent(i16).invoke(composer3, 0);
                                        composer3.endReplaceGroup();
                                    }
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }, composer2, 54);
                    int i18 = i10;
                    MotionCarouselKt.ItemHolder(i17, str132222, z5, rememberComposableLambda, composer2, ((i18 >> 12) & 896) | ((i18 >> 12) & 112) | 3072);
                    i15 = i17 + 1;
                }
                composer2.endReplaceGroup();
                composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        };
        String str132222 = str8;
        boolean z42222 = z3;
        MotionLayoutKt.m7102MotionLayoutCoreSehEMGo(motionScene2, f2, str122222, 257, m7040getNonebfy_xzQ2222, onSizeChanged2222, mutableState42222, ref32222, defaultInvalidationStrategy2222, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function32222, startRestartGroup, 54), startRestartGroup, 806879232 | (i10 & 14) | (Ref.$stable << 21));
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        if (ComposerKt.isTraceInProgress()) {
        }
        z2 = z42222;
        str5 = str9222;
        obj5 = obj4;
        str6 = str132222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final float MotionCarousel$lambda$1(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CarouselState MotionCarousel$lambda$4(MutableState<CarouselState> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int MotionCarousel$lambda$7(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    public static final void ItemHolder(final int i, final String str, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1970516035);
        ComposerKt.sourceInformation(startRestartGroup, "C(ItemHolder)P(1,3,2)259@10665L83:MotionCarousel.kt#fysre8");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i3 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1970516035, i3, -1, "androidx.constraintlayout.compose.ItemHolder (MotionCarousel.kt:250)");
            }
            Modifier layoutId$default = ConstraintLayoutTagKt.layoutId$default(Modifier.Companion, str + i, null, 2, null);
            if (z) {
                float f = 20;
                layoutId$default = BorderKt.m258borderxT4_qwU(ClipKt.clip(layoutId$default, RoundedCornerShapeKt.m1032RoundedCornerShape0680j_4(Dp.m6684constructorimpl(f))), Dp.m6684constructorimpl(2), ColorKt.Color(0, 0, 0, 60), RoundedCornerShapeKt.m1032RoundedCornerShape0680j_4(Dp.m6684constructorimpl(f)));
            }
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1063080426, "C259@10738L8:MotionCarousel.kt#fysre8");
            function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 9) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$ItemHolder$2
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

                public final void invoke(Composer composer2, int i4) {
                    MotionCarouselKt.ItemHolder(i, str, z, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    public static final <T> void items(MotionCarouselScope motionCarouselScope, final List<? extends T> list, final Function3<? super T, ? super Composer, ? super Integer, Unit> function3) {
        motionCarouselScope.items(list.size(), ComposableLambdaKt.composableLambdaInstance(85623574, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$items$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Composer composer, Integer num2) {
                invoke(num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i, Composer composer, int i2) {
                ComposerKt.sourceInformation(composer, "C278@11161L25:MotionCarousel.kt#fysre8");
                if ((i2 & 6) == 0) {
                    i2 |= composer.changed(i) ? 4 : 2;
                }
                if ((i2 & 19) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(85623574, i2, -1, "androidx.constraintlayout.compose.items.<anonymous> (MotionCarousel.kt:278)");
                }
                function3.invoke(list.get(i), composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    public static final <T> void itemsWithProperties(MotionCarouselScope motionCarouselScope, final List<? extends T> list, final Function4<? super T, ? super androidx.compose.runtime.State<MotionLayoutScope.MotionProperties>, ? super Composer, ? super Integer, Unit> function4) {
        motionCarouselScope.itemsWithProperties(list.size(), ComposableLambdaKt.composableLambdaInstance(1304172608, true, new Function4<Integer, androidx.compose.runtime.State<? extends MotionLayoutScope.MotionProperties>, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$itemsWithProperties$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, androidx.compose.runtime.State<? extends MotionLayoutScope.MotionProperties> state, Composer composer, Integer num2) {
                invoke(num.intValue(), (androidx.compose.runtime.State<MotionLayoutScope.MotionProperties>) state, composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i, androidx.compose.runtime.State<MotionLayoutScope.MotionProperties> state, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "C302@11988L37:MotionCarousel.kt#fysre8");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(i) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(state) ? 32 : 16;
                }
                if ((i3 & 147) == 146 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1304172608, i3, -1, "androidx.constraintlayout.compose.itemsWithProperties.<anonymous> (MotionCarousel.kt:302)");
                }
                function4.invoke(list.get(i), state, composer, Integer.valueOf(i3 & 112));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    private static final androidx.compose.runtime.State<MotionItemsProvider> rememberStateOfItemsProvider(Function1<? super MotionCarouselScope, Unit> function1, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1507876322, "C(rememberStateOfItemsProvider)308@12208L29,309@12249L84:MotionCarousel.kt#fysre8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1507876322, i, -1, "androidx.constraintlayout.compose.rememberStateOfItemsProvider (MotionCarousel.kt:307)");
        }
        final androidx.compose.runtime.State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composer, i & 14);
        ComposerKt.sourceInformationMarkerStart(composer, 1350480360, "CC(remember):MotionCarousel.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.derivedStateOf(new Function0<MotionCarouselScopeImpl>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$rememberStateOfItemsProvider$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final MotionCarouselScopeImpl invoke() {
                    MotionCarouselScopeImpl motionCarouselScopeImpl = new MotionCarouselScopeImpl();
                    rememberUpdatedState.getValue().invoke(motionCarouselScopeImpl);
                    return motionCarouselScopeImpl;
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        androidx.compose.runtime.State<MotionItemsProvider> state = (androidx.compose.runtime.State) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return state;
    }
}
