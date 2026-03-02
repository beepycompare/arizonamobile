package androidx.compose.material3;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
/* compiled from: MaterialTheme.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a>\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aH\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0001¢\u0006\u0002\u0010\u000e\u001aP\u0010\u000f\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0001¢\u0006\u0002\u0010\u000e\u001a\u0015\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0017\"\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u000e\u0010\u0018\u001a\u00020\u0019X\u0080T¢\u0006\u0002\n\u0000\"\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u0011X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"MaterialTheme", "", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "shapes", "Landroidx/compose/material3/Shapes;", "typography", "Landroidx/compose/material3/Typography;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/Typography;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "motionScheme", "Landroidx/compose/material3/MotionScheme;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/MotionScheme;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/Typography;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "MaterialExpressiveTheme", "LocalUsingExpressiveTheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalUsingExpressiveTheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "TextSelectionBackgroundOpacity", "", "_localMotionScheme", "get_localMotionScheme$annotations", "()V", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MaterialThemeKt {
    public static final float TextSelectionBackgroundOpacity = 0.4f;
    private static final ProvidableCompositionLocal<Boolean> LocalUsingExpressiveTheme = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Boolean.valueOf(MaterialThemeKt.LocalUsingExpressiveTheme$lambda$3());
        }
    });
    private static final ProvidableCompositionLocal<MotionScheme> _localMotionScheme = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MotionScheme standard$material3;
            standard$material3 = MotionScheme.Companion.standard$material3();
            return standard$material3;
        }
    });

    public static final boolean LocalUsingExpressiveTheme$lambda$3() {
        return false;
    }

    public static final Unit MaterialExpressiveTheme$lambda$2(ColorScheme colorScheme, MotionScheme motionScheme, Shapes shapes, Typography typography, Function2 function2, int i, int i2, Composer composer, int i3) {
        MaterialExpressiveTheme(colorScheme, motionScheme, shapes, typography, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit MaterialTheme$lambda$0(ColorScheme colorScheme, Shapes shapes, Typography typography, Function2 function2, int i, int i2, Composer composer, int i3) {
        MaterialTheme(colorScheme, shapes, typography, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit MaterialTheme$lambda$1(ColorScheme colorScheme, MotionScheme motionScheme, Shapes shapes, Typography typography, Function2 function2, int i, int i2, Composer composer, int i3) {
        MaterialTheme(colorScheme, motionScheme, shapes, typography, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static /* synthetic */ void get_localMotionScheme$annotations() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:141:0x0095, code lost:
        if ((r15 & 4) != 0) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MaterialTheme(ColorScheme colorScheme, Shapes shapes, Typography typography, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        final Typography typography2;
        final Shapes shapes2;
        final ColorScheme colorScheme2;
        Composer startRestartGroup = composer.startRestartGroup(-449719819);
        ComposerKt.sourceInformation(startRestartGroup, "C(MaterialTheme)N(colorScheme,shapes,typography,content)61@2821L12,59@2734L191:MaterialTheme.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (((i2 & 1) == 0 && startRestartGroup.changed(colorScheme)) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= ((i2 & 2) == 0 && startRestartGroup.changed(shapes)) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= ((i2 & 4) == 0 && startRestartGroup.changed(typography)) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if (startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            startRestartGroup.startDefaults();
            ComposerKt.sourceInformation(startRestartGroup, "54@2578L11,55@2626L6,56@2677L10");
            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    colorScheme = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 6);
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    shapes = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    typography = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
                    i3 &= -897;
                }
                ColorScheme colorScheme3 = colorScheme;
                Shapes shapes3 = shapes;
                Typography typography3 = typography;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-449719819, i3, -1, "androidx.compose.material3.MaterialTheme (MaterialTheme.kt:59)");
                }
                int i4 = i3 << 3;
                MaterialTheme(colorScheme3, MaterialTheme.INSTANCE.getMotionScheme(startRestartGroup, 6), shapes3, typography3, function2, startRestartGroup, (i3 & 14) | (i4 & 896) | (i4 & 7168) | (i4 & 57344), 0);
                function22 = function2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                colorScheme2 = colorScheme3;
                shapes2 = shapes3;
                typography2 = typography3;
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
            }
        } else {
            function22 = function2;
            startRestartGroup.skipToGroupEnd();
            typography2 = typography;
            shapes2 = shapes;
            colorScheme2 = colorScheme;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MaterialThemeKt.MaterialTheme$lambda$0(ColorScheme.this, shapes2, typography2, function22, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:181:0x00d4, code lost:
        if ((r29 & 8) != 0) goto L68;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MaterialTheme(ColorScheme colorScheme, MotionScheme motionScheme, Shapes shapes, Typography typography, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        ColorScheme colorScheme2;
        int i3;
        MotionScheme motionScheme2;
        Shapes shapes2;
        final Typography typography2;
        int i4;
        int i5;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(904511636);
        ComposerKt.sourceInformation(startRestartGroup, "C(MaterialTheme)N(colorScheme,motionScheme,shapes,typography,content)97@4480L40,105@4846L81,98@4525L402:MaterialTheme.kt#uh7d8r");
        if ((i & 6) == 0) {
            if ((i2 & 1) == 0) {
                colorScheme2 = colorScheme;
                if (startRestartGroup.changed(colorScheme2)) {
                    i7 = 4;
                    i3 = i7 | i;
                }
            } else {
                colorScheme2 = colorScheme;
            }
            i7 = 2;
            i3 = i7 | i;
        } else {
            colorScheme2 = colorScheme;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                motionScheme2 = motionScheme;
                if (startRestartGroup.changed(motionScheme2)) {
                    i6 = 32;
                    i3 |= i6;
                }
            } else {
                motionScheme2 = motionScheme;
            }
            i6 = 16;
            i3 |= i6;
        } else {
            motionScheme2 = motionScheme;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i2 & 4) == 0) {
                shapes2 = shapes;
                if (startRestartGroup.changed(shapes2)) {
                    i5 = 256;
                    i3 |= i5;
                }
            } else {
                shapes2 = shapes;
            }
            i5 = 128;
            i3 |= i5;
        } else {
            shapes2 = shapes;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                typography2 = typography;
                if (startRestartGroup.changed(typography2)) {
                    i4 = 2048;
                    i3 |= i4;
                }
            } else {
                typography2 = typography;
            }
            i4 = 1024;
            i3 |= i4;
        } else {
            typography2 = typography;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if (startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            startRestartGroup.startDefaults();
            ComposerKt.sourceInformation(startRestartGroup, "90@4205L11,91@4265L12,92@4314L6,93@4365L10");
            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    colorScheme2 = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 6);
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    motionScheme2 = MaterialTheme.INSTANCE.getMotionScheme(startRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    shapes2 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6);
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    typography2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
                    i3 &= -7169;
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(904511636, i3, -1, "androidx.compose.material3.MaterialTheme (MaterialTheme.kt:95)");
                }
                CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ColorSchemeKt.getLocalColorScheme().provides(colorScheme2), _localMotionScheme.provides(motionScheme2), IndicationKt.getLocalIndication().provides(RippleKt.m2402rippleH2RKhps$default(false, 0.0f, 0L, 7, null)), ShapesKt.getLocalShapes().provides(shapes2), TextSelectionColorsKt.getLocalTextSelectionColors().provides(rememberTextSelectionColors(colorScheme2, startRestartGroup, i3 & 14)), TypographyKt.getLocalTypography().provides(typography2)}, ComposableLambdaKt.rememberComposableLambda(-1750539308, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MaterialThemeKt$MaterialTheme$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i8) {
                        ComposerKt.sourceInformation(composer2, "C106@4856L65:MaterialTheme.kt#uh7d8r");
                        if (!composer2.shouldExecute((i8 & 3) != 2, i8 & 1)) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1750539308, i8, -1, "androidx.compose.material3.MaterialTheme.<anonymous> (MaterialTheme.kt:106)");
                        }
                        TextKt.ProvideTextStyle(Typography.this.getBodyLarge(), function2, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        final Shapes shapes3 = shapes2;
        final Typography typography3 = typography2;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final ColorScheme colorScheme3 = colorScheme2;
            final MotionScheme motionScheme3 = motionScheme2;
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MaterialThemeKt.MaterialTheme$lambda$1(ColorScheme.this, motionScheme3, shapes3, typography3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:211:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MaterialExpressiveTheme(ColorScheme colorScheme, MotionScheme motionScheme, Shapes shapes, Typography typography, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        Object obj2;
        int i4;
        Object obj3;
        int i5;
        Object obj4;
        Function2<? super Composer, ? super Integer, Unit> function22;
        final ColorScheme colorScheme2;
        final MotionScheme motionScheme2;
        final Shapes shapes2;
        final Typography typography2;
        ScopeUpdateScope endRestartGroup;
        final ColorScheme colorScheme3;
        ColorScheme colorScheme4;
        MotionScheme motionScheme3;
        Typography typography3;
        Shapes shapes3;
        Composer startRestartGroup = composer.startRestartGroup(1317329884);
        ComposerKt.sourceInformation(startRestartGroup, "C(MaterialExpressiveTheme)N(colorScheme,motionScheme,shapes,typography,content)191@8447L7:MaterialTheme.kt#uh7d8r");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            obj = colorScheme;
        } else if ((i & 6) == 0) {
            obj = colorScheme;
            i3 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            obj = colorScheme;
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj2 = motionScheme;
            i3 |= startRestartGroup.changed(obj2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj3 = shapes;
                i3 |= startRestartGroup.changed(obj3) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    obj4 = typography;
                    i3 |= startRestartGroup.changed(obj4) ? 2048 : 1024;
                    if ((i2 & 16) == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        function22 = function2;
                        i3 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
                        if (!startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
                            startRestartGroup.skipToGroupEnd();
                            colorScheme2 = obj;
                            motionScheme2 = obj2;
                            shapes2 = obj3;
                            typography2 = obj4;
                        } else {
                            if (i6 != 0) {
                                obj = null;
                            }
                            final MotionScheme motionScheme4 = i7 != 0 ? null : obj2;
                            final Shapes shapes4 = i4 != 0 ? null : obj3;
                            final Typography typography4 = i5 != 0 ? null : obj4;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1317329884, i3, -1, "androidx.compose.material3.MaterialExpressiveTheme (MaterialTheme.kt:190)");
                            }
                            ProvidableCompositionLocal<Boolean> providableCompositionLocal = LocalUsingExpressiveTheme;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume = startRestartGroup.consume(providableCompositionLocal);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            if (((Boolean) consume).booleanValue()) {
                                startRestartGroup.startReplaceGroup(1458674654);
                                ComposerKt.sourceInformation(startRestartGroup, "192@8466L312");
                                if (obj == null) {
                                    startRestartGroup.startReplaceGroup(-1061322393);
                                    ComposerKt.sourceInformation(startRestartGroup, "193@8536L11");
                                    ColorScheme colorScheme5 = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 6);
                                    startRestartGroup.endReplaceGroup();
                                    colorScheme4 = colorScheme5;
                                } else {
                                    startRestartGroup.startReplaceGroup(-1061323292);
                                    startRestartGroup.endReplaceGroup();
                                    colorScheme4 = obj;
                                }
                                if (motionScheme4 == null) {
                                    startRestartGroup.startReplaceGroup(-1061320152);
                                    ComposerKt.sourceInformation(startRestartGroup, "194@8606L12");
                                    MotionScheme motionScheme5 = MaterialTheme.INSTANCE.getMotionScheme(startRestartGroup, 6);
                                    startRestartGroup.endReplaceGroup();
                                    motionScheme3 = motionScheme5;
                                } else {
                                    startRestartGroup.startReplaceGroup(-1061321082);
                                    startRestartGroup.endReplaceGroup();
                                    motionScheme3 = motionScheme4;
                                }
                                if (typography4 == null) {
                                    startRestartGroup.startReplaceGroup(-1061318010);
                                    ComposerKt.sourceInformation(startRestartGroup, "195@8673L10");
                                    Typography typography5 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
                                    startRestartGroup.endReplaceGroup();
                                    typography3 = typography5;
                                } else {
                                    startRestartGroup.startReplaceGroup(-1061318878);
                                    startRestartGroup.endReplaceGroup();
                                    typography3 = typography4;
                                }
                                if (shapes4 == null) {
                                    startRestartGroup.startReplaceGroup(-1061316190);
                                    ComposerKt.sourceInformation(startRestartGroup, "196@8730L6");
                                    Shapes shapes5 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6);
                                    startRestartGroup.endReplaceGroup();
                                    shapes3 = shapes5;
                                } else {
                                    startRestartGroup.startReplaceGroup(-1061316934);
                                    startRestartGroup.endReplaceGroup();
                                    shapes3 = shapes4;
                                }
                                MaterialTheme(colorScheme4, motionScheme3, shapes3, typography3, function22, startRestartGroup, i3 & 57344, 0);
                                startRestartGroup.endReplaceGroup();
                                colorScheme3 = obj;
                            } else {
                                startRestartGroup.startReplaceGroup(1459011221);
                                ComposerKt.sourceInformation(startRestartGroup, "200@8866L415,200@8800L481");
                                colorScheme3 = obj;
                                CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal.provides(true), ComposableLambdaKt.rememberComposableLambda(1535649272, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MaterialThemeKt$MaterialExpressiveTheme$1
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i8) {
                                        ComposerKt.sourceInformation(composer2, "C201@8880L391:MaterialTheme.kt#uh7d8r");
                                        if (!composer2.shouldExecute((i8 & 3) != 2, i8 & 1)) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1535649272, i8, -1, "androidx.compose.material3.MaterialExpressiveTheme.<anonymous> (MaterialTheme.kt:201)");
                                        }
                                        ColorScheme colorScheme6 = ColorScheme.this;
                                        if (colorScheme6 == null) {
                                            colorScheme6 = ColorSchemeKt.expressiveLightColorScheme();
                                        }
                                        MotionScheme motionScheme6 = motionScheme4;
                                        if (motionScheme6 == null) {
                                            motionScheme6 = MotionScheme.Companion.expressive$material3();
                                        }
                                        Shapes shapes6 = shapes4;
                                        if (shapes6 == null) {
                                            shapes6 = new Shapes(null, null, null, null, null, 31, null);
                                        }
                                        Typography typography6 = typography4;
                                        if (typography6 == null) {
                                            typography6 = new Typography(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
                                        }
                                        MaterialThemeKt.MaterialTheme(colorScheme6, motionScheme6, shapes6, typography6, function2, composer2, 0, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                                startRestartGroup.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            colorScheme2 = colorScheme3;
                            motionScheme2 = motionScheme4;
                            shapes2 = shapes4;
                            typography2 = typography4;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj5, Object obj6) {
                                    return MaterialThemeKt.MaterialExpressiveTheme$lambda$2(ColorScheme.this, motionScheme2, shapes2, typography2, function2, i, i2, (Composer) obj5, ((Integer) obj6).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    function22 = function2;
                    if (!startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj4 = typography;
                if ((i2 & 16) == 0) {
                }
                function22 = function2;
                if (!startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj3 = shapes;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            obj4 = typography;
            if ((i2 & 16) == 0) {
            }
            function22 = function2;
            if (!startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj2 = motionScheme;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        obj3 = shapes;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        obj4 = typography;
        if ((i2 & 16) == 0) {
        }
        function22 = function2;
        if (!startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalUsingExpressiveTheme() {
        return LocalUsingExpressiveTheme;
    }

    public static final TextSelectionColors rememberTextSelectionColors(ColorScheme colorScheme, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1866455512, "C(rememberTextSelectionColors)N(colorScheme)219@9547L198:MaterialTheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1866455512, i, -1, "androidx.compose.material3.rememberTextSelectionColors (MaterialTheme.kt:217)");
        }
        long m1877getPrimary0d7_KjU = colorScheme.m1877getPrimary0d7_KjU();
        ComposerKt.sourceInformationMarkerStart(composer, -1632576770, "CC(remember):MaterialTheme.kt#9igjgp");
        boolean changed = composer.changed(m1877getPrimary0d7_KjU);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            TextSelectionColors textSelectionColors = new TextSelectionColors(m1877getPrimary0d7_KjU, Color.m4771copywmQWz5c$default(m1877getPrimary0d7_KjU, 0.4f, 0.0f, 0.0f, 0.0f, 14, null), null);
            composer.updateRememberedValue(textSelectionColors);
            rememberedValue = textSelectionColors;
        }
        TextSelectionColors textSelectionColors2 = (TextSelectionColors) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textSelectionColors2;
    }
}
