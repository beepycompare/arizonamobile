package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.InputTransformationKt;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextObfuscationMode;
import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* compiled from: BasicSecureTextField.kt */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aÊ\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u001328\b\u0002\u0010\u0014\u001a2\u0012\u0004\u0012\u00020\u0016\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0015¢\u0006\u0002\b\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001aÔ\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010(\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u001328\b\u0002\u0010\u0014\u001a2\u0012\u0004\u0012\u00020\u0016\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0015¢\u0006\u0002\b\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a \u0010+\u001a\u00020\u00052\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00050\u0017¢\u0006\u0002\b-H\u0003¢\u0006\u0002\u0010.\u001a\u001a\u0010/\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\r2\b\u00100\u001a\u0004\u0018\u00010\rH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"DefaultObfuscationCharacter", "", "LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS", "", "BasicSecureTextField", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "textObfuscationMode", "Landroidx/compose/foundation/text/input/TextObfuscationMode;", "textObfuscationCharacter", "BasicSecureTextField-Jb9bMDk", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ICLandroidx/compose/runtime/Composer;III)V", "readOnly", "BasicSecureTextField-egD4TGM", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ICLandroidx/compose/runtime/Composer;III)V", "DisableCutCopy", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "then", "next", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BasicSecureTextFieldKt {
    private static final char DefaultObfuscationCharacter = 8226;
    private static final long LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS = 1500;

    /* JADX WARN: Removed duplicated region for block: B:101:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:255:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0113  */
    /* renamed from: BasicSecureTextField-egD4TGM  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1040BasicSecureTextFieldegD4TGM(final TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2, MutableInteractionSource mutableInteractionSource, Brush brush, TextFieldDecorator textFieldDecorator, int i, char c, Composer composer, final int i2, final int i3, final int i4) {
        Object obj;
        int i5;
        Object obj2;
        int i6;
        boolean z3;
        int i7;
        boolean z4;
        int i8;
        Object obj3;
        int i9;
        Object obj4;
        int i10;
        Object obj5;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        final KeyboardActionHandler keyboardActionHandler2;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function22;
        final int i25;
        Composer composer2;
        final boolean z5;
        final boolean z6;
        final InputTransformation inputTransformation2;
        final Modifier modifier2;
        final MutableInteractionSource mutableInteractionSource2;
        final Brush brush2;
        final TextFieldDecorator textFieldDecorator2;
        final KeyboardOptions keyboardOptions2;
        final TextStyle textStyle2;
        final char c2;
        ScopeUpdateScope endRestartGroup;
        CodepointTransformation codepointTransformation;
        Modifier.Companion companion;
        Composer startRestartGroup = composer.startRestartGroup(-817513499);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicSecureTextField)P(10,6,2,9,3,13,5,7,8,4!2,12:c#foundation.text.input.TextObfuscationMode)134@7973L46,135@8056L60,136@8163L130,136@8121L172,147@8671L129,147@8632L168,154@8844L424,183@9940L852,183@9925L867:BasicSecureTextField.kt#423gt5");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
            obj = textFieldState;
        } else if ((i2 & 6) == 0) {
            obj = textFieldState;
            i5 = (startRestartGroup.changed(obj) ? 4 : 2) | i2;
        } else {
            obj = textFieldState;
            i5 = i2;
        }
        int i26 = i4 & 2;
        if (i26 != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            obj2 = modifier;
            i5 |= startRestartGroup.changed(obj2) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z3 = z;
                i5 |= startRestartGroup.changed(z3) ? 256 : 128;
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    z4 = z2;
                    i5 |= startRestartGroup.changed(z4) ? 2048 : 1024;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i2 & 24576) == 0) {
                        obj3 = inputTransformation;
                        i5 |= startRestartGroup.changed(obj3) ? 16384 : 8192;
                        i9 = i4 & 32;
                        if (i9 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            obj4 = textStyle;
                        } else {
                            obj4 = textStyle;
                            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i5 |= startRestartGroup.changed(obj4) ? 131072 : 65536;
                            }
                        }
                        i10 = i4 & 64;
                        if (i10 != 0) {
                            i5 |= 1572864;
                            obj5 = keyboardOptions;
                        } else {
                            obj5 = keyboardOptions;
                            if ((i2 & 1572864) == 0) {
                                i5 |= startRestartGroup.changed(obj5) ? 1048576 : 524288;
                            }
                        }
                        i11 = i4 & 128;
                        if (i11 != 0) {
                            i5 |= 12582912;
                        } else if ((i2 & 12582912) == 0) {
                            i12 = i11;
                            i5 |= startRestartGroup.changed(keyboardActionHandler) ? 8388608 : 4194304;
                            i13 = i4 & 256;
                            if (i13 == 0) {
                                i5 |= 100663296;
                            } else if ((i2 & 100663296) == 0) {
                                i14 = i13;
                                i5 |= startRestartGroup.changedInstance(function2) ? 67108864 : 33554432;
                                i15 = i4 & 512;
                                if (i15 != 0) {
                                    i5 |= 805306368;
                                } else if ((i2 & 805306368) == 0) {
                                    i16 = i15;
                                    i5 |= startRestartGroup.changed(mutableInteractionSource) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                                    i17 = i4 & 1024;
                                    if (i17 == 0) {
                                        i19 = i3 | 6;
                                        i18 = i17;
                                    } else if ((i3 & 6) == 0) {
                                        i18 = i17;
                                        i19 = i3 | (startRestartGroup.changed(brush) ? 4 : 2);
                                    } else {
                                        i18 = i17;
                                        i19 = i3;
                                    }
                                    i20 = i4 & 2048;
                                    if (i20 == 0) {
                                        i19 |= 48;
                                    } else if ((i3 & 48) == 0) {
                                        i19 |= (i3 & 64) == 0 ? startRestartGroup.changed(textFieldDecorator) : startRestartGroup.changedInstance(textFieldDecorator) ? 32 : 16;
                                    }
                                    int i27 = i19;
                                    i21 = i4 & 4096;
                                    if (i21 == 0) {
                                        i22 = i27 | RendererCapabilities.DECODER_SUPPORT_MASK;
                                    } else {
                                        int i28 = i27;
                                        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                            i28 |= startRestartGroup.changed(i) ? 256 : 128;
                                        }
                                        i22 = i28;
                                    }
                                    i23 = i4 & 8192;
                                    if (i23 == 0) {
                                        i24 = i22 | 3072;
                                    } else {
                                        int i29 = i22;
                                        if ((i3 & 3072) == 0) {
                                            i24 = i29 | (startRestartGroup.changed(c) ? 2048 : 1024);
                                        } else {
                                            i24 = i29;
                                        }
                                    }
                                    if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i24 & 1171) != 1170, i5 & 1)) {
                                        Modifier.Companion companion2 = i26 != 0 ? Modifier.Companion : obj2;
                                        final boolean z7 = i6 != 0 ? true : z3;
                                        final boolean z8 = i7 != 0 ? false : z4;
                                        final InputTransformation inputTransformation3 = i8 != 0 ? null : obj3;
                                        final TextStyle textStyle3 = i9 != 0 ? TextStyle.Companion.getDefault() : obj4;
                                        if (i10 != 0) {
                                            obj5 = KeyboardOptions.Companion.getSecureTextField$foundation_release();
                                        }
                                        final KeyboardOptions keyboardOptions3 = obj5;
                                        final KeyboardActionHandler keyboardActionHandler3 = i12 != 0 ? null : keyboardActionHandler;
                                        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function23 = i14 != 0 ? null : function2;
                                        final MutableInteractionSource mutableInteractionSource3 = i16 != 0 ? null : mutableInteractionSource;
                                        final SolidColor solidColor = i18 != 0 ? new SolidColor(Color.Companion.m4104getBlack0d7_KjU(), null) : brush;
                                        final TextFieldDecorator textFieldDecorator3 = i20 != 0 ? null : textFieldDecorator;
                                        int m1226getRevealLastTypedvTwcZD0 = i21 != 0 ? TextObfuscationMode.Companion.m1226getRevealLastTypedvTwcZD0() : i;
                                        char c3 = i23 != 0 ? (char) 8226 : c;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-817513499, i5, i24, "androidx.compose.foundation.text.BasicSecureTextField (BasicSecureTextField.kt:133)");
                                        }
                                        final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Character.valueOf(c3), startRestartGroup, (i24 >> 9) & 14);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 120990987, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.Companion.getEmpty()) {
                                            rememberedValue = new SecureTextFieldController(rememberUpdatedState);
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        final SecureTextFieldController secureTextFieldController = (SecureTextFieldController) rememberedValue;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 120994481, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                        boolean changedInstance = startRestartGroup.changedInstance(secureTextFieldController);
                                        BasicSecureTextFieldKt$BasicSecureTextField$1$1 rememberedValue2 = startRestartGroup.rememberedValue();
                                        if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                                            rememberedValue2 = new BasicSecureTextFieldKt$BasicSecureTextField$1$1(secureTextFieldController, null);
                                            startRestartGroup.updateRememberedValue(rememberedValue2);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        EffectsKt.LaunchedEffect(secureTextFieldController, (Function2) rememberedValue2, startRestartGroup, 0);
                                        final boolean m1221equalsimpl0 = TextObfuscationMode.m1221equalsimpl0(m1226getRevealLastTypedvTwcZD0, TextObfuscationMode.Companion.m1226getRevealLastTypedvTwcZD0());
                                        Boolean valueOf = Boolean.valueOf(m1221equalsimpl0);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 121010736, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                        boolean changed = startRestartGroup.changed(m1221equalsimpl0) | startRestartGroup.changedInstance(secureTextFieldController);
                                        BasicSecureTextFieldKt$BasicSecureTextField$2$1 rememberedValue3 = startRestartGroup.rememberedValue();
                                        if (changed || rememberedValue3 == Composer.Companion.getEmpty()) {
                                            rememberedValue3 = new BasicSecureTextFieldKt$BasicSecureTextField$2$1(m1221equalsimpl0, secureTextFieldController, null);
                                            startRestartGroup.updateRememberedValue(rememberedValue3);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue3, startRestartGroup, 0);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 121016567, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                        boolean z9 = (i24 & 896) == 256;
                                        Object rememberedValue4 = startRestartGroup.rememberedValue();
                                        if (z9 || rememberedValue4 == Composer.Companion.getEmpty()) {
                                            if (TextObfuscationMode.m1221equalsimpl0(m1226getRevealLastTypedvTwcZD0, TextObfuscationMode.Companion.m1226getRevealLastTypedvTwcZD0())) {
                                                codepointTransformation = secureTextFieldController.getCodepointTransformation();
                                            } else if (TextObfuscationMode.m1221equalsimpl0(m1226getRevealLastTypedvTwcZD0, TextObfuscationMode.Companion.m1225getHiddenvTwcZD0())) {
                                                codepointTransformation = new CodepointTransformation() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda0
                                                    @Override // androidx.compose.foundation.text.input.internal.CodepointTransformation
                                                    public final int transform(int i30, int i31) {
                                                        int BasicSecureTextField_egD4TGM$lambda$4$lambda$3;
                                                        BasicSecureTextField_egD4TGM$lambda$4$lambda$3 = BasicSecureTextFieldKt.BasicSecureTextField_egD4TGM$lambda$4$lambda$3(State.this, i30, i31);
                                                        return BasicSecureTextField_egD4TGM$lambda$4$lambda$3;
                                                    }
                                                };
                                            } else {
                                                rememberedValue4 = null;
                                                startRestartGroup.updateRememberedValue(rememberedValue4);
                                            }
                                            rememberedValue4 = codepointTransformation;
                                            startRestartGroup.updateRememberedValue(rememberedValue4);
                                        }
                                        final CodepointTransformation codepointTransformation2 = (CodepointTransformation) rememberedValue4;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        Modifier onPreviewKeyEvent = KeyInputModifierKt.onPreviewKeyEvent(SemanticsModifierKt.semantics$default(companion2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1
                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                invoke2(semanticsPropertyReceiver);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                SemanticsPropertiesKt.setContentType(semanticsPropertyReceiver, ContentType.Companion.getPassword());
                                            }
                                        }, 1, null), new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$2
                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                                return m1041invokeZmokQxo(keyEvent.m5158unboximpl());
                                            }

                                            /* renamed from: invoke-ZmokQxo  reason: not valid java name */
                                            public final Boolean m1041invokeZmokQxo(android.view.KeyEvent keyEvent) {
                                                KeyCommand mo1066mapZmokQxo = KeyMapping_androidKt.getPlatformDefaultKeyMapping().mo1066mapZmokQxo(keyEvent);
                                                return Boolean.valueOf(mo1066mapZmokQxo == KeyCommand.COPY || mo1066mapZmokQxo == KeyCommand.CUT);
                                            }
                                        });
                                        if (m1221equalsimpl0) {
                                            companion = secureTextFieldController.getFocusChangeModifier();
                                        } else {
                                            companion = Modifier.Companion;
                                        }
                                        final Modifier then = onPreviewKeyEvent.then(companion);
                                        final TextFieldState textFieldState2 = obj;
                                        DisableCutCopy(ComposableLambdaKt.rememberComposableLambda(252521481, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$3
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

                                            public final void invoke(Composer composer3, int i30) {
                                                InputTransformation inputTransformation4;
                                                ComposerKt.sourceInformation(composer3, "C184@9950L836:BasicSecureTextField.kt#423gt5");
                                                if (composer3.shouldExecute((i30 & 3) != 2, i30 & 1)) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(252521481, i30, -1, "androidx.compose.foundation.text.BasicSecureTextField.<anonymous> (BasicSecureTextField.kt:184)");
                                                    }
                                                    TextFieldState textFieldState3 = TextFieldState.this;
                                                    Modifier modifier3 = then;
                                                    boolean z10 = z7;
                                                    boolean z11 = z8;
                                                    if (m1221equalsimpl0) {
                                                        inputTransformation4 = BasicSecureTextFieldKt.then(inputTransformation3, secureTextFieldController.getPasswordInputTransformation());
                                                    } else {
                                                        inputTransformation4 = inputTransformation3;
                                                    }
                                                    BasicTextFieldKt.BasicTextField(textFieldState3, modifier3, z10, z11, inputTransformation4, textStyle3, keyboardOptions3, keyboardActionHandler3, TextFieldLineLimits.SingleLine.INSTANCE, function23, mutableInteractionSource3, solidColor, codepointTransformation2, null, textFieldDecorator3, null, true, composer3, 100663296, 1572864, 40960);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }, startRestartGroup, 54), startRestartGroup, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        i25 = m1226getRevealLastTypedvTwcZD0;
                                        composer2 = startRestartGroup;
                                        c2 = c3;
                                        z5 = z7;
                                        z6 = z8;
                                        inputTransformation2 = inputTransformation3;
                                        textStyle2 = textStyle3;
                                        keyboardOptions2 = keyboardOptions3;
                                        keyboardActionHandler2 = keyboardActionHandler3;
                                        function22 = function23;
                                        mutableInteractionSource2 = mutableInteractionSource3;
                                        brush2 = solidColor;
                                        textFieldDecorator2 = textFieldDecorator3;
                                        modifier2 = companion2;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        keyboardActionHandler2 = keyboardActionHandler;
                                        function22 = function2;
                                        i25 = i;
                                        composer2 = startRestartGroup;
                                        z5 = z3;
                                        z6 = z4;
                                        inputTransformation2 = obj3;
                                        modifier2 = obj2;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        brush2 = brush;
                                        textFieldDecorator2 = textFieldDecorator;
                                        keyboardOptions2 = obj5;
                                        textStyle2 = obj4;
                                        c2 = c;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup == null) {
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$4
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

                                            public final void invoke(Composer composer3, int i30) {
                                                BasicSecureTextFieldKt.m1040BasicSecureTextFieldegD4TGM(TextFieldState.this, modifier2, z5, z6, inputTransformation2, textStyle2, keyboardOptions2, keyboardActionHandler2, function22, mutableInteractionSource2, brush2, textFieldDecorator2, i25, c2, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i16 = i15;
                                i17 = i4 & 1024;
                                if (i17 == 0) {
                                }
                                i20 = i4 & 2048;
                                if (i20 == 0) {
                                }
                                int i272 = i19;
                                i21 = i4 & 4096;
                                if (i21 == 0) {
                                }
                                i23 = i4 & 8192;
                                if (i23 == 0) {
                                }
                                if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i24 & 1171) != 1170, i5 & 1)) {
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                }
                            }
                            i14 = i13;
                            i15 = i4 & 512;
                            if (i15 != 0) {
                            }
                            i16 = i15;
                            i17 = i4 & 1024;
                            if (i17 == 0) {
                            }
                            i20 = i4 & 2048;
                            if (i20 == 0) {
                            }
                            int i2722 = i19;
                            i21 = i4 & 4096;
                            if (i21 == 0) {
                            }
                            i23 = i4 & 8192;
                            if (i23 == 0) {
                            }
                            if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i24 & 1171) != 1170, i5 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        i12 = i11;
                        i13 = i4 & 256;
                        if (i13 == 0) {
                        }
                        i14 = i13;
                        i15 = i4 & 512;
                        if (i15 != 0) {
                        }
                        i16 = i15;
                        i17 = i4 & 1024;
                        if (i17 == 0) {
                        }
                        i20 = i4 & 2048;
                        if (i20 == 0) {
                        }
                        int i27222 = i19;
                        i21 = i4 & 4096;
                        if (i21 == 0) {
                        }
                        i23 = i4 & 8192;
                        if (i23 == 0) {
                        }
                        if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i24 & 1171) != 1170, i5 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    obj3 = inputTransformation;
                    i9 = i4 & 32;
                    if (i9 != 0) {
                    }
                    i10 = i4 & 64;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 128;
                    if (i11 != 0) {
                    }
                    i12 = i11;
                    i13 = i4 & 256;
                    if (i13 == 0) {
                    }
                    i14 = i13;
                    i15 = i4 & 512;
                    if (i15 != 0) {
                    }
                    i16 = i15;
                    i17 = i4 & 1024;
                    if (i17 == 0) {
                    }
                    i20 = i4 & 2048;
                    if (i20 == 0) {
                    }
                    int i272222 = i19;
                    i21 = i4 & 4096;
                    if (i21 == 0) {
                    }
                    i23 = i4 & 8192;
                    if (i23 == 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i24 & 1171) != 1170, i5 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z4 = z2;
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                obj3 = inputTransformation;
                i9 = i4 & 32;
                if (i9 != 0) {
                }
                i10 = i4 & 64;
                if (i10 != 0) {
                }
                i11 = i4 & 128;
                if (i11 != 0) {
                }
                i12 = i11;
                i13 = i4 & 256;
                if (i13 == 0) {
                }
                i14 = i13;
                i15 = i4 & 512;
                if (i15 != 0) {
                }
                i16 = i15;
                i17 = i4 & 1024;
                if (i17 == 0) {
                }
                i20 = i4 & 2048;
                if (i20 == 0) {
                }
                int i2722222 = i19;
                i21 = i4 & 4096;
                if (i21 == 0) {
                }
                i23 = i4 & 8192;
                if (i23 == 0) {
                }
                if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i24 & 1171) != 1170, i5 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z3 = z;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            z4 = z2;
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            obj3 = inputTransformation;
            i9 = i4 & 32;
            if (i9 != 0) {
            }
            i10 = i4 & 64;
            if (i10 != 0) {
            }
            i11 = i4 & 128;
            if (i11 != 0) {
            }
            i12 = i11;
            i13 = i4 & 256;
            if (i13 == 0) {
            }
            i14 = i13;
            i15 = i4 & 512;
            if (i15 != 0) {
            }
            i16 = i15;
            i17 = i4 & 1024;
            if (i17 == 0) {
            }
            i20 = i4 & 2048;
            if (i20 == 0) {
            }
            int i27222222 = i19;
            i21 = i4 & 4096;
            if (i21 == 0) {
            }
            i23 = i4 & 8192;
            if (i23 == 0) {
            }
            if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i24 & 1171) != 1170, i5 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        z3 = z;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        z4 = z2;
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        obj3 = inputTransformation;
        i9 = i4 & 32;
        if (i9 != 0) {
        }
        i10 = i4 & 64;
        if (i10 != 0) {
        }
        i11 = i4 & 128;
        if (i11 != 0) {
        }
        i12 = i11;
        i13 = i4 & 256;
        if (i13 == 0) {
        }
        i14 = i13;
        i15 = i4 & 512;
        if (i15 != 0) {
        }
        i16 = i15;
        i17 = i4 & 1024;
        if (i17 == 0) {
        }
        i20 = i4 & 2048;
        if (i20 == 0) {
        }
        int i272222222 = i19;
        i21 = i4 & 4096;
        if (i21 == 0) {
        }
        i23 = i4 & 8192;
        if (i23 == 0) {
        }
        if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i24 & 1171) != 1170, i5 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int BasicSecureTextField_egD4TGM$lambda$4$lambda$3(State state, int i, int i2) {
        return ((Character) state.getValue()).charValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InputTransformation then(InputTransformation inputTransformation, InputTransformation inputTransformation2) {
        return inputTransformation == null ? inputTransformation2 : inputTransformation2 == null ? inputTransformation : InputTransformationKt.then(inputTransformation, inputTransformation2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DisableCutCopy(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1085555050);
        ComposerKt.sourceInformation(startRestartGroup, "C(DisableCutCopy)306@14490L7,308@14536L875,329@15416L80:BasicSecureTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1085555050, i2, -1, "androidx.compose.foundation.text.DisableCutCopy (BasicSecureTextField.kt:305)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final TextToolbar textToolbar = (TextToolbar) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1202758015, "CC(remember):BasicSecureTextField.kt#9igjgp");
            boolean changed = startRestartGroup.changed(textToolbar);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new TextToolbar() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1
                    private final /* synthetic */ TextToolbar $$delegate_0;

                    @Override // androidx.compose.ui.platform.TextToolbar
                    public TextToolbarStatus getStatus() {
                        return this.$$delegate_0.getStatus();
                    }

                    @Override // androidx.compose.ui.platform.TextToolbar
                    public void hide() {
                        this.$$delegate_0.hide();
                    }

                    @Override // androidx.compose.ui.platform.TextToolbar
                    public void showMenu(Rect rect, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04) {
                        this.$$delegate_0.showMenu(rect, function0, function02, function03, function04);
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.$$delegate_0 = TextToolbar.this;
                    }

                    @Override // androidx.compose.ui.platform.TextToolbar
                    public void showMenu(Rect rect, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04, Function0<Unit> function05) {
                        TextToolbar.this.showMenu(rect, null, function02, null, function04, function05);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalTextToolbar().provides((BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1) rememberedValue), function2, startRestartGroup, ((i2 << 3) & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$DisableCutCopy$1
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
                    BasicSecureTextFieldKt.DisableCutCopy(function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:205:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0111  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the overload that takes in readOnly parameter.")
    /* renamed from: BasicSecureTextField-Jb9bMDk  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1039BasicSecureTextFieldJb9bMDk(final TextFieldState textFieldState, Modifier modifier, boolean z, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, TextFieldDecorator textFieldDecorator, int i, char c, Composer composer, final int i2, final int i3, final int i4) {
        Object obj;
        int i5;
        Object obj2;
        int i6;
        boolean z2;
        int i7;
        Object obj3;
        int i8;
        Object obj4;
        int i9;
        Object obj5;
        int i10;
        Object obj6;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        Composer composer2;
        final Function2 function22;
        final int i23;
        final boolean z3;
        final InputTransformation inputTransformation2;
        final TextStyle textStyle2;
        final KeyboardOptions keyboardOptions2;
        final Modifier modifier2;
        final KeyboardActionHandler keyboardActionHandler2;
        final MutableInteractionSource mutableInteractionSource2;
        final Brush brush2;
        final TextFieldDecorator textFieldDecorator2;
        final char c2;
        ScopeUpdateScope endRestartGroup;
        int i24;
        Modifier.Companion companion;
        int i25;
        TextStyle textStyle3;
        Composer startRestartGroup = composer.startRestartGroup(1399310985);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicSecureTextField)P(9,6,2,3,12,5,7,8,4!2,11:c#foundation.text.input.TextObfuscationMode)355@16532L563:BasicSecureTextField.kt#423gt5");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
            obj = textFieldState;
        } else if ((i2 & 6) == 0) {
            obj = textFieldState;
            i5 = (startRestartGroup.changed(obj) ? 4 : 2) | i2;
        } else {
            obj = textFieldState;
            i5 = i2;
        }
        int i26 = i4 & 2;
        if (i26 != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            obj2 = modifier;
            i5 |= startRestartGroup.changed(obj2) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z2 = z;
                i5 |= startRestartGroup.changed(z2) ? 256 : 128;
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    obj3 = inputTransformation;
                    i5 |= startRestartGroup.changed(obj3) ? 2048 : 1024;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i2 & 24576) == 0) {
                        obj4 = textStyle;
                        i5 |= startRestartGroup.changed(obj4) ? 16384 : 8192;
                        i9 = i4 & 32;
                        if (i9 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            obj5 = keyboardOptions;
                        } else {
                            obj5 = keyboardOptions;
                            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i5 |= startRestartGroup.changed(obj5) ? 131072 : 65536;
                            }
                        }
                        i10 = i4 & 64;
                        if (i10 != 0) {
                            i5 |= 1572864;
                            obj6 = keyboardActionHandler;
                        } else {
                            obj6 = keyboardActionHandler;
                            if ((i2 & 1572864) == 0) {
                                i5 |= startRestartGroup.changed(obj6) ? 1048576 : 524288;
                            }
                        }
                        i11 = i4 & 128;
                        if (i11 != 0) {
                            i5 |= 12582912;
                        } else if ((i2 & 12582912) == 0) {
                            i12 = i11;
                            i5 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                            i13 = i4 & 256;
                            if (i13 == 0) {
                                i5 |= 100663296;
                            } else if ((i2 & 100663296) == 0) {
                                i14 = i13;
                                i5 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                                i15 = i4 & 512;
                                if (i15 != 0) {
                                    i5 |= 805306368;
                                } else if ((i2 & 805306368) == 0) {
                                    i16 = i15;
                                    i5 |= startRestartGroup.changed(brush) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                                    i17 = i4 & 1024;
                                    if (i17 == 0) {
                                        i18 = i3 | 6;
                                    } else if ((i3 & 6) == 0) {
                                        i18 = i3 | ((i3 & 8) == 0 ? startRestartGroup.changed(textFieldDecorator) : startRestartGroup.changedInstance(textFieldDecorator) ? 4 : 2);
                                    } else {
                                        i18 = i3;
                                    }
                                    i19 = i4 & 2048;
                                    if (i19 == 0) {
                                        i18 |= 48;
                                        i20 = i19;
                                    } else if ((i3 & 48) == 0) {
                                        i20 = i19;
                                        i18 |= startRestartGroup.changed(i) ? 32 : 16;
                                    } else {
                                        i20 = i19;
                                    }
                                    int i27 = i18;
                                    i21 = i4 & 4096;
                                    if (i21 == 0) {
                                        i22 = i27 | RendererCapabilities.DECODER_SUPPORT_MASK;
                                    } else if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                        i22 = i27 | (startRestartGroup.changed(c) ? 256 : 128);
                                    } else {
                                        i22 = i27;
                                    }
                                    if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
                                        if (i26 != 0) {
                                            companion = Modifier.Companion;
                                            i24 = i7;
                                        } else {
                                            i24 = i7;
                                            companion = obj2;
                                        }
                                        boolean z4 = i6 != 0 ? true : z2;
                                        InputTransformation inputTransformation3 = i24 != 0 ? null : obj3;
                                        if (i8 != 0) {
                                            textStyle3 = TextStyle.Companion.getDefault();
                                            i25 = i9;
                                        } else {
                                            i25 = i9;
                                            textStyle3 = obj4;
                                        }
                                        KeyboardOptions secureTextField$foundation_release = i25 != 0 ? KeyboardOptions.Companion.getSecureTextField$foundation_release() : obj5;
                                        KeyboardActionHandler keyboardActionHandler3 = i10 != 0 ? null : obj6;
                                        Function2 function23 = i12 != 0 ? null : function2;
                                        MutableInteractionSource mutableInteractionSource3 = i14 != 0 ? null : mutableInteractionSource;
                                        SolidColor solidColor = i16 != 0 ? new SolidColor(Color.Companion.m4104getBlack0d7_KjU(), null) : brush;
                                        TextFieldDecorator textFieldDecorator3 = i17 != 0 ? null : textFieldDecorator;
                                        int m1226getRevealLastTypedvTwcZD0 = i20 != 0 ? TextObfuscationMode.Companion.m1226getRevealLastTypedvTwcZD0() : i;
                                        char c3 = i21 != 0 ? (char) 8226 : c;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1399310985, i5, i22, "androidx.compose.foundation.text.BasicSecureTextField (BasicSecureTextField.kt:354)");
                                        }
                                        int i28 = i5 << 3;
                                        int i29 = i22 << 3;
                                        composer2 = startRestartGroup;
                                        m1040BasicSecureTextFieldegD4TGM(obj, companion, z4, false, inputTransformation3, textStyle3, secureTextField$foundation_release, keyboardActionHandler3, function23, mutableInteractionSource3, solidColor, textFieldDecorator3, m1226getRevealLastTypedvTwcZD0, c3, composer2, (i5 & 14) | 3072 | (i5 & 112) | (i5 & 896) | (57344 & i28) | (458752 & i28) | (3670016 & i28) | (29360128 & i28) | (234881024 & i28) | (i28 & 1879048192), ((i5 >> 27) & 14) | (i29 & 112) | (i29 & 896) | (i29 & 7168), 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        modifier2 = companion;
                                        z3 = z4;
                                        inputTransformation2 = inputTransformation3;
                                        textStyle2 = textStyle3;
                                        keyboardOptions2 = secureTextField$foundation_release;
                                        keyboardActionHandler2 = keyboardActionHandler3;
                                        function22 = function23;
                                        mutableInteractionSource2 = mutableInteractionSource3;
                                        brush2 = solidColor;
                                        textFieldDecorator2 = textFieldDecorator3;
                                        i23 = m1226getRevealLastTypedvTwcZD0;
                                        c2 = c3;
                                    } else {
                                        composer2 = startRestartGroup;
                                        composer2.skipToGroupEnd();
                                        function22 = function2;
                                        i23 = i;
                                        z3 = z2;
                                        inputTransformation2 = obj3;
                                        textStyle2 = obj4;
                                        keyboardOptions2 = obj5;
                                        modifier2 = obj2;
                                        keyboardActionHandler2 = obj6;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        brush2 = brush;
                                        textFieldDecorator2 = textFieldDecorator;
                                        c2 = c;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup == null) {
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$5
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

                                            public final void invoke(Composer composer3, int i30) {
                                                BasicSecureTextFieldKt.m1039BasicSecureTextFieldJb9bMDk(TextFieldState.this, modifier2, z3, inputTransformation2, textStyle2, keyboardOptions2, keyboardActionHandler2, function22, mutableInteractionSource2, brush2, textFieldDecorator2, i23, c2, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i16 = i15;
                                i17 = i4 & 1024;
                                if (i17 == 0) {
                                }
                                i19 = i4 & 2048;
                                if (i19 == 0) {
                                }
                                int i272 = i18;
                                i21 = i4 & 4096;
                                if (i21 == 0) {
                                }
                                if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                }
                            }
                            i14 = i13;
                            i15 = i4 & 512;
                            if (i15 != 0) {
                            }
                            i16 = i15;
                            i17 = i4 & 1024;
                            if (i17 == 0) {
                            }
                            i19 = i4 & 2048;
                            if (i19 == 0) {
                            }
                            int i2722 = i18;
                            i21 = i4 & 4096;
                            if (i21 == 0) {
                            }
                            if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        i12 = i11;
                        i13 = i4 & 256;
                        if (i13 == 0) {
                        }
                        i14 = i13;
                        i15 = i4 & 512;
                        if (i15 != 0) {
                        }
                        i16 = i15;
                        i17 = i4 & 1024;
                        if (i17 == 0) {
                        }
                        i19 = i4 & 2048;
                        if (i19 == 0) {
                        }
                        int i27222 = i18;
                        i21 = i4 & 4096;
                        if (i21 == 0) {
                        }
                        if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    obj4 = textStyle;
                    i9 = i4 & 32;
                    if (i9 != 0) {
                    }
                    i10 = i4 & 64;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 128;
                    if (i11 != 0) {
                    }
                    i12 = i11;
                    i13 = i4 & 256;
                    if (i13 == 0) {
                    }
                    i14 = i13;
                    i15 = i4 & 512;
                    if (i15 != 0) {
                    }
                    i16 = i15;
                    i17 = i4 & 1024;
                    if (i17 == 0) {
                    }
                    i19 = i4 & 2048;
                    if (i19 == 0) {
                    }
                    int i272222 = i18;
                    i21 = i4 & 4096;
                    if (i21 == 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj3 = inputTransformation;
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                obj4 = textStyle;
                i9 = i4 & 32;
                if (i9 != 0) {
                }
                i10 = i4 & 64;
                if (i10 != 0) {
                }
                i11 = i4 & 128;
                if (i11 != 0) {
                }
                i12 = i11;
                i13 = i4 & 256;
                if (i13 == 0) {
                }
                i14 = i13;
                i15 = i4 & 512;
                if (i15 != 0) {
                }
                i16 = i15;
                i17 = i4 & 1024;
                if (i17 == 0) {
                }
                i19 = i4 & 2048;
                if (i19 == 0) {
                }
                int i2722222 = i18;
                i21 = i4 & 4096;
                if (i21 == 0) {
                }
                if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            obj3 = inputTransformation;
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            obj4 = textStyle;
            i9 = i4 & 32;
            if (i9 != 0) {
            }
            i10 = i4 & 64;
            if (i10 != 0) {
            }
            i11 = i4 & 128;
            if (i11 != 0) {
            }
            i12 = i11;
            i13 = i4 & 256;
            if (i13 == 0) {
            }
            i14 = i13;
            i15 = i4 & 512;
            if (i15 != 0) {
            }
            i16 = i15;
            i17 = i4 & 1024;
            if (i17 == 0) {
            }
            i19 = i4 & 2048;
            if (i19 == 0) {
            }
            int i27222222 = i18;
            i21 = i4 & 4096;
            if (i21 == 0) {
            }
            if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        z2 = z;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        obj3 = inputTransformation;
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        obj4 = textStyle;
        i9 = i4 & 32;
        if (i9 != 0) {
        }
        i10 = i4 & 64;
        if (i10 != 0) {
        }
        i11 = i4 & 128;
        if (i11 != 0) {
        }
        i12 = i11;
        i13 = i4 & 256;
        if (i13 == 0) {
        }
        i14 = i13;
        i15 = i4 & 512;
        if (i15 != 0) {
        }
        i16 = i15;
        i17 = i4 & 1024;
        if (i17 == 0) {
        }
        i19 = i4 & 2048;
        if (i19 == 0) {
        }
        int i272222222 = i18;
        i21 = i4 & 4096;
        if (i21 == 0) {
        }
        if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
