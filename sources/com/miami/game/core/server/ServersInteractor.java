package com.miami.game.core.server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.miami.game.core.api.model.response.servers.ServersApiModelItem;
import com.miami.game.core.api.network.NetworkDataSource;
import com.miami.game.core.build.config.BuildConfigRepository;
import com.miami.game.core.local.repository.common.IKeyValueRepository;
import com.miami.game.core.local.repository.common.LocalRepository;
import com.miami.game.core.server.data.FavoriteServerDao;
import com.miami.game.core.server.data.FavoriteServerDatabase;
import com.miami.game.core.server.data.FavoriteServerEntity;
import com.miami.game.core.server.data.FavoriteServerEntityKt;
import com.miami.game.core.server.model.ServerModel;
import com.miami.game.core.server.model.ServerModelKt;
import com.miami.game.core.server.model.ServerStateCategory;
import com.miami.game.core.server.model.ServersState;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
/* compiled from: ServersInteractor.kt */
@Singleton
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0016J\u0018\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\u000e\u0010\u001e\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u001fJ\u0016\u0010!\u001a\u00020\u00162\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0019H\u0002J\u0016\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0019H\u0002J\u000e\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020'J\u000e\u0010*\u001a\u00020\u00162\u0006\u0010)\u001a\u00020'J\u000e\u0010+\u001a\u00020\u00162\u0006\u0010)\u001a\u00020'J\b\u0010,\u001a\u00020\u0016H\u0002J\u0016\u0010-\u001a\u00020\u00162\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0019H\u0002J\u0006\u0010.\u001a\u00020\u0016J\u0006\u0010/\u001a\u00020\u0016J\u0006\u00100\u001a\u00020\u0016J\u000e\u00101\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u001fJ\u000e\u00102\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u00064"}, d2 = {"Lcom/miami/game/core/server/ServersInteractor;", "", "buildConfig", "Lcom/miami/game/core/build/config/BuildConfigRepository;", "dataSource", "Lcom/miami/game/core/api/network/NetworkDataSource;", "localRepository", "Lcom/miami/game/core/local/repository/common/LocalRepository;", "favoriteServerDatabase", "Lcom/miami/game/core/server/data/FavoriteServerDatabase;", "<init>", "(Lcom/miami/game/core/build/config/BuildConfigRepository;Lcom/miami/game/core/api/network/NetworkDataSource;Lcom/miami/game/core/local/repository/common/LocalRepository;Lcom/miami/game/core/server/data/FavoriteServerDatabase;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "stateStore", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/core/server/model/ServersState;", "interactorStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getInteractorStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "initial", "", "retry", "readDataAssets", "", "Lcom/miami/game/core/api/model/response/servers/ServersApiModelItem;", "fileName", "", "observeFavorite", "checkFavorite", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firstLaunch", "updateFavorites", "favoritesList", "Lcom/miami/game/core/server/data/FavoriteServerEntity;", "getDonateMultiple", "", "list", "Lcom/miami/game/core/server/model/ServerModel;", "selectServer", "serverModel", "favoriteServer", "favoriteServerStartGame", "getCurrentServer", "getCurrentServerLocal", "filterMobileList", "filterDesktopList", "filterFavoriteList", "getServersMobileList", "getServersDesktopList", "Companion", "server_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServersInteractor {
    public static final String CURRENT_SERVER_KEY = "CURRENT_SERVER";
    public static final Companion Companion = new Companion(null);
    public static final String DESKTOP_LIST_KEY = "DESKTOP_SERVER_LIST";
    public static final String MOBILE_LIST_KEY = "MOBILE_SERVER_LIST";
    private final BuildConfigRepository buildConfig;
    private final NetworkDataSource dataSource;
    private final FavoriteServerDatabase favoriteServerDatabase;
    private final StateFlow<ServersState> interactorStateFlow;
    private final LocalRepository localRepository;
    private final CoroutineScope scope;
    private final MutableStateFlow<ServersState> stateStore;

    @Inject
    public ServersInteractor(BuildConfigRepository buildConfig, NetworkDataSource dataSource, LocalRepository localRepository, FavoriteServerDatabase favoriteServerDatabase) {
        Intrinsics.checkNotNullParameter(buildConfig, "buildConfig");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        Intrinsics.checkNotNullParameter(localRepository, "localRepository");
        Intrinsics.checkNotNullParameter(favoriteServerDatabase, "favoriteServerDatabase");
        this.buildConfig = buildConfig;
        this.dataSource = dataSource;
        this.localRepository = localRepository;
        this.favoriteServerDatabase = favoriteServerDatabase;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        MutableStateFlow<ServersState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ServersState(null, null, null, null, ServerStateCategory.Mobile, false, 0, 111, null));
        this.stateStore = MutableStateFlow;
        this.interactorStateFlow = FlowKt.asStateFlow(MutableStateFlow);
        initial();
        observeFavorite();
    }

    public final StateFlow<ServersState> getInteractorStateFlow() {
        return this.interactorStateFlow;
    }

    private final void initial() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getIO(), null, new ServersInteractor$initial$1(this, null), 2, null);
    }

    public final void retry() {
        initial();
    }

    private final List<ServersApiModelItem> readDataAssets(String str) {
        try {
            InputStream open = this.localRepository.getContext().getAssets().open(str);
            Intrinsics.checkNotNullExpressionValue(open, "open(...)");
            InputStreamReader inputStreamReader = new InputStreamReader(open, Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            String readText = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, null);
            return (List) new Gson().fromJson(readText, new TypeToken<List<? extends ServersApiModelItem>>() { // from class: com.miami.game.core.server.ServersInteractor$readDataAssets$listType$1
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final void observeFavorite() {
        FlowKt.launchIn(FlowKt.onEach(this.favoriteServerDatabase.favoriteServerDAO().getAllFlowFavoriteServers(), new ServersInteractor$observeFavorite$1(this, null)), this.scope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkFavorite(Continuation<? super Unit> continuation) {
        ServersInteractor$checkFavorite$1 serversInteractor$checkFavorite$1;
        int i;
        if (continuation instanceof ServersInteractor$checkFavorite$1) {
            serversInteractor$checkFavorite$1 = (ServersInteractor$checkFavorite$1) continuation;
            if ((serversInteractor$checkFavorite$1.label & Integer.MIN_VALUE) != 0) {
                serversInteractor$checkFavorite$1.label -= Integer.MIN_VALUE;
                Object obj = serversInteractor$checkFavorite$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = serversInteractor$checkFavorite$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    FavoriteServerDao favoriteServerDAO = this.favoriteServerDatabase.favoriteServerDAO();
                    serversInteractor$checkFavorite$1.label = 1;
                    obj = favoriteServerDAO.getAllFavoriteServers(serversInteractor$checkFavorite$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                updateFavorites((List) obj);
                return Unit.INSTANCE;
            }
        }
        serversInteractor$checkFavorite$1 = new ServersInteractor$checkFavorite$1(this, continuation);
        Object obj2 = serversInteractor$checkFavorite$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = serversInteractor$checkFavorite$1.label;
        if (i != 0) {
        }
        updateFavorites((List) obj2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object firstLaunch(Continuation<? super Unit> continuation) {
        ServersInteractor$firstLaunch$1 serversInteractor$firstLaunch$1;
        Object obj;
        int i;
        if (continuation instanceof ServersInteractor$firstLaunch$1) {
            serversInteractor$firstLaunch$1 = (ServersInteractor$firstLaunch$1) continuation;
            if ((serversInteractor$firstLaunch$1.label & Integer.MIN_VALUE) != 0) {
                serversInteractor$firstLaunch$1.label -= Integer.MIN_VALUE;
                obj = serversInteractor$firstLaunch$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = serversInteractor$firstLaunch$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    FavoriteServerDao favoriteServerDAO = this.favoriteServerDatabase.favoriteServerDAO();
                    serversInteractor$firstLaunch$1.label = 1;
                    obj = favoriteServerDAO.getAllFavoriteServers(serversInteractor$firstLaunch$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                if (!((List) obj).isEmpty()) {
                    filterFavoriteList();
                }
                return Unit.INSTANCE;
            }
        }
        serversInteractor$firstLaunch$1 = new ServersInteractor$firstLaunch$1(this, continuation);
        obj = serversInteractor$firstLaunch$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = serversInteractor$firstLaunch$1.label;
        if (i != 0) {
        }
        if (!((List) obj).isEmpty()) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFavorites(List<FavoriteServerEntity> list) {
        ServersState value;
        ServersState serversState;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        MutableStateFlow<ServersState> mutableStateFlow = this.stateStore;
        do {
            value = mutableStateFlow.getValue();
            serversState = value;
            arrayList = new ArrayList();
            arrayList2 = new ArrayList();
            for (ServerModel serverModel : serversState.getServerListMobile()) {
                ServerModel copy$default = ServerModel.copy$default(serverModel, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, list.contains(FavoriteServerEntityKt.toFavoriteEntity(serverModel)), false, false, 917503, null);
                arrayList.add(copy$default);
                if (copy$default.isFavorite()) {
                    arrayList2.add(copy$default);
                }
            }
            arrayList3 = new ArrayList();
            for (ServerModel serverModel2 : serversState.getServerListDesktop()) {
                ServerModel copy$default2 = ServerModel.copy$default(serverModel2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, list.contains(FavoriteServerEntityKt.toFavoriteEntity(serverModel2)), false, false, 917503, null);
                arrayList3.add(copy$default2);
                if (copy$default2.isFavorite()) {
                    arrayList2.add(copy$default2);
                }
            }
        } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default(serversState, null, CollectionsKt.toList(arrayList), CollectionsKt.toList(arrayList3), CollectionsKt.toList(arrayList2), null, false, getDonateMultiple(arrayList2), 49, null)));
    }

    private final int getDonateMultiple(List<ServerModel> list) {
        int i = 0;
        for (ServerModel serverModel : list) {
            Integer xdonate = serverModel.getXdonate();
            i = Math.max(i, xdonate != null ? xdonate.intValue() : 0);
        }
        return i;
    }

    public final void selectServer(ServerModel serverModel) {
        Intrinsics.checkNotNullParameter(serverModel, "serverModel");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new ServersInteractor$selectServer$1(this, serverModel, null), 3, null);
    }

    public final void favoriteServer(ServerModel serverModel) {
        Intrinsics.checkNotNullParameter(serverModel, "serverModel");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new ServersInteractor$favoriteServer$1(serverModel, this, null), 3, null);
    }

    public final void favoriteServerStartGame(ServerModel serverModel) {
        Intrinsics.checkNotNullParameter(serverModel, "serverModel");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new ServersInteractor$favoriteServerStartGame$1(serverModel, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getCurrentServer() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new ServersInteractor$getCurrentServer$1(this, null), 3, null);
    }

    private final void getCurrentServerLocal(List<ServerModel> list) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new ServersInteractor$getCurrentServerLocal$1(this, list, null), 3, null);
    }

    public final void filterMobileList() {
        ServersState value;
        MutableStateFlow<ServersState> mutableStateFlow = this.stateStore;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default(value, null, null, null, null, ServerStateCategory.Mobile, false, 0, 111, null)));
    }

    public final void filterDesktopList() {
        ServersState value;
        MutableStateFlow<ServersState> mutableStateFlow = this.stateStore;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default(value, null, null, null, null, ServerStateCategory.Desktop, false, 0, 111, null)));
    }

    public final void filterFavoriteList() {
        ServersState value;
        MutableStateFlow<ServersState> mutableStateFlow = this.stateStore;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default(value, null, null, null, null, ServerStateCategory.Favorite, false, 0, 111, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(16:1|(2:3|(14:5|6|7|(1:(1:(1:(1:(3:13|14|15)(2:17|18))(6:19|20|21|(1:22)|24|25))(5:29|30|(4:32|(2:35|33)|36|37)(1:44)|(5:39|(2:41|(2:43|27))|21|(1:22)|24)|25))(2:45|46))(3:98|99|(2:101|27))|47|48|(2:50|(3:52|(2:53|(1:56)(1:55))|57)(2:77|(6:81|(2:84|82)|85|86|(5:87|(2:90|88)|91|92|(1:95)(1:94))|96)))(1:97)|(5:63|(2:66|64)|67|68|(2:69|(1:72)(1:71)))(0)|74|(2:76|27)|30|(0)(0)|(0)|25))|106|6|7|(0)(0)|47|48|(0)(0)|(7:59|61|63|(1:64)|67|68|(3:69|(0)(0)|71))(0)|74|(0)|30|(0)(0)|(0)|25) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01f2, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01f3, code lost:
        timber.log.Timber.Forest.tag("ServersInteractor").d(java.lang.String.valueOf(r0.getMessage()), new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0298, code lost:
        timber.log.Timber.Forest.tag("ServersInteractor").d(java.lang.String.valueOf(r0.getMessage()), new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x02b7, code lost:
        if (checkFavorite(r2) != r3) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0206 A[EDGE_INSN: B:108:0x0206->B:74:0x0206 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f A[Catch: Exception -> 0x01f2, TRY_ENTER, TryCatch #1 {Exception -> 0x01f2, blocks: (B:24:0x0069, B:30:0x0099, B:33:0x009f, B:35:0x00a8, B:36:0x00ad, B:59:0x0189, B:61:0x018f, B:63:0x0198, B:64:0x01a9, B:66:0x01af, B:67:0x01c3, B:68:0x01ca, B:40:0x00e9, B:42:0x00f1, B:44:0x00fa, B:45:0x010c, B:47:0x0112, B:48:0x0127, B:49:0x012e, B:50:0x0148, B:52:0x014e, B:53:0x0163, B:27:0x0070), top: B:101:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01af A[Catch: Exception -> 0x01f2, LOOP:3: B:64:0x01a9->B:66:0x01af, LOOP_END, TryCatch #1 {Exception -> 0x01f2, blocks: (B:24:0x0069, B:30:0x0099, B:33:0x009f, B:35:0x00a8, B:36:0x00ad, B:59:0x0189, B:61:0x018f, B:63:0x0198, B:64:0x01a9, B:66:0x01af, B:67:0x01c3, B:68:0x01ca, B:40:0x00e9, B:42:0x00f1, B:44:0x00fa, B:45:0x010c, B:47:0x0112, B:48:0x0127, B:49:0x012e, B:50:0x0148, B:52:0x014e, B:53:0x0163, B:27:0x0070), top: B:101:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ef A[LOOP:4: B:68:0x01ca->B:71:0x01ef, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x021c A[Catch: Exception -> 0x005c, TryCatch #0 {Exception -> 0x005c, blocks: (B:18:0x0052, B:91:0x026f, B:92:0x0271, B:19:0x0057, B:77:0x0218, B:79:0x021c, B:80:0x022d, B:82:0x0233, B:83:0x0247, B:86:0x024d, B:88:0x0259, B:74:0x0206), top: B:101:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x024d A[Catch: Exception -> 0x005c, TryCatch #0 {Exception -> 0x005c, blocks: (B:18:0x0052, B:91:0x026f, B:92:0x0271, B:19:0x0057, B:77:0x0218, B:79:0x021c, B:80:0x022d, B:82:0x0233, B:83:0x0247, B:86:0x024d, B:88:0x0259, B:74:0x0206), top: B:101:0x0031 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getServersMobileList(Continuation<? super Unit> continuation) {
        ServersInteractor$getServersMobileList$1 serversInteractor$getServersMobileList$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        List list;
        ArrayList arrayList;
        MutableStateFlow<ServersState> mutableStateFlow;
        ServersState value;
        List<ServerModel> list2;
        List<ServerModel> list3;
        List<ServersApiModelItem> readDataAssets;
        List<ServerModel> list4;
        MutableStateFlow<ServersState> mutableStateFlow2;
        ServersState value2;
        List<ServerModel> list5;
        if (continuation instanceof ServersInteractor$getServersMobileList$1) {
            serversInteractor$getServersMobileList$1 = (ServersInteractor$getServersMobileList$1) continuation;
            if ((serversInteractor$getServersMobileList$1.label & Integer.MIN_VALUE) != 0) {
                serversInteractor$getServersMobileList$1.label -= Integer.MIN_VALUE;
                obj = serversInteractor$getServersMobileList$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = serversInteractor$getServersMobileList$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    LocalRepository localRepository = this.localRepository;
                    serversInteractor$getServersMobileList$1.L$0 = SpillingKt.nullOutSpilledVariable(localRepository);
                    serversInteractor$getServersMobileList$1.L$1 = SpillingKt.nullOutSpilledVariable(MOBILE_LIST_KEY);
                    serversInteractor$getServersMobileList$1.I$0 = 0;
                    serversInteractor$getServersMobileList$1.label = 1;
                    obj = BuildersKt.withContext(Dispatchers.getIO(), new ServersInteractor$getServersMobileList$$inlined$getSuspend$1(localRepository, MOBILE_LIST_KEY, null), serversInteractor$getServersMobileList$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    int i2 = serversInteractor$getServersMobileList$1.I$0;
                    String str = (String) serversInteractor$getServersMobileList$1.L$1;
                    IKeyValueRepository iKeyValueRepository = (IKeyValueRepository) serversInteractor$getServersMobileList$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    list = (List) obj;
                    if (list != null) {
                        List<ServersApiModelItem> list6 = list;
                        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                        for (ServersApiModelItem serversApiModelItem : list6) {
                            arrayList2.add(ServerModelKt.toDomain(serversApiModelItem, true, this.buildConfig.isArizona()));
                        }
                        arrayList = arrayList2;
                    } else {
                        arrayList = null;
                    }
                    if (arrayList != null) {
                        getCurrentServer();
                        if (!arrayList.isEmpty()) {
                            LocalRepository localRepository2 = this.localRepository;
                            serversInteractor$getServersMobileList$1.L$0 = arrayList;
                            serversInteractor$getServersMobileList$1.L$1 = SpillingKt.nullOutSpilledVariable(arrayList);
                            serversInteractor$getServersMobileList$1.I$0 = 0;
                            serversInteractor$getServersMobileList$1.label = 3;
                            if (localRepository2.save2(MOBILE_LIST_KEY, (String) arrayList, (Continuation<? super Unit>) serversInteractor$getServersMobileList$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        mutableStateFlow = this.stateStore;
                        do {
                            value = mutableStateFlow.getValue();
                        } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default(value, null, CollectionsKt.toList(arrayList), null, null, null, false, 0, 125, null)));
                    }
                    serversInteractor$getServersMobileList$1.L$0 = null;
                    serversInteractor$getServersMobileList$1.L$1 = null;
                    serversInteractor$getServersMobileList$1.label = 4;
                } else if (i != 3) {
                    if (i == 4) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i3 = serversInteractor$getServersMobileList$1.I$0;
                    List list7 = (List) serversInteractor$getServersMobileList$1.L$1;
                    arrayList = (List) serversInteractor$getServersMobileList$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    mutableStateFlow = this.stateStore;
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default(value, null, CollectionsKt.toList(arrayList), null, null, null, false, 0, 125, null)));
                    serversInteractor$getServersMobileList$1.L$0 = null;
                    serversInteractor$getServersMobileList$1.L$1 = null;
                    serversInteractor$getServersMobileList$1.label = 4;
                }
                list2 = (List) obj;
                if (list2 == null) {
                    if (!list2.isEmpty()) {
                        getCurrentServerLocal(list2);
                        MutableStateFlow<ServersState> mutableStateFlow3 = this.stateStore;
                        while (true) {
                            ServersState value3 = mutableStateFlow3.getValue();
                            MutableStateFlow<ServersState> mutableStateFlow4 = mutableStateFlow3;
                            list3 = list2;
                            if (mutableStateFlow4.compareAndSet(value3, ServersState.copy$default(value3, null, list3, null, null, null, false, 0, 125, null))) {
                                break;
                            }
                            mutableStateFlow3 = mutableStateFlow4;
                            list2 = list3;
                        }
                    } else {
                        list3 = list2;
                        List<ServersApiModelItem> readDataAssets2 = readDataAssets("server_mobile.json");
                        if (readDataAssets2 != null && !readDataAssets2.isEmpty()) {
                            List<ServersApiModelItem> list8 = readDataAssets2;
                            List<ServerModel> arrayList3 = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(list8, 10));
                            for (ServersApiModelItem serversApiModelItem2 : list8) {
                                arrayList3.add(ServerModelKt.toDomain(serversApiModelItem2, true, this.buildConfig.isArizona()));
                            }
                            getCurrentServerLocal(arrayList3);
                            MutableStateFlow<ServersState> mutableStateFlow5 = this.stateStore;
                            while (true) {
                                ServersState value4 = mutableStateFlow5.getValue();
                                ServersState serversState = value4;
                                List<ServersApiModelItem> list9 = readDataAssets2;
                                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list9, 10));
                                for (ServersApiModelItem serversApiModelItem3 : list9) {
                                    arrayList4.add(ServerModelKt.toDomain(serversApiModelItem3, true, this.buildConfig.isArizona()));
                                }
                                if (mutableStateFlow5.compareAndSet(value4, ServersState.copy$default(serversState, null, arrayList4, null, null, null, false, 0, 125, null))) {
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    list3 = list2;
                }
                if (list3 == null && (readDataAssets = readDataAssets("server_mobile.json")) != null && !readDataAssets.isEmpty()) {
                    List<ServersApiModelItem> list10 = readDataAssets;
                    List<ServerModel> arrayList5 = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(list10, 10));
                    for (ServersApiModelItem serversApiModelItem4 : list10) {
                        arrayList5.add(ServerModelKt.toDomain(serversApiModelItem4, false, this.buildConfig.isArizona()));
                    }
                    list4 = arrayList5;
                    getCurrentServerLocal(list4);
                    mutableStateFlow2 = this.stateStore;
                    while (true) {
                        value2 = mutableStateFlow2.getValue();
                        list5 = list4;
                        if (!mutableStateFlow2.compareAndSet(value2, ServersState.copy$default(value2, null, list5, null, null, null, false, 0, 125, null))) {
                            break;
                        }
                        list4 = list5;
                    }
                }
                NetworkDataSource networkDataSource = this.dataSource;
                serversInteractor$getServersMobileList$1.L$0 = null;
                serversInteractor$getServersMobileList$1.L$1 = null;
                serversInteractor$getServersMobileList$1.label = 2;
                obj = networkDataSource.getServersMobile(serversInteractor$getServersMobileList$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = (List) obj;
                if (list != null) {
                }
                if (arrayList != null) {
                }
                serversInteractor$getServersMobileList$1.L$0 = null;
                serversInteractor$getServersMobileList$1.L$1 = null;
                serversInteractor$getServersMobileList$1.label = 4;
            }
        }
        serversInteractor$getServersMobileList$1 = new ServersInteractor$getServersMobileList$1(this, continuation);
        obj = serversInteractor$getServersMobileList$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = serversInteractor$getServersMobileList$1.label;
        if (i != 0) {
        }
        list2 = (List) obj;
        if (list2 == null) {
        }
        if (list3 == null) {
            List<ServersApiModelItem> list102 = readDataAssets;
            List<ServerModel> arrayList52 = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(list102, 10));
            while (r0.hasNext()) {
            }
            list4 = arrayList52;
            getCurrentServerLocal(list4);
            mutableStateFlow2 = this.stateStore;
            while (true) {
                value2 = mutableStateFlow2.getValue();
                list5 = list4;
                if (!mutableStateFlow2.compareAndSet(value2, ServersState.copy$default(value2, null, list5, null, null, null, false, 0, 125, null))) {
                }
                list4 = list5;
            }
        }
        NetworkDataSource networkDataSource2 = this.dataSource;
        serversInteractor$getServersMobileList$1.L$0 = null;
        serversInteractor$getServersMobileList$1.L$1 = null;
        serversInteractor$getServersMobileList$1.label = 2;
        obj = networkDataSource2.getServersMobile(serversInteractor$getServersMobileList$1);
        if (obj == coroutine_suspended) {
        }
        list = (List) obj;
        if (list != null) {
        }
        if (arrayList != null) {
        }
        serversInteractor$getServersMobileList$1.L$0 = null;
        serversInteractor$getServersMobileList$1.L$1 = null;
        serversInteractor$getServersMobileList$1.label = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(16:1|(2:3|(14:5|6|7|(1:(1:(1:(1:(3:13|14|15)(2:17|18))(6:19|20|21|(1:22)|24|25))(5:29|30|(4:32|(2:35|33)|36|37)(1:44)|(5:39|(2:41|(2:43|27))|21|(1:22)|24)|25))(2:45|46))(3:93|94|(2:96|27))|47|48|(2:50|(3:52|(2:53|(1:56)(1:55))|57)(2:77|(6:81|(2:84|82)|85|86|(2:87|(1:90)(1:89))|91)))(1:92)|(5:63|(2:66|64)|67|68|(2:69|(1:72)(1:71)))(0)|74|(2:76|27)|30|(0)(0)|(0)|25))|101|6|7|(0)(0)|47|48|(0)(0)|(7:59|61|63|(1:64)|67|68|(3:69|(0)(0)|71))(0)|74|(0)|30|(0)(0)|(0)|25) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01b3, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01b4, code lost:
        timber.log.Timber.Forest.tag("ServersInteractor").d(java.lang.String.valueOf(r0.getMessage()), new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0252, code lost:
        timber.log.Timber.Forest.tag("ServersInteractor").d(java.lang.String.valueOf(r0.getMessage()), new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x026f, code lost:
        if (checkFavorite(r2) != r3) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01c7 A[EDGE_INSN: B:104:0x01c7->B:70:0x01c7 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f A[Catch: Exception -> 0x01b3, TRY_ENTER, TryCatch #1 {Exception -> 0x01b3, blocks: (B:24:0x0069, B:30:0x0099, B:33:0x009f, B:35:0x00a8, B:36:0x00ad, B:55:0x014c, B:57:0x0152, B:59:0x015b, B:60:0x016c, B:62:0x0172, B:63:0x0186, B:64:0x018d, B:40:0x00dd, B:42:0x00e5, B:44:0x00ee, B:45:0x00ff, B:47:0x0105, B:48:0x0119, B:49:0x0120, B:27:0x0070), top: B:97:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0172 A[Catch: Exception -> 0x01b3, LOOP:3: B:60:0x016c->B:62:0x0172, LOOP_END, TryCatch #1 {Exception -> 0x01b3, blocks: (B:24:0x0069, B:30:0x0099, B:33:0x009f, B:35:0x00a8, B:36:0x00ad, B:55:0x014c, B:57:0x0152, B:59:0x015b, B:60:0x016c, B:62:0x0172, B:63:0x0186, B:64:0x018d, B:40:0x00dd, B:42:0x00e5, B:44:0x00ee, B:45:0x00ff, B:47:0x0105, B:48:0x0119, B:49:0x0120, B:27:0x0070), top: B:97:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01b0 A[LOOP:4: B:64:0x018d->B:67:0x01b0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01db A[Catch: Exception -> 0x005c, TryCatch #0 {Exception -> 0x005c, blocks: (B:18:0x0052, B:87:0x022a, B:88:0x0231, B:19:0x0057, B:73:0x01d7, B:75:0x01db, B:76:0x01ec, B:78:0x01f2, B:79:0x0206, B:82:0x020c, B:84:0x0215, B:70:0x01c7), top: B:97:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x020c A[Catch: Exception -> 0x005c, TryCatch #0 {Exception -> 0x005c, blocks: (B:18:0x0052, B:87:0x022a, B:88:0x0231, B:19:0x0057, B:73:0x01d7, B:75:0x01db, B:76:0x01ec, B:78:0x01f2, B:79:0x0206, B:82:0x020c, B:84:0x0215, B:70:0x01c7), top: B:97:0x0031 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getServersDesktopList(Continuation<? super Unit> continuation) {
        ServersInteractor$getServersDesktopList$1 serversInteractor$getServersDesktopList$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        List list;
        ArrayList arrayList;
        List list2;
        MutableStateFlow<ServersState> mutableStateFlow;
        ServersState value;
        List<ServerModel> list3;
        List<ServerModel> list4;
        List<ServersApiModelItem> readDataAssets;
        List<ServerModel> list5;
        MutableStateFlow<ServersState> mutableStateFlow2;
        ServersState value2;
        List<ServerModel> list6;
        if (continuation instanceof ServersInteractor$getServersDesktopList$1) {
            serversInteractor$getServersDesktopList$1 = (ServersInteractor$getServersDesktopList$1) continuation;
            if ((serversInteractor$getServersDesktopList$1.label & Integer.MIN_VALUE) != 0) {
                serversInteractor$getServersDesktopList$1.label -= Integer.MIN_VALUE;
                obj = serversInteractor$getServersDesktopList$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = serversInteractor$getServersDesktopList$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    LocalRepository localRepository = this.localRepository;
                    serversInteractor$getServersDesktopList$1.L$0 = SpillingKt.nullOutSpilledVariable(localRepository);
                    serversInteractor$getServersDesktopList$1.L$1 = SpillingKt.nullOutSpilledVariable(DESKTOP_LIST_KEY);
                    serversInteractor$getServersDesktopList$1.I$0 = 0;
                    serversInteractor$getServersDesktopList$1.label = 1;
                    obj = BuildersKt.withContext(Dispatchers.getIO(), new ServersInteractor$getServersDesktopList$$inlined$getSuspend$1(localRepository, DESKTOP_LIST_KEY, null), serversInteractor$getServersDesktopList$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    int i2 = serversInteractor$getServersDesktopList$1.I$0;
                    String str = (String) serversInteractor$getServersDesktopList$1.L$1;
                    IKeyValueRepository iKeyValueRepository = (IKeyValueRepository) serversInteractor$getServersDesktopList$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    list = (List) obj;
                    if (list != null) {
                        List<ServersApiModelItem> list7 = list;
                        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
                        for (ServersApiModelItem serversApiModelItem : list7) {
                            arrayList2.add(ServerModelKt.toDomain(serversApiModelItem, false, this.buildConfig.isArizona()));
                        }
                        arrayList = arrayList2;
                    } else {
                        arrayList = null;
                    }
                    if (arrayList != null) {
                        if (!arrayList.isEmpty()) {
                            LocalRepository localRepository2 = this.localRepository;
                            serversInteractor$getServersDesktopList$1.L$0 = arrayList;
                            serversInteractor$getServersDesktopList$1.L$1 = SpillingKt.nullOutSpilledVariable(arrayList);
                            serversInteractor$getServersDesktopList$1.I$0 = 0;
                            serversInteractor$getServersDesktopList$1.label = 3;
                            if (localRepository2.save2(DESKTOP_LIST_KEY, (String) arrayList, (Continuation<? super Unit>) serversInteractor$getServersDesktopList$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        list2 = arrayList;
                        getCurrentServer();
                        mutableStateFlow = this.stateStore;
                        do {
                            value = mutableStateFlow.getValue();
                        } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default(value, null, null, list2, null, null, false, 0, 123, null)));
                    }
                    serversInteractor$getServersDesktopList$1.L$0 = null;
                    serversInteractor$getServersDesktopList$1.L$1 = null;
                    serversInteractor$getServersDesktopList$1.label = 4;
                } else if (i != 3) {
                    if (i == 4) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i3 = serversInteractor$getServersDesktopList$1.I$0;
                    List list8 = (List) serversInteractor$getServersDesktopList$1.L$1;
                    arrayList = (List) serversInteractor$getServersDesktopList$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    list2 = arrayList;
                    getCurrentServer();
                    mutableStateFlow = this.stateStore;
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default(value, null, null, list2, null, null, false, 0, 123, null)));
                    serversInteractor$getServersDesktopList$1.L$0 = null;
                    serversInteractor$getServersDesktopList$1.L$1 = null;
                    serversInteractor$getServersDesktopList$1.label = 4;
                }
                list3 = (List) obj;
                if (list3 != null) {
                    list4 = list3;
                } else if (!list3.isEmpty()) {
                    getCurrentServerLocal(list3);
                    MutableStateFlow<ServersState> mutableStateFlow3 = this.stateStore;
                    while (true) {
                        ServersState value3 = mutableStateFlow3.getValue();
                        list4 = list3;
                        if (mutableStateFlow3.compareAndSet(value3, ServersState.copy$default(value3, null, null, list4, null, null, false, 0, 123, null))) {
                            break;
                        }
                        list3 = list4;
                    }
                } else {
                    list4 = list3;
                    List<ServersApiModelItem> readDataAssets2 = readDataAssets("server_desktop.json");
                    if (readDataAssets2 != null && !readDataAssets2.isEmpty()) {
                        List<ServersApiModelItem> list9 = readDataAssets2;
                        List<ServerModel> arrayList3 = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(list9, 10));
                        for (ServersApiModelItem serversApiModelItem2 : list9) {
                            arrayList3.add(ServerModelKt.toDomain(serversApiModelItem2, false, this.buildConfig.isArizona()));
                        }
                        List<ServerModel> list10 = arrayList3;
                        getCurrentServerLocal(list10);
                        MutableStateFlow<ServersState> mutableStateFlow4 = this.stateStore;
                        while (true) {
                            ServersState value4 = mutableStateFlow4.getValue();
                            List<ServerModel> list11 = list10;
                            if (mutableStateFlow4.compareAndSet(value4, ServersState.copy$default(value4, null, null, list11, null, null, false, 0, 123, null))) {
                                break;
                            }
                            list10 = list11;
                        }
                    }
                }
                if (list4 == null && (readDataAssets = readDataAssets("server_desktop.json")) != null && !readDataAssets.isEmpty()) {
                    List<ServersApiModelItem> list12 = readDataAssets;
                    List<ServerModel> arrayList4 = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(list12, 10));
                    for (ServersApiModelItem serversApiModelItem3 : list12) {
                        arrayList4.add(ServerModelKt.toDomain(serversApiModelItem3, false, this.buildConfig.isArizona()));
                    }
                    list5 = arrayList4;
                    getCurrentServerLocal(list5);
                    mutableStateFlow2 = this.stateStore;
                    while (true) {
                        value2 = mutableStateFlow2.getValue();
                        list6 = list5;
                        if (!mutableStateFlow2.compareAndSet(value2, ServersState.copy$default(value2, null, null, list6, null, null, false, 0, 123, null))) {
                            break;
                        }
                        list5 = list6;
                    }
                }
                NetworkDataSource networkDataSource = this.dataSource;
                serversInteractor$getServersDesktopList$1.L$0 = null;
                serversInteractor$getServersDesktopList$1.L$1 = null;
                serversInteractor$getServersDesktopList$1.label = 2;
                obj = networkDataSource.getServersDesktop(serversInteractor$getServersDesktopList$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = (List) obj;
                if (list != null) {
                }
                if (arrayList != null) {
                }
                serversInteractor$getServersDesktopList$1.L$0 = null;
                serversInteractor$getServersDesktopList$1.L$1 = null;
                serversInteractor$getServersDesktopList$1.label = 4;
            }
        }
        serversInteractor$getServersDesktopList$1 = new ServersInteractor$getServersDesktopList$1(this, continuation);
        obj = serversInteractor$getServersDesktopList$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = serversInteractor$getServersDesktopList$1.label;
        if (i != 0) {
        }
        list3 = (List) obj;
        if (list3 != null) {
        }
        if (list4 == null) {
            List<ServersApiModelItem> list122 = readDataAssets;
            List<ServerModel> arrayList42 = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(list122, 10));
            while (r0.hasNext()) {
            }
            list5 = arrayList42;
            getCurrentServerLocal(list5);
            mutableStateFlow2 = this.stateStore;
            while (true) {
                value2 = mutableStateFlow2.getValue();
                list6 = list5;
                if (!mutableStateFlow2.compareAndSet(value2, ServersState.copy$default(value2, null, null, list6, null, null, false, 0, 123, null))) {
                }
                list5 = list6;
            }
        }
        NetworkDataSource networkDataSource2 = this.dataSource;
        serversInteractor$getServersDesktopList$1.L$0 = null;
        serversInteractor$getServersDesktopList$1.L$1 = null;
        serversInteractor$getServersDesktopList$1.label = 2;
        obj = networkDataSource2.getServersDesktop(serversInteractor$getServersDesktopList$1);
        if (obj == coroutine_suspended) {
        }
        list = (List) obj;
        if (list != null) {
        }
        if (arrayList != null) {
        }
        serversInteractor$getServersDesktopList$1.L$0 = null;
        serversInteractor$getServersDesktopList$1.L$1 = null;
        serversInteractor$getServersDesktopList$1.label = 4;
    }

    /* compiled from: ServersInteractor.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/miami/game/core/server/ServersInteractor$Companion;", "", "<init>", "()V", "CURRENT_SERVER_KEY", "", "MOBILE_LIST_KEY", "DESKTOP_LIST_KEY", "server_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
