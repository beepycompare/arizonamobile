package ru.mrlargha.commonui.elements.dialogs.playerlist;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Player.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/playerlist/Player;", "", "id", "", "name", "", FirebaseAnalytics.Param.LEVEL, "ping", "color", "<init>", "(ILjava/lang/String;III)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getLevel", "getPing", "getColor", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Player {
    private final int color;
    private final int id;
    private final int level;
    private final String name;
    private final int ping;

    public static /* synthetic */ Player copy$default(Player player, int i, String str, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = player.id;
        }
        if ((i5 & 2) != 0) {
            str = player.name;
        }
        if ((i5 & 4) != 0) {
            i2 = player.level;
        }
        if ((i5 & 8) != 0) {
            i3 = player.ping;
        }
        if ((i5 & 16) != 0) {
            i4 = player.color;
        }
        int i6 = i4;
        int i7 = i2;
        return player.copy(i, str, i7, i3, i6);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.level;
    }

    public final int component4() {
        return this.ping;
    }

    public final int component5() {
        return this.color;
    }

    public final Player copy(int i, String name, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new Player(i, name, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Player) {
            Player player = (Player) obj;
            return this.id == player.id && Intrinsics.areEqual(this.name, player.name) && this.level == player.level && this.ping == player.ping && this.color == player.color;
        }
        return false;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.level)) * 31) + Integer.hashCode(this.ping)) * 31) + Integer.hashCode(this.color);
    }

    public String toString() {
        int i = this.id;
        String str = this.name;
        int i2 = this.level;
        int i3 = this.ping;
        return "Player(id=" + i + ", name=" + str + ", level=" + i2 + ", ping=" + i3 + ", color=" + this.color + ")";
    }

    public Player(int i, String name, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
        this.level = i2;
        this.ping = i3;
        this.color = i4;
    }

    public final int getColor() {
        return this.color;
    }

    public final int getId() {
        return this.id;
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPing() {
        return this.ping;
    }
}
