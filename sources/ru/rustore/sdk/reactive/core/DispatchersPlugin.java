package ru.rustore.sdk.reactive.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
/* compiled from: DispatchersPlugin.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R*\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lru/rustore/sdk/reactive/core/DispatchersPlugin;", "", "()V", "value", "Lru/rustore/sdk/reactive/core/Dispatcher;", "io", "getIo", "()Lru/rustore/sdk/reactive/core/Dispatcher;", "setIo", "(Lru/rustore/sdk/reactive/core/Dispatcher;)V", JvmProtoBufUtil.DEFAULT_MODULE_NAME, "getMain", "setMain", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DispatchersPlugin {
    public static final DispatchersPlugin INSTANCE = new DispatchersPlugin();

    /* renamed from: io  reason: collision with root package name */
    private static Dispatcher f1607io;
    private static Dispatcher main;

    private DispatchersPlugin() {
    }

    public final Dispatcher getMain() {
        Dispatcher dispatcher;
        synchronized (this) {
            dispatcher = main;
        }
        return dispatcher;
    }

    public final void setMain(Dispatcher dispatcher) {
        synchronized (this) {
            main = dispatcher;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final Dispatcher getIo() {
        Dispatcher dispatcher;
        synchronized (this) {
            dispatcher = f1607io;
        }
        return dispatcher;
    }

    public final void setIo(Dispatcher dispatcher) {
        synchronized (this) {
            f1607io = dispatcher;
            Unit unit = Unit.INSTANCE;
        }
    }
}
