package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.material3.tokens.ShapeKeyTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import io.appmetrica.analytics.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
/* compiled from: ExpressiveNavigationBar.kt */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u001aW\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020!0,¢\u0006\u0002\b-H\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a\u009d\u0001\u00100\u001a\u00020!2\u0006\u00101\u001a\u0002022\f\u00103\u001a\b\u0012\u0004\u0012\u00020!0,2\u0011\u00104\u001a\r\u0012\u0004\u0012\u00020!0,¢\u0006\u0002\b-2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u00105\u001a\u0002022\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020!\u0018\u00010,¢\u0006\u0002\b-2\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020!\u0018\u00010,¢\u0006\u0002\b-2\b\b\u0002\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=H\u0001ø\u0001\u0000¢\u0006\u0004\b>\u0010?\u001a\u0018\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020AH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u0016\u0010\u000e\u001a\u00020\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000f\u0010\u0010\"\u0016\u0010\u0011\u001a\u00020\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0010\"\u0010\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u0016\u0010\u0014\u001a\u00020\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0015\u0010\u0010\"\u0016\u0010\u0016\u001a\u00020\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0017\u0010\u0010\"\u0016\u0010\u0018\u001a\u00020\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0019\u0010\u0010\"\u0016\u0010\u001a\u001a\u00020\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001b\u0010\u0010\"\u0010\u0010\u001c\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u0010\u0010\u001d\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u0016\u0010\u001e\u001a\u00020\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001f\u0010\u0010\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006D"}, d2 = {"ActiveIconColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ActiveIndicatorColor", "ActiveIndicatorShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ActiveLabelTextColor", "IconSize", "Landroidx/compose/ui/unit/Dp;", "F", "InactiveIconColor", "InactiveLabelTextColor", "LabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "NavigationBarHeight", "StartIconIndicatorHorizontalPadding", "getStartIconIndicatorHorizontalPadding", "()F", "StartIconIndicatorVerticalPadding", "getStartIconIndicatorVerticalPadding", "StartIconItemActiveIndicatorHeight", "StartIconToLabelPadding", "getStartIconToLabelPadding", "TopIconIndicatorHorizontalPadding", "getTopIconIndicatorHorizontalPadding", "TopIconIndicatorToLabelPadding", "getTopIconIndicatorToLabelPadding", "TopIconIndicatorVerticalPadding", "getTopIconIndicatorVerticalPadding", "TopIconItemActiveIndicatorHeight", "TopIconItemActiveIndicatorWidth", "TopIconItemVerticalPadding", "getTopIconItemVerticalPadding", "ExpressiveNavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "arrangement", "Landroidx/compose/material3/NavigationBarArrangement;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "ExpressiveNavigationBar-NiJtXQ4", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/foundation/layout/WindowInsets;ILkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ExpressiveNavigationBarItem", "selected", "", "onClick", "icon", "enabled", Constants.ScionAnalytics.PARAM_LABEL, "badge", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "colors", "Landroidx/compose/material3/NavigationItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "ExpressiveNavigationBarItem-pli-t6k", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ILandroidx/compose/material3/NavigationItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "calculateCenteredContentHorizontalPadding", "", "itemsCount", "barWidth", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExpressiveNavigationBarKt {
    private static final ColorSchemeKeyTokens ActiveIconColor;
    private static final ColorSchemeKeyTokens ActiveIndicatorColor;
    private static final ShapeKeyTokens ActiveIndicatorShape;
    private static final ColorSchemeKeyTokens ActiveLabelTextColor;
    private static final float IconSize;
    private static final ColorSchemeKeyTokens InactiveIconColor;
    private static final ColorSchemeKeyTokens InactiveLabelTextColor;
    private static final TypographyKeyTokens LabelTextFont;
    private static final float NavigationBarHeight;
    private static final float StartIconIndicatorHorizontalPadding;
    private static final float StartIconIndicatorVerticalPadding;
    private static final float StartIconItemActiveIndicatorHeight;
    private static final float StartIconToLabelPadding;
    private static final float TopIconIndicatorHorizontalPadding;
    private static final float TopIconIndicatorToLabelPadding;
    private static final float TopIconIndicatorVerticalPadding;
    private static final float TopIconItemActiveIndicatorHeight;
    private static final float TopIconItemActiveIndicatorWidth;
    private static final float TopIconItemVerticalPadding;

    /* JADX WARN: Removed duplicated region for block: B:108:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x017c  */
    /* renamed from: ExpressiveNavigationBar-NiJtXQ4  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1899ExpressiveNavigationBarNiJtXQ4(Modifier modifier, long j, long j2, WindowInsets windowInsets, int i, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i2, final int i3) {
        Object obj;
        int i4;
        long j3;
        long j4;
        final Object obj2;
        int i5;
        final Modifier.Companion companion;
        final int m1898getArrangementEbr7WPU;
        long j5;
        long j6;
        Composer composer2;
        final Modifier modifier2;
        final WindowInsets windowInsets2;
        final long j7;
        final int i6;
        final long j8;
        int i7;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-1171105467);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExpressiveNavigationBar)P(4,1:c#ui.graphics.Color,3:c#ui.graphics.Color,5,0:c#material3.NavigationBarArrangement)83@3944L14,84@4018L12,85@4097L12,92@4328L779,89@4244L863:ExpressiveNavigationBar.kt#uh7d8r");
        int i10 = i3 & 1;
        if (i10 != 0) {
            i4 = i2 | 6;
            obj = modifier;
        } else if ((i2 & 6) == 0) {
            obj = modifier;
            i4 = (startRestartGroup.changed(obj) ? 4 : 2) | i2;
        } else {
            obj = modifier;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            if ((i3 & 2) == 0) {
                j3 = j;
                if (startRestartGroup.changed(j3)) {
                    i9 = 32;
                    i4 |= i9;
                }
            } else {
                j3 = j;
            }
            i9 = 16;
            i4 |= i9;
        } else {
            j3 = j;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            j4 = j2;
            i4 |= ((i3 & 4) == 0 && startRestartGroup.changed(j4)) ? 256 : 128;
        } else {
            j4 = j2;
        }
        if ((i2 & 3072) == 0) {
            if ((i3 & 8) == 0) {
                obj2 = windowInsets;
                if (startRestartGroup.changed(obj2)) {
                    i8 = 2048;
                    i4 |= i8;
                }
            } else {
                obj2 = windowInsets;
            }
            i8 = 1024;
            i4 |= i8;
        } else {
            obj2 = windowInsets;
        }
        if ((i2 & 24576) == 0) {
            if ((i3 & 16) == 0) {
                i5 = i;
                if (startRestartGroup.changed(i5)) {
                    i7 = 16384;
                    i4 |= i7;
                }
            } else {
                i5 = i;
            }
            i7 = 8192;
            i4 |= i7;
        } else {
            i5 = i;
        }
        if ((i3 & 32) != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        if ((74899 & i4) != 74898 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startDefaults();
            if ((i2 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                companion = i10 != 0 ? Modifier.Companion : obj;
                if ((i3 & 2) != 0) {
                    j3 = ExpressiveNavigationBarDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                    i4 &= -113;
                }
                if ((i3 & 4) != 0) {
                    j4 = ExpressiveNavigationBarDefaults.INSTANCE.getContentColor(startRestartGroup, 6);
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    i4 &= -7169;
                    obj2 = ExpressiveNavigationBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                }
                if ((i3 & 16) != 0) {
                    m1898getArrangementEbr7WPU = ExpressiveNavigationBarDefaults.INSTANCE.m1898getArrangementEbr7WPU();
                    i4 &= -57345;
                    j5 = j3;
                    j6 = j4;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1171105467, i4, -1, "androidx.compose.material3.ExpressiveNavigationBar (ExpressiveNavigationBar.kt:88)");
                    }
                    int i11 = i4 << 3;
                    composer2 = startRestartGroup;
                    SurfaceKt.m2347SurfaceT9BRK9s(null, null, j5, j6, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1573697866, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExpressiveNavigationBarKt$ExpressiveNavigationBar$1
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

                        public final void invoke(Composer composer3, int i12) {
                            float f;
                            CenteredContentMeasurePolicy centeredContentMeasurePolicy;
                            ComposerKt.sourceInformation(composer3, "C93@4338L763:ExpressiveNavigationBar.kt#uh7d8r");
                            if ((i12 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1573697866, i12, -1, "androidx.compose.material3.ExpressiveNavigationBar.<anonymous> (ExpressiveNavigationBar.kt:93)");
                                }
                                Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(Modifier.this, obj2);
                                f = ExpressiveNavigationBarKt.NavigationBarHeight;
                                Modifier selectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m770defaultMinSizeVpY3zN4$default(windowInsetsPadding, 0.0f, f, 1, null));
                                int i13 = m1898getArrangementEbr7WPU;
                                if (NavigationBarArrangement.m2056equalsimpl0(i13, NavigationBarArrangement.Companion.m2061getEqualWeightEbr7WPU())) {
                                    centeredContentMeasurePolicy = new EqualWeightContentMeasurePolicy();
                                } else if (NavigationBarArrangement.m2056equalsimpl0(i13, NavigationBarArrangement.Companion.m2060getCenteredEbr7WPU())) {
                                    centeredContentMeasurePolicy = new CenteredContentMeasurePolicy();
                                } else {
                                    throw new IllegalArgumentException("Invalid ItemsArrangement value.");
                                }
                                Function2<Composer, Integer, Unit> function22 = function2;
                                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, selectableGroup);
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
                                Updater.m3527setimpl(m3520constructorimpl, centeredContentMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                function22.invoke(composer3, 0);
                                composer3.endNode();
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
                    }, startRestartGroup, 54), composer2, (i11 & 896) | 12582912 | (i11 & 7168), BuildConfig.API_LEVEL);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = companion;
                    windowInsets2 = obj2;
                    j7 = j6;
                    i6 = m1898getArrangementEbr7WPU;
                    j8 = j5;
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i3 & 2) != 0) {
                    i4 &= -113;
                }
                if ((i3 & 4) != 0) {
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    i4 &= -7169;
                }
                if ((i3 & 16) != 0) {
                    i4 &= -57345;
                }
                companion = obj;
            }
            j6 = j4;
            m1898getArrangementEbr7WPU = i5;
            j5 = j3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i112 = i4 << 3;
            composer2 = startRestartGroup;
            SurfaceKt.m2347SurfaceT9BRK9s(null, null, j5, j6, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1573697866, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExpressiveNavigationBarKt$ExpressiveNavigationBar$1
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

                public final void invoke(Composer composer3, int i12) {
                    float f;
                    CenteredContentMeasurePolicy centeredContentMeasurePolicy;
                    ComposerKt.sourceInformation(composer3, "C93@4338L763:ExpressiveNavigationBar.kt#uh7d8r");
                    if ((i12 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1573697866, i12, -1, "androidx.compose.material3.ExpressiveNavigationBar.<anonymous> (ExpressiveNavigationBar.kt:93)");
                        }
                        Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(Modifier.this, obj2);
                        f = ExpressiveNavigationBarKt.NavigationBarHeight;
                        Modifier selectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m770defaultMinSizeVpY3zN4$default(windowInsetsPadding, 0.0f, f, 1, null));
                        int i13 = m1898getArrangementEbr7WPU;
                        if (NavigationBarArrangement.m2056equalsimpl0(i13, NavigationBarArrangement.Companion.m2061getEqualWeightEbr7WPU())) {
                            centeredContentMeasurePolicy = new EqualWeightContentMeasurePolicy();
                        } else if (NavigationBarArrangement.m2056equalsimpl0(i13, NavigationBarArrangement.Companion.m2060getCenteredEbr7WPU())) {
                            centeredContentMeasurePolicy = new CenteredContentMeasurePolicy();
                        } else {
                            throw new IllegalArgumentException("Invalid ItemsArrangement value.");
                        }
                        Function2<Composer, Integer, Unit> function22 = function2;
                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, selectableGroup);
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
                        Updater.m3527setimpl(m3520constructorimpl, centeredContentMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                        function22.invoke(composer3, 0);
                        composer3.endNode();
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
            }, startRestartGroup, 54), composer2, (i112 & 896) | 12582912 | (i112 & 7168), BuildConfig.API_LEVEL);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = companion;
            windowInsets2 = obj2;
            j7 = j6;
            i6 = m1898getArrangementEbr7WPU;
            j8 = j5;
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
            modifier2 = obj;
            j8 = j3;
            windowInsets2 = obj2;
            j7 = j4;
            i6 = i5;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExpressiveNavigationBarKt$ExpressiveNavigationBar$2
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

                public final void invoke(Composer composer3, int i12) {
                    ExpressiveNavigationBarKt.m1899ExpressiveNavigationBarNiJtXQ4(Modifier.this, j8, j7, windowInsets2, i6, function2, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0114  */
    /* renamed from: ExpressiveNavigationBarItem-pli-t6k  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1900ExpressiveNavigationBarItemplit6k(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i, NavigationItemColors navigationItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i2, final int i3) {
        boolean z3;
        int i4;
        Function0<Unit> function02;
        Object obj;
        int i5;
        Modifier.Companion companion;
        int i6;
        boolean z4;
        int i7;
        Object obj2;
        int i8;
        Object obj3;
        int i9;
        int i10;
        int i11;
        int i12;
        int m2114getTopxw1Ddg;
        NavigationItemColors navigationItemColors2;
        int i13;
        MutableInteractionSource mutableInteractionSource2;
        Modifier modifier2;
        NavigationItemColors navigationItemColors3;
        boolean z5;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Function2<? super Composer, ? super Integer, Unit> function25;
        MutableInteractionSource mutableInteractionSource3;
        boolean m2109equalsimpl0;
        float f;
        float f2;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource4;
        final NavigationItemColors navigationItemColors4;
        final Modifier modifier3;
        final boolean z6;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final int i14;
        ScopeUpdateScope endRestartGroup;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(1250474866);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExpressiveNavigationBarItem)P(9,8,3,7,2,6!1,4:c#material3.NavigationItemIconPosition)195@8610L8,219@9391L5,220@9444L5,215@9259L800:ExpressiveNavigationBar.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
            z3 = z;
        } else {
            z3 = z;
            if ((i2 & 6) == 0) {
                i4 = (startRestartGroup.changed(z3) ? 4 : 2) | i2;
            } else {
                i4 = i2;
            }
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i2 & 48) == 0) {
                i4 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
            }
        }
        if ((i3 & 4) != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = function2;
            i4 |= startRestartGroup.changedInstance(obj) ? 256 : 128;
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i2 & 3072) == 0) {
                companion = modifier;
                i4 |= startRestartGroup.changed(companion) ? 2048 : 1024;
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i2 & 24576) == 0) {
                    z4 = z2;
                    i4 |= startRestartGroup.changed(z4) ? 16384 : 8192;
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((196608 & i2) == 0) {
                        obj2 = function22;
                        i4 |= startRestartGroup.changedInstance(obj2) ? 131072 : 65536;
                        i8 = i3 & 64;
                        if (i8 != 0) {
                            i4 |= 1572864;
                        } else if ((1572864 & i2) == 0) {
                            obj3 = function23;
                            i4 |= startRestartGroup.changedInstance(obj3) ? 1048576 : 524288;
                            i9 = i3 & 128;
                            if (i9 == 0) {
                                i4 |= 12582912;
                            } else if ((i2 & 12582912) == 0) {
                                i10 = i9;
                                i4 |= startRestartGroup.changed(i) ? 8388608 : 4194304;
                                if ((i2 & 100663296) == 0) {
                                    if ((i3 & 256) == 0 && startRestartGroup.changed(navigationItemColors)) {
                                        i15 = 67108864;
                                        i4 |= i15;
                                    }
                                    i15 = 33554432;
                                    i4 |= i15;
                                }
                                i11 = i3 & 512;
                                if (i11 != 0) {
                                    i4 |= 805306368;
                                } else if ((i2 & 805306368) == 0) {
                                    i12 = i11;
                                    i4 |= startRestartGroup.changed(mutableInteractionSource) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                                    int i16 = i4;
                                    if ((i4 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                                        startRestartGroup.startDefaults();
                                        if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                            if (i5 != 0) {
                                                companion = Modifier.Companion;
                                            }
                                            if (i6 != 0) {
                                                z4 = true;
                                            }
                                            if (i7 != 0) {
                                                obj2 = null;
                                            }
                                            if (i8 != 0) {
                                                obj3 = null;
                                            }
                                            m2114getTopxw1Ddg = i10 == 0 ? NavigationItemIconPosition.Companion.m2114getTopxw1Ddg() : i;
                                            if ((i3 & 256) == 0) {
                                                navigationItemColors2 = ExpressiveNavigationBarItemDefaults.INSTANCE.colors(startRestartGroup, 6);
                                                i13 = i16 & (-234881025);
                                            } else {
                                                navigationItemColors2 = navigationItemColors;
                                                i13 = i16;
                                            }
                                            mutableInteractionSource2 = i12 == 0 ? mutableInteractionSource : null;
                                            modifier2 = companion;
                                            navigationItemColors3 = navigationItemColors2;
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            if ((i3 & 256) != 0) {
                                                m2114getTopxw1Ddg = i;
                                                navigationItemColors3 = navigationItemColors;
                                                i13 = i16 & (-234881025);
                                                modifier2 = companion;
                                                z5 = z4;
                                                function24 = obj2;
                                                function25 = obj3;
                                                mutableInteractionSource2 = mutableInteractionSource;
                                                startRestartGroup.endDefaults();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1250474866, i13, -1, "androidx.compose.material3.ExpressiveNavigationBarItem (ExpressiveNavigationBar.kt:197)");
                                                }
                                                startRestartGroup.startReplaceGroup(-986536477);
                                                ComposerKt.sourceInformation(startRestartGroup, "199@8762L39");
                                                if (mutableInteractionSource2 == null) {
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -986535826, "CC(remember):ExpressiveNavigationBar.kt#9igjgp");
                                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                                    if (rememberedValue == Composer.Companion.getEmpty()) {
                                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                                } else {
                                                    mutableInteractionSource3 = mutableInteractionSource2;
                                                }
                                                startRestartGroup.endReplaceGroup();
                                                m2109equalsimpl0 = NavigationItemIconPosition.m2109equalsimpl0(m2114getTopxw1Ddg, NavigationItemIconPosition.Companion.m2114getTopxw1Ddg());
                                                if (m2109equalsimpl0) {
                                                    f = TopIconIndicatorHorizontalPadding;
                                                } else {
                                                    f = StartIconIndicatorHorizontalPadding;
                                                }
                                                float f3 = f;
                                                if (m2109equalsimpl0) {
                                                    f2 = TopIconIndicatorVerticalPadding;
                                                } else {
                                                    f2 = StartIconIndicatorVerticalPadding;
                                                }
                                                int i17 = i13 >> 3;
                                                composer2 = startRestartGroup;
                                                int i18 = m2114getTopxw1Ddg;
                                                NavigationItemKt.m2115NavigationItemSHbi2eg(z3, function02, obj, TypographyKt.getValue(LabelTextFont, startRestartGroup, 6), ShapesKt.getValue(ActiveIndicatorShape, startRestartGroup, 6), TopIconItemActiveIndicatorWidth, f3, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier2, z5, function24, function25, i18, mutableInteractionSource3, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 21) & 112) | (i17 & 896) | (i17 & 7168) | (57344 & i17) | (458752 & i17) | (i17 & 3670016));
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                mutableInteractionSource4 = mutableInteractionSource2;
                                                navigationItemColors4 = navigationItemColors3;
                                                modifier3 = modifier2;
                                                z6 = z5;
                                                function26 = function24;
                                                function27 = function25;
                                                i14 = i18;
                                            } else {
                                                m2114getTopxw1Ddg = i;
                                                navigationItemColors3 = navigationItemColors;
                                                mutableInteractionSource2 = mutableInteractionSource;
                                                i13 = i16;
                                                modifier2 = companion;
                                            }
                                        }
                                        z5 = z4;
                                        function24 = obj2;
                                        function25 = obj3;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        startRestartGroup.startReplaceGroup(-986536477);
                                        ComposerKt.sourceInformation(startRestartGroup, "199@8762L39");
                                        if (mutableInteractionSource2 == null) {
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        m2109equalsimpl0 = NavigationItemIconPosition.m2109equalsimpl0(m2114getTopxw1Ddg, NavigationItemIconPosition.Companion.m2114getTopxw1Ddg());
                                        if (m2109equalsimpl0) {
                                        }
                                        float f32 = f;
                                        if (m2109equalsimpl0) {
                                        }
                                        int i172 = i13 >> 3;
                                        composer2 = startRestartGroup;
                                        int i182 = m2114getTopxw1Ddg;
                                        NavigationItemKt.m2115NavigationItemSHbi2eg(z3, function02, obj, TypographyKt.getValue(LabelTextFont, startRestartGroup, 6), ShapesKt.getValue(ActiveIndicatorShape, startRestartGroup, 6), TopIconItemActiveIndicatorWidth, f32, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier2, z5, function24, function25, i182, mutableInteractionSource3, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 21) & 112) | (i172 & 896) | (i172 & 7168) | (57344 & i172) | (458752 & i172) | (i172 & 3670016));
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        mutableInteractionSource4 = mutableInteractionSource2;
                                        navigationItemColors4 = navigationItemColors3;
                                        modifier3 = modifier2;
                                        z6 = z5;
                                        function26 = function24;
                                        function27 = function25;
                                        i14 = i182;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        i14 = i;
                                        mutableInteractionSource4 = mutableInteractionSource;
                                        composer2 = startRestartGroup;
                                        modifier3 = companion;
                                        z6 = z4;
                                        function26 = obj2;
                                        function27 = obj3;
                                        navigationItemColors4 = navigationItemColors;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup == null) {
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExpressiveNavigationBarKt$ExpressiveNavigationBarItem$1
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
                                                ExpressiveNavigationBarKt.m1900ExpressiveNavigationBarItemplit6k(z, function0, function2, modifier3, z6, function26, function27, i14, navigationItemColors4, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i12 = i11;
                                int i162 = i4;
                                if ((i4 & 306783379) == 306783378) {
                                }
                                startRestartGroup.startDefaults();
                                if ((i2 & 1) != 0) {
                                }
                                if (i5 != 0) {
                                }
                                if (i6 != 0) {
                                }
                                if (i7 != 0) {
                                }
                                if (i8 != 0) {
                                }
                                if (i10 == 0) {
                                }
                                if ((i3 & 256) == 0) {
                                }
                                if (i12 == 0) {
                                }
                                modifier2 = companion;
                                navigationItemColors3 = navigationItemColors2;
                                z5 = z4;
                                function24 = obj2;
                                function25 = obj3;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                startRestartGroup.startReplaceGroup(-986536477);
                                ComposerKt.sourceInformation(startRestartGroup, "199@8762L39");
                                if (mutableInteractionSource2 == null) {
                                }
                                startRestartGroup.endReplaceGroup();
                                m2109equalsimpl0 = NavigationItemIconPosition.m2109equalsimpl0(m2114getTopxw1Ddg, NavigationItemIconPosition.Companion.m2114getTopxw1Ddg());
                                if (m2109equalsimpl0) {
                                }
                                float f322 = f;
                                if (m2109equalsimpl0) {
                                }
                                int i1722 = i13 >> 3;
                                composer2 = startRestartGroup;
                                int i1822 = m2114getTopxw1Ddg;
                                NavigationItemKt.m2115NavigationItemSHbi2eg(z3, function02, obj, TypographyKt.getValue(LabelTextFont, startRestartGroup, 6), ShapesKt.getValue(ActiveIndicatorShape, startRestartGroup, 6), TopIconItemActiveIndicatorWidth, f322, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier2, z5, function24, function25, i1822, mutableInteractionSource3, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 21) & 112) | (i1722 & 896) | (i1722 & 7168) | (57344 & i1722) | (458752 & i1722) | (i1722 & 3670016));
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                mutableInteractionSource4 = mutableInteractionSource2;
                                navigationItemColors4 = navigationItemColors3;
                                modifier3 = modifier2;
                                z6 = z5;
                                function26 = function24;
                                function27 = function25;
                                i14 = i1822;
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                }
                            }
                            i10 = i9;
                            if ((i2 & 100663296) == 0) {
                            }
                            i11 = i3 & 512;
                            if (i11 != 0) {
                            }
                            i12 = i11;
                            int i1622 = i4;
                            if ((i4 & 306783379) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i2 & 1) != 0) {
                            }
                            if (i5 != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if (i7 != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i10 == 0) {
                            }
                            if ((i3 & 256) == 0) {
                            }
                            if (i12 == 0) {
                            }
                            modifier2 = companion;
                            navigationItemColors3 = navigationItemColors2;
                            z5 = z4;
                            function24 = obj2;
                            function25 = obj3;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.startReplaceGroup(-986536477);
                            ComposerKt.sourceInformation(startRestartGroup, "199@8762L39");
                            if (mutableInteractionSource2 == null) {
                            }
                            startRestartGroup.endReplaceGroup();
                            m2109equalsimpl0 = NavigationItemIconPosition.m2109equalsimpl0(m2114getTopxw1Ddg, NavigationItemIconPosition.Companion.m2114getTopxw1Ddg());
                            if (m2109equalsimpl0) {
                            }
                            float f3222 = f;
                            if (m2109equalsimpl0) {
                            }
                            int i17222 = i13 >> 3;
                            composer2 = startRestartGroup;
                            int i18222 = m2114getTopxw1Ddg;
                            NavigationItemKt.m2115NavigationItemSHbi2eg(z3, function02, obj, TypographyKt.getValue(LabelTextFont, startRestartGroup, 6), ShapesKt.getValue(ActiveIndicatorShape, startRestartGroup, 6), TopIconItemActiveIndicatorWidth, f3222, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier2, z5, function24, function25, i18222, mutableInteractionSource3, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 21) & 112) | (i17222 & 896) | (i17222 & 7168) | (57344 & i17222) | (458752 & i17222) | (i17222 & 3670016));
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            mutableInteractionSource4 = mutableInteractionSource2;
                            navigationItemColors4 = navigationItemColors3;
                            modifier3 = modifier2;
                            z6 = z5;
                            function26 = function24;
                            function27 = function25;
                            i14 = i18222;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        obj3 = function23;
                        i9 = i3 & 128;
                        if (i9 == 0) {
                        }
                        i10 = i9;
                        if ((i2 & 100663296) == 0) {
                        }
                        i11 = i3 & 512;
                        if (i11 != 0) {
                        }
                        i12 = i11;
                        int i16222 = i4;
                        if ((i4 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i10 == 0) {
                        }
                        if ((i3 & 256) == 0) {
                        }
                        if (i12 == 0) {
                        }
                        modifier2 = companion;
                        navigationItemColors3 = navigationItemColors2;
                        z5 = z4;
                        function24 = obj2;
                        function25 = obj3;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceGroup(-986536477);
                        ComposerKt.sourceInformation(startRestartGroup, "199@8762L39");
                        if (mutableInteractionSource2 == null) {
                        }
                        startRestartGroup.endReplaceGroup();
                        m2109equalsimpl0 = NavigationItemIconPosition.m2109equalsimpl0(m2114getTopxw1Ddg, NavigationItemIconPosition.Companion.m2114getTopxw1Ddg());
                        if (m2109equalsimpl0) {
                        }
                        float f32222 = f;
                        if (m2109equalsimpl0) {
                        }
                        int i172222 = i13 >> 3;
                        composer2 = startRestartGroup;
                        int i182222 = m2114getTopxw1Ddg;
                        NavigationItemKt.m2115NavigationItemSHbi2eg(z3, function02, obj, TypographyKt.getValue(LabelTextFont, startRestartGroup, 6), ShapesKt.getValue(ActiveIndicatorShape, startRestartGroup, 6), TopIconItemActiveIndicatorWidth, f32222, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier2, z5, function24, function25, i182222, mutableInteractionSource3, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 21) & 112) | (i172222 & 896) | (i172222 & 7168) | (57344 & i172222) | (458752 & i172222) | (i172222 & 3670016));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        mutableInteractionSource4 = mutableInteractionSource2;
                        navigationItemColors4 = navigationItemColors3;
                        modifier3 = modifier2;
                        z6 = z5;
                        function26 = function24;
                        function27 = function25;
                        i14 = i182222;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    obj2 = function22;
                    i8 = i3 & 64;
                    if (i8 != 0) {
                    }
                    obj3 = function23;
                    i9 = i3 & 128;
                    if (i9 == 0) {
                    }
                    i10 = i9;
                    if ((i2 & 100663296) == 0) {
                    }
                    i11 = i3 & 512;
                    if (i11 != 0) {
                    }
                    i12 = i11;
                    int i162222 = i4;
                    if ((i4 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i10 == 0) {
                    }
                    if ((i3 & 256) == 0) {
                    }
                    if (i12 == 0) {
                    }
                    modifier2 = companion;
                    navigationItemColors3 = navigationItemColors2;
                    z5 = z4;
                    function24 = obj2;
                    function25 = obj3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceGroup(-986536477);
                    ComposerKt.sourceInformation(startRestartGroup, "199@8762L39");
                    if (mutableInteractionSource2 == null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    m2109equalsimpl0 = NavigationItemIconPosition.m2109equalsimpl0(m2114getTopxw1Ddg, NavigationItemIconPosition.Companion.m2114getTopxw1Ddg());
                    if (m2109equalsimpl0) {
                    }
                    float f322222 = f;
                    if (m2109equalsimpl0) {
                    }
                    int i1722222 = i13 >> 3;
                    composer2 = startRestartGroup;
                    int i1822222 = m2114getTopxw1Ddg;
                    NavigationItemKt.m2115NavigationItemSHbi2eg(z3, function02, obj, TypographyKt.getValue(LabelTextFont, startRestartGroup, 6), ShapesKt.getValue(ActiveIndicatorShape, startRestartGroup, 6), TopIconItemActiveIndicatorWidth, f322222, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier2, z5, function24, function25, i1822222, mutableInteractionSource3, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 21) & 112) | (i1722222 & 896) | (i1722222 & 7168) | (57344 & i1722222) | (458752 & i1722222) | (i1722222 & 3670016));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    mutableInteractionSource4 = mutableInteractionSource2;
                    navigationItemColors4 = navigationItemColors3;
                    modifier3 = modifier2;
                    z6 = z5;
                    function26 = function24;
                    function27 = function25;
                    i14 = i1822222;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z4 = z2;
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                obj2 = function22;
                i8 = i3 & 64;
                if (i8 != 0) {
                }
                obj3 = function23;
                i9 = i3 & 128;
                if (i9 == 0) {
                }
                i10 = i9;
                if ((i2 & 100663296) == 0) {
                }
                i11 = i3 & 512;
                if (i11 != 0) {
                }
                i12 = i11;
                int i1622222 = i4;
                if ((i4 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if (i10 == 0) {
                }
                if ((i3 & 256) == 0) {
                }
                if (i12 == 0) {
                }
                modifier2 = companion;
                navigationItemColors3 = navigationItemColors2;
                z5 = z4;
                function24 = obj2;
                function25 = obj3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceGroup(-986536477);
                ComposerKt.sourceInformation(startRestartGroup, "199@8762L39");
                if (mutableInteractionSource2 == null) {
                }
                startRestartGroup.endReplaceGroup();
                m2109equalsimpl0 = NavigationItemIconPosition.m2109equalsimpl0(m2114getTopxw1Ddg, NavigationItemIconPosition.Companion.m2114getTopxw1Ddg());
                if (m2109equalsimpl0) {
                }
                float f3222222 = f;
                if (m2109equalsimpl0) {
                }
                int i17222222 = i13 >> 3;
                composer2 = startRestartGroup;
                int i18222222 = m2114getTopxw1Ddg;
                NavigationItemKt.m2115NavigationItemSHbi2eg(z3, function02, obj, TypographyKt.getValue(LabelTextFont, startRestartGroup, 6), ShapesKt.getValue(ActiveIndicatorShape, startRestartGroup, 6), TopIconItemActiveIndicatorWidth, f3222222, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier2, z5, function24, function25, i18222222, mutableInteractionSource3, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 21) & 112) | (i17222222 & 896) | (i17222222 & 7168) | (57344 & i17222222) | (458752 & i17222222) | (i17222222 & 3670016));
                if (ComposerKt.isTraceInProgress()) {
                }
                mutableInteractionSource4 = mutableInteractionSource2;
                navigationItemColors4 = navigationItemColors3;
                modifier3 = modifier2;
                z6 = z5;
                function26 = function24;
                function27 = function25;
                i14 = i18222222;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            companion = modifier;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            z4 = z2;
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            obj2 = function22;
            i8 = i3 & 64;
            if (i8 != 0) {
            }
            obj3 = function23;
            i9 = i3 & 128;
            if (i9 == 0) {
            }
            i10 = i9;
            if ((i2 & 100663296) == 0) {
            }
            i11 = i3 & 512;
            if (i11 != 0) {
            }
            i12 = i11;
            int i16222222 = i4;
            if ((i4 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if (i10 == 0) {
            }
            if ((i3 & 256) == 0) {
            }
            if (i12 == 0) {
            }
            modifier2 = companion;
            navigationItemColors3 = navigationItemColors2;
            z5 = z4;
            function24 = obj2;
            function25 = obj3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceGroup(-986536477);
            ComposerKt.sourceInformation(startRestartGroup, "199@8762L39");
            if (mutableInteractionSource2 == null) {
            }
            startRestartGroup.endReplaceGroup();
            m2109equalsimpl0 = NavigationItemIconPosition.m2109equalsimpl0(m2114getTopxw1Ddg, NavigationItemIconPosition.Companion.m2114getTopxw1Ddg());
            if (m2109equalsimpl0) {
            }
            float f32222222 = f;
            if (m2109equalsimpl0) {
            }
            int i172222222 = i13 >> 3;
            composer2 = startRestartGroup;
            int i182222222 = m2114getTopxw1Ddg;
            NavigationItemKt.m2115NavigationItemSHbi2eg(z3, function02, obj, TypographyKt.getValue(LabelTextFont, startRestartGroup, 6), ShapesKt.getValue(ActiveIndicatorShape, startRestartGroup, 6), TopIconItemActiveIndicatorWidth, f32222222, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier2, z5, function24, function25, i182222222, mutableInteractionSource3, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 21) & 112) | (i172222222 & 896) | (i172222222 & 7168) | (57344 & i172222222) | (458752 & i172222222) | (i172222222 & 3670016));
            if (ComposerKt.isTraceInProgress()) {
            }
            mutableInteractionSource4 = mutableInteractionSource2;
            navigationItemColors4 = navigationItemColors3;
            modifier3 = modifier2;
            z6 = z5;
            function26 = function24;
            function27 = function25;
            i14 = i182222222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = function2;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        companion = modifier;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        z4 = z2;
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        obj2 = function22;
        i8 = i3 & 64;
        if (i8 != 0) {
        }
        obj3 = function23;
        i9 = i3 & 128;
        if (i9 == 0) {
        }
        i10 = i9;
        if ((i2 & 100663296) == 0) {
        }
        i11 = i3 & 512;
        if (i11 != 0) {
        }
        i12 = i11;
        int i162222222 = i4;
        if ((i4 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i10 == 0) {
        }
        if ((i3 & 256) == 0) {
        }
        if (i12 == 0) {
        }
        modifier2 = companion;
        navigationItemColors3 = navigationItemColors2;
        z5 = z4;
        function24 = obj2;
        function25 = obj3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(-986536477);
        ComposerKt.sourceInformation(startRestartGroup, "199@8762L39");
        if (mutableInteractionSource2 == null) {
        }
        startRestartGroup.endReplaceGroup();
        m2109equalsimpl0 = NavigationItemIconPosition.m2109equalsimpl0(m2114getTopxw1Ddg, NavigationItemIconPosition.Companion.m2114getTopxw1Ddg());
        if (m2109equalsimpl0) {
        }
        float f322222222 = f;
        if (m2109equalsimpl0) {
        }
        int i1722222222 = i13 >> 3;
        composer2 = startRestartGroup;
        int i1822222222 = m2114getTopxw1Ddg;
        NavigationItemKt.m2115NavigationItemSHbi2eg(z3, function02, obj, TypographyKt.getValue(LabelTextFont, startRestartGroup, 6), ShapesKt.getValue(ActiveIndicatorShape, startRestartGroup, 6), TopIconItemActiveIndicatorWidth, f322222222, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier2, z5, function24, function25, i1822222222, mutableInteractionSource3, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 21) & 112) | (i1722222222 & 896) | (i1722222222 & 7168) | (57344 & i1722222222) | (458752 & i1722222222) | (i1722222222 & 3670016));
        if (ComposerKt.isTraceInProgress()) {
        }
        mutableInteractionSource4 = mutableInteractionSource2;
        navigationItemColors4 = navigationItemColors3;
        modifier3 = modifier2;
        z6 = z5;
        function26 = function24;
        function27 = function25;
        i14 = i1822222222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int calculateCenteredContentHorizontalPadding(int i, int i2) {
        if (i > 6) {
            return 0;
        }
        return MathKt.roundToInt((((100 - ((i + 3) * 10)) / 2.0f) / 100) * i2);
    }

    public static final float getTopIconItemVerticalPadding() {
        return TopIconItemVerticalPadding;
    }

    public static final float getTopIconIndicatorVerticalPadding() {
        return TopIconIndicatorVerticalPadding;
    }

    public static final float getTopIconIndicatorHorizontalPadding() {
        return TopIconIndicatorHorizontalPadding;
    }

    public static final float getStartIconIndicatorVerticalPadding() {
        return StartIconIndicatorVerticalPadding;
    }

    public static final float getTopIconIndicatorToLabelPadding() {
        return TopIconIndicatorToLabelPadding;
    }

    public static final float getStartIconIndicatorHorizontalPadding() {
        return StartIconIndicatorHorizontalPadding;
    }

    public static final float getStartIconToLabelPadding() {
        return StartIconToLabelPadding;
    }

    static {
        float m6684constructorimpl = Dp.m6684constructorimpl((float) 24.0d);
        IconSize = m6684constructorimpl;
        float m6684constructorimpl2 = Dp.m6684constructorimpl(56);
        TopIconItemActiveIndicatorWidth = m6684constructorimpl2;
        float m6684constructorimpl3 = Dp.m6684constructorimpl(32);
        TopIconItemActiveIndicatorHeight = m6684constructorimpl3;
        float m6684constructorimpl4 = Dp.m6684constructorimpl(40);
        StartIconItemActiveIndicatorHeight = m6684constructorimpl4;
        LabelTextFont = TypographyKeyTokens.LabelMedium;
        ActiveIndicatorShape = ShapeKeyTokens.CornerFull;
        ActiveIconColor = ColorSchemeKeyTokens.Secondary;
        ActiveLabelTextColor = ColorSchemeKeyTokens.Secondary;
        ActiveIndicatorColor = ColorSchemeKeyTokens.SecondaryContainer;
        InactiveIconColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        InactiveLabelTextColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        NavigationBarHeight = Dp.m6684constructorimpl(64);
        TopIconItemVerticalPadding = Dp.m6684constructorimpl(6);
        float f = 2;
        TopIconIndicatorVerticalPadding = Dp.m6684constructorimpl(Dp.m6684constructorimpl(m6684constructorimpl3 - m6684constructorimpl) / f);
        TopIconIndicatorHorizontalPadding = Dp.m6684constructorimpl(Dp.m6684constructorimpl(m6684constructorimpl2 - m6684constructorimpl) / f);
        StartIconIndicatorVerticalPadding = Dp.m6684constructorimpl(Dp.m6684constructorimpl(m6684constructorimpl4 - m6684constructorimpl) / f);
        float f2 = 4;
        TopIconIndicatorToLabelPadding = Dp.m6684constructorimpl(f2);
        StartIconIndicatorHorizontalPadding = Dp.m6684constructorimpl(16);
        StartIconToLabelPadding = Dp.m6684constructorimpl(f2);
    }
}
