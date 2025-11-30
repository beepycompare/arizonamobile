package io.appmetrica.analytics.networktasks.internal;

import androidx.media3.exoplayer.upstream.CmcdData;
import io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lio/appmetrica/analytics/networktasks/internal/NetworkServiceLocator;", "Lio/appmetrica/analytics/networktasks/internal/NetworkServiceLifecycleObserver;", "", "onCreate", "onDestroy", "Lio/appmetrica/analytics/networktasks/internal/NetworkCore;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lio/appmetrica/analytics/networktasks/internal/NetworkCore;", "getNetworkCore", "()Lio/appmetrica/analytics/networktasks/internal/NetworkCore;", "networkCore", "Lio/appmetrica/analytics/coreapi/internal/io/IExecutionPolicy;", "executionPolicy", "<init>", "(Lio/appmetrica/analytics/coreapi/internal/io/IExecutionPolicy;)V", "Companion", "network-tasks_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class NetworkServiceLocator implements NetworkServiceLifecycleObserver {
    public static final Companion Companion = new Companion(null);
    private static volatile NetworkServiceLocator b;

    /* renamed from: a  reason: collision with root package name */
    private final NetworkCore f1303a;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0007R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/appmetrica/analytics/networktasks/internal/NetworkServiceLocator$Companion;", "", "Lio/appmetrica/analytics/networktasks/internal/NetworkServiceLocator;", "getInstance", "Lio/appmetrica/analytics/coreapi/internal/io/IExecutionPolicy;", "executionPolicy", "", "init", "networkServiceLocator", "instance", "Lio/appmetrica/analytics/networktasks/internal/NetworkServiceLocator;", "network-tasks_release"}, k = 1, mv = {1, 6, 0})
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final NetworkServiceLocator getInstance() {
            NetworkServiceLocator networkServiceLocator = NetworkServiceLocator.b;
            if (networkServiceLocator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("instance");
                return null;
            }
            return networkServiceLocator;
        }

        @JvmStatic
        public final void init(IExecutionPolicy iExecutionPolicy) {
            if (NetworkServiceLocator.b == null) {
                synchronized (NetworkServiceLocator.class) {
                    if (NetworkServiceLocator.b == null) {
                        NetworkServiceLocator.b = new NetworkServiceLocator(iExecutionPolicy);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        private Companion() {
        }

        @JvmStatic
        public final void init(NetworkServiceLocator networkServiceLocator) {
            NetworkServiceLocator.b = networkServiceLocator;
        }
    }

    public NetworkServiceLocator(IExecutionPolicy iExecutionPolicy) {
        NetworkCore networkCore = new NetworkCore(iExecutionPolicy);
        networkCore.setName("IAA-NC");
        networkCore.start();
        this.f1303a = networkCore;
    }

    @JvmStatic
    public static final NetworkServiceLocator getInstance() {
        return Companion.getInstance();
    }

    @JvmStatic
    public static final void init(IExecutionPolicy iExecutionPolicy) {
        Companion.init(iExecutionPolicy);
    }

    public final NetworkCore getNetworkCore() {
        return this.f1303a;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.NetworkServiceLifecycleObserver
    public void onCreate() {
    }

    @Override // io.appmetrica.analytics.networktasks.internal.NetworkServiceLifecycleObserver
    public void onDestroy() {
        this.f1303a.stopTasks();
    }

    @JvmStatic
    public static final void init(NetworkServiceLocator networkServiceLocator) {
        Companion.init(networkServiceLocator);
    }
}
