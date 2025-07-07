package com.miami.game.core.error.model;

import com.facebook.internal.NativeProtocol;
import com.miami.game.core.error.codes.ValidationErrorCode;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AppError.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/miami/game/core/error/model/AppError;", "", "<init>", "()V", "ApiError", "ValidationApiError", "AuthError", "HttpError", NativeProtocol.ERROR_NETWORK_ERROR, "ResponseParsingError", "ResponseContentError", "Lcom/miami/game/core/error/model/AppError$ApiError;", "Lcom/miami/game/core/error/model/AppError$AuthError;", "Lcom/miami/game/core/error/model/AppError$HttpError;", "Lcom/miami/game/core/error/model/AppError$NetworkError;", "Lcom/miami/game/core/error/model/AppError$ResponseContentError;", "Lcom/miami/game/core/error/model/AppError$ResponseParsingError;", "Lcom/miami/game/core/error/model/AppError$ValidationApiError;", "error_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class AppError {
    public /* synthetic */ AppError(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AppError() {
    }

    /* compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/miami/game/core/error/model/AppError$ApiError;", "Lcom/miami/game/core/error/model/AppError;", "type", "Lcom/miami/game/core/error/model/ApiErrorType;", "<init>", "(Lcom/miami/game/core/error/model/ApiErrorType;)V", "getType", "()Lcom/miami/game/core/error/model/ApiErrorType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "error_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class ApiError extends AppError {
        public static final Companion Companion = new Companion(null);
        private final ApiErrorType type;

        public static /* synthetic */ ApiError copy$default(ApiError apiError, ApiErrorType apiErrorType, int i, Object obj) {
            if ((i & 1) != 0) {
                apiErrorType = apiError.type;
            }
            return apiError.copy(apiErrorType);
        }

        public final ApiErrorType component1() {
            return this.type;
        }

        public final ApiError copy(ApiErrorType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new ApiError(type);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ApiError) && Intrinsics.areEqual(this.type, ((ApiError) obj).type);
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        public String toString() {
            return "ApiError(type=" + this.type + ")";
        }

        public final ApiErrorType getType() {
            return this.type;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ApiError(ApiErrorType type) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
        }

        /* compiled from: AppError.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/error/model/AppError$ApiError$Companion;", "", "<init>", "()V", "of", "Lcom/miami/game/core/error/model/AppError$ApiError;", "code", "", "error_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ApiError of(String str) {
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    return null;
                }
                return new ApiError(ApiErrorType.Companion.of(str));
            }
        }
    }

    /* compiled from: AppError.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003HÆ\u0003J%\u0010\f\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/miami/game/core/error/model/AppError$ValidationApiError;", "Lcom/miami/game/core/error/model/AppError;", "errors", "", "Lcom/miami/game/core/error/model/ValidationErrorType;", "", "Lcom/miami/game/core/error/codes/ValidationErrorCode;", "<init>", "(Ljava/util/Map;)V", "getErrors", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "error_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class ValidationApiError extends AppError {
        private final Map<ValidationErrorType, List<ValidationErrorCode>> errors;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ValidationApiError copy$default(ValidationApiError validationApiError, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = validationApiError.errors;
            }
            return validationApiError.copy(map);
        }

        public final Map<ValidationErrorType, List<ValidationErrorCode>> component1() {
            return this.errors;
        }

        public final ValidationApiError copy(Map<ValidationErrorType, ? extends List<? extends ValidationErrorCode>> errors) {
            Intrinsics.checkNotNullParameter(errors, "errors");
            return new ValidationApiError(errors);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ValidationApiError) && Intrinsics.areEqual(this.errors, ((ValidationApiError) obj).errors);
        }

        public int hashCode() {
            return this.errors.hashCode();
        }

        public String toString() {
            return "ValidationApiError(errors=" + this.errors + ")";
        }

        public final Map<ValidationErrorType, List<ValidationErrorCode>> getErrors() {
            return this.errors;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ValidationApiError(Map<ValidationErrorType, ? extends List<? extends ValidationErrorCode>> errors) {
            super(null);
            Intrinsics.checkNotNullParameter(errors, "errors");
            this.errors = errors;
        }
    }

    /* compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/miami/game/core/error/model/AppError$AuthError;", "Lcom/miami/game/core/error/model/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "error_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class AuthError extends AppError {
        public static final AuthError INSTANCE = new AuthError();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AuthError) {
                AuthError authError = (AuthError) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1969050993;
        }

        public String toString() {
            return "AuthError";
        }

        private AuthError() {
            super(null);
        }
    }

    /* compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/miami/game/core/error/model/AppError$HttpError;", "Lcom/miami/game/core/error/model/AppError;", "httpCode", "", "<init>", "(I)V", "getHttpCode", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "error_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class HttpError extends AppError {
        private final int httpCode;

        public static /* synthetic */ HttpError copy$default(HttpError httpError, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = httpError.httpCode;
            }
            return httpError.copy(i);
        }

        public final int component1() {
            return this.httpCode;
        }

        public final HttpError copy(int i) {
            return new HttpError(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HttpError) && this.httpCode == ((HttpError) obj).httpCode;
        }

        public int hashCode() {
            return Integer.hashCode(this.httpCode);
        }

        public String toString() {
            return "HttpError(httpCode=" + this.httpCode + ")";
        }

        public final int getHttpCode() {
            return this.httpCode;
        }

        public HttpError(int i) {
            super(null);
            this.httpCode = i;
        }
    }

    /* compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/miami/game/core/error/model/AppError$NetworkError;", "Lcom/miami/game/core/error/model/AppError;", "type", "Lcom/miami/game/core/error/model/NetworkErrorType;", "<init>", "(Lcom/miami/game/core/error/model/NetworkErrorType;)V", "getType", "()Lcom/miami/game/core/error/model/NetworkErrorType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "error_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class NetworkError extends AppError {
        private final NetworkErrorType type;

        public static /* synthetic */ NetworkError copy$default(NetworkError networkError, NetworkErrorType networkErrorType, int i, Object obj) {
            if ((i & 1) != 0) {
                networkErrorType = networkError.type;
            }
            return networkError.copy(networkErrorType);
        }

        public final NetworkErrorType component1() {
            return this.type;
        }

        public final NetworkError copy(NetworkErrorType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new NetworkError(type);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NetworkError) && this.type == ((NetworkError) obj).type;
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        public String toString() {
            return "NetworkError(type=" + this.type + ")";
        }

        public final NetworkErrorType getType() {
            return this.type;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NetworkError(NetworkErrorType type) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
        }
    }

    /* compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/miami/game/core/error/model/AppError$ResponseParsingError;", "Lcom/miami/game/core/error/model/AppError;", "fieldName", "", "<init>", "(Ljava/lang/String;)V", "getFieldName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "error_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class ResponseParsingError extends AppError {
        private final String fieldName;

        public ResponseParsingError() {
            this(null, 1, null);
        }

        public static /* synthetic */ ResponseParsingError copy$default(ResponseParsingError responseParsingError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = responseParsingError.fieldName;
            }
            return responseParsingError.copy(str);
        }

        public final String component1() {
            return this.fieldName;
        }

        public final ResponseParsingError copy(String fieldName) {
            Intrinsics.checkNotNullParameter(fieldName, "fieldName");
            return new ResponseParsingError(fieldName);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ResponseParsingError) && Intrinsics.areEqual(this.fieldName, ((ResponseParsingError) obj).fieldName);
        }

        public int hashCode() {
            return this.fieldName.hashCode();
        }

        public String toString() {
            return "ResponseParsingError(fieldName=" + this.fieldName + ")";
        }

        public /* synthetic */ ResponseParsingError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        public final String getFieldName() {
            return this.fieldName;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResponseParsingError(String fieldName) {
            super(null);
            Intrinsics.checkNotNullParameter(fieldName, "fieldName");
            this.fieldName = fieldName;
        }
    }

    /* compiled from: AppError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/miami/game/core/error/model/AppError$ResponseContentError;", "Lcom/miami/game/core/error/model/AppError;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "error_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class ResponseContentError extends AppError {
        public static final ResponseContentError INSTANCE = new ResponseContentError();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ResponseContentError) {
                ResponseContentError responseContentError = (ResponseContentError) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 532758303;
        }

        public String toString() {
            return "ResponseContentError";
        }

        private ResponseContentError() {
            super(null);
        }
    }
}
