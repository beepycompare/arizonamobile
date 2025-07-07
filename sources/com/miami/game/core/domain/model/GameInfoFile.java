package com.miami.game.core.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: GameInfoFile.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J^\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000f¨\u0006("}, d2 = {"Lcom/miami/game/core/domain/model/GameInfoFile;", "", "path", "", "name", "size", "", "hash", "dateChange", "gpuType", "isHashChecked", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Z)V", "getPath", "()Ljava/lang/String;", "getName", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getHash", "getDateChange", "getGpuType", "()Z", "localPath", "getLocalPath", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Z)Lcom/miami/game/core/domain/model/GameInfoFile;", "equals", "other", "hashCode", "", "toString", "domain-model_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GameInfoFile {
    private final Long dateChange;
    private final String gpuType;
    private final String hash;
    private final boolean isHashChecked;
    private final String name;
    private final String path;
    private final Long size;

    public static /* synthetic */ GameInfoFile copy$default(GameInfoFile gameInfoFile, String str, String str2, Long l, String str3, Long l2, String str4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gameInfoFile.path;
        }
        if ((i & 2) != 0) {
            str2 = gameInfoFile.name;
        }
        if ((i & 4) != 0) {
            l = gameInfoFile.size;
        }
        if ((i & 8) != 0) {
            str3 = gameInfoFile.hash;
        }
        if ((i & 16) != 0) {
            l2 = gameInfoFile.dateChange;
        }
        if ((i & 32) != 0) {
            str4 = gameInfoFile.gpuType;
        }
        if ((i & 64) != 0) {
            z = gameInfoFile.isHashChecked;
        }
        String str5 = str4;
        boolean z2 = z;
        Long l3 = l2;
        Long l4 = l;
        return gameInfoFile.copy(str, str2, l4, str3, l3, str5, z2);
    }

    public final String component1() {
        return this.path;
    }

    public final String component2() {
        return this.name;
    }

    public final Long component3() {
        return this.size;
    }

    public final String component4() {
        return this.hash;
    }

    public final Long component5() {
        return this.dateChange;
    }

    public final String component6() {
        return this.gpuType;
    }

    public final boolean component7() {
        return this.isHashChecked;
    }

    public final GameInfoFile copy(String path, String str, Long l, String str2, Long l2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(path, "path");
        return new GameInfoFile(path, str, l, str2, l2, str3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GameInfoFile) {
            GameInfoFile gameInfoFile = (GameInfoFile) obj;
            return Intrinsics.areEqual(this.path, gameInfoFile.path) && Intrinsics.areEqual(this.name, gameInfoFile.name) && Intrinsics.areEqual(this.size, gameInfoFile.size) && Intrinsics.areEqual(this.hash, gameInfoFile.hash) && Intrinsics.areEqual(this.dateChange, gameInfoFile.dateChange) && Intrinsics.areEqual(this.gpuType, gameInfoFile.gpuType) && this.isHashChecked == gameInfoFile.isHashChecked;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.path.hashCode() * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.size;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.hash;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l2 = this.dateChange;
        int hashCode5 = (hashCode4 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str3 = this.gpuType;
        return ((hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31) + Boolean.hashCode(this.isHashChecked);
    }

    public String toString() {
        String str = this.path;
        String str2 = this.name;
        Long l = this.size;
        String str3 = this.hash;
        Long l2 = this.dateChange;
        String str4 = this.gpuType;
        return "GameInfoFile(path=" + str + ", name=" + str2 + ", size=" + l + ", hash=" + str3 + ", dateChange=" + l2 + ", gpuType=" + str4 + ", isHashChecked=" + this.isHashChecked + ")";
    }

    public GameInfoFile(String path, String str, Long l, String str2, Long l2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
        this.name = str;
        this.size = l;
        this.hash = str2;
        this.dateChange = l2;
        this.gpuType = str3;
        this.isHashChecked = z;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getName() {
        return this.name;
    }

    public final Long getSize() {
        return this.size;
    }

    public final String getHash() {
        return this.hash;
    }

    public final Long getDateChange() {
        return this.dateChange;
    }

    public final String getGpuType() {
        return this.gpuType;
    }

    public final boolean isHashChecked() {
        return this.isHashChecked;
    }

    public final String getLocalPath() {
        return StringsKt.substringAfter$default(this.path, "/files", (String) null, 2, (Object) null);
    }
}
