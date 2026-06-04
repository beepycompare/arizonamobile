package com.miami.game.core.api.network;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.miami.game.core.api.model.response.HwVersion;
import com.miami.game.core.api.model.response.news.NewsApiModelItem;
import com.miami.game.core.api.model.response.servers.ServersApiModelItem;
import com.miami.game.core.api.network.retrofit.NetworkApi;
import com.miami.game.core.connection.resolver.api.ConnectionResolver;
import com.miami.game.core.network.error_handler.CoroutineErrorHandlerRetrofitFactory;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;
/* compiled from: NetworkDataSourceImpl.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001*B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\tH\u0002J>\u0010\u0016\u001a\u0004\u0018\u0001H\u0017\"\u0004\b\u0000\u0010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u001e\u0010\u001a\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00170\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001bH\u0082@¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0096@¢\u0006\u0002\u0010\"J\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0096@¢\u0006\u0002\u0010\"J\u0016\u0010$\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0096@¢\u0006\u0002\u0010\"J\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010 H\u0096@¢\u0006\u0002\u0010\"J\u000e\u0010'\u001a\u00020(H\u0096@¢\u0006\u0002\u0010\"J\b\u0010)\u001a\u00020(H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082D¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/miami/game/core/api/network/NetworkDataSourceImpl;", "Lcom/miami/game/core/api/network/NetworkDataSource;", "connectionResolver", "Lcom/miami/game/core/connection/resolver/api/ConnectionResolver;", "retrofitFactory", "Lcom/miami/game/core/network/error_handler/CoroutineErrorHandlerRetrofitFactory;", "<init>", "(Lcom/miami/game/core/connection/resolver/api/ConnectionResolver;Lcom/miami/game/core/network/error_handler/CoroutineErrorHandlerRetrofitFactory;)V", "maxConnectionTrying", "", "tag", "", "apiService", "Lcom/miami/game/core/api/network/retrofit/NetworkApi;", "serverChannels", "Ljava/util/concurrent/atomic/AtomicIntegerArray;", "retryGetFromServer", "retryBaseDelayMs", "", "retryMaxDelayMs", "backoffFor", "attempt", "retryOrReturnNull", ExifInterface.GPS_DIRECTION_TRUE, "channelType", "Lcom/miami/game/core/api/network/NetworkDataSourceImpl$ChannelType;", "fetcher", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lcom/miami/game/core/api/network/NetworkDataSourceImpl$ChannelType;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getServersMobile", "", "Lcom/miami/game/core/api/model/response/servers/ServersApiModelItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getServersDesktop", "getServersVc", "getNews", "Lcom/miami/game/core/api/model/response/news/NewsApiModelItem;", "getHwVersion", "Lcom/miami/game/core/api/model/response/HwVersion;", "createDefaultHwVersion", "ChannelType", "api-network"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NetworkDataSourceImpl implements NetworkDataSource {
    private final NetworkApi apiService;
    private final ConnectionResolver connectionResolver;
    private final int maxConnectionTrying;
    private final long retryBaseDelayMs;
    private final AtomicIntegerArray retryGetFromServer;
    private final long retryMaxDelayMs;
    private final AtomicIntegerArray serverChannels;
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
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = -1;
        }
        this.serverChannels = new AtomicIntegerArray(iArr);
        this.retryGetFromServer = new AtomicIntegerArray(ChannelType.getEntries().size());
        this.retryBaseDelayMs = 500L;
        this.retryMaxDelayMs = 5000L;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: NetworkDataSourceImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/api/network/NetworkDataSourceImpl$ChannelType;", "", "<init>", "(Ljava/lang/String;I)V", "MOBILE", "PC", "NEWS", "VC", "api-network"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ChannelType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ChannelType[] $VALUES;
        public static final ChannelType MOBILE = new ChannelType("MOBILE", 0);
        public static final ChannelType PC = new ChannelType("PC", 1);
        public static final ChannelType NEWS = new ChannelType("NEWS", 2);
        public static final ChannelType VC = new ChannelType("VC", 3);

        private static final /* synthetic */ ChannelType[] $values() {
            return new ChannelType[]{MOBILE, PC, NEWS, VC};
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

    private final long backoffFor(int i) {
        return RangesKt.coerceAtMost(this.retryBaseDelayMs << RangesKt.coerceAtMost(i, 4), this.retryMaxDelayMs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a3 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object retryOrReturnNull(ChannelType channelType, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        NetworkDataSourceImpl$retryOrReturnNull$1 networkDataSourceImpl$retryOrReturnNull$1;
        int i;
        int ordinal;
        int i2;
        if (continuation instanceof NetworkDataSourceImpl$retryOrReturnNull$1) {
            networkDataSourceImpl$retryOrReturnNull$1 = (NetworkDataSourceImpl$retryOrReturnNull$1) continuation;
            if ((networkDataSourceImpl$retryOrReturnNull$1.label & Integer.MIN_VALUE) != 0) {
                networkDataSourceImpl$retryOrReturnNull$1.label -= Integer.MIN_VALUE;
                Object obj = networkDataSourceImpl$retryOrReturnNull$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = networkDataSourceImpl$retryOrReturnNull$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ordinal = channelType.ordinal();
                    int i3 = this.retryGetFromServer.get(ordinal);
                    if (i3 >= this.maxConnectionTrying) {
                        return null;
                    }
                    this.retryGetFromServer.set(ordinal, i3 + 1);
                    this.serverChannels.incrementAndGet(ordinal);
                    long backoffFor = backoffFor(i3);
                    networkDataSourceImpl$retryOrReturnNull$1.L$0 = SpillingKt.nullOutSpilledVariable(channelType);
                    networkDataSourceImpl$retryOrReturnNull$1.L$1 = function1;
                    networkDataSourceImpl$retryOrReturnNull$1.I$0 = ordinal;
                    networkDataSourceImpl$retryOrReturnNull$1.I$1 = i3;
                    networkDataSourceImpl$retryOrReturnNull$1.label = 1;
                    if (DelayKt.delay(backoffFor, networkDataSourceImpl$retryOrReturnNull$1) != coroutine_suspended) {
                        i2 = i3;
                    }
                } else if (i != 1) {
                    if (i == 2) {
                        int i4 = networkDataSourceImpl$retryOrReturnNull$1.I$1;
                        int i5 = networkDataSourceImpl$retryOrReturnNull$1.I$0;
                        Function1 function12 = (Function1) networkDataSourceImpl$retryOrReturnNull$1.L$1;
                        ChannelType channelType2 = (ChannelType) networkDataSourceImpl$retryOrReturnNull$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    i2 = networkDataSourceImpl$retryOrReturnNull$1.I$1;
                    int i6 = networkDataSourceImpl$retryOrReturnNull$1.I$0;
                    function1 = (Function1) networkDataSourceImpl$retryOrReturnNull$1.L$1;
                    ResultKt.throwOnFailure(obj);
                    ordinal = i6;
                    channelType = (ChannelType) networkDataSourceImpl$retryOrReturnNull$1.L$0;
                }
                networkDataSourceImpl$retryOrReturnNull$1.L$0 = SpillingKt.nullOutSpilledVariable(channelType);
                networkDataSourceImpl$retryOrReturnNull$1.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                networkDataSourceImpl$retryOrReturnNull$1.I$0 = ordinal;
                networkDataSourceImpl$retryOrReturnNull$1.I$1 = i2;
                networkDataSourceImpl$retryOrReturnNull$1.label = 2;
                Object invoke = function1.invoke(networkDataSourceImpl$retryOrReturnNull$1);
                return invoke != coroutine_suspended ? coroutine_suspended : invoke;
            }
        }
        networkDataSourceImpl$retryOrReturnNull$1 = new NetworkDataSourceImpl$retryOrReturnNull$1(this, continuation);
        Object obj2 = networkDataSourceImpl$retryOrReturnNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = networkDataSourceImpl$retryOrReturnNull$1.label;
        if (i != 0) {
        }
        networkDataSourceImpl$retryOrReturnNull$1.L$0 = SpillingKt.nullOutSpilledVariable(channelType);
        networkDataSourceImpl$retryOrReturnNull$1.L$1 = SpillingKt.nullOutSpilledVariable(function1);
        networkDataSourceImpl$retryOrReturnNull$1.I$0 = ordinal;
        networkDataSourceImpl$retryOrReturnNull$1.I$1 = i2;
        networkDataSourceImpl$retryOrReturnNull$1.label = 2;
        Object invoke2 = function1.invoke(networkDataSourceImpl$retryOrReturnNull$1);
        if (invoke2 != coroutine_suspended2) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|(1:(1:(1:(3:11|12|13)(2:15|16))(5:17|18|19|20|21))(1:27))(1:36)|28|29|30|(3:32|20|21)|26))|38|6|(0)(0)|28|29|30|(0)|26|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006b, code lost:
        if (r11 == r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b2, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b3, code lost:
        r2 = r11;
        r11 = r4;
        r4 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ed, code lost:
        if (r11 == r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
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
                    int i3 = this.serverChannels.get(ChannelType.MOBILE.ordinal());
                    networkDataSourceImpl$getServersMobile$1.label = 1;
                    obj = connectionResolver.getServerMobileList(i3, networkDataSourceImpl$getServersMobile$1);
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else if (i != 2) {
                    if (i == 3) {
                        int i4 = networkDataSourceImpl$getServersMobile$1.I$0;
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
                        List list = (List) obj;
                        this.retryGetFromServer.set(ChannelType.MOBILE.ordinal(), 0);
                        return list;
                    } catch (Exception e) {
                        Exception e2 = e;
                        Log.e(this.tag, "getServersMobile: Unexpected error while fetching servers: " + e2.getMessage());
                        networkDataSourceImpl$getServersMobile$1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                        networkDataSourceImpl$getServersMobile$1.L$1 = SpillingKt.nullOutSpilledVariable(e2);
                        networkDataSourceImpl$getServersMobile$1.I$0 = i2;
                        networkDataSourceImpl$getServersMobile$1.label = 3;
                        obj = retryOrReturnNull(ChannelType.MOBILE, new NetworkDataSourceImpl$getServersMobile$2(this, null), networkDataSourceImpl$getServersMobile$1);
                    }
                }
                Pair pair = (Pair) obj;
                String str3 = (String) pair.component1();
                int intValue = ((Number) pair.component2()).intValue();
                this.serverChannels.set(ChannelType.MOBILE.ordinal(), intValue);
                NetworkApi networkApi = this.apiService;
                networkDataSourceImpl$getServersMobile$1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                networkDataSourceImpl$getServersMobile$1.I$0 = intValue;
                networkDataSourceImpl$getServersMobile$1.label = 2;
                servers = networkApi.getServers(str3, networkDataSourceImpl$getServersMobile$1);
                if (servers != coroutine_suspended) {
                    i2 = intValue;
                    obj = servers;
                    str = str3;
                    List list2 = (List) obj;
                    this.retryGetFromServer.set(ChannelType.MOBILE.ordinal(), 0);
                    return list2;
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
        int intValue2 = ((Number) pair2.component2()).intValue();
        this.serverChannels.set(ChannelType.MOBILE.ordinal(), intValue2);
        NetworkApi networkApi2 = this.apiService;
        networkDataSourceImpl$getServersMobile$1.L$0 = SpillingKt.nullOutSpilledVariable(str32);
        networkDataSourceImpl$getServersMobile$1.I$0 = intValue2;
        networkDataSourceImpl$getServersMobile$1.label = 2;
        servers = networkApi2.getServers(str32, networkDataSourceImpl$getServersMobile$1);
        if (servers != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|(1:(1:(1:(3:11|12|13)(2:15|16))(5:17|18|19|20|21))(1:27))(1:36)|28|29|30|(3:32|20|21)|26))|38|6|(0)(0)|28|29|30|(0)|26|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006b, code lost:
        if (r11 == r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b2, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b3, code lost:
        r2 = r11;
        r11 = r4;
        r4 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ed, code lost:
        if (r11 == r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
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
                    int i3 = this.serverChannels.get(ChannelType.PC.ordinal());
                    networkDataSourceImpl$getServersDesktop$1.label = 1;
                    obj = connectionResolver.getServerDesktopList(i3, networkDataSourceImpl$getServersDesktop$1);
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else if (i != 2) {
                    if (i == 3) {
                        int i4 = networkDataSourceImpl$getServersDesktop$1.I$0;
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
                        List list = (List) obj;
                        this.retryGetFromServer.set(ChannelType.PC.ordinal(), 0);
                        return list;
                    } catch (Exception e) {
                        Exception e2 = e;
                        Log.e(this.tag, "getServersDesktop: Unexpected error while fetching servers: " + e2.getMessage());
                        networkDataSourceImpl$getServersDesktop$1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                        networkDataSourceImpl$getServersDesktop$1.L$1 = SpillingKt.nullOutSpilledVariable(e2);
                        networkDataSourceImpl$getServersDesktop$1.I$0 = i2;
                        networkDataSourceImpl$getServersDesktop$1.label = 3;
                        obj = retryOrReturnNull(ChannelType.PC, new NetworkDataSourceImpl$getServersDesktop$2(this, null), networkDataSourceImpl$getServersDesktop$1);
                    }
                }
                Pair pair = (Pair) obj;
                String str3 = (String) pair.component1();
                int intValue = ((Number) pair.component2()).intValue();
                this.serverChannels.set(ChannelType.PC.ordinal(), intValue);
                NetworkApi networkApi = this.apiService;
                networkDataSourceImpl$getServersDesktop$1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                networkDataSourceImpl$getServersDesktop$1.I$0 = intValue;
                networkDataSourceImpl$getServersDesktop$1.label = 2;
                servers = networkApi.getServers(str3, networkDataSourceImpl$getServersDesktop$1);
                if (servers != coroutine_suspended) {
                    i2 = intValue;
                    obj = servers;
                    str = str3;
                    List list2 = (List) obj;
                    this.retryGetFromServer.set(ChannelType.PC.ordinal(), 0);
                    return list2;
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
        int intValue2 = ((Number) pair2.component2()).intValue();
        this.serverChannels.set(ChannelType.PC.ordinal(), intValue2);
        NetworkApi networkApi2 = this.apiService;
        networkDataSourceImpl$getServersDesktop$1.L$0 = SpillingKt.nullOutSpilledVariable(str32);
        networkDataSourceImpl$getServersDesktop$1.I$0 = intValue2;
        networkDataSourceImpl$getServersDesktop$1.label = 2;
        servers = networkApi2.getServers(str32, networkDataSourceImpl$getServersDesktop$1);
        if (servers != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|(1:(1:(1:(3:11|12|13)(2:15|16))(5:17|18|19|20|21))(1:27))(1:36)|28|29|30|(3:32|20|21)|26))|38|6|(0)(0)|28|29|30|(0)|26|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006b, code lost:
        if (r11 == r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b2, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b3, code lost:
        r2 = r11;
        r11 = r4;
        r4 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ed, code lost:
        if (r11 == r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    @Override // com.miami.game.core.api.network.NetworkDataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getServersVc(Continuation<? super List<ServersApiModelItem>> continuation) {
        NetworkDataSourceImpl$getServersVc$1 networkDataSourceImpl$getServersVc$1;
        Object coroutine_suspended;
        int i;
        int i2;
        String str;
        Object servers;
        if (continuation instanceof NetworkDataSourceImpl$getServersVc$1) {
            networkDataSourceImpl$getServersVc$1 = (NetworkDataSourceImpl$getServersVc$1) continuation;
            if ((networkDataSourceImpl$getServersVc$1.label & Integer.MIN_VALUE) != 0) {
                networkDataSourceImpl$getServersVc$1.label -= Integer.MIN_VALUE;
                Object obj = networkDataSourceImpl$getServersVc$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = networkDataSourceImpl$getServersVc$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ConnectionResolver connectionResolver = this.connectionResolver;
                    int i3 = this.serverChannels.get(ChannelType.VC.ordinal());
                    networkDataSourceImpl$getServersVc$1.label = 1;
                    obj = connectionResolver.getServerVcList(i3, networkDataSourceImpl$getServersVc$1);
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else if (i != 2) {
                    if (i == 3) {
                        int i4 = networkDataSourceImpl$getServersVc$1.I$0;
                        Exception exc = (Exception) networkDataSourceImpl$getServersVc$1.L$1;
                        String str2 = (String) networkDataSourceImpl$getServersVc$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return (List) obj;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    i2 = networkDataSourceImpl$getServersVc$1.I$0;
                    str = (String) networkDataSourceImpl$getServersVc$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        List list = (List) obj;
                        this.retryGetFromServer.set(ChannelType.VC.ordinal(), 0);
                        return list;
                    } catch (Exception e) {
                        Exception e2 = e;
                        Log.e(this.tag, "getServersVc: Unexpected error while fetching servers: " + e2.getMessage());
                        networkDataSourceImpl$getServersVc$1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                        networkDataSourceImpl$getServersVc$1.L$1 = SpillingKt.nullOutSpilledVariable(e2);
                        networkDataSourceImpl$getServersVc$1.I$0 = i2;
                        networkDataSourceImpl$getServersVc$1.label = 3;
                        obj = retryOrReturnNull(ChannelType.VC, new NetworkDataSourceImpl$getServersVc$2(this, null), networkDataSourceImpl$getServersVc$1);
                    }
                }
                Pair pair = (Pair) obj;
                String str3 = (String) pair.component1();
                int intValue = ((Number) pair.component2()).intValue();
                this.serverChannels.set(ChannelType.VC.ordinal(), intValue);
                NetworkApi networkApi = this.apiService;
                networkDataSourceImpl$getServersVc$1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                networkDataSourceImpl$getServersVc$1.I$0 = intValue;
                networkDataSourceImpl$getServersVc$1.label = 2;
                servers = networkApi.getServers(str3, networkDataSourceImpl$getServersVc$1);
                if (servers != coroutine_suspended) {
                    i2 = intValue;
                    obj = servers;
                    str = str3;
                    List list2 = (List) obj;
                    this.retryGetFromServer.set(ChannelType.VC.ordinal(), 0);
                    return list2;
                }
                return coroutine_suspended;
            }
        }
        networkDataSourceImpl$getServersVc$1 = new NetworkDataSourceImpl$getServersVc$1(this, continuation);
        Object obj2 = networkDataSourceImpl$getServersVc$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = networkDataSourceImpl$getServersVc$1.label;
        if (i != 0) {
        }
        Pair pair2 = (Pair) obj2;
        String str32 = (String) pair2.component1();
        int intValue2 = ((Number) pair2.component2()).intValue();
        this.serverChannels.set(ChannelType.VC.ordinal(), intValue2);
        NetworkApi networkApi2 = this.apiService;
        networkDataSourceImpl$getServersVc$1.L$0 = SpillingKt.nullOutSpilledVariable(str32);
        networkDataSourceImpl$getServersVc$1.I$0 = intValue2;
        networkDataSourceImpl$getServersVc$1.label = 2;
        servers = networkApi2.getServers(str32, networkDataSourceImpl$getServersVc$1);
        if (servers != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|(1:(1:(1:(3:11|12|13)(2:15|16))(5:17|18|19|20|21))(1:27))(1:36)|28|29|30|(3:32|20|21)|26))|38|6|(0)(0)|28|29|30|(0)|26|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006a, code lost:
        if (r11 == r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ad, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ae, code lost:
        r2 = r11;
        r11 = r4;
        r4 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f2, code lost:
        if (r11 == r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009a  */
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
                    int i3 = this.serverChannels.get(ChannelType.NEWS.ordinal());
                    networkDataSourceImpl$getNews$1.label = 1;
                    obj = connectionResolver.getNewsServer(i3, networkDataSourceImpl$getNews$1);
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else if (i != 2) {
                    if (i == 3) {
                        int i4 = networkDataSourceImpl$getNews$1.I$0;
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
                        List list = (List) obj;
                        this.retryGetFromServer.set(ChannelType.NEWS.ordinal(), 0);
                        return list;
                    } catch (Exception e) {
                        Exception e2 = e;
                        Log.e(this.tag, "getNews: Unexpected error while fetching servers: " + e2.getMessage() + ", " + str);
                        networkDataSourceImpl$getNews$1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                        networkDataSourceImpl$getNews$1.L$1 = SpillingKt.nullOutSpilledVariable(e2);
                        networkDataSourceImpl$getNews$1.I$0 = i2;
                        networkDataSourceImpl$getNews$1.label = 3;
                        obj = retryOrReturnNull(ChannelType.NEWS, new NetworkDataSourceImpl$getNews$2(this, null), networkDataSourceImpl$getNews$1);
                    }
                }
                Pair pair = (Pair) obj;
                String str3 = (String) pair.component1();
                int intValue = ((Number) pair.component2()).intValue();
                this.serverChannels.set(ChannelType.NEWS.ordinal(), intValue);
                NetworkApi networkApi = this.apiService;
                networkDataSourceImpl$getNews$1.L$0 = str3;
                networkDataSourceImpl$getNews$1.I$0 = intValue;
                networkDataSourceImpl$getNews$1.label = 2;
                news = networkApi.getNews(str3, networkDataSourceImpl$getNews$1);
                if (news != coroutine_suspended) {
                    i2 = intValue;
                    obj = news;
                    str = str3;
                    List list2 = (List) obj;
                    this.retryGetFromServer.set(ChannelType.NEWS.ordinal(), 0);
                    return list2;
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
        int intValue2 = ((Number) pair2.component2()).intValue();
        this.serverChannels.set(ChannelType.NEWS.ordinal(), intValue2);
        NetworkApi networkApi2 = this.apiService;
        networkDataSourceImpl$getNews$1.L$0 = str32;
        networkDataSourceImpl$getNews$1.I$0 = intValue2;
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
