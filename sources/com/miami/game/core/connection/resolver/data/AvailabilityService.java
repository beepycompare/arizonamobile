package com.miami.game.core.connection.resolver.data;

import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
/* compiled from: AvailabilityService.kt */
@Singleton
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/connection/resolver/data/AvailabilityService;", "", "<init>", "()V", "checkAvailability", "", "serverUri", "", "connection-resolver_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AvailabilityService {
    public final boolean checkAvailability(String serverUri) {
        Intrinsics.checkNotNullParameter(serverUri, "serverUri");
        return (FirebaseConfigHelper.INSTANCE.checkWithIsReachable(serverUri) || FirebaseConfigHelper.INSTANCE.checkWithUnixSystemPing(serverUri) || FirebaseConfigHelper.INSTANCE.checkWithLinuxNC(serverUri)) && FirebaseConfigHelper.INSTANCE.isServiceAvailable(serverUri);
    }
}
