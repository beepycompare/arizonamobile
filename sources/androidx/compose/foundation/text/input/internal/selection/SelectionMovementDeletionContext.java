package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
/* compiled from: TextPreparedSelection.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\b\u0001\u0018\u0000 Y2\u00020\u0001:\u0001YB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ,\u0010%\u001a\u00020\u00002\b\b\u0002\u0010&\u001a\u00020\u00072\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020)0(¢\u0006\u0002\b*H\u0082\bJ\u0006\u0010+\u001a\u00020\u0000J\u0006\u0010,\u001a\u00020\u0000J\u0006\u0010-\u001a\u00020\u0000J\u0006\u0010.\u001a\u00020\u0000J\u001f\u0010/\u001a\u00020\u00002\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020)0(¢\u0006\u0002\b*J\u001f\u00101\u001a\u00020\u00002\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020)0(¢\u0006\u0002\b*J\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u000203J!\u00105\u001a\u00020\u00002\b\b\u0002\u0010&\u001a\u00020\u00072\f\u00106\u001a\b\u0012\u0004\u0012\u00020307H\u0082\bJ\u0006\u00108\u001a\u00020\u0000J\u0006\u00109\u001a\u00020\u0000J\u0006\u0010:\u001a\u00020\u0000J\u0006\u0010;\u001a\u00020\u0000J\u0006\u0010<\u001a\u00020\u0000J\u0006\u0010=\u001a\u00020\u0000J\u0006\u0010>\u001a\u00020\u0000J\u0006\u0010?\u001a\u00020\u0000J\u0006\u0010@\u001a\u00020\u0000J\u0006\u0010A\u001a\u00020\u0000J\u0006\u0010B\u001a\u00020\u0000J\u0006\u0010C\u001a\u00020\u0000J\u0006\u0010D\u001a\u00020\u0000J\u0006\u0010E\u001a\u00020\u0000J\u0006\u0010F\u001a\u00020\u0000J\u0006\u0010G\u001a\u00020\u0000J\u0006\u0010H\u001a\u00020\u0000J\u0006\u0010I\u001a\u00020\u0000J\u0006\u0010J\u001a\u00020\u0000J\u0006\u0010K\u001a\u00020\u0000J\u0006\u0010L\u001a\u00020\u0000J\b\u0010M\u001a\u00020\u0007H\u0002J\u0017\u0010N\u001a\u000203*\u00020\u00052\b\b\u0002\u0010O\u001a\u000203H\u0082\u0010J\u0017\u0010P\u001a\u000203*\u00020\u00052\b\b\u0002\u0010O\u001a\u000203H\u0082\u0010J\u0016\u0010Q\u001a\u000203*\u00020\u00052\b\b\u0002\u0010O\u001a\u000203H\u0002J\u0016\u0010R\u001a\u000203*\u00020\u00052\b\b\u0002\u0010O\u001a\u000203H\u0002J\u0014\u0010S\u001a\u000203*\u00020\u00052\u0006\u0010T\u001a\u000203H\u0002J\u0010\u0010U\u001a\u0002032\u0006\u0010V\u001a\u000203H\u0002J\u0010\u0010W\u001a\u0002032\u0006\u0010X\u001a\u000203H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/SelectionMovementDeletionContext;", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "isFromSoftKeyboard", "", "visibleTextLayoutHeight", "", "textPreparedSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;", "<init>", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/ui/text/TextLayoutResult;ZFLandroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;)V", "initialValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getInitialValue", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "initialWedgeAffinity", "Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "getInitialWedgeAffinity", "()Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "selection", "Landroidx/compose/ui/text/TextRange;", "getSelection-d9O1mEE", "()J", "setSelection-5zc-tL8", "(J)V", "J", "wedgeAffinity", "Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "getWedgeAffinity", "()Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "setWedgeAffinity", "(Landroidx/compose/foundation/text/input/internal/WedgeAffinity;)V", "text", "", "applyIfNotEmpty", "resetCachedX", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "selectAll", "deselect", "moveCursorLeftByChar", "moveCursorRightByChar", "collapseLeftOr", "or", "collapseRightOr", "getPrecedingCharacterIndex", "", "getNextCharacterIndex", "moveCursorTo", "proposedCursorMovement", "Lkotlin/Function0;", "moveCursorPrevByCodePointOrEmoji", "moveCursorPrevByChar", "moveCursorNextByChar", "moveCursorToHome", "moveCursorToEnd", "moveCursorLeftByWord", "moveCursorRightByWord", "moveCursorNextByWord", "moveCursorPrevByWord", "moveCursorPrevByParagraph", "moveCursorNextByParagraph", "moveCursorUpByLine", "moveCursorDownByLine", "moveCursorToLineLeftSide", "moveCursorToLineRightSide", "moveCursorToLineStart", "moveCursorToLineEnd", "moveCursorUpByPage", "moveCursorDownByPage", "selectMovement", "deleteMovement", "isLtr", "getNextWordOffsetForLayout", "currentOffset", "getPrevWordOffsetForLayout", "getLineStartByOffsetForLayout", "getLineEndByOffsetForLayout", "jumpByLinesOffset", "linesAmount", "jumpByPagesOffset", "pagesAmount", "charOffset", TypedValues.CycleType.S_WAVE_OFFSET, "Companion", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SelectionMovementDeletionContext {
    public static final int NoCharacterFound = -1;
    private final TextFieldCharSequence initialValue;
    private final SelectionWedgeAffinity initialWedgeAffinity;
    private final boolean isFromSoftKeyboard;
    private long selection;
    private final TransformedTextFieldState state;
    private final String text;
    private final TextLayoutResult textLayoutResult;
    private final TextFieldPreparedSelectionState textPreparedSelectionState;
    private final float visibleTextLayoutHeight;
    private WedgeAffinity wedgeAffinity;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public SelectionMovementDeletionContext(TransformedTextFieldState transformedTextFieldState, TextLayoutResult textLayoutResult, boolean z, float f, TextFieldPreparedSelectionState textFieldPreparedSelectionState) {
        this.state = transformedTextFieldState;
        this.textLayoutResult = textLayoutResult;
        this.isFromSoftKeyboard = z;
        this.visibleTextLayoutHeight = f;
        this.textPreparedSelectionState = textFieldPreparedSelectionState;
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            TextFieldCharSequence visualText = transformedTextFieldState.getVisualText();
            this.initialValue = visualText;
            this.initialWedgeAffinity = transformedTextFieldState.getSelectionWedgeAffinity();
            Unit unit = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            this.selection = visualText.m1336getSelectiond9O1mEE();
            this.text = visualText.getText().toString();
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    public final TextFieldCharSequence getInitialValue() {
        return this.initialValue;
    }

    public final SelectionWedgeAffinity getInitialWedgeAffinity() {
        return this.initialWedgeAffinity;
    }

    /* renamed from: getSelection-d9O1mEE  reason: not valid java name */
    public final long m1486getSelectiond9O1mEE() {
        return this.selection;
    }

    /* renamed from: setSelection-5zc-tL8  reason: not valid java name */
    public final void m1487setSelection5zctL8(long j) {
        this.selection = j;
    }

    public final WedgeAffinity getWedgeAffinity() {
        return this.wedgeAffinity;
    }

    public final void setWedgeAffinity(WedgeAffinity wedgeAffinity) {
        this.wedgeAffinity = wedgeAffinity;
    }

    private final SelectionMovementDeletionContext applyIfNotEmpty(boolean z, Function1<? super SelectionMovementDeletionContext, Unit> function1) {
        if (z) {
            this.textPreparedSelectionState.resetCachedX();
        }
        if (this.text.length() > 0) {
            function1.invoke(this);
        }
        return this;
    }

    static /* synthetic */ SelectionMovementDeletionContext applyIfNotEmpty$default(SelectionMovementDeletionContext selectionMovementDeletionContext, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if (z) {
            selectionMovementDeletionContext.textPreparedSelectionState.resetCachedX();
        }
        if (selectionMovementDeletionContext.text.length() > 0) {
            function1.invoke(selectionMovementDeletionContext);
        }
        return selectionMovementDeletionContext;
    }

    public final SelectionMovementDeletionContext moveCursorLeftByChar() {
        if (isLtr()) {
            return moveCursorPrevByChar();
        }
        return moveCursorNextByChar();
    }

    public final SelectionMovementDeletionContext moveCursorRightByChar() {
        if (isLtr()) {
            return moveCursorNextByChar();
        }
        return moveCursorPrevByChar();
    }

    public final int getPrecedingCharacterIndex() {
        return StringHelpers_androidKt.findPrecedingBreak(this.text, TextRange.m6998getEndimpl(this.selection));
    }

    public final int getNextCharacterIndex() {
        return StringHelpers_androidKt.findFollowingBreak(this.text, TextRange.m6998getEndimpl(this.selection));
    }

    public final SelectionMovementDeletionContext moveCursorLeftByWord() {
        if (isLtr()) {
            return moveCursorPrevByWord();
        }
        return moveCursorNextByWord();
    }

    public final SelectionMovementDeletionContext moveCursorRightByWord() {
        if (isLtr()) {
            return moveCursorNextByWord();
        }
        return moveCursorPrevByWord();
    }

    public final SelectionMovementDeletionContext moveCursorUpByLine() {
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        int jumpByLinesOffset = textLayoutResult != null ? jumpByLinesOffset(textLayoutResult, -1) : Integer.MIN_VALUE;
        if (jumpByLinesOffset == Integer.MIN_VALUE) {
            this.textPreparedSelectionState.resetCachedX();
        }
        if (this.text.length() > 0) {
            int m6998getEndimpl = TextRange.m6998getEndimpl(m1486getSelectiond9O1mEE());
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(RangesKt.coerceAtLeast(jumpByLinesOffset, 0), m6998getEndimpl, this.state);
            int m1474component1impl = CursorAndWedgeAffinity.m1474component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1475component2impl = CursorAndWedgeAffinity.m1475component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1474component1impl != m6998getEndimpl || !TextRange.m6997getCollapsedimpl(m1486getSelectiond9O1mEE())) {
                m1487setSelection5zctL8(TextRangeKt.TextRange(m1474component1impl));
            }
            if (m1475component2impl != null) {
                setWedgeAffinity(m1475component2impl);
            }
        }
        return this;
    }

    public final SelectionMovementDeletionContext moveCursorDownByLine() {
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        int jumpByLinesOffset = textLayoutResult != null ? jumpByLinesOffset(textLayoutResult, 1) : Integer.MAX_VALUE;
        if (jumpByLinesOffset == Integer.MAX_VALUE) {
            this.textPreparedSelectionState.resetCachedX();
        }
        if (this.text.length() > 0) {
            int m6998getEndimpl = TextRange.m6998getEndimpl(m1486getSelectiond9O1mEE());
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(RangesKt.coerceAtMost(jumpByLinesOffset, this.text.length()), m6998getEndimpl, this.state);
            int m1474component1impl = CursorAndWedgeAffinity.m1474component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1475component2impl = CursorAndWedgeAffinity.m1475component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1474component1impl != m6998getEndimpl || !TextRange.m6997getCollapsedimpl(m1486getSelectiond9O1mEE())) {
                m1487setSelection5zctL8(TextRangeKt.TextRange(m1474component1impl));
            }
            if (m1475component2impl != null) {
                setWedgeAffinity(m1475component2impl);
            }
        }
        return this;
    }

    public final SelectionMovementDeletionContext moveCursorToLineLeftSide() {
        if (isLtr()) {
            return moveCursorToLineStart();
        }
        return moveCursorToLineEnd();
    }

    public final SelectionMovementDeletionContext moveCursorToLineRightSide() {
        if (isLtr()) {
            return moveCursorToLineEnd();
        }
        return moveCursorToLineStart();
    }

    private final boolean isLtr() {
        ResolvedTextDirection paragraphDirection;
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        return textLayoutResult == null || (paragraphDirection = textLayoutResult.getParagraphDirection(TextRange.m6998getEndimpl(this.selection))) == null || paragraphDirection == ResolvedTextDirection.Ltr;
    }

    static /* synthetic */ int getNextWordOffsetForLayout$default(SelectionMovementDeletionContext selectionMovementDeletionContext, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = TextRange.m6998getEndimpl(selectionMovementDeletionContext.selection);
        }
        return selectionMovementDeletionContext.getNextWordOffsetForLayout(textLayoutResult, i);
    }

    private final int getNextWordOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        while (i < this.initialValue.length()) {
            long m6975getWordBoundaryjx7JFs = textLayoutResult.m6975getWordBoundaryjx7JFs(charOffset(i));
            if (TextRange.m6998getEndimpl(m6975getWordBoundaryjx7JFs) > i) {
                return TextRange.m6998getEndimpl(m6975getWordBoundaryjx7JFs);
            }
            i++;
        }
        return this.initialValue.length();
    }

    static /* synthetic */ int getPrevWordOffsetForLayout$default(SelectionMovementDeletionContext selectionMovementDeletionContext, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = TextRange.m6998getEndimpl(selectionMovementDeletionContext.selection);
        }
        return selectionMovementDeletionContext.getPrevWordOffsetForLayout(textLayoutResult, i);
    }

    private final int getPrevWordOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        while (i > 0) {
            long m6975getWordBoundaryjx7JFs = textLayoutResult.m6975getWordBoundaryjx7JFs(charOffset(i));
            if (TextRange.m7003getStartimpl(m6975getWordBoundaryjx7JFs) < i) {
                return TextRange.m7003getStartimpl(m6975getWordBoundaryjx7JFs);
            }
            i--;
        }
        return 0;
    }

    static /* synthetic */ int getLineStartByOffsetForLayout$default(SelectionMovementDeletionContext selectionMovementDeletionContext, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = TextRange.m7001getMinimpl(selectionMovementDeletionContext.selection);
        }
        return selectionMovementDeletionContext.getLineStartByOffsetForLayout(textLayoutResult, i);
    }

    private final int getLineStartByOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        return textLayoutResult.getLineStart(textLayoutResult.getLineForOffset(i));
    }

    static /* synthetic */ int getLineEndByOffsetForLayout$default(SelectionMovementDeletionContext selectionMovementDeletionContext, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = TextRange.m7000getMaximpl(selectionMovementDeletionContext.selection);
        }
        return selectionMovementDeletionContext.getLineEndByOffsetForLayout(textLayoutResult, i);
    }

    private final int getLineEndByOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        return textLayoutResult.getLineEnd(textLayoutResult.getLineForOffset(i), true);
    }

    private final int jumpByLinesOffset(TextLayoutResult textLayoutResult, int i) {
        int m6998getEndimpl = TextRange.m6998getEndimpl(this.selection);
        if (Float.isNaN(this.textPreparedSelectionState.getCachedX())) {
            this.textPreparedSelectionState.setCachedX(textLayoutResult.getCursorRect(m6998getEndimpl).getLeft());
        }
        int lineForOffset = textLayoutResult.getLineForOffset(m6998getEndimpl) + i;
        if (lineForOffset < 0) {
            return Integer.MIN_VALUE;
        }
        if (lineForOffset >= textLayoutResult.getLineCount()) {
            return Integer.MAX_VALUE;
        }
        float lineBottom = textLayoutResult.getLineBottom(lineForOffset) - 1.0f;
        float cachedX = this.textPreparedSelectionState.getCachedX();
        if ((isLtr() && cachedX >= textLayoutResult.getLineRight(lineForOffset)) || (!isLtr() && cachedX <= textLayoutResult.getLineLeft(lineForOffset))) {
            return textLayoutResult.getLineEnd(lineForOffset, true);
        }
        return textLayoutResult.m6973getOffsetForPositionk4lQ0M(Offset.m4519constructorimpl((Float.floatToRawIntBits(cachedX) << 32) | (Float.floatToRawIntBits(lineBottom) & 4294967295L)));
    }

    private final int jumpByPagesOffset(int i) {
        int m6998getEndimpl = TextRange.m6998getEndimpl(this.initialValue.m1336getSelectiond9O1mEE());
        if (this.textLayoutResult == null || Float.isNaN(this.visibleTextLayoutHeight)) {
            return m6998getEndimpl;
        }
        Rect translate = this.textLayoutResult.getCursorRect(m6998getEndimpl).translate(0.0f, this.visibleTextLayoutHeight * i);
        float lineBottom = this.textLayoutResult.getLineBottom(this.textLayoutResult.getLineForVerticalPosition(translate.getTop()));
        int i2 = (Math.abs(translate.getTop() - lineBottom) > Math.abs(translate.getBottom() - lineBottom) ? 1 : (Math.abs(translate.getTop() - lineBottom) == Math.abs(translate.getBottom() - lineBottom) ? 0 : -1));
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        if (i2 > 0) {
            return textLayoutResult.m6973getOffsetForPositionk4lQ0M(translate.m4562getTopLeftF1C5BW0());
        }
        return textLayoutResult.m6973getOffsetForPositionk4lQ0M(translate.m4555getBottomLeftF1C5BW0());
    }

    private final int charOffset(int i) {
        return RangesKt.coerceAtMost(i, this.text.length() - 1);
    }

    /* compiled from: TextPreparedSelection.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/SelectionMovementDeletionContext$Companion;", "", "<init>", "()V", "NoCharacterFound", "", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final SelectionMovementDeletionContext selectAll() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            this.selection = TextRangeKt.TextRange(0, this.text.length());
        }
        return this;
    }

    public final SelectionMovementDeletionContext deselect() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            this.selection = TextRangeKt.TextRange(TextRange.m6998getEndimpl(this.selection));
        }
        return this;
    }

    public final SelectionMovementDeletionContext collapseLeftOr(Function1<? super SelectionMovementDeletionContext, Unit> function1) {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            if (TextRange.m6997getCollapsedimpl(this.selection)) {
                function1.invoke(this);
                return this;
            }
            boolean isLtr = isLtr();
            long j = this.selection;
            if (isLtr) {
                this.selection = TextRangeKt.TextRange(TextRange.m7001getMinimpl(j));
                return this;
            }
            this.selection = TextRangeKt.TextRange(TextRange.m7000getMaximpl(j));
        }
        return this;
    }

    public final SelectionMovementDeletionContext collapseRightOr(Function1<? super SelectionMovementDeletionContext, Unit> function1) {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            if (TextRange.m6997getCollapsedimpl(this.selection)) {
                function1.invoke(this);
                return this;
            }
            boolean isLtr = isLtr();
            long j = this.selection;
            if (isLtr) {
                this.selection = TextRangeKt.TextRange(TextRange.m7000getMaximpl(j));
                return this;
            }
            this.selection = TextRangeKt.TextRange(TextRange.m7001getMinimpl(j));
        }
        return this;
    }

    private final SelectionMovementDeletionContext moveCursorTo(boolean z, Function0<Integer> function0) {
        if (z) {
            this.textPreparedSelectionState.resetCachedX();
        }
        if (this.text.length() > 0) {
            int m6998getEndimpl = TextRange.m6998getEndimpl(m1486getSelectiond9O1mEE());
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(function0.invoke().intValue(), m6998getEndimpl, this.state);
            int m1474component1impl = CursorAndWedgeAffinity.m1474component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1475component2impl = CursorAndWedgeAffinity.m1475component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1474component1impl != m6998getEndimpl || !TextRange.m6997getCollapsedimpl(m1486getSelectiond9O1mEE())) {
                m1487setSelection5zctL8(TextRangeKt.TextRange(m1474component1impl));
            }
            if (m1475component2impl != null) {
                setWedgeAffinity(m1475component2impl);
            }
        }
        return this;
    }

    static /* synthetic */ SelectionMovementDeletionContext moveCursorTo$default(SelectionMovementDeletionContext selectionMovementDeletionContext, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if (z) {
            selectionMovementDeletionContext.textPreparedSelectionState.resetCachedX();
        }
        if (selectionMovementDeletionContext.text.length() > 0) {
            int m6998getEndimpl = TextRange.m6998getEndimpl(selectionMovementDeletionContext.m1486getSelectiond9O1mEE());
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(((Number) function0.invoke()).intValue(), m6998getEndimpl, selectionMovementDeletionContext.state);
            int m1474component1impl = CursorAndWedgeAffinity.m1474component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1475component2impl = CursorAndWedgeAffinity.m1475component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1474component1impl != m6998getEndimpl || !TextRange.m6997getCollapsedimpl(selectionMovementDeletionContext.m1486getSelectiond9O1mEE())) {
                selectionMovementDeletionContext.m1487setSelection5zctL8(TextRangeKt.TextRange(m1474component1impl));
            }
            if (m1475component2impl != null) {
                selectionMovementDeletionContext.setWedgeAffinity(m1475component2impl);
            }
        }
        return selectionMovementDeletionContext;
    }

    public final SelectionMovementDeletionContext moveCursorPrevByCodePointOrEmoji() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            int m6998getEndimpl = TextRange.m6998getEndimpl(m1486getSelectiond9O1mEE());
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(StringHelpers_androidKt.findCodePointOrEmojiStartBefore(this.text, TextRange.m6998getEndimpl(this.selection), -1), m6998getEndimpl, this.state);
            int m1474component1impl = CursorAndWedgeAffinity.m1474component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1475component2impl = CursorAndWedgeAffinity.m1475component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1474component1impl != m6998getEndimpl || !TextRange.m6997getCollapsedimpl(m1486getSelectiond9O1mEE())) {
                m1487setSelection5zctL8(TextRangeKt.TextRange(m1474component1impl));
            }
            if (m1475component2impl != null) {
                setWedgeAffinity(m1475component2impl);
            }
        }
        return this;
    }

    public final SelectionMovementDeletionContext moveCursorPrevByChar() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            int m6998getEndimpl = TextRange.m6998getEndimpl(m1486getSelectiond9O1mEE());
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(StringHelpers_androidKt.findPrecedingBreak(this.text, TextRange.m6998getEndimpl(this.selection)), m6998getEndimpl, this.state);
            int m1474component1impl = CursorAndWedgeAffinity.m1474component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1475component2impl = CursorAndWedgeAffinity.m1475component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1474component1impl != m6998getEndimpl || !TextRange.m6997getCollapsedimpl(m1486getSelectiond9O1mEE())) {
                m1487setSelection5zctL8(TextRangeKt.TextRange(m1474component1impl));
            }
            if (m1475component2impl != null) {
                setWedgeAffinity(m1475component2impl);
            }
        }
        return this;
    }

    public final SelectionMovementDeletionContext moveCursorNextByChar() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            int m6998getEndimpl = TextRange.m6998getEndimpl(m1486getSelectiond9O1mEE());
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(StringHelpers_androidKt.findFollowingBreak(this.text, TextRange.m6998getEndimpl(this.selection)), m6998getEndimpl, this.state);
            int m1474component1impl = CursorAndWedgeAffinity.m1474component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1475component2impl = CursorAndWedgeAffinity.m1475component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1474component1impl != m6998getEndimpl || !TextRange.m6997getCollapsedimpl(m1486getSelectiond9O1mEE())) {
                m1487setSelection5zctL8(TextRangeKt.TextRange(m1474component1impl));
            }
            if (m1475component2impl != null) {
                setWedgeAffinity(m1475component2impl);
            }
        }
        return this;
    }

    public final SelectionMovementDeletionContext moveCursorToHome() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            int m6998getEndimpl = TextRange.m6998getEndimpl(m1486getSelectiond9O1mEE());
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(0, m6998getEndimpl, this.state);
            int m1474component1impl = CursorAndWedgeAffinity.m1474component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1475component2impl = CursorAndWedgeAffinity.m1475component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1474component1impl != m6998getEndimpl || !TextRange.m6997getCollapsedimpl(m1486getSelectiond9O1mEE())) {
                m1487setSelection5zctL8(TextRangeKt.TextRange(m1474component1impl));
            }
            if (m1475component2impl != null) {
                setWedgeAffinity(m1475component2impl);
            }
        }
        return this;
    }

    public final SelectionMovementDeletionContext moveCursorToEnd() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            int m6998getEndimpl = TextRange.m6998getEndimpl(m1486getSelectiond9O1mEE());
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(this.text.length(), m6998getEndimpl, this.state);
            int m1474component1impl = CursorAndWedgeAffinity.m1474component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1475component2impl = CursorAndWedgeAffinity.m1475component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1474component1impl != m6998getEndimpl || !TextRange.m6997getCollapsedimpl(m1486getSelectiond9O1mEE())) {
                m1487setSelection5zctL8(TextRangeKt.TextRange(m1474component1impl));
            }
            if (m1475component2impl != null) {
                setWedgeAffinity(m1475component2impl);
            }
        }
        return this;
    }

    public final SelectionMovementDeletionContext moveCursorNextByWord() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            int m6998getEndimpl = TextRange.m6998getEndimpl(m1486getSelectiond9O1mEE());
            TextLayoutResult textLayoutResult = this.textLayoutResult;
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(textLayoutResult != null ? getNextWordOffsetForLayout$default(this, textLayoutResult, 0, 1, null) : this.text.length(), m6998getEndimpl, this.state);
            int m1474component1impl = CursorAndWedgeAffinity.m1474component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1475component2impl = CursorAndWedgeAffinity.m1475component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1474component1impl != m6998getEndimpl || !TextRange.m6997getCollapsedimpl(m1486getSelectiond9O1mEE())) {
                m1487setSelection5zctL8(TextRangeKt.TextRange(m1474component1impl));
            }
            if (m1475component2impl != null) {
                setWedgeAffinity(m1475component2impl);
            }
        }
        return this;
    }

    public final SelectionMovementDeletionContext moveCursorPrevByWord() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            int m6998getEndimpl = TextRange.m6998getEndimpl(m1486getSelectiond9O1mEE());
            TextLayoutResult textLayoutResult = this.textLayoutResult;
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(textLayoutResult != null ? getPrevWordOffsetForLayout$default(this, textLayoutResult, 0, 1, null) : 0, m6998getEndimpl, this.state);
            int m1474component1impl = CursorAndWedgeAffinity.m1474component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1475component2impl = CursorAndWedgeAffinity.m1475component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1474component1impl != m6998getEndimpl || !TextRange.m6997getCollapsedimpl(m1486getSelectiond9O1mEE())) {
                m1487setSelection5zctL8(TextRangeKt.TextRange(m1474component1impl));
            }
            if (m1475component2impl != null) {
                setWedgeAffinity(m1475component2impl);
            }
        }
        return this;
    }

    public final SelectionMovementDeletionContext moveCursorPrevByParagraph() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            int m6998getEndimpl = TextRange.m6998getEndimpl(m1486getSelectiond9O1mEE());
            int findParagraphStart = StringHelpersKt.findParagraphStart(this.text, TextRange.m7001getMinimpl(this.selection));
            if (findParagraphStart == TextRange.m7001getMinimpl(this.selection) && findParagraphStart != 0) {
                findParagraphStart = StringHelpersKt.findParagraphStart(this.text, findParagraphStart - 1);
            }
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(findParagraphStart, m6998getEndimpl, this.state);
            int m1474component1impl = CursorAndWedgeAffinity.m1474component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1475component2impl = CursorAndWedgeAffinity.m1475component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1474component1impl != m6998getEndimpl || !TextRange.m6997getCollapsedimpl(m1486getSelectiond9O1mEE())) {
                m1487setSelection5zctL8(TextRangeKt.TextRange(m1474component1impl));
            }
            if (m1475component2impl != null) {
                setWedgeAffinity(m1475component2impl);
            }
        }
        return this;
    }

    public final SelectionMovementDeletionContext moveCursorNextByParagraph() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            int m6998getEndimpl = TextRange.m6998getEndimpl(m1486getSelectiond9O1mEE());
            int findParagraphEnd = StringHelpersKt.findParagraphEnd(this.text, TextRange.m7000getMaximpl(this.selection));
            if (findParagraphEnd == TextRange.m7000getMaximpl(this.selection) && findParagraphEnd != this.text.length()) {
                findParagraphEnd = StringHelpersKt.findParagraphEnd(this.text, findParagraphEnd + 1);
            }
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(findParagraphEnd, m6998getEndimpl, this.state);
            int m1474component1impl = CursorAndWedgeAffinity.m1474component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1475component2impl = CursorAndWedgeAffinity.m1475component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1474component1impl != m6998getEndimpl || !TextRange.m6997getCollapsedimpl(m1486getSelectiond9O1mEE())) {
                m1487setSelection5zctL8(TextRangeKt.TextRange(m1474component1impl));
            }
            if (m1475component2impl != null) {
                setWedgeAffinity(m1475component2impl);
            }
        }
        return this;
    }

    public final SelectionMovementDeletionContext moveCursorToLineStart() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            int m6998getEndimpl = TextRange.m6998getEndimpl(m1486getSelectiond9O1mEE());
            TextLayoutResult textLayoutResult = this.textLayoutResult;
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(textLayoutResult != null ? getLineStartByOffsetForLayout$default(this, textLayoutResult, 0, 1, null) : 0, m6998getEndimpl, this.state);
            int m1474component1impl = CursorAndWedgeAffinity.m1474component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1475component2impl = CursorAndWedgeAffinity.m1475component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1474component1impl != m6998getEndimpl || !TextRange.m6997getCollapsedimpl(m1486getSelectiond9O1mEE())) {
                m1487setSelection5zctL8(TextRangeKt.TextRange(m1474component1impl));
            }
            if (m1475component2impl != null) {
                setWedgeAffinity(m1475component2impl);
            }
        }
        return this;
    }

    public final SelectionMovementDeletionContext moveCursorToLineEnd() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            int m6998getEndimpl = TextRange.m6998getEndimpl(m1486getSelectiond9O1mEE());
            TextLayoutResult textLayoutResult = this.textLayoutResult;
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(textLayoutResult != null ? getLineEndByOffsetForLayout$default(this, textLayoutResult, 0, 1, null) : this.text.length(), m6998getEndimpl, this.state);
            int m1474component1impl = CursorAndWedgeAffinity.m1474component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1475component2impl = CursorAndWedgeAffinity.m1475component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1474component1impl != m6998getEndimpl || !TextRange.m6997getCollapsedimpl(m1486getSelectiond9O1mEE())) {
                m1487setSelection5zctL8(TextRangeKt.TextRange(m1474component1impl));
            }
            if (m1475component2impl != null) {
                setWedgeAffinity(m1475component2impl);
            }
        }
        return this;
    }

    public final SelectionMovementDeletionContext moveCursorUpByPage() {
        if (this.text.length() > 0) {
            int m6998getEndimpl = TextRange.m6998getEndimpl(m1486getSelectiond9O1mEE());
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(jumpByPagesOffset(-1), m6998getEndimpl, this.state);
            int m1474component1impl = CursorAndWedgeAffinity.m1474component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1475component2impl = CursorAndWedgeAffinity.m1475component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1474component1impl != m6998getEndimpl || !TextRange.m6997getCollapsedimpl(m1486getSelectiond9O1mEE())) {
                m1487setSelection5zctL8(TextRangeKt.TextRange(m1474component1impl));
            }
            if (m1475component2impl != null) {
                setWedgeAffinity(m1475component2impl);
            }
        }
        return this;
    }

    public final SelectionMovementDeletionContext moveCursorDownByPage() {
        if (this.text.length() > 0) {
            int m6998getEndimpl = TextRange.m6998getEndimpl(m1486getSelectiond9O1mEE());
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(jumpByPagesOffset(1), m6998getEndimpl, this.state);
            int m1474component1impl = CursorAndWedgeAffinity.m1474component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1475component2impl = CursorAndWedgeAffinity.m1475component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1474component1impl != m6998getEndimpl || !TextRange.m6997getCollapsedimpl(m1486getSelectiond9O1mEE())) {
                m1487setSelection5zctL8(TextRangeKt.TextRange(m1474component1impl));
            }
            if (m1475component2impl != null) {
                setWedgeAffinity(m1475component2impl);
            }
        }
        return this;
    }

    public final SelectionMovementDeletionContext selectMovement() {
        if (this.text.length() > 0) {
            this.selection = TextRangeKt.TextRange(TextRange.m7003getStartimpl(this.initialValue.m1336getSelectiond9O1mEE()), TextRange.m6998getEndimpl(this.selection));
        }
        return this;
    }

    public final SelectionMovementDeletionContext deleteMovement() {
        if (this.text.length() > 0) {
            boolean m6997getCollapsedimpl = TextRange.m6997getCollapsedimpl(this.initialValue.m1336getSelectiond9O1mEE());
            TransformedTextFieldState transformedTextFieldState = this.state;
            if (!m6997getCollapsedimpl) {
                transformedTextFieldState.deleteSelectedText();
            } else {
                TransformedTextFieldState.m1459replaceTextM8tDOmk$default(transformedTextFieldState, "", TextRangeKt.TextRange(TextRange.m7003getStartimpl(this.initialValue.m1336getSelectiond9O1mEE()), TextRange.m6998getEndimpl(this.selection)), null, !this.isFromSoftKeyboard, 4, null);
            }
            this.selection = this.state.getVisualText().m1336getSelectiond9O1mEE();
            this.wedgeAffinity = WedgeAffinity.Start;
        }
        return this;
    }
}
