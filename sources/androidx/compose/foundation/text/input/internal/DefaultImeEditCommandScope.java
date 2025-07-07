package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* compiled from: ImeEditCommand.android.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J!\u0010\u000f\u001a\u00020\u000b2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R%\u0010\u0007\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/text/input/internal/DefaultImeEditCommandScope;", "Landroidx/compose/foundation/text/input/internal/ImeEditCommandScope;", "transformedTextFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;)V", "batchDepth", "", "editCommands", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "", "Lkotlin/ExtensionFunctionType;", "beginBatchEdit", "", "edit", "block", "endBatchEdit", "mapFromTransformed", "Landroidx/compose/ui/text/TextRange;", "range", "mapFromTransformed-GEjPoXI", "(J)J", "mapToTransformed", "mapToTransformed-GEjPoXI", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DefaultImeEditCommandScope implements ImeEditCommandScope {
    public static final int $stable = 8;
    private int batchDepth;
    private final MutableVector<Function1<TextFieldBuffer, Unit>> editCommands = new MutableVector<>(new Function1[16], 0);
    private final TransformedTextFieldState transformedTextFieldState;

    public DefaultImeEditCommandScope(TransformedTextFieldState transformedTextFieldState) {
        this.transformedTextFieldState = transformedTextFieldState;
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    /* renamed from: mapFromTransformed-GEjPoXI */
    public long mo1233mapFromTransformedGEjPoXI(long j) {
        return this.transformedTextFieldState.m1332mapFromTransformedGEjPoXI(j);
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    /* renamed from: mapToTransformed-GEjPoXI */
    public long mo1234mapToTransformedGEjPoXI(long j) {
        return this.transformedTextFieldState.m1334mapToTransformedGEjPoXI(j);
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    public boolean beginBatchEdit() {
        this.batchDepth++;
        return true;
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    public void edit(Function1<? super TextFieldBuffer, Unit> function1) {
        beginBatchEdit();
        this.editCommands.add(function1);
        endBatchEdit();
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    public boolean endBatchEdit() {
        int i = this.batchDepth - 1;
        this.batchDepth = i;
        if (i == 0 && this.editCommands.getSize() != 0) {
            TransformedTextFieldState transformedTextFieldState = this.transformedTextFieldState;
            TextFieldState textFieldState = transformedTextFieldState.textFieldState;
            InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
            TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
            textFieldState.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
            TextFieldBuffer mainBuffer$foundation_release = textFieldState.getMainBuffer$foundation_release();
            MutableVector<Function1<TextFieldBuffer, Unit>> mutableVector = this.editCommands;
            Function1<TextFieldBuffer, Unit>[] function1Arr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i2 = 0; i2 < size; i2++) {
                function1Arr[i2].invoke(mainBuffer$foundation_release);
            }
            transformedTextFieldState.updateWedgeAffinity(mainBuffer$foundation_release);
            textFieldState.commitEditAsUser(inputTransformation, false, textFieldEditUndoBehavior);
            this.editCommands.clear();
        }
        return this.batchDepth > 0;
    }
}
