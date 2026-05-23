package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.StringsHelpers_jvmAndAndroidKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
/* compiled from: CodepointTransformation.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001\u001a\u001c\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0000¨\u0006\u000b"}, d2 = {"mask", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation$Companion;", FirebaseAnalytics.Param.CHARACTER, "", "toVisualText", "", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "codepointTransformation", "offsetMappingCalculator", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CodepointTransformationKt {
    public static final CodepointTransformation mask(CodepointTransformation.Companion companion, char c) {
        return new MaskCodepointTransformation(c);
    }

    public static final CharSequence toVisualText(TextFieldCharSequence textFieldCharSequence, CodepointTransformation codepointTransformation, OffsetMappingCalculator offsetMappingCalculator) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        boolean z = false;
        int i2 = 0;
        while (i < textFieldCharSequence.length()) {
            int codePointAt = CodepointHelpers_jvmAndAndroidKt.codePointAt(textFieldCharSequence, i);
            int transform = codepointTransformation.transform(i2, codePointAt);
            int charCount = CodepointHelpers_jvmAndAndroidKt.charCount(codePointAt);
            if (transform != codePointAt) {
                offsetMappingCalculator.recordEditOperation(sb.length(), sb.length() + charCount, CodepointHelpers_jvmAndAndroidKt.charCount(transform));
                z = true;
            }
            StringsHelpers_jvmAndAndroidKt.appendCodePointX(sb, transform);
            i += charCount;
            i2++;
        }
        return z ? sb.toString() : textFieldCharSequence;
    }
}
