package com.arkivanov.essenty.instancekeeper;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.essenty.instancekeeper.InstanceKeeper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InstanceKeeperExt.kt */
@Metadata(d1 = {"\u00000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a5\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\b\u001a/\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\t\u001a=\u0010\n\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001\u0018\u0001*\u00060\u000bj\u0002`\f*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\r\u001a7\u0010\u000e\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a/\u0010\u000e\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u000f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a=\u0010\u0012\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001\u0018\u0001*\u00060\u000bj\u0002`\f*\u00020\u000f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a1\u0010\u0014\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a+\u0010\u0014\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a3\u0010\u0017\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a+\u0010\u0017\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u000f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0019\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001a"}, d2 = {"getOrCreate", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper$Instance;", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "key", "", "factory", "Lkotlin/Function0;", "(Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper$Instance;", "(Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;Lkotlin/jvm/functions/Function0;)Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper$Instance;", "getOrCreateCloseable", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "(Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/AutoCloseable;", "retainedInstance", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperOwner;", "(Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperOwner;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper$Instance;", "(Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperOwner;Lkotlin/jvm/functions/Function0;)Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper$Instance;", "retainedCloseable", "(Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperOwner;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/AutoCloseable;", "getOrCreateSimple", "(Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "retainedSimpleInstance", "(Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperOwner;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperOwner;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "instance-keeper_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InstanceKeeperExtKt {
    public static final <T extends InstanceKeeper.Instance> T getOrCreate(InstanceKeeper instanceKeeper, Object key, Function0<? extends T> factory) {
        Intrinsics.checkNotNullParameter(instanceKeeper, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(factory, "factory");
        T t = (T) instanceKeeper.get(key);
        if (t == null) {
            T invoke = factory.invoke();
            instanceKeeper.put(key, invoke);
            return invoke;
        }
        return t;
    }

    public static final /* synthetic */ <T extends InstanceKeeper.Instance> T getOrCreate(InstanceKeeper instanceKeeper, Function0<? extends T> factory) {
        Intrinsics.checkNotNullParameter(instanceKeeper, "<this>");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        T t = (T) instanceKeeper.get(null);
        if (t == null) {
            T invoke = factory.invoke();
            instanceKeeper.put(null, invoke);
            return invoke;
        }
        return t;
    }

    public static /* synthetic */ AutoCloseable getOrCreateCloseable$default(InstanceKeeper instanceKeeper, Object key, Function0 factory, int i, Object obj) {
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            key = null;
        }
        Intrinsics.checkNotNullParameter(instanceKeeper, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(factory, "factory");
        InstanceKeeperExtKt$getOrCreateCloseable$1$1 instanceKeeperExtKt$getOrCreateCloseable$1$1 = instanceKeeper.get(key);
        if (instanceKeeperExtKt$getOrCreateCloseable$1$1 == null) {
            instanceKeeperExtKt$getOrCreateCloseable$1$1 = new InstanceKeeperExtKt$getOrCreateCloseable$1$1((AutoCloseable) factory.invoke());
            instanceKeeper.put(key, instanceKeeperExtKt$getOrCreateCloseable$1$1);
        }
        return ((InstanceKeeperExtKt$getOrCreateCloseable$1$1) instanceKeeperExtKt$getOrCreateCloseable$1$1).getInstance();
    }

    public static final /* synthetic */ <T extends InstanceKeeper.Instance> T retainedInstance(InstanceKeeperOwner instanceKeeperOwner, Object key, Function0<? extends T> factory) {
        Intrinsics.checkNotNullParameter(instanceKeeperOwner, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(factory, "factory");
        InstanceKeeper instanceKeeper = instanceKeeperOwner.getInstanceKeeper();
        T t = (T) instanceKeeper.get(key);
        if (t == null) {
            T invoke = factory.invoke();
            instanceKeeper.put(key, invoke);
            return invoke;
        }
        return t;
    }

    public static final /* synthetic */ <T extends InstanceKeeper.Instance> T retainedInstance(InstanceKeeperOwner instanceKeeperOwner, Function0<? extends T> factory) {
        Intrinsics.checkNotNullParameter(instanceKeeperOwner, "<this>");
        Intrinsics.checkNotNullParameter(factory, "factory");
        InstanceKeeper instanceKeeper = instanceKeeperOwner.getInstanceKeeper();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        T t = (T) instanceKeeper.get(null);
        if (t == null) {
            T invoke = factory.invoke();
            instanceKeeper.put(null, invoke);
            return invoke;
        }
        return t;
    }

    public static /* synthetic */ AutoCloseable retainedCloseable$default(InstanceKeeperOwner instanceKeeperOwner, Object key, Function0 factory, int i, Object obj) {
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            key = null;
        }
        Intrinsics.checkNotNullParameter(instanceKeeperOwner, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(factory, "factory");
        InstanceKeeper instanceKeeper = instanceKeeperOwner.getInstanceKeeper();
        InstanceKeeperExtKt$getOrCreateCloseable$1$1 instanceKeeperExtKt$getOrCreateCloseable$1$1 = instanceKeeper.get(key);
        if (instanceKeeperExtKt$getOrCreateCloseable$1$1 == null) {
            instanceKeeperExtKt$getOrCreateCloseable$1$1 = new InstanceKeeperExtKt$getOrCreateCloseable$1$1((AutoCloseable) factory.invoke());
            instanceKeeper.put(key, instanceKeeperExtKt$getOrCreateCloseable$1$1);
        }
        return ((InstanceKeeperExtKt$getOrCreateCloseable$1$1) instanceKeeperExtKt$getOrCreateCloseable$1$1).getInstance();
    }

    public static final /* synthetic */ <T extends AutoCloseable> T retainedCloseable(InstanceKeeperOwner instanceKeeperOwner, Object key, Function0<? extends T> factory) {
        Intrinsics.checkNotNullParameter(instanceKeeperOwner, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(factory, "factory");
        InstanceKeeper instanceKeeper = instanceKeeperOwner.getInstanceKeeper();
        InstanceKeeperExtKt$getOrCreateCloseable$1$1 instanceKeeperExtKt$getOrCreateCloseable$1$1 = instanceKeeper.get(key);
        if (instanceKeeperExtKt$getOrCreateCloseable$1$1 == null) {
            instanceKeeperExtKt$getOrCreateCloseable$1$1 = new InstanceKeeperExtKt$getOrCreateCloseable$1$1(factory.invoke());
            instanceKeeper.put(key, instanceKeeperExtKt$getOrCreateCloseable$1$1);
        }
        return (T) ((InstanceKeeperExtKt$getOrCreateCloseable$1$1) instanceKeeperExtKt$getOrCreateCloseable$1$1).getInstance();
    }

    public static final /* synthetic */ <T> T getOrCreateSimple(InstanceKeeper instanceKeeper, Function0<? extends T> factory) {
        Intrinsics.checkNotNullParameter(instanceKeeper, "<this>");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        InstanceKeeper.SimpleInstance simpleInstance = instanceKeeper.get(null);
        if (simpleInstance == null) {
            simpleInstance = new InstanceKeeper.SimpleInstance(factory.invoke());
            instanceKeeper.put(null, simpleInstance);
        }
        return (T) ((InstanceKeeper.SimpleInstance) simpleInstance).getInstance();
    }

    public static final /* synthetic */ <T> T retainedSimpleInstance(InstanceKeeperOwner instanceKeeperOwner, Object key, Function0<? extends T> factory) {
        Intrinsics.checkNotNullParameter(instanceKeeperOwner, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(factory, "factory");
        InstanceKeeper instanceKeeper = instanceKeeperOwner.getInstanceKeeper();
        InstanceKeeper.SimpleInstance simpleInstance = instanceKeeper.get(key);
        if (simpleInstance == null) {
            simpleInstance = new InstanceKeeper.SimpleInstance(factory.invoke());
            instanceKeeper.put(key, simpleInstance);
        }
        return (T) ((InstanceKeeper.SimpleInstance) simpleInstance).getInstance();
    }

    public static final /* synthetic */ <T> T retainedSimpleInstance(InstanceKeeperOwner instanceKeeperOwner, Function0<? extends T> factory) {
        Intrinsics.checkNotNullParameter(instanceKeeperOwner, "<this>");
        Intrinsics.checkNotNullParameter(factory, "factory");
        InstanceKeeper instanceKeeper = instanceKeeperOwner.getInstanceKeeper();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        InstanceKeeper.SimpleInstance simpleInstance = instanceKeeper.get(null);
        if (simpleInstance == null) {
            simpleInstance = new InstanceKeeper.SimpleInstance(factory.invoke());
            instanceKeeper.put(null, simpleInstance);
        }
        return (T) ((InstanceKeeper.SimpleInstance) simpleInstance).getInstance();
    }

    public static final /* synthetic */ <T extends AutoCloseable> T getOrCreateCloseable(InstanceKeeper instanceKeeper, Object key, Function0<? extends T> factory) {
        Intrinsics.checkNotNullParameter(instanceKeeper, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(factory, "factory");
        InstanceKeeperExtKt$getOrCreateCloseable$1$1 instanceKeeperExtKt$getOrCreateCloseable$1$1 = instanceKeeper.get(key);
        if (instanceKeeperExtKt$getOrCreateCloseable$1$1 == null) {
            instanceKeeperExtKt$getOrCreateCloseable$1$1 = new InstanceKeeperExtKt$getOrCreateCloseable$1$1(factory.invoke());
            instanceKeeper.put(key, instanceKeeperExtKt$getOrCreateCloseable$1$1);
        }
        return (T) ((InstanceKeeperExtKt$getOrCreateCloseable$1$1) instanceKeeperExtKt$getOrCreateCloseable$1$1).getInstance();
    }

    public static final <T> T getOrCreateSimple(InstanceKeeper instanceKeeper, Object key, Function0<? extends T> factory) {
        Intrinsics.checkNotNullParameter(instanceKeeper, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(factory, "factory");
        InstanceKeeper.SimpleInstance simpleInstance = instanceKeeper.get(key);
        if (simpleInstance == null) {
            simpleInstance = new InstanceKeeper.SimpleInstance(factory.invoke());
            instanceKeeper.put(key, simpleInstance);
        }
        return (T) ((InstanceKeeper.SimpleInstance) simpleInstance).getInstance();
    }
}
