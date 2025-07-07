package androidx.compose.material3;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.SnackbarTokens;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
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
import kotlin.ranges.RangesKt;
/* compiled from: Snackbar.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001ae\u0010\n\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001ag\u0010\u0018\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0017\u001aj\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010'\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u0099\u0001\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020 2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"ContainerMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "HeightToFirstLine", "HorizontalSpacing", "HorizontalSpacingButtonSide", "LongButtonVerticalOffset", "SeparateButtonExtraY", "SnackbarVerticalPadding", "TextEndExtraSpacing", "NewLineButtonSnackbar", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "dismissAction", "actionTextStyle", "Landroidx/compose/ui/text/TextStyle;", "actionContentColor", "Landroidx/compose/ui/graphics/Color;", "dismissActionContentColor", "NewLineButtonSnackbar-kKq0p4A", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JJLandroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "actionTextColor", "dismissActionColor", "OneRowSnackbar-kKq0p4A", "Snackbar", "snackbarData", "Landroidx/compose/material3/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "contentColor", "actionColor", "Snackbar-sDKtq54", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJJJLandroidx/compose/runtime/Composer;II)V", FirebaseAnalytics.Param.CONTENT, "Snackbar-eQBnUkQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnackbarKt {
    private static final float HorizontalSpacingButtonSide;
    private static final float TextEndExtraSpacing;
    private static final float ContainerMaxWidth = Dp.m6684constructorimpl(600);
    private static final float HeightToFirstLine = Dp.m6684constructorimpl(30);
    private static final float HorizontalSpacing = Dp.m6684constructorimpl(16);
    private static final float SeparateButtonExtraY = Dp.m6684constructorimpl(2);
    private static final float SnackbarVerticalPadding = Dp.m6684constructorimpl(6);
    private static final float LongButtonVerticalOffset = Dp.m6684constructorimpl(12);

    /* JADX WARN: Removed duplicated region for block: B:100:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:179:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010f  */
    /* renamed from: Snackbar-eQBnUkQ  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2332SnackbareQBnUkQ(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z, Shape shape, long j, long j2, long j3, long j4, final Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        int i4;
        Object obj2;
        int i5;
        boolean z2;
        Object obj3;
        long j5;
        int i6;
        final Modifier.Companion companion;
        Object obj4;
        boolean z3;
        Shape shape2;
        long j6;
        long j7;
        long j8;
        long j9;
        Composer composer2;
        final boolean z4;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final Shape shape3;
        final long j10;
        final long j11;
        final long j12;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final long j13;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-1235788955);
        ComposerKt.sourceInformation(startRestartGroup, "C(Snackbar)P(8!1,6,2,9,3:c#ui.graphics.Color,5:c#ui.graphics.Color,1:c#ui.graphics.Color,7:c#ui.graphics.Color)107@5066L5,108@5118L5,109@5168L12,110@5231L18,111@5307L25,120@5574L1123,114@5378L1319:Snackbar.kt#uh7d8r");
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = function2;
            i3 |= startRestartGroup.changedInstance(obj) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj2 = function22;
                i3 |= startRestartGroup.changedInstance(obj2) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    z2 = z;
                    i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            obj3 = shape;
                            if (startRestartGroup.changed(obj3)) {
                                i8 = 16384;
                                i3 |= i8;
                            }
                        } else {
                            obj3 = shape;
                        }
                        i8 = 8192;
                        i3 |= i8;
                    } else {
                        obj3 = shape;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            j5 = j;
                            if (startRestartGroup.changed(j5)) {
                                i7 = 131072;
                                i3 |= i7;
                            }
                        } else {
                            j5 = j;
                        }
                        i7 = 65536;
                        i3 |= i7;
                    } else {
                        j5 = j;
                    }
                    if ((i & 1572864) != 0) {
                        i6 = i9;
                        i3 |= ((i2 & 64) == 0 && startRestartGroup.changed(j2)) ? 1048576 : 524288;
                    } else {
                        i6 = i9;
                    }
                    if ((i & 12582912) == 0) {
                        i3 |= ((i2 & 128) == 0 && startRestartGroup.changed(j3)) ? 8388608 : 4194304;
                    }
                    if ((100663296 & i) == 0) {
                        i3 |= ((i2 & 256) == 0 && startRestartGroup.changed(j4)) ? 67108864 : 33554432;
                    }
                    if ((i2 & 512) == 0) {
                        i3 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i3 |= startRestartGroup.changedInstance(function23) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i6 != 0 ? Modifier.Companion : modifier;
                                if (i10 != 0) {
                                    obj = null;
                                }
                                obj4 = i4 == 0 ? obj2 : null;
                                z3 = i5 != 0 ? false : z2;
                                if ((i2 & 16) != 0) {
                                    shape2 = SnackbarDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                    i3 &= -57345;
                                } else {
                                    shape2 = obj3;
                                }
                                if ((i2 & 32) != 0) {
                                    j6 = SnackbarDefaults.INSTANCE.getColor(startRestartGroup, 6);
                                    i3 &= -458753;
                                } else {
                                    j6 = j5;
                                }
                                if ((i2 & 64) != 0) {
                                    j7 = SnackbarDefaults.INSTANCE.getContentColor(startRestartGroup, 6);
                                    i3 &= -3670017;
                                } else {
                                    j7 = j2;
                                }
                                if ((i2 & 128) != 0) {
                                    j8 = SnackbarDefaults.INSTANCE.getActionContentColor(startRestartGroup, 6);
                                    i3 = (-29360129) & i3;
                                } else {
                                    j8 = j3;
                                }
                                if ((i2 & 256) != 0) {
                                    j9 = SnackbarDefaults.INSTANCE.getDismissActionContentColor(startRestartGroup, 6);
                                    i3 &= -234881025;
                                } else {
                                    j9 = j4;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                if ((i2 & 128) != 0) {
                                    i3 &= -29360129;
                                }
                                if ((i2 & 256) != 0) {
                                    i3 &= -234881025;
                                }
                                companion = modifier;
                                j8 = j3;
                                j9 = j4;
                                obj4 = obj2;
                                z3 = z2;
                                shape2 = obj3;
                                j6 = j5;
                                j7 = j2;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:113)");
                            }
                            final boolean z5 = z3;
                            final Function2<? super Composer, ? super Integer, Unit> function26 = obj;
                            final long j14 = j8;
                            final Function2<? super Composer, ? super Integer, Unit> function27 = obj4;
                            final long j15 = j9;
                            int i11 = i3 >> 9;
                            SurfaceKt.m2347SurfaceT9BRK9s(companion, shape2, j6, j7, 0.0f, SnackbarTokens.INSTANCE.m3306getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.rememberComposableLambda(-1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
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
                                    ComposerKt.sourceInformation(composer3, "C121@5634L5,122@5705L5,123@5779L912,123@5719L972:Snackbar.kt#uh7d8r");
                                    if ((i12 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1829663446, i12, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:121)");
                                        }
                                        TextStyle value = TypographyKt.getValue(SnackbarTokens.INSTANCE.getSupportingTextFont(), composer3, 6);
                                        final TextStyle value2 = TypographyKt.getValue(SnackbarTokens.INSTANCE.getActionLabelTextFont(), composer3, 6);
                                        ProvidedValue<TextStyle> provides = TextKt.getLocalTextStyle().provides(value);
                                        final boolean z6 = z5;
                                        final Function2<Composer, Integer, Unit> function28 = function26;
                                        final Function2<Composer, Integer, Unit> function29 = function23;
                                        final Function2<Composer, Integer, Unit> function210 = function27;
                                        final long j16 = j14;
                                        final long j17 = j15;
                                        CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                invoke(composer4, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer4, int i13) {
                                                ComposerKt.sourceInformation(composer4, "C:Snackbar.kt#uh7d8r");
                                                if ((i13 & 3) != 2 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(835891690, i13, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:124)");
                                                    }
                                                    if (z6 && function28 != null) {
                                                        composer4.startReplaceGroup(-810715387);
                                                        ComposerKt.sourceInformation(composer4, "126@5873L383");
                                                        SnackbarKt.m2330NewLineButtonSnackbarkKq0p4A(function29, function28, function210, value2, j16, j17, composer4, 0);
                                                        composer4.endReplaceGroup();
                                                    } else {
                                                        composer4.startReplaceGroup(-810701708);
                                                        ComposerKt.sourceInformation(composer4, "135@6301L366");
                                                        SnackbarKt.m2331OneRowSnackbarkKq0p4A(function29, function28, function210, value2, j16, j17, composer4, 0);
                                                        composer4.endReplaceGroup();
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }, composer3, 54), composer3, ProvidedValue.$stable | 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }, startRestartGroup, 54), startRestartGroup, (i3 & 14) | 12779520 | (i11 & 112) | (i11 & 896) | (i11 & 7168), 80);
                            composer2 = startRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z4 = z3;
                            function24 = obj;
                            shape3 = shape2;
                            j10 = j6;
                            j11 = j7;
                            j12 = j8;
                            function25 = obj4;
                            j13 = j9;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            companion = modifier;
                            composer2 = startRestartGroup;
                            function24 = obj;
                            function25 = obj2;
                            z4 = z2;
                            shape3 = obj3;
                            j10 = j5;
                            j11 = j2;
                            j12 = j3;
                            j13 = j4;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$2
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
                                    SnackbarKt.m2332SnackbareQBnUkQ(Modifier.this, function24, function25, z4, shape3, j10, j11, j12, j13, function23, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i3 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i4 == 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if ((i2 & 128) != 0) {
                    }
                    if ((i2 & 256) != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final boolean z52 = z3;
                    final Function2<? super Composer, ? super Integer, Unit> function262 = obj;
                    final long j142 = j8;
                    final Function2<? super Composer, ? super Integer, Unit> function272 = obj4;
                    final long j152 = j9;
                    int i112 = i3 >> 9;
                    SurfaceKt.m2347SurfaceT9BRK9s(companion, shape2, j6, j7, 0.0f, SnackbarTokens.INSTANCE.m3306getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.rememberComposableLambda(-1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
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
                            ComposerKt.sourceInformation(composer3, "C121@5634L5,122@5705L5,123@5779L912,123@5719L972:Snackbar.kt#uh7d8r");
                            if ((i12 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1829663446, i12, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:121)");
                                }
                                TextStyle value = TypographyKt.getValue(SnackbarTokens.INSTANCE.getSupportingTextFont(), composer3, 6);
                                final TextStyle value2 = TypographyKt.getValue(SnackbarTokens.INSTANCE.getActionLabelTextFont(), composer3, 6);
                                ProvidedValue<TextStyle> provides = TextKt.getLocalTextStyle().provides(value);
                                final boolean z6 = z52;
                                final Function2<? super Composer, ? super Integer, Unit> function28 = function262;
                                final Function2<? super Composer, ? super Integer, Unit> function29 = function23;
                                final Function2<? super Composer, ? super Integer, Unit> function210 = function272;
                                final long j16 = j142;
                                final long j17 = j152;
                                CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i13) {
                                        ComposerKt.sourceInformation(composer4, "C:Snackbar.kt#uh7d8r");
                                        if ((i13 & 3) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(835891690, i13, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:124)");
                                            }
                                            if (z6 && function28 != null) {
                                                composer4.startReplaceGroup(-810715387);
                                                ComposerKt.sourceInformation(composer4, "126@5873L383");
                                                SnackbarKt.m2330NewLineButtonSnackbarkKq0p4A(function29, function28, function210, value2, j16, j17, composer4, 0);
                                                composer4.endReplaceGroup();
                                            } else {
                                                composer4.startReplaceGroup(-810701708);
                                                ComposerKt.sourceInformation(composer4, "135@6301L366");
                                                SnackbarKt.m2331OneRowSnackbarkKq0p4A(function29, function28, function210, value2, j16, j17, composer4, 0);
                                                composer4.endReplaceGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }, composer3, 54), composer3, ProvidedValue.$stable | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }, startRestartGroup, 54), startRestartGroup, (i3 & 14) | 12779520 | (i112 & 112) | (i112 & 896) | (i112 & 7168), 80);
                    composer2 = startRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z4 = z3;
                    function24 = obj;
                    shape3 = shape2;
                    j10 = j6;
                    j11 = j7;
                    j12 = j8;
                    function25 = obj4;
                    j13 = j9;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z2 = z;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                if ((i & 1572864) != 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if ((100663296 & i) == 0) {
                }
                if ((i2 & 512) == 0) {
                }
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i6 != 0) {
                }
                if (i10 != 0) {
                }
                if (i4 == 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if ((i2 & 128) != 0) {
                }
                if ((i2 & 256) != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final boolean z522 = z3;
                final Function2<? super Composer, ? super Integer, Unit> function2622 = obj;
                final long j1422 = j8;
                final Function2<? super Composer, ? super Integer, Unit> function2722 = obj4;
                final long j1522 = j9;
                int i1122 = i3 >> 9;
                SurfaceKt.m2347SurfaceT9BRK9s(companion, shape2, j6, j7, 0.0f, SnackbarTokens.INSTANCE.m3306getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.rememberComposableLambda(-1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
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
                        ComposerKt.sourceInformation(composer3, "C121@5634L5,122@5705L5,123@5779L912,123@5719L972:Snackbar.kt#uh7d8r");
                        if ((i12 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1829663446, i12, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:121)");
                            }
                            TextStyle value = TypographyKt.getValue(SnackbarTokens.INSTANCE.getSupportingTextFont(), composer3, 6);
                            final TextStyle value2 = TypographyKt.getValue(SnackbarTokens.INSTANCE.getActionLabelTextFont(), composer3, 6);
                            ProvidedValue<TextStyle> provides = TextKt.getLocalTextStyle().provides(value);
                            final boolean z6 = z522;
                            final Function2<? super Composer, ? super Integer, Unit> function28 = function2622;
                            final Function2<? super Composer, ? super Integer, Unit> function29 = function23;
                            final Function2<? super Composer, ? super Integer, Unit> function210 = function2722;
                            final long j16 = j1422;
                            final long j17 = j1522;
                            CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i13) {
                                    ComposerKt.sourceInformation(composer4, "C:Snackbar.kt#uh7d8r");
                                    if ((i13 & 3) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(835891690, i13, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:124)");
                                        }
                                        if (z6 && function28 != null) {
                                            composer4.startReplaceGroup(-810715387);
                                            ComposerKt.sourceInformation(composer4, "126@5873L383");
                                            SnackbarKt.m2330NewLineButtonSnackbarkKq0p4A(function29, function28, function210, value2, j16, j17, composer4, 0);
                                            composer4.endReplaceGroup();
                                        } else {
                                            composer4.startReplaceGroup(-810701708);
                                            ComposerKt.sourceInformation(composer4, "135@6301L366");
                                            SnackbarKt.m2331OneRowSnackbarkKq0p4A(function29, function28, function210, value2, j16, j17, composer4, 0);
                                            composer4.endReplaceGroup();
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }, composer3, 54), composer3, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }, startRestartGroup, 54), startRestartGroup, (i3 & 14) | 12779520 | (i1122 & 112) | (i1122 & 896) | (i1122 & 7168), 80);
                composer2 = startRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                }
                z4 = z3;
                function24 = obj;
                shape3 = shape2;
                j10 = j6;
                j11 = j7;
                j12 = j8;
                function25 = obj4;
                j13 = j9;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj2 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            z2 = z;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            if ((i & 1572864) != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((100663296 & i) == 0) {
            }
            if ((i2 & 512) == 0) {
            }
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i6 != 0) {
            }
            if (i10 != 0) {
            }
            if (i4 == 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if ((i2 & 256) != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final boolean z5222 = z3;
            final Function2<? super Composer, ? super Integer, Unit> function26222 = obj;
            final long j14222 = j8;
            final Function2<? super Composer, ? super Integer, Unit> function27222 = obj4;
            final long j15222 = j9;
            int i11222 = i3 >> 9;
            SurfaceKt.m2347SurfaceT9BRK9s(companion, shape2, j6, j7, 0.0f, SnackbarTokens.INSTANCE.m3306getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.rememberComposableLambda(-1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
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
                    ComposerKt.sourceInformation(composer3, "C121@5634L5,122@5705L5,123@5779L912,123@5719L972:Snackbar.kt#uh7d8r");
                    if ((i12 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1829663446, i12, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:121)");
                        }
                        TextStyle value = TypographyKt.getValue(SnackbarTokens.INSTANCE.getSupportingTextFont(), composer3, 6);
                        final TextStyle value2 = TypographyKt.getValue(SnackbarTokens.INSTANCE.getActionLabelTextFont(), composer3, 6);
                        ProvidedValue<TextStyle> provides = TextKt.getLocalTextStyle().provides(value);
                        final boolean z6 = z5222;
                        final Function2<? super Composer, ? super Integer, Unit> function28 = function26222;
                        final Function2<? super Composer, ? super Integer, Unit> function29 = function23;
                        final Function2<? super Composer, ? super Integer, Unit> function210 = function27222;
                        final long j16 = j14222;
                        final long j17 = j15222;
                        CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i13) {
                                ComposerKt.sourceInformation(composer4, "C:Snackbar.kt#uh7d8r");
                                if ((i13 & 3) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(835891690, i13, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:124)");
                                    }
                                    if (z6 && function28 != null) {
                                        composer4.startReplaceGroup(-810715387);
                                        ComposerKt.sourceInformation(composer4, "126@5873L383");
                                        SnackbarKt.m2330NewLineButtonSnackbarkKq0p4A(function29, function28, function210, value2, j16, j17, composer4, 0);
                                        composer4.endReplaceGroup();
                                    } else {
                                        composer4.startReplaceGroup(-810701708);
                                        ComposerKt.sourceInformation(composer4, "135@6301L366");
                                        SnackbarKt.m2331OneRowSnackbarkKq0p4A(function29, function28, function210, value2, j16, j17, composer4, 0);
                                        composer4.endReplaceGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }, composer3, 54), composer3, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, startRestartGroup, 54), startRestartGroup, (i3 & 14) | 12779520 | (i11222 & 112) | (i11222 & 896) | (i11222 & 7168), 80);
            composer2 = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
            }
            z4 = z3;
            function24 = obj;
            shape3 = shape2;
            j10 = j6;
            j11 = j7;
            j12 = j8;
            function25 = obj4;
            j13 = j9;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = function2;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        obj2 = function22;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        z2 = z;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        if ((i & 1572864) != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((100663296 & i) == 0) {
        }
        if ((i2 & 512) == 0) {
        }
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i6 != 0) {
        }
        if (i10 != 0) {
        }
        if (i4 == 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if ((i2 & 256) != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final boolean z52222 = z3;
        final Function2<? super Composer, ? super Integer, Unit> function262222 = obj;
        final long j142222 = j8;
        final Function2<? super Composer, ? super Integer, Unit> function272222 = obj4;
        final long j152222 = j9;
        int i112222 = i3 >> 9;
        SurfaceKt.m2347SurfaceT9BRK9s(companion, shape2, j6, j7, 0.0f, SnackbarTokens.INSTANCE.m3306getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.rememberComposableLambda(-1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
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
                ComposerKt.sourceInformation(composer3, "C121@5634L5,122@5705L5,123@5779L912,123@5719L972:Snackbar.kt#uh7d8r");
                if ((i12 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1829663446, i12, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:121)");
                    }
                    TextStyle value = TypographyKt.getValue(SnackbarTokens.INSTANCE.getSupportingTextFont(), composer3, 6);
                    final TextStyle value2 = TypographyKt.getValue(SnackbarTokens.INSTANCE.getActionLabelTextFont(), composer3, 6);
                    ProvidedValue<TextStyle> provides = TextKt.getLocalTextStyle().provides(value);
                    final boolean z6 = z52222;
                    final Function2<? super Composer, ? super Integer, Unit> function28 = function262222;
                    final Function2<? super Composer, ? super Integer, Unit> function29 = function23;
                    final Function2<? super Composer, ? super Integer, Unit> function210 = function272222;
                    final long j16 = j142222;
                    final long j17 = j152222;
                    CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                            invoke(composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i13) {
                            ComposerKt.sourceInformation(composer4, "C:Snackbar.kt#uh7d8r");
                            if ((i13 & 3) != 2 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(835891690, i13, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:124)");
                                }
                                if (z6 && function28 != null) {
                                    composer4.startReplaceGroup(-810715387);
                                    ComposerKt.sourceInformation(composer4, "126@5873L383");
                                    SnackbarKt.m2330NewLineButtonSnackbarkKq0p4A(function29, function28, function210, value2, j16, j17, composer4, 0);
                                    composer4.endReplaceGroup();
                                } else {
                                    composer4.startReplaceGroup(-810701708);
                                    ComposerKt.sourceInformation(composer4, "135@6301L366");
                                    SnackbarKt.m2331OneRowSnackbarkKq0p4A(function29, function28, function210, value2, j16, j17, composer4, 0);
                                    composer4.endReplaceGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer4.skipToGroupEnd();
                        }
                    }, composer3, 54), composer3, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }, startRestartGroup, 54), startRestartGroup, (i3 & 14) | 12779520 | (i112222 & 112) | (i112222 & 896) | (i112222 & 7168), 80);
        composer2 = startRestartGroup;
        if (ComposerKt.isTraceInProgress()) {
        }
        z4 = z3;
        function24 = obj;
        shape3 = shape2;
        j10 = j6;
        j11 = j7;
        j12 = j8;
        function25 = obj4;
        j13 = j9;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x010e  */
    /* renamed from: Snackbar-sDKtq54  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2333SnackbarsDKtq54(final SnackbarData snackbarData, Modifier modifier, boolean z, Shape shape, long j, long j2, long j3, long j4, long j5, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        int i4;
        boolean z2;
        Object obj2;
        long j6;
        long j7;
        int i5;
        int i6;
        final Modifier.Companion companion;
        Shape shape2;
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        long j13;
        final long j14;
        long j15;
        boolean z3;
        Shape shape3;
        long j16;
        Composer composer2;
        final long j17;
        final boolean z4;
        final Shape shape4;
        final long j18;
        final long j19;
        final long j20;
        final long j21;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(274621471);
        ComposerKt.sourceInformation(startRestartGroup, "C(Snackbar)P(8,6,2,7,3:c#ui.graphics.Color,4:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color)205@9602L5,206@9654L5,207@9704L12,208@9760L11,209@9822L18,210@9898L25,251@11371L38,241@10959L456:Snackbar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(snackbarData) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        obj2 = shape;
                        if (startRestartGroup.changed(obj2)) {
                            i11 = 2048;
                            i3 |= i11;
                        }
                    } else {
                        obj2 = shape;
                    }
                    i11 = 1024;
                    i3 |= i11;
                } else {
                    obj2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        j6 = j;
                        if (startRestartGroup.changed(j6)) {
                            i10 = 16384;
                            i3 |= i10;
                        }
                    } else {
                        j6 = j;
                    }
                    i10 = 8192;
                    i3 |= i10;
                } else {
                    j6 = j;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        j7 = j2;
                        if (startRestartGroup.changed(j7)) {
                            i9 = 131072;
                            i3 |= i9;
                        }
                    } else {
                        j7 = j2;
                    }
                    i9 = 65536;
                    i3 |= i9;
                } else {
                    j7 = j2;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        i7 = i3;
                        i6 = i12;
                        if (startRestartGroup.changed(j3)) {
                            i8 = 1048576;
                            i5 = i7 | i8;
                        }
                    } else {
                        i7 = i3;
                        i6 = i12;
                    }
                    i8 = 524288;
                    i5 = i7 | i8;
                } else {
                    i5 = i3;
                    i6 = i12;
                }
                if ((i & 12582912) == 0) {
                    i5 |= ((i2 & 128) == 0 && startRestartGroup.changed(j4)) ? 8388608 : 4194304;
                }
                if ((100663296 & i) == 0) {
                    i5 |= ((i2 & 256) == 0 && startRestartGroup.changed(j5)) ? 67108864 : 33554432;
                }
                if ((38347923 & i5) == 38347922 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        companion = i6 != 0 ? Modifier.Companion : obj;
                        boolean z5 = i4 != 0 ? false : z2;
                        if ((i2 & 8) != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(startRestartGroup, 6);
                            i5 &= -7169;
                        } else {
                            shape2 = obj2;
                        }
                        if ((i2 & 16) != 0) {
                            j8 = SnackbarDefaults.INSTANCE.getColor(startRestartGroup, 6);
                            i5 &= -57345;
                        } else {
                            j8 = j6;
                        }
                        if ((i2 & 32) != 0) {
                            j9 = SnackbarDefaults.INSTANCE.getContentColor(startRestartGroup, 6);
                            i5 &= -458753;
                        } else {
                            j9 = j7;
                        }
                        if ((i2 & 64) != 0) {
                            j10 = SnackbarDefaults.INSTANCE.getActionColor(startRestartGroup, 6);
                            i5 &= -3670017;
                        } else {
                            j10 = j3;
                        }
                        if ((i2 & 128) != 0) {
                            j11 = SnackbarDefaults.INSTANCE.getActionContentColor(startRestartGroup, 6);
                            i5 = (-29360129) & i5;
                        } else {
                            j11 = j4;
                        }
                        if ((i2 & 256) != 0) {
                            i5 &= -234881025;
                            j14 = j10;
                            j15 = j11;
                            j12 = SnackbarDefaults.INSTANCE.getDismissActionContentColor(startRestartGroup, 6);
                            z3 = z5;
                            shape3 = shape2;
                            j16 = j8;
                            j13 = j9;
                        } else {
                            j12 = j5;
                            j13 = j9;
                            j14 = j10;
                            j15 = j11;
                            z3 = z5;
                            shape3 = shape2;
                            j16 = j8;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i5 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i5 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i5 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            i5 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            i5 &= -29360129;
                        }
                        if ((i2 & 256) != 0) {
                            i5 &= -234881025;
                        }
                        j14 = j3;
                        j15 = j4;
                        j12 = j5;
                        companion = obj;
                        z3 = z2;
                        shape3 = obj2;
                        j16 = j6;
                        j13 = j7;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(274621471, i5, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:211)");
                    }
                    final String actionLabel = snackbarData.getVisuals().getActionLabel();
                    startRestartGroup.startReplaceGroup(1561344786);
                    ComposerKt.sourceInformation(startRestartGroup, "215@10097L267");
                    ComposableLambda rememberComposableLambda = actionLabel != null ? ComposableLambdaKt.rememberComposableLambda(-1378313599, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            ComposerKt.sourceInformation(composer3, "C217@10171L44,218@10247L32,219@10311L21,216@10115L235:Snackbar.kt#uh7d8r");
                            if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1378313599, i13, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:216)");
                                }
                                ButtonColors m1623textButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1623textButtonColorsro_MJ88(0L, j14, 0L, 0L, composer3, 24576, 13);
                                ComposerKt.sourceInformationMarkerStart(composer3, 642119911, "CC(remember):Snackbar.kt#9igjgp");
                                boolean changed = composer3.changed(snackbarData);
                                final SnackbarData snackbarData2 = snackbarData;
                                Object rememberedValue = composer3.rememberedValue();
                                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                                    rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                            invoke2();
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                        public final void invoke2() {
                                            SnackbarData.this.performAction();
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                final String str = actionLabel;
                                ButtonKt.TextButton((Function0) rememberedValue, null, false, null, m1623textButtonColorsro_MJ88, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(521110564, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                                        invoke(rowScope, composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(RowScope rowScope, Composer composer4, int i14) {
                                        ComposerKt.sourceInformation(composer4, "C219@10313L17:Snackbar.kt#uh7d8r");
                                        if ((i14 & 17) == 16 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(521110564, i14, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:219)");
                                        }
                                        TextKt.m2497Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 0, 0, 131070);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer3, 54), composer3, 805306368, 494);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }, startRestartGroup, 54) : null;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(1561358724);
                    ComposerKt.sourceInformation(startRestartGroup, "227@10548L362");
                    ComposableLambda rememberComposableLambda2 = snackbarData.getVisuals().getWithDismissAction() ? ComposableLambdaKt.rememberComposableLambda(-1812633777, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            ComposerKt.sourceInformation(composer3, "C229@10608L26,228@10566L330:Snackbar.kt#uh7d8r");
                            if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1812633777, i13, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:228)");
                                }
                                ComposerKt.sourceInformationMarkerStart(composer3, 642131457, "CC(remember):Snackbar.kt#9igjgp");
                                boolean changed = composer3.changed(SnackbarData.this);
                                final SnackbarData snackbarData2 = SnackbarData.this;
                                Object rememberedValue = composer3.rememberedValue();
                                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                                    rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                            invoke2();
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                        public final void invoke2() {
                                            SnackbarData.this.dismiss();
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                IconButtonKt.IconButton((Function0) rememberedValue, null, false, null, null, ComposableSingletons$SnackbarKt.INSTANCE.m1785getLambda1$material3_release(), composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }, startRestartGroup, 54) : null;
                    startRestartGroup.endReplaceGroup();
                    int i13 = i5 << 3;
                    composer2 = startRestartGroup;
                    m2332SnackbareQBnUkQ(PaddingKt.m738padding3ABfNKs(companion, Dp.m6684constructorimpl(12)), rememberComposableLambda, rememberComposableLambda2, z3, shape3, j16, j13, j15, j12, ComposableLambdaKt.rememberComposableLambda(-1266389126, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i14) {
                            ComposerKt.sourceInformation(composer3, "C251@11373L34:Snackbar.kt#uh7d8r");
                            if ((i14 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1266389126, i14, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:251)");
                            }
                            TextKt.m2497Text4IGK_g(SnackbarData.this.getVisuals().getMessage(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131070);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), composer2, (i13 & 3670016) | (i13 & 7168) | 805306368 | (57344 & i13) | (458752 & i13) | (29360128 & i5) | (234881024 & i5), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j17 = j14;
                    z4 = z3;
                    shape4 = shape3;
                    j18 = j16;
                    j19 = j13;
                    j20 = j15;
                    j21 = j12;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    composer2 = startRestartGroup;
                    companion = obj;
                    z4 = z2;
                    shape4 = obj2;
                    j18 = j6;
                    j19 = j7;
                    j17 = j3;
                    j20 = j4;
                    j21 = j5;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$4
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i14) {
                            SnackbarKt.m2333SnackbarsDKtq54(SnackbarData.this, companion, z4, shape4, j18, j19, j17, j20, j21, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            if ((1572864 & i) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((100663296 & i) == 0) {
            }
            if ((38347923 & i5) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i6 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if ((i2 & 256) != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final String actionLabel2 = snackbarData.getVisuals().getActionLabel();
            startRestartGroup.startReplaceGroup(1561344786);
            ComposerKt.sourceInformation(startRestartGroup, "215@10097L267");
            if (actionLabel2 != null) {
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1561358724);
            ComposerKt.sourceInformation(startRestartGroup, "227@10548L362");
            if (snackbarData.getVisuals().getWithDismissAction()) {
            }
            startRestartGroup.endReplaceGroup();
            int i132 = i5 << 3;
            composer2 = startRestartGroup;
            m2332SnackbareQBnUkQ(PaddingKt.m738padding3ABfNKs(companion, Dp.m6684constructorimpl(12)), rememberComposableLambda, rememberComposableLambda2, z3, shape3, j16, j13, j15, j12, ComposableLambdaKt.rememberComposableLambda(-1266389126, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i14) {
                    ComposerKt.sourceInformation(composer3, "C251@11373L34:Snackbar.kt#uh7d8r");
                    if ((i14 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1266389126, i14, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:251)");
                    }
                    TextKt.m2497Text4IGK_g(SnackbarData.this.getVisuals().getMessage(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), composer2, (i132 & 3670016) | (i132 & 7168) | 805306368 | (57344 & i132) | (458752 & i132) | (29360128 & i5) | (234881024 & i5), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            j17 = j14;
            z4 = z3;
            shape4 = shape3;
            j18 = j16;
            j19 = j13;
            j20 = j15;
            j21 = j12;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        if ((1572864 & i) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((100663296 & i) == 0) {
        }
        if ((38347923 & i5) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i6 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if ((i2 & 256) != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final String actionLabel22 = snackbarData.getVisuals().getActionLabel();
        startRestartGroup.startReplaceGroup(1561344786);
        ComposerKt.sourceInformation(startRestartGroup, "215@10097L267");
        if (actionLabel22 != null) {
        }
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(1561358724);
        ComposerKt.sourceInformation(startRestartGroup, "227@10548L362");
        if (snackbarData.getVisuals().getWithDismissAction()) {
        }
        startRestartGroup.endReplaceGroup();
        int i1322 = i5 << 3;
        composer2 = startRestartGroup;
        m2332SnackbareQBnUkQ(PaddingKt.m738padding3ABfNKs(companion, Dp.m6684constructorimpl(12)), rememberComposableLambda, rememberComposableLambda2, z3, shape3, j16, j13, j15, j12, ComposableLambdaKt.rememberComposableLambda(-1266389126, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i14) {
                ComposerKt.sourceInformation(composer3, "C251@11373L34:Snackbar.kt#uh7d8r");
                if ((i14 & 3) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1266389126, i14, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:251)");
                }
                TextKt.m2497Text4IGK_g(SnackbarData.this.getVisuals().getMessage(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131070);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), composer2, (i1322 & 3670016) | (i1322 & 7168) | 805306368 | (57344 & i1322) | (458752 & i1322) | (29360128 & i5) | (234881024 & i5), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        j17 = j14;
        z4 = z3;
        shape4 = shape3;
        j18 = j16;
        j19 = j13;
        j20 = j15;
        j21 = j12;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: NewLineButtonSnackbar-kKq0p4A  reason: not valid java name */
    public static final void m2330NewLineButtonSnackbarkKq0p4A(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final TextStyle textStyle, final long j, final long j2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1332496681);
        ComposerKt.sourceInformation(startRestartGroup, "C(NewLineButtonSnackbar)P(5!1,3,2,1:c#ui.graphics.Color,4:c#ui.graphics.Color)264@11690L1175:Snackbar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(textStyle) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(j) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1332496681, i2, -1, "androidx.compose.material3.NewLineButtonSnackbar (Snackbar.kt:263)");
            }
            Modifier m742paddingqDBjuR0$default = PaddingKt.m742paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m792widthInVpY3zN4$default(Modifier.Companion, 0.0f, ContainerMaxWidth, 1, null), 0.0f, 1, null), HorizontalSpacing, 0.0f, 0.0f, SeparateButtonExtraY, 6, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m742paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            int i3 = i2;
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
            Updater.m3527setimpl(m3520constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -376152340, "C272@11979L191,279@12180L679:Snackbar.kt#uh7d8r");
            Modifier m593paddingFromBaselineVpY3zN4 = AlignmentLineKt.m593paddingFromBaselineVpY3zN4(Modifier.Companion, HeightToFirstLine, LongButtonVerticalOffset);
            float f = HorizontalSpacingButtonSide;
            Modifier m742paddingqDBjuR0$default2 = PaddingKt.m742paddingqDBjuR0$default(m593paddingFromBaselineVpY3zN4, 0.0f, 0.0f, f, 0.0f, 11, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m742paddingqDBjuR0$default2);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1482962025, "C276@12154L6:Snackbar.kt#uh7d8r");
            function2.invoke(startRestartGroup, Integer.valueOf(i3 & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier align = columnScopeInstance.align(Modifier.Companion, Alignment.Companion.getEnd());
            if (function23 != null) {
                f = Dp.m6684constructorimpl(0);
            }
            Modifier m742paddingqDBjuR0$default3 = PaddingKt.m742paddingqDBjuR0$default(align, 0.0f, 0.0f, f, 0.0f, 11, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m742paddingqDBjuR0$default3);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1482754232, "C283@12348L501:Snackbar.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor4);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3520constructorimpl4 = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl4, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl4.getInserting() || !Intrinsics.areEqual(m3520constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m3520constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m3520constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3527setimpl(m3520constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1996615437, "C284@12370L208:Snackbar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(j)), TextKt.getLocalTextStyle().provides(textStyle)}, function22, startRestartGroup, ProvidedValue.$stable | (i3 & 112));
            startRestartGroup.startReplaceGroup(618603253);
            ComposerKt.sourceInformation(startRestartGroup, "290@12644L173");
            if (function23 != null) {
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(j2)), function23, startRestartGroup, ProvidedValue.$stable | ((i3 >> 3) & 112));
            }
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$NewLineButtonSnackbar$2
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
                    SnackbarKt.m2330NewLineButtonSnackbarkKq0p4A(function2, function22, function23, textStyle, j, j2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OneRowSnackbar-kKq0p4A  reason: not valid java name */
    public static final void m2331OneRowSnackbarkKq0p4A(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final TextStyle textStyle, final long j, final long j2, Composer composer, final int i) {
        int i2;
        float m6684constructorimpl;
        Composer startRestartGroup = composer.startRestartGroup(-903235475);
        ComposerKt.sourceInformation(startRestartGroup, "C(OneRowSnackbar)P(5!1,3,2,1:c#ui.graphics.Color,4:c#ui.graphics.Color)338@14229L3580,312@13223L4586:Snackbar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(textStyle) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(j) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-903235475, i2, -1, "androidx.compose.material3.OneRowSnackbar (Snackbar.kt:308)");
            }
            Modifier.Companion companion = Modifier.Companion;
            float f = HorizontalSpacing;
            if (function23 == null) {
                m6684constructorimpl = HorizontalSpacingButtonSide;
            } else {
                m6684constructorimpl = Dp.m6684constructorimpl(0);
            }
            Modifier m742paddingqDBjuR0$default = PaddingKt.m742paddingqDBjuR0$default(companion, f, 0.0f, m6684constructorimpl, 0.0f, 10, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1386942712, "CC(remember):Snackbar.kt#9igjgp");
            MeasurePolicy rememberedValue = startRestartGroup.rememberedValue();
            int i3 = i2;
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo42measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j3) {
                        float f2;
                        Measurable measurable;
                        Measurable measurable2;
                        int i4;
                        float f3;
                        int i5;
                        int max;
                        int height;
                        int i6;
                        float f4;
                        MeasureScope measureScope2 = measureScope;
                        int m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j3);
                        f2 = SnackbarKt.ContainerMaxWidth;
                        int min = Math.min(m6637getMaxWidthimpl, measureScope2.mo383roundToPx0680j_4(f2));
                        String str = r1;
                        int size = list.size();
                        int i7 = 0;
                        while (true) {
                            if (i7 >= size) {
                                measurable = null;
                                break;
                            }
                            measurable = list.get(i7);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), str)) {
                                break;
                            }
                            i7++;
                        }
                        Measurable measurable3 = measurable;
                        Placeable mo5438measureBRTryo0 = measurable3 != null ? measurable3.mo5438measureBRTryo0(j3) : null;
                        String str2 = r2;
                        int size2 = list.size();
                        int i8 = 0;
                        while (true) {
                            if (i8 >= size2) {
                                measurable2 = null;
                                break;
                            }
                            measurable2 = list.get(i8);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), str2)) {
                                break;
                            }
                            i8++;
                        }
                        Measurable measurable4 = measurable2;
                        final Placeable mo5438measureBRTryo02 = measurable4 != null ? measurable4.mo5438measureBRTryo0(j3) : null;
                        int width = mo5438measureBRTryo0 != null ? mo5438measureBRTryo0.getWidth() : 0;
                        int height2 = mo5438measureBRTryo0 != null ? mo5438measureBRTryo0.getHeight() : 0;
                        int width2 = mo5438measureBRTryo02 != null ? mo5438measureBRTryo02.getWidth() : 0;
                        int height3 = mo5438measureBRTryo02 != null ? mo5438measureBRTryo02.getHeight() : 0;
                        if (width2 == 0) {
                            f4 = SnackbarKt.TextEndExtraSpacing;
                            i4 = measureScope2.mo383roundToPx0680j_4(f4);
                        } else {
                            i4 = 0;
                        }
                        int coerceAtLeast = RangesKt.coerceAtLeast(((min - width) - width2) - i4, Constraints.m6639getMinWidthimpl(j3));
                        String str3 = r3;
                        int size3 = list.size();
                        int i9 = 0;
                        while (i9 < size3) {
                            Measurable measurable5 = list.get(i9);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable5), str3)) {
                                int i10 = height3;
                                final Placeable mo5438measureBRTryo03 = measurable5.mo5438measureBRTryo0(Constraints.m6627copyZbe2FdA$default(j3, 0, coerceAtLeast, 0, 0, 9, null));
                                int i11 = mo5438measureBRTryo03.get(androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline());
                                int i12 = mo5438measureBRTryo03.get(androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline());
                                boolean z = true;
                                boolean z2 = (i11 == Integer.MIN_VALUE || i12 == Integer.MIN_VALUE) ? false : true;
                                if (i11 != i12 && z2) {
                                    z = false;
                                }
                                final int i13 = min - width2;
                                final int i14 = i13 - width;
                                if (!z) {
                                    f3 = SnackbarKt.HeightToFirstLine;
                                    i5 = measureScope2.mo383roundToPx0680j_4(f3) - i11;
                                    max = Math.max(measureScope2.mo383roundToPx0680j_4(SnackbarTokens.INSTANCE.m3309getTwoLinesContainerHeightD9Ej5fM()), mo5438measureBRTryo03.getHeight() + i5);
                                    if (mo5438measureBRTryo0 != null) {
                                        height = (max - mo5438measureBRTryo0.getHeight()) / 2;
                                    }
                                    height = 0;
                                } else {
                                    max = Math.max(measureScope2.mo383roundToPx0680j_4(SnackbarTokens.INSTANCE.m3308getSingleLineContainerHeightD9Ej5fM()), Math.max(height2, i10));
                                    i5 = (max - mo5438measureBRTryo03.getHeight()) / 2;
                                    if (mo5438measureBRTryo0 != null && (i6 = mo5438measureBRTryo0.get(androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline())) != Integer.MIN_VALUE) {
                                        height = (i11 + i5) - i6;
                                    }
                                    height = 0;
                                }
                                final int i15 = height;
                                final int i16 = i5;
                                int i17 = max;
                                final int height4 = mo5438measureBRTryo02 != null ? (i17 - mo5438measureBRTryo02.getHeight()) / 2 : 0;
                                final Placeable placeable = mo5438measureBRTryo0;
                                return MeasureScope.layout$default(measureScope2, min, i17, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2$1.2
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
                                        Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, i16, 0.0f, 4, null);
                                        Placeable placeable2 = mo5438measureBRTryo02;
                                        if (placeable2 != null) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i13, height4, 0.0f, 4, null);
                                        }
                                        Placeable placeable3 = placeable;
                                        if (placeable3 != null) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i14, i15, 0.0f, 4, null);
                                        }
                                    }
                                }, 4, null);
                            }
                            i9++;
                            measureScope2 = measureScope;
                            height3 = height3;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m742paddingqDBjuR0$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2016566027, "C314@13253L86:Snackbar.kt#uh7d8r");
            Modifier m740paddingVpY3zN4$default = PaddingKt.m740paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "text"), 0.0f, SnackbarVerticalPadding, 1, null);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1308937155, "C314@13331L6:Snackbar.kt#uh7d8r");
            function2.invoke(startRestartGroup, Integer.valueOf(i3 & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.startReplaceGroup(-904778058);
            ComposerKt.sourceInformation(startRestartGroup, "316@13390L295");
            if (function22 != null) {
                Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, "action");
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1309057900, "C317@13446L221:Snackbar.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(j)), TextKt.getLocalTextStyle().provides(textStyle)}, function22, startRestartGroup, ProvidedValue.$stable | (i3 & 112));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-904766579);
            ComposerKt.sourceInformation(startRestartGroup, "325@13757L247");
            if (function23 != null) {
                Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.Companion, "dismissAction");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId2);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor4);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3520constructorimpl4 = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl4, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl4.getInserting() || !Intrinsics.areEqual(m3520constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m3520constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m3520constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m3527setimpl(m3520constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1309427203, "C326@13820L166:Snackbar.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(j2)), function23, startRestartGroup, ProvidedValue.$stable | ((i3 >> 3) & 112));
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$3
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
                    SnackbarKt.m2331OneRowSnackbarkKq0p4A(function2, function22, function23, textStyle, j, j2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    static {
        float f = 8;
        HorizontalSpacingButtonSide = Dp.m6684constructorimpl(f);
        TextEndExtraSpacing = Dp.m6684constructorimpl(f);
    }
}
