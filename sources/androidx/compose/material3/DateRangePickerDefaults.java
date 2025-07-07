package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DateRangePicker.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0087\u0001\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00040\u0014¢\u0006\u0002\b\u00152\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00040\u0014¢\u0006\u0002\b\u00152\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00040\u0014¢\u0006\u0002\b\u0015H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J$\u0010\u001a\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/DateRangePickerDefaults;", "", "()V", "DateRangePickerHeadline", "", "selectedStartDateMillis", "", "selectedEndDateMillis", "displayMode", "Landroidx/compose/material3/DisplayMode;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "modifier", "Landroidx/compose/ui/Modifier;", "DateRangePickerHeadline-v84Udv0", "(Ljava/lang/Long;Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "startDateText", "", "endDateText", "startDatePlaceholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "endDatePlaceholder", "datesDelimiter", "DateRangePickerHeadline-0YIUgSQ", "(Ljava/lang/Long;Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DateRangePickerTitle", "DateRangePickerTitle-hOD91z4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DateRangePickerDefaults {
    public static final int $stable = 0;
    public static final DateRangePickerDefaults INSTANCE = new DateRangePickerDefaults();

    private DateRangePickerDefaults() {
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* renamed from: DateRangePickerTitle-hOD91z4  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1845DateRangePickerTitlehOD91z4(final int i, Modifier modifier, Composer composer, final int i2, final int i3) {
        int i4;
        Object obj;
        Composer composer2;
        final Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1412719908);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateRangePickerTitle)P(0:c#material3.DisplayMode):DateRangePicker.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = i2 | (startRestartGroup.changed(i) ? 4 : 2);
        } else {
            i4 = i2;
        }
        int i5 = i3 & 2;
        if (i5 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            obj = modifier;
            i4 |= startRestartGroup.changed(obj) ? 32 : 16;
            if ((i4 & 19) == 18 || !startRestartGroup.getSkipping()) {
                Modifier.Companion companion = i5 == 0 ? Modifier.Companion : obj;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1412719908, i4, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerTitle (DateRangePicker.kt:338)");
                }
                if (!DisplayMode.m1868equalsimpl0(i, DisplayMode.Companion.m1873getPickerjFl4v0())) {
                    startRestartGroup.startReplaceGroup(980469064);
                    ComposerKt.sourceInformation(startRestartGroup, "341@15673L48,341@15668L75");
                    Strings.Companion companion2 = Strings.Companion;
                    TextKt.m2497Text4IGK_g(Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_date_range_picker_title), startRestartGroup, 0), companion, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, i4 & 112, 0, 131068);
                    composer2 = startRestartGroup;
                    composer2.endReplaceGroup();
                } else {
                    composer2 = startRestartGroup;
                    if (DisplayMode.m1868equalsimpl0(i, DisplayMode.Companion.m1872getInputjFl4v0())) {
                        composer2.startReplaceGroup(980473063);
                        ComposerKt.sourceInformation(composer2, "343@15798L47,343@15793L74");
                        Strings.Companion companion3 = Strings.Companion;
                        TextKt.m2497Text4IGK_g(Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_date_range_input_title), composer2, 0), companion, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, i4 & 112, 0, 131068);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(329974917);
                        composer2.endReplaceGroup();
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = companion;
            } else {
                startRestartGroup.skipToGroupEnd();
                composer2 = startRestartGroup;
                modifier2 = obj;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerTitle$1
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

                    public final void invoke(Composer composer3, int i6) {
                        DateRangePickerDefaults.this.m1845DateRangePickerTitlehOD91z4(i, modifier2, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
                return;
            }
            return;
        }
        obj = modifier;
        if ((i4 & 19) == 18) {
        }
        if (i5 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (!DisplayMode.m1868equalsimpl0(i, DisplayMode.Companion.m1873getPickerjFl4v0())) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = companion;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /* renamed from: DateRangePickerHeadline-v84Udv0  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1844DateRangePickerHeadlinev84Udv0(final Long l, final Long l2, final int i, final DatePickerFormatter datePickerFormatter, Modifier modifier, Composer composer, final int i2, final int i3) {
        Long l3;
        int i4;
        Object obj;
        int i5;
        int i6;
        Modifier.Companion companion;
        Object obj2;
        final Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1611069472);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateRangePickerHeadline)P(4,3,1:c#material3.DisplayMode)367@16887L47,368@16961L45,377@17394L30,378@17459L28,369@17015L534:DateRangePicker.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
            l3 = l;
        } else if ((i2 & 6) == 0) {
            l3 = l;
            i4 = (startRestartGroup.changed(l3) ? 4 : 2) | i2;
        } else {
            l3 = l;
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            obj = l2;
            i4 |= startRestartGroup.changed(obj) ? 32 : 16;
            if ((i3 & 4) == 0) {
                i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i5 = i;
                i4 |= startRestartGroup.changed(i5) ? 256 : 128;
                if ((i3 & 8) != 0) {
                    i4 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    i4 |= (i2 & 4096) == 0 ? startRestartGroup.changed(datePickerFormatter) : startRestartGroup.changedInstance(datePickerFormatter) ? 2048 : 1024;
                }
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i2 & 24576) == 0) {
                    companion = modifier;
                    i4 |= startRestartGroup.changed(companion) ? 16384 : 8192;
                    if ((i3 & 32) == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        obj2 = this;
                        i4 |= startRestartGroup.changed(obj2) ? 131072 : 65536;
                        if ((74899 & i4) == 74898 || !startRestartGroup.getSkipping()) {
                            if (i6 != 0) {
                                companion = Modifier.Companion;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1611069472, i4, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:366)");
                            }
                            Strings.Companion companion2 = Strings.Companion;
                            final String m2779getString2EP1pXo = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_date_range_picker_start_headline), startRestartGroup, 0);
                            Strings.Companion companion3 = Strings.Companion;
                            final String m2779getString2EP1pXo2 = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_date_range_picker_end_headline), startRestartGroup, 0);
                            int i7 = (i4 >> 15) & 14;
                            Long l4 = obj;
                            int i8 = i5;
                            Modifier modifier3 = companion;
                            obj2.m1842DateRangePickerHeadline0YIUgSQ(l3, l4, i8, datePickerFormatter, modifier3, m2779getString2EP1pXo, m2779getString2EP1pXo2, ComposableLambdaKt.rememberComposableLambda(482821121, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i9) {
                                    ComposerKt.sourceInformation(composer2, "C377@17396L26:DateRangePicker.kt#uh7d8r");
                                    if ((i9 & 3) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(482821121, i9, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline.<anonymous> (DateRangePicker.kt:377)");
                                    }
                                    TextKt.m2497Text4IGK_g(m2779getString2EP1pXo, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1522669758, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i9) {
                                    ComposerKt.sourceInformation(composer2, "C378@17461L24:DateRangePicker.kt#uh7d8r");
                                    if ((i9 & 3) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1522669758, i9, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline.<anonymous> (DateRangePicker.kt:378)");
                                    }
                                    TextKt.m2497Text4IGK_g(m2779getString2EP1pXo2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), ComposableSingletons$DateRangePickerKt.INSTANCE.m1768getLambda1$material3_release(), startRestartGroup, (i4 & 14) | 918552576 | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4), i7);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = companion;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$3
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i9) {
                                    DateRangePickerDefaults.this.m1844DateRangePickerHeadlinev84Udv0(l, l2, i, datePickerFormatter, modifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    obj2 = this;
                    if ((74899 & i4) == 74898) {
                    }
                    if (i6 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Strings.Companion companion22 = Strings.Companion;
                    final String m2779getString2EP1pXo3 = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_date_range_picker_start_headline), startRestartGroup, 0);
                    Strings.Companion companion32 = Strings.Companion;
                    final String m2779getString2EP1pXo22 = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_date_range_picker_end_headline), startRestartGroup, 0);
                    int i72 = (i4 >> 15) & 14;
                    Long l42 = obj;
                    int i82 = i5;
                    Modifier modifier32 = companion;
                    obj2.m1842DateRangePickerHeadline0YIUgSQ(l3, l42, i82, datePickerFormatter, modifier32, m2779getString2EP1pXo3, m2779getString2EP1pXo22, ComposableLambdaKt.rememberComposableLambda(482821121, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i9) {
                            ComposerKt.sourceInformation(composer2, "C377@17396L26:DateRangePicker.kt#uh7d8r");
                            if ((i9 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(482821121, i9, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline.<anonymous> (DateRangePicker.kt:377)");
                            }
                            TextKt.m2497Text4IGK_g(m2779getString2EP1pXo3, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1522669758, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i9) {
                            ComposerKt.sourceInformation(composer2, "C378@17461L24:DateRangePicker.kt#uh7d8r");
                            if ((i9 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1522669758, i9, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline.<anonymous> (DateRangePicker.kt:378)");
                            }
                            TextKt.m2497Text4IGK_g(m2779getString2EP1pXo22, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), ComposableSingletons$DateRangePickerKt.INSTANCE.m1768getLambda1$material3_release(), startRestartGroup, (i4 & 14) | 918552576 | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4), i72);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier2 = modifier32;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                companion = modifier;
                if ((i3 & 32) == 0) {
                }
                obj2 = this;
                if ((74899 & i4) == 74898) {
                }
                if (i6 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                Strings.Companion companion222 = Strings.Companion;
                final String m2779getString2EP1pXo32 = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_date_range_picker_start_headline), startRestartGroup, 0);
                Strings.Companion companion322 = Strings.Companion;
                final String m2779getString2EP1pXo222 = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_date_range_picker_end_headline), startRestartGroup, 0);
                int i722 = (i4 >> 15) & 14;
                Long l422 = obj;
                int i822 = i5;
                Modifier modifier322 = companion;
                obj2.m1842DateRangePickerHeadline0YIUgSQ(l3, l422, i822, datePickerFormatter, modifier322, m2779getString2EP1pXo32, m2779getString2EP1pXo222, ComposableLambdaKt.rememberComposableLambda(482821121, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        ComposerKt.sourceInformation(composer2, "C377@17396L26:DateRangePicker.kt#uh7d8r");
                        if ((i9 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(482821121, i9, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline.<anonymous> (DateRangePicker.kt:377)");
                        }
                        TextKt.m2497Text4IGK_g(m2779getString2EP1pXo32, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1522669758, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        ComposerKt.sourceInformation(composer2, "C378@17461L24:DateRangePicker.kt#uh7d8r");
                        if ((i9 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1522669758, i9, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline.<anonymous> (DateRangePicker.kt:378)");
                        }
                        TextKt.m2497Text4IGK_g(m2779getString2EP1pXo222, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), ComposableSingletons$DateRangePickerKt.INSTANCE.m1768getLambda1$material3_release(), startRestartGroup, (i4 & 14) | 918552576 | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4), i722);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = modifier322;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i5 = i;
            if ((i3 & 8) != 0) {
            }
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            companion = modifier;
            if ((i3 & 32) == 0) {
            }
            obj2 = this;
            if ((74899 & i4) == 74898) {
            }
            if (i6 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Strings.Companion companion2222 = Strings.Companion;
            final String m2779getString2EP1pXo322 = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_date_range_picker_start_headline), startRestartGroup, 0);
            Strings.Companion companion3222 = Strings.Companion;
            final String m2779getString2EP1pXo2222 = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_date_range_picker_end_headline), startRestartGroup, 0);
            int i7222 = (i4 >> 15) & 14;
            Long l4222 = obj;
            int i8222 = i5;
            Modifier modifier3222 = companion;
            obj2.m1842DateRangePickerHeadline0YIUgSQ(l3, l4222, i8222, datePickerFormatter, modifier3222, m2779getString2EP1pXo322, m2779getString2EP1pXo2222, ComposableLambdaKt.rememberComposableLambda(482821121, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i9) {
                    ComposerKt.sourceInformation(composer2, "C377@17396L26:DateRangePicker.kt#uh7d8r");
                    if ((i9 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(482821121, i9, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline.<anonymous> (DateRangePicker.kt:377)");
                    }
                    TextKt.m2497Text4IGK_g(m2779getString2EP1pXo322, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1522669758, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i9) {
                    ComposerKt.sourceInformation(composer2, "C378@17461L24:DateRangePicker.kt#uh7d8r");
                    if ((i9 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1522669758, i9, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline.<anonymous> (DateRangePicker.kt:378)");
                    }
                    TextKt.m2497Text4IGK_g(m2779getString2EP1pXo2222, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), ComposableSingletons$DateRangePickerKt.INSTANCE.m1768getLambda1$material3_release(), startRestartGroup, (i4 & 14) | 918552576 | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4), i7222);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier3222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = l2;
        if ((i3 & 4) == 0) {
        }
        i5 = i;
        if ((i3 & 8) != 0) {
        }
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        companion = modifier;
        if ((i3 & 32) == 0) {
        }
        obj2 = this;
        if ((74899 & i4) == 74898) {
        }
        if (i6 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Strings.Companion companion22222 = Strings.Companion;
        final String m2779getString2EP1pXo3222 = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_date_range_picker_start_headline), startRestartGroup, 0);
        Strings.Companion companion32222 = Strings.Companion;
        final String m2779getString2EP1pXo22222 = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_date_range_picker_end_headline), startRestartGroup, 0);
        int i72222 = (i4 >> 15) & 14;
        Long l42222 = obj;
        int i82222 = i5;
        Modifier modifier32222 = companion;
        obj2.m1842DateRangePickerHeadline0YIUgSQ(l3, l42222, i82222, datePickerFormatter, modifier32222, m2779getString2EP1pXo3222, m2779getString2EP1pXo22222, ComposableLambdaKt.rememberComposableLambda(482821121, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i9) {
                ComposerKt.sourceInformation(composer2, "C377@17396L26:DateRangePicker.kt#uh7d8r");
                if ((i9 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(482821121, i9, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline.<anonymous> (DateRangePicker.kt:377)");
                }
                TextKt.m2497Text4IGK_g(m2779getString2EP1pXo3222, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1522669758, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i9) {
                ComposerKt.sourceInformation(composer2, "C378@17461L24:DateRangePicker.kt#uh7d8r");
                if ((i9 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1522669758, i9, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline.<anonymous> (DateRangePicker.kt:378)");
                }
                TextKt.m2497Text4IGK_g(m2779getString2EP1pXo22222, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), ComposableSingletons$DateRangePickerKt.INSTANCE.m1768getLambda1$material3_release(), startRestartGroup, (i4 & 14) | 918552576 | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4), i72222);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier32222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: DateRangePickerHeadline-0YIUgSQ  reason: not valid java name */
    public final void m1842DateRangePickerHeadline0YIUgSQ(Long l, final Long l2, final int i, final DatePickerFormatter datePickerFormatter, final Modifier modifier, final String str, final String str2, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, final int i2, final int i3) {
        int i4;
        Composer composer2;
        Long l3;
        String str3;
        Composer startRestartGroup = composer.startRestartGroup(-820363420);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateRangePickerHeadline)P(7,6,2:c#material3.DisplayMode!1,5,9,4,8,3)420@19570L15,456@21103L168,454@21029L748:DateRangePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(l) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changed(l2) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= (i2 & 4096) == 0 ? startRestartGroup.changed(datePickerFormatter) : startRestartGroup.changedInstance(datePickerFormatter) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i4 |= startRestartGroup.changed(str) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            i4 |= startRestartGroup.changed(str2) ? 1048576 : 524288;
        }
        if ((12582912 & i2) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ((100663296 & i2) == 0) {
            i4 |= startRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
        }
        if ((805306368 & i2) == 0) {
            i4 |= startRestartGroup.changedInstance(function23) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((306783379 & i4) != 306783378 || (i3 & 1) != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-820363420, i4, i3, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:419)");
            }
            Locale defaultLocale = CalendarLocale_androidKt.defaultLocale(startRestartGroup, 0);
            int i5 = i4;
            composer2 = startRestartGroup;
            String formatDate$default = DatePickerFormatter.formatDate$default(datePickerFormatter, l, defaultLocale, false, 4, null);
            l3 = l;
            String formatDate$default2 = DatePickerFormatter.formatDate$default(datePickerFormatter, l2, defaultLocale, false, 4, null);
            String formatDate = datePickerFormatter.formatDate(l3, defaultLocale, true);
            composer2.startReplaceGroup(1063158288);
            String str4 = "";
            ComposerKt.sourceInformation(composer2, "");
            if (formatDate != null) {
                str3 = formatDate$default2;
            } else if (DisplayMode.m1868equalsimpl0(i, DisplayMode.Companion.m1873getPickerjFl4v0())) {
                composer2.startReplaceGroup(1063166242);
                ComposerKt.sourceInformation(composer2, "434@20163L51");
                Strings.Companion companion = Strings.Companion;
                str3 = formatDate$default2;
                formatDate = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_date_picker_no_selection_description), composer2, 0);
                composer2.endReplaceGroup();
            } else {
                str3 = formatDate$default2;
                if (DisplayMode.m1868equalsimpl0(i, DisplayMode.Companion.m1872getInputjFl4v0())) {
                    composer2.startReplaceGroup(1063169213);
                    ComposerKt.sourceInformation(composer2, "435@20256L46");
                    Strings.Companion companion2 = Strings.Companion;
                    String m2779getString2EP1pXo = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_date_input_no_input_description), composer2, 0);
                    composer2.endReplaceGroup();
                    formatDate = m2779getString2EP1pXo;
                } else {
                    composer2.startReplaceGroup(-1401419729);
                    composer2.endReplaceGroup();
                    formatDate = "";
                }
            }
            composer2.endReplaceGroup();
            String formatDate2 = datePickerFormatter.formatDate(l2, defaultLocale, true);
            composer2.startReplaceGroup(1063174382);
            ComposerKt.sourceInformation(composer2, "");
            if (formatDate2 != null) {
                str4 = formatDate2;
            } else if (DisplayMode.m1868equalsimpl0(i, DisplayMode.Companion.m1873getPickerjFl4v0())) {
                composer2.startReplaceGroup(1063182274);
                ComposerKt.sourceInformation(composer2, "446@20664L51");
                Strings.Companion companion3 = Strings.Companion;
                str4 = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_date_picker_no_selection_description), composer2, 0);
                composer2.endReplaceGroup();
            } else if (DisplayMode.m1868equalsimpl0(i, DisplayMode.Companion.m1872getInputjFl4v0())) {
                composer2.startReplaceGroup(1063185245);
                ComposerKt.sourceInformation(composer2, "447@20757L46");
                Strings.Companion companion4 = Strings.Companion;
                str4 = Strings_androidKt.m2779getString2EP1pXo(Strings.m2709constructorimpl(R.string.m3c_date_input_no_input_description), composer2, 0);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1400922737);
                composer2.endReplaceGroup();
            }
            composer2.endReplaceGroup();
            final String str5 = str + ": " + formatDate;
            final String str6 = str2 + ": " + str4;
            ComposerKt.sourceInformationMarkerStart(composer2, 1063196439, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean changed = composer2.changed(str5) | composer2.changed(str6);
            Object rememberedValue = composer2.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$4$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.m5929setLiveRegionhR3wRGc(semanticsPropertyReceiver, LiveRegionMode.Companion.m5903getPolite0phEisY());
                        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str5 + ", " + str6);
                    }
                };
                composer2.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(modifier, (Function1) rememberedValue);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.HorizontalOrVertical m619spacedBy0680j_4 = Arrangement.INSTANCE.m619spacedBy0680j_4(Dp.m6684constructorimpl(4));
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m619spacedBy0680j_4, centerVertically, composer2, 54);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, clearAndSetSemantics);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer m3520constructorimpl = Updater.m3520constructorimpl(composer2);
            Updater.m3527setimpl(m3520constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 303513083, "C468@21589L16:DateRangePicker.kt#uh7d8r");
            if (formatDate$default != null) {
                composer2.startReplaceGroup(303536053);
                ComposerKt.sourceInformation(composer2, "464@21471L31");
                TextKt.m2497Text4IGK_g(formatDate$default, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(303604222);
                ComposerKt.sourceInformation(composer2, "466@21540L22");
                function2.invoke(composer2, Integer.valueOf((i5 >> 21) & 14));
                composer2.endReplaceGroup();
            }
            function23.invoke(composer2, Integer.valueOf((i5 >> 27) & 14));
            if (str3 != null) {
                composer2.startReplaceGroup(303729431);
                ComposerKt.sourceInformation(composer2, "470@21666L29");
                TextKt.m2497Text4IGK_g(str3, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(303795616);
                ComposerKt.sourceInformation(composer2, "472@21733L20");
                function22.invoke(composer2, Integer.valueOf((i5 >> 24) & 14));
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            l3 = l;
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Long l4 = l3;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$6
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

                public final void invoke(Composer composer3, int i6) {
                    DateRangePickerDefaults.this.m1842DateRangePickerHeadline0YIUgSQ(l4, l2, i, datePickerFormatter, modifier, str, str2, function2, function22, function23, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
                }
            });
        }
    }
}
