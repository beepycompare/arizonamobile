package com.arkivanov.decompose.router.panels;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChildPanelsFactory.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0001\u0010\u0003 \u0001*\u00020\u0002*\n\b\u0002\u0010\u0004 \u0001*\u00020\u00022\u00020\u0002:\u0003\u0005\u0006\u0007\u0082\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/arkivanov/decompose/router/panels/Config;", "MC", "", "DC", "EC", "Main", "Details", "Extra", "Lcom/arkivanov/decompose/router/panels/Config$Details;", "Lcom/arkivanov/decompose/router/panels/Config$Extra;", "Lcom/arkivanov/decompose/router/panels/Config$Main;", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface Config<MC, DC, EC> {

    /* compiled from: ChildPanelsFactory.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\n\b\u0003\u0010\u0001 \u0001*\u00020\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00028\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000b\u001a\u00028\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0005\u001a\u00028\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/arkivanov/decompose/router/panels/Config$Main;", "MC", "", "Lcom/arkivanov/decompose/router/panels/Config;", "", "config", "<init>", "(Ljava/lang/Object;)V", "getConfig", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/arkivanov/decompose/router/panels/Config$Main;", "equals", "", "other", "hashCode", "", "toString", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Main<MC> implements Config {
        private final MC config;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Main copy$default(Main main, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = main.config;
            }
            return main.copy(obj);
        }

        public final MC component1() {
            return this.config;
        }

        public final Main<MC> copy(MC config) {
            Intrinsics.checkNotNullParameter(config, "config");
            return new Main<>(config);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Main) && Intrinsics.areEqual(this.config, ((Main) obj).config);
        }

        public int hashCode() {
            return this.config.hashCode();
        }

        public String toString() {
            return "Main(config=" + this.config + ')';
        }

        public Main(MC config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.config = config;
        }

        public final MC getConfig() {
            return this.config;
        }
    }

    /* compiled from: ChildPanelsFactory.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\n\b\u0003\u0010\u0001 \u0001*\u00020\u00022\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00028\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000b\u001a\u00028\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0005\u001a\u00028\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/arkivanov/decompose/router/panels/Config$Details;", "DC", "", "Lcom/arkivanov/decompose/router/panels/Config;", "", "config", "<init>", "(Ljava/lang/Object;)V", "getConfig", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/arkivanov/decompose/router/panels/Config$Details;", "equals", "", "other", "hashCode", "", "toString", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Details<DC> implements Config {
        private final DC config;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Details copy$default(Details details, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = details.config;
            }
            return details.copy(obj);
        }

        public final DC component1() {
            return this.config;
        }

        public final Details<DC> copy(DC config) {
            Intrinsics.checkNotNullParameter(config, "config");
            return new Details<>(config);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Details) && Intrinsics.areEqual(this.config, ((Details) obj).config);
        }

        public int hashCode() {
            return this.config.hashCode();
        }

        public String toString() {
            return "Details(config=" + this.config + ')';
        }

        public Details(DC config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.config = config;
        }

        public final DC getConfig() {
            return this.config;
        }
    }

    /* compiled from: ChildPanelsFactory.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\n\b\u0003\u0010\u0001 \u0001*\u00020\u00022\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00028\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000b\u001a\u00028\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0005\u001a\u00028\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/arkivanov/decompose/router/panels/Config$Extra;", "EC", "", "Lcom/arkivanov/decompose/router/panels/Config;", "", "config", "<init>", "(Ljava/lang/Object;)V", "getConfig", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/arkivanov/decompose/router/panels/Config$Extra;", "equals", "", "other", "hashCode", "", "toString", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Extra<EC> implements Config {
        private final EC config;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Extra copy$default(Extra extra, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = extra.config;
            }
            return extra.copy(obj);
        }

        public final EC component1() {
            return this.config;
        }

        public final Extra<EC> copy(EC config) {
            Intrinsics.checkNotNullParameter(config, "config");
            return new Extra<>(config);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Extra) && Intrinsics.areEqual(this.config, ((Extra) obj).config);
        }

        public int hashCode() {
            return this.config.hashCode();
        }

        public String toString() {
            return "Extra(config=" + this.config + ')';
        }

        public Extra(EC config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.config = config;
        }

        public final EC getConfig() {
            return this.config;
        }
    }
}
