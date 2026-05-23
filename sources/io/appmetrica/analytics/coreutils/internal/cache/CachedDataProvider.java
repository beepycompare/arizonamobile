package io.appmetrica.analytics.coreutils.internal.cache;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public interface CachedDataProvider {

    /* loaded from: classes5.dex */
    public static class CachedData<T> {
        private final String b;
        private volatile long c;
        private volatile long d;
        private long e = 0;
        private Object f = null;

        /* renamed from: a  reason: collision with root package name */
        private final SystemTimeProvider f352a = new SystemTimeProvider();

        public CachedData(long j, long j2, String str) {
            this.b = String.format("[CachedData-%s]", str);
            this.c = j;
            this.d = j2;
        }

        public T getData() {
            return (T) this.f;
        }

        public long getExpiryTime() {
            return this.d;
        }

        public long getRefreshTime() {
            return this.c;
        }

        public final boolean isEmpty() {
            return this.f == null;
        }

        public void setData(T t) {
            this.f = t;
            this.e = this.f352a.currentTimeMillis();
        }

        public void setExpirationPolicy(long j, long j2) {
            this.c = j;
            this.d = j2;
        }

        public final boolean shouldClearData() {
            if (this.e == 0) {
                return false;
            }
            long currentTimeMillis = this.f352a.currentTimeMillis() - this.e;
            return currentTimeMillis > this.d || currentTimeMillis < 0;
        }

        public final boolean shouldUpdateData() {
            long currentTimeMillis = this.f352a.currentTimeMillis() - this.e;
            return currentTimeMillis > this.c || currentTimeMillis < 0;
        }

        public String toString() {
            return "CachedData{tag='" + this.b + "', refreshTime=" + this.c + ", expiryTime=" + this.d + ", mCachedTime=" + this.e + ", mCachedData=" + this.f + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
