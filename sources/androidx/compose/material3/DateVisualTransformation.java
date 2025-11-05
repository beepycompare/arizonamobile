package androidx.compose.material3;

import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
/* compiled from: DateInput.kt */
@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u000b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/DateVisualTransformation;", "Landroidx/compose/ui/text/input/VisualTransformation;", "dateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "<init>", "(Landroidx/compose/material3/internal/DateInputFormat;)V", "firstDelimiterOffset", "", "secondDelimiterOffset", "dateFormatLength", "dateOffsetTranslator", "androidx/compose/material3/DateVisualTransformation$dateOffsetTranslator$1", "Landroidx/compose/material3/DateVisualTransformation$dateOffsetTranslator$1;", "filter", "Landroidx/compose/ui/text/input/TransformedText;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class DateVisualTransformation implements VisualTransformation {
    private final int dateFormatLength;
    private final DateInputFormat dateInputFormat;
    private final DateVisualTransformation$dateOffsetTranslator$1 dateOffsetTranslator = new OffsetMapping() { // from class: androidx.compose.material3.DateVisualTransformation$dateOffsetTranslator$1
        @Override // androidx.compose.ui.text.input.OffsetMapping
        public int originalToTransformed(int i) {
            int i2;
            int i3;
            int i4;
            int i5;
            i2 = DateVisualTransformation.this.firstDelimiterOffset;
            if (i < i2) {
                return i;
            }
            i3 = DateVisualTransformation.this.secondDelimiterOffset;
            if (i < i3) {
                return i + 1;
            }
            i4 = DateVisualTransformation.this.dateFormatLength;
            if (i <= i4) {
                return i + 2;
            }
            i5 = DateVisualTransformation.this.dateFormatLength;
            return i5 + 2;
        }

        @Override // androidx.compose.ui.text.input.OffsetMapping
        public int transformedToOriginal(int i) {
            int i2;
            int i3;
            int i4;
            int i5;
            i2 = DateVisualTransformation.this.firstDelimiterOffset;
            if (i <= i2 - 1) {
                return i;
            }
            i3 = DateVisualTransformation.this.secondDelimiterOffset;
            if (i <= i3 - 1) {
                return i - 1;
            }
            i4 = DateVisualTransformation.this.dateFormatLength;
            if (i <= i4 + 1) {
                return i - 2;
            }
            i5 = DateVisualTransformation.this.dateFormatLength;
            return i5;
        }
    };
    private final int firstDelimiterOffset;
    private final int secondDelimiterOffset;

    /* JADX WARN: Type inference failed for: r8v3, types: [androidx.compose.material3.DateVisualTransformation$dateOffsetTranslator$1] */
    public DateVisualTransformation(DateInputFormat dateInputFormat) {
        this.dateInputFormat = dateInputFormat;
        this.firstDelimiterOffset = StringsKt.indexOf$default((CharSequence) dateInputFormat.getPatternWithDelimiters(), dateInputFormat.getDelimiter(), 0, false, 6, (Object) null);
        this.secondDelimiterOffset = StringsKt.lastIndexOf$default((CharSequence) dateInputFormat.getPatternWithDelimiters(), dateInputFormat.getDelimiter(), 0, false, 6, (Object) null);
        this.dateFormatLength = dateInputFormat.getPatternWithoutDelimiters().length();
    }

    @Override // androidx.compose.ui.text.input.VisualTransformation
    public TransformedText filter(AnnotatedString annotatedString) {
        String text;
        int i = 0;
        if (annotatedString.getText().length() > this.dateFormatLength) {
            text = StringsKt.substring(annotatedString.getText(), RangesKt.until(0, this.dateFormatLength));
        } else {
            text = annotatedString.getText();
        }
        String str = text;
        String str2 = "";
        int i2 = 0;
        while (i < str.length()) {
            int i3 = i2 + 1;
            str2 = str2 + str.charAt(i);
            if (i3 == this.firstDelimiterOffset || i2 + 2 == this.secondDelimiterOffset) {
                str2 = str2 + this.dateInputFormat.getDelimiter();
            }
            i++;
            i2 = i3;
        }
        return new TransformedText(new AnnotatedString(str2, null, 2, null), this.dateOffsetTranslator);
    }
}
