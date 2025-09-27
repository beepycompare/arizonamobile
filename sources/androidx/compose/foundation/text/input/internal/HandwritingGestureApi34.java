package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextHighlightType;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextGranularity;
import androidx.compose.ui.text.TextInclusionStrategy;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.SetSelectionCommand;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
/* compiled from: HandwritingGesture.android.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0002\b\u0010J+\u0010\u0011\u001a\u00020\u0012*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0000¢\u0006\u0002\b\u0016J,\u0010\u0017\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u001c\u0010\u001a\u001a\u00020\r*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u001b\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u001d\u001a\u00020\r*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\nH\u0002J,\u0010\u001e\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u001c\u0010 \u001a\u00020\r*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010!\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010#\u001a\u00020\r*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\nH\u0002J&\u0010$\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020%2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J&\u0010&\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020'2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J&\u0010(\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020)2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J#\u0010*\u001a\u00020\r*\u00020\u00062\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0012H\u0002¢\u0006\u0004\b.\u0010/J\u0014\u00100\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\bH\u0002J#\u00101\u001a\u00020\r*\u00020\u00062\u0006\u00102\u001a\u00020,2\u0006\u00103\u001a\u000204H\u0002¢\u0006\u0004\b5\u00106JA\u0010\u0004\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020\b2\b\u00108\u001a\u0004\u0018\u0001092\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0000¢\u0006\u0002\b\u0010J-\u0010\u0011\u001a\u00020\u0012*\u0002072\u0006\u0010\u0018\u001a\u00020\u00132\b\u00108\u001a\u0004\u0018\u0001092\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0000¢\u0006\u0002\b\u0016J2\u0010\u0017\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010=\u001a\u0004\u0018\u0001092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J\u001e\u0010\u001a\u001a\u00020\r*\u0002072\u0006\u0010\u0018\u001a\u00020\u00192\b\u00108\u001a\u0004\u0018\u000109H\u0002J0\u0010\u001b\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020?2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J\u001e\u0010\u001d\u001a\u00020\r*\u0002072\u0006\u0010\u0018\u001a\u00020\u001c2\b\u00108\u001a\u0004\u0018\u000109H\u0002J2\u0010\u001e\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020\u001f2\b\u0010=\u001a\u0004\u0018\u0001092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J\u001e\u0010 \u001a\u00020\r*\u0002072\u0006\u0010\u0018\u001a\u00020\u001f2\b\u00108\u001a\u0004\u0018\u000109H\u0002J0\u0010!\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020\"2\u0006\u0010>\u001a\u00020?2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J\u001e\u0010#\u001a\u00020\r*\u0002072\u0006\u0010\u0018\u001a\u00020\"2\b\u00108\u001a\u0004\u0018\u000109H\u0002J:\u0010$\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020%2\u0006\u0010>\u001a\u00020?2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J2\u0010&\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020'2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J:\u0010(\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020)2\u0006\u0010>\u001a\u00020?2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J,\u0010@\u001a\u00020\r2\u0006\u0010A\u001a\u00020\u00052\u0006\u0010>\u001a\u00020B2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J5\u0010C\u001a\u00020\r2\u0006\u00102\u001a\u00020,2\b\u0010=\u001a\u0004\u0018\u0001092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002¢\u0006\u0004\bD\u0010EJ;\u0010F\u001a\u00020\r2\u0006\u00102\u001a\u00020,2\u0006\u0010>\u001a\u00020?2\u0006\u0010-\u001a\u00020\u00122\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002¢\u0006\u0004\bG\u0010HJ$\u0010I\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\b2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J\u0013\u0010J\u001a\u00020K*\u00020\u0005H\u0002¢\u0006\u0004\bL\u0010M¨\u0006N"}, d2 = {"Landroidx/compose/foundation/text/input/internal/HandwritingGestureApi34;", "", "<init>", "()V", "performHandwritingGesture", "", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "handwritingGesture", "Landroid/view/inputmethod/HandwritingGesture;", "layoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "updateSelectionState", "Lkotlin/Function0;", "", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "performHandwritingGesture$foundation_release", "previewHandwritingGesture", "", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "previewHandwritingGesture$foundation_release", "performSelectGesture", "gesture", "Landroid/view/inputmethod/SelectGesture;", "previewSelectGesture", "performDeleteGesture", "Landroid/view/inputmethod/DeleteGesture;", "previewDeleteGesture", "performSelectRangeGesture", "Landroid/view/inputmethod/SelectRangeGesture;", "previewSelectRangeGesture", "performDeleteRangeGesture", "Landroid/view/inputmethod/DeleteRangeGesture;", "previewDeleteRangeGesture", "performJoinOrSplitGesture", "Landroid/view/inputmethod/JoinOrSplitGesture;", "performInsertGesture", "Landroid/view/inputmethod/InsertGesture;", "performRemoveSpaceGesture", "Landroid/view/inputmethod/RemoveSpaceGesture;", "performDeletion", "rangeInTransformedText", "Landroidx/compose/ui/text/TextRange;", "adjustRange", "performDeletion-Sb-Bc2M", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;JZ)V", "fallback", "highlightRange", "range", "type", "Landroidx/compose/foundation/text/input/TextHighlightType;", "highlightRange-XJREzCE", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;JI)V", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "textFieldSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "editCommandConsumer", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/EditCommand;", "textSelectionManager", "text", "Landroidx/compose/ui/text/AnnotatedString;", "performInsertionOnLegacyTextField", TypedValues.CycleType.S_WAVE_OFFSET, "", "performSelectionOnLegacyTextField", "performSelectionOnLegacyTextField-8ffj60Q", "(JLandroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function1;)V", "performDeletionOnLegacyTextField", "performDeletionOnLegacyTextField-vJH6DeI", "(JLandroidx/compose/ui/text/AnnotatedString;ZLkotlin/jvm/functions/Function1;)V", "fallbackOnLegacyTextField", "toTextGranularity", "Landroidx/compose/ui/text/TextGranularity;", "toTextGranularity-NUwxegE", "(I)I", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HandwritingGestureApi34 {
    public static final int $stable = 0;
    public static final HandwritingGestureApi34 INSTANCE = new HandwritingGestureApi34();

    private HandwritingGestureApi34() {
    }

    public final int performHandwritingGesture$foundation_release(TransformedTextFieldState transformedTextFieldState, HandwritingGesture handwritingGesture, TextLayoutState textLayoutState, Function0<Unit> function0, ViewConfiguration viewConfiguration) {
        if (handwritingGesture instanceof SelectGesture) {
            return performSelectGesture(transformedTextFieldState, (SelectGesture) handwritingGesture, textLayoutState, function0);
        }
        if (handwritingGesture instanceof DeleteGesture) {
            return performDeleteGesture(transformedTextFieldState, (DeleteGesture) handwritingGesture, textLayoutState);
        }
        if (handwritingGesture instanceof SelectRangeGesture) {
            return performSelectRangeGesture(transformedTextFieldState, (SelectRangeGesture) handwritingGesture, textLayoutState, function0);
        }
        if (handwritingGesture instanceof DeleteRangeGesture) {
            return performDeleteRangeGesture(transformedTextFieldState, (DeleteRangeGesture) handwritingGesture, textLayoutState);
        }
        if (handwritingGesture instanceof JoinOrSplitGesture) {
            return performJoinOrSplitGesture(transformedTextFieldState, (JoinOrSplitGesture) handwritingGesture, textLayoutState, viewConfiguration);
        }
        if (handwritingGesture instanceof InsertGesture) {
            return performInsertGesture(transformedTextFieldState, (InsertGesture) handwritingGesture, textLayoutState, viewConfiguration);
        }
        if (handwritingGesture instanceof RemoveSpaceGesture) {
            return performRemoveSpaceGesture(transformedTextFieldState, (RemoveSpaceGesture) handwritingGesture, textLayoutState, viewConfiguration);
        }
        return 2;
    }

    public final boolean previewHandwritingGesture$foundation_release(final TransformedTextFieldState transformedTextFieldState, PreviewableHandwritingGesture previewableHandwritingGesture, TextLayoutState textLayoutState, CancellationSignal cancellationSignal) {
        if (previewableHandwritingGesture instanceof SelectGesture) {
            previewSelectGesture(transformedTextFieldState, (SelectGesture) previewableHandwritingGesture, textLayoutState);
        } else if (previewableHandwritingGesture instanceof DeleteGesture) {
            previewDeleteGesture(transformedTextFieldState, (DeleteGesture) previewableHandwritingGesture, textLayoutState);
        } else if (previewableHandwritingGesture instanceof SelectRangeGesture) {
            previewSelectRangeGesture(transformedTextFieldState, (SelectRangeGesture) previewableHandwritingGesture, textLayoutState);
        } else if (!(previewableHandwritingGesture instanceof DeleteRangeGesture)) {
            return false;
        } else {
            previewDeleteRangeGesture(transformedTextFieldState, (DeleteRangeGesture) previewableHandwritingGesture, textLayoutState);
        }
        if (cancellationSignal != null) {
            cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$$ExternalSyntheticLambda3
                @Override // android.os.CancellationSignal.OnCancelListener
                public final void onCancel() {
                    HandwritingGestureApi34.previewHandwritingGesture$lambda$1(TransformedTextFieldState.this);
                }
            });
            return true;
        }
        return true;
    }

    private final int performSelectGesture(TransformedTextFieldState transformedTextFieldState, SelectGesture selectGesture, TextLayoutState textLayoutState, Function0<Unit> function0) {
        long m1523getRangeForScreenRectOH9lIzo;
        m1523getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m1523getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m1505toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.m6720getCollapsedimpl(m1523getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallback(transformedTextFieldState, (HandwritingGesture) selectGesture);
        }
        transformedTextFieldState.m1603selectCharsIn5zctL8(m1523getRangeForScreenRectOH9lIzo);
        if (function0 != null) {
            function0.invoke();
            return 1;
        }
        return 1;
    }

    private final void previewSelectGesture(TransformedTextFieldState transformedTextFieldState, SelectGesture selectGesture, TextLayoutState textLayoutState) {
        long m1523getRangeForScreenRectOH9lIzo;
        m1523getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m1523getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m1505toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
        m1501highlightRangeXJREzCE(transformedTextFieldState, m1523getRangeForScreenRectOH9lIzo, TextHighlightType.Companion.m1461getHandwritingSelectPreviewsxJuwY());
    }

    private final int performDeleteGesture(TransformedTextFieldState transformedTextFieldState, DeleteGesture deleteGesture, TextLayoutState textLayoutState) {
        long m1523getRangeForScreenRectOH9lIzo;
        int m1505toTextGranularityNUwxegE = m1505toTextGranularityNUwxegE(deleteGesture.getGranularity());
        m1523getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m1523getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), m1505toTextGranularityNUwxegE, TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.m6720getCollapsedimpl(m1523getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallback(transformedTextFieldState, (HandwritingGesture) deleteGesture);
        }
        m1502performDeletionSbBc2M(transformedTextFieldState, m1523getRangeForScreenRectOH9lIzo, TextGranularity.m6684equalsimpl0(m1505toTextGranularityNUwxegE, TextGranularity.Companion.m6689getWordDRrd7Zo()));
        return 1;
    }

    private final void previewDeleteGesture(TransformedTextFieldState transformedTextFieldState, DeleteGesture deleteGesture, TextLayoutState textLayoutState) {
        long m1523getRangeForScreenRectOH9lIzo;
        m1523getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m1523getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), m1505toTextGranularityNUwxegE(deleteGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
        m1501highlightRangeXJREzCE(transformedTextFieldState, m1523getRangeForScreenRectOH9lIzo, TextHighlightType.Companion.m1460getHandwritingDeletePreviewsxJuwY());
    }

    private final int performSelectRangeGesture(TransformedTextFieldState transformedTextFieldState, SelectRangeGesture selectRangeGesture, TextLayoutState textLayoutState, Function0<Unit> function0) {
        long m1525getRangeForScreenRectsO048IG0;
        m1525getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m1525getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m1505toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.m6720getCollapsedimpl(m1525getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallback(transformedTextFieldState, (HandwritingGesture) selectRangeGesture);
        }
        transformedTextFieldState.m1603selectCharsIn5zctL8(m1525getRangeForScreenRectsO048IG0);
        if (function0 != null) {
            function0.invoke();
            return 1;
        }
        return 1;
    }

    private final void previewSelectRangeGesture(TransformedTextFieldState transformedTextFieldState, SelectRangeGesture selectRangeGesture, TextLayoutState textLayoutState) {
        long m1525getRangeForScreenRectsO048IG0;
        m1525getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m1525getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m1505toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
        m1501highlightRangeXJREzCE(transformedTextFieldState, m1525getRangeForScreenRectsO048IG0, TextHighlightType.Companion.m1461getHandwritingSelectPreviewsxJuwY());
    }

    private final int performDeleteRangeGesture(TransformedTextFieldState transformedTextFieldState, DeleteRangeGesture deleteRangeGesture, TextLayoutState textLayoutState) {
        long m1525getRangeForScreenRectsO048IG0;
        int m1505toTextGranularityNUwxegE = m1505toTextGranularityNUwxegE(deleteRangeGesture.getGranularity());
        m1525getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m1525getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), m1505toTextGranularityNUwxegE, TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.m6720getCollapsedimpl(m1525getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallback(transformedTextFieldState, (HandwritingGesture) deleteRangeGesture);
        }
        m1502performDeletionSbBc2M(transformedTextFieldState, m1525getRangeForScreenRectsO048IG0, TextGranularity.m6684equalsimpl0(m1505toTextGranularityNUwxegE, TextGranularity.Companion.m6689getWordDRrd7Zo()));
        return 1;
    }

    private final void previewDeleteRangeGesture(TransformedTextFieldState transformedTextFieldState, DeleteRangeGesture deleteRangeGesture, TextLayoutState textLayoutState) {
        long m1525getRangeForScreenRectsO048IG0;
        m1525getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m1525getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), m1505toTextGranularityNUwxegE(deleteRangeGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
        m1501highlightRangeXJREzCE(transformedTextFieldState, m1525getRangeForScreenRectsO048IG0, TextHighlightType.Companion.m1460getHandwritingDeletePreviewsxJuwY());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
        if (r12 == true) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int performJoinOrSplitGesture(TransformedTextFieldState transformedTextFieldState, JoinOrSplitGesture joinOrSplitGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        long offset;
        int m1518getOffsetForHandwritingGestured4ec7I;
        long rangeOfWhitespaces;
        boolean isBiDiBoundary;
        if (transformedTextFieldState.getOutputText() != transformedTextFieldState.getUntransformedText()) {
            return 3;
        }
        offset = HandwritingGesture_androidKt.toOffset(joinOrSplitGesture.getJoinOrSplitPoint());
        m1518getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m1518getOffsetForHandwritingGestured4ec7I(textLayoutState, offset, viewConfiguration);
        if (m1518getOffsetForHandwritingGestured4ec7I != -1) {
            TextLayoutResult layoutResult = textLayoutState.getLayoutResult();
            if (layoutResult != null) {
                isBiDiBoundary = HandwritingGesture_androidKt.isBiDiBoundary(layoutResult, m1518getOffsetForHandwritingGestured4ec7I);
            }
            rangeOfWhitespaces = HandwritingGesture_androidKt.rangeOfWhitespaces(transformedTextFieldState.getVisualText(), m1518getOffsetForHandwritingGestured4ec7I);
            if (TextRange.m6720getCollapsedimpl(rangeOfWhitespaces)) {
                TransformedTextFieldState.m1596replaceTextM8tDOmk$default(transformedTextFieldState, " ", rangeOfWhitespaces, null, false, 12, null);
            } else {
                m1502performDeletionSbBc2M(transformedTextFieldState, rangeOfWhitespaces, false);
            }
            return 1;
        }
        return fallback(transformedTextFieldState, (HandwritingGesture) joinOrSplitGesture);
    }

    private final int performInsertGesture(TransformedTextFieldState transformedTextFieldState, InsertGesture insertGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        long offset;
        int m1518getOffsetForHandwritingGestured4ec7I;
        offset = HandwritingGesture_androidKt.toOffset(insertGesture.getInsertionPoint());
        m1518getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m1518getOffsetForHandwritingGestured4ec7I(textLayoutState, offset, viewConfiguration);
        if (m1518getOffsetForHandwritingGestured4ec7I == -1) {
            return fallback(transformedTextFieldState, (HandwritingGesture) insertGesture);
        }
        TransformedTextFieldState.m1596replaceTextM8tDOmk$default(transformedTextFieldState, insertGesture.getTextToInsert(), TextRangeKt.TextRange(m1518getOffsetForHandwritingGestured4ec7I), null, false, 12, null);
        return 1;
    }

    private final int performRemoveSpaceGesture(TransformedTextFieldState transformedTextFieldState, RemoveSpaceGesture removeSpaceGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        long offset;
        long offset2;
        long m1520getRangeForRemoveSpaceGesture5iVPX68;
        TextLayoutResult layoutResult = textLayoutState.getLayoutResult();
        offset = HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getStartPoint());
        offset2 = HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getEndPoint());
        m1520getRangeForRemoveSpaceGesture5iVPX68 = HandwritingGesture_androidKt.m1520getRangeForRemoveSpaceGesture5iVPX68(layoutResult, offset, offset2, textLayoutState.getTextLayoutNodeCoordinates(), viewConfiguration);
        if (TextRange.m6720getCollapsedimpl(m1520getRangeForRemoveSpaceGesture5iVPX68)) {
            return INSTANCE.fallback(transformedTextFieldState, (HandwritingGesture) removeSpaceGesture);
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = -1;
        String replace = new Regex("\\s+").replace(TextRangeKt.m6733substringFDrldGo(transformedTextFieldState.getVisualText(), m1520getRangeForRemoveSpaceGesture5iVPX68), new Function1() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence performRemoveSpaceGesture$lambda$7;
                performRemoveSpaceGesture$lambda$7 = HandwritingGestureApi34.performRemoveSpaceGesture$lambda$7(Ref.IntRef.this, intRef2, (MatchResult) obj);
                return performRemoveSpaceGesture$lambda$7;
            }
        });
        if (intRef.element == -1 || intRef2.element == -1) {
            return fallback(transformedTextFieldState, (HandwritingGesture) removeSpaceGesture);
        }
        long TextRange = TextRangeKt.TextRange(TextRange.m6726getStartimpl(m1520getRangeForRemoveSpaceGesture5iVPX68) + intRef.element, TextRange.m6726getStartimpl(m1520getRangeForRemoveSpaceGesture5iVPX68) + intRef2.element);
        String substring = replace.substring(intRef.element, replace.length() - (TextRange.m6722getLengthimpl(m1520getRangeForRemoveSpaceGesture5iVPX68) - intRef2.element));
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        TransformedTextFieldState.m1596replaceTextM8tDOmk$default(transformedTextFieldState, substring, TextRange, null, false, 12, null);
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence performRemoveSpaceGesture$lambda$7(Ref.IntRef intRef, Ref.IntRef intRef2, MatchResult matchResult) {
        if (intRef.element == -1) {
            intRef.element = matchResult.getRange().getFirst();
        }
        intRef2.element = matchResult.getRange().getLast() + 1;
        return "";
    }

    /* renamed from: performDeletion-Sb-Bc2M  reason: not valid java name */
    private final void m1502performDeletionSbBc2M(TransformedTextFieldState transformedTextFieldState, long j, boolean z) {
        if (z) {
            j = HandwritingGesture_androidKt.m1514adjustHandwritingDeleteGestureRange72CqOWE(j, transformedTextFieldState.getVisualText());
        }
        TransformedTextFieldState.m1596replaceTextM8tDOmk$default(transformedTextFieldState, "", j, null, false, 12, null);
    }

    /* renamed from: highlightRange-XJREzCE  reason: not valid java name */
    private final void m1501highlightRangeXJREzCE(TransformedTextFieldState transformedTextFieldState, long j, int i) {
        if (TextRange.m6720getCollapsedimpl(j)) {
            TextFieldState textFieldState = transformedTextFieldState.textFieldState;
            InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
            TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
            textFieldState.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
            TextFieldBuffer mainBuffer$foundation_release = textFieldState.getMainBuffer$foundation_release();
            mainBuffer$foundation_release.clearHighlight$foundation_release();
            transformedTextFieldState.updateWedgeAffinity(mainBuffer$foundation_release);
            textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
            return;
        }
        transformedTextFieldState.m1597highlightCharsIn7RAjNK8(i, j);
    }

    public final int performHandwritingGesture$foundation_release(LegacyTextFieldState legacyTextFieldState, HandwritingGesture handwritingGesture, TextFieldSelectionManager textFieldSelectionManager, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        TextLayoutResult value;
        TextLayoutInput layoutInput;
        AnnotatedString untransformedText = legacyTextFieldState.getUntransformedText();
        if (untransformedText == null) {
            return 3;
        }
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (Intrinsics.areEqual(untransformedText, (layoutResult == null || (value = layoutResult.getValue()) == null || (layoutInput = value.getLayoutInput()) == null) ? null : layoutInput.getText())) {
            if (handwritingGesture instanceof SelectGesture) {
                return performSelectGesture(legacyTextFieldState, (SelectGesture) handwritingGesture, textFieldSelectionManager, function1);
            }
            if (handwritingGesture instanceof DeleteGesture) {
                return performDeleteGesture(legacyTextFieldState, (DeleteGesture) handwritingGesture, untransformedText, function1);
            }
            if (handwritingGesture instanceof SelectRangeGesture) {
                return performSelectRangeGesture(legacyTextFieldState, (SelectRangeGesture) handwritingGesture, textFieldSelectionManager, function1);
            }
            if (handwritingGesture instanceof DeleteRangeGesture) {
                return performDeleteRangeGesture(legacyTextFieldState, (DeleteRangeGesture) handwritingGesture, untransformedText, function1);
            }
            if (handwritingGesture instanceof JoinOrSplitGesture) {
                return performJoinOrSplitGesture(legacyTextFieldState, (JoinOrSplitGesture) handwritingGesture, untransformedText, viewConfiguration, function1);
            }
            if (handwritingGesture instanceof InsertGesture) {
                return performInsertGesture(legacyTextFieldState, (InsertGesture) handwritingGesture, viewConfiguration, function1);
            }
            if (handwritingGesture instanceof RemoveSpaceGesture) {
                return performRemoveSpaceGesture(legacyTextFieldState, (RemoveSpaceGesture) handwritingGesture, untransformedText, viewConfiguration, function1);
            }
            return 2;
        }
        return 3;
    }

    public final boolean previewHandwritingGesture$foundation_release(LegacyTextFieldState legacyTextFieldState, PreviewableHandwritingGesture previewableHandwritingGesture, final TextFieldSelectionManager textFieldSelectionManager, CancellationSignal cancellationSignal) {
        TextLayoutResult value;
        TextLayoutInput layoutInput;
        AnnotatedString untransformedText = legacyTextFieldState.getUntransformedText();
        if (untransformedText == null) {
            return false;
        }
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (Intrinsics.areEqual(untransformedText, (layoutResult == null || (value = layoutResult.getValue()) == null || (layoutInput = value.getLayoutInput()) == null) ? null : layoutInput.getText())) {
            if (previewableHandwritingGesture instanceof SelectGesture) {
                previewSelectGesture(legacyTextFieldState, (SelectGesture) previewableHandwritingGesture, textFieldSelectionManager);
            } else if (previewableHandwritingGesture instanceof DeleteGesture) {
                previewDeleteGesture(legacyTextFieldState, (DeleteGesture) previewableHandwritingGesture, textFieldSelectionManager);
            } else if (previewableHandwritingGesture instanceof SelectRangeGesture) {
                previewSelectRangeGesture(legacyTextFieldState, (SelectRangeGesture) previewableHandwritingGesture, textFieldSelectionManager);
            } else if (!(previewableHandwritingGesture instanceof DeleteRangeGesture)) {
                return false;
            } else {
                previewDeleteRangeGesture(legacyTextFieldState, (DeleteRangeGesture) previewableHandwritingGesture, textFieldSelectionManager);
            }
            if (cancellationSignal != null) {
                cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$$ExternalSyntheticLambda0
                    @Override // android.os.CancellationSignal.OnCancelListener
                    public final void onCancel() {
                        HandwritingGestureApi34.previewHandwritingGesture$lambda$10(TextFieldSelectionManager.this);
                    }
                });
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void previewHandwritingGesture$lambda$10(TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.clearPreviewHighlight$foundation_release();
        }
    }

    private final int performSelectGesture(LegacyTextFieldState legacyTextFieldState, SelectGesture selectGesture, TextFieldSelectionManager textFieldSelectionManager, Function1<? super EditCommand, Unit> function1) {
        long m1522getRangeForScreenRectOH9lIzo;
        m1522getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m1522getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m1505toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.m6720getCollapsedimpl(m1522getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallbackOnLegacyTextField((HandwritingGesture) selectGesture, function1);
        }
        m1504performSelectionOnLegacyTextField8ffj60Q(m1522getRangeForScreenRectOH9lIzo, textFieldSelectionManager, function1);
        return 1;
    }

    private final void previewSelectGesture(LegacyTextFieldState legacyTextFieldState, SelectGesture selectGesture, TextFieldSelectionManager textFieldSelectionManager) {
        long m1522getRangeForScreenRectOH9lIzo;
        if (textFieldSelectionManager != null) {
            m1522getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m1522getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m1505toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
            textFieldSelectionManager.m1838setSelectionPreviewHighlight5zctL8$foundation_release(m1522getRangeForScreenRectOH9lIzo);
        }
    }

    private final int performDeleteGesture(LegacyTextFieldState legacyTextFieldState, DeleteGesture deleteGesture, AnnotatedString annotatedString, Function1<? super EditCommand, Unit> function1) {
        long m1522getRangeForScreenRectOH9lIzo;
        int m1505toTextGranularityNUwxegE = m1505toTextGranularityNUwxegE(deleteGesture.getGranularity());
        m1522getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m1522getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), m1505toTextGranularityNUwxegE, TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.m6720getCollapsedimpl(m1522getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallbackOnLegacyTextField((HandwritingGesture) deleteGesture, function1);
        }
        m1503performDeletionOnLegacyTextFieldvJH6DeI(m1522getRangeForScreenRectOH9lIzo, annotatedString, TextGranularity.m6684equalsimpl0(m1505toTextGranularityNUwxegE, TextGranularity.Companion.m6689getWordDRrd7Zo()), function1);
        return 1;
    }

    private final void previewDeleteGesture(LegacyTextFieldState legacyTextFieldState, DeleteGesture deleteGesture, TextFieldSelectionManager textFieldSelectionManager) {
        long m1522getRangeForScreenRectOH9lIzo;
        if (textFieldSelectionManager != null) {
            m1522getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m1522getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), m1505toTextGranularityNUwxegE(deleteGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
            textFieldSelectionManager.m1836setDeletionPreviewHighlight5zctL8$foundation_release(m1522getRangeForScreenRectOH9lIzo);
        }
    }

    private final int performSelectRangeGesture(LegacyTextFieldState legacyTextFieldState, SelectRangeGesture selectRangeGesture, TextFieldSelectionManager textFieldSelectionManager, Function1<? super EditCommand, Unit> function1) {
        long m1524getRangeForScreenRectsO048IG0;
        m1524getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m1524getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m1505toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.m6720getCollapsedimpl(m1524getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallbackOnLegacyTextField((HandwritingGesture) selectRangeGesture, function1);
        }
        m1504performSelectionOnLegacyTextField8ffj60Q(m1524getRangeForScreenRectsO048IG0, textFieldSelectionManager, function1);
        return 1;
    }

    private final void previewSelectRangeGesture(LegacyTextFieldState legacyTextFieldState, SelectRangeGesture selectRangeGesture, TextFieldSelectionManager textFieldSelectionManager) {
        long m1524getRangeForScreenRectsO048IG0;
        if (textFieldSelectionManager != null) {
            m1524getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m1524getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m1505toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
            textFieldSelectionManager.m1838setSelectionPreviewHighlight5zctL8$foundation_release(m1524getRangeForScreenRectsO048IG0);
        }
    }

    private final int performDeleteRangeGesture(LegacyTextFieldState legacyTextFieldState, DeleteRangeGesture deleteRangeGesture, AnnotatedString annotatedString, Function1<? super EditCommand, Unit> function1) {
        long m1524getRangeForScreenRectsO048IG0;
        int m1505toTextGranularityNUwxegE = m1505toTextGranularityNUwxegE(deleteRangeGesture.getGranularity());
        m1524getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m1524getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), m1505toTextGranularityNUwxegE, TextInclusionStrategy.Companion.getContainsCenter());
        if (TextRange.m6720getCollapsedimpl(m1524getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallbackOnLegacyTextField((HandwritingGesture) deleteRangeGesture, function1);
        }
        m1503performDeletionOnLegacyTextFieldvJH6DeI(m1524getRangeForScreenRectsO048IG0, annotatedString, TextGranularity.m6684equalsimpl0(m1505toTextGranularityNUwxegE, TextGranularity.Companion.m6689getWordDRrd7Zo()), function1);
        return 1;
    }

    private final void previewDeleteRangeGesture(LegacyTextFieldState legacyTextFieldState, DeleteRangeGesture deleteRangeGesture, TextFieldSelectionManager textFieldSelectionManager) {
        long m1524getRangeForScreenRectsO048IG0;
        if (textFieldSelectionManager != null) {
            m1524getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m1524getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), m1505toTextGranularityNUwxegE(deleteRangeGesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter());
            textFieldSelectionManager.m1836setDeletionPreviewHighlight5zctL8$foundation_release(m1524getRangeForScreenRectsO048IG0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
        if (r8 == true) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int performJoinOrSplitGesture(LegacyTextFieldState legacyTextFieldState, JoinOrSplitGesture joinOrSplitGesture, AnnotatedString annotatedString, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        long offset;
        int m1517getOffsetForHandwritingGestured4ec7I;
        long rangeOfWhitespaces;
        TextLayoutResult value;
        boolean isBiDiBoundary;
        if (viewConfiguration != null) {
            offset = HandwritingGesture_androidKt.toOffset(joinOrSplitGesture.getJoinOrSplitPoint());
            m1517getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m1517getOffsetForHandwritingGestured4ec7I(legacyTextFieldState, offset, viewConfiguration);
            if (m1517getOffsetForHandwritingGestured4ec7I != -1) {
                TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                if (layoutResult != null && (value = layoutResult.getValue()) != null) {
                    isBiDiBoundary = HandwritingGesture_androidKt.isBiDiBoundary(value, m1517getOffsetForHandwritingGestured4ec7I);
                }
                rangeOfWhitespaces = HandwritingGesture_androidKt.rangeOfWhitespaces(annotatedString, m1517getOffsetForHandwritingGestured4ec7I);
                if (TextRange.m6720getCollapsedimpl(rangeOfWhitespaces)) {
                    performInsertionOnLegacyTextField(TextRange.m6726getStartimpl(rangeOfWhitespaces), " ", function1);
                } else {
                    m1503performDeletionOnLegacyTextFieldvJH6DeI(rangeOfWhitespaces, annotatedString, false, function1);
                }
                return 1;
            }
            return fallbackOnLegacyTextField((HandwritingGesture) joinOrSplitGesture, function1);
        }
        return fallbackOnLegacyTextField((HandwritingGesture) joinOrSplitGesture, function1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
        if (r3 == true) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int performInsertGesture(LegacyTextFieldState legacyTextFieldState, InsertGesture insertGesture, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        long offset;
        int m1517getOffsetForHandwritingGestured4ec7I;
        TextLayoutResult value;
        boolean isBiDiBoundary;
        if (viewConfiguration != null) {
            offset = HandwritingGesture_androidKt.toOffset(insertGesture.getInsertionPoint());
            m1517getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m1517getOffsetForHandwritingGestured4ec7I(legacyTextFieldState, offset, viewConfiguration);
            if (m1517getOffsetForHandwritingGestured4ec7I != -1) {
                TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                if (layoutResult != null && (value = layoutResult.getValue()) != null) {
                    isBiDiBoundary = HandwritingGesture_androidKt.isBiDiBoundary(value, m1517getOffsetForHandwritingGestured4ec7I);
                }
                performInsertionOnLegacyTextField(m1517getOffsetForHandwritingGestured4ec7I, insertGesture.getTextToInsert(), function1);
                return 1;
            }
            return fallbackOnLegacyTextField((HandwritingGesture) insertGesture, function1);
        }
        return fallbackOnLegacyTextField((HandwritingGesture) insertGesture, function1);
    }

    private final int performRemoveSpaceGesture(LegacyTextFieldState legacyTextFieldState, RemoveSpaceGesture removeSpaceGesture, AnnotatedString annotatedString, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        long offset;
        long offset2;
        long m1520getRangeForRemoveSpaceGesture5iVPX68;
        EditCommand compoundEditCommand;
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
        offset = HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getStartPoint());
        offset2 = HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getEndPoint());
        m1520getRangeForRemoveSpaceGesture5iVPX68 = HandwritingGesture_androidKt.m1520getRangeForRemoveSpaceGesture5iVPX68(value, offset, offset2, legacyTextFieldState.getLayoutCoordinates(), viewConfiguration);
        if (TextRange.m6720getCollapsedimpl(m1520getRangeForRemoveSpaceGesture5iVPX68)) {
            return INSTANCE.fallbackOnLegacyTextField((HandwritingGesture) removeSpaceGesture, function1);
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = -1;
        String replace = new Regex("\\s+").replace(TextRangeKt.m6733substringFDrldGo(annotatedString, m1520getRangeForRemoveSpaceGesture5iVPX68), new Function1() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence performRemoveSpaceGesture$lambda$16;
                performRemoveSpaceGesture$lambda$16 = HandwritingGestureApi34.performRemoveSpaceGesture$lambda$16(Ref.IntRef.this, intRef2, (MatchResult) obj);
                return performRemoveSpaceGesture$lambda$16;
            }
        });
        if (intRef.element == -1 || intRef2.element == -1) {
            return fallbackOnLegacyTextField((HandwritingGesture) removeSpaceGesture, function1);
        }
        int m6726getStartimpl = TextRange.m6726getStartimpl(m1520getRangeForRemoveSpaceGesture5iVPX68) + intRef.element;
        int m6726getStartimpl2 = TextRange.m6726getStartimpl(m1520getRangeForRemoveSpaceGesture5iVPX68) + intRef2.element;
        String substring = replace.substring(intRef.element, replace.length() - (TextRange.m6722getLengthimpl(m1520getRangeForRemoveSpaceGesture5iVPX68) - intRef2.element));
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        compoundEditCommand = HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(m6726getStartimpl, m6726getStartimpl2), new CommitTextCommand(substring, 1));
        function1.invoke(compoundEditCommand);
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence performRemoveSpaceGesture$lambda$16(Ref.IntRef intRef, Ref.IntRef intRef2, MatchResult matchResult) {
        if (intRef.element == -1) {
            intRef.element = matchResult.getRange().getFirst();
        }
        intRef2.element = matchResult.getRange().getLast() + 1;
        return "";
    }

    private final void performInsertionOnLegacyTextField(int i, String str, Function1<? super EditCommand, Unit> function1) {
        EditCommand compoundEditCommand;
        compoundEditCommand = HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(i, i), new CommitTextCommand(str, 1));
        function1.invoke(compoundEditCommand);
    }

    /* renamed from: performSelectionOnLegacyTextField-8ffj60Q  reason: not valid java name */
    private final void m1504performSelectionOnLegacyTextField8ffj60Q(long j, TextFieldSelectionManager textFieldSelectionManager, Function1<? super EditCommand, Unit> function1) {
        function1.invoke(new SetSelectionCommand(TextRange.m6726getStartimpl(j), TextRange.m6721getEndimpl(j)));
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.enterSelectionMode$foundation_release(true);
        }
    }

    /* renamed from: performDeletionOnLegacyTextField-vJH6DeI  reason: not valid java name */
    private final void m1503performDeletionOnLegacyTextFieldvJH6DeI(long j, AnnotatedString annotatedString, boolean z, Function1<? super EditCommand, Unit> function1) {
        EditCommand compoundEditCommand;
        if (z) {
            j = HandwritingGesture_androidKt.m1514adjustHandwritingDeleteGestureRange72CqOWE(j, annotatedString);
        }
        compoundEditCommand = HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(TextRange.m6721getEndimpl(j), TextRange.m6721getEndimpl(j)), new DeleteSurroundingTextCommand(TextRange.m6722getLengthimpl(j), 0));
        function1.invoke(compoundEditCommand);
    }

    private final int fallbackOnLegacyTextField(HandwritingGesture handwritingGesture, Function1<? super EditCommand, Unit> function1) {
        String fallbackText = handwritingGesture.getFallbackText();
        if (fallbackText == null) {
            return 3;
        }
        function1.invoke(new CommitTextCommand(fallbackText, 1));
        return 5;
    }

    /* renamed from: toTextGranularity-NUwxegE  reason: not valid java name */
    private final int m1505toTextGranularityNUwxegE(int i) {
        if (i != 1) {
            if (i == 2) {
                return TextGranularity.Companion.m6688getCharacterDRrd7Zo();
            }
            return TextGranularity.Companion.m6688getCharacterDRrd7Zo();
        }
        return TextGranularity.Companion.m6689getWordDRrd7Zo();
    }

    private final int fallback(TransformedTextFieldState transformedTextFieldState, HandwritingGesture handwritingGesture) {
        TextFieldState textFieldState = transformedTextFieldState.textFieldState;
        InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer mainBuffer$foundation_release = textFieldState.getMainBuffer$foundation_release();
        mainBuffer$foundation_release.clearHighlight$foundation_release();
        transformedTextFieldState.updateWedgeAffinity(mainBuffer$foundation_release);
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
        String fallbackText = handwritingGesture.getFallbackText();
        if (fallbackText == null) {
            return 3;
        }
        TransformedTextFieldState.replaceSelectedText$default(transformedTextFieldState, fallbackText, true, null, false, 12, null);
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void previewHandwritingGesture$lambda$1(TransformedTextFieldState transformedTextFieldState) {
        TextFieldState textFieldState = transformedTextFieldState.textFieldState;
        InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer mainBuffer$foundation_release = textFieldState.getMainBuffer$foundation_release();
        mainBuffer$foundation_release.clearHighlight$foundation_release();
        transformedTextFieldState.updateWedgeAffinity(mainBuffer$foundation_release);
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
    }
}
