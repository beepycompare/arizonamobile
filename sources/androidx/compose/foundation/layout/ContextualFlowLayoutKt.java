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
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u008e\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f21\u0010\u0010\u001a-\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a\u008e\u0001\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u001d21\u0010\u0010\u001a-\u0012\u0004\u0012\u00020\u001e\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u001f\u001a\u00ad\u0001\u0010 \u001a\u0014\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010'\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010)¢\u0006\u0002\b\u00160(2;\u0010*\u001a7\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110+¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016H\u0001¢\u0006\u0002\u0010-\u001a\u00ad\u0001\u0010.\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010'\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010)¢\u0006\u0002\b\u00160(2;\u0010*\u001a7\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110+¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016H\u0001¢\u0006\u0002\u0010/¨\u00060"}, d2 = {"ContextualFlowColumn", "", "itemCount", "", "modifier", "Landroidx/compose/ui/Modifier;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "itemHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "maxItemsInEachColumn", "maxLines", "overflow", "Landroidx/compose/foundation/layout/ContextualFlowColumnOverflow;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function2;", "Landroidx/compose/foundation/layout/ContextualFlowColumnScope;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/ContextualFlowColumnOverflow;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "ContextualFlowRow", "itemVerticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "maxItemsInEachRow", "Landroidx/compose/foundation/layout/ContextualFlowRowOverflow;", "Landroidx/compose/foundation/layout/ContextualFlowRowScope;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/ContextualFlowRowOverflow;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "contextualColumnMeasureHelper", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "maxItemsInMainAxis", "overflowState", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "overflowComposables", "", "Lkotlin/Function0;", "getComposable", "Landroidx/compose/foundation/layout/FlowLineInfo;", "info", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;ILjava/util/List;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "contextualRowMeasurementHelper", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;ILjava/util/List;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "foundation-layout_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ContextualFlowLayoutKt {
    /* JADX WARN: Code restructure failed: missing block: B:143:0x01c9, code lost:
        if (r6 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0123  */
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
        Composer startRestartGroup = composer.startRestartGroup(253921631);
        ComposerKt.sourceInformation(startRestartGroup, "C(ContextualFlowRow)P(2,6,1,8,3,4,5,7)80@3819L53,82@3926L209,97@4433L335,88@4168L600,107@4773L68:ContextualFlowLayout.kt#2w3rfo");
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 6) == 0) {
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
                        if ((i5 & 256) != 0) {
                            i6 |= 100663296;
                        } else if ((i4 & 100663296) == 0) {
                            i6 |= startRestartGroup.changedInstance(function4) ? 67108864 : 33554432;
                        }
                        companion = companion;
                        if (startRestartGroup.shouldExecute((38347923 & i6) != 38347922, i6 & 1)) {
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
                                ComposerKt.traceEventStart(253921631, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:79)");
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1235066022, "CC(remember):ContextualFlowLayout.kt#9igjgp");
                            int i19 = 29360128 & i6;
                            boolean z = i19 == 8388608;
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = clip.createOverflowState$foundation_layout_release();
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1235069602, "CC(remember):ContextualFlowLayout.kt#9igjgp");
                            boolean z2 = i19 == 8388608;
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!z2) {
                                arrayList = rememberedValue2;
                            }
                            ArrayList arrayList2 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList2);
                            startRestartGroup.updateRememberedValue(arrayList2);
                            arrayList = arrayList2;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i20 = i6 >> 6;
                            SubcomposeLayoutKt.SubcomposeLayout(companion, contextualRowMeasurementHelper(start, vertical5, vertical3, i17, i18, flowLayoutOverflowState, i, (List) arrayList, ComposableLambdaKt.rememberComposableLambda(-1599700159, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public /* bridge */ /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                                    invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(int i21, FlowLineInfo flowLineInfo, Composer composer2, int i22) {
                                    ComposerKt.sourceInformation(composer2, "C105@4744L14:ContextualFlowLayout.kt#2w3rfo");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1599700159, i22, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:98)");
                                    }
                                    function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m670getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m669getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i21), composer2, Integer.valueOf((i22 << 3) & 112));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
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
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            vertical4 = vertical;
                            i13 = i2;
                            contextualFlowRowOverflow2 = contextualFlowRowOverflow;
                            horizontal2 = obj;
                            i14 = i3;
                        }
                        final Modifier modifier2 = companion;
                        final Alignment.Vertical vertical6 = vertical3;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowRow$1
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

                                public final void invoke(Composer composer2, int i21) {
                                    ContextualFlowLayoutKt.ContextualFlowRow(i, modifier2, horizontal2, vertical4, vertical6, i13, i14, contextualFlowRowOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
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
                    if ((i5 & 256) != 0) {
                    }
                    companion = companion;
                    if (startRestartGroup.shouldExecute((38347923 & i6) != 38347922, i6 & 1)) {
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
                if ((i5 & 256) != 0) {
                }
                companion = companion;
                if (startRestartGroup.shouldExecute((38347923 & i6) != 38347922, i6 & 1)) {
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
            if ((i5 & 256) != 0) {
            }
            companion = companion;
            if (startRestartGroup.shouldExecute((38347923 & i6) != 38347922, i6 & 1)) {
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
        if ((i5 & 256) != 0) {
        }
        companion = companion;
        if (startRestartGroup.shouldExecute((38347923 & i6) != 38347922, i6 & 1)) {
        }
        final Modifier modifier22222 = companion;
        final Alignment.Vertical vertical62222 = vertical3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:143:0x01c9, code lost:
        if (r6 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0123  */
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
        Composer startRestartGroup = composer.startRestartGroup(1048542435);
        ComposerKt.sourceInformation(startRestartGroup, "C(ContextualFlowColumn)P(2,6,8,1,3,4,5,7)155@7413L53,157@7520L209,172@8032L338,163@7762L608,183@8376L68:ContextualFlowLayout.kt#2w3rfo");
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 6) == 0) {
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
                        if ((i5 & 256) != 0) {
                            i6 |= 100663296;
                        } else if ((i4 & 100663296) == 0) {
                            i6 |= startRestartGroup.changedInstance(function4) ? 67108864 : 33554432;
                        }
                        companion = companion;
                        if (startRestartGroup.shouldExecute((38347923 & i6) != 38347922, i6 & 1)) {
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
                                ComposerKt.traceEventStart(1048542435, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:154)");
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1055903340, "CC(remember):ContextualFlowLayout.kt#9igjgp");
                            int i19 = 29360128 & i6;
                            boolean z = i19 == 8388608;
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = clip.createOverflowState$foundation_layout_release();
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1055899760, "CC(remember):ContextualFlowLayout.kt#9igjgp");
                            boolean z2 = i19 == 8388608;
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!z2) {
                                arrayList = rememberedValue2;
                            }
                            ArrayList arrayList2 = new ArrayList();
                            clip.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList2);
                            startRestartGroup.updateRememberedValue(arrayList2);
                            arrayList = arrayList2;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i20 = i6 >> 6;
                            SubcomposeLayoutKt.SubcomposeLayout(companion, contextualColumnMeasureHelper(top, horizontal5, horizontal3, i17, i18, flowLayoutOverflowState, i, (List) arrayList, ComposableLambdaKt.rememberComposableLambda(1048264111, true, new Function4<Integer, FlowLineInfo, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public /* bridge */ /* synthetic */ Unit invoke(Integer num, FlowLineInfo flowLineInfo, Composer composer2, Integer num2) {
                                    invoke(num.intValue(), flowLineInfo, composer2, num2.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(int i21, FlowLineInfo flowLineInfo, Composer composer2, int i22) {
                                    ComposerKt.sourceInformation(composer2, "C180@8346L14:ContextualFlowLayout.kt#2w3rfo");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1048264111, i22, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:173)");
                                    }
                                    function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex$foundation_layout_release(), flowLineInfo.getPositionInLine$foundation_layout_release(), flowLineInfo.m669getMaxCrossAxisSizeD9Ej5fM$foundation_layout_release(), flowLineInfo.m670getMaxMainAxisSizeD9Ej5fM$foundation_layout_release(), null), Integer.valueOf(i21), composer2, Integer.valueOf((i22 << 3) & 112));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
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
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            horizontal4 = horizontal;
                            i13 = i2;
                            contextualFlowColumnOverflow2 = contextualFlowColumnOverflow;
                            vertical2 = obj;
                            i14 = i3;
                        }
                        final Modifier modifier2 = companion;
                        final Alignment.Horizontal horizontal6 = horizontal3;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$ContextualFlowColumn$1
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

                                public final void invoke(Composer composer2, int i21) {
                                    ContextualFlowLayoutKt.ContextualFlowColumn(i, modifier2, vertical2, horizontal4, horizontal6, i13, i14, contextualFlowColumnOverflow2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
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
                    if ((i5 & 256) != 0) {
                    }
                    companion = companion;
                    if (startRestartGroup.shouldExecute((38347923 & i6) != 38347922, i6 & 1)) {
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
                if ((i5 & 256) != 0) {
                }
                companion = companion;
                if (startRestartGroup.shouldExecute((38347923 & i6) != 38347922, i6 & 1)) {
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
            if ((i5 & 256) != 0) {
            }
            companion = companion;
            if (startRestartGroup.shouldExecute((38347923 & i6) != 38347922, i6 & 1)) {
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
        if ((i5 & 256) != 0) {
        }
        companion = companion;
        if (startRestartGroup.shouldExecute((38347923 & i6) != 38347922, i6 & 1)) {
        }
        final Modifier modifier22222 = companion;
        final Alignment.Horizontal horizontal62222 = horizontal3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
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
        r3 = new androidx.compose.foundation.layout.FlowMeasureLazyPolicy(true, r21, r22, r21.mo625getSpacingD9Ej5fM(), androidx.compose.foundation.layout.CrossAxisAlignment.Companion.vertical$foundation_layout_release(r23), r22.mo625getSpacingD9Ej5fM(), r27, r25, r4, r26, r28, r29, null).getMeasurePolicy();
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
        ComposerKt.sourceInformationMarkerStart(composer, 785825072, "C(contextualRowMeasurementHelper)P(1,8,3,4,5,7,2,6)395@16763L969:ContextualFlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(785825072, i4, -1, "androidx.compose.foundation.layout.contextualRowMeasurementHelper (ContextualFlowLayout.kt:394)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1139059380, "CC(remember):ContextualFlowLayout.kt#9igjgp");
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
        r3 = new androidx.compose.foundation.layout.FlowMeasureLazyPolicy(false, r22, r21, r21.mo625getSpacingD9Ej5fM(), androidx.compose.foundation.layout.CrossAxisAlignment.Companion.horizontal$foundation_layout_release(r23), r22.mo625getSpacingD9Ej5fM(), r27, r25, r4, r26, r28, r29, null).getMeasurePolicy();
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
        ComposerKt.sourceInformationMarkerStart(composer, -1985535130, "C(contextualColumnMeasureHelper)P(8,1,3,4,5,7,2,6)435@18251L976:ContextualFlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1985535130, i4, -1, "androidx.compose.foundation.layout.contextualColumnMeasureHelper (ContextualFlowLayout.kt:434)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1978145909, "CC(remember):ContextualFlowLayout.kt#9igjgp");
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
