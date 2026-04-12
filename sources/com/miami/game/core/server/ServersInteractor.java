package com.miami.game.core.server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.miami.game.core.api.model.response.servers.ServersApiModelItem;
import com.miami.game.core.api.network.NetworkDataSource;
import com.miami.game.core.build.config.BuildConfigRepository;
import com.miami.game.core.design.system.component.background.LauncherBackgroundWriter;
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
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0016J\u0018\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\u000e\u0010\u001e\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u001fJ\u0016\u0010!\u001a\u00020\u00162\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0019H\u0002J\u0016\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0019H\u0002J\u000e\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020'J\u0016\u0010*\u001a\u00020\u00162\u0006\u0010)\u001a\u00020'H\u0082@¢\u0006\u0002\u0010+J\u000e\u0010,\u001a\u00020\u00162\u0006\u0010)\u001a\u00020'J\u000e\u0010-\u001a\u00020\u00162\u0006\u0010)\u001a\u00020'J\u000e\u0010.\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u001fJ\u0006\u0010/\u001a\u00020\u0016J\u0006\u00100\u001a\u00020\u0016J\u0006\u00101\u001a\u00020\u0016J\u000e\u00102\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u001fJ\u000e\u00103\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u001fJ\u000e\u00104\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u00066"}, d2 = {"Lcom/miami/game/core/server/ServersInteractor;", "", "buildConfig", "Lcom/miami/game/core/build/config/BuildConfigRepository;", "dataSource", "Lcom/miami/game/core/api/network/NetworkDataSource;", "localRepository", "Lcom/miami/game/core/local/repository/common/LocalRepository;", "favoriteServerDatabase", "Lcom/miami/game/core/server/data/FavoriteServerDatabase;", "<init>", "(Lcom/miami/game/core/build/config/BuildConfigRepository;Lcom/miami/game/core/api/network/NetworkDataSource;Lcom/miami/game/core/local/repository/common/LocalRepository;Lcom/miami/game/core/server/data/FavoriteServerDatabase;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "stateStore", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/core/server/model/ServersState;", "interactorStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getInteractorStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "initial", "", "retry", "readDataAssets", "", "Lcom/miami/game/core/api/model/response/servers/ServersApiModelItem;", "fileName", "", "observeFavorite", "checkFavorite", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firstLaunch", "updateFavorites", "favoritesList", "Lcom/miami/game/core/server/data/FavoriteServerEntity;", "getDonateMultiple", "", "list", "Lcom/miami/game/core/server/model/ServerModel;", "selectServer", "serverModel", "selectServerInternal", "(Lcom/miami/game/core/server/model/ServerModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "favoriteServer", "favoriteServerStartGame", "getCurrentServer", "filterMobileList", "filterDesktopList", "filterFavoriteList", "getServersMobileList", "getServersDesktopList", "getServersVcList", "Companion", "server"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServersInteractor {
    public static final String CURRENT_SERVER_KEY = "CURRENT_SERVER";
    public static final Companion Companion = new Companion(null);
    public static final String DESKTOP_LIST_KEY = "DESKTOP_SERVER_LIST";
    public static final String MOBILE_LIST_KEY = "MOBILE_SERVER_LIST";
    public static final String VC_LIST_KEY = "VC_SERVER_LIST";
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
        MutableStateFlow<ServersState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ServersState(null, null, null, null, null, ServerStateCategory.Mobile, false, 0, 223, null));
        this.stateStore = MutableStateFlow;
        this.interactorStateFlow = FlowKt.asStateFlow(MutableStateFlow);
        initial();
        observeFavorite();
    }

    public final StateFlow<ServersState> getInteractorStateFlow() {
        return this.interactorStateFlow;
    }

    private final void initial() {
        LauncherBackgroundWriter.INSTANCE.setParams(this.localRepository.getContext(), this.buildConfig.isArizona());
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
                ServerModel copy$default = ServerModel.copy$default(serverModel, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, list.contains(FavoriteServerEntityKt.toFavoriteEntity(serverModel)), false, false, 1835007, null);
                arrayList.add(copy$default);
                if (copy$default.isFavorite()) {
                    arrayList2.add(copy$default);
                }
            }
            arrayList3 = new ArrayList();
            for (ServerModel serverModel2 : serversState.getServerListDesktop()) {
                ServerModel copy$default2 = ServerModel.copy$default(serverModel2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, list.contains(FavoriteServerEntityKt.toFavoriteEntity(serverModel2)), false, false, 1835007, null);
                arrayList3.add(copy$default2);
                if (copy$default2.isFavorite()) {
                    arrayList2.add(copy$default2);
                }
            }
        } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default(serversState, null, CollectionsKt.toList(arrayList), CollectionsKt.toList(arrayList3), null, CollectionsKt.toList(arrayList2), null, false, getDonateMultiple(arrayList2), 105, null)));
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object selectServerInternal(ServerModel serverModel, Continuation<? super Unit> continuation) {
        ServersInteractor$selectServerInternal$1 serversInteractor$selectServerInternal$1;
        int i;
        ServerModel serverModel2;
        MutableStateFlow<ServersState> mutableStateFlow;
        ServersState value;
        if (continuation instanceof ServersInteractor$selectServerInternal$1) {
            serversInteractor$selectServerInternal$1 = (ServersInteractor$selectServerInternal$1) continuation;
            if ((serversInteractor$selectServerInternal$1.label & Integer.MIN_VALUE) != 0) {
                serversInteractor$selectServerInternal$1.label -= Integer.MIN_VALUE;
                Object obj = serversInteractor$selectServerInternal$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = serversInteractor$selectServerInternal$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    LocalRepository localRepository = this.localRepository;
                    serversInteractor$selectServerInternal$1.L$0 = serverModel;
                    serversInteractor$selectServerInternal$1.label = 1;
                    if (localRepository.save2(CURRENT_SERVER_KEY, (String) serverModel, (Continuation<? super Unit>) serversInteractor$selectServerInternal$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    serverModel = (ServerModel) serversInteractor$selectServerInternal$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                serverModel2 = serverModel;
                mutableStateFlow = this.stateStore;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default(value, serverModel2, null, null, null, null, null, false, 0, 254, null)));
                return Unit.INSTANCE;
            }
        }
        serversInteractor$selectServerInternal$1 = new ServersInteractor$selectServerInternal$1(this, continuation);
        Object obj2 = serversInteractor$selectServerInternal$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = serversInteractor$selectServerInternal$1.label;
        if (i != 0) {
        }
        serverModel2 = serverModel;
        mutableStateFlow = this.stateStore;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default(value, serverModel2, null, null, null, null, null, false, 0, 254, null)));
        return Unit.INSTANCE;
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
    /* JADX WARN: Code restructure failed: missing block: B:17:0x007e, code lost:
        if (r1 == r3) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ae, code lost:
        if (selectServerInternal(r1, r2) == r3) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b0, code lost:
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b1 A[LOOP:0: B:26:0x00b1->B:27:0x00cb, LOOP_START] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getCurrentServer(Continuation<? super Unit> continuation) {
        ServersInteractor$getCurrentServer$1 serversInteractor$getCurrentServer$1;
        int i;
        ServerModel serverModel;
        ServersState value;
        if (continuation instanceof ServersInteractor$getCurrentServer$1) {
            serversInteractor$getCurrentServer$1 = (ServersInteractor$getCurrentServer$1) continuation;
            if ((serversInteractor$getCurrentServer$1.label & Integer.MIN_VALUE) != 0) {
                serversInteractor$getCurrentServer$1.label -= Integer.MIN_VALUE;
                Object obj = serversInteractor$getCurrentServer$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = serversInteractor$getCurrentServer$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    LocalRepository localRepository = this.localRepository;
                    serversInteractor$getCurrentServer$1.L$0 = SpillingKt.nullOutSpilledVariable(localRepository);
                    serversInteractor$getCurrentServer$1.L$1 = SpillingKt.nullOutSpilledVariable(CURRENT_SERVER_KEY);
                    serversInteractor$getCurrentServer$1.I$0 = 0;
                    serversInteractor$getCurrentServer$1.label = 1;
                    obj = BuildersKt.withContext(Dispatchers.getIO(), new ServersInteractor$getCurrentServer$$inlined$getSuspend$1(localRepository, CURRENT_SERVER_KEY, null), serversInteractor$getCurrentServer$1);
                } else if (i != 1) {
                    if (i == 2) {
                        int i2 = serversInteractor$getCurrentServer$1.I$0;
                        ServerModel serverModel2 = (ServerModel) serversInteractor$getCurrentServer$1.L$1;
                        ServerModel serverModel3 = (ServerModel) serversInteractor$getCurrentServer$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i3 = serversInteractor$getCurrentServer$1.I$0;
                    String str = (String) serversInteractor$getCurrentServer$1.L$1;
                    IKeyValueRepository iKeyValueRepository = (IKeyValueRepository) serversInteractor$getCurrentServer$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                serverModel = (ServerModel) obj;
                MutableStateFlow<ServersState> mutableStateFlow = this.stateStore;
                if (serverModel != null) {
                    ServerModel serverModel4 = (ServerModel) CollectionsKt.firstOrNull((List<? extends Object>) mutableStateFlow.getValue().getServerListMobile());
                    if (serverModel4 != null) {
                        serversInteractor$getCurrentServer$1.L$0 = SpillingKt.nullOutSpilledVariable(serverModel);
                        serversInteractor$getCurrentServer$1.L$1 = SpillingKt.nullOutSpilledVariable(serverModel4);
                        serversInteractor$getCurrentServer$1.I$0 = 0;
                        serversInteractor$getCurrentServer$1.label = 2;
                    }
                } else {
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default(value, serverModel, null, null, null, null, null, false, 0, 254, null)));
                }
                return Unit.INSTANCE;
            }
        }
        serversInteractor$getCurrentServer$1 = new ServersInteractor$getCurrentServer$1(this, continuation);
        Object obj2 = serversInteractor$getCurrentServer$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = serversInteractor$getCurrentServer$1.label;
        if (i != 0) {
        }
        serverModel = (ServerModel) obj2;
        MutableStateFlow<ServersState> mutableStateFlow2 = this.stateStore;
        if (serverModel != null) {
        }
        return Unit.INSTANCE;
    }

    public final void filterMobileList() {
        ServersState value;
        MutableStateFlow<ServersState> mutableStateFlow = this.stateStore;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default(value, null, null, null, null, null, ServerStateCategory.Mobile, false, 0, 223, null)));
    }

    public final void filterDesktopList() {
        ServersState value;
        MutableStateFlow<ServersState> mutableStateFlow = this.stateStore;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default(value, null, null, null, null, null, ServerStateCategory.Desktop, false, 0, 223, null)));
    }

    public final void filterFavoriteList() {
        ServersState value;
        MutableStateFlow<ServersState> mutableStateFlow = this.stateStore;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default(value, null, null, null, null, null, ServerStateCategory.Favorite, false, 0, 223, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(16:1|(2:3|(14:5|6|7|(1:(1:(1:(1:(3:13|14|15)(2:17|18))(6:19|20|21|(1:22)|24|25))(5:29|30|(4:32|(2:35|33)|36|37)(1:44)|(5:39|(2:41|(2:43|27))|21|(1:22)|24)|25))(2:45|46))(3:91|92|(2:94|27))|47|48|(2:50|(3:52|(2:53|(1:56)(1:55))|57)(2:58|(3:62|(5:63|(2:66|64)|67|68|(1:71)(1:70))|72)))|(6:78|(2:81|79)|82|83|(1:84)|86)|88|(2:90|27)|30|(0)(0)|(0)|25))|99|6|7|(0)(0)|47|48|(0)|(8:74|76|78|(1:79)|82|83|(1:84)|86)|88|(0)|30|(0)(0)|(0)|25) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01b2, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01b3, code lost:
        timber.log.Timber.Forest.tag("ServersInteractor").d(java.lang.String.valueOf(r0.getMessage()), new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0258, code lost:
        timber.log.Timber.Forest.tag("ServersInteractor").d(java.lang.String.valueOf(r0.getMessage()), new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0277, code lost:
        if (checkFavorite(r2) != r3) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a1 A[Catch: Exception -> 0x01b2, TRY_ENTER, TryCatch #1 {Exception -> 0x01b2, blocks: (B:24:0x0069, B:30:0x0099, B:33:0x00a1, B:35:0x00ab, B:36:0x00ad, B:40:0x00e3, B:42:0x00e9, B:44:0x00f2, B:45:0x00f4, B:46:0x010e, B:48:0x0114, B:49:0x0129, B:54:0x0150, B:56:0x0156, B:58:0x015f, B:59:0x0170, B:61:0x0176, B:62:0x018a, B:63:0x018f, B:27:0x0070), top: B:95:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0176 A[Catch: Exception -> 0x01b2, LOOP:5: B:59:0x0170->B:61:0x0176, LOOP_END, TryCatch #1 {Exception -> 0x01b2, blocks: (B:24:0x0069, B:30:0x0099, B:33:0x00a1, B:35:0x00ab, B:36:0x00ad, B:40:0x00e3, B:42:0x00e9, B:44:0x00f2, B:45:0x00f4, B:46:0x010e, B:48:0x0114, B:49:0x0129, B:54:0x0150, B:56:0x0156, B:58:0x015f, B:59:0x0170, B:61:0x0176, B:62:0x018a, B:63:0x018f, B:27:0x0070), top: B:95:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01dc A[Catch: Exception -> 0x005c, TryCatch #0 {Exception -> 0x005c, blocks: (B:18:0x0052, B:85:0x022c, B:86:0x022e, B:19:0x0057, B:71:0x01d8, B:73:0x01dc, B:74:0x01ed, B:76:0x01f3, B:77:0x0207, B:80:0x020d, B:82:0x0216, B:68:0x01c6), top: B:95:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x020d A[Catch: Exception -> 0x005c, TryCatch #0 {Exception -> 0x005c, blocks: (B:18:0x0052, B:85:0x022c, B:86:0x022e, B:19:0x0057, B:71:0x01d8, B:73:0x01dc, B:74:0x01ed, B:76:0x01f3, B:77:0x0207, B:80:0x020d, B:82:0x0216, B:68:0x01c6), top: B:95:0x0031 }] */
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
        List list2;
        List<ServersApiModelItem> readDataAssets;
        ArrayList arrayList2;
        MutableStateFlow<ServersState> mutableStateFlow2;
        ServersState value2;
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
                        List<ServersApiModelItem> list3 = list;
                        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                        for (ServersApiModelItem serversApiModelItem : list3) {
                            arrayList3.add(ServerModelKt.toDomain(serversApiModelItem, true, this.buildConfig.isArizona()));
                        }
                        arrayList = arrayList3;
                    } else {
                        arrayList = null;
                    }
                    if (arrayList != null) {
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
                        } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default(value, null, CollectionsKt.toList(arrayList), null, null, null, null, false, 0, 253, null)));
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
                    List list4 = (List) serversInteractor$getServersMobileList$1.L$1;
                    arrayList = (List) serversInteractor$getServersMobileList$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    mutableStateFlow = this.stateStore;
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default(value, null, CollectionsKt.toList(arrayList), null, null, null, null, false, 0, 253, null)));
                    serversInteractor$getServersMobileList$1.L$0 = null;
                    serversInteractor$getServersMobileList$1.L$1 = null;
                    serversInteractor$getServersMobileList$1.label = 4;
                }
                list2 = (List) obj;
                if (list2 != null) {
                    if (!list2.isEmpty()) {
                        MutableStateFlow<ServersState> mutableStateFlow3 = this.stateStore;
                        while (true) {
                            ServersState value3 = mutableStateFlow3.getValue();
                            if (mutableStateFlow3.compareAndSet(value3, ServersState.copy$default(value3, null, list2, null, null, null, null, false, 0, 253, null))) {
                                break;
                            }
                        }
                    } else {
                        List<ServersApiModelItem> readDataAssets2 = readDataAssets("server_mobile.json");
                        if (readDataAssets2 != null && !readDataAssets2.isEmpty()) {
                            MutableStateFlow<ServersState> mutableStateFlow4 = this.stateStore;
                            while (true) {
                                ServersState value4 = mutableStateFlow4.getValue();
                                ServersState serversState = value4;
                                List<ServersApiModelItem> list5 = readDataAssets2;
                                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
                                for (ServersApiModelItem serversApiModelItem2 : list5) {
                                    arrayList4.add(ServerModelKt.toDomain(serversApiModelItem2, true, this.buildConfig.isArizona()));
                                }
                                if (mutableStateFlow4.compareAndSet(value4, ServersState.copy$default(serversState, null, arrayList4, null, null, null, null, false, 0, 253, null))) {
                                    break;
                                }
                            }
                        }
                    }
                }
                if (list2 == null && (readDataAssets = readDataAssets("server_mobile.json")) != null && !readDataAssets.isEmpty()) {
                    List<ServersApiModelItem> list6 = readDataAssets;
                    ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                    for (ServersApiModelItem serversApiModelItem3 : list6) {
                        arrayList5.add(ServerModelKt.toDomain(serversApiModelItem3, false, this.buildConfig.isArizona()));
                    }
                    arrayList2 = arrayList5;
                    mutableStateFlow2 = this.stateStore;
                    do {
                        value2 = mutableStateFlow2.getValue();
                    } while (!mutableStateFlow2.compareAndSet(value2, ServersState.copy$default(value2, null, arrayList2, null, null, null, null, false, 0, 253, null)));
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
        if (list2 != null) {
        }
        if (list2 == null) {
            List<ServersApiModelItem> list62 = readDataAssets;
            ArrayList arrayList52 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list62, 10));
            while (r0.hasNext()) {
            }
            arrayList2 = arrayList52;
            mutableStateFlow2 = this.stateStore;
            do {
                value2 = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value2, ServersState.copy$default(value2, null, arrayList2, null, null, null, null, false, 0, 253, null)));
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
    /* JADX WARN: Can't wrap try/catch for region: R(16:1|(2:3|(14:5|6|7|(1:(1:(1:(1:(3:13|14|15)(2:17|18))(6:19|20|21|(1:22)|24|25))(5:29|30|(4:32|(2:35|33)|36|37)(1:44)|(5:39|(2:41|(2:43|27))|21|(1:22)|24)|25))(2:45|46))(3:88|89|(2:91|27))|47|48|(2:50|(4:52|(1:53)|55|56)(2:57|(6:61|(2:64|62)|65|66|(1:67)|69)))|(6:75|(2:78|76)|79|80|(1:81)|83)|85|(2:87|27)|30|(0)(0)|(0)|25))|96|6|7|(0)(0)|47|48|(0)|(8:71|73|75|(1:76)|79|80|(1:81)|83)|85|(0)|30|(0)(0)|(0)|25) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0199, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x019a, code lost:
        timber.log.Timber.Forest.tag("ServersInteractor").d(java.lang.String.valueOf(r0.getMessage()), new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0237, code lost:
        timber.log.Timber.Forest.tag("ServersInteractor").d(java.lang.String.valueOf(r0.getMessage()), new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0254, code lost:
        if (checkFavorite(r2) != r3) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a1 A[Catch: Exception -> 0x0199, TRY_ENTER, TryCatch #1 {Exception -> 0x0199, blocks: (B:24:0x0069, B:30:0x0099, B:33:0x00a1, B:35:0x00ab, B:36:0x00ad, B:39:0x00d0, B:41:0x00d6, B:43:0x00df, B:44:0x00f0, B:46:0x00f6, B:47:0x010a, B:48:0x0110, B:51:0x0136, B:53:0x013c, B:55:0x0145, B:56:0x0156, B:58:0x015c, B:59:0x0170, B:60:0x0176, B:27:0x0070), top: B:92:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x015c A[Catch: Exception -> 0x0199, LOOP:5: B:56:0x0156->B:58:0x015c, LOOP_END, TryCatch #1 {Exception -> 0x0199, blocks: (B:24:0x0069, B:30:0x0099, B:33:0x00a1, B:35:0x00ab, B:36:0x00ad, B:39:0x00d0, B:41:0x00d6, B:43:0x00df, B:44:0x00f0, B:46:0x00f6, B:47:0x010a, B:48:0x0110, B:51:0x0136, B:53:0x013c, B:55:0x0145, B:56:0x0156, B:58:0x015c, B:59:0x0170, B:60:0x0176, B:27:0x0070), top: B:92:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01c1 A[Catch: Exception -> 0x005c, TryCatch #0 {Exception -> 0x005c, blocks: (B:18:0x0052, B:82:0x0210, B:83:0x0214, B:19:0x0057, B:68:0x01bd, B:70:0x01c1, B:71:0x01d2, B:73:0x01d8, B:74:0x01ec, B:77:0x01f2, B:79:0x01fb, B:65:0x01ad), top: B:92:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01f2 A[Catch: Exception -> 0x005c, TryCatch #0 {Exception -> 0x005c, blocks: (B:18:0x0052, B:82:0x0210, B:83:0x0214, B:19:0x0057, B:68:0x01bd, B:70:0x01c1, B:71:0x01d2, B:73:0x01d8, B:74:0x01ec, B:77:0x01f2, B:79:0x01fb, B:65:0x01ad), top: B:92:0x0031 }] */
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
        List list3;
        List<ServersApiModelItem> readDataAssets;
        ArrayList arrayList2;
        MutableStateFlow<ServersState> mutableStateFlow2;
        ServersState value2;
        ServersState value3;
        ServersState value4;
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
                        List<ServersApiModelItem> list4 = list;
                        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                        for (ServersApiModelItem serversApiModelItem : list4) {
                            arrayList3.add(ServerModelKt.toDomain(serversApiModelItem, false, this.buildConfig.isArizona()));
                        }
                        arrayList = arrayList3;
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
                        mutableStateFlow = this.stateStore;
                        do {
                            value = mutableStateFlow.getValue();
                        } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default(value, null, null, list2, null, null, null, false, 0, 251, null)));
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
                    List list5 = (List) serversInteractor$getServersDesktopList$1.L$1;
                    arrayList = (List) serversInteractor$getServersDesktopList$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    list2 = arrayList;
                    mutableStateFlow = this.stateStore;
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default(value, null, null, list2, null, null, null, false, 0, 251, null)));
                    serversInteractor$getServersDesktopList$1.L$0 = null;
                    serversInteractor$getServersDesktopList$1.L$1 = null;
                    serversInteractor$getServersDesktopList$1.label = 4;
                }
                list3 = (List) obj;
                if (list3 != null) {
                    if (!list3.isEmpty()) {
                        MutableStateFlow<ServersState> mutableStateFlow3 = this.stateStore;
                        do {
                            value4 = mutableStateFlow3.getValue();
                        } while (!mutableStateFlow3.compareAndSet(value4, ServersState.copy$default(value4, null, null, list3, null, null, null, false, 0, 251, null)));
                    } else {
                        List<ServersApiModelItem> readDataAssets2 = readDataAssets("server_desktop.json");
                        if (readDataAssets2 != null && !readDataAssets2.isEmpty()) {
                            List<ServersApiModelItem> list6 = readDataAssets2;
                            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                            for (ServersApiModelItem serversApiModelItem2 : list6) {
                                arrayList4.add(ServerModelKt.toDomain(serversApiModelItem2, false, this.buildConfig.isArizona()));
                            }
                            ArrayList arrayList5 = arrayList4;
                            MutableStateFlow<ServersState> mutableStateFlow4 = this.stateStore;
                            do {
                                value3 = mutableStateFlow4.getValue();
                            } while (!mutableStateFlow4.compareAndSet(value3, ServersState.copy$default(value3, null, null, arrayList5, null, null, null, false, 0, 251, null)));
                        }
                    }
                }
                if (list3 == null && (readDataAssets = readDataAssets("server_desktop.json")) != null && !readDataAssets.isEmpty()) {
                    List<ServersApiModelItem> list7 = readDataAssets;
                    ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
                    for (ServersApiModelItem serversApiModelItem3 : list7) {
                        arrayList6.add(ServerModelKt.toDomain(serversApiModelItem3, false, this.buildConfig.isArizona()));
                    }
                    arrayList2 = arrayList6;
                    mutableStateFlow2 = this.stateStore;
                    do {
                        value2 = mutableStateFlow2.getValue();
                    } while (!mutableStateFlow2.compareAndSet(value2, ServersState.copy$default(value2, null, null, arrayList2, null, null, null, false, 0, 251, null)));
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
        if (list3 == null) {
            List<ServersApiModelItem> list72 = readDataAssets;
            ArrayList arrayList62 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list72, 10));
            while (r0.hasNext()) {
            }
            arrayList2 = arrayList62;
            mutableStateFlow2 = this.stateStore;
            do {
                value2 = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value2, ServersState.copy$default(value2, null, null, arrayList2, null, null, null, false, 0, 251, null)));
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(17:1|(2:3|(15:5|6|7|(1:(1:(1:(8:12|13|14|15|(1:16)|18|19|20)(2:23|24))(6:25|26|(4:28|(2:31|29)|32|33)|(2:35|(3:37|(5:40|14|15|(1:16)|18)|39)(4:41|15|(1:16)|18))|19|20))(2:42|43))(2:85|(2:87|88)(2:89|(2:91|39)))|44|45|(2:47|(4:49|(1:50)|52|53)(2:54|(6:58|(2:61|59)|62|63|(1:64)|66)))|(6:72|(2:75|73)|76|77|(1:78)|80)|82|(2:84|39)|26|(0)|(0)|19|20))|96|6|7|(0)(0)|44|45|(0)|(8:68|70|72|(1:73)|76|77|(1:78)|80)|82|(0)|26|(0)|(0)|19|20) */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x019a, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x019b, code lost:
        timber.log.Timber.Forest.tag("ServersInteractor").d(java.lang.String.valueOf(r0.getMessage()), new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0239, code lost:
        timber.log.Timber.Forest.tag("ServersInteractor").d(java.lang.String.valueOf(r0.getMessage()), new java.lang.Object[0]);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a4 A[Catch: Exception -> 0x019a, TRY_ENTER, TryCatch #0 {Exception -> 0x019a, blocks: (B:23:0x0061, B:32:0x009c, B:35:0x00a4, B:37:0x00ae, B:38:0x00b0, B:41:0x00d2, B:43:0x00d8, B:45:0x00e1, B:46:0x00f2, B:48:0x00f8, B:49:0x010c, B:50:0x0112, B:53:0x0138, B:55:0x013e, B:57:0x0147, B:58:0x0158, B:60:0x015e, B:61:0x0172, B:62:0x0178, B:29:0x0073), top: B:93:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x015e A[Catch: Exception -> 0x019a, LOOP:5: B:58:0x0158->B:60:0x015e, LOOP_END, TryCatch #0 {Exception -> 0x019a, blocks: (B:23:0x0061, B:32:0x009c, B:35:0x00a4, B:37:0x00ae, B:38:0x00b0, B:41:0x00d2, B:43:0x00d8, B:45:0x00e1, B:46:0x00f2, B:48:0x00f8, B:49:0x010c, B:50:0x0112, B:53:0x0138, B:55:0x013e, B:57:0x0147, B:58:0x0158, B:60:0x015e, B:61:0x0172, B:62:0x0178, B:29:0x0073), top: B:93:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c1 A[Catch: Exception -> 0x0054, TryCatch #1 {Exception -> 0x0054, blocks: (B:14:0x0042, B:86:0x0215, B:87:0x0217, B:18:0x004f, B:70:0x01bd, B:72:0x01c1, B:73:0x01d2, B:75:0x01d8, B:76:0x01ec, B:78:0x01f1, B:80:0x01fa, B:67:0x01ae), top: B:93:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01f1 A[Catch: Exception -> 0x0054, TryCatch #1 {Exception -> 0x0054, blocks: (B:14:0x0042, B:86:0x0215, B:87:0x0217, B:18:0x004f, B:70:0x01bd, B:72:0x01c1, B:73:0x01d2, B:75:0x01d8, B:76:0x01ec, B:78:0x01f1, B:80:0x01fa, B:67:0x01ae), top: B:93:0x0030 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getServersVcList(Continuation<? super Unit> continuation) {
        ServersInteractor$getServersVcList$1 serversInteractor$getServersVcList$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        ArrayList arrayList;
        List list;
        ArrayList arrayList2;
        List list2;
        MutableStateFlow<ServersState> mutableStateFlow;
        ServersState value;
        List list3;
        List<ServersApiModelItem> readDataAssets;
        ArrayList arrayList3;
        MutableStateFlow<ServersState> mutableStateFlow2;
        ServersState value2;
        ServersState value3;
        ServersState value4;
        if (continuation instanceof ServersInteractor$getServersVcList$1) {
            serversInteractor$getServersVcList$1 = (ServersInteractor$getServersVcList$1) continuation;
            if ((serversInteractor$getServersVcList$1.label & Integer.MIN_VALUE) != 0) {
                serversInteractor$getServersVcList$1.label -= Integer.MIN_VALUE;
                obj = serversInteractor$getServersVcList$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = serversInteractor$getServersVcList$1.label;
                arrayList = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!this.buildConfig.isArizona()) {
                        return Unit.INSTANCE;
                    }
                    LocalRepository localRepository = this.localRepository;
                    serversInteractor$getServersVcList$1.L$0 = SpillingKt.nullOutSpilledVariable(localRepository);
                    serversInteractor$getServersVcList$1.L$1 = SpillingKt.nullOutSpilledVariable(VC_LIST_KEY);
                    serversInteractor$getServersVcList$1.I$0 = 0;
                    serversInteractor$getServersVcList$1.label = 1;
                    obj = BuildersKt.withContext(Dispatchers.getIO(), new ServersInteractor$getServersVcList$$inlined$getSuspend$1(localRepository, VC_LIST_KEY, null), serversInteractor$getServersVcList$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            int i2 = serversInteractor$getServersVcList$1.I$0;
                            List list4 = (List) serversInteractor$getServersVcList$1.L$1;
                            list2 = (List) serversInteractor$getServersVcList$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            arrayList2 = list2;
                            mutableStateFlow = this.stateStore;
                            do {
                                value = mutableStateFlow.getValue();
                            } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default(value, null, null, null, arrayList2, null, null, false, 0, 247, null)));
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    list = (List) obj;
                    if (list != null) {
                        List<ServersApiModelItem> list5 = list;
                        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
                        for (ServersApiModelItem serversApiModelItem : list5) {
                            arrayList4.add(ServerModelKt.toDomain(serversApiModelItem, false, this.buildConfig.isArizona()));
                        }
                        arrayList = arrayList4;
                    }
                    if (arrayList != null) {
                        if (!arrayList.isEmpty()) {
                            LocalRepository localRepository2 = this.localRepository;
                            serversInteractor$getServersVcList$1.L$0 = arrayList;
                            serversInteractor$getServersVcList$1.L$1 = SpillingKt.nullOutSpilledVariable(arrayList);
                            serversInteractor$getServersVcList$1.I$0 = 0;
                            serversInteractor$getServersVcList$1.label = 3;
                            if (localRepository2.save2(VC_LIST_KEY, (String) arrayList, (Continuation<? super Unit>) serversInteractor$getServersVcList$1) != coroutine_suspended) {
                                list2 = arrayList;
                                arrayList2 = list2;
                                mutableStateFlow = this.stateStore;
                                do {
                                    value = mutableStateFlow.getValue();
                                } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default(value, null, null, null, arrayList2, null, null, false, 0, 247, null)));
                            }
                            return coroutine_suspended;
                        }
                        arrayList2 = arrayList;
                        mutableStateFlow = this.stateStore;
                        do {
                            value = mutableStateFlow.getValue();
                        } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default(value, null, null, null, arrayList2, null, null, false, 0, 247, null)));
                    }
                    return Unit.INSTANCE;
                } else {
                    int i3 = serversInteractor$getServersVcList$1.I$0;
                    String str = (String) serversInteractor$getServersVcList$1.L$1;
                    IKeyValueRepository iKeyValueRepository = (IKeyValueRepository) serversInteractor$getServersVcList$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                list3 = (List) obj;
                if (list3 != null) {
                    if (!list3.isEmpty()) {
                        MutableStateFlow<ServersState> mutableStateFlow3 = this.stateStore;
                        do {
                            value4 = mutableStateFlow3.getValue();
                        } while (!mutableStateFlow3.compareAndSet(value4, ServersState.copy$default(value4, null, null, null, list3, null, null, false, 0, 247, null)));
                    } else {
                        List<ServersApiModelItem> readDataAssets2 = readDataAssets("server_vc.json");
                        if (readDataAssets2 != null && !readDataAssets2.isEmpty()) {
                            List<ServersApiModelItem> list6 = readDataAssets2;
                            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                            for (ServersApiModelItem serversApiModelItem2 : list6) {
                                arrayList5.add(ServerModelKt.toDomain(serversApiModelItem2, false, this.buildConfig.isArizona()));
                            }
                            ArrayList arrayList6 = arrayList5;
                            MutableStateFlow<ServersState> mutableStateFlow4 = this.stateStore;
                            do {
                                value3 = mutableStateFlow4.getValue();
                            } while (!mutableStateFlow4.compareAndSet(value3, ServersState.copy$default(value3, null, null, null, arrayList6, null, null, false, 0, 247, null)));
                        }
                    }
                }
                if (list3 == null && (readDataAssets = readDataAssets("server_vc.json")) != null && !readDataAssets.isEmpty()) {
                    List<ServersApiModelItem> list7 = readDataAssets;
                    ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
                    for (ServersApiModelItem serversApiModelItem3 : list7) {
                        arrayList7.add(ServerModelKt.toDomain(serversApiModelItem3, false, this.buildConfig.isArizona()));
                    }
                    arrayList3 = arrayList7;
                    mutableStateFlow2 = this.stateStore;
                    do {
                        value2 = mutableStateFlow2.getValue();
                    } while (!mutableStateFlow2.compareAndSet(value2, ServersState.copy$default(value2, null, null, null, arrayList3, null, null, false, 0, 247, null)));
                }
                NetworkDataSource networkDataSource = this.dataSource;
                serversInteractor$getServersVcList$1.L$0 = null;
                serversInteractor$getServersVcList$1.L$1 = null;
                serversInteractor$getServersVcList$1.label = 2;
                obj = networkDataSource.getServersVc(serversInteractor$getServersVcList$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = (List) obj;
                if (list != null) {
                }
                if (arrayList != null) {
                }
                return Unit.INSTANCE;
            }
        }
        serversInteractor$getServersVcList$1 = new ServersInteractor$getServersVcList$1(this, continuation);
        obj = serversInteractor$getServersVcList$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = serversInteractor$getServersVcList$1.label;
        arrayList = null;
        if (i != 0) {
        }
        list3 = (List) obj;
        if (list3 != null) {
        }
        if (list3 == null) {
            List<ServersApiModelItem> list72 = readDataAssets;
            ArrayList arrayList72 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list72, 10));
            while (r0.hasNext()) {
            }
            arrayList3 = arrayList72;
            mutableStateFlow2 = this.stateStore;
            do {
                value2 = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value2, ServersState.copy$default(value2, null, null, null, arrayList3, null, null, false, 0, 247, null)));
        }
        NetworkDataSource networkDataSource2 = this.dataSource;
        serversInteractor$getServersVcList$1.L$0 = null;
        serversInteractor$getServersVcList$1.L$1 = null;
        serversInteractor$getServersVcList$1.label = 2;
        obj = networkDataSource2.getServersVc(serversInteractor$getServersVcList$1);
        if (obj == coroutine_suspended) {
        }
        list = (List) obj;
        if (list != null) {
        }
        if (arrayList != null) {
        }
        return Unit.INSTANCE;
    }

    /* compiled from: ServersInteractor.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/miami/game/core/server/ServersInteractor$Companion;", "", "<init>", "()V", "CURRENT_SERVER_KEY", "", "MOBILE_LIST_KEY", "DESKTOP_LIST_KEY", "VC_LIST_KEY", "server"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
