package com.miami.game.core.network.error_handler.parser.model;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ErrorWithCodeApiModel.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/miami/game/core/network/error_handler/parser/model/ErrorWithCodeApiModel;", "", "code", "", NotificationCompat.CATEGORY_STATUS, "payload", "Lcom/miami/game/core/network/error_handler/parser/model/PayloadErrorApiModel;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/miami/game/core/network/error_handler/parser/model/PayloadErrorApiModel;)V", "getCode", "()Ljava/lang/String;", "getStatus", "getPayload", "()Lcom/miami/game/core/network/error_handler/parser/model/PayloadErrorApiModel;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "network_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ErrorWithCodeApiModel {
    @SerializedName("code")
    private final String code;
    @SerializedName("payload")
    private final PayloadErrorApiModel payload;
    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    private final String status;

    public static /* synthetic */ ErrorWithCodeApiModel copy$default(ErrorWithCodeApiModel errorWithCodeApiModel, String str, String str2, PayloadErrorApiModel payloadErrorApiModel, int i, Object obj) {
        if ((i & 1) != 0) {
            str = errorWithCodeApiModel.code;
        }
        if ((i & 2) != 0) {
            str2 = errorWithCodeApiModel.status;
        }
        if ((i & 4) != 0) {
            payloadErrorApiModel = errorWithCodeApiModel.payload;
        }
        return errorWithCodeApiModel.copy(str, str2, payloadErrorApiModel);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.status;
    }

    public final PayloadErrorApiModel component3() {
        return this.payload;
    }

    public final ErrorWithCodeApiModel copy(String str, String str2, PayloadErrorApiModel payloadErrorApiModel) {
        return new ErrorWithCodeApiModel(str, str2, payloadErrorApiModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ErrorWithCodeApiModel) {
            ErrorWithCodeApiModel errorWithCodeApiModel = (ErrorWithCodeApiModel) obj;
            return Intrinsics.areEqual(this.code, errorWithCodeApiModel.code) && Intrinsics.areEqual(this.status, errorWithCodeApiModel.status) && Intrinsics.areEqual(this.payload, errorWithCodeApiModel.payload);
        }
        return false;
    }

    public int hashCode() {
        String str = this.code;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.status;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        PayloadErrorApiModel payloadErrorApiModel = this.payload;
        return hashCode2 + (payloadErrorApiModel != null ? payloadErrorApiModel.hashCode() : 0);
    }

    public String toString() {
        String str = this.code;
        String str2 = this.status;
        return "ErrorWithCodeApiModel(code=" + str + ", status=" + str2 + ", payload=" + this.payload + ")";
    }

    public ErrorWithCodeApiModel(String str, String str2, PayloadErrorApiModel payloadErrorApiModel) {
        this.code = str;
        this.status = str2;
        this.payload = payloadErrorApiModel;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getStatus() {
        return this.status;
    }

    public final PayloadErrorApiModel getPayload() {
        return this.payload;
    }
}
