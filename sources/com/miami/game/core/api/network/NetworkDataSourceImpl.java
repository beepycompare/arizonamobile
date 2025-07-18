package com.miami.game.core.api.network;

import android.util.Log;
import com.miami.game.core.api.model.response.HwVersion;
import com.miami.game.core.api.model.response.game_info.GameInfoResponseApiModel;
import com.miami.game.core.api.model.response.news.NewsApiModelItem;
import com.miami.game.core.api.model.response.servers.ServersApiModelItem;
import com.miami.game.core.api.network.retrofit.NetworkApi;
import com.miami.game.core.connection.resolver.api.ConnectionResolver;
import com.miami.game.core.network.error_handler.CoroutineErrorHandlerRetrofitFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NetworkDataSourceImpl.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013H\u0082@¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0096@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0096@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013H\u0096@¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001f\u001a\u00020 H\u0096@¢\u0006\u0002\u0010\u0019J\b\u0010!\u001a\u00020 H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006#"}, d2 = {"Lcom/miami/game/core/api/network/NetworkDataSourceImpl;", "Lcom/miami/game/core/api/network/NetworkDataSource;", "connectionResolver", "Lcom/miami/game/core/connection/resolver/api/ConnectionResolver;", "retrofitFactory", "Lcom/miami/game/core/network/error_handler/CoroutineErrorHandlerRetrofitFactory;", "<init>", "(Lcom/miami/game/core/connection/resolver/api/ConnectionResolver;Lcom/miami/game/core/network/error_handler/CoroutineErrorHandlerRetrofitFactory;)V", "maxConnectionTrying", "", "tag", "", "apiService", "Lcom/miami/game/core/api/network/retrofit/NetworkApi;", "serverChannels", "", "[Ljava/lang/Integer;", "retryGetFromServer", "retryOrReturnNull", "", "Lcom/miami/game/core/api/model/response/servers/ServersApiModelItem;", "channelType", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retryOrReturnNullForNews", "Lcom/miami/game/core/api/model/response/news/NewsApiModelItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGameInfo", "Lcom/miami/game/core/api/model/response/game_info/GameInfoResponseApiModel;", "getServersMobile", "getServersDesktop", "getNews", "getHwVersion", "Lcom/miami/game/core/api/model/response/HwVersion;", "createDefaultHwVersion", "ChannelType", "api-network_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NetworkDataSourceImpl implements NetworkDataSource {
    private final NetworkApi apiService;
    private final ConnectionResolver connectionResolver;
    private final int maxConnectionTrying;
    private final Integer[] retryGetFromServer;
    private final Integer[] serverChannels;
    private final String tag;

    public NetworkDataSourceImpl(ConnectionResolver connectionResolver, CoroutineErrorHandlerRetrofitFactory retrofitFactory) {
        Intrinsics.checkNotNullParameter(connectionResolver, "connectionResolver");
        Intrinsics.checkNotNullParameter(retrofitFactory, "retrofitFactory");
        this.connectionResolver = connectionResolver;
        this.maxConnectionTrying = 10;
        this.tag = "NetworkDataSourceImpl";
        Object create = retrofitFactory.createRetrofit().create(NetworkApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        this.apiService = (NetworkApi) create;
        int size = ChannelType.getEntries().size();
        Integer[] numArr = new Integer[size];
        for (int i = 0; i < size; i++) {
            numArr[i] = -1;
        }
        this.serverChannels = numArr;
        int size2 = ChannelType.getEntries().size();
        Integer[] numArr2 = new Integer[size2];
        for (int i2 = 0; i2 < size2; i2++) {
            numArr2[i2] = 0;
        }
        this.retryGetFromServer = numArr2;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: NetworkDataSourceImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/api/network/NetworkDataSourceImpl$ChannelType;", "", "<init>", "(Ljava/lang/String;I)V", "GAME_INFO", "MOBILE", "PC", "NEWS", "api-network_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class ChannelType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ChannelType[] $VALUES;
        public static final ChannelType GAME_INFO = new ChannelType("GAME_INFO", 0);
        public static final ChannelType MOBILE = new ChannelType("MOBILE", 1);
        public static final ChannelType PC = new ChannelType("PC", 2);
        public static final ChannelType NEWS = new ChannelType("NEWS", 3);

        private static final /* synthetic */ ChannelType[] $values() {
            return new ChannelType[]{GAME_INFO, MOBILE, PC, NEWS};
        }

        public static EnumEntries<ChannelType> getEntries() {
            return $ENTRIES;
        }

        public static ChannelType valueOf(String str) {
            return (ChannelType) Enum.valueOf(ChannelType.class, str);
        }

        public static ChannelType[] values() {
            return (ChannelType[]) $VALUES.clone();
        }

        private ChannelType(String str, int i) {
        }

        static {
            ChannelType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object retryOrReturnNull(int i, Continuation<? super List<ServersApiModelItem>> continuation) {
        if (this.retryGetFromServer[i].intValue() < this.maxConnectionTrying) {
            Integer[] numArr = this.retryGetFromServer;
            numArr[i] = Boxing.boxInt(numArr[i].intValue() + 1);
            Integer[] numArr2 = this.serverChannels;
            numArr2[i] = Boxing.boxInt(numArr2[i].intValue() + 1);
            return getServersMobile(continuation);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object retryOrReturnNullForNews(Continuation<? super List<NewsApiModelItem>> continuation) {
        if (this.retryGetFromServer[ChannelType.NEWS.ordinal()].intValue() < this.maxConnectionTrying) {
            Integer[] numArr = this.retryGetFromServer;
            int ordinal = ChannelType.NEWS.ordinal();
            numArr[ordinal] = Boxing.boxInt(numArr[ordinal].intValue() + 1);
            Integer[] numArr2 = this.serverChannels;
            int ordinal2 = ChannelType.NEWS.ordinal();
            numArr2[ordinal2] = Boxing.boxInt(numArr2[ordinal2].intValue() + 1);
            return getNews(continuation);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0056, code lost:
        if (r7 == r1) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0085 A[RETURN] */
    @Override // com.miami.game.core.api.network.NetworkDataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getGameInfo(Continuation<? super GameInfoResponseApiModel> continuation) {
        NetworkDataSourceImpl$getGameInfo$1 networkDataSourceImpl$getGameInfo$1;
        int i;
        if (continuation instanceof NetworkDataSourceImpl$getGameInfo$1) {
            networkDataSourceImpl$getGameInfo$1 = (NetworkDataSourceImpl$getGameInfo$1) continuation;
            if ((networkDataSourceImpl$getGameInfo$1.label & Integer.MIN_VALUE) != 0) {
                networkDataSourceImpl$getGameInfo$1.label -= Integer.MIN_VALUE;
                Object obj = networkDataSourceImpl$getGameInfo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = networkDataSourceImpl$getGameInfo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ConnectionResolver connectionResolver = this.connectionResolver;
                    int intValue = this.serverChannels[ChannelType.GAME_INFO.ordinal()].intValue();
                    networkDataSourceImpl$getGameInfo$1.label = 1;
                    obj = connectionResolver.getGameFilesInfoServer(intValue, networkDataSourceImpl$getGameInfo$1);
                } else if (i != 1) {
                    if (i == 2) {
                        String str = (String) networkDataSourceImpl$getGameInfo$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                String str2 = (String) ((Pair) obj).component1();
                networkDataSourceImpl$getGameInfo$1.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                networkDataSourceImpl$getGameInfo$1.label = 2;
                Object gameFilesInfo = this.apiService.getGameFilesInfo(str2 + "astc.game.json", networkDataSourceImpl$getGameInfo$1);
                return gameFilesInfo != coroutine_suspended ? coroutine_suspended : gameFilesInfo;
            }
        }
        networkDataSourceImpl$getGameInfo$1 = new NetworkDataSourceImpl$getGameInfo$1(this, continuation);
        Object obj2 = networkDataSourceImpl$getGameInfo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = networkDataSourceImpl$getGameInfo$1.label;
        if (i != 0) {
        }
        String str22 = (String) ((Pair) obj2).component1();
        networkDataSourceImpl$getGameInfo$1.L$0 = SpillingKt.nullOutSpilledVariable(str22);
        networkDataSourceImpl$getGameInfo$1.label = 2;
        Object gameFilesInfo2 = this.apiService.getGameFilesInfo(str22 + "astc.game.json", networkDataSourceImpl$getGameInfo$1);
        if (gameFilesInfo2 != coroutine_suspended2) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|(1:(1:(1:(3:11|12|13)(2:15|16))(5:17|18|19|20|21))(1:27))(1:36)|28|29|30|(3:32|20|21)|26))|38|6|(0)(0)|28|29|30|(0)|26|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
        if (r11 == r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00aa, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ab, code lost:
        r2 = r11;
        r11 = r4;
        r4 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e1, code lost:
        if (r11 == r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a3  */
    @Override // com.miami.game.core.api.network.NetworkDataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getServersMobile(Continuation<? super List<ServersApiModelItem>> continuation) {
        NetworkDataSourceImpl$getServersMobile$1 networkDataSourceImpl$getServersMobile$1;
        Object coroutine_suspended;
        int i;
        int i2;
        String str;
        Object servers;
        if (continuation instanceof NetworkDataSourceImpl$getServersMobile$1) {
            networkDataSourceImpl$getServersMobile$1 = (NetworkDataSourceImpl$getServersMobile$1) continuation;
            if ((networkDataSourceImpl$getServersMobile$1.label & Integer.MIN_VALUE) != 0) {
                networkDataSourceImpl$getServersMobile$1.label -= Integer.MIN_VALUE;
                Object obj = networkDataSourceImpl$getServersMobile$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = networkDataSourceImpl$getServersMobile$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ConnectionResolver connectionResolver = this.connectionResolver;
                    int intValue = this.serverChannels[ChannelType.MOBILE.ordinal()].intValue();
                    networkDataSourceImpl$getServersMobile$1.label = 1;
                    obj = connectionResolver.getServerMobileList(intValue, networkDataSourceImpl$getServersMobile$1);
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else if (i != 2) {
                    if (i == 3) {
                        int i3 = networkDataSourceImpl$getServersMobile$1.I$0;
                        Exception exc = (Exception) networkDataSourceImpl$getServersMobile$1.L$1;
                        String str2 = (String) networkDataSourceImpl$getServersMobile$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return (List) obj;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    i2 = networkDataSourceImpl$getServersMobile$1.I$0;
                    str = (String) networkDataSourceImpl$getServersMobile$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        return (List) obj;
                    } catch (Exception e) {
                        Exception e2 = e;
                        Log.e(this.tag, "getServersMobile: Unexpected error while fetching servers: " + e2.getMessage());
                        int ordinal = ChannelType.MOBILE.ordinal();
                        networkDataSourceImpl$getServersMobile$1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                        networkDataSourceImpl$getServersMobile$1.L$1 = SpillingKt.nullOutSpilledVariable(e2);
                        networkDataSourceImpl$getServersMobile$1.I$0 = i2;
                        networkDataSourceImpl$getServersMobile$1.label = 3;
                        obj = retryOrReturnNull(ordinal, networkDataSourceImpl$getServersMobile$1);
                    }
                }
                Pair pair = (Pair) obj;
                String str3 = (String) pair.component1();
                int intValue2 = ((Number) pair.component2()).intValue();
                this.serverChannels[ChannelType.MOBILE.ordinal()] = Boxing.boxInt(intValue2);
                NetworkApi networkApi = this.apiService;
                networkDataSourceImpl$getServersMobile$1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                networkDataSourceImpl$getServersMobile$1.I$0 = intValue2;
                networkDataSourceImpl$getServersMobile$1.label = 2;
                servers = networkApi.getServers(str3, networkDataSourceImpl$getServersMobile$1);
                if (servers != coroutine_suspended) {
                    i2 = intValue2;
                    obj = servers;
                    str = str3;
                    return (List) obj;
                }
                return coroutine_suspended;
            }
        }
        networkDataSourceImpl$getServersMobile$1 = new NetworkDataSourceImpl$getServersMobile$1(this, continuation);
        Object obj2 = networkDataSourceImpl$getServersMobile$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = networkDataSourceImpl$getServersMobile$1.label;
        if (i != 0) {
        }
        Pair pair2 = (Pair) obj2;
        String str32 = (String) pair2.component1();
        int intValue22 = ((Number) pair2.component2()).intValue();
        this.serverChannels[ChannelType.MOBILE.ordinal()] = Boxing.boxInt(intValue22);
        NetworkApi networkApi2 = this.apiService;
        networkDataSourceImpl$getServersMobile$1.L$0 = SpillingKt.nullOutSpilledVariable(str32);
        networkDataSourceImpl$getServersMobile$1.I$0 = intValue22;
        networkDataSourceImpl$getServersMobile$1.label = 2;
        servers = networkApi2.getServers(str32, networkDataSourceImpl$getServersMobile$1);
        if (servers != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|(1:(1:(1:(3:11|12|13)(2:15|16))(5:17|18|19|20|21))(1:27))(1:36)|28|29|30|(3:32|20|21)|26))|38|6|(0)(0)|28|29|30|(0)|26|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
        if (r11 == r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00aa, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ab, code lost:
        r2 = r11;
        r11 = r4;
        r4 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e1, code lost:
        if (r11 == r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a3  */
    @Override // com.miami.game.core.api.network.NetworkDataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getServersDesktop(Continuation<? super List<ServersApiModelItem>> continuation) {
        NetworkDataSourceImpl$getServersDesktop$1 networkDataSourceImpl$getServersDesktop$1;
        Object coroutine_suspended;
        int i;
        int i2;
        String str;
        Object servers;
        if (continuation instanceof NetworkDataSourceImpl$getServersDesktop$1) {
            networkDataSourceImpl$getServersDesktop$1 = (NetworkDataSourceImpl$getServersDesktop$1) continuation;
            if ((networkDataSourceImpl$getServersDesktop$1.label & Integer.MIN_VALUE) != 0) {
                networkDataSourceImpl$getServersDesktop$1.label -= Integer.MIN_VALUE;
                Object obj = networkDataSourceImpl$getServersDesktop$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = networkDataSourceImpl$getServersDesktop$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ConnectionResolver connectionResolver = this.connectionResolver;
                    int intValue = this.serverChannels[ChannelType.PC.ordinal()].intValue();
                    networkDataSourceImpl$getServersDesktop$1.label = 1;
                    obj = connectionResolver.getServerDesktopList(intValue, networkDataSourceImpl$getServersDesktop$1);
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else if (i != 2) {
                    if (i == 3) {
                        int i3 = networkDataSourceImpl$getServersDesktop$1.I$0;
                        Exception exc = (Exception) networkDataSourceImpl$getServersDesktop$1.L$1;
                        String str2 = (String) networkDataSourceImpl$getServersDesktop$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return (List) obj;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    i2 = networkDataSourceImpl$getServersDesktop$1.I$0;
                    str = (String) networkDataSourceImpl$getServersDesktop$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        return (List) obj;
                    } catch (Exception e) {
                        Exception e2 = e;
                        Log.e(this.tag, "getServersDesktop: Unexpected error while fetching servers: " + e2.getMessage());
                        int ordinal = ChannelType.PC.ordinal();
                        networkDataSourceImpl$getServersDesktop$1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                        networkDataSourceImpl$getServersDesktop$1.L$1 = SpillingKt.nullOutSpilledVariable(e2);
                        networkDataSourceImpl$getServersDesktop$1.I$0 = i2;
                        networkDataSourceImpl$getServersDesktop$1.label = 3;
                        obj = retryOrReturnNull(ordinal, networkDataSourceImpl$getServersDesktop$1);
                    }
                }
                Pair pair = (Pair) obj;
                String str3 = (String) pair.component1();
                int intValue2 = ((Number) pair.component2()).intValue();
                this.serverChannels[ChannelType.PC.ordinal()] = Boxing.boxInt(intValue2);
                NetworkApi networkApi = this.apiService;
                networkDataSourceImpl$getServersDesktop$1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                networkDataSourceImpl$getServersDesktop$1.I$0 = intValue2;
                networkDataSourceImpl$getServersDesktop$1.label = 2;
                servers = networkApi.getServers(str3, networkDataSourceImpl$getServersDesktop$1);
                if (servers != coroutine_suspended) {
                    i2 = intValue2;
                    obj = servers;
                    str = str3;
                    return (List) obj;
                }
                return coroutine_suspended;
            }
        }
        networkDataSourceImpl$getServersDesktop$1 = new NetworkDataSourceImpl$getServersDesktop$1(this, continuation);
        Object obj2 = networkDataSourceImpl$getServersDesktop$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = networkDataSourceImpl$getServersDesktop$1.label;
        if (i != 0) {
        }
        Pair pair2 = (Pair) obj2;
        String str32 = (String) pair2.component1();
        int intValue22 = ((Number) pair2.component2()).intValue();
        this.serverChannels[ChannelType.PC.ordinal()] = Boxing.boxInt(intValue22);
        NetworkApi networkApi2 = this.apiService;
        networkDataSourceImpl$getServersDesktop$1.L$0 = SpillingKt.nullOutSpilledVariable(str32);
        networkDataSourceImpl$getServersDesktop$1.I$0 = intValue22;
        networkDataSourceImpl$getServersDesktop$1.label = 2;
        servers = networkApi2.getServers(str32, networkDataSourceImpl$getServersDesktop$1);
        if (servers != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|(1:(1:(1:(3:11|12|13)(2:15|16))(5:17|18|19|20|21))(1:27))(1:36)|28|29|30|(3:32|20|21)|26))|38|6|(0)(0)|28|29|30|(0)|26|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
        if (r11 == r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a6, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a7, code lost:
        r2 = r11;
        r11 = r4;
        r4 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e1, code lost:
        if (r11 == r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    @Override // com.miami.game.core.api.network.NetworkDataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getNews(Continuation<? super List<NewsApiModelItem>> continuation) {
        NetworkDataSourceImpl$getNews$1 networkDataSourceImpl$getNews$1;
        Object coroutine_suspended;
        int i;
        int i2;
        String str;
        Object news;
        if (continuation instanceof NetworkDataSourceImpl$getNews$1) {
            networkDataSourceImpl$getNews$1 = (NetworkDataSourceImpl$getNews$1) continuation;
            if ((networkDataSourceImpl$getNews$1.label & Integer.MIN_VALUE) != 0) {
                networkDataSourceImpl$getNews$1.label -= Integer.MIN_VALUE;
                Object obj = networkDataSourceImpl$getNews$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = networkDataSourceImpl$getNews$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ConnectionResolver connectionResolver = this.connectionResolver;
                    int intValue = this.serverChannels[ChannelType.NEWS.ordinal()].intValue();
                    networkDataSourceImpl$getNews$1.label = 1;
                    obj = connectionResolver.getNewsServer(intValue, networkDataSourceImpl$getNews$1);
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else if (i != 2) {
                    if (i == 3) {
                        int i3 = networkDataSourceImpl$getNews$1.I$0;
                        Exception exc = (Exception) networkDataSourceImpl$getNews$1.L$1;
                        String str2 = (String) networkDataSourceImpl$getNews$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return (List) obj;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    i2 = networkDataSourceImpl$getNews$1.I$0;
                    str = (String) networkDataSourceImpl$getNews$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        return (List) obj;
                    } catch (Exception e) {
                        Exception e2 = e;
                        Log.e(this.tag, "getNews: Unexpected error while fetching servers: " + e2.getMessage() + ", " + str);
                        networkDataSourceImpl$getNews$1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                        networkDataSourceImpl$getNews$1.L$1 = SpillingKt.nullOutSpilledVariable(e2);
                        networkDataSourceImpl$getNews$1.I$0 = i2;
                        networkDataSourceImpl$getNews$1.label = 3;
                        obj = retryOrReturnNullForNews(networkDataSourceImpl$getNews$1);
                    }
                }
                Pair pair = (Pair) obj;
                String str3 = (String) pair.component1();
                int intValue2 = ((Number) pair.component2()).intValue();
                this.serverChannels[ChannelType.NEWS.ordinal()] = Boxing.boxInt(intValue2);
                NetworkApi networkApi = this.apiService;
                networkDataSourceImpl$getNews$1.L$0 = str3;
                networkDataSourceImpl$getNews$1.I$0 = intValue2;
                networkDataSourceImpl$getNews$1.label = 2;
                news = networkApi.getNews(str3, networkDataSourceImpl$getNews$1);
                if (news != coroutine_suspended) {
                    i2 = intValue2;
                    obj = news;
                    str = str3;
                    return (List) obj;
                }
                return coroutine_suspended;
            }
        }
        networkDataSourceImpl$getNews$1 = new NetworkDataSourceImpl$getNews$1(this, continuation);
        Object obj2 = networkDataSourceImpl$getNews$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = networkDataSourceImpl$getNews$1.label;
        if (i != 0) {
        }
        Pair pair2 = (Pair) obj2;
        String str32 = (String) pair2.component1();
        int intValue22 = ((Number) pair2.component2()).intValue();
        this.serverChannels[ChannelType.NEWS.ordinal()] = Boxing.boxInt(intValue22);
        NetworkApi networkApi2 = this.apiService;
        networkDataSourceImpl$getNews$1.L$0 = str32;
        networkDataSourceImpl$getNews$1.I$0 = intValue22;
        networkDataSourceImpl$getNews$1.label = 2;
        news = networkApi2.getNews(str32, networkDataSourceImpl$getNews$1);
        if (news != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    @Override // com.miami.game.core.api.network.NetworkDataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getHwVersion(Continuation<? super HwVersion> continuation) {
        NetworkDataSourceImpl$getHwVersion$1 networkDataSourceImpl$getHwVersion$1;
        int i;
        try {
            if (continuation instanceof NetworkDataSourceImpl$getHwVersion$1) {
                networkDataSourceImpl$getHwVersion$1 = (NetworkDataSourceImpl$getHwVersion$1) continuation;
                if ((networkDataSourceImpl$getHwVersion$1.label & Integer.MIN_VALUE) != 0) {
                    networkDataSourceImpl$getHwVersion$1.label -= Integer.MIN_VALUE;
                    Object obj = networkDataSourceImpl$getHwVersion$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = networkDataSourceImpl$getHwVersion$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        NetworkApi networkApi = this.apiService;
                        networkDataSourceImpl$getHwVersion$1.label = 1;
                        obj = networkApi.getHwVersion("https://pc.az-ins.com/mobile.json", networkDataSourceImpl$getHwVersion$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return (HwVersion) obj;
                }
            }
            if (i != 0) {
            }
            return (HwVersion) obj;
        } catch (Exception e) {
            Log.e(this.tag, "getHwVersion: Unexpected error while fetching HW version: " + e.getMessage());
            return createDefaultHwVersion();
        }
        networkDataSourceImpl$getHwVersion$1 = new NetworkDataSourceImpl$getHwVersion$1(this, continuation);
        Object obj2 = networkDataSourceImpl$getHwVersion$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = networkDataSourceImpl$getHwVersion$1.label;
    }

    private final HwVersion createDefaultHwVersion() {
        return new HwVersion(1, "1.0.0");
    }
}
