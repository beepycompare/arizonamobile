package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.DialogTokens;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DatePickerDialog.android.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u009a\u0001\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00070\u0017¢\u0006\u0002\b\u000b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"DialogButtonsCrossAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "DialogButtonsMainAxisSpacing", "DialogButtonsPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "shape", "Landroidx/compose/ui/graphics/Shape;", "tonalElevation", "colors", "Landroidx/compose/material3/DatePickerColors;", "properties", "Landroidx/compose/ui/window/DialogProperties;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "DatePickerDialog-GmEhDVc", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;FLandroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DatePickerDialog_androidKt {
    private static final float DialogButtonsCrossAxisSpacing = Dp.m6684constructorimpl(12);
    private static final float DialogButtonsMainAxisSpacing;
    private static final PaddingValues DialogButtonsPadding;

    /* JADX WARN: Removed duplicated region for block: B:102:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fe  */
    /* renamed from: DatePickerDialog-GmEhDVc  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1828DatePickerDialogGmEhDVc(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, float f, DatePickerColors datePickerColors, DialogProperties dialogProperties, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Modifier.Companion companion;
        int i5;
        Object obj;
        Object obj2;
        int i6;
        float f2;
        final DatePickerColors datePickerColors2;
        int i7;
        DialogProperties dialogProperties2;
        final DialogProperties dialogProperties3;
        final float f3;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final Modifier modifier2;
        Composer composer2;
        final Shape shape2;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-36517340);
        ComposerKt.sourceInformation(startRestartGroup, "C(DatePickerDialog)P(5,1,4,3,7,8:c#ui.unit.Dp!1,6)71@3518L5,73@3635L8,81@3937L1615,77@3787L1765:DatePickerDialog.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                companion = modifier;
                i3 |= startRestartGroup.changed(companion) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    obj = function22;
                    i3 |= startRestartGroup.changedInstance(obj) ? 2048 : 1024;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            obj2 = shape;
                            if (startRestartGroup.changed(obj2)) {
                                i9 = 16384;
                                i3 |= i9;
                            }
                        } else {
                            obj2 = shape;
                        }
                        i9 = 8192;
                        i3 |= i9;
                    } else {
                        obj2 = shape;
                    }
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((196608 & i) == 0) {
                        f2 = f;
                        i3 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                        if ((1572864 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                datePickerColors2 = datePickerColors;
                                if (startRestartGroup.changed(datePickerColors2)) {
                                    i8 = 1048576;
                                    i3 |= i8;
                                }
                            } else {
                                datePickerColors2 = datePickerColors;
                            }
                            i8 = 524288;
                            i3 |= i8;
                        } else {
                            datePickerColors2 = datePickerColors;
                        }
                        i7 = i2 & 128;
                        if (i7 != 0) {
                            i3 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i3 |= startRestartGroup.changed(dialogProperties) ? 8388608 : 4194304;
                        }
                        if ((i2 & 256) != 0) {
                            i3 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i3 |= startRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
                            if ((i3 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i4 != 0) {
                                        companion = Modifier.Companion;
                                    }
                                    if (i5 != 0) {
                                        obj = null;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                        obj2 = DatePickerDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                    }
                                    if (i6 != 0) {
                                        f2 = DatePickerDefaults.INSTANCE.m1827getTonalElevationD9Ej5fM();
                                    }
                                    if ((i2 & 64) != 0) {
                                        i3 &= -3670017;
                                        datePickerColors2 = DatePickerDefaults.INSTANCE.colors(startRestartGroup, 6);
                                    }
                                    if (i7 != 0) {
                                        dialogProperties2 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                                        Modifier modifier3 = companion;
                                        final Function2<? super Composer, ? super Integer, Unit> function24 = obj;
                                        final float f4 = f2;
                                        final Shape shape3 = obj2;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:76)");
                                        }
                                        AlertDialogKt.BasicAlertDialog(function0, SizeKt.wrapContentHeight$default(modifier3, null, false, 3, null), dialogProperties2, ComposableLambdaKt.rememberComposableLambda(-10625622, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1
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

                                            public final void invoke(Composer composer3, int i10) {
                                                ComposerKt.sourceInformation(composer3, "C89@4257L1289,82@3947L1599:DatePickerDialog.android.kt#uh7d8r");
                                                if ((i10 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-10625622, i10, -1, "androidx.compose.material3.DatePickerDialog.<anonymous> (DatePickerDialog.android.kt:82)");
                                                    }
                                                    Modifier m773heightInVpY3zN4$default = SizeKt.m773heightInVpY3zN4$default(SizeKt.m782requiredWidth3ABfNKs(Modifier.Companion, DatePickerModalTokens.INSTANCE.m2945getContainerWidthD9Ej5fM()), 0.0f, DatePickerModalTokens.INSTANCE.m2944getContainerHeightD9Ej5fM(), 1, null);
                                                    Shape shape4 = Shape.this;
                                                    long m1800getContainerColor0d7_KjU = datePickerColors2.m1800getContainerColor0d7_KjU();
                                                    float f5 = f4;
                                                    final Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                                    final Function2<Composer, Integer, Unit> function25 = function24;
                                                    final Function2<Composer, Integer, Unit> function26 = function2;
                                                    SurfaceKt.m2347SurfaceT9BRK9s(m773heightInVpY3zN4$default, shape4, m1800getContainerColor0d7_KjU, 0L, f5, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1706202235, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1.1
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

                                                        public final void invoke(Composer composer4, int i11) {
                                                            PaddingValues paddingValues;
                                                            ComposerKt.sourceInformation(composer4, "C90@4271L1265:DatePickerDialog.android.kt#uh7d8r");
                                                            if ((i11 & 3) != 2 || !composer4.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-1706202235, i11, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous> (DatePickerDialog.android.kt:90)");
                                                                }
                                                                Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                                                final Function2<Composer, Integer, Unit> function27 = function25;
                                                                final Function2<Composer, Integer, Unit> function28 = function26;
                                                                ComposerKt.sourceInformationMarkerStart(composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.Companion.getStart(), composer4, 6);
                                                                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, Modifier.Companion);
                                                                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                                                ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                                if (!(composer4.getApplier() instanceof Applier)) {
                                                                    ComposablesKt.invalidApplier();
                                                                }
                                                                composer4.startReusableNode();
                                                                if (composer4.getInserting()) {
                                                                    composer4.createNode(constructor);
                                                                } else {
                                                                    composer4.useNode();
                                                                }
                                                                Composer m3520constructorimpl = Updater.m3520constructorimpl(composer4);
                                                                Updater.m3527setimpl(m3520constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                                if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                                }
                                                                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                                ComposerKt.sourceInformationMarkerStart(composer4, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                                                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                                                ComposerKt.sourceInformationMarkerStart(composer4, -2140243970, "C96@4721L64,98@4829L693:DatePickerDialog.android.kt#uh7d8r");
                                                                Modifier weight = columnScopeInstance.weight(Modifier.Companion, 1.0f, false);
                                                                ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                                CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                                                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer4, weight);
                                                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                                                                ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                                if (!(composer4.getApplier() instanceof Applier)) {
                                                                    ComposablesKt.invalidApplier();
                                                                }
                                                                composer4.startReusableNode();
                                                                if (composer4.getInserting()) {
                                                                    composer4.createNode(constructor2);
                                                                } else {
                                                                    composer4.useNode();
                                                                }
                                                                Composer m3520constructorimpl2 = Updater.m3520constructorimpl(composer4);
                                                                Updater.m3527setimpl(m3520constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                                Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                                if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                                    m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                                    m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                                }
                                                                Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                                                                ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                ComposerKt.sourceInformationMarkerStart(composer4, 1276701771, "C96@4774L9:DatePickerDialog.android.kt#uh7d8r");
                                                                function33.invoke(columnScopeInstance, composer4, 6);
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                composer4.endNode();
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                Modifier align = columnScopeInstance.align(Modifier.Companion, Alignment.Companion.getEnd());
                                                                paddingValues = DatePickerDialog_androidKt.DialogButtonsPadding;
                                                                Modifier padding = PaddingKt.padding(align, paddingValues);
                                                                ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                                CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                                                                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer4, padding);
                                                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                                                                ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                                if (!(composer4.getApplier() instanceof Applier)) {
                                                                    ComposablesKt.invalidApplier();
                                                                }
                                                                composer4.startReusableNode();
                                                                if (composer4.getInserting()) {
                                                                    composer4.createNode(constructor3);
                                                                } else {
                                                                    composer4.useNode();
                                                                }
                                                                Composer m3520constructorimpl3 = Updater.m3520constructorimpl(composer4);
                                                                Updater.m3527setimpl(m3520constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                                Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                                if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                                                    m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                                    m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                                                }
                                                                Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                                                                ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                                                ComposerKt.sourceInformationMarkerStart(composer4, 1276882687, "C100@5030L5,101@5106L5,102@5134L370,99@4927L577:DatePickerDialog.android.kt#uh7d8r");
                                                                ProvideContentColorTextStyleKt.m2707ProvideContentColorTextStyle3JVO9M(ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer4, 6), TypographyKt.getValue(DialogTokens.INSTANCE.getActionLabelTextFont(), composer4, 6), ComposableLambdaKt.rememberComposableLambda(642347978, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$2$1
                                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                    {
                                                                        super(2);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function2
                                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                                        invoke(composer5, num.intValue());
                                                                        return Unit.INSTANCE;
                                                                    }

                                                                    public final void invoke(Composer composer5, int i12) {
                                                                        float f6;
                                                                        float f7;
                                                                        ComposerKt.sourceInformation(composer5, "C106@5359L123,103@5160L322:DatePickerDialog.android.kt#uh7d8r");
                                                                        if ((i12 & 3) != 2 || !composer5.getSkipping()) {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(642347978, i12, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:103)");
                                                                            }
                                                                            f6 = DatePickerDialog_androidKt.DialogButtonsMainAxisSpacing;
                                                                            f7 = DatePickerDialog_androidKt.DialogButtonsCrossAxisSpacing;
                                                                            final Function2<Composer, Integer, Unit> function29 = function27;
                                                                            final Function2<Composer, Integer, Unit> function210 = function28;
                                                                            AlertDialogKt.m1560AlertDialogFlowRowixp7dh8(f6, f7, ComposableLambdaKt.rememberComposableLambda(1241707635, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$2$1.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                                {
                                                                                    super(2);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function2
                                                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                                                    invoke(composer6, num.intValue());
                                                                                    return Unit.INSTANCE;
                                                                                }

                                                                                public final void invoke(Composer composer6, int i13) {
                                                                                    ComposerKt.sourceInformation(composer6, "C108@5441L15:DatePickerDialog.android.kt#uh7d8r");
                                                                                    if ((i13 & 3) != 2 || !composer6.getSkipping()) {
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventStart(1241707635, i13, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:107)");
                                                                                        }
                                                                                        Function2<Composer, Integer, Unit> function211 = function29;
                                                                                        composer6.startReplaceGroup(-779485335);
                                                                                        ComposerKt.sourceInformation(composer6, "107@5404L8");
                                                                                        if (function211 != null) {
                                                                                            function211.invoke(composer6, 0);
                                                                                            Unit unit = Unit.INSTANCE;
                                                                                        }
                                                                                        composer6.endReplaceGroup();
                                                                                        function210.invoke(composer6, 0);
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventEnd();
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    composer6.skipToGroupEnd();
                                                                                }
                                                                            }, composer5, 54), composer5, 438);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                                return;
                                                                            }
                                                                            return;
                                                                        }
                                                                        composer5.skipToGroupEnd();
                                                                    }
                                                                }, composer4, 54), composer4, RendererCapabilities.DECODER_SUPPORT_MASK);
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                composer4.endNode();
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                composer4.endNode();
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer4.skipToGroupEnd();
                                                        }
                                                    }, composer3, 54), composer3, 12582918, 104);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }, startRestartGroup, 54), startRestartGroup, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        dialogProperties3 = dialogProperties2;
                                        f3 = f4;
                                        function23 = function24;
                                        modifier2 = modifier3;
                                        composer2 = startRestartGroup;
                                        shape2 = shape3;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i3 &= -3670017;
                                    }
                                }
                                dialogProperties2 = dialogProperties;
                                Modifier modifier32 = companion;
                                final Function2<? super Composer, ? super Integer, Unit> function242 = obj;
                                final float f42 = f2;
                                final Shape shape32 = obj2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                AlertDialogKt.BasicAlertDialog(function0, SizeKt.wrapContentHeight$default(modifier32, null, false, 3, null), dialogProperties2, ComposableLambdaKt.rememberComposableLambda(-10625622, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1
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

                                    public final void invoke(Composer composer3, int i10) {
                                        ComposerKt.sourceInformation(composer3, "C89@4257L1289,82@3947L1599:DatePickerDialog.android.kt#uh7d8r");
                                        if ((i10 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-10625622, i10, -1, "androidx.compose.material3.DatePickerDialog.<anonymous> (DatePickerDialog.android.kt:82)");
                                            }
                                            Modifier m773heightInVpY3zN4$default = SizeKt.m773heightInVpY3zN4$default(SizeKt.m782requiredWidth3ABfNKs(Modifier.Companion, DatePickerModalTokens.INSTANCE.m2945getContainerWidthD9Ej5fM()), 0.0f, DatePickerModalTokens.INSTANCE.m2944getContainerHeightD9Ej5fM(), 1, null);
                                            Shape shape4 = Shape.this;
                                            long m1800getContainerColor0d7_KjU = datePickerColors2.m1800getContainerColor0d7_KjU();
                                            float f5 = f42;
                                            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                            final Function2<? super Composer, ? super Integer, Unit> function25 = function242;
                                            final Function2<? super Composer, ? super Integer, Unit> function26 = function2;
                                            SurfaceKt.m2347SurfaceT9BRK9s(m773heightInVpY3zN4$default, shape4, m1800getContainerColor0d7_KjU, 0L, f5, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1706202235, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1.1
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

                                                public final void invoke(Composer composer4, int i11) {
                                                    PaddingValues paddingValues;
                                                    ComposerKt.sourceInformation(composer4, "C90@4271L1265:DatePickerDialog.android.kt#uh7d8r");
                                                    if ((i11 & 3) != 2 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1706202235, i11, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous> (DatePickerDialog.android.kt:90)");
                                                        }
                                                        Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                                        final Function2<? super Composer, ? super Integer, Unit> function27 = function25;
                                                        final Function2<? super Composer, ? super Integer, Unit> function28 = function26;
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.Companion.getStart(), composer4, 6);
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, Modifier.Companion);
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                        if (!(composer4.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer4.startReusableNode();
                                                        if (composer4.getInserting()) {
                                                            composer4.createNode(constructor);
                                                        } else {
                                                            composer4.useNode();
                                                        }
                                                        Composer m3520constructorimpl = Updater.m3520constructorimpl(composer4);
                                                        Updater.m3527setimpl(m3520constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                        Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                        if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                            m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                            m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                        }
                                                        Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                                                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -2140243970, "C96@4721L64,98@4829L693:DatePickerDialog.android.kt#uh7d8r");
                                                        Modifier weight = columnScopeInstance.weight(Modifier.Companion, 1.0f, false);
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                        CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer4, weight);
                                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                        if (!(composer4.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer4.startReusableNode();
                                                        if (composer4.getInserting()) {
                                                            composer4.createNode(constructor2);
                                                        } else {
                                                            composer4.useNode();
                                                        }
                                                        Composer m3520constructorimpl2 = Updater.m3520constructorimpl(composer4);
                                                        Updater.m3527setimpl(m3520constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                        Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                        if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                            m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                            m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                        }
                                                        Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 1276701771, "C96@4774L9:DatePickerDialog.android.kt#uh7d8r");
                                                        function33.invoke(columnScopeInstance, composer4, 6);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        composer4.endNode();
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        Modifier align = columnScopeInstance.align(Modifier.Companion, Alignment.Companion.getEnd());
                                                        paddingValues = DatePickerDialog_androidKt.DialogButtonsPadding;
                                                        Modifier padding = PaddingKt.padding(align, paddingValues);
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                        CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                                                        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer4, padding);
                                                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                        if (!(composer4.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer4.startReusableNode();
                                                        if (composer4.getInserting()) {
                                                            composer4.createNode(constructor3);
                                                        } else {
                                                            composer4.useNode();
                                                        }
                                                        Composer m3520constructorimpl3 = Updater.m3520constructorimpl(composer4);
                                                        Updater.m3527setimpl(m3520constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                        Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                        if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                                            m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                            m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                                        }
                                                        Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 1276882687, "C100@5030L5,101@5106L5,102@5134L370,99@4927L577:DatePickerDialog.android.kt#uh7d8r");
                                                        ProvideContentColorTextStyleKt.m2707ProvideContentColorTextStyle3JVO9M(ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer4, 6), TypographyKt.getValue(DialogTokens.INSTANCE.getActionLabelTextFont(), composer4, 6), ComposableLambdaKt.rememberComposableLambda(642347978, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$2$1
                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                                invoke(composer5, num.intValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            public final void invoke(Composer composer5, int i12) {
                                                                float f6;
                                                                float f7;
                                                                ComposerKt.sourceInformation(composer5, "C106@5359L123,103@5160L322:DatePickerDialog.android.kt#uh7d8r");
                                                                if ((i12 & 3) != 2 || !composer5.getSkipping()) {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(642347978, i12, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:103)");
                                                                    }
                                                                    f6 = DatePickerDialog_androidKt.DialogButtonsMainAxisSpacing;
                                                                    f7 = DatePickerDialog_androidKt.DialogButtonsCrossAxisSpacing;
                                                                    final Function2<? super Composer, ? super Integer, Unit> function29 = function27;
                                                                    final Function2<? super Composer, ? super Integer, Unit> function210 = function28;
                                                                    AlertDialogKt.m1560AlertDialogFlowRowixp7dh8(f6, f7, ComposableLambdaKt.rememberComposableLambda(1241707635, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$2$1.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        /* JADX WARN: Multi-variable type inference failed */
                                                                        {
                                                                            super(2);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function2
                                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                                            invoke(composer6, num.intValue());
                                                                            return Unit.INSTANCE;
                                                                        }

                                                                        public final void invoke(Composer composer6, int i13) {
                                                                            ComposerKt.sourceInformation(composer6, "C108@5441L15:DatePickerDialog.android.kt#uh7d8r");
                                                                            if ((i13 & 3) != 2 || !composer6.getSkipping()) {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(1241707635, i13, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:107)");
                                                                                }
                                                                                Function2<Composer, Integer, Unit> function211 = function29;
                                                                                composer6.startReplaceGroup(-779485335);
                                                                                ComposerKt.sourceInformation(composer6, "107@5404L8");
                                                                                if (function211 != null) {
                                                                                    function211.invoke(composer6, 0);
                                                                                    Unit unit = Unit.INSTANCE;
                                                                                }
                                                                                composer6.endReplaceGroup();
                                                                                function210.invoke(composer6, 0);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            }
                                                                            composer6.skipToGroupEnd();
                                                                        }
                                                                    }, composer5, 54), composer5, 438);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                composer5.skipToGroupEnd();
                                                            }
                                                        }, composer4, 54), composer4, RendererCapabilities.DECODER_SUPPORT_MASK);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        composer4.endNode();
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        composer4.endNode();
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            }, composer3, 54), composer3, 12582918, 104);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, startRestartGroup, 54), startRestartGroup, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                dialogProperties3 = dialogProperties2;
                                f3 = f42;
                                function23 = function242;
                                modifier2 = modifier32;
                                composer2 = startRestartGroup;
                                shape2 = shape32;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                composer2 = startRestartGroup;
                                modifier2 = companion;
                                function23 = obj;
                                shape2 = obj2;
                                f3 = f2;
                                dialogProperties3 = dialogProperties;
                            }
                            final DatePickerColors datePickerColors3 = datePickerColors2;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$2
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

                                    public final void invoke(Composer composer3, int i10) {
                                        DatePickerDialog_androidKt.m1828DatePickerDialogGmEhDVc(function0, function2, modifier2, function23, shape2, f3, datePickerColors3, dialogProperties3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i3 & 38347923) == 38347922) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i4 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if ((i2 & 16) != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if ((i2 & 64) != 0) {
                        }
                        if (i7 != 0) {
                        }
                        dialogProperties2 = dialogProperties;
                        Modifier modifier322 = companion;
                        final Function2<? super Composer, ? super Integer, Unit> function2422 = obj;
                        final float f422 = f2;
                        final Shape shape322 = obj2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        AlertDialogKt.BasicAlertDialog(function0, SizeKt.wrapContentHeight$default(modifier322, null, false, 3, null), dialogProperties2, ComposableLambdaKt.rememberComposableLambda(-10625622, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1
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

                            public final void invoke(Composer composer3, int i10) {
                                ComposerKt.sourceInformation(composer3, "C89@4257L1289,82@3947L1599:DatePickerDialog.android.kt#uh7d8r");
                                if ((i10 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-10625622, i10, -1, "androidx.compose.material3.DatePickerDialog.<anonymous> (DatePickerDialog.android.kt:82)");
                                    }
                                    Modifier m773heightInVpY3zN4$default = SizeKt.m773heightInVpY3zN4$default(SizeKt.m782requiredWidth3ABfNKs(Modifier.Companion, DatePickerModalTokens.INSTANCE.m2945getContainerWidthD9Ej5fM()), 0.0f, DatePickerModalTokens.INSTANCE.m2944getContainerHeightD9Ej5fM(), 1, null);
                                    Shape shape4 = Shape.this;
                                    long m1800getContainerColor0d7_KjU = datePickerColors2.m1800getContainerColor0d7_KjU();
                                    float f5 = f422;
                                    final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                    final Function2<? super Composer, ? super Integer, Unit> function25 = function2422;
                                    final Function2<? super Composer, ? super Integer, Unit> function26 = function2;
                                    SurfaceKt.m2347SurfaceT9BRK9s(m773heightInVpY3zN4$default, shape4, m1800getContainerColor0d7_KjU, 0L, f5, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1706202235, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1.1
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

                                        public final void invoke(Composer composer4, int i11) {
                                            PaddingValues paddingValues;
                                            ComposerKt.sourceInformation(composer4, "C90@4271L1265:DatePickerDialog.android.kt#uh7d8r");
                                            if ((i11 & 3) != 2 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1706202235, i11, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous> (DatePickerDialog.android.kt:90)");
                                                }
                                                Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                                final Function2<? super Composer, ? super Integer, Unit> function27 = function25;
                                                final Function2<? super Composer, ? super Integer, Unit> function28 = function26;
                                                ComposerKt.sourceInformationMarkerStart(composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.Companion.getStart(), composer4, 6);
                                                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, Modifier.Companion);
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                                ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                if (!(composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer4.startReusableNode();
                                                if (composer4.getInserting()) {
                                                    composer4.createNode(constructor);
                                                } else {
                                                    composer4.useNode();
                                                }
                                                Composer m3520constructorimpl = Updater.m3520constructorimpl(composer4);
                                                Updater.m3527setimpl(m3520constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                ComposerKt.sourceInformationMarkerStart(composer4, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer4, -2140243970, "C96@4721L64,98@4829L693:DatePickerDialog.android.kt#uh7d8r");
                                                Modifier weight = columnScopeInstance.weight(Modifier.Companion, 1.0f, false);
                                                ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer4, weight);
                                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                                                ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                if (!(composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer4.startReusableNode();
                                                if (composer4.getInserting()) {
                                                    composer4.createNode(constructor2);
                                                } else {
                                                    composer4.useNode();
                                                }
                                                Composer m3520constructorimpl2 = Updater.m3520constructorimpl(composer4);
                                                Updater.m3527setimpl(m3520constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                    m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                    m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                }
                                                Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                                                ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer4, 1276701771, "C96@4774L9:DatePickerDialog.android.kt#uh7d8r");
                                                function33.invoke(columnScopeInstance, composer4, 6);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                composer4.endNode();
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                Modifier align = columnScopeInstance.align(Modifier.Companion, Alignment.Companion.getEnd());
                                                paddingValues = DatePickerDialog_androidKt.DialogButtonsPadding;
                                                Modifier padding = PaddingKt.padding(align, paddingValues);
                                                ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                                                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer4, padding);
                                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                                                ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                if (!(composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer4.startReusableNode();
                                                if (composer4.getInserting()) {
                                                    composer4.createNode(constructor3);
                                                } else {
                                                    composer4.useNode();
                                                }
                                                Composer m3520constructorimpl3 = Updater.m3520constructorimpl(composer4);
                                                Updater.m3527setimpl(m3520constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                                    m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                    m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                                }
                                                Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                                                ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer4, 1276882687, "C100@5030L5,101@5106L5,102@5134L370,99@4927L577:DatePickerDialog.android.kt#uh7d8r");
                                                ProvideContentColorTextStyleKt.m2707ProvideContentColorTextStyle3JVO9M(ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer4, 6), TypographyKt.getValue(DialogTokens.INSTANCE.getActionLabelTextFont(), composer4, 6), ComposableLambdaKt.rememberComposableLambda(642347978, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$2$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                        invoke(composer5, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer5, int i12) {
                                                        float f6;
                                                        float f7;
                                                        ComposerKt.sourceInformation(composer5, "C106@5359L123,103@5160L322:DatePickerDialog.android.kt#uh7d8r");
                                                        if ((i12 & 3) != 2 || !composer5.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(642347978, i12, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:103)");
                                                            }
                                                            f6 = DatePickerDialog_androidKt.DialogButtonsMainAxisSpacing;
                                                            f7 = DatePickerDialog_androidKt.DialogButtonsCrossAxisSpacing;
                                                            final Function2<? super Composer, ? super Integer, Unit> function29 = function27;
                                                            final Function2<? super Composer, ? super Integer, Unit> function210 = function28;
                                                            AlertDialogKt.m1560AlertDialogFlowRowixp7dh8(f6, f7, ComposableLambdaKt.rememberComposableLambda(1241707635, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$2$1.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(2);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function2
                                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                                    invoke(composer6, num.intValue());
                                                                    return Unit.INSTANCE;
                                                                }

                                                                public final void invoke(Composer composer6, int i13) {
                                                                    ComposerKt.sourceInformation(composer6, "C108@5441L15:DatePickerDialog.android.kt#uh7d8r");
                                                                    if ((i13 & 3) != 2 || !composer6.getSkipping()) {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(1241707635, i13, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:107)");
                                                                        }
                                                                        Function2<Composer, Integer, Unit> function211 = function29;
                                                                        composer6.startReplaceGroup(-779485335);
                                                                        ComposerKt.sourceInformation(composer6, "107@5404L8");
                                                                        if (function211 != null) {
                                                                            function211.invoke(composer6, 0);
                                                                            Unit unit = Unit.INSTANCE;
                                                                        }
                                                                        composer6.endReplaceGroup();
                                                                        function210.invoke(composer6, 0);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    composer6.skipToGroupEnd();
                                                                }
                                                            }, composer5, 54), composer5, 438);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer5.skipToGroupEnd();
                                                    }
                                                }, composer4, 54), composer4, RendererCapabilities.DECODER_SUPPORT_MASK);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                composer4.endNode();
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                composer4.endNode();
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }, composer3, 54), composer3, 12582918, 104);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }, startRestartGroup, 54), startRestartGroup, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        dialogProperties3 = dialogProperties2;
                        f3 = f422;
                        function23 = function2422;
                        modifier2 = modifier322;
                        composer2 = startRestartGroup;
                        shape2 = shape322;
                        final DatePickerColors datePickerColors32 = datePickerColors2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    f2 = f;
                    if ((1572864 & i) == 0) {
                    }
                    i7 = i2 & 128;
                    if (i7 != 0) {
                    }
                    if ((i2 & 256) != 0) {
                    }
                    if ((i3 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if (i7 != 0) {
                    }
                    dialogProperties2 = dialogProperties;
                    Modifier modifier3222 = companion;
                    final Function2<? super Composer, ? super Integer, Unit> function24222 = obj;
                    final float f4222 = f2;
                    final Shape shape3222 = obj2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    AlertDialogKt.BasicAlertDialog(function0, SizeKt.wrapContentHeight$default(modifier3222, null, false, 3, null), dialogProperties2, ComposableLambdaKt.rememberComposableLambda(-10625622, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1
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

                        public final void invoke(Composer composer3, int i10) {
                            ComposerKt.sourceInformation(composer3, "C89@4257L1289,82@3947L1599:DatePickerDialog.android.kt#uh7d8r");
                            if ((i10 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-10625622, i10, -1, "androidx.compose.material3.DatePickerDialog.<anonymous> (DatePickerDialog.android.kt:82)");
                                }
                                Modifier m773heightInVpY3zN4$default = SizeKt.m773heightInVpY3zN4$default(SizeKt.m782requiredWidth3ABfNKs(Modifier.Companion, DatePickerModalTokens.INSTANCE.m2945getContainerWidthD9Ej5fM()), 0.0f, DatePickerModalTokens.INSTANCE.m2944getContainerHeightD9Ej5fM(), 1, null);
                                Shape shape4 = Shape.this;
                                long m1800getContainerColor0d7_KjU = datePickerColors2.m1800getContainerColor0d7_KjU();
                                float f5 = f4222;
                                final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                final Function2<? super Composer, ? super Integer, Unit> function25 = function24222;
                                final Function2<? super Composer, ? super Integer, Unit> function26 = function2;
                                SurfaceKt.m2347SurfaceT9BRK9s(m773heightInVpY3zN4$default, shape4, m1800getContainerColor0d7_KjU, 0L, f5, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1706202235, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1.1
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

                                    public final void invoke(Composer composer4, int i11) {
                                        PaddingValues paddingValues;
                                        ComposerKt.sourceInformation(composer4, "C90@4271L1265:DatePickerDialog.android.kt#uh7d8r");
                                        if ((i11 & 3) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1706202235, i11, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous> (DatePickerDialog.android.kt:90)");
                                            }
                                            Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                            final Function2<? super Composer, ? super Integer, Unit> function27 = function25;
                                            final Function2<? super Composer, ? super Integer, Unit> function28 = function26;
                                            ComposerKt.sourceInformationMarkerStart(composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.Companion.getStart(), composer4, 6);
                                            ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, Modifier.Companion);
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                            if (!(composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer4.startReusableNode();
                                            if (composer4.getInserting()) {
                                                composer4.createNode(constructor);
                                            } else {
                                                composer4.useNode();
                                            }
                                            Composer m3520constructorimpl = Updater.m3520constructorimpl(composer4);
                                            Updater.m3527setimpl(m3520constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composer4, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer4, -2140243970, "C96@4721L64,98@4829L693:DatePickerDialog.android.kt#uh7d8r");
                                            Modifier weight = columnScopeInstance.weight(Modifier.Companion, 1.0f, false);
                                            ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                            ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                            CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer4, weight);
                                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                            if (!(composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer4.startReusableNode();
                                            if (composer4.getInserting()) {
                                                composer4.createNode(constructor2);
                                            } else {
                                                composer4.useNode();
                                            }
                                            Composer m3520constructorimpl2 = Updater.m3520constructorimpl(composer4);
                                            Updater.m3527setimpl(m3520constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                            }
                                            Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer4, 1276701771, "C96@4774L9:DatePickerDialog.android.kt#uh7d8r");
                                            function33.invoke(columnScopeInstance, composer4, 6);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            composer4.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            Modifier align = columnScopeInstance.align(Modifier.Companion, Alignment.Companion.getEnd());
                                            paddingValues = DatePickerDialog_androidKt.DialogButtonsPadding;
                                            Modifier padding = PaddingKt.padding(align, paddingValues);
                                            ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                            ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                            CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer4, padding);
                                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                            if (!(composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer4.startReusableNode();
                                            if (composer4.getInserting()) {
                                                composer4.createNode(constructor3);
                                            } else {
                                                composer4.useNode();
                                            }
                                            Composer m3520constructorimpl3 = Updater.m3520constructorimpl(composer4);
                                            Updater.m3527setimpl(m3520constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                                m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                            }
                                            Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer4, 1276882687, "C100@5030L5,101@5106L5,102@5134L370,99@4927L577:DatePickerDialog.android.kt#uh7d8r");
                                            ProvideContentColorTextStyleKt.m2707ProvideContentColorTextStyle3JVO9M(ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer4, 6), TypographyKt.getValue(DialogTokens.INSTANCE.getActionLabelTextFont(), composer4, 6), ComposableLambdaKt.rememberComposableLambda(642347978, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$2$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                    invoke(composer5, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer5, int i12) {
                                                    float f6;
                                                    float f7;
                                                    ComposerKt.sourceInformation(composer5, "C106@5359L123,103@5160L322:DatePickerDialog.android.kt#uh7d8r");
                                                    if ((i12 & 3) != 2 || !composer5.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(642347978, i12, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:103)");
                                                        }
                                                        f6 = DatePickerDialog_androidKt.DialogButtonsMainAxisSpacing;
                                                        f7 = DatePickerDialog_androidKt.DialogButtonsCrossAxisSpacing;
                                                        final Function2<? super Composer, ? super Integer, Unit> function29 = function27;
                                                        final Function2<? super Composer, ? super Integer, Unit> function210 = function28;
                                                        AlertDialogKt.m1560AlertDialogFlowRowixp7dh8(f6, f7, ComposableLambdaKt.rememberComposableLambda(1241707635, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$2$1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                                invoke(composer6, num.intValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            public final void invoke(Composer composer6, int i13) {
                                                                ComposerKt.sourceInformation(composer6, "C108@5441L15:DatePickerDialog.android.kt#uh7d8r");
                                                                if ((i13 & 3) != 2 || !composer6.getSkipping()) {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(1241707635, i13, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:107)");
                                                                    }
                                                                    Function2<Composer, Integer, Unit> function211 = function29;
                                                                    composer6.startReplaceGroup(-779485335);
                                                                    ComposerKt.sourceInformation(composer6, "107@5404L8");
                                                                    if (function211 != null) {
                                                                        function211.invoke(composer6, 0);
                                                                        Unit unit = Unit.INSTANCE;
                                                                    }
                                                                    composer6.endReplaceGroup();
                                                                    function210.invoke(composer6, 0);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                composer6.skipToGroupEnd();
                                                            }
                                                        }, composer5, 54), composer5, 438);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }, composer4, 54), composer4, RendererCapabilities.DECODER_SUPPORT_MASK);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            composer4.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            composer4.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }, composer3, 54), composer3, 12582918, 104);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }, startRestartGroup, 54), startRestartGroup, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    dialogProperties3 = dialogProperties2;
                    f3 = f4222;
                    function23 = function24222;
                    modifier2 = modifier3222;
                    composer2 = startRestartGroup;
                    shape2 = shape3222;
                    final DatePickerColors datePickerColors322 = datePickerColors2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj = function22;
                if ((i & 24576) != 0) {
                }
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                f2 = f;
                if ((1572864 & i) == 0) {
                }
                i7 = i2 & 128;
                if (i7 != 0) {
                }
                if ((i2 & 256) != 0) {
                }
                if ((i3 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if (i6 != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if (i7 != 0) {
                }
                dialogProperties2 = dialogProperties;
                Modifier modifier32222 = companion;
                final Function2<? super Composer, ? super Integer, Unit> function242222 = obj;
                final float f42222 = f2;
                final Shape shape32222 = obj2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                AlertDialogKt.BasicAlertDialog(function0, SizeKt.wrapContentHeight$default(modifier32222, null, false, 3, null), dialogProperties2, ComposableLambdaKt.rememberComposableLambda(-10625622, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1
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

                    public final void invoke(Composer composer3, int i10) {
                        ComposerKt.sourceInformation(composer3, "C89@4257L1289,82@3947L1599:DatePickerDialog.android.kt#uh7d8r");
                        if ((i10 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-10625622, i10, -1, "androidx.compose.material3.DatePickerDialog.<anonymous> (DatePickerDialog.android.kt:82)");
                            }
                            Modifier m773heightInVpY3zN4$default = SizeKt.m773heightInVpY3zN4$default(SizeKt.m782requiredWidth3ABfNKs(Modifier.Companion, DatePickerModalTokens.INSTANCE.m2945getContainerWidthD9Ej5fM()), 0.0f, DatePickerModalTokens.INSTANCE.m2944getContainerHeightD9Ej5fM(), 1, null);
                            Shape shape4 = Shape.this;
                            long m1800getContainerColor0d7_KjU = datePickerColors2.m1800getContainerColor0d7_KjU();
                            float f5 = f42222;
                            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                            final Function2<? super Composer, ? super Integer, Unit> function25 = function242222;
                            final Function2<? super Composer, ? super Integer, Unit> function26 = function2;
                            SurfaceKt.m2347SurfaceT9BRK9s(m773heightInVpY3zN4$default, shape4, m1800getContainerColor0d7_KjU, 0L, f5, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1706202235, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1.1
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

                                public final void invoke(Composer composer4, int i11) {
                                    PaddingValues paddingValues;
                                    ComposerKt.sourceInformation(composer4, "C90@4271L1265:DatePickerDialog.android.kt#uh7d8r");
                                    if ((i11 & 3) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1706202235, i11, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous> (DatePickerDialog.android.kt:90)");
                                        }
                                        Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                        final Function2<? super Composer, ? super Integer, Unit> function27 = function25;
                                        final Function2<? super Composer, ? super Integer, Unit> function28 = function26;
                                        ComposerKt.sourceInformationMarkerStart(composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.Companion.getStart(), composer4, 6);
                                        ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, Modifier.Companion);
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                        ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                        if (!(composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor);
                                        } else {
                                            composer4.useNode();
                                        }
                                        Composer m3520constructorimpl = Updater.m3520constructorimpl(composer4);
                                        Updater.m3527setimpl(m3520constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composer4, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer4, -2140243970, "C96@4721L64,98@4829L693:DatePickerDialog.android.kt#uh7d8r");
                                        Modifier weight = columnScopeInstance.weight(Modifier.Companion, 1.0f, false);
                                        ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                        ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer4, weight);
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                                        ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                        if (!(composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor2);
                                        } else {
                                            composer4.useNode();
                                        }
                                        Composer m3520constructorimpl2 = Updater.m3520constructorimpl(composer4);
                                        Updater.m3527setimpl(m3520constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                            m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                        }
                                        Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer4, 1276701771, "C96@4774L9:DatePickerDialog.android.kt#uh7d8r");
                                        function33.invoke(columnScopeInstance, composer4, 6);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        composer4.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        Modifier align = columnScopeInstance.align(Modifier.Companion, Alignment.Companion.getEnd());
                                        paddingValues = DatePickerDialog_androidKt.DialogButtonsPadding;
                                        Modifier padding = PaddingKt.padding(align, paddingValues);
                                        ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                        ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                                        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer4, padding);
                                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                                        ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                        if (!(composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor3);
                                        } else {
                                            composer4.useNode();
                                        }
                                        Composer m3520constructorimpl3 = Updater.m3520constructorimpl(composer4);
                                        Updater.m3527setimpl(m3520constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                            m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                            m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                        }
                                        Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer4, 1276882687, "C100@5030L5,101@5106L5,102@5134L370,99@4927L577:DatePickerDialog.android.kt#uh7d8r");
                                        ProvideContentColorTextStyleKt.m2707ProvideContentColorTextStyle3JVO9M(ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer4, 6), TypographyKt.getValue(DialogTokens.INSTANCE.getActionLabelTextFont(), composer4, 6), ComposableLambdaKt.rememberComposableLambda(642347978, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$2$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                invoke(composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer5, int i12) {
                                                float f6;
                                                float f7;
                                                ComposerKt.sourceInformation(composer5, "C106@5359L123,103@5160L322:DatePickerDialog.android.kt#uh7d8r");
                                                if ((i12 & 3) != 2 || !composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(642347978, i12, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:103)");
                                                    }
                                                    f6 = DatePickerDialog_androidKt.DialogButtonsMainAxisSpacing;
                                                    f7 = DatePickerDialog_androidKt.DialogButtonsCrossAxisSpacing;
                                                    final Function2<? super Composer, ? super Integer, Unit> function29 = function27;
                                                    final Function2<? super Composer, ? super Integer, Unit> function210 = function28;
                                                    AlertDialogKt.m1560AlertDialogFlowRowixp7dh8(f6, f7, ComposableLambdaKt.rememberComposableLambda(1241707635, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$2$1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                            invoke(composer6, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer6, int i13) {
                                                            ComposerKt.sourceInformation(composer6, "C108@5441L15:DatePickerDialog.android.kt#uh7d8r");
                                                            if ((i13 & 3) != 2 || !composer6.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1241707635, i13, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:107)");
                                                                }
                                                                Function2<Composer, Integer, Unit> function211 = function29;
                                                                composer6.startReplaceGroup(-779485335);
                                                                ComposerKt.sourceInformation(composer6, "107@5404L8");
                                                                if (function211 != null) {
                                                                    function211.invoke(composer6, 0);
                                                                    Unit unit = Unit.INSTANCE;
                                                                }
                                                                composer6.endReplaceGroup();
                                                                function210.invoke(composer6, 0);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer6.skipToGroupEnd();
                                                        }
                                                    }, composer5, 54), composer5, 438);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        }, composer4, 54), composer4, RendererCapabilities.DECODER_SUPPORT_MASK);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        composer4.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        composer4.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }, composer3, 54), composer3, 12582918, 104);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }, startRestartGroup, 54), startRestartGroup, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                dialogProperties3 = dialogProperties2;
                f3 = f42222;
                function23 = function242222;
                modifier2 = modifier32222;
                composer2 = startRestartGroup;
                shape2 = shape32222;
                final DatePickerColors datePickerColors3222 = datePickerColors2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            companion = modifier;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            obj = function22;
            if ((i & 24576) != 0) {
            }
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            f2 = f;
            if ((1572864 & i) == 0) {
            }
            i7 = i2 & 128;
            if (i7 != 0) {
            }
            if ((i2 & 256) != 0) {
            }
            if ((i3 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i6 != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if (i7 != 0) {
            }
            dialogProperties2 = dialogProperties;
            Modifier modifier322222 = companion;
            final Function2<? super Composer, ? super Integer, Unit> function2422222 = obj;
            final float f422222 = f2;
            final Shape shape322222 = obj2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            AlertDialogKt.BasicAlertDialog(function0, SizeKt.wrapContentHeight$default(modifier322222, null, false, 3, null), dialogProperties2, ComposableLambdaKt.rememberComposableLambda(-10625622, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1
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

                public final void invoke(Composer composer3, int i10) {
                    ComposerKt.sourceInformation(composer3, "C89@4257L1289,82@3947L1599:DatePickerDialog.android.kt#uh7d8r");
                    if ((i10 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-10625622, i10, -1, "androidx.compose.material3.DatePickerDialog.<anonymous> (DatePickerDialog.android.kt:82)");
                        }
                        Modifier m773heightInVpY3zN4$default = SizeKt.m773heightInVpY3zN4$default(SizeKt.m782requiredWidth3ABfNKs(Modifier.Companion, DatePickerModalTokens.INSTANCE.m2945getContainerWidthD9Ej5fM()), 0.0f, DatePickerModalTokens.INSTANCE.m2944getContainerHeightD9Ej5fM(), 1, null);
                        Shape shape4 = Shape.this;
                        long m1800getContainerColor0d7_KjU = datePickerColors2.m1800getContainerColor0d7_KjU();
                        float f5 = f422222;
                        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                        final Function2<? super Composer, ? super Integer, Unit> function25 = function2422222;
                        final Function2<? super Composer, ? super Integer, Unit> function26 = function2;
                        SurfaceKt.m2347SurfaceT9BRK9s(m773heightInVpY3zN4$default, shape4, m1800getContainerColor0d7_KjU, 0L, f5, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1706202235, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1.1
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

                            public final void invoke(Composer composer4, int i11) {
                                PaddingValues paddingValues;
                                ComposerKt.sourceInformation(composer4, "C90@4271L1265:DatePickerDialog.android.kt#uh7d8r");
                                if ((i11 & 3) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1706202235, i11, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous> (DatePickerDialog.android.kt:90)");
                                    }
                                    Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                    final Function2<? super Composer, ? super Integer, Unit> function27 = function25;
                                    final Function2<? super Composer, ? super Integer, Unit> function28 = function26;
                                    ComposerKt.sourceInformationMarkerStart(composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.Companion.getStart(), composer4, 6);
                                    ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, Modifier.Companion);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m3520constructorimpl = Updater.m3520constructorimpl(composer4);
                                    Updater.m3527setimpl(m3520constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer4, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer4, -2140243970, "C96@4721L64,98@4829L693:DatePickerDialog.android.kt#uh7d8r");
                                    Modifier weight = columnScopeInstance.weight(Modifier.Companion, 1.0f, false);
                                    ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                    ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer4, weight);
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor2);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m3520constructorimpl2 = Updater.m3520constructorimpl(composer4);
                                    Updater.m3527setimpl(m3520constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer4, 1276701771, "C96@4774L9:DatePickerDialog.android.kt#uh7d8r");
                                    function33.invoke(columnScopeInstance, composer4, 6);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    Modifier align = columnScopeInstance.align(Modifier.Companion, Alignment.Companion.getEnd());
                                    paddingValues = DatePickerDialog_androidKt.DialogButtonsPadding;
                                    Modifier padding = PaddingKt.padding(align, paddingValues);
                                    ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                    MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                    ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer4, padding);
                                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor3);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m3520constructorimpl3 = Updater.m3520constructorimpl(composer4);
                                    Updater.m3527setimpl(m3520constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                        m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                        m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                    }
                                    Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer4, 1276882687, "C100@5030L5,101@5106L5,102@5134L370,99@4927L577:DatePickerDialog.android.kt#uh7d8r");
                                    ProvideContentColorTextStyleKt.m2707ProvideContentColorTextStyle3JVO9M(ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer4, 6), TypographyKt.getValue(DialogTokens.INSTANCE.getActionLabelTextFont(), composer4, 6), ComposableLambdaKt.rememberComposableLambda(642347978, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$2$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                            invoke(composer5, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer5, int i12) {
                                            float f6;
                                            float f7;
                                            ComposerKt.sourceInformation(composer5, "C106@5359L123,103@5160L322:DatePickerDialog.android.kt#uh7d8r");
                                            if ((i12 & 3) != 2 || !composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(642347978, i12, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:103)");
                                                }
                                                f6 = DatePickerDialog_androidKt.DialogButtonsMainAxisSpacing;
                                                f7 = DatePickerDialog_androidKt.DialogButtonsCrossAxisSpacing;
                                                final Function2<? super Composer, ? super Integer, Unit> function29 = function27;
                                                final Function2<? super Composer, ? super Integer, Unit> function210 = function28;
                                                AlertDialogKt.m1560AlertDialogFlowRowixp7dh8(f6, f7, ComposableLambdaKt.rememberComposableLambda(1241707635, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$2$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                        invoke(composer6, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer6, int i13) {
                                                        ComposerKt.sourceInformation(composer6, "C108@5441L15:DatePickerDialog.android.kt#uh7d8r");
                                                        if ((i13 & 3) != 2 || !composer6.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1241707635, i13, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:107)");
                                                            }
                                                            Function2<Composer, Integer, Unit> function211 = function29;
                                                            composer6.startReplaceGroup(-779485335);
                                                            ComposerKt.sourceInformation(composer6, "107@5404L8");
                                                            if (function211 != null) {
                                                                function211.invoke(composer6, 0);
                                                                Unit unit = Unit.INSTANCE;
                                                            }
                                                            composer6.endReplaceGroup();
                                                            function210.invoke(composer6, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer6.skipToGroupEnd();
                                                    }
                                                }, composer5, 54), composer5, 438);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer5.skipToGroupEnd();
                                        }
                                    }, composer4, 54), composer4, RendererCapabilities.DECODER_SUPPORT_MASK);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }, composer3, 54), composer3, 12582918, 104);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, startRestartGroup, 54), startRestartGroup, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            dialogProperties3 = dialogProperties2;
            f3 = f422222;
            function23 = function2422222;
            modifier2 = modifier322222;
            composer2 = startRestartGroup;
            shape2 = shape322222;
            final DatePickerColors datePickerColors32222 = datePickerColors2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        companion = modifier;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        obj = function22;
        if ((i & 24576) != 0) {
        }
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        f2 = f;
        if ((1572864 & i) == 0) {
        }
        i7 = i2 & 128;
        if (i7 != 0) {
        }
        if ((i2 & 256) != 0) {
        }
        if ((i3 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if (i7 != 0) {
        }
        dialogProperties2 = dialogProperties;
        Modifier modifier3222222 = companion;
        final Function2<? super Composer, ? super Integer, Unit> function24222222 = obj;
        final float f4222222 = f2;
        final Shape shape3222222 = obj2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        AlertDialogKt.BasicAlertDialog(function0, SizeKt.wrapContentHeight$default(modifier3222222, null, false, 3, null), dialogProperties2, ComposableLambdaKt.rememberComposableLambda(-10625622, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1
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

            public final void invoke(Composer composer3, int i10) {
                ComposerKt.sourceInformation(composer3, "C89@4257L1289,82@3947L1599:DatePickerDialog.android.kt#uh7d8r");
                if ((i10 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-10625622, i10, -1, "androidx.compose.material3.DatePickerDialog.<anonymous> (DatePickerDialog.android.kt:82)");
                    }
                    Modifier m773heightInVpY3zN4$default = SizeKt.m773heightInVpY3zN4$default(SizeKt.m782requiredWidth3ABfNKs(Modifier.Companion, DatePickerModalTokens.INSTANCE.m2945getContainerWidthD9Ej5fM()), 0.0f, DatePickerModalTokens.INSTANCE.m2944getContainerHeightD9Ej5fM(), 1, null);
                    Shape shape4 = Shape.this;
                    long m1800getContainerColor0d7_KjU = datePickerColors2.m1800getContainerColor0d7_KjU();
                    float f5 = f4222222;
                    final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                    final Function2<? super Composer, ? super Integer, Unit> function25 = function24222222;
                    final Function2<? super Composer, ? super Integer, Unit> function26 = function2;
                    SurfaceKt.m2347SurfaceT9BRK9s(m773heightInVpY3zN4$default, shape4, m1800getContainerColor0d7_KjU, 0L, f5, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1706202235, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1.1
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

                        public final void invoke(Composer composer4, int i11) {
                            PaddingValues paddingValues;
                            ComposerKt.sourceInformation(composer4, "C90@4271L1265:DatePickerDialog.android.kt#uh7d8r");
                            if ((i11 & 3) != 2 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1706202235, i11, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous> (DatePickerDialog.android.kt:90)");
                                }
                                Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                final Function2<? super Composer, ? super Integer, Unit> function27 = function25;
                                final Function2<? super Composer, ? super Integer, Unit> function28 = function26;
                                ComposerKt.sourceInformationMarkerStart(composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.Companion.getStart(), composer4, 6);
                                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, Modifier.Companion);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor);
                                } else {
                                    composer4.useNode();
                                }
                                Composer m3520constructorimpl = Updater.m3520constructorimpl(composer4);
                                Updater.m3527setimpl(m3520constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer4, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer4, -2140243970, "C96@4721L64,98@4829L693:DatePickerDialog.android.kt#uh7d8r");
                                Modifier weight = columnScopeInstance.weight(Modifier.Companion, 1.0f, false);
                                ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer4, weight);
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor2);
                                } else {
                                    composer4.useNode();
                                }
                                Composer m3520constructorimpl2 = Updater.m3520constructorimpl(composer4);
                                Updater.m3527setimpl(m3520constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer4, 1276701771, "C96@4774L9:DatePickerDialog.android.kt#uh7d8r");
                                function33.invoke(columnScopeInstance, composer4, 6);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                Modifier align = columnScopeInstance.align(Modifier.Companion, Alignment.Companion.getEnd());
                                paddingValues = DatePickerDialog_androidKt.DialogButtonsPadding;
                                Modifier padding = PaddingKt.padding(align, paddingValues);
                                ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer4, padding);
                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor3);
                                } else {
                                    composer4.useNode();
                                }
                                Composer m3520constructorimpl3 = Updater.m3520constructorimpl(composer4);
                                Updater.m3527setimpl(m3520constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                    m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                    m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                }
                                Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer4, 1276882687, "C100@5030L5,101@5106L5,102@5134L370,99@4927L577:DatePickerDialog.android.kt#uh7d8r");
                                ProvideContentColorTextStyleKt.m2707ProvideContentColorTextStyle3JVO9M(ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer4, 6), TypographyKt.getValue(DialogTokens.INSTANCE.getActionLabelTextFont(), composer4, 6), ComposableLambdaKt.rememberComposableLambda(642347978, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$2$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                        invoke(composer5, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer5, int i12) {
                                        float f6;
                                        float f7;
                                        ComposerKt.sourceInformation(composer5, "C106@5359L123,103@5160L322:DatePickerDialog.android.kt#uh7d8r");
                                        if ((i12 & 3) != 2 || !composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(642347978, i12, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:103)");
                                            }
                                            f6 = DatePickerDialog_androidKt.DialogButtonsMainAxisSpacing;
                                            f7 = DatePickerDialog_androidKt.DialogButtonsCrossAxisSpacing;
                                            final Function2<? super Composer, ? super Integer, Unit> function29 = function27;
                                            final Function2<? super Composer, ? super Integer, Unit> function210 = function28;
                                            AlertDialogKt.m1560AlertDialogFlowRowixp7dh8(f6, f7, ComposableLambdaKt.rememberComposableLambda(1241707635, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$DatePickerDialog$1$1$1$2$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                    invoke(composer6, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer6, int i13) {
                                                    ComposerKt.sourceInformation(composer6, "C108@5441L15:DatePickerDialog.android.kt#uh7d8r");
                                                    if ((i13 & 3) != 2 || !composer6.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1241707635, i13, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:107)");
                                                        }
                                                        Function2<Composer, Integer, Unit> function211 = function29;
                                                        composer6.startReplaceGroup(-779485335);
                                                        ComposerKt.sourceInformation(composer6, "107@5404L8");
                                                        if (function211 != null) {
                                                            function211.invoke(composer6, 0);
                                                            Unit unit = Unit.INSTANCE;
                                                        }
                                                        composer6.endReplaceGroup();
                                                        function210.invoke(composer6, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer6.skipToGroupEnd();
                                                }
                                            }, composer5, 54), composer5, 438);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer5.skipToGroupEnd();
                                    }
                                }, composer4, 54), composer4, RendererCapabilities.DECODER_SUPPORT_MASK);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer4.skipToGroupEnd();
                        }
                    }, composer3, 54), composer3, 12582918, 104);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }, startRestartGroup, 54), startRestartGroup, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        dialogProperties3 = dialogProperties2;
        f3 = f4222222;
        function23 = function24222222;
        modifier2 = modifier3222222;
        composer2 = startRestartGroup;
        shape2 = shape3222222;
        final DatePickerColors datePickerColors322222 = datePickerColors2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    static {
        float f = 8;
        DialogButtonsPadding = PaddingKt.m735PaddingValuesa9UjIt4$default(0.0f, 0.0f, Dp.m6684constructorimpl(6), Dp.m6684constructorimpl(f), 3, null);
        DialogButtonsMainAxisSpacing = Dp.m6684constructorimpl(f);
    }
}
