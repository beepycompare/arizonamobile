package com.arkivanov.decompose;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Child.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0001\u0010\u0003 \u0001*\u00020\u00022\u00020\u0002:\u0002\u000e\u000fB\t\b\u0004¢\u0006\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00018\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\b\u0082\u0001\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/arkivanov/decompose/Child;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "<init>", "()V", "configuration", "getConfiguration", "()Ljava/lang/Object;", "instance", "getInstance", "key", "getKey$annotations", "getKey", "Created", "Destroyed", "Lcom/arkivanov/decompose/Child$Created;", "Lcom/arkivanov/decompose/Child$Destroyed;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class Child<C, T> {
    public /* synthetic */ Child(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ void getKey$annotations() {
    }

    public abstract C getConfiguration();

    public abstract T getInstance();

    public abstract Object getKey();

    private Child() {
    }

    /* compiled from: Child.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\n\b\u0002\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0003\u0010\u0003 \u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B!\b\u0007\u0012\u0006\u0010\u0005\u001a\u00028\u0002\u0012\u0006\u0010\u0006\u001a\u00028\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00028\u0002\u0012\u0006\u0010\u0006\u001a\u00028\u0003¢\u0006\u0004\b\b\u0010\nJ)\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00042\u0006\u0010\u0005\u001a\u00028\u00022\u0006\u0010\u0006\u001a\u00028\u0003H\u0007¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\fJ\u000e\u0010\u0015\u001a\u00028\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0002HÆ\u0003J8\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u00022\b\b\u0002\u0010\u0006\u001a\u00028\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0005\u001a\u00028\u0002X\u0096\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00028\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u0007\u001a\u00020\u00028\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/arkivanov/decompose/Child$Created;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/arkivanov/decompose/Child;", "configuration", "instance", "key", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getConfiguration", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getInstance", "getKey$annotations", "()V", "getKey", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/arkivanov/decompose/Child;", "component1", "component2", "component3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/arkivanov/decompose/Child$Created;", "equals", "", "other", "hashCode", "", "toString", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Created<C, T> extends Child<C, T> {
        private final C configuration;
        private final T instance;
        private final Object key;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Created copy$default(Created created, Object obj, Object obj2, Object obj3, int i, Object obj4) {
            if ((i & 1) != 0) {
                obj = created.configuration;
            }
            if ((i & 2) != 0) {
                obj2 = created.instance;
            }
            if ((i & 4) != 0) {
                obj3 = created.key;
            }
            return created.copy(obj, obj2, obj3);
        }

        public static /* synthetic */ void getKey$annotations() {
        }

        public final C component1() {
            return this.configuration;
        }

        public final T component2() {
            return this.instance;
        }

        public final Object component3() {
            return this.key;
        }

        public final Created<C, T> copy(C configuration, T instance, Object key) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            Intrinsics.checkNotNullParameter(instance, "instance");
            Intrinsics.checkNotNullParameter(key, "key");
            return new Created<>(configuration, instance, key);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Created) {
                Created created = (Created) obj;
                return Intrinsics.areEqual(this.configuration, created.configuration) && Intrinsics.areEqual(this.instance, created.instance) && Intrinsics.areEqual(this.key, created.key);
            }
            return false;
        }

        public int hashCode() {
            return (((this.configuration.hashCode() * 31) + this.instance.hashCode()) * 31) + this.key.hashCode();
        }

        public String toString() {
            return "Created(configuration=" + this.configuration + ", instance=" + this.instance + ", key=" + this.key + ')';
        }

        @Override // com.arkivanov.decompose.Child
        public C getConfiguration() {
            return this.configuration;
        }

        @Override // com.arkivanov.decompose.Child
        public T getInstance() {
            return this.instance;
        }

        @Override // com.arkivanov.decompose.Child
        public Object getKey() {
            return this.key;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Created(C configuration, T instance, Object key) {
            super(null);
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            Intrinsics.checkNotNullParameter(instance, "instance");
            Intrinsics.checkNotNullParameter(key, "key");
            this.configuration = configuration;
            this.instance = instance;
            this.key = key;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Created(C configuration, T instance) {
            this(configuration, instance, configuration);
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            Intrinsics.checkNotNullParameter(instance, "instance");
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "For binary compatibility")
        public final /* synthetic */ Child copy(Object configuration, Object instance) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            Intrinsics.checkNotNullParameter(instance, "instance");
            return copy$default(this, configuration, instance, null, 4, null);
        }
    }

    /* compiled from: Child.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\n\b\u0002\u0010\u0001 \u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003B\u0019\b\u0007\u0012\u0006\u0010\u0005\u001a\u00028\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00028\u0002¢\u0006\u0004\b\u0007\u0010\tJ!\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00028\u0002H\u0007¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0002HÆ\u0003J(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0005\u001a\u00028\u0002X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\u00020\u00028\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/arkivanov/decompose/Child$Destroyed;", "C", "", "Lcom/arkivanov/decompose/Child;", "", "configuration", "key", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "(Ljava/lang/Object;)V", "getConfiguration", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getKey$annotations", "()V", "getKey", "instance", "getInstance", "()Ljava/lang/Void;", "copy", "(Ljava/lang/Object;)Lcom/arkivanov/decompose/Child;", "component1", "component2", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/arkivanov/decompose/Child$Destroyed;", "equals", "", "other", "hashCode", "", "toString", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Destroyed<C> extends Child {
        private final C configuration;
        private final Void instance;
        private final Object key;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Destroyed copy$default(Destroyed destroyed, Object obj, Object obj2, int i, Object obj3) {
            if ((i & 1) != 0) {
                obj = destroyed.configuration;
            }
            if ((i & 2) != 0) {
                obj2 = destroyed.key;
            }
            return destroyed.copy(obj, obj2);
        }

        public static /* synthetic */ void getKey$annotations() {
        }

        public final C component1() {
            return this.configuration;
        }

        public final Object component2() {
            return this.key;
        }

        public final Destroyed<C> copy(C configuration, Object key) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            Intrinsics.checkNotNullParameter(key, "key");
            return new Destroyed<>(configuration, key);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Destroyed) {
                Destroyed destroyed = (Destroyed) obj;
                return Intrinsics.areEqual(this.configuration, destroyed.configuration) && Intrinsics.areEqual(this.key, destroyed.key);
            }
            return false;
        }

        public int hashCode() {
            return (this.configuration.hashCode() * 31) + this.key.hashCode();
        }

        public String toString() {
            return "Destroyed(configuration=" + this.configuration + ", key=" + this.key + ')';
        }

        @Override // com.arkivanov.decompose.Child
        public C getConfiguration() {
            return this.configuration;
        }

        @Override // com.arkivanov.decompose.Child
        public Object getKey() {
            return this.key;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Destroyed(C configuration, Object key) {
            super(null);
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            Intrinsics.checkNotNullParameter(key, "key");
            this.configuration = configuration;
            this.key = key;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Destroyed(C configuration) {
            this(configuration, configuration);
            Intrinsics.checkNotNullParameter(configuration, "configuration");
        }

        @Override // com.arkivanov.decompose.Child
        public Void getInstance() {
            return this.instance;
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "For binary compatibility")
        public final /* synthetic */ Child copy(Object configuration) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            return copy$default(this, configuration, null, 2, null);
        }
    }
}
