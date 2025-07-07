package com.miami.game.core.error.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ValidationErrorType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/miami/game/core/error/model/ValidationErrorType;", "", "<init>", "(Ljava/lang/String;I)V", "EMAIL", "PASSWORD", "REFRESH_TOKEN", "TOKEN", "PREFERRED_CURRENCY", "REFERRAL", "REGISTRATION_SOURCE_ID", "UNKNOWN", "OLD_PASSWORD", "NEW_PASSWORD", "error_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ValidationErrorType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ValidationErrorType[] $VALUES;
    public static final ValidationErrorType EMAIL = new ValidationErrorType("EMAIL", 0);
    public static final ValidationErrorType PASSWORD = new ValidationErrorType("PASSWORD", 1);
    public static final ValidationErrorType REFRESH_TOKEN = new ValidationErrorType("REFRESH_TOKEN", 2);
    public static final ValidationErrorType TOKEN = new ValidationErrorType("TOKEN", 3);
    public static final ValidationErrorType PREFERRED_CURRENCY = new ValidationErrorType("PREFERRED_CURRENCY", 4);
    public static final ValidationErrorType REFERRAL = new ValidationErrorType("REFERRAL", 5);
    public static final ValidationErrorType REGISTRATION_SOURCE_ID = new ValidationErrorType("REGISTRATION_SOURCE_ID", 6);
    public static final ValidationErrorType UNKNOWN = new ValidationErrorType("UNKNOWN", 7);
    public static final ValidationErrorType OLD_PASSWORD = new ValidationErrorType("OLD_PASSWORD", 8);
    public static final ValidationErrorType NEW_PASSWORD = new ValidationErrorType("NEW_PASSWORD", 9);

    private static final /* synthetic */ ValidationErrorType[] $values() {
        return new ValidationErrorType[]{EMAIL, PASSWORD, REFRESH_TOKEN, TOKEN, PREFERRED_CURRENCY, REFERRAL, REGISTRATION_SOURCE_ID, UNKNOWN, OLD_PASSWORD, NEW_PASSWORD};
    }

    public static EnumEntries<ValidationErrorType> getEntries() {
        return $ENTRIES;
    }

    private ValidationErrorType(String str, int i) {
    }

    static {
        ValidationErrorType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ValidationErrorType valueOf(String str) {
        return (ValidationErrorType) Enum.valueOf(ValidationErrorType.class, str);
    }

    public static ValidationErrorType[] values() {
        return (ValidationErrorType[]) $VALUES.clone();
    }
}
