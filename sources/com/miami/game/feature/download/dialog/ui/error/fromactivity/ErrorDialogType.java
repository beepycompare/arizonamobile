package com.miami.game.feature.download.dialog.ui.error.fromactivity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ExternalState.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/error/fromactivity/ErrorDialogType;", "", "<init>", "(Ljava/lang/String;I)V", "Base", "Alert", "Download", "ConnectionError", "Repair", "dialogs_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ErrorDialogType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ErrorDialogType[] $VALUES;
    public static final ErrorDialogType Base = new ErrorDialogType("Base", 0);
    public static final ErrorDialogType Alert = new ErrorDialogType("Alert", 1);
    public static final ErrorDialogType Download = new ErrorDialogType("Download", 2);
    public static final ErrorDialogType ConnectionError = new ErrorDialogType("ConnectionError", 3);
    public static final ErrorDialogType Repair = new ErrorDialogType("Repair", 4);

    private static final /* synthetic */ ErrorDialogType[] $values() {
        return new ErrorDialogType[]{Base, Alert, Download, ConnectionError, Repair};
    }

    public static EnumEntries<ErrorDialogType> getEntries() {
        return $ENTRIES;
    }

    private ErrorDialogType(String str, int i) {
    }

    static {
        ErrorDialogType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ErrorDialogType valueOf(String str) {
        return (ErrorDialogType) Enum.valueOf(ErrorDialogType.class, str);
    }

    public static ErrorDialogType[] values() {
        return (ErrorDialogType[]) $VALUES.clone();
    }
}
