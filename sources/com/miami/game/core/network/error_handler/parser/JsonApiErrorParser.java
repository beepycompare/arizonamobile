package com.miami.game.core.network.error_handler.parser;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.gson.Gson;
import com.miami.game.core.error.model.ApiErrorType;
import com.miami.game.core.error.model.AppError;
import com.miami.game.core.network.error_handler.parser.model.ErrorWithCodeApiModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: JsonApiErrorParser.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/miami/game/core/network/error_handler/parser/JsonApiErrorParser;", "", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "parseApiError", "Lcom/miami/game/core/error/model/AppError;", TtmlNode.TAG_BODY, "", "parseApiErrorWithCode", "Companion", "network_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class JsonApiErrorParser {
    public static final Companion Companion = new Companion(null);
    public static final String ERROR = "error";
    private final Gson gson = new Gson();

    /* compiled from: JsonApiErrorParser.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/miami/game/core/network/error_handler/parser/JsonApiErrorParser$Companion;", "", "<init>", "()V", "ERROR", "", "network_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final AppError parseApiError(String body) {
        Intrinsics.checkNotNullParameter(body, "body");
        try {
            return parseApiErrorWithCode(body);
        } catch (Exception unused) {
            return null;
        }
    }

    private final AppError parseApiErrorWithCode(String str) {
        String code;
        ErrorWithCodeApiModel errorWithCodeApiModel = (ErrorWithCodeApiModel) this.gson.fromJson(str, (Class<Object>) ErrorWithCodeApiModel.class);
        if (!Intrinsics.areEqual(errorWithCodeApiModel.getStatus(), "error") || (code = errorWithCodeApiModel.getCode()) == null || code.length() == 0) {
            return null;
        }
        return new AppError.ApiError(ApiErrorType.Companion.of(errorWithCodeApiModel.getCode()));
    }
}
