package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Scaffold.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a±\u0001\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0013\b\u0002\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0013\b\u0002\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0013\b\u0002\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u0015¢\u0006\u0002\b\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0087\u0001\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000e2\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u0015¢\u0006\u0002\b\t2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\tH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "Scaffold", "", "modifier", "Landroidx/compose/ui/Modifier;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material3/FabPosition;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-TvnljyQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;IJJLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ScaffoldLayout", "fabPosition", "snackbar", "fab", "ScaffoldLayout-FMILGgc", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScaffoldKt {
    private static final float FabSpacing = Dp.m6684constructorimpl(16);

    /* JADX WARN: Removed duplicated region for block: B:100:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:199:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0117  */
    /* renamed from: Scaffold-TvnljyQ  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2212ScaffoldTvnljyQ(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, int i, long j, long j2, WindowInsets windowInsets, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i2, final int i3) {
        int i4;
        Object obj;
        int i5;
        Object obj2;
        int i6;
        Object obj3;
        int i7;
        Object obj4;
        int i8;
        int i9;
        Modifier.Companion companion;
        Function2<Composer, Integer, Unit> m1777getLambda1$material3_release;
        Function2<Composer, Integer, Unit> m1778getLambda2$material3_release;
        Function2<Composer, Integer, Unit> m1779getLambda3$material3_release;
        Function2<Composer, Integer, Unit> m1780getLambda4$material3_release;
        int m1909getEndERTFSPs;
        int i10;
        int i11;
        long j3;
        long j4;
        final WindowInsets windowInsets2;
        int i12;
        long j5;
        int i13;
        boolean z;
        Object rememberedValue;
        boolean changed;
        Object rememberedValue2;
        Composer composer2;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final int i14;
        final long j6;
        final long j7;
        ScopeUpdateScope endRestartGroup;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(-1219521777);
        ComposerKt.sourceInformation(startRestartGroup, "C(Scaffold)P(7,9!1,8,5,6:c#material3.FabPosition,1:c#ui.graphics.Color,3:c#ui.graphics.Color,4)90@4654L11,91@4704L31,92@4794L19,95@4889L74,98@5047L224,104@5347L314,96@4968L693:Scaffold.kt#uh7d8r");
        int i16 = i3 & 1;
        if (i16 != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i17 = i3 & 2;
        if (i17 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            obj = function2;
            i4 |= startRestartGroup.changedInstance(obj) ? 32 : 16;
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj2 = function22;
                i4 |= startRestartGroup.changedInstance(obj2) ? 256 : 128;
                i6 = i3 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    obj3 = function23;
                    i4 |= startRestartGroup.changedInstance(obj3) ? 2048 : 1024;
                    i7 = i3 & 16;
                    if (i7 == 0) {
                        i4 |= 24576;
                    } else if ((i2 & 24576) == 0) {
                        obj4 = function24;
                        i4 |= startRestartGroup.changedInstance(obj4) ? 16384 : 8192;
                        i8 = i3 & 32;
                        if (i8 != 0) {
                            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i4 |= startRestartGroup.changed(i) ? 131072 : 65536;
                        }
                        if ((i2 & 1572864) == 0) {
                            i9 = i16;
                            i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(j)) ? 1048576 : 524288;
                        } else {
                            i9 = i16;
                        }
                        if ((i2 & 12582912) == 0) {
                            i4 |= ((i3 & 128) == 0 && startRestartGroup.changed(j2)) ? 8388608 : 4194304;
                        }
                        if ((i2 & 100663296) == 0) {
                            if ((i3 & 256) == 0 && startRestartGroup.changed(windowInsets)) {
                                i15 = 67108864;
                                i4 |= i15;
                            }
                            i15 = 33554432;
                            i4 |= i15;
                        }
                        if ((i3 & 512) != 0) {
                            i4 |= 805306368;
                        } else if ((i2 & 805306368) == 0) {
                            i4 |= startRestartGroup.changedInstance(function3) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                            if ((i4 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    companion = i9 == 0 ? Modifier.Companion : modifier;
                                    m1777getLambda1$material3_release = i17 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m1777getLambda1$material3_release() : obj;
                                    m1778getLambda2$material3_release = i5 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m1778getLambda2$material3_release() : obj2;
                                    m1779getLambda3$material3_release = i6 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m1779getLambda3$material3_release() : obj3;
                                    m1780getLambda4$material3_release = i7 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m1780getLambda4$material3_release() : obj4;
                                    m1909getEndERTFSPs = i8 == 0 ? FabPosition.Companion.m1909getEndERTFSPs() : i;
                                    if ((i3 & 64) == 0) {
                                        i4 &= -3670017;
                                        i10 = -234881025;
                                        i11 = -29360129;
                                        j3 = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 6).m1695getBackground0d7_KjU();
                                    } else {
                                        i10 = -234881025;
                                        i11 = -29360129;
                                        j3 = j;
                                    }
                                    if ((i3 & 128) == 0) {
                                        j4 = ColorSchemeKt.m1733contentColorForek8zF_U(j3, startRestartGroup, (i4 >> 18) & 14);
                                        i4 &= i11;
                                    } else {
                                        j4 = j2;
                                    }
                                    if ((i3 & 256) == 0) {
                                        windowInsets2 = ScaffoldDefaults.INSTANCE.getContentWindowInsets(startRestartGroup, 6);
                                        i4 &= i10;
                                    } else {
                                        windowInsets2 = windowInsets;
                                    }
                                    i12 = 100663296;
                                    j5 = j4;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i3 & 64) != 0) {
                                        i4 &= -3670017;
                                    }
                                    if ((i3 & 128) != 0) {
                                        i4 &= -29360129;
                                    }
                                    if ((i3 & 256) != 0) {
                                        i4 &= -234881025;
                                    }
                                    companion = modifier;
                                    m1909getEndERTFSPs = i;
                                    j3 = j;
                                    windowInsets2 = windowInsets;
                                    m1777getLambda1$material3_release = obj;
                                    m1778getLambda2$material3_release = obj2;
                                    m1779getLambda3$material3_release = obj3;
                                    m1780getLambda4$material3_release = obj4;
                                    i12 = 100663296;
                                    j5 = j2;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    i13 = i12;
                                } else {
                                    i13 = i12;
                                    ComposerKt.traceEventStart(-1219521777, i4, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:94)");
                                }
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1794939901, "CC(remember):Scaffold.kt#9igjgp");
                                int i18 = (234881024 & i4) ^ i13;
                                z = (i18 <= 67108864 && startRestartGroup.changed(windowInsets2)) || (i4 & i13) == 67108864;
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!z || rememberedValue == Composer.Companion.getEmpty()) {
                                    rememberedValue = new MutableWindowInsets(windowInsets2);
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                final MutableWindowInsets mutableWindowInsets = (MutableWindowInsets) rememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                long j8 = j3;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1794934695, "CC(remember):Scaffold.kt#9igjgp");
                                changed = startRestartGroup.changed(mutableWindowInsets) | ((i18 <= 67108864 && startRestartGroup.changed(windowInsets2)) || (i4 & i13) == 67108864);
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (!changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                                    rememberedValue2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets3) {
                                            invoke2(windowInsets3);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                        public final void invoke2(WindowInsets windowInsets3) {
                                            MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets2, windowInsets3));
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                final Function2<? super Composer, ? super Integer, Unit> function29 = m1777getLambda1$material3_release;
                                final Function2<? super Composer, ? super Integer, Unit> function210 = m1778getLambda2$material3_release;
                                final Function2<? super Composer, ? super Integer, Unit> function211 = m1779getLambda3$material3_release;
                                final Function2<? super Composer, ? super Integer, Unit> function212 = m1780getLambda4$material3_release;
                                final int i19 = m1909getEndERTFSPs;
                                int i20 = i4 >> 12;
                                composer2 = startRestartGroup;
                                SurfaceKt.m2347SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) rememberedValue2), null, j8, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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

                                    public final void invoke(Composer composer3, int i21) {
                                        ComposerKt.sourceInformation(composer3, "C105@5357L298:Scaffold.kt#uh7d8r");
                                        if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1979205334, i21, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:105)");
                                            }
                                            ScaffoldKt.m2213ScaffoldLayoutFMILGgc(i19, function29, function3, function211, function212, mutableWindowInsets, function210, composer3, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, startRestartGroup, 54), composer2, (i20 & 896) | 12582912 | (i20 & 7168), 114);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = companion;
                                function25 = m1777getLambda1$material3_release;
                                function26 = m1778getLambda2$material3_release;
                                function27 = m1779getLambda3$material3_release;
                                function28 = m1780getLambda4$material3_release;
                                i14 = m1909getEndERTFSPs;
                                j6 = j8;
                                j7 = j5;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                windowInsets2 = windowInsets;
                                composer2 = startRestartGroup;
                                function25 = obj;
                                function26 = obj2;
                                function27 = obj3;
                                function28 = obj4;
                                modifier2 = modifier;
                                i14 = i;
                                j6 = j;
                                j7 = j2;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$3
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

                                    public final void invoke(Composer composer3, int i21) {
                                        ScaffoldKt.m2212ScaffoldTvnljyQ(Modifier.this, function25, function26, function27, function28, i14, j6, j7, windowInsets2, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i4 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                        }
                        if (i9 == 0) {
                        }
                        if (i17 == 0) {
                        }
                        if (i5 == 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (i8 == 0) {
                        }
                        if ((i3 & 64) == 0) {
                        }
                        if ((i3 & 128) == 0) {
                        }
                        if ((i3 & 256) == 0) {
                        }
                        i12 = 100663296;
                        j5 = j4;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1794939901, "CC(remember):Scaffold.kt#9igjgp");
                        int i182 = (234881024 & i4) ^ i13;
                        if (i182 <= 67108864) {
                        }
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!z) {
                        }
                        rememberedValue = new MutableWindowInsets(windowInsets2);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        final MutableWindowInsets mutableWindowInsets2 = (MutableWindowInsets) rememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        long j82 = j3;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1794934695, "CC(remember):Scaffold.kt#9igjgp");
                        changed = startRestartGroup.changed(mutableWindowInsets2) | ((i182 <= 67108864 && startRestartGroup.changed(windowInsets2)) || (i4 & i13) == 67108864);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets3) {
                                invoke2(windowInsets3);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(WindowInsets windowInsets3) {
                                MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets2, windowInsets3));
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        final Function2<? super Composer, ? super Integer, Unit> function292 = m1777getLambda1$material3_release;
                        final Function2<? super Composer, ? super Integer, Unit> function2102 = m1778getLambda2$material3_release;
                        final Function2<? super Composer, ? super Integer, Unit> function2112 = m1779getLambda3$material3_release;
                        final Function2<? super Composer, ? super Integer, Unit> function2122 = m1780getLambda4$material3_release;
                        final int i192 = m1909getEndERTFSPs;
                        int i202 = i4 >> 12;
                        composer2 = startRestartGroup;
                        SurfaceKt.m2347SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) rememberedValue2), null, j82, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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

                            public final void invoke(Composer composer3, int i21) {
                                ComposerKt.sourceInformation(composer3, "C105@5357L298:Scaffold.kt#uh7d8r");
                                if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1979205334, i21, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:105)");
                                    }
                                    ScaffoldKt.m2213ScaffoldLayoutFMILGgc(i192, function292, function3, function2112, function2122, mutableWindowInsets2, function2102, composer3, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }, startRestartGroup, 54), composer2, (i202 & 896) | 12582912 | (i202 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier2 = companion;
                        function25 = m1777getLambda1$material3_release;
                        function26 = m1778getLambda2$material3_release;
                        function27 = m1779getLambda3$material3_release;
                        function28 = m1780getLambda4$material3_release;
                        i14 = m1909getEndERTFSPs;
                        j6 = j82;
                        j7 = j5;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    obj4 = function24;
                    i8 = i3 & 32;
                    if (i8 != 0) {
                    }
                    if ((i2 & 1572864) == 0) {
                    }
                    if ((i2 & 12582912) == 0) {
                    }
                    if ((i2 & 100663296) == 0) {
                    }
                    if ((i3 & 512) != 0) {
                    }
                    if ((i4 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i9 == 0) {
                    }
                    if (i17 == 0) {
                    }
                    if (i5 == 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i7 == 0) {
                    }
                    if (i8 == 0) {
                    }
                    if ((i3 & 64) == 0) {
                    }
                    if ((i3 & 128) == 0) {
                    }
                    if ((i3 & 256) == 0) {
                    }
                    i12 = 100663296;
                    j5 = j4;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1794939901, "CC(remember):Scaffold.kt#9igjgp");
                    int i1822 = (234881024 & i4) ^ i13;
                    if (i1822 <= 67108864) {
                    }
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z) {
                    }
                    rememberedValue = new MutableWindowInsets(windowInsets2);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    final MutableWindowInsets mutableWindowInsets22 = (MutableWindowInsets) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    long j822 = j3;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1794934695, "CC(remember):Scaffold.kt#9igjgp");
                    changed = startRestartGroup.changed(mutableWindowInsets22) | ((i1822 <= 67108864 && startRestartGroup.changed(windowInsets2)) || (i4 & i13) == 67108864);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets3) {
                            invoke2(windowInsets3);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(WindowInsets windowInsets3) {
                            MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets2, windowInsets3));
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final Function2<? super Composer, ? super Integer, Unit> function2922 = m1777getLambda1$material3_release;
                    final Function2<? super Composer, ? super Integer, Unit> function21022 = m1778getLambda2$material3_release;
                    final Function2<? super Composer, ? super Integer, Unit> function21122 = m1779getLambda3$material3_release;
                    final Function2<? super Composer, ? super Integer, Unit> function21222 = m1780getLambda4$material3_release;
                    final int i1922 = m1909getEndERTFSPs;
                    int i2022 = i4 >> 12;
                    composer2 = startRestartGroup;
                    SurfaceKt.m2347SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) rememberedValue2), null, j822, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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

                        public final void invoke(Composer composer3, int i21) {
                            ComposerKt.sourceInformation(composer3, "C105@5357L298:Scaffold.kt#uh7d8r");
                            if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1979205334, i21, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:105)");
                                }
                                ScaffoldKt.m2213ScaffoldLayoutFMILGgc(i1922, function2922, function3, function21122, function21222, mutableWindowInsets22, function21022, composer3, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }, startRestartGroup, 54), composer2, (i2022 & 896) | 12582912 | (i2022 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier2 = companion;
                    function25 = m1777getLambda1$material3_release;
                    function26 = m1778getLambda2$material3_release;
                    function27 = m1779getLambda3$material3_release;
                    function28 = m1780getLambda4$material3_release;
                    i14 = m1909getEndERTFSPs;
                    j6 = j822;
                    j7 = j5;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj3 = function23;
                i7 = i3 & 16;
                if (i7 == 0) {
                }
                obj4 = function24;
                i8 = i3 & 32;
                if (i8 != 0) {
                }
                if ((i2 & 1572864) == 0) {
                }
                if ((i2 & 12582912) == 0) {
                }
                if ((i2 & 100663296) == 0) {
                }
                if ((i3 & 512) != 0) {
                }
                if ((i4 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i9 == 0) {
                }
                if (i17 == 0) {
                }
                if (i5 == 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if (i8 == 0) {
                }
                if ((i3 & 64) == 0) {
                }
                if ((i3 & 128) == 0) {
                }
                if ((i3 & 256) == 0) {
                }
                i12 = 100663296;
                j5 = j4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1794939901, "CC(remember):Scaffold.kt#9igjgp");
                int i18222 = (234881024 & i4) ^ i13;
                if (i18222 <= 67108864) {
                }
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z) {
                }
                rememberedValue = new MutableWindowInsets(windowInsets2);
                startRestartGroup.updateRememberedValue(rememberedValue);
                final MutableWindowInsets mutableWindowInsets222 = (MutableWindowInsets) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                long j8222 = j3;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1794934695, "CC(remember):Scaffold.kt#9igjgp");
                changed = startRestartGroup.changed(mutableWindowInsets222) | ((i18222 <= 67108864 && startRestartGroup.changed(windowInsets2)) || (i4 & i13) == 67108864);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets3) {
                        invoke2(windowInsets3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(WindowInsets windowInsets3) {
                        MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets2, windowInsets3));
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final Function2<? super Composer, ? super Integer, Unit> function29222 = m1777getLambda1$material3_release;
                final Function2<? super Composer, ? super Integer, Unit> function210222 = m1778getLambda2$material3_release;
                final Function2<? super Composer, ? super Integer, Unit> function211222 = m1779getLambda3$material3_release;
                final Function2<? super Composer, ? super Integer, Unit> function212222 = m1780getLambda4$material3_release;
                final int i19222 = m1909getEndERTFSPs;
                int i20222 = i4 >> 12;
                composer2 = startRestartGroup;
                SurfaceKt.m2347SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) rememberedValue2), null, j8222, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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

                    public final void invoke(Composer composer3, int i21) {
                        ComposerKt.sourceInformation(composer3, "C105@5357L298:Scaffold.kt#uh7d8r");
                        if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1979205334, i21, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:105)");
                            }
                            ScaffoldKt.m2213ScaffoldLayoutFMILGgc(i19222, function29222, function3, function211222, function212222, mutableWindowInsets222, function210222, composer3, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }, startRestartGroup, 54), composer2, (i20222 & 896) | 12582912 | (i20222 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = companion;
                function25 = m1777getLambda1$material3_release;
                function26 = m1778getLambda2$material3_release;
                function27 = m1779getLambda3$material3_release;
                function28 = m1780getLambda4$material3_release;
                i14 = m1909getEndERTFSPs;
                j6 = j8222;
                j7 = j5;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            obj2 = function22;
            i6 = i3 & 8;
            if (i6 != 0) {
            }
            obj3 = function23;
            i7 = i3 & 16;
            if (i7 == 0) {
            }
            obj4 = function24;
            i8 = i3 & 32;
            if (i8 != 0) {
            }
            if ((i2 & 1572864) == 0) {
            }
            if ((i2 & 12582912) == 0) {
            }
            if ((i2 & 100663296) == 0) {
            }
            if ((i3 & 512) != 0) {
            }
            if ((i4 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i9 == 0) {
            }
            if (i17 == 0) {
            }
            if (i5 == 0) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            if (i8 == 0) {
            }
            if ((i3 & 64) == 0) {
            }
            if ((i3 & 128) == 0) {
            }
            if ((i3 & 256) == 0) {
            }
            i12 = 100663296;
            j5 = j4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1794939901, "CC(remember):Scaffold.kt#9igjgp");
            int i182222 = (234881024 & i4) ^ i13;
            if (i182222 <= 67108864) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z) {
            }
            rememberedValue = new MutableWindowInsets(windowInsets2);
            startRestartGroup.updateRememberedValue(rememberedValue);
            final MutableWindowInsets mutableWindowInsets2222 = (MutableWindowInsets) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            long j82222 = j3;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1794934695, "CC(remember):Scaffold.kt#9igjgp");
            changed = startRestartGroup.changed(mutableWindowInsets2222) | ((i182222 <= 67108864 && startRestartGroup.changed(windowInsets2)) || (i4 & i13) == 67108864);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets3) {
                    invoke2(windowInsets3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(WindowInsets windowInsets3) {
                    MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets2, windowInsets3));
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Function2<? super Composer, ? super Integer, Unit> function292222 = m1777getLambda1$material3_release;
            final Function2<? super Composer, ? super Integer, Unit> function2102222 = m1778getLambda2$material3_release;
            final Function2<? super Composer, ? super Integer, Unit> function2112222 = m1779getLambda3$material3_release;
            final Function2<? super Composer, ? super Integer, Unit> function2122222 = m1780getLambda4$material3_release;
            final int i192222 = m1909getEndERTFSPs;
            int i202222 = i4 >> 12;
            composer2 = startRestartGroup;
            SurfaceKt.m2347SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) rememberedValue2), null, j82222, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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

                public final void invoke(Composer composer3, int i21) {
                    ComposerKt.sourceInformation(composer3, "C105@5357L298:Scaffold.kt#uh7d8r");
                    if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1979205334, i21, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:105)");
                        }
                        ScaffoldKt.m2213ScaffoldLayoutFMILGgc(i192222, function292222, function3, function2112222, function2122222, mutableWindowInsets2222, function2102222, composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, startRestartGroup, 54), composer2, (i202222 & 896) | 12582912 | (i202222 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = companion;
            function25 = m1777getLambda1$material3_release;
            function26 = m1778getLambda2$material3_release;
            function27 = m1779getLambda3$material3_release;
            function28 = m1780getLambda4$material3_release;
            i14 = m1909getEndERTFSPs;
            j6 = j82222;
            j7 = j5;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = function2;
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        obj2 = function22;
        i6 = i3 & 8;
        if (i6 != 0) {
        }
        obj3 = function23;
        i7 = i3 & 16;
        if (i7 == 0) {
        }
        obj4 = function24;
        i8 = i3 & 32;
        if (i8 != 0) {
        }
        if ((i2 & 1572864) == 0) {
        }
        if ((i2 & 12582912) == 0) {
        }
        if ((i2 & 100663296) == 0) {
        }
        if ((i3 & 512) != 0) {
        }
        if ((i4 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i9 == 0) {
        }
        if (i17 == 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if (i8 == 0) {
        }
        if ((i3 & 64) == 0) {
        }
        if ((i3 & 128) == 0) {
        }
        if ((i3 & 256) == 0) {
        }
        i12 = 100663296;
        j5 = j4;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1794939901, "CC(remember):Scaffold.kt#9igjgp");
        int i1822222 = (234881024 & i4) ^ i13;
        if (i1822222 <= 67108864) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z) {
        }
        rememberedValue = new MutableWindowInsets(windowInsets2);
        startRestartGroup.updateRememberedValue(rememberedValue);
        final MutableWindowInsets mutableWindowInsets22222 = (MutableWindowInsets) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        long j822222 = j3;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1794934695, "CC(remember):Scaffold.kt#9igjgp");
        changed = startRestartGroup.changed(mutableWindowInsets22222) | ((i1822222 <= 67108864 && startRestartGroup.changed(windowInsets2)) || (i4 & i13) == 67108864);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets3) {
                invoke2(windowInsets3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(WindowInsets windowInsets3) {
                MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets2, windowInsets3));
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final Function2<? super Composer, ? super Integer, Unit> function2922222 = m1777getLambda1$material3_release;
        final Function2<? super Composer, ? super Integer, Unit> function21022222 = m1778getLambda2$material3_release;
        final Function2<? super Composer, ? super Integer, Unit> function21122222 = m1779getLambda3$material3_release;
        final Function2<? super Composer, ? super Integer, Unit> function21222222 = m1780getLambda4$material3_release;
        final int i1922222 = m1909getEndERTFSPs;
        int i2022222 = i4 >> 12;
        composer2 = startRestartGroup;
        SurfaceKt.m2347SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) rememberedValue2), null, j822222, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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

            public final void invoke(Composer composer3, int i21) {
                ComposerKt.sourceInformation(composer3, "C105@5357L298:Scaffold.kt#uh7d8r");
                if ((i21 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1979205334, i21, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:105)");
                    }
                    ScaffoldKt.m2213ScaffoldLayoutFMILGgc(i1922222, function2922222, function3, function21122222, function21222222, mutableWindowInsets22222, function21022222, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }, startRestartGroup, 54), composer2, (i2022222 & 896) | 12582912 | (i2022222 & 7168), 114);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = companion;
        function25 = m1777getLambda1$material3_release;
        function26 = m1778getLambda2$material3_release;
        function27 = m1779getLambda3$material3_release;
        function28 = m1780getLambda4$material3_release;
        i14 = m1909getEndERTFSPs;
        j6 = j822222;
        j7 = j5;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ScaffoldLayout-FMILGgc  reason: not valid java name */
    public static final void m2213ScaffoldLayoutFMILGgc(final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i2) {
        int i3;
        Object obj;
        Object obj2;
        final WindowInsets windowInsets2;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-975511942);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScaffoldLayout)P(4:c#material3.FabPosition,6,1,5,3,2)139@6582L6951,139@6565L6968:Scaffold.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = function3;
            i3 |= startRestartGroup.changedInstance(obj) ? 256 : 128;
        } else {
            obj = function3;
        }
        if ((i2 & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            obj2 = function23;
            i3 |= startRestartGroup.changedInstance(obj2) ? 16384 : 8192;
        } else {
            obj2 = function23;
        }
        if ((196608 & i2) == 0) {
            windowInsets2 = windowInsets;
            i3 |= startRestartGroup.changed(windowInsets2) ? 131072 : 65536;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((i2 & 1572864) == 0) {
            i3 |= startRestartGroup.changedInstance(function24) ? 1048576 : 524288;
        }
        if ((i3 & 599187) != 599186 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-975511942, i3, -1, "androidx.compose.material3.ScaffoldLayout (Scaffold.kt:138)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1690368138, "CC(remember):Scaffold.kt#9igjgp");
            boolean z = ((i3 & 112) == 32) | ((i3 & 7168) == 2048) | ((458752 & i3) == 131072) | ((57344 & i3) == 16384) | ((i3 & 14) == 4) | ((3670016 & i3) == 1048576) | ((i3 & 896) == 256);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32 = obj;
                i4 = 0;
                final Function2<? super Composer, ? super Integer, Unit> function25 = obj2;
                rememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m2215invoke0kLqBqw(subcomposeMeasureScope, constraints.m6643unboximpl());
                    }

                    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                    public final MeasureResult m2215invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                        Object obj3;
                        Object obj4;
                        Object obj5;
                        ArrayList arrayList;
                        FabPlacement fabPlacement;
                        Object obj6;
                        Integer num;
                        int i5;
                        int intValue;
                        float f;
                        int i6;
                        int bottom;
                        float f2;
                        Object obj7;
                        Object obj8;
                        int i7;
                        float f3;
                        float f4;
                        int i8;
                        float f5;
                        float f6;
                        final int m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j);
                        final int m6636getMaxHeightimpl = Constraints.m6636getMaxHeightimpl(j);
                        long m6627copyZbe2FdA$default = Constraints.m6627copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
                        List<Measurable> subcompose = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.TopBar, function2);
                        ArrayList arrayList2 = new ArrayList(subcompose.size());
                        int size = subcompose.size();
                        for (int i9 = 0; i9 < size; i9++) {
                            arrayList2.add(subcompose.get(i9).mo5438measureBRTryo0(m6627copyZbe2FdA$default));
                        }
                        ArrayList arrayList3 = arrayList2;
                        if (arrayList3.isEmpty()) {
                            obj3 = null;
                        } else {
                            obj3 = arrayList3.get(0);
                            int height = ((Placeable) obj3).getHeight();
                            int lastIndex = CollectionsKt.getLastIndex(arrayList3);
                            if (1 <= lastIndex) {
                                int i10 = 1;
                                while (true) {
                                    Object obj9 = arrayList3.get(i10);
                                    int height2 = ((Placeable) obj9).getHeight();
                                    if (height < height2) {
                                        obj3 = obj9;
                                        height = height2;
                                    }
                                    if (i10 == lastIndex) {
                                        break;
                                    }
                                    i10++;
                                }
                            }
                        }
                        Placeable placeable = (Placeable) obj3;
                        int height3 = placeable != null ? placeable.getHeight() : 0;
                        List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.Snackbar, function22);
                        WindowInsets windowInsets3 = windowInsets2;
                        ArrayList arrayList4 = new ArrayList(subcompose2.size());
                        int size2 = subcompose2.size();
                        int i11 = 0;
                        while (i11 < size2) {
                            SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                            arrayList4.add(subcompose2.get(i11).mo5438measureBRTryo0(ConstraintsKt.m6656offsetNN6EwU(m6627copyZbe2FdA$default, (-windowInsets3.getLeft(subcomposeMeasureScope2, subcomposeMeasureScope.getLayoutDirection())) - windowInsets3.getRight(subcomposeMeasureScope2, subcomposeMeasureScope.getLayoutDirection()), -windowInsets3.getBottom(subcomposeMeasureScope2))));
                            i11++;
                            height3 = height3;
                            subcompose2 = subcompose2;
                            arrayList3 = arrayList3;
                        }
                        final ArrayList arrayList5 = arrayList3;
                        final int i12 = height3;
                        final ArrayList arrayList6 = arrayList4;
                        if (arrayList6.isEmpty()) {
                            obj4 = null;
                        } else {
                            obj4 = arrayList6.get(0);
                            int height4 = ((Placeable) obj4).getHeight();
                            int lastIndex2 = CollectionsKt.getLastIndex(arrayList6);
                            if (1 <= lastIndex2) {
                                Object obj10 = obj4;
                                int i13 = height4;
                                int i14 = 1;
                                while (true) {
                                    Object obj11 = arrayList6.get(i14);
                                    int height5 = ((Placeable) obj11).getHeight();
                                    if (i13 < height5) {
                                        obj10 = obj11;
                                        i13 = height5;
                                    }
                                    if (i14 == lastIndex2) {
                                        break;
                                    }
                                    i14++;
                                }
                                obj4 = obj10;
                            }
                        }
                        Placeable placeable2 = (Placeable) obj4;
                        int height6 = placeable2 != null ? placeable2.getHeight() : 0;
                        if (arrayList6.isEmpty()) {
                            obj5 = null;
                        } else {
                            obj5 = arrayList6.get(0);
                            int width = ((Placeable) obj5).getWidth();
                            int lastIndex3 = CollectionsKt.getLastIndex(arrayList6);
                            if (1 <= lastIndex3) {
                                Object obj12 = obj5;
                                int i15 = width;
                                int i16 = 1;
                                while (true) {
                                    Object obj13 = arrayList6.get(i16);
                                    int width2 = ((Placeable) obj13).getWidth();
                                    if (i15 < width2) {
                                        obj12 = obj13;
                                        i15 = width2;
                                    }
                                    if (i16 == lastIndex3) {
                                        break;
                                    }
                                    i16++;
                                }
                                obj5 = obj12;
                            }
                        }
                        Placeable placeable3 = (Placeable) obj5;
                        int width3 = placeable3 != null ? placeable3.getWidth() : 0;
                        List<Measurable> subcompose3 = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.Fab, function25);
                        WindowInsets windowInsets4 = windowInsets2;
                        ArrayList arrayList7 = new ArrayList(subcompose3.size());
                        int size3 = subcompose3.size();
                        int i17 = 0;
                        while (i17 < size3) {
                            int i18 = height6;
                            SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                            List<Measurable> list = subcompose3;
                            ArrayList arrayList8 = arrayList7;
                            Placeable mo5438measureBRTryo0 = subcompose3.get(i17).mo5438measureBRTryo0(ConstraintsKt.m6656offsetNN6EwU(m6627copyZbe2FdA$default, (-windowInsets4.getLeft(subcomposeMeasureScope3, subcomposeMeasureScope.getLayoutDirection())) - windowInsets4.getRight(subcomposeMeasureScope3, subcomposeMeasureScope.getLayoutDirection()), -windowInsets4.getBottom(subcomposeMeasureScope3)));
                            mo5438measureBRTryo0 = (mo5438measureBRTryo0.getHeight() == 0 || mo5438measureBRTryo0.getWidth() == 0) ? null : null;
                            if (mo5438measureBRTryo0 != null) {
                                arrayList8.add(mo5438measureBRTryo0);
                            }
                            i17++;
                            height6 = i18;
                            subcompose3 = list;
                            arrayList7 = arrayList8;
                        }
                        int i19 = height6;
                        ArrayList arrayList9 = arrayList7;
                        if (arrayList9.isEmpty()) {
                            arrayList = arrayList9;
                            fabPlacement = null;
                        } else {
                            if (arrayList9.isEmpty()) {
                                obj7 = null;
                            } else {
                                obj7 = arrayList9.get(0);
                                int width4 = ((Placeable) obj7).getWidth();
                                int lastIndex4 = CollectionsKt.getLastIndex(arrayList9);
                                if (1 <= lastIndex4) {
                                    Object obj14 = obj7;
                                    int i20 = width4;
                                    int i21 = 1;
                                    while (true) {
                                        Object obj15 = arrayList9.get(i21);
                                        int width5 = ((Placeable) obj15).getWidth();
                                        if (i20 < width5) {
                                            obj14 = obj15;
                                            i20 = width5;
                                        }
                                        if (i21 == lastIndex4) {
                                            break;
                                        }
                                        i21++;
                                    }
                                    obj7 = obj14;
                                }
                            }
                            Intrinsics.checkNotNull(obj7);
                            int width6 = ((Placeable) obj7).getWidth();
                            if (arrayList9.isEmpty()) {
                                arrayList = arrayList9;
                                obj8 = null;
                            } else {
                                obj8 = arrayList9.get(0);
                                int height7 = ((Placeable) obj8).getHeight();
                                int lastIndex5 = CollectionsKt.getLastIndex(arrayList9);
                                if (1 <= lastIndex5) {
                                    Object obj16 = obj8;
                                    int i22 = height7;
                                    int i23 = 1;
                                    while (true) {
                                        Object obj17 = arrayList9.get(i23);
                                        arrayList = arrayList9;
                                        int height8 = ((Placeable) obj17).getHeight();
                                        if (i22 < height8) {
                                            i22 = height8;
                                            obj16 = obj17;
                                        }
                                        if (i23 == lastIndex5) {
                                            break;
                                        }
                                        i23++;
                                        arrayList9 = arrayList;
                                    }
                                    obj8 = obj16;
                                } else {
                                    arrayList = arrayList9;
                                }
                            }
                            Intrinsics.checkNotNull(obj8);
                            int height9 = ((Placeable) obj8).getHeight();
                            int i24 = i;
                            if (FabPosition.m1904equalsimpl0(i24, FabPosition.Companion.m1911getStartERTFSPs())) {
                                if (subcomposeMeasureScope.getLayoutDirection() == LayoutDirection.Ltr) {
                                    f6 = ScaffoldKt.FabSpacing;
                                    i7 = subcomposeMeasureScope.mo383roundToPx0680j_4(f6);
                                    fabPlacement = new FabPlacement(i7, width6, height9);
                                } else {
                                    f5 = ScaffoldKt.FabSpacing;
                                    i8 = subcomposeMeasureScope.mo383roundToPx0680j_4(f5);
                                    i7 = (m6637getMaxWidthimpl - i8) - width6;
                                    fabPlacement = new FabPlacement(i7, width6, height9);
                                }
                            } else {
                                if (FabPosition.m1904equalsimpl0(i24, FabPosition.Companion.m1909getEndERTFSPs()) ? true : FabPosition.m1904equalsimpl0(i24, FabPosition.Companion.m1910getEndOverlayERTFSPs())) {
                                    if (subcomposeMeasureScope.getLayoutDirection() == LayoutDirection.Ltr) {
                                        f4 = ScaffoldKt.FabSpacing;
                                        i8 = subcomposeMeasureScope.mo383roundToPx0680j_4(f4);
                                        i7 = (m6637getMaxWidthimpl - i8) - width6;
                                    } else {
                                        f3 = ScaffoldKt.FabSpacing;
                                        i7 = subcomposeMeasureScope.mo383roundToPx0680j_4(f3);
                                    }
                                } else {
                                    i7 = (m6637getMaxWidthimpl - width6) / 2;
                                }
                                fabPlacement = new FabPlacement(i7, width6, height9);
                            }
                        }
                        ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.BottomBar;
                        final Function2<Composer, Integer, Unit> function26 = function24;
                        List<Measurable> subcompose4 = subcomposeMeasureScope.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(-2146438447, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1$bottomBarPlaceables$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num2) {
                                invoke(composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i25) {
                                ComposerKt.sourceInformation(composer2, "C209@10015L11:Scaffold.kt#uh7d8r");
                                if ((i25 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2146438447, i25, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:209)");
                                }
                                function26.invoke(composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        ArrayList arrayList10 = new ArrayList(subcompose4.size());
                        int size4 = subcompose4.size();
                        for (int i25 = 0; i25 < size4; i25++) {
                            arrayList10.add(subcompose4.get(i25).mo5438measureBRTryo0(m6627copyZbe2FdA$default));
                        }
                        final ArrayList arrayList11 = arrayList10;
                        if (arrayList11.isEmpty()) {
                            obj6 = null;
                        } else {
                            obj6 = arrayList11.get(0);
                            int height10 = ((Placeable) obj6).getHeight();
                            int lastIndex6 = CollectionsKt.getLastIndex(arrayList11);
                            if (1 <= lastIndex6) {
                                int i26 = 1;
                                while (true) {
                                    Object obj18 = arrayList11.get(i26);
                                    int height11 = ((Placeable) obj18).getHeight();
                                    if (height10 < height11) {
                                        height10 = height11;
                                        obj6 = obj18;
                                    }
                                    if (i26 == lastIndex6) {
                                        break;
                                    }
                                    i26++;
                                }
                            }
                        }
                        Placeable placeable4 = (Placeable) obj6;
                        final Integer valueOf = placeable4 != null ? Integer.valueOf(placeable4.getHeight()) : null;
                        if (fabPlacement != null) {
                            int i27 = i;
                            WindowInsets windowInsets5 = windowInsets2;
                            if (valueOf == null || FabPosition.m1904equalsimpl0(i27, FabPosition.Companion.m1910getEndOverlayERTFSPs())) {
                                int height12 = fabPlacement.getHeight();
                                f = ScaffoldKt.FabSpacing;
                                i6 = height12 + subcomposeMeasureScope.mo383roundToPx0680j_4(f);
                                bottom = windowInsets5.getBottom(subcomposeMeasureScope);
                            } else {
                                i6 = valueOf.intValue() + fabPlacement.getHeight();
                                f2 = ScaffoldKt.FabSpacing;
                                bottom = subcomposeMeasureScope.mo383roundToPx0680j_4(f2);
                            }
                            num = Integer.valueOf(i6 + bottom);
                        } else {
                            num = null;
                        }
                        if (i19 != 0) {
                            if (num != null) {
                                intValue = num.intValue();
                            } else {
                                intValue = valueOf != null ? valueOf.intValue() : windowInsets2.getBottom(subcomposeMeasureScope);
                            }
                            i5 = i19 + intValue;
                        } else {
                            i5 = 0;
                        }
                        ScaffoldLayoutContent scaffoldLayoutContent2 = ScaffoldLayoutContent.MainContent;
                        final WindowInsets windowInsets6 = windowInsets2;
                        final Function3<PaddingValues, Composer, Integer, Unit> function33 = function32;
                        List<Measurable> subcompose5 = subcomposeMeasureScope.subcompose(scaffoldLayoutContent2, ComposableLambdaKt.composableLambdaInstance(-1213360416, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1$bodyContentPlaceables$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num2) {
                                invoke(composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i28) {
                                float f7;
                                float mo687calculateBottomPaddingD9Ej5fM;
                                Integer num2;
                                ComposerKt.sourceInformation(composer2, "C260@12377L21:Scaffold.kt#uh7d8r");
                                if ((i28 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1213360416, i28, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:238)");
                                    }
                                    PaddingValues asPaddingValues = WindowInsetsKt.asPaddingValues(WindowInsets.this, subcomposeMeasureScope);
                                    if (arrayList5.isEmpty()) {
                                        f7 = asPaddingValues.mo690calculateTopPaddingD9Ej5fM();
                                    } else {
                                        f7 = subcomposeMeasureScope.mo386toDpu2uoSUM(i12);
                                    }
                                    if (arrayList11.isEmpty() || (num2 = valueOf) == null) {
                                        mo687calculateBottomPaddingD9Ej5fM = asPaddingValues.mo687calculateBottomPaddingD9Ej5fM();
                                    } else {
                                        mo687calculateBottomPaddingD9Ej5fM = subcomposeMeasureScope.mo386toDpu2uoSUM(num2.intValue());
                                    }
                                    function33.invoke(PaddingKt.m734PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(asPaddingValues, subcomposeMeasureScope.getLayoutDirection()), f7, PaddingKt.calculateEndPadding(asPaddingValues, subcomposeMeasureScope.getLayoutDirection()), mo687calculateBottomPaddingD9Ej5fM), composer2, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }));
                        ArrayList arrayList12 = new ArrayList(subcompose5.size());
                        int size5 = subcompose5.size();
                        for (int i28 = 0; i28 < size5; i28++) {
                            arrayList12.add(subcompose5.get(i28).mo5438measureBRTryo0(m6627copyZbe2FdA$default));
                        }
                        final ArrayList arrayList13 = arrayList12;
                        final Integer num2 = valueOf;
                        final WindowInsets windowInsets7 = windowInsets2;
                        final int i29 = width3;
                        final Integer num3 = num;
                        final int i30 = i5;
                        final FabPlacement fabPlacement2 = fabPlacement;
                        final ArrayList arrayList14 = arrayList;
                        return MeasureScope.layout$default(subcomposeMeasureScope, m6637getMaxWidthimpl, m6636getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                List<Placeable> list2 = arrayList13;
                                int size6 = list2.size();
                                for (int i31 = 0; i31 < size6; i31++) {
                                    Placeable.PlacementScope.place$default(placementScope, list2.get(i31), 0, 0, 0.0f, 4, null);
                                }
                                List<Placeable> list3 = arrayList5;
                                int size7 = list3.size();
                                for (int i32 = 0; i32 < size7; i32++) {
                                    Placeable.PlacementScope.place$default(placementScope, list3.get(i32), 0, 0, 0.0f, 4, null);
                                }
                                List<Placeable> list4 = arrayList6;
                                int i33 = m6637getMaxWidthimpl;
                                int i34 = i29;
                                WindowInsets windowInsets8 = windowInsets7;
                                SubcomposeMeasureScope subcomposeMeasureScope4 = subcomposeMeasureScope;
                                int i35 = m6636getMaxHeightimpl;
                                int i36 = i30;
                                int size8 = list4.size();
                                for (int i37 = 0; i37 < size8; i37++) {
                                    Placeable.PlacementScope.place$default(placementScope, list4.get(i37), ((i33 - i34) / 2) + windowInsets8.getLeft(subcomposeMeasureScope4, subcomposeMeasureScope4.getLayoutDirection()), i35 - i36, 0.0f, 4, null);
                                }
                                List<Placeable> list5 = arrayList11;
                                int i38 = m6636getMaxHeightimpl;
                                Integer num4 = num2;
                                int size9 = list5.size();
                                for (int i39 = 0; i39 < size9; i39++) {
                                    Placeable.PlacementScope.place$default(placementScope, list5.get(i39), 0, i38 - (num4 != null ? num4.intValue() : 0), 0.0f, 4, null);
                                }
                                FabPlacement fabPlacement3 = fabPlacement2;
                                if (fabPlacement3 != null) {
                                    List<Placeable> list6 = arrayList14;
                                    int i40 = m6636getMaxHeightimpl;
                                    Integer num5 = num3;
                                    int size10 = list6.size();
                                    for (int i41 = 0; i41 < size10; i41++) {
                                        int left = fabPlacement3.getLeft();
                                        Intrinsics.checkNotNull(num5);
                                        Placeable.PlacementScope.place$default(placementScope, list6.get(i41), left, i40 - num5.intValue(), 0.0f, 4, null);
                                    }
                                }
                            }
                        }, 4, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            } else {
                i4 = 0;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) rememberedValue, startRestartGroup, i4, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$2
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

                public final void invoke(Composer composer2, int i5) {
                    ScaffoldKt.m2213ScaffoldLayoutFMILGgc(i, function2, function3, function22, function23, windowInsets, function24, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }
}
