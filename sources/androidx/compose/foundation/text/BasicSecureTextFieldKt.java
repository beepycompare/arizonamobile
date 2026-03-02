package androidx.compose.foundation.text;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.InputTransformationKt;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextObfuscationMode;
import androidx.compose.foundation.text.input.TextObfuscationMode_androidKt;
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
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aÛ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u001028\b\u0002\u0010\u0011\u001a2\u0012\u0004\u0012\u00020\u0013\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%H\u0007¢\u0006\u0004\b&\u0010'\u001a\u001a\u0010(\u001a\u0004\u0018\u00010\n*\u0004\u0018\u00010\n2\b\u0010)\u001a\u0004\u0018\u00010\nH\u0002\u001a \u0010-\u001a\u00020\u00012\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b/H\u0003¢\u0006\u0002\u00100\u001aÇ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u001028\b\u0002\u0010\u0011\u001a2\u0012\u0004\u0012\u00020\u0013\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b1\u00102\u001aÑ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u001028\b\u0002\u0010\u0011\u001a2\u0012\u0004\u0012\u00020\u0013\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b3\u00104\"\u000e\u0010*\u001a\u00020+X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020#X\u0082T¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"BasicSecureTextField", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "textObfuscationMode", "Landroidx/compose/foundation/text/input/TextObfuscationMode;", "textObfuscationCharacter", "", "scrollState", "Landroidx/compose/foundation/ScrollState;", "BasicSecureTextField-ltb6GB4", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ICLandroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "then", "next", "LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS", "", "DefaultObfuscationCharacter", "DisableCutCopy", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "BasicSecureTextField-Jb9bMDk", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ICLandroidx/compose/runtime/Composer;III)V", "BasicSecureTextField-egD4TGM", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ICLandroidx/compose/runtime/Composer;III)V", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BasicSecureTextFieldKt {
    private static final char DefaultObfuscationCharacter = 8226;
    private static final long LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS = 1500;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BasicSecureTextField_Jb9bMDk$lambda$0(TextFieldState textFieldState, Modifier modifier, boolean z, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, TextFieldDecorator textFieldDecorator, int i, char c, int i2, int i3, int i4, Composer composer, int i5) {
        m1135BasicSecureTextFieldJb9bMDk(textFieldState, modifier, z, inputTransformation, textStyle, keyboardOptions, keyboardActionHandler, function2, mutableInteractionSource, brush, textFieldDecorator, i, c, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BasicSecureTextField_egD4TGM$lambda$0(TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, TextFieldDecorator textFieldDecorator, int i, char c, int i2, int i3, int i4, Composer composer, int i5) {
        m1136BasicSecureTextFieldegD4TGM(textFieldState, modifier, z, z2, inputTransformation, textStyle, keyboardOptions, keyboardActionHandler, function2, mutableInteractionSource, brush, textFieldDecorator, i, c, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BasicSecureTextField_ltb6GB4$lambda$7(TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, TextFieldDecorator textFieldDecorator, int i, char c, ScrollState scrollState, int i2, int i3, int i4, Composer composer, int i5) {
        m1137BasicSecureTextFieldltb6GB4(textFieldState, modifier, z, z2, inputTransformation, textStyle, keyboardOptions, keyboardActionHandler, function2, mutableInteractionSource, brush, textFieldDecorator, i, c, scrollState, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DisableCutCopy$lambda$1(Function2 function2, int i, Composer composer, int i2) {
        DisableCutCopy(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:240:0x03ab, code lost:
        if (r0 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L140;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:283:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0129  */
    /* renamed from: BasicSecureTextField-ltb6GB4  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1137BasicSecureTextFieldltb6GB4(final TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2, MutableInteractionSource mutableInteractionSource, Brush brush, TextFieldDecorator textFieldDecorator, int i, char c, ScrollState scrollState, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Object obj;
        int i6;
        boolean z3;
        int i7;
        boolean z4;
        int i8;
        final Object obj2;
        int i9;
        Object obj3;
        int i10;
        final Object obj4;
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
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function22;
        final int i23;
        final char c2;
        Composer composer2;
        final boolean z5;
        final boolean z6;
        final InputTransformation inputTransformation2;
        final Modifier modifier2;
        final TextStyle textStyle2;
        final KeyboardActionHandler keyboardActionHandler2;
        final MutableInteractionSource mutableInteractionSource2;
        final Brush brush2;
        final TextFieldDecorator textFieldDecorator2;
        final ScrollState scrollState2;
        ScopeUpdateScope endRestartGroup;
        Modifier.Companion companion;
        KeyboardOptions keyboardOptions2;
        boolean z7;
        SolidColor solidColor;
        int i24;
        final ScrollState scrollState3;
        final Brush brush3;
        final TextFieldDecorator textFieldDecorator3;
        final KeyboardActionHandler keyboardActionHandler3;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function23;
        final MutableInteractionSource mutableInteractionSource3;
        TextStyle textStyle3;
        char c3;
        final boolean z8;
        int i25;
        final boolean z9;
        boolean z10;
        char c4;
        CodepointTransformation codepointTransformation;
        Modifier.Companion companion2;
        int i26;
        Composer startRestartGroup = composer.startRestartGroup(1568790509);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicSecureTextField)N(state,modifier,enabled,readOnly,inputTransformation,textStyle,keyboardOptions,onKeyboardAction,onTextLayout,interactionSource,cursorBrush,decorator,textObfuscationMode:c#foundation.text.input.TextObfuscationMode,textObfuscationCharacter,scrollState)140@8345L46,141@8428L60,142@8535L130,142@8493L172,155@9098L129,155@9059L168,162@9271L424,176@9771L38,177@9841L288,191@10367L891,191@10352L906:BasicSecureTextField.kt#423gt5");
        if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(textFieldState) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i27 = i4 & 2;
        if (i27 != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            obj = modifier;
            i5 |= startRestartGroup.changed(obj) ? 32 : 16;
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
                    int i28 = 8192;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i2 & 24576) == 0) {
                        obj2 = inputTransformation;
                        i5 |= startRestartGroup.changed(obj2) ? 16384 : 8192;
                        i9 = i4 & 32;
                        if (i9 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            obj3 = textStyle;
                        } else {
                            obj3 = textStyle;
                            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i5 |= startRestartGroup.changed(obj3) ? 131072 : 65536;
                            }
                        }
                        i10 = i4 & 64;
                        if (i10 != 0) {
                            i5 |= 1572864;
                            obj4 = keyboardOptions;
                        } else {
                            obj4 = keyboardOptions;
                            if ((i2 & 1572864) == 0) {
                                i5 |= startRestartGroup.changed(obj4) ? 1048576 : 524288;
                            }
                        }
                        i11 = i4 & 128;
                        if (i11 != 0) {
                            i5 |= 12582912;
                        } else if ((i2 & 12582912) == 0) {
                            i5 |= startRestartGroup.changed(keyboardActionHandler) ? 8388608 : 4194304;
                        }
                        i12 = i4 & 256;
                        if (i12 != 0) {
                            i5 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i13 = i12;
                            i5 |= startRestartGroup.changedInstance(function2) ? 67108864 : 33554432;
                            i14 = i4 & 512;
                            if (i14 == 0) {
                                i5 |= 805306368;
                            } else if ((i2 & 805306368) == 0) {
                                i15 = i14;
                                i5 |= startRestartGroup.changed(mutableInteractionSource) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                                i16 = i4 & 1024;
                                if (i16 != 0) {
                                    i18 = i3 | 6;
                                    i17 = i16;
                                } else if ((i3 & 6) == 0) {
                                    i17 = i16;
                                    i18 = i3 | (startRestartGroup.changed(brush) ? 4 : 2);
                                } else {
                                    i17 = i16;
                                    i18 = i3;
                                }
                                i19 = i4 & 2048;
                                if (i19 != 0) {
                                    i18 |= 48;
                                } else if ((i3 & 48) == 0) {
                                    i18 |= (i3 & 64) == 0 ? startRestartGroup.changed(textFieldDecorator) : startRestartGroup.changedInstance(textFieldDecorator) ? 32 : 16;
                                }
                                if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                    if ((i4 & 4096) == 0 && startRestartGroup.changed(i)) {
                                        i26 = 256;
                                        i18 |= i26;
                                    }
                                    i26 = 128;
                                    i18 |= i26;
                                }
                                int i29 = i18;
                                i20 = i4 & 8192;
                                if (i20 != 0) {
                                    i21 = i29 | 3072;
                                } else if ((i3 & 3072) == 0) {
                                    i21 = i29 | (startRestartGroup.changed(c) ? 2048 : 1024);
                                } else {
                                    i21 = i29;
                                }
                                if ((i3 & 24576) == 0) {
                                    if ((i4 & 16384) == 0 && startRestartGroup.changed(scrollState)) {
                                        i28 = 16384;
                                    }
                                    i21 |= i28;
                                }
                                i22 = i21;
                                if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 9363) != 9362, i5 & 1)) {
                                    startRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(startRestartGroup, "138@8287L21");
                                    if ((i2 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i4 & 4096) != 0) {
                                            i22 &= -897;
                                        }
                                        if ((i4 & 16384) != 0) {
                                            i22 &= -57345;
                                        }
                                        keyboardActionHandler3 = keyboardActionHandler;
                                        function23 = function2;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        brush3 = brush;
                                        textFieldDecorator3 = textFieldDecorator;
                                        c3 = c;
                                        scrollState3 = scrollState;
                                        i25 = i22;
                                        z9 = z4;
                                        companion = obj;
                                        textStyle3 = obj3;
                                        z8 = z3;
                                        i24 = i;
                                    } else {
                                        companion = i27 != 0 ? Modifier.Companion : obj;
                                        if (i6 != 0) {
                                            z3 = true;
                                        }
                                        if (i7 != 0) {
                                            z4 = false;
                                        }
                                        if (i8 != 0) {
                                            obj2 = null;
                                        }
                                        if (i9 != 0) {
                                            obj3 = TextStyle.Companion.getDefault();
                                        }
                                        if (i10 != 0) {
                                            obj4 = KeyboardOptions.Companion.getSecureTextField$foundation();
                                        }
                                        KeyboardActionHandler keyboardActionHandler4 = i11 != 0 ? null : keyboardActionHandler;
                                        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function24 = i13 != 0 ? null : function2;
                                        MutableInteractionSource mutableInteractionSource4 = i15 != 0 ? null : mutableInteractionSource;
                                        if (i17 != 0) {
                                            keyboardOptions2 = obj4;
                                            z7 = z3;
                                            solidColor = new SolidColor(Color.Companion.m4798getBlack0d7_KjU(), null);
                                        } else {
                                            keyboardOptions2 = obj4;
                                            z7 = z3;
                                            solidColor = brush;
                                        }
                                        TextFieldDecorator textFieldDecorator4 = i19 != 0 ? null : textFieldDecorator;
                                        if ((i4 & 4096) != 0) {
                                            i24 = TextObfuscationMode_androidKt.getDefault(TextObfuscationMode.Companion);
                                            i22 &= -897;
                                        } else {
                                            i24 = i;
                                        }
                                        char c5 = i20 != 0 ? (char) 8226 : c;
                                        int i30 = i22;
                                        if ((i4 & 16384) != 0) {
                                            brush3 = solidColor;
                                            textFieldDecorator3 = textFieldDecorator4;
                                            function23 = function24;
                                            mutableInteractionSource3 = mutableInteractionSource4;
                                            c3 = c5;
                                            scrollState3 = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                                            obj4 = keyboardOptions2;
                                            i25 = i30 & (-57345);
                                            keyboardActionHandler3 = keyboardActionHandler4;
                                            z9 = z4;
                                            textStyle3 = obj3;
                                            z8 = z7;
                                        } else {
                                            scrollState3 = scrollState;
                                            brush3 = solidColor;
                                            textFieldDecorator3 = textFieldDecorator4;
                                            keyboardActionHandler3 = keyboardActionHandler4;
                                            function23 = function24;
                                            mutableInteractionSource3 = mutableInteractionSource4;
                                            textStyle3 = obj3;
                                            c3 = c5;
                                            z8 = z7;
                                            obj4 = keyboardOptions2;
                                            i25 = i30;
                                            z9 = z4;
                                        }
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1568790509, i5, i25, "androidx.compose.foundation.text.BasicSecureTextField (BasicSecureTextField.kt:139)");
                                    }
                                    final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Character.valueOf(c3), startRestartGroup, (i25 >> 9) & 14);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 74191401, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.Companion.getEmpty()) {
                                        rememberedValue = new SecureTextFieldController(rememberUpdatedState);
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    final SecureTextFieldController secureTextFieldController = (SecureTextFieldController) rememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 74194895, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                    boolean changedInstance = startRestartGroup.changedInstance(secureTextFieldController);
                                    BasicSecureTextFieldKt$BasicSecureTextField$1$1 rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                                        rememberedValue2 = new BasicSecureTextFieldKt$BasicSecureTextField$1$1(secureTextFieldController, null);
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    EffectsKt.LaunchedEffect(secureTextFieldController, (Function2) rememberedValue2, startRestartGroup, 0);
                                    if (TextObfuscationMode.m1354equalsimpl0(i24, TextObfuscationMode.Companion.m1359getRevealLastTypedvTwcZD0())) {
                                        startRestartGroup.startReplaceGroup(74207180);
                                        ComposerKt.sourceInformation(startRestartGroup, "152@8922L31");
                                        z10 = BasicSecureTextField_androidKt.platformAllowsRevealLastTyped(startRestartGroup, 0);
                                        startRestartGroup.endReplaceGroup();
                                    } else {
                                        startRestartGroup.startReplaceGroup(-1994543479);
                                        startRestartGroup.endReplaceGroup();
                                        z10 = false;
                                    }
                                    Boolean valueOf = Boolean.valueOf(z10);
                                    final TextStyle textStyle4 = textStyle3;
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 74212910, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                    boolean changed = startRestartGroup.changed(z10) | startRestartGroup.changedInstance(secureTextFieldController);
                                    BasicSecureTextFieldKt$BasicSecureTextField$2$1 rememberedValue3 = startRestartGroup.rememberedValue();
                                    if (changed) {
                                        c4 = c3;
                                    } else {
                                        c4 = c3;
                                    }
                                    rememberedValue3 = new BasicSecureTextFieldKt$BasicSecureTextField$2$1(z10, secureTextFieldController, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue3, startRestartGroup, 0);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 74218741, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                    boolean z11 = (((i25 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && startRestartGroup.changed(i24)) || (i25 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256;
                                    Object rememberedValue4 = startRestartGroup.rememberedValue();
                                    if (z11 || rememberedValue4 == Composer.Companion.getEmpty()) {
                                        if (TextObfuscationMode.m1354equalsimpl0(i24, TextObfuscationMode.Companion.m1359getRevealLastTypedvTwcZD0())) {
                                            codepointTransformation = secureTextFieldController.getCodepointTransformation();
                                        } else {
                                            codepointTransformation = TextObfuscationMode.m1354equalsimpl0(i24, TextObfuscationMode.Companion.m1358getHiddenvTwcZD0()) ? new CodepointTransformation() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda3
                                                @Override // androidx.compose.foundation.text.input.internal.CodepointTransformation
                                                public final int transform(int i31, int i32) {
                                                    int BasicSecureTextField_ltb6GB4$lambda$3$0;
                                                    BasicSecureTextField_ltb6GB4$lambda$3$0 = BasicSecureTextFieldKt.BasicSecureTextField_ltb6GB4$lambda$3$0(State.this, i31, i32);
                                                    return BasicSecureTextField_ltb6GB4$lambda$3$0;
                                                }
                                            } : null;
                                        }
                                        startRestartGroup.updateRememberedValue(codepointTransformation);
                                        rememberedValue4 = codepointTransformation;
                                    }
                                    final CodepointTransformation codepointTransformation2 = (CodepointTransformation) rememberedValue4;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 74234355, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                    Object rememberedValue5 = startRestartGroup.rememberedValue();
                                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                                        rememberedValue5 = new Function1() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda4
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj5) {
                                                Unit BasicSecureTextField_ltb6GB4$lambda$4$0;
                                                BasicSecureTextField_ltb6GB4$lambda$4$0 = BasicSecureTextFieldKt.BasicSecureTextField_ltb6GB4$lambda$4$0((SemanticsPropertyReceiver) obj5);
                                                return BasicSecureTextField_ltb6GB4$lambda$4$0;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue5);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    Modifier semantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue5, 1, null);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 74236845, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                    BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$2$1 rememberedValue6 = startRestartGroup.rememberedValue();
                                    if (rememberedValue6 == Composer.Companion.getEmpty()) {
                                        rememberedValue6 = new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$2$1
                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                                return m1138invokeZmokQxo(keyEvent.m5917unboximpl());
                                            }

                                            /* renamed from: invoke-ZmokQxo  reason: not valid java name */
                                            public final Boolean m1138invokeZmokQxo(android.view.KeyEvent keyEvent) {
                                                KeyCommand mo1200mapZmokQxo = KeyMapping_androidKt.getPlatformDefaultKeyMapping().mo1200mapZmokQxo(keyEvent);
                                                return Boolean.valueOf(mo1200mapZmokQxo == KeyCommand.COPY || mo1200mapZmokQxo == KeyCommand.CUT);
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue6);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    Modifier onPreviewKeyEvent = KeyInputModifierKt.onPreviewKeyEvent(semantics$default, (Function1) rememberedValue6);
                                    if (z10) {
                                        companion2 = secureTextFieldController.getFocusChangeModifier();
                                    } else {
                                        companion2 = Modifier.Companion;
                                    }
                                    final Modifier then = onPreviewKeyEvent.then(companion2);
                                    final KeyboardOptions keyboardOptions3 = obj4;
                                    final boolean z12 = z10;
                                    DisableCutCopy(ComposableLambdaKt.rememberComposableLambda(135148049, true, new Function2() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda5
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj5, Object obj6) {
                                            return BasicSecureTextFieldKt.BasicSecureTextField_ltb6GB4$lambda$6(z12, obj2, secureTextFieldController, textFieldState, then, z8, z9, textStyle4, keyboardOptions3, keyboardActionHandler3, function23, mutableInteractionSource3, brush3, codepointTransformation2, textFieldDecorator3, scrollState3, (Composer) obj5, ((Integer) obj6).intValue());
                                        }
                                    }, startRestartGroup, 54), startRestartGroup, 6);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    c2 = c4;
                                    modifier2 = companion;
                                    composer2 = startRestartGroup;
                                    i23 = i24;
                                    inputTransformation2 = obj2;
                                    z5 = z8;
                                    z6 = z9;
                                    textStyle2 = textStyle4;
                                    obj4 = keyboardOptions3;
                                    keyboardActionHandler2 = keyboardActionHandler3;
                                    function22 = function23;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                    brush2 = brush3;
                                    textFieldDecorator2 = textFieldDecorator3;
                                    scrollState2 = scrollState3;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    function22 = function2;
                                    i23 = i;
                                    c2 = c;
                                    composer2 = startRestartGroup;
                                    z5 = z3;
                                    z6 = z4;
                                    inputTransformation2 = obj2;
                                    modifier2 = obj;
                                    textStyle2 = obj3;
                                    keyboardActionHandler2 = keyboardActionHandler;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    brush2 = brush;
                                    textFieldDecorator2 = textFieldDecorator;
                                    scrollState2 = scrollState;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda6
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj5, Object obj6) {
                                            return BasicSecureTextFieldKt.BasicSecureTextField_ltb6GB4$lambda$7(TextFieldState.this, modifier2, z5, z6, inputTransformation2, textStyle2, obj4, keyboardActionHandler2, function22, mutableInteractionSource2, brush2, textFieldDecorator2, i23, c2, scrollState2, i2, i3, i4, (Composer) obj5, ((Integer) obj6).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i15 = i14;
                            i16 = i4 & 1024;
                            if (i16 != 0) {
                            }
                            i19 = i4 & 2048;
                            if (i19 != 0) {
                            }
                            if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                            }
                            int i292 = i18;
                            i20 = i4 & 8192;
                            if (i20 != 0) {
                            }
                            if ((i3 & 24576) == 0) {
                            }
                            i22 = i21;
                            if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 9363) != 9362, i5 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i13 = i12;
                        i14 = i4 & 512;
                        if (i14 == 0) {
                        }
                        i15 = i14;
                        i16 = i4 & 1024;
                        if (i16 != 0) {
                        }
                        i19 = i4 & 2048;
                        if (i19 != 0) {
                        }
                        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                        }
                        int i2922 = i18;
                        i20 = i4 & 8192;
                        if (i20 != 0) {
                        }
                        if ((i3 & 24576) == 0) {
                        }
                        i22 = i21;
                        if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 9363) != 9362, i5 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    obj2 = inputTransformation;
                    i9 = i4 & 32;
                    if (i9 != 0) {
                    }
                    i10 = i4 & 64;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 128;
                    if (i11 != 0) {
                    }
                    i12 = i4 & 256;
                    if (i12 != 0) {
                    }
                    i13 = i12;
                    i14 = i4 & 512;
                    if (i14 == 0) {
                    }
                    i15 = i14;
                    i16 = i4 & 1024;
                    if (i16 != 0) {
                    }
                    i19 = i4 & 2048;
                    if (i19 != 0) {
                    }
                    if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    }
                    int i29222 = i18;
                    i20 = i4 & 8192;
                    if (i20 != 0) {
                    }
                    if ((i3 & 24576) == 0) {
                    }
                    i22 = i21;
                    if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 9363) != 9362, i5 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z4 = z2;
                i8 = i4 & 16;
                int i282 = 8192;
                if (i8 == 0) {
                }
                obj2 = inputTransformation;
                i9 = i4 & 32;
                if (i9 != 0) {
                }
                i10 = i4 & 64;
                if (i10 != 0) {
                }
                i11 = i4 & 128;
                if (i11 != 0) {
                }
                i12 = i4 & 256;
                if (i12 != 0) {
                }
                i13 = i12;
                i14 = i4 & 512;
                if (i14 == 0) {
                }
                i15 = i14;
                i16 = i4 & 1024;
                if (i16 != 0) {
                }
                i19 = i4 & 2048;
                if (i19 != 0) {
                }
                if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                }
                int i292222 = i18;
                i20 = i4 & 8192;
                if (i20 != 0) {
                }
                if ((i3 & 24576) == 0) {
                }
                i22 = i21;
                if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 9363) != 9362, i5 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z3 = z;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            z4 = z2;
            i8 = i4 & 16;
            int i2822 = 8192;
            if (i8 == 0) {
            }
            obj2 = inputTransformation;
            i9 = i4 & 32;
            if (i9 != 0) {
            }
            i10 = i4 & 64;
            if (i10 != 0) {
            }
            i11 = i4 & 128;
            if (i11 != 0) {
            }
            i12 = i4 & 256;
            if (i12 != 0) {
            }
            i13 = i12;
            i14 = i4 & 512;
            if (i14 == 0) {
            }
            i15 = i14;
            i16 = i4 & 1024;
            if (i16 != 0) {
            }
            i19 = i4 & 2048;
            if (i19 != 0) {
            }
            if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            }
            int i2922222 = i18;
            i20 = i4 & 8192;
            if (i20 != 0) {
            }
            if ((i3 & 24576) == 0) {
            }
            i22 = i21;
            if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 9363) != 9362, i5 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        z3 = z;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        z4 = z2;
        i8 = i4 & 16;
        int i28222 = 8192;
        if (i8 == 0) {
        }
        obj2 = inputTransformation;
        i9 = i4 & 32;
        if (i9 != 0) {
        }
        i10 = i4 & 64;
        if (i10 != 0) {
        }
        i11 = i4 & 128;
        if (i11 != 0) {
        }
        i12 = i4 & 256;
        if (i12 != 0) {
        }
        i13 = i12;
        i14 = i4 & 512;
        if (i14 == 0) {
        }
        i15 = i14;
        i16 = i4 & 1024;
        if (i16 != 0) {
        }
        i19 = i4 & 2048;
        if (i19 != 0) {
        }
        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
        }
        int i29222222 = i18;
        i20 = i4 & 8192;
        if (i20 != 0) {
        }
        if ((i3 & 24576) == 0) {
        }
        i22 = i21;
        if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 9363) != 9362, i5 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int BasicSecureTextField_ltb6GB4$lambda$3$0(State state, int i, int i2) {
        return ((Character) state.getValue()).charValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicSecureTextField_ltb6GB4$lambda$4$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentType(semanticsPropertyReceiver, ContentType.Companion.getPassword());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BasicSecureTextField_ltb6GB4$lambda$6(boolean z, InputTransformation inputTransformation, SecureTextFieldController secureTextFieldController, TextFieldState textFieldState, Modifier modifier, boolean z2, boolean z3, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, CodepointTransformation codepointTransformation, TextFieldDecorator textFieldDecorator, ScrollState scrollState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C192@10377L875:BasicSecureTextField.kt#423gt5");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(135148049, i, -1, "androidx.compose.foundation.text.BasicSecureTextField.<anonymous> (BasicSecureTextField.kt:192)");
            }
            BasicTextFieldKt.BasicTextField(textFieldState, modifier, z2, z3, z ? then(inputTransformation, secureTextFieldController.getPasswordInputTransformation()) : inputTransformation, textStyle, keyboardOptions, keyboardActionHandler, TextFieldLineLimits.SingleLine.INSTANCE, function2, mutableInteractionSource, brush, codepointTransformation, null, textFieldDecorator, scrollState, true, composer, 100663296, 1572864, 8192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final InputTransformation then(InputTransformation inputTransformation, InputTransformation inputTransformation2) {
        return inputTransformation == null ? inputTransformation2 : inputTransformation2 == null ? inputTransformation : InputTransformationKt.then(inputTransformation, inputTransformation2);
    }

    private static final void DisableCutCopy(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1141174275);
        ComposerKt.sourceInformation(startRestartGroup, "C(DisableCutCopy)N(content)312@14862L7,314@14908L877,335@15790L80:BasicSecureTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1141174275, i2, -1, "androidx.compose.foundation.text.DisableCutCopy (BasicSecureTextField.kt:311)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final TextToolbar textToolbar = (TextToolbar) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1451823216, "CC(remember):BasicSecureTextField.kt#9igjgp");
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
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BasicSecureTextFieldKt.DisableCutCopy$lambda$1(Function2.this, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:202:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012a  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the overload that takes in readOnly parameter.")
    /* renamed from: BasicSecureTextField-Jb9bMDk  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1135BasicSecureTextFieldJb9bMDk(final TextFieldState textFieldState, Modifier modifier, boolean z, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, TextFieldDecorator textFieldDecorator, int i, char c, Composer composer, final int i2, final int i3, final int i4) {
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
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicSecureTextField)N(state,modifier,enabled,inputTransformation,textStyle,keyboardOptions,onKeyboardAction,onTextLayout,interactionSource,cursorBrush,decorator,textObfuscationMode:c#foundation.text.input.TextObfuscationMode,textObfuscationCharacter)364@17059L564:BasicSecureTextField.kt#423gt5");
        if ((i2 & 6) == 0) {
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
                                    if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
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
                                    } else {
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
                                        KeyboardOptions secureTextField$foundation = i25 != 0 ? KeyboardOptions.Companion.getSecureTextField$foundation() : obj5;
                                        KeyboardActionHandler keyboardActionHandler3 = i10 != 0 ? null : obj6;
                                        Function2 function23 = i12 != 0 ? null : function2;
                                        MutableInteractionSource mutableInteractionSource3 = i14 != 0 ? null : mutableInteractionSource;
                                        SolidColor solidColor = i16 != 0 ? new SolidColor(Color.Companion.m4798getBlack0d7_KjU(), null) : brush;
                                        TextFieldDecorator textFieldDecorator3 = i17 != 0 ? null : textFieldDecorator;
                                        int m1359getRevealLastTypedvTwcZD0 = i20 != 0 ? TextObfuscationMode.Companion.m1359getRevealLastTypedvTwcZD0() : i;
                                        char c3 = i21 != 0 ? (char) 8226 : c;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1399310985, i5, i22, "androidx.compose.foundation.text.BasicSecureTextField (BasicSecureTextField.kt:363)");
                                        }
                                        int i28 = i5 << 3;
                                        int i29 = i22 << 3;
                                        composer2 = startRestartGroup;
                                        m1137BasicSecureTextFieldltb6GB4(obj, companion, z4, false, inputTransformation3, textStyle3, secureTextField$foundation, keyboardActionHandler3, function23, mutableInteractionSource3, solidColor, textFieldDecorator3, m1359getRevealLastTypedvTwcZD0, c3, null, composer2, (i5 & 14) | 3072 | (i5 & 112) | (i5 & 896) | (57344 & i28) | (458752 & i28) | (3670016 & i28) | (29360128 & i28) | (234881024 & i28) | (i28 & 1879048192), ((i5 >> 27) & 14) | (i29 & 112) | (i29 & 896) | (i29 & 7168), 16384);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        modifier2 = companion;
                                        z3 = z4;
                                        inputTransformation2 = inputTransformation3;
                                        textStyle2 = textStyle3;
                                        keyboardOptions2 = secureTextField$foundation;
                                        keyboardActionHandler2 = keyboardActionHandler3;
                                        function22 = function23;
                                        mutableInteractionSource2 = mutableInteractionSource3;
                                        brush2 = solidColor;
                                        textFieldDecorator2 = textFieldDecorator3;
                                        i23 = m1359getRevealLastTypedvTwcZD0;
                                        c2 = c3;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup == null) {
                                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda2
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(Object obj7, Object obj8) {
                                                return BasicSecureTextFieldKt.BasicSecureTextField_Jb9bMDk$lambda$0(TextFieldState.this, modifier2, z3, inputTransformation2, textStyle2, keyboardOptions2, keyboardActionHandler2, function22, mutableInteractionSource2, brush2, textFieldDecorator2, i23, c2, i2, i3, i4, (Composer) obj7, ((Integer) obj8).intValue());
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
                                if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
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
                            if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
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
                        if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
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
                    if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
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
                if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
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
            if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
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
        if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:205:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012d  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the overload that takes in scrollState parameter.")
    /* renamed from: BasicSecureTextField-egD4TGM  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1136BasicSecureTextFieldegD4TGM(final TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, TextFieldDecorator textFieldDecorator, int i, char c, Composer composer, final int i2, final int i3, final int i4) {
        Object obj;
        int i5;
        Object obj2;
        int i6;
        boolean z3;
        int i7;
        Object obj3;
        int i8;
        Object obj4;
        int i9;
        Object obj5;
        int i10;
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
        final boolean z4;
        final KeyboardActionHandler keyboardActionHandler2;
        final Function2 function22;
        final int i23;
        final char c2;
        final boolean z5;
        final InputTransformation inputTransformation2;
        final TextStyle textStyle2;
        final KeyboardOptions keyboardOptions2;
        final Modifier modifier2;
        final MutableInteractionSource mutableInteractionSource2;
        final Brush brush2;
        final TextFieldDecorator textFieldDecorator2;
        ScopeUpdateScope endRestartGroup;
        int i24;
        Modifier.Companion companion;
        int i25;
        InputTransformation inputTransformation3;
        int i26;
        TextStyle textStyle3;
        Composer startRestartGroup = composer.startRestartGroup(-817513499);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicSecureTextField)N(state,modifier,enabled,readOnly,inputTransformation,textStyle,keyboardOptions,onKeyboardAction,onTextLayout,interactionSource,cursorBrush,decorator,textObfuscationMode:c#foundation.text.input.TextObfuscationMode,textObfuscationCharacter)421@19275L21,406@18694L609:BasicSecureTextField.kt#423gt5");
        if ((i2 & 6) == 0) {
            obj = textFieldState;
            i5 = (startRestartGroup.changed(obj) ? 4 : 2) | i2;
        } else {
            obj = textFieldState;
            i5 = i2;
        }
        int i27 = i4 & 2;
        if (i27 != 0) {
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
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else if ((i2 & 24576) == 0) {
                    obj3 = inputTransformation;
                    i5 |= startRestartGroup.changed(obj3) ? 16384 : 8192;
                    i8 = i4 & 32;
                    if (i8 == 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        obj4 = textStyle;
                    } else {
                        obj4 = textStyle;
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i5 |= startRestartGroup.changed(obj4) ? 131072 : 65536;
                        }
                    }
                    i9 = i4 & 64;
                    if (i9 == 0) {
                        i5 |= 1572864;
                        obj5 = keyboardOptions;
                    } else {
                        obj5 = keyboardOptions;
                        if ((i2 & 1572864) == 0) {
                            i5 |= startRestartGroup.changed(obj5) ? 1048576 : 524288;
                        }
                    }
                    i10 = i4 & 128;
                    if (i10 == 0) {
                        i5 |= 12582912;
                    } else if ((i2 & 12582912) == 0) {
                        i5 |= startRestartGroup.changed(keyboardActionHandler) ? 8388608 : 4194304;
                    }
                    i11 = i4 & 256;
                    if (i11 == 0) {
                        i5 |= 100663296;
                    } else if ((i2 & 100663296) == 0) {
                        i12 = i11;
                        i5 |= startRestartGroup.changedInstance(function2) ? 67108864 : 33554432;
                        i13 = i4 & 512;
                        if (i13 != 0) {
                            i5 |= 805306368;
                        } else if ((i2 & 805306368) == 0) {
                            i14 = i13;
                            i5 |= startRestartGroup.changed(mutableInteractionSource) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                            i15 = i4 & 1024;
                            if (i15 == 0) {
                                i17 = i3 | 6;
                                i16 = i15;
                            } else if ((i3 & 6) == 0) {
                                i16 = i15;
                                i17 = i3 | (startRestartGroup.changed(brush) ? 4 : 2);
                            } else {
                                i16 = i15;
                                i17 = i3;
                            }
                            i18 = i4 & 2048;
                            if (i18 == 0) {
                                i17 |= 48;
                            } else if ((i3 & 48) == 0) {
                                i17 |= (i3 & 64) == 0 ? startRestartGroup.changed(textFieldDecorator) : startRestartGroup.changedInstance(textFieldDecorator) ? 32 : 16;
                            }
                            int i28 = i17;
                            i19 = i4 & 4096;
                            if (i19 == 0) {
                                i20 = i28 | RendererCapabilities.DECODER_SUPPORT_MASK;
                            } else if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                i20 = i28 | (startRestartGroup.changed(i) ? 256 : 128);
                            } else {
                                i20 = i28;
                            }
                            i21 = i4 & 8192;
                            if (i21 == 0) {
                                i22 = i20 | 3072;
                            } else {
                                int i29 = i20;
                                if ((i3 & 3072) == 0) {
                                    i29 |= startRestartGroup.changed(c) ? 2048 : 1024;
                                }
                                i22 = i29;
                            }
                            if (startRestartGroup.shouldExecute((i5 & 306782355) == 306782354 || (i22 & 1171) != 1170, i5 & 1)) {
                                composer2 = startRestartGroup;
                                composer2.skipToGroupEnd();
                                z4 = z2;
                                keyboardActionHandler2 = keyboardActionHandler;
                                function22 = function2;
                                i23 = i;
                                c2 = c;
                                z5 = z3;
                                inputTransformation2 = obj3;
                                textStyle2 = obj4;
                                keyboardOptions2 = obj5;
                                modifier2 = obj2;
                                mutableInteractionSource2 = mutableInteractionSource;
                                brush2 = brush;
                                textFieldDecorator2 = textFieldDecorator;
                            } else {
                                if (i27 != 0) {
                                    companion = Modifier.Companion;
                                    i24 = i7;
                                } else {
                                    i24 = i7;
                                    companion = obj2;
                                }
                                boolean z6 = i6 != 0 ? true : z3;
                                boolean z7 = (i4 & 8) != 0 ? false : z2;
                                if (i24 != 0) {
                                    i25 = i21;
                                    inputTransformation3 = null;
                                } else {
                                    i25 = i21;
                                    inputTransformation3 = obj3;
                                }
                                if (i8 != 0) {
                                    textStyle3 = TextStyle.Companion.getDefault();
                                    i26 = i9;
                                } else {
                                    i26 = i9;
                                    textStyle3 = obj4;
                                }
                                KeyboardOptions secureTextField$foundation = i26 != 0 ? KeyboardOptions.Companion.getSecureTextField$foundation() : obj5;
                                KeyboardActionHandler keyboardActionHandler3 = i10 != 0 ? null : keyboardActionHandler;
                                Function2 function23 = i12 != 0 ? null : function2;
                                MutableInteractionSource mutableInteractionSource3 = i14 != 0 ? null : mutableInteractionSource;
                                SolidColor solidColor = i16 != 0 ? new SolidColor(Color.Companion.m4798getBlack0d7_KjU(), null) : brush;
                                TextFieldDecorator textFieldDecorator3 = i18 != 0 ? null : textFieldDecorator;
                                int m1359getRevealLastTypedvTwcZD0 = i19 != 0 ? TextObfuscationMode.Companion.m1359getRevealLastTypedvTwcZD0() : i;
                                char c3 = i25 != 0 ? (char) 8226 : c;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-817513499, i5, i22, "androidx.compose.foundation.text.BasicSecureTextField (BasicSecureTextField.kt:405)");
                                }
                                composer2 = startRestartGroup;
                                m1137BasicSecureTextFieldltb6GB4(obj, companion, z6, false, inputTransformation3, textStyle3, secureTextField$foundation, keyboardActionHandler3, function23, mutableInteractionSource3, solidColor, textFieldDecorator3, m1359getRevealLastTypedvTwcZD0, c3, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), composer2, (i5 & 14) | 3072 | (i5 & 112) | (i5 & 896) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | (234881024 & i5) | (1879048192 & i5), i22 & 8190, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z4 = z7;
                                modifier2 = companion;
                                z5 = z6;
                                inputTransformation2 = inputTransformation3;
                                textStyle2 = textStyle3;
                                keyboardOptions2 = secureTextField$foundation;
                                keyboardActionHandler2 = keyboardActionHandler3;
                                function22 = function23;
                                mutableInteractionSource2 = mutableInteractionSource3;
                                brush2 = solidColor;
                                textFieldDecorator2 = textFieldDecorator3;
                                i23 = m1359getRevealLastTypedvTwcZD0;
                                c2 = c3;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj6, Object obj7) {
                                        return BasicSecureTextFieldKt.BasicSecureTextField_egD4TGM$lambda$0(TextFieldState.this, modifier2, z5, z4, inputTransformation2, textStyle2, keyboardOptions2, keyboardActionHandler2, function22, mutableInteractionSource2, brush2, textFieldDecorator2, i23, c2, i2, i3, i4, (Composer) obj6, ((Integer) obj7).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i14 = i13;
                        i15 = i4 & 1024;
                        if (i15 == 0) {
                        }
                        i18 = i4 & 2048;
                        if (i18 == 0) {
                        }
                        int i282 = i17;
                        i19 = i4 & 4096;
                        if (i19 == 0) {
                        }
                        i21 = i4 & 8192;
                        if (i21 == 0) {
                        }
                        if (startRestartGroup.shouldExecute((i5 & 306782355) == 306782354 || (i22 & 1171) != 1170, i5 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i12 = i11;
                    i13 = i4 & 512;
                    if (i13 != 0) {
                    }
                    i14 = i13;
                    i15 = i4 & 1024;
                    if (i15 == 0) {
                    }
                    i18 = i4 & 2048;
                    if (i18 == 0) {
                    }
                    int i2822 = i17;
                    i19 = i4 & 4096;
                    if (i19 == 0) {
                    }
                    i21 = i4 & 8192;
                    if (i21 == 0) {
                    }
                    if (startRestartGroup.shouldExecute((i5 & 306782355) == 306782354 || (i22 & 1171) != 1170, i5 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj3 = inputTransformation;
                i8 = i4 & 32;
                if (i8 == 0) {
                }
                i9 = i4 & 64;
                if (i9 == 0) {
                }
                i10 = i4 & 128;
                if (i10 == 0) {
                }
                i11 = i4 & 256;
                if (i11 == 0) {
                }
                i12 = i11;
                i13 = i4 & 512;
                if (i13 != 0) {
                }
                i14 = i13;
                i15 = i4 & 1024;
                if (i15 == 0) {
                }
                i18 = i4 & 2048;
                if (i18 == 0) {
                }
                int i28222 = i17;
                i19 = i4 & 4096;
                if (i19 == 0) {
                }
                i21 = i4 & 8192;
                if (i21 == 0) {
                }
                if (startRestartGroup.shouldExecute((i5 & 306782355) == 306782354 || (i22 & 1171) != 1170, i5 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z3 = z;
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            obj3 = inputTransformation;
            i8 = i4 & 32;
            if (i8 == 0) {
            }
            i9 = i4 & 64;
            if (i9 == 0) {
            }
            i10 = i4 & 128;
            if (i10 == 0) {
            }
            i11 = i4 & 256;
            if (i11 == 0) {
            }
            i12 = i11;
            i13 = i4 & 512;
            if (i13 != 0) {
            }
            i14 = i13;
            i15 = i4 & 1024;
            if (i15 == 0) {
            }
            i18 = i4 & 2048;
            if (i18 == 0) {
            }
            int i282222 = i17;
            i19 = i4 & 4096;
            if (i19 == 0) {
            }
            i21 = i4 & 8192;
            if (i21 == 0) {
            }
            if (startRestartGroup.shouldExecute((i5 & 306782355) == 306782354 || (i22 & 1171) != 1170, i5 & 1)) {
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
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        obj3 = inputTransformation;
        i8 = i4 & 32;
        if (i8 == 0) {
        }
        i9 = i4 & 64;
        if (i9 == 0) {
        }
        i10 = i4 & 128;
        if (i10 == 0) {
        }
        i11 = i4 & 256;
        if (i11 == 0) {
        }
        i12 = i11;
        i13 = i4 & 512;
        if (i13 != 0) {
        }
        i14 = i13;
        i15 = i4 & 1024;
        if (i15 == 0) {
        }
        i18 = i4 & 2048;
        if (i18 == 0) {
        }
        int i2822222 = i17;
        i19 = i4 & 4096;
        if (i19 == 0) {
        }
        i21 = i4 & 8192;
        if (i21 == 0) {
        }
        if (startRestartGroup.shouldExecute((i5 & 306782355) == 306782354 || (i22 & 1171) != 1170, i5 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
