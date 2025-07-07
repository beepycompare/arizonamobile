package com.miami.game.core.network.error_handler.parser;

import com.miami.game.core.error.model.AppError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Response;
import timber.log.Timber;
/* compiled from: ResponseApiErrorParser.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\n\u001a\u0004\u0018\u00010\u00072\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/miami/game/core/network/error_handler/parser/ResponseApiErrorParser;", "", "jsonApiErrorParser", "Lcom/miami/game/core/network/error_handler/parser/JsonApiErrorParser;", "<init>", "(Lcom/miami/game/core/network/error_handler/parser/JsonApiErrorParser;)V", "parseApiErrorFromResponseBody", "Lcom/miami/game/core/error/model/AppError;", "responseBody", "Lokhttp3/ResponseBody;", "parseApiErrorFromErrorResponse", "response", "Lretrofit2/Response;", "network_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ResponseApiErrorParser {
    private final JsonApiErrorParser jsonApiErrorParser;

    public ResponseApiErrorParser(JsonApiErrorParser jsonApiErrorParser) {
        Intrinsics.checkNotNullParameter(jsonApiErrorParser, "jsonApiErrorParser");
        this.jsonApiErrorParser = jsonApiErrorParser;
    }

    public final AppError parseApiErrorFromResponseBody(ResponseBody responseBody) {
        Intrinsics.checkNotNullParameter(responseBody, "responseBody");
        try {
            return this.jsonApiErrorParser.parseApiError(responseBody.string());
        } catch (Exception unused) {
            return null;
        }
    }

    public final AppError parseApiErrorFromErrorResponse(Response<?> response) {
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            ResponseBody errorBody = response.errorBody();
            if (errorBody != null) {
                return this.jsonApiErrorParser.parseApiError(errorBody.string());
            }
            return null;
        } catch (Exception e) {
            Timber.Forest.w(e, "Can't parse API error from failure response " + response, new Object[0]);
            return null;
        }
    }
}
