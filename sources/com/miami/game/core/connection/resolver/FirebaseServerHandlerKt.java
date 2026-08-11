package com.miami.game.core.connection.resolver;

import kotlin.Metadata;
/* compiled from: FirebaseServerHandler.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"TAG", "", "EXPECTED_PING_HASH", "REMOTE_CONFIG_FETCH_TIMEOUT_SECONDS", "", "REMOTE_CONFIG_TASK_TIMEOUT_SECONDS", "REMOTE_CONFIG_FETCH_ATTEMPTS", "", "REMOTE_CONFIG_RETRY_DELAY_MS", "connection-resolver"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FirebaseServerHandlerKt {
    private static final String EXPECTED_PING_HASH = "5aa4731d5d84e09e2f7e7141e560104f";
    private static final int REMOTE_CONFIG_FETCH_ATTEMPTS = 2;
    private static final long REMOTE_CONFIG_FETCH_TIMEOUT_SECONDS = 15;
    private static final long REMOTE_CONFIG_RETRY_DELAY_MS = 1000;
    private static final long REMOTE_CONFIG_TASK_TIMEOUT_SECONDS = 20;
    private static final String TAG = "FirebaseSrvHandler";
}
