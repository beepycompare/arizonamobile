package com.miami.game.core.error;

import android.content.res.Resources;
import com.miami.game.core.error.codes.ValidationErrorCode;
import com.miami.game.core.error.model.ApiErrorType;
import com.miami.game.core.error.model.AppError;
import com.miami.game.core.error.model.AppException;
import com.miami.game.core.error.model.NetworkErrorType;
import com.miami.game.core.error.model.ValidationErrorType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AppErrorUiMessage.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\b"}, d2 = {"uiMessage", "", "Lcom/miami/game/core/error/model/AppError;", "resources", "Landroid/content/res/Resources;", "Lcom/miami/game/core/error/codes/ValidationErrorCode;", "Lcom/miami/game/core/error/model/ApiErrorType$Code;", "Lcom/miami/game/core/error/model/AppException;", "error_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AppErrorUiMessageKt {

    /* compiled from: AppErrorUiMessage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NetworkErrorType.values().length];
            try {
                iArr[NetworkErrorType.SSL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NetworkErrorType.CONNECTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NetworkErrorType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String uiMessage(AppError appError, Resources resources) {
        AppError.ResponseParsingError responseParsingError;
        List<ValidationErrorCode> list;
        String uiMessage;
        Intrinsics.checkNotNullParameter(appError, "<this>");
        Intrinsics.checkNotNullParameter(resources, "resources");
        if (appError instanceof AppError.ValidationApiError) {
            Iterator<Map.Entry<ValidationErrorType, List<ValidationErrorCode>>> it = ((AppError.ValidationApiError) appError).getErrors().entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    list = null;
                    break;
                }
                list = it.next().getValue();
                if (list != null) {
                    break;
                }
            }
            ValidationErrorCode validationErrorCode = list != null ? (ValidationErrorCode) CollectionsKt.firstOrNull((List<? extends Object>) list) : null;
            if (validationErrorCode == null || (uiMessage = uiMessage(validationErrorCode, resources)) == null) {
                String string = resources.getString(R.string.network_error_message_http_unknown);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            }
            return uiMessage;
        } else if (appError instanceof AppError.ApiError) {
            AppError.ApiError apiError = (AppError.ApiError) appError;
            ApiErrorType type = apiError.getType();
            if (type instanceof ApiErrorType.Code) {
                return uiMessage((ApiErrorType.Code) apiError.getType(), resources);
            }
            if (type instanceof ApiErrorType.UnknownCode) {
                String string2 = resources.getString(R.string.error_message_unknown_with_code, ((ApiErrorType.UnknownCode) apiError.getType()).getCode());
                Intrinsics.checkNotNull(string2);
                return string2;
            } else if (!Intrinsics.areEqual(type, ApiErrorType.NoCode.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            } else {
                String string3 = resources.getString(R.string.network_error_message_http_unknown);
                Intrinsics.checkNotNull(string3);
                return string3;
            }
        } else if (Intrinsics.areEqual(appError, AppError.AuthError.INSTANCE)) {
            String string4 = resources.getString(R.string.error_message_auth);
            Intrinsics.checkNotNull(string4);
            return string4;
        } else if (appError instanceof AppError.HttpError) {
            String string5 = resources.getString(R.string.error_message_unknown_with_code, String.valueOf(((AppError.HttpError) appError).getHttpCode()));
            Intrinsics.checkNotNull(string5);
            return string5;
        } else if (!(appError instanceof AppError.NetworkError)) {
            if (appError instanceof AppError.ResponseParsingError) {
                String string6 = resources.getString(R.string.network_error_message_data_format);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                return ((AppError.ResponseParsingError) appError).getFieldName().length() == 0 ? string6 : string6 + " (" + responseParsingError.getFieldName() + ")";
            } else if (Intrinsics.areEqual(appError, AppError.ResponseContentError.INSTANCE)) {
                String string7 = resources.getString(R.string.network_error_message_http_unknown);
                Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                return string7;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            int i = WhenMappings.$EnumSwitchMapping$0[((AppError.NetworkError) appError).getType().ordinal()];
            if (i == 1) {
                String string8 = resources.getString(R.string.network_error_message_certificate);
                Intrinsics.checkNotNull(string8);
                return string8;
            } else if (i == 2 || i == 3) {
                String string9 = resources.getString(R.string.network_error_message_connection);
                Intrinsics.checkNotNull(string9);
                return string9;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public static final String uiMessage(ValidationErrorCode validationErrorCode, Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        String string = resources.getString(R.string.network_error_message_http_unknown);
        Intrinsics.checkNotNull(string);
        return string;
    }

    public static final String uiMessage(ApiErrorType.Code code, Resources resources) {
        Intrinsics.checkNotNullParameter(code, "<this>");
        Intrinsics.checkNotNullParameter(resources, "resources");
        code.getCode();
        String string = resources.getString(R.string.error_message_unknown_with_code, code.getCode().getCode());
        Intrinsics.checkNotNull(string);
        return string;
    }

    public static final String uiMessage(AppException appException, Resources resources) {
        Intrinsics.checkNotNullParameter(appException, "<this>");
        Intrinsics.checkNotNullParameter(resources, "resources");
        return uiMessage(appException.getAppError(), resources);
    }
}
