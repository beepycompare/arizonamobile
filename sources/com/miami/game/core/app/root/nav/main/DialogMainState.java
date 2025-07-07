package com.miami.game.core.app.root.nav.main;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: MainState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/DialogMainState;", "", "<init>", "()V", "Empty", "Error", "UpdateClient", "Lcom/miami/game/core/app/root/nav/main/DialogMainState$Empty;", "Lcom/miami/game/core/app/root/nav/main/DialogMainState$Error;", "Lcom/miami/game/core/app/root/nav/main/DialogMainState$UpdateClient;", "app-root_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class DialogMainState {
    public static final int $stable = 0;

    public /* synthetic */ DialogMainState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: MainState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/DialogMainState$Empty;", "Lcom/miami/game/core/app/root/nav/main/DialogMainState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app-root_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Empty extends DialogMainState {
        public static final int $stable = 0;
        public static final Empty INSTANCE = new Empty();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Empty) {
                Empty empty = (Empty) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1443232695;
        }

        public String toString() {
            return "Empty";
        }

        private Empty() {
            super(null);
        }
    }

    private DialogMainState() {
    }

    /* compiled from: MainState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/DialogMainState$Error;", "Lcom/miami/game/core/app/root/nav/main/DialogMainState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app-root_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Error extends DialogMainState {
        public static final int $stable = 0;
        public static final Error INSTANCE = new Error();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Error) {
                Error error = (Error) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1443383410;
        }

        public String toString() {
            return "Error";
        }

        private Error() {
            super(null);
        }
    }

    /* compiled from: MainState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/DialogMainState$UpdateClient;", "Lcom/miami/game/core/app/root/nav/main/DialogMainState;", "isCheckUpdate", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app-root_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class UpdateClient extends DialogMainState {
        public static final int $stable = 0;
        private final boolean isCheckUpdate;

        public UpdateClient() {
            this(false, 1, null);
        }

        public static /* synthetic */ UpdateClient copy$default(UpdateClient updateClient, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = updateClient.isCheckUpdate;
            }
            return updateClient.copy(z);
        }

        public final boolean component1() {
            return this.isCheckUpdate;
        }

        public final UpdateClient copy(boolean z) {
            return new UpdateClient(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpdateClient) && this.isCheckUpdate == ((UpdateClient) obj).isCheckUpdate;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isCheckUpdate);
        }

        public String toString() {
            return "UpdateClient(isCheckUpdate=" + this.isCheckUpdate + ")";
        }

        public UpdateClient(boolean z) {
            super(null);
            this.isCheckUpdate = z;
        }

        public /* synthetic */ UpdateClient(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z);
        }

        public final boolean isCheckUpdate() {
            return this.isCheckUpdate;
        }
    }
}
