package kotlinx.collections.immutable.implementations.immutableList;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.collections.immutable.PersistentList;
import kotlinx.collections.immutable.internal.CommonFunctionsKt;
import kotlinx.collections.immutable.internal.ListImplementation;
import kotlinx.collections.immutable.internal.MutabilityOwnership;
/* compiled from: PersistentVectorBuilder.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010)\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0010*\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B?\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010!\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\"J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J\b\u0010$\u001a\u00020\u000bH\u0002J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\b\u0010%\u001a\u00020\u000bH\u0002J\u001d\u0010&\u001a\u00020'2\u000e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010)J'\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010+J-\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010-\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010.J\u001f\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\b\u00100\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u00101J\u0015\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010\u0018J\u0015\u00103\u001a\u00020'2\u0006\u00100\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00104J?\u00105\u001a\u0002062\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u00109J?\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010;\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010<J\u0016\u0010=\u001a\u00020'2\f\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000?H\u0016J=\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010A\u001a\u00020\u000b2\u000e\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0CH\u0002¢\u0006\u0002\u0010DJE\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010$\u001a\u00020\u000b2\u0014\u0010F\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0007H\u0002¢\u0006\u0002\u0010GJM\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000b2\u0014\u0010I\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070CH\u0002¢\u0006\u0002\u0010JJ\u001d\u00103\u001a\u0002062\u0006\u0010K\u001a\u00020\u000b2\u0006\u00100\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010LJ/\u0010M\u001a\u0002062\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010K\u001a\u00020\u000b2\u0006\u00100\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010NJG\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u00010\b2\u0006\u0010P\u001a\u00020QH\u0002¢\u0006\u0002\u0010RJ\u001e\u0010=\u001a\u00020'2\u0006\u0010K\u001a\u00020\u000b2\f\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000?H\u0016J[\u0010O\u001a\u0002062\f\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000?2\u0006\u0010K\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u000b2\u0016\u0010F\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010T\u001a\u00020\u000b2\u000e\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010VJU\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010X\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u000b2\u0016\u0010F\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010T\u001a\u00020\u000b2\u000e\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010YJk\u0010Z\u001a\u0002062\f\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000?2\u0006\u0010K\u001a\u00020\u000b2\u000e\u0010[\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\\\u001a\u00020\u000b2\u0016\u0010F\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010T\u001a\u00020\u000b2\u000e\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010]J\u0016\u0010^\u001a\u00028\u00002\u0006\u0010K\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0002\u0010_J\u001d\u0010`\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010K\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010aJ\u0015\u0010b\u001a\u00028\u00002\u0006\u0010K\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010_J9\u0010c\u001a\u0004\u0018\u00010\b2\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010dJ=\u0010e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020QH\u0002¢\u0006\u0002\u0010gJ/\u0010h\u001a\u0002062\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010iJ?\u0010j\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020QH\u0002¢\u0006\u0002\u0010gJ\u0016\u0010k\u001a\u00020'2\f\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000?H\u0016J\u001a\u0010l\u001a\u00020'2\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020'0nJ\u001c\u0010k\u001a\u00020'2\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020'0nH\u0002J/\u0010o\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u001f\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010.J5\u0010p\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010K\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010qJ,\u0010r\u001a\u00020\u000b2\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020'0n2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020QH\u0002JA\u0010k\u001a\u00020\u000b2\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020'0n2\u000e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010t\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020QH\u0002¢\u0006\u0002\u0010uJu\u0010v\u001a\u00020\u000b2\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020'0n2\u000e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010t\u001a\u00020\u000b2\u0006\u0010w\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020Q2\u0014\u0010x\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070y2\u0014\u0010F\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070yH\u0002¢\u0006\u0002\u0010zJ\u001e\u0010{\u001a\u00028\u00002\u0006\u0010K\u001a\u00020\u000b2\u0006\u00100\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010|JE\u0010}\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\u000b2\u0006\u0010~\u001a\u00028\u00002\u0006\u0010\u007f\u001a\u00020QH\u0002¢\u0006\u0002\u0010RJ\u0011\u0010\u0080\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0081\u0001H\u0096\u0002J\u0010\u0010\u0082\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0083\u0001H\u0016J\u0018\u0010\u0082\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0083\u00012\u0006\u0010K\u001a\u00020\u000bH\u0016J \u0010\u0084\u0001\u001a\u0011\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0085\u00012\u0006\u0010K\u001a\u00020\u000bH\u0002R\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R:\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007@BX\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR6\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007@BX\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001e\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000f¨\u0006\u0086\u0001"}, d2 = {"Lkotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractMutableList;", "Lkotlinx/collections/immutable/PersistentList$Builder;", "vector", "Lkotlinx/collections/immutable/PersistentList;", "vectorRoot", "", "", "vectorTail", "rootShift", "", "<init>", "(Lkotlinx/collections/immutable/PersistentList;[Ljava/lang/Object;[Ljava/lang/Object;I)V", "getRootShift$kotlinx_collections_immutable", "()I", "setRootShift$kotlinx_collections_immutable", "(I)V", "builtVector", "ownership", "Lkotlinx/collections/immutable/internal/MutabilityOwnership;", "value", "root", "getRoot$kotlinx_collections_immutable", "()[Ljava/lang/Object;", "setRoot", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "tail", "getTail$kotlinx_collections_immutable", "setTail", "size", "getSize", "getModCount", "getModCount$kotlinx_collections_immutable", "build", "rootSize", "tailSize", "isMutable", "", "buffer", "([Ljava/lang/Object;)Z", "makeMutable", "([Ljava/lang/Object;)[Ljava/lang/Object;", "makeMutableShiftingRight", "distance", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "mutableBufferWith", "element", "(Ljava/lang/Object;)[Ljava/lang/Object;", "mutableBuffer", "add", "(Ljava/lang/Object;)Z", "pushFilledTail", "", "filledTail", "newTail", "([Ljava/lang/Object;[Ljava/lang/Object;[Ljava/lang/Object;)V", "pushTail", "shift", "([Ljava/lang/Object;[Ljava/lang/Object;I)[Ljava/lang/Object;", "addAll", "elements", "", "copyToBuffer", "bufferIndex", "sourceIterator", "", "([Ljava/lang/Object;ILjava/util/Iterator;)[Ljava/lang/Object;", "pushBuffersIncreasingHeightIfNeeded", "buffers", "([Ljava/lang/Object;I[[Ljava/lang/Object;)[Ljava/lang/Object;", "pushBuffers", "buffersIterator", "([Ljava/lang/Object;IILjava/util/Iterator;)[Ljava/lang/Object;", FirebaseAnalytics.Param.INDEX, "(ILjava/lang/Object;)V", "insertIntoTail", "([Ljava/lang/Object;ILjava/lang/Object;)V", "insertIntoRoot", "elementCarry", "Lkotlinx/collections/immutable/implementations/immutableList/ObjectRef;", "([Ljava/lang/Object;IILjava/lang/Object;Lkotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "rightShift", "nullBuffers", "nextBuffer", "(Ljava/util/Collection;II[[Ljava/lang/Object;I[Ljava/lang/Object;)V", "shiftLeafBuffers", "startLeafIndex", "(II[[Ljava/lang/Object;I[Ljava/lang/Object;)[Ljava/lang/Object;", "splitToBuffers", "startBuffer", "startBufferSize", "(Ljava/util/Collection;I[Ljava/lang/Object;I[[Ljava/lang/Object;I[Ljava/lang/Object;)V", "get", "(I)Ljava/lang/Object;", "bufferFor", "(I)[Ljava/lang/Object;", "removeAt", "removeFromTailAt", "([Ljava/lang/Object;III)Ljava/lang/Object;", "removeFromRootAt", "tailCarry", "([Ljava/lang/Object;IILkotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "pullLastBufferFromRoot", "([Ljava/lang/Object;II)V", "pullLastBuffer", "removeAll", "removeAllWithPredicate", "predicate", "Lkotlin/Function1;", "retainFirst", "nullifyAfter", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "removeAllFromTail", "bufferRef", "bufferSize", "(Lkotlin/jvm/functions/Function1;[Ljava/lang/Object;ILkotlinx/collections/immutable/implementations/immutableList/ObjectRef;)I", "recyclableRemoveAll", "toBufferSize", "recyclableBuffers", "", "(Lkotlin/jvm/functions/Function1;[Ljava/lang/Object;IILkotlinx/collections/immutable/implementations/immutableList/ObjectRef;Ljava/util/List;Ljava/util/List;)I", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "setInRoot", "e", "oldElementCarry", "iterator", "", "listIterator", "", "leafBufferIterator", "", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PersistentVectorBuilder<E> extends AbstractMutableList<E> implements PersistentList.Builder<E> {
    private PersistentList<? extends E> builtVector;
    private MutabilityOwnership ownership;
    private Object[] root;
    private int rootShift;
    private int size;
    private Object[] tail;

    public PersistentVectorBuilder(PersistentList<? extends E> vector, Object[] objArr, Object[] vectorTail, int i) {
        Intrinsics.checkNotNullParameter(vector, "vector");
        Intrinsics.checkNotNullParameter(vectorTail, "vectorTail");
        this.rootShift = i;
        this.builtVector = vector;
        this.ownership = new MutabilityOwnership();
        this.root = objArr;
        this.tail = vectorTail;
        this.size = vector.size();
    }

    public final int getRootShift$kotlinx_collections_immutable() {
        return this.rootShift;
    }

    public final void setRootShift$kotlinx_collections_immutable(int i) {
        this.rootShift = i;
    }

    public final Object[] getRoot$kotlinx_collections_immutable() {
        return this.root;
    }

    private final void setRoot(Object[] objArr) {
        if (objArr != this.root) {
            this.builtVector = null;
            this.root = objArr;
        }
    }

    public final Object[] getTail$kotlinx_collections_immutable() {
        return this.tail;
    }

    private final void setTail(Object[] objArr) {
        if (objArr != this.tail) {
            this.builtVector = null;
            this.tail = objArr;
        }
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.size;
    }

    public final int getModCount$kotlinx_collections_immutable() {
        return this.modCount;
    }

    @Override // kotlinx.collections.immutable.PersistentCollection.Builder
    public PersistentList<E> build() {
        PersistentVector persistentVector = this.builtVector;
        if (persistentVector == null) {
            Object[] objArr = this.root;
            Object[] objArr2 = this.tail;
            this.ownership = new MutabilityOwnership();
            if (objArr == null) {
                if (objArr2.length == 0) {
                    persistentVector = UtilsKt.persistentVectorOf();
                } else {
                    Object[] copyOf = Arrays.copyOf(objArr2, size());
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                    persistentVector = new SmallPersistentVector(copyOf);
                }
            } else {
                persistentVector = new PersistentVector(objArr, objArr2, size(), this.rootShift);
            }
            this.builtVector = persistentVector;
        }
        return (PersistentList<E>) persistentVector;
    }

    private final int rootSize() {
        if (size() <= 32) {
            return 0;
        }
        return UtilsKt.rootSize(size());
    }

    private final int tailSize(int i) {
        return i <= 32 ? i : i - UtilsKt.rootSize(i);
    }

    private final int tailSize() {
        return tailSize(size());
    }

    private final boolean isMutable(Object[] objArr) {
        return objArr.length == 33 && objArr[32] == this.ownership;
    }

    private final Object[] makeMutable(Object[] objArr) {
        if (objArr == null) {
            return mutableBuffer();
        }
        return isMutable(objArr) ? objArr : ArraysKt.copyInto$default(objArr, mutableBuffer(), 0, 0, RangesKt.coerceAtMost(objArr.length, 32), 6, (Object) null);
    }

    private final Object[] makeMutableShiftingRight(Object[] objArr, int i) {
        if (isMutable(objArr)) {
            return ArraysKt.copyInto(objArr, objArr, i, 0, 32 - i);
        }
        return ArraysKt.copyInto(objArr, mutableBuffer(), i, 0, 32 - i);
    }

    private final Object[] mutableBufferWith(Object obj) {
        Object[] objArr = new Object[33];
        objArr[0] = obj;
        objArr[32] = this.ownership;
        return objArr;
    }

    private final Object[] mutableBuffer() {
        Object[] objArr = new Object[33];
        objArr[32] = this.ownership;
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e) {
        this.modCount++;
        int tailSize = tailSize();
        if (tailSize < 32) {
            Object[] makeMutable = makeMutable(this.tail);
            makeMutable[tailSize] = e;
            setTail(makeMutable);
            this.size = size() + 1;
        } else {
            pushFilledTail(this.root, this.tail, mutableBufferWith(e));
        }
        return true;
    }

    private final void pushFilledTail(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int size = size() >> 5;
        int i = this.rootShift;
        if (size > (1 << i)) {
            setRoot(pushTail(mutableBufferWith(objArr), objArr2, this.rootShift + 5));
            setTail(objArr3);
            this.rootShift += 5;
            this.size = size() + 1;
        } else if (objArr == null) {
            setRoot(objArr2);
            setTail(objArr3);
            this.size = size() + 1;
        } else {
            setRoot(pushTail(objArr, objArr2, i));
            setTail(objArr3);
            this.size = size() + 1;
        }
    }

    private final Object[] pushTail(Object[] objArr, Object[] objArr2, int i) {
        int indexSegment = UtilsKt.indexSegment(size() - 1, i);
        Object[] makeMutable = makeMutable(objArr);
        if (i == 5) {
            makeMutable[indexSegment] = objArr2;
            return makeMutable;
        }
        makeMutable[indexSegment] = pushTail((Object[]) makeMutable[indexSegment], objArr2, i - 5);
        return makeMutable;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        this.modCount++;
        int tailSize = tailSize();
        Iterator<? extends E> it = elements.iterator();
        if (32 - tailSize >= elements.size()) {
            setTail(copyToBuffer(makeMutable(this.tail), tailSize, it));
            this.size = size() + elements.size();
        } else {
            int size = ((elements.size() + tailSize) - 1) / 32;
            Object[][] objArr = new Object[size];
            objArr[0] = copyToBuffer(makeMutable(this.tail), tailSize, it);
            for (int i = 1; i < size; i++) {
                objArr[i] = copyToBuffer(mutableBuffer(), 0, it);
            }
            setRoot(pushBuffersIncreasingHeightIfNeeded(this.root, rootSize(), objArr));
            setTail(copyToBuffer(mutableBuffer(), 0, it));
            this.size = size() + elements.size();
        }
        return true;
    }

    private final Object[] copyToBuffer(Object[] objArr, int i, Iterator<? extends Object> it) {
        while (i < 32 && it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return objArr;
    }

    private final Object[] pushBuffersIncreasingHeightIfNeeded(Object[] objArr, int i, Object[][] objArr2) {
        Object[] makeMutable;
        Iterator<Object[]> it = ArrayIteratorKt.iterator(objArr2);
        int i2 = i >> 5;
        int i3 = this.rootShift;
        if (i2 < (1 << i3)) {
            makeMutable = pushBuffers(objArr, i, i3, it);
        } else {
            makeMutable = makeMutable(objArr);
        }
        while (it.hasNext()) {
            this.rootShift += 5;
            makeMutable = mutableBufferWith(makeMutable);
            int i4 = this.rootShift;
            pushBuffers(makeMutable, 1 << i4, i4, it);
        }
        return makeMutable;
    }

    private final Object[] pushBuffers(Object[] objArr, int i, int i2, Iterator<Object[]> it) {
        if (it.hasNext()) {
            if (i2 >= 0) {
                if (i2 == 0) {
                    return it.next();
                }
                Object[] makeMutable = makeMutable(objArr);
                int indexSegment = UtilsKt.indexSegment(i, i2);
                int i3 = i2 - 5;
                makeMutable[indexSegment] = pushBuffers((Object[]) makeMutable[indexSegment], i, i3, it);
                while (true) {
                    indexSegment++;
                    if (indexSegment >= 32 || !it.hasNext()) {
                        break;
                    }
                    makeMutable[indexSegment] = pushBuffers((Object[]) makeMutable[indexSegment], 0, i3, it);
                }
                return makeMutable;
            }
            throw new IllegalStateException("Check failed.");
        }
        throw new IllegalStateException("Check failed.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        ListImplementation.checkPositionIndex$kotlinx_collections_immutable(i, size());
        if (i == size()) {
            add(e);
            return;
        }
        this.modCount++;
        int rootSize = rootSize();
        if (i >= rootSize) {
            insertIntoTail(this.root, i - rootSize, e);
            return;
        }
        ObjectRef objectRef = new ObjectRef(null);
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        insertIntoTail(insertIntoRoot(objArr, this.rootShift, i, e, objectRef), 0, objectRef.getValue());
    }

    private final void insertIntoTail(Object[] objArr, int i, E e) {
        int tailSize = tailSize();
        Object[] makeMutable = makeMutable(this.tail);
        if (tailSize < 32) {
            ArraysKt.copyInto(this.tail, makeMutable, i + 1, i, tailSize);
            makeMutable[i] = e;
            setRoot(objArr);
            setTail(makeMutable);
            this.size = size() + 1;
            return;
        }
        Object[] objArr2 = this.tail;
        Object obj = objArr2[31];
        ArraysKt.copyInto(objArr2, makeMutable, i + 1, i, 31);
        makeMutable[i] = e;
        pushFilledTail(objArr, makeMutable, mutableBufferWith(obj));
    }

    private final Object[] insertIntoRoot(Object[] objArr, int i, int i2, Object obj, ObjectRef objectRef) {
        Object obj2;
        int indexSegment = UtilsKt.indexSegment(i2, i);
        if (i == 0) {
            objectRef.setValue(objArr[31]);
            Object[] copyInto = ArraysKt.copyInto(objArr, makeMutable(objArr), indexSegment + 1, indexSegment, 31);
            copyInto[indexSegment] = obj;
            return copyInto;
        }
        Object[] makeMutable = makeMutable(objArr);
        int i3 = i - 5;
        Object obj3 = makeMutable[indexSegment];
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        makeMutable[indexSegment] = insertIntoRoot((Object[]) obj3, i3, i2, obj, objectRef);
        while (true) {
            indexSegment++;
            if (indexSegment >= 32 || (obj2 = makeMutable[indexSegment]) == null) {
                break;
            }
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            makeMutable[indexSegment] = insertIntoRoot((Object[]) obj2, i3, 0, objectRef.getValue(), objectRef);
        }
        return makeMutable;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends E> elements) {
        PersistentVectorBuilder<E> persistentVectorBuilder;
        Collection<? extends E> collection;
        Object[] copyInto;
        Object[][] objArr;
        Intrinsics.checkNotNullParameter(elements, "elements");
        ListImplementation.checkPositionIndex$kotlinx_collections_immutable(i, size());
        if (i == size()) {
            return addAll(elements);
        }
        if (elements.isEmpty()) {
            return false;
        }
        this.modCount++;
        int i2 = (i >> 5) << 5;
        int size = (((size() - i2) + elements.size()) - 1) / 32;
        if (size == 0) {
            CommonFunctionsKt.m9966assert(i >= rootSize());
            int i3 = i & 31;
            Object[] objArr2 = this.tail;
            Object[] copyInto2 = ArraysKt.copyInto(objArr2, makeMutable(objArr2), (((i + elements.size()) - 1) & 31) + 1, i3, tailSize());
            copyToBuffer(copyInto2, i3, elements.iterator());
            setTail(copyInto2);
            this.size = size() + elements.size();
            return true;
        }
        Object[][] objArr3 = new Object[size];
        int tailSize = tailSize();
        int tailSize2 = tailSize(size() + elements.size());
        if (i >= rootSize()) {
            copyInto = mutableBuffer();
            objArr = objArr3;
            persistentVectorBuilder = this;
            collection = elements;
            persistentVectorBuilder.splitToBuffers(collection, i, this.tail, tailSize, objArr, size, copyInto);
        } else {
            persistentVectorBuilder = this;
            collection = elements;
            if (tailSize2 > tailSize) {
                int i4 = tailSize2 - tailSize;
                Object[] makeMutableShiftingRight = makeMutableShiftingRight(persistentVectorBuilder.tail, i4);
                persistentVectorBuilder.insertIntoRoot(collection, i, i4, objArr3, size, makeMutableShiftingRight);
                objArr = objArr3;
                copyInto = makeMutableShiftingRight;
            } else {
                int i5 = tailSize - tailSize2;
                copyInto = ArraysKt.copyInto(persistentVectorBuilder.tail, mutableBuffer(), 0, i5, tailSize);
                int i6 = 32 - i5;
                Object[] makeMutableShiftingRight2 = makeMutableShiftingRight(persistentVectorBuilder.tail, i6);
                int i7 = size - 1;
                objArr3[i7] = makeMutableShiftingRight2;
                persistentVectorBuilder.insertIntoRoot(collection, i, i6, objArr3, i7, makeMutableShiftingRight2);
                collection = collection;
                objArr = objArr3;
                persistentVectorBuilder = persistentVectorBuilder;
            }
        }
        setRoot(pushBuffersIncreasingHeightIfNeeded(persistentVectorBuilder.root, i2, objArr));
        setTail(copyInto);
        persistentVectorBuilder.size = size() + collection.size();
        return true;
    }

    private final void insertIntoRoot(Collection<? extends E> collection, int i, int i2, Object[][] objArr, int i3, Object[] objArr2) {
        Object[] objArr3;
        if (this.root == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        int i4 = i >> 5;
        Object[] shiftLeafBuffers = shiftLeafBuffers(i4, i2, objArr, i3, objArr2);
        int rootSize = i3 - (((rootSize() >> 5) - 1) - i4);
        if (rootSize < i3) {
            Object[] objArr4 = objArr[rootSize];
            Intrinsics.checkNotNull(objArr4);
            objArr3 = objArr4;
        } else {
            objArr3 = objArr2;
        }
        splitToBuffers(collection, i, shiftLeafBuffers, 32, objArr, rootSize, objArr3);
    }

    private final Object[] shiftLeafBuffers(int i, int i2, Object[][] objArr, int i3, Object[] objArr2) {
        if (this.root == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        ListIterator<Object[]> leafBufferIterator = leafBufferIterator(rootSize() >> 5);
        while (leafBufferIterator.previousIndex() != i) {
            Object[] previous = leafBufferIterator.previous();
            ArraysKt.copyInto(previous, objArr2, 0, 32 - i2, 32);
            objArr2 = makeMutableShiftingRight(previous, i2);
            i3--;
            objArr[i3] = objArr2;
        }
        return leafBufferIterator.previous();
    }

    private final void splitToBuffers(Collection<? extends E> collection, int i, Object[] objArr, int i2, Object[][] objArr2, int i3, Object[] objArr3) {
        Object[] mutableBuffer;
        if (i3 < 1) {
            throw new IllegalStateException("Check failed.");
        }
        Object[] makeMutable = makeMutable(objArr);
        objArr2[0] = makeMutable;
        int i4 = i & 31;
        int size = ((i + collection.size()) - 1) & 31;
        int i5 = (i2 - i4) + size;
        if (i5 < 32) {
            ArraysKt.copyInto(makeMutable, objArr3, size + 1, i4, i2);
        } else {
            int i6 = i5 - 31;
            if (i3 == 1) {
                mutableBuffer = makeMutable;
            } else {
                mutableBuffer = mutableBuffer();
                i3--;
                objArr2[i3] = mutableBuffer;
            }
            int i7 = i2 - i6;
            ArraysKt.copyInto(makeMutable, objArr3, 0, i7, i2);
            ArraysKt.copyInto(makeMutable, mutableBuffer, size + 1, i4, i7);
            objArr3 = mutableBuffer;
        }
        Iterator<? extends E> it = collection.iterator();
        copyToBuffer(makeMutable, i4, it);
        for (int i8 = 1; i8 < i3; i8++) {
            objArr2[i8] = copyToBuffer(mutableBuffer(), 0, it);
        }
        copyToBuffer(objArr3, 0, it);
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        ListImplementation.checkElementIndex$kotlinx_collections_immutable(i, size());
        return (E) bufferFor(i)[i & 31];
    }

    private final Object[] bufferFor(int i) {
        if (rootSize() <= i) {
            return this.tail;
        }
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        for (int i2 = this.rootShift; i2 > 0; i2 -= 5) {
            Object[] objArr2 = objArr[UtilsKt.indexSegment(i, i2)];
            Intrinsics.checkNotNull(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr = objArr2;
        }
        return objArr;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int i) {
        ListImplementation.checkElementIndex$kotlinx_collections_immutable(i, size());
        this.modCount++;
        int rootSize = rootSize();
        if (i >= rootSize) {
            return (E) removeFromTailAt(this.root, rootSize, this.rootShift, i - rootSize);
        }
        ObjectRef objectRef = new ObjectRef(this.tail[0]);
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        removeFromTailAt(removeFromRootAt(objArr, this.rootShift, i, objectRef), rootSize, this.rootShift, 0);
        return (E) objectRef.getValue();
    }

    private final Object removeFromTailAt(Object[] objArr, int i, int i2, int i3) {
        int size = size() - i;
        CommonFunctionsKt.m9966assert(i3 < size);
        if (size == 1) {
            Object obj = this.tail[0];
            pullLastBufferFromRoot(objArr, i, i2);
            return obj;
        }
        Object[] objArr2 = this.tail;
        Object obj2 = objArr2[i3];
        Object[] copyInto = ArraysKt.copyInto(objArr2, makeMutable(objArr2), i3, i3 + 1, size);
        copyInto[size - 1] = null;
        setRoot(objArr);
        setTail(copyInto);
        this.size = (i + size) - 1;
        this.rootShift = i2;
        return obj2;
    }

    private final Object[] removeFromRootAt(Object[] objArr, int i, int i2, ObjectRef objectRef) {
        int indexSegment = UtilsKt.indexSegment(i2, i);
        if (i == 0) {
            Object obj = objArr[indexSegment];
            Object[] copyInto = ArraysKt.copyInto(objArr, makeMutable(objArr), indexSegment, indexSegment + 1, 32);
            copyInto[31] = objectRef.getValue();
            objectRef.setValue(obj);
            return copyInto;
        }
        int indexSegment2 = objArr[31] == null ? UtilsKt.indexSegment(rootSize() - 1, i) : 31;
        Object[] makeMutable = makeMutable(objArr);
        int i3 = i - 5;
        int i4 = indexSegment + 1;
        if (i4 <= indexSegment2) {
            while (true) {
                Object obj2 = makeMutable[indexSegment2];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                makeMutable[indexSegment2] = removeFromRootAt((Object[]) obj2, i3, 0, objectRef);
                if (indexSegment2 == i4) {
                    break;
                }
                indexSegment2--;
            }
        }
        Object obj3 = makeMutable[indexSegment];
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        makeMutable[indexSegment] = removeFromRootAt((Object[]) obj3, i3, i2, objectRef);
        return makeMutable;
    }

    private final void pullLastBufferFromRoot(Object[] objArr, int i, int i2) {
        if (i2 == 0) {
            setRoot(null);
            if (objArr == null) {
                objArr = new Object[0];
            }
            setTail(objArr);
            this.size = i;
            this.rootShift = i2;
            return;
        }
        ObjectRef objectRef = new ObjectRef(null);
        Intrinsics.checkNotNull(objArr);
        Object[] pullLastBuffer = pullLastBuffer(objArr, i2, i, objectRef);
        Intrinsics.checkNotNull(pullLastBuffer);
        Object value = objectRef.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        setTail((Object[]) value);
        this.size = i;
        if (pullLastBuffer[1] == null) {
            setRoot((Object[]) pullLastBuffer[0]);
            this.rootShift = i2 - 5;
            return;
        }
        setRoot(pullLastBuffer);
        this.rootShift = i2;
    }

    private final Object[] pullLastBuffer(Object[] objArr, int i, int i2, ObjectRef objectRef) {
        Object[] pullLastBuffer;
        int indexSegment = UtilsKt.indexSegment(i2 - 1, i);
        if (i == 5) {
            objectRef.setValue(objArr[indexSegment]);
            pullLastBuffer = null;
        } else {
            Object obj = objArr[indexSegment];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            pullLastBuffer = pullLastBuffer((Object[]) obj, i - 5, i2, objectRef);
        }
        if (pullLastBuffer == null && indexSegment == 0) {
            return null;
        }
        Object[] makeMutable = makeMutable(objArr);
        makeMutable[indexSegment] = pullLastBuffer;
        return makeMutable;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(final Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        return removeAllWithPredicate(new Function1() { // from class: kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean contains;
                contains = elements.contains(obj);
                return Boolean.valueOf(contains);
            }
        });
    }

    public final boolean removeAllWithPredicate(Function1<? super E, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean removeAll = removeAll(predicate);
        if (removeAll) {
            this.modCount++;
        }
        return removeAll;
    }

    private final boolean removeAll(Function1<? super E, Boolean> function1) {
        Object[] pushBuffers;
        int tailSize = tailSize();
        ObjectRef objectRef = new ObjectRef(null);
        if (this.root == null) {
            return removeAllFromTail(function1, tailSize, objectRef) != tailSize;
        }
        ListIterator<Object[]> leafBufferIterator = leafBufferIterator(0);
        int i = 32;
        while (i == 32 && leafBufferIterator.hasNext()) {
            i = removeAll(function1, leafBufferIterator.next(), 32, objectRef);
        }
        if (i == 32) {
            CommonFunctionsKt.m9966assert(!leafBufferIterator.hasNext());
            int removeAllFromTail = removeAllFromTail(function1, tailSize, objectRef);
            if (removeAllFromTail == 0) {
                pullLastBufferFromRoot(this.root, size(), this.rootShift);
            }
            return removeAllFromTail != tailSize;
        }
        int previousIndex = leafBufferIterator.previousIndex() << 5;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = i;
        while (leafBufferIterator.hasNext()) {
            i2 = recyclableRemoveAll(function1, leafBufferIterator.next(), 32, i2, objectRef, arrayList2, arrayList);
        }
        int recyclableRemoveAll = recyclableRemoveAll(function1, this.tail, tailSize, i2, objectRef, arrayList2, arrayList);
        Object value = objectRef.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr = (Object[]) value;
        ArraysKt.fill(objArr, (Object) null, recyclableRemoveAll, 32);
        if (arrayList.isEmpty()) {
            pushBuffers = this.root;
            Intrinsics.checkNotNull(pushBuffers);
        } else {
            pushBuffers = pushBuffers(this.root, previousIndex, this.rootShift, arrayList.iterator());
        }
        int size = previousIndex + (arrayList.size() << 5);
        setRoot(retainFirst(pushBuffers, size));
        setTail(objArr);
        this.size = size + recyclableRemoveAll;
        return true;
    }

    private final Object[] retainFirst(Object[] objArr, int i) {
        if ((i & 31) != 0) {
            throw new IllegalStateException("Check failed.");
        }
        if (i == 0) {
            this.rootShift = 0;
            return null;
        }
        int i2 = i - 1;
        while (true) {
            int i3 = this.rootShift;
            if ((i2 >> i3) == 0) {
                this.rootShift = i3 - 5;
                Object[] objArr2 = objArr[0];
                Intrinsics.checkNotNull(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                objArr = objArr2;
            } else {
                return nullifyAfter(objArr, i2, i3);
            }
        }
    }

    private final Object[] nullifyAfter(Object[] objArr, int i, int i2) {
        if (i2 >= 0) {
            if (i2 == 0) {
                return objArr;
            }
            int indexSegment = UtilsKt.indexSegment(i, i2);
            Object obj = objArr[indexSegment];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            Object nullifyAfter = nullifyAfter((Object[]) obj, i, i2 - 5);
            if (indexSegment < 31) {
                int i3 = indexSegment + 1;
                if (objArr[i3] != null) {
                    if (isMutable(objArr)) {
                        ArraysKt.fill(objArr, (Object) null, i3, 32);
                    }
                    objArr = ArraysKt.copyInto(objArr, mutableBuffer(), 0, 0, i3);
                }
            }
            if (nullifyAfter != objArr[indexSegment]) {
                Object[] makeMutable = makeMutable(objArr);
                makeMutable[indexSegment] = nullifyAfter;
                return makeMutable;
            }
            return objArr;
        }
        throw new IllegalStateException("Check failed.");
    }

    private final int removeAllFromTail(Function1<? super E, Boolean> function1, int i, ObjectRef objectRef) {
        int removeAll = removeAll(function1, this.tail, i, objectRef);
        if (removeAll == i) {
            CommonFunctionsKt.m9966assert(objectRef.getValue() == this.tail);
            return i;
        }
        Object value = objectRef.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr = (Object[]) value;
        ArraysKt.fill(objArr, (Object) null, removeAll, i);
        setTail(objArr);
        this.size = size() - (i - removeAll);
        return removeAll;
    }

    private final int removeAll(Function1<? super E, Boolean> function1, Object[] objArr, int i, ObjectRef objectRef) {
        Object[] objArr2 = objArr;
        int i2 = i;
        boolean z = false;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (function1.invoke(obj).booleanValue()) {
                if (!z) {
                    objArr2 = makeMutable(objArr);
                    z = true;
                    i2 = i3;
                }
            } else if (z) {
                objArr2[i2] = obj;
                i2++;
            }
        }
        objectRef.setValue(objArr2);
        return i2;
    }

    private final int recyclableRemoveAll(Function1<? super E, Boolean> function1, Object[] objArr, int i, int i2, ObjectRef objectRef, List<Object[]> list, List<Object[]> list2) {
        Object[] mutableBuffer;
        if (isMutable(objArr)) {
            list.add(objArr);
        }
        Object value = objectRef.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr2 = (Object[]) value;
        Object[] objArr3 = objArr2;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (!function1.invoke(obj).booleanValue()) {
                if (i2 == 32) {
                    if (!list.isEmpty()) {
                        mutableBuffer = list.remove(list.size() - 1);
                    } else {
                        mutableBuffer = mutableBuffer();
                    }
                    objArr3 = mutableBuffer;
                    i2 = 0;
                }
                objArr3[i2] = obj;
                i2++;
            }
        }
        objectRef.setValue(objArr3);
        if (objArr2 != objectRef.getValue()) {
            list2.add(objArr2);
        }
        return i2;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        ListImplementation.checkElementIndex$kotlinx_collections_immutable(i, size());
        if (rootSize() <= i) {
            Object[] makeMutable = makeMutable(this.tail);
            if (makeMutable != this.tail) {
                this.modCount++;
            }
            int i2 = i & 31;
            E e2 = (E) makeMutable[i2];
            makeMutable[i2] = e;
            setTail(makeMutable);
            return e2;
        }
        ObjectRef objectRef = new ObjectRef(null);
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        setRoot(setInRoot(objArr, this.rootShift, i, e, objectRef));
        return (E) objectRef.getValue();
    }

    private final Object[] setInRoot(Object[] objArr, int i, int i2, E e, ObjectRef objectRef) {
        int indexSegment = UtilsKt.indexSegment(i2, i);
        Object[] makeMutable = makeMutable(objArr);
        if (i == 0) {
            if (makeMutable != objArr) {
                this.modCount++;
            }
            objectRef.setValue(makeMutable[indexSegment]);
            makeMutable[indexSegment] = e;
            return makeMutable;
        }
        Object obj = makeMutable[indexSegment];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        makeMutable[indexSegment] = setInRoot((Object[]) obj, i - 5, i2, e, objectRef);
        return makeMutable;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i) {
        ListImplementation.checkPositionIndex$kotlinx_collections_immutable(i, size());
        return new PersistentVectorMutableIterator(this, i);
    }

    private final ListIterator<Object[]> leafBufferIterator(int i) {
        if (this.root == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        int rootSize = rootSize() >> 5;
        ListImplementation.checkPositionIndex$kotlinx_collections_immutable(i, rootSize);
        int i2 = this.rootShift;
        if (i2 == 0) {
            Object[] objArr = this.root;
            Intrinsics.checkNotNull(objArr);
            return new SingleElementListIterator(objArr, i);
        }
        Object[] objArr2 = this.root;
        Intrinsics.checkNotNull(objArr2);
        return new TrieIterator(objArr2, i, rootSize, i2 / 5);
    }
}
