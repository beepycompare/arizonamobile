package com.arkivanov.essenty.instancekeeper;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
/* compiled from: InstanceKeeper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\t\nJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0001H&J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0003H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0001H&¨\u0006\u000b"}, d2 = {"Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "", "get", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper$Instance;", "key", "put", "", "instance", "remove", "Instance", "SimpleInstance", "instance-keeper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface InstanceKeeper {

    /* compiled from: InstanceKeeper.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper$Instance;", "", "onDestroy", "", "instance-keeper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface Instance {

        /* compiled from: InstanceKeeper.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class DefaultImpls {
            public static void onDestroy(Instance instance) {
            }
        }

        void onDestroy();
    }

    Instance get(Object obj);

    void put(Object obj, Instance instance);

    Instance remove(Object obj);

    /* compiled from: InstanceKeeper.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper$SimpleInstance;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper$Instance;", "instance", "<init>", "(Ljava/lang/Object;)V", "getInstance", "()Ljava/lang/Object;", "Ljava/lang/Object;", "instance-keeper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class SimpleInstance<T> implements Instance {
        private final T instance;

        public SimpleInstance(T t) {
            this.instance = t;
        }

        public final T getInstance() {
            return this.instance;
        }

        @Override // com.arkivanov.essenty.instancekeeper.InstanceKeeper.Instance
        public void onDestroy() {
            Instance.DefaultImpls.onDestroy(this);
        }
    }
}
