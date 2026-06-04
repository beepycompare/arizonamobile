package com.miami.game.core.network.error_handler.parser.model;

import androidx.autofill.HintConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PayloadErrorTypeApiModel.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0010\b\u0004\u0012\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007j\u0010\b\b\u0012\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\tj\u0010\b\n\u0012\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000bj\u0010\b\f\u0012\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\rj\u0010\b\u000e\u0012\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000fj\u0010\b\u0010\u0012\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011j\u0010\b\u0012\u0012\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013j\u0010\b\u0014\u0012\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015j\u0010\b\u0016\u0012\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017¨\u0006\u0018"}, d2 = {"Lcom/miami/game/core/network/error_handler/parser/model/PayloadErrorTypeApiModel;", "", "<init>", "(Ljava/lang/String;I)V", "EMAIL", "Lcom/google/gson/annotations/SerializedName;", "value", "email", "PASSWORD", HintConstants.AUTOFILL_HINT_PASSWORD, "REFRESH_TOKEN", "refreshToken", "TOKEN", "token", "PREFERRED_CURRENCY", "preferredCurrency", "REFERRAL", "referral", "REGISTRATION_SOURCE_ID", "registrationSourceId", "OLD_PASSWORD", "oldPassword", "NEW_PASSWORD", HintConstants.AUTOFILL_HINT_NEW_PASSWORD, "network"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PayloadErrorTypeApiModel {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PayloadErrorTypeApiModel[] $VALUES;
    @SerializedName("email")
    public static final PayloadErrorTypeApiModel EMAIL = new PayloadErrorTypeApiModel("EMAIL", 0);
    @SerializedName(HintConstants.AUTOFILL_HINT_PASSWORD)
    public static final PayloadErrorTypeApiModel PASSWORD = new PayloadErrorTypeApiModel("PASSWORD", 1);
    @SerializedName("refreshToken")
    public static final PayloadErrorTypeApiModel REFRESH_TOKEN = new PayloadErrorTypeApiModel("REFRESH_TOKEN", 2);
    @SerializedName("token")
    public static final PayloadErrorTypeApiModel TOKEN = new PayloadErrorTypeApiModel("TOKEN", 3);
    @SerializedName("preferredCurrency")
    public static final PayloadErrorTypeApiModel PREFERRED_CURRENCY = new PayloadErrorTypeApiModel("PREFERRED_CURRENCY", 4);
    @SerializedName("referral")
    public static final PayloadErrorTypeApiModel REFERRAL = new PayloadErrorTypeApiModel("REFERRAL", 5);
    @SerializedName("registrationSourceId")
    public static final PayloadErrorTypeApiModel REGISTRATION_SOURCE_ID = new PayloadErrorTypeApiModel("REGISTRATION_SOURCE_ID", 6);
    @SerializedName("oldPassword")
    public static final PayloadErrorTypeApiModel OLD_PASSWORD = new PayloadErrorTypeApiModel("OLD_PASSWORD", 7);
    @SerializedName(HintConstants.AUTOFILL_HINT_NEW_PASSWORD)
    public static final PayloadErrorTypeApiModel NEW_PASSWORD = new PayloadErrorTypeApiModel("NEW_PASSWORD", 8);

    private static final /* synthetic */ PayloadErrorTypeApiModel[] $values() {
        return new PayloadErrorTypeApiModel[]{EMAIL, PASSWORD, REFRESH_TOKEN, TOKEN, PREFERRED_CURRENCY, REFERRAL, REGISTRATION_SOURCE_ID, OLD_PASSWORD, NEW_PASSWORD};
    }

    public static EnumEntries<PayloadErrorTypeApiModel> getEntries() {
        return $ENTRIES;
    }

    public static PayloadErrorTypeApiModel valueOf(String str) {
        return (PayloadErrorTypeApiModel) Enum.valueOf(PayloadErrorTypeApiModel.class, str);
    }

    public static PayloadErrorTypeApiModel[] values() {
        return (PayloadErrorTypeApiModel[]) $VALUES.clone();
    }

    private PayloadErrorTypeApiModel(String str, int i) {
    }

    static {
        PayloadErrorTypeApiModel[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
