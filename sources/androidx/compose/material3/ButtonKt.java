package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Button.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u008f\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001c\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001d\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001e"}, d2 = {"Button", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/ButtonColors;", "elevation", "Landroidx/compose/material3/ButtonElevation;", "border", "Landroidx/compose/foundation/BorderStroke;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ButtonColors;Landroidx/compose/material3/ButtonElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ElevatedButton", "FilledTonalButton", "OutlinedButton", "TextButton", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:184:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0101  */
    /* JADX WARN: Type inference failed for: r11v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Button(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Object obj;
        int i4;
        boolean z2;
        Object obj2;
        ButtonColors buttonColors2;
        ButtonElevation buttonElevation2;
        int i5;
        Object obj3;
        int i6;
        int i7;
        int i8;
        int i9;
        Shape shape2;
        ButtonColors buttonColors3;
        Modifier modifier2;
        boolean z3;
        State<Dp> state;
        int i10;
        final PaddingValues contentPadding;
        MutableInteractionSource mutableInteractionSource2;
        int i11;
        Shape shape3;
        int i12;
        Modifier modifier3;
        BorderStroke borderStroke2;
        boolean z4;
        ?? r11;
        MutableInteractionSource mutableInteractionSource3;
        Composer composer2;
        final ButtonColors buttonColors4;
        final ButtonElevation buttonElevation3;
        final boolean z5;
        final Shape shape4;
        final BorderStroke borderStroke3;
        final MutableInteractionSource mutableInteractionSource4;
        final PaddingValues paddingValues2;
        final Modifier modifier4;
        ScopeUpdateScope endRestartGroup;
        int i13;
        int i14;
        Object obj4;
        int i15;
        Object obj5;
        Composer startRestartGroup = composer.startRestartGroup(650121315);
        ComposerKt.sourceInformation(startRestartGroup, "C(Button)P(8,7,5,9,1,4!1,3,6)111@5461L5,112@5510L14,113@5575L17,134@6467L587,124@6130L924:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i16 = i2 & 2;
        if (i16 != 0) {
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
                        obj4 = shape;
                        if (startRestartGroup.changed(obj4)) {
                            i15 = 2048;
                            obj5 = obj4;
                            i3 |= i15;
                            obj2 = obj5;
                        }
                    } else {
                        obj4 = shape;
                    }
                    i15 = 1024;
                    obj5 = obj4;
                    i3 |= i15;
                    obj2 = obj5;
                } else {
                    obj2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonColors2 = buttonColors;
                        if (startRestartGroup.changed(buttonColors2)) {
                            i14 = 16384;
                            i3 |= i14;
                        }
                    } else {
                        buttonColors2 = buttonColors;
                    }
                    i14 = 8192;
                    i3 |= i14;
                } else {
                    buttonColors2 = buttonColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        buttonElevation2 = buttonElevation;
                        if (startRestartGroup.changed(buttonElevation2)) {
                            i13 = 131072;
                            i3 |= i13;
                        }
                    } else {
                        buttonElevation2 = buttonElevation;
                    }
                    i13 = 65536;
                    i3 |= i13;
                } else {
                    buttonElevation2 = buttonElevation;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else if ((1572864 & i) == 0) {
                    obj3 = borderStroke;
                    i3 |= startRestartGroup.changed(obj3) ? 1048576 : 524288;
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                        i7 = i16;
                    } else {
                        i7 = i16;
                        if ((i & 12582912) == 0) {
                            i3 |= startRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                        }
                    }
                    i8 = i2 & 256;
                    if (i8 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i9 = i8;
                        i3 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        if ((i2 & 512) != 0) {
                            i3 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i3 |= startRestartGroup.changedInstance(function3) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        }
                        if ((306783379 & i3) == 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i7 != 0 ? Modifier.Companion : modifier;
                                boolean z6 = i4 != 0 ? true : z2;
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                    shape2 = ButtonDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                } else {
                                    shape2 = obj2;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    buttonColors3 = ButtonDefaults.INSTANCE.buttonColors(startRestartGroup, 6);
                                } else {
                                    buttonColors3 = buttonColors2;
                                }
                                int i17 = i3;
                                if ((i2 & 32) != 0) {
                                    modifier2 = companion;
                                    z3 = true;
                                    state = null;
                                    buttonElevation2 = ButtonDefaults.INSTANCE.m1613buttonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                    i10 = i17 & (-458753);
                                } else {
                                    modifier2 = companion;
                                    z3 = true;
                                    state = null;
                                    i10 = i17;
                                }
                                if (i5 != 0) {
                                    obj3 = state;
                                }
                                contentPadding = i6 != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                mutableInteractionSource2 = i9 != 0 ? state : mutableInteractionSource;
                                i11 = i10;
                                buttonColors2 = buttonColors3;
                                shape3 = shape2;
                                i12 = 650121315;
                                modifier3 = modifier2;
                                borderStroke2 = obj3;
                                z4 = z6;
                                r11 = z3;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                i11 = i3;
                                r11 = 1;
                                shape3 = obj2;
                                borderStroke2 = obj3;
                                state = null;
                                modifier3 = modifier;
                                contentPadding = paddingValues;
                                mutableInteractionSource2 = mutableInteractionSource;
                                z4 = z2;
                                i12 = 650121315;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i12, i11, -1, "androidx.compose.material3.Button (Button.kt:118)");
                            }
                            startRestartGroup.startReplaceGroup(-239156623);
                            ComposerKt.sourceInformation(startRestartGroup, "120@5882L39");
                            if (mutableInteractionSource2 == null) {
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -239155972, "CC(remember):Button.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            startRestartGroup.endReplaceGroup();
                            long m1605containerColorvNxB06k$material3_release = buttonColors2.m1605containerColorvNxB06k$material3_release(z4);
                            final long m1606contentColorvNxB06k$material3_release = buttonColors2.m1606contentColorvNxB06k$material3_release(z4);
                            startRestartGroup.startReplaceGroup(-239150048);
                            ComposerKt.sourceInformation(startRestartGroup, "123@6067L43");
                            if (buttonElevation2 != null) {
                                state = buttonElevation2.shadowElevation$material3_release(z4, mutableInteractionSource3, startRestartGroup, ((i11 >> 6) & 14) | ((i11 >> 9) & 896));
                            }
                            startRestartGroup.endReplaceGroup();
                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource2;
                            Modifier modifier5 = modifier3;
                            SurfaceKt.m2350Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    SemanticsPropertiesKt.m5930setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m5911getButtono7Vup1c());
                                }
                            }, r11, null), z4, shape3, m1605containerColorvNxB06k$material3_release, m1606contentColorvNxB06k$material3_release, 0.0f, state != null ? state.getValue().m6698unboximpl() : Dp.m6684constructorimpl(0), borderStroke2, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(956488494, r11, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2
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

                                public final void invoke(Composer composer3, int i18) {
                                    ComposerKt.sourceInformation(composer3, "C137@6586L10,138@6618L430,135@6477L571:Button.kt#uh7d8r");
                                    if ((i18 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(956488494, i18, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:135)");
                                        }
                                        long j = m1606contentColorvNxB06k$material3_release;
                                        TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer3, 6).getLabelLarge();
                                        final PaddingValues paddingValues3 = contentPadding;
                                        final Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                        ProvideContentColorTextStyleKt.m2707ProvideContentColorTextStyle3JVO9M(j, labelLarge, ComposableLambdaKt.rememberComposableLambda(1327513942, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2.1
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

                                            public final void invoke(Composer composer4, int i19) {
                                                ComposerKt.sourceInformation(composer4, "C139@6632L406:Button.kt#uh7d8r");
                                                if ((i19 & 3) != 2 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1327513942, i19, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:139)");
                                                    }
                                                    Modifier padding = PaddingKt.padding(SizeKt.m769defaultMinSizeVpY3zN4(Modifier.Companion, ButtonDefaults.INSTANCE.m1621getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1620getMinHeightD9Ej5fM()), PaddingValues.this);
                                                    Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                                                    Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                                    ComposerKt.sourceInformationMarkerStart(composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), centerVertically, composer4, 54);
                                                    ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, padding);
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
                                                    Updater.m3527setimpl(m3520constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                    Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                    if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                    ComposerKt.sourceInformationMarkerStart(composer4, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                                                    function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
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
                                        }, composer3, 54), composer3, RendererCapabilities.DECODER_SUPPORT_MASK);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }, startRestartGroup, 54), startRestartGroup, (i11 & 8078) | (234881024 & (i11 << 6)), 6, 64);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2 = startRestartGroup;
                            buttonColors4 = buttonColors2;
                            buttonElevation3 = buttonElevation2;
                            z5 = z4;
                            shape4 = shape3;
                            borderStroke3 = borderStroke2;
                            mutableInteractionSource4 = mutableInteractionSource5;
                            paddingValues2 = contentPadding;
                            modifier4 = modifier5;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier4 = obj;
                            z5 = z2;
                            shape4 = obj2;
                            composer2 = startRestartGroup;
                            buttonColors4 = buttonColors2;
                            buttonElevation3 = buttonElevation2;
                            borderStroke3 = obj3;
                            paddingValues2 = paddingValues;
                            mutableInteractionSource4 = mutableInteractionSource;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$3
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

                                public final void invoke(Composer composer3, int i18) {
                                    ButtonKt.Button(function0, modifier4, z5, shape4, buttonColors4, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i9 = i8;
                    if ((i2 & 512) != 0) {
                    }
                    if ((306783379 & i3) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if ((i2 & 8) != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    int i172 = i3;
                    if ((i2 & 32) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    i11 = i10;
                    buttonColors2 = buttonColors3;
                    shape3 = shape2;
                    i12 = 650121315;
                    modifier3 = modifier2;
                    borderStroke2 = obj3;
                    z4 = z6;
                    r11 = z3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceGroup(-239156623);
                    ComposerKt.sourceInformation(startRestartGroup, "120@5882L39");
                    if (mutableInteractionSource2 == null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    long m1605containerColorvNxB06k$material3_release2 = buttonColors2.m1605containerColorvNxB06k$material3_release(z4);
                    final long m1606contentColorvNxB06k$material3_release2 = buttonColors2.m1606contentColorvNxB06k$material3_release(z4);
                    startRestartGroup.startReplaceGroup(-239150048);
                    ComposerKt.sourceInformation(startRestartGroup, "123@6067L43");
                    if (buttonElevation2 != null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource2;
                    Modifier modifier52 = modifier3;
                    SurfaceKt.m2350Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.m5930setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m5911getButtono7Vup1c());
                        }
                    }, r11, null), z4, shape3, m1605containerColorvNxB06k$material3_release2, m1606contentColorvNxB06k$material3_release2, 0.0f, state != null ? state.getValue().m6698unboximpl() : Dp.m6684constructorimpl(0), borderStroke2, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(956488494, r11, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2
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

                        public final void invoke(Composer composer3, int i18) {
                            ComposerKt.sourceInformation(composer3, "C137@6586L10,138@6618L430,135@6477L571:Button.kt#uh7d8r");
                            if ((i18 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(956488494, i18, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:135)");
                                }
                                long j = m1606contentColorvNxB06k$material3_release2;
                                TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer3, 6).getLabelLarge();
                                final PaddingValues paddingValues3 = contentPadding;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                ProvideContentColorTextStyleKt.m2707ProvideContentColorTextStyle3JVO9M(j, labelLarge, ComposableLambdaKt.rememberComposableLambda(1327513942, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2.1
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

                                    public final void invoke(Composer composer4, int i19) {
                                        ComposerKt.sourceInformation(composer4, "C139@6632L406:Button.kt#uh7d8r");
                                        if ((i19 & 3) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1327513942, i19, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:139)");
                                            }
                                            Modifier padding = PaddingKt.padding(SizeKt.m769defaultMinSizeVpY3zN4(Modifier.Companion, ButtonDefaults.INSTANCE.m1621getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1620getMinHeightD9Ej5fM()), PaddingValues.this);
                                            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                            ComposerKt.sourceInformationMarkerStart(composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), centerVertically, composer4, 54);
                                            ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, padding);
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
                                            Updater.m3527setimpl(m3520constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composer4, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                                            function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
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
                                }, composer3, 54), composer3, RendererCapabilities.DECODER_SUPPORT_MASK);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }, startRestartGroup, 54), startRestartGroup, (i11 & 8078) | (234881024 & (i11 << 6)), 6, 64);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    buttonColors4 = buttonColors2;
                    buttonElevation3 = buttonElevation2;
                    z5 = z4;
                    shape4 = shape3;
                    borderStroke3 = borderStroke2;
                    mutableInteractionSource4 = mutableInteractionSource52;
                    paddingValues2 = contentPadding;
                    modifier4 = modifier52;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj3 = borderStroke;
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                i8 = i2 & 256;
                if (i8 == 0) {
                }
                i9 = i8;
                if ((i2 & 512) != 0) {
                }
                if ((306783379 & i3) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i7 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                int i1722 = i3;
                if ((i2 & 32) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i9 != 0) {
                }
                i11 = i10;
                buttonColors2 = buttonColors3;
                shape3 = shape2;
                i12 = 650121315;
                modifier3 = modifier2;
                borderStroke2 = obj3;
                z4 = z6;
                r11 = z3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceGroup(-239156623);
                ComposerKt.sourceInformation(startRestartGroup, "120@5882L39");
                if (mutableInteractionSource2 == null) {
                }
                startRestartGroup.endReplaceGroup();
                long m1605containerColorvNxB06k$material3_release22 = buttonColors2.m1605containerColorvNxB06k$material3_release(z4);
                final long m1606contentColorvNxB06k$material3_release22 = buttonColors2.m1606contentColorvNxB06k$material3_release(z4);
                startRestartGroup.startReplaceGroup(-239150048);
                ComposerKt.sourceInformation(startRestartGroup, "123@6067L43");
                if (buttonElevation2 != null) {
                }
                startRestartGroup.endReplaceGroup();
                MutableInteractionSource mutableInteractionSource522 = mutableInteractionSource2;
                Modifier modifier522 = modifier3;
                SurfaceKt.m2350Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.m5930setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m5911getButtono7Vup1c());
                    }
                }, r11, null), z4, shape3, m1605containerColorvNxB06k$material3_release22, m1606contentColorvNxB06k$material3_release22, 0.0f, state != null ? state.getValue().m6698unboximpl() : Dp.m6684constructorimpl(0), borderStroke2, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(956488494, r11, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2
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

                    public final void invoke(Composer composer3, int i18) {
                        ComposerKt.sourceInformation(composer3, "C137@6586L10,138@6618L430,135@6477L571:Button.kt#uh7d8r");
                        if ((i18 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(956488494, i18, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:135)");
                            }
                            long j = m1606contentColorvNxB06k$material3_release22;
                            TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer3, 6).getLabelLarge();
                            final PaddingValues paddingValues3 = contentPadding;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                            ProvideContentColorTextStyleKt.m2707ProvideContentColorTextStyle3JVO9M(j, labelLarge, ComposableLambdaKt.rememberComposableLambda(1327513942, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2.1
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

                                public final void invoke(Composer composer4, int i19) {
                                    ComposerKt.sourceInformation(composer4, "C139@6632L406:Button.kt#uh7d8r");
                                    if ((i19 & 3) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1327513942, i19, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:139)");
                                        }
                                        Modifier padding = PaddingKt.padding(SizeKt.m769defaultMinSizeVpY3zN4(Modifier.Companion, ButtonDefaults.INSTANCE.m1621getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1620getMinHeightD9Ej5fM()), PaddingValues.this);
                                        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                        ComposerKt.sourceInformationMarkerStart(composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), centerVertically, composer4, 54);
                                        ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, padding);
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
                                        Updater.m3527setimpl(m3520constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composer4, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                                        function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
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
                            }, composer3, 54), composer3, RendererCapabilities.DECODER_SUPPORT_MASK);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }, startRestartGroup, 54), startRestartGroup, (i11 & 8078) | (234881024 & (i11 << 6)), 6, 64);
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                buttonColors4 = buttonColors2;
                buttonElevation3 = buttonElevation2;
                z5 = z4;
                shape4 = shape3;
                borderStroke3 = borderStroke2;
                mutableInteractionSource4 = mutableInteractionSource522;
                paddingValues2 = contentPadding;
                modifier4 = modifier522;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            obj3 = borderStroke;
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            i8 = i2 & 256;
            if (i8 == 0) {
            }
            i9 = i8;
            if ((i2 & 512) != 0) {
            }
            if ((306783379 & i3) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i7 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            int i17222 = i3;
            if ((i2 & 32) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i9 != 0) {
            }
            i11 = i10;
            buttonColors2 = buttonColors3;
            shape3 = shape2;
            i12 = 650121315;
            modifier3 = modifier2;
            borderStroke2 = obj3;
            z4 = z6;
            r11 = z3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceGroup(-239156623);
            ComposerKt.sourceInformation(startRestartGroup, "120@5882L39");
            if (mutableInteractionSource2 == null) {
            }
            startRestartGroup.endReplaceGroup();
            long m1605containerColorvNxB06k$material3_release222 = buttonColors2.m1605containerColorvNxB06k$material3_release(z4);
            final long m1606contentColorvNxB06k$material3_release222 = buttonColors2.m1606contentColorvNxB06k$material3_release(z4);
            startRestartGroup.startReplaceGroup(-239150048);
            ComposerKt.sourceInformation(startRestartGroup, "123@6067L43");
            if (buttonElevation2 != null) {
            }
            startRestartGroup.endReplaceGroup();
            MutableInteractionSource mutableInteractionSource5222 = mutableInteractionSource2;
            Modifier modifier5222 = modifier3;
            SurfaceKt.m2350Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m5930setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m5911getButtono7Vup1c());
                }
            }, r11, null), z4, shape3, m1605containerColorvNxB06k$material3_release222, m1606contentColorvNxB06k$material3_release222, 0.0f, state != null ? state.getValue().m6698unboximpl() : Dp.m6684constructorimpl(0), borderStroke2, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(956488494, r11, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2
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

                public final void invoke(Composer composer3, int i18) {
                    ComposerKt.sourceInformation(composer3, "C137@6586L10,138@6618L430,135@6477L571:Button.kt#uh7d8r");
                    if ((i18 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(956488494, i18, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:135)");
                        }
                        long j = m1606contentColorvNxB06k$material3_release222;
                        TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer3, 6).getLabelLarge();
                        final PaddingValues paddingValues3 = contentPadding;
                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                        ProvideContentColorTextStyleKt.m2707ProvideContentColorTextStyle3JVO9M(j, labelLarge, ComposableLambdaKt.rememberComposableLambda(1327513942, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2.1
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

                            public final void invoke(Composer composer4, int i19) {
                                ComposerKt.sourceInformation(composer4, "C139@6632L406:Button.kt#uh7d8r");
                                if ((i19 & 3) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1327513942, i19, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:139)");
                                    }
                                    Modifier padding = PaddingKt.padding(SizeKt.m769defaultMinSizeVpY3zN4(Modifier.Companion, ButtonDefaults.INSTANCE.m1621getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1620getMinHeightD9Ej5fM()), PaddingValues.this);
                                    Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                                    Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                    ComposerKt.sourceInformationMarkerStart(composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), centerVertically, composer4, 54);
                                    ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, padding);
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
                                    Updater.m3527setimpl(m3520constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer4, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                                    function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
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
                        }, composer3, 54), composer3, RendererCapabilities.DECODER_SUPPORT_MASK);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, startRestartGroup, 54), startRestartGroup, (i11 & 8078) | (234881024 & (i11 << 6)), 6, 64);
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            buttonColors4 = buttonColors2;
            buttonElevation3 = buttonElevation2;
            z5 = z4;
            shape4 = shape3;
            borderStroke3 = borderStroke2;
            mutableInteractionSource4 = mutableInteractionSource5222;
            paddingValues2 = contentPadding;
            modifier4 = modifier5222;
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
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        obj3 = borderStroke;
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        i8 = i2 & 256;
        if (i8 == 0) {
        }
        i9 = i8;
        if ((i2 & 512) != 0) {
        }
        if ((306783379 & i3) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i7 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        int i172222 = i3;
        if ((i2 & 32) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i9 != 0) {
        }
        i11 = i10;
        buttonColors2 = buttonColors3;
        shape3 = shape2;
        i12 = 650121315;
        modifier3 = modifier2;
        borderStroke2 = obj3;
        z4 = z6;
        r11 = z3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(-239156623);
        ComposerKt.sourceInformation(startRestartGroup, "120@5882L39");
        if (mutableInteractionSource2 == null) {
        }
        startRestartGroup.endReplaceGroup();
        long m1605containerColorvNxB06k$material3_release2222 = buttonColors2.m1605containerColorvNxB06k$material3_release(z4);
        final long m1606contentColorvNxB06k$material3_release2222 = buttonColors2.m1606contentColorvNxB06k$material3_release(z4);
        startRestartGroup.startReplaceGroup(-239150048);
        ComposerKt.sourceInformation(startRestartGroup, "123@6067L43");
        if (buttonElevation2 != null) {
        }
        startRestartGroup.endReplaceGroup();
        MutableInteractionSource mutableInteractionSource52222 = mutableInteractionSource2;
        Modifier modifier52222 = modifier3;
        SurfaceKt.m2350Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.m5930setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m5911getButtono7Vup1c());
            }
        }, r11, null), z4, shape3, m1605containerColorvNxB06k$material3_release2222, m1606contentColorvNxB06k$material3_release2222, 0.0f, state != null ? state.getValue().m6698unboximpl() : Dp.m6684constructorimpl(0), borderStroke2, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(956488494, r11, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2
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

            public final void invoke(Composer composer3, int i18) {
                ComposerKt.sourceInformation(composer3, "C137@6586L10,138@6618L430,135@6477L571:Button.kt#uh7d8r");
                if ((i18 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(956488494, i18, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:135)");
                    }
                    long j = m1606contentColorvNxB06k$material3_release2222;
                    TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer3, 6).getLabelLarge();
                    final PaddingValues paddingValues3 = contentPadding;
                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                    ProvideContentColorTextStyleKt.m2707ProvideContentColorTextStyle3JVO9M(j, labelLarge, ComposableLambdaKt.rememberComposableLambda(1327513942, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2.1
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

                        public final void invoke(Composer composer4, int i19) {
                            ComposerKt.sourceInformation(composer4, "C139@6632L406:Button.kt#uh7d8r");
                            if ((i19 & 3) != 2 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1327513942, i19, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:139)");
                                }
                                Modifier padding = PaddingKt.padding(SizeKt.m769defaultMinSizeVpY3zN4(Modifier.Companion, ButtonDefaults.INSTANCE.m1621getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1620getMinHeightD9Ej5fM()), PaddingValues.this);
                                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                                Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                ComposerKt.sourceInformationMarkerStart(composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), centerVertically, composer4, 54);
                                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, padding);
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
                                Updater.m3527setimpl(m3520constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer4, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                                function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
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
                    }, composer3, 54), composer3, RendererCapabilities.DECODER_SUPPORT_MASK);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }, startRestartGroup, 54), startRestartGroup, (i11 & 8078) | (234881024 & (i11 << 6)), 6, 64);
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        buttonColors4 = buttonColors2;
        buttonElevation3 = buttonElevation2;
        z5 = z4;
        shape4 = shape3;
        borderStroke3 = borderStroke2;
        mutableInteractionSource4 = mutableInteractionSource52222;
        paddingValues2 = contentPadding;
        modifier4 = modifier52222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedButton(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Object obj;
        int i4;
        boolean z2;
        Object obj2;
        Object obj3;
        Object obj4;
        int i5;
        Object obj5;
        int i6;
        int i7;
        int i8;
        Shape shape2;
        ButtonColors buttonColors2;
        ButtonElevation buttonElevation2;
        boolean z3;
        Shape shape3;
        Object obj6;
        MutableInteractionSource mutableInteractionSource2;
        PaddingValues paddingValues2;
        BorderStroke borderStroke2;
        Modifier modifier2;
        int i9;
        Composer composer2;
        final Modifier modifier3;
        final boolean z4;
        final Shape shape4;
        final ButtonColors buttonColors3;
        final ButtonElevation buttonElevation3;
        final BorderStroke borderStroke3;
        final PaddingValues paddingValues3;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i10;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(1466887385);
        ComposerKt.sourceInformation(startRestartGroup, "C(ElevatedButton)P(8,7,5,9,1,4!1,3,6)204@9975L13,205@10032L22,206@10105L25,212@10343L314:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i13 = i2 & 2;
        if (i13 != 0) {
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
                            i12 = 2048;
                            i3 |= i12;
                        }
                    } else {
                        obj2 = shape;
                    }
                    i12 = 1024;
                    i3 |= i12;
                } else {
                    obj2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        obj3 = buttonColors;
                        if (startRestartGroup.changed(obj3)) {
                            i11 = 16384;
                            i3 |= i11;
                        }
                    } else {
                        obj3 = buttonColors;
                    }
                    i11 = 8192;
                    i3 |= i11;
                } else {
                    obj3 = buttonColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        obj4 = buttonElevation;
                        if (startRestartGroup.changed(obj4)) {
                            i10 = 131072;
                            i3 |= i10;
                        }
                    } else {
                        obj4 = buttonElevation;
                    }
                    i10 = 65536;
                    i3 |= i10;
                } else {
                    obj4 = buttonElevation;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else if ((1572864 & i) == 0) {
                    obj5 = borderStroke;
                    i3 |= startRestartGroup.changed(obj5) ? 1048576 : 524288;
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i8 = i7;
                        i3 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        if ((i2 & 512) != 0) {
                            i3 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i3 |= startRestartGroup.changedInstance(function3) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                            if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i13 == 0 ? Modifier.Companion : obj;
                                    boolean z5 = i4 == 0 ? true : z2;
                                    if ((i2 & 8) == 0) {
                                        i3 &= -7169;
                                        shape2 = ButtonDefaults.INSTANCE.getElevatedShape(startRestartGroup, 6);
                                    } else {
                                        shape2 = obj2;
                                    }
                                    if ((i2 & 16) == 0) {
                                        i3 &= -57345;
                                        buttonColors2 = ButtonDefaults.INSTANCE.elevatedButtonColors(startRestartGroup, 6);
                                    } else {
                                        buttonColors2 = obj3;
                                    }
                                    int i14 = i3;
                                    if ((i2 & 32) == 0) {
                                        obj4 = ButtonDefaults.INSTANCE.m1615elevatedButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                        i3 = i14 & (-458753);
                                    } else {
                                        i3 = i14;
                                    }
                                    if (i5 != 0) {
                                        obj5 = null;
                                    }
                                    PaddingValues contentPadding = i6 == 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                    buttonElevation2 = obj4;
                                    z3 = z5;
                                    shape3 = shape2;
                                    if (i8 == 0) {
                                        obj6 = buttonColors2;
                                        mutableInteractionSource2 = null;
                                    } else {
                                        obj6 = buttonColors2;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                    }
                                    paddingValues2 = contentPadding;
                                    borderStroke2 = obj5;
                                    modifier2 = companion;
                                    i9 = 1466887385;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                    }
                                    if ((i2 & 32) != 0) {
                                        i3 &= -458753;
                                    }
                                    paddingValues2 = paddingValues;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    z3 = z2;
                                    shape3 = obj2;
                                    obj6 = obj3;
                                    buttonElevation2 = obj4;
                                    borderStroke2 = obj5;
                                    i9 = 1466887385;
                                    modifier2 = obj;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i9, i3, -1, "androidx.compose.material3.ElevatedButton (Button.kt:212)");
                                }
                                Button(function02, modifier2, z3, shape3, obj6, buttonElevation2, borderStroke2, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer2 = startRestartGroup;
                                modifier3 = modifier2;
                                z4 = z3;
                                shape4 = shape3;
                                buttonColors3 = obj6;
                                buttonElevation3 = buttonElevation2;
                                borderStroke3 = borderStroke2;
                                paddingValues3 = paddingValues2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier3 = obj;
                                z4 = z2;
                                shape4 = obj2;
                                composer2 = startRestartGroup;
                                buttonColors3 = obj3;
                                buttonElevation3 = obj4;
                                borderStroke3 = obj5;
                                paddingValues3 = paddingValues;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$ElevatedButton$1
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

                                    public final void invoke(Composer composer3, int i15) {
                                        ButtonKt.ElevatedButton(function0, modifier3, z4, shape4, buttonColors3, buttonElevation3, borderStroke3, paddingValues3, mutableInteractionSource3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
                        if (i13 == 0) {
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 8) == 0) {
                        }
                        if ((i2 & 16) == 0) {
                        }
                        int i142 = i3;
                        if ((i2 & 32) == 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 == 0) {
                        }
                        buttonElevation2 = obj4;
                        z3 = z5;
                        shape3 = shape2;
                        if (i8 == 0) {
                        }
                        paddingValues2 = contentPadding;
                        borderStroke2 = obj5;
                        modifier2 = companion;
                        i9 = 1466887385;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        Button(function02, modifier2, z3, shape3, obj6, buttonElevation2, borderStroke2, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = startRestartGroup;
                        modifier3 = modifier2;
                        z4 = z3;
                        shape4 = shape3;
                        buttonColors3 = obj6;
                        buttonElevation3 = buttonElevation2;
                        borderStroke3 = borderStroke2;
                        paddingValues3 = paddingValues2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i8 = i7;
                    if ((i2 & 512) != 0) {
                    }
                    if ((i3 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i13 == 0) {
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 8) == 0) {
                    }
                    if ((i2 & 16) == 0) {
                    }
                    int i1422 = i3;
                    if ((i2 & 32) == 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 == 0) {
                    }
                    buttonElevation2 = obj4;
                    z3 = z5;
                    shape3 = shape2;
                    if (i8 == 0) {
                    }
                    paddingValues2 = contentPadding;
                    borderStroke2 = obj5;
                    modifier2 = companion;
                    i9 = 1466887385;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Button(function02, modifier2, z3, shape3, obj6, buttonElevation2, borderStroke2, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    modifier3 = modifier2;
                    z4 = z3;
                    shape4 = shape3;
                    buttonColors3 = obj6;
                    buttonElevation3 = buttonElevation2;
                    borderStroke3 = borderStroke2;
                    paddingValues3 = paddingValues2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj5 = borderStroke;
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                i8 = i7;
                if ((i2 & 512) != 0) {
                }
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i13 == 0) {
                }
                if (i4 == 0) {
                }
                if ((i2 & 8) == 0) {
                }
                if ((i2 & 16) == 0) {
                }
                int i14222 = i3;
                if ((i2 & 32) == 0) {
                }
                if (i5 != 0) {
                }
                if (i6 == 0) {
                }
                buttonElevation2 = obj4;
                z3 = z5;
                shape3 = shape2;
                if (i8 == 0) {
                }
                paddingValues2 = contentPadding;
                borderStroke2 = obj5;
                modifier2 = companion;
                i9 = 1466887385;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                Button(function02, modifier2, z3, shape3, obj6, buttonElevation2, borderStroke2, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                modifier3 = modifier2;
                z4 = z3;
                shape4 = shape3;
                buttonColors3 = obj6;
                buttonElevation3 = buttonElevation2;
                borderStroke3 = borderStroke2;
                paddingValues3 = paddingValues2;
                mutableInteractionSource3 = mutableInteractionSource2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            obj5 = borderStroke;
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            i8 = i7;
            if ((i2 & 512) != 0) {
            }
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i13 == 0) {
            }
            if (i4 == 0) {
            }
            if ((i2 & 8) == 0) {
            }
            if ((i2 & 16) == 0) {
            }
            int i142222 = i3;
            if ((i2 & 32) == 0) {
            }
            if (i5 != 0) {
            }
            if (i6 == 0) {
            }
            buttonElevation2 = obj4;
            z3 = z5;
            shape3 = shape2;
            if (i8 == 0) {
            }
            paddingValues2 = contentPadding;
            borderStroke2 = obj5;
            modifier2 = companion;
            i9 = 1466887385;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            Button(function02, modifier2, z3, shape3, obj6, buttonElevation2, borderStroke2, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            modifier3 = modifier2;
            z4 = z3;
            shape4 = shape3;
            buttonColors3 = obj6;
            buttonElevation3 = buttonElevation2;
            borderStroke3 = borderStroke2;
            paddingValues3 = paddingValues2;
            mutableInteractionSource3 = mutableInteractionSource2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
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
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        obj5 = borderStroke;
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        i8 = i7;
        if ((i2 & 512) != 0) {
        }
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i13 == 0) {
        }
        if (i4 == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        int i1422222 = i3;
        if ((i2 & 32) == 0) {
        }
        if (i5 != 0) {
        }
        if (i6 == 0) {
        }
        buttonElevation2 = obj4;
        z3 = z5;
        shape3 = shape2;
        if (i8 == 0) {
        }
        paddingValues2 = contentPadding;
        borderStroke2 = obj5;
        modifier2 = companion;
        i9 = 1466887385;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Button(function02, modifier2, z3, shape3, obj6, buttonElevation2, borderStroke2, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        modifier3 = modifier2;
        z4 = z3;
        shape4 = shape3;
        buttonColors3 = obj6;
        buttonElevation3 = buttonElevation2;
        borderStroke3 = borderStroke2;
        paddingValues3 = paddingValues2;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilledTonalButton(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Object obj;
        int i4;
        boolean z2;
        Object obj2;
        Object obj3;
        Object obj4;
        int i5;
        Object obj5;
        int i6;
        int i7;
        int i8;
        Shape shape2;
        ButtonColors buttonColors2;
        ButtonElevation buttonElevation2;
        boolean z3;
        Shape shape3;
        Object obj6;
        MutableInteractionSource mutableInteractionSource2;
        PaddingValues paddingValues2;
        BorderStroke borderStroke2;
        Modifier modifier2;
        int i9;
        Composer composer2;
        final Modifier modifier3;
        final boolean z4;
        final Shape shape4;
        final ButtonColors buttonColors3;
        final ButtonElevation buttonElevation3;
        final BorderStroke borderStroke3;
        final PaddingValues paddingValues3;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i10;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(-1717924381);
        ComposerKt.sourceInformation(startRestartGroup, "C(FilledTonalButton)P(8,7,5,9,1,4!1,3,6)277@13636L16,278@13696L25,279@13772L28,285@14013L314:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i13 = i2 & 2;
        if (i13 != 0) {
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
                            i12 = 2048;
                            i3 |= i12;
                        }
                    } else {
                        obj2 = shape;
                    }
                    i12 = 1024;
                    i3 |= i12;
                } else {
                    obj2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        obj3 = buttonColors;
                        if (startRestartGroup.changed(obj3)) {
                            i11 = 16384;
                            i3 |= i11;
                        }
                    } else {
                        obj3 = buttonColors;
                    }
                    i11 = 8192;
                    i3 |= i11;
                } else {
                    obj3 = buttonColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        obj4 = buttonElevation;
                        if (startRestartGroup.changed(obj4)) {
                            i10 = 131072;
                            i3 |= i10;
                        }
                    } else {
                        obj4 = buttonElevation;
                    }
                    i10 = 65536;
                    i3 |= i10;
                } else {
                    obj4 = buttonElevation;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else if ((1572864 & i) == 0) {
                    obj5 = borderStroke;
                    i3 |= startRestartGroup.changed(obj5) ? 1048576 : 524288;
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i8 = i7;
                        i3 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        if ((i2 & 512) != 0) {
                            i3 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i3 |= startRestartGroup.changedInstance(function3) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                            if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i13 == 0 ? Modifier.Companion : obj;
                                    boolean z5 = i4 == 0 ? true : z2;
                                    if ((i2 & 8) == 0) {
                                        i3 &= -7169;
                                        shape2 = ButtonDefaults.INSTANCE.getFilledTonalShape(startRestartGroup, 6);
                                    } else {
                                        shape2 = obj2;
                                    }
                                    if ((i2 & 16) == 0) {
                                        i3 &= -57345;
                                        buttonColors2 = ButtonDefaults.INSTANCE.filledTonalButtonColors(startRestartGroup, 6);
                                    } else {
                                        buttonColors2 = obj3;
                                    }
                                    int i14 = i3;
                                    if ((i2 & 32) == 0) {
                                        obj4 = ButtonDefaults.INSTANCE.m1617filledTonalButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                        i3 = i14 & (-458753);
                                    } else {
                                        i3 = i14;
                                    }
                                    if (i5 != 0) {
                                        obj5 = null;
                                    }
                                    PaddingValues contentPadding = i6 == 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                    buttonElevation2 = obj4;
                                    z3 = z5;
                                    shape3 = shape2;
                                    if (i8 == 0) {
                                        obj6 = buttonColors2;
                                        mutableInteractionSource2 = null;
                                    } else {
                                        obj6 = buttonColors2;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                    }
                                    paddingValues2 = contentPadding;
                                    borderStroke2 = obj5;
                                    modifier2 = companion;
                                    i9 = -1717924381;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                    }
                                    if ((i2 & 32) != 0) {
                                        i3 &= -458753;
                                    }
                                    paddingValues2 = paddingValues;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    z3 = z2;
                                    shape3 = obj2;
                                    obj6 = obj3;
                                    buttonElevation2 = obj4;
                                    borderStroke2 = obj5;
                                    i9 = -1717924381;
                                    modifier2 = obj;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i9, i3, -1, "androidx.compose.material3.FilledTonalButton (Button.kt:285)");
                                }
                                Button(function02, modifier2, z3, shape3, obj6, buttonElevation2, borderStroke2, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer2 = startRestartGroup;
                                modifier3 = modifier2;
                                z4 = z3;
                                shape4 = shape3;
                                buttonColors3 = obj6;
                                buttonElevation3 = buttonElevation2;
                                borderStroke3 = borderStroke2;
                                paddingValues3 = paddingValues2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier3 = obj;
                                z4 = z2;
                                shape4 = obj2;
                                composer2 = startRestartGroup;
                                buttonColors3 = obj3;
                                buttonElevation3 = obj4;
                                borderStroke3 = obj5;
                                paddingValues3 = paddingValues;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$FilledTonalButton$1
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

                                    public final void invoke(Composer composer3, int i15) {
                                        ButtonKt.FilledTonalButton(function0, modifier3, z4, shape4, buttonColors3, buttonElevation3, borderStroke3, paddingValues3, mutableInteractionSource3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
                        if (i13 == 0) {
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 8) == 0) {
                        }
                        if ((i2 & 16) == 0) {
                        }
                        int i142 = i3;
                        if ((i2 & 32) == 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 == 0) {
                        }
                        buttonElevation2 = obj4;
                        z3 = z5;
                        shape3 = shape2;
                        if (i8 == 0) {
                        }
                        paddingValues2 = contentPadding;
                        borderStroke2 = obj5;
                        modifier2 = companion;
                        i9 = -1717924381;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        Button(function02, modifier2, z3, shape3, obj6, buttonElevation2, borderStroke2, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = startRestartGroup;
                        modifier3 = modifier2;
                        z4 = z3;
                        shape4 = shape3;
                        buttonColors3 = obj6;
                        buttonElevation3 = buttonElevation2;
                        borderStroke3 = borderStroke2;
                        paddingValues3 = paddingValues2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i8 = i7;
                    if ((i2 & 512) != 0) {
                    }
                    if ((i3 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i13 == 0) {
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 8) == 0) {
                    }
                    if ((i2 & 16) == 0) {
                    }
                    int i1422 = i3;
                    if ((i2 & 32) == 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 == 0) {
                    }
                    buttonElevation2 = obj4;
                    z3 = z5;
                    shape3 = shape2;
                    if (i8 == 0) {
                    }
                    paddingValues2 = contentPadding;
                    borderStroke2 = obj5;
                    modifier2 = companion;
                    i9 = -1717924381;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Button(function02, modifier2, z3, shape3, obj6, buttonElevation2, borderStroke2, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    modifier3 = modifier2;
                    z4 = z3;
                    shape4 = shape3;
                    buttonColors3 = obj6;
                    buttonElevation3 = buttonElevation2;
                    borderStroke3 = borderStroke2;
                    paddingValues3 = paddingValues2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj5 = borderStroke;
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                i8 = i7;
                if ((i2 & 512) != 0) {
                }
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i13 == 0) {
                }
                if (i4 == 0) {
                }
                if ((i2 & 8) == 0) {
                }
                if ((i2 & 16) == 0) {
                }
                int i14222 = i3;
                if ((i2 & 32) == 0) {
                }
                if (i5 != 0) {
                }
                if (i6 == 0) {
                }
                buttonElevation2 = obj4;
                z3 = z5;
                shape3 = shape2;
                if (i8 == 0) {
                }
                paddingValues2 = contentPadding;
                borderStroke2 = obj5;
                modifier2 = companion;
                i9 = -1717924381;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                Button(function02, modifier2, z3, shape3, obj6, buttonElevation2, borderStroke2, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                modifier3 = modifier2;
                z4 = z3;
                shape4 = shape3;
                buttonColors3 = obj6;
                buttonElevation3 = buttonElevation2;
                borderStroke3 = borderStroke2;
                paddingValues3 = paddingValues2;
                mutableInteractionSource3 = mutableInteractionSource2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            obj5 = borderStroke;
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            i8 = i7;
            if ((i2 & 512) != 0) {
            }
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i13 == 0) {
            }
            if (i4 == 0) {
            }
            if ((i2 & 8) == 0) {
            }
            if ((i2 & 16) == 0) {
            }
            int i142222 = i3;
            if ((i2 & 32) == 0) {
            }
            if (i5 != 0) {
            }
            if (i6 == 0) {
            }
            buttonElevation2 = obj4;
            z3 = z5;
            shape3 = shape2;
            if (i8 == 0) {
            }
            paddingValues2 = contentPadding;
            borderStroke2 = obj5;
            modifier2 = companion;
            i9 = -1717924381;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            Button(function02, modifier2, z3, shape3, obj6, buttonElevation2, borderStroke2, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            modifier3 = modifier2;
            z4 = z3;
            shape4 = shape3;
            buttonColors3 = obj6;
            buttonElevation3 = buttonElevation2;
            borderStroke3 = borderStroke2;
            paddingValues3 = paddingValues2;
            mutableInteractionSource3 = mutableInteractionSource2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
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
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        obj5 = borderStroke;
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        i8 = i7;
        if ((i2 & 512) != 0) {
        }
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i13 == 0) {
        }
        if (i4 == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        int i1422222 = i3;
        if ((i2 & 32) == 0) {
        }
        if (i5 != 0) {
        }
        if (i6 == 0) {
        }
        buttonElevation2 = obj4;
        z3 = z5;
        shape3 = shape2;
        if (i8 == 0) {
        }
        paddingValues2 = contentPadding;
        borderStroke2 = obj5;
        modifier2 = companion;
        i9 = -1717924381;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Button(function02, modifier2, z3, shape3, obj6, buttonElevation2, borderStroke2, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        modifier3 = modifier2;
        z4 = z3;
        shape4 = shape3;
        buttonColors3 = obj6;
        buttonElevation3 = buttonElevation2;
        borderStroke3 = borderStroke2;
        paddingValues3 = paddingValues2;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedButton(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier.Companion companion;
        int i4;
        boolean z2;
        Object obj;
        Object obj2;
        int i5;
        Object obj3;
        Object obj4;
        int i6;
        int i7;
        int i8;
        BorderStroke borderStroke2;
        MutableInteractionSource mutableInteractionSource2;
        PaddingValues paddingValues2;
        Modifier modifier2;
        BorderStroke borderStroke3;
        boolean z3;
        Shape shape2;
        ButtonColors buttonColors2;
        ButtonElevation buttonElevation2;
        int i9;
        Composer composer2;
        final Modifier modifier3;
        final boolean z4;
        final Shape shape3;
        final ButtonColors buttonColors3;
        final ButtonElevation buttonElevation3;
        final BorderStroke borderStroke4;
        final PaddingValues paddingValues3;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i10;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(-1694808287);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedButton)P(8,7,5,9,1,4!1,3,6)349@17203L13,350@17260L22,352@17367L29,357@17575L314:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i13 = i2 & 2;
        if (i13 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        obj = shape;
                        if (startRestartGroup.changed(obj)) {
                            i12 = 2048;
                            i3 |= i12;
                        }
                    } else {
                        obj = shape;
                    }
                    i12 = 1024;
                    i3 |= i12;
                } else {
                    obj = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        obj2 = buttonColors;
                        if (startRestartGroup.changed(obj2)) {
                            i11 = 16384;
                            i3 |= i11;
                        }
                    } else {
                        obj2 = buttonColors;
                    }
                    i11 = 8192;
                    i3 |= i11;
                } else {
                    obj2 = buttonColors;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    obj3 = buttonElevation;
                    i3 |= startRestartGroup.changed(obj3) ? 131072 : 65536;
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            obj4 = borderStroke;
                            if (startRestartGroup.changed(obj4)) {
                                i10 = 1048576;
                                i3 |= i10;
                            }
                        } else {
                            obj4 = borderStroke;
                        }
                        i10 = 524288;
                        i3 |= i10;
                    } else {
                        obj4 = borderStroke;
                    }
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i8 = i7;
                        i3 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        if ((i2 & 512) != 0) {
                            i3 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i3 |= startRestartGroup.changedInstance(function3) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                            if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i13 != 0) {
                                        companion = Modifier.Companion;
                                    }
                                    if (i4 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                        obj = ButtonDefaults.INSTANCE.getOutlinedShape(startRestartGroup, 6);
                                    }
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                        obj2 = ButtonDefaults.INSTANCE.outlinedButtonColors(startRestartGroup, 6);
                                    }
                                    if (i5 != 0) {
                                        obj3 = null;
                                    }
                                    if ((i2 & 64) == 0) {
                                        borderStroke2 = ButtonDefaults.INSTANCE.outlinedButtonBorder(z2, startRestartGroup, ((i3 >> 6) & 14) | 48, 0);
                                        i3 &= -3670017;
                                    } else {
                                        borderStroke2 = obj4;
                                    }
                                    PaddingValues contentPadding = i6 == 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                    mutableInteractionSource2 = i8 == 0 ? null : mutableInteractionSource;
                                    paddingValues2 = contentPadding;
                                    modifier2 = companion;
                                    borderStroke3 = borderStroke2;
                                    z3 = z2;
                                    shape2 = obj;
                                    buttonColors2 = obj2;
                                    buttonElevation2 = obj3;
                                    i9 = -1694808287;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i3 &= -3670017;
                                    }
                                    paddingValues2 = paddingValues;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    z3 = z2;
                                    shape2 = obj;
                                    buttonColors2 = obj2;
                                    buttonElevation2 = obj3;
                                    borderStroke3 = obj4;
                                    i9 = -1694808287;
                                    modifier2 = companion;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i9, i3, -1, "androidx.compose.material3.OutlinedButton (Button.kt:357)");
                                }
                                composer2 = startRestartGroup;
                                Button(function02, modifier2, z3, shape2, buttonColors2, buttonElevation2, borderStroke3, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier2;
                                z4 = z3;
                                shape3 = shape2;
                                buttonColors3 = buttonColors2;
                                buttonElevation3 = buttonElevation2;
                                borderStroke4 = borderStroke3;
                                paddingValues3 = paddingValues2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                mutableInteractionSource3 = mutableInteractionSource;
                                composer2 = startRestartGroup;
                                modifier3 = companion;
                                z4 = z2;
                                shape3 = obj;
                                buttonColors3 = obj2;
                                buttonElevation3 = obj3;
                                borderStroke4 = obj4;
                                paddingValues3 = paddingValues;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$OutlinedButton$1
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

                                    public final void invoke(Composer composer3, int i14) {
                                        ButtonKt.OutlinedButton(function0, modifier3, z4, shape3, buttonColors3, buttonElevation3, borderStroke4, paddingValues3, mutableInteractionSource3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
                        if (i13 != 0) {
                        }
                        if (i4 != 0) {
                        }
                        if ((i2 & 8) != 0) {
                        }
                        if ((i2 & 16) != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if ((i2 & 64) == 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i8 == 0) {
                        }
                        paddingValues2 = contentPadding;
                        modifier2 = companion;
                        borderStroke3 = borderStroke2;
                        z3 = z2;
                        shape2 = obj;
                        buttonColors2 = obj2;
                        buttonElevation2 = obj3;
                        i9 = -1694808287;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = startRestartGroup;
                        Button(function02, modifier2, z3, shape2, buttonColors2, buttonElevation2, borderStroke3, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier2;
                        z4 = z3;
                        shape3 = shape2;
                        buttonColors3 = buttonColors2;
                        buttonElevation3 = buttonElevation2;
                        borderStroke4 = borderStroke3;
                        paddingValues3 = paddingValues2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i8 = i7;
                    if ((i2 & 512) != 0) {
                    }
                    if ((i3 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if ((i2 & 8) != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 64) == 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i8 == 0) {
                    }
                    paddingValues2 = contentPadding;
                    modifier2 = companion;
                    borderStroke3 = borderStroke2;
                    z3 = z2;
                    shape2 = obj;
                    buttonColors2 = obj2;
                    buttonElevation2 = obj3;
                    i9 = -1694808287;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    Button(function02, modifier2, z3, shape2, buttonColors2, buttonElevation2, borderStroke3, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier2;
                    z4 = z3;
                    shape3 = shape2;
                    buttonColors3 = buttonColors2;
                    buttonElevation3 = buttonElevation2;
                    borderStroke4 = borderStroke3;
                    paddingValues3 = paddingValues2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj3 = buttonElevation;
                if ((1572864 & i) != 0) {
                }
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                i8 = i7;
                if ((i2 & 512) != 0) {
                }
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i13 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 64) == 0) {
                }
                if (i6 == 0) {
                }
                if (i8 == 0) {
                }
                paddingValues2 = contentPadding;
                modifier2 = companion;
                borderStroke3 = borderStroke2;
                z3 = z2;
                shape2 = obj;
                buttonColors2 = obj2;
                buttonElevation2 = obj3;
                i9 = -1694808287;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                Button(function02, modifier2, z3, shape2, buttonColors2, buttonElevation2, borderStroke3, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier2;
                z4 = z3;
                shape3 = shape2;
                buttonColors3 = buttonColors2;
                buttonElevation3 = buttonElevation2;
                borderStroke4 = borderStroke3;
                paddingValues3 = paddingValues2;
                mutableInteractionSource3 = mutableInteractionSource2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            obj3 = buttonElevation;
            if ((1572864 & i) != 0) {
            }
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            i8 = i7;
            if ((i2 & 512) != 0) {
            }
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i13 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 64) == 0) {
            }
            if (i6 == 0) {
            }
            if (i8 == 0) {
            }
            paddingValues2 = contentPadding;
            modifier2 = companion;
            borderStroke3 = borderStroke2;
            z3 = z2;
            shape2 = obj;
            buttonColors2 = obj2;
            buttonElevation2 = obj3;
            i9 = -1694808287;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            Button(function02, modifier2, z3, shape2, buttonColors2, buttonElevation2, borderStroke3, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            z4 = z3;
            shape3 = shape2;
            buttonColors3 = buttonColors2;
            buttonElevation3 = buttonElevation2;
            borderStroke4 = borderStroke3;
            paddingValues3 = paddingValues2;
            mutableInteractionSource3 = mutableInteractionSource2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        companion = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        obj3 = buttonElevation;
        if ((1572864 & i) != 0) {
        }
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        i8 = i7;
        if ((i2 & 512) != 0) {
        }
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i13 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if (i6 == 0) {
        }
        if (i8 == 0) {
        }
        paddingValues2 = contentPadding;
        modifier2 = companion;
        borderStroke3 = borderStroke2;
        z3 = z2;
        shape2 = obj;
        buttonColors2 = obj2;
        buttonElevation2 = obj3;
        i9 = -1694808287;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        Button(function02, modifier2, z3, shape2, buttonColors2, buttonElevation2, borderStroke3, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        z4 = z3;
        shape3 = shape2;
        buttonColors3 = buttonColors2;
        buttonElevation3 = buttonElevation2;
        borderStroke4 = borderStroke3;
        paddingValues3 = paddingValues2;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextButton(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier.Companion companion;
        int i4;
        boolean z2;
        Object obj;
        Object obj2;
        int i5;
        Object obj3;
        int i6;
        Object obj4;
        int i7;
        int i8;
        int i9;
        int i10;
        MutableInteractionSource mutableInteractionSource2;
        PaddingValues paddingValues2;
        Composer composer2;
        final Modifier modifier2;
        final boolean z3;
        final Shape shape2;
        final ButtonColors buttonColors2;
        final ButtonElevation buttonElevation2;
        final BorderStroke borderStroke2;
        final PaddingValues paddingValues3;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(-2106428362);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextButton)P(8,7,5,9,1,4!1,3,6)422@20900L9,423@20953L18,430@21234L314:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i13 = i2 & 2;
        if (i13 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        obj = shape;
                        if (startRestartGroup.changed(obj)) {
                            i12 = 2048;
                            i3 |= i12;
                        }
                    } else {
                        obj = shape;
                    }
                    i12 = 1024;
                    i3 |= i12;
                } else {
                    obj = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        obj2 = buttonColors;
                        if (startRestartGroup.changed(obj2)) {
                            i11 = 16384;
                            i3 |= i11;
                        }
                    } else {
                        obj2 = buttonColors;
                    }
                    i11 = 8192;
                    i3 |= i11;
                } else {
                    obj2 = buttonColors;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    obj3 = buttonElevation;
                    i3 |= startRestartGroup.changed(obj3) ? 131072 : 65536;
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        obj4 = borderStroke;
                        i3 |= startRestartGroup.changed(obj4) ? 1048576 : 524288;
                        i7 = i2 & 128;
                        if (i7 != 0) {
                            i3 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i8 = i7;
                            i3 |= startRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                            i9 = i2 & 256;
                            if (i9 == 0) {
                                i3 |= 100663296;
                            } else if ((i & 100663296) == 0) {
                                i10 = i9;
                                i3 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                                if ((i2 & 512) != 0) {
                                    i3 |= 805306368;
                                } else if ((i & 805306368) == 0) {
                                    i3 |= startRestartGroup.changedInstance(function3) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                                    if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                                        startRestartGroup.startDefaults();
                                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                            if (i13 != 0) {
                                                companion = Modifier.Companion;
                                            }
                                            if (i4 != 0) {
                                                z2 = true;
                                            }
                                            if ((i2 & 8) != 0) {
                                                i3 &= -7169;
                                                obj = ButtonDefaults.INSTANCE.getTextShape(startRestartGroup, 6);
                                            }
                                            if ((i2 & 16) != 0) {
                                                i3 &= -57345;
                                                obj2 = ButtonDefaults.INSTANCE.textButtonColors(startRestartGroup, 6);
                                            }
                                            if (i5 != 0) {
                                                obj3 = null;
                                            }
                                            if (i6 != 0) {
                                                obj4 = null;
                                            }
                                            PaddingValues textButtonContentPadding = i8 == 0 ? ButtonDefaults.INSTANCE.getTextButtonContentPadding() : paddingValues;
                                            mutableInteractionSource2 = i10 == 0 ? null : mutableInteractionSource;
                                            paddingValues2 = textButtonContentPadding;
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            if ((i2 & 8) != 0) {
                                                i3 &= -7169;
                                            }
                                            if ((i2 & 16) != 0) {
                                                i3 &= -57345;
                                            }
                                            paddingValues2 = paddingValues;
                                            mutableInteractionSource2 = mutableInteractionSource;
                                        }
                                        Modifier modifier3 = companion;
                                        Shape shape3 = obj;
                                        ButtonColors buttonColors3 = obj2;
                                        ButtonElevation buttonElevation3 = obj3;
                                        BorderStroke borderStroke3 = obj4;
                                        boolean z4 = z2;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2106428362, i3, -1, "androidx.compose.material3.TextButton (Button.kt:430)");
                                        }
                                        composer2 = startRestartGroup;
                                        Button(function02, modifier3, z4, shape3, buttonColors3, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        modifier2 = modifier3;
                                        z3 = z4;
                                        shape2 = shape3;
                                        buttonColors2 = buttonColors3;
                                        buttonElevation2 = buttonElevation3;
                                        borderStroke2 = borderStroke3;
                                        paddingValues3 = paddingValues2;
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        composer2 = startRestartGroup;
                                        modifier2 = companion;
                                        z3 = z2;
                                        shape2 = obj;
                                        buttonColors2 = obj2;
                                        buttonElevation2 = obj3;
                                        borderStroke2 = obj4;
                                        paddingValues3 = paddingValues;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup == null) {
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$TextButton$1
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

                                            public final void invoke(Composer composer3, int i14) {
                                                ButtonKt.TextButton(function0, modifier2, z3, shape2, buttonColors2, buttonElevation2, borderStroke2, paddingValues3, mutableInteractionSource3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
                                if (i13 != 0) {
                                }
                                if (i4 != 0) {
                                }
                                if ((i2 & 8) != 0) {
                                }
                                if ((i2 & 16) != 0) {
                                }
                                if (i5 != 0) {
                                }
                                if (i6 != 0) {
                                }
                                if (i8 == 0) {
                                }
                                if (i10 == 0) {
                                }
                                paddingValues2 = textButtonContentPadding;
                                Modifier modifier32 = companion;
                                Shape shape32 = obj;
                                ButtonColors buttonColors32 = obj2;
                                ButtonElevation buttonElevation32 = obj3;
                                BorderStroke borderStroke32 = obj4;
                                boolean z42 = z2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                composer2 = startRestartGroup;
                                Button(function02, modifier32, z42, shape32, buttonColors32, buttonElevation32, borderStroke32, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                modifier2 = modifier32;
                                z3 = z42;
                                shape2 = shape32;
                                buttonColors2 = buttonColors32;
                                buttonElevation2 = buttonElevation32;
                                borderStroke2 = borderStroke32;
                                paddingValues3 = paddingValues2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                }
                            }
                            i10 = i9;
                            if ((i2 & 512) != 0) {
                            }
                            if ((i3 & 306783379) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                            }
                            if (i13 != 0) {
                            }
                            if (i4 != 0) {
                            }
                            if ((i2 & 8) != 0) {
                            }
                            if ((i2 & 16) != 0) {
                            }
                            if (i5 != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if (i8 == 0) {
                            }
                            if (i10 == 0) {
                            }
                            paddingValues2 = textButtonContentPadding;
                            Modifier modifier322 = companion;
                            Shape shape322 = obj;
                            ButtonColors buttonColors322 = obj2;
                            ButtonElevation buttonElevation322 = obj3;
                            BorderStroke borderStroke322 = obj4;
                            boolean z422 = z2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = startRestartGroup;
                            Button(function02, modifier322, z422, shape322, buttonColors322, buttonElevation322, borderStroke322, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier2 = modifier322;
                            z3 = z422;
                            shape2 = shape322;
                            buttonColors2 = buttonColors322;
                            buttonElevation2 = buttonElevation322;
                            borderStroke2 = borderStroke322;
                            paddingValues3 = paddingValues2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        i8 = i7;
                        i9 = i2 & 256;
                        if (i9 == 0) {
                        }
                        i10 = i9;
                        if ((i2 & 512) != 0) {
                        }
                        if ((i3 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i13 != 0) {
                        }
                        if (i4 != 0) {
                        }
                        if ((i2 & 8) != 0) {
                        }
                        if ((i2 & 16) != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (i10 == 0) {
                        }
                        paddingValues2 = textButtonContentPadding;
                        Modifier modifier3222 = companion;
                        Shape shape3222 = obj;
                        ButtonColors buttonColors3222 = obj2;
                        ButtonElevation buttonElevation3222 = obj3;
                        BorderStroke borderStroke3222 = obj4;
                        boolean z4222 = z2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = startRestartGroup;
                        Button(function02, modifier3222, z4222, shape3222, buttonColors3222, buttonElevation3222, borderStroke3222, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier2 = modifier3222;
                        z3 = z4222;
                        shape2 = shape3222;
                        buttonColors2 = buttonColors3222;
                        buttonElevation2 = buttonElevation3222;
                        borderStroke2 = borderStroke3222;
                        paddingValues3 = paddingValues2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    obj4 = borderStroke;
                    i7 = i2 & 128;
                    if (i7 != 0) {
                    }
                    i8 = i7;
                    i9 = i2 & 256;
                    if (i9 == 0) {
                    }
                    i10 = i9;
                    if ((i2 & 512) != 0) {
                    }
                    if ((i3 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if ((i2 & 8) != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i10 == 0) {
                    }
                    paddingValues2 = textButtonContentPadding;
                    Modifier modifier32222 = companion;
                    Shape shape32222 = obj;
                    ButtonColors buttonColors32222 = obj2;
                    ButtonElevation buttonElevation32222 = obj3;
                    BorderStroke borderStroke32222 = obj4;
                    boolean z42222 = z2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    Button(function02, modifier32222, z42222, shape32222, buttonColors32222, buttonElevation32222, borderStroke32222, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier2 = modifier32222;
                    z3 = z42222;
                    shape2 = shape32222;
                    buttonColors2 = buttonColors32222;
                    buttonElevation2 = buttonElevation32222;
                    borderStroke2 = borderStroke32222;
                    paddingValues3 = paddingValues2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj3 = buttonElevation;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                obj4 = borderStroke;
                i7 = i2 & 128;
                if (i7 != 0) {
                }
                i8 = i7;
                i9 = i2 & 256;
                if (i9 == 0) {
                }
                i10 = i9;
                if ((i2 & 512) != 0) {
                }
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i13 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i8 == 0) {
                }
                if (i10 == 0) {
                }
                paddingValues2 = textButtonContentPadding;
                Modifier modifier322222 = companion;
                Shape shape322222 = obj;
                ButtonColors buttonColors322222 = obj2;
                ButtonElevation buttonElevation322222 = obj3;
                BorderStroke borderStroke322222 = obj4;
                boolean z422222 = z2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                Button(function02, modifier322222, z422222, shape322222, buttonColors322222, buttonElevation322222, borderStroke322222, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = modifier322222;
                z3 = z422222;
                shape2 = shape322222;
                buttonColors2 = buttonColors322222;
                buttonElevation2 = buttonElevation322222;
                borderStroke2 = borderStroke322222;
                paddingValues3 = paddingValues2;
                mutableInteractionSource3 = mutableInteractionSource2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            obj3 = buttonElevation;
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            obj4 = borderStroke;
            i7 = i2 & 128;
            if (i7 != 0) {
            }
            i8 = i7;
            i9 = i2 & 256;
            if (i9 == 0) {
            }
            i10 = i9;
            if ((i2 & 512) != 0) {
            }
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i13 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i8 == 0) {
            }
            if (i10 == 0) {
            }
            paddingValues2 = textButtonContentPadding;
            Modifier modifier3222222 = companion;
            Shape shape3222222 = obj;
            ButtonColors buttonColors3222222 = obj2;
            ButtonElevation buttonElevation3222222 = obj3;
            BorderStroke borderStroke3222222 = obj4;
            boolean z4222222 = z2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            Button(function02, modifier3222222, z4222222, shape3222222, buttonColors3222222, buttonElevation3222222, borderStroke3222222, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier3222222;
            z3 = z4222222;
            shape2 = shape3222222;
            buttonColors2 = buttonColors3222222;
            buttonElevation2 = buttonElevation3222222;
            borderStroke2 = borderStroke3222222;
            paddingValues3 = paddingValues2;
            mutableInteractionSource3 = mutableInteractionSource2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        companion = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        obj3 = buttonElevation;
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        obj4 = borderStroke;
        i7 = i2 & 128;
        if (i7 != 0) {
        }
        i8 = i7;
        i9 = i2 & 256;
        if (i9 == 0) {
        }
        i10 = i9;
        if ((i2 & 512) != 0) {
        }
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i13 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i8 == 0) {
        }
        if (i10 == 0) {
        }
        paddingValues2 = textButtonContentPadding;
        Modifier modifier32222222 = companion;
        Shape shape32222222 = obj;
        ButtonColors buttonColors32222222 = obj2;
        ButtonElevation buttonElevation32222222 = obj3;
        BorderStroke borderStroke32222222 = obj4;
        boolean z42222222 = z2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        Button(function02, modifier32222222, z42222222, shape32222222, buttonColors32222222, buttonElevation32222222, borderStroke32222222, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier32222222;
        z3 = z42222222;
        shape2 = shape32222222;
        buttonColors2 = buttonColors32222222;
        buttonElevation2 = buttonElevation32222222;
        borderStroke2 = borderStroke32222222;
        paddingValues3 = paddingValues2;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
