package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
/* compiled from: ContextualFlowLayout.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u008e\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f21\u0010\u0010\u001a-\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a\u008e\u0001\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u001d21\u0010\u0010\u001a-\u0012\u0004\u0012\u00020\u001e\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u001f\u001a\u00ad\u0001\u0010 \u001a\u0014\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010'\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010)¢\u0006\u0002\b\u00160(2;\u0010*\u001a7\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110+¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016H\u0001¢\u0006\u0002\u0010-\u001a\u00ad\u0001\u0010.\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010'\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010)¢\u0006\u0002\b\u00160(2;\u0010*\u001a7\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110+¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016H\u0001¢\u0006\u0002\u0010/¨\u00060"}, d2 = {"ContextualFlowRow", "", "itemCount", "", "modifier", "Landroidx/compose/ui/Modifier;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "itemVerticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "maxItemsInEachRow", "maxLines", "overflow", "Landroidx/compose/foundation/layout/ContextualFlowRowOverflow;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function2;", "Landroidx/compose/foundation/layout/ContextualFlowRowScope;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/ContextualFlowRowOverflow;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "ContextualFlowColumn", "itemHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "maxItemsInEachColumn", "Landroidx/compose/foundation/layout/ContextualFlowColumnOverflow;", "Landroidx/compose/foundation/layout/ContextualFlowColumnScope;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/ContextualFlowColumnOverflow;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "contextualRowMeasurementHelper", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "maxItemsInMainAxis", "overflowState", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "overflowComposables", "", "Lkotlin/Function0;", "getComposable", "Landroidx/compose/foundation/layout/FlowLineInfo;", "info", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;ILjava/util/List;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "contextualColumnMeasureHelper", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;ILjava/util/List;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ContextualFlowLayoutKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ContextualFlowColumn$lambda$3(int i, Modifier modifier, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i2, int i3, ContextualFlowColumnOverflow contextualFlowColumnOverflow, Function4 function4, int i4, int i5, Composer composer, int i6) {
        ContextualFlowColumn(i, modifier, vertical, horizontal, horizontal2, i2, i3, contextualFlowColumnOverflow, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ContextualFlowRow$lambda$3(int i, Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i2, int i3, ContextualFlowRowOverflow contextualFlowRowOverflow, Function4 function4, int i4, int i5, Composer composer, int i6) {
        ContextualFlowRow(i, modifier, horizontal, vertical, vertical2, i2, i3, contextualFlowRowOverflow, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:137:0x01ba, code lost:
        if (r6 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L87;
     */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011f  */
    @Deprecated(message = "ContextualFlowLayouts are no longer maintained")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ContextualFlowRow(final int i, Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i2, int i3, ContextualFlowRowOverflow contextualFlowRowOverflow, final Function4<? super ContextualFlowRowScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i4, final int i5) {
        int i6;
        Modifier.Companion companion;
        int i7;
        Object obj;
        int i8;
        int i9;
        Alignment.Vertical vertical3;
        int i10;
        int i11;
        int i12;
        final Arrangement.Vertical vertical4;
        final int i13;
        final ContextualFlowRowOverflow contextualFlowRowOverflow2;
        final Arrangement.Horizontal horizontal2;
        final int i14;
        ScopeUpdateScope endRestartGroup;
        int i15;
        Arrangement.Vertical vertical5;
        ArrayList arrayList;
        Composer startRestartGroup = composer.startRestartGroup(-294153140);
        ComposerKt.sourceInformation(startRestartGroup, "C(ContextualFlowRow)N(itemCount,modifier,horizontalArrangement,verticalArrangement,itemVerticalAlignment,maxItemsInEachRow,maxLines,overflow,content)80@3819L53,82@3926L209,97@4434L336,88@4168L602,107@4775L68:ContextualFlowLayout.kt#2w3rfo");
        if ((i4 & 6) == 0) {
            i6 = (startRestartGroup.changed(i) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i16 = i5 & 2;
        if (i16 != 0) {
            i6 |= 48;
        } else if ((i4 & 48) == 0) {
            Object obj2 = modifier;
            i6 |= startRestartGroup.changed(obj2) ? 32 : 16;
            companion = obj2;
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj = horizontal;
                i6 |= startRestartGroup.changed(obj) ? 256 : 128;
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else if ((i4 & 3072) == 0) {
                    i6 |= startRestartGroup.changed(vertical) ? 2048 : 1024;
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else if ((i4 & 24576) == 0) {
                        Object obj3 = vertical2;
                        i6 |= startRestartGroup.changed(obj3) ? 16384 : 8192;
                        vertical3 = obj3;
                        i10 = i5 & 32;
                        if (i10 != 0) {
                            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i6 |= startRestartGroup.changed(i2) ? 131072 : 65536;
                        }
                        i11 = i5 & 64;
                        if (i11 != 0) {
                            i6 |= 1572864;
                        } else if ((i4 & 1572864) == 0) {
                            i6 |= startRestartGroup.changed(i3) ? 1048576 : 524288;
                        }
                        i12 = i5 & 128;
                        if (i12 != 0) {
                            i6 |= 12582912;
                        } else if ((i4 & 12582912) == 0) {
                            i6 |= startRestartGroup.changed(contextualFlowRowOverflow) ? 8388608 : 4194304;
                        }
                        if ((i4 & 100663296) == 0) {
                            i6 |= startRestartGroup.changedInstance(function4) ? 67108864 : 33554432;
                        }
                        companion = companion;
                        if (!startRestartGroup.shouldExecute((i6 & 38347923) != 38347922, i6 & 1)) {
                            startRestartGroup.skipToGroupEnd();
                            vertical4 = vertical;
                            i13 = i2;
                            contextualFlowRowOverflow2 = contextualFlowRowOverflow;
                            horizontal2 = obj;
                            i14 = i3;
                        } else {
                            if (i16 != 0) {
                                companion = Modifier.Companion;
                            }
                            Arrangement.Horizontal start = i7 != 0 ? Arrangement.INSTANCE.getStart() : obj;
                            if (i8 != 0) {
                                vertical5 = Arrangement.INSTANCE.getTop();
                                i15 = i9;
                            } else {
                                i15 = i9;
                                vertical5 = vertical;
                            }
                            if (i15 != 0) {
                                vertical3 = Alignment.Companion.getTop();
                            }
                            int i17 = i10 != 0 ? Integer.MAX_VALUE : i2;
                            int i18 = i11 != 0 ? Integer.MAX_VALUE : i3;
                            ContextualFlowRowOverflow clip = i12 != 0 ? ContextualFlowRowOverflow.Companion.getClip() : contextualFlowRowOverflow;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-294153140, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:79)");
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 786690945, "CC(remember):ContextualFlowLayout.kt#9igjgp");
                            int i19 = 29360128 & i6;
                            boolean z = i19 == 8388608;
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = clip.createOverflowState$foundation_layout();
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 786694525, "CC(remember):ContextualFlowLayout.kt#9igjgp");
                            boolean z2 = i19 == 8388608;
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!z2) {
                                arrayList = rememberedValue2;
                            }
                            ArrayList arrayList2 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList2);
                            startRestartGroup.updateRememberedValue(arrayList2);
                            arrayList = arrayList2;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i20 = i6 >> 6;
                            SubcomposeLayoutKt.SubcomposeLayout(companion, contextualRowMeasurementHelper(start, vertical5, vertical3, i17, i18, flowLayoutOverflowState, i, (List) arrayList, ComposableLambdaKt.rememberComposableLambda(-1677845586, true, new Function4() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function4
                                public final Object invoke(Object obj4, Object obj5, Object obj6, Object obj7) {
                                    return ContextualFlowLayoutKt.ContextualFlowRow$lambda$2(Function4.this, ((Integer) obj4).intValue(), (FlowLineInfo) obj5, (Composer) obj6, ((Integer) obj7).intValue());
                                }
                            }, startRestartGroup, 54), startRestartGroup, (i20 & 57344) | (i20 & 14) | 100663296 | (i20 & 112) | (i20 & 896) | (i20 & 7168) | ((i6 << 18) & 3670016)), startRestartGroup, (i6 >> 3) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            contextualFlowRowOverflow2 = clip;
                            horizontal2 = start;
                            vertical4 = vertical5;
                            i13 = i17;
                            i14 = i18;
                        }
                        final Modifier modifier2 = companion;
                        final Alignment.Vertical vertical6 = vertical3;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj4, Object obj5) {
                                    return ContextualFlowLayoutKt.ContextualFlowRow$lambda$3(i, modifier2, horizontal2, vertical4, vertical6, i13, i14, contextualFlowRowOverflow2, function4, i4, i5, (Composer) obj4, ((Integer) obj5).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    vertical3 = vertical2;
                    i10 = i5 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i5 & 64;
                    if (i11 != 0) {
                    }
                    i12 = i5 & 128;
                    if (i12 != 0) {
                    }
                    if ((i4 & 100663296) == 0) {
                    }
                    companion = companion;
                    if (!startRestartGroup.shouldExecute((i6 & 38347923) != 38347922, i6 & 1)) {
                    }
                    final Modifier modifier22 = companion;
                    final Alignment.Vertical vertical62 = vertical3;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                vertical3 = vertical2;
                i10 = i5 & 32;
                if (i10 != 0) {
                }
                i11 = i5 & 64;
                if (i11 != 0) {
                }
                i12 = i5 & 128;
                if (i12 != 0) {
                }
                if ((i4 & 100663296) == 0) {
                }
                companion = companion;
                if (!startRestartGroup.shouldExecute((i6 & 38347923) != 38347922, i6 & 1)) {
                }
                final Modifier modifier222 = companion;
                final Alignment.Vertical vertical622 = vertical3;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj = horizontal;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            vertical3 = vertical2;
            i10 = i5 & 32;
            if (i10 != 0) {
            }
            i11 = i5 & 64;
            if (i11 != 0) {
            }
            i12 = i5 & 128;
            if (i12 != 0) {
            }
            if ((i4 & 100663296) == 0) {
            }
            companion = companion;
            if (!startRestartGroup.shouldExecute((i6 & 38347923) != 38347922, i6 & 1)) {
            }
            final Modifier modifier2222 = companion;
            final Alignment.Vertical vertical6222 = vertical3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        obj = horizontal;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        vertical3 = vertical2;
        i10 = i5 & 32;
        if (i10 != 0) {
        }
        i11 = i5 & 64;
        if (i11 != 0) {
        }
        i12 = i5 & 128;
        if (i12 != 0) {
        }
        if ((i4 & 100663296) == 0) {
        }
        companion = companion;
        if (!startRestartGroup.shouldExecute((i6 & 38347923) != 38347922, i6 & 1)) {
        }
        final Modifier modifier22222 = companion;
        final Alignment.Vertical vertical62222 = vertical3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ContextualFlowRow$lambda$2(Function4 function4, int i, FlowLineInfo flowLineInfo, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "CN(index,info)105@4746L14:ContextualFlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1677845586, i2, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:98)");
        }
        function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout(), flowLineInfo.getPositionInLine$foundation_layout(), flowLineInfo.m748getMaxMainAxisSizeD9Ej5fM$foundation_layout(), flowLineInfo.m747getMaxCrossAxisSizeD9Ej5fM$foundation_layout(), null), Integer.valueOf(i), composer, Integer.valueOf((i2 << 3) & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:137:0x01ba, code lost:
        if (r6 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L87;
     */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011f  */
    @Deprecated(message = "ContextualFlowLayouts are no longer maintained")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ContextualFlowColumn(final int i, Modifier modifier, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i2, int i3, ContextualFlowColumnOverflow contextualFlowColumnOverflow, final Function4<? super ContextualFlowColumnScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i4, final int i5) {
        int i6;
        Modifier.Companion companion;
        int i7;
        Object obj;
        int i8;
        int i9;
        Alignment.Horizontal horizontal3;
        int i10;
        int i11;
        int i12;
        final Arrangement.Horizontal horizontal4;
        final int i13;
        final ContextualFlowColumnOverflow contextualFlowColumnOverflow2;
        final Arrangement.Vertical vertical2;
        final int i14;
        ScopeUpdateScope endRestartGroup;
        int i15;
        Arrangement.Horizontal horizontal5;
        ArrayList arrayList;
        Composer startRestartGroup = composer.startRestartGroup(1986851536);
        ComposerKt.sourceInformation(startRestartGroup, "C(ContextualFlowColumn)N(itemCount,modifier,verticalArrangement,horizontalArrangement,itemHorizontalAlignment,maxItemsInEachColumn,maxLines,overflow,content)155@7415L53,157@7522L209,172@8034L339,163@7764L609,183@8379L68:ContextualFlowLayout.kt#2w3rfo");
        if ((i4 & 6) == 0) {
            i6 = (startRestartGroup.changed(i) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i16 = i5 & 2;
        if (i16 != 0) {
            i6 |= 48;
        } else if ((i4 & 48) == 0) {
            Object obj2 = modifier;
            i6 |= startRestartGroup.changed(obj2) ? 32 : 16;
            companion = obj2;
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj = vertical;
                i6 |= startRestartGroup.changed(obj) ? 256 : 128;
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else if ((i4 & 3072) == 0) {
                    i6 |= startRestartGroup.changed(horizontal) ? 2048 : 1024;
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else if ((i4 & 24576) == 0) {
                        Object obj3 = horizontal2;
                        i6 |= startRestartGroup.changed(obj3) ? 16384 : 8192;
                        horizontal3 = obj3;
                        i10 = i5 & 32;
                        if (i10 != 0) {
                            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i6 |= startRestartGroup.changed(i2) ? 131072 : 65536;
                        }
                        i11 = i5 & 64;
                        if (i11 != 0) {
                            i6 |= 1572864;
                        } else if ((i4 & 1572864) == 0) {
                            i6 |= startRestartGroup.changed(i3) ? 1048576 : 524288;
                        }
                        i12 = i5 & 128;
                        if (i12 != 0) {
                            i6 |= 12582912;
                        } else if ((i4 & 12582912) == 0) {
                            i6 |= startRestartGroup.changed(contextualFlowColumnOverflow) ? 8388608 : 4194304;
                        }
                        if ((i4 & 100663296) == 0) {
                            i6 |= startRestartGroup.changedInstance(function4) ? 67108864 : 33554432;
                        }
                        companion = companion;
                        if (!startRestartGroup.shouldExecute((i6 & 38347923) != 38347922, i6 & 1)) {
                            startRestartGroup.skipToGroupEnd();
                            horizontal4 = horizontal;
                            i13 = i2;
                            contextualFlowColumnOverflow2 = contextualFlowColumnOverflow;
                            vertical2 = obj;
                            i14 = i3;
                        } else {
                            if (i16 != 0) {
                                companion = Modifier.Companion;
                            }
                            Arrangement.Vertical top = i7 != 0 ? Arrangement.INSTANCE.getTop() : obj;
                            if (i8 != 0) {
                                horizontal5 = Arrangement.INSTANCE.getStart();
                                i15 = i9;
                            } else {
                                i15 = i9;
                                horizontal5 = horizontal;
                            }
                            if (i15 != 0) {
                                horizontal3 = Alignment.Companion.getStart();
                            }
                            int i17 = i10 != 0 ? Integer.MAX_VALUE : i2;
                            int i18 = i11 != 0 ? Integer.MAX_VALUE : i3;
                            ContextualFlowColumnOverflow clip = i12 != 0 ? ContextualFlowColumnOverflow.Companion.getClip() : contextualFlowColumnOverflow;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1986851536, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:154)");
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1896103003, "CC(remember):ContextualFlowLayout.kt#9igjgp");
                            int i19 = 29360128 & i6;
                            boolean z = i19 == 8388608;
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = clip.createOverflowState$foundation_layout();
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1896099423, "CC(remember):ContextualFlowLayout.kt#9igjgp");
                            boolean z2 = i19 == 8388608;
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!z2) {
                                arrayList = rememberedValue2;
                            }
                            ArrayList arrayList2 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList2);
                            startRestartGroup.updateRememberedValue(arrayList2);
                            arrayList = arrayList2;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i20 = i6 >> 6;
                            SubcomposeLayoutKt.SubcomposeLayout(companion, contextualColumnMeasureHelper(top, horizontal5, horizontal3, i17, i18, flowLayoutOverflowState, i, (List) arrayList, ComposableLambdaKt.rememberComposableLambda(620176540, true, new Function4() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function4
                                public final Object invoke(Object obj4, Object obj5, Object obj6, Object obj7) {
                                    return ContextualFlowLayoutKt.ContextualFlowColumn$lambda$2(Function4.this, ((Integer) obj4).intValue(), (FlowLineInfo) obj5, (Composer) obj6, ((Integer) obj7).intValue());
                                }
                            }, startRestartGroup, 54), startRestartGroup, (i20 & 57344) | (i20 & 14) | 100663296 | (i20 & 112) | (i20 & 896) | (i20 & 7168) | ((i6 << 18) & 3670016)), startRestartGroup, (i6 >> 3) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            contextualFlowColumnOverflow2 = clip;
                            vertical2 = top;
                            horizontal4 = horizontal5;
                            i13 = i17;
                            i14 = i18;
                        }
                        final Modifier modifier2 = companion;
                        final Alignment.Horizontal horizontal6 = horizontal3;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj4, Object obj5) {
                                    return ContextualFlowLayoutKt.ContextualFlowColumn$lambda$3(i, modifier2, vertical2, horizontal4, horizontal6, i13, i14, contextualFlowColumnOverflow2, function4, i4, i5, (Composer) obj4, ((Integer) obj5).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    horizontal3 = horizontal2;
                    i10 = i5 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i5 & 64;
                    if (i11 != 0) {
                    }
                    i12 = i5 & 128;
                    if (i12 != 0) {
                    }
                    if ((i4 & 100663296) == 0) {
                    }
                    companion = companion;
                    if (!startRestartGroup.shouldExecute((i6 & 38347923) != 38347922, i6 & 1)) {
                    }
                    final Modifier modifier22 = companion;
                    final Alignment.Horizontal horizontal62 = horizontal3;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                horizontal3 = horizontal2;
                i10 = i5 & 32;
                if (i10 != 0) {
                }
                i11 = i5 & 64;
                if (i11 != 0) {
                }
                i12 = i5 & 128;
                if (i12 != 0) {
                }
                if ((i4 & 100663296) == 0) {
                }
                companion = companion;
                if (!startRestartGroup.shouldExecute((i6 & 38347923) != 38347922, i6 & 1)) {
                }
                final Modifier modifier222 = companion;
                final Alignment.Horizontal horizontal622 = horizontal3;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj = vertical;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            horizontal3 = horizontal2;
            i10 = i5 & 32;
            if (i10 != 0) {
            }
            i11 = i5 & 64;
            if (i11 != 0) {
            }
            i12 = i5 & 128;
            if (i12 != 0) {
            }
            if ((i4 & 100663296) == 0) {
            }
            companion = companion;
            if (!startRestartGroup.shouldExecute((i6 & 38347923) != 38347922, i6 & 1)) {
            }
            final Modifier modifier2222 = companion;
            final Alignment.Horizontal horizontal6222 = horizontal3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        obj = vertical;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        horizontal3 = horizontal2;
        i10 = i5 & 32;
        if (i10 != 0) {
        }
        i11 = i5 & 64;
        if (i11 != 0) {
        }
        i12 = i5 & 128;
        if (i12 != 0) {
        }
        if ((i4 & 100663296) == 0) {
        }
        companion = companion;
        if (!startRestartGroup.shouldExecute((i6 & 38347923) != 38347922, i6 & 1)) {
        }
        final Modifier modifier22222 = companion;
        final Alignment.Horizontal horizontal62222 = horizontal3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ContextualFlowColumn$lambda$2(Function4 function4, int i, FlowLineInfo flowLineInfo, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "CN(index,info)180@8349L14:ContextualFlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(620176540, i2, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:173)");
        }
        function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout(), flowLineInfo.getPositionInLine$foundation_layout(), flowLineInfo.m747getMaxCrossAxisSizeD9Ej5fM$foundation_layout(), flowLineInfo.m748getMaxMainAxisSizeD9Ej5fM$foundation_layout(), null), Integer.valueOf(i), composer, Integer.valueOf((i2 << 3) & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
        if (r30.changed(r4) == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ce, code lost:
        if (r30.changed(r29) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d4, code lost:
        if ((r31 & 100663296) != 67108864) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00d6, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d7, code lost:
        r2 = r3 | r5;
        r3 = r30.rememberedValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00dd, code lost:
        if (r2 != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e5, code lost:
        if (r3 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e7, code lost:
        r3 = new androidx.compose.foundation.layout.FlowMeasureLazyPolicy(true, r21, r22, r21.mo694getSpacingD9Ej5fM(), androidx.compose.foundation.layout.CrossAxisAlignment.Companion.vertical$foundation_layout(r23), r22.mo694getSpacingD9Ej5fM(), r27, r25, r4, r26, r28, r29, null).getMeasurePolicy();
        r30.updateRememberedValue(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x010c, code lost:
        r3 = (kotlin.jvm.functions.Function2) r3;
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0115, code lost:
        if (androidx.compose.runtime.ComposerKt.isTraceInProgress() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0117, code lost:
        androidx.compose.runtime.ComposerKt.traceEventEnd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x011a, code lost:
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x011d, code lost:
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Function2<SubcomposeMeasureScope, Constraints, MeasureResult> contextualRowMeasurementHelper(Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState, int i3, List<? extends Function2<? super Composer, ? super Integer, Unit>> list, Function4<? super Integer, ? super FlowLineInfo, ? super Composer, ? super Integer, Unit> function4, Composer composer, int i4) {
        int i5;
        boolean z;
        ComposerKt.sourceInformationMarkerStart(composer, 962906403, "C(contextualRowMeasurementHelper)N(horizontalArrangement,verticalArrangement,itemVerticalAlignment,maxItemsInMainAxis,maxLines,overflowState,itemCount,overflowComposables,getComposable)385@16647L971:ContextualFlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(962906403, i4, -1, "androidx.compose.foundation.layout.contextualRowMeasurementHelper (ContextualFlowLayout.kt:384)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1935101358, "CC(remember):ContextualFlowLayout.kt#9igjgp");
        boolean z2 = false;
        boolean z3 = ((((i4 & 14) ^ 6) > 4 && composer.changed(horizontal)) || (i4 & 6) == 4) | ((((i4 & 112) ^ 48) > 32 && composer.changed(vertical)) || (i4 & 48) == 32) | ((((i4 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(vertical2)) || (i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
        if (((i4 & 7168) ^ 3072) > 2048) {
            i5 = i;
        } else {
            i5 = i;
        }
        if ((i4 & 3072) != 2048) {
            z = false;
            boolean changed = z3 | z | ((((57344 & i4) ^ 24576) <= 16384 && composer.changed(i2)) || (i4 & 24576) == 16384) | composer.changed(flowLayoutOverflowState) | ((((3670016 & i4) ^ 1572864) <= 1048576 && composer.changed(i3)) || (i4 & 1572864) == 1048576);
            if (((234881024 & i4) ^ 100663296) <= 67108864) {
            }
        }
        z = true;
        boolean changed2 = z3 | z | ((((57344 & i4) ^ 24576) <= 16384 && composer.changed(i2)) || (i4 & 24576) == 16384) | composer.changed(flowLayoutOverflowState) | ((((3670016 & i4) ^ 1572864) <= 1048576 && composer.changed(i3)) || (i4 & 1572864) == 1048576);
        if (((234881024 & i4) ^ 100663296) <= 67108864) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
        if (r30.changed(r4) == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ce, code lost:
        if (r30.changed(r29) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d4, code lost:
        if ((r31 & 100663296) != 67108864) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00d6, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d7, code lost:
        r2 = r3 | r5;
        r3 = r30.rememberedValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00dd, code lost:
        if (r2 != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e5, code lost:
        if (r3 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e7, code lost:
        r3 = new androidx.compose.foundation.layout.FlowMeasureLazyPolicy(false, r22, r21, r21.mo694getSpacingD9Ej5fM(), androidx.compose.foundation.layout.CrossAxisAlignment.Companion.horizontal$foundation_layout(r23), r22.mo694getSpacingD9Ej5fM(), r27, r25, r4, r26, r28, r29, null).getMeasurePolicy();
        r30.updateRememberedValue(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x010c, code lost:
        r3 = (kotlin.jvm.functions.Function2) r3;
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0115, code lost:
        if (androidx.compose.runtime.ComposerKt.isTraceInProgress() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0117, code lost:
        androidx.compose.runtime.ComposerKt.traceEventEnd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x011a, code lost:
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x011d, code lost:
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Function2<SubcomposeMeasureScope, Constraints, MeasureResult> contextualColumnMeasureHelper(Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState, int i3, List<? extends Function2<? super Composer, ? super Integer, Unit>> list, Function4<? super Integer, ? super FlowLineInfo, ? super Composer, ? super Integer, Unit> function4, Composer composer, int i4) {
        int i5;
        boolean z;
        ComposerKt.sourceInformationMarkerStart(composer, -676633639, "C(contextualColumnMeasureHelper)N(verticalArrangement,horizontalArrangement,itemHorizontalAlignment,maxItemsInMainAxis,maxLines,overflowState,itemCount,overflowComposables,getComposable)425@18138L978:ContextualFlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-676633639, i4, -1, "androidx.compose.foundation.layout.contextualColumnMeasureHelper (ContextualFlowLayout.kt:424)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1704848565, "CC(remember):ContextualFlowLayout.kt#9igjgp");
        boolean z2 = false;
        boolean z3 = ((((i4 & 14) ^ 6) > 4 && composer.changed(vertical)) || (i4 & 6) == 4) | ((((i4 & 112) ^ 48) > 32 && composer.changed(horizontal)) || (i4 & 48) == 32) | ((((i4 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(horizontal2)) || (i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
        if (((i4 & 7168) ^ 3072) > 2048) {
            i5 = i;
        } else {
            i5 = i;
        }
        if ((i4 & 3072) != 2048) {
            z = false;
            boolean changed = z3 | z | ((((57344 & i4) ^ 24576) <= 16384 && composer.changed(i2)) || (i4 & 24576) == 16384) | composer.changed(flowLayoutOverflowState) | ((((3670016 & i4) ^ 1572864) <= 1048576 && composer.changed(i3)) || (i4 & 1572864) == 1048576);
            if (((234881024 & i4) ^ 100663296) <= 67108864) {
            }
        }
        z = true;
        boolean changed2 = z3 | z | ((((57344 & i4) ^ 24576) <= 16384 && composer.changed(i2)) || (i4 & 24576) == 16384) | composer.changed(flowLayoutOverflowState) | ((((3670016 & i4) ^ 1572864) <= 1048576 && composer.changed(i3)) || (i4 & 1572864) == 1048576);
        if (((234881024 & i4) ^ 100663296) <= 67108864) {
        }
    }
}
