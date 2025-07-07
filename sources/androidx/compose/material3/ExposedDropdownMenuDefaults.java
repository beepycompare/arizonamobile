package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt;
import androidx.compose.material3.tokens.FilledAutocompleteTokens;
import androidx.compose.material3.tokens.OutlinedAutocompleteTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.PopupProperties;
import androidx.media3.common.C;
import androidx.media3.extractor.WavUtil;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: ExposedDropdownMenu.android.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000bJ\u001f\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000eJ\u0082\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\u00122\b\b\u0002\u0010%\u001a\u00020\u00122\b\b\u0002\u0010&\u001a\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u00122\b\b\u0002\u0010(\u001a\u00020\u00122\b\b\u0002\u0010)\u001a\u00020\u00122\b\b\u0002\u0010*\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u0084\u0003\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010-\u001a\u00020\u00122\b\b\u0002\u0010.\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010/\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u00100\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\u00122\b\b\u0002\u0010%\u001a\u00020\u00122\b\b\u0002\u0010&\u001a\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u00122\b\b\u0002\u0010(\u001a\u00020\u00122\b\b\u0002\u00101\u001a\u00020\u00122\b\b\u0002\u00102\u001a\u00020\u00122\b\b\u0002\u0010*\u001a\u00020\u00122\b\b\u0002\u00103\u001a\u00020\u00122\b\b\u0002\u00104\u001a\u00020\u00122\b\b\u0002\u00105\u001a\u00020\u00122\b\b\u0002\u00106\u001a\u00020\u00122\b\b\u0002\u00107\u001a\u00020\u00122\b\b\u0002\u00108\u001a\u00020\u00122\b\b\u0002\u00109\u001a\u00020\u00122\b\b\u0002\u0010:\u001a\u00020\u00122\b\b\u0002\u0010;\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u0098\u0003\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010-\u001a\u00020\u00122\b\b\u0002\u0010.\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010/\u001a\u00020\u00122\b\b\u0002\u0010>\u001a\u00020\u00122\b\b\u0002\u0010?\u001a\u00020\u00122\b\b\u0002\u0010@\u001a\u00020\u00122\b\b\u0002\u00100\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\u00122\b\b\u0002\u0010%\u001a\u00020\u00122\b\b\u0002\u0010&\u001a\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u00122\b\b\u0002\u0010(\u001a\u00020\u00122\b\b\u0002\u00101\u001a\u00020\u00122\b\b\u0002\u00102\u001a\u00020\u00122\b\b\u0002\u0010*\u001a\u00020\u00122\b\b\u0002\u00103\u001a\u00020\u00122\b\b\u0002\u00104\u001a\u00020\u00122\b\b\u0002\u00105\u001a\u00020\u00122\b\b\u0002\u00106\u001a\u00020\u00122\b\b\u0002\u00107\u001a\u00020\u00122\b\b\u0002\u00108\u001a\u00020\u00122\b\b\u0002\u00109\u001a\u00020\u00122\b\b\u0002\u0010:\u001a\u00020\u00122\b\b\u0002\u0010;\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u001a\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ\u0082\u0002\u0010I\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010J\u001a\u00020\u00122\b\b\u0002\u0010K\u001a\u00020\u00122\b\b\u0002\u0010L\u001a\u00020\u00122\b\b\u0002\u0010M\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\u00122\b\b\u0002\u0010%\u001a\u00020\u00122\b\b\u0002\u0010&\u001a\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u00122\b\b\u0002\u0010(\u001a\u00020\u00122\b\b\u0002\u0010)\u001a\u00020\u00122\b\b\u0002\u0010*\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\bN\u0010,J\u0084\u0003\u0010I\u001a\u00020\u00102\b\b\u0002\u0010-\u001a\u00020\u00122\b\b\u0002\u0010.\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010/\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u00100\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010J\u001a\u00020\u00122\b\b\u0002\u0010K\u001a\u00020\u00122\b\b\u0002\u0010L\u001a\u00020\u00122\b\b\u0002\u0010M\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\u00122\b\b\u0002\u0010%\u001a\u00020\u00122\b\b\u0002\u0010&\u001a\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u00122\b\b\u0002\u0010(\u001a\u00020\u00122\b\b\u0002\u00101\u001a\u00020\u00122\b\b\u0002\u00102\u001a\u00020\u00122\b\b\u0002\u0010*\u001a\u00020\u00122\b\b\u0002\u00103\u001a\u00020\u00122\b\b\u0002\u00104\u001a\u00020\u00122\b\b\u0002\u00105\u001a\u00020\u00122\b\b\u0002\u00106\u001a\u00020\u00122\b\b\u0002\u00107\u001a\u00020\u00122\b\b\u0002\u00108\u001a\u00020\u00122\b\b\u0002\u00109\u001a\u00020\u00122\b\b\u0002\u0010:\u001a\u00020\u00122\b\b\u0002\u0010;\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\bO\u0010=J\u0098\u0003\u0010I\u001a\u00020\u00102\b\b\u0002\u0010-\u001a\u00020\u00122\b\b\u0002\u0010.\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010/\u001a\u00020\u00122\b\b\u0002\u0010>\u001a\u00020\u00122\b\b\u0002\u0010?\u001a\u00020\u00122\b\b\u0002\u0010@\u001a\u00020\u00122\b\b\u0002\u00100\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010J\u001a\u00020\u00122\b\b\u0002\u0010K\u001a\u00020\u00122\b\b\u0002\u0010L\u001a\u00020\u00122\b\b\u0002\u0010M\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\u00122\b\b\u0002\u0010%\u001a\u00020\u00122\b\b\u0002\u0010&\u001a\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u00122\b\b\u0002\u0010(\u001a\u00020\u00122\b\b\u0002\u00101\u001a\u00020\u00122\b\b\u0002\u00102\u001a\u00020\u00122\b\b\u0002\u0010*\u001a\u00020\u00122\b\b\u0002\u00103\u001a\u00020\u00122\b\b\u0002\u00104\u001a\u00020\u00122\b\b\u0002\u00105\u001a\u00020\u00122\b\b\u0002\u00106\u001a\u00020\u00122\b\b\u0002\u00107\u001a\u00020\u00122\b\b\u0002\u00108\u001a\u00020\u00122\b\b\u0002\u00109\u001a\u00020\u00122\b\b\u0002\u0010:\u001a\u00020\u00122\b\b\u0002\u0010;\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\bP\u0010BR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Q²\u0006\n\u0010R\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuDefaults;", "", "()V", "ItemContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getItemContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "TrailingIcon", "", "expanded", "", "(ZLandroidx/compose/runtime/Composer;I)V", "modifier", "Landroidx/compose/ui/Modifier;", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "outlinedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "containerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-St-qZLY", "(JJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "unfocusedTextColor", "errorTextColor", "errorContainerColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "errorPlaceholderColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "outlinedTextFieldColors-tN0la-I", "(JJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIII)Landroidx/compose/material3/TextFieldColors;", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "outlinedTextFieldColors-FD9MK7s", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIII)Landroidx/compose/material3/TextFieldColors;", "popupProperties", "Landroidx/compose/ui/window/PopupProperties;", "anchorType", "Landroidx/compose/material3/MenuAnchorType;", "popupProperties-pR6Bxps$material3_release", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/window/PopupProperties;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-St-qZLY", "textFieldColors-tN0la-I", "textFieldColors-FD9MK7s", "material3_release", "a11yServicesEnabled"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExposedDropdownMenuDefaults {
    public static final int $stable = 0;
    public static final ExposedDropdownMenuDefaults INSTANCE = new ExposedDropdownMenuDefaults();
    private static final PaddingValues ItemContentPadding = PaddingKt.m732PaddingValuesYgX7TsA(ExposedDropdownMenu_androidKt.access$getExposedDropdownMenuItemHorizontalPadding$p(), Dp.m6684constructorimpl(0));

    private ExposedDropdownMenuDefaults() {
    }

    public final void TrailingIcon(final boolean z, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1987096744);
        ComposerKt.sourceInformation(startRestartGroup, "C(TrailingIcon)520@22966L83:ExposedDropdownMenu.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i3 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1987096744, i3, -1, "androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.android.kt:519)");
            }
            IconKt.m1954Iconww6aTOc(ArrowDropDownKt.getArrowDropDown(Icons.Filled.INSTANCE), (String) null, RotateKt.rotate(modifier, z ? 180.0f : 0.0f), 0L, startRestartGroup, 48, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuDefaults$TrailingIcon$1
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

                public final void invoke(Composer composer2, int i5) {
                    ExposedDropdownMenuDefaults.this.TrailingIcon(z, modifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* renamed from: textFieldColors-FD9MK7s  reason: not valid java name */
    public final TextFieldColors m1892textFieldColorsFD9MK7s(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, Composer composer, int i, int i2, int i3, int i4, int i5, int i6) {
        TextSelectionColors textSelectionColors2;
        int i7;
        long j39;
        int i8;
        long j40;
        int i9;
        long j41;
        int i10;
        long j42;
        int i11;
        long j43;
        int i12;
        long j44;
        ComposerKt.sourceInformationMarkerStart(composer, 768358577, "C(textFieldColors)P(27:c#ui.graphics.Color,37:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,20:c#ui.graphics.Color,30:c#ui.graphics.Color,1:c#ui.graphics.Color,10:c#ui.graphics.Color,0:c#ui.graphics.Color,11:c#ui.graphics.Color,29,21:c#ui.graphics.Color,31:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,28:c#ui.graphics.Color,38:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,22:c#ui.graphics.Color,32:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,26:c#ui.graphics.Color,36:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)573@27038L5,574@27126L5,576@27233L5,579@27421L5,580@27516L5,581@27613L5,582@27709L5,583@27802L5,584@27883L5,585@27979L5,586@28058L7,588@28178L5,590@28293L5,592@28415L5,596@28640L5,598@28756L5,599@28857L5,601@28977L5,605@29196L5,607@29314L5,609@29429L5,611@29551L5,615@29773L5,616@29865L5,617@29954L5,618@30050L5,619@30140L5,620@30238L5,621@30338L5,623@30457L5,626@30657L5,627@30750L5,628@30845L5,630@30959L5,633@31154L5,634@31247L5,635@31342L5,637@31456L5,640@31651L5,642@31709L2230:ExposedDropdownMenu.android.kt#uh7d8r");
        long value = (i5 & 1) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), composer, 6) : j;
        long value2 = (i5 & 2) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer, 6) : j2;
        long m4077copywmQWz5c$default = (i5 & 4) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer, 6), FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long value3 = (i5 & 8) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), composer, 6) : j4;
        long value4 = (i5 & 16) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer, 6) : j5;
        long value5 = (i5 & 32) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer, 6) : j6;
        long value6 = (i5 & 64) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer, 6) : j7;
        long value7 = (i5 & 128) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer, 6) : j8;
        long value8 = (i5 & 256) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer, 6) : j9;
        long value9 = (i5 & 512) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer, 6) : j10;
        if ((i5 & 1024) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        if ((i5 & 2048) != 0) {
            i7 = 6;
            j39 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), composer, 6);
        } else {
            i7 = 6;
            j39 = j11;
        }
        long value10 = (i5 & 4096) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldActiveIndicatorColor(), composer, i7) : j12;
        long m4077copywmQWz5c$default2 = (i5 & 8192) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorColor(), composer, i7), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j13;
        TextSelectionColors textSelectionColors3 = textSelectionColors2;
        if ((i5 & 16384) != 0) {
            i8 = 6;
            j40 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), composer, 6);
        } else {
            i8 = 6;
            j40 = j14;
        }
        long value11 = (i5 & 32768) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer, i8) : j15;
        long value12 = (i5 & 65536) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer, i8) : j16;
        long m4077copywmQWz5c$default3 = (i5 & 131072) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), composer, i8), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        if ((i5 & 262144) != 0) {
            i9 = 6;
            j41 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer, 6);
        } else {
            i9 = 6;
            j41 = j18;
        }
        long value13 = (i5 & 524288) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer, i9) : j19;
        long value14 = (i5 & 1048576) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer, i9) : j20;
        long m4077copywmQWz5c$default4 = (i5 & 2097152) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), composer, i9), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j21;
        if ((i5 & 4194304) != 0) {
            i10 = 6;
            j42 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer, 6);
        } else {
            i10 = 6;
            j42 = j22;
        }
        long value15 = (i5 & 8388608) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer, i10) : j23;
        long value16 = (i5 & 16777216) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer, i10) : j24;
        long value17 = (i5 & 33554432) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), composer, i10) : j25;
        long value18 = (i5 & 67108864) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer, i10) : j26;
        long value19 = (i5 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i10) : j27;
        long value20 = (i5 & 268435456) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i10) : j28;
        long m4077copywmQWz5c$default5 = (i5 & C.BUFFER_FLAG_LAST_SAMPLE) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i10), FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j29;
        if ((i5 & 1073741824) != 0) {
            i11 = 6;
            j43 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6);
        } else {
            i11 = 6;
            j43 = j30;
        }
        long value21 = (i6 & 1) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i11) : j31;
        long value22 = (i6 & 2) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i11) : j32;
        long m4077copywmQWz5c$default6 = (i6 & 4) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i11), FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j33;
        if ((i6 & 8) != 0) {
            i12 = 6;
            j44 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6);
        } else {
            i12 = 6;
            j44 = j34;
        }
        long value23 = (i6 & 16) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i12) : j35;
        long value24 = (i6 & 32) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i12) : j36;
        long m4077copywmQWz5c$default7 = (i6 & 64) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i12), FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j37;
        long value25 = (i6 & 128) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6) : j38;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(768358577, i, i2, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.android.kt:642)");
        }
        int i13 = i4 << 12;
        int i14 = i4 >> 18;
        int i15 = (i14 & 14) | 3072 | (i14 & 112) | (i14 & 896);
        long j45 = m4077copywmQWz5c$default2;
        long j46 = m4077copywmQWz5c$default;
        long j47 = value5;
        long j48 = value8;
        TextFieldColors m2478colors0hiis_0 = TextFieldDefaults.INSTANCE.m2478colors0hiis_0(value, value2, j46, value3, value4, j47, value6, value7, j48, value9, textSelectionColors3, j39, value10, j45, j40, value11, value12, m4077copywmQWz5c$default3, j41, value13, value14, m4077copywmQWz5c$default4, j42, value15, value16, value17, value18, value19, value20, m4077copywmQWz5c$default5, j43, 0L, 0L, 0L, 0L, value21, value22, m4077copywmQWz5c$default6, j44, value23, value24, m4077copywmQWz5c$default7, value25, composer, i & 2147483646, i2 & 2147483646, i3 & 2147483646, (i4 & 14) | (458752 & i13) | (3670016 & i13) | (29360128 & i13) | (234881024 & i13) | (i13 & 1879048192), i15, 0, 15);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m2478colors0hiis_0;
    }

    /* renamed from: outlinedTextFieldColors-FD9MK7s  reason: not valid java name */
    public final TextFieldColors m1888outlinedTextFieldColorsFD9MK7s(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, Composer composer, int i, int i2, int i3, int i4, int i5, int i6) {
        TextSelectionColors textSelectionColors2;
        int i7;
        long j39;
        int i8;
        long j40;
        int i9;
        long j41;
        int i10;
        long j42;
        int i11;
        long j43;
        int i12;
        long j44;
        int i13;
        long j45;
        ComposerKt.sourceInformationMarkerStart(composer, -1567195085, "C(outlinedTextFieldColors)P(27:c#ui.graphics.Color,37:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,21:c#ui.graphics.Color,31:c#ui.graphics.Color,2:c#ui.graphics.Color,11:c#ui.graphics.Color,0:c#ui.graphics.Color,12:c#ui.graphics.Color,29,20:c#ui.graphics.Color,30:c#ui.graphics.Color,1:c#ui.graphics.Color,10:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,28:c#ui.graphics.Color,38:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,22:c#ui.graphics.Color,32:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,26:c#ui.graphics.Color,36:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)734@37917L5,735@38007L5,737@38116L5,740@38308L5,745@38624L5,746@38722L5,747@38801L7,748@38900L5,749@38994L5,751@39107L5,754@39305L5,756@39423L5,758@39538L5,760@39660L5,764@39883L5,766@40003L5,768@40120L5,770@40244L5,774@40470L5,775@40564L5,776@40655L5,778@40765L5,781@40958L5,782@41058L5,784@41172L5,786@41293L5,789@41497L5,790@41592L5,791@41689L5,793@41805L5,796@42004L5,797@42099L5,798@42196L5,800@42312L5,803@42511L5,805@42577L2206:ExposedDropdownMenu.android.kt#uh7d8r");
        long value = (i5 & 1) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), composer, 6) : j;
        long value2 = (i5 & 2) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer, 6) : j2;
        long m4077copywmQWz5c$default = (i5 & 4) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long value3 = (i5 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), composer, 6) : j4;
        long m4113getTransparent0d7_KjU = (i5 & 16) != 0 ? Color.Companion.m4113getTransparent0d7_KjU() : j5;
        long m4113getTransparent0d7_KjU2 = (i5 & 32) != 0 ? Color.Companion.m4113getTransparent0d7_KjU() : j6;
        long m4113getTransparent0d7_KjU3 = (i5 & 64) != 0 ? Color.Companion.m4113getTransparent0d7_KjU() : j7;
        long m4113getTransparent0d7_KjU4 = (i5 & 128) != 0 ? Color.Companion.m4113getTransparent0d7_KjU() : j8;
        long value4 = (i5 & 256) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer, 6) : j9;
        long value5 = (i5 & 512) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer, 6) : j10;
        if ((i5 & 1024) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        if ((i5 & 2048) != 0) {
            i7 = 6;
            j39 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), composer, 6);
        } else {
            i7 = 6;
            j39 = j11;
        }
        long value6 = (i5 & 4096) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldOutlineColor(), composer, i7) : j12;
        long m4077copywmQWz5c$default2 = (i5 & 8192) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineColor(), composer, i7), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j13;
        TextSelectionColors textSelectionColors3 = textSelectionColors2;
        if ((i5 & 16384) != 0) {
            i8 = 6;
            j40 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), composer, 6);
        } else {
            i8 = 6;
            j40 = j14;
        }
        long value7 = (i5 & 32768) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer, i8) : j15;
        long value8 = (i5 & 65536) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer, i8) : j16;
        long m4077copywmQWz5c$default3 = (i5 & 131072) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), composer, i8), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        if ((i5 & 262144) != 0) {
            i9 = 6;
            j41 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer, 6);
        } else {
            i9 = 6;
            j41 = j18;
        }
        long value9 = (i5 & 524288) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer, i9) : j19;
        long value10 = (i5 & 1048576) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer, i9) : j20;
        long m4077copywmQWz5c$default4 = (i5 & 2097152) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), composer, i9), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j21;
        if ((i5 & 4194304) != 0) {
            i10 = 6;
            j42 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer, 6);
        } else {
            i10 = 6;
            j42 = j22;
        }
        long value11 = (i5 & 8388608) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer, i10) : j23;
        long value12 = (i5 & 16777216) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer, i10) : j24;
        long m4077copywmQWz5c$default5 = (i5 & 33554432) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), composer, i10), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j25;
        if ((i5 & 67108864) != 0) {
            i11 = 6;
            j43 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer, 6);
        } else {
            i11 = 6;
            j43 = j26;
        }
        long value13 = (i5 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i11) : j27;
        long value14 = (i5 & 268435456) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i11) : j28;
        long m4077copywmQWz5c$default6 = (i5 & C.BUFFER_FLAG_LAST_SAMPLE) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i11), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j29;
        if ((i5 & 1073741824) != 0) {
            i12 = 6;
            j44 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6);
        } else {
            i12 = 6;
            j44 = j30;
        }
        long value15 = (i6 & 1) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i12) : j31;
        long value16 = (i6 & 2) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i12) : j32;
        long m4077copywmQWz5c$default7 = (i6 & 4) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i12), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j33;
        if ((i6 & 8) != 0) {
            i13 = 6;
            j45 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6);
        } else {
            i13 = 6;
            j45 = j34;
        }
        long value17 = (i6 & 16) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i13) : j35;
        long value18 = (i6 & 32) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i13) : j36;
        long m4077copywmQWz5c$default8 = (i6 & 64) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i13), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j37;
        long value19 = (i6 & 128) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6) : j38;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1567195085, i, i2, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.android.kt:805)");
        }
        int i14 = i4 << 12;
        int i15 = i4 >> 18;
        int i16 = (i15 & 14) | 3072 | (i15 & 112) | (i15 & 896);
        long j46 = m4077copywmQWz5c$default2;
        long j47 = m4077copywmQWz5c$default;
        long j48 = m4113getTransparent0d7_KjU2;
        long j49 = value4;
        TextFieldColors m2147colors0hiis_0 = OutlinedTextFieldDefaults.INSTANCE.m2147colors0hiis_0(value, value2, j47, value3, m4113getTransparent0d7_KjU, j48, m4113getTransparent0d7_KjU3, m4113getTransparent0d7_KjU4, j49, value5, textSelectionColors3, j39, value6, j46, j40, value7, value8, m4077copywmQWz5c$default3, j41, value9, value10, m4077copywmQWz5c$default4, j42, value11, value12, m4077copywmQWz5c$default5, j43, value13, value14, m4077copywmQWz5c$default6, j44, 0L, 0L, 0L, 0L, value15, value16, m4077copywmQWz5c$default7, j45, value17, value18, m4077copywmQWz5c$default8, value19, composer, i & 2147483646, i2 & 2147483646, i3 & 2147483646, (i4 & 14) | (458752 & i14) | (3670016 & i14) | (29360128 & i14) | (234881024 & i14) | (i14 & 1879048192), i16, 0, 15);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m2147colors0hiis_0;
    }

    public final PaddingValues getItemContentPadding() {
        return ItemContentPadding;
    }

    /* renamed from: popupProperties-pR6Bxps$material3_release  reason: not valid java name */
    public final PopupProperties m1891popupPropertiespR6Bxps$material3_release(String str, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1724259382, "C(popupProperties)P(0:c#material3.MenuAnchorType)861@45439L35:ExposedDropdownMenu.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1724259382, i, -1, "androidx.compose.material3.ExposedDropdownMenuDefaults.popupProperties (ExposedDropdownMenu.android.kt:860)");
        }
        State<Boolean> rememberAccessibilityServiceState = AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState(false, false, composer, 0, 3);
        int i2 = !popupProperties_pR6Bxps$lambda$0(rememberAccessibilityServiceState) ? 393248 : 393216;
        if (MenuAnchorType.m2024equalsimpl0(str, MenuAnchorType.Companion.m2028getPrimaryEditableMg6Rgbw()) || (MenuAnchorType.m2024equalsimpl0(str, MenuAnchorType.Companion.m2030getSecondaryEditableMg6Rgbw()) && !popupProperties_pR6Bxps$lambda$0(rememberAccessibilityServiceState))) {
            i2 |= 8;
        }
        PopupProperties popupProperties = new PopupProperties(i2, false, false, false, false, false, 62, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return popupProperties;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public final /* synthetic */ void TrailingIcon(boolean z, Composer composer, final int i) {
        int i2;
        final boolean z2;
        Composer startRestartGroup = composer.startRestartGroup(-473088613);
        ComposerKt.sourceInformation(startRestartGroup, "C(TrailingIcon)886@46586L32:ExposedDropdownMenu.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(this) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            z2 = z;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-473088613, i2, -1, "androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.android.kt:886)");
            }
            z2 = z;
            TrailingIcon(z2, Modifier.Companion, startRestartGroup, (i2 & 14) | 48 | ((i2 << 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuDefaults$TrailingIcon$2
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

                public final void invoke(Composer composer2, int i3) {
                    ExposedDropdownMenuDefaults.this.TrailingIcon(z2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: textFieldColors-tN0la-I  reason: not valid java name */
    public final /* synthetic */ TextFieldColors m1894textFieldColorstN0laI(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, TextSelectionColors textSelectionColors, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, Composer composer, int i, int i2, int i3, int i4, int i5, int i6) {
        TextSelectionColors textSelectionColors2;
        int i7;
        long j37;
        long j38;
        int i8;
        long j39;
        int i9;
        long j40;
        int i10;
        long j41;
        int i11;
        long j42;
        int i12;
        long j43;
        ComposerKt.sourceInformationMarkerStart(composer, 611690079, "C(textFieldColors)P(26:c#ui.graphics.Color,35:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,0:c#ui.graphics.Color,10:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,28,20:c#ui.graphics.Color,29:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,22:c#ui.graphics.Color,31:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,27:c#ui.graphics.Color,36:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,21:c#ui.graphics.Color,30:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,23:c#ui.graphics.Color,32:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,24:c#ui.graphics.Color,33:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,25:c#ui.graphics.Color,34:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)891@46833L5,892@46921L5,894@47028L5,897@47216L5,898@47304L5,899@47397L5,900@47478L5,901@47574L5,902@47653L7,904@47773L5,906@47888L5,908@48010L5,912@48235L5,914@48351L5,915@48452L5,917@48572L5,921@48791L5,923@48909L5,925@49024L5,927@49146L5,931@49368L5,932@49460L5,933@49549L5,934@49645L5,935@49735L5,936@49833L5,937@49933L5,939@50052L5,942@50252L5,943@50345L5,944@50440L5,946@50554L5,949@50749L5,950@50842L5,951@50937L5,953@51051L5,956@51246L5,958@51286L2215:ExposedDropdownMenu.android.kt#uh7d8r");
        long value = (i5 & 1) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), composer, 6) : j;
        long value2 = (i5 & 2) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer, 6) : j2;
        long m4077copywmQWz5c$default = (i5 & 4) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer, 6), FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long value3 = (i5 & 8) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), composer, 6) : j4;
        long value4 = (i5 & 16) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer, 6) : j5;
        long value5 = (i5 & 32) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer, 6) : j6;
        long value6 = (i5 & 64) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer, 6) : j7;
        long value7 = (i5 & 128) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer, 6) : j8;
        if ((i5 & 256) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        if ((i5 & 512) != 0) {
            i7 = 6;
            j37 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), composer, 6);
        } else {
            i7 = 6;
            j37 = j9;
        }
        long value8 = (i5 & 1024) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldActiveIndicatorColor(), composer, i7) : j10;
        long m4077copywmQWz5c$default2 = (i5 & 2048) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorColor(), composer, i7), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j11;
        TextSelectionColors textSelectionColors3 = textSelectionColors2;
        if ((i5 & 4096) != 0) {
            j38 = m4077copywmQWz5c$default2;
            i8 = 6;
            j39 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), composer, 6);
        } else {
            j38 = m4077copywmQWz5c$default2;
            i8 = 6;
            j39 = j12;
        }
        long value9 = (i5 & 8192) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer, i8) : j13;
        long value10 = (i5 & 16384) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer, i8) : j14;
        long m4077copywmQWz5c$default3 = (32768 & i5) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), composer, i8), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j15;
        if ((65536 & i5) != 0) {
            i9 = 6;
            j40 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer, 6);
        } else {
            i9 = 6;
            j40 = j16;
        }
        long value11 = (131072 & i5) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer, i9) : j17;
        long value12 = (262144 & i5) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer, i9) : j18;
        long m4077copywmQWz5c$default4 = (524288 & i5) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), composer, i9), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j19;
        if ((1048576 & i5) != 0) {
            i10 = 6;
            j41 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer, 6);
        } else {
            i10 = 6;
            j41 = j20;
        }
        long value13 = (2097152 & i5) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer, i10) : j21;
        long value14 = (4194304 & i5) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer, i10) : j22;
        long value15 = (8388608 & i5) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), composer, i10) : j23;
        long value16 = (16777216 & i5) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer, i10) : j24;
        long value17 = (33554432 & i5) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i10) : j25;
        long value18 = (67108864 & i5) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i10) : j26;
        long m4077copywmQWz5c$default5 = (134217728 & i5) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i10), FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j27;
        if ((268435456 & i5) != 0) {
            i11 = 6;
            j42 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6);
        } else {
            i11 = 6;
            j42 = j28;
        }
        long value19 = (536870912 & i5) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i11) : j29;
        long value20 = (i5 & 1073741824) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i11) : j30;
        long m4077copywmQWz5c$default6 = (i6 & 1) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i11), FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j31;
        if ((i6 & 2) != 0) {
            i12 = 6;
            j43 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6);
        } else {
            i12 = 6;
            j43 = j32;
        }
        long value21 = (i6 & 4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i12) : j33;
        long value22 = (i6 & 8) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i12) : j34;
        long m4077copywmQWz5c$default7 = (i6 & 16) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i12), FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j35;
        long value23 = (i6 & 32) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6) : j36;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(611690079, i, i2, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.android.kt:958)");
        }
        int i13 = i << 6;
        int i14 = (65534 & i) | ((i << 3) & 458752) | (i13 & 3670016) | (i13 & 29360128) | (i13 & 234881024) | (i13 & 1879048192);
        int i15 = i2 << 6;
        int i16 = ((i >> 24) & WebSocketProtocol.PAYLOAD_SHORT) | (i15 & 896) | (i15 & 7168) | (i15 & 57344) | (i15 & 458752) | (i15 & 3670016) | (i15 & 29360128) | (i15 & 234881024) | (i15 & 1879048192);
        int i17 = i3 << 6;
        int i18 = ((i2 >> 24) & WebSocketProtocol.PAYLOAD_SHORT) | (i17 & 896) | (i17 & 7168) | (i17 & 57344) | (i17 & 458752) | (i17 & 3670016) | (i17 & 29360128) | (i17 & 234881024) | (i17 & 1879048192);
        int i19 = i4 << 6;
        long j44 = value4;
        TextFieldColors m1892textFieldColorsFD9MK7s = m1892textFieldColorsFD9MK7s(value, value2, m4077copywmQWz5c$default, value3, j44, value4, j44, value5, value6, value7, textSelectionColors3, j37, value8, j38, j39, value9, value10, m4077copywmQWz5c$default3, j40, value11, value12, m4077copywmQWz5c$default4, j41, value13, value14, value15, value16, value17, value18, m4077copywmQWz5c$default5, j42, value19, value20, m4077copywmQWz5c$default6, j43, value21, value22, m4077copywmQWz5c$default7, value23, composer, i14, i16, i18, ((i3 >> 24) & WebSocketProtocol.PAYLOAD_SHORT) | (i19 & 896) | (i19 & 7168) | (i19 & 57344) | (i19 & 458752) | (i19 & 3670016) | (i19 & 29360128) | (i19 & 234881024) | (i19 & 1879048192), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m1892textFieldColorsFD9MK7s;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: outlinedTextFieldColors-tN0la-I  reason: not valid java name */
    public final /* synthetic */ TextFieldColors m1890outlinedTextFieldColorstN0laI(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, TextSelectionColors textSelectionColors, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, Composer composer, int i, int i2, int i3, int i4, int i5, int i6) {
        TextSelectionColors textSelectionColors2;
        int i7;
        long j37;
        long j38;
        int i8;
        long j39;
        int i9;
        long j40;
        int i10;
        long j41;
        int i11;
        long j42;
        int i12;
        long j43;
        int i13;
        long j44;
        ComposerKt.sourceInformationMarkerStart(composer, -388128543, "C(outlinedTextFieldColors)P(26:c#ui.graphics.Color,35:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,0:c#ui.graphics.Color,11:c#ui.graphics.Color,1:c#ui.graphics.Color,12:c#ui.graphics.Color,28,20:c#ui.graphics.Color,29:c#ui.graphics.Color,2:c#ui.graphics.Color,10:c#ui.graphics.Color,22:c#ui.graphics.Color,31:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,27:c#ui.graphics.Color,36:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,21:c#ui.graphics.Color,30:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,23:c#ui.graphics.Color,32:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,24:c#ui.graphics.Color,33:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,25:c#ui.graphics.Color,34:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)1003@53726L5,1004@53816L5,1006@53925L5,1009@54117L5,1012@54307L5,1013@54405L5,1014@54484L7,1015@54583L5,1016@54677L5,1018@54790L5,1021@54988L5,1023@55106L5,1025@55221L5,1027@55343L5,1031@55566L5,1033@55686L5,1035@55803L5,1037@55927L5,1041@56153L5,1042@56247L5,1043@56338L5,1045@56448L5,1048@56641L5,1049@56741L5,1051@56855L5,1053@56976L5,1056@57180L5,1057@57275L5,1058@57372L5,1060@57488L5,1063@57687L5,1064@57782L5,1065@57879L5,1067@57995L5,1070@58194L5,1072@58234L2199:ExposedDropdownMenu.android.kt#uh7d8r");
        long value = (i5 & 1) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), composer, 6) : j;
        long value2 = (i5 & 2) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer, 6) : j2;
        long m4077copywmQWz5c$default = (i5 & 4) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long value3 = (i5 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), composer, 6) : j4;
        long m4113getTransparent0d7_KjU = (i5 & 16) != 0 ? Color.Companion.m4113getTransparent0d7_KjU() : j5;
        long m4113getTransparent0d7_KjU2 = (i5 & 32) != 0 ? Color.Companion.m4113getTransparent0d7_KjU() : j6;
        long value4 = (i5 & 64) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer, 6) : j7;
        long value5 = (i5 & 128) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer, 6) : j8;
        if ((i5 & 256) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        if ((i5 & 512) != 0) {
            i7 = 6;
            j37 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), composer, 6);
        } else {
            i7 = 6;
            j37 = j9;
        }
        long value6 = (i5 & 1024) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldOutlineColor(), composer, i7) : j10;
        long m4077copywmQWz5c$default2 = (i5 & 2048) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineColor(), composer, i7), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j11;
        TextSelectionColors textSelectionColors3 = textSelectionColors2;
        if ((i5 & 4096) != 0) {
            j38 = m4077copywmQWz5c$default2;
            i8 = 6;
            j39 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), composer, 6);
        } else {
            j38 = m4077copywmQWz5c$default2;
            i8 = 6;
            j39 = j12;
        }
        long value7 = (i5 & 8192) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer, i8) : j13;
        long value8 = (i5 & 16384) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer, i8) : j14;
        long m4077copywmQWz5c$default3 = (32768 & i5) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), composer, i8), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j15;
        if ((65536 & i5) != 0) {
            i9 = 6;
            j40 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer, 6);
        } else {
            i9 = 6;
            j40 = j16;
        }
        long value9 = (131072 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer, i9) : j17;
        long value10 = (262144 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer, i9) : j18;
        long m4077copywmQWz5c$default4 = (524288 & i5) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), composer, i9), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j19;
        if ((1048576 & i5) != 0) {
            i10 = 6;
            j41 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer, 6);
        } else {
            i10 = 6;
            j41 = j20;
        }
        long value11 = (2097152 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer, i10) : j21;
        long value12 = (4194304 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer, i10) : j22;
        long m4077copywmQWz5c$default5 = (8388608 & i5) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), composer, i10), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j23;
        if ((16777216 & i5) != 0) {
            i11 = 6;
            j42 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer, 6);
        } else {
            i11 = 6;
            j42 = j24;
        }
        long value13 = (33554432 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i11) : j25;
        long value14 = (67108864 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i11) : j26;
        long m4077copywmQWz5c$default6 = (134217728 & i5) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i11), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j27;
        if ((268435456 & i5) != 0) {
            i12 = 6;
            j43 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6);
        } else {
            i12 = 6;
            j43 = j28;
        }
        long value15 = (536870912 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i12) : j29;
        long value16 = (i5 & 1073741824) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i12) : j30;
        long m4077copywmQWz5c$default7 = (i6 & 1) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i12), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j31;
        if ((i6 & 2) != 0) {
            i13 = 6;
            j44 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6);
        } else {
            i13 = 6;
            j44 = j32;
        }
        long value17 = (i6 & 4) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i13) : j33;
        long value18 = (i6 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i13) : j34;
        long m4077copywmQWz5c$default8 = (i6 & 16) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i13), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j35;
        long value19 = (i6 & 32) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6) : j36;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-388128543, i, i2, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.android.kt:1072)");
        }
        int i14 = i << 6;
        int i15 = (65534 & i) | ((i << 3) & 458752) | (i14 & 3670016) | (i14 & 29360128) | (i14 & 234881024) | (i14 & 1879048192);
        int i16 = i2 << 6;
        int i17 = ((i >> 24) & WebSocketProtocol.PAYLOAD_SHORT) | (i16 & 896) | (i16 & 7168) | (i16 & 57344) | (i16 & 458752) | (i16 & 3670016) | (i16 & 29360128) | (i16 & 234881024) | (i16 & 1879048192);
        int i18 = i3 << 6;
        int i19 = ((i2 >> 24) & WebSocketProtocol.PAYLOAD_SHORT) | (i18 & 896) | (i18 & 7168) | (i18 & 57344) | (i18 & 458752) | (i18 & 3670016) | (i18 & 29360128) | (i18 & 234881024) | (i18 & 1879048192);
        int i20 = i4 << 6;
        long j45 = m4113getTransparent0d7_KjU;
        TextFieldColors m1888outlinedTextFieldColorsFD9MK7s = m1888outlinedTextFieldColorsFD9MK7s(value, value2, m4077copywmQWz5c$default, value3, j45, m4113getTransparent0d7_KjU, j45, m4113getTransparent0d7_KjU2, value4, value5, textSelectionColors3, j37, value6, j38, j39, value7, value8, m4077copywmQWz5c$default3, j40, value9, value10, m4077copywmQWz5c$default4, j41, value11, value12, m4077copywmQWz5c$default5, j42, value13, value14, m4077copywmQWz5c$default6, j43, value15, value16, m4077copywmQWz5c$default7, j44, value17, value18, m4077copywmQWz5c$default8, value19, composer, i15, i17, i19, ((i3 >> 24) & WebSocketProtocol.PAYLOAD_SHORT) | (i20 & 896) | (i20 & 7168) | (i20 & 57344) | (i20 & 458752) | (i20 & 3670016) | (i20 & 29360128) | (i20 & 234881024) | (i20 & 1879048192), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m1888outlinedTextFieldColorsFD9MK7s;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: textFieldColors-St-qZLY  reason: not valid java name */
    public final /* synthetic */ TextFieldColors m1893textFieldColorsStqZLY(long j, long j2, long j3, long j4, long j5, TextSelectionColors textSelectionColors, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, Composer composer, int i, int i2, int i3, int i4) {
        TextSelectionColors textSelectionColors2;
        ComposerKt.sourceInformationMarkerStart(composer, -1343678550, "C(textFieldColors)P(19:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,18,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,15:c#ui.graphics.Color,22:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,16:c#ui.graphics.Color,23:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)1117@60636L5,1119@60743L5,1122@60930L5,1123@61011L5,1124@61107L5,1125@61186L7,1127@61306L5,1129@61421L5,1131@61543L5,1135@61768L5,1137@61884L5,1138@61985L5,1140@62105L5,1144@62324L5,1146@62442L5,1148@62557L5,1150@62679L5,1154@62901L5,1155@62993L5,1156@63082L5,1157@63178L5,1158@63268L5,1159@63359L5,1161@63473L5,1197@65427L5,1198@65521L5,1200@65638L5,1203@65842L5,1204@65934L5,1205@66028L5,1207@66145L5,1210@66349L5,1165@63611L2754:ExposedDropdownMenu.android.kt#uh7d8r");
        long value = (i4 & 1) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer, 6) : j;
        long m4077copywmQWz5c$default = (i4 & 2) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer, 6), FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long value2 = (i4 & 4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer, 6) : j3;
        long value3 = (i4 & 8) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer, 6) : j4;
        long value4 = (i4 & 16) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer, 6) : j5;
        if ((i4 & 32) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value5 = (i4 & 64) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), composer, 6) : j6;
        long value6 = (i4 & 128) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldActiveIndicatorColor(), composer, 6) : j7;
        long m4077copywmQWz5c$default2 = (i4 & 256) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorColor(), composer, 6), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j8;
        long value7 = (i4 & 512) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), composer, 6) : j9;
        long value8 = (i4 & 1024) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer, 6) : j10;
        long value9 = (i4 & 2048) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer, 6) : j11;
        long m4077copywmQWz5c$default3 = (i4 & 4096) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), composer, 6), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j12;
        long value10 = (i4 & 8192) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer, 6) : j13;
        long value11 = (i4 & 16384) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer, 6) : j14;
        long value12 = (32768 & i4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer, 6) : j15;
        long m4077copywmQWz5c$default4 = (65536 & i4) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), composer, 6), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j16;
        long value13 = (131072 & i4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer, 6) : j17;
        long value14 = (262144 & i4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer, 6) : j18;
        long value15 = (524288 & i4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer, 6) : j19;
        long value16 = (1048576 & i4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), composer, 6) : j20;
        long value17 = (2097152 & i4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer, 6) : j21;
        long value18 = (4194304 & i4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6) : j22;
        long m4077copywmQWz5c$default5 = (i4 & 8388608) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer, 6), FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j23;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1343678550, i, i2, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.android.kt:1165)");
        }
        int i5 = i << 3;
        int i6 = (i & 14) | (i5 & 112) | (i5 & 896);
        int i7 = i << 9;
        int i8 = i6 | (i7 & 7168) | ((i << 6) & 57344) | (i7 & 458752) | ((i << 12) & 3670016);
        int i9 = i << 15;
        int i10 = i8 | (i9 & 29360128) | (i9 & 234881024) | (i9 & 1879048192);
        int i11 = i2 << 15;
        int i12 = i3 << 15;
        int i13 = i3 << 18;
        int i14 = ((i3 >> 6) & 14) | (i12 & 1879048192);
        long j24 = value;
        long j25 = value2;
        TextFieldColors m1892textFieldColorsFD9MK7s = m1892textFieldColorsFD9MK7s(j24, value, m4077copywmQWz5c$default, j24, j25, j25, j25, j25, value3, value4, textSelectionColors2, value5, value6, m4077copywmQWz5c$default2, value7, value8, value9, m4077copywmQWz5c$default3, value10, value11, value12, m4077copywmQWz5c$default4, value13, value14, value15, value16, value17, value18, value18, m4077copywmQWz5c$default5, value18, ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), composer, i10, ((i >> 15) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE) | (i11 & 458752) | (i11 & 3670016) | (i11 & 29360128) | (i11 & 234881024) | (i11 & 1879048192), ((i2 >> 15) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE) | (i12 & 458752) | (i12 & 3670016) | (i12 & 29360128) | (i13 & 234881024) | (i13 & 1879048192), i14, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m1892textFieldColorsFD9MK7s;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: outlinedTextFieldColors-St-qZLY  reason: not valid java name */
    public final /* synthetic */ TextFieldColors m1889outlinedTextFieldColorsStqZLY(long j, long j2, long j3, long j4, long j5, TextSelectionColors textSelectionColors, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, Composer composer, int i, int i2, int i3, int i4) {
        TextSelectionColors textSelectionColors2;
        ComposerKt.sourceInformationMarkerStart(composer, -836383316, "C(outlinedTextFieldColors)P(19:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,18,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.graphics.Color,15:c#ui.graphics.Color,22:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,16:c#ui.graphics.Color,23:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)1216@66578L5,1218@66687L5,1222@66922L5,1223@67020L5,1224@67099L7,1225@67198L5,1226@67292L5,1228@67405L5,1231@67603L5,1233@67721L5,1235@67836L5,1237@67958L5,1241@68181L5,1243@68301L5,1245@68418L5,1247@68542L5,1251@68768L5,1252@68862L5,1253@68953L5,1255@69063L5,1258@69256L5,1259@69349L5,1261@69465L5,1297@71405L5,1298@71499L5,1300@71616L5,1303@71820L5,1304@71912L5,1305@72006L5,1307@72123L5,1310@72327L5,1265@69605L2738:ExposedDropdownMenu.android.kt#uh7d8r");
        long value = (i4 & 1) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer, 6) : j;
        long m4077copywmQWz5c$default = (i4 & 2) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long m4113getTransparent0d7_KjU = (i4 & 4) != 0 ? Color.Companion.m4113getTransparent0d7_KjU() : j3;
        long value2 = (i4 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer, 6) : j4;
        long value3 = (i4 & 16) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer, 6) : j5;
        if ((i4 & 32) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value4 = (i4 & 64) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), composer, 6) : j6;
        long value5 = (i4 & 128) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldOutlineColor(), composer, 6) : j7;
        long m4077copywmQWz5c$default2 = (i4 & 256) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j8;
        long value6 = (i4 & 512) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), composer, 6) : j9;
        long value7 = (i4 & 1024) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer, 6) : j10;
        long value8 = (i4 & 2048) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer, 6) : j11;
        long m4077copywmQWz5c$default3 = (i4 & 4096) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j12;
        long value9 = (i4 & 8192) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer, 6) : j13;
        long value10 = (i4 & 16384) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer, 6) : j14;
        long value11 = (32768 & i4) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer, 6) : j15;
        long m4077copywmQWz5c$default4 = (65536 & i4) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j16;
        long value12 = (131072 & i4) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer, 6) : j17;
        long value13 = (262144 & i4) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer, 6) : j18;
        long value14 = (524288 & i4) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer, 6) : j19;
        long m4077copywmQWz5c$default5 = (1048576 & i4) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j20;
        long value15 = (2097152 & i4) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer, 6) : j21;
        long value16 = (4194304 & i4) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6) : j22;
        long m4077copywmQWz5c$default6 = (i4 & 8388608) != 0 ? Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j23;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-836383316, i, i2, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.android.kt:1265)");
        }
        int i5 = i << 3;
        int i6 = (i & 14) | (i5 & 112) | (i5 & 896);
        int i7 = i << 9;
        int i8 = i6 | (i7 & 7168) | ((i << 6) & 57344) | (i7 & 458752) | ((i << 12) & 3670016);
        int i9 = i << 15;
        int i10 = i8 | (i9 & 29360128) | (i9 & 234881024) | (i9 & 1879048192);
        int i11 = i2 << 15;
        int i12 = i3 << 15;
        int i13 = i3 << 18;
        int i14 = ((i3 >> 6) & 14) | (i12 & 1879048192);
        long j24 = value;
        long j25 = m4113getTransparent0d7_KjU;
        TextFieldColors m1888outlinedTextFieldColorsFD9MK7s = m1888outlinedTextFieldColorsFD9MK7s(j24, value, m4077copywmQWz5c$default, j24, j25, j25, j25, j25, value2, value3, textSelectionColors2, value4, value5, m4077copywmQWz5c$default2, value6, value7, value8, m4077copywmQWz5c$default3, value9, value10, value11, m4077copywmQWz5c$default4, value12, value13, value14, m4077copywmQWz5c$default5, value15, value16, value16, m4077copywmQWz5c$default6, value16, ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), Color.m4077copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), composer, i10, ((i >> 15) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE) | (i11 & 458752) | (i11 & 3670016) | (i11 & 29360128) | (i11 & 234881024) | (i11 & 1879048192), ((i2 >> 15) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE) | (i12 & 458752) | (i12 & 3670016) | (i12 & 29360128) | (i13 & 234881024) | (i13 & 1879048192), i14, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m1888outlinedTextFieldColorsFD9MK7s;
    }

    private static final boolean popupProperties_pR6Bxps$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
