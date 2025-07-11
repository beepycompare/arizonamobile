package io.appmetrica.analytics.coreapi.internal.data;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\n\b\u0001\u0010\u0002 \u0001*\u00020\u00032\u00020\u0003J\u0015\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lio/appmetrica/analytics/coreapi/internal/data/Parser;", "IN", "OUT", "", "parse", Constants.MessagePayloadKeys.RAW_DATA, "(Ljava/lang/Object;)Ljava/lang/Object;", "parseOrNull", "core-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface Parser<IN, OUT> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static <IN, OUT> OUT parseOrNull(Parser<? super IN, ? extends OUT> parser, IN in) {
            OUT out;
            try {
                Result.Companion companion = Result.Companion;
                out = (OUT) Result.m8471constructorimpl(parser.parse(in));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                out = (OUT) Result.m8471constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m8477isFailureimpl(out)) {
                return null;
            }
            return out;
        }
    }

    OUT parse(IN in);

    OUT parseOrNull(IN in);
}
