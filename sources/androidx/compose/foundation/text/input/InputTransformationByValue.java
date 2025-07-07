package androidx.compose.foundation.text.input;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InputTransformation.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B=\u00126\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\tJ9\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003JC\u0010\r\u001a\u00020\u000028\b\u0002\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0018H\u0016RA\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/text/input/InputTransformationByValue;", "Landroidx/compose/foundation/text/input/InputTransformation;", "transformation", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "current", "proposed", "(Lkotlin/jvm/functions/Function2;)V", "getTransformation", "()Lkotlin/jvm/functions/Function2;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "transformInput", "", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
final class InputTransformationByValue implements InputTransformation {
    private final Function2<CharSequence, CharSequence, CharSequence> transformation;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InputTransformationByValue copy$default(InputTransformationByValue inputTransformationByValue, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = inputTransformationByValue.transformation;
        }
        return inputTransformationByValue.copy(function2);
    }

    public final Function2<CharSequence, CharSequence, CharSequence> component1() {
        return this.transformation;
    }

    public final InputTransformationByValue copy(Function2<? super CharSequence, ? super CharSequence, ? extends CharSequence> function2) {
        return new InputTransformationByValue(function2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof InputTransformationByValue) && Intrinsics.areEqual(this.transformation, ((InputTransformationByValue) obj).transformation);
    }

    public int hashCode() {
        return this.transformation.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InputTransformationByValue(Function2<? super CharSequence, ? super CharSequence, ? extends CharSequence> function2) {
        this.transformation = function2;
    }

    public final Function2<CharSequence, CharSequence, CharSequence> getTransformation() {
        return this.transformation;
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void transformInput(TextFieldBuffer textFieldBuffer) {
        TextFieldCharSequence m1192toTextFieldCharSequenceI88jaVs$foundation_release$default = TextFieldBuffer.m1192toTextFieldCharSequenceI88jaVs$foundation_release$default(textFieldBuffer, 0L, null, null, 7, null);
        CharSequence invoke = this.transformation.invoke(textFieldBuffer.getOriginalValue$foundation_release(), m1192toTextFieldCharSequenceI88jaVs$foundation_release$default);
        if (invoke == m1192toTextFieldCharSequenceI88jaVs$foundation_release$default) {
            return;
        }
        if (invoke == textFieldBuffer.getOriginalValue$foundation_release()) {
            textFieldBuffer.revertAllChanges();
        } else {
            textFieldBuffer.setTextIfChanged$foundation_release(invoke);
        }
    }

    public String toString() {
        return "InputTransformation.byValue(transformation=" + this.transformation + ')';
    }
}
