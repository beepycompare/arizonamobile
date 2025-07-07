package ru.rustore.sdk.core.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RuStoreFeatureAvailabilityException.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lru/rustore/sdk/core/exception/RuStoreFeatureAvailabilityException;", "Lru/rustore/sdk/core/exception/RuStoreException;", "message", "", "(Ljava/lang/String;)V", "sdk-public-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public class RuStoreFeatureAvailabilityException extends RuStoreException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RuStoreFeatureAvailabilityException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
