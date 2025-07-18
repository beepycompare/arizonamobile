package kotlinx.collections.immutable.implementations.immutableMap;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.collections.immutable.internal.CommonFunctionsKt;
import kotlinx.collections.immutable.internal.DeltaCounter;
import kotlinx.collections.immutable.internal.MutabilityOwnership;
/* compiled from: TrieNode.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u0085\u0001*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0004\u0084\u0001\u0085\u0001B1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fB)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b¢\u0006\u0004\b\u000b\u0010\rJ\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000fH\u0002J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000fH\u0002J\r\u0010\u0015\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0016J\u0015\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u001aJ\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0015\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u001dJ\u0015\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u001fJ\u0015\u0010 \u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\"J\u0015\u0010#\u001a\u00028\u00012\u0006\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\"J!\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001e\u001a\u00020\u0005H\u0000¢\u0006\u0002\b%J1\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010'\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010(J9\u0010)\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010'\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00012\u0006\u0010*\u001a\u00020\nH\u0002¢\u0006\u0002\u0010+J)\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010-J=\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00028\u00012\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0002¢\u0006\u0002\u00101JD\u00102\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\nH\u0002J&\u00104\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J.\u00105\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\nH\u0002JO\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00028\u00002\u0006\u00109\u001a\u00028\u00012\u0006\u0010:\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010;JI\u0010<\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00028\u00002\u0006\u00109\u001a\u00028\u00012\u0006\u0010:\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010=JQ\u0010>\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00028\u00002\u0006\u00109\u001a\u00028\u00012\u0006\u0010:\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\nH\u0002¢\u0006\u0002\u0010?J[\u0010@\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00028\u00002\u0006\u0010C\u001a\u00028\u00012\u0006\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00028\u00002\u0006\u0010F\u001a\u00028\u00012\u0006\u0010:\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010GJ&\u0010H\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J:\u0010I\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0002J\u001e\u0010J\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010K\u001a\u00020\u0005H\u0002J2\u0010L\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010K\u001a\u00020\u00052\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0002J\u0012\u0010M\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u0003H\u0002J\u0015\u0010N\u001a\u00020\u00182\u0006\u0010'\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010OJ\u0017\u0010P\u001a\u0004\u0018\u00018\u00012\u0006\u0010'\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010QJ+\u0010R\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000f2\u0006\u0010'\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010SJ=\u0010T\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010'\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00012\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0002¢\u0006\u0002\u0010UJ#\u0010V\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010'\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010WJ7\u0010X\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010'\u001a\u00028\u00002\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0002¢\u0006\u0002\u0010YJ+\u0010V\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010'\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010ZJ?\u0010X\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010'\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00012\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0002¢\u0006\u0002\u0010UJ8\u0010[\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010\\\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010]\u001a\u00020^2\u0006\u0010*\u001a\u00020\nH\u0002JT\u0010_\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010\\\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u00052\u0006\u0010]\u001a\u00020^2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0002J\b\u0010`\u001a\u00020\u0005H\u0002J\u001c\u0010a\u001a\u00020\u00182\u0012\u0010\\\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002J#\u0010b\u001a\u00020\u00182\u0006\u0010c\u001a\u00020\u00052\u0006\u0010'\u001a\u00028\u00002\u0006\u0010:\u001a\u00020\u0005¢\u0006\u0002\u0010dJ%\u0010e\u001a\u0004\u0018\u00018\u00012\u0006\u0010c\u001a\u00020\u00052\u0006\u0010'\u001a\u00028\u00002\u0006\u0010:\u001a\u00020\u0005¢\u0006\u0002\u0010fJJ\u0010g\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010\\\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010:\u001a\u00020\u00052\u0006\u0010]\u001a\u00020^2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100J9\u0010h\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000f2\u0006\u0010c\u001a\u00020\u00052\u0006\u0010'\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00012\u0006\u0010:\u001a\u00020\u0005¢\u0006\u0002\u0010iJK\u0010j\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010c\u001a\u00020\u00052\u0006\u0010'\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00012\u0006\u0010:\u001a\u00020\u00052\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100¢\u0006\u0002\u0010kJ1\u0010l\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010c\u001a\u00020\u00052\u0006\u0010'\u001a\u00028\u00002\u0006\u0010:\u001a\u00020\u0005¢\u0006\u0002\u0010mJP\u0010n\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0012\u0010o\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0002JE\u0010p\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010c\u001a\u00020\u00052\u0006\u0010'\u001a\u00028\u00002\u0006\u0010:\u001a\u00020\u00052\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100¢\u0006\u0002\u0010qJD\u0010r\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\nH\u0002J9\u0010l\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010c\u001a\u00020\u00052\u0006\u0010'\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00012\u0006\u0010:\u001a\u00020\u0005¢\u0006\u0002\u0010sJM\u0010p\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010c\u001a\u00020\u00052\u0006\u0010'\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00012\u0006\u0010:\u001a\u00020\u00052\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100¢\u0006\u0002\u0010kJG\u0010t\u001a\u00020\u0018\"\u0004\b\u0002\u0010u\"\u0004\b\u0003\u0010v2\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u0002Hu\u0012\u0004\u0012\u0002Hv0\u00002\u0018\u0010x\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002Hv\u0012\u0004\u0012\u00020\u00180yH\u0000¢\u0006\u0002\bzJ\u009a\u0001\u0010{\u001a\u00020|2\u0089\u0001\u0010}\u001a\u0084\u0001\u0012!\u0012\u001f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u000e\b\u007f\u0012\n\b\u0080\u0001\u0012\u0005\b\b(\u0081\u0001\u0012\u0014\u0012\u00120\u0005¢\u0006\r\b\u007f\u0012\t\b\u0080\u0001\u0012\u0004\b\b(:\u0012\u0015\u0012\u00130\u0005¢\u0006\u000e\b\u007f\u0012\n\b\u0080\u0001\u0012\u0005\b\b(\u0082\u0001\u0012\u0014\u0012\u00120\u0005¢\u0006\r\b\u007f\u0012\t\b\u0080\u0001\u0012\u0004\b\b(\u0004\u0012\u0014\u0012\u00120\u0005¢\u0006\r\b\u007f\u0012\t\b\u0080\u0001\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020|0~H\u0000¢\u0006\u0003\b\u0083\u0001J¥\u0001\u0010{\u001a\u00020|2\u0089\u0001\u0010}\u001a\u0084\u0001\u0012!\u0012\u001f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u000e\b\u007f\u0012\n\b\u0080\u0001\u0012\u0005\b\b(\u0081\u0001\u0012\u0014\u0012\u00120\u0005¢\u0006\r\b\u007f\u0012\t\b\u0080\u0001\u0012\u0004\b\b(:\u0012\u0015\u0012\u00130\u0005¢\u0006\u000e\b\u007f\u0012\n\b\u0080\u0001\u0012\u0005\b\b(\u0082\u0001\u0012\u0014\u0012\u00120\u0005¢\u0006\r\b\u007f\u0012\t\b\u0080\u0001\u0012\u0004\b\b(\u0004\u0012\u0014\u0012\u00120\u0005¢\u0006\r\b\u007f\u0012\t\b\u0080\u0001\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020|0~2\u0007\u0010\u0082\u0001\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b@BX\u0080\u000e¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0086\u0001"}, d2 = {"Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "dataMap", "", "nodeMap", "buffer", "", "ownedBy", "Lkotlinx/collections/immutable/internal/MutabilityOwnership;", "<init>", "(II[Ljava/lang/Object;Lkotlinx/collections/immutable/internal/MutabilityOwnership;)V", "(II[Ljava/lang/Object;)V", "asInsertResult", "Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "asUpdateResult", "value", "getBuffer$kotlinx_collections_immutable", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "entryCount", "entryCount$kotlinx_collections_immutable", "hasEntryAt", "", "positionMask", "hasEntryAt$kotlinx_collections_immutable", "hasNodeAt", "entryKeyIndex", "entryKeyIndex$kotlinx_collections_immutable", "nodeIndex", "nodeIndex$kotlinx_collections_immutable", "keyAtIndex", "keyIndex", "(I)Ljava/lang/Object;", "valueAtKeyIndex", "nodeAtIndex", "nodeAtIndex$kotlinx_collections_immutable", "insertEntryAt", "key", "(ILjava/lang/Object;Ljava/lang/Object;)Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableInsertEntryAt", "owner", "(ILjava/lang/Object;Ljava/lang/Object;Lkotlinx/collections/immutable/internal/MutabilityOwnership;)Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "updateValueAtIndex", "(ILjava/lang/Object;)Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableUpdateValueAtIndex", "mutator", "Lkotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "(ILjava/lang/Object;Lkotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "updateNodeAtIndex", "newNode", "removeNodeAtIndex", "mutableRemoveNodeAtIndex", "bufferMoveEntryToNode", "newKeyHash", "newKey", "newValue", "shift", "(IIILjava/lang/Object;Ljava/lang/Object;ILkotlinx/collections/immutable/internal/MutabilityOwnership;)[Ljava/lang/Object;", "moveEntryToNode", "(IIILjava/lang/Object;Ljava/lang/Object;I)Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableMoveEntryToNode", "(IIILjava/lang/Object;Ljava/lang/Object;ILkotlinx/collections/immutable/internal/MutabilityOwnership;)Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "makeNode", "keyHash1", "key1", "value1", "keyHash2", "key2", "value2", "(ILjava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;ILkotlinx/collections/immutable/internal/MutabilityOwnership;)Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "removeEntryAtIndex", "mutableRemoveEntryAtIndex", "collisionRemoveEntryAtIndex", CmcdData.OBJECT_TYPE_INIT_SEGMENT, "mutableCollisionRemoveEntryAtIndex", "collisionKeyIndex", "collisionContainsKey", "(Ljava/lang/Object;)Z", "collisionGet", "(Ljava/lang/Object;)Ljava/lang/Object;", "collisionPut", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "mutableCollisionPut", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "collisionRemove", "(Ljava/lang/Object;)Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionRemove", "(Ljava/lang/Object;Lkotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionPutAll", "otherNode", "intersectionCounter", "Lkotlinx/collections/immutable/internal/DeltaCounter;", "mutablePutAllFromOtherNodeCell", "calculateSize", "elementsIdentityEquals", "containsKey", "keyHash", "(ILjava/lang/Object;I)Z", "get", "(ILjava/lang/Object;I)Ljava/lang/Object;", "mutablePutAll", "put", "(ILjava/lang/Object;Ljava/lang/Object;I)Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "mutablePut", "(ILjava/lang/Object;Ljava/lang/Object;ILkotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "remove", "(ILjava/lang/Object;I)Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "replaceNode", "targetNode", "mutableRemove", "(ILjava/lang/Object;ILkotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableReplaceNode", "(ILjava/lang/Object;Ljava/lang/Object;I)Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "equalsWith", "K1", "V1", "that", "equalityComparator", "Lkotlin/Function2;", "equalsWith$kotlinx_collections_immutable", "accept", "", "visitor", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "node", "hash", "accept$kotlinx_collections_immutable", "ModificationResult", "Companion", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TrieNode<K, V> {
    public static final Companion Companion = new Companion(null);
    private static final TrieNode EMPTY = new TrieNode(0, 0, new Object[0]);
    private Object[] buffer;
    private int dataMap;
    private int nodeMap;
    private final MutabilityOwnership ownedBy;

    public TrieNode(int i, int i2, Object[] buffer, MutabilityOwnership mutabilityOwnership) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.dataMap = i;
        this.nodeMap = i2;
        this.ownedBy = mutabilityOwnership;
        this.buffer = buffer;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TrieNode(int i, int i2, Object[] buffer) {
        this(i, i2, buffer, null);
        Intrinsics.checkNotNullParameter(buffer, "buffer");
    }

    /* compiled from: TrieNode.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B#\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJD\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002*\u0010\u0011\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00050\u0012H\u0086\bø\u0001\u0000R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "node", "Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "sizeDelta", "", "<init>", "(Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;I)V", "getNode", "()Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "setNode", "(Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;)V", "getSizeDelta", "()I", "replaceNode", "operation", "Lkotlin/Function1;", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ModificationResult<K, V> {
        private TrieNode<K, V> node;
        private final int sizeDelta;

        public ModificationResult(TrieNode<K, V> node, int i) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.node = node;
            this.sizeDelta = i;
        }

        public final TrieNode<K, V> getNode() {
            return this.node;
        }

        public final int getSizeDelta() {
            return this.sizeDelta;
        }

        public final void setNode(TrieNode<K, V> trieNode) {
            Intrinsics.checkNotNullParameter(trieNode, "<set-?>");
            this.node = trieNode;
        }

        public final ModificationResult<K, V> replaceNode(Function1<? super TrieNode<K, V>, TrieNode<K, V>> operation) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            setNode(operation.invoke(getNode()));
            return this;
        }
    }

    private final ModificationResult<K, V> asInsertResult() {
        return new ModificationResult<>(this, 1);
    }

    private final ModificationResult<K, V> asUpdateResult() {
        return new ModificationResult<>(this, 0);
    }

    public final Object[] getBuffer$kotlinx_collections_immutable() {
        return this.buffer;
    }

    public final int entryCount$kotlinx_collections_immutable() {
        return Integer.bitCount(this.dataMap);
    }

    public final boolean hasEntryAt$kotlinx_collections_immutable(int i) {
        return (i & this.dataMap) != 0;
    }

    private final boolean hasNodeAt(int i) {
        return (i & this.nodeMap) != 0;
    }

    public final int entryKeyIndex$kotlinx_collections_immutable(int i) {
        return Integer.bitCount((i - 1) & this.dataMap) * 2;
    }

    public final int nodeIndex$kotlinx_collections_immutable(int i) {
        return (this.buffer.length - 1) - Integer.bitCount((i - 1) & this.nodeMap);
    }

    private final K keyAtIndex(int i) {
        return (K) this.buffer[i];
    }

    private final V valueAtKeyIndex(int i) {
        return (V) this.buffer[i + 1];
    }

    public final TrieNode<K, V> nodeAtIndex$kotlinx_collections_immutable(int i) {
        Object obj = this.buffer[i];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of kotlinx.collections.immutable.implementations.immutableMap.TrieNode, V of kotlinx.collections.immutable.implementations.immutableMap.TrieNode>");
        return (TrieNode) obj;
    }

    private final TrieNode<K, V> insertEntryAt(int i, K k, V v) {
        return new TrieNode<>(i | this.dataMap, this.nodeMap, TrieNodeKt.access$insertEntryAtIndex(this.buffer, entryKeyIndex$kotlinx_collections_immutable(i), k, v));
    }

    private final TrieNode<K, V> mutableInsertEntryAt(int i, K k, V v, MutabilityOwnership mutabilityOwnership) {
        int entryKeyIndex$kotlinx_collections_immutable = entryKeyIndex$kotlinx_collections_immutable(i);
        if (this.ownedBy == mutabilityOwnership) {
            this.buffer = TrieNodeKt.access$insertEntryAtIndex(this.buffer, entryKeyIndex$kotlinx_collections_immutable, k, v);
            this.dataMap = i | this.dataMap;
            return this;
        }
        return new TrieNode<>(i | this.dataMap, this.nodeMap, TrieNodeKt.access$insertEntryAtIndex(this.buffer, entryKeyIndex$kotlinx_collections_immutable, k, v), mutabilityOwnership);
    }

    private final TrieNode<K, V> updateValueAtIndex(int i, V v) {
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        copyOf[i + 1] = v;
        return new TrieNode<>(this.dataMap, this.nodeMap, copyOf);
    }

    private final TrieNode<K, V> mutableUpdateValueAtIndex(int i, V v, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        if (this.ownedBy == persistentHashMapBuilder.getOwnership$kotlinx_collections_immutable()) {
            this.buffer[i + 1] = v;
            return this;
        }
        persistentHashMapBuilder.setModCount$kotlinx_collections_immutable(persistentHashMapBuilder.getModCount$kotlinx_collections_immutable() + 1);
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        copyOf[i + 1] = v;
        return new TrieNode<>(this.dataMap, this.nodeMap, copyOf, persistentHashMapBuilder.getOwnership$kotlinx_collections_immutable());
    }

    static /* synthetic */ TrieNode updateNodeAtIndex$default(TrieNode trieNode, int i, int i2, TrieNode trieNode2, MutabilityOwnership mutabilityOwnership, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            mutabilityOwnership = null;
        }
        return trieNode.updateNodeAtIndex(i, i2, trieNode2, mutabilityOwnership);
    }

    private final TrieNode<K, V> updateNodeAtIndex(int i, int i2, TrieNode<K, V> trieNode, MutabilityOwnership mutabilityOwnership) {
        Object[] objArr = trieNode.buffer;
        if (objArr.length == 2 && trieNode.nodeMap == 0) {
            if (this.buffer.length == 1) {
                trieNode.dataMap = this.nodeMap;
                return trieNode;
            }
            return new TrieNode<>(this.dataMap ^ i2, i2 ^ this.nodeMap, TrieNodeKt.access$replaceNodeWithEntry(this.buffer, i, entryKeyIndex$kotlinx_collections_immutable(i2), objArr[0], objArr[1]), mutabilityOwnership);
        } else if (mutabilityOwnership != null && this.ownedBy == mutabilityOwnership) {
            this.buffer[i] = trieNode;
            return this;
        } else {
            Object[] objArr2 = this.buffer;
            Object[] copyOf = Arrays.copyOf(objArr2, objArr2.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            copyOf[i] = trieNode;
            return new TrieNode<>(this.dataMap, this.nodeMap, copyOf, mutabilityOwnership);
        }
    }

    private final TrieNode<K, V> removeNodeAtIndex(int i, int i2) {
        Object[] objArr = this.buffer;
        if (objArr.length == 1) {
            return null;
        }
        return new TrieNode<>(this.dataMap, i2 ^ this.nodeMap, TrieNodeKt.access$removeNodeAtIndex(objArr, i));
    }

    private final TrieNode<K, V> mutableRemoveNodeAtIndex(int i, int i2, MutabilityOwnership mutabilityOwnership) {
        Object[] objArr = this.buffer;
        if (objArr.length == 1) {
            return null;
        }
        if (this.ownedBy == mutabilityOwnership) {
            this.buffer = TrieNodeKt.access$removeNodeAtIndex(objArr, i);
            this.nodeMap ^= i2;
            return this;
        }
        return new TrieNode<>(this.dataMap, i2 ^ this.nodeMap, TrieNodeKt.access$removeNodeAtIndex(objArr, i), mutabilityOwnership);
    }

    private final Object[] bufferMoveEntryToNode(int i, int i2, int i3, K k, V v, int i4, MutabilityOwnership mutabilityOwnership) {
        K keyAtIndex = keyAtIndex(i);
        return TrieNodeKt.access$replaceEntryWithNode(this.buffer, i, nodeIndex$kotlinx_collections_immutable(i2) + 1, makeNode(keyAtIndex != null ? keyAtIndex.hashCode() : 0, keyAtIndex, valueAtKeyIndex(i), i3, k, v, i4 + 5, mutabilityOwnership));
    }

    private final TrieNode<K, V> moveEntryToNode(int i, int i2, int i3, K k, V v, int i4) {
        return new TrieNode<>(this.dataMap ^ i2, this.nodeMap | i2, bufferMoveEntryToNode(i, i2, i3, k, v, i4, null));
    }

    private final TrieNode<K, V> mutableMoveEntryToNode(int i, int i2, int i3, K k, V v, int i4, MutabilityOwnership mutabilityOwnership) {
        if (this.ownedBy == mutabilityOwnership) {
            this.buffer = bufferMoveEntryToNode(i, i2, i3, k, v, i4, mutabilityOwnership);
            this.dataMap ^= i2;
            this.nodeMap |= i2;
            return this;
        }
        return new TrieNode<>(this.dataMap ^ i2, i2 | this.nodeMap, bufferMoveEntryToNode(i, i2, i3, k, v, i4, mutabilityOwnership), mutabilityOwnership);
    }

    private final TrieNode<K, V> makeNode(int i, K k, V v, int i2, K k2, V v2, int i3, MutabilityOwnership mutabilityOwnership) {
        if (i3 > 30) {
            return new TrieNode<>(0, 0, new Object[]{k, v, k2, v2}, mutabilityOwnership);
        }
        int indexSegment = TrieNodeKt.indexSegment(i, i3);
        int indexSegment2 = TrieNodeKt.indexSegment(i2, i3);
        if (indexSegment != indexSegment2) {
            return new TrieNode<>((1 << indexSegment) | (1 << indexSegment2), 0, indexSegment < indexSegment2 ? new Object[]{k, v, k2, v2} : new Object[]{k2, v2, k, v}, mutabilityOwnership);
        }
        return new TrieNode<>(0, 1 << indexSegment, new Object[]{makeNode(i, k, v, i2, k2, v2, i3 + 5, mutabilityOwnership)}, mutabilityOwnership);
    }

    private final TrieNode<K, V> removeEntryAtIndex(int i, int i2) {
        Object[] objArr = this.buffer;
        if (objArr.length == 2) {
            return null;
        }
        return new TrieNode<>(i2 ^ this.dataMap, this.nodeMap, TrieNodeKt.access$removeEntryAtIndex(objArr, i));
    }

    private final TrieNode<K, V> mutableRemoveEntryAtIndex(int i, int i2, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        persistentHashMapBuilder.setSize(persistentHashMapBuilder.size() - 1);
        persistentHashMapBuilder.setOperationResult$kotlinx_collections_immutable(valueAtKeyIndex(i));
        if (this.buffer.length == 2) {
            return null;
        }
        if (this.ownedBy == persistentHashMapBuilder.getOwnership$kotlinx_collections_immutable()) {
            this.buffer = TrieNodeKt.access$removeEntryAtIndex(this.buffer, i);
            this.dataMap ^= i2;
            return this;
        }
        return new TrieNode<>(i2 ^ this.dataMap, this.nodeMap, TrieNodeKt.access$removeEntryAtIndex(this.buffer, i), persistentHashMapBuilder.getOwnership$kotlinx_collections_immutable());
    }

    private final TrieNode<K, V> collisionRemoveEntryAtIndex(int i) {
        Object[] objArr = this.buffer;
        if (objArr.length == 2) {
            return null;
        }
        return new TrieNode<>(0, 0, TrieNodeKt.access$removeEntryAtIndex(objArr, i));
    }

    private final TrieNode<K, V> mutableCollisionRemoveEntryAtIndex(int i, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        persistentHashMapBuilder.setSize(persistentHashMapBuilder.size() - 1);
        persistentHashMapBuilder.setOperationResult$kotlinx_collections_immutable(valueAtKeyIndex(i));
        if (this.buffer.length == 2) {
            return null;
        }
        if (this.ownedBy == persistentHashMapBuilder.getOwnership$kotlinx_collections_immutable()) {
            this.buffer = TrieNodeKt.access$removeEntryAtIndex(this.buffer, i);
            return this;
        }
        return new TrieNode<>(0, 0, TrieNodeKt.access$removeEntryAtIndex(this.buffer, i), persistentHashMapBuilder.getOwnership$kotlinx_collections_immutable());
    }

    private final int collisionKeyIndex(Object obj) {
        IntProgression step = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 <= 0 || first > last) && (step2 >= 0 || last > first)) {
            return -1;
        }
        while (!Intrinsics.areEqual(obj, keyAtIndex(first))) {
            if (first == last) {
                return -1;
            }
            first += step2;
        }
        return first;
    }

    private final boolean collisionContainsKey(K k) {
        return collisionKeyIndex(k) != -1;
    }

    private final V collisionGet(K k) {
        int collisionKeyIndex = collisionKeyIndex(k);
        if (collisionKeyIndex != -1) {
            return valueAtKeyIndex(collisionKeyIndex);
        }
        return null;
    }

    private final ModificationResult<K, V> collisionPut(K k, V v) {
        int collisionKeyIndex = collisionKeyIndex(k);
        if (collisionKeyIndex != -1) {
            if (v == valueAtKeyIndex(collisionKeyIndex)) {
                return null;
            }
            Object[] objArr = this.buffer;
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            copyOf[collisionKeyIndex + 1] = v;
            return new TrieNode(0, 0, copyOf).asUpdateResult();
        }
        return new TrieNode(0, 0, TrieNodeKt.access$insertEntryAtIndex(this.buffer, 0, k, v)).asInsertResult();
    }

    private final TrieNode<K, V> mutableCollisionPut(K k, V v, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        int collisionKeyIndex = collisionKeyIndex(k);
        if (collisionKeyIndex != -1) {
            persistentHashMapBuilder.setOperationResult$kotlinx_collections_immutable(valueAtKeyIndex(collisionKeyIndex));
            if (this.ownedBy == persistentHashMapBuilder.getOwnership$kotlinx_collections_immutable()) {
                this.buffer[collisionKeyIndex + 1] = v;
                return this;
            }
            persistentHashMapBuilder.setModCount$kotlinx_collections_immutable(persistentHashMapBuilder.getModCount$kotlinx_collections_immutable() + 1);
            Object[] objArr = this.buffer;
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            copyOf[collisionKeyIndex + 1] = v;
            return new TrieNode<>(0, 0, copyOf, persistentHashMapBuilder.getOwnership$kotlinx_collections_immutable());
        }
        persistentHashMapBuilder.setSize(persistentHashMapBuilder.size() + 1);
        return new TrieNode<>(0, 0, TrieNodeKt.access$insertEntryAtIndex(this.buffer, 0, k, v), persistentHashMapBuilder.getOwnership$kotlinx_collections_immutable());
    }

    private final TrieNode<K, V> collisionRemove(K k) {
        int collisionKeyIndex = collisionKeyIndex(k);
        return collisionKeyIndex != -1 ? collisionRemoveEntryAtIndex(collisionKeyIndex) : this;
    }

    private final TrieNode<K, V> mutableCollisionRemove(K k, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        int collisionKeyIndex = collisionKeyIndex(k);
        return collisionKeyIndex != -1 ? mutableCollisionRemoveEntryAtIndex(collisionKeyIndex, persistentHashMapBuilder) : this;
    }

    private final TrieNode<K, V> collisionRemove(K k, V v) {
        int collisionKeyIndex = collisionKeyIndex(k);
        return (collisionKeyIndex == -1 || !Intrinsics.areEqual(v, valueAtKeyIndex(collisionKeyIndex))) ? this : collisionRemoveEntryAtIndex(collisionKeyIndex);
    }

    private final TrieNode<K, V> mutableCollisionRemove(K k, V v, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        int collisionKeyIndex = collisionKeyIndex(k);
        return (collisionKeyIndex == -1 || !Intrinsics.areEqual(v, valueAtKeyIndex(collisionKeyIndex))) ? this : mutableCollisionRemoveEntryAtIndex(collisionKeyIndex, persistentHashMapBuilder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final TrieNode<K, V> mutableCollisionPutAll(TrieNode<K, V> trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        CommonFunctionsKt.m9966assert(this.nodeMap == 0);
        CommonFunctionsKt.m9966assert(this.dataMap == 0);
        CommonFunctionsKt.m9966assert(trieNode.nodeMap == 0);
        CommonFunctionsKt.m9966assert(trieNode.dataMap == 0);
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length + trieNode.buffer.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        int length = this.buffer.length;
        IntProgression step = RangesKt.step(RangesKt.until(0, trieNode.buffer.length), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                if (!collisionContainsKey(trieNode.buffer[first])) {
                    Object[] objArr2 = trieNode.buffer;
                    copyOf[length] = objArr2[first];
                    copyOf[length + 1] = objArr2[first + 1];
                    length += 2;
                } else {
                    deltaCounter.setCount(deltaCounter.getCount() + 1);
                }
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        if (length == this.buffer.length) {
            return this;
        }
        if (length == trieNode.buffer.length) {
            return trieNode;
        }
        if (length == copyOf.length) {
            return new TrieNode<>(0, 0, copyOf, mutabilityOwnership);
        }
        Object[] copyOf2 = Arrays.copyOf(copyOf, length);
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
        return new TrieNode<>(0, 0, copyOf2, mutabilityOwnership);
    }

    private final TrieNode<K, V> mutablePutAllFromOtherNodeCell(TrieNode<K, V> trieNode, int i, int i2, DeltaCounter deltaCounter, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        if (hasNodeAt(i)) {
            TrieNode<K, V> nodeAtIndex$kotlinx_collections_immutable = nodeAtIndex$kotlinx_collections_immutable(nodeIndex$kotlinx_collections_immutable(i));
            if (trieNode.hasNodeAt(i)) {
                return nodeAtIndex$kotlinx_collections_immutable.mutablePutAll(trieNode.nodeAtIndex$kotlinx_collections_immutable(trieNode.nodeIndex$kotlinx_collections_immutable(i)), i2 + 5, deltaCounter, persistentHashMapBuilder);
            }
            if (trieNode.hasEntryAt$kotlinx_collections_immutable(i)) {
                int entryKeyIndex$kotlinx_collections_immutable = trieNode.entryKeyIndex$kotlinx_collections_immutable(i);
                K keyAtIndex = trieNode.keyAtIndex(entryKeyIndex$kotlinx_collections_immutable);
                V valueAtKeyIndex = trieNode.valueAtKeyIndex(entryKeyIndex$kotlinx_collections_immutable);
                int size = persistentHashMapBuilder.size();
                TrieNode<K, V> mutablePut = nodeAtIndex$kotlinx_collections_immutable.mutablePut(keyAtIndex != null ? keyAtIndex.hashCode() : 0, keyAtIndex, valueAtKeyIndex, i2 + 5, persistentHashMapBuilder);
                if (persistentHashMapBuilder.size() == size) {
                    deltaCounter.setCount(deltaCounter.getCount() + 1);
                }
                return mutablePut;
            }
            return nodeAtIndex$kotlinx_collections_immutable;
        } else if (trieNode.hasNodeAt(i)) {
            TrieNode<K, V> nodeAtIndex$kotlinx_collections_immutable2 = trieNode.nodeAtIndex$kotlinx_collections_immutable(trieNode.nodeIndex$kotlinx_collections_immutable(i));
            if (hasEntryAt$kotlinx_collections_immutable(i)) {
                int entryKeyIndex$kotlinx_collections_immutable2 = entryKeyIndex$kotlinx_collections_immutable(i);
                K keyAtIndex2 = keyAtIndex(entryKeyIndex$kotlinx_collections_immutable2);
                int i3 = i2 + 5;
                if (!nodeAtIndex$kotlinx_collections_immutable2.containsKey(keyAtIndex2 != null ? keyAtIndex2.hashCode() : 0, keyAtIndex2, i3)) {
                    return nodeAtIndex$kotlinx_collections_immutable2.mutablePut(keyAtIndex2 != null ? keyAtIndex2.hashCode() : 0, keyAtIndex2, valueAtKeyIndex(entryKeyIndex$kotlinx_collections_immutable2), i3, persistentHashMapBuilder);
                }
                deltaCounter.setCount(deltaCounter.getCount() + 1);
                return nodeAtIndex$kotlinx_collections_immutable2;
            }
            return nodeAtIndex$kotlinx_collections_immutable2;
        } else {
            int entryKeyIndex$kotlinx_collections_immutable3 = entryKeyIndex$kotlinx_collections_immutable(i);
            K keyAtIndex3 = keyAtIndex(entryKeyIndex$kotlinx_collections_immutable3);
            V valueAtKeyIndex2 = valueAtKeyIndex(entryKeyIndex$kotlinx_collections_immutable3);
            int entryKeyIndex$kotlinx_collections_immutable4 = trieNode.entryKeyIndex$kotlinx_collections_immutable(i);
            K keyAtIndex4 = trieNode.keyAtIndex(entryKeyIndex$kotlinx_collections_immutable4);
            return makeNode(keyAtIndex3 != null ? keyAtIndex3.hashCode() : 0, keyAtIndex3, valueAtKeyIndex2, keyAtIndex4 != null ? keyAtIndex4.hashCode() : 0, keyAtIndex4, trieNode.valueAtKeyIndex(entryKeyIndex$kotlinx_collections_immutable4), i2 + 5, persistentHashMapBuilder.getOwnership$kotlinx_collections_immutable());
        }
    }

    private final int calculateSize() {
        if (this.nodeMap == 0) {
            return this.buffer.length / 2;
        }
        int bitCount = Integer.bitCount(this.dataMap);
        int length = this.buffer.length;
        for (int i = bitCount * 2; i < length; i++) {
            bitCount += nodeAtIndex$kotlinx_collections_immutable(i).calculateSize();
        }
        return bitCount;
    }

    private final boolean elementsIdentityEquals(TrieNode<K, V> trieNode) {
        if (this == trieNode) {
            return true;
        }
        if (this.nodeMap == trieNode.nodeMap && this.dataMap == trieNode.dataMap) {
            int length = this.buffer.length;
            for (int i = 0; i < length; i++) {
                if (this.buffer[i] != trieNode.buffer[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public final boolean containsKey(int i, K k, int i2) {
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasEntryAt$kotlinx_collections_immutable(indexSegment)) {
            return Intrinsics.areEqual(k, keyAtIndex(entryKeyIndex$kotlinx_collections_immutable(indexSegment)));
        }
        if (hasNodeAt(indexSegment)) {
            TrieNode<K, V> nodeAtIndex$kotlinx_collections_immutable = nodeAtIndex$kotlinx_collections_immutable(nodeIndex$kotlinx_collections_immutable(indexSegment));
            if (i2 == 30) {
                return nodeAtIndex$kotlinx_collections_immutable.collisionContainsKey(k);
            }
            return nodeAtIndex$kotlinx_collections_immutable.containsKey(i, k, i2 + 5);
        }
        return false;
    }

    public final V get(int i, K k, int i2) {
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasEntryAt$kotlinx_collections_immutable(indexSegment)) {
            int entryKeyIndex$kotlinx_collections_immutable = entryKeyIndex$kotlinx_collections_immutable(indexSegment);
            if (Intrinsics.areEqual(k, keyAtIndex(entryKeyIndex$kotlinx_collections_immutable))) {
                return valueAtKeyIndex(entryKeyIndex$kotlinx_collections_immutable);
            }
            return null;
        } else if (hasNodeAt(indexSegment)) {
            TrieNode<K, V> nodeAtIndex$kotlinx_collections_immutable = nodeAtIndex$kotlinx_collections_immutable(nodeIndex$kotlinx_collections_immutable(indexSegment));
            if (i2 == 30) {
                return nodeAtIndex$kotlinx_collections_immutable.collisionGet(k);
            }
            return nodeAtIndex$kotlinx_collections_immutable.get(i, k, i2 + 5);
        } else {
            return null;
        }
    }

    public final TrieNode<K, V> mutablePutAll(TrieNode<K, V> otherNode, int i, DeltaCounter intersectionCounter, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        Object[] objArr;
        Intrinsics.checkNotNullParameter(otherNode, "otherNode");
        Intrinsics.checkNotNullParameter(intersectionCounter, "intersectionCounter");
        PersistentHashMapBuilder<K, V> mutator = persistentHashMapBuilder;
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        if (this == otherNode) {
            intersectionCounter.plusAssign(calculateSize());
            return this;
        }
        int i2 = i;
        if (i2 > 30) {
            return mutableCollisionPutAll(otherNode, intersectionCounter, mutator.getOwnership$kotlinx_collections_immutable());
        }
        int i3 = this.nodeMap | otherNode.nodeMap;
        int i4 = this.dataMap;
        int i5 = otherNode.dataMap;
        int i6 = (i4 ^ i5) & (~i3);
        int i7 = i4 & i5;
        while (i7 != 0) {
            int lowestOneBit = Integer.lowestOneBit(i7);
            if (Intrinsics.areEqual(keyAtIndex(entryKeyIndex$kotlinx_collections_immutable(lowestOneBit)), otherNode.keyAtIndex(otherNode.entryKeyIndex$kotlinx_collections_immutable(lowestOneBit)))) {
                i6 |= lowestOneBit;
            } else {
                i3 |= lowestOneBit;
            }
            i7 ^= lowestOneBit;
        }
        if ((i3 & i6) != 0) {
            throw new IllegalStateException("Check failed.");
        }
        TrieNode<K, V> trieNode = (Intrinsics.areEqual(this.ownedBy, mutator.getOwnership$kotlinx_collections_immutable()) && this.dataMap == i6 && this.nodeMap == i3) ? this : new TrieNode<>(i6, i3, new Object[(Integer.bitCount(i6) * 2) + Integer.bitCount(i3)]);
        int i8 = 0;
        int i9 = i3;
        int i10 = 0;
        while (i9 != 0) {
            int lowestOneBit2 = Integer.lowestOneBit(i9);
            trieNode.buffer[(objArr.length - 1) - i10] = mutablePutAllFromOtherNodeCell(otherNode, lowestOneBit2, i2, intersectionCounter, mutator);
            i10++;
            i9 ^= lowestOneBit2;
            i2 = i;
            mutator = persistentHashMapBuilder;
        }
        while (i6 != 0) {
            int lowestOneBit3 = Integer.lowestOneBit(i6);
            int i11 = i8 * 2;
            if (!otherNode.hasEntryAt$kotlinx_collections_immutable(lowestOneBit3)) {
                int entryKeyIndex$kotlinx_collections_immutable = entryKeyIndex$kotlinx_collections_immutable(lowestOneBit3);
                trieNode.buffer[i11] = keyAtIndex(entryKeyIndex$kotlinx_collections_immutable);
                trieNode.buffer[i11 + 1] = valueAtKeyIndex(entryKeyIndex$kotlinx_collections_immutable);
            } else {
                int entryKeyIndex$kotlinx_collections_immutable2 = otherNode.entryKeyIndex$kotlinx_collections_immutable(lowestOneBit3);
                trieNode.buffer[i11] = otherNode.keyAtIndex(entryKeyIndex$kotlinx_collections_immutable2);
                trieNode.buffer[i11 + 1] = otherNode.valueAtKeyIndex(entryKeyIndex$kotlinx_collections_immutable2);
                if (hasEntryAt$kotlinx_collections_immutable(lowestOneBit3)) {
                    intersectionCounter.setCount(intersectionCounter.getCount() + 1);
                }
            }
            i8++;
            i6 ^= lowestOneBit3;
        }
        return elementsIdentityEquals(trieNode) ? this : otherNode.elementsIdentityEquals(trieNode) ? otherNode : trieNode;
    }

    public final ModificationResult<K, V> put(int i, K k, V v, int i2) {
        ModificationResult<K, V> put;
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasEntryAt$kotlinx_collections_immutable(indexSegment)) {
            int entryKeyIndex$kotlinx_collections_immutable = entryKeyIndex$kotlinx_collections_immutable(indexSegment);
            if (Intrinsics.areEqual(k, keyAtIndex(entryKeyIndex$kotlinx_collections_immutable))) {
                if (valueAtKeyIndex(entryKeyIndex$kotlinx_collections_immutable) == v) {
                    return null;
                }
                return updateValueAtIndex(entryKeyIndex$kotlinx_collections_immutable, v).asUpdateResult();
            }
            return moveEntryToNode(entryKeyIndex$kotlinx_collections_immutable, indexSegment, i, k, v, i2).asInsertResult();
        } else if (hasNodeAt(indexSegment)) {
            int nodeIndex$kotlinx_collections_immutable = nodeIndex$kotlinx_collections_immutable(indexSegment);
            TrieNode<K, V> nodeAtIndex$kotlinx_collections_immutable = nodeAtIndex$kotlinx_collections_immutable(nodeIndex$kotlinx_collections_immutable);
            if (i2 == 30) {
                put = nodeAtIndex$kotlinx_collections_immutable.collisionPut(k, v);
                if (put == null) {
                    return null;
                }
            } else {
                put = nodeAtIndex$kotlinx_collections_immutable.put(i, k, v, i2 + 5);
                if (put == null) {
                    return null;
                }
            }
            put.setNode(updateNodeAtIndex$default(this, nodeIndex$kotlinx_collections_immutable, indexSegment, put.getNode(), null, 8, null));
            return put;
        } else {
            return insertEntryAt(indexSegment, k, v).asInsertResult();
        }
    }

    public final TrieNode<K, V> mutablePut(int i, K k, V v, int i2, PersistentHashMapBuilder<K, V> mutator) {
        PersistentHashMapBuilder<K, V> persistentHashMapBuilder;
        TrieNode<K, V> mutablePut;
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasEntryAt$kotlinx_collections_immutable(indexSegment)) {
            int entryKeyIndex$kotlinx_collections_immutable = entryKeyIndex$kotlinx_collections_immutable(indexSegment);
            if (Intrinsics.areEqual(k, keyAtIndex(entryKeyIndex$kotlinx_collections_immutable))) {
                mutator.setOperationResult$kotlinx_collections_immutable(valueAtKeyIndex(entryKeyIndex$kotlinx_collections_immutable));
                return valueAtKeyIndex(entryKeyIndex$kotlinx_collections_immutable) == v ? this : mutableUpdateValueAtIndex(entryKeyIndex$kotlinx_collections_immutable, v, mutator);
            }
            mutator.setSize(mutator.size() + 1);
            return mutableMoveEntryToNode(entryKeyIndex$kotlinx_collections_immutable, indexSegment, i, k, v, i2, mutator.getOwnership$kotlinx_collections_immutable());
        } else if (hasNodeAt(indexSegment)) {
            int nodeIndex$kotlinx_collections_immutable = nodeIndex$kotlinx_collections_immutable(indexSegment);
            TrieNode<K, V> nodeAtIndex$kotlinx_collections_immutable = nodeAtIndex$kotlinx_collections_immutable(nodeIndex$kotlinx_collections_immutable);
            if (i2 == 30) {
                mutablePut = nodeAtIndex$kotlinx_collections_immutable.mutableCollisionPut(k, v, mutator);
                persistentHashMapBuilder = mutator;
            } else {
                persistentHashMapBuilder = mutator;
                mutablePut = nodeAtIndex$kotlinx_collections_immutable.mutablePut(i, k, v, i2 + 5, persistentHashMapBuilder);
            }
            return nodeAtIndex$kotlinx_collections_immutable == mutablePut ? this : updateNodeAtIndex(nodeIndex$kotlinx_collections_immutable, indexSegment, mutablePut, persistentHashMapBuilder.getOwnership$kotlinx_collections_immutable());
        } else {
            mutator.setSize(mutator.size() + 1);
            return mutableInsertEntryAt(indexSegment, k, v, mutator.getOwnership$kotlinx_collections_immutable());
        }
    }

    public final TrieNode<K, V> remove(int i, K k, int i2) {
        TrieNode<K, V> remove;
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasEntryAt$kotlinx_collections_immutable(indexSegment)) {
            int entryKeyIndex$kotlinx_collections_immutable = entryKeyIndex$kotlinx_collections_immutable(indexSegment);
            if (Intrinsics.areEqual(k, keyAtIndex(entryKeyIndex$kotlinx_collections_immutable))) {
                return removeEntryAtIndex(entryKeyIndex$kotlinx_collections_immutable, indexSegment);
            }
        } else if (hasNodeAt(indexSegment)) {
            int nodeIndex$kotlinx_collections_immutable = nodeIndex$kotlinx_collections_immutable(indexSegment);
            TrieNode<K, V> nodeAtIndex$kotlinx_collections_immutable = nodeAtIndex$kotlinx_collections_immutable(nodeIndex$kotlinx_collections_immutable);
            if (i2 == 30) {
                remove = nodeAtIndex$kotlinx_collections_immutable.collisionRemove(k);
            } else {
                remove = nodeAtIndex$kotlinx_collections_immutable.remove(i, k, i2 + 5);
            }
            return replaceNode(nodeAtIndex$kotlinx_collections_immutable, remove, nodeIndex$kotlinx_collections_immutable, indexSegment);
        }
        return this;
    }

    private final TrieNode<K, V> replaceNode(TrieNode<K, V> trieNode, TrieNode<K, V> trieNode2, int i, int i2) {
        if (trieNode2 == null) {
            return removeNodeAtIndex(i, i2);
        }
        return trieNode != trieNode2 ? updateNodeAtIndex$default(this, i, i2, trieNode2, null, 8, null) : this;
    }

    public final TrieNode<K, V> mutableRemove(int i, K k, int i2, PersistentHashMapBuilder<K, V> mutator) {
        TrieNode<K, V> mutableRemove;
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasEntryAt$kotlinx_collections_immutable(indexSegment)) {
            int entryKeyIndex$kotlinx_collections_immutable = entryKeyIndex$kotlinx_collections_immutable(indexSegment);
            if (Intrinsics.areEqual(k, keyAtIndex(entryKeyIndex$kotlinx_collections_immutable))) {
                return mutableRemoveEntryAtIndex(entryKeyIndex$kotlinx_collections_immutable, indexSegment, mutator);
            }
        } else if (hasNodeAt(indexSegment)) {
            int nodeIndex$kotlinx_collections_immutable = nodeIndex$kotlinx_collections_immutable(indexSegment);
            TrieNode<K, V> nodeAtIndex$kotlinx_collections_immutable = nodeAtIndex$kotlinx_collections_immutable(nodeIndex$kotlinx_collections_immutable);
            if (i2 == 30) {
                mutableRemove = nodeAtIndex$kotlinx_collections_immutable.mutableCollisionRemove(k, mutator);
            } else {
                mutableRemove = nodeAtIndex$kotlinx_collections_immutable.mutableRemove(i, k, i2 + 5, mutator);
            }
            return mutableReplaceNode(mutableRemove, nodeIndex$kotlinx_collections_immutable, indexSegment, mutator.getOwnership$kotlinx_collections_immutable());
        }
        return this;
    }

    private final TrieNode<K, V> mutableReplaceNode(TrieNode<K, V> trieNode, int i, int i2, MutabilityOwnership mutabilityOwnership) {
        if (trieNode == null) {
            return mutableRemoveNodeAtIndex(i, i2, mutabilityOwnership);
        }
        return updateNodeAtIndex(i, i2, trieNode, mutabilityOwnership);
    }

    public final TrieNode<K, V> remove(int i, K k, V v, int i2) {
        TrieNode<K, V> remove;
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasEntryAt$kotlinx_collections_immutable(indexSegment)) {
            int entryKeyIndex$kotlinx_collections_immutable = entryKeyIndex$kotlinx_collections_immutable(indexSegment);
            if (Intrinsics.areEqual(k, keyAtIndex(entryKeyIndex$kotlinx_collections_immutable)) && Intrinsics.areEqual(v, valueAtKeyIndex(entryKeyIndex$kotlinx_collections_immutable))) {
                return removeEntryAtIndex(entryKeyIndex$kotlinx_collections_immutable, indexSegment);
            }
        } else if (hasNodeAt(indexSegment)) {
            int nodeIndex$kotlinx_collections_immutable = nodeIndex$kotlinx_collections_immutable(indexSegment);
            TrieNode<K, V> nodeAtIndex$kotlinx_collections_immutable = nodeAtIndex$kotlinx_collections_immutable(nodeIndex$kotlinx_collections_immutable);
            if (i2 == 30) {
                remove = nodeAtIndex$kotlinx_collections_immutable.collisionRemove(k, v);
            } else {
                remove = nodeAtIndex$kotlinx_collections_immutable.remove(i, k, v, i2 + 5);
            }
            return replaceNode(nodeAtIndex$kotlinx_collections_immutable, remove, nodeIndex$kotlinx_collections_immutable, indexSegment);
        }
        return this;
    }

    public final TrieNode<K, V> mutableRemove(int i, K k, V v, int i2, PersistentHashMapBuilder<K, V> mutator) {
        PersistentHashMapBuilder<K, V> persistentHashMapBuilder;
        TrieNode<K, V> mutableRemove;
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasEntryAt$kotlinx_collections_immutable(indexSegment)) {
            int entryKeyIndex$kotlinx_collections_immutable = entryKeyIndex$kotlinx_collections_immutable(indexSegment);
            if (Intrinsics.areEqual(k, keyAtIndex(entryKeyIndex$kotlinx_collections_immutable)) && Intrinsics.areEqual(v, valueAtKeyIndex(entryKeyIndex$kotlinx_collections_immutable))) {
                return mutableRemoveEntryAtIndex(entryKeyIndex$kotlinx_collections_immutable, indexSegment, mutator);
            }
        } else if (hasNodeAt(indexSegment)) {
            int nodeIndex$kotlinx_collections_immutable = nodeIndex$kotlinx_collections_immutable(indexSegment);
            TrieNode<K, V> nodeAtIndex$kotlinx_collections_immutable = nodeAtIndex$kotlinx_collections_immutable(nodeIndex$kotlinx_collections_immutable);
            if (i2 == 30) {
                mutableRemove = nodeAtIndex$kotlinx_collections_immutable.mutableCollisionRemove(k, v, mutator);
                persistentHashMapBuilder = mutator;
            } else {
                persistentHashMapBuilder = mutator;
                mutableRemove = nodeAtIndex$kotlinx_collections_immutable.mutableRemove(i, k, v, i2 + 5, persistentHashMapBuilder);
            }
            return mutableReplaceNode(mutableRemove, nodeIndex$kotlinx_collections_immutable, indexSegment, persistentHashMapBuilder.getOwnership$kotlinx_collections_immutable());
        }
        return this;
    }

    public final <K1, V1> boolean equalsWith$kotlinx_collections_immutable(TrieNode<K1, V1> that, Function2<? super V, ? super V1, Boolean> equalityComparator) {
        int i;
        boolean z;
        Intrinsics.checkNotNullParameter(that, "that");
        Intrinsics.checkNotNullParameter(equalityComparator, "equalityComparator");
        if (this == that) {
            return true;
        }
        int i2 = this.dataMap;
        if (i2 == that.dataMap && (i = this.nodeMap) == that.nodeMap) {
            if (i2 == 0 && i == 0) {
                Object[] objArr = this.buffer;
                if (objArr.length != that.buffer.length) {
                    return false;
                }
                IntProgression step = RangesKt.step(RangesKt.until(0, objArr.length), 2);
                if ((step instanceof Collection) && ((Collection) step).isEmpty()) {
                    return true;
                }
                Iterator<Integer> it = step.iterator();
                while (it.hasNext()) {
                    int nextInt = ((IntIterator) it).nextInt();
                    K1 keyAtIndex = that.keyAtIndex(nextInt);
                    V1 valueAtKeyIndex = that.valueAtKeyIndex(nextInt);
                    int collisionKeyIndex = collisionKeyIndex(keyAtIndex);
                    if (collisionKeyIndex != -1) {
                        z = equalityComparator.invoke(valueAtKeyIndex(collisionKeyIndex), valueAtKeyIndex).booleanValue();
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        return false;
                    }
                }
                return true;
            }
            int bitCount = Integer.bitCount(i2) * 2;
            IntProgression step2 = RangesKt.step(RangesKt.until(0, bitCount), 2);
            int first = step2.getFirst();
            int last = step2.getLast();
            int step3 = step2.getStep();
            if ((step3 > 0 && first <= last) || (step3 < 0 && last <= first)) {
                while (Intrinsics.areEqual(keyAtIndex(first), that.keyAtIndex(first)) && equalityComparator.invoke(valueAtKeyIndex(first), that.valueAtKeyIndex(first)).booleanValue()) {
                    if (first != last) {
                        first += step3;
                    }
                }
                return false;
            }
            int length = this.buffer.length;
            while (bitCount < length) {
                if (!nodeAtIndex$kotlinx_collections_immutable(bitCount).equalsWith$kotlinx_collections_immutable(that.nodeAtIndex$kotlinx_collections_immutable(bitCount), equalityComparator)) {
                    return false;
                }
                bitCount++;
            }
            return true;
        }
        return false;
    }

    public final void accept$kotlinx_collections_immutable(Function5<? super TrieNode<K, V>, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> visitor) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        accept(visitor, 0, 0);
    }

    private final void accept(Function5<? super TrieNode<K, V>, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> function5, int i, int i2) {
        function5.invoke(this, Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(this.dataMap), Integer.valueOf(this.nodeMap));
        int i3 = this.nodeMap;
        while (i3 != 0) {
            int lowestOneBit = Integer.lowestOneBit(i3);
            nodeAtIndex$kotlinx_collections_immutable(nodeIndex$kotlinx_collections_immutable(lowestOneBit)).accept(function5, (Integer.numberOfTrailingZeros(lowestOneBit) << i2) + i, i2 + 5);
            i3 -= lowestOneBit;
        }
    }

    /* compiled from: TrieNode.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode$Companion;", "", "<init>", "()V", "EMPTY", "Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "", "getEMPTY$kotlinx_collections_immutable", "()Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TrieNode getEMPTY$kotlinx_collections_immutable() {
            return TrieNode.EMPTY;
        }
    }
}
