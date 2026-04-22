package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* compiled from: Divider.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\t\u001a-\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\r\u0010\t¨\u0006\u000e"}, d2 = {"HorizontalDivider", "", "modifier", "Landroidx/compose/ui/Modifier;", "thickness", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "HorizontalDivider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "VerticalDivider", "VerticalDivider-9IZ8Weo", "Divider", "Divider-9IZ8Weo", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DividerKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Divider_9IZ8Weo$lambda$6(Modifier modifier, float f, long j, int i, int i2, Composer composer, int i3) {
        m2038Divider9IZ8Weo(modifier, f, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit HorizontalDivider_9IZ8Weo$lambda$2(Modifier modifier, float f, long j, int i, int i2, Composer composer, int i3) {
        m2039HorizontalDivider9IZ8Weo(modifier, f, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit VerticalDivider_9IZ8Weo$lambda$5(Modifier modifier, float f, long j, int i, int i2, Composer composer, int i3) {
        m2040VerticalDivider9IZ8Weo(modifier, f, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* renamed from: HorizontalDivider-9IZ8Weo  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2039HorizontalDivider9IZ8Weo(Modifier modifier, float f, long j, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        float f2;
        final long j2;
        Modifier.Companion companion;
        final float f3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(75144485);
        ComposerKt.sourceInformation(startRestartGroup, "C(HorizontalDivider)N(modifier,thickness:c#ui.unit.Dp,color:c#ui.graphics.Color)53@2086L220,53@2036L270:Divider.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            obj = modifier;
        } else if ((i & 6) == 0) {
            obj = modifier;
            i3 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            obj = modifier;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                j2 = j;
                i3 |= ((i2 & 4) == 0 && startRestartGroup.changed(j2)) ? 256 : 128;
            } else {
                j2 = j;
            }
            boolean z = true;
            if (startRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
                startRestartGroup.skipToGroupEnd();
                companion = obj;
                f3 = f2;
            } else {
                startRestartGroup.startDefaults();
                ComposerKt.sourceInformation(startRestartGroup, "51@2021L5");
                if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                    companion = i4 != 0 ? Modifier.Companion : obj;
                    f3 = i5 != 0 ? DividerDefaults.INSTANCE.m2037getThicknessD9Ej5fM() : f2;
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        j2 = DividerDefaults.INSTANCE.getColor(startRestartGroup, 6);
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    companion = obj;
                    f3 = f2;
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(75144485, i3, -1, "androidx.compose.material3.HorizontalDivider (Divider.kt:53)");
                }
                Modifier m850height3ABfNKs = SizeKt.m850height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), f3);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -800586783, "CC(remember):Divider.kt#9igjgp");
                boolean z2 = (i3 & 112) == 32;
                if ((((i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256 || !startRestartGroup.changed(j2)) && (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
                    z = false;
                }
                boolean z3 = z2 | z;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: androidx.compose.material3.DividerKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return DividerKt.HorizontalDivider_9IZ8Weo$lambda$1$lambda$0(f3, j2, (DrawScope) obj2);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                CanvasKt.Canvas(m850height3ABfNKs, (Function1) rememberedValue, startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier2 = companion;
                final float f4 = f3;
                final long j3 = j2;
                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DividerKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return DividerKt.HorizontalDivider_9IZ8Weo$lambda$2(Modifier.this, f4, j3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
                return;
            }
            return;
        }
        f2 = f;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        boolean z4 = true;
        if (startRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit HorizontalDivider_9IZ8Weo$lambda$1$lambda$0(float f, long j, DrawScope drawScope) {
        float f2 = drawScope.mo405toPx0680j_4(f);
        DrawScope.m5332drawLineNGM6Ib0$default(drawScope, j, Offset.m4519constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(drawScope.mo405toPx0680j_4(f) / 2.0f) & 4294967295L)), Offset.m4519constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo5346getSizeNHjbRc() >> 32))) << 32) | (Float.floatToRawIntBits(drawScope.mo405toPx0680j_4(f) / 2.0f) & 4294967295L)), f2, 0, null, 0.0f, null, 0, 496, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* renamed from: VerticalDivider-9IZ8Weo  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2040VerticalDivider9IZ8Weo(Modifier modifier, float f, long j, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        float f2;
        final long j2;
        Modifier.Companion companion;
        final float f3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1534852205);
        ComposerKt.sourceInformation(startRestartGroup, "C(VerticalDivider)N(modifier,thickness:c#ui.unit.Dp,color:c#ui.graphics.Color)81@3058L221,81@3008L271:Divider.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            obj = modifier;
        } else if ((i & 6) == 0) {
            obj = modifier;
            i3 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            obj = modifier;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                j2 = j;
                i3 |= ((i2 & 4) == 0 && startRestartGroup.changed(j2)) ? 256 : 128;
            } else {
                j2 = j;
            }
            boolean z = true;
            if (startRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
                startRestartGroup.skipToGroupEnd();
                companion = obj;
                f3 = f2;
            } else {
                startRestartGroup.startDefaults();
                ComposerKt.sourceInformation(startRestartGroup, "79@2993L5");
                if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                    companion = i4 != 0 ? Modifier.Companion : obj;
                    f3 = i5 != 0 ? DividerDefaults.INSTANCE.m2037getThicknessD9Ej5fM() : f2;
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        j2 = DividerDefaults.INSTANCE.getColor(startRestartGroup, 6);
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    companion = obj;
                    f3 = f2;
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1534852205, i3, -1, "androidx.compose.material3.VerticalDivider (Divider.kt:81)");
                }
                Modifier m869width3ABfNKs = SizeKt.m869width3ABfNKs(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), f3);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1819179376, "CC(remember):Divider.kt#9igjgp");
                boolean z2 = (i3 & 112) == 32;
                if ((((i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256 || !startRestartGroup.changed(j2)) && (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
                    z = false;
                }
                boolean z3 = z2 | z;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: androidx.compose.material3.DividerKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return DividerKt.VerticalDivider_9IZ8Weo$lambda$4$lambda$3(f3, j2, (DrawScope) obj2);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                CanvasKt.Canvas(m869width3ABfNKs, (Function1) rememberedValue, startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier2 = companion;
                final float f4 = f3;
                final long j3 = j2;
                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DividerKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return DividerKt.VerticalDivider_9IZ8Weo$lambda$5(Modifier.this, f4, j3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
                return;
            }
            return;
        }
        f2 = f;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        boolean z4 = true;
        if (startRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit VerticalDivider_9IZ8Weo$lambda$4$lambda$3(float f, long j, DrawScope drawScope) {
        float f2 = drawScope.mo405toPx0680j_4(f);
        long m4519constructorimpl = Offset.m4519constructorimpl((Float.floatToRawIntBits(drawScope.mo405toPx0680j_4(f) / 2.0f) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L));
        float intBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo5346getSizeNHjbRc() & 4294967295L));
        DrawScope.m5332drawLineNGM6Ib0$default(drawScope, j, m4519constructorimpl, Offset.m4519constructorimpl((Float.floatToRawIntBits(drawScope.mo405toPx0680j_4(f) / 2.0f) << 32) | (Float.floatToRawIntBits(intBitsToFloat) & 4294967295L)), f2, 0, null, 0.0f, null, 0, 496, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011d  */
    @Deprecated(message = "Renamed to HorizontalDivider", replaceWith = @ReplaceWith(expression = "HorizontalDivider(modifier, thickness, color)", imports = {}))
    /* renamed from: Divider-9IZ8Weo  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2038Divider9IZ8Weo(Modifier modifier, float f, long j, Composer composer, final int i, final int i2) {
        int i3;
        long j2;
        Modifier.Companion companion;
        float f2;
        long j3;
        float f3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(1562471785);
        ComposerKt.sourceInformation(startRestartGroup, "C(Divider)N(modifier,thickness:c#ui.unit.Dp,color:c#ui.graphics.Color)106@3745L78:Divider.kt#uh7d8r");
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i2 & 4) == 0) {
                j2 = j;
                if (startRestartGroup.changed(j2)) {
                    i4 = 256;
                    i3 |= i4;
                }
            } else {
                j2 = j;
            }
            i4 = 128;
            i3 |= i4;
        } else {
            j2 = j;
        }
        if (startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            startRestartGroup.startDefaults();
            ComposerKt.sourceInformation(startRestartGroup, "98@3564L5");
            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                startRestartGroup.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                companion = modifier;
                f2 = f;
            } else {
                companion = i5 != 0 ? Modifier.Companion : modifier;
                f2 = i6 != 0 ? DividerDefaults.INSTANCE.m2037getThicknessD9Ej5fM() : f;
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    j3 = DividerDefaults.INSTANCE.getColor(startRestartGroup, 6);
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1562471785, i3, -1, "androidx.compose.material3.Divider (Divider.kt:99)");
                    }
                    if (Dp.m7560equalsimpl0(f2, Dp.Companion.m7573getHairlineD9Ej5fM())) {
                        startRestartGroup.startReplaceGroup(-1258183496);
                        startRestartGroup.endReplaceGroup();
                        f3 = f2;
                    } else {
                        startRestartGroup.startReplaceGroup(-1258250053);
                        ComposerKt.sourceInformation(startRestartGroup, "102@3672L7");
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        f3 = Dp.m7555constructorimpl(1.0f / ((Density) consume).getDensity());
                        startRestartGroup.endReplaceGroup();
                    }
                    BoxKt.Box(BackgroundKt.m264backgroundbw27NRU$default(SizeKt.m850height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), f3), j3, null, 2, null), startRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }
            j3 = j2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            if (Dp.m7560equalsimpl0(f2, Dp.Companion.m7573getHairlineD9Ej5fM())) {
            }
            BoxKt.Box(BackgroundKt.m264backgroundbw27NRU$default(SizeKt.m850height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), f3), j3, null, 2, null), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            companion = modifier;
            f2 = f;
            j3 = j2;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier2 = companion;
            final float f4 = f2;
            final long j4 = j3;
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DividerKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DividerKt.Divider_9IZ8Weo$lambda$6(Modifier.this, f4, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
