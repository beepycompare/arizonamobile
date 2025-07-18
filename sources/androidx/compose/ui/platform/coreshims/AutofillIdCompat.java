package androidx.compose.ui.platform.coreshims;

import android.view.autofill.AutofillId;
/* loaded from: classes2.dex */
public class AutofillIdCompat {
    private final Object mWrappedObj;

    private AutofillIdCompat(AutofillId autofillId) {
        this.mWrappedObj = autofillId;
    }

    public static AutofillIdCompat toAutofillIdCompat(AutofillId autofillId) {
        return new AutofillIdCompat(autofillId);
    }

    public AutofillId toAutofillId() {
        return (AutofillId) this.mWrappedObj;
    }
}
