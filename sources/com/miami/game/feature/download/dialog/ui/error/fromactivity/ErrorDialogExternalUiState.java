package com.miami.game.feature.download.dialog.ui.error.fromactivity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ExternalState.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/error/fromactivity/ErrorDialogExternalUiState;", "", "type", "Lcom/miami/game/feature/download/dialog/ui/error/fromactivity/ErrorDialogType;", "positiveText", "", "negativeText", "title", "description", "<init>", "(Lcom/miami/game/feature/download/dialog/ui/error/fromactivity/ErrorDialogType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Lcom/miami/game/feature/download/dialog/ui/error/fromactivity/ErrorDialogType;", "getPositiveText", "()Ljava/lang/String;", "getNegativeText", "getTitle", "getDescription", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "dialogs_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ErrorDialogExternalUiState {
    public static final int $stable = 0;
    private final String description;
    private final String negativeText;
    private final String positiveText;
    private final String title;
    private final ErrorDialogType type;

    public ErrorDialogExternalUiState() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ErrorDialogExternalUiState copy$default(ErrorDialogExternalUiState errorDialogExternalUiState, ErrorDialogType errorDialogType, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            errorDialogType = errorDialogExternalUiState.type;
        }
        if ((i & 2) != 0) {
            str = errorDialogExternalUiState.positiveText;
        }
        if ((i & 4) != 0) {
            str2 = errorDialogExternalUiState.negativeText;
        }
        if ((i & 8) != 0) {
            str3 = errorDialogExternalUiState.title;
        }
        if ((i & 16) != 0) {
            str4 = errorDialogExternalUiState.description;
        }
        String str5 = str4;
        String str6 = str2;
        return errorDialogExternalUiState.copy(errorDialogType, str, str6, str3, str5);
    }

    public final ErrorDialogType component1() {
        return this.type;
    }

    public final String component2() {
        return this.positiveText;
    }

    public final String component3() {
        return this.negativeText;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.description;
    }

    public final ErrorDialogExternalUiState copy(ErrorDialogType type, String positiveText, String negativeText, String title, String description) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(positiveText, "positiveText");
        Intrinsics.checkNotNullParameter(negativeText, "negativeText");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        return new ErrorDialogExternalUiState(type, positiveText, negativeText, title, description);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ErrorDialogExternalUiState) {
            ErrorDialogExternalUiState errorDialogExternalUiState = (ErrorDialogExternalUiState) obj;
            return this.type == errorDialogExternalUiState.type && Intrinsics.areEqual(this.positiveText, errorDialogExternalUiState.positiveText) && Intrinsics.areEqual(this.negativeText, errorDialogExternalUiState.negativeText) && Intrinsics.areEqual(this.title, errorDialogExternalUiState.title) && Intrinsics.areEqual(this.description, errorDialogExternalUiState.description);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.type.hashCode() * 31) + this.positiveText.hashCode()) * 31) + this.negativeText.hashCode()) * 31) + this.title.hashCode()) * 31) + this.description.hashCode();
    }

    public String toString() {
        ErrorDialogType errorDialogType = this.type;
        String str = this.positiveText;
        String str2 = this.negativeText;
        String str3 = this.title;
        return "ErrorDialogExternalUiState(type=" + errorDialogType + ", positiveText=" + str + ", negativeText=" + str2 + ", title=" + str3 + ", description=" + this.description + ")";
    }

    public ErrorDialogExternalUiState(ErrorDialogType type, String positiveText, String negativeText, String title, String description) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(positiveText, "positiveText");
        Intrinsics.checkNotNullParameter(negativeText, "negativeText");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        this.type = type;
        this.positiveText = positiveText;
        this.negativeText = negativeText;
        this.title = title;
        this.description = description;
    }

    public /* synthetic */ ErrorDialogExternalUiState(ErrorDialogType errorDialogType, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str5;
        String str6;
        String str7;
        String str8;
        ErrorDialogExternalUiState errorDialogExternalUiState;
        ErrorDialogType errorDialogType2;
        errorDialogType = (i & 1) != 0 ? ErrorDialogType.Base : errorDialogType;
        str = (i & 2) != 0 ? "Да" : str;
        str2 = (i & 4) != 0 ? "Нет" : str2;
        str3 = (i & 8) != 0 ? "" : str3;
        if ((i & 16) != 0) {
            str5 = "";
            str8 = str2;
            str6 = str3;
            errorDialogType2 = errorDialogType;
            str7 = str;
            errorDialogExternalUiState = this;
        } else {
            str5 = str4;
            str6 = str3;
            str7 = str;
            str8 = str2;
            errorDialogExternalUiState = this;
            errorDialogType2 = errorDialogType;
        }
        new ErrorDialogExternalUiState(errorDialogType2, str7, str8, str6, str5);
    }

    public final ErrorDialogType getType() {
        return this.type;
    }

    public final String getPositiveText() {
        return this.positiveText;
    }

    public final String getNegativeText() {
        return this.negativeText;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }
}
