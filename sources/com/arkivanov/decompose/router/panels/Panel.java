package com.arkivanov.decompose.router.panels;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChildPanelsFactory.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0001\u0010\u0003 \u0001*\u00020\u0002*\n\b\u0002\u0010\u0004 \u0001*\u00020\u0002*\n\b\u0003\u0010\u0005 \u0001*\u00020\u0002*\n\b\u0004\u0010\u0006 \u0001*\u00020\u0002*\n\b\u0005\u0010\u0007 \u0001*\u00020\u00022\u00020\u0002:\u0003\b\t\n\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/arkivanov/decompose/router/panels/Panel;", "MC", "", "MT", "DC", "DT", "EC", "ET", "Main", "Details", "Extra", "Lcom/arkivanov/decompose/router/panels/Panel$Details;", "Lcom/arkivanov/decompose/router/panels/Panel$Extra;", "Lcom/arkivanov/decompose/router/panels/Panel$Main;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface Panel<MC, MT, DC, DT, EC, ET> {

    /* compiled from: ChildPanelsFactory.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\n\b\u0006\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0007\u0010\u0003 \u0001*\u00020\u00022&\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004B\u0017\u0012\u0006\u0010\u0006\u001a\u00028\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000e\u001a\u00028\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u000f\u001a\u00028\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ.\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u00070\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u00062\b\b\u0002\u0010\u0007\u001a\u00028\u0007HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0006\u001a\u00028\u0006¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u00028\u0007¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/arkivanov/decompose/router/panels/Panel$Main;", "MC", "", "MT", "Lcom/arkivanov/decompose/router/panels/Panel;", "", "config", "instance", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getConfig", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getInstance", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/arkivanov/decompose/router/panels/Panel$Main;", "equals", "", "other", "hashCode", "", "toString", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Main<MC, MT> implements Panel {
        private final MC config;
        private final MT instance;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Main copy$default(Main main, Object obj, Object obj2, int i, Object obj3) {
            if ((i & 1) != 0) {
                obj = main.config;
            }
            if ((i & 2) != 0) {
                obj2 = main.instance;
            }
            return main.copy(obj, obj2);
        }

        public final MC component1() {
            return this.config;
        }

        public final MT component2() {
            return this.instance;
        }

        public final Main<MC, MT> copy(MC config, MT instance) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(instance, "instance");
            return new Main<>(config, instance);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Main) {
                Main main = (Main) obj;
                return Intrinsics.areEqual(this.config, main.config) && Intrinsics.areEqual(this.instance, main.instance);
            }
            return false;
        }

        public int hashCode() {
            return (this.config.hashCode() * 31) + this.instance.hashCode();
        }

        public String toString() {
            return "Main(config=" + this.config + ", instance=" + this.instance + ')';
        }

        public Main(MC config, MT instance) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(instance, "instance");
            this.config = config;
            this.instance = instance;
        }

        public final MC getConfig() {
            return this.config;
        }

        public final MT getInstance() {
            return this.instance;
        }
    }

    /* compiled from: ChildPanelsFactory.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\n\b\u0006\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0007\u0010\u0003 \u0001*\u00020\u00022&\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004B\u0017\u0012\u0006\u0010\u0006\u001a\u00028\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000e\u001a\u00028\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u000f\u001a\u00028\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ.\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u00070\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u00062\b\b\u0002\u0010\u0007\u001a\u00028\u0007HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0006\u001a\u00028\u0006¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u00028\u0007¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/arkivanov/decompose/router/panels/Panel$Details;", "DC", "", "DT", "Lcom/arkivanov/decompose/router/panels/Panel;", "", "config", "instance", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getConfig", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getInstance", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/arkivanov/decompose/router/panels/Panel$Details;", "equals", "", "other", "hashCode", "", "toString", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Details<DC, DT> implements Panel {
        private final DC config;
        private final DT instance;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Details copy$default(Details details, Object obj, Object obj2, int i, Object obj3) {
            if ((i & 1) != 0) {
                obj = details.config;
            }
            if ((i & 2) != 0) {
                obj2 = details.instance;
            }
            return details.copy(obj, obj2);
        }

        public final DC component1() {
            return this.config;
        }

        public final DT component2() {
            return this.instance;
        }

        public final Details<DC, DT> copy(DC config, DT instance) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(instance, "instance");
            return new Details<>(config, instance);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Details) {
                Details details = (Details) obj;
                return Intrinsics.areEqual(this.config, details.config) && Intrinsics.areEqual(this.instance, details.instance);
            }
            return false;
        }

        public int hashCode() {
            return (this.config.hashCode() * 31) + this.instance.hashCode();
        }

        public String toString() {
            return "Details(config=" + this.config + ", instance=" + this.instance + ')';
        }

        public Details(DC config, DT instance) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(instance, "instance");
            this.config = config;
            this.instance = instance;
        }

        public final DC getConfig() {
            return this.config;
        }

        public final DT getInstance() {
            return this.instance;
        }
    }

    /* compiled from: ChildPanelsFactory.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\n\b\u0006\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0007\u0010\u0003 \u0001*\u00020\u00022&\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\u0017\u0012\u0006\u0010\u0006\u001a\u00028\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000e\u001a\u00028\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u000f\u001a\u00028\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ.\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u00070\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u00062\b\b\u0002\u0010\u0007\u001a\u00028\u0007HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0006\u001a\u00028\u0006¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u00028\u0007¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/arkivanov/decompose/router/panels/Panel$Extra;", "EC", "", "ET", "Lcom/arkivanov/decompose/router/panels/Panel;", "", "config", "instance", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getConfig", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getInstance", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/arkivanov/decompose/router/panels/Panel$Extra;", "equals", "", "other", "hashCode", "", "toString", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Extra<EC, ET> implements Panel {
        private final EC config;
        private final ET instance;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Extra copy$default(Extra extra, Object obj, Object obj2, int i, Object obj3) {
            if ((i & 1) != 0) {
                obj = extra.config;
            }
            if ((i & 2) != 0) {
                obj2 = extra.instance;
            }
            return extra.copy(obj, obj2);
        }

        public final EC component1() {
            return this.config;
        }

        public final ET component2() {
            return this.instance;
        }

        public final Extra<EC, ET> copy(EC config, ET instance) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(instance, "instance");
            return new Extra<>(config, instance);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Extra) {
                Extra extra = (Extra) obj;
                return Intrinsics.areEqual(this.config, extra.config) && Intrinsics.areEqual(this.instance, extra.instance);
            }
            return false;
        }

        public int hashCode() {
            return (this.config.hashCode() * 31) + this.instance.hashCode();
        }

        public String toString() {
            return "Extra(config=" + this.config + ", instance=" + this.instance + ')';
        }

        public Extra(EC config, ET instance) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(instance, "instance");
            this.config = config;
            this.instance = instance;
        }

        public final EC getConfig() {
            return this.config;
        }

        public final ET getInstance() {
            return this.instance;
        }
    }
}
