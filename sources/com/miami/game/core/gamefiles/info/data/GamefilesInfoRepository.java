package com.miami.game.core.gamefiles.info.data;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.miami.game.core.api.model.response.game_info.GameInfoApiModel;
import com.miami.game.core.api.model.response.game_info.GameInfoResponseApiModel;
import com.miami.game.core.domain.model.GameInfoFile;
import com.miami.game.core.gamefiles.info.data.api.GamefilesInfoApiRepository;
import com.miami.game.core.gamefiles.info.data.store.GameInfoPrefRepository;
import com.miami.game.core.gamefiles.info.domain.model.GameInfoFileData;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
/* compiled from: GamefilesInfoRepository.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/miami/game/core/gamefiles/info/data/GamefilesInfoRepository;", "", "gamefilesInfoApiRepository", "Lcom/miami/game/core/gamefiles/info/data/api/GamefilesInfoApiRepository;", "gameInfoPrefRepository", "Lcom/miami/game/core/gamefiles/info/data/store/GameInfoPrefRepository;", "<init>", "(Lcom/miami/game/core/gamefiles/info/data/api/GamefilesInfoApiRepository;Lcom/miami/game/core/gamefiles/info/data/store/GameInfoPrefRepository;)V", "getGameInfoFiles", "Lcom/miami/game/core/gamefiles/info/domain/model/GameInfoFileData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveGameInfoFiles", "", "gameInfoFileData", "", "Lcom/miami/game/core/domain/model/GameInfoFile;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "makeFilesList", "gameInfoResponseApiModel", "Lcom/miami/game/core/api/model/response/game_info/GameInfoResponseApiModel;", "appendData", "root", "Lcom/miami/game/core/api/model/response/game_info/GameInfoApiModel;", "appendedPath", "", "Companion", "gamefiles-info_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GamefilesInfoRepository {
    public static final Companion Companion = new Companion(null);
    public static final String FILE_KEY = "file";
    private final GameInfoPrefRepository gameInfoPrefRepository;
    private final GamefilesInfoApiRepository gamefilesInfoApiRepository;

    @Inject
    public GamefilesInfoRepository(GamefilesInfoApiRepository gamefilesInfoApiRepository, GameInfoPrefRepository gameInfoPrefRepository) {
        Intrinsics.checkNotNullParameter(gamefilesInfoApiRepository, "gamefilesInfoApiRepository");
        Intrinsics.checkNotNullParameter(gameInfoPrefRepository, "gameInfoPrefRepository");
        this.gamefilesInfoApiRepository = gamefilesInfoApiRepository;
        this.gameInfoPrefRepository = gameInfoPrefRepository;
    }

    /* compiled from: GamefilesInfoRepository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/miami/game/core/gamefiles/info/data/GamefilesInfoRepository$Companion;", "", "<init>", "()V", "FILE_KEY", "", "gamefiles-info_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final Object getGameInfoFiles(Continuation<? super GameInfoFileData> continuation) throws Exception {
        return BuildersKt.withContext(Dispatchers.getIO(), new GamefilesInfoRepository$getGameInfoFiles$2(this, null), continuation);
    }

    public final Object saveGameInfoFiles(List<GameInfoFile> list, Continuation<? super Unit> continuation) throws Exception {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new GamefilesInfoRepository$saveGameInfoFiles$2(list, this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<GameInfoFile> makeFilesList(GameInfoResponseApiModel gameInfoResponseApiModel) {
        return appendData$default(this, gameInfoResponseApiModel.getData(), null, 2, null);
    }

    static /* synthetic */ List appendData$default(GamefilesInfoRepository gamefilesInfoRepository, GameInfoApiModel gameInfoApiModel, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        return gamefilesInfoRepository.appendData(gameInfoApiModel, str);
    }

    private final List<GameInfoFile> appendData(GameInfoApiModel gameInfoApiModel, String str) {
        String type;
        List<GameInfoApiModel> data;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str2 = null;
        if ((gameInfoApiModel != null ? gameInfoApiModel.getName() : null) != null) {
            sb.append(RemoteSettings.FORWARD_SLASH_STRING + gameInfoApiModel.getName());
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        ArrayList arrayList = new ArrayList();
        if (gameInfoApiModel != null && (data = gameInfoApiModel.getData()) != null) {
            for (GameInfoApiModel gameInfoApiModel2 : data) {
                arrayList.addAll(appendData(gameInfoApiModel2, sb2));
            }
        }
        if (gameInfoApiModel != null && (type = gameInfoApiModel.getType()) != null) {
            str2 = type.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str2, "toLowerCase(...)");
        }
        if (Intrinsics.areEqual(str2, "file")) {
            arrayList.add(new GameInfoFile(sb2, gameInfoApiModel.getName(), gameInfoApiModel.getSize(), gameInfoApiModel.getHash(), gameInfoApiModel.getDateChange(), gameInfoApiModel.getGpuType(), false));
        }
        return arrayList;
    }
}
