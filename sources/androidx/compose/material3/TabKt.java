package androidx.compose.material3;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Tab.kt */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0082\u0001\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u008a\u0001\u0010$\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001az\u0010$\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00120(¢\u0006\u0002\b\u0018¢\u0006\u0002\b*H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a7\u0010-\u001a\u00020\u00122\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u00182\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u0018H\u0003¢\u0006\u0002\u0010.\u001a=\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u00142\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u0018H\u0003ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aD\u00104\u001a\u00020\u0012*\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\r2\u0006\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020\r2\u0006\u0010>\u001a\u00020\rH\u0002\u001a\u001c\u0010?\u001a\u00020\u0012*\u0002052\u0006\u0010@\u001a\u0002092\u0006\u0010<\u001a\u00020\rH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0010\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006A²\u0006\n\u0010B\u001a\u00020\u001eX\u008a\u0084\u0002"}, d2 = {"DoubleLineTextBaselineWithIcon", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalTextPadding", "getHorizontalTextPadding", "()F", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "LargeTabHeight", "SingleLineTextBaselineWithIcon", "SmallTabHeight", "TabFadeInAnimationDelay", "", "TabFadeInAnimationDuration", "TabFadeOutAnimationDuration", "TextDistanceFromLeadingIcon", "LeadingIconTab", "", "selected", "", "onClick", "Lkotlin/Function0;", "text", "Landroidx/compose/runtime/Composable;", "icon", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "LeadingIconTab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "Tab", "Tab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-bogVsAg", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextAndIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "density", "Landroidx/compose/ui/unit/Density;", "textPlaceable", "Landroidx/compose/ui/layout/Placeable;", "iconPlaceable", "tabWidth", "tabHeight", "firstBaseline", "lastBaseline", "placeTextOrIcon", "textOrIconPlaceable", "material3_release", "color"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TabKt {
    private static final int TabFadeInAnimationDelay = 100;
    private static final int TabFadeInAnimationDuration = 150;
    private static final int TabFadeOutAnimationDuration = 100;
    private static final float SmallTabHeight = PrimaryNavigationTabTokens.INSTANCE.m3264getContainerHeightD9Ej5fM();
    private static final float LargeTabHeight = Dp.m6684constructorimpl(72);
    private static final float HorizontalTextPadding = Dp.m6684constructorimpl(16);
    private static final float SingleLineTextBaselineWithIcon = Dp.m6684constructorimpl(14);
    private static final float DoubleLineTextBaselineWithIcon = Dp.m6684constructorimpl(6);
    private static final long IconDistanceFromBaseline = TextUnitKt.getSp(20);
    private static final float TextDistanceFromLeadingIcon = Dp.m6684constructorimpl(8);

    /* JADX WARN: Removed duplicated region for block: B:101:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0102  */
    /* renamed from: Tab-wqdebIU  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2383TabwqdebIU(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, long j, long j2, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        boolean z3;
        int i3;
        Function0<Unit> function02;
        Modifier.Companion companion;
        int i4;
        boolean z4;
        int i5;
        final Object obj;
        int i6;
        final Object obj2;
        int i7;
        int i8;
        int i9;
        int i10;
        long j3;
        long j4;
        boolean z5;
        final ComposableLambda composableLambda;
        long j5;
        long j6;
        int i11;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final Modifier modifier2;
        final boolean z6;
        final long j7;
        final long j8;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-350627181);
        ComposerKt.sourceInformation(startRestartGroup, "C(Tab)P(5,4,3!1,7!1,6:c#ui.graphics.Color,8:c#ui.graphics.Color)99@4483L7,121@5133L65,113@4964L234:Tab.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z3 = z;
        } else {
            z3 = z;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changed(z3) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 48) == 0) {
                i3 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
            }
        }
        int i14 = i2 & 4;
        if (i14 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z4 = z2;
                i3 |= startRestartGroup.changed(z4) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    obj = function2;
                    i3 |= startRestartGroup.changedInstance(obj) ? 16384 : 8192;
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((196608 & i) == 0) {
                        obj2 = function22;
                        i3 |= startRestartGroup.changedInstance(obj2) ? 131072 : 65536;
                        if ((1572864 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                i12 = i3;
                                i8 = i14;
                                if (startRestartGroup.changed(j)) {
                                    i13 = 1048576;
                                    i7 = i12 | i13;
                                }
                            } else {
                                i12 = i3;
                                i8 = i14;
                            }
                            i13 = 524288;
                            i7 = i12 | i13;
                        } else {
                            i7 = i3;
                            i8 = i14;
                        }
                        if ((i & 12582912) == 0) {
                            i7 |= ((i2 & 128) == 0 && startRestartGroup.changed(j2)) ? 8388608 : 4194304;
                        }
                        i9 = i2 & 256;
                        if (i9 != 0) {
                            i7 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i10 = i9;
                            i7 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                            if ((i7 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i8 != 0) {
                                        companion = Modifier.Companion;
                                    }
                                    if (i4 != 0) {
                                        z4 = true;
                                    }
                                    if (i5 != 0) {
                                        obj = null;
                                    }
                                    if (i6 != 0) {
                                        obj2 = null;
                                    }
                                    if ((i2 & 64) == 0) {
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object consume = startRestartGroup.consume(ContentColorKt.getLocalContentColor());
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        j3 = ((Color) consume).m4088unboximpl();
                                        i7 &= -3670017;
                                    } else {
                                        j3 = j;
                                    }
                                    if ((i2 & 128) == 0) {
                                        i7 &= -29360129;
                                        j4 = j3;
                                    } else {
                                        j4 = j2;
                                    }
                                    z5 = z4;
                                    composableLambda = null;
                                    if (i10 == 0) {
                                        i11 = -350627181;
                                        j5 = j3;
                                        j6 = j4;
                                        mutableInteractionSource2 = null;
                                    } else {
                                        j5 = j3;
                                        j6 = j4;
                                        i11 = -350627181;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 64) != 0) {
                                        i7 &= -3670017;
                                    }
                                    if ((i2 & 128) != 0) {
                                        i7 &= -29360129;
                                    }
                                    j6 = j2;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    z5 = z4;
                                    composableLambda = null;
                                    i11 = -350627181;
                                    j5 = j;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i11, i7, -1, "androidx.compose.material3.Tab (Tab.kt:102)");
                                }
                                startRestartGroup.startReplaceGroup(79583089);
                                ComposerKt.sourceInformation(startRestartGroup, "*105@4702L247");
                                if (obj != null) {
                                    composableLambda = ComposableLambdaKt.rememberComposableLambda(708874428, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$styledText$1$1
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

                                        public final void invoke(Composer composer3, int i15) {
                                            ComposerKt.sourceInformation(composer3, "C107@4793L5,110@4896L39:Tab.kt#uh7d8r");
                                            if ((i15 & 3) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(708874428, i15, -1, "androidx.compose.material3.Tab.<anonymous>.<anonymous> (Tab.kt:106)");
                                                }
                                                TextKt.ProvideTextStyle(TextStyle.m6160copyp1EtxEg$default(TypographyKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getLabelTextFont(), composer3, 6), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.Companion.m6568getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), obj, composer3, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }, startRestartGroup, 54);
                                }
                                startRestartGroup.endReplaceGroup();
                                int i15 = i7 >> 6;
                                composer2 = startRestartGroup;
                                Modifier modifier3 = companion;
                                m2382TabbogVsAg(z3, function02, modifier3, z5, j5, j6, mutableInteractionSource2, ComposableLambdaKt.rememberComposableLambda(1540996038, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                                        invoke(columnScope, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ColumnScope columnScope, Composer composer3, int i16) {
                                        ComposerKt.sourceInformation(composer3, "C122@5143L49:Tab.kt#uh7d8r");
                                        if ((i16 & 17) == 16 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1540996038, i16, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:122)");
                                        }
                                        TabKt.TabBaselineLayout(composableLambda, obj2, composer3, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, startRestartGroup, 54), composer2, (i7 & 14) | 12582912 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (57344 & i15) | (458752 & i15) | (i15 & 3670016), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function23 = obj;
                                function24 = obj2;
                                modifier2 = modifier3;
                                z6 = z5;
                                j7 = j5;
                                j8 = j6;
                                mutableInteractionSource3 = mutableInteractionSource2;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                mutableInteractionSource3 = mutableInteractionSource;
                                composer2 = startRestartGroup;
                                modifier2 = companion;
                                z6 = z4;
                                function23 = obj;
                                function24 = obj2;
                                j7 = j;
                                j8 = j2;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$2
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
                                        TabKt.m2383TabwqdebIU(z, function0, modifier2, z6, function23, function24, j7, j8, mutableInteractionSource3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i10 = i9;
                        if ((i7 & 38347923) == 38347922) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i4 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if ((i2 & 64) == 0) {
                        }
                        if ((i2 & 128) == 0) {
                        }
                        z5 = z4;
                        composableLambda = null;
                        if (i10 == 0) {
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceGroup(79583089);
                        ComposerKt.sourceInformation(startRestartGroup, "*105@4702L247");
                        if (obj != null) {
                        }
                        startRestartGroup.endReplaceGroup();
                        int i152 = i7 >> 6;
                        composer2 = startRestartGroup;
                        Modifier modifier32 = companion;
                        m2382TabbogVsAg(z3, function02, modifier32, z5, j5, j6, mutableInteractionSource2, ComposableLambdaKt.rememberComposableLambda(1540996038, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                                invoke(columnScope, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ColumnScope columnScope, Composer composer3, int i16) {
                                ComposerKt.sourceInformation(composer3, "C122@5143L49:Tab.kt#uh7d8r");
                                if ((i16 & 17) == 16 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1540996038, i16, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:122)");
                                }
                                TabKt.TabBaselineLayout(composableLambda, obj2, composer3, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54), composer2, (i7 & 14) | 12582912 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (57344 & i152) | (458752 & i152) | (i152 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function23 = obj;
                        function24 = obj2;
                        modifier2 = modifier32;
                        z6 = z5;
                        j7 = j5;
                        j8 = j6;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    obj2 = function22;
                    if ((1572864 & i) == 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    i9 = i2 & 256;
                    if (i9 != 0) {
                    }
                    i10 = i9;
                    if ((i7 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i2 & 64) == 0) {
                    }
                    if ((i2 & 128) == 0) {
                    }
                    z5 = z4;
                    composableLambda = null;
                    if (i10 == 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceGroup(79583089);
                    ComposerKt.sourceInformation(startRestartGroup, "*105@4702L247");
                    if (obj != null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    int i1522 = i7 >> 6;
                    composer2 = startRestartGroup;
                    Modifier modifier322 = companion;
                    m2382TabbogVsAg(z3, function02, modifier322, z5, j5, j6, mutableInteractionSource2, ComposableLambdaKt.rememberComposableLambda(1540996038, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                            invoke(columnScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ColumnScope columnScope, Composer composer3, int i16) {
                            ComposerKt.sourceInformation(composer3, "C122@5143L49:Tab.kt#uh7d8r");
                            if ((i16 & 17) == 16 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1540996038, i16, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:122)");
                            }
                            TabKt.TabBaselineLayout(composableLambda, obj2, composer3, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), composer2, (i7 & 14) | 12582912 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (57344 & i1522) | (458752 & i1522) | (i1522 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function23 = obj;
                    function24 = obj2;
                    modifier2 = modifier322;
                    z6 = z5;
                    j7 = j5;
                    j8 = j6;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj = function2;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                obj2 = function22;
                if ((1572864 & i) == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i9 = i2 & 256;
                if (i9 != 0) {
                }
                i10 = i9;
                if ((i7 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i8 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if ((i2 & 64) == 0) {
                }
                if ((i2 & 128) == 0) {
                }
                z5 = z4;
                composableLambda = null;
                if (i10 == 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceGroup(79583089);
                ComposerKt.sourceInformation(startRestartGroup, "*105@4702L247");
                if (obj != null) {
                }
                startRestartGroup.endReplaceGroup();
                int i15222 = i7 >> 6;
                composer2 = startRestartGroup;
                Modifier modifier3222 = companion;
                m2382TabbogVsAg(z3, function02, modifier3222, z5, j5, j6, mutableInteractionSource2, ComposableLambdaKt.rememberComposableLambda(1540996038, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                        invoke(columnScope, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ColumnScope columnScope, Composer composer3, int i16) {
                        ComposerKt.sourceInformation(composer3, "C122@5143L49:Tab.kt#uh7d8r");
                        if ((i16 & 17) == 16 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1540996038, i16, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:122)");
                        }
                        TabKt.TabBaselineLayout(composableLambda, obj2, composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), composer2, (i7 & 14) | 12582912 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (57344 & i15222) | (458752 & i15222) | (i15222 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                function23 = obj;
                function24 = obj2;
                modifier2 = modifier3222;
                z6 = z5;
                j7 = j5;
                j8 = j6;
                mutableInteractionSource3 = mutableInteractionSource2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z4 = z2;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            obj = function2;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            obj2 = function22;
            if ((1572864 & i) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i9 = i2 & 256;
            if (i9 != 0) {
            }
            i10 = i9;
            if ((i7 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i8 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if ((i2 & 64) == 0) {
            }
            if ((i2 & 128) == 0) {
            }
            z5 = z4;
            composableLambda = null;
            if (i10 == 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceGroup(79583089);
            ComposerKt.sourceInformation(startRestartGroup, "*105@4702L247");
            if (obj != null) {
            }
            startRestartGroup.endReplaceGroup();
            int i152222 = i7 >> 6;
            composer2 = startRestartGroup;
            Modifier modifier32222 = companion;
            m2382TabbogVsAg(z3, function02, modifier32222, z5, j5, j6, mutableInteractionSource2, ComposableLambdaKt.rememberComposableLambda(1540996038, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope columnScope, Composer composer3, int i16) {
                    ComposerKt.sourceInformation(composer3, "C122@5143L49:Tab.kt#uh7d8r");
                    if ((i16 & 17) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1540996038, i16, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:122)");
                    }
                    TabKt.TabBaselineLayout(composableLambda, obj2, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), composer2, (i7 & 14) | 12582912 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (57344 & i152222) | (458752 & i152222) | (i152222 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            function23 = obj;
            function24 = obj2;
            modifier2 = modifier32222;
            z6 = z5;
            j7 = j5;
            j8 = j6;
            mutableInteractionSource3 = mutableInteractionSource2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        companion = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z4 = z2;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        obj = function2;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        obj2 = function22;
        if ((1572864 & i) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i9 = i2 & 256;
        if (i9 != 0) {
        }
        i10 = i9;
        if ((i7 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if ((i2 & 128) == 0) {
        }
        z5 = z4;
        composableLambda = null;
        if (i10 == 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(79583089);
        ComposerKt.sourceInformation(startRestartGroup, "*105@4702L247");
        if (obj != null) {
        }
        startRestartGroup.endReplaceGroup();
        int i1522222 = i7 >> 6;
        composer2 = startRestartGroup;
        Modifier modifier322222 = companion;
        m2382TabbogVsAg(z3, function02, modifier322222, z5, j5, j6, mutableInteractionSource2, ComposableLambdaKt.rememberComposableLambda(1540996038, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                invoke(columnScope, composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ColumnScope columnScope, Composer composer3, int i16) {
                ComposerKt.sourceInformation(composer3, "C122@5143L49:Tab.kt#uh7d8r");
                if ((i16 & 17) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1540996038, i16, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:122)");
                }
                TabKt.TabBaselineLayout(composableLambda, obj2, composer3, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), composer2, (i7 & 14) | 12582912 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (57344 & i1522222) | (458752 & i1522222) | (i1522222 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        function23 = obj;
        function24 = obj2;
        modifier2 = modifier322222;
        z6 = z5;
        j7 = j5;
        j8 = j6;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fc  */
    /* renamed from: LeadingIconTab-wqdebIU  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2381LeadingIconTabwqdebIU(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Modifier modifier, boolean z2, long j, long j2, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        final boolean z3;
        int i3;
        final Function0<Unit> function02;
        Object obj;
        int i4;
        Modifier.Companion companion;
        int i5;
        boolean z4;
        long j3;
        int i6;
        int i7;
        int i8;
        long j4;
        final MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        final Modifier modifier2;
        final MutableInteractionSource mutableInteractionSource3;
        final boolean z5;
        final long j5;
        final long j6;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-777316544);
        ComposerKt.sourceInformation(startRestartGroup, "C(LeadingIconTab)P(5,4,7,1,3!1,6:c#ui.graphics.Color,8:c#ui.graphics.Color)164@7036L7,171@7399L76,173@7551L950,173@7481L1020:Tab.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z3 = z;
        } else {
            z3 = z;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changed(z3) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 48) == 0) {
                i3 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
            }
        }
        if ((i2 & 4) != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                obj = function22;
                i3 |= startRestartGroup.changedInstance(obj) ? 2048 : 1024;
                i4 = i2 & 16;
                if (i4 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    companion = modifier;
                    i3 |= startRestartGroup.changed(companion) ? 16384 : 8192;
                    i5 = i2 & 32;
                    if (i5 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((196608 & i) == 0) {
                        z4 = z2;
                        i3 |= startRestartGroup.changed(z4) ? 131072 : 65536;
                        if ((1572864 & i) == 0) {
                            j3 = j;
                            i3 |= ((i2 & 64) == 0 && startRestartGroup.changed(j3)) ? 1048576 : 524288;
                        } else {
                            j3 = j;
                        }
                        if ((12582912 & i) == 0) {
                            i6 = i3 | (((i2 & 128) == 0 && startRestartGroup.changed(j2)) ? 8388608 : 4194304);
                        } else {
                            i6 = i3;
                        }
                        i7 = i2 & 256;
                        if (i7 != 0) {
                            i6 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i8 = i7;
                            i6 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                            if ((i6 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i4 != 0) {
                                        companion = Modifier.Companion;
                                    }
                                    if (i5 != 0) {
                                        z4 = true;
                                    }
                                    if ((i2 & 64) != 0) {
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object consume = startRestartGroup.consume(ContentColorKt.getLocalContentColor());
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        j3 = ((Color) consume).m4088unboximpl();
                                        i6 &= -3670017;
                                    }
                                    if ((i2 & 128) == 0) {
                                        i6 &= -29360129;
                                        j4 = j3;
                                    } else {
                                        j4 = j2;
                                    }
                                    if (i8 != 0) {
                                        mutableInteractionSource2 = null;
                                        final boolean z6 = z4;
                                        int i9 = i6;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-777316544, i9, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:167)");
                                        }
                                        long j7 = j3;
                                        final Indication m2211rippleOrFallbackImplementation9IZ8Weo = RippleKt.m2211rippleOrFallbackImplementation9IZ8Weo(true, 0.0f, j7, startRestartGroup, ((i9 >> 12) & 896) | 6, 2);
                                        composer2 = startRestartGroup;
                                        final Function2<? super Composer, ? super Integer, Unit> function23 = obj;
                                        final Modifier modifier3 = companion;
                                        int i10 = i9 >> 18;
                                        m2384TabTransitionKlgxPg(j7, j4, z, ComposableLambdaKt.rememberComposableLambda(-429037564, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$LeadingIconTab$1
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

                                            public final void invoke(Composer composer3, int i11) {
                                                float f;
                                                float f2;
                                                ComposerKt.sourceInformation(composer3, "C174@7561L934:Tab.kt#uh7d8r");
                                                if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-429037564, i11, -1, "androidx.compose.material3.LeadingIconTab.<anonymous> (Tab.kt:174)");
                                                    }
                                                    Modifier modifier4 = Modifier.this;
                                                    f = TabKt.SmallTabHeight;
                                                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m740paddingVpY3zN4$default(SelectableKt.m1000selectableO2vRcR0(SizeKt.m771height3ABfNKs(modifier4, f), z3, mutableInteractionSource2, m2211rippleOrFallbackImplementation9IZ8Weo, z6, Role.m5904boximpl(Role.Companion.m5918getTabo7Vup1c()), function02), TabKt.getHorizontalTextPadding(), 0.0f, 2, null), 0.0f, 1, null);
                                                    Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                                                    Function2<Composer, Integer, Unit> function24 = function23;
                                                    Function2<Composer, Integer, Unit> function25 = function2;
                                                    ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), centerVertically, composer3, 54);
                                                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, fillMaxWidth$default);
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                    if (!(composer3.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer3.startReusableNode();
                                                    if (composer3.getInserting()) {
                                                        composer3.createNode(constructor);
                                                    } else {
                                                        composer3.useNode();
                                                    }
                                                    Composer m3520constructorimpl = Updater.m3520constructorimpl(composer3);
                                                    Updater.m3527setimpl(m3520constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                    Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                    if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                    ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer3, 2028967152, "C191@8233L6,192@8252L59,194@8393L5,195@8446L39:Tab.kt#uh7d8r");
                                                    function24.invoke(composer3, 0);
                                                    f2 = TabKt.TextDistanceFromLeadingIcon;
                                                    SpacerKt.Spacer(SizeKt.m782requiredWidth3ABfNKs(Modifier.Companion, f2), composer3, 6);
                                                    TextKt.ProvideTextStyle(TextStyle.m6160copyp1EtxEg$default(TypographyKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getLabelTextFont(), composer3, 6), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.Companion.m6568getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function25, composer3, 0);
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    composer3.endNode();
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }, composer2, 54), composer2, ((i9 << 6) & 896) | (i10 & 112) | (i10 & 14) | 3072);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        modifier2 = modifier3;
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                        z5 = z6;
                                        j5 = j7;
                                        j6 = j4;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 64) != 0) {
                                        i6 &= -3670017;
                                    }
                                    if ((i2 & 128) != 0) {
                                        i6 &= -29360129;
                                    }
                                    j4 = j2;
                                }
                                mutableInteractionSource2 = mutableInteractionSource;
                                final boolean z62 = z4;
                                int i92 = i6;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                long j72 = j3;
                                final Indication m2211rippleOrFallbackImplementation9IZ8Weo2 = RippleKt.m2211rippleOrFallbackImplementation9IZ8Weo(true, 0.0f, j72, startRestartGroup, ((i92 >> 12) & 896) | 6, 2);
                                composer2 = startRestartGroup;
                                final Function2<? super Composer, ? super Integer, Unit> function232 = obj;
                                final Modifier modifier32 = companion;
                                int i102 = i92 >> 18;
                                m2384TabTransitionKlgxPg(j72, j4, z, ComposableLambdaKt.rememberComposableLambda(-429037564, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$LeadingIconTab$1
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

                                    public final void invoke(Composer composer3, int i11) {
                                        float f;
                                        float f2;
                                        ComposerKt.sourceInformation(composer3, "C174@7561L934:Tab.kt#uh7d8r");
                                        if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-429037564, i11, -1, "androidx.compose.material3.LeadingIconTab.<anonymous> (Tab.kt:174)");
                                            }
                                            Modifier modifier4 = Modifier.this;
                                            f = TabKt.SmallTabHeight;
                                            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m740paddingVpY3zN4$default(SelectableKt.m1000selectableO2vRcR0(SizeKt.m771height3ABfNKs(modifier4, f), z3, mutableInteractionSource2, m2211rippleOrFallbackImplementation9IZ8Weo2, z62, Role.m5904boximpl(Role.Companion.m5918getTabo7Vup1c()), function02), TabKt.getHorizontalTextPadding(), 0.0f, 2, null), 0.0f, 1, null);
                                            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                                            Function2<Composer, Integer, Unit> function24 = function232;
                                            Function2<Composer, Integer, Unit> function25 = function2;
                                            ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), centerVertically, composer3, 54);
                                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, fillMaxWidth$default);
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor);
                                            } else {
                                                composer3.useNode();
                                            }
                                            Composer m3520constructorimpl = Updater.m3520constructorimpl(composer3);
                                            Updater.m3527setimpl(m3520constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2028967152, "C191@8233L6,192@8252L59,194@8393L5,195@8446L39:Tab.kt#uh7d8r");
                                            function24.invoke(composer3, 0);
                                            f2 = TabKt.TextDistanceFromLeadingIcon;
                                            SpacerKt.Spacer(SizeKt.m782requiredWidth3ABfNKs(Modifier.Companion, f2), composer3, 6);
                                            TextKt.ProvideTextStyle(TextStyle.m6160copyp1EtxEg$default(TypographyKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getLabelTextFont(), composer3, 6), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.Companion.m6568getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function25, composer3, 0);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            composer3.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, composer2, 54), composer2, ((i92 << 6) & 896) | (i102 & 112) | (i102 & 14) | 3072);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                modifier2 = modifier32;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                z5 = z62;
                                j5 = j72;
                                j6 = j4;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                mutableInteractionSource3 = mutableInteractionSource;
                                modifier2 = companion;
                                z5 = z4;
                                j5 = j3;
                                j6 = j2;
                                composer2 = startRestartGroup;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$LeadingIconTab$2
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

                                    public final void invoke(Composer composer3, int i11) {
                                        TabKt.m2381LeadingIconTabwqdebIU(z, function0, function2, function22, modifier2, z5, j5, j6, mutableInteractionSource3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i8 = i7;
                        if ((i6 & 38347923) == 38347922) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i4 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if ((i2 & 64) != 0) {
                        }
                        if ((i2 & 128) == 0) {
                        }
                        if (i8 != 0) {
                        }
                        mutableInteractionSource2 = mutableInteractionSource;
                        final boolean z622 = z4;
                        int i922 = i6;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        long j722 = j3;
                        final Indication m2211rippleOrFallbackImplementation9IZ8Weo22 = RippleKt.m2211rippleOrFallbackImplementation9IZ8Weo(true, 0.0f, j722, startRestartGroup, ((i922 >> 12) & 896) | 6, 2);
                        composer2 = startRestartGroup;
                        final Function2<? super Composer, ? super Integer, Unit> function2322 = obj;
                        final Modifier modifier322 = companion;
                        int i1022 = i922 >> 18;
                        m2384TabTransitionKlgxPg(j722, j4, z, ComposableLambdaKt.rememberComposableLambda(-429037564, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$LeadingIconTab$1
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

                            public final void invoke(Composer composer3, int i11) {
                                float f;
                                float f2;
                                ComposerKt.sourceInformation(composer3, "C174@7561L934:Tab.kt#uh7d8r");
                                if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-429037564, i11, -1, "androidx.compose.material3.LeadingIconTab.<anonymous> (Tab.kt:174)");
                                    }
                                    Modifier modifier4 = Modifier.this;
                                    f = TabKt.SmallTabHeight;
                                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m740paddingVpY3zN4$default(SelectableKt.m1000selectableO2vRcR0(SizeKt.m771height3ABfNKs(modifier4, f), z3, mutableInteractionSource2, m2211rippleOrFallbackImplementation9IZ8Weo22, z622, Role.m5904boximpl(Role.Companion.m5918getTabo7Vup1c()), function02), TabKt.getHorizontalTextPadding(), 0.0f, 2, null), 0.0f, 1, null);
                                    Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function24 = function2322;
                                    Function2<Composer, Integer, Unit> function25 = function2;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), centerVertically, composer3, 54);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, fillMaxWidth$default);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m3520constructorimpl = Updater.m3520constructorimpl(composer3);
                                    Updater.m3527setimpl(m3520constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 2028967152, "C191@8233L6,192@8252L59,194@8393L5,195@8446L39:Tab.kt#uh7d8r");
                                    function24.invoke(composer3, 0);
                                    f2 = TabKt.TextDistanceFromLeadingIcon;
                                    SpacerKt.Spacer(SizeKt.m782requiredWidth3ABfNKs(Modifier.Companion, f2), composer3, 6);
                                    TextKt.ProvideTextStyle(TextStyle.m6160copyp1EtxEg$default(TypographyKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getLabelTextFont(), composer3, 6), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.Companion.m6568getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function25, composer3, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }, composer2, 54), composer2, ((i922 << 6) & 896) | (i1022 & 112) | (i1022 & 14) | 3072);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier2 = modifier322;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        z5 = z622;
                        j5 = j722;
                        j6 = j4;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    z4 = z2;
                    if ((1572864 & i) == 0) {
                    }
                    if ((12582912 & i) == 0) {
                    }
                    i7 = i2 & 256;
                    if (i7 != 0) {
                    }
                    i8 = i7;
                    if ((i6 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if ((i2 & 128) == 0) {
                    }
                    if (i8 != 0) {
                    }
                    mutableInteractionSource2 = mutableInteractionSource;
                    final boolean z6222 = z4;
                    int i9222 = i6;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    long j7222 = j3;
                    final Indication m2211rippleOrFallbackImplementation9IZ8Weo222 = RippleKt.m2211rippleOrFallbackImplementation9IZ8Weo(true, 0.0f, j7222, startRestartGroup, ((i9222 >> 12) & 896) | 6, 2);
                    composer2 = startRestartGroup;
                    final Function2<? super Composer, ? super Integer, Unit> function23222 = obj;
                    final Modifier modifier3222 = companion;
                    int i10222 = i9222 >> 18;
                    m2384TabTransitionKlgxPg(j7222, j4, z, ComposableLambdaKt.rememberComposableLambda(-429037564, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$LeadingIconTab$1
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

                        public final void invoke(Composer composer3, int i11) {
                            float f;
                            float f2;
                            ComposerKt.sourceInformation(composer3, "C174@7561L934:Tab.kt#uh7d8r");
                            if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-429037564, i11, -1, "androidx.compose.material3.LeadingIconTab.<anonymous> (Tab.kt:174)");
                                }
                                Modifier modifier4 = Modifier.this;
                                f = TabKt.SmallTabHeight;
                                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m740paddingVpY3zN4$default(SelectableKt.m1000selectableO2vRcR0(SizeKt.m771height3ABfNKs(modifier4, f), z3, mutableInteractionSource2, m2211rippleOrFallbackImplementation9IZ8Weo222, z6222, Role.m5904boximpl(Role.Companion.m5918getTabo7Vup1c()), function02), TabKt.getHorizontalTextPadding(), 0.0f, 2, null), 0.0f, 1, null);
                                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                                Function2<Composer, Integer, Unit> function24 = function23222;
                                Function2<Composer, Integer, Unit> function25 = function2;
                                ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), centerVertically, composer3, 54);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, fillMaxWidth$default);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m3520constructorimpl = Updater.m3520constructorimpl(composer3);
                                Updater.m3527setimpl(m3520constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, 2028967152, "C191@8233L6,192@8252L59,194@8393L5,195@8446L39:Tab.kt#uh7d8r");
                                function24.invoke(composer3, 0);
                                f2 = TabKt.TextDistanceFromLeadingIcon;
                                SpacerKt.Spacer(SizeKt.m782requiredWidth3ABfNKs(Modifier.Companion, f2), composer3, 6);
                                TextKt.ProvideTextStyle(TextStyle.m6160copyp1EtxEg$default(TypographyKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getLabelTextFont(), composer3, 6), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.Companion.m6568getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function25, composer3, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }, composer2, 54), composer2, ((i9222 << 6) & 896) | (i10222 & 112) | (i10222 & 14) | 3072);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier2 = modifier3222;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    z5 = z6222;
                    j5 = j7222;
                    j6 = j4;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                companion = modifier;
                i5 = i2 & 32;
                if (i5 == 0) {
                }
                z4 = z2;
                if ((1572864 & i) == 0) {
                }
                if ((12582912 & i) == 0) {
                }
                i7 = i2 & 256;
                if (i7 != 0) {
                }
                i8 = i7;
                if ((i6 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if ((i2 & 128) == 0) {
                }
                if (i8 != 0) {
                }
                mutableInteractionSource2 = mutableInteractionSource;
                final boolean z62222 = z4;
                int i92222 = i6;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                long j72222 = j3;
                final Indication m2211rippleOrFallbackImplementation9IZ8Weo2222 = RippleKt.m2211rippleOrFallbackImplementation9IZ8Weo(true, 0.0f, j72222, startRestartGroup, ((i92222 >> 12) & 896) | 6, 2);
                composer2 = startRestartGroup;
                final Function2<? super Composer, ? super Integer, Unit> function232222 = obj;
                final Modifier modifier32222 = companion;
                int i102222 = i92222 >> 18;
                m2384TabTransitionKlgxPg(j72222, j4, z, ComposableLambdaKt.rememberComposableLambda(-429037564, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$LeadingIconTab$1
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

                    public final void invoke(Composer composer3, int i11) {
                        float f;
                        float f2;
                        ComposerKt.sourceInformation(composer3, "C174@7561L934:Tab.kt#uh7d8r");
                        if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-429037564, i11, -1, "androidx.compose.material3.LeadingIconTab.<anonymous> (Tab.kt:174)");
                            }
                            Modifier modifier4 = Modifier.this;
                            f = TabKt.SmallTabHeight;
                            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m740paddingVpY3zN4$default(SelectableKt.m1000selectableO2vRcR0(SizeKt.m771height3ABfNKs(modifier4, f), z3, mutableInteractionSource2, m2211rippleOrFallbackImplementation9IZ8Weo2222, z62222, Role.m5904boximpl(Role.Companion.m5918getTabo7Vup1c()), function02), TabKt.getHorizontalTextPadding(), 0.0f, 2, null), 0.0f, 1, null);
                            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                            Function2<Composer, Integer, Unit> function24 = function232222;
                            Function2<Composer, Integer, Unit> function25 = function2;
                            ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), centerVertically, composer3, 54);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, fillMaxWidth$default);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor);
                            } else {
                                composer3.useNode();
                            }
                            Composer m3520constructorimpl = Updater.m3520constructorimpl(composer3);
                            Updater.m3527setimpl(m3520constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, 2028967152, "C191@8233L6,192@8252L59,194@8393L5,195@8446L39:Tab.kt#uh7d8r");
                            function24.invoke(composer3, 0);
                            f2 = TabKt.TextDistanceFromLeadingIcon;
                            SpacerKt.Spacer(SizeKt.m782requiredWidth3ABfNKs(Modifier.Companion, f2), composer3, 6);
                            TextKt.ProvideTextStyle(TextStyle.m6160copyp1EtxEg$default(TypographyKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getLabelTextFont(), composer3, 6), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.Companion.m6568getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function25, composer3, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }, composer2, 54), composer2, ((i92222 << 6) & 896) | (i102222 & 112) | (i102222 & 14) | 3072);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = modifier32222;
                mutableInteractionSource3 = mutableInteractionSource2;
                z5 = z62222;
                j5 = j72222;
                j6 = j4;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            obj = function22;
            i4 = i2 & 16;
            if (i4 != 0) {
            }
            companion = modifier;
            i5 = i2 & 32;
            if (i5 == 0) {
            }
            z4 = z2;
            if ((1572864 & i) == 0) {
            }
            if ((12582912 & i) == 0) {
            }
            i7 = i2 & 256;
            if (i7 != 0) {
            }
            i8 = i7;
            if ((i6 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i2 & 128) == 0) {
            }
            if (i8 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            final boolean z622222 = z4;
            int i922222 = i6;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            long j722222 = j3;
            final Indication m2211rippleOrFallbackImplementation9IZ8Weo22222 = RippleKt.m2211rippleOrFallbackImplementation9IZ8Weo(true, 0.0f, j722222, startRestartGroup, ((i922222 >> 12) & 896) | 6, 2);
            composer2 = startRestartGroup;
            final Function2<? super Composer, ? super Integer, Unit> function2322222 = obj;
            final Modifier modifier322222 = companion;
            int i1022222 = i922222 >> 18;
            m2384TabTransitionKlgxPg(j722222, j4, z, ComposableLambdaKt.rememberComposableLambda(-429037564, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$LeadingIconTab$1
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

                public final void invoke(Composer composer3, int i11) {
                    float f;
                    float f2;
                    ComposerKt.sourceInformation(composer3, "C174@7561L934:Tab.kt#uh7d8r");
                    if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-429037564, i11, -1, "androidx.compose.material3.LeadingIconTab.<anonymous> (Tab.kt:174)");
                        }
                        Modifier modifier4 = Modifier.this;
                        f = TabKt.SmallTabHeight;
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m740paddingVpY3zN4$default(SelectableKt.m1000selectableO2vRcR0(SizeKt.m771height3ABfNKs(modifier4, f), z3, mutableInteractionSource2, m2211rippleOrFallbackImplementation9IZ8Weo22222, z622222, Role.m5904boximpl(Role.Companion.m5918getTabo7Vup1c()), function02), TabKt.getHorizontalTextPadding(), 0.0f, 2, null), 0.0f, 1, null);
                        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                        Function2<Composer, Integer, Unit> function24 = function2322222;
                        Function2<Composer, Integer, Unit> function25 = function2;
                        ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), centerVertically, composer3, 54);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, fillMaxWidth$default);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer m3520constructorimpl = Updater.m3520constructorimpl(composer3);
                        Updater.m3527setimpl(m3520constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 2028967152, "C191@8233L6,192@8252L59,194@8393L5,195@8446L39:Tab.kt#uh7d8r");
                        function24.invoke(composer3, 0);
                        f2 = TabKt.TextDistanceFromLeadingIcon;
                        SpacerKt.Spacer(SizeKt.m782requiredWidth3ABfNKs(Modifier.Companion, f2), composer3, 6);
                        TextKt.ProvideTextStyle(TextStyle.m6160copyp1EtxEg$default(TypographyKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getLabelTextFont(), composer3, 6), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.Companion.m6568getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function25, composer3, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, composer2, 54), composer2, ((i922222 << 6) & 896) | (i1022222 & 112) | (i1022222 & 14) | 3072);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier322222;
            mutableInteractionSource3 = mutableInteractionSource2;
            z5 = z622222;
            j5 = j722222;
            j6 = j4;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i2 & 8) == 0) {
        }
        obj = function22;
        i4 = i2 & 16;
        if (i4 != 0) {
        }
        companion = modifier;
        i5 = i2 & 32;
        if (i5 == 0) {
        }
        z4 = z2;
        if ((1572864 & i) == 0) {
        }
        if ((12582912 & i) == 0) {
        }
        i7 = i2 & 256;
        if (i7 != 0) {
        }
        i8 = i7;
        if ((i6 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i2 & 128) == 0) {
        }
        if (i8 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        final boolean z6222222 = z4;
        int i9222222 = i6;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        long j7222222 = j3;
        final Indication m2211rippleOrFallbackImplementation9IZ8Weo222222 = RippleKt.m2211rippleOrFallbackImplementation9IZ8Weo(true, 0.0f, j7222222, startRestartGroup, ((i9222222 >> 12) & 896) | 6, 2);
        composer2 = startRestartGroup;
        final Function2<? super Composer, ? super Integer, Unit> function23222222 = obj;
        final Modifier modifier3222222 = companion;
        int i10222222 = i9222222 >> 18;
        m2384TabTransitionKlgxPg(j7222222, j4, z, ComposableLambdaKt.rememberComposableLambda(-429037564, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$LeadingIconTab$1
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

            public final void invoke(Composer composer3, int i11) {
                float f;
                float f2;
                ComposerKt.sourceInformation(composer3, "C174@7561L934:Tab.kt#uh7d8r");
                if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-429037564, i11, -1, "androidx.compose.material3.LeadingIconTab.<anonymous> (Tab.kt:174)");
                    }
                    Modifier modifier4 = Modifier.this;
                    f = TabKt.SmallTabHeight;
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m740paddingVpY3zN4$default(SelectableKt.m1000selectableO2vRcR0(SizeKt.m771height3ABfNKs(modifier4, f), z3, mutableInteractionSource2, m2211rippleOrFallbackImplementation9IZ8Weo222222, z6222222, Role.m5904boximpl(Role.Companion.m5918getTabo7Vup1c()), function02), TabKt.getHorizontalTextPadding(), 0.0f, 2, null), 0.0f, 1, null);
                    Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                    Function2<Composer, Integer, Unit> function24 = function23222222;
                    Function2<Composer, Integer, Unit> function25 = function2;
                    ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), centerVertically, composer3, 54);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, fillMaxWidth$default);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    Composer m3520constructorimpl = Updater.m3520constructorimpl(composer3);
                    Updater.m3527setimpl(m3520constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, 2028967152, "C191@8233L6,192@8252L59,194@8393L5,195@8446L39:Tab.kt#uh7d8r");
                    function24.invoke(composer3, 0);
                    f2 = TabKt.TextDistanceFromLeadingIcon;
                    SpacerKt.Spacer(SizeKt.m782requiredWidth3ABfNKs(Modifier.Companion, f2), composer3, 6);
                    TextKt.ProvideTextStyle(TextStyle.m6160copyp1EtxEg$default(TypographyKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getLabelTextFont(), composer3, 6), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.Companion.m6568getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function25, composer3, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }, composer2, 54), composer2, ((i9222222 << 6) & 896) | (i10222222 & 112) | (i10222222 & 14) | 3072);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier3222222;
        mutableInteractionSource3 = mutableInteractionSource2;
        z5 = z6222222;
        j5 = j7222222;
        j6 = j4;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0122  */
    /* renamed from: Tab-bogVsAg  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2382TabbogVsAg(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, long j, long j2, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        boolean z3;
        int i3;
        Object obj;
        int i4;
        Modifier.Companion companion;
        int i5;
        boolean z4;
        long j3;
        long j4;
        int i6;
        int i7;
        final MutableInteractionSource mutableInteractionSource2;
        final boolean z5;
        int i8;
        final Modifier modifier2;
        long j5;
        Composer composer2;
        final long j6;
        final MutableInteractionSource mutableInteractionSource3;
        final long j7;
        final Modifier modifier3;
        final boolean z6;
        ScopeUpdateScope endRestartGroup;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(-202735880);
        ComposerKt.sourceInformation(startRestartGroup, "C(Tab)P(5,4,3,1,6:c#ui.graphics.Color,7:c#ui.graphics.Color,2)238@10306L7,246@10715L76,248@10867L600,248@10797L670:Tab.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z3 = z;
        } else {
            z3 = z;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changed(z3) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = function0;
            i3 |= startRestartGroup.changedInstance(obj) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                companion = modifier;
                i3 |= startRestartGroup.changed(companion) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    z4 = z2;
                    i3 |= startRestartGroup.changed(z4) ? 2048 : 1024;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            j3 = j;
                            if (startRestartGroup.changed(j3)) {
                                i10 = 16384;
                                i3 |= i10;
                            }
                        } else {
                            j3 = j;
                        }
                        i10 = 8192;
                        i3 |= i10;
                    } else {
                        j3 = j;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            j4 = j2;
                            if (startRestartGroup.changed(j4)) {
                                i9 = 131072;
                                i3 |= i9;
                            }
                        } else {
                            j4 = j2;
                        }
                        i9 = 65536;
                        i3 |= i9;
                    } else {
                        j4 = j2;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changed(mutableInteractionSource) ? 1048576 : 524288;
                    }
                    if ((i2 & 128) == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                        int i11 = i3;
                        if ((i3 & 4793491) == 4793490 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i4 != 0) {
                                    companion = Modifier.Companion;
                                }
                                if (i5 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object consume = startRestartGroup.consume(ContentColorKt.getLocalContentColor());
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    j3 = ((Color) consume).m4088unboximpl();
                                    i7 = i11 & (-57345);
                                } else {
                                    i7 = i11;
                                }
                                if ((i2 & 32) != 0) {
                                    i7 &= -458753;
                                    j4 = j3;
                                }
                                if (i6 != 0) {
                                    mutableInteractionSource2 = null;
                                    z5 = z4;
                                    i8 = -202735880;
                                    modifier2 = companion;
                                    j5 = j4;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(i8, i7, -1, "androidx.compose.material3.Tab (Tab.kt:242)");
                                    }
                                    final Indication m2211rippleOrFallbackImplementation9IZ8Weo = RippleKt.m2211rippleOrFallbackImplementation9IZ8Weo(true, 0.0f, j3, startRestartGroup, ((i7 >> 6) & 896) | 6, 2);
                                    final Function0<Unit> function02 = obj;
                                    final boolean z7 = z3;
                                    int i12 = i7 >> 12;
                                    m2384TabTransitionKlgxPg(j3, j5, z, ComposableLambdaKt.rememberComposableLambda(-551896140, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$3
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

                                        public final void invoke(Composer composer3, int i13) {
                                            ComposerKt.sourceInformation(composer3, "C249@10877L584:Tab.kt#uh7d8r");
                                            if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-551896140, i13, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:249)");
                                                }
                                                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SelectableKt.m1000selectableO2vRcR0(Modifier.this, z7, mutableInteractionSource2, m2211rippleOrFallbackImplementation9IZ8Weo, z5, Role.m5904boximpl(Role.Companion.m5918getTabo7Vup1c()), function02), 0.0f, 1, null);
                                                Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
                                                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                                ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer3, 54);
                                                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, fillMaxWidth$default);
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                if (!(composer3.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer3.startReusableNode();
                                                if (composer3.getInserting()) {
                                                    composer3.createNode(constructor);
                                                } else {
                                                    composer3.useNode();
                                                }
                                                Composer m3520constructorimpl = Updater.m3520constructorimpl(composer3);
                                                Updater.m3527setimpl(m3520constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                ComposerKt.sourceInformationMarkerStart(composer3, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                                                function32.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                composer3.endNode();
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }, startRestartGroup, 54), startRestartGroup, (i12 & 112) | (i12 & 14) | 3072 | ((i7 << 6) & 896));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer2 = startRestartGroup;
                                    j6 = j3;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    j7 = j5;
                                    modifier3 = modifier2;
                                    z6 = z5;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                i7 = (i2 & 16) != 0 ? i11 & (-57345) : i11;
                                if ((i2 & 32) != 0) {
                                    i7 &= -458753;
                                }
                            }
                            modifier2 = companion;
                            j5 = j4;
                            mutableInteractionSource2 = mutableInteractionSource;
                            z5 = z4;
                            i8 = -202735880;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            final Indication m2211rippleOrFallbackImplementation9IZ8Weo2 = RippleKt.m2211rippleOrFallbackImplementation9IZ8Weo(true, 0.0f, j3, startRestartGroup, ((i7 >> 6) & 896) | 6, 2);
                            final Function0<Unit> function022 = obj;
                            final boolean z72 = z3;
                            int i122 = i7 >> 12;
                            m2384TabTransitionKlgxPg(j3, j5, z, ComposableLambdaKt.rememberComposableLambda(-551896140, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$3
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

                                public final void invoke(Composer composer3, int i13) {
                                    ComposerKt.sourceInformation(composer3, "C249@10877L584:Tab.kt#uh7d8r");
                                    if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-551896140, i13, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:249)");
                                        }
                                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SelectableKt.m1000selectableO2vRcR0(Modifier.this, z72, mutableInteractionSource2, m2211rippleOrFallbackImplementation9IZ8Weo2, z5, Role.m5904boximpl(Role.Companion.m5918getTabo7Vup1c()), function022), 0.0f, 1, null);
                                        Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
                                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                        Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                        ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer3, 54);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, fillMaxWidth$default);
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor);
                                        } else {
                                            composer3.useNode();
                                        }
                                        Composer m3520constructorimpl = Updater.m3520constructorimpl(composer3);
                                        Updater.m3527setimpl(m3520constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composer3, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                                        function32.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }, startRestartGroup, 54), startRestartGroup, (i122 & 112) | (i122 & 14) | 3072 | ((i7 << 6) & 896));
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = startRestartGroup;
                            j6 = j3;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            j7 = j5;
                            modifier3 = modifier2;
                            z6 = z5;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier3 = companion;
                            composer2 = startRestartGroup;
                            z6 = z4;
                            j6 = j3;
                            j7 = j4;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$4
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

                                public final void invoke(Composer composer3, int i13) {
                                    TabKt.m2382TabbogVsAg(z, function0, modifier3, z6, j6, j7, mutableInteractionSource3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    int i112 = i3;
                    if ((i3 & 4793491) == 4793490) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    modifier2 = companion;
                    j5 = j4;
                    mutableInteractionSource2 = mutableInteractionSource;
                    z5 = z4;
                    i8 = -202735880;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final Indication m2211rippleOrFallbackImplementation9IZ8Weo22 = RippleKt.m2211rippleOrFallbackImplementation9IZ8Weo(true, 0.0f, j3, startRestartGroup, ((i7 >> 6) & 896) | 6, 2);
                    final Function0<Unit> function0222 = obj;
                    final boolean z722 = z3;
                    int i1222 = i7 >> 12;
                    m2384TabTransitionKlgxPg(j3, j5, z, ComposableLambdaKt.rememberComposableLambda(-551896140, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$3
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

                        public final void invoke(Composer composer3, int i13) {
                            ComposerKt.sourceInformation(composer3, "C249@10877L584:Tab.kt#uh7d8r");
                            if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-551896140, i13, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:249)");
                                }
                                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SelectableKt.m1000selectableO2vRcR0(Modifier.this, z722, mutableInteractionSource2, m2211rippleOrFallbackImplementation9IZ8Weo22, z5, Role.m5904boximpl(Role.Companion.m5918getTabo7Vup1c()), function0222), 0.0f, 1, null);
                                Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
                                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer3, 54);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, fillMaxWidth$default);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m3520constructorimpl = Updater.m3520constructorimpl(composer3);
                                Updater.m3527setimpl(m3520constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer3, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                                function32.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }, startRestartGroup, 54), startRestartGroup, (i1222 & 112) | (i1222 & 14) | 3072 | ((i7 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    j6 = j3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    j7 = j5;
                    modifier3 = modifier2;
                    z6 = z5;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z4 = z2;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                if ((i2 & 128) == 0) {
                }
                int i1122 = i3;
                if ((i3 & 4793491) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i6 != 0) {
                }
                modifier2 = companion;
                j5 = j4;
                mutableInteractionSource2 = mutableInteractionSource;
                z5 = z4;
                i8 = -202735880;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final Indication m2211rippleOrFallbackImplementation9IZ8Weo222 = RippleKt.m2211rippleOrFallbackImplementation9IZ8Weo(true, 0.0f, j3, startRestartGroup, ((i7 >> 6) & 896) | 6, 2);
                final Function0<Unit> function02222 = obj;
                final boolean z7222 = z3;
                int i12222 = i7 >> 12;
                m2384TabTransitionKlgxPg(j3, j5, z, ComposableLambdaKt.rememberComposableLambda(-551896140, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$3
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

                    public final void invoke(Composer composer3, int i13) {
                        ComposerKt.sourceInformation(composer3, "C249@10877L584:Tab.kt#uh7d8r");
                        if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-551896140, i13, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:249)");
                            }
                            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SelectableKt.m1000selectableO2vRcR0(Modifier.this, z7222, mutableInteractionSource2, m2211rippleOrFallbackImplementation9IZ8Weo222, z5, Role.m5904boximpl(Role.Companion.m5918getTabo7Vup1c()), function02222), 0.0f, 1, null);
                            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                            Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                            ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer3, 54);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, fillMaxWidth$default);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor);
                            } else {
                                composer3.useNode();
                            }
                            Composer m3520constructorimpl = Updater.m3520constructorimpl(composer3);
                            Updater.m3527setimpl(m3520constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                            function32.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }, startRestartGroup, 54), startRestartGroup, (i12222 & 112) | (i12222 & 14) | 3072 | ((i7 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                j6 = j3;
                mutableInteractionSource3 = mutableInteractionSource2;
                j7 = j5;
                modifier3 = modifier2;
                z6 = z5;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            companion = modifier;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            z4 = z2;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            if ((i2 & 128) == 0) {
            }
            int i11222 = i3;
            if ((i3 & 4793491) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i6 != 0) {
            }
            modifier2 = companion;
            j5 = j4;
            mutableInteractionSource2 = mutableInteractionSource;
            z5 = z4;
            i8 = -202735880;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final Indication m2211rippleOrFallbackImplementation9IZ8Weo2222 = RippleKt.m2211rippleOrFallbackImplementation9IZ8Weo(true, 0.0f, j3, startRestartGroup, ((i7 >> 6) & 896) | 6, 2);
            final Function0<Unit> function022222 = obj;
            final boolean z72222 = z3;
            int i122222 = i7 >> 12;
            m2384TabTransitionKlgxPg(j3, j5, z, ComposableLambdaKt.rememberComposableLambda(-551896140, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$3
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

                public final void invoke(Composer composer3, int i13) {
                    ComposerKt.sourceInformation(composer3, "C249@10877L584:Tab.kt#uh7d8r");
                    if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-551896140, i13, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:249)");
                        }
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SelectableKt.m1000selectableO2vRcR0(Modifier.this, z72222, mutableInteractionSource2, m2211rippleOrFallbackImplementation9IZ8Weo2222, z5, Role.m5904boximpl(Role.Companion.m5918getTabo7Vup1c()), function022222), 0.0f, 1, null);
                        Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                        Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                        ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer3, 54);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, fillMaxWidth$default);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer m3520constructorimpl = Updater.m3520constructorimpl(composer3);
                        Updater.m3527setimpl(m3520constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                        function32.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, startRestartGroup, 54), startRestartGroup, (i122222 & 112) | (i122222 & 14) | 3072 | ((i7 << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            j6 = j3;
            mutableInteractionSource3 = mutableInteractionSource2;
            j7 = j5;
            modifier3 = modifier2;
            z6 = z5;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = function0;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        companion = modifier;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        z4 = z2;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        if ((i2 & 128) == 0) {
        }
        int i112222 = i3;
        if ((i3 & 4793491) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i6 != 0) {
        }
        modifier2 = companion;
        j5 = j4;
        mutableInteractionSource2 = mutableInteractionSource;
        z5 = z4;
        i8 = -202735880;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final Indication m2211rippleOrFallbackImplementation9IZ8Weo22222 = RippleKt.m2211rippleOrFallbackImplementation9IZ8Weo(true, 0.0f, j3, startRestartGroup, ((i7 >> 6) & 896) | 6, 2);
        final Function0<Unit> function0222222 = obj;
        final boolean z722222 = z3;
        int i1222222 = i7 >> 12;
        m2384TabTransitionKlgxPg(j3, j5, z, ComposableLambdaKt.rememberComposableLambda(-551896140, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$3
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

            public final void invoke(Composer composer3, int i13) {
                ComposerKt.sourceInformation(composer3, "C249@10877L584:Tab.kt#uh7d8r");
                if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-551896140, i13, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:249)");
                    }
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SelectableKt.m1000selectableO2vRcR0(Modifier.this, z722222, mutableInteractionSource2, m2211rippleOrFallbackImplementation9IZ8Weo22222, z5, Role.m5904boximpl(Role.Companion.m5918getTabo7Vup1c()), function0222222), 0.0f, 1, null);
                    Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                    Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                    ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer3, 54);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, fillMaxWidth$default);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    Composer m3520constructorimpl = Updater.m3520constructorimpl(composer3);
                    Updater.m3527setimpl(m3520constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                    function32.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }, startRestartGroup, 54), startRestartGroup, (i1222222 & 112) | (i1222222 & 14) | 3072 | ((i7 << 6) & 896));
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        j6 = j3;
        mutableInteractionSource3 = mutableInteractionSource2;
        j7 = j5;
        modifier3 = modifier2;
        z6 = z5;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TabTransition-Klgx-Pg  reason: not valid java name */
    public static final void m2384TabTransitionKlgxPg(final long j, final long j2, boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        final boolean z2;
        Composer startRestartGroup = composer.startRestartGroup(735731848);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)280@11898L26,282@11961L548,297@12514L77:Tab.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            z2 = z;
            i2 |= startRestartGroup.changed(z2) ? 256 : 128;
        } else {
            z2 = z;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i2 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(735731848, i2, -1, "androidx.compose.material3.TabTransition (Tab.kt:279)");
            }
            int i3 = i2 >> 6;
            Transition updateTransition = TransitionKt.updateTransition(Boolean.valueOf(z2), (String) null, startRestartGroup, i3 & 14, 2);
            TabKt$TabTransition$color$2 tabKt$TabTransition$color$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.TabKt$TabTransition$color$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<Boolean> segment, Composer composer2, int i4) {
                    TweenSpec tween$default;
                    composer2.startReplaceGroup(-899623535);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-899623535, i4, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:284)");
                    }
                    if (segment.isTransitioningTo(false, true)) {
                        tween$default = AnimationSpecKt.tween(150, 100, EasingKt.getLinearEasing());
                    } else {
                        tween$default = AnimationSpecKt.tween$default(100, 0, EasingKt.getLinearEasing(), 2, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return tween$default;
                }
            };
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1939694975, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
            boolean booleanValue = ((Boolean) updateTransition.getTargetState()).booleanValue();
            startRestartGroup.startReplaceGroup(-1997025499);
            ComposerKt.sourceInformation(startRestartGroup, "C:Tab.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1997025499, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:295)");
            }
            long j3 = booleanValue ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceGroup();
            ColorSpace m4082getColorSpaceimpl = Color.m4082getColorSpaceimpl(j3);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1918408083, "CC(remember):Transition.kt#9igjgp");
            boolean changed = startRestartGroup.changed(m4082getColorSpaceimpl);
            TwoWayConverter<Color, AnimationVector4D> rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(m4082getColorSpaceimpl);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            TwoWayConverter twoWayConverter = (TwoWayConverter) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
            boolean booleanValue2 = ((Boolean) updateTransition.getCurrentState()).booleanValue();
            startRestartGroup.startReplaceGroup(-1997025499);
            ComposerKt.sourceInformation(startRestartGroup, "C:Tab.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1997025499, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:295)");
            }
            long j4 = booleanValue2 ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceGroup();
            Color m4068boximpl = Color.m4068boximpl(j4);
            boolean booleanValue3 = ((Boolean) updateTransition.getTargetState()).booleanValue();
            startRestartGroup.startReplaceGroup(-1997025499);
            ComposerKt.sourceInformation(startRestartGroup, "C:Tab.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1997025499, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:295)");
            }
            long j5 = booleanValue3 ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceGroup();
            State createTransitionAnimation = TransitionKt.createTransitionAnimation(updateTransition, m4068boximpl, Color.m4068boximpl(j5), tabKt$TabTransition$color$2.invoke((TabKt$TabTransition$color$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), twoWayConverter, "ColorAnimation", startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(TabTransition_Klgx_Pg$lambda$2(createTransitionAnimation))), function2, startRestartGroup, (i3 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$TabTransition$1
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
                    TabKt.m2384TabTransitionKlgxPg(j, j2, z2, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TabBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(514131524);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabBaselineLayout)P(1)314@13233L2042,307@12989L2286:Tab.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(514131524, i2, -1, "androidx.compose.material3.TabBaselineLayout (Tab.kt:306)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 370960155, "CC(remember):Tab.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = (i3 == 4) | ((i2 & 112) == 32);
            MeasurePolicy rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.TabKt$TabBaselineLayout$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo42measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        Placeable placeable;
                        Placeable placeable2;
                        long j2;
                        if (function2 != null) {
                            int size = list.size();
                            for (int i4 = 0; i4 < size; i4++) {
                                Measurable measurable = list.get(i4);
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "text")) {
                                    placeable = measurable.mo5438measureBRTryo0(Constraints.m6627copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                        placeable = null;
                        if (function22 != null) {
                            int size2 = list.size();
                            for (int i5 = 0; i5 < size2; i5++) {
                                Measurable measurable2 = list.get(i5);
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "icon")) {
                                    placeable2 = measurable2.mo5438measureBRTryo0(j);
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                        placeable2 = null;
                        final int max = Math.max(placeable != null ? placeable.getWidth() : 0, placeable2 != null ? placeable2.getWidth() : 0);
                        int i6 = measureScope.mo383roundToPx0680j_4((placeable == null || placeable2 == null) ? TabKt.SmallTabHeight : TabKt.LargeTabHeight);
                        int height = placeable2 != null ? placeable2.getHeight() : 0;
                        int height2 = placeable != null ? placeable.getHeight() : 0;
                        j2 = TabKt.IconDistanceFromBaseline;
                        final int max2 = Math.max(i6, height + height2 + measureScope.mo382roundToPxR2X_6o(j2));
                        final Integer valueOf = placeable != null ? Integer.valueOf(placeable.get(AlignmentLineKt.getFirstBaseline())) : null;
                        final Integer valueOf2 = placeable != null ? Integer.valueOf(placeable.get(AlignmentLineKt.getLastBaseline())) : null;
                        final Placeable placeable3 = placeable;
                        final Placeable placeable4 = placeable2;
                        return MeasureScope.layout$default(measureScope, max, max2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabKt$TabBaselineLayout$2$1.1
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
                                Placeable placeable5;
                                Placeable placeable6 = Placeable.this;
                                if (placeable6 == null || (placeable5 = placeable4) == null) {
                                    if (placeable6 != null) {
                                        TabKt.placeTextOrIcon(placementScope, placeable6, max2);
                                        return;
                                    }
                                    Placeable placeable7 = placeable4;
                                    if (placeable7 != null) {
                                        TabKt.placeTextOrIcon(placementScope, placeable7, max2);
                                        return;
                                    }
                                    return;
                                }
                                MeasureScope measureScope2 = measureScope;
                                int i7 = max;
                                int i8 = max2;
                                Integer num = valueOf;
                                Intrinsics.checkNotNull(num);
                                int intValue = num.intValue();
                                Integer num2 = valueOf2;
                                Intrinsics.checkNotNull(num2);
                                TabKt.placeTextAndIcon(placementScope, measureScope2, placeable6, placeable5, i7, i8, intValue, num2.intValue());
                            }
                        }, 4, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
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
            Updater.m3527setimpl(m3520constructorimpl, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1248753480, "C:Tab.kt#uh7d8r");
            startRestartGroup.startReplaceGroup(871566271);
            ComposerKt.sourceInformation(startRestartGroup, "309@13038L85");
            if (function2 != null) {
                Modifier m740paddingVpY3zN4$default = PaddingKt.m740paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "text"), HorizontalTextPadding, 0.0f, 2, null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m740paddingVpY3zN4$default);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3520constructorimpl2 = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 719667646, "C309@13115L6:Tab.kt#uh7d8r");
                function2.invoke(startRestartGroup, Integer.valueOf(i3));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(871570579);
            ComposerKt.sourceInformation(startRestartGroup, "312@13174L41");
            if (function22 != null) {
                Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, "icon");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3520constructorimpl3 = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 719758910, "C312@13207L6:Tab.kt#uh7d8r");
                function22.invoke(startRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            }
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$TabBaselineLayout$3
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
                    TabKt.TabBaselineLayout(function2, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeTextOrIcon(Placeable.PlacementScope placementScope, Placeable placeable, int i) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, (i - placeable.getHeight()) / 2, 0.0f, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeTextAndIcon(Placeable.PlacementScope placementScope, Density density, Placeable placeable, Placeable placeable2, int i, int i2, int i3, int i4) {
        float f;
        if (i3 == i4) {
            f = SingleLineTextBaselineWithIcon;
        } else {
            f = DoubleLineTextBaselineWithIcon;
        }
        int mo383roundToPx0680j_4 = density.mo383roundToPx0680j_4(f) + density.mo383roundToPx0680j_4(PrimaryNavigationTabTokens.INSTANCE.m3262getActiveIndicatorHeightD9Ej5fM());
        int i5 = (i2 - i4) - mo383roundToPx0680j_4;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (i - placeable.getWidth()) / 2, i5, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, (i - placeable2.getWidth()) / 2, i5 - ((placeable2.getHeight() + density.mo382roundToPxR2X_6o(IconDistanceFromBaseline)) - i3), 0.0f, 4, null);
    }

    public static final float getHorizontalTextPadding() {
        return HorizontalTextPadding;
    }

    private static final long TabTransition_Klgx_Pg$lambda$2(State<Color> state) {
        return state.getValue().m4088unboximpl();
    }
}
