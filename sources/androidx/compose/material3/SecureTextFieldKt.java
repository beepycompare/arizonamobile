package androidx.compose.material3;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicSecureTextFieldKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextObfuscationMode;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.TextFieldLabelPosition;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: SecureTextField.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u008f\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2 \b\u0002\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"28\b\u0002\u0010#\u001a2\u0012\u0004\u0012\u00020%\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010&0\u0012¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u0001\u0018\u00010$¢\u0006\u0002\b\u00102\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020/2\n\b\u0002\u00100\u001a\u0004\u0018\u000101H\u0007¢\u0006\u0004\b2\u00103\u001a\u008f\u0003\u00104\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2 \b\u0002\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"28\b\u0002\u0010#\u001a2\u0012\u0004\u0012\u00020%\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010&0\u0012¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u0001\u0018\u00010$¢\u0006\u0002\b\u00102\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020/2\n\b\u0002\u00100\u001a\u0004\u0018\u000101H\u0007¢\u0006\u0004\b5\u00103\"\u000e\u00106\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u00107\u001a\u00020\u001eX\u0082T¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"SecureTextField", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", Constants.ScionAnalytics.PARAM_LABEL, "Lkotlin/Function1;", "Landroidx/compose/material3/TextFieldLabelScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "placeholder", "Lkotlin/Function0;", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textObfuscationMode", "Landroidx/compose/foundation/text/input/TextObfuscationMode;", "textObfuscationCharacter", "", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "SecureTextField-XvU6IwQ", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/material3/TextFieldLabelPosition;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/text/input/InputTransformation;ICLandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;IIII)V", "OutlinedSecureTextField", "OutlinedSecureTextField-XvU6IwQ", "SecureTextFieldKeyboardOptions", "DefaultObfuscationCharacter", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SecureTextFieldKt {
    private static final char DefaultObfuscationCharacter = 8226;
    private static final KeyboardOptions SecureTextFieldKeyboardOptions = new KeyboardOptions(0, (Boolean) false, KeyboardType.Companion.m7243getPasswordPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 121, (DefaultConstructorMarker) null);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OutlinedSecureTextField_XvU6IwQ$lambda$5(TextFieldState textFieldState, Modifier modifier, boolean z, TextStyle textStyle, TextFieldLabelPosition textFieldLabelPosition, Function3 function3, Function2 function2, Function2 function22, Function2 function23, Function2 function24, Function2 function25, Function2 function26, boolean z2, InputTransformation inputTransformation, int i, char c, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2 function27, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, int i2, int i3, int i4, int i5, Composer composer, int i6) {
        m2438OutlinedSecureTextFieldXvU6IwQ(textFieldState, modifier, z, textStyle, textFieldLabelPosition, function3, function2, function22, function23, function24, function25, function26, z2, inputTransformation, i, c, keyboardOptions, keyboardActionHandler, function27, shape, textFieldColors, paddingValues, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SecureTextField_XvU6IwQ$lambda$2(TextFieldState textFieldState, Modifier modifier, boolean z, TextStyle textStyle, TextFieldLabelPosition textFieldLabelPosition, Function3 function3, Function2 function2, Function2 function22, Function2 function23, Function2 function24, Function2 function25, Function2 function26, boolean z2, InputTransformation inputTransformation, int i, char c, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2 function27, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, int i2, int i3, int i4, int i5, Composer composer, int i6) {
        m2439SecureTextFieldXvU6IwQ(textFieldState, modifier, z, textStyle, textFieldLabelPosition, function3, function2, function22, function23, function24, function25, function26, z2, inputTransformation, i, c, keyboardOptions, keyboardActionHandler, function27, shape, textFieldColors, paddingValues, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:158:0x01e9, code lost:
        if (r4.changed(r79) == false) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x05e6  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0617  */
    /* JADX WARN: Removed duplicated region for block: B:370:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010d  */
    /* renamed from: SecureTextField-XvU6IwQ  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2439SecureTextFieldXvU6IwQ(final TextFieldState textFieldState, Modifier modifier, boolean z, TextStyle textStyle, TextFieldLabelPosition textFieldLabelPosition, Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, boolean z2, InputTransformation inputTransformation, int i, char c, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function27, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Composer composer, final int i2, final int i3, final int i4, final int i5) {
        final TextFieldState textFieldState2;
        int i6;
        Modifier.Companion companion;
        int i7;
        TextStyle textStyle2;
        TextFieldLabelPosition.Attached attached;
        int i8;
        Object obj;
        int i9;
        Object obj2;
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
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        final boolean z3;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final boolean z4;
        final int i31;
        final char c2;
        final KeyboardOptions keyboardOptions2;
        final KeyboardActionHandler keyboardActionHandler2;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function210;
        final Shape shape2;
        final TextFieldColors textFieldColors2;
        final PaddingValues paddingValues2;
        final MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        final TextStyle textStyle3;
        final TextFieldLabelPosition textFieldLabelPosition2;
        final Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function32;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final InputTransformation inputTransformation2;
        ScopeUpdateScope endRestartGroup;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        int i32;
        Shape shape3;
        PaddingValues paddingValues3;
        final int i33;
        final Shape shape4;
        final Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function33;
        final char c3;
        final InputTransformation inputTransformation3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActionHandler keyboardActionHandler3;
        final boolean z5;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function216;
        int i34;
        final PaddingValues paddingValues4;
        final Function2<? super Composer, ? super Integer, Unit> function217;
        final Function2<? super Composer, ? super Integer, Unit> function218;
        final Function2<? super Composer, ? super Integer, Unit> function219;
        final Function2<? super Composer, ? super Integer, Unit> function220;
        final boolean z6;
        final Function2<? super Composer, ? super Integer, Unit> function221;
        final TextFieldLabelPosition textFieldLabelPosition3;
        final Modifier modifier3;
        final TextFieldColors textFieldColors3;
        MutableInteractionSource mutableInteractionSource3;
        final MutableInteractionSource mutableInteractionSource4;
        int i35;
        int i36;
        Composer startRestartGroup = composer.startRestartGroup(1177133806);
        ComposerKt.sourceInformation(startRestartGroup, "C(SecureTextField)N(state,modifier,enabled,textStyle,labelPosition,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,isError,inputTransformation,textObfuscationMode:c#foundation.text.input.TextObfuscationMode,textObfuscationCharacter,keyboardOptions,onKeyboardAction,onTextLayout,shape,colors,contentPadding,interactionSource)166@9935L2109,166@9848L2196:SecureTextField.kt#uh7d8r");
        if ((i5 & 1) != 0) {
            i6 = i2 | 6;
            textFieldState2 = textFieldState;
        } else {
            textFieldState2 = textFieldState;
            if ((i2 & 6) == 0) {
                i6 = (startRestartGroup.changed(textFieldState2) ? 4 : 2) | i2;
            } else {
                i6 = i2;
            }
        }
        int i37 = i5 & 2;
        if (i37 != 0) {
            i6 |= 48;
        } else if ((i2 & 48) == 0) {
            companion = modifier;
            i6 |= startRestartGroup.changed(companion) ? 32 : 16;
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i6 |= startRestartGroup.changed(z) ? 256 : 128;
                if ((i2 & 3072) == 0) {
                    if ((i5 & 8) == 0) {
                        textStyle2 = textStyle;
                        if (startRestartGroup.changed(textStyle2)) {
                            i36 = 2048;
                            i6 |= i36;
                        }
                    } else {
                        textStyle2 = textStyle;
                    }
                    i36 = 1024;
                    i6 |= i36;
                } else {
                    textStyle2 = textStyle;
                }
                int i38 = 16384;
                if ((i2 & 24576) == 0) {
                    if ((i5 & 16) == 0) {
                        attached = textFieldLabelPosition;
                        if (startRestartGroup.changed(attached)) {
                            i35 = 16384;
                            i6 |= i35;
                        }
                    } else {
                        attached = textFieldLabelPosition;
                    }
                    i35 = 8192;
                    i6 |= i35;
                } else {
                    attached = textFieldLabelPosition;
                }
                i8 = i5 & 32;
                if (i8 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    obj = function3;
                } else {
                    obj = function3;
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i6 |= startRestartGroup.changedInstance(obj) ? 131072 : 65536;
                    }
                }
                i9 = i5 & 64;
                if (i9 != 0) {
                    i6 |= 1572864;
                    obj2 = function2;
                } else {
                    obj2 = function2;
                    if ((i2 & 1572864) == 0) {
                        i6 |= startRestartGroup.changedInstance(obj2) ? 1048576 : 524288;
                    }
                }
                i10 = i5 & 128;
                if (i10 != 0) {
                    i6 |= 12582912;
                } else if ((i2 & 12582912) == 0) {
                    i6 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                }
                i11 = i5 & 256;
                if (i11 != 0) {
                    i6 |= 100663296;
                } else if ((i2 & 100663296) == 0) {
                    i12 = i11;
                    i6 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                    i13 = i5 & 512;
                    if (i13 == 0) {
                        i6 |= 805306368;
                    } else if ((i2 & 805306368) == 0) {
                        i14 = i13;
                        i6 |= startRestartGroup.changedInstance(function24) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        i15 = i5 & 1024;
                        if (i15 != 0) {
                            i17 = i3 | 6;
                            i16 = i15;
                        } else if ((i3 & 6) == 0) {
                            i16 = i15;
                            i17 = i3 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                        } else {
                            i16 = i15;
                            i17 = i3;
                        }
                        i18 = i5 & 2048;
                        if (i18 != 0) {
                            i17 |= 48;
                            i19 = i18;
                        } else if ((i3 & 48) == 0) {
                            i19 = i18;
                            i17 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
                        } else {
                            i19 = i18;
                        }
                        int i39 = i17;
                        i20 = i5 & 4096;
                        if (i20 != 0) {
                            i21 = i39 | RendererCapabilities.DECODER_SUPPORT_MASK;
                        } else {
                            int i40 = i39;
                            if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                i40 |= startRestartGroup.changed(z2) ? 256 : 128;
                            }
                            i21 = i40;
                        }
                        i22 = i5 & 8192;
                        if (i22 != 0) {
                            i23 = i21 | 3072;
                        } else {
                            i23 = i21;
                            if ((i3 & 3072) == 0) {
                                i23 |= startRestartGroup.changed(inputTransformation) ? 2048 : 1024;
                                if ((i3 & 24576) == 0) {
                                    if ((i5 & 16384) != 0) {
                                    }
                                    i38 = 8192;
                                    i23 |= i38;
                                }
                                i24 = i5 & 32768;
                                if (i24 == 0) {
                                    i23 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i23 |= startRestartGroup.changed(c) ? 131072 : 65536;
                                }
                                i25 = i5 & 65536;
                                if (i25 == 0) {
                                    i23 |= 1572864;
                                } else if ((i3 & 1572864) == 0) {
                                    i23 |= startRestartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                                }
                                i26 = i5 & 131072;
                                if (i26 == 0) {
                                    i23 |= 12582912;
                                } else if ((i3 & 12582912) == 0) {
                                    i23 |= startRestartGroup.changed(keyboardActionHandler) ? 8388608 : 4194304;
                                }
                                i27 = i5 & 262144;
                                if (i27 == 0) {
                                    i23 |= 100663296;
                                } else if ((i3 & 100663296) == 0) {
                                    i23 |= startRestartGroup.changedInstance(function27) ? 67108864 : 33554432;
                                }
                                if ((i3 & 805306368) == 0) {
                                    i23 |= ((i5 & 524288) == 0 && startRestartGroup.changed(shape)) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                                }
                                if ((i4 & 6) != 0) {
                                    i28 = i4 | (((i5 & 1048576) == 0 && startRestartGroup.changed(textFieldColors)) ? 4 : 2);
                                } else {
                                    i28 = i4;
                                }
                                if ((i4 & 48) == 0) {
                                    i28 |= ((i5 & 2097152) == 0 && startRestartGroup.changed(paddingValues)) ? 32 : 16;
                                }
                                int i41 = i28;
                                i29 = i5 & 4194304;
                                if (i29 == 0) {
                                    i30 = i41 | RendererCapabilities.DECODER_SUPPORT_MASK;
                                } else {
                                    int i42 = i41;
                                    if ((i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                        i42 |= startRestartGroup.changed(mutableInteractionSource) ? 256 : 128;
                                    }
                                    i30 = i42;
                                }
                                if (!startRestartGroup.shouldExecute(((i6 & 306783379) != 306783378 && (i23 & 306783379) == 306783378 && (i30 & 147) == 146) ? false : true, i6 & 1)) {
                                    startRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(startRestartGroup, "130@8055L7,146@8985L5,147@9040L8");
                                    if ((i2 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i5 & 8) != 0) {
                                            i6 &= -7169;
                                        }
                                        if ((i5 & 16) != 0) {
                                            i6 &= -57345;
                                        }
                                        if ((i5 & 16384) != 0) {
                                            i23 &= -57345;
                                        }
                                        if ((i5 & 524288) != 0) {
                                            i23 &= -1879048193;
                                        }
                                        z6 = z;
                                        function217 = function22;
                                        function218 = function23;
                                        function221 = function24;
                                        function220 = function25;
                                        function215 = function26;
                                        inputTransformation3 = inputTransformation;
                                        i33 = i;
                                        c3 = c;
                                        keyboardOptions3 = keyboardOptions;
                                        keyboardActionHandler3 = keyboardActionHandler;
                                        function216 = function27;
                                        shape4 = shape;
                                        paddingValues4 = paddingValues;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        textFieldLabelPosition3 = attached;
                                        function33 = obj;
                                        modifier3 = companion;
                                        function219 = obj2;
                                        i34 = i23;
                                        z5 = z2;
                                        textFieldColors3 = textFieldColors;
                                    } else {
                                        if (i37 != 0) {
                                            companion = Modifier.Companion;
                                        }
                                        boolean z7 = i7 != 0 ? true : z;
                                        if ((i5 & 8) != 0) {
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object consume = startRestartGroup.consume(TextKt.getLocalTextStyle());
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            i6 &= -7169;
                                            textStyle2 = (TextStyle) consume;
                                        }
                                        if ((i5 & 16) != 0) {
                                            i6 &= -57345;
                                            attached = new TextFieldLabelPosition.Attached(false, null, null, 7, null);
                                        }
                                        if (i8 != 0) {
                                            obj = null;
                                        }
                                        if (i9 != 0) {
                                            obj2 = null;
                                        }
                                        Function2<? super Composer, ? super Integer, Unit> function222 = i10 != 0 ? null : function22;
                                        Function2<? super Composer, ? super Integer, Unit> function223 = i12 != 0 ? null : function23;
                                        Function2<? super Composer, ? super Integer, Unit> function224 = i14 != 0 ? null : function24;
                                        Function2<? super Composer, ? super Integer, Unit> function225 = i16 != 0 ? null : function25;
                                        function215 = i19 != 0 ? null : function26;
                                        boolean z8 = i20 != 0 ? false : z2;
                                        InputTransformation inputTransformation4 = i22 != 0 ? null : inputTransformation;
                                        if ((i5 & 16384) != 0) {
                                            i32 = TextObfuscationMode.Companion.m1359getRevealLastTypedvTwcZD0();
                                            i23 &= -57345;
                                        } else {
                                            i32 = i;
                                        }
                                        char c4 = i24 != 0 ? (char) 8226 : c;
                                        KeyboardOptions keyboardOptions4 = i25 != 0 ? SecureTextFieldKeyboardOptions : keyboardOptions;
                                        KeyboardActionHandler keyboardActionHandler4 = i26 != 0 ? null : keyboardActionHandler;
                                        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function226 = i27 != 0 ? null : function27;
                                        if ((i5 & 524288) != 0) {
                                            shape3 = TextFieldDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                            i23 &= -1879048193;
                                        } else {
                                            shape3 = shape;
                                        }
                                        boolean z9 = z7;
                                        TextFieldColors colors = (i5 & 1048576) != 0 ? TextFieldDefaults.INSTANCE.colors(startRestartGroup, 6) : textFieldColors;
                                        if ((2097152 & i5) == 0) {
                                            paddingValues3 = paddingValues;
                                        } else if (obj == null || (attached instanceof TextFieldLabelPosition.Above)) {
                                            paddingValues3 = TextFieldDefaults.m2682contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                        } else {
                                            paddingValues3 = TextFieldDefaults.m2681contentPaddingWithLabela9UjIt4$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                        }
                                        i33 = i32;
                                        shape4 = shape3;
                                        if (i29 != 0) {
                                            function33 = obj;
                                            c3 = c4;
                                            inputTransformation3 = inputTransformation4;
                                            keyboardOptions3 = keyboardOptions4;
                                            keyboardActionHandler3 = keyboardActionHandler4;
                                            z5 = z8;
                                            function216 = function226;
                                            i34 = i23;
                                            paddingValues4 = paddingValues3;
                                            function217 = function222;
                                            function218 = function223;
                                            function219 = obj2;
                                            function220 = function225;
                                            z6 = z9;
                                            function221 = function224;
                                            textFieldLabelPosition3 = attached;
                                            modifier3 = companion;
                                            textFieldColors3 = colors;
                                            mutableInteractionSource3 = null;
                                        } else {
                                            function33 = obj;
                                            c3 = c4;
                                            inputTransformation3 = inputTransformation4;
                                            keyboardOptions3 = keyboardOptions4;
                                            keyboardActionHandler3 = keyboardActionHandler4;
                                            z5 = z8;
                                            function216 = function226;
                                            i34 = i23;
                                            paddingValues4 = paddingValues3;
                                            function217 = function222;
                                            function218 = function223;
                                            function219 = obj2;
                                            function220 = function225;
                                            z6 = z9;
                                            function221 = function224;
                                            textFieldLabelPosition3 = attached;
                                            modifier3 = companion;
                                            textFieldColors3 = colors;
                                            mutableInteractionSource3 = mutableInteractionSource;
                                        }
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1177133806, i6, i34, "androidx.compose.material3.SecureTextField (SecureTextField.kt:155)");
                                    }
                                    if (mutableInteractionSource3 == null) {
                                        startRestartGroup.startReplaceGroup(-413168883);
                                        ComposerKt.sourceInformation(startRestartGroup, "157@9449L39");
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1649239957, "CC(remember):SecureTextField.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.Companion.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        startRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = (MutableInteractionSource) rememberedValue;
                                    } else {
                                        startRestartGroup.startReplaceGroup(1649239306);
                                        startRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                    }
                                    startRestartGroup.startReplaceGroup(1649245416);
                                    ComposerKt.sourceInformation(startRestartGroup, "*161@9673L25");
                                    long m7033getColor0d7_KjU = textStyle2.m7033getColor0d7_KjU();
                                    if (m7033getColor0d7_KjU == 16) {
                                        m7033getColor0d7_KjU = textFieldColors3.m2679textColorXeAY9LY$material3(z6, z5, FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource4, startRestartGroup, 0).getValue().booleanValue());
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    final TextStyle merge = textStyle2.merge(new TextStyle(m7033getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                    CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColors3.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(-2072926674, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SecureTextFieldKt$SecureTextField$1
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i43) {
                                            ComposerKt.sourceInformation(composer3, "C171@10094L38,204@11657L351,187@10882L1145,167@9945L2093:SecureTextField.kt#uh7d8r");
                                            if (!composer3.shouldExecute((i43 & 3) != 2, i43 & 1)) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2072926674, i43, -1, "androidx.compose.material3.SecureTextField.<anonymous> (SecureTextField.kt:167)");
                                            }
                                            Modifier modifier4 = Modifier.this;
                                            boolean z10 = z5;
                                            Strings.Companion companion2 = Strings.Companion;
                                            Modifier m848defaultMinSizeVpY3zN4 = SizeKt.m848defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier4, z10, Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(androidx.compose.ui.R.string.default_error_message), composer3, 0)), TextFieldDefaults.INSTANCE.m2698getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m2697getMinHeightD9Ej5fM());
                                            SolidColor solidColor = new SolidColor(textFieldColors3.m2629cursorColorvNxB06k$material3(z5), null);
                                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                                            TextFieldLabelPosition textFieldLabelPosition4 = textFieldLabelPosition3;
                                            Function3<TextFieldLabelScope, Composer, Integer, Unit> function34 = function33;
                                            Function2<Composer, Integer, Unit> function227 = function219;
                                            Function2<Composer, Integer, Unit> function228 = function217;
                                            Function2<Composer, Integer, Unit> function229 = function218;
                                            Function2<Composer, Integer, Unit> function230 = function221;
                                            Function2<Composer, Integer, Unit> function231 = function220;
                                            Function2<Composer, Integer, Unit> function232 = function215;
                                            boolean z11 = z5;
                                            TextFieldColors textFieldColors4 = textFieldColors3;
                                            PaddingValues paddingValues5 = paddingValues4;
                                            final boolean z12 = z6;
                                            final boolean z13 = z5;
                                            final MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource4;
                                            final TextFieldColors textFieldColors5 = textFieldColors3;
                                            final Shape shape5 = shape4;
                                            BasicSecureTextFieldKt.m1136BasicSecureTextFieldegD4TGM(textFieldState2, m848defaultMinSizeVpY3zN4, z6, false, inputTransformation3, merge, keyboardOptions3, keyboardActionHandler3, function216, mutableInteractionSource4, solidColor, TextFieldDefaults.INSTANCE.decorator(textFieldState2, z6, TextFieldLineLimits.SingleLine.INSTANCE, null, mutableInteractionSource5, textFieldLabelPosition4, function34, function227, function228, function229, function230, function231, function232, z11, textFieldColors4, paddingValues5, ComposableLambdaKt.rememberComposableLambda(-43781811, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SecureTextFieldKt$SecureTextField$1.1
                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                    invoke(composer4, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer4, int i44) {
                                                    ComposerKt.sourceInformation(composer4, "C205@11701L285:SecureTextField.kt#uh7d8r");
                                                    if (!composer4.shouldExecute((i44 & 3) != 2, i44 & 1)) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-43781811, i44, -1, "androidx.compose.material3.SecureTextField.<anonymous>.<anonymous> (SecureTextField.kt:205)");
                                                    }
                                                    TextFieldDefaults.INSTANCE.m2691Container4EFweAY(z12, z13, mutableInteractionSource6, null, textFieldColors5, shape5, 0.0f, 0.0f, composer4, 100663296, 200);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, composer3, 54), composer3, 3456, 14155776, 0), i33, c3, composer3, 0, 0, 8);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    Function2<? super Composer, ? super Integer, Unit> function227 = function220;
                                    textFieldColors2 = textFieldColors3;
                                    function214 = function227;
                                    modifier2 = modifier3;
                                    z3 = z6;
                                    textFieldLabelPosition2 = textFieldLabelPosition3;
                                    function32 = function33;
                                    function28 = function217;
                                    function212 = function218;
                                    function29 = function215;
                                    paddingValues2 = paddingValues4;
                                    inputTransformation2 = inputTransformation3;
                                    keyboardActionHandler2 = keyboardActionHandler3;
                                    function210 = function216;
                                    i31 = i33;
                                    c2 = c3;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                    composer2 = startRestartGroup;
                                    textStyle3 = textStyle2;
                                    z4 = z5;
                                    function211 = function219;
                                    function213 = function221;
                                    keyboardOptions2 = keyboardOptions3;
                                    shape2 = shape4;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    z3 = z;
                                    function28 = function22;
                                    function29 = function26;
                                    z4 = z2;
                                    i31 = i;
                                    c2 = c;
                                    keyboardOptions2 = keyboardOptions;
                                    keyboardActionHandler2 = keyboardActionHandler;
                                    function210 = function27;
                                    shape2 = shape;
                                    textFieldColors2 = textFieldColors;
                                    paddingValues2 = paddingValues;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    composer2 = startRestartGroup;
                                    textStyle3 = textStyle2;
                                    textFieldLabelPosition2 = attached;
                                    function32 = obj;
                                    modifier2 = companion;
                                    function211 = obj2;
                                    function212 = function23;
                                    function213 = function24;
                                    function214 = function25;
                                    inputTransformation2 = inputTransformation;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SecureTextFieldKt$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj3, Object obj4) {
                                            return SecureTextFieldKt.SecureTextField_XvU6IwQ$lambda$2(TextFieldState.this, modifier2, z3, textStyle3, textFieldLabelPosition2, function32, function211, function28, function212, function213, function214, function29, z4, inputTransformation2, i31, c2, keyboardOptions2, keyboardActionHandler2, function210, shape2, textFieldColors2, paddingValues2, mutableInteractionSource2, i2, i3, i4, i5, (Composer) obj3, ((Integer) obj4).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                        }
                        if ((i3 & 24576) == 0) {
                        }
                        i24 = i5 & 32768;
                        if (i24 == 0) {
                        }
                        i25 = i5 & 65536;
                        if (i25 == 0) {
                        }
                        i26 = i5 & 131072;
                        if (i26 == 0) {
                        }
                        i27 = i5 & 262144;
                        if (i27 == 0) {
                        }
                        if ((i3 & 805306368) == 0) {
                        }
                        if ((i4 & 6) != 0) {
                        }
                        if ((i4 & 48) == 0) {
                        }
                        int i412 = i28;
                        i29 = i5 & 4194304;
                        if (i29 == 0) {
                        }
                        if (!startRestartGroup.shouldExecute(((i6 & 306783379) != 306783378 && (i23 & 306783379) == 306783378 && (i30 & 147) == 146) ? false : true, i6 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i14 = i13;
                    i15 = i5 & 1024;
                    if (i15 != 0) {
                    }
                    i18 = i5 & 2048;
                    if (i18 != 0) {
                    }
                    int i392 = i17;
                    i20 = i5 & 4096;
                    if (i20 != 0) {
                    }
                    i22 = i5 & 8192;
                    if (i22 != 0) {
                    }
                    if ((i3 & 24576) == 0) {
                    }
                    i24 = i5 & 32768;
                    if (i24 == 0) {
                    }
                    i25 = i5 & 65536;
                    if (i25 == 0) {
                    }
                    i26 = i5 & 131072;
                    if (i26 == 0) {
                    }
                    i27 = i5 & 262144;
                    if (i27 == 0) {
                    }
                    if ((i3 & 805306368) == 0) {
                    }
                    if ((i4 & 6) != 0) {
                    }
                    if ((i4 & 48) == 0) {
                    }
                    int i4122 = i28;
                    i29 = i5 & 4194304;
                    if (i29 == 0) {
                    }
                    if (!startRestartGroup.shouldExecute(((i6 & 306783379) != 306783378 && (i23 & 306783379) == 306783378 && (i30 & 147) == 146) ? false : true, i6 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i12 = i11;
                i13 = i5 & 512;
                if (i13 == 0) {
                }
                i14 = i13;
                i15 = i5 & 1024;
                if (i15 != 0) {
                }
                i18 = i5 & 2048;
                if (i18 != 0) {
                }
                int i3922 = i17;
                i20 = i5 & 4096;
                if (i20 != 0) {
                }
                i22 = i5 & 8192;
                if (i22 != 0) {
                }
                if ((i3 & 24576) == 0) {
                }
                i24 = i5 & 32768;
                if (i24 == 0) {
                }
                i25 = i5 & 65536;
                if (i25 == 0) {
                }
                i26 = i5 & 131072;
                if (i26 == 0) {
                }
                i27 = i5 & 262144;
                if (i27 == 0) {
                }
                if ((i3 & 805306368) == 0) {
                }
                if ((i4 & 6) != 0) {
                }
                if ((i4 & 48) == 0) {
                }
                int i41222 = i28;
                i29 = i5 & 4194304;
                if (i29 == 0) {
                }
                if (!startRestartGroup.shouldExecute(((i6 & 306783379) != 306783378 && (i23 & 306783379) == 306783378 && (i30 & 147) == 146) ? false : true, i6 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            if ((i2 & 3072) == 0) {
            }
            int i382 = 16384;
            if ((i2 & 24576) == 0) {
            }
            i8 = i5 & 32;
            if (i8 != 0) {
            }
            i9 = i5 & 64;
            if (i9 != 0) {
            }
            i10 = i5 & 128;
            if (i10 != 0) {
            }
            i11 = i5 & 256;
            if (i11 != 0) {
            }
            i12 = i11;
            i13 = i5 & 512;
            if (i13 == 0) {
            }
            i14 = i13;
            i15 = i5 & 1024;
            if (i15 != 0) {
            }
            i18 = i5 & 2048;
            if (i18 != 0) {
            }
            int i39222 = i17;
            i20 = i5 & 4096;
            if (i20 != 0) {
            }
            i22 = i5 & 8192;
            if (i22 != 0) {
            }
            if ((i3 & 24576) == 0) {
            }
            i24 = i5 & 32768;
            if (i24 == 0) {
            }
            i25 = i5 & 65536;
            if (i25 == 0) {
            }
            i26 = i5 & 131072;
            if (i26 == 0) {
            }
            i27 = i5 & 262144;
            if (i27 == 0) {
            }
            if ((i3 & 805306368) == 0) {
            }
            if ((i4 & 6) != 0) {
            }
            if ((i4 & 48) == 0) {
            }
            int i412222 = i28;
            i29 = i5 & 4194304;
            if (i29 == 0) {
            }
            if (!startRestartGroup.shouldExecute(((i6 & 306783379) != 306783378 && (i23 & 306783379) == 306783378 && (i30 & 147) == 146) ? false : true, i6 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        companion = modifier;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        if ((i2 & 3072) == 0) {
        }
        int i3822 = 16384;
        if ((i2 & 24576) == 0) {
        }
        i8 = i5 & 32;
        if (i8 != 0) {
        }
        i9 = i5 & 64;
        if (i9 != 0) {
        }
        i10 = i5 & 128;
        if (i10 != 0) {
        }
        i11 = i5 & 256;
        if (i11 != 0) {
        }
        i12 = i11;
        i13 = i5 & 512;
        if (i13 == 0) {
        }
        i14 = i13;
        i15 = i5 & 1024;
        if (i15 != 0) {
        }
        i18 = i5 & 2048;
        if (i18 != 0) {
        }
        int i392222 = i17;
        i20 = i5 & 4096;
        if (i20 != 0) {
        }
        i22 = i5 & 8192;
        if (i22 != 0) {
        }
        if ((i3 & 24576) == 0) {
        }
        i24 = i5 & 32768;
        if (i24 == 0) {
        }
        i25 = i5 & 65536;
        if (i25 == 0) {
        }
        i26 = i5 & 131072;
        if (i26 == 0) {
        }
        i27 = i5 & 262144;
        if (i27 == 0) {
        }
        if ((i3 & 805306368) == 0) {
        }
        if ((i4 & 6) != 0) {
        }
        if ((i4 & 48) == 0) {
        }
        int i4122222 = i28;
        i29 = i5 & 4194304;
        if (i29 == 0) {
        }
        if (!startRestartGroup.shouldExecute(((i6 & 306783379) != 306783378 && (i23 & 306783379) == 306783378 && (i30 & 147) == 146) ? false : true, i6 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:158:0x01e9, code lost:
        if (r4.changed(r79) == false) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:365:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010d  */
    /* renamed from: OutlinedSecureTextField-XvU6IwQ  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2438OutlinedSecureTextFieldXvU6IwQ(final TextFieldState textFieldState, Modifier modifier, boolean z, TextStyle textStyle, TextFieldLabelPosition textFieldLabelPosition, Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, boolean z2, InputTransformation inputTransformation, int i, char c, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function27, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Composer composer, final int i2, final int i3, final int i4, final int i5) {
        TextFieldState textFieldState2;
        int i6;
        Modifier.Companion companion;
        int i7;
        TextStyle textStyle2;
        TextFieldLabelPosition.Attached attached;
        int i8;
        Object obj;
        int i9;
        Object obj2;
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
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        final boolean z3;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final InputTransformation inputTransformation2;
        final int i31;
        final char c2;
        final KeyboardOptions keyboardOptions2;
        final KeyboardActionHandler keyboardActionHandler2;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function210;
        final Shape shape2;
        final TextFieldColors textFieldColors2;
        final PaddingValues paddingValues2;
        final MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        final TextStyle textStyle3;
        final TextFieldLabelPosition textFieldLabelPosition2;
        final Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function32;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final boolean z4;
        ScopeUpdateScope endRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function215;
        int i32;
        Shape shape3;
        TextFieldLabelPosition textFieldLabelPosition3;
        Modifier modifier3;
        int i33;
        Shape shape4;
        char c3;
        InputTransformation inputTransformation3;
        KeyboardOptions keyboardOptions3;
        KeyboardActionHandler keyboardActionHandler3;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function216;
        int i34;
        Function2<? super Composer, ? super Integer, Unit> function217;
        Function2<? super Composer, ? super Integer, Unit> function218;
        Function2<? super Composer, ? super Integer, Unit> function219;
        Function2<? super Composer, ? super Integer, Unit> function220;
        boolean z5;
        TextFieldColors colors;
        PaddingValues m2345contentPaddinga9UjIt4$default;
        Function2<? super Composer, ? super Integer, Unit> function221;
        boolean z6;
        MutableInteractionSource mutableInteractionSource3;
        MutableInteractionSource mutableInteractionSource4;
        int i35;
        int i36;
        Composer startRestartGroup = composer.startRestartGroup(-273370384);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedSecureTextField)N(state,modifier,enabled,textStyle,labelPosition,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,isError,inputTransformation,textObfuscationMode:c#foundation.text.input.TextObfuscationMode,textObfuscationCharacter,keyboardOptions,onKeyboardAction,onTextLayout,shape,colors,contentPadding,interactionSource)326@19422L2745,326@19335L2832:SecureTextField.kt#uh7d8r");
        if ((i5 & 1) != 0) {
            i6 = i2 | 6;
            textFieldState2 = textFieldState;
        } else {
            textFieldState2 = textFieldState;
            if ((i2 & 6) == 0) {
                i6 = (startRestartGroup.changed(textFieldState2) ? 4 : 2) | i2;
            } else {
                i6 = i2;
            }
        }
        int i37 = i5 & 2;
        if (i37 != 0) {
            i6 |= 48;
        } else if ((i2 & 48) == 0) {
            companion = modifier;
            i6 |= startRestartGroup.changed(companion) ? 32 : 16;
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i6 |= startRestartGroup.changed(z) ? 256 : 128;
                if ((i2 & 3072) == 0) {
                    if ((i5 & 8) == 0) {
                        textStyle2 = textStyle;
                        if (startRestartGroup.changed(textStyle2)) {
                            i36 = 2048;
                            i6 |= i36;
                        }
                    } else {
                        textStyle2 = textStyle;
                    }
                    i36 = 1024;
                    i6 |= i36;
                } else {
                    textStyle2 = textStyle;
                }
                int i38 = 16384;
                if ((i2 & 24576) == 0) {
                    if ((i5 & 16) == 0) {
                        attached = textFieldLabelPosition;
                        if (startRestartGroup.changed(attached)) {
                            i35 = 16384;
                            i6 |= i35;
                        }
                    } else {
                        attached = textFieldLabelPosition;
                    }
                    i35 = 8192;
                    i6 |= i35;
                } else {
                    attached = textFieldLabelPosition;
                }
                i8 = i5 & 32;
                if (i8 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    obj = function3;
                } else {
                    obj = function3;
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i6 |= startRestartGroup.changedInstance(obj) ? 131072 : 65536;
                    }
                }
                i9 = i5 & 64;
                if (i9 != 0) {
                    i6 |= 1572864;
                    obj2 = function2;
                } else {
                    obj2 = function2;
                    if ((i2 & 1572864) == 0) {
                        i6 |= startRestartGroup.changedInstance(obj2) ? 1048576 : 524288;
                    }
                }
                i10 = i5 & 128;
                if (i10 != 0) {
                    i6 |= 12582912;
                } else if ((i2 & 12582912) == 0) {
                    i6 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                }
                i11 = i5 & 256;
                if (i11 != 0) {
                    i6 |= 100663296;
                } else if ((i2 & 100663296) == 0) {
                    i12 = i11;
                    i6 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                    i13 = i5 & 512;
                    if (i13 == 0) {
                        i6 |= 805306368;
                    } else if ((i2 & 805306368) == 0) {
                        i14 = i13;
                        i6 |= startRestartGroup.changedInstance(function24) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        i15 = i5 & 1024;
                        if (i15 != 0) {
                            i17 = i3 | 6;
                            i16 = i15;
                        } else if ((i3 & 6) == 0) {
                            i16 = i15;
                            i17 = i3 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                        } else {
                            i16 = i15;
                            i17 = i3;
                        }
                        i18 = i5 & 2048;
                        if (i18 != 0) {
                            i17 |= 48;
                            i19 = i18;
                        } else if ((i3 & 48) == 0) {
                            i19 = i18;
                            i17 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
                        } else {
                            i19 = i18;
                        }
                        int i39 = i17;
                        i20 = i5 & 4096;
                        if (i20 != 0) {
                            i21 = i39 | RendererCapabilities.DECODER_SUPPORT_MASK;
                        } else {
                            int i40 = i39;
                            if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                i40 |= startRestartGroup.changed(z2) ? 256 : 128;
                            }
                            i21 = i40;
                        }
                        i22 = i5 & 8192;
                        if (i22 != 0) {
                            i23 = i21 | 3072;
                        } else {
                            i23 = i21;
                            if ((i3 & 3072) == 0) {
                                i23 |= startRestartGroup.changed(inputTransformation) ? 2048 : 1024;
                                if ((i3 & 24576) == 0) {
                                    if ((i5 & 16384) != 0) {
                                    }
                                    i38 = 8192;
                                    i23 |= i38;
                                }
                                i24 = i5 & 32768;
                                if (i24 == 0) {
                                    i23 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i23 |= startRestartGroup.changed(c) ? 131072 : 65536;
                                }
                                i25 = i5 & 65536;
                                if (i25 == 0) {
                                    i23 |= 1572864;
                                } else if ((i3 & 1572864) == 0) {
                                    i23 |= startRestartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                                }
                                i26 = i5 & 131072;
                                if (i26 == 0) {
                                    i23 |= 12582912;
                                } else if ((i3 & 12582912) == 0) {
                                    i23 |= startRestartGroup.changed(keyboardActionHandler) ? 8388608 : 4194304;
                                }
                                i27 = i5 & 262144;
                                if (i27 == 0) {
                                    i23 |= 100663296;
                                } else if ((i3 & 100663296) == 0) {
                                    i23 |= startRestartGroup.changedInstance(function27) ? 67108864 : 33554432;
                                }
                                if ((i3 & 805306368) == 0) {
                                    i23 |= ((i5 & 524288) == 0 && startRestartGroup.changed(shape)) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                                }
                                if ((i4 & 6) != 0) {
                                    i28 = i4 | (((i5 & 1048576) == 0 && startRestartGroup.changed(textFieldColors)) ? 4 : 2);
                                } else {
                                    i28 = i4;
                                }
                                if ((i4 & 48) == 0) {
                                    i28 |= ((i5 & 2097152) == 0 && startRestartGroup.changed(paddingValues)) ? 32 : 16;
                                }
                                int i41 = i28;
                                i29 = i5 & 4194304;
                                if (i29 == 0) {
                                    i30 = i41 | RendererCapabilities.DECODER_SUPPORT_MASK;
                                } else {
                                    int i42 = i41;
                                    if ((i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                        i42 |= startRestartGroup.changed(mutableInteractionSource) ? 256 : 128;
                                    }
                                    i30 = i42;
                                }
                                if (!startRestartGroup.shouldExecute(((i6 & 306783379) != 306783378 && (i23 & 306783379) == 306783378 && (i30 & 147) == 146) ? false : true, i6 & 1)) {
                                    startRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(startRestartGroup, "295@17703L7,311@18641L5,312@18704L8");
                                    if ((i2 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i5 & 8) != 0) {
                                            i6 &= -7169;
                                        }
                                        if ((i5 & 16) != 0) {
                                            i6 &= -57345;
                                        }
                                        if ((i5 & 16384) != 0) {
                                            i23 &= -57345;
                                        }
                                        if ((i5 & 524288) != 0) {
                                            i23 &= -1879048193;
                                        }
                                        Modifier modifier4 = companion;
                                        textFieldLabelPosition3 = attached;
                                        modifier3 = modifier4;
                                        z6 = z;
                                        function217 = function22;
                                        function218 = function23;
                                        function221 = function24;
                                        function220 = function25;
                                        function215 = function26;
                                        z5 = z2;
                                        inputTransformation3 = inputTransformation;
                                        i33 = i;
                                        c3 = c;
                                        keyboardOptions3 = keyboardOptions;
                                        keyboardActionHandler3 = keyboardActionHandler;
                                        function216 = function27;
                                        shape4 = shape;
                                        m2345contentPaddinga9UjIt4$default = paddingValues;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        function219 = obj2;
                                        i34 = i23;
                                        colors = textFieldColors;
                                    } else {
                                        if (i37 != 0) {
                                            companion = Modifier.Companion;
                                        }
                                        boolean z7 = i7 != 0 ? true : z;
                                        if ((i5 & 8) != 0) {
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object consume = startRestartGroup.consume(TextKt.getLocalTextStyle());
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            i6 &= -7169;
                                            textStyle2 = (TextStyle) consume;
                                        }
                                        if ((i5 & 16) != 0) {
                                            i6 &= -57345;
                                            attached = new TextFieldLabelPosition.Attached(false, null, null, 7, null);
                                        }
                                        if (i8 != 0) {
                                            obj = null;
                                        }
                                        if (i9 != 0) {
                                            obj2 = null;
                                        }
                                        Function2<? super Composer, ? super Integer, Unit> function222 = i10 != 0 ? null : function22;
                                        Function2<? super Composer, ? super Integer, Unit> function223 = i12 != 0 ? null : function23;
                                        Function2<? super Composer, ? super Integer, Unit> function224 = i14 != 0 ? null : function24;
                                        Function2<? super Composer, ? super Integer, Unit> function225 = i16 != 0 ? null : function25;
                                        function215 = i19 != 0 ? null : function26;
                                        boolean z8 = i20 != 0 ? false : z2;
                                        InputTransformation inputTransformation4 = i22 != 0 ? null : inputTransformation;
                                        if ((i5 & 16384) != 0) {
                                            i32 = TextObfuscationMode.Companion.m1359getRevealLastTypedvTwcZD0();
                                            i23 &= -57345;
                                        } else {
                                            i32 = i;
                                        }
                                        char c4 = i24 != 0 ? (char) 8226 : c;
                                        KeyboardOptions keyboardOptions4 = i25 != 0 ? SecureTextFieldKeyboardOptions : keyboardOptions;
                                        KeyboardActionHandler keyboardActionHandler4 = i26 != 0 ? null : keyboardActionHandler;
                                        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function226 = i27 != 0 ? null : function27;
                                        if ((i5 & 524288) != 0) {
                                            shape3 = OutlinedTextFieldDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                            i23 &= -1879048193;
                                        } else {
                                            shape3 = shape;
                                        }
                                        boolean z9 = z7;
                                        Modifier modifier5 = companion;
                                        textFieldLabelPosition3 = attached;
                                        modifier3 = modifier5;
                                        i33 = i32;
                                        shape4 = shape3;
                                        c3 = c4;
                                        inputTransformation3 = inputTransformation4;
                                        keyboardOptions3 = keyboardOptions4;
                                        keyboardActionHandler3 = keyboardActionHandler4;
                                        function216 = function226;
                                        i34 = i23;
                                        function217 = function222;
                                        function218 = function223;
                                        function219 = obj2;
                                        function220 = function225;
                                        z5 = z8;
                                        colors = (i5 & 1048576) != 0 ? OutlinedTextFieldDefaults.INSTANCE.colors(startRestartGroup, 6) : textFieldColors;
                                        m2345contentPaddinga9UjIt4$default = (2097152 & i5) != 0 ? OutlinedTextFieldDefaults.m2345contentPaddinga9UjIt4$default(OutlinedTextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null) : paddingValues;
                                        function221 = function224;
                                        if (i29 != 0) {
                                            mutableInteractionSource3 = null;
                                            z6 = z9;
                                        } else {
                                            z6 = z9;
                                            mutableInteractionSource3 = mutableInteractionSource;
                                        }
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-273370384, i6, i34, "androidx.compose.material3.OutlinedSecureTextField (SecureTextField.kt:315)");
                                    }
                                    if (mutableInteractionSource3 == null) {
                                        startRestartGroup.startReplaceGroup(-717679893);
                                        ComposerKt.sourceInformation(startRestartGroup, "317@18936L39");
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -715887625, "CC(remember):SecureTextField.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.Companion.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        startRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = (MutableInteractionSource) rememberedValue;
                                    } else {
                                        startRestartGroup.startReplaceGroup(-715888276);
                                        startRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                    }
                                    startRestartGroup.startReplaceGroup(-715882166);
                                    ComposerKt.sourceInformation(startRestartGroup, "*321@19160L25");
                                    long m7033getColor0d7_KjU = textStyle2.m7033getColor0d7_KjU();
                                    if (m7033getColor0d7_KjU == 16) {
                                        m7033getColor0d7_KjU = colors.m2679textColorXeAY9LY$material3(z6, z5, FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource4, startRestartGroup, 0).getValue().booleanValue());
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(colors.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(1147500080, true, new SecureTextFieldKt$OutlinedSecureTextField$1(modifier3, obj, textFieldLabelPosition3, z5, colors, textFieldState2, z6, mutableInteractionSource4, function219, function217, function218, function221, function220, function215, m2345contentPaddinga9UjIt4$default, inputTransformation3, textStyle2.merge(new TextStyle(m7033getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null)), keyboardOptions3, keyboardActionHandler3, function216, i33, c3, shape4), startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = modifier3;
                                    function32 = obj;
                                    textFieldLabelPosition2 = textFieldLabelPosition3;
                                    z3 = z6;
                                    function28 = function217;
                                    function212 = function218;
                                    function213 = function221;
                                    function214 = function220;
                                    inputTransformation2 = inputTransformation3;
                                    keyboardActionHandler2 = keyboardActionHandler3;
                                    function210 = function216;
                                    i31 = i33;
                                    c2 = c3;
                                    shape2 = shape4;
                                    textFieldColors2 = colors;
                                    z4 = z5;
                                    function29 = function215;
                                    paddingValues2 = m2345contentPaddinga9UjIt4$default;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                    composer2 = startRestartGroup;
                                    textStyle3 = textStyle2;
                                    function211 = function219;
                                    keyboardOptions2 = keyboardOptions3;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    z3 = z;
                                    function28 = function22;
                                    function29 = function26;
                                    inputTransformation2 = inputTransformation;
                                    i31 = i;
                                    c2 = c;
                                    keyboardOptions2 = keyboardOptions;
                                    keyboardActionHandler2 = keyboardActionHandler;
                                    function210 = function27;
                                    shape2 = shape;
                                    textFieldColors2 = textFieldColors;
                                    paddingValues2 = paddingValues;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    composer2 = startRestartGroup;
                                    textStyle3 = textStyle2;
                                    textFieldLabelPosition2 = attached;
                                    function32 = obj;
                                    modifier2 = companion;
                                    function211 = obj2;
                                    function212 = function23;
                                    function213 = function24;
                                    function214 = function25;
                                    z4 = z2;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SecureTextFieldKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj3, Object obj4) {
                                            return SecureTextFieldKt.OutlinedSecureTextField_XvU6IwQ$lambda$5(TextFieldState.this, modifier2, z3, textStyle3, textFieldLabelPosition2, function32, function211, function28, function212, function213, function214, function29, z4, inputTransformation2, i31, c2, keyboardOptions2, keyboardActionHandler2, function210, shape2, textFieldColors2, paddingValues2, mutableInteractionSource2, i2, i3, i4, i5, (Composer) obj3, ((Integer) obj4).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                        }
                        if ((i3 & 24576) == 0) {
                        }
                        i24 = i5 & 32768;
                        if (i24 == 0) {
                        }
                        i25 = i5 & 65536;
                        if (i25 == 0) {
                        }
                        i26 = i5 & 131072;
                        if (i26 == 0) {
                        }
                        i27 = i5 & 262144;
                        if (i27 == 0) {
                        }
                        if ((i3 & 805306368) == 0) {
                        }
                        if ((i4 & 6) != 0) {
                        }
                        if ((i4 & 48) == 0) {
                        }
                        int i412 = i28;
                        i29 = i5 & 4194304;
                        if (i29 == 0) {
                        }
                        if (!startRestartGroup.shouldExecute(((i6 & 306783379) != 306783378 && (i23 & 306783379) == 306783378 && (i30 & 147) == 146) ? false : true, i6 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i14 = i13;
                    i15 = i5 & 1024;
                    if (i15 != 0) {
                    }
                    i18 = i5 & 2048;
                    if (i18 != 0) {
                    }
                    int i392 = i17;
                    i20 = i5 & 4096;
                    if (i20 != 0) {
                    }
                    i22 = i5 & 8192;
                    if (i22 != 0) {
                    }
                    if ((i3 & 24576) == 0) {
                    }
                    i24 = i5 & 32768;
                    if (i24 == 0) {
                    }
                    i25 = i5 & 65536;
                    if (i25 == 0) {
                    }
                    i26 = i5 & 131072;
                    if (i26 == 0) {
                    }
                    i27 = i5 & 262144;
                    if (i27 == 0) {
                    }
                    if ((i3 & 805306368) == 0) {
                    }
                    if ((i4 & 6) != 0) {
                    }
                    if ((i4 & 48) == 0) {
                    }
                    int i4122 = i28;
                    i29 = i5 & 4194304;
                    if (i29 == 0) {
                    }
                    if (!startRestartGroup.shouldExecute(((i6 & 306783379) != 306783378 && (i23 & 306783379) == 306783378 && (i30 & 147) == 146) ? false : true, i6 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i12 = i11;
                i13 = i5 & 512;
                if (i13 == 0) {
                }
                i14 = i13;
                i15 = i5 & 1024;
                if (i15 != 0) {
                }
                i18 = i5 & 2048;
                if (i18 != 0) {
                }
                int i3922 = i17;
                i20 = i5 & 4096;
                if (i20 != 0) {
                }
                i22 = i5 & 8192;
                if (i22 != 0) {
                }
                if ((i3 & 24576) == 0) {
                }
                i24 = i5 & 32768;
                if (i24 == 0) {
                }
                i25 = i5 & 65536;
                if (i25 == 0) {
                }
                i26 = i5 & 131072;
                if (i26 == 0) {
                }
                i27 = i5 & 262144;
                if (i27 == 0) {
                }
                if ((i3 & 805306368) == 0) {
                }
                if ((i4 & 6) != 0) {
                }
                if ((i4 & 48) == 0) {
                }
                int i41222 = i28;
                i29 = i5 & 4194304;
                if (i29 == 0) {
                }
                if (!startRestartGroup.shouldExecute(((i6 & 306783379) != 306783378 && (i23 & 306783379) == 306783378 && (i30 & 147) == 146) ? false : true, i6 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            if ((i2 & 3072) == 0) {
            }
            int i382 = 16384;
            if ((i2 & 24576) == 0) {
            }
            i8 = i5 & 32;
            if (i8 != 0) {
            }
            i9 = i5 & 64;
            if (i9 != 0) {
            }
            i10 = i5 & 128;
            if (i10 != 0) {
            }
            i11 = i5 & 256;
            if (i11 != 0) {
            }
            i12 = i11;
            i13 = i5 & 512;
            if (i13 == 0) {
            }
            i14 = i13;
            i15 = i5 & 1024;
            if (i15 != 0) {
            }
            i18 = i5 & 2048;
            if (i18 != 0) {
            }
            int i39222 = i17;
            i20 = i5 & 4096;
            if (i20 != 0) {
            }
            i22 = i5 & 8192;
            if (i22 != 0) {
            }
            if ((i3 & 24576) == 0) {
            }
            i24 = i5 & 32768;
            if (i24 == 0) {
            }
            i25 = i5 & 65536;
            if (i25 == 0) {
            }
            i26 = i5 & 131072;
            if (i26 == 0) {
            }
            i27 = i5 & 262144;
            if (i27 == 0) {
            }
            if ((i3 & 805306368) == 0) {
            }
            if ((i4 & 6) != 0) {
            }
            if ((i4 & 48) == 0) {
            }
            int i412222 = i28;
            i29 = i5 & 4194304;
            if (i29 == 0) {
            }
            if (!startRestartGroup.shouldExecute(((i6 & 306783379) != 306783378 && (i23 & 306783379) == 306783378 && (i30 & 147) == 146) ? false : true, i6 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        companion = modifier;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        if ((i2 & 3072) == 0) {
        }
        int i3822 = 16384;
        if ((i2 & 24576) == 0) {
        }
        i8 = i5 & 32;
        if (i8 != 0) {
        }
        i9 = i5 & 64;
        if (i9 != 0) {
        }
        i10 = i5 & 128;
        if (i10 != 0) {
        }
        i11 = i5 & 256;
        if (i11 != 0) {
        }
        i12 = i11;
        i13 = i5 & 512;
        if (i13 == 0) {
        }
        i14 = i13;
        i15 = i5 & 1024;
        if (i15 != 0) {
        }
        i18 = i5 & 2048;
        if (i18 != 0) {
        }
        int i392222 = i17;
        i20 = i5 & 4096;
        if (i20 != 0) {
        }
        i22 = i5 & 8192;
        if (i22 != 0) {
        }
        if ((i3 & 24576) == 0) {
        }
        i24 = i5 & 32768;
        if (i24 == 0) {
        }
        i25 = i5 & 65536;
        if (i25 == 0) {
        }
        i26 = i5 & 131072;
        if (i26 == 0) {
        }
        i27 = i5 & 262144;
        if (i27 == 0) {
        }
        if ((i3 & 805306368) == 0) {
        }
        if ((i4 & 6) != 0) {
        }
        if ((i4 & 48) == 0) {
        }
        int i4122222 = i28;
        i29 = i5 & 4194304;
        if (i29 == 0) {
        }
        if (!startRestartGroup.shouldExecute(((i6 & 306783379) != 306783378 && (i23 & 306783379) == 306783378 && (i30 & 147) == 146) ? false : true, i6 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
