package ru.mrlargha.commonui.utils.ui;

import android.text.Editable;
import android.widget.EditText;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: EditTextValidationBuilder.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\tJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\tJ\u0006\u0010\u001f\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Lru/mrlargha/commonui/utils/ui/EditTextValidationBuilder;", "", "editText", "Landroid/widget/EditText;", "<init>", "(Landroid/widget/EditText;)V", "isCheckEmptyField", "", "value", "", "maxInputCount", "getMaxInputCount", "()J", "minInputCount", "getMinInputCount", "updateValue", "getUpdateValue", "()Ljava/lang/Long;", "setUpdateValue", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "Lru/mrlargha/commonui/utils/ui/EditeTextValidationErrorType;", "currentValidationErrorType", "getCurrentValidationErrorType", "()Lru/mrlargha/commonui/utils/ui/EditeTextValidationErrorType;", "checkEmptyList", "isCheck", "setMaxInputCount", "maxValue", "setMinInputCount", "minValue", "checkValidationField", "Companion", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class EditTextValidationBuilder {
    public static final Companion Companion = new Companion(null);
    public static final long MIN_INPUT_VALUE = 0;
    private EditeTextValidationErrorType currentValidationErrorType;
    private final EditText editText;
    private boolean isCheckEmptyField;
    private long maxInputCount;
    private long minInputCount;
    private Long updateValue;

    public EditTextValidationBuilder(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        this.editText = editText;
        this.maxInputCount = Long.MAX_VALUE;
        this.currentValidationErrorType = EditeTextValidationErrorType.SUCCESSFUL;
    }

    public final long getMaxInputCount() {
        return this.maxInputCount;
    }

    public final long getMinInputCount() {
        return this.minInputCount;
    }

    public final Long getUpdateValue() {
        return this.updateValue;
    }

    public final void setUpdateValue(Long l) {
        this.updateValue = l;
    }

    public final EditeTextValidationErrorType getCurrentValidationErrorType() {
        return this.currentValidationErrorType;
    }

    public static /* synthetic */ EditTextValidationBuilder checkEmptyList$default(EditTextValidationBuilder editTextValidationBuilder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return editTextValidationBuilder.checkEmptyList(z);
    }

    public final EditTextValidationBuilder checkEmptyList(boolean z) {
        this.isCheckEmptyField = z;
        return this;
    }

    public final EditTextValidationBuilder setMaxInputCount(long j) {
        this.maxInputCount = j;
        return this;
    }

    public final EditTextValidationBuilder setMinInputCount(long j) {
        this.minInputCount = j;
        return this;
    }

    public final EditeTextValidationErrorType checkValidationField() {
        int inputType = this.editText.getInputType();
        if (this.isCheckEmptyField) {
            Editable text = this.editText.getText();
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            if (text.length() == 0) {
                EditeTextValidationErrorType editeTextValidationErrorType = EditeTextValidationErrorType.EMPTY;
                this.currentValidationErrorType = editeTextValidationErrorType;
                return editeTextValidationErrorType;
            }
        }
        if ((inputType & 15) == 2) {
            Long l = this.updateValue;
            if (l == null && (l = StringsKt.toLongOrNull(this.editText.getText().toString())) == null) {
                return EditeTextValidationErrorType.EMPTY;
            }
            long longValue = l.longValue();
            if (longValue > this.maxInputCount) {
                EditeTextValidationErrorType editeTextValidationErrorType2 = EditeTextValidationErrorType.MAX_VALUE;
                this.currentValidationErrorType = editeTextValidationErrorType2;
                return editeTextValidationErrorType2;
            } else if (longValue < this.minInputCount) {
                EditeTextValidationErrorType editeTextValidationErrorType3 = EditeTextValidationErrorType.MIN_VALUE;
                this.currentValidationErrorType = editeTextValidationErrorType3;
                return editeTextValidationErrorType3;
            } else {
                EditeTextValidationErrorType editeTextValidationErrorType4 = EditeTextValidationErrorType.SUCCESSFUL;
                this.currentValidationErrorType = editeTextValidationErrorType4;
                return editeTextValidationErrorType4;
            }
        }
        String obj = this.editText.getText().toString();
        if (obj.length() > this.maxInputCount) {
            EditeTextValidationErrorType editeTextValidationErrorType5 = EditeTextValidationErrorType.MAX_VALUE;
            this.currentValidationErrorType = editeTextValidationErrorType5;
            return editeTextValidationErrorType5;
        } else if (obj.length() < this.minInputCount) {
            EditeTextValidationErrorType editeTextValidationErrorType6 = EditeTextValidationErrorType.MIN_VALUE;
            this.currentValidationErrorType = editeTextValidationErrorType6;
            return editeTextValidationErrorType6;
        } else {
            EditeTextValidationErrorType editeTextValidationErrorType7 = EditeTextValidationErrorType.SUCCESSFUL;
            this.currentValidationErrorType = editeTextValidationErrorType7;
            return editeTextValidationErrorType7;
        }
    }

    /* compiled from: EditTextValidationBuilder.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/utils/ui/EditTextValidationBuilder$Companion;", "", "<init>", "()V", "MIN_INPUT_VALUE", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
