package com.miami.game.core.connection.resolver.data;

import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AvailabilityService.kt */
@Singleton
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\b\u0007\u001a\u0002\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bÊ\u0001\u0002\b\n¨\u0006\t"}, d2 = {"Lcom/miami/game/core/connection/resolver/data/AvailabilityService;", "", "<init>", "()V", "Ljavax/inject/Inject;", "checkAvailability", "", "serverUri", "", "connection-resolver", "Ljavax/inject/Singleton;"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AvailabilityService {
    public final boolean checkAvailability(String serverUri) {
        Intrinsics.checkNotNullParameter(serverUri, "serverUri");
        return FirebaseConfigHelper.INSTANCE.isServiceAvailable(serverUri);
    }
}
