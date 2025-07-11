package com.miami.game.core.error.model;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AppException.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB%\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0005\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0005\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/miami/game/core/error/model/AppException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "appError", "Lcom/miami/game/core/error/model/AppError;", "<init>", "(Lcom/miami/game/core/error/model/AppError;)V", "message", "", "(Lcom/miami/game/core/error/model/AppError;Ljava/lang/String;)V", "cause", "", "(Lcom/miami/game/core/error/model/AppError;Ljava/lang/String;Ljava/lang/Throwable;)V", "(Lcom/miami/game/core/error/model/AppError;Ljava/lang/Throwable;)V", "getAppError", "()Lcom/miami/game/core/error/model/AppError;", "getMessage", "()Ljava/lang/String;", "error_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AppException extends RuntimeException {
    private final AppError appError;

    public final AppError getAppError() {
        return this.appError;
    }

    public AppException(AppError appError) {
        Intrinsics.checkNotNullParameter(appError, "appError");
        this.appError = appError;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppException(AppError appError, String str) {
        super(str);
        Intrinsics.checkNotNullParameter(appError, "appError");
        this.appError = appError;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppException(AppError appError, String str, Throwable th) {
        super(str, th);
        Intrinsics.checkNotNullParameter(appError, "appError");
        this.appError = appError;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppException(AppError appError, Throwable th) {
        super(th);
        Intrinsics.checkNotNullParameter(appError, "appError");
        this.appError = appError;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{super.getMessage(), this.appError.toString()}), null, null, null, 0, null, null, 63, null);
    }
}
