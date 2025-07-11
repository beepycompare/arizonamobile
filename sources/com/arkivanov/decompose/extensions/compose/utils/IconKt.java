package com.arkivanov.decompose.extensions.compose.utils;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Icon.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\b\u0010\t\u001a\u0014\u0010\n\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0013\u0010\u000b\u001a\u00020\f*\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"IconCompat", "", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "modifier", "Landroidx/compose/ui/Modifier;", "tint", "Landroidx/compose/ui/graphics/Color;", "IconCompat-FNF3uiM", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "defaultSizeFor", "isInfinite", "", "Landroidx/compose/ui/geometry/Size;", "isInfinite-uvyYCjk", "(J)Z", "extensions-compose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IconKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconCompat_FNF3uiM$lambda$0(Painter painter, Modifier modifier, long j, int i, int i2, Composer composer, int i3) {
        m8010IconCompatFNF3uiM(painter, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* renamed from: IconCompat-FNF3uiM  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m8010IconCompatFNF3uiM(final Painter painter, Modifier modifier, long j, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        int i4;
        long j2;
        final Modifier modifier2;
        final long j3;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(painter, "painter");
        Composer startRestartGroup = composer.startRestartGroup(-1547148365);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(painter) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                j2 = j;
                i3 |= startRestartGroup.changed(j2) ? 256 : 128;
                if ((i3 & 147) == 146 || !startRestartGroup.getSkipping()) {
                    Modifier.Companion companion = i5 != 0 ? Modifier.Companion : obj;
                    long m4114getUnspecified0d7_KjU = i4 != 0 ? Color.Companion.m4114getUnspecified0d7_KjU() : j2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1547148365, i3, -1, "com.arkivanov.decompose.extensions.compose.utils.IconCompat (Icon.kt:21)");
                    }
                    BoxKt.Box(PainterModifierKt.paint$default(defaultSizeFor(GraphicsLayerModifierKt.toolingGraphicsLayer(companion), painter), painter, false, null, ContentScale.Companion.getFit(), 0.0f, Color.m4079equalsimpl0(m4114getUnspecified0d7_KjU, Color.Companion.m4114getUnspecified0d7_KjU()) ? null : ColorFilter.Companion.m4119tintxETnrds$default(ColorFilter.Companion, m4114getUnspecified0d7_KjU, 0, 2, null), 22, null), startRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = companion;
                    j3 = m4114getUnspecified0d7_KjU;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier2 = obj;
                    j3 = j2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: com.arkivanov.decompose.extensions.compose.utils.IconKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit IconCompat_FNF3uiM$lambda$0;
                            IconCompat_FNF3uiM$lambda$0 = IconKt.IconCompat_FNF3uiM$lambda$0(Painter.this, modifier2, j3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                            return IconCompat_FNF3uiM$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            j2 = j;
            if ((i3 & 147) == 146) {
            }
            if (i5 != 0) {
            }
            if (i4 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            BoxKt.Box(PainterModifierKt.paint$default(defaultSizeFor(GraphicsLayerModifierKt.toolingGraphicsLayer(companion), painter), painter, false, null, ContentScale.Companion.getFit(), 0.0f, Color.m4079equalsimpl0(m4114getUnspecified0d7_KjU, Color.Companion.m4114getUnspecified0d7_KjU()) ? null : ColorFilter.Companion.m4119tintxETnrds$default(ColorFilter.Companion, m4114getUnspecified0d7_KjU, 0, 2, null), 22, null), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = companion;
            j3 = m4114getUnspecified0d7_KjU;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        j2 = j;
        if ((i3 & 147) == 146) {
        }
        if (i5 != 0) {
        }
        if (i4 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        BoxKt.Box(PainterModifierKt.paint$default(defaultSizeFor(GraphicsLayerModifierKt.toolingGraphicsLayer(companion), painter), painter, false, null, ContentScale.Companion.getFit(), 0.0f, Color.m4079equalsimpl0(m4114getUnspecified0d7_KjU, Color.Companion.m4114getUnspecified0d7_KjU()) ? null : ColorFilter.Companion.m4119tintxETnrds$default(ColorFilter.Companion, m4114getUnspecified0d7_KjU, 0, 2, null), 22, null), startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = companion;
        j3 = m4114getUnspecified0d7_KjU;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final Modifier defaultSizeFor(Modifier modifier, Painter painter) {
        return (Size.m3902equalsimpl0(painter.mo4761getIntrinsicSizeNHjbRc(), Size.Companion.m3914getUnspecifiedNHjbRc()) || m8011isInfiniteuvyYCjk(painter.mo4761getIntrinsicSizeNHjbRc())) ? modifier.then(SizeKt.m785size3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(24))) : modifier;
    }

    /* renamed from: isInfinite-uvyYCjk  reason: not valid java name */
    private static final boolean m8011isInfiniteuvyYCjk(long j) {
        return Float.isInfinite(Size.m3906getWidthimpl(j)) && Float.isInfinite(Size.m3903getHeightimpl(j));
    }
}
