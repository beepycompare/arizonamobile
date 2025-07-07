package com.miami.game.core.api.model.response.game_info;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GameInfoApiModel.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jh\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006("}, d2 = {"Lcom/miami/game/core/api/model/response/game_info/GameInfoApiModel;", "", "type", "", "name", "dateChange", "", "size", "hash", "data", "", "gpuType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getName", "getDateChange", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSize", "getHash", "getData", "()Ljava/util/List;", "getGpuType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lcom/miami/game/core/api/model/response/game_info/GameInfoApiModel;", "equals", "", "other", "hashCode", "", "toString", "api-model_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GameInfoApiModel {
    @SerializedName("data")
    private final List<GameInfoApiModel> data;
    @SerializedName("date_change")
    private final Long dateChange;
    @SerializedName("gpu_type")
    private final String gpuType;
    @SerializedName("hash")
    private final String hash;
    @SerializedName("name")
    private final String name;
    @SerializedName("size")
    private final Long size;
    @SerializedName("type")
    private final String type;

    public static /* synthetic */ GameInfoApiModel copy$default(GameInfoApiModel gameInfoApiModel, String str, String str2, Long l, Long l2, String str3, List list, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gameInfoApiModel.type;
        }
        if ((i & 2) != 0) {
            str2 = gameInfoApiModel.name;
        }
        if ((i & 4) != 0) {
            l = gameInfoApiModel.dateChange;
        }
        if ((i & 8) != 0) {
            l2 = gameInfoApiModel.size;
        }
        if ((i & 16) != 0) {
            str3 = gameInfoApiModel.hash;
        }
        List<GameInfoApiModel> list2 = list;
        if ((i & 32) != 0) {
            list2 = gameInfoApiModel.data;
        }
        if ((i & 64) != 0) {
            str4 = gameInfoApiModel.gpuType;
        }
        List list3 = list2;
        String str5 = str4;
        String str6 = str3;
        Long l3 = l;
        return gameInfoApiModel.copy(str, str2, l3, l2, str6, list3, str5);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.name;
    }

    public final Long component3() {
        return this.dateChange;
    }

    public final Long component4() {
        return this.size;
    }

    public final String component5() {
        return this.hash;
    }

    public final List<GameInfoApiModel> component6() {
        return this.data;
    }

    public final String component7() {
        return this.gpuType;
    }

    public final GameInfoApiModel copy(String str, String str2, Long l, Long l2, String str3, List<GameInfoApiModel> list, String str4) {
        return new GameInfoApiModel(str, str2, l, l2, str3, list, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GameInfoApiModel) {
            GameInfoApiModel gameInfoApiModel = (GameInfoApiModel) obj;
            return Intrinsics.areEqual(this.type, gameInfoApiModel.type) && Intrinsics.areEqual(this.name, gameInfoApiModel.name) && Intrinsics.areEqual(this.dateChange, gameInfoApiModel.dateChange) && Intrinsics.areEqual(this.size, gameInfoApiModel.size) && Intrinsics.areEqual(this.hash, gameInfoApiModel.hash) && Intrinsics.areEqual(this.data, gameInfoApiModel.data) && Intrinsics.areEqual(this.gpuType, gameInfoApiModel.gpuType);
        }
        return false;
    }

    public int hashCode() {
        String str = this.type;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.dateChange;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.size;
        int hashCode4 = (hashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str3 = this.hash;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<GameInfoApiModel> list = this.data;
        int hashCode6 = (hashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.gpuType;
        return hashCode6 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        String str = this.type;
        String str2 = this.name;
        Long l = this.dateChange;
        Long l2 = this.size;
        String str3 = this.hash;
        List<GameInfoApiModel> list = this.data;
        return "GameInfoApiModel(type=" + str + ", name=" + str2 + ", dateChange=" + l + ", size=" + l2 + ", hash=" + str3 + ", data=" + list + ", gpuType=" + this.gpuType + ")";
    }

    public GameInfoApiModel(String str, String str2, Long l, Long l2, String str3, List<GameInfoApiModel> list, String str4) {
        this.type = str;
        this.name = str2;
        this.dateChange = l;
        this.size = l2;
        this.hash = str3;
        this.data = list;
        this.gpuType = str4;
    }

    public final String getType() {
        return this.type;
    }

    public final String getName() {
        return this.name;
    }

    public final Long getDateChange() {
        return this.dateChange;
    }

    public final Long getSize() {
        return this.size;
    }

    public final String getHash() {
        return this.hash;
    }

    public final List<GameInfoApiModel> getData() {
        return this.data;
    }

    public final String getGpuType() {
        return this.gpuType;
    }
}
