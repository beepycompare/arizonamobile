package androidx.compose.material3;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.ui.graphics.Color;
import androidx.media3.common.C;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TextFieldDefaults.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\bU\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bß\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u0010.\u001a\u00020\u0003¢\u0006\u0004\b/\u00100J½\u0003\u0010_\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u0003¢\u0006\u0004\b`\u0010aJ!\u0010b\u001a\u00020\u000e*\u0004\u0018\u00010\u000e2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u000e0dH\u0000¢\u0006\u0002\beJ'\u0010f\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\bk\u0010lJ'\u0010m\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\bn\u0010lJ'\u0010o\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\bp\u0010lJ'\u0010q\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\br\u0010lJ'\u0010s\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\bt\u0010lJ'\u0010u\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\bv\u0010lJ'\u0010w\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\bx\u0010lJ'\u0010y\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\bz\u0010lJ'\u0010{\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\b|\u0010lJ'\u0010}\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\b~\u0010lJ\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010i\u001a\u00020hH\u0001¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\u0015\u0010\u0081\u0001\u001a\u00020h2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\n\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b4\u00102R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b5\u00102R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b6\u00102R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b7\u00102R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b8\u00102R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b9\u00102R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b:\u00102R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b;\u00102R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b<\u00102R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0013\u0010\u000f\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b?\u00102R\u0013\u0010\u0010\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b@\u00102R\u0013\u0010\u0011\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bA\u00102R\u0013\u0010\u0012\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bB\u00102R\u0013\u0010\u0013\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bC\u00102R\u0013\u0010\u0014\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bD\u00102R\u0013\u0010\u0015\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bE\u00102R\u0013\u0010\u0016\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bF\u00102R\u0013\u0010\u0017\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bG\u00102R\u0013\u0010\u0018\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bH\u00102R\u0013\u0010\u0019\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bI\u00102R\u0013\u0010\u001a\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bJ\u00102R\u0013\u0010\u001b\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bK\u00102R\u0013\u0010\u001c\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bL\u00102R\u0013\u0010\u001d\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bM\u00102R\u0013\u0010\u001e\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bN\u00102R\u0013\u0010\u001f\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bO\u00102R\u0013\u0010 \u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bP\u00102R\u0013\u0010!\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bQ\u00102R\u0013\u0010\"\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bR\u00102R\u0013\u0010#\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bS\u00102R\u0013\u0010$\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bT\u00102R\u0013\u0010%\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bU\u00102R\u0013\u0010&\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bV\u00102R\u0013\u0010'\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bW\u00102R\u0013\u0010(\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bX\u00102R\u0013\u0010)\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bY\u00102R\u0013\u0010*\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bZ\u00102R\u0013\u0010+\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b[\u00102R\u0013\u0010,\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b\\\u00102R\u0013\u0010-\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b]\u00102R\u0013\u0010.\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b^\u00102¨\u0006\u0085\u0001"}, d2 = {"Landroidx/compose/material3/TextFieldColors;", "", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "textSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "<init>", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFocusedTextColor-0d7_KjU", "()J", "J", "getUnfocusedTextColor-0d7_KjU", "getDisabledTextColor-0d7_KjU", "getErrorTextColor-0d7_KjU", "getFocusedContainerColor-0d7_KjU", "getUnfocusedContainerColor-0d7_KjU", "getDisabledContainerColor-0d7_KjU", "getErrorContainerColor-0d7_KjU", "getCursorColor-0d7_KjU", "getErrorCursorColor-0d7_KjU", "getTextSelectionColors", "()Landroidx/compose/foundation/text/selection/TextSelectionColors;", "getFocusedIndicatorColor-0d7_KjU", "getUnfocusedIndicatorColor-0d7_KjU", "getDisabledIndicatorColor-0d7_KjU", "getErrorIndicatorColor-0d7_KjU", "getFocusedLeadingIconColor-0d7_KjU", "getUnfocusedLeadingIconColor-0d7_KjU", "getDisabledLeadingIconColor-0d7_KjU", "getErrorLeadingIconColor-0d7_KjU", "getFocusedTrailingIconColor-0d7_KjU", "getUnfocusedTrailingIconColor-0d7_KjU", "getDisabledTrailingIconColor-0d7_KjU", "getErrorTrailingIconColor-0d7_KjU", "getFocusedLabelColor-0d7_KjU", "getUnfocusedLabelColor-0d7_KjU", "getDisabledLabelColor-0d7_KjU", "getErrorLabelColor-0d7_KjU", "getFocusedPlaceholderColor-0d7_KjU", "getUnfocusedPlaceholderColor-0d7_KjU", "getDisabledPlaceholderColor-0d7_KjU", "getErrorPlaceholderColor-0d7_KjU", "getFocusedSupportingTextColor-0d7_KjU", "getUnfocusedSupportingTextColor-0d7_KjU", "getDisabledSupportingTextColor-0d7_KjU", "getErrorSupportingTextColor-0d7_KjU", "getFocusedPrefixColor-0d7_KjU", "getUnfocusedPrefixColor-0d7_KjU", "getDisabledPrefixColor-0d7_KjU", "getErrorPrefixColor-0d7_KjU", "getFocusedSuffixColor-0d7_KjU", "getUnfocusedSuffixColor-0d7_KjU", "getDisabledSuffixColor-0d7_KjU", "getErrorSuffixColor-0d7_KjU", "copy", "copy-ejIjP34", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/TextFieldColors;", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse$material3", "leadingIconColor", "enabled", "", "isError", "focused", "leadingIconColor-XeAY9LY$material3", "(ZZZ)J", "trailingIconColor", "trailingIconColor-XeAY9LY$material3", "indicatorColor", "indicatorColor-XeAY9LY$material3", "containerColor", "containerColor-XeAY9LY$material3", "placeholderColor", "placeholderColor-XeAY9LY$material3", "labelColor", "labelColor-XeAY9LY$material3", "textColor", "textColor-XeAY9LY$material3", "supportingTextColor", "supportingTextColor-XeAY9LY$material3", "prefixColor", "prefixColor-XeAY9LY$material3", "suffixColor", "suffixColor-XeAY9LY$material3", "cursorColor-vNxB06k$material3", "(Z)J", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldColors {
    public static final int $stable = 0;
    private final long cursorColor;
    private final long disabledContainerColor;
    private final long disabledIndicatorColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledPlaceholderColor;
    private final long disabledPrefixColor;
    private final long disabledSuffixColor;
    private final long disabledSupportingTextColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long errorContainerColor;
    private final long errorCursorColor;
    private final long errorIndicatorColor;
    private final long errorLabelColor;
    private final long errorLeadingIconColor;
    private final long errorPlaceholderColor;
    private final long errorPrefixColor;
    private final long errorSuffixColor;
    private final long errorSupportingTextColor;
    private final long errorTextColor;
    private final long errorTrailingIconColor;
    private final long focusedContainerColor;
    private final long focusedIndicatorColor;
    private final long focusedLabelColor;
    private final long focusedLeadingIconColor;
    private final long focusedPlaceholderColor;
    private final long focusedPrefixColor;
    private final long focusedSuffixColor;
    private final long focusedSupportingTextColor;
    private final long focusedTextColor;
    private final long focusedTrailingIconColor;
    private final TextSelectionColors textSelectionColors;
    private final long unfocusedContainerColor;
    private final long unfocusedIndicatorColor;
    private final long unfocusedLabelColor;
    private final long unfocusedLeadingIconColor;
    private final long unfocusedPlaceholderColor;
    private final long unfocusedPrefixColor;
    private final long unfocusedSuffixColor;
    private final long unfocusedSupportingTextColor;
    private final long unfocusedTextColor;
    private final long unfocusedTrailingIconColor;

    public /* synthetic */ TextFieldColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, textSelectionColors, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36, j37, j38, j39, j40, j41, j42);
    }

    private TextFieldColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42) {
        this.focusedTextColor = j;
        this.unfocusedTextColor = j2;
        this.disabledTextColor = j3;
        this.errorTextColor = j4;
        this.focusedContainerColor = j5;
        this.unfocusedContainerColor = j6;
        this.disabledContainerColor = j7;
        this.errorContainerColor = j8;
        this.cursorColor = j9;
        this.errorCursorColor = j10;
        this.textSelectionColors = textSelectionColors;
        this.focusedIndicatorColor = j11;
        this.unfocusedIndicatorColor = j12;
        this.disabledIndicatorColor = j13;
        this.errorIndicatorColor = j14;
        this.focusedLeadingIconColor = j15;
        this.unfocusedLeadingIconColor = j16;
        this.disabledLeadingIconColor = j17;
        this.errorLeadingIconColor = j18;
        this.focusedTrailingIconColor = j19;
        this.unfocusedTrailingIconColor = j20;
        this.disabledTrailingIconColor = j21;
        this.errorTrailingIconColor = j22;
        this.focusedLabelColor = j23;
        this.unfocusedLabelColor = j24;
        this.disabledLabelColor = j25;
        this.errorLabelColor = j26;
        this.focusedPlaceholderColor = j27;
        this.unfocusedPlaceholderColor = j28;
        this.disabledPlaceholderColor = j29;
        this.errorPlaceholderColor = j30;
        this.focusedSupportingTextColor = j31;
        this.unfocusedSupportingTextColor = j32;
        this.disabledSupportingTextColor = j33;
        this.errorSupportingTextColor = j34;
        this.focusedPrefixColor = j35;
        this.unfocusedPrefixColor = j36;
        this.disabledPrefixColor = j37;
        this.errorPrefixColor = j38;
        this.focusedSuffixColor = j39;
        this.unfocusedSuffixColor = j40;
        this.disabledSuffixColor = j41;
        this.errorSuffixColor = j42;
    }

    /* renamed from: getFocusedTextColor-0d7_KjU  reason: not valid java name */
    public final long m2660getFocusedTextColor0d7_KjU() {
        return this.focusedTextColor;
    }

    /* renamed from: getUnfocusedTextColor-0d7_KjU  reason: not valid java name */
    public final long m2670getUnfocusedTextColor0d7_KjU() {
        return this.unfocusedTextColor;
    }

    /* renamed from: getDisabledTextColor-0d7_KjU  reason: not valid java name */
    public final long m2639getDisabledTextColor0d7_KjU() {
        return this.disabledTextColor;
    }

    /* renamed from: getErrorTextColor-0d7_KjU  reason: not valid java name */
    public final long m2650getErrorTextColor0d7_KjU() {
        return this.errorTextColor;
    }

    /* renamed from: getFocusedContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2652getFocusedContainerColor0d7_KjU() {
        return this.focusedContainerColor;
    }

    /* renamed from: getUnfocusedContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2662getUnfocusedContainerColor0d7_KjU() {
        return this.unfocusedContainerColor;
    }

    /* renamed from: getDisabledContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2631getDisabledContainerColor0d7_KjU() {
        return this.disabledContainerColor;
    }

    /* renamed from: getErrorContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2641getErrorContainerColor0d7_KjU() {
        return this.errorContainerColor;
    }

    /* renamed from: getCursorColor-0d7_KjU  reason: not valid java name */
    public final long m2630getCursorColor0d7_KjU() {
        return this.cursorColor;
    }

    /* renamed from: getErrorCursorColor-0d7_KjU  reason: not valid java name */
    public final long m2642getErrorCursorColor0d7_KjU() {
        return this.errorCursorColor;
    }

    public final TextSelectionColors getTextSelectionColors() {
        return this.textSelectionColors;
    }

    /* renamed from: getFocusedIndicatorColor-0d7_KjU  reason: not valid java name */
    public final long m2653getFocusedIndicatorColor0d7_KjU() {
        return this.focusedIndicatorColor;
    }

    /* renamed from: getUnfocusedIndicatorColor-0d7_KjU  reason: not valid java name */
    public final long m2663getUnfocusedIndicatorColor0d7_KjU() {
        return this.unfocusedIndicatorColor;
    }

    /* renamed from: getDisabledIndicatorColor-0d7_KjU  reason: not valid java name */
    public final long m2632getDisabledIndicatorColor0d7_KjU() {
        return this.disabledIndicatorColor;
    }

    /* renamed from: getErrorIndicatorColor-0d7_KjU  reason: not valid java name */
    public final long m2643getErrorIndicatorColor0d7_KjU() {
        return this.errorIndicatorColor;
    }

    /* renamed from: getFocusedLeadingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2655getFocusedLeadingIconColor0d7_KjU() {
        return this.focusedLeadingIconColor;
    }

    /* renamed from: getUnfocusedLeadingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2665getUnfocusedLeadingIconColor0d7_KjU() {
        return this.unfocusedLeadingIconColor;
    }

    /* renamed from: getDisabledLeadingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2634getDisabledLeadingIconColor0d7_KjU() {
        return this.disabledLeadingIconColor;
    }

    /* renamed from: getErrorLeadingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2645getErrorLeadingIconColor0d7_KjU() {
        return this.errorLeadingIconColor;
    }

    /* renamed from: getFocusedTrailingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2661getFocusedTrailingIconColor0d7_KjU() {
        return this.focusedTrailingIconColor;
    }

    /* renamed from: getUnfocusedTrailingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2671getUnfocusedTrailingIconColor0d7_KjU() {
        return this.unfocusedTrailingIconColor;
    }

    /* renamed from: getDisabledTrailingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2640getDisabledTrailingIconColor0d7_KjU() {
        return this.disabledTrailingIconColor;
    }

    /* renamed from: getErrorTrailingIconColor-0d7_KjU  reason: not valid java name */
    public final long m2651getErrorTrailingIconColor0d7_KjU() {
        return this.errorTrailingIconColor;
    }

    /* renamed from: getFocusedLabelColor-0d7_KjU  reason: not valid java name */
    public final long m2654getFocusedLabelColor0d7_KjU() {
        return this.focusedLabelColor;
    }

    /* renamed from: getUnfocusedLabelColor-0d7_KjU  reason: not valid java name */
    public final long m2664getUnfocusedLabelColor0d7_KjU() {
        return this.unfocusedLabelColor;
    }

    /* renamed from: getDisabledLabelColor-0d7_KjU  reason: not valid java name */
    public final long m2633getDisabledLabelColor0d7_KjU() {
        return this.disabledLabelColor;
    }

    /* renamed from: getErrorLabelColor-0d7_KjU  reason: not valid java name */
    public final long m2644getErrorLabelColor0d7_KjU() {
        return this.errorLabelColor;
    }

    /* renamed from: getFocusedPlaceholderColor-0d7_KjU  reason: not valid java name */
    public final long m2656getFocusedPlaceholderColor0d7_KjU() {
        return this.focusedPlaceholderColor;
    }

    /* renamed from: getUnfocusedPlaceholderColor-0d7_KjU  reason: not valid java name */
    public final long m2666getUnfocusedPlaceholderColor0d7_KjU() {
        return this.unfocusedPlaceholderColor;
    }

    /* renamed from: getDisabledPlaceholderColor-0d7_KjU  reason: not valid java name */
    public final long m2635getDisabledPlaceholderColor0d7_KjU() {
        return this.disabledPlaceholderColor;
    }

    /* renamed from: getErrorPlaceholderColor-0d7_KjU  reason: not valid java name */
    public final long m2646getErrorPlaceholderColor0d7_KjU() {
        return this.errorPlaceholderColor;
    }

    /* renamed from: getFocusedSupportingTextColor-0d7_KjU  reason: not valid java name */
    public final long m2659getFocusedSupportingTextColor0d7_KjU() {
        return this.focusedSupportingTextColor;
    }

    /* renamed from: getUnfocusedSupportingTextColor-0d7_KjU  reason: not valid java name */
    public final long m2669getUnfocusedSupportingTextColor0d7_KjU() {
        return this.unfocusedSupportingTextColor;
    }

    /* renamed from: getDisabledSupportingTextColor-0d7_KjU  reason: not valid java name */
    public final long m2638getDisabledSupportingTextColor0d7_KjU() {
        return this.disabledSupportingTextColor;
    }

    /* renamed from: getErrorSupportingTextColor-0d7_KjU  reason: not valid java name */
    public final long m2649getErrorSupportingTextColor0d7_KjU() {
        return this.errorSupportingTextColor;
    }

    /* renamed from: getFocusedPrefixColor-0d7_KjU  reason: not valid java name */
    public final long m2657getFocusedPrefixColor0d7_KjU() {
        return this.focusedPrefixColor;
    }

    /* renamed from: getUnfocusedPrefixColor-0d7_KjU  reason: not valid java name */
    public final long m2667getUnfocusedPrefixColor0d7_KjU() {
        return this.unfocusedPrefixColor;
    }

    /* renamed from: getDisabledPrefixColor-0d7_KjU  reason: not valid java name */
    public final long m2636getDisabledPrefixColor0d7_KjU() {
        return this.disabledPrefixColor;
    }

    /* renamed from: getErrorPrefixColor-0d7_KjU  reason: not valid java name */
    public final long m2647getErrorPrefixColor0d7_KjU() {
        return this.errorPrefixColor;
    }

    /* renamed from: getFocusedSuffixColor-0d7_KjU  reason: not valid java name */
    public final long m2658getFocusedSuffixColor0d7_KjU() {
        return this.focusedSuffixColor;
    }

    /* renamed from: getUnfocusedSuffixColor-0d7_KjU  reason: not valid java name */
    public final long m2668getUnfocusedSuffixColor0d7_KjU() {
        return this.unfocusedSuffixColor;
    }

    /* renamed from: getDisabledSuffixColor-0d7_KjU  reason: not valid java name */
    public final long m2637getDisabledSuffixColor0d7_KjU() {
        return this.disabledSuffixColor;
    }

    /* renamed from: getErrorSuffixColor-0d7_KjU  reason: not valid java name */
    public final long m2648getErrorSuffixColor0d7_KjU() {
        return this.errorSuffixColor;
    }

    /* renamed from: copy-ejIjP34$default  reason: not valid java name */
    public static /* synthetic */ TextFieldColors m2626copyejIjP34$default(TextFieldColors textFieldColors, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, int i, int i2, Object obj) {
        long j43;
        long j44;
        long j45 = (i & 1) != 0 ? textFieldColors.focusedTextColor : j;
        long j46 = (i & 2) != 0 ? textFieldColors.unfocusedTextColor : j2;
        long j47 = (i & 4) != 0 ? textFieldColors.disabledTextColor : j3;
        long j48 = (i & 8) != 0 ? textFieldColors.errorTextColor : j4;
        long j49 = (i & 16) != 0 ? textFieldColors.focusedContainerColor : j5;
        long j50 = (i & 32) != 0 ? textFieldColors.unfocusedContainerColor : j6;
        if ((i & 64) != 0) {
            j43 = j45;
            j44 = textFieldColors.disabledContainerColor;
        } else {
            j43 = j45;
            j44 = j7;
        }
        return textFieldColors.m2628copyejIjP34(j43, j46, j47, j48, j49, j50, j44, (i & 128) != 0 ? textFieldColors.errorContainerColor : j8, (i & 256) != 0 ? textFieldColors.cursorColor : j9, (i & 512) != 0 ? textFieldColors.errorCursorColor : j10, (i & 1024) != 0 ? textFieldColors.textSelectionColors : textSelectionColors, (i & 2048) != 0 ? textFieldColors.focusedIndicatorColor : j11, (i & 4096) != 0 ? textFieldColors.unfocusedIndicatorColor : j12, (i & 8192) != 0 ? textFieldColors.disabledIndicatorColor : j13, (i & 16384) != 0 ? textFieldColors.errorIndicatorColor : j14, (i & 32768) != 0 ? textFieldColors.focusedLeadingIconColor : j15, (i & 65536) != 0 ? textFieldColors.unfocusedLeadingIconColor : j16, (i & 131072) != 0 ? textFieldColors.disabledLeadingIconColor : j17, (i & 262144) != 0 ? textFieldColors.errorLeadingIconColor : j18, (i & 524288) != 0 ? textFieldColors.focusedTrailingIconColor : j19, (i & 1048576) != 0 ? textFieldColors.unfocusedTrailingIconColor : j20, (i & 2097152) != 0 ? textFieldColors.disabledTrailingIconColor : j21, (i & 4194304) != 0 ? textFieldColors.errorTrailingIconColor : j22, (i & 8388608) != 0 ? textFieldColors.focusedLabelColor : j23, (i & 16777216) != 0 ? textFieldColors.unfocusedLabelColor : j24, (i & 33554432) != 0 ? textFieldColors.disabledLabelColor : j25, (i & 67108864) != 0 ? textFieldColors.errorLabelColor : j26, (i & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? textFieldColors.focusedPlaceholderColor : j27, (i & 268435456) != 0 ? textFieldColors.unfocusedPlaceholderColor : j28, (i & C.BUFFER_FLAG_LAST_SAMPLE) != 0 ? textFieldColors.disabledPlaceholderColor : j29, (i & 1073741824) != 0 ? textFieldColors.errorPlaceholderColor : j30, (i & Integer.MIN_VALUE) != 0 ? textFieldColors.focusedSupportingTextColor : j31, (i2 & 1) != 0 ? textFieldColors.unfocusedSupportingTextColor : j32, (i2 & 2) != 0 ? textFieldColors.disabledSupportingTextColor : j33, (i2 & 4) != 0 ? textFieldColors.errorSupportingTextColor : j34, (i2 & 8) != 0 ? textFieldColors.focusedPrefixColor : j35, (i2 & 16) != 0 ? textFieldColors.unfocusedPrefixColor : j36, (i2 & 32) != 0 ? textFieldColors.disabledPrefixColor : j37, (i2 & 64) != 0 ? textFieldColors.errorPrefixColor : j38, (i2 & 128) != 0 ? textFieldColors.focusedSuffixColor : j39, (i2 & 256) != 0 ? textFieldColors.unfocusedSuffixColor : j40, (i2 & 512) != 0 ? textFieldColors.disabledSuffixColor : j41, (i2 & 1024) != 0 ? textFieldColors.errorSuffixColor : j42);
    }

    /* renamed from: copy-ejIjP34  reason: not valid java name */
    public final TextFieldColors m2628copyejIjP34(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42) {
        return new TextFieldColors(j != 16 ? j : this.focusedTextColor, j2 != 16 ? j2 : this.unfocusedTextColor, j3 != 16 ? j3 : this.disabledTextColor, j4 != 16 ? j4 : this.errorTextColor, j5 != 16 ? j5 : this.focusedContainerColor, j6 != 16 ? j6 : this.unfocusedContainerColor, j7 != 16 ? j7 : this.disabledContainerColor, j8 != 16 ? j8 : this.errorContainerColor, j9 != 16 ? j9 : this.cursorColor, j10 != 16 ? j10 : this.errorCursorColor, takeOrElse$material3(textSelectionColors, new Function0() { // from class: androidx.compose.material3.TextFieldColors$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                TextSelectionColors textSelectionColors2;
                textSelectionColors2 = TextFieldColors.this.textSelectionColors;
                return textSelectionColors2;
            }
        }), j11 != 16 ? j11 : this.focusedIndicatorColor, j12 != 16 ? j12 : this.unfocusedIndicatorColor, j13 != 16 ? j13 : this.disabledIndicatorColor, j14 != 16 ? j14 : this.errorIndicatorColor, j15 != 16 ? j15 : this.focusedLeadingIconColor, j16 != 16 ? j16 : this.unfocusedLeadingIconColor, j17 != 16 ? j17 : this.disabledLeadingIconColor, j18 != 16 ? j18 : this.errorLeadingIconColor, j19 != 16 ? j19 : this.focusedTrailingIconColor, j20 != 16 ? j20 : this.unfocusedTrailingIconColor, j21 != 16 ? j21 : this.disabledTrailingIconColor, j22 != 16 ? j22 : this.errorTrailingIconColor, j23 != 16 ? j23 : this.focusedLabelColor, j24 != 16 ? j24 : this.unfocusedLabelColor, j25 != 16 ? j25 : this.disabledLabelColor, j26 != 16 ? j26 : this.errorLabelColor, j27 != 16 ? j27 : this.focusedPlaceholderColor, j28 != 16 ? j28 : this.unfocusedPlaceholderColor, j29 != 16 ? j29 : this.disabledPlaceholderColor, j30 != 16 ? j30 : this.errorPlaceholderColor, j31 != 16 ? j31 : this.focusedSupportingTextColor, j32 != 16 ? j32 : this.unfocusedSupportingTextColor, j33 != 16 ? j33 : this.disabledSupportingTextColor, j34 != 16 ? j34 : this.errorSupportingTextColor, j35 != 16 ? j35 : this.focusedPrefixColor, j36 != 16 ? j36 : this.unfocusedPrefixColor, j37 != 16 ? j37 : this.disabledPrefixColor, j38 != 16 ? j38 : this.errorPrefixColor, j39 != 16 ? j39 : this.focusedSuffixColor, j40 != 16 ? j40 : this.unfocusedSuffixColor, j41 != 16 ? j41 : this.disabledSuffixColor, j42 != 16 ? j42 : this.errorSuffixColor, null);
    }

    public final TextSelectionColors takeOrElse$material3(TextSelectionColors textSelectionColors, Function0<TextSelectionColors> function0) {
        return textSelectionColors == null ? function0.invoke() : textSelectionColors;
    }

    /* renamed from: leadingIconColor-XeAY9LY$material3  reason: not valid java name */
    public final long m2674leadingIconColorXeAY9LY$material3(boolean z, boolean z2, boolean z3) {
        if (z) {
            if (z2) {
                return this.errorLeadingIconColor;
            }
            if (z3) {
                return this.focusedLeadingIconColor;
            }
            return this.unfocusedLeadingIconColor;
        }
        return this.disabledLeadingIconColor;
    }

    /* renamed from: trailingIconColor-XeAY9LY$material3  reason: not valid java name */
    public final long m2680trailingIconColorXeAY9LY$material3(boolean z, boolean z2, boolean z3) {
        if (z) {
            if (z2) {
                return this.errorTrailingIconColor;
            }
            if (z3) {
                return this.focusedTrailingIconColor;
            }
            return this.unfocusedTrailingIconColor;
        }
        return this.disabledTrailingIconColor;
    }

    /* renamed from: indicatorColor-XeAY9LY$material3  reason: not valid java name */
    public final long m2672indicatorColorXeAY9LY$material3(boolean z, boolean z2, boolean z3) {
        if (z) {
            if (z2) {
                return this.errorIndicatorColor;
            }
            if (z3) {
                return this.focusedIndicatorColor;
            }
            return this.unfocusedIndicatorColor;
        }
        return this.disabledIndicatorColor;
    }

    /* renamed from: containerColor-XeAY9LY$material3  reason: not valid java name */
    public final long m2627containerColorXeAY9LY$material3(boolean z, boolean z2, boolean z3) {
        if (z) {
            if (z2) {
                return this.errorContainerColor;
            }
            if (z3) {
                return this.focusedContainerColor;
            }
            return this.unfocusedContainerColor;
        }
        return this.disabledContainerColor;
    }

    /* renamed from: placeholderColor-XeAY9LY$material3  reason: not valid java name */
    public final long m2675placeholderColorXeAY9LY$material3(boolean z, boolean z2, boolean z3) {
        if (z) {
            if (z2) {
                return this.errorPlaceholderColor;
            }
            if (z3) {
                return this.focusedPlaceholderColor;
            }
            return this.unfocusedPlaceholderColor;
        }
        return this.disabledPlaceholderColor;
    }

    /* renamed from: labelColor-XeAY9LY$material3  reason: not valid java name */
    public final long m2673labelColorXeAY9LY$material3(boolean z, boolean z2, boolean z3) {
        if (z) {
            if (z2) {
                return this.errorLabelColor;
            }
            if (z3) {
                return this.focusedLabelColor;
            }
            return this.unfocusedLabelColor;
        }
        return this.disabledLabelColor;
    }

    /* renamed from: textColor-XeAY9LY$material3  reason: not valid java name */
    public final long m2679textColorXeAY9LY$material3(boolean z, boolean z2, boolean z3) {
        if (z) {
            if (z2) {
                return this.errorTextColor;
            }
            if (z3) {
                return this.focusedTextColor;
            }
            return this.unfocusedTextColor;
        }
        return this.disabledTextColor;
    }

    /* renamed from: supportingTextColor-XeAY9LY$material3  reason: not valid java name */
    public final long m2678supportingTextColorXeAY9LY$material3(boolean z, boolean z2, boolean z3) {
        if (z) {
            if (z2) {
                return this.errorSupportingTextColor;
            }
            if (z3) {
                return this.focusedSupportingTextColor;
            }
            return this.unfocusedSupportingTextColor;
        }
        return this.disabledSupportingTextColor;
    }

    /* renamed from: prefixColor-XeAY9LY$material3  reason: not valid java name */
    public final long m2676prefixColorXeAY9LY$material3(boolean z, boolean z2, boolean z3) {
        if (z) {
            if (z2) {
                return this.errorPrefixColor;
            }
            if (z3) {
                return this.focusedPrefixColor;
            }
            return this.unfocusedPrefixColor;
        }
        return this.disabledPrefixColor;
    }

    /* renamed from: suffixColor-XeAY9LY$material3  reason: not valid java name */
    public final long m2677suffixColorXeAY9LY$material3(boolean z, boolean z2, boolean z3) {
        if (z) {
            if (z2) {
                return this.errorSuffixColor;
            }
            if (z3) {
                return this.focusedSuffixColor;
            }
            return this.unfocusedSuffixColor;
        }
        return this.disabledSuffixColor;
    }

    /* renamed from: cursorColor-vNxB06k$material3  reason: not valid java name */
    public final long m2629cursorColorvNxB06k$material3(boolean z) {
        return z ? this.errorCursorColor : this.cursorColor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TextFieldColors)) {
            return false;
        }
        TextFieldColors textFieldColors = (TextFieldColors) obj;
        return Color.m4773equalsimpl0(this.focusedTextColor, textFieldColors.focusedTextColor) && Color.m4773equalsimpl0(this.unfocusedTextColor, textFieldColors.unfocusedTextColor) && Color.m4773equalsimpl0(this.disabledTextColor, textFieldColors.disabledTextColor) && Color.m4773equalsimpl0(this.errorTextColor, textFieldColors.errorTextColor) && Color.m4773equalsimpl0(this.focusedContainerColor, textFieldColors.focusedContainerColor) && Color.m4773equalsimpl0(this.unfocusedContainerColor, textFieldColors.unfocusedContainerColor) && Color.m4773equalsimpl0(this.disabledContainerColor, textFieldColors.disabledContainerColor) && Color.m4773equalsimpl0(this.errorContainerColor, textFieldColors.errorContainerColor) && Color.m4773equalsimpl0(this.cursorColor, textFieldColors.cursorColor) && Color.m4773equalsimpl0(this.errorCursorColor, textFieldColors.errorCursorColor) && Intrinsics.areEqual(this.textSelectionColors, textFieldColors.textSelectionColors) && Color.m4773equalsimpl0(this.focusedIndicatorColor, textFieldColors.focusedIndicatorColor) && Color.m4773equalsimpl0(this.unfocusedIndicatorColor, textFieldColors.unfocusedIndicatorColor) && Color.m4773equalsimpl0(this.disabledIndicatorColor, textFieldColors.disabledIndicatorColor) && Color.m4773equalsimpl0(this.errorIndicatorColor, textFieldColors.errorIndicatorColor) && Color.m4773equalsimpl0(this.focusedLeadingIconColor, textFieldColors.focusedLeadingIconColor) && Color.m4773equalsimpl0(this.unfocusedLeadingIconColor, textFieldColors.unfocusedLeadingIconColor) && Color.m4773equalsimpl0(this.disabledLeadingIconColor, textFieldColors.disabledLeadingIconColor) && Color.m4773equalsimpl0(this.errorLeadingIconColor, textFieldColors.errorLeadingIconColor) && Color.m4773equalsimpl0(this.focusedTrailingIconColor, textFieldColors.focusedTrailingIconColor) && Color.m4773equalsimpl0(this.unfocusedTrailingIconColor, textFieldColors.unfocusedTrailingIconColor) && Color.m4773equalsimpl0(this.disabledTrailingIconColor, textFieldColors.disabledTrailingIconColor) && Color.m4773equalsimpl0(this.errorTrailingIconColor, textFieldColors.errorTrailingIconColor) && Color.m4773equalsimpl0(this.focusedLabelColor, textFieldColors.focusedLabelColor) && Color.m4773equalsimpl0(this.unfocusedLabelColor, textFieldColors.unfocusedLabelColor) && Color.m4773equalsimpl0(this.disabledLabelColor, textFieldColors.disabledLabelColor) && Color.m4773equalsimpl0(this.errorLabelColor, textFieldColors.errorLabelColor) && Color.m4773equalsimpl0(this.focusedPlaceholderColor, textFieldColors.focusedPlaceholderColor) && Color.m4773equalsimpl0(this.unfocusedPlaceholderColor, textFieldColors.unfocusedPlaceholderColor) && Color.m4773equalsimpl0(this.disabledPlaceholderColor, textFieldColors.disabledPlaceholderColor) && Color.m4773equalsimpl0(this.errorPlaceholderColor, textFieldColors.errorPlaceholderColor) && Color.m4773equalsimpl0(this.focusedSupportingTextColor, textFieldColors.focusedSupportingTextColor) && Color.m4773equalsimpl0(this.unfocusedSupportingTextColor, textFieldColors.unfocusedSupportingTextColor) && Color.m4773equalsimpl0(this.disabledSupportingTextColor, textFieldColors.disabledSupportingTextColor) && Color.m4773equalsimpl0(this.errorSupportingTextColor, textFieldColors.errorSupportingTextColor) && Color.m4773equalsimpl0(this.focusedPrefixColor, textFieldColors.focusedPrefixColor) && Color.m4773equalsimpl0(this.unfocusedPrefixColor, textFieldColors.unfocusedPrefixColor) && Color.m4773equalsimpl0(this.disabledPrefixColor, textFieldColors.disabledPrefixColor) && Color.m4773equalsimpl0(this.errorPrefixColor, textFieldColors.errorPrefixColor) && Color.m4773equalsimpl0(this.focusedSuffixColor, textFieldColors.focusedSuffixColor) && Color.m4773equalsimpl0(this.unfocusedSuffixColor, textFieldColors.unfocusedSuffixColor) && Color.m4773equalsimpl0(this.disabledSuffixColor, textFieldColors.disabledSuffixColor) && Color.m4773equalsimpl0(this.errorSuffixColor, textFieldColors.errorSuffixColor);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((Color.m4779hashCodeimpl(this.focusedTextColor) * 31) + Color.m4779hashCodeimpl(this.unfocusedTextColor)) * 31) + Color.m4779hashCodeimpl(this.disabledTextColor)) * 31) + Color.m4779hashCodeimpl(this.errorTextColor)) * 31) + Color.m4779hashCodeimpl(this.focusedContainerColor)) * 31) + Color.m4779hashCodeimpl(this.unfocusedContainerColor)) * 31) + Color.m4779hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m4779hashCodeimpl(this.errorContainerColor)) * 31) + Color.m4779hashCodeimpl(this.cursorColor)) * 31) + Color.m4779hashCodeimpl(this.errorCursorColor)) * 31) + this.textSelectionColors.hashCode()) * 31) + Color.m4779hashCodeimpl(this.focusedIndicatorColor)) * 31) + Color.m4779hashCodeimpl(this.unfocusedIndicatorColor)) * 31) + Color.m4779hashCodeimpl(this.disabledIndicatorColor)) * 31) + Color.m4779hashCodeimpl(this.errorIndicatorColor)) * 31) + Color.m4779hashCodeimpl(this.focusedLeadingIconColor)) * 31) + Color.m4779hashCodeimpl(this.unfocusedLeadingIconColor)) * 31) + Color.m4779hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m4779hashCodeimpl(this.errorLeadingIconColor)) * 31) + Color.m4779hashCodeimpl(this.focusedTrailingIconColor)) * 31) + Color.m4779hashCodeimpl(this.unfocusedTrailingIconColor)) * 31) + Color.m4779hashCodeimpl(this.disabledTrailingIconColor)) * 31) + Color.m4779hashCodeimpl(this.errorTrailingIconColor)) * 31) + Color.m4779hashCodeimpl(this.focusedLabelColor)) * 31) + Color.m4779hashCodeimpl(this.unfocusedLabelColor)) * 31) + Color.m4779hashCodeimpl(this.disabledLabelColor)) * 31) + Color.m4779hashCodeimpl(this.errorLabelColor)) * 31) + Color.m4779hashCodeimpl(this.focusedPlaceholderColor)) * 31) + Color.m4779hashCodeimpl(this.unfocusedPlaceholderColor)) * 31) + Color.m4779hashCodeimpl(this.disabledPlaceholderColor)) * 31) + Color.m4779hashCodeimpl(this.errorPlaceholderColor)) * 31) + Color.m4779hashCodeimpl(this.focusedSupportingTextColor)) * 31) + Color.m4779hashCodeimpl(this.unfocusedSupportingTextColor)) * 31) + Color.m4779hashCodeimpl(this.disabledSupportingTextColor)) * 31) + Color.m4779hashCodeimpl(this.errorSupportingTextColor)) * 31) + Color.m4779hashCodeimpl(this.focusedPrefixColor)) * 31) + Color.m4779hashCodeimpl(this.unfocusedPrefixColor)) * 31) + Color.m4779hashCodeimpl(this.disabledPrefixColor)) * 31) + Color.m4779hashCodeimpl(this.errorPrefixColor)) * 31) + Color.m4779hashCodeimpl(this.focusedSuffixColor)) * 31) + Color.m4779hashCodeimpl(this.unfocusedSuffixColor)) * 31) + Color.m4779hashCodeimpl(this.disabledSuffixColor)) * 31) + Color.m4779hashCodeimpl(this.errorSuffixColor);
    }
}
