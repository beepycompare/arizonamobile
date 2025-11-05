package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: EditingBuffer.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001=B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\tJ\r\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cJ\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\rH\u0080\u0002¢\u0006\u0002\b(J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\b/J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\bH\u0000¢\u0006\u0002\b/J\u001d\u00100\u001a\u00020,2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\rH\u0000¢\u0006\u0002\b1J\u001d\u00102\u001a\u00020,2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\rH\u0000¢\u0006\u0002\b3J\u001d\u00104\u001a\u00020,2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\rH\u0000¢\u0006\u0002\b5J\r\u00106\u001a\u00020,H\u0000¢\u0006\u0002\b7J\r\u00108\u001a\u00020,H\u0000¢\u0006\u0002\b9J\b\u0010:\u001a\u00020\bH\u0016J\r\u0010;\u001a\u00020\u0003H\u0000¢\u0006\u0002\b<R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001e\u0010\u0016\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001e\u0010\u0018\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0004\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R$\u0010\"\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\r8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u0014\u0010)\u001a\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0010¨\u0006>"}, d2 = {"Landroidx/compose/ui/text/input/EditingBuffer;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "selection", "Landroidx/compose/ui/text/TextRange;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "gapBuffer", "Landroidx/compose/ui/text/input/PartialGapBuffer;", "value", "", "selectionStart", "getSelectionStart$ui_text", "()I", "setSelectionStart", "(I)V", "selectionEnd", "getSelectionEnd$ui_text", "setSelectionEnd", "compositionStart", "getCompositionStart$ui_text", "compositionEnd", "getCompositionEnd$ui_text", "hasComposition", "", "hasComposition$ui_text", "composition", "getComposition-MzsxiRA$ui_text", "()Landroidx/compose/ui/text/TextRange;", "getSelection-d9O1mEE$ui_text", "()J", "cursor", "getCursor$ui_text", "setCursor$ui_text", "get", "", FirebaseAnalytics.Param.INDEX, "get$ui_text", "length", "getLength$ui_text", "replace", "", TtmlNode.START, TtmlNode.END, "replace$ui_text", "delete", "delete$ui_text", "setSelection", "setSelection$ui_text", "setComposition", "setComposition$ui_text", "cancelComposition", "cancelComposition$ui_text", "commitComposition", "commitComposition$ui_text", "toString", "toAnnotatedString", "toAnnotatedString$ui_text", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EditingBuffer {
    public static final int NOWHERE = -1;
    private int compositionEnd;
    private int compositionStart;
    private final PartialGapBuffer gapBuffer;
    private int selectionEnd;
    private int selectionStart;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public /* synthetic */ EditingBuffer(AnnotatedString annotatedString, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, j);
    }

    public /* synthetic */ EditingBuffer(String str, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j);
    }

    private EditingBuffer(AnnotatedString annotatedString, long j) {
        this.gapBuffer = new PartialGapBuffer(annotatedString.getText());
        this.selectionStart = TextRange.m7455getMinimpl(j);
        this.selectionEnd = TextRange.m7454getMaximpl(j);
        this.compositionStart = -1;
        this.compositionEnd = -1;
        int m7455getMinimpl = TextRange.m7455getMinimpl(j);
        int m7454getMaximpl = TextRange.m7454getMaximpl(j);
        if (m7455getMinimpl < 0 || m7455getMinimpl > annotatedString.length()) {
            throw new IndexOutOfBoundsException("start (" + m7455getMinimpl + ") offset is outside of text region " + annotatedString.length());
        }
        if (m7454getMaximpl < 0 || m7454getMaximpl > annotatedString.length()) {
            throw new IndexOutOfBoundsException("end (" + m7454getMaximpl + ") offset is outside of text region " + annotatedString.length());
        }
        if (m7455getMinimpl > m7454getMaximpl) {
            throw new IllegalArgumentException("Do not set reversed range: " + m7455getMinimpl + " > " + m7454getMaximpl);
        }
    }

    /* compiled from: EditingBuffer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/text/input/EditingBuffer$Companion;", "", "<init>", "()V", "NOWHERE", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final int getSelectionStart$ui_text() {
        return this.selectionStart;
    }

    private final void setSelectionStart(int i) {
        if (!(i >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot set selectionStart to a negative value: " + i);
        }
        this.selectionStart = i;
    }

    public final int getSelectionEnd$ui_text() {
        return this.selectionEnd;
    }

    private final void setSelectionEnd(int i) {
        if (!(i >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot set selectionEnd to a negative value: " + i);
        }
        this.selectionEnd = i;
    }

    public final int getCompositionStart$ui_text() {
        return this.compositionStart;
    }

    public final int getCompositionEnd$ui_text() {
        return this.compositionEnd;
    }

    public final boolean hasComposition$ui_text() {
        return this.compositionStart != -1;
    }

    /* renamed from: getComposition-MzsxiRA$ui_text  reason: not valid java name */
    public final TextRange m7620getCompositionMzsxiRA$ui_text() {
        if (hasComposition$ui_text()) {
            return TextRange.m7445boximpl(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd));
        }
        return null;
    }

    /* renamed from: getSelection-d9O1mEE$ui_text  reason: not valid java name */
    public final long m7621getSelectiond9O1mEE$ui_text() {
        return TextRangeKt.TextRange(this.selectionStart, this.selectionEnd);
    }

    public final int getCursor$ui_text() {
        int i = this.selectionStart;
        int i2 = this.selectionEnd;
        if (i == i2) {
            return i2;
        }
        return -1;
    }

    public final void setCursor$ui_text(int i) {
        setSelection$ui_text(i, i);
    }

    public final char get$ui_text(int i) {
        return this.gapBuffer.get(i);
    }

    public final int getLength$ui_text() {
        return this.gapBuffer.getLength();
    }

    private EditingBuffer(String str, long j) {
        this(new AnnotatedString(str, null, 2, null), j, (DefaultConstructorMarker) null);
    }

    public final void replace$ui_text(int i, int i2, AnnotatedString annotatedString) {
        replace$ui_text(i, i2, annotatedString.getText());
    }

    public final void replace$ui_text(int i, int i2, String str) {
        if (i < 0 || i > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + i + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i2 < 0 || i2 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + i2 + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i > i2) {
            throw new IllegalArgumentException("Do not set reversed range: " + i + " > " + i2);
        }
        this.gapBuffer.replace(i, i2, str);
        setSelectionStart(str.length() + i);
        setSelectionEnd(i + str.length());
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public final void delete$ui_text(int i, int i2) {
        long TextRange = TextRangeKt.TextRange(i, i2);
        this.gapBuffer.replace(i, i2, "");
        long m7622updateRangeAfterDeletepWDy79M = EditingBufferKt.m7622updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.selectionStart, this.selectionEnd), TextRange);
        setSelectionStart(TextRange.m7455getMinimpl(m7622updateRangeAfterDeletepWDy79M));
        setSelectionEnd(TextRange.m7454getMaximpl(m7622updateRangeAfterDeletepWDy79M));
        if (hasComposition$ui_text()) {
            long m7622updateRangeAfterDeletepWDy79M2 = EditingBufferKt.m7622updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd), TextRange);
            if (TextRange.m7451getCollapsedimpl(m7622updateRangeAfterDeletepWDy79M2)) {
                commitComposition$ui_text();
                return;
            }
            this.compositionStart = TextRange.m7455getMinimpl(m7622updateRangeAfterDeletepWDy79M2);
            this.compositionEnd = TextRange.m7454getMaximpl(m7622updateRangeAfterDeletepWDy79M2);
        }
    }

    public final void setSelection$ui_text(int i, int i2) {
        if (i < 0 || i > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + i + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i2 < 0 || i2 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + i2 + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i > i2) {
            throw new IllegalArgumentException("Do not set reversed range: " + i + " > " + i2);
        }
        setSelectionStart(i);
        setSelectionEnd(i2);
    }

    public final void setComposition$ui_text(int i, int i2) {
        if (i < 0 || i > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + i + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i2 < 0 || i2 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + i2 + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i >= i2) {
            throw new IllegalArgumentException("Do not set reversed or empty range: " + i + " > " + i2);
        }
        this.compositionStart = i;
        this.compositionEnd = i2;
    }

    public final void cancelComposition$ui_text() {
        replace$ui_text(this.compositionStart, this.compositionEnd, "");
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public final void commitComposition$ui_text() {
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public String toString() {
        return this.gapBuffer.toString();
    }

    public final AnnotatedString toAnnotatedString$ui_text() {
        return new AnnotatedString(toString(), null, 2, null);
    }
}
