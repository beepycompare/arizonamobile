package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.DialogProperties;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: AndroidAlertDialog.android.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aß\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "icon", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "iconContentColor", "titleContentColor", "textContentColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-Oix01E0", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJJJFLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;III)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidAlertDialog_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:228:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011c  */
    /* renamed from: AlertDialog-Oix01E0  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1564AlertDialogOix01E0(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Shape shape, long j, long j2, long j3, long j4, float f, DialogProperties dialogProperties, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        Modifier.Companion companion;
        int i6;
        int i7;
        Object obj;
        int i8;
        Object obj2;
        int i9;
        Object obj3;
        Object obj4;
        int i10;
        long j5;
        int i11;
        int i12;
        int i13;
        long j6;
        long j7;
        long j8;
        long j9;
        DialogProperties dialogProperties2;
        float f2;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Shape shape2;
        Modifier modifier2;
        int i14;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Function2<? super Composer, ? super Integer, Unit> function29;
        long j10;
        long j11;
        int i15;
        int i16;
        long j12;
        long j13;
        Composer composer2;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Shape shape3;
        final long j14;
        final long j15;
        final long j16;
        final long j17;
        final float f3;
        final DialogProperties dialogProperties3;
        ScopeUpdateScope endRestartGroup;
        int i17;
        Composer startRestartGroup = composer.startRestartGroup(-2081346864);
        ComposerKt.sourceInformation(startRestartGroup, "C(AlertDialog)P(6!1,5,2,3,11,9,8,1:c#ui.graphics.Color,4:c#ui.graphics.Color,12:c#ui.graphics.Color,10:c#ui.graphics.Color,13:c#ui.unit.Dp)62@4918L5,62@4973L14,62@5039L16,62@5108L17,62@5177L16,46@1648L513:AndroidAlertDialog.android.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                companion = modifier;
                i4 |= startRestartGroup.changed(companion) ? 256 : 128;
                i6 = i3 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else if ((i & 3072) == 0) {
                    i4 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
                    i7 = i3 & 16;
                    if (i7 == 0) {
                        i4 |= 24576;
                    } else if ((i & 24576) == 0) {
                        obj = function23;
                        i4 |= startRestartGroup.changedInstance(obj) ? 16384 : 8192;
                        i8 = i3 & 32;
                        if (i8 != 0) {
                            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            obj2 = function24;
                        } else {
                            obj2 = function24;
                            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i4 |= startRestartGroup.changedInstance(obj2) ? 131072 : 65536;
                            }
                        }
                        i9 = i3 & 64;
                        if (i9 != 0) {
                            i4 |= 1572864;
                            obj3 = function25;
                        } else {
                            obj3 = function25;
                            if ((i & 1572864) == 0) {
                                i4 |= startRestartGroup.changedInstance(obj3) ? 1048576 : 524288;
                            }
                        }
                        if ((i & 12582912) == 0) {
                            if ((i3 & 128) == 0) {
                                obj4 = shape;
                                if (startRestartGroup.changed(obj4)) {
                                    i17 = 8388608;
                                    i4 |= i17;
                                }
                            } else {
                                obj4 = shape;
                            }
                            i17 = 4194304;
                            i4 |= i17;
                        } else {
                            obj4 = shape;
                        }
                        if ((i & 100663296) == 0) {
                            i4 |= ((i3 & 256) == 0 && startRestartGroup.changed(j)) ? 67108864 : 33554432;
                        }
                        if ((805306368 & i) == 0) {
                            i4 |= ((i3 & 512) == 0 && startRestartGroup.changed(j2)) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        }
                        if ((i2 & 6) == 0) {
                            i10 = i2 | (((i3 & 1024) == 0 && startRestartGroup.changed(j3)) ? 4 : 2);
                        } else {
                            i10 = i2;
                        }
                        if ((i2 & 48) == 0) {
                            j5 = j4;
                            i10 |= ((i3 & 2048) == 0 && startRestartGroup.changed(j5)) ? 32 : 16;
                        } else {
                            j5 = j4;
                        }
                        i11 = i3 & 4096;
                        if (i11 != 0) {
                            i10 |= RendererCapabilities.DECODER_SUPPORT_MASK;
                        } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                            i10 |= startRestartGroup.changed(f) ? 256 : 128;
                            i12 = i3 & 8192;
                            if (i12 == 0) {
                                i10 |= 3072;
                                i13 = i12;
                            } else {
                                i13 = i12;
                                if ((i2 & 3072) == 0) {
                                    i10 |= startRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                                    if ((i4 & 306783379) == 306783378 || (i10 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
                                        startRestartGroup.startDefaults();
                                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                            if (i5 != 0) {
                                                companion = Modifier.Companion;
                                            }
                                            Function2<? super Composer, ? super Integer, Unit> function214 = i6 != 0 ? null : function22;
                                            if (i7 != 0) {
                                                obj = null;
                                            }
                                            if (i8 != 0) {
                                                obj2 = null;
                                            }
                                            if (i9 != 0) {
                                                obj3 = null;
                                            }
                                            if ((i3 & 128) != 0) {
                                                i4 &= -29360129;
                                                obj4 = AlertDialogDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                            }
                                            if ((i3 & 256) != 0) {
                                                j6 = AlertDialogDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                                i4 &= -234881025;
                                            } else {
                                                j6 = j;
                                            }
                                            if ((i3 & 512) != 0) {
                                                j7 = AlertDialogDefaults.INSTANCE.getIconContentColor(startRestartGroup, 6);
                                                i4 = (-1879048193) & i4;
                                            } else {
                                                j7 = j2;
                                            }
                                            if ((i3 & 1024) != 0) {
                                                j8 = AlertDialogDefaults.INSTANCE.getTitleContentColor(startRestartGroup, 6);
                                                i10 &= -15;
                                            } else {
                                                j8 = j3;
                                            }
                                            if ((i3 & 2048) != 0) {
                                                j9 = AlertDialogDefaults.INSTANCE.getTextContentColor(startRestartGroup, 6);
                                                i10 &= -113;
                                            } else {
                                                j9 = j5;
                                            }
                                            float m1558getTonalElevationD9Ej5fM = i11 != 0 ? AlertDialogDefaults.INSTANCE.m1558getTonalElevationD9Ej5fM() : f;
                                            if (i13 != 0) {
                                                f2 = m1558getTonalElevationD9Ej5fM;
                                                dialogProperties2 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                            } else {
                                                dialogProperties2 = dialogProperties;
                                                f2 = m1558getTonalElevationD9Ej5fM;
                                            }
                                            function26 = obj2;
                                            function27 = obj3;
                                            shape2 = obj4;
                                            modifier2 = companion;
                                            i14 = -2081346864;
                                            int i18 = i4;
                                            function28 = obj;
                                            function29 = function214;
                                            j10 = j6;
                                            j11 = j8;
                                            long j18 = j9;
                                            i15 = i18;
                                            i16 = i10;
                                            j12 = j7;
                                            j13 = j18;
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            if ((i3 & 128) != 0) {
                                                i4 &= -29360129;
                                            }
                                            if ((i3 & 256) != 0) {
                                                i4 &= -234881025;
                                            }
                                            if ((i3 & 512) != 0) {
                                                i4 &= -1879048193;
                                            }
                                            if ((i3 & 1024) != 0) {
                                                i10 &= -15;
                                            }
                                            if ((i3 & 2048) != 0) {
                                                i10 &= -113;
                                            }
                                            j11 = j3;
                                            f2 = f;
                                            dialogProperties2 = dialogProperties;
                                            j13 = j5;
                                            i15 = i4;
                                            function26 = obj2;
                                            function27 = obj3;
                                            shape2 = obj4;
                                            i16 = i10;
                                            modifier2 = companion;
                                            i14 = -2081346864;
                                            j10 = j;
                                            j12 = j2;
                                            function28 = obj;
                                            function29 = function22;
                                        }
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(i14, i15, i16, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                                        }
                                        composer2 = startRestartGroup;
                                        AlertDialogKt.m1561AlertDialogImplwrnwzgE(function0, function2, modifier2, function29, function28, function26, function27, shape2, j10, j12, j11, j13, f2, dialogProperties2, composer2, i15 & 2147483646, i16 & 8190);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        modifier3 = modifier2;
                                        function210 = function29;
                                        function211 = function28;
                                        function212 = function26;
                                        function213 = function27;
                                        shape3 = shape2;
                                        j14 = j10;
                                        j15 = j12;
                                        j16 = j11;
                                        j17 = j13;
                                        f3 = f2;
                                        dialogProperties3 = dialogProperties2;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        f3 = f;
                                        dialogProperties3 = dialogProperties;
                                        composer2 = startRestartGroup;
                                        shape3 = obj4;
                                        modifier3 = companion;
                                        function210 = function22;
                                        j16 = j3;
                                        j17 = j5;
                                        function211 = obj;
                                        function212 = obj2;
                                        function213 = obj3;
                                        j14 = j;
                                        j15 = j2;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1
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
                                                AndroidAlertDialog_androidKt.m1564AlertDialogOix01E0(function0, function2, modifier3, function210, function211, function212, function213, shape3, j14, j15, j16, j17, f3, dialogProperties3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                            }
                            if ((i4 & 306783379) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                            }
                            if (i5 != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if (i7 != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if ((i3 & 128) != 0) {
                            }
                            if ((i3 & 256) != 0) {
                            }
                            if ((i3 & 512) != 0) {
                            }
                            if ((i3 & 1024) != 0) {
                            }
                            if ((i3 & 2048) != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i13 != 0) {
                            }
                            function26 = obj2;
                            function27 = obj3;
                            shape2 = obj4;
                            modifier2 = companion;
                            i14 = -2081346864;
                            int i182 = i4;
                            function28 = obj;
                            function29 = function214;
                            j10 = j6;
                            j11 = j8;
                            long j182 = j9;
                            i15 = i182;
                            i16 = i10;
                            j12 = j7;
                            j13 = j182;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = startRestartGroup;
                            AlertDialogKt.m1561AlertDialogImplwrnwzgE(function0, function2, modifier2, function29, function28, function26, function27, shape2, j10, j12, j11, j13, f2, dialogProperties2, composer2, i15 & 2147483646, i16 & 8190);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = modifier2;
                            function210 = function29;
                            function211 = function28;
                            function212 = function26;
                            function213 = function27;
                            shape3 = shape2;
                            j14 = j10;
                            j15 = j12;
                            j16 = j11;
                            j17 = j13;
                            f3 = f2;
                            dialogProperties3 = dialogProperties2;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i12 = i3 & 8192;
                        if (i12 == 0) {
                        }
                        if ((i4 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if ((i3 & 128) != 0) {
                        }
                        if ((i3 & 256) != 0) {
                        }
                        if ((i3 & 512) != 0) {
                        }
                        if ((i3 & 1024) != 0) {
                        }
                        if ((i3 & 2048) != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i13 != 0) {
                        }
                        function26 = obj2;
                        function27 = obj3;
                        shape2 = obj4;
                        modifier2 = companion;
                        i14 = -2081346864;
                        int i1822 = i4;
                        function28 = obj;
                        function29 = function214;
                        j10 = j6;
                        j11 = j8;
                        long j1822 = j9;
                        i15 = i1822;
                        i16 = i10;
                        j12 = j7;
                        j13 = j1822;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = startRestartGroup;
                        AlertDialogKt.m1561AlertDialogImplwrnwzgE(function0, function2, modifier2, function29, function28, function26, function27, shape2, j10, j12, j11, j13, f2, dialogProperties2, composer2, i15 & 2147483646, i16 & 8190);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier2;
                        function210 = function29;
                        function211 = function28;
                        function212 = function26;
                        function213 = function27;
                        shape3 = shape2;
                        j14 = j10;
                        j15 = j12;
                        j16 = j11;
                        j17 = j13;
                        f3 = f2;
                        dialogProperties3 = dialogProperties2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    obj = function23;
                    i8 = i3 & 32;
                    if (i8 != 0) {
                    }
                    i9 = i3 & 64;
                    if (i9 != 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    if ((i & 100663296) == 0) {
                    }
                    if ((805306368 & i) == 0) {
                    }
                    if ((i2 & 6) == 0) {
                    }
                    if ((i2 & 48) == 0) {
                    }
                    i11 = i3 & 4096;
                    if (i11 != 0) {
                    }
                    i12 = i3 & 8192;
                    if (i12 == 0) {
                    }
                    if ((i4 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if ((i3 & 128) != 0) {
                    }
                    if ((i3 & 256) != 0) {
                    }
                    if ((i3 & 512) != 0) {
                    }
                    if ((i3 & 1024) != 0) {
                    }
                    if ((i3 & 2048) != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    function26 = obj2;
                    function27 = obj3;
                    shape2 = obj4;
                    modifier2 = companion;
                    i14 = -2081346864;
                    int i18222 = i4;
                    function28 = obj;
                    function29 = function214;
                    j10 = j6;
                    j11 = j8;
                    long j18222 = j9;
                    i15 = i18222;
                    i16 = i10;
                    j12 = j7;
                    j13 = j18222;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    AlertDialogKt.m1561AlertDialogImplwrnwzgE(function0, function2, modifier2, function29, function28, function26, function27, shape2, j10, j12, j11, j13, f2, dialogProperties2, composer2, i15 & 2147483646, i16 & 8190);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier2;
                    function210 = function29;
                    function211 = function28;
                    function212 = function26;
                    function213 = function27;
                    shape3 = shape2;
                    j14 = j10;
                    j15 = j12;
                    j16 = j11;
                    j17 = j13;
                    f3 = f2;
                    dialogProperties3 = dialogProperties2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i7 = i3 & 16;
                if (i7 == 0) {
                }
                obj = function23;
                i8 = i3 & 32;
                if (i8 != 0) {
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((805306368 & i) == 0) {
                }
                if ((i2 & 6) == 0) {
                }
                if ((i2 & 48) == 0) {
                }
                i11 = i3 & 4096;
                if (i11 != 0) {
                }
                i12 = i3 & 8192;
                if (i12 == 0) {
                }
                if ((i4 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if ((i3 & 128) != 0) {
                }
                if ((i3 & 256) != 0) {
                }
                if ((i3 & 512) != 0) {
                }
                if ((i3 & 1024) != 0) {
                }
                if ((i3 & 2048) != 0) {
                }
                if (i11 != 0) {
                }
                if (i13 != 0) {
                }
                function26 = obj2;
                function27 = obj3;
                shape2 = obj4;
                modifier2 = companion;
                i14 = -2081346864;
                int i182222 = i4;
                function28 = obj;
                function29 = function214;
                j10 = j6;
                j11 = j8;
                long j182222 = j9;
                i15 = i182222;
                i16 = i10;
                j12 = j7;
                j13 = j182222;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                AlertDialogKt.m1561AlertDialogImplwrnwzgE(function0, function2, modifier2, function29, function28, function26, function27, shape2, j10, j12, j11, j13, f2, dialogProperties2, composer2, i15 & 2147483646, i16 & 8190);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier2;
                function210 = function29;
                function211 = function28;
                function212 = function26;
                function213 = function27;
                shape3 = shape2;
                j14 = j10;
                j15 = j12;
                j16 = j11;
                j17 = j13;
                f3 = f2;
                dialogProperties3 = dialogProperties2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            companion = modifier;
            i6 = i3 & 8;
            if (i6 != 0) {
            }
            i7 = i3 & 16;
            if (i7 == 0) {
            }
            obj = function23;
            i8 = i3 & 32;
            if (i8 != 0) {
            }
            i9 = i3 & 64;
            if (i9 != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((805306368 & i) == 0) {
            }
            if ((i2 & 6) == 0) {
            }
            if ((i2 & 48) == 0) {
            }
            i11 = i3 & 4096;
            if (i11 != 0) {
            }
            i12 = i3 & 8192;
            if (i12 == 0) {
            }
            if ((i4 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if ((i3 & 128) != 0) {
            }
            if ((i3 & 256) != 0) {
            }
            if ((i3 & 512) != 0) {
            }
            if ((i3 & 1024) != 0) {
            }
            if ((i3 & 2048) != 0) {
            }
            if (i11 != 0) {
            }
            if (i13 != 0) {
            }
            function26 = obj2;
            function27 = obj3;
            shape2 = obj4;
            modifier2 = companion;
            i14 = -2081346864;
            int i1822222 = i4;
            function28 = obj;
            function29 = function214;
            j10 = j6;
            j11 = j8;
            long j1822222 = j9;
            i15 = i1822222;
            i16 = i10;
            j12 = j7;
            j13 = j1822222;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            AlertDialogKt.m1561AlertDialogImplwrnwzgE(function0, function2, modifier2, function29, function28, function26, function27, shape2, j10, j12, j11, j13, f2, dialogProperties2, composer2, i15 & 2147483646, i16 & 8190);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            function210 = function29;
            function211 = function28;
            function212 = function26;
            function213 = function27;
            shape3 = shape2;
            j14 = j10;
            j15 = j12;
            j16 = j11;
            j17 = j13;
            f3 = f2;
            dialogProperties3 = dialogProperties2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        companion = modifier;
        i6 = i3 & 8;
        if (i6 != 0) {
        }
        i7 = i3 & 16;
        if (i7 == 0) {
        }
        obj = function23;
        i8 = i3 & 32;
        if (i8 != 0) {
        }
        i9 = i3 & 64;
        if (i9 != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((805306368 & i) == 0) {
        }
        if ((i2 & 6) == 0) {
        }
        if ((i2 & 48) == 0) {
        }
        i11 = i3 & 4096;
        if (i11 != 0) {
        }
        i12 = i3 & 8192;
        if (i12 == 0) {
        }
        if ((i4 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if ((i3 & 128) != 0) {
        }
        if ((i3 & 256) != 0) {
        }
        if ((i3 & 512) != 0) {
        }
        if ((i3 & 1024) != 0) {
        }
        if ((i3 & 2048) != 0) {
        }
        if (i11 != 0) {
        }
        if (i13 != 0) {
        }
        function26 = obj2;
        function27 = obj3;
        shape2 = obj4;
        modifier2 = companion;
        i14 = -2081346864;
        int i18222222 = i4;
        function28 = obj;
        function29 = function214;
        j10 = j6;
        j11 = j8;
        long j18222222 = j9;
        i15 = i18222222;
        i16 = i10;
        j12 = j7;
        j13 = j18222222;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        AlertDialogKt.m1561AlertDialogImplwrnwzgE(function0, function2, modifier2, function29, function28, function26, function27, shape2, j10, j12, j11, j13, f2, dialogProperties2, composer2, i15 & 2147483646, i16 & 8190);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        function210 = function29;
        function211 = function28;
        function212 = function26;
        function213 = function27;
        shape3 = shape2;
        j14 = j10;
        j15 = j12;
        j16 = j11;
        j17 = j13;
        f3 = f2;
        dialogProperties3 = dialogProperties2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
