package okhttp3.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.collection.SieveCacheKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.Call;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.internal.http2.Header;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
/* compiled from: -UtilJvm.kt */
@Metadata(d1 = {"\u0000´\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0016\u0010\b\u001a\u00020\u0005*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0007H\u0000\u001a)\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000eH\u0000¢\u0006\u0002\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0011H\u0000\u001a \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0000\u001a\u001f\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0012\u0010\u001d\u001a\u00020\u001e*\b\u0012\u0004\u0012\u00020 0\u001fH\u0000\u001a\u0012\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f*\u00020\u001eH\u0000\u001a\u0014\u0010\"\u001a\u00020\u0007*\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0000\u001a\f\u0010$\u001a\u00020%*\u00020&H\u0000\u001a\u001c\u0010'\u001a\u00020\u0007*\u00020(2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u0019H\u0000\u001a\f\u0010'\u001a\u00020**\u00020\u0012H\u0000\u001a\u001c\u0010+\u001a\u00020\u0007*\u00020(2\u0006\u0010,\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u0019H\u0000\u001a\f\u0010-\u001a\u00020\u0005*\u00020.H\u0000\u001a\u0014\u0010/\u001a\u00020\u0007*\u00020.2\u0006\u00100\u001a\u00020\u0012H\u0000\u001a\"\u00101\u001a\u00020*2\u0006\u0010\u0004\u001a\u00020\u00052\f\u00102\u001a\b\u0012\u0004\u0012\u00020*03H\u0080\bø\u0001\u0000\u001a\f\u00104\u001a\u00020\u0017*\u000205H\u0000\u001a\u001f\u00106\u001a\b\u0012\u0004\u0012\u0002H70\u001f\"\u0004\b\u0000\u00107*\b\u0012\u0004\u0012\u0002H70\u001fH\u0080\b\u001a\u001f\u00106\u001a\b\u0012\u0004\u0012\u0002H708\"\u0004\b\u0000\u00107*\b\u0012\u0004\u0012\u0002H708H\u0080\b\u001a1\u00106\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H;09\"\u0004\b\u0000\u0010:\"\u0004\b\u0001\u0010;*\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H;09H\u0080\b\u001a\u001e\u0010<\u001a\b\u0012\u0004\u0012\u0002H70\u001f\"\u0004\b\u0000\u00107*\b\u0012\u0004\u0012\u0002H70\u001fH\u0000\u001a-\u0010=\u001a\b\u0012\u0004\u0012\u0002H70\u001f\"\u0004\b\u0000\u001072\u0012\u0010>\u001a\n\u0012\u0006\b\u0001\u0012\u0002H70\r\"\u0002H7H\u0001¢\u0006\u0002\u0010?\u001a'\u0010<\u001a\b\u0012\u0004\u0012\u0002H70\u001f\"\u0004\b\u0000\u00107*\f\u0012\u0006\b\u0001\u0012\u0002H7\u0018\u00010\rH\u0000¢\u0006\u0002\u0010?\u001a\f\u0010@\u001a\u00020**\u00020.H\u0000\u001a\f\u0010@\u001a\u00020**\u00020AH\u0000\u001a\f\u0010B\u001a\u00020\u0005*\u00020\u0017H\u0000\u001a\f\u0010B\u001a\u00020\u0005*\u00020\u0015H\u0000\u001a3\u0010C\u001a\u0004\u0018\u0001H7\"\u0004\b\u0000\u001072\u0006\u0010D\u001a\u00020\u000e2\f\u0010E\u001a\b\u0012\u0004\u0012\u0002H70F2\u0006\u0010G\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0010H\u001a\f\u0010J\u001a\u00020**\u00020KH\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010I\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010L\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006M"}, d2 = {"UTC", "Ljava/util/TimeZone;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "name", "", "daemon", "", "toHostHeader", "Lokhttp3/HttpUrl;", "includeDefaultPort", "format", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "readBomAsCharset", "Ljava/nio/charset/Charset;", "Lokio/BufferedSource;", "default", "checkDuration", "", TypedValues.TransitionType.S_DURATION, "", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/Duration;", "checkDuration-HG0u8IE", "(Ljava/lang/String;J)I", "toHeaders", "Lokhttp3/Headers;", "", "Lokhttp3/internal/http2/Header;", "toHeaderList", "canReuseConnectionFor", "other", "asFactory", "Lokhttp3/EventListener$Factory;", "Lokhttp3/EventListener;", "skipAll", "Lokio/Source;", "timeUnit", "", "discard", "timeout", "peerName", "Ljava/net/Socket;", "isHealthy", "source", "threadName", "block", "Lkotlin/Function0;", "headersContentLength", "Lokhttp3/Response;", "unmodifiable", ExifInterface.GPS_DIRECTION_TRUE, "", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "toImmutableList", "immutableListOf", "elements", "([Ljava/lang/Object;)Ljava/util/List;", "closeQuietly", "Ljava/net/ServerSocket;", "toHexString", "readFieldOrNull", "instance", "fieldType", "Ljava/lang/Class;", "fieldName", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "assertionsEnabled", "assertLockNotHeld", "Lokhttp3/Dispatcher;", "okHttpName", "okhttp"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class _UtilJvmKt {
    public static final TimeZone UTC;
    public static final boolean assertionsEnabled;
    public static final String okHttpName;

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventListener asFactory$lambda$9(EventListener eventListener, Call it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return eventListener;
    }

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Intrinsics.checkNotNull(timeZone);
        UTC = timeZone;
        assertionsEnabled = false;
        String name = OkHttpClient.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        okHttpName = StringsKt.removeSuffix(StringsKt.removePrefix(name, (CharSequence) "okhttp3."), (CharSequence) "Client");
    }

    public static final ThreadFactory threadFactory(final String name, final boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ThreadFactory() { // from class: okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread threadFactory$lambda$1;
                threadFactory$lambda$1 = _UtilJvmKt.threadFactory$lambda$1(name, z, runnable);
                return threadFactory$lambda$1;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread threadFactory$lambda$1(String str, boolean z, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z);
        return thread;
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return toHostHeader(httpUrl, z);
    }

    public static final String toHostHeader(HttpUrl httpUrl, boolean z) {
        String host;
        Intrinsics.checkNotNullParameter(httpUrl, "<this>");
        if (StringsKt.contains$default((CharSequence) httpUrl.host(), (CharSequence) StringUtils.PROCESS_POSTFIX_DELIMITER, false, 2, (Object) null)) {
            host = "[" + httpUrl.host() + AbstractJsonLexerKt.END_LIST;
        } else {
            host = httpUrl.host();
        }
        return (z || httpUrl.port() != HttpUrl.Companion.defaultPort(httpUrl.scheme())) ? host + AbstractJsonLexerKt.COLON + httpUrl.port() : host;
    }

    public static final String format(String format, Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(args, args.length);
        String format2 = String.format(locale, format, Arrays.copyOf(copyOf, copyOf.length));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        return format2;
    }

    public static final Charset readBomAsCharset(BufferedSource bufferedSource, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(charset, "default");
        int select = bufferedSource.select(_UtilCommonKt.getUNICODE_BOMS());
        if (select != -1) {
            if (select != 0) {
                if (select != 1) {
                    if (select != 2) {
                        if (select != 3) {
                            if (select == 4) {
                                return Charsets.INSTANCE.UTF32_BE();
                            }
                            throw new AssertionError();
                        }
                        return Charsets.UTF_16LE;
                    }
                    return Charsets.INSTANCE.UTF32_LE();
                }
                return Charsets.UTF_16BE;
            }
            return Charsets.UTF_8;
        }
        return charset;
    }

    public static final int checkDuration(String name, long j, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(unit, "unit");
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i < 0) {
            throw new IllegalStateException((name + " < 0").toString());
        }
        long millis = unit.toMillis(j);
        if (millis <= SieveCacheKt.NodeLinkMask) {
            if (millis != 0 || i <= 0) {
                return (int) millis;
            }
            throw new IllegalArgumentException((name + " too small").toString());
        }
        throw new IllegalArgumentException((name + " too large").toString());
    }

    /* renamed from: checkDuration-HG0u8IE  reason: not valid java name */
    public static final int m10370checkDurationHG0u8IE(String name, long j) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (Duration.m9849isNegativeimpl(j)) {
            throw new IllegalStateException((name + " < 0").toString());
        }
        long m9834getInWholeMillisecondsimpl = Duration.m9834getInWholeMillisecondsimpl(j);
        if (m9834getInWholeMillisecondsimpl > SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException((name + " too large").toString());
        }
        if (m9834getInWholeMillisecondsimpl == 0 && Duration.m9850isPositiveimpl(j)) {
            throw new IllegalArgumentException((name + " too small").toString());
        }
        return (int) m9834getInWholeMillisecondsimpl;
    }

    public static final Headers toHeaders(List<Header> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            builder.addLenient$okhttp(header.component1().utf8(), header.component2().utf8());
        }
        return builder.build();
    }

    public static final List<Header> toHeaderList(Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        IntRange until = RangesKt.until(0, headers.size());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            arrayList.add(new Header(headers.name(nextInt), headers.value(nextInt)));
        }
        return arrayList;
    }

    public static final boolean canReuseConnectionFor(HttpUrl httpUrl, HttpUrl other) {
        Intrinsics.checkNotNullParameter(httpUrl, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.areEqual(httpUrl.host(), other.host()) && httpUrl.port() == other.port() && Intrinsics.areEqual(httpUrl.scheme(), other.scheme());
    }

    public static final EventListener.Factory asFactory(final EventListener eventListener) {
        Intrinsics.checkNotNullParameter(eventListener, "<this>");
        return new EventListener.Factory() { // from class: okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0
            @Override // okhttp3.EventListener.Factory
            public final EventListener create(Call call) {
                EventListener asFactory$lambda$9;
                asFactory$lambda$9 = _UtilJvmKt.asFactory$lambda$9(EventListener.this, call);
                return asFactory$lambda$9;
            }
        };
    }

    public static final boolean skipAll(Source source, int i, TimeUnit timeUnit) throws IOException {
        Intrinsics.checkNotNullParameter(source, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        long nanoTime = System.nanoTime();
        long deadlineNanoTime = source.timeout().hasDeadline() ? source.timeout().deadlineNanoTime() - nanoTime : Long.MAX_VALUE;
        source.timeout().deadlineNanoTime(Math.min(deadlineNanoTime, timeUnit.toNanos(i)) + nanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                buffer.clear();
            }
            if (deadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
                return true;
            }
            source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            return true;
        } catch (InterruptedIOException unused) {
            if (deadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
                return false;
            }
            source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            return false;
        } catch (Throwable th) {
            if (deadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            throw th;
        }
    }

    public static final void skipAll(BufferedSource bufferedSource) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        while (!bufferedSource.exhausted()) {
            bufferedSource.skip(bufferedSource.getBuffer().size());
        }
    }

    public static final boolean discard(Source source, int i, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(source, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        try {
            return skipAll(source, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String peerName(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "<this>");
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        if (remoteSocketAddress instanceof InetSocketAddress) {
            String hostName = ((InetSocketAddress) remoteSocketAddress).getHostName();
            Intrinsics.checkNotNullExpressionValue(hostName, "getHostName(...)");
            return hostName;
        }
        return remoteSocketAddress.toString();
    }

    public static final boolean isHealthy(Socket socket, BufferedSource source) {
        Intrinsics.checkNotNullParameter(socket, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                return !source.exhausted();
            } finally {
                socket.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final void threadName(String name, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        Thread currentThread = Thread.currentThread();
        String name2 = currentThread.getName();
        currentThread.setName(name);
        try {
            block.invoke();
        } finally {
            currentThread.setName(name2);
        }
    }

    public static final long headersContentLength(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        String str = response.headers().get("Content-Length");
        if (str != null) {
            return _UtilCommonKt.toLongOrDefault(str, -1L);
        }
        return -1L;
    }

    public static final <T> List<T> unmodifiable(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<T> unmodifiableList = Collections.unmodifiableList(list);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(...)");
        return unmodifiableList;
    }

    public static final <T> Set<T> unmodifiable(Set<? extends T> set) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Set<T> unmodifiableSet = Collections.unmodifiableSet(set);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(...)");
        return unmodifiableSet;
    }

    public static final <K, V> Map<K, V> unmodifiable(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(map);
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "unmodifiableMap(...)");
        return unmodifiableMap;
    }

    public static final <T> List<T> toImmutableList(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        if (list.size() == 1) {
            List<T> singletonList = Collections.singletonList(list.get(0));
            Intrinsics.checkNotNullExpressionValue(singletonList, "singletonList(...)");
            return singletonList;
        }
        Object[] array = list.toArray();
        Intrinsics.checkNotNullExpressionValue(array, "toArray(...)");
        List<T> unmodifiableList = Collections.unmodifiableList(ArraysKt.asList(array));
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(...)");
        Intrinsics.checkNotNull(unmodifiableList, "null cannot be cast to non-null type kotlin.collections.List<T of okhttp3.internal._UtilJvmKt.toImmutableList>");
        return unmodifiableList;
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return toImmutableList(elements);
    }

    public static final <T> List<T> toImmutableList(T[] tArr) {
        if (tArr == null || tArr.length == 0) {
            return CollectionsKt.emptyList();
        }
        if (tArr.length == 1) {
            List<T> singletonList = Collections.singletonList(tArr[0]);
            Intrinsics.checkNotNullExpressionValue(singletonList, "singletonList(...)");
            return singletonList;
        }
        List<T> unmodifiableList = Collections.unmodifiableList(ArraysKt.asList((Object[]) tArr.clone()));
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(...)");
        return unmodifiableList;
    }

    public static final void closeQuietly(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e) {
            throw e;
        } catch (RuntimeException e2) {
            if (!Intrinsics.areEqual(e2.getMessage(), "bio == null")) {
                throw e2;
            }
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(ServerSocket serverSocket) {
        Intrinsics.checkNotNullParameter(serverSocket, "<this>");
        try {
            serverSocket.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final String toHexString(long j) {
        String hexString = Long.toHexString(j);
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(...)");
        return hexString;
    }

    public static final String toHexString(int i) {
        String hexString = Integer.toHexString(i);
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(...)");
        return hexString;
    }

    public static final <T> T readFieldOrNull(Object instance, Class<T> fieldType, String fieldName) {
        T t;
        Object readFieldOrNull;
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(fieldType, "fieldType");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Class<?> cls = instance.getClass();
        while (true) {
            t = null;
            if (!Intrinsics.areEqual(cls, Object.class)) {
                try {
                    Field declaredField = cls.getDeclaredField(fieldName);
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(instance);
                    if (!fieldType.isInstance(obj)) {
                        break;
                    }
                    t = fieldType.cast(obj);
                    break;
                } catch (NoSuchFieldException unused) {
                    cls = cls.getSuperclass();
                    Intrinsics.checkNotNullExpressionValue(cls, "getSuperclass(...)");
                }
            } else if (Intrinsics.areEqual(fieldName, "delegate") || (readFieldOrNull = readFieldOrNull(instance, Object.class, "delegate")) == null) {
                return null;
            } else {
                return (T) readFieldOrNull(readFieldOrNull, fieldType, fieldName);
            }
        }
        return t;
    }

    public static final void assertLockNotHeld(Dispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "<this>");
        if (assertionsEnabled && Thread.holdsLock(dispatcher)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + dispatcher);
        }
    }
}
