package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldBufferKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
/* compiled from: TransformedTextFieldState.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u0000 g2\u00020\u0001:\u0002fgB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010*\u001a\u00020+2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u000e\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020.J\u0015\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\u0015¢\u0006\u0004\b1\u00102J\u0015\u00103\u001a\u00020+2\u0006\u00104\u001a\u00020\u0015¢\u0006\u0004\b5\u00102J\u001d\u00106\u001a\u00020+2\u0006\u00107\u001a\u0002082\u0006\u00100\u001a\u00020\u0015¢\u0006\u0004\b9\u0010:J\u000e\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020=J\u0006\u0010>\u001a\u00020+J\u0006\u0010?\u001a\u00020+J1\u0010@\u001a\u00020+2\u0006\u0010<\u001a\u00020=2\u0006\u0010A\u001a\u00020\u00152\b\b\u0002\u0010B\u001a\u00020C2\b\b\u0002\u0010D\u001a\u00020\u0019¢\u0006\u0004\bE\u0010FJ,\u0010G\u001a\u00020+2\u0006\u0010<\u001a\u00020=2\b\b\u0002\u0010H\u001a\u00020\u00192\b\b\u0002\u0010B\u001a\u00020C2\b\b\u0002\u0010D\u001a\u00020\u0019J\u0006\u0010I\u001a\u00020+J\u0006\u0010J\u001a\u00020+J\u0006\u0010K\u001a\u00020+J\u0006\u0010L\u001a\u00020+J,\u0010M\u001a\u00020+2\b\b\u0002\u0010D\u001a\u00020\u00192\u0017\u0010N\u001a\u0013\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020+0O¢\u0006\u0002\bQH\u0086\bJ\f\u0010R\u001a\u00020+*\u00020PH\u0002J\u0015\u0010S\u001a\u00020\u00152\u0006\u0010T\u001a\u00020.¢\u0006\u0004\bU\u0010VJ\u0015\u0010S\u001a\u00020\u00152\u0006\u0010A\u001a\u00020\u0015¢\u0006\u0004\bW\u0010XJ\u0015\u0010Y\u001a\u00020\u00152\u0006\u0010T\u001a\u00020.¢\u0006\u0004\bZ\u0010VJ\u0015\u0010Y\u001a\u00020\u00152\u0006\u0010A\u001a\u00020\u0015¢\u0006\u0004\b[\u0010XJ\u0016\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_H\u0086@¢\u0006\u0002\u0010`J\u0013\u0010a\u001a\u00020\u00192\b\u0010b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010c\u001a\u00020.H\u0016J\b\u0010d\u001a\u00020eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u001e\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010 \u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b \u0010\u001bR+\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006h"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "", "textFieldState", "Landroidx/compose/foundation/text/input/TextFieldState;", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "<init>", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/internal/CodepointTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;)V", "outputTransformedText", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "codepointTransformedText", "untransformedText", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getUntransformedText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "untransformedComposition", "Landroidx/compose/ui/text/TextRange;", "getUntransformedComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "userCommit", "", "getUserCommit", "()Z", "outputText", "getOutputText", "visualText", "getVisualText", "isTransformed", "<set-?>", "Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "selectionWedgeAffinity", "getSelectionWedgeAffinity", "()Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "setSelectionWedgeAffinity", "(Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;)V", "selectionWedgeAffinity$delegate", "Landroidx/compose/runtime/MutableState;", "update", "", "placeCursorBeforeCharAt", "transformedOffset", "", "selectCharsIn", "transformedRange", "selectCharsIn-5zc-tL8", "(J)V", "selectUntransformedCharsIn", "untransformedRange", "selectUntransformedCharsIn-5zc-tL8", "highlightCharsIn", "type", "Landroidx/compose/foundation/text/input/TextHighlightType;", "highlightCharsIn-7RAjNK8", "(IJ)V", "replaceAll", "newText", "", "selectAll", "deleteSelectedText", "replaceText", "range", "undoBehavior", "Landroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;", "restartImeIfContentChanges", "replaceText-M8tDOmk", "(Ljava/lang/CharSequence;JLandroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;Z)V", "replaceSelectedText", "clearComposition", "collapseSelectionToMax", "collapseSelectionToEnd", "undo", "redo", "editUntransformedTextAsUser", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "Lkotlin/ExtensionFunctionType;", "updateWedgeAffinity", "mapToTransformed", TypedValues.CycleType.S_WAVE_OFFSET, "mapToTransformed--jx7JFs", "(I)J", "mapToTransformed-GEjPoXI", "(J)J", "mapFromTransformed", "mapFromTransformed--jx7JFs", "mapFromTransformed-GEjPoXI", "collectImeNotifications", "", "notifyImeListener", "Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "(Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "other", "hashCode", "toString", "", "TransformedText", "Companion", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TransformedTextFieldState {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion(null);
    private final CodepointTransformation codepointTransformation;
    private final State<TransformedText> codepointTransformedText;
    private InputTransformation inputTransformation;
    private final OutputTransformation outputTransformation;
    private final State<TransformedText> outputTransformedText;
    private final MutableState selectionWedgeAffinity$delegate;
    private final TextFieldState textFieldState;

    @JvmStatic
    private static final TransformedText calculateTransformedText(TextFieldCharSequence textFieldCharSequence, OutputTransformation outputTransformation, SelectionWedgeAffinity selectionWedgeAffinity) {
        return Companion.calculateTransformedText(textFieldCharSequence, outputTransformation, selectionWedgeAffinity);
    }

    @JvmStatic
    private static final TransformedText calculateTransformedText(TextFieldCharSequence textFieldCharSequence, CodepointTransformation codepointTransformation, SelectionWedgeAffinity selectionWedgeAffinity) {
        return Companion.calculateTransformedText(textFieldCharSequence, codepointTransformation, selectionWedgeAffinity);
    }

    @JvmStatic
    /* renamed from: mapFromTransformed-xdX6-G0  reason: not valid java name */
    private static final long m1889mapFromTransformedxdX6G0(long j, OffsetMappingCalculator offsetMappingCalculator) {
        return Companion.m1903mapFromTransformedxdX6G0(j, offsetMappingCalculator);
    }

    @JvmStatic
    /* renamed from: mapToTransformed-XGyztTk  reason: not valid java name */
    private static final long m1890mapToTransformedXGyztTk(long j, OffsetMappingCalculator offsetMappingCalculator, SelectionWedgeAffinity selectionWedgeAffinity) {
        return Companion.m1904mapToTransformedXGyztTk(j, offsetMappingCalculator, selectionWedgeAffinity);
    }

    public TransformedTextFieldState(TextFieldState textFieldState, InputTransformation inputTransformation, final CodepointTransformation codepointTransformation, final OutputTransformation outputTransformation) {
        MutableState mutableStateOf$default;
        this.textFieldState = textFieldState;
        this.inputTransformation = inputTransformation;
        this.codepointTransformation = codepointTransformation;
        this.outputTransformation = outputTransformation;
        this.outputTransformedText = outputTransformation != null ? SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.input.internal.TransformedTextFieldState$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                TransformedTextFieldState.TransformedText outputTransformedText$lambda$0$0;
                outputTransformedText$lambda$0$0 = TransformedTextFieldState.outputTransformedText$lambda$0$0(TransformedTextFieldState.this, outputTransformation);
                return outputTransformedText$lambda$0$0;
            }
        }) : null;
        this.codepointTransformedText = codepointTransformation != null ? SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.input.internal.TransformedTextFieldState$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                TransformedTextFieldState.TransformedText codepointTransformedText$lambda$0$0;
                codepointTransformedText$lambda$0$0 = TransformedTextFieldState.codepointTransformedText$lambda$0$0(TransformedTextFieldState.this, codepointTransformation);
                return codepointTransformedText$lambda$0$0;
            }
        }) : null;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new SelectionWedgeAffinity(WedgeAffinity.Start), null, 2, null);
        this.selectionWedgeAffinity$delegate = mutableStateOf$default;
    }

    public /* synthetic */ TransformedTextFieldState(TextFieldState textFieldState, InputTransformation inputTransformation, CodepointTransformation codepointTransformation, OutputTransformation outputTransformation, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textFieldState, (i & 2) != 0 ? null : inputTransformation, (i & 4) != 0 ? null : codepointTransformation, (i & 8) != 0 ? null : outputTransformation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TransformedText outputTransformedText$lambda$0$0(TransformedTextFieldState transformedTextFieldState, OutputTransformation outputTransformation) {
        return Companion.calculateTransformedText(transformedTextFieldState.textFieldState.getValue$foundation(), outputTransformation, transformedTextFieldState.getSelectionWedgeAffinity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TransformedText codepointTransformedText$lambda$0$0(TransformedTextFieldState transformedTextFieldState, CodepointTransformation codepointTransformation) {
        TextFieldCharSequence value$foundation;
        TransformedText value;
        Companion companion = Companion;
        State<TransformedText> state = transformedTextFieldState.outputTransformedText;
        if (state == null || (value = state.getValue()) == null || (value$foundation = value.getText()) == null) {
            value$foundation = transformedTextFieldState.textFieldState.getValue$foundation();
        }
        return companion.calculateTransformedText(value$foundation, codepointTransformation, transformedTextFieldState.getSelectionWedgeAffinity());
    }

    public final TextFieldCharSequence getUntransformedText() {
        return this.textFieldState.getValue$foundation();
    }

    /* renamed from: getUntransformedComposition-MzsxiRA  reason: not valid java name */
    public final TextRange m1892getUntransformedCompositionMzsxiRA() {
        return this.textFieldState.m1725getCompositionMzsxiRA();
    }

    public final boolean getUserCommit() {
        return this.textFieldState.getUserCommit$foundation();
    }

    public final TextFieldCharSequence getOutputText() {
        TransformedText value;
        TextFieldCharSequence text;
        State<TransformedText> state = this.outputTransformedText;
        return (state == null || (value = state.getValue()) == null || (text = value.getText()) == null) ? getUntransformedText() : text;
    }

    public final TextFieldCharSequence getVisualText() {
        TransformedText value;
        TextFieldCharSequence text;
        State<TransformedText> state = this.codepointTransformedText;
        return (state == null || (value = state.getValue()) == null || (text = value.getText()) == null) ? getOutputText() : text;
    }

    public final boolean isTransformed() {
        return (this.outputTransformation == null && this.codepointTransformation == null) ? false : true;
    }

    public final SelectionWedgeAffinity getSelectionWedgeAffinity() {
        return (SelectionWedgeAffinity) this.selectionWedgeAffinity$delegate.getValue();
    }

    public final void setSelectionWedgeAffinity(SelectionWedgeAffinity selectionWedgeAffinity) {
        this.selectionWedgeAffinity$delegate.setValue(selectionWedgeAffinity);
    }

    public final void update(InputTransformation inputTransformation) {
        this.inputTransformation = inputTransformation;
    }

    public final void placeCursorBeforeCharAt(int i) {
        m1899selectCharsIn5zctL8(TextRangeKt.TextRange(i));
    }

    /* renamed from: selectCharsIn-5zc-tL8  reason: not valid java name */
    public final void m1899selectCharsIn5zctL8(long j) {
        m1900selectUntransformedCharsIn5zctL8(m1895mapFromTransformedGEjPoXI(j));
    }

    /* renamed from: selectUntransformedCharsIn-5zc-tL8  reason: not valid java name */
    public final void m1900selectUntransformedCharsIn5zctL8(long j) {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBufferKt.setSelectionCoerced(textFieldState.getMainBuffer$foundation(), TextRange.m7608getStartimpl(j), TextRange.m7603getEndimpl(j));
        TextFieldState.access$commitEditAsUser(textFieldState, inputTransformation, true, textFieldEditUndoBehavior);
        TextFieldState.access$setUserCommit(textFieldState, true);
    }

    /* renamed from: highlightCharsIn-7RAjNK8  reason: not valid java name */
    public final void m1893highlightCharsIn7RAjNK8(int i, long j) {
        long m1895mapFromTransformedGEjPoXI = m1895mapFromTransformedGEjPoXI(j);
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        textFieldState.getMainBuffer$foundation().m1717setHighlightK7f2yys$foundation(i, TextRange.m7608getStartimpl(m1895mapFromTransformedGEjPoXI), TextRange.m7603getEndimpl(m1895mapFromTransformedGEjPoXI));
        TextFieldState.access$commitEditAsUser(textFieldState, inputTransformation, true, textFieldEditUndoBehavior);
        TextFieldState.access$setUserCommit(textFieldState, true);
    }

    public final void replaceAll(CharSequence charSequence) {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer mainBuffer$foundation = textFieldState.getMainBuffer$foundation();
        TextFieldBufferKt.delete(mainBuffer$foundation, 0, mainBuffer$foundation.getLength());
        mainBuffer$foundation.append(charSequence.toString());
        updateWedgeAffinity(mainBuffer$foundation);
        TextFieldState.access$commitEditAsUser(textFieldState, inputTransformation, true, textFieldEditUndoBehavior);
        TextFieldState.access$setUserCommit(textFieldState, true);
    }

    public final void selectAll() {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer mainBuffer$foundation = textFieldState.getMainBuffer$foundation();
        TextFieldBufferKt.setSelectionCoerced(mainBuffer$foundation, 0, mainBuffer$foundation.getLength());
        TextFieldState.access$commitEditAsUser(textFieldState, inputTransformation, true, textFieldEditUndoBehavior);
        TextFieldState.access$setUserCommit(textFieldState, true);
    }

    public final void deleteSelectedText() {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.NeverMerge;
        textFieldState.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer mainBuffer$foundation = textFieldState.getMainBuffer$foundation();
        TextFieldBufferKt.delete(mainBuffer$foundation, TextRange.m7606getMinimpl(mainBuffer$foundation.m1716getSelectiond9O1mEE()), TextRange.m7605getMaximpl(mainBuffer$foundation.m1716getSelectiond9O1mEE()));
        TextFieldBufferKt.setSelectionCoerced$default(mainBuffer$foundation, TextRange.m7606getMinimpl(mainBuffer$foundation.m1716getSelectiond9O1mEE()), 0, 2, null);
        updateWedgeAffinity(mainBuffer$foundation);
        TextFieldState.access$commitEditAsUser(textFieldState, inputTransformation, true, textFieldEditUndoBehavior);
        TextFieldState.access$setUserCommit(textFieldState, true);
    }

    /* renamed from: replaceText-M8tDOmk$default  reason: not valid java name */
    public static /* synthetic */ void m1891replaceTextM8tDOmk$default(TransformedTextFieldState transformedTextFieldState, CharSequence charSequence, long j, TextFieldEditUndoBehavior textFieldEditUndoBehavior, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        TextFieldEditUndoBehavior textFieldEditUndoBehavior2 = textFieldEditUndoBehavior;
        if ((i & 8) != 0) {
            z = true;
        }
        transformedTextFieldState.m1898replaceTextM8tDOmk(charSequence, j, textFieldEditUndoBehavior2, z);
    }

    /* renamed from: replaceText-M8tDOmk  reason: not valid java name */
    public final void m1898replaceTextM8tDOmk(CharSequence charSequence, long j, TextFieldEditUndoBehavior textFieldEditUndoBehavior, boolean z) {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        textFieldState.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer mainBuffer$foundation = textFieldState.getMainBuffer$foundation();
        long m1895mapFromTransformedGEjPoXI = m1895mapFromTransformedGEjPoXI(j);
        mainBuffer$foundation.replace(TextRange.m7606getMinimpl(m1895mapFromTransformedGEjPoXI), TextRange.m7605getMaximpl(m1895mapFromTransformedGEjPoXI), charSequence);
        TextFieldBufferKt.setSelectionCoerced$default(mainBuffer$foundation, TextRange.m7606getMinimpl(m1895mapFromTransformedGEjPoXI) + charSequence.length(), 0, 2, null);
        updateWedgeAffinity(mainBuffer$foundation);
        TextFieldState.access$commitEditAsUser(textFieldState, inputTransformation, z, textFieldEditUndoBehavior);
        TextFieldState.access$setUserCommit(textFieldState, true);
    }

    public static /* synthetic */ void replaceSelectedText$default(TransformedTextFieldState transformedTextFieldState, CharSequence charSequence, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        transformedTextFieldState.replaceSelectedText(charSequence, z, textFieldEditUndoBehavior, z2);
    }

    public final void replaceSelectedText(CharSequence charSequence, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior, boolean z2) {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        textFieldState.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer mainBuffer$foundation = textFieldState.getMainBuffer$foundation();
        if (z) {
            mainBuffer$foundation.commitComposition$foundation();
        }
        long m1716getSelectiond9O1mEE = mainBuffer$foundation.m1716getSelectiond9O1mEE();
        mainBuffer$foundation.replace(TextRange.m7606getMinimpl(m1716getSelectiond9O1mEE), TextRange.m7605getMaximpl(m1716getSelectiond9O1mEE), charSequence);
        TextFieldBufferKt.setSelectionCoerced$default(mainBuffer$foundation, TextRange.m7606getMinimpl(m1716getSelectiond9O1mEE) + charSequence.length(), 0, 2, null);
        updateWedgeAffinity(mainBuffer$foundation);
        TextFieldState.access$commitEditAsUser(textFieldState, inputTransformation, z2, textFieldEditUndoBehavior);
        TextFieldState.access$setUserCommit(textFieldState, true);
    }

    public final void collapseSelectionToMax() {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer mainBuffer$foundation = textFieldState.getMainBuffer$foundation();
        TextFieldBufferKt.setSelectionCoerced$default(mainBuffer$foundation, TextRange.m7605getMaximpl(mainBuffer$foundation.m1716getSelectiond9O1mEE()), 0, 2, null);
        TextFieldState.access$commitEditAsUser(textFieldState, inputTransformation, true, textFieldEditUndoBehavior);
        TextFieldState.access$setUserCommit(textFieldState, true);
    }

    public final void collapseSelectionToEnd() {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer mainBuffer$foundation = textFieldState.getMainBuffer$foundation();
        TextFieldBufferKt.setSelectionCoerced$default(mainBuffer$foundation, TextRange.m7603getEndimpl(mainBuffer$foundation.m1716getSelectiond9O1mEE()), 0, 2, null);
        TextFieldState.access$commitEditAsUser(textFieldState, inputTransformation, true, textFieldEditUndoBehavior);
        TextFieldState.access$setUserCommit(textFieldState, true);
    }

    public final void undo() {
        this.textFieldState.getUndoState().undo();
    }

    public final void redo() {
        this.textFieldState.getUndoState().redo();
    }

    public static /* synthetic */ void editUntransformedTextAsUser$default(TransformedTextFieldState transformedTextFieldState, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        TextFieldState textFieldState = transformedTextFieldState.textFieldState;
        InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer mainBuffer$foundation = textFieldState.getMainBuffer$foundation();
        function1.invoke(mainBuffer$foundation);
        transformedTextFieldState.updateWedgeAffinity(mainBuffer$foundation);
        TextFieldState.access$commitEditAsUser(textFieldState, inputTransformation, z, textFieldEditUndoBehavior);
        TextFieldState.access$setUserCommit(textFieldState, true);
    }

    public final void editUntransformedTextAsUser(boolean z, Function1<? super TextFieldBuffer, Unit> function1) {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer mainBuffer$foundation = textFieldState.getMainBuffer$foundation();
        function1.invoke(mainBuffer$foundation);
        updateWedgeAffinity(mainBuffer$foundation);
        TextFieldState.access$commitEditAsUser(textFieldState, inputTransformation, z, textFieldEditUndoBehavior);
        TextFieldState.access$setUserCommit(textFieldState, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateWedgeAffinity(TextFieldBuffer textFieldBuffer) {
        if (textFieldBuffer.getChangeTracker$foundation().getChangeCount() <= 0 || !TextRange.m7602getCollapsedimpl(textFieldBuffer.m1716getSelectiond9O1mEE())) {
            return;
        }
        setSelectionWedgeAffinity(new SelectionWedgeAffinity(WedgeAffinity.Start));
    }

    /* renamed from: mapToTransformed--jx7JFs  reason: not valid java name */
    public final long m1896mapToTransformedjx7JFs(int i) {
        TransformedText value;
        TransformedText value2;
        State<TransformedText> state = this.outputTransformedText;
        OffsetMappingCalculator offsetMappingCalculator = null;
        OffsetMappingCalculator offsetMapping = (state == null || (value2 = state.getValue()) == null) ? null : value2.getOffsetMapping();
        State<TransformedText> state2 = this.codepointTransformedText;
        if (state2 != null && (value = state2.getValue()) != null) {
            offsetMappingCalculator = value.getOffsetMapping();
        }
        long m1841mapFromSourcejx7JFs = offsetMapping != null ? offsetMapping.m1841mapFromSourcejx7JFs(i) : TextRangeKt.TextRange(i);
        return offsetMappingCalculator != null ? Companion.m1904mapToTransformedXGyztTk(m1841mapFromSourcejx7JFs, offsetMappingCalculator, getSelectionWedgeAffinity()) : m1841mapFromSourcejx7JFs;
    }

    /* renamed from: mapToTransformed-GEjPoXI  reason: not valid java name */
    public final long m1897mapToTransformedGEjPoXI(long j) {
        TransformedText value;
        TransformedText value2;
        State<TransformedText> state = this.outputTransformedText;
        OffsetMappingCalculator offsetMappingCalculator = null;
        OffsetMappingCalculator offsetMapping = (state == null || (value2 = state.getValue()) == null) ? null : value2.getOffsetMapping();
        State<TransformedText> state2 = this.codepointTransformedText;
        if (state2 != null && (value = state2.getValue()) != null) {
            offsetMappingCalculator = value.getOffsetMapping();
        }
        if (offsetMapping != null) {
            j = Companion.m1905mapToTransformedXGyztTk$default(Companion, j, offsetMapping, null, 4, null);
        }
        return offsetMappingCalculator != null ? Companion.m1904mapToTransformedXGyztTk(j, offsetMappingCalculator, getSelectionWedgeAffinity()) : j;
    }

    /* renamed from: mapFromTransformed--jx7JFs  reason: not valid java name */
    public final long m1894mapFromTransformedjx7JFs(int i) {
        TransformedText value;
        TransformedText value2;
        State<TransformedText> state = this.outputTransformedText;
        OffsetMappingCalculator offsetMappingCalculator = null;
        OffsetMappingCalculator offsetMapping = (state == null || (value2 = state.getValue()) == null) ? null : value2.getOffsetMapping();
        State<TransformedText> state2 = this.codepointTransformedText;
        if (state2 != null && (value = state2.getValue()) != null) {
            offsetMappingCalculator = value.getOffsetMapping();
        }
        long m1840mapFromDestjx7JFs = offsetMappingCalculator != null ? offsetMappingCalculator.m1840mapFromDestjx7JFs(i) : TextRangeKt.TextRange(i);
        return offsetMapping != null ? Companion.m1903mapFromTransformedxdX6G0(m1840mapFromDestjx7JFs, offsetMapping) : m1840mapFromDestjx7JFs;
    }

    /* renamed from: mapFromTransformed-GEjPoXI  reason: not valid java name */
    public final long m1895mapFromTransformedGEjPoXI(long j) {
        TransformedText value;
        TransformedText value2;
        State<TransformedText> state = this.outputTransformedText;
        OffsetMappingCalculator offsetMappingCalculator = null;
        OffsetMappingCalculator offsetMapping = (state == null || (value2 = state.getValue()) == null) ? null : value2.getOffsetMapping();
        State<TransformedText> state2 = this.codepointTransformedText;
        if (state2 != null && (value = state2.getValue()) != null) {
            offsetMappingCalculator = value.getOffsetMapping();
        }
        if (offsetMappingCalculator != null) {
            j = Companion.m1903mapFromTransformedxdX6G0(j, offsetMappingCalculator);
        }
        return offsetMapping != null ? Companion.m1903mapFromTransformedxdX6G0(j, offsetMapping) : j;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object collectImeNotifications(final TextFieldState.NotifyImeListener notifyImeListener, Continuation<?> continuation) {
        TransformedTextFieldState$collectImeNotifications$1 transformedTextFieldState$collectImeNotifications$1;
        int i;
        if (continuation instanceof TransformedTextFieldState$collectImeNotifications$1) {
            transformedTextFieldState$collectImeNotifications$1 = (TransformedTextFieldState$collectImeNotifications$1) continuation;
            if ((transformedTextFieldState$collectImeNotifications$1.label & Integer.MIN_VALUE) != 0) {
                transformedTextFieldState$collectImeNotifications$1.label -= Integer.MIN_VALUE;
                Object obj = transformedTextFieldState$collectImeNotifications$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = transformedTextFieldState$collectImeNotifications$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.outputTransformation != null) {
                        notifyImeListener = new TextFieldState.NotifyImeListener() { // from class: androidx.compose.foundation.text.input.internal.TransformedTextFieldState$$ExternalSyntheticLambda0
                            @Override // androidx.compose.foundation.text.input.TextFieldState.NotifyImeListener
                            public final void onChange(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, boolean z) {
                                TransformedTextFieldState.collectImeNotifications$lambda$0(TextFieldState.NotifyImeListener.this, this, textFieldCharSequence, textFieldCharSequence2, z);
                            }
                        };
                    }
                    transformedTextFieldState$collectImeNotifications$1.L$0 = notifyImeListener;
                    transformedTextFieldState$collectImeNotifications$1.label = 1;
                    TransformedTextFieldState$collectImeNotifications$1 transformedTextFieldState$collectImeNotifications$12 = transformedTextFieldState$collectImeNotifications$1;
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(transformedTextFieldState$collectImeNotifications$12), 1);
                    cancellableContinuationImpl.initCancellability();
                    this.textFieldState.addNotifyImeListener$foundation(notifyImeListener);
                    cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$2$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th) {
                            TransformedTextFieldState.this.textFieldState.removeNotifyImeListener$foundation(notifyImeListener);
                        }
                    });
                    Object result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(transformedTextFieldState$collectImeNotifications$12);
                    }
                    if (result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    TextFieldState.NotifyImeListener notifyImeListener2 = (TextFieldState.NotifyImeListener) transformedTextFieldState$collectImeNotifications$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }
        transformedTextFieldState$collectImeNotifications$1 = new TransformedTextFieldState$collectImeNotifications$1(this, continuation);
        Object obj2 = transformedTextFieldState$collectImeNotifications$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = transformedTextFieldState$collectImeNotifications$1.label;
        if (i != 0) {
        }
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void collectImeNotifications$lambda$0(TextFieldState.NotifyImeListener notifyImeListener, TransformedTextFieldState transformedTextFieldState, TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, boolean z) {
        TextFieldCharSequence text;
        TransformedText calculateTransformedText = Companion.calculateTransformedText(textFieldCharSequence, transformedTextFieldState.outputTransformation, transformedTextFieldState.getSelectionWedgeAffinity());
        if (calculateTransformedText != null && (text = calculateTransformedText.getText()) != null) {
            textFieldCharSequence = text;
        }
        notifyImeListener.onChange(textFieldCharSequence, transformedTextFieldState.getVisualText(), z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TransformedTextFieldState) {
            TransformedTextFieldState transformedTextFieldState = (TransformedTextFieldState) obj;
            if (Intrinsics.areEqual(this.textFieldState, transformedTextFieldState.textFieldState) && Intrinsics.areEqual(this.codepointTransformation, transformedTextFieldState.codepointTransformation)) {
                return Intrinsics.areEqual(this.outputTransformation, transformedTextFieldState.outputTransformation);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.textFieldState.hashCode() * 31;
        CodepointTransformation codepointTransformation = this.codepointTransformation;
        int hashCode2 = (hashCode + (codepointTransformation != null ? codepointTransformation.hashCode() : 0)) * 31;
        OutputTransformation outputTransformation = this.outputTransformation;
        return hashCode2 + (outputTransformation != null ? outputTransformation.hashCode() : 0);
    }

    public String toString() {
        return "TransformedTextFieldState(textFieldState=" + this.textFieldState + ", outputTransformation=" + this.outputTransformation + ", outputTransformedText=" + this.outputTransformedText + ", codepointTransformation=" + this.codepointTransformation + ", codepointTransformedText=" + this.codepointTransformedText + ", outputText=\"" + ((Object) getOutputText()) + "\", visualText=\"" + ((Object) getVisualText()) + "\")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TransformedTextFieldState.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "", "text", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "offsetMapping", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "<init>", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)V", "getText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getOffsetMapping", "()Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class TransformedText {
        private final OffsetMappingCalculator offsetMapping;
        private final TextFieldCharSequence text;

        public static /* synthetic */ TransformedText copy$default(TransformedText transformedText, TextFieldCharSequence textFieldCharSequence, OffsetMappingCalculator offsetMappingCalculator, int i, Object obj) {
            if ((i & 1) != 0) {
                textFieldCharSequence = transformedText.text;
            }
            if ((i & 2) != 0) {
                offsetMappingCalculator = transformedText.offsetMapping;
            }
            return transformedText.copy(textFieldCharSequence, offsetMappingCalculator);
        }

        public final TextFieldCharSequence component1() {
            return this.text;
        }

        public final OffsetMappingCalculator component2() {
            return this.offsetMapping;
        }

        public final TransformedText copy(TextFieldCharSequence textFieldCharSequence, OffsetMappingCalculator offsetMappingCalculator) {
            return new TransformedText(textFieldCharSequence, offsetMappingCalculator);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TransformedText) {
                TransformedText transformedText = (TransformedText) obj;
                return Intrinsics.areEqual(this.text, transformedText.text) && Intrinsics.areEqual(this.offsetMapping, transformedText.offsetMapping);
            }
            return false;
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + this.offsetMapping.hashCode();
        }

        public String toString() {
            return "TransformedText(text=" + ((Object) this.text) + ", offsetMapping=" + this.offsetMapping + ')';
        }

        public TransformedText(TextFieldCharSequence textFieldCharSequence, OffsetMappingCalculator offsetMappingCalculator) {
            this.text = textFieldCharSequence;
            this.offsetMapping = offsetMappingCalculator;
        }

        public final TextFieldCharSequence getText() {
            return this.text;
        }

        public final OffsetMappingCalculator getOffsetMapping() {
            return this.offsetMapping;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TransformedTextFieldState.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0003J+\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0003¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$Companion;", "", "<init>", "()V", "calculateTransformedText", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "untransformedValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "wedgeAffinity", "Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "mapToTransformed", "Landroidx/compose/ui/text/TextRange;", "range", "mapping", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "selectionWedgeAffinity", "mapToTransformed-XGyztTk", "(JLandroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;)J", "mapFromTransformed", "mapFromTransformed-xdX6-G0", "(JLandroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)J", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {

        /* compiled from: TransformedTextFieldState.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[WedgeAffinity.values().length];
                try {
                    iArr[WedgeAffinity.Start.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[WedgeAffinity.End.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final TransformedText calculateTransformedText(TextFieldCharSequence textFieldCharSequence, OutputTransformation outputTransformation, SelectionWedgeAffinity selectionWedgeAffinity) {
            List<AnnotatedString.Range<AnnotatedString.Annotation>> list;
            OffsetMappingCalculator offsetMappingCalculator = new OffsetMappingCalculator();
            TextFieldBuffer textFieldBuffer = new TextFieldBuffer(textFieldCharSequence, null, null, offsetMappingCalculator, 6, null);
            textFieldBuffer.setCanCallAddStyle$foundation(true);
            outputTransformation.transformOutput(textFieldBuffer);
            textFieldBuffer.setCanCallAddStyle$foundation(false);
            List<AnnotatedString.Range<AnnotatedString.Annotation>> outputTransformationAnnotations$foundation = textFieldBuffer.getOutputTransformationAnnotations$foundation();
            if (textFieldBuffer.getChanges().getChangeCount() == 0 && ((list = outputTransformationAnnotations$foundation) == null || list.isEmpty())) {
                return null;
            }
            long m1904mapToTransformedXGyztTk = m1904mapToTransformedXGyztTk(textFieldCharSequence.m1724getSelectiond9O1mEE(), offsetMappingCalculator, selectionWedgeAffinity);
            TextRange m1723getCompositionMzsxiRA = textFieldCharSequence.m1723getCompositionMzsxiRA();
            return new TransformedText(TextFieldBuffer.m1713toTextFieldCharSequencewFTz33Y$foundation$default(textFieldBuffer, m1904mapToTransformedXGyztTk, m1723getCompositionMzsxiRA != null ? TextRange.m7596boximpl(TransformedTextFieldState.Companion.m1904mapToTransformedXGyztTk(m1723getCompositionMzsxiRA.m7612unboximpl(), offsetMappingCalculator, selectionWedgeAffinity)) : null, null, outputTransformationAnnotations$foundation, 4, null), offsetMappingCalculator);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final TransformedText calculateTransformedText(TextFieldCharSequence textFieldCharSequence, CodepointTransformation codepointTransformation, SelectionWedgeAffinity selectionWedgeAffinity) {
            OffsetMappingCalculator offsetMappingCalculator = new OffsetMappingCalculator();
            CharSequence visualText = CodepointTransformationKt.toVisualText(textFieldCharSequence, codepointTransformation, offsetMappingCalculator);
            TextRange textRange = null;
            if (visualText == textFieldCharSequence) {
                return null;
            }
            long m1904mapToTransformedXGyztTk = m1904mapToTransformedXGyztTk(textFieldCharSequence.m1724getSelectiond9O1mEE(), offsetMappingCalculator, selectionWedgeAffinity);
            TextRange m1723getCompositionMzsxiRA = textFieldCharSequence.m1723getCompositionMzsxiRA();
            if (m1723getCompositionMzsxiRA != null) {
                textRange = TextRange.m7596boximpl(TransformedTextFieldState.Companion.m1904mapToTransformedXGyztTk(m1723getCompositionMzsxiRA.m7612unboximpl(), offsetMappingCalculator, selectionWedgeAffinity));
            }
            return new TransformedText(new TextFieldCharSequence(visualText, m1904mapToTransformedXGyztTk, textRange, null, null, null, 56, null), offsetMappingCalculator);
        }

        /* renamed from: mapToTransformed-XGyztTk$default  reason: not valid java name */
        static /* synthetic */ long m1905mapToTransformedXGyztTk$default(Companion companion, long j, OffsetMappingCalculator offsetMappingCalculator, SelectionWedgeAffinity selectionWedgeAffinity, int i, Object obj) {
            if ((i & 4) != 0) {
                selectionWedgeAffinity = null;
            }
            return companion.m1904mapToTransformedXGyztTk(j, offsetMappingCalculator, selectionWedgeAffinity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        /* renamed from: mapToTransformed-XGyztTk  reason: not valid java name */
        public final long m1904mapToTransformedXGyztTk(long j, OffsetMappingCalculator offsetMappingCalculator, SelectionWedgeAffinity selectionWedgeAffinity) {
            long TextRange;
            long m1841mapFromSourcejx7JFs = offsetMappingCalculator.m1841mapFromSourcejx7JFs(TextRange.m7608getStartimpl(j));
            long m1841mapFromSourcejx7JFs2 = TextRange.m7602getCollapsedimpl(j) ? m1841mapFromSourcejx7JFs : offsetMappingCalculator.m1841mapFromSourcejx7JFs(TextRange.m7603getEndimpl(j));
            WedgeAffinity wedgeAffinity = null;
            WedgeAffinity startAffinity = selectionWedgeAffinity != null ? selectionWedgeAffinity.getStartAffinity() : null;
            if (TextRange.m7602getCollapsedimpl(j)) {
                wedgeAffinity = startAffinity;
            } else if (selectionWedgeAffinity != null) {
                wedgeAffinity = selectionWedgeAffinity.getEndAffinity();
            }
            if (startAffinity != null && !TextRange.m7602getCollapsedimpl(m1841mapFromSourcejx7JFs)) {
                int i = WhenMappings.$EnumSwitchMapping$0[startAffinity.ordinal()];
                if (i == 1) {
                    m1841mapFromSourcejx7JFs = TextRangeKt.TextRange(TextRange.m7608getStartimpl(m1841mapFromSourcejx7JFs));
                } else if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    m1841mapFromSourcejx7JFs = TextRangeKt.TextRange(TextRange.m7603getEndimpl(m1841mapFromSourcejx7JFs));
                }
            }
            if (wedgeAffinity != null && !TextRange.m7602getCollapsedimpl(m1841mapFromSourcejx7JFs2)) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[wedgeAffinity.ordinal()];
                if (i2 == 1) {
                    TextRange = TextRangeKt.TextRange(TextRange.m7608getStartimpl(m1841mapFromSourcejx7JFs2));
                } else if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    TextRange = TextRangeKt.TextRange(TextRange.m7603getEndimpl(m1841mapFromSourcejx7JFs2));
                }
                m1841mapFromSourcejx7JFs2 = TextRange;
            }
            int min = Math.min(TextRange.m7606getMinimpl(m1841mapFromSourcejx7JFs), TextRange.m7606getMinimpl(m1841mapFromSourcejx7JFs2));
            int max = Math.max(TextRange.m7605getMaximpl(m1841mapFromSourcejx7JFs), TextRange.m7605getMaximpl(m1841mapFromSourcejx7JFs2));
            if (TextRange.m7607getReversedimpl(j)) {
                return TextRangeKt.TextRange(max, min);
            }
            return TextRangeKt.TextRange(min, max);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        /* renamed from: mapFromTransformed-xdX6-G0  reason: not valid java name */
        public final long m1903mapFromTransformedxdX6G0(long j, OffsetMappingCalculator offsetMappingCalculator) {
            long m1840mapFromDestjx7JFs = offsetMappingCalculator.m1840mapFromDestjx7JFs(TextRange.m7608getStartimpl(j));
            long m1840mapFromDestjx7JFs2 = TextRange.m7602getCollapsedimpl(j) ? m1840mapFromDestjx7JFs : offsetMappingCalculator.m1840mapFromDestjx7JFs(TextRange.m7603getEndimpl(j));
            int min = Math.min(TextRange.m7606getMinimpl(m1840mapFromDestjx7JFs), TextRange.m7606getMinimpl(m1840mapFromDestjx7JFs2));
            int max = Math.max(TextRange.m7605getMaximpl(m1840mapFromDestjx7JFs), TextRange.m7605getMaximpl(m1840mapFromDestjx7JFs2));
            if (TextRange.m7607getReversedimpl(j)) {
                return TextRangeKt.TextRange(max, min);
            }
            return TextRangeKt.TextRange(min, max);
        }
    }
}
