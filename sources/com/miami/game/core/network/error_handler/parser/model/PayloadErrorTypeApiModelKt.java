package com.miami.game.core.network.error_handler.parser.model;

import com.miami.game.core.error.model.ValidationErrorType;
import kotlin.Metadata;
/* compiled from: PayloadErrorTypeApiModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000¨\u0006\u0003"}, d2 = {"toValidationError", "Lcom/miami/game/core/error/model/ValidationErrorType;", "Lcom/miami/game/core/network/error_handler/parser/model/PayloadErrorTypeApiModel;", "network_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PayloadErrorTypeApiModelKt {

    /* compiled from: PayloadErrorTypeApiModel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PayloadErrorTypeApiModel.values().length];
            try {
                iArr[PayloadErrorTypeApiModel.EMAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PayloadErrorTypeApiModel.PASSWORD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PayloadErrorTypeApiModel.REFRESH_TOKEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PayloadErrorTypeApiModel.TOKEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PayloadErrorTypeApiModel.PREFERRED_CURRENCY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PayloadErrorTypeApiModel.REFERRAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PayloadErrorTypeApiModel.REGISTRATION_SOURCE_ID.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PayloadErrorTypeApiModel.OLD_PASSWORD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PayloadErrorTypeApiModel.NEW_PASSWORD.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final ValidationErrorType toValidationError(PayloadErrorTypeApiModel payloadErrorTypeApiModel) {
        switch (payloadErrorTypeApiModel == null ? -1 : WhenMappings.$EnumSwitchMapping$0[payloadErrorTypeApiModel.ordinal()]) {
            case 1:
                return ValidationErrorType.EMAIL;
            case 2:
                return ValidationErrorType.PASSWORD;
            case 3:
                return ValidationErrorType.REFRESH_TOKEN;
            case 4:
                return ValidationErrorType.TOKEN;
            case 5:
                return ValidationErrorType.PREFERRED_CURRENCY;
            case 6:
                return ValidationErrorType.REFERRAL;
            case 7:
                return ValidationErrorType.REGISTRATION_SOURCE_ID;
            case 8:
                return ValidationErrorType.OLD_PASSWORD;
            case 9:
                return ValidationErrorType.NEW_PASSWORD;
            default:
                return ValidationErrorType.UNKNOWN;
        }
    }
}
