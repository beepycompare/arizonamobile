package com.arizonagames.feature.minigames.fishing.backend;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\bHÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/arizonagames/feature/minigames/fishing/backend/GameData;", "", "type", "", "title", "", "caption", "cells", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getType", "()I", "getTitle", "()Ljava/lang/String;", "getCaption", "getCells", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "fishing-backend"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GameData {
    private final String caption;
    private final List<List<Integer>> cells;
    private final String title;
    private final int type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GameData copy$default(GameData gameData, int i, String str, String str2, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = gameData.type;
        }
        if ((i2 & 2) != 0) {
            str = gameData.title;
        }
        if ((i2 & 4) != 0) {
            str2 = gameData.caption;
        }
        if ((i2 & 8) != 0) {
            list = gameData.cells;
        }
        return gameData.copy(i, str, str2, list);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.caption;
    }

    public final List<List<Integer>> component4() {
        return this.cells;
    }

    public final GameData copy(int i, String title, String caption, List<? extends List<Integer>> cells) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(caption, "caption");
        Intrinsics.checkNotNullParameter(cells, "cells");
        return new GameData(i, title, caption, cells);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GameData) {
            GameData gameData = (GameData) obj;
            return this.type == gameData.type && Intrinsics.areEqual(this.title, gameData.title) && Intrinsics.areEqual(this.caption, gameData.caption) && Intrinsics.areEqual(this.cells, gameData.cells);
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.type) * 31) + this.title.hashCode()) * 31) + this.caption.hashCode()) * 31) + this.cells.hashCode();
    }

    public String toString() {
        int i = this.type;
        String str = this.title;
        String str2 = this.caption;
        return "GameData(type=" + i + ", title=" + str + ", caption=" + str2 + ", cells=" + this.cells + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GameData(int i, String title, String caption, List<? extends List<Integer>> cells) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(caption, "caption");
        Intrinsics.checkNotNullParameter(cells, "cells");
        this.type = i;
        this.title = title;
        this.caption = caption;
        this.cells = cells;
    }

    public final int getType() {
        return this.type;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getCaption() {
        return this.caption;
    }

    public final List<List<Integer>> getCells() {
        return this.cells;
    }
}
