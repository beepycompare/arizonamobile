package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
/* compiled from: Deprecated.kt */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aC\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001d\u0010\u0004\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0004\u0012\u0002H\u00010\u0005¢\u0006\u0002\b\u0007H\u0087\b¢\u0006\u0002\u0010\b\u001a2\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\n0\u0005H\u0087H¢\u0006\u0002\u0010\f\u001aJ\u0010\r\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u00122\u001a\u0010\u0013\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u0014\"\u0006\u0012\u0002\b\u00030\u0006H\u0001¢\u0006\u0002\u0010\u0015\u001a&\u0010\u0016\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0087@¢\u0006\u0002\u0010\u0019\u001a(\u0010\u001a\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0087@¢\u0006\u0002\u0010\u0019\u001a\u001e\u0010\u001b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a \u0010\u001d\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a&\u0010\u001e\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u001f\u001a\u0002H\u0002H\u0087@¢\u0006\u0002\u0010 \u001a\u001e\u0010!\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a&\u0010\"\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u001f\u001a\u0002H\u0002H\u0087@¢\u0006\u0002\u0010 \u001a \u0010#\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a\u001e\u0010$\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a \u0010%\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a0\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010'\u001a\u00020\u00182\b\b\u0002\u0010(\u001a\u00020)H\u0007\u001aQ\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2\"\u0010+\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0007¢\u0006\u0002\u00100\u001aQ\u00101\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2\"\u0010+\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0001¢\u0006\u0002\u00100\u001af\u00102\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)27\u0010+\u001a3\b\u0001\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-\u0012\u0006\u0012\u0004\u0018\u00010/03H\u0007¢\u0006\u0002\u00104\u001aQ\u00105\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2\"\u0010+\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0007¢\u0006\u0002\u00100\u001a$\u00106\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\b\b\u0000\u0010\u0002*\u00020/*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0006H\u0001\u001a>\u00107\u001a\u0002H8\"\b\b\u0000\u0010\u0002*\u00020/\"\u0010\b\u0001\u00108*\n\u0012\u0006\b\u0000\u0012\u0002H\u000209*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00062\u0006\u0010:\u001a\u0002H8H\u0087@¢\u0006\u0002\u0010;\u001a<\u00107\u001a\u0002H8\"\b\b\u0000\u0010\u0002*\u00020/\"\u000e\b\u0001\u00108*\b\u0012\u0004\u0012\u0002H\u00020<*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00062\u0006\u0010:\u001a\u0002H8H\u0087@¢\u0006\u0002\u0010=\u001a0\u0010>\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010'\u001a\u00020\u00182\b\b\u0002\u0010(\u001a\u00020)H\u0007\u001aQ\u0010?\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2\"\u0010+\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0007¢\u0006\u0002\u00100\u001a6\u0010@\u001a\u0002H8\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u00108*\b\u0012\u0004\u0012\u0002H\u00020<*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010:\u001a\u0002H8H\u0081@¢\u0006\u0002\u0010=\u001a8\u0010A\u001a\u0002H8\"\u0004\b\u0000\u0010\u0002\"\u0010\b\u0001\u00108*\n\u0012\u0006\b\u0000\u0012\u0002H\u000209*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010:\u001a\u0002H8H\u0081@¢\u0006\u0002\u0010;\u001a<\u0010B\u001a\u000e\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u0002HE0C\"\u0004\b\u0000\u0010D\"\u0004\b\u0001\u0010E*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u0002HE0F0\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001aR\u0010B\u001a\u0002HG\"\u0004\b\u0000\u0010D\"\u0004\b\u0001\u0010E\"\u0018\b\u0002\u0010G*\u0012\u0012\u0006\b\u0000\u0012\u0002HD\u0012\u0006\b\u0000\u0012\u0002HE0H*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u0002HE0F0\u00062\u0006\u0010:\u001a\u0002HGH\u0081@¢\u0006\u0002\u0010I\u001a$\u0010J\u001a\b\u0012\u0004\u0012\u0002H\u00020K\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a$\u0010L\u001a\b\u0012\u0004\u0012\u0002H\u00020M\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a]\u0010N\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2(\u0010O\u001a$\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00060-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0007¢\u0006\u0002\u00100\u001aW\u0010P\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2\"\u0010O\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0001¢\u0006\u0002\u00100\u001al\u0010Q\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)27\u0010O\u001a3\b\u0001\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010-\u0012\u0006\u0012\u0004\u0018\u00010/03H\u0001¢\u0006\u0002\u00104\u001ar\u0010R\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u00020/*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)29\u0010O\u001a5\b\u0001\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u0002H\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010-\u0012\u0006\u0012\u0004\u0018\u00010/03H\u0007¢\u0006\u0002\u00104\u001a]\u0010S\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u00020/*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2$\u0010O\u001a \b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0007¢\u0006\u0002\u00100\u001a.\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020U0\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)H\u0007\u001a\u001e\u0010V\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0007\u001aW\u0010W\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010D*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2\"\u0010X\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002HD0-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0001¢\u0006\u0002\u00100\u001a$\u0010Y\u001a\b\u0012\u0004\u0012\u0002H\u00020Z\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0081@¢\u0006\u0002\u0010\u001c\u001a\u001e\u0010[\u001a\u00020.\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a\u001e\u0010\\\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a<\u0010]\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u001a\u0010^\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020_j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002``H\u0087@¢\u0006\u0002\u0010a\u001a<\u0010b\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u001a\u0010^\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020_j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002``H\u0087@¢\u0006\u0002\u0010a\u001a\u001e\u0010c\u001a\u00020.\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a$\u0010d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\b\b\u0000\u0010\u0002*\u00020/*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0006H\u0007\u001a?\u0010e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010F0\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00062\f\u0010f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0087\u0004\u001az\u0010e\u001a\b\u0012\u0004\u0012\u0002HE0\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010E*\b\u0012\u0004\u0012\u0002H\u00020\u00062\f\u0010f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00062\b\b\u0002\u0010(\u001a\u00020)26\u0010O\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(g\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(h\u0012\u0004\u0012\u0002HE0,H\u0001\u001a1\u0010i\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u0012*\u0006\u0012\u0002\b\u00030\u0006H\u0001\u001a`\u0010j\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\u00020k2\u0006\u0010(\u001a\u00020l2\b\b\u0002\u0010m\u001a\u00020\u00182/\b\u0001\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0-\u0012\u0006\u0012\u0004\u0018\u00010/0,¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010o¨\u0006p"}, d2 = {"consume", "R", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/BroadcastChannel;", "block", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "consumeEach", "", "action", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumesAll", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "channels", "", "([Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlin/jvm/functions/Function1;", "elementAt", FirebaseAnalytics.Param.INDEX, "", "(Lkotlinx/coroutines/channels/ReceiveChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "elementAtOrNull", "first", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firstOrNull", "indexOf", "element", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "last", "lastIndexOf", "lastOrNull", "single", "singleOrNull", "drop", "n", "context", "Lkotlin/coroutines/CoroutineContext;", "dropWhile", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "filter", "filterIndexed", "Lkotlin/Function3;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/channels/ReceiveChannel;", "filterNot", "filterNotNull", "filterNotNullTo", "C", "", FirebaseAnalytics.Param.DESTINATION, "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/SendChannel;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "take", "takeWhile", "toChannel", "toCollection", "toMap", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/Pair;", "M", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toMutableList", "", "toSet", "", "flatMap", "transform", "map", "mapIndexed", "mapIndexedNotNull", "mapNotNull", "withIndex", "Lkotlin/collections/IndexedValue;", "distinct", "distinctBy", "selector", "toMutableSet", "", "any", "count", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Comparator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "minWith", "none", "requireNoNulls", "zip", "other", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "consumes", "produce", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/Job;", "capacity", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/Job;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/coroutines/channels/ChannelsKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class ChannelsKt__DeprecatedKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E, R> R consume(BroadcastChannel<E> broadcastChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        ReceiveChannel<E> openSubscription = broadcastChannel.openSubscription();
        try {
            return function1.invoke(openSubscription);
        } finally {
            ReceiveChannel.cancel$default((ReceiveChannel) openSubscription, (CancellationException) null, 1, (Object) null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00a2 A[Catch: all -> 0x00b4, TryCatch #0 {all -> 0x00b4, blocks: (B:64:0x009a, B:66:0x00a2, B:67:0x00ac), top: B:77:0x009a }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ac A[Catch: all -> 0x00b4, TRY_LEAVE, TryCatch #0 {all -> 0x00b4, blocks: (B:64:0x009a, B:66:0x00a2, B:67:0x00ac), top: B:77:0x009a }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0096 -> B:77:0x009a). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.ERROR, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object consumeEach(BroadcastChannel<E> broadcastChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        ChannelsKt__DeprecatedKt$consumeEach$1 channelsKt__DeprecatedKt$consumeEach$1;
        int i;
        ReceiveChannel<E> receiveChannel;
        int i2;
        ChannelsKt__DeprecatedKt$consumeEach$1 channelsKt__DeprecatedKt$consumeEach$12;
        int i3;
        int i4;
        ReceiveChannel<E> receiveChannel2;
        ReceiveChannel<E> receiveChannel3;
        ChannelIterator<E> it;
        Function1<? super E, Unit> function12;
        BroadcastChannel<E> broadcastChannel2;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__DeprecatedKt$consumeEach$1) {
                channelsKt__DeprecatedKt$consumeEach$1 = (ChannelsKt__DeprecatedKt$consumeEach$1) continuation;
                if ((channelsKt__DeprecatedKt$consumeEach$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__DeprecatedKt$consumeEach$1.label -= Integer.MIN_VALUE;
                    Object obj = channelsKt__DeprecatedKt$consumeEach$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__DeprecatedKt$consumeEach$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        ReceiveChannel<E> openSubscription = broadcastChannel.openSubscription();
                        i2 = 0;
                        channelsKt__DeprecatedKt$consumeEach$12 = channelsKt__DeprecatedKt$consumeEach$1;
                        i3 = 0;
                        i4 = 0;
                        receiveChannel2 = openSubscription;
                        receiveChannel3 = receiveChannel2;
                        it = openSubscription.iterator();
                        function12 = function1;
                        broadcastChannel2 = broadcastChannel;
                        channelsKt__DeprecatedKt$consumeEach$12.L$0 = SpillingKt.nullOutSpilledVariable(broadcastChannel);
                        channelsKt__DeprecatedKt$consumeEach$12.L$1 = function12;
                        channelsKt__DeprecatedKt$consumeEach$12.L$2 = SpillingKt.nullOutSpilledVariable(broadcastChannel2);
                        channelsKt__DeprecatedKt$consumeEach$12.L$3 = receiveChannel3;
                        channelsKt__DeprecatedKt$consumeEach$12.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                        channelsKt__DeprecatedKt$consumeEach$12.L$5 = it;
                        channelsKt__DeprecatedKt$consumeEach$12.I$0 = i4;
                        channelsKt__DeprecatedKt$consumeEach$12.I$1 = i3;
                        channelsKt__DeprecatedKt$consumeEach$12.I$2 = i2;
                        channelsKt__DeprecatedKt$consumeEach$12.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$consumeEach$12);
                        if (hasNext != coroutine_suspended) {
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        int i5 = channelsKt__DeprecatedKt$consumeEach$1.I$2;
                        int i6 = channelsKt__DeprecatedKt$consumeEach$1.I$1;
                        int i7 = channelsKt__DeprecatedKt$consumeEach$1.I$0;
                        ChannelIterator<E> channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$consumeEach$1.L$5;
                        ReceiveChannel<E> receiveChannel4 = (ReceiveChannel) channelsKt__DeprecatedKt$consumeEach$1.L$4;
                        ReceiveChannel<E> receiveChannel5 = (ReceiveChannel) channelsKt__DeprecatedKt$consumeEach$1.L$3;
                        BroadcastChannel<E> broadcastChannel3 = (BroadcastChannel) channelsKt__DeprecatedKt$consumeEach$1.L$2;
                        Function1<? super E, Unit> function13 = (Function1) channelsKt__DeprecatedKt$consumeEach$1.L$1;
                        BroadcastChannel<E> broadcastChannel4 = (BroadcastChannel) channelsKt__DeprecatedKt$consumeEach$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        i2 = i5;
                        broadcastChannel = broadcastChannel4;
                        ReceiveChannel<E> receiveChannel6 = receiveChannel5;
                        ChannelIterator<E> channelIterator2 = channelIterator;
                        channelsKt__DeprecatedKt$consumeEach$12 = channelsKt__DeprecatedKt$consumeEach$1;
                        i3 = i6;
                        broadcastChannel2 = broadcastChannel3;
                        receiveChannel2 = receiveChannel4;
                        i4 = i7;
                        try {
                            if (!((Boolean) obj).booleanValue()) {
                                function13.invoke((Object) channelIterator2.next());
                                function12 = function13;
                                receiveChannel3 = receiveChannel6;
                                it = channelIterator2;
                                try {
                                    channelsKt__DeprecatedKt$consumeEach$12.L$0 = SpillingKt.nullOutSpilledVariable(broadcastChannel);
                                    channelsKt__DeprecatedKt$consumeEach$12.L$1 = function12;
                                    channelsKt__DeprecatedKt$consumeEach$12.L$2 = SpillingKt.nullOutSpilledVariable(broadcastChannel2);
                                    channelsKt__DeprecatedKt$consumeEach$12.L$3 = receiveChannel3;
                                    channelsKt__DeprecatedKt$consumeEach$12.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                                    channelsKt__DeprecatedKt$consumeEach$12.L$5 = it;
                                    channelsKt__DeprecatedKt$consumeEach$12.I$0 = i4;
                                    channelsKt__DeprecatedKt$consumeEach$12.I$1 = i3;
                                    channelsKt__DeprecatedKt$consumeEach$12.I$2 = i2;
                                    channelsKt__DeprecatedKt$consumeEach$12.label = 1;
                                    hasNext = it.hasNext(channelsKt__DeprecatedKt$consumeEach$12);
                                    if (hasNext != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    ReceiveChannel<E> receiveChannel7 = receiveChannel3;
                                    function13 = function12;
                                    obj = hasNext;
                                    receiveChannel6 = receiveChannel7;
                                    channelIterator2 = it;
                                    if (!((Boolean) obj).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        ReceiveChannel.cancel$default((ReceiveChannel) receiveChannel6, (CancellationException) null, 1, (Object) null);
                                        return Unit.INSTANCE;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    receiveChannel = receiveChannel3;
                                    ReceiveChannel.cancel$default((ReceiveChannel) receiveChannel, (CancellationException) null, 1, (Object) null);
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            receiveChannel = receiveChannel6;
                            ReceiveChannel.cancel$default((ReceiveChannel) receiveChannel, (CancellationException) null, 1, (Object) null);
                            throw th;
                        }
                    }
                }
            }
            if (i != 0) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
        channelsKt__DeprecatedKt$consumeEach$1 = new ChannelsKt__DeprecatedKt$consumeEach$1(continuation);
        Object obj2 = channelsKt__DeprecatedKt$consumeEach$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$consumeEach$1.label;
    }

    public static final Function1<Throwable, Unit> consumesAll(final ReceiveChannel<?>... receiveChannelArr) {
        return new Function1() { // from class: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit consumesAll$lambda$0$ChannelsKt__DeprecatedKt;
                consumesAll$lambda$0$ChannelsKt__DeprecatedKt = ChannelsKt__DeprecatedKt.consumesAll$lambda$0$ChannelsKt__DeprecatedKt(receiveChannelArr, (Throwable) obj);
                return consumesAll$lambda$0$ChannelsKt__DeprecatedKt;
            }
        };
    }

    public static final Unit consumesAll$lambda$0$ChannelsKt__DeprecatedKt(ReceiveChannel[] receiveChannelArr, Throwable th) {
        Throwable th2 = null;
        for (ReceiveChannel receiveChannel : receiveChannelArr) {
            try {
                ChannelsKt.cancelConsumed(receiveChannel, th);
            } catch (Throwable th3) {
                if (th2 == null) {
                    th2 = th3;
                } else {
                    ExceptionsKt.addSuppressed(th2, th3);
                }
            }
        }
        if (th2 != null) {
            throw th2;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ad A[Catch: all -> 0x005b, TRY_LEAVE, TryCatch #2 {all -> 0x005b, blocks: (B:65:0x0047, B:79:0x00a5, B:81:0x00ad, B:87:0x00be, B:88:0x00d8), top: B:103:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00be A[Catch: all -> 0x005b, TRY_ENTER, TryCatch #2 {all -> 0x005b, blocks: (B:65:0x0047, B:79:0x00a5, B:81:0x00ad, B:87:0x00be, B:88:0x00d8), top: B:103:0x0047 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x009d -> B:79:0x00a5). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object elementAt(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        ChannelsKt__DeprecatedKt$elementAt$1 channelsKt__DeprecatedKt$elementAt$1;
        int i2;
        ReceiveChannel receiveChannel2;
        ChannelIterator it;
        ChannelsKt__DeprecatedKt$elementAt$1 channelsKt__DeprecatedKt$elementAt$12;
        int i3;
        int i4;
        Throwable th;
        ReceiveChannel receiveChannel3;
        ReceiveChannel receiveChannel4;
        int i5;
        int i6;
        ReceiveChannel receiveChannel5;
        Throwable th2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$elementAt$1) {
            channelsKt__DeprecatedKt$elementAt$1 = (ChannelsKt__DeprecatedKt$elementAt$1) continuation;
            if ((channelsKt__DeprecatedKt$elementAt$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$elementAt$1.label -= Integer.MIN_VALUE;
                Object obj = channelsKt__DeprecatedKt$elementAt$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = channelsKt__DeprecatedKt$elementAt$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        if (i < 0) {
                            throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + i + '.');
                        }
                        it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$elementAt$12 = channelsKt__DeprecatedKt$elementAt$1;
                        i3 = 0;
                        i4 = 0;
                        th = null;
                        receiveChannel3 = receiveChannel;
                        receiveChannel4 = receiveChannel3;
                        i5 = i;
                        i6 = 0;
                        receiveChannel5 = receiveChannel4;
                        channelsKt__DeprecatedKt$elementAt$12.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                        channelsKt__DeprecatedKt$elementAt$12.L$1 = receiveChannel3;
                        channelsKt__DeprecatedKt$elementAt$12.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                        channelsKt__DeprecatedKt$elementAt$12.L$3 = it;
                        channelsKt__DeprecatedKt$elementAt$12.I$0 = i5;
                        channelsKt__DeprecatedKt$elementAt$12.I$1 = i4;
                        channelsKt__DeprecatedKt$elementAt$12.I$2 = i3;
                        channelsKt__DeprecatedKt$elementAt$12.I$3 = i6;
                        channelsKt__DeprecatedKt$elementAt$12.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$elementAt$12);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        receiveChannel2 = receiveChannel;
                        th2 = th;
                        throw th2;
                    }
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i7 = channelsKt__DeprecatedKt$elementAt$1.I$3;
                    int i8 = channelsKt__DeprecatedKt$elementAt$1.I$2;
                    int i9 = channelsKt__DeprecatedKt$elementAt$1.I$1;
                    int i10 = channelsKt__DeprecatedKt$elementAt$1.I$0;
                    ChannelIterator channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$elementAt$1.L$3;
                    ReceiveChannel receiveChannel6 = (ReceiveChannel) channelsKt__DeprecatedKt$elementAt$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$elementAt$1.L$1;
                    ReceiveChannel receiveChannel7 = (ReceiveChannel) channelsKt__DeprecatedKt$elementAt$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        channelsKt__DeprecatedKt$elementAt$12 = channelsKt__DeprecatedKt$elementAt$1;
                        receiveChannel4 = receiveChannel6;
                        i4 = i9;
                        i3 = i8;
                        i5 = i10;
                        th = null;
                        ChannelIterator channelIterator2 = channelIterator;
                        if (!((Boolean) obj).booleanValue()) {
                            Object next = channelIterator2.next();
                            int i11 = i7 + 1;
                            if (i5 != i7) {
                                receiveChannel3 = receiveChannel2;
                                receiveChannel5 = receiveChannel7;
                                it = channelIterator2;
                                i6 = i11;
                                try {
                                    channelsKt__DeprecatedKt$elementAt$12.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                                    channelsKt__DeprecatedKt$elementAt$12.L$1 = receiveChannel3;
                                    channelsKt__DeprecatedKt$elementAt$12.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                                    channelsKt__DeprecatedKt$elementAt$12.L$3 = it;
                                    channelsKt__DeprecatedKt$elementAt$12.I$0 = i5;
                                    channelsKt__DeprecatedKt$elementAt$12.I$1 = i4;
                                    channelsKt__DeprecatedKt$elementAt$12.I$2 = i3;
                                    channelsKt__DeprecatedKt$elementAt$12.I$3 = i6;
                                    channelsKt__DeprecatedKt$elementAt$12.label = 1;
                                    hasNext = it.hasNext(channelsKt__DeprecatedKt$elementAt$12);
                                    if (hasNext != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    receiveChannel7 = receiveChannel5;
                                    i7 = i6;
                                    channelIterator2 = it;
                                    receiveChannel2 = receiveChannel3;
                                    obj = hasNext;
                                    if (!((Boolean) obj).booleanValue()) {
                                        throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + i5 + '.');
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    receiveChannel2 = receiveChannel3;
                                    th2 = th;
                                    try {
                                        throw th2;
                                    } catch (Throwable th5) {
                                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                                        throw th5;
                                    }
                                }
                            } else {
                                ChannelsKt.cancelConsumed(receiveChannel2, th);
                                return next;
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        th2 = th;
                        throw th2;
                    }
                }
            }
        }
        channelsKt__DeprecatedKt$elementAt$1 = new ChannelsKt__DeprecatedKt$elementAt$1(continuation);
        Object obj2 = channelsKt__DeprecatedKt$elementAt$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = channelsKt__DeprecatedKt$elementAt$1.label;
        if (i2 != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x008c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x009c A[Catch: all -> 0x00b2, TRY_LEAVE, TryCatch #0 {all -> 0x00b2, blocks: (B:82:0x0094, B:84:0x009c, B:78:0x006c), top: B:100:0x0094 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ae  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x008d -> B:100:0x0094). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object elementAtOrNull(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        ChannelsKt__DeprecatedKt$elementAtOrNull$1 channelsKt__DeprecatedKt$elementAtOrNull$1;
        int i2;
        ReceiveChannel receiveChannel2;
        Throwable th;
        int i3;
        ChannelIterator it;
        ChannelsKt__DeprecatedKt$elementAtOrNull$1 channelsKt__DeprecatedKt$elementAtOrNull$12;
        int i4;
        int i5;
        Throwable th2;
        ReceiveChannel receiveChannel3;
        int i6;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__DeprecatedKt$elementAtOrNull$1) {
                channelsKt__DeprecatedKt$elementAtOrNull$1 = (ChannelsKt__DeprecatedKt$elementAtOrNull$1) continuation;
                if ((channelsKt__DeprecatedKt$elementAtOrNull$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__DeprecatedKt$elementAtOrNull$1.label -= Integer.MIN_VALUE;
                    Object obj = channelsKt__DeprecatedKt$elementAtOrNull$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i2 = channelsKt__DeprecatedKt$elementAtOrNull$1.label;
                    if (i2 != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (i >= 0) {
                            try {
                                i3 = 0;
                                it = receiveChannel.iterator();
                                channelsKt__DeprecatedKt$elementAtOrNull$12 = channelsKt__DeprecatedKt$elementAtOrNull$1;
                                i4 = 0;
                                i5 = 0;
                                th2 = null;
                                receiveChannel3 = receiveChannel;
                                i6 = i;
                                receiveChannel2 = receiveChannel3;
                                channelsKt__DeprecatedKt$elementAtOrNull$12.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                                channelsKt__DeprecatedKt$elementAtOrNull$12.L$1 = receiveChannel2;
                                channelsKt__DeprecatedKt$elementAtOrNull$12.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                                channelsKt__DeprecatedKt$elementAtOrNull$12.L$3 = it;
                                channelsKt__DeprecatedKt$elementAtOrNull$12.I$0 = i6;
                                channelsKt__DeprecatedKt$elementAtOrNull$12.I$1 = i5;
                                channelsKt__DeprecatedKt$elementAtOrNull$12.I$2 = i4;
                                channelsKt__DeprecatedKt$elementAtOrNull$12.I$3 = i3;
                                channelsKt__DeprecatedKt$elementAtOrNull$12.label = 1;
                                hasNext = it.hasNext(channelsKt__DeprecatedKt$elementAtOrNull$12);
                                if (hasNext != coroutine_suspended) {
                                }
                            } catch (Throwable th3) {
                                receiveChannel2 = receiveChannel;
                                th = th3;
                            }
                        } else {
                            ChannelsKt.cancelConsumed(receiveChannel, null);
                            return null;
                        }
                    } else if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        int i7 = channelsKt__DeprecatedKt$elementAtOrNull$1.I$3;
                        int i8 = channelsKt__DeprecatedKt$elementAtOrNull$1.I$2;
                        int i9 = channelsKt__DeprecatedKt$elementAtOrNull$1.I$1;
                        int i10 = channelsKt__DeprecatedKt$elementAtOrNull$1.I$0;
                        ChannelIterator channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$elementAtOrNull$1.L$3;
                        ReceiveChannel receiveChannel4 = (ReceiveChannel) channelsKt__DeprecatedKt$elementAtOrNull$1.L$2;
                        ReceiveChannel receiveChannel5 = (ReceiveChannel) channelsKt__DeprecatedKt$elementAtOrNull$1.L$1;
                        ReceiveChannel receiveChannel6 = (ReceiveChannel) channelsKt__DeprecatedKt$elementAtOrNull$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            i4 = i8;
                            receiveChannel2 = receiveChannel5;
                            it = channelIterator;
                            channelsKt__DeprecatedKt$elementAtOrNull$12 = channelsKt__DeprecatedKt$elementAtOrNull$1;
                            i6 = i10;
                            Throwable th4 = null;
                            try {
                                if (!((Boolean) obj).booleanValue()) {
                                    Object next = it.next();
                                    int i11 = i7 + 1;
                                    if (i6 == i7) {
                                        ChannelsKt.cancelConsumed(receiveChannel2, th4);
                                        return next;
                                    }
                                    receiveChannel3 = receiveChannel4;
                                    receiveChannel = receiveChannel6;
                                    th2 = th4;
                                    i5 = i9;
                                    i3 = i11;
                                    channelsKt__DeprecatedKt$elementAtOrNull$12.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                                    channelsKt__DeprecatedKt$elementAtOrNull$12.L$1 = receiveChannel2;
                                    channelsKt__DeprecatedKt$elementAtOrNull$12.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                                    channelsKt__DeprecatedKt$elementAtOrNull$12.L$3 = it;
                                    channelsKt__DeprecatedKt$elementAtOrNull$12.I$0 = i6;
                                    channelsKt__DeprecatedKt$elementAtOrNull$12.I$1 = i5;
                                    channelsKt__DeprecatedKt$elementAtOrNull$12.I$2 = i4;
                                    channelsKt__DeprecatedKt$elementAtOrNull$12.I$3 = i3;
                                    channelsKt__DeprecatedKt$elementAtOrNull$12.label = 1;
                                    hasNext = it.hasNext(channelsKt__DeprecatedKt$elementAtOrNull$12);
                                    if (hasNext != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    Throwable th5 = th2;
                                    receiveChannel6 = receiveChannel;
                                    i7 = i3;
                                    i9 = i5;
                                    receiveChannel4 = receiveChannel3;
                                    obj = hasNext;
                                    th4 = th5;
                                    if (!((Boolean) obj).booleanValue()) {
                                        ChannelsKt.cancelConsumed(receiveChannel2, th4);
                                        return null;
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            receiveChannel2 = receiveChannel5;
                        }
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th8) {
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            throw th8;
        }
        channelsKt__DeprecatedKt$elementAtOrNull$1 = new ChannelsKt__DeprecatedKt$elementAtOrNull$1(continuation);
        Object obj2 = channelsKt__DeprecatedKt$elementAtOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = channelsKt__DeprecatedKt$elementAtOrNull$1.label;
        if (i2 != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0078 A[Catch: all -> 0x003e, TRY_LEAVE, TryCatch #2 {all -> 0x003e, blocks: (B:53:0x003a, B:64:0x0070, B:66:0x0078, B:69:0x0081, B:70:0x0088), top: B:81:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0081 A[Catch: all -> 0x003e, TRY_ENTER, TryCatch #2 {all -> 0x003e, blocks: (B:53:0x003a, B:64:0x0070, B:66:0x0078, B:69:0x0081, B:70:0x0088), top: B:81:0x003a }] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object first(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$first$1 channelsKt__DeprecatedKt$first$1;
        Object obj;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator channelIterator;
        if (continuation instanceof ChannelsKt__DeprecatedKt$first$1) {
            channelsKt__DeprecatedKt$first$1 = (ChannelsKt__DeprecatedKt$first$1) continuation;
            if ((channelsKt__DeprecatedKt$first$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$first$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$first$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$first$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$first$1.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__DeprecatedKt$first$1.L$1 = receiveChannel;
                        channelsKt__DeprecatedKt$first$1.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__DeprecatedKt$first$1.L$3 = it;
                        channelsKt__DeprecatedKt$first$1.I$0 = 0;
                        channelsKt__DeprecatedKt$first$1.I$1 = 0;
                        channelsKt__DeprecatedKt$first$1.label = 1;
                        Object hasNext = it.hasNext(channelsKt__DeprecatedKt$first$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext;
                    } catch (Throwable th2) {
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i2 = channelsKt__DeprecatedKt$first$1.I$1;
                    int i3 = channelsKt__DeprecatedKt$first$1.I$0;
                    channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$first$1.L$3;
                    ReceiveChannel receiveChannel3 = (ReceiveChannel) channelsKt__DeprecatedKt$first$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$first$1.L$1;
                    ReceiveChannel receiveChannel4 = (ReceiveChannel) channelsKt__DeprecatedKt$first$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th4;
                        }
                    }
                }
                if (((Boolean) obj).booleanValue()) {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }
                Object next = channelIterator.next();
                ChannelsKt.cancelConsumed(receiveChannel2, null);
                return next;
            }
        }
        channelsKt__DeprecatedKt$first$1 = new ChannelsKt__DeprecatedKt$first$1(continuation);
        obj = channelsKt__DeprecatedKt$first$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$first$1.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x007d A[Catch: all -> 0x003e, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x003e, blocks: (B:55:0x003a, B:66:0x0070, B:71:0x007d), top: B:84:0x003a }] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object firstOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$firstOrNull$1 channelsKt__DeprecatedKt$firstOrNull$1;
        Object obj;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator channelIterator;
        if (continuation instanceof ChannelsKt__DeprecatedKt$firstOrNull$1) {
            channelsKt__DeprecatedKt$firstOrNull$1 = (ChannelsKt__DeprecatedKt$firstOrNull$1) continuation;
            if ((channelsKt__DeprecatedKt$firstOrNull$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$firstOrNull$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$firstOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$firstOrNull$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$firstOrNull$1.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__DeprecatedKt$firstOrNull$1.L$1 = receiveChannel;
                        channelsKt__DeprecatedKt$firstOrNull$1.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__DeprecatedKt$firstOrNull$1.L$3 = it;
                        channelsKt__DeprecatedKt$firstOrNull$1.I$0 = 0;
                        channelsKt__DeprecatedKt$firstOrNull$1.I$1 = 0;
                        channelsKt__DeprecatedKt$firstOrNull$1.label = 1;
                        Object hasNext = it.hasNext(channelsKt__DeprecatedKt$firstOrNull$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext;
                    } catch (Throwable th2) {
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i2 = channelsKt__DeprecatedKt$firstOrNull$1.I$1;
                    int i3 = channelsKt__DeprecatedKt$firstOrNull$1.I$0;
                    channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$firstOrNull$1.L$3;
                    ReceiveChannel receiveChannel3 = (ReceiveChannel) channelsKt__DeprecatedKt$firstOrNull$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$firstOrNull$1.L$1;
                    ReceiveChannel receiveChannel4 = (ReceiveChannel) channelsKt__DeprecatedKt$firstOrNull$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th4;
                        }
                    }
                }
                if (!((Boolean) obj).booleanValue()) {
                    Object next = channelIterator.next();
                    ChannelsKt.cancelConsumed(receiveChannel2, null);
                    return next;
                }
                ChannelsKt.cancelConsumed(receiveChannel2, null);
                return null;
            }
        }
        channelsKt__DeprecatedKt$firstOrNull$1 = new ChannelsKt__DeprecatedKt$firstOrNull$1(continuation);
        obj = channelsKt__DeprecatedKt$firstOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$firstOrNull$1.label;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00b3 A[Catch: all -> 0x0058, TryCatch #1 {all -> 0x0058, blocks: (B:63:0x0047, B:76:0x00ab, B:78:0x00b3, B:80:0x00bd, B:83:0x00c7, B:84:0x00d2), top: B:97:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00d2 A[Catch: all -> 0x0058, TRY_LEAVE, TryCatch #1 {all -> 0x0058, blocks: (B:63:0x0047, B:76:0x00ab, B:78:0x00b3, B:80:0x00bd, B:83:0x00c7, B:84:0x00d2), top: B:97:0x0047 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x00a4 -> B:76:0x00ab). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object indexOf(ReceiveChannel receiveChannel, Object obj, Continuation continuation) {
        ChannelsKt__DeprecatedKt$indexOf$1 channelsKt__DeprecatedKt$indexOf$1;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        int i2;
        Ref.IntRef intRef;
        ChannelsKt__DeprecatedKt$indexOf$1 channelsKt__DeprecatedKt$indexOf$12;
        ChannelIterator it;
        Throwable th2;
        int i3;
        int i4;
        ReceiveChannel receiveChannel3;
        Object obj2;
        ReceiveChannel receiveChannel4;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__DeprecatedKt$indexOf$1) {
                channelsKt__DeprecatedKt$indexOf$1 = (ChannelsKt__DeprecatedKt$indexOf$1) continuation;
                if ((channelsKt__DeprecatedKt$indexOf$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__DeprecatedKt$indexOf$1.label -= Integer.MIN_VALUE;
                    Object obj3 = channelsKt__DeprecatedKt$indexOf$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__DeprecatedKt$indexOf$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj3);
                        try {
                            i2 = 0;
                            intRef = new Ref.IntRef();
                            channelsKt__DeprecatedKt$indexOf$12 = channelsKt__DeprecatedKt$indexOf$1;
                            it = receiveChannel.iterator();
                            th2 = null;
                            i3 = 0;
                            i4 = 0;
                            receiveChannel2 = receiveChannel;
                            receiveChannel3 = receiveChannel2;
                            obj2 = obj;
                            receiveChannel4 = receiveChannel3;
                            channelsKt__DeprecatedKt$indexOf$12.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                            channelsKt__DeprecatedKt$indexOf$12.L$1 = obj2;
                            channelsKt__DeprecatedKt$indexOf$12.L$2 = intRef;
                            channelsKt__DeprecatedKt$indexOf$12.L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                            channelsKt__DeprecatedKt$indexOf$12.L$4 = receiveChannel2;
                            channelsKt__DeprecatedKt$indexOf$12.L$5 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                            channelsKt__DeprecatedKt$indexOf$12.L$6 = it;
                            channelsKt__DeprecatedKt$indexOf$12.I$0 = i4;
                            channelsKt__DeprecatedKt$indexOf$12.I$1 = i3;
                            channelsKt__DeprecatedKt$indexOf$12.I$2 = i2;
                            channelsKt__DeprecatedKt$indexOf$12.label = 1;
                            hasNext = it.hasNext(channelsKt__DeprecatedKt$indexOf$12);
                            if (hasNext != coroutine_suspended) {
                            }
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        int i5 = channelsKt__DeprecatedKt$indexOf$1.I$2;
                        int i6 = channelsKt__DeprecatedKt$indexOf$1.I$1;
                        int i7 = channelsKt__DeprecatedKt$indexOf$1.I$0;
                        ChannelIterator channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$indexOf$1.L$6;
                        ReceiveChannel receiveChannel5 = (ReceiveChannel) channelsKt__DeprecatedKt$indexOf$1.L$5;
                        ReceiveChannel receiveChannel6 = (ReceiveChannel) channelsKt__DeprecatedKt$indexOf$1.L$4;
                        ReceiveChannel receiveChannel7 = (ReceiveChannel) channelsKt__DeprecatedKt$indexOf$1.L$3;
                        Ref.IntRef intRef2 = (Ref.IntRef) channelsKt__DeprecatedKt$indexOf$1.L$2;
                        Object obj4 = channelsKt__DeprecatedKt$indexOf$1.L$1;
                        ReceiveChannel receiveChannel8 = (ReceiveChannel) channelsKt__DeprecatedKt$indexOf$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj3);
                            i2 = i5;
                            receiveChannel = receiveChannel8;
                            Ref.IntRef intRef3 = intRef2;
                            Throwable th4 = null;
                            i3 = i6;
                            receiveChannel4 = receiveChannel7;
                            int i8 = i7;
                            obj2 = obj4;
                            ChannelIterator channelIterator2 = channelIterator;
                            channelsKt__DeprecatedKt$indexOf$12 = channelsKt__DeprecatedKt$indexOf$1;
                            receiveChannel3 = receiveChannel5;
                            if (((Boolean) obj3).booleanValue()) {
                                if (Intrinsics.areEqual(obj2, channelIterator2.next())) {
                                    Integer boxInt = Boxing.boxInt(intRef3.element);
                                    ChannelsKt.cancelConsumed(receiveChannel6, th4);
                                    return boxInt;
                                }
                                intRef3.element++;
                                receiveChannel2 = receiveChannel6;
                                i4 = i8;
                                th2 = th4;
                                it = channelIterator2;
                                intRef = intRef3;
                                try {
                                    channelsKt__DeprecatedKt$indexOf$12.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                                    channelsKt__DeprecatedKt$indexOf$12.L$1 = obj2;
                                    channelsKt__DeprecatedKt$indexOf$12.L$2 = intRef;
                                    channelsKt__DeprecatedKt$indexOf$12.L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                                    channelsKt__DeprecatedKt$indexOf$12.L$4 = receiveChannel2;
                                    channelsKt__DeprecatedKt$indexOf$12.L$5 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                                    channelsKt__DeprecatedKt$indexOf$12.L$6 = it;
                                    channelsKt__DeprecatedKt$indexOf$12.I$0 = i4;
                                    channelsKt__DeprecatedKt$indexOf$12.I$1 = i3;
                                    channelsKt__DeprecatedKt$indexOf$12.I$2 = i2;
                                    channelsKt__DeprecatedKt$indexOf$12.label = 1;
                                    hasNext = it.hasNext(channelsKt__DeprecatedKt$indexOf$12);
                                    if (hasNext != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    int i9 = i4;
                                    receiveChannel6 = receiveChannel2;
                                    obj3 = hasNext;
                                    intRef3 = intRef;
                                    channelIterator2 = it;
                                    th4 = th2;
                                    i8 = i9;
                                    if (((Boolean) obj3).booleanValue()) {
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                }
                            } else {
                                Unit unit = Unit.INSTANCE;
                                ChannelsKt.cancelConsumed(receiveChannel6, th4);
                                return Boxing.boxInt(-1);
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            receiveChannel2 = receiveChannel6;
                        }
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th7) {
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            throw th7;
        }
        channelsKt__DeprecatedKt$indexOf$1 = new ChannelsKt__DeprecatedKt$indexOf$1(continuation);
        Object obj32 = channelsKt__DeprecatedKt$indexOf$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$indexOf$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00eb A[Catch: all -> 0x0075, TRY_ENTER, TryCatch #1 {all -> 0x0075, blocks: (B:80:0x006c, B:89:0x00a2, B:91:0x00aa, B:103:0x00eb, B:104:0x00f2), top: B:113:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00aa A[Catch: all -> 0x0075, TRY_LEAVE, TryCatch #1 {all -> 0x0075, blocks: (B:80:0x006c, B:89:0x00a2, B:91:0x00aa, B:103:0x00eb, B:104:0x00f2), top: B:113:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00de A[Catch: all -> 0x00f3, TRY_LEAVE, TryCatch #0 {all -> 0x00f3, blocks: (B:97:0x00d6, B:99:0x00de, B:93:0x00b2, B:85:0x007b), top: B:111:0x007b }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:96:0x00d1 -> B:74:0x0046). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object last(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$last$1 channelsKt__DeprecatedKt$last$1;
        Object obj;
        int i;
        int i2;
        ReceiveChannel receiveChannel2;
        ReceiveChannel receiveChannel3;
        ChannelIterator channelIterator;
        int i3;
        Object next;
        ReceiveChannel receiveChannel4;
        ReceiveChannel receiveChannel5;
        ChannelIterator channelIterator2;
        Throwable th;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$last$1) {
            channelsKt__DeprecatedKt$last$1 = (ChannelsKt__DeprecatedKt$last$1) continuation;
            if ((channelsKt__DeprecatedKt$last$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$last$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$last$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$last$1.label;
                Throwable th2 = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$last$1.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__DeprecatedKt$last$1.L$1 = receiveChannel;
                        channelsKt__DeprecatedKt$last$1.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__DeprecatedKt$last$1.L$3 = it;
                        i2 = 0;
                        channelsKt__DeprecatedKt$last$1.I$0 = 0;
                        channelsKt__DeprecatedKt$last$1.I$1 = 0;
                        channelsKt__DeprecatedKt$last$1.label = 1;
                        Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$last$1);
                        if (hasNext2 != coroutine_suspended) {
                            receiveChannel2 = receiveChannel;
                            receiveChannel3 = receiveChannel2;
                            channelIterator = it;
                            obj = hasNext2;
                            i3 = 0;
                        }
                        return coroutine_suspended;
                    } catch (Throwable th3) {
                        receiveChannel3 = receiveChannel;
                        th = th3;
                    }
                } else {
                    if (i == 1) {
                        int i4 = channelsKt__DeprecatedKt$last$1.I$1;
                        int i5 = channelsKt__DeprecatedKt$last$1.I$0;
                        ChannelIterator channelIterator3 = (ChannelIterator) channelsKt__DeprecatedKt$last$1.L$3;
                        receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$last$1.L$2;
                        receiveChannel3 = (ReceiveChannel) channelsKt__DeprecatedKt$last$1.L$1;
                        ReceiveChannel receiveChannel6 = (ReceiveChannel) channelsKt__DeprecatedKt$last$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            i2 = i4;
                            receiveChannel = receiveChannel6;
                            channelIterator = channelIterator3;
                            i3 = i5;
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } else if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        int i6 = channelsKt__DeprecatedKt$last$1.I$1;
                        int i7 = channelsKt__DeprecatedKt$last$1.I$0;
                        Object obj2 = channelsKt__DeprecatedKt$last$1.L$4;
                        channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$last$1.L$3;
                        receiveChannel5 = (ReceiveChannel) channelsKt__DeprecatedKt$last$1.L$2;
                        ReceiveChannel receiveChannel7 = (ReceiveChannel) channelsKt__DeprecatedKt$last$1.L$1;
                        receiveChannel4 = (ReceiveChannel) channelsKt__DeprecatedKt$last$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            int i8 = i7;
                            i2 = i6;
                            receiveChannel = receiveChannel7;
                            ReceiveChannel receiveChannel8 = receiveChannel5;
                            ChannelIterator channelIterator4 = channelIterator2;
                            Throwable th5 = th2;
                            int i9 = i8;
                            if (!((Boolean) obj).booleanValue()) {
                                next = channelIterator4.next();
                                i3 = i9;
                                th2 = th5;
                                channelIterator2 = channelIterator4;
                                receiveChannel5 = receiveChannel8;
                                channelsKt__DeprecatedKt$last$1.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                                channelsKt__DeprecatedKt$last$1.L$1 = receiveChannel;
                                channelsKt__DeprecatedKt$last$1.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                                channelsKt__DeprecatedKt$last$1.L$3 = channelIterator2;
                                channelsKt__DeprecatedKt$last$1.L$4 = next;
                                channelsKt__DeprecatedKt$last$1.I$0 = i3;
                                channelsKt__DeprecatedKt$last$1.I$1 = i2;
                                channelsKt__DeprecatedKt$last$1.label = 2;
                                hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$last$1);
                                if (hasNext != coroutine_suspended) {
                                    i8 = i3;
                                    obj2 = next;
                                    obj = hasNext;
                                    ReceiveChannel receiveChannel82 = receiveChannel5;
                                    ChannelIterator channelIterator42 = channelIterator2;
                                    Throwable th52 = th2;
                                    int i92 = i8;
                                    if (!((Boolean) obj).booleanValue()) {
                                        ChannelsKt.cancelConsumed(receiveChannel, th52);
                                        return obj2;
                                    }
                                }
                                return coroutine_suspended;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            receiveChannel3 = receiveChannel7;
                        }
                    }
                    try {
                        throw th;
                    } catch (Throwable th7) {
                        ChannelsKt.cancelConsumed(receiveChannel3, th);
                        throw th7;
                    }
                }
                if (((Boolean) obj).booleanValue()) {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }
                next = channelIterator.next();
                receiveChannel4 = receiveChannel;
                receiveChannel = receiveChannel3;
                receiveChannel5 = receiveChannel2;
                channelIterator2 = channelIterator;
                channelsKt__DeprecatedKt$last$1.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                channelsKt__DeprecatedKt$last$1.L$1 = receiveChannel;
                channelsKt__DeprecatedKt$last$1.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                channelsKt__DeprecatedKt$last$1.L$3 = channelIterator2;
                channelsKt__DeprecatedKt$last$1.L$4 = next;
                channelsKt__DeprecatedKt$last$1.I$0 = i3;
                channelsKt__DeprecatedKt$last$1.I$1 = i2;
                channelsKt__DeprecatedKt$last$1.label = 2;
                hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$last$1);
                if (hasNext != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        }
        channelsKt__DeprecatedKt$last$1 = new ChannelsKt__DeprecatedKt$last$1(continuation);
        obj = channelsKt__DeprecatedKt$last$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$last$1.label;
        Throwable th22 = null;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d0 A[Catch: all -> 0x00f1, TryCatch #0 {all -> 0x00f1, blocks: (B:76:0x00c8, B:78:0x00d0, B:80:0x00da, B:81:0x00de, B:72:0x0098, B:82:0x00e5), top: B:94:0x00c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e5 A[Catch: all -> 0x00f1, TRY_LEAVE, TryCatch #0 {all -> 0x00f1, blocks: (B:76:0x00c8, B:78:0x00d0, B:80:0x00da, B:81:0x00de, B:72:0x0098, B:82:0x00e5), top: B:94:0x00c8 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x00c3 -> B:94:0x00c8). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object lastIndexOf(ReceiveChannel receiveChannel, Object obj, Continuation continuation) {
        ChannelsKt__DeprecatedKt$lastIndexOf$1 channelsKt__DeprecatedKt$lastIndexOf$1;
        int i;
        ReceiveChannel receiveChannel2;
        Ref.IntRef intRef;
        Ref.IntRef intRef2;
        Throwable th;
        ChannelIterator it;
        int i2;
        int i3;
        int i4;
        ReceiveChannel receiveChannel3;
        ReceiveChannel receiveChannel4;
        Object obj2;
        ChannelsKt__DeprecatedKt$lastIndexOf$1 channelsKt__DeprecatedKt$lastIndexOf$12;
        ReceiveChannel receiveChannel5;
        Throwable th2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$lastIndexOf$1) {
            channelsKt__DeprecatedKt$lastIndexOf$1 = (ChannelsKt__DeprecatedKt$lastIndexOf$1) continuation;
            if ((channelsKt__DeprecatedKt$lastIndexOf$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$lastIndexOf$1.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__DeprecatedKt$lastIndexOf$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$lastIndexOf$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    Ref.IntRef intRef3 = new Ref.IntRef();
                    intRef3.element = -1;
                    try {
                        intRef = intRef3;
                        intRef2 = new Ref.IntRef();
                        th = null;
                        it = receiveChannel.iterator();
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        receiveChannel3 = receiveChannel;
                        receiveChannel2 = receiveChannel3;
                        receiveChannel4 = receiveChannel2;
                        obj2 = obj;
                        channelsKt__DeprecatedKt$lastIndexOf$12 = channelsKt__DeprecatedKt$lastIndexOf$1;
                        receiveChannel5 = receiveChannel4;
                        channelsKt__DeprecatedKt$lastIndexOf$12.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                        channelsKt__DeprecatedKt$lastIndexOf$12.L$1 = obj2;
                        channelsKt__DeprecatedKt$lastIndexOf$12.L$2 = intRef;
                        channelsKt__DeprecatedKt$lastIndexOf$12.L$3 = intRef2;
                        channelsKt__DeprecatedKt$lastIndexOf$12.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                        channelsKt__DeprecatedKt$lastIndexOf$12.L$5 = receiveChannel2;
                        channelsKt__DeprecatedKt$lastIndexOf$12.L$6 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                        channelsKt__DeprecatedKt$lastIndexOf$12.L$7 = it;
                        channelsKt__DeprecatedKt$lastIndexOf$12.I$0 = i4;
                        channelsKt__DeprecatedKt$lastIndexOf$12.I$1 = i3;
                        channelsKt__DeprecatedKt$lastIndexOf$12.I$2 = i2;
                        channelsKt__DeprecatedKt$lastIndexOf$12.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$lastIndexOf$12);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        receiveChannel2 = receiveChannel;
                        th2 = th;
                        throw th2;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i5 = channelsKt__DeprecatedKt$lastIndexOf$1.I$2;
                    int i6 = channelsKt__DeprecatedKt$lastIndexOf$1.I$1;
                    int i7 = channelsKt__DeprecatedKt$lastIndexOf$1.I$0;
                    ChannelIterator channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$lastIndexOf$1.L$7;
                    ReceiveChannel receiveChannel6 = (ReceiveChannel) channelsKt__DeprecatedKt$lastIndexOf$1.L$6;
                    ReceiveChannel receiveChannel7 = (ReceiveChannel) channelsKt__DeprecatedKt$lastIndexOf$1.L$5;
                    ReceiveChannel receiveChannel8 = (ReceiveChannel) channelsKt__DeprecatedKt$lastIndexOf$1.L$4;
                    Ref.IntRef intRef4 = (Ref.IntRef) channelsKt__DeprecatedKt$lastIndexOf$1.L$3;
                    Ref.IntRef intRef5 = (Ref.IntRef) channelsKt__DeprecatedKt$lastIndexOf$1.L$2;
                    Object obj4 = channelsKt__DeprecatedKt$lastIndexOf$1.L$1;
                    ReceiveChannel receiveChannel9 = (ReceiveChannel) channelsKt__DeprecatedKt$lastIndexOf$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        channelsKt__DeprecatedKt$lastIndexOf$12 = channelsKt__DeprecatedKt$lastIndexOf$1;
                        receiveChannel5 = receiveChannel8;
                        i4 = i7;
                        i2 = i5;
                        receiveChannel2 = receiveChannel7;
                        i3 = i6;
                        obj2 = obj4;
                        intRef = intRef5;
                        intRef2 = intRef4;
                        it = channelIterator;
                        th = null;
                        receiveChannel4 = receiveChannel6;
                        try {
                            if (((Boolean) obj3).booleanValue()) {
                                if (Intrinsics.areEqual(obj2, it.next())) {
                                    intRef.element = intRef2.element;
                                }
                                intRef2.element++;
                                receiveChannel3 = receiveChannel9;
                                channelsKt__DeprecatedKt$lastIndexOf$12.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                                channelsKt__DeprecatedKt$lastIndexOf$12.L$1 = obj2;
                                channelsKt__DeprecatedKt$lastIndexOf$12.L$2 = intRef;
                                channelsKt__DeprecatedKt$lastIndexOf$12.L$3 = intRef2;
                                channelsKt__DeprecatedKt$lastIndexOf$12.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                                channelsKt__DeprecatedKt$lastIndexOf$12.L$5 = receiveChannel2;
                                channelsKt__DeprecatedKt$lastIndexOf$12.L$6 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                                channelsKt__DeprecatedKt$lastIndexOf$12.L$7 = it;
                                channelsKt__DeprecatedKt$lastIndexOf$12.I$0 = i4;
                                channelsKt__DeprecatedKt$lastIndexOf$12.I$1 = i3;
                                channelsKt__DeprecatedKt$lastIndexOf$12.I$2 = i2;
                                channelsKt__DeprecatedKt$lastIndexOf$12.label = 1;
                                hasNext = it.hasNext(channelsKt__DeprecatedKt$lastIndexOf$12);
                                if (hasNext != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                receiveChannel9 = receiveChannel3;
                                obj3 = hasNext;
                                if (((Boolean) obj3).booleanValue()) {
                                }
                            } else {
                                Unit unit = Unit.INSTANCE;
                                ChannelsKt.cancelConsumed(receiveChannel2, th);
                                return Boxing.boxInt(intRef.element);
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            th2 = th;
                            try {
                                throw th2;
                            } catch (Throwable th5) {
                                ChannelsKt.cancelConsumed(receiveChannel2, th2);
                                throw th5;
                            }
                        }
                    } catch (Throwable th6) {
                        th2 = th6;
                        receiveChannel2 = receiveChannel7;
                        throw th2;
                    }
                }
            }
        }
        channelsKt__DeprecatedKt$lastIndexOf$1 = new ChannelsKt__DeprecatedKt$lastIndexOf$1(continuation);
        Object obj32 = channelsKt__DeprecatedKt$lastIndexOf$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$lastIndexOf$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00e2 A[Catch: all -> 0x00ef, TRY_LEAVE, TryCatch #3 {all -> 0x00ef, blocks: (B:98:0x00da, B:100:0x00e2, B:94:0x00b6, B:89:0x00a2, B:93:0x00ae, B:85:0x007b), top: B:116:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00ae A[Catch: all -> 0x00ef, TRY_ENTER, TryCatch #3 {all -> 0x00ef, blocks: (B:98:0x00da, B:100:0x00e2, B:94:0x00b6, B:89:0x00a2, B:93:0x00ae, B:85:0x007b), top: B:116:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00d5  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x00d5 -> B:74:0x0046). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object lastOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$lastOrNull$1 channelsKt__DeprecatedKt$lastOrNull$1;
        Object obj;
        int i;
        int i2;
        ReceiveChannel receiveChannel2;
        ReceiveChannel receiveChannel3;
        ChannelIterator channelIterator;
        int i3;
        Object next;
        ReceiveChannel receiveChannel4;
        ChannelIterator channelIterator2;
        ReceiveChannel receiveChannel5;
        Throwable th;
        ReceiveChannel receiveChannel6;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$lastOrNull$1) {
            channelsKt__DeprecatedKt$lastOrNull$1 = (ChannelsKt__DeprecatedKt$lastOrNull$1) continuation;
            if ((channelsKt__DeprecatedKt$lastOrNull$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$lastOrNull$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$lastOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$lastOrNull$1.label;
                Throwable th2 = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$lastOrNull$1.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__DeprecatedKt$lastOrNull$1.L$1 = receiveChannel;
                        channelsKt__DeprecatedKt$lastOrNull$1.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__DeprecatedKt$lastOrNull$1.L$3 = it;
                        i2 = 0;
                        channelsKt__DeprecatedKt$lastOrNull$1.I$0 = 0;
                        channelsKt__DeprecatedKt$lastOrNull$1.I$1 = 0;
                        channelsKt__DeprecatedKt$lastOrNull$1.label = 1;
                        Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$lastOrNull$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        receiveChannel3 = receiveChannel2;
                        channelIterator = it;
                        obj = hasNext2;
                        i3 = 0;
                    } catch (Throwable th3) {
                        receiveChannel6 = receiveChannel;
                        th = th3;
                    }
                } else {
                    if (i == 1) {
                        int i4 = channelsKt__DeprecatedKt$lastOrNull$1.I$1;
                        int i5 = channelsKt__DeprecatedKt$lastOrNull$1.I$0;
                        ChannelIterator channelIterator3 = (ChannelIterator) channelsKt__DeprecatedKt$lastOrNull$1.L$3;
                        receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$lastOrNull$1.L$2;
                        receiveChannel6 = (ReceiveChannel) channelsKt__DeprecatedKt$lastOrNull$1.L$1;
                        receiveChannel3 = (ReceiveChannel) channelsKt__DeprecatedKt$lastOrNull$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            i2 = i4;
                            receiveChannel = receiveChannel6;
                            channelIterator = channelIterator3;
                            i3 = i5;
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } else if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        int i6 = channelsKt__DeprecatedKt$lastOrNull$1.I$1;
                        int i7 = channelsKt__DeprecatedKt$lastOrNull$1.I$0;
                        Object obj2 = channelsKt__DeprecatedKt$lastOrNull$1.L$4;
                        channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$lastOrNull$1.L$3;
                        receiveChannel4 = (ReceiveChannel) channelsKt__DeprecatedKt$lastOrNull$1.L$2;
                        ReceiveChannel receiveChannel7 = (ReceiveChannel) channelsKt__DeprecatedKt$lastOrNull$1.L$1;
                        receiveChannel5 = (ReceiveChannel) channelsKt__DeprecatedKt$lastOrNull$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            int i8 = i7;
                            i2 = i6;
                            receiveChannel = receiveChannel7;
                            ReceiveChannel receiveChannel8 = receiveChannel4;
                            ChannelIterator channelIterator4 = channelIterator2;
                            Throwable th5 = th2;
                            int i9 = i8;
                            if (!((Boolean) obj).booleanValue()) {
                                next = channelIterator4.next();
                                i3 = i9;
                                th2 = th5;
                                channelIterator2 = channelIterator4;
                                receiveChannel4 = receiveChannel8;
                                channelsKt__DeprecatedKt$lastOrNull$1.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                                channelsKt__DeprecatedKt$lastOrNull$1.L$1 = receiveChannel;
                                channelsKt__DeprecatedKt$lastOrNull$1.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                                channelsKt__DeprecatedKt$lastOrNull$1.L$3 = channelIterator2;
                                channelsKt__DeprecatedKt$lastOrNull$1.L$4 = next;
                                channelsKt__DeprecatedKt$lastOrNull$1.I$0 = i3;
                                channelsKt__DeprecatedKt$lastOrNull$1.I$1 = i2;
                                channelsKt__DeprecatedKt$lastOrNull$1.label = 2;
                                hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$lastOrNull$1);
                                if (hasNext != coroutine_suspended) {
                                    i8 = i3;
                                    obj2 = next;
                                    obj = hasNext;
                                    ReceiveChannel receiveChannel82 = receiveChannel4;
                                    ChannelIterator channelIterator42 = channelIterator2;
                                    Throwable th52 = th2;
                                    int i92 = i8;
                                    if (!((Boolean) obj).booleanValue()) {
                                        ChannelsKt.cancelConsumed(receiveChannel, th52);
                                        return obj2;
                                    }
                                }
                                return coroutine_suspended;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            receiveChannel6 = receiveChannel7;
                        }
                    }
                    try {
                        throw th;
                    } catch (Throwable th7) {
                        ChannelsKt.cancelConsumed(receiveChannel6, th);
                        throw th7;
                    }
                }
                if (!((Boolean) obj).booleanValue()) {
                    next = channelIterator.next();
                    ChannelIterator channelIterator5 = channelIterator;
                    receiveChannel4 = receiveChannel2;
                    channelIterator2 = channelIterator5;
                    receiveChannel5 = receiveChannel3;
                    channelsKt__DeprecatedKt$lastOrNull$1.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                    channelsKt__DeprecatedKt$lastOrNull$1.L$1 = receiveChannel;
                    channelsKt__DeprecatedKt$lastOrNull$1.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                    channelsKt__DeprecatedKt$lastOrNull$1.L$3 = channelIterator2;
                    channelsKt__DeprecatedKt$lastOrNull$1.L$4 = next;
                    channelsKt__DeprecatedKt$lastOrNull$1.I$0 = i3;
                    channelsKt__DeprecatedKt$lastOrNull$1.I$1 = i2;
                    channelsKt__DeprecatedKt$lastOrNull$1.label = 2;
                    hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$lastOrNull$1);
                    if (hasNext != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                ChannelsKt.cancelConsumed(receiveChannel, null);
                return null;
            }
        }
        channelsKt__DeprecatedKt$lastOrNull$1 = new ChannelsKt__DeprecatedKt$lastOrNull$1(continuation);
        obj = channelsKt__DeprecatedKt$lastOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$lastOrNull$1.label;
        Throwable th22 = null;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00a2 A[Catch: all -> 0x006d, TRY_LEAVE, TryCatch #2 {all -> 0x006d, blocks: (B:76:0x0064, B:85:0x009a, B:87:0x00a2, B:97:0x00e2, B:98:0x00e9), top: B:109:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00da A[Catch: all -> 0x0044, TRY_ENTER, TryCatch #0 {all -> 0x0044, blocks: (B:69:0x003f, B:91:0x00cd, B:95:0x00da, B:96:0x00e1), top: B:105:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00e2 A[Catch: all -> 0x006d, TRY_ENTER, TryCatch #2 {all -> 0x006d, blocks: (B:76:0x0064, B:85:0x009a, B:87:0x00a2, B:97:0x00e2, B:98:0x00e9), top: B:109:0x0064 }] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object single(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$single$1 channelsKt__DeprecatedKt$single$1;
        Object obj;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        int i2;
        ReceiveChannel receiveChannel3;
        ChannelIterator channelIterator;
        int i3;
        Object obj2;
        ReceiveChannel receiveChannel4;
        if (continuation instanceof ChannelsKt__DeprecatedKt$single$1) {
            channelsKt__DeprecatedKt$single$1 = (ChannelsKt__DeprecatedKt$single$1) continuation;
            if ((channelsKt__DeprecatedKt$single$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$single$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$single$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$single$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$single$1.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__DeprecatedKt$single$1.L$1 = receiveChannel;
                        channelsKt__DeprecatedKt$single$1.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__DeprecatedKt$single$1.L$3 = it;
                        i2 = 0;
                        channelsKt__DeprecatedKt$single$1.I$0 = 0;
                        channelsKt__DeprecatedKt$single$1.I$1 = 0;
                        channelsKt__DeprecatedKt$single$1.label = 1;
                        Object hasNext = it.hasNext(channelsKt__DeprecatedKt$single$1);
                        if (hasNext != coroutine_suspended) {
                            receiveChannel3 = receiveChannel;
                            receiveChannel2 = receiveChannel3;
                            channelIterator = it;
                            obj = hasNext;
                            i3 = 0;
                        }
                        return coroutine_suspended;
                    } catch (Throwable th2) {
                        receiveChannel2 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i != 1) {
                    if (i == 2) {
                        int i4 = channelsKt__DeprecatedKt$single$1.I$1;
                        int i5 = channelsKt__DeprecatedKt$single$1.I$0;
                        obj2 = channelsKt__DeprecatedKt$single$1.L$4;
                        ChannelIterator channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$single$1.L$3;
                        ReceiveChannel receiveChannel5 = (ReceiveChannel) channelsKt__DeprecatedKt$single$1.L$2;
                        receiveChannel4 = (ReceiveChannel) channelsKt__DeprecatedKt$single$1.L$1;
                        ReceiveChannel receiveChannel6 = (ReceiveChannel) channelsKt__DeprecatedKt$single$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            if (!((Boolean) obj).booleanValue()) {
                                throw new IllegalArgumentException("ReceiveChannel has more than one element.");
                            }
                            ChannelsKt.cancelConsumed(receiveChannel4, null);
                            return obj2;
                        } catch (Throwable th3) {
                            th = th3;
                            receiveChannel2 = receiveChannel4;
                            try {
                                throw th;
                            } catch (Throwable th4) {
                                ChannelsKt.cancelConsumed(receiveChannel2, th);
                                throw th4;
                            }
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i6 = channelsKt__DeprecatedKt$single$1.I$1;
                    int i7 = channelsKt__DeprecatedKt$single$1.I$0;
                    ChannelIterator channelIterator3 = (ChannelIterator) channelsKt__DeprecatedKt$single$1.L$3;
                    receiveChannel3 = (ReceiveChannel) channelsKt__DeprecatedKt$single$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$single$1.L$1;
                    ReceiveChannel receiveChannel7 = (ReceiveChannel) channelsKt__DeprecatedKt$single$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        i2 = i6;
                        receiveChannel = receiveChannel7;
                        channelIterator = channelIterator3;
                        i3 = i7;
                    } catch (Throwable th5) {
                        th = th5;
                        throw th;
                    }
                }
                if (((Boolean) obj).booleanValue()) {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }
                Object next = channelIterator.next();
                channelsKt__DeprecatedKt$single$1.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                channelsKt__DeprecatedKt$single$1.L$1 = receiveChannel2;
                channelsKt__DeprecatedKt$single$1.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                channelsKt__DeprecatedKt$single$1.L$3 = SpillingKt.nullOutSpilledVariable(channelIterator);
                channelsKt__DeprecatedKt$single$1.L$4 = next;
                channelsKt__DeprecatedKt$single$1.I$0 = i3;
                channelsKt__DeprecatedKt$single$1.I$1 = i2;
                channelsKt__DeprecatedKt$single$1.label = 2;
                Object hasNext2 = channelIterator.hasNext(channelsKt__DeprecatedKt$single$1);
                if (hasNext2 != coroutine_suspended) {
                    obj = hasNext2;
                    obj2 = next;
                    receiveChannel4 = receiveChannel2;
                    if (!((Boolean) obj).booleanValue()) {
                    }
                }
                return coroutine_suspended;
            }
        }
        channelsKt__DeprecatedKt$single$1 = new ChannelsKt__DeprecatedKt$single$1(continuation);
        obj = channelsKt__DeprecatedKt$single$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$single$1.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00a7 A[Catch: all -> 0x00e1, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00e1, blocks: (B:86:0x009b, B:90:0x00a7, B:82:0x0074), top: B:106:0x0074 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00dd  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object singleOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$singleOrNull$1 channelsKt__DeprecatedKt$singleOrNull$1;
        Object obj;
        int i;
        int i2;
        ReceiveChannel receiveChannel2;
        ReceiveChannel receiveChannel3;
        ChannelIterator channelIterator;
        int i3;
        ReceiveChannel receiveChannel4;
        Throwable th;
        Object obj2;
        if (continuation instanceof ChannelsKt__DeprecatedKt$singleOrNull$1) {
            channelsKt__DeprecatedKt$singleOrNull$1 = (ChannelsKt__DeprecatedKt$singleOrNull$1) continuation;
            if ((channelsKt__DeprecatedKt$singleOrNull$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$singleOrNull$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__DeprecatedKt$singleOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$singleOrNull$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$singleOrNull$1.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__DeprecatedKt$singleOrNull$1.L$1 = receiveChannel;
                        channelsKt__DeprecatedKt$singleOrNull$1.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__DeprecatedKt$singleOrNull$1.L$3 = it;
                        i2 = 0;
                        channelsKt__DeprecatedKt$singleOrNull$1.I$0 = 0;
                        channelsKt__DeprecatedKt$singleOrNull$1.I$1 = 0;
                        channelsKt__DeprecatedKt$singleOrNull$1.label = 1;
                        Object hasNext = it.hasNext(channelsKt__DeprecatedKt$singleOrNull$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        receiveChannel3 = receiveChannel2;
                        channelIterator = it;
                        obj = hasNext;
                        i3 = 0;
                    } catch (Throwable th2) {
                        receiveChannel4 = receiveChannel;
                        th = th2;
                        throw th;
                    }
                } else if (i != 1) {
                    if (i == 2) {
                        int i4 = channelsKt__DeprecatedKt$singleOrNull$1.I$1;
                        int i5 = channelsKt__DeprecatedKt$singleOrNull$1.I$0;
                        obj2 = channelsKt__DeprecatedKt$singleOrNull$1.L$4;
                        ChannelIterator channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$singleOrNull$1.L$3;
                        ReceiveChannel receiveChannel5 = (ReceiveChannel) channelsKt__DeprecatedKt$singleOrNull$1.L$2;
                        receiveChannel4 = (ReceiveChannel) channelsKt__DeprecatedKt$singleOrNull$1.L$1;
                        ReceiveChannel receiveChannel6 = (ReceiveChannel) channelsKt__DeprecatedKt$singleOrNull$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            if (((Boolean) obj).booleanValue()) {
                                ChannelsKt.cancelConsumed(receiveChannel4, null);
                                return obj2;
                            }
                            ChannelsKt.cancelConsumed(receiveChannel4, null);
                            return null;
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                throw th;
                            } catch (Throwable th4) {
                                ChannelsKt.cancelConsumed(receiveChannel4, th);
                                throw th4;
                            }
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i6 = channelsKt__DeprecatedKt$singleOrNull$1.I$1;
                    int i7 = channelsKt__DeprecatedKt$singleOrNull$1.I$0;
                    ChannelIterator channelIterator3 = (ChannelIterator) channelsKt__DeprecatedKt$singleOrNull$1.L$3;
                    receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$singleOrNull$1.L$2;
                    ReceiveChannel receiveChannel7 = (ReceiveChannel) channelsKt__DeprecatedKt$singleOrNull$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__DeprecatedKt$singleOrNull$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        i2 = i6;
                        receiveChannel = receiveChannel7;
                        channelIterator = channelIterator3;
                        i3 = i7;
                    } catch (Throwable th5) {
                        th = th5;
                        receiveChannel4 = receiveChannel7;
                        throw th;
                    }
                }
                if (!((Boolean) obj).booleanValue()) {
                    Object next = channelIterator.next();
                    channelsKt__DeprecatedKt$singleOrNull$1.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                    channelsKt__DeprecatedKt$singleOrNull$1.L$1 = receiveChannel;
                    channelsKt__DeprecatedKt$singleOrNull$1.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                    channelsKt__DeprecatedKt$singleOrNull$1.L$3 = SpillingKt.nullOutSpilledVariable(channelIterator);
                    channelsKt__DeprecatedKt$singleOrNull$1.L$4 = next;
                    channelsKt__DeprecatedKt$singleOrNull$1.I$0 = i3;
                    channelsKt__DeprecatedKt$singleOrNull$1.I$1 = i2;
                    channelsKt__DeprecatedKt$singleOrNull$1.label = 2;
                    Object hasNext2 = channelIterator.hasNext(channelsKt__DeprecatedKt$singleOrNull$1);
                    if (hasNext2 != coroutine_suspended) {
                        receiveChannel4 = receiveChannel;
                        obj2 = next;
                        obj = hasNext2;
                        if (((Boolean) obj).booleanValue()) {
                        }
                    }
                    return coroutine_suspended;
                }
                ChannelsKt.cancelConsumed(receiveChannel, null);
                return null;
            }
        }
        channelsKt__DeprecatedKt$singleOrNull$1 = new ChannelsKt__DeprecatedKt$singleOrNull$1(continuation);
        obj = channelsKt__DeprecatedKt$singleOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$singleOrNull$1.label;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    public static /* synthetic */ ReceiveChannel drop$default(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext, int i2, Object obj) {
        ReceiveChannel drop;
        if ((i2 & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        drop = drop(receiveChannel, i, coroutineContext);
        return drop;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel drop(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$drop$1(i, receiveChannel, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel dropWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        ReceiveChannel dropWhile;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        dropWhile = dropWhile(receiveChannel, coroutineContext, function2);
        return dropWhile;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel dropWhile(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$dropWhile$1(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel filter$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.filter(receiveChannel, coroutineContext, function2);
    }

    public static final <E> ReceiveChannel<E> filter(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$filter$1(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel filterIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        ReceiveChannel filterIndexed;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        filterIndexed = filterIndexed(receiveChannel, coroutineContext, function3);
        return filterIndexed;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterIndexed(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$filterIndexed$1(receiveChannel, function3, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel filterNot$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        ReceiveChannel filterNot;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        filterNot = filterNot(receiveChannel, coroutineContext, function2);
        return filterNot;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterNot(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt.filter(receiveChannel, coroutineContext, new ChannelsKt__DeprecatedKt$filterNot$1(function2, null));
    }

    public static final <E> ReceiveChannel<E> filterNotNull(ReceiveChannel<? extends E> receiveChannel) {
        ReceiveChannel<E> filter$default;
        filter$default = filter$default(receiveChannel, null, new ChannelsKt__DeprecatedKt$filterNotNull$1(null), 1, null);
        Intrinsics.checkNotNull(filter$default, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.filterNotNull>");
        return filter$default;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00a8 A[Catch: all -> 0x0056, TryCatch #1 {all -> 0x0056, blocks: (B:62:0x0045, B:75:0x00a0, B:77:0x00a8, B:79:0x00ae, B:81:0x00b6), top: B:94:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00b6 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #1 {all -> 0x0056, blocks: (B:62:0x0045, B:75:0x00a0, B:77:0x00a8, B:79:0x00ae, B:81:0x00b6), top: B:94:0x0045 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x009a -> B:75:0x00a0). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel receiveChannel, Collection collection, Continuation continuation) {
        ChannelsKt__DeprecatedKt$filterNotNullTo$1 channelsKt__DeprecatedKt$filterNotNullTo$1;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        int i2;
        ChannelIterator it;
        ChannelsKt__DeprecatedKt$filterNotNullTo$1 channelsKt__DeprecatedKt$filterNotNullTo$12;
        int i3;
        int i4;
        Throwable th2;
        ReceiveChannel receiveChannel3;
        Collection collection2;
        ReceiveChannel receiveChannel4;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$filterNotNullTo$1) {
            channelsKt__DeprecatedKt$filterNotNullTo$1 = (ChannelsKt__DeprecatedKt$filterNotNullTo$1) continuation;
            if ((channelsKt__DeprecatedKt$filterNotNullTo$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$filterNotNullTo$1.label -= Integer.MIN_VALUE;
                Object obj = channelsKt__DeprecatedKt$filterNotNullTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$filterNotNullTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        i2 = 0;
                        it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$filterNotNullTo$12 = channelsKt__DeprecatedKt$filterNotNullTo$1;
                        i3 = 0;
                        i4 = 0;
                        th2 = null;
                        receiveChannel2 = receiveChannel;
                        receiveChannel3 = receiveChannel2;
                        collection2 = collection;
                        receiveChannel4 = receiveChannel3;
                        channelsKt__DeprecatedKt$filterNotNullTo$12.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__DeprecatedKt$filterNotNullTo$12.L$1 = collection2;
                        channelsKt__DeprecatedKt$filterNotNullTo$12.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                        channelsKt__DeprecatedKt$filterNotNullTo$12.L$3 = receiveChannel2;
                        channelsKt__DeprecatedKt$filterNotNullTo$12.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                        channelsKt__DeprecatedKt$filterNotNullTo$12.L$5 = it;
                        channelsKt__DeprecatedKt$filterNotNullTo$12.I$0 = i4;
                        channelsKt__DeprecatedKt$filterNotNullTo$12.I$1 = i3;
                        channelsKt__DeprecatedKt$filterNotNullTo$12.I$2 = i2;
                        channelsKt__DeprecatedKt$filterNotNullTo$12.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$12);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i5 = channelsKt__DeprecatedKt$filterNotNullTo$1.I$2;
                    int i6 = channelsKt__DeprecatedKt$filterNotNullTo$1.I$1;
                    int i7 = channelsKt__DeprecatedKt$filterNotNullTo$1.I$0;
                    ChannelIterator channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$filterNotNullTo$1.L$5;
                    ReceiveChannel receiveChannel5 = (ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$1.L$4;
                    ReceiveChannel receiveChannel6 = (ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$1.L$3;
                    ReceiveChannel receiveChannel7 = (ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$1.L$2;
                    Collection collection3 = (Collection) channelsKt__DeprecatedKt$filterNotNullTo$1.L$1;
                    ReceiveChannel receiveChannel8 = (ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        i2 = i5;
                        receiveChannel = receiveChannel8;
                        ChannelIterator channelIterator2 = channelIterator;
                        i3 = i6;
                        receiveChannel4 = receiveChannel7;
                        int i8 = i7;
                        channelsKt__DeprecatedKt$filterNotNullTo$12 = channelsKt__DeprecatedKt$filterNotNullTo$1;
                        receiveChannel3 = receiveChannel5;
                        Throwable th4 = null;
                        collection2 = collection3;
                        if (!((Boolean) obj).booleanValue()) {
                            Unit unit = Unit.INSTANCE;
                            ChannelsKt.cancelConsumed(receiveChannel6, th4);
                            return collection2;
                        }
                        try {
                            Object next = channelIterator2.next();
                            if (next != null) {
                                collection2.add(next);
                            }
                            channelsKt__DeprecatedKt$filterNotNullTo$12.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                            channelsKt__DeprecatedKt$filterNotNullTo$12.L$1 = collection2;
                            channelsKt__DeprecatedKt$filterNotNullTo$12.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                            channelsKt__DeprecatedKt$filterNotNullTo$12.L$3 = receiveChannel2;
                            channelsKt__DeprecatedKt$filterNotNullTo$12.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                            channelsKt__DeprecatedKt$filterNotNullTo$12.L$5 = it;
                            channelsKt__DeprecatedKt$filterNotNullTo$12.I$0 = i4;
                            channelsKt__DeprecatedKt$filterNotNullTo$12.I$1 = i3;
                            channelsKt__DeprecatedKt$filterNotNullTo$12.I$2 = i2;
                            channelsKt__DeprecatedKt$filterNotNullTo$12.label = 1;
                            hasNext = it.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$12);
                            if (hasNext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            int i9 = i4;
                            receiveChannel6 = receiveChannel2;
                            obj = hasNext;
                            channelIterator2 = it;
                            th4 = th2;
                            i8 = i9;
                            if (!((Boolean) obj).booleanValue()) {
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            try {
                                throw th;
                            } catch (Throwable th6) {
                                ChannelsKt.cancelConsumed(receiveChannel2, th);
                                throw th6;
                            }
                        }
                        receiveChannel2 = receiveChannel6;
                        i4 = i8;
                        th2 = th4;
                        it = channelIterator2;
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel2 = receiveChannel6;
                        throw th;
                    }
                }
            }
        }
        channelsKt__DeprecatedKt$filterNotNullTo$1 = new ChannelsKt__DeprecatedKt$filterNotNullTo$1(continuation);
        Object obj2 = channelsKt__DeprecatedKt$filterNotNullTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$filterNotNullTo$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Not initialized variable reg: 12, insn: 0x008a: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]), block:B:80:0x0089 */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0029 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00e2 A[Catch: all -> 0x0149, TryCatch #2 {all -> 0x0149, blocks: (B:84:0x00a1, B:88:0x00da, B:90:0x00e2, B:92:0x00e8, B:99:0x0143), top: B:114:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0143 A[Catch: all -> 0x0149, TRY_LEAVE, TryCatch #2 {all -> 0x0149, blocks: (B:84:0x00a1, B:88:0x00da, B:90:0x00e2, B:92:0x00e8, B:99:0x0143), top: B:114:0x00a1 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:0x0140 -> B:114:0x00a1). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel receiveChannel, SendChannel sendChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$filterNotNullTo$3 channelsKt__DeprecatedKt$filterNotNullTo$3;
        int i;
        Throwable th;
        ReceiveChannel receiveChannel2;
        ReceiveChannel receiveChannel3;
        int i2;
        int i3;
        ChannelIterator channelIterator;
        ReceiveChannel receiveChannel4;
        ReceiveChannel receiveChannel5;
        SendChannel sendChannel2;
        int i4;
        ReceiveChannel receiveChannel6;
        Throwable th2;
        Throwable th3;
        int i5;
        int i6;
        ChannelsKt__DeprecatedKt$filterNotNullTo$3 channelsKt__DeprecatedKt$filterNotNullTo$32;
        SendChannel sendChannel3;
        ReceiveChannel receiveChannel7;
        ReceiveChannel receiveChannel8;
        ReceiveChannel receiveChannel9;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$filterNotNullTo$3) {
            channelsKt__DeprecatedKt$filterNotNullTo$3 = (ChannelsKt__DeprecatedKt$filterNotNullTo$3) continuation;
            if ((channelsKt__DeprecatedKt$filterNotNullTo$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$filterNotNullTo$3.label -= Integer.MIN_VALUE;
                Object obj = channelsKt__DeprecatedKt$filterNotNullTo$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$filterNotNullTo$3.label;
                int i7 = 1;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        receiveChannel3 = receiveChannel;
                        receiveChannel7 = receiveChannel3;
                        sendChannel3 = sendChannel;
                        channelIterator = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$filterNotNullTo$32 = channelsKt__DeprecatedKt$filterNotNullTo$3;
                        i6 = 0;
                        i5 = 0;
                        i4 = 0;
                        th2 = null;
                        receiveChannel9 = receiveChannel7;
                        receiveChannel8 = receiveChannel9;
                        channelsKt__DeprecatedKt$filterNotNullTo$32.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel9);
                        channelsKt__DeprecatedKt$filterNotNullTo$32.L$1 = sendChannel3;
                        channelsKt__DeprecatedKt$filterNotNullTo$32.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel8);
                        channelsKt__DeprecatedKt$filterNotNullTo$32.L$3 = receiveChannel3;
                        channelsKt__DeprecatedKt$filterNotNullTo$32.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel7);
                        channelsKt__DeprecatedKt$filterNotNullTo$32.L$5 = channelIterator;
                        channelsKt__DeprecatedKt$filterNotNullTo$32.L$6 = null;
                        channelsKt__DeprecatedKt$filterNotNullTo$32.L$7 = null;
                        channelsKt__DeprecatedKt$filterNotNullTo$32.I$0 = i6;
                        channelsKt__DeprecatedKt$filterNotNullTo$32.I$1 = i5;
                        channelsKt__DeprecatedKt$filterNotNullTo$32.I$2 = i4;
                        channelsKt__DeprecatedKt$filterNotNullTo$32.label = i7;
                        hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$32);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (Throwable th4) {
                        th3 = th4;
                        receiveChannel3 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else {
                    try {
                        if (i == 1) {
                            int i8 = channelsKt__DeprecatedKt$filterNotNullTo$3.I$2;
                            i2 = channelsKt__DeprecatedKt$filterNotNullTo$3.I$1;
                            i3 = channelsKt__DeprecatedKt$filterNotNullTo$3.I$0;
                            channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$filterNotNullTo$3.L$5;
                            receiveChannel4 = (ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$3.L$4;
                            ReceiveChannel receiveChannel10 = (ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$3.L$3;
                            receiveChannel5 = (ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$3.L$2;
                            SendChannel sendChannel4 = (SendChannel) channelsKt__DeprecatedKt$filterNotNullTo$3.L$1;
                            ReceiveChannel receiveChannel11 = (ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$3.L$0;
                            ResultKt.throwOnFailure(obj);
                            sendChannel2 = sendChannel4;
                            i4 = i8;
                            receiveChannel3 = receiveChannel10;
                            receiveChannel6 = receiveChannel11;
                            th2 = null;
                            if (!((Boolean) obj).booleanValue()) {
                            }
                        } else if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            int i9 = channelsKt__DeprecatedKt$filterNotNullTo$3.I$3;
                            int i10 = channelsKt__DeprecatedKt$filterNotNullTo$3.I$2;
                            i2 = channelsKt__DeprecatedKt$filterNotNullTo$3.I$1;
                            i3 = channelsKt__DeprecatedKt$filterNotNullTo$3.I$0;
                            Object obj2 = channelsKt__DeprecatedKt$filterNotNullTo$3.L$7;
                            Object obj3 = channelsKt__DeprecatedKt$filterNotNullTo$3.L$6;
                            channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$filterNotNullTo$3.L$5;
                            receiveChannel4 = (ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$3.L$4;
                            ReceiveChannel receiveChannel12 = (ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$3.L$3;
                            receiveChannel5 = (ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$3.L$2;
                            SendChannel sendChannel5 = (SendChannel) channelsKt__DeprecatedKt$filterNotNullTo$3.L$1;
                            ReceiveChannel receiveChannel13 = (ReceiveChannel) channelsKt__DeprecatedKt$filterNotNullTo$3.L$0;
                            ResultKt.throwOnFailure(obj);
                            Throwable th5 = null;
                            try {
                                ReceiveChannel receiveChannel14 = receiveChannel13;
                                th2 = th5;
                                receiveChannel9 = receiveChannel14;
                                ReceiveChannel receiveChannel15 = receiveChannel4;
                                channelsKt__DeprecatedKt$filterNotNullTo$32 = channelsKt__DeprecatedKt$filterNotNullTo$3;
                                receiveChannel8 = receiveChannel5;
                                i5 = i2;
                                receiveChannel7 = receiveChannel15;
                                SendChannel sendChannel6 = sendChannel5;
                                i4 = i10;
                                receiveChannel3 = receiveChannel12;
                                i6 = i3;
                                sendChannel3 = sendChannel6;
                                channelsKt__DeprecatedKt$filterNotNullTo$32.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel9);
                                channelsKt__DeprecatedKt$filterNotNullTo$32.L$1 = sendChannel3;
                                channelsKt__DeprecatedKt$filterNotNullTo$32.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel8);
                                channelsKt__DeprecatedKt$filterNotNullTo$32.L$3 = receiveChannel3;
                                channelsKt__DeprecatedKt$filterNotNullTo$32.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel7);
                                channelsKt__DeprecatedKt$filterNotNullTo$32.L$5 = channelIterator;
                                channelsKt__DeprecatedKt$filterNotNullTo$32.L$6 = null;
                                channelsKt__DeprecatedKt$filterNotNullTo$32.L$7 = null;
                                channelsKt__DeprecatedKt$filterNotNullTo$32.I$0 = i6;
                                channelsKt__DeprecatedKt$filterNotNullTo$32.I$1 = i5;
                                channelsKt__DeprecatedKt$filterNotNullTo$32.I$2 = i4;
                                channelsKt__DeprecatedKt$filterNotNullTo$32.label = i7;
                                hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$32);
                                if (hasNext != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                int i11 = i6;
                                receiveChannel6 = receiveChannel9;
                                obj = hasNext;
                                sendChannel2 = sendChannel3;
                                i3 = i11;
                                int i12 = i5;
                                receiveChannel5 = receiveChannel8;
                                channelsKt__DeprecatedKt$filterNotNullTo$3 = channelsKt__DeprecatedKt$filterNotNullTo$32;
                                receiveChannel4 = receiveChannel7;
                                i2 = i12;
                                if (!((Boolean) obj).booleanValue()) {
                                    Unit unit = Unit.INSTANCE;
                                    return sendChannel2;
                                }
                                Object next = channelIterator.next();
                                if (next != null) {
                                    channelsKt__DeprecatedKt$filterNotNullTo$3.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel6);
                                    channelsKt__DeprecatedKt$filterNotNullTo$3.L$1 = sendChannel2;
                                    channelsKt__DeprecatedKt$filterNotNullTo$3.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                                    channelsKt__DeprecatedKt$filterNotNullTo$3.L$3 = receiveChannel3;
                                    channelsKt__DeprecatedKt$filterNotNullTo$3.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                                    channelsKt__DeprecatedKt$filterNotNullTo$3.L$5 = channelIterator;
                                    channelsKt__DeprecatedKt$filterNotNullTo$3.L$6 = SpillingKt.nullOutSpilledVariable(next);
                                    channelsKt__DeprecatedKt$filterNotNullTo$3.L$7 = SpillingKt.nullOutSpilledVariable(next);
                                    channelsKt__DeprecatedKt$filterNotNullTo$3.I$0 = i3;
                                    channelsKt__DeprecatedKt$filterNotNullTo$3.I$1 = i2;
                                    channelsKt__DeprecatedKt$filterNotNullTo$3.I$2 = i4;
                                    channelsKt__DeprecatedKt$filterNotNullTo$3.I$3 = 0;
                                    channelsKt__DeprecatedKt$filterNotNullTo$3.label = 2;
                                    if (sendChannel2.send(next, channelsKt__DeprecatedKt$filterNotNullTo$3) != coroutine_suspended) {
                                        th5 = th;
                                        receiveChannel13 = receiveChannel6;
                                        receiveChannel12 = receiveChannel3;
                                        i10 = i4;
                                        sendChannel5 = sendChannel2;
                                        ReceiveChannel receiveChannel142 = receiveChannel13;
                                        th2 = th5;
                                        receiveChannel9 = receiveChannel142;
                                        ReceiveChannel receiveChannel152 = receiveChannel4;
                                        channelsKt__DeprecatedKt$filterNotNullTo$32 = channelsKt__DeprecatedKt$filterNotNullTo$3;
                                        receiveChannel8 = receiveChannel5;
                                        i5 = i2;
                                        receiveChannel7 = receiveChannel152;
                                        SendChannel sendChannel62 = sendChannel5;
                                        i4 = i10;
                                        receiveChannel3 = receiveChannel12;
                                        i6 = i3;
                                        sendChannel3 = sendChannel62;
                                        i7 = 1;
                                        channelsKt__DeprecatedKt$filterNotNullTo$32.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel9);
                                        channelsKt__DeprecatedKt$filterNotNullTo$32.L$1 = sendChannel3;
                                        channelsKt__DeprecatedKt$filterNotNullTo$32.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel8);
                                        channelsKt__DeprecatedKt$filterNotNullTo$32.L$3 = receiveChannel3;
                                        channelsKt__DeprecatedKt$filterNotNullTo$32.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel7);
                                        channelsKt__DeprecatedKt$filterNotNullTo$32.L$5 = channelIterator;
                                        channelsKt__DeprecatedKt$filterNotNullTo$32.L$6 = null;
                                        channelsKt__DeprecatedKt$filterNotNullTo$32.L$7 = null;
                                        channelsKt__DeprecatedKt$filterNotNullTo$32.I$0 = i6;
                                        channelsKt__DeprecatedKt$filterNotNullTo$32.I$1 = i5;
                                        channelsKt__DeprecatedKt$filterNotNullTo$32.I$2 = i4;
                                        channelsKt__DeprecatedKt$filterNotNullTo$32.label = i7;
                                        hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$32);
                                        if (hasNext != coroutine_suspended) {
                                        }
                                    }
                                    return coroutine_suspended;
                                }
                                ReceiveChannel receiveChannel16 = receiveChannel4;
                                channelsKt__DeprecatedKt$filterNotNullTo$32 = channelsKt__DeprecatedKt$filterNotNullTo$3;
                                receiveChannel8 = receiveChannel5;
                                i5 = i2;
                                receiveChannel7 = receiveChannel16;
                                receiveChannel9 = receiveChannel6;
                                i6 = i3;
                                sendChannel3 = sendChannel2;
                                i7 = 1;
                                channelsKt__DeprecatedKt$filterNotNullTo$32.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel9);
                                channelsKt__DeprecatedKt$filterNotNullTo$32.L$1 = sendChannel3;
                                channelsKt__DeprecatedKt$filterNotNullTo$32.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel8);
                                channelsKt__DeprecatedKt$filterNotNullTo$32.L$3 = receiveChannel3;
                                channelsKt__DeprecatedKt$filterNotNullTo$32.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel7);
                                channelsKt__DeprecatedKt$filterNotNullTo$32.L$5 = channelIterator;
                                channelsKt__DeprecatedKt$filterNotNullTo$32.L$6 = null;
                                channelsKt__DeprecatedKt$filterNotNullTo$32.L$7 = null;
                                channelsKt__DeprecatedKt$filterNotNullTo$32.I$0 = i6;
                                channelsKt__DeprecatedKt$filterNotNullTo$32.I$1 = i5;
                                channelsKt__DeprecatedKt$filterNotNullTo$32.I$2 = i4;
                                channelsKt__DeprecatedKt$filterNotNullTo$32.label = i7;
                                hasNext = channelIterator.hasNext(channelsKt__DeprecatedKt$filterNotNullTo$32);
                                if (hasNext != coroutine_suspended) {
                                }
                            } catch (Throwable th6) {
                                th3 = th6;
                                th = th3;
                                try {
                                    throw th;
                                } finally {
                                    ChannelsKt.cancelConsumed(receiveChannel3, th);
                                }
                            }
                            i7 = 1;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel3 = receiveChannel2;
                        throw th;
                    }
                }
            }
        }
        channelsKt__DeprecatedKt$filterNotNullTo$3 = new ChannelsKt__DeprecatedKt$filterNotNullTo$3(continuation);
        Object obj4 = channelsKt__DeprecatedKt$filterNotNullTo$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$filterNotNullTo$3.label;
        int i72 = 1;
        if (i != 0) {
        }
    }

    public static /* synthetic */ ReceiveChannel take$default(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext, int i2, Object obj) {
        ReceiveChannel take;
        if ((i2 & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        take = take(receiveChannel, i, coroutineContext);
        return take;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel take(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$take$1(i, receiveChannel, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel takeWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        ReceiveChannel takeWhile;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        takeWhile = takeWhile(receiveChannel, coroutineContext, function2);
        return takeWhile;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel takeWhile(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$takeWhile$1(receiveChannel, function2, null), 6, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0095: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]), block:B:76:0x0094 */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0029 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ed A[Catch: all -> 0x0138, TryCatch #1 {all -> 0x0138, blocks: (B:80:0x00ac, B:84:0x00e5, B:86:0x00ed, B:91:0x0132), top: B:104:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0132 A[Catch: all -> 0x0138, TRY_LEAVE, TryCatch #1 {all -> 0x0138, blocks: (B:80:0x00ac, B:84:0x00e5, B:86:0x00ed, B:91:0x0132), top: B:104:0x00ac }] */
    /* JADX WARN: Type inference failed for: r14v1, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r14v4, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x012f -> B:104:0x00ac). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends SendChannel<? super E>> Object toChannel(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        ChannelsKt__DeprecatedKt$toChannel$1 channelsKt__DeprecatedKt$toChannel$1;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        int i2;
        int i3;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        C c2;
        int i4;
        ReceiveChannel<? extends E> receiveChannel6;
        Throwable th2;
        ChannelsKt__DeprecatedKt$toChannel$1 channelsKt__DeprecatedKt$toChannel$12;
        ReceiveChannel<? extends E> receiveChannel7;
        int i5;
        ReceiveChannel<? extends E> receiveChannel8;
        int i6;
        C c3;
        ReceiveChannel<? extends E> receiveChannel9;
        Throwable th3;
        ChannelIterator<? extends E> channelIterator;
        ChannelIterator<? extends E> channelIterator2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$toChannel$1) {
            channelsKt__DeprecatedKt$toChannel$1 = (ChannelsKt__DeprecatedKt$toChannel$1) continuation;
            if ((channelsKt__DeprecatedKt$toChannel$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$toChannel$1.label -= Integer.MIN_VALUE;
                Object obj = channelsKt__DeprecatedKt$toChannel$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$toChannel$1.label;
                int i7 = 1;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        receiveChannel3 = receiveChannel;
                        receiveChannel8 = receiveChannel3;
                        c3 = c;
                        channelIterator2 = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$toChannel$12 = channelsKt__DeprecatedKt$toChannel$1;
                        i6 = 0;
                        i5 = 0;
                        i4 = 0;
                        th2 = null;
                        receiveChannel9 = receiveChannel8;
                        receiveChannel7 = receiveChannel9;
                        channelsKt__DeprecatedKt$toChannel$12.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel9);
                        channelsKt__DeprecatedKt$toChannel$12.L$1 = c3;
                        channelsKt__DeprecatedKt$toChannel$12.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel7);
                        channelsKt__DeprecatedKt$toChannel$12.L$3 = receiveChannel3;
                        channelsKt__DeprecatedKt$toChannel$12.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel8);
                        channelsKt__DeprecatedKt$toChannel$12.L$5 = channelIterator2;
                        channelsKt__DeprecatedKt$toChannel$12.L$6 = null;
                        channelsKt__DeprecatedKt$toChannel$12.L$7 = null;
                        channelsKt__DeprecatedKt$toChannel$12.I$0 = i6;
                        channelsKt__DeprecatedKt$toChannel$12.I$1 = i5;
                        channelsKt__DeprecatedKt$toChannel$12.I$2 = i4;
                        channelsKt__DeprecatedKt$toChannel$12.label = i7;
                        hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$toChannel$12);
                        if (hasNext == coroutine_suspended) {
                        }
                    } catch (Throwable th4) {
                        th3 = th4;
                        receiveChannel3 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else {
                    try {
                        if (i != 1) {
                            if (i == 2) {
                                int i8 = channelsKt__DeprecatedKt$toChannel$1.I$3;
                                int i9 = channelsKt__DeprecatedKt$toChannel$1.I$2;
                                int i10 = channelsKt__DeprecatedKt$toChannel$1.I$1;
                                int i11 = channelsKt__DeprecatedKt$toChannel$1.I$0;
                                Object obj2 = channelsKt__DeprecatedKt$toChannel$1.L$7;
                                Object obj3 = channelsKt__DeprecatedKt$toChannel$1.L$6;
                                ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__DeprecatedKt$toChannel$1.L$5;
                                ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__DeprecatedKt$toChannel$1.L$4;
                                ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) channelsKt__DeprecatedKt$toChannel$1.L$3;
                                ReceiveChannel<? extends E> receiveChannel12 = (ReceiveChannel) channelsKt__DeprecatedKt$toChannel$1.L$2;
                                ?? r14 = (SendChannel) channelsKt__DeprecatedKt$toChannel$1.L$1;
                                ReceiveChannel<? extends E> receiveChannel13 = (ReceiveChannel) channelsKt__DeprecatedKt$toChannel$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                channelsKt__DeprecatedKt$toChannel$12 = channelsKt__DeprecatedKt$toChannel$1;
                                receiveChannel7 = receiveChannel12;
                                i5 = i10;
                                receiveChannel8 = receiveChannel10;
                                i4 = i9;
                                receiveChannel3 = receiveChannel11;
                                i6 = i11;
                                c3 = r14;
                                receiveChannel9 = receiveChannel13;
                                th2 = null;
                                ChannelIterator<? extends E> channelIterator4 = channelIterator3;
                                i7 = 1;
                                channelIterator2 = channelIterator4;
                                try {
                                    channelsKt__DeprecatedKt$toChannel$12.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel9);
                                    channelsKt__DeprecatedKt$toChannel$12.L$1 = c3;
                                    channelsKt__DeprecatedKt$toChannel$12.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel7);
                                    channelsKt__DeprecatedKt$toChannel$12.L$3 = receiveChannel3;
                                    channelsKt__DeprecatedKt$toChannel$12.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel8);
                                    channelsKt__DeprecatedKt$toChannel$12.L$5 = channelIterator2;
                                    channelsKt__DeprecatedKt$toChannel$12.L$6 = null;
                                    channelsKt__DeprecatedKt$toChannel$12.L$7 = null;
                                    channelsKt__DeprecatedKt$toChannel$12.I$0 = i6;
                                    channelsKt__DeprecatedKt$toChannel$12.I$1 = i5;
                                    channelsKt__DeprecatedKt$toChannel$12.I$2 = i4;
                                    channelsKt__DeprecatedKt$toChannel$12.label = i7;
                                    hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$toChannel$12);
                                    if (hasNext == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    int i12 = i6;
                                    receiveChannel6 = receiveChannel9;
                                    obj = hasNext;
                                    c2 = c3;
                                    i3 = i12;
                                    int i13 = i5;
                                    receiveChannel5 = receiveChannel7;
                                    channelsKt__DeprecatedKt$toChannel$1 = channelsKt__DeprecatedKt$toChannel$12;
                                    receiveChannel4 = receiveChannel8;
                                    i2 = i13;
                                    channelIterator = channelIterator2;
                                    if (!((Boolean) obj).booleanValue()) {
                                        E next = channelIterator.next();
                                        channelsKt__DeprecatedKt$toChannel$1.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel6);
                                        channelsKt__DeprecatedKt$toChannel$1.L$1 = c2;
                                        channelsKt__DeprecatedKt$toChannel$1.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                                        channelsKt__DeprecatedKt$toChannel$1.L$3 = receiveChannel3;
                                        channelsKt__DeprecatedKt$toChannel$1.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                                        channelsKt__DeprecatedKt$toChannel$1.L$5 = channelIterator;
                                        channelsKt__DeprecatedKt$toChannel$1.L$6 = SpillingKt.nullOutSpilledVariable(next);
                                        channelsKt__DeprecatedKt$toChannel$1.L$7 = SpillingKt.nullOutSpilledVariable(next);
                                        channelsKt__DeprecatedKt$toChannel$1.I$0 = i3;
                                        channelsKt__DeprecatedKt$toChannel$1.I$1 = i2;
                                        channelsKt__DeprecatedKt$toChannel$1.I$2 = i4;
                                        channelsKt__DeprecatedKt$toChannel$1.I$3 = 0;
                                        channelsKt__DeprecatedKt$toChannel$1.label = 2;
                                        if (c2.send(next, channelsKt__DeprecatedKt$toChannel$1) != coroutine_suspended) {
                                            ReceiveChannel<? extends E> receiveChannel14 = receiveChannel4;
                                            channelsKt__DeprecatedKt$toChannel$12 = channelsKt__DeprecatedKt$toChannel$1;
                                            receiveChannel7 = receiveChannel5;
                                            i5 = i2;
                                            receiveChannel8 = receiveChannel14;
                                            receiveChannel9 = receiveChannel6;
                                            i6 = i3;
                                            c3 = c2;
                                            channelIterator4 = channelIterator;
                                            i7 = 1;
                                            channelIterator2 = channelIterator4;
                                            channelsKt__DeprecatedKt$toChannel$12.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel9);
                                            channelsKt__DeprecatedKt$toChannel$12.L$1 = c3;
                                            channelsKt__DeprecatedKt$toChannel$12.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel7);
                                            channelsKt__DeprecatedKt$toChannel$12.L$3 = receiveChannel3;
                                            channelsKt__DeprecatedKt$toChannel$12.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel8);
                                            channelsKt__DeprecatedKt$toChannel$12.L$5 = channelIterator2;
                                            channelsKt__DeprecatedKt$toChannel$12.L$6 = null;
                                            channelsKt__DeprecatedKt$toChannel$12.L$7 = null;
                                            channelsKt__DeprecatedKt$toChannel$12.I$0 = i6;
                                            channelsKt__DeprecatedKt$toChannel$12.I$1 = i5;
                                            channelsKt__DeprecatedKt$toChannel$12.I$2 = i4;
                                            channelsKt__DeprecatedKt$toChannel$12.label = i7;
                                            hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$toChannel$12);
                                            if (hasNext == coroutine_suspended) {
                                            }
                                        }
                                        return coroutine_suspended;
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    return c2;
                                } catch (Throwable th5) {
                                    th3 = th5;
                                    th = th3;
                                    try {
                                        throw th;
                                    } finally {
                                        ChannelsKt.cancelConsumed(receiveChannel3, th);
                                    }
                                }
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i14 = channelsKt__DeprecatedKt$toChannel$1.I$2;
                        i2 = channelsKt__DeprecatedKt$toChannel$1.I$1;
                        i3 = channelsKt__DeprecatedKt$toChannel$1.I$0;
                        ChannelIterator<? extends E> channelIterator5 = (ChannelIterator) channelsKt__DeprecatedKt$toChannel$1.L$5;
                        receiveChannel4 = (ReceiveChannel) channelsKt__DeprecatedKt$toChannel$1.L$4;
                        ReceiveChannel<? extends E> receiveChannel15 = (ReceiveChannel) channelsKt__DeprecatedKt$toChannel$1.L$3;
                        receiveChannel5 = (ReceiveChannel) channelsKt__DeprecatedKt$toChannel$1.L$2;
                        ?? r142 = (SendChannel) channelsKt__DeprecatedKt$toChannel$1.L$1;
                        ReceiveChannel<? extends E> receiveChannel16 = (ReceiveChannel) channelsKt__DeprecatedKt$toChannel$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        c2 = r142;
                        i4 = i14;
                        receiveChannel3 = receiveChannel15;
                        receiveChannel6 = receiveChannel16;
                        th2 = null;
                        channelIterator = channelIterator5;
                        if (!((Boolean) obj).booleanValue()) {
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel3 = receiveChannel2;
                        throw th;
                    }
                }
            }
        }
        channelsKt__DeprecatedKt$toChannel$1 = new ChannelsKt__DeprecatedKt$toChannel$1(continuation);
        Object obj4 = channelsKt__DeprecatedKt$toChannel$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$toChannel$1.label;
        int i72 = 1;
        if (i != 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00a8 A[Catch: all -> 0x0056, TryCatch #1 {all -> 0x0056, blocks: (B:59:0x0045, B:72:0x00a0, B:74:0x00a8, B:75:0x00b4), top: B:88:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00b4 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #1 {all -> 0x0056, blocks: (B:59:0x0045, B:72:0x00a0, B:74:0x00a8, B:75:0x00b4), top: B:88:0x0045 }] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x009a -> B:72:0x00a0). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends Collection<? super E>> Object toCollection(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        ChannelsKt__DeprecatedKt$toCollection$1 channelsKt__DeprecatedKt$toCollection$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        int i2;
        ChannelIterator<? extends E> it;
        ChannelsKt__DeprecatedKt$toCollection$1 channelsKt__DeprecatedKt$toCollection$12;
        int i3;
        int i4;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        C c2;
        ReceiveChannel<? extends E> receiveChannel4;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$toCollection$1) {
            channelsKt__DeprecatedKt$toCollection$1 = (ChannelsKt__DeprecatedKt$toCollection$1) continuation;
            if ((channelsKt__DeprecatedKt$toCollection$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$toCollection$1.label -= Integer.MIN_VALUE;
                Object obj = channelsKt__DeprecatedKt$toCollection$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$toCollection$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        i2 = 0;
                        it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$toCollection$12 = channelsKt__DeprecatedKt$toCollection$1;
                        i3 = 0;
                        i4 = 0;
                        th2 = null;
                        receiveChannel2 = receiveChannel;
                        receiveChannel3 = receiveChannel2;
                        c2 = c;
                        receiveChannel4 = receiveChannel3;
                        channelsKt__DeprecatedKt$toCollection$12.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__DeprecatedKt$toCollection$12.L$1 = c2;
                        channelsKt__DeprecatedKt$toCollection$12.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                        channelsKt__DeprecatedKt$toCollection$12.L$3 = receiveChannel2;
                        channelsKt__DeprecatedKt$toCollection$12.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                        channelsKt__DeprecatedKt$toCollection$12.L$5 = it;
                        channelsKt__DeprecatedKt$toCollection$12.I$0 = i4;
                        channelsKt__DeprecatedKt$toCollection$12.I$1 = i3;
                        channelsKt__DeprecatedKt$toCollection$12.I$2 = i2;
                        channelsKt__DeprecatedKt$toCollection$12.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$toCollection$12);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i5 = channelsKt__DeprecatedKt$toCollection$1.I$2;
                    int i6 = channelsKt__DeprecatedKt$toCollection$1.I$1;
                    int i7 = channelsKt__DeprecatedKt$toCollection$1.I$0;
                    ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$toCollection$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel5 = (ReceiveChannel) channelsKt__DeprecatedKt$toCollection$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__DeprecatedKt$toCollection$1.L$3;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__DeprecatedKt$toCollection$1.L$2;
                    ?? r9 = (Collection) channelsKt__DeprecatedKt$toCollection$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__DeprecatedKt$toCollection$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        i2 = i5;
                        receiveChannel = receiveChannel8;
                        ChannelIterator<? extends E> channelIterator2 = channelIterator;
                        i3 = i6;
                        receiveChannel4 = receiveChannel7;
                        int i8 = i7;
                        channelsKt__DeprecatedKt$toCollection$12 = channelsKt__DeprecatedKt$toCollection$1;
                        receiveChannel3 = receiveChannel5;
                        Throwable th4 = null;
                        c2 = r9;
                        if (!((Boolean) obj).booleanValue()) {
                            c2.add(channelIterator2.next());
                            receiveChannel2 = receiveChannel6;
                            i4 = i8;
                            th2 = th4;
                            it = channelIterator2;
                            try {
                                channelsKt__DeprecatedKt$toCollection$12.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                                channelsKt__DeprecatedKt$toCollection$12.L$1 = c2;
                                channelsKt__DeprecatedKt$toCollection$12.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                                channelsKt__DeprecatedKt$toCollection$12.L$3 = receiveChannel2;
                                channelsKt__DeprecatedKt$toCollection$12.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                                channelsKt__DeprecatedKt$toCollection$12.L$5 = it;
                                channelsKt__DeprecatedKt$toCollection$12.I$0 = i4;
                                channelsKt__DeprecatedKt$toCollection$12.I$1 = i3;
                                channelsKt__DeprecatedKt$toCollection$12.I$2 = i2;
                                channelsKt__DeprecatedKt$toCollection$12.label = 1;
                                hasNext = it.hasNext(channelsKt__DeprecatedKt$toCollection$12);
                                if (hasNext != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                int i9 = i4;
                                receiveChannel6 = receiveChannel2;
                                obj = hasNext;
                                channelIterator2 = it;
                                th4 = th2;
                                i8 = i9;
                                if (!((Boolean) obj).booleanValue()) {
                                    Unit unit = Unit.INSTANCE;
                                    ChannelsKt.cancelConsumed(receiveChannel6, th4);
                                    return c2;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                try {
                                    throw th;
                                } catch (Throwable th6) {
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    throw th6;
                                }
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel2 = receiveChannel6;
                        throw th;
                    }
                }
            }
        }
        channelsKt__DeprecatedKt$toCollection$1 = new ChannelsKt__DeprecatedKt$toCollection$1(continuation);
        Object obj2 = channelsKt__DeprecatedKt$toCollection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$toCollection$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00a8 A[Catch: all -> 0x0056, TryCatch #2 {all -> 0x0056, blocks: (B:59:0x0045, B:72:0x00a0, B:74:0x00a8, B:75:0x00be), top: B:90:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00be A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #2 {all -> 0x0056, blocks: (B:59:0x0045, B:72:0x00a0, B:74:0x00a8, B:75:0x00be), top: B:90:0x0045 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x009a -> B:72:0x00a0). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, M m, Continuation<? super M> continuation) {
        ChannelsKt__DeprecatedKt$toMap$2 channelsKt__DeprecatedKt$toMap$2;
        int i;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel2;
        Throwable th;
        int i2;
        ChannelIterator<? extends Pair<? extends K, ? extends V>> it;
        ChannelsKt__DeprecatedKt$toMap$2 channelsKt__DeprecatedKt$toMap$22;
        int i3;
        int i4;
        Throwable th2;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel3;
        Map map;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel4;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$toMap$2) {
            channelsKt__DeprecatedKt$toMap$2 = (ChannelsKt__DeprecatedKt$toMap$2) continuation;
            if ((channelsKt__DeprecatedKt$toMap$2.label & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$toMap$2.label -= Integer.MIN_VALUE;
                Object obj = channelsKt__DeprecatedKt$toMap$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$toMap$2.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        i2 = 0;
                        it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$toMap$22 = channelsKt__DeprecatedKt$toMap$2;
                        i3 = 0;
                        i4 = 0;
                        th2 = null;
                        receiveChannel2 = receiveChannel;
                        receiveChannel3 = receiveChannel2;
                        map = m;
                        receiveChannel4 = receiveChannel3;
                        channelsKt__DeprecatedKt$toMap$22.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__DeprecatedKt$toMap$22.L$1 = map;
                        channelsKt__DeprecatedKt$toMap$22.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                        channelsKt__DeprecatedKt$toMap$22.L$3 = receiveChannel2;
                        channelsKt__DeprecatedKt$toMap$22.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                        channelsKt__DeprecatedKt$toMap$22.L$5 = it;
                        channelsKt__DeprecatedKt$toMap$22.I$0 = i4;
                        channelsKt__DeprecatedKt$toMap$22.I$1 = i3;
                        channelsKt__DeprecatedKt$toMap$22.I$2 = i2;
                        channelsKt__DeprecatedKt$toMap$22.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$toMap$22);
                        if (hasNext != coroutine_suspended) {
                        }
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i5 = channelsKt__DeprecatedKt$toMap$2.I$2;
                    int i6 = channelsKt__DeprecatedKt$toMap$2.I$1;
                    int i7 = channelsKt__DeprecatedKt$toMap$2.I$0;
                    ChannelIterator<? extends Pair<? extends K, ? extends V>> channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$toMap$2.L$5;
                    ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel5 = (ReceiveChannel) channelsKt__DeprecatedKt$toMap$2.L$4;
                    ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel6 = (ReceiveChannel) channelsKt__DeprecatedKt$toMap$2.L$3;
                    ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel7 = (ReceiveChannel) channelsKt__DeprecatedKt$toMap$2.L$2;
                    Map map2 = (Map) channelsKt__DeprecatedKt$toMap$2.L$1;
                    ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel8 = (ReceiveChannel) channelsKt__DeprecatedKt$toMap$2.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        i2 = i5;
                        receiveChannel = receiveChannel8;
                        ChannelIterator<? extends Pair<? extends K, ? extends V>> channelIterator2 = channelIterator;
                        i3 = i6;
                        receiveChannel4 = receiveChannel7;
                        int i8 = i7;
                        channelsKt__DeprecatedKt$toMap$22 = channelsKt__DeprecatedKt$toMap$2;
                        receiveChannel3 = receiveChannel5;
                        Throwable th4 = null;
                        map = map2;
                        if (!((Boolean) obj).booleanValue()) {
                            Pair<? extends K, ? extends V> next = channelIterator2.next();
                            map.put(next.getFirst(), next.getSecond());
                            receiveChannel2 = receiveChannel6;
                            i4 = i8;
                            th2 = th4;
                            it = channelIterator2;
                            try {
                                channelsKt__DeprecatedKt$toMap$22.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                                channelsKt__DeprecatedKt$toMap$22.L$1 = map;
                                channelsKt__DeprecatedKt$toMap$22.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                                channelsKt__DeprecatedKt$toMap$22.L$3 = receiveChannel2;
                                channelsKt__DeprecatedKt$toMap$22.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                                channelsKt__DeprecatedKt$toMap$22.L$5 = it;
                                channelsKt__DeprecatedKt$toMap$22.I$0 = i4;
                                channelsKt__DeprecatedKt$toMap$22.I$1 = i3;
                                channelsKt__DeprecatedKt$toMap$22.I$2 = i2;
                                channelsKt__DeprecatedKt$toMap$22.label = 1;
                                hasNext = it.hasNext(channelsKt__DeprecatedKt$toMap$22);
                                if (hasNext != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                int i9 = i4;
                                receiveChannel6 = receiveChannel2;
                                obj = hasNext;
                                channelIterator2 = it;
                                th4 = th2;
                                i8 = i9;
                                if (!((Boolean) obj).booleanValue()) {
                                    Unit unit = Unit.INSTANCE;
                                    ChannelsKt.cancelConsumed(receiveChannel6, th4);
                                    return map;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                try {
                                    throw th;
                                } catch (Throwable th6) {
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    throw th6;
                                }
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel2 = receiveChannel6;
                        throw th;
                    }
                }
            }
        }
        channelsKt__DeprecatedKt$toMap$2 = new ChannelsKt__DeprecatedKt$toMap$2(continuation);
        Object obj2 = channelsKt__DeprecatedKt$toMap$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$toMap$2.label;
        if (i != 0) {
        }
    }

    public static /* synthetic */ ReceiveChannel flatMap$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        ReceiveChannel flatMap;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        flatMap = flatMap(receiveChannel, coroutineContext, function2);
        return flatMap;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel flatMap(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$flatMap$1(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel map$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.map(receiveChannel, coroutineContext, function2);
    }

    public static final <E, R> ReceiveChannel<R> map(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$map$1(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel mapIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.mapIndexed(receiveChannel, coroutineContext, function3);
    }

    public static final <E, R> ReceiveChannel<R> mapIndexed(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$mapIndexed$1(receiveChannel, function3, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel mapIndexedNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        ReceiveChannel mapIndexedNotNull;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        mapIndexedNotNull = mapIndexedNotNull(receiveChannel, coroutineContext, function3);
        return mapIndexedNotNull;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapIndexedNotNull(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3) {
        return ChannelsKt.filterNotNull(ChannelsKt.mapIndexed(receiveChannel, coroutineContext, function3));
    }

    public static /* synthetic */ ReceiveChannel mapNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        ReceiveChannel mapNotNull;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        mapNotNull = mapNotNull(receiveChannel, coroutineContext, function2);
        return mapNotNull;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapNotNull(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt.filterNotNull(ChannelsKt.map(receiveChannel, coroutineContext, function2));
    }

    public static /* synthetic */ ReceiveChannel withIndex$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, int i, Object obj) {
        ReceiveChannel withIndex;
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        withIndex = withIndex(receiveChannel, coroutineContext);
        return withIndex;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel withIndex(ReceiveChannel receiveChannel, CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$withIndex$1(receiveChannel, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel distinctBy$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.distinctBy(receiveChannel, coroutineContext, function2);
    }

    public static final <E, K> ReceiveChannel<E> distinctBy(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new ChannelsKt__DeprecatedKt$distinctBy$1(receiveChannel, function2, null), 6, null);
    }

    public static final <E> Object toMutableSet(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Set<E>> continuation) {
        return ChannelsKt.toCollection(receiveChannel, new LinkedHashSet(), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0042  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object any(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$any$1 channelsKt__DeprecatedKt$any$1;
        int i;
        try {
            if (continuation instanceof ChannelsKt__DeprecatedKt$any$1) {
                channelsKt__DeprecatedKt$any$1 = (ChannelsKt__DeprecatedKt$any$1) continuation;
                if ((channelsKt__DeprecatedKt$any$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__DeprecatedKt$any$1.label -= Integer.MIN_VALUE;
                    Object obj = channelsKt__DeprecatedKt$any$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__DeprecatedKt$any$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$any$1.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__DeprecatedKt$any$1.L$1 = receiveChannel;
                        channelsKt__DeprecatedKt$any$1.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__DeprecatedKt$any$1.I$0 = 0;
                        channelsKt__DeprecatedKt$any$1.I$1 = 0;
                        channelsKt__DeprecatedKt$any$1.label = 1;
                        obj = it.hasNext(channelsKt__DeprecatedKt$any$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        int i2 = channelsKt__DeprecatedKt$any$1.I$1;
                        int i3 = channelsKt__DeprecatedKt$any$1.I$0;
                        ReceiveChannel receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$any$1.L$2;
                        receiveChannel = (ReceiveChannel) channelsKt__DeprecatedKt$any$1.L$1;
                        ReceiveChannel receiveChannel3 = (ReceiveChannel) channelsKt__DeprecatedKt$any$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    ChannelsKt.cancelConsumed(receiveChannel, null);
                    return obj;
                }
            }
            if (i != 0) {
            }
            ChannelsKt.cancelConsumed(receiveChannel, null);
            return obj;
        } finally {
        }
        channelsKt__DeprecatedKt$any$1 = new ChannelsKt__DeprecatedKt$any$1(continuation);
        Object obj2 = channelsKt__DeprecatedKt$any$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$any$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00aa A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:72:0x00a2, B:74:0x00aa, B:68:0x0076, B:75:0x00b6), top: B:86:0x00a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00b6 A[Catch: all -> 0x00c2, TRY_LEAVE, TryCatch #0 {all -> 0x00c2, blocks: (B:72:0x00a2, B:74:0x00aa, B:68:0x0076, B:75:0x00b6), top: B:86:0x00a2 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x009d -> B:86:0x00a2). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object count(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$count$1 channelsKt__DeprecatedKt$count$1;
        int i;
        ReceiveChannel receiveChannel2;
        Throwable th;
        int i2;
        Ref.IntRef intRef;
        ChannelIterator it;
        Throwable th2;
        int i3;
        int i4;
        ReceiveChannel receiveChannel3;
        ReceiveChannel receiveChannel4;
        ChannelsKt__DeprecatedKt$count$1 channelsKt__DeprecatedKt$count$12;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__DeprecatedKt$count$1) {
                channelsKt__DeprecatedKt$count$1 = (ChannelsKt__DeprecatedKt$count$1) continuation;
                if ((channelsKt__DeprecatedKt$count$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__DeprecatedKt$count$1.label -= Integer.MIN_VALUE;
                    Object obj = channelsKt__DeprecatedKt$count$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__DeprecatedKt$count$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        try {
                            i2 = 0;
                            intRef = new Ref.IntRef();
                            it = receiveChannel.iterator();
                            th2 = null;
                            i3 = 0;
                            i4 = 0;
                            receiveChannel3 = receiveChannel;
                            receiveChannel4 = receiveChannel3;
                            channelsKt__DeprecatedKt$count$12 = channelsKt__DeprecatedKt$count$1;
                            receiveChannel2 = receiveChannel4;
                            channelsKt__DeprecatedKt$count$12.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                            channelsKt__DeprecatedKt$count$12.L$1 = intRef;
                            channelsKt__DeprecatedKt$count$12.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                            channelsKt__DeprecatedKt$count$12.L$3 = receiveChannel2;
                            channelsKt__DeprecatedKt$count$12.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                            channelsKt__DeprecatedKt$count$12.L$5 = it;
                            channelsKt__DeprecatedKt$count$12.I$0 = i4;
                            channelsKt__DeprecatedKt$count$12.I$1 = i3;
                            channelsKt__DeprecatedKt$count$12.I$2 = i2;
                            channelsKt__DeprecatedKt$count$12.label = 1;
                            hasNext = it.hasNext(channelsKt__DeprecatedKt$count$12);
                            if (hasNext != coroutine_suspended) {
                            }
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        int i5 = channelsKt__DeprecatedKt$count$1.I$2;
                        int i6 = channelsKt__DeprecatedKt$count$1.I$1;
                        int i7 = channelsKt__DeprecatedKt$count$1.I$0;
                        ChannelIterator channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$count$1.L$5;
                        ReceiveChannel receiveChannel5 = (ReceiveChannel) channelsKt__DeprecatedKt$count$1.L$4;
                        ReceiveChannel receiveChannel6 = (ReceiveChannel) channelsKt__DeprecatedKt$count$1.L$3;
                        ReceiveChannel receiveChannel7 = (ReceiveChannel) channelsKt__DeprecatedKt$count$1.L$2;
                        Ref.IntRef intRef2 = (Ref.IntRef) channelsKt__DeprecatedKt$count$1.L$1;
                        ReceiveChannel receiveChannel8 = (ReceiveChannel) channelsKt__DeprecatedKt$count$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            i2 = i5;
                            receiveChannel = receiveChannel8;
                            Ref.IntRef intRef3 = intRef2;
                            ChannelIterator channelIterator2 = channelIterator;
                            i3 = i6;
                            receiveChannel4 = receiveChannel5;
                            th2 = null;
                            channelsKt__DeprecatedKt$count$12 = channelsKt__DeprecatedKt$count$1;
                            receiveChannel2 = receiveChannel6;
                            i4 = i7;
                            try {
                                if (!((Boolean) obj).booleanValue()) {
                                    channelIterator2.next();
                                    intRef3.element++;
                                    receiveChannel3 = receiveChannel7;
                                    it = channelIterator2;
                                    intRef = intRef3;
                                    channelsKt__DeprecatedKt$count$12.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                                    channelsKt__DeprecatedKt$count$12.L$1 = intRef;
                                    channelsKt__DeprecatedKt$count$12.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                                    channelsKt__DeprecatedKt$count$12.L$3 = receiveChannel2;
                                    channelsKt__DeprecatedKt$count$12.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                                    channelsKt__DeprecatedKt$count$12.L$5 = it;
                                    channelsKt__DeprecatedKt$count$12.I$0 = i4;
                                    channelsKt__DeprecatedKt$count$12.I$1 = i3;
                                    channelsKt__DeprecatedKt$count$12.I$2 = i2;
                                    channelsKt__DeprecatedKt$count$12.label = 1;
                                    hasNext = it.hasNext(channelsKt__DeprecatedKt$count$12);
                                    if (hasNext != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    ChannelIterator channelIterator3 = it;
                                    receiveChannel7 = receiveChannel3;
                                    obj = hasNext;
                                    intRef3 = intRef;
                                    channelIterator2 = channelIterator3;
                                    if (!((Boolean) obj).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                                        return Boxing.boxInt(intRef3.element);
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            receiveChannel2 = receiveChannel6;
                        }
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th6) {
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            throw th6;
        }
        channelsKt__DeprecatedKt$count$1 = new ChannelsKt__DeprecatedKt$count$1(continuation);
        Object obj2 = channelsKt__DeprecatedKt$count$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$count$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00f4 A[Catch: all -> 0x010e, TRY_LEAVE, TryCatch #3 {all -> 0x010e, blocks: (B:101:0x00ec, B:103:0x00f4, B:97:0x00c6, B:92:0x00b0, B:96:0x00bc, B:88:0x0087), top: B:122:0x0087 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00bc A[Catch: all -> 0x010e, TRY_ENTER, TryCatch #3 {all -> 0x010e, blocks: (B:101:0x00ec, B:103:0x00f4, B:97:0x00c6, B:92:0x00b0, B:96:0x00bc, B:88:0x0087), top: B:122:0x0087 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:0x00e7 -> B:77:0x004a). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object maxWith(ReceiveChannel receiveChannel, Comparator comparator, Continuation continuation) {
        ChannelsKt__DeprecatedKt$maxWith$1 channelsKt__DeprecatedKt$maxWith$1;
        int i;
        int i2;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        Object obj;
        ReceiveChannel receiveChannel3;
        int i3;
        ReceiveChannel receiveChannel4;
        Comparator comparator2;
        int i4;
        Object next;
        ReceiveChannel receiveChannel5;
        ChannelIterator channelIterator2;
        Throwable th;
        ReceiveChannel receiveChannel6;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$maxWith$1) {
            channelsKt__DeprecatedKt$maxWith$1 = (ChannelsKt__DeprecatedKt$maxWith$1) continuation;
            if ((channelsKt__DeprecatedKt$maxWith$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$maxWith$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__DeprecatedKt$maxWith$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$maxWith$1.label;
                Throwable th2 = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$maxWith$1.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__DeprecatedKt$maxWith$1.L$1 = comparator;
                        channelsKt__DeprecatedKt$maxWith$1.L$2 = receiveChannel;
                        channelsKt__DeprecatedKt$maxWith$1.L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__DeprecatedKt$maxWith$1.L$4 = it;
                        i2 = 0;
                        channelsKt__DeprecatedKt$maxWith$1.I$0 = 0;
                        channelsKt__DeprecatedKt$maxWith$1.I$1 = 0;
                        channelsKt__DeprecatedKt$maxWith$1.label = 1;
                        Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$maxWith$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext2;
                        receiveChannel3 = receiveChannel2;
                        i3 = 0;
                    } catch (Throwable th3) {
                        receiveChannel6 = receiveChannel;
                        th = th3;
                    }
                } else {
                    if (i == 1) {
                        int i5 = channelsKt__DeprecatedKt$maxWith$1.I$1;
                        int i6 = channelsKt__DeprecatedKt$maxWith$1.I$0;
                        ChannelIterator channelIterator3 = (ChannelIterator) channelsKt__DeprecatedKt$maxWith$1.L$4;
                        receiveChannel3 = (ReceiveChannel) channelsKt__DeprecatedKt$maxWith$1.L$3;
                        receiveChannel6 = (ReceiveChannel) channelsKt__DeprecatedKt$maxWith$1.L$2;
                        Comparator comparator3 = (Comparator) channelsKt__DeprecatedKt$maxWith$1.L$1;
                        receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$maxWith$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            i2 = i5;
                            receiveChannel = receiveChannel6;
                            obj = obj2;
                            i3 = i6;
                            comparator = comparator3;
                            channelIterator = channelIterator3;
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } else if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        int i7 = channelsKt__DeprecatedKt$maxWith$1.I$1;
                        i4 = channelsKt__DeprecatedKt$maxWith$1.I$0;
                        next = channelsKt__DeprecatedKt$maxWith$1.L$5;
                        channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$maxWith$1.L$4;
                        receiveChannel5 = (ReceiveChannel) channelsKt__DeprecatedKt$maxWith$1.L$3;
                        ReceiveChannel receiveChannel7 = (ReceiveChannel) channelsKt__DeprecatedKt$maxWith$1.L$2;
                        comparator2 = (Comparator) channelsKt__DeprecatedKt$maxWith$1.L$1;
                        receiveChannel4 = (ReceiveChannel) channelsKt__DeprecatedKt$maxWith$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            ChannelsKt__DeprecatedKt$maxWith$1 channelsKt__DeprecatedKt$maxWith$12 = channelsKt__DeprecatedKt$maxWith$1;
                            int i8 = i7;
                            receiveChannel = receiveChannel7;
                            ReceiveChannel receiveChannel8 = receiveChannel5;
                            Throwable th5 = th2;
                            ChannelIterator channelIterator4 = channelIterator2;
                            Object obj3 = next;
                            ChannelsKt__DeprecatedKt$maxWith$1 channelsKt__DeprecatedKt$maxWith$13 = channelsKt__DeprecatedKt$maxWith$12;
                            if (!((Boolean) obj2).booleanValue()) {
                                Object next2 = channelIterator4.next();
                                if (comparator2.compare(obj3, next2) < 0) {
                                    next = next2;
                                    i2 = i8;
                                    channelsKt__DeprecatedKt$maxWith$1 = channelsKt__DeprecatedKt$maxWith$13;
                                } else {
                                    i2 = i8;
                                    channelsKt__DeprecatedKt$maxWith$1 = channelsKt__DeprecatedKt$maxWith$13;
                                    next = obj3;
                                }
                                channelIterator2 = channelIterator4;
                                th2 = th5;
                                receiveChannel5 = receiveChannel8;
                                channelsKt__DeprecatedKt$maxWith$1.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                                channelsKt__DeprecatedKt$maxWith$1.L$1 = comparator2;
                                channelsKt__DeprecatedKt$maxWith$1.L$2 = receiveChannel;
                                channelsKt__DeprecatedKt$maxWith$1.L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                                channelsKt__DeprecatedKt$maxWith$1.L$4 = channelIterator2;
                                channelsKt__DeprecatedKt$maxWith$1.L$5 = next;
                                channelsKt__DeprecatedKt$maxWith$1.I$0 = i4;
                                channelsKt__DeprecatedKt$maxWith$1.I$1 = i2;
                                channelsKt__DeprecatedKt$maxWith$1.label = 2;
                                hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$maxWith$1);
                                if (hasNext != coroutine_suspended) {
                                    channelsKt__DeprecatedKt$maxWith$12 = channelsKt__DeprecatedKt$maxWith$1;
                                    i8 = i2;
                                    obj2 = hasNext;
                                    ReceiveChannel receiveChannel82 = receiveChannel5;
                                    Throwable th52 = th2;
                                    ChannelIterator channelIterator42 = channelIterator2;
                                    Object obj32 = next;
                                    ChannelsKt__DeprecatedKt$maxWith$1 channelsKt__DeprecatedKt$maxWith$132 = channelsKt__DeprecatedKt$maxWith$12;
                                    if (!((Boolean) obj2).booleanValue()) {
                                        ChannelsKt.cancelConsumed(receiveChannel, th52);
                                        return obj32;
                                    }
                                }
                                return coroutine_suspended;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            receiveChannel6 = receiveChannel7;
                        }
                    }
                    try {
                        throw th;
                    } catch (Throwable th7) {
                        ChannelsKt.cancelConsumed(receiveChannel6, th);
                        throw th7;
                    }
                }
                if (!((Boolean) obj).booleanValue()) {
                    receiveChannel4 = receiveChannel2;
                    comparator2 = comparator;
                    i4 = i3;
                    next = channelIterator.next();
                    receiveChannel5 = receiveChannel3;
                    channelIterator2 = channelIterator;
                    channelsKt__DeprecatedKt$maxWith$1.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                    channelsKt__DeprecatedKt$maxWith$1.L$1 = comparator2;
                    channelsKt__DeprecatedKt$maxWith$1.L$2 = receiveChannel;
                    channelsKt__DeprecatedKt$maxWith$1.L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                    channelsKt__DeprecatedKt$maxWith$1.L$4 = channelIterator2;
                    channelsKt__DeprecatedKt$maxWith$1.L$5 = next;
                    channelsKt__DeprecatedKt$maxWith$1.I$0 = i4;
                    channelsKt__DeprecatedKt$maxWith$1.I$1 = i2;
                    channelsKt__DeprecatedKt$maxWith$1.label = 2;
                    hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$maxWith$1);
                    if (hasNext != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                ChannelsKt.cancelConsumed(receiveChannel, null);
                return null;
            }
        }
        channelsKt__DeprecatedKt$maxWith$1 = new ChannelsKt__DeprecatedKt$maxWith$1(continuation);
        Object obj22 = channelsKt__DeprecatedKt$maxWith$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$maxWith$1.label;
        Throwable th22 = null;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00f4 A[Catch: all -> 0x010e, TRY_LEAVE, TryCatch #3 {all -> 0x010e, blocks: (B:101:0x00ec, B:103:0x00f4, B:97:0x00c6, B:92:0x00b0, B:96:0x00bc, B:88:0x0087), top: B:122:0x0087 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00bc A[Catch: all -> 0x010e, TRY_ENTER, TryCatch #3 {all -> 0x010e, blocks: (B:101:0x00ec, B:103:0x00f4, B:97:0x00c6, B:92:0x00b0, B:96:0x00bc, B:88:0x0087), top: B:122:0x0087 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:0x00e7 -> B:77:0x004a). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object minWith(ReceiveChannel receiveChannel, Comparator comparator, Continuation continuation) {
        ChannelsKt__DeprecatedKt$minWith$1 channelsKt__DeprecatedKt$minWith$1;
        int i;
        int i2;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        Object obj;
        ReceiveChannel receiveChannel3;
        int i3;
        ReceiveChannel receiveChannel4;
        Comparator comparator2;
        int i4;
        Object next;
        ReceiveChannel receiveChannel5;
        ChannelIterator channelIterator2;
        Throwable th;
        ReceiveChannel receiveChannel6;
        Object hasNext;
        if (continuation instanceof ChannelsKt__DeprecatedKt$minWith$1) {
            channelsKt__DeprecatedKt$minWith$1 = (ChannelsKt__DeprecatedKt$minWith$1) continuation;
            if ((channelsKt__DeprecatedKt$minWith$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__DeprecatedKt$minWith$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__DeprecatedKt$minWith$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__DeprecatedKt$minWith$1.label;
                Throwable th2 = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    try {
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$minWith$1.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__DeprecatedKt$minWith$1.L$1 = comparator;
                        channelsKt__DeprecatedKt$minWith$1.L$2 = receiveChannel;
                        channelsKt__DeprecatedKt$minWith$1.L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__DeprecatedKt$minWith$1.L$4 = it;
                        i2 = 0;
                        channelsKt__DeprecatedKt$minWith$1.I$0 = 0;
                        channelsKt__DeprecatedKt$minWith$1.I$1 = 0;
                        channelsKt__DeprecatedKt$minWith$1.label = 1;
                        Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$minWith$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                        obj = hasNext2;
                        receiveChannel3 = receiveChannel2;
                        i3 = 0;
                    } catch (Throwable th3) {
                        receiveChannel6 = receiveChannel;
                        th = th3;
                    }
                } else {
                    if (i == 1) {
                        int i5 = channelsKt__DeprecatedKt$minWith$1.I$1;
                        int i6 = channelsKt__DeprecatedKt$minWith$1.I$0;
                        ChannelIterator channelIterator3 = (ChannelIterator) channelsKt__DeprecatedKt$minWith$1.L$4;
                        receiveChannel3 = (ReceiveChannel) channelsKt__DeprecatedKt$minWith$1.L$3;
                        receiveChannel6 = (ReceiveChannel) channelsKt__DeprecatedKt$minWith$1.L$2;
                        Comparator comparator3 = (Comparator) channelsKt__DeprecatedKt$minWith$1.L$1;
                        receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$minWith$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            i2 = i5;
                            receiveChannel = receiveChannel6;
                            obj = obj2;
                            i3 = i6;
                            comparator = comparator3;
                            channelIterator = channelIterator3;
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } else if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        int i7 = channelsKt__DeprecatedKt$minWith$1.I$1;
                        i4 = channelsKt__DeprecatedKt$minWith$1.I$0;
                        next = channelsKt__DeprecatedKt$minWith$1.L$5;
                        channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$minWith$1.L$4;
                        receiveChannel5 = (ReceiveChannel) channelsKt__DeprecatedKt$minWith$1.L$3;
                        ReceiveChannel receiveChannel7 = (ReceiveChannel) channelsKt__DeprecatedKt$minWith$1.L$2;
                        comparator2 = (Comparator) channelsKt__DeprecatedKt$minWith$1.L$1;
                        receiveChannel4 = (ReceiveChannel) channelsKt__DeprecatedKt$minWith$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            ChannelsKt__DeprecatedKt$minWith$1 channelsKt__DeprecatedKt$minWith$12 = channelsKt__DeprecatedKt$minWith$1;
                            int i8 = i7;
                            receiveChannel = receiveChannel7;
                            ReceiveChannel receiveChannel8 = receiveChannel5;
                            Throwable th5 = th2;
                            ChannelIterator channelIterator4 = channelIterator2;
                            Object obj3 = next;
                            ChannelsKt__DeprecatedKt$minWith$1 channelsKt__DeprecatedKt$minWith$13 = channelsKt__DeprecatedKt$minWith$12;
                            if (!((Boolean) obj2).booleanValue()) {
                                Object next2 = channelIterator4.next();
                                if (comparator2.compare(obj3, next2) > 0) {
                                    next = next2;
                                    i2 = i8;
                                    channelsKt__DeprecatedKt$minWith$1 = channelsKt__DeprecatedKt$minWith$13;
                                } else {
                                    i2 = i8;
                                    channelsKt__DeprecatedKt$minWith$1 = channelsKt__DeprecatedKt$minWith$13;
                                    next = obj3;
                                }
                                channelIterator2 = channelIterator4;
                                th2 = th5;
                                receiveChannel5 = receiveChannel8;
                                channelsKt__DeprecatedKt$minWith$1.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                                channelsKt__DeprecatedKt$minWith$1.L$1 = comparator2;
                                channelsKt__DeprecatedKt$minWith$1.L$2 = receiveChannel;
                                channelsKt__DeprecatedKt$minWith$1.L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                                channelsKt__DeprecatedKt$minWith$1.L$4 = channelIterator2;
                                channelsKt__DeprecatedKt$minWith$1.L$5 = next;
                                channelsKt__DeprecatedKt$minWith$1.I$0 = i4;
                                channelsKt__DeprecatedKt$minWith$1.I$1 = i2;
                                channelsKt__DeprecatedKt$minWith$1.label = 2;
                                hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$minWith$1);
                                if (hasNext != coroutine_suspended) {
                                    channelsKt__DeprecatedKt$minWith$12 = channelsKt__DeprecatedKt$minWith$1;
                                    i8 = i2;
                                    obj2 = hasNext;
                                    ReceiveChannel receiveChannel82 = receiveChannel5;
                                    Throwable th52 = th2;
                                    ChannelIterator channelIterator42 = channelIterator2;
                                    Object obj32 = next;
                                    ChannelsKt__DeprecatedKt$minWith$1 channelsKt__DeprecatedKt$minWith$132 = channelsKt__DeprecatedKt$minWith$12;
                                    if (!((Boolean) obj2).booleanValue()) {
                                        ChannelsKt.cancelConsumed(receiveChannel, th52);
                                        return obj32;
                                    }
                                }
                                return coroutine_suspended;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            receiveChannel6 = receiveChannel7;
                        }
                    }
                    try {
                        throw th;
                    } catch (Throwable th7) {
                        ChannelsKt.cancelConsumed(receiveChannel6, th);
                        throw th7;
                    }
                }
                if (!((Boolean) obj).booleanValue()) {
                    receiveChannel4 = receiveChannel2;
                    comparator2 = comparator;
                    i4 = i3;
                    next = channelIterator.next();
                    receiveChannel5 = receiveChannel3;
                    channelIterator2 = channelIterator;
                    channelsKt__DeprecatedKt$minWith$1.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                    channelsKt__DeprecatedKt$minWith$1.L$1 = comparator2;
                    channelsKt__DeprecatedKt$minWith$1.L$2 = receiveChannel;
                    channelsKt__DeprecatedKt$minWith$1.L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                    channelsKt__DeprecatedKt$minWith$1.L$4 = channelIterator2;
                    channelsKt__DeprecatedKt$minWith$1.L$5 = next;
                    channelsKt__DeprecatedKt$minWith$1.I$0 = i4;
                    channelsKt__DeprecatedKt$minWith$1.I$1 = i2;
                    channelsKt__DeprecatedKt$minWith$1.label = 2;
                    hasNext = channelIterator2.hasNext(channelsKt__DeprecatedKt$minWith$1);
                    if (hasNext != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                ChannelsKt.cancelConsumed(receiveChannel, null);
                return null;
            }
        }
        channelsKt__DeprecatedKt$minWith$1 = new ChannelsKt__DeprecatedKt$minWith$1(continuation);
        Object obj22 = channelsKt__DeprecatedKt$minWith$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$minWith$1.label;
        Throwable th22 = null;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0042  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object none(ReceiveChannel receiveChannel, Continuation continuation) {
        ChannelsKt__DeprecatedKt$none$1 channelsKt__DeprecatedKt$none$1;
        int i;
        try {
            if (continuation instanceof ChannelsKt__DeprecatedKt$none$1) {
                channelsKt__DeprecatedKt$none$1 = (ChannelsKt__DeprecatedKt$none$1) continuation;
                if ((channelsKt__DeprecatedKt$none$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__DeprecatedKt$none$1.label -= Integer.MIN_VALUE;
                    Object obj = channelsKt__DeprecatedKt$none$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__DeprecatedKt$none$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        ChannelIterator it = receiveChannel.iterator();
                        channelsKt__DeprecatedKt$none$1.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__DeprecatedKt$none$1.L$1 = receiveChannel;
                        channelsKt__DeprecatedKt$none$1.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        channelsKt__DeprecatedKt$none$1.I$0 = 0;
                        channelsKt__DeprecatedKt$none$1.I$1 = 0;
                        channelsKt__DeprecatedKt$none$1.label = 1;
                        obj = it.hasNext(channelsKt__DeprecatedKt$none$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        int i2 = channelsKt__DeprecatedKt$none$1.I$1;
                        int i3 = channelsKt__DeprecatedKt$none$1.I$0;
                        ReceiveChannel receiveChannel2 = (ReceiveChannel) channelsKt__DeprecatedKt$none$1.L$2;
                        receiveChannel = (ReceiveChannel) channelsKt__DeprecatedKt$none$1.L$1;
                        ReceiveChannel receiveChannel3 = (ReceiveChannel) channelsKt__DeprecatedKt$none$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    Boolean boxBoolean = Boxing.boxBoolean(!((Boolean) obj).booleanValue());
                    ChannelsKt.cancelConsumed(receiveChannel, null);
                    return boxBoolean;
                }
            }
            if (i != 0) {
            }
            Boolean boxBoolean2 = Boxing.boxBoolean(!((Boolean) obj).booleanValue());
            ChannelsKt.cancelConsumed(receiveChannel, null);
            return boxBoolean2;
        } finally {
        }
        channelsKt__DeprecatedKt$none$1 = new ChannelsKt__DeprecatedKt$none$1(continuation);
        Object obj2 = channelsKt__DeprecatedKt$none$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__DeprecatedKt$none$1.label;
    }

    public static /* synthetic */ ReceiveChannel zip$default(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.zip(receiveChannel, receiveChannel2, coroutineContext, function2);
    }

    public static final <E, R, V> ReceiveChannel<V> zip(ReceiveChannel<? extends E> receiveChannel, ReceiveChannel<? extends R> receiveChannel2, CoroutineContext coroutineContext, Function2<? super E, ? super R, ? extends V> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumesAll(receiveChannel, receiveChannel2), new ChannelsKt__DeprecatedKt$zip$2(receiveChannel2, receiveChannel, function2, null), 6, null);
    }

    public static final Function1<Throwable, Unit> consumes(final ReceiveChannel<?> receiveChannel) {
        return new Function1() { // from class: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit consumes$lambda$0$ChannelsKt__DeprecatedKt;
                consumes$lambda$0$ChannelsKt__DeprecatedKt = ChannelsKt__DeprecatedKt.consumes$lambda$0$ChannelsKt__DeprecatedKt(ReceiveChannel.this, (Throwable) obj);
                return consumes$lambda$0$ChannelsKt__DeprecatedKt;
            }
        };
    }

    public static final Unit consumes$lambda$0$ChannelsKt__DeprecatedKt(ReceiveChannel receiveChannel, Throwable th) {
        ChannelsKt.cancelConsumed(receiveChannel, th);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ ReceiveChannel produce$default(CoroutineScope coroutineScope, Job job, int i, Function2 function2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return ChannelsKt.produce(coroutineScope, job, i, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Passing a Job to coroutine builders breaks structured concurrency, leading to hard-to-diagnose errors. This pattern should be avoided. This overload will be deprecated with an error in the future.")
    public static final <E> ReceiveChannel<E> produce(CoroutineScope coroutineScope, Job job, int i, Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNull(job, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext");
        return ProduceKt.produce(coroutineScope, job, i, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    private static final <E> Object consumeEach$$forInline(BroadcastChannel<E> broadcastChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        ReceiveChannel<E> openSubscription = broadcastChannel.openSubscription();
        try {
            ReceiveChannel<E> receiveChannel = openSubscription;
            ChannelIterator<E> it = openSubscription.iterator();
            while (((Boolean) it.hasNext(null)).booleanValue()) {
                function1.invoke(it.next());
            }
            Unit unit = Unit.INSTANCE;
            ReceiveChannel.cancel$default((ReceiveChannel) openSubscription, (CancellationException) null, 1, (Object) null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            ReceiveChannel.cancel$default((ReceiveChannel) openSubscription, (CancellationException) null, 1, (Object) null);
            throw th;
        }
    }
}
