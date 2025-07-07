package com.miami.game.core.error.model;

import com.miami.game.core.error.codes.ApiErrorCode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ApiErrorType.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/miami/game/core/error/model/ApiErrorType;", "", "<init>", "()V", "Companion", "Code", "UnknownCode", "NoCode", "Lcom/miami/game/core/error/model/ApiErrorType$Code;", "Lcom/miami/game/core/error/model/ApiErrorType$NoCode;", "Lcom/miami/game/core/error/model/ApiErrorType$UnknownCode;", "error_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class ApiErrorType {
    public static final Companion Companion = new Companion(null);

    public /* synthetic */ ApiErrorType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ApiErrorType() {
    }

    /* compiled from: ApiErrorType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/error/model/ApiErrorType$Companion;", "", "<init>", "()V", "of", "Lcom/miami/game/core/error/model/ApiErrorType;", "code", "", "error_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ApiErrorType of(String code) {
            Intrinsics.checkNotNullParameter(code, "code");
            if (code.length() == 0) {
                return NoCode.INSTANCE;
            }
            ApiErrorCode fromCode = ApiErrorCode.Companion.fromCode(code);
            if (fromCode != null) {
                return new Code(fromCode);
            }
            return new UnknownCode(code);
        }
    }

    /* compiled from: ApiErrorType.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/miami/game/core/error/model/ApiErrorType$Code;", "Lcom/miami/game/core/error/model/ApiErrorType;", "code", "Lcom/miami/game/core/error/codes/ApiErrorCode;", "<init>", "(Lcom/miami/game/core/error/codes/ApiErrorCode;)V", "getCode", "()Lcom/miami/game/core/error/codes/ApiErrorCode;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "error_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Code extends ApiErrorType {
        private final ApiErrorCode code;

        public static /* synthetic */ Code copy$default(Code code, ApiErrorCode apiErrorCode, int i, Object obj) {
            if ((i & 1) != 0) {
                apiErrorCode = code.code;
            }
            return code.copy(apiErrorCode);
        }

        public final ApiErrorCode component1() {
            return this.code;
        }

        public final Code copy(ApiErrorCode code) {
            Intrinsics.checkNotNullParameter(code, "code");
            return new Code(code);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Code) && this.code == ((Code) obj).code;
        }

        public int hashCode() {
            return this.code.hashCode();
        }

        public String toString() {
            return "Code(code=" + this.code + ")";
        }

        public final ApiErrorCode getCode() {
            return this.code;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Code(ApiErrorCode code) {
            super(null);
            Intrinsics.checkNotNullParameter(code, "code");
            this.code = code;
        }
    }

    /* compiled from: ApiErrorType.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/miami/game/core/error/model/ApiErrorType$UnknownCode;", "Lcom/miami/game/core/error/model/ApiErrorType;", "code", "", "<init>", "(Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "error_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class UnknownCode extends ApiErrorType {
        private final String code;

        public static /* synthetic */ UnknownCode copy$default(UnknownCode unknownCode, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unknownCode.code;
            }
            return unknownCode.copy(str);
        }

        public final String component1() {
            return this.code;
        }

        public final UnknownCode copy(String code) {
            Intrinsics.checkNotNullParameter(code, "code");
            return new UnknownCode(code);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UnknownCode) && Intrinsics.areEqual(this.code, ((UnknownCode) obj).code);
        }

        public int hashCode() {
            return this.code.hashCode();
        }

        public String toString() {
            return "UnknownCode(code=" + this.code + ")";
        }

        public final String getCode() {
            return this.code;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownCode(String code) {
            super(null);
            Intrinsics.checkNotNullParameter(code, "code");
            this.code = code;
        }
    }

    /* compiled from: ApiErrorType.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/miami/game/core/error/model/ApiErrorType$NoCode;", "Lcom/miami/game/core/error/model/ApiErrorType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "error_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class NoCode extends ApiErrorType {
        public static final NoCode INSTANCE = new NoCode();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NoCode) {
                NoCode noCode = (NoCode) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1558819428;
        }

        public String toString() {
            return "NoCode";
        }

        private NoCode() {
            super(null);
        }
    }
}
