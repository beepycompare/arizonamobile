package com.arizona.launcher.model.servers;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.autofill.HintConstants;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.gson.annotations.SerializedName;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SAMPServerInfo.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001OB¡\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u00104\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u000106H\u0096\u0002J\b\u00107\u001a\u00020\u0003H\u0016J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\bHÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\fHÆ\u0003J\t\u0010?\u001a\u00020\fHÆ\u0003J\t\u0010@\u001a\u00020\fHÆ\u0003J\t\u0010A\u001a\u00020\fHÆ\u0003J\t\u0010B\u001a\u00020\bHÆ\u0003J\t\u0010C\u001a\u00020\u0012HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\u000f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\fHÆ\u0003J§\u0001\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00032\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0006\u0010H\u001a\u00020\u0003J\t\u0010I\u001a\u00020\fHÖ\u0001J\u0016\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u0003R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010#R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010,R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001b\"\u0004\b0\u0010#R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010&¨\u0006P"}, d2 = {"Lcom/arizona/launcher/model/servers/SAMPServerInfo;", "Landroid/os/Parcelable;", "id", "", "address", "Ljava/net/InetAddress;", "port", "hasPassword", "", "currentPlayerCount", "maxPlayerCount", "serverName", "", "tg", "vk", "inst", "favorite", "serverType", "Lcom/arizona/launcher/model/servers/ServerType;", "ping", "plotPoints", "", "Lcom/arizona/launcher/model/servers/SAMPServerInfo$PlotPoint;", "serverIcon", "<init>", "(ILjava/net/InetAddress;IZIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/arizona/launcher/model/servers/ServerType;ILjava/util/List;Ljava/lang/String;)V", "getId", "()I", "getAddress", "()Ljava/net/InetAddress;", "getPort", "getHasPassword", "()Z", "getCurrentPlayerCount", "setCurrentPlayerCount", "(I)V", "getMaxPlayerCount", "getServerName", "()Ljava/lang/String;", "getTg", "getVk", "getInst", "getFavorite", "setFavorite", "(Z)V", "getServerType", "()Lcom/arizona/launcher/model/servers/ServerType;", "getPing", "setPing", "getPlotPoints", "()Ljava/util/List;", "getServerIcon", "equals", "other", "", "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "describeContents", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", DownloaderServiceMarshaller.PARAMS_FLAGS, "PlotPoint", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SAMPServerInfo implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<SAMPServerInfo> CREATOR = new Creator();
    @SerializedName("ip")
    private final InetAddress address;
    @SerializedName("online")
    private int currentPlayerCount;
    private boolean favorite;
    @SerializedName(HintConstants.AUTOFILL_HINT_PASSWORD)
    private final boolean hasPassword;
    @SerializedName("number")
    private final int id;
    private final String inst;
    @SerializedName("maxplayers")
    private final int maxPlayerCount;
    private int ping;
    private final List<PlotPoint> plotPoints;
    @SerializedName("port")
    private final int port;
    @SerializedName("icon")
    private final String serverIcon;
    @SerializedName("name")
    private final String serverName;
    private final ServerType serverType;
    private final String tg;
    private final String vk;

    /* compiled from: SAMPServerInfo.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<SAMPServerInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SAMPServerInfo createFromParcel(Parcel parcel) {
            boolean z;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            InetAddress inetAddress = (InetAddress) parcel.readSerializable();
            int readInt2 = parcel.readInt();
            boolean z2 = false;
            if (parcel.readInt() != 0) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            boolean z3 = parcel.readInt() != 0 ? true : z;
            ServerType valueOf = ServerType.valueOf(parcel.readString());
            int readInt5 = parcel.readInt();
            int readInt6 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt6);
            int i = 0;
            while (i != readInt6) {
                arrayList.add(PlotPoint.CREATOR.createFromParcel(parcel));
                i++;
                readInt6 = readInt6;
            }
            return new SAMPServerInfo(readInt, inetAddress, readInt2, z2, readInt3, readInt4, readString, readString2, readString3, readString4, z3, valueOf, readInt5, arrayList, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SAMPServerInfo[] newArray(int i) {
            return new SAMPServerInfo[i];
        }
    }

    public final int component1() {
        return this.id;
    }

    public final String component10() {
        return this.inst;
    }

    public final boolean component11() {
        return this.favorite;
    }

    public final ServerType component12() {
        return this.serverType;
    }

    public final int component13() {
        return this.ping;
    }

    public final List<PlotPoint> component14() {
        return this.plotPoints;
    }

    public final String component15() {
        return this.serverIcon;
    }

    public final InetAddress component2() {
        return this.address;
    }

    public final int component3() {
        return this.port;
    }

    public final boolean component4() {
        return this.hasPassword;
    }

    public final int component5() {
        return this.currentPlayerCount;
    }

    public final int component6() {
        return this.maxPlayerCount;
    }

    public final String component7() {
        return this.serverName;
    }

    public final String component8() {
        return this.tg;
    }

    public final String component9() {
        return this.vk;
    }

    public final SAMPServerInfo copy(int i, InetAddress address, int i2, boolean z, int i3, int i4, String serverName, String tg, String vk, String inst, boolean z2, ServerType serverType, int i5, List<PlotPoint> plotPoints, String str) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(serverName, "serverName");
        Intrinsics.checkNotNullParameter(tg, "tg");
        Intrinsics.checkNotNullParameter(vk, "vk");
        Intrinsics.checkNotNullParameter(inst, "inst");
        Intrinsics.checkNotNullParameter(serverType, "serverType");
        Intrinsics.checkNotNullParameter(plotPoints, "plotPoints");
        return new SAMPServerInfo(i, address, i2, z, i3, i4, serverName, tg, vk, inst, z2, serverType, i5, plotPoints, str);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public String toString() {
        int i = this.id;
        InetAddress inetAddress = this.address;
        int i2 = this.port;
        boolean z = this.hasPassword;
        int i3 = this.currentPlayerCount;
        int i4 = this.maxPlayerCount;
        String str = this.serverName;
        String str2 = this.tg;
        String str3 = this.vk;
        String str4 = this.inst;
        boolean z2 = this.favorite;
        ServerType serverType = this.serverType;
        int i5 = this.ping;
        List<PlotPoint> list = this.plotPoints;
        return "SAMPServerInfo(id=" + i + ", address=" + inetAddress + ", port=" + i2 + ", hasPassword=" + z + ", currentPlayerCount=" + i3 + ", maxPlayerCount=" + i4 + ", serverName=" + str + ", tg=" + str2 + ", vk=" + str3 + ", inst=" + str4 + ", favorite=" + z2 + ", serverType=" + serverType + ", ping=" + i5 + ", plotPoints=" + list + ", serverIcon=" + this.serverIcon + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.id);
        dest.writeSerializable(this.address);
        dest.writeInt(this.port);
        dest.writeInt(this.hasPassword ? 1 : 0);
        dest.writeInt(this.currentPlayerCount);
        dest.writeInt(this.maxPlayerCount);
        dest.writeString(this.serverName);
        dest.writeString(this.tg);
        dest.writeString(this.vk);
        dest.writeString(this.inst);
        dest.writeInt(this.favorite ? 1 : 0);
        dest.writeString(this.serverType.name());
        dest.writeInt(this.ping);
        List<PlotPoint> list = this.plotPoints;
        dest.writeInt(list.size());
        for (PlotPoint plotPoint : list) {
            plotPoint.writeToParcel(dest, i);
        }
        dest.writeString(this.serverIcon);
    }

    public SAMPServerInfo(int i, InetAddress address, int i2, boolean z, int i3, int i4, String serverName, String tg, String vk, String inst, boolean z2, ServerType serverType, int i5, List<PlotPoint> plotPoints, String str) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(serverName, "serverName");
        Intrinsics.checkNotNullParameter(tg, "tg");
        Intrinsics.checkNotNullParameter(vk, "vk");
        Intrinsics.checkNotNullParameter(inst, "inst");
        Intrinsics.checkNotNullParameter(serverType, "serverType");
        Intrinsics.checkNotNullParameter(plotPoints, "plotPoints");
        this.id = i;
        this.address = address;
        this.port = i2;
        this.hasPassword = z;
        this.currentPlayerCount = i3;
        this.maxPlayerCount = i4;
        this.serverName = serverName;
        this.tg = tg;
        this.vk = vk;
        this.inst = inst;
        this.favorite = z2;
        this.serverType = serverType;
        this.ping = i5;
        this.plotPoints = plotPoints;
        this.serverIcon = str;
    }

    public final int getId() {
        return this.id;
    }

    public /* synthetic */ SAMPServerInfo(int i, InetAddress inetAddress, int i2, boolean z, int i3, int i4, String str, String str2, String str3, String str4, boolean z2, ServerType serverType, int i5, List list, String str5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? InetAddress.getByName("0.0.0.0") : inetAddress, (i6 & 4) != 0 ? 0 : i2, (i6 & 8) != 0 ? false : z, (i6 & 16) != 0 ? 0 : i3, (i6 & 32) != 0 ? 0 : i4, (i6 & 64) != 0 ? "" : str, (i6 & 128) != 0 ? "" : str2, (i6 & 256) != 0 ? "" : str3, (i6 & 512) != 0 ? "" : str4, (i6 & 1024) != 0 ? false : z2, serverType, (i6 & 4096) != 0 ? 0 : i5, list, (i6 & 16384) != 0 ? null : str5);
    }

    public final InetAddress getAddress() {
        return this.address;
    }

    public final int getPort() {
        return this.port;
    }

    public final boolean getHasPassword() {
        return this.hasPassword;
    }

    public final int getCurrentPlayerCount() {
        return this.currentPlayerCount;
    }

    public final void setCurrentPlayerCount(int i) {
        this.currentPlayerCount = i;
    }

    public final int getMaxPlayerCount() {
        return this.maxPlayerCount;
    }

    public final String getServerName() {
        return this.serverName;
    }

    public final String getTg() {
        return this.tg;
    }

    public final String getVk() {
        return this.vk;
    }

    public final String getInst() {
        return this.inst;
    }

    public final boolean getFavorite() {
        return this.favorite;
    }

    public final void setFavorite(boolean z) {
        this.favorite = z;
    }

    public final ServerType getServerType() {
        return this.serverType;
    }

    public final int getPing() {
        return this.ping;
    }

    public final void setPing(int i) {
        this.ping = i;
    }

    public final List<PlotPoint> getPlotPoints() {
        return this.plotPoints;
    }

    public final String getServerIcon() {
        return this.serverIcon;
    }

    /* compiled from: SAMPServerInfo.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0003J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/arizona/launcher/model/servers/SAMPServerInfo$PlotPoint;", "Landroid/os/Parcelable;", "online", "", "time", "", "<init>", "(IJ)V", "getOnline", "()I", "getTime", "()J", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", DownloaderServiceMarshaller.PARAMS_FLAGS, "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class PlotPoint implements Parcelable {
        public static final int $stable = 0;
        public static final Parcelable.Creator<PlotPoint> CREATOR = new Creator();
        private final int online;
        private final long time;

        /* compiled from: SAMPServerInfo.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<PlotPoint> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PlotPoint createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new PlotPoint(parcel.readInt(), parcel.readLong());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PlotPoint[] newArray(int i) {
                return new PlotPoint[i];
            }
        }

        public static /* synthetic */ PlotPoint copy$default(PlotPoint plotPoint, int i, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = plotPoint.online;
            }
            if ((i2 & 2) != 0) {
                j = plotPoint.time;
            }
            return plotPoint.copy(i, j);
        }

        public final int component1() {
            return this.online;
        }

        public final long component2() {
            return this.time;
        }

        public final PlotPoint copy(int i, long j) {
            return new PlotPoint(i, j);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PlotPoint) {
                PlotPoint plotPoint = (PlotPoint) obj;
                return this.online == plotPoint.online && this.time == plotPoint.time;
            }
            return false;
        }

        public int hashCode() {
            return (Integer.hashCode(this.online) * 31) + Long.hashCode(this.time);
        }

        public String toString() {
            int i = this.online;
            return "PlotPoint(online=" + i + ", time=" + this.time + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int i) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(this.online);
            dest.writeLong(this.time);
        }

        public PlotPoint(int i, long j) {
            this.online = i;
            this.time = j;
        }

        public final int getOnline() {
            return this.online;
        }

        public final long getTime() {
            return this.time;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(getClass(), obj != null ? obj.getClass() : null)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.arizona.launcher.model.servers.SAMPServerInfo");
            SAMPServerInfo sAMPServerInfo = (SAMPServerInfo) obj;
            return this.id == sAMPServerInfo.id && Intrinsics.areEqual(this.address, sAMPServerInfo.address) && this.port == sAMPServerInfo.port && Intrinsics.areEqual(this.serverName, sAMPServerInfo.serverName) && this.favorite == sAMPServerInfo.favorite && this.serverType == sAMPServerInfo.serverType;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.id * 31) + this.address.hashCode()) * 31) + this.port) * 31) + this.serverName.hashCode()) * 31) + Boolean.hashCode(this.favorite)) * 31) + this.serverType.hashCode();
    }
}
