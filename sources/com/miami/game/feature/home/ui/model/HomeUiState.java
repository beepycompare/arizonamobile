package com.miami.game.feature.home.ui.model;

import androidx.compose.ui.graphics.ImageBitmap;
import com.facebook.internal.NativeProtocol;
import com.miami.game.core.drawable.resources.R;
import com.miami.game.core.news.domain.NewsModel;
import com.miami.game.core.server.model.ServerModel;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HomeUiState.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b8\b\u0087\b\u0018\u0000 X2\u00020\u0001:\u0001XBí\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0004\b\"\u0010#J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0007HÆ\u0003J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010@\u001a\u00020\u0007HÆ\u0003J\t\u0010A\u001a\u00020\u0007HÆ\u0003J\t\u0010B\u001a\u00020\u0007HÆ\u0003J\t\u0010C\u001a\u00020\u0007HÆ\u0003J\t\u0010D\u001a\u00020\u0007HÆ\u0003J\t\u0010E\u001a\u00020\u0007HÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010!HÆ\u0003J\u0085\u0002\u0010S\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!HÆ\u0001J\u0014\u0010T\u001a\u00020\u00052\b\u0010U\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010V\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010W\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010&R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b/\u0010(R\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u0010(R\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u0010(R\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b2\u0010(R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010&R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010&R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010&R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010&R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010&R\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010&R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010&R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010%R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010%R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010%R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:¨\u0006Y"}, d2 = {"Lcom/miami/game/feature/home/ui/model/HomeUiState;", "", "backGroundId", "", "isProgressDownload", "", "updateSize", "", "newsList", "", "Lcom/miami/game/core/news/domain/NewsModel;", "currentServer", "Lcom/miami/game/core/server/model/ServerModel;", "forumLink", "discLink", "vkLink", "tgLink", "websiteLink", "shopLink", "isCheckingFiles", "isPrivacyAccepted", "isUpdateNeeded", "isFirstDownload", "xDonate", "isShopAllowed", "isGameReady", "isArizona", "queue", "online", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "file", "Ljava/io/File;", "imageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "<init>", "(IZLjava/lang/String;Ljava/util/List;Lcom/miami/game/core/server/model/ServerModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZIZZZIIILjava/io/File;Landroidx/compose/ui/graphics/ImageBitmap;)V", "getBackGroundId", "()I", "()Z", "getUpdateSize", "()Ljava/lang/String;", "getNewsList", "()Ljava/util/List;", "getCurrentServer", "()Lcom/miami/game/core/server/model/ServerModel;", "getForumLink", "getDiscLink", "getVkLink", "getTgLink", "getWebsiteLink", "getShopLink", "getXDonate", "getQueue", "getOnline", "getVersion", "getFile", "()Ljava/io/File;", "getImageBitmap", "()Landroidx/compose/ui/graphics/ImageBitmap;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "equals", "other", "hashCode", "toString", "Companion", "home"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HomeUiState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final int backGroundId;
    private final ServerModel currentServer;
    private final String discLink;
    private final File file;
    private final String forumLink;
    private final ImageBitmap imageBitmap;
    private final boolean isArizona;
    private final boolean isCheckingFiles;
    private final boolean isFirstDownload;
    private final boolean isGameReady;
    private final boolean isPrivacyAccepted;
    private final boolean isProgressDownload;
    private final boolean isShopAllowed;
    private final boolean isUpdateNeeded;
    private final List<NewsModel> newsList;
    private final int online;
    private final int queue;
    private final String shopLink;
    private final String tgLink;
    private final String updateSize;
    private final int version;
    private final String vkLink;
    private final String websiteLink;
    private final int xDonate;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HomeUiState copy$default(HomeUiState homeUiState, int i, boolean z, String str, List list, ServerModel serverModel, String str2, String str3, String str4, String str5, String str6, String str7, boolean z2, boolean z3, boolean z4, boolean z5, int i2, boolean z6, boolean z7, boolean z8, int i3, int i4, int i5, File file, ImageBitmap imageBitmap, int i6, Object obj) {
        ImageBitmap imageBitmap2;
        File file2;
        int i7 = (i6 & 1) != 0 ? homeUiState.backGroundId : i;
        boolean z9 = (i6 & 2) != 0 ? homeUiState.isProgressDownload : z;
        String str8 = (i6 & 4) != 0 ? homeUiState.updateSize : str;
        List<NewsModel> list2 = (i6 & 8) != 0 ? homeUiState.newsList : list;
        ServerModel serverModel2 = (i6 & 16) != 0 ? homeUiState.currentServer : serverModel;
        String str9 = (i6 & 32) != 0 ? homeUiState.forumLink : str2;
        String str10 = (i6 & 64) != 0 ? homeUiState.discLink : str3;
        String str11 = (i6 & 128) != 0 ? homeUiState.vkLink : str4;
        String str12 = (i6 & 256) != 0 ? homeUiState.tgLink : str5;
        String str13 = (i6 & 512) != 0 ? homeUiState.websiteLink : str6;
        String str14 = (i6 & 1024) != 0 ? homeUiState.shopLink : str7;
        boolean z10 = (i6 & 2048) != 0 ? homeUiState.isCheckingFiles : z2;
        boolean z11 = (i6 & 4096) != 0 ? homeUiState.isPrivacyAccepted : z3;
        boolean z12 = (i6 & 8192) != 0 ? homeUiState.isUpdateNeeded : z4;
        int i8 = i7;
        boolean z13 = (i6 & 16384) != 0 ? homeUiState.isFirstDownload : z5;
        int i9 = (i6 & 32768) != 0 ? homeUiState.xDonate : i2;
        boolean z14 = (i6 & 65536) != 0 ? homeUiState.isShopAllowed : z6;
        boolean z15 = (i6 & 131072) != 0 ? homeUiState.isGameReady : z7;
        boolean z16 = (i6 & 262144) != 0 ? homeUiState.isArizona : z8;
        int i10 = (i6 & 524288) != 0 ? homeUiState.queue : i3;
        int i11 = (i6 & 1048576) != 0 ? homeUiState.online : i4;
        int i12 = (i6 & 2097152) != 0 ? homeUiState.version : i5;
        File file3 = (i6 & 4194304) != 0 ? homeUiState.file : file;
        if ((i6 & 8388608) != 0) {
            file2 = file3;
            imageBitmap2 = homeUiState.imageBitmap;
        } else {
            imageBitmap2 = imageBitmap;
            file2 = file3;
        }
        return homeUiState.copy(i8, z9, str8, list2, serverModel2, str9, str10, str11, str12, str13, str14, z10, z11, z12, z13, i9, z14, z15, z16, i10, i11, i12, file2, imageBitmap2);
    }

    public final int component1() {
        return this.backGroundId;
    }

    public final String component10() {
        return this.websiteLink;
    }

    public final String component11() {
        return this.shopLink;
    }

    public final boolean component12() {
        return this.isCheckingFiles;
    }

    public final boolean component13() {
        return this.isPrivacyAccepted;
    }

    public final boolean component14() {
        return this.isUpdateNeeded;
    }

    public final boolean component15() {
        return this.isFirstDownload;
    }

    public final int component16() {
        return this.xDonate;
    }

    public final boolean component17() {
        return this.isShopAllowed;
    }

    public final boolean component18() {
        return this.isGameReady;
    }

    public final boolean component19() {
        return this.isArizona;
    }

    public final boolean component2() {
        return this.isProgressDownload;
    }

    public final int component20() {
        return this.queue;
    }

    public final int component21() {
        return this.online;
    }

    public final int component22() {
        return this.version;
    }

    public final File component23() {
        return this.file;
    }

    public final ImageBitmap component24() {
        return this.imageBitmap;
    }

    public final String component3() {
        return this.updateSize;
    }

    public final List<NewsModel> component4() {
        return this.newsList;
    }

    public final ServerModel component5() {
        return this.currentServer;
    }

    public final String component6() {
        return this.forumLink;
    }

    public final String component7() {
        return this.discLink;
    }

    public final String component8() {
        return this.vkLink;
    }

    public final String component9() {
        return this.tgLink;
    }

    public final HomeUiState copy(int i, boolean z, String updateSize, List<NewsModel> newsList, ServerModel serverModel, String forumLink, String discLink, String vkLink, String tgLink, String websiteLink, String shopLink, boolean z2, boolean z3, boolean z4, boolean z5, int i2, boolean z6, boolean z7, boolean z8, int i3, int i4, int i5, File file, ImageBitmap imageBitmap) {
        Intrinsics.checkNotNullParameter(updateSize, "updateSize");
        Intrinsics.checkNotNullParameter(newsList, "newsList");
        Intrinsics.checkNotNullParameter(forumLink, "forumLink");
        Intrinsics.checkNotNullParameter(discLink, "discLink");
        Intrinsics.checkNotNullParameter(vkLink, "vkLink");
        Intrinsics.checkNotNullParameter(tgLink, "tgLink");
        Intrinsics.checkNotNullParameter(websiteLink, "websiteLink");
        Intrinsics.checkNotNullParameter(shopLink, "shopLink");
        return new HomeUiState(i, z, updateSize, newsList, serverModel, forumLink, discLink, vkLink, tgLink, websiteLink, shopLink, z2, z3, z4, z5, i2, z6, z7, z8, i3, i4, i5, file, imageBitmap);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HomeUiState) {
            HomeUiState homeUiState = (HomeUiState) obj;
            return this.backGroundId == homeUiState.backGroundId && this.isProgressDownload == homeUiState.isProgressDownload && Intrinsics.areEqual(this.updateSize, homeUiState.updateSize) && Intrinsics.areEqual(this.newsList, homeUiState.newsList) && Intrinsics.areEqual(this.currentServer, homeUiState.currentServer) && Intrinsics.areEqual(this.forumLink, homeUiState.forumLink) && Intrinsics.areEqual(this.discLink, homeUiState.discLink) && Intrinsics.areEqual(this.vkLink, homeUiState.vkLink) && Intrinsics.areEqual(this.tgLink, homeUiState.tgLink) && Intrinsics.areEqual(this.websiteLink, homeUiState.websiteLink) && Intrinsics.areEqual(this.shopLink, homeUiState.shopLink) && this.isCheckingFiles == homeUiState.isCheckingFiles && this.isPrivacyAccepted == homeUiState.isPrivacyAccepted && this.isUpdateNeeded == homeUiState.isUpdateNeeded && this.isFirstDownload == homeUiState.isFirstDownload && this.xDonate == homeUiState.xDonate && this.isShopAllowed == homeUiState.isShopAllowed && this.isGameReady == homeUiState.isGameReady && this.isArizona == homeUiState.isArizona && this.queue == homeUiState.queue && this.online == homeUiState.online && this.version == homeUiState.version && Intrinsics.areEqual(this.file, homeUiState.file) && Intrinsics.areEqual(this.imageBitmap, homeUiState.imageBitmap);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((Integer.hashCode(this.backGroundId) * 31) + Boolean.hashCode(this.isProgressDownload)) * 31) + this.updateSize.hashCode()) * 31) + this.newsList.hashCode()) * 31;
        ServerModel serverModel = this.currentServer;
        int hashCode2 = (((((((((((((((((((((((((((((((((((hashCode + (serverModel == null ? 0 : serverModel.hashCode())) * 31) + this.forumLink.hashCode()) * 31) + this.discLink.hashCode()) * 31) + this.vkLink.hashCode()) * 31) + this.tgLink.hashCode()) * 31) + this.websiteLink.hashCode()) * 31) + this.shopLink.hashCode()) * 31) + Boolean.hashCode(this.isCheckingFiles)) * 31) + Boolean.hashCode(this.isPrivacyAccepted)) * 31) + Boolean.hashCode(this.isUpdateNeeded)) * 31) + Boolean.hashCode(this.isFirstDownload)) * 31) + Integer.hashCode(this.xDonate)) * 31) + Boolean.hashCode(this.isShopAllowed)) * 31) + Boolean.hashCode(this.isGameReady)) * 31) + Boolean.hashCode(this.isArizona)) * 31) + Integer.hashCode(this.queue)) * 31) + Integer.hashCode(this.online)) * 31) + Integer.hashCode(this.version)) * 31;
        File file = this.file;
        int hashCode3 = (hashCode2 + (file == null ? 0 : file.hashCode())) * 31;
        ImageBitmap imageBitmap = this.imageBitmap;
        return hashCode3 + (imageBitmap != null ? imageBitmap.hashCode() : 0);
    }

    public String toString() {
        int i = this.backGroundId;
        boolean z = this.isProgressDownload;
        String str = this.updateSize;
        List<NewsModel> list = this.newsList;
        ServerModel serverModel = this.currentServer;
        String str2 = this.forumLink;
        String str3 = this.discLink;
        String str4 = this.vkLink;
        String str5 = this.tgLink;
        String str6 = this.websiteLink;
        String str7 = this.shopLink;
        boolean z2 = this.isCheckingFiles;
        boolean z3 = this.isPrivacyAccepted;
        boolean z4 = this.isUpdateNeeded;
        boolean z5 = this.isFirstDownload;
        int i2 = this.xDonate;
        boolean z6 = this.isShopAllowed;
        boolean z7 = this.isGameReady;
        boolean z8 = this.isArizona;
        int i3 = this.queue;
        int i4 = this.online;
        int i5 = this.version;
        File file = this.file;
        return "HomeUiState(backGroundId=" + i + ", isProgressDownload=" + z + ", updateSize=" + str + ", newsList=" + list + ", currentServer=" + serverModel + ", forumLink=" + str2 + ", discLink=" + str3 + ", vkLink=" + str4 + ", tgLink=" + str5 + ", websiteLink=" + str6 + ", shopLink=" + str7 + ", isCheckingFiles=" + z2 + ", isPrivacyAccepted=" + z3 + ", isUpdateNeeded=" + z4 + ", isFirstDownload=" + z5 + ", xDonate=" + i2 + ", isShopAllowed=" + z6 + ", isGameReady=" + z7 + ", isArizona=" + z8 + ", queue=" + i3 + ", online=" + i4 + ", version=" + i5 + ", file=" + file + ", imageBitmap=" + this.imageBitmap + ")";
    }

    public HomeUiState(int i, boolean z, String updateSize, List<NewsModel> newsList, ServerModel serverModel, String forumLink, String discLink, String vkLink, String tgLink, String websiteLink, String shopLink, boolean z2, boolean z3, boolean z4, boolean z5, int i2, boolean z6, boolean z7, boolean z8, int i3, int i4, int i5, File file, ImageBitmap imageBitmap) {
        Intrinsics.checkNotNullParameter(updateSize, "updateSize");
        Intrinsics.checkNotNullParameter(newsList, "newsList");
        Intrinsics.checkNotNullParameter(forumLink, "forumLink");
        Intrinsics.checkNotNullParameter(discLink, "discLink");
        Intrinsics.checkNotNullParameter(vkLink, "vkLink");
        Intrinsics.checkNotNullParameter(tgLink, "tgLink");
        Intrinsics.checkNotNullParameter(websiteLink, "websiteLink");
        Intrinsics.checkNotNullParameter(shopLink, "shopLink");
        this.backGroundId = i;
        this.isProgressDownload = z;
        this.updateSize = updateSize;
        this.newsList = newsList;
        this.currentServer = serverModel;
        this.forumLink = forumLink;
        this.discLink = discLink;
        this.vkLink = vkLink;
        this.tgLink = tgLink;
        this.websiteLink = websiteLink;
        this.shopLink = shopLink;
        this.isCheckingFiles = z2;
        this.isPrivacyAccepted = z3;
        this.isUpdateNeeded = z4;
        this.isFirstDownload = z5;
        this.xDonate = i2;
        this.isShopAllowed = z6;
        this.isGameReady = z7;
        this.isArizona = z8;
        this.queue = i3;
        this.online = i4;
        this.version = i5;
        this.file = file;
        this.imageBitmap = imageBitmap;
    }

    public final int getBackGroundId() {
        return this.backGroundId;
    }

    public final boolean isProgressDownload() {
        return this.isProgressDownload;
    }

    public /* synthetic */ HomeUiState(int i, boolean z, String str, List list, ServerModel serverModel, String str2, String str3, String str4, String str5, String str6, String str7, boolean z2, boolean z3, boolean z4, boolean z5, int i2, boolean z6, boolean z7, boolean z8, int i3, int i4, int i5, File file, ImageBitmap imageBitmap, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        ImageBitmap imageBitmap2;
        HomeUiState homeUiState;
        int i7;
        boolean z9;
        ServerModel serverModel2;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        boolean z10;
        boolean z11;
        String str14 = (i6 & 4) != 0 ? "" : str;
        List listOf = (i6 & 8) != 0 ? CollectionsKt.listOf((Object[]) new NewsModel[]{new NewsModel(null, null, null, null, 15, null), new NewsModel(null, null, null, null, 15, null)}) : list;
        boolean z12 = (i6 & 2048) != 0 ? true : z2;
        boolean z13 = (i6 & 4096) != 0 ? false : z3;
        boolean z14 = (i6 & 8192) != 0 ? false : z4;
        boolean z15 = (i6 & 16384) != 0 ? false : z5;
        int i8 = (32768 & i6) != 0 ? 0 : i2;
        boolean z16 = (131072 & i6) != 0 ? false : z7;
        int i9 = (524288 & i6) != 0 ? 0 : i3;
        int i10 = (1048576 & i6) != 0 ? 0 : i4;
        int i11 = (2097152 & i6) != 0 ? 0 : i5;
        File file2 = (4194304 & i6) != 0 ? null : file;
        if ((i6 & 8388608) != 0) {
            imageBitmap2 = null;
            i7 = i;
            z9 = z;
            serverModel2 = serverModel;
            str8 = str2;
            str9 = str3;
            str10 = str4;
            str11 = str5;
            str12 = str6;
            str13 = str7;
            z10 = z6;
            z11 = z8;
            homeUiState = this;
        } else {
            imageBitmap2 = imageBitmap;
            homeUiState = this;
            i7 = i;
            z9 = z;
            serverModel2 = serverModel;
            str8 = str2;
            str9 = str3;
            str10 = str4;
            str11 = str5;
            str12 = str6;
            str13 = str7;
            z10 = z6;
            z11 = z8;
        }
        new HomeUiState(i7, z9, str14, listOf, serverModel2, str8, str9, str10, str11, str12, str13, z12, z13, z14, z15, i8, z10, z16, z11, i9, i10, i11, file2, imageBitmap2);
    }

    public final String getUpdateSize() {
        return this.updateSize;
    }

    public final List<NewsModel> getNewsList() {
        return this.newsList;
    }

    public final ServerModel getCurrentServer() {
        return this.currentServer;
    }

    public final String getForumLink() {
        return this.forumLink;
    }

    public final String getDiscLink() {
        return this.discLink;
    }

    public final String getVkLink() {
        return this.vkLink;
    }

    public final String getTgLink() {
        return this.tgLink;
    }

    public final String getWebsiteLink() {
        return this.websiteLink;
    }

    public final String getShopLink() {
        return this.shopLink;
    }

    public final boolean isCheckingFiles() {
        return this.isCheckingFiles;
    }

    public final boolean isPrivacyAccepted() {
        return this.isPrivacyAccepted;
    }

    public final boolean isUpdateNeeded() {
        return this.isUpdateNeeded;
    }

    public final boolean isFirstDownload() {
        return this.isFirstDownload;
    }

    public final int getXDonate() {
        return this.xDonate;
    }

    public final boolean isShopAllowed() {
        return this.isShopAllowed;
    }

    public final boolean isGameReady() {
        return this.isGameReady;
    }

    public final boolean isArizona() {
        return this.isArizona;
    }

    public final int getQueue() {
        return this.queue;
    }

    public final int getOnline() {
        return this.online;
    }

    public final int getVersion() {
        return this.version;
    }

    public final File getFile() {
        return this.file;
    }

    public final ImageBitmap getImageBitmap() {
        return this.imageBitmap;
    }

    /* compiled from: HomeUiState.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/miami/game/feature/home/ui/model/HomeUiState$Companion;", "", "<init>", "()V", "initial", "Lcom/miami/game/feature/home/ui/model/HomeUiState;", "isArisona", "", "isHw", "home"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HomeUiState initial(boolean z, boolean z2) {
            return new HomeUiState(z ? R.drawable.arizona_backgournd_home : R.drawable.rodina_backgournd_home, false, null, null, null, z ? "https://forum.arizona-rp.com/" : "https://forum.rodina-rp.com/", z ? "https://discord.com/invite/arizona-games" : "https://discord.com/invite/rodinagames", z ? "https://vk.com/arizonastaterp" : "https://vk.com/rodina_rp", z ? "https://t.me/arizona_rpcom" : "https://t.me/rodina_com", z ? "https://arizona-rp.com/" : "https://rodina-rp.com/", z ? "https://arizona-rp.com/shop" : "https://rodina-rp.com/shop", false, false, false, false, 0, !z2, false, z, 0, 0, 0, null, null, 16447500, null);
        }
    }
}
