package androidx.datastore.core;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
/* compiled from: StorageConnection.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002JX\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0001\u0010\u00042B\u0010\u0005\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0006¢\u0006\u0002\b\u000eH¦@¢\u0006\u0002\u0010\u000fJ=\u0010\u0010\u001a\u00020\u00112-\u0010\u0005\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0012¢\u0006\u0002\b\u000eH¦@¢\u0006\u0002\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0001"}, d2 = {"Landroidx/datastore/core/StorageConnection;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/Closeable;", "readScope", "R", "block", "Lkotlin/Function3;", "Landroidx/datastore/core/ReadScope;", "", "Lkotlin/ParameterName;", "name", "locked", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeScope", "", "Lkotlin/Function2;", "Landroidx/datastore/core/WriteScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coordinator", "Landroidx/datastore/core/InterProcessCoordinator;", "getCoordinator", "()Landroidx/datastore/core/InterProcessCoordinator;", "datastore-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface StorageConnection<T> extends Closeable {
    InterProcessCoordinator getCoordinator();

    <R> Object readScope(Function3<? super ReadScope<T>, ? super Boolean, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation);

    Object writeScope(Function2<? super WriteScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation);
}
