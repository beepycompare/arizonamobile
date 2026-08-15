package com.arizona.launcher.util;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
/* compiled from: GameFileServerRouteResolver.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bÊ\u0001\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"Lcom/arizona/launcher/util/GameFileServerPair;", "", JvmProtoBufUtil.DEFAULT_MODULE_NAME, "", "reserve", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getMain", "()Ljava/lang/String;", "getReserve", "asList", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GameFileServerPair {
    public static final int $stable = 0;
    private final String main;
    private final String reserve;

    public static /* synthetic */ GameFileServerPair copy$default(GameFileServerPair gameFileServerPair, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gameFileServerPair.main;
        }
        if ((i & 2) != 0) {
            str2 = gameFileServerPair.reserve;
        }
        return gameFileServerPair.copy(str, str2);
    }

    public final String component1() {
        return this.main;
    }

    public final String component2() {
        return this.reserve;
    }

    public final GameFileServerPair copy(String main, String reserve) {
        Intrinsics.checkNotNullParameter(main, "main");
        Intrinsics.checkNotNullParameter(reserve, "reserve");
        return new GameFileServerPair(main, reserve);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GameFileServerPair) {
            GameFileServerPair gameFileServerPair = (GameFileServerPair) obj;
            return Intrinsics.areEqual(this.main, gameFileServerPair.main) && Intrinsics.areEqual(this.reserve, gameFileServerPair.reserve);
        }
        return false;
    }

    public int hashCode() {
        return (this.main.hashCode() * 31) + this.reserve.hashCode();
    }

    public String toString() {
        String str = this.main;
        return "GameFileServerPair(main=" + str + ", reserve=" + this.reserve + ")";
    }

    public GameFileServerPair(String main, String reserve) {
        Intrinsics.checkNotNullParameter(main, "main");
        Intrinsics.checkNotNullParameter(reserve, "reserve");
        this.main = main;
        this.reserve = reserve;
    }

    public final String getMain() {
        return this.main;
    }

    public final String getReserve() {
        return this.reserve;
    }

    public final List<String> asList() {
        return CollectionsKt.listOf((Object[]) new String[]{this.main, this.reserve});
    }
}
