package com.arizona.launcher.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FileServerRouteResolver.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nÊ\u0001\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0019"}, d2 = {"Lcom/arizona/launcher/util/FileServerOrigins;", "", "mainArizona", "", "reserveArizona", "mainRodina", "reserveRodina", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMainArizona", "()Ljava/lang/String;", "getReserveArizona", "getMainRodina", "getReserveRodina", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileServerOrigins {
    public static final int $stable = 0;
    private final String mainArizona;
    private final String mainRodina;
    private final String reserveArizona;
    private final String reserveRodina;

    public static /* synthetic */ FileServerOrigins copy$default(FileServerOrigins fileServerOrigins, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileServerOrigins.mainArizona;
        }
        if ((i & 2) != 0) {
            str2 = fileServerOrigins.reserveArizona;
        }
        if ((i & 4) != 0) {
            str3 = fileServerOrigins.mainRodina;
        }
        if ((i & 8) != 0) {
            str4 = fileServerOrigins.reserveRodina;
        }
        return fileServerOrigins.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.mainArizona;
    }

    public final String component2() {
        return this.reserveArizona;
    }

    public final String component3() {
        return this.mainRodina;
    }

    public final String component4() {
        return this.reserveRodina;
    }

    public final FileServerOrigins copy(String mainArizona, String reserveArizona, String mainRodina, String reserveRodina) {
        Intrinsics.checkNotNullParameter(mainArizona, "mainArizona");
        Intrinsics.checkNotNullParameter(reserveArizona, "reserveArizona");
        Intrinsics.checkNotNullParameter(mainRodina, "mainRodina");
        Intrinsics.checkNotNullParameter(reserveRodina, "reserveRodina");
        return new FileServerOrigins(mainArizona, reserveArizona, mainRodina, reserveRodina);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FileServerOrigins) {
            FileServerOrigins fileServerOrigins = (FileServerOrigins) obj;
            return Intrinsics.areEqual(this.mainArizona, fileServerOrigins.mainArizona) && Intrinsics.areEqual(this.reserveArizona, fileServerOrigins.reserveArizona) && Intrinsics.areEqual(this.mainRodina, fileServerOrigins.mainRodina) && Intrinsics.areEqual(this.reserveRodina, fileServerOrigins.reserveRodina);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.mainArizona.hashCode() * 31) + this.reserveArizona.hashCode()) * 31) + this.mainRodina.hashCode()) * 31) + this.reserveRodina.hashCode();
    }

    public String toString() {
        String str = this.mainArizona;
        String str2 = this.reserveArizona;
        String str3 = this.mainRodina;
        return "FileServerOrigins(mainArizona=" + str + ", reserveArizona=" + str2 + ", mainRodina=" + str3 + ", reserveRodina=" + this.reserveRodina + ")";
    }

    public FileServerOrigins(String mainArizona, String reserveArizona, String mainRodina, String reserveRodina) {
        Intrinsics.checkNotNullParameter(mainArizona, "mainArizona");
        Intrinsics.checkNotNullParameter(reserveArizona, "reserveArizona");
        Intrinsics.checkNotNullParameter(mainRodina, "mainRodina");
        Intrinsics.checkNotNullParameter(reserveRodina, "reserveRodina");
        this.mainArizona = mainArizona;
        this.reserveArizona = reserveArizona;
        this.mainRodina = mainRodina;
        this.reserveRodina = reserveRodina;
    }

    public final String getMainArizona() {
        return this.mainArizona;
    }

    public final String getReserveArizona() {
        return this.reserveArizona;
    }

    public final String getMainRodina() {
        return this.mainRodina;
    }

    public final String getReserveRodina() {
        return this.reserveRodina;
    }
}
