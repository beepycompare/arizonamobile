package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.PlainTooltipTokens;
import androidx.compose.material3.tokens.RichTooltipTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Tooltip.android.kt */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ao\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0093\u0001\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aH\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010&H\u0003ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006)"}, d2 = {"PlainTooltip", "", "Landroidx/compose/material3/TooltipScope;", "modifier", "Landroidx/compose/ui/Modifier;", "caretSize", "Landroidx/compose/ui/unit/DpSize;", "shape", "Landroidx/compose/ui/graphics/Shape;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "containerColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "PlainTooltip-7QI4Sbk", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "RichTooltip", "title", "action", "colors", "Landroidx/compose/material3/RichTooltipColors;", "text", "RichTooltip-yDvdmqw", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/RichTooltipColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "drawCaretWithPath", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "caretType", "Landroidx/compose/material3/CaretType;", "density", "Landroidx/compose/ui/unit/Density;", "configuration", "Landroid/content/res/Configuration;", "anchorLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "drawCaretWithPath-JKu-mZY", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/material3/CaretType;Landroidx/compose/ui/unit/Density;Landroid/content/res/Configuration;JJLandroidx/compose/ui/layout/LayoutCoordinates;)Landroidx/compose/ui/draw/DrawResult;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Tooltip_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:124:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0104  */
    /* renamed from: PlainTooltip-7QI4Sbk  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2648PlainTooltip7QI4Sbk(final TooltipScope tooltipScope, Modifier modifier, long j, Shape shape, long j2, long j3, float f, float f2, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        Shape shape2;
        final long j4;
        long j5;
        int i4;
        float f3;
        int i5;
        long j6;
        float f4;
        float f5;
        Shape shape3;
        int i6;
        final long j7;
        long j8;
        Modifier modifier2;
        Composer composer2;
        final Modifier modifier3;
        final long j9;
        final Shape shape4;
        final long j10;
        final float f6;
        final float f7;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(1407069716);
        ComposerKt.sourceInformation(startRestartGroup, "C(PlainTooltip)P(4,0:c#ui.unit.DpSize,6,3:c#ui.graphics.Color,1:c#ui.graphics.Color,7:c#ui.unit.Dp,5:c#ui.unit.Dp)208@8412L26,209@8482L24,211@8552L26,96@3876L606,90@3685L797:Tooltip.android.kt#uh7d8r");
        if ((Integer.MIN_VALUE & i2) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? startRestartGroup.changed(tooltipScope) : startRestartGroup.changedInstance(tooltipScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i3 |= ((i2 & 2) == 0 && startRestartGroup.changed(j)) ? 256 : 128;
            }
            if ((i & 3072) != 0) {
                if ((i2 & 4) == 0) {
                    shape2 = shape;
                    if (startRestartGroup.changed(shape2)) {
                        i8 = 2048;
                        i3 |= i8;
                    }
                } else {
                    shape2 = shape;
                }
                i8 = 1024;
                i3 |= i8;
            } else {
                shape2 = shape;
            }
            if ((i & 24576) != 0) {
                if ((i2 & 8) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i7 = 16384;
                        i3 |= i7;
                    }
                } else {
                    j4 = j2;
                }
                i7 = 8192;
                i3 |= i7;
            } else {
                j4 = j2;
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                j5 = j3;
                i3 |= ((i2 & 16) == 0 && startRestartGroup.changed(j5)) ? 131072 : 65536;
            } else {
                j5 = j3;
            }
            i4 = i2 & 32;
            if (i4 == 0) {
                i3 |= 1572864;
                f3 = f;
            } else {
                f3 = f;
                if ((i & 1572864) == 0) {
                    i3 |= startRestartGroup.changed(f3) ? 1048576 : 524288;
                }
            }
            i5 = i2 & 64;
            if (i5 == 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                i3 |= startRestartGroup.changed(f2) ? 8388608 : 4194304;
            }
            if ((i2 & 128) == 0) {
                i3 |= 100663296;
            } else if ((i & 100663296) == 0) {
                i3 |= startRestartGroup.changedInstance(function2) ? 67108864 : 33554432;
            }
            if ((38347923 & i3) == 38347922 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    if (i9 != 0) {
                        companion = Modifier.Companion;
                    }
                    if ((i2 & 2) == 0) {
                        j6 = DpSize.Companion.m6791getUnspecifiedMYxV2XQ();
                        i3 &= -897;
                    } else {
                        j6 = j;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -7169;
                        shape2 = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(startRestartGroup, 6);
                    }
                    if ((i2 & 8) != 0) {
                        j4 = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(startRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 16) != 0) {
                        j5 = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(startRestartGroup, 6);
                        i3 &= -458753;
                    }
                    float m6684constructorimpl = i4 == 0 ? Dp.m6684constructorimpl(0) : f3;
                    if (i5 == 0) {
                        f5 = m6684constructorimpl;
                        shape3 = shape2;
                        f4 = Dp.m6684constructorimpl(0);
                    } else {
                        f4 = f2;
                        f5 = m6684constructorimpl;
                        shape3 = shape2;
                    }
                    i6 = i3;
                    j7 = j6;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -458753;
                    }
                    f4 = f2;
                    shape3 = shape2;
                    f5 = f3;
                    i6 = i3;
                    j7 = j;
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1407069716, i6, -1, "androidx.compose.material3.PlainTooltip (Tooltip.android.kt:73)");
                }
                startRestartGroup.startReplaceGroup(-333850415);
                ComposerKt.sourceInformation(startRestartGroup, "76@3183L7,77@3242L7,78@3281L343");
                if (j7 == InlineClassHelperKt.UnspecifiedPackedFloats) {
                    j8 = j5;
                    modifier2 = companion;
                } else {
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final Density density = (Density) consume;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume2 = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final Configuration configuration = (Configuration) consume2;
                    Modifier.Companion companion2 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -333845325, "CC(remember):Tooltip.android.kt#9igjgp");
                    boolean changed = ((((458752 & i6) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072 && startRestartGroup.changed(j5)) || (i6 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | startRestartGroup.changed(density) | startRestartGroup.changedInstance(configuration) | ((((i6 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && startRestartGroup.changed(j7)) || (i6 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        final long j11 = j7;
                        final long j12 = j5;
                        j8 = j12;
                        rememberedValue = (Function2) new Function2<CacheDrawScope, LayoutCoordinates, DrawResult>() { // from class: androidx.compose.material3.Tooltip_androidKt$PlainTooltip$drawCaretModifier$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final DrawResult invoke(CacheDrawScope cacheDrawScope, LayoutCoordinates layoutCoordinates) {
                                DrawResult m2651drawCaretWithPathJKumZY;
                                m2651drawCaretWithPathJKumZY = Tooltip_androidKt.m2651drawCaretWithPathJKumZY(cacheDrawScope, CaretType.Plain, Density.this, configuration, j12, j11, layoutCoordinates);
                                return m2651drawCaretWithPathJKumZY;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    } else {
                        j8 = j5;
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    modifier2 = tooltipScope.drawCaret(companion2, (Function2) rememberedValue).then(companion);
                }
                startRestartGroup.endReplaceGroup();
                int i10 = i6 >> 6;
                composer2 = startRestartGroup;
                SurfaceKt.m2347SurfaceT9BRK9s(modifier2, shape3, j8, 0L, f5, f4, null, ComposableLambdaKt.rememberComposableLambda(1430116975, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$PlainTooltip$1
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
                        ComposerKt.sourceInformation(composer3, "C97@3886L590:Tooltip.android.kt#uh7d8r");
                        if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1430116975, i11, -1, "androidx.compose.material3.PlainTooltip.<anonymous> (Tooltip.android.kt:97)");
                            }
                            Modifier padding = PaddingKt.padding(SizeKt.m789sizeInqDBjuR0$default(Modifier.Companion, TooltipKt.getTooltipMinWidth(), TooltipKt.getTooltipMinHeight(), TooltipKt.getPlainTooltipMaxWidth(), 0.0f, 8, null), TooltipKt.getPlainTooltipContentPadding());
                            long j13 = j4;
                            Function2<Composer, Integer, Unit> function22 = function2;
                            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, padding);
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
                            Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, 1903647947, "C106@4266L5,108@4285L181:Tooltip.android.kt#uh7d8r");
                            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(j13)), TextKt.getLocalTextStyle().provides(TypographyKt.getValue(PlainTooltipTokens.INSTANCE.getSupportingTextFont(), composer3, 6))}, function22, composer3, ProvidedValue.$stable);
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
                }, startRestartGroup, 54), composer2, ((i6 >> 9) & 896) | (i10 & 112) | 12582912 | (57344 & i10) | (i10 & 458752), 72);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                j9 = j4;
                shape4 = shape3;
                j10 = j8;
                f6 = f5;
                f7 = f4;
            } else {
                startRestartGroup.skipToGroupEnd();
                j7 = j;
                composer2 = startRestartGroup;
                modifier3 = companion;
                shape4 = shape2;
                j10 = j5;
                j9 = j4;
                f6 = f3;
                f7 = f2;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$PlainTooltip$2
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
                        Tooltip_androidKt.m2648PlainTooltip7QI4Sbk(TooltipScope.this, modifier3, j7, shape4, j9, j10, f6, f7, function2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        companion = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
        }
        if ((i & 3072) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        i4 = i2 & 32;
        if (i4 == 0) {
        }
        i5 = i2 & 64;
        if (i5 == 0) {
        }
        if ((i2 & 128) == 0) {
        }
        if ((38347923 & i3) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i9 != 0) {
        }
        if ((i2 & 2) == 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i4 == 0) {
        }
        if (i5 == 0) {
        }
        i6 = i3;
        j7 = j6;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(-333850415);
        ComposerKt.sourceInformation(startRestartGroup, "76@3183L7,77@3242L7,78@3281L343");
        if (j7 == InlineClassHelperKt.UnspecifiedPackedFloats) {
        }
        startRestartGroup.endReplaceGroup();
        int i102 = i6 >> 6;
        composer2 = startRestartGroup;
        SurfaceKt.m2347SurfaceT9BRK9s(modifier2, shape3, j8, 0L, f5, f4, null, ComposableLambdaKt.rememberComposableLambda(1430116975, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$PlainTooltip$1
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
                ComposerKt.sourceInformation(composer3, "C97@3886L590:Tooltip.android.kt#uh7d8r");
                if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1430116975, i11, -1, "androidx.compose.material3.PlainTooltip.<anonymous> (Tooltip.android.kt:97)");
                    }
                    Modifier padding = PaddingKt.padding(SizeKt.m789sizeInqDBjuR0$default(Modifier.Companion, TooltipKt.getTooltipMinWidth(), TooltipKt.getTooltipMinHeight(), TooltipKt.getPlainTooltipMaxWidth(), 0.0f, 8, null), TooltipKt.getPlainTooltipContentPadding());
                    long j13 = j4;
                    Function2<Composer, Integer, Unit> function22 = function2;
                    ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, padding);
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
                    Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, 1903647947, "C106@4266L5,108@4285L181:Tooltip.android.kt#uh7d8r");
                    CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(j13)), TextKt.getLocalTextStyle().provides(TypographyKt.getValue(PlainTooltipTokens.INSTANCE.getSupportingTextFont(), composer3, 6))}, function22, composer3, ProvidedValue.$stable);
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
        }, startRestartGroup, 54), composer2, ((i6 >> 9) & 896) | (i102 & 112) | 12582912 | (57344 & i102) | (i102 & 458752), 72);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = companion;
        j9 = j4;
        shape4 = shape3;
        j10 = j8;
        f6 = f5;
        f7 = f4;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:188:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0104  */
    /* renamed from: RichTooltip-yDvdmqw  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2649RichTooltipyDvdmqw(final TooltipScope tooltipScope, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, long j, Shape shape, RichTooltipColors richTooltipColors, float f, float f2, final Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        int i4;
        final Object obj;
        int i5;
        final Object obj2;
        long j2;
        Object obj3;
        int i6;
        int i7;
        int i8;
        RichTooltipColors richTooltipColors2;
        float f3;
        int i9;
        float f4;
        RichTooltipColors richTooltipColors3;
        long j3;
        Modifier modifier2;
        final RichTooltipColors richTooltipColors4;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final float f5;
        final float f6;
        final Modifier modifier3;
        final long j4;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Shape shape2;
        ScopeUpdateScope endRestartGroup;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(1867454921);
        ComposerKt.sourceInformation(startRestartGroup, "C(RichTooltip)P(3,7!1,1:c#ui.unit.DpSize,5!1,8:c#ui.unit.Dp,4:c#ui.unit.Dp)255@9959L25,257@10034L19,*148@5873L7,150@5944L11,150@5956L61,178@6991L1595,167@6622L1964:Tooltip.android.kt#uh7d8r");
        if ((Integer.MIN_VALUE & i2) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? startRestartGroup.changed(tooltipScope) : startRestartGroup.changedInstance(tooltipScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 1;
        if (i11 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 32 : 16;
            i4 = i2 & 2;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj = function2;
                i3 |= startRestartGroup.changedInstance(obj) ? 256 : 128;
                i5 = i2 & 4;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    obj2 = function22;
                    i3 |= startRestartGroup.changedInstance(obj2) ? 2048 : 1024;
                    if ((i & 24576) != 0) {
                        j2 = j;
                        i3 |= ((i2 & 8) == 0 && startRestartGroup.changed(j2)) ? 16384 : 8192;
                    } else {
                        j2 = j;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 16) == 0) {
                            obj3 = shape;
                            if (startRestartGroup.changed(obj3)) {
                                i10 = 131072;
                                i3 |= i10;
                            }
                        } else {
                            obj3 = shape;
                        }
                        i10 = 65536;
                        i3 |= i10;
                    } else {
                        obj3 = shape;
                    }
                    if ((i & 1572864) == 0) {
                        i3 |= ((i2 & 32) == 0 && startRestartGroup.changed(richTooltipColors)) ? 1048576 : 524288;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changed(f) ? 8388608 : 4194304;
                    }
                    i7 = i2 & 128;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i8 = i7;
                        i3 |= startRestartGroup.changed(f2) ? 67108864 : 33554432;
                        if ((i2 & 256) != 0) {
                            i3 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i3 |= startRestartGroup.changedInstance(function23) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        }
                        int i12 = i3;
                        if ((306783379 & i3) == 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i11 != 0) {
                                    companion = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    obj = null;
                                }
                                if (i5 != 0) {
                                    obj2 = null;
                                }
                                if ((i2 & 8) != 0) {
                                    j2 = DpSize.Companion.m6791getUnspecifiedMYxV2XQ();
                                    i12 &= -57345;
                                }
                                if ((i2 & 16) != 0) {
                                    i12 &= -458753;
                                    obj3 = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(startRestartGroup, 6);
                                }
                                if ((i2 & 32) != 0) {
                                    richTooltipColors2 = TooltipDefaults.INSTANCE.richTooltipColors(startRestartGroup, 6);
                                    i12 &= -3670017;
                                } else {
                                    richTooltipColors2 = richTooltipColors;
                                }
                                float m2977getLevel0D9Ej5fM = i6 != 0 ? ElevationTokens.INSTANCE.m2977getLevel0D9Ej5fM() : f;
                                if (i8 != 0) {
                                    int i13 = i12;
                                    f3 = m2977getLevel0D9Ej5fM;
                                    i9 = i13;
                                    f4 = RichTooltipTokens.INSTANCE.m3275getContainerElevationD9Ej5fM();
                                } else {
                                    int i14 = i12;
                                    f3 = m2977getLevel0D9Ej5fM;
                                    i9 = i14;
                                    f4 = f2;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i12 &= -57345;
                                }
                                if ((i2 & 16) != 0) {
                                    i12 &= -458753;
                                }
                                if ((i2 & 32) != 0) {
                                    i12 &= -3670017;
                                }
                                richTooltipColors2 = richTooltipColors;
                                f4 = f2;
                                i9 = i12;
                                f3 = f;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1867454921, i9, -1, "androidx.compose.material3.RichTooltip (Tooltip.android.kt:147)");
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume = startRestartGroup.consume(SurfaceKt.getLocalAbsoluteTonalElevation());
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            final long m1731applyTonalElevationRFCenO8 = ColorSchemeKt.m1731applyTonalElevationRFCenO8(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 6), richTooltipColors2.m2203getContainerColor0d7_KjU(), Dp.m6684constructorimpl(((Dp) consume).m6698unboximpl() + f3), startRestartGroup, 0);
                            Shape shape3 = obj3;
                            startRestartGroup.startReplaceGroup(1472746423);
                            ComposerKt.sourceInformation(startRestartGroup, "153@6122L7,154@6181L7,155@6220L341");
                            if (j2 != InlineClassHelperKt.UnspecifiedPackedFloats) {
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                final Density density = (Density) consume2;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume3 = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                final Configuration configuration = (Configuration) consume3;
                                Modifier.Companion companion2 = Modifier.Companion;
                                richTooltipColors3 = richTooltipColors2;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1472751513, "CC(remember):Tooltip.android.kt#9igjgp");
                                boolean changed = startRestartGroup.changed(density) | startRestartGroup.changedInstance(configuration) | startRestartGroup.changed(m1731applyTonalElevationRFCenO8) | ((((57344 & i9) ^ 24576) > 16384 && startRestartGroup.changed(j2)) || (i9 & 24576) == 16384);
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                                    final long j5 = j2;
                                    Object obj4 = new Function2<CacheDrawScope, LayoutCoordinates, DrawResult>() { // from class: androidx.compose.material3.Tooltip_androidKt$RichTooltip$drawCaretModifier$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final DrawResult invoke(CacheDrawScope cacheDrawScope, LayoutCoordinates layoutCoordinates) {
                                            DrawResult m2651drawCaretWithPathJKumZY;
                                            m2651drawCaretWithPathJKumZY = Tooltip_androidKt.m2651drawCaretWithPathJKumZY(cacheDrawScope, CaretType.Rich, Density.this, configuration, m1731applyTonalElevationRFCenO8, j5, layoutCoordinates);
                                            return m2651drawCaretWithPathJKumZY;
                                        }
                                    };
                                    j3 = j5;
                                    rememberedValue = (Function2) obj4;
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                } else {
                                    j3 = j2;
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                modifier2 = tooltipScope.drawCaret(companion2, (Function2) rememberedValue).then(companion);
                            } else {
                                richTooltipColors3 = richTooltipColors2;
                                j3 = j2;
                                modifier2 = companion;
                            }
                            startRestartGroup.endReplaceGroup();
                            richTooltipColors4 = richTooltipColors3;
                            int i15 = i9 >> 9;
                            SurfaceKt.m2347SurfaceT9BRK9s(SizeKt.m789sizeInqDBjuR0$default(modifier2, TooltipKt.getTooltipMinWidth(), TooltipKt.getTooltipMinHeight(), TooltipKt.getRichTooltipMaxWidth(), 0.0f, 8, null), shape3, richTooltipColors3.m2203getContainerColor0d7_KjU(), 0L, f3, f4, null, ComposableLambdaKt.rememberComposableLambda(317290958, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$RichTooltip$1
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

                                /* JADX WARN: Multi-variable type inference failed */
                                /* JADX WARN: Type inference failed for: r19v0 */
                                /* JADX WARN: Type inference failed for: r19v1 */
                                /* JADX WARN: Type inference failed for: r19v2 */
                                public final void invoke(Composer composer3, int i16) {
                                    ?? r19;
                                    Function2<Composer, Integer, Unit> function26;
                                    RichTooltipColors richTooltipColors5;
                                    ComposerKt.sourceInformation(composer3, "C179@7066L5,180@7133L5,181@7210L5,183@7225L1355:Tooltip.android.kt#uh7d8r");
                                    if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(317290958, i16, -1, "androidx.compose.material3.RichTooltip.<anonymous> (Tooltip.android.kt:179)");
                                        }
                                        TextStyle value = TypographyKt.getValue(RichTooltipTokens.INSTANCE.getActionLabelTextFont(), composer3, 6);
                                        TextStyle value2 = TypographyKt.getValue(RichTooltipTokens.INSTANCE.getSubheadFont(), composer3, 6);
                                        TextStyle value3 = TypographyKt.getValue(RichTooltipTokens.INSTANCE.getSupportingTextFont(), composer3, 6);
                                        Modifier m740paddingVpY3zN4$default = PaddingKt.m740paddingVpY3zN4$default(Modifier.Companion, TooltipKt.getRichTooltipHorizontalPadding(), 0.0f, 2, null);
                                        Function2<Composer, Integer, Unit> function27 = obj;
                                        Function2<Composer, Integer, Unit> function28 = obj2;
                                        RichTooltipColors richTooltipColors6 = richTooltipColors4;
                                        Function2<Composer, Integer, Unit> function29 = function23;
                                        ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer3, 0);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, m740paddingVpY3zN4$default);
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
                                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer3, -459254051, "C193@7718L319:Tooltip.android.kt#uh7d8r");
                                        composer3.startReplaceGroup(955016030);
                                        ComposerKt.sourceInformation(composer3, "*185@7347L344");
                                        if (function27 == null) {
                                            function26 = function28;
                                            richTooltipColors5 = richTooltipColors6;
                                            r19 = 1;
                                        } else {
                                            r19 = 1;
                                            function26 = function28;
                                            richTooltipColors5 = richTooltipColors6;
                                            Modifier m594paddingFromBaselineVpY3zN4$default = AlignmentLineKt.m594paddingFromBaselineVpY3zN4$default(Modifier.Companion, TooltipKt.getHeightToSubheadFirstLine(), 0.0f, 2, null);
                                            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, m594paddingFromBaselineVpY3zN4$default);
                                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor2);
                                            } else {
                                                composer3.useNode();
                                            }
                                            Composer m3520constructorimpl2 = Updater.m3520constructorimpl(composer3);
                                            Updater.m3527setimpl(m3520constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                            }
                                            Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer3, 1468424960, "C186@7446L227:Tooltip.android.kt#uh7d8r");
                                            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(richTooltipColors5.m2205getTitleContentColor0d7_KjU())), TextKt.getLocalTextStyle().provides(value2)}, function27, composer3, ProvidedValue.$stable);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            composer3.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            Unit unit = Unit.INSTANCE;
                                            Unit unit2 = Unit.INSTANCE;
                                        }
                                        composer3.endReplaceGroup();
                                        Modifier textVerticalPadding = TooltipKt.textVerticalPadding(Modifier.Companion, function27 != null ? r19 : false, function26 != null ? r19 : false);
                                        ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                                        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer3, textVerticalPadding);
                                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor3);
                                        } else {
                                            composer3.useNode();
                                        }
                                        Composer m3520constructorimpl3 = Updater.m3520constructorimpl(composer3);
                                        Updater.m3527setimpl(m3520constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                            m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                            m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                        }
                                        Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1959181329, "C194@7812L211:Tooltip.android.kt#uh7d8r");
                                        ProvidedValue[] providedValueArr = new ProvidedValue[2];
                                        providedValueArr[0] = ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(richTooltipColors5.m2204getContentColor0d7_KjU()));
                                        providedValueArr[r19] = TextKt.getLocalTextStyle().provides(value3);
                                        CompositionLocalKt.CompositionLocalProvider(providedValueArr, function29, composer3, ProvidedValue.$stable);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.startReplaceGroup(955039618);
                                        ComposerKt.sourceInformation(composer3, "*201@8080L476");
                                        if (function26 != null) {
                                            Modifier m742paddingqDBjuR0$default = PaddingKt.m742paddingqDBjuR0$default(SizeKt.m776requiredHeightInVpY3zN4$default(Modifier.Companion, TooltipKt.getActionLabelMinHeight(), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, TooltipKt.getActionLabelBottomPadding(), 7, null);
                                            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                            MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer3, m742paddingqDBjuR0$default);
                                            Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor4);
                                            } else {
                                                composer3.useNode();
                                            }
                                            Composer m3520constructorimpl4 = Updater.m3520constructorimpl(composer3);
                                            Updater.m3527setimpl(m3520constructorimpl4, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m3527setimpl(m3520constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (m3520constructorimpl4.getInserting() || !Intrinsics.areEqual(m3520constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                                m3520constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                                m3520constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                            }
                                            Updater.m3527setimpl(m3520constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer3, 1469278235, "C206@8306L232:Tooltip.android.kt#uh7d8r");
                                            ProvidedValue[] providedValueArr2 = new ProvidedValue[2];
                                            providedValueArr2[0] = ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(richTooltipColors5.m2202getActionContentColor0d7_KjU()));
                                            providedValueArr2[r19] = TextKt.getLocalTextStyle().provides(value);
                                            CompositionLocalKt.CompositionLocalProvider(providedValueArr2, function26, composer3, ProvidedValue.$stable);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            composer3.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            Unit unit3 = Unit.INSTANCE;
                                            Unit unit4 = Unit.INSTANCE;
                                        }
                                        composer3.endReplaceGroup();
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
                            }, startRestartGroup, 54), startRestartGroup, ((i9 >> 12) & 112) | 12582912 | (57344 & i15) | (i15 & 458752), 72);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2 = startRestartGroup;
                            function24 = obj2;
                            f5 = f3;
                            f6 = f4;
                            long j6 = j3;
                            modifier3 = companion;
                            j4 = j6;
                            function25 = obj;
                            shape2 = shape3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            richTooltipColors4 = richTooltipColors;
                            composer2 = startRestartGroup;
                            modifier3 = companion;
                            function25 = obj;
                            function24 = obj2;
                            shape2 = obj3;
                            j4 = j2;
                            f5 = f;
                            f6 = f2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$RichTooltip$2
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
                                    Tooltip_androidKt.m2649RichTooltipyDvdmqw(TooltipScope.this, modifier3, function25, function24, j4, shape2, richTooltipColors4, f5, f6, function23, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i8 = i7;
                    if ((i2 & 256) != 0) {
                    }
                    int i122 = i3;
                    if ((306783379 & i3) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 8) != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume4 = startRestartGroup.consume(SurfaceKt.getLocalAbsoluteTonalElevation());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final long m1731applyTonalElevationRFCenO82 = ColorSchemeKt.m1731applyTonalElevationRFCenO8(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 6), richTooltipColors2.m2203getContainerColor0d7_KjU(), Dp.m6684constructorimpl(((Dp) consume4).m6698unboximpl() + f3), startRestartGroup, 0);
                    Shape shape32 = obj3;
                    startRestartGroup.startReplaceGroup(1472746423);
                    ComposerKt.sourceInformation(startRestartGroup, "153@6122L7,154@6181L7,155@6220L341");
                    if (j2 != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    }
                    startRestartGroup.endReplaceGroup();
                    richTooltipColors4 = richTooltipColors3;
                    int i152 = i9 >> 9;
                    SurfaceKt.m2347SurfaceT9BRK9s(SizeKt.m789sizeInqDBjuR0$default(modifier2, TooltipKt.getTooltipMinWidth(), TooltipKt.getTooltipMinHeight(), TooltipKt.getRichTooltipMaxWidth(), 0.0f, 8, null), shape32, richTooltipColors3.m2203getContainerColor0d7_KjU(), 0L, f3, f4, null, ComposableLambdaKt.rememberComposableLambda(317290958, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$RichTooltip$1
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

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r19v0 */
                        /* JADX WARN: Type inference failed for: r19v1 */
                        /* JADX WARN: Type inference failed for: r19v2 */
                        public final void invoke(Composer composer3, int i16) {
                            ?? r19;
                            Function2<Composer, Integer, Unit> function26;
                            RichTooltipColors richTooltipColors5;
                            ComposerKt.sourceInformation(composer3, "C179@7066L5,180@7133L5,181@7210L5,183@7225L1355:Tooltip.android.kt#uh7d8r");
                            if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(317290958, i16, -1, "androidx.compose.material3.RichTooltip.<anonymous> (Tooltip.android.kt:179)");
                                }
                                TextStyle value = TypographyKt.getValue(RichTooltipTokens.INSTANCE.getActionLabelTextFont(), composer3, 6);
                                TextStyle value2 = TypographyKt.getValue(RichTooltipTokens.INSTANCE.getSubheadFont(), composer3, 6);
                                TextStyle value3 = TypographyKt.getValue(RichTooltipTokens.INSTANCE.getSupportingTextFont(), composer3, 6);
                                Modifier m740paddingVpY3zN4$default = PaddingKt.m740paddingVpY3zN4$default(Modifier.Companion, TooltipKt.getRichTooltipHorizontalPadding(), 0.0f, 2, null);
                                Function2<Composer, Integer, Unit> function27 = obj;
                                Function2<Composer, Integer, Unit> function28 = obj2;
                                RichTooltipColors richTooltipColors6 = richTooltipColors4;
                                Function2<Composer, Integer, Unit> function29 = function23;
                                ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer3, 0);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, m740paddingVpY3zN4$default);
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
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, -459254051, "C193@7718L319:Tooltip.android.kt#uh7d8r");
                                composer3.startReplaceGroup(955016030);
                                ComposerKt.sourceInformation(composer3, "*185@7347L344");
                                if (function27 == null) {
                                    function26 = function28;
                                    richTooltipColors5 = richTooltipColors6;
                                    r19 = 1;
                                } else {
                                    r19 = 1;
                                    function26 = function28;
                                    richTooltipColors5 = richTooltipColors6;
                                    Modifier m594paddingFromBaselineVpY3zN4$default = AlignmentLineKt.m594paddingFromBaselineVpY3zN4$default(Modifier.Companion, TooltipKt.getHeightToSubheadFirstLine(), 0.0f, 2, null);
                                    ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, m594paddingFromBaselineVpY3zN4$default);
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor2);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m3520constructorimpl2 = Updater.m3520constructorimpl(composer3);
                                    Updater.m3527setimpl(m3520constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 1468424960, "C186@7446L227:Tooltip.android.kt#uh7d8r");
                                    CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(richTooltipColors5.m2205getTitleContentColor0d7_KjU())), TextKt.getLocalTextStyle().provides(value2)}, function27, composer3, ProvidedValue.$stable);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    Unit unit = Unit.INSTANCE;
                                    Unit unit2 = Unit.INSTANCE;
                                }
                                composer3.endReplaceGroup();
                                Modifier textVerticalPadding = TooltipKt.textVerticalPadding(Modifier.Companion, function27 != null ? r19 : false, function26 != null ? r19 : false);
                                ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer3, textVerticalPadding);
                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor3);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m3520constructorimpl3 = Updater.m3520constructorimpl(composer3);
                                Updater.m3527setimpl(m3520constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                    m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                    m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                }
                                Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, -1959181329, "C194@7812L211:Tooltip.android.kt#uh7d8r");
                                ProvidedValue[] providedValueArr = new ProvidedValue[2];
                                providedValueArr[0] = ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(richTooltipColors5.m2204getContentColor0d7_KjU()));
                                providedValueArr[r19] = TextKt.getLocalTextStyle().provides(value3);
                                CompositionLocalKt.CompositionLocalProvider(providedValueArr, function29, composer3, ProvidedValue.$stable);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.startReplaceGroup(955039618);
                                ComposerKt.sourceInformation(composer3, "*201@8080L476");
                                if (function26 != null) {
                                    Modifier m742paddingqDBjuR0$default = PaddingKt.m742paddingqDBjuR0$default(SizeKt.m776requiredHeightInVpY3zN4$default(Modifier.Companion, TooltipKt.getActionLabelMinHeight(), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, TooltipKt.getActionLabelBottomPadding(), 7, null);
                                    ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                    MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer3, m742paddingqDBjuR0$default);
                                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor4);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m3520constructorimpl4 = Updater.m3520constructorimpl(composer3);
                                    Updater.m3527setimpl(m3520constructorimpl4, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m3527setimpl(m3520constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m3520constructorimpl4.getInserting() || !Intrinsics.areEqual(m3520constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                        m3520constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                        m3520constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                    }
                                    Updater.m3527setimpl(m3520constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 1469278235, "C206@8306L232:Tooltip.android.kt#uh7d8r");
                                    ProvidedValue[] providedValueArr2 = new ProvidedValue[2];
                                    providedValueArr2[0] = ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(richTooltipColors5.m2202getActionContentColor0d7_KjU()));
                                    providedValueArr2[r19] = TextKt.getLocalTextStyle().provides(value);
                                    CompositionLocalKt.CompositionLocalProvider(providedValueArr2, function26, composer3, ProvidedValue.$stable);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    Unit unit3 = Unit.INSTANCE;
                                    Unit unit4 = Unit.INSTANCE;
                                }
                                composer3.endReplaceGroup();
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
                    }, startRestartGroup, 54), startRestartGroup, ((i9 >> 12) & 112) | 12582912 | (57344 & i152) | (i152 & 458752), 72);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    function24 = obj2;
                    f5 = f3;
                    f6 = f4;
                    long j62 = j3;
                    modifier3 = companion;
                    j4 = j62;
                    function25 = obj;
                    shape2 = shape32;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj2 = function22;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                if ((i & 1572864) == 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                i7 = i2 & 128;
                if (i7 == 0) {
                }
                i8 = i7;
                if ((i2 & 256) != 0) {
                }
                int i1222 = i3;
                if ((306783379 & i3) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i11 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i6 != 0) {
                }
                if (i8 != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume42 = startRestartGroup.consume(SurfaceKt.getLocalAbsoluteTonalElevation());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final long m1731applyTonalElevationRFCenO822 = ColorSchemeKt.m1731applyTonalElevationRFCenO8(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 6), richTooltipColors2.m2203getContainerColor0d7_KjU(), Dp.m6684constructorimpl(((Dp) consume42).m6698unboximpl() + f3), startRestartGroup, 0);
                Shape shape322 = obj3;
                startRestartGroup.startReplaceGroup(1472746423);
                ComposerKt.sourceInformation(startRestartGroup, "153@6122L7,154@6181L7,155@6220L341");
                if (j2 != InlineClassHelperKt.UnspecifiedPackedFloats) {
                }
                startRestartGroup.endReplaceGroup();
                richTooltipColors4 = richTooltipColors3;
                int i1522 = i9 >> 9;
                SurfaceKt.m2347SurfaceT9BRK9s(SizeKt.m789sizeInqDBjuR0$default(modifier2, TooltipKt.getTooltipMinWidth(), TooltipKt.getTooltipMinHeight(), TooltipKt.getRichTooltipMaxWidth(), 0.0f, 8, null), shape322, richTooltipColors3.m2203getContainerColor0d7_KjU(), 0L, f3, f4, null, ComposableLambdaKt.rememberComposableLambda(317290958, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$RichTooltip$1
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

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r19v0 */
                    /* JADX WARN: Type inference failed for: r19v1 */
                    /* JADX WARN: Type inference failed for: r19v2 */
                    public final void invoke(Composer composer3, int i16) {
                        ?? r19;
                        Function2<Composer, Integer, Unit> function26;
                        RichTooltipColors richTooltipColors5;
                        ComposerKt.sourceInformation(composer3, "C179@7066L5,180@7133L5,181@7210L5,183@7225L1355:Tooltip.android.kt#uh7d8r");
                        if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(317290958, i16, -1, "androidx.compose.material3.RichTooltip.<anonymous> (Tooltip.android.kt:179)");
                            }
                            TextStyle value = TypographyKt.getValue(RichTooltipTokens.INSTANCE.getActionLabelTextFont(), composer3, 6);
                            TextStyle value2 = TypographyKt.getValue(RichTooltipTokens.INSTANCE.getSubheadFont(), composer3, 6);
                            TextStyle value3 = TypographyKt.getValue(RichTooltipTokens.INSTANCE.getSupportingTextFont(), composer3, 6);
                            Modifier m740paddingVpY3zN4$default = PaddingKt.m740paddingVpY3zN4$default(Modifier.Companion, TooltipKt.getRichTooltipHorizontalPadding(), 0.0f, 2, null);
                            Function2<Composer, Integer, Unit> function27 = obj;
                            Function2<Composer, Integer, Unit> function28 = obj2;
                            RichTooltipColors richTooltipColors6 = richTooltipColors4;
                            Function2<Composer, Integer, Unit> function29 = function23;
                            ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer3, 0);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, m740paddingVpY3zN4$default);
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
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, -459254051, "C193@7718L319:Tooltip.android.kt#uh7d8r");
                            composer3.startReplaceGroup(955016030);
                            ComposerKt.sourceInformation(composer3, "*185@7347L344");
                            if (function27 == null) {
                                function26 = function28;
                                richTooltipColors5 = richTooltipColors6;
                                r19 = 1;
                            } else {
                                r19 = 1;
                                function26 = function28;
                                richTooltipColors5 = richTooltipColors6;
                                Modifier m594paddingFromBaselineVpY3zN4$default = AlignmentLineKt.m594paddingFromBaselineVpY3zN4$default(Modifier.Companion, TooltipKt.getHeightToSubheadFirstLine(), 0.0f, 2, null);
                                ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, m594paddingFromBaselineVpY3zN4$default);
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor2);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m3520constructorimpl2 = Updater.m3520constructorimpl(composer3);
                                Updater.m3527setimpl(m3520constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, 1468424960, "C186@7446L227:Tooltip.android.kt#uh7d8r");
                                CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(richTooltipColors5.m2205getTitleContentColor0d7_KjU())), TextKt.getLocalTextStyle().provides(value2)}, function27, composer3, ProvidedValue.$stable);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Unit unit = Unit.INSTANCE;
                                Unit unit2 = Unit.INSTANCE;
                            }
                            composer3.endReplaceGroup();
                            Modifier textVerticalPadding = TooltipKt.textVerticalPadding(Modifier.Companion, function27 != null ? r19 : false, function26 != null ? r19 : false);
                            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer3, textVerticalPadding);
                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor3);
                            } else {
                                composer3.useNode();
                            }
                            Composer m3520constructorimpl3 = Updater.m3520constructorimpl(composer3);
                            Updater.m3527setimpl(m3520constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                            }
                            Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, -1959181329, "C194@7812L211:Tooltip.android.kt#uh7d8r");
                            ProvidedValue[] providedValueArr = new ProvidedValue[2];
                            providedValueArr[0] = ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(richTooltipColors5.m2204getContentColor0d7_KjU()));
                            providedValueArr[r19] = TextKt.getLocalTextStyle().provides(value3);
                            CompositionLocalKt.CompositionLocalProvider(providedValueArr, function29, composer3, ProvidedValue.$stable);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.startReplaceGroup(955039618);
                            ComposerKt.sourceInformation(composer3, "*201@8080L476");
                            if (function26 != null) {
                                Modifier m742paddingqDBjuR0$default = PaddingKt.m742paddingqDBjuR0$default(SizeKt.m776requiredHeightInVpY3zN4$default(Modifier.Companion, TooltipKt.getActionLabelMinHeight(), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, TooltipKt.getActionLabelBottomPadding(), 7, null);
                                ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer3, m742paddingqDBjuR0$default);
                                Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor4);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m3520constructorimpl4 = Updater.m3520constructorimpl(composer3);
                                Updater.m3527setimpl(m3520constructorimpl4, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m3527setimpl(m3520constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m3520constructorimpl4.getInserting() || !Intrinsics.areEqual(m3520constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                    m3520constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                    m3520constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                }
                                Updater.m3527setimpl(m3520constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, 1469278235, "C206@8306L232:Tooltip.android.kt#uh7d8r");
                                ProvidedValue[] providedValueArr2 = new ProvidedValue[2];
                                providedValueArr2[0] = ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(richTooltipColors5.m2202getActionContentColor0d7_KjU()));
                                providedValueArr2[r19] = TextKt.getLocalTextStyle().provides(value);
                                CompositionLocalKt.CompositionLocalProvider(providedValueArr2, function26, composer3, ProvidedValue.$stable);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Unit unit3 = Unit.INSTANCE;
                                Unit unit4 = Unit.INSTANCE;
                            }
                            composer3.endReplaceGroup();
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
                }, startRestartGroup, 54), startRestartGroup, ((i9 >> 12) & 112) | 12582912 | (57344 & i1522) | (i1522 & 458752), 72);
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                function24 = obj2;
                f5 = f3;
                f6 = f4;
                long j622 = j3;
                modifier3 = companion;
                j4 = j622;
                function25 = obj;
                shape2 = shape322;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj = function2;
            i5 = i2 & 4;
            if (i5 != 0) {
            }
            obj2 = function22;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            i7 = i2 & 128;
            if (i7 == 0) {
            }
            i8 = i7;
            if ((i2 & 256) != 0) {
            }
            int i12222 = i3;
            if ((306783379 & i3) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i11 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i6 != 0) {
            }
            if (i8 != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume422 = startRestartGroup.consume(SurfaceKt.getLocalAbsoluteTonalElevation());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final long m1731applyTonalElevationRFCenO8222 = ColorSchemeKt.m1731applyTonalElevationRFCenO8(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 6), richTooltipColors2.m2203getContainerColor0d7_KjU(), Dp.m6684constructorimpl(((Dp) consume422).m6698unboximpl() + f3), startRestartGroup, 0);
            Shape shape3222 = obj3;
            startRestartGroup.startReplaceGroup(1472746423);
            ComposerKt.sourceInformation(startRestartGroup, "153@6122L7,154@6181L7,155@6220L341");
            if (j2 != InlineClassHelperKt.UnspecifiedPackedFloats) {
            }
            startRestartGroup.endReplaceGroup();
            richTooltipColors4 = richTooltipColors3;
            int i15222 = i9 >> 9;
            SurfaceKt.m2347SurfaceT9BRK9s(SizeKt.m789sizeInqDBjuR0$default(modifier2, TooltipKt.getTooltipMinWidth(), TooltipKt.getTooltipMinHeight(), TooltipKt.getRichTooltipMaxWidth(), 0.0f, 8, null), shape3222, richTooltipColors3.m2203getContainerColor0d7_KjU(), 0L, f3, f4, null, ComposableLambdaKt.rememberComposableLambda(317290958, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$RichTooltip$1
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

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r19v0 */
                /* JADX WARN: Type inference failed for: r19v1 */
                /* JADX WARN: Type inference failed for: r19v2 */
                public final void invoke(Composer composer3, int i16) {
                    ?? r19;
                    Function2<Composer, Integer, Unit> function26;
                    RichTooltipColors richTooltipColors5;
                    ComposerKt.sourceInformation(composer3, "C179@7066L5,180@7133L5,181@7210L5,183@7225L1355:Tooltip.android.kt#uh7d8r");
                    if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(317290958, i16, -1, "androidx.compose.material3.RichTooltip.<anonymous> (Tooltip.android.kt:179)");
                        }
                        TextStyle value = TypographyKt.getValue(RichTooltipTokens.INSTANCE.getActionLabelTextFont(), composer3, 6);
                        TextStyle value2 = TypographyKt.getValue(RichTooltipTokens.INSTANCE.getSubheadFont(), composer3, 6);
                        TextStyle value3 = TypographyKt.getValue(RichTooltipTokens.INSTANCE.getSupportingTextFont(), composer3, 6);
                        Modifier m740paddingVpY3zN4$default = PaddingKt.m740paddingVpY3zN4$default(Modifier.Companion, TooltipKt.getRichTooltipHorizontalPadding(), 0.0f, 2, null);
                        Function2<Composer, Integer, Unit> function27 = obj;
                        Function2<Composer, Integer, Unit> function28 = obj2;
                        RichTooltipColors richTooltipColors6 = richTooltipColors4;
                        Function2<Composer, Integer, Unit> function29 = function23;
                        ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer3, 0);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, m740paddingVpY3zN4$default);
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
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -459254051, "C193@7718L319:Tooltip.android.kt#uh7d8r");
                        composer3.startReplaceGroup(955016030);
                        ComposerKt.sourceInformation(composer3, "*185@7347L344");
                        if (function27 == null) {
                            function26 = function28;
                            richTooltipColors5 = richTooltipColors6;
                            r19 = 1;
                        } else {
                            r19 = 1;
                            function26 = function28;
                            richTooltipColors5 = richTooltipColors6;
                            Modifier m594paddingFromBaselineVpY3zN4$default = AlignmentLineKt.m594paddingFromBaselineVpY3zN4$default(Modifier.Companion, TooltipKt.getHeightToSubheadFirstLine(), 0.0f, 2, null);
                            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, m594paddingFromBaselineVpY3zN4$default);
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor2);
                            } else {
                                composer3.useNode();
                            }
                            Composer m3520constructorimpl2 = Updater.m3520constructorimpl(composer3);
                            Updater.m3527setimpl(m3520constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, 1468424960, "C186@7446L227:Tooltip.android.kt#uh7d8r");
                            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(richTooltipColors5.m2205getTitleContentColor0d7_KjU())), TextKt.getLocalTextStyle().provides(value2)}, function27, composer3, ProvidedValue.$stable);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Unit unit = Unit.INSTANCE;
                            Unit unit2 = Unit.INSTANCE;
                        }
                        composer3.endReplaceGroup();
                        Modifier textVerticalPadding = TooltipKt.textVerticalPadding(Modifier.Companion, function27 != null ? r19 : false, function26 != null ? r19 : false);
                        ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer3, textVerticalPadding);
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor3);
                        } else {
                            composer3.useNode();
                        }
                        Composer m3520constructorimpl3 = Updater.m3520constructorimpl(composer3);
                        Updater.m3527setimpl(m3520constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -1959181329, "C194@7812L211:Tooltip.android.kt#uh7d8r");
                        ProvidedValue[] providedValueArr = new ProvidedValue[2];
                        providedValueArr[0] = ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(richTooltipColors5.m2204getContentColor0d7_KjU()));
                        providedValueArr[r19] = TextKt.getLocalTextStyle().provides(value3);
                        CompositionLocalKt.CompositionLocalProvider(providedValueArr, function29, composer3, ProvidedValue.$stable);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.startReplaceGroup(955039618);
                        ComposerKt.sourceInformation(composer3, "*201@8080L476");
                        if (function26 != null) {
                            Modifier m742paddingqDBjuR0$default = PaddingKt.m742paddingqDBjuR0$default(SizeKt.m776requiredHeightInVpY3zN4$default(Modifier.Companion, TooltipKt.getActionLabelMinHeight(), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, TooltipKt.getActionLabelBottomPadding(), 7, null);
                            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer3, m742paddingqDBjuR0$default);
                            Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor4);
                            } else {
                                composer3.useNode();
                            }
                            Composer m3520constructorimpl4 = Updater.m3520constructorimpl(composer3);
                            Updater.m3527setimpl(m3520constructorimpl4, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m3527setimpl(m3520constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m3520constructorimpl4.getInserting() || !Intrinsics.areEqual(m3520constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                m3520constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                m3520constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                            }
                            Updater.m3527setimpl(m3520constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, 1469278235, "C206@8306L232:Tooltip.android.kt#uh7d8r");
                            ProvidedValue[] providedValueArr2 = new ProvidedValue[2];
                            providedValueArr2[0] = ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(richTooltipColors5.m2202getActionContentColor0d7_KjU()));
                            providedValueArr2[r19] = TextKt.getLocalTextStyle().provides(value);
                            CompositionLocalKt.CompositionLocalProvider(providedValueArr2, function26, composer3, ProvidedValue.$stable);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Unit unit3 = Unit.INSTANCE;
                            Unit unit4 = Unit.INSTANCE;
                        }
                        composer3.endReplaceGroup();
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
            }, startRestartGroup, 54), startRestartGroup, ((i9 >> 12) & 112) | 12582912 | (57344 & i15222) | (i15222 & 458752), 72);
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            function24 = obj2;
            f5 = f3;
            f6 = f4;
            long j6222 = j3;
            modifier3 = companion;
            j4 = j6222;
            function25 = obj;
            shape2 = shape3222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        i4 = i2 & 2;
        if (i4 == 0) {
        }
        obj = function2;
        i5 = i2 & 4;
        if (i5 != 0) {
        }
        obj2 = function22;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        i7 = i2 & 128;
        if (i7 == 0) {
        }
        i8 = i7;
        if ((i2 & 256) != 0) {
        }
        int i122222 = i3;
        if ((306783379 & i3) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i11 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i6 != 0) {
        }
        if (i8 != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume4222 = startRestartGroup.consume(SurfaceKt.getLocalAbsoluteTonalElevation());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final long m1731applyTonalElevationRFCenO82222 = ColorSchemeKt.m1731applyTonalElevationRFCenO8(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 6), richTooltipColors2.m2203getContainerColor0d7_KjU(), Dp.m6684constructorimpl(((Dp) consume4222).m6698unboximpl() + f3), startRestartGroup, 0);
        Shape shape32222 = obj3;
        startRestartGroup.startReplaceGroup(1472746423);
        ComposerKt.sourceInformation(startRestartGroup, "153@6122L7,154@6181L7,155@6220L341");
        if (j2 != InlineClassHelperKt.UnspecifiedPackedFloats) {
        }
        startRestartGroup.endReplaceGroup();
        richTooltipColors4 = richTooltipColors3;
        int i152222 = i9 >> 9;
        SurfaceKt.m2347SurfaceT9BRK9s(SizeKt.m789sizeInqDBjuR0$default(modifier2, TooltipKt.getTooltipMinWidth(), TooltipKt.getTooltipMinHeight(), TooltipKt.getRichTooltipMaxWidth(), 0.0f, 8, null), shape32222, richTooltipColors3.m2203getContainerColor0d7_KjU(), 0L, f3, f4, null, ComposableLambdaKt.rememberComposableLambda(317290958, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$RichTooltip$1
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

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r19v0 */
            /* JADX WARN: Type inference failed for: r19v1 */
            /* JADX WARN: Type inference failed for: r19v2 */
            public final void invoke(Composer composer3, int i16) {
                ?? r19;
                Function2<Composer, Integer, Unit> function26;
                RichTooltipColors richTooltipColors5;
                ComposerKt.sourceInformation(composer3, "C179@7066L5,180@7133L5,181@7210L5,183@7225L1355:Tooltip.android.kt#uh7d8r");
                if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(317290958, i16, -1, "androidx.compose.material3.RichTooltip.<anonymous> (Tooltip.android.kt:179)");
                    }
                    TextStyle value = TypographyKt.getValue(RichTooltipTokens.INSTANCE.getActionLabelTextFont(), composer3, 6);
                    TextStyle value2 = TypographyKt.getValue(RichTooltipTokens.INSTANCE.getSubheadFont(), composer3, 6);
                    TextStyle value3 = TypographyKt.getValue(RichTooltipTokens.INSTANCE.getSupportingTextFont(), composer3, 6);
                    Modifier m740paddingVpY3zN4$default = PaddingKt.m740paddingVpY3zN4$default(Modifier.Companion, TooltipKt.getRichTooltipHorizontalPadding(), 0.0f, 2, null);
                    Function2<Composer, Integer, Unit> function27 = obj;
                    Function2<Composer, Integer, Unit> function28 = obj2;
                    RichTooltipColors richTooltipColors6 = richTooltipColors4;
                    Function2<Composer, Integer, Unit> function29 = function23;
                    ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer3, 0);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, m740paddingVpY3zN4$default);
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
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, -459254051, "C193@7718L319:Tooltip.android.kt#uh7d8r");
                    composer3.startReplaceGroup(955016030);
                    ComposerKt.sourceInformation(composer3, "*185@7347L344");
                    if (function27 == null) {
                        function26 = function28;
                        richTooltipColors5 = richTooltipColors6;
                        r19 = 1;
                    } else {
                        r19 = 1;
                        function26 = function28;
                        richTooltipColors5 = richTooltipColors6;
                        Modifier m594paddingFromBaselineVpY3zN4$default = AlignmentLineKt.m594paddingFromBaselineVpY3zN4$default(Modifier.Companion, TooltipKt.getHeightToSubheadFirstLine(), 0.0f, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, m594paddingFromBaselineVpY3zN4$default);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor2);
                        } else {
                            composer3.useNode();
                        }
                        Composer m3520constructorimpl2 = Updater.m3520constructorimpl(composer3);
                        Updater.m3527setimpl(m3520constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 1468424960, "C186@7446L227:Tooltip.android.kt#uh7d8r");
                        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(richTooltipColors5.m2205getTitleContentColor0d7_KjU())), TextKt.getLocalTextStyle().provides(value2)}, function27, composer3, ProvidedValue.$stable);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Unit unit = Unit.INSTANCE;
                        Unit unit2 = Unit.INSTANCE;
                    }
                    composer3.endReplaceGroup();
                    Modifier textVerticalPadding = TooltipKt.textVerticalPadding(Modifier.Companion, function27 != null ? r19 : false, function26 != null ? r19 : false);
                    ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer3, textVerticalPadding);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor3);
                    } else {
                        composer3.useNode();
                    }
                    Composer m3520constructorimpl3 = Updater.m3520constructorimpl(composer3);
                    Updater.m3527setimpl(m3520constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, -1959181329, "C194@7812L211:Tooltip.android.kt#uh7d8r");
                    ProvidedValue[] providedValueArr = new ProvidedValue[2];
                    providedValueArr[0] = ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(richTooltipColors5.m2204getContentColor0d7_KjU()));
                    providedValueArr[r19] = TextKt.getLocalTextStyle().provides(value3);
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr, function29, composer3, ProvidedValue.$stable);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.startReplaceGroup(955039618);
                    ComposerKt.sourceInformation(composer3, "*201@8080L476");
                    if (function26 != null) {
                        Modifier m742paddingqDBjuR0$default = PaddingKt.m742paddingqDBjuR0$default(SizeKt.m776requiredHeightInVpY3zN4$default(Modifier.Companion, TooltipKt.getActionLabelMinHeight(), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, TooltipKt.getActionLabelBottomPadding(), 7, null);
                        ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer3, m742paddingqDBjuR0$default);
                        Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor4);
                        } else {
                            composer3.useNode();
                        }
                        Composer m3520constructorimpl4 = Updater.m3520constructorimpl(composer3);
                        Updater.m3527setimpl(m3520constructorimpl4, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m3527setimpl(m3520constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m3520constructorimpl4.getInserting() || !Intrinsics.areEqual(m3520constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                            m3520constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                            m3520constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                        }
                        Updater.m3527setimpl(m3520constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 1469278235, "C206@8306L232:Tooltip.android.kt#uh7d8r");
                        ProvidedValue[] providedValueArr2 = new ProvidedValue[2];
                        providedValueArr2[0] = ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(richTooltipColors5.m2202getActionContentColor0d7_KjU()));
                        providedValueArr2[r19] = TextKt.getLocalTextStyle().provides(value);
                        CompositionLocalKt.CompositionLocalProvider(providedValueArr2, function26, composer3, ProvidedValue.$stable);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Unit unit3 = Unit.INSTANCE;
                        Unit unit4 = Unit.INSTANCE;
                    }
                    composer3.endReplaceGroup();
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
        }, startRestartGroup, 54), startRestartGroup, ((i9 >> 12) & 112) | 12582912 | (57344 & i152222) | (i152222 & 458752), 72);
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        function24 = obj2;
        f5 = f3;
        f6 = f4;
        long j62222 = j3;
        modifier3 = companion;
        j4 = j62222;
        function25 = obj;
        shape2 = shape32222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawCaretWithPath-JKu-mZY  reason: not valid java name */
    public static final DrawResult m2651drawCaretWithPathJKumZY(CacheDrawScope cacheDrawScope, CaretType caretType, Density density, Configuration configuration, final long j, long j2, final LayoutCoordinates layoutCoordinates) {
        long j3;
        final Path Path = AndroidPath_androidKt.Path();
        if (layoutCoordinates != null) {
            int mo383roundToPx0680j_4 = density.mo383roundToPx0680j_4(DpSize.m6780getHeightD9Ej5fM(j2));
            int mo383roundToPx0680j_42 = density.mo383roundToPx0680j_4(DpSize.m6782getWidthD9Ej5fM(j2));
            int mo383roundToPx0680j_43 = density.mo383roundToPx0680j_4(Dp.m6684constructorimpl(configuration.screenWidthDp));
            int mo383roundToPx0680j_44 = density.mo383roundToPx0680j_4(TooltipKt.getSpacingBetweenTooltipAndAnchor());
            Rect boundsInWindow = LayoutCoordinatesKt.boundsInWindow(layoutCoordinates);
            float left = boundsInWindow.getLeft();
            float right = boundsInWindow.getRight();
            float top = boundsInWindow.getTop();
            float f = 2;
            float f2 = (right + left) / f;
            float f3 = right - left;
            float m3906getWidthimpl = Size.m3906getWidthimpl(cacheDrawScope.m3698getSizeNHjbRc());
            float m3903getHeightimpl = Size.m3903getHeightimpl(cacheDrawScope.m3698getSizeNHjbRc());
            boolean z = (top - m3903getHeightimpl) - ((float) mo383roundToPx0680j_44) < 0.0f;
            if (z) {
                m3903getHeightimpl = 0.0f;
            }
            if (caretType == CaretType.Plain) {
                float f4 = mo383roundToPx0680j_43;
                if ((m3906getWidthimpl / f) + f2 > f4) {
                    j3 = OffsetKt.Offset(m3906getWidthimpl - (f4 - f2), m3903getHeightimpl);
                } else {
                    j3 = OffsetKt.Offset(f2 - Math.max(left - ((Size.m3906getWidthimpl(cacheDrawScope.m3698getSizeNHjbRc()) / f) - (f3 / f)), 0.0f), m3903getHeightimpl);
                }
            } else {
                long Offset = OffsetKt.Offset(f2 - left, m3903getHeightimpl);
                float f5 = mo383roundToPx0680j_43;
                if (left + m3906getWidthimpl > f5) {
                    float f6 = right - m3906getWidthimpl;
                    Offset = OffsetKt.Offset(f2 - f6, m3903getHeightimpl);
                    if (f6 < 0.0f) {
                        float f7 = m3906getWidthimpl / f;
                        float f8 = f3 / f;
                        if ((left - f7) + f8 <= 0.0f) {
                            j3 = OffsetKt.Offset(f2, m3903getHeightimpl);
                        } else if ((right + f7) - f8 >= f5) {
                            j3 = OffsetKt.Offset(m3906getWidthimpl - (f5 - f2), m3903getHeightimpl);
                        } else {
                            j3 = OffsetKt.Offset(f7, m3903getHeightimpl);
                        }
                    }
                }
                j3 = Offset;
            }
            if (z) {
                Path.moveTo(Offset.m3837getXimpl(j3), Offset.m3838getYimpl(j3));
                float f9 = mo383roundToPx0680j_42 / 2;
                Path.lineTo(Offset.m3837getXimpl(j3) + f9, Offset.m3838getYimpl(j3));
                Path.lineTo(Offset.m3837getXimpl(j3), Offset.m3838getYimpl(j3) - mo383roundToPx0680j_4);
                Path.lineTo(Offset.m3837getXimpl(j3) - f9, Offset.m3838getYimpl(j3));
                Path.close();
            } else {
                Path.moveTo(Offset.m3837getXimpl(j3), Offset.m3838getYimpl(j3));
                float f10 = mo383roundToPx0680j_42 / 2;
                Path.lineTo(Offset.m3837getXimpl(j3) + f10, Offset.m3838getYimpl(j3));
                Path.lineTo(Offset.m3837getXimpl(j3), Offset.m3838getYimpl(j3) + mo383roundToPx0680j_4);
                Path.lineTo(Offset.m3837getXimpl(j3) - f10, Offset.m3838getYimpl(j3));
                Path.close();
            }
        }
        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$drawCaretWithPath$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope contentDrawScope) {
                if (LayoutCoordinates.this != null) {
                    contentDrawScope.drawContent();
                    DrawScope.m4630drawPathLG529CI$default(contentDrawScope, Path, j, 0.0f, null, null, 0, 60, null);
                }
            }
        });
    }
}
