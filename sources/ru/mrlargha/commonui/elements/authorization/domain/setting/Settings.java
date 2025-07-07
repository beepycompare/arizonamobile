package ru.mrlargha.commonui.elements.authorization.domain.setting;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Settings.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/domain/setting/Settings;", "", "client", "Lru/mrlargha/commonui/elements/authorization/domain/setting/Client;", "launcher", "Lru/mrlargha/commonui/elements/authorization/domain/setting/Launcher;", "<init>", "(Lru/mrlargha/commonui/elements/authorization/domain/setting/Client;Lru/mrlargha/commonui/elements/authorization/domain/setting/Launcher;)V", "getClient", "()Lru/mrlargha/commonui/elements/authorization/domain/setting/Client;", "setClient", "(Lru/mrlargha/commonui/elements/authorization/domain/setting/Client;)V", "getLauncher", "()Lru/mrlargha/commonui/elements/authorization/domain/setting/Launcher;", "setLauncher", "(Lru/mrlargha/commonui/elements/authorization/domain/setting/Launcher;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Settings {
    @SerializedName("client")
    private Client client;
    @SerializedName("launcher")
    private Launcher launcher;

    public Settings() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ Settings copy$default(Settings settings, Client client, Launcher launcher, int i, Object obj) {
        if ((i & 1) != 0) {
            client = settings.client;
        }
        if ((i & 2) != 0) {
            launcher = settings.launcher;
        }
        return settings.copy(client, launcher);
    }

    public final Client component1() {
        return this.client;
    }

    public final Launcher component2() {
        return this.launcher;
    }

    public final Settings copy(Client client, Launcher launcher) {
        return new Settings(client, launcher);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Settings) {
            Settings settings = (Settings) obj;
            return Intrinsics.areEqual(this.client, settings.client) && Intrinsics.areEqual(this.launcher, settings.launcher);
        }
        return false;
    }

    public int hashCode() {
        Client client = this.client;
        int hashCode = (client == null ? 0 : client.hashCode()) * 31;
        Launcher launcher = this.launcher;
        return hashCode + (launcher != null ? launcher.hashCode() : 0);
    }

    public String toString() {
        Client client = this.client;
        return "Settings(client=" + client + ", launcher=" + this.launcher + ")";
    }

    public Settings(Client client, Launcher launcher) {
        this.client = client;
        this.launcher = launcher;
    }

    public /* synthetic */ Settings(Client client, Launcher launcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Client(null, 1, null) : client, (i & 2) != 0 ? new Launcher(null, null, null, null, null, null, 63, null) : launcher);
    }

    public final Client getClient() {
        return this.client;
    }

    public final void setClient(Client client) {
        this.client = client;
    }

    public final Launcher getLauncher() {
        return this.launcher;
    }

    public final void setLauncher(Launcher launcher) {
        this.launcher = launcher;
    }
}
