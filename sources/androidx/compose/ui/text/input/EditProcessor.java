package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* compiled from: EditProcessor.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ \u0010\u0010\u001a\u00020\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0006\u0010\u0018\u001a\u00020\bJ\f\u0010\u0019\u001a\u00020\u0011*\u00020\u000fH\u0002R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/text/input/EditProcessor;", "", "()V", "<set-?>", "Landroidx/compose/ui/text/input/EditingBuffer;", "mBuffer", "getMBuffer$ui_text_release", "()Landroidx/compose/ui/text/input/EditingBuffer;", "Landroidx/compose/ui/text/input/TextFieldValue;", "mBufferState", "getMBufferState$ui_text_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "apply", "editCommands", "", "Landroidx/compose/ui/text/input/EditCommand;", "generateBatchErrorMessage", "", "failedCommand", "reset", "", "value", "textInputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "toTextFieldValue", "toStringForLog", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EditProcessor {
    public static final int $stable = 8;
    private TextFieldValue mBufferState = new TextFieldValue(AnnotatedStringKt.emptyAnnotatedString(), TextRange.Companion.m6152getZerod9O1mEE(), (TextRange) null, (DefaultConstructorMarker) null);
    private EditingBuffer mBuffer = new EditingBuffer(this.mBufferState.getAnnotatedString(), this.mBufferState.m6396getSelectiond9O1mEE(), (DefaultConstructorMarker) null);

    public final TextFieldValue getMBufferState$ui_text_release() {
        return this.mBufferState;
    }

    public final EditingBuffer getMBuffer$ui_text_release() {
        return this.mBuffer;
    }

    public final void reset(TextFieldValue textFieldValue, TextInputSession textInputSession) {
        boolean areEqual = Intrinsics.areEqual(textFieldValue.m6395getCompositionMzsxiRA(), this.mBuffer.m6308getCompositionMzsxiRA$ui_text_release());
        boolean z = true;
        boolean z2 = false;
        if (!Intrinsics.areEqual(this.mBufferState.getAnnotatedString().getText(), textFieldValue.getAnnotatedString().getText())) {
            this.mBuffer = new EditingBuffer(textFieldValue.getAnnotatedString(), textFieldValue.m6396getSelectiond9O1mEE(), (DefaultConstructorMarker) null);
        } else if (TextRange.m6140equalsimpl0(this.mBufferState.m6396getSelectiond9O1mEE(), textFieldValue.m6396getSelectiond9O1mEE())) {
            z = false;
        } else {
            this.mBuffer.setSelection$ui_text_release(TextRange.m6145getMinimpl(textFieldValue.m6396getSelectiond9O1mEE()), TextRange.m6144getMaximpl(textFieldValue.m6396getSelectiond9O1mEE()));
            z2 = true;
            z = false;
        }
        if (textFieldValue.m6395getCompositionMzsxiRA() == null) {
            this.mBuffer.commitComposition$ui_text_release();
        } else if (!TextRange.m6141getCollapsedimpl(textFieldValue.m6395getCompositionMzsxiRA().m6151unboximpl())) {
            this.mBuffer.setComposition$ui_text_release(TextRange.m6145getMinimpl(textFieldValue.m6395getCompositionMzsxiRA().m6151unboximpl()), TextRange.m6144getMaximpl(textFieldValue.m6395getCompositionMzsxiRA().m6151unboximpl()));
        }
        if (z || (!z2 && !areEqual)) {
            this.mBuffer.commitComposition$ui_text_release();
            textFieldValue = TextFieldValue.m6391copy3r_uNRQ$default(textFieldValue, (AnnotatedString) null, 0L, (TextRange) null, 3, (Object) null);
        }
        TextFieldValue textFieldValue2 = this.mBufferState;
        this.mBufferState = textFieldValue;
        if (textInputSession != null) {
            textInputSession.updateState(textFieldValue2, textFieldValue);
        }
    }

    public final TextFieldValue toTextFieldValue() {
        return this.mBufferState;
    }

    private final String generateBatchErrorMessage(List<? extends EditCommand> list, final EditCommand editCommand) {
        StringBuilder sb = new StringBuilder();
        StringBuilder append = sb.append("Error while applying EditCommand batch to buffer (length=" + this.mBuffer.getLength$ui_text_release() + ", composition=" + this.mBuffer.m6308getCompositionMzsxiRA$ui_text_release() + ", selection=" + ((Object) TextRange.m6150toStringimpl(this.mBuffer.m6309getSelectiond9O1mEE$ui_text_release())) + "):");
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append(...)");
        CollectionsKt.joinTo(list, sb, (r14 & 2) != 0 ? ", " : "\n", (r14 & 4) != 0 ? "" : null, (r14 & 8) != 0 ? "" : null, (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : new Function1<EditCommand, CharSequence>() { // from class: androidx.compose.ui.text.input.EditProcessor$generateBatchErrorMessage$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(EditCommand editCommand2) {
                String stringForLog;
                StringBuilder append2 = new StringBuilder().append(EditCommand.this == editCommand2 ? " > " : "   ");
                stringForLog = this.toStringForLog(editCommand2);
                return append2.append(stringForLog).toString();
            }
        });
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toStringForLog(EditCommand editCommand) {
        if (editCommand instanceof CommitTextCommand) {
            CommitTextCommand commitTextCommand = (CommitTextCommand) editCommand;
            return "CommitTextCommand(text.length=" + commitTextCommand.getText().length() + ", newCursorPosition=" + commitTextCommand.getNewCursorPosition() + ')';
        } else if (editCommand instanceof SetComposingTextCommand) {
            SetComposingTextCommand setComposingTextCommand = (SetComposingTextCommand) editCommand;
            return "SetComposingTextCommand(text.length=" + setComposingTextCommand.getText().length() + ", newCursorPosition=" + setComposingTextCommand.getNewCursorPosition() + ')';
        } else {
            if (!(editCommand instanceof SetComposingRegionCommand) && !(editCommand instanceof DeleteSurroundingTextCommand) && !(editCommand instanceof DeleteSurroundingTextInCodePointsCommand) && !(editCommand instanceof SetSelectionCommand) && !(editCommand instanceof FinishComposingTextCommand) && !(editCommand instanceof BackspaceCommand) && !(editCommand instanceof MoveCursorCommand) && !(editCommand instanceof DeleteAllCommand)) {
                StringBuilder sb = new StringBuilder("Unknown EditCommand: ");
                String simpleName = Reflection.getOrCreateKotlinClass(editCommand.getClass()).getSimpleName();
                if (simpleName == null) {
                    simpleName = "{anonymous EditCommand}";
                }
                return sb.append(simpleName).toString();
            }
            return editCommand.toString();
        }
    }

    public final TextFieldValue apply(List<? extends EditCommand> list) {
        EditCommand editCommand;
        EditCommand editCommand2 = null;
        try {
            int size = list.size();
            int i = 0;
            EditCommand editCommand3 = null;
            while (i < size) {
                try {
                    editCommand = list.get(i);
                } catch (Exception e) {
                    e = e;
                    editCommand2 = editCommand3;
                }
                try {
                    editCommand.applyTo(this.mBuffer);
                    i++;
                    editCommand3 = editCommand;
                } catch (Exception e2) {
                    e = e2;
                    editCommand2 = editCommand;
                    throw new RuntimeException(generateBatchErrorMessage(list, editCommand2), e);
                }
            }
            AnnotatedString annotatedString$ui_text_release = this.mBuffer.toAnnotatedString$ui_text_release();
            long m6309getSelectiond9O1mEE$ui_text_release = this.mBuffer.m6309getSelectiond9O1mEE$ui_text_release();
            TextRange m6135boximpl = TextRange.m6135boximpl(m6309getSelectiond9O1mEE$ui_text_release);
            m6135boximpl.m6151unboximpl();
            TextRange textRange = TextRange.m6146getReversedimpl(this.mBufferState.m6396getSelectiond9O1mEE()) ? null : m6135boximpl;
            TextFieldValue textFieldValue = new TextFieldValue(annotatedString$ui_text_release, textRange != null ? textRange.m6151unboximpl() : TextRangeKt.TextRange(TextRange.m6144getMaximpl(m6309getSelectiond9O1mEE$ui_text_release), TextRange.m6145getMinimpl(m6309getSelectiond9O1mEE$ui_text_release)), this.mBuffer.m6308getCompositionMzsxiRA$ui_text_release(), (DefaultConstructorMarker) null);
            this.mBufferState = textFieldValue;
            return textFieldValue;
        } catch (Exception e3) {
            e = e3;
        }
    }
}
