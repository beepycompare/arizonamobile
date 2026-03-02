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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0014\u0010\u0011\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0006\u0010\u0015\u001a\u00020\u0005J \u0010\u0016\u001a\u00020\u00172\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0002J\f\u0010\u0019\u001a\u00020\u0017*\u00020\u0014H\u0002R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/text/input/EditProcessor;", "", "<init>", "()V", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "mBufferState", "getMBufferState$ui_text", "()Landroidx/compose/ui/text/input/TextFieldValue;", "Landroidx/compose/ui/text/input/EditingBuffer;", "mBuffer", "getMBuffer$ui_text", "()Landroidx/compose/ui/text/input/EditingBuffer;", "reset", "", "textInputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "apply", "editCommands", "", "Landroidx/compose/ui/text/input/EditCommand;", "toTextFieldValue", "generateBatchErrorMessage", "", "failedCommand", "toStringForLog", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EditProcessor {
    public static final int $stable = 8;
    private TextFieldValue mBufferState = new TextFieldValue(AnnotatedStringKt.emptyAnnotatedString(), TextRange.Companion.m7008getZerod9O1mEE(), (TextRange) null, (DefaultConstructorMarker) null);
    private EditingBuffer mBuffer = new EditingBuffer(this.mBufferState.getAnnotatedString(), this.mBufferState.m7253getSelectiond9O1mEE(), (DefaultConstructorMarker) null);

    public final TextFieldValue getMBufferState$ui_text() {
        return this.mBufferState;
    }

    public final EditingBuffer getMBuffer$ui_text() {
        return this.mBuffer;
    }

    public final void reset(TextFieldValue textFieldValue, TextInputSession textInputSession) {
        boolean areEqual = Intrinsics.areEqual(textFieldValue.m7252getCompositionMzsxiRA(), this.mBuffer.m7165getCompositionMzsxiRA$ui_text());
        boolean z = true;
        boolean z2 = false;
        if (!Intrinsics.areEqual(this.mBufferState.getAnnotatedString().getText(), textFieldValue.getAnnotatedString().getText())) {
            this.mBuffer = new EditingBuffer(textFieldValue.getAnnotatedString(), textFieldValue.m7253getSelectiond9O1mEE(), (DefaultConstructorMarker) null);
        } else if (TextRange.m6996equalsimpl0(this.mBufferState.m7253getSelectiond9O1mEE(), textFieldValue.m7253getSelectiond9O1mEE())) {
            z = false;
        } else {
            this.mBuffer.setSelection$ui_text(TextRange.m7001getMinimpl(textFieldValue.m7253getSelectiond9O1mEE()), TextRange.m7000getMaximpl(textFieldValue.m7253getSelectiond9O1mEE()));
            z2 = true;
            z = false;
        }
        if (textFieldValue.m7252getCompositionMzsxiRA() == null) {
            this.mBuffer.commitComposition$ui_text();
        } else if (!TextRange.m6997getCollapsedimpl(textFieldValue.m7252getCompositionMzsxiRA().m7007unboximpl())) {
            this.mBuffer.setComposition$ui_text(TextRange.m7001getMinimpl(textFieldValue.m7252getCompositionMzsxiRA().m7007unboximpl()), TextRange.m7000getMaximpl(textFieldValue.m7252getCompositionMzsxiRA().m7007unboximpl()));
        }
        if (z || (!z2 && !areEqual)) {
            this.mBuffer.commitComposition$ui_text();
            textFieldValue = TextFieldValue.m7248copy3r_uNRQ$default(textFieldValue, (AnnotatedString) null, 0L, (TextRange) null, 3, (Object) null);
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
        StringBuilder append = sb.append("Error while applying EditCommand batch to buffer (length=" + this.mBuffer.getLength$ui_text() + ", composition=" + this.mBuffer.m7165getCompositionMzsxiRA$ui_text() + ", selection=" + ((Object) TextRange.m7006toStringimpl(this.mBuffer.m7166getSelectiond9O1mEE$ui_text())) + "):");
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append(...)");
        CollectionsKt.joinTo$default(list, sb, "\n", null, null, 0, null, new Function1() { // from class: androidx.compose.ui.text.input.EditProcessor$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence generateBatchErrorMessage$lambda$0$0;
                generateBatchErrorMessage$lambda$0$0 = EditProcessor.generateBatchErrorMessage$lambda$0$0(EditCommand.this, this, (EditCommand) obj);
                return generateBatchErrorMessage$lambda$0$0;
            }
        }, 60, null);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence generateBatchErrorMessage$lambda$0$0(EditCommand editCommand, EditProcessor editProcessor, EditCommand editCommand2) {
        return (editCommand == editCommand2 ? " > " : "   ") + editProcessor.toStringForLog(editCommand2);
    }

    private final String toStringForLog(EditCommand editCommand) {
        if (editCommand instanceof CommitTextCommand) {
            CommitTextCommand commitTextCommand = (CommitTextCommand) editCommand;
            return "CommitTextCommand(text.length=" + commitTextCommand.getText().length() + ", newCursorPosition=" + commitTextCommand.getNewCursorPosition() + ')';
        } else if (editCommand instanceof SetComposingTextCommand) {
            SetComposingTextCommand setComposingTextCommand = (SetComposingTextCommand) editCommand;
            return "SetComposingTextCommand(text.length=" + setComposingTextCommand.getText().length() + ", newCursorPosition=" + setComposingTextCommand.getNewCursorPosition() + ')';
        } else if (editCommand instanceof SetComposingRegionCommand) {
            return ((SetComposingRegionCommand) editCommand).toString();
        } else {
            if (editCommand instanceof DeleteSurroundingTextCommand) {
                return ((DeleteSurroundingTextCommand) editCommand).toString();
            }
            if (editCommand instanceof DeleteSurroundingTextInCodePointsCommand) {
                return ((DeleteSurroundingTextInCodePointsCommand) editCommand).toString();
            }
            if (editCommand instanceof SetSelectionCommand) {
                return ((SetSelectionCommand) editCommand).toString();
            }
            if (editCommand instanceof FinishComposingTextCommand) {
                return ((FinishComposingTextCommand) editCommand).toString();
            }
            if (editCommand instanceof BackspaceCommand) {
                return ((BackspaceCommand) editCommand).toString();
            }
            if (editCommand instanceof MoveCursorCommand) {
                return ((MoveCursorCommand) editCommand).toString();
            }
            if (editCommand instanceof DeleteAllCommand) {
                return ((DeleteAllCommand) editCommand).toString();
            }
            StringBuilder sb = new StringBuilder("Unknown EditCommand: ");
            String simpleName = Reflection.getOrCreateKotlinClass(editCommand.getClass()).getSimpleName();
            if (simpleName == null) {
                simpleName = "{anonymous EditCommand}";
            }
            return sb.append(simpleName).toString();
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
            AnnotatedString annotatedString$ui_text = this.mBuffer.toAnnotatedString$ui_text();
            long m7166getSelectiond9O1mEE$ui_text = this.mBuffer.m7166getSelectiond9O1mEE$ui_text();
            TextRange m6991boximpl = TextRange.m6991boximpl(m7166getSelectiond9O1mEE$ui_text);
            m6991boximpl.m7007unboximpl();
            TextRange textRange = TextRange.m7002getReversedimpl(this.mBufferState.m7253getSelectiond9O1mEE()) ? null : m6991boximpl;
            TextFieldValue textFieldValue = new TextFieldValue(annotatedString$ui_text, textRange != null ? textRange.m7007unboximpl() : TextRangeKt.TextRange(TextRange.m7000getMaximpl(m7166getSelectiond9O1mEE$ui_text), TextRange.m7001getMinimpl(m7166getSelectiond9O1mEE$ui_text)), this.mBuffer.m7165getCompositionMzsxiRA$ui_text(), (DefaultConstructorMarker) null);
            this.mBufferState = textFieldValue;
            return textFieldValue;
        } catch (Exception e3) {
            e = e3;
        }
    }
}
