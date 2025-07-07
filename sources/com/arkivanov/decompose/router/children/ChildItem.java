package com.arkivanov.decompose.router.children;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.backhandler.ChildBackHandler;
import com.arkivanov.essenty.instancekeeper.InstanceKeeperDispatcher;
import com.arkivanov.essenty.lifecycle.LifecycleRegistry;
import com.arkivanov.essenty.statekeeper.SerializableContainer;
import com.arkivanov.essenty.statekeeper.StateKeeperDispatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ChildItem.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0001\u0010\u0003 \u0001*\u00020\u00022\u00020\u0002:\u0002\t\nR\u0012\u0010\u0004\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00018\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0082\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lcom/arkivanov/decompose/router/children/ChildItem;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "configuration", "getConfiguration", "()Ljava/lang/Object;", "instance", "getInstance", "Created", "Destroyed", "Lcom/arkivanov/decompose/router/children/ChildItem$Created;", "Lcom/arkivanov/decompose/router/children/ChildItem$Destroyed;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ChildItem<C, T> {
    C getConfiguration();

    T getInstance();

    /* compiled from: ChildItem.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\n\b\u0002\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0003\u0010\u0003 \u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B7\u0012\u0006\u0010\u0005\u001a\u00028\u0002\u0012\u0006\u0010\u0006\u001a\u00028\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u001d\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000e\u0010\u001e\u001a\u00028\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J\t\u0010\"\u001a\u00020\u000eHÆ\u0003JV\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u00022\b\b\u0002\u0010\u0006\u001a\u00028\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u0016\u0010\u0005\u001a\u00028\u0002X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00028\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/arkivanov/decompose/router/children/ChildItem$Created;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/arkivanov/decompose/router/children/ChildItem;", "configuration", "instance", "lifecycleRegistry", "Lcom/arkivanov/essenty/lifecycle/LifecycleRegistry;", "stateKeeperDispatcher", "Lcom/arkivanov/essenty/statekeeper/StateKeeperDispatcher;", "instanceKeeperDispatcher", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperDispatcher;", "backHandler", "Lcom/arkivanov/decompose/backhandler/ChildBackHandler;", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Lcom/arkivanov/essenty/lifecycle/LifecycleRegistry;Lcom/arkivanov/essenty/statekeeper/StateKeeperDispatcher;Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperDispatcher;Lcom/arkivanov/decompose/backhandler/ChildBackHandler;)V", "getConfiguration", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getInstance", "getLifecycleRegistry", "()Lcom/arkivanov/essenty/lifecycle/LifecycleRegistry;", "getStateKeeperDispatcher", "()Lcom/arkivanov/essenty/statekeeper/StateKeeperDispatcher;", "getInstanceKeeperDispatcher", "()Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperDispatcher;", "getBackHandler", "()Lcom/arkivanov/decompose/backhandler/ChildBackHandler;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Lcom/arkivanov/essenty/lifecycle/LifecycleRegistry;Lcom/arkivanov/essenty/statekeeper/StateKeeperDispatcher;Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperDispatcher;Lcom/arkivanov/decompose/backhandler/ChildBackHandler;)Lcom/arkivanov/decompose/router/children/ChildItem$Created;", "equals", "", "other", "hashCode", "", "toString", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Created<C, T> implements ChildItem<C, T> {
        private final ChildBackHandler backHandler;
        private final C configuration;
        private final T instance;
        private final InstanceKeeperDispatcher instanceKeeperDispatcher;
        private final LifecycleRegistry lifecycleRegistry;
        private final StateKeeperDispatcher stateKeeperDispatcher;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Created copy$default(Created created, Object obj, Object obj2, LifecycleRegistry lifecycleRegistry, StateKeeperDispatcher stateKeeperDispatcher, InstanceKeeperDispatcher instanceKeeperDispatcher, ChildBackHandler childBackHandler, int i, Object obj3) {
            C c = obj;
            if ((i & 1) != 0) {
                c = created.configuration;
            }
            T t = obj2;
            if ((i & 2) != 0) {
                t = created.instance;
            }
            if ((i & 4) != 0) {
                lifecycleRegistry = created.lifecycleRegistry;
            }
            if ((i & 8) != 0) {
                stateKeeperDispatcher = created.stateKeeperDispatcher;
            }
            if ((i & 16) != 0) {
                instanceKeeperDispatcher = created.instanceKeeperDispatcher;
            }
            if ((i & 32) != 0) {
                childBackHandler = created.backHandler;
            }
            InstanceKeeperDispatcher instanceKeeperDispatcher2 = instanceKeeperDispatcher;
            ChildBackHandler childBackHandler2 = childBackHandler;
            return created.copy(c, t, lifecycleRegistry, stateKeeperDispatcher, instanceKeeperDispatcher2, childBackHandler2);
        }

        public final C component1() {
            return this.configuration;
        }

        public final T component2() {
            return this.instance;
        }

        public final LifecycleRegistry component3() {
            return this.lifecycleRegistry;
        }

        public final StateKeeperDispatcher component4() {
            return this.stateKeeperDispatcher;
        }

        public final InstanceKeeperDispatcher component5() {
            return this.instanceKeeperDispatcher;
        }

        public final ChildBackHandler component6() {
            return this.backHandler;
        }

        public final Created<C, T> copy(C configuration, T instance, LifecycleRegistry lifecycleRegistry, StateKeeperDispatcher stateKeeperDispatcher, InstanceKeeperDispatcher instanceKeeperDispatcher, ChildBackHandler backHandler) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            Intrinsics.checkNotNullParameter(instance, "instance");
            Intrinsics.checkNotNullParameter(lifecycleRegistry, "lifecycleRegistry");
            Intrinsics.checkNotNullParameter(stateKeeperDispatcher, "stateKeeperDispatcher");
            Intrinsics.checkNotNullParameter(instanceKeeperDispatcher, "instanceKeeperDispatcher");
            Intrinsics.checkNotNullParameter(backHandler, "backHandler");
            return new Created<>(configuration, instance, lifecycleRegistry, stateKeeperDispatcher, instanceKeeperDispatcher, backHandler);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Created) {
                Created created = (Created) obj;
                return Intrinsics.areEqual(this.configuration, created.configuration) && Intrinsics.areEqual(this.instance, created.instance) && Intrinsics.areEqual(this.lifecycleRegistry, created.lifecycleRegistry) && Intrinsics.areEqual(this.stateKeeperDispatcher, created.stateKeeperDispatcher) && Intrinsics.areEqual(this.instanceKeeperDispatcher, created.instanceKeeperDispatcher) && Intrinsics.areEqual(this.backHandler, created.backHandler);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((this.configuration.hashCode() * 31) + this.instance.hashCode()) * 31) + this.lifecycleRegistry.hashCode()) * 31) + this.stateKeeperDispatcher.hashCode()) * 31) + this.instanceKeeperDispatcher.hashCode()) * 31) + this.backHandler.hashCode();
        }

        public String toString() {
            return "Created(configuration=" + this.configuration + ", instance=" + this.instance + ", lifecycleRegistry=" + this.lifecycleRegistry + ", stateKeeperDispatcher=" + this.stateKeeperDispatcher + ", instanceKeeperDispatcher=" + this.instanceKeeperDispatcher + ", backHandler=" + this.backHandler + ')';
        }

        public Created(C configuration, T instance, LifecycleRegistry lifecycleRegistry, StateKeeperDispatcher stateKeeperDispatcher, InstanceKeeperDispatcher instanceKeeperDispatcher, ChildBackHandler backHandler) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            Intrinsics.checkNotNullParameter(instance, "instance");
            Intrinsics.checkNotNullParameter(lifecycleRegistry, "lifecycleRegistry");
            Intrinsics.checkNotNullParameter(stateKeeperDispatcher, "stateKeeperDispatcher");
            Intrinsics.checkNotNullParameter(instanceKeeperDispatcher, "instanceKeeperDispatcher");
            Intrinsics.checkNotNullParameter(backHandler, "backHandler");
            this.configuration = configuration;
            this.instance = instance;
            this.lifecycleRegistry = lifecycleRegistry;
            this.stateKeeperDispatcher = stateKeeperDispatcher;
            this.instanceKeeperDispatcher = instanceKeeperDispatcher;
            this.backHandler = backHandler;
        }

        @Override // com.arkivanov.decompose.router.children.ChildItem
        public C getConfiguration() {
            return this.configuration;
        }

        @Override // com.arkivanov.decompose.router.children.ChildItem
        public T getInstance() {
            return this.instance;
        }

        public final LifecycleRegistry getLifecycleRegistry() {
            return this.lifecycleRegistry;
        }

        public final StateKeeperDispatcher getStateKeeperDispatcher() {
            return this.stateKeeperDispatcher;
        }

        public final InstanceKeeperDispatcher getInstanceKeeperDispatcher() {
            return this.instanceKeeperDispatcher;
        }

        public final ChildBackHandler getBackHandler() {
            return this.backHandler;
        }
    }

    /* compiled from: ChildItem.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\n\b\u0002\u0010\u0001 \u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003B\u001b\u0012\u0006\u0010\u0005\u001a\u00028\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0012\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0005\u001a\u00028\u0002X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/arkivanov/decompose/router/children/ChildItem$Destroyed;", "C", "", "Lcom/arkivanov/decompose/router/children/ChildItem;", "", "configuration", "savedState", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "<init>", "(Ljava/lang/Object;Lcom/arkivanov/essenty/statekeeper/SerializableContainer;)V", "getConfiguration", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSavedState", "()Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "instance", "getInstance", "()Ljava/lang/Void;", "component1", "component2", "copy", "(Ljava/lang/Object;Lcom/arkivanov/essenty/statekeeper/SerializableContainer;)Lcom/arkivanov/decompose/router/children/ChildItem$Destroyed;", "equals", "", "other", "hashCode", "", "toString", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Destroyed<C> implements ChildItem {
        private final C configuration;
        private final Void instance;
        private final SerializableContainer savedState;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Destroyed copy$default(Destroyed destroyed, Object obj, SerializableContainer serializableContainer, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = destroyed.configuration;
            }
            if ((i & 2) != 0) {
                serializableContainer = destroyed.savedState;
            }
            return destroyed.copy(obj, serializableContainer);
        }

        public final C component1() {
            return this.configuration;
        }

        public final SerializableContainer component2() {
            return this.savedState;
        }

        public final Destroyed<C> copy(C configuration, SerializableContainer serializableContainer) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            return new Destroyed<>(configuration, serializableContainer);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Destroyed) {
                Destroyed destroyed = (Destroyed) obj;
                return Intrinsics.areEqual(this.configuration, destroyed.configuration) && Intrinsics.areEqual(this.savedState, destroyed.savedState);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.configuration.hashCode() * 31;
            SerializableContainer serializableContainer = this.savedState;
            return hashCode + (serializableContainer == null ? 0 : serializableContainer.hashCode());
        }

        public String toString() {
            return "Destroyed(configuration=" + this.configuration + ", savedState=" + this.savedState + ')';
        }

        public Destroyed(C configuration, SerializableContainer serializableContainer) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            this.configuration = configuration;
            this.savedState = serializableContainer;
        }

        public /* synthetic */ Destroyed(Object obj, SerializableContainer serializableContainer, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i & 2) != 0 ? null : serializableContainer);
        }

        @Override // com.arkivanov.decompose.router.children.ChildItem
        public C getConfiguration() {
            return this.configuration;
        }

        public final SerializableContainer getSavedState() {
            return this.savedState;
        }

        @Override // com.arkivanov.decompose.router.children.ChildItem
        public Void getInstance() {
            return this.instance;
        }
    }
}
