package com.google.firebase.sessions;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
/* compiled from: TimeProvider.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/google/firebase/sessions/TimeProviderImpl;", "Lcom/google/firebase/sessions/TimeProvider;", "()V", "US_PER_MILLIS", "", "currentTimeUs", "elapsedRealtime", "Lkotlin/time/Duration;", "elapsedRealtime-UwyO8pc", "()J", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TimeProviderImpl implements TimeProvider {
    public static final TimeProviderImpl INSTANCE = new TimeProviderImpl();
    private static final long US_PER_MILLIS = 1000;

    private TimeProviderImpl() {
    }

    @Override // com.google.firebase.sessions.TimeProvider
    /* renamed from: elapsedRealtime-UwyO8pc */
    public long mo8291elapsedRealtimeUwyO8pc() {
        Duration.Companion companion = Duration.Companion;
        return DurationKt.toDuration(SystemClock.elapsedRealtime(), DurationUnit.MILLISECONDS);
    }

    @Override // com.google.firebase.sessions.TimeProvider
    public long currentTimeUs() {
        return System.currentTimeMillis() * 1000;
    }
}
