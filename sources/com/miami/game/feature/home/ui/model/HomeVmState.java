package com.miami.game.feature.home.ui.model;

import com.miami.game.core.drawable.resources.R;
import com.miami.game.core.news.domain.NewsModel;
import com.miami.game.core.server.model.ServerModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HomeVmState.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001%BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\rHÆ\u0003JM\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lcom/miami/game/feature/home/ui/model/HomeVmState;", "", "backGroundId", "", "isProgressDownload", "", "percentageProgress", "", "updateSize", "newsList", "", "Lcom/miami/game/core/news/domain/NewsModel;", "currentServer", "Lcom/miami/game/core/server/model/ServerModel;", "<init>", "(IZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/miami/game/core/server/model/ServerModel;)V", "getBackGroundId", "()I", "()Z", "getPercentageProgress", "()Ljava/lang/String;", "getUpdateSize", "getNewsList", "()Ljava/util/List;", "getCurrentServer", "()Lcom/miami/game/core/server/model/ServerModel;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "Companion", "home_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HomeVmState {
    private final int backGroundId;
    private final ServerModel currentServer;
    private final boolean isProgressDownload;
    private final List<NewsModel> newsList;
    private final String percentageProgress;
    private final String updateSize;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ HomeVmState copy$default(HomeVmState homeVmState, int i, boolean z, String str, String str2, List list, ServerModel serverModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = homeVmState.backGroundId;
        }
        if ((i2 & 2) != 0) {
            z = homeVmState.isProgressDownload;
        }
        if ((i2 & 4) != 0) {
            str = homeVmState.percentageProgress;
        }
        if ((i2 & 8) != 0) {
            str2 = homeVmState.updateSize;
        }
        List<NewsModel> list2 = list;
        if ((i2 & 16) != 0) {
            list2 = homeVmState.newsList;
        }
        if ((i2 & 32) != 0) {
            serverModel = homeVmState.currentServer;
        }
        List list3 = list2;
        ServerModel serverModel2 = serverModel;
        return homeVmState.copy(i, z, str, str2, list3, serverModel2);
    }

    public final int component1() {
        return this.backGroundId;
    }

    public final boolean component2() {
        return this.isProgressDownload;
    }

    public final String component3() {
        return this.percentageProgress;
    }

    public final String component4() {
        return this.updateSize;
    }

    public final List<NewsModel> component5() {
        return this.newsList;
    }

    public final ServerModel component6() {
        return this.currentServer;
    }

    public final HomeVmState copy(int i, boolean z, String percentageProgress, String updateSize, List<NewsModel> newsList, ServerModel serverModel) {
        Intrinsics.checkNotNullParameter(percentageProgress, "percentageProgress");
        Intrinsics.checkNotNullParameter(updateSize, "updateSize");
        Intrinsics.checkNotNullParameter(newsList, "newsList");
        return new HomeVmState(i, z, percentageProgress, updateSize, newsList, serverModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HomeVmState) {
            HomeVmState homeVmState = (HomeVmState) obj;
            return this.backGroundId == homeVmState.backGroundId && this.isProgressDownload == homeVmState.isProgressDownload && Intrinsics.areEqual(this.percentageProgress, homeVmState.percentageProgress) && Intrinsics.areEqual(this.updateSize, homeVmState.updateSize) && Intrinsics.areEqual(this.newsList, homeVmState.newsList) && Intrinsics.areEqual(this.currentServer, homeVmState.currentServer);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((Integer.hashCode(this.backGroundId) * 31) + Boolean.hashCode(this.isProgressDownload)) * 31) + this.percentageProgress.hashCode()) * 31) + this.updateSize.hashCode()) * 31) + this.newsList.hashCode()) * 31;
        ServerModel serverModel = this.currentServer;
        return hashCode + (serverModel == null ? 0 : serverModel.hashCode());
    }

    public String toString() {
        int i = this.backGroundId;
        boolean z = this.isProgressDownload;
        String str = this.percentageProgress;
        String str2 = this.updateSize;
        List<NewsModel> list = this.newsList;
        return "HomeVmState(backGroundId=" + i + ", isProgressDownload=" + z + ", percentageProgress=" + str + ", updateSize=" + str2 + ", newsList=" + list + ", currentServer=" + this.currentServer + ")";
    }

    public HomeVmState(int i, boolean z, String percentageProgress, String updateSize, List<NewsModel> newsList, ServerModel serverModel) {
        Intrinsics.checkNotNullParameter(percentageProgress, "percentageProgress");
        Intrinsics.checkNotNullParameter(updateSize, "updateSize");
        Intrinsics.checkNotNullParameter(newsList, "newsList");
        this.backGroundId = i;
        this.isProgressDownload = z;
        this.percentageProgress = percentageProgress;
        this.updateSize = updateSize;
        this.newsList = newsList;
        this.currentServer = serverModel;
    }

    public final int getBackGroundId() {
        return this.backGroundId;
    }

    public final boolean isProgressDownload() {
        return this.isProgressDownload;
    }

    public final String getPercentageProgress() {
        return this.percentageProgress;
    }

    public /* synthetic */ HomeVmState(int i, boolean z, String str, String str2, List list, ServerModel serverModel, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, str, (i2 & 8) != 0 ? "" : str2, list, serverModel);
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

    /* compiled from: HomeVmState.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/feature/home/ui/model/HomeVmState$Companion;", "", "<init>", "()V", "initial", "Lcom/miami/game/feature/home/ui/model/HomeVmState;", "isArisona", "", "home_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HomeVmState initial(boolean z) {
            return new HomeVmState(z ? R.drawable.arizona_backgournd_home : R.drawable.rodina_backgournd_home, false, "0", null, CollectionsKt.emptyList(), null, 8, null);
        }
    }
}
