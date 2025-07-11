package com.miami.game.core.error.codes;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ValidationErrorCode.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/miami/game/core/error/codes/ValidationErrorCode;", "", "code", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "UNKNOWN", "Companion", "error_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ValidationErrorCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ValidationErrorCode[] $VALUES;
    public static final Companion Companion;
    public static final ValidationErrorCode UNKNOWN = new ValidationErrorCode("UNKNOWN", 0, "");
    private final String code;

    private static final /* synthetic */ ValidationErrorCode[] $values() {
        return new ValidationErrorCode[]{UNKNOWN};
    }

    public static EnumEntries<ValidationErrorCode> getEntries() {
        return $ENTRIES;
    }

    public static ValidationErrorCode valueOf(String str) {
        return (ValidationErrorCode) Enum.valueOf(ValidationErrorCode.class, str);
    }

    public static ValidationErrorCode[] values() {
        return (ValidationErrorCode[]) $VALUES.clone();
    }

    private ValidationErrorCode(String str, int i, String str2) {
        this.code = str2;
    }

    public final String getCode() {
        return this.code;
    }

    static {
        ValidationErrorCode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    /* compiled from: ValidationErrorCode.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/error/codes/ValidationErrorCode$Companion;", "", "<init>", "()V", "fromCode", "Lcom/miami/game/core/error/codes/ValidationErrorCode;", "code", "", "error_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ValidationErrorCode fromCode(String code) {
            Object obj;
            Intrinsics.checkNotNullParameter(code, "code");
            Iterator<E> it = ValidationErrorCode.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((ValidationErrorCode) obj).getCode(), code)) {
                    break;
                }
            }
            return (ValidationErrorCode) obj;
        }
    }
}
