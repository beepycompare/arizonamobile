package com.miami.game.core.network.error_handler.parser.model;

import androidx.autofill.HintConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PayloadErrorTypeApiModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/miami/game/core/network/error_handler/parser/model/PayloadErrorTypeApiModel;", "", "<init>", "(Ljava/lang/String;I)V", "EMAIL", "PASSWORD", "REFRESH_TOKEN", "TOKEN", "PREFERRED_CURRENCY", "REFERRAL", "REGISTRATION_SOURCE_ID", "OLD_PASSWORD", "NEW_PASSWORD", "network_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
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

    private PayloadErrorTypeApiModel(String str, int i) {
    }

    static {
        PayloadErrorTypeApiModel[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static PayloadErrorTypeApiModel valueOf(String str) {
        return (PayloadErrorTypeApiModel) Enum.valueOf(PayloadErrorTypeApiModel.class, str);
    }

    public static PayloadErrorTypeApiModel[] values() {
        return (PayloadErrorTypeApiModel[]) $VALUES.clone();
    }
}
