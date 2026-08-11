package ru.mrlargha.commonui.elements.dialogs;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: UserInputDialogResponseCodec.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/UserInputDialogResponseCodec;", "", "<init>", "()V", "PART_SEPARATOR", "", "encode", "mainInput", "findPlayerInput", "decode", "Lru/mrlargha/commonui/elements/dialogs/UserInputDialogResponseCodec$DecodedInput;", "input", "hasFindPlayerInput", "", "DecodedInput", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UserInputDialogResponseCodec {
    public static final UserInputDialogResponseCodec INSTANCE = new UserInputDialogResponseCodec();
    private static final String PART_SEPARATOR = "|";

    private UserInputDialogResponseCodec() {
    }

    public final String encode(String mainInput, String str) {
        Intrinsics.checkNotNullParameter(mainInput, "mainInput");
        return str == null ? mainInput : str + PART_SEPARATOR + mainInput;
    }

    public final DecodedInput decode(String input, boolean z) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (!z) {
            return new DecodedInput(input, null, 2, null);
        }
        List split$default = StringsKt.split$default((CharSequence) input, new String[]{PART_SEPARATOR}, false, 2, 2, (Object) null);
        if (split$default.size() == 2) {
            return new DecodedInput((String) split$default.get(1), (String) split$default.get(0));
        }
        return new DecodedInput(input, null, 2, null);
    }

    /* compiled from: UserInputDialogResponseCodec.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/UserInputDialogResponseCodec$DecodedInput;", "", "mainInput", "", "findPlayerInput", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getMainInput", "()Ljava/lang/String;", "getFindPlayerInput", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DecodedInput {
        private final String findPlayerInput;
        private final String mainInput;

        public static /* synthetic */ DecodedInput copy$default(DecodedInput decodedInput, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = decodedInput.mainInput;
            }
            if ((i & 2) != 0) {
                str2 = decodedInput.findPlayerInput;
            }
            return decodedInput.copy(str, str2);
        }

        public final String component1() {
            return this.mainInput;
        }

        public final String component2() {
            return this.findPlayerInput;
        }

        public final DecodedInput copy(String mainInput, String str) {
            Intrinsics.checkNotNullParameter(mainInput, "mainInput");
            return new DecodedInput(mainInput, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DecodedInput) {
                DecodedInput decodedInput = (DecodedInput) obj;
                return Intrinsics.areEqual(this.mainInput, decodedInput.mainInput) && Intrinsics.areEqual(this.findPlayerInput, decodedInput.findPlayerInput);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.mainInput.hashCode() * 31;
            String str = this.findPlayerInput;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            String str = this.mainInput;
            return "DecodedInput(mainInput=" + str + ", findPlayerInput=" + this.findPlayerInput + ")";
        }

        public DecodedInput(String mainInput, String str) {
            Intrinsics.checkNotNullParameter(mainInput, "mainInput");
            this.mainInput = mainInput;
            this.findPlayerInput = str;
        }

        public /* synthetic */ DecodedInput(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2);
        }

        public final String getMainInput() {
            return this.mainInput;
        }

        public final String getFindPlayerInput() {
            return this.findPlayerInput;
        }
    }
}
