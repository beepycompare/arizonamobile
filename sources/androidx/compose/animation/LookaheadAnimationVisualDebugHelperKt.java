package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
/* compiled from: LookaheadAnimationVisualDebugHelper.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aT\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\t2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a*\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00052\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"colorIndex", "", "keyToColor", "Landroidx/collection/MutableScatterMap;", "", "Landroidx/compose/ui/graphics/Color;", "LookaheadAnimationVisualDebugging", "", "isEnabled", "", "overlayColor", "multipleMatchesColor", "unmatchedElementColor", "isShowKeyLabelEnabled", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "LookaheadAnimationVisualDebugging-gUzqikQ", "(ZJJJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "CustomizedLookaheadAnimationVisualDebugging", "debugColor", "CustomizedLookaheadAnimationVisualDebugging-Iv8Zu3U", "(JLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "animation"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LookaheadAnimationVisualDebugHelperKt {
    private static int colorIndex;
    private static final MutableScatterMap<Object, Color> keyToColor = new MutableScatterMap<>(0, 1, null);

    /* JADX WARN: Removed duplicated region for block: B:124:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:195:? A[RETURN, SYNTHETIC] */
    /* renamed from: LookaheadAnimationVisualDebugging-gUzqikQ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m136LookaheadAnimationVisualDebugginggUzqikQ(boolean z, long j, long j2, long j3, boolean z2, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        boolean z3;
        int i3;
        long j4;
        int i4;
        long j5;
        int i5;
        long j6;
        int i6;
        final boolean z4;
        boolean z5;
        final long j7;
        final long j8;
        final long j9;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1722790302);
        ComposerKt.sourceInformation(startRestartGroup, "C(LookaheadAnimationVisualDebugging)N(isEnabled,overlayColor:c#ui.graphics.Color,multipleMatchesColor:c#ui.graphics.Color,unmatchedElementColor:c#ui.graphics.Color,isShowKeyLabelEnabled,content)559@20834L353:LookaheadAnimationVisualDebugHelper.kt#xbi5r1");
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i | 6;
            z3 = z;
        } else if ((i & 6) == 0) {
            z3 = z;
            i3 = (startRestartGroup.changed(z3) ? 4 : 2) | i;
        } else {
            z3 = z;
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            j4 = j;
            i3 |= startRestartGroup.changed(j4) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                j5 = j2;
                i3 |= startRestartGroup.changed(j5) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    j6 = j3;
                    i3 |= startRestartGroup.changed(j6) ? 2048 : 1024;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        i3 |= startRestartGroup.changed(z2) ? 16384 : 8192;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i3 |= startRestartGroup.changedInstance(function2) ? 131072 : 65536;
                        }
                        if (!startRestartGroup.shouldExecute((i3 & 74899) != 74898, i3 & 1)) {
                            startRestartGroup.skipToGroupEnd();
                            z4 = z2;
                            z5 = z3;
                            j7 = j4;
                            j8 = j5;
                            j9 = j6;
                        } else {
                            z5 = i7 != 0 ? true : z3;
                            long Color = i8 != 0 ? ColorKt.Color(2150934611L) : j4;
                            long Color2 = i4 != 0 ? ColorKt.Color(4293542709L) : j5;
                            long Color3 = i5 != 0 ? ColorKt.Color(4288323750L) : j6;
                            boolean z6 = i6 != 0 ? false : z2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1722790302, i3, -1, "androidx.compose.animation.LookaheadAnimationVisualDebugging (LookaheadAnimationVisualDebugHelper.kt:558)");
                            }
                            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugConfig().provides(new LookaheadAnimationVisualDebugConfig(z5, Color, Color2, Color3, z6, null)), function2, startRestartGroup, ProvidedValue.$stable | ((i3 >> 12) & 112));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j7 = Color;
                            j8 = Color2;
                            j9 = Color3;
                            z4 = z6;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final boolean z7 = z5;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.LookaheadAnimationVisualDebugHelperKt$LookaheadAnimationVisualDebugging$1
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

                                public final void invoke(Composer composer2, int i9) {
                                    LookaheadAnimationVisualDebugHelperKt.m136LookaheadAnimationVisualDebugginggUzqikQ(z7, j7, j8, j9, z4, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i3 & 74899) != 74898, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                j6 = j3;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                if (!startRestartGroup.shouldExecute((i3 & 74899) != 74898, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            j5 = j2;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            j6 = j3;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            if (!startRestartGroup.shouldExecute((i3 & 74899) != 74898, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        j4 = j;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        j5 = j2;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        j6 = j3;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 74899) != 74898, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* renamed from: CustomizedLookaheadAnimationVisualDebugging-Iv8Zu3U */
    public static final void m135CustomizedLookaheadAnimationVisualDebuggingIv8Zu3U(final long j, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1657127863);
        ComposerKt.sourceInformation(startRestartGroup, "C(CustomizedLookaheadAnimationVisualDebugging)N(debugColor:c#ui.graphics.Color,content)592@22107L129:LookaheadAnimationVisualDebugHelper.kt#xbi5r1");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1657127863, i2, -1, "androidx.compose.animation.CustomizedLookaheadAnimationVisualDebugging (LookaheadAnimationVisualDebugHelper.kt:591)");
            }
            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugColor().provides(Color.m5338boximpl(j)), function2, startRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.LookaheadAnimationVisualDebugHelperKt$CustomizedLookaheadAnimationVisualDebugging$1
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

                public final void invoke(Composer composer2, int i3) {
                    LookaheadAnimationVisualDebugHelperKt.m135CustomizedLookaheadAnimationVisualDebuggingIv8Zu3U(j, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
