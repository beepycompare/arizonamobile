package com.miami.game.core.settings.game_test;

import com.miami.game.core.firebase.notification.NotificationStatsStore;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GameTestScriptModel.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/miami/game/core/settings/game_test/BackendFixture;", "", "name", "", "provider", "previewScreen", NotificationStatsStore.KEY_EVENTS, "", "Lcom/miami/game/core/settings/game_test/BackendFixtureEvent;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getProvider", "getPreviewScreen", "getEvents", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BackendFixture {
    private final List<BackendFixtureEvent> events;
    private final String name;
    private final String previewScreen;
    private final String provider;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BackendFixture copy$default(BackendFixture backendFixture, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = backendFixture.name;
        }
        if ((i & 2) != 0) {
            str2 = backendFixture.provider;
        }
        if ((i & 4) != 0) {
            str3 = backendFixture.previewScreen;
        }
        if ((i & 8) != 0) {
            list = backendFixture.events;
        }
        return backendFixture.copy(str, str2, str3, list);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.provider;
    }

    public final String component3() {
        return this.previewScreen;
    }

    public final List<BackendFixtureEvent> component4() {
        return this.events;
    }

    public final BackendFixture copy(String name, String str, String str2, List<BackendFixtureEvent> events) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(events, "events");
        return new BackendFixture(name, str, str2, events);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BackendFixture) {
            BackendFixture backendFixture = (BackendFixture) obj;
            return Intrinsics.areEqual(this.name, backendFixture.name) && Intrinsics.areEqual(this.provider, backendFixture.provider) && Intrinsics.areEqual(this.previewScreen, backendFixture.previewScreen) && Intrinsics.areEqual(this.events, backendFixture.events);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        String str = this.provider;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.previewScreen;
        return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.events.hashCode();
    }

    public String toString() {
        String str = this.name;
        String str2 = this.provider;
        String str3 = this.previewScreen;
        return "BackendFixture(name=" + str + ", provider=" + str2 + ", previewScreen=" + str3 + ", events=" + this.events + ")";
    }

    public BackendFixture(String name, String str, String str2, List<BackendFixtureEvent> events) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(events, "events");
        this.name = name;
        this.provider = str;
        this.previewScreen = str2;
        this.events = events;
    }

    public /* synthetic */ BackendFixture(String str, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, list);
    }

    public final String getName() {
        return this.name;
    }

    public final String getProvider() {
        return this.provider;
    }

    public final String getPreviewScreen() {
        return this.previewScreen;
    }

    public final List<BackendFixtureEvent> getEvents() {
        return this.events;
    }
}
