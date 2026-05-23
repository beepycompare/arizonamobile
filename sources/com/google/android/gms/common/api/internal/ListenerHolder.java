package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
public final class ListenerHolder<L> {
    private final Executor zaa;
    private volatile ListenerKey zab;

    /* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
    /* loaded from: classes4.dex */
    public static final class ListenerKey<L> {
        private final Object zaa;
        private final String zab;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ListenerKey(L l, String str) {
            this.zaa = l;
            this.zab = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ListenerKey) {
                ListenerKey listenerKey = (ListenerKey) obj;
                return this.zaa == listenerKey.zaa && this.zab.equals(listenerKey.zab);
            }
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.zaa) * 31) + this.zab.hashCode();
        }

        public String toIdString() {
            int identityHashCode = System.identityHashCode(this.zaa);
            String str = this.zab;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(identityHashCode).length());
            sb.append(str);
            sb.append("@");
            sb.append(identityHashCode);
            return sb.toString();
        }

        final /* synthetic */ Object zaa() {
            return this.zaa;
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
    /* loaded from: classes4.dex */
    public interface Notifier<L> {
        void notifyListener(L l);

        void onNotifyListenerFailed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListenerHolder(Looper looper, L l, String str) {
        this.zaa = new HandlerExecutor(looper);
        this.zab = new ListenerKey(Preconditions.checkNotNull(l, "Listener must not be null"), Preconditions.checkNotEmpty(str));
    }

    public void clear() {
        this.zab = null;
    }

    public ListenerKey<L> getListenerKey() {
        return this.zab;
    }

    public boolean hasListener() {
        return this.zab != null;
    }

    public void notifyListener(final Notifier<? super L> notifier) {
        Preconditions.checkNotNull(notifier, "Notifier must not be null");
        this.zaa.execute(new Runnable() { // from class: com.google.android.gms.common.api.internal.zabw
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                ListenerHolder.this.zaa(notifier);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void zaa(Notifier notifier) {
        ListenerKey listenerKey = this.zab;
        if (listenerKey == null) {
            notifier.onNotifyListenerFailed();
            return;
        }
        try {
            notifier.notifyListener(listenerKey.zaa());
        } catch (RuntimeException e) {
            notifier.onNotifyListenerFailed();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListenerHolder(Executor executor, L l, String str) {
        this.zaa = (Executor) Preconditions.checkNotNull(executor, "Executor must not be null");
        this.zab = new ListenerKey(Preconditions.checkNotNull(l, "Listener must not be null"), Preconditions.checkNotEmpty(str));
    }
}
